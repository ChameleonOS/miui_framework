.class public final enum Landroid/graphics/Canvas$VertexMode;
.super Ljava/lang/Enum;
.source "Canvas.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/graphics/Canvas;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "VertexMode"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Landroid/graphics/Canvas$VertexMode;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Landroid/graphics/Canvas$VertexMode;

.field public static final enum TRIANGLES:Landroid/graphics/Canvas$VertexMode;

.field public static final enum TRIANGLE_FAN:Landroid/graphics/Canvas$VertexMode;

.field public static final enum TRIANGLE_STRIP:Landroid/graphics/Canvas$VertexMode;


# instance fields
.field public final nativeInt:I


# direct methods
.method static constructor <clinit>()V
    .registers 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 1255
    new-instance v0, Landroid/graphics/Canvas$VertexMode;

    const-string v1, "TRIANGLES"

    invoke-direct {v0, v1, v2, v2}, Landroid/graphics/Canvas$VertexMode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Landroid/graphics/Canvas$VertexMode;->TRIANGLES:Landroid/graphics/Canvas$VertexMode;

    .line 1256
    new-instance v0, Landroid/graphics/Canvas$VertexMode;

    const-string v1, "TRIANGLE_STRIP"

    invoke-direct {v0, v1, v3, v3}, Landroid/graphics/Canvas$VertexMode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Landroid/graphics/Canvas$VertexMode;->TRIANGLE_STRIP:Landroid/graphics/Canvas$VertexMode;

    .line 1257
    new-instance v0, Landroid/graphics/Canvas$VertexMode;

    const-string v1, "TRIANGLE_FAN"

    invoke-direct {v0, v1, v4, v4}, Landroid/graphics/Canvas$VertexMode;-><init>(Ljava/lang/String;II)V

    sput-object v0, Landroid/graphics/Canvas$VertexMode;->TRIANGLE_FAN:Landroid/graphics/Canvas$VertexMode;

    .line 1254
    const/4 v0, 0x3

    new-array v0, v0, [Landroid/graphics/Canvas$VertexMode;

    sget-object v1, Landroid/graphics/Canvas$VertexMode;->TRIANGLES:Landroid/graphics/Canvas$VertexMode;

    aput-object v1, v0, v2

    sget-object v1, Landroid/graphics/Canvas$VertexMode;->TRIANGLE_STRIP:Landroid/graphics/Canvas$VertexMode;

    aput-object v1, v0, v3

    sget-object v1, Landroid/graphics/Canvas$VertexMode;->TRIANGLE_FAN:Landroid/graphics/Canvas$VertexMode;

    aput-object v1, v0, v4

    sput-object v0, Landroid/graphics/Canvas$VertexMode;->$VALUES:[Landroid/graphics/Canvas$VertexMode;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .registers 4
    .parameter
    .parameter
    .parameter "nativeInt"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 1259
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 1260
    iput p3, p0, Landroid/graphics/Canvas$VertexMode;->nativeInt:I

    .line 1261
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Landroid/graphics/Canvas$VertexMode;
    .registers 2
    .parameter "name"

    .prologue
    .line 1254
    const-class v0, Landroid/graphics/Canvas$VertexMode;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Landroid/graphics/Canvas$VertexMode;

    return-object v0
.end method

.method public static values()[Landroid/graphics/Canvas$VertexMode;
    .registers 1

    .prologue
    .line 1254
    sget-object v0, Landroid/graphics/Canvas$VertexMode;->$VALUES:[Landroid/graphics/Canvas$VertexMode;

    invoke-virtual {v0}, [Landroid/graphics/Canvas$VertexMode;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/graphics/Canvas$VertexMode;

    return-object v0
.end method
