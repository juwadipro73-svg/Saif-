package com.clozed.code;

import android.app.Application;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelKt;
import com.clozed.code.data.AgentOpt;
import com.clozed.code.data.ApiException;
import com.clozed.code.data.Backend;
import com.clozed.code.data.ModelOpt;
import com.clozed.code.data.PermissionReq;
import com.clozed.code.data.Prefs;
import com.clozed.code.data.SessionInfo;
import com.clozed.code.engine.CatModel;
import com.clozed.code.engine.CatProvider;
import com.clozed.code.engine.ChainEntry;
import com.clozed.code.engine.LocalBackend;
import com.clozed.code.engine.ModelFetch;
import com.clozed.code.engine.ProviderBackup;
import com.clozed.code.engine.ProviderStore;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: AppViewModel.kt */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0098\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010(\u001a\u00020)2\n\u0010*\u001a\u00060+j\u0002`,H\u0002J\u0006\u0010-\u001a\u00020)J\u001e\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u001cJ\u000e\u00102\u001a\u00020)2\u0006\u00101\u001a\u00020\u001cJ.\u00103\u001a\u00020)2\u0006\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\u001cJ\b\u00109\u001a\u0004\u0018\u00010\u001cJ\u000e\u0010:\u001a\u00020)2\u0006\u0010;\u001a\u00020\u001cJ\u000e\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020#J\u0006\u0010>\u001a\u00020)J\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001c0@2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001c0@H\u0002J\u0010\u0010B\u001a\u00020)2\u0006\u0010C\u001a\u00020\u0012H\u0002J\u0006\u0010D\u001a\u00020)J\u0010\u0010E\u001a\u00020)2\u0006\u0010C\u001a\u00020\u0012H\u0002J\u0010\u0010F\u001a\u00020)2\u0006\u0010*\u001a\u00020GH\u0002J\b\u0010H\u001a\u00020)H\u0002J\u0006\u0010I\u001a\u00020)J\b\u0010J\u001a\u00020)H\u0002J,\u0010K\u001a\u00020)2\u0006\u00101\u001a\u00020\u001c2\b\b\u0002\u0010L\u001a\u00020\u001c2\b\b\u0002\u0010M\u001a\u00020\u001c2\b\b\u0002\u0010N\u001a\u00020\u001cJ\u0018\u0010O\u001a\u00020\u001c2\u0006\u0010P\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020\u001cH\u0002J\u0016\u0010R\u001a\u00020)2\u0006\u0010P\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020\u001cJ\u001e\u0010S\u001a\u00020)2\u0006\u0010T\u001a\u00020\u001c2\u0006\u0010;\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010UJ\u000e\u0010V\u001a\u00020)2\u0006\u0010W\u001a\u00020\u001cJ\u000e\u0010X\u001a\u00020)2\u0006\u0010T\u001a\u00020\u001cJ\u0016\u0010Y\u001a\u00020)2\u0006\u0010T\u001a\u00020\u001c2\u0006\u0010L\u001a\u00020\u001cJ\u000e\u0010Z\u001a\u00020)2\u0006\u0010T\u001a\u00020\u001cJ\u0006\u0010[\u001a\u00020)J\u0012\u0010\\\u001a\u00020)2\b\b\u0002\u0010]\u001a\u00020#H\u0002J\u000e\u0010^\u001a\u00020)H\u0082@¢\u0006\u0002\u0010_J\u001e\u0010`\u001a\u00020)2\u0006\u0010;\u001a\u00020\u001c2\u000e\b\u0002\u0010a\u001a\b\u0012\u0004\u0012\u00020\u001c0bJ\b\u0010c\u001a\u0004\u0018\u00010\u0014J\u0006\u0010d\u001a\u00020)J\u0016\u0010e\u001a\u00020)2\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020\u001cJ\u000e\u0010i\u001a\u00020)2\u0006\u0010j\u001a\u00020kJ\u000e\u0010l\u001a\u00020)2\u0006\u0010m\u001a\u00020nJ\u000e\u0010o\u001a\u00020)2\u0006\u0010p\u001a\u00020\u001cJ\u000e\u0010q\u001a\u00020)2\u0006\u0010=\u001a\u00020#J\u0006\u0010r\u001a\u00020)J\u0006\u0010s\u001a\u00020)J\f\u0010t\u001a\b\u0012\u0004\u0012\u00020u0bJ\u0010\u0010v\u001a\u0004\u0018\u00010\u001c2\u0006\u0010T\u001a\u00020\u001cJ\u0010\u0010w\u001a\u00020\u001c2\u0006\u0010x\u001a\u00020\u001cH\u0002J\u000e\u0010y\u001a\u00020z2\u0006\u0010T\u001a\u00020\u001cJ\u0014\u0010{\u001a\b\u0012\u0004\u0012\u00020|0b2\u0006\u0010T\u001a\u00020\u001cJ\u0016\u0010}\u001a\u00020)2\u0006\u0010T\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\u001cJ\u0016\u0010~\u001a\u00020)2\u0006\u0010T\u001a\u00020\u001c2\u0006\u0010\u007f\u001a\u00020zJ\u0007\u0010\u0080\u0001\u001a\u00020#J\u000f\u0010\u0081\u0001\u001a\u00020)2\u0006\u0010=\u001a\u00020#J\u000e\u0010\u0082\u0001\u001a\t\u0012\u0005\u0012\u00030\u0083\u00010bJ\u0017\u0010\u0084\u0001\u001a\u00020)2\u000e\u0010\u0085\u0001\u001a\t\u0012\u0005\u0012\u00030\u0083\u00010bJ\u000f\u0010\u0086\u0001\u001a\u00020\u001c2\u0006\u0010T\u001a\u00020\u001cJ\u000f\u0010\u0087\u0001\u001a\u00020#2\u0006\u0010T\u001a\u00020\u001cJ\r\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020k0bJ\u0007\u0010\u0089\u0001\u001a\u00020)J\u000f\u0010\u008a\u0001\u001a\u00020)2\u0006\u0010T\u001a\u00020\u001cJ\u000f\u0010\u008b\u0001\u001a\u00020)2\u0006\u0010T\u001a\u00020\u001cJ8\u0010\u008c\u0001\u001a\u00020)2\u0007\u0010\u008d\u0001\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\u001cJ\u0007\u0010\u008e\u0001\u001a\u00020)J\u0018\u0010\u008f\u0001\u001a\u00020)2\u0007\u0010\u0090\u0001\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\u001cJ\u0018\u0010\u0091\u0001\u001a\u00020)2\u0006\u0010T\u001a\u00020\u001c2\u0007\u0010\u0092\u0001\u001a\u00020#J\u001a\u0010\u0093\u0001\u001a\u00020)2\u0006\u0010T\u001a\u00020\u001c2\t\b\u0002\u0010\u0094\u0001\u001a\u00020#J9\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020\u001c0b2\u0006\u00105\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\u001c2\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u001cH\u0086@¢\u0006\u0003\u0010\u0097\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bj\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d`\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0010R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0010R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0099\u0001"}, d2 = {"Lcom/clozed/code/AppViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "prefs", "Lcom/clozed/code/data/Prefs;", "getPrefs", "()Lcom/clozed/code/data/Prefs;", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/clozed/code/UiState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "api", "Lcom/clozed/code/data/Backend;", "local", "Lcom/clozed/code/engine/LocalBackend;", "eventJob", "Lkotlinx/coroutines/Job;", "msgJob", "listJob", "busyJob", "sending", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "_themeMode", "themeMode", "getThemeMode", "_dynamicColor", "", "dynamicColor", "getDynamicColor", "settingsReturn", "Lcom/clozed/code/Screen;", "fail", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "consumeMessage", "connect", "url", "password", "directory", "connectLocal", "addCustomProvider", "name", "kind", "apiUrl", "models", "key", "exportProvidersJson", "importProvidersJson", "text", "setAutoApprove", "v", "disconnect", "withPending", "", "active", "startBusyWatch", "client", "onAppResumed", "startEvents", "handleEvent", "Lorg/json/JSONObject;", "scheduleSessions", "refreshSessions", "loadPickers", "newSession", "title", "portSource", "portWhat", "portCommand", "source", "what", "portFromProject", "sendTo", "id", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "switchProvider", "providerId", "deleteSession", "renameSession", "openSession", "back", "scheduleMessages", "immediate", "loadMessages", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "send", "images", "", "engine", "interrupt", "replyPermission", "req", "Lcom/clozed/code/data/PermissionReq;", "decision", "switchModel", "m", "Lcom/clozed/code/data/ModelOpt;", "switchAgent", "a", "Lcom/clozed/code/data/AgentOpt;", "setThemeMode", "mode", "setDynamicColor", "openSettings", "closeSettings", "customProviders", "Lcom/clozed/code/engine/CatProvider;", "keyHint", "mask", "k", "keyCount", "", "keyEntries", "Lcom/clozed/code/AppViewModel$KeyEntry;", "addApiKey", "removeApiKeyAt", "index", "autoSwitchOn", "setAutoSwitch", "fallbackChain", "Lcom/clozed/code/engine/ChainEntry;", "saveFallbackChain", "list", "providerName", "providerExhausted", "fallbackChoices", "resetLimitFlags", "removeKey", "removeCustomProvider", "updateCustomProvider", "oldId", "loadIntegrations", "connectKey", "integrationId", "setProviderEnabled", DebugKt.DEBUG_PROPERTY_VALUE_ON, "fetchModels", NotificationCompat.GROUP_KEY_SILENT, "fetchModelList", "existingId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "KeyEntry", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class AppViewModel extends AndroidViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<Boolean> _dynamicColor;
    private final MutableStateFlow<UiState> _state;
    private final MutableStateFlow<String> _themeMode;
    private Backend api;
    private Job busyJob;
    private final StateFlow<Boolean> dynamicColor;
    private Job eventJob;
    private Job listJob;
    private LocalBackend local;
    private Job msgJob;
    private final Prefs prefs;
    private final HashMap<String, Long> sending;
    private Screen settingsReturn;
    private final StateFlow<UiState> state;
    private final StateFlow<String> themeMode;

    /* compiled from: AppViewModel.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /tmp/classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Screen.values().length];
            try {
                iArr[Screen.Chat.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppViewModel(Application app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        Prefs prefs = new Prefs(app);
        this.prefs = prefs;
        MutableStateFlow<UiState> MutableStateFlow = StateFlowKt.MutableStateFlow(new UiState(null, false, null, null, false, null, null, false, null, null, null, null, null, null, null, null, false, false, null, 524287, null));
        this._state = MutableStateFlow;
        this.state = FlowKt.asStateFlow(MutableStateFlow);
        this.sending = new HashMap<>();
        MutableStateFlow<String> MutableStateFlow2 = StateFlowKt.MutableStateFlow(prefs.getThemeMode());
        this._themeMode = MutableStateFlow2;
        this.themeMode = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<Boolean> MutableStateFlow3 = StateFlowKt.MutableStateFlow(Boolean.valueOf(prefs.getDynamicColor()));
        this._dynamicColor = MutableStateFlow3;
        this.dynamicColor = FlowKt.asStateFlow(MutableStateFlow3);
        this.settingsReturn = Screen.Sessions;
        if (prefs.getAutoConnect()) {
            if (Intrinsics.areEqual(prefs.getMode(), "local")) {
                connectLocal(prefs.getDirectory());
            } else {
                connect(prefs.getServerUrl(), prefs.getPassword(), prefs.getDirectory());
            }
        }
    }

    public final Prefs getPrefs() {
        return this.prefs;
    }

    public final StateFlow<UiState> getState() {
        return this.state;
    }

    public final StateFlow<String> getThemeMode() {
        return this.themeMode;
    }

    public final StateFlow<Boolean> getDynamicColor() {
        return this.dynamicColor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fail(Exception e) {
        String message;
        UiState value;
        if (e instanceof CancellationException) {
            throw e;
        }
        ApiException apiException = e instanceof ApiException ? (ApiException) e : null;
        if ((apiException == null || (message = apiException.getMessage()) == null) && (message = e.getMessage()) == null) {
            message = "Unknown error";
        }
        String str = message;
        MutableStateFlow<UiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, UiState.copy$default(value, null, false, null, null, false, null, null, false, null, null, null, null, null, null, null, str, false, false, null, 491519, null)));
    }

    public final void consumeMessage() {
        UiState value;
        MutableStateFlow<UiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, UiState.copy$default(value, null, false, null, null, false, null, null, false, null, null, null, null, null, null, null, null, false, false, null, 491519, null)));
    }

    public final void connect(String url, String password, String directory) {
        AppViewModel appViewModel = this;
        String url2 = url;
        Intrinsics.checkNotNullParameter(url2, "url");
        String password2 = password;
        Intrinsics.checkNotNullParameter(password2, "password");
        String directory2 = directory;
        Intrinsics.checkNotNullParameter(directory2, "directory");
        MutableStateFlow<UiState> mutableStateFlow = appViewModel._state;
        while (true) {
            UiState value = mutableStateFlow.getValue();
            if (mutableStateFlow.compareAndSet(value, UiState.copy$default(value, null, true, null, null, false, null, null, false, null, null, null, null, null, null, null, null, false, false, null, 524281, null))) {
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(appViewModel), null, null, new AppViewModel$connect$2(url2, password2, appViewModel, directory2, null), 3, null);
                return;
            }
            appViewModel = this;
            url2 = url;
            password2 = password;
            directory2 = directory;
        }
    }

    public final void connectLocal(String directory) {
        UiState value;
        Intrinsics.checkNotNullParameter(directory, "directory");
        String obj = StringsKt.trim((CharSequence) directory).toString();
        if (StringsKt.isBlank(obj)) {
            obj = new File(getApplication().getFilesDir(), "workspace").getPath();
        }
        String str = obj;
        MutableStateFlow<UiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, UiState.copy$default(value, null, true, null, null, false, null, null, false, null, null, null, null, null, null, null, null, false, false, null, 524281, null)));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AppViewModel$connectLocal$2(this, directory, str, null), 3, null);
    }

    public final void addCustomProvider(String name, String kind, String apiUrl, String models, String key) {
        UiState value;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(apiUrl, "apiUrl");
        Intrinsics.checkNotNullParameter(models, "models");
        Intrinsics.checkNotNullParameter(key, "key");
        LocalBackend localBackend = this.local;
        if (localBackend == null) {
            return;
        }
        List split$default = StringsKt.split$default((CharSequence) models, new String[]{",", "\n"}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
        Iterator it = split$default.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        localBackend.getStore().addCustom(StringsKt.trim((CharSequence) name).toString(), kind, apiUrl, arrayList2, key);
        MutableStateFlow<UiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, UiState.copy$default(value, null, false, null, null, false, null, null, false, null, null, null, null, null, null, null, "Provider added ✓", false, false, null, 491519, null)));
        loadIntegrations();
        loadPickers();
    }

    public final String exportProvidersJson() {
        return ProviderBackup.INSTANCE.export(getApplication());
    }

    public final void importProvidersJson(String text) {
        UiState value;
        UiState uiState;
        String message;
        UiState value2;
        Intrinsics.checkNotNullParameter(text, "text");
        try {
            int m1288import = ProviderBackup.INSTANCE.m1288import(getApplication(), text);
            MutableStateFlow<UiState> mutableStateFlow = this._state;
            do {
                value2 = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value2, UiState.copy$default(value2, null, false, null, null, false, null, null, false, null, null, null, null, null, null, null, m1288import + " providers imported ✓", false, false, null, 491519, null)));
            loadIntegrations();
            loadPickers();
        } catch (Exception e) {
            MutableStateFlow<UiState> mutableStateFlow2 = this._state;
            do {
                value = mutableStateFlow2.getValue();
                uiState = value;
                message = e.getMessage();
                if (message == null) {
                    message = "unknown error";
                }
            } while (!mutableStateFlow2.compareAndSet(value, UiState.copy$default(uiState, null, false, null, null, false, null, null, false, null, null, null, null, null, null, null, "Import failed: " + message, false, false, null, 491519, null)));
        }
    }

    public final void setAutoApprove(boolean v) {
        UiState value;
        ProviderStore store;
        LocalBackend localBackend = this.local;
        if (localBackend != null && (store = localBackend.getStore()) != null) {
            store.setAutoApprove(v);
        }
        MutableStateFlow<UiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, UiState.copy$default(value, null, false, null, null, false, null, null, false, null, null, null, null, null, null, null, null, false, v, null, 393215, null)));
    }

    public final void disconnect() {
        Job job = this.eventJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Job job2 = this.busyJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.api = null;
        this.local = null;
        this.prefs.setAutoConnect(false);
        this._state.setValue(new UiState(null, false, null, null, false, null, null, false, null, null, null, null, null, null, null, null, false, false, null, 524287, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set<String> withPending(Set<String> active) {
        long currentTimeMillis = System.currentTimeMillis();
        HashMap<String, Long> hashMap = this.sending;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Long> entry : hashMap.entrySet()) {
            if (currentTimeMillis - entry.getValue().longValue() < 15000) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return SetsKt.plus((Set) active, (Iterable) linkedHashMap.keySet());
    }

    private final void startBusyWatch(Backend client) {
        Job launch$default;
        Job job = this.busyJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AppViewModel$startBusyWatch$1(this, client, null), 3, null);
        this.busyJob = launch$default;
    }

    public final void onAppResumed() {
        Backend backend = this.api;
        if (backend == null) {
            return;
        }
        refreshSessions();
        if (this.state.getValue().getCurrentId() != null) {
            scheduleMessages(true);
        }
        Job job = this.busyJob;
        if (job == null || !job.isActive()) {
            startBusyWatch(backend);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startEvents(Backend client) {
        Job launch$default;
        startBusyWatch(client);
        Job job = this.eventJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AppViewModel$startEvents$1(client, this, null), 3, null);
        this.eventJob = launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b4, code lost:
    
        if (r2.equals("session.execution.failed") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00d4, code lost:
    
        r6 = r30._state;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00d6, code lost:
    
        r7 = r6.getValue();
        r8 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0110, code lost:
    
        if (r6.compareAndSet(r7, com.clozed.code.UiState.copy$default(r8, null, false, null, null, false, null, kotlin.collections.SetsKt.minus(r8.getBusy(), r4), false, null, null, null, null, null, null, null, null, false, false, null, 524223, null)) == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00bc, code lost:
    
        if (r2.equals("session.execution.succeeded") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c6, code lost:
    
        if (r2.equals("session.idle") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d0, code lost:
    
        if (r2.equals("session.execution.interrupted") == false) goto L48;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:53:0x018d. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void handleEvent(org.json.JSONObject r31) {
        /*
            Method dump skipped, instructions count: 490
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.AppViewModel.handleEvent(org.json.JSONObject):void");
    }

    private final void scheduleSessions() {
        Job launch$default;
        Job job = this.listJob;
        if (job == null || !job.isActive()) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AppViewModel$scheduleSessions$1(this, null), 3, null);
            this.listJob = launch$default;
        }
    }

    public final void refreshSessions() {
        Backend backend = this.api;
        if (backend == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AppViewModel$refreshSessions$1(this, backend, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadPickers() {
        Backend backend = this.api;
        if (backend == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AppViewModel$loadPickers$1(this, backend, null), 3, null);
    }

    public static /* synthetic */ void newSession$default(AppViewModel appViewModel, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "";
        }
        if ((i & 8) != 0) {
            str4 = "";
        }
        appViewModel.newSession(str, str2, str3, str4);
    }

    public final void newSession(String directory, String title, String portSource, String portWhat) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(portSource, "portSource");
        Intrinsics.checkNotNullParameter(portWhat, "portWhat");
        Backend backend = this.api;
        if (backend == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AppViewModel$newSession$1(directory, this, backend, title, portSource, portWhat, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String portCommand(String source, String what) {
        return "/port \"" + StringsKt.replace$default(StringsKt.trim((CharSequence) source).toString(), "\"", "", false, 4, (Object) null) + "\" " + StringsKt.trim((CharSequence) what).toString();
    }

    public final void portFromProject(String source, String what) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(what, "what");
        if (StringsKt.isBlank(source)) {
            return;
        }
        send$default(this, portCommand(source, what), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object sendTo(java.lang.String r31, java.lang.String r32, kotlin.coroutines.Continuation<? super kotlin.Unit> r33) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.AppViewModel.sendTo(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void switchProvider(String providerId) {
        Backend backend;
        String currentId;
        Intrinsics.checkNotNullParameter(providerId, "providerId");
        LocalBackend localBackend = this.local;
        if (localBackend == null || (backend = this.api) == null || (currentId = this.state.getValue().getCurrentId()) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AppViewModel$switchProvider$1(localBackend, currentId, providerId, backend, this, null), 3, null);
    }

    public final void deleteSession(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Backend backend = this.api;
        if (backend == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AppViewModel$deleteSession$1(backend, id, this, null), 3, null);
    }

    public final void renameSession(String id, String title) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Backend backend = this.api;
        if (backend == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AppViewModel$renameSession$1(backend, id, title, this, null), 3, null);
    }

    public final void openSession(String id) {
        Object obj;
        String id2 = id;
        Intrinsics.checkNotNullParameter(id2, "id");
        MutableStateFlow<UiState> mutableStateFlow = this._state;
        while (true) {
            UiState value = mutableStateFlow.getValue();
            MutableStateFlow<UiState> mutableStateFlow2 = mutableStateFlow;
            UiState uiState = value;
            Screen screen = Screen.Chat;
            List emptyList = CollectionsKt.emptyList();
            List emptyList2 = CollectionsKt.emptyList();
            Iterator<T> it = uiState.getSessions().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (Intrinsics.areEqual(((SessionInfo) obj).getId(), id2)) {
                        break;
                    }
                }
            }
            if (mutableStateFlow2.compareAndSet(value, UiState.copy$default(uiState, screen, false, null, null, false, null, null, false, id2, (SessionInfo) obj, emptyList, emptyList2, null, null, null, null, false, false, null, 520446, null))) {
                break;
            }
            id2 = id;
            mutableStateFlow = mutableStateFlow2;
        }
        scheduleMessages(true);
        if (this.state.getValue().getModels().isEmpty() || this.state.getValue().getAgents().isEmpty()) {
            loadPickers();
        }
    }

    public final void back() {
        UiState value;
        if (WhenMappings.$EnumSwitchMapping$0[this.state.getValue().getScreen().ordinal()] == 1) {
            MutableStateFlow<UiState> mutableStateFlow = this._state;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, UiState.copy$default(value, Screen.Sessions, false, null, null, false, null, null, false, null, null, CollectionsKt.emptyList(), null, null, null, null, null, false, false, null, 523006, null)));
            refreshSessions();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void scheduleMessages$default(AppViewModel appViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        appViewModel.scheduleMessages(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleMessages(boolean immediate) {
        Job launch$default;
        Job job = this.msgJob;
        if (job == null || !job.isActive()) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AppViewModel$scheduleMessages$1(immediate, this, null), 3, null);
            this.msgJob = launch$default;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(8:5|6|(1:(1:(8:10|11|12|13|14|(2:16|(1:17))|25|26)(2:32|33))(3:34|35|36))(3:47|(4:55|56|(1:58)|41)|54)|37|38|39|(6:42|13|14|(0)|25|26)|41))|62|6|(0)(0)|37|38|39|(0)|41|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009d, code lost:
    
        r3 = r0;
        r2 = r7;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00b9 A[Catch: Exception -> 0x00ea, TryCatch #3 {Exception -> 0x00ea, blocks: (B:14:0x00a3, B:16:0x00b9, B:17:0x00bb, B:31:0x009f), top: B:30:0x009f }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object loadMessages(kotlin.coroutines.Continuation<? super kotlin.Unit> r28) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.AppViewModel.loadMessages(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void send$default(AppViewModel appViewModel, String str, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        appViewModel.send(str, list);
    }

    public final void send(String text, List<String> images) {
        String currentId;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(images, "images");
        Backend backend = this.api;
        if (backend == null || (currentId = this.state.getValue().getCurrentId()) == null) {
            return;
        }
        if (StringsKt.isBlank(text) && images.isEmpty()) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AppViewModel$send$1(this, currentId, backend, text, images, null), 3, null);
    }

    /* renamed from: engine, reason: from getter */
    public final LocalBackend getLocal() {
        return this.local;
    }

    public final void interrupt() {
        String currentId;
        UiState value;
        UiState uiState;
        Backend backend = this.api;
        if (backend == null || (currentId = this.state.getValue().getCurrentId()) == null) {
            return;
        }
        this.sending.remove(currentId);
        MutableStateFlow<UiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            uiState = value;
        } while (!mutableStateFlow.compareAndSet(value, UiState.copy$default(uiState, null, false, null, null, false, null, SetsKt.minus(uiState.getBusy(), currentId), false, null, null, null, null, null, null, null, null, false, false, null, 524223, null)));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AppViewModel$interrupt$2(backend, currentId, this, null), 3, null);
    }

    public final void replyPermission(PermissionReq req, String decision) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(decision, "decision");
        Backend backend = this.api;
        if (backend == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AppViewModel$replyPermission$1(backend, req, decision, this, null), 3, null);
    }

    public final void switchModel(ModelOpt m) {
        String currentId;
        Intrinsics.checkNotNullParameter(m, "m");
        Backend backend = this.api;
        if (backend == null || (currentId = this.state.getValue().getCurrentId()) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AppViewModel$switchModel$1(backend, currentId, m, this, null), 3, null);
    }

    public final void switchAgent(AgentOpt a) {
        String currentId;
        Intrinsics.checkNotNullParameter(a, "a");
        Backend backend = this.api;
        if (backend == null || (currentId = this.state.getValue().getCurrentId()) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AppViewModel$switchAgent$1(backend, currentId, a, this, null), 3, null);
    }

    public final void setThemeMode(String mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.prefs.setThemeMode(mode);
        this._themeMode.setValue(mode);
    }

    public final void setDynamicColor(boolean v) {
        this.prefs.setDynamicColor(v);
        this._dynamicColor.setValue(Boolean.valueOf(v));
    }

    public final void openSettings() {
        UiState value;
        Screen screen = this.state.getValue().getScreen();
        if (screen == Screen.Settings || screen == Screen.Connect) {
            return;
        }
        this.settingsReturn = screen;
        MutableStateFlow<UiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, UiState.copy$default(value, Screen.Settings, false, null, null, false, null, null, false, null, null, null, null, null, null, null, null, false, false, null, 524286, null)));
        loadIntegrations();
    }

    public final void closeSettings() {
        UiState value;
        MutableStateFlow<UiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, UiState.copy$default(value, this.settingsReturn, false, null, null, false, null, null, false, null, null, null, null, null, null, null, null, false, false, null, 524286, null)));
    }

    public final List<CatProvider> customProviders() {
        ProviderStore store;
        List<CatProvider> customProviders;
        LocalBackend localBackend = this.local;
        return (localBackend == null || (store = localBackend.getStore()) == null || (customProviders = store.customProviders()) == null) ? CollectionsKt.emptyList() : customProviders;
    }

    public final String keyHint(String id) {
        ProviderStore store;
        String keyFor;
        Intrinsics.checkNotNullParameter(id, "id");
        LocalBackend localBackend = this.local;
        if (localBackend == null || (store = localBackend.getStore()) == null || (keyFor = store.keyFor(id)) == null) {
            return null;
        }
        if (keyFor.length() <= 8) {
            return "••••";
        }
        return StringsKt.take(keyFor, 3) + "…" + StringsKt.takeLast(keyFor, 4);
    }

    /* compiled from: AppViewModel.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/clozed/code/AppViewModel$KeyEntry;", "", "hint", "", "exhaustedUntil", "", "reason", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getHint", "()Ljava/lang/String;", "getExhaustedUntil", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getReason", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /tmp/classes3.dex */
    public static final class KeyEntry {
        public static final int $stable = 0;
        private final Long exhaustedUntil;
        private final String hint;
        private final String reason;

        public KeyEntry(String hint, Long l, String str) {
            Intrinsics.checkNotNullParameter(hint, "hint");
            this.hint = hint;
            this.exhaustedUntil = l;
            this.reason = str;
        }

        public final Long getExhaustedUntil() {
            return this.exhaustedUntil;
        }

        public final String getHint() {
            return this.hint;
        }

        public final String getReason() {
            return this.reason;
        }
    }

    private final String mask(String k) {
        if (k.length() <= 8) {
            return "••••";
        }
        return StringsKt.take(k, 3) + "…" + StringsKt.takeLast(k, 4);
    }

    public final int keyCount(String id) {
        ProviderStore store;
        List<String> keys;
        Intrinsics.checkNotNullParameter(id, "id");
        LocalBackend localBackend = this.local;
        if (localBackend == null || (store = localBackend.getStore()) == null || (keys = store.keys(id)) == null) {
            return 0;
        }
        return keys.size();
    }

    public final List<KeyEntry> keyEntries(String id) {
        ProviderStore store;
        Intrinsics.checkNotNullParameter(id, "id");
        LocalBackend localBackend = this.local;
        if (localBackend == null || (store = localBackend.getStore()) == null) {
            return CollectionsKt.emptyList();
        }
        List<String> keys = store.keys(id);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(keys, 10));
        for (String str : keys) {
            Pair<Long, String> exhaustedInfo = store.exhaustedInfo(id, str);
            String mask = mask(str);
            String str2 = null;
            Long first = exhaustedInfo != null ? exhaustedInfo.getFirst() : null;
            if (exhaustedInfo != null) {
                str2 = exhaustedInfo.getSecond();
            }
            arrayList.add(new KeyEntry(mask, first, str2));
        }
        return arrayList;
    }

    public final void addApiKey(String id, String key) {
        UiState value;
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(key, "key");
        LocalBackend localBackend = this.local;
        if (localBackend == null) {
            return;
        }
        localBackend.getStore().addKey(id, key);
        MutableStateFlow<UiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, UiState.copy$default(value, null, false, null, null, false, null, null, false, null, null, null, null, null, null, null, "API key added ✓", false, false, null, 491519, null)));
        loadIntegrations();
        loadPickers();
        fetchModels(id, true);
    }

    public final void removeApiKeyAt(String id, int index) {
        Intrinsics.checkNotNullParameter(id, "id");
        LocalBackend localBackend = this.local;
        if (localBackend == null) {
            return;
        }
        localBackend.getStore().removeKeyAt(id, index);
        loadIntegrations();
        loadPickers();
    }

    public final boolean autoSwitchOn() {
        ProviderStore store;
        LocalBackend localBackend = this.local;
        if (localBackend == null || (store = localBackend.getStore()) == null) {
            return true;
        }
        return store.getAutoSwitch();
    }

    public final void setAutoSwitch(boolean v) {
        ProviderStore store;
        LocalBackend localBackend = this.local;
        if (localBackend == null || (store = localBackend.getStore()) == null) {
            return;
        }
        store.setAutoSwitch(v);
    }

    public final List<ChainEntry> fallbackChain() {
        ProviderStore store;
        List<ChainEntry> chain;
        LocalBackend localBackend = this.local;
        return (localBackend == null || (store = localBackend.getStore()) == null || (chain = store.chain()) == null) ? CollectionsKt.emptyList() : chain;
    }

    public final void saveFallbackChain(List<ChainEntry> list) {
        ProviderStore store;
        Intrinsics.checkNotNullParameter(list, "list");
        LocalBackend localBackend = this.local;
        if (localBackend == null || (store = localBackend.getStore()) == null) {
            return;
        }
        store.saveChain(list);
    }

    public final String providerName(String id) {
        ProviderStore store;
        CatProvider provider;
        String name;
        Intrinsics.checkNotNullParameter(id, "id");
        LocalBackend localBackend = this.local;
        return (localBackend == null || (store = localBackend.getStore()) == null || (provider = store.provider(id)) == null || (name = provider.getName()) == null) ? id : name;
    }

    public final boolean providerExhausted(String id) {
        ProviderStore store;
        Intrinsics.checkNotNullParameter(id, "id");
        LocalBackend localBackend = this.local;
        if (localBackend != null && (store = localBackend.getStore()) != null) {
            List<String> keys = store.keys(id);
            if (!keys.isEmpty()) {
                List<String> list = keys;
                if ((list instanceof Collection) && list.isEmpty()) {
                    return true;
                }
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (!store.isKeyExhausted(id, (String) it.next())) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final List<ModelOpt> fallbackChoices() {
        ProviderStore store;
        LocalBackend localBackend = this.local;
        if (localBackend == null || (store = localBackend.getStore()) == null) {
            return CollectionsKt.emptyList();
        }
        List<CatProvider> all = store.all();
        ArrayList<CatProvider> arrayList = new ArrayList();
        for (Object obj : all) {
            CatProvider catProvider = (CatProvider) obj;
            if (store.isConnected(catProvider) && store.isEnabled(catProvider.getId())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (CatProvider catProvider2 : arrayList) {
            List<CatModel> models = catProvider2.getModels();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(models, 10));
            for (CatModel catModel : models) {
                arrayList3.add(new ModelOpt(catProvider2.getId(), catModel.getId(), catModel.getName()));
            }
            CollectionsKt.addAll(arrayList2, arrayList3);
        }
        return arrayList2;
    }

    public final void resetLimitFlags() {
        UiState value;
        ProviderStore store;
        LocalBackend localBackend = this.local;
        if (localBackend != null && (store = localBackend.getStore()) != null) {
            store.clearAllExhausted();
        }
        MutableStateFlow<UiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, UiState.copy$default(value, null, false, null, null, false, null, null, false, null, null, null, null, null, null, null, "Limit flags reset ✓", false, false, null, 491519, null)));
    }

    public final void removeKey(String id) {
        UiState value;
        Intrinsics.checkNotNullParameter(id, "id");
        LocalBackend localBackend = this.local;
        if (localBackend == null) {
            return;
        }
        localBackend.getStore().setKey(id, "");
        MutableStateFlow<UiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, UiState.copy$default(value, null, false, null, null, false, null, null, false, null, null, null, null, null, null, null, "API key removed", false, false, null, 491519, null)));
        loadIntegrations();
        loadPickers();
    }

    public final void removeCustomProvider(String id) {
        UiState value;
        Intrinsics.checkNotNullParameter(id, "id");
        LocalBackend localBackend = this.local;
        if (localBackend == null) {
            return;
        }
        localBackend.getStore().removeCustom(id);
        MutableStateFlow<UiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, UiState.copy$default(value, null, false, null, null, false, null, null, false, null, null, null, null, null, null, null, "Provider removed", false, false, null, 491519, null)));
        loadIntegrations();
        loadPickers();
    }

    public final void updateCustomProvider(String oldId, String name, String kind, String apiUrl, String models, String key) {
        UiState value;
        Intrinsics.checkNotNullParameter(oldId, "oldId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(apiUrl, "apiUrl");
        Intrinsics.checkNotNullParameter(models, "models");
        Intrinsics.checkNotNullParameter(key, "key");
        LocalBackend localBackend = this.local;
        if (localBackend == null) {
            return;
        }
        List split$default = StringsKt.split$default((CharSequence) models, new String[]{",", "\n"}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
        Iterator it = split$default.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        List<String> keys = localBackend.getStore().keys(oldId);
        localBackend.getStore().removeCustom(oldId);
        String addCustom = localBackend.getStore().addCustom(StringsKt.trim((CharSequence) name).toString(), kind, apiUrl, arrayList2, key);
        if (StringsKt.isBlank(key)) {
            localBackend.getStore().saveKeys(addCustom, keys);
        }
        MutableStateFlow<UiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, UiState.copy$default(value, null, false, null, null, false, null, null, false, null, null, null, null, null, null, null, "Provider updated ✓", false, false, null, 491519, null)));
        loadIntegrations();
        loadPickers();
    }

    public final void loadIntegrations() {
        Backend backend = this.api;
        if (backend == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AppViewModel$loadIntegrations$1(this, backend, null), 3, null);
    }

    public final void connectKey(String integrationId, String key) {
        Intrinsics.checkNotNullParameter(integrationId, "integrationId");
        Intrinsics.checkNotNullParameter(key, "key");
        Backend backend = this.api;
        if (backend == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AppViewModel$connectKey$1(backend, integrationId, key, this, null), 3, null);
    }

    public final void setProviderEnabled(String id, boolean on) {
        Intrinsics.checkNotNullParameter(id, "id");
        LocalBackend localBackend = this.local;
        if (localBackend == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AppViewModel$setProviderEnabled$1(localBackend, id, on, this, null), 3, null);
    }

    public static /* synthetic */ void fetchModels$default(AppViewModel appViewModel, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        appViewModel.fetchModels(str, z);
    }

    public final void fetchModels(String id, boolean silent) {
        CatProvider provider;
        AppViewModel appViewModel = this;
        String id2 = id;
        Intrinsics.checkNotNullParameter(id2, "id");
        LocalBackend localBackend = appViewModel.local;
        if (localBackend == null || (provider = localBackend.getStore().provider(id2)) == null || appViewModel.state.getValue().getFetching().contains(id2)) {
            return;
        }
        MutableStateFlow<UiState> mutableStateFlow = appViewModel._state;
        while (true) {
            UiState value = mutableStateFlow.getValue();
            UiState uiState = value;
            if (mutableStateFlow.compareAndSet(value, UiState.copy$default(uiState, null, false, null, null, false, null, null, false, null, null, null, null, null, null, null, null, false, false, SetsKt.plus(uiState.getFetching(), id2), 262143, null))) {
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(appViewModel), null, null, new AppViewModel$fetchModels$2(provider, localBackend, id2, silent, appViewModel, null), 3, null);
                return;
            } else {
                appViewModel = this;
                id2 = id;
            }
        }
    }

    public final Object fetchModelList(String str, String str2, String str3, String str4, Continuation<? super List<String>> continuation) {
        LocalBackend localBackend;
        ProviderStore store;
        String str5 = null;
        if (str4 != null && (localBackend = this.local) != null && (store = localBackend.getStore()) != null) {
            str5 = store.keyFor(str4);
        }
        ModelFetch modelFetch = ModelFetch.INSTANCE;
        String str6 = str3;
        if (StringsKt.isBlank(str6)) {
            if (str5 == null) {
                str5 = "";
            }
            str6 = str5;
        }
        return modelFetch.fetch(str, str2, str6, continuation);
    }
}
