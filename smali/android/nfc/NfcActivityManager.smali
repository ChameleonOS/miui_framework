.class public final Landroid/nfc/NfcActivityManager;
.super Landroid/nfc/INdefPushCallback$Stub;
.source "NfcActivityManager.java"

# interfaces
.implements Landroid/app/Application$ActivityLifecycleCallbacks;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/nfc/NfcActivityManager$NfcActivityState;,
        Landroid/nfc/NfcActivityManager$NfcApplicationState;
    }
.end annotation


# static fields
.field static final DBG:Ljava/lang/Boolean; = null

.field static final TAG:Ljava/lang/String; = "NFC"


# instance fields
.field final mActivities:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/nfc/NfcActivityManager$NfcActivityState;",
            ">;"
        }
    .end annotation
.end field

.field final mAdapter:Landroid/nfc/NfcAdapter;

.field final mApps:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/nfc/NfcActivityManager$NfcApplicationState;",
            ">;"
        }
    .end annotation
.end field

.field final mDefaultEvent:Landroid/nfc/NfcEvent;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 41
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Landroid/nfc/NfcActivityManager;->DBG:Ljava/lang/Boolean;

    return-void
.end method

.method public constructor <init>(Landroid/nfc/NfcAdapter;)V
    .registers 4
    .parameter "adapter"

    .prologue
    .line 185
    invoke-direct {p0}, Landroid/nfc/INdefPushCallback$Stub;-><init>()V

    .line 186
    iput-object p1, p0, Landroid/nfc/NfcActivityManager;->mAdapter:Landroid/nfc/NfcAdapter;

    .line 187
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Landroid/nfc/NfcActivityManager;->mActivities:Ljava/util/List;

    .line 188
    new-instance v0, Ljava/util/ArrayList;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Landroid/nfc/NfcActivityManager;->mApps:Ljava/util/List;

    .line 189
    new-instance v0, Landroid/nfc/NfcEvent;

    iget-object v1, p0, Landroid/nfc/NfcActivityManager;->mAdapter:Landroid/nfc/NfcAdapter;

    invoke-direct {v0, v1}, Landroid/nfc/NfcEvent;-><init>(Landroid/nfc/NfcAdapter;)V

    iput-object v0, p0, Landroid/nfc/NfcActivityManager;->mDefaultEvent:Landroid/nfc/NfcEvent;

    .line 190
    return-void
.end method


# virtual methods
.method public createMessage()Landroid/nfc/NdefMessage;
    .registers 5

    .prologue
    .line 274
    monitor-enter p0

    .line 275
    :try_start_1
    invoke-virtual {p0}, Landroid/nfc/NfcActivityManager;->findResumedActivityState()Landroid/nfc/NfcActivityManager$NfcActivityState;

    move-result-object v2

    .line 276
    .local v2, state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    if-nez v2, :cond_a

    const/4 v1, 0x0

    monitor-exit p0

    .line 286
    :cond_9
    :goto_9
    return-object v1

    .line 278
    :cond_a
    iget-object v0, v2, Landroid/nfc/NfcActivityManager$NfcActivityState;->ndefMessageCallback:Landroid/nfc/NfcAdapter$CreateNdefMessageCallback;

    .line 279
    .local v0, callback:Landroid/nfc/NfcAdapter$CreateNdefMessageCallback;
    iget-object v1, v2, Landroid/nfc/NfcActivityManager$NfcActivityState;->ndefMessage:Landroid/nfc/NdefMessage;

    .line 280
    .local v1, message:Landroid/nfc/NdefMessage;
    monitor-exit p0
    :try_end_f
    .catchall {:try_start_1 .. :try_end_f} :catchall_18

    .line 283
    if-eqz v0, :cond_9

    .line 284
    iget-object v3, p0, Landroid/nfc/NfcActivityManager;->mDefaultEvent:Landroid/nfc/NfcEvent;

    invoke-interface {v0, v3}, Landroid/nfc/NfcAdapter$CreateNdefMessageCallback;->createNdefMessage(Landroid/nfc/NfcEvent;)Landroid/nfc/NdefMessage;

    move-result-object v1

    goto :goto_9

    .line 280
    .end local v0           #callback:Landroid/nfc/NfcAdapter$CreateNdefMessageCallback;
    .end local v1           #message:Landroid/nfc/NdefMessage;
    .end local v2           #state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    :catchall_18
    move-exception v3

    :try_start_19
    monitor-exit p0
    :try_end_1a
    .catchall {:try_start_19 .. :try_end_1a} :catchall_18

    throw v3
