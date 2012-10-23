.class public Lcom/android/internal/util/IndentingPrintWriter;
.super Ljava/io/PrintWriter;
.source "IndentingPrintWriter.java"


# instance fields
.field private mBuilder:Ljava/lang/StringBuilder;

.field private mCurrent:Ljava/lang/String;

.field private mEmptyLine:Z

.field private final mIndent:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/io/Writer;Ljava/lang/String;)V
    .registers 4
    .parameter "writer"
    .parameter "indent"

    .prologue
    .line 35
    invoke-direct {p0, p1}, Ljava/io/PrintWriter;-><init>(Ljava/io/Writer;)V

    .line 30
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iput-object v0, p0, Lcom/android/internal/util/IndentingPrintWriter;->mBuilder:Ljava/lang/StringBuilder;

    .line 31
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0}, Ljava/lang/String;-><init>()V

    iput-object v0, p0, Lcom/android/internal/util/IndentingPrintWriter;->mCurrent:Ljava/lang/String;

    .line 32
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/internal/util/IndentingPrintWriter;->mEmptyLine:Z

    .line 36
    iput-object p2, p0, Lcom/android/internal/util/IndentingPrintWriter;->mIndent:Ljava/lang/String;

    .line 37
    return-void
.end method


# virtual methods
.method public decreaseIndent()V
    .registers 4

    .prologue
    .line 45
    iget-object v0, p0, Lcom/android/internal/util/IndentingPrintWriter;->mBuilder:Ljava/lang/StringBuilder;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/android/internal/util/IndentingPrintWriter;->mIndent:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->delete(II)Ljava/lang/StringBuilder;

    .line 46
    iget-object v0, p0, Lcom/android/internal/util/IndentingPrintWriter;->mBuilder:Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/internal/util/IndentingPrintWriter;->mCurrent:Ljava/lang/String;

    .line 47
    return-void
.end method

.method public increaseIndent()V
    .registers 3

    .prologue
    .line 40
    iget-object v0, p0, Lcom/android/internal/util/IndentingPrintWriter;->mBuilder:Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/android/internal/util/IndentingPrintWriter;->mIndent:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 41
    iget-object v0, p0, Lcom/android/internal/util/IndentingPrintWriter;->mBuilder:Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/internal/util/IndentingPrintWriter;->mCurrent:Ljava/lang/String;

    .line 42
    return-void
.end method

.method public printPair(Ljava/lang/String;Ljava/lang/Object;)V
    .registers 5
    .parameter "key"
    .parameter "value"

    .prologue
    .line 50
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/android/internal/util/IndentingPrintWriter;->print(Ljava/lang/String;)V

    .line 51
    return-void
.end method

.method public println()V
    .registers 2

    .prologue
    .line 55
    invoke-super {p0}, Ljava/io/PrintWriter;->println()V

    .line 56
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/internal/util/IndentingPrintWriter;->mEmptyLine:Z

    .line 57
    return-void
.end method

.method public write([CII)V
    .registers 5
    .parameter "buf"
    .parameter "offset"
    .parameter "count"

    .prologue
    .line 61
    iget-boolean v0, p0, Lcom/android/internal/util/IndentingPrintWriter;->mEmptyLine:Z

    if-eqz v0, :cond_c

    .line 62
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/internal/util/IndentingPrintWriter;->mEmptyLine:Z

    .line 63
    iget-object v0, p0, Lcom/android/internal/util/IndentingPrintWriter;->mCurrent:Ljava/lang/String;

    invoke-super {p0, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 65
    :cond_c
    invoke-super {p0, p1, p2, p3}, Ljava/io/PrintWriter;->write([CII)V

    .line 66
    return-void
.end method
