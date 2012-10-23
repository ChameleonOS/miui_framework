.class Landroid/widget/RemoteViewsService$RemoteViewsFactoryAdapter;
.super Lcom/android/internal/widget/IRemoteViewsFactory$Stub;
.source "RemoteViewsService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/RemoteViewsService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "RemoteViewsFactoryAdapter"
.end annotation


# instance fields
.field private mFactory:Landroid/widget/RemoteViewsService$RemoteViewsFactory;

.field private mIsCreated:Z


# direct methods
.method public constructor <init>(Landroid/widget/RemoteViewsService$RemoteViewsFactory;Z)V
    .registers 3
    .parameter "factory"
    .parameter "isCreated"

    .prologue
    .line 133
    invoke-direct {p0}, Lcom/android/internal/widget/IRemoteViewsFactory$Stub;-><init>()V

    .line 134
    iput-object p1, p0, Landroid/widget/RemoteViewsService$RemoteViewsFactoryAdapter;->mFactory:Landroid/widget/RemoteViewsService$RemoteViewsFactory;

    .line 135
    iput-boolean p2, p0, Landroid/widget/RemoteViewsService$RemoteViewsFactoryAdapter;->mIsCreated:Z

    .line 136
    return-void
.end method


# virtual methods
.method public declared-synchronized getCount()I
    .registers 5

    .prologue
    .line 152
    monitor-enter p0

    const/4 v0, 0x0

    .line 154
    .local v0, count:I
    :try_start_2
    iget-object v3, p0, Landroid/widget/RemoteViewsService$RemoteViewsFactoryAdapter;->mFactory:Landroid/widget/RemoteViewsService$RemoteViewsFactory;

    invoke-interface {v3}, Landroid/widget/RemoteViewsService$RemoteViewsFactory;->getCount()I
    :try_end_7
    .catchall {:try_start_2 .. :try_end_7} :catchall_17
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_7} :catch_a

    move-result v0

    .line 159
    :goto_8
    monitor-exit p0

    return v0

    .line 155
    :catch_a
    move-exception v1

    .line 156
    .local v1, ex:Ljava/lang/Exception;
    :try_start_b
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    .line 157
    .local v2, t:Ljava/lang/Thread;
    invoke-static {}, Ljava/lang/Thread;->getDefaultUncaughtExceptionHandler()Ljava/lang/Thread$UncaughtExceptionHandler;

    move-result-object v3

    invoke-interface {v3, v2, v1}, Ljava/lang/Thread$UncaughtExceptionHandler;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V
    :try_end_16
    .catchall {:try_start_b .. :try_end_16} :catchall_17

    goto :goto_8

    .line 152
    .end local v1           #ex:Ljava/lang/Exception;
    .end local v2           #t:Ljava/lang/Thread;
    :catchall_17
    move-exception v3

    monitor-exit p0

    throw v3
.end method

.method public declared-synchronized getItemId(I)J
    .registers 7
    .parameter "position"

    .prologue
    .line 195
    monitor-enter p0

    const-wide/16 v1, 0x0

    .line 197
    .local v1, id:J
    :try_start_3
    iget-object v4, p0, Landroid/widget/RemoteViewsService$RemoteViewsFactoryAdapter;->mFactory:Landroid/widget/RemoteViewsService$RemoteViewsFactory;

    invoke-interface {v4, p1}, Landroid/widget/RemoteViewsService$RemoteViewsFactory;->getItemId(I)J
    :try_end_8
    .catchall {:try_start_3 .. :try_end_8} :catchall_18
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_8} :catch_b

    move-result-wide v1

    .line 202
    :goto_9
    monitor-exit p0

    return-wide v1

    .line 198
    :catch_b
    move-exception v0

    .line 199
    .local v0, ex:Ljava/lang/Exception;
    :try_start_c
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v3

    .line 200
    .local v3, t:Ljava/lang/Thread;
    invoke-static {}, Ljava/lang/Thread;->getDefaultUncaughtExceptionHandler()Ljava/lang/Thread$UncaughtExceptionHandler;

    move-result-object v4

    invoke-interface {v4, v3, v0}, Ljava/lang/Thread$UncaughtExceptionHandler;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V
    :try_end_17
    .catchall {:try_start_c .. :try_end_17} :catchall_18

    goto :goto_9

    .line 195
    .end local v0           #ex:Ljava/lang/Exception;
    .end local v3           #t:Ljava/lang/Thread;
    :catchall_18
    move-exception v4

    monitor-exit p0

    throw v4
