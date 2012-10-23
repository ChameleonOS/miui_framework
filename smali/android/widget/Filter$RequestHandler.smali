.class Landroid/widget/Filter$RequestHandler;
.super Landroid/os/Handler;
.source "Filter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/Filter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "RequestHandler"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/widget/Filter;


# direct methods
.method public constructor <init>(Landroid/widget/Filter;Landroid/os/Looper;)V
    .registers 3
    .parameter
    .parameter "looper"

    .prologue
    .line 216
    iput-object p1, p0, Landroid/widget/Filter$RequestHandler;->this$0:Landroid/widget/Filter;

    .line 217
    invoke-direct {p0, p2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 218
    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .registers 11
    .parameter "msg"

    .prologue
    .line 228
    iget v4, p1, Landroid/os/Message;->what:I

    .line 230
    .local v4, what:I
    sparse-switch v4, :sswitch_data_a4

    .line 260
    :goto_5
    return-void

    .line 232
    :sswitch_6
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Landroid/widget/Filter$RequestArguments;

    .line 234
    .local v0, args:Landroid/widget/Filter$RequestArguments;
    :try_start_a
    iget-object v5, p0, Landroid/widget/Filter$RequestHandler;->this$0:Landroid/widget/Filter;

    iget-object v6, v0, Landroid/widget/Filter$RequestArguments;->constraint:Ljava/lang/CharSequence;

    invoke-virtual {v5, v6}, Landroid/widget/Filter;->performFiltering(Ljava/lang/CharSequence;)Landroid/widget/Filter$FilterResults;

    move-result-object v5

    iput-object v5, v0, Landroid/widget/Filter$RequestArguments;->results:Landroid/widget/Filter$FilterResults;
    :try_end_14
    .catchall {:try_start_a .. :try_end_14} :catchall_6b
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_14} :catch_4f

    .line 239
    iget-object v5, p0, Landroid/widget/Filter$RequestHandler;->this$0:Landroid/widget/Filter;

    #getter for: Landroid/widget/Filter;->mResultHandler:Landroid/os/Handler;
    invoke-static {v5}, Landroid/widget/Filter;->access$200(Landroid/widget/Filter;)Landroid/os/Handler;

    move-result-object v5

    invoke-virtual {v5, v4}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v3

    .line 240
    .local v3, message:Landroid/os/Message;
    iput-object v0, v3, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 241
    :goto_20
    invoke-virtual {v3}, Landroid/os/Message;->sendToTarget()V

    .line 244
    iget-object v5, p0, Landroid/widget/Filter$RequestHandler;->this$0:Landroid/widget/Filter;

    #getter for: Landroid/widget/Filter;->mLock:Ljava/lang/Object;
    invoke-static {v5}, Landroid/widget/Filter;->access$300(Landroid/widget/Filter;)Ljava/lang/Object;

    move-result-object v6

    monitor-enter v6

    .line 245
    :try_start_2a
    iget-object v5, p0, Landroid/widget/Filter$RequestHandler;->this$0:Landroid/widget/Filter;

    #getter for: Landroid/widget/Filter;->mThreadHandler:Landroid/os/Handler;
    invoke-static {v5}, Landroid/widget/Filter;->access$400(Landroid/widget/Filter;)Landroid/os/Handler;

    move-result-object v5

    if-eqz v5, :cond_4a

    .line 246
    iget-object v5, p0, Landroid/widget/Filter$RequestHandler;->this$0:Landroid/widget/Filter;

    #getter for: Landroid/widget/Filter;->mThreadHandler:Landroid/os/Handler;
    invoke-static {v5}, Landroid/widget/Filter;->access$400(Landroid/widget/Filter;)Landroid/os/Handler;

    move-result-object v5

    const v7, -0x21524111

    invoke-virtual {v5, v7}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v2

    .line 247
    .local v2, finishMessage:Landroid/os/Message;
    iget-object v5, p0, Landroid/widget/Filter$RequestHandler;->this$0:Landroid/widget/Filter;

    #getter for: Landroid/widget/Filter;->mThreadHandler:Landroid/os/Handler;
    invoke-static {v5}, Landroid/widget/Filter;->access$400(Landroid/widget/Filter;)Landroid/os/Handler;

    move-result-object v5

    const-wide/16 v7, 0xbb8

    invoke-virtual {v5, v2, v7, v8}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    .line 249
    .end local v2           #finishMessage:Landroid/os/Message;
    :cond_4a
    monitor-exit v6

    goto :goto_5

    :catchall_4c
    move-exception v5

    monitor-exit v6
    :try_end_4e
    .catchall {:try_start_2a .. :try_end_4e} :catchall_4c

    throw v5

    .line 235
    .end local v3           #message:Landroid/os/Message;
    :catch_4f
    move-exception v1

    .line 236
    .local v1, e:Ljava/lang/Exception;
    :try_start_50
    new-instance v5, Landroid/widget/Filter$FilterResults;

    invoke-direct {v5}, Landroid/widget/Filter$FilterResults;-><init>()V

    iput-object v5, v0, Landroid/widget/Filter$RequestArguments;->results:Landroid/widget/Filter$FilterResults;

    .line 237
    const-string v5, "Filter"

    const-string v6, "An exception occured during performFiltering()!"

    invoke-static {v5, v6, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_5e
    .catchall {:try_start_50 .. :try_end_5e} :catchall_6b

    .line 239
    iget-object v5, p0, Landroid/widget/Filter$RequestHandler;->this$0:Landroid/widget/Filter;

    #getter for: Landroid/widget/Filter;->mResultHandler:Landroid/os/Handler;
    invoke-static {v5}, Landroid/widget/Filter;->access$200(Landroid/widget/Filter;)Landroid/os/Handler;

    move-result-object v5

    invoke-virtual {v5, v4}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v3

    .line 240
    .restart local v3       #message:Landroid/os/Message;
    iput-object v0, v3, Landroid/os/Message;->obj:Ljava/lang/Object;

    goto :goto_20

    .line 239
    .end local v1           #e:Ljava/lang/Exception;
    .end local v3           #message:Landroid/os/Message;
    :catchall_6b
    move-exception v5

    iget-object v6, p0, Landroid/widget/Filter$RequestHandler;->this$0:Landroid/widget/Filter;

    #getter for: Landroid/widget/Filter;->mResultHandler:Landroid/os/Handler;
    invoke-static {v6}, Landroid/widget/Filter;->access$200(Landroid/widget/Filter;)Landroid/os/Handler;

    move-result-object v6

    invoke-virtual {v6, v4}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v3

    .line 240
    .restart local v3       #message:Landroid/os/Message;
    iput-object v0, v3, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 241
    invoke-virtual {v3}, Landroid/os/Message;->sendToTarget()V

    .line 239
    throw v5

    .line 252
    .end local v0           #args:Landroid/widget/Filter$RequestArguments;
    .end local v3           #message:Landroid/os/Message;
    :sswitch_7c
    iget-object v5, p0, Landroid/widget/Filter$RequestHandler;->this$0:Landroid/widget/Filter;

    #getter for: Landroid/widget/Filter;->mLock:Ljava/lang/Object;
    invoke-static {v5}, Landroid/widget/Filter;->access$300(Landroid/widget/Filter;)Ljava/lang/Object;

    move-result-object v6

    monitor-enter v6

    .line 253
    :try_start_83
    iget-object v5, p0, Landroid/widget/Filter$RequestHandler;->this$0:Landroid/widget/Filter;

    #getter for: Landroid/widget/Filter;->mThreadHandler:Landroid/os/Handler;
    invoke-static {v5}, Landroid/widget/Filter;->access$400(Landroid/widget/Filter;)Landroid/os/Handler;

    move-result-object v5

    if-eqz v5, :cond_9e

    .line 254
    iget-object v5, p0, Landroid/widget/Filter$RequestHandler;->this$0:Landroid/widget/Filter;

    #getter for: Landroid/widget/Filter;->mThreadHandler:Landroid/os/Handler;
    invoke-static {v5}, Landroid/widget/Filter;->access$400(Landroid/widget/Filter;)Landroid/os/Handler;

    move-result-object v5

    invoke-virtual {v5}, Landroid/os/Handler;->getLooper()Landroid/os/Looper;

    move-result-object v5

    invoke-virtual {v5}, Landroid/os/Looper;->quit()V

    .line 255
    iget-object v5, p0, Landroid/widget/Filter$RequestHandler;->this$0:Landroid/widget/Filter;

    const/4 v7, 0x0

    #setter for: Landroid/widget/Filter;->mThreadHandler:Landroid/os/Handler;
    invoke-static {v5, v7}, Landroid/widget/Filter;->access$402(Landroid/widget/Filter;Landroid/os/Handler;)Landroid/os/Handler;

    .line 257
    :cond_9e
    monitor-exit v6

    goto/16 :goto_5

    :catchall_a1
    move-exception v5

    monitor-exit v6
    :try_end_a3
    .catchall {:try_start_83 .. :try_end_a3} :catchall_a1

    throw v5

    .line 230
    :sswitch_data_a4
    .sparse-switch
        -0x2f2f0ff3 -> :sswitch_6
        -0x21524111 -> :sswitch_7c
    .end sparse-switch
.end method
