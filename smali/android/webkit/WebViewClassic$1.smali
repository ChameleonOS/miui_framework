.class Landroid/webkit/WebViewClassic$1;
.super Landroid/os/AsyncTask;
.source "WebViewClassic.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/webkit/WebViewClassic;->setupPackageListener(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/util/Set",
        "<",
        "Ljava/lang/String;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Landroid/webkit/WebViewClassic;


# direct methods
.method constructor <init>(Landroid/webkit/WebViewClassic;)V
    .registers 2
    .parameter

    .prologue
    .line 1635
    iput-object p1, p0, Landroid/webkit/WebViewClassic$1;->this$0:Landroid/webkit/WebViewClassic;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 1635
    check-cast p1, [Ljava/lang/Void;

    .end local p1
    invoke-virtual {p0, p1}, Landroid/webkit/WebViewClassic$1;->doInBackground([Ljava/lang/Void;)Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/util/Set;
    .registers 7
    .parameter "unused"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/Void;",
            ")",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1639
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    .line 1640
    .local v1, installedPackages:Ljava/util/Set;,"Ljava/util/Set<Ljava/lang/String;>;"
    iget-object v4, p0, Landroid/webkit/WebViewClassic$1;->this$0:Landroid/webkit/WebViewClassic;

    #getter for: Landroid/webkit/WebViewClassic;->mContext:Landroid/content/Context;
    invoke-static {v4}, Landroid/webkit/WebViewClassic;->access$600(Landroid/webkit/WebViewClassic;)Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    .line 1641
    .local v3, pm:Landroid/content/pm/PackageManager;
    invoke-static {}, Landroid/webkit/WebViewClassic;->access$1400()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :goto_17
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2d

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 1643
    .local v2, name:Ljava/lang/String;
    const/4 v4, 0x5

    :try_start_24
    invoke-virtual {v3, v2, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    .line 1645
    invoke-interface {v1, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    :try_end_2a
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_24 .. :try_end_2a} :catch_2b

    goto :goto_17

    .line 1646
    :catch_2b
    move-exception v4

    goto :goto_17

    .line 1650
    .end local v2           #name:Ljava/lang/String;
    :cond_2d
    return-object v1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 1635
    check-cast p1, Ljava/util/Set;

    .end local p1
    invoke-virtual {p0, p1}, Landroid/webkit/WebViewClassic$1;->onPostExecute(Ljava/util/Set;)V

    return-void
.end method

.method protected onPostExecute(Ljava/util/Set;)V
    .registers 4
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1656
    .local p1, installedPackages:Ljava/util/Set;,"Ljava/util/Set<Ljava/lang/String;>;"
    iget-object v0, p0, Landroid/webkit/WebViewClassic$1;->this$0:Landroid/webkit/WebViewClassic;

    #getter for: Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;
    invoke-static {v0}, Landroid/webkit/WebViewClassic;->access$1600(Landroid/webkit/WebViewClassic;)Landroid/webkit/WebViewCore;

    move-result-object v0

    if-eqz v0, :cond_13

    .line 1657
    iget-object v0, p0, Landroid/webkit/WebViewClassic$1;->this$0:Landroid/webkit/WebViewClassic;

    #getter for: Landroid/webkit/WebViewClassic;->mWebViewCore:Landroid/webkit/WebViewCore;
    invoke-static {v0}, Landroid/webkit/WebViewClassic;->access$1600(Landroid/webkit/WebViewClassic;)Landroid/webkit/WebViewCore;

    move-result-object v0

    const/16 v1, 0xb8

    invoke-virtual {v0, v1, p1}, Landroid/webkit/WebViewCore;->sendMessage(ILjava/lang/Object;)V

    .line 1659
    :cond_13
    return-void
.end method
