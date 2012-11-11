.class public Landroid/util/LogWriter;
.super Ljava/io/Writer;
.source "LogWriter.java"


# instance fields
.field private final mBuffer:I

.field private mBuilder:Ljava/lang/StringBuilder;

.field private final mPriority:I

.field private final mTag:Ljava/lang/String;


# direct methods
.method public constructor <init>(ILjava/lang/String;)V
    .registers 5
    .parameter "priority"
    .parameter "tag"

    .prologue
    invoke-direct {p0}, Ljava/io/Writer;-><init>()V

    new-instance v0, Ljava/lang/StringBuilder;

    const/16 v1, 0x80

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    iput-object v0, p0, Landroid/util/LogWriter;->mBuilder:Ljava/lang/StringBuilder;

    iput p1, p0, Landroid/util/LogWriter;->mPriority:I

    iput-object p2, p0, Landroid/util/LogWriter;->mTag:Ljava/lang/String;

    const/4 v0, 0x0

    iput v0, p0, Landroid/util/LogWriter;->mBuffer:I

    return-void
.end method

.method public constructor <init>(ILjava/lang/String;I)V
    .registers 6
    .parameter "priority"
    .parameter "tag"
    .parameter "buffer"

    .prologue
    invoke-direct {p0}, Ljava/io/Writer;-><init>()V

    new-instance v0, Ljava/lang/StringBuilder;

    const/16 v1, 0x80

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    iput-object v0, p0, Landroid/util/LogWriter;->mBuilder:Ljava/lang/StringBuilder;

    iput p1, p0, Landroid/util/LogWriter;->mPriority:I

    iput-object p2, p0, Landroid/util/LogWriter;->mTag:Ljava/lang/String;

    iput p3, p0, Landroid/util/LogWriter;->mBuffer:I

    return-void
.end method

.method private flushBuilder()V
    .registers 5

    .prologue
    iget-object v0, p0, Landroid/util/LogWriter;->mBuilder:Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->length()I

    move-result v0

    if-lez v0, :cond_23

    iget v0, p0, Landroid/util/LogWriter;->mBuffer:I

    iget v1, p0, Landroid/util/LogWriter;->mPriority:I

    iget-object v2, p0, Landroid/util/LogWriter;->mTag:Ljava/lang/String;

    iget-object v3, p0, Landroid/util/LogWriter;->mBuilder:Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v1, v2, v3}, Landroid/util/Log;->println_native(IILjava/lang/String;Ljava/lang/String;)I

    iget-object v0, p0, Landroid/util/LogWriter;->mBuilder:Ljava/lang/StringBuilder;

    const/4 v1, 0x0

    iget-object v2, p0, Landroid/util/LogWriter;->mBuilder:Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->length()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->delete(II)Ljava/lang/StringBuilder;

    :cond_23
    return-void
.end method


# virtual methods
.method public close()V
    .registers 1

    .prologue
    invoke-direct {p0}, Landroid/util/LogWriter;->flushBuilder()V

    return-void
.end method

.method public flush()V
    .registers 1

    .prologue
    invoke-direct {p0}, Landroid/util/LogWriter;->flushBuilder()V

    return-void
.end method

.method public write([CII)V
    .registers 7
    .parameter "buf"
    .parameter "offset"
    .parameter "count"

    .prologue
    const/4 v1, 0x0

    .local v1, i:I
    :goto_1
    if-ge v1, p3, :cond_17

    add-int v2, p2, v1

    aget-char v0, p1, v2

    .local v0, c:C
    const/16 v2, 0xa

    if-ne v0, v2, :cond_11

    invoke-direct {p0}, Landroid/util/LogWriter;->flushBuilder()V

    :goto_e
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    :cond_11
    iget-object v2, p0, Landroid/util/LogWriter;->mBuilder:Ljava/lang/StringBuilder;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_e

    .end local v0           #c:C
    :cond_17
    return-void
.end method
