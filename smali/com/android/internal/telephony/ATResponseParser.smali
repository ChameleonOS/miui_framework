.class public Lcom/android/internal/telephony/ATResponseParser;
.super Ljava/lang/Object;
.source "ATResponseParser.java"


# instance fields
.field private line:Ljava/lang/String;

.field private next:I

.field private tokEnd:I

.field private tokStart:I


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .registers 3
    .parameter "line"

    .prologue
    .line 34
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 27
    const/4 v0, 0x0

    iput v0, p0, Lcom/android/internal/telephony/ATResponseParser;->next:I

    .line 35
    iput-object p1, p0, Lcom/android/internal/telephony/ATResponseParser;->line:Ljava/lang/String;

    .line 36
    return-void
.end method

.method private nextTok()V
    .registers 10

    .prologue
    const/16 v8, 0x2c

    const/16 v7, 0x22

    .line 98
    iget-object v4, p0, Lcom/android/internal/telephony/ATResponseParser;->line:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v3

    .line 100
    .local v3, len:I
    iget v4, p0, Lcom/android/internal/telephony/ATResponseParser;->next:I

    if-nez v4, :cond_11

    .line 101
    invoke-direct {p0}, Lcom/android/internal/telephony/ATResponseParser;->skipPrefix()V

    .line 104
    :cond_11
    iget v4, p0, Lcom/android/internal/telephony/ATResponseParser;->next:I

    if-lt v4, v3, :cond_1b

    .line 105
    new-instance v4, Lcom/android/internal/telephony/ATParseEx;

    invoke-direct {v4}, Lcom/android/internal/telephony/ATParseEx;-><init>()V

    throw v4

    .line 111
    :cond_1b
    :try_start_1b
    iget-object v4, p0, Lcom/android/internal/telephony/ATResponseParser;->line:Ljava/lang/String;

    iget v5, p0, Lcom/android/internal/telephony/ATResponseParser;->next:I

    add-int/lit8 v6, v5, 0x1

    iput v6, p0, Lcom/android/internal/telephony/ATResponseParser;->next:I

    invoke-virtual {v4, v5}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 112
    .local v0, c:C
    const/4 v2, 0x0

    .line 114
    .local v2, hasQuote:Z
    invoke-direct {p0, v0}, Lcom/android/internal/telephony/ATResponseParser;->skipWhiteSpace(C)C

    move-result v0

    .line 116
    if-ne v0, v7, :cond_8a

    .line 117
    iget v4, p0, Lcom/android/internal/telephony/ATResponseParser;->next:I

    if-lt v4, v3, :cond_3f

    .line 118
    new-instance v4, Lcom/android/internal/telephony/ATParseEx;

    invoke-direct {v4}, Lcom/android/internal/telephony/ATParseEx;-><init>()V

    throw v4
    :try_end_38
    .catch Ljava/lang/StringIndexOutOfBoundsException; {:try_start_1b .. :try_end_38} :catch_38

    .line 145
    .end local v0           #c:C
    .end local v2           #hasQuote:Z
    :catch_38
    move-exception v1

    .line 146
    .local v1, ex:Ljava/lang/StringIndexOutOfBoundsException;
    new-instance v4, Lcom/android/internal/telephony/ATParseEx;

    invoke-direct {v4}, Lcom/android/internal/telephony/ATParseEx;-><init>()V

    throw v4

    .line 120
    .end local v1           #ex:Ljava/lang/StringIndexOutOfBoundsException;
    .restart local v0       #c:C
    .restart local v2       #hasQuote:Z
    :cond_3f
    :try_start_3f
    iget-object v4, p0, Lcom/android/internal/telephony/ATResponseParser;->line:Ljava/lang/String;

    iget v5, p0, Lcom/android/internal/telephony/ATResponseParser;->next:I

    add-int/lit8 v6, v5, 0x1

    iput v6, p0, Lcom/android/internal/telephony/ATResponseParser;->next:I

    invoke-virtual {v4, v5}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 121
    iget v4, p0, Lcom/android/internal/telephony/ATResponseParser;->next:I

    add-int/lit8 v4, v4, -0x1

    iput v4, p0, Lcom/android/internal/telephony/ATResponseParser;->tokStart:I

    .line 122
    :goto_51
    if-eq v0, v7, :cond_64

    iget v4, p0, Lcom/android/internal/telephony/ATResponseParser;->next:I

    if-ge v4, v3, :cond_64

    .line 123
    iget-object v4, p0, Lcom/android/internal/telephony/ATResponseParser;->line:Ljava/lang/String;

    iget v5, p0, Lcom/android/internal/telephony/ATResponseParser;->next:I

    add-int/lit8 v6, v5, 0x1

    iput v6, p0, Lcom/android/internal/telephony/ATResponseParser;->next:I

    invoke-virtual {v4, v5}, Ljava/lang/String;->charAt(I)C

    move-result v0

    goto :goto_51

    .line 125
    :cond_64
    if-eq v0, v7, :cond_6c

    .line 126
    new-instance v4, Lcom/android/internal/telephony/ATParseEx;

    invoke-direct {v4}, Lcom/android/internal/telephony/ATParseEx;-><init>()V

    throw v4

    .line 128
    :cond_6c
    iget v4, p0, Lcom/android/internal/telephony/ATResponseParser;->next:I

    add-int/lit8 v4, v4, -0x1

    iput v4, p0, Lcom/android/internal/telephony/ATResponseParser;->tokEnd:I

    .line 129
    iget v4, p0, Lcom/android/internal/telephony/ATResponseParser;->next:I

    if-ge v4, v3, :cond_a4

    iget-object v4, p0, Lcom/android/internal/telephony/ATResponseParser;->line:Ljava/lang/String;

    iget v5, p0, Lcom/android/internal/telephony/ATResponseParser;->next:I

    add-int/lit8 v6, v5, 0x1

    iput v6, p0, Lcom/android/internal/telephony/ATResponseParser;->next:I

    invoke-virtual {v4, v5}, Ljava/lang/String;->charAt(I)C

    move-result v4

    if-eq v4, v8, :cond_a4

    .line 130
    new-instance v4, Lcom/android/internal/telephony/ATParseEx;

    invoke-direct {v4}, Lcom/android/internal/telephony/ATParseEx;-><init>()V

    throw v4

    .line 133
    :cond_8a
    iget v4, p0, Lcom/android/internal/telephony/ATResponseParser;->next:I

    add-int/lit8 v4, v4, -0x1

    iput v4, p0, Lcom/android/internal/telephony/ATResponseParser;->tokStart:I

    .line 134
    iget v4, p0, Lcom/android/internal/telephony/ATResponseParser;->tokStart:I

    iput v4, p0, Lcom/android/internal/telephony/ATResponseParser;->tokEnd:I

    .line 135
    :goto_94
    if-eq v0, v8, :cond_a4

    .line 136
    invoke-static {v0}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result v4

    if-nez v4, :cond_a0

    .line 137
    iget v4, p0, Lcom/android/internal/telephony/ATResponseParser;->next:I

    iput v4, p0, Lcom/android/internal/telephony/ATResponseParser;->tokEnd:I

    .line 139
    :cond_a0
    iget v4, p0, Lcom/android/internal/telephony/ATResponseParser;->next:I

    if-ne v4, v3, :cond_a5

    .line 148
    :cond_a4
    return-void

    .line 142
    :cond_a5
    iget-object v4, p0, Lcom/android/internal/telephony/ATResponseParser;->line:Ljava/lang/String;

    iget v5, p0, Lcom/android/internal/telephony/ATResponseParser;->next:I

    add-int/lit8 v6, v5, 0x1

    iput v6, p0, Lcom/android/internal/telephony/ATResponseParser;->next:I

    invoke-virtual {v4, v5}, Ljava/lang/String;->charAt(I)C
    :try_end_b0
    .catch Ljava/lang/StringIndexOutOfBoundsException; {:try_start_3f .. :try_end_b0} :catch_38

    move-result v0

    goto :goto_94
