.class public Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;
.super Ljava/lang/Object;
.source "PointCloud.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/widget/multiwaveview/PointCloud;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "GlowManager"
.end annotation


# instance fields
.field private alpha:F

.field private radius:F

.field final synthetic this$0:Lcom/android/internal/widget/multiwaveview/PointCloud;

.field private x:F

.field private y:F


# direct methods
.method public constructor <init>(Lcom/android/internal/widget/multiwaveview/PointCloud;)V
    .registers 3
    .parameter

    .prologue
    const/4 v0, 0x0

    iput-object p1, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->this$0:Lcom/android/internal/widget/multiwaveview/PointCloud;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput v0, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->radius:F

    iput v0, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->alpha:F

    return-void
.end method

.method static synthetic access$000(Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;)F
    .registers 2
    .parameter "x0"

    .prologue
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->x:F

    return v0
.end method

.method static synthetic access$100(Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;)F
    .registers 2
    .parameter "x0"

    .prologue
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->y:F

    return v0
.end method

.method static synthetic access$200(Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;)F
    .registers 2
    .parameter "x0"

    .prologue
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->radius:F

    return v0
.end method

.method static synthetic access$300(Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;)F
    .registers 2
    .parameter "x0"

    .prologue
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->alpha:F

    return v0
.end method


# virtual methods
.method public getAlpha()F
    .registers 2

    .prologue
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->alpha:F

    return v0
.end method

.method public getRadius()F
    .registers 2

    .prologue
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->radius:F

    return v0
.end method

.method public getX()F
    .registers 2

    .prologue
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->x:F

    return v0
.end method

.method public getY()F
    .registers 2

    .prologue
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->y:F

    return v0
.end method

.method public setAlpha(F)V
    .registers 2
    .parameter "a"

    .prologue
    iput p1, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->alpha:F

    return-void
.end method

.method public setRadius(F)V
    .registers 2
    .parameter "r"

    .prologue
    iput p1, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->radius:F

    return-void
.end method

.method public setX(F)V
    .registers 2
    .parameter "x1"

    .prologue
    iput p1, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->x:F

    return-void
.end method

.method public setY(F)V
    .registers 2
    .parameter "y1"

    .prologue
    iput p1, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->y:F

    return-void
.end method
