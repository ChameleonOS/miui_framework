.class public Lmiui/provider/Weather;
.super Ljava/lang/Object;
.source "Weather.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmiui/provider/Weather$Widget;,
        Lmiui/provider/Weather$SelectedCity;,
        Lmiui/provider/Weather$HotCity;,
        Lmiui/provider/Weather$City;,
        Lmiui/provider/Weather$WeatherCityColumns;,
        Lmiui/provider/Weather$DailyWeather;,
        Lmiui/provider/Weather$LocalWeather;,
        Lmiui/provider/Weather$WeatherBaseColumns;
    }
.end annotation


# static fields
.field public static final AUTHORITY:Ljava/lang/String; = "weather"

.field public static final BLIZZARD:I = 0xd

.field public static final BLOWING_SAND:I = 0x15

.field public static final CLOUDY:I = 0x1

.field public static final DUST:I = 0x14

.field public static final DUSTSTORM:I = 0x13

.field public static final FLOATING_DUST:I = 0x17

.field public static final FOG:I = 0x3

.field public static final HAILSTONE:I = 0x16

.field public static final HEAVY_RAIN:I = 0x9

.field public static final HEAVY_RAINSTORM:I = 0x5

.field public static final HEAVY_SNOW:I = 0xf

.field public static final LIGHT_RAIN:I = 0xb

.field public static final LIGHT_SNOW:I = 0x11

.field public static final MODERATE_RAIN:I = 0xa

.field public static final MODERATE_SNOW:I = 0x10

.field public static final OVERCAST:I = 0x2

.field public static final RAINSTORM:I = 0x6

.field public static final RAIN_SHOWERS:I = 0x8

.field public static final SLEET:I = 0xc

.field public static final SNOW_SHOWERS:I = 0xe

.field public static final STRONG_DUSTSTORM:I = 0x12

.field public static final STRONG_RAINSTORM:I = 0x4

.field public static final SUNNY:I = 0x0

.field public static final T_STORMS:I = 0x7


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 8
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 155
    return-void
.end method
