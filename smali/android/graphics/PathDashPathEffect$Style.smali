.class public final enum Landroid/graphics/PathDashPathEffect$Style;
.super Ljava/lang/Enum;
.source "PathDashPathEffect.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/graphics/PathDashPathEffect;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Style"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Landroid/graphics/PathDashPathEffect$Style;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Landroid/graphics/PathDashPathEffect$Style;

.field public static final enum MORPH:Landroid/graphics/PathDashPathEffect$Style;

.field public static final enum ROTATE:Landroid/graphics/PathDashPathEffect$Style;

.field public static final enum TRANSLATE:Landroid/graphics/PathDashPathEffect$Style;


# instance fields
.field native_style:I


# direct methods
.method static constructor <clinit>()V
    .registers 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 22
    new-instance v0, Landroid/graphics/PathDashPathEffect$Style;

    const-string v1, "TRANSLATE"

    invoke-direct {v0, v1, v2, v2}, Landroid/graphics/PathDashPathEffect$Style;-><init>(Ljava/lang/String;II)V

    sput-object v0, Landroid/graphics/PathDashPathEffect$Style;->TRANSLATE:Landroid/graphics/PathDashPathEffect$Style;

    .line 23
    new-instance v0, Landroid/graphics/PathDashPathEffect$Style;

    const-string v1, "ROTATE"

    invoke-direct {v0, v1, v3, v3}, Landroid/graphics/PathDashPathEffect$Style;-><init>(Ljava/lang/String;II)V

    sput-object v0, Landroid/graphics/PathDashPathEffect$Style;->ROTATE:Landroid/graphics/PathDashPathEffect$Style;

    .line 24
    new-instance v0, Landroid/graphics/PathDashPathEffect$Style;

    const-string v1, "MORPH"

    invoke-direct {v0, v1, v4, v4}, Landroid/graphics/PathDashPathEffect$Style;-><init>(Ljava/lang/String;II)V

    sput-object v0, Landroid/graphics/PathDashPathEffect$Style;->MORPH:Landroid/graphics/PathDashPathEffect$Style;

    .line 21
    const/4 v0, 0x3

    new-array v0, v0, [Landroid/graphics/PathDashPathEffect$Style;

    sget-object v1, Landroid/graphics/PathDashPathEffect$Style;->TRANSLATE:Landroid/graphics/PathDashPathEffect$Style;

    aput-object v1, v0, v2

    sget-object v1, Landroid/graphics/PathDashPathEffect$Style;->ROTATE:Landroid/graphics/PathDashPathEffect$Style;

    aput-object v1, v0, v3

    sget-object v1, Landroid/graphics/PathDashPathEffect$Style;->MORPH:Landroid/graphics/PathDashPathEffect$Style;

    aput-object v1, v0, v4

    sput-object v0, Landroid/graphics/PathDashPathEffect$Style;->$VALUES:[Landroid/graphics/PathDashPathEffect$Style;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .registers 4
    .parameter
    .parameter
    .parameter "value"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 26
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 27
    iput p3, p0, Landroid/graphics/PathDashPathEffect$Style;->native_style:I

    .line 28
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Landroid/graphics/PathDashPathEffect$Style;
    .registers 2
    .parameter "name"

    .prologue
    .line 21
    const-class v0, Landroid/graphics/PathDashPathEffect$Style;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Landroid/graphics/PathDashPathEffect$Style;

    return-object v0
.end method

.method public static values()[Landroid/graphics/PathDashPathEffect$Style;
    .registers 1

    .prologue
    .line 21
    sget-object v0, Landroid/graphics/PathDashPathEffect$Style;->$VALUES:[Landroid/graphics/PathDashPathEffect$Style;

    invoke-virtual {v0}, [Landroid/graphics/PathDashPathEffect$Style;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/graphics/PathDashPathEffect$Style;

    return-object v0
.end method
