.class Landroid/view/LayoutInflater$BlinkLayout$1;
.super Ljava/lang/Object;
.source "LayoutInflater.java"

# interfaces
.implements Landroid/os/Handler$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/view/LayoutInflater$BlinkLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/view/LayoutInflater$BlinkLayout;


# direct methods
.method constructor <init>(Landroid/view/LayoutInflater$BlinkLayout;)V
    .registers 2
    .parameter

    .prologue
    .line 884
    iput-object p1, p0, Landroid/view/LayoutInflater$BlinkLayout$1;->this$0:Landroid/view/LayoutInflater$BlinkLayout;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)Z
    .registers 6
    .parameter "msg"

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 887
    iget v2, p1, Landroid/os/Message;->what:I

    const/16 v3, 0x42

    if-ne v2, v3, :cond_29

    .line 888
    iget-object v2, p0, Landroid/view/LayoutInflater$BlinkLayout$1;->this$0:Landroid/view/LayoutInflater$BlinkLayout;

    #getter for: Landroid/view/LayoutInflater$BlinkLayout;->mBlink:Z
    invoke-static {v2}, Landroid/view/LayoutInflater$BlinkLayout;->access$000(Landroid/view/LayoutInflater$BlinkLayout;)Z

    move-result v2

    if-eqz v2, :cond_23

    .line 889
    iget-object v2, p0, Landroid/view/LayoutInflater$BlinkLayout$1;->this$0:Landroid/view/LayoutInflater$BlinkLayout;

    iget-object v3, p0, Landroid/view/LayoutInflater$BlinkLayout$1;->this$0:Landroid/view/LayoutInflater$BlinkLayout;

    #getter for: Landroid/view/LayoutInflater$BlinkLayout;->mBlinkState:Z
    invoke-static {v3}, Landroid/view/LayoutInflater$BlinkLayout;->access$100(Landroid/view/LayoutInflater$BlinkLayout;)Z

    move-result v3

    if-nez v3, :cond_1b

    move v0, v1

    :cond_1b
    #setter for: Landroid/view/LayoutInflater$BlinkLayout;->mBlinkState:Z
    invoke-static {v2, v0}, Landroid/view/LayoutInflater$BlinkLayout;->access$102(Landroid/view/LayoutInflater$BlinkLayout;Z)Z

    .line 890
    iget-object v0, p0, Landroid/view/LayoutInflater$BlinkLayout$1;->this$0:Landroid/view/LayoutInflater$BlinkLayout;

    #calls: Landroid/view/LayoutInflater$BlinkLayout;->makeBlink()V
    invoke-static {v0}, Landroid/view/LayoutInflater$BlinkLayout;->access$200(Landroid/view/LayoutInflater$BlinkLayout;)V

    .line 892
    :cond_23
    iget-object v0, p0, Landroid/view/LayoutInflater$BlinkLayout$1;->this$0:Landroid/view/LayoutInflater$BlinkLayout;

    invoke-virtual {v0}, Landroid/view/LayoutInflater$BlinkLayout;->invalidate()V

    .line 895
    :goto_28
    return v1

    :cond_29
    move v1, v0

    goto :goto_28
.end method
