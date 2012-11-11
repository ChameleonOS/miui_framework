.class Landroid/webkit/CallbackProxy$UploadFile;
.super Ljava/lang/Object;
.source "CallbackProxy.java"

# interfaces
.implements Landroid/webkit/ValueCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/CallbackProxy;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "UploadFile"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/webkit/ValueCallback",
        "<",
        "Landroid/net/Uri;",
        ">;"
    }
.end annotation


# instance fields
.field private mValue:Landroid/net/Uri;

.field final synthetic this$0:Landroid/webkit/CallbackProxy;


# direct methods
.method private constructor <init>(Landroid/webkit/CallbackProxy;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Landroid/webkit/CallbackProxy$UploadFile;->this$0:Landroid/webkit/CallbackProxy;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/webkit/CallbackProxy;Landroid/webkit/CallbackProxy$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Landroid/webkit/CallbackProxy$UploadFile;-><init>(Landroid/webkit/CallbackProxy;)V

    return-void
.end method


# virtual methods
.method public getResult()Landroid/net/Uri;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/webkit/CallbackProxy$UploadFile;->mValue:Landroid/net/Uri;

    return-object v0
.end method

.method public onReceiveValue(Landroid/net/Uri;)V
    .registers 4
    .parameter "value"

    .prologue
    iput-object p1, p0, Landroid/webkit/CallbackProxy$UploadFile;->mValue:Landroid/net/Uri;

    iget-object v1, p0, Landroid/webkit/CallbackProxy$UploadFile;->this$0:Landroid/webkit/CallbackProxy;

    monitor-enter v1

    :try_start_5
    iget-object v0, p0, Landroid/webkit/CallbackProxy$UploadFile;->this$0:Landroid/webkit/CallbackProxy;

    invoke-virtual {v0}, Ljava/lang/Object;->notify()V

    monitor-exit v1

    return-void

    :catchall_c
    move-exception v0

    monitor-exit v1
    :try_end_e
    .catchall {:try_start_5 .. :try_end_e} :catchall_c

    throw v0
.end method

.method public bridge synthetic onReceiveValue(Ljava/lang/Object;)V
    .registers 2
    .parameter "x0"

    .prologue
    check-cast p1, Landroid/net/Uri;

    .end local p1
    invoke-virtual {p0, p1}, Landroid/webkit/CallbackProxy$UploadFile;->onReceiveValue(Landroid/net/Uri;)V

    return-void
.end method
