.class public Lcom/android/internal/util/FastXmlSerializer;
.super Ljava/lang/Object;
.source "FastXmlSerializer.java"

# interfaces
.implements Lorg/xmlpull/v1/XmlSerializer;


# static fields
.field private static final BUFFER_LEN:I = 0x2000

.field private static final ESCAPE_TABLE:[Ljava/lang/String;


# instance fields
.field private mBytes:Ljava/nio/ByteBuffer;

.field private mCharset:Ljava/nio/charset/CharsetEncoder;

.field private mInTag:Z

.field private mOutputStream:Ljava/io/OutputStream;

.field private mPos:I

.field private final mText:[C

.field private mWriter:Ljava/io/Writer;


# direct methods
.method static constructor <clinit>()V
    .registers 4

    .prologue
    const/4 v3, 0x0

    const/16 v0, 0x40

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    aput-object v3, v0, v1

    const/4 v1, 0x1

    aput-object v3, v0, v1

    const/4 v1, 0x2

    aput-object v3, v0, v1

    const/4 v1, 0x3

    aput-object v3, v0, v1

    const/4 v1, 0x4

    aput-object v3, v0, v1

    const/4 v1, 0x5

    aput-object v3, v0, v1

    const/4 v1, 0x6

    aput-object v3, v0, v1

    const/4 v1, 0x7

    aput-object v3, v0, v1

    const/16 v1, 0x8

    aput-object v3, v0, v1

    const/16 v1, 0x9

    aput-object v3, v0, v1

    const/16 v1, 0xa

    aput-object v3, v0, v1

    const/16 v1, 0xb

    aput-object v3, v0, v1

    const/16 v1, 0xc

    aput-object v3, v0, v1

    const/16 v1, 0xd

    aput-object v3, v0, v1

    const/16 v1, 0xe

    aput-object v3, v0, v1

    const/16 v1, 0xf

    aput-object v3, v0, v1

    const/16 v1, 0x10

    aput-object v3, v0, v1

    const/16 v1, 0x11

    aput-object v3, v0, v1

    const/16 v1, 0x12

    aput-object v3, v0, v1

    const/16 v1, 0x13

    aput-object v3, v0, v1

    const/16 v1, 0x14

    aput-object v3, v0, v1

    const/16 v1, 0x15

    aput-object v3, v0, v1

    const/16 v1, 0x16

    aput-object v3, v0, v1

    const/16 v1, 0x17

    aput-object v3, v0, v1

    const/16 v1, 0x18

    aput-object v3, v0, v1

    const/16 v1, 0x19

    aput-object v3, v0, v1

    const/16 v1, 0x1a

    aput-object v3, v0, v1

    const/16 v1, 0x1b

    aput-object v3, v0, v1

    const/16 v1, 0x1c

    aput-object v3, v0, v1

    const/16 v1, 0x1d

    aput-object v3, v0, v1

    const/16 v1, 0x1e

    aput-object v3, v0, v1

    const/16 v1, 0x1f

    aput-object v3, v0, v1

    const/16 v1, 0x20

    aput-object v3, v0, v1

    const/16 v1, 0x21

    aput-object v3, v0, v1

    const/16 v1, 0x22

    const-string v2, "&quot;"

    aput-object v2, v0, v1

    const/16 v1, 0x23

    aput-object v3, v0, v1

    const/16 v1, 0x24

    aput-object v3, v0, v1

    const/16 v1, 0x25

    aput-object v3, v0, v1

    const/16 v1, 0x26

    const-string v2, "&amp;"

    aput-object v2, v0, v1

    const/16 v1, 0x27

    aput-object v3, v0, v1

    const/16 v1, 0x28

    aput-object v3, v0, v1

    const/16 v1, 0x29

    aput-object v3, v0, v1

    const/16 v1, 0x2a

    aput-object v3, v0, v1

    const/16 v1, 0x2b

    aput-object v3, v0, v1

    const/16 v1, 0x2c

    aput-object v3, v0, v1

    const/16 v1, 0x2d

    aput-object v3, v0, v1

    const/16 v1, 0x2e

    aput-object v3, v0, v1

    const/16 v1, 0x2f

    aput-object v3, v0, v1

    const/16 v1, 0x30

    aput-object v3, v0, v1

    const/16 v1, 0x31

    aput-object v3, v0, v1

    const/16 v1, 0x32

    aput-object v3, v0, v1

    const/16 v1, 0x33

    aput-object v3, v0, v1

    const/16 v1, 0x34

    aput-object v3, v0, v1

    const/16 v1, 0x35

    aput-object v3, v0, v1

    const/16 v1, 0x36

    aput-object v3, v0, v1

    const/16 v1, 0x37

    aput-object v3, v0, v1

    const/16 v1, 0x38

    aput-object v3, v0, v1

    const/16 v1, 0x39

    aput-object v3, v0, v1

    const/16 v1, 0x3a

    aput-object v3, v0, v1

    const/16 v1, 0x3b

    aput-object v3, v0, v1

    const/16 v1, 0x3c

    const-string v2, "&lt;"

    aput-object v2, v0, v1

    const/16 v1, 0x3d

    aput-object v3, v0, v1

    const/16 v1, 0x3e

    const-string v2, "&gt;"

    aput-object v2, v0, v1

    const/16 v1, 0x3f

    aput-object v3, v0, v1

    sput-object v0, Lcom/android/internal/util/FastXmlSerializer;->ESCAPE_TABLE:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .registers 3

    .prologue
    const/16 v1, 0x2000

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    new-array v0, v1, [C

    iput-object v0, p0, Lcom/android/internal/util/FastXmlSerializer;->mText:[C

    invoke-static {v1}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v0

    iput-object v0, p0, Lcom/android/internal/util/FastXmlSerializer;->mBytes:Ljava/nio/ByteBuffer;

    return-void
.end method

.method private append(C)V
    .registers 4
    .parameter "c"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    iget v0, p0, Lcom/android/internal/util/FastXmlSerializer;->mPos:I

    .local v0, pos:I
    const/16 v1, 0x1fff

    if-lt v0, v1, :cond_b

    invoke-virtual {p0}, Lcom/android/internal/util/FastXmlSerializer;->flush()V

    iget v0, p0, Lcom/android/internal/util/FastXmlSerializer;->mPos:I

    :cond_b
    iget-object v1, p0, Lcom/android/internal/util/FastXmlSerializer;->mText:[C

    aput-char p1, v1, v0

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lcom/android/internal/util/FastXmlSerializer;->mPos:I

    return-void
.end method

.method private append(Ljava/lang/String;)V
    .registers 4
    .parameter "str"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    invoke-direct {p0, p1, v0, v1}, Lcom/android/internal/util/FastXmlSerializer;->append(Ljava/lang/String;II)V

    return-void
.end method

.method private append(Ljava/lang/String;II)V
    .registers 9
    .parameter "str"
    .parameter "i"
    .parameter "length"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v4, 0x2000

    if-le p3, v4, :cond_15

    add-int v0, p2, p3

    .local v0, end:I
    :goto_6
    if-ge p2, v0, :cond_2b

    add-int/lit16 v1, p2, 0x2000

    .local v1, next:I
    if-ge v1, v0, :cond_12

    move v3, v4

    :goto_d
    invoke-direct {p0, p1, p2, v3}, Lcom/android/internal/util/FastXmlSerializer;->append(Ljava/lang/String;II)V

    move p2, v1

    goto :goto_6

    :cond_12
    sub-int v3, v0, p2

    goto :goto_d

    .end local v0           #end:I
    .end local v1           #next:I
    :cond_15
    iget v2, p0, Lcom/android/internal/util/FastXmlSerializer;->mPos:I

    .local v2, pos:I
    add-int v3, v2, p3

    if-le v3, v4, :cond_20

    invoke-virtual {p0}, Lcom/android/internal/util/FastXmlSerializer;->flush()V

    iget v2, p0, Lcom/android/internal/util/FastXmlSerializer;->mPos:I

    :cond_20
    add-int v3, p2, p3

    iget-object v4, p0, Lcom/android/internal/util/FastXmlSerializer;->mText:[C

    invoke-virtual {p1, p2, v3, v4, v2}, Ljava/lang/String;->getChars(II[CI)V

    add-int v3, v2, p3

    iput v3, p0, Lcom/android/internal/util/FastXmlSerializer;->mPos:I

    .end local v2           #pos:I
    :cond_2b
    return-void
.end method

.method private append([CII)V
    .registers 9
    .parameter "buf"
    .parameter "i"
    .parameter "length"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v4, 0x2000

    if-le p3, v4, :cond_15

    add-int v0, p2, p3

    .local v0, end:I
    :goto_6
    if-ge p2, v0, :cond_29

    add-int/lit16 v1, p2, 0x2000

    .local v1, next:I
    if-ge v1, v0, :cond_12

    move v3, v4

    :goto_d
    invoke-direct {p0, p1, p2, v3}, Lcom/android/internal/util/FastXmlSerializer;->append([CII)V

    move p2, v1

    goto :goto_6

    :cond_12
    sub-int v3, v0, p2

    goto :goto_d

    .end local v0           #end:I
    .end local v1           #next:I
    :cond_15
    iget v2, p0, Lcom/android/internal/util/FastXmlSerializer;->mPos:I

    .local v2, pos:I
    add-int v3, v2, p3

    if-le v3, v4, :cond_20

    invoke-virtual {p0}, Lcom/android/internal/util/FastXmlSerializer;->flush()V

    iget v2, p0, Lcom/android/internal/util/FastXmlSerializer;->mPos:I

    :cond_20
    iget-object v3, p0, Lcom/android/internal/util/FastXmlSerializer;->mText:[C

    invoke-static {p1, p2, v3, v2, p3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    add-int v3, v2, p3

    iput v3, p0, Lcom/android/internal/util/FastXmlSerializer;->mPos:I

    .end local v2           #pos:I
    :cond_29
    return-void
.end method

.method private escapeAndAppendString(Ljava/lang/String;)V
    .registers 10
    .parameter "string"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    .local v0, N:I
    sget-object v7, Lcom/android/internal/util/FastXmlSerializer;->ESCAPE_TABLE:[Ljava/lang/String;

    array-length v7, v7

    int-to-char v1, v7

    .local v1, NE:C
    sget-object v4, Lcom/android/internal/util/FastXmlSerializer;->ESCAPE_TABLE:[Ljava/lang/String;

    .local v4, escapes:[Ljava/lang/String;
    const/4 v5, 0x0

    .local v5, lastPos:I
    const/4 v6, 0x0

    .local v6, pos:I
    :goto_c
    if-ge v6, v0, :cond_28

    invoke-virtual {p1, v6}, Ljava/lang/String;->charAt(I)C

    move-result v2

    .local v2, c:C
    if-lt v2, v1, :cond_17

    :cond_14
    :goto_14
    add-int/lit8 v6, v6, 0x1

    goto :goto_c

    :cond_17
    aget-object v3, v4, v2

    .local v3, escape:Ljava/lang/String;
    if-eqz v3, :cond_14

    if-ge v5, v6, :cond_22

    sub-int v7, v6, v5

    invoke-direct {p0, p1, v5, v7}, Lcom/android/internal/util/FastXmlSerializer;->append(Ljava/lang/String;II)V

    :cond_22
    add-int/lit8 v5, v6, 0x1

    invoke-direct {p0, v3}, Lcom/android/internal/util/FastXmlSerializer;->append(Ljava/lang/String;)V

    goto :goto_14

    .end local v2           #c:C
    .end local v3           #escape:Ljava/lang/String;
    :cond_28
    if-ge v5, v6, :cond_2f

    sub-int v7, v6, v5

    invoke-direct {p0, p1, v5, v7}, Lcom/android/internal/util/FastXmlSerializer;->append(Ljava/lang/String;II)V

    :cond_2f
    return-void
.end method

.method private escapeAndAppendString([CII)V
    .registers 12
    .parameter "buf"
    .parameter "start"
    .parameter "len"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    sget-object v7, Lcom/android/internal/util/FastXmlSerializer;->ESCAPE_TABLE:[Ljava/lang/String;

    array-length v7, v7

    int-to-char v0, v7

    .local v0, NE:C
    sget-object v4, Lcom/android/internal/util/FastXmlSerializer;->ESCAPE_TABLE:[Ljava/lang/String;

    .local v4, escapes:[Ljava/lang/String;
    add-int v2, p2, p3

    .local v2, end:I
    move v5, p2

    .local v5, lastPos:I
    move v6, p2

    .local v6, pos:I
    :goto_a
    if-ge v6, v2, :cond_24

    aget-char v1, p1, v6

    .local v1, c:C
    if-lt v1, v0, :cond_13

    :cond_10
    :goto_10
    add-int/lit8 v6, v6, 0x1

    goto :goto_a

    :cond_13
    aget-object v3, v4, v1

    .local v3, escape:Ljava/lang/String;
    if-eqz v3, :cond_10

    if-ge v5, v6, :cond_1e

    sub-int v7, v6, v5

    invoke-direct {p0, p1, v5, v7}, Lcom/android/internal/util/FastXmlSerializer;->append([CII)V

    :cond_1e
    add-int/lit8 v5, v6, 0x1

    invoke-direct {p0, v3}, Lcom/android/internal/util/FastXmlSerializer;->append(Ljava/lang/String;)V

    goto :goto_10

    .end local v1           #c:C
    .end local v3           #escape:Ljava/lang/String;
    :cond_24
    if-ge v5, v6, :cond_2b

    sub-int v7, v6, v5

    invoke-direct {p0, p1, v5, v7}, Lcom/android/internal/util/FastXmlSerializer;->append([CII)V

    :cond_2b
    return-void
.end method

.method private flushBytes()V
    .registers 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    iget-object v1, p0, Lcom/android/internal/util/FastXmlSerializer;->mBytes:Ljava/nio/ByteBuffer;

    invoke-virtual {v1}, Ljava/nio/ByteBuffer;->position()I

    move-result v0

    .local v0, position:I
    if-lez v0, :cond_1e

    iget-object v1, p0, Lcom/android/internal/util/FastXmlSerializer;->mBytes:Ljava/nio/ByteBuffer;

    invoke-virtual {v1}, Ljava/nio/ByteBuffer;->flip()Ljava/nio/Buffer;

    iget-object v1, p0, Lcom/android/internal/util/FastXmlSerializer;->mOutputStream:Ljava/io/OutputStream;

    iget-object v2, p0, Lcom/android/internal/util/FastXmlSerializer;->mBytes:Ljava/nio/ByteBuffer;

    invoke-virtual {v2}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3, v0}, Ljava/io/OutputStream;->write([BII)V

    iget-object v1, p0, Lcom/android/internal/util/FastXmlSerializer;->mBytes:Ljava/nio/ByteBuffer;

    invoke-virtual {v1}, Ljava/nio/ByteBuffer;->clear()Ljava/nio/Buffer;

    :cond_1e
    return-void
.end method


# virtual methods
.method public attribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    .registers 5
    .parameter "namespace"
    .parameter "name"
    .parameter "value"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const/16 v0, 0x20

    invoke-direct {p0, v0}, Lcom/android/internal/util/FastXmlSerializer;->append(C)V

    if-eqz p1, :cond_f

    invoke-direct {p0, p1}, Lcom/android/internal/util/FastXmlSerializer;->append(Ljava/lang/String;)V

    const/16 v0, 0x3a

    invoke-direct {p0, v0}, Lcom/android/internal/util/FastXmlSerializer;->append(C)V

    :cond_f
    invoke-direct {p0, p2}, Lcom/android/internal/util/FastXmlSerializer;->append(Ljava/lang/String;)V

    const-string v0, "=\""

    invoke-direct {p0, v0}, Lcom/android/internal/util/FastXmlSerializer;->append(Ljava/lang/String;)V

    invoke-direct {p0, p3}, Lcom/android/internal/util/FastXmlSerializer;->escapeAndAppendString(Ljava/lang/String;)V

    const/16 v0, 0x22

    invoke-direct {p0, v0}, Lcom/android/internal/util/FastXmlSerializer;->append(C)V

    return-object p0
.end method

.method public cdsect(Ljava/lang/String;)V
    .registers 3
    .parameter "text"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public comment(Ljava/lang/String;)V
    .registers 3
    .parameter "text"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public docdecl(Ljava/lang/String;)V
    .registers 3
    .parameter "text"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public endDocument()V
    .registers 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    invoke-virtual {p0}, Lcom/android/internal/util/FastXmlSerializer;->flush()V

    return-void
.end method

.method public endTag(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    .registers 4
    .parameter "namespace"
    .parameter "name"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    iget-boolean v0, p0, Lcom/android/internal/util/FastXmlSerializer;->mInTag:Z

    if-eqz v0, :cond_d

    const-string v0, " />\n"

    invoke-direct {p0, v0}, Lcom/android/internal/util/FastXmlSerializer;->append(Ljava/lang/String;)V

    :goto_9
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/internal/util/FastXmlSerializer;->mInTag:Z

    return-object p0

    :cond_d
    const-string v0, "</"

    invoke-direct {p0, v0}, Lcom/android/internal/util/FastXmlSerializer;->append(Ljava/lang/String;)V

    if-eqz p1, :cond_1c

    invoke-direct {p0, p1}, Lcom/android/internal/util/FastXmlSerializer;->append(Ljava/lang/String;)V

    const/16 v0, 0x3a

    invoke-direct {p0, v0}, Lcom/android/internal/util/FastXmlSerializer;->append(C)V

    :cond_1c
    invoke-direct {p0, p2}, Lcom/android/internal/util/FastXmlSerializer;->append(Ljava/lang/String;)V

    const-string v0, ">\n"

    invoke-direct {p0, v0}, Lcom/android/internal/util/FastXmlSerializer;->append(Ljava/lang/String;)V

    goto :goto_9
.end method

.method public entityRef(Ljava/lang/String;)V
    .registers 3
    .parameter "text"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public flush()V
    .registers 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    iget v2, p0, Lcom/android/internal/util/FastXmlSerializer;->mPos:I

    if-lez v2, :cond_46

    iget-object v2, p0, Lcom/android/internal/util/FastXmlSerializer;->mOutputStream:Ljava/io/OutputStream;

    if-eqz v2, :cond_47

    iget-object v2, p0, Lcom/android/internal/util/FastXmlSerializer;->mText:[C

    iget v3, p0, Lcom/android/internal/util/FastXmlSerializer;->mPos:I

    invoke-static {v2, v5, v3}, Ljava/nio/CharBuffer;->wrap([CII)Ljava/nio/CharBuffer;

    move-result-object v0

    .local v0, charBuffer:Ljava/nio/CharBuffer;
    iget-object v2, p0, Lcom/android/internal/util/FastXmlSerializer;->mCharset:Ljava/nio/charset/CharsetEncoder;

    iget-object v3, p0, Lcom/android/internal/util/FastXmlSerializer;->mBytes:Ljava/nio/ByteBuffer;

    invoke-virtual {v2, v0, v3, v4}, Ljava/nio/charset/CharsetEncoder;->encode(Ljava/nio/CharBuffer;Ljava/nio/ByteBuffer;Z)Ljava/nio/charset/CoderResult;

    move-result-object v1

    .local v1, result:Ljava/nio/charset/CoderResult;
    :goto_1a
    invoke-virtual {v1}, Ljava/nio/charset/CoderResult;->isError()Z

    move-result v2

    if-eqz v2, :cond_2a

    new-instance v2, Ljava/io/IOException;

    invoke-virtual {v1}, Ljava/nio/charset/CoderResult;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v2

    :cond_2a
    invoke-virtual {v1}, Ljava/nio/charset/CoderResult;->isOverflow()Z

    move-result v2

    if-eqz v2, :cond_3c

    invoke-direct {p0}, Lcom/android/internal/util/FastXmlSerializer;->flushBytes()V

    iget-object v2, p0, Lcom/android/internal/util/FastXmlSerializer;->mCharset:Ljava/nio/charset/CharsetEncoder;

    iget-object v3, p0, Lcom/android/internal/util/FastXmlSerializer;->mBytes:Ljava/nio/ByteBuffer;

    invoke-virtual {v2, v0, v3, v4}, Ljava/nio/charset/CharsetEncoder;->encode(Ljava/nio/CharBuffer;Ljava/nio/ByteBuffer;Z)Ljava/nio/charset/CoderResult;

    move-result-object v1

    goto :goto_1a

    :cond_3c
    invoke-direct {p0}, Lcom/android/internal/util/FastXmlSerializer;->flushBytes()V

    iget-object v2, p0, Lcom/android/internal/util/FastXmlSerializer;->mOutputStream:Ljava/io/OutputStream;

    invoke-virtual {v2}, Ljava/io/OutputStream;->flush()V

    .end local v0           #charBuffer:Ljava/nio/CharBuffer;
    .end local v1           #result:Ljava/nio/charset/CoderResult;
    :goto_44
    iput v5, p0, Lcom/android/internal/util/FastXmlSerializer;->mPos:I

    :cond_46
    return-void

    :cond_47
    iget-object v2, p0, Lcom/android/internal/util/FastXmlSerializer;->mWriter:Ljava/io/Writer;

    iget-object v3, p0, Lcom/android/internal/util/FastXmlSerializer;->mText:[C

    iget v4, p0, Lcom/android/internal/util/FastXmlSerializer;->mPos:I

    invoke-virtual {v2, v3, v5, v4}, Ljava/io/Writer;->write([CII)V

    iget-object v2, p0, Lcom/android/internal/util/FastXmlSerializer;->mWriter:Ljava/io/Writer;

    invoke-virtual {v2}, Ljava/io/Writer;->flush()V

    goto :goto_44
.end method

.method public getDepth()I
    .registers 2

    .prologue
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public getFeature(Ljava/lang/String;)Z
    .registers 3
    .parameter "name"

    .prologue
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public getName()Ljava/lang/String;
    .registers 2

    .prologue
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public getNamespace()Ljava/lang/String;
    .registers 2

    .prologue
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public getPrefix(Ljava/lang/String;Z)Ljava/lang/String;
    .registers 4
    .parameter "namespace"
    .parameter "generatePrefix"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public getProperty(Ljava/lang/String;)Ljava/lang/Object;
    .registers 3
    .parameter "name"

    .prologue
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public ignorableWhitespace(Ljava/lang/String;)V
    .registers 3
    .parameter "text"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public processingInstruction(Ljava/lang/String;)V
    .registers 3
    .parameter "text"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public setFeature(Ljava/lang/String;Z)V
    .registers 4
    .parameter "name"
    .parameter "state"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const-string v0, "http://xmlpull.org/v1/doc/features.html#indent-output"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9

    return-void

    :cond_9
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public setOutput(Ljava/io/OutputStream;Ljava/lang/String;)V
    .registers 5
    .parameter "os"
    .parameter "encoding"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    if-nez p1, :cond_8

    new-instance v1, Ljava/lang/IllegalArgumentException;

    invoke-direct {v1}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v1

    :cond_8
    :try_start_8
    invoke-static {p2}, Ljava/nio/charset/Charset;->forName(Ljava/lang/String;)Ljava/nio/charset/Charset;

    move-result-object v1

    invoke-virtual {v1}, Ljava/nio/charset/Charset;->newEncoder()Ljava/nio/charset/CharsetEncoder;

    move-result-object v1

    iput-object v1, p0, Lcom/android/internal/util/FastXmlSerializer;->mCharset:Ljava/nio/charset/CharsetEncoder;
    :try_end_12
    .catch Ljava/nio/charset/IllegalCharsetNameException; {:try_start_8 .. :try_end_12} :catch_15
    .catch Ljava/nio/charset/UnsupportedCharsetException; {:try_start_8 .. :try_end_12} :catch_24

    iput-object p1, p0, Lcom/android/internal/util/FastXmlSerializer;->mOutputStream:Ljava/io/OutputStream;

    return-void

    :catch_15
    move-exception v0

    .local v0, e:Ljava/nio/charset/IllegalCharsetNameException;
    new-instance v1, Ljava/io/UnsupportedEncodingException;

    invoke-direct {v1, p2}, Ljava/io/UnsupportedEncodingException;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/io/UnsupportedEncodingException;->initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    move-result-object v1

    check-cast v1, Ljava/io/UnsupportedEncodingException;

    check-cast v1, Ljava/io/UnsupportedEncodingException;

    throw v1

    .end local v0           #e:Ljava/nio/charset/IllegalCharsetNameException;
    :catch_24
    move-exception v0

    .local v0, e:Ljava/nio/charset/UnsupportedCharsetException;
    new-instance v1, Ljava/io/UnsupportedEncodingException;

    invoke-direct {v1, p2}, Ljava/io/UnsupportedEncodingException;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/io/UnsupportedEncodingException;->initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    move-result-object v1

    check-cast v1, Ljava/io/UnsupportedEncodingException;

    check-cast v1, Ljava/io/UnsupportedEncodingException;

    throw v1
.end method

.method public setOutput(Ljava/io/Writer;)V
    .registers 2
    .parameter "writer"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    iput-object p1, p0, Lcom/android/internal/util/FastXmlSerializer;->mWriter:Ljava/io/Writer;

    return-void
.end method

.method public setPrefix(Ljava/lang/String;Ljava/lang/String;)V
    .registers 4
    .parameter "prefix"
    .parameter "namespace"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public setProperty(Ljava/lang/String;Ljava/lang/Object;)V
    .registers 4
    .parameter "name"
    .parameter "value"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public startDocument(Ljava/lang/String;Ljava/lang/Boolean;)V
    .registers 5
    .parameter "encoding"
    .parameter "standalone"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "<?xml version=\'1.0\' encoding=\'utf-8\' standalone=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_26

    const-string/jumbo v0, "yes"

    :goto_14
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\' ?>\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/android/internal/util/FastXmlSerializer;->append(Ljava/lang/String;)V

    return-void

    :cond_26
    const-string/jumbo v0, "no"

    goto :goto_14
.end method

.method public startTag(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    .registers 4
    .parameter "namespace"
    .parameter "name"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    iget-boolean v0, p0, Lcom/android/internal/util/FastXmlSerializer;->mInTag:Z

    if-eqz v0, :cond_9

    const-string v0, ">\n"

    invoke-direct {p0, v0}, Lcom/android/internal/util/FastXmlSerializer;->append(Ljava/lang/String;)V

    :cond_9
    const/16 v0, 0x3c

    invoke-direct {p0, v0}, Lcom/android/internal/util/FastXmlSerializer;->append(C)V

    if-eqz p1, :cond_18

    invoke-direct {p0, p1}, Lcom/android/internal/util/FastXmlSerializer;->append(Ljava/lang/String;)V

    const/16 v0, 0x3a

    invoke-direct {p0, v0}, Lcom/android/internal/util/FastXmlSerializer;->append(C)V

    :cond_18
    invoke-direct {p0, p2}, Lcom/android/internal/util/FastXmlSerializer;->append(Ljava/lang/String;)V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/internal/util/FastXmlSerializer;->mInTag:Z

    return-object p0
.end method

.method public text(Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    .registers 3
    .parameter "text"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    iget-boolean v0, p0, Lcom/android/internal/util/FastXmlSerializer;->mInTag:Z

    if-eqz v0, :cond_c

    const-string v0, ">"

    invoke-direct {p0, v0}, Lcom/android/internal/util/FastXmlSerializer;->append(Ljava/lang/String;)V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/internal/util/FastXmlSerializer;->mInTag:Z

    :cond_c
    invoke-direct {p0, p1}, Lcom/android/internal/util/FastXmlSerializer;->escapeAndAppendString(Ljava/lang/String;)V

    return-object p0
.end method

.method public text([CII)Lorg/xmlpull/v1/XmlSerializer;
    .registers 5
    .parameter "buf"
    .parameter "start"
    .parameter "len"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    iget-boolean v0, p0, Lcom/android/internal/util/FastXmlSerializer;->mInTag:Z

    if-eqz v0, :cond_c

    const-string v0, ">"

    invoke-direct {p0, v0}, Lcom/android/internal/util/FastXmlSerializer;->append(Ljava/lang/String;)V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/internal/util/FastXmlSerializer;->mInTag:Z

    :cond_c
    invoke-direct {p0, p1, p2, p3}, Lcom/android/internal/util/FastXmlSerializer;->escapeAndAppendString([CII)V

    return-object p0
.end method
