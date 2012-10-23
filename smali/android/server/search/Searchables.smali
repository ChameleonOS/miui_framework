.class public Landroid/server/search/Searchables;
.super Ljava/lang/Object;
.source "Searchables.java"


# static fields
.field public static ENHANCED_GOOGLE_SEARCH_COMPONENT_NAME:Ljava/lang/String; = null

.field private static final GLOBAL_SEARCH_RANKER:Ljava/util/Comparator; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Comparator",
            "<",
            "Landroid/content/pm/ResolveInfo;",
            ">;"
        }
    .end annotation
.end field

.field public static GOOGLE_SEARCH_COMPONENT_NAME:Ljava/lang/String; = null

.field private static final LOG_TAG:Ljava/lang/String; = "Searchables"

.field private static final MD_LABEL_DEFAULT_SEARCHABLE:Ljava/lang/String; = "android.app.default_searchable"

.field private static final MD_SEARCHABLE_SYSTEM_SEARCH:Ljava/lang/String; = "*"


# instance fields
.field private mContext:Landroid/content/Context;

.field private mCurrentGlobalSearchActivity:Landroid/content/ComponentName;

.field private mGlobalSearchActivities:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/content/pm/ResolveInfo;",
            ">;"
        }
    .end annotation
.end field

.field private mSearchablesInGlobalSearchList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/app/SearchableInfo;",
            ">;"
        }
    .end annotation
.end field

.field private mSearchablesList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/app/SearchableInfo;",
            ">;"
        }
    .end annotation
.end field

.field private mSearchablesMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Landroid/content/ComponentName;",
            "Landroid/app/SearchableInfo;",
            ">;"
        }
    .end annotation
.end field

.field private mWebSearchActivity:Landroid/content/ComponentName;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 63
    const-string v0, "com.android.googlesearch/.GoogleSearch"

    sput-object v0, Landroid/server/search/Searchables;->GOOGLE_SEARCH_COMPONENT_NAME:Ljava/lang/String;

    .line 65
    const-string v0, "com.google.android.providers.enhancedgooglesearch/.Launcher"

    sput-object v0, Landroid/server/search/Searchables;->ENHANCED_GOOGLE_SEARCH_COMPONENT_NAME:Ljava/lang/String;

    .line 315
    new-instance v0, Landroid/server/search/Searchables$1;

    invoke-direct {v0}, Landroid/server/search/Searchables$1;-><init>()V

    sput-object v0, Landroid/server/search/Searchables;->GLOBAL_SEARCH_RANKER:Ljava/util/Comparator;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .registers 3
    .parameter "context"

    .prologue
    const/4 v0, 0x0

    .line 72
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 54
    iput-object v0, p0, Landroid/server/search/Searchables;->mSearchablesMap:Ljava/util/HashMap;

    .line 55
    iput-object v0, p0, Landroid/server/search/Searchables;->mSearchablesList:Ljava/util/ArrayList;

    .line 56
    iput-object v0, p0, Landroid/server/search/Searchables;->mSearchablesInGlobalSearchList:Ljava/util/ArrayList;

    .line 60
    iput-object v0, p0, Landroid/server/search/Searchables;->mCurrentGlobalSearchActivity:Landroid/content/ComponentName;

    .line 61
    iput-object v0, p0, Landroid/server/search/Searchables;->mWebSearchActivity:Landroid/content/ComponentName;

    .line 73
    iput-object p1, p0, Landroid/server/search/Searchables;->mContext:Landroid/content/Context;

    .line 74
    return-void
.end method

.method static synthetic access$000(Landroid/content/pm/ResolveInfo;)Z
    .registers 2
    .parameter "x0"

    .prologue
    .line 42
    invoke-static {p0}, Landroid/server/search/Searchables;->isSystemApp(Landroid/content/pm/ResolveInfo;)Z

    move-result v0

    return v0
.end method

