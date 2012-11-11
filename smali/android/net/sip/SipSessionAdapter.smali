.class public Landroid/net/sip/SipSessionAdapter;
.super Landroid/net/sip/ISipSessionListener$Stub;
.source "SipSessionAdapter.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct {p0}, Landroid/net/sip/ISipSessionListener$Stub;-><init>()V

    return-void
.end method


# virtual methods
.method public onCallBusy(Landroid/net/sip/ISipSession;)V
    .registers 2
    .parameter "session"

    .prologue
    return-void
.end method

.method public onCallChangeFailed(Landroid/net/sip/ISipSession;ILjava/lang/String;)V
    .registers 4
    .parameter "session"
    .parameter "errorCode"
    .parameter "message"

    .prologue
    return-void
.end method

.method public onCallEnded(Landroid/net/sip/ISipSession;)V
    .registers 2
    .parameter "session"

    .prologue
    return-void
.end method

.method public onCallEstablished(Landroid/net/sip/ISipSession;Ljava/lang/String;)V
    .registers 3
    .parameter "session"
    .parameter "sessionDescription"

    .prologue
    return-void
.end method

.method public onCallTransferring(Landroid/net/sip/ISipSession;Ljava/lang/String;)V
    .registers 3
    .parameter "session"
    .parameter "sessionDescription"

    .prologue
    return-void
.end method

.method public onCalling(Landroid/net/sip/ISipSession;)V
    .registers 2
    .parameter "session"

    .prologue
    return-void
.end method

.method public onError(Landroid/net/sip/ISipSession;ILjava/lang/String;)V
    .registers 4
    .parameter "session"
    .parameter "errorCode"
    .parameter "message"

    .prologue
    return-void
.end method

.method public onRegistering(Landroid/net/sip/ISipSession;)V
    .registers 2
    .parameter "session"

    .prologue
    return-void
.end method

.method public onRegistrationDone(Landroid/net/sip/ISipSession;I)V
    .registers 3
    .parameter "session"
    .parameter "duration"

    .prologue
    return-void
.end method

.method public onRegistrationFailed(Landroid/net/sip/ISipSession;ILjava/lang/String;)V
    .registers 4
    .parameter "session"
    .parameter "errorCode"
    .parameter "message"

    .prologue
    return-void
.end method

.method public onRegistrationTimeout(Landroid/net/sip/ISipSession;)V
    .registers 2
    .parameter "session"

    .prologue
    return-void
.end method

.method public onRinging(Landroid/net/sip/ISipSession;Landroid/net/sip/SipProfile;Ljava/lang/String;)V
    .registers 4
    .parameter "session"
    .parameter "caller"
    .parameter "sessionDescription"

    .prologue
    return-void
.end method

.method public onRingingBack(Landroid/net/sip/ISipSession;)V
    .registers 2
    .parameter "session"

    .prologue
    return-void
.end method
