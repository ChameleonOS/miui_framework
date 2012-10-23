.class public Landroid/text/method/ScrollingMovementMethod;
.super Landroid/text/method/BaseMovementMethod;
.source "ScrollingMovementMethod.java"

# interfaces
.implements Landroid/text/method/MovementMethod;


# static fields
.field private static sInstance:Landroid/text/method/ScrollingMovementMethod;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 27
    invoke-direct {p0}, Landroid/text/method/BaseMovementMethod;-><init>()V

    return-void
.end method

.method public static getInstance()Landroid/text/method/MovementMethod;
    .registers 1

    .prologue
    .line 113
    sget-object v0, Landroid/text/method/ScrollingMovementMethod;->sInstance:Landroid/text/method/ScrollingMovementMethod;

    if-nez v0, :cond_b

    .line 114
    new-instance v0, Landroid/text/method/ScrollingMovementMethod;

    invoke-direct {v0}, Landroid/text/method/ScrollingMovementMethod;-><init>()V

    sput-object v0, Landroid/text/method/ScrollingMovementMethod;->sInstance:Landroid/text/method/ScrollingMovementMethod;

    .line 116
    :cond_b
    sget-object v0, Landroid/text/method/ScrollingMovementMethod;->sInstance:Landroid/text/method/ScrollingMovementMethod;

    return-object v0
.end method


# virtual methods
.method protected bottom(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 65
    invoke-virtual {p0, p1, p2}, Landroid/text/method/ScrollingMovementMethod;->scrollBottom(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    return v0
.end method

.method protected down(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 45
    const/4 v0, 0x1

    invoke-virtual {p0, p1, p2, v0}, Landroid/text/method/ScrollingMovementMethod;->scrollDown(Landroid/widget/TextView;Landroid/text/Spannable;I)Z

    move-result v0

    return v0
.end method

.method protected end(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 85
    invoke-virtual {p0, p1, p2}, Landroid/text/method/ScrollingMovementMethod;->bottom(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    return v0
.end method

.method protected home(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 80
    invoke-virtual {p0, p1, p2}, Landroid/text/method/ScrollingMovementMethod;->top(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    return v0
.end method

.method protected left(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 30
    const/4 v0, 0x1

    invoke-virtual {p0, p1, p2, v0}, Landroid/text/method/ScrollingMovementMethod;->scrollLeft(Landroid/widget/TextView;Landroid/text/Spannable;I)Z

    move-result v0

    return v0
.end method

.method protected lineEnd(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 75
    invoke-virtual {p0, p1, p2}, Landroid/text/method/ScrollingMovementMethod;->scrollLineEnd(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    return v0
.end method

.method protected lineStart(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 70
    invoke-virtual {p0, p1, p2}, Landroid/text/method/ScrollingMovementMethod;->scrollLineStart(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    return v0
.end method

.method public onTakeFocus(Landroid/widget/TextView;Landroid/text/Spannable;I)V
    .registers 10
    .parameter "widget"
    .parameter "text"
    .parameter "dir"

    .prologue
    .line 95
    invoke-virtual {p1}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v0

    .line 97
    .local v0, layout:Landroid/text/Layout;
    if-eqz v0, :cond_16

    and-int/lit8 v3, p3, 0x2

    if-eqz v3, :cond_16

    .line 98
    invoke-virtual {p1}, Landroid/widget/TextView;->getScrollX()I

    move-result v3

    const/4 v4, 0x0

    invoke-virtual {v0, v4}, Landroid/text/Layout;->getLineTop(I)I

    move-result v4

    invoke-virtual {p1, v3, v4}, Landroid/widget/TextView;->scrollTo(II)V

    .line 101
    :cond_16
    if-eqz v0, :cond_3f

    and-int/lit8 v3, p3, 0x1

    if-eqz v3, :cond_3f

    .line 102
    invoke-virtual {p1}, Landroid/widget/TextView;->getTotalPaddingTop()I

    move-result v3

    invoke-virtual {p1}, Landroid/widget/TextView;->getTotalPaddingBottom()I

    move-result v4

    add-int v2, v3, v4

    .line 104
    .local v2, padding:I
    invoke-virtual {v0}, Landroid/text/Layout;->getLineCount()I

    move-result v3

    add-int/lit8 v1, v3, -0x1

    .line 106
    .local v1, line:I
    invoke-virtual {p1}, Landroid/widget/TextView;->getScrollX()I

    move-result v3

    add-int/lit8 v4, v1, 0x1

    invoke-virtual {v0, v4}, Landroid/text/Layout;->getLineTop(I)I

    move-result v4

    invoke-virtual {p1}, Landroid/widget/TextView;->getHeight()I

    move-result v5

    sub-int/2addr v5, v2

    sub-int/2addr v4, v5

    invoke-virtual {p1, v3, v4}, Landroid/widget/TextView;->scrollTo(II)V

    .line 110
    .end local v1           #line:I
    .end local v2           #padding:I
    :cond_3f
    return-void
.end method

.method public onTouchEvent(Landroid/widget/TextView;Landroid/text/Spannable;Landroid/view/MotionEvent;)Z
    .registers 5
    .parameter "widget"
    .parameter "buffer"
    .parameter "event"

    .prologue
    .line 90
    invoke-static {p1, p2, p3}, Landroid/text/method/Touch;->onTouchEvent(Landroid/widget/TextView;Landroid/text/Spannable;Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method

.method protected pageDown(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 55
    invoke-virtual {p0, p1, p2}, Landroid/text/method/ScrollingMovementMethod;->scrollPageDown(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    return v0
.end method

.method protected pageUp(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 50
    invoke-virtual {p0, p1, p2}, Landroid/text/method/ScrollingMovementMethod;->scrollPageUp(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    return v0
.end method

.method protected right(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 35
    const/4 v0, 0x1

    invoke-virtual {p0, p1, p2, v0}, Landroid/text/method/ScrollingMovementMethod;->scrollRight(Landroid/widget/TextView;Landroid/text/Spannable;I)Z

    move-result v0

    return v0
.end method

.method protected top(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 60
    invoke-virtual {p0, p1, p2}, Landroid/text/method/ScrollingMovementMethod;->scrollTop(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    return v0
.end method

.method protected up(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 40
    const/4 v0, 0x1

    invoke-virtual {p0, p1, p2, v0}, Landroid/text/method/ScrollingMovementMethod;->scrollUp(Landroid/widget/TextView;Landroid/text/Spannable;I)Z

    move-result v0

    return v0
.end method
