.class public Landroid/view/SurfaceSession;
.super Ljava/lang/Object;
.source "SurfaceSession.java"


# instance fields
.field private mClient:I


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    invoke-direct {p0}, Landroid/view/SurfaceSession;->init()V

    return-void
.end method

.method private native destroy()V
.end method

.method private native init()V
.end method


# virtual methods
.method protected finalize()V
    .registers 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    invoke-direct {p0}, Landroid/view/SurfaceSession;->destroy()V

    return-void
.end method

.method public native kill()V
.end method
