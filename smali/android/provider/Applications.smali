.class public Landroid/provider/Applications;
.super Ljava/lang/Object;
.source "Applications.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/provider/Applications$ApplicationColumns;
    }
.end annotation


# static fields
.field public static final APPLICATION_DIR_TYPE:Ljava/lang/String; = "vnd.android.cursor.dir/vnd.android.application"

.field public static final APPLICATION_ITEM_TYPE:Ljava/lang/String; = "vnd.android.cursor.item/vnd.android.application"

.field public static final APPLICATION_PATH:Ljava/lang/String; = "applications"

.field private static final APPLICATION_SUB_TYPE:Ljava/lang/String; = "vnd.android.application"

.field public static final AUTHORITY:Ljava/lang/String; = "applications"

.field public static final CONTENT_URI:Landroid/net/Uri; = null

.field public static final SEARCH_PATH:Ljava/lang/String; = "search"


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 41
    const-string v0, "content://applications"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Landroid/provider/Applications;->CONTENT_URI:Landroid/net/Uri;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .prologue
    .line 70
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static componentNameToUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;
    .registers 4
    .parameter "packageName"
    .parameter "className"

    .prologue
    .line 111
    sget-object v0, Landroid/provider/Applications;->CONTENT_URI:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v1, "applications"

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public static search(Landroid/content/ContentResolver;Ljava/lang/String;)Landroid/database/Cursor;
    .registers 8
    .parameter "resolver"
    .parameter "query"

    .prologue
    const/4 v2, 0x0

    .line 77
    sget-object v0, Landroid/provider/Applications;->CONTENT_URI:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    const-string/jumbo v3, "search"

    invoke-virtual {v0, v3}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v1

    .local v1, searchUri:Landroid/net/Uri;
    move-object v0, p0

    move-object v3, v2

    move-object v4, v2

    move-object v5, v2

    .line 78
    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    return-object v0
.end method

.method public static uriToComponentName(Landroid/net/Uri;)Landroid/content/ComponentName;
    .registers 7
    .parameter "appUri"

    .prologue
    const/4 v3, 0x0

    .line 91
    if-nez p0, :cond_4

    .line 99
    :cond_3
    :goto_3
    return-object v3

    .line 92
    :cond_4
    const-string v4, "content"

    invoke-virtual {p0}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 93
    const-string v4, "applications"

    invoke-virtual {p0}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 94
    invoke-virtual {p0}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v2

    .line 95
    .local v2, pathSegments:Ljava/util/List;,"Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v4

    const/4 v5, 0x3

    if-ne v4, v5, :cond_3

    .line 96
    const-string v4, "applications"

    const/4 v5, 0x0

    invoke-interface {v2, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 97
    const/4 v3, 0x1

    invoke-interface {v2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 98
    .local v1, packageName:Ljava/lang/String;
    const/4 v3, 0x2

    invoke-interface {v2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 99
    .local v0, name:Ljava/lang/String;
    new-instance v3, Landroid/content/ComponentName;

    invoke-direct {v3, v1, v0}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_3
.end method
