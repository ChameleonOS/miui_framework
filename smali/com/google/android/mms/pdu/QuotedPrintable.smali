.class public Lcom/google/android/mms/pdu/QuotedPrintable;
.super Ljava/lang/Object;
.source "QuotedPrintable.java"


# static fields
.field private static ESCAPE_CHAR:B


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 23
    const/16 v0, 0x3d

    sput-byte v0, Lcom/google/android/mms/pdu/QuotedPrintable;->ESCAPE_CHAR:B

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 22
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static final decodeQuotedPrintable([B)[B
    .registers 11
    .parameter "bytes"

    .prologue
    const/4 v9, -0x1

    const/4 v6, 0x0

    .line 40
    if-nez p0, :cond_5

    .line 66
    :cond_4
    :goto_4
    return-object v6

    .line 43
    :cond_5
    new-instance v1, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v1}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 44
    .local v1, buffer:Ljava/io/ByteArrayOutputStream;
    const/4 v3, 0x0

    .local v3, i:I
    :goto_b
    array-length v7, p0

    if-ge v3, v7, :cond_53

    .line 45
    aget-byte v0, p0, v3

    .line 46
    .local v0, b:I
    sget-byte v7, Lcom/google/android/mms/pdu/QuotedPrintable;->ESCAPE_CHAR:B

    if-ne v0, v7, :cond_4f

    .line 48
    const/16 v7, 0xd

    add-int/lit8 v8, v3, 0x1

    :try_start_18
    aget-byte v8, p0, v8

    int-to-char v8, v8

    if-ne v7, v8, :cond_2b

    const/16 v7, 0xa

    add-int/lit8 v8, v3, 0x2

    aget-byte v8, p0, v8

    int-to-char v8, v8

    if-ne v7, v8, :cond_2b

    .line 50
    add-int/lit8 v3, v3, 0x2

    .line 44
    :goto_28
    add-int/lit8 v3, v3, 0x1

    goto :goto_b

    .line 53
    :cond_2b
    add-int/lit8 v3, v3, 0x1

    aget-byte v7, p0, v3

    int-to-char v7, v7

    const/16 v8, 0x10

    invoke-static {v7, v8}, Ljava/lang/Character;->digit(CI)I

    move-result v5

    .line 54
    .local v5, u:I
    add-int/lit8 v3, v3, 0x1

    aget-byte v7, p0, v3

    int-to-char v7, v7

    const/16 v8, 0x10

    invoke-static {v7, v8}, Ljava/lang/Character;->digit(CI)I

    move-result v4

    .line 55
    .local v4, l:I
    if-eq v5, v9, :cond_4

    if-eq v4, v9, :cond_4

    .line 58
    shl-int/lit8 v7, v5, 0x4

    add-int/2addr v7, v4

    int-to-char v7, v7

    invoke-virtual {v1, v7}, Ljava/io/ByteArrayOutputStream;->write(I)V
    :try_end_4c
    .catch Ljava/lang/ArrayIndexOutOfBoundsException; {:try_start_18 .. :try_end_4c} :catch_4d

    goto :goto_28

    .line 59
    .end local v4           #l:I
    .end local v5           #u:I
    :catch_4d
    move-exception v2

    .line 60
    .local v2, e:Ljava/lang/ArrayIndexOutOfBoundsException;
    goto :goto_4

    .line 63
    .end local v2           #e:Ljava/lang/ArrayIndexOutOfBoundsException;
    :cond_4f
    invoke-virtual {v1, v0}, Ljava/io/ByteArrayOutputStream;->write(I)V

    goto :goto_28

    .line 66
    .end local v0           #b:I
    :cond_53
    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v6

    goto :goto_4
.end method