.end method

.method declared-synchronized destroyActivityState(Landroid/app/Activity;)V
    .registers 4
    .parameter "activity"

    .prologue
    .line 178
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0, p1}, Landroid/nfc/NfcActivityManager;->findActivityState(Landroid/app/Activity;)Landroid/nfc/NfcActivityManager$NfcActivityState;

    move-result-object v0

    .line 179
    .local v0, activityState:Landroid/nfc/NfcActivityManager$NfcActivityState;
    if-eqz v0, :cond_f

    .line 180
    invoke-virtual {v0}, Landroid/nfc/NfcActivityManager$NfcActivityState;->destroy()V

    .line 181
    iget-object v1, p0, Landroid/nfc/NfcActivityManager;->mActivities:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->remove(Ljava/lang/Object;)Z
    :try_end_f
    .catchall {:try_start_1 .. :try_end_f} :catchall_11

    .line 183
    :cond_f
    monitor-exit p0

    return-void

    .line 178
    .end local v0           #activityState:Landroid/nfc/NfcActivityManager$NfcActivityState;
    :catchall_11
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method declared-synchronized findActivityState(Landroid/app/Activity;)Landroid/nfc/NfcActivityManager$NfcActivityState;
    .registers 5
    .parameter "activity"

    .prologue
    .line 150
    monitor-enter p0

    :try_start_1
    iget-object v2, p0, Landroid/nfc/NfcActivityManager;->mActivities:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :cond_7
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_19

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/nfc/NfcActivityManager$NfcActivityState;

    .line 151
    .local v1, state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    iget-object v2, v1, Landroid/nfc/NfcActivityManager$NfcActivityState;->activity:Landroid/app/Activity;
    :try_end_15
    .catchall {:try_start_1 .. :try_end_15} :catchall_1b

    if-ne v2, p1, :cond_7

    .line 155
    .end local v1           #state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    :goto_17
    monitor-exit p0

    return-object v1

    :cond_19
    const/4 v1, 0x0

    goto :goto_17

    .line 150
    .end local v0           #i$:Ljava/util/Iterator;
    :catchall_1b
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method findAppState(Landroid/app/Application;)Landroid/nfc/NfcActivityManager$NfcApplicationState;
    .registers 5
    .parameter "app"

    .prologue
    .line 76
    iget-object v2, p0, Landroid/nfc/NfcActivityManager;->mApps:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, i$:Ljava/util/Iterator;
    :cond_6
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_17

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/nfc/NfcActivityManager$NfcApplicationState;

    .line 77
    .local v0, appState:Landroid/nfc/NfcActivityManager$NfcApplicationState;
    iget-object v2, v0, Landroid/nfc/NfcActivityManager$NfcApplicationState;->app:Landroid/app/Application;

    if-ne v2, p1, :cond_6

    .line 81
    .end local v0           #appState:Landroid/nfc/NfcActivityManager$NfcApplicationState;
    :goto_16
    return-object v0

    :cond_17
    const/4 v0, 0x0

    goto :goto_16
.end method

