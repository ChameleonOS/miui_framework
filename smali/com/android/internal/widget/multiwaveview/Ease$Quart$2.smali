.class final Lcom/android/internal/widget/multiwaveview/Ease$Quart$2;
.super Ljava/lang/Object;
.source "Ease.java"

# interfaces
.implements Landroid/animation/TimeInterpolator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/widget/multiwaveview/Ease$Quart;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 80
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getInterpolation(F)F
    .registers 5
    .parameter "input"

    .prologue
    const/high16 v2, 0x3f80

    .line 82
    const/high16 v0, -0x4080

    div-float v1, p1, v2

    sub-float p1, v1, v2

    mul-float v1, p1, p1

    mul-float/2addr v1, p1

    mul-float/2addr v1, p1

    sub-float/2addr v1, v2

    mul-float/2addr v0, v1

    const/4 v1, 0x0

    add-float/2addr v0, v1

    return v0
.end method
