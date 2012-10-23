.class Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;
.super Ljava/lang/Object;
.source "WifiConfigStore.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/wifi/WifiConfigStore;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "DelayedDiskWrite"
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "DelayedDiskWrite"

.field private static sDiskWriteHandler:Landroid/os/Handler;

.field private static sDiskWriteHandlerThread:Landroid/os/HandlerThread;

.field private static sWriteSequence:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 692
    const/4 v0, 0x0

    sput v0, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;->sWriteSequence:I

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .prologue
    .line 687
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000(Ljava/util/List;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 687
    invoke-static {p0}, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;->onWriteCalled(Ljava/util/List;)V

    return-void
.end method

.method private static loge(Ljava/lang/String;)V
    .registers 2
    .parameter "s"

    .prologue
    .line 830
    const-string v0, "DelayedDiskWrite"

    invoke-static {v0, p0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 831
    return-void
.end method

.method private static onWriteCalled(Ljava/util/List;)V
    .registers 18
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Landroid/net/wifi/WifiConfiguration;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 716
    .local p0, networks:Ljava/util/List;,"Ljava/util/List<Landroid/net/wifi/WifiConfiguration;>;"
    const/4 v9, 0x0

    .line 718
    .local v9, out:Ljava/io/DataOutputStream;
    :try_start_1
    new-instance v10, Ljava/io/DataOutputStream;

    new-instance v14, Ljava/io/BufferedOutputStream;

    new-instance v15, Ljava/io/FileOutputStream;

    invoke-static {}, Landroid/net/wifi/WifiConfigStore;->access$100()Ljava/lang/String;

    move-result-object v16

    invoke-direct/range {v15 .. v16}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    invoke-direct {v14, v15}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;)V

    invoke-direct {v10, v14}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_14
    .catchall {:try_start_1 .. :try_end_14} :catchall_216
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_14} :catch_219

    .line 721
    .end local v9           #out:Ljava/io/DataOutputStream;
    .local v10, out:Ljava/io/DataOutputStream;
    const/4 v14, 0x2

    :try_start_15
    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 723
    invoke-interface/range {p0 .. p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_1c
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v14

    if-eqz v14, :cond_1e2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/wifi/WifiConfiguration;
    :try_end_28
    .catchall {:try_start_15 .. :try_end_28} :catchall_e5
    .catch Ljava/io/IOException; {:try_start_15 .. :try_end_28} :catch_63

    .line 724
    .local v0, config:Landroid/net/wifi/WifiConfiguration;
    const/4 v13, 0x0

    .line 727
    .local v13, writeToFile:Z
    :try_start_29
    iget-object v8, v0, Landroid/net/wifi/WifiConfiguration;->linkProperties:Landroid/net/LinkProperties;

    .line 728
    .local v8, linkProperties:Landroid/net/LinkProperties;
    sget-object v14, Landroid/net/wifi/WifiConfigStore$1;->$SwitchMap$android$net$wifi$WifiConfiguration$IpAssignment:[I

    iget-object v15, v0, Landroid/net/wifi/WifiConfiguration;->ipAssignment:Landroid/net/wifi/WifiConfiguration$IpAssignment;

    invoke-virtual {v15}, Landroid/net/wifi/WifiConfiguration$IpAssignment;->ordinal()I

    move-result v15

    aget v14, v14, v15

    packed-switch v14, :pswitch_data_21c

    .line 769
    const-string v14, "Ignore invalid ip assignment while writing"

    invoke-static {v14}, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;->loge(Ljava/lang/String;)V

    .line 773
    :goto_3d
    :pswitch_3d
    sget-object v14, Landroid/net/wifi/WifiConfigStore$1;->$SwitchMap$android$net$wifi$WifiConfiguration$ProxySettings:[I

    iget-object v15, v0, Landroid/net/wifi/WifiConfiguration;->proxySettings:Landroid/net/wifi/WifiConfiguration$ProxySettings;

    invoke-virtual {v15}, Landroid/net/wifi/WifiConfiguration$ProxySettings;->ordinal()I

    move-result v15

    aget v14, v14, v15

    packed-switch v14, :pswitch_data_226

    .line 796
    const-string v14, "Ignthisore invalid proxy settings while writing"

    invoke-static {v14}, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;->loge(Ljava/lang/String;)V

    .line 799
    :goto_4f
    :pswitch_4f
    if-eqz v13, :cond_5d

    .line 800
    const-string v14, "id"

    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeUTF(Ljava/lang/String;)V

    .line 801
    #calls: Landroid/net/wifi/WifiConfigStore;->configKey(Landroid/net/wifi/WifiConfiguration;)I
    invoke-static {v0}, Landroid/net/wifi/WifiConfigStore;->access$200(Landroid/net/wifi/WifiConfiguration;)I

    move-result v14

    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeInt(I)V
    :try_end_5d
    .catchall {:try_start_29 .. :try_end_5d} :catchall_e5
    .catch Ljava/lang/NullPointerException; {:try_start_29 .. :try_end_5d} :catch_c6
    .catch Ljava/io/IOException; {:try_start_29 .. :try_end_5d} :catch_63

    .line 806
    .end local v8           #linkProperties:Landroid/net/LinkProperties;
    :cond_5d
    :goto_5d
    :try_start_5d
    const-string v14, "eos"

    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeUTF(Ljava/lang/String;)V
    :try_end_62
    .catchall {:try_start_5d .. :try_end_62} :catchall_e5
    .catch Ljava/io/IOException; {:try_start_5d .. :try_end_62} :catch_63

    goto :goto_1c

    .line 809
    .end local v0           #config:Landroid/net/wifi/WifiConfiguration;
    .end local v13           #writeToFile:Z
    :catch_63
    move-exception v2

    move-object v9, v10

    .line 810
    .end local v10           #out:Ljava/io/DataOutputStream;
    .local v2, e:Ljava/io/IOException;
    .restart local v9       #out:Ljava/io/DataOutputStream;
    :goto_65
    :try_start_65
    const-string v14, "Error writing data file"

    invoke-static {v14}, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;->loge(Ljava/lang/String;)V
    :try_end_6a
    .catchall {:try_start_65 .. :try_end_6a} :catchall_216

    .line 812
    if-eqz v9, :cond_6f

    .line 814
    :try_start_6c
    invoke-virtual {v9}, Ljava/io/DataOutputStream;->close()V
    :try_end_6f
    .catch Ljava/lang/Exception; {:try_start_6c .. :try_end_6f} :catch_20b

    .line 819
    :cond_6f
    :goto_6f
    const-class v15, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;

    monitor-enter v15

    .line 820
    :try_start_72
    sget v14, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;->sWriteSequence:I

    add-int/lit8 v14, v14, -0x1

    sput v14, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;->sWriteSequence:I

    if-nez v14, :cond_89

    .line 821
    sget-object v14, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;->sDiskWriteHandler:Landroid/os/Handler;

    invoke-virtual {v14}, Landroid/os/Handler;->getLooper()Landroid/os/Looper;

    move-result-object v14

    invoke-virtual {v14}, Landroid/os/Looper;->quit()V

    .line 822
    const/4 v14, 0x0

    sput-object v14, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;->sDiskWriteHandler:Landroid/os/Handler;

    .line 823
    const/4 v14, 0x0

    sput-object v14, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;->sDiskWriteHandlerThread:Landroid/os/HandlerThread;

    .line 825
    :cond_89
    monitor-exit v15
    :try_end_8a
    .catchall {:try_start_72 .. :try_end_8a} :catchall_20e

    .line 827
    .end local v2           #e:Ljava/io/IOException;
    :goto_8a
    return-void

    .line 730
    .end local v9           #out:Ljava/io/DataOutputStream;
    .restart local v0       #config:Landroid/net/wifi/WifiConfiguration;
    .restart local v8       #linkProperties:Landroid/net/LinkProperties;
    .restart local v10       #out:Ljava/io/DataOutputStream;
    .restart local v13       #writeToFile:Z
    :pswitch_8b
    :try_start_8b
    const-string v14, "ipAssignment"

    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeUTF(Ljava/lang/String;)V

    .line 731
    iget-object v14, v0, Landroid/net/wifi/WifiConfiguration;->ipAssignment:Landroid/net/wifi/WifiConfiguration$IpAssignment;

    invoke-virtual {v14}, Landroid/net/wifi/WifiConfiguration$IpAssignment;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeUTF(Ljava/lang/String;)V

    .line 732
    invoke-virtual {v8}, Landroid/net/LinkProperties;->getLinkAddresses()Ljava/util/Collection;

    move-result-object v14

    invoke-interface {v14}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .local v5, i$:Ljava/util/Iterator;
    :goto_a1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v14

    if-eqz v14, :cond_10a

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/net/LinkAddress;

    .line 733
    .local v7, linkAddr:Landroid/net/LinkAddress;
    const-string/jumbo v14, "linkAddress"

    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeUTF(Ljava/lang/String;)V

    .line 734
    invoke-virtual {v7}, Landroid/net/LinkAddress;->getAddress()Ljava/net/InetAddress;

    move-result-object v14

    invoke-virtual {v14}, Ljava/net/InetAddress;->getHostAddress()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeUTF(Ljava/lang/String;)V

    .line 735
    invoke-virtual {v7}, Landroid/net/LinkAddress;->getNetworkPrefixLength()I

    move-result v14

    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeInt(I)V
    :try_end_c5
    .catchall {:try_start_8b .. :try_end_c5} :catchall_e5
    .catch Ljava/lang/NullPointerException; {:try_start_8b .. :try_end_c5} :catch_c6
    .catch Ljava/io/IOException; {:try_start_8b .. :try_end_c5} :catch_63

    goto :goto_a1

    .line 803
    .end local v5           #i$:Ljava/util/Iterator;
    .end local v7           #linkAddr:Landroid/net/LinkAddress;
    .end local v8           #linkProperties:Landroid/net/LinkProperties;
    :catch_c6
    move-exception v2

    .line 804
    .local v2, e:Ljava/lang/NullPointerException;
    :try_start_c7
    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    const-string v15, "Failure in writing "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    iget-object v15, v0, Landroid/net/wifi/WifiConfiguration;->linkProperties:Landroid/net/LinkProperties;

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-static {v14}, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;->loge(Ljava/lang/String;)V
    :try_end_e3
    .catchall {:try_start_c7 .. :try_end_e3} :catchall_e5
    .catch Ljava/io/IOException; {:try_start_c7 .. :try_end_e3} :catch_63

    goto/16 :goto_5d

    .line 812
    .end local v0           #config:Landroid/net/wifi/WifiConfiguration;
    .end local v2           #e:Ljava/lang/NullPointerException;
    .end local v13           #writeToFile:Z
    :catchall_e5
    move-exception v14

    move-object v9, v10

    .end local v10           #out:Ljava/io/DataOutputStream;
    .restart local v9       #out:Ljava/io/DataOutputStream;
    :goto_e7
    if-eqz v9, :cond_ec

    .line 814
    :try_start_e9
    invoke-virtual {v9}, Ljava/io/DataOutputStream;->close()V
    :try_end_ec
    .catch Ljava/lang/Exception; {:try_start_e9 .. :try_end_ec} :catch_205

    .line 819
    :cond_ec
    :goto_ec
    const-class v15, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;

    monitor-enter v15

    .line 820
    :try_start_ef
    sget v16, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;->sWriteSequence:I

    add-int/lit8 v16, v16, -0x1

    sput v16, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;->sWriteSequence:I

    if-nez v16, :cond_108

    .line 821
    sget-object v16, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;->sDiskWriteHandler:Landroid/os/Handler;

    invoke-virtual/range {v16 .. v16}, Landroid/os/Handler;->getLooper()Landroid/os/Looper;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/os/Looper;->quit()V

    .line 822
    const/16 v16, 0x0

    sput-object v16, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;->sDiskWriteHandler:Landroid/os/Handler;

    .line 823
    const/16 v16, 0x0

    sput-object v16, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;->sDiskWriteHandlerThread:Landroid/os/HandlerThread;

    .line 825
    :cond_108
    monitor-exit v15
    :try_end_109
    .catchall {:try_start_ef .. :try_end_109} :catchall_208

    .line 812
    throw v14

    .line 737
    .end local v9           #out:Ljava/io/DataOutputStream;
    .restart local v0       #config:Landroid/net/wifi/WifiConfiguration;
    .restart local v5       #i$:Ljava/util/Iterator;
    .restart local v8       #linkProperties:Landroid/net/LinkProperties;
    .restart local v10       #out:Ljava/io/DataOutputStream;
    .restart local v13       #writeToFile:Z
    :cond_10a
    :try_start_10a
    invoke-virtual {v8}, Landroid/net/LinkProperties;->getRoutes()Ljava/util/Collection;

    move-result-object v14

    invoke-interface {v14}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_112
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v14

    if-eqz v14, :cond_15f

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Landroid/net/RouteInfo;

    .line 738
    .local v12, route:Landroid/net/RouteInfo;
    const-string v14, "gateway"

    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeUTF(Ljava/lang/String;)V

    .line 739
    invoke-virtual {v12}, Landroid/net/RouteInfo;->getDestination()Landroid/net/LinkAddress;

    move-result-object v1

    .line 740
    .local v1, dest:Landroid/net/LinkAddress;
    if-eqz v1, :cond_155

    .line 741
    const/4 v14, 0x1

    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 742
    invoke-virtual {v1}, Landroid/net/LinkAddress;->getAddress()Ljava/net/InetAddress;

    move-result-object v14

    invoke-virtual {v14}, Ljava/net/InetAddress;->getHostAddress()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeUTF(Ljava/lang/String;)V

    .line 743
    invoke-virtual {v1}, Landroid/net/LinkAddress;->getNetworkPrefixLength()I

    move-result v14

    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 747
    :goto_13f
    invoke-virtual {v12}, Landroid/net/RouteInfo;->getGateway()Ljava/net/InetAddress;

    move-result-object v14

    if-eqz v14, :cond_15a

    .line 748
    const/4 v14, 0x1

    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 749
    invoke-virtual {v12}, Landroid/net/RouteInfo;->getGateway()Ljava/net/InetAddress;

    move-result-object v14

    invoke-virtual {v14}, Ljava/net/InetAddress;->getHostAddress()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeUTF(Ljava/lang/String;)V

    goto :goto_112

    .line 745
    :cond_155
    const/4 v14, 0x0

    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeInt(I)V

    goto :goto_13f

    .line 751
    :cond_15a
    const/4 v14, 0x0

    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeInt(I)V

    goto :goto_112

    .line 754
    .end local v1           #dest:Landroid/net/LinkAddress;
    .end local v12           #route:Landroid/net/RouteInfo;
    :cond_15f
    invoke-virtual {v8}, Landroid/net/LinkProperties;->getDnses()Ljava/util/Collection;

    move-result-object v14

    invoke-interface {v14}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_167
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v14

    if-eqz v14, :cond_180

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/net/InetAddress;

    .line 755
    .local v6, inetAddr:Ljava/net/InetAddress;
    const-string v14, "dns"

    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeUTF(Ljava/lang/String;)V

    .line 756
    invoke-virtual {v6}, Ljava/net/InetAddress;->getHostAddress()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeUTF(Ljava/lang/String;)V

    goto :goto_167

    .line 758
    .end local v6           #inetAddr:Ljava/net/InetAddress;
    :cond_180
    const/4 v13, 0x1

    .line 759
    goto/16 :goto_3d

    .line 761
    .end local v5           #i$:Ljava/util/Iterator;
    :pswitch_183
    const-string v14, "ipAssignment"

    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeUTF(Ljava/lang/String;)V

    .line 762
    iget-object v14, v0, Landroid/net/wifi/WifiConfiguration;->ipAssignment:Landroid/net/wifi/WifiConfiguration$IpAssignment;

    invoke-virtual {v14}, Landroid/net/wifi/WifiConfiguration$IpAssignment;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeUTF(Ljava/lang/String;)V

    .line 763
    const/4 v13, 0x1

    .line 764
    goto/16 :goto_3d

    .line 775
    :pswitch_194
    invoke-virtual {v8}, Landroid/net/LinkProperties;->getHttpProxy()Landroid/net/ProxyProperties;

    move-result-object v11

    .line 776
    .local v11, proxyProperties:Landroid/net/ProxyProperties;
    invoke-virtual {v11}, Landroid/net/ProxyProperties;->getExclusionList()Ljava/lang/String;

    move-result-object v3

    .line 777
    .local v3, exclusionList:Ljava/lang/String;
    const-string/jumbo v14, "proxySettings"

    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeUTF(Ljava/lang/String;)V

    .line 778
    iget-object v14, v0, Landroid/net/wifi/WifiConfiguration;->proxySettings:Landroid/net/wifi/WifiConfiguration$ProxySettings;

    invoke-virtual {v14}, Landroid/net/wifi/WifiConfiguration$ProxySettings;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeUTF(Ljava/lang/String;)V

    .line 779
    const-string/jumbo v14, "proxyHost"

    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeUTF(Ljava/lang/String;)V

    .line 780
    invoke-virtual {v11}, Landroid/net/ProxyProperties;->getHost()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeUTF(Ljava/lang/String;)V

    .line 781
    const-string/jumbo v14, "proxyPort"

    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeUTF(Ljava/lang/String;)V

    .line 782
    invoke-virtual {v11}, Landroid/net/ProxyProperties;->getPort()I

    move-result v14

    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 783
    const-string v14, "exclusionList"

    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeUTF(Ljava/lang/String;)V

    .line 784
    invoke-virtual {v10, v3}, Ljava/io/DataOutputStream;->writeUTF(Ljava/lang/String;)V

    .line 785
    const/4 v13, 0x1

    .line 786
    goto/16 :goto_4f

    .line 788
    .end local v3           #exclusionList:Ljava/lang/String;
    .end local v11           #proxyProperties:Landroid/net/ProxyProperties;
    :pswitch_1d0
    const-string/jumbo v14, "proxySettings"

    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeUTF(Ljava/lang/String;)V

    .line 789
    iget-object v14, v0, Landroid/net/wifi/WifiConfiguration;->proxySettings:Landroid/net/wifi/WifiConfiguration$ProxySettings;

    invoke-virtual {v14}, Landroid/net/wifi/WifiConfiguration$ProxySettings;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v10, v14}, Ljava/io/DataOutputStream;->writeUTF(Ljava/lang/String;)V
    :try_end_1df
    .catchall {:try_start_10a .. :try_end_1df} :catchall_e5
    .catch Ljava/lang/NullPointerException; {:try_start_10a .. :try_end_1df} :catch_c6
    .catch Ljava/io/IOException; {:try_start_10a .. :try_end_1df} :catch_63

    .line 790
    const/4 v13, 0x1

    .line 791
    goto/16 :goto_4f

    .line 812
    .end local v0           #config:Landroid/net/wifi/WifiConfiguration;
    .end local v8           #linkProperties:Landroid/net/LinkProperties;
    .end local v13           #writeToFile:Z
    :cond_1e2
    if-eqz v10, :cond_1e7

    .line 814
    :try_start_1e4
    invoke-virtual {v10}, Ljava/io/DataOutputStream;->close()V
    :try_end_1e7
    .catch Ljava/lang/Exception; {:try_start_1e4 .. :try_end_1e7} :catch_211

    .line 819
    :cond_1e7
    :goto_1e7
    const-class v15, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;

    monitor-enter v15

    .line 820
    :try_start_1ea
    sget v14, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;->sWriteSequence:I

    add-int/lit8 v14, v14, -0x1

    sput v14, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;->sWriteSequence:I

    if-nez v14, :cond_201

    .line 821
    sget-object v14, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;->sDiskWriteHandler:Landroid/os/Handler;

    invoke-virtual {v14}, Landroid/os/Handler;->getLooper()Landroid/os/Looper;

    move-result-object v14

    invoke-virtual {v14}, Landroid/os/Looper;->quit()V

    .line 822
    const/4 v14, 0x0

    sput-object v14, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;->sDiskWriteHandler:Landroid/os/Handler;

    .line 823
    const/4 v14, 0x0

    sput-object v14, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;->sDiskWriteHandlerThread:Landroid/os/HandlerThread;

    .line 825
    :cond_201
    monitor-exit v15
    :try_end_202
    .catchall {:try_start_1ea .. :try_end_202} :catchall_213

    move-object v9, v10

    .line 826
    .end local v10           #out:Ljava/io/DataOutputStream;
    .restart local v9       #out:Ljava/io/DataOutputStream;
    goto/16 :goto_8a

    .line 815
    :catch_205
    move-exception v15

    goto/16 :goto_ec

    .line 825
    :catchall_208
    move-exception v14

    :try_start_209
    monitor-exit v15
    :try_end_20a
    .catchall {:try_start_209 .. :try_end_20a} :catchall_208

    throw v14

    .line 815
    .local v2, e:Ljava/io/IOException;
    :catch_20b
    move-exception v14

    goto/16 :goto_6f

    .line 825
    :catchall_20e
    move-exception v14

    :try_start_20f
    monitor-exit v15
    :try_end_210
    .catchall {:try_start_20f .. :try_end_210} :catchall_20e

    throw v14

    .line 815
    .end local v2           #e:Ljava/io/IOException;
    .end local v9           #out:Ljava/io/DataOutputStream;
    .restart local v10       #out:Ljava/io/DataOutputStream;
    :catch_211
    move-exception v14

    goto :goto_1e7

    .line 825
    :catchall_213
    move-exception v14

    :try_start_214
    monitor-exit v15
    :try_end_215
    .catchall {:try_start_214 .. :try_end_215} :catchall_213

    throw v14

    .line 812
    .end local v10           #out:Ljava/io/DataOutputStream;
    .restart local v9       #out:Ljava/io/DataOutputStream;
    :catchall_216
    move-exception v14

    goto/16 :goto_e7

    .line 809
    :catch_219
    move-exception v2

    goto/16 :goto_65

    .line 728
    :pswitch_data_21c
    .packed-switch 0x1
        :pswitch_8b
        :pswitch_183
        :pswitch_3d
    .end packed-switch

    .line 773
    :pswitch_data_226
    .packed-switch 0x1
        :pswitch_194
        :pswitch_1d0
        :pswitch_4f
    .end packed-switch
.end method

.method static write(Ljava/util/List;)V
    .registers 4
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Landroid/net/wifi/WifiConfiguration;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 698
    .local p0, networks:Ljava/util/List;,"Ljava/util/List<Landroid/net/wifi/WifiConfiguration;>;"
    const-class v1, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;

    monitor-enter v1

    .line 699
    :try_start_3
    sget v0, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;->sWriteSequence:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;->sWriteSequence:I

    const/4 v2, 0x1

    if-ne v0, v2, :cond_27

    .line 700
    new-instance v0, Landroid/os/HandlerThread;

    const-string v2, "WifiConfigThread"

    invoke-direct {v0, v2}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;)V

    sput-object v0, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;->sDiskWriteHandlerThread:Landroid/os/HandlerThread;

    .line 701
    sget-object v0, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;->sDiskWriteHandlerThread:Landroid/os/HandlerThread;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->start()V

    .line 702
    new-instance v0, Landroid/os/Handler;

    sget-object v2, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;->sDiskWriteHandlerThread:Landroid/os/HandlerThread;

    invoke-virtual {v2}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-direct {v0, v2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    sput-object v0, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;->sDiskWriteHandler:Landroid/os/Handler;

    .line 704
    :cond_27
    monitor-exit v1
    :try_end_28
    .catchall {:try_start_3 .. :try_end_28} :catchall_33

    .line 706
    sget-object v0, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite;->sDiskWriteHandler:Landroid/os/Handler;

    new-instance v1, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite$1;

    invoke-direct {v1, p0}, Landroid/net/wifi/WifiConfigStore$DelayedDiskWrite$1;-><init>(Ljava/util/List;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 712
    return-void

    .line 704
    :catchall_33
    move-exception v0

    :try_start_34
    monitor-exit v1
    :try_end_35
    .catchall {:try_start_34 .. :try_end_35} :catchall_33

    throw v0
.end method
