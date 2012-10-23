.class public final Lmiui/provider/ExtraTelephony$Keyword;
.super Ljava/lang/Object;
.source "ExtraTelephony.java"

# interfaces
.implements Landroid/provider/BaseColumns;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/provider/ExtraTelephony;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Keyword"
.end annotation


# static fields
.field public static final CONTENT_ITEM_TYPE:Ljava/lang/String; = "vnd.android.cursor.item/firewall-keyword"

.field public static final CONTENT_TYPE:Ljava/lang/String; = "vnd.android.cursor.dir/firewall-keyword"

.field public static final CONTENT_URI:Landroid/net/Uri; = null

.field public static final DATA:Ljava/lang/String; = "data"


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 970
    const-string v0, "content://firewall/keyword"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lmiui/provider/ExtraTelephony$Keyword;->CONTENT_URI:Landroid/net/Uri;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 966
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
