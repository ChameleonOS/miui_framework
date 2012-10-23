.class public Landroid/graphics/Region;
.super Ljava/lang/Object;
.source "Region.java"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/graphics/Region$Op;
    }
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/graphics/Region;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public final mNativeRegion:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 296
    new-instance v0, Landroid/graphics/Region$1;

    invoke-direct {v0}, Landroid/graphics/Region$1;-><init>()V

    sput-object v0, Landroid/graphics/Region;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .registers 2

    .prologue
    .line 50
    invoke-static {}, Landroid/graphics/Region;->nativeConstructor()I

    move-result v0

    invoke-direct {p0, v0}, Landroid/graphics/Region;-><init>(I)V

    .line 51
    return-void
.end method

.method constructor <init>(I)V
    .registers 3
    .parameter "ni"

    .prologue
    .line 347
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 348
    if-nez p1, :cond_b

    .line 349
    new-instance v0, Ljava/lang/RuntimeException;

    invoke-direct {v0}, Ljava/lang/RuntimeException;-><init>()V

    throw v0

    .line 351
    :cond_b
    iput p1, p0, Landroid/graphics/Region;->mNativeRegion:I

    .line 352
    return-void
.end method

.method private constructor <init>(II)V
    .registers 3
    .parameter "ni"
    .parameter "dummy"

    .prologue
    .line 357
    invoke-direct {p0, p1}, Landroid/graphics/Region;-><init>(I)V

    .line 358
    return-void
.end method

.method public constructor <init>(IIII)V
    .registers 6
    .parameter "left"
    .parameter "top"
    .parameter "right"
    .parameter "bottom"

    .prologue
    .line 69
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 70
    invoke-static {}, Landroid/graphics/Region;->nativeConstructor()I

    move-result v0

    iput v0, p0, Landroid/graphics/Region;->mNativeRegion:I

    .line 71
    iget v0, p0, Landroid/graphics/Region;->mNativeRegion:I

    invoke-static {v0, p1, p2, p3, p4}, Landroid/graphics/Region;->nativeSetRect(IIIII)Z

    .line 72
    return-void
.end method

.method public constructor <init>(Landroid/graphics/Rect;)V
    .registers 7
    .parameter "r"

    .prologue
    .line 62
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 63
    invoke-static {}, Landroid/graphics/Region;->nativeConstructor()I

    move-result v0

    iput v0, p0, Landroid/graphics/Region;->mNativeRegion:I

    .line 64
    iget v0, p0, Landroid/graphics/Region;->mNativeRegion:I

    iget v1, p1, Landroid/graphics/Rect;->left:I

    iget v2, p1, Landroid/graphics/Rect;->top:I

    iget v3, p1, Landroid/graphics/Rect;->right:I

    iget v4, p1, Landroid/graphics/Rect;->bottom:I

    invoke-static {v0, v1, v2, v3, v4}, Landroid/graphics/Region;->nativeSetRect(IIIII)Z

    .line 65
    return-void
.end method

.method public constructor <init>(Landroid/graphics/Region;)V
    .registers 4
    .parameter "region"

    .prologue
    .line 56
    invoke-static {}, Landroid/graphics/Region;->nativeConstructor()I

    move-result v0

    invoke-direct {p0, v0}, Landroid/graphics/Region;-><init>(I)V

    .line 57
    iget v0, p0, Landroid/graphics/Region;->mNativeRegion:I

    iget v1, p1, Landroid/graphics/Region;->mNativeRegion:I

    invoke-static {v0, v1}, Landroid/graphics/Region;->nativeSetRegion(II)Z

    .line 58
    return-void
.end method

