.class public final Lmiui/text/util/MiuiFormatter;
.super Ljava/lang/Object;
.source "MiuiFormatter.java"


# static fields
.field public static final GB:J = 0x3b9aca00L

.field public static final KB:J = 0x3e8L

.field public static final MB:J = 0xf4240L

.field private static final UNIT:J = 0x3e8L


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 9
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static formatFileSize(Landroid/content/Context;J)Ljava/lang/String;
    .registers 4
    .parameter "context"
    .parameter "number"

    .prologue
    .line 26
    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Lmiui/text/util/MiuiFormatter;->formatFileSize(Landroid/content/Context;JZ)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static formatFileSize(Landroid/content/Context;JZ)Ljava/lang/String;
    .registers 12
    .parameter "context"
    .parameter "number"
    .parameter "shorter"

    .prologue
    const/high16 v5, 0x447a

    const/high16 v4, 0x4461

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 38
    if-nez p0, :cond_b

    .line 39
    const-string v3, ""

    .line 82
    :goto_a
    return-object v3

    .line 42
    :cond_b
    long-to-float v0, p1

    .line 43
    .local v0, result:F
    const v1, 0x60c01de

    .line 44
    .local v1, suffix:I
    cmpl-float v3, v0, v4

    if-lez v3, :cond_17

    .line 45
    const v1, 0x60c017b

    .line 46
    div-float/2addr v0, v5

    .line 48
    :cond_17
    cmpl-float v3, v0, v4

    if-lez v3, :cond_1f

    .line 49
    const v1, 0x60c017c

    .line 50
    div-float/2addr v0, v5

    .line 52
    :cond_1f
    cmpl-float v3, v0, v4

    if-lez v3, :cond_27

    .line 53
    const v1, 0x60c019b

    .line 54
    div-float/2addr v0, v5

    .line 56
    :cond_27
    cmpl-float v3, v0, v4

    if-lez v3, :cond_2f

    .line 57
    const v1, 0x60c01df

    .line 58
    div-float/2addr v0, v5

    .line 60
    :cond_2f
    cmpl-float v3, v0, v4

    if-lez v3, :cond_37

    .line 61
    const v1, 0x60c01e0

    .line 62
    div-float/2addr v0, v5

    .line 65
    :cond_37
    const/high16 v3, 0x3f80

    cmpg-float v3, v0, v3

    if-gez v3, :cond_62

    .line 66
    const-string v3, "%.2f"

    new-array v4, v7, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 82
    .local v2, value:Ljava/lang/String;
    :goto_4b
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x60c01e1

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    aput-object v2, v5, v6

    invoke-virtual {p0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-virtual {v3, v4, v5}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    goto :goto_a

    .line 67
    .end local v2           #value:Ljava/lang/String;
    :cond_62
    const/high16 v3, 0x4120

    cmpg-float v3, v0, v3

    if-gez v3, :cond_88

    .line 68
    if-eqz p3, :cond_79

    .line 69
    const-string v3, "%.1f"

    new-array v4, v7, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .restart local v2       #value:Ljava/lang/String;
    goto :goto_4b

    .line 71
    .end local v2           #value:Ljava/lang/String;
    :cond_79
    const-string v3, "%.2f"

    new-array v4, v7, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .restart local v2       #value:Ljava/lang/String;
    goto :goto_4b

    .line 73
    .end local v2           #value:Ljava/lang/String;
    :cond_88
    const/high16 v3, 0x42c8

    cmpg-float v3, v0, v3

    if-gez v3, :cond_ae

    .line 74
    if-eqz p3, :cond_9f

    .line 75
    const-string v3, "%.0f"

    new-array v4, v7, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .restart local v2       #value:Ljava/lang/String;
    goto :goto_4b

    .line 77
    .end local v2           #value:Ljava/lang/String;
    :cond_9f
    const-string v3, "%.2f"

    new-array v4, v7, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .restart local v2       #value:Ljava/lang/String;
    goto :goto_4b

    .line 80
    .end local v2           #value:Ljava/lang/String;
    :cond_ae
    const-string v3, "%.0f"

    new-array v4, v7, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .restart local v2       #value:Ljava/lang/String;
    goto :goto_4b
.end method

.method public static formatShortFileSize(Landroid/content/Context;J)Ljava/lang/String;
    .registers 4
    .parameter "context"
    .parameter "number"

    .prologue
    .line 34
    const/4 v0, 0x1

    invoke-static {p0, p1, p2, v0}, Lmiui/text/util/MiuiFormatter;->formatFileSize(Landroid/content/Context;JZ)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
