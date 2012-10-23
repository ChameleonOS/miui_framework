.class public Lcom/android/internal/telephony/gsm/MiuiSpnOverride;
.super Ljava/lang/Object;
.source "MiuiSpnOverride.java"


# static fields
.field public static final EQ_OPERATOR_CM:Ljava/lang/String; = "46000"

.field public static final EQ_OPERATOR_CT:Ljava/lang/String; = "46003"

.field public static final EQ_OPERATOR_CU:Ljava/lang/String; = "46001"

.field private static final sImpl:Lcom/android/internal/telephony/gsm/MiuiSpnOverrideImpl;

.field static final sInstance:Lcom/android/internal/telephony/gsm/MiuiSpnOverride;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 17
    new-instance v0, Lcom/android/internal/telephony/gsm/MiuiSpnOverrideImpl;

    invoke-direct {v0}, Lcom/android/internal/telephony/gsm/MiuiSpnOverrideImpl;-><init>()V

    sput-object v0, Lcom/android/internal/telephony/gsm/MiuiSpnOverride;->sImpl:Lcom/android/internal/telephony/gsm/MiuiSpnOverrideImpl;

    .line 19
    new-instance v0, Lcom/android/internal/telephony/gsm/MiuiSpnOverride;

    invoke-direct {v0}, Lcom/android/internal/telephony/gsm/MiuiSpnOverride;-><init>()V

    sput-object v0, Lcom/android/internal/telephony/gsm/MiuiSpnOverride;->sInstance:Lcom/android/internal/telephony/gsm/MiuiSpnOverride;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 9
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getInstance()Lcom/android/internal/telephony/gsm/MiuiSpnOverride;
    .registers 1

    .prologue
    .line 22
    sget-object v0, Lcom/android/internal/telephony/gsm/MiuiSpnOverride;->sInstance:Lcom/android/internal/telephony/gsm/MiuiSpnOverride;

    return-object v0
.end method


# virtual methods
.method public containsCarrier(Ljava/lang/String;)Z
    .registers 3
    .parameter "carrier"

    .prologue
    .line 26
    sget-object v0, Lcom/android/internal/telephony/gsm/MiuiSpnOverride;->sImpl:Lcom/android/internal/telephony/gsm/MiuiSpnOverrideImpl;

    invoke-virtual {v0, p1}, Lcom/android/internal/telephony/gsm/MiuiSpnOverrideImpl;->containsCarrier(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public getEquivalentOperatorNumeric(Ljava/lang/String;)Ljava/lang/String;
    .registers 3
    .parameter "carrier"

    .prologue
    .line 34
    sget-object v0, Lcom/android/internal/telephony/gsm/MiuiSpnOverride;->sImpl:Lcom/android/internal/telephony/gsm/MiuiSpnOverrideImpl;

    invoke-virtual {v0, p1}, Lcom/android/internal/telephony/gsm/MiuiSpnOverrideImpl;->getEquivalentOperatorNumeric(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSpn(Ljava/lang/String;)Ljava/lang/String;
    .registers 3
    .parameter "carrier"

    .prologue
    .line 30
    sget-object v0, Lcom/android/internal/telephony/gsm/MiuiSpnOverride;->sImpl:Lcom/android/internal/telephony/gsm/MiuiSpnOverrideImpl;

    invoke-virtual {v0, p1}, Lcom/android/internal/telephony/gsm/MiuiSpnOverrideImpl;->getSpn(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
