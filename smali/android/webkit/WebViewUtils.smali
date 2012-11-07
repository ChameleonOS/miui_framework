.class public Landroid/webkit/WebViewUtils;
.super Ljava/lang/Object;
.source "WebViewUtils.java"


# static fields
.field static final AMAZON:Ljava/lang/String; = "http://www.amazon.cn/gp/aw/?tag=xm05-23"

.field static final BAIDU:Ljava/lang/String; = "http://m.baidu.com/?from=1269a"

.field static final BUY360:Ljava/lang/String; = "http://union.m.360buy.com/click/go.action?to=http://m.360buy.com&type=1&keyword=&unionId=35295&subunionId=0"

.field static final CTRIP:Ljava/lang/String; = "http://me.ctrip.com/hotel/default.html?sid=44237"

.field static final DANGDANG:Ljava/lang/String; = "http://m.dangdang.com/?unionid=p-307566m"

.field static final DDMAP:Ljava/lang/String; = "http://wap.ddmap.com/forword_city_configdata.jsp?from=xm"

.field static final DIYICAI:Ljava/lang/String; = "http://m.diyicai.com/wap/csj/index.jsp?sid=31017545293"

.field static final ELONG:Ljava/lang/String; = "http://m.elong.com/?ref=xiaomi"

.field static final GANJI:Ljava/lang/String; = "http://3g.ganji.cn/?from=xiaomi_shouye"

.field static final IFENG:Ljava/lang/String; = "http://i.ifeng.com/?ch=rj_mr_dh"

.field static final LEXUN:Ljava/lang/String; = "http://adv.lexun.com/go.aspx?cd=131"

.field static final SHUPENG:Ljava/lang/String; = "xiaomi.shupeng.com"

.field static final SOHU_TV:Ljava/lang/String; = "http://m.tv.sohu.com/?pvid=4b7ac3c25600002a"

.field static final TAOBAO:Ljava/lang/String; = "http://r.m.taobao.com/m2?e=%2BH8j1GjPyOOPa7lSh9yl0ZKuVhyUwLhPGSY0flyd5vURHvdLKD84V5WIA0jtv%2B%2FYKh8niYXjxykNEw6fEG%2FZKZVD2YEvHQ%3D%3D"

.field static final TMALL:Ljava/lang/String; = "http://r.m.taobao.com/m2?e=%2BH8j1GjPyOOPa7lSh9yl0ZKuVhyW4Ue7bosm0iveBlJ9WF9tt4O%2Fk%2FfyX%2B1sS7hnUmD%2BV%2Be3DOq8"

.field static final UNION_SITES_MAP:Ljava/util/HashMap; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field static final WAN500:Ljava/lang/String; = "http://3g.500wan.com/index?coopid=2328"

