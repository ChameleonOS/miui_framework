.class Lcom/android/internal/widget/multiwaveview/Ease$Linear;
.super Ljava/lang/Object;
.source "Ease.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/widget/multiwaveview/Ease;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Linear"
.end annotation


# static fields
.field public static final easeNone:Landroid/animation/TimeInterpolator;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    new-instance v0, Lcom/android/internal/widget/multiwaveview/Ease$Linear$1;

    invoke-direct {v0}, Lcom/android/internal/widget/multiwaveview/Ease$Linear$1;-><init>()V

    sput-object v0, Lcom/android/internal/widget/multiwaveview/Ease$Linear;->easeNone:Landroid/animation/TimeInterpolator;

    return-void
.end method

.method constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
