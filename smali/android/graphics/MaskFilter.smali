.class public Landroid/graphics/MaskFilter;
.super Ljava/lang/Object;
.source "MaskFilter.java"


# instance fields
.field native_instance:I


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 24
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static native nativeDestructor(I)V
.end method


# virtual methods
.method protected finalize()V
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 27
    iget v0, p0, Landroid/graphics/MaskFilter;->native_instance:I

    invoke-static {v0}, Landroid/graphics/MaskFilter;->nativeDestructor(I)V

    .line 28
    return-void
.end method
