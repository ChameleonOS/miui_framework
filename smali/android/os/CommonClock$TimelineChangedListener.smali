.class Landroid/os/CommonClock$TimelineChangedListener;
.super Landroid/os/Binder;
.source "CommonClock.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/os/CommonClock;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "TimelineChangedListener"
.end annotation


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "android.os.ICommonClockListener"


# instance fields
.field final synthetic this$0:Landroid/os/CommonClock;


# direct methods
.method private constructor <init>(Landroid/os/CommonClock;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Landroid/os/CommonClock$TimelineChangedListener;->this$0:Landroid/os/CommonClock;

    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/os/CommonClock;Landroid/os/CommonClock$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Landroid/os/CommonClock$TimelineChangedListener;-><init>(Landroid/os/CommonClock;)V

    return-void
.end method


# virtual methods
.method protected onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .registers 9
    .parameter "code"
    .parameter "data"
    .parameter "reply"
    .parameter "flags"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    packed-switch p1, :pswitch_data_30

    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v2

    :goto_7
    return v2

    :pswitch_8
    const-string v2, "android.os.ICommonClockListener"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    .local v0, timelineId:J
    iget-object v2, p0, Landroid/os/CommonClock$TimelineChangedListener;->this$0:Landroid/os/CommonClock;

    #getter for: Landroid/os/CommonClock;->mListenerLock:Ljava/lang/Object;
    invoke-static {v2}, Landroid/os/CommonClock;->access$000(Landroid/os/CommonClock;)Ljava/lang/Object;

    move-result-object v3

    monitor-enter v3

    :try_start_18
    iget-object v2, p0, Landroid/os/CommonClock$TimelineChangedListener;->this$0:Landroid/os/CommonClock;

    #getter for: Landroid/os/CommonClock;->mTimelineChangedListener:Landroid/os/CommonClock$OnTimelineChangedListener;
    invoke-static {v2}, Landroid/os/CommonClock;->access$200(Landroid/os/CommonClock;)Landroid/os/CommonClock$OnTimelineChangedListener;

    move-result-object v2

    if-eqz v2, :cond_29

    iget-object v2, p0, Landroid/os/CommonClock$TimelineChangedListener;->this$0:Landroid/os/CommonClock;

    #getter for: Landroid/os/CommonClock;->mTimelineChangedListener:Landroid/os/CommonClock$OnTimelineChangedListener;
    invoke-static {v2}, Landroid/os/CommonClock;->access$200(Landroid/os/CommonClock;)Landroid/os/CommonClock$OnTimelineChangedListener;

    move-result-object v2

    invoke-interface {v2, v0, v1}, Landroid/os/CommonClock$OnTimelineChangedListener;->onTimelineChanged(J)V

    :cond_29
    monitor-exit v3

    const/4 v2, 0x1

    goto :goto_7

    :catchall_2c
    move-exception v2

    monitor-exit v3
    :try_end_2e
    .catchall {:try_start_18 .. :try_end_2e} :catchall_2c

    throw v2

    nop

    :pswitch_data_30
    .packed-switch 0x1
        :pswitch_8
    .end packed-switch
.end method
