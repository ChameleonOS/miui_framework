.class public Landroid/webkit/SelectionFloatPanel;
.super Landroid/widget/FrameLayout;
.source "SelectionFloatPanel.java"


# static fields
.field private static sHeight:I

.field private static sWidth:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    const/4 v0, 0x0

    .line 15
    sput v0, Landroid/webkit/SelectionFloatPanel;->sHeight:I

    .line 16
    sput v0, Landroid/webkit/SelectionFloatPanel;->sWidth:I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .registers 2
    .parameter "context"

    .prologue
    .line 19
    invoke-direct {p0, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .line 20
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 3
    .parameter "context"
    .parameter "attrs"

    .prologue
    .line 23
    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 24
    return-void
.end method

.method public static getInstance(Landroid/content/Context;Landroid/webkit/WebViewClassic;)Landroid/webkit/SelectionFloatPanel;
    .registers 8
    .parameter "context"
    .parameter "wvclassic"

    .prologue
    const/4 v3, 0x0

    .line 27
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v4

    const v5, 0x6030037

    invoke-virtual {v4, v5, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/webkit/SelectionFloatPanel;

    .line 28
    .local v0, instance:Landroid/webkit/SelectionFloatPanel;
    new-instance v1, Landroid/webkit/SelectionFloatPanel$1;

    invoke-direct {v1, p1, v0}, Landroid/webkit/SelectionFloatPanel$1;-><init>(Landroid/webkit/WebViewClassic;Landroid/webkit/SelectionFloatPanel;)V

    .line 37
    .local v1, l:Landroid/view/View$OnClickListener;
    const v4, 0x60b0015

    invoke-virtual {v0, v4}, Landroid/webkit/SelectionFloatPanel;->findViewById(I)Landroid/view/View;

    move-result-object v2

    .line 38
    .local v2, v:Landroid/view/View;
    if-eqz v2, :cond_2b

    .line 39
    invoke-virtual {v2, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 44
    invoke-virtual {p1}, Landroid/webkit/WebViewClassic;->getWebView()Landroid/webkit/WebView;

    move-result-object v3

    invoke-virtual {v3, v0}, Landroid/webkit/WebView;->addView(Landroid/view/View;)V

    .line 45
    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Landroid/webkit/SelectionFloatPanel;->setVisibility(I)V

    .line 46
    .end local v0           #instance:Landroid/webkit/SelectionFloatPanel;
    :goto_2a
    return-object v0

    .line 41
    .restart local v0       #instance:Landroid/webkit/SelectionFloatPanel;
    :cond_2b
    const-string/jumbo v4, "showFloat"

    const-string/jumbo v5, "no view"

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    move-object v0, v3

    .line 42
    goto :goto_2a
.end method


# virtual methods
.method protected onMeasure(II)V
    .registers 4
    .parameter "widthMeasureSpec"
    .parameter "heightMeasureSpec"

    .prologue
    .line 51
    invoke-super {p0, p1, p2}, Landroid/widget/FrameLayout;->onMeasure(II)V

    .line 52
    invoke-virtual {p0}, Landroid/webkit/SelectionFloatPanel;->getMeasuredHeight()I

    move-result v0

    sput v0, Landroid/webkit/SelectionFloatPanel;->sHeight:I

    .line 53
    invoke-virtual {p0}, Landroid/webkit/SelectionFloatPanel;->getMeasuredWidth()I

    move-result v0

    sput v0, Landroid/webkit/SelectionFloatPanel;->sWidth:I

    .line 54
    return-void
.end method

.method public showAt(II)V
    .registers 4
    .parameter "x"
    .parameter "y"

    .prologue
    .line 65
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Landroid/webkit/SelectionFloatPanel;->setVisibility(I)V

    .line 66
    int-to-float v0, p1

    invoke-virtual {p0, v0}, Landroid/webkit/SelectionFloatPanel;->setX(F)V

    .line 67
    int-to-float v0, p2

    invoke-virtual {p0, v0}, Landroid/webkit/SelectionFloatPanel;->setY(F)V

    .line 68
    invoke-virtual {p0}, Landroid/webkit/SelectionFloatPanel;->requestLayout()V

    .line 69
    return-void
.end method

.method public viewHeight()I
    .registers 2

    .prologue
    .line 57
    sget v0, Landroid/webkit/SelectionFloatPanel;->sHeight:I

    return v0
.end method

.method public viewWidth()I
    .registers 2

    .prologue
    .line 61
    sget v0, Landroid/webkit/SelectionFloatPanel;->sWidth:I

    return v0
.end method
