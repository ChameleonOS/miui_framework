.class Landroid/webkit/CallbackProxy$6;
.super Ljava/lang/Object;
.source "CallbackProxy.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/webkit/CallbackProxy;->handleMessage(Landroid/os/Message;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/webkit/CallbackProxy;

.field final synthetic val$res:Landroid/webkit/JsPromptResult;


# direct methods
.method constructor <init>(Landroid/webkit/CallbackProxy;Landroid/webkit/JsPromptResult;)V
    .registers 3
    .parameter
    .parameter

    .prologue
    .line 692
    iput-object p1, p0, Landroid/webkit/CallbackProxy$6;->this$0:Landroid/webkit/CallbackProxy;

    iput-object p2, p0, Landroid/webkit/CallbackProxy$6;->val$res:Landroid/webkit/JsPromptResult;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .registers 3
    .parameter "dialog"

    .prologue
    .line 695
    iget-object v0, p0, Landroid/webkit/CallbackProxy$6;->val$res:Landroid/webkit/JsPromptResult;

    invoke-virtual {v0}, Landroid/webkit/JsPromptResult;->cancel()V

    .line 696
    return-void
.end method
