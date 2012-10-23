.class public Lmiui/content/res/IconCustomizer;
.super Ljava/lang/Object;
.source "IconCustomizer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmiui/content/res/IconCustomizer$CustomizedIconsListener;
    }
.end annotation


# static fields
.field private static final sAlphaShift:I = 0x18

.field private static sCache:Ljava/util/HashMap; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/ref/SoftReference",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;>;"
        }
    .end annotation
.end field

.field private static final sCanvas:Landroid/graphics/Canvas; = null

.field private static final sColorShift:I = 0x8

#the value of this static final field might be set in the static constructor
.field public static final sCustomizedIconHeight:I = 0x0

#the value of this static final field might be set in the static constructor
.field public static final sCustomizedIconWidth:I = 0x0

.field private static final sDensities:[I = null

#the value of this static final field might be set in the static constructor
.field private static final sDensity:I = 0x0

.field private static sExcludeAll:Ljava/lang/Boolean; = null

.field private static sExcludes:Ljava/util/Set; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

#the value of this static final field might be set in the static constructor
.field private static final sIconHeight:I = 0x0

.field private static sIconMapping:Ljava/util/Map; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

#the value of this static final field might be set in the static constructor
.field private static final sIconWidth:I = 0x0

.field private static final sOldBounds:Landroid/graphics/Rect; = null

.field private static final sPathPrefix:Ljava/lang/String; = "/data/system/customized_icons/"

.field private static final sRGBMask:I = 0xffffff

.field private static final sSystemResource:Landroid/content/res/Resources;


# direct methods
.method static constructor <clinit>()V
    .registers 5

    .prologue
    const/16 v3, 0x5a

    const/16 v2, 0x48

    const/4 v0, 0x1

    .line 48
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v1

    sput-object v1, Lmiui/content/res/IconCustomizer;->sSystemResource:Landroid/content/res/Resources;

    .line 49
    sget-object v1, Lmiui/content/res/IconCustomizer;->sSystemResource:Landroid/content/res/Resources;

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v1, v1, Landroid/util/DisplayMetrics;->densityDpi:I

    sput v1, Lmiui/content/res/IconCustomizer;->sDensity:I

    .line 50
    sget v1, Lmiui/content/res/IconCustomizer;->sDensity:I

    invoke-static {v1}, Lmiui/util/DisplayUtils;->getBestDensityOrder(I)[I

    move-result-object v1

    sput-object v1, Lmiui/content/res/IconCustomizer;->sDensities:[I

    .line 52
    invoke-static {v2}, Lmiui/content/res/IconCustomizer;->scalePixel(I)I

    move-result v1

    sput v1, Lmiui/content/res/IconCustomizer;->sIconWidth:I

    .line 53
    invoke-static {v2}, Lmiui/content/res/IconCustomizer;->scalePixel(I)I

    move-result v1

    sput v1, Lmiui/content/res/IconCustomizer;->sIconHeight:I

    .line 54
    invoke-static {v3}, Lmiui/content/res/IconCustomizer;->scalePixel(I)I

    move-result v1

    sput v1, Lmiui/content/res/IconCustomizer;->sCustomizedIconWidth:I

    .line 55
    invoke-static {v3}, Lmiui/content/res/IconCustomizer;->scalePixel(I)I

    move-result v1

    sput v1, Lmiui/content/res/IconCustomizer;->sCustomizedIconHeight:I

    .line 57
    new-instance v1, Landroid/graphics/Rect;

    invoke-direct {v1}, Landroid/graphics/Rect;-><init>()V

    sput-object v1, Lmiui/content/res/IconCustomizer;->sOldBounds:Landroid/graphics/Rect;

    .line 58
    new-instance v1, Landroid/graphics/Canvas;

    invoke-direct {v1}, Landroid/graphics/Canvas;-><init>()V

    sput-object v1, Lmiui/content/res/IconCustomizer;->sCanvas:Landroid/graphics/Canvas;

    .line 61
    sget-object v1, Lmiui/content/res/IconCustomizer;->sCanvas:Landroid/graphics/Canvas;

    new-instance v2, Landroid/graphics/PaintFlagsDrawFilter;

    const/4 v3, 0x4

    const/4 v4, 0x2

    invoke-direct {v2, v3, v4}, Landroid/graphics/PaintFlagsDrawFilter;-><init>(II)V

    invoke-virtual {v1, v2}, Landroid/graphics/Canvas;->setDrawFilter(Landroid/graphics/DrawFilter;)V

    .line 64
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    sput-object v1, Lmiui/content/res/IconCustomizer;->sCache:Ljava/util/HashMap;

    .line 240
    const-string/jumbo v1, "sys.ui.app-icon-background"

    invoke-static {v1, v0}, Landroid/os/SystemProperties;->getInt(Ljava/lang/String;I)I

    move-result v1

    if-eq v1, v0, :cond_106

    :goto_5f
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lmiui/content/res/IconCustomizer;->sExcludeAll:Ljava/lang/Boolean;

    .line 242
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lmiui/content/res/IconCustomizer;->sIconMapping:Ljava/util/Map;

    .line 245
    sget-object v0, Lmiui/content/res/IconCustomizer;->sIconMapping:Ljava/util/Map;

    const-string v1, "com.android.contacts.activities.TwelveKeyDialer.png"

    const-string v2, "com.android.contacts.TwelveKeyDialer.png"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 246
    sget-object v0, Lmiui/content/res/IconCustomizer;->sIconMapping:Ljava/util/Map;

    const-string v1, "com.miui.weather2.png"

    const-string v2, "com.miui.weather.png"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 247
    sget-object v0, Lmiui/content/res/IconCustomizer;->sIconMapping:Ljava/util/Map;

    const-string v1, "com.miui.gallery.png"

    const-string v2, "com.android.gallery.png"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 248
    sget-object v0, Lmiui/content/res/IconCustomizer;->sIconMapping:Ljava/util/Map;

    const-string v1, "com.android.gallery3d.png"

    const-string v2, "com.cooliris.media.png"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 249
    sget-object v0, Lmiui/content/res/IconCustomizer;->sIconMapping:Ljava/util/Map;

    const-string v1, "com.xiaomi.market.png"

    const-string v2, "com.miui.supermarket.png"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 250
    sget-object v0, Lmiui/content/res/IconCustomizer;->sIconMapping:Ljava/util/Map;

    const-string v1, "com.wali.miui.networkassistant.png"

    const-string v2, "com.android.monitor.png"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 253
    sget-object v0, Lmiui/content/res/IconCustomizer;->sIconMapping:Ljava/util/Map;

    const-string v1, "com.android.camera.CameraEntry.png"

    const-string v2, "com.miui.camera.png"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 254
    sget-object v0, Lmiui/content/res/IconCustomizer;->sIconMapping:Ljava/util/Map;

    const-string v1, "com.htc.album.png"

    const-string v2, "com.miui.gallery.png"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 255
    sget-object v0, Lmiui/content/res/IconCustomizer;->sIconMapping:Ljava/util/Map;

    const-string v1, "com.htc.fm.activity.FMRadioMain.png"

    const-string v2, "com.miui.fmradio.png"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 256
    sget-object v0, Lmiui/content/res/IconCustomizer;->sIconMapping:Ljava/util/Map;

    const-string v1, "com.htc.fm.FMRadio.png"

    const-string v2, "com.miui.fmradio.png"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 259
    sget-object v0, Lmiui/content/res/IconCustomizer;->sIconMapping:Ljava/util/Map;

    const-string v1, "com.sec.android.app.camera.Camera.png"

    const-string v2, "com.miui.camera.png"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 260
    sget-object v0, Lmiui/content/res/IconCustomizer;->sIconMapping:Ljava/util/Map;

    const-string v1, "com.sec.android.app.fm.png"

    const-string v2, "com.miui.fmradio.png"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 263
    sget-object v0, Lmiui/content/res/IconCustomizer;->sIconMapping:Ljava/util/Map;

    const-string v1, "com.android.hwcamera.png"

    const-string v2, "com.miui.camera.png"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 264
    sget-object v0, Lmiui/content/res/IconCustomizer;->sIconMapping:Ljava/util/Map;

    const-string v1, "com.huawei.android.FMRadio.png"

    const-string v2, "com.miui.fmradio.png"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 267
    sget-object v0, Lmiui/content/res/IconCustomizer;->sIconMapping:Ljava/util/Map;

    const-string v1, "com.sonyericsson.android.camera.png"

    const-string v2, "com.miui.camera.png"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 268
    sget-object v0, Lmiui/content/res/IconCustomizer;->sIconMapping:Ljava/util/Map;

    const-string v1, "com.sonyericsson.fmradio.png"

    const-string v2, "com.miui.fmradio.png"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 271
    sget-object v0, Lmiui/content/res/IconCustomizer;->sIconMapping:Ljava/util/Map;

    const-string v1, "com.motorola.Camera.Camera.png"

    const-string v2, "com.miui.camera.png"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 272
    return-void

    .line 240
    :cond_106
    const/4 v0, 0x0

    goto/16 :goto_5f
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 41
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 195
    return-void
.end method

.method private static RGBToColor([I)I
    .registers 3
    .parameter "RGB"

    .prologue
    .line 606
    const/4 v0, 0x0

    aget v0, p0, v0

    shl-int/lit8 v0, v0, 0x8

    const/4 v1, 0x1

    aget v1, p0, v1

    add-int/2addr v0, v1

    shl-int/lit8 v0, v0, 0x8

    const/4 v1, 0x2

    aget v1, p0, v1

    add-int/2addr v0, v1

    return v0
.end method

.method public static clearCache()V
    .registers 2

    .prologue
    .line 151
    sget-object v1, Lmiui/content/res/IconCustomizer;->sExcludeAll:Ljava/lang/Boolean;

    monitor-enter v1

    .line 152
    const/4 v0, 0x0

    :try_start_4
    sput-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    .line 153
    monitor-exit v1
    :try_end_7
    .catchall {:try_start_4 .. :try_end_7} :catchall_d

    .line 154
    sget-object v0, Lmiui/content/res/IconCustomizer;->sCache:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 155
    return-void

    .line 153
    :catchall_d
    move-exception v0

    :try_start_e
    monitor-exit v1
    :try_end_f
    .catchall {:try_start_e .. :try_end_f} :catchall_d

    throw v0
.end method

.method public static clearCustomizedIcons(Ljava/lang/String;)V
    .registers 3
    .parameter "packageName"

    .prologue
    .line 158
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_14

    .line 159
    const-string v0, "/data/system/customized_icons/*"

    const-string/jumbo v1, "root"

    invoke-static {v0, v1}, Lmiui/util/CommandLineUtils;->rm(Ljava/lang/String;Ljava/lang/String;)Z

    .line 160
    sget-object v0, Lmiui/content/res/IconCustomizer;->sCache:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 164
    :goto_13
    return-void

    .line 162
    :cond_14
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "/data/system/customized_icons/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "*"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "root"

    invoke-static {v0, v1}, Lmiui/util/CommandLineUtils;->rm(Ljava/lang/String;Ljava/lang/String;)Z

    goto :goto_13
.end method

.method private static colorToRGB(I)[I
    .registers 4
    .parameter "color"

    .prologue
    .line 600
    const/4 v0, 0x3

    new-array v0, v0, [I

    const/4 v1, 0x0

    const/high16 v2, 0xff

    and-int/2addr v2, p0

    shr-int/lit8 v2, v2, 0x10

    aput v2, v0, v1

    const/4 v1, 0x1

    const v2, 0xff00

    and-int/2addr v2, p0

    shr-int/lit8 v2, v2, 0x8

    aput v2, v0, v1

    const/4 v1, 0x2

    and-int/lit16 v2, p0, 0xff

    aput v2, v0, v1

    return-object v0
.end method

.method private static composeIcon(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    .registers 16
    .parameter "base"

    .prologue
    const/4 v9, 0x0

    const/4 v2, 0x0

    const/4 v14, 0x0

    .line 426
    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    .line 427
    .local v3, baseWidth:I
    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v7

    .line 428
    .local v7, baseHeight:I
    mul-int v4, v3, v7

    new-array v1, v4, [I

    .local v1, basePixels:[I
    move-object v0, p0

    move v4, v2

    move v5, v2

    move v6, v3

    .line 429
    invoke-virtual/range {v0 .. v7}, Landroid/graphics/Bitmap;->getPixels([IIIIIII)V

    .line 430
    invoke-virtual {p0}, Landroid/graphics/Bitmap;->recycle()V

    .line 433
    invoke-static {v3, v7, v1}, Lmiui/content/res/IconCustomizer;->cutEdge(II[I)V

    .line 436
    sget v4, Lmiui/content/res/IconCustomizer;->sCustomizedIconWidth:I

    sget v5, Lmiui/content/res/IconCustomizer;->sCustomizedIconHeight:I

    sget-object v6, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v4, v5, v6}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v13

    .line 437
    .local v13, result:Landroid/graphics/Bitmap;
    new-instance v0, Landroid/graphics/Canvas;

    invoke-direct {v0, v13}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 440
    .local v0, canvas:Landroid/graphics/Canvas;
    const-string v4, "icon_background.png"

    invoke-static {v4}, Lmiui/content/res/IconCustomizer;->getCachedThemeIcon(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v10

    .line 441
    .local v10, background:Landroid/graphics/Bitmap;
    if-eqz v10, :cond_36

    .line 442
    invoke-static {v0, v10, v3, v7, v1}, Lmiui/content/res/IconCustomizer;->drawBackground(Landroid/graphics/Canvas;Landroid/graphics/Bitmap;II[I)V

    .line 446
    :cond_36
    const-string v4, "icon_pattern.png"

    invoke-static {v4}, Lmiui/content/res/IconCustomizer;->getCachedThemeIcon(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v12

    .line 447
    .local v12, pattern:Landroid/graphics/Bitmap;
    if-eqz v12, :cond_41

    .line 448
    invoke-virtual {v0, v12, v14, v14, v9}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 452
    :cond_41
    sget v4, Lmiui/content/res/IconCustomizer;->sCustomizedIconWidth:I

    sub-int/2addr v4, v3

    div-int/lit8 v4, v4, 0x2

    sget v5, Lmiui/content/res/IconCustomizer;->sCustomizedIconHeight:I

    sub-int/2addr v5, v7

    div-int/lit8 v5, v5, 0x2

    const/4 v8, 0x1

    move v6, v3

    invoke-virtual/range {v0 .. v9}, Landroid/graphics/Canvas;->drawBitmap([IIIIIIIZLandroid/graphics/Paint;)V

    .line 456
    const-string v2, "icon_border.png"

    invoke-static {v2}, Lmiui/content/res/IconCustomizer;->getCachedThemeIcon(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v11

    .line 457
    .local v11, foreground:Landroid/graphics/Bitmap;
    if-eqz v11, :cond_5b

    .line 458
    invoke-virtual {v0, v11, v14, v14, v9}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 461
    :cond_5b
    return-object v13
.end method

.method private static composeShortcutIcon(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    .registers 15
    .parameter "base"

    .prologue
    const/4 v9, 0x0

    const/4 v2, 0x0

    const/4 v13, 0x0

    .line 466
    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    .line 467
    .local v3, baseWidth:I
    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v7

    .line 468
    .local v7, baseHeight:I
    mul-int v4, v3, v7

    new-array v1, v4, [I

    .local v1, basePixels:[I
    move-object v0, p0

    move v4, v2

    move v5, v2

    move v6, v3

    .line 469
    invoke-virtual/range {v0 .. v7}, Landroid/graphics/Bitmap;->getPixels([IIIIIII)V

    .line 470
    invoke-virtual {p0}, Landroid/graphics/Bitmap;->recycle()V

    .line 473
    invoke-static {v3, v7, v1}, Lmiui/content/res/IconCustomizer;->cutEdge(II[I)V

    .line 476
    sget v4, Lmiui/content/res/IconCustomizer;->sCustomizedIconWidth:I

    sget v5, Lmiui/content/res/IconCustomizer;->sCustomizedIconHeight:I

    sget-object v6, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v4, v5, v6}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v12

    .line 477
    .local v12, result:Landroid/graphics/Bitmap;
    new-instance v0, Landroid/graphics/Canvas;

    invoke-direct {v0, v12}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 480
    .local v0, canvas:Landroid/graphics/Canvas;
    const-string v4, "icon_shortcut.png"

    invoke-static {v4}, Lmiui/content/res/IconCustomizer;->getCachedThemeIcon(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v10

    .line 481
    .local v10, background:Landroid/graphics/Bitmap;
    if-eqz v10, :cond_36

    .line 482
    invoke-virtual {v0, v10, v13, v13, v9}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 486
    :cond_36
    sget v4, Lmiui/content/res/IconCustomizer;->sCustomizedIconWidth:I

    sub-int/2addr v4, v3

    div-int/lit8 v4, v4, 0x2

    sget v5, Lmiui/content/res/IconCustomizer;->sCustomizedIconHeight:I

    sub-int/2addr v5, v7

    div-int/lit8 v5, v5, 0x2

    const/4 v8, 0x1

    move v6, v3

    invoke-virtual/range {v0 .. v9}, Landroid/graphics/Canvas;->drawBitmap([IIIIIIIZLandroid/graphics/Paint;)V

    .line 490
    const-string v2, "icon_shortcut_arrow.png"

    invoke-static {v2}, Lmiui/content/res/IconCustomizer;->getCachedThemeIcon(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v11

    .line 491
    .local v11, foreground:Landroid/graphics/Bitmap;
    if-eqz v11, :cond_50

    .line 492
    invoke-virtual {v0, v11, v13, v13, v9}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 495
    :cond_50
    return-object v12
.end method

.method private static cutEdge(II[I)V
    .registers 14
    .parameter "baseWidth"
    .parameter "baseHeight"
    .parameter "basePixels"

    .prologue
    .line 500
    const-string v2, "icon_mask.png"

    invoke-static {v2}, Lmiui/content/res/IconCustomizer;->getCachedThemeIcon(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 501
    .local v0, alphaCutter:Landroid/graphics/Bitmap;
    if-nez v0, :cond_9

    .line 519
    :cond_8
    return-void

    .line 504
    :cond_9
    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v9

    .line 505
    .local v9, alphaWidth:I
    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v8

    .line 506
    .local v8, alphaHeight:I
    if-lt v9, p0, :cond_8

    if-lt v8, p1, :cond_8

    .line 509
    mul-int v2, v9, v8

    new-array v1, v2, [I

    .line 510
    .local v1, alphaPixels:[I
    const/4 v2, 0x0

    sub-int v3, v9, p0

    div-int/lit8 v4, v3, 0x2

    sub-int v3, v8, p1

    div-int/lit8 v5, v3, 0x2

    move v3, p0

    move v6, p0

    move v7, p1

    invoke-virtual/range {v0 .. v7}, Landroid/graphics/Bitmap;->getPixels([IIIIIII)V

    .line 515
    mul-int v2, p0, p1

    add-int/lit8 v10, v2, -0x1

    .local v10, i:I
    :goto_2c
    if-ltz v10, :cond_8

    .line 516
    aget v2, p2, v10

    const v3, 0xffffff

    aget v4, p2, v10

    ushr-int/lit8 v4, v4, 0x18

    aget v5, v1, v10

    ushr-int/lit8 v5, v5, 0x18

    mul-int/2addr v4, v5

    div-int/lit16 v4, v4, 0xff

    shl-int/lit8 v4, v4, 0x18

    add-int/2addr v3, v4

    and-int/2addr v2, v3

    aput v2, p2, v10

    .line 515
    add-int/lit8 v10, v10, -0x1

    goto :goto_2c
.end method

.method private static drawBackground(Landroid/graphics/Canvas;Landroid/graphics/Bitmap;II[I)V
    .registers 24
    .parameter "canvas"
    .parameter "background"
    .parameter "baseWidth"
    .parameter "baseHeight"
    .parameter "basePixels"

    .prologue
    .line 523
    const/16 v17, 0x0

    .line 524
    .local v17, sum:I
    const/4 v1, 0x3

    new-array v0, v1, [I

    move-object/from16 v18, v0

    fill-array-data v18, :array_136

    .line 528
    .local v18, sumRGB:[I
    mul-int v1, p2, p3

    add-int/lit8 v14, v1, -0x1

    .local v14, i:I
    :goto_e
    if-ltz v14, :cond_3d

    .line 529
    aget v1, p4, v14

    const v3, 0xffffff

    and-int v12, v1, v3

    .line 531
    .local v12, color:I
    if-lez v12, :cond_3a

    .line 532
    invoke-static {v12}, Lmiui/content/res/IconCustomizer;->colorToRGB(I)[I

    move-result-object v11

    .line 533
    .local v11, RGB:[I
    const/4 v1, 0x0

    aget v3, v18, v1

    const/4 v5, 0x0

    aget v5, v11, v5

    add-int/2addr v3, v5

    aput v3, v18, v1

    .line 534
    const/4 v1, 0x1

    aget v3, v18, v1

    const/4 v5, 0x1

    aget v5, v11, v5

    add-int/2addr v3, v5

    aput v3, v18, v1

    .line 535
    const/4 v1, 0x2

    aget v3, v18, v1

    const/4 v5, 0x2

    aget v5, v11, v5

    add-int/2addr v3, v5

    aput v3, v18, v1

    .line 536
    add-int/lit8 v17, v17, 0x1

    .line 528
    .end local v11           #RGB:[I
    :cond_3a
    add-int/lit8 v14, v14, -0x1

    goto :goto_e

    .line 539
    .end local v12           #color:I
    :cond_3d
    if-lez v17, :cond_54

    .line 540
    const/4 v1, 0x0

    aget v3, v18, v1

    div-int v3, v3, v17

    aput v3, v18, v1

    .line 541
    const/4 v1, 0x1

    aget v3, v18, v1

    div-int v3, v3, v17

    aput v3, v18, v1

    .line 542
    const/4 v1, 0x2

    aget v3, v18, v1

    div-int v3, v3, v17

    aput v3, v18, v1

    .line 546
    :cond_54
    invoke-static/range {v18 .. v18}, Lmiui/content/res/IconCustomizer;->RGBToColor([I)I

    move-result v12

    .line 547
    .restart local v12       #color:I
    invoke-static {v12}, Lmiui/content/res/IconCustomizer;->getSaturation(I)F

    move-result v1

    float-to-double v5, v1

    const-wide v9, 0x3f947ae147ae147bL

    cmpg-double v1, v5, v9

    if-gez v1, :cond_b7

    .line 548
    const/4 v12, 0x0

    .line 580
    :goto_67
    invoke-static {v12}, Lmiui/content/res/IconCustomizer;->colorToRGB(I)[I

    move-result-object v18

    .line 582
    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v4

    .line 583
    .local v4, backgroundWidth:I
    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v8

    .line 584
    .local v8, backgroundHeight:I
    mul-int v1, v4, v8

    new-array v2, v1, [I

    .line 585
    .local v2, backgroundPixels:[I
    const/4 v3, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object/from16 v1, p1

    move v7, v4

    invoke-virtual/range {v1 .. v8}, Landroid/graphics/Bitmap;->getPixels([IIIIIII)V

    .line 586
    mul-int v1, v4, v8

    add-int/lit8 v14, v1, -0x1

    :goto_84
    if-ltz v14, :cond_129

    .line 587
    aget v12, v2, v14

    .line 589
    const/high16 v1, -0x100

    and-int/2addr v1, v12

    const/high16 v3, 0xff

    and-int/2addr v3, v12

    const/4 v5, 0x0

    aget v5, v18, v5

    mul-int/2addr v3, v5

    ushr-int/lit8 v3, v3, 0x8

    const/high16 v5, 0xff

    and-int/2addr v3, v5

    or-int/2addr v1, v3

    const v3, 0xff00

    and-int/2addr v3, v12

    const/4 v5, 0x1

    aget v5, v18, v5

    mul-int/2addr v3, v5

    ushr-int/lit8 v3, v3, 0x8

    const v5, 0xff00

    and-int/2addr v3, v5

    or-int/2addr v1, v3

    and-int/lit16 v3, v12, 0xff

    const/4 v5, 0x2

    aget v5, v18, v5

    mul-int/2addr v3, v5

    ushr-int/lit8 v3, v3, 0x8

    and-int/lit16 v3, v3, 0xff

    or-int/2addr v1, v3

    aput v1, v2, v14

    .line 586
    add-int/lit8 v14, v14, -0x1

    goto :goto_84

    .line 551
    .end local v2           #backgroundPixels:[I
    .end local v4           #backgroundWidth:I
    .end local v8           #backgroundHeight:I
    :cond_b7
    const/4 v1, 0x2

    new-array v0, v1, [[I

    move-object/from16 v16, v0

    const/4 v1, 0x0

    const/4 v3, 0x2

    new-array v3, v3, [I

    fill-array-data v3, :array_140

    aput-object v3, v16, v1

    const/4 v1, 0x1

    const/4 v3, 0x2

    new-array v3, v3, [I

    fill-array-data v3, :array_148

    aput-object v3, v16, v1

    .line 558
    .local v16, mappingSections:[[I
    const/16 v17, 0x0

    .line 559
    const/4 v14, 0x0

    :goto_d1
    move-object/from16 v0, v16

    array-length v1, v0

    if-ge v14, v1, :cond_e6

    .line 560
    aget-object v1, v16, v14

    const/4 v3, 0x1

    aget v1, v1, v3

    aget-object v3, v16, v14

    const/4 v5, 0x0

    aget v3, v3, v5

    sub-int/2addr v1, v3

    add-int v17, v17, v1

    .line 559
    add-int/lit8 v14, v14, 0x1

    goto :goto_d1

    .line 563
    :cond_e6
    invoke-static {v12}, Lmiui/content/res/IconCustomizer;->getHue(I)F

    move-result v13

    .line 564
    .local v13, hue:F
    move/from16 v0, v17

    int-to-float v1, v0

    mul-float/2addr v1, v13

    const/high16 v3, 0x43b4

    div-float v13, v1, v3

    .line 565
    const/4 v14, 0x0

    :goto_f3
    move-object/from16 v0, v16

    array-length v1, v0

    if-ge v14, v1, :cond_115

    .line 566
    aget-object v1, v16, v14

    const/4 v3, 0x1

    aget v1, v1, v3

    aget-object v3, v16, v14

    const/4 v5, 0x0

    aget v3, v3, v5

    sub-int v15, v1, v3

    .line 567
    .local v15, length:I
    int-to-float v1, v15

    cmpl-float v1, v13, v1

    if-lez v1, :cond_10e

    .line 568
    int-to-float v1, v15

    sub-float/2addr v13, v1

    .line 565
    add-int/lit8 v14, v14, 0x1

    goto :goto_f3

    .line 570
    :cond_10e
    aget-object v1, v16, v14

    const/4 v3, 0x0

    aget v1, v1, v3

    int-to-float v1, v1

    add-float/2addr v13, v1

    .line 574
    .end local v15           #length:I
    :cond_115
    invoke-static {v12, v13}, Lmiui/content/res/IconCustomizer;->setHue(IF)I

    move-result v12

    .line 577
    const v1, 0x3f19999a

    invoke-static {v12, v1}, Lmiui/content/res/IconCustomizer;->setValue(IF)I

    move-result v12

    .line 578
    const v1, 0x3ecccccd

    invoke-static {v12, v1}, Lmiui/content/res/IconCustomizer;->setSaturation(IF)I

    move-result v12

    goto/16 :goto_67

    .line 596
    .end local v13           #hue:F
    .end local v16           #mappingSections:[[I
    .restart local v2       #backgroundPixels:[I
    .restart local v4       #backgroundWidth:I
    .restart local v8       #backgroundHeight:I
    :cond_129
    const/4 v3, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v9, 0x1

    const/4 v10, 0x0

    move-object/from16 v1, p0

    move v7, v4

    invoke-virtual/range {v1 .. v10}, Landroid/graphics/Canvas;->drawBitmap([IIIIIIIZLandroid/graphics/Paint;)V

    .line 597
    return-void

    .line 524
    nop

    :array_136
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
    .end array-data

    .line 551
    :array_140
    .array-data 0x4
        0x64t 0x0t 0x0t 0x0t
        0x6et 0x0t 0x0t 0x0t
    .end array-data

    :array_148
    .array-data 0x4
        0xbet 0x0t 0x0t 0x0t
        0x13t 0x1t 0x0t 0x0t
    .end array-data
.end method

.method private static drawableToBitmap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    .registers 19
    .parameter "icon"

    .prologue
    .line 368
    sget-object v16, Lmiui/content/res/IconCustomizer;->sCanvas:Landroid/graphics/Canvas;

    monitor-enter v16

    .line 369
    :try_start_3
    sget v12, Lmiui/content/res/IconCustomizer;->sIconWidth:I

    .line 370
    .local v12, targetWidth:I
    sget v11, Lmiui/content/res/IconCustomizer;->sIconHeight:I

    .line 372
    .local v11, targetHeight:I
    move v14, v12

    .line 373
    .local v14, width:I
    move v5, v11

    .line 375
    .local v5, height:I
    move-object/from16 v0, p0

    instance-of v15, v0, Landroid/graphics/drawable/PaintDrawable;

    if-eqz v15, :cond_6c

    .line 376
    move-object/from16 v0, p0

    check-cast v0, Landroid/graphics/drawable/PaintDrawable;

    move-object v7, v0

    .line 377
    .local v7, painter:Landroid/graphics/drawable/PaintDrawable;
    invoke-virtual {v7, v12}, Landroid/graphics/drawable/PaintDrawable;->setIntrinsicWidth(I)V

    .line 378
    invoke-virtual {v7, v11}, Landroid/graphics/drawable/PaintDrawable;->setIntrinsicHeight(I)V

    .line 387
    .end local v7           #painter:Landroid/graphics/drawable/PaintDrawable;
    :cond_1a
    :goto_1a
    invoke-virtual/range {p0 .. p0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v10

    .line 388
    .local v10, sourceWidth:I
    invoke-virtual/range {p0 .. p0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v9

    .line 390
    .local v9, sourceHeight:I
    if-lez v10, :cond_35

    if-lez v10, :cond_35

    .line 392
    if-lt v14, v10, :cond_2a

    if-ge v5, v9, :cond_94

    .line 394
    :cond_2a
    int-to-float v15, v10

    int-to-float v0, v9

    move/from16 v17, v0

    div-float v8, v15, v17

    .line 395
    .local v8, ratio:F
    if-le v10, v9, :cond_8e

    .line 396
    int-to-float v15, v14

    div-float/2addr v15, v8

    float-to-int v5, v15

    .line 407
    .end local v8           #ratio:F
    :cond_35
    :goto_35
    sget-object v15, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v12, v11, v15}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v2

    .line 409
    .local v2, bitmap:Landroid/graphics/Bitmap;
    sget-object v4, Lmiui/content/res/IconCustomizer;->sCanvas:Landroid/graphics/Canvas;

    .line 410
    .local v4, canvas:Landroid/graphics/Canvas;
    invoke-virtual {v4, v2}, Landroid/graphics/Canvas;->setBitmap(Landroid/graphics/Bitmap;)V

    .line 412
    sub-int v15, v12, v14

    div-int/lit8 v6, v15, 0x2

    .line 413
    .local v6, left:I
    sub-int v15, v11, v5

    div-int/lit8 v13, v15, 0x2

    .line 415
    .local v13, top:I
    sget-object v15, Lmiui/content/res/IconCustomizer;->sOldBounds:Landroid/graphics/Rect;

    invoke-virtual/range {p0 .. p0}, Landroid/graphics/drawable/Drawable;->getBounds()Landroid/graphics/Rect;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/graphics/Rect;->set(Landroid/graphics/Rect;)V

    .line 416
    add-int v15, v6, v14

    add-int v17, v13, v5

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v6, v13, v15, v1}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 417
    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 418
    sget-object v15, Lmiui/content/res/IconCustomizer;->sOldBounds:Landroid/graphics/Rect;

    move-object/from16 v0, p0

    invoke-virtual {v0, v15}, Landroid/graphics/drawable/Drawable;->setBounds(Landroid/graphics/Rect;)V

    .line 420
    monitor-exit v16

    return-object v2

    .line 379
    .end local v2           #bitmap:Landroid/graphics/Bitmap;
    .end local v4           #canvas:Landroid/graphics/Canvas;
    .end local v6           #left:I
    .end local v9           #sourceHeight:I
    .end local v10           #sourceWidth:I
    .end local v13           #top:I
    :cond_6c
    move-object/from16 v0, p0

    instance-of v15, v0, Landroid/graphics/drawable/BitmapDrawable;

    if-eqz v15, :cond_1a

    .line 381
    move-object/from16 v0, p0

    check-cast v0, Landroid/graphics/drawable/BitmapDrawable;

    move-object v3, v0

    .line 382
    .local v3, bitmapDrawable:Landroid/graphics/drawable/BitmapDrawable;
    invoke-virtual {v3}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v2

    .line 383
    .restart local v2       #bitmap:Landroid/graphics/Bitmap;
    invoke-virtual {v2}, Landroid/graphics/Bitmap;->getDensity()I

    move-result v15

    if-nez v15, :cond_1a

    .line 384
    sget-object v15, Lmiui/content/res/IconCustomizer;->sSystemResource:Landroid/content/res/Resources;

    invoke-virtual {v15}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v15

    invoke-virtual {v3, v15}, Landroid/graphics/drawable/BitmapDrawable;->setTargetDensity(Landroid/util/DisplayMetrics;)V

    goto :goto_1a

    .line 421
    .end local v2           #bitmap:Landroid/graphics/Bitmap;
    .end local v3           #bitmapDrawable:Landroid/graphics/drawable/BitmapDrawable;
    .end local v5           #height:I
    .end local v11           #targetHeight:I
    .end local v12           #targetWidth:I
    .end local v14           #width:I
    :catchall_8b
    move-exception v15

    monitor-exit v16
    :try_end_8d
    .catchall {:try_start_3 .. :try_end_8d} :catchall_8b

    throw v15

    .line 397
    .restart local v5       #height:I
    .restart local v8       #ratio:F
    .restart local v9       #sourceHeight:I
    .restart local v10       #sourceWidth:I
    .restart local v11       #targetHeight:I
    .restart local v12       #targetWidth:I
    .restart local v14       #width:I
    :cond_8e
    if-le v9, v10, :cond_35

    .line 398
    int-to-float v15, v5

    mul-float/2addr v15, v8

    float-to-int v14, v15

    goto :goto_35

    .line 400
    .end local v8           #ratio:F
    :cond_94
    if-ge v10, v14, :cond_35

    if-ge v9, v5, :cond_35

    .line 402
    move v14, v10

    .line 403
    move v5, v9

    goto :goto_35
.end method

.method public static generateIconDrawable(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/BitmapDrawable;
    .registers 3
    .parameter "base"

    .prologue
    .line 356
    invoke-static {p0}, Lmiui/content/res/IconCustomizer;->drawableToBitmap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 357
    .local v0, icon:Landroid/graphics/Bitmap;
    invoke-static {v0}, Lmiui/content/res/IconCustomizer;->composeIcon(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 358
    invoke-static {v0}, Lmiui/content/res/IconCustomizer;->scaleDrawable(Landroid/graphics/Bitmap;)Landroid/graphics/drawable/BitmapDrawable;

    move-result-object v1

    return-object v1
.end method

.method public static generateShortcutIconDrawable(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/BitmapDrawable;
    .registers 3
    .parameter "base"

    .prologue
    .line 362
    invoke-static {p0}, Lmiui/content/res/IconCustomizer;->drawableToBitmap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 363
    .local v0, icon:Landroid/graphics/Bitmap;
    invoke-static {v0}, Lmiui/content/res/IconCustomizer;->composeShortcutIcon(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 364
    invoke-static {v0}, Lmiui/content/res/IconCustomizer;->scaleDrawable(Landroid/graphics/Bitmap;)Landroid/graphics/drawable/BitmapDrawable;

    move-result-object v1

    return-object v1
.end method

.method private static getCachedThemeIcon(Ljava/lang/String;)Landroid/graphics/Bitmap;
    .registers 3
    .parameter "path"

    .prologue
    .line 67
    sget v0, Lmiui/content/res/IconCustomizer;->sCustomizedIconWidth:I

    sget v1, Lmiui/content/res/IconCustomizer;->sCustomizedIconHeight:I

    invoke-static {p0, v0, v1}, Lmiui/content/res/IconCustomizer;->getCachedThemeIcon(Ljava/lang/String;II)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method public static getCachedThemeIcon(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    .registers 7
    .parameter "path"
    .parameter "iconWidth"
    .parameter "iconHeight"

    .prologue
    .line 71
    const/4 v0, 0x0

    .line 73
    .local v0, result:Landroid/graphics/Bitmap;
    sget-object v2, Lmiui/content/res/IconCustomizer;->sCache:Ljava/util/HashMap;

    invoke-virtual {v2, p0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/ref/SoftReference;

    .line 74
    .local v1, soft:Ljava/lang/ref/SoftReference;,"Ljava/lang/ref/SoftReference<Landroid/graphics/Bitmap;>;"
    if-eqz v1, :cond_11

    .line 75
    invoke-virtual {v1}, Ljava/lang/ref/SoftReference;->get()Ljava/lang/Object;

    move-result-object v0

    .end local v0           #result:Landroid/graphics/Bitmap;
    check-cast v0, Landroid/graphics/Bitmap;

    .line 78
    .restart local v0       #result:Landroid/graphics/Bitmap;
    :cond_11
    if-nez v0, :cond_21

    .line 79
    invoke-static {p0}, Lmiui/content/res/IconCustomizer;->getThemeIcon(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 80
    sget-object v2, Lmiui/content/res/IconCustomizer;->sCache:Ljava/util/HashMap;

    new-instance v3, Ljava/lang/ref/SoftReference;

    invoke-direct {v3, v0}, Ljava/lang/ref/SoftReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v2, p0, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 83
    :cond_21
    invoke-static {v0, p1, p2}, Lmiui/content/res/IconCustomizer;->scaleBitmap(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;

    move-result-object v2

    return-object v2
.end method

.method public static getCustomizedIconDrawable(Ljava/lang/String;Ljava/lang/String;)Landroid/graphics/drawable/BitmapDrawable;
    .registers 10
    .parameter "packageName"
    .parameter "className"

    .prologue
    .line 324
    invoke-static {p0, p1}, Lmiui/content/res/IconCustomizer;->getFileName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 325
    .local v0, fileName:Ljava/lang/String;
    invoke-static {v0}, Lmiui/content/res/IconCustomizer;->getThemeIcon(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 328
    .local v1, icon:Landroid/graphics/Bitmap;
    if-nez v1, :cond_22

    if-eqz p1, :cond_22

    invoke-virtual {p1, p0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_22

    .line 329
    const-string v5, "%s.png"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p1, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lmiui/content/res/IconCustomizer;->getThemeIcon(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 332
    :cond_22
    if-nez v1, :cond_32

    .line 333
    sget-object v5, Lmiui/content/res/IconCustomizer;->sIconMapping:Ljava/util/Map;

    invoke-interface {v5, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 334
    .local v3, mappingName:Ljava/lang/String;
    if-eqz v3, :cond_32

    .line 335
    invoke-static {v3}, Lmiui/content/res/IconCustomizer;->getThemeIcon(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 339
    .end local v3           #mappingName:Ljava/lang/String;
    :cond_32
    if-nez v1, :cond_5b

    .line 340
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "/data/system/customized_icons/"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 341
    .local v4, pathName:Ljava/lang/String;
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 342
    .local v2, iconFile:Ljava/io/File;
    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v5

    if-eqz v5, :cond_5b

    .line 343
    invoke-static {v4}, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 344
    if-nez v1, :cond_5b

    .line 347
    invoke-virtual {v2}, Ljava/io/File;->delete()Z

    .line 352
    .end local v2           #iconFile:Ljava/io/File;
    .end local v4           #pathName:Ljava/lang/String;
    :cond_5b
    invoke-static {v1}, Lmiui/content/res/IconCustomizer;->scaleDrawable(Landroid/graphics/Bitmap;)Landroid/graphics/drawable/BitmapDrawable;

    move-result-object v5

    return-object v5
.end method

.method public static getFileName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .registers 6
    .parameter "packageName"
    .parameter "className"

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 139
    if-nez p1, :cond_f

    .line 140
    const-string v0, "%s.png"

    new-array v1, v3, [Ljava/lang/Object;

    aput-object p0, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 147
    :goto_e
    return-object v0

    .line 143
    :cond_f
    invoke-virtual {p1, p0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_20

    .line 144
    const-string v0, "%s.png"

    new-array v1, v3, [Ljava/lang/Object;

    aput-object p1, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_e

    .line 147
    :cond_20
    const-string v0, "%s@%s.png"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    aput-object p1, v1, v2

    aput-object p0, v1, v3

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_e
.end method

.method private static getHue(I)F
    .registers 14
    .parameter "color"

    .prologue
    const/4 v12, 0x1

    const/4 v11, 0x0

    const/high16 v10, 0x4270

    const/4 v9, 0x2

    .line 659
    invoke-static {p0}, Lmiui/content/res/IconCustomizer;->colorToRGB(I)[I

    move-result-object v0

    .line 661
    .local v0, RGB:[I
    aget v6, v0, v11

    aget v7, v0, v12

    aget v8, v0, v9

    invoke-static {v7, v8}, Ljava/lang/Math;->min(II)I

    move-result v7

    invoke-static {v6, v7}, Ljava/lang/Math;->min(II)I

    move-result v4

    .line 662
    .local v4, min:I
    aget v6, v0, v11

    aget v7, v0, v12

    aget v8, v0, v9

    invoke-static {v7, v8}, Ljava/lang/Math;->max(II)I

    move-result v7

    invoke-static {v6, v7}, Ljava/lang/Math;->max(II)I

    move-result v3

    .line 664
    .local v3, max:I
    sub-int v5, v3, v4

    .line 665
    .local v5, range:I
    if-nez v5, :cond_2b

    .line 666
    const/4 v1, 0x0

    .line 676
    :goto_2a
    return v1

    .line 668
    :cond_2b
    const/4 v2, 0x0

    .line 669
    .local v2, index:I
    :goto_2c
    if-ge v2, v9, :cond_35

    aget v6, v0, v2

    if-eq v4, v6, :cond_35

    .line 670
    add-int/lit8 v2, v2, 0x1

    goto :goto_2c

    .line 672
    :cond_35
    add-int/lit8 v6, v2, 0x1

    rem-int/lit8 v6, v6, 0x3

    mul-int/lit8 v6, v6, 0x78

    int-to-float v1, v6

    .line 673
    .local v1, hue:F
    add-int/lit8 v6, v2, 0x2

    rem-int/lit8 v6, v6, 0x3

    aget v6, v0, v6

    sub-int/2addr v6, v4

    int-to-float v6, v6

    mul-float/2addr v6, v10

    int-to-float v7, v5

    div-float/2addr v6, v7

    add-float/2addr v1, v6

    .line 674
    add-int/lit8 v6, v2, 0x1

    rem-int/lit8 v6, v6, 0x3

    aget v6, v0, v6

    sub-int v6, v3, v6

    int-to-float v6, v6

    mul-float/2addr v6, v10

    int-to-float v7, v5

    div-float/2addr v6, v7

    add-float/2addr v1, v6

    .line 676
    goto :goto_2a
.end method

.method private static getSaturation(I)F
    .registers 10
    .parameter "color"

    .prologue
    const/4 v8, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 632
    invoke-static {p0}, Lmiui/content/res/IconCustomizer;->colorToRGB(I)[I

    move-result-object v0

    .line 634
    .local v0, RGB:[I
    aget v3, v0, v6

    aget v4, v0, v7

    aget v5, v0, v8

    invoke-static {v4, v5}, Ljava/lang/Math;->min(II)I

    move-result v4

    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v2

    .line 635
    .local v2, min:I
    aget v3, v0, v6

    aget v4, v0, v7

    aget v5, v0, v8

    invoke-static {v4, v5}, Ljava/lang/Math;->max(II)I

    move-result v4

    invoke-static {v3, v4}, Ljava/lang/Math;->max(II)I

    move-result v1

    .line 636
    .local v1, max:I
    if-eqz v1, :cond_27

    if-ne v1, v2, :cond_29

    .line 637
    :cond_27
    int-to-float v3, p0

    .line 639
    :goto_28
    return v3

    :cond_29
    const/high16 v3, 0x3f80

    sub-int v4, v1, v2

    int-to-float v4, v4

    mul-float/2addr v3, v4

    int-to-float v4, v1

    div-float/2addr v3, v4

    goto :goto_28
.end method

.method private static getThemeIcon(Ljava/lang/String;)Landroid/graphics/Bitmap;
    .registers 6
    .parameter "fileName"

    .prologue
    .line 87
    const/4 v1, 0x0

    .line 88
    .local v1, icon:Landroid/graphics/Bitmap;
    const/4 v0, 0x0

    .local v0, i:I
    :goto_2
    sget-object v3, Lmiui/content/res/IconCustomizer;->sDensities:[I

    array-length v3, v3

    if-ge v0, v3, :cond_33

    .line 89
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lmiui/content/res/IconCustomizer;->sDensities:[I

    aget v4, v4, v0

    invoke-static {v4}, Lmiui/util/DisplayUtils;->getDrawbleDensityFolder(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 90
    .local v2, targetFileName:Ljava/lang/String;
    invoke-static {}, Lmiui/content/res/ThemeResources;->getSystem()Lmiui/content/res/ThemeResourcesSystem;

    move-result-object v3

    sget-object v4, Lmiui/content/res/IconCustomizer;->sSystemResource:Landroid/content/res/Resources;

    invoke-virtual {v3, v4, v2}, Lmiui/content/res/ThemeResourcesSystem;->getIcon(Landroid/content/res/Resources;Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 91
    if-eqz v1, :cond_47

    .line 92
    sget-object v3, Lmiui/content/res/IconCustomizer;->sDensities:[I

    aget v3, v3, v0

    invoke-virtual {v1, v3}, Landroid/graphics/Bitmap;->setDensity(I)V

    .line 96
    .end local v2           #targetFileName:Ljava/lang/String;
    :cond_33
    if-nez v1, :cond_46

    .line 97
    invoke-static {}, Lmiui/content/res/ThemeResources;->getSystem()Lmiui/content/res/ThemeResourcesSystem;

    move-result-object v3

    sget-object v4, Lmiui/content/res/IconCustomizer;->sSystemResource:Landroid/content/res/Resources;

    invoke-virtual {v3, v4, p0}, Lmiui/content/res/ThemeResourcesSystem;->getIcon(Landroid/content/res/Resources;Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 98
    if-eqz v1, :cond_46

    .line 99
    const/16 v3, 0xf0

    invoke-virtual {v1, v3}, Landroid/graphics/Bitmap;->setDensity(I)V

    .line 102
    :cond_46
    return-object v1

    .line 88
    .restart local v2       #targetFileName:Ljava/lang/String;
    :cond_47
    add-int/lit8 v0, v0, 0x1

    goto :goto_2
.end method

.method private static getValue(I)F
    .registers 6
    .parameter "color"

    .prologue
    .line 610
    invoke-static {p0}, Lmiui/content/res/IconCustomizer;->colorToRGB(I)[I

    move-result-object v0

    .line 612
    .local v0, RGB:[I
    const/4 v2, 0x0

    aget v2, v0, v2

    const/4 v3, 0x1

    aget v3, v0, v3

    const/4 v4, 0x2

    aget v4, v0, v4

    invoke-static {v3, v4}, Ljava/lang/Math;->max(II)I

    move-result v3

    invoke-static {v2, v3}, Ljava/lang/Math;->max(II)I

    move-result v1

    .line 613
    .local v1, max:I
    const/high16 v2, 0x3f80

    int-to-float v3, v1

    mul-float/2addr v2, v3

    const/high16 v3, 0x437f

    div-float/2addr v2, v3

    return v2
.end method

.method public static isExclude(Ljava/lang/String;)Z
    .registers 4
    .parameter "packageName"

    .prologue
    .line 275
    sget-object v1, Lmiui/content/res/IconCustomizer;->sExcludeAll:Ljava/lang/Boolean;

    monitor-enter v1

    .line 276
    :try_start_3
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    if-nez v0, :cond_11d

    .line 277
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    sput-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    .line 278
    invoke-static {}, Lmiui/content/res/ThemeResources;->getSystem()Lmiui/content/res/ThemeResourcesSystem;

    move-result-object v0

    const-string v2, "exclude_list.txt"

    invoke-virtual {v0, v2}, Lmiui/content/res/ThemeResourcesSystem;->hasIcon(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_11d

    .line 279
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.android.browser"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 280
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.android.calendar"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 281
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.android.camera"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 282
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.android.contacts"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 283
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.android.deskclock"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 284
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.android.email"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 285
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.android.fileexplorer"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 286
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.android.gallery"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 287
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.android.launcher"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 288
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.android.mms"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 289
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.android.monitor"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 290
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.android.music"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 291
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.android.phone"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 292
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.android.providers.contacts"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 293
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.android.providers.downloads.ui"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 294
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.android.providers.telephony"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 295
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.android.quicksearchbox"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 296
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.android.settings"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 297
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.android.soundrecorder"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 298
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.android.spare_parts"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 299
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.android.stk"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 300
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.android.thememanager"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 301
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.android.updater"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 302
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.miui.antispam"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 303
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.miui.backup"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 304
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.miui.bugreport"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 305
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.miui.camera"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 306
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.miui.cit"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 307
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.miui.compass"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 308
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.miui.fmradio"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 309
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.miui.lockv4"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 310
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.miui.notes"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 311
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.miui.player"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 312
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.xiaomi.market"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 313
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.miui.uac"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 314
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.miui.userbook"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 315
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    const-string v2, "com.miui.weather2"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 319
    :cond_11d
    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludeAll:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_12d

    sget-object v0, Lmiui/content/res/IconCustomizer;->sExcludes:Ljava/util/Set;

    invoke-interface {v0, p0}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_130

    :cond_12d
    const/4 v0, 0x1

    :goto_12e
    monitor-exit v1

    return v0

    :cond_130
    const/4 v0, 0x0

    goto :goto_12e

    .line 320
    :catchall_132
    move-exception v0

    monitor-exit v1
    :try_end_134
    .catchall {:try_start_3 .. :try_end_134} :catchall_132

    throw v0
.end method

.method public static prepareCustomizedIcons(Landroid/content/Context;)V
    .registers 2
    .parameter "context"

    .prologue
    .line 167
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lmiui/content/res/IconCustomizer;->prepareCustomizedIcons(Landroid/content/Context;Lmiui/content/res/IconCustomizer$CustomizedIconsListener;)V

    .line 168
    return-void
.end method

.method public static prepareCustomizedIcons(Landroid/content/Context;Lmiui/content/res/IconCustomizer$CustomizedIconsListener;)V
    .registers 11
    .parameter "context"
    .parameter "l"

    .prologue
    .line 171
    new-instance v2, Landroid/content/Intent;

    const-string v7, "android.intent.action.MAIN"

    const/4 v8, 0x0

    invoke-direct {v2, v7, v8}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 172
    .local v2, launcherIntent:Landroid/content/Intent;
    const-string v7, "android.intent.category.LAUNCHER"

    invoke-virtual {v2, v7}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 174
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 175
    .local v4, pm:Landroid/content/pm/PackageManager;
    const/4 v7, 0x0

    invoke-virtual {v4, v2, v7}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v3

    .line 177
    .local v3, list:Ljava/util/List;,"Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    if-eqz p1, :cond_1f

    .line 178
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v7

    invoke-interface {p1, v7}, Lmiui/content/res/IconCustomizer$CustomizedIconsListener;->beforePrepareIcon(I)V

    .line 181
    :cond_1f
    const/4 v5, 0x0

    .line 182
    .local v5, taskCnt:I
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :cond_24
    :goto_24
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_3e

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/pm/ResolveInfo;

    .line 183
    .local v1, info:Landroid/content/pm/ResolveInfo;
    iget-object v7, v1, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    invoke-virtual {v7, v4}, Landroid/content/pm/ActivityInfo;->loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    .line 185
    if-eqz p1, :cond_24

    .line 186
    add-int/lit8 v6, v5, 0x1

    .end local v5           #taskCnt:I
    .local v6, taskCnt:I
    invoke-interface {p1, v5}, Lmiui/content/res/IconCustomizer$CustomizedIconsListener;->finishPrepareIcon(I)V

    move v5, v6

    .end local v6           #taskCnt:I
    .restart local v5       #taskCnt:I
    goto :goto_24

    .line 190
    .end local v1           #info:Landroid/content/pm/ResolveInfo;
    :cond_3e
    if-eqz p1, :cond_43

    .line 191
    invoke-interface {p1}, Lmiui/content/res/IconCustomizer$CustomizedIconsListener;->finishAllIcons()V

    .line 193
    :cond_43
    return-void
.end method

.method public static saveCustomizedIconBitmap(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .registers 12
    .parameter "fileName"
    .parameter "icon"

    .prologue
    .line 205
    :try_start_0
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "/data/system/customized_icons/"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 206
    .local v5, pathName:Ljava/lang/String;
    new-instance v1, Ljava/io/File;

    invoke-direct {v1, v5}, Ljava/io/File;-><init>(Ljava/lang/String;)V
    :try_end_18
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_18} :catch_54
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_18} :catch_59

    .line 207
    .local v1, file:Ljava/io/File;
    const/4 v2, 0x0

    .line 211
    .local v2, outputStream:Ljava/io/FileOutputStream;
    :try_start_19
    new-instance v3, Ljava/io/FileOutputStream;

    invoke-direct {v3, v1}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    :try_end_1e
    .catch Ljava/io/FileNotFoundException; {:try_start_19 .. :try_end_1e} :catch_5e
    .catch Ljava/io/IOException; {:try_start_19 .. :try_end_1e} :catch_59

    .line 212
    .end local v2           #outputStream:Ljava/io/FileOutputStream;
    .local v3, outputStream:Ljava/io/FileOutputStream;
    const/16 v6, 0x1b4

    const/4 v7, -0x1

    const/4 v8, -0x1

    :try_start_22
    invoke-static {v5, v6, v7, v8}, Landroid/os/FileUtils;->setPermissions(Ljava/lang/String;III)I
    :try_end_25
    .catch Ljava/io/FileNotFoundException; {:try_start_22 .. :try_end_25} :catch_60
    .catch Ljava/io/IOException; {:try_start_22 .. :try_end_25} :catch_59

    move-object v2, v3

    .line 220
    .end local v3           #outputStream:Ljava/io/FileOutputStream;
    .restart local v2       #outputStream:Ljava/io/FileOutputStream;
    :goto_26
    if-nez v2, :cond_46

    .line 221
    :try_start_28
    invoke-virtual {v1}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v4

    .line 222
    .local v4, parent:Ljava/io/File;
    invoke-virtual {v4}, Ljava/io/File;->mkdirs()Z

    .line 223
    invoke-virtual {v4}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v6

    const/16 v7, 0x3ff

    const/4 v8, -0x1

    const/4 v9, -0x1

    invoke-static {v6, v7, v8, v9}, Landroid/os/FileUtils;->setPermissions(Ljava/lang/String;III)I

    .line 225
    new-instance v2, Ljava/io/FileOutputStream;

    .end local v2           #outputStream:Ljava/io/FileOutputStream;
    invoke-direct {v2, v1}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 226
    .restart local v2       #outputStream:Ljava/io/FileOutputStream;
    const/16 v6, 0x1b4

    const/4 v7, -0x1

    const/4 v8, -0x1

    invoke-static {v5, v6, v7, v8}, Landroid/os/FileUtils;->setPermissions(Ljava/lang/String;III)I

    .line 230
    .end local v4           #parent:Ljava/io/File;
    :cond_46
    sget-object v6, Landroid/graphics/Bitmap$CompressFormat;->PNG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v7, 0x64

    invoke-virtual {p1, v6, v7, v2}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 231
    invoke-virtual {v2}, Ljava/io/FileOutputStream;->flush()V

    .line 232
    invoke-virtual {v2}, Ljava/io/FileOutputStream;->close()V
    :try_end_53
    .catch Ljava/io/FileNotFoundException; {:try_start_28 .. :try_end_53} :catch_54
    .catch Ljava/io/IOException; {:try_start_28 .. :try_end_53} :catch_59

    .line 238
    .end local v1           #file:Ljava/io/File;
    .end local v2           #outputStream:Ljava/io/FileOutputStream;
    .end local v5           #pathName:Ljava/lang/String;
    :goto_53
    return-void

    .line 233
    :catch_54
    move-exception v0

    .line 234
    .local v0, e:Ljava/io/FileNotFoundException;
    invoke-virtual {v0}, Ljava/io/FileNotFoundException;->printStackTrace()V

    goto :goto_53

    .line 235
    .end local v0           #e:Ljava/io/FileNotFoundException;
    :catch_59
    move-exception v0

    .line 236
    .local v0, e:Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_53

    .line 213
    .end local v0           #e:Ljava/io/IOException;
    .restart local v1       #file:Ljava/io/File;
    .restart local v2       #outputStream:Ljava/io/FileOutputStream;
    .restart local v5       #pathName:Ljava/lang/String;
    :catch_5e
    move-exception v6

    goto :goto_26

    .end local v2           #outputStream:Ljava/io/FileOutputStream;
    .restart local v3       #outputStream:Ljava/io/FileOutputStream;
    :catch_60
    move-exception v6

    move-object v2, v3

    .end local v3           #outputStream:Ljava/io/FileOutputStream;
    .restart local v2       #outputStream:Ljava/io/FileOutputStream;
    goto :goto_26
.end method

.method private static scaleBitmap(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    .registers 3
    .parameter "icon"

    .prologue
    .line 123
    sget v0, Lmiui/content/res/IconCustomizer;->sCustomizedIconWidth:I

    sget v1, Lmiui/content/res/IconCustomizer;->sCustomizedIconHeight:I

    invoke-static {p0, v0, v1}, Lmiui/content/res/IconCustomizer;->scaleBitmap(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method private static scaleBitmap(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    .registers 5
    .parameter "icon"
    .parameter "iconWidth"
    .parameter "iconHeight"

    .prologue
    .line 127
    const/4 v0, 0x0

    .line 128
    .local v0, bitmap:Landroid/graphics/Bitmap;
    if-eqz p0, :cond_1a

    .line 129
    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v1

    if-ne v1, p1, :cond_10

    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v1

    if-ne v1, p2, :cond_10

    .line 135
    .end local p0
    :goto_f
    return-object p0

    .line 132
    .restart local p0
    :cond_10
    const/4 v1, 0x1

    invoke-static {p0, p1, p2, v1}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 133
    sget v1, Lmiui/content/res/IconCustomizer;->sDensity:I

    invoke-virtual {v0, v1}, Landroid/graphics/Bitmap;->setDensity(I)V

    :cond_1a
    move-object p0, v0

    .line 135
    goto :goto_f
.end method

.method private static scaleDrawable(Landroid/graphics/Bitmap;)Landroid/graphics/drawable/BitmapDrawable;
    .registers 4
    .parameter "icon"

    .prologue
    .line 114
    const/4 v0, 0x0

    .line 115
    .local v0, bd:Landroid/graphics/drawable/BitmapDrawable;
    if-eqz p0, :cond_e

    .line 116
    invoke-static {p0}, Lmiui/content/res/IconCustomizer;->scaleBitmap(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 117
    .local v1, bitmap:Landroid/graphics/Bitmap;
    new-instance v0, Landroid/graphics/drawable/BitmapDrawable;

    .end local v0           #bd:Landroid/graphics/drawable/BitmapDrawable;
    sget-object v2, Lmiui/content/res/IconCustomizer;->sSystemResource:Landroid/content/res/Resources;

    invoke-direct {v0, v2, v1}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    .line 119
    .end local v1           #bitmap:Landroid/graphics/Bitmap;
    .restart local v0       #bd:Landroid/graphics/drawable/BitmapDrawable;
    :cond_e
    return-object v0
.end method

.method private static scalePixel(I)I
    .registers 4
    .parameter "px"

    .prologue
    .line 106
    sget v0, Lmiui/content/res/IconCustomizer;->sDensity:I

    .line 107
    .local v0, density:I
    sget v1, Lmiui/content/res/IconCustomizer;->sDensity:I

    const/16 v2, 0x140

    if-ne v1, v2, :cond_a

    .line 108
    const/16 v0, 0x168

    .line 110
    :cond_a
    mul-int v1, p0, v0

    div-int/lit16 v1, v1, 0xf0

    return v1
.end method

.method private static setHue(IF)I
    .registers 15
    .parameter "color"
    .parameter "hue"

    .prologue
    const/4 v12, 0x1

    const/4 v11, 0x0

    const/4 v10, 0x0

    const/high16 v8, 0x43b4

    const/high16 v9, 0x4270

    .line 680
    invoke-static {p0}, Lmiui/content/res/IconCustomizer;->colorToRGB(I)[I

    move-result-object v0

    .line 682
    .local v0, RGB:[I
    aget v5, v0, v11

    aget v6, v0, v12

    const/4 v7, 0x2

    aget v7, v0, v7

    invoke-static {v6, v7}, Ljava/lang/Math;->min(II)I

    move-result v6

    invoke-static {v5, v6}, Ljava/lang/Math;->min(II)I

    move-result v3

    .line 683
    .local v3, min:I
    aget v5, v0, v11

    aget v6, v0, v12

    const/4 v7, 0x2

    aget v7, v0, v7

    invoke-static {v6, v7}, Ljava/lang/Math;->max(II)I

    move-result v6

    invoke-static {v5, v6}, Ljava/lang/Math;->max(II)I

    move-result v2

    .line 685
    .local v2, max:I
    sub-int v4, v2, v3

    .line 686
    .local v4, range:I
    if-nez v4, :cond_2e

    .line 702
    .end local p0
    :goto_2d
    return p0

    .line 689
    .restart local p0
    :cond_2e
    :goto_2e
    cmpg-float v5, p1, v10

    if-gez v5, :cond_34

    .line 690
    add-float/2addr p1, v8

    goto :goto_2e

    .line 691
    :cond_34
    :goto_34
    cmpl-float v5, p1, v8

    if-lez v5, :cond_3a

    .line 692
    sub-float/2addr p1, v8

    goto :goto_34

    .line 694
    :cond_3a
    const/high16 v5, 0x42f0

    div-float v5, p1, v5

    float-to-double v5, v5

    invoke-static {v5, v6}, Ljava/lang/Math;->floor(D)D

    move-result-wide v5

    double-to-int v1, v5

    .line 695
    .local v1, index:I
    mul-int/lit8 v5, v1, 0x78

    int-to-float v5, v5

    sub-float/2addr p1, v5

    .line 696
    add-int/lit8 v5, v1, 0x2

    rem-int/lit8 v1, v5, 0x3

    .line 698
    aput v3, v0, v1

    .line 699
    add-int/lit8 v5, v1, 0x2

    rem-int/lit8 v5, v5, 0x3

    int-to-float v6, v3

    int-to-float v7, v4

    invoke-static {p1, v9}, Ljava/lang/Math;->min(FF)F

    move-result v8

    mul-float/2addr v7, v8

    div-float/2addr v7, v9

    add-float/2addr v6, v7

    float-to-int v6, v6

    aput v6, v0, v5

    .line 700
    add-int/lit8 v5, v1, 0x1

    rem-int/lit8 v5, v5, 0x3

    int-to-float v6, v2

    int-to-float v7, v4

    sub-float v8, p1, v9

    invoke-static {v10, v8}, Ljava/lang/Math;->max(FF)F

    move-result v8

    mul-float/2addr v7, v8

    div-float/2addr v7, v9

    sub-float/2addr v6, v7

    float-to-int v6, v6

    aput v6, v0, v5

    .line 702
    invoke-static {v0}, Lmiui/content/res/IconCustomizer;->RGBToColor([I)I

    move-result p0

    goto :goto_2d
.end method

.method private static setSaturation(IF)I
    .registers 12
    .parameter "color"
    .parameter "saturation"

    .prologue
    const/4 v9, 0x2

    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 643
    invoke-static {p0}, Lmiui/content/res/IconCustomizer;->colorToRGB(I)[I

    move-result-object v0

    .line 645
    .local v0, RGB:[I
    aget v4, v0, v7

    aget v5, v0, v8

    aget v6, v0, v9

    invoke-static {v5, v6}, Ljava/lang/Math;->min(II)I

    move-result v5

    invoke-static {v4, v5}, Ljava/lang/Math;->min(II)I

    move-result v3

    .line 646
    .local v3, min:I
    aget v4, v0, v7

    aget v5, v0, v8

    aget v6, v0, v9

    invoke-static {v5, v6}, Ljava/lang/Math;->max(II)I

    move-result v5

    invoke-static {v4, v5}, Ljava/lang/Math;->max(II)I

    move-result v2

    .line 647
    .local v2, max:I
    if-eqz v2, :cond_27

    if-ne v2, v3, :cond_28

    .line 655
    .end local p0
    :cond_27
    :goto_27
    return p0

    .line 650
    .restart local p0
    :cond_28
    const/high16 v4, 0x3f80

    sub-int v5, v2, v3

    int-to-float v5, v5

    mul-float/2addr v4, v5

    int-to-float v5, v2

    div-float v1, v4, v5

    .line 651
    .local v1, currentSaturation:F
    int-to-float v4, v2

    aget v5, v0, v7

    sub-int v5, v2, v5

    int-to-float v5, v5

    mul-float/2addr v5, p1

    div-float/2addr v5, v1

    sub-float/2addr v4, v5

    float-to-int v4, v4

    aput v4, v0, v7

    .line 652
    int-to-float v4, v2

    aget v5, v0, v8

    sub-int v5, v2, v5

    int-to-float v5, v5

    mul-float/2addr v5, p1

    div-float/2addr v5, v1

    sub-float/2addr v4, v5

    float-to-int v4, v4

    aput v4, v0, v8

    .line 653
    int-to-float v4, v2

    aget v5, v0, v9

    sub-int v5, v2, v5

    int-to-float v5, v5

    mul-float/2addr v5, p1

    div-float/2addr v5, v1

    sub-float/2addr v4, v5

    float-to-int v4, v4

    aput v4, v0, v9

    .line 655
    invoke-static {v0}, Lmiui/content/res/IconCustomizer;->RGBToColor([I)I

    move-result p0

    goto :goto_27
.end method

.method private static setValue(IF)I
    .registers 11
    .parameter "color"
    .parameter "value"

    .prologue
    const/4 v8, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 617
    invoke-static {p0}, Lmiui/content/res/IconCustomizer;->colorToRGB(I)[I

    move-result-object v0

    .line 619
    .local v0, RGB:[I
    aget v3, v0, v6

    aget v4, v0, v7

    aget v5, v0, v8

    invoke-static {v4, v5}, Ljava/lang/Math;->max(II)I

    move-result v4

    invoke-static {v3, v4}, Ljava/lang/Math;->max(II)I

    move-result v2

    .line 620
    .local v2, max:I
    if-nez v2, :cond_18

    .line 628
    .end local p0
    :goto_17
    return p0

    .line 623
    .restart local p0
    :cond_18
    const/high16 v3, 0x3f80

    int-to-float v4, v2

    mul-float/2addr v3, v4

    const/high16 v4, 0x437f

    div-float v1, v3, v4

    .line 624
    .local v1, currentValue:F
    aget v3, v0, v6

    int-to-float v3, v3

    mul-float/2addr v3, p1

    div-float/2addr v3, v1

    float-to-int v3, v3

    aput v3, v0, v6

    .line 625
    aget v3, v0, v7

    int-to-float v3, v3

    mul-float/2addr v3, p1

    div-float/2addr v3, v1

    float-to-int v3, v3

    aput v3, v0, v7

    .line 626
    aget v3, v0, v8

    int-to-float v3, v3

    mul-float/2addr v3, p1

    div-float/2addr v3, v1

    float-to-int v3, v3

    aput v3, v0, v8

    .line 628
    invoke-static {v0}, Lmiui/content/res/IconCustomizer;->RGBToColor([I)I

    move-result p0

    goto :goto_17
.end method
