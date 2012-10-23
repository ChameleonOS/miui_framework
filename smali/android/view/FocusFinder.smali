.class public Landroid/view/FocusFinder;
.super Ljava/lang/Object;
.source "FocusFinder.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/view/FocusFinder$SequentialFocusComparator;
    }
.end annotation


# static fields
.field private static final tlFocusFinder:Ljava/lang/ThreadLocal;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ThreadLocal",
            "<",
            "Landroid/view/FocusFinder;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field final mBestCandidateRect:Landroid/graphics/Rect;

.field final mFocusedRect:Landroid/graphics/Rect;

.field final mOtherRect:Landroid/graphics/Rect;

.field final mSequentialFocusComparator:Landroid/view/FocusFinder$SequentialFocusComparator;

.field private final mTempList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 31
    new-instance v0, Landroid/view/FocusFinder$1;

    invoke-direct {v0}, Landroid/view/FocusFinder$1;-><init>()V

    sput-object v0, Landroid/view/FocusFinder;->tlFocusFinder:Ljava/lang/ThreadLocal;

    return-void
.end method

.method private constructor <init>()V
    .registers 3

    .prologue
    .line 54
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 46
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/view/FocusFinder;->mFocusedRect:Landroid/graphics/Rect;

    .line 47
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/view/FocusFinder;->mOtherRect:Landroid/graphics/Rect;

    .line 48
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/view/FocusFinder;->mBestCandidateRect:Landroid/graphics/Rect;

    .line 49
    new-instance v0, Landroid/view/FocusFinder$SequentialFocusComparator;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Landroid/view/FocusFinder$SequentialFocusComparator;-><init>(Landroid/view/FocusFinder$1;)V

    iput-object v0, p0, Landroid/view/FocusFinder;->mSequentialFocusComparator:Landroid/view/FocusFinder$SequentialFocusComparator;

    .line 51
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/view/FocusFinder;->mTempList:Ljava/util/ArrayList;

    .line 54
    return-void
.end method

.method synthetic constructor <init>(Landroid/view/FocusFinder$1;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 29
    invoke-direct {p0}, Landroid/view/FocusFinder;-><init>()V

    return-void
.end method

.method private findNextAccessibilityFocus(Landroid/view/ViewGroup;Landroid/view/View;Landroid/graphics/Rect;I)Landroid/view/View;
    .registers 12
    .parameter "root"
    .parameter "focused"
    .parameter "focusedRect"
    .parameter "direction"

    .prologue
    .line 181
    iget-object v5, p0, Landroid/view/FocusFinder;->mTempList:Ljava/util/ArrayList;

    .line 183
    .local v5, focusables:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/View;>;"
    :try_start_2
    invoke-virtual {v5}, Ljava/util/ArrayList;->clear()V

    .line 184
    const/4 v0, 0x2

    invoke-virtual {p1, v5, p4, v0}, Landroid/view/ViewGroup;->addFocusables(Ljava/util/ArrayList;II)V

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move v4, p4

    .line 185
    invoke-direct/range {v0 .. v5}, Landroid/view/FocusFinder;->findNextFocus(Landroid/view/ViewGroup;Landroid/view/View;Landroid/graphics/Rect;ILjava/util/ArrayList;)Landroid/view/View;
    :try_end_11
    .catchall {:try_start_2 .. :try_end_11} :catchall_16

    move-result-object v6

    .line 189
    .local v6, next:Landroid/view/View;
    invoke-virtual {v5}, Ljava/util/ArrayList;->clear()V

    return-object v6

    .end local v6           #next:Landroid/view/View;
    :catchall_16
    move-exception v0

    invoke-virtual {v5}, Ljava/util/ArrayList;->clear()V

    throw v0
.end method

.method private findNextFocus(Landroid/view/ViewGroup;Landroid/view/View;Landroid/graphics/Rect;I)Landroid/view/View;
    .registers 7
    .parameter "root"
    .parameter "focused"
    .parameter "focusedRect"
    .parameter "direction"

    .prologue
    .line 82
    and-int/lit16 v0, p4, 0x1000

    const/16 v1, 0x1000

    if-eq v0, v1, :cond_b

    .line 83
    invoke-direct {p0, p1, p2, p3, p4}, Landroid/view/FocusFinder;->findNextInputFocus(Landroid/view/ViewGroup;Landroid/view/View;Landroid/graphics/Rect;I)Landroid/view/View;

    move-result-object v0

    .line 85
    :goto_a
    return-object v0

    :cond_b
    invoke-direct {p0, p1, p2, p3, p4}, Landroid/view/FocusFinder;->findNextAccessibilityFocus(Landroid/view/ViewGroup;Landroid/view/View;Landroid/graphics/Rect;I)Landroid/view/View;

    move-result-object v0

    goto :goto_a
.end method

.method private findNextFocus(Landroid/view/ViewGroup;Landroid/view/View;Landroid/graphics/Rect;ILjava/util/ArrayList;)Landroid/view/View;
    .registers 12
    .parameter "root"
    .parameter "focused"
    .parameter "focusedRect"
    .parameter "direction"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/ViewGroup;",
            "Landroid/view/View;",
            "Landroid/graphics/Rect;",
            "I",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/view/View;",
            ">;)",
            "Landroid/view/View;"
        }
    .end annotation

    .prologue
    .line 123
    .local p5, focusables:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/View;>;"
    and-int/lit16 v5, p4, -0x1001

    .line 124
    .local v5, directionMasked:I
    if-eqz p2, :cond_2a

    .line 125
    if-nez p3, :cond_8

    .line 126
    iget-object p3, p0, Landroid/view/FocusFinder;->mFocusedRect:Landroid/graphics/Rect;

    .line 129
    :cond_8
    invoke-virtual {p2, p3}, Landroid/view/View;->getFocusedRect(Landroid/graphics/Rect;)V

    .line 130
    invoke-virtual {p1, p2, p3}, Landroid/view/ViewGroup;->offsetDescendantRectToMyCoords(Landroid/view/View;Landroid/graphics/Rect;)V

    .line 163
    :cond_e
    :goto_e
    sparse-switch v5, :sswitch_data_6a

    .line 175
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unknown direction: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 132
    :cond_2a
    if-nez p3, :cond_e

    .line 133
    iget-object p3, p0, Landroid/view/FocusFinder;->mFocusedRect:Landroid/graphics/Rect;

    .line 135
    sparse-switch v5, :sswitch_data_84

    goto :goto_e

    .line 153
    :sswitch_32
    invoke-virtual {p1}, Landroid/view/ViewGroup;->isLayoutRtl()Z

    move-result v0

    if-eqz v0, :cond_52

    .line 154
    invoke-direct {p0, p1, p3}, Landroid/view/FocusFinder;->setFocusTopLeft(Landroid/view/ViewGroup;Landroid/graphics/Rect;)V

    goto :goto_e

    .line 138
    :sswitch_3c
    invoke-direct {p0, p1, p3}, Landroid/view/FocusFinder;->setFocusTopLeft(Landroid/view/ViewGroup;Landroid/graphics/Rect;)V

    goto :goto_e

    .line 141
    :sswitch_40
    invoke-virtual {p1}, Landroid/view/ViewGroup;->isLayoutRtl()Z

    move-result v0

    if-eqz v0, :cond_4a

    .line 142
    invoke-direct {p0, p1, p3}, Landroid/view/FocusFinder;->setFocusBottomRight(Landroid/view/ViewGroup;Landroid/graphics/Rect;)V

    goto :goto_e

    .line 144
    :cond_4a
    invoke-direct {p0, p1, p3}, Landroid/view/FocusFinder;->setFocusTopLeft(Landroid/view/ViewGroup;Landroid/graphics/Rect;)V

    goto :goto_e

    .line 150
    :sswitch_4e
    invoke-direct {p0, p1, p3}, Landroid/view/FocusFinder;->setFocusBottomRight(Landroid/view/ViewGroup;Landroid/graphics/Rect;)V

    goto :goto_e

    .line 156
    :cond_52
    invoke-direct {p0, p1, p3}, Landroid/view/FocusFinder;->setFocusBottomRight(Landroid/view/ViewGroup;Landroid/graphics/Rect;)V

    goto :goto_e

    :sswitch_56
    move-object v0, p0

    move-object v1, p5

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    .line 166
    invoke-direct/range {v0 .. v5}, Landroid/view/FocusFinder;->findNextInputFocusInRelativeDirection(Ljava/util/ArrayList;Landroid/view/ViewGroup;Landroid/view/View;Landroid/graphics/Rect;I)Landroid/view/View;

    move-result-object v0

    .line 172
    :goto_5f
    return-object v0

    :sswitch_60
    move-object v0, p0

    move-object v1, p5

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    invoke-virtual/range {v0 .. v5}, Landroid/view/FocusFinder;->findNextInputFocusInAbsoluteDirection(Ljava/util/ArrayList;Landroid/view/ViewGroup;Landroid/view/View;Landroid/graphics/Rect;I)Landroid/view/View;

    move-result-object v0

    goto :goto_5f

    .line 163
    :sswitch_data_6a
    .sparse-switch
        0x1 -> :sswitch_56
        0x2 -> :sswitch_56
        0x11 -> :sswitch_60
        0x21 -> :sswitch_60
        0x42 -> :sswitch_60
        0x82 -> :sswitch_60
    .end sparse-switch

    .line 135
    :sswitch_data_84
    .sparse-switch
        0x1 -> :sswitch_32
        0x2 -> :sswitch_40
        0x11 -> :sswitch_4e
        0x21 -> :sswitch_4e
        0x42 -> :sswitch_3c
        0x82 -> :sswitch_3c
    .end sparse-switch