.end method

.method private skipPrefix()V
    .registers 6

    .prologue
    .line 173
    const/4 v2, 0x0

    iput v2, p0, Lcom/android/internal/telephony/ATResponseParser;->next:I

    .line 174
    iget-object v2, p0, Lcom/android/internal/telephony/ATResponseParser;->line:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v1

    .line 175
    .local v1, s:I
    :cond_9
    iget v2, p0, Lcom/android/internal/telephony/ATResponseParser;->next:I

    if-ge v2, v1, :cond_1e

    .line 176
    iget-object v2, p0, Lcom/android/internal/telephony/ATResponseParser;->line:Ljava/lang/String;

    iget v3, p0, Lcom/android/internal/telephony/ATResponseParser;->next:I

    add-int/lit8 v4, v3, 0x1

    iput v4, p0, Lcom/android/internal/telephony/ATResponseParser;->next:I

    invoke-virtual {v2, v3}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 178
    .local v0, c:C
    const/16 v2, 0x3a

    if-ne v0, v2, :cond_9

    .line 179
    return-void

    .line 183
    .end local v0           #c:C
    :cond_1e
    new-instance v2, Lcom/android/internal/telephony/ATParseEx;

    const-string/jumbo v3, "missing prefix"

    invoke-direct {v2, v3}, Lcom/android/internal/telephony/ATParseEx;-><init>(Ljava/lang/String;)V

    throw v2
.end method

