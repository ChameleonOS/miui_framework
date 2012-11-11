.class public Landroid/net/sip/SipSession$Listener;
.super Ljava/lang/Object;
.source "SipSession.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/sip/SipSession;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Listener"
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCallBusy(Landroid/net/sip/SipSession;)V
    .registers 2
    .parameter "session"

    .prologue
    return-void
.end method

.method public onCallChangeFailed(Landroid/net/sip/SipSession;ILjava/lang/String;)V
    .registers 4
    .parameter "session"
    .parameter "errorCode"
    .parameter "errorMessage"

    .prologue
    return-void
.end method

.method public onCallEnded(Landroid/net/sip/SipSession;)V
    .registers 2
    .parameter "session"

    .prologue
    return-void
.end method

.method public onCallEstablished(Landroid/net/sip/SipSession;Ljava/lang/String;)V
    .registers 3
    .parameter "session"
    .parameter "sessionDescription"

    .prologue
    return-void
.end method

.method public onCallTransferring(Landroid/net/sip/SipSession;Ljava/lang/String;)V
    .registers 3
    .parameter "newSession"
    .parameter "sessionDescription"

    .prologue
    return-void
.end method

.method public onCalling(Landroid/net/sip/SipSession;)V
    .registers 2
    .parameter "session"

    .prologue
    return-void
.end method

.method public onError(Landroid/net/sip/SipSession;ILjava/lang/String;)V
    .registers 4
    .parameter "session"
    .parameter "errorCode"
    .parameter "errorMessage"

    .prologue
    return-void
.end method

.method public onRegistering(Landroid/net/sip/SipSession;)V
    .registers 2
    .parameter "session"

    .prologue
    return-void
.end method

.method public onRegistrationDone(Landroid/net/sip/SipSession;I)V
    .registers 3
    .parameter "session"
    .parameter "duration"

    .prologue
    return-void
.end method

.method public onRegistrationFailed(Landroid/net/sip/SipSession;ILjava/lang/String;)V
    .registers 4
    .parameter "session"
    .parameter "errorCode"
    .parameter "errorMessage"

    .prologue
    return-void
.end method

.method public onRegistrationTimeout(Landroid/net/sip/SipSession;)V
    .registers 2
    .parameter "session"

    .prologue
    return-void
.end method

.method public onRinging(Landroid/net/sip/SipSession;Landroid/net/sip/SipProfile;Ljava/lang/String;)V
    .registers 4
    .parameter "session"
    .parameter "caller"
    .parameter "sessionDescription"

    .prologue
    return-void
.end method

.method public onRingingBack(Landroid/net/sip/SipSession;)V
    .registers 2
    .parameter "session"

    .prologue
    return-void
.end method
