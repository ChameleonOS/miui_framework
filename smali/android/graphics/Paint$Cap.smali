.class public final enum Landroid/graphics/Paint$Cap;
.super Ljava/lang/Enum;
.source "Paint.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/graphics/Paint;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Cap"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Landroid/graphics/Paint$Cap;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Landroid/graphics/Paint$Cap;

.field public static final enum BUTT:Landroid/graphics/Paint$Cap;

.field public static final enum ROUND:Landroid/graphics/Paint$Cap;

.field public static final enum SQUARE:Landroid/graphics/Paint$Cap;


# instance fields
.field final nativeInt:I


# direct methods
.method static constructor <clinit>()V
    .registers 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 268
    new-instance v0, Landroid/graphics/Paint$Cap;

    const-string v1, "BUTT"

    invoke-direct {v0, v1, v2, v2}, Landroid/graphics/Paint$Cap;-><init>(Ljava/lang/String;II)V

    sput-object v0, Landroid/graphics/Paint$Cap;->BUTT:Landroid/graphics/Paint$Cap;

    .line 273
    new-instance v0, Landroid/graphics/Paint$Cap;

    const-string v1, "ROUND"

    invoke-direct {v0, v1, v3, v3}, Landroid/graphics/Paint$Cap;-><init>(Ljava/lang/String;II)V

    sput-object v0, Landroid/graphics/Paint$Cap;->ROUND:Landroid/graphics/Paint$Cap;

    .line 278
    new-instance v0, Landroid/graphics/Paint$Cap;

    const-string v1, "SQUARE"

    invoke-direct {v0, v1, v4, v4}, Landroid/graphics/Paint$Cap;-><init>(Ljava/lang/String;II)V

    sput-object v0, Landroid/graphics/Paint$Cap;->SQUARE:Landroid/graphics/Paint$Cap;

    .line 264
    const/4 v0, 0x3

    new-array v0, v0, [Landroid/graphics/Paint$Cap;

    sget-object v1, Landroid/graphics/Paint$Cap;->BUTT:Landroid/graphics/Paint$Cap;

    aput-object v1, v0, v2

    sget-object v1, Landroid/graphics/Paint$Cap;->ROUND:Landroid/graphics/Paint$Cap;

    aput-object v1, v0, v3

    sget-object v1, Landroid/graphics/Paint$Cap;->SQUARE:Landroid/graphics/Paint$Cap;

    aput-object v1, v0, v4

    sput-object v0, Landroid/graphics/Paint$Cap;->$VALUES:[Landroid/graphics/Paint$Cap;

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
    .line 280
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 281
    iput p3, p0, Landroid/graphics/Paint$Cap;->nativeInt:I

    .line 282
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Landroid/graphics/Paint$Cap;
    .registers 2
    .parameter "name"

    .prologue
    .line 264
    const-class v0, Landroid/graphics/Paint$Cap;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Landroid/graphics/Paint$Cap;

    return-object v0
.end method

.method public static values()[Landroid/graphics/Paint$Cap;
    .registers 1

    .prologue
    .line 264
    sget-object v0, Landroid/graphics/Paint$Cap;->$VALUES:[Landroid/graphics/Paint$Cap;

    invoke-virtual {v0}, [Landroid/graphics/Paint$Cap;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/graphics/Paint$Cap;

    return-object v0
.end method
