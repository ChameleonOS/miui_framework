.class final Lcom/android/internal/widget/multiwaveview/Ease$Quad$3;
.super Ljava/lang/Object;
.source "Ease.java"

# interfaces
.implements Landroid/animation/TimeInterpolator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/widget/multiwaveview/Ease$Quad;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 65
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getInterpolation(F)F
    .registers 6
    .parameter "input"

    .prologue
    const/high16 v1, 0x3f00

    const/4 v3, 0x0

    const/high16 v2, 0x3f80

    .line 67
    div-float/2addr p1, v1

    cmpg-float v0, p1, v2

    if-gez v0, :cond_f

    mul-float v0, v1, p1

    mul-float/2addr v0, p1

    add-float/2addr v0, v3

    :goto_e
    return v0

    :cond_f
    const/high16 v0, -0x4100

    sub-float/2addr p1, v2

    const/high16 v1, 0x4000

    sub-float v1, p1, v1

    mul-float/2addr v1, p1

    sub-float/2addr v1, v2

    mul-float/2addr v0, v1

    add-float/2addr v0, v3

    goto :goto_e
.end method
