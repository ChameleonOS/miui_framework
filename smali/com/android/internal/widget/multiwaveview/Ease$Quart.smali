.class Lcom/android/internal/widget/multiwaveview/Ease$Quart;
.super Ljava/lang/Object;
.source "Ease.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/widget/multiwaveview/Ease;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Quart"
.end annotation


# static fields
.field public static final easeIn:Landroid/animation/TimeInterpolator;

.field public static final easeInOut:Landroid/animation/TimeInterpolator;

.field public static final easeOut:Landroid/animation/TimeInterpolator;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 75
    new-instance v0, Lcom/android/internal/widget/multiwaveview/Ease$Quart$1;

    invoke-direct {v0}, Lcom/android/internal/widget/multiwaveview/Ease$Quart$1;-><init>()V

    sput-object v0, Lcom/android/internal/widget/multiwaveview/Ease$Quart;->easeIn:Landroid/animation/TimeInterpolator;

    .line 80
    new-instance v0, Lcom/android/internal/widget/multiwaveview/Ease$Quart$2;

    invoke-direct {v0}, Lcom/android/internal/widget/multiwaveview/Ease$Quart$2;-><init>()V

    sput-object v0, Lcom/android/internal/widget/multiwaveview/Ease$Quart;->easeOut:Landroid/animation/TimeInterpolator;

    .line 85
    new-instance v0, Lcom/android/internal/widget/multiwaveview/Ease$Quart$3;

    invoke-direct {v0}, Lcom/android/internal/widget/multiwaveview/Ease$Quart$3;-><init>()V

    sput-object v0, Lcom/android/internal/widget/multiwaveview/Ease$Quart;->easeInOut:Landroid/animation/TimeInterpolator;

    return-void
.end method

.method constructor <init>()V
    .registers 1

    .prologue
    .line 74
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
