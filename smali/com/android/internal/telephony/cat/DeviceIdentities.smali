.class Lcom/android/internal/telephony/cat/DeviceIdentities;
.super Lcom/android/internal/telephony/cat/ValueObject;
.source "CommandDetails.java"


# instance fields
.field public destinationId:I

.field public sourceId:I


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    invoke-direct {p0}, Lcom/android/internal/telephony/cat/ValueObject;-><init>()V

    return-void
.end method


# virtual methods
.method getTag()Lcom/android/internal/telephony/cat/ComprehensionTlvTag;
    .registers 2

    .prologue
    sget-object v0, Lcom/android/internal/telephony/cat/ComprehensionTlvTag;->DEVICE_IDENTITIES:Lcom/android/internal/telephony/cat/ComprehensionTlvTag;

    return-object v0
.end method
