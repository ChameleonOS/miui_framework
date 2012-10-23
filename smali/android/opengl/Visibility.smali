.class public Landroid/opengl/Visibility;
.super Ljava/lang/Object;
.source "Visibility.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 24
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static native computeBoundingSphere([FII[FI)V
.end method

.method public static native frustumCullSpheres([FI[FII[III)I
.end method

.method public static native visibilityTest([FI[FI[CII)I
.end method
