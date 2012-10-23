.class Landroid/widget/CalendarView$WeeksAdapter;
.super Landroid/widget/BaseAdapter;
.source "CalendarView.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/CalendarView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "WeeksAdapter"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/widget/CalendarView$WeeksAdapter$CalendarGestureListener;
    }
.end annotation


# instance fields
.field private mFocusedMonth:I

.field private mGestureDetector:Landroid/view/GestureDetector;

.field private final mSelectedDate:Ljava/util/Calendar;

.field private mSelectedWeek:I

.field private mTotalWeekCount:I

.field final synthetic this$0:Landroid/widget/CalendarView;


# direct methods
.method public constructor <init>(Landroid/widget/CalendarView;Landroid/content/Context;)V
    .registers 6
    .parameter
    .parameter "context"

    .prologue
    .line 1347
    iput-object p1, p0, Landroid/widget/CalendarView$WeeksAdapter;->this$0:Landroid/widget/CalendarView;

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 1343
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    iput-object v0, p0, Landroid/widget/CalendarView$WeeksAdapter;->mSelectedDate:Ljava/util/Calendar;

    .line 1348
    #setter for: Landroid/view/View;->mContext:Landroid/content/Context;
    invoke-static {p1, p2}, Landroid/widget/CalendarView;->access$1402(Landroid/widget/CalendarView;Landroid/content/Context;)Landroid/content/Context;

    .line 1349
    new-instance v0, Landroid/view/GestureDetector;

    #getter for: Landroid/view/View;->mContext:Landroid/content/Context;
    invoke-static {p1}, Landroid/widget/CalendarView;->access$1500(Landroid/widget/CalendarView;)Landroid/content/Context;

    move-result-object v1

    new-instance v2, Landroid/widget/CalendarView$WeeksAdapter$CalendarGestureListener;

    invoke-direct {v2, p0}, Landroid/widget/CalendarView$WeeksAdapter$CalendarGestureListener;-><init>(Landroid/widget/CalendarView$WeeksAdapter;)V

    invoke-direct {v0, v1, v2}, Landroid/view/GestureDetector;-><init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;)V

    iput-object v0, p0, Landroid/widget/CalendarView$WeeksAdapter;->mGestureDetector:Landroid/view/GestureDetector;

    .line 1350
    invoke-direct {p0}, Landroid/widget/CalendarView$WeeksAdapter;->init()V

    .line 1351
    return-void
.end method

.method static synthetic access$400(Landroid/widget/CalendarView$WeeksAdapter;)Ljava/util/Calendar;
    .registers 2
    .parameter "x0"

    .prologue
    .line 1335
    iget-object v0, p0, Landroid/widget/CalendarView$WeeksAdapter;->mSelectedDate:Ljava/util/Calendar;

    return-object v0
.end method

