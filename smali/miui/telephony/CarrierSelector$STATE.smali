.class public final enum Lmiui/telephony/CarrierSelector$STATE;
.super Ljava/lang/Enum;
.source "CarrierSelector.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/telephony/CarrierSelector;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "STATE"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lmiui/telephony/CarrierSelector$STATE;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lmiui/telephony/CarrierSelector$STATE;

.field public static final enum TAIWAN:Lmiui/telephony/CarrierSelector$STATE;


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .prologue
    const/4 v2, 0x0

    new-instance v0, Lmiui/telephony/CarrierSelector$STATE;

    const-string v1, "TAIWAN"

    invoke-direct {v0, v1, v2}, Lmiui/telephony/CarrierSelector$STATE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lmiui/telephony/CarrierSelector$STATE;->TAIWAN:Lmiui/telephony/CarrierSelector$STATE;

    const/4 v0, 0x1

    new-array v0, v0, [Lmiui/telephony/CarrierSelector$STATE;

    sget-object v1, Lmiui/telephony/CarrierSelector$STATE;->TAIWAN:Lmiui/telephony/CarrierSelector$STATE;

    aput-object v1, v0, v2

    sput-object v0, Lmiui/telephony/CarrierSelector$STATE;->$VALUES:[Lmiui/telephony/CarrierSelector$STATE;

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

.method public static valueOf(Ljava/lang/String;)Lmiui/telephony/CarrierSelector$STATE;
    .registers 2
    .parameter "name"

    .prologue
    const-class v0, Lmiui/telephony/CarrierSelector$STATE;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lmiui/telephony/CarrierSelector$STATE;

    return-object v0
.end method

.method public static values()[Lmiui/telephony/CarrierSelector$STATE;
    .registers 1

    .prologue
    sget-object v0, Lmiui/telephony/CarrierSelector$STATE;->$VALUES:[Lmiui/telephony/CarrierSelector$STATE;

    invoke-virtual {v0}, [Lmiui/telephony/CarrierSelector$STATE;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lmiui/telephony/CarrierSelector$STATE;

    return-object v0
.end method
