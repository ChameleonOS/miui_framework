.class Lcom/android/internal/telephony/cat/LanguageResponseData;
.super Lcom/android/internal/telephony/cat/ResponseData;
.source "ResponseData.java"


# instance fields
.field private lang:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .registers 2
    .parameter "lang"

    .prologue
    .line 163
    invoke-direct {p0}, Lcom/android/internal/telephony/cat/ResponseData;-><init>()V

    .line 164
    iput-object p1, p0, Lcom/android/internal/telephony/cat/LanguageResponseData;->lang:Ljava/lang/String;

    .line 165
    return-void
.end method


# virtual methods
.method public format(Ljava/io/ByteArrayOutputStream;)V
    .registers 9
    .parameter "buf"

    .prologue
    .line 169
    if-nez p1, :cond_3

    .line 191
    :cond_2
    return-void

    .line 174
    :cond_3
    sget-object v6, Lcom/android/internal/telephony/cat/ComprehensionTlvTag;->LANGUAGE:Lcom/android/internal/telephony/cat/ComprehensionTlvTag;

    invoke-virtual {v6}, Lcom/android/internal/telephony/cat/ComprehensionTlvTag;->value()I

    move-result v6

    or-int/lit16 v5, v6, 0x80

    .line 175
    .local v5, tag:I
    invoke-virtual {p1, v5}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 179
    iget-object v6, p0, Lcom/android/internal/telephony/cat/LanguageResponseData;->lang:Ljava/lang/String;

    if-eqz v6, :cond_31

    iget-object v6, p0, Lcom/android/internal/telephony/cat/LanguageResponseData;->lang:Ljava/lang/String;

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    if-lez v6, :cond_31

    .line 180
    iget-object v6, p0, Lcom/android/internal/telephony/cat/LanguageResponseData;->lang:Ljava/lang/String;

    invoke-static {v6}, Lcom/android/internal/telephony/GsmAlphabet;->stringToGsm8BitPacked(Ljava/lang/String;)[B

    move-result-object v2

    .line 186
    .local v2, data:[B
    :goto_20
    array-length v6, v2

    invoke-virtual {p1, v6}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 188
    move-object v0, v2

    .local v0, arr$:[B
    array-length v4, v0

    .local v4, len$:I
    const/4 v3, 0x0

    .local v3, i$:I
    :goto_27
    if-ge v3, v4, :cond_2

    aget-byte v1, v0, v3

    .line 189
    .local v1, b:B
    invoke-virtual {p1, v1}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 188
    add-int/lit8 v3, v3, 0x1

    goto :goto_27

    .line 183
    .end local v0           #arr$:[B
    .end local v1           #b:B
    .end local v2           #data:[B
    .end local v3           #i$:I
    .end local v4           #len$:I
    :cond_31
    const/4 v6, 0x0

    new-array v2, v6, [B

    .restart local v2       #data:[B
    goto :goto_20
.end method
