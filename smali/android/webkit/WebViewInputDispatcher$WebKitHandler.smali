.class final Landroid/webkit/WebViewInputDispatcher$WebKitHandler;
.super Landroid/os/Handler;
.source "WebViewInputDispatcher.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/WebViewInputDispatcher;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "WebKitHandler"
.end annotation


# static fields
.field public static final MSG_DISPATCH_WEBKIT_EVENTS:I = 0x1


# instance fields
.field final synthetic this$0:Landroid/webkit/WebViewInputDispatcher;


# direct methods
.method public constructor <init>(Landroid/webkit/WebViewInputDispatcher;Landroid/os/Looper;)V
    .registers 3
    .parameter
    .parameter "looper"

    .prologue
    .line 1145
    iput-object p1, p0, Landroid/webkit/WebViewInputDispatcher$WebKitHandler;->this$0:Landroid/webkit/WebViewInputDispatcher;

    .line 1146
    invoke-direct {p0, p2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 1147
    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .registers 5
    .parameter "msg"

    .prologue
    .line 1151
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_28

    .line 1156
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unknown message type: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p1, Landroid/os/Message;->what:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1153
    :pswitch_20
    iget-object v0, p0, Landroid/webkit/WebViewInputDispatcher$WebKitHandler;->this$0:Landroid/webkit/WebViewInputDispatcher;

    const/4 v1, 0x1

    #calls: Landroid/webkit/WebViewInputDispatcher;->dispatchWebKitEvents(Z)V
    invoke-static {v0, v1}, Landroid/webkit/WebViewInputDispatcher;->access$800(Landroid/webkit/WebViewInputDispatcher;Z)V

    .line 1158
    return-void

    .line 1151
    nop

    :pswitch_data_28
    .packed-switch 0x1
        :pswitch_20
    .end packed-switch
.end method
