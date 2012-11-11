.class Lmiui/util/ErrorReportUtils$Base64Coder;
.super Ljava/lang/Object;
.source "ErrorReportUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/util/ErrorReportUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "Base64Coder"
.end annotation


# static fields
.field private static map1:[C

.field private static map2:[B


# direct methods
.method static constructor <clinit>()V
    .registers 7

    .prologue
    const/16 v6, 0x40

    new-array v3, v6, [C

    sput-object v3, Lmiui/util/ErrorReportUtils$Base64Coder;->map1:[C

    const/4 v1, 0x0

    .local v1, i:I
    const/16 v0, 0x41

    .local v0, c:C
    move v2, v1

    .end local v1           #i:I
    .local v2, i:I
    :goto_a
    const/16 v3, 0x5a

    if-gt v0, v3, :cond_19

    sget-object v3, Lmiui/util/ErrorReportUtils$Base64Coder;->map1:[C

    add-int/lit8 v1, v2, 0x1

    .end local v2           #i:I
    .restart local v1       #i:I
    aput-char v0, v3, v2

    add-int/lit8 v3, v0, 0x1

    int-to-char v0, v3

    move v2, v1

    .end local v1           #i:I
    .restart local v2       #i:I
    goto :goto_a

    :cond_19
    const/16 v0, 0x61

    :goto_1b
    const/16 v3, 0x7a

    if-gt v0, v3, :cond_2a

    sget-object v3, Lmiui/util/ErrorReportUtils$Base64Coder;->map1:[C

    add-int/lit8 v1, v2, 0x1

    .end local v2           #i:I
    .restart local v1       #i:I
    aput-char v0, v3, v2

    add-int/lit8 v3, v0, 0x1

    int-to-char v0, v3

    move v2, v1

    .end local v1           #i:I
    .restart local v2       #i:I
    goto :goto_1b

    :cond_2a
    const/16 v0, 0x30

    :goto_2c
    const/16 v3, 0x39

    if-gt v0, v3, :cond_3b

    sget-object v3, Lmiui/util/ErrorReportUtils$Base64Coder;->map1:[C

    add-int/lit8 v1, v2, 0x1

    .end local v2           #i:I
    .restart local v1       #i:I
    aput-char v0, v3, v2

    add-int/lit8 v3, v0, 0x1

    int-to-char v0, v3

    move v2, v1

    .end local v1           #i:I
    .restart local v2       #i:I
    goto :goto_2c

    :cond_3b
    sget-object v3, Lmiui/util/ErrorReportUtils$Base64Coder;->map1:[C

    add-int/lit8 v1, v2, 0x1

    .end local v2           #i:I
    .restart local v1       #i:I
    const/16 v4, 0x2b

    aput-char v4, v3, v2

    sget-object v3, Lmiui/util/ErrorReportUtils$Base64Coder;->map1:[C

    add-int/lit8 v2, v1, 0x1

    .end local v1           #i:I
    .restart local v2       #i:I
    const/16 v4, 0x2f

    aput-char v4, v3, v1

    const/16 v3, 0x80

    new-array v3, v3, [B

    sput-object v3, Lmiui/util/ErrorReportUtils$Base64Coder;->map2:[B

    const/4 v1, 0x0

    .end local v2           #i:I
    .restart local v1       #i:I
    :goto_52
    sget-object v3, Lmiui/util/ErrorReportUtils$Base64Coder;->map2:[B

    array-length v3, v3

    if-ge v1, v3, :cond_5f

    sget-object v3, Lmiui/util/ErrorReportUtils$Base64Coder;->map2:[B

    const/4 v4, -0x1

    aput-byte v4, v3, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_52

    :cond_5f
    const/4 v1, 0x0

    :goto_60
    if-ge v1, v6, :cond_6e

    sget-object v3, Lmiui/util/ErrorReportUtils$Base64Coder;->map2:[B

    sget-object v4, Lmiui/util/ErrorReportUtils$Base64Coder;->map1:[C

    aget-char v4, v4, v1

    int-to-byte v5, v1

    aput-byte v5, v3, v4

    add-int/lit8 v1, v1, 0x1

    goto :goto_60

    :cond_6e
    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static encode([B)[C
    .registers 3
    .parameter "in"

    .prologue
    const/4 v0, 0x0

    array-length v1, p0

    invoke-static {p0, v0, v1}, Lmiui/util/ErrorReportUtils$Base64Coder;->encode([BII)[C

    move-result-object v0

    return-object v0
.end method

.method public static encode([BII)[C
    .registers 20
    .parameter "in"
    .parameter "iOff"
    .parameter "iLen"

    .prologue
    mul-int/lit8 v15, p2, 0x4

    add-int/lit8 v15, v15, 0x2

    div-int/lit8 v10, v15, 0x3

    .local v10, oDataLen:I
    add-int/lit8 v15, p2, 0x2

    div-int/lit8 v15, v15, 0x3

    mul-int/lit8 v11, v15, 0x4

    .local v11, oLen:I
    new-array v14, v11, [C

    .local v14, out:[C
    move/from16 v4, p1

    .local v4, ip:I
    add-int v3, p1, p2

    .local v3, iEnd:I
    const/4 v12, 0x0

    .local v12, op:I
    move v13, v12

    .end local v12           #op:I
    .local v13, op:I
    move v5, v4

    .end local v4           #ip:I
    .local v5, ip:I
    :goto_15
    if-ge v5, v3, :cond_74

    add-int/lit8 v4, v5, 0x1

    .end local v5           #ip:I
    .restart local v4       #ip:I
    aget-byte v15, p0, v5

    and-int/lit16 v0, v15, 0xff

    .local v0, i0:I
    if-ge v4, v3, :cond_68

    add-int/lit8 v5, v4, 0x1

    .end local v4           #ip:I
    .restart local v5       #ip:I
    aget-byte v15, p0, v4

    and-int/lit16 v1, v15, 0xff

    .local v1, i1:I
    :goto_25
    if-ge v5, v3, :cond_6b

    add-int/lit8 v4, v5, 0x1

    .end local v5           #ip:I
    .restart local v4       #ip:I
    aget-byte v15, p0, v5

    and-int/lit16 v2, v15, 0xff

    .local v2, i2:I
    :goto_2d
    ushr-int/lit8 v6, v0, 0x2

    .local v6, o0:I
    and-int/lit8 v15, v0, 0x3

    shl-int/lit8 v15, v15, 0x4

    ushr-int/lit8 v16, v1, 0x4

    or-int v7, v15, v16

    .local v7, o1:I
    and-int/lit8 v15, v1, 0xf

    shl-int/lit8 v15, v15, 0x2

    ushr-int/lit8 v16, v2, 0x6

    or-int v8, v15, v16

    .local v8, o2:I
    and-int/lit8 v9, v2, 0x3f

    .local v9, o3:I
    add-int/lit8 v12, v13, 0x1

    .end local v13           #op:I
    .restart local v12       #op:I
    sget-object v15, Lmiui/util/ErrorReportUtils$Base64Coder;->map1:[C

    aget-char v15, v15, v6

    aput-char v15, v14, v13

    add-int/lit8 v13, v12, 0x1

    .end local v12           #op:I
    .restart local v13       #op:I
    sget-object v15, Lmiui/util/ErrorReportUtils$Base64Coder;->map1:[C

    aget-char v15, v15, v7

    aput-char v15, v14, v12

    if-ge v13, v10, :cond_6e

    sget-object v15, Lmiui/util/ErrorReportUtils$Base64Coder;->map1:[C

    aget-char v15, v15, v8

    :goto_57
    aput-char v15, v14, v13

    add-int/lit8 v12, v13, 0x1

    .end local v13           #op:I
    .restart local v12       #op:I
    if-ge v12, v10, :cond_71

    sget-object v15, Lmiui/util/ErrorReportUtils$Base64Coder;->map1:[C

    aget-char v15, v15, v9

    :goto_61
    aput-char v15, v14, v12

    add-int/lit8 v12, v12, 0x1

    move v13, v12

    .end local v12           #op:I
    .restart local v13       #op:I
    move v5, v4

    .end local v4           #ip:I
    .restart local v5       #ip:I
    goto :goto_15

    .end local v1           #i1:I
    .end local v2           #i2:I
    .end local v5           #ip:I
    .end local v6           #o0:I
    .end local v7           #o1:I
    .end local v8           #o2:I
    .end local v9           #o3:I
    .restart local v4       #ip:I
    :cond_68
    const/4 v1, 0x0

    move v5, v4

    .end local v4           #ip:I
    .restart local v5       #ip:I
    goto :goto_25

    .restart local v1       #i1:I
    :cond_6b
    const/4 v2, 0x0

    move v4, v5

    .end local v5           #ip:I
    .restart local v4       #ip:I
    goto :goto_2d

    .restart local v2       #i2:I
    .restart local v6       #o0:I
    .restart local v7       #o1:I
    .restart local v8       #o2:I
    .restart local v9       #o3:I
    :cond_6e
    const/16 v15, 0x3d

    goto :goto_57

    .end local v13           #op:I
    .restart local v12       #op:I
    :cond_71
    const/16 v15, 0x3d

    goto :goto_61

    .end local v0           #i0:I
    .end local v1           #i1:I
    .end local v2           #i2:I
    .end local v4           #ip:I
    .end local v6           #o0:I
    .end local v7           #o1:I
    .end local v8           #o2:I
    .end local v9           #o3:I
    .end local v12           #op:I
    .restart local v5       #ip:I
    .restart local v13       #op:I
    :cond_74
    return-object v14
.end method
