.class public Landroid/net/EthernetDataTracker;
.super Ljava/lang/Object;
.source "EthernetDataTracker.java"

# interfaces
.implements Landroid/net/NetworkStateTracker;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/net/EthernetDataTracker$InterfaceObserver;
    }
.end annotation


# static fields
.field private static final NETWORKTYPE:Ljava/lang/String; = "ETHERNET"

.field private static final TAG:Ljava/lang/String; = "Ethernet"

.field private static mIface:Ljava/lang/String;

.field private static mLinkUp:Z

.field private static sIfaceMatch:Ljava/lang/String;

.field private static sInstance:Landroid/net/EthernetDataTracker;


# instance fields
.field private mContext:Landroid/content/Context;

.field private mCsHandler:Landroid/os/Handler;

.field private mDefaultGatewayAddr:Ljava/util/concurrent/atomic/AtomicInteger;

.field private mDefaultRouteSet:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private mHwAddr:Ljava/lang/String;

.field private mInterfaceObserver:Landroid/net/EthernetDataTracker$InterfaceObserver;

.field private mLinkCapabilities:Landroid/net/LinkCapabilities;

.field private mLinkProperties:Landroid/net/LinkProperties;

.field private mNMService:Landroid/os/INetworkManagementService;

.field private mNetworkInfo:Landroid/net/NetworkInfo;

.field private mPrivateDnsRouteSet:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private mTeardownRequested:Ljava/util/concurrent/atomic/AtomicBoolean;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    const-string v0, ""

    sput-object v0, Landroid/net/EthernetDataTracker;->sIfaceMatch:Ljava/lang/String;

    const-string v0, ""

    sput-object v0, Landroid/net/EthernetDataTracker;->mIface:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .registers 6

    .prologue
    const/4 v4, 0x0

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v0, v4}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Landroid/net/EthernetDataTracker;->mTeardownRequested:Ljava/util/concurrent/atomic/AtomicBoolean;

    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v0, v4}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Landroid/net/EthernetDataTracker;->mPrivateDnsRouteSet:Ljava/util/concurrent/atomic/AtomicBoolean;

    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-direct {v0, v4}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object v0, p0, Landroid/net/EthernetDataTracker;->mDefaultGatewayAddr:Ljava/util/concurrent/atomic/AtomicInteger;

    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v0, v4}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Landroid/net/EthernetDataTracker;->mDefaultRouteSet:Ljava/util/concurrent/atomic/AtomicBoolean;

    new-instance v0, Landroid/net/NetworkInfo;

    const/16 v1, 0x9

    const-string v2, "ETHERNET"

    const-string v3, ""

    invoke-direct {v0, v1, v4, v2, v3}, Landroid/net/NetworkInfo;-><init>(IILjava/lang/String;Ljava/lang/String;)V

    iput-object v0, p0, Landroid/net/EthernetDataTracker;->mNetworkInfo:Landroid/net/NetworkInfo;

    new-instance v0, Landroid/net/LinkProperties;

    invoke-direct {v0}, Landroid/net/LinkProperties;-><init>()V

    iput-object v0, p0, Landroid/net/EthernetDataTracker;->mLinkProperties:Landroid/net/LinkProperties;

    new-instance v0, Landroid/net/LinkCapabilities;

    invoke-direct {v0}, Landroid/net/LinkCapabilities;-><init>()V

    iput-object v0, p0, Landroid/net/EthernetDataTracker;->mLinkCapabilities:Landroid/net/LinkCapabilities;

    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .registers 1

    .prologue
    sget-object v0, Landroid/net/EthernetDataTracker;->mIface:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100()Z
    .registers 1

    .prologue
    sget-boolean v0, Landroid/net/EthernetDataTracker;->mLinkUp:Z

    return v0
.end method

.method static synthetic access$102(Z)Z
    .registers 1
    .parameter "x0"

    .prologue
    sput-boolean p0, Landroid/net/EthernetDataTracker;->mLinkUp:Z

    return p0
.end method

.method static synthetic access$200(Landroid/net/EthernetDataTracker;)Landroid/net/NetworkInfo;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/net/EthernetDataTracker;->mNetworkInfo:Landroid/net/NetworkInfo;

    return-object v0