.end method

.method public declared-synchronized getLoadingView()Landroid/widget/RemoteViews;
    .registers 5

    .prologue
    .line 175
    monitor-enter p0

    const/4 v1, 0x0

    .line 177
    .local v1, rv:Landroid/widget/RemoteViews;
    :try_start_2
    iget-object v3, p0, Landroid/widget/RemoteViewsService$RemoteViewsFactoryAdapter;->mFactory:Landroid/widget/RemoteViewsService$RemoteViewsFactory;

    invoke-interface {v3}, Landroid/widget/RemoteViewsService$RemoteViewsFactory;->getLoadingView()Landroid/widget/RemoteViews;
    :try_end_7
    .catchall {:try_start_2 .. :try_end_7} :catchall_17
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_7} :catch_a

    move-result-object v1

    .line 182
    :goto_8
    monitor-exit p0

    return-object v1

    .line 178
    :catch_a
    move-exception v0

    .line 179
    .local v0, ex:Ljava/lang/Exception;
    :try_start_b
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    .line 180
    .local v2, t:Ljava/lang/Thread;
    invoke-static {}, Ljava/lang/Thread;->getDefaultUncaughtExceptionHandler()Ljava/lang/Thread$UncaughtExceptionHandler;

    move-result-object v3

    invoke-interface {v3, v2, v0}, Ljava/lang/Thread$UncaughtExceptionHandler;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V
    :try_end_16
    .catchall {:try_start_b .. :try_end_16} :catchall_17

    goto :goto_8

    .line 175
    .end local v0           #ex:Ljava/lang/Exception;
    .end local v2           #t:Ljava/lang/Thread;
    :catchall_17
    move-exception v3

    monitor-exit p0

    throw v3
.end method

.method public declared-synchronized getViewAt(I)Landroid/widget/RemoteViews;
    .registers 6
    .parameter "position"

    .prologue
    .line 162
    monitor-enter p0

    const/4 v1, 0x0

    .line 164
    .local v1, rv:Landroid/widget/RemoteViews;
    :try_start_2
    iget-object v3, p0, Landroid/widget/RemoteViewsService$RemoteViewsFactoryAdapter;->mFactory:Landroid/widget/RemoteViewsService$RemoteViewsFactory;

    invoke-interface {v3, p1}, Landroid/widget/RemoteViewsService$RemoteViewsFactory;->getViewAt(I)Landroid/widget/RemoteViews;

    move-result-object v1

    .line 165
    if-eqz v1, :cond_e

    .line 166
    const/4 v3, 0x1

    invoke-virtual {v1, v3}, Landroid/widget/RemoteViews;->setIsWidgetCollectionChild(Z)V
    :try_end_e
    .catchall {:try_start_2 .. :try_end_e} :catchall_1d
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_e} :catch_10

    .line 172
    :cond_e
    :goto_e
    monitor-exit p0

    return-object v1

    .line 168
    :catch_10
    move-exception v0

    .line 169
    .local v0, ex:Ljava/lang/Exception;
    :try_start_11
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    .line 170
    .local v2, t:Ljava/lang/Thread;
    invoke-static {}, Ljava/lang/Thread;->getDefaultUncaughtExceptionHandler()Ljava/lang/Thread$UncaughtExceptionHandler;

    move-result-object v3

    invoke-interface {v3, v2, v0}, Ljava/lang/Thread$UncaughtExceptionHandler;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V
    :try_end_1c
    .catchall {:try_start_11 .. :try_end_1c} :catchall_1d

    goto :goto_e

    .line 162
    .end local v0           #ex:Ljava/lang/Exception;
    .end local v2           #t:Ljava/lang/Thread;
    :catchall_1d
    move-exception v3

    monitor-exit p0

    throw v3
