.class public Landroid/text/SpannableString;
.super Landroid/text/SpannableStringInternal;
.source "SpannableString.java"

# interfaces
.implements Ljava/lang/CharSequence;
.implements Landroid/text/GetChars;
.implements Landroid/text/Spannable;


# direct methods
.method public constructor <init>(Ljava/lang/CharSequence;)V
    .registers 4
    .parameter "source"

    .prologue
    .line 30
    const/4 v0, 0x0

    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v1

    invoke-direct {p0, p1, v0, v1}, Landroid/text/SpannableStringInternal;-><init>(Ljava/lang/CharSequence;II)V

    .line 31
    return-void
.end method

.method private constructor <init>(Ljava/lang/CharSequence;II)V
    .registers 4
    .parameter "source"
    .parameter "start"
    .parameter "end"

    .prologue
    .line 34
    invoke-direct {p0, p1, p2, p3}, Landroid/text/SpannableStringInternal;-><init>(Ljava/lang/CharSequence;II)V

    .line 35
    return-void
.end method

.method public static valueOf(Ljava/lang/CharSequence;)Landroid/text/SpannableString;
    .registers 2
    .parameter "source"

    .prologue
    .line 38
    instance-of v0, p0, Landroid/text/SpannableString;

    if-eqz v0, :cond_7

    .line 39
    check-cast p0, Landroid/text/SpannableString;

    .line 41
    .end local p0
    :goto_6
    return-object p0

    .restart local p0
    :cond_7
    new-instance v0, Landroid/text/SpannableString;

    invoke-direct {v0, p0}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    move-object p0, v0

    goto :goto_6
.end method


# virtual methods
.method public bridge synthetic getSpanEnd(Ljava/lang/Object;)I
    .registers 3
    .parameter "x0"

    .prologue
    .line 25
    invoke-super {p0, p1}, Landroid/text/SpannableStringInternal;->getSpanEnd(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public bridge synthetic getSpanFlags(Ljava/lang/Object;)I
    .registers 3
    .parameter "x0"

    .prologue
    .line 25
    invoke-super {p0, p1}, Landroid/text/SpannableStringInternal;->getSpanFlags(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public bridge synthetic getSpanStart(Ljava/lang/Object;)I
    .registers 3
    .parameter "x0"

    .prologue
    .line 25
    invoke-super {p0, p1}, Landroid/text/SpannableStringInternal;->getSpanStart(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public bridge synthetic getSpans(IILjava/lang/Class;)[Ljava/lang/Object;
    .registers 5
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"

    .prologue
    .line 25
    invoke-super {p0, p1, p2, p3}, Landroid/text/SpannableStringInternal;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic nextSpanTransition(IILjava/lang/Class;)I
    .registers 5
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"

    .prologue
    .line 25
    invoke-super {p0, p1, p2, p3}, Landroid/text/SpannableStringInternal;->nextSpanTransition(IILjava/lang/Class;)I

    move-result v0

    return v0
.end method

.method public removeSpan(Ljava/lang/Object;)V
    .registers 2
    .parameter "what"

    .prologue
    .line 50
    invoke-super {p0, p1}, Landroid/text/SpannableStringInternal;->removeSpan(Ljava/lang/Object;)V

    .line 51
    return-void
.end method

.method public setSpan(Ljava/lang/Object;III)V
    .registers 5
    .parameter "what"
    .parameter "start"
    .parameter "end"
    .parameter "flags"

    .prologue
    .line 46
    invoke-super {p0, p1, p2, p3, p4}, Landroid/text/SpannableStringInternal;->setSpan(Ljava/lang/Object;III)V

    .line 47
    return-void
.end method

.method public final subSequence(II)Ljava/lang/CharSequence;
    .registers 4
    .parameter "start"
    .parameter "end"

    .prologue
    .line 54
    new-instance v0, Landroid/text/SpannableString;

    invoke-direct {v0, p0, p1, p2}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;II)V

    return-object v0
.end method
