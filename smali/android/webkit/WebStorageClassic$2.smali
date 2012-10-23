.class Landroid/webkit/WebStorageClassic$2;
.super Landroid/os/Handler;
.source "WebStorageClassic.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/webkit/WebStorageClassic;->createHandler()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/webkit/WebStorageClassic;


# direct methods
.method constructor <init>(Landroid/webkit/WebStorageClassic;)V
    .registers 2
    .parameter

    .prologue
    .line 98
    iput-object p1, p0, Landroid/webkit/WebStorageClassic$2;->this$0:Landroid/webkit/WebStorageClassic;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .registers 15
    .parameter "msg"

    .prologue
    const/4 v12, 0x0

    .line 101
    iget v10, p1, Landroid/os/Message;->what:I

    packed-switch v10, :pswitch_data_f8

    .line 161
    :goto_6
    return-void

    .line 103
    :pswitch_7
    iget-object v9, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v9, Landroid/webkit/WebStorage$Origin;

    .line 104
    .local v9, website:Landroid/webkit/WebStorage$Origin;
    invoke-virtual {v9}, Landroid/webkit/WebStorage$Origin;->getOrigin()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9}, Landroid/webkit/WebStorage$Origin;->getQuota()J

    move-result-wide v11

    #calls: Landroid/webkit/WebStorageClassic;->nativeSetQuotaForOrigin(Ljava/lang/String;J)V
    invoke-static {v10, v11, v12}, Landroid/webkit/WebStorageClassic;->access$000(Ljava/lang/String;J)V

    goto :goto_6

    .line 109
    .end local v9           #website:Landroid/webkit/WebStorage$Origin;
    :pswitch_17
    iget-object v9, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v9, Landroid/webkit/WebStorage$Origin;

    .line 110
    .restart local v9       #website:Landroid/webkit/WebStorage$Origin;
    invoke-virtual {v9}, Landroid/webkit/WebStorage$Origin;->getOrigin()Ljava/lang/String;

    move-result-object v10

    #calls: Landroid/webkit/WebStorageClassic;->nativeDeleteOrigin(Ljava/lang/String;)V
    invoke-static {v10}, Landroid/webkit/WebStorageClassic;->access$100(Ljava/lang/String;)V

    goto :goto_6

    .line 114
    .end local v9           #website:Landroid/webkit/WebStorage$Origin;
    :pswitch_23
    #calls: Landroid/webkit/WebStorageClassic;->nativeDeleteAllData()V
    invoke-static {}, Landroid/webkit/WebStorageClassic;->access$200()V

    goto :goto_6

    .line 118
    :pswitch_27
    iget-object v10, p0, Landroid/webkit/WebStorageClassic$2;->this$0:Landroid/webkit/WebStorageClassic;

    #calls: Landroid/webkit/WebStorageClassic;->syncValues()V
    invoke-static {v10}, Landroid/webkit/WebStorageClassic;->access$300(Landroid/webkit/WebStorageClassic;)V

    .line 119
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Landroid/webkit/ValueCallback;

    .line 120
    .local v0, callback:Landroid/webkit/ValueCallback;
    new-instance v2, Ljava/util/HashMap;

    iget-object v10, p0, Landroid/webkit/WebStorageClassic$2;->this$0:Landroid/webkit/WebStorageClassic;

    #getter for: Landroid/webkit/WebStorageClassic;->mOrigins:Ljava/util/Map;
    invoke-static {v10}, Landroid/webkit/WebStorageClassic;->access$400(Landroid/webkit/WebStorageClassic;)Ljava/util/Map;

    move-result-object v10

    invoke-direct {v2, v10}, Ljava/util/HashMap;-><init>(Ljava/util/Map;)V

    .line 121
    .local v2, origins:Ljava/util/Map;
    new-instance v8, Ljava/util/HashMap;

    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    .line 122
    .local v8, values:Ljava/util/Map;
    const-string v10, "callback"

    invoke-interface {v8, v10, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 123
    const-string/jumbo v10, "origins"

    invoke-interface {v8, v10, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 124
    iget-object v10, p0, Landroid/webkit/WebStorageClassic$2;->this$0:Landroid/webkit/WebStorageClassic;

    const/4 v11, 0x0

    invoke-static {v12, v11, v8}, Landroid/os/Message;->obtain(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v11

    #calls: Landroid/webkit/WebStorageClassic;->postUIMessage(Landroid/os/Message;)V
    invoke-static {v10, v11}, Landroid/webkit/WebStorageClassic;->access$500(Landroid/webkit/WebStorageClassic;Landroid/os/Message;)V

    goto :goto_6

    .line 128
    .end local v0           #callback:Landroid/webkit/ValueCallback;
    .end local v2           #origins:Ljava/util/Map;
    .end local v8           #values:Ljava/util/Map;
    :pswitch_56
    iget-object v10, p0, Landroid/webkit/WebStorageClassic$2;->this$0:Landroid/webkit/WebStorageClassic;

    #calls: Landroid/webkit/WebStorageClassic;->syncValues()V
    invoke-static {v10}, Landroid/webkit/WebStorageClassic;->access$300(Landroid/webkit/WebStorageClassic;)V

    .line 129
    iget-object v8, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v8, Ljava/util/Map;

    .line 130
    .restart local v8       #values:Ljava/util/Map;
    const-string/jumbo v10, "origin"

    invoke-interface {v8, v10}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 131
    .local v1, origin:Ljava/lang/String;
    const-string v10, "callback"

    invoke-interface {v8, v10}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/webkit/ValueCallback;

    .line 132
    .restart local v0       #callback:Landroid/webkit/ValueCallback;
    iget-object v10, p0, Landroid/webkit/WebStorageClassic$2;->this$0:Landroid/webkit/WebStorageClassic;

    #getter for: Landroid/webkit/WebStorageClassic;->mOrigins:Ljava/util/Map;
    invoke-static {v10}, Landroid/webkit/WebStorageClassic;->access$400(Landroid/webkit/WebStorageClassic;)Ljava/util/Map;

    move-result-object v10

    invoke-interface {v10, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/webkit/WebStorage$Origin;

    .line 133
    .restart local v9       #website:Landroid/webkit/WebStorage$Origin;
    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    .line 134
    .local v5, retValues:Ljava/util/Map;
    const-string v10, "callback"

    invoke-interface {v5, v10, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 135
    if-eqz v9, :cond_97

    .line 136
    invoke-virtual {v9}, Landroid/webkit/WebStorage$Origin;->getUsage()J

    move-result-wide v6

    .line 137
    .local v6, usage:J
    const-string/jumbo v10, "usage"

    new-instance v11, Ljava/lang/Long;

    invoke-direct {v11, v6, v7}, Ljava/lang/Long;-><init>(J)V

    invoke-interface {v5, v10, v11}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 139
    .end local v6           #usage:J
    :cond_97
    iget-object v10, p0, Landroid/webkit/WebStorageClassic$2;->this$0:Landroid/webkit/WebStorageClassic;

    const/4 v11, 0x1

    invoke-static {v12, v11, v5}, Landroid/os/Message;->obtain(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v11

    #calls: Landroid/webkit/WebStorageClassic;->postUIMessage(Landroid/os/Message;)V
    invoke-static {v10, v11}, Landroid/webkit/WebStorageClassic;->access$500(Landroid/webkit/WebStorageClassic;Landroid/os/Message;)V

    goto/16 :goto_6

    .line 143
    .end local v0           #callback:Landroid/webkit/ValueCallback;
    .end local v1           #origin:Ljava/lang/String;
    .end local v5           #retValues:Ljava/util/Map;
    .end local v8           #values:Ljava/util/Map;
    .end local v9           #website:Landroid/webkit/WebStorage$Origin;
    :pswitch_a3
    iget-object v10, p0, Landroid/webkit/WebStorageClassic$2;->this$0:Landroid/webkit/WebStorageClassic;

    #calls: Landroid/webkit/WebStorageClassic;->syncValues()V
    invoke-static {v10}, Landroid/webkit/WebStorageClassic;->access$300(Landroid/webkit/WebStorageClassic;)V

    .line 144
    iget-object v8, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v8, Ljava/util/Map;

    .line 145
    .restart local v8       #values:Ljava/util/Map;
    const-string/jumbo v10, "origin"

    invoke-interface {v8, v10}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 146
    .restart local v1       #origin:Ljava/lang/String;
    const-string v10, "callback"

    invoke-interface {v8, v10}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/webkit/ValueCallback;

    .line 147
    .restart local v0       #callback:Landroid/webkit/ValueCallback;
    iget-object v10, p0, Landroid/webkit/WebStorageClassic$2;->this$0:Landroid/webkit/WebStorageClassic;

    #getter for: Landroid/webkit/WebStorageClassic;->mOrigins:Ljava/util/Map;
    invoke-static {v10}, Landroid/webkit/WebStorageClassic;->access$400(Landroid/webkit/WebStorageClassic;)Ljava/util/Map;

    move-result-object v10

    invoke-interface {v10, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/webkit/WebStorage$Origin;

    .line 148
    .restart local v9       #website:Landroid/webkit/WebStorage$Origin;
    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    .line 149
    .restart local v5       #retValues:Ljava/util/Map;
    const-string v10, "callback"

    invoke-interface {v5, v10, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 150
    if-eqz v9, :cond_e4

    .line 151
    invoke-virtual {v9}, Landroid/webkit/WebStorage$Origin;->getQuota()J

    move-result-wide v3

    .line 152
    .local v3, quota:J
    const-string/jumbo v10, "quota"

    new-instance v11, Ljava/lang/Long;

    invoke-direct {v11, v3, v4}, Ljava/lang/Long;-><init>(J)V

    invoke-interface {v5, v10, v11}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 154
    .end local v3           #quota:J
    :cond_e4
    iget-object v10, p0, Landroid/webkit/WebStorageClassic$2;->this$0:Landroid/webkit/WebStorageClassic;

    const/4 v11, 0x2

    invoke-static {v12, v11, v5}, Landroid/os/Message;->obtain(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v11

    #calls: Landroid/webkit/WebStorageClassic;->postUIMessage(Landroid/os/Message;)V
    invoke-static {v10, v11}, Landroid/webkit/WebStorageClassic;->access$500(Landroid/webkit/WebStorageClassic;Landroid/os/Message;)V

    goto/16 :goto_6

    .line 158
    .end local v0           #callback:Landroid/webkit/ValueCallback;
    .end local v1           #origin:Ljava/lang/String;
    .end local v5           #retValues:Ljava/util/Map;
    .end local v8           #values:Ljava/util/Map;
    .end local v9           #website:Landroid/webkit/WebStorage$Origin;
    :pswitch_f0
    iget-object v10, p0, Landroid/webkit/WebStorageClassic$2;->this$0:Landroid/webkit/WebStorageClassic;

    #calls: Landroid/webkit/WebStorageClassic;->syncValues()V
    invoke-static {v10}, Landroid/webkit/WebStorageClassic;->access$300(Landroid/webkit/WebStorageClassic;)V

    goto/16 :goto_6

    .line 101
    nop

    :pswitch_data_f8
    .packed-switch 0x0
        :pswitch_f0
        :pswitch_7
        :pswitch_17
        :pswitch_23
        :pswitch_27
        :pswitch_56
        :pswitch_a3
    .end packed-switch
.end method
