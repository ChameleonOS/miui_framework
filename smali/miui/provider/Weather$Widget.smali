.class public final Lmiui/provider/Weather$Widget;
.super Ljava/lang/Object;
.source "Weather.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/provider/Weather;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Widget"
.end annotation


# static fields
.field public static final CONTENT_ITEM_TYPE:Ljava/lang/String; = "vnd.android.cursor.item/weather_widget"

.field public static final CONTENT_TYPE:Ljava/lang/String; = "vnd.android.cursor.dir/weather_widget"

.field public static final CONTENT_URI:Landroid/net/Uri; = null

.field public static final ID:Ljava/lang/String; = "_id"

.field public static final PID:Ljava/lang/String; = "posID"

.field public static final TYPE_ID:Ljava/lang/String; = "type_id"

.field public static final WIDGET_ID:Ljava/lang/String; = "widget_id"


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    const-string v0, "content://weather/widget"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lmiui/provider/Weather$Widget;->CONTENT_URI:Landroid/net/Uri;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
