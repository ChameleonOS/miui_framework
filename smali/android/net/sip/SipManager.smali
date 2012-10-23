.class public Landroid/net/sip/SipManager;
.super Ljava/lang/Object;
.source "SipManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/net/sip/SipManager$ListenerRelay;
    }
.end annotation


# static fields
.field public static final ACTION_SIP_ADD_PHONE:Ljava/lang/String; = "com.android.phone.SIP_ADD_PHONE"

.field public static final ACTION_SIP_INCOMING_CALL:Ljava/lang/String; = "com.android.phone.SIP_INCOMING_CALL"

.field public static final ACTION_SIP_REMOVE_PHONE:Ljava/lang/String; = "com.android.phone.SIP_REMOVE_PHONE"

.field public static final ACTION_SIP_SERVICE_UP:Ljava/lang/String; = "android.net.sip.SIP_SERVICE_UP"

.field public static final EXTRA_CALL_ID:Ljava/lang/String; = "android:sipCallID"

.field public static final EXTRA_LOCAL_URI:Ljava/lang/String; = "android:localSipUri"

.field public static final EXTRA_OFFER_SD:Ljava/lang/String; = "android:sipOfferSD"

.field public static final INCOMING_CALL_RESULT_CODE:I = 0x65

.field private static final TAG:Ljava/lang/String; = "SipManager"


# instance fields
.field private mContext:Landroid/content/Context;

.field private mSipService:Landroid/net/sip/ISipService;


# direct methods
.method private constructor <init>(Landroid/content/Context;)V
    .registers 2
    .parameter "context"

    .prologue
    .line 158
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 159
    iput-object p1, p0, Landroid/net/sip/SipManager;->mContext:Landroid/content/Context;

    .line 160
    invoke-direct {p0}, Landroid/net/sip/SipManager;->createSipService()V

    .line 161
    return-void
.end method

