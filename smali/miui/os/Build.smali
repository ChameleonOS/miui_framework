.class public Lmiui/os/Build;
.super Landroid/os/Build;
.source "Build.java"


# static fields
.field public static final IS_DEFY:Z

.field public static final IS_DESIRE:Z

.field public static final IS_FAST_GPU_DEVICE:Z

.field public static final IS_FINAL_USER_BUILD:Z

.field public static final IS_FULL_SOURCE_CODE_DEVICE:Z

.field public static final IS_GALAXYS2:Z

.field public static final IS_GALAXYS_NEXUS:Z

.field public static final IS_HTC_HD2:Z

.field public static final IS_I9000:Z

.field public static final IS_LOW_MEMORY_DEVICE:Z

.field public static final IS_MI1S:Z

.field public static final IS_MILESTONE:Z

.field public static final IS_MIONE:Z

.field public static final IS_MIONE_CT_CUSTOMIZATION:Z

.field public static final IS_MIONE_PLUS_CDMA:Z

.field public static final IS_MITWO:Z

.field public static final IS_NEED_UNCOMPRESSED_UCS2_SMS_DEVICE:Z

.field public static final IS_NEXUS_7:Z

.field public static final IS_NEXUS_ONE:Z

.field public static final IS_NEXUS_S:Z

.field public static final IS_P990:Z

.field public static final IS_RICH_MEMORY_DEVICE:Z

.field public static final IS_T959:Z

.field public static final IS_U8860:Z

.field public static final IS_U9200:Z

.field public static final IS_XIAOMI:Z

.field public static final SHOW_MAGNIFIER_WHEN_INPUT:Z


