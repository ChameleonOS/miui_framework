.class public Landroid/os/PatternMatcher;
.super Ljava/lang/Object;
.source "PatternMatcher.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/os/PatternMatcher;",
            ">;"
        }
    .end annotation
.end field

.field public static final PATTERN_LITERAL:I = 0x0

.field public static final PATTERN_PREFIX:I = 0x1

.field public static final PATTERN_SIMPLE_GLOB:I = 0x2


# instance fields
.field private final mPattern:Ljava/lang/String;

.field private final mType:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    new-instance v0, Landroid/os/PatternMatcher$1;

    invoke-direct {v0}, Landroid/os/PatternMatcher$1;-><init>()V

    sput-object v0, Landroid/os/PatternMatcher;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .registers 3
    .parameter "src"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/os/PatternMatcher;->mPattern:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/os/PatternMatcher;->mType:I

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .registers 3
    .parameter "pattern"
    .parameter "type"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroid/os/PatternMatcher;->mPattern:Ljava/lang/String;

    iput p2, p0, Landroid/os/PatternMatcher;->mType:I

    return-void
.end method

.method static matchPattern(Ljava/lang/String;Ljava/lang/String;I)Z
    .registers 16
    .parameter "pattern"
    .parameter "match"
    .parameter "type"

    .prologue
    const/16 v12, 0x5c

    const/16 v11, 0x2a

    const/16 v10, 0x2e

    const/4 v7, 0x1

    const/4 v8, 0x0

    if-nez p1, :cond_b

    :cond_a
    :goto_a
    return v8

    :cond_b
    if-nez p2, :cond_12

    invoke-virtual {p0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    goto :goto_a

    :cond_12
    if-ne p2, v7, :cond_19

    invoke-virtual {p1, p0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v8

    goto :goto_a

    :cond_19
    const/4 v9, 0x2

    if-ne p2, v9, :cond_a

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    .local v1, NP:I
    if-gtz v1, :cond_2c

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v9

    if-gtz v9, :cond_2a

    :goto_28
    move v8, v7

    goto :goto_a

    :cond_2a
    move v7, v8

    goto :goto_28

    :cond_2c
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    .local v0, NM:I
    const/4 v5, 0x0

    .local v5, ip:I
    const/4 v4, 0x0

    .local v4, im:I
    invoke-virtual {p0, v8}, Ljava/lang/String;->charAt(I)C

    move-result v6

    .local v6, nextChar:C
    :goto_36
    if-ge v5, v1, :cond_b0

    if-ge v4, v0, :cond_b0

    move v2, v6

    .local v2, c:C
    add-int/lit8 v5, v5, 0x1

    if-ge v5, v1, :cond_5d

    invoke-virtual {p0, v5}, Ljava/lang/String;->charAt(I)C

    move-result v6

    :goto_43
    if-ne v2, v12, :cond_5f

    move v3, v7

    .local v3, escaped:Z
    :goto_46
    if-eqz v3, :cond_51

    move v2, v6

    add-int/lit8 v5, v5, 0x1

    if-ge v5, v1, :cond_61

    invoke-virtual {p0, v5}, Ljava/lang/String;->charAt(I)C

    move-result v6

    :cond_51
    :goto_51
    if-ne v6, v11, :cond_a5

    if-nez v3, :cond_8f

    if-ne v2, v10, :cond_8f

    add-int/lit8 v9, v1, -0x1

    if-lt v5, v9, :cond_63

    move v8, v7

    goto :goto_a

    .end local v3           #escaped:Z
    :cond_5d
    move v6, v8

    goto :goto_43

    :cond_5f
    move v3, v8

    goto :goto_46

    .restart local v3       #escaped:Z
    :cond_61
    move v6, v8

    goto :goto_51

    :cond_63
    add-int/lit8 v5, v5, 0x1

    invoke-virtual {p0, v5}, Ljava/lang/String;->charAt(I)C

    move-result v6

    if-ne v6, v12, :cond_73

    add-int/lit8 v5, v5, 0x1

    if-ge v5, v1, :cond_86

    invoke-virtual {p0, v5}, Ljava/lang/String;->charAt(I)C

    move-result v6

    :cond_73
    :goto_73
    invoke-virtual {p1, v4}, Ljava/lang/String;->charAt(I)C

    move-result v9

    if-ne v9, v6, :cond_88

    :goto_79
    if-eq v4, v0, :cond_a

    add-int/lit8 v5, v5, 0x1

    if-ge v5, v1, :cond_8d

    invoke-virtual {p0, v5}, Ljava/lang/String;->charAt(I)C

    move-result v6

    :goto_83
    add-int/lit8 v4, v4, 0x1

    goto :goto_36

    :cond_86
    move v6, v8

    goto :goto_73

    :cond_88
    add-int/lit8 v4, v4, 0x1

    if-lt v4, v0, :cond_73

    goto :goto_79

    :cond_8d
    move v6, v8

    goto :goto_83

    :cond_8f
    invoke-virtual {p1, v4}, Ljava/lang/String;->charAt(I)C

    move-result v9

    if-eq v9, v2, :cond_9e

    :goto_95
    add-int/lit8 v5, v5, 0x1

    if-ge v5, v1, :cond_a3

    invoke-virtual {p0, v5}, Ljava/lang/String;->charAt(I)C

    move-result v6

    :goto_9d
    goto :goto_36

    :cond_9e
    add-int/lit8 v4, v4, 0x1

    if-lt v4, v0, :cond_8f

    goto :goto_95

    :cond_a3
    move v6, v8

    goto :goto_9d

    :cond_a5
    if-eq v2, v10, :cond_ad

    invoke-virtual {p1, v4}, Ljava/lang/String;->charAt(I)C

    move-result v9

    if-ne v9, v2, :cond_a

    :cond_ad
    add-int/lit8 v4, v4, 0x1

    goto :goto_36

    .end local v2           #c:C
    .end local v3           #escaped:Z
    :cond_b0
    if-lt v5, v1, :cond_b7

    if-lt v4, v0, :cond_b7

    move v8, v7

    goto/16 :goto_a

    :cond_b7
    add-int/lit8 v9, v1, -0x2

    if-ne v5, v9, :cond_a

    invoke-virtual {p0, v5}, Ljava/lang/String;->charAt(I)C

    move-result v9

    if-ne v9, v10, :cond_a

    add-int/lit8 v9, v5, 0x1

    invoke-virtual {p0, v9}, Ljava/lang/String;->charAt(I)C

    move-result v9

    if-ne v9, v11, :cond_a

    move v8, v7

    goto/16 :goto_a
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public final getPath()Ljava/lang/String;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/os/PatternMatcher;->mPattern:Ljava/lang/String;

    return-object v0
.end method

.method public final getType()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/os/PatternMatcher;->mType:I

    return v0
.end method

.method public match(Ljava/lang/String;)Z
    .registers 4
    .parameter "str"

    .prologue
    iget-object v0, p0, Landroid/os/PatternMatcher;->mPattern:Ljava/lang/String;

    iget v1, p0, Landroid/os/PatternMatcher;->mType:I

    invoke-static {v0, p1, v1}, Landroid/os/PatternMatcher;->matchPattern(Ljava/lang/String;Ljava/lang/String;I)Z

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    .prologue
    const-string v0, "? "

    .local v0, type:Ljava/lang/String;
    iget v1, p0, Landroid/os/PatternMatcher;->mType:I

    packed-switch v1, :pswitch_data_32

    :goto_7
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "PatternMatcher{"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/os/PatternMatcher;->mPattern:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "}"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    :pswitch_28
    const-string v0, "LITERAL: "

    goto :goto_7

    :pswitch_2b
    const-string v0, "PREFIX: "

    goto :goto_7

    :pswitch_2e
    const-string v0, "GLOB: "

    goto :goto_7

    nop

    :pswitch_data_32
    .packed-switch 0x0
        :pswitch_28
        :pswitch_2b
        :pswitch_2e
    .end packed-switch
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 4
    .parameter "dest"
    .parameter "flags"

    .prologue
    iget-object v0, p0, Landroid/os/PatternMatcher;->mPattern:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget v0, p0, Landroid/os/PatternMatcher;->mType:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    return-void
.end method
