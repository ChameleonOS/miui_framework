.class public final Lmiui/telephony/CarrierSelector;
.super Ljava/lang/Object;
.source "CarrierSelector.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmiui/telephony/CarrierSelector$STATE;,
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


# static fields
.field private static final mCarrier2MccMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lmiui/telephony/CarrierSelector$CARRIER;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final mMccHandled:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final mState2MccMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lmiui/telephony/CarrierSelector$STATE;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


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

.field private final mStateMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lmiui/telephony/CarrierSelector$STATE;",
            "TT;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .prologue
    .line 20
    invoke-static {}, Lcom/google/android/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    sput-object v0, Lmiui/telephony/CarrierSelector;->mCarrier2MccMap:Ljava/util/Map;

    .line 23
    invoke-static {}, Lcom/google/android/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    sput-object v0, Lmiui/telephony/CarrierSelector;->mState2MccMap:Ljava/util/Map;

    .line 25
    invoke-static {}, Lcom/google/android/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v0

    sput-object v0, Lmiui/telephony/CarrierSelector;->mMccHandled:Ljava/util/Set;

    .line 28
    sget-object v0, Lmiui/telephony/CarrierSelector;->mCarrier2MccMap:Ljava/util/Map;

    sget-object v1, Lmiui/telephony/CarrierSelector$CARRIER;->DEFAULT:Lmiui/telephony/CarrierSelector$CARRIER;

    const-string v2, "000"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 29
    sget-object v0, Lmiui/telephony/CarrierSelector;->mCarrier2MccMap:Ljava/util/Map;

    sget-object v1, Lmiui/telephony/CarrierSelector$CARRIER;->CHINA_MOBILE:Lmiui/telephony/CarrierSelector$CARRIER;

    const-string v2, "460"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 30
    sget-object v0, Lmiui/telephony/CarrierSelector;->mCarrier2MccMap:Ljava/util/Map;

    sget-object v1, Lmiui/telephony/CarrierSelector$CARRIER;->CHINA_UNICOM:Lmiui/telephony/CarrierSelector$CARRIER;

    const-string v2, "460"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 31
    sget-object v0, Lmiui/telephony/CarrierSelector;->mCarrier2MccMap:Ljava/util/Map;

    sget-object v1, Lmiui/telephony/CarrierSelector$CARRIER;->CHINA_TELECOM:Lmiui/telephony/CarrierSelector$CARRIER;

    const-string v2, "460"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 33
    sget-object v0, Lmiui/telephony/CarrierSelector;->mState2MccMap:Ljava/util/Map;

    sget-object v1, Lmiui/telephony/CarrierSelector$STATE;->TAIWAN:Lmiui/telephony/CarrierSelector$STATE;

    const-string v2, "466"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 34
    return-void
.end method

.method public constructor <init>()V
    .registers 2

    .prologue
    .line 47
    .local p0, this:Lmiui/telephony/CarrierSelector;,"Lmiui/telephony/CarrierSelector<TT;>;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 14
    sget-object v0, Lmiui/telephony/CarrierSelector$CARRIER;->DEFAULT:Lmiui/telephony/CarrierSelector$CARRIER;

    iput-object v0, p0, Lmiui/telephony/CarrierSelector;->mDefaultCarrier:Lmiui/telephony/CarrierSelector$CARRIER;

    .line 16
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lmiui/telephony/CarrierSelector;->mCarrierMap:Ljava/util/Map;

    .line 18
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lmiui/telephony/CarrierSelector;->mStateMap:Ljava/util/Map;

    .line 48
    return-void
.end method

.method public constructor <init>(Lmiui/telephony/CarrierSelector$CARRIER;)V
    .registers 3
    .parameter "defaultCarrier"

    .prologue
    .line 50
    .local p0, this:Lmiui/telephony/CarrierSelector;,"Lmiui/telephony/CarrierSelector<TT;>;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 14
    sget-object v0, Lmiui/telephony/CarrierSelector$CARRIER;->DEFAULT:Lmiui/telephony/CarrierSelector$CARRIER;

    iput-object v0, p0, Lmiui/telephony/CarrierSelector;->mDefaultCarrier:Lmiui/telephony/CarrierSelector$CARRIER;

    .line 16
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lmiui/telephony/CarrierSelector;->mCarrierMap:Ljava/util/Map;

    .line 18
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lmiui/telephony/CarrierSelector;->mStateMap:Ljava/util/Map;

    .line 51
    iput-object p1, p0, Lmiui/telephony/CarrierSelector;->mDefaultCarrier:Lmiui/telephony/CarrierSelector$CARRIER;

    .line 52
    return-void
.end method

