.class Landroid/net/sip/SipSession$1;
.super Landroid/net/sip/ISipSessionListener$Stub;
.source "SipSession.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/net/sip/SipSession;->createListener()Landroid/net/sip/ISipSessionListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/net/sip/SipSession;


# direct methods
.method constructor <init>(Landroid/net/sip/SipSession;)V
    .registers 2
    .parameter

    .prologue
    .line 465
    iput-object p1, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    invoke-direct {p0}, Landroid/net/sip/ISipSessionListener$Stub;-><init>()V

    return-void
.end method


# virtual methods
.method public onCallBusy(Landroid/net/sip/ISipSession;)V
    .registers 4
    .parameter "session"

    .prologue
    .line 501
    iget-object v0, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    #getter for: Landroid/net/sip/SipSession;->mListener:Landroid/net/sip/SipSession$Listener;
    invoke-static {v0}, Landroid/net/sip/SipSession;->access$000(Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession$Listener;

    move-result-object v0

    if-eqz v0, :cond_13

    .line 502
    iget-object v0, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    #getter for: Landroid/net/sip/SipSession;->mListener:Landroid/net/sip/SipSession$Listener;
    invoke-static {v0}, Landroid/net/sip/SipSession;->access$000(Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession$Listener;

    move-result-object v0

    iget-object v1, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    invoke-virtual {v0, v1}, Landroid/net/sip/SipSession$Listener;->onCallBusy(Landroid/net/sip/SipSession;)V

    .line 504
    :cond_13
    return-void
.end method

.method public onCallChangeFailed(Landroid/net/sip/ISipSession;ILjava/lang/String;)V
    .registers 6
    .parameter "session"
    .parameter "errorCode"
    .parameter "message"

    .prologue
    .line 518
    iget-object v0, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    #getter for: Landroid/net/sip/SipSession;->mListener:Landroid/net/sip/SipSession$Listener;
    invoke-static {v0}, Landroid/net/sip/SipSession;->access$000(Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession$Listener;

    move-result-object v0

    if-eqz v0, :cond_13

    .line 519
    iget-object v0, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    #getter for: Landroid/net/sip/SipSession;->mListener:Landroid/net/sip/SipSession$Listener;
    invoke-static {v0}, Landroid/net/sip/SipSession;->access$000(Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession$Listener;

    move-result-object v0

    iget-object v1, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    invoke-virtual {v0, v1, p2, p3}, Landroid/net/sip/SipSession$Listener;->onCallChangeFailed(Landroid/net/sip/SipSession;ILjava/lang/String;)V

    .line 522
    :cond_13
    return-void
.end method

.method public onCallEnded(Landroid/net/sip/ISipSession;)V
    .registers 4
    .parameter "session"

    .prologue
    .line 495
    iget-object v0, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    #getter for: Landroid/net/sip/SipSession;->mListener:Landroid/net/sip/SipSession$Listener;
    invoke-static {v0}, Landroid/net/sip/SipSession;->access$000(Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession$Listener;

    move-result-object v0

    if-eqz v0, :cond_13

    .line 496
    iget-object v0, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    #getter for: Landroid/net/sip/SipSession;->mListener:Landroid/net/sip/SipSession$Listener;
    invoke-static {v0}, Landroid/net/sip/SipSession;->access$000(Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession$Listener;

    move-result-object v0

    iget-object v1, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    invoke-virtual {v0, v1}, Landroid/net/sip/SipSession$Listener;->onCallEnded(Landroid/net/sip/SipSession;)V

    .line 498
    :cond_13
    return-void
.end method

.method public onCallEstablished(Landroid/net/sip/ISipSession;Ljava/lang/String;)V
    .registers 5
    .parameter "session"
    .parameter "sessionDescription"

    .prologue
    .line 488
    iget-object v0, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    #getter for: Landroid/net/sip/SipSession;->mListener:Landroid/net/sip/SipSession$Listener;
    invoke-static {v0}, Landroid/net/sip/SipSession;->access$000(Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession$Listener;

    move-result-object v0

    if-eqz v0, :cond_13

    .line 489
    iget-object v0, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    #getter for: Landroid/net/sip/SipSession;->mListener:Landroid/net/sip/SipSession$Listener;
    invoke-static {v0}, Landroid/net/sip/SipSession;->access$000(Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession$Listener;

    move-result-object v0

    iget-object v1, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    invoke-virtual {v0, v1, p2}, Landroid/net/sip/SipSession$Listener;->onCallEstablished(Landroid/net/sip/SipSession;Ljava/lang/String;)V

    .line 492
    :cond_13
    return-void
.end method

.method public onCallTransferring(Landroid/net/sip/ISipSession;Ljava/lang/String;)V
    .registers 6
    .parameter "session"
    .parameter "sessionDescription"

    .prologue
    .line 508
    iget-object v0, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    #getter for: Landroid/net/sip/SipSession;->mListener:Landroid/net/sip/SipSession$Listener;
    invoke-static {v0}, Landroid/net/sip/SipSession;->access$000(Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession$Listener;

    move-result-object v0

    if-eqz v0, :cond_1c

    .line 509
    iget-object v0, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    #getter for: Landroid/net/sip/SipSession;->mListener:Landroid/net/sip/SipSession$Listener;
    invoke-static {v0}, Landroid/net/sip/SipSession;->access$000(Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession$Listener;

    move-result-object v0

    new-instance v1, Landroid/net/sip/SipSession;

    iget-object v2, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    #getter for: Landroid/net/sip/SipSession;->mListener:Landroid/net/sip/SipSession$Listener;
    invoke-static {v2}, Landroid/net/sip/SipSession;->access$000(Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession$Listener;

    move-result-object v2

    invoke-direct {v1, p1, v2}, Landroid/net/sip/SipSession;-><init>(Landroid/net/sip/ISipSession;Landroid/net/sip/SipSession$Listener;)V

    invoke-virtual {v0, v1, p2}, Landroid/net/sip/SipSession$Listener;->onCallTransferring(Landroid/net/sip/SipSession;Ljava/lang/String;)V

    .line 514
    :cond_1c
    return-void
.end method

.method public onCalling(Landroid/net/sip/ISipSession;)V
    .registers 4
    .parameter "session"

    .prologue
    .line 467
    iget-object v0, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    #getter for: Landroid/net/sip/SipSession;->mListener:Landroid/net/sip/SipSession$Listener;
    invoke-static {v0}, Landroid/net/sip/SipSession;->access$000(Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession$Listener;

    move-result-object v0

    if-eqz v0, :cond_13

    .line 468
    iget-object v0, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    #getter for: Landroid/net/sip/SipSession;->mListener:Landroid/net/sip/SipSession$Listener;
    invoke-static {v0}, Landroid/net/sip/SipSession;->access$000(Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession$Listener;

    move-result-object v0

    iget-object v1, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    invoke-virtual {v0, v1}, Landroid/net/sip/SipSession$Listener;->onCalling(Landroid/net/sip/SipSession;)V

    .line 470
    :cond_13
    return-void
.end method

.method public onError(Landroid/net/sip/ISipSession;ILjava/lang/String;)V
    .registers 6
    .parameter "session"
    .parameter "errorCode"
    .parameter "message"

    .prologue
    .line 525
    iget-object v0, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    #getter for: Landroid/net/sip/SipSession;->mListener:Landroid/net/sip/SipSession$Listener;
    invoke-static {v0}, Landroid/net/sip/SipSession;->access$000(Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession$Listener;

    move-result-object v0

    if-eqz v0, :cond_13

    .line 526
    iget-object v0, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    #getter for: Landroid/net/sip/SipSession;->mListener:Landroid/net/sip/SipSession$Listener;
    invoke-static {v0}, Landroid/net/sip/SipSession;->access$000(Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession$Listener;

    move-result-object v0

    iget-object v1, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    invoke-virtual {v0, v1, p2, p3}, Landroid/net/sip/SipSession$Listener;->onError(Landroid/net/sip/SipSession;ILjava/lang/String;)V

    .line 528
    :cond_13
    return-void
.end method

.method public onRegistering(Landroid/net/sip/ISipSession;)V
    .registers 4
    .parameter "session"

    .prologue
    .line 531
    iget-object v0, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    #getter for: Landroid/net/sip/SipSession;->mListener:Landroid/net/sip/SipSession$Listener;
    invoke-static {v0}, Landroid/net/sip/SipSession;->access$000(Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession$Listener;

    move-result-object v0

    if-eqz v0, :cond_13

    .line 532
    iget-object v0, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    #getter for: Landroid/net/sip/SipSession;->mListener:Landroid/net/sip/SipSession$Listener;
    invoke-static {v0}, Landroid/net/sip/SipSession;->access$000(Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession$Listener;

    move-result-object v0

    iget-object v1, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    invoke-virtual {v0, v1}, Landroid/net/sip/SipSession$Listener;->onRegistering(Landroid/net/sip/SipSession;)V

    .line 534
    :cond_13
    return-void
.end method

.method public onRegistrationDone(Landroid/net/sip/ISipSession;I)V
    .registers 5
    .parameter "session"
    .parameter "duration"

    .prologue
    .line 537
    iget-object v0, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    #getter for: Landroid/net/sip/SipSession;->mListener:Landroid/net/sip/SipSession$Listener;
    invoke-static {v0}, Landroid/net/sip/SipSession;->access$000(Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession$Listener;

    move-result-object v0

    if-eqz v0, :cond_13

    .line 538
    iget-object v0, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    #getter for: Landroid/net/sip/SipSession;->mListener:Landroid/net/sip/SipSession$Listener;
    invoke-static {v0}, Landroid/net/sip/SipSession;->access$000(Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession$Listener;

    move-result-object v0

    iget-object v1, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    invoke-virtual {v0, v1, p2}, Landroid/net/sip/SipSession$Listener;->onRegistrationDone(Landroid/net/sip/SipSession;I)V

    .line 540
    :cond_13
    return-void
.end method

.method public onRegistrationFailed(Landroid/net/sip/ISipSession;ILjava/lang/String;)V
    .registers 6
    .parameter "session"
    .parameter "errorCode"
    .parameter "message"

    .prologue
    .line 544
    iget-object v0, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    #getter for: Landroid/net/sip/SipSession;->mListener:Landroid/net/sip/SipSession$Listener;
    invoke-static {v0}, Landroid/net/sip/SipSession;->access$000(Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession$Listener;

    move-result-object v0

    if-eqz v0, :cond_13

    .line 545
    iget-object v0, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    #getter for: Landroid/net/sip/SipSession;->mListener:Landroid/net/sip/SipSession$Listener;
    invoke-static {v0}, Landroid/net/sip/SipSession;->access$000(Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession$Listener;

    move-result-object v0

    iget-object v1, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    invoke-virtual {v0, v1, p2, p3}, Landroid/net/sip/SipSession$Listener;->onRegistrationFailed(Landroid/net/sip/SipSession;ILjava/lang/String;)V

    .line 548
    :cond_13
    return-void
.end method

.method public onRegistrationTimeout(Landroid/net/sip/ISipSession;)V
    .registers 4
    .parameter "session"

    .prologue
    .line 551
    iget-object v0, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    #getter for: Landroid/net/sip/SipSession;->mListener:Landroid/net/sip/SipSession$Listener;
    invoke-static {v0}, Landroid/net/sip/SipSession;->access$000(Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession$Listener;

    move-result-object v0

    if-eqz v0, :cond_13

    .line 552
    iget-object v0, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    #getter for: Landroid/net/sip/SipSession;->mListener:Landroid/net/sip/SipSession$Listener;
    invoke-static {v0}, Landroid/net/sip/SipSession;->access$000(Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession$Listener;

    move-result-object v0

    iget-object v1, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    invoke-virtual {v0, v1}, Landroid/net/sip/SipSession$Listener;->onRegistrationTimeout(Landroid/net/sip/SipSession;)V

    .line 554
    :cond_13
    return-void
.end method

.method public onRinging(Landroid/net/sip/ISipSession;Landroid/net/sip/SipProfile;Ljava/lang/String;)V
    .registers 6
    .parameter "session"
    .parameter "caller"
    .parameter "sessionDescription"

    .prologue
    .line 474
    iget-object v0, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    #getter for: Landroid/net/sip/SipSession;->mListener:Landroid/net/sip/SipSession$Listener;
    invoke-static {v0}, Landroid/net/sip/SipSession;->access$000(Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession$Listener;

    move-result-object v0

    if-eqz v0, :cond_13

    .line 475
    iget-object v0, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    #getter for: Landroid/net/sip/SipSession;->mListener:Landroid/net/sip/SipSession$Listener;
    invoke-static {v0}, Landroid/net/sip/SipSession;->access$000(Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession$Listener;

    move-result-object v0

    iget-object v1, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    invoke-virtual {v0, v1, p2, p3}, Landroid/net/sip/SipSession$Listener;->onRinging(Landroid/net/sip/SipSession;Landroid/net/sip/SipProfile;Ljava/lang/String;)V

    .line 478
    :cond_13
    return-void
.end method

.method public onRingingBack(Landroid/net/sip/ISipSession;)V
    .registers 4
    .parameter "session"

    .prologue
    .line 481
    iget-object v0, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    #getter for: Landroid/net/sip/SipSession;->mListener:Landroid/net/sip/SipSession$Listener;
    invoke-static {v0}, Landroid/net/sip/SipSession;->access$000(Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession$Listener;

    move-result-object v0

    if-eqz v0, :cond_13

    .line 482
    iget-object v0, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    #getter for: Landroid/net/sip/SipSession;->mListener:Landroid/net/sip/SipSession$Listener;
    invoke-static {v0}, Landroid/net/sip/SipSession;->access$000(Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession$Listener;

    move-result-object v0

    iget-object v1, p0, Landroid/net/sip/SipSession$1;->this$0:Landroid/net/sip/SipSession;

    invoke-virtual {v0, v1}, Landroid/net/sip/SipSession$Listener;->onRingingBack(Landroid/net/sip/SipSession;)V

    .line 484
    :cond_13
    return-void
.end method
