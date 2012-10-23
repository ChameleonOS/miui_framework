.class public final Lmiui/provider/Weather$City;
.super Ljava/lang/Object;
.source "Weather.java"

# interfaces
.implements Lmiui/provider/Weather$WeatherCityColumns;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/provider/Weather;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "City"
.end annotation


# static fields
.field public static final AREA_CODE:Ljava/lang/String; = "area_code"

.field public static final CONTENT_ITEM_TYPE:Ljava/lang/String; = "vnd.android.cursor.item/weahter_city"

.field public static final CONTENT_TYPE:Ljava/lang/String; = "vnd.android.cursor.dir/weather_city"

.field public static final CONTENT_URI:Landroid/net/Uri; = null

.field public static final PARENT:Ljava/lang/String; = "parent"

.field public static final PHONE_CODE:Ljava/lang/String; = "phone_code"

.field public static final PY:Ljava/lang/String; = "pinyin"

.field public static final P_X:Ljava/lang/String; = "x"

.field public static final P_Y:Ljava/lang/String; = "y"

.field public static final ROOT:Ljava/lang/String; = "root"

.field public static final URL:Ljava/lang/String; = "url"


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 103
    const-string v0, "content://weather/city"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lmiui/provider/Weather$City;->CONTENT_URI:Landroid/net/Uri;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 101
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
