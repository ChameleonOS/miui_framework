.class Landroid/webkit/ViewManager;
.super Ljava/lang/Object;
.source "ViewManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/webkit/ViewManager$ChildView;
    }
.end annotation


# static fields
.field private static final MAX_SURFACE_DIMENSION:I = 0x800


# instance fields
.field private final MAX_SURFACE_AREA:I

.field private final mChildren:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/webkit/ViewManager$ChildView;",
            ">;"
        }
    .end annotation
.end field

.field private mHidden:Z

.field private mReadyToDraw:Z

.field private final mWebView:Landroid/webkit/WebViewClassic;

.field private mZoomInProgress:Z


# direct methods
.method constructor <init>(Landroid/webkit/WebViewClassic;)V
    .registers 8
    .parameter "w"

    .prologue
    .line 102
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 29
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, p0, Landroid/webkit/ViewManager;->mChildren:Ljava/util/ArrayList;

    .line 32
    const/4 v2, 0x0

    iput-boolean v2, p0, Landroid/webkit/ViewManager;->mZoomInProgress:Z

    .line 103
    iput-object p1, p0, Landroid/webkit/ViewManager;->mWebView:Landroid/webkit/WebViewClassic;

    .line 104
    invoke-virtual {p1}, Landroid/webkit/WebViewClassic;->getWebView()Landroid/webkit/WebView;

    move-result-object v2

    invoke-virtual {v2}, Landroid/webkit/WebView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    .line 105
    .local v0, metrics:Landroid/util/DisplayMetrics;
    iget v2, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    iget v3, v0, Landroid/util/DisplayMetrics;->heightPixels:I

    mul-int v1, v2, v3

    .line 110
    .local v1, pixelArea:I
    int-to-double v2, v1

    const-wide/high16 v4, 0x4006

    mul-double/2addr v2, v4

    double-to-int v2, v2

    iput v2, p0, Landroid/webkit/ViewManager;->MAX_SURFACE_AREA:I

    .line 111
    return-void
.end method

