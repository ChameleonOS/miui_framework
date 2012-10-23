.class public Landroid/text/style/RelativeSizeSpan;
.super Landroid/text/style/MetricAffectingSpan;
.source "RelativeSizeSpan.java"

# interfaces
.implements Landroid/text/ParcelableSpan;


# instance fields
.field private final mProportion:F


# direct methods
.method public constructor <init>(F)V
    .registers 2
    .parameter "proportion"

    .prologue
    .line 28
    invoke-direct {p0}, Landroid/text/style/MetricAffectingSpan;-><init>()V

    .line 29
    iput p1, p0, Landroid/text/style/RelativeSizeSpan;->mProportion:F

    .line 30
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .registers 3
    .parameter "src"

    .prologue
    .line 32
    invoke-direct {p0}, Landroid/text/style/MetricAffectingSpan;-><init>()V

    .line 33
    invoke-virtual {p1}, Landroid/os/Parcel;->readFloat()F

    move-result v0

    iput v0, p0, Landroid/text/style/RelativeSizeSpan;->mProportion:F

    .line 34
    return-void
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    .line 41
    const/4 v0, 0x0

    return v0
.end method

.method public getSizeChange()F
    .registers 2

    .prologue
    .line 49
    iget v0, p0, Landroid/text/style/RelativeSizeSpan;->mProportion:F

    return v0
.end method

.method public getSpanTypeId()I
    .registers 2

    .prologue
    .line 37
    const/4 v0, 0x3

    return v0
.end method

.method public updateDrawState(Landroid/text/TextPaint;)V
    .registers 4
    .parameter "ds"

    .prologue
    .line 54
    invoke-virtual {p1}, Landroid/text/TextPaint;->getTextSize()F

    move-result v0

    iget v1, p0, Landroid/text/style/RelativeSizeSpan;->mProportion:F

    mul-float/2addr v0, v1

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 55
    return-void
.end method

.method public updateMeasureState(Landroid/text/TextPaint;)V
    .registers 4
    .parameter "ds"

    .prologue
    .line 59
    invoke-virtual {p1}, Landroid/text/TextPaint;->getTextSize()F

    move-result v0

    iget v1, p0, Landroid/text/style/RelativeSizeSpan;->mProportion:F

    mul-float/2addr v0, v1

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 60
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 4
    .parameter "dest"
    .parameter "flags"

    .prologue
    .line 45
    iget v0, p0, Landroid/text/style/RelativeSizeSpan;->mProportion:F

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeFloat(F)V

    .line 46
    return-void
.end method
