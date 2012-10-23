.class Lmiui/view/VolumePanel$1;
.super Ljava/lang/Object;
.source "VolumePanel.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lmiui/view/VolumePanel;->recreateIfNeeded()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lmiui/view/VolumePanel;


# direct methods
.method constructor <init>(Lmiui/view/VolumePanel;)V
    .registers 2
    .parameter

    .prologue
    .line 248
    iput-object p1, p0, Lmiui/view/VolumePanel$1;->this$0:Lmiui/view/VolumePanel;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .registers 4
    .parameter "v"
    .parameter "event"

    .prologue
    .line 250
    iget-object v0, p0, Lmiui/view/VolumePanel$1;->this$0:Lmiui/view/VolumePanel;

    #calls: Lmiui/view/VolumePanel;->resetTimeout()V
    invoke-static {v0}, Lmiui/view/VolumePanel;->access$000(Lmiui/view/VolumePanel;)V

    .line 251
    const/4 v0, 0x0

    return v0
.end method
