.class Landroid/widget/AnalogClock$1;
.super Landroid/content/BroadcastReceiver;
.source "AnalogClock.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/AnalogClock;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/widget/AnalogClock;


# direct methods
.method constructor <init>(Landroid/widget/AnalogClock;)V
    .registers 2
    .parameter

    .prologue
    .line 236
    iput-object p1, p0, Landroid/widget/AnalogClock$1;->this$0:Landroid/widget/AnalogClock;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .registers 7
    .parameter "context"
    .parameter "intent"

    .prologue
    .line 239
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    const-string v2, "android.intent.action.TIMEZONE_CHANGED"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_25

    .line 240
    const-string/jumbo v1, "time-zone"

    invoke-virtual {p2, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 241
    .local v0, tz:Ljava/lang/String;
    iget-object v1, p0, Landroid/widget/AnalogClock$1;->this$0:Landroid/widget/AnalogClock;

    new-instance v2, Landroid/text/format/Time;

    invoke-static {v0}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/TimeZone;->getID()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/text/format/Time;-><init>(Ljava/lang/String;)V

    #setter for: Landroid/widget/AnalogClock;->mCalendar:Landroid/text/format/Time;
    invoke-static {v1, v2}, Landroid/widget/AnalogClock;->access$002(Landroid/widget/AnalogClock;Landroid/text/format/Time;)Landroid/text/format/Time;

    .line 244
    .end local v0           #tz:Ljava/lang/String;
    :cond_25
    iget-object v1, p0, Landroid/widget/AnalogClock$1;->this$0:Landroid/widget/AnalogClock;

    #calls: Landroid/widget/AnalogClock;->onTimeChanged()V
    invoke-static {v1}, Landroid/widget/AnalogClock;->access$100(Landroid/widget/AnalogClock;)V

    .line 246
    iget-object v1, p0, Landroid/widget/AnalogClock$1;->this$0:Landroid/widget/AnalogClock;

    invoke-virtual {v1}, Landroid/widget/AnalogClock;->invalidate()V

    .line 247
    return-void
.end method
