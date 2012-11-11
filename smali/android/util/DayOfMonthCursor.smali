.class public Landroid/util/DayOfMonthCursor;
.super Landroid/util/MonthDisplayHelper;
.source "DayOfMonthCursor.java"


# instance fields
.field private mColumn:I

.field private mRow:I


# direct methods
.method public constructor <init>(IIII)V
    .registers 6
    .parameter "year"
    .parameter "month"
    .parameter "dayOfMonth"
    .parameter "weekStartDay"

    .prologue
    invoke-direct {p0, p1, p2, p4}, Landroid/util/MonthDisplayHelper;-><init>(III)V

    invoke-virtual {p0, p3}, Landroid/util/DayOfMonthCursor;->getRowOf(I)I

    move-result v0

    iput v0, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    invoke-virtual {p0, p3}, Landroid/util/DayOfMonthCursor;->getColumnOf(I)I

    move-result v0

    iput v0, p0, Landroid/util/DayOfMonthCursor;->mColumn:I

    return-void
.end method


# virtual methods
.method public down()Z
    .registers 4

    .prologue
    const/4 v0, 0x0

    iget v1, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    add-int/lit8 v1, v1, 0x1

    iget v2, p0, Landroid/util/DayOfMonthCursor;->mColumn:I

    invoke-virtual {p0, v1, v2}, Landroid/util/DayOfMonthCursor;->isWithinCurrentMonth(II)Z

    move-result v1

    if-eqz v1, :cond_14

    iget v1, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    :goto_13
    return v0

    :cond_14
    invoke-virtual {p0}, Landroid/util/DayOfMonthCursor;->nextMonth()V

    iput v0, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    :goto_19
    iget v0, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    iget v1, p0, Landroid/util/DayOfMonthCursor;->mColumn:I

    invoke-virtual {p0, v0, v1}, Landroid/util/DayOfMonthCursor;->isWithinCurrentMonth(II)Z

    move-result v0

    if-nez v0, :cond_2a

    iget v0, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    goto :goto_19

    :cond_2a
    const/4 v0, 0x1

    goto :goto_13
.end method

.method public getSelectedColumn()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/util/DayOfMonthCursor;->mColumn:I

    return v0
.end method

.method public getSelectedDayOfMonth()I
    .registers 3

    .prologue
    iget v0, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    iget v1, p0, Landroid/util/DayOfMonthCursor;->mColumn:I

    invoke-virtual {p0, v0, v1}, Landroid/util/DayOfMonthCursor;->getDayAt(II)I

    move-result v0

    return v0
.end method

.method public getSelectedMonthOffset()I
    .registers 3

    .prologue
    iget v0, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    iget v1, p0, Landroid/util/DayOfMonthCursor;->mColumn:I

    invoke-virtual {p0, v0, v1}, Landroid/util/DayOfMonthCursor;->isWithinCurrentMonth(II)Z

    move-result v0

    if-eqz v0, :cond_c

    const/4 v0, 0x0

    :goto_b
    return v0

    :cond_c
    iget v0, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    if-nez v0, :cond_12

    const/4 v0, -0x1

    goto :goto_b

    :cond_12
    const/4 v0, 0x1

    goto :goto_b
.end method

.method public getSelectedRow()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    return v0
.end method

.method public isSelected(II)Z
    .registers 4
    .parameter "row"
    .parameter "column"

    .prologue
    iget v0, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    if-ne v0, p1, :cond_a

    iget v0, p0, Landroid/util/DayOfMonthCursor;->mColumn:I

    if-ne v0, p2, :cond_a

    const/4 v0, 0x1

    :goto_9
    return v0

    :cond_a
    const/4 v0, 0x0

    goto :goto_9
.end method

