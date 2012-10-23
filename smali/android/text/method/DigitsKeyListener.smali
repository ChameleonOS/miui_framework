.class public Landroid/text/method/DigitsKeyListener;
.super Landroid/text/method/NumberKeyListener;
.source "DigitsKeyListener.java"


# static fields
.field private static final CHARACTERS:[[C = null

.field private static final DECIMAL:I = 0x2

.field private static final SIGN:I = 0x1

.field private static sInstance:[Landroid/text/method/DigitsKeyListener;


# instance fields
.field private mAccepted:[C

.field private mDecimal:Z

.field private mSign:Z


# direct methods
.method static constructor <clinit>()V
    .registers 5

    .prologue
    const/16 v4, 0xb

    const/4 v3, 0x4

    .line 52
    new-array v0, v3, [[C

    const/4 v1, 0x0

    const/16 v2, 0xa

    new-array v2, v2, [C

    fill-array-data v2, :array_30

    aput-object v2, v0, v1

    const/4 v1, 0x1

    new-array v2, v4, [C

    fill-array-data v2, :array_3e

    aput-object v2, v0, v1

    const/4 v1, 0x2

    new-array v2, v4, [C

    fill-array-data v2, :array_4e

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const/16 v2, 0xc

    new-array v2, v2, [C

    fill-array-data v2, :array_5e

    aput-object v2, v0, v1

    sput-object v0, Landroid/text/method/DigitsKeyListener;->CHARACTERS:[[C

    .line 221
    new-array v0, v3, [Landroid/text/method/DigitsKeyListener;

    sput-object v0, Landroid/text/method/DigitsKeyListener;->sInstance:[Landroid/text/method/DigitsKeyListener;

    return-void

    .line 52
    :array_30
    .array-data 0x2
        0x30t 0x0t
        0x31t 0x0t
        0x32t 0x0t
        0x33t 0x0t
        0x34t 0x0t
        0x35t 0x0t
        0x36t 0x0t
        0x37t 0x0t
        0x38t 0x0t
        0x39t 0x0t
    .end array-data

    :array_3e
    .array-data 0x2
        0x30t 0x0t
        0x31t 0x0t
        0x32t 0x0t
        0x33t 0x0t
        0x34t 0x0t
        0x35t 0x0t
        0x36t 0x0t
        0x37t 0x0t
        0x38t 0x0t
        0x39t 0x0t
        0x2dt 0x0t
    .end array-data

    nop

    :array_4e
    .array-data 0x2
        0x30t 0x0t
        0x31t 0x0t
        0x32t 0x0t
        0x33t 0x0t
        0x34t 0x0t
        0x35t 0x0t
        0x36t 0x0t
        0x37t 0x0t
        0x38t 0x0t
        0x39t 0x0t
        0x2et 0x0t
    .end array-data

    nop

    :array_5e
    .array-data 0x2
        0x30t 0x0t
        0x31t 0x0t
        0x32t 0x0t
        0x33t 0x0t
        0x34t 0x0t
        0x35t 0x0t
        0x36t 0x0t
        0x37t 0x0t
        0x38t 0x0t
        0x39t 0x0t
        0x2dt 0x0t
        0x2et 0x0t
    .end array-data
.end method

.method public constructor <init>()V
    .registers 2

    .prologue
    const/4 v0, 0x0

    .line 63
    invoke-direct {p0, v0, v0}, Landroid/text/method/DigitsKeyListener;-><init>(ZZ)V

    .line 64
    return-void
.end method

.method public constructor <init>(ZZ)V
    .registers 6
    .parameter "sign"
    .parameter "decimal"

    .prologue
    const/4 v1, 0x0

    .line 71
    invoke-direct {p0}, Landroid/text/method/NumberKeyListener;-><init>()V

    .line 72
    iput-boolean p1, p0, Landroid/text/method/DigitsKeyListener;->mSign:Z

    .line 73
    iput-boolean p2, p0, Landroid/text/method/DigitsKeyListener;->mDecimal:Z

    .line 75
    if-eqz p1, :cond_17

    const/4 v2, 0x1

    :goto_b
    if-eqz p2, :cond_e

    const/4 v1, 0x2

    :cond_e
    or-int v0, v2, v1

    .line 76
    .local v0, kind:I
    sget-object v1, Landroid/text/method/DigitsKeyListener;->CHARACTERS:[[C

    aget-object v1, v1, v0

    iput-object v1, p0, Landroid/text/method/DigitsKeyListener;->mAccepted:[C

    .line 77
    return-void

    .end local v0           #kind:I
    :cond_17
    move v2, v1

    .line 75
    goto :goto_b
.end method

.method public static getInstance()Landroid/text/method/DigitsKeyListener;
    .registers 1

    .prologue
    const/4 v0, 0x0

    .line 83
    invoke-static {v0, v0}, Landroid/text/method/DigitsKeyListener;->getInstance(ZZ)Landroid/text/method/DigitsKeyListener;

    move-result-object v0

    return-object v0
.end method

.method public static getInstance(Ljava/lang/String;)Landroid/text/method/DigitsKeyListener;
    .registers 5
    .parameter "accepted"

    .prologue
    const/4 v3, 0x0

    .line 109
    new-instance v0, Landroid/text/method/DigitsKeyListener;

    invoke-direct {v0}, Landroid/text/method/DigitsKeyListener;-><init>()V

    .line 111
    .local v0, dim:Landroid/text/method/DigitsKeyListener;
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    new-array v1, v1, [C

    iput-object v1, v0, Landroid/text/method/DigitsKeyListener;->mAccepted:[C

    .line 112
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    iget-object v2, v0, Landroid/text/method/DigitsKeyListener;->mAccepted:[C

    invoke-virtual {p0, v3, v1, v2, v3}, Ljava/lang/String;->getChars(II[CI)V

    .line 114
    return-object v0
.end method

.method public static getInstance(ZZ)Landroid/text/method/DigitsKeyListener;
    .registers 5
    .parameter "sign"
    .parameter "decimal"

    .prologue
    const/4 v1, 0x0

    .line 92
    if-eqz p0, :cond_14

    const/4 v2, 0x1

    :goto_4
    if-eqz p1, :cond_7

    const/4 v1, 0x2

    :cond_7
    or-int v0, v2, v1

    .line 94
    .local v0, kind:I
    sget-object v1, Landroid/text/method/DigitsKeyListener;->sInstance:[Landroid/text/method/DigitsKeyListener;

    aget-object v1, v1, v0

    if-eqz v1, :cond_16

    .line 95
    sget-object v1, Landroid/text/method/DigitsKeyListener;->sInstance:[Landroid/text/method/DigitsKeyListener;

    aget-object v1, v1, v0

    .line 98
    :goto_13
    return-object v1

    .end local v0           #kind:I
    :cond_14
    move v2, v1

    .line 92
    goto :goto_4

    .line 97
    .restart local v0       #kind:I
    :cond_16
    sget-object v1, Landroid/text/method/DigitsKeyListener;->sInstance:[Landroid/text/method/DigitsKeyListener;

    new-instance v2, Landroid/text/method/DigitsKeyListener;

    invoke-direct {v2, p0, p1}, Landroid/text/method/DigitsKeyListener;-><init>(ZZ)V

    aput-object v2, v1, v0

    .line 98
    sget-object v1, Landroid/text/method/DigitsKeyListener;->sInstance:[Landroid/text/method/DigitsKeyListener;

    aget-object v1, v1, v0

    goto :goto_13
.end method


# virtual methods
.method public filter(Ljava/lang/CharSequence;IILandroid/text/Spanned;II)Ljava/lang/CharSequence;
    .registers 17
    .parameter "source"
    .parameter "start"
    .parameter "end"
    .parameter "dest"
    .parameter "dstart"
    .parameter "dend"

    .prologue
    .line 131
    invoke-super/range {p0 .. p6}, Landroid/text/method/NumberKeyListener;->filter(Ljava/lang/CharSequence;IILandroid/text/Spanned;II)Ljava/lang/CharSequence;

    move-result-object v4

    .line 133
    .local v4, out:Ljava/lang/CharSequence;
    iget-boolean v8, p0, Landroid/text/method/DigitsKeyListener;->mSign:Z

    if-nez v8, :cond_d

    iget-boolean v8, p0, Landroid/text/method/DigitsKeyListener;->mDecimal:Z

    if-nez v8, :cond_d

    .line 217
    .end local v4           #out:Ljava/lang/CharSequence;
    :cond_c
    :goto_c
    return-object v4

    .line 137
    .restart local v4       #out:Ljava/lang/CharSequence;
    :cond_d
    if-eqz v4, :cond_15

    .line 138
    move-object p1, v4

    .line 139
    const/4 p2, 0x0

    .line 140
    invoke-interface {v4}, Ljava/lang/CharSequence;->length()I

    move-result p3

    .line 143
    :cond_15
    const/4 v5, -0x1

    .line 144
    .local v5, sign:I
    const/4 v1, -0x1

    .line 145
    .local v1, decimal:I
    invoke-interface {p4}, Landroid/text/Spanned;->length()I

    move-result v2

    .line 151
    .local v2, dlen:I
    const/4 v3, 0x0

    .local v3, i:I
    :goto_1c
    if-ge v3, p5, :cond_30

    .line 152
    invoke-interface {p4, v3}, Landroid/text/Spanned;->charAt(I)C

    move-result v0

    .line 154
    .local v0, c:C
    const/16 v8, 0x2d

    if-ne v0, v8, :cond_2a

    .line 155
    move v5, v3

    .line 151
    :cond_27
    :goto_27
    add-int/lit8 v3, v3, 0x1

    goto :goto_1c

    .line 156
    :cond_2a
    const/16 v8, 0x2e

    if-ne v0, v8, :cond_27

    .line 157
    move v1, v3

    goto :goto_27

    .line 160
    .end local v0           #c:C
    :cond_30
    move/from16 v3, p6

    :goto_32
    if-ge v3, v2, :cond_47

    .line 161
    invoke-interface {p4, v3}, Landroid/text/Spanned;->charAt(I)C

    move-result v0

    .line 163
    .restart local v0       #c:C
    const/16 v8, 0x2d

    if-ne v0, v8, :cond_3f

    .line 164
    const-string v4, ""

    goto :goto_c

    .line 165
    :cond_3f
    const/16 v8, 0x2e

    if-ne v0, v8, :cond_44

    .line 166
    move v1, v3

    .line 160
    :cond_44
    add-int/lit8 v3, v3, 0x1

    goto :goto_32

    .line 177
    .end local v0           #c:C
    :cond_47
    const/4 v7, 0x0

    .line 179
    .local v7, stripped:Landroid/text/SpannableStringBuilder;
    add-int/lit8 v3, p3, -0x1

    :goto_4a
    if-lt v3, p2, :cond_85

    .line 180
    invoke-interface {p1, v3}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v0

    .line 181
    .restart local v0       #c:C
    const/4 v6, 0x0

    .line 183
    .local v6, strip:Z
    const/16 v8, 0x2d

    if-ne v0, v8, :cond_69

    .line 184
    if-ne v3, p2, :cond_59

    if-eqz p5, :cond_63

    .line 185
    :cond_59
    const/4 v6, 0x1

    .line 199
    :cond_5a
    :goto_5a
    if-eqz v6, :cond_82

    .line 200
    add-int/lit8 v8, p2, 0x1

    if-ne p3, v8, :cond_73

    .line 201
    const-string v4, ""

    goto :goto_c

    .line 186
    :cond_63
    if-ltz v5, :cond_67

    .line 187
    const/4 v6, 0x1

    goto :goto_5a

    .line 189
    :cond_67
    move v5, v3

    goto :goto_5a

    .line 191
    :cond_69
    const/16 v8, 0x2e

    if-ne v0, v8, :cond_5a

    .line 192
    if-ltz v1, :cond_71

    .line 193
    const/4 v6, 0x1

    goto :goto_5a

    .line 195
    :cond_71
    move v1, v3

    goto :goto_5a

    .line 204
    :cond_73
    if-nez v7, :cond_7a

    .line 205
    new-instance v7, Landroid/text/SpannableStringBuilder;

    .end local v7           #stripped:Landroid/text/SpannableStringBuilder;
    invoke-direct {v7, p1, p2, p3}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;II)V

    .line 208
    .restart local v7       #stripped:Landroid/text/SpannableStringBuilder;
    :cond_7a
    sub-int v8, v3, p2

    add-int/lit8 v9, v3, 0x1

    sub-int/2addr v9, p2

    invoke-virtual {v7, v8, v9}, Landroid/text/SpannableStringBuilder;->delete(II)Landroid/text/SpannableStringBuilder;

    .line 179
    :cond_82
    add-int/lit8 v3, v3, -0x1

    goto :goto_4a

    .line 212
    .end local v0           #c:C
    .end local v6           #strip:Z
    :cond_85
    if-eqz v7, :cond_89

    move-object v4, v7

    .line 213
    goto :goto_c

    .line 214
    :cond_89
    if-nez v4, :cond_c

    .line 217
    const/4 v4, 0x0

    goto :goto_c
.end method

.method protected getAcceptedChars()[C
    .registers 2

    .prologue
    .line 43
    iget-object v0, p0, Landroid/text/method/DigitsKeyListener;->mAccepted:[C

    return-object v0
.end method

.method public getInputType()I
    .registers 3

    .prologue
    .line 118
    const/4 v0, 0x2

    .line 119
    .local v0, contentType:I
    iget-boolean v1, p0, Landroid/text/method/DigitsKeyListener;->mSign:Z

    if-eqz v1, :cond_7

    .line 120
    or-int/lit16 v0, v0, 0x1000

    .line 122
    :cond_7
    iget-boolean v1, p0, Landroid/text/method/DigitsKeyListener;->mDecimal:Z

    if-eqz v1, :cond_d

    .line 123
    or-int/lit16 v0, v0, 0x2000

    .line 125
    :cond_d
    return v0
.end method
