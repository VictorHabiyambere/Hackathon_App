package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.NonGmsServiceBrokerClient;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zaae;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zabv;
import com.google.android.gms.common.api.internal.zact;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public abstract class GoogleApi<O extends Api.ApiOptions> implements HasApiKey<O> {
    protected final GoogleApiManager zaa;
    private final Context zab;
    private final String zac;
    private final Api zad;
    private final Api.ApiOptions zae;
    private final ApiKey zaf;
    private final Looper zag;
    private final int zah;
    @NotOnlyInitialized
    private final GoogleApiClient zai;
    private final StatusExceptionMapper zaj;

    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    public static class Settings {
        public static final Settings DEFAULT_SETTINGS = new Builder().build();
        public final StatusExceptionMapper zaa;
        public final Looper zab;

        /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
        public static class Builder {
            private StatusExceptionMapper zaa;
            private Looper zab;

            public Settings build() {
                if (this.zaa == null) {
                    this.zaa = new ApiExceptionMapper();
                }
                if (this.zab == null) {
                    this.zab = Looper.getMainLooper();
                }
                return new Settings(this.zaa, this.zab);
            }

            public Builder setLooper(Looper looper) {
                Preconditions.checkNotNull(looper, "Looper must not be null.");
                this.zab = looper;
                return this;
            }

            public Builder setMapper(StatusExceptionMapper mapper) {
                Preconditions.checkNotNull(mapper, "StatusExceptionMapper must not be null.");
                this.zaa = mapper;
                return this;
            }
        }

        private Settings(StatusExceptionMapper statusExceptionMapper, Account account, Looper looper) {
            this.zaa = statusExceptionMapper;
            this.zab = looper;
        }
    }

    public GoogleApi(Activity activity, Api<O> api, O options, Settings settings) {
        this((Context) activity, activity, (Api) api, (Api.ApiOptions) options, settings);
    }

    private final BaseImplementation.ApiMethodImpl zad(int i, BaseImplementation.ApiMethodImpl apiMethodImpl) {
        apiMethodImpl.zak();
        this.zaa.zaw(this, i, apiMethodImpl);
        return apiMethodImpl;
    }

    private final Task zae(int i, TaskApiCall taskApiCall) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zaa.zax(this, i, taskApiCall, taskCompletionSource, this.zaj);
        return taskCompletionSource.getTask();
    }

    public GoogleApiClient asGoogleApiClient() {
        return this.zai;
    }

    /* access modifiers changed from: protected */
    public ClientSettings.Builder createClientSettingsBuilder() {
        Account account;
        Set<Scope> set;
        GoogleSignInAccount googleSignInAccount;
        ClientSettings.Builder builder = new ClientSettings.Builder();
        Api.ApiOptions apiOptions = this.zae;
        if (!(apiOptions instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (googleSignInAccount = ((Api.ApiOptions.HasGoogleSignInAccountOptions) apiOptions).getGoogleSignInAccount()) == null) {
            Api.ApiOptions apiOptions2 = this.zae;
            account = apiOptions2 instanceof Api.ApiOptions.HasAccountOptions ? ((Api.ApiOptions.HasAccountOptions) apiOptions2).getAccount() : null;
        } else {
            account = googleSignInAccount.getAccount();
        }
        builder.zab(account);
        Api.ApiOptions apiOptions3 = this.zae;
        if (apiOptions3 instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) {
            GoogleSignInAccount googleSignInAccount2 = ((Api.ApiOptions.HasGoogleSignInAccountOptions) apiOptions3).getGoogleSignInAccount();
            if (googleSignInAccount2 == null) {
                set = Collections.emptySet();
            } else {
                set = googleSignInAccount2.getRequestedScopes();
            }
        } else {
            set = Collections.emptySet();
        }
        builder.zaa(set);
        builder.zac(this.zab.getClass().getName());
        builder.setRealClientPackageName(this.zab.getPackageName());
        return builder;
    }

    /* access modifiers changed from: protected */
    public Task<Boolean> disconnectService() {
        return this.zaa.zap(this);
    }

    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doBestEffortWrite(T methodImpl) {
        zad(2, methodImpl);
        return methodImpl;
    }

    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doRead(T methodImpl) {
        zad(0, methodImpl);
        return methodImpl;
    }

    @Deprecated
    public <A extends Api.AnyClient, T extends RegisterListenerMethod<A, ?>, U extends UnregisterListenerMethod<A, ?>> Task<Void> doRegisterEventListener(T registerMethod, U unregisterMethod) {
        Preconditions.checkNotNull(registerMethod);
        Preconditions.checkNotNull(unregisterMethod);
        Preconditions.checkNotNull(registerMethod.getListenerKey(), "Listener has already been released.");
        Preconditions.checkNotNull(unregisterMethod.getListenerKey(), "Listener has already been released.");
        Preconditions.checkArgument(Objects.equal(registerMethod.getListenerKey(), unregisterMethod.getListenerKey()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        return this.zaa.zaq(this, registerMethod, unregisterMethod, zad.zaa);
    }

    public Task<Boolean> doUnregisterEventListener(ListenerHolder.ListenerKey<?> listenerKey) {
        return doUnregisterEventListener(listenerKey, 0);
    }

    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doWrite(T methodImpl) {
        zad(1, methodImpl);
        return methodImpl;
    }

    public final ApiKey<O> getApiKey() {
        return this.zaf;
    }

    public O getApiOptions() {
        return this.zae;
    }

    public Context getApplicationContext() {
        return this.zab;
    }

    /* access modifiers changed from: protected */
    public String getContextAttributionTag() {
        return this.zac;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public String getContextFeatureId() {
        return this.zac;
    }

    public Looper getLooper() {
        return this.zag;
    }

    public <L> ListenerHolder<L> registerListener(L listener, String listenerType) {
        return ListenerHolders.createListenerHolder(listener, this.zag, listenerType);
    }

    public final int zaa() {
        return this.zah;
    }

    public final Api.Client zab(Looper looper, zabq zabq) {
        Looper looper2 = looper;
        Api.Client buildClient = ((Api.AbstractClientBuilder) Preconditions.checkNotNull(this.zad.zaa())).buildClient(this.zab, looper2, createClientSettingsBuilder().build(), this.zae, (GoogleApiClient.ConnectionCallbacks) zabq, (GoogleApiClient.OnConnectionFailedListener) zabq);
        String contextAttributionTag = getContextAttributionTag();
        if (contextAttributionTag != null && (buildClient instanceof BaseGmsClient)) {
            ((BaseGmsClient) buildClient).setAttributionTag(contextAttributionTag);
        }
        if (contextAttributionTag != null && (buildClient instanceof NonGmsServiceBrokerClient)) {
            ((NonGmsServiceBrokerClient) buildClient).zac(contextAttributionTag);
        }
        return buildClient;
    }

    public final zact zac(Context context, Handler handler) {
        return new zact(context, handler, createClientSettingsBuilder().build());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GoogleApi(android.app.Activity r2, com.google.android.gms.common.api.Api<O> r3, O r4, com.google.android.gms.common.api.internal.StatusExceptionMapper r5) {
        /*
            r1 = this;
            com.google.android.gms.common.api.GoogleApi$Settings$Builder r0 = new com.google.android.gms.common.api.GoogleApi$Settings$Builder
            r0.<init>()
            r0.setMapper(r5)
            android.os.Looper r5 = r2.getMainLooper()
            r0.setLooper(r5)
            com.google.android.gms.common.api.GoogleApi$Settings r5 = r0.build()
            r1.<init>((android.app.Activity) r2, r3, r4, (com.google.android.gms.common.api.GoogleApi.Settings) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.GoogleApi.<init>(android.app.Activity, com.google.android.gms.common.api.Api, com.google.android.gms.common.api.Api$ApiOptions, com.google.android.gms.common.api.internal.StatusExceptionMapper):void");
    }

    public <TResult, A extends Api.AnyClient> Task<TResult> doBestEffortWrite(TaskApiCall<A, TResult> methodImpl) {
        return zae(2, methodImpl);
    }

    public <TResult, A extends Api.AnyClient> Task<TResult> doRead(TaskApiCall<A, TResult> methodImpl) {
        return zae(0, methodImpl);
    }

    public Task<Boolean> doUnregisterEventListener(ListenerHolder.ListenerKey<?> listenerKey, int methodKey) {
        Preconditions.checkNotNull(listenerKey, "Listener key cannot be null.");
        return this.zaa.zar(this, listenerKey, methodKey);
    }

    public <TResult, A extends Api.AnyClient> Task<TResult> doWrite(TaskApiCall<A, TResult> methodImpl) {
        return zae(1, methodImpl);
    }

    private GoogleApi(Context context, Activity activity, Api api, Api.ApiOptions apiOptions, Settings settings) {
        Preconditions.checkNotNull(context, "Null context is not permitted.");
        Preconditions.checkNotNull(api, "Api must not be null.");
        Preconditions.checkNotNull(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.zab = context.getApplicationContext();
        String str = null;
        if (PlatformVersion.isAtLeastR()) {
            try {
                str = (String) Context.class.getMethod("getAttributionTag", new Class[0]).invoke(context, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            }
        }
        this.zac = str;
        this.zad = api;
        this.zae = apiOptions;
        this.zag = settings.zab;
        this.zaf = ApiKey.getSharedApiKey(this.zad, this.zae, this.zac);
        this.zai = new zabv(this);
        this.zaa = GoogleApiManager.zam(this.zab);
        this.zah = this.zaa.zaa();
        this.zaj = settings.zaa;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            zaae.zad(activity, this.zaa, this.zaf);
        }
        this.zaa.zaB(this);
    }

    public <A extends Api.AnyClient> Task<Void> doRegisterEventListener(RegistrationMethods<A, ?> methods) {
        Preconditions.checkNotNull(methods);
        Preconditions.checkNotNull(methods.register.getListenerKey(), "Listener has already been released.");
        Preconditions.checkNotNull(methods.zaa.getListenerKey(), "Listener has already been released.");
        return this.zaa.zaq(this, methods.register, methods.zaa, methods.zab);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GoogleApi(android.content.Context r2, com.google.android.gms.common.api.Api<O> r3, O r4, android.os.Looper r5, com.google.android.gms.common.api.internal.StatusExceptionMapper r6) {
        /*
            r1 = this;
            com.google.android.gms.common.api.GoogleApi$Settings$Builder r0 = new com.google.android.gms.common.api.GoogleApi$Settings$Builder
            r0.<init>()
            r0.setLooper(r5)
            r0.setMapper(r6)
            com.google.android.gms.common.api.GoogleApi$Settings r5 = r0.build()
            r1.<init>((android.content.Context) r2, r3, r4, (com.google.android.gms.common.api.GoogleApi.Settings) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.GoogleApi.<init>(android.content.Context, com.google.android.gms.common.api.Api, com.google.android.gms.common.api.Api$ApiOptions, android.os.Looper, com.google.android.gms.common.api.internal.StatusExceptionMapper):void");
    }

    public GoogleApi(Context context, Api<O> api, O options, Settings settings) {
        this(context, (Activity) null, (Api) api, (Api.ApiOptions) options, settings);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GoogleApi(android.content.Context r2, com.google.android.gms.common.api.Api<O> r3, O r4, com.google.android.gms.common.api.internal.StatusExceptionMapper r5) {
        /*
            r1 = this;
            com.google.android.gms.common.api.GoogleApi$Settings$Builder r0 = new com.google.android.gms.common.api.GoogleApi$Settings$Builder
            r0.<init>()
            r0.setMapper(r5)
            com.google.android.gms.common.api.GoogleApi$Settings r5 = r0.build()
            r1.<init>((android.content.Context) r2, r3, r4, (com.google.android.gms.common.api.GoogleApi.Settings) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.GoogleApi.<init>(android.content.Context, com.google.android.gms.common.api.Api, com.google.android.gms.common.api.Api$ApiOptions, com.google.android.gms.common.api.internal.StatusExceptionMapper):void");
    }
}