.method public static createIncomingCallBroadcast(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    .registers 4
    .parameter "callId"
    .parameter "sessionDescription"

    .prologue
    .line 457
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 458
    .local v0, intent:Landroid/content/Intent;
    const-string v1, "android:sipCallID"

    invoke-virtual {v0, v1, p0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 459
    const-string v1, "android:sipOfferSD"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 460
    return-object v0
.end method

.method private static createRelay(Landroid/net/sip/SipRegistrationListener;Ljava/lang/String;)Landroid/net/sip/ISipSessionListener;
    .registers 3
    .parameter "listener"
    .parameter "uri"

    .prologue
    .line 539
    if-nez p0, :cond_4

    const/4 v0, 0x0

    :goto_3
    return-object v0

    :cond_4
    new-instance v0, Landroid/net/sip/SipManager$ListenerRelay;

    invoke-direct {v0, p0, p1}, Landroid/net/sip/SipManager$ListenerRelay;-><init>(Landroid/net/sip/SipRegistrationListener;Ljava/lang/String;)V

    goto :goto_3
.end method

.method private createSipService()V
    .registers 3

    .prologue
    .line 164
    const-string/jumbo v1, "sip"

    invoke-static {v1}, Landroid/os/ServiceManager;->getService(Ljava/lang/String;)Landroid/os/IBinder;

    move-result-object v0

    .line 165
    .local v0, b:Landroid/os/IBinder;
    invoke-static {v0}, Landroid/net/sip/ISipService$Stub;->asInterface(Landroid/os/IBinder;)Landroid/net/sip/ISipService;

    move-result-object v1

    iput-object v1, p0, Landroid/net/sip/SipManager;->mSipService:Landroid/net/sip/ISipService;

    .line 166
    return-void
.end method

.method public static getCallId(Landroid/content/Intent;)Ljava/lang/String;
    .registers 2
    .parameter "incomingCallIntent"

    .prologue
    .line 432
    const-string v0, "android:sipCallID"

    invoke-virtual {p0, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getOfferSessionDescription(Landroid/content/Intent;)Ljava/lang/String;
    .registers 2
    .parameter "incomingCallIntent"

    .prologue
    .line 444
    const-string v0, "android:sipOfferSD"

    invoke-virtual {p0, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static isApiSupported(Landroid/content/Context;)Z
    .registers 3
    .parameter "context"

    .prologue
    .line 138
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    const-string v1, "android.software.sip"

    invoke-virtual {v0, v1}, Landroid/content/pm/PackageManager;->hasSystemFeature(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static isIncomingCallIntent(Landroid/content/Intent;)Z
    .registers 4
    .parameter "intent"

    .prologue
    const/4 v2, 0x0

    .line 419
    if-nez p0, :cond_4

    .line 422
    :cond_3
    :goto_3
    return v2

    .line 420
    :cond_4
    invoke-static {p0}, Landroid/net/sip/SipManager;->getCallId(Landroid/content/Intent;)Ljava/lang/String;

    move-result-object v0

    .line 421
    .local v0, callId:Ljava/lang/String;
    invoke-static {p0}, Landroid/net/sip/SipManager;->getOfferSessionDescription(Landroid/content/Intent;)Ljava/lang/String;

    move-result-object v1

    .line 422
    .local v1, offerSd:Ljava/lang/String;
    if-eqz v0, :cond_3

    if-eqz v1, :cond_3

    const/4 v2, 0x1

    goto :goto_3
.end method

.method public static isSipWifiOnly(Landroid/content/Context;)Z
    .registers 3
    .parameter "context"

    .prologue
    .line 154
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x111002b

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getBoolean(I)Z

    move-result v0

    return v0
.end method

.method public static isVoipSupported(Landroid/content/Context;)Z
    .registers 3
    .parameter "context"

    .prologue
    .line 146
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    const-string v1, "android.software.sip.voip"

    invoke-virtual {v0, v1}, Landroid/content/pm/PackageManager;->hasSystemFeature(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_14

    invoke-static {p0}, Landroid/net/sip/SipManager;->isApiSupported(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_14

    const/4 v0, 0x1

    :goto_13
    return v0

    :cond_14
    const/4 v0, 0x0

    goto :goto_13
.end method

.method public static newInstance(Landroid/content/Context;)Landroid/net/sip/SipManager;
    .registers 2
    .parameter "context"

    .prologue
    .line 131
    invoke-static {p0}, Landroid/net/sip/SipManager;->isApiSupported(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_c

    new-instance v0, Landroid/net/sip/SipManager;

    invoke-direct {v0, p0}, Landroid/net/sip/SipManager;-><init>(Landroid/content/Context;)V

    :goto_b
    return-object v0

    :cond_c
    const/4 v0, 0x0

    goto :goto_b
.end method


# virtual methods
.method public close(Ljava/lang/String;)V
    .registers 5
    .parameter "localProfileUri"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/net/sip/SipException;
        }
    .end annotation

    .prologue
    .line 259
    :try_start_0
    iget-object v1, p0, Landroid/net/sip/SipManager;->mSipService:Landroid/net/sip/ISipService;

    invoke-interface {v1, p1}, Landroid/net/sip/ISipService;->close(Ljava/lang/String;)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    .line 263
    return-void

    .line 260
    :catch_6
    move-exception v0

    .line 261
    .local v0, e:Landroid/os/RemoteException;
    new-instance v1, Landroid/net/sip/SipException;

    const-string v2, "close()"

    invoke-direct {v1, v2, v0}, Landroid/net/sip/SipException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public createSipSession(Landroid/net/sip/SipProfile;Landroid/net/sip/SipSession$Listener;)Landroid/net/sip/SipSession;
    .registers 7
    .parameter "localProfile"
    .parameter "listener"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/net/sip/SipException;
        }
    .end annotation

    .prologue
    .line 553
    :try_start_0
    iget-object v2, p0, Landroid/net/sip/SipManager;->mSipService:Landroid/net/sip/ISipService;

    const/4 v3, 0x0

    invoke-interface {v2, p1, v3}, Landroid/net/sip/ISipService;->createSession(Landroid/net/sip/SipProfile;Landroid/net/sip/ISipSessionListener;)Landroid/net/sip/ISipSession;

    move-result-object v1

    .line 554
    .local v1, s:Landroid/net/sip/ISipSession;
    if-nez v1, :cond_1a

    .line 555
    new-instance v2, Landroid/net/sip/SipException;

    const-string v3, "Failed to create SipSession; network unavailable?"

    invoke-direct {v2, v3}, Landroid/net/sip/SipException;-><init>(Ljava/lang/String;)V

    throw v2
    :try_end_11
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_11} :catch_11

    .line 559
    .end local v1           #s:Landroid/net/sip/ISipSession;
    :catch_11
    move-exception v0

    .line 560
    .local v0, e:Landroid/os/RemoteException;
    new-instance v2, Landroid/net/sip/SipException;

    const-string v3, "createSipSession()"

    invoke-direct {v2, v3, v0}, Landroid/net/sip/SipException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    .line 558
    .end local v0           #e:Landroid/os/RemoteException;
    .restart local v1       #s:Landroid/net/sip/ISipSession;
    :cond_1a
    :try_start_1a
    new-instance v2, Landroid/net/sip/SipSession;

    invoke-direct {v2, v1, p2}, Landroid/net/sip/SipSession;-><init>(Landroid/net/sip/ISipSession;Landroid/net/sip/SipSession$Listener;)V
    :try_end_1f
    .catch Landroid/os/RemoteException; {:try_start_1a .. :try_end_1f} :catch_11

    return-object v2
.end method

.method public getListOfProfiles()[Landroid/net/sip/SipProfile;
    .registers 3

    .prologue
    .line 571
    :try_start_0
    iget-object v1, p0, Landroid/net/sip/SipManager;->mSipService:Landroid/net/sip/ISipService;

    invoke-interface {v1}, Landroid/net/sip/ISipService;->getListOfProfiles()[Landroid/net/sip/SipProfile;
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_7

    move-result-object v1

    .line 573
    :goto_6
    return-object v1

    .line 572
    :catch_7
    move-exception v0

    .line 573
    .local v0, e:Landroid/os/RemoteException;
    const/4 v1, 0x0

    new-array v1, v1, [Landroid/net/sip/SipProfile;

    goto :goto_6
.end method

.method public getSessionFor(Landroid/content/Intent;)Landroid/net/sip/SipSession;
    .registers 7
    .parameter "incomingCallIntent"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/net/sip/SipException;
        }
    .end annotation

    .prologue
    .line 529
    :try_start_0
    invoke-static {p1}, Landroid/net/sip/SipManager;->getCallId(Landroid/content/Intent;)Ljava/lang/String;

    move-result-object v0

    .line 530
    .local v0, callId:Ljava/lang/String;
    iget-object v3, p0, Landroid/net/sip/SipManager;->mSipService:Landroid/net/sip/ISipService;

    invoke-interface {v3, v0}, Landroid/net/sip/ISipService;->getPendingSession(Ljava/lang/String;)Landroid/net/sip/ISipSession;

    move-result-object v2

    .line 531
    .local v2, s:Landroid/net/sip/ISipSession;
    if-nez v2, :cond_e

    const/4 v3, 0x0

    :goto_d
    return-object v3

    :cond_e
    new-instance v3, Landroid/net/sip/SipSession;

    invoke-direct {v3, v2}, Landroid/net/sip/SipSession;-><init>(Landroid/net/sip/ISipSession;)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_13} :catch_14

    goto :goto_d

    .line 532
    .end local v0           #callId:Ljava/lang/String;
    .end local v2           #s:Landroid/net/sip/ISipSession;
    :catch_14
    move-exception v1

    .line 533
    .local v1, e:Landroid/os/RemoteException;
    new-instance v3, Landroid/net/sip/SipException;

    const-string v4, "getSessionFor()"

    invoke-direct {v3, v4, v1}, Landroid/net/sip/SipException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3
.end method

.method public isOpened(Ljava/lang/String;)Z
    .registers 5
    .parameter "localProfileUri"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/net/sip/SipException;
        }
    .end annotation

    .prologue
    .line 275
    :try_start_0
    iget-object v1, p0, Landroid/net/sip/SipManager;->mSipService:Landroid/net/sip/ISipService;

    invoke-interface {v1, p1}, Landroid/net/sip/ISipService;->isOpened(Ljava/lang/String;)Z
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_7

    move-result v1

    return v1

    .line 276
    :catch_7
    move-exception v0

    .line 277
    .local v0, e:Landroid/os/RemoteException;
    new-instance v1, Landroid/net/sip/SipException;

    const-string v2, "isOpened()"

    invoke-direct {v1, v2, v0}, Landroid/net/sip/SipException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public isRegistered(Ljava/lang/String;)Z
    .registers 5
    .parameter "localProfileUri"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/net/sip/SipException;
        }
    .end annotation

    .prologue
    .line 296
    :try_start_0
    iget-object v1, p0, Landroid/net/sip/SipManager;->mSipService:Landroid/net/sip/ISipService;

    invoke-interface {v1, p1}, Landroid/net/sip/ISipService;->isRegistered(Ljava/lang/String;)Z
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_7

    move-result v1

    return v1

    .line 297
    :catch_7
    move-exception v0

    .line 298
    .local v0, e:Landroid/os/RemoteException;
    new-instance v1, Landroid/net/sip/SipException;

    const-string v2, "isRegistered()"

    invoke-direct {v1, v2, v0}, Landroid/net/sip/SipException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public makeAudioCall(Landroid/net/sip/SipProfile;Landroid/net/sip/SipProfile;Landroid/net/sip/SipAudioCall$Listener;I)Landroid/net/sip/SipAudioCall;
    .registers 9
    .parameter "localProfile"
    .parameter "peerProfile"
    .parameter "listener"
    .parameter "timeout"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/net/sip/SipException;
        }
    .end annotation

    .prologue
    .line 323
    iget-object v2, p0, Landroid/net/sip/SipManager;->mContext:Landroid/content/Context;

    invoke-static {v2}, Landroid/net/sip/SipManager;->isVoipSupported(Landroid/content/Context;)Z

    move-result v2

    if-nez v2, :cond_10

    .line 324
    new-instance v2, Landroid/net/sip/SipException;

    const-string v3, "VOIP API is not supported"

    invoke-direct {v2, v3}, Landroid/net/sip/SipException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 326
    :cond_10
    new-instance v0, Landroid/net/sip/SipAudioCall;

    iget-object v2, p0, Landroid/net/sip/SipManager;->mContext:Landroid/content/Context;

    invoke-direct {v0, v2, p1}, Landroid/net/sip/SipAudioCall;-><init>(Landroid/content/Context;Landroid/net/sip/SipProfile;)V

    .line 327
    .local v0, call:Landroid/net/sip/SipAudioCall;
    invoke-virtual {v0, p3}, Landroid/net/sip/SipAudioCall;->setListener(Landroid/net/sip/SipAudioCall$Listener;)V

    .line 328
    const/4 v2, 0x0

    invoke-virtual {p0, p1, v2}, Landroid/net/sip/SipManager;->createSipSession(Landroid/net/sip/SipProfile;Landroid/net/sip/SipSession$Listener;)Landroid/net/sip/SipSession;

    move-result-object v1

    .line 329
    .local v1, s:Landroid/net/sip/SipSession;
    invoke-virtual {v0, p2, v1, p4}, Landroid/net/sip/SipAudioCall;->makeCall(Landroid/net/sip/SipProfile;Landroid/net/sip/SipSession;I)V

    .line 330
    return-object v0
.end method

.method public makeAudioCall(Ljava/lang/String;Ljava/lang/String;Landroid/net/sip/SipAudioCall$Listener;I)Landroid/net/sip/SipAudioCall;
    .registers 8
    .parameter "localProfileUri"
    .parameter "peerProfileUri"
    .parameter "listener"
    .parameter "timeout"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/net/sip/SipException;
        }
    .end annotation

    .prologue
    .line 355
    iget-object v1, p0, Landroid/net/sip/SipManager;->mContext:Landroid/content/Context;

    invoke-static {v1}, Landroid/net/sip/SipManager;->isVoipSupported(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_10

    .line 356
    new-instance v1, Landroid/net/sip/SipException;

    const-string v2, "VOIP API is not supported"

    invoke-direct {v1, v2}, Landroid/net/sip/SipException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 359
    :cond_10
    :try_start_10
    new-instance v1, Landroid/net/sip/SipProfile$Builder;

    invoke-direct {v1, p1}, Landroid/net/sip/SipProfile$Builder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Landroid/net/sip/SipProfile$Builder;->build()Landroid/net/sip/SipProfile;

    move-result-object v1

    new-instance v2, Landroid/net/sip/SipProfile$Builder;

    invoke-direct {v2, p2}, Landroid/net/sip/SipProfile$Builder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Landroid/net/sip/SipProfile$Builder;->build()Landroid/net/sip/SipProfile;

    move-result-object v2

    invoke-virtual {p0, v1, v2, p3, p4}, Landroid/net/sip/SipManager;->makeAudioCall(Landroid/net/sip/SipProfile;Landroid/net/sip/SipProfile;Landroid/net/sip/SipAudioCall$Listener;I)Landroid/net/sip/SipAudioCall;
    :try_end_25
    .catch Ljava/text/ParseException; {:try_start_10 .. :try_end_25} :catch_27

    move-result-object v1

    return-object v1

    .line 363
    :catch_27
    move-exception v0

    .line 364
    .local v0, e:Ljava/text/ParseException;
    new-instance v1, Landroid/net/sip/SipException;

    const-string v2, "build SipProfile"

    invoke-direct {v1, v2, v0}, Landroid/net/sip/SipException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public open(Landroid/net/sip/SipProfile;)V
    .registers 5
    .parameter "localProfile"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/net/sip/SipException;
        }
    .end annotation

    .prologue
    .line 181
    :try_start_0
    iget-object v1, p0, Landroid/net/sip/SipManager;->mSipService:Landroid/net/sip/ISipService;

    invoke-interface {v1, p1}, Landroid/net/sip/ISipService;->open(Landroid/net/sip/SipProfile;)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    .line 185
    return-void

    .line 182
    :catch_6
    move-exception v0

    .line 183
    .local v0, e:Landroid/os/RemoteException;
    new-instance v1, Landroid/net/sip/SipException;

    const-string/jumbo v2, "open()"

    invoke-direct {v1, v2, v0}, Landroid/net/sip/SipException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public open(Landroid/net/sip/SipProfile;Landroid/app/PendingIntent;Landroid/net/sip/SipRegistrationListener;)V
    .registers 7
    .parameter "localProfile"
    .parameter "incomingCallPendingIntent"
    .parameter "listener"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/net/sip/SipException;
        }
    .end annotation

    .prologue
    .line 219
    if-nez p2, :cond_a

    .line 220
    new-instance v1, Ljava/lang/NullPointerException;

    const-string v2, "incomingCallPendingIntent cannot be null"

    invoke-direct {v1, v2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 224
    :cond_a
    :try_start_a
    iget-object v1, p0, Landroid/net/sip/SipManager;->mSipService:Landroid/net/sip/ISipService;

    invoke-virtual {p1}, Landroid/net/sip/SipProfile;->getUriString()Ljava/lang/String;

    move-result-object v2

    invoke-static {p3, v2}, Landroid/net/sip/SipManager;->createRelay(Landroid/net/sip/SipRegistrationListener;Ljava/lang/String;)Landroid/net/sip/ISipSessionListener;

    move-result-object v2

    invoke-interface {v1, p1, p2, v2}, Landroid/net/sip/ISipService;->open3(Landroid/net/sip/SipProfile;Landroid/app/PendingIntent;Landroid/net/sip/ISipSessionListener;)V
    :try_end_17
    .catch Landroid/os/RemoteException; {:try_start_a .. :try_end_17} :catch_18

    .line 229
    return-void

    .line 226
    :catch_18
    move-exception v0

    .line 227
    .local v0, e:Landroid/os/RemoteException;
    new-instance v1, Landroid/net/sip/SipException;

    const-string/jumbo v2, "open()"

    invoke-direct {v1, v2, v0}, Landroid/net/sip/SipException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public register(Landroid/net/sip/SipProfile;ILandroid/net/sip/SipRegistrationListener;)V
    .registers 8
    .parameter "localProfile"
    .parameter "expiryTime"
    .parameter "listener"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/net/sip/SipException;
        }
    .end annotation

    .prologue
    .line 479
    :try_start_0
    iget-object v2, p0, Landroid/net/sip/SipManager;->mSipService:Landroid/net/sip/ISipService;

    invoke-virtual {p1}, Landroid/net/sip/SipProfile;->getUriString()Ljava/lang/String;

    move-result-object v3

    invoke-static {p3, v3}, Landroid/net/sip/SipManager;->createRelay(Landroid/net/sip/SipRegistrationListener;Ljava/lang/String;)Landroid/net/sip/ISipSessionListener;

    move-result-object v3

    invoke-interface {v2, p1, v3}, Landroid/net/sip/ISipService;->createSession(Landroid/net/sip/SipProfile;Landroid/net/sip/ISipSessionListener;)Landroid/net/sip/ISipSession;

    move-result-object v1

    .line 481
    .local v1, session:Landroid/net/sip/ISipSession;
    if-nez v1, :cond_22

    .line 482
    new-instance v2, Landroid/net/sip/SipException;

    const-string v3, "SipService.createSession() returns null"

    invoke-direct {v2, v3}, Landroid/net/sip/SipException;-><init>(Ljava/lang/String;)V

    throw v2
    :try_end_18
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_18} :catch_18

    .line 486
    .end local v1           #session:Landroid/net/sip/ISipSession;
    :catch_18
    move-exception v0

    .line 487
    .local v0, e:Landroid/os/RemoteException;
    new-instance v2, Landroid/net/sip/SipException;

    const-string/jumbo v3, "register()"

    invoke-direct {v2, v3, v0}, Landroid/net/sip/SipException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    .line 485
    .end local v0           #e:Landroid/os/RemoteException;
    .restart local v1       #session:Landroid/net/sip/ISipSession;
    :cond_22
    :try_start_22
    invoke-interface {v1, p2}, Landroid/net/sip/ISipSession;->register(I)V
    :try_end_25
    .catch Landroid/os/RemoteException; {:try_start_22 .. :try_end_25} :catch_18

    .line 489
    return-void