.end method

.method static synthetic access$300(Landroid/net/EthernetDataTracker;Ljava/lang/String;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Landroid/net/EthernetDataTracker;->interfaceAdded(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$400(Landroid/net/EthernetDataTracker;Ljava/lang/String;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Landroid/net/EthernetDataTracker;->interfaceRemoved(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$500(Landroid/net/EthernetDataTracker;)Landroid/net/LinkProperties;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/net/EthernetDataTracker;->mLinkProperties:Landroid/net/LinkProperties;

    return-object v0
.end method

.method static synthetic access$502(Landroid/net/EthernetDataTracker;Landroid/net/LinkProperties;)Landroid/net/LinkProperties;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput-object p1, p0, Landroid/net/EthernetDataTracker;->mLinkProperties:Landroid/net/LinkProperties;

    return-object p1
.end method

.method static synthetic access$600(Landroid/net/EthernetDataTracker;)Ljava/lang/String;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/net/EthernetDataTracker;->mHwAddr:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$700(Landroid/net/EthernetDataTracker;)Landroid/os/Handler;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/net/EthernetDataTracker;->mCsHandler:Landroid/os/Handler;

    return-object v0
.end method

.method public static declared-synchronized getInstance()Landroid/net/EthernetDataTracker;
    .registers 2

    .prologue
    const-class v1, Landroid/net/EthernetDataTracker;

    monitor-enter v1

    :try_start_3
    sget-object v0, Landroid/net/EthernetDataTracker;->sInstance:Landroid/net/EthernetDataTracker;

    if-nez v0, :cond_e

    new-instance v0, Landroid/net/EthernetDataTracker;

    invoke-direct {v0}, Landroid/net/EthernetDataTracker;-><init>()V

    sput-object v0, Landroid/net/EthernetDataTracker;->sInstance:Landroid/net/EthernetDataTracker;

    :cond_e
    sget-object v0, Landroid/net/EthernetDataTracker;->sInstance:Landroid/net/EthernetDataTracker;
    :try_end_10
    .catchall {:try_start_3 .. :try_end_10} :catchall_12

    monitor-exit v1

    return-object v0

    :catchall_12
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private interfaceAdded(Ljava/lang/String;)V
    .registers 7
    .parameter "iface"

    .prologue
    sget-object v2, Landroid/net/EthernetDataTracker;->sIfaceMatch:Ljava/lang/String;

    invoke-virtual {p1, v2}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_9

    :goto_8
    return-void

    :cond_9
    const-string v2, "Ethernet"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Adding "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    monitor-enter p0

    :try_start_22
    sget-object v2, Landroid/net/EthernetDataTracker;->mIface:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_2f

    monitor-exit p0

    goto :goto_8

    :catchall_2c
    move-exception v2

    monitor-exit p0
    :try_end_2e
    .catchall {:try_start_22 .. :try_end_2e} :catchall_2c

    throw v2

    :cond_2f
    :try_start_2f
    sput-object p1, Landroid/net/EthernetDataTracker;->mIface:Ljava/lang/String;

    monitor-exit p0
    :try_end_32
    .catchall {:try_start_2f .. :try_end_32} :catchall_2c

    :try_start_32
    iget-object v2, p0, Landroid/net/EthernetDataTracker;->mNMService:Landroid/os/INetworkManagementService;

    invoke-interface {v2, p1}, Landroid/os/INetworkManagementService;->setInterfaceUp(Ljava/lang/String;)V
    :try_end_37
    .catch Ljava/lang/Exception; {:try_start_32 .. :try_end_37} :catch_4a

    :goto_37
    iget-object v2, p0, Landroid/net/EthernetDataTracker;->mNetworkInfo:Landroid/net/NetworkInfo;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/net/NetworkInfo;->setIsAvailable(Z)V

    iget-object v2, p0, Landroid/net/EthernetDataTracker;->mCsHandler:Landroid/os/Handler;

    const/4 v3, 0x3

    iget-object v4, p0, Landroid/net/EthernetDataTracker;->mNetworkInfo:Landroid/net/NetworkInfo;

    invoke-virtual {v2, v3, v4}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    .local v1, msg:Landroid/os/Message;
    invoke-virtual {v1}, Landroid/os/Message;->sendToTarget()V

    goto :goto_8

    .end local v1           #msg:Landroid/os/Message;
    :catch_4a
    move-exception v0

    .local v0, e:Ljava/lang/Exception;
    const-string v2, "Ethernet"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Error upping interface "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ": "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_37
.end method

.method private interfaceRemoved(Ljava/lang/String;)V
    .registers 5
    .parameter "iface"

    .prologue
    sget-object v0, Landroid/net/EthernetDataTracker;->mIface:Ljava/lang/String;

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_9

    :goto_8
    return-void

    :cond_9
    const-string v0, "Ethernet"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Removing "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    invoke-virtual {p0}, Landroid/net/EthernetDataTracker;->disconnect()V

    const-string v0, ""

    sput-object v0, Landroid/net/EthernetDataTracker;->mIface:Ljava/lang/String;

    goto :goto_8
.end method

.method private runDhcp()V
    .registers 3

    .prologue
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Landroid/net/EthernetDataTracker$1;

    invoke-direct {v1, p0}, Landroid/net/EthernetDataTracker$1;-><init>(Landroid/net/EthernetDataTracker;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .local v0, dhcpThread:Ljava/lang/Thread;
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    return-void
.end method


# virtual methods
.method public Clone()Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    new-instance v0, Ljava/lang/CloneNotSupportedException;

    invoke-direct {v0}, Ljava/lang/CloneNotSupportedException;-><init>()V

    throw v0
.end method

.method public defaultRouteSet(Z)V
    .registers 3
    .parameter "enabled"

    .prologue
    iget-object v0, p0, Landroid/net/EthernetDataTracker;->mDefaultRouteSet:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    return-void
.end method

.method public disconnect()V
    .registers 9

    .prologue
    sget-object v4, Landroid/net/EthernetDataTracker;->mIface:Ljava/lang/String;

    invoke-static {v4}, Landroid/net/NetworkUtils;->stopDhcp(Ljava/lang/String;)Z

    iget-object v4, p0, Landroid/net/EthernetDataTracker;->mLinkProperties:Landroid/net/LinkProperties;

    invoke-virtual {v4}, Landroid/net/LinkProperties;->clear()V

    iget-object v4, p0, Landroid/net/EthernetDataTracker;->mNetworkInfo:Landroid/net/NetworkInfo;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Landroid/net/NetworkInfo;->setIsAvailable(Z)V

    iget-object v4, p0, Landroid/net/EthernetDataTracker;->mNetworkInfo:Landroid/net/NetworkInfo;

    sget-object v5, Landroid/net/NetworkInfo$DetailedState;->DISCONNECTED:Landroid/net/NetworkInfo$DetailedState;

    const/4 v6, 0x0

    iget-object v7, p0, Landroid/net/EthernetDataTracker;->mHwAddr:Ljava/lang/String;

    invoke-virtual {v4, v5, v6, v7}, Landroid/net/NetworkInfo;->setDetailedState(Landroid/net/NetworkInfo$DetailedState;Ljava/lang/String;Ljava/lang/String;)V

    iget-object v4, p0, Landroid/net/EthernetDataTracker;->mCsHandler:Landroid/os/Handler;

    const/4 v5, 0x3

    iget-object v6, p0, Landroid/net/EthernetDataTracker;->mNetworkInfo:Landroid/net/NetworkInfo;

    invoke-virtual {v4, v5, v6}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v2

    .local v2, msg:Landroid/os/Message;
    invoke-virtual {v2}, Landroid/os/Message;->sendToTarget()V

    iget-object v4, p0, Landroid/net/EthernetDataTracker;->mCsHandler:Landroid/os/Handler;

    const/4 v5, 0x1

    iget-object v6, p0, Landroid/net/EthernetDataTracker;->mNetworkInfo:Landroid/net/NetworkInfo;

    invoke-virtual {v4, v5, v6}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v2

    invoke-virtual {v2}, Landroid/os/Message;->sendToTarget()V

    const-string/jumbo v4, "network_management"

    invoke-static {v4}, Landroid/os/ServiceManager;->getService(Ljava/lang/String;)Landroid/os/IBinder;

    move-result-object v0

    .local v0, b:Landroid/os/IBinder;
    invoke-static {v0}, Landroid/os/INetworkManagementService$Stub;->asInterface(Landroid/os/IBinder;)Landroid/os/INetworkManagementService;

    move-result-object v3

    .local v3, service:Landroid/os/INetworkManagementService;
    :try_start_3d
    sget-object v4, Landroid/net/EthernetDataTracker;->mIface:Ljava/lang/String;

    invoke-interface {v3, v4}, Landroid/os/INetworkManagementService;->clearInterfaceAddresses(Ljava/lang/String;)V
    :try_end_42
    .catch Ljava/lang/Exception; {:try_start_3d .. :try_end_42} :catch_43

    :goto_42
    return-void

    :catch_43
    move-exception v1

    .local v1, e:Ljava/lang/Exception;
    const-string v4, "Ethernet"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Failed to clear addresses or disable ipv6"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_42
.end method

.method public getDefaultGatewayAddr()I
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/net/EthernetDataTracker;->mDefaultGatewayAddr:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v0

    return v0
.end method

.method public getLinkCapabilities()Landroid/net/LinkCapabilities;
    .registers 3

    .prologue
    new-instance v0, Landroid/net/LinkCapabilities;

    iget-object v1, p0, Landroid/net/EthernetDataTracker;->mLinkCapabilities:Landroid/net/LinkCapabilities;

    invoke-direct {v0, v1}, Landroid/net/LinkCapabilities;-><init>(Landroid/net/LinkCapabilities;)V

    return-object v0
.end method

.method public declared-synchronized getLinkProperties()Landroid/net/LinkProperties;
    .registers 3

    .prologue
    monitor-enter p0

    :try_start_1
    new-instance v0, Landroid/net/LinkProperties;

    iget-object v1, p0, Landroid/net/EthernetDataTracker;->mLinkProperties:Landroid/net/LinkProperties;

    invoke-direct {v0, v1}, Landroid/net/LinkProperties;-><init>(Landroid/net/LinkProperties;)V
    :try_end_8
    .catchall {:try_start_1 .. :try_end_8} :catchall_a

    monitor-exit p0

    return-object v0

    :catchall_a
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getNetworkInfo()Landroid/net/NetworkInfo;
    .registers 2

    .prologue
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/net/EthernetDataTracker;->mNetworkInfo:Landroid/net/NetworkInfo;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getTcpBufferSizesPropName()Ljava/lang/String;
    .registers 2

    .prologue
    const-string/jumbo v0, "net.tcp.buffersize.wifi"

    return-object v0
.end method

.method public declared-synchronized isAvailable()Z
    .registers 2

    .prologue
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/net/EthernetDataTracker;->mNetworkInfo:Landroid/net/NetworkInfo;

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isAvailable()Z
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

.method public isDefaultRouteSet()Z
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/net/EthernetDataTracker;->mDefaultRouteSet:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    return v0
.end method

.method public isPrivateDnsRouteSet()Z
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/net/EthernetDataTracker;->mPrivateDnsRouteSet:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    return v0
.end method

.method public isTeardownRequested()Z
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/net/EthernetDataTracker;->mTeardownRequested:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    return v0
.end method

.method public privateDnsRouteSet(Z)V
    .registers 3
    .parameter "enabled"

    .prologue
    iget-object v0, p0, Landroid/net/EthernetDataTracker;->mPrivateDnsRouteSet:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    return-void
.end method

.method public reconnect()Z
    .registers 3

    .prologue
    sget-boolean v0, Landroid/net/EthernetDataTracker;->mLinkUp:Z

    if-eqz v0, :cond_d

    iget-object v0, p0, Landroid/net/EthernetDataTracker;->mTeardownRequested:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    invoke-direct {p0}, Landroid/net/EthernetDataTracker;->runDhcp()V

    :cond_d
    sget-boolean v0, Landroid/net/EthernetDataTracker;->mLinkUp:Z

    return v0
.end method

.method public setDependencyMet(Z)V
    .registers 2
    .parameter "met"

    .prologue
    return-void
.end method

.method public setPolicyDataEnable(Z)V
    .registers 5
    .parameter "enabled"

    .prologue
    const-string v0, "Ethernet"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "ignoring setPolicyDataEnable("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    return-void
.end method

.method public setRadio(Z)Z
    .registers 3
    .parameter "turnOn"

    .prologue
    const/4 v0, 0x1

    return v0
.end method

.method public setTeardownRequested(Z)V
    .registers 3
    .parameter "isRequested"

    .prologue
    iget-object v0, p0, Landroid/net/EthernetDataTracker;->mTeardownRequested:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    return-void
.end method

.method public setUserDataEnable(Z)V
    .registers 5
    .parameter "enabled"

    .prologue
    const-string v0, "Ethernet"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "ignoring setUserDataEnable("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    return-void
.end method

.method public startMonitoring(Landroid/content/Context;Landroid/os/Handler;)V
    .registers 14
    .parameter "context"
    .parameter "target"

    .prologue
    iput-object p1, p0, Landroid/net/EthernetDataTracker;->mContext:Landroid/content/Context;

    iput-object p2, p0, Landroid/net/EthernetDataTracker;->mCsHandler:Landroid/os/Handler;

    const-string/jumbo v8, "network_management"

    invoke-static {v8}, Landroid/os/ServiceManager;->getService(Ljava/lang/String;)Landroid/os/IBinder;

    move-result-object v1

    .local v1, b:Landroid/os/IBinder;
    invoke-static {v1}, Landroid/os/INetworkManagementService$Stub;->asInterface(Landroid/os/IBinder;)Landroid/os/INetworkManagementService;

    move-result-object v8

    iput-object v8, p0, Landroid/net/EthernetDataTracker;->mNMService:Landroid/os/INetworkManagementService;

    new-instance v8, Landroid/net/EthernetDataTracker$InterfaceObserver;

    invoke-direct {v8, p0}, Landroid/net/EthernetDataTracker$InterfaceObserver;-><init>(Landroid/net/EthernetDataTracker;)V

    iput-object v8, p0, Landroid/net/EthernetDataTracker;->mInterfaceObserver:Landroid/net/EthernetDataTracker$InterfaceObserver;

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    const v9, 0x1040018

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v8

    sput-object v8, Landroid/net/EthernetDataTracker;->sIfaceMatch:Ljava/lang/String;

    :try_start_25
    iget-object v8, p0, Landroid/net/EthernetDataTracker;->mNMService:Landroid/os/INetworkManagementService;

    invoke-interface {v8}, Landroid/os/INetworkManagementService;->listInterfaces()[Ljava/lang/String;

    move-result-object v6

    .local v6, ifaces:[Ljava/lang/String;
    move-object v0, v6

    .local v0, arr$:[Ljava/lang/String;
    array-length v7, v0

    .local v7, len$:I
    const/4 v4, 0x0

    .local v4, i$:I
    :goto_2e
    if-ge v4, v7, :cond_67

    aget-object v5, v0, v4

    .local v5, iface:Ljava/lang/String;
    sget-object v8, Landroid/net/EthernetDataTracker;->sIfaceMatch:Ljava/lang/String;

    invoke-virtual {v5, v8}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_6f

    sput-object v5, Landroid/net/EthernetDataTracker;->mIface:Ljava/lang/String;

    iget-object v8, p0, Landroid/net/EthernetDataTracker;->mNMService:Landroid/os/INetworkManagementService;

    invoke-interface {v8, v5}, Landroid/os/INetworkManagementService;->setInterfaceUp(Ljava/lang/String;)V

    iget-object v8, p0, Landroid/net/EthernetDataTracker;->mNMService:Landroid/os/INetworkManagementService;

    invoke-interface {v8, v5}, Landroid/os/INetworkManagementService;->getInterfaceConfig(Ljava/lang/String;)Landroid/net/InterfaceConfiguration;

    move-result-object v2

    .local v2, config:Landroid/net/InterfaceConfiguration;
    invoke-virtual {v2}, Landroid/net/InterfaceConfiguration;->isActive()Z

    move-result v8

    sput-boolean v8, Landroid/net/EthernetDataTracker;->mLinkUp:Z

    if-eqz v2, :cond_64

    iget-object v8, p0, Landroid/net/EthernetDataTracker;->mHwAddr:Ljava/lang/String;

    if-nez v8, :cond_64

    invoke-virtual {v2}, Landroid/net/InterfaceConfiguration;->getHardwareAddress()Ljava/lang/String;

    move-result-object v8

    iput-object v8, p0, Landroid/net/EthernetDataTracker;->mHwAddr:Ljava/lang/String;

    iget-object v8, p0, Landroid/net/EthernetDataTracker;->mHwAddr:Ljava/lang/String;

    if-eqz v8, :cond_64

    iget-object v8, p0, Landroid/net/EthernetDataTracker;->mNetworkInfo:Landroid/net/NetworkInfo;

    iget-object v9, p0, Landroid/net/EthernetDataTracker;->mHwAddr:Ljava/lang/String;

    invoke-virtual {v8, v9}, Landroid/net/NetworkInfo;->setExtraInfo(Ljava/lang/String;)V

    :cond_64
    invoke-virtual {p0}, Landroid/net/EthernetDataTracker;->reconnect()Z
    :try_end_67
    .catch Landroid/os/RemoteException; {:try_start_25 .. :try_end_67} :catch_72

    .end local v0           #arr$:[Ljava/lang/String;
    .end local v2           #config:Landroid/net/InterfaceConfiguration;
    .end local v4           #i$:I
    .end local v5           #iface:Ljava/lang/String;
    .end local v6           #ifaces:[Ljava/lang/String;
    .end local v7           #len$:I
    :cond_67
    :goto_67
    :try_start_67
    iget-object v8, p0, Landroid/net/EthernetDataTracker;->mNMService:Landroid/os/INetworkManagementService;

    iget-object v9, p0, Landroid/net/EthernetDataTracker;->mInterfaceObserver:Landroid/net/EthernetDataTracker$InterfaceObserver;

    invoke-interface {v8, v9}, Landroid/os/INetworkManagementService;->registerObserver(Landroid/net/INetworkManagementEventObserver;)V
    :try_end_6e
    .catch Landroid/os/RemoteException; {:try_start_67 .. :try_end_6e} :catch_8c

    :goto_6e
    return-void

    .restart local v0       #arr$:[Ljava/lang/String;
    .restart local v4       #i$:I
    .restart local v5       #iface:Ljava/lang/String;
    .restart local v6       #ifaces:[Ljava/lang/String;
    .restart local v7       #len$:I
    :cond_6f
    add-int/lit8 v4, v4, 0x1

    goto :goto_2e

    .end local v0           #arr$:[Ljava/lang/String;
    .end local v4           #i$:I
    .end local v5           #iface:Ljava/lang/String;
    .end local v6           #ifaces:[Ljava/lang/String;
    .end local v7           #len$:I
    :catch_72
    move-exception v3

    .local v3, e:Landroid/os/RemoteException;
    const-string v8, "Ethernet"

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Could not get list of interfaces "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_67

    .end local v3           #e:Landroid/os/RemoteException;
    :catch_8c
    move-exception v3

    .restart local v3       #e:Landroid/os/RemoteException;
    const-string v8, "Ethernet"

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Could not register InterfaceObserver "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_6e
.end method

.method public startUsingNetworkFeature(Ljava/lang/String;II)I
    .registers 5
    .parameter "feature"
    .parameter "callingPid"
    .parameter "callingUid"

    .prologue
    const/4 v0, -0x1

    return v0
.end method

.method public stopUsingNetworkFeature(Ljava/lang/String;II)I
    .registers 5
    .parameter "feature"
    .parameter "callingPid"
    .parameter "callingUid"

    .prologue
    const/4 v0, -0x1

    return v0
.end method

.method public teardown()Z
    .registers 3

    .prologue
    const/4 v1, 0x1

    iget-object v0, p0, Landroid/net/EthernetDataTracker;->mTeardownRequested:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    sget-object v0, Landroid/net/EthernetDataTracker;->mIface:Ljava/lang/String;

    invoke-static {v0}, Landroid/net/NetworkUtils;->stopDhcp(Ljava/lang/String;)Z

    return v1
.end method
