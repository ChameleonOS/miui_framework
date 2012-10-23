.class public Lcom/android/internal/telephony/MiuiAdnUtils;
.super Ljava/lang/Object;
.source "MiuiAdnUtils.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "MiuiAdnUtils"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 7
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static encodeAlphaTag([BLjava/lang/String;I)Z
    .registers 12
    .parameter "adnString"
    .parameter "alphaTag"
    .parameter "footerOffset"

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 23
    :try_start_2
    invoke-static {p1}, Lcom/android/internal/telephony/GsmAlphabet;->stringToGsm7BitPacked(Ljava/lang/String;)[B

    .line 24
    invoke-static {p1}, Lcom/android/internal/telephony/GsmAlphabet;->stringToGsm8BitPacked(Ljava/lang/String;)[B
    :try_end_8
    .catch Lcom/android/internal/telephony/EncodeException; {:try_start_2 .. :try_end_8} :catch_10

    move-result-object v0

    .line 41
    .local v0, byteTag:[B
    :goto_9
    array-length v7, v0

    if-le v7, p2, :cond_3c

    .end local p2
    :goto_c
    invoke-static {v0, v6, p0, v6, p2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 43
    .end local v0           #byteTag:[B
    :goto_f
    return v5

    .line 25
    .restart local p2
    :catch_10
    move-exception v2

    .line 26
    .local v2, ex:Lcom/android/internal/telephony/EncodeException;
    const-string v7, "MiuiAdnUtils"

    const-string v8, "[buildAdnString]  can\'t encode with GSM alphabet, try utf-16be"

    invoke-static {v7, v8}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 28
    new-array v3, v5, [B

    .line 29
    .local v3, header:[B
    const/16 v7, -0x80

    aput-byte v7, v3, v6

    .line 32
    :try_start_1e
    const-string/jumbo v7, "utf-16be"

    invoke-virtual {p1, v7}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B
    :try_end_24
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_1e .. :try_end_24} :catch_32

    move-result-object v1

    .line 37
    .local v1, data:[B
    array-length v7, v1

    add-int/lit8 v7, v7, 0x1

    new-array v0, v7, [B

    .line 38
    .restart local v0       #byteTag:[B
    invoke-static {v3, v6, v0, v6, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 39
    array-length v7, v1

    invoke-static {v1, v6, v0, v5, v7}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_9

    .line 33
    .end local v0           #byteTag:[B
    .end local v1           #data:[B
    :catch_32
    move-exception v4

    .line 34
    .local v4, uex:Ljava/io/UnsupportedEncodingException;
    const-string v5, "MiuiAdnUtils"

    const-string v7, "Implausible UnsupportedEncodingException "

    invoke-static {v5, v7, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    move v5, v6

    .line 35
    goto :goto_f

    .line 41
    .end local v2           #ex:Lcom/android/internal/telephony/EncodeException;
    .end local v3           #header:[B
    .end local v4           #uex:Ljava/io/UnsupportedEncodingException;
    .restart local v0       #byteTag:[B
    :cond_3c
    array-length p2, v0

    goto :goto_c
.end method
