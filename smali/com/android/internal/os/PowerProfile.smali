.class public Lcom/android/internal/os/PowerProfile;
.super Ljava/lang/Object;
.source "PowerProfile.java"


# static fields
.field private static final ATTR_NAME:Ljava/lang/String; = "name"

.field public static final POWER_AUDIO:Ljava/lang/String; = "dsp.audio"

.field public static final POWER_BATTERY_CAPACITY:Ljava/lang/String; = "battery.capacity"

.field public static final POWER_BLUETOOTH_ACTIVE:Ljava/lang/String; = "bluetooth.active"

.field public static final POWER_BLUETOOTH_AT_CMD:Ljava/lang/String; = "bluetooth.at"

.field public static final POWER_BLUETOOTH_ON:Ljava/lang/String; = "bluetooth.on"

.field public static final POWER_CPU_ACTIVE:Ljava/lang/String; = "cpu.active"

.field public static final POWER_CPU_AWAKE:Ljava/lang/String; = "cpu.awake"

.field public static final POWER_CPU_IDLE:Ljava/lang/String; = "cpu.idle"

.field public static final POWER_CPU_SPEEDS:Ljava/lang/String; = "cpu.speeds"

.field public static final POWER_GPS_ON:Ljava/lang/String; = "gps.on"

.field public static final POWER_NONE:Ljava/lang/String; = "none"

.field public static final POWER_RADIO_ACTIVE:Ljava/lang/String; = "radio.active"

.field public static final POWER_RADIO_ON:Ljava/lang/String; = "radio.on"

.field public static final POWER_RADIO_SCANNING:Ljava/lang/String; = "radio.scanning"

.field public static final POWER_SCREEN_FULL:Ljava/lang/String; = "screen.full"

.field public static final POWER_SCREEN_ON:Ljava/lang/String; = "screen.on"

.field public static final POWER_VIDEO:Ljava/lang/String; = "dsp.video"

.field public static final POWER_WIFI_ACTIVE:Ljava/lang/String; = "wifi.active"

.field public static final POWER_WIFI_ON:Ljava/lang/String; = "wifi.on"

.field public static final POWER_WIFI_SCAN:Ljava/lang/String; = "wifi.scan"

.field private static final TAG_ARRAY:Ljava/lang/String; = "array"

.field private static final TAG_ARRAYITEM:Ljava/lang/String; = "value"

.field private static final TAG_DEVICE:Ljava/lang/String; = "device"

.field private static final TAG_ITEM:Ljava/lang/String; = "item"

.field static final sPowerMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 143
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/android/internal/os/PowerProfile;->sPowerMap:Ljava/util/HashMap;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .registers 3
    .parameter "context"

    .prologue
    .line 151
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 154
    sget-object v0, Lcom/android/internal/os/PowerProfile;->sPowerMap:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->size()I

    move-result v0

    if-nez v0, :cond_e

    .line 155
    invoke-direct {p0, p1}, Lcom/android/internal/os/PowerProfile;->readPowerValuesFromXml(Landroid/content/Context;)V

    .line 157
    :cond_e
    return-void
.end method

