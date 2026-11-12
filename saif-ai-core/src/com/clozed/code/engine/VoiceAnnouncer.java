package com.clozed.code.engine;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Voice.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tJ \u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0011H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/clozed/code/engine/VoiceAnnouncer;", "", "<init>", "()V", "tts", "Landroid/speech/tts/TextToSpeech;", "ready", "", "pending", "", "main", "Landroid/os/Handler;", "focusRequest", "Landroid/media/AudioFocusRequest;", "speak", "", "ctx", "Landroid/content/Context;", "text", "say", "app", "t", "requestFocus", "attrs", "Landroid/media/AudioAttributes;", "abandonFocus", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /tmp/classes3.dex */
public final class VoiceAnnouncer {
    private static AudioFocusRequest focusRequest;
    private static String pending;
    private static boolean ready;
    private static TextToSpeech tts;
    public static final VoiceAnnouncer INSTANCE = new VoiceAnnouncer();
    private static final Handler main = new Handler(Looper.getMainLooper());
    public static final int $stable = 8;

    private VoiceAnnouncer() {
    }

    public final void speak(Context ctx, final String text) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(text, "text");
        final Context applicationContext = ctx.getApplicationContext();
        main.post(new Runnable() { // from class: com.clozed.code.engine.VoiceAnnouncer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                VoiceAnnouncer.speak$lambda$2(applicationContext, text);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void speak$lambda$2(final Context context, String str) {
        try {
            TextToSpeech textToSpeech = tts;
            if (textToSpeech != null && ready) {
                VoiceAnnouncer voiceAnnouncer = INSTANCE;
                Intrinsics.checkNotNull(context);
                voiceAnnouncer.say(context, textToSpeech, str);
            } else {
                pending = str;
                if (textToSpeech == null) {
                    tts = new TextToSpeech(context, new TextToSpeech.OnInitListener() { // from class: com.clozed.code.engine.VoiceAnnouncer$$ExternalSyntheticLambda1
                        @Override // android.speech.tts.TextToSpeech.OnInitListener
                        public final void onInit(int i) {
                            VoiceAnnouncer.speak$lambda$2$lambda$1(context, i);
                        }
                    });
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void speak$lambda$2$lambda$1(Context context, int i) {
        TextToSpeech textToSpeech = tts;
        if (i == 0 && textToSpeech != null) {
            VoiceAnnouncer voiceAnnouncer = INSTANCE;
            ready = true;
            int language = textToSpeech.setLanguage(Locale.US);
            if (language == -2 || language == -1) {
                textToSpeech.setLanguage(Locale.getDefault());
            }
            String str = pending;
            if (str != null) {
                Intrinsics.checkNotNull(context);
                voiceAnnouncer.say(context, textToSpeech, str);
            }
            pending = null;
            return;
        }
        if (textToSpeech != null) {
            try {
                textToSpeech.shutdown();
            } catch (Exception unused) {
            }
        }
        tts = null;
        ready = false;
        pending = null;
    }

    private final void say(final Context app, TextToSpeech t, String text) {
        try {
            AudioAttributes build = new AudioAttributes.Builder().setUsage(1).setContentType(1).build();
            t.setAudioAttributes(build);
            t.setOnUtteranceProgressListener(new UtteranceProgressListener() { // from class: com.clozed.code.engine.VoiceAnnouncer$say$1
                @Override // android.speech.tts.UtteranceProgressListener
                public void onStart(String utteranceId) {
                }

                @Override // android.speech.tts.UtteranceProgressListener
                public void onDone(String utteranceId) {
                    VoiceAnnouncer.INSTANCE.abandonFocus(app);
                }

                @Override // android.speech.tts.UtteranceProgressListener
                @Deprecated(message = "Deprecated in Java")
                public void onError(String utteranceId) {
                    VoiceAnnouncer.INSTANCE.abandonFocus(app);
                }
            });
            Intrinsics.checkNotNull(build);
            requestFocus(app, build);
            t.speak(text, 0, null, "clozed_voice");
        } catch (Exception unused) {
        }
    }

    private final void requestFocus(Context app, AudioAttributes attrs) {
        try {
            Object systemService = app.getSystemService("audio");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            AudioManager audioManager = (AudioManager) systemService;
            if (Build.VERSION.SDK_INT >= 26) {
                AudioFocusRequest build = new AudioFocusRequest.Builder(3).setAudioAttributes(attrs).build();
                focusRequest = build;
                audioManager.requestAudioFocus(build);
                return;
            }
            audioManager.requestAudioFocus(null, 3, 3);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void abandonFocus(Context app) {
        try {
            Object systemService = app.getSystemService("audio");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            AudioManager audioManager = (AudioManager) systemService;
            if (Build.VERSION.SDK_INT < 26) {
                audioManager.abandonAudioFocus(null);
                return;
            }
            AudioFocusRequest audioFocusRequest = focusRequest;
            if (audioFocusRequest != null) {
                audioManager.abandonAudioFocusRequest(audioFocusRequest);
            }
        } catch (Exception unused) {
        }
    }
}
