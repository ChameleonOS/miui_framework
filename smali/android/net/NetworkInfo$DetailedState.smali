.class public final enum Landroid/net/NetworkInfo$DetailedState;
.super Ljava/lang/Enum;
.source "NetworkInfo.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/NetworkInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "DetailedState"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Landroid/net/NetworkInfo$DetailedState;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Landroid/net/NetworkInfo$DetailedState;

.field public static final enum AUTHENTICATING:Landroid/net/NetworkInfo$DetailedState;

.field public static final enum BLOCKED:Landroid/net/NetworkInfo$DetailedState;

.field public static final enum CONNECTED:Landroid/net/NetworkInfo$DetailedState;

.field public static final enum CONNECTING:Landroid/net/NetworkInfo$DetailedState;

.field public static final enum DISCONNECTED:Landroid/net/NetworkInfo$DetailedState;

.field public static final enum DISCONNECTING:Landroid/net/NetworkInfo$DetailedState;

.field public static final enum FAILED:Landroid/net/NetworkInfo$DetailedState;

.field public static final enum IDLE:Landroid/net/NetworkInfo$DetailedState;

.field public static final enum OBTAINING_IPADDR:Landroid/net/NetworkInfo$DetailedState;

.field public static final enum SCANNING:Landroid/net/NetworkInfo$DetailedState;

.field public static final enum SUSPENDED:Landroid/net/NetworkInfo$DetailedState;

.field public static final enum VERIFYING_POOR_LINK:Landroid/net/NetworkInfo$DetailedState;


