.class public final Lmiui/provider/ExtraTelephony$SimCards;
.super Ljava/lang/Object;
.source "ExtraTelephony.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/provider/ExtraTelephony;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "SimCards"
.end annotation


# static fields
.field public static final BIND_ID:Ljava/lang/String; = "bind_id"

.field public static final CONTENT_URI:Landroid/net/Uri; = null

.field public static final IMSI:Ljava/lang/String; = "imsi"

.field public static final MARKER1:Ljava/lang/String; = "marker1"

.field public static final MARKER2:Ljava/lang/String; = "marker2"

.field public static final NUMBER:Ljava/lang/String; = "number"

.field public static final SLOT:Ljava/lang/String; = "slot"

.field public static final _ID:Ljava/lang/String; = "_id"


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 420
    const-string v0, "content://mms-sms/sim-cards"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lmiui/provider/ExtraTelephony$SimCards;->CONTENT_URI:Landroid/net/Uri;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 419
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
