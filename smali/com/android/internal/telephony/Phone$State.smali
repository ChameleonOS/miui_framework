.class public final enum Lcom/android/internal/telephony/Phone$State;
.super Ljava/lang/Enum;
.source "Phone.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/telephony/Phone;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "State"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/android/internal/telephony/Phone$State;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/android/internal/telephony/Phone$State;

.field public static final enum IDLE:Lcom/android/internal/telephony/Phone$State;

.field public static final enum OFFHOOK:Lcom/android/internal/telephony/Phone$State;

.field public static final enum RINGING:Lcom/android/internal/telephony/Phone$State;


# direct methods
.method static constructor <clinit>()V
    .registers 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 62
    new-instance v0, Lcom/android/internal/telephony/Phone$State;

    const-string v1, "IDLE"

    invoke-direct {v0, v1, v2}, Lcom/android/internal/telephony/Phone$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/internal/telephony/Phone$State;->IDLE:Lcom/android/internal/telephony/Phone$State;

    new-instance v0, Lcom/android/internal/telephony/Phone$State;

    const-string v1, "RINGING"

    invoke-direct {v0, v1, v3}, Lcom/android/internal/telephony/Phone$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/internal/telephony/Phone$State;->RINGING:Lcom/android/internal/telephony/Phone$State;

    new-instance v0, Lcom/android/internal/telephony/Phone$State;

    const-string v1, "OFFHOOK"

    invoke-direct {v0, v1, v4}, Lcom/android/internal/telephony/Phone$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/internal/telephony/Phone$State;->OFFHOOK:Lcom/android/internal/telephony/Phone$State;

    .line 61
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/android/internal/telephony/Phone$State;

    sget-object v1, Lcom/android/internal/telephony/Phone$State;->IDLE:Lcom/android/internal/telephony/Phone$State;

    aput-object v1, v0, v2

    sget-object v1, Lcom/android/internal/telephony/Phone$State;->RINGING:Lcom/android/internal/telephony/Phone$State;

    aput-object v1, v0, v3

    sget-object v1, Lcom/android/internal/telephony/Phone$State;->OFFHOOK:Lcom/android/internal/telephony/Phone$State;

    aput-object v1, v0, v4

    sput-object v0, Lcom/android/internal/telephony/Phone$State;->$VALUES:[Lcom/android/internal/telephony/Phone$State;

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
    .line 61
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/android/internal/telephony/Phone$State;
    .registers 2
    .parameter "name"

    .prologue
    .line 61
    const-class v0, Lcom/android/internal/telephony/Phone$State;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/android/internal/telephony/Phone$State;

    return-object v0
.end method

.method public static values()[Lcom/android/internal/telephony/Phone$State;
    .registers 1

    .prologue
    .line 61
    sget-object v0, Lcom/android/internal/telephony/Phone$State;->$VALUES:[Lcom/android/internal/telephony/Phone$State;

    invoke-virtual {v0}, [Lcom/android/internal/telephony/Phone$State;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/android/internal/telephony/Phone$State;

    return-object v0
.end method
