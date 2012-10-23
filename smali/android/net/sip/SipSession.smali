.class public final Landroid/net/sip/SipSession;
.super Ljava/lang/Object;
.source "SipSession.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/net/sip/SipSession$Listener;,
        Landroid/net/sip/SipSession$State;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "SipSession"


# instance fields
.field private mListener:Landroid/net/sip/SipSession$Listener;

.field private final mSession:Landroid/net/sip/ISipSession;


# direct methods
.method constructor <init>(Landroid/net/sip/ISipSession;)V
    .registers 6
    .parameter "realSession"

    .prologue
    .line 239
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 240
    iput-object p1, p0, Landroid/net/sip/SipSession;->mSession:Landroid/net/sip/ISipSession;

    .line 241
    if-eqz p1, :cond_e

    .line 243
    :try_start_7
    invoke-direct {p0}, Landroid/net/sip/SipSession;->createListener()Landroid/net/sip/ISipSessionListener;

    move-result-object v1

    invoke-interface {p1, v1}, Landroid/net/sip/ISipSession;->setListener(Landroid/net/sip/ISipSessionListener;)V
    :try_end_e
    .catch Landroid/os/RemoteException; {:try_start_7 .. :try_end_e} :catch_f

    .line 248
    :cond_e
    :goto_e
    return-void

    .line 244
    :catch_f
    move-exception v0

    .line 245
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "SipSession"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "SipSession.setListener(): "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_e
.end method

.method constructor <init>(Landroid/net/sip/ISipSession;Landroid/net/sip/SipSession$Listener;)V
    .registers 3
    .parameter "realSession"
    .parameter "listener"

    .prologue
    .line 251
    invoke-direct {p0, p1}, Landroid/net/sip/SipSession;-><init>(Landroid/net/sip/ISipSession;)V

    .line 252
    invoke-virtual {p0, p2}, Landroid/net/sip/SipSession;->setListener(Landroid/net/sip/SipSession$Listener;)V

    .line 253
    return-void
.end method