.end method

.method public declared-synchronized getViewTypeCount()I
    .registers 5

    .prologue
    .line 185
    monitor-enter p0

    const/4 v0, 0x0

    .line 187
    .local v0, count:I
    :try_start_2
    iget-object v3, p0, Landroid/widget/RemoteViewsService$RemoteViewsFactoryAdapter;->mFactory:Landroid/widget/RemoteViewsService$RemoteViewsFactory;

    invoke-interface {v3}, Landroid/widget/RemoteViewsService$RemoteViewsFactory;->getViewTypeCount()I
    :try_end_7
    .catchall {:try_start_2 .. :try_end_7} :catchall_17
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_7} :catch_a

    move-result v0

    .line 192
    :goto_8
    monitor-exit p0

    return v0

    .line 188
    :catch_a
    move-exception v1

    .line 189
    .local v1, ex:Ljava/lang/Exception;
    :try_start_b
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    .line 190
    .local v2, t:Ljava/lang/Thread;
    invoke-static {}, Ljava/lang/Thread;->getDefaultUncaughtExceptionHandler()Ljava/lang/Thread$UncaughtExceptionHandler;

    move-result-object v3

    invoke-interface {v3, v2, v1}, Ljava/lang/Thread$UncaughtExceptionHandler;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V
    :try_end_16
    .catchall {:try_start_b .. :try_end_16} :catchall_17

    goto :goto_8

    .line 185
    .end local v1           #ex:Ljava/lang/Exception;
    .end local v2           #t:Ljava/lang/Thread;
    :catchall_17
    move-exception v3

    monitor-exit p0

    throw v3
.end method

.method public declared-synchronized hasStableIds()Z
    .registers 5

    .prologue
    .line 205
    monitor-enter p0

    const/4 v1, 0x0

    .line 207
    .local v1, hasStableIds:Z
    :try_start_2
    iget-object v3, p0, Landroid/widget/RemoteViewsService$RemoteViewsFactoryAdapter;->mFactory:Landroid/widget/RemoteViewsService$RemoteViewsFactory;

    invoke-interface {v3}, Landroid/widget/RemoteViewsService$RemoteViewsFactory;->hasStableIds()Z
    :try_end_7
    .catchall {:try_start_2 .. :try_end_7} :catchall_17
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_7} :catch_a

    move-result v1

    .line 212
    :goto_8
    monitor-exit p0

    return v1

    .line 208
    :catch_a
    move-exception v0

    .line 209
    .local v0, ex:Ljava/lang/Exception;
    :try_start_b
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    .line 210
    .local v2, t:Ljava/lang/Thread;
    invoke-static {}, Ljava/lang/Thread;->getDefaultUncaughtExceptionHandler()Ljava/lang/Thread$UncaughtExceptionHandler;

    move-result-object v3

    invoke-interface {v3, v2, v0}, Ljava/lang/Thread$UncaughtExceptionHandler;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V
    :try_end_16
    .catchall {:try_start_b .. :try_end_16} :catchall_17

    goto :goto_8

    .line 205
    .end local v0           #ex:Ljava/lang/Exception;
    .end local v2           #t:Ljava/lang/Thread;
    :catchall_17
    move-exception v3

    monitor-exit p0

    throw v3
.end method

