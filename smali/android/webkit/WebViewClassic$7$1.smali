.class Landroid/webkit/WebViewClassic$7$1;
.super Ljava/lang/Object;
.source "WebViewClassic.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/webkit/WebViewClassic$7;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Landroid/webkit/WebViewClassic$7;

.field final synthetic val$p:Landroid/graphics/Picture;


# direct methods
.method constructor <init>(Landroid/webkit/WebViewClassic$7;Landroid/graphics/Picture;)V
    .registers 3
    .parameter
    .parameter

    .prologue
    .line 2323
    iput-object p1, p0, Landroid/webkit/WebViewClassic$7$1;->this$1:Landroid/webkit/WebViewClassic$7;

    iput-object p2, p0, Landroid/webkit/WebViewClassic$7$1;->val$p:Landroid/graphics/Picture;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 4

    .prologue
    .line 2326
    iget-object v0, p0, Landroid/webkit/WebViewClassic$7$1;->this$1:Landroid/webkit/WebViewClassic$7;

    iget-object v0, v0, Landroid/webkit/WebViewClassic$7;->this$0:Landroid/webkit/WebViewClassic;

    iget-object v1, p0, Landroid/webkit/WebViewClassic$7$1;->val$p:Landroid/graphics/Picture;

    iget-object v2, p0, Landroid/webkit/WebViewClassic$7$1;->this$1:Landroid/webkit/WebViewClassic$7;

    iget-object v2, v2, Landroid/webkit/WebViewClassic$7;->val$copy:Landroid/os/Bundle;

    #calls: Landroid/webkit/WebViewClassic;->restoreHistoryPictureFields(Landroid/graphics/Picture;Landroid/os/Bundle;)V
    invoke-static {v0, v1, v2}, Landroid/webkit/WebViewClassic;->access$1900(Landroid/webkit/WebViewClassic;Landroid/graphics/Picture;Landroid/os/Bundle;)V

    .line 2327
    return-void
.end method
