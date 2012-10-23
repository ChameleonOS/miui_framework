.class Lmiui/telephony/phonenumber/ChineseTelocation$2;
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
    .line 212
    iput-object p1, p0, Lmiui/telephony/phonenumber/ChineseTelocation$2;->this$0:Lmiui/telephony/phonenumber/ChineseTelocation;

    invoke-direct {p0, p2}, Landroid/database/ContentObserver;-><init>(Landroid/os/Handler;)V

    return-void
.end method


# virtual methods
.method public onChange(Z)V
    .registers 4
    .parameter "selfChange"

    .prologue
    .line 215
    invoke-super {p0, p1}, Landroid/database/ContentObserver;->onChange(Z)V

    .line 216
    const-string v0, "ChineseTelocation"

    const-string v1, "custom location changed, reloading ..."

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 217
    iget-object v0, p0, Lmiui/telephony/phonenumber/ChineseTelocation$2;->this$0:Lmiui/telephony/phonenumber/ChineseTelocation;

    #calls: Lmiui/telephony/phonenumber/ChineseTelocation;->updateCustomLocation()V
    invoke-static {v0}, Lmiui/telephony/phonenumber/ChineseTelocation;->access$100(Lmiui/telephony/phonenumber/ChineseTelocation;)V

    .line 218
    return-void
.end method
