.class Landroid/net/VpnService$Callback;
.super Landroid/os/Binder;
.source "VpnService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/VpnService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "Callback"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/net/VpnService;


# direct methods
.method private constructor <init>(Landroid/net/VpnService;)V
    .registers 2
    .parameter

    .prologue
    .line 236
    iput-object p1, p0, Landroid/net/VpnService$Callback;->this$0:Landroid/net/VpnService;

    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/net/VpnService;Landroid/net/VpnService$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 236
    invoke-direct {p0, p1}, Landroid/net/VpnService$Callback;-><init>(Landroid/net/VpnService;)V

    return-void
.end method


# virtual methods
.method protected onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .registers 6
    .parameter "code"
    .parameter "data"
    .parameter "reply"
    .parameter "flags"

    .prologue
    .line 239
    const v0, 0xffffff

    if-ne p1, v0, :cond_c

    .line 240
    iget-object v0, p0, Landroid/net/VpnService$Callback;->this$0:Landroid/net/VpnService;

    invoke-virtual {v0}, Landroid/net/VpnService;->onRevoke()V

    .line 241
    const/4 v0, 0x1

    .line 243
    :goto_b
    return v0

    :cond_c
    const/4 v0, 0x0

    goto :goto_b
.end method
