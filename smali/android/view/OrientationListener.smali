.class public abstract Landroid/view/OrientationListener;
.super Ljava/lang/Object;
.source "OrientationListener.java"

# interfaces
.implements Landroid/hardware/SensorListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/view/OrientationListener$OrientationEventListenerInternal;
    }
.end annotation

.annotation runtime Ljava/lang/Deprecated;
.end annotation


# static fields
.field public static final ORIENTATION_UNKNOWN:I = -0x1


# instance fields
.field private mOrientationEventLis:Landroid/view/OrientationEventListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 3
    .parameter "context"

    .prologue
    .line 45
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 46
    new-instance v0, Landroid/view/OrientationListener$OrientationEventListenerInternal;

    invoke-direct {v0, p0, p1}, Landroid/view/OrientationListener$OrientationEventListenerInternal;-><init>(Landroid/view/OrientationListener;Landroid/content/Context;)V

    iput-object v0, p0, Landroid/view/OrientationListener;->mOrientationEventLis:Landroid/view/OrientationEventListener;

    .line 47
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;I)V
    .registers 4
    .parameter "context"
    .parameter "rate"

    .prologue
    .line 58
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 59
    new-instance v0, Landroid/view/OrientationListener$OrientationEventListenerInternal;

    invoke-direct {v0, p0, p1, p2}, Landroid/view/OrientationListener$OrientationEventListenerInternal;-><init>(Landroid/view/OrientationListener;Landroid/content/Context;I)V

    iput-object v0, p0, Landroid/view/OrientationListener;->mOrientationEventLis:Landroid/view/OrientationEventListener;

    .line 60
    return-void
.end method


# virtual methods
.method public disable()V
    .registers 2

    .prologue
    .line 90
    iget-object v0, p0, Landroid/view/OrientationListener;->mOrientationEventLis:Landroid/view/OrientationEventListener;

    invoke-virtual {v0}, Landroid/view/OrientationEventListener;->disable()V

    .line 91
    return-void
.end method

.method public enable()V
    .registers 2

    .prologue
    .line 83
    iget-object v0, p0, Landroid/view/OrientationListener;->mOrientationEventLis:Landroid/view/OrientationEventListener;

    invoke-virtual {v0}, Landroid/view/OrientationEventListener;->enable()V

    .line 84
    return-void
.end method

.method public onAccuracyChanged(II)V
    .registers 3
    .parameter "sensor"
    .parameter "accuracy"

    .prologue
    .line 94
    return-void
.end method

.method public abstract onOrientationChanged(I)V
.end method

.method public onSensorChanged(I[F)V
    .registers 3
    .parameter "sensor"
    .parameter "values"

    .prologue
    .line 98
    return-void
.end method
