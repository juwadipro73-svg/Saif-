package com.example.builder.agent

import com.example.builder.safety.VersionManager
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import java.io.File

/**
 * Plain JVM tests for stack routing: an explicit native / flutter ask must produce that
 * stack end to end (detect -> plan -> assemble -> verify -> commit), never forced HTML.
 * Also guards the no-cap output budget (high auto-continue ceiling).
 */
class BuildStackUnitTest {

    @get:Rule
    val tmp = TemporaryFolder()

    private fun richSpec(): AppSpec = AppSpec(
        appName = "StackApp",
        vision = "A stack-routed app",
        archetype = "app",
        targetUser = "Mobile User",
        features = (1..6).map { i ->
            FeatureSpec(id = "feat_$i", title = "Feature $i", priority = "MUST", acceptance = "works", domProbes = emptyList())
        },
        screens = listOf("home", "game", "stats", "settings"),
        dataModel = "Store",
        designSystem = DesignTokens("dark", "#8B5CF6", "#38BDF8", "#0A0D14", "#131826", "#F1F5F9"),
        animationList = emptyList()
    )

    // ------------------------------------------------------------------
    // Stack detection
    // ------------------------------------------------------------------

    @Test
    fun `native asks route to NATIVE`() {
        assertEquals(BuildStack.NATIVE, BuildAgent.detectBuildStack("make me a native android app for notes"))
        assertEquals(BuildStack.NATIVE, BuildAgent.detectBuildStack("java me calculator banao"))
        assertEquals(BuildStack.NATIVE, BuildAgent.detectBuildStack("build a kotlin music player"))
        assertEquals(BuildStack.NATIVE, BuildAgent.detectBuildStack("compile to apk with android studio project"))
        assertEquals(BuildStack.NATIVE, BuildAgent.detectBuildStack("native-java todo with manifest and MainActivity"))
    }

    @Test
    fun `flutter asks route to FLUTTER`() {
        assertEquals(BuildStack.FLUTTER, BuildAgent.detectBuildStack("flutter me chat app banao"))
        assertEquals(BuildStack.FLUTTER, BuildAgent.detectBuildStack("build a dart todo with pubspec and widgets"))
        assertEquals(BuildStack.FLUTTER, BuildAgent.detectBuildStack("make a statefulwidget counter"))
    }

    @Test
    fun `plain asks stay on HTML`() {
        assertEquals(BuildStack.HTML, BuildAgent.detectBuildStack("game banao"))
        assertEquals(BuildStack.HTML, BuildAgent.detectBuildStack("make a beautiful todo app"))
        assertEquals(BuildStack.HTML, BuildAgent.detectBuildStack("html webview dashboard"))
    }

    @Test
    fun `when both stacks named the first one wins`() {
        assertEquals(BuildStack.NATIVE, BuildAgent.detectBuildStack("java native app please, not flutter"))
        assertEquals(BuildStack.FLUTTER, BuildAgent.detectBuildStack("flutter or native java — pick flutter"))
    }

    // ------------------------------------------------------------------
    // Task plans per stack
    // ------------------------------------------------------------------

    @Test
    fun `native full plan owns manifest main activity layouts and features`() {
        val tasks = BuildAgent.nativeFullTasksFor(richSpec())
        val files = tasks.flatMap { it.targetFiles }
        assertTrue(files.any { it.endsWith("AndroidManifest.xml") })
        assertTrue(files.any { it.endsWith("MainActivity.java") })
        assertTrue(files.any { it.endsWith("activity_main.xml") })
        assertTrue(files.any { it.endsWith("GameActivity.java") })
        assertTrue(files.any { it.contains("/features/") })
        assertTrue("all native files under src/native/", files.all { it.startsWith("src/native/") })
        assertTrue("plan capped", tasks.size <= 24)
    }

    @Test
    fun `flutter full plan owns pubspec main screens and features`() {
        val tasks = BuildAgent.flutterFullTasksFor(richSpec())
        val files = tasks.flatMap { it.targetFiles }
        assertTrue(files.any { it.endsWith("pubspec.yaml") })
        assertTrue(files.any { it.endsWith("lib/main.dart") })
        assertTrue(files.any { it.endsWith("game_screen.dart") })
        assertTrue(files.any { it.contains("/features/") })
        assertTrue("all flutter files under src/flutter/", files.all { it.startsWith("src/flutter/") })
        assertTrue("plan capped", tasks.size <= 24)
    }