.field static final YOUYUAN:Ljava/lang/String; = "http://youyuan.com/?from=3114"


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .prologue
    .line 47
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    .line 50
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string v1, "baidu"

    const-string v2, "http://m.baidu.com/?from=1269a"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 51
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string v1, "m.baidu"

    const-string v2, "http://m.baidu.com/?from=1269a"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 53
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string/jumbo v1, "taobao"

    const-string v2, "http://r.m.taobao.com/m2?e=%2BH8j1GjPyOOPa7lSh9yl0ZKuVhyUwLhPGSY0flyd5vURHvdLKD84V5WIA0jtv%2B%2FYKh8niYXjxykNEw6fEG%2FZKZVD2YEvHQ%3D%3D"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 54
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string v1, "m.taobao"

    const-string v2, "http://r.m.taobao.com/m2?e=%2BH8j1GjPyOOPa7lSh9yl0ZKuVhyUwLhPGSY0flyd5vURHvdLKD84V5WIA0jtv%2B%2FYKh8niYXjxykNEw6fEG%2FZKZVD2YEvHQ%3D%3D"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 56
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string/jumbo v1, "tmall"

    const-string v2, "http://r.m.taobao.com/m2?e=%2BH8j1GjPyOOPa7lSh9yl0ZKuVhyW4Ue7bosm0iveBlJ9WF9tt4O%2Fk%2FfyX%2B1sS7hnUmD%2BV%2Be3DOq8"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 57
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string v1, "m.tmall"

    const-string v2, "http://r.m.taobao.com/m2?e=%2BH8j1GjPyOOPa7lSh9yl0ZKuVhyW4Ue7bosm0iveBlJ9WF9tt4O%2Fk%2FfyX%2B1sS7hnUmD%2BV%2Be3DOq8"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 59
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string v1, "360buy"

    const-string v2, "http://union.m.360buy.com/click/go.action?to=http://m.360buy.com&type=1&keyword=&unionId=35295&subunionId=0"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 60
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string v1, "m.360buy"

    const-string v2, "http://union.m.360buy.com/click/go.action?to=http://m.360buy.com&type=1&keyword=&unionId=35295&subunionId=0"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 62
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string v1, "amazon"

    const-string v2, "http://www.amazon.cn/gp/aw/?tag=xm05-23"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 64
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string v1, "dangdang"

    const-string v2, "http://m.dangdang.com/?unionid=p-307566m"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 65
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string v1, "m.dangdang"

    const-string v2, "http://m.dangdang.com/?unionid=p-307566m"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 67
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string/jumbo v1, "youyuan"

    const-string v2, "http://youyuan.com/?from=3114"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 69
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string v1, "ctrip"

    const-string v2, "http://me.ctrip.com/hotel/default.html?sid=44237"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 70
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string/jumbo v1, "me.ctrip"

    const-string v2, "http://me.ctrip.com/hotel/default.html?sid=44237"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 72
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string v1, "elong"

    const-string v2, "http://m.elong.com/?ref=xiaomi"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 73
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string v1, "m.elong"

    const-string v2, "http://m.elong.com/?ref=xiaomi"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 75
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string v1, "ifeng"

    const-string v2, "http://i.ifeng.com/?ch=rj_mr_dh"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 76
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string v1, "i.ifeng"

    const-string v2, "http://i.ifeng.com/?ch=rj_mr_dh"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 78
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string v1, "ganji"

    const-string v2, "http://3g.ganji.cn/?from=xiaomi_shouye"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 79
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string v1, "3g.ganji"

    const-string v2, "http://3g.ganji.cn/?from=xiaomi_shouye"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 81
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string v1, "lexun"

    const-string v2, "http://adv.lexun.com/go.aspx?cd=131"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 83
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string v1, "ddmap"

    const-string v2, "http://wap.ddmap.com/forword_city_configdata.jsp?from=xm"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 84
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string/jumbo v1, "wap.ddmap"

    const-string v2, "http://wap.ddmap.com/forword_city_configdata.jsp?from=xm"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 86
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string/jumbo v1, "shupeng"

    const-string/jumbo v2, "xiaomi.shupeng.com"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 87
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string v1, "m.shupeng"

    const-string/jumbo v2, "xiaomi.shupeng.com"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 89
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string/jumbo v1, "tv.sohu"

    const-string v2, "http://m.tv.sohu.com/?pvid=4b7ac3c25600002a"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 90
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string v1, "m.tv.sohu"

    const-string v2, "http://m.tv.sohu.com/?pvid=4b7ac3c25600002a"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 92
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string v1, "500wan"

    const-string v2, "http://3g.500wan.com/index?coopid=2328"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 93
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string v1, "3g.500wan"

    const-string v2, "http://3g.500wan.com/index?coopid=2328"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 95
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string v1, "diyicai"

    const-string v2, "http://m.diyicai.com/wap/csj/index.jsp?sid=31017545293"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 96
    sget-object v0, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    const-string v1, "m.diyicai"

    const-string v2, "http://m.diyicai.com/wap/csj/index.jsp?sid=31017545293"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 97
    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 11
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static processUrl(Ljava/lang/String;)Ljava/lang/String;
    .registers 7
    .parameter "url"

    .prologue
    .line 100
    if-nez p0, :cond_4

    const/4 p0, 0x0

    .line 119
    .end local p0
    :cond_3
    :goto_3
    return-object p0

    .line 102
    .restart local p0
    :cond_4
    :try_start_4
    invoke-static {p0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    .line 103
    .local v3, uri:Landroid/net/Uri;
    if-eqz v3, :cond_3

    invoke-virtual {v3}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_1c

    invoke-virtual {v3}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v4

    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    :cond_1c
    invoke-virtual {v3}, Landroid/net/Uri;->getQuery()Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_3

    .line 105
    invoke-virtual {v3}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v0

    .line 106
    .local v0, host:Ljava/lang/String;
    if-eqz v0, :cond_3

    .line 107
    const/16 v4, 0x2e

    invoke-virtual {v0, v4}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v2

    .line 108
    .local v2, lastIndex:I
    const/4 v4, -0x1

    if-eq v2, v4, :cond_3

    .line 109
    const-string/jumbo v4, "www."

    invoke-virtual {v0, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_51

    const/4 v4, 0x4

    :goto_3b
    invoke-virtual {v0, v4, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    .line 110
    .local v1, key:Ljava/lang/String;
    sget-object v4, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    invoke-virtual {v4, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 111
    sget-object v4, Landroid/webkit/WebViewUtils;->UNION_SITES_MAP:Ljava/util/HashMap;

    invoke-virtual {v4, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;
    :try_end_4f
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4f} :catch_53

    move-object p0, v4

    goto :goto_3

    .line 109
    .end local v1           #key:Ljava/lang/String;
    :cond_51
    const/4 v4, 0x0

    goto :goto_3b

    .line 116
    .end local v0           #host:Ljava/lang/String;
    .end local v2           #lastIndex:I
    .end local v3           #uri:Landroid/net/Uri;
    :catch_53
    move-exception v4

    goto :goto_3
.end method
