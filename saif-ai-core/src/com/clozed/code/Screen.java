package com.clozed.code;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: AppViewModel.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/clozed/code/Screen;", "", "<init>", "(Ljava/lang/String;I)V", "Connect", "Sessions", "Chat", "Settings", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class Screen {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Screen[] $VALUES;
    public static final Screen Connect = new Screen("Connect", 0);
    public static final Screen Sessions = new Screen("Sessions", 1);
    public static final Screen Chat = new Screen("Chat", 2);
    public static final Screen Settings = new Screen("Settings", 3);

    private static final /* synthetic */ Screen[] $values() {
        return new Screen[]{Connect, Sessions, Chat, Settings};
    }

    public static EnumEntries<Screen> getEntries() {
        return $ENTRIES;
    }

    static {
        Screen[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private Screen(String str, int i) {
    }

    public static Screen valueOf(String str) {
        return (Screen) Enum.valueOf(Screen.class, str);
    }

    public static Screen[] values() {
        return (Screen[]) $VALUES.clone();
    }
}