    @Test
    fun `createTaskPlan routes new apps to the requested stack`() {
        val native = BuildAgent.createTaskPlan(richSpec(), false, BuildIntent.NEW_APP, "native app", emptySet(), BuildStack.NATIVE)
        assertTrue(native.flatMap { it.targetFiles }.all { it.startsWith("src/native/") })
        val flutter = BuildAgent.createTaskPlan(richSpec(), false, BuildIntent.NEW_APP, "flutter app", emptySet(), BuildStack.FLUTTER)
        assertTrue(flutter.flatMap { it.targetFiles }.all { it.startsWith("src/flutter/") })
        val html = BuildAgent.createTaskPlan(richSpec(), false, BuildIntent.NEW_APP, "game", emptySet(), BuildStack.HTML)
        assertTrue(html.flatMap { it.targetFiles }.none { it.startsWith("src/native/") || it.startsWith("src/flutter/") })
    }

    @Test
    fun `delta targets resolve inside the requested stack tree`() {
        assertEquals(
            "src/native/app/src/main/java/com/saifapp/app/MainActivity.java",
            BuildAgent.guessDeltaTarget("fix crash in MainActivity.java", BuildStack.NATIVE)
        )
        assertEquals(
            "src/native/app/src/main/AndroidManifest.xml",
            BuildAgent.guessDeltaTarget("add camera permission to manifest", BuildStack.NATIVE)
        )
        assertEquals(
            "src/flutter/pubspec.yaml",
            BuildAgent.guessDeltaTarget("bump version in pubspec", BuildStack.FLUTTER)
        )
        assertEquals(
            "src/flutter/lib/main.dart",
            BuildAgent.guessDeltaTarget("fix main.dart theme", BuildStack.FLUTTER)
        )
        val nativeDelta = BuildAgent.deltaTasksFor("change button text", emptySet(), BuildStack.NATIVE)
        assertTrue(nativeDelta.flatMap { it.targetFiles }.all { it.startsWith("src/native/") })
    }

    @Test
    fun `nativePathFor maps user named files into the native tree`() {
        assertEquals(
            "src/native/app/src/main/AndroidManifest.xml",
            BuildAgent.nativePathFor("AndroidManifest.xml")
        )
        assertEquals(
            "src/native/app/src/main/res/layout/activity_main.xml",
            BuildAgent.nativePathFor("res/layout/activity_main.xml")
        )
        assertEquals(
            "src/native/app/src/main/java/com/saifapp/app/SettingsActivity.java",
            BuildAgent.nativePathFor("SettingsActivity.java")
        )
    }

    // ------------------------------------------------------------------
    // Native assemble + verify
    // ------------------------------------------------------------------

    private fun nativeModules(): Map<String, String> {
        val manifest = """
            <?xml version="1.0" encoding="utf-8"?>
            <manifest xmlns:android="http://schemas.android.com/apk/res/android"
                package="com.saifapp.app">
                <application android:label="Demo">
                    <activity android:name=".MainActivity" android:exported="true">
                        <intent-filter>
                            <action android:name="android.intent.action.MAIN" />
                            <category android:name="android.intent.category.LAUNCHER" />
                        </intent-filter>
                    </activity>
                </application>
            </manifest>
        """.trimIndent()
        val main = """
            package com.saifapp.app;

            import android.app.Activity;
            import android.os.Bundle;

            public class MainActivity extends Activity {
                @Override
                protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.activity_main);
                }
            }
        """.trimIndent()
        val layout = """
            <?xml version="1.0" encoding="utf-8"?>
            <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
                android:layout_width="match_parent"
                android:layout_height="match_parent">
                <TextView android:id="@+id/title"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="@string/app_name" />
            </LinearLayout>
        """.trimIndent()
        val strings = """
            <?xml version="1.0" encoding="utf-8"?>
            <resources>
                <string name="app_name">Demo</string>
            </resources>
        """.trimIndent()
        return mapOf(
            "src/native/app/src/main/AndroidManifest.xml" to manifest,
            "src/native/app/src/main/java/com/saifapp/app/MainActivity.java" to main,
            "src/native/app/src/main/res/layout/activity_main.xml" to layout,
            "src/native/app/src/main/res/values/strings.xml" to strings
        )
    }

