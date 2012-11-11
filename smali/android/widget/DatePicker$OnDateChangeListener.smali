.class Landroid/widget/DatePicker$OnDateChangeListener;
.super Ljava/lang/Object;
.source "DatePicker.java"

# interfaces
.implements Landroid/widget/NumberPicker$OnValueChangeListener;


# annotations
.annotation build Landroid/annotation/MiuiHook;
    value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_CLASS:Landroid/annotation/MiuiHook$MiuiHookType;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/DatePicker;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "OnDateChangeListener"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/widget/DatePicker;


# direct methods
.method constructor <init>(Landroid/widget/DatePicker;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Landroid/widget/DatePicker$OnDateChangeListener;->this$0:Landroid/widget/DatePicker;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onValueChange(Landroid/widget/NumberPicker;II)V
    .registers 10
    .parameter "picker"
    .parameter "oldVal"
    .parameter "newVal"

    .prologue
    const/4 v5, 0x5

    const/4 v4, 0x2

    const/4 v3, 0x1

    iget-object v0, p0, Landroid/widget/DatePicker$OnDateChangeListener;->this$0:Landroid/widget/DatePicker;

    #calls: Landroid/widget/DatePicker;->updateInputState()V
    invoke-static {v0}, Landroid/widget/DatePicker;->access$000(Landroid/widget/DatePicker;)V

    iget-object v0, p0, Landroid/widget/DatePicker$OnDateChangeListener;->this$0:Landroid/widget/DatePicker;

    #getter for: Landroid/widget/DatePicker;->mTempDate:Ljava/util/Calendar;
    invoke-static {v0}, Landroid/widget/DatePicker;->access$200(Landroid/widget/DatePicker;)Ljava/util/Calendar;

    move-result-object v0

    iget-object v1, p0, Landroid/widget/DatePicker$OnDateChangeListener;->this$0:Landroid/widget/DatePicker;

    #getter for: Landroid/widget/DatePicker;->mCurrentDate:Ljava/util/Calendar;
    invoke-static {v1}, Landroid/widget/DatePicker;->access$100(Landroid/widget/DatePicker;)Ljava/util/Calendar;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Ljava/util/Calendar;->setTimeInMillis(J)V

    iget-object v0, p0, Landroid/widget/DatePicker$OnDateChangeListener;->this$0:Landroid/widget/DatePicker;

    #getter for: Landroid/widget/DatePicker;->mDaySpinner:Landroid/widget/NumberPicker;
    invoke-static {v0}, Landroid/widget/DatePicker;->access$300(Landroid/widget/DatePicker;)Landroid/widget/NumberPicker;

    move-result-object v0

    if-ne p1, v0, :cond_61

    iget-object v0, p0, Landroid/widget/DatePicker$OnDateChangeListener;->this$0:Landroid/widget/DatePicker;

    #getter for: Landroid/widget/DatePicker;->mTempDate:Ljava/util/Calendar;
    invoke-static {v0}, Landroid/widget/DatePicker;->access$200(Landroid/widget/DatePicker;)Ljava/util/Calendar;

    move-result-object v0

    sub-int v1, p3, p2

    invoke-virtual {v0, v5, v1}, Ljava/util/Calendar;->add(II)V

    :goto_2e
    iget-object v0, p0, Landroid/widget/DatePicker$OnDateChangeListener;->this$0:Landroid/widget/DatePicker;

    iget-object v1, p0, Landroid/widget/DatePicker$OnDateChangeListener;->this$0:Landroid/widget/DatePicker;

    #getter for: Landroid/widget/DatePicker;->mTempDate:Ljava/util/Calendar;
    invoke-static {v1}, Landroid/widget/DatePicker;->access$200(Landroid/widget/DatePicker;)Ljava/util/Calendar;

    move-result-object v1

    invoke-virtual {v1, v3}, Ljava/util/Calendar;->get(I)I

    move-result v1

    iget-object v2, p0, Landroid/widget/DatePicker$OnDateChangeListener;->this$0:Landroid/widget/DatePicker;

    #getter for: Landroid/widget/DatePicker;->mTempDate:Ljava/util/Calendar;
    invoke-static {v2}, Landroid/widget/DatePicker;->access$200(Landroid/widget/DatePicker;)Ljava/util/Calendar;

    move-result-object v2

    invoke-virtual {v2, v4}, Ljava/util/Calendar;->get(I)I

    move-result v2

    iget-object v3, p0, Landroid/widget/DatePicker$OnDateChangeListener;->this$0:Landroid/widget/DatePicker;

    #getter for: Landroid/widget/DatePicker;->mTempDate:Ljava/util/Calendar;
    invoke-static {v3}, Landroid/widget/DatePicker;->access$200(Landroid/widget/DatePicker;)Ljava/util/Calendar;

    move-result-object v3

    invoke-virtual {v3, v5}, Ljava/util/Calendar;->get(I)I

    move-result v3

    #calls: Landroid/widget/DatePicker;->setDate(III)V
    invoke-static {v0, v1, v2, v3}, Landroid/widget/DatePicker;->access$600(Landroid/widget/DatePicker;III)V

    iget-object v0, p0, Landroid/widget/DatePicker$OnDateChangeListener;->this$0:Landroid/widget/DatePicker;

    #calls: Landroid/widget/DatePicker;->updateSpinners()V
    invoke-static {v0}, Landroid/widget/DatePicker;->access$700(Landroid/widget/DatePicker;)V

    iget-object v0, p0, Landroid/widget/DatePicker$OnDateChangeListener;->this$0:Landroid/widget/DatePicker;

    #calls: Landroid/widget/DatePicker;->updateCalendarView()V
    invoke-static {v0}, Landroid/widget/DatePicker;->access$800(Landroid/widget/DatePicker;)V

    iget-object v0, p0, Landroid/widget/DatePicker$OnDateChangeListener;->this$0:Landroid/widget/DatePicker;

    #calls: Landroid/widget/DatePicker;->notifyDateChanged()V
    invoke-static {v0}, Landroid/widget/DatePicker;->access$900(Landroid/widget/DatePicker;)V

    return-void

    :cond_61
    iget-object v0, p0, Landroid/widget/DatePicker$OnDateChangeListener;->this$0:Landroid/widget/DatePicker;

    #getter for: Landroid/widget/DatePicker;->mMonthSpinner:Landroid/widget/NumberPicker;
    invoke-static {v0}, Landroid/widget/DatePicker;->access$400(Landroid/widget/DatePicker;)Landroid/widget/NumberPicker;

    move-result-object v0

    if-ne p1, v0, :cond_75

    iget-object v0, p0, Landroid/widget/DatePicker$OnDateChangeListener;->this$0:Landroid/widget/DatePicker;

    #getter for: Landroid/widget/DatePicker;->mTempDate:Ljava/util/Calendar;
    invoke-static {v0}, Landroid/widget/DatePicker;->access$200(Landroid/widget/DatePicker;)Ljava/util/Calendar;

    move-result-object v0

    sub-int v1, p3, p2

    invoke-virtual {v0, v4, v1}, Ljava/util/Calendar;->add(II)V

    goto :goto_2e

    :cond_75
    iget-object v0, p0, Landroid/widget/DatePicker$OnDateChangeListener;->this$0:Landroid/widget/DatePicker;

    #getter for: Landroid/widget/DatePicker;->mYearSpinner:Landroid/widget/NumberPicker;
    invoke-static {v0}, Landroid/widget/DatePicker;->access$500(Landroid/widget/DatePicker;)Landroid/widget/NumberPicker;

    move-result-object v0

    if-ne p1, v0, :cond_87

    iget-object v0, p0, Landroid/widget/DatePicker$OnDateChangeListener;->this$0:Landroid/widget/DatePicker;

    #getter for: Landroid/widget/DatePicker;->mTempDate:Ljava/util/Calendar;
    invoke-static {v0}, Landroid/widget/DatePicker;->access$200(Landroid/widget/DatePicker;)Ljava/util/Calendar;

    move-result-object v0

    invoke-virtual {v0, v3, p3}, Ljava/util/Calendar;->set(II)V

    goto :goto_2e

    :cond_87
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0
.end method
