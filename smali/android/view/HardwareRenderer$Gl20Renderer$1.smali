.class Landroid/view/HardwareRenderer$Gl20Renderer$1;
.super Ljava/lang/Object;
.source "HardwareRenderer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/view/HardwareRenderer$Gl20Renderer;->destroyHardwareResources(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/view/HardwareRenderer$Gl20Renderer;

.field final synthetic val$view:Landroid/view/View;


# direct methods
.method constructor <init>(Landroid/view/HardwareRenderer$Gl20Renderer;Landroid/view/View;)V
    .registers 3
    .parameter
    .parameter

    .prologue
    iput-object p1, p0, Landroid/view/HardwareRenderer$Gl20Renderer$1;->this$0:Landroid/view/HardwareRenderer$Gl20Renderer;

    iput-object p2, p0, Landroid/view/HardwareRenderer$Gl20Renderer$1;->val$view:Landroid/view/View;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/view/HardwareRenderer$Gl20Renderer$1;->val$view:Landroid/view/View;

    #calls: Landroid/view/HardwareRenderer$Gl20Renderer;->destroyResources(Landroid/view/View;)V
    invoke-static {v0}, Landroid/view/HardwareRenderer$Gl20Renderer;->access$500(Landroid/view/View;)V

    const/4 v0, 0x0

    invoke-static {v0}, Landroid/view/GLES20Canvas;->flushCaches(I)V

    return-void
.end method