.method static synthetic access$000(Landroid/os/Parcel;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 22
    invoke-static {p0}, Landroid/graphics/Region;->nativeCreateFromParcel(Landroid/os/Parcel;)I

    move-result v0

    return v0
.end method

.method private static native nativeConstructor()I
.end method

.method private static native nativeCreateFromParcel(Landroid/os/Parcel;)I
.end method

.method private static native nativeDestructor(I)V
.end method

.method private static native nativeEquals(II)Z
.end method

.method private static native nativeGetBoundaryPath(II)Z
.end method

.method private static native nativeGetBounds(ILandroid/graphics/Rect;)Z
.end method

.method private static native nativeOp(IIII)Z
.end method

.method private static native nativeOp(IIIIII)Z
.end method

.method private static native nativeOp(ILandroid/graphics/Rect;II)Z
.end method

.method private static native nativeSetPath(III)Z
.end method

.method private static native nativeSetRect(IIIII)Z
.end method

.method private static native nativeSetRegion(II)Z
.end method

.method private static native nativeToString(I)Ljava/lang/String;
.end method

.method private static native nativeWriteToParcel(ILandroid/os/Parcel;)Z
.end method


# virtual methods
.method public native contains(II)Z
.end method

.method public describeContents()I
    .registers 2

    .prologue
    .line 316
    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 5
    .parameter "obj"

    .prologue
    .line 332
    if-eqz p1, :cond_6

    instance-of v1, p1, Landroid/graphics/Region;

    if-nez v1, :cond_8

    .line 333
    :cond_6
    const/4 v1, 0x0

    .line 336
    :goto_7
    return v1

    :cond_8
    move-object v0, p1

    .line 335
    check-cast v0, Landroid/graphics/Region;

    .line 336
    .local v0, peer:Landroid/graphics/Region;
    iget v1, p0, Landroid/graphics/Region;->mNativeRegion:I

    iget v2, v0, Landroid/graphics/Region;->mNativeRegion:I

    invoke-static {v1, v2}, Landroid/graphics/Region;->nativeEquals(II)Z

    move-result v1

    goto :goto_7
.end method

.method protected finalize()V
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 341
    :try_start_0
    iget v0, p0, Landroid/graphics/Region;->mNativeRegion:I

    invoke-static {v0}, Landroid/graphics/Region;->nativeDestructor(I)V
    :try_end_5
    .catchall {:try_start_0 .. :try_end_5} :catchall_9

    .line 343
    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    .line 345
    return-void

    .line 343
    :catchall_9
    move-exception v0

    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    throw v0
.end method

.method public getBoundaryPath()Landroid/graphics/Path;
    .registers 4

    .prologue
    .line 149
    new-instance v0, Landroid/graphics/Path;

    invoke-direct {v0}, Landroid/graphics/Path;-><init>()V

    .line 150
    .local v0, path:Landroid/graphics/Path;
    iget v1, p0, Landroid/graphics/Region;->mNativeRegion:I

    invoke-virtual {v0}, Landroid/graphics/Path;->ni()I

    move-result v2

    invoke-static {v1, v2}, Landroid/graphics/Region;->nativeGetBoundaryPath(II)Z

    .line 151
    return-object v0
.end method

.method public getBoundaryPath(Landroid/graphics/Path;)Z
    .registers 4
    .parameter "path"

    .prologue
    .line 159
    iget v0, p0, Landroid/graphics/Region;->mNativeRegion:I

    invoke-virtual {p1}, Landroid/graphics/Path;->ni()I

    move-result v1

    invoke-static {v0, v1}, Landroid/graphics/Region;->nativeGetBoundaryPath(II)Z

    move-result v0

    return v0
.end method

.method public getBounds()Landroid/graphics/Rect;
    .registers 3

    .prologue
    .line 128
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .line 129
    .local v0, r:Landroid/graphics/Rect;
    iget v1, p0, Landroid/graphics/Region;->mNativeRegion:I

    invoke-static {v1, v0}, Landroid/graphics/Region;->nativeGetBounds(ILandroid/graphics/Rect;)Z

    .line 130
    return-object v0
.end method

.method public getBounds(Landroid/graphics/Rect;)Z
    .registers 3
    .parameter "r"

    .prologue
    .line 138
    if-nez p1, :cond_8

    .line 139
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    .line 141
    :cond_8
    iget v0, p0, Landroid/graphics/Region;->mNativeRegion:I

    invoke-static {v0, p1}, Landroid/graphics/Region;->nativeGetBounds(ILandroid/graphics/Rect;)Z

    move-result v0

    return v0
.end method

.method public native isComplex()Z
.end method

.method public native isEmpty()Z
.end method

.method public native isRect()Z
.end method

.method final ni()I
    .registers 2

    .prologue
    .line 361
    iget v0, p0, Landroid/graphics/Region;->mNativeRegion:I

    return v0
.end method

.method public op(IIIILandroid/graphics/Region$Op;)Z
    .registers 12
    .parameter "left"
    .parameter "top"
    .parameter "right"
    .parameter "bottom"
    .parameter "op"

    .prologue
    .line 260
    iget v0, p0, Landroid/graphics/Region;->mNativeRegion:I

    iget v5, p5, Landroid/graphics/Region$Op;->nativeInt:I

    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    invoke-static/range {v0 .. v5}, Landroid/graphics/Region;->nativeOp(IIIIII)Z

    move-result v0

    return v0
.end method

.method public op(Landroid/graphics/Rect;Landroid/graphics/Region$Op;)Z
    .registers 9
    .parameter "r"
    .parameter "op"

    .prologue
    .line 251
    iget v0, p0, Landroid/graphics/Region;->mNativeRegion:I

    iget v1, p1, Landroid/graphics/Rect;->left:I

    iget v2, p1, Landroid/graphics/Rect;->top:I

    iget v3, p1, Landroid/graphics/Rect;->right:I

    iget v4, p1, Landroid/graphics/Rect;->bottom:I

    iget v5, p2, Landroid/graphics/Region$Op;->nativeInt:I

    invoke-static/range {v0 .. v5}, Landroid/graphics/Region;->nativeOp(IIIIII)Z

    move-result v0

    return v0
.end method

.method public op(Landroid/graphics/Rect;Landroid/graphics/Region;Landroid/graphics/Region$Op;)Z
    .registers 7
    .parameter "rect"
    .parameter "region"
    .parameter "op"

    .prologue
    .line 277
    iget v0, p0, Landroid/graphics/Region;->mNativeRegion:I

    iget v1, p2, Landroid/graphics/Region;->mNativeRegion:I

    iget v2, p3, Landroid/graphics/Region$Op;->nativeInt:I

    invoke-static {v0, p1, v1, v2}, Landroid/graphics/Region;->nativeOp(ILandroid/graphics/Rect;II)Z

    move-result v0

    return v0
.end method

.method public op(Landroid/graphics/Region;Landroid/graphics/Region$Op;)Z
    .registers 4
    .parameter "region"
    .parameter "op"

    .prologue
    .line 269
    invoke-virtual {p0, p0, p1, p2}, Landroid/graphics/Region;->op(Landroid/graphics/Region;Landroid/graphics/Region;Landroid/graphics/Region$Op;)Z

    move-result v0

    return v0
.end method

.method public op(Landroid/graphics/Region;Landroid/graphics/Region;Landroid/graphics/Region$Op;)Z
    .registers 8
    .parameter "region1"
    .parameter "region2"
    .parameter "op"

    .prologue
    .line 286
    iget v0, p0, Landroid/graphics/Region;->mNativeRegion:I

    iget v1, p1, Landroid/graphics/Region;->mNativeRegion:I

    iget v2, p2, Landroid/graphics/Region;->mNativeRegion:I

    iget v3, p3, Landroid/graphics/Region$Op;->nativeInt:I

    invoke-static {v0, v1, v2, v3}, Landroid/graphics/Region;->nativeOp(IIII)Z

    move-result v0

    return v0
.end method

.method public native quickContains(IIII)Z
.end method

.method public quickContains(Landroid/graphics/Rect;)Z
    .registers 6
    .parameter "r"

    .prologue
    .line 174
    iget v0, p1, Landroid/graphics/Rect;->left:I

    iget v1, p1, Landroid/graphics/Rect;->top:I

    iget v2, p1, Landroid/graphics/Rect;->right:I

    iget v3, p1, Landroid/graphics/Rect;->bottom:I

    invoke-virtual {p0, v0, v1, v2, v3}, Landroid/graphics/Region;->quickContains(IIII)Z

    move-result v0

    return v0
.end method

.method public native quickReject(IIII)Z
.end method

.method public quickReject(Landroid/graphics/Rect;)Z
    .registers 6
    .parameter "r"

    .prologue
    .line 192
    iget v0, p1, Landroid/graphics/Rect;->left:I

    iget v1, p1, Landroid/graphics/Rect;->top:I

    iget v2, p1, Landroid/graphics/Rect;->right:I

    iget v3, p1, Landroid/graphics/Rect;->bottom:I

    invoke-virtual {p0, v0, v1, v2, v3}, Landroid/graphics/Region;->quickReject(IIII)Z

    move-result v0

    return v0
.end method

.method public native quickReject(Landroid/graphics/Region;)Z
.end method

.method public scale(F)V
    .registers 3
    .parameter "scale"

    .prologue
    .line 232
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Landroid/graphics/Region;->scale(FLandroid/graphics/Region;)V

    .line 233
    return-void
.end method

.method public native scale(FLandroid/graphics/Region;)V
.end method

.method public set(IIII)Z
    .registers 6
    .parameter "left"
    .parameter "top"
    .parameter "right"
    .parameter "bottom"

    .prologue
    .line 95
    iget v0, p0, Landroid/graphics/Region;->mNativeRegion:I

    invoke-static {v0, p1, p2, p3, p4}, Landroid/graphics/Region;->nativeSetRect(IIIII)Z

    move-result v0

    return v0
.end method

.method public set(Landroid/graphics/Rect;)Z
    .registers 7
    .parameter "r"

    .prologue
    .line 89
    iget v0, p0, Landroid/graphics/Region;->mNativeRegion:I

    iget v1, p1, Landroid/graphics/Rect;->left:I

    iget v2, p1, Landroid/graphics/Rect;->top:I

    iget v3, p1, Landroid/graphics/Rect;->right:I

    iget v4, p1, Landroid/graphics/Rect;->bottom:I

    invoke-static {v0, v1, v2, v3, v4}, Landroid/graphics/Region;->nativeSetRect(IIIII)Z

    move-result v0

    return v0
.end method

.method public set(Landroid/graphics/Region;)Z
    .registers 4
    .parameter "region"

    .prologue
    .line 83
    iget v0, p0, Landroid/graphics/Region;->mNativeRegion:I

    iget v1, p1, Landroid/graphics/Region;->mNativeRegion:I

    invoke-static {v0, v1}, Landroid/graphics/Region;->nativeSetRegion(II)Z

    move-result v0

    return v0
.end method

.method public setEmpty()V
    .registers 3

    .prologue
    const/4 v1, 0x0

    .line 77
    iget v0, p0, Landroid/graphics/Region;->mNativeRegion:I

    invoke-static {v0, v1, v1, v1, v1}, Landroid/graphics/Region;->nativeSetRect(IIIII)Z

    .line 78
    return-void
.end method

.method public setPath(Landroid/graphics/Path;Landroid/graphics/Region;)Z
    .registers 6
    .parameter "path"
    .parameter "clip"

    .prologue
    .line 105
    iget v0, p0, Landroid/graphics/Region;->mNativeRegion:I

    invoke-virtual {p1}, Landroid/graphics/Path;->ni()I

    move-result v1

    iget v2, p2, Landroid/graphics/Region;->mNativeRegion:I

    invoke-static {v0, v1, v2}, Landroid/graphics/Region;->nativeSetPath(III)Z

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 2

    .prologue
    .line 291
    iget v0, p0, Landroid/graphics/Region;->mNativeRegion:I

    invoke-static {v0}, Landroid/graphics/Region;->nativeToString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public translate(II)V
    .registers 4
    .parameter "dx"
    .parameter "dy"

    .prologue
    .line 213
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Landroid/graphics/Region;->translate(IILandroid/graphics/Region;)V

    .line 214
    return-void
.end method

.method public native translate(IILandroid/graphics/Region;)V
.end method

.method public final union(Landroid/graphics/Rect;)Z
    .registers 3
    .parameter "r"

    .prologue
    .line 243
    sget-object v0, Landroid/graphics/Region$Op;->UNION:Landroid/graphics/Region$Op;

    invoke-virtual {p0, p1, v0}, Landroid/graphics/Region;->op(Landroid/graphics/Rect;Landroid/graphics/Region$Op;)Z

    move-result v0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 4
    .parameter "p"
    .parameter "flags"

    .prologue
    .line 325
    iget v0, p0, Landroid/graphics/Region;->mNativeRegion:I

    invoke-static {v0, p1}, Landroid/graphics/Region;->nativeWriteToParcel(ILandroid/os/Parcel;)Z

    move-result v0

    if-nez v0, :cond_e

    .line 326
    new-instance v0, Ljava/lang/RuntimeException;

    invoke-direct {v0}, Ljava/lang/RuntimeException;-><init>()V

    throw v0

    .line 328
    :cond_e
    return-void
.end method
