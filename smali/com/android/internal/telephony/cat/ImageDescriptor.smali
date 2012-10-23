.class public Lcom/android/internal/telephony/cat/ImageDescriptor;
.super Ljava/lang/Object;
.source "ImageDescriptor.java"


# static fields
.field static final CODING_SCHEME_BASIC:I = 0x11

.field static final CODING_SCHEME_COLOUR:I = 0x21


# instance fields
.field codingScheme:I

.field height:I

.field highOffset:I

.field imageId:I

.field length:I

.field lowOffset:I

.field width:I


# direct methods
.method constructor <init>()V
    .registers 2

    .prologue
    const/4 v0, 0x0

    .line 39
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 40
    iput v0, p0, Lcom/android/internal/telephony/cat/ImageDescriptor;->width:I

    .line 41
    iput v0, p0, Lcom/android/internal/telephony/cat/ImageDescriptor;->height:I

    .line 42
    iput v0, p0, Lcom/android/internal/telephony/cat/ImageDescriptor;->codingScheme:I

    .line 43
    iput v0, p0, Lcom/android/internal/telephony/cat/ImageDescriptor;->imageId:I

    .line 44
    iput v0, p0, Lcom/android/internal/telephony/cat/ImageDescriptor;->highOffset:I

    .line 45
    iput v0, p0, Lcom/android/internal/telephony/cat/ImageDescriptor;->lowOffset:I

    .line 46
    iput v0, p0, Lcom/android/internal/telephony/cat/ImageDescriptor;->length:I

    .line 47
    return-void
.end method

.method static parse([BI)Lcom/android/internal/telephony/cat/ImageDescriptor;
    .registers 7
    .parameter "rawData"
    .parameter "valueIndex"

    .prologue
    .line 57
    new-instance v0, Lcom/android/internal/telephony/cat/ImageDescriptor;

    invoke-direct {v0}, Lcom/android/internal/telephony/cat/ImageDescriptor;-><init>()V

    .line 59
    .local v0, d:Lcom/android/internal/telephony/cat/ImageDescriptor;
    add-int/lit8 v2, p1, 0x1

    .end local p1
    .local v2, valueIndex:I
    :try_start_7
    aget-byte v3, p0, p1

    and-int/lit16 v3, v3, 0xff

    iput v3, v0, Lcom/android/internal/telephony/cat/ImageDescriptor;->width:I
    :try_end_d
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_7 .. :try_end_d} :catch_55

    .line 60
    add-int/lit8 p1, v2, 0x1

    .end local v2           #valueIndex:I
    .restart local p1
    :try_start_f
    aget-byte v3, p0, v2

    and-int/lit16 v3, v3, 0xff

    iput v3, v0, Lcom/android/internal/telephony/cat/ImageDescriptor;->height:I
    :try_end_15
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_f .. :try_end_15} :catch_61

    .line 61
    add-int/lit8 v2, p1, 0x1

    .end local p1
    .restart local v2       #valueIndex:I
    :try_start_17
    aget-byte v3, p0, p1

    and-int/lit16 v3, v3, 0xff

    iput v3, v0, Lcom/android/internal/telephony/cat/ImageDescriptor;->codingScheme:I
    :try_end_1d
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_17 .. :try_end_1d} :catch_55

    .line 64
    add-int/lit8 p1, v2, 0x1

    .end local v2           #valueIndex:I
    .restart local p1
    :try_start_1f
    aget-byte v3, p0, v2

    and-int/lit16 v3, v3, 0xff

    shl-int/lit8 v3, v3, 0x8

    iput v3, v0, Lcom/android/internal/telephony/cat/ImageDescriptor;->imageId:I

    .line 65
    iget v3, v0, Lcom/android/internal/telephony/cat/ImageDescriptor;->imageId:I
    :try_end_29
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_1f .. :try_end_29} :catch_61

    add-int/lit8 v2, p1, 0x1

    .end local p1
    .restart local v2       #valueIndex:I
    :try_start_2b
    aget-byte v4, p0, p1

    and-int/lit16 v4, v4, 0xff

    or-int/2addr v3, v4

    iput v3, v0, Lcom/android/internal/telephony/cat/ImageDescriptor;->imageId:I
    :try_end_32
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_2b .. :try_end_32} :catch_55

    .line 67
    add-int/lit8 p1, v2, 0x1

    .end local v2           #valueIndex:I
    .restart local p1
    :try_start_34
    aget-byte v3, p0, v2

    and-int/lit16 v3, v3, 0xff

    iput v3, v0, Lcom/android/internal/telephony/cat/ImageDescriptor;->highOffset:I
    :try_end_3a
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_34 .. :try_end_3a} :catch_61

    .line 68
    add-int/lit8 v2, p1, 0x1

    .end local p1
    .restart local v2       #valueIndex:I
    :try_start_3c
    aget-byte v3, p0, p1

    and-int/lit16 v3, v3, 0xff

    iput v3, v0, Lcom/android/internal/telephony/cat/ImageDescriptor;->lowOffset:I
    :try_end_42
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_3c .. :try_end_42} :catch_55

    .line 70
    add-int/lit8 p1, v2, 0x1

    .end local v2           #valueIndex:I
    .restart local p1
    :try_start_44
    aget-byte v3, p0, v2
    :try_end_46
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_44 .. :try_end_46} :catch_61

    and-int/lit16 v3, v3, 0xff

    shl-int/lit8 v3, v3, 0x8

    add-int/lit8 v2, p1, 0x1

    .end local p1
    .restart local v2       #valueIndex:I
    :try_start_4c
    aget-byte v4, p0, p1

    and-int/lit16 v4, v4, 0xff

    or-int/2addr v3, v4

    iput v3, v0, Lcom/android/internal/telephony/cat/ImageDescriptor;->length:I
    :try_end_53
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_4c .. :try_end_53} :catch_55

    move p1, v2

    .line 75
    .end local v2           #valueIndex:I
    .restart local p1
    :goto_54
    return-object v0

    .line 71
    .end local p1
    .restart local v2       #valueIndex:I
    :catch_55
    move-exception v1

    move p1, v2

    .line 72
    .end local v2           #valueIndex:I
    .local v1, e:Ljava/lang/IndexOutOfBoundsException;
    .restart local p1
    :goto_57
    const-string v3, "ImageDescripter"

    const-string/jumbo v4, "parse; failed parsing image descriptor"

    invoke-static {v3, v4}, Lcom/android/internal/telephony/cat/CatLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 73
    const/4 v0, 0x0

    goto :goto_54

    .line 71
    .end local v1           #e:Ljava/lang/IndexOutOfBoundsException;
    :catch_61
    move-exception v1

    goto :goto_57
.end method
