.class public Lmiui/telephony/Connection;
.super Ljava/lang/Object;
.source "Connection.java"


# static fields
.field public static PRESENTATION_ALLOWED:I

.field public static PRESENTATION_PAYPHONE:I

.field public static PRESENTATION_RESTRICTED:I

.field public static PRESENTATION_UNKNOWN:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 10
    const/4 v0, 0x1

    sput v0, Lmiui/telephony/Connection;->PRESENTATION_ALLOWED:I

    .line 11
    const/4 v0, 0x2

    sput v0, Lmiui/telephony/Connection;->PRESENTATION_RESTRICTED:I

    .line 12
    const/4 v0, 0x3

    sput v0, Lmiui/telephony/Connection;->PRESENTATION_UNKNOWN:I

    .line 13
    const/4 v0, 0x4

    sput v0, Lmiui/telephony/Connection;->PRESENTATION_PAYPHONE:I

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 7
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getPresentationString(I)Ljava/lang/String;
    .registers 4
    .parameter "presentation"

    .prologue
    .line 20
    const-string v0, ""

    .line 21
    .local v0, name:Ljava/lang/String;
    sget v1, Lmiui/telephony/Connection;->PRESENTATION_RESTRICTED:I

    if-ne p0, v1, :cond_12

    .line 22
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x60c003d

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 28
    :goto_11
    return-object v0

    .line 23
    :cond_12
    sget v1, Lmiui/telephony/Connection;->PRESENTATION_PAYPHONE:I

    if-ne p0, v1, :cond_22

    .line 24
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x60c003e

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_11

    .line 26
    :cond_22
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x60c003c

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_11
.end method
