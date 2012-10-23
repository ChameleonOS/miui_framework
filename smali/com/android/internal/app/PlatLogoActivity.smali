.class public Lcom/android/internal/app/PlatLogoActivity;
.super Landroid/app/Activity;
.source "PlatLogoActivity.java"


# instance fields
.field mContent:Landroid/widget/ImageView;

.field mCount:I

.field final mHandler:Landroid/os/Handler;

.field mToast:Landroid/widget/Toast;


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 35
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 39
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/android/internal/app/PlatLogoActivity;->mHandler:Landroid/os/Handler;

    return-void
.end method

.method private makeView()Landroid/view/View;
    .registers 16

    .prologue
    const/high16 v14, 0x4080

    const/high16 v13, 0x4000

    const/4 v12, 0x0

    const/4 v11, 0x1

    const/4 v10, -0x2

    .line 42
    new-instance v2, Landroid/util/DisplayMetrics;

    invoke-direct {v2}, Landroid/util/DisplayMetrics;-><init>()V

    .line 43
    .local v2, metrics:Landroid/util/DisplayMetrics;
    invoke-virtual {p0}, Lcom/android/internal/app/PlatLogoActivity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v8

    invoke-interface {v8}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v8

    invoke-virtual {v8, v2}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 45
    new-instance v7, Landroid/widget/LinearLayout;

    invoke-direct {v7, p0}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 46
    .local v7, view:Landroid/widget/LinearLayout;
    invoke-virtual {v7, v11}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 47
    new-instance v8, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v8, v10, v10}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v7, v8}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 52
    const/high16 v8, 0x4100

    iget v9, v2, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v8, v9

    float-to-int v4, v8

    .line 53
    .local v4, p:I
    invoke-virtual {v7, v4, v4, v4, v4}, Landroid/widget/LinearLayout;->setPadding(IIII)V

    .line 55
    const-string/jumbo v8, "sans-serif-light"

    const/4 v9, 0x0

    invoke-static {v8, v9}, Landroid/graphics/Typeface;->create(Ljava/lang/String;I)Landroid/graphics/Typeface;

    move-result-object v0

    .line 56
    .local v0, light:Landroid/graphics/Typeface;
    const-string/jumbo v8, "sans-serif"

    invoke-static {v8, v11}, Landroid/graphics/Typeface;->create(Ljava/lang/String;I)Landroid/graphics/Typeface;

    move-result-object v3

    .line 58
    .local v3, normal:Landroid/graphics/Typeface;
    const/high16 v8, 0x4160

    iget v9, v2, Landroid/util/DisplayMetrics;->density:F

    mul-float v5, v8, v9

    .line 59
    .local v5, size:F
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v1, v10, v10}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 62
    .local v1, lp:Landroid/widget/LinearLayout$LayoutParams;
    iput v11, v1, Landroid/widget/LinearLayout$LayoutParams;->gravity:I

    .line 63
    const/high16 v8, -0x3f80

    iget v9, v2, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v8, v9

    float-to-int v8, v8

    iput v8, v1, Landroid/view/ViewGroup$MarginLayoutParams;->bottomMargin:I

    .line 65
    new-instance v6, Landroid/widget/TextView;

    invoke-direct {v6, p0}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 66
    .local v6, tv:Landroid/widget/TextView;
    if-eqz v0, :cond_5e

    invoke-virtual {v6, v0}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 67
    :cond_5e
    const/high16 v8, 0x3fa0

    mul-float/2addr v8, v5

    invoke-virtual {v6, v8}, Landroid/widget/TextView;->setTextSize(F)V

    .line 68
    const/4 v8, -0x1

    invoke-virtual {v6, v8}, Landroid/widget/TextView;->setTextColor(I)V

    .line 69
    iget v8, v2, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v8, v14

    iget v9, v2, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v9, v13

    const/high16 v10, 0x6600

    invoke-virtual {v6, v8, v12, v9, v10}, Landroid/widget/TextView;->setShadowLayer(FFFI)V

    .line 70
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Android "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    sget-object v9, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 71
    invoke-virtual {v7, v6, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 73
    new-instance v6, Landroid/widget/TextView;

    .end local v6           #tv:Landroid/widget/TextView;
    invoke-direct {v6, p0}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 74
    .restart local v6       #tv:Landroid/widget/TextView;
    if-eqz v3, :cond_98

    invoke-virtual {v6, v3}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 75
    :cond_98
    invoke-virtual {v6, v5}, Landroid/widget/TextView;->setTextSize(F)V

    .line 76
    const/4 v8, -0x1

    invoke-virtual {v6, v8}, Landroid/widget/TextView;->setTextColor(I)V

    .line 77
    iget v8, v2, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v8, v14

    iget v9, v2, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v9, v13

    const/high16 v10, 0x6600

    invoke-virtual {v6, v8, v12, v9, v10}, Landroid/widget/TextView;->setShadowLayer(FFFI)V

    .line 78
    const-string v8, "JELLY BEAN"

    invoke-virtual {v6, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 79
    invoke-virtual {v7, v6, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 81
    return-object v7
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .registers 6
    .parameter "savedInstanceState"

    .prologue
    .line 86
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 88
    const-string v2, ""

    const/4 v3, 0x1

    invoke-static {p0, v2, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    iput-object v2, p0, Lcom/android/internal/app/PlatLogoActivity;->mToast:Landroid/widget/Toast;

    .line 89
    iget-object v2, p0, Lcom/android/internal/app/PlatLogoActivity;->mToast:Landroid/widget/Toast;

    invoke-direct {p0}, Lcom/android/internal/app/PlatLogoActivity;->makeView()Landroid/view/View;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/Toast;->setView(Landroid/view/View;)V

    .line 91
    new-instance v0, Landroid/util/DisplayMetrics;

    invoke-direct {v0}, Landroid/util/DisplayMetrics;-><init>()V

    .line 92
    .local v0, metrics:Landroid/util/DisplayMetrics;
    invoke-virtual {p0}, Lcom/android/internal/app/PlatLogoActivity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v2

    invoke-interface {v2}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 94
    new-instance v2, Landroid/widget/ImageView;

    invoke-direct {v2, p0}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    iput-object v2, p0, Lcom/android/internal/app/PlatLogoActivity;->mContent:Landroid/widget/ImageView;

    .line 95
    iget-object v2, p0, Lcom/android/internal/app/PlatLogoActivity;->mContent:Landroid/widget/ImageView;

    const v3, 0x1080452

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 96
    iget-object v2, p0, Lcom/android/internal/app/PlatLogoActivity;->mContent:Landroid/widget/ImageView;

    sget-object v3, Landroid/widget/ImageView$ScaleType;->CENTER_INSIDE:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 98
    const/high16 v2, 0x4200

    iget v3, v0, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v2, v3

    float-to-int v1, v2

    .line 99
    .local v1, p:I
    iget-object v2, p0, Lcom/android/internal/app/PlatLogoActivity;->mContent:Landroid/widget/ImageView;

    invoke-virtual {v2, v1, v1, v1, v1}, Landroid/widget/ImageView;->setPadding(IIII)V

    .line 101
    iget-object v2, p0, Lcom/android/internal/app/PlatLogoActivity;->mContent:Landroid/widget/ImageView;

    new-instance v3, Lcom/android/internal/app/PlatLogoActivity$1;

    invoke-direct {v3, p0}, Lcom/android/internal/app/PlatLogoActivity$1;-><init>(Lcom/android/internal/app/PlatLogoActivity;)V

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 109
    iget-object v2, p0, Lcom/android/internal/app/PlatLogoActivity;->mContent:Landroid/widget/ImageView;

    new-instance v3, Lcom/android/internal/app/PlatLogoActivity$2;

    invoke-direct {v3, p0}, Lcom/android/internal/app/PlatLogoActivity$2;-><init>(Lcom/android/internal/app/PlatLogoActivity;)V

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 127
    iget-object v2, p0, Lcom/android/internal/app/PlatLogoActivity;->mContent:Landroid/widget/ImageView;

    invoke-virtual {p0, v2}, Lcom/android/internal/app/PlatLogoActivity;->setContentView(Landroid/view/View;)V

    .line 128
    return-void
.end method
