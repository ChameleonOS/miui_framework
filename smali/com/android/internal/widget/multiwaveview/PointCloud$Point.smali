.class Lcom/android/internal/widget/multiwaveview/PointCloud$Point;
.super Ljava/lang/Object;
.source "PointCloud.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/widget/multiwaveview/PointCloud;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "Point"
.end annotation


# instance fields
.field radius:F

.field final synthetic this$0:Lcom/android/internal/widget/multiwaveview/PointCloud;

.field x:F

.field y:F


# direct methods
.method public constructor <init>(Lcom/android/internal/widget/multiwaveview/PointCloud;FFF)V
    .registers 5
    .parameter
    .parameter "x2"
    .parameter "y2"
    .parameter "r"

    .prologue
    .line 111
    iput-object p1, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$Point;->this$0:Lcom/android/internal/widget/multiwaveview/PointCloud;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 112
    iput p2, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$Point;->x:F

    .line 113
    iput p3, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$Point;->y:F

    .line 114
    iput p4, p0, Lcom/android/internal/widget/multiwaveview/PointCloud$Point;->radius:F

    .line 115
    return-void
.end method
