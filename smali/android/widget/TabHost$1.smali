.class Landroid/widget/TabHost$1;
.super Ljava/lang/Object;
.source "TabHost.java"

# interfaces
.implements Landroid/view/View$OnKeyListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/widget/TabHost;->setup()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/widget/TabHost;


# direct methods
.method constructor <init>(Landroid/widget/TabHost;)V
    .registers 2
    .parameter

    .prologue
    .line 130
    iput-object p1, p0, Landroid/widget/TabHost$1;->this$0:Landroid/widget/TabHost;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onKey(Landroid/view/View;ILandroid/view/KeyEvent;)Z
    .registers 6
    .parameter "v"
    .parameter "keyCode"
    .parameter "event"

    .prologue
    .line 132
    sparse-switch p2, :sswitch_data_1a

    .line 142
    iget-object v0, p0, Landroid/widget/TabHost$1;->this$0:Landroid/widget/TabHost;

    #getter for: Landroid/widget/TabHost;->mTabContent:Landroid/widget/FrameLayout;
    invoke-static {v0}, Landroid/widget/TabHost;->access$100(Landroid/widget/TabHost;)Landroid/widget/FrameLayout;

    move-result-object v0

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->requestFocus(I)Z

    .line 143
    iget-object v0, p0, Landroid/widget/TabHost$1;->this$0:Landroid/widget/TabHost;

    #getter for: Landroid/widget/TabHost;->mTabContent:Landroid/widget/FrameLayout;
    invoke-static {v0}, Landroid/widget/TabHost;->access$100(Landroid/widget/TabHost;)Landroid/widget/FrameLayout;

    move-result-object v0

    invoke-virtual {v0, p3}, Landroid/widget/FrameLayout;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    :goto_17
    return v0

    .line 139
    :sswitch_18
    const/4 v0, 0x0

    goto :goto_17

    .line 132
    :sswitch_data_1a
    .sparse-switch
        0x13 -> :sswitch_18
        0x14 -> :sswitch_18
        0x15 -> :sswitch_18
        0x16 -> :sswitch_18
        0x17 -> :sswitch_18
        0x42 -> :sswitch_18
    .end sparse-switch
.end method
