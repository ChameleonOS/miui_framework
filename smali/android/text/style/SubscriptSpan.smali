.class public Landroid/text/style/SubscriptSpan;
.super Landroid/text/style/MetricAffectingSpan;
.source "SubscriptSpan.java"

# interfaces
.implements Landroid/text/ParcelableSpan;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 25
    invoke-direct {p0}, Landroid/text/style/MetricAffectingSpan;-><init>()V

    .line 26
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .registers 2
    .parameter "src"

    .prologue
    .line 28
    invoke-direct {p0}, Landroid/text/style/MetricAffectingSpan;-><init>()V

    .line 29
    return-void
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    .line 36
    const/4 v0, 0x0

    return v0
.end method

.method public getSpanTypeId()I
    .registers 2

    .prologue
    .line 32
    const/16 v0, 0xf

    return v0
.end method

.method public updateDrawState(Landroid/text/TextPaint;)V
    .registers 5
    .parameter "tp"

    .prologue
    .line 44
    iget v0, p1, Landroid/text/TextPaint;->baselineShift:I

    invoke-virtual {p1}, Landroid/text/TextPaint;->ascent()F

    move-result v1

    const/high16 v2, 0x4000

    div-float/2addr v1, v2

    float-to-int v1, v1

    sub-int/2addr v0, v1

    iput v0, p1, Landroid/text/TextPaint;->baselineShift:I

    .line 45
    return-void
.end method

.method public updateMeasureState(Landroid/text/TextPaint;)V
    .registers 5
    .parameter "tp"

    .prologue
    .line 49
    iget v0, p1, Landroid/text/TextPaint;->baselineShift:I

    invoke-virtual {p1}, Landroid/text/TextPaint;->ascent()F

    move-result v1

    const/high16 v2, 0x4000

    div-float/2addr v1, v2

    float-to-int v1, v1

    sub-int/2addr v0, v1

    iput v0, p1, Landroid/text/TextPaint;->baselineShift:I

    .line 50
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 3
    .parameter "dest"
    .parameter "flags"

    .prologue
    .line 40
    return-void
.end method
