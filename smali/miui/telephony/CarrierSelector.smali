.class public final Lmiui/telephony/CarrierSelector;
.super Ljava/lang/Object;
.source "CarrierSelector.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmiui/telephony/CarrierSelector$CARRIER;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private final mCarrierMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lmiui/telephony/CarrierSelector$CARRIER;",
            "TT;>;"
        }
    .end annotation
.end field

.field private mDefaultCarrier:Lmiui/telephony/CarrierSelector$CARRIER;


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 20
    .local p0, this:Lmiui/telephony/CarrierSelector;,"Lmiui/telephony/CarrierSelector<TT;>;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 12
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lmiui/telephony/CarrierSelector;->mCarrierMap:Ljava/util/Map;

    .line 21
    return-void
.end method

.method public constructor <init>(Lmiui/telephony/CarrierSelector$CARRIER;)V
    .registers 3
    .parameter "defaultCarrier"

    .prologue
    .line 23
    .local p0, this:Lmiui/telephony/CarrierSelector;,"Lmiui/telephony/CarrierSelector<TT;>;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 12
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lmiui/telephony/CarrierSelector;->mCarrierMap:Ljava/util/Map;

    .line 24
    iput-object p1, p0, Lmiui/telephony/CarrierSelector;->mDefaultCarrier:Lmiui/telephony/CarrierSelector$CARRIER;

    .line 25
    return-void
.end method

.method private internalSelectCarrier(Ljava/lang/String;Lmiui/telephony/CarrierSelector$CARRIER;)Lmiui/telephony/CarrierSelector$CARRIER;
    .registers 7
    .parameter "mccMnc"
    .parameter "defaultCarrier"

    .prologue
    .line 78
    .local p0, this:Lmiui/telephony/CarrierSelector;,"Lmiui/telephony/CarrierSelector<TT;>;"
    move-object v0, p2

    .line 79
    .local v0, carrier:Lmiui/telephony/CarrierSelector$CARRIER;
    invoke-static {}, Lcom/android/internal/telephony/gsm/MiuiSpnOverride;->getInstance()Lcom/android/internal/telephony/gsm/MiuiSpnOverride;

    move-result-object v2

    .line 80
    .local v2, spn:Lcom/android/internal/telephony/gsm/MiuiSpnOverride;
    invoke-virtual {v2, p1}, Lcom/android/internal/telephony/gsm/MiuiSpnOverride;->getEquivalentOperatorNumeric(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 81
    .local v1, eqOperator:Ljava/lang/String;
    const-string v3, "46000"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_14

    .line 82
    sget-object v0, Lmiui/telephony/CarrierSelector$CARRIER;->CHINA_MOBILE:Lmiui/telephony/CarrierSelector$CARRIER;

    .line 88
    :cond_13
    :goto_13
    return-object v0

    .line 83
    :cond_14
    const-string v3, "46001"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1f

    .line 84
    sget-object v0, Lmiui/telephony/CarrierSelector$CARRIER;->CHINA_UNICOM:Lmiui/telephony/CarrierSelector$CARRIER;

    goto :goto_13

    .line 85
    :cond_1f
    const-string v3, "46003"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_13

    .line 86
    sget-object v0, Lmiui/telephony/CarrierSelector$CARRIER;->CHINA_TELECOM:Lmiui/telephony/CarrierSelector$CARRIER;

    goto :goto_13
.end method


# virtual methods
.method public register(Lmiui/telephony/CarrierSelector$CARRIER;Ljava/lang/Object;)V
    .registers 5
    .parameter "carrier"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lmiui/telephony/CarrierSelector$CARRIER;",
            "TT;)V"
        }
    .end annotation

    .prologue
    .line 28
    .local p0, this:Lmiui/telephony/CarrierSelector;,"Lmiui/telephony/CarrierSelector<TT;>;"
    .local p2, value:Ljava/lang/Object;,"TT;"
    if-nez p1, :cond_a

    .line 29
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "carrier not nullable"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 31
    :cond_a
    iget-object v0, p0, Lmiui/telephony/CarrierSelector;->mCarrierMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 32
    return-void
.end method

.method public selectCarrier(Ljava/lang/String;)Lmiui/telephony/CarrierSelector$CARRIER;
    .registers 3
    .parameter "mccMnc"

    .prologue
    .line 42
    .local p0, this:Lmiui/telephony/CarrierSelector;,"Lmiui/telephony/CarrierSelector<TT;>;"
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lmiui/telephony/CarrierSelector;->internalSelectCarrier(Ljava/lang/String;Lmiui/telephony/CarrierSelector$CARRIER;)Lmiui/telephony/CarrierSelector$CARRIER;

    move-result-object v0

    return-object v0
.end method

.method public selectValue(Ljava/lang/String;)Ljava/lang/Object;
    .registers 4
    .parameter "mccMnc"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")TT;"
        }
    .end annotation

    .prologue
    .line 55
    .local p0, this:Lmiui/telephony/CarrierSelector;,"Lmiui/telephony/CarrierSelector<TT;>;"
    iget-object v1, p0, Lmiui/telephony/CarrierSelector;->mDefaultCarrier:Lmiui/telephony/CarrierSelector$CARRIER;

    invoke-direct {p0, p1, v1}, Lmiui/telephony/CarrierSelector;->internalSelectCarrier(Ljava/lang/String;Lmiui/telephony/CarrierSelector$CARRIER;)Lmiui/telephony/CarrierSelector$CARRIER;

    move-result-object v0

    .line 56
    .local v0, carrier:Lmiui/telephony/CarrierSelector$CARRIER;
    iget-object v1, p0, Lmiui/telephony/CarrierSelector;->mCarrierMap:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    return-object v1
.end method

.method public selectValue(Ljava/lang/String;Z)Ljava/lang/Object;
    .registers 5
    .parameter "mccMnc"
    .parameter "useDefault"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Z)TT;"
        }
    .end annotation

    .prologue
    .line 71
    .local p0, this:Lmiui/telephony/CarrierSelector;,"Lmiui/telephony/CarrierSelector<TT;>;"
    if-eqz p2, :cond_f

    iget-object v1, p0, Lmiui/telephony/CarrierSelector;->mDefaultCarrier:Lmiui/telephony/CarrierSelector$CARRIER;

    :goto_4
    invoke-direct {p0, p1, v1}, Lmiui/telephony/CarrierSelector;->internalSelectCarrier(Ljava/lang/String;Lmiui/telephony/CarrierSelector$CARRIER;)Lmiui/telephony/CarrierSelector$CARRIER;

    move-result-object v0

    .line 73
    .local v0, carrier:Lmiui/telephony/CarrierSelector$CARRIER;
    iget-object v1, p0, Lmiui/telephony/CarrierSelector;->mCarrierMap:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    return-object v1

    .line 71
    .end local v0           #carrier:Lmiui/telephony/CarrierSelector$CARRIER;
    :cond_f
    const/4 v1, 0x0

    goto :goto_4
.end method
