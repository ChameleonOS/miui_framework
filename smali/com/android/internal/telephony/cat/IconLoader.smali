.class Lcom/android/internal/telephony/cat/IconLoader;
.super Landroid/os/Handler;
.source "IconLoader.java"


# static fields
.field private static final CLUT_ENTRY_SIZE:I = 0x3

.field private static final CLUT_LOCATION_OFFSET:I = 0x4

.field private static final EVENT_READ_CLUT_DONE:I = 0x3

.field private static final EVENT_READ_EF_IMG_RECOED_DONE:I = 0x1

.field private static final EVENT_READ_ICON_DONE:I = 0x2

.field private static final STATE_MULTI_ICONS:I = 0x2

.field private static final STATE_SINGLE_ICON:I = 0x1

.field private static sLoader:Lcom/android/internal/telephony/cat/IconLoader;


# instance fields
.field private mCurrentIcon:Landroid/graphics/Bitmap;

.field private mCurrentRecordIndex:I

.field private mEndMsg:Landroid/os/Message;

.field private mIconData:[B

.field private mIcons:[Landroid/graphics/Bitmap;

.field private mIconsCache:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation
.end field

.field private mId:Lcom/android/internal/telephony/cat/ImageDescriptor;

.field private mRecordNumber:I

.field private mRecordNumbers:[I

.field private mSimFH:Lcom/android/internal/telephony/IccFileHandler;

.field private mState:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    const/4 v0, 0x0

    sput-object v0, Lcom/android/internal/telephony/cat/IconLoader;->sLoader:Lcom/android/internal/telephony/cat/IconLoader;

    return-void
.end method

.method private constructor <init>(Landroid/os/Looper;Lcom/android/internal/telephony/IccFileHandler;)V
    .registers 5
    .parameter "looper"
    .parameter "fh"

    .prologue
    const/4 v1, 0x0

    invoke-direct {p0, p1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    const/4 v0, 0x1

    iput v0, p0, Lcom/android/internal/telephony/cat/IconLoader;->mState:I

    iput-object v1, p0, Lcom/android/internal/telephony/cat/IconLoader;->mId:Lcom/android/internal/telephony/cat/ImageDescriptor;

    iput-object v1, p0, Lcom/android/internal/telephony/cat/IconLoader;->mCurrentIcon:Landroid/graphics/Bitmap;

    iput-object v1, p0, Lcom/android/internal/telephony/cat/IconLoader;->mSimFH:Lcom/android/internal/telephony/IccFileHandler;

    iput-object v1, p0, Lcom/android/internal/telephony/cat/IconLoader;->mEndMsg:Landroid/os/Message;

    iput-object v1, p0, Lcom/android/internal/telephony/cat/IconLoader;->mIconData:[B

    iput-object v1, p0, Lcom/android/internal/telephony/cat/IconLoader;->mRecordNumbers:[I

    const/4 v0, 0x0

    iput v0, p0, Lcom/android/internal/telephony/cat/IconLoader;->mCurrentRecordIndex:I

    iput-object v1, p0, Lcom/android/internal/telephony/cat/IconLoader;->mIcons:[Landroid/graphics/Bitmap;

    iput-object v1, p0, Lcom/android/internal/telephony/cat/IconLoader;->mIconsCache:Ljava/util/HashMap;

    iput-object p2, p0, Lcom/android/internal/telephony/cat/IconLoader;->mSimFH:Lcom/android/internal/telephony/IccFileHandler;

    new-instance v0, Ljava/util/HashMap;

    const/16 v1, 0x32

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(I)V

    iput-object v0, p0, Lcom/android/internal/telephony/cat/IconLoader;->mIconsCache:Ljava/util/HashMap;

    return-void
.end method

.method private static bitToBnW(I)I
    .registers 2
    .parameter "bit"

    .prologue
    const/4 v0, 0x1

    if-ne p0, v0, :cond_5

    const/4 v0, -0x1

    :goto_4
    return v0

    :cond_5
    const/high16 v0, -0x100

    goto :goto_4
.end method

.method static getInstance(Landroid/os/Handler;Lcom/android/internal/telephony/IccFileHandler;)Lcom/android/internal/telephony/cat/IconLoader;
    .registers 5
    .parameter "caller"
    .parameter "fh"

    .prologue
    sget-object v1, Lcom/android/internal/telephony/cat/IconLoader;->sLoader:Lcom/android/internal/telephony/cat/IconLoader;

    if-eqz v1, :cond_7

    sget-object v1, Lcom/android/internal/telephony/cat/IconLoader;->sLoader:Lcom/android/internal/telephony/cat/IconLoader;

    :goto_6
    return-object v1

    :cond_7
    if-eqz p1, :cond_1d

    new-instance v0, Landroid/os/HandlerThread;

    const-string v1, "Cat Icon Loader"

    invoke-direct {v0, v1}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;)V

    .local v0, thread:Landroid/os/HandlerThread;
    invoke-virtual {v0}, Landroid/os/HandlerThread;->start()V

    new-instance v1, Lcom/android/internal/telephony/cat/IconLoader;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-direct {v1, v2, p1}, Lcom/android/internal/telephony/cat/IconLoader;-><init>(Landroid/os/Looper;Lcom/android/internal/telephony/IccFileHandler;)V

    goto :goto_6

    .end local v0           #thread:Landroid/os/HandlerThread;
    :cond_1d
    const/4 v1, 0x0

    goto :goto_6
.end method

.method private static getMask(I)I
    .registers 2
    .parameter "numOfBits"

    .prologue
    const/4 v0, 0x0

    .local v0, mask:I
    packed-switch p0, :pswitch_data_1a

    :goto_4
    return v0

    :pswitch_5
    const/4 v0, 0x1

    goto :goto_4

    :pswitch_7
    const/4 v0, 0x3

    goto :goto_4

    :pswitch_9
    const/4 v0, 0x7

    goto :goto_4

    :pswitch_b
    const/16 v0, 0xf

    goto :goto_4

    :pswitch_e
    const/16 v0, 0x1f

    goto :goto_4

    :pswitch_11
    const/16 v0, 0x3f

    goto :goto_4

    :pswitch_14
    const/16 v0, 0x7f

    goto :goto_4

    :pswitch_17
    const/16 v0, 0xff

    goto :goto_4

    :pswitch_data_1a
    .packed-switch 0x1
        :pswitch_5
        :pswitch_7
        :pswitch_9
        :pswitch_b
        :pswitch_e
        :pswitch_11
        :pswitch_14
        :pswitch_17
    .end packed-switch
.end method

.method private handleImageDescriptor([B)Z
    .registers 4
    .parameter "rawData"

    .prologue
    const/4 v0, 0x1

    invoke-static {p1, v0}, Lcom/android/internal/telephony/cat/ImageDescriptor;->parse([BI)Lcom/android/internal/telephony/cat/ImageDescriptor;

    move-result-object v1

    iput-object v1, p0, Lcom/android/internal/telephony/cat/IconLoader;->mId:Lcom/android/internal/telephony/cat/ImageDescriptor;

    iget-object v1, p0, Lcom/android/internal/telephony/cat/IconLoader;->mId:Lcom/android/internal/telephony/cat/ImageDescriptor;

    if-nez v1, :cond_c

    const/4 v0, 0x0

    :cond_c
    return v0
.end method

.method public static parseToBnW([BI)Landroid/graphics/Bitmap;
    .registers 15
    .parameter "data"
    .parameter "length"

    .prologue
    const/4 v8, 0x0

    .local v8, valueIndex:I
    add-int/lit8 v9, v8, 0x1

    .end local v8           #valueIndex:I
    .local v9, valueIndex:I
    aget-byte v11, p0, v8

    and-int/lit16 v10, v11, 0xff

    .local v10, width:I
    add-int/lit8 v8, v9, 0x1

    .end local v9           #valueIndex:I
    .restart local v8       #valueIndex:I
    aget-byte v11, p0, v9

    and-int/lit16 v3, v11, 0xff

    .local v3, height:I
    mul-int v4, v10, v3

    .local v4, numOfPixels:I
    new-array v7, v4, [I

    .local v7, pixels:[I
    const/4 v5, 0x0

    .local v5, pixelIndex:I
    const/4 v0, 0x7

    .local v0, bitIndex:I
    const/4 v2, 0x0

    .local v2, currentByte:B
    move v6, v5

    .end local v5           #pixelIndex:I
    .local v6, pixelIndex:I
    move v9, v8

    .end local v8           #valueIndex:I
    .restart local v9       #valueIndex:I
    :goto_16
    if-ge v6, v4, :cond_33

    rem-int/lit8 v11, v6, 0x8

    if-nez v11, :cond_44

    add-int/lit8 v8, v9, 0x1

    .end local v9           #valueIndex:I
    .restart local v8       #valueIndex:I
    aget-byte v2, p0, v9

    const/4 v0, 0x7

    :goto_21
    add-int/lit8 v5, v6, 0x1

    .end local v6           #pixelIndex:I
    .restart local v5       #pixelIndex:I
    add-int/lit8 v1, v0, -0x1

    .end local v0           #bitIndex:I
    .local v1, bitIndex:I
    shr-int v11, v2, v0

    and-int/lit8 v11, v11, 0x1

    invoke-static {v11}, Lcom/android/internal/telephony/cat/IconLoader;->bitToBnW(I)I

    move-result v11

    aput v11, v7, v6

    move v0, v1

    .end local v1           #bitIndex:I
    .restart local v0       #bitIndex:I
    move v6, v5

    .end local v5           #pixelIndex:I
    .restart local v6       #pixelIndex:I
    move v9, v8

    .end local v8           #valueIndex:I
    .restart local v9       #valueIndex:I
    goto :goto_16

    :cond_33
    if-eq v6, v4, :cond_3d

    const-string v11, "IconLoader"

    const-string/jumbo v12, "parseToBnW; size error"

    invoke-static {v11, v12}, Lcom/android/internal/telephony/cat/CatLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    :cond_3d
    sget-object v11, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v7, v10, v3, v11}, Landroid/graphics/Bitmap;->createBitmap([IIILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v11

    return-object v11

    :cond_44
    move v8, v9

    .end local v9           #valueIndex:I
    .restart local v8       #valueIndex:I
    goto :goto_21
.end method

.method public static parseToRGB([BIZ[B)Landroid/graphics/Bitmap;
    .registers 26
    .parameter "data"
    .parameter "length"
    .parameter "transparency"
    .parameter "clut"

    .prologue
    const/16 v16, 0x0

    .local v16, valueIndex:I
    add-int/lit8 v17, v16, 0x1

    .end local v16           #valueIndex:I
    .local v17, valueIndex:I
    aget-byte v19, p0, v16

    move/from16 v0, v19

    and-int/lit16 v0, v0, 0xff

    move/from16 v18, v0

    .local v18, width:I
    add-int/lit8 v16, v17, 0x1

    .end local v17           #valueIndex:I
    .restart local v16       #valueIndex:I
    aget-byte v19, p0, v17

    move/from16 v0, v19

    and-int/lit16 v9, v0, 0xff

    .local v9, height:I
    add-int/lit8 v17, v16, 0x1

    .end local v16           #valueIndex:I
    .restart local v17       #valueIndex:I
    aget-byte v19, p0, v16

    move/from16 v0, v19

    and-int/lit16 v4, v0, 0xff

    .local v4, bitsPerImg:I
    add-int/lit8 v16, v17, 0x1

    .end local v17           #valueIndex:I
    .restart local v16       #valueIndex:I
    aget-byte v19, p0, v17

    move/from16 v0, v19

    and-int/lit16 v11, v0, 0xff

    .local v11, numOfClutEntries:I
    const/16 v19, 0x1

    move/from16 v0, v19

    move/from16 v1, p2

    if-ne v0, v1, :cond_32

    add-int/lit8 v19, v11, -0x1

    const/16 v20, 0x0

    aput-byte v20, p3, v19

    :cond_32
    mul-int v12, v18, v9

    .local v12, numOfPixels:I
    new-array v15, v12, [I

    .local v15, pixels:[I
    const/16 v16, 0x6

    const/4 v13, 0x0

    .local v13, pixelIndex:I
    rsub-int/lit8 v5, v4, 0x8

    .local v5, bitsStartOffset:I
    move v2, v5

    .local v2, bitIndex:I
    add-int/lit8 v17, v16, 0x1

    .end local v16           #valueIndex:I
    .restart local v17       #valueIndex:I
    aget-byte v8, p0, v16

    .local v8, currentByte:B
    invoke-static {v4}, Lcom/android/internal/telephony/cat/IconLoader;->getMask(I)I

    move-result v10

    .local v10, mask:I
    const/16 v19, 0x8

    rem-int v19, v19, v4

    if-nez v19, :cond_74

    const/4 v3, 0x1

    .local v3, bitsOverlaps:Z
    :goto_4b
    move v14, v13

    .end local v13           #pixelIndex:I
    .local v14, pixelIndex:I
    :goto_4c
    if-ge v14, v12, :cond_79

    if-gez v2, :cond_84

    add-int/lit8 v16, v17, 0x1

    .end local v17           #valueIndex:I
    .restart local v16       #valueIndex:I
    aget-byte v8, p0, v17

    if-eqz v3, :cond_76

    move v2, v5

    :goto_57
    shr-int v19, v8, v2

    and-int v6, v19, v10

    .local v6, clutEntry:I
    mul-int/lit8 v7, v6, 0x3

    .local v7, clutIndex:I
    add-int/lit8 v13, v14, 0x1

    .end local v14           #pixelIndex:I
    .restart local v13       #pixelIndex:I
    aget-byte v19, p3, v7

    add-int/lit8 v20, v7, 0x1

    aget-byte v20, p3, v20

    add-int/lit8 v21, v7, 0x2

    aget-byte v21, p3, v21

    invoke-static/range {v19 .. v21}, Landroid/graphics/Color;->rgb(III)I

    move-result v19

    aput v19, v15, v14

    sub-int/2addr v2, v4

    move v14, v13

    .end local v13           #pixelIndex:I
    .restart local v14       #pixelIndex:I
    move/from16 v17, v16

    .end local v16           #valueIndex:I
    .restart local v17       #valueIndex:I
    goto :goto_4c

    .end local v3           #bitsOverlaps:Z
    .end local v6           #clutEntry:I
    .end local v7           #clutIndex:I
    .end local v14           #pixelIndex:I
    .restart local v13       #pixelIndex:I
    :cond_74
    const/4 v3, 0x0

    goto :goto_4b

    .end local v13           #pixelIndex:I
    .end local v17           #valueIndex:I
    .restart local v3       #bitsOverlaps:Z
    .restart local v14       #pixelIndex:I
    .restart local v16       #valueIndex:I
    :cond_76
    mul-int/lit8 v2, v2, -0x1

    goto :goto_57

    .end local v16           #valueIndex:I
    .restart local v17       #valueIndex:I
    :cond_79
    sget-object v19, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    move/from16 v0, v18

    move-object/from16 v1, v19

    invoke-static {v15, v0, v9, v1}, Landroid/graphics/Bitmap;->createBitmap([IIILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v19

    return-object v19

    :cond_84
    move/from16 v16, v17

    .end local v17           #valueIndex:I
    .restart local v16       #valueIndex:I
    goto :goto_57
.end method

.method private postIcon()V
    .registers 4

    .prologue
    iget v0, p0, Lcom/android/internal/telephony/cat/IconLoader;->mState:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_11

    iget-object v0, p0, Lcom/android/internal/telephony/cat/IconLoader;->mEndMsg:Landroid/os/Message;

    iget-object v1, p0, Lcom/android/internal/telephony/cat/IconLoader;->mCurrentIcon:Landroid/graphics/Bitmap;

    iput-object v1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    iget-object v0, p0, Lcom/android/internal/telephony/cat/IconLoader;->mEndMsg:Landroid/os/Message;

    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    :cond_10
    :goto_10
    return-void

    :cond_11
    iget v0, p0, Lcom/android/internal/telephony/cat/IconLoader;->mState:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_10

    iget-object v0, p0, Lcom/android/internal/telephony/cat/IconLoader;->mIcons:[Landroid/graphics/Bitmap;

    iget v1, p0, Lcom/android/internal/telephony/cat/IconLoader;->mCurrentRecordIndex:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/android/internal/telephony/cat/IconLoader;->mCurrentRecordIndex:I

    iget-object v2, p0, Lcom/android/internal/telephony/cat/IconLoader;->mCurrentIcon:Landroid/graphics/Bitmap;

    aput-object v2, v0, v1

    iget v0, p0, Lcom/android/internal/telephony/cat/IconLoader;->mCurrentRecordIndex:I

    iget-object v1, p0, Lcom/android/internal/telephony/cat/IconLoader;->mRecordNumbers:[I

    array-length v1, v1

    if-ge v0, v1, :cond_33

    iget-object v0, p0, Lcom/android/internal/telephony/cat/IconLoader;->mRecordNumbers:[I

    iget v1, p0, Lcom/android/internal/telephony/cat/IconLoader;->mCurrentRecordIndex:I

    aget v0, v0, v1

    invoke-direct {p0, v0}, Lcom/android/internal/telephony/cat/IconLoader;->startLoadingIcon(I)V

    goto :goto_10

    :cond_33
    iget-object v0, p0, Lcom/android/internal/telephony/cat/IconLoader;->mEndMsg:Landroid/os/Message;

    iget-object v1, p0, Lcom/android/internal/telephony/cat/IconLoader;->mIcons:[Landroid/graphics/Bitmap;

    iput-object v1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    iget-object v0, p0, Lcom/android/internal/telephony/cat/IconLoader;->mEndMsg:Landroid/os/Message;

    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    goto :goto_10
.end method

.method private readClut()V
    .registers 8

    .prologue
    const/4 v1, 0x3

    iget-object v0, p0, Lcom/android/internal/telephony/cat/IconLoader;->mIconData:[B

    aget-byte v0, v0, v1

    mul-int/lit8 v4, v0, 0x3

    .local v4, length:I
    invoke-virtual {p0, v1}, Lcom/android/internal/telephony/cat/IconLoader;->obtainMessage(I)Landroid/os/Message;

    move-result-object v5

    .local v5, msg:Landroid/os/Message;
    iget-object v0, p0, Lcom/android/internal/telephony/cat/IconLoader;->mSimFH:Lcom/android/internal/telephony/IccFileHandler;

    iget-object v1, p0, Lcom/android/internal/telephony/cat/IconLoader;->mId:Lcom/android/internal/telephony/cat/ImageDescriptor;

    iget v1, v1, Lcom/android/internal/telephony/cat/ImageDescriptor;->imageId:I

    iget-object v2, p0, Lcom/android/internal/telephony/cat/IconLoader;->mIconData:[B

    const/4 v3, 0x4

    aget-byte v2, v2, v3

    iget-object v3, p0, Lcom/android/internal/telephony/cat/IconLoader;->mIconData:[B

    const/4 v6, 0x5

    aget-byte v3, v3, v6

    invoke-virtual/range {v0 .. v5}, Lcom/android/internal/telephony/IccFileHandler;->loadEFImgTransparent(IIIILandroid/os/Message;)V

    return-void
.end method

.method private readIconData()V
    .registers 7

    .prologue
    const/4 v2, 0x0

    const/4 v0, 0x2

    invoke-virtual {p0, v0}, Lcom/android/internal/telephony/cat/IconLoader;->obtainMessage(I)Landroid/os/Message;

    move-result-object v5

    .local v5, msg:Landroid/os/Message;
    iget-object v0, p0, Lcom/android/internal/telephony/cat/IconLoader;->mSimFH:Lcom/android/internal/telephony/IccFileHandler;

    iget-object v1, p0, Lcom/android/internal/telephony/cat/IconLoader;->mId:Lcom/android/internal/telephony/cat/ImageDescriptor;

    iget v1, v1, Lcom/android/internal/telephony/cat/ImageDescriptor;->imageId:I

    iget-object v3, p0, Lcom/android/internal/telephony/cat/IconLoader;->mId:Lcom/android/internal/telephony/cat/ImageDescriptor;

    iget v4, v3, Lcom/android/internal/telephony/cat/ImageDescriptor;->length:I

    move v3, v2

    invoke-virtual/range {v0 .. v5}, Lcom/android/internal/telephony/IccFileHandler;->loadEFImgTransparent(IIIILandroid/os/Message;)V

    return-void
.end method

.method private readId()V
    .registers 4

    .prologue
    iget v1, p0, Lcom/android/internal/telephony/cat/IconLoader;->mRecordNumber:I

    if-gez v1, :cond_b

    const/4 v1, 0x0

    iput-object v1, p0, Lcom/android/internal/telephony/cat/IconLoader;->mCurrentIcon:Landroid/graphics/Bitmap;

    invoke-direct {p0}, Lcom/android/internal/telephony/cat/IconLoader;->postIcon()V

    :goto_a
    return-void

    :cond_b
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lcom/android/internal/telephony/cat/IconLoader;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    .local v0, msg:Landroid/os/Message;
    iget-object v1, p0, Lcom/android/internal/telephony/cat/IconLoader;->mSimFH:Lcom/android/internal/telephony/IccFileHandler;

    iget v2, p0, Lcom/android/internal/telephony/cat/IconLoader;->mRecordNumber:I

    invoke-virtual {v1, v2, v0}, Lcom/android/internal/telephony/IccFileHandler;->loadEFImgLinearFixed(ILandroid/os/Message;)V

    goto :goto_a
.end method

.method private startLoadingIcon(I)V
    .registers 4
    .parameter "recordNumber"

    .prologue
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/internal/telephony/cat/IconLoader;->mId:Lcom/android/internal/telephony/cat/ImageDescriptor;

    iput-object v0, p0, Lcom/android/internal/telephony/cat/IconLoader;->mIconData:[B

    iput-object v0, p0, Lcom/android/internal/telephony/cat/IconLoader;->mCurrentIcon:Landroid/graphics/Bitmap;

    iput p1, p0, Lcom/android/internal/telephony/cat/IconLoader;->mRecordNumber:I

    iget-object v0, p0, Lcom/android/internal/telephony/cat/IconLoader;->mIconsCache:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_27

    iget-object v0, p0, Lcom/android/internal/telephony/cat/IconLoader;->mIconsCache:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/Bitmap;

    iput-object v0, p0, Lcom/android/internal/telephony/cat/IconLoader;->mCurrentIcon:Landroid/graphics/Bitmap;

    invoke-direct {p0}, Lcom/android/internal/telephony/cat/IconLoader;->postIcon()V

    :goto_26
    return-void

    :cond_27
    invoke-direct {p0}, Lcom/android/internal/telephony/cat/IconLoader;->readId()V

    goto :goto_26
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .registers 10
    .parameter "msg"

    .prologue
    :try_start_0
    iget v5, p1, Landroid/os/Message;->what:I

    packed-switch v5, :pswitch_data_90

    :cond_5
    :goto_5
    return-void

    :pswitch_6
    iget-object v1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v1, Landroid/os/AsyncResult;

    .local v1, ar:Landroid/os/AsyncResult;
    iget-object v5, v1, Landroid/os/AsyncResult;->result:Ljava/lang/Object;

    check-cast v5, [B

    check-cast v5, [B

    invoke-direct {p0, v5}, Lcom/android/internal/telephony/cat/IconLoader;->handleImageDescriptor([B)Z

    move-result v5

    if-eqz v5, :cond_24

    invoke-direct {p0}, Lcom/android/internal/telephony/cat/IconLoader;->readIconData()V
    :try_end_19
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_19} :catch_1a

    goto :goto_5

    .end local v1           #ar:Landroid/os/AsyncResult;
    :catch_1a
    move-exception v3

    .local v3, e:Ljava/lang/Exception;
    const-string v5, "Icon load failed"

    invoke-static {p0, v5}, Lcom/android/internal/telephony/cat/CatLog;->d(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/android/internal/telephony/cat/IconLoader;->postIcon()V

    goto :goto_5

    .end local v3           #e:Ljava/lang/Exception;
    .restart local v1       #ar:Landroid/os/AsyncResult;
    :cond_24
    :try_start_24
    new-instance v5, Ljava/lang/Exception;

    const-string v6, "Unable to parse image descriptor"

    invoke-direct {v5, v6}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v5

    .end local v1           #ar:Landroid/os/AsyncResult;
    :pswitch_2c
    iget-object v1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v1, Landroid/os/AsyncResult;

    .restart local v1       #ar:Landroid/os/AsyncResult;
    iget-object v5, v1, Landroid/os/AsyncResult;->result:Ljava/lang/Object;

    check-cast v5, [B

    move-object v0, v5

    check-cast v0, [B

    move-object v4, v0

    .local v4, rawData:[B
    iget-object v5, p0, Lcom/android/internal/telephony/cat/IconLoader;->mId:Lcom/android/internal/telephony/cat/ImageDescriptor;

    iget v5, v5, Lcom/android/internal/telephony/cat/ImageDescriptor;->codingScheme:I

    const/16 v6, 0x11

    if-ne v5, v6, :cond_58

    array-length v5, v4

    invoke-static {v4, v5}, Lcom/android/internal/telephony/cat/IconLoader;->parseToBnW([BI)Landroid/graphics/Bitmap;

    move-result-object v5

    iput-object v5, p0, Lcom/android/internal/telephony/cat/IconLoader;->mCurrentIcon:Landroid/graphics/Bitmap;

    iget-object v5, p0, Lcom/android/internal/telephony/cat/IconLoader;->mIconsCache:Ljava/util/HashMap;

    iget v6, p0, Lcom/android/internal/telephony/cat/IconLoader;->mRecordNumber:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    iget-object v7, p0, Lcom/android/internal/telephony/cat/IconLoader;->mCurrentIcon:Landroid/graphics/Bitmap;

    invoke-virtual {v5, v6, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-direct {p0}, Lcom/android/internal/telephony/cat/IconLoader;->postIcon()V

    goto :goto_5

    :cond_58
    iget-object v5, p0, Lcom/android/internal/telephony/cat/IconLoader;->mId:Lcom/android/internal/telephony/cat/ImageDescriptor;

    iget v5, v5, Lcom/android/internal/telephony/cat/ImageDescriptor;->codingScheme:I

    const/16 v6, 0x21

    if-ne v5, v6, :cond_5

    iput-object v4, p0, Lcom/android/internal/telephony/cat/IconLoader;->mIconData:[B

    invoke-direct {p0}, Lcom/android/internal/telephony/cat/IconLoader;->readClut()V

    goto :goto_5

    .end local v1           #ar:Landroid/os/AsyncResult;
    .end local v4           #rawData:[B
    :pswitch_66
    iget-object v1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v1, Landroid/os/AsyncResult;

    .restart local v1       #ar:Landroid/os/AsyncResult;
    iget-object v5, v1, Landroid/os/AsyncResult;->result:Ljava/lang/Object;

    check-cast v5, [B

    move-object v0, v5

    check-cast v0, [B

    move-object v2, v0

    .local v2, clut:[B
    iget-object v5, p0, Lcom/android/internal/telephony/cat/IconLoader;->mIconData:[B

    iget-object v6, p0, Lcom/android/internal/telephony/cat/IconLoader;->mIconData:[B

    array-length v6, v6

    const/4 v7, 0x0

    invoke-static {v5, v6, v7, v2}, Lcom/android/internal/telephony/cat/IconLoader;->parseToRGB([BIZ[B)Landroid/graphics/Bitmap;

    move-result-object v5

    iput-object v5, p0, Lcom/android/internal/telephony/cat/IconLoader;->mCurrentIcon:Landroid/graphics/Bitmap;

    iget-object v5, p0, Lcom/android/internal/telephony/cat/IconLoader;->mIconsCache:Ljava/util/HashMap;

    iget v6, p0, Lcom/android/internal/telephony/cat/IconLoader;->mRecordNumber:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    iget-object v7, p0, Lcom/android/internal/telephony/cat/IconLoader;->mCurrentIcon:Landroid/graphics/Bitmap;

    invoke-virtual {v5, v6, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-direct {p0}, Lcom/android/internal/telephony/cat/IconLoader;->postIcon()V
    :try_end_8e
    .catch Ljava/lang/Exception; {:try_start_24 .. :try_end_8e} :catch_1a

    goto/16 :goto_5

    :pswitch_data_90
    .packed-switch 0x1
        :pswitch_6
        :pswitch_2c
        :pswitch_66
    .end packed-switch
.end method

.method loadIcon(ILandroid/os/Message;)V
    .registers 4
    .parameter "recordNumber"
    .parameter "msg"

    .prologue
    if-nez p2, :cond_3

    :goto_2
    return-void

    :cond_3
    iput-object p2, p0, Lcom/android/internal/telephony/cat/IconLoader;->mEndMsg:Landroid/os/Message;

    const/4 v0, 0x1

    iput v0, p0, Lcom/android/internal/telephony/cat/IconLoader;->mState:I

    invoke-direct {p0, p1}, Lcom/android/internal/telephony/cat/IconLoader;->startLoadingIcon(I)V

    goto :goto_2
.end method

.method loadIcons([ILandroid/os/Message;)V
    .registers 5
    .parameter "recordNumbers"
    .parameter "msg"

    .prologue
    const/4 v1, 0x0

    if-eqz p1, :cond_8

    array-length v0, p1

    if-eqz v0, :cond_8

    if-nez p2, :cond_9

    :cond_8
    :goto_8
    return-void

    :cond_9
    iput-object p2, p0, Lcom/android/internal/telephony/cat/IconLoader;->mEndMsg:Landroid/os/Message;

    array-length v0, p1

    new-array v0, v0, [Landroid/graphics/Bitmap;

    iput-object v0, p0, Lcom/android/internal/telephony/cat/IconLoader;->mIcons:[Landroid/graphics/Bitmap;

    iput-object p1, p0, Lcom/android/internal/telephony/cat/IconLoader;->mRecordNumbers:[I

    iput v1, p0, Lcom/android/internal/telephony/cat/IconLoader;->mCurrentRecordIndex:I

    const/4 v0, 0x2

    iput v0, p0, Lcom/android/internal/telephony/cat/IconLoader;->mState:I

    aget v0, p1, v1

    invoke-direct {p0, v0}, Lcom/android/internal/telephony/cat/IconLoader;->startLoadingIcon(I)V

    goto :goto_8
.end method