.end method

.method private findNextInputFocus(Landroid/view/ViewGroup;Landroid/view/View;Landroid/graphics/Rect;I)Landroid/view/View;
    .registers 13
    .parameter "root"
    .parameter "focused"
    .parameter "focusedRect"
    .parameter "direction"

    .prologue
    .line 90
    const/4 v6, 0x0

    .line 91
    .local v6, next:Landroid/view/View;
    if-eqz p2, :cond_7

    .line 92
    invoke-direct {p0, p1, p2, p4}, Landroid/view/FocusFinder;->findNextUserSpecifiedInputFocus(Landroid/view/ViewGroup;Landroid/view/View;I)Landroid/view/View;

    move-result-object v6

    .line 94
    :cond_7
    if-eqz v6, :cond_b

    move-object v7, v6

    .line 107
    .end local v6           #next:Landroid/view/View;
    .local v7, next:Landroid/view/View;
    :goto_a
    return-object v7

    .line 97
    .end local v7           #next:Landroid/view/View;
    .restart local v6       #next:Landroid/view/View;
    :cond_b
    iget-object v5, p0, Landroid/view/FocusFinder;->mTempList:Ljava/util/ArrayList;

    .line 99
    .local v5, focusables:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/View;>;"
    :try_start_d
    invoke-virtual {v5}, Ljava/util/ArrayList;->clear()V

    .line 100
    invoke-virtual {p1, v5, p4}, Landroid/view/ViewGroup;->addFocusables(Ljava/util/ArrayList;I)V

    .line 101
    invoke-virtual {v5}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_22

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move v4, p4

    .line 102
    invoke-direct/range {v0 .. v5}, Landroid/view/FocusFinder;->findNextFocus(Landroid/view/ViewGroup;Landroid/view/View;Landroid/graphics/Rect;ILjava/util/ArrayList;)Landroid/view/View;
    :try_end_21
    .catchall {:try_start_d .. :try_end_21} :catchall_27

    move-result-object v6

    .line 105
    :cond_22
    invoke-virtual {v5}, Ljava/util/ArrayList;->clear()V

    move-object v7, v6

    .line 107
    .end local v6           #next:Landroid/view/View;
    .restart local v7       #next:Landroid/view/View;
    goto :goto_a

    .line 105
    .end local v7           #next:Landroid/view/View;
    .restart local v6       #next:Landroid/view/View;
    :catchall_27
    move-exception v0

    invoke-virtual {v5}, Ljava/util/ArrayList;->clear()V

    throw v0
.end method

