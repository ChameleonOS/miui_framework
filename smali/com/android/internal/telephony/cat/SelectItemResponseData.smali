.class Lcom/android/internal/telephony/cat/SelectItemResponseData;
.super Lcom/android/internal/telephony/cat/ResponseData;
.source "ResponseData.java"


# instance fields
.field private id:I


# direct methods
.method public constructor <init>(I)V
    .registers 2
    .parameter "id"

    .prologue
    .line 54
    invoke-direct {p0}, Lcom/android/internal/telephony/cat/ResponseData;-><init>()V

    .line 55
    iput p1, p0, Lcom/android/internal/telephony/cat/SelectItemResponseData;->id:I

    .line 56
    return-void
.end method


# virtual methods
.method public format(Ljava/io/ByteArrayOutputStream;)V
    .registers 4
    .parameter "buf"

    .prologue
    .line 61
    sget-object v1, Lcom/android/internal/telephony/cat/ComprehensionTlvTag;->ITEM_ID:Lcom/android/internal/telephony/cat/ComprehensionTlvTag;

    invoke-virtual {v1}, Lcom/android/internal/telephony/cat/ComprehensionTlvTag;->value()I

    move-result v1

    or-int/lit16 v0, v1, 0x80

    .line 62
    .local v0, tag:I
    invoke-virtual {p1, v0}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 63
    const/4 v1, 0x1

    invoke-virtual {p1, v1}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 64
    iget v1, p0, Lcom/android/internal/telephony/cat/SelectItemResponseData;->id:I

    invoke-virtual {p1, v1}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 65
    return-void
.end method
