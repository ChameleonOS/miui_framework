.class public final enum Lcom/android/internal/telephony/IccCardStatus$PinState;
.super Ljava/lang/Enum;
.source "IccCardStatus.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/telephony/IccCardStatus;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "PinState"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/android/internal/telephony/IccCardStatus$PinState;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/android/internal/telephony/IccCardStatus$PinState;

.field public static final enum PINSTATE_DISABLED:Lcom/android/internal/telephony/IccCardStatus$PinState;

.field public static final enum PINSTATE_ENABLED_BLOCKED:Lcom/android/internal/telephony/IccCardStatus$PinState;

.field public static final enum PINSTATE_ENABLED_NOT_VERIFIED:Lcom/android/internal/telephony/IccCardStatus$PinState;

.field public static final enum PINSTATE_ENABLED_PERM_BLOCKED:Lcom/android/internal/telephony/IccCardStatus$PinState;

.field public static final enum PINSTATE_ENABLED_VERIFIED:Lcom/android/internal/telephony/IccCardStatus$PinState;

.field public static final enum PINSTATE_UNKNOWN:Lcom/android/internal/telephony/IccCardStatus$PinState;


# direct methods
.method static constructor <clinit>()V
    .registers 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 40
    new-instance v0, Lcom/android/internal/telephony/IccCardStatus$PinState;

    const-string v1, "PINSTATE_UNKNOWN"

    invoke-direct {v0, v1, v3}, Lcom/android/internal/telephony/IccCardStatus$PinState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/internal/telephony/IccCardStatus$PinState;->PINSTATE_UNKNOWN:Lcom/android/internal/telephony/IccCardStatus$PinState;

    .line 41
    new-instance v0, Lcom/android/internal/telephony/IccCardStatus$PinState;

    const-string v1, "PINSTATE_ENABLED_NOT_VERIFIED"

    invoke-direct {v0, v1, v4}, Lcom/android/internal/telephony/IccCardStatus$PinState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/internal/telephony/IccCardStatus$PinState;->PINSTATE_ENABLED_NOT_VERIFIED:Lcom/android/internal/telephony/IccCardStatus$PinState;

    .line 42
    new-instance v0, Lcom/android/internal/telephony/IccCardStatus$PinState;

    const-string v1, "PINSTATE_ENABLED_VERIFIED"

    invoke-direct {v0, v1, v5}, Lcom/android/internal/telephony/IccCardStatus$PinState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/internal/telephony/IccCardStatus$PinState;->PINSTATE_ENABLED_VERIFIED:Lcom/android/internal/telephony/IccCardStatus$PinState;

    .line 43
    new-instance v0, Lcom/android/internal/telephony/IccCardStatus$PinState;

    const-string v1, "PINSTATE_DISABLED"

    invoke-direct {v0, v1, v6}, Lcom/android/internal/telephony/IccCardStatus$PinState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/internal/telephony/IccCardStatus$PinState;->PINSTATE_DISABLED:Lcom/android/internal/telephony/IccCardStatus$PinState;

    .line 44
    new-instance v0, Lcom/android/internal/telephony/IccCardStatus$PinState;

    const-string v1, "PINSTATE_ENABLED_BLOCKED"

    invoke-direct {v0, v1, v7}, Lcom/android/internal/telephony/IccCardStatus$PinState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/internal/telephony/IccCardStatus$PinState;->PINSTATE_ENABLED_BLOCKED:Lcom/android/internal/telephony/IccCardStatus$PinState;

    .line 45
    new-instance v0, Lcom/android/internal/telephony/IccCardStatus$PinState;

    const-string v1, "PINSTATE_ENABLED_PERM_BLOCKED"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/android/internal/telephony/IccCardStatus$PinState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/internal/telephony/IccCardStatus$PinState;->PINSTATE_ENABLED_PERM_BLOCKED:Lcom/android/internal/telephony/IccCardStatus$PinState;

    .line 39
    const/4 v0, 0x6

    new-array v0, v0, [Lcom/android/internal/telephony/IccCardStatus$PinState;

    sget-object v1, Lcom/android/internal/telephony/IccCardStatus$PinState;->PINSTATE_UNKNOWN:Lcom/android/internal/telephony/IccCardStatus$PinState;

    aput-object v1, v0, v3

    sget-object v1, Lcom/android/internal/telephony/IccCardStatus$PinState;->PINSTATE_ENABLED_NOT_VERIFIED:Lcom/android/internal/telephony/IccCardStatus$PinState;

    aput-object v1, v0, v4

    sget-object v1, Lcom/android/internal/telephony/IccCardStatus$PinState;->PINSTATE_ENABLED_VERIFIED:Lcom/android/internal/telephony/IccCardStatus$PinState;

    aput-object v1, v0, v5

    sget-object v1, Lcom/android/internal/telephony/IccCardStatus$PinState;->PINSTATE_DISABLED:Lcom/android/internal/telephony/IccCardStatus$PinState;

    aput-object v1, v0, v6

    sget-object v1, Lcom/android/internal/telephony/IccCardStatus$PinState;->PINSTATE_ENABLED_BLOCKED:Lcom/android/internal/telephony/IccCardStatus$PinState;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/android/internal/telephony/IccCardStatus$PinState;->PINSTATE_ENABLED_PERM_BLOCKED:Lcom/android/internal/telephony/IccCardStatus$PinState;

    aput-object v2, v0, v1

    sput-object v0, Lcom/android/internal/telephony/IccCardStatus$PinState;->$VALUES:[Lcom/android/internal/telephony/IccCardStatus$PinState;

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
    .line 39
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/android/internal/telephony/IccCardStatus$PinState;
    .registers 2
    .parameter "name"

    .prologue
    .line 39
    const-class v0, Lcom/android/internal/telephony/IccCardStatus$PinState;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/android/internal/telephony/IccCardStatus$PinState;

    return-object v0
.end method

.method public static values()[Lcom/android/internal/telephony/IccCardStatus$PinState;
    .registers 1

    .prologue
    .line 39
    sget-object v0, Lcom/android/internal/telephony/IccCardStatus$PinState;->$VALUES:[Lcom/android/internal/telephony/IccCardStatus$PinState;

    invoke-virtual {v0}, [Lcom/android/internal/telephony/IccCardStatus$PinState;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/android/internal/telephony/IccCardStatus$PinState;

    return-object v0
.end method


# virtual methods
.method isPermBlocked()Z
    .registers 2

    .prologue
    .line 48
    sget-object v0, Lcom/android/internal/telephony/IccCardStatus$PinState;->PINSTATE_ENABLED_PERM_BLOCKED:Lcom/android/internal/telephony/IccCardStatus$PinState;

    if-ne p0, v0, :cond_6

    const/4 v0, 0x1

    :goto_5
    return v0

    :cond_6
    const/4 v0, 0x0

    goto :goto_5
.end method

.method isPinRequired()Z
    .registers 2

    .prologue
    .line 52
    sget-object v0, Lcom/android/internal/telephony/IccCardStatus$PinState;->PINSTATE_ENABLED_NOT_VERIFIED:Lcom/android/internal/telephony/IccCardStatus$PinState;

    if-ne p0, v0, :cond_6

    const/4 v0, 0x1

    :goto_5
    return v0

    :cond_6
    const/4 v0, 0x0

    goto :goto_5
.end method

.method isPukRequired()Z
    .registers 2

    .prologue
    .line 56
    sget-object v0, Lcom/android/internal/telephony/IccCardStatus$PinState;->PINSTATE_ENABLED_BLOCKED:Lcom/android/internal/telephony/IccCardStatus$PinState;

    if-ne p0, v0, :cond_6

    const/4 v0, 0x1

    :goto_5
    return v0

    :cond_6
    const/4 v0, 0x0

    goto :goto_5
.end method
