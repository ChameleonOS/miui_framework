.class public Landroid/text/InputFilter$LengthFilter;
.super Ljava/lang/Object;
.source "InputFilter.java"

# interfaces
.implements Landroid/text/InputFilter;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/text/InputFilter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LengthFilter"
.end annotation


# instance fields
.field private mMax:I


# direct methods
.method public constructor <init>(I)V
    .registers 2
    .parameter "max"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Landroid/text/InputFilter$LengthFilter;->mMax:I

    return-void
.end method


# virtual methods
.method public filter(Ljava/lang/CharSequence;IILandroid/text/Spanned;II)Ljava/lang/CharSequence;
    .registers 11
    .parameter "source"
    .parameter "start"
    .parameter "end"
    .parameter "dest"
    .parameter "dstart"
    .parameter "dend"

    .prologue
    iget v1, p0, Landroid/text/InputFilter$LengthFilter;->mMax:I

    invoke-interface {p4}, Landroid/text/Spanned;->length()I

    move-result v2

    sub-int v3, p6, p5

    sub-int/2addr v2, v3

    sub-int v0, v1, v2

    .local v0, keep:I
    if-gtz v0, :cond_10

    const-string v1, ""

    :goto_f
    return-object v1

    :cond_10
    sub-int v1, p3, p2

    if-lt v0, v1, :cond_16

    const/4 v1, 0x0

    goto :goto_f

    :cond_16
    add-int/2addr v0, p2

    add-int/lit8 v1, v0, -0x1

    invoke-interface {p1, v1}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v1

    invoke-static {v1}, Ljava/lang/Character;->isHighSurrogate(C)Z

    move-result v1

    if-eqz v1, :cond_2a

    add-int/lit8 v0, v0, -0x1

    if-ne v0, p2, :cond_2a

    const-string v1, ""

    goto :goto_f

    :cond_2a
    invoke-interface {p1, p2, v0}, Ljava/lang/CharSequence;->subSequence(II)Ljava/lang/CharSequence;

    move-result-object v1

    goto :goto_f
.end method
