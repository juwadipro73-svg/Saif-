package com.clozed.code.ui;

import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: FolderPicker.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"treeUriToPath", "", "uri", "Landroid/net/Uri;", "app_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class FolderPickerKt {
    public static final String treeUriToPath(Uri uri) {
        String treeDocumentId;
        int indexOf$default;
        Intrinsics.checkNotNullParameter(uri, "uri");
        try {
            treeDocumentId = DocumentsContract.getTreeDocumentId(uri);
            Intrinsics.checkNotNull(treeDocumentId);
            indexOf$default = StringsKt.indexOf$default((CharSequence) treeDocumentId, ':', 0, false, 6, (Object) null);
        } catch (Exception unused) {
        }
        if (indexOf$default < 0) {
            return null;
        }
        String substring = treeDocumentId.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        String substring2 = treeDocumentId.substring(indexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        String path = StringsKt.equals(substring, "primary", true) ? Environment.getExternalStorageDirectory().getPath() : "/storage/" + substring;
        if (substring2.length() != 0) {
            path = path + "/" + substring2;
        }
        if (new File(path).isDirectory()) {
            return path;
        }
        return null;
    }
}
