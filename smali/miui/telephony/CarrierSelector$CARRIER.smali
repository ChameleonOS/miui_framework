.class public final enum Lmiui/telephony/CarrierSelector$CARRIER;
.super Ljava/lang/Enum;
.source "CarrierSelector.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/telephony/CarrierSelector;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "CARRIER"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lmiui/telephony/CarrierSelector$CARRIER;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lmiui/telephony/CarrierSelector$CARRIER;

.field public static final enum CHINA_MOBILE:Lmiui/telephony/CarrierSelector$CARRIER;

.field public static final enum CHINA_TELECOM:Lmiui/telephony/CarrierSelector$CARRIER;

.field public static final enum CHINA_UNICOM:Lmiui/telephony/CarrierSelector$CARRIER;

.field public static final enum DEFAULT:Lmiui/telephony/CarrierSelector$CARRIER;


# direct methods
.method static constructor <clinit>()V
    .registers 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 37
    new-instance v0, Lmiui/telephony/CarrierSelector$CARRIER;

    const-string v1, "CHINA_MOBILE"

    invoke-direct {v0, v1, v2}, Lmiui/telephony/CarrierSelector$CARRIER;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lmiui/telephony/CarrierSelector$CARRIER;->CHINA_MOBILE:Lmiui/telephony/CarrierSelector$CARRIER;

    .line 38
    new-instance v0, Lmiui/telephony/CarrierSelector$CARRIER;

    const-string v1, "CHINA_UNICOM"

    invoke-direct {v0, v1, v3}, Lmiui/telephony/CarrierSelector$CARRIER;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lmiui/telephony/CarrierSelector$CARRIER;->CHINA_UNICOM:Lmiui/telephony/CarrierSelector$CARRIER;

    .line 39
    new-instance v0, Lmiui/telephony/CarrierSelector$CARRIER;

    const-string v1, "CHINA_TELECOM"

    invoke-direct {v0, v1, v4}, Lmiui/telephony/CarrierSelector$CARRIER;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lmiui/telephony/CarrierSelector$CARRIER;->CHINA_TELECOM:Lmiui/telephony/CarrierSelector$CARRIER;

    .line 40
    new-instance v0, Lmiui/telephony/CarrierSelector$CARRIER;

    const-string v1, "DEFAULT"

    invoke-direct {v0, v1, v5}, Lmiui/telephony/CarrierSelector$CARRIER;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lmiui/telephony/CarrierSelector$CARRIER;->DEFAULT:Lmiui/telephony/CarrierSelector$CARRIER;

    .line 36
    const/4 v0, 0x4

    new-array v0, v0, [Lmiui/telephony/CarrierSelector$CARRIER;

    sget-object v1, Lmiui/telephony/CarrierSelector$CARRIER;->CHINA_MOBILE:Lmiui/telephony/CarrierSelector$CARRIER;

    aput-object v1, v0, v2

    sget-object v1, Lmiui/telephony/CarrierSelector$CARRIER;->CHINA_UNICOM:Lmiui/telephony/CarrierSelector$CARRIER;

    aput-object v1, v0, v3

    sget-object v1, Lmiui/telephony/CarrierSelector$CARRIER;->CHINA_TELECOM:Lmiui/telephony/CarrierSelector$CARRIER;

    aput-object v1, v0, v4

    sget-object v1, Lmiui/telephony/CarrierSelector$CARRIER;->DEFAULT:Lmiui/telephony/CarrierSelector$CARRIER;

    aput-object v1, v0, v5

    sput-object v0, Lmiui/telephony/CarrierSelector$CARRIER;->$VALUES:[Lmiui/telephony/CarrierSelector$CARRIER;

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
    .line 36
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lmiui/telephony/CarrierSelector$CARRIER;
    .registers 2
    .parameter "name"

    .prologue
    .line 36
    const-class v0, Lmiui/telephony/CarrierSelector$CARRIER;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lmiui/telephony/CarrierSelector$CARRIER;

    return-object v0
.end method

.method public static values()[Lmiui/telephony/CarrierSelector$CARRIER;
    .registers 1

    .prologue
    .line 36
    sget-object v0, Lmiui/telephony/CarrierSelector$CARRIER;->$VALUES:[Lmiui/telephony/CarrierSelector$CARRIER;

    invoke-virtual {v0}, [Lmiui/telephony/CarrierSelector$CARRIER;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lmiui/telephony/CarrierSelector$CARRIER;

    return-object v0
.end method
