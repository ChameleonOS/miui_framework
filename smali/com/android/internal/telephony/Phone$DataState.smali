.class public final enum Lcom/android/internal/telephony/Phone$DataState;
.super Ljava/lang/Enum;
.source "Phone.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/telephony/Phone;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "DataState"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/android/internal/telephony/Phone$DataState;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/android/internal/telephony/Phone$DataState;

.field public static final enum CONNECTED:Lcom/android/internal/telephony/Phone$DataState;

.field public static final enum CONNECTING:Lcom/android/internal/telephony/Phone$DataState;

.field public static final enum DISCONNECTED:Lcom/android/internal/telephony/Phone$DataState;

.field public static final enum SUSPENDED:Lcom/android/internal/telephony/Phone$DataState;


# direct methods
.method static constructor <clinit>()V
    .registers 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 77
    new-instance v0, Lcom/android/internal/telephony/Phone$DataState;

    const-string v1, "CONNECTED"

    invoke-direct {v0, v1, v2}, Lcom/android/internal/telephony/Phone$DataState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/internal/telephony/Phone$DataState;->CONNECTED:Lcom/android/internal/telephony/Phone$DataState;

    new-instance v0, Lcom/android/internal/telephony/Phone$DataState;

    const-string v1, "CONNECTING"

    invoke-direct {v0, v1, v3}, Lcom/android/internal/telephony/Phone$DataState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/internal/telephony/Phone$DataState;->CONNECTING:Lcom/android/internal/telephony/Phone$DataState;

    new-instance v0, Lcom/android/internal/telephony/Phone$DataState;

    const-string v1, "DISCONNECTED"

    invoke-direct {v0, v1, v4}, Lcom/android/internal/telephony/Phone$DataState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/internal/telephony/Phone$DataState;->DISCONNECTED:Lcom/android/internal/telephony/Phone$DataState;

    new-instance v0, Lcom/android/internal/telephony/Phone$DataState;

    const-string v1, "SUSPENDED"

    invoke-direct {v0, v1, v5}, Lcom/android/internal/telephony/Phone$DataState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/internal/telephony/Phone$DataState;->SUSPENDED:Lcom/android/internal/telephony/Phone$DataState;

    .line 76
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/android/internal/telephony/Phone$DataState;

    sget-object v1, Lcom/android/internal/telephony/Phone$DataState;->CONNECTED:Lcom/android/internal/telephony/Phone$DataState;

    aput-object v1, v0, v2

    sget-object v1, Lcom/android/internal/telephony/Phone$DataState;->CONNECTING:Lcom/android/internal/telephony/Phone$DataState;

    aput-object v1, v0, v3

    sget-object v1, Lcom/android/internal/telephony/Phone$DataState;->DISCONNECTED:Lcom/android/internal/telephony/Phone$DataState;

    aput-object v1, v0, v4

    sget-object v1, Lcom/android/internal/telephony/Phone$DataState;->SUSPENDED:Lcom/android/internal/telephony/Phone$DataState;

    aput-object v1, v0, v5

    sput-object v0, Lcom/android/internal/telephony/Phone$DataState;->$VALUES:[Lcom/android/internal/telephony/Phone$DataState;

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
    .line 76
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/android/internal/telephony/Phone$DataState;
    .registers 2
    .parameter "name"

    .prologue
    .line 76
    const-class v0, Lcom/android/internal/telephony/Phone$DataState;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/android/internal/telephony/Phone$DataState;

    return-object v0
.end method

.method public static values()[Lcom/android/internal/telephony/Phone$DataState;
    .registers 1

    .prologue
    .line 76
    sget-object v0, Lcom/android/internal/telephony/Phone$DataState;->$VALUES:[Lcom/android/internal/telephony/Phone$DataState;

    invoke-virtual {v0}, [Lcom/android/internal/telephony/Phone$DataState;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/android/internal/telephony/Phone$DataState;

    return-object v0
.end method
