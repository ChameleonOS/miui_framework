.class Landroid/net/sip/SipAudioCall$1;
.super Landroid/net/sip/SipSession$Listener;
.source "SipAudioCall.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/net/sip/SipAudioCall;->createListener()Landroid/net/sip/SipSession$Listener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/net/sip/SipAudioCall;


# direct methods
.method constructor <init>(Landroid/net/sip/SipAudioCall;)V
    .registers 2
    .parameter

    .prologue
    .line 382
    iput-object p1, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    invoke-direct {p0}, Landroid/net/sip/SipSession$Listener;-><init>()V

    return-void
.end method


# virtual methods
.method public onCallBusy(Landroid/net/sip/SipSession;)V
    .registers 7
    .parameter "session"

    .prologue
    .line 486
    invoke-static {}, Landroid/net/sip/SipAudioCall;->access$000()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "sip call busy: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 487
    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    #getter for: Landroid/net/sip/SipAudioCall;->mListener:Landroid/net/sip/SipAudioCall$Listener;
    invoke-static {v2}, Landroid/net/sip/SipAudioCall;->access$100(Landroid/net/sip/SipAudioCall;)Landroid/net/sip/SipAudioCall$Listener;

    move-result-object v0

    .line 488
    .local v0, listener:Landroid/net/sip/SipAudioCall$Listener;
    if-eqz v0, :cond_28

    .line 490
    :try_start_23
    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    invoke-virtual {v0, v2}, Landroid/net/sip/SipAudioCall$Listener;->onCallBusy(Landroid/net/sip/SipAudioCall;)V
    :try_end_28
    .catch Ljava/lang/Throwable; {:try_start_23 .. :try_end_28} :catch_2f

    .line 495
    :cond_28
    :goto_28
    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    const/4 v3, 0x0

    #calls: Landroid/net/sip/SipAudioCall;->close(Z)V
    invoke-static {v2, v3}, Landroid/net/sip/SipAudioCall;->access$900(Landroid/net/sip/SipAudioCall;Z)V

    .line 496
    return-void

    .line 491
    :catch_2f
    move-exception v1

    .line 492
    .local v1, t:Ljava/lang/Throwable;
    invoke-static {}, Landroid/net/sip/SipAudioCall;->access$000()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "onCallBusy(): "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_28
.end method

.method public onCallChangeFailed(Landroid/net/sip/SipSession;ILjava/lang/String;)V
    .registers 9
    .parameter "session"
    .parameter "errorCode"
    .parameter "message"

    .prologue
    .line 501
    invoke-static {}, Landroid/net/sip/SipAudioCall;->access$000()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "sip call change failed: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 502
    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    #setter for: Landroid/net/sip/SipAudioCall;->mErrorCode:I
    invoke-static {v2, p2}, Landroid/net/sip/SipAudioCall;->access$1002(Landroid/net/sip/SipAudioCall;I)I

    .line 503
    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    #setter for: Landroid/net/sip/SipAudioCall;->mErrorMessage:Ljava/lang/String;
    invoke-static {v2, p3}, Landroid/net/sip/SipAudioCall;->access$1102(Landroid/net/sip/SipAudioCall;Ljava/lang/String;)Ljava/lang/String;

    .line 504
    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    #getter for: Landroid/net/sip/SipAudioCall;->mListener:Landroid/net/sip/SipAudioCall$Listener;
    invoke-static {v2}, Landroid/net/sip/SipAudioCall;->access$100(Landroid/net/sip/SipAudioCall;)Landroid/net/sip/SipAudioCall$Listener;

    move-result-object v0

    .line 505
    .local v0, listener:Landroid/net/sip/SipAudioCall$Listener;
    if-eqz v0, :cond_38

    .line 507
    :try_start_2d
    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    iget-object v3, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    #getter for: Landroid/net/sip/SipAudioCall;->mErrorCode:I
    invoke-static {v3}, Landroid/net/sip/SipAudioCall;->access$1000(Landroid/net/sip/SipAudioCall;)I

    move-result v3

    invoke-virtual {v0, v2, v3, p3}, Landroid/net/sip/SipAudioCall$Listener;->onError(Landroid/net/sip/SipAudioCall;ILjava/lang/String;)V
    :try_end_38
    .catch Ljava/lang/Throwable; {:try_start_2d .. :try_end_38} :catch_39

    .line 513
    :cond_38
    :goto_38
    return-void

    .line 509
    :catch_39
    move-exception v1

    .line 510
    .local v1, t:Ljava/lang/Throwable;
    invoke-static {}, Landroid/net/sip/SipAudioCall;->access$000()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "onCallBusy(): "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_38