.end method

.method public setRegistrationListener(Ljava/lang/String;Landroid/net/sip/SipRegistrationListener;)V
    .registers 6
    .parameter "localProfileUri"
    .parameter "listener"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/net/sip/SipException;
        }
    .end annotation

    .prologue
    .line 243
    :try_start_0
    iget-object v1, p0, Landroid/net/sip/SipManager;->mSipService:Landroid/net/sip/ISipService;

    invoke-static {p2, p1}, Landroid/net/sip/SipManager;->createRelay(Landroid/net/sip/SipRegistrationListener;Ljava/lang/String;)Landroid/net/sip/ISipSessionListener;

    move-result-object v2

    invoke-interface {v1, p1, v2}, Landroid/net/sip/ISipService;->setRegistrationListener(Ljava/lang/String;Landroid/net/sip/ISipSessionListener;)V
    :try_end_9
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_9} :catch_a

    .line 248
    return-void

    .line 245
    :catch_a
    move-exception v0

    .line 246
    .local v0, e:Landroid/os/RemoteException;
    new-instance v1, Landroid/net/sip/SipException;

    const-string/jumbo v2, "setRegistrationListener()"

    invoke-direct {v1, v2, v0}, Landroid/net/sip/SipException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public takeAudioCall(Landroid/content/Intent;Landroid/net/sip/SipAudioCall$Listener;)Landroid/net/sip/SipAudioCall;
    .registers 10
    .parameter "incomingCallIntent"
    .parameter "listener"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/net/sip/SipException;
        }
    .end annotation

    .prologue
    .line 382
    if-nez p1, :cond_a

    .line 383
    new-instance v5, Landroid/net/sip/SipException;

    const-string v6, "Cannot retrieve session with null intent"

    invoke-direct {v5, v6}, Landroid/net/sip/SipException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 386
    :cond_a
    invoke-static {p1}, Landroid/net/sip/SipManager;->getCallId(Landroid/content/Intent;)Ljava/lang/String;

    move-result-object v1

    .line 387
    .local v1, callId:Ljava/lang/String;
    if-nez v1, :cond_18

    .line 388
    new-instance v5, Landroid/net/sip/SipException;

    const-string v6, "Call ID missing in incoming call intent"

    invoke-direct {v5, v6}, Landroid/net/sip/SipException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 391
    :cond_18
    invoke-static {p1}, Landroid/net/sip/SipManager;->getOfferSessionDescription(Landroid/content/Intent;)Ljava/lang/String;

    move-result-object v2

    .line 392
    .local v2, offerSd:Ljava/lang/String;
    if-nez v2, :cond_26

    .line 393
    new-instance v5, Landroid/net/sip/SipException;

    const-string v6, "Session description missing in incoming call intent"

    invoke-direct {v5, v6}, Landroid/net/sip/SipException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 398
    :cond_26
    :try_start_26
    iget-object v5, p0, Landroid/net/sip/SipManager;->mSipService:Landroid/net/sip/ISipService;

    invoke-interface {v5, v1}, Landroid/net/sip/ISipService;->getPendingSession(Ljava/lang/String;)Landroid/net/sip/ISipSession;

    move-result-object v3

    .line 399
    .local v3, session:Landroid/net/sip/ISipSession;
    if-nez v3, :cond_40

    .line 400
    new-instance v5, Landroid/net/sip/SipException;

    const-string v6, "No pending session for the call"

    invoke-direct {v5, v6}, Landroid/net/sip/SipException;-><init>(Ljava/lang/String;)V

    throw v5
    :try_end_36
    .catch Ljava/lang/Throwable; {:try_start_26 .. :try_end_36} :catch_36

    .line 407
    .end local v3           #session:Landroid/net/sip/ISipSession;
    :catch_36
    move-exception v4

    .line 408
    .local v4, t:Ljava/lang/Throwable;
    new-instance v5, Landroid/net/sip/SipException;

    const-string/jumbo v6, "takeAudioCall()"

    invoke-direct {v5, v6, v4}, Landroid/net/sip/SipException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v5

    .line 402
    .end local v4           #t:Ljava/lang/Throwable;
    .restart local v3       #session:Landroid/net/sip/ISipSession;
    :cond_40
    :try_start_40
    new-instance v0, Landroid/net/sip/SipAudioCall;

    iget-object v5, p0, Landroid/net/sip/SipManager;->mContext:Landroid/content/Context;

    invoke-interface {v3}, Landroid/net/sip/ISipSession;->getLocalProfile()Landroid/net/sip/SipProfile;

    move-result-object v6

    invoke-direct {v0, v5, v6}, Landroid/net/sip/SipAudioCall;-><init>(Landroid/content/Context;Landroid/net/sip/SipProfile;)V

    .line 404
    .local v0, call:Landroid/net/sip/SipAudioCall;
    new-instance v5, Landroid/net/sip/SipSession;

    invoke-direct {v5, v3}, Landroid/net/sip/SipSession;-><init>(Landroid/net/sip/ISipSession;)V

    invoke-virtual {v0, v5, v2}, Landroid/net/sip/SipAudioCall;->attachCall(Landroid/net/sip/SipSession;Ljava/lang/String;)V

    .line 405
    invoke-virtual {v0, p2}, Landroid/net/sip/SipAudioCall;->setListener(Landroid/net/sip/SipAudioCall$Listener;)V
    :try_end_56
    .catch Ljava/lang/Throwable; {:try_start_40 .. :try_end_56} :catch_36

    .line 406
    return-object v0
