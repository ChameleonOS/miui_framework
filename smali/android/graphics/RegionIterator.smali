.class public Landroid/graphics/RegionIterator;
.super Ljava/lang/Object;
.source "RegionIterator.java"


# instance fields
.field private final mNativeIter:I


# direct methods
.method public constructor <init>(Landroid/graphics/Region;)V
    .registers 3
    .parameter "region"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    invoke-virtual {p1}, Landroid/graphics/Region;->ni()I

    move-result v0

    invoke-static {v0}, Landroid/graphics/RegionIterator;->nativeConstructor(I)I

    move-result v0

    iput v0, p0, Landroid/graphics/RegionIterator;->mNativeIter:I

    return-void
.end method

.method private static native nativeConstructor(I)I
.end method

.method private static native nativeDestructor(I)V
.end method

.method private static native nativeNext(ILandroid/graphics/Rect;)Z
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
    iget v0, p0, Landroid/graphics/RegionIterator;->mNativeIter:I

    invoke-static {v0}, Landroid/graphics/RegionIterator;->nativeDestructor(I)V

    return-void
.end method

.method public final next(Landroid/graphics/Rect;)Z
    .registers 4
    .parameter "r"

    .prologue
    if-nez p1, :cond_a

    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "The Rect must be provided"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_a
    iget v0, p0, Landroid/graphics/RegionIterator;->mNativeIter:I

    invoke-static {v0, p1}, Landroid/graphics/RegionIterator;->nativeNext(ILandroid/graphics/Rect;)Z

    move-result v0

    return v0
.end method
