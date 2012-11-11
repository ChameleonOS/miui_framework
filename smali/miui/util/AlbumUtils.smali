.class public Lmiui/util/AlbumUtils;
.super Ljava/lang/Object;
.source "AlbumUtils.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static clipRoundCornerBitmap(Landroid/graphics/Bitmap;FI)Landroid/graphics/Bitmap;
    .registers 12
    .parameter "bitmap"
    .parameter "radius"
    .parameter "color"

    .prologue
    const/4 v8, 0x0

    if-nez p0, :cond_5

    const/4 v1, 0x0

    :goto_4
    return-object v1

    :cond_5
    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v5

    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v6

    sget-object v7, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v5, v6, v7}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v1

    .local v1, output:Landroid/graphics/Bitmap;
    new-instance v0, Landroid/graphics/Canvas;

    invoke-direct {v0, v1}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .local v0, canvas:Landroid/graphics/Canvas;
    new-instance v2, Landroid/graphics/Paint;

    invoke-direct {v2}, Landroid/graphics/Paint;-><init>()V

    .local v2, paint:Landroid/graphics/Paint;
    new-instance v3, Landroid/graphics/Rect;

    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v5

    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v6

    invoke-direct {v3, v8, v8, v5, v6}, Landroid/graphics/Rect;-><init>(IIII)V

    .local v3, rect:Landroid/graphics/Rect;
    new-instance v4, Landroid/graphics/RectF;

    invoke-direct {v4, v3}, Landroid/graphics/RectF;-><init>(Landroid/graphics/Rect;)V

    .local v4, rectF:Landroid/graphics/RectF;
    invoke-virtual {v2, p2}, Landroid/graphics/Paint;->setColor(I)V

    const/4 v5, 0x7

    invoke-virtual {v2, v5}, Landroid/graphics/Paint;->setFlags(I)V

    invoke-virtual {v0, v8, v8, v8, v8}, Landroid/graphics/Canvas;->drawARGB(IIII)V

    invoke-virtual {v0, v4, p1, p1, v2}, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V

    new-instance v5, Landroid/graphics/PorterDuffXfermode;

    sget-object v6, Landroid/graphics/PorterDuff$Mode;->SRC_IN:Landroid/graphics/PorterDuff$Mode;

    invoke-direct {v5, v6}, Landroid/graphics/PorterDuffXfermode;-><init>(Landroid/graphics/PorterDuff$Mode;)V

    invoke-virtual {v2, v5}, Landroid/graphics/Paint;->setXfermode(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;

    invoke-virtual {v0, p0, v3, v3, v2}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    goto :goto_4
.end method

.method public static loadAlbum(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;II)Landroid/graphics/Bitmap;
    .registers 7
    .parameter "context"
    .parameter "uri"
    .parameter "path"
    .parameter "width"
    .parameter "height"

    .prologue
    const/4 v0, 0x0

    .local v0, bm:Landroid/graphics/Bitmap;
    if-eqz p1, :cond_c

    new-instance v1, Lmiui/util/InputStreamLoader;

    invoke-direct {v1, p0, p1}, Lmiui/util/InputStreamLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;)V

    invoke-static {v1, p3, p4}, Lmiui/util/ImageUtils;->getBitmap(Lmiui/util/InputStreamLoader;II)Landroid/graphics/Bitmap;

    move-result-object v0

    :cond_c
    if-nez v0, :cond_19

    if-eqz p2, :cond_19

    new-instance v1, Lmiui/util/InputStreamLoader;

    invoke-direct {v1, p2}, Lmiui/util/InputStreamLoader;-><init>(Ljava/lang/String;)V

    invoke-static {v1, p3, p4}, Lmiui/util/ImageUtils;->getBitmap(Lmiui/util/InputStreamLoader;II)Landroid/graphics/Bitmap;

    move-result-object v0

    :cond_19
    return-object v0
.end method
