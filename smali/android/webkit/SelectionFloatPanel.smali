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

    sput v0, Landroid/webkit/SelectionFloatPanel;->sHeight:I

    sput v0, Landroid/webkit/SelectionFloatPanel;->sWidth:I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .registers 2
    .parameter "context"

    .prologue
    invoke-direct {p0, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 3
    .parameter "context"
    .parameter "attrs"

    .prologue
    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-void
.end method

.method public static getInstance(Landroid/content/Context;Landroid/webkit/WebViewClassic;)Landroid/webkit/SelectionFloatPanel;
    .registers 13
    .parameter "context"
    .parameter "wvclassic"

    .prologue
    const/4 v8, 0x0

    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v9

    const v10, 0x6030037

    invoke-virtual {v9, v10, v8}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/webkit/SelectionFloatPanel;

    .local v0, instance:Landroid/webkit/SelectionFloatPanel;
    new-instance v1, Landroid/webkit/SelectionFloatPanel$1;

    invoke-direct {v1, p1, v0}, Landroid/webkit/SelectionFloatPanel$1;-><init>(Landroid/webkit/WebViewClassic;Landroid/webkit/SelectionFloatPanel;)V

    .local v1, l:Landroid/view/View$OnClickListener;
    const v9, 0x60b0015

    invoke-virtual {v0, v9}, Landroid/webkit/SelectionFloatPanel;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .local v4, vCopy:Landroid/view/View;
    if-eqz v4, :cond_52

    invoke-virtual {v4, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    new-instance v3, Landroid/webkit/SelectionFloatPanel$2;

    invoke-direct {v3, p1, v0}, Landroid/webkit/SelectionFloatPanel$2;-><init>(Landroid/webkit/WebViewClassic;Landroid/webkit/SelectionFloatPanel;)V

    .local v3, selectAllListener:Landroid/view/View$OnClickListener;
    const v9, 0x60b001a

    invoke-virtual {v0, v9}, Landroid/webkit/SelectionFloatPanel;->findViewById(I)Landroid/view/View;

    move-result-object v5

    .local v5, vSelectAll:Landroid/view/View;
    if-eqz v5, :cond_5d

    invoke-virtual {v5, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    new-instance v7, Landroid/webkit/SelectionFloatPanel$3;

    invoke-direct {v7, p1, v0}, Landroid/webkit/SelectionFloatPanel$3;-><init>(Landroid/webkit/WebViewClassic;Landroid/webkit/SelectionFloatPanel;)V

    .local v7, webSearchListener:Landroid/view/View$OnClickListener;
    const v9, 0x60b008a

    invoke-virtual {v0, v9}, Landroid/webkit/SelectionFloatPanel;->findViewById(I)Landroid/view/View;

    move-result-object v6

    .local v6, vWebSearch:Landroid/view/View;
    if-eqz v6, :cond_68

    invoke-virtual {v6, v7}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    invoke-virtual {p1}, Landroid/webkit/WebViewClassic;->getWebView()Landroid/webkit/WebView;

    move-result-object v8

    invoke-virtual {v8}, Landroid/webkit/WebView;->getRootView()Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/view/ViewGroup;

    move-object v2, v8

    check-cast v2, Landroid/view/ViewGroup;

    .local v2, rootView:Landroid/view/ViewGroup;
    invoke-virtual {v2, v0}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .end local v0           #instance:Landroid/webkit/SelectionFloatPanel;
    .end local v2           #rootView:Landroid/view/ViewGroup;
    .end local v3           #selectAllListener:Landroid/view/View$OnClickListener;
    .end local v5           #vSelectAll:Landroid/view/View;
    .end local v6           #vWebSearch:Landroid/view/View;
    .end local v7           #webSearchListener:Landroid/view/View$OnClickListener;
    :goto_51
    return-object v0

    .restart local v0       #instance:Landroid/webkit/SelectionFloatPanel;
    :cond_52
    const-string/jumbo v9, "showFloat"

    const-string/jumbo v10, "no copy view."

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    move-object v0, v8

    goto :goto_51

    .restart local v3       #selectAllListener:Landroid/view/View$OnClickListener;
    .restart local v5       #vSelectAll:Landroid/view/View;
    :cond_5d
    const-string/jumbo v9, "showFloat"

    const-string/jumbo v10, "no selectAll view."

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    move-object v0, v8

    goto :goto_51

    .restart local v6       #vWebSearch:Landroid/view/View;
    .restart local v7       #webSearchListener:Landroid/view/View$OnClickListener;
    :cond_68
    const-string/jumbo v9, "showFloat"

    const-string/jumbo v10, "no webSearch view."

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    move-object v0, v8

    goto :goto_51
.end method


# virtual methods
.method protected onMeasure(II)V
    .registers 4
    .parameter "widthMeasureSpec"
    .parameter "heightMeasureSpec"

    .prologue
    invoke-super {p0, p1, p2}, Landroid/widget/FrameLayout;->onMeasure(II)V

    invoke-virtual {p0}, Landroid/webkit/SelectionFloatPanel;->getMeasuredHeight()I

    move-result v0

    sput v0, Landroid/webkit/SelectionFloatPanel;->sHeight:I

    invoke-virtual {p0}, Landroid/webkit/SelectionFloatPanel;->getMeasuredWidth()I

    move-result v0

    sput v0, Landroid/webkit/SelectionFloatPanel;->sWidth:I

    return-void
.end method

.method public showAt(II)V
    .registers 4
    .parameter "x"
    .parameter "y"

    .prologue
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Landroid/webkit/SelectionFloatPanel;->setVisibility(I)V

    int-to-float v0, p1

    invoke-virtual {p0, v0}, Landroid/webkit/SelectionFloatPanel;->setX(F)V

    int-to-float v0, p2

    invoke-virtual {p0, v0}, Landroid/webkit/SelectionFloatPanel;->setY(F)V

    invoke-virtual {p0}, Landroid/webkit/SelectionFloatPanel;->requestLayout()V

    return-void
.end method

.method public viewHeight()I
    .registers 2

    .prologue
    sget v0, Landroid/webkit/SelectionFloatPanel;->sHeight:I

    return v0
.end method

.method public viewWidth()I
    .registers 2

    .prologue
    sget v0, Landroid/webkit/SelectionFloatPanel;->sWidth:I

    return v0
.end method
