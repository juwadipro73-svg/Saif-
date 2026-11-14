package com.example.ui.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.SystemUpdate
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.local.AdminGlobalConfig

/**
 * Remote kill switch gate. When the admin flips the force-update switch, every non-admin
 * install is stopped at entry (even before login) and only sees this screen until the user
 * installs a new version. Admins always bypass it so they can switch it back off.
 */
object ForceUpdateGate {

    /**
     * Pure decision logic (unit-testable): true = block entry for this user on this build.
     */
    fun shouldBlock(
        config: AdminGlobalConfig,
        installedVersionCode: Long,
        isAdmin: Boolean
    ): Boolean {
        if (isAdmin) return false
        if (!config.forceUpdateActive) return false
        // Min code 0/negative = block every build while the switch is on.
        if (config.forceUpdateMinCode <= 0) return true
        return installedVersionCode < config.forceUpdateMinCode
    }

    fun installedVersionCode(context: Context): Long {
        return try {
            val info = context.packageManager.getPackageInfo(context.packageName, 0)
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
                info.longVersionCode
            } else {
                @Suppress("DEPRECATION")
                info.versionCode.toLong()
            }
        } catch (_: Exception) {
            0L
        }
    }

    fun openDownload(context: Context, url: String) {
        val clean = url.trim()
        if (clean.isEmpty()) {
            Toast.makeText(context, "Download link is not set yet. Please contact support.", Toast.LENGTH_LONG).show()
            return
        }
        try {
            val fixed = if (clean.startsWith("http://") || clean.startsWith("https://")) clean else "https://$clean"
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(fixed)).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            })
        } catch (_: Exception) {
            Toast.makeText(context, "Could not open the download link.", Toast.LENGTH_LONG).show()
        }
    }
}

@Composable
fun ForceUpdateGateScreen(
    downloadUrl: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFF151226), Color(0xFF1E1A38), Color(0xFF151226))
                )
            )
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Surface(
                shape = RoundedCornerShape(28.dp),
                color = Color(0xFF9B82EC).copy(alpha = 0.14f),
                modifier = Modifier.size(96.dp)
            ) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Icon(
                        imageVector = Icons.Outlined.SystemUpdate,
                        contentDescription = null,
                        tint = Color(0xFF9B82EC),
                        modifier = Modifier.size(52.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Please download new version",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "This version of SAIF AI has been stopped by the admin. Install the latest version to continue — your projects and chats stay safe.",
                fontSize = 14.sp,
                color = Color(0xFFB9B5C9),
                textAlign = TextAlign.Center,
                lineHeight = 20.sp
            )
            Spacer(modifier = Modifier.height(28.dp))
            Button(
                onClick = { ForceUpdateGate.openDownload(context, downloadUrl) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9B82EC)),
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Text(
                    text = "Click here to download",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}
