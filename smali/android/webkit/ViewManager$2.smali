.class Landroid/webkit/ViewManager$2;
.super Ljava/lang/Object;
.source "ViewManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/webkit/ViewManager;->postResetStateAll()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/webkit/ViewManager;


# direct methods
.method constructor <init>(Landroid/webkit/ViewManager;)V
    .registers 2
    .parameter

    .prologue
    .line 264
    iput-object p1, p0, Landroid/webkit/ViewManager$2;->this$0:Landroid/webkit/ViewManager;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 3

    .prologue
    .line 266
    iget-object v0, p0, Landroid/webkit/ViewManager$2;->this$0:Landroid/webkit/ViewManager;

    const/4 v1, 0x0

    #setter for: Landroid/webkit/ViewManager;->mReadyToDraw:Z
    invoke-static {v0, v1}, Landroid/webkit/ViewManager;->access$402(Landroid/webkit/ViewManager;Z)Z

    .line 267
    return-void
.end method
