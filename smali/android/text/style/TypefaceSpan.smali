.class public Landroid/text/style/TypefaceSpan;
.super Landroid/text/style/MetricAffectingSpan;
.source "TypefaceSpan.java"

# interfaces
.implements Landroid/text/ParcelableSpan;


# instance fields
.field private final mFamily:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/os/Parcel;)V
    .registers 3
    .parameter "src"

    .prologue
    .line 40
    invoke-direct {p0}, Landroid/text/style/MetricAffectingSpan;-><init>()V

    .line 41
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/text/style/TypefaceSpan;->mFamily:Ljava/lang/String;

    .line 42
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .registers 2
    .parameter "family"

    .prologue
    .line 36
    invoke-direct {p0}, Landroid/text/style/MetricAffectingSpan;-><init>()V

    .line 37
    iput-object p1, p0, Landroid/text/style/TypefaceSpan;->mFamily:Ljava/lang/String;

    .line 38
    return-void
.end method

.method private static apply(Landroid/graphics/Paint;Ljava/lang/String;)V
    .registers 7
    .parameter "paint"
    .parameter "family"

    .prologue
    .line 76
    invoke-virtual {p0}, Landroid/graphics/Paint;->getTypeface()Landroid/graphics/Typeface;

    move-result-object v1

    .line 77
    .local v1, old:Landroid/graphics/Typeface;
    if-nez v1, :cond_28

    .line 78
    const/4 v2, 0x0

    .line 83
    .local v2, oldStyle:I
    :goto_7
    invoke-static {p1, v2}, Landroid/graphics/Typeface;->create(Ljava/lang/String;I)Landroid/graphics/Typeface;

    move-result-object v3

    .line 84
    .local v3, tf:Landroid/graphics/Typeface;
    invoke-virtual {v3}, Landroid/graphics/Typeface;->getStyle()I

    move-result v4

    xor-int/lit8 v4, v4, -0x1

    and-int v0, v2, v4

    .line 86
    .local v0, fake:I
    and-int/lit8 v4, v0, 0x1

    if-eqz v4, :cond_1b

    .line 87
    const/4 v4, 0x1

    invoke-virtual {p0, v4}, Landroid/graphics/Paint;->setFakeBoldText(Z)V

    .line 90
    :cond_1b
    and-int/lit8 v4, v0, 0x2

    if-eqz v4, :cond_24

    .line 91
    const/high16 v4, -0x4180

    invoke-virtual {p0, v4}, Landroid/graphics/Paint;->setTextSkewX(F)V

    .line 94
    :cond_24
    invoke-virtual {p0, v3}, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 95
    return-void

    .line 80
    .end local v0           #fake:I
    .end local v2           #oldStyle:I
    .end local v3           #tf:Landroid/graphics/Typeface;
    :cond_28
    invoke-virtual {v1}, Landroid/graphics/Typeface;->getStyle()I

    move-result v2

    .restart local v2       #oldStyle:I
    goto :goto_7
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    .line 49
    const/4 v0, 0x0

    return v0
.end method

.method public getFamily()Ljava/lang/String;
    .registers 2

    .prologue
    .line 60
    iget-object v0, p0, Landroid/text/style/TypefaceSpan;->mFamily:Ljava/lang/String;

    return-object v0
.end method

.method public getSpanTypeId()I
    .registers 2

    .prologue
    .line 45
    const/16 v0, 0xd

    return v0
.end method

.method public updateDrawState(Landroid/text/TextPaint;)V
    .registers 3
    .parameter "ds"

    .prologue
    .line 65
    iget-object v0, p0, Landroid/text/style/TypefaceSpan;->mFamily:Ljava/lang/String;

    invoke-static {p1, v0}, Landroid/text/style/TypefaceSpan;->apply(Landroid/graphics/Paint;Ljava/lang/String;)V

    .line 66
    return-void
.end method

.method public updateMeasureState(Landroid/text/TextPaint;)V
    .registers 3
    .parameter "paint"

    .prologue
    .line 70
    iget-object v0, p0, Landroid/text/style/TypefaceSpan;->mFamily:Ljava/lang/String;

    invoke-static {p1, v0}, Landroid/text/style/TypefaceSpan;->apply(Landroid/graphics/Paint;Ljava/lang/String;)V

    .line 71
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 4
    .parameter "dest"
    .parameter "flags"

    .prologue
    .line 53
    iget-object v0, p0, Landroid/text/style/TypefaceSpan;->mFamily:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 54
    return-void
.end method
