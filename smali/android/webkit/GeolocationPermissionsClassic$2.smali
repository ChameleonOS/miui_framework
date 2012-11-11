.class Landroid/webkit/GeolocationPermissionsClassic$2;
.super Landroid/os/Handler;
.source "GeolocationPermissionsClassic.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/webkit/GeolocationPermissionsClassic;->createHandler()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/webkit/GeolocationPermissionsClassic;


# direct methods
.method constructor <init>(Landroid/webkit/GeolocationPermissionsClassic;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Landroid/webkit/GeolocationPermissionsClassic$2;->this$0:Landroid/webkit/GeolocationPermissionsClassic;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .registers 11
    .parameter "msg"

    .prologue
    const/4 v8, 0x0

    iget v6, p1, Landroid/os/Message;->what:I

    packed-switch v6, :pswitch_data_76

    :goto_6
    return-void

    :pswitch_7
    #calls: Landroid/webkit/GeolocationPermissionsClassic;->nativeGetOrigins()Ljava/util/Set;
    invoke-static {}, Landroid/webkit/GeolocationPermissionsClassic;->access$000()Ljava/util/Set;

    move-result-object v3

    .local v3, origins:Ljava/util/Set;
    iget-object v1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v1, Landroid/webkit/ValueCallback;

    .local v1, callback:Landroid/webkit/ValueCallback;
    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    .local v5, values:Ljava/util/Map;
    const-string v6, "callback"

    invoke-interface {v5, v6, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string/jumbo v6, "origins"

    invoke-interface {v5, v6, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v6, p0, Landroid/webkit/GeolocationPermissionsClassic$2;->this$0:Landroid/webkit/GeolocationPermissionsClassic;

    const/4 v7, 0x0

    invoke-static {v8, v7, v5}, Landroid/os/Message;->obtain(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v7

    #calls: Landroid/webkit/GeolocationPermissionsClassic;->postUIMessage(Landroid/os/Message;)V
    invoke-static {v6, v7}, Landroid/webkit/GeolocationPermissionsClassic;->access$100(Landroid/webkit/GeolocationPermissionsClassic;Landroid/os/Message;)V

    goto :goto_6

    .end local v1           #callback:Landroid/webkit/ValueCallback;
    .end local v3           #origins:Ljava/util/Set;
    .end local v5           #values:Ljava/util/Map;
    :pswitch_2a
    iget-object v5, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v5, Ljava/util/Map;

    .restart local v5       #values:Ljava/util/Map;
    const-string/jumbo v6, "origin"

    invoke-interface {v5, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .local v2, origin:Ljava/lang/String;
    const-string v6, "callback"

    invoke-interface {v5, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/webkit/ValueCallback;

    .restart local v1       #callback:Landroid/webkit/ValueCallback;
    #calls: Landroid/webkit/GeolocationPermissionsClassic;->nativeGetAllowed(Ljava/lang/String;)Z
    invoke-static {v2}, Landroid/webkit/GeolocationPermissionsClassic;->access$200(Ljava/lang/String;)Z

    move-result v0

    .local v0, allowed:Z
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    .local v4, retValues:Ljava/util/Map;
    const-string v6, "callback"

    invoke-interface {v4, v6, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v6, "allowed"

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    invoke-interface {v4, v6, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v6, p0, Landroid/webkit/GeolocationPermissionsClassic$2;->this$0:Landroid/webkit/GeolocationPermissionsClassic;

    const/4 v7, 0x1

    invoke-static {v8, v7, v4}, Landroid/os/Message;->obtain(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v7

    #calls: Landroid/webkit/GeolocationPermissionsClassic;->postUIMessage(Landroid/os/Message;)V
    invoke-static {v6, v7}, Landroid/webkit/GeolocationPermissionsClassic;->access$100(Landroid/webkit/GeolocationPermissionsClassic;Landroid/os/Message;)V

    goto :goto_6

    .end local v0           #allowed:Z
    .end local v1           #callback:Landroid/webkit/ValueCallback;
    .end local v2           #origin:Ljava/lang/String;
    .end local v4           #retValues:Ljava/util/Map;
    .end local v5           #values:Ljava/util/Map;
    :pswitch_61
    iget-object v6, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v6, Ljava/lang/String;

    #calls: Landroid/webkit/GeolocationPermissionsClassic;->nativeClear(Ljava/lang/String;)V
    invoke-static {v6}, Landroid/webkit/GeolocationPermissionsClassic;->access$300(Ljava/lang/String;)V

    goto :goto_6

    :pswitch_69
    iget-object v6, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v6, Ljava/lang/String;

    #calls: Landroid/webkit/GeolocationPermissionsClassic;->nativeAllow(Ljava/lang/String;)V
    invoke-static {v6}, Landroid/webkit/GeolocationPermissionsClassic;->access$400(Ljava/lang/String;)V

    goto :goto_6

    :pswitch_71
    #calls: Landroid/webkit/GeolocationPermissionsClassic;->nativeClearAll()V
    invoke-static {}, Landroid/webkit/GeolocationPermissionsClassic;->access$500()V

    goto :goto_6

    nop

    :pswitch_data_76
    .packed-switch 0x0
        :pswitch_7
        :pswitch_2a
        :pswitch_61
        :pswitch_69
        :pswitch_71
    .end packed-switch
.end method
