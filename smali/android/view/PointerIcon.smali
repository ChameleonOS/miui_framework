.class public final Landroid/view/PointerIcon;
.super Ljava/lang/Object;
.source "PointerIcon.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/view/PointerIcon;",
            ">;"
        }
    .end annotation
.end field

.field public static final STYLE_ARROW:I = 0x3e8

.field public static final STYLE_CUSTOM:I = -0x1

.field private static final STYLE_DEFAULT:I = 0x3e8

.field public static final STYLE_NULL:I = 0x0

.field private static final STYLE_OEM_FIRST:I = 0x2710

.field public static final STYLE_SPOT_ANCHOR:I = 0x7d2

.field public static final STYLE_SPOT_HOVER:I = 0x7d0

.field public static final STYLE_SPOT_TOUCH:I = 0x7d1

.field private static final TAG:Ljava/lang/String; = "PointerIcon"

.field private static final gNullIcon:Landroid/view/PointerIcon;


# instance fields
.field private mBitmap:Landroid/graphics/Bitmap;

.field private mHotSpotX:F

.field private mHotSpotY:F

.field private final mStyle:I

.field private mSystemIconResourceId:I


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    .line 69
    new-instance v0, Landroid/view/PointerIcon;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Landroid/view/PointerIcon;-><init>(I)V

    sput-object v0, Landroid/view/PointerIcon;->gNullIcon:Landroid/view/PointerIcon;

    .line 308
    new-instance v0, Landroid/view/PointerIcon$1;

    invoke-direct {v0}, Landroid/view/PointerIcon$1;-><init>()V

    sput-object v0, Landroid/view/PointerIcon;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method private constructor <init>(I)V
    .registers 2
    .parameter "style"

    .prologue
    .line 77
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 78
    iput p1, p0, Landroid/view/PointerIcon;->mStyle:I

    .line 79
    return-void
.end method

