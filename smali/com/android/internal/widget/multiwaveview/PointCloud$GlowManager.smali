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

    .line 67
    iput-object p1, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->this$0:Lcom/android/internal/widget/multiwaveview/PointCloud;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 70
    iput v0, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->radius:F

    .line 71
    iput v0, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->alpha:F

    return-void
.end method

.method static synthetic access$000(Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;)F
    .registers 2
    .parameter "x0"

    .prologue
    .line 67
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->x:F

    return v0
.end method

.method static synthetic access$100(Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;)F
    .registers 2
    .parameter "x0"

    .prologue
    .line 67
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->y:F

    return v0
.end method

.method static synthetic access$200(Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;)F
    .registers 2
    .parameter "x0"

    .prologue
    .line 67
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->radius:F

    return v0
.end method

.method static synthetic access$300(Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;)F
    .registers 2
    .parameter "x0"

    .prologue
    .line 67
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->alpha:F

    return v0
.end method


# virtual methods
.method public getAlpha()F
    .registers 2

    .prologue
    .line 94
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->alpha:F

    return v0
.end method

.method public getRadius()F
    .registers 2

    .prologue
    .line 102
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->radius:F

    return v0
.end method

.method public getX()F
    .registers 2

    .prologue
    .line 78
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->x:F

    return v0
.end method

.method public getY()F
    .registers 2

    .prologue
    .line 86
    iget v0, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->y:F

    return v0
.end method

.method public setAlpha(F)V
    .registers 2
    .parameter "a"

    .prologue
    .line 90
    iput p1, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->alpha:F

    .line 91
    return-void
.end method

.method public setRadius(F)V
    .registers 2
    .parameter "r"

    .prologue
    .line 98
    iput p1, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->radius:F

    .line 99
    return-void
.end method

.method public setX(F)V
    .registers 2
    .parameter "x1"

    .prologue
    .line 74
    iput p1, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->x:F

    .line 75
    return-void
.end method

.method public setY(F)V
    .registers 2
    .parameter "y1"

    .prologue
    .line 82
    iput p1, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$GlowManager;->y:F

    .line 83
    return-void
.end method