.method public declared-synchronized isCreated()Z
    .registers 2

    .prologue
    .line 138
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/widget/RemoteViewsService$RemoteViewsFactoryAdapter;->mIsCreated:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized onDataSetChanged()V
    .registers 4

    .prologue
    .line 142
    monitor-enter p0

    :try_start_1
    iget-object v2, p0, Landroid/widget/RemoteViewsService$RemoteViewsFactoryAdapter;->mFactory:Landroid/widget/RemoteViewsService$RemoteViewsFactory;

    invoke-interface {v2}, Landroid/widget/RemoteViewsService$RemoteViewsFactory;->onDataSetChanged()V
    :try_end_6
    .catchall {:try_start_1 .. :try_end_6} :catchall_15
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_6} :catch_8

    .line 147
    :goto_6
    monitor-exit p0

    return-void

    .line 143
    :catch_8
    move-exception v0

    .line 144
    .local v0, ex:Ljava/lang/Exception;
    :try_start_9
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    .line 145
    .local v1, t:Ljava/lang/Thread;
    invoke-static {}, Ljava/lang/Thread;->getDefaultUncaughtExceptionHandler()Ljava/lang/Thread$UncaughtExceptionHandler;

    move-result-object v2

    invoke-interface {v2, v1, v0}, Ljava/lang/Thread$UncaughtExceptionHandler;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V
    :try_end_14
    .catchall {:try_start_9 .. :try_end_14} :catchall_15

    goto :goto_6

    .line 142
    .end local v0           #ex:Ljava/lang/Exception;
    .end local v1           #t:Ljava/lang/Thread;
    :catchall_15
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized onDataSetChangedAsync()V
    .registers 2

    .prologue
    .line 149
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/widget/RemoteViewsService$RemoteViewsFactoryAdapter;->onDataSetChanged()V
    :try_end_4
    .catchall {:try_start_1 .. :try_end_4} :catchall_6

    .line 150
    monitor-exit p0

    return-void

    .line 149
    :catchall_6
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public onDestroy(Landroid/content/Intent;)V
    .registers 8
    .parameter "intent"

    .prologue
    .line 215
    invoke-static {}, Landroid/widget/RemoteViewsService;->access$000()Ljava/lang/Object;

    move-result-object v5

    monitor-enter v5

    .line 216
    :try_start_5
    new-instance v2, Landroid/content/Intent$FilterComparison;

    invoke-direct {v2, p1}, Landroid/content/Intent$FilterComparison;-><init>(Landroid/content/Intent;)V

    .line 217
    .local v2, fc:Landroid/content/Intent$FilterComparison;
    invoke-static {}, Landroid/widget/RemoteViewsService;->access$100()Ljava/util/HashMap;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_28

    .line 218
    invoke-static {}, Landroid/widget/RemoteViewsService;->access$100()Ljava/util/HashMap;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/widget/RemoteViewsService$RemoteViewsFactory;
    :try_end_1e
    .catchall {:try_start_5 .. :try_end_1e} :catchall_37

    .line 220
    .local v1, factory:Landroid/widget/RemoteViewsService$RemoteViewsFactory;
    :try_start_1e
    invoke-interface {v1}, Landroid/widget/RemoteViewsService$RemoteViewsFactory;->onDestroy()V
    :try_end_21
    .catchall {:try_start_1e .. :try_end_21} :catchall_37
    .catch Ljava/lang/Exception; {:try_start_1e .. :try_end_21} :catch_2a

    .line 225
    :goto_21
    :try_start_21
    invoke-static {}, Landroid/widget/RemoteViewsService;->access$100()Ljava/util/HashMap;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 227
    .end local v1           #factory:Landroid/widget/RemoteViewsService$RemoteViewsFactory;
    :cond_28
    monitor-exit v5

    .line 228
    return-void

    .line 221
    .restart local v1       #factory:Landroid/widget/RemoteViewsService$RemoteViewsFactory;
    :catch_2a
    move-exception v0

    .line 222
    .local v0, ex:Ljava/lang/Exception;
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v3

    .line 223
    .local v3, t:Ljava/lang/Thread;
    invoke-static {}, Ljava/lang/Thread;->getDefaultUncaughtExceptionHandler()Ljava/lang/Thread$UncaughtExceptionHandler;

    move-result-object v4

    invoke-interface {v4, v3, v0}, Ljava/lang/Thread$UncaughtExceptionHandler;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V

    goto :goto_21

    .line 227
    .end local v0           #ex:Ljava/lang/Exception;
    .end local v1           #factory:Landroid/widget/RemoteViewsService$RemoteViewsFactory;
    .end local v2           #fc:Landroid/content/Intent$FilterComparison;
    .end local v3           #t:Ljava/lang/Thread;
    :catchall_37
    move-exception v4

    monitor-exit v5
    :try_end_39
    .catchall {:try_start_21 .. :try_end_39} :catchall_37

    throw v4
.end method
