.class public final enum Landroid/database/CursorJoiner$Result;
.super Ljava/lang/Enum;
.source "CursorJoiner.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/database/CursorJoiner;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Result"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Landroid/database/CursorJoiner$Result;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Landroid/database/CursorJoiner$Result;

.field public static final enum BOTH:Landroid/database/CursorJoiner$Result;

.field public static final enum LEFT:Landroid/database/CursorJoiner$Result;

.field public static final enum RIGHT:Landroid/database/CursorJoiner$Result;


# direct methods
.method static constructor <clinit>()V
    .registers 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 60
    new-instance v0, Landroid/database/CursorJoiner$Result;

    const-string v1, "RIGHT"

    invoke-direct {v0, v1, v2}, Landroid/database/CursorJoiner$Result;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/database/CursorJoiner$Result;->RIGHT:Landroid/database/CursorJoiner$Result;

    .line 62
    new-instance v0, Landroid/database/CursorJoiner$Result;

    const-string v1, "LEFT"

    invoke-direct {v0, v1, v3}, Landroid/database/CursorJoiner$Result;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/database/CursorJoiner$Result;->LEFT:Landroid/database/CursorJoiner$Result;

    .line 64
    new-instance v0, Landroid/database/CursorJoiner$Result;

    const-string v1, "BOTH"

    invoke-direct {v0, v1, v4}, Landroid/database/CursorJoiner$Result;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/database/CursorJoiner$Result;->BOTH:Landroid/database/CursorJoiner$Result;

    .line 58
    const/4 v0, 0x3

    new-array v0, v0, [Landroid/database/CursorJoiner$Result;

    sget-object v1, Landroid/database/CursorJoiner$Result;->RIGHT:Landroid/database/CursorJoiner$Result;

    aput-object v1, v0, v2

    sget-object v1, Landroid/database/CursorJoiner$Result;->LEFT:Landroid/database/CursorJoiner$Result;

    aput-object v1, v0, v3

    sget-object v1, Landroid/database/CursorJoiner$Result;->BOTH:Landroid/database/CursorJoiner$Result;

    aput-object v1, v0, v4

    sput-object v0, Landroid/database/CursorJoiner$Result;->$VALUES:[Landroid/database/CursorJoiner$Result;

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
    .line 58
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Landroid/database/CursorJoiner$Result;
    .registers 2
    .parameter "name"

    .prologue
    .line 58
    const-class v0, Landroid/database/CursorJoiner$Result;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Landroid/database/CursorJoiner$Result;

    return-object v0
.end method

.method public static values()[Landroid/database/CursorJoiner$Result;
    .registers 1

    .prologue
    .line 58
    sget-object v0, Landroid/database/CursorJoiner$Result;->$VALUES:[Landroid/database/CursorJoiner$Result;

    invoke-virtual {v0}, [Landroid/database/CursorJoiner$Result;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/database/CursorJoiner$Result;

    return-object v0
.end method