.end method

.method public onCallEnded(Landroid/net/sip/SipSession;)V
    .registers 7
    .parameter "session"

    .prologue
    .line 462
    invoke-static {}, Landroid/net/sip/SipAudioCall;->access$000()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "sip call ended: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " mSipSession:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    #getter for: Landroid/net/sip/SipAudioCall;->mSipSession:Landroid/net/sip/SipSession;
    invoke-static {v4}, Landroid/net/sip/SipAudioCall;->access$200(Landroid/net/sip/SipAudioCall;)Landroid/net/sip/SipSession;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 464
    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    #getter for: Landroid/net/sip/SipAudioCall;->mTransferringSession:Landroid/net/sip/SipSession;
    invoke-static {v2}, Landroid/net/sip/SipAudioCall;->access$600(Landroid/net/sip/SipAudioCall;)Landroid/net/sip/SipSession;

    move-result-object v2

    if-ne p1, v2, :cond_3a

    .line 465
    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    const/4 v3, 0x0

    #setter for: Landroid/net/sip/SipAudioCall;->mTransferringSession:Landroid/net/sip/SipSession;
    invoke-static {v2, v3}, Landroid/net/sip/SipAudioCall;->access$602(Landroid/net/sip/SipAudioCall;Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession;

    .line 482
    :cond_39
    :goto_39
    return-void

    .line 470
    :cond_3a
    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    #getter for: Landroid/net/sip/SipAudioCall;->mTransferringSession:Landroid/net/sip/SipSession;
    invoke-static {v2}, Landroid/net/sip/SipAudioCall;->access$600(Landroid/net/sip/SipAudioCall;)Landroid/net/sip/SipSession;

    move-result-object v2

    if-nez v2, :cond_39

    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    #getter for: Landroid/net/sip/SipAudioCall;->mSipSession:Landroid/net/sip/SipSession;
    invoke-static {v2}, Landroid/net/sip/SipAudioCall;->access$200(Landroid/net/sip/SipAudioCall;)Landroid/net/sip/SipSession;

    move-result-object v2

    if-ne p1, v2, :cond_39

    .line 473
    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    #getter for: Landroid/net/sip/SipAudioCall;->mListener:Landroid/net/sip/SipAudioCall$Listener;
    invoke-static {v2}, Landroid/net/sip/SipAudioCall;->access$100(Landroid/net/sip/SipAudioCall;)Landroid/net/sip/SipAudioCall$Listener;

    move-result-object v0

    .line 474
    .local v0, listener:Landroid/net/sip/SipAudioCall$Listener;
    if-eqz v0, :cond_57

    .line 476
    :try_start_52
    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    invoke-virtual {v0, v2}, Landroid/net/sip/SipAudioCall$Listener;->onCallEnded(Landroid/net/sip/SipAudioCall;)V
    :try_end_57
    .catch Ljava/lang/Throwable; {:try_start_52 .. :try_end_57} :catch_5d

    .line 481
    :cond_57
    :goto_57
    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    invoke-virtual {v2}, Landroid/net/sip/SipAudioCall;->close()V

    goto :goto_39

    .line 477
    :catch_5d
    move-exception v1

    .line 478
    .local v1, t:Ljava/lang/Throwable;
    invoke-static {}, Landroid/net/sip/SipAudioCall;->access$000()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "onCallEnded(): "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_57
.end method

.method public onCallEstablished(Landroid/net/sip/SipSession;Ljava/lang/String;)V
    .registers 8
    .parameter "session"
    .parameter "sessionDescription"

    .prologue
    .line 436
    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    #setter for: Landroid/net/sip/SipAudioCall;->mPeerSd:Ljava/lang/String;
    invoke-static {v2, p2}, Landroid/net/sip/SipAudioCall;->access$502(Landroid/net/sip/SipAudioCall;Ljava/lang/String;)Ljava/lang/String;

    .line 437
    invoke-static {}, Landroid/net/sip/SipAudioCall;->access$000()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "onCallEstablished()"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    #getter for: Landroid/net/sip/SipAudioCall;->mPeerSd:Ljava/lang/String;
    invoke-static {v4}, Landroid/net/sip/SipAudioCall;->access$500(Landroid/net/sip/SipAudioCall;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 440
    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    #getter for: Landroid/net/sip/SipAudioCall;->mTransferringSession:Landroid/net/sip/SipSession;
    invoke-static {v2}, Landroid/net/sip/SipAudioCall;->access$600(Landroid/net/sip/SipAudioCall;)Landroid/net/sip/SipSession;

    move-result-object v2

    if-eqz v2, :cond_3c

    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    #getter for: Landroid/net/sip/SipAudioCall;->mTransferringSession:Landroid/net/sip/SipSession;
    invoke-static {v2}, Landroid/net/sip/SipAudioCall;->access$600(Landroid/net/sip/SipAudioCall;)Landroid/net/sip/SipSession;

    move-result-object v2

    if-ne p1, v2, :cond_3c

    .line 442
    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    #calls: Landroid/net/sip/SipAudioCall;->transferToNewSession()V
    invoke-static {v2}, Landroid/net/sip/SipAudioCall;->access$700(Landroid/net/sip/SipAudioCall;)V

    .line 458
    :cond_3b
    :goto_3b
    return-void

    .line 446
    :cond_3c
    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    #getter for: Landroid/net/sip/SipAudioCall;->mListener:Landroid/net/sip/SipAudioCall$Listener;
    invoke-static {v2}, Landroid/net/sip/SipAudioCall;->access$100(Landroid/net/sip/SipAudioCall;)Landroid/net/sip/SipAudioCall$Listener;

    move-result-object v0

    .line 447
    .local v0, listener:Landroid/net/sip/SipAudioCall$Listener;
    if-eqz v0, :cond_3b

    .line 449
    :try_start_44
    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    #getter for: Landroid/net/sip/SipAudioCall;->mHold:Z
    invoke-static {v2}, Landroid/net/sip/SipAudioCall;->access$800(Landroid/net/sip/SipAudioCall;)Z

    move-result v2

    if-eqz v2, :cond_6f

    .line 450
    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    invoke-virtual {v0, v2}, Landroid/net/sip/SipAudioCall$Listener;->onCallHeld(Landroid/net/sip/SipAudioCall;)V
    :try_end_51
    .catch Ljava/lang/Throwable; {:try_start_44 .. :try_end_51} :catch_52

    goto :goto_3b

    .line 454
    :catch_52
    move-exception v1

    .line 455
    .local v1, t:Ljava/lang/Throwable;
    invoke-static {}, Landroid/net/sip/SipAudioCall;->access$000()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "onCallEstablished(): "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_3b

    .line 452
    .end local v1           #t:Ljava/lang/Throwable;
    :cond_6f
    :try_start_6f
    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    invoke-virtual {v0, v2}, Landroid/net/sip/SipAudioCall$Listener;->onCallEstablished(Landroid/net/sip/SipAudioCall;)V
    :try_end_74
    .catch Ljava/lang/Throwable; {:try_start_6f .. :try_end_74} :catch_52

    goto :goto_3b
.end method

.method public onCallTransferring(Landroid/net/sip/SipSession;Ljava/lang/String;)V
    .registers 8
    .parameter "newSession"
    .parameter "sessionDescription"

    .prologue
    .line 545
    invoke-static {}, Landroid/net/sip/SipAudioCall;->access$000()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "onCallTransferring mSipSession:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    #getter for: Landroid/net/sip/SipAudioCall;->mSipSession:Landroid/net/sip/SipSession;
    invoke-static {v4}, Landroid/net/sip/SipAudioCall;->access$200(Landroid/net/sip/SipAudioCall;)Landroid/net/sip/SipSession;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " newSession:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 547
    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    #setter for: Landroid/net/sip/SipAudioCall;->mTransferringSession:Landroid/net/sip/SipSession;
    invoke-static {v2, p1}, Landroid/net/sip/SipAudioCall;->access$602(Landroid/net/sip/SipAudioCall;Landroid/net/sip/SipSession;)Landroid/net/sip/SipSession;

    .line 549
    if-nez p2, :cond_46

    .line 550
    :try_start_32
    invoke-virtual {p1}, Landroid/net/sip/SipSession;->getPeerProfile()Landroid/net/sip/SipProfile;

    move-result-object v2

    iget-object v3, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    #calls: Landroid/net/sip/SipAudioCall;->createOffer()Landroid/net/sip/SimpleSessionDescription;
    invoke-static {v3}, Landroid/net/sip/SipAudioCall;->access$1300(Landroid/net/sip/SipAudioCall;)Landroid/net/sip/SimpleSessionDescription;

    move-result-object v3

    invoke-virtual {v3}, Landroid/net/sip/SimpleSessionDescription;->encode()Ljava/lang/String;

    move-result-object v3

    const/16 v4, 0xf

    invoke-virtual {p1, v2, v3, v4}, Landroid/net/sip/SipSession;->makeCall(Landroid/net/sip/SipProfile;Ljava/lang/String;I)V

    .line 560
    :goto_45
    return-void

    .line 553
    :cond_46
    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    #calls: Landroid/net/sip/SipAudioCall;->createAnswer(Ljava/lang/String;)Landroid/net/sip/SimpleSessionDescription;
    invoke-static {v2, p2}, Landroid/net/sip/SipAudioCall;->access$400(Landroid/net/sip/SipAudioCall;Ljava/lang/String;)Landroid/net/sip/SimpleSessionDescription;

    move-result-object v2

    invoke-virtual {v2}, Landroid/net/sip/SimpleSessionDescription;->encode()Ljava/lang/String;

    move-result-object v0

    .line 554
    .local v0, answer:Ljava/lang/String;
    const/4 v2, 0x5

    invoke-virtual {p1, v0, v2}, Landroid/net/sip/SipSession;->answerCall(Ljava/lang/String;I)V
    :try_end_54
    .catch Ljava/lang/Throwable; {:try_start_32 .. :try_end_54} :catch_55

    goto :goto_45

    .line 556
    .end local v0           #answer:Ljava/lang/String;
    :catch_55
    move-exception v1

    .line 557
    .local v1, e:Ljava/lang/Throwable;
    invoke-static {}, Landroid/net/sip/SipAudioCall;->access$000()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "onCallTransferring()"

    invoke-static {v2, v3, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 558
    invoke-virtual {p1}, Landroid/net/sip/SipSession;->endCall()V

    goto :goto_45
.end method

.method public onCalling(Landroid/net/sip/SipSession;)V
    .registers 7
    .parameter "session"

    .prologue
    .line 385
    invoke-static {}, Landroid/net/sip/SipAudioCall;->access$000()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "calling... "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 386
    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    #getter for: Landroid/net/sip/SipAudioCall;->mListener:Landroid/net/sip/SipAudioCall$Listener;
    invoke-static {v2}, Landroid/net/sip/SipAudioCall;->access$100(Landroid/net/sip/SipAudioCall;)Landroid/net/sip/SipAudioCall$Listener;

    move-result-object v0

    .line 387
    .local v0, listener:Landroid/net/sip/SipAudioCall$Listener;
    if-eqz v0, :cond_27

    .line 389
    :try_start_22
    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    invoke-virtual {v0, v2}, Landroid/net/sip/SipAudioCall$Listener;->onCalling(Landroid/net/sip/SipAudioCall;)V
    :try_end_27
    .catch Ljava/lang/Throwable; {:try_start_22 .. :try_end_27} :catch_28

    .line 394
    :cond_27
    :goto_27
    return-void

    .line 390
    :catch_28
    move-exception v1

    .line 391
    .local v1, t:Ljava/lang/Throwable;
    invoke-static {}, Landroid/net/sip/SipAudioCall;->access$000()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "onCalling(): "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_27
.end method

.method public onError(Landroid/net/sip/SipSession;ILjava/lang/String;)V
    .registers 5
    .parameter "session"
    .parameter "errorCode"
    .parameter "message"

    .prologue
    .line 518
    iget-object v0, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    #calls: Landroid/net/sip/SipAudioCall;->onError(ILjava/lang/String;)V
    invoke-static {v0, p2, p3}, Landroid/net/sip/SipAudioCall;->access$1200(Landroid/net/sip/SipAudioCall;ILjava/lang/String;)V

    .line 519
    return-void
.end method

.method public onRegistering(Landroid/net/sip/SipSession;)V
    .registers 2
    .parameter "session"

    .prologue
    .line 524
    return-void
.end method

.method public onRegistrationDone(Landroid/net/sip/SipSession;I)V
    .registers 3
    .parameter "session"
    .parameter "duration"

    .prologue
    .line 540
    return-void
.end method

.method public onRegistrationFailed(Landroid/net/sip/SipSession;ILjava/lang/String;)V
    .registers 4
    .parameter "session"
    .parameter "errorCode"
    .parameter "message"

    .prologue
    .line 535
    return-void
.end method

.method public onRegistrationTimeout(Landroid/net/sip/SipSession;)V
    .registers 2
    .parameter "session"

    .prologue
    .line 529
    return-void
.end method

.method public onRinging(Landroid/net/sip/SipSession;Landroid/net/sip/SipProfile;Ljava/lang/String;)V
    .registers 9
    .parameter "session"
    .parameter "peerProfile"
    .parameter "sessionDescription"

    .prologue
    .line 413
    iget-object v3, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    monitor-enter v3

    .line 414
    :try_start_3
    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    #getter for: Landroid/net/sip/SipAudioCall;->mSipSession:Landroid/net/sip/SipSession;
    invoke-static {v2}, Landroid/net/sip/SipAudioCall;->access$200(Landroid/net/sip/SipAudioCall;)Landroid/net/sip/SipSession;

    move-result-object v2

    if-eqz v2, :cond_27

    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    #getter for: Landroid/net/sip/SipAudioCall;->mInCall:Z
    invoke-static {v2}, Landroid/net/sip/SipAudioCall;->access$300(Landroid/net/sip/SipAudioCall;)Z

    move-result v2

    if-eqz v2, :cond_27

    invoke-virtual {p1}, Landroid/net/sip/SipSession;->getCallId()Ljava/lang/String;

    move-result-object v2

    iget-object v4, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    #getter for: Landroid/net/sip/SipAudioCall;->mSipSession:Landroid/net/sip/SipSession;
    invoke-static {v4}, Landroid/net/sip/SipAudioCall;->access$200(Landroid/net/sip/SipAudioCall;)Landroid/net/sip/SipSession;

    move-result-object v4

    invoke-virtual {v4}, Landroid/net/sip/SipSession;->getCallId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2c

    .line 418
    :cond_27
    invoke-virtual {p1}, Landroid/net/sip/SipSession;->endCall()V

    .line 419
    monitor-exit v3
    :try_end_2b
    .catchall {:try_start_3 .. :try_end_2b} :catchall_42

    .line 431
    :goto_2b
    return-void

    .line 424
    :cond_2c
    :try_start_2c
    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    #calls: Landroid/net/sip/SipAudioCall;->createAnswer(Ljava/lang/String;)Landroid/net/sip/SimpleSessionDescription;
    invoke-static {v2, p3}, Landroid/net/sip/SipAudioCall;->access$400(Landroid/net/sip/SipAudioCall;Ljava/lang/String;)Landroid/net/sip/SimpleSessionDescription;

    move-result-object v2

    invoke-virtual {v2}, Landroid/net/sip/SimpleSessionDescription;->encode()Ljava/lang/String;

    move-result-object v0

    .line 425
    .local v0, answer:Ljava/lang/String;
    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    #getter for: Landroid/net/sip/SipAudioCall;->mSipSession:Landroid/net/sip/SipSession;
    invoke-static {v2}, Landroid/net/sip/SipAudioCall;->access$200(Landroid/net/sip/SipAudioCall;)Landroid/net/sip/SipSession;

    move-result-object v2

    const/4 v4, 0x5

    invoke-virtual {v2, v0, v4}, Landroid/net/sip/SipSession;->answerCall(Ljava/lang/String;I)V
    :try_end_40
    .catchall {:try_start_2c .. :try_end_40} :catchall_42
    .catch Ljava/lang/Throwable; {:try_start_2c .. :try_end_40} :catch_45

    .line 430
    .end local v0           #answer:Ljava/lang/String;
    :goto_40
    :try_start_40
    monitor-exit v3

    goto :goto_2b

    :catchall_42
    move-exception v2

    monitor-exit v3
    :try_end_44
    .catchall {:try_start_40 .. :try_end_44} :catchall_42

    throw v2

    .line 426
    :catch_45
    move-exception v1

    .line 427
    .local v1, e:Ljava/lang/Throwable;
    :try_start_46
    invoke-static {}, Landroid/net/sip/SipAudioCall;->access$000()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v4, "onRinging()"

    invoke-static {v2, v4, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 428
    invoke-virtual {p1}, Landroid/net/sip/SipSession;->endCall()V
    :try_end_53
    .catchall {:try_start_46 .. :try_end_53} :catchall_42

    goto :goto_40
.end method

.method public onRingingBack(Landroid/net/sip/SipSession;)V
    .registers 7
    .parameter "session"

    .prologue
    .line 398
    invoke-static {}, Landroid/net/sip/SipAudioCall;->access$000()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "sip call ringing back: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 399
    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    #getter for: Landroid/net/sip/SipAudioCall;->mListener:Landroid/net/sip/SipAudioCall$Listener;
    invoke-static {v2}, Landroid/net/sip/SipAudioCall;->access$100(Landroid/net/sip/SipAudioCall;)Landroid/net/sip/SipAudioCall$Listener;

    move-result-object v0

    .line 400
    .local v0, listener:Landroid/net/sip/SipAudioCall$Listener;
    if-eqz v0, :cond_28

    .line 402
    :try_start_23
    iget-object v2, p0, Landroid/net/sip/SipAudioCall$1;->this$0:Landroid/net/sip/SipAudioCall;

    invoke-virtual {v0, v2}, Landroid/net/sip/SipAudioCall$Listener;->onRingingBack(Landroid/net/sip/SipAudioCall;)V
    :try_end_28
    .catch Ljava/lang/Throwable; {:try_start_23 .. :try_end_28} :catch_29

    .line 407
    :cond_28
    :goto_28
    return-void

    .line 403
    :catch_29
    move-exception v1

    .line 404
    .local v1, t:Ljava/lang/Throwable;
    invoke-static {}, Landroid/net/sip/SipAudioCall;->access$000()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "onRingingBack(): "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_28
.end method
