.class Landroid/renderscript/RenderScript$MessageThread;
.super Ljava/lang/Thread;
.source "RenderScript.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/renderscript/RenderScript;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "MessageThread"
.end annotation


# static fields
.field static final RS_ERROR_FATAL_UNKNOWN:I = 0x1000

.field static final RS_MESSAGE_TO_CLIENT_ERROR:I = 0x3

.field static final RS_MESSAGE_TO_CLIENT_EXCEPTION:I = 0x1

.field static final RS_MESSAGE_TO_CLIENT_NONE:I = 0x0

.field static final RS_MESSAGE_TO_CLIENT_RESIZE:I = 0x2

.field static final RS_MESSAGE_TO_CLIENT_USER:I = 0x4


# instance fields
.field mAuxData:[I

.field mRS:Landroid/renderscript/RenderScript;

.field mRun:Z


# direct methods
.method constructor <init>(Landroid/renderscript/RenderScript;)V
    .registers 3
    .parameter "rs"

    .prologue
    .line 852
    const-string v0, "RSMessageThread"

    invoke-direct {p0, v0}, Ljava/lang/Thread;-><init>(Ljava/lang/String;)V

    .line 840
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/renderscript/RenderScript$MessageThread;->mRun:Z

    .line 841
    const/4 v0, 0x2

    new-array v0, v0, [I

    iput-object v0, p0, Landroid/renderscript/RenderScript$MessageThread;->mAuxData:[I

    .line 853
    iput-object p1, p0, Landroid/renderscript/RenderScript$MessageThread;->mRS:Landroid/renderscript/RenderScript;

    .line 855
    return-void
.end method


# virtual methods
.method public run()V
    .registers 11

    .prologue
    const/4 v9, 0x4

    const/4 v8, 0x0

    .line 860
    const/16 v5, 0x10

    new-array v2, v5, [I

    .line 861
    .local v2, rbuf:[I
    iget-object v5, p0, Landroid/renderscript/RenderScript$MessageThread;->mRS:Landroid/renderscript/RenderScript;

    iget-object v6, p0, Landroid/renderscript/RenderScript$MessageThread;->mRS:Landroid/renderscript/RenderScript;

    iget v6, v6, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {v5, v6}, Landroid/renderscript/RenderScript;->nContextInitToClient(I)V

    .line 862
    :cond_f
    :goto_f
    iget-boolean v5, p0, Landroid/renderscript/RenderScript$MessageThread;->mRun:Z

    if-eqz v5, :cond_cd

    .line 863
    aput v8, v2, v8

    .line 864
    iget-object v5, p0, Landroid/renderscript/RenderScript$MessageThread;->mRS:Landroid/renderscript/RenderScript;

    iget-object v6, p0, Landroid/renderscript/RenderScript$MessageThread;->mRS:Landroid/renderscript/RenderScript;

    iget v6, v6, Landroid/renderscript/RenderScript;->mContext:I

    iget-object v7, p0, Landroid/renderscript/RenderScript$MessageThread;->mAuxData:[I

    invoke-virtual {v5, v6, v7}, Landroid/renderscript/RenderScript;->nContextPeekMessage(I[I)I

    move-result v1

    .line 865
    .local v1, msg:I
    iget-object v5, p0, Landroid/renderscript/RenderScript$MessageThread;->mAuxData:[I

    const/4 v6, 0x1

    aget v3, v5, v6

    .line 866
    .local v3, size:I
    iget-object v5, p0, Landroid/renderscript/RenderScript$MessageThread;->mAuxData:[I

    aget v4, v5, v8

    .line 868
    .local v4, subID:I
    if-ne v1, v9, :cond_73

    .line 869
    shr-int/lit8 v5, v3, 0x2

    array-length v6, v2

    if-lt v5, v6, :cond_37

    .line 870
    add-int/lit8 v5, v3, 0x3

    shr-int/lit8 v5, v5, 0x2

    new-array v2, v5, [I

    .line 872
    :cond_37
    iget-object v5, p0, Landroid/renderscript/RenderScript$MessageThread;->mRS:Landroid/renderscript/RenderScript;

    iget-object v6, p0, Landroid/renderscript/RenderScript$MessageThread;->mRS:Landroid/renderscript/RenderScript;

    iget v6, v6, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {v5, v6, v2}, Landroid/renderscript/RenderScript;->nContextGetUserMessage(I[I)I

    move-result v5

    if-eq v5, v9, :cond_4b

    .line 874
    new-instance v5, Landroid/renderscript/RSDriverException;

    const-string v6, "Error processing message from Renderscript."

    invoke-direct {v5, v6}, Landroid/renderscript/RSDriverException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 877
    :cond_4b
    iget-object v5, p0, Landroid/renderscript/RenderScript$MessageThread;->mRS:Landroid/renderscript/RenderScript;

    iget-object v5, v5, Landroid/renderscript/RenderScript;->mMessageCallback:Landroid/renderscript/RenderScript$RSMessageHandler;

    if-eqz v5, :cond_6b

    .line 878
    iget-object v5, p0, Landroid/renderscript/RenderScript$MessageThread;->mRS:Landroid/renderscript/RenderScript;

    iget-object v5, v5, Landroid/renderscript/RenderScript;->mMessageCallback:Landroid/renderscript/RenderScript$RSMessageHandler;

    iput-object v2, v5, Landroid/renderscript/RenderScript$RSMessageHandler;->mData:[I

    .line 879
    iget-object v5, p0, Landroid/renderscript/RenderScript$MessageThread;->mRS:Landroid/renderscript/RenderScript;

    iget-object v5, v5, Landroid/renderscript/RenderScript;->mMessageCallback:Landroid/renderscript/RenderScript$RSMessageHandler;

    iput v4, v5, Landroid/renderscript/RenderScript$RSMessageHandler;->mID:I

    .line 880
    iget-object v5, p0, Landroid/renderscript/RenderScript$MessageThread;->mRS:Landroid/renderscript/RenderScript;

    iget-object v5, v5, Landroid/renderscript/RenderScript;->mMessageCallback:Landroid/renderscript/RenderScript$RSMessageHandler;

    iput v3, v5, Landroid/renderscript/RenderScript$RSMessageHandler;->mLength:I

    .line 881
    iget-object v5, p0, Landroid/renderscript/RenderScript$MessageThread;->mRS:Landroid/renderscript/RenderScript;

    iget-object v5, v5, Landroid/renderscript/RenderScript;->mMessageCallback:Landroid/renderscript/RenderScript$RSMessageHandler;

    invoke-virtual {v5}, Landroid/renderscript/RenderScript$RSMessageHandler;->run()V

    goto :goto_f

    .line 883
    :cond_6b
    new-instance v5, Landroid/renderscript/RSInvalidStateException;

    const-string v6, "Received a message from the script with no message handler installed."

    invoke-direct {v5, v6}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 888
    :cond_73
    const/4 v5, 0x3

    if-ne v1, v5, :cond_c2

    .line 889
    iget-object v5, p0, Landroid/renderscript/RenderScript$MessageThread;->mRS:Landroid/renderscript/RenderScript;

    iget-object v6, p0, Landroid/renderscript/RenderScript$MessageThread;->mRS:Landroid/renderscript/RenderScript;

    iget v6, v6, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {v5, v6}, Landroid/renderscript/RenderScript;->nContextGetErrorMessage(I)Ljava/lang/String;

    move-result-object v0

    .line 891
    .local v0, e:Ljava/lang/String;
    const/16 v5, 0x1000

    if-lt v4, v5, :cond_a7

    .line 892
    new-instance v5, Landroid/renderscript/RSRuntimeException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Fatal error "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ", details: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Landroid/renderscript/RSRuntimeException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 895
    :cond_a7
    iget-object v5, p0, Landroid/renderscript/RenderScript$MessageThread;->mRS:Landroid/renderscript/RenderScript;

    iget-object v5, v5, Landroid/renderscript/RenderScript;->mErrorCallback:Landroid/renderscript/RenderScript$RSErrorHandler;

    if-eqz v5, :cond_f

    .line 896
    iget-object v5, p0, Landroid/renderscript/RenderScript$MessageThread;->mRS:Landroid/renderscript/RenderScript;

    iget-object v5, v5, Landroid/renderscript/RenderScript;->mErrorCallback:Landroid/renderscript/RenderScript$RSErrorHandler;

    iput-object v0, v5, Landroid/renderscript/RenderScript$RSErrorHandler;->mErrorMessage:Ljava/lang/String;

    .line 897
    iget-object v5, p0, Landroid/renderscript/RenderScript$MessageThread;->mRS:Landroid/renderscript/RenderScript;

    iget-object v5, v5, Landroid/renderscript/RenderScript;->mErrorCallback:Landroid/renderscript/RenderScript$RSErrorHandler;

    iput v4, v5, Landroid/renderscript/RenderScript$RSErrorHandler;->mErrorNum:I

    .line 898
    iget-object v5, p0, Landroid/renderscript/RenderScript$MessageThread;->mRS:Landroid/renderscript/RenderScript;

    iget-object v5, v5, Landroid/renderscript/RenderScript;->mErrorCallback:Landroid/renderscript/RenderScript$RSErrorHandler;

    invoke-virtual {v5}, Landroid/renderscript/RenderScript$RSErrorHandler;->run()V

    goto/16 :goto_f

    .line 911
    .end local v0           #e:Ljava/lang/String;
    :cond_c2
    const-wide/16 v5, 0x1

    const/4 v7, 0x0

    :try_start_c5
    invoke-static {v5, v6, v7}, Landroid/renderscript/RenderScript$MessageThread;->sleep(JI)V
    :try_end_c8
    .catch Ljava/lang/InterruptedException; {:try_start_c5 .. :try_end_c8} :catch_ca

    goto/16 :goto_f

    .line 912
    :catch_ca
    move-exception v5

    goto/16 :goto_f

    .line 915
    .end local v1           #msg:I
    .end local v3           #size:I
    .end local v4           #subID:I
    :cond_cd
    const-string v5, "RenderScript_jni"

    const-string v6, "MessageThread exiting."

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 916
    return-void
.end method
