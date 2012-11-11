.class public Lcom/google/android/mms/pdu/PduPart;
.super Ljava/lang/Object;
.source "PduPart.java"


# static fields
.field public static final CONTENT_TRANSFER_ENCODING:Ljava/lang/String; = "Content-Transfer-Encoding"

.field static final DISPOSITION_ATTACHMENT:[B = null

.field static final DISPOSITION_FROM_DATA:[B = null

.field static final DISPOSITION_INLINE:[B = null

.field public static final P_7BIT:Ljava/lang/String; = "7bit"

.field public static final P_8BIT:Ljava/lang/String; = "8bit"

.field public static final P_BASE64:Ljava/lang/String; = "base64"

.field public static final P_BINARY:Ljava/lang/String; = "binary"

.field public static final P_CHARSET:I = 0x81

.field public static final P_COMMENT:I = 0x9b

.field public static final P_CONTENT_DISPOSITION:I = 0xc5

.field public static final P_CONTENT_ID:I = 0xc0

.field public static final P_CONTENT_LOCATION:I = 0x8e

.field public static final P_CONTENT_TRANSFER_ENCODING:I = 0xc8

.field public static final P_CONTENT_TYPE:I = 0x91

.field public static final P_CREATION_DATE:I = 0x93

.field public static final P_CT_MR_TYPE:I = 0x89

.field public static final P_DEP_COMMENT:I = 0x8c

.field public static final P_DEP_CONTENT_DISPOSITION:I = 0xae

.field public static final P_DEP_DOMAIN:I = 0x8d

.field public static final P_DEP_FILENAME:I = 0x86

.field public static final P_DEP_NAME:I = 0x85

.field public static final P_DEP_PATH:I = 0x8f

.field public static final P_DEP_START:I = 0x8a

.field public static final P_DEP_START_INFO:I = 0x8b

.field public static final P_DIFFERENCES:I = 0x87

.field public static final P_DISPOSITION_ATTACHMENT:I = 0x81

.field public static final P_DISPOSITION_FROM_DATA:I = 0x80

.field public static final P_DISPOSITION_INLINE:I = 0x82

.field public static final P_DOMAIN:I = 0x9c

.field public static final P_FILENAME:I = 0x98

.field public static final P_LEVEL:I = 0x82

.field public static final P_MAC:I = 0x92

.field public static final P_MAX_AGE:I = 0x8e

.field public static final P_MODIFICATION_DATE:I = 0x94

.field public static final P_NAME:I = 0x97

.field public static final P_PADDING:I = 0x88

.field public static final P_PATH:I = 0x9d

.field public static final P_Q:I = 0x80

.field public static final P_QUOTED_PRINTABLE:Ljava/lang/String; = "quoted-printable"

.field public static final P_READ_DATE:I = 0x95

.field public static final P_SEC:I = 0x91

.field public static final P_SECURE:I = 0x90

.field public static final P_SIZE:I = 0x96

.field public static final P_START:I = 0x99

.field public static final P_START_INFO:I = 0x9a

.field public static final P_TYPE:I = 0x83

.field private static final TAG:Ljava/lang/String; = "PduPart"


# instance fields
.field private mPartData:[B

.field private mPartHeader:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private mUri:Landroid/net/Uri;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    const-string v0, "from-data"

    invoke-virtual {v0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    sput-object v0, Lcom/google/android/mms/pdu/PduPart;->DISPOSITION_FROM_DATA:[B

    const-string v0, "attachment"

    invoke-virtual {v0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    sput-object v0, Lcom/google/android/mms/pdu/PduPart;->DISPOSITION_ATTACHMENT:[B

    const-string v0, "inline"

    invoke-virtual {v0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    sput-object v0, Lcom/google/android/mms/pdu/PduPart;->DISPOSITION_INLINE:[B

    return-void
.end method

.method public constructor <init>()V
    .registers 2

    .prologue
    const/4 v0, 0x0

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/google/android/mms/pdu/PduPart;->mPartHeader:Ljava/util/Map;

    iput-object v0, p0, Lcom/google/android/mms/pdu/PduPart;->mUri:Landroid/net/Uri;

    iput-object v0, p0, Lcom/google/android/mms/pdu/PduPart;->mPartData:[B

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/google/android/mms/pdu/PduPart;->mPartHeader:Ljava/util/Map;

    return-void
.end method


# virtual methods
.method public generateLocation()Ljava/lang/String;
    .registers 5

    .prologue
    iget-object v2, p0, Lcom/google/android/mms/pdu/PduPart;->mPartHeader:Ljava/util/Map;

    const/16 v3, 0x97

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [B

    move-object v1, v2

    check-cast v1, [B

    .local v1, location:[B
    if-nez v1, :cond_37

    iget-object v2, p0, Lcom/google/android/mms/pdu/PduPart;->mPartHeader:Ljava/util/Map;

    const/16 v3, 0x98

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [B

    move-object v1, v2

    check-cast v1, [B

    if-nez v1, :cond_37

    iget-object v2, p0, Lcom/google/android/mms/pdu/PduPart;->mPartHeader:Ljava/util/Map;

    const/16 v3, 0x8e

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [B

    move-object v1, v2

    check-cast v1, [B

    :cond_37
    if-nez v1, :cond_63

    iget-object v2, p0, Lcom/google/android/mms/pdu/PduPart;->mPartHeader:Ljava/util/Map;

    const/16 v3, 0xc0

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [B

    move-object v0, v2

    check-cast v0, [B

    .local v0, contentId:[B
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "cid:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    new-instance v3, Ljava/lang/String;

    invoke-direct {v3, v0}, Ljava/lang/String;-><init>([B)V

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .end local v0           #contentId:[B
    :goto_62
    return-object v2

    :cond_63
    new-instance v2, Ljava/lang/String;

    invoke-direct {v2, v1}, Ljava/lang/String;-><init>([B)V

    goto :goto_62
.end method

.method public getCharset()I
    .registers 4

    .prologue
    iget-object v1, p0, Lcom/google/android/mms/pdu/PduPart;->mPartHeader:Ljava/util/Map;

    const/16 v2, 0x81

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .local v0, charset:Ljava/lang/Integer;
    if-nez v0, :cond_12

    const/4 v1, 0x0

    :goto_11
    return v1

    :cond_12
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v1

    goto :goto_11
.end method

.method public getContentDisposition()[B
    .registers 3

    .prologue
    iget-object v0, p0, Lcom/google/android/mms/pdu/PduPart;->mPartHeader:Ljava/util/Map;

    const/16 v1, 0xc5

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    check-cast v0, [B

    return-object v0
.end method

.method public getContentId()[B
    .registers 3

    .prologue
    iget-object v0, p0, Lcom/google/android/mms/pdu/PduPart;->mPartHeader:Ljava/util/Map;

    const/16 v1, 0xc0

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    check-cast v0, [B

    return-object v0
.end method

.method public getContentLocation()[B
    .registers 3

    .prologue
    iget-object v0, p0, Lcom/google/android/mms/pdu/PduPart;->mPartHeader:Ljava/util/Map;

    const/16 v1, 0x8e

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    check-cast v0, [B

    return-object v0
.end method

.method public getContentTransferEncoding()[B
    .registers 3

    .prologue
    iget-object v0, p0, Lcom/google/android/mms/pdu/PduPart;->mPartHeader:Ljava/util/Map;

    const/16 v1, 0xc8

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    check-cast v0, [B

    return-object v0
.end method

.method public getContentType()[B
    .registers 3

    .prologue
    iget-object v0, p0, Lcom/google/android/mms/pdu/PduPart;->mPartHeader:Ljava/util/Map;

    const/16 v1, 0x91

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    check-cast v0, [B

    return-object v0
.end method

.method public getData()[B
    .registers 5

    .prologue
    const/4 v3, 0x0

    iget-object v1, p0, Lcom/google/android/mms/pdu/PduPart;->mPartData:[B

    if-nez v1, :cond_7

    const/4 v0, 0x0

    :goto_6
    return-object v0

    :cond_7
    iget-object v1, p0, Lcom/google/android/mms/pdu/PduPart;->mPartData:[B

    array-length v1, v1

    new-array v0, v1, [B

    .local v0, byteArray:[B
    iget-object v1, p0, Lcom/google/android/mms/pdu/PduPart;->mPartData:[B

    iget-object v2, p0, Lcom/google/android/mms/pdu/PduPart;->mPartData:[B

    array-length v2, v2

    invoke-static {v1, v3, v0, v3, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_6
.end method

.method public getDataUri()Landroid/net/Uri;
    .registers 2

    .prologue
    iget-object v0, p0, Lcom/google/android/mms/pdu/PduPart;->mUri:Landroid/net/Uri;

    return-object v0
.end method

.method public getFilename()[B
    .registers 3

    .prologue
    iget-object v0, p0, Lcom/google/android/mms/pdu/PduPart;->mPartHeader:Ljava/util/Map;

    const/16 v1, 0x98

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    check-cast v0, [B

    return-object v0
.end method

.method public getName()[B
    .registers 3

    .prologue
    iget-object v0, p0, Lcom/google/android/mms/pdu/PduPart;->mPartHeader:Ljava/util/Map;

    const/16 v1, 0x97

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    check-cast v0, [B

    return-object v0
.end method

.method public setCharset(I)V
    .registers 5
    .parameter "charset"

    .prologue
    iget-object v0, p0, Lcom/google/android/mms/pdu/PduPart;->mPartHeader:Ljava/util/Map;

    const/16 v1, 0x81

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public setContentDisposition([B)V
    .registers 4
    .parameter "contentDisposition"

    .prologue
    if-nez p1, :cond_b

    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "null content-disposition"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_b
    iget-object v0, p0, Lcom/google/android/mms/pdu/PduPart;->mPartHeader:Ljava/util/Map;

    const/16 v1, 0xc5

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public setContentId([B)V
    .registers 9
    .parameter "contentId"

    .prologue
    const/16 v6, 0xc0

    const/16 v5, 0x3e

    const/16 v4, 0x3c

    const/4 v3, 0x1

    const/4 v2, 0x0

    if-eqz p1, :cond_d

    array-length v1, p1

    if-nez v1, :cond_15

    :cond_d
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Content-Id may not be null or empty."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_15
    array-length v1, p1

    if-le v1, v3, :cond_2f

    aget-byte v1, p1, v2

    int-to-char v1, v1

    if-ne v1, v4, :cond_2f

    array-length v1, p1

    add-int/lit8 v1, v1, -0x1

    aget-byte v1, p1, v1

    int-to-char v1, v1

    if-ne v1, v5, :cond_2f

    iget-object v1, p0, Lcom/google/android/mms/pdu/PduPart;->mPartHeader:Ljava/util/Map;

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :goto_2e
    return-void

    :cond_2f
    array-length v1, p1

    add-int/lit8 v1, v1, 0x2

    new-array v0, v1, [B

    .local v0, buffer:[B
    aput-byte v4, v0, v2

    array-length v1, v0

    add-int/lit8 v1, v1, -0x1

    aput-byte v5, v0, v1

    array-length v1, p1

    invoke-static {p1, v2, v0, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    iget-object v1, p0, Lcom/google/android/mms/pdu/PduPart;->mPartHeader:Ljava/util/Map;

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2e
.end method

.method public setContentLocation([B)V
    .registers 4
    .parameter "contentLocation"

    .prologue
    if-nez p1, :cond_b

    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "null content-location"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_b
    iget-object v0, p0, Lcom/google/android/mms/pdu/PduPart;->mPartHeader:Ljava/util/Map;

    const/16 v1, 0x8e

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public setContentTransferEncoding([B)V
    .registers 4
    .parameter "contentTransferEncoding"

    .prologue
    if-nez p1, :cond_b

    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "null content-transfer-encoding"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_b
    iget-object v0, p0, Lcom/google/android/mms/pdu/PduPart;->mPartHeader:Ljava/util/Map;

    const/16 v1, 0xc8

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public setContentType([B)V
    .registers 4
    .parameter "contentType"

    .prologue
    if-nez p1, :cond_b

    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "null content-type"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_b
    iget-object v0, p0, Lcom/google/android/mms/pdu/PduPart;->mPartHeader:Ljava/util/Map;

    const/16 v1, 0x91

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public setData([B)V
    .registers 5
    .parameter "data"

    .prologue
    const/4 v2, 0x0

    if-nez p1, :cond_4

    :goto_3
    return-void

    :cond_4
    array-length v0, p1

    new-array v0, v0, [B

    iput-object v0, p0, Lcom/google/android/mms/pdu/PduPart;->mPartData:[B

    iget-object v0, p0, Lcom/google/android/mms/pdu/PduPart;->mPartData:[B

    array-length v1, p1

    invoke-static {p1, v2, v0, v2, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_3
.end method

.method public setDataUri(Landroid/net/Uri;)V
    .registers 2
    .parameter "uri"

    .prologue
    iput-object p1, p0, Lcom/google/android/mms/pdu/PduPart;->mUri:Landroid/net/Uri;

    return-void
.end method

.method public setFilename([B)V
    .registers 4
    .parameter "fileName"

    .prologue
    if-nez p1, :cond_b

    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "null content-id"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_b
    iget-object v0, p0, Lcom/google/android/mms/pdu/PduPart;->mPartHeader:Ljava/util/Map;

    const/16 v1, 0x98

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public setName([B)V
    .registers 4
    .parameter "name"

    .prologue
    if-nez p1, :cond_b

    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "null content-id"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_b
    iget-object v0, p0, Lcom/google/android/mms/pdu/PduPart;->mPartHeader:Ljava/util/Map;

    const/16 v1, 0x97

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method
