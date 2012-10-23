.class Lmiui/widget/SlidingButton$SlidingHandler;
.super Landroid/os/Handler;
.source "SlidingButton.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/widget/SlidingButton;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SlidingHandler"
.end annotation


# instance fields
.field final synthetic this$0:Lmiui/widget/SlidingButton;


# direct methods
.method private constructor <init>(Lmiui/widget/SlidingButton;)V
    .registers 2
    .parameter

    .prologue
    .line 339
    iput-object p1, p0, Lmiui/widget/SlidingButton$SlidingHandler;->this$0:Lmiui/widget/SlidingButton;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lmiui/widget/SlidingButton;Lmiui/widget/SlidingButton$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 339
    invoke-direct {p0, p1}, Lmiui/widget/SlidingButton$SlidingHandler;-><init>(Lmiui/widget/SlidingButton;)V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .registers 3
    .parameter "m"

    .prologue
    .line 341
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_c

    .line 346
    :goto_5
    return-void

    .line 343
    :pswitch_6
    iget-object v0, p0, Lmiui/widget/SlidingButton$SlidingHandler;->this$0:Lmiui/widget/SlidingButton;

    #calls: Lmiui/widget/SlidingButton;->doAnimation()V
    invoke-static {v0}, Lmiui/widget/SlidingButton;->access$100(Lmiui/widget/SlidingButton;)V

    goto :goto_5

    .line 341
    :pswitch_data_c
    .packed-switch 0x3e8
        :pswitch_6
    .end packed-switch
.end method
