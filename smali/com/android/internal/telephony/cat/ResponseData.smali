.class abstract Lcom/android/internal/telephony/cat/ResponseData;
.super Ljava/lang/Object;
.source "ResponseData.java"


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 31
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static writeLength(Ljava/io/ByteArrayOutputStream;I)V
    .registers 3
    .parameter "buf"
    .parameter "length"

    .prologue
    .line 42
    const/16 v0, 0x7f

    if-le p1, v0, :cond_9

    .line 43
    const/16 v0, 0x81

    invoke-virtual {p0, v0}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 45
    :cond_9
    invoke-virtual {p0, p1}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 46
    return-void
.end method


# virtual methods
.method public abstract format(Ljava/io/ByteArrayOutputStream;)V
.end method