.method public left()Z
    .registers 4

    .prologue
    iget v1, p0, Landroid/util/DayOfMonthCursor;->mColumn:I

    if-nez v1, :cond_19

    iget v1, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    const/4 v1, 0x6

    iput v1, p0, Landroid/util/DayOfMonthCursor;->mColumn:I

    :goto_d
    iget v1, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    iget v2, p0, Landroid/util/DayOfMonthCursor;->mColumn:I

    invoke-virtual {p0, v1, v2}, Landroid/util/DayOfMonthCursor;->isWithinCurrentMonth(II)Z

    move-result v1

    if-eqz v1, :cond_20

    const/4 v1, 0x0

    :goto_18
    return v1

    :cond_19
    iget v1, p0, Landroid/util/DayOfMonthCursor;->mColumn:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Landroid/util/DayOfMonthCursor;->mColumn:I

    goto :goto_d

    :cond_20
    invoke-virtual {p0}, Landroid/util/DayOfMonthCursor;->previousMonth()V

    invoke-virtual {p0}, Landroid/util/DayOfMonthCursor;->getNumberOfDaysInMonth()I

    move-result v0

    .local v0, lastDay:I
    invoke-virtual {p0, v0}, Landroid/util/DayOfMonthCursor;->getRowOf(I)I

    move-result v1

    iput v1, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    invoke-virtual {p0, v0}, Landroid/util/DayOfMonthCursor;->getColumnOf(I)I

    move-result v1

    iput v1, p0, Landroid/util/DayOfMonthCursor;->mColumn:I

    const/4 v1, 0x1

    goto :goto_18
.end method

.method public right()Z
    .registers 4

    .prologue
    const/4 v0, 0x0

    iget v1, p0, Landroid/util/DayOfMonthCursor;->mColumn:I

    const/4 v2, 0x6

    if-ne v1, v2, :cond_19

    iget v1, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    iput v0, p0, Landroid/util/DayOfMonthCursor;->mColumn:I

    :goto_e
    iget v1, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    iget v2, p0, Landroid/util/DayOfMonthCursor;->mColumn:I

    invoke-virtual {p0, v1, v2}, Landroid/util/DayOfMonthCursor;->isWithinCurrentMonth(II)Z

    move-result v1

    if-eqz v1, :cond_20

    :goto_18
    return v0

    :cond_19
    iget v1, p0, Landroid/util/DayOfMonthCursor;->mColumn:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Landroid/util/DayOfMonthCursor;->mColumn:I

    goto :goto_e

    :cond_20
    invoke-virtual {p0}, Landroid/util/DayOfMonthCursor;->nextMonth()V

    iput v0, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    iput v0, p0, Landroid/util/DayOfMonthCursor;->mColumn:I

    :goto_27
    iget v0, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    iget v1, p0, Landroid/util/DayOfMonthCursor;->mColumn:I

    invoke-virtual {p0, v0, v1}, Landroid/util/DayOfMonthCursor;->isWithinCurrentMonth(II)Z

    move-result v0

    if-nez v0, :cond_38

    iget v0, p0, Landroid/util/DayOfMonthCursor;->mColumn:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Landroid/util/DayOfMonthCursor;->mColumn:I

    goto :goto_27

    :cond_38
    const/4 v0, 0x1

    goto :goto_18
.end method

.method public setSelectedDayOfMonth(I)V
    .registers 3
    .parameter "dayOfMonth"

    .prologue
    invoke-virtual {p0, p1}, Landroid/util/DayOfMonthCursor;->getRowOf(I)I

    move-result v0

    iput v0, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    invoke-virtual {p0, p1}, Landroid/util/DayOfMonthCursor;->getColumnOf(I)I

    move-result v0

    iput v0, p0, Landroid/util/DayOfMonthCursor;->mColumn:I

    return-void
.end method

.method public setSelectedRowColumn(II)V
    .registers 3
    .parameter "row"
    .parameter "col"

    .prologue
    iput p1, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    iput p2, p0, Landroid/util/DayOfMonthCursor;->mColumn:I

    return-void
.end method

.method public up()Z
    .registers 3

    .prologue
    iget v0, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    add-int/lit8 v0, v0, -0x1

    iget v1, p0, Landroid/util/DayOfMonthCursor;->mColumn:I

    invoke-virtual {p0, v0, v1}, Landroid/util/DayOfMonthCursor;->isWithinCurrentMonth(II)Z

    move-result v0

    if-eqz v0, :cond_14

    iget v0, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    const/4 v0, 0x0

    :goto_13
    return v0

    :cond_14
    invoke-virtual {p0}, Landroid/util/DayOfMonthCursor;->previousMonth()V

    const/4 v0, 0x5

    iput v0, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    :goto_1a
    iget v0, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    iget v1, p0, Landroid/util/DayOfMonthCursor;->mColumn:I

    invoke-virtual {p0, v0, v1}, Landroid/util/DayOfMonthCursor;->isWithinCurrentMonth(II)Z

    move-result v0

    if-nez v0, :cond_2b

    iget v0, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Landroid/util/DayOfMonthCursor;->mRow:I

    goto :goto_1a

    :cond_2b
    const/4 v0, 0x1

    goto :goto_13
.end method
