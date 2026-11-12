package com.clozed.code.ui;

import com.clozed.code.engine.CatProvider;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsScreen.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/clozed/code/ui/CustomEdit;", "", "existing", "Lcom/clozed/code/engine/CatProvider;", "<init>", "(Lcom/clozed/code/engine/CatProvider;)V", "getExisting", "()Lcom/clozed/code/engine/CatProvider;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class CustomEdit {
    private final CatProvider existing;

    public CustomEdit(CatProvider catProvider) {
        this.existing = catProvider;
    }

    public final CatProvider getExisting() {
        return this.existing;
    }
}
