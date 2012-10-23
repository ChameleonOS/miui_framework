.class public Lcom/google/android/util/AbstractMessageParser$Html;
.super Lcom/google/android/util/AbstractMessageParser$Token;
.source "AbstractMessageParser.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/util/AbstractMessageParser;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Html"
.end annotation


# instance fields
.field private html:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .registers 4
    .parameter "text"
    .parameter "html"

    .prologue
    .line 725
    sget-object v0, Lcom/google/android/util/AbstractMessageParser$Token$Type;->HTML:Lcom/google/android/util/AbstractMessageParser$Token$Type;

    invoke-direct {p0, v0, p1}, Lcom/google/android/util/AbstractMessageParser$Token;-><init>(Lcom/google/android/util/AbstractMessageParser$Token$Type;Ljava/lang/String;)V

    .line 726
    iput-object p2, p0, Lcom/google/android/util/AbstractMessageParser$Html;->html:Ljava/lang/String;

    .line 727
    return-void
.end method

.method private static trimLeadingWhitespace(Ljava/lang/String;)Ljava/lang/String;
    .registers 3
    .parameter "text"

    .prologue
    .line 751
    const/4 v0, 0x0

    .line 752
    .local v0, index:I
    :goto_1
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    if-ge v0, v1, :cond_14

    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result v1

    invoke-static {v1}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result v1

    if-eqz v1, :cond_14

    .line 754
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 756
    :cond_14
    invoke-virtual {p0, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public static trimTrailingWhitespace(Ljava/lang/String;)Ljava/lang/String;
    .registers 3
    .parameter "text"

    .prologue
    .line 760
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    .line 761
    .local v0, index:I
    :goto_4
    if-lez v0, :cond_15

    add-int/lit8 v1, v0, -0x1

    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v1

    invoke-static {v1}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result v1

    if-eqz v1, :cond_15

    .line 762
    add-int/lit8 v0, v0, -0x1

    goto :goto_4

    .line 764
    :cond_15
    const/4 v1, 0x0

    invoke-virtual {p0, v1, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method


# virtual methods
.method public getInfo()Ljava/util/List;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 737
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public isHtml()Z
    .registers 2

    .prologue
    .line 729
    const/4 v0, 0x1

    return v0
.end method

.method public toHtml(Z)Ljava/lang/String;
    .registers 3
    .parameter "caps"

    .prologue
    .line 731
    if-eqz p1, :cond_9

    iget-object v0, p0, Lcom/google/android/util/AbstractMessageParser$Html;->html:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v0

    :goto_8
    return-object v0

    :cond_9
    iget-object v0, p0, Lcom/google/android/util/AbstractMessageParser$Html;->html:Ljava/lang/String;

    goto :goto_8
.end method

.method public trimLeadingWhitespace()V
    .registers 2

    .prologue
    .line 741
    iget-object v0, p0, Lcom/google/android/util/AbstractMessageParser$Token;->text:Ljava/lang/String;

    invoke-static {v0}, Lcom/google/android/util/AbstractMessageParser$Html;->trimLeadingWhitespace(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/util/AbstractMessageParser$Token;->text:Ljava/lang/String;

    .line 742
    iget-object v0, p0, Lcom/google/android/util/AbstractMessageParser$Html;->html:Ljava/lang/String;

    invoke-static {v0}, Lcom/google/android/util/AbstractMessageParser$Html;->trimLeadingWhitespace(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/util/AbstractMessageParser$Html;->html:Ljava/lang/String;

    .line 743
    return-void
.end method

.method public trimTrailingWhitespace()V
    .registers 2

    .prologue
    .line 746
    iget-object v0, p0, Lcom/google/android/util/AbstractMessageParser$Token;->text:Ljava/lang/String;

    invoke-static {v0}, Lcom/google/android/util/AbstractMessageParser$Html;->trimTrailingWhitespace(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/util/AbstractMessageParser$Token;->text:Ljava/lang/String;

    .line 747
    iget-object v0, p0, Lcom/google/android/util/AbstractMessageParser$Html;->html:Ljava/lang/String;

    invoke-static {v0}, Lcom/google/android/util/AbstractMessageParser$Html;->trimTrailingWhitespace(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/util/AbstractMessageParser$Html;->html:Ljava/lang/String;

    .line 748
    return-void
.end method