.method static synthetic access$500(Landroid/widget/CalendarView$WeeksAdapter;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 1335
    invoke-direct {p0}, Landroid/widget/CalendarView$WeeksAdapter;->init()V

    return-void
.end method

.method private init()V
    .registers 4

    .prologue
    const/4 v2, 0x7

    .line 1357
    iget-object v0, p0, Landroid/widget/CalendarView$WeeksAdapter;->this$0:Landroid/widget/CalendarView;

    iget-object v1, p0, Landroid/widget/CalendarView$WeeksAdapter;->mSelectedDate:Ljava/util/Calendar;

    #calls: Landroid/widget/CalendarView;->getWeeksSinceMinDate(Ljava/util/Calendar;)I
    invoke-static {v0, v1}, Landroid/widget/CalendarView;->access$1600(Landroid/widget/CalendarView;Ljava/util/Calendar;)I

    move-result v0

    iput v0, p0, Landroid/widget/CalendarView$WeeksAdapter;->mSelectedWeek:I

    .line 1358
    iget-object v0, p0, Landroid/widget/CalendarView$WeeksAdapter;->this$0:Landroid/widget/CalendarView;

    iget-object v1, p0, Landroid/widget/CalendarView$WeeksAdapter;->this$0:Landroid/widget/CalendarView;

    #getter for: Landroid/widget/CalendarView;->mMaxDate:Ljava/util/Calendar;
    invoke-static {v1}, Landroid/widget/CalendarView;->access$1700(Landroid/widget/CalendarView;)Ljava/util/Calendar;

    move-result-object v1

    #calls: Landroid/widget/CalendarView;->getWeeksSinceMinDate(Ljava/util/Calendar;)I
    invoke-static {v0, v1}, Landroid/widget/CalendarView;->access$1600(Landroid/widget/CalendarView;Ljava/util/Calendar;)I

    move-result v0

    iput v0, p0, Landroid/widget/CalendarView$WeeksAdapter;->mTotalWeekCount:I

    .line 1359
    iget-object v0, p0, Landroid/widget/CalendarView$WeeksAdapter;->this$0:Landroid/widget/CalendarView;

    #getter for: Landroid/widget/CalendarView;->mMinDate:Ljava/util/Calendar;
    invoke-static {v0}, Landroid/widget/CalendarView;->access$1800(Landroid/widget/CalendarView;)Ljava/util/Calendar;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/util/Calendar;->get(I)I

    move-result v0

    iget-object v1, p0, Landroid/widget/CalendarView$WeeksAdapter;->this$0:Landroid/widget/CalendarView;

    #getter for: Landroid/widget/CalendarView;->mFirstDayOfWeek:I
    invoke-static {v1}, Landroid/widget/CalendarView;->access$1900(Landroid/widget/CalendarView;)I

    move-result v1

    if-ne v0, v1, :cond_3d

    iget-object v0, p0, Landroid/widget/CalendarView$WeeksAdapter;->this$0:Landroid/widget/CalendarView;

    #getter for: Landroid/widget/CalendarView;->mMaxDate:Ljava/util/Calendar;
    invoke-static {v0}, Landroid/widget/CalendarView;->access$1700(Landroid/widget/CalendarView;)Ljava/util/Calendar;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/util/Calendar;->get(I)I

    move-result v0

    iget-object v1, p0, Landroid/widget/CalendarView$WeeksAdapter;->this$0:Landroid/widget/CalendarView;

    #getter for: Landroid/widget/CalendarView;->mFirstDayOfWeek:I
    invoke-static {v1}, Landroid/widget/CalendarView;->access$1900(Landroid/widget/CalendarView;)I

    move-result v1

    if-eq v0, v1, :cond_43

    .line 1361
    :cond_3d
    iget v0, p0, Landroid/widget/CalendarView$WeeksAdapter;->mTotalWeekCount:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Landroid/widget/CalendarView$WeeksAdapter;->mTotalWeekCount:I

    .line 1363
    :cond_43
    return-void
.end method

.method private onDateTapped(Ljava/util/Calendar;)V
    .registers 3
    .parameter "day"

    .prologue
    .line 1463
    invoke-virtual {p0, p1}, Landroid/widget/CalendarView$WeeksAdapter;->setSelectedDay(Ljava/util/Calendar;)V

    .line 1464
    iget-object v0, p0, Landroid/widget/CalendarView$WeeksAdapter;->this$0:Landroid/widget/CalendarView;

    #calls: Landroid/widget/CalendarView;->setMonthDisplayed(Ljava/util/Calendar;)V
    invoke-static {v0, p1}, Landroid/widget/CalendarView;->access$2300(Landroid/widget/CalendarView;Ljava/util/Calendar;)V

    .line 1465
    return-void
.end method


# virtual methods
.method public getCount()I
    .registers 2

    .prologue
    .line 1390
    iget v0, p0, Landroid/widget/CalendarView$WeeksAdapter;->mTotalWeekCount:I

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .registers 3
    .parameter "position"

    .prologue
    .line 1395
    const/4 v0, 0x0

    return-object v0
.end method

.method public getItemId(I)J
    .registers 4
    .parameter "position"

    .prologue
    .line 1400
    int-to-long v0, p1

    return-wide v0
.end method

.method public getSelectedDay()Ljava/util/Calendar;
    .registers 2

    .prologue
    .line 1385
    iget-object v0, p0, Landroid/widget/CalendarView$WeeksAdapter;->mSelectedDate:Ljava/util/Calendar;

    return-object v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .registers 10
    .parameter "position"
    .parameter "convertView"
    .parameter "parent"

    .prologue
    const/4 v5, -0x2

    .line 1405
    const/4 v2, 0x0

    .line 1406
    .local v2, weekView:Landroid/widget/CalendarView$WeekView;
    if-eqz p2, :cond_18

    move-object v2, p2

    .line 1407
    check-cast v2, Landroid/widget/CalendarView$WeekView;

    .line 1418
    :goto_7
    iget v3, p0, Landroid/widget/CalendarView$WeeksAdapter;->mSelectedWeek:I

    if-ne v3, p1, :cond_35

    iget-object v3, p0, Landroid/widget/CalendarView$WeeksAdapter;->mSelectedDate:Ljava/util/Calendar;

    const/4 v4, 0x7

    invoke-virtual {v3, v4}, Ljava/util/Calendar;->get(I)I

    move-result v1

    .line 1420
    .local v1, selectedWeekDay:I
    :goto_12
    iget v3, p0, Landroid/widget/CalendarView$WeeksAdapter;->mFocusedMonth:I

    invoke-virtual {v2, p1, v1, v3}, Landroid/widget/CalendarView$WeekView;->init(III)V

    .line 1422
    return-object v2

    .line 1409
    .end local v1           #selectedWeekDay:I
    :cond_18
    new-instance v2, Landroid/widget/CalendarView$WeekView;

    .end local v2           #weekView:Landroid/widget/CalendarView$WeekView;
    iget-object v3, p0, Landroid/widget/CalendarView$WeeksAdapter;->this$0:Landroid/widget/CalendarView;

    iget-object v4, p0, Landroid/widget/CalendarView$WeeksAdapter;->this$0:Landroid/widget/CalendarView;

    #getter for: Landroid/view/View;->mContext:Landroid/content/Context;
    invoke-static {v4}, Landroid/widget/CalendarView;->access$2000(Landroid/widget/CalendarView;)Landroid/content/Context;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Landroid/widget/CalendarView$WeekView;-><init>(Landroid/widget/CalendarView;Landroid/content/Context;)V

    .line 1410
    .restart local v2       #weekView:Landroid/widget/CalendarView$WeekView;
    new-instance v0, Landroid/widget/AbsListView$LayoutParams;

    invoke-direct {v0, v5, v5}, Landroid/widget/AbsListView$LayoutParams;-><init>(II)V

    .line 1413
    .local v0, params:Landroid/widget/AbsListView$LayoutParams;
    invoke-virtual {v2, v0}, Landroid/widget/CalendarView$WeekView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 1414
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/widget/CalendarView$WeekView;->setClickable(Z)V

    .line 1415
    invoke-virtual {v2, p0}, Landroid/widget/CalendarView$WeekView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    goto :goto_7

    .line 1418
    .end local v0           #params:Landroid/widget/AbsListView$LayoutParams;
    :cond_35
    const/4 v1, -0x1

    goto :goto_12
.end method

.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .registers 7
    .parameter "v"
    .parameter "event"

    .prologue
    const/4 v1, 0x1

    .line 1440
    iget-object v2, p0, Landroid/widget/CalendarView$WeeksAdapter;->this$0:Landroid/widget/CalendarView;

    #getter for: Landroid/widget/CalendarView;->mListView:Landroid/widget/ListView;
    invoke-static {v2}, Landroid/widget/CalendarView;->access$2100(Landroid/widget/CalendarView;)Landroid/widget/ListView;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/ListView;->isEnabled()Z

    move-result v2

    if-eqz v2, :cond_57

    iget-object v2, p0, Landroid/widget/CalendarView$WeeksAdapter;->mGestureDetector:Landroid/view/GestureDetector;

    invoke-virtual {v2, p2}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v2

    if-eqz v2, :cond_57

    move-object v0, p1

    .line 1441
    check-cast v0, Landroid/widget/CalendarView$WeekView;

    .line 1443
    .local v0, weekView:Landroid/widget/CalendarView$WeekView;
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result v2

    iget-object v3, p0, Landroid/widget/CalendarView$WeeksAdapter;->this$0:Landroid/widget/CalendarView;

    #getter for: Landroid/widget/CalendarView;->mTempDate:Ljava/util/Calendar;
    invoke-static {v3}, Landroid/widget/CalendarView;->access$2200(Landroid/widget/CalendarView;)Ljava/util/Calendar;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/widget/CalendarView$WeekView;->getDayFromLocation(FLjava/util/Calendar;)Z

    move-result v2

    if-nez v2, :cond_29

    .line 1454
    .end local v0           #weekView:Landroid/widget/CalendarView$WeekView;
    :cond_28
    :goto_28
    return v1

    .line 1448
    .restart local v0       #weekView:Landroid/widget/CalendarView$WeekView;
    :cond_29
    iget-object v2, p0, Landroid/widget/CalendarView$WeeksAdapter;->this$0:Landroid/widget/CalendarView;

    #getter for: Landroid/widget/CalendarView;->mTempDate:Ljava/util/Calendar;
    invoke-static {v2}, Landroid/widget/CalendarView;->access$2200(Landroid/widget/CalendarView;)Ljava/util/Calendar;

    move-result-object v2

    iget-object v3, p0, Landroid/widget/CalendarView$WeeksAdapter;->this$0:Landroid/widget/CalendarView;

    #getter for: Landroid/widget/CalendarView;->mMinDate:Ljava/util/Calendar;
    invoke-static {v3}, Landroid/widget/CalendarView;->access$1800(Landroid/widget/CalendarView;)Ljava/util/Calendar;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/Calendar;->before(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_28

    iget-object v2, p0, Landroid/widget/CalendarView$WeeksAdapter;->this$0:Landroid/widget/CalendarView;

    #getter for: Landroid/widget/CalendarView;->mTempDate:Ljava/util/Calendar;
    invoke-static {v2}, Landroid/widget/CalendarView;->access$2200(Landroid/widget/CalendarView;)Ljava/util/Calendar;

    move-result-object v2

    iget-object v3, p0, Landroid/widget/CalendarView$WeeksAdapter;->this$0:Landroid/widget/CalendarView;

    #getter for: Landroid/widget/CalendarView;->mMaxDate:Ljava/util/Calendar;
    invoke-static {v3}, Landroid/widget/CalendarView;->access$1700(Landroid/widget/CalendarView;)Ljava/util/Calendar;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/Calendar;->after(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_28

    .line 1451
    iget-object v2, p0, Landroid/widget/CalendarView$WeeksAdapter;->this$0:Landroid/widget/CalendarView;

    #getter for: Landroid/widget/CalendarView;->mTempDate:Ljava/util/Calendar;
    invoke-static {v2}, Landroid/widget/CalendarView;->access$2200(Landroid/widget/CalendarView;)Ljava/util/Calendar;

    move-result-object v2

    invoke-direct {p0, v2}, Landroid/widget/CalendarView$WeeksAdapter;->onDateTapped(Ljava/util/Calendar;)V

    goto :goto_28

    .line 1454
    .end local v0           #weekView:Landroid/widget/CalendarView$WeekView;
    :cond_57
    const/4 v1, 0x0

    goto :goto_28
.end method

.method public setFocusMonth(I)V
    .registers 3
    .parameter "month"

    .prologue
    .line 1431
    iget v0, p0, Landroid/widget/CalendarView$WeeksAdapter;->mFocusedMonth:I

    if-ne v0, p1, :cond_5

    .line 1436
    :goto_4
    return-void

    .line 1434
    :cond_5
    iput p1, p0, Landroid/widget/CalendarView$WeeksAdapter;->mFocusedMonth:I

    .line 1435
    invoke-virtual {p0}, Landroid/widget/CalendarView$WeeksAdapter;->notifyDataSetChanged()V

    goto :goto_4
.end method

.method public setSelectedDay(Ljava/util/Calendar;)V
    .registers 6
    .parameter "selectedDay"

    .prologue
    const/4 v3, 0x6

    const/4 v2, 0x1

    .line 1371
    invoke-virtual {p1, v3}, Ljava/util/Calendar;->get(I)I

    move-result v0

    iget-object v1, p0, Landroid/widget/CalendarView$WeeksAdapter;->mSelectedDate:Ljava/util/Calendar;

    invoke-virtual {v1, v3}, Ljava/util/Calendar;->get(I)I

    move-result v1

    if-ne v0, v1, :cond_1b

    invoke-virtual {p1, v2}, Ljava/util/Calendar;->get(I)I

    move-result v0

    iget-object v1, p0, Landroid/widget/CalendarView$WeeksAdapter;->mSelectedDate:Ljava/util/Calendar;

    invoke-virtual {v1, v2}, Ljava/util/Calendar;->get(I)I

    move-result v1

    if-ne v0, v1, :cond_1b

    .line 1379
    :goto_1a
    return-void

    .line 1375
    :cond_1b
    iget-object v0, p0, Landroid/widget/CalendarView$WeeksAdapter;->mSelectedDate:Ljava/util/Calendar;

    invoke-virtual {p1}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Ljava/util/Calendar;->setTimeInMillis(J)V

    .line 1376
    iget-object v0, p0, Landroid/widget/CalendarView$WeeksAdapter;->this$0:Landroid/widget/CalendarView;

    iget-object v1, p0, Landroid/widget/CalendarView$WeeksAdapter;->mSelectedDate:Ljava/util/Calendar;

    #calls: Landroid/widget/CalendarView;->getWeeksSinceMinDate(Ljava/util/Calendar;)I
    invoke-static {v0, v1}, Landroid/widget/CalendarView;->access$1600(Landroid/widget/CalendarView;Ljava/util/Calendar;)I

    move-result v0

    iput v0, p0, Landroid/widget/CalendarView$WeeksAdapter;->mSelectedWeek:I

    .line 1377
    iget-object v0, p0, Landroid/widget/CalendarView$WeeksAdapter;->mSelectedDate:Ljava/util/Calendar;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Ljava/util/Calendar;->get(I)I

    move-result v0

    iput v0, p0, Landroid/widget/CalendarView$WeeksAdapter;->mFocusedMonth:I

    .line 1378
    invoke-virtual {p0}, Landroid/widget/CalendarView$WeeksAdapter;->notifyDataSetChanged()V

    goto :goto_1a
.end method
