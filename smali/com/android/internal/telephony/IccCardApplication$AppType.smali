.class public final enum Lcom/android/internal/telephony/IccCardApplication$AppType;
.super Ljava/lang/Enum;
.source "IccCardApplication.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/telephony/IccCardApplication;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "AppType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/android/internal/telephony/IccCardApplication$AppType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/android/internal/telephony/IccCardApplication$AppType;

.field public static final enum APPTYPE_CSIM:Lcom/android/internal/telephony/IccCardApplication$AppType;

.field public static final enum APPTYPE_ISIM:Lcom/android/internal/telephony/IccCardApplication$AppType;

.field public static final enum APPTYPE_RUIM:Lcom/android/internal/telephony/IccCardApplication$AppType;

.field public static final enum APPTYPE_SIM:Lcom/android/internal/telephony/IccCardApplication$AppType;

.field public static final enum APPTYPE_UNKNOWN:Lcom/android/internal/telephony/IccCardApplication$AppType;

.field public static final enum APPTYPE_USIM:Lcom/android/internal/telephony/IccCardApplication$AppType;


# direct methods
.method static constructor <clinit>()V
    .registers 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 29
    new-instance v0, Lcom/android/internal/telephony/IccCardApplication$AppType;

    const-string v1, "APPTYPE_UNKNOWN"

    invoke-direct {v0, v1, v3}, Lcom/android/internal/telephony/IccCardApplication$AppType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/internal/telephony/IccCardApplication$AppType;->APPTYPE_UNKNOWN:Lcom/android/internal/telephony/IccCardApplication$AppType;

    .line 30
    new-instance v0, Lcom/android/internal/telephony/IccCardApplication$AppType;

    const-string v1, "APPTYPE_SIM"

    invoke-direct {v0, v1, v4}, Lcom/android/internal/telephony/IccCardApplication$AppType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/internal/telephony/IccCardApplication$AppType;->APPTYPE_SIM:Lcom/android/internal/telephony/IccCardApplication$AppType;

    .line 31
    new-instance v0, Lcom/android/internal/telephony/IccCardApplication$AppType;

    const-string v1, "APPTYPE_USIM"

    invoke-direct {v0, v1, v5}, Lcom/android/internal/telephony/IccCardApplication$AppType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/internal/telephony/IccCardApplication$AppType;->APPTYPE_USIM:Lcom/android/internal/telephony/IccCardApplication$AppType;

    .line 32
    new-instance v0, Lcom/android/internal/telephony/IccCardApplication$AppType;

    const-string v1, "APPTYPE_RUIM"

    invoke-direct {v0, v1, v6}, Lcom/android/internal/telephony/IccCardApplication$AppType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/internal/telephony/IccCardApplication$AppType;->APPTYPE_RUIM:Lcom/android/internal/telephony/IccCardApplication$AppType;

    .line 33
    new-instance v0, Lcom/android/internal/telephony/IccCardApplication$AppType;

    const-string v1, "APPTYPE_CSIM"

    invoke-direct {v0, v1, v7}, Lcom/android/internal/telephony/IccCardApplication$AppType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/internal/telephony/IccCardApplication$AppType;->APPTYPE_CSIM:Lcom/android/internal/telephony/IccCardApplication$AppType;

    .line 34
    new-instance v0, Lcom/android/internal/telephony/IccCardApplication$AppType;

    const-string v1, "APPTYPE_ISIM"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/android/internal/telephony/IccCardApplication$AppType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/internal/telephony/IccCardApplication$AppType;->APPTYPE_ISIM:Lcom/android/internal/telephony/IccCardApplication$AppType;

    .line 28
    const/4 v0, 0x6

    new-array v0, v0, [Lcom/android/internal/telephony/IccCardApplication$AppType;

    sget-object v1, Lcom/android/internal/telephony/IccCardApplication$AppType;->APPTYPE_UNKNOWN:Lcom/android/internal/telephony/IccCardApplication$AppType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/android/internal/telephony/IccCardApplication$AppType;->APPTYPE_SIM:Lcom/android/internal/telephony/IccCardApplication$AppType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/android/internal/telephony/IccCardApplication$AppType;->APPTYPE_USIM:Lcom/android/internal/telephony/IccCardApplication$AppType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/android/internal/telephony/IccCardApplication$AppType;->APPTYPE_RUIM:Lcom/android/internal/telephony/IccCardApplication$AppType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/android/internal/telephony/IccCardApplication$AppType;->APPTYPE_CSIM:Lcom/android/internal/telephony/IccCardApplication$AppType;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/android/internal/telephony/IccCardApplication$AppType;->APPTYPE_ISIM:Lcom/android/internal/telephony/IccCardApplication$AppType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/android/internal/telephony/IccCardApplication$AppType;->$VALUES:[Lcom/android/internal/telephony/IccCardApplication$AppType;

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
    .line 28
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/android/internal/telephony/IccCardApplication$AppType;
    .registers 2
    .parameter "name"

    .prologue
    .line 28
    const-class v0, Lcom/android/internal/telephony/IccCardApplication$AppType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/android/internal/telephony/IccCardApplication$AppType;

    return-object v0
.end method

.method public static values()[Lcom/android/internal/telephony/IccCardApplication$AppType;
    .registers 1

    .prologue
    .line 28
    sget-object v0, Lcom/android/internal/telephony/IccCardApplication$AppType;->$VALUES:[Lcom/android/internal/telephony/IccCardApplication$AppType;

    invoke-virtual {v0}, [Lcom/android/internal/telephony/IccCardApplication$AppType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/android/internal/telephony/IccCardApplication$AppType;

    return-object v0
.end method
