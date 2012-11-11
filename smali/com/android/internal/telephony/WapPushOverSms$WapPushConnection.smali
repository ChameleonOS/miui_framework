.class Lcom/android/internal/telephony/WapPushOverSms$WapPushConnection;
.super Ljava/lang/Object;
.source "WapPushOverSms.java"

# interfaces
.implements Landroid/content/ServiceConnection;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/telephony/WapPushOverSms;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "WapPushConnection"
.end annotation


# instance fields
.field private mOwner:Landroid/content/Context;

.field private mWapPushMan:Lcom/android/internal/telephony/IWapPushManager;

.field final synthetic this$0:Lcom/android/internal/telephony/WapPushOverSms;


# direct methods
.method public constructor <init>(Lcom/android/internal/telephony/WapPushOverSms;Landroid/content/Context;)V
    .registers 3
    .parameter
    .parameter "ownerContext"

    .prologue
    iput-object p1, p0, Lcom/android/internal/telephony/WapPushOverSms$WapPushConnection;->this$0:Lcom/android/internal/telephony/WapPushOverSms;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p2, p0, Lcom/android/internal/telephony/WapPushOverSms$WapPushConnection;->mOwner:Landroid/content/Context;

    return-void
.end method

.method static synthetic access$000(Lcom/android/internal/telephony/WapPushOverSms$WapPushConnection;)Lcom/android/internal/telephony/IWapPushManager;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Lcom/android/internal/telephony/WapPushOverSms$WapPushConnection;->mWapPushMan:Lcom/android/internal/telephony/IWapPushManager;

    return-object v0
.end method

.method static synthetic access$100(Lcom/android/internal/telephony/WapPushOverSms$WapPushConnection;)Landroid/content/Context;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Lcom/android/internal/telephony/WapPushOverSms$WapPushConnection;->mOwner:Landroid/content/Context;

    return-object v0
.end method

.method private rebindWapPushManager()V
    .registers 3

    .prologue
    iget-object v1, p0, Lcom/android/internal/telephony/WapPushOverSms$WapPushConnection;->mWapPushMan:Lcom/android/internal/telephony/IWapPushManager;

    if-eqz v1, :cond_5

    :goto_4
    return-void

    :cond_5
    move-object v0, p0

    .local v0, wapPushConnection:Landroid/content/ServiceConnection;
    new-instance v1, Lcom/android/internal/telephony/WapPushOverSms$WapPushConnection$1;

    invoke-direct {v1, p0, v0}, Lcom/android/internal/telephony/WapPushOverSms$WapPushConnection$1;-><init>(Lcom/android/internal/telephony/WapPushOverSms$WapPushConnection;Landroid/content/ServiceConnection;)V

    invoke-virtual {v1}, Lcom/android/internal/telephony/WapPushOverSms$WapPushConnection$1;->start()V

    goto :goto_4
.end method


# virtual methods
.method public bindWapPushManager()V
    .registers 5

    .prologue
    iget-object v1, p0, Lcom/android/internal/telephony/WapPushOverSms$WapPushConnection;->mWapPushMan:Lcom/android/internal/telephony/IWapPushManager;

    if-eqz v1, :cond_5

    :goto_4
    return-void

    :cond_5
    move-object v0, p0

    .local v0, wapPushConnection:Landroid/content/ServiceConnection;
    iget-object v1, p0, Lcom/android/internal/telephony/WapPushOverSms$WapPushConnection;->mOwner:Landroid/content/Context;

    new-instance v2, Landroid/content/Intent;

    const-class v3, Lcom/android/internal/telephony/IWapPushManager;

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v0, v3}, Landroid/content/Context;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    goto :goto_4
.end method

.method public getWapPushManager()Lcom/android/internal/telephony/IWapPushManager;
    .registers 2

    .prologue
    iget-object v0, p0, Lcom/android/internal/telephony/WapPushOverSms$WapPushConnection;->mWapPushMan:Lcom/android/internal/telephony/IWapPushManager;

    return-object v0
.end method

.method public onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .registers 4
    .parameter "name"
    .parameter "service"

    .prologue
    invoke-static {p2}, Lcom/android/internal/telephony/IWapPushManager$Stub;->asInterface(Landroid/os/IBinder;)Lcom/android/internal/telephony/IWapPushManager;

    move-result-object v0

    iput-object v0, p0, Lcom/android/internal/telephony/WapPushOverSms$WapPushConnection;->mWapPushMan:Lcom/android/internal/telephony/IWapPushManager;

    return-void
.end method

.method public onServiceDisconnected(Landroid/content/ComponentName;)V
    .registers 3
    .parameter "name"

    .prologue
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/internal/telephony/WapPushOverSms$WapPushConnection;->mWapPushMan:Lcom/android/internal/telephony/IWapPushManager;

    invoke-direct {p0}, Lcom/android/internal/telephony/WapPushOverSms$WapPushConnection;->rebindWapPushManager()V

    return-void
.end method
