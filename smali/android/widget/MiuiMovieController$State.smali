.class final enum Landroid/widget/MiuiMovieController$State;
.super Ljava/lang/Enum;
.source "MiuiMovieController.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/MiuiMovieController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "State"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Landroid/widget/MiuiMovieController$State;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Landroid/widget/MiuiMovieController$State;

.field public static final enum ENDED:Landroid/widget/MiuiMovieController$State;

.field public static final enum ERROR:Landroid/widget/MiuiMovieController$State;

.field public static final enum LOADING:Landroid/widget/MiuiMovieController$State;

.field public static final enum PAUSED:Landroid/widget/MiuiMovieController$State;

.field public static final enum PLAYING:Landroid/widget/MiuiMovieController$State;


# direct methods
.method static constructor <clinit>()V
    .registers 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    new-instance v0, Landroid/widget/MiuiMovieController$State;

    const-string v1, "PLAYING"

    invoke-direct {v0, v1, v2}, Landroid/widget/MiuiMovieController$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/widget/MiuiMovieController$State;->PLAYING:Landroid/widget/MiuiMovieController$State;

    new-instance v0, Landroid/widget/MiuiMovieController$State;

    const-string v1, "PAUSED"

    invoke-direct {v0, v1, v3}, Landroid/widget/MiuiMovieController$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/widget/MiuiMovieController$State;->PAUSED:Landroid/widget/MiuiMovieController$State;

    new-instance v0, Landroid/widget/MiuiMovieController$State;

    const-string v1, "ENDED"

    invoke-direct {v0, v1, v4}, Landroid/widget/MiuiMovieController$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/widget/MiuiMovieController$State;->ENDED:Landroid/widget/MiuiMovieController$State;

    new-instance v0, Landroid/widget/MiuiMovieController$State;

    const-string v1, "ERROR"

    invoke-direct {v0, v1, v5}, Landroid/widget/MiuiMovieController$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/widget/MiuiMovieController$State;->ERROR:Landroid/widget/MiuiMovieController$State;

    new-instance v0, Landroid/widget/MiuiMovieController$State;

    const-string v1, "LOADING"

    invoke-direct {v0, v1, v6}, Landroid/widget/MiuiMovieController$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/widget/MiuiMovieController$State;->LOADING:Landroid/widget/MiuiMovieController$State;

    const/4 v0, 0x5

    new-array v0, v0, [Landroid/widget/MiuiMovieController$State;

    sget-object v1, Landroid/widget/MiuiMovieController$State;->PLAYING:Landroid/widget/MiuiMovieController$State;

    aput-object v1, v0, v2

    sget-object v1, Landroid/widget/MiuiMovieController$State;->PAUSED:Landroid/widget/MiuiMovieController$State;

    aput-object v1, v0, v3

    sget-object v1, Landroid/widget/MiuiMovieController$State;->ENDED:Landroid/widget/MiuiMovieController$State;

    aput-object v1, v0, v4

    sget-object v1, Landroid/widget/MiuiMovieController$State;->ERROR:Landroid/widget/MiuiMovieController$State;

    aput-object v1, v0, v5

    sget-object v1, Landroid/widget/MiuiMovieController$State;->LOADING:Landroid/widget/MiuiMovieController$State;

    aput-object v1, v0, v6

    sput-object v0, Landroid/widget/MiuiMovieController$State;->$VALUES:[Landroid/widget/MiuiMovieController$State;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .registers 3
    .parameter
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Landroid/widget/MiuiMovieController$State;
    .registers 2
    .parameter "name"

    .prologue
    const-class v0, Landroid/widget/MiuiMovieController$State;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Landroid/widget/MiuiMovieController$State;

    return-object v0
.end method

.method public static values()[Landroid/widget/MiuiMovieController$State;
    .registers 1

    .prologue
    sget-object v0, Landroid/widget/MiuiMovieController$State;->$VALUES:[Landroid/widget/MiuiMovieController$State;

    invoke-virtual {v0}, [Landroid/widget/MiuiMovieController$State;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/widget/MiuiMovieController$State;

    return-object v0
.end method