.method private internalSelectCarrier(Ljava/lang/String;Lmiui/telephony/CarrierSelector$CARRIER;)Lmiui/telephony/CarrierSelector$CARRIER;
    .registers 7
    .parameter "mccMnc"
    .parameter "defaultCarrier"

    .prologue
    .line 183
    .local p0, this:Lmiui/telephony/CarrierSelector;,"Lmiui/telephony/CarrierSelector<TT;>;"
    move-object v0, p2

    .line 184
    .local v0, carrier:Lmiui/telephony/CarrierSelector$CARRIER;
    invoke-static {}, Lcom/android/internal/telephony/gsm/MiuiSpnOverride;->getInstance()Lcom/android/internal/telephony/gsm/MiuiSpnOverride;

    move-result-object v2

    .line 185
    .local v2, spn:Lcom/android/internal/telephony/gsm/MiuiSpnOverride;
    invoke-virtual {v2, p1}, Lcom/android/internal/telephony/gsm/MiuiSpnOverride;->getEquivalentOperatorNumeric(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 186
    .local v1, eqOperator:Ljava/lang/String;
    const-string v3, "46000"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_14

    .line 187
    sget-object v0, Lmiui/telephony/CarrierSelector$CARRIER;->CHINA_MOBILE:Lmiui/telephony/CarrierSelector$CARRIER;

    .line 193
    :cond_13
    :goto_13
    return-object v0

    .line 188
    :cond_14
    const-string v3, "46001"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1f

    .line 189
    sget-object v0, Lmiui/telephony/CarrierSelector$CARRIER;->CHINA_UNICOM:Lmiui/telephony/CarrierSelector$CARRIER;

    goto :goto_13

    .line 190
    :cond_1f
    const-string v3, "46003"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_13

    .line 191
    sget-object v0, Lmiui/telephony/CarrierSelector$CARRIER;->CHINA_TELECOM:Lmiui/telephony/CarrierSelector$CARRIER;

    goto :goto_13
.end method

.method private internalSelectState(Ljava/lang/String;)Lmiui/telephony/CarrierSelector$STATE;
    .registers 3
    .parameter "mcc"

    .prologue
    .line 175
    .local p0, this:Lmiui/telephony/CarrierSelector;,"Lmiui/telephony/CarrierSelector<TT;>;"
    const-string v0, "466"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 176
    sget-object v0, Lmiui/telephony/CarrierSelector$STATE;->TAIWAN:Lmiui/telephony/CarrierSelector$STATE;

    .line 178
    :goto_a
    return-object v0

    :cond_b
    const/4 v0, 0x0

    goto :goto_a
.end method


# virtual methods
.method public register(Lmiui/telephony/CarrierSelector$CARRIER;Ljava/lang/Object;)V
    .registers 7
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
    .line 55
    .local p0, this:Lmiui/telephony/CarrierSelector;,"Lmiui/telephony/CarrierSelector<TT;>;"
    .local p2, value:Ljava/lang/Object;,"TT;"
    if-nez p1, :cond_a

    .line 56
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "carrier not nullable"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 58
    :cond_a
    sget-object v1, Lmiui/telephony/CarrierSelector;->mCarrier2MccMap:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 59
    .local v0, mcc:Ljava/lang/String;
    if-nez v0, :cond_2e

    .line 60
    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "mcc for the carrier is unknown, carrier: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 63
    :cond_2e
    sget-object v1, Lmiui/telephony/CarrierSelector;->mMccHandled:Ljava/util/Set;

    invoke-interface {v1, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 64
    iget-object v1, p0, Lmiui/telephony/CarrierSelector;->mCarrierMap:Ljava/util/Map;

    invoke-interface {v1, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 65
    return-void
.end method

.method public register(Lmiui/telephony/CarrierSelector$STATE;Ljava/lang/Object;)V
    .registers 7
    .parameter "state"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lmiui/telephony/CarrierSelector$STATE;",
            "TT;)V"
        }
    .end annotation

    .prologue
    .line 68
    .local p0, this:Lmiui/telephony/CarrierSelector;,"Lmiui/telephony/CarrierSelector<TT;>;"
    .local p2, value:Ljava/lang/Object;,"TT;"
    if-nez p1, :cond_b

    .line 69
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "state not nullable"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 71
    :cond_b
    sget-object v1, Lmiui/telephony/CarrierSelector;->mState2MccMap:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 72
    .local v0, mcc:Ljava/lang/String;
    if-nez v0, :cond_2f

    .line 73
    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "mcc for the state is unknown, state: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 76
    :cond_2f
    sget-object v1, Lmiui/telephony/CarrierSelector;->mMccHandled:Ljava/util/Set;

    invoke-interface {v1, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 77
    iget-object v1, p0, Lmiui/telephony/CarrierSelector;->mStateMap:Ljava/util/Map;

    invoke-interface {v1, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 78
    return-void
.end method

.method public selectCarrier(Ljava/lang/String;)Lmiui/telephony/CarrierSelector$CARRIER;
    .registers 3
    .parameter "mccMnc"

    .prologue
    .line 88
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
    .line 102
    .local p0, this:Lmiui/telephony/CarrierSelector;,"Lmiui/telephony/CarrierSelector<TT;>;"
    iget-object v1, p0, Lmiui/telephony/CarrierSelector;->mDefaultCarrier:Lmiui/telephony/CarrierSelector$CARRIER;

    invoke-direct {p0, p1, v1}, Lmiui/telephony/CarrierSelector;->internalSelectCarrier(Ljava/lang/String;Lmiui/telephony/CarrierSelector$CARRIER;)Lmiui/telephony/CarrierSelector$CARRIER;

    move-result-object v0

    .line 103
    .local v0, carrier:Lmiui/telephony/CarrierSelector$CARRIER;
    iget-object v1, p0, Lmiui/telephony/CarrierSelector;->mCarrierMap:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    return-object v1
.end method

.method public selectValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    .registers 4
    .parameter "mcc"
    .parameter "mnc"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")TT;"
        }
    .end annotation

    .prologue
    .line 134
    .local p0, this:Lmiui/telephony/CarrierSelector;,"Lmiui/telephony/CarrierSelector<TT;>;"
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Lmiui/telephony/CarrierSelector;->selectValue(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public selectValue(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/Object;
    .registers 9
    .parameter "mcc"
    .parameter "mnc"
    .parameter "useDefault"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Z)TT;"
        }
    .end annotation

    .prologue
    .line 151
    .local p0, this:Lmiui/telephony/CarrierSelector;,"Lmiui/telephony/CarrierSelector<TT;>;"
    if-nez p1, :cond_b

    .line 152
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v4, "mcc not nullable"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 154
    :cond_b
    const/4 v0, 0x0

    .line 155
    .local v0, carrier:Lmiui/telephony/CarrierSelector$CARRIER;
    if-eqz p2, :cond_24

    .line 156
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-direct {p0, v3, v4}, Lmiui/telephony/CarrierSelector;->internalSelectCarrier(Ljava/lang/String;Lmiui/telephony/CarrierSelector$CARRIER;)Lmiui/telephony/CarrierSelector$CARRIER;

    move-result-object v0

    .line 159
    :cond_24
    if-nez v0, :cond_45

    .line 160
    invoke-direct {p0, p1}, Lmiui/telephony/CarrierSelector;->internalSelectState(Ljava/lang/String;)Lmiui/telephony/CarrierSelector$STATE;

    move-result-object v1

    .line 161
    .local v1, state:Lmiui/telephony/CarrierSelector$STATE;
    iget-object v3, p0, Lmiui/telephony/CarrierSelector;->mStateMap:Ljava/util/Map;

    invoke-interface {v3, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 165
    .end local v1           #state:Lmiui/telephony/CarrierSelector$STATE;
    .local v2, value:Ljava/lang/Object;,"TT;"
    :goto_30
    if-nez v2, :cond_44

    if-eqz p3, :cond_44

    .line 167
    sget-object v3, Lmiui/telephony/CarrierSelector;->mMccHandled:Ljava/util/Set;

    invoke-interface {v3, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_44

    .line 168
    iget-object v3, p0, Lmiui/telephony/CarrierSelector;->mCarrierMap:Ljava/util/Map;

    iget-object v4, p0, Lmiui/telephony/CarrierSelector;->mDefaultCarrier:Lmiui/telephony/CarrierSelector$CARRIER;

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 171
    :cond_44
    return-object v2

    .line 163
    .end local v2           #value:Ljava/lang/Object;,"TT;"
    :cond_45
    iget-object v3, p0, Lmiui/telephony/CarrierSelector;->mCarrierMap:Ljava/util/Map;

    invoke-interface {v3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .restart local v2       #value:Ljava/lang/Object;,"TT;"
    goto :goto_30
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
    .line 119
    .local p0, this:Lmiui/telephony/CarrierSelector;,"Lmiui/telephony/CarrierSelector<TT;>;"
    if-eqz p2, :cond_f

    iget-object v1, p0, Lmiui/telephony/CarrierSelector;->mDefaultCarrier:Lmiui/telephony/CarrierSelector$CARRIER;

    :goto_4
    invoke-direct {p0, p1, v1}, Lmiui/telephony/CarrierSelector;->internalSelectCarrier(Ljava/lang/String;Lmiui/telephony/CarrierSelector$CARRIER;)Lmiui/telephony/CarrierSelector$CARRIER;

    move-result-object v0

    .line 121
    .local v0, carrier:Lmiui/telephony/CarrierSelector$CARRIER;
    iget-object v1, p0, Lmiui/telephony/CarrierSelector;->mCarrierMap:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    return-object v1

    .line 119
    .end local v0           #carrier:Lmiui/telephony/CarrierSelector$CARRIER;
    :cond_f
    const/4 v1, 0x0

    goto :goto_4
.end method