# direct methods
.method static constructor <clinit>()V
    .registers 4

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 11
    const-string v0, "jordan"

    sget-object v3, Lmiui/os/Build;->BOARD:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_DEFY:Z

    .line 12
    const-string v0, "bravo"

    sget-object v3, Lmiui/os/Build;->DEVICE:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_DESIRE:Z

    .line 13
    const-string v0, "galaxys2"

    sget-object v3, Lmiui/os/Build;->DEVICE:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_GALAXYS2:Z

    .line 14
    const-string v0, "htcleo"

    sget-object v3, Lmiui/os/Build;->DEVICE:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_35

    const-string/jumbo v0, "leo"

    sget-object v3, Lmiui/os/Build;->DEVICE:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_166

    :cond_35
    move v0, v2

    :goto_36
    sput-boolean v0, Lmiui/os/Build;->IS_HTC_HD2:Z

    .line 15
    const-string v0, "aries"

    sget-object v3, Lmiui/os/Build;->BOARD:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_I9000:Z

    .line 16
    const-string/jumbo v0, "umts_sholes"

    sget-object v3, Lmiui/os/Build;->DEVICE:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_MILESTONE:Z

    .line 17
    const-string/jumbo v0, "mione"

    sget-object v3, Lmiui/os/Build;->DEVICE:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_63

    const-string/jumbo v0, "mione_plus"

    sget-object v3, Lmiui/os/Build;->DEVICE:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_169

    :cond_63
    move v0, v2

    :goto_64
    sput-boolean v0, Lmiui/os/Build;->IS_MIONE:Z

    .line 18
    const-string v0, "aries"

    sget-object v3, Lmiui/os/Build;->DEVICE:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_MITWO:Z

    .line 19
    sget-boolean v0, Lmiui/os/Build;->IS_MIONE:Z

    if-nez v0, :cond_78

    sget-boolean v0, Lmiui/os/Build;->IS_MITWO:Z

    if-eqz v0, :cond_16c

    :cond_78
    move v0, v2

    :goto_79
    sput-boolean v0, Lmiui/os/Build;->IS_XIAOMI:Z

    .line 20
    const-string/jumbo v0, "passion"

    sget-object v3, Lmiui/os/Build;->DEVICE:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_NEXUS_ONE:Z

    .line 21
    const-string v0, "crespo"

    sget-object v3, Lmiui/os/Build;->DEVICE:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_NEXUS_S:Z

    .line 22
    const-string v0, "grouper"

    sget-object v3, Lmiui/os/Build;->DEVICE:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_NEXUS_7:Z

    .line 23
    const-string/jumbo v0, "maguro"

    sget-object v3, Lmiui/os/Build;->DEVICE:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_GALAXYS_NEXUS:Z

    .line 24
    const-string/jumbo v0, "p990"

    sget-object v3, Lmiui/os/Build;->DEVICE:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_P990:Z

    .line 25
    sget-object v0, Lmiui/os/Build;->DEVICE:Ljava/lang/String;

    const-string/jumbo v3, "vibrant"

    invoke-virtual {v0, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_T959:Z

    .line 26
    const-string v0, "hwu8860"

    sget-object v3, Lmiui/os/Build;->DEVICE:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_U8860:Z

    .line 27
    const-string v0, "hwu9200"

    sget-object v3, Lmiui/os/Build;->DEVICE:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_U9200:Z

    .line 28
    const-string v0, "MI 1S"

    sget-object v3, Lmiui/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_e3

    const-string v0, "MI 1SC"

    sget-object v3, Lmiui/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_16f

    :cond_e3
    move v0, v2

    :goto_e4
    sput-boolean v0, Lmiui/os/Build;->IS_MI1S:Z

    .line 30
    sget-boolean v0, Lmiui/os/Build;->IS_MIONE:Z

    if-nez v0, :cond_ee

    sget-boolean v0, Lmiui/os/Build;->IS_GALAXYS2:Z

    if-eqz v0, :cond_172

    :cond_ee
    move v0, v2

    :goto_ef
    sput-boolean v0, Lmiui/os/Build;->IS_RICH_MEMORY_DEVICE:Z

    .line 31
    sget-boolean v0, Lmiui/os/Build;->IS_MILESTONE:Z

    sput-boolean v0, Lmiui/os/Build;->IS_LOW_MEMORY_DEVICE:Z

    .line 33
    sget-boolean v0, Lmiui/os/Build;->IS_MIONE:Z

    if-nez v0, :cond_109

    sget-boolean v0, Lmiui/os/Build;->IS_I9000:Z

    if-nez v0, :cond_109

    sget-boolean v0, Lmiui/os/Build;->IS_P990:Z

    if-nez v0, :cond_109

    sget-boolean v0, Lmiui/os/Build;->IS_NEXUS_S:Z

    if-nez v0, :cond_109

    sget-boolean v0, Lmiui/os/Build;->IS_GALAXYS2:Z

    if-eqz v0, :cond_175

    :cond_109
    move v0, v2

    :goto_10a
    sput-boolean v0, Lmiui/os/Build;->IS_FAST_GPU_DEVICE:Z

    .line 36
    sget-boolean v0, Lmiui/os/Build;->IS_MILESTONE:Z

    if-nez v0, :cond_124

    sget-boolean v0, Lmiui/os/Build;->IS_NEXUS_S:Z

    if-nez v0, :cond_124

    sget-boolean v0, Lmiui/os/Build;->IS_I9000:Z

    if-nez v0, :cond_124

    sget-boolean v0, Lmiui/os/Build;->IS_DEFY:Z

    if-nez v0, :cond_124

    sget-boolean v0, Lmiui/os/Build;->IS_GALAXYS2:Z

    if-nez v0, :cond_124

    sget-boolean v0, Lmiui/os/Build;->IS_P990:Z

    if-eqz v0, :cond_177

    :cond_124
    move v0, v2

    :goto_125
    sput-boolean v0, Lmiui/os/Build;->IS_NEED_UNCOMPRESSED_UCS2_SMS_DEVICE:Z

    .line 39
    sget-boolean v0, Lmiui/os/Build;->IS_MIONE:Z

    if-eqz v0, :cond_179

    invoke-static {}, Lmiui/os/Build;->isMsm8660()Z

    move-result v0

    if-eqz v0, :cond_179

    move v0, v2

    :goto_132
    sput-boolean v0, Lmiui/os/Build;->IS_MIONE_PLUS_CDMA:Z

    .line 43
    const-string v0, "ct"

    const-string/jumbo v3, "ro.carrier.name"

    invoke-static {v3}, Lmiui/os/Build;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_MIONE_CT_CUSTOMIZATION:Z

    .line 46
    sget-boolean v0, Lmiui/os/Build;->IS_XIAOMI:Z

    if-nez v0, :cond_14f

    sget-boolean v0, Lmiui/os/Build;->IS_GALAXYS_NEXUS:Z

    if-nez v0, :cond_14f

    sget-boolean v0, Lmiui/os/Build;->IS_NEXUS_S:Z

    if-eqz v0, :cond_17b

    :cond_14f
    move v0, v2

    :goto_150
    sput-boolean v0, Lmiui/os/Build;->SHOW_MAGNIFIER_WHEN_INPUT:Z

    .line 49
    sget-boolean v0, Lmiui/os/Build;->IS_XIAOMI:Z

    if-nez v0, :cond_162

    sget-boolean v0, Lmiui/os/Build;->IS_GALAXYS_NEXUS:Z

    if-nez v0, :cond_162

    sget-boolean v0, Lmiui/os/Build;->IS_NEXUS_S:Z

    if-nez v0, :cond_162

    sget-boolean v0, Lmiui/os/Build;->IS_NEXUS_7:Z

    if-eqz v0, :cond_163

    :cond_162
    move v1, v2

    :cond_163
    sput-boolean v1, Lmiui/os/Build;->IS_FULL_SOURCE_CODE_DEVICE:Z

    return-void

    :cond_166
    move v0, v1

    .line 14
    goto/16 :goto_36

    :cond_169
    move v0, v1

    .line 17
    goto/16 :goto_64

    :cond_16c
    move v0, v1

    .line 19
    goto/16 :goto_79

    :cond_16f
    move v0, v1

    .line 28
    goto/16 :goto_e4

    :cond_172
    move v0, v1

    .line 30
    goto/16 :goto_ef

    :cond_175
    move v0, v1

    .line 33
    goto :goto_10a

    :cond_177
    move v0, v1

    .line 36
    goto :goto_125

    :cond_179
    move v0, v1

    .line 39
    goto :goto_132

    :cond_17b
    move v0, v1

    .line 46
    goto :goto_150
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 9
    invoke-direct {p0}, Landroid/os/Build;-><init>()V

    return-void
.end method

.method private static getString(Ljava/lang/String;)Ljava/lang/String;
    .registers 2
    .parameter "property"

    .prologue
    .line 85
    const-string/jumbo v0, "unknown"

    invoke-static {p0, v0}, Landroid/os/SystemProperties;->get(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static isDevelopmentVersion()Z
    .registers 2

    .prologue
    .line 54
    const-string v0, "\\d+.\\d+.\\d+(.ALPHA)?"

    .line 55
    .local v0, regularExpression:Ljava/lang/String;
    sget-object v1, Landroid/os/Build$VERSION;->INCREMENTAL:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_14

    sget-object v1, Landroid/os/Build$VERSION;->INCREMENTAL:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_14

    const/4 v1, 0x1

    :goto_13
    return v1

    :cond_14
    const/4 v1, 0x0

    goto :goto_13
.end method

.method public static isMsm8660()Z
    .registers 2

    .prologue
    .line 71
    const-string/jumbo v1, "ro.soc.name"

    invoke-static {v1}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 72
    .local v0, soc:Ljava/lang/String;
    const-string/jumbo v1, "msm8660"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_19

    const-string/jumbo v1, "unkown"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1b

    :cond_19
    const/4 v1, 0x1

    :goto_1a
    return v1

    :cond_1b
    const/4 v1, 0x0

    goto :goto_1a
.end method

.method public static isOfficialVersion()Z
    .registers 1

    .prologue
    .line 67
    invoke-static {}, Lmiui/os/Build;->isDevelopmentVersion()Z

    move-result v0

    if-nez v0, :cond_c

    invoke-static {}, Lmiui/os/Build;->isStableVersion()Z

    move-result v0

    if-eqz v0, :cond_e

    :cond_c
    const/4 v0, 0x1

    :goto_d
    return v0

    :cond_e
    const/4 v0, 0x0

    goto :goto_d
.end method

.method public static isStableVersion()Z
    .registers 2

    .prologue
    .line 61
    const-string v0, "ICS\\d+.\\d+"

    .line 62
    .local v0, regularExpression:Ljava/lang/String;
    sget-object v1, Landroid/os/Build$VERSION;->INCREMENTAL:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_14

    sget-object v1, Landroid/os/Build$VERSION;->INCREMENTAL:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_14

    const/4 v1, 0x1

    :goto_13
    return v1

    :cond_14
    const/4 v1, 0x0

    goto :goto_13
.end method
