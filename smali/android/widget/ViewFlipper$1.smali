.class Landroid/widget/ViewFlipper$1;
.super Landroid/content/BroadcastReceiver;
.source "ViewFlipper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/ViewFlipper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/widget/ViewFlipper;


# direct methods
.method constructor <init>(Landroid/widget/ViewFlipper;)V
    .registers 2
    .parameter

    .prologue
    .line 71
    iput-object p1, p0, Landroid/widget/ViewFlipper$1;->this$0:Landroid/widget/ViewFlipper;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .registers 7
    .parameter "context"
    .parameter "intent"

    .prologue
    const/4 v3, 0x0

    .line 74
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 75
    .local v0, action:Ljava/lang/String;
    const-string v1, "android.intent.action.SCREEN_OFF"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_18

    .line 76
    iget-object v1, p0, Landroid/widget/ViewFlipper$1;->this$0:Landroid/widget/ViewFlipper;

    #setter for: Landroid/widget/ViewFlipper;->mUserPresent:Z
    invoke-static {v1, v3}, Landroid/widget/ViewFlipper;->access$002(Landroid/widget/ViewFlipper;Z)Z

    .line 77
    iget-object v1, p0, Landroid/widget/ViewFlipper$1;->this$0:Landroid/widget/ViewFlipper;

    #calls: Landroid/widget/ViewFlipper;->updateRunning()V
    invoke-static {v1}, Landroid/widget/ViewFlipper;->access$100(Landroid/widget/ViewFlipper;)V

    .line 82
    :cond_17
    :goto_17
    return-void

    .line 78
    :cond_18
    const-string v1, "android.intent.action.USER_PRESENT"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_17

    .line 79
    iget-object v1, p0, Landroid/widget/ViewFlipper$1;->this$0:Landroid/widget/ViewFlipper;

    const/4 v2, 0x1

    #setter for: Landroid/widget/ViewFlipper;->mUserPresent:Z
    invoke-static {v1, v2}, Landroid/widget/ViewFlipper;->access$002(Landroid/widget/ViewFlipper;Z)Z

    .line 80
    iget-object v1, p0, Landroid/widget/ViewFlipper$1;->this$0:Landroid/widget/ViewFlipper;

    #calls: Landroid/widget/ViewFlipper;->updateRunning(Z)V
    invoke-static {v1, v3}, Landroid/widget/ViewFlipper;->access$200(Landroid/widget/ViewFlipper;Z)V

    goto :goto_17
.end method
