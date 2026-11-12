package com.clozed.code.engine;

import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.clozed.code.data.AgentOpt;
import com.clozed.code.data.Backend;
import com.clozed.code.data.Block;
import com.clozed.code.data.ChatItem;
import com.clozed.code.data.IntegrationOpt;
import com.clozed.code.data.ModelOpt;
import com.clozed.code.data.PermissionReq;
import com.clozed.code.data.SessionInfo;
import com.clozed.code.engine.LlmTurn;
import com.clozed.code.engine.MPart;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: LocalBackend.kt */
@Metadata(d1 = {"\u0000\u0096\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001:\u0002Ë\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020\u0019H\u0002J\u0010\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020'H\u0002J\u0010\u0010/\u001a\u0002002\u0006\u0010,\u001a\u00020\u0019H\u0002J\u001a\u00101\u001a\u0002002\u0006\u00102\u001a\u00020\u00182\b\u00103\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u00104\u001a\u00020\u00182\u0006\u00105\u001a\u00020\u0018H\u0002J\u0010\u00106\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u0018H\u0002J\u0010\u00108\u001a\u0002092\u0006\u0010,\u001a\u00020\u0019H\u0002J\u000e\u00108\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010:J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002090;H\u0096@¢\u0006\u0002\u0010:J\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00180=H\u0096@¢\u0006\u0002\u0010:J\u0018\u0010>\u001a\u0004\u0018\u0001092\u0006\u00107\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010?J\u0018\u0010@\u001a\u0002092\b\u0010A\u001a\u0004\u0018\u00010\u0018H\u0096@¢\u0006\u0002\u0010?J\u0016\u0010B\u001a\u0002002\u0006\u00107\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010?J\u001e\u0010C\u001a\u0002002\u0006\u00107\u001a\u00020\u00182\u0006\u0010D\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010EJ\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020G0;2\u0006\u00107\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010?J\u0010\u0010H\u001a\u00020\u00182\u0006\u0010I\u001a\u00020\u0018H\u0002J\u0016\u0010J\u001a\b\u0012\u0004\u0012\u00020G0;2\u0006\u0010,\u001a\u00020\u0019H\u0002J\u001c\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180L2\u0006\u0010M\u001a\u00020\u0018H\u0002J \u0010N\u001a\u0002002\u0006\u0010,\u001a\u00020\u00192\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u0018H\u0002J\u0018\u0010R\u001a\u0002002\u0006\u0010,\u001a\u00020\u00192\u0006\u0010Q\u001a\u00020\u0018H\u0002J\"\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00180;2\f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00180;H\u0082@¢\u0006\u0002\u0010UJ,\u0010V\u001a\u0002002\u0006\u00107\u001a\u00020\u00182\u0006\u0010Q\u001a\u00020\u00182\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00180;H\u0096@¢\u0006\u0002\u0010XJ\u0014\u0010Y\u001a\u00020*2\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u0018H\u0002J\u0014\u0010\\\u001a\u0002002\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u0018H\u0002J\u0006\u0010]\u001a\u000200J3\u0010^\u001a\u0002002\u0006\u0010,\u001a\u00020\u00192\u001c\u0010_\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002000a\u0012\u0006\u0012\u0004\u0018\u00010b0`H\u0002¢\u0006\u0002\u0010cJ\u0016\u0010d\u001a\u0002002\u0006\u00107\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010?J\u001c\u0010e\u001a\b\u0012\u0004\u0012\u00020f0;2\u0006\u00107\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010?J&\u0010g\u001a\u0002002\u0006\u0010h\u001a\u00020\u00182\u0006\u0010i\u001a\u00020\u00182\u0006\u0010j\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010kJ\u0014\u0010l\u001a\b\u0012\u0004\u0012\u00020m0;H\u0096@¢\u0006\u0002\u0010:J\u0014\u0010n\u001a\b\u0012\u0004\u0012\u00020o0;H\u0096@¢\u0006\u0002\u0010:J\u001e\u0010p\u001a\u0002002\u0006\u0010h\u001a\u00020\u00182\u0006\u0010q\u001a\u00020mH\u0096@¢\u0006\u0002\u0010rJ\u001e\u0010s\u001a\u0002002\u0006\u0010h\u001a\u00020\u00182\u0006\u0010t\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010EJ\u001e\u0010u\u001a\u0002002\u0006\u0010h\u001a\u00020\u00182\u0006\u0010v\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010EJ\u0014\u0010w\u001a\b\u0012\u0004\u0012\u00020x0;H\u0096@¢\u0006\u0002\u0010:J\u001e\u0010y\u001a\u0002002\u0006\u0010z\u001a\u00020\u00182\u0006\u0010{\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010EJ\u000e\u0010|\u001a\b\u0012\u0004\u0012\u00020'0}H\u0016J\u0015\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00182\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0002J\u0017\u0010\u0083\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010LH\u0002J+\u0010\u0084\u0001\u001a\u0002002\u0006\u00107\u001a\u00020\u00182\u0007\u0010\u0085\u0001\u001a\u00020#2\b\u0010h\u001a\u0004\u0018\u00010\u0018H\u0086@¢\u0006\u0003\u0010\u0086\u0001J\u0019\u0010\u0088\u0001\u001a\t\u0012\u0005\u0012\u00030\u0089\u00010;2\u0007\u0010\u008a\u0001\u001a\u00020\u0018H\u0002J,\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00182\u0007\u0010\u008c\u0001\u001a\u00020\u00192\u0007\u0010\u008d\u0001\u001a\u00020\u00182\r\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180;H\u0002J<\u0010\u008f\u0001\u001a\u0002002\u0007\u0010\u008c\u0001\u001a\u00020\u00192\u0007\u0010\u008d\u0001\u001a\u00020\u00182\r\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180;2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0018H\u0082@¢\u0006\u0003\u0010\u0091\u0001J1\u0010\u0092\u0001\u001a\u00020\u00182\u0007\u0010\u008c\u0001\u001a\u00020\u00192\u0007\u0010\u0093\u0001\u001a\u00020\u00182\r\u0010\u0094\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180;H\u0082@¢\u0006\u0003\u0010\u0095\u0001J\u0012\u0010\u0099\u0001\u001a\u00020\u00182\u0007\u0010\u009a\u0001\u001a\u00020\u0018H\u0002J\u0011\u0010\u009b\u0001\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0019H\u0002JC\u0010\u009c\u0001\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u00192\u0007\u0010\u009d\u0001\u001a\u00020\u00182\n\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u0082\u00012\u000e\u0010\u009f\u0001\u001a\t\u0012\u0005\u0012\u00030 \u00010;2\u000b\b\u0002\u0010¡\u0001\u001a\u0004\u0018\u00010\u0018H\u0002J\u0011\u0010¢\u0001\u001a\u0002002\u0006\u0010,\u001a\u00020\u0019H\u0002J\u001c\u0010£\u0001\u001a\u0004\u0018\u00010\u00182\u0006\u0010,\u001a\u00020\u00192\u0007\u0010¤\u0001\u001a\u00020\u0005H\u0002J-\u0010§\u0001\u001a\u0004\u0018\u00010\u00182\u0006\u0010,\u001a\u00020\u00192\u0007\u0010\u009a\u0001\u001a\u00020\u00182\u0006\u0010I\u001a\u00020\u00182\u0007\u0010¨\u0001\u001a\u00020\u0018H\u0002J\u001d\u0010©\u0001\u001a\u00020\u00182\u0007\u0010ª\u0001\u001a\u00020\u00182\t\b\u0002\u0010«\u0001\u001a\u00020*H\u0002J\u0018\u0010¬\u0001\u001a\t\u0012\u0005\u0012\u00030\u00ad\u00010;2\u0006\u0010,\u001a\u00020\u0019H\u0002J \u0010®\u0001\u001a\t\u0012\u0005\u0012\u00030¯\u00010;2\u000e\u0010\u009f\u0001\u001a\t\u0012\u0005\u0012\u00030 \u00010;H\u0002J\u0018\u0010°\u0001\u001a\u0002002\u0006\u0010,\u001a\u00020\u0019H\u0082@¢\u0006\u0003\u0010±\u0001J\u0014\u0010²\u0001\u001a\u00020\u00182\t\u0010³\u0001\u001a\u0004\u0018\u00010\u0018H\u0002J#\u0010´\u0001\u001a\t\u0012\u0005\u0012\u00030µ\u00010;2\b\u0010¶\u0001\u001a\u00030\u0082\u00012\u0007\u0010·\u0001\u001a\u00020\u0018H\u0002J\u001c\u0010¸\u0001\u001a\u00020\u00182\b\u0010¶\u0001\u001a\u00030\u0082\u00012\u0007\u0010·\u0001\u001a\u00020\u0018H\u0002J7\u0010¹\u0001\u001a\u00020#2\u0006\u0010,\u001a\u00020\u00192\u0007\u0010\u008c\u0001\u001a\u00020\u00192\t\b\u0002\u0010º\u0001\u001a\u00020#2\t\b\u0002\u0010»\u0001\u001a\u00020\u0018H\u0082@¢\u0006\u0003\u0010¼\u0001J\\\u0010½\u0001\u001a\u00020\u00182\u0007\u0010¾\u0001\u001a\u00020\u00192\u0007\u0010\u008c\u0001\u001a\u00020\u00192\u0006\u0010V\u001a\u00020\u00182\u0007\u0010\u009d\u0001\u001a\u00020\u00182'\u0010¿\u0001\u001a\"\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00180L0;\u0012\u0004\u0012\u0002000`H\u0082@¢\u0006\u0003\u0010À\u0001J$\u0010Á\u0001\u001a\u00020\u00182\u0007\u0010\u008c\u0001\u001a\u00020\u00192\u0007\u0010Â\u0001\u001a\u00020\u00182\u0007\u0010\u008a\u0001\u001a\u00020\u0005H\u0002J\u0011\u0010Ã\u0001\u001a\u00020*2\u0006\u0010,\u001a\u00020\u0019H\u0002J\u0018\u0010Ä\u0001\u001a\u0002002\u0006\u0010,\u001a\u00020\u0019H\u0082@¢\u0006\u0003\u0010±\u0001J\u0011\u0010Å\u0001\u001a\u0002002\u0006\u0010,\u001a\u00020\u0019H\u0002J!\u0010Æ\u0001\u001a\u0002002\u0006\u0010,\u001a\u00020\u00192\u0007\u0010Ç\u0001\u001a\u00020#H\u0082@¢\u0006\u0003\u0010È\u0001J\u0018\u0010É\u0001\u001a\u0002002\u0006\u0010,\u001a\u00020\u0019H\u0082@¢\u0006\u0003\u0010±\u0001J\u0011\u0010Ê\u0001\u001a\u0002002\u0006\u0010,\u001a\u00020\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017j\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019`\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001f0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000RP\u0010 \u001aB\u0012\f\u0012\n \"*\u0004\u0018\u00010\u00180\u0018\u0012\f\u0012\n \"*\u0004\u0018\u00010#0# \"* \u0012\f\u0012\n \"*\u0004\u0018\u00010\u00180\u0018\u0012\f\u0012\n \"*\u0004\u0018\u00010#0#\u0018\u00010!0!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010~\u001a\b\u0012\u0004\u0012\u00020\u00180;X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\u00180;X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180=X\u0082\u0004¢\u0006\u0002\n\u0000R-\u0010\u0096\u0001\u001a \u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u0097\u0001j\u000f\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018`\u0098\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010¥\u0001\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b¦\u0001\u0010\t¨\u0006Ì\u0001"}, d2 = {"Lcom/clozed/code/engine/LocalBackend;", "Lcom/clozed/code/data/Backend;", "ctx", "Landroid/content/Context;", "defaultDir", "Ljava/io/File;", "<init>", "(Landroid/content/Context;Ljava/io/File;)V", "getDefaultDir", "()Ljava/io/File;", "setDefaultDir", "(Ljava/io/File;)V", "store", "Lcom/clozed/code/engine/ProviderStore;", "getStore", "()Lcom/clozed/code/engine/ProviderStore;", "mcp", "Lcom/clozed/code/engine/McpManager;", "getMcp", "()Lcom/clozed/code/engine/McpManager;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sessions", "Ljava/util/LinkedHashMap;", "", "Lcom/clozed/code/engine/Sess;", "Lkotlin/collections/LinkedHashMap;", "jobs", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlinx/coroutines/Job;", "pending", "Lcom/clozed/code/engine/PendingPerm;", "sessionAllows", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "bus", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lorg/json/JSONObject;", "sessDir", "bgCounter", "", "toJson", "s", "fromJson", "o", "save", "", "emit", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "sid", "newId", "prefix", "get", "id", "info", "Lcom/clozed/code/data/SessionInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "activeSessionIds", "", "session", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSession", "directory", "deleteSession", "renameSession", "title", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "messages", "Lcom/clozed/code/data/ChatItem;", "summaryOf", "args", "toItems", "parsePortArgs", "Lkotlin/Pair;", "a", "noteBefore", "before", "Lcom/clozed/code/engine/Msg;", "text", "note", "importImages", "uris", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prompt", "images", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activeCount", "excluding", "svcOn", "syncService", "interruptAll", "startJob", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lcom/clozed/code/engine/Sess;Lkotlin/jvm/functions/Function1;)V", "interrupt", "permissions", "Lcom/clozed/code/data/PermissionReq;", "replyPermission", "sessionId", "requestId", "decision", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "models", "Lcom/clozed/code/data/ModelOpt;", "agents", "Lcom/clozed/code/data/AgentOpt;", "switchModel", "m", "(Ljava/lang/String;Lcom/clozed/code/data/ModelOpt;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "switchProvider", "providerId", "switchAgent", "agentId", "integrations", "Lcom/clozed/code/data/IntegrationOpt;", "connectKey", "integrationId", "key", "events", "Lkotlinx/coroutines/flow/Flow;", "preferred", "modelPrefs", "defaultModelFor", "p", "Lcom/clozed/code/engine/CatProvider;", "pickDefaultModel", "setProviderEnabled", DebugKt.DEBUG_PROPERTY_VALUE_ON, "(Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "alwaysAsk", "projectRules", "Lcom/clozed/code/engine/PermRule;", "dir", "ruleDecision", "host", "action", "resources", "permit", "message", "(Lcom/clozed/code/engine/Sess;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "askUser", "question", "options", "(Lcom/clozed/code/engine/Sess;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "promptCache", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "asset", "name", "planDir", "systemPrompt", "agent", "provider", "tools", "Lcom/clozed/code/engine/Tool;", "modelOverride", "reconcilePlan", "nestedInstructions", "f", "outputsDir", "getOutputsDir", "trackLoop", "output", "bigOutput", "out", "window", "buildTurns", "Lcom/clozed/code/engine/LlmTurn;", "specs", "Lcom/clozed/code/engine/ToolSpec;", "runLoop", "(Lcom/clozed/code/engine/Sess;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "maskKey", "k", "candidates", "Lcom/clozed/code/engine/LocalBackend$Cand;", "primary", "modelId", "allLimitsMessage", "step", "final", "reason", "(Lcom/clozed/code/engine/Sess;Lcom/clozed/code/engine/Sess;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "spawn", "parent", "onUndo", "(Lcom/clozed/code/engine/Sess;Lcom/clozed/code/engine/Sess;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startBackground", "cmd", "estimateTokens", "maybeCompact", "pruneOutputs", "compact", "keepTail", "(Lcom/clozed/code/engine/Sess;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "undo", "generateTitle", "Cand", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class LocalBackend implements Backend {
    public static final int $stable = 8;
    private final Set<String> alwaysAsk;
    private int bgCounter;
    private final MutableSharedFlow<JSONObject> bus;
    private final Context ctx;
    private File defaultDir;
    private final ConcurrentHashMap<String, Job> jobs;
    private final McpManager mcp;
    private final List<String> modelPrefs;
    private final ConcurrentHashMap<String, PendingPerm> pending;
    private final List<String> preferred;
    private final HashMap<String, String> promptCache;
    private final CoroutineScope scope;
    private final File sessDir;
    private final ConcurrentHashMap.KeySetView<String, Boolean> sessionAllows;
    private final LinkedHashMap<String, Sess> sessions;
    private final ProviderStore store;
    private volatile boolean svcOn;

    public LocalBackend(Context ctx, File defaultDir) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(defaultDir, "defaultDir");
        this.ctx = ctx;
        this.defaultDir = defaultDir;
        ProviderStore providerStore = new ProviderStore(ctx);
        this.store = providerStore;
        this.mcp = new McpManager(providerStore);
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getDefault()));
        this.sessions = new LinkedHashMap<>();
        this.jobs = new ConcurrentHashMap<>();
        this.pending = new ConcurrentHashMap<>();
        this.sessionAllows = ConcurrentHashMap.newKeySet();
        this.bus = SharedFlowKt.MutableSharedFlow$default(0, 512, BufferOverflow.DROP_OLDEST, 1, null);
        File file = new File(ctx.getFilesDir(), "sessions");
        file.mkdirs();
        this.sessDir = file;
        this.defaultDir.mkdirs();
        Skills.INSTANCE.installBundled(ctx);
        try {
            long currentTimeMillis = System.currentTimeMillis() - 259200000;
            File[] listFiles = new File(ctx.getFilesDir(), "tool-output").listFiles();
            if (listFiles != null) {
                ArrayList arrayList = new ArrayList();
                for (File file2 : listFiles) {
                    if (file2.lastModified() < currentTimeMillis) {
                        arrayList.add(file2);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((File) it.next()).delete();
                }
            }
        } catch (Exception unused) {
        }
        File[] listFiles2 = this.sessDir.listFiles(new FileFilter() { // from class: com.clozed.code.engine.LocalBackend$$ExternalSyntheticLambda6
            @Override // java.io.FileFilter
            public final boolean accept(File file3) {
                boolean _init_$lambda$3;
                _init_$lambda$3 = LocalBackend._init_$lambda$3(file3);
                return _init_$lambda$3;
            }
        });
        if (listFiles2 != null) {
            for (File file3 : listFiles2) {
                try {
                    Intrinsics.checkNotNull(file3);
                    Sess fromJson = fromJson(new JSONObject(FilesKt.readText$default(file3, null, 1, null)));
                    this.sessions.put(fromJson.getId(), fromJson);
                } catch (Exception unused2) {
                }
            }
        }
        this.preferred = CollectionsKt.listOf((Object[]) new String[]{"anthropic", "openai", "google", "openrouter", "deepseek", "xai", "groq", "mistral"});
        this.modelPrefs = CollectionsKt.listOf((Object[]) new String[]{"sonnet", "gpt-5", "gemini-2.5-pro", "gemini", "deepseek-chat", "kimi", "qwen3-coder", "llama"});
        this.alwaysAsk = SetsKt.setOf((Object[]) new String[]{"edit", "shell", "external_directory", "mcp"});
        this.promptCache = new HashMap<>();
    }

    public final File getDefaultDir() {
        return this.defaultDir;
    }

    public final void setDefaultDir(File file) {
        Intrinsics.checkNotNullParameter(file, "<set-?>");
        this.defaultDir = file;
    }

    public final ProviderStore getStore() {
        return this.store;
    }

    public final McpManager getMcp() {
        return this.mcp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$3(File file) {
        Intrinsics.checkNotNull(file);
        return Intrinsics.areEqual(FilesKt.getExtension(file), "json");
    }

    private final JSONObject toJson(Sess s) {
        JSONArray jSONArray = new JSONArray();
        synchronized (s) {
            for (Msg msg : s.getMsgs()) {
                JSONObject put = new JSONObject().put("id", msg.getId()).put("role", msg.getRole()).put("text", msg.getText()).put("kind", msg.getKind()).put("model", msg.getModel()).put("completed", msg.getCompleted()).put("time", msg.getTime());
                String llmText = msg.getLlmText();
                if (llmText != null) {
                    put.put("llmText", llmText);
                }
                String think = msg.getThink();
                if (think != null) {
                    put.put("think", think);
                }
                if (!msg.getImages().isEmpty()) {
                    put.put("images", new JSONArray((Collection) msg.getImages()));
                }
                String error = msg.getError();
                if (error != null) {
                    put.put("error", error);
                }
                JSONArray jSONArray2 = new JSONArray();
                for (MPart mPart : msg.getParts()) {
                    if (mPart instanceof MPart.Text) {
                        jSONArray2.put(new JSONObject().put("t", "text").put("text", ((MPart.Text) mPart).getText()));
                    } else if (mPart instanceof MPart.Reasoning) {
                        jSONArray2.put(new JSONObject().put("t", "reasoning").put("text", ((MPart.Reasoning) mPart).getText()));
                    } else {
                        if (!(mPart instanceof MPart.ToolP)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        JSONArray jSONArray3 = new JSONArray();
                        Iterator<T> it = ((MPart.ToolP) mPart).getUndo().iterator();
                        while (it.hasNext()) {
                            Pair pair = (Pair) it.next();
                            String str = (String) pair.component1();
                            Object obj = (String) pair.component2();
                            JSONObject put2 = new JSONObject().put("path", str);
                            if (obj == null) {
                                obj = JSONObject.NULL;
                            }
                            jSONArray3.put(put2.put("before", obj));
                        }
                        JSONObject put3 = new JSONObject().put("t", "tool").put("id", ((MPart.ToolP) mPart).getCallId()).put("name", ((MPart.ToolP) mPart).getName()).put("args", ((MPart.ToolP) mPart).getArgs()).put(NotificationCompat.CATEGORY_STATUS, ((MPart.ToolP) mPart).getStatus()).put("output", ((MPart.ToolP) mPart).getOutput()).put("undo", jSONArray3);
                        String extra = ((MPart.ToolP) mPart).getExtra();
                        if (extra == null) {
                            extra = "";
                        }
                        jSONArray2.put(put3.put("extra", extra));
                    }
                }
                put.put("parts", jSONArray2);
                jSONArray.put(put);
            }
            Unit unit = Unit.INSTANCE;
        }
        JSONObject put4 = new JSONObject().put("id", s.getId()).put("title", s.getTitle()).put("created", s.getCreated()).put("updated", s.getUpdated()).put("directory", s.getDirectory()).put("agent", s.getAgent());
        Object providerId = s.getProviderId();
        if (providerId == null) {
            providerId = JSONObject.NULL;
        }
        JSONObject put5 = put4.put("providerId", providerId);
        Object modelId = s.getModelId();
        if (modelId == null) {
            modelId = JSONObject.NULL;
        }
        JSONObject put6 = put5.put("modelId", modelId).put("todos", s.getTodos()).put("titled", s.getTitled()).put("extraDirs", new JSONArray((Collection) CollectionsKt.toList(s.getExtraDirs()))).put("msgs", jSONArray).put("effort", s.getEffort()).put("inT", s.getInTokens()).put("outT", s.getOutTokens()).put("cR", s.getCacheRead()).put("cW", s.getCacheWrite()).put("cost", s.getCost());
        Intrinsics.checkNotNullExpressionValue(put6, "put(...)");
        return put6;
    }

    private final Sess fromJson(JSONObject o) {
        JSONArray jSONArray;
        Sess sess;
        String str;
        int i;
        String str2;
        String str3 = "id";
        String string = o.getString("id");
        String str4 = "getString(...)";
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Sess sess2 = new Sess(string);
        sess2.setTitle(o.optString("title"));
        sess2.setCreated(o.optLong("created"));
        sess2.setUpdated(o.optLong("updated"));
        sess2.setDirectory(o.optString("directory"));
        sess2.setAgent(o.optString("agent", "build"));
        sess2.setProviderId(o.isNull("providerId") ? null : o.optString("providerId"));
        sess2.setModelId(o.isNull("modelId") ? null : o.optString("modelId"));
        JSONArray optJSONArray = o.optJSONArray("todos");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        sess2.setTodos(optJSONArray);
        JSONArray optJSONArray2 = o.optJSONArray("extraDirs");
        if (optJSONArray2 != null) {
            int length = optJSONArray2.length();
            for (int i2 = 0; i2 < length; i2++) {
                sess2.getExtraDirs().add(optJSONArray2.getString(i2));
            }
        }
        sess2.setTitled(o.optBoolean("titled", false));
        sess2.setEffort(o.optString("effort"));
        sess2.setInTokens(o.optLong("inT"));
        sess2.setOutTokens(o.optLong("outT"));
        sess2.setCacheRead(o.optLong("cR"));
        sess2.setCacheWrite(o.optLong("cW"));
        sess2.setCost(o.optDouble("cost", 0.0d));
        JSONArray optJSONArray3 = o.optJSONArray("msgs");
        if (optJSONArray3 == null) {
            optJSONArray3 = new JSONArray();
        }
        int length2 = optJSONArray3.length();
        int i3 = 0;
        while (i3 < length2) {
            JSONObject jSONObject = optJSONArray3.getJSONObject(i3);
            String string2 = jSONObject.getString(str3);
            Intrinsics.checkNotNullExpressionValue(string2, str4);
            String string3 = jSONObject.getString("role");
            Intrinsics.checkNotNullExpressionValue(string3, str4);
            String optString = jSONObject.optString("text");
            Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
            Msg msg = new Msg(string2, string3, optString);
            msg.setKind(jSONObject.optString("kind"));
            msg.setModel(jSONObject.optString("model"));
            msg.setCompleted(jSONObject.optBoolean("completed", true));
            msg.setTime(jSONObject.optLong("time"));
            if (jSONObject.has("llmText")) {
                msg.setLlmText(jSONObject.optString("llmText"));
            }
            if (jSONObject.has("error")) {
                msg.setError(jSONObject.optString("error"));
            }
            if (jSONObject.has("think")) {
                msg.setThink(jSONObject.optString("think"));
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("images");
            if (optJSONArray4 != null) {
                int length3 = optJSONArray4.length();
                for (int i4 = 0; i4 < length3; i4++) {
                    msg.getImages().add(optJSONArray4.getString(i4));
                }
            }
            JSONArray optJSONArray5 = jSONObject.optJSONArray("parts");
            if (optJSONArray5 == null) {
                optJSONArray5 = new JSONArray();
            }
            int length4 = optJSONArray5.length();
            int i5 = 0;
            while (i5 < length4) {
                JSONObject jSONObject2 = optJSONArray5.getJSONObject(i5);
                String optString2 = jSONObject2.optString("t");
                if (optString2 != null) {
                    int hashCode = optString2.hashCode();
                    jSONArray = optJSONArray3;
                    if (hashCode == -669405410) {
                        sess = sess2;
                        str = str3;
                        i = length2;
                        str2 = str4;
                        if (optString2.equals("reasoning")) {
                            ArrayList<MPart> parts = msg.getParts();
                            String optString3 = jSONObject2.optString("text");
                            Intrinsics.checkNotNullExpressionValue(optString3, "optString(...)");
                            parts.add(new MPart.Reasoning(optString3));
                        }
                    } else if (hashCode == 3556653) {
                        sess = sess2;
                        str = str3;
                        i = length2;
                        str2 = str4;
                        if (optString2.equals("text")) {
                            ArrayList<MPart> parts2 = msg.getParts();
                            String optString4 = jSONObject2.optString("text");
                            Intrinsics.checkNotNullExpressionValue(optString4, "optString(...)");
                            parts2.add(new MPart.Text(optString4));
                        }
                    } else if (hashCode == 3565976 && optString2.equals("tool")) {
                        String optString5 = jSONObject2.optString(str3);
                        Intrinsics.checkNotNullExpressionValue(optString5, "optString(...)");
                        String optString6 = jSONObject2.optString("name");
                        Intrinsics.checkNotNullExpressionValue(optString6, "optString(...)");
                        String optString7 = jSONObject2.optString("args");
                        Intrinsics.checkNotNullExpressionValue(optString7, "optString(...)");
                        String optString8 = jSONObject2.optString(NotificationCompat.CATEGORY_STATUS);
                        Intrinsics.checkNotNullExpressionValue(optString8, "optString(...)");
                        String optString9 = jSONObject2.optString("output");
                        Intrinsics.checkNotNullExpressionValue(optString9, "optString(...)");
                        MPart.ToolP toolP = new MPart.ToolP(optString5, optString6, optString7, optString8, optString9);
                        String optString10 = jSONObject2.optString("extra");
                        if (StringsKt.isBlank(optString10)) {
                            optString10 = null;
                        }
                        toolP.setExtra(optString10);
                        if (Intrinsics.areEqual(toolP.getStatus(), "running") || Intrinsics.areEqual(toolP.getStatus(), "streaming")) {
                            toolP.setStatus("error");
                        }
                        JSONArray optJSONArray6 = jSONObject2.optJSONArray("undo");
                        if (optJSONArray6 != null) {
                            int length5 = optJSONArray6.length();
                            int i6 = 0;
                            while (i6 < length5) {
                                Sess sess3 = sess2;
                                JSONObject jSONObject3 = optJSONArray6.getJSONObject(i6);
                                String str5 = str3;
                                int i7 = length2;
                                String str6 = str4;
                                toolP.getUndo().add(TuplesKt.to(jSONObject3.getString("path"), jSONObject3.isNull("before") ? null : jSONObject3.getString("before")));
                                i6++;
                                sess2 = sess3;
                                str3 = str5;
                                length2 = i7;
                                str4 = str6;
                            }
                        }
                        sess = sess2;
                        str = str3;
                        i = length2;
                        str2 = str4;
                        msg.getParts().add(toolP);
                    }
                    i5++;
                    optJSONArray3 = jSONArray;
                    sess2 = sess;
                    str3 = str;
                    length2 = i;
                    str4 = str2;
                } else {
                    jSONArray = optJSONArray3;
                }
                sess = sess2;
                str = str3;
                i = length2;
                str2 = str4;
                i5++;
                optJSONArray3 = jSONArray;
                sess2 = sess;
                str3 = str;
                length2 = i;
                str4 = str2;
            }
            JSONArray jSONArray2 = optJSONArray3;
            Sess sess4 = sess2;
            String str7 = str3;
            int i8 = length2;
            String str8 = str4;
            if (Intrinsics.areEqual(msg.getRole(), "assistant") && !msg.getCompleted()) {
                msg.setCompleted(true);
                if (msg.getError() == null) {
                    msg.setError("Interrupted");
                }
            }
            sess4.getMsgs().add(msg);
            i3++;
            optJSONArray3 = jSONArray2;
            sess2 = sess4;
            str3 = str7;
            length2 = i8;
            str4 = str8;
        }
        return sess2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void save(Sess s) {
        try {
            File file = new File(this.sessDir, s.getId() + ".json");
            String jSONObject = toJson(s).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
            FilesKt.writeText$default(file, jSONObject, null, 2, null);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emit(String type, String sid) {
        JSONObject jSONObject = new JSONObject();
        if (sid != null) {
            jSONObject.put("sessionID", sid);
        }
        MutableSharedFlow<JSONObject> mutableSharedFlow = this.bus;
        JSONObject put = new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, type).put("data", jSONObject);
        Intrinsics.checkNotNullExpressionValue(put, "put(...)");
        mutableSharedFlow.tryEmit(put);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String newId(String prefix) {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        return prefix + StringsKt.take(StringsKt.replace$default(uuid, "-", "", false, 4, (Object) null), 16);
    }

    private final Sess get(String id) {
        Sess sess;
        synchronized (this.sessions) {
            sess = this.sessions.get(id);
        }
        if (sess != null) {
            return sess;
        }
        throw new IllegalStateException("Session not found");
    }

    private final SessionInfo info(Sess s) {
        String str;
        String id = s.getId();
        String title = s.getTitle();
        if (StringsKt.isBlank(title)) {
            title = "New session";
        }
        String str2 = title;
        long updated = s.getUpdated();
        String directory = s.getDirectory();
        double cost = s.getCost();
        long cacheWrite = s.getCacheWrite() + s.getInTokens() + s.getOutTokens() + s.getCacheRead();
        String modelId = s.getModelId();
        if (modelId != null) {
            String providerId = s.getProviderId();
            if (providerId == null) {
                providerId = "";
            }
            str = providerId + "/" + modelId;
        } else {
            str = null;
        }
        return new SessionInfo(id, str2, updated, directory, cost, str, s.getAgent(), cacheWrite);
    }

    @Override // com.clozed.code.data.Backend
    public Object info(Continuation<? super String> continuation) {
        return "local";
    }

    @Override // com.clozed.code.data.Backend
    public Object sessions(Continuation<? super List<SessionInfo>> continuation) {
        ArrayList arrayList;
        synchronized (this.sessions) {
            Collection<Sess> values = this.sessions.values();
            Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
            List<Sess> sortedWith = CollectionsKt.sortedWith(values, new Comparator() { // from class: com.clozed.code.engine.LocalBackend$sessions$lambda$22$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Long.valueOf(((Sess) t2).getUpdated()), Long.valueOf(((Sess) t).getUpdated()));
                }
            });
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(sortedWith, 10));
            for (Sess sess : sortedWith) {
                Intrinsics.checkNotNull(sess);
                arrayList2.add(info(sess));
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    @Override // com.clozed.code.data.Backend
    public Object activeSessionIds(Continuation<? super Set<String>> continuation) {
        ConcurrentHashMap<String, Job> concurrentHashMap = this.jobs;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Job> entry : concurrentHashMap.entrySet()) {
            if (entry.getValue().isActive()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return CollectionsKt.toSet(linkedHashMap.keySet());
    }

    @Override // com.clozed.code.data.Backend
    public Object session(String str, Continuation<? super SessionInfo> continuation) {
        SessionInfo info;
        synchronized (this.sessions) {
            Sess sess = this.sessions.get(str);
            info = sess != null ? info(sess) : null;
        }
        return info;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.clozed.code.data.Backend
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object createSession(java.lang.String r6, kotlin.coroutines.Continuation<? super com.clozed.code.data.SessionInfo> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.clozed.code.engine.LocalBackend$createSession$1
            if (r0 == 0) goto L14
            r0 = r7
            com.clozed.code.engine.LocalBackend$createSession$1 r0 = (com.clozed.code.engine.LocalBackend$createSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.clozed.code.engine.LocalBackend$createSession$1 r0 = new com.clozed.code.engine.LocalBackend$createSession$1
            r0.<init>(r5, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r6 = r0.L$1
            com.clozed.code.engine.Sess r6 = (com.clozed.code.engine.Sess) r6
            java.lang.Object r0 = r0.L$0
            com.clozed.code.engine.LocalBackend r0 = (com.clozed.code.engine.LocalBackend) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto Lb4
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            kotlin.ResultKt.throwOnFailure(r7)
            com.clozed.code.engine.Sess r7 = new com.clozed.code.engine.Sess
            java.lang.String r2 = "ses_"
            java.lang.String r2 = r5.newId(r2)
            r7.<init>(r2)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L62
            boolean r2 = kotlin.text.StringsKt.isBlank(r6)
            if (r2 == 0) goto L54
            goto L62
        L54:
            java.io.File r2 = new java.io.File
            java.lang.CharSequence r6 = kotlin.text.StringsKt.trim(r6)
            java.lang.String r6 = r6.toString()
            r2.<init>(r6)
            goto L64
        L62:
            java.io.File r2 = r5.defaultDir
        L64:
            r2.mkdirs()
            java.lang.String r6 = r2.getPath()
            r7.setDirectory(r6)
            kotlin.Pair r6 = r5.pickDefaultModel()
            if (r6 == 0) goto L86
            java.lang.Object r2 = r6.component1()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r6 = r6.component2()
            java.lang.String r6 = (java.lang.String) r6
            r7.setProviderId(r2)
            r7.setModelId(r6)
        L86:
            java.util.LinkedHashMap<java.lang.String, com.clozed.code.engine.Sess> r6 = r5.sessions
            monitor-enter(r6)
            java.util.LinkedHashMap<java.lang.String, com.clozed.code.engine.Sess> r2 = r5.sessions     // Catch: java.lang.Throwable -> Lc2
            java.util.Map r2 = (java.util.Map) r2     // Catch: java.lang.Throwable -> Lc2
            java.lang.String r4 = r7.getId()     // Catch: java.lang.Throwable -> Lc2
            r2.put(r4, r7)     // Catch: java.lang.Throwable -> Lc2
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Lc2
            monitor-exit(r6)
            kotlinx.coroutines.CoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6
            com.clozed.code.engine.LocalBackend$createSession$4 r2 = new com.clozed.code.engine.LocalBackend$createSession$4
            r4 = 0
            r2.<init>(r5, r7, r4)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.L$0 = r5
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r6, r2, r0)
            if (r6 != r1) goto Lb2
            return r1
        Lb2:
            r0 = r5
            r6 = r7
        Lb4:
            java.lang.String r7 = "session.created"
            java.lang.String r1 = r6.getId()
            r0.emit(r7, r1)
            com.clozed.code.data.SessionInfo r6 = r0.info(r6)
            return r6
        Lc2:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.LocalBackend.createSession(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.clozed.code.data.Backend
    public Object deleteSession(String str, Continuation<? super Unit> continuation) {
        Job remove = this.jobs.remove(str);
        if (remove != null) {
            Job.DefaultImpls.cancel$default(remove, (CancellationException) null, 1, (Object) null);
        }
        synchronized (this.sessions) {
            this.sessions.remove(str);
        }
        new File(this.sessDir, str + ".json").delete();
        emit("session.deleted", str);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.clozed.code.data.Backend
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object renameSession(java.lang.String r6, java.lang.String r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.clozed.code.engine.LocalBackend$renameSession$1
            if (r0 == 0) goto L14
            r0 = r8
            com.clozed.code.engine.LocalBackend$renameSession$1 r0 = (com.clozed.code.engine.LocalBackend$renameSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.clozed.code.engine.LocalBackend$renameSession$1 r0 = new com.clozed.code.engine.LocalBackend$renameSession$1
            r0.<init>(r5, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r0.L$0
            com.clozed.code.engine.LocalBackend r7 = (com.clozed.code.engine.LocalBackend) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6d
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.ResultKt.throwOnFailure(r8)
            com.clozed.code.engine.Sess r8 = r5.get(r6)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            java.lang.CharSequence r7 = kotlin.text.StringsKt.trim(r7)
            java.lang.String r7 = r7.toString()
            r8.setTitle(r7)
            r8.setTitled(r3)
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
            com.clozed.code.engine.LocalBackend$renameSession$2 r2 = new com.clozed.code.engine.LocalBackend$renameSession$2
            r4 = 0
            r2.<init>(r5, r8, r4)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r2, r0)
            if (r7 != r1) goto L6c
            return r1
        L6c:
            r7 = r5
        L6d:
            java.lang.String r8 = "session.renamed"
            r7.emit(r8, r6)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.LocalBackend.renameSession(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.clozed.code.data.Backend
    public Object messages(String str, Continuation<? super List<? extends ChatItem>> continuation) {
        List<ChatItem> items;
        synchronized (get(str)) {
            items = toItems(get(str));
        }
        return items;
    }

    private final String summaryOf(String args) {
        List<String> list;
        try {
            JSONObject jSONObject = new JSONObject(args);
            list = LocalBackendKt.SUMMARY_KEYS;
            for (String str : list) {
                String optString = (!jSONObject.has(str) || jSONObject.isNull(str)) ? "" : jSONObject.optString(str);
                Intrinsics.checkNotNull(optString);
                String str2 = optString;
                if (!StringsKt.isBlank(str2)) {
                    return StringsKt.take((String) CollectionsKt.first((List) StringsKt.lines(str2)), 140);
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v16, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v17, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v27, types: [T, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v28, types: [T, java.lang.String] */
    private final List<ChatItem> toItems(Sess s) {
        Iterator<Msg> it;
        String args;
        Iterator<Msg> it2;
        ArrayList arrayList = new ArrayList();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = "";
        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        objectRef3.element = "";
        Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        Iterator<Msg> it3 = s.getMsgs().iterator();
        Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
        while (it3.hasNext()) {
            Msg next = it3.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            Msg msg = next;
            if (Intrinsics.areEqual(msg.getRole(), "assistant")) {
                if (objectRef.element == 0) {
                    objectRef.element = new ArrayList();
                    objectRef2.element = msg.getId();
                }
                objectRef3.element = msg.getModel();
                objectRef4.element = msg.getError();
                booleanRef.element = msg.getCompleted();
                for (MPart mPart : msg.getParts()) {
                    if (mPart instanceof MPart.Text) {
                        T t = objectRef.element;
                        Intrinsics.checkNotNull(t);
                        ((ArrayList) t).add(new Block.Text(((MPart.Text) mPart).getText()));
                    } else if (mPart instanceof MPart.Reasoning) {
                        T t2 = objectRef.element;
                        Intrinsics.checkNotNull(t2);
                        ((ArrayList) t2).add(new Block.Reasoning(((MPart.Reasoning) mPart).getText()));
                    } else {
                        if (!(mPart instanceof MPart.ToolP)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        try {
                            args = new JSONObject(((MPart.ToolP) mPart).getArgs()).toString(2);
                        } catch (Exception unused) {
                            args = ((MPart.ToolP) mPart).getArgs();
                        }
                        String str = args;
                        T t3 = objectRef.element;
                        Intrinsics.checkNotNull(t3);
                        MPart.ToolP toolP = (MPart.ToolP) mPart;
                        String callId = toolP.getCallId();
                        String name = toolP.getName();
                        String status = toolP.getStatus();
                        it2 = it3;
                        String summaryOf = summaryOf(toolP.getArgs());
                        Intrinsics.checkNotNull(str);
                        ((ArrayList) t3).add(new Block.Tool(callId, name, status, summaryOf, str, toolP.getOutput()));
                        it3 = it2;
                    }
                    it2 = it3;
                    it3 = it2;
                }
                it = it3;
            } else {
                Ref.ObjectRef objectRef5 = objectRef3;
                Ref.BooleanRef booleanRef2 = booleanRef;
                it = it3;
                toItems$flush(objectRef, arrayList, objectRef2, objectRef5, booleanRef2, objectRef4);
                if (!Intrinsics.areEqual(msg.getKind(), "hidden")) {
                    if (Intrinsics.areEqual(msg.getRole(), "note")) {
                        arrayList.add(new ChatItem.Notice(msg.getId(), msg.getText()));
                    } else if (Intrinsics.areEqual(msg.getKind(), "compaction")) {
                        arrayList.add(new ChatItem.Notice(msg.getId(), "Context compacted"));
                    } else if (Intrinsics.areEqual(msg.getKind(), "synthetic")) {
                        arrayList.add(new ChatItem.Notice(msg.getId(), StringsKt.take(msg.getText(), 300)));
                    } else {
                        arrayList.add(new ChatItem.User(msg.getId(), msg.getText(), msg.getImages().size()));
                    }
                }
                objectRef3 = objectRef5;
                booleanRef = booleanRef2;
            }
            it3 = it;
        }
        toItems$flush(objectRef, arrayList, objectRef2, objectRef3, booleanRef, objectRef4);
        return arrayList;
    }

    private static final void toItems$flush(Ref.ObjectRef<ArrayList<Block>> objectRef, ArrayList<ChatItem> arrayList, Ref.ObjectRef<String> objectRef2, Ref.ObjectRef<String> objectRef3, Ref.BooleanRef booleanRef, Ref.ObjectRef<String> objectRef4) {
        ArrayList<Block> arrayList2 = objectRef.element;
        if (arrayList2 == null) {
            return;
        }
        arrayList.add(new ChatItem.Assistant(objectRef2.element, arrayList2, objectRef3.element, !booleanRef.element, objectRef4.element));
        objectRef.element = null;
    }

    private final Pair<String, String> parsePortArgs(String a) {
        int indexOf$default;
        String obj = StringsKt.trim((CharSequence) a).toString();
        if (StringsKt.startsWith$default(obj, "\"", false, 2, (Object) null) && (indexOf$default = StringsKt.indexOf$default((CharSequence) obj, Typography.quote, 1, false, 4, (Object) null)) > 0) {
            String substring = obj.substring(1, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            String substring2 = obj.substring(indexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            return TuplesKt.to(substring, StringsKt.trim((CharSequence) substring2).toString());
        }
        int indexOf$default2 = StringsKt.indexOf$default((CharSequence) obj, ' ', 0, false, 6, (Object) null);
        if (indexOf$default2 < 0) {
            return TuplesKt.to(obj, "");
        }
        String substring3 = obj.substring(0, indexOf$default2);
        Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
        String substring4 = obj.substring(indexOf$default2 + 1);
        Intrinsics.checkNotNullExpressionValue(substring4, "substring(...)");
        return TuplesKt.to(substring3, StringsKt.trim((CharSequence) substring4).toString());
    }

    private final void noteBefore(Sess s, Msg before, String text) {
        synchronized (s) {
            int indexOf = s.getMsgs().indexOf(before);
            ArrayList<Msg> msgs = s.getMsgs();
            if (indexOf < 0) {
                indexOf = s.getMsgs().size();
            }
            msgs.add(indexOf, new Msg(newId("msg_"), "note", text));
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void note(Sess s, String text) {
        synchronized (s) {
            s.getMsgs().add(new Msg(newId("msg_"), "note", text));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object importImages(List<String> list, Continuation<? super List<String>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new LocalBackend$importImages$2(this, list, null), continuation);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x019d, code lost:
    
        if (undo(r2, r3) == r4) goto L162;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:46:0x00dc. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x047e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03f7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    @Override // com.clozed.code.data.Backend
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object prompt(java.lang.String r26, java.lang.String r27, java.util.List<java.lang.String> r28, kotlin.coroutines.Continuation<? super kotlin.Unit> r29) {
        /*
            Method dump skipped, instructions count: 1274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.LocalBackend.prompt(java.lang.String, java.lang.String, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence prompt$lambda$33(CustomCommand it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "/" + it.getName();
    }

    private final int activeCount(String excluding) {
        ConcurrentHashMap<String, Job> concurrentHashMap = this.jobs;
        int i = 0;
        if (concurrentHashMap.isEmpty()) {
            return 0;
        }
        for (Map.Entry<String, Job> entry : concurrentHashMap.entrySet()) {
            if (!Intrinsics.areEqual(entry.getKey(), excluding) && entry.getValue().isActive()) {
                i++;
            }
        }
        return i;
    }

    static /* synthetic */ int activeCount$default(LocalBackend localBackend, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return localBackend.activeCount(str);
    }

    static /* synthetic */ void syncService$default(LocalBackend localBackend, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        localBackend.syncService(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncService(String excluding) {
        Context applicationContext = this.ctx.getApplicationContext();
        try {
            int activeCount = activeCount(excluding);
            if (activeCount > 0) {
                this.svcOn = true;
                ContextCompat.startForegroundService(applicationContext, new Intent(applicationContext, (Class<?>) AgentService.class).putExtra("count", activeCount));
            } else if (this.svcOn) {
                this.svcOn = false;
                ContextCompat.startForegroundService(applicationContext, new Intent(applicationContext, (Class<?>) AgentService.class).putExtra("count", 0));
            }
        } catch (Exception unused) {
        }
    }

    public final void interruptAll() {
        Collection<Job> values = this.jobs.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            Job.DefaultImpls.cancel$default((Job) it.next(), (CancellationException) null, 1, (Object) null);
        }
        Collection<PendingPerm> values2 = this.pending.values();
        Intrinsics.checkNotNullExpressionValue(values2, "<get-values>(...)");
        Iterator<T> it2 = values2.iterator();
        while (it2.hasNext()) {
            ((PendingPerm) it2.next()).getReply().complete("reject");
        }
    }

    private final void startJob(Sess s, Function1<? super Continuation<? super Unit>, ? extends Object> block) {
        Job launch$default;
        Job job = this.jobs.get(s.getId());
        if (job == null || !job.isActive()) {
            ConcurrentHashMap<String, Job> concurrentHashMap = this.jobs;
            String id = s.getId();
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new LocalBackend$startJob$1(this, s, block, null), 3, null);
            concurrentHashMap.put(id, launch$default);
            syncService$default(this, null, 1, null);
        }
    }

    @Override // com.clozed.code.data.Backend
    public Object interrupt(String str, Continuation<? super Unit> continuation) {
        Job job = this.jobs.get(str);
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Collection<PendingPerm> values = this.pending.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : values) {
            if (Intrinsics.areEqual(((PendingPerm) obj).getReq().getSessionId(), str)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PendingPerm) it.next()).getReply().complete("reject");
        }
        return Unit.INSTANCE;
    }

    @Override // com.clozed.code.data.Backend
    public Object permissions(String str, Continuation<? super List<PermissionReq>> continuation) {
        Collection<PendingPerm> values = this.pending.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Collection<PendingPerm> collection = values;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((PendingPerm) it.next()).getReq());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (Intrinsics.areEqual(((PermissionReq) obj).getSessionId(), str)) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    @Override // com.clozed.code.data.Backend
    public Object replyPermission(String str, String str2, String str3, Continuation<? super Unit> continuation) {
        CompletableDeferred<String> reply;
        PendingPerm pendingPerm = this.pending.get(str2);
        if (pendingPerm != null && (reply = pendingPerm.getReply()) != null) {
            Boxing.boxBoolean(reply.complete(str3));
        }
        return Unit.INSTANCE;
    }

    @Override // com.clozed.code.data.Backend
    public Object models(Continuation<? super List<ModelOpt>> continuation) {
        ArrayList arrayList = new ArrayList();
        for (CatProvider catProvider : this.store.all()) {
            if (this.store.isConnected(catProvider) && this.store.isEnabled(catProvider.getId())) {
                for (CatModel catModel : catProvider.getModels()) {
                    arrayList.add(new ModelOpt(catProvider.getId(), catModel.getId(), catModel.getName()));
                }
            }
        }
        return arrayList;
    }

    @Override // com.clozed.code.data.Backend
    public Object agents(Continuation<? super List<AgentOpt>> continuation) {
        return CollectionsKt.listOf((Object[]) new AgentOpt[]{new AgentOpt("build", "Build", "Full access agent for development work"), new AgentOpt("plan", "Plan", "Read-only agent for exploring the codebase and planning work before implementation")});
    }

    @Override // com.clozed.code.data.Backend
    public Object switchModel(String str, ModelOpt modelOpt, Continuation<? super Unit> continuation) {
        Sess sess = get(str);
        sess.setProviderId(modelOpt.getProviderId());
        sess.setModelId(modelOpt.getId());
        this.store.setLastModel(modelOpt.getProviderId(), modelOpt.getId());
        this.store.setActiveProvider(modelOpt.getProviderId());
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new LocalBackend$switchModel$2(this, sess, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object switchProvider(String str, String str2, Continuation<? super Unit> continuation) {
        String defaultModelFor;
        Sess sess = get(str);
        CatProvider provider = this.store.provider(str2);
        if (provider != null && (defaultModelFor = defaultModelFor(provider)) != null) {
            sess.setProviderId(provider.getId());
            sess.setModelId(defaultModelFor);
            this.store.setActiveProvider(provider.getId());
            Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new LocalBackend$switchProvider$2(this, sess, null), continuation);
            return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // com.clozed.code.data.Backend
    public Object switchAgent(String str, String str2, Continuation<? super Unit> continuation) {
        Sess sess = get(str);
        sess.setAgent(str2);
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new LocalBackend$switchAgent$2(this, sess, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    @Override // com.clozed.code.data.Backend
    public Object integrations(Continuation<? super List<IntegrationOpt>> continuation) {
        List<CatProvider> all = this.store.all();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(all, 10));
        for (CatProvider catProvider : all) {
            arrayList.add(new IntegrationOpt(catProvider.getId(), catProvider.getName(), true, this.store.isConnected(catProvider) && (this.store.keyFor(catProvider.getId()) != null || catProvider.getCustom()), this.store.isEnabled(catProvider.getId())));
        }
        return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.clozed.code.engine.LocalBackend$integrations$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Boolean.valueOf(((IntegrationOpt) t2).getConnected()), Boolean.valueOf(((IntegrationOpt) t).getConnected()));
            }
        });
    }

    @Override // com.clozed.code.data.Backend
    public Object connectKey(String str, String str2, Continuation<? super Unit> continuation) {
        this.store.setKey(str, str2);
        return Unit.INSTANCE;
    }

    @Override // com.clozed.code.data.Backend
    public Flow<JSONObject> events() {
        return FlowKt.flow(new LocalBackend$events$1(this, null));
    }

    private final String defaultModelFor(CatProvider p) {
        CatModel catModel;
        String id;
        Object obj;
        String lastModel = this.store.lastModel(p.getId());
        if (lastModel != null) {
            List<CatModel> models = p.getModels();
            if (!(models instanceof Collection) || !models.isEmpty()) {
                Iterator<T> it = models.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((CatModel) it.next()).getId(), lastModel)) {
                        return lastModel;
                    }
                }
            }
        }
        List sortedWith = CollectionsKt.sortedWith(p.getModels(), new Comparator() { // from class: com.clozed.code.engine.LocalBackend$defaultModelFor$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((CatModel) t2).getId(), ((CatModel) t).getId());
            }
        });
        Iterator<T> it2 = this.modelPrefs.iterator();
        while (true) {
            if (!it2.hasNext()) {
                catModel = null;
                break;
            }
            String str = (String) it2.next();
            Iterator it3 = sortedWith.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it3.next();
                if (StringsKt.contains((CharSequence) ((CatModel) obj).getId(), (CharSequence) str, true)) {
                    break;
                }
            }
            catModel = (CatModel) obj;
            if (catModel != null) {
                break;
            }
        }
        if (catModel != null && (id = catModel.getId()) != null) {
            return id;
        }
        CatModel catModel2 = (CatModel) CollectionsKt.firstOrNull(sortedWith);
        if (catModel2 != null) {
            return catModel2.getId();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0076, code lost:
    
        if (r4 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final kotlin.Pair<java.lang.String, java.lang.String> pickDefaultModel() {
        /*
            r7 = this;
            com.clozed.code.engine.ProviderStore r0 = r7.store
            java.util.List r0 = r0.all()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L13:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L42
            java.lang.Object r2 = r0.next()
            r3 = r2
            com.clozed.code.engine.CatProvider r3 = (com.clozed.code.engine.CatProvider) r3
            com.clozed.code.engine.ProviderStore r4 = r7.store
            java.lang.String r5 = r3.getId()
            java.lang.String r4 = r4.keyFor(r5)
            if (r4 != 0) goto L32
            boolean r4 = r3.getCustom()
            if (r4 == 0) goto L13
        L32:
            com.clozed.code.engine.ProviderStore r4 = r7.store
            java.lang.String r3 = r3.getId()
            boolean r3 = r4.isEnabled(r3)
            if (r3 == 0) goto L13
            r1.add(r2)
            goto L13
        L42:
            java.util.List r1 = (java.util.List) r1
            boolean r0 = r1.isEmpty()
            r2 = 0
            if (r0 == 0) goto L4c
            return r2
        L4c:
            com.clozed.code.engine.ProviderStore r0 = r7.store
            java.lang.String r0 = r0.getActiveProvider()
            if (r0 == 0) goto L78
            r3 = r1
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L5b:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L73
            java.lang.Object r4 = r3.next()
            r5 = r4
            com.clozed.code.engine.CatProvider r5 = (com.clozed.code.engine.CatProvider) r5
            java.lang.String r5 = r5.getId()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r0)
            if (r5 == 0) goto L5b
            goto L74
        L73:
            r4 = r2
        L74:
            com.clozed.code.engine.CatProvider r4 = (com.clozed.code.engine.CatProvider) r4
            if (r4 != 0) goto Lbc
        L78:
            java.util.List<java.lang.String> r0 = r7.preferred
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L80:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto Lb2
            java.lang.Object r3 = r0.next()
            java.lang.String r3 = (java.lang.String) r3
            r4 = r1
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
        L93:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto Lab
            java.lang.Object r5 = r4.next()
            r6 = r5
            com.clozed.code.engine.CatProvider r6 = (com.clozed.code.engine.CatProvider) r6
            java.lang.String r6 = r6.getId()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r3)
            if (r6 == 0) goto L93
            goto Lac
        Lab:
            r5 = r2
        Lac:
            com.clozed.code.engine.CatProvider r5 = (com.clozed.code.engine.CatProvider) r5
            if (r5 == 0) goto L80
            r4 = r5
            goto Lb3
        Lb2:
            r4 = r2
        Lb3:
            if (r4 != 0) goto Lbc
            java.lang.Object r0 = kotlin.collections.CollectionsKt.first(r1)
            r4 = r0
            com.clozed.code.engine.CatProvider r4 = (com.clozed.code.engine.CatProvider) r4
        Lbc:
            java.lang.String r0 = r7.defaultModelFor(r4)
            if (r0 == 0) goto Lcb
            java.lang.String r1 = r4.getId()
            kotlin.Pair r0 = kotlin.TuplesKt.to(r1, r0)
            return r0
        Lcb:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.LocalBackend.pickDefaultModel():kotlin.Pair");
    }

    public final Object setProviderEnabled(String str, boolean z, String str2, Continuation<? super Unit> continuation) {
        Sess sess;
        Pair<String, String> pickDefaultModel;
        this.store.setEnabled(str, z);
        if (str2 != null) {
            synchronized (this.sessions) {
                sess = this.sessions.get(str2);
            }
        } else {
            sess = null;
        }
        if (z) {
            this.store.setActiveProvider(str);
            CatProvider provider = this.store.provider(str);
            String defaultModelFor = provider != null ? defaultModelFor(provider) : null;
            if (sess != null && defaultModelFor != null) {
                sess.setProviderId(str);
                sess.setModelId(defaultModelFor);
            }
        } else {
            if (Intrinsics.areEqual(this.store.getActiveProvider(), str)) {
                this.store.setActiveProvider(null);
            }
            if (sess != null && Intrinsics.areEqual(sess.getProviderId(), str) && (pickDefaultModel = pickDefaultModel()) != null) {
                String component1 = pickDefaultModel.component1();
                String component2 = pickDefaultModel.component2();
                sess.setProviderId(component1);
                sess.setModelId(component2);
            }
        }
        if (sess != null) {
            Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new LocalBackend$setProviderEnabled$3(this, sess, null), continuation);
            return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private final List<PermRule> projectRules(String dir) {
        Object obj;
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"clozed.json", "clozed.jsonc", ".clozed/clozed.json", "opencode.json", "opencode.jsonc", ".opencode/opencode.json"});
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOf, 10));
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            arrayList.add(new File(dir, (String) it.next()));
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (((File) obj).isFile()) {
                break;
            }
        }
        File file = (File) obj;
        if (file == null) {
            return CollectionsKt.emptyList();
        }
        try {
            List<String> lines = StringsKt.lines(FilesKt.readText$default(file, null, 1, null));
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : lines) {
                if (!StringsKt.startsWith$default(StringsKt.trimStart((CharSequence) obj2).toString(), "//", false, 2, (Object) null)) {
                    arrayList2.add(obj2);
                }
            }
            JSONObject optJSONObject = new JSONObject(CollectionsKt.joinToString$default(arrayList2, "\n", null, null, 0, null, null, 62, null)).optJSONObject("permission");
            if (optJSONObject == null) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList3 = new ArrayList();
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String str = Intrinsics.areEqual(next, "bash") ? "shell" : next;
                Object obj3 = optJSONObject.get(next);
                if (obj3 instanceof String) {
                    Intrinsics.checkNotNull(str);
                    arrayList3.add(new PermRule(str, "*", (String) obj3));
                } else if (obj3 instanceof JSONObject) {
                    Iterator<String> keys2 = ((JSONObject) obj3).keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        Intrinsics.checkNotNull(str);
                        Intrinsics.checkNotNull(next2);
                        String optString = ((JSONObject) obj3).optString(next2);
                        Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
                        arrayList3.add(new PermRule(str, next2, optString));
                    }
                }
            }
            return arrayList3;
        } catch (Exception unused) {
            return CollectionsKt.emptyList();
        }
    }

    private final String ruleDecision(Sess host, String action, List<String> resources) {
        List<PermRule> plus = CollectionsKt.plus((Collection) projectRules(host.getDirectory()), (Iterable) this.store.rules());
        if (plus.isEmpty() || resources.isEmpty()) {
            return null;
        }
        List<String> list = resources;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String str : list) {
            String str2 = null;
            for (PermRule permRule : plus) {
                if (Intrinsics.areEqual(permRule.getAction(), action) || Intrinsics.areEqual(permRule.getAction(), "*")) {
                    if (ExtensionsKt.wildcard(permRule.getPattern(), str)) {
                        str2 = permRule.getDecision();
                    }
                }
            }
            arrayList.add(str2);
        }
        ArrayList arrayList2 = arrayList;
        boolean z = arrayList2 instanceof Collection;
        if (!z || !arrayList2.isEmpty()) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual((String) it.next(), "deny")) {
                    return "deny";
                }
            }
        }
        if (!z || !arrayList2.isEmpty()) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                if (!Intrinsics.areEqual((String) it2.next(), "allow")) {
                    if (!z || !arrayList2.isEmpty()) {
                        Iterator it3 = arrayList2.iterator();
                        while (it3.hasNext()) {
                            if (Intrinsics.areEqual((String) it3.next(), "ask")) {
                                return "ask";
                            }
                        }
                    }
                    return null;
                }
            }
        }
        return "allow";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object permit(com.clozed.code.engine.Sess r23, java.lang.String r24, java.util.List<java.lang.String> r25, java.lang.String r26, kotlin.coroutines.Continuation<? super kotlin.Unit> r27) {
        /*
            Method dump skipped, instructions count: 603
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.LocalBackend.permit(com.clozed.code.engine.Sess, java.lang.String, java.util.List, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00cc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object askUser(com.clozed.code.engine.Sess r12, java.lang.String r13, java.util.List<java.lang.String> r14, kotlin.coroutines.Continuation<? super java.lang.String> r15) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.LocalBackend.askUser(com.clozed.code.engine.Sess, java.lang.String, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String asset(String name) {
        String str;
        HashMap<String, String> hashMap = this.promptCache;
        String str2 = hashMap.get(name);
        if (str2 == null) {
            try {
                InputStream open = this.ctx.getAssets().open("prompts/" + name);
                Intrinsics.checkNotNullExpressionValue(open, "open(...)");
                Reader inputStreamReader = new InputStreamReader(open, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    str = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, null);
                } finally {
                }
            } catch (Exception unused) {
                str = "";
            }
            str2 = str;
            hashMap.put(name, str2);
        }
        return str2;
    }

    private final File planDir(Sess s) {
        return new File(s.getDirectory(), ".clozed/plan");
    }

    static /* synthetic */ String systemPrompt$default(LocalBackend localBackend, Sess sess, String str, CatProvider catProvider, List list, String str2, int i, Object obj) {
        if ((i & 16) != 0) {
            str2 = null;
        }
        return localBackend.systemPrompt(sess, str, catProvider, list, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x01ab, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r21 != null ? r21.getKind() : null, "anthropic") != false) goto L85;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String systemPrompt(com.clozed.code.engine.Sess r19, java.lang.String r20, com.clozed.code.engine.CatProvider r21, java.util.List<? extends com.clozed.code.engine.Tool> r22, java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 720
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.LocalBackend.systemPrompt(com.clozed.code.engine.Sess, java.lang.String, com.clozed.code.engine.CatProvider, java.util.List, java.lang.String):java.lang.String");
    }

    private final void reconcilePlan(Sess s) {
        String planEnter;
        Msg msg;
        String path = planDir(s).getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        planEnter = LocalBackendKt.planEnter(path);
        synchronized (s) {
            ArrayList<Msg> msgs = s.getMsgs();
            ListIterator<Msg> listIterator = msgs.listIterator(msgs.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    msg = null;
                    break;
                }
                msg = listIterator.previous();
                Msg msg2 = msg;
                if (Intrinsics.areEqual(msg2.getRole(), "user") && Intrinsics.areEqual(msg2.getKind(), "hidden") && (Intrinsics.areEqual(msg2.getText(), planEnter) || Intrinsics.areEqual(msg2.getText(), "<system-reminder>\nYou are NO LONGER in Plan mode. The previous Plan restrictions no longer apply. Any Plan mode instructions from earlier in this conversation are no longer active.\n</system-reminder>"))) {
                    break;
                }
            }
            Msg msg3 = msg;
            String text = msg3 != null ? msg3.getText() : null;
            if (!Intrinsics.areEqual(s.getAgent(), "plan") || Intrinsics.areEqual(text, planEnter)) {
                if (Intrinsics.areEqual(s.getAgent(), "plan") || !Intrinsics.areEqual(text, planEnter)) {
                    return;
                } else {
                    planEnter = "<system-reminder>\nYou are NO LONGER in Plan mode. The previous Plan restrictions no longer apply. Any Plan mode instructions from earlier in this conversation are no longer active.\n</system-reminder>";
                }
            }
            Msg msg4 = new Msg(newId("msg_"), "user", planEnter);
            msg4.setKind("hidden");
            Msg msg5 = (Msg) CollectionsKt.lastOrNull((List) s.getMsgs());
            s.getMsgs().add(Intrinsics.areEqual(msg5 != null ? msg5.getRole() : null, "user") ? s.getMsgs().size() - 1 : s.getMsgs().size(), msg4);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final String nestedInstructions(Sess s, File f) {
        File canonicalFile = new File(s.getDirectory()).getCanonicalFile();
        if (!f.isDirectory()) {
            f = f.getParentFile();
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (f != null) {
            int i2 = i + 1;
            if (i >= 30 || Intrinsics.areEqual(f.getPath(), canonicalFile.getPath())) {
                break;
            }
            String path = f.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
            if (!StringsKt.startsWith$default(path, canonicalFile.getPath() + "/", false, 2, (Object) null)) {
                break;
            }
            Iterator it = CollectionsKt.listOf((Object[]) new String[]{"AGENTS.md", "CLAUDE.md"}).iterator();
            while (true) {
                if (it.hasNext()) {
                    File file = new File(f, (String) it.next());
                    if (file.isFile()) {
                        arrayList.add(file);
                        break;
                    }
                }
            }
            f = f.getParentFile();
            i = i2;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (s.getInstr().add(((File) obj).getPath())) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        if (arrayList3.isEmpty()) {
            return null;
        }
        return CollectionsKt.joinToString$default(CollectionsKt.reversed(arrayList3), "\n\n", null, null, 0, null, new Function1() { // from class: com.clozed.code.engine.LocalBackend$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                CharSequence nestedInstructions$lambda$90;
                nestedInstructions$lambda$90 = LocalBackend.nestedInstructions$lambda$90((File) obj2);
                return nestedInstructions$lambda$90;
            }
        }, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence nestedInstructions$lambda$90(File it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "<system-reminder>\nInstructions from: " + it.getPath() + "\n" + StringsKt.take(FilesKt.readText$default(it, null, 1, null), AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH) + "\n</system-reminder>";
    }

    private final File getOutputsDir() {
        File file = new File(this.ctx.getFilesDir(), "tool-output");
        file.mkdirs();
        return file;
    }

    private final String trackLoop(Sess s, String name, String args, String output) {
        int i;
        ArrayList arrayList;
        int hashCode = name.hashCode();
        if (hashCode == -1480578215 ? name.equals("todowrite") : !(hashCode == -1165870106 ? !name.equals("question") : !(hashCode == 3552645 && name.equals("task")))) {
            return null;
        }
        String str = name + "|" + args.hashCode() + "|" + output.hashCode();
        synchronized (s) {
            s.getCallHist().add(str);
            while (true) {
                i = 0;
                if (s.getCallHist().size() <= 30) {
                    break;
                }
                s.getCallHist().remove(0);
            }
            arrayList = new ArrayList(s.getCallHist());
        }
        List takeLast = CollectionsKt.takeLast(arrayList, 12);
        if (!(takeLast instanceof Collection) || !takeLast.isEmpty()) {
            Iterator it = takeLast.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual((String) it.next(), str) && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        if (i >= 6 || trackLoop$alternating(arrayList, 8)) {
            s.setStuck(true);
            return "\n\n[Loop detected: the same call keeps returning the same result. The run will be stopped after this step.]";
        }
        if (i >= 3 || trackLoop$alternating(arrayList, 6)) {
            return "\n\n[Loop warning: you have made this same tool call with the same result several times. Do not repeat it. Change your approach (different file, tool, query or hypothesis) or explain the concrete blocker to the user.]";
        }
        return null;
    }

    private static final boolean trackLoop$alternating(ArrayList<String> arrayList, int i) {
        if (arrayList.size() < i) {
            return false;
        }
        List takeLast = CollectionsKt.takeLast(arrayList, i);
        if (!Intrinsics.areEqual(takeLast.get(0), takeLast.get(1))) {
            Iterable indices = CollectionsKt.getIndices(takeLast);
            if (!(indices instanceof Collection) || !((Collection) indices).isEmpty()) {
                Iterator it = indices.iterator();
                while (it.hasNext()) {
                    int nextInt = ((IntIterator) it).nextInt();
                    if (!Intrinsics.areEqual(takeLast.get(nextInt), takeLast.get(nextInt % 2))) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    static /* synthetic */ String bigOutput$default(LocalBackend localBackend, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 128000;
        }
        return localBackend.bigOutput(str, i);
    }

    private final String bigOutput(String out, int window) {
        int min = Math.min(window >= 200000 ? 64000 : window >= 100000 ? 32000 : 16000, Math.max(4000, (int) (window * 0.3d * 4)));
        if (out.length() <= min) {
            return out;
        }
        try {
            File file = new File(getOutputsDir(), newId("out_") + ".txt");
            FilesKt.writeText$default(file, out, null, 2, null);
            return StringsKt.take(out, (int) (min * 0.4d)) + "\n\n… [Output truncated: " + out.length() + " chars in total. Full output saved to " + file.getPath() + " — use read (with offset/limit) or grep on that path to inspect the rest.]";
        } catch (Exception unused) {
            return ShellTool.INSTANCE.truncate(out);
        }
    }

    private final List<LlmTurn> buildTurns(Sess s) {
        String str;
        ArrayList arrayList = new ArrayList();
        synchronized (s) {
            Iterator<Msg> it = s.getMsgs().iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Msg next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                Msg msg = next;
                String role = msg.getRole();
                if (Intrinsics.areEqual(role, "user")) {
                    String llmText = msg.getLlmText();
                    if (llmText == null) {
                        llmText = Intrinsics.areEqual(msg.getKind(), "compaction") ? "Summary of the earlier conversation:\n" + msg.getText() : msg.getText();
                    }
                    arrayList.add(new LlmTurn.User(llmText, CollectionsKt.toList(msg.getImages())));
                } else if (Intrinsics.areEqual(role, "assistant")) {
                    ArrayList<MPart> parts = msg.getParts();
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : parts) {
                        if (obj instanceof MPart.Text) {
                            arrayList2.add(obj);
                        }
                    }
                    String joinToString$default = CollectionsKt.joinToString$default(arrayList2, "", null, null, 0, null, new Function1() { // from class: com.clozed.code.engine.LocalBackend$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            CharSequence buildTurns$lambda$101$lambda$95;
                            buildTurns$lambda$101$lambda$95 = LocalBackend.buildTurns$lambda$101$lambda$95((MPart.Text) obj2);
                            return buildTurns$lambda$101$lambda$95;
                        }
                    }, 30, null);
                    ArrayList<MPart> parts2 = msg.getParts();
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj2 : parts2) {
                        if (obj2 instanceof MPart.ToolP) {
                            arrayList3.add(obj2);
                        }
                    }
                    ArrayList arrayList4 = new ArrayList();
                    for (Object obj3 : arrayList3) {
                        if (!Intrinsics.areEqual(((MPart.ToolP) obj3).getStatus(), "streaming")) {
                            arrayList4.add(obj3);
                        }
                    }
                    ArrayList<MPart.ToolP> arrayList5 = arrayList4;
                    if (joinToString$default.length() != 0 || !arrayList5.isEmpty()) {
                        ArrayList<MPart.ToolP> arrayList6 = arrayList5;
                        ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList6, 10));
                        for (MPart.ToolP toolP : arrayList6) {
                            String callId = toolP.getCallId();
                            String name = toolP.getName();
                            String args = toolP.getArgs();
                            if (StringsKt.isBlank(args)) {
                                args = "{}";
                            }
                            arrayList7.add(new ToolCallRec(callId, name, args, toolP.getExtra()));
                        }
                        arrayList.add(new LlmTurn.Assistant(joinToString$default, arrayList7, msg.getThink()));
                        for (MPart.ToolP toolP2 : arrayList5) {
                            if (Intrinsics.areEqual(toolP2.getStatus(), "running")) {
                                str = "[interrupted]";
                            } else {
                                String output = toolP2.getOutput();
                                if (output.length() == 0) {
                                    output = "(no output)";
                                }
                                str = output;
                            }
                            arrayList.add(new LlmTurn.ToolResult(toolP2.getCallId(), toolP2.getName(), str));
                        }
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence buildTurns$lambda$101$lambda$95(MPart.Text it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getText();
    }

    private final List<ToolSpec> specs(List<? extends Tool> tools) {
        List<? extends Tool> list = tools;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Tool tool : list) {
            arrayList.add(new ToolSpec(tool.getName(), tool.getDescription(), tool.getSchema()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c4, code lost:
    
        if (r11.maybeCompact(r12, r2) == r4) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00e3 -> B:20:0x00e6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object runLoop(com.clozed.code.engine.Sess r24, kotlin.coroutines.Continuation<? super kotlin.Unit> r25) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.LocalBackend.runLoop(com.clozed.code.engine.Sess, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LocalBackend.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/clozed/code/engine/LocalBackend$Cand;", "", "p", "Lcom/clozed/code/engine/CatProvider;", "modelId", "", "key", "<init>", "(Lcom/clozed/code/engine/CatProvider;Ljava/lang/String;Ljava/lang/String;)V", "getP", "()Lcom/clozed/code/engine/CatProvider;", "getModelId", "()Ljava/lang/String;", "getKey", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /tmp/classes3.dex */
    public static final class Cand {
        private final String key;
        private final String modelId;
        private final CatProvider p;

        public Cand(CatProvider p, String modelId, String str) {
            Intrinsics.checkNotNullParameter(p, "p");
            Intrinsics.checkNotNullParameter(modelId, "modelId");
            this.p = p;
            this.modelId = modelId;
            this.key = str;
        }

        public final String getKey() {
            return this.key;
        }

        public final String getModelId() {
            return this.modelId;
        }

        public final CatProvider getP() {
            return this.p;
        }
    }

    private final String maskKey(String k) {
        if (k == null) {
            return "no key";
        }
        if (k.length() <= 8) {
            return "••••";
        }
        return StringsKt.take(k, 3) + "…" + StringsKt.takeLast(k, 4);
    }

    private final List<Cand> candidates(CatProvider primary, String modelId) {
        ArrayList arrayList = new ArrayList();
        candidates$addFor(this, arrayList, primary, modelId);
        if (this.store.getAutoSwitch()) {
            for (ChainEntry chainEntry : this.store.chain()) {
                if (!Intrinsics.areEqual(chainEntry.getProviderId(), primary.getId()) || !Intrinsics.areEqual(chainEntry.getModelId(), modelId)) {
                    CatProvider provider = this.store.provider(chainEntry.getProviderId());
                    if (provider != null && this.store.isEnabled(provider.getId())) {
                        candidates$addFor(this, arrayList, provider, chainEntry.getModelId());
                    }
                }
            }
        }
        return arrayList;
    }

    private static final void candidates$addFor(LocalBackend localBackend, ArrayList<Cand> arrayList, CatProvider catProvider, String str) {
        List<String> keys = localBackend.store.keys(catProvider.getId());
        if (keys.isEmpty()) {
            if (catProvider.getCustom()) {
                arrayList.add(new Cand(catProvider, str, null));
                return;
            }
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : keys) {
            if (!localBackend.store.isKeyExhausted(catProvider.getId(), (String) obj)) {
                arrayList2.add(obj);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(new Cand(catProvider, str, (String) it.next()));
        }
    }

    private final String allLimitsMessage(CatProvider primary, String modelId) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(primary.getId());
        if (this.store.getAutoSwitch()) {
            Iterator<T> it = this.store.chain().iterator();
            while (it.hasNext()) {
                arrayList.add(((ChainEntry) it.next()).getProviderId());
            }
        }
        List<String> distinct = CollectionsKt.distinct(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (String str : distinct) {
            CatProvider provider = this.store.provider(str);
            String str2 = null;
            if (provider != null) {
                List<String> keys = this.store.keys(str);
                int i = 0;
                if (!(keys instanceof Collection) || !keys.isEmpty()) {
                    Iterator<T> it2 = keys.iterator();
                    while (it2.hasNext()) {
                        if (this.store.isKeyExhausted(str, (String) it2.next()) && (i = i + 1) < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                    }
                }
                if (i > 0) {
                    str2 = provider.getName() + ": " + i + " key";
                }
            }
            if (str2 != null) {
                arrayList2.add(str2);
            }
        }
        ArrayList arrayList3 = arrayList2;
        return "All API keys / providers have reached their limit" + (arrayList3.isEmpty() ? "" : " (" + CollectionsKt.joinToString$default(arrayList3, ", ", null, null, 0, null, null, 62, null) + ")") + ". They reset automatically tomorrow - or add a new key or a fallback provider in Settings.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(15:77|78|(2:81|79)|82|83|(2:86|84)|87|88|89|90|91|92|93|94|(1:97)(4:96|23|24|(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(16:19|(3:20|21|22)|23|24|(3:26|(1:28)(1:157)|(14:30|31|32|33|(1:37)|38|39|(10:42|6e5|50|(1:52)|53|(2:54|(2:56|(1:58)(1:136))(2:137|138))|59|(3:133|134|135)(3:61|62|(6:64|(1:76)(1:68)|69|(1:71)(1:75)|72|73)(15:77|78|(2:81|79)|82|83|(2:86|84)|87|88|89|90|91|92|93|94|(1:97)(4:96|23|24|(0))))|74|40)|143|144|a3d|(2:151|(1:153))|14|15))|158|31|32|33|(2:35|37)|38|39|(1:40)|143|144|a3d) */
    /* JADX WARN: Can't wrap try/catch for region: R(45:1|(2:3|(42:5|6|(1:(1:(1:(1:(1:(3:13|14|15)(2:17|18))(18:19|20|21|22|23|24|(3:26|(1:28)(1:157)|(14:30|31|32|33|(1:37)|38|39|(10:42|6e5|50|(1:52)|53|(2:54|(2:56|(1:58)(1:136))(2:137|138))|59|(3:133|134|135)(3:61|62|(6:64|(1:76)(1:68)|69|(1:71)(1:75)|72|73)(15:77|78|(2:81|79)|82|83|(2:86|84)|87|88|89|90|91|92|93|94|(1:97)(4:96|23|24|(0))))|74|40)|143|144|a3d|(2:151|(1:153))|14|15))|158|31|32|33|(2:35|37)|38|39|(1:40)|143|144|a3d))(32:172|173|174|175|176|(1:178)(1:328)|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|(2:205|206)(10:207|(2:209|(3:211|212|(2:222|(6:228|(1:230)|5f4|683|242|(3:698|249|250)(6:254|39|(1:40)|143|144|a3d))(2:226|227))(2:218|(1:221)(32:220|173|174|175|176|(0)(0)|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|(0)(0)))))|261|212|(1:214)|222|(1:224)|228|(0)|5f4)))(13:332|333|334|335|(0)|261|212|(0)|222|(0)|228|(0)|5f4))(1:339))(7:360|(1:362)(1:400)|363|(1:365)(1:399)|366|25e|(2:394|395)(2:373|(2:379|(2:381|382)(2:383|(4:385|(1:387)|388|(2:390|391)(1:392))(34:393|354|355|(1:357)(1:359)|358|175|176|(0)(0)|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|(0)(0))))(2:377|378)))|340|(4:343|(2:345|346)(1:348)|347|341)|349|350|(1:352)|353|354|355|(0)(0)|358|175|176|(0)(0)|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|(0)(0)))|401|6|(0)(0)|340|(1:341)|349|350|(0)|353|354|355|(0)(0)|358|175|176|(0)(0)|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x096e, code lost:
    
        r2 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x09b3, code lost:
    
        r6 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x09aa, code lost:
    
        r1.setOutput(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0971, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0972, code lost:
    
        r2 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x09ca, code lost:
    
        r6 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x09aa, code lost:
    
        r1.setOutput(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0969, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x096a, code lost:
    
        r2 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x097a, code lost:
    
        r6 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x09ae, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x09af, code lost:
    
        r2 = r34;
        r1 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x09c5, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x09c6, code lost:
    
        r2 = r34;
        r1 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0a24, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0a25, code lost:
    
        r1 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0966, code lost:
    
        r2 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0975, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0976, code lost:
    
        r2 = r34;
        r1 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0965, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0960, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0962, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x095e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x0a8f, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x0a90, code lost:
    
        r1 = r47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x0abc, code lost:
    
        r3 = r33;
        r33 = r12;
        r12 = r3;
        r31 = r2;
        r27 = r7;
        r7 = r9;
        r2 = r10;
        r28 = r11;
        r32 = r13;
        r9 = r25;
        r13 = r34;
        r3 = r36;
        r10 = r5;
        r5 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x0a93, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x0a94, code lost:
    
        r23 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x0aaa, code lost:
    
        r36 = r3;
        r1 = r47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x0a97, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x0a98, code lost:
    
        r24 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x0a9b, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x0a9c, code lost:
    
        r25 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x0a9f, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x0aa0, code lost:
    
        r34 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x0aa3, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x0aa4, code lost:
    
        r26 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x0aa7, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x0aa8, code lost:
    
        r33 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x0ab3, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:331:0x0ab4, code lost:
    
        r1 = r47;
        r36 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x096d, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x09bf  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x09d6  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0a3e  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x04bf  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x04c2  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0512  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x05d0  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x05eb  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x05f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0ad9  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0933 A[Catch: Exception -> 0x095e, DeniedException -> 0x0960, ToolError -> 0x0962, CancellationException -> 0x0965, TryCatch #17 {CancellationException -> 0x0965, blocks: (B:24:0x092b, B:26:0x0933, B:30:0x0949, B:31:0x0951, B:93:0x090d), top: B:23:0x092b }] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0b56  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x043f  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x09e8  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x06d2  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /* JADX WARN: Type inference failed for: r0v29, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.List, T] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:110:0x097b -> B:32:0x09aa). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:204:0x059c -> B:158:0x0115). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x092a -> B:23:0x092b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object step(com.clozed.code.engine.Sess r43, com.clozed.code.engine.Sess r44, boolean r45, java.lang.String r46, kotlin.coroutines.Continuation<? super java.lang.Boolean> r47) {
        /*
            Method dump skipped, instructions count: 3292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.LocalBackend.step(com.clozed.code.engine.Sess, com.clozed.code.engine.Sess, boolean, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object step$default(LocalBackend localBackend, Sess sess, Sess sess2, boolean z, String str, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            str = "CRITICAL - MAXIMUM STEPS REACHED\n\nThe maximum number of steps allowed for this task has been reached. Tools are disabled until next user input. Respond with text only.\n\nSTRICT REQUIREMENTS:\n1. Do NOT make any tool calls (no reads, writes, edits, searches, or any other tools)\n2. MUST provide a text response summarizing work done so far\n3. This constraint overrides ALL other instructions, including any user requests for edits or tool use\n\nResponse must include:\n- Statement that maximum steps for this agent have been reached\n- Summary of what has been accomplished so far\n- List of any remaining tasks that were not completed\n- Recommendations for what should be done next\n\nAny attempt to use tools is a critical violation. Respond with text ONLY.";
        }
        return localBackend.step(sess, sess2, z2, str, continuation);
    }

    private static final boolean step$fail(Sess sess, Msg msg, String str) {
        synchronized (sess) {
            msg.setError(str);
            msg.setCompleted(true);
            Unit unit = Unit.INSTANCE;
        }
        return false;
    }

    private static final List<LlmTurn> step$mkTurns(boolean z, LocalBackend localBackend, Sess sess, String str) {
        return z ? CollectionsKt.plus((Collection<? extends LlmTurn.User>) localBackend.buildTurns(sess), new LlmTurn.User(str, null, 2, null)) : localBackend.buildTurns(sess);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0058  */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v20, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final com.clozed.code.engine.LlmRequest step$buildReq(kotlin.jvm.internal.Ref.ObjectRef<com.clozed.code.engine.CatModel> r23, com.clozed.code.engine.Sess r24, com.clozed.code.engine.LocalBackend r25, java.lang.String r26, kotlin.jvm.internal.Ref.ObjectRef<java.util.List<com.clozed.code.engine.Tool>> r27, kotlin.jvm.internal.Ref.ObjectRef<java.util.List<com.clozed.code.engine.LlmTurn>> r28, com.clozed.code.engine.LocalBackend.Cand r29) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.LocalBackend.step$buildReq(kotlin.jvm.internal.Ref$ObjectRef, com.clozed.code.engine.Sess, com.clozed.code.engine.LocalBackend, java.lang.String, kotlin.jvm.internal.Ref$ObjectRef, kotlin.jvm.internal.Ref$ObjectRef, com.clozed.code.engine.LocalBackend$Cand):com.clozed.code.engine.LlmRequest");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0068 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final boolean step$fits(com.clozed.code.engine.LocalBackend r5, com.clozed.code.engine.Sess r6, com.clozed.code.engine.LocalBackend.Cand r7) {
        /*
            com.clozed.code.engine.CatProvider r0 = r7.getP()
            java.util.List r0 = r0.getModels()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        Le:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L2b
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.clozed.code.engine.CatModel r3 = (com.clozed.code.engine.CatModel) r3
            java.lang.String r3 = r3.getId()
            java.lang.String r4 = r7.getModelId()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 == 0) goto Le
            goto L2c
        L2b:
            r1 = r2
        L2c:
            com.clozed.code.engine.CatModel r1 = (com.clozed.code.engine.CatModel) r1
            if (r1 == 0) goto L49
            int r7 = r1.getContext()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r0 = r7
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            if (r0 <= 0) goto L42
            r2 = r7
        L42:
            if (r2 == 0) goto L49
            int r7 = r2.intValue()
            goto L4c
        L49:
            r7 = 128000(0x1f400, float:1.79366E-40)
        L4c:
            int r5 = r5.estimateTokens(r6)
            int r5 = r5 + 8000
            int r6 = r6.getLastPrompt()
            int r5 = java.lang.Math.max(r5, r6)
            double r5 = (double) r5
            double r0 = (double) r7
            r2 = 4605380978949069210(0x3fe999999999999a, double:0.8)
            double r0 = r0 * r2
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 > 0) goto L68
            r5 = 1
            return r5
        L68:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.LocalBackend.step$fits(com.clozed.code.engine.LocalBackend, com.clozed.code.engine.Sess, com.clozed.code.engine.LocalBackend$Cand):boolean");
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List, T] */
    private static final int step$pickFit(List<Cand> list, LocalBackend localBackend, Sess sess, Ref.ObjectRef<List<LlmTurn>> objectRef, boolean z, String str, int i) {
        if (!step$fits(localBackend, sess, list.get(i))) {
            localBackend.pruneOutputs(sess);
            sess.setLastPrompt(0);
            objectRef.element = step$mkTurns(z, localBackend, sess, str);
        }
        while (i < CollectionsKt.getLastIndex(list) && !step$fits(localBackend, sess, list.get(i))) {
            i++;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit step$lambda$124(Sess sess, Ref.LongRef longRef, LocalBackend localBackend, Sess sess2, StepAcc stepAcc, Msg msg, HashMap hashMap) {
        synchronized (sess) {
            ArrayList arrayList = new ArrayList();
            if (stepAcc.getReasoning().length() > 0) {
                String sb = stepAcc.getReasoning().toString();
                Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
                arrayList.add(new MPart.Reasoning(sb));
            }
            if (stepAcc.getText().length() > 0) {
                String sb2 = stepAcc.getText().toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                arrayList.add(new MPart.Text(sb2));
            }
            for (CallAcc callAcc : stepAcc.getCalls()) {
                HashMap hashMap2 = hashMap;
                String id = callAcc.getId();
                Object obj = hashMap2.get(id);
                if (obj == null) {
                    MPart.ToolP toolP = new MPart.ToolP(callAcc.getId(), callAcc.getName(), "", "streaming", "");
                    hashMap2.put(id, toolP);
                    obj = toolP;
                }
                MPart.ToolP toolP2 = (MPart.ToolP) obj;
                toolP2.setName(callAcc.getName());
                toolP2.setArgs(callAcc.getArgs().toString());
                toolP2.setExtra(callAcc.getExtra());
                arrayList.add(toolP2);
            }
            msg.getParts().clear();
            msg.getParts().addAll(arrayList);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - longRef.element > 120) {
            longRef.element = currentTimeMillis;
            localBackend.emit("session.text.delta", sess2.getId());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence step$lambda$133(Tool it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit step$lambda$134(MPart.ToolP toolP, String path, String str) {
        Intrinsics.checkNotNullParameter(path, "path");
        toolP.getUndo().add(TuplesKt.to(path, str));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit step$lambda$135(Sess sess, JSONArray arr) {
        Intrinsics.checkNotNullParameter(arr, "arr");
        sess.setTodos(arr);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String step$lambda$136(LocalBackend localBackend, Sess sess, String cmd, File dir) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(dir, "dir");
        return localBackend.startBackground(sess, cmd, dir);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String step$lambda$137(LocalBackend localBackend, Sess sess, File f) {
        Intrinsics.checkNotNullParameter(f, "f");
        return localBackend.nestedInstructions(sess, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x017e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x00d0 -> B:10:0x00d5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object spawn(com.clozed.code.engine.Sess r17, com.clozed.code.engine.Sess r18, java.lang.String r19, java.lang.String r20, kotlin.jvm.functions.Function1<? super java.util.List<kotlin.Pair<java.lang.String, java.lang.String>>, kotlin.Unit> r21, kotlin.coroutines.Continuation<? super java.lang.String> r22) {
        /*
            Method dump skipped, instructions count: 487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.LocalBackend.spawn(com.clozed.code.engine.Sess, com.clozed.code.engine.Sess, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence spawn$lambda$146(MPart.Text it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getText();
    }

    private final String startBackground(final Sess host, final String cmd, File dir) {
        int i = this.bgCounter + 1;
        this.bgCounter = i;
        final String str = "bg-" + i;
        final Process start = new ProcessBuilder("/system/bin/sh", "-c", cmd).directory(dir).redirectErrorStream(true).start();
        ThreadsKt.thread$default(false, true, null, null, 0, new Function0() { // from class: com.clozed.code.engine.LocalBackend$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit startBackground$lambda$150;
                startBackground$lambda$150 = LocalBackend.startBackground$lambda$150(start, this, str, cmd, host);
                return startBackground$lambda$150;
            }
        }, 29, null);
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startBackground$lambda$150(Process process, LocalBackend localBackend, String str, String str2, Sess sess) {
        int i;
        StringBuilder sb = new StringBuilder();
        try {
            InputStream inputStream = process.getInputStream();
            Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
            Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            try {
                BufferedReader bufferedReader2 = bufferedReader;
                char[] cArr = new char[4096];
                while (true) {
                    int read = bufferedReader2.read(cArr);
                    if (read < 0) {
                        break;
                    }
                    if (sb.length() < 200000) {
                        sb.append(cArr, 0, read);
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(bufferedReader, null);
            } finally {
            }
        } catch (Exception unused) {
        }
        try {
            i = process.waitFor();
        } catch (Exception unused2) {
            i = -1;
        }
        String newId = localBackend.newId("msg_");
        String take = StringsKt.take(str2, 80);
        ShellTool shellTool = ShellTool.INSTANCE;
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        Msg msg = new Msg(newId, "user", "Background command " + str + " (`" + take + "`) finished with exit code " + i + ":\n" + shellTool.truncate(sb2));
        msg.setKind("synthetic");
        synchronized (sess) {
            sess.getMsgs().add(msg);
        }
        localBackend.emit("session.message.updated", sess.getId());
        Job job = localBackend.jobs.get(sess.getId());
        if (job == null || !job.isActive()) {
            localBackend.startJob(sess, new LocalBackend$startBackground$1$4(localBackend, sess, null));
        }
        return Unit.INSTANCE;
    }

    private final int estimateTokens(Sess s) {
        int i;
        synchronized (s) {
            i = 0;
            for (Msg msg : s.getMsgs()) {
                i += msg.getText().length();
                for (MPart mPart : msg.getParts()) {
                    if (mPart instanceof MPart.Text) {
                        i += ((MPart.Text) mPart).getText().length();
                    } else if (mPart instanceof MPart.ToolP) {
                        i += ((MPart.ToolP) mPart).getArgs().length() + ((MPart.ToolP) mPart).getOutput().length();
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        return i / 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object maybeCompact(com.clozed.code.engine.Sess r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof com.clozed.code.engine.LocalBackend$maybeCompact$1
            if (r0 == 0) goto L14
            r0 = r13
            com.clozed.code.engine.LocalBackend$maybeCompact$1 r0 = (com.clozed.code.engine.LocalBackend$maybeCompact$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L19
        L14:
            com.clozed.code.engine.LocalBackend$maybeCompact$1 r0 = new com.clozed.code.engine.LocalBackend$maybeCompact$1
            r0.<init>(r11, r13)
        L19:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 != r4) goto L30
            java.lang.Object r12 = r0.L$0
            com.clozed.code.engine.Sess r12 = (com.clozed.code.engine.Sess) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto Ld0
        L30:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L38:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.String r13 = r12.getProviderId()
            if (r13 == 0) goto Ld9
            com.clozed.code.engine.ProviderStore r2 = r11.store
            com.clozed.code.engine.CatProvider r13 = r2.provider(r13)
            if (r13 != 0) goto L4b
            goto Ld9
        L4b:
            java.util.List r13 = r13.getModels()
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.Iterator r13 = r13.iterator()
        L55:
            boolean r2 = r13.hasNext()
            r5 = 0
            if (r2 == 0) goto L72
            java.lang.Object r2 = r13.next()
            r6 = r2
            com.clozed.code.engine.CatModel r6 = (com.clozed.code.engine.CatModel) r6
            java.lang.String r6 = r6.getId()
            java.lang.String r7 = r12.getModelId()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)
            if (r6 == 0) goto L55
            goto L73
        L72:
            r2 = r5
        L73:
            com.clozed.code.engine.CatModel r2 = (com.clozed.code.engine.CatModel) r2
            if (r2 == 0) goto L90
            int r13 = r2.getContext()
            java.lang.Integer r13 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r13)
            r2 = r13
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            if (r2 <= 0) goto L89
            r5 = r13
        L89:
            if (r5 == 0) goto L90
            int r13 = r5.intValue()
            goto L93
        L90:
            r13 = 128000(0x1f400, float:1.79366E-40)
        L93:
            monitor-enter(r12)
            java.util.ArrayList r2 = r12.getMsgs()     // Catch: java.lang.Throwable -> Ld6
            int r2 = r2.size()     // Catch: java.lang.Throwable -> Ld6
            monitor-exit(r12)
            r5 = 4
            if (r2 > r5) goto La3
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        La3:
            int r2 = maybeCompact$est(r11, r12)
            double r5 = (double) r2
            double r7 = (double) r13
            r9 = 4603579539098121011(0x3fe3333333333333, double:0.6)
            double r9 = r9 * r7
            int r13 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r13 <= 0) goto Lb9
            r11.pruneOutputs(r12)
            r12.setLastPrompt(r3)
        Lb9:
            int r13 = maybeCompact$est(r11, r12)
            double r5 = (double) r13
            r9 = 4604930618986332160(0x3fe8000000000000, double:0.75)
            double r7 = r7 * r9
            int r13 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r13 <= 0) goto Ld3
            r0.L$0 = r12
            r0.label = r4
            java.lang.Object r13 = r11.compact(r12, r4, r0)
            if (r13 != r1) goto Ld0
            return r1
        Ld0:
            r12.setLastPrompt(r3)
        Ld3:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        Ld6:
            r13 = move-exception
            monitor-exit(r12)
            throw r13
        Ld9:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.LocalBackend.maybeCompact(com.clozed.code.engine.Sess, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final int maybeCompact$est(LocalBackend localBackend, Sess sess) {
        return Math.max(localBackend.estimateTokens(sess) + 8000, sess.getLastPrompt());
    }

    private final void pruneOutputs(Sess s) {
        synchronized (s) {
            IntRange indices = CollectionsKt.getIndices(s.getMsgs());
            ArrayList arrayList = new ArrayList();
            for (Integer num : indices) {
                int intValue = num.intValue();
                if (Intrinsics.areEqual(s.getMsgs().get(intValue).getRole(), "user") && Intrinsics.areEqual(s.getMsgs().get(intValue).getKind(), "")) {
                    arrayList.add(num);
                }
            }
            ArrayList arrayList2 = arrayList;
            int intValue2 = arrayList2.size() >= 2 ? ((Number) arrayList2.get(arrayList2.size() - 2)).intValue() : 0;
            int size = s.getMsgs().size() - 1;
            if (size >= 0) {
                int i = 160000;
                while (true) {
                    int i2 = size - 1;
                    Msg msg = s.getMsgs().get(size);
                    Intrinsics.checkNotNullExpressionValue(msg, "get(...)");
                    Msg msg2 = msg;
                    if (Intrinsics.areEqual(msg2.getRole(), "assistant")) {
                        for (MPart mPart : CollectionsKt.reversed(msg2.getParts())) {
                            if ((mPart instanceof MPart.ToolP) && !Intrinsics.areEqual(((MPart.ToolP) mPart).getName(), "skill") && !Intrinsics.areEqual(((MPart.ToolP) mPart).getName(), "todowrite") && !Intrinsics.areEqual(((MPart.ToolP) mPart).getName(), "question")) {
                                int length = ((MPart.ToolP) mPart).getOutput().length();
                                if (size < intValue2 && i <= 0) {
                                    if (length > 300 && !StringsKt.startsWith$default(((MPart.ToolP) mPart).getOutput(), "[output pruned", false, 2, (Object) null)) {
                                        ((MPart.ToolP) mPart).setOutput("[output pruned to save context: was " + length + " chars]");
                                    }
                                }
                                i -= length;
                            }
                        }
                    }
                    if (i2 < 0) {
                        break;
                    } else {
                        size = i2;
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x009a, code lost:
    
        r3 = r3.nextIndex();
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object compact(com.clozed.code.engine.Sess r24, boolean r25, kotlin.coroutines.Continuation<? super kotlin.Unit> r26) {
        /*
            Method dump skipped, instructions count: 515
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.LocalBackend.compact(com.clozed.code.engine.Sess, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object undo(com.clozed.code.engine.Sess r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.clozed.code.engine.LocalBackend$undo$1
            if (r0 == 0) goto L14
            r0 = r7
            com.clozed.code.engine.LocalBackend$undo$1 r0 = (com.clozed.code.engine.LocalBackend$undo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.clozed.code.engine.LocalBackend$undo$1 r0 = new com.clozed.code.engine.LocalBackend$undo$1
            r0.<init>(r5, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.L$1
            com.clozed.code.engine.Sess r6 = (com.clozed.code.engine.Sess) r6
            java.lang.Object r0 = r0.L$0
            com.clozed.code.engine.LocalBackend r0 = (com.clozed.code.engine.LocalBackend) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L6a
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.ResultKt.throwOnFailure(r7)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, kotlinx.coroutines.Job> r7 = r5.jobs
            java.lang.String r2 = r6.getId()
            java.lang.Object r7 = r7.get(r2)
            kotlinx.coroutines.Job r7 = (kotlinx.coroutines.Job) r7
            r2 = 0
            if (r7 == 0) goto L4f
            kotlinx.coroutines.Job.DefaultImpls.cancel$default(r7, r2, r3, r2)
        L4f:
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
            com.clozed.code.engine.LocalBackend$undo$reverted$1 r4 = new com.clozed.code.engine.LocalBackend$undo$reverted$1
            r4.<init>(r6, r5, r2)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r4, r0)
            if (r7 != r1) goto L69
            return r1
        L69:
            r0 = r5
        L6a:
            java.lang.Number r7 = (java.lang.Number) r7
            r7.intValue()
            r0.save(r6)
            java.lang.String r7 = "session.message.updated"
            java.lang.String r6 = r6.getId()
            r0.emit(r7, r6)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clozed.code.engine.LocalBackend.undo(com.clozed.code.engine.Sess, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void generateTitle(Sess s) {
        CatProvider provider;
        String modelId;
        Object obj;
        String text;
        if (s.getTitled()) {
            return;
        }
        s.setTitled(true);
        String providerId = s.getProviderId();
        if (providerId == null || (provider = this.store.provider(providerId)) == null || (modelId = s.getModelId()) == null) {
            return;
        }
        synchronized (s) {
            Iterator<T> it = s.getMsgs().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                Msg msg = (Msg) obj;
                if (Intrinsics.areEqual(msg.getRole(), "user") && Intrinsics.areEqual(msg.getKind(), "")) {
                    break;
                }
            }
            Msg msg2 = (Msg) obj;
            text = msg2 != null ? msg2.getText() : null;
        }
        if (text == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new LocalBackend$generateTitle$1(provider, this, modelId, text, s, null), 3, null);
    }
}