.method static synthetic access$000(Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession$Listener;
    .registers 2
    .parameter "x0"

    .prologue
    .line 29
    iget-object v0, p0, Landroid/net/sip/SipSession;->mListener:Landroid/net/sip/SipSession$Listener;

    return-object v0
.end method

.method private createListener()Landroid/net/sip/ISipSessionListener;
    .registers 2

    .prologue
    .line 465
    new-instance v0, Landroid/net/sip/SipSession$1;

    invoke-direct {v0, p0}, Landroid/net/sip/SipSession$1;-><init>(Landroid/net/sip/SipSession;)V

    return-object v0
.end method


# virtual methods
.method public answerCall(Ljava/lang/String;I)V
    .registers 7
    .parameter "sessionDescription"
    .parameter "timeout"

    .prologue
    .line 421
    :try_start_0
    iget-object v1, p0, Landroid/net/sip/SipSession;->mSession:Landroid/net/sip/ISipSession;

    invoke-interface {v1, p1, p2}, Landroid/net/sip/ISipSession;->answerCall(Ljava/lang/String;I)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    .line 425
    :goto_5
    return-void

    .line 422
    :catch_6
    move-exception v0

    .line 423
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "SipSession"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "answerCall(): "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_5
.end method

.method public changeCall(Ljava/lang/String;I)V
    .registers 7
    .parameter "sessionDescription"
    .parameter "timeout"

    .prologue
    .line 454
    :try_start_0
    iget-object v1, p0, Landroid/net/sip/SipSession;->mSession:Landroid/net/sip/ISipSession;

    invoke-interface {v1, p1, p2}, Landroid/net/sip/ISipSession;->changeCall(Ljava/lang/String;I)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    .line 458
    :goto_5
    return-void

    .line 455
    :catch_6
    move-exception v0

    .line 456
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "SipSession"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "changeCall(): "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_5
.end method

.method public endCall()V
    .registers 5

    .prologue
    .line 437
    :try_start_0
    iget-object v1, p0, Landroid/net/sip/SipSession;->mSession:Landroid/net/sip/ISipSession;

    invoke-interface {v1}, Landroid/net/sip/ISipSession;->endCall()V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    .line 441
    :goto_5
    return-void

    .line 438
    :catch_6
    move-exception v0

    .line 439
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "SipSession"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "endCall(): "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_5
.end method

.method public getCallId()Ljava/lang/String;
    .registers 5

    .prologue
    .line 334
    :try_start_0
    iget-object v1, p0, Landroid/net/sip/SipSession;->mSession:Landroid/net/sip/ISipSession;

    invoke-interface {v1}, Landroid/net/sip/ISipSession;->getCallId()Ljava/lang/String;
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_7

    move-result-object v1

    .line 337
    :goto_6
    return-object v1

    .line 335
    :catch_7
    move-exception v0

    .line 336
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "SipSession"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "getCallId(): "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 337
    const/4 v1, 0x0

    goto :goto_6
.end method

.method public getLocalIp()Ljava/lang/String;
    .registers 5

    .prologue
    .line 262
    :try_start_0
    iget-object v1, p0, Landroid/net/sip/SipSession;->mSession:Landroid/net/sip/ISipSession;

    invoke-interface {v1}, Landroid/net/sip/ISipSession;->getLocalIp()Ljava/lang/String;
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_7

    move-result-object v1

    .line 265
    :goto_6
    return-object v1

    .line 263
    :catch_7
    move-exception v0

    .line 264
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "SipSession"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "getLocalIp(): "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 265
    const-string v1, "127.0.0.1"

    goto :goto_6
.end method

.method public getLocalProfile()Landroid/net/sip/SipProfile;
    .registers 5

    .prologue
    .line 276
    :try_start_0
    iget-object v1, p0, Landroid/net/sip/SipSession;->mSession:Landroid/net/sip/ISipSession;

    invoke-interface {v1}, Landroid/net/sip/ISipSession;->getLocalProfile()Landroid/net/sip/SipProfile;
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_7

    move-result-object v1

    .line 279
    :goto_6
    return-object v1

    .line 277
    :catch_7
    move-exception v0

    .line 278
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "SipSession"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "getLocalProfile(): "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 279
    const/4 v1, 0x0

    goto :goto_6
.end method

.method public getPeerProfile()Landroid/net/sip/SipProfile;
    .registers 5

    .prologue
    .line 291
    :try_start_0
    iget-object v1, p0, Landroid/net/sip/SipSession;->mSession:Landroid/net/sip/ISipSession;

    invoke-interface {v1}, Landroid/net/sip/ISipSession;->getPeerProfile()Landroid/net/sip/SipProfile;
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_7

    move-result-object v1

    .line 294
    :goto_6
    return-object v1

    .line 292
    :catch_7
    move-exception v0

    .line 293
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "SipSession"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "getPeerProfile(): "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 294
    const/4 v1, 0x0

    goto :goto_6
.end method

.method getRealSession()Landroid/net/sip/ISipSession;
    .registers 2

    .prologue
    .line 461
    iget-object v0, p0, Landroid/net/sip/SipSession;->mSession:Landroid/net/sip/ISipSession;

    return-object v0
.end method

.method public getState()I
    .registers 5

    .prologue
    .line 306
    :try_start_0
    iget-object v1, p0, Landroid/net/sip/SipSession;->mSession:Landroid/net/sip/ISipSession;

    invoke-interface {v1}, Landroid/net/sip/ISipSession;->getState()I
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_7

    move-result v1

    .line 309
    :goto_6
    return v1

    .line 307
    :catch_7
    move-exception v0

    .line 308
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "SipSession"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "getState(): "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 309
    const/16 v1, 0x65

    goto :goto_6
.end method

.method public isInCall()Z
    .registers 5

    .prologue
    .line 320
    :try_start_0
    iget-object v1, p0, Landroid/net/sip/SipSession;->mSession:Landroid/net/sip/ISipSession;

    invoke-interface {v1}, Landroid/net/sip/ISipSession;->isInCall()Z
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_7

    move-result v1

    .line 323
    :goto_6
    return v1

    .line 321
    :catch_7
    move-exception v0

    .line 322
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "SipSession"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "isInCall(): "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 323
    const/4 v1, 0x0

    goto :goto_6
.end method

.method public makeCall(Landroid/net/sip/SipProfile;Ljava/lang/String;I)V
    .registers 8
    .parameter "callee"
    .parameter "sessionDescription"
    .parameter "timeout"

    .prologue
    .line 403
    :try_start_0
    iget-object v1, p0, Landroid/net/sip/SipSession;->mSession:Landroid/net/sip/ISipSession;

    invoke-interface {v1, p1, p2, p3}, Landroid/net/sip/ISipSession;->makeCall(Landroid/net/sip/SipProfile;Ljava/lang/String;I)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    .line 407
    :goto_5
    return-void

    .line 404
    :catch_6
    move-exception v0

    .line 405
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "SipSession"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "makeCall(): "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_5
.end method

.method public register(I)V
    .registers 6
    .parameter "duration"

    .prologue
    .line 365
    :try_start_0
    iget-object v1, p0, Landroid/net/sip/SipSession;->mSession:Landroid/net/sip/ISipSession;

    invoke-interface {v1, p1}, Landroid/net/sip/ISipSession;->register(I)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    .line 369
    :goto_5
    return-void

    .line 366
    :catch_6
    move-exception v0

    .line 367
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "SipSession"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "register(): "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_5
.end method

.method public setListener(Landroid/net/sip/SipSession$Listener;)V
    .registers 2
    .parameter "listener"

    .prologue
    .line 350
    iput-object p1, p0, Landroid/net/sip/SipSession;->mListener:Landroid/net/sip/SipSession$Listener;

    .line 351
    return-void
.end method

.method public unregister()V
    .registers 5

    .prologue
    .line 382
    :try_start_0
    iget-object v1, p0, Landroid/net/sip/SipSession;->mSession:Landroid/net/sip/ISipSession;

    invoke-interface {v1}, Landroid/net/sip/ISipSession;->unregister()V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    .line 386
    :goto_5
    return-void

    .line 383
    :catch_6
    move-exception v0

    .line 384
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "SipSession"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "unregister(): "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_5
.end method