.method synthetic constructor <init>(ILandroid/view/PointerIcon$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 41
    invoke-direct {p0, p1}, Landroid/view/PointerIcon;-><init>(I)V

    return-void
.end method

.method static synthetic access$102(Landroid/view/PointerIcon;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 41
    iput p1, p0, Landroid/view/PointerIcon;->mSystemIconResourceId:I

    return p1
.end method

.method public static createCustomIcon(Landroid/graphics/Bitmap;FF)Landroid/view/PointerIcon;
    .registers 6
    .parameter "bitmap"
    .parameter "hotSpotX"
    .parameter "hotSpotY"

    .prologue
    .line 162
    if-nez p0, :cond_a

    .line 163
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "bitmap must not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 165
    :cond_a
    invoke-static {p0, p1, p2}, Landroid/view/PointerIcon;->validateHotSpot(Landroid/graphics/Bitmap;FF)V

    .line 167
    new-instance v0, Landroid/view/PointerIcon;

    const/4 v1, -0x1

    invoke-direct {v0, v1}, Landroid/view/PointerIcon;-><init>(I)V

    .line 168
    .local v0, icon:Landroid/view/PointerIcon;
    iput-object p0, v0, Landroid/view/PointerIcon;->mBitmap:Landroid/graphics/Bitmap;

    .line 169
    iput p1, v0, Landroid/view/PointerIcon;->mHotSpotX:F

    .line 170
    iput p2, v0, Landroid/view/PointerIcon;->mHotSpotY:F

    .line 171
    return-object v0
.end method

.method public static getDefaultIcon(Landroid/content/Context;)Landroid/view/PointerIcon;
    .registers 2
    .parameter "context"

    .prologue
    .line 101
    const/16 v0, 0x3e8

    invoke-static {p0, v0}, Landroid/view/PointerIcon;->getSystemIcon(Landroid/content/Context;I)Landroid/view/PointerIcon;

    move-result-object v0

    return-object v0
.end method

.method public static getNullIcon()Landroid/view/PointerIcon;
    .registers 1

    .prologue
    .line 89
    sget-object v0, Landroid/view/PointerIcon;->gNullIcon:Landroid/view/PointerIcon;

    return-object v0
.end method

.method public static getSystemIcon(Landroid/content/Context;I)Landroid/view/PointerIcon;
    .registers 12
    .parameter "context"
    .parameter "style"

    .prologue
    const/4 v9, -0x1

    const/16 v8, 0x3e8

    .line 115
    if-nez p0, :cond_d

    .line 116
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string v5, "context must not be null"

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 119
    :cond_d
    if-nez p1, :cond_12

    .line 120
    sget-object v4, Landroid/view/PointerIcon;->gNullIcon:Landroid/view/PointerIcon;

    .line 145
    :goto_11
    return-object v4

    .line 123
    :cond_12
    invoke-static {p1}, Landroid/view/PointerIcon;->getSystemIconStyleIndex(I)I

    move-result v3

    .line 124
    .local v3, styleIndex:I
    if-nez v3, :cond_1c

    .line 125
    invoke-static {v8}, Landroid/view/PointerIcon;->getSystemIconStyleIndex(I)I

    move-result v3

    .line 128
    :cond_1c
    const/4 v4, 0x0

    sget-object v5, Lcom/android/internal/R$styleable;->Pointer:[I

    const v6, 0x10103db

    const/4 v7, 0x0

    invoke-virtual {p0, v4, v5, v6, v7}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 131
    .local v0, a:Landroid/content/res/TypedArray;
    invoke-virtual {v0, v3, v9}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v2

    .line 132
    .local v2, resourceId:I
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 134
    if-ne v2, v9, :cond_52

    .line 135
    const-string v4, "PointerIcon"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Missing theme resources for pointer icon style "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 136
    if-ne p1, v8, :cond_4d

    sget-object v4, Landroid/view/PointerIcon;->gNullIcon:Landroid/view/PointerIcon;

    goto :goto_11

    :cond_4d
    invoke-static {p0, v8}, Landroid/view/PointerIcon;->getSystemIcon(Landroid/content/Context;I)Landroid/view/PointerIcon;

    move-result-object v4

    goto :goto_11

    .line 139
    :cond_52
    new-instance v1, Landroid/view/PointerIcon;

    invoke-direct {v1, p1}, Landroid/view/PointerIcon;-><init>(I)V

    .line 140
    .local v1, icon:Landroid/view/PointerIcon;
    const/high16 v4, -0x100

    and-int/2addr v4, v2

    const/high16 v5, 0x100

    if-ne v4, v5, :cond_62

    .line 141
    iput v2, v1, Landroid/view/PointerIcon;->mSystemIconResourceId:I

    :goto_60
    move-object v4, v1

    .line 145
    goto :goto_11

    .line 143
    :cond_62
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-direct {v1, v4, v2}, Landroid/view/PointerIcon;->loadResource(Landroid/content/res/Resources;I)V

    goto :goto_60
.end method

.method private static getSystemIconStyleIndex(I)I
    .registers 2
    .parameter "style"

    .prologue
    const/4 v0, 0x0

    .line 422
    sparse-switch p0, :sswitch_data_c

    .line 432
    :goto_4
    :sswitch_4
    return v0

    .line 426
    :sswitch_5
    const/4 v0, 0x1

    goto :goto_4

    .line 428
    :sswitch_7
    const/4 v0, 0x2

    goto :goto_4

    .line 430
    :sswitch_9
    const/4 v0, 0x3

    goto :goto_4

    .line 422
    nop

    :sswitch_data_c
    .sparse-switch
        0x3e8 -> :sswitch_4
        0x7d0 -> :sswitch_5
        0x7d1 -> :sswitch_7
        0x7d2 -> :sswitch_9
    .end sparse-switch
.end method

.method public static loadCustomIcon(Landroid/content/res/Resources;I)Landroid/view/PointerIcon;
    .registers 5
    .parameter "resources"
    .parameter "resourceId"

    .prologue
    .line 196
    if-nez p0, :cond_b

    .line 197
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "resources must not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 200
    :cond_b
    new-instance v0, Landroid/view/PointerIcon;

    const/4 v1, -0x1

    invoke-direct {v0, v1}, Landroid/view/PointerIcon;-><init>(I)V

    .line 201
    .local v0, icon:Landroid/view/PointerIcon;
    invoke-direct {v0, p0, p1}, Landroid/view/PointerIcon;->loadResource(Landroid/content/res/Resources;I)V

    .line 202
    return-object v0
.end method

.method private loadResource(Landroid/content/res/Resources;I)V
    .registers 12
    .parameter "resources"
    .parameter "resourceId"

    .prologue
    .line 377
    invoke-virtual {p1, p2}, Landroid/content/res/Resources;->getXml(I)Landroid/content/res/XmlResourceParser;

    move-result-object v6

    .line 382
    .local v6, parser:Landroid/content/res/XmlResourceParser;
    :try_start_4
    const-string/jumbo v7, "pointer-icon"

    invoke-static {v6, v7}, Lcom/android/internal/util/XmlUtils;->beginDocument(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)V

    .line 384
    sget-object v7, Lcom/android/internal/R$styleable;->PointerIcon:[I

    invoke-virtual {p1, v6, v7}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 386
    .local v0, a:Landroid/content/res/TypedArray;
    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-virtual {v0, v7, v8}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v1

    .line 387
    .local v1, bitmapRes:I
    const/4 v7, 0x1

    const/4 v8, 0x0

    invoke-virtual {v0, v7, v8}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v4

    .line 388
    .local v4, hotSpotX:F
    const/4 v7, 0x2

    const/4 v8, 0x0

    invoke-virtual {v0, v7, v8}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v5

    .line 389
    .local v5, hotSpotY:F
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V
    :try_end_25
    .catchall {:try_start_4 .. :try_end_25} :catchall_3b
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_25} :catch_32

    .line 393
    invoke-interface {v6}, Landroid/content/res/XmlResourceParser;->close()V

    .line 396
    if-nez v1, :cond_40

    .line 397
    new-instance v7, Ljava/lang/IllegalArgumentException;

    const-string v8, "<pointer-icon> is missing bitmap attribute."

    invoke-direct {v7, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 390
    .end local v0           #a:Landroid/content/res/TypedArray;
    .end local v1           #bitmapRes:I
    .end local v4           #hotSpotX:F
    .end local v5           #hotSpotY:F
    :catch_32
    move-exception v3

    .line 391
    .local v3, ex:Ljava/lang/Exception;
    :try_start_33
    new-instance v7, Ljava/lang/IllegalArgumentException;

    const-string v8, "Exception parsing pointer icon resource."

    invoke-direct {v7, v8, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v7
    :try_end_3b
    .catchall {:try_start_33 .. :try_end_3b} :catchall_3b

    .line 393
    .end local v3           #ex:Ljava/lang/Exception;
    :catchall_3b
    move-exception v7

    invoke-interface {v6}, Landroid/content/res/XmlResourceParser;->close()V

    throw v7

    .line 400
    .restart local v0       #a:Landroid/content/res/TypedArray;
    .restart local v1       #bitmapRes:I
    .restart local v4       #hotSpotX:F
    .restart local v5       #hotSpotY:F
    :cond_40
    invoke-virtual {p1, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    .line 401
    .local v2, drawable:Landroid/graphics/drawable/Drawable;
    instance-of v7, v2, Landroid/graphics/drawable/BitmapDrawable;

    if-nez v7, :cond_50

    .line 402
    new-instance v7, Ljava/lang/IllegalArgumentException;

    const-string v8, "<pointer-icon> bitmap attribute must refer to a bitmap drawable."

    invoke-direct {v7, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 407
    :cond_50
    check-cast v2, Landroid/graphics/drawable/BitmapDrawable;

    .end local v2           #drawable:Landroid/graphics/drawable/Drawable;
    invoke-virtual {v2}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v7

    iput-object v7, p0, Landroid/view/PointerIcon;->mBitmap:Landroid/graphics/Bitmap;

    .line 408
    iput v4, p0, Landroid/view/PointerIcon;->mHotSpotX:F

    .line 409
    iput v5, p0, Landroid/view/PointerIcon;->mHotSpotY:F

    .line 410
    return-void
.end method

.method private throwIfIconIsNotLoaded()V
    .registers 3

    .prologue
    .line 303
    invoke-virtual {p0}, Landroid/view/PointerIcon;->isLoaded()Z

    move-result v0

    if-nez v0, :cond_e

    .line 304
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "The icon is not loaded."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 306
    :cond_e
    return-void
.end method

.method private static validateHotSpot(Landroid/graphics/Bitmap;FF)V
    .registers 5
    .parameter "bitmap"
    .parameter "hotSpotX"
    .parameter "hotSpotY"

    .prologue
    const/4 v1, 0x0

    .line 413
    cmpg-float v0, p1, v1

    if-ltz v0, :cond_e

    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v0

    int-to-float v0, v0

    cmpl-float v0, p1, v0

    if-ltz v0, :cond_17

    .line 414
    :cond_e
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "x hotspot lies outside of the bitmap area"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 416
    :cond_17
    cmpg-float v0, p2, v1

    if-ltz v0, :cond_24

    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v0

    int-to-float v0, v0

    cmpl-float v0, p2, v0

    if-ltz v0, :cond_2d

    .line 417
    :cond_24
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "y hotspot lies outside of the bitmap area"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 419
    :cond_2d
    return-void
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    .line 335
    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 7
    .parameter "other"

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 353
    if-ne p0, p1, :cond_5

    .line 373
    :cond_4
    :goto_4
    return v1

    .line 357
    :cond_5
    if-eqz p1, :cond_b

    instance-of v3, p1, Landroid/view/PointerIcon;

    if-nez v3, :cond_d

    :cond_b
    move v1, v2

    .line 358
    goto :goto_4

    :cond_d
    move-object v0, p1

    .line 361
    check-cast v0, Landroid/view/PointerIcon;

    .line 362
    .local v0, otherIcon:Landroid/view/PointerIcon;
    iget v3, p0, Landroid/view/PointerIcon;->mStyle:I

    iget v4, v0, Landroid/view/PointerIcon;->mStyle:I

    if-ne v3, v4, :cond_1c

    iget v3, p0, Landroid/view/PointerIcon;->mSystemIconResourceId:I

    iget v4, v0, Landroid/view/PointerIcon;->mSystemIconResourceId:I

    if-eq v3, v4, :cond_1e

    :cond_1c
    move v1, v2

    .line 364
    goto :goto_4

    .line 367
    :cond_1e
    iget v3, p0, Landroid/view/PointerIcon;->mSystemIconResourceId:I

    if-nez v3, :cond_4

    iget-object v3, p0, Landroid/view/PointerIcon;->mBitmap:Landroid/graphics/Bitmap;

    iget-object v4, v0, Landroid/view/PointerIcon;->mBitmap:Landroid/graphics/Bitmap;

    if-ne v3, v4, :cond_38

    iget v3, p0, Landroid/view/PointerIcon;->mHotSpotX:F

    iget v4, v0, Landroid/view/PointerIcon;->mHotSpotX:F

    cmpl-float v3, v3, v4

    if-nez v3, :cond_38

    iget v3, p0, Landroid/view/PointerIcon;->mHotSpotY:F

    iget v4, v0, Landroid/view/PointerIcon;->mHotSpotY:F

    cmpl-float v3, v3, v4

    if-eqz v3, :cond_4

    :cond_38
    move v1, v2

    .line 370
    goto :goto_4
.end method

.method public getBitmap()Landroid/graphics/Bitmap;
    .registers 2

    .prologue
    .line 270
    invoke-direct {p0}, Landroid/view/PointerIcon;->throwIfIconIsNotLoaded()V

    .line 271
    iget-object v0, p0, Landroid/view/PointerIcon;->mBitmap:Landroid/graphics/Bitmap;

    return-object v0
.end method

.method public getHotSpotX()F
    .registers 2

    .prologue
    .line 284
    invoke-direct {p0}, Landroid/view/PointerIcon;->throwIfIconIsNotLoaded()V

    .line 285
    iget v0, p0, Landroid/view/PointerIcon;->mHotSpotX:F

    return v0
.end method

.method public getHotSpotY()F
    .registers 2

    .prologue
    .line 298
    invoke-direct {p0}, Landroid/view/PointerIcon;->throwIfIconIsNotLoaded()V

    .line 299
    iget v0, p0, Landroid/view/PointerIcon;->mHotSpotY:F

    return v0
.end method

.method public getStyle()I
    .registers 2

    .prologue
    .line 257
    iget v0, p0, Landroid/view/PointerIcon;->mStyle:I

    return v0
.end method

.method public isLoaded()Z
    .registers 2

    .prologue
    .line 248
    iget-object v0, p0, Landroid/view/PointerIcon;->mBitmap:Landroid/graphics/Bitmap;

    if-nez v0, :cond_8

    iget v0, p0, Landroid/view/PointerIcon;->mStyle:I

    if-nez v0, :cond_a

    :cond_8
    const/4 v0, 0x1

    :goto_9
    return v0

    :cond_a
    const/4 v0, 0x0

    goto :goto_9
.end method

.method public isNullIcon()Z
    .registers 2

    .prologue
    .line 237
    iget v0, p0, Landroid/view/PointerIcon;->mStyle:I

    if-nez v0, :cond_6

    const/4 v0, 0x1

    :goto_5
    return v0

    :cond_6
    const/4 v0, 0x0

    goto :goto_5
.end method

.method public load(Landroid/content/Context;)Landroid/view/PointerIcon;
    .registers 5
    .parameter "context"

    .prologue
    .line 217
    if-nez p1, :cond_a

    .line 218
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "context must not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 221
    :cond_a
    iget v1, p0, Landroid/view/PointerIcon;->mSystemIconResourceId:I

    if-eqz v1, :cond_12

    iget-object v1, p0, Landroid/view/PointerIcon;->mBitmap:Landroid/graphics/Bitmap;

    if-eqz v1, :cond_14

    :cond_12
    move-object v0, p0

    .line 228
    :goto_13
    return-object v0

    .line 225
    :cond_14
    new-instance v0, Landroid/view/PointerIcon;

    iget v1, p0, Landroid/view/PointerIcon;->mStyle:I

    invoke-direct {v0, v1}, Landroid/view/PointerIcon;-><init>(I)V

    .line 226
    .local v0, result:Landroid/view/PointerIcon;
    iget v1, p0, Landroid/view/PointerIcon;->mSystemIconResourceId:I

    iput v1, v0, Landroid/view/PointerIcon;->mSystemIconResourceId:I

    .line 227
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    iget v2, p0, Landroid/view/PointerIcon;->mSystemIconResourceId:I

    invoke-direct {v0, v1, v2}, Landroid/view/PointerIcon;->loadResource(Landroid/content/res/Resources;I)V

    goto :goto_13
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 4
    .parameter "out"
    .parameter "flags"

    .prologue
    .line 339
    iget v0, p0, Landroid/view/PointerIcon;->mStyle:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 341
    iget v0, p0, Landroid/view/PointerIcon;->mStyle:I

    if-eqz v0, :cond_21

    .line 342
    iget v0, p0, Landroid/view/PointerIcon;->mSystemIconResourceId:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 343
    iget v0, p0, Landroid/view/PointerIcon;->mSystemIconResourceId:I

    if-nez v0, :cond_21

    .line 344
    iget-object v0, p0, Landroid/view/PointerIcon;->mBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v0, p1, p2}, Landroid/graphics/Bitmap;->writeToParcel(Landroid/os/Parcel;I)V

    .line 345
    iget v0, p0, Landroid/view/PointerIcon;->mHotSpotX:F

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeFloat(F)V

    .line 346
    iget v0, p0, Landroid/view/PointerIcon;->mHotSpotY:F

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeFloat(F)V

    .line 349
    :cond_21
    return-void
.end method