.method private findGlobalSearchActivities()Ljava/util/List;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Landroid/content/pm/ResolveInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 264
    new-instance v1, Landroid/content/Intent;

    const-string v3, "android.search.action.GLOBAL_SEARCH"

    invoke-direct {v1, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 265
    .local v1, intent:Landroid/content/Intent;
    iget-object v3, p0, Landroid/server/search/Searchables;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 266
    .local v2, pm:Landroid/content/pm/PackageManager;
    const/high16 v3, 0x1

    invoke-virtual {v2, v1, v3}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    .line 269
    .local v0, activities:Ljava/util/List;,"Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    if-eqz v0, :cond_20

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_20

    .line 271
    sget-object v3, Landroid/server/search/Searchables;->GLOBAL_SEARCH_RANKER:Ljava/util/Comparator;

    invoke-static {v0, v3}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 274
    :cond_20
    return-object v0
.end method

.method private findGlobalSearchActivity(Ljava/util/List;)Landroid/content/ComponentName;
    .registers 5
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Landroid/content/pm/ResolveInfo;",
            ">;)",
            "Landroid/content/ComponentName;"
        }
    .end annotation

    .prologue
    .line 283
    .local p1, installed:Ljava/util/List;,"Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    invoke-direct {p0}, Landroid/server/search/Searchables;->getGlobalSearchProviderSetting()Ljava/lang/String;

    move-result-object v1

    .line 284
    .local v1, searchProviderSetting:Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_17

    .line 285
    invoke-static {v1}, Landroid/content/ComponentName;->unflattenFromString(Ljava/lang/String;)Landroid/content/ComponentName;

    move-result-object v0

    .line 287
    .local v0, globalSearchComponent:Landroid/content/ComponentName;
    if-eqz v0, :cond_17

    invoke-direct {p0, v0}, Landroid/server/search/Searchables;->isInstalled(Landroid/content/ComponentName;)Z

    move-result v2

    if-eqz v2, :cond_17

    .line 292
    .end local v0           #globalSearchComponent:Landroid/content/ComponentName;
    :goto_16
    return-object v0

    :cond_17
    invoke-direct {p0, p1}, Landroid/server/search/Searchables;->getDefaultGlobalSearchProvider(Ljava/util/List;)Landroid/content/ComponentName;

    move-result-object v0

    goto :goto_16
.end method

