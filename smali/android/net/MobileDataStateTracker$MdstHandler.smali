.class Landroid/net/MobileDataStateTracker$MdstHandler;
.super Landroid/os/Handler;
.source "MobileDataStateTracker.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/MobileDataStateTracker;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "MdstHandler"
.end annotation


# instance fields
.field private mMdst:Landroid/net/MobileDataStateTracker;


# direct methods
.method constructor <init>(Landroid/os/Looper;Landroid/net/MobileDataStateTracker;)V
    .registers 3
    .parameter "looper"
    .parameter "mdst"

    .prologue
    .line 121
    invoke-direct {p0, p1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 122
    iput-object p2, p0, Landroid/net/MobileDataStateTracker$MdstHandler;->mMdst:Landroid/net/MobileDataStateTracker;

    .line 123
    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .registers 4
    .parameter "msg"

    .prologue
    .line 127
    iget v0, p1, Landroid/os/Message;->what:I

    sparse-switch v0, :sswitch_data_1c

    .line 149
    :cond_5
    :goto_5
    return-void

    .line 129
    :sswitch_6
    iget v0, p1, Landroid/os/Message;->arg1:I

    if-nez v0, :cond_5

    .line 133
    iget-object v1, p0, Landroid/net/MobileDataStateTracker$MdstHandler;->mMdst:Landroid/net/MobileDataStateTracker;

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Lcom/android/internal/util/AsyncChannel;

    #setter for: Landroid/net/MobileDataStateTracker;->mDataConnectionTrackerAc:Lcom/android/internal/util/AsyncChannel;
    invoke-static {v1, v0}, Landroid/net/MobileDataStateTracker;->access$102(Landroid/net/MobileDataStateTracker;Lcom/android/internal/util/AsyncChannel;)Lcom/android/internal/util/AsyncChannel;

    goto :goto_5

    .line 142
    :sswitch_14
    iget-object v0, p0, Landroid/net/MobileDataStateTracker$MdstHandler;->mMdst:Landroid/net/MobileDataStateTracker;

    const/4 v1, 0x0

    #setter for: Landroid/net/MobileDataStateTracker;->mDataConnectionTrackerAc:Lcom/android/internal/util/AsyncChannel;
    invoke-static {v0, v1}, Landroid/net/MobileDataStateTracker;->access$102(Landroid/net/MobileDataStateTracker;Lcom/android/internal/util/AsyncChannel;)Lcom/android/internal/util/AsyncChannel;

    goto :goto_5

    .line 127
    nop

    :sswitch_data_1c
    .sparse-switch
        0x11000 -> :sswitch_6
        0x11004 -> :sswitch_14
    .end sparse-switch
.end method