.method static synthetic access$000(Landroid/webkit/ViewManager;Landroid/webkit/ViewManager$ChildView;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 27
    invoke-direct {p0, p1}, Landroid/webkit/ViewManager;->requestLayout(Landroid/webkit/ViewManager$ChildView;)V

    return-void
.end method

.method static synthetic access$200(Landroid/webkit/ViewManager;)Landroid/webkit/WebViewClassic;
    .registers 2
    .parameter "x0"

    .prologue
    .line 27
    iget-object v0, p0, Landroid/webkit/ViewManager;->mWebView:Landroid/webkit/WebViewClassic;

    return-object v0
.end method

.method static synthetic access$300(Landroid/webkit/ViewManager;)Ljava/util/ArrayList;
    .registers 2
    .parameter "x0"

    .prologue
    .line 27
    iget-object v0, p0, Landroid/webkit/ViewManager;->mChildren:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$400(Landroid/webkit/ViewManager;)Z
    .registers 2
    .parameter "x0"

    .prologue
    .line 27
    iget-boolean v0, p0, Landroid/webkit/ViewManager;->mReadyToDraw:Z

    return v0
.end method

.method static synthetic access$402(Landroid/webkit/ViewManager;Z)Z
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 27
    iput-boolean p1, p0, Landroid/webkit/ViewManager;->mReadyToDraw:Z

    return p1
.end method

.method private requestLayout(Landroid/webkit/ViewManager$ChildView;)V
    .registers 15
    .parameter "v"

    .prologue
    const/16 v12, 0x800

    .line 122
    iget-object v10, p0, Landroid/webkit/ViewManager;->mWebView:Landroid/webkit/WebViewClassic;

    iget v11, p1, Landroid/webkit/ViewManager$ChildView;->width:I

    invoke-virtual {v10, v11}, Landroid/webkit/WebViewClassic;->contentToViewDimension(I)I

    move-result v7

    .line 123
    .local v7, width:I
    iget-object v10, p0, Landroid/webkit/ViewManager;->mWebView:Landroid/webkit/WebViewClassic;

    iget v11, p1, Landroid/webkit/ViewManager$ChildView;->height:I

    invoke-virtual {v10, v11}, Landroid/webkit/WebViewClassic;->contentToViewDimension(I)I

    move-result v3

    .line 124
    .local v3, height:I
    iget-object v10, p0, Landroid/webkit/ViewManager;->mWebView:Landroid/webkit/WebViewClassic;

    iget v11, p1, Landroid/webkit/ViewManager$ChildView;->x:I

    invoke-virtual {v10, v11}, Landroid/webkit/WebViewClassic;->contentToViewX(I)I

    move-result v8

    .line 125
    .local v8, x:I
    iget-object v10, p0, Landroid/webkit/ViewManager;->mWebView:Landroid/webkit/WebViewClassic;

    iget v11, p1, Landroid/webkit/ViewManager$ChildView;->y:I

    invoke-virtual {v10, v11}, Landroid/webkit/WebViewClassic;->contentToViewY(I)I

    move-result v9

    .line 128
    .local v9, y:I
    iget-object v10, p1, Landroid/webkit/ViewManager$ChildView;->mView:Landroid/view/View;

    invoke-virtual {v10}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v4

    .line 130
    .local v4, layoutParams:Landroid/view/ViewGroup$LayoutParams;
    instance-of v10, v4, Landroid/widget/AbsoluteLayout$LayoutParams;

    if-eqz v10, :cond_51

    move-object v5, v4

    .line 131
    check-cast v5, Landroid/widget/AbsoluteLayout$LayoutParams;

    .line 132
    .local v5, lp:Landroid/widget/AbsoluteLayout$LayoutParams;
    iput v7, v5, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 133
    iput v3, v5, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 134
    iput v8, v5, Landroid/widget/AbsoluteLayout$LayoutParams;->x:I

    .line 135
    iput v9, v5, Landroid/widget/AbsoluteLayout$LayoutParams;->y:I

    .line 141
    :goto_37
    iget-object v10, p1, Landroid/webkit/ViewManager$ChildView;->mView:Landroid/view/View;

    invoke-virtual {v10, v5}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 143
    iget-object v10, p1, Landroid/webkit/ViewManager$ChildView;->mView:Landroid/view/View;

    instance-of v10, v10, Landroid/view/SurfaceView;

    if-eqz v10, :cond_50

    .line 145
    iget-object v6, p1, Landroid/webkit/ViewManager$ChildView;->mView:Landroid/view/View;

    check-cast v6, Landroid/view/SurfaceView;

    .line 147
    .local v6, sView:Landroid/view/SurfaceView;
    invoke-virtual {v6}, Landroid/view/SurfaceView;->isFixedSize()Z

    move-result v10

    if-eqz v10, :cond_57

    iget-boolean v10, p0, Landroid/webkit/ViewManager;->mZoomInProgress:Z

    if-eqz v10, :cond_57

    .line 221
    .end local v6           #sView:Landroid/view/SurfaceView;
    :cond_50
    :goto_50
    return-void

    .line 137
    .end local v5           #lp:Landroid/widget/AbsoluteLayout$LayoutParams;
    :cond_51
    new-instance v5, Landroid/widget/AbsoluteLayout$LayoutParams;

    invoke-direct {v5, v7, v3, v8, v9}, Landroid/widget/AbsoluteLayout$LayoutParams;-><init>(IIII)V

    .restart local v5       #lp:Landroid/widget/AbsoluteLayout$LayoutParams;
    goto :goto_37

    .line 162
    .restart local v6       #sView:Landroid/view/SurfaceView;
    :cond_57
    move v2, v7

    .line 163
    .local v2, fixedW:I
    move v1, v3

    .line 164
    .local v1, fixedH:I
    if-gt v2, v12, :cond_5d

    if-le v1, v12, :cond_6d

    .line 165
    :cond_5d
    iget v10, p1, Landroid/webkit/ViewManager$ChildView;->width:I

    iget v11, p1, Landroid/webkit/ViewManager$ChildView;->height:I

    if-le v10, v11, :cond_9d

    .line 166
    const/16 v2, 0x800

    .line 167
    iget v10, p1, Landroid/webkit/ViewManager$ChildView;->height:I

    mul-int/lit16 v10, v10, 0x800

    iget v11, p1, Landroid/webkit/ViewManager$ChildView;->width:I

    div-int v1, v10, v11

    .line 173
    :cond_6d
    :goto_6d
    mul-int v10, v2, v1

    iget v11, p0, Landroid/webkit/ViewManager;->MAX_SURFACE_AREA:I

    if-le v10, v11, :cond_91

    .line 174
    iget v10, p0, Landroid/webkit/ViewManager;->MAX_SURFACE_AREA:I

    int-to-float v0, v10

    .line 175
    .local v0, area:F
    iget v10, p1, Landroid/webkit/ViewManager$ChildView;->width:I

    iget v11, p1, Landroid/webkit/ViewManager$ChildView;->height:I

    if-le v10, v11, :cond_a8

    .line 176
    iget v10, p1, Landroid/webkit/ViewManager$ChildView;->width:I

    int-to-float v10, v10

    mul-float/2addr v10, v0

    iget v11, p1, Landroid/webkit/ViewManager$ChildView;->height:I

    int-to-float v11, v11

    div-float/2addr v10, v11

    float-to-double v10, v10

    invoke-static {v10, v11}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v10

    double-to-int v2, v10

    .line 177
    iget v10, p1, Landroid/webkit/ViewManager$ChildView;->height:I

    mul-int/2addr v10, v2

    iget v11, p1, Landroid/webkit/ViewManager$ChildView;->width:I

    div-int v1, v10, v11

    .line 184
    .end local v0           #area:F
    :cond_91
    :goto_91
    if-ne v2, v7, :cond_95

    if-eq v1, v3, :cond_be

    .line 187
    :cond_95
    invoke-virtual {v6}, Landroid/view/SurfaceView;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v10

    invoke-interface {v10, v2, v1}, Landroid/view/SurfaceHolder;->setFixedSize(II)V

    goto :goto_50

    .line 169
    :cond_9d
    const/16 v1, 0x800

    .line 170
    iget v10, p1, Landroid/webkit/ViewManager$ChildView;->width:I

    mul-int/lit16 v10, v10, 0x800

    iget v11, p1, Landroid/webkit/ViewManager$ChildView;->height:I

    div-int v2, v10, v11

    goto :goto_6d

    .line 179
    .restart local v0       #area:F
    :cond_a8
    iget v10, p1, Landroid/webkit/ViewManager$ChildView;->height:I

    int-to-float v10, v10

    mul-float/2addr v10, v0

    iget v11, p1, Landroid/webkit/ViewManager$ChildView;->width:I

    int-to-float v11, v11

    div-float/2addr v10, v11

    float-to-double v10, v10

    invoke-static {v10, v11}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v10

    double-to-int v1, v10

    .line 180
    iget v10, p1, Landroid/webkit/ViewManager$ChildView;->width:I

    mul-int/2addr v10, v1

    iget v11, p1, Landroid/webkit/ViewManager$ChildView;->height:I

    div-int v2, v10, v11

    goto :goto_91

    .line 188
    .end local v0           #area:F
    :cond_be
    invoke-virtual {v6}, Landroid/view/SurfaceView;->isFixedSize()Z

    move-result v10

    if-nez v10, :cond_d9

    iget-boolean v10, p0, Landroid/webkit/ViewManager;->mZoomInProgress:Z

    if-eqz v10, :cond_d9

    .line 191
    invoke-virtual {v6}, Landroid/view/SurfaceView;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v10

    invoke-virtual {v6}, Landroid/view/SurfaceView;->getWidth()I

    move-result v11

    invoke-virtual {v6}, Landroid/view/SurfaceView;->getHeight()I

    move-result v12

    invoke-interface {v10, v11, v12}, Landroid/view/SurfaceHolder;->setFixedSize(II)V

    goto/16 :goto_50

    .line 193
    :cond_d9
    invoke-virtual {v6}, Landroid/view/SurfaceView;->isFixedSize()Z

    move-result v10

    if-eqz v10, :cond_50

    iget-boolean v10, p0, Landroid/webkit/ViewManager;->mZoomInProgress:Z

    if-nez v10, :cond_50

    .line 205
    invoke-virtual {v6}, Landroid/view/SurfaceView;->getVisibility()I

    move-result v10

    if-nez v10, :cond_102

    .line 206
    const/4 v10, 0x4

    invoke-virtual {v6, v10}, Landroid/view/SurfaceView;->setVisibility(I)V

    .line 207
    invoke-virtual {v6}, Landroid/view/SurfaceView;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v10

    invoke-interface {v10}, Landroid/view/SurfaceHolder;->setSizeFromLayout()V

    .line 211
    iget-object v10, p0, Landroid/webkit/ViewManager;->mWebView:Landroid/webkit/WebViewClassic;

    iget-object v10, v10, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    new-instance v11, Landroid/webkit/ViewManager$1;

    invoke-direct {v11, p0, v6}, Landroid/webkit/ViewManager$1;-><init>(Landroid/webkit/ViewManager;Landroid/view/SurfaceView;)V

    invoke-virtual {v10, v11}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto/16 :goto_50

    .line 217
    :cond_102
    invoke-virtual {v6}, Landroid/view/SurfaceView;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v10

    invoke-interface {v10}, Landroid/view/SurfaceHolder;->setSizeFromLayout()V

    goto/16 :goto_50
.end method


# virtual methods
.method createView()Landroid/webkit/ViewManager$ChildView;
    .registers 2

    .prologue
    .line 114
    new-instance v0, Landroid/webkit/ViewManager$ChildView;

    invoke-direct {v0, p0}, Landroid/webkit/ViewManager$ChildView;-><init>(Landroid/webkit/ViewManager;)V

    return-object v0
.end method

.method endZoom()V
    .registers 4

    .prologue
    .line 231
    const/4 v2, 0x0

    iput-boolean v2, p0, Landroid/webkit/ViewManager;->mZoomInProgress:Z

    .line 232
    iget-object v2, p0, Landroid/webkit/ViewManager;->mChildren:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :goto_9
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_19

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/webkit/ViewManager$ChildView;

    .line 233
    .local v1, v:Landroid/webkit/ViewManager$ChildView;
    invoke-direct {p0, v1}, Landroid/webkit/ViewManager;->requestLayout(Landroid/webkit/ViewManager$ChildView;)V

    goto :goto_9

    .line 235
    .end local v1           #v:Landroid/webkit/ViewManager$ChildView;
    :cond_19
    return-void
.end method

.method hideAll()V
    .registers 5

    .prologue
    .line 244
    iget-boolean v2, p0, Landroid/webkit/ViewManager;->mHidden:Z

    if-eqz v2, :cond_5

    .line 251
    :goto_4
    return-void

    .line 247
    :cond_5
    iget-object v2, p0, Landroid/webkit/ViewManager;->mChildren:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :goto_b
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1f

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/webkit/ViewManager$ChildView;

    .line 248
    .local v1, v:Landroid/webkit/ViewManager$ChildView;
    iget-object v2, v1, Landroid/webkit/ViewManager$ChildView;->mView:Landroid/view/View;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    goto :goto_b

    .line 250
    .end local v1           #v:Landroid/webkit/ViewManager$ChildView;
    :cond_1f
    const/4 v2, 0x1

    iput-boolean v2, p0, Landroid/webkit/ViewManager;->mHidden:Z

    goto :goto_4
.end method

.method hitTest(II)Landroid/webkit/ViewManager$ChildView;
    .registers 8
    .parameter "contentX"
    .parameter "contentY"

    .prologue
    const/4 v2, 0x0

    .line 283
    iget-boolean v3, p0, Landroid/webkit/ViewManager;->mHidden:Z

    if-eqz v3, :cond_7

    move-object v1, v2

    .line 294
    :goto_6
    return-object v1

    .line 286
    :cond_7
    iget-object v3, p0, Landroid/webkit/ViewManager;->mChildren:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :cond_d
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_38

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/webkit/ViewManager$ChildView;

    .line 287
    .local v1, v:Landroid/webkit/ViewManager$ChildView;
    iget-object v3, v1, Landroid/webkit/ViewManager$ChildView;->mView:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getVisibility()I

    move-result v3

    if-nez v3, :cond_d

    .line 288
    iget v3, v1, Landroid/webkit/ViewManager$ChildView;->x:I

    if-lt p1, v3, :cond_d

    iget v3, v1, Landroid/webkit/ViewManager$ChildView;->x:I

    iget v4, v1, Landroid/webkit/ViewManager$ChildView;->width:I

    add-int/2addr v3, v4

    if-ge p1, v3, :cond_d

    iget v3, v1, Landroid/webkit/ViewManager$ChildView;->y:I

    if-lt p2, v3, :cond_d

    iget v3, v1, Landroid/webkit/ViewManager$ChildView;->y:I

    iget v4, v1, Landroid/webkit/ViewManager$ChildView;->height:I

    add-int/2addr v3, v4

    if-ge p2, v3, :cond_d

    goto :goto_6

    .end local v1           #v:Landroid/webkit/ViewManager$ChildView;
    :cond_38
    move-object v1, v2

    .line 294
    goto :goto_6
.end method

.method postReadyToDrawAll()V
    .registers 3

    .prologue
    .line 272
    iget-object v0, p0, Landroid/webkit/ViewManager;->mWebView:Landroid/webkit/WebViewClassic;

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    new-instance v1, Landroid/webkit/ViewManager$3;

    invoke-direct {v1, p0}, Landroid/webkit/ViewManager$3;-><init>(Landroid/webkit/ViewManager;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 280
    return-void
.end method

.method postResetStateAll()V
    .registers 3

    .prologue
    .line 264
    iget-object v0, p0, Landroid/webkit/ViewManager;->mWebView:Landroid/webkit/WebViewClassic;

    iget-object v0, v0, Landroid/webkit/WebViewClassic;->mPrivateHandler:Landroid/os/Handler;

    new-instance v1, Landroid/webkit/ViewManager$2;

    invoke-direct {v1, p0}, Landroid/webkit/ViewManager$2;-><init>(Landroid/webkit/ViewManager;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 269
    return-void
.end method

.method scaleAll()V
    .registers 4

    .prologue
    .line 238
    iget-object v2, p0, Landroid/webkit/ViewManager;->mChildren:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :goto_6
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_16

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/webkit/ViewManager$ChildView;

    .line 239
    .local v1, v:Landroid/webkit/ViewManager$ChildView;
    invoke-direct {p0, v1}, Landroid/webkit/ViewManager;->requestLayout(Landroid/webkit/ViewManager$ChildView;)V

    goto :goto_6

    .line 241
    .end local v1           #v:Landroid/webkit/ViewManager$ChildView;
    :cond_16
    return-void
.end method

.method showAll()V
    .registers 5

    .prologue
    const/4 v3, 0x0

    .line 254
    iget-boolean v2, p0, Landroid/webkit/ViewManager;->mHidden:Z

    if-nez v2, :cond_6

    .line 261
    :goto_5
    return-void

    .line 257
    :cond_6
    iget-object v2, p0, Landroid/webkit/ViewManager;->mChildren:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :goto_c
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1e

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/webkit/ViewManager$ChildView;

    .line 258
    .local v1, v:Landroid/webkit/ViewManager$ChildView;
    iget-object v2, v1, Landroid/webkit/ViewManager$ChildView;->mView:Landroid/view/View;

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    goto :goto_c

    .line 260
    .end local v1           #v:Landroid/webkit/ViewManager$ChildView;
    :cond_1e
    iput-boolean v3, p0, Landroid/webkit/ViewManager;->mHidden:Z

    goto :goto_5
.end method

.method startZoom()V
    .registers 4

    .prologue
    .line 224
    const/4 v2, 0x1

    iput-boolean v2, p0, Landroid/webkit/ViewManager;->mZoomInProgress:Z

    .line 225
    iget-object v2, p0, Landroid/webkit/ViewManager;->mChildren:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :goto_9
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_19

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/webkit/ViewManager$ChildView;

    .line 226
    .local v1, v:Landroid/webkit/ViewManager$ChildView;
    invoke-direct {p0, v1}, Landroid/webkit/ViewManager;->requestLayout(Landroid/webkit/ViewManager$ChildView;)V

    goto :goto_9

    .line 228
    .end local v1           #v:Landroid/webkit/ViewManager$ChildView;
    :cond_19
    return-void
.end method