    @Test
    fun `native assemble relocates tree and rewrites package`() {
        val projectDir = tmp.newFolder("nativeApp")
        val assembly = NativeStack.assemble(projectDir, "com.example.demo", nativeModules())
        assertTrue("no errors: ${assembly.issues}", assembly.issues.none { it.severity == "ERROR" })
        val main = File(projectDir, "app/src/main/java/com/example/demo/MainActivity.java")
        assertTrue(main.isFile)
        assertTrue(main.readText().contains("package com.example.demo;"))
        val manifest = File(projectDir, "app/src/main/AndroidManifest.xml")
        assertTrue(manifest.readText().contains("package=\"com.example.demo\""))
        assertTrue(File(projectDir, "app/src/main/res/layout/activity_main.xml").isFile)
    }

    @Test
    fun `native assemble with no sources reports error`() {
        val projectDir = tmp.newFolder("nativeEmpty")
        val assembly = NativeStack.assemble(projectDir, "com.example.demo", emptyMap())
        assertTrue(assembly.issues.any { it.severity == "ERROR" })
    }

    @Test
    fun `native verify passes a complete tree`() {
        val projectDir = tmp.newFolder("nativeGood")
        NativeStack.assemble(projectDir, "com.example.demo", nativeModules())
        val report = NativeStack.verify(projectDir, "com.example.demo")
        assertTrue("expected pass, got: ${report.issues}", report.passed)
        assertTrue(report.totalCount > 0)
    }

    @Test
    fun `native verify fails without manifest`() {
        val projectDir = tmp.newFolder("nativeNoManifest")
        val report = NativeStack.verify(projectDir, "com.example.demo")
        assertFalse(report.passed)
        assertTrue(report.issues.any { it.message.contains("AndroidManifest") })
    }

    @Test
    fun `native verify fails when a declared activity has no source`() {
        val projectDir = tmp.newFolder("nativeGhost")
        val mods = nativeModules().toMutableMap()
        val withGhost = mods["src/native/app/src/main/AndroidManifest.xml"]!!.replace(
            "</application>",
            "<activity android:name=\".GhostActivity\" android:exported=\"false\" /></application>"
        )
        mods["src/native/app/src/main/AndroidManifest.xml"] = withGhost
        NativeStack.assemble(projectDir, "com.example.demo", mods)
        val report = NativeStack.verify(projectDir, "com.example.demo")
        assertFalse(report.passed)
        assertTrue(report.issues.any { it.message.contains("GhostActivity") })
    }

    // ------------------------------------------------------------------
    // Flutter assemble + verify
    // ------------------------------------------------------------------

    private fun flutterModules(): Map<String, String> {
        val pubspec = """
            name: demo
            version: 1.0.0
            environment:
              sdk: ">=3.0.0 <4.0.0"
            flutter:
              uses-material-design: true
        """.trimIndent()
        val main = """
            import 'package:flutter/material.dart';
            import 'screens/home_screen.dart';

            void main() => runApp(const DemoApp());

            class DemoApp extends StatelessWidget {
              const DemoApp({super.key});
              @override
              Widget build(BuildContext context) {
                return MaterialApp(home: HomeScreen());
              }
            }
        """.trimIndent()
        val home = """
            import 'package:flutter/material.dart';

            class HomeScreen extends StatelessWidget {
              const HomeScreen({super.key});
              @override
              Widget build(BuildContext context) {
                return Scaffold(body: Center(child: Text('hi')));
              }
            }
        """.trimIndent()
        return mapOf(
            "src/flutter/pubspec.yaml" to pubspec,
            "src/flutter/lib/main.dart" to main,
            "src/flutter/lib/screens/home_screen.dart" to home
        )
    }