.end method

.method public unregister(Landroid/net/sip/SipProfile;Landroid/net/sip/SipRegistrationListener;)V
    .registers 7
    .parameter "localProfile"
    .parameter "listener"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/net/sip/SipException;
        }
    .end annotation

    .prologue
    .line 504
    :try_start_0
    iget-object v2, p0, Landroid/net/sip/SipManager;->mSipService:Landroid/net/sip/ISipService;

    invoke-virtual {p1}, Landroid/net/sip/SipProfile;->getUriString()Ljava/lang/String;

    move-result-object v3

    invoke-static {p2, v3}, Landroid/net/sip/SipManager;->createRelay(Landroid/net/sip/SipRegistrationListener;Ljava/lang/String;)Landroid/net/sip/ISipSessionListener;

    move-result-object v3

    invoke-interface {v2, p1, v3}, Landroid/net/sip/ISipService;->createSession(Landroid/net/sip/SipProfile;Landroid/net/sip/ISipSessionListener;)Landroid/net/sip/ISipSession;

    move-result-object v1

    .line 506
    .local v1, session:Landroid/net/sip/ISipSession;
    if-nez v1, :cond_22

    .line 507
    new-instance v2, Landroid/net/sip/SipException;

    const-string v3, "SipService.createSession() returns null"

    invoke-direct {v2, v3}, Landroid/net/sip/SipException;-><init>(Ljava/lang/String;)V

    throw v2
    :try_end_18
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_18} :catch_18

    .line 511
    .end local v1           #session:Landroid/net/sip/ISipSession;
    :catch_18
    move-exception v0

    .line 512
    .local v0, e:Landroid/os/RemoteException;
    new-instance v2, Landroid/net/sip/SipException;

    const-string/jumbo v3, "unregister()"

    invoke-direct {v2, v3, v0}, Landroid/net/sip/SipException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    .line 510
    .end local v0           #e:Landroid/os/RemoteException;
    .restart local v1       #session:Landroid/net/sip/ISipSession;
    :cond_22
    :try_start_22
    invoke-interface {v1}, Landroid/net/sip/ISipSession;->unregister()V
    :try_end_25
    .catch Landroid/os/RemoteException; {:try_start_22 .. :try_end_25} :catch_18

    .line 514
    return-void
.end method
