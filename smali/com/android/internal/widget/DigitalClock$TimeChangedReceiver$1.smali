.class Lcom/android/internal/widget/DigitalClock$TimeChangedReceiver$1;
.super Ljava/lang/Object;
.source "DigitalClock.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/internal/widget/DigitalClock$TimeChangedReceiver;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/internal/widget/DigitalClock$TimeChangedReceiver;

.field final synthetic val$clock:Lcom/android/internal/widget/DigitalClock;

.field final synthetic val$timezoneChanged:Z


# direct methods
.method constructor <init>(Lcom/android/internal/widget/DigitalClock$TimeChangedReceiver;ZLcom/android/internal/widget/DigitalClock;)V
    .registers 4
    .parameter
    .parameter
    .parameter

    .prologue
    .line 86
    iput-object p1, p0, Lcom/android/internal/widget/DigitalClock$TimeChangedReceiver$1;->this$0:Lcom/android/internal/widget/DigitalClock$TimeChangedReceiver;

    iput-boolean p2, p0, Lcom/android/internal/widget/DigitalClock$TimeChangedReceiver$1;->val$timezoneChanged:Z

    iput-object p3, p0, Lcom/android/internal/widget/DigitalClock$TimeChangedReceiver$1;->val$clock:Lcom/android/internal/widget/DigitalClock;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 3

    .prologue
    .line 88
    iget-boolean v0, p0, Lcom/android/internal/widget/DigitalClock$TimeChangedReceiver$1;->val$timezoneChanged:Z

    if-eqz v0, :cond_d

    .line 89
    iget-object v0, p0, Lcom/android/internal/widget/DigitalClock$TimeChangedReceiver$1;->val$clock:Lcom/android/internal/widget/DigitalClock;

    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v1

    #setter for: Lcom/android/internal/widget/DigitalClock;->mCalendar:Ljava/util/Calendar;
    invoke-static {v0, v1}, Lcom/android/internal/widget/DigitalClock;->access$002(Lcom/android/internal/widget/DigitalClock;Ljava/util/Calendar;)Ljava/util/Calendar;

    .line 91
    :cond_d
    iget-object v0, p0, Lcom/android/internal/widget/DigitalClock$TimeChangedReceiver$1;->val$clock:Lcom/android/internal/widget/DigitalClock;

    invoke-virtual {v0}, Lcom/android/internal/widget/DigitalClock;->updateTime()V

    .line 92
    return-void
.end method
