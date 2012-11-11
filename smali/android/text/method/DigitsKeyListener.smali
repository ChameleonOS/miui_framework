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

    new-array v0, v3, [Landroid/text/method/DigitsKeyListener;

    sput-object v0, Landroid/text/method/DigitsKeyListener;->sInstance:[Landroid/text/method/DigitsKeyListener;

    return-void

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

    invoke-direct {p0, v0, v0}, Landroid/text/method/DigitsKeyListener;-><init>(ZZ)V

    return-void
.end method

.method public constructor <init>(ZZ)V
    .registers 6
    .parameter "sign"
    .parameter "decimal"

    .prologue
    const/4 v1, 0x0

    invoke-direct {p0}, Landroid/text/method/NumberKeyListener;-><init>()V

    iput-boolean p1, p0, Landroid/text/method/DigitsKeyListener;->mSign:Z

    iput-boolean p2, p0, Landroid/text/method/DigitsKeyListener;->mDecimal:Z

    if-eqz p1, :cond_17

    const/4 v2, 0x1

    :goto_b
    if-eqz p2, :cond_e

    const/4 v1, 0x2

    :cond_e
    or-int v0, v2, v1

    .local v0, kind:I
    sget-object v1, Landroid/text/method/DigitsKeyListener;->CHARACTERS:[[C

    aget-object v1, v1, v0

    iput-object v1, p0, Landroid/text/method/DigitsKeyListener;->mAccepted:[C

    return-void

    .end local v0           #kind:I
    :cond_17
    move v2, v1

    goto :goto_b
.end method

.method public static getInstance()Landroid/text/method/DigitsKeyListener;
    .registers 1

    .prologue
    const/4 v0, 0x0

    invoke-static {v0, v0}, Landroid/text/method/DigitsKeyListener;->getInstance(ZZ)Landroid/text/method/DigitsKeyListener;

    move-result-object v0

    return-object v0
.end method

.method public static getInstance(Ljava/lang/String;)Landroid/text/method/DigitsKeyListener;
    .registers 5
    .parameter "accepted"

    .prologue
    const/4 v3, 0x0

    new-instance v0, Landroid/text/method/DigitsKeyListener;

    invoke-direct {v0}, Landroid/text/method/DigitsKeyListener;-><init>()V

    .local v0, dim:Landroid/text/method/DigitsKeyListener;
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    new-array v1, v1, [C

    iput-object v1, v0, Landroid/text/method/DigitsKeyListener;->mAccepted:[C

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    iget-object v2, v0, Landroid/text/method/DigitsKeyListener;->mAccepted:[C

    invoke-virtual {p0, v3, v1, v2, v3}, Ljava/lang/String;->getChars(II[CI)V

    return-object v0
.end method

.method public static getInstance(ZZ)Landroid/text/method/DigitsKeyListener;
    .registers 5
    .parameter "sign"
    .parameter "decimal"

    .prologue
    const/4 v1, 0x0

    if-eqz p0, :cond_14

    const/4 v2, 0x1

    :goto_4
    if-eqz p1, :cond_7

    const/4 v1, 0x2

    :cond_7
    or-int v0, v2, v1

    .local v0, kind:I
    sget-object v1, Landroid/text/method/DigitsKeyListener;->sInstance:[Landroid/text/method/DigitsKeyListener;

    aget-object v1, v1, v0

    if-eqz v1, :cond_16

    sget-object v1, Landroid/text/method/DigitsKeyListener;->sInstance:[Landroid/text/method/DigitsKeyListener;

    aget-object v1, v1, v0

    :goto_13
    return-object v1

    .end local v0           #kind:I
    :cond_14
    move v2, v1

    goto :goto_4

    .restart local v0       #kind:I
    :cond_16
    sget-object v1, Landroid/text/method/DigitsKeyListener;->sInstance:[Landroid/text/method/DigitsKeyListener;

    new-instance v2, Landroid/text/method/DigitsKeyListener;

    invoke-direct {v2, p0, p1}, Landroid/text/method/DigitsKeyListener;-><init>(ZZ)V

    aput-object v2, v1, v0

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
    invoke-super/range {p0 .. p6}, Landroid/text/method/NumberKeyListener;->filter(Ljava/lang/CharSequence;IILandroid/text/Spanned;II)Ljava/lang/CharSequence;

    move-result-object v4

    .local v4, out:Ljava/lang/CharSequence;
    iget-boolean v8, p0, Landroid/text/method/DigitsKeyListener;->mSign:Z

    if-nez v8, :cond_d

    iget-boolean v8, p0, Landroid/text/method/DigitsKeyListener;->mDecimal:Z

    if-nez v8, :cond_d

    .end local v4           #out:Ljava/lang/CharSequence;
    :cond_c
    :goto_c
    return-object v4

    .restart local v4       #out:Ljava/lang/CharSequence;
    :cond_d
    if-eqz v4, :cond_15

    move-object p1, v4

    const/4 p2, 0x0

    invoke-interface {v4}, Ljava/lang/CharSequence;->length()I

    move-result p3

    :cond_15
    const/4 v5, -0x1

    .local v5, sign:I
    const/4 v1, -0x1

    .local v1, decimal:I
    invoke-interface {p4}, Landroid/text/Spanned;->length()I

    move-result v2

    .local v2, dlen:I
    const/4 v3, 0x0

    .local v3, i:I
    :goto_1c
    if-ge v3, p5, :cond_30

    invoke-interface {p4, v3}, Landroid/text/Spanned;->charAt(I)C

    move-result v0

    .local v0, c:C
    const/16 v8, 0x2d

    if-ne v0, v8, :cond_2a

    move v5, v3

    :cond_27
    :goto_27
    add-int/lit8 v3, v3, 0x1

    goto :goto_1c

    :cond_2a
    const/16 v8, 0x2e

    if-ne v0, v8, :cond_27

    move v1, v3

    goto :goto_27

    .end local v0           #c:C
    :cond_30
    move/from16 v3, p6

    :goto_32
    if-ge v3, v2, :cond_47

    invoke-interface {p4, v3}, Landroid/text/Spanned;->charAt(I)C

    move-result v0

    .restart local v0       #c:C
    const/16 v8, 0x2d

    if-ne v0, v8, :cond_3f

    const-string v4, ""

    goto :goto_c

    :cond_3f
    const/16 v8, 0x2e

    if-ne v0, v8, :cond_44

    move v1, v3

    :cond_44
    add-int/lit8 v3, v3, 0x1

    goto :goto_32

    .end local v0           #c:C
    :cond_47
    const/4 v7, 0x0

    .local v7, stripped:Landroid/text/SpannableStringBuilder;
    add-int/lit8 v3, p3, -0x1

    :goto_4a
    if-lt v3, p2, :cond_85

    invoke-interface {p1, v3}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v0

    .restart local v0       #c:C
    const/4 v6, 0x0

    .local v6, strip:Z
    const/16 v8, 0x2d

    if-ne v0, v8, :cond_69

    if-ne v3, p2, :cond_59

    if-eqz p5, :cond_63

    :cond_59
    const/4 v6, 0x1

    :cond_5a
    :goto_5a
    if-eqz v6, :cond_82

    add-int/lit8 v8, p2, 0x1

    if-ne p3, v8, :cond_73

    const-string v4, ""

    goto :goto_c

    :cond_63
    if-ltz v5, :cond_67

    const/4 v6, 0x1

    goto :goto_5a

    :cond_67
    move v5, v3

    goto :goto_5a

    :cond_69
    const/16 v8, 0x2e

    if-ne v0, v8, :cond_5a

    if-ltz v1, :cond_71

    const/4 v6, 0x1

    goto :goto_5a

    :cond_71
    move v1, v3

    goto :goto_5a

    :cond_73
    if-nez v7, :cond_7a

    new-instance v7, Landroid/text/SpannableStringBuilder;

    .end local v7           #stripped:Landroid/text/SpannableStringBuilder;
    invoke-direct {v7, p1, p2, p3}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;II)V

    .restart local v7       #stripped:Landroid/text/SpannableStringBuilder;
    :cond_7a
    sub-int v8, v3, p2

    add-int/lit8 v9, v3, 0x1

    sub-int/2addr v9, p2

    invoke-virtual {v7, v8, v9}, Landroid/text/SpannableStringBuilder;->delete(II)Landroid/text/SpannableStringBuilder;

    :cond_82
    add-int/lit8 v3, v3, -0x1

    goto :goto_4a

    .end local v0           #c:C
    .end local v6           #strip:Z
    :cond_85
    if-eqz v7, :cond_89

    move-object v4, v7

    goto :goto_c

    :cond_89
    if-nez v4, :cond_c

    const/4 v4, 0x0

    goto :goto_c
.end method

.method protected getAcceptedChars()[C
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/text/method/DigitsKeyListener;->mAccepted:[C

    return-object v0
.end method

.method public getInputType()I
    .registers 3

    .prologue
    const/4 v0, 0x2

    .local v0, contentType:I
    iget-boolean v1, p0, Landroid/text/method/DigitsKeyListener;->mSign:Z

    if-eqz v1, :cond_7

    or-int/lit16 v0, v0, 0x1000

    :cond_7
    iget-boolean v1, p0, Landroid/text/method/DigitsKeyListener;->mDecimal:Z

    if-eqz v1, :cond_d

    or-int/lit16 v0, v0, 0x2000

    :cond_d
    return v0
.end method