.method private skipWhiteSpace(C)C
    .registers 6
    .parameter "c"

    .prologue
    .line 156
    iget-object v1, p0, Lcom/android/internal/telephony/ATResponseParser;->line:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v0

    .line 157
    .local v0, len:I
    :goto_6
    iget v1, p0, Lcom/android/internal/telephony/ATResponseParser;->next:I

    if-ge v1, v0, :cond_1d

    invoke-static {p1}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result v1

    if-eqz v1, :cond_1d

    .line 158
    iget-object v1, p0, Lcom/android/internal/telephony/ATResponseParser;->line:Ljava/lang/String;

    iget v2, p0, Lcom/android/internal/telephony/ATResponseParser;->next:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/android/internal/telephony/ATResponseParser;->next:I

    invoke-virtual {v1, v2}, Ljava/lang/String;->charAt(I)C

    move-result p1

    goto :goto_6

    .line 161
    :cond_1d
    invoke-static {p1}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result v1

    if-eqz v1, :cond_29

    .line 162
    new-instance v1, Lcom/android/internal/telephony/ATParseEx;

    invoke-direct {v1}, Lcom/android/internal/telephony/ATParseEx;-><init>()V

    throw v1

    .line 164
    :cond_29
    return p1
.end method


# virtual methods
.method public hasMore()Z
    .registers 3

    .prologue
    .line 92
    iget v0, p0, Lcom/android/internal/telephony/ATResponseParser;->next:I

    iget-object v1, p0, Lcom/android/internal/telephony/ATResponseParser;->line:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-ge v0, v1, :cond_c

    const/4 v0, 0x1

    :goto_b
    return v0

    :cond_c
    const/4 v0, 0x0

    goto :goto_b
.end method

.method public nextBoolean()Z
    .registers 5

    .prologue
    const/4 v1, 0x1

    .line 44
    invoke-direct {p0}, Lcom/android/internal/telephony/ATResponseParser;->nextTok()V

    .line 46
    iget v2, p0, Lcom/android/internal/telephony/ATResponseParser;->tokEnd:I

    iget v3, p0, Lcom/android/internal/telephony/ATResponseParser;->tokStart:I

    sub-int/2addr v2, v3

    if-le v2, v1, :cond_11

    .line 47
    new-instance v1, Lcom/android/internal/telephony/ATParseEx;

    invoke-direct {v1}, Lcom/android/internal/telephony/ATParseEx;-><init>()V

    throw v1

    .line 49
    :cond_11
    iget-object v2, p0, Lcom/android/internal/telephony/ATResponseParser;->line:Ljava/lang/String;

    iget v3, p0, Lcom/android/internal/telephony/ATResponseParser;->tokStart:I

    invoke-virtual {v2, v3}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 51
    .local v0, c:C
    const/16 v2, 0x30

    if-ne v0, v2, :cond_1f

    const/4 v1, 0x0

    .line 52
    :cond_1e
    return v1

    :cond_1f
    const/16 v2, 0x31

    if-eq v0, v2, :cond_1e

    .line 53
    new-instance v1, Lcom/android/internal/telephony/ATParseEx;

    invoke-direct {v1}, Lcom/android/internal/telephony/ATParseEx;-><init>()V

    throw v1
.end method

.method public nextInt()I
    .registers 5

    .prologue
    .line 62
    const/4 v2, 0x0

    .line 64
    .local v2, ret:I
    invoke-direct {p0}, Lcom/android/internal/telephony/ATResponseParser;->nextTok()V

    .line 66
    iget v1, p0, Lcom/android/internal/telephony/ATResponseParser;->tokStart:I

    .local v1, i:I
    :goto_6
    iget v3, p0, Lcom/android/internal/telephony/ATResponseParser;->tokEnd:I

    if-ge v1, v3, :cond_26

    .line 67
    iget-object v3, p0, Lcom/android/internal/telephony/ATResponseParser;->line:Ljava/lang/String;

    invoke-virtual {v3, v1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 70
    .local v0, c:C
    const/16 v3, 0x30

    if-lt v0, v3, :cond_18

    const/16 v3, 0x39

    if-le v0, v3, :cond_1e

    .line 71
    :cond_18
    new-instance v3, Lcom/android/internal/telephony/ATParseEx;

    invoke-direct {v3}, Lcom/android/internal/telephony/ATParseEx;-><init>()V

    throw v3

    .line 74
    :cond_1e
    mul-int/lit8 v2, v2, 0xa

    .line 75
    add-int/lit8 v3, v0, -0x30

    add-int/2addr v2, v3

    .line 66
    add-int/lit8 v1, v1, 0x1

    goto :goto_6

    .line 78
    .end local v0           #c:C
    :cond_26
    return v2
.end method

.method public nextString()Ljava/lang/String;
    .registers 4

    .prologue
    .line 84
    invoke-direct {p0}, Lcom/android/internal/telephony/ATResponseParser;->nextTok()V

    .line 86
    iget-object v0, p0, Lcom/android/internal/telephony/ATResponseParser;->line:Ljava/lang/String;

    iget v1, p0, Lcom/android/internal/telephony/ATResponseParser;->tokStart:I

    iget v2, p0, Lcom/android/internal/telephony/ATResponseParser;->tokEnd:I

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
