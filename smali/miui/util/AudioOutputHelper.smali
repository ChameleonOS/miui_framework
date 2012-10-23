.class public Lmiui/util/AudioOutputHelper;
.super Ljava/lang/Object;
.source "AudioOutputHelper.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmiui/util/AudioOutputHelper$DUMP_TAG;,
        Lmiui/util/AudioOutputHelper$AudioOutputClient;
    }
.end annotation


# static fields
.field private static final DEFAULT_TEMP_FILE:Ljava/lang/String; = "audio_flinger_%d_%d_%d.dump"

.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 30
    const-class v0, Lmiui/util/AudioOutputHelper;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lmiui/util/AudioOutputHelper;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 29
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 54
    return-void
.end method

.method private static collectSessions(Ljava/io/BufferedReader;Ljava/util/Map;)Ljava/lang/String;
    .registers 8
    .parameter "reader"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/BufferedReader;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/NumberFormatException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 90
    .local p1, sessions:Ljava/util/Map;,"Ljava/util/Map<Ljava/lang/Integer;Ljava/lang/Integer;>;"
    const/4 v0, 0x0

    .line 91
    .local v0, content:Ljava/lang/String;
    :goto_1
    invoke-virtual {p0}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_13

    .line 92
    sget-object v4, Lmiui/util/AudioOutputHelper$DUMP_TAG;->SESSIONS_CONTENT_FINDER:Ljava/util/regex/Pattern;

    invoke-virtual {v4, v0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v1

    .line 93
    .local v1, matcher:Ljava/util/regex/Matcher;
    invoke-virtual {v1}, Ljava/util/regex/Matcher;->find()Z

    move-result v4

    if-nez v4, :cond_14

    .line 102
    .end local v1           #matcher:Ljava/util/regex/Matcher;
    :cond_13
    return-object v0

    .line 97
    .restart local v1       #matcher:Ljava/util/regex/Matcher;
    :cond_14
    const/4 v4, 0x1

    invoke-virtual {v1, v4}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v3

    .line 98
    .local v3, sessionId:I
    const/4 v4, 0x2

    invoke-virtual {v1, v4}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v2

    .line 99
    .local v2, pid:I
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {p1, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1
.end method

.method private static collectTracks(Ljava/io/BufferedReader;Ljava/util/List;Ljava/util/Map;Z)Ljava/lang/String;
    .registers 14
    .parameter "reader"
    .parameter
    .parameter
    .parameter "active"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/BufferedReader;",
            "Ljava/util/List",
            "<",
            "Lmiui/util/AudioOutputHelper$AudioOutputClient;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ">;Z)",
            "Ljava/lang/String;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/NumberFormatException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 108
    .local p1, clients:Ljava/util/List;,"Ljava/util/List<Lmiui/util/AudioOutputHelper$AudioOutputClient;>;"
    .local p2, sessions:Ljava/util/Map;,"Ljava/util/Map<Ljava/lang/Integer;Ljava/lang/Integer;>;"
    const/4 v1, 0x0

    .line 109
    .local v1, content:Ljava/lang/String;
    :cond_1
    :goto_1
    invoke-virtual {p0}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_13

    .line 110
    sget-object v9, Lmiui/util/AudioOutputHelper$DUMP_TAG;->TRACK_CONTENT_FINDER:Ljava/util/regex/Pattern;

    invoke-virtual {v9, v1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v4

    .line 111
    .local v4, matcher:Ljava/util/regex/Matcher;
    invoke-virtual {v4}, Ljava/util/regex/Matcher;->find()Z

    move-result v9

    if-nez v9, :cond_14

    .line 138
    .end local v4           #matcher:Ljava/util/regex/Matcher;
    :cond_13
    return-object v1

    .line 115
    .restart local v4       #matcher:Ljava/util/regex/Matcher;
    :cond_14
    const/4 v9, 0x3

    invoke-virtual {v4, v9}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Integer;->intValue()I

    move-result v7

    .line 116
    .local v7, sessionId:I
    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-interface {p2, v9}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Integer;

    .line 117
    .local v6, proc:Ljava/lang/Integer;
    if-eqz v6, :cond_1

    .line 118
    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I

    move-result v5

    .line 119
    .local v5, pid:I
    const/4 v9, 0x2

    invoke-virtual {v4, v9}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Integer;->intValue()I

    move-result v8

    .line 120
    .local v8, streamType:I
    const/4 v2, 0x0

    .line 123
    .local v2, found:Z
    if-eqz p3, :cond_59

    .line 124
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, i$:Ljava/util/Iterator;
    :cond_45
    :goto_45
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_59

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lmiui/util/AudioOutputHelper$AudioOutputClient;

    .line 125
    .local v0, c:Lmiui/util/AudioOutputHelper$AudioOutputClient;
    iget v9, v0, Lmiui/util/AudioOutputHelper$AudioOutputClient;->mSessionId:I

    if-ne v9, v7, :cond_45

    .line 126
    iput-boolean p3, v0, Lmiui/util/AudioOutputHelper$AudioOutputClient;->mActive:Z

    .line 127
    const/4 v2, 0x1

    goto :goto_45

    .line 132
    .end local v0           #c:Lmiui/util/AudioOutputHelper$AudioOutputClient;
    .end local v3           #i$:Ljava/util/Iterator;
    :cond_59
    if-nez v2, :cond_1

    .line 133
    new-instance v9, Lmiui/util/AudioOutputHelper$AudioOutputClient;

    invoke-direct {v9, v7, v5, v8, p3}, Lmiui/util/AudioOutputHelper$AudioOutputClient;-><init>(IIIZ)V

    invoke-interface {p1, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1
.end method

.method public static getActiveClientNameList(Ljava/util/List;Landroid/content/Context;Z)Ljava/util/List;
    .registers 12
    .parameter
    .parameter "context"
    .parameter "addMainProc"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Landroid/app/ActivityManager$RunningAppProcessInfo;",
            ">;",
            "Landroid/content/Context;",
            "Z)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .local p0, procs:Ljava/util/List;,"Ljava/util/List<Landroid/app/ActivityManager$RunningAppProcessInfo;>;"
    const/4 v5, 0x0

    .line 276
    if-nez p0, :cond_4

    .line 304
    :cond_3
    :goto_3
    return-object v5

    .line 280
    :cond_4
    invoke-static {p1}, Lmiui/util/AudioOutputHelper;->parseAudioFlingerDump(Landroid/content/Context;)Ljava/util/List;

    move-result-object v1

    .line 281
    .local v1, clients:Ljava/util/List;,"Ljava/util/List<Lmiui/util/AudioOutputHelper$AudioOutputClient;>;"
    if-eqz v1, :cond_3

    .line 285
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 286
    .local v5, names:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_13
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_3f

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lmiui/util/AudioOutputHelper$AudioOutputClient;

    .line 287
    .local v0, c:Lmiui/util/AudioOutputHelper$AudioOutputClient;
    iget-boolean v8, v0, Lmiui/util/AudioOutputHelper$AudioOutputClient;->mActive:Z

    if-eqz v8, :cond_13

    .line 288
    iget v6, v0, Lmiui/util/AudioOutputHelper$AudioOutputClient;->mProcessId:I

    .line 289
    .local v6, pid:I
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, i$:Ljava/util/Iterator;
    :cond_29
    :goto_29
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_13

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/app/ActivityManager$RunningAppProcessInfo;

    .line 290
    .local v7, proc:Landroid/app/ActivityManager$RunningAppProcessInfo;
    iget v8, v7, Landroid/app/ActivityManager$RunningAppProcessInfo;->pid:I

    if-ne v8, v6, :cond_29

    .line 291
    iget-object v8, v7, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    invoke-virtual {v5, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_29

    .line 297
    .end local v0           #c:Lmiui/util/AudioOutputHelper$AudioOutputClient;
    .end local v3           #i$:Ljava/util/Iterator;
    .end local v6           #pid:I
    .end local v7           #proc:Landroid/app/ActivityManager$RunningAppProcessInfo;
    :cond_3f
    if-eqz p2, :cond_3

    .line 300
    invoke-static {v5}, Lmiui/util/AudioOutputHelper;->getMainProcessNames(Ljava/util/List;)Ljava/util/List;

    move-result-object v4

    .line 301
    .local v4, mainProc:Ljava/util/List;,"Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    goto :goto_3
.end method

.method public static getActiveReceiverNameList(Landroid/content/Context;)Ljava/util/List;
    .registers 14
    .parameter "context"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v8, 0x0

    .line 314
    :try_start_1
    new-instance v3, Landroid/content/Intent;

    const-string v9, "android.intent.action.MEDIA_BUTTON"

    invoke-direct {v3, v9}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 315
    .local v3, intent:Landroid/content/Intent;
    invoke-static {}, Landroid/app/AppGlobals;->getPackageManager()Landroid/content/pm/IPackageManager;

    move-result-object v9

    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    invoke-interface {v9, v3, v10, v11, v12}, Landroid/content/pm/IPackageManager;->queryIntentReceivers(Landroid/content/Intent;Ljava/lang/String;II)Ljava/util/List;

    move-result-object v6

    .line 317
    .local v6, receivers:Ljava/util/List;,"Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    if-eqz v6, :cond_1b

    invoke-interface {v6}, Ljava/util/List;->isEmpty()Z

    move-result v9

    if-eqz v9, :cond_1d

    :cond_1b
    move-object v7, v8

    .line 342
    .end local v3           #intent:Landroid/content/Intent;
    .end local v6           #receivers:Ljava/util/List;,"Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    :cond_1c
    :goto_1c
    return-object v7

    .line 321
    .restart local v3       #intent:Landroid/content/Intent;
    .restart local v6       #receivers:Ljava/util/List;,"Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    :cond_1d
    invoke-static {}, Landroid/app/ActivityManagerNative;->getDefault()Landroid/app/IActivityManager;

    move-result-object v9

    invoke-interface {v9}, Landroid/app/IActivityManager;->getRunningAppProcesses()Ljava/util/List;

    move-result-object v9

    const/4 v10, 0x1

    invoke-static {v9, p0, v10}, Lmiui/util/AudioOutputHelper;->getActiveClientNameList(Ljava/util/List;Landroid/content/Context;Z)Ljava/util/List;

    move-result-object v5

    .line 323
    .local v5, processes:Ljava/util/List;,"Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v5, :cond_32

    invoke-interface {v5}, Ljava/util/List;->isEmpty()Z

    move-result v9

    if-eqz v9, :cond_34

    :cond_32
    move-object v7, v8

    .line 324
    goto :goto_1c

    .line 327
    :cond_34
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 328
    .local v7, result:Ljava/util/List;,"Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_3d
    :goto_3d
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_1c

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 329
    .local v4, p:Ljava/lang/String;
    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, i$:Ljava/util/Iterator;
    :cond_4d
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_3d

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/content/pm/ResolveInfo;

    .line 330
    .local v2, info:Landroid/content/pm/ResolveInfo;
    iget-object v9, v2, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    if-eqz v9, :cond_4d

    iget-object v9, v2, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v9, v9, Landroid/content/pm/ComponentInfo;->processName:Ljava/lang/String;

    invoke-virtual {v4, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_4d

    .line 332
    invoke-interface {v7, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_6a
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_6a} :catch_6b

    goto :goto_3d

    .line 339
    .end local v1           #i$:Ljava/util/Iterator;
    .end local v2           #info:Landroid/content/pm/ResolveInfo;
    .end local v3           #intent:Landroid/content/Intent;
    .end local v4           #p:Ljava/lang/String;
    .end local v5           #processes:Ljava/util/List;,"Ljava/util/List<Ljava/lang/String;>;"
    .end local v6           #receivers:Ljava/util/List;,"Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    .end local v7           #result:Ljava/util/List;,"Ljava/util/List<Ljava/lang/String;>;"
    :catch_6b
    move-exception v9

    move-object v7, v8

    .line 342
    goto :goto_1c
.end method

.method private static getMainProcessNames(Ljava/util/List;)Ljava/util/List;
    .registers 6
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 356
    .local p0, names:Ljava/util/List;,"Ljava/util/List<Ljava/lang/String;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 357
    .local v2, mainProcs:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, i$:Ljava/util/Iterator;
    :cond_9
    :goto_9
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_26

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 358
    .local v3, name:Ljava/lang/String;
    const-string v4, ":"

    invoke-virtual {v3, v4}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    .line 359
    .local v0, colonIndex:I
    if-lez v0, :cond_9

    .line 360
    const/4 v4, 0x0

    invoke-virtual {v3, v4, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_9

    .line 364
    .end local v0           #colonIndex:I
    .end local v3           #name:Ljava/lang/String;
    :cond_26
    return-object v2
.end method

.method public static hasActiveReceivers(Landroid/content/Context;)Z
    .registers 3
    .parameter "context"

    .prologue
    .line 351
    invoke-static {p0}, Lmiui/util/AudioOutputHelper;->getActiveReceiverNameList(Landroid/content/Context;)Ljava/util/List;

    move-result-object v0

    .line 352
    .local v0, processes:Ljava/util/List;,"Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v0, :cond_e

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_e

    const/4 v1, 0x1

    :goto_d
    return v1

    :cond_e
    const/4 v1, 0x0

    goto :goto_d
.end method

.method public static parseAudioFlingerDump(Landroid/content/Context;)Ljava/util/List;
    .registers 16
    .parameter "context"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            ")",
            "Ljava/util/List",
            "<",
            "Lmiui/util/AudioOutputHelper$AudioOutputClient;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v14, 0x3

    const/4 v13, 0x2

    const/4 v12, 0x1

    const/4 v11, 0x0

    .line 148
    const/4 v0, 0x0

    .line 150
    .local v0, dir:Ljava/io/File;
    :try_start_5
    invoke-virtual {p0}, Landroid/content/Context;->getFilesDir()Ljava/io/File;
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_8} :catch_72

    move-result-object v0

    .line 154
    :goto_9
    if-nez v0, :cond_12

    .line 155
    new-instance v0, Ljava/io/File;

    .end local v0           #dir:Ljava/io/File;
    const-string v8, "/cache"

    invoke-direct {v0, v8}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 158
    .restart local v0       #dir:Ljava/io/File;
    :cond_12
    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v4

    .line 159
    .local v4, pid:I
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Thread;->getId()J

    move-result-wide v6

    .line 160
    .local v6, tid:J
    const/4 v2, 0x0

    .line 161
    .local v2, i:I
    new-instance v1, Ljava/io/File;

    const-string v8, "audio_flinger_%d_%d_%d.dump"

    new-array v9, v14, [Ljava/lang/Object;

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v9, v11

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    aput-object v10, v9, v12

    add-int/lit8 v3, v2, 0x1

    .end local v2           #i:I
    .local v3, i:I
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v9, v13

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-direct {v1, v0, v8}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .local v1, dumpFile:Ljava/io/File;
    move v2, v3

    .line 162
    .end local v3           #i:I
    .restart local v2       #i:I
    :goto_41
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v8

    if-eqz v8, :cond_6a

    .line 163
    new-instance v1, Ljava/io/File;

    .end local v1           #dumpFile:Ljava/io/File;
    const-string v8, "audio_flinger_%d_%d_%d.dump"

    new-array v9, v14, [Ljava/lang/Object;

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v9, v11

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    aput-object v10, v9, v12

    add-int/lit8 v3, v2, 0x1

    .end local v2           #i:I
    .restart local v3       #i:I
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v9, v13

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-direct {v1, v0, v8}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .restart local v1       #dumpFile:Ljava/io/File;
    move v2, v3

    .end local v3           #i:I
    .restart local v2       #i:I
    goto :goto_41

    .line 166
    :cond_6a
    invoke-static {v1}, Lmiui/util/AudioOutputHelper;->parseAudioFlingerDumpInternal(Ljava/io/File;)Ljava/util/List;

    move-result-object v5

    .line 167
    .local v5, result:Ljava/util/List;,"Ljava/util/List<Lmiui/util/AudioOutputHelper$AudioOutputClient;>;"
    invoke-virtual {v1}, Ljava/io/File;->delete()Z

    .line 169
    return-object v5

    .line 151
    .end local v1           #dumpFile:Ljava/io/File;
    .end local v2           #i:I
    .end local v4           #pid:I
    .end local v5           #result:Ljava/util/List;,"Ljava/util/List<Lmiui/util/AudioOutputHelper$AudioOutputClient;>;"
    .end local v6           #tid:J
    :catch_72
    move-exception v8

    goto :goto_9
.end method

.method private static parseAudioFlingerDumpInternal(Ljava/io/File;)Ljava/util/List;
    .registers 19
    .parameter "tempFile"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/File;",
            ")",
            "Ljava/util/List",
            "<",
            "Lmiui/util/AudioOutputHelper$AudioOutputClient;",
            ">;"
        }
    .end annotation

    .prologue
    .line 173
    const/4 v7, 0x0

    .line 175
    .local v7, os:Ljava/io/FileOutputStream;
    :try_start_1
    new-instance v8, Ljava/io/FileOutputStream;

    move-object/from16 v0, p0

    invoke-direct {v8, v0}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    :try_end_8
    .catchall {:try_start_1 .. :try_end_8} :catchall_5d
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_8} :catch_2b
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_8} :catch_3d
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_8} :catch_4d

    .line 176
    .end local v7           #os:Ljava/io/FileOutputStream;
    .local v8, os:Ljava/io/FileOutputStream;
    :try_start_8
    const-string/jumbo v15, "media.audio_flinger"

    invoke-static {v15}, Landroid/os/ServiceManager;->getService(Ljava/lang/String;)Landroid/os/IBinder;

    move-result-object v15

    invoke-virtual {v8}, Ljava/io/FileOutputStream;->getFD()Ljava/io/FileDescriptor;

    move-result-object v16

    const/16 v17, 0x0

    invoke-interface/range {v15 .. v17}, Landroid/os/IBinder;->dump(Ljava/io/FileDescriptor;[Ljava/lang/String;)V
    :try_end_18
    .catchall {:try_start_8 .. :try_end_18} :catchall_107
    .catch Ljava/io/FileNotFoundException; {:try_start_8 .. :try_end_18} :catch_113
    .catch Landroid/os/RemoteException; {:try_start_8 .. :try_end_18} :catch_10f
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_18} :catch_10b

    .line 184
    if-eqz v8, :cond_1d

    .line 186
    :try_start_1a
    invoke-virtual {v8}, Ljava/io/FileOutputStream;->close()V
    :try_end_1d
    .catch Ljava/io/IOException; {:try_start_1a .. :try_end_1d} :catch_101

    :cond_1d
    :goto_1d
    move-object v7, v8

    .line 192
    .end local v8           #os:Ljava/io/FileOutputStream;
    .restart local v7       #os:Ljava/io/FileOutputStream;
    :cond_1e
    :goto_1e
    const/4 v5, 0x0

    .line 194
    .local v5, in:Ljava/io/InputStream;
    :try_start_1f
    new-instance v6, Ljava/io/FileInputStream;

    move-object/from16 v0, p0

    invoke-direct {v6, v0}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    :try_end_26
    .catch Ljava/io/FileNotFoundException; {:try_start_1f .. :try_end_26} :catch_104

    .end local v5           #in:Ljava/io/InputStream;
    .local v6, in:Ljava/io/InputStream;
    move-object v5, v6

    .line 198
    .end local v6           #in:Ljava/io/InputStream;
    .restart local v5       #in:Ljava/io/InputStream;
    :goto_27
    if-nez v5, :cond_64

    .line 199
    const/4 v2, 0x0

    .line 266
    :goto_2a
    return-object v2

    .line 177
    .end local v5           #in:Ljava/io/InputStream;
    :catch_2b
    move-exception v4

    .line 178
    .local v4, e:Ljava/io/FileNotFoundException;
    :goto_2c
    :try_start_2c
    sget-object v15, Lmiui/util/AudioOutputHelper;->TAG:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/io/FileNotFoundException;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-static/range {v15 .. v16}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_35
    .catchall {:try_start_2c .. :try_end_35} :catchall_5d

    .line 184
    if-eqz v7, :cond_1e

    .line 186
    :try_start_37
    invoke-virtual {v7}, Ljava/io/FileOutputStream;->close()V
    :try_end_3a
    .catch Ljava/io/IOException; {:try_start_37 .. :try_end_3a} :catch_3b

    goto :goto_1e

    .line 187
    .end local v4           #e:Ljava/io/FileNotFoundException;
    :catch_3b
    move-exception v15

    goto :goto_1e

    .line 179
    :catch_3d
    move-exception v4

    .line 180
    .local v4, e:Landroid/os/RemoteException;
    :goto_3e
    :try_start_3e
    sget-object v15, Lmiui/util/AudioOutputHelper;->TAG:Ljava/lang/String;

    invoke-virtual {v4}, Landroid/os/RemoteException;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-static/range {v15 .. v16}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_47
    .catchall {:try_start_3e .. :try_end_47} :catchall_5d

    .line 184
    if-eqz v7, :cond_1e

    .line 186
    :try_start_49
    invoke-virtual {v7}, Ljava/io/FileOutputStream;->close()V
    :try_end_4c
    .catch Ljava/io/IOException; {:try_start_49 .. :try_end_4c} :catch_3b

    goto :goto_1e

    .line 181
    .end local v4           #e:Landroid/os/RemoteException;
    :catch_4d
    move-exception v4

    .line 182
    .local v4, e:Ljava/io/IOException;
    :goto_4e
    :try_start_4e
    sget-object v15, Lmiui/util/AudioOutputHelper;->TAG:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-static/range {v15 .. v16}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_57
    .catchall {:try_start_4e .. :try_end_57} :catchall_5d

    .line 184
    if-eqz v7, :cond_1e

    .line 186
    :try_start_59
    invoke-virtual {v7}, Ljava/io/FileOutputStream;->close()V
    :try_end_5c
    .catch Ljava/io/IOException; {:try_start_59 .. :try_end_5c} :catch_3b

    goto :goto_1e

    .line 184
    .end local v4           #e:Ljava/io/IOException;
    :catchall_5d
    move-exception v15

    :goto_5e
    if-eqz v7, :cond_63

    .line 186
    :try_start_60
    invoke-virtual {v7}, Ljava/io/FileOutputStream;->close()V
    :try_end_63
    .catch Ljava/io/IOException; {:try_start_60 .. :try_end_63} :catch_fa

    .line 184
    :cond_63
    :goto_63
    throw v15

    .line 203
    .restart local v5       #in:Ljava/io/InputStream;
    :cond_64
    :try_start_64
    new-instance v9, Ljava/io/BufferedReader;

    new-instance v15, Ljava/io/InputStreamReader;

    invoke-direct {v15, v5}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v9, v15}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 204
    .local v9, reader:Ljava/io/BufferedReader;
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 205
    .local v2, clients:Ljava/util/List;,"Ljava/util/List<Lmiui/util/AudioOutputHelper$AudioOutputClient;>;"
    const/4 v10, 0x0

    .line 206
    .local v10, sessions:Ljava/util/Map;,"Ljava/util/Map<Ljava/lang/Integer;Ljava/lang/Integer;>;"
    const/4 v12, 0x0

    .line 208
    .local v12, standby:Z
    const/4 v3, 0x0

    .line 209
    .local v3, content:Ljava/lang/String;
    const/4 v11, 0x0

    .line 211
    .local v11, skipped:Ljava/lang/String;
    :cond_77
    :goto_77
    if-eqz v11, :cond_93

    .line 212
    move-object v3, v11

    .line 213
    const/4 v11, 0x0

    .line 221
    :cond_7b
    sget-object v15, Lmiui/util/AudioOutputHelper$DUMP_TAG;->SESSIONS_HEAD_FINDER:Ljava/util/regex/Pattern;

    invoke-virtual {v15, v3}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v15

    invoke-virtual {v15}, Ljava/util/regex/Matcher;->matches()Z

    move-result v15

    if-eqz v15, :cond_9f

    .line 222
    if-nez v10, :cond_8e

    .line 223
    new-instance v10, Ljava/util/HashMap;

    .end local v10           #sessions:Ljava/util/Map;,"Ljava/util/Map<Ljava/lang/Integer;Ljava/lang/Integer;>;"
    invoke-direct {v10}, Ljava/util/HashMap;-><init>()V

    .line 225
    .restart local v10       #sessions:Ljava/util/Map;,"Ljava/util/Map<Ljava/lang/Integer;Ljava/lang/Integer;>;"
    :cond_8e
    invoke-static {v9, v10}, Lmiui/util/AudioOutputHelper;->collectSessions(Ljava/io/BufferedReader;Ljava/util/Map;)Ljava/lang/String;

    move-result-object v11

    .line 226
    goto :goto_77

    .line 215
    :cond_93
    invoke-virtual {v9}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;
    :try_end_96
    .catchall {:try_start_64 .. :try_end_96} :catchall_f5
    .catch Ljava/lang/Exception; {:try_start_64 .. :try_end_96} :catch_e5

    move-result-object v3

    .line 216
    if-nez v3, :cond_7b

    .line 261
    :try_start_99
    invoke-virtual {v5}, Ljava/io/FileInputStream;->close()V
    :try_end_9c
    .catch Ljava/io/IOException; {:try_start_99 .. :try_end_9c} :catch_9d

    goto :goto_2a

    .line 262
    :catch_9d
    move-exception v15

    goto :goto_2a

    .line 229
    :cond_9f
    :try_start_9f
    sget-object v15, Lmiui/util/AudioOutputHelper$DUMP_TAG;->STANDBY_FINDER:Ljava/util/regex/Pattern;

    invoke-virtual {v15, v3}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v13

    .line 230
    .local v13, standbyMatcher:Ljava/util/regex/Matcher;
    invoke-virtual {v13}, Ljava/util/regex/Matcher;->find()Z

    move-result v15

    if-eqz v15, :cond_b9

    .line 231
    const/4 v15, 0x1

    invoke-virtual {v13, v15}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v15

    invoke-static {v15}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v12

    .line 232
    goto :goto_77

    .line 235
    :cond_b9
    if-nez v12, :cond_77

    .line 236
    sget-object v15, Lmiui/util/AudioOutputHelper$DUMP_TAG;->TRACKS_FINDER:Ljava/util/regex/Pattern;

    invoke-virtual {v15, v3}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v14

    .line 237
    .local v14, trackMatcher:Ljava/util/regex/Matcher;
    invoke-virtual {v14}, Ljava/util/regex/Matcher;->find()Z

    move-result v15

    if-eqz v15, :cond_d0

    .line 239
    invoke-virtual {v9}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    .line 241
    const/4 v15, 0x0

    invoke-static {v9, v2, v10, v15}, Lmiui/util/AudioOutputHelper;->collectTracks(Ljava/io/BufferedReader;Ljava/util/List;Ljava/util/Map;Z)Ljava/lang/String;

    move-result-object v11

    .line 242
    goto :goto_77

    .line 245
    :cond_d0
    sget-object v15, Lmiui/util/AudioOutputHelper$DUMP_TAG;->ACTIVE_TRACKS_FINDER:Ljava/util/regex/Pattern;

    invoke-virtual {v15, v3}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v1

    .line 246
    .local v1, activeTrackMatcher:Ljava/util/regex/Matcher;
    invoke-virtual {v1}, Ljava/util/regex/Matcher;->find()Z

    move-result v15

    if-eqz v15, :cond_77

    .line 248
    invoke-virtual {v9}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    .line 250
    const/4 v15, 0x1

    invoke-static {v9, v2, v10, v15}, Lmiui/util/AudioOutputHelper;->collectTracks(Ljava/io/BufferedReader;Ljava/util/List;Ljava/util/Map;Z)Ljava/lang/String;
    :try_end_e3
    .catchall {:try_start_9f .. :try_end_e3} :catchall_f5
    .catch Ljava/lang/Exception; {:try_start_9f .. :try_end_e3} :catch_e5

    move-result-object v11

    .line 251
    goto :goto_77

    .line 257
    .end local v1           #activeTrackMatcher:Ljava/util/regex/Matcher;
    .end local v2           #clients:Ljava/util/List;,"Ljava/util/List<Lmiui/util/AudioOutputHelper$AudioOutputClient;>;"
    .end local v3           #content:Ljava/lang/String;
    .end local v9           #reader:Ljava/io/BufferedReader;
    .end local v10           #sessions:Ljava/util/Map;,"Ljava/util/Map<Ljava/lang/Integer;Ljava/lang/Integer;>;"
    .end local v11           #skipped:Ljava/lang/String;
    .end local v12           #standby:Z
    .end local v13           #standbyMatcher:Ljava/util/regex/Matcher;
    .end local v14           #trackMatcher:Ljava/util/regex/Matcher;
    :catch_e5
    move-exception v4

    .line 258
    .local v4, e:Ljava/lang/Exception;
    :try_start_e6
    sget-object v15, Lmiui/util/AudioOutputHelper;->TAG:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-static/range {v15 .. v16}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_ef
    .catchall {:try_start_e6 .. :try_end_ef} :catchall_f5

    .line 261
    :try_start_ef
    invoke-virtual {v5}, Ljava/io/FileInputStream;->close()V
    :try_end_f2
    .catch Ljava/io/IOException; {:try_start_ef .. :try_end_f2} :catch_ff

    .line 266
    :goto_f2
    const/4 v2, 0x0

    goto/16 :goto_2a

    .line 260
    .end local v4           #e:Ljava/lang/Exception;
    :catchall_f5
    move-exception v15

    .line 261
    :try_start_f6
    invoke-virtual {v5}, Ljava/io/FileInputStream;->close()V
    :try_end_f9
    .catch Ljava/io/IOException; {:try_start_f6 .. :try_end_f9} :catch_fd

    .line 260
    :goto_f9
    throw v15

    .line 187
    .end local v5           #in:Ljava/io/InputStream;
    :catch_fa
    move-exception v16

    goto/16 :goto_63

    .line 262
    .restart local v5       #in:Ljava/io/InputStream;
    :catch_fd
    move-exception v16

    goto :goto_f9

    .restart local v4       #e:Ljava/lang/Exception;
    :catch_ff
    move-exception v15

    goto :goto_f2

    .line 187
    .end local v4           #e:Ljava/lang/Exception;
    .end local v5           #in:Ljava/io/InputStream;
    .end local v7           #os:Ljava/io/FileOutputStream;
    .restart local v8       #os:Ljava/io/FileOutputStream;
    :catch_101
    move-exception v15

    goto/16 :goto_1d

    .line 195
    .end local v8           #os:Ljava/io/FileOutputStream;
    .restart local v5       #in:Ljava/io/InputStream;
    .restart local v7       #os:Ljava/io/FileOutputStream;
    :catch_104
    move-exception v15

    goto/16 :goto_27

    .line 184
    .end local v5           #in:Ljava/io/InputStream;
    .end local v7           #os:Ljava/io/FileOutputStream;
    .restart local v8       #os:Ljava/io/FileOutputStream;
    :catchall_107
    move-exception v15

    move-object v7, v8

    .end local v8           #os:Ljava/io/FileOutputStream;
    .restart local v7       #os:Ljava/io/FileOutputStream;
    goto/16 :goto_5e

    .line 181
    .end local v7           #os:Ljava/io/FileOutputStream;
    .restart local v8       #os:Ljava/io/FileOutputStream;
    :catch_10b
    move-exception v4

    move-object v7, v8

    .end local v8           #os:Ljava/io/FileOutputStream;
    .restart local v7       #os:Ljava/io/FileOutputStream;
    goto/16 :goto_4e

    .line 179
    .end local v7           #os:Ljava/io/FileOutputStream;
    .restart local v8       #os:Ljava/io/FileOutputStream;
    :catch_10f
    move-exception v4

    move-object v7, v8

    .end local v8           #os:Ljava/io/FileOutputStream;
    .restart local v7       #os:Ljava/io/FileOutputStream;
    goto/16 :goto_3e

    .line 177
    .end local v7           #os:Ljava/io/FileOutputStream;
    .restart local v8       #os:Ljava/io/FileOutputStream;
    :catch_113
    move-exception v4

    move-object v7, v8

    .end local v8           #os:Ljava/io/FileOutputStream;
    .restart local v7       #os:Ljava/io/FileOutputStream;
    goto/16 :goto_2c
.end method
