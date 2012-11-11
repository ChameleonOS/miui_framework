.class public Lmiui/util/ContactPhotoUtils;
.super Ljava/lang/Object;
.source "ContactPhotoUtils.java"


# static fields
.field private static final WORD_PHOTO:Ljava/lang/String; = "word_photo"

.field private static sAsiaLangPattern:Ljava/util/regex/Pattern; = null

.field private static sBitmap:Landroid/graphics/Bitmap; = null

.field private static sCanvas:Landroid/graphics/Canvas; = null

.field private static final sPhotoSize:I = 0x60

.field private static sPt:Landroid/graphics/Paint;

.field private static sRect:Landroid/graphics/Rect;

.field private static suffix:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 5

    .prologue
    const/4 v4, 0x1

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/16 v1, 0x60

    sput-object v2, Lmiui/util/ContactPhotoUtils;->sPt:Landroid/graphics/Paint;

    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0, v3, v3, v1, v1}, Landroid/graphics/Rect;-><init>(IIII)V

    sput-object v0, Lmiui/util/ContactPhotoUtils;->sRect:Landroid/graphics/Rect;

    sput-object v2, Lmiui/util/ContactPhotoUtils;->sBitmap:Landroid/graphics/Bitmap;

    sput-object v2, Lmiui/util/ContactPhotoUtils;->sCanvas:Landroid/graphics/Canvas;

    sget-object v0, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v1, v1, v0}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v0

    sput-object v0, Lmiui/util/ContactPhotoUtils;->sBitmap:Landroid/graphics/Bitmap;

    new-instance v0, Landroid/graphics/Canvas;

    sget-object v1, Lmiui/util/ContactPhotoUtils;->sBitmap:Landroid/graphics/Bitmap;

    invoke-direct {v0, v1}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    sput-object v0, Lmiui/util/ContactPhotoUtils;->sCanvas:Landroid/graphics/Canvas;

    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    sput-object v0, Lmiui/util/ContactPhotoUtils;->sPt:Landroid/graphics/Paint;

    sget-object v0, Lmiui/util/ContactPhotoUtils;->sPt:Landroid/graphics/Paint;

    invoke-virtual {v0, v4}, Landroid/graphics/Paint;->setFilterBitmap(Z)V

    sget-object v0, Lmiui/util/ContactPhotoUtils;->sPt:Landroid/graphics/Paint;

    new-instance v1, Landroid/graphics/PorterDuffXfermode;

    sget-object v2, Landroid/graphics/PorterDuff$Mode;->SRC_IN:Landroid/graphics/PorterDuff$Mode;

    invoke-direct {v1, v2}, Landroid/graphics/PorterDuffXfermode;-><init>(Landroid/graphics/PorterDuff$Mode;)V

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setXfermode(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;

    const/16 v0, 0x28

    new-array v0, v0, [Ljava/lang/String;

    const-string/jumbo v1, "\u8001\u5e08"

    aput-object v1, v0, v3

    const-string/jumbo v1, "\u5148\u751f"

    aput-object v1, v0, v4

    const/4 v1, 0x2

    const-string/jumbo v2, "\u8001\u677f"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string/jumbo v2, "\u4ed4"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string/jumbo v2, "\u624b\u673a"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string/jumbo v2, "\u53d4"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string/jumbo v2, "\u963f\u59e8"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string/jumbo v2, "\u5b85"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string/jumbo v2, "\u4f2f"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string/jumbo v2, "\u4f2f\u6bcd"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string/jumbo v2, "\u4f2f\u7236"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string/jumbo v2, "\u54e5"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string/jumbo v2, "\u59d0"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string/jumbo v2, "\u5f1f"

    aput-object v2, v0, v1

    const/16 v1, 0xe

    const-string/jumbo v2, "\u59b9"

    aput-object v2, v0, v1

    const/16 v1, 0xf

    const-string/jumbo v2, "\u8205"

    aput-object v2, v0, v1

    const/16 v1, 0x10

    const-string/jumbo v2, "\u59d1"

    aput-object v2, v0, v1

    const/16 v1, 0x11

    const-string/jumbo v2, "\u7236"

    aput-object v2, v0, v1

    const/16 v1, 0x12

    const-string/jumbo v2, "\u4e3b\u4efb"

    aput-object v2, v0, v1

    const/16 v1, 0x13

    const-string/jumbo v2, "\u7ecf\u7406"

    aput-object v2, v0, v1

    const/16 v1, 0x14

    const-string/jumbo v2, "\u5de5\u4f5c"

    aput-object v2, v0, v1

    const/16 v1, 0x15

    const-string/jumbo v2, "\u540c\u4e8b"

    aput-object v2, v0, v1

    const/16 v1, 0x16

    const-string/jumbo v2, "\u5f8b\u5e08"

    aput-object v2, v0, v1

    const/16 v1, 0x17

    const-string/jumbo v2, "\u53f8\u673a"

    aput-object v2, v0, v1

    const/16 v1, 0x18

    const-string/jumbo v2, "\u5e08\u5085"

    aput-object v2, v0, v1

    const/16 v1, 0x19

    const-string/jumbo v2, "\u5e08\u7236"

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    const-string/jumbo v2, "\u7237"

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    const-string/jumbo v2, "\u5976"

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    const-string/jumbo v2, "\u4e2d\u4ecb"

    aput-object v2, v0, v1

    const/16 v1, 0x1d

    const-string/jumbo v2, "\u8463"

    aput-object v2, v0, v1

    const/16 v1, 0x1e

    const-string/jumbo v2, "\u603b"

    aput-object v2, v0, v1

    const/16 v1, 0x1f

    const-string/jumbo v2, "\u592a\u592a"

    aput-object v2, v0, v1

    const/16 v1, 0x20

    const-string/jumbo v2, "\u4fdd\u59c6"

    aput-object v2, v0, v1

    const/16 v1, 0x21

    const-string/jumbo v2, "\u67d0"

    aput-object v2, v0, v1

    const/16 v1, 0x22

    const-string/jumbo v2, "\u79d8\u4e66"

    aput-object v2, v0, v1

    const/16 v1, 0x23

    const-string/jumbo v2, "\u5904\u957f"

    aput-object v2, v0, v1

    const/16 v1, 0x24

    const-string/jumbo v2, "\u5c40\u957f"

    aput-object v2, v0, v1

    const/16 v1, 0x25

    const-string/jumbo v2, "\u73ed\u957f"

    aput-object v2, v0, v1

    const/16 v1, 0x26

    const-string/jumbo v2, "\u5144"

    aput-object v2, v0, v1

    const/16 v1, 0x27

    const-string/jumbo v2, "\u52a9\u7406"

    aput-object v2, v0, v1

    sput-object v0, Lmiui/util/ContactPhotoUtils;->suffix:[Ljava/lang/String;

    const-string v0, "[\u4e00-\u9fa5]"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lmiui/util/ContactPhotoUtils;->sAsiaLangPattern:Ljava/util/regex/Pattern;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static createNameBitmap(Landroid/content/Context;Ljava/lang/String;II)Landroid/graphics/Bitmap;
    .registers 16
    .parameter "context"
    .parameter "name"
    .parameter "drawableId"
    .parameter "color"

    .prologue
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-eqz v9, :cond_8

    const/4 v0, 0x0

    :goto_7
    return-object v0

    :cond_8
    const/4 v8, 0x0

    .local v8, word:Ljava/lang/String;
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v9

    const/4 v10, 0x1

    if-le v9, v10, :cond_1c

    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Lmiui/util/ContactPhotoUtils;->getWordFromName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    :goto_18
    if-nez v8, :cond_1e

    const/4 v0, 0x0

    goto :goto_7

    :cond_1c
    move-object v8, p1

    goto :goto_18

    :cond_1e
    invoke-virtual {v8}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-eqz v9, :cond_2a

    const/4 v0, 0x0

    goto :goto_7

    :cond_2a
    const/16 v9, 0x60

    const/16 v10, 0x60

    sget-object v11, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v9, v10, v11}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v0

    .local v0, bmp:Landroid/graphics/Bitmap;
    new-instance v1, Landroid/graphics/Canvas;

    invoke-direct {v1, v0}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .local v1, canvas:Landroid/graphics/Canvas;
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    invoke-virtual {v9, p2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    .local v2, drawable:Landroid/graphics/drawable/Drawable;
    sget-object v9, Lmiui/util/ContactPhotoUtils;->sRect:Landroid/graphics/Rect;

    invoke-virtual {v2, v9}, Landroid/graphics/drawable/Drawable;->setBounds(Landroid/graphics/Rect;)V

    invoke-virtual {v2, v1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    new-instance v6, Landroid/graphics/Paint;

    invoke-direct {v6}, Landroid/graphics/Paint;-><init>()V

    .local v6, paint:Landroid/graphics/Paint;
    const/4 v9, 0x1

    invoke-virtual {v6, v9}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    invoke-virtual {v6, p3}, Landroid/graphics/Paint;->setColor(I)V

    invoke-static {p1}, Lmiui/util/ContactPhotoUtils;->isChinese(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_69

    const v9, 0x42accccc

    invoke-virtual {v6, v9}, Landroid/graphics/Paint;->setTextSize(F)V

    const/high16 v9, 0x4080

    const/high16 v10, 0x4298

    invoke-virtual {v1, v8, v9, v10, v6}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto :goto_7

    :cond_69
    const-string v9, " |\\.|-|,|\\(|\\)|\uff08|\uff09|\u2014"

    invoke-virtual {v8, v9}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    .local v5, nameStrs:[Ljava/lang/String;
    if-nez v5, :cond_76

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    const/4 v0, 0x0

    goto :goto_7

    :cond_76
    const/4 v3, 0x0

    .local v3, first:Ljava/lang/String;
    const/4 v7, 0x0

    .local v7, second:Ljava/lang/String;
    const/4 v4, 0x0

    .local v4, i:I
    :goto_79
    array-length v9, v5

    if-ge v4, v9, :cond_9c

    aget-object v9, v5, v4

    invoke-virtual {v9}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_90

    if-nez v3, :cond_93

    aget-object v9, v5, v4

    invoke-virtual {v9}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    :cond_90
    :goto_90
    add-int/lit8 v4, v4, 0x1

    goto :goto_79

    :cond_93
    if-nez v7, :cond_9c

    aget-object v9, v5, v4

    invoke-virtual {v9}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v7

    goto :goto_90

    :cond_9c
    if-nez v3, :cond_a4

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    const/4 v0, 0x0

    goto/16 :goto_7

    :cond_a4
    if-nez v7, :cond_be

    const/16 v9, 0x60

    const/16 v10, 0x60

    invoke-static {v9, v10}, Landroid/util/MathUtils;->min(II)F

    move-result v9

    const v10, 0x3f666666

    mul-float/2addr v9, v10

    invoke-virtual {v6, v9}, Landroid/graphics/Paint;->setTextSize(F)V

    const/high16 v9, 0x4080

    const/high16 v10, 0x4298

    invoke-virtual {v1, v3, v9, v10, v6}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto/16 :goto_7

    :cond_be
    const/16 v9, 0x60

    const/16 v10, 0x60

    invoke-static {v9, v10}, Landroid/util/MathUtils;->min(II)F

    move-result v9

    const v10, 0x3ecccccd

    mul-float/2addr v9, v10

    invoke-virtual {v6, v9}, Landroid/graphics/Paint;->setTextSize(F)V

    const/high16 v9, 0x4080

    const/high16 v10, 0x422c

    invoke-virtual {v1, v3, v9, v10, v6}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    const/high16 v9, 0x41e0

    const/high16 v10, 0x42ac

    invoke-virtual {v1, v7, v9, v10, v6}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto/16 :goto_7
.end method

.method public static createNameBitmap(Landroid/content/Context;Ljava/lang/String;IIIII)Landroid/graphics/Bitmap;
    .registers 9
    .parameter "context"
    .parameter "name"
    .parameter "drawableId"
    .parameter "color"
    .parameter "bgDrawableId"
    .parameter "maskDrawableId"
    .parameter "fgDrawableId"

    .prologue
    invoke-static {p0, p1, p2, p3}, Lmiui/util/ContactPhotoUtils;->createNameBitmap(Landroid/content/Context;Ljava/lang/String;II)Landroid/graphics/Bitmap;

    move-result-object v0

    .local v0, bitmap:Landroid/graphics/Bitmap;
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-static {v1, v0, p4, p5, p6}, Lmiui/util/ContactPhotoUtils;->createPhoto(Landroid/content/res/Resources;Landroid/graphics/Bitmap;III)Landroid/graphics/Bitmap;

    move-result-object v1

    return-object v1
.end method

.method public static declared-synchronized createPhoto(Landroid/content/res/Resources;Landroid/graphics/Bitmap;III)Landroid/graphics/Bitmap;
    .registers 14
    .parameter "res"
    .parameter "src"
    .parameter "bgDrawableId"
    .parameter "maskDrawableId"
    .parameter "fgDrawableId"

    .prologue
    const/4 v3, 0x0

    const-class v5, Lmiui/util/ContactPhotoUtils;

    monitor-enter v5

    if-nez p1, :cond_8

    :goto_6
    monitor-exit v5

    return-object v3

    :cond_8
    const/16 v4, 0x60

    const/16 v6, 0x60

    :try_start_c
    sget-object v7, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v4, v6, v7}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v3

    .local v3, photo:Landroid/graphics/Bitmap;
    invoke-virtual {p0, p2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .local v0, bgDrawable:Landroid/graphics/drawable/Drawable;
    sget-object v4, Lmiui/util/ContactPhotoUtils;->sRect:Landroid/graphics/Rect;

    invoke-virtual {v0, v4}, Landroid/graphics/drawable/Drawable;->setBounds(Landroid/graphics/Rect;)V

    invoke-virtual {p0, p4}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    .local v2, fgDrawable:Landroid/graphics/drawable/Drawable;
    sget-object v4, Lmiui/util/ContactPhotoUtils;->sRect:Landroid/graphics/Rect;

    invoke-virtual {v2, v4}, Landroid/graphics/drawable/Drawable;->setBounds(Landroid/graphics/Rect;)V

    new-instance v1, Landroid/graphics/Canvas;

    invoke-direct {v1, v3}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .local v1, canvas:Landroid/graphics/Canvas;
    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    invoke-static {p0, p1, p3}, Lmiui/util/ContactPhotoUtils;->cutBitmap(Landroid/content/res/Resources;Landroid/graphics/Bitmap;I)V

    sget-object v4, Lmiui/util/ContactPhotoUtils;->sBitmap:Landroid/graphics/Bitmap;

    sget-object v6, Lmiui/util/ContactPhotoUtils;->sRect:Landroid/graphics/Rect;

    sget-object v7, Lmiui/util/ContactPhotoUtils;->sRect:Landroid/graphics/Rect;

    const/4 v8, 0x0

    invoke-virtual {v1, v4, v6, v7, v8}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    invoke-virtual {v2, v1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->recycle()V
    :try_end_3f
    .catchall {:try_start_c .. :try_end_3f} :catchall_40

    goto :goto_6

    .end local v0           #bgDrawable:Landroid/graphics/drawable/Drawable;
    .end local v1           #canvas:Landroid/graphics/Canvas;
    .end local v2           #fgDrawable:Landroid/graphics/drawable/Drawable;
    .end local v3           #photo:Landroid/graphics/Bitmap;
    :catchall_40
    move-exception v4

    monitor-exit v5

    throw v4
.end method

.method private static cutBitmap(Landroid/content/res/Resources;Landroid/graphics/Bitmap;I)V
    .registers 12
    .parameter "res"
    .parameter "src"
    .parameter "maskDrawableId"

    .prologue
    sget-object v5, Lmiui/util/ContactPhotoUtils;->sCanvas:Landroid/graphics/Canvas;

    const/4 v6, 0x0

    sget-object v7, Landroid/graphics/PorterDuff$Mode;->CLEAR:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {v5, v6, v7}, Landroid/graphics/Canvas;->drawColor(ILandroid/graphics/PorterDuff$Mode;)V

    invoke-virtual {p0, p2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .local v0, dst:Landroid/graphics/drawable/Drawable;
    sget-object v5, Lmiui/util/ContactPhotoUtils;->sRect:Landroid/graphics/Rect;

    invoke-virtual {v0, v5}, Landroid/graphics/drawable/Drawable;->setBounds(Landroid/graphics/Rect;)V

    sget-object v5, Lmiui/util/ContactPhotoUtils;->sCanvas:Landroid/graphics/Canvas;

    invoke-virtual {v0, v5}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v4

    .local v4, width:I
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v1

    .local v1, height:I
    const/4 v2, 0x0

    .local v2, left:I
    const/4 v3, 0x0

    .local v3, top:I
    if-le v4, v1, :cond_3a

    sub-int v5, v4, v1

    div-int/lit8 v2, v5, 0x2

    move v4, v1

    :cond_27
    :goto_27
    sget-object v5, Lmiui/util/ContactPhotoUtils;->sCanvas:Landroid/graphics/Canvas;

    new-instance v6, Landroid/graphics/Rect;

    add-int v7, v2, v4

    add-int v8, v3, v1

    invoke-direct {v6, v2, v3, v7, v8}, Landroid/graphics/Rect;-><init>(IIII)V

    sget-object v7, Lmiui/util/ContactPhotoUtils;->sRect:Landroid/graphics/Rect;

    sget-object v8, Lmiui/util/ContactPhotoUtils;->sPt:Landroid/graphics/Paint;

    invoke-virtual {v5, p1, v6, v7, v8}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    return-void

    :cond_3a
    if-ge v4, v1, :cond_27

    sub-int v5, v1, v4

    div-int/lit8 v3, v5, 0x2

    move v1, v4

    goto :goto_27
.end method

.method private static getWordFromName(Ljava/lang/String;)Ljava/lang/String;
    .registers 4
    .parameter "name"

    .prologue
    invoke-static {p0}, Lmiui/util/ContactPhotoUtils;->isChinese(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_11

    invoke-static {p0}, Lmiui/util/ContactPhotoUtils;->removeSuffix(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .local v1, word:Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_12

    const/4 p0, 0x0

    .end local p0
    .local v0, length:I
    :cond_11
    :goto_11
    return-object p0

    .end local v0           #length:I
    .restart local p0
    :cond_12
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v0

    .restart local v0       #length:I
    add-int/lit8 v2, v0, -0x1

    invoke-virtual {v1, v2, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p0

    goto :goto_11
.end method

.method private static isChinese(Ljava/lang/String;)Z
    .registers 2
    .parameter "name"

    .prologue
    sget-object v0, Lmiui/util/ContactPhotoUtils;->sAsiaLangPattern:Ljava/util/regex/Pattern;

    invoke-virtual {v0, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/regex/Matcher;->find()Z

    move-result v0

    return v0
.end method

.method private static removeSuffix(Ljava/lang/String;)Ljava/lang/String;
    .registers 8
    .parameter "name"

    .prologue
    const/4 v6, 0x0

    move-object v3, p0

    .local v3, result:Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_a

    const/4 v4, 0x0

    :goto_9
    return-object v4

    :cond_a
    const/4 v1, 0x0

    .local v1, found:Z
    :cond_b
    const/4 v1, 0x0

    const/4 v2, 0x0

    .local v2, i:I
    :goto_d
    sget-object v4, Lmiui/util/ContactPhotoUtils;->suffix:[Ljava/lang/String;

    array-length v4, v4

    if-ge v2, v4, :cond_34

    sget-object v4, Lmiui/util/ContactPhotoUtils;->suffix:[Ljava/lang/String;

    aget-object v4, v4, v2

    invoke-virtual {v3, v4}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_54

    const/4 v1, 0x1

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v4

    sget-object v5, Lmiui/util/ContactPhotoUtils;->suffix:[Ljava/lang/String;

    aget-object v5, v5, v2

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v5

    sub-int/2addr v4, v5

    invoke-virtual {v3, v6, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    :cond_2e
    :goto_2e
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_9c

    :cond_34
    if-eqz v1, :cond_3c

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_b

    :cond_3c
    if-eqz v3, :cond_42

    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    :cond_42
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_52

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    invoke-virtual {p0, v4}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    :cond_52
    move-object v4, v3

    goto :goto_9

    :cond_54
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    invoke-virtual {v3, v4}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .local v0, c:C
    const/16 v4, 0x41

    if-lt v0, v4, :cond_66

    const/16 v4, 0x5a

    if-le v0, v4, :cond_90

    :cond_66
    const/16 v4, 0x61

    if-lt v0, v4, :cond_6e

    const/16 v4, 0x7a

    if-le v0, v4, :cond_90

    :cond_6e
    const/16 v4, 0x2c

    if-eq v0, v4, :cond_90

    const/16 v4, 0x2e

    if-eq v0, v4, :cond_90

    const/16 v4, 0x2d

    if-eq v0, v4, :cond_90

    const/16 v4, 0x28

    if-eq v0, v4, :cond_90

    const/16 v4, 0x29

    if-eq v0, v4, :cond_90

    const v4, 0xff08

    if-eq v0, v4, :cond_90

    const v4, 0xff09

    if-eq v0, v4, :cond_90

    const/16 v4, 0x2014

    if-ne v0, v4, :cond_2e

    :cond_90
    const/4 v1, 0x1

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    invoke-virtual {v3, v6, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    goto :goto_2e

    .end local v0           #c:C
    :cond_9c
    add-int/lit8 v2, v2, 0x1

    goto/16 :goto_d
.end method

.method public static setUseWordPhoto(Landroid/content/Context;Z)V
    .registers 5
    .parameter "context"
    .parameter "useWordPhoto"

    .prologue
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const-string/jumbo v2, "word_photo"

    if-eqz p1, :cond_e

    const/4 v0, 0x1

    :goto_a
    invoke-static {v1, v2, v0}, Landroid/provider/Settings$System;->putInt(Landroid/content/ContentResolver;Ljava/lang/String;I)Z

    return-void

    :cond_e
    const/4 v0, 0x0

    goto :goto_a
.end method

.method public static useWordPhoto(Landroid/content/Context;)Z
    .registers 5
    .parameter "context"

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    const-string/jumbo v3, "word_photo"

    invoke-static {v2, v3, v1}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v2

    if-ne v2, v0, :cond_10

    :goto_f
    return v0

    :cond_10
    move v0, v1

    goto :goto_f
.end method
