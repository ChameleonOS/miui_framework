.class Landroid/server/search/SearchManagerService$GlobalSearchProviderObserver;
.super Landroid/database/ContentObserver;
.source "SearchManagerService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/server/search/SearchManagerService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "GlobalSearchProviderObserver"
.end annotation


# instance fields
.field private final mResolver:Landroid/content/ContentResolver;

.field final synthetic this$0:Landroid/server/search/SearchManagerService;


# direct methods
.method public constructor <init>(Landroid/server/search/SearchManagerService;Landroid/content/ContentResolver;)V
    .registers 6
    .parameter
    .parameter "resolver"

    .prologue
    iput-object p1, p0, Landroid/server/search/SearchManagerService$GlobalSearchProviderObserver;->this$0:Landroid/server/search/SearchManagerService;

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroid/database/ContentObserver;-><init>(Landroid/os/Handler;)V

    iput-object p2, p0, Landroid/server/search/SearchManagerService$GlobalSearchProviderObserver;->mResolver:Landroid/content/ContentResolver;

    iget-object v0, p0, Landroid/server/search/SearchManagerService$GlobalSearchProviderObserver;->mResolver:Landroid/content/ContentResolver;

    const-string/jumbo v1, "search_global_search_activity"

    invoke-static {v1}, Landroid/provider/Settings$Secure;->getUriFor(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2, p0}, Landroid/content/ContentResolver;->registerContentObserver(Landroid/net/Uri;ZLandroid/database/ContentObserver;)V

    return-void
.end method


# virtual methods
.method public onChange(Z)V
    .registers 4
    .parameter "selfChange"

    .prologue
    iget-object v1, p0, Landroid/server/search/SearchManagerService$GlobalSearchProviderObserver;->this$0:Landroid/server/search/SearchManagerService;

    #calls: Landroid/server/search/SearchManagerService;->getSearchables()Landroid/server/search/Searchables;
    invoke-static {v1}, Landroid/server/search/SearchManagerService;->access$200(Landroid/server/search/SearchManagerService;)Landroid/server/search/Searchables;

    move-result-object v1

    invoke-virtual {v1}, Landroid/server/search/Searchables;->buildSearchableList()V

    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.search.action.GLOBAL_SEARCH_ACTIVITY_CHANGED"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .local v0, intent:Landroid/content/Intent;
    const/high16 v1, 0x2000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    iget-object v1, p0, Landroid/server/search/SearchManagerService$GlobalSearchProviderObserver;->this$0:Landroid/server/search/SearchManagerService;

    #getter for: Landroid/server/search/SearchManagerService;->mContext:Landroid/content/Context;
    invoke-static {v1}, Landroid/server/search/SearchManagerService;->access$100(Landroid/server/search/SearchManagerService;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    return-void
.end method