.method private readPowerValuesFromXml(Landroid/content/Context;)V
    .registers 15
    .parameter "context"

    .prologue
    .line 160
    const v4, 0x10f000a

    .line 161
    .local v4, id:I
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    invoke-virtual {v11, v4}, Landroid/content/res/Resources;->getXml(I)Landroid/content/res/XmlResourceParser;

    move-result-object v6

    .line 162
    .local v6, parser:Landroid/content/res/XmlResourceParser;
    const/4 v7, 0x0

    .line 163
    .local v7, parsingArray:Z
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 164
    .local v0, array:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/Double;>;"
    const/4 v1, 0x0

    .line 167
    .local v1, arrayName:Ljava/lang/String;
    :try_start_12
    const-string v11, "device"

    invoke-static {v6, v11}, Lcom/android/internal/util/XmlUtils;->beginDocument(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)V

    .line 170
    :cond_17
    :goto_17
    invoke-static {v6}, Lcom/android/internal/util/XmlUtils;->nextElement(Lorg/xmlpull/v1/XmlPullParser;)V

    .line 172
    invoke-interface {v6}, Landroid/content/res/XmlResourceParser;->getName()Ljava/lang/String;

    move-result-object v3

    .line 173
    .local v3, element:Ljava/lang/String;
    if-nez v3, :cond_35

    .line 202
    if-eqz v7, :cond_31

    .line 203
    sget-object v11, Lcom/android/internal/os/PowerProfile;->sPowerMap:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v12

    new-array v12, v12, [Ljava/lang/Double;

    invoke-virtual {v0, v12}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v12

    invoke-virtual {v11, v1, v12}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_31
    .catchall {:try_start_12 .. :try_end_31} :catchall_b0
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_12 .. :try_end_31} :catch_a9
    .catch Ljava/io/IOException; {:try_start_12 .. :try_end_31} :catch_c0

    .line 210
    :cond_31
    invoke-interface {v6}, Landroid/content/res/XmlResourceParser;->close()V

    .line 212
    return-void

    .line 175
    :cond_35
    if-eqz v7, :cond_50

    :try_start_37
    const-string/jumbo v11, "value"

    invoke-virtual {v3, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_50

    .line 177
    sget-object v11, Lcom/android/internal/os/PowerProfile;->sPowerMap:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v12

    new-array v12, v12, [Ljava/lang/Double;

    invoke-virtual {v0, v12}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v12

    invoke-virtual {v11, v1, v12}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 178
    const/4 v7, 0x0

    .line 180
    :cond_50
    const-string v11, "array"

    invoke-virtual {v3, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_65

    .line 181
    const/4 v7, 0x1

    .line 182
    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 183
    const/4 v11, 0x0

    const-string/jumbo v12, "name"

    invoke-interface {v6, v11, v12}, Landroid/content/res/XmlResourceParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    goto :goto_17

    .line 184
    :cond_65
    const-string v11, "item"

    invoke-virtual {v3, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_76

    const-string/jumbo v11, "value"

    invoke-virtual {v3, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_17

    .line 185
    :cond_76
    const/4 v5, 0x0

    .line 186
    .local v5, name:Ljava/lang/String;
    if-nez v7, :cond_81

    const/4 v11, 0x0

    const-string/jumbo v12, "name"

    invoke-interface {v6, v11, v12}, Landroid/content/res/XmlResourceParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 187
    :cond_81
    invoke-interface {v6}, Landroid/content/res/XmlResourceParser;->next()I

    move-result v11

    const/4 v12, 0x4

    if-ne v11, v12, :cond_17

    .line 188
    invoke-interface {v6}, Landroid/content/res/XmlResourceParser;->getText()Ljava/lang/String;
    :try_end_8b
    .catchall {:try_start_37 .. :try_end_8b} :catchall_b0
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_37 .. :try_end_8b} :catch_a9
    .catch Ljava/io/IOException; {:try_start_37 .. :try_end_8b} :catch_c0

    move-result-object v8

    .line 189
    .local v8, power:Ljava/lang/String;
    const-wide/16 v9, 0x0

    .line 191
    .local v9, value:D
    :try_start_8e
    invoke-static {v8}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Double;->doubleValue()D
    :try_end_95
    .catchall {:try_start_8e .. :try_end_95} :catchall_b0
    .catch Ljava/lang/NumberFormatException; {:try_start_8e .. :try_end_95} :catch_c7
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_8e .. :try_end_95} :catch_a9
    .catch Ljava/io/IOException; {:try_start_8e .. :try_end_95} :catch_c0

    move-result-wide v9

    .line 194
    :goto_96
    :try_start_96
    const-string v11, "item"

    invoke-virtual {v3, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_b5

    .line 195
    sget-object v11, Lcom/android/internal/os/PowerProfile;->sPowerMap:Ljava/util/HashMap;

    invoke-static {v9, v10}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v12

    invoke-virtual {v11, v5, v12}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_a7
    .catchall {:try_start_96 .. :try_end_a7} :catchall_b0
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_96 .. :try_end_a7} :catch_a9
    .catch Ljava/io/IOException; {:try_start_96 .. :try_end_a7} :catch_c0

    goto/16 :goto_17

    .line 205
    .end local v3           #element:Ljava/lang/String;
    .end local v5           #name:Ljava/lang/String;
    .end local v8           #power:Ljava/lang/String;
    .end local v9           #value:D
    :catch_a9
    move-exception v2

    .line 206
    .local v2, e:Lorg/xmlpull/v1/XmlPullParserException;
    :try_start_aa
    new-instance v11, Ljava/lang/RuntimeException;

    invoke-direct {v11, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v11
    :try_end_b0
    .catchall {:try_start_aa .. :try_end_b0} :catchall_b0

    .line 210
    .end local v2           #e:Lorg/xmlpull/v1/XmlPullParserException;
    :catchall_b0
    move-exception v11

    invoke-interface {v6}, Landroid/content/res/XmlResourceParser;->close()V

    throw v11

    .line 196
    .restart local v3       #element:Ljava/lang/String;
    .restart local v5       #name:Ljava/lang/String;
    .restart local v8       #power:Ljava/lang/String;
    .restart local v9       #value:D
    :cond_b5
    if-eqz v7, :cond_17

    .line 197
    :try_start_b7
    invoke-static {v9, v10}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v11

    invoke-virtual {v0, v11}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_be
    .catchall {:try_start_b7 .. :try_end_be} :catchall_b0
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_b7 .. :try_end_be} :catch_a9
    .catch Ljava/io/IOException; {:try_start_b7 .. :try_end_be} :catch_c0

    goto/16 :goto_17

    .line 207
    .end local v3           #element:Ljava/lang/String;
    .end local v5           #name:Ljava/lang/String;
    .end local v8           #power:Ljava/lang/String;
    .end local v9           #value:D
    :catch_c0
    move-exception v2

    .line 208
    .local v2, e:Ljava/io/IOException;
    :try_start_c1
    new-instance v11, Ljava/lang/RuntimeException;

    invoke-direct {v11, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v11
    :try_end_c7
    .catchall {:try_start_c1 .. :try_end_c7} :catchall_b0

    .line 192
    .end local v2           #e:Ljava/io/IOException;
    .restart local v3       #element:Ljava/lang/String;
    .restart local v5       #name:Ljava/lang/String;
    .restart local v8       #power:Ljava/lang/String;
    .restart local v9       #value:D
    :catch_c7
    move-exception v11

    goto :goto_96
.end method


# virtual methods
.method public getAveragePower(Ljava/lang/String;)D
    .registers 5
    .parameter "type"

    .prologue
    .line 220
    sget-object v1, Lcom/android/internal/os/PowerProfile;->sPowerMap:Ljava/util/HashMap;

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2b

    .line 221
    sget-object v1, Lcom/android/internal/os/PowerProfile;->sPowerMap:Ljava/util/HashMap;

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 222
    .local v0, data:Ljava/lang/Object;
    instance-of v1, v0, [Ljava/lang/Double;

    if-eqz v1, :cond_1e

    .line 223
    check-cast v0, [Ljava/lang/Double;

    .end local v0           #data:Ljava/lang/Object;
    check-cast v0, [Ljava/lang/Double;

    const/4 v1, 0x0

    aget-object v1, v0, v1

    invoke-virtual {v1}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v1

    .line 228
    :goto_1d
    return-wide v1

    .line 225
    .restart local v0       #data:Ljava/lang/Object;
    :cond_1e
    sget-object v1, Lcom/android/internal/os/PowerProfile;->sPowerMap:Ljava/util/HashMap;

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Double;

    invoke-virtual {v1}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v1

    goto :goto_1d

    .line 228
    .end local v0           #data:Ljava/lang/Object;
    :cond_2b
    const-wide/16 v1, 0x0

    goto :goto_1d
.end method

.method public getAveragePower(Ljava/lang/String;I)D
    .registers 8
    .parameter "type"
    .parameter "level"

    .prologue
    const-wide/16 v2, 0x0

    .line 241
    sget-object v4, Lcom/android/internal/os/PowerProfile;->sPowerMap:Ljava/util/HashMap;

    invoke-virtual {v4, p1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_24

    .line 242
    sget-object v4, Lcom/android/internal/os/PowerProfile;->sPowerMap:Ljava/util/HashMap;

    invoke-virtual {v4, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 243
    .local v0, data:Ljava/lang/Object;
    instance-of v4, v0, [Ljava/lang/Double;

    if-eqz v4, :cond_31

    .line 244
    check-cast v0, [Ljava/lang/Double;

    .end local v0           #data:Ljava/lang/Object;
    move-object v1, v0

    check-cast v1, [Ljava/lang/Double;

    .line 245
    .local v1, values:[Ljava/lang/Double;
    array-length v4, v1

    if-le v4, p2, :cond_25

    if-ltz p2, :cond_25

    .line 246
    aget-object v2, v1, p2

    invoke-virtual {v2}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v2

    .line 256
    .end local v1           #values:[Ljava/lang/Double;
    :cond_24
    :goto_24
    return-wide v2

    .line 247
    .restart local v1       #values:[Ljava/lang/Double;
    :cond_25
    if-ltz p2, :cond_24

    .line 250
    array-length v2, v1

    add-int/lit8 v2, v2, -0x1

    aget-object v2, v1, v2

    invoke-virtual {v2}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v2

    goto :goto_24

    .line 253
    .end local v1           #values:[Ljava/lang/Double;
    .restart local v0       #data:Ljava/lang/Object;
    :cond_31
    check-cast v0, Ljava/lang/Double;

    .end local v0           #data:Ljava/lang/Object;
    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v2

    goto :goto_24
.end method

.method public getBatteryCapacity()D
    .registers 3

    .prologue
    .line 266
    const-string v0, "battery.capacity"

    invoke-virtual {p0, v0}, Lcom/android/internal/os/PowerProfile;->getAveragePower(Ljava/lang/String;)D

    move-result-wide v0

    return-wide v0
.end method

.method public getNumSpeedSteps()I
    .registers 4

    .prologue
    .line 274
    sget-object v1, Lcom/android/internal/os/PowerProfile;->sPowerMap:Ljava/util/HashMap;

    const-string v2, "cpu.speeds"

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 275
    .local v0, value:Ljava/lang/Object;
    if-eqz v0, :cond_14

    instance-of v1, v0, [Ljava/lang/Double;

    if-eqz v1, :cond_14

    .line 276
    check-cast v0, [Ljava/lang/Double;

    .end local v0           #value:Ljava/lang/Object;
    check-cast v0, [Ljava/lang/Double;

    array-length v1, v0

    .line 278
    :goto_13
    return v1

    .restart local v0       #value:Ljava/lang/Object;
    :cond_14
    const/4 v1, 0x1

    goto :goto_13
.end method
