.class Lmiui/text/util/EmojiSmileys$LazySmileyDrawable;
.super Landroid/graphics/drawable/Drawable;
.source "EmojiSmileys.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/text/util/EmojiSmileys;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "LazySmileyDrawable"
.end annotation


# instance fields
.field private mBitmap:Landroid/graphics/Bitmap;

.field private final mPaint:Landroid/graphics/Paint;

.field private final mResId:I


# direct methods
.method public constructor <init>(I)V
    .registers 5
    .parameter "resId"

    .prologue
    const/16 v2, 0x30

    const/4 v1, 0x0

    .line 74
    invoke-direct {p0}, Landroid/graphics/drawable/Drawable;-><init>()V

    .line 70
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lmiui/text/util/EmojiSmileys$LazySmileyDrawable;->mPaint:Landroid/graphics/Paint;

    .line 75
    iput p1, p0, Lmiui/text/util/EmojiSmileys$LazySmileyDrawable;->mResId:I

    .line 76
    invoke-virtual {p0, v1, v1, v2, v2}, Lmiui/text/util/EmojiSmileys$LazySmileyDrawable;->setBounds(IIII)V

    .line 77
    return-void
.end method


# virtual methods
.method public draw(Landroid/graphics/Canvas;)V
    .registers 6
    .parameter "canvas"

    .prologue
    .line 95
    invoke-virtual {p0}, Lmiui/text/util/EmojiSmileys$LazySmileyDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0}, Lmiui/text/util/EmojiSmileys$LazySmileyDrawable;->getBounds()Landroid/graphics/Rect;

    move-result-object v2

    iget-object v3, p0, Lmiui/text/util/EmojiSmileys$LazySmileyDrawable;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    .line 96
    return-void
.end method

.method public getBitmap()Landroid/graphics/Bitmap;
    .registers 5

    .prologue
    .line 80
    iget-object v2, p0, Lmiui/text/util/EmojiSmileys$LazySmileyDrawable;->mBitmap:Landroid/graphics/Bitmap;

    if-eqz v2, :cond_7

    .line 81
    iget-object v2, p0, Lmiui/text/util/EmojiSmileys$LazySmileyDrawable;->mBitmap:Landroid/graphics/Bitmap;

    .line 89
    :goto_6
    return-object v2

    .line 83
    :cond_7
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v2

    iget v3, p0, Lmiui/text/util/EmojiSmileys$LazySmileyDrawable;->mResId:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 84
    .local v1, d:Landroid/graphics/drawable/Drawable;
    instance-of v2, v1, Landroid/graphics/drawable/BitmapDrawable;

    if-eqz v2, :cond_21

    move-object v0, v1

    .line 85
    check-cast v0, Landroid/graphics/drawable/BitmapDrawable;

    .line 86
    .local v0, bd:Landroid/graphics/drawable/BitmapDrawable;
    invoke-virtual {v0}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v2

    iput-object v2, p0, Lmiui/text/util/EmojiSmileys$LazySmileyDrawable;->mBitmap:Landroid/graphics/Bitmap;

    .line 87
    iget-object v2, p0, Lmiui/text/util/EmojiSmileys$LazySmileyDrawable;->mBitmap:Landroid/graphics/Bitmap;

    goto :goto_6

    .line 89
    .end local v0           #bd:Landroid/graphics/drawable/BitmapDrawable;
    :cond_21
    const/4 v2, 0x0

    goto :goto_6
.end method

.method public getIntrinsicHeight()I
    .registers 2

    .prologue
    .line 121
    const/16 v0, 0x30

    return v0
.end method

.method public getIntrinsicWidth()I
    .registers 2

    .prologue
    .line 116
    const/16 v0, 0x30

    return v0
.end method

.method public getOpacity()I
    .registers 3

    .prologue
    .line 100
    invoke-virtual {p0}, Lmiui/text/util/EmojiSmileys$LazySmileyDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    if-eqz v0, :cond_1a

    invoke-virtual {p0}, Lmiui/text/util/EmojiSmileys$LazySmileyDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->hasAlpha()Z

    move-result v0

    if-nez v0, :cond_1a

    iget-object v0, p0, Lmiui/text/util/EmojiSmileys$LazySmileyDrawable;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {v0}, Landroid/graphics/Paint;->getAlpha()I

    move-result v0

    const/16 v1, 0xff

    if-ge v0, v1, :cond_1c

    :cond_1a
    const/4 v0, -0x3

    :goto_1b
    return v0

    :cond_1c
    const/4 v0, -0x1

    goto :goto_1b
.end method

.method public setAlpha(I)V
    .registers 3
    .parameter "alpha"

    .prologue
    .line 106
    iget-object v0, p0, Lmiui/text/util/EmojiSmileys$LazySmileyDrawable;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setAlpha(I)V

    .line 107
    return-void
.end method

.method public setColorFilter(Landroid/graphics/ColorFilter;)V
    .registers 3
    .parameter "cf"

    .prologue
    .line 111
    iget-object v0, p0, Lmiui/text/util/EmojiSmileys$LazySmileyDrawable;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setColorFilter(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;

    .line 112
    return-void
.end method
