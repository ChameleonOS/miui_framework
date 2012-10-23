.class Landroid/server/BluetoothAdapterProperties;
.super Ljava/lang/Object;
.source "BluetoothAdapterProperties.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "BluetoothAdapterProperties"


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mPropertiesMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final mService:Landroid/server/BluetoothService;


# direct methods
.method constructor <init>(Landroid/content/Context;Landroid/server/BluetoothService;)V
    .registers 4
    .parameter "context"
    .parameter "service"

    .prologue
    .line 33
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 34
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/server/BluetoothAdapterProperties;->mPropertiesMap:Ljava/util/Map;

    .line 35
    iput-object p1, p0, Landroid/server/BluetoothAdapterProperties;->mContext:Landroid/content/Context;

    .line 36
    iput-object p2, p0, Landroid/server/BluetoothAdapterProperties;->mService:Landroid/server/BluetoothService;

    .line 37
    return-void
.end method


# virtual methods
.method declared-synchronized clear()V
    .registers 2

    .prologue
    .line 51
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/server/BluetoothAdapterProperties;->mPropertiesMap:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V
    :try_end_6
    .catchall {:try_start_1 .. :try_end_6} :catchall_8

    .line 52
    monitor-exit p0

    return-void

    .line 51
    :catchall_8
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized getAllProperties()V
    .registers 14

    .prologue
    .line 63
    monitor-enter p0

    :try_start_1
    iget-object v9, p0, Landroid/server/BluetoothAdapterProperties;->mContext:Landroid/content/Context;

    const-string v10, "android.permission.BLUETOOTH"

    const-string v11, "Need BLUETOOTH permission"

    invoke-virtual {v9, v10, v11}, Landroid/content/Context;->enforceCallingOrSelfPermission(Ljava/lang/String;Ljava/lang/String;)V

    .line 66
    iget-object v9, p0, Landroid/server/BluetoothAdapterProperties;->mPropertiesMap:Ljava/util/Map;

    invoke-interface {v9}, Ljava/util/Map;->clear()V

    .line 68
    iget-object v9, p0, Landroid/server/BluetoothAdapterProperties;->mService:Landroid/server/BluetoothService;

    invoke-virtual {v9}, Landroid/server/BluetoothService;->getAdapterPropertiesNative()[Ljava/lang/Object;

    move-result-object v9

    check-cast v9, [Ljava/lang/String;

    move-object v0, v9

    check-cast v0, [Ljava/lang/String;

    move-object v7, v0

    .line 71
    .local v7, properties:[Ljava/lang/String;
    if-nez v7, :cond_26

    .line 72
    const-string v9, "BluetoothAdapterProperties"

    const-string v10, "*Error*: GetAdapterProperties returned NULL"

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_24
    .catchall {:try_start_1 .. :try_end_24} :catchall_8f

    .line 104
    :cond_24
    :goto_24
    monitor-exit p0

    return-void

    .line 76
    :cond_26
    const/4 v2, 0x0

    .local v2, i:I
    :goto_27
    :try_start_27
    array-length v9, v7

    if-ge v2, v9, :cond_97

    .line 77
    aget-object v5, v7, v2

    .line 78
    .local v5, name:Ljava/lang/String;
    const/4 v6, 0x0

    .line 79
    .local v6, newValue:Ljava/lang/String;
    if-nez v5, :cond_50

    .line 80
    const-string v9, "BluetoothAdapterProperties"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Error:Adapter Property at index "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, " is null"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 76
    :goto_4d
    add-int/lit8 v2, v2, 0x1

    goto :goto_27

    .line 83
    :cond_50
    const-string v9, "Devices"

    invoke-virtual {v5, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_60

    const-string v9, "UUIDs"

    invoke-virtual {v5, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_92

    .line 84
    :cond_60
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    .line 85
    .local v8, str:Ljava/lang/StringBuilder;
    add-int/lit8 v2, v2, 0x1

    aget-object v9, v7, v2

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Integer;->intValue()I

    move-result v4

    .line 86
    .local v4, len:I
    const/4 v3, 0x0

    .local v3, j:I
    :goto_72
    if-ge v3, v4, :cond_83

    .line 87
    add-int/lit8 v2, v2, 0x1

    aget-object v9, v7, v2

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 88
    const-string v9, ","

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 86
    add-int/lit8 v3, v3, 0x1

    goto :goto_72

    .line 90
    :cond_83
    if-lez v4, :cond_89

    .line 91
    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 96
    .end local v3           #j:I
    .end local v4           #len:I
    .end local v8           #str:Ljava/lang/StringBuilder;
    :cond_89
    :goto_89
    iget-object v9, p0, Landroid/server/BluetoothAdapterProperties;->mPropertiesMap:Ljava/util/Map;

    invoke-interface {v9, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_8e
    .catchall {:try_start_27 .. :try_end_8e} :catchall_8f

    goto :goto_4d

    .line 63
    .end local v2           #i:I
    .end local v5           #name:Ljava/lang/String;
    .end local v6           #newValue:Ljava/lang/String;
    .end local v7           #properties:[Ljava/lang/String;
    :catchall_8f
    move-exception v9

    monitor-exit p0

    throw v9

    .line 94
    .restart local v2       #i:I
    .restart local v5       #name:Ljava/lang/String;
    .restart local v6       #newValue:Ljava/lang/String;
    .restart local v7       #properties:[Ljava/lang/String;
    :cond_92
    add-int/lit8 v2, v2, 0x1

    :try_start_94
    aget-object v6, v7, v2

    goto :goto_89

    .line 100
    .end local v5           #name:Ljava/lang/String;
    .end local v6           #newValue:Ljava/lang/String;
    :cond_97
    iget-object v9, p0, Landroid/server/BluetoothAdapterProperties;->mService:Landroid/server/BluetoothService;

    invoke-virtual {v9}, Landroid/server/BluetoothService;->getAdapterPathNative()Ljava/lang/String;

    move-result-object v1

    .line 101
    .local v1, adapterPath:Ljava/lang/String;
    if-eqz v1, :cond_24

    .line 102
    iget-object v9, p0, Landroid/server/BluetoothAdapterProperties;->mPropertiesMap:Ljava/util/Map;

    const-string v10, "ObjectPath"

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v11, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "/dev_"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-interface {v9, v10, v11}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_b9
    .catchall {:try_start_94 .. :try_end_b9} :catchall_8f

    goto/16 :goto_24
.end method

.method getObjectPath()Ljava/lang/String;
    .registers 2

    .prologue
    .line 47
    const-string v0, "ObjectPath"

    invoke-virtual {p0, v0}, Landroid/server/BluetoothAdapterProperties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method declared-synchronized getProperty(Ljava/lang/String;)Ljava/lang/String;
    .registers 3
    .parameter "name"

    .prologue
    .line 40
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/server/BluetoothAdapterProperties;->mPropertiesMap:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_c

    .line 41
    invoke-virtual {p0}, Landroid/server/BluetoothAdapterProperties;->getAllProperties()V

    .line 43
    :cond_c
    iget-object v0, p0, Landroid/server/BluetoothAdapterProperties;->mPropertiesMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;
    :try_end_14
    .catchall {:try_start_1 .. :try_end_14} :catchall_16

    monitor-exit p0

    return-object v0

    .line 40
    :catchall_16
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized isEmpty()Z
    .registers 2

    .prologue
    .line 55
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/server/BluetoothAdapterProperties;->mPropertiesMap:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->isEmpty()Z
    :try_end_6
    .catchall {:try_start_1 .. :try_end_6} :catchall_9

    move-result v0

    monitor-exit p0

    return v0

    :catchall_9
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized setProperty(Ljava/lang/String;Ljava/lang/String;)V
    .registers 4
    .parameter "name"
    .parameter "value"

    .prologue
    .line 59
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/server/BluetoothAdapterProperties;->mPropertiesMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_6
    .catchall {:try_start_1 .. :try_end_6} :catchall_8

    .line 60
    monitor-exit p0

    return-void

    .line 59
    :catchall_8
    move-exception v0

    monitor-exit p0

    throw v0
.end method
