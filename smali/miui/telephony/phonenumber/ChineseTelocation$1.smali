.class Lmiui/telephony/phonenumber/ChineseTelocation$1;
.super Landroid/database/ContentObserver;
.source "ChineseTelocation.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lmiui/telephony/phonenumber/ChineseTelocation;->initObserver(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lmiui/telephony/phonenumber/ChineseTelocation;


# direct methods
.method constructor <init>(Lmiui/telephony/phonenumber/ChineseTelocation;Landroid/os/Handler;)V
    .registers 3
    .parameter
    .parameter "x0"

    .prologue
    iput-object p1, p0, Lmiui/telephony/phonenumber/ChineseTelocation$1;->this$0:Lmiui/telephony/phonenumber/ChineseTelocation;

    invoke-direct {p0, p2}, Landroid/database/ContentObserver;-><init>(Landroid/os/Handler;)V

    return-void
.end method


# virtual methods
.method public onChange(Z)V
    .registers 4
    .parameter "selfChange"

    .prologue
    invoke-super {p0, p1}, Landroid/database/ContentObserver;->onChange(Z)V

    const-string v0, "ChineseTelocation"

    const-string/jumbo v1, "telocation setting changed, reloading ..."

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    iget-object v0, p0, Lmiui/telephony/phonenumber/ChineseTelocation$1;->this$0:Lmiui/telephony/phonenumber/ChineseTelocation;

    #calls: Lmiui/telephony/phonenumber/ChineseTelocation;->updateTelocationSetting()V
    invoke-static {v0}, Lmiui/telephony/phonenumber/ChineseTelocation;->access$000(Lmiui/telephony/phonenumber/ChineseTelocation;)V

    return-void
.end method