.method private findNextInputFocusInRelativeDirection(Ljava/util/ArrayList;Landroid/view/ViewGroup;Landroid/view/View;Landroid/graphics/Rect;I)Landroid/view/View;
    .registers 9
    .parameter
    .parameter "root"
    .parameter "focused"
    .parameter "focusedRect"
    .parameter "direction"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/view/View;",
            ">;",
            "Landroid/view/ViewGroup;",
            "Landroid/view/View;",
            "Landroid/graphics/Rect;",
            "I)",
            "Landroid/view/View;"
        }
    .end annotation

    .prologue
    .line 197
    .local p1, focusables:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/View;>;"
    :try_start_0
    iget-object v1, p0, Landroid/view/FocusFinder;->mSequentialFocusComparator:Landroid/view/FocusFinder$SequentialFocusComparator;

    invoke-virtual {v1, p2}, Landroid/view/FocusFinder$SequentialFocusComparator;->setRoot(Landroid/view/ViewGroup;)V

    .line 198
    iget-object v1, p0, Landroid/view/FocusFinder;->mSequentialFocusComparator:Landroid/view/FocusFinder$SequentialFocusComparator;

    invoke-static {p1, v1}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V
    :try_end_a
    .catchall {:try_start_0 .. :try_end_a} :catchall_1f

    .line 200
    iget-object v1, p0, Landroid/view/FocusFinder;->mSequentialFocusComparator:Landroid/view/FocusFinder$SequentialFocusComparator;

    invoke-virtual {v1}, Landroid/view/FocusFinder$SequentialFocusComparator;->recycle()V

    .line 203
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 204
    .local v0, count:I
    packed-switch p5, :pswitch_data_30

    .line 210
    add-int/lit8 v1, v0, -0x1

    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/View;

    :goto_1e
    return-object v1

    .line 200
    .end local v0           #count:I
    :catchall_1f
    move-exception v1

    iget-object v2, p0, Landroid/view/FocusFinder;->mSequentialFocusComparator:Landroid/view/FocusFinder$SequentialFocusComparator;

    invoke-virtual {v2}, Landroid/view/FocusFinder$SequentialFocusComparator;->recycle()V

    throw v1

    .line 206
    .restart local v0       #count:I
    :pswitch_26
    invoke-static {p2, p3, p1, v0}, Landroid/view/FocusFinder;->getForwardFocusable(Landroid/view/ViewGroup;Landroid/view/View;Ljava/util/ArrayList;I)Landroid/view/View;

    move-result-object v1

    goto :goto_1e

    .line 208
    :pswitch_2b
    invoke-static {p2, p3, p1, v0}, Landroid/view/FocusFinder;->getBackwardFocusable(Landroid/view/ViewGroup;Landroid/view/View;Ljava/util/ArrayList;I)Landroid/view/View;

    move-result-object v1

    goto :goto_1e

    .line 204
    :pswitch_data_30
    .packed-switch 0x1
        :pswitch_2b
        :pswitch_26
    .end packed-switch
.end method

.method private findNextUserSpecifiedInputFocus(Landroid/view/ViewGroup;Landroid/view/View;I)Landroid/view/View;
    .registers 6
    .parameter "root"
    .parameter "focused"
    .parameter "direction"

    .prologue
    .line 112
    invoke-virtual {p2, p1, p3}, Landroid/view/View;->findUserSetNextFocus(Landroid/view/View;I)Landroid/view/View;

    move-result-object v0

    .line 113
    .local v0, userSetNextFocus:Landroid/view/View;
    if-eqz v0, :cond_19

    invoke-virtual {v0}, Landroid/view/View;->isFocusable()Z

    move-result v1

    if-eqz v1, :cond_19

    invoke-virtual {v0}, Landroid/view/View;->isInTouchMode()Z

    move-result v1

    if-eqz v1, :cond_18

    invoke-virtual {v0}, Landroid/view/View;->isFocusableInTouchMode()Z

    move-result v1

    if-eqz v1, :cond_19

    .line 118
    .end local v0           #userSetNextFocus:Landroid/view/View;
    :cond_18
    :goto_18
    return-object v0

    .restart local v0       #userSetNextFocus:Landroid/view/View;
    :cond_19
    const/4 v0, 0x0

    goto :goto_18
.end method

.method private static getBackwardFocusable(Landroid/view/ViewGroup;Landroid/view/View;Ljava/util/ArrayList;I)Landroid/view/View;
    .registers 5
    .parameter "root"
    .parameter "focused"
    .parameter
    .parameter "count"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/ViewGroup;",
            "Landroid/view/View;",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/view/View;",
            ">;I)",
            "Landroid/view/View;"
        }
    .end annotation

    .prologue
    .line 287
    .local p2, focusables:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/View;>;"
    invoke-virtual {p0}, Landroid/view/ViewGroup;->isLayoutRtl()Z

    move-result v0

    if-eqz v0, :cond_b

    invoke-static {p1, p2, p3}, Landroid/view/FocusFinder;->getNextFocusable(Landroid/view/View;Ljava/util/ArrayList;I)Landroid/view/View;

    move-result-object v0

    :goto_a
    return-object v0

    :cond_b
    invoke-static {p1, p2, p3}, Landroid/view/FocusFinder;->getPreviousFocusable(Landroid/view/View;Ljava/util/ArrayList;I)Landroid/view/View;

    move-result-object v0

    goto :goto_a
.end method

.method private static getForwardFocusable(Landroid/view/ViewGroup;Landroid/view/View;Ljava/util/ArrayList;I)Landroid/view/View;
    .registers 5
    .parameter "root"
    .parameter "focused"
    .parameter
    .parameter "count"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/ViewGroup;",
            "Landroid/view/View;",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/view/View;",
            ">;I)",
            "Landroid/view/View;"
        }
    .end annotation

    .prologue
    .line 267
    .local p2, focusables:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/View;>;"
    invoke-virtual {p0}, Landroid/view/ViewGroup;->isLayoutRtl()Z

    move-result v0

    if-eqz v0, :cond_b

    invoke-static {p1, p2, p3}, Landroid/view/FocusFinder;->getPreviousFocusable(Landroid/view/View;Ljava/util/ArrayList;I)Landroid/view/View;

    move-result-object v0

    :goto_a
    return-object v0

    :cond_b
    invoke-static {p1, p2, p3}, Landroid/view/FocusFinder;->getNextFocusable(Landroid/view/View;Ljava/util/ArrayList;I)Landroid/view/View;

    move-result-object v0

    goto :goto_a
.end method

.method public static getInstance()Landroid/view/FocusFinder;
    .registers 1

    .prologue
    .line 43
    sget-object v0, Landroid/view/FocusFinder;->tlFocusFinder:Ljava/lang/ThreadLocal;

    invoke-virtual {v0}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/FocusFinder;

    return-object v0
.end method