    @Test
    fun `flutter assemble promotes tree writes guide and zips`() {
        val projectDir = tmp.newFolder("flutterApp")
        val assembly = FlutterStack.assemble(projectDir, "Demo", flutterModules(), cacheDir = null)
        assertTrue("no errors: ${assembly.issues}", assembly.issues.none { it.severity == "ERROR" })
        assertTrue(File(projectDir, "flutter_app/lib/main.dart").isFile)
        assertTrue(File(projectDir, "flutter_app/BUILD_GUIDE.md").isFile)
        assertEquals("flutter_app.zip", assembly.zipPath)
        assertTrue(File(projectDir, "flutter_app.zip").isFile)
    }

    @Test
    fun `flutter assemble with no sources reports error`() {
        val projectDir = tmp.newFolder("flutterEmpty")
        val assembly = FlutterStack.assemble(projectDir, "Demo", emptyMap(), cacheDir = null)
        assertTrue(assembly.issues.any { it.severity == "ERROR" })
    }

    @Test
    fun `flutter verify passes a complete project`() {
        val projectDir = tmp.newFolder("flutterGood")
        FlutterStack.assemble(projectDir, "Demo", flutterModules(), cacheDir = null)
        val report = FlutterStack.verify(projectDir)
        assertTrue("expected pass, got: ${report.issues}", report.passed)
    }

    @Test
    fun `flutter verify fails without entry point`() {
        val projectDir = tmp.newFolder("flutterNoMain")
        val report = FlutterStack.verify(projectDir)
        assertFalse(report.passed)
        assertTrue(report.issues.any { it.message.contains("main.dart") })
    }

    @Test
    fun `flutter verify fails on dangling imports`() {
        val projectDir = tmp.newFolder("flutterDangle")
        val mods = flutterModules().toMutableMap()
        mods["src/flutter/lib/main.dart"] = mods["src/flutter/lib/main.dart"]!! + "\nimport 'screens/missing.dart';\n"
        FlutterStack.assemble(projectDir, "Demo", mods, cacheDir = null)
        val report = FlutterStack.verify(projectDir)
        assertFalse(report.passed)
        assertTrue(report.issues.any { it.message.contains("missing.dart") })
    }

    @Test
    fun `dart balance check ignores strings and comments`() {
        assertEquals(null, FlutterStack.checkDartBalance("void f() { print('{'); // }\n/* } */ }"))
        assertTrue(FlutterStack.checkDartBalance("void f() { print('x'); ").toString().contains("unclosed"))
        assertTrue(FlutterStack.checkDartBalance("void f() { } }").toString().contains("unbalanced"))
    }

    @Test
    fun `build guide names the app and the apk command`() {
        val guide = FlutterStack.buildGuideText("DemoApp", listOf("flutter_app/lib/main.dart"))
        assertTrue(guide.contains("DemoApp"))
        assertTrue(guide.contains("flutter build apk"))
        assertTrue(guide.contains("flutter_app/lib/main.dart"))
    }

    // ------------------------------------------------------------------
    // Commits + budget guards
    // ------------------------------------------------------------------

    @Test
    fun `native and flutter commits archive versioned snapshots`() {
        val nativeDir = tmp.newFolder("commitNative")
        NativeStack.assemble(nativeDir, "com.example.demo", nativeModules())
        val nRes = VersionManager.commitNativeAtomic(nativeDir, "prompt", "summary", listOf("app/src/main/AndroidManifest.xml"), 5, 5)
        assertTrue(nRes.isSuccess)
        assertTrue(File(nativeDir, ".saif/versions/v0001/meta.json").isFile)
        assertTrue(File(nativeDir, ".saif/versions/v0001/app/src/main/AndroidManifest.xml").isFile)

        val flutterDir = tmp.newFolder("commitFlutter")
        FlutterStack.assemble(flutterDir, "Demo", flutterModules(), cacheDir = null)
        val fRes = VersionManager.commitFlutterAtomic(flutterDir, "prompt", "summary", listOf("flutter_app/lib/main.dart"), 5, 5)
        assertTrue(fRes.isSuccess)
        assertTrue(File(flutterDir, ".saif/versions/v0001/meta.json").isFile)
        assertTrue(File(flutterDir, ".saif/versions/v0001/flutter_app.zip").isFile)
    }

    @Test
    fun `auto continue ceiling stays high enough for big apps`() {
        assertTrue(BuildAgent.MAX_CONTINUATIONS >= 32)
        assertTrue(BuildAgent.CODER_MAX_OUTPUT_TOKENS >= 16384)
    }
}