# direct methods
.method static constructor <clinit>()V
    .registers 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 60
    new-instance v0, Landroid/net/NetworkInfo$DetailedState;

    const-string v1, "IDLE"

    invoke-direct {v0, v1, v3}, Landroid/net/NetworkInfo$DetailedState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/net/NetworkInfo$DetailedState;->IDLE:Landroid/net/NetworkInfo$DetailedState;

    .line 62
    new-instance v0, Landroid/net/NetworkInfo$DetailedState;

    const-string v1, "SCANNING"

    invoke-direct {v0, v1, v4}, Landroid/net/NetworkInfo$DetailedState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/net/NetworkInfo$DetailedState;->SCANNING:Landroid/net/NetworkInfo$DetailedState;

    .line 64
    new-instance v0, Landroid/net/NetworkInfo$DetailedState;

    const-string v1, "CONNECTING"

    invoke-direct {v0, v1, v5}, Landroid/net/NetworkInfo$DetailedState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/net/NetworkInfo$DetailedState;->CONNECTING:Landroid/net/NetworkInfo$DetailedState;

    .line 66
    new-instance v0, Landroid/net/NetworkInfo$DetailedState;

    const-string v1, "AUTHENTICATING"

    invoke-direct {v0, v1, v6}, Landroid/net/NetworkInfo$DetailedState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/net/NetworkInfo$DetailedState;->AUTHENTICATING:Landroid/net/NetworkInfo$DetailedState;

    .line 68
    new-instance v0, Landroid/net/NetworkInfo$DetailedState;

    const-string v1, "OBTAINING_IPADDR"

    invoke-direct {v0, v1, v7}, Landroid/net/NetworkInfo$DetailedState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/net/NetworkInfo$DetailedState;->OBTAINING_IPADDR:Landroid/net/NetworkInfo$DetailedState;

    .line 70
    new-instance v0, Landroid/net/NetworkInfo$DetailedState;

    const-string v1, "CONNECTED"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Landroid/net/NetworkInfo$DetailedState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/net/NetworkInfo$DetailedState;->CONNECTED:Landroid/net/NetworkInfo$DetailedState;

    .line 72
    new-instance v0, Landroid/net/NetworkInfo$DetailedState;

    const-string v1, "SUSPENDED"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Landroid/net/NetworkInfo$DetailedState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/net/NetworkInfo$DetailedState;->SUSPENDED:Landroid/net/NetworkInfo$DetailedState;

    .line 74
    new-instance v0, Landroid/net/NetworkInfo$DetailedState;

    const-string v1, "DISCONNECTING"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Landroid/net/NetworkInfo$DetailedState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/net/NetworkInfo$DetailedState;->DISCONNECTING:Landroid/net/NetworkInfo$DetailedState;

    .line 76
    new-instance v0, Landroid/net/NetworkInfo$DetailedState;

    const-string v1, "DISCONNECTED"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Landroid/net/NetworkInfo$DetailedState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/net/NetworkInfo$DetailedState;->DISCONNECTED:Landroid/net/NetworkInfo$DetailedState;

    .line 78
    new-instance v0, Landroid/net/NetworkInfo$DetailedState;

    const-string v1, "FAILED"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Landroid/net/NetworkInfo$DetailedState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/net/NetworkInfo$DetailedState;->FAILED:Landroid/net/NetworkInfo$DetailedState;

    .line 80
    new-instance v0, Landroid/net/NetworkInfo$DetailedState;

    const-string v1, "BLOCKED"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Landroid/net/NetworkInfo$DetailedState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/net/NetworkInfo$DetailedState;->BLOCKED:Landroid/net/NetworkInfo$DetailedState;

    .line 82
    new-instance v0, Landroid/net/NetworkInfo$DetailedState;

    const-string v1, "VERIFYING_POOR_LINK"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Landroid/net/NetworkInfo$DetailedState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/net/NetworkInfo$DetailedState;->VERIFYING_POOR_LINK:Landroid/net/NetworkInfo$DetailedState;

    .line 58
    const/16 v0, 0xc

    new-array v0, v0, [Landroid/net/NetworkInfo$DetailedState;

    sget-object v1, Landroid/net/NetworkInfo$DetailedState;->IDLE:Landroid/net/NetworkInfo$DetailedState;

    aput-object v1, v0, v3

    sget-object v1, Landroid/net/NetworkInfo$DetailedState;->SCANNING:Landroid/net/NetworkInfo$DetailedState;

    aput-object v1, v0, v4

    sget-object v1, Landroid/net/NetworkInfo$DetailedState;->CONNECTING:Landroid/net/NetworkInfo$DetailedState;

    aput-object v1, v0, v5

    sget-object v1, Landroid/net/NetworkInfo$DetailedState;->AUTHENTICATING:Landroid/net/NetworkInfo$DetailedState;

    aput-object v1, v0, v6

    sget-object v1, Landroid/net/NetworkInfo$DetailedState;->OBTAINING_IPADDR:Landroid/net/NetworkInfo$DetailedState;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Landroid/net/NetworkInfo$DetailedState;->CONNECTED:Landroid/net/NetworkInfo$DetailedState;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Landroid/net/NetworkInfo$DetailedState;->SUSPENDED:Landroid/net/NetworkInfo$DetailedState;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Landroid/net/NetworkInfo$DetailedState;->DISCONNECTING:Landroid/net/NetworkInfo$DetailedState;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Landroid/net/NetworkInfo$DetailedState;->DISCONNECTED:Landroid/net/NetworkInfo$DetailedState;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Landroid/net/NetworkInfo$DetailedState;->FAILED:Landroid/net/NetworkInfo$DetailedState;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Landroid/net/NetworkInfo$DetailedState;->BLOCKED:Landroid/net/NetworkInfo$DetailedState;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Landroid/net/NetworkInfo$DetailedState;->VERIFYING_POOR_LINK:Landroid/net/NetworkInfo$DetailedState;

    aput-object v2, v0, v1

    sput-object v0, Landroid/net/NetworkInfo$DetailedState;->$VALUES:[Landroid/net/NetworkInfo$DetailedState;

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

.method public static valueOf(Ljava/lang/String;)Landroid/net/NetworkInfo$DetailedState;
    .registers 2
    .parameter "name"

    .prologue
    .line 58
    const-class v0, Landroid/net/NetworkInfo$DetailedState;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Landroid/net/NetworkInfo$DetailedState;

    return-object v0
.end method

.method public static values()[Landroid/net/NetworkInfo$DetailedState;
    .registers 1

    .prologue
    .line 58
    sget-object v0, Landroid/net/NetworkInfo$DetailedState;->$VALUES:[Landroid/net/NetworkInfo$DetailedState;

    invoke-virtual {v0}, [Landroid/net/NetworkInfo$DetailedState;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/net/NetworkInfo$DetailedState;

    return-object v0
.end method
