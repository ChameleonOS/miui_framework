.class public final Lmiui/provider/Weather$SelectedCity;
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
    name = "SelectedCity"
.end annotation


# static fields
.field public static final CONTENT_ITEM_TYPE:Ljava/lang/String; = "vnd.android.cursor.item/weather_selected_city"

.field public static final CONTENT_TYPE:Ljava/lang/String; = "vnd.android.cursor.dir/weather_selected_city"

.field public static final CONTENT_URI:Landroid/net/Uri; = null

.field public static final FLAG:Ljava/lang/String; = "flag"

.field public static final FLAG_GPS:I = 0x1

.field public static final POSITION:Ljava/lang/String; = "position"


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    const-string v0, "content://weather/selected_city"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lmiui/provider/Weather$SelectedCity;->CONTENT_URI:Landroid/net/Uri;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
