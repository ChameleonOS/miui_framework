.class Landroid/text/method/ReplacementTransformationMethod$SpannedReplacementCharSequence;
.super Landroid/text/method/ReplacementTransformationMethod$ReplacementCharSequence;
.source "ReplacementTransformationMethod.java"

# interfaces
.implements Landroid/text/Spanned;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/text/method/ReplacementTransformationMethod;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SpannedReplacementCharSequence"
.end annotation


# instance fields
.field private mSpanned:Landroid/text/Spanned;


# direct methods
.method public constructor <init>(Landroid/text/Spanned;[C[C)V
    .registers 4
    .parameter "source"
    .parameter "original"
    .parameter "replacement"

    .prologue
    .line 175
    invoke-direct {p0, p1, p2, p3}, Landroid/text/method/ReplacementTransformationMethod$ReplacementCharSequence;-><init>(Ljava/lang/CharSequence;[C[C)V

    .line 176
    iput-object p1, p0, Landroid/text/method/ReplacementTransformationMethod$SpannedReplacementCharSequence;->mSpanned:Landroid/text/Spanned;

    .line 177
    return-void
.end method


# virtual methods
.method public getSpanEnd(Ljava/lang/Object;)I
    .registers 3
    .parameter "tag"

    .prologue
    .line 192
    iget-object v0, p0, Landroid/text/method/ReplacementTransformationMethod$SpannedReplacementCharSequence;->mSpanned:Landroid/text/Spanned;

    invoke-interface {v0, p1}, Landroid/text/Spanned;->getSpanEnd(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public getSpanFlags(Ljava/lang/Object;)I
    .registers 3
    .parameter "tag"

    .prologue
    .line 196
    iget-object v0, p0, Landroid/text/method/ReplacementTransformationMethod$SpannedReplacementCharSequence;->mSpanned:Landroid/text/Spanned;

    invoke-interface {v0, p1}, Landroid/text/Spanned;->getSpanFlags(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public getSpanStart(Ljava/lang/Object;)I
    .registers 3
    .parameter "tag"

    .prologue
    .line 188
    iget-object v0, p0, Landroid/text/method/ReplacementTransformationMethod$SpannedReplacementCharSequence;->mSpanned:Landroid/text/Spanned;

    invoke-interface {v0, p1}, Landroid/text/Spanned;->getSpanStart(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public getSpans(IILjava/lang/Class;)[Ljava/lang/Object;
    .registers 5
    .parameter "start"
    .parameter "end"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(II",
            "Ljava/lang/Class",
            "<TT;>;)[TT;"
        }
    .end annotation

    .prologue
    .line 184
    .local p3, type:Ljava/lang/Class;,"Ljava/lang/Class<TT;>;"
    iget-object v0, p0, Landroid/text/method/ReplacementTransformationMethod$SpannedReplacementCharSequence;->mSpanned:Landroid/text/Spanned;

    invoke-interface {v0, p1, p2, p3}, Landroid/text/Spanned;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public nextSpanTransition(IILjava/lang/Class;)I
    .registers 5
    .parameter "start"
    .parameter "end"
    .parameter "type"

    .prologue
    .line 200
    iget-object v0, p0, Landroid/text/method/ReplacementTransformationMethod$SpannedReplacementCharSequence;->mSpanned:Landroid/text/Spanned;

    invoke-interface {v0, p1, p2, p3}, Landroid/text/Spanned;->nextSpanTransition(IILjava/lang/Class;)I

    move-result v0

    return v0
.end method

.method public subSequence(II)Ljava/lang/CharSequence;
    .registers 4
    .parameter "start"
    .parameter "end"

    .prologue
    .line 180
    new-instance v0, Landroid/text/SpannedString;

    invoke-direct {v0, p0}, Landroid/text/SpannedString;-><init>(Ljava/lang/CharSequence;)V

    invoke-virtual {v0, p1, p2}, Landroid/text/SpannedString;->subSequence(II)Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method
