.class public abstract Landroid/text/method/ReplacementTransformationMethod;
.super Ljava/lang/Object;
.source "ReplacementTransformationMethod.java"

# interfaces
.implements Landroid/text/method/TransformationMethod;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/text/method/ReplacementTransformationMethod$SpannedReplacementCharSequence;,
        Landroid/text/method/ReplacementTransformationMethod$ReplacementCharSequence;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 33
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 169
    return-void
.end method


# virtual methods
.method protected abstract getOriginal()[C
.end method

.method protected abstract getReplacement()[C
.end method

.method public getTransformation(Ljava/lang/CharSequence;Landroid/view/View;)Ljava/lang/CharSequence;
    .registers 10
    .parameter "source"
    .parameter "v"

    .prologue
    .line 53
    invoke-virtual {p0}, Landroid/text/method/ReplacementTransformationMethod;->getOriginal()[C

    move-result-object v3

    .line 54
    .local v3, original:[C
    invoke-virtual {p0}, Landroid/text/method/ReplacementTransformationMethod;->getReplacement()[C

    move-result-object v4

    .line 59
    .local v4, replacement:[C
    instance-of v5, p1, Landroid/text/Editable;

    if-nez v5, :cond_40

    .line 64
    const/4 v0, 0x1

    .line 65
    .local v0, doNothing:Z
    array-length v2, v3

    .line 66
    .local v2, n:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_f
    if-ge v1, v2, :cond_1a

    .line 67
    aget-char v5, v3, v1

    invoke-static {p1, v5}, Landroid/text/TextUtils;->indexOf(Ljava/lang/CharSequence;C)I

    move-result v5

    if-ltz v5, :cond_1d

    .line 68
    const/4 v0, 0x0

    .line 72
    :cond_1a
    if-eqz v0, :cond_20

    .line 98
    .end local v0           #doNothing:Z
    .end local v1           #i:I
    .end local v2           #n:I
    .end local p1
    :goto_1c
    return-object p1

    .line 66
    .restart local v0       #doNothing:Z
    .restart local v1       #i:I
    .restart local v2       #n:I
    .restart local p1
    :cond_1d
    add-int/lit8 v1, v1, 0x1

    goto :goto_f

    .line 76
    :cond_20
    instance-of v5, p1, Landroid/text/Spannable;

    if-nez v5, :cond_40

    .line 82
    instance-of v5, p1, Landroid/text/Spanned;

    if-eqz v5, :cond_36

    .line 83
    new-instance v5, Landroid/text/SpannedString;

    new-instance v6, Landroid/text/method/ReplacementTransformationMethod$SpannedReplacementCharSequence;

    check-cast p1, Landroid/text/Spanned;

    .end local p1
    invoke-direct {v6, p1, v3, v4}, Landroid/text/method/ReplacementTransformationMethod$SpannedReplacementCharSequence;-><init>(Landroid/text/Spanned;[C[C)V

    invoke-direct {v5, v6}, Landroid/text/SpannedString;-><init>(Ljava/lang/CharSequence;)V

    move-object p1, v5

    goto :goto_1c

    .line 87
    .restart local p1
    :cond_36
    new-instance v5, Landroid/text/method/ReplacementTransformationMethod$ReplacementCharSequence;

    invoke-direct {v5, p1, v3, v4}, Landroid/text/method/ReplacementTransformationMethod$ReplacementCharSequence;-><init>(Ljava/lang/CharSequence;[C[C)V

    invoke-virtual {v5}, Landroid/text/method/ReplacementTransformationMethod$ReplacementCharSequence;->toString()Ljava/lang/String;

    move-result-object p1

    goto :goto_1c

    .line 94
    .end local v0           #doNothing:Z
    .end local v1           #i:I
    .end local v2           #n:I
    :cond_40
    instance-of v5, p1, Landroid/text/Spanned;

    if-eqz v5, :cond_4d

    .line 95
    new-instance v5, Landroid/text/method/ReplacementTransformationMethod$SpannedReplacementCharSequence;

    check-cast p1, Landroid/text/Spanned;

    .end local p1
    invoke-direct {v5, p1, v3, v4}, Landroid/text/method/ReplacementTransformationMethod$SpannedReplacementCharSequence;-><init>(Landroid/text/Spanned;[C[C)V

    move-object p1, v5

    goto :goto_1c

    .line 98
    .restart local p1
    :cond_4d
    new-instance v5, Landroid/text/method/ReplacementTransformationMethod$ReplacementCharSequence;

    invoke-direct {v5, p1, v3, v4}, Landroid/text/method/ReplacementTransformationMethod$ReplacementCharSequence;-><init>(Ljava/lang/CharSequence;[C[C)V

    move-object p1, v5

    goto :goto_1c
.end method

.method public onFocusChanged(Landroid/view/View;Ljava/lang/CharSequence;ZILandroid/graphics/Rect;)V
    .registers 6
    .parameter "view"
    .parameter "sourceText"
    .parameter "focused"
    .parameter "direction"
    .parameter "previouslyFocusedRect"

    .prologue
    .line 106
    return-void
.end method
