.class final Lcom/android/internal/widget/multiwaveview/Ease$Quad$1;
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
    .line 55
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getInterpolation(F)F
    .registers 4
    .parameter "input"

    .prologue
    const/high16 v0, 0x3f80

    .line 57
    div-float/2addr p1, v0

    mul-float/2addr v0, p1

    mul-float/2addr v0, p1

    const/4 v1, 0x0

    add-float/2addr v0, v1

    return v0
.end method
