.class Landroid/content/res/SimulateNinePngUtil;
.super Ljava/lang/Object;
.source "SimulateNinePngUtil.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/content/res/SimulateNinePngUtil$NinePathInputStream;
    }
.end annotation


# static fields
.field private static PNG_HEAD_FORMAT:[B


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    const/16 v0, 0x8

    new-array v0, v0, [B

    fill-array-data v0, :array_a

    sput-object v0, Landroid/content/res/SimulateNinePngUtil;->PNG_HEAD_FORMAT:[B

    return-void

    :array_a
    .array-data 0x1
        0x89t
        0x50t
        0x4et
        0x47t
        0xdt
        0xat
        0x1at
        0xat
    .end array-data
.end method

.method constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static computePatchColor([B)I
    .registers 2
    .parameter "srcImageData"

    .prologue
    const/4 v0, 0x1

    return v0
.end method

.method private static convertByteToIntByBigEndian([BI)I
    .registers 4
    .parameter "data"
    .parameter "start"

    .prologue
    const/4 v0, 0x0

    .local v0, ret:I
    add-int/lit8 v1, p1, 0x0

    aget-byte v1, p0, v1

    and-int/lit16 v1, v1, 0xff

    shl-int/lit8 v1, v1, 0x18

    add-int/2addr v0, v1

    add-int/lit8 v1, p1, 0x1

    aget-byte v1, p0, v1

    and-int/lit16 v1, v1, 0xff

    shl-int/lit8 v1, v1, 0x10

    add-int/2addr v0, v1

    add-int/lit8 v1, p1, 0x2

    aget-byte v1, p0, v1

    and-int/lit16 v1, v1, 0xff

    shl-int/lit8 v1, v1, 0x8

    add-int/2addr v0, v1

    add-int/lit8 v1, p1, 0x3

    aget-byte v1, p0, v1

    and-int/lit16 v1, v1, 0xff

    add-int/2addr v0, v1

    return v0
.end method

.method private static convertBytesFromIntByBigEndian([BII)V
    .registers 5
    .parameter "data"
    .parameter "start"
    .parameter "N"

    .prologue
    add-int/lit8 v0, p1, 0x0

    ushr-int/lit8 v1, p2, 0x18

    and-int/lit16 v1, v1, 0xff

    int-to-byte v1, v1

    aput-byte v1, p0, v0

    add-int/lit8 v0, p1, 0x1

    shr-int/lit8 v1, p2, 0x10

    and-int/lit16 v1, v1, 0xff

    int-to-byte v1, v1

    aput-byte v1, p0, v0

    add-int/lit8 v0, p1, 0x2

    shr-int/lit8 v1, p2, 0x8

    and-int/lit16 v1, v1, 0xff

    int-to-byte v1, v1

    aput-byte v1, p0, v0

    add-int/lit8 v0, p1, 0x3

    and-int/lit16 v1, p2, 0xff

    int-to-byte v1, v1

    aput-byte v1, p0, v0

    return-void
.end method

.method public static convertIntoNinePngData([B)[B
    .registers 11
    .parameter "srcData"

    .prologue
    const/16 v9, 0x21

    if-eqz p0, :cond_f

    array-length v7, p0

    const/16 v8, 0x29

    if-lt v7, v8, :cond_f

    invoke-static {p0}, Landroid/content/res/SimulateNinePngUtil;->isPngFormat([B)Z

    move-result v7

    if-nez v7, :cond_11

    :cond_f
    const/4 p0, 0x0

    .end local p0
    :cond_10
    :goto_10
    return-object p0

    .restart local p0
    :cond_11
    invoke-static {p0}, Landroid/content/res/SimulateNinePngUtil;->isNinePngFormat([B)Z

    move-result v7

    if-nez v7, :cond_10

    invoke-static {p0}, Landroid/content/res/SimulateNinePngUtil;->getNinePatchChunk([B)[B

    move-result-object v5

    .local v5, ninePatchChunk:[B
    array-length v7, p0

    add-int/lit8 v7, v7, 0xc

    array-length v8, v5

    add-int/2addr v7, v8

    new-array v3, v7, [B

    .local v3, destData:[B
    const/16 v6, 0x21

    .local v6, pngHeadEnd:I
    const/4 v4, 0x0

    .local v4, i:I
    :goto_25
    if-ge v4, v9, :cond_2e

    aget-byte v7, p0, v4

    aput-byte v7, v3, v4

    add-int/lit8 v4, v4, 0x1

    goto :goto_25

    :cond_2e
    array-length v7, v5

    invoke-static {v3, v9, v7}, Landroid/content/res/SimulateNinePngUtil;->convertBytesFromIntByBigEndian([BII)V

    invoke-static {v3}, Landroid/content/res/SimulateNinePngUtil;->fillNinePngFormatMark([B)V

    const/16 v0, 0x29

    .local v0, chunkHeadStart:I
    const/4 v4, 0x0

    :goto_38
    array-length v7, v5

    if-ge v4, v7, :cond_44

    add-int/lit8 v7, v4, 0x29

    aget-byte v8, v5, v4

    aput-byte v8, v3, v7

    add-int/lit8 v4, v4, 0x1

    goto :goto_38

    :cond_44
    array-length v7, v5

    add-int/lit8 v2, v7, 0x29

    .local v2, crcPostion:I
    new-instance v1, Ljava/util/zip/CRC32;

    invoke-direct {v1}, Ljava/util/zip/CRC32;-><init>()V

    .local v1, crc:Ljava/util/zip/CRC32;
    const/16 v7, 0x25

    array-length v8, v5

    add-int/lit8 v8, v8, 0x4

    invoke-virtual {v1, v3, v7, v8}, Ljava/util/zip/CRC32;->update([BII)V

    invoke-virtual {v1}, Ljava/util/zip/CRC32;->getValue()J

    move-result-wide v7

    long-to-int v7, v7

    invoke-static {v3, v2, v7}, Landroid/content/res/SimulateNinePngUtil;->convertBytesFromIntByBigEndian([BII)V

    const/4 v4, 0x0

    :goto_5d
    array-length v7, p0

    add-int/lit8 v7, v7, -0x21

    if-ge v4, v7, :cond_6e

    add-int/lit8 v7, v2, 0x4

    add-int/2addr v7, v4

    add-int/lit8 v8, v4, 0x21

    aget-byte v8, p0, v8

    aput-byte v8, v3, v7

    add-int/lit8 v4, v4, 0x1

    goto :goto_5d

    :cond_6e
    move-object p0, v3

    goto :goto_10
.end method

.method public static convertIntoNinePngStream(Ljava/io/InputStream;)Ljava/io/InputStream;
    .registers 8
    .parameter "pngInputStream"

    .prologue
    const/4 v3, 0x0

    .local v3, retStream:Ljava/io/InputStream;
    const/16 v6, 0x29

    :try_start_3
    new-array v5, v6, [B

    .local v5, srcHeader:[B
    invoke-virtual {p0, v5}, Ljava/io/InputStream;->read([B)I

    move-result v1

    .local v1, n:I
    if-gtz v1, :cond_19

    const/4 v5, 0x0

    :cond_c
    :goto_c
    invoke-static {v5}, Landroid/content/res/SimulateNinePngUtil;->convertIntoNinePngData([B)[B

    move-result-object v2

    .local v2, nineHeader:[B
    if-eqz v2, :cond_18

    new-instance v4, Landroid/content/res/SimulateNinePngUtil$NinePathInputStream;

    invoke-direct {v4, p0, v2}, Landroid/content/res/SimulateNinePngUtil$NinePathInputStream;-><init>(Ljava/io/InputStream;[B)V

    .end local v3           #retStream:Ljava/io/InputStream;
    .local v4, retStream:Ljava/io/InputStream;
    move-object v3, v4

    .end local v1           #n:I
    .end local v2           #nineHeader:[B
    .end local v4           #retStream:Ljava/io/InputStream;
    .end local v5           #srcHeader:[B
    .restart local v3       #retStream:Ljava/io/InputStream;
    :cond_18
    :goto_18
    return-object v3

    .restart local v1       #n:I
    .restart local v5       #srcHeader:[B
    :cond_19
    array-length v6, v5

    if-ge v1, v6, :cond_c

    invoke-static {v5, v1}, Ljava/util/Arrays;->copyOf([BI)[B
    :try_end_1f
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_1f} :catch_21

    move-result-object v5

    goto :goto_c

    .end local v1           #n:I
    .end local v5           #srcHeader:[B
    :catch_21
    move-exception v0

    .local v0, e:Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_18
.end method

.method private static fillNinePngFormatMark([B)V
    .registers 3
    .parameter "data"

    .prologue
    const/16 v0, 0x25

    const/16 v1, 0x6e

    aput-byte v1, p0, v0

    const/16 v0, 0x26

    const/16 v1, 0x70

    aput-byte v1, p0, v0

    const/16 v0, 0x27

    const/16 v1, 0x54

    aput-byte v1, p0, v0

    const/16 v0, 0x28

    const/16 v1, 0x63

    aput-byte v1, p0, v0

    return-void
.end method

.method private static getNinePatchChunk([B)[B
    .registers 7
    .parameter "srcImageData"

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/16 v3, 0x10

    invoke-static {p0, v3}, Landroid/content/res/SimulateNinePngUtil;->convertByteToIntByBigEndian([BI)I

    move-result v2

    .local v2, width:I
    const/16 v3, 0x14

    invoke-static {p0, v3}, Landroid/content/res/SimulateNinePngUtil;->convertByteToIntByBigEndian([BI)I

    move-result v1

    .local v1, height:I
    const/16 v3, 0x34

    new-array v0, v3, [B

    .local v0, chunk:[B
    const/4 v3, 0x0

    aput-byte v4, v0, v3

    aput-byte v5, v0, v4

    aput-byte v5, v0, v5

    const/4 v3, 0x3

    aput-byte v4, v0, v3

    const/16 v3, 0x24

    invoke-static {v0, v3, v2}, Landroid/content/res/SimulateNinePngUtil;->convertBytesFromIntByBigEndian([BII)V

    const/16 v3, 0x2c

    invoke-static {v0, v3, v1}, Landroid/content/res/SimulateNinePngUtil;->convertBytesFromIntByBigEndian([BII)V

    const/16 v3, 0x30

    invoke-static {p0}, Landroid/content/res/SimulateNinePngUtil;->computePatchColor([B)I

    move-result v4

    invoke-static {v0, v3, v4}, Landroid/content/res/SimulateNinePngUtil;->convertBytesFromIntByBigEndian([BII)V

    return-object v0
.end method

.method private static isNinePngFormat([B)Z
    .registers 4
    .parameter "data"

    .prologue
    const/16 v2, 0x28

    if-eqz p0, :cond_27

    array-length v0, p0

    if-le v0, v2, :cond_27

    const/16 v0, 0x25

    aget-byte v0, p0, v0

    const/16 v1, 0x6e

    if-ne v0, v1, :cond_27

    const/16 v0, 0x26

    aget-byte v0, p0, v0

    const/16 v1, 0x70

    if-ne v0, v1, :cond_27

    const/16 v0, 0x27

    aget-byte v0, p0, v0

    const/16 v1, 0x54

    if-ne v0, v1, :cond_27

    aget-byte v0, p0, v2

    const/16 v1, 0x63

    if-ne v0, v1, :cond_27

    const/4 v0, 0x1

    :goto_26
    return v0

    :cond_27
    const/4 v0, 0x0

    goto :goto_26
.end method

.method private static isPngFormat([B)Z
    .registers 4
    .parameter "data"

    .prologue
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1
    sget-object v1, Landroid/content/res/SimulateNinePngUtil;->PNG_HEAD_FORMAT:[B

    array-length v1, v1

    if-ge v0, v1, :cond_13

    aget-byte v1, p0, v0

    sget-object v2, Landroid/content/res/SimulateNinePngUtil;->PNG_HEAD_FORMAT:[B

    aget-byte v2, v2, v0

    if-eq v1, v2, :cond_10

    const/4 v1, 0x0

    :goto_f
    return v1

    :cond_10
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_13
    const/4 v1, 0x1

    goto :goto_f
.end method
