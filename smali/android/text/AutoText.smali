.class public Landroid/text/AutoText;
.super Ljava/lang/Object;
.source "AutoText.java"


# static fields
.field private static final DEFAULT:I = 0x3801

.field private static final INCREMENT:I = 0x400

.field private static final RIGHT:I = 0x2454

.field private static final TRIE_C:I = 0x0

.field private static final TRIE_CHILD:I = 0x2

.field private static final TRIE_NEXT:I = 0x3

.field private static final TRIE_NULL:C = '\uffff'

.field private static final TRIE_OFF:I = 0x1

.field private static final TRIE_ROOT:I = 0x0

.field private static final TRIE_SIZEOF:I = 0x4

.field private static sInstance:Landroid/text/AutoText;

.field private static sLock:Ljava/lang/Object;


# instance fields
.field private mLocale:Ljava/util/Locale;

.field private mSize:I

.field private mText:Ljava/lang/String;

.field private mTrie:[C

.field private mTrieUsed:C


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    .line 58
    new-instance v0, Landroid/text/AutoText;

    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/text/AutoText;-><init>(Landroid/content/res/Resources;)V

    sput-object v0, Landroid/text/AutoText;->sInstance:Landroid/text/AutoText;

    .line 59
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Landroid/text/AutoText;->sLock:Ljava/lang/Object;

    return-void
.end method

.method private constructor <init>(Landroid/content/res/Resources;)V
    .registers 3
    .parameter "resources"

    .prologue
    .line 76
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 77
    invoke-virtual {p1}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget-object v0, v0, Landroid/content/res/Configuration;->locale:Ljava/util/Locale;

    iput-object v0, p0, Landroid/text/AutoText;->mLocale:Ljava/util/Locale;

    .line 78
    invoke-direct {p0, p1}, Landroid/text/AutoText;->init(Landroid/content/res/Resources;)V

    .line 79
    return-void
.end method

.method private add(Ljava/lang/String;C)V
    .registers 12
    .parameter "src"
    .parameter "off"

    .prologue
    const v8, 0xffff

    .line 213
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v5

    .line 214
    .local v5, slen:I
    const/4 v2, 0x0

    .line 216
    .local v2, herep:I
    iget v6, p0, Landroid/text/AutoText;->mSize:I

    add-int/lit8 v6, v6, 0x1

    iput v6, p0, Landroid/text/AutoText;->mSize:I

    .line 218
    const/4 v3, 0x0

    .local v3, i:I
    :goto_f
    if-ge v3, v5, :cond_36

    .line 219
    invoke-virtual {p1, v3}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 220
    .local v0, c:C
    const/4 v1, 0x0

    .line 222
    .local v1, found:Z
    :goto_16
    iget-object v6, p0, Landroid/text/AutoText;->mTrie:[C

    aget-char v6, v6, v2

    if-eq v6, v8, :cond_3e

    .line 224
    iget-object v6, p0, Landroid/text/AutoText;->mTrie:[C

    iget-object v7, p0, Landroid/text/AutoText;->mTrie:[C

    aget-char v7, v7, v2

    add-int/lit8 v7, v7, 0x0

    aget-char v6, v6, v7

    if-ne v0, v6, :cond_7f

    .line 228
    add-int/lit8 v6, v5, -0x1

    if-ne v3, v6, :cond_37

    .line 229
    iget-object v6, p0, Landroid/text/AutoText;->mTrie:[C

    iget-object v7, p0, Landroid/text/AutoText;->mTrie:[C

    aget-char v7, v7, v2

    add-int/lit8 v7, v7, 0x1

    aput-char p2, v6, v7

    .line 265
    .end local v0           #c:C
    .end local v1           #found:Z
    :cond_36
    :goto_36
    return-void

    .line 236
    .restart local v0       #c:C
    .restart local v1       #found:Z
    :cond_37
    iget-object v6, p0, Landroid/text/AutoText;->mTrie:[C

    aget-char v6, v6, v2

    add-int/lit8 v2, v6, 0x2

    .line 237
    const/4 v1, 0x1

    .line 242
    :cond_3e
    if-nez v1, :cond_8c

    .line 245
    invoke-direct {p0}, Landroid/text/AutoText;->newTrieNode()C

    move-result v4

    .line 246
    .local v4, node:C
    iget-object v6, p0, Landroid/text/AutoText;->mTrie:[C

    aput-char v4, v6, v2

    .line 248
    iget-object v6, p0, Landroid/text/AutoText;->mTrie:[C

    iget-object v7, p0, Landroid/text/AutoText;->mTrie:[C

    aget-char v7, v7, v2

    add-int/lit8 v7, v7, 0x0

    aput-char v0, v6, v7

    .line 249
    iget-object v6, p0, Landroid/text/AutoText;->mTrie:[C

    iget-object v7, p0, Landroid/text/AutoText;->mTrie:[C

    aget-char v7, v7, v2

    add-int/lit8 v7, v7, 0x1

    aput-char v8, v6, v7

    .line 250
    iget-object v6, p0, Landroid/text/AutoText;->mTrie:[C

    iget-object v7, p0, Landroid/text/AutoText;->mTrie:[C

    aget-char v7, v7, v2

    add-int/lit8 v7, v7, 0x3

    aput-char v8, v6, v7

    .line 251
    iget-object v6, p0, Landroid/text/AutoText;->mTrie:[C

    iget-object v7, p0, Landroid/text/AutoText;->mTrie:[C

    aget-char v7, v7, v2

    add-int/lit8 v7, v7, 0x2

    aput-char v8, v6, v7

    .line 255
    add-int/lit8 v6, v5, -0x1

    if-ne v3, v6, :cond_86

    .line 256
    iget-object v6, p0, Landroid/text/AutoText;->mTrie:[C

    iget-object v7, p0, Landroid/text/AutoText;->mTrie:[C

    aget-char v7, v7, v2

    add-int/lit8 v7, v7, 0x1

    aput-char p2, v6, v7

    goto :goto_36

    .line 223
    .end local v4           #node:C
    :cond_7f
    iget-object v6, p0, Landroid/text/AutoText;->mTrie:[C

    aget-char v6, v6, v2

    add-int/lit8 v2, v6, 0x3

    goto :goto_16

    .line 262
    .restart local v4       #node:C
    :cond_86
    iget-object v6, p0, Landroid/text/AutoText;->mTrie:[C

    aget-char v6, v6, v2

    add-int/lit8 v2, v6, 0x2

    .line 218
    .end local v4           #node:C
    :cond_8c
    add-int/lit8 v3, v3, 0x1

    goto :goto_f
.end method

.method public static get(Ljava/lang/CharSequence;IILandroid/view/View;)Ljava/lang/String;
    .registers 5
    .parameter "src"
    .parameter "start"
    .parameter "end"
    .parameter "view"

    .prologue
    .line 111
    invoke-static {p3}, Landroid/text/AutoText;->getInstance(Landroid/view/View;)Landroid/text/AutoText;

    move-result-object v0

    invoke-direct {v0, p0, p1, p2}, Landroid/text/AutoText;->lookup(Ljava/lang/CharSequence;II)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static getInstance(Landroid/view/View;)Landroid/text/AutoText;
    .registers 6
    .parameter "view"

    .prologue
    .line 88
    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 89
    .local v2, res:Landroid/content/res/Resources;
    invoke-virtual {v2}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v3

    iget-object v1, v3, Landroid/content/res/Configuration;->locale:Ljava/util/Locale;

    .line 92
    .local v1, locale:Ljava/util/Locale;
    sget-object v4, Landroid/text/AutoText;->sLock:Ljava/lang/Object;

    monitor-enter v4

    .line 93
    :try_start_11
    sget-object v0, Landroid/text/AutoText;->sInstance:Landroid/text/AutoText;

    .line 95
    .local v0, instance:Landroid/text/AutoText;
    iget-object v3, v0, Landroid/text/AutoText;->mLocale:Ljava/util/Locale;

    invoke-virtual {v1, v3}, Ljava/util/Locale;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_22

    .line 96
    new-instance v0, Landroid/text/AutoText;

    .end local v0           #instance:Landroid/text/AutoText;
    invoke-direct {v0, v2}, Landroid/text/AutoText;-><init>(Landroid/content/res/Resources;)V

    .line 97
    .restart local v0       #instance:Landroid/text/AutoText;
    sput-object v0, Landroid/text/AutoText;->sInstance:Landroid/text/AutoText;

    .line 99
    :cond_22
    monitor-exit v4

    .line 101
    return-object v0

    .line 99
    .end local v0           #instance:Landroid/text/AutoText;
    :catchall_24
    move-exception v3

    monitor-exit v4
    :try_end_26
    .catchall {:try_start_11 .. :try_end_26} :catchall_24

    throw v3
.end method

.method private getSize()I
    .registers 2

    .prologue
    .line 129
    iget v0, p0, Landroid/text/AutoText;->mSize:I

    return v0
.end method

.method public static getSize(Landroid/view/View;)I
    .registers 2
    .parameter "view"

    .prologue
    .line 122
    invoke-static {p0}, Landroid/text/AutoText;->getInstance(Landroid/view/View;)Landroid/text/AutoText;

    move-result-object v0

    invoke-direct {v0}, Landroid/text/AutoText;->getSize()I

    move-result v0

    return v0
.end method

.method private init(Landroid/content/res/Resources;)V
    .registers 14
    .parameter "r"

    .prologue
    .line 162
    const v9, 0x10f0001

    invoke-virtual {p1, v9}, Landroid/content/res/Resources;->getXml(I)Landroid/content/res/XmlResourceParser;

    move-result-object v6

    .line 164
    .local v6, parser:Landroid/content/res/XmlResourceParser;
    new-instance v7, Ljava/lang/StringBuilder;

    const/16 v9, 0x2454

    invoke-direct {v7, v9}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 165
    .local v7, right:Ljava/lang/StringBuilder;
    const/16 v9, 0x3801

    new-array v9, v9, [C

    iput-object v9, p0, Landroid/text/AutoText;->mTrie:[C

    .line 166
    iget-object v9, p0, Landroid/text/AutoText;->mTrie:[C

    const/4 v10, 0x0

    const v11, 0xffff

    aput-char v11, v9, v10

    .line 167
    const/4 v9, 0x1

    iput-char v9, p0, Landroid/text/AutoText;->mTrieUsed:C

    .line 170
    :try_start_1f
    const-string/jumbo v9, "words"

    invoke-static {v6, v9}, Lcom/android/internal/util/XmlUtils;->beginDocument(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)V

    .line 171
    const-string v3, ""

    .line 172
    .local v3, odest:Ljava/lang/String;
    const/4 v5, 0x0

    .line 175
    .local v5, ooff:C
    :cond_28
    :goto_28
    invoke-static {v6}, Lcom/android/internal/util/XmlUtils;->nextElement(Lorg/xmlpull/v1/XmlPullParser;)V

    .line 177
    invoke-interface {v6}, Landroid/content/res/XmlResourceParser;->getName()Ljava/lang/String;

    move-result-object v2

    .line 178
    .local v2, element:Ljava/lang/String;
    if-eqz v2, :cond_3a

    const-string/jumbo v9, "word"

    invoke-virtual {v2, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_47

    .line 200
    :cond_3a
    invoke-virtual {p1}, Landroid/content/res/Resources;->flushLayoutCache()V
    :try_end_3d
    .catchall {:try_start_1f .. :try_end_3d} :catchall_6c
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_1f .. :try_end_3d} :catch_65
    .catch Ljava/io/IOException; {:try_start_1f .. :try_end_3d} :catch_82

    .line 206
    invoke-interface {v6}, Landroid/content/res/XmlResourceParser;->close()V

    .line 209
    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    iput-object v9, p0, Landroid/text/AutoText;->mText:Ljava/lang/String;

    .line 210
    return-void

    .line 182
    :cond_47
    const/4 v9, 0x0

    :try_start_48
    const-string/jumbo v10, "src"

    invoke-interface {v6, v9, v10}, Landroid/content/res/XmlResourceParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 183
    .local v8, src:Ljava/lang/String;
    invoke-interface {v6}, Landroid/content/res/XmlResourceParser;->next()I

    move-result v9

    const/4 v10, 0x4

    if-ne v9, v10, :cond_28

    .line 184
    invoke-interface {v6}, Landroid/content/res/XmlResourceParser;->getText()Ljava/lang/String;

    move-result-object v0

    .line 187
    .local v0, dest:Ljava/lang/String;
    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_71

    .line 188
    move v4, v5

    .line 195
    :goto_61
    invoke-direct {p0, v8, v4}, Landroid/text/AutoText;->add(Ljava/lang/String;C)V
    :try_end_64
    .catchall {:try_start_48 .. :try_end_64} :catchall_6c
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_48 .. :try_end_64} :catch_65
    .catch Ljava/io/IOException; {:try_start_48 .. :try_end_64} :catch_82

    goto :goto_28

    .line 201
    .end local v0           #dest:Ljava/lang/String;
    .end local v2           #element:Ljava/lang/String;
    .end local v3           #odest:Ljava/lang/String;
    .end local v5           #ooff:C
    .end local v8           #src:Ljava/lang/String;
    :catch_65
    move-exception v1

    .line 202
    .local v1, e:Lorg/xmlpull/v1/XmlPullParserException;
    :try_start_66
    new-instance v9, Ljava/lang/RuntimeException;

    invoke-direct {v9, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v9
    :try_end_6c
    .catchall {:try_start_66 .. :try_end_6c} :catchall_6c

    .line 206
    .end local v1           #e:Lorg/xmlpull/v1/XmlPullParserException;
    :catchall_6c
    move-exception v9

    invoke-interface {v6}, Landroid/content/res/XmlResourceParser;->close()V

    throw v9

    .line 190
    .restart local v0       #dest:Ljava/lang/String;
    .restart local v2       #element:Ljava/lang/String;
    .restart local v3       #odest:Ljava/lang/String;
    .restart local v5       #ooff:C
    .restart local v8       #src:Ljava/lang/String;
    :cond_71
    :try_start_71
    invoke-virtual {v7}, Ljava/lang/StringBuilder;->length()I

    move-result v9

    int-to-char v4, v9

    .line 191
    .local v4, off:C
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v9

    int-to-char v9, v9

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 192
    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_81
    .catchall {:try_start_71 .. :try_end_81} :catchall_6c
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_71 .. :try_end_81} :catch_65
    .catch Ljava/io/IOException; {:try_start_71 .. :try_end_81} :catch_82

    goto :goto_61

    .line 203
    .end local v0           #dest:Ljava/lang/String;
    .end local v2           #element:Ljava/lang/String;
    .end local v3           #odest:Ljava/lang/String;
    .end local v4           #off:C
    .end local v5           #ooff:C
    .end local v8           #src:Ljava/lang/String;
    :catch_82
    move-exception v1

    .line 204
    .local v1, e:Ljava/io/IOException;
    :try_start_83
    new-instance v9, Ljava/lang/RuntimeException;

    invoke-direct {v9, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v9
    :try_end_89
    .catchall {:try_start_83 .. :try_end_89} :catchall_6c
.end method

.method private lookup(Ljava/lang/CharSequence;II)Ljava/lang/String;
    .registers 13
    .parameter "src"
    .parameter "start"
    .parameter "end"

    .prologue
    const/4 v5, 0x0

    const v8, 0xffff

    .line 133
    iget-object v6, p0, Landroid/text/AutoText;->mTrie:[C

    const/4 v7, 0x0

    aget-char v1, v6, v7

    .line 135
    .local v1, here:I
    move v2, p2

    .local v2, i:I
    :goto_a
    if-ge v2, p3, :cond_3d

    .line 136
    invoke-interface {p1, v2}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v0

    .line 138
    .local v0, c:C
    :goto_10
    if-eq v1, v8, :cond_44

    .line 139
    iget-object v6, p0, Landroid/text/AutoText;->mTrie:[C

    add-int/lit8 v7, v1, 0x0

    aget-char v6, v6, v7

    if-ne v0, v6, :cond_49

    .line 140
    add-int/lit8 v6, p3, -0x1

    if-ne v2, v6, :cond_3e

    iget-object v6, p0, Landroid/text/AutoText;->mTrie:[C

    add-int/lit8 v7, v1, 0x1

    aget-char v6, v6, v7

    if-eq v6, v8, :cond_3e

    .line 142
    iget-object v5, p0, Landroid/text/AutoText;->mTrie:[C

    add-int/lit8 v6, v1, 0x1

    aget-char v4, v5, v6

    .line 143
    .local v4, off:I
    iget-object v5, p0, Landroid/text/AutoText;->mText:Ljava/lang/String;

    invoke-virtual {v5, v4}, Ljava/lang/String;->charAt(I)C

    move-result v3

    .line 145
    .local v3, len:I
    iget-object v5, p0, Landroid/text/AutoText;->mText:Ljava/lang/String;

    add-int/lit8 v6, v4, 0x1

    add-int/lit8 v7, v4, 0x1

    add-int/2addr v7, v3

    invoke-virtual {v5, v6, v7}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v5

    .line 158
    .end local v0           #c:C
    .end local v3           #len:I
    .end local v4           #off:I
    :cond_3d
    return-object v5

    .line 148
    .restart local v0       #c:C
    :cond_3e
    iget-object v6, p0, Landroid/text/AutoText;->mTrie:[C

    add-int/lit8 v7, v1, 0x2

    aget-char v1, v6, v7

    .line 153
    :cond_44
    if-eq v1, v8, :cond_3d

    .line 135
    add-int/lit8 v2, v2, 0x1

    goto :goto_a

    .line 138
    :cond_49
    iget-object v6, p0, Landroid/text/AutoText;->mTrie:[C

    add-int/lit8 v7, v1, 0x3

    aget-char v1, v6, v7

    goto :goto_10
.end method

.method private newTrieNode()C
    .registers 6

    .prologue
    const/4 v4, 0x0

    .line 268
    iget-char v2, p0, Landroid/text/AutoText;->mTrieUsed:C

    add-int/lit8 v2, v2, 0x4

    iget-object v3, p0, Landroid/text/AutoText;->mTrie:[C

    array-length v3, v3

    if-le v2, v3, :cond_1b

    .line 269
    iget-object v2, p0, Landroid/text/AutoText;->mTrie:[C

    array-length v2, v2

    add-int/lit16 v2, v2, 0x400

    new-array v0, v2, [C

    .line 270
    .local v0, copy:[C
    iget-object v2, p0, Landroid/text/AutoText;->mTrie:[C

    iget-object v3, p0, Landroid/text/AutoText;->mTrie:[C

    array-length v3, v3

    invoke-static {v2, v4, v0, v4, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 271
    iput-object v0, p0, Landroid/text/AutoText;->mTrie:[C

    .line 274
    .end local v0           #copy:[C
    :cond_1b
    iget-char v1, p0, Landroid/text/AutoText;->mTrieUsed:C

    .line 275
    .local v1, ret:C
    iget-char v2, p0, Landroid/text/AutoText;->mTrieUsed:C

    add-int/lit8 v2, v2, 0x4

    int-to-char v2, v2

    iput-char v2, p0, Landroid/text/AutoText;->mTrieUsed:C

    .line 277
    return v1
.end method
