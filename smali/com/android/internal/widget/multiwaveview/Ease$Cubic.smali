.class Lcom/android/internal/widget/multiwaveview/Ease$Cubic;
.super Ljava/lang/Object;
.source "Ease.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/widget/multiwaveview/Ease;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Cubic"
.end annotation


# static fields
.field public static final easeIn:Landroid/animation/TimeInterpolator;

.field public static final easeInOut:Landroid/animation/TimeInterpolator;

.field public static final easeOut:Landroid/animation/TimeInterpolator;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    new-instance v0, Lcom/android/internal/widget/multiwaveview/Ease$Cubic$1;

    invoke-direct {v0}, Lcom/android/internal/widget/multiwaveview/Ease$Cubic$1;-><init>()V

    sput-object v0, Lcom/android/internal/widget/multiwaveview/Ease$Cubic;->easeIn:Landroid/animation/TimeInterpolator;

    new-instance v0, Lcom/android/internal/widget/multiwaveview/Ease$Cubic$2;

    invoke-direct {v0}, Lcom/android/internal/widget/multiwaveview/Ease$Cubic$2;-><init>()V

    sput-object v0, Lcom/android/internal/widget/multiwaveview/Ease$Cubic;->easeOut:Landroid/animation/TimeInterpolator;

    new-instance v0, Lcom/android/internal/widget/multiwaveview/Ease$Cubic$3;

    invoke-direct {v0}, Lcom/android/internal/widget/multiwaveview/Ease$Cubic$3;-><init>()V

    sput-object v0, Lcom/android/internal/widget/multiwaveview/Ease$Cubic;->easeInOut:Landroid/animation/TimeInterpolator;

    return-void
.end method

.method constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
