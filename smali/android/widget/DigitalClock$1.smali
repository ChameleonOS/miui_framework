.class Landroid/widget/DigitalClock$1;
.super Ljava/lang/Object;
.source "DigitalClock.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/widget/DigitalClock;->onAttachedToWindow()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/widget/DigitalClock;


# direct methods
.method constructor <init>(Landroid/widget/DigitalClock;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Landroid/widget/DigitalClock$1;->this$0:Landroid/widget/DigitalClock;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 10

    .prologue
    const-wide/16 v7, 0x3e8

    iget-object v4, p0, Landroid/widget/DigitalClock$1;->this$0:Landroid/widget/DigitalClock;

    #getter for: Landroid/widget/DigitalClock;->mTickerStopped:Z
    invoke-static {v4}, Landroid/widget/DigitalClock;->access$000(Landroid/widget/DigitalClock;)Z

    move-result v4

    if-eqz v4, :cond_b

    :goto_a
    return-void

    :cond_b
    iget-object v4, p0, Landroid/widget/DigitalClock$1;->this$0:Landroid/widget/DigitalClock;

    iget-object v4, v4, Landroid/widget/DigitalClock;->mCalendar:Ljava/util/Calendar;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    invoke-virtual {v4, v5, v6}, Ljava/util/Calendar;->setTimeInMillis(J)V

    iget-object v4, p0, Landroid/widget/DigitalClock$1;->this$0:Landroid/widget/DigitalClock;

    iget-object v5, p0, Landroid/widget/DigitalClock$1;->this$0:Landroid/widget/DigitalClock;

    iget-object v5, v5, Landroid/widget/DigitalClock;->mFormat:Ljava/lang/String;

    iget-object v6, p0, Landroid/widget/DigitalClock$1;->this$0:Landroid/widget/DigitalClock;

    iget-object v6, v6, Landroid/widget/DigitalClock;->mCalendar:Ljava/util/Calendar;

    invoke-static {v5, v6}, Landroid/text/format/DateFormat;->format(Ljava/lang/CharSequence;Ljava/util/Calendar;)Ljava/lang/CharSequence;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/DigitalClock;->setText(Ljava/lang/CharSequence;)V

    iget-object v4, p0, Landroid/widget/DigitalClock$1;->this$0:Landroid/widget/DigitalClock;

    invoke-virtual {v4}, Landroid/widget/DigitalClock;->invalidate()V

    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v2

    .local v2, now:J
    rem-long v4, v2, v7

    sub-long v4, v7, v4

    add-long v0, v2, v4

    .local v0, next:J
    iget-object v4, p0, Landroid/widget/DigitalClock$1;->this$0:Landroid/widget/DigitalClock;

    #getter for: Landroid/widget/DigitalClock;->mHandler:Landroid/os/Handler;
    invoke-static {v4}, Landroid/widget/DigitalClock;->access$200(Landroid/widget/DigitalClock;)Landroid/os/Handler;

    move-result-object v4

    iget-object v5, p0, Landroid/widget/DigitalClock$1;->this$0:Landroid/widget/DigitalClock;

    #getter for: Landroid/widget/DigitalClock;->mTicker:Ljava/lang/Runnable;
    invoke-static {v5}, Landroid/widget/DigitalClock;->access$100(Landroid/widget/DigitalClock;)Ljava/lang/Runnable;

    move-result-object v5

    invoke-virtual {v4, v5, v0, v1}, Landroid/os/Handler;->postAtTime(Ljava/lang/Runnable;J)Z

    goto :goto_a
.end method
