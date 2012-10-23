.class public Landroid/graphics/ColorFilter;
.super Ljava/lang/Object;
.source "ColorFilter.java"


# instance fields
.field public nativeColorFilter:I

.field native_instance:I


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 25
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static native finalizer(II)V
.end method


# virtual methods
.method protected finalize()V
    .registers 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 35
    :try_start_0
    invoke-super {p0}, Ljava/lang/Object;->finalize()V
    :try_end_3
    .catchall {:try_start_0 .. :try_end_3} :catchall_b

    .line 37
    iget v0, p0, Landroid/graphics/ColorFilter;->native_instance:I

    iget v1, p0, Landroid/graphics/ColorFilter;->nativeColorFilter:I

    invoke-static {v0, v1}, Landroid/graphics/ColorFilter;->finalizer(II)V

    .line 39
    return-void

    .line 37
    :catchall_b
    move-exception v0

    iget v1, p0, Landroid/graphics/ColorFilter;->native_instance:I

    iget v2, p0, Landroid/graphics/ColorFilter;->nativeColorFilter:I

    invoke-static {v1, v2}, Landroid/graphics/ColorFilter;->finalizer(II)V

    throw v0
.end method