.method declared-synchronized findResumedActivityState()Landroid/nfc/NfcActivityManager$NfcActivityState;
    .registers 4

    .prologue
    .line 169
    monitor-enter p0

    :try_start_1
    iget-object v2, p0, Landroid/nfc/NfcActivityManager;->mActivities:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :cond_7
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_19

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/nfc/NfcActivityManager$NfcActivityState;

    .line 170
    .local v1, state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    iget-boolean v2, v1, Landroid/nfc/NfcActivityManager$NfcActivityState;->resumed:Z
    :try_end_15
    .catchall {:try_start_1 .. :try_end_15} :catchall_1b

    if-eqz v2, :cond_7

    .line 174
    .end local v1           #state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    :goto_17
    monitor-exit p0

    return-object v1

    :cond_19
    const/4 v1, 0x0

    goto :goto_17

    .line 169
    .end local v0           #i$:Ljava/util/Iterator;
    :catchall_1b
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method declared-synchronized getActivityState(Landroid/app/Activity;)Landroid/nfc/NfcActivityManager$NfcActivityState;
    .registers 4
    .parameter "activity"

    .prologue
    .line 160
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0, p1}, Landroid/nfc/NfcActivityManager;->findActivityState(Landroid/app/Activity;)Landroid/nfc/NfcActivityManager$NfcActivityState;

    move-result-object v0

    .line 161
    .local v0, state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    if-nez v0, :cond_11

    .line 162
    new-instance v0, Landroid/nfc/NfcActivityManager$NfcActivityState;

    .end local v0           #state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    invoke-direct {v0, p0, p1}, Landroid/nfc/NfcActivityManager$NfcActivityState;-><init>(Landroid/nfc/NfcActivityManager;Landroid/app/Activity;)V

    .line 163
    .restart local v0       #state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    iget-object v1, p0, Landroid/nfc/NfcActivityManager;->mActivities:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_11
    .catchall {:try_start_1 .. :try_end_11} :catchall_13

    .line 165
    :cond_11
    monitor-exit p0

    return-object v0

    .line 160
    .end local v0           #state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    :catchall_13
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public getUris()[Landroid/net/Uri;
    .registers 12

    .prologue
    const/4 v8, 0x0

    .line 295
    monitor-enter p0

    .line 296
    :try_start_2
    invoke-virtual {p0}, Landroid/nfc/NfcActivityManager;->findResumedActivityState()Landroid/nfc/NfcActivityManager$NfcActivityState;

    move-result-object v5

    .line 297
    .local v5, state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    if-nez v5, :cond_b

    monitor-exit p0

    move-object v7, v8

    .line 320
    :cond_a
    :goto_a
    return-object v7

    .line 298
    :cond_b
    iget-object v7, v5, Landroid/nfc/NfcActivityManager$NfcActivityState;->uris:[Landroid/net/Uri;

    .line 299
    .local v7, uris:[Landroid/net/Uri;
    iget-object v1, v5, Landroid/nfc/NfcActivityManager$NfcActivityState;->uriCallback:Landroid/nfc/NfcAdapter$CreateBeamUrisCallback;

    .line 300
    .local v1, callback:Landroid/nfc/NfcAdapter$CreateBeamUrisCallback;
    monitor-exit p0
    :try_end_10
    .catchall {:try_start_2 .. :try_end_10} :catchall_2c

    .line 301
    if-eqz v1, :cond_a

    .line 302
    iget-object v9, p0, Landroid/nfc/NfcActivityManager;->mDefaultEvent:Landroid/nfc/NfcEvent;

    invoke-interface {v1, v9}, Landroid/nfc/NfcAdapter$CreateBeamUrisCallback;->createBeamUris(Landroid/nfc/NfcEvent;)[Landroid/net/Uri;

    move-result-object v7

    .line 303
    if-eqz v7, :cond_a

    .line 304
    move-object v0, v7

    .local v0, arr$:[Landroid/net/Uri;
    array-length v3, v0

    .local v3, len$:I
    const/4 v2, 0x0

    .local v2, i$:I
    :goto_1d
    if-ge v2, v3, :cond_a

    aget-object v6, v0, v2

    .line 305
    .local v6, uri:Landroid/net/Uri;
    if-nez v6, :cond_2f

    .line 306
    const-string v9, "NFC"

    const-string v10, "Uri not allowed to be null."

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    move-object v7, v8

    .line 307
    goto :goto_a

    .line 300
    .end local v0           #arr$:[Landroid/net/Uri;
    .end local v1           #callback:Landroid/nfc/NfcAdapter$CreateBeamUrisCallback;
    .end local v2           #i$:I
    .end local v3           #len$:I
    .end local v5           #state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    .end local v6           #uri:Landroid/net/Uri;
    .end local v7           #uris:[Landroid/net/Uri;
    :catchall_2c
    move-exception v8

    :try_start_2d
    monitor-exit p0
    :try_end_2e
    .catchall {:try_start_2d .. :try_end_2e} :catchall_2c

    throw v8

    .line 309
    .restart local v0       #arr$:[Landroid/net/Uri;
    .restart local v1       #callback:Landroid/nfc/NfcAdapter$CreateBeamUrisCallback;
    .restart local v2       #i$:I
    .restart local v3       #len$:I
    .restart local v5       #state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    .restart local v6       #uri:Landroid/net/Uri;
    .restart local v7       #uris:[Landroid/net/Uri;
    :cond_2f
    invoke-virtual {v6}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v4

    .line 310
    .local v4, scheme:Ljava/lang/String;
    if-eqz v4, :cond_45

    const-string v9, "file"

    invoke-virtual {v4, v9}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_4e

    const-string v9, "content"

    invoke-virtual {v4, v9}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_4e

    .line 312
    :cond_45
    const-string v9, "NFC"

    const-string v10, "Uri needs to have either scheme file or scheme content"

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    move-object v7, v8

    .line 314
    goto :goto_a

    .line 304
    :cond_4e
    add-int/lit8 v2, v2, 0x1

    goto :goto_1d
.end method

.method public onActivityCreated(Landroid/app/Activity;Landroid/os/Bundle;)V
    .registers 3
    .parameter "activity"
    .parameter "savedInstanceState"

    .prologue
    .line 343
    return-void
.end method

.method public onActivityDestroyed(Landroid/app/Activity;)V
    .registers 6
    .parameter "activity"

    .prologue
    .line 384
    monitor-enter p0

    .line 385
    :try_start_1
    invoke-virtual {p0, p1}, Landroid/nfc/NfcActivityManager;->findActivityState(Landroid/app/Activity;)Landroid/nfc/NfcActivityManager$NfcActivityState;

    move-result-object v0

    .line 386
    .local v0, state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    sget-object v1, Landroid/nfc/NfcActivityManager;->DBG:Ljava/lang/Boolean;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_30

    const-string v1, "NFC"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "onDestroy() for "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 387
    :cond_30
    if-eqz v0, :cond_35

    .line 389
    invoke-virtual {p0, p1}, Landroid/nfc/NfcActivityManager;->destroyActivityState(Landroid/app/Activity;)V

    .line 391
    :cond_35
    monitor-exit p0

    .line 392
    return-void

    .line 391
    .end local v0           #state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    :catchall_37
    move-exception v1

    monitor-exit p0
    :try_end_39
    .catchall {:try_start_1 .. :try_end_39} :catchall_37

    throw v1
.end method

.method public onActivityPaused(Landroid/app/Activity;)V
    .registers 7
    .parameter "activity"

    .prologue
    const/4 v4, 0x0

    .line 364
    monitor-enter p0

    .line 365
    :try_start_2
    invoke-virtual {p0, p1}, Landroid/nfc/NfcActivityManager;->findActivityState(Landroid/app/Activity;)Landroid/nfc/NfcActivityManager$NfcActivityState;

    move-result-object v0

    .line 366
    .local v0, state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    sget-object v1, Landroid/nfc/NfcActivityManager;->DBG:Ljava/lang/Boolean;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_31

    const-string v1, "NFC"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "onPause() for "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 367
    :cond_31
    if-nez v0, :cond_35

    monitor-exit p0

    .line 371
    :goto_34
    return-void

    .line 368
    :cond_35
    const/4 v1, 0x0

    iput-boolean v1, v0, Landroid/nfc/NfcActivityManager$NfcActivityState;->resumed:Z

    .line 369
    monitor-exit p0
    :try_end_39
    .catchall {:try_start_2 .. :try_end_39} :catchall_3d

    .line 370
    invoke-virtual {p0, v4}, Landroid/nfc/NfcActivityManager;->requestNfcServiceCallback(Z)V

    goto :goto_34

    .line 369
    .end local v0           #state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    :catchall_3d
    move-exception v1

    :try_start_3e
    monitor-exit p0
    :try_end_3f
    .catchall {:try_start_3e .. :try_end_3f} :catchall_3d

    throw v1
.end method

.method public onActivityResumed(Landroid/app/Activity;)V
    .registers 7
    .parameter "activity"

    .prologue
    const/4 v4, 0x1

    .line 352
    monitor-enter p0

    .line 353
    :try_start_2
    invoke-virtual {p0, p1}, Landroid/nfc/NfcActivityManager;->findActivityState(Landroid/app/Activity;)Landroid/nfc/NfcActivityManager$NfcActivityState;

    move-result-object v0

    .line 354
    .local v0, state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    sget-object v1, Landroid/nfc/NfcActivityManager;->DBG:Ljava/lang/Boolean;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_31

    const-string v1, "NFC"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "onResume() for "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 355
    :cond_31
    if-nez v0, :cond_35

    monitor-exit p0

    .line 359
    :goto_34
    return-void

    .line 356
    :cond_35
    const/4 v1, 0x1

    iput-boolean v1, v0, Landroid/nfc/NfcActivityManager$NfcActivityState;->resumed:Z

    .line 357
    monitor-exit p0
    :try_end_39
    .catchall {:try_start_2 .. :try_end_39} :catchall_3d

    .line 358
    invoke-virtual {p0, v4}, Landroid/nfc/NfcActivityManager;->requestNfcServiceCallback(Z)V

    goto :goto_34

    .line 357
    .end local v0           #state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    :catchall_3d
    move-exception v1

    :try_start_3e
    monitor-exit p0
    :try_end_3f
    .catchall {:try_start_3e .. :try_end_3f} :catchall_3d

    throw v1
.end method

.method public onActivitySaveInstanceState(Landroid/app/Activity;Landroid/os/Bundle;)V
    .registers 3
    .parameter "activity"
    .parameter "outState"

    .prologue
    .line 379
    return-void
.end method

.method public onActivityStarted(Landroid/app/Activity;)V
    .registers 2
    .parameter "activity"

    .prologue
    .line 347
    return-void
.end method

.method public onActivityStopped(Landroid/app/Activity;)V
    .registers 2
    .parameter "activity"

    .prologue
    .line 375
    return-void
.end method

.method public onNdefPushComplete()V
    .registers 4

    .prologue
    .line 328
    monitor-enter p0

    .line 329
    :try_start_1
    invoke-virtual {p0}, Landroid/nfc/NfcActivityManager;->findResumedActivityState()Landroid/nfc/NfcActivityManager$NfcActivityState;

    move-result-object v1

    .line 330
    .local v1, state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    if-nez v1, :cond_9

    monitor-exit p0

    .line 339
    :cond_8
    :goto_8
    return-void

    .line 332
    :cond_9
    iget-object v0, v1, Landroid/nfc/NfcActivityManager$NfcActivityState;->onNdefPushCompleteCallback:Landroid/nfc/NfcAdapter$OnNdefPushCompleteCallback;

    .line 333
    .local v0, callback:Landroid/nfc/NfcAdapter$OnNdefPushCompleteCallback;
    monitor-exit p0
    :try_end_c
    .catchall {:try_start_1 .. :try_end_c} :catchall_14

    .line 336
    if-eqz v0, :cond_8

    .line 337
    iget-object v2, p0, Landroid/nfc/NfcActivityManager;->mDefaultEvent:Landroid/nfc/NfcEvent;

    invoke-interface {v0, v2}, Landroid/nfc/NfcAdapter$OnNdefPushCompleteCallback;->onNdefPushComplete(Landroid/nfc/NfcEvent;)V

    goto :goto_8

    .line 333
    .end local v0           #callback:Landroid/nfc/NfcAdapter$OnNdefPushCompleteCallback;
    .end local v1           #state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    :catchall_14
    move-exception v2

    :try_start_15
    monitor-exit p0
    :try_end_16
    .catchall {:try_start_15 .. :try_end_16} :catchall_14

    throw v2
.end method

.method registerApplication(Landroid/app/Application;)V
    .registers 4
    .parameter "app"

    .prologue
    .line 85
    invoke-virtual {p0, p1}, Landroid/nfc/NfcActivityManager;->findAppState(Landroid/app/Application;)Landroid/nfc/NfcActivityManager$NfcApplicationState;

    move-result-object v0

    .line 86
    .local v0, appState:Landroid/nfc/NfcActivityManager$NfcApplicationState;
    if-nez v0, :cond_10

    .line 87
    new-instance v0, Landroid/nfc/NfcActivityManager$NfcApplicationState;

    .end local v0           #appState:Landroid/nfc/NfcActivityManager$NfcApplicationState;
    invoke-direct {v0, p0, p1}, Landroid/nfc/NfcActivityManager$NfcApplicationState;-><init>(Landroid/nfc/NfcActivityManager;Landroid/app/Application;)V

    .line 88
    .restart local v0       #appState:Landroid/nfc/NfcActivityManager$NfcApplicationState;
    iget-object v1, p0, Landroid/nfc/NfcActivityManager;->mApps:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 90
    :cond_10
    invoke-virtual {v0}, Landroid/nfc/NfcActivityManager$NfcApplicationState;->register()V

    .line 91
    return-void
.end method

.method requestNfcServiceCallback(Z)V
    .registers 5
    .parameter "request"

    .prologue
    .line 263
    :try_start_0
    sget-object v2, Landroid/nfc/NfcAdapter;->sService:Landroid/nfc/INfcAdapter;

    if-eqz p1, :cond_9

    move-object v1, p0

    :goto_5
    invoke-interface {v2, v1}, Landroid/nfc/INfcAdapter;->setNdefPushCallback(Landroid/nfc/INdefPushCallback;)V
    :try_end_8
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_8} :catch_b

    .line 267
    :goto_8
    return-void

    .line 263
    :cond_9
    const/4 v1, 0x0

    goto :goto_5

    .line 264
    :catch_b
    move-exception v0

    .line 265
    .local v0, e:Landroid/os/RemoteException;
    iget-object v1, p0, Landroid/nfc/NfcActivityManager;->mAdapter:Landroid/nfc/NfcAdapter;

    invoke-virtual {v1, v0}, Landroid/nfc/NfcAdapter;->attemptDeadServiceRecovery(Ljava/lang/Exception;)V

    goto :goto_8
.end method

.method public setNdefPushContentUri(Landroid/app/Activity;[Landroid/net/Uri;)V
    .registers 6
    .parameter "activity"
    .parameter "uris"

    .prologue
    .line 194
    monitor-enter p0

    .line 195
    :try_start_1
    invoke-virtual {p0, p1}, Landroid/nfc/NfcActivityManager;->getActivityState(Landroid/app/Activity;)Landroid/nfc/NfcActivityManager$NfcActivityState;

    move-result-object v1

    .line 196
    .local v1, state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    iput-object p2, v1, Landroid/nfc/NfcActivityManager$NfcActivityState;->uris:[Landroid/net/Uri;

    .line 197
    iget-boolean v0, v1, Landroid/nfc/NfcActivityManager$NfcActivityState;->resumed:Z

    .line 198
    .local v0, isResumed:Z
    monitor-exit p0
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_11

    .line 199
    if-eqz v0, :cond_10

    .line 200
    const/4 v2, 0x1

    invoke-virtual {p0, v2}, Landroid/nfc/NfcActivityManager;->requestNfcServiceCallback(Z)V

    .line 202
    :cond_10
    return-void

    .line 198
    .end local v0           #isResumed:Z
    .end local v1           #state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    :catchall_11
    move-exception v2

    :try_start_12
    monitor-exit p0
    :try_end_13
    .catchall {:try_start_12 .. :try_end_13} :catchall_11

    throw v2
.end method

.method public setNdefPushContentUriCallback(Landroid/app/Activity;Landroid/nfc/NfcAdapter$CreateBeamUrisCallback;)V
    .registers 6
    .parameter "activity"
    .parameter "callback"

    .prologue
    .line 208
    monitor-enter p0

    .line 209
    :try_start_1
    invoke-virtual {p0, p1}, Landroid/nfc/NfcActivityManager;->getActivityState(Landroid/app/Activity;)Landroid/nfc/NfcActivityManager$NfcActivityState;

    move-result-object v1

    .line 210
    .local v1, state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    iput-object p2, v1, Landroid/nfc/NfcActivityManager$NfcActivityState;->uriCallback:Landroid/nfc/NfcAdapter$CreateBeamUrisCallback;

    .line 211
    iget-boolean v0, v1, Landroid/nfc/NfcActivityManager$NfcActivityState;->resumed:Z

    .line 212
    .local v0, isResumed:Z
    monitor-exit p0
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_11

    .line 213
    if-eqz v0, :cond_10

    .line 214
    const/4 v2, 0x1

    invoke-virtual {p0, v2}, Landroid/nfc/NfcActivityManager;->requestNfcServiceCallback(Z)V

    .line 216
    :cond_10
    return-void

    .line 212
    .end local v0           #isResumed:Z
    .end local v1           #state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    :catchall_11
    move-exception v2

    :try_start_12
    monitor-exit p0
    :try_end_13
    .catchall {:try_start_12 .. :try_end_13} :catchall_11

    throw v2
.end method

.method public setNdefPushMessage(Landroid/app/Activity;Landroid/nfc/NdefMessage;)V
    .registers 6
    .parameter "activity"
    .parameter "message"

    .prologue
    .line 220
    monitor-enter p0

    .line 221
    :try_start_1
    invoke-virtual {p0, p1}, Landroid/nfc/NfcActivityManager;->getActivityState(Landroid/app/Activity;)Landroid/nfc/NfcActivityManager$NfcActivityState;

    move-result-object v1

    .line 222
    .local v1, state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    iput-object p2, v1, Landroid/nfc/NfcActivityManager$NfcActivityState;->ndefMessage:Landroid/nfc/NdefMessage;

    .line 223
    iget-boolean v0, v1, Landroid/nfc/NfcActivityManager$NfcActivityState;->resumed:Z

    .line 224
    .local v0, isResumed:Z
    monitor-exit p0
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_11

    .line 225
    if-eqz v0, :cond_10

    .line 226
    const/4 v2, 0x1

    invoke-virtual {p0, v2}, Landroid/nfc/NfcActivityManager;->requestNfcServiceCallback(Z)V

    .line 228
    :cond_10
    return-void

    .line 224
    .end local v0           #isResumed:Z
    .end local v1           #state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    :catchall_11
    move-exception v2

    :try_start_12
    monitor-exit p0
    :try_end_13
    .catchall {:try_start_12 .. :try_end_13} :catchall_11

    throw v2
.end method

.method public setNdefPushMessageCallback(Landroid/app/Activity;Landroid/nfc/NfcAdapter$CreateNdefMessageCallback;)V
    .registers 6
    .parameter "activity"
    .parameter "callback"

    .prologue
    .line 233
    monitor-enter p0

    .line 234
    :try_start_1
    invoke-virtual {p0, p1}, Landroid/nfc/NfcActivityManager;->getActivityState(Landroid/app/Activity;)Landroid/nfc/NfcActivityManager$NfcActivityState;

    move-result-object v1

    .line 235
    .local v1, state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    iput-object p2, v1, Landroid/nfc/NfcActivityManager$NfcActivityState;->ndefMessageCallback:Landroid/nfc/NfcAdapter$CreateNdefMessageCallback;

    .line 236
    iget-boolean v0, v1, Landroid/nfc/NfcActivityManager$NfcActivityState;->resumed:Z

    .line 237
    .local v0, isResumed:Z
    monitor-exit p0
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_11

    .line 238
    if-eqz v0, :cond_10

    .line 239
    const/4 v2, 0x1

    invoke-virtual {p0, v2}, Landroid/nfc/NfcActivityManager;->requestNfcServiceCallback(Z)V

    .line 241
    :cond_10
    return-void

    .line 237
    .end local v0           #isResumed:Z
    .end local v1           #state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    :catchall_11
    move-exception v2

    :try_start_12
    monitor-exit p0
    :try_end_13
    .catchall {:try_start_12 .. :try_end_13} :catchall_11

    throw v2
.end method

.method public setOnNdefPushCompleteCallback(Landroid/app/Activity;Landroid/nfc/NfcAdapter$OnNdefPushCompleteCallback;)V
    .registers 6
    .parameter "activity"
    .parameter "callback"

    .prologue
    .line 246
    monitor-enter p0

    .line 247
    :try_start_1
    invoke-virtual {p0, p1}, Landroid/nfc/NfcActivityManager;->getActivityState(Landroid/app/Activity;)Landroid/nfc/NfcActivityManager$NfcActivityState;

    move-result-object v1

    .line 248
    .local v1, state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    iput-object p2, v1, Landroid/nfc/NfcActivityManager$NfcActivityState;->onNdefPushCompleteCallback:Landroid/nfc/NfcAdapter$OnNdefPushCompleteCallback;

    .line 249
    iget-boolean v0, v1, Landroid/nfc/NfcActivityManager$NfcActivityState;->resumed:Z

    .line 250
    .local v0, isResumed:Z
    monitor-exit p0
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_11

    .line 251
    if-eqz v0, :cond_10

    .line 252
    const/4 v2, 0x1

    invoke-virtual {p0, v2}, Landroid/nfc/NfcActivityManager;->requestNfcServiceCallback(Z)V

    .line 254
    :cond_10
    return-void

    .line 250
    .end local v0           #isResumed:Z
    .end local v1           #state:Landroid/nfc/NfcActivityManager$NfcActivityState;
    :catchall_11
    move-exception v2

    :try_start_12
    monitor-exit p0
    :try_end_13
    .catchall {:try_start_12 .. :try_end_13} :catchall_11

    throw v2
.end method

.method unregisterApplication(Landroid/app/Application;)V
    .registers 6
    .parameter "app"

    .prologue
    .line 94
    invoke-virtual {p0, p1}, Landroid/nfc/NfcActivityManager;->findAppState(Landroid/app/Application;)Landroid/nfc/NfcActivityManager$NfcApplicationState;

    move-result-object v0

    .line 95
    .local v0, appState:Landroid/nfc/NfcActivityManager$NfcApplicationState;
    if-nez v0, :cond_1f

    .line 96
    const-string v1, "NFC"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "app was not registered "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 100
    :goto_1e
    return-void

    .line 99
    :cond_1f
    invoke-virtual {v0}, Landroid/nfc/NfcActivityManager$NfcApplicationState;->unregister()V

    goto :goto_1e
.end method