.method private static getNextFocusable(Landroid/view/View;Ljava/util/ArrayList;I)Landroid/view/View;
    .registers 5
    .parameter "focused"
    .parameter
    .parameter "count"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/View;",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/view/View;",
            ">;I)",
            "Landroid/view/View;"
        }
    .end annotation

    .prologue
    .line 273
    .local p1, focusables:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/View;>;"
    if-eqz p0, :cond_15

    .line 274
    invoke-virtual {p1, p0}, Ljava/util/ArrayList;->lastIndexOf(Ljava/lang/Object;)I

    move-result v0

    .line 275
    .local v0, position:I
    if-ltz v0, :cond_15

    add-int/lit8 v1, v0, 0x1

    if-ge v1, p2, :cond_15

    .line 276
    add-int/lit8 v1, v0, 0x1

    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/View;

    .line 282
    .end local v0           #position:I
    :goto_14
    return-object v1

    .line 279
    :cond_15
    invoke-virtual {p1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_23

    .line 280
    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/View;

    goto :goto_14

    .line 282
    :cond_23
    const/4 v1, 0x0

    goto :goto_14
.end method

.method private static getPreviousFocusable(Landroid/view/View;Ljava/util/ArrayList;I)Landroid/view/View;
    .registers 5
    .parameter "focused"
    .parameter
    .parameter "count"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/View;",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/view/View;",
            ">;I)",
            "Landroid/view/View;"
        }
    .end annotation

    .prologue
    .line 293
    .local p1, focusables:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/View;>;"
    if-eqz p0, :cond_11

    .line 294
    invoke-virtual {p1, p0}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v0

    .line 295
    .local v0, position:I
    if-lez v0, :cond_11

    .line 296
    add-int/lit8 v1, v0, -0x1

    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/View;

    .line 302
    .end local v0           #position:I
    :goto_10
    return-object v1

    .line 299
    :cond_11
    invoke-virtual {p1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_20

    .line 300
    add-int/lit8 v1, p2, -0x1

    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/View;

    goto :goto_10

    .line 302
    :cond_20
    const/4 v1, 0x0

    goto :goto_10
.end method

.method private isTouchCandidate(IILandroid/graphics/Rect;I)Z
    .registers 8
    .parameter "x"
    .parameter "y"
    .parameter "destRect"
    .parameter "direction"

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 623
    sparse-switch p4, :sswitch_data_46

    .line 633
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 625
    :sswitch_d
    iget v2, p3, Landroid/graphics/Rect;->left:I

    if-gt v2, p1, :cond_1a

    iget v2, p3, Landroid/graphics/Rect;->top:I

    if-gt v2, p2, :cond_1a

    iget v2, p3, Landroid/graphics/Rect;->bottom:I

    if-gt p2, v2, :cond_1a

    .line 631
    :cond_19
    :goto_19
    return v0

    :cond_1a
    move v0, v1

    .line 625
    goto :goto_19

    .line 627
    :sswitch_1c
    iget v2, p3, Landroid/graphics/Rect;->left:I

    if-lt v2, p1, :cond_28

    iget v2, p3, Landroid/graphics/Rect;->top:I

    if-gt v2, p2, :cond_28

    iget v2, p3, Landroid/graphics/Rect;->bottom:I

    if-le p2, v2, :cond_19

    :cond_28
    move v0, v1

    goto :goto_19

    .line 629
    :sswitch_2a
    iget v2, p3, Landroid/graphics/Rect;->top:I

    if-gt v2, p2, :cond_36

    iget v2, p3, Landroid/graphics/Rect;->left:I

    if-gt v2, p1, :cond_36

    iget v2, p3, Landroid/graphics/Rect;->right:I

    if-le p1, v2, :cond_19

    :cond_36
    move v0, v1

    goto :goto_19

    .line 631
    :sswitch_38
    iget v2, p3, Landroid/graphics/Rect;->top:I

    if-lt v2, p2, :cond_44

    iget v2, p3, Landroid/graphics/Rect;->left:I

    if-gt v2, p1, :cond_44

    iget v2, p3, Landroid/graphics/Rect;->right:I

    if-le p1, v2, :cond_19

    :cond_44
    move v0, v1

    goto :goto_19

    .line 623
    :sswitch_data_46
    .sparse-switch
        0x11 -> :sswitch_d
        0x21 -> :sswitch_2a
        0x42 -> :sswitch_1c
        0x82 -> :sswitch_38
    .end sparse-switch
.end method

.method static majorAxisDistance(ILandroid/graphics/Rect;Landroid/graphics/Rect;)I
    .registers 5
    .parameter "direction"
    .parameter "source"
    .parameter "dest"

    .prologue
    .line 468
    const/4 v0, 0x0

    invoke-static {p0, p1, p2}, Landroid/view/FocusFinder;->majorAxisDistanceRaw(ILandroid/graphics/Rect;Landroid/graphics/Rect;)I

    move-result v1

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    return v0
.end method

.method static majorAxisDistanceRaw(ILandroid/graphics/Rect;Landroid/graphics/Rect;)I
    .registers 5
    .parameter "direction"
    .parameter "source"
    .parameter "dest"

    .prologue
    .line 472
    sparse-switch p0, :sswitch_data_24

    .line 482
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 474
    :sswitch_b
    iget v0, p1, Landroid/graphics/Rect;->left:I

    iget v1, p2, Landroid/graphics/Rect;->right:I

    sub-int/2addr v0, v1

    .line 480
    :goto_10
    return v0

    .line 476
    :sswitch_11
    iget v0, p2, Landroid/graphics/Rect;->left:I

    iget v1, p1, Landroid/graphics/Rect;->right:I

    sub-int/2addr v0, v1

    goto :goto_10

    .line 478
    :sswitch_17
    iget v0, p1, Landroid/graphics/Rect;->top:I

    iget v1, p2, Landroid/graphics/Rect;->bottom:I

    sub-int/2addr v0, v1

    goto :goto_10

    .line 480
    :sswitch_1d
    iget v0, p2, Landroid/graphics/Rect;->top:I

    iget v1, p1, Landroid/graphics/Rect;->bottom:I

    sub-int/2addr v0, v1

    goto :goto_10

    .line 472
    nop

    :sswitch_data_24
    .sparse-switch
        0x11 -> :sswitch_b
        0x21 -> :sswitch_17
        0x42 -> :sswitch_11
        0x82 -> :sswitch_1d
    .end sparse-switch
.end method

.method static majorAxisDistanceToFarEdge(ILandroid/graphics/Rect;Landroid/graphics/Rect;)I
    .registers 5
    .parameter "direction"
    .parameter "source"
    .parameter "dest"

    .prologue
    .line 493
    const/4 v0, 0x1

    invoke-static {p0, p1, p2}, Landroid/view/FocusFinder;->majorAxisDistanceToFarEdgeRaw(ILandroid/graphics/Rect;Landroid/graphics/Rect;)I

    move-result v1

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    return v0
.end method

.method static majorAxisDistanceToFarEdgeRaw(ILandroid/graphics/Rect;Landroid/graphics/Rect;)I
    .registers 5
    .parameter "direction"
    .parameter "source"
    .parameter "dest"

    .prologue
    .line 497
    sparse-switch p0, :sswitch_data_24

    .line 507
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 499
    :sswitch_b
    iget v0, p1, Landroid/graphics/Rect;->left:I

    iget v1, p2, Landroid/graphics/Rect;->left:I

    sub-int/2addr v0, v1

    .line 505
    :goto_10
    return v0

    .line 501
    :sswitch_11
    iget v0, p2, Landroid/graphics/Rect;->right:I

    iget v1, p1, Landroid/graphics/Rect;->right:I

    sub-int/2addr v0, v1

    goto :goto_10

    .line 503
    :sswitch_17
    iget v0, p1, Landroid/graphics/Rect;->top:I

    iget v1, p2, Landroid/graphics/Rect;->top:I

    sub-int/2addr v0, v1

    goto :goto_10

    .line 505
    :sswitch_1d
    iget v0, p2, Landroid/graphics/Rect;->bottom:I

    iget v1, p1, Landroid/graphics/Rect;->bottom:I

    sub-int/2addr v0, v1

    goto :goto_10

    .line 497
    nop

    :sswitch_data_24
    .sparse-switch
        0x11 -> :sswitch_b
        0x21 -> :sswitch_17
        0x42 -> :sswitch_11
        0x82 -> :sswitch_1d
    .end sparse-switch
.end method

.method static minorAxisDistance(ILandroid/graphics/Rect;Landroid/graphics/Rect;)I
    .registers 6
    .parameter "direction"
    .parameter "source"
    .parameter "dest"

    .prologue
    .line 520
    sparse-switch p0, :sswitch_data_3c

    .line 534
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 524
    :sswitch_b
    iget v0, p1, Landroid/graphics/Rect;->top:I

    invoke-virtual {p1}, Landroid/graphics/Rect;->height()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    add-int/2addr v0, v1

    iget v1, p2, Landroid/graphics/Rect;->top:I

    invoke-virtual {p2}, Landroid/graphics/Rect;->height()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    add-int/2addr v1, v2

    sub-int/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Math;->abs(I)I

    move-result v0

    .line 530
    :goto_22
    return v0

    :sswitch_23
    iget v0, p1, Landroid/graphics/Rect;->left:I

    invoke-virtual {p1}, Landroid/graphics/Rect;->width()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    add-int/2addr v0, v1

    iget v1, p2, Landroid/graphics/Rect;->left:I

    invoke-virtual {p2}, Landroid/graphics/Rect;->width()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    add-int/2addr v1, v2

    sub-int/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Math;->abs(I)I

    move-result v0

    goto :goto_22

    .line 520
    nop

    :sswitch_data_3c
    .sparse-switch
        0x11 -> :sswitch_b
        0x21 -> :sswitch_23
        0x42 -> :sswitch_b
        0x82 -> :sswitch_23
    .end sparse-switch
.end method

.method private setFocusBottomRight(Landroid/view/ViewGroup;Landroid/graphics/Rect;)V
    .registers 7
    .parameter "root"
    .parameter "focusedRect"

    .prologue
    .line 214
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getScrollY()I

    move-result v2

    invoke-virtual {p1}, Landroid/view/ViewGroup;->getHeight()I

    move-result v3

    add-int v0, v2, v3

    .line 215
    .local v0, rootBottom:I
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getScrollX()I

    move-result v2

    invoke-virtual {p1}, Landroid/view/ViewGroup;->getWidth()I

    move-result v3

    add-int v1, v2, v3

    .line 216
    .local v1, rootRight:I
    invoke-virtual {p2, v1, v0, v1, v0}, Landroid/graphics/Rect;->set(IIII)V

    .line 217
    return-void
.end method

.method private setFocusTopLeft(Landroid/view/ViewGroup;Landroid/graphics/Rect;)V
    .registers 5
    .parameter "root"
    .parameter "focusedRect"

    .prologue
    .line 220
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getScrollY()I

    move-result v1

    .line 221
    .local v1, rootTop:I
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getScrollX()I

    move-result v0

    .line 222
    .local v0, rootLeft:I
    invoke-virtual {p2, v0, v1, v0, v1}, Landroid/graphics/Rect;->set(IIII)V

    .line 223
    return-void
.end method


# virtual methods
.method beamBeats(ILandroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Rect;)Z
    .registers 11
    .parameter "direction"
    .parameter "source"
    .parameter "rect1"
    .parameter "rect2"

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 355
    invoke-virtual {p0, p1, p2, p3}, Landroid/view/FocusFinder;->beamsOverlap(ILandroid/graphics/Rect;Landroid/graphics/Rect;)Z

    move-result v0

    .line 356
    .local v0, rect1InSrcBeam:Z
    invoke-virtual {p0, p1, p2, p4}, Landroid/view/FocusFinder;->beamsOverlap(ILandroid/graphics/Rect;Landroid/graphics/Rect;)Z

    move-result v1

    .line 359
    .local v1, rect2InSrcBeam:Z
    if-nez v1, :cond_e

    if-nez v0, :cond_10

    :cond_e
    move v2, v3

    .line 382
    :cond_f
    :goto_f
    return v2

    .line 369
    :cond_10
    invoke-virtual {p0, p1, p2, p4}, Landroid/view/FocusFinder;->isToDirectionOf(ILandroid/graphics/Rect;Landroid/graphics/Rect;)Z

    move-result v4

    if-eqz v4, :cond_f

    .line 374
    const/16 v4, 0x11

    if-eq p1, v4, :cond_f

    const/16 v4, 0x42

    if-eq p1, v4, :cond_f

    .line 382
    invoke-static {p1, p2, p3}, Landroid/view/FocusFinder;->majorAxisDistance(ILandroid/graphics/Rect;Landroid/graphics/Rect;)I

    move-result v4

    invoke-static {p1, p2, p4}, Landroid/view/FocusFinder;->majorAxisDistanceToFarEdge(ILandroid/graphics/Rect;Landroid/graphics/Rect;)I

    move-result v5

    if-lt v4, v5, :cond_f

    move v2, v3

    goto :goto_f
.end method

.method beamsOverlap(ILandroid/graphics/Rect;Landroid/graphics/Rect;)Z
    .registers 8
    .parameter "direction"
    .parameter "rect1"
    .parameter "rect2"

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 432
    sparse-switch p1, :sswitch_data_2a

    .line 440
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 435
    :sswitch_d
    iget v2, p3, Landroid/graphics/Rect;->bottom:I

    iget v3, p2, Landroid/graphics/Rect;->top:I

    if-lt v2, v3, :cond_1a

    iget v2, p3, Landroid/graphics/Rect;->top:I

    iget v3, p2, Landroid/graphics/Rect;->bottom:I

    if-gt v2, v3, :cond_1a

    .line 438
    :cond_19
    :goto_19
    return v0

    :cond_1a
    move v0, v1

    .line 435
    goto :goto_19

    .line 438
    :sswitch_1c
    iget v2, p3, Landroid/graphics/Rect;->right:I

    iget v3, p2, Landroid/graphics/Rect;->left:I

    if-lt v2, v3, :cond_28

    iget v2, p3, Landroid/graphics/Rect;->left:I

    iget v3, p2, Landroid/graphics/Rect;->right:I

    if-le v2, v3, :cond_19

    :cond_28
    move v0, v1

    goto :goto_19

    .line 432
    :sswitch_data_2a
    .sparse-switch
        0x11 -> :sswitch_d
        0x21 -> :sswitch_1c
        0x42 -> :sswitch_d
        0x82 -> :sswitch_1c
    .end sparse-switch
.end method

.method public findNearestTouchable(Landroid/view/ViewGroup;III[I)Landroid/view/View;
    .registers 21
    .parameter "root"
    .parameter "x"
    .parameter "y"
    .parameter "direction"
    .parameter "deltas"

    .prologue
    .line 550
    invoke-virtual/range {p1 .. p1}, Landroid/view/ViewGroup;->getTouchables()Ljava/util/ArrayList;

    move-result-object v12

    .line 551
    .local v12, touchables:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/View;>;"
    const v8, 0x7fffffff

    .line 552
    .local v8, minDistance:I
    const/4 v3, 0x0

    .line 554
    .local v3, closest:Landroid/view/View;
    invoke-virtual {v12}, Ljava/util/ArrayList;->size()I

    move-result v9

    .line 556
    .local v9, numTouchables:I
    move-object/from16 v0, p1

    iget-object v13, v0, Landroid/view/View;->mContext:Landroid/content/Context;

    invoke-static {v13}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v13

    invoke-virtual {v13}, Landroid/view/ViewConfiguration;->getScaledEdgeSlop()I

    move-result v6

    .line 558
    .local v6, edgeSlop:I
    new-instance v4, Landroid/graphics/Rect;

    invoke-direct {v4}, Landroid/graphics/Rect;-><init>()V

    .line 559
    .local v4, closestBounds:Landroid/graphics/Rect;
    iget-object v11, p0, Landroid/view/FocusFinder;->mOtherRect:Landroid/graphics/Rect;

    .line 561
    .local v11, touchableBounds:Landroid/graphics/Rect;
    const/4 v7, 0x0

    .local v7, i:I
    :goto_20
    if-ge v7, v9, :cond_88

    .line 562
    invoke-virtual {v12, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroid/view/View;

    .line 565
    .local v10, touchable:Landroid/view/View;
    invoke-virtual {v10, v11}, Landroid/view/View;->getDrawingRect(Landroid/graphics/Rect;)V

    .line 567
    const/4 v13, 0x1

    const/4 v14, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v10, v11, v13, v14}, Landroid/view/ViewGroup;->offsetRectBetweenParentAndChild(Landroid/view/View;Landroid/graphics/Rect;ZZ)V

    .line 569
    move/from16 v0, p2

    move/from16 v1, p3

    move/from16 v2, p4

    invoke-direct {p0, v0, v1, v11, v2}, Landroid/view/FocusFinder;->isTouchCandidate(IILandroid/graphics/Rect;I)Z

    move-result v13

    if-nez v13, :cond_41

    .line 561
    :cond_3e
    :goto_3e
    add-int/lit8 v7, v7, 0x1

    goto :goto_20

    .line 573
    :cond_41
    const v5, 0x7fffffff

    .line 575
    .local v5, distance:I
    sparse-switch p4, :sswitch_data_8a

    .line 590
    :goto_47
    if-ge v5, v6, :cond_3e

    .line 592
    if-eqz v3, :cond_59

    invoke-virtual {v4, v11}, Landroid/graphics/Rect;->contains(Landroid/graphics/Rect;)Z

    move-result v13

    if-nez v13, :cond_59

    invoke-virtual {v11, v4}, Landroid/graphics/Rect;->contains(Landroid/graphics/Rect;)Z

    move-result v13

    if-nez v13, :cond_3e

    if-ge v5, v8, :cond_3e

    .line 595
    :cond_59
    move v8, v5

    .line 596
    move-object v3, v10

    .line 597
    invoke-virtual {v4, v11}, Landroid/graphics/Rect;->set(Landroid/graphics/Rect;)V

    .line 598
    sparse-switch p4, :sswitch_data_9c

    goto :goto_3e

    .line 600
    :sswitch_62
    const/4 v13, 0x0

    neg-int v14, v5

    aput v14, p5, v13

    goto :goto_3e

    .line 577
    :sswitch_67
    iget v13, v11, Landroid/graphics/Rect;->right:I

    sub-int v13, p2, v13

    add-int/lit8 v5, v13, 0x1

    .line 578
    goto :goto_47

    .line 580
    :sswitch_6e
    iget v5, v11, Landroid/graphics/Rect;->left:I

    .line 581
    goto :goto_47

    .line 583
    :sswitch_71
    iget v13, v11, Landroid/graphics/Rect;->bottom:I

    sub-int v13, p3, v13

    add-int/lit8 v5, v13, 0x1

    .line 584
    goto :goto_47

    .line 586
    :sswitch_78
    iget v5, v11, Landroid/graphics/Rect;->top:I

    goto :goto_47

    .line 603
    :sswitch_7b
    const/4 v13, 0x0

    aput v5, p5, v13

    goto :goto_3e

    .line 606
    :sswitch_7f
    const/4 v13, 0x1

    neg-int v14, v5

    aput v14, p5, v13

    goto :goto_3e

    .line 609
    :sswitch_84
    const/4 v13, 0x1

    aput v5, p5, v13

    goto :goto_3e

    .line 615
    .end local v5           #distance:I
    .end local v10           #touchable:Landroid/view/View;
    :cond_88
    return-object v3

    .line 575
    nop

    :sswitch_data_8a
    .sparse-switch
        0x11 -> :sswitch_67
        0x21 -> :sswitch_71
        0x42 -> :sswitch_6e
        0x82 -> :sswitch_78
    .end sparse-switch

    .line 598
    :sswitch_data_9c
    .sparse-switch
        0x11 -> :sswitch_62
        0x21 -> :sswitch_7f
        0x42 -> :sswitch_7b
        0x82 -> :sswitch_84
    .end sparse-switch
.end method

.method public final findNextFocus(Landroid/view/ViewGroup;Landroid/view/View;I)Landroid/view/View;
    .registers 5
    .parameter "root"
    .parameter "focused"
    .parameter "direction"

    .prologue
    .line 65
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0, p3}, Landroid/view/FocusFinder;->findNextFocus(Landroid/view/ViewGroup;Landroid/view/View;Landroid/graphics/Rect;I)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public findNextFocusFromRect(Landroid/view/ViewGroup;Landroid/graphics/Rect;I)Landroid/view/View;
    .registers 6
    .parameter "root"
    .parameter "focusedRect"
    .parameter "direction"

    .prologue
    .line 77
    iget-object v0, p0, Landroid/view/FocusFinder;->mFocusedRect:Landroid/graphics/Rect;

    invoke-virtual {v0, p2}, Landroid/graphics/Rect;->set(Landroid/graphics/Rect;)V

    .line 78
    const/4 v0, 0x0

    iget-object v1, p0, Landroid/view/FocusFinder;->mFocusedRect:Landroid/graphics/Rect;

    invoke-direct {p0, p1, v0, v1, p3}, Landroid/view/FocusFinder;->findNextFocus(Landroid/view/ViewGroup;Landroid/view/View;Landroid/graphics/Rect;I)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method findNextInputFocusInAbsoluteDirection(Ljava/util/ArrayList;Landroid/view/ViewGroup;Landroid/view/View;Landroid/graphics/Rect;I)Landroid/view/View;
    .registers 13
    .parameter
    .parameter "root"
    .parameter "focused"
    .parameter "focusedRect"
    .parameter "direction"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/view/View;",
            ">;",
            "Landroid/view/ViewGroup;",
            "Landroid/view/View;",
            "Landroid/graphics/Rect;",
            "I)",
            "Landroid/view/View;"
        }
    .end annotation

    .prologue
    .local p1, focusables:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/View;>;"
    const/4 v6, 0x0

    .line 229
    iget-object v4, p0, Landroid/view/FocusFinder;->mBestCandidateRect:Landroid/graphics/Rect;

    invoke-virtual {v4, p4}, Landroid/graphics/Rect;->set(Landroid/graphics/Rect;)V

    .line 230
    sparse-switch p5, :sswitch_data_6e

    .line 244
    :goto_9
    const/4 v0, 0x0

    .line 246
    .local v0, closest:Landroid/view/View;
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v3

    .line 247
    .local v3, numFocusables:I
    const/4 v2, 0x0

    .local v2, i:I
    :goto_f
    if-ge v2, v3, :cond_6d

    .line 248
    invoke-virtual {p1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/View;

    .line 251
    .local v1, focusable:Landroid/view/View;
    if-eq v1, p3, :cond_1b

    if-ne v1, p2, :cond_50

    .line 247
    :cond_1b
    :goto_1b
    add-int/lit8 v2, v2, 0x1

    goto :goto_f

    .line 232
    .end local v0           #closest:Landroid/view/View;
    .end local v1           #focusable:Landroid/view/View;
    .end local v2           #i:I
    .end local v3           #numFocusables:I
    :sswitch_1e
    iget-object v4, p0, Landroid/view/FocusFinder;->mBestCandidateRect:Landroid/graphics/Rect;

    invoke-virtual {p4}, Landroid/graphics/Rect;->width()I

    move-result v5

    add-int/lit8 v5, v5, 0x1

    invoke-virtual {v4, v5, v6}, Landroid/graphics/Rect;->offset(II)V

    goto :goto_9

    .line 235
    :sswitch_2a
    iget-object v4, p0, Landroid/view/FocusFinder;->mBestCandidateRect:Landroid/graphics/Rect;

    invoke-virtual {p4}, Landroid/graphics/Rect;->width()I

    move-result v5

    add-int/lit8 v5, v5, 0x1

    neg-int v5, v5

    invoke-virtual {v4, v5, v6}, Landroid/graphics/Rect;->offset(II)V

    goto :goto_9

    .line 238
    :sswitch_37
    iget-object v4, p0, Landroid/view/FocusFinder;->mBestCandidateRect:Landroid/graphics/Rect;

    invoke-virtual {p4}, Landroid/graphics/Rect;->height()I

    move-result v5

    add-int/lit8 v5, v5, 0x1

    invoke-virtual {v4, v6, v5}, Landroid/graphics/Rect;->offset(II)V

    goto :goto_9

    .line 241
    :sswitch_43
    iget-object v4, p0, Landroid/view/FocusFinder;->mBestCandidateRect:Landroid/graphics/Rect;

    invoke-virtual {p4}, Landroid/graphics/Rect;->height()I

    move-result v5

    add-int/lit8 v5, v5, 0x1

    neg-int v5, v5

    invoke-virtual {v4, v6, v5}, Landroid/graphics/Rect;->offset(II)V

    goto :goto_9

    .line 254
    .restart local v0       #closest:Landroid/view/View;
    .restart local v1       #focusable:Landroid/view/View;
    .restart local v2       #i:I
    .restart local v3       #numFocusables:I
    :cond_50
    iget-object v4, p0, Landroid/view/FocusFinder;->mOtherRect:Landroid/graphics/Rect;

    invoke-virtual {v1, v4}, Landroid/view/View;->getDrawingRect(Landroid/graphics/Rect;)V

    .line 255
    iget-object v4, p0, Landroid/view/FocusFinder;->mOtherRect:Landroid/graphics/Rect;

    invoke-virtual {p2, v1, v4}, Landroid/view/ViewGroup;->offsetDescendantRectToMyCoords(Landroid/view/View;Landroid/graphics/Rect;)V

    .line 257
    iget-object v4, p0, Landroid/view/FocusFinder;->mOtherRect:Landroid/graphics/Rect;

    iget-object v5, p0, Landroid/view/FocusFinder;->mBestCandidateRect:Landroid/graphics/Rect;

    invoke-virtual {p0, p5, p4, v4, v5}, Landroid/view/FocusFinder;->isBetterCandidate(ILandroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Rect;)Z

    move-result v4

    if-eqz v4, :cond_1b

    .line 258
    iget-object v4, p0, Landroid/view/FocusFinder;->mBestCandidateRect:Landroid/graphics/Rect;

    iget-object v5, p0, Landroid/view/FocusFinder;->mOtherRect:Landroid/graphics/Rect;

    invoke-virtual {v4, v5}, Landroid/graphics/Rect;->set(Landroid/graphics/Rect;)V

    .line 259
    move-object v0, v1

    goto :goto_1b

    .line 262
    .end local v1           #focusable:Landroid/view/View;
    :cond_6d
    return-object v0

    .line 230
    :sswitch_data_6e
    .sparse-switch
        0x11 -> :sswitch_1e
        0x21 -> :sswitch_37
        0x42 -> :sswitch_2a
        0x82 -> :sswitch_43
    .end sparse-switch
.end method

.method getWeightedDistanceFor(II)I
    .registers 5
    .parameter "majorAxisDistance"
    .parameter "minorAxisDistance"

    .prologue
    .line 392
    mul-int/lit8 v0, p1, 0xd

    mul-int/2addr v0, p1

    mul-int v1, p2, p2

    add-int/2addr v0, v1

    return v0
.end method

.method isBetterCandidate(ILandroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Rect;)Z
    .registers 10
    .parameter "direction"
    .parameter "source"
    .parameter "rect1"
    .parameter "rect2"

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 319
    invoke-virtual {p0, p2, p3, p1}, Landroid/view/FocusFinder;->isCandidate(Landroid/graphics/Rect;Landroid/graphics/Rect;I)Z

    move-result v2

    if-nez v2, :cond_a

    move v0, v1

    .line 340
    :cond_9
    :goto_9
    return v0

    .line 325
    :cond_a
    invoke-virtual {p0, p2, p4, p1}, Landroid/view/FocusFinder;->isCandidate(Landroid/graphics/Rect;Landroid/graphics/Rect;I)Z

    move-result v2

    if-eqz v2, :cond_9

    .line 330
    invoke-virtual {p0, p1, p2, p3, p4}, Landroid/view/FocusFinder;->beamBeats(ILandroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Rect;)Z

    move-result v2

    if-nez v2, :cond_9

    .line 335
    invoke-virtual {p0, p1, p2, p4, p3}, Landroid/view/FocusFinder;->beamBeats(ILandroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Rect;)Z

    move-result v2

    if-eqz v2, :cond_1e

    move v0, v1

    .line 336
    goto :goto_9

    .line 340
    :cond_1e
    invoke-static {p1, p2, p3}, Landroid/view/FocusFinder;->majorAxisDistance(ILandroid/graphics/Rect;Landroid/graphics/Rect;)I

    move-result v2

    invoke-static {p1, p2, p3}, Landroid/view/FocusFinder;->minorAxisDistance(ILandroid/graphics/Rect;Landroid/graphics/Rect;)I

    move-result v3

    invoke-virtual {p0, v2, v3}, Landroid/view/FocusFinder;->getWeightedDistanceFor(II)I

    move-result v2

    invoke-static {p1, p2, p4}, Landroid/view/FocusFinder;->majorAxisDistance(ILandroid/graphics/Rect;Landroid/graphics/Rect;)I

    move-result v3

    invoke-static {p1, p2, p4}, Landroid/view/FocusFinder;->minorAxisDistance(ILandroid/graphics/Rect;Landroid/graphics/Rect;)I

    move-result v4

    invoke-virtual {p0, v3, v4}, Landroid/view/FocusFinder;->getWeightedDistanceFor(II)I

    move-result v3

    if-lt v2, v3, :cond_9

    move v0, v1

    goto :goto_9
.end method

.method isCandidate(Landroid/graphics/Rect;Landroid/graphics/Rect;I)Z
    .registers 8
    .parameter "srcRect"
    .parameter "destRect"
    .parameter "direction"

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 405
    sparse-switch p3, :sswitch_data_5e

    .line 419
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 407
    :sswitch_d
    iget v2, p1, Landroid/graphics/Rect;->right:I

    iget v3, p2, Landroid/graphics/Rect;->right:I

    if-gt v2, v3, :cond_19

    iget v2, p1, Landroid/graphics/Rect;->left:I

    iget v3, p2, Landroid/graphics/Rect;->right:I

    if-lt v2, v3, :cond_20

    :cond_19
    iget v2, p1, Landroid/graphics/Rect;->left:I

    iget v3, p2, Landroid/graphics/Rect;->left:I

    if-le v2, v3, :cond_20

    .line 416
    :cond_1f
    :goto_1f
    return v0

    :cond_20
    move v0, v1

    .line 407
    goto :goto_1f

    .line 410
    :sswitch_22
    iget v2, p1, Landroid/graphics/Rect;->left:I

    iget v3, p2, Landroid/graphics/Rect;->left:I

    if-lt v2, v3, :cond_2e

    iget v2, p1, Landroid/graphics/Rect;->right:I

    iget v3, p2, Landroid/graphics/Rect;->left:I

    if-gt v2, v3, :cond_34

    :cond_2e
    iget v2, p1, Landroid/graphics/Rect;->right:I

    iget v3, p2, Landroid/graphics/Rect;->right:I

    if-lt v2, v3, :cond_1f

    :cond_34
    move v0, v1

    goto :goto_1f

    .line 413
    :sswitch_36
    iget v2, p1, Landroid/graphics/Rect;->bottom:I

    iget v3, p2, Landroid/graphics/Rect;->bottom:I

    if-gt v2, v3, :cond_42

    iget v2, p1, Landroid/graphics/Rect;->top:I

    iget v3, p2, Landroid/graphics/Rect;->bottom:I

    if-lt v2, v3, :cond_48

    :cond_42
    iget v2, p1, Landroid/graphics/Rect;->top:I

    iget v3, p2, Landroid/graphics/Rect;->top:I

    if-gt v2, v3, :cond_1f

    :cond_48
    move v0, v1

    goto :goto_1f

    .line 416
    :sswitch_4a
    iget v2, p1, Landroid/graphics/Rect;->top:I

    iget v3, p2, Landroid/graphics/Rect;->top:I

    if-lt v2, v3, :cond_56

    iget v2, p1, Landroid/graphics/Rect;->bottom:I

    iget v3, p2, Landroid/graphics/Rect;->top:I

    if-gt v2, v3, :cond_5c

    :cond_56
    iget v2, p1, Landroid/graphics/Rect;->bottom:I

    iget v3, p2, Landroid/graphics/Rect;->bottom:I

    if-lt v2, v3, :cond_1f

    :cond_5c
    move v0, v1

    goto :goto_1f

    .line 405
    :sswitch_data_5e
    .sparse-switch
        0x11 -> :sswitch_d
        0x21 -> :sswitch_36
        0x42 -> :sswitch_22
        0x82 -> :sswitch_4a
    .end sparse-switch
.end method

.method isToDirectionOf(ILandroid/graphics/Rect;Landroid/graphics/Rect;)Z
    .registers 8
    .parameter "direction"
    .parameter "src"
    .parameter "dest"

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 448
    sparse-switch p1, :sswitch_data_2e

    .line 458
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 450
    :sswitch_d
    iget v2, p2, Landroid/graphics/Rect;->left:I

    iget v3, p3, Landroid/graphics/Rect;->right:I

    if-lt v2, v3, :cond_14

    .line 456
    :cond_13
    :goto_13
    return v0

    :cond_14
    move v0, v1

    .line 450
    goto :goto_13

    .line 452
    :sswitch_16
    iget v2, p2, Landroid/graphics/Rect;->right:I

    iget v3, p3, Landroid/graphics/Rect;->left:I

    if-le v2, v3, :cond_13

    move v0, v1

    goto :goto_13

    .line 454
    :sswitch_1e
    iget v2, p2, Landroid/graphics/Rect;->top:I

    iget v3, p3, Landroid/graphics/Rect;->bottom:I

    if-ge v2, v3, :cond_13

    move v0, v1

    goto :goto_13

    .line 456
    :sswitch_26
    iget v2, p2, Landroid/graphics/Rect;->bottom:I

    iget v3, p3, Landroid/graphics/Rect;->top:I

    if-le v2, v3, :cond_13

    move v0, v1

    goto :goto_13

    .line 448
    :sswitch_data_2e
    .sparse-switch
        0x11 -> :sswitch_d
        0x21 -> :sswitch_1e
        0x42 -> :sswitch_16
        0x82 -> :sswitch_26
    .end sparse-switch
.end method
