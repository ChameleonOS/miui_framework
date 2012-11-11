.class Landroid/provider/Settings$NameValueCache;
.super Ljava/lang/Object;
.source "Settings.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/provider/Settings;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "NameValueCache"
.end annotation


# static fields
.field private static final NAME_EQ_PLACEHOLDER:Ljava/lang/String; = "name=?"

.field private static final SELECT_VALUE:[Ljava/lang/String;


# instance fields
.field private final mCallCommand:Ljava/lang/String;

.field private mContentProvider:Landroid/content/IContentProvider;

.field private final mUri:Landroid/net/Uri;

.field private final mValues:Ljava/util/HashMap;
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

.field private mValuesVersion:J

.field private final mVersionSystemProperty:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .prologue
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string/jumbo v2, "value"

    aput-object v2, v0, v1

    sput-object v0, Landroid/provider/Settings$NameValueCache;->SELECT_VALUE:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;)V
    .registers 6
    .parameter "versionSystemProperty"
    .parameter "uri"
    .parameter "callCommand"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/provider/Settings$NameValueCache;->mValues:Ljava/util/HashMap;

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Landroid/provider/Settings$NameValueCache;->mValuesVersion:J

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/provider/Settings$NameValueCache;->mContentProvider:Landroid/content/IContentProvider;

    iput-object p1, p0, Landroid/provider/Settings$NameValueCache;->mVersionSystemProperty:Ljava/lang/String;

    iput-object p2, p0, Landroid/provider/Settings$NameValueCache;->mUri:Landroid/net/Uri;

    iput-object p3, p0, Landroid/provider/Settings$NameValueCache;->mCallCommand:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    .registers 18
    .parameter "cr"
    .parameter "name"

    .prologue
    iget-object v2, p0, Landroid/provider/Settings$NameValueCache;->mVersionSystemProperty:Ljava/lang/String;

    const-wide/16 v3, 0x0

    invoke-static {v2, v3, v4}, Landroid/os/SystemProperties;->getLong(Ljava/lang/String;J)J

    move-result-wide v12

    .local v12, newValuesVersion:J
    monitor-enter p0

    :try_start_9
    iget-wide v2, p0, Landroid/provider/Settings$NameValueCache;->mValuesVersion:J

    cmp-long v2, v2, v12

    if-eqz v2, :cond_16

    iget-object v2, p0, Landroid/provider/Settings$NameValueCache;->mValues:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->clear()V

    iput-wide v12, p0, Landroid/provider/Settings$NameValueCache;->mValuesVersion:J

    :cond_16
    iget-object v2, p0, Landroid/provider/Settings$NameValueCache;->mValues:Ljava/util/HashMap;

    move-object/from16 v0, p2

    invoke-virtual {v2, v0}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2d

    iget-object v2, p0, Landroid/provider/Settings$NameValueCache;->mValues:Ljava/util/HashMap;

    move-object/from16 v0, p2

    invoke-virtual {v2, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    monitor-exit p0

    move-object v14, v2

    :cond_2c
    :goto_2c
    return-object v14

    :cond_2d
    monitor-exit p0
    :try_end_2e
    .catchall {:try_start_9 .. :try_end_2e} :catchall_a8

    const/4 v1, 0x0

    .local v1, cp:Landroid/content/IContentProvider;
    monitor-enter p0

    :try_start_30
    iget-object v1, p0, Landroid/provider/Settings$NameValueCache;->mContentProvider:Landroid/content/IContentProvider;

    if-nez v1, :cond_43

    iget-object v2, p0, Landroid/provider/Settings$NameValueCache;->mUri:Landroid/net/Uri;

    invoke-virtual {v2}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p1

    invoke-virtual {v0, v2}, Landroid/content/ContentResolver;->acquireProvider(Ljava/lang/String;)Landroid/content/IContentProvider;

    move-result-object v10

    iput-object v10, p0, Landroid/provider/Settings$NameValueCache;->mContentProvider:Landroid/content/IContentProvider;

    .end local v1           #cp:Landroid/content/IContentProvider;
    .local v10, cp:Landroid/content/IContentProvider;
    move-object v1, v10

    .end local v10           #cp:Landroid/content/IContentProvider;
    .restart local v1       #cp:Landroid/content/IContentProvider;
    :cond_43
    monitor-exit p0
    :try_end_44
    .catchall {:try_start_30 .. :try_end_44} :catchall_ab

    iget-object v2, p0, Landroid/provider/Settings$NameValueCache;->mCallCommand:Ljava/lang/String;

    if-eqz v2, :cond_65

    :try_start_48
    iget-object v2, p0, Landroid/provider/Settings$NameValueCache;->mCallCommand:Ljava/lang/String;

    const/4 v3, 0x0

    move-object/from16 v0, p2

    invoke-interface {v1, v2, v0, v3}, Landroid/content/IContentProvider;->call(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v8

    .local v8, b:Landroid/os/Bundle;
    if-eqz v8, :cond_65

    invoke-virtual {v8}, Landroid/os/Bundle;->getPairValue()Ljava/lang/String;

    move-result-object v14

    .local v14, value:Ljava/lang/String;
    monitor-enter p0
    :try_end_58
    .catch Landroid/os/RemoteException; {:try_start_48 .. :try_end_58} :catch_64

    :try_start_58
    iget-object v2, p0, Landroid/provider/Settings$NameValueCache;->mValues:Ljava/util/HashMap;

    move-object/from16 v0, p2

    invoke-virtual {v2, v0, v14}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    monitor-exit p0

    goto :goto_2c

    :catchall_61
    move-exception v2

    monitor-exit p0
    :try_end_63
    .catchall {:try_start_58 .. :try_end_63} :catchall_61

    :try_start_63
    throw v2
    :try_end_64
    .catch Landroid/os/RemoteException; {:try_start_63 .. :try_end_64} :catch_64

    .end local v8           #b:Landroid/os/Bundle;
    .end local v14           #value:Ljava/lang/String;
    :catch_64
    move-exception v2

    :cond_65
    const/4 v9, 0x0

    .local v9, c:Landroid/database/Cursor;
    :try_start_66
    iget-object v2, p0, Landroid/provider/Settings$NameValueCache;->mUri:Landroid/net/Uri;

    sget-object v3, Landroid/provider/Settings$NameValueCache;->SELECT_VALUE:[Ljava/lang/String;

    const-string/jumbo v4, "name=?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    aput-object p2, v5, v6

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-interface/range {v1 .. v7}, Landroid/content/IContentProvider;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/os/ICancellationSignal;)Landroid/database/Cursor;

    move-result-object v9

    if-nez v9, :cond_ae

    const-string v2, "Settings"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Can\'t get key "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p2

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " from "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Landroid/provider/Settings$NameValueCache;->mUri:Landroid/net/Uri;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_a1
    .catchall {:try_start_66 .. :try_end_a1} :catchall_fd
    .catch Landroid/os/RemoteException; {:try_start_66 .. :try_end_a1} :catch_ce

    const/4 v14, 0x0

    if-eqz v9, :cond_2c

    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    goto :goto_2c

    .end local v1           #cp:Landroid/content/IContentProvider;
    .end local v9           #c:Landroid/database/Cursor;
    :catchall_a8
    move-exception v2

    :try_start_a9
    monitor-exit p0
    :try_end_aa
    .catchall {:try_start_a9 .. :try_end_aa} :catchall_a8

    throw v2

    .restart local v1       #cp:Landroid/content/IContentProvider;
    :catchall_ab
    move-exception v2

    :try_start_ac
    monitor-exit p0
    :try_end_ad
    .catchall {:try_start_ac .. :try_end_ad} :catchall_ab

    throw v2

    .restart local v9       #c:Landroid/database/Cursor;
    :cond_ae
    :try_start_ae
    invoke-interface {v9}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    if-eqz v2, :cond_c9

    const/4 v2, 0x0

    invoke-interface {v9, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v14

    .restart local v14       #value:Ljava/lang/String;
    :goto_b9
    monitor-enter p0
    :try_end_ba
    .catchall {:try_start_ae .. :try_end_ba} :catchall_fd
    .catch Landroid/os/RemoteException; {:try_start_ae .. :try_end_ba} :catch_ce

    :try_start_ba
    iget-object v2, p0, Landroid/provider/Settings$NameValueCache;->mValues:Ljava/util/HashMap;

    move-object/from16 v0, p2

    invoke-virtual {v2, v0, v14}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    monitor-exit p0
    :try_end_c2
    .catchall {:try_start_ba .. :try_end_c2} :catchall_cb

    if-eqz v9, :cond_2c

    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    goto/16 :goto_2c

    .end local v14           #value:Ljava/lang/String;
    :cond_c9
    const/4 v14, 0x0

    goto :goto_b9

    .restart local v14       #value:Ljava/lang/String;
    :catchall_cb
    move-exception v2

    :try_start_cc
    monitor-exit p0
    :try_end_cd
    .catchall {:try_start_cc .. :try_end_cd} :catchall_cb

    :try_start_cd
    throw v2
    :try_end_ce
    .catchall {:try_start_cd .. :try_end_ce} :catchall_fd
    .catch Landroid/os/RemoteException; {:try_start_cd .. :try_end_ce} :catch_ce

    .end local v14           #value:Ljava/lang/String;
    :catch_ce
    move-exception v11

    .local v11, e:Landroid/os/RemoteException;
    :try_start_cf
    const-string v2, "Settings"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Can\'t get key "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p2

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " from "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Landroid/provider/Settings$NameValueCache;->mUri:Landroid/net/Uri;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3, v11}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_f5
    .catchall {:try_start_cf .. :try_end_f5} :catchall_fd

    const/4 v14, 0x0

    if-eqz v9, :cond_2c

    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    goto/16 :goto_2c

    .end local v11           #e:Landroid/os/RemoteException;
    :catchall_fd
    move-exception v2

    if-eqz v9, :cond_103

    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    :cond_103
    throw v2
.end method