.method private findWebSearchActivity(Landroid/content/ComponentName;)Landroid/content/ComponentName;
    .registers 9
    .parameter "globalSearchActivity"

    .prologue
    const/4 v4, 0x0

    .line 372
    if-nez p1, :cond_4

    .line 387
    :goto_3
    return-object v4

    .line 375
    :cond_4
    new-instance v2, Landroid/content/Intent;

    const-string v5, "android.intent.action.WEB_SEARCH"

    invoke-direct {v2, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 376
    .local v2, intent:Landroid/content/Intent;
    invoke-virtual {p1}, Landroid/content/ComponentName;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 377
    iget-object v5, p0, Landroid/server/search/Searchables;->mContext:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    .line 378
    .local v3, pm:Landroid/content/pm/PackageManager;
    const/high16 v5, 0x1

    invoke-virtual {v3, v2, v5}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    .line 381
    .local v0, activities:Ljava/util/List;,"Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    if-eqz v0, :cond_39

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_39

    .line 382
    const/4 v4, 0x0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/content/pm/ResolveInfo;

    iget-object v1, v4, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    .line 384
    .local v1, ai:Landroid/content/pm/ActivityInfo;
    new-instance v4, Landroid/content/ComponentName;

    iget-object v5, v1, Landroid/content/pm/PackageItemInfo;->packageName:Ljava/lang/String;

    iget-object v6, v1, Landroid/content/pm/PackageItemInfo;->name:Ljava/lang/String;

    invoke-direct {v4, v5, v6}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_3

    .line 386
    .end local v1           #ai:Landroid/content/pm/ActivityInfo;
    :cond_39
    const-string v5, "Searchables"

    const-string v6, "No web search activity found"

    invoke-static {v5, v6}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_3
.end method

.method private getDefaultGlobalSearchProvider(Ljava/util/List;)Landroid/content/ComponentName;
    .registers 6
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Landroid/content/pm/ResolveInfo;",
            ">;)",
            "Landroid/content/ComponentName;"
        }
    .end annotation

    .prologue
    .line 352
    .local p1, providerList:Ljava/util/List;,"Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    if-eqz p1, :cond_1b

    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1b

    .line 353
    const/4 v1, 0x0

    invoke-interface {p1, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/pm/ResolveInfo;

    iget-object v0, v1, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    .line 354
    .local v0, ai:Landroid/content/pm/ActivityInfo;
    new-instance v1, Landroid/content/ComponentName;

    iget-object v2, v0, Landroid/content/pm/PackageItemInfo;->packageName:Ljava/lang/String;

    iget-object v3, v0, Landroid/content/pm/PackageItemInfo;->name:Ljava/lang/String;

    invoke-direct {v1, v2, v3}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 358
    .end local v0           #ai:Landroid/content/pm/ActivityInfo;
    :goto_1a
    return-object v1

    .line 357
    :cond_1b
    const-string v1, "Searchables"

    const-string v2, "No global search activity found"

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 358
    const/4 v1, 0x0

    goto :goto_1a
.end method

.method private getGlobalSearchProviderSetting()Ljava/lang/String;
    .registers 3

    .prologue
    .line 362
    iget-object v0, p0, Landroid/server/search/Searchables;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const-string/jumbo v1, "search_global_search_activity"

    invoke-static {v0, v1}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private isInstalled(Landroid/content/ComponentName;)Z
    .registers 6
    .parameter "globalSearch"

    .prologue
    .line 301
    new-instance v1, Landroid/content/Intent;

    const-string v3, "android.search.action.GLOBAL_SEARCH"

    invoke-direct {v1, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 302
    .local v1, intent:Landroid/content/Intent;
    invoke-virtual {v1, p1}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    .line 304
    iget-object v3, p0, Landroid/server/search/Searchables;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 305
    .local v2, pm:Landroid/content/pm/PackageManager;
    const/high16 v3, 0x1

    invoke-virtual {v2, v1, v3}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    .line 308
    .local v0, activities:Ljava/util/List;,"Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    if-eqz v0, :cond_20

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_20

    .line 309
    const/4 v3, 0x1

    .line 312
    :goto_1f
    return v3

    :cond_20
    const/4 v3, 0x0

    goto :goto_1f
.end method

.method private static final isSystemApp(Landroid/content/pm/ResolveInfo;)Z
    .registers 2
    .parameter "res"

    .prologue
    .line 344
    iget-object v0, p0, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v0, v0, Landroid/content/pm/ComponentInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v0, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/lit8 v0, v0, 0x1

    if-eqz v0, :cond_c

    const/4 v0, 0x1

    :goto_b
    return v0

    :cond_c
    const/4 v0, 0x0

    goto :goto_b
.end method


# virtual methods
.method public buildSearchableList()V
    .registers 24

    .prologue
    .line 191
    new-instance v11, Ljava/util/HashMap;

    invoke-direct {v11}, Ljava/util/HashMap;-><init>()V

    .line 193
    .local v11, newSearchablesMap:Ljava/util/HashMap;,"Ljava/util/HashMap<Landroid/content/ComponentName;Landroid/app/SearchableInfo;>;"
    new-instance v10, Ljava/util/ArrayList;

    invoke-direct {v10}, Ljava/util/ArrayList;-><init>()V

    .line 195
    .local v10, newSearchablesList:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/app/SearchableInfo;>;"
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 198
    .local v9, newSearchablesInGlobalSearchList:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/app/SearchableInfo;>;"
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/server/search/Searchables;->mContext:Landroid/content/Context;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v13

    .line 202
    .local v13, pm:Landroid/content/pm/PackageManager;
    new-instance v6, Landroid/content/Intent;

    const-string v20, "android.intent.action.SEARCH"

    move-object/from16 v0, v20

    invoke-direct {v6, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 203
    .local v6, intent:Landroid/content/Intent;
    const/16 v20, 0x80

    move/from16 v0, v20

    invoke-virtual {v13, v6, v0}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v14

    .line 206
    .local v14, searchList:Ljava/util/List;,"Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    new-instance v18, Landroid/content/Intent;

    const-string v20, "android.intent.action.WEB_SEARCH"

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 207
    .local v18, webSearchIntent:Landroid/content/Intent;
    const/16 v20, 0x80

    move-object/from16 v0, v18

    move/from16 v1, v20

    invoke-virtual {v13, v0, v1}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v17

    .line 210
    .local v17, webSearchInfoList:Ljava/util/List;,"Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    if-nez v14, :cond_43

    if-eqz v17, :cond_b5

    .line 211
    :cond_43
    if-nez v14, :cond_9c

    const/4 v15, 0x0

    .line 212
    .local v15, search_count:I
    :goto_46
    if-nez v17, :cond_a1

    const/16 v19, 0x0

    .line 213
    .local v19, web_search_count:I
    :goto_4a
    add-int v3, v15, v19

    .line 214
    .local v3, count:I
    const/4 v4, 0x0

    .local v4, ii:I
    :goto_4d
    if-ge v4, v3, :cond_b5

    .line 216
    if-ge v4, v15, :cond_a6

    invoke-interface {v14, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Landroid/content/pm/ResolveInfo;

    move-object/from16 v5, v20

    .line 219
    .local v5, info:Landroid/content/pm/ResolveInfo;
    :goto_59
    iget-object v2, v5, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    .line 221
    .local v2, ai:Landroid/content/pm/ActivityInfo;
    new-instance v20, Landroid/content/ComponentName;

    iget-object v0, v2, Landroid/content/pm/PackageItemInfo;->packageName:Ljava/lang/String;

    move-object/from16 v21, v0

    iget-object v0, v2, Landroid/content/pm/PackageItemInfo;->name:Ljava/lang/String;

    move-object/from16 v22, v0

    invoke-direct/range {v20 .. v22}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v20

    invoke-virtual {v11, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v20

    if-nez v20, :cond_99

    .line 222
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/server/search/Searchables;->mContext:Landroid/content/Context;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    invoke-static {v0, v2}, Landroid/app/SearchableInfo;->getActivityMetaData(Landroid/content/Context;Landroid/content/pm/ActivityInfo;)Landroid/app/SearchableInfo;

    move-result-object v16

    .line 223
    .local v16, searchable:Landroid/app/SearchableInfo;
    if-eqz v16, :cond_99

    .line 224
    move-object/from16 v0, v16

    invoke-virtual {v10, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 225
    invoke-virtual/range {v16 .. v16}, Landroid/app/SearchableInfo;->getSearchActivity()Landroid/content/ComponentName;

    move-result-object v20

    move-object/from16 v0, v20

    move-object/from16 v1, v16

    invoke-virtual {v11, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 226
    invoke-virtual/range {v16 .. v16}, Landroid/app/SearchableInfo;->shouldIncludeInGlobalSearch()Z

    move-result v20

    if-eqz v20, :cond_99

    .line 227
    move-object/from16 v0, v16

    invoke-virtual {v9, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 214
    .end local v16           #searchable:Landroid/app/SearchableInfo;
    :cond_99
    add-int/lit8 v4, v4, 0x1

    goto :goto_4d

    .line 211
    .end local v2           #ai:Landroid/content/pm/ActivityInfo;
    .end local v3           #count:I
    .end local v4           #ii:I
    .end local v5           #info:Landroid/content/pm/ResolveInfo;
    .end local v15           #search_count:I
    .end local v19           #web_search_count:I
    :cond_9c
    invoke-interface {v14}, Ljava/util/List;->size()I

    move-result v15

    goto :goto_46

    .line 212
    .restart local v15       #search_count:I
    :cond_a1
    invoke-interface/range {v17 .. v17}, Ljava/util/List;->size()I

    move-result v19

    goto :goto_4a

    .line 216
    .restart local v3       #count:I
    .restart local v4       #ii:I
    .restart local v19       #web_search_count:I
    :cond_a6
    sub-int v20, v4, v15

    move-object/from16 v0, v17

    move/from16 v1, v20

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Landroid/content/pm/ResolveInfo;

    move-object/from16 v5, v20

    goto :goto_59

    .line 234
    .end local v3           #count:I
    .end local v4           #ii:I
    .end local v15           #search_count:I
    .end local v19           #web_search_count:I
    :cond_b5
    invoke-direct/range {p0 .. p0}, Landroid/server/search/Searchables;->findGlobalSearchActivities()Ljava/util/List;

    move-result-object v7

    .line 237
    .local v7, newGlobalSearchActivities:Ljava/util/List;,"Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    move-object/from16 v0, p0

    invoke-direct {v0, v7}, Landroid/server/search/Searchables;->findGlobalSearchActivity(Ljava/util/List;)Landroid/content/ComponentName;

    move-result-object v8

    .line 241
    .local v8, newGlobalSearchActivity:Landroid/content/ComponentName;
    move-object/from16 v0, p0

    invoke-direct {v0, v8}, Landroid/server/search/Searchables;->findWebSearchActivity(Landroid/content/ComponentName;)Landroid/content/ComponentName;

    move-result-object v12

    .line 244
    .local v12, newWebSearchActivity:Landroid/content/ComponentName;
    monitor-enter p0

    .line 245
    :try_start_c6
    move-object/from16 v0, p0

    iput-object v11, v0, Landroid/server/search/Searchables;->mSearchablesMap:Ljava/util/HashMap;

    .line 246
    move-object/from16 v0, p0

    iput-object v10, v0, Landroid/server/search/Searchables;->mSearchablesList:Ljava/util/ArrayList;

    .line 247
    move-object/from16 v0, p0

    iput-object v9, v0, Landroid/server/search/Searchables;->mSearchablesInGlobalSearchList:Ljava/util/ArrayList;

    .line 248
    move-object/from16 v0, p0

    iput-object v7, v0, Landroid/server/search/Searchables;->mGlobalSearchActivities:Ljava/util/List;

    .line 249
    move-object/from16 v0, p0

    iput-object v8, v0, Landroid/server/search/Searchables;->mCurrentGlobalSearchActivity:Landroid/content/ComponentName;

    .line 250
    move-object/from16 v0, p0

    iput-object v12, v0, Landroid/server/search/Searchables;->mWebSearchActivity:Landroid/content/ComponentName;

    .line 251
    monitor-exit p0

    .line 252
    return-void

    .line 251
    :catchall_e0
    move-exception v20

    monitor-exit p0
    :try_end_e2
    .catchall {:try_start_c6 .. :try_end_e2} :catchall_e0

    throw v20
.end method

.method public declared-synchronized getGlobalSearchActivities()Ljava/util/ArrayList;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/content/pm/ResolveInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 409
    monitor-enter p0

    :try_start_1
    new-instance v0, Ljava/util/ArrayList;

    iget-object v1, p0, Landroid/server/search/Searchables;->mGlobalSearchActivities:Ljava/util/List;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V
    :try_end_8
    .catchall {:try_start_1 .. :try_end_8} :catchall_a

    monitor-exit p0

    return-object v0

    :catchall_a
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getGlobalSearchActivity()Landroid/content/ComponentName;
    .registers 2

    .prologue
    .line 416
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/server/search/Searchables;->mCurrentGlobalSearchActivity:Landroid/content/ComponentName;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getSearchableInfo(Landroid/content/ComponentName;)Landroid/app/SearchableInfo;
    .registers 12
    .parameter "activity"

    .prologue
    const/4 v8, 0x0

    .line 106
    monitor-enter p0

    .line 107
    :try_start_2
    iget-object v7, p0, Landroid/server/search/Searchables;->mSearchablesMap:Ljava/util/HashMap;

    invoke-virtual {v7, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/app/SearchableInfo;

    .line 108
    .local v6, result:Landroid/app/SearchableInfo;
    if-eqz v6, :cond_f

    monitor-exit p0

    move-object v7, v6

    .line 165
    :goto_e
    return-object v7

    .line 109
    :cond_f
    monitor-exit p0
    :try_end_10
    .catchall {:try_start_2 .. :try_end_10} :catchall_42

    .line 116
    const/4 v1, 0x0

    .line 118
    .local v1, ai:Landroid/content/pm/ActivityInfo;
    :try_start_11
    iget-object v7, p0, Landroid/server/search/Searchables;->mContext:Landroid/content/Context;

    invoke-virtual {v7}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v7

    const/16 v9, 0x80

    invoke-virtual {v7, p1, v9}, Landroid/content/pm/PackageManager;->getActivityInfo(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;

    move-result-object v1

    .line 120
    const/4 v4, 0x0

    .line 123
    .local v4, refActivityName:Ljava/lang/String;
    iget-object v2, v1, Landroid/content/pm/PackageItemInfo;->metaData:Landroid/os/Bundle;

    .line 124
    .local v2, md:Landroid/os/Bundle;
    if-eqz v2, :cond_28

    .line 125
    const-string v7, "android.app.default_searchable"

    invoke-virtual {v2, v7}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 128
    :cond_28
    if-nez v4, :cond_36

    .line 129
    iget-object v7, v1, Landroid/content/pm/ComponentInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v2, v7, Landroid/content/pm/PackageItemInfo;->metaData:Landroid/os/Bundle;

    .line 130
    if-eqz v2, :cond_36

    .line 131
    const-string v7, "android.app.default_searchable"

    invoke-virtual {v2, v7}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 136
    :cond_36
    if-eqz v4, :cond_84

    .line 139
    const-string v7, "*"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_3d
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_11 .. :try_end_3d} :catch_89

    move-result v7

    if-eqz v7, :cond_45

    move-object v7, v8

    .line 140
    goto :goto_e

    .line 109
    .end local v1           #ai:Landroid/content/pm/ActivityInfo;
    .end local v2           #md:Landroid/os/Bundle;
    .end local v4           #refActivityName:Ljava/lang/String;
    .end local v6           #result:Landroid/app/SearchableInfo;
    :catchall_42
    move-exception v7

    :try_start_43
    monitor-exit p0
    :try_end_44
    .catchall {:try_start_43 .. :try_end_44} :catchall_42

    throw v7

    .line 142
    .restart local v1       #ai:Landroid/content/pm/ActivityInfo;
    .restart local v2       #md:Landroid/os/Bundle;
    .restart local v4       #refActivityName:Ljava/lang/String;
    .restart local v6       #result:Landroid/app/SearchableInfo;
    :cond_45
    :try_start_45
    invoke-virtual {p1}, Landroid/content/ComponentName;->getPackageName()Ljava/lang/String;

    move-result-object v3

    .line 144
    .local v3, pkg:Ljava/lang/String;
    const/4 v7, 0x0

    invoke-virtual {v4, v7}, Ljava/lang/String;->charAt(I)C

    move-result v7

    const/16 v9, 0x2e

    if-ne v7, v9, :cond_7d

    .line 145
    new-instance v5, Landroid/content/ComponentName;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v5, v3, v7}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 152
    .local v5, referredActivity:Landroid/content/ComponentName;
    :goto_68
    monitor-enter p0
    :try_end_69
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_45 .. :try_end_69} :catch_89

    .line 153
    :try_start_69
    iget-object v7, p0, Landroid/server/search/Searchables;->mSearchablesMap:Ljava/util/HashMap;

    invoke-virtual {v7, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    move-object v0, v7

    check-cast v0, Landroid/app/SearchableInfo;

    move-object v6, v0

    .line 154
    if-eqz v6, :cond_83

    .line 155
    iget-object v7, p0, Landroid/server/search/Searchables;->mSearchablesMap:Ljava/util/HashMap;

    invoke-virtual {v7, p1, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 156
    monitor-exit p0
    :try_end_7b
    .catchall {:try_start_69 .. :try_end_7b} :catchall_86

    move-object v7, v6

    goto :goto_e

    .line 147
    .end local v5           #referredActivity:Landroid/content/ComponentName;
    :cond_7d
    :try_start_7d
    new-instance v5, Landroid/content/ComponentName;

    invoke-direct {v5, v3, v4}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_82
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_7d .. :try_end_82} :catch_89

    .restart local v5       #referredActivity:Landroid/content/ComponentName;
    goto :goto_68

    .line 158
    :cond_83
    :try_start_83
    monitor-exit p0

    .end local v2           #md:Landroid/os/Bundle;
    .end local v3           #pkg:Ljava/lang/String;
    .end local v4           #refActivityName:Ljava/lang/String;
    .end local v5           #referredActivity:Landroid/content/ComponentName;
    :cond_84
    :goto_84
    move-object v7, v8

    .line 165
    goto :goto_e

    .line 158
    .restart local v2       #md:Landroid/os/Bundle;
    .restart local v3       #pkg:Ljava/lang/String;
    .restart local v4       #refActivityName:Ljava/lang/String;
    .restart local v5       #referredActivity:Landroid/content/ComponentName;
    :catchall_86
    move-exception v7

    monitor-exit p0
    :try_end_88
    .catchall {:try_start_83 .. :try_end_88} :catchall_86

    :try_start_88
    throw v7
    :try_end_89
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_88 .. :try_end_89} :catch_89

    .line 160
    .end local v2           #md:Landroid/os/Bundle;
    .end local v3           #pkg:Ljava/lang/String;
    .end local v4           #refActivityName:Ljava/lang/String;
    .end local v5           #referredActivity:Landroid/content/ComponentName;
    :catch_89
    move-exception v7

    goto :goto_84
.end method

.method public declared-synchronized getSearchablesInGlobalSearchList()Ljava/util/ArrayList;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/app/SearchableInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 402
    monitor-enter p0

    :try_start_1
    new-instance v0, Ljava/util/ArrayList;

    iget-object v1, p0, Landroid/server/search/Searchables;->mSearchablesInGlobalSearchList:Ljava/util/ArrayList;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V
    :try_end_8
    .catchall {:try_start_1 .. :try_end_8} :catchall_a

    monitor-exit p0

    return-object v0

    :catchall_a
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getSearchablesList()Ljava/util/ArrayList;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/app/SearchableInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 394
    monitor-enter p0

    :try_start_1
    new-instance v0, Ljava/util/ArrayList;

    iget-object v1, p0, Landroid/server/search/Searchables;->mSearchablesList:Ljava/util/ArrayList;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V
    :try_end_8
    .catchall {:try_start_1 .. :try_end_8} :catchall_a

    .line 395
    .local v0, result:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/app/SearchableInfo;>;"
    monitor-exit p0

    return-object v0

    .line 394
    .end local v0           #result:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/app/SearchableInfo;>;"
    :catchall_a
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getWebSearchActivity()Landroid/content/ComponentName;
    .registers 2

    .prologue
    .line 423
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/server/search/Searchables;->mWebSearchActivity:Landroid/content/ComponentName;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method
