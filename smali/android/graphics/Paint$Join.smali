.class public final enum Landroid/graphics/Paint$Join;
.super Ljava/lang/Enum;
.source "Paint.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/graphics/Paint;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Join"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Landroid/graphics/Paint$Join;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Landroid/graphics/Paint$Join;

.field public static final enum BEVEL:Landroid/graphics/Paint$Join;

.field public static final enum MITER:Landroid/graphics/Paint$Join;

.field public static final enum ROUND:Landroid/graphics/Paint$Join;


# instance fields
.field final nativeInt:I


# direct methods
.method static constructor <clinit>()V
    .registers 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 294
    new-instance v0, Landroid/graphics/Paint$Join;

    const-string v1, "MITER"

    invoke-direct {v0, v1, v2, v2}, Landroid/graphics/Paint$Join;-><init>(Ljava/lang/String;II)V

    sput-object v0, Landroid/graphics/Paint$Join;->MITER:Landroid/graphics/Paint$Join;

    .line 298
    new-instance v0, Landroid/graphics/Paint$Join;

    const-string v1, "ROUND"

    invoke-direct {v0, v1, v3, v3}, Landroid/graphics/Paint$Join;-><init>(Ljava/lang/String;II)V

    sput-object v0, Landroid/graphics/Paint$Join;->ROUND:Landroid/graphics/Paint$Join;

    .line 302
    new-instance v0, Landroid/graphics/Paint$Join;

    const-string v1, "BEVEL"

    invoke-direct {v0, v1, v4, v4}, Landroid/graphics/Paint$Join;-><init>(Ljava/lang/String;II)V

    sput-object v0, Landroid/graphics/Paint$Join;->BEVEL:Landroid/graphics/Paint$Join;

    .line 290
    const/4 v0, 0x3

    new-array v0, v0, [Landroid/graphics/Paint$Join;

    sget-object v1, Landroid/graphics/Paint$Join;->MITER:Landroid/graphics/Paint$Join;

    aput-object v1, v0, v2

    sget-object v1, Landroid/graphics/Paint$Join;->ROUND:Landroid/graphics/Paint$Join;

    aput-object v1, v0, v3

    sget-object v1, Landroid/graphics/Paint$Join;->BEVEL:Landroid/graphics/Paint$Join;

    aput-object v1, v0, v4

    sput-object v0, Landroid/graphics/Paint$Join;->$VALUES:[Landroid/graphics/Paint$Join;

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
    .line 304
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 305
    iput p3, p0, Landroid/graphics/Paint$Join;->nativeInt:I

    .line 306
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Landroid/graphics/Paint$Join;
    .registers 2
    .parameter "name"

    .prologue
    .line 290
    const-class v0, Landroid/graphics/Paint$Join;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Landroid/graphics/Paint$Join;

    return-object v0
.end method

.method public static values()[Landroid/graphics/Paint$Join;
    .registers 1

    .prologue
    .line 290
    sget-object v0, Landroid/graphics/Paint$Join;->$VALUES:[Landroid/graphics/Paint$Join;

    invoke-virtual {v0}, [Landroid/graphics/Paint$Join;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/graphics/Paint$Join;

    return-object v0
.end method
