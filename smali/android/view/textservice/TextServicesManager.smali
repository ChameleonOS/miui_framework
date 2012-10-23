.class public final Landroid/view/textservice/TextServicesManager;
.super Ljava/lang/Object;
.source "TextServicesManager.java"


# static fields
.field private static final DBG:Z

.field private static final TAG:Ljava/lang/String;

.field private static sInstance:Landroid/view/textservice/TextServicesManager;

.field private static sService:Lcom/android/internal/textservice/ITextServicesManager;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 65
    const-class v0, Landroid/view/textservice/TextServicesManager;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Landroid/view/textservice/TextServicesManager;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .registers 3

    .prologue
    .line 71
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 72
    sget-object v1, Landroid/view/textservice/TextServicesManager;->sService:Lcom/android/internal/textservice/ITextServicesManager;

    if-nez v1, :cond_14

    .line 73
    const-string/jumbo v1, "textservices"

    invoke-static {v1}, Landroid/os/ServiceManager;->getService(Ljava/lang/String;)Landroid/os/IBinder;

    move-result-object v0

    .line 74
    .local v0, b:Landroid/os/IBinder;
    invoke-static {v0}, Lcom/android/internal/textservice/ITextServicesManager$Stub;->asInterface(Landroid/os/IBinder;)Lcom/android/internal/textservice/ITextServicesManager;

    move-result-object v1

    sput-object v1, Landroid/view/textservice/TextServicesManager;->sService:Lcom/android/internal/textservice/ITextServicesManager;

    .line 76
    .end local v0           #b:Landroid/os/IBinder;
    :cond_14
    return-void
.end method

.method public static getInstance()Landroid/view/textservice/TextServicesManager;
    .registers 2

    .prologue
    .line 83
    const-class v1, Landroid/view/textservice/TextServicesManager;

    monitor-enter v1

    .line 84
    :try_start_3
    sget-object v0, Landroid/view/textservice/TextServicesManager;->sInstance:Landroid/view/textservice/TextServicesManager;

    if-eqz v0, :cond_b

    .line 85
    sget-object v0, Landroid/view/textservice/TextServicesManager;->sInstance:Landroid/view/textservice/TextServicesManager;

    monitor-exit v1

    .line 89
    :goto_a
    return-object v0

    .line 87
    :cond_b
    new-instance v0, Landroid/view/textservice/TextServicesManager;

    invoke-direct {v0}, Landroid/view/textservice/TextServicesManager;-><init>()V

    sput-object v0, Landroid/view/textservice/TextServicesManager;->sInstance:Landroid/view/textservice/TextServicesManager;

    .line 88
    monitor-exit v1
    :try_end_13
    .catchall {:try_start_3 .. :try_end_13} :catchall_16

    .line 89
    sget-object v0, Landroid/view/textservice/TextServicesManager;->sInstance:Landroid/view/textservice/TextServicesManager;

    goto :goto_a

    .line 88
    :catchall_16
    move-exception v0

    :try_start_17
    monitor-exit v1
    :try_end_18
    .catchall {:try_start_17 .. :try_end_18} :catchall_16

    throw v0
.end method


# virtual methods
.method public getCurrentSpellChecker()Landroid/view/textservice/SpellCheckerInfo;
    .registers 5

    .prologue
    const/4 v1, 0x0

    .line 194
    :try_start_1
    sget-object v2, Landroid/view/textservice/TextServicesManager;->sService:Lcom/android/internal/textservice/ITextServicesManager;

    const/4 v3, 0x0

    invoke-interface {v2, v3}, Lcom/android/internal/textservice/ITextServicesManager;->getCurrentSpellChecker(Ljava/lang/String;)Landroid/view/textservice/SpellCheckerInfo;
    :try_end_7
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_7} :catch_9

    move-result-object v1

    .line 196
    :goto_8
    return-object v1

    .line 195
    :catch_9
    move-exception v0

    .line 196
    .local v0, e:Landroid/os/RemoteException;
    goto :goto_8
.end method

.method public getCurrentSpellCheckerSubtype(Z)Landroid/view/textservice/SpellCheckerSubtype;
    .registers 7
    .parameter "allowImplicitlySelectedSubtype"

    .prologue
    const/4 v1, 0x0

    .line 221
    :try_start_1
    sget-object v2, Landroid/view/textservice/TextServicesManager;->sService:Lcom/android/internal/textservice/ITextServicesManager;

    const/4 v3, 0x0

    invoke-interface {v2, v3, p1}, Lcom/android/internal/textservice/ITextServicesManager;->getCurrentSpellCheckerSubtype(Ljava/lang/String;Z)Landroid/view/textservice/SpellCheckerSubtype;
    :try_end_7
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_7} :catch_9

    move-result-object v1

    .line 224
    :goto_8
    return-object v1

    .line 222
    :catch_9
    move-exception v0

    .line 223
    .local v0, e:Landroid/os/RemoteException;
    sget-object v2, Landroid/view/textservice/TextServicesManager;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Error in getCurrentSpellCheckerSubtype: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_8
.end method

.method public getEnabledSpellCheckers()[Landroid/view/textservice/SpellCheckerInfo;
    .registers 6

    .prologue
    .line 177
    :try_start_0
    sget-object v2, Landroid/view/textservice/TextServicesManager;->sService:Lcom/android/internal/textservice/ITextServicesManager;

    invoke-interface {v2}, Lcom/android/internal/textservice/ITextServicesManager;->getEnabledSpellCheckers()[Landroid/view/textservice/SpellCheckerInfo;
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_7

    move-result-object v1

    .line 184
    :goto_6
    return-object v1

    .line 182
    :catch_7
    move-exception v0

    .line 183
    .local v0, e:Landroid/os/RemoteException;
    sget-object v2, Landroid/view/textservice/TextServicesManager;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Error in getEnabledSpellCheckers: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 184
    const/4 v1, 0x0

    goto :goto_6
.end method

.method public isSpellCheckerEnabled()Z
    .registers 5

    .prologue
    .line 261
    :try_start_0
    sget-object v1, Landroid/view/textservice/TextServicesManager;->sService:Lcom/android/internal/textservice/ITextServicesManager;

    invoke-interface {v1}, Lcom/android/internal/textservice/ITextServicesManager;->isSpellCheckerEnabled()Z
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_7

    move-result v1

    .line 264
    :goto_6
    return v1

    .line 262
    :catch_7
    move-exception v0

    .line 263
    .local v0, e:Landroid/os/RemoteException;
    sget-object v1, Landroid/view/textservice/TextServicesManager;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Error in isSpellCheckerEnabled:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 264
    const/4 v1, 0x0

    goto :goto_6
.end method

.method public newSpellCheckerSession(Landroid/os/Bundle;Ljava/util/Locale;Landroid/view/textservice/SpellCheckerSession$SpellCheckerSessionListener;Z)Landroid/view/textservice/SpellCheckerSession;
    .registers 22
    .parameter "bundle"
    .parameter "locale"
    .parameter "listener"
    .parameter "referToSpellCheckerLanguageSettings"

    .prologue
    .line 108
    if-nez p3, :cond_8

    .line 109
    new-instance v1, Ljava/lang/NullPointerException;

    invoke-direct {v1}, Ljava/lang/NullPointerException;-><init>()V

    throw v1

    .line 111
    :cond_8
    if-nez p4, :cond_14

    if-nez p2, :cond_14

    .line 112
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Locale should not be null if you don\'t refer settings."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 116
    :cond_14
    if-eqz p4, :cond_1e

    invoke-virtual/range {p0 .. p0}, Landroid/view/textservice/TextServicesManager;->isSpellCheckerEnabled()Z

    move-result v1

    if-nez v1, :cond_1e

    .line 117
    const/4 v12, 0x0

    .line 169
    :goto_1d
    return-object v12

    .line 122
    :cond_1e
    :try_start_1e
    sget-object v1, Landroid/view/textservice/TextServicesManager;->sService:Lcom/android/internal/textservice/ITextServicesManager;

    const/4 v2, 0x0

    invoke-interface {v1, v2}, Lcom/android/internal/textservice/ITextServicesManager;->getCurrentSpellChecker(Ljava/lang/String;)Landroid/view/textservice/SpellCheckerInfo;
    :try_end_24
    .catch Landroid/os/RemoteException; {:try_start_1e .. :try_end_24} :catch_29

    move-result-object v11

    .line 126
    .local v11, sci:Landroid/view/textservice/SpellCheckerInfo;
    if-nez v11, :cond_2c

    .line 127
    const/4 v12, 0x0

    goto :goto_1d

    .line 123
    .end local v11           #sci:Landroid/view/textservice/SpellCheckerInfo;
    :catch_29
    move-exception v7

    .line 124
    .local v7, e:Landroid/os/RemoteException;
    const/4 v12, 0x0

    goto :goto_1d

    .line 129
    .end local v7           #e:Landroid/os/RemoteException;
    .restart local v11       #sci:Landroid/view/textservice/SpellCheckerInfo;
    :cond_2c
    const/4 v14, 0x0

    .line 130
    .local v14, subtypeInUse:Landroid/view/textservice/SpellCheckerSubtype;
    if-eqz p4, :cond_66

    .line 131
    const/4 v1, 0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Landroid/view/textservice/TextServicesManager;->getCurrentSpellCheckerSubtype(Z)Landroid/view/textservice/SpellCheckerSubtype;

    move-result-object v14

    .line 132
    if-nez v14, :cond_3a

    .line 133
    const/4 v12, 0x0

    goto :goto_1d

    .line 135
    :cond_3a
    if-eqz p2, :cond_82

    .line 136
    invoke-virtual {v14}, Landroid/view/textservice/SpellCheckerSubtype;->getLocale()Ljava/lang/String;

    move-result-object v15

    .line 137
    .local v15, subtypeLocale:Ljava/lang/String;
    invoke-virtual/range {p2 .. p2}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v9

    .line 138
    .local v9, inputLocale:Ljava/lang/String;
    invoke-virtual {v15}, Ljava/lang/String;->length()I

    move-result v1

    const/4 v2, 0x2

    if-lt v1, v2, :cond_64

    invoke-virtual {v9}, Ljava/lang/String;->length()I

    move-result v1

    const/4 v2, 0x2

    if-lt v1, v2, :cond_64

    const/4 v1, 0x0

    const/4 v2, 0x2

    invoke-virtual {v15, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x2

    invoke-virtual {v9, v2, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_82

    .line 140
    :cond_64
    const/4 v12, 0x0

    goto :goto_1d

    .line 144
    .end local v9           #inputLocale:Ljava/lang/String;
    .end local v15           #subtypeLocale:Ljava/lang/String;
    :cond_66
    invoke-virtual/range {p2 .. p2}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v10

    .line 145
    .local v10, localeStr:Ljava/lang/String;
    const/4 v8, 0x0

    .local v8, i:I
    :goto_6b
    invoke-virtual {v11}, Landroid/view/textservice/SpellCheckerInfo;->getSubtypeCount()I

    move-result v1

    if-ge v8, v1, :cond_82

    .line 146
    invoke-virtual {v11, v8}, Landroid/view/textservice/SpellCheckerInfo;->getSubtypeAt(I)Landroid/view/textservice/SpellCheckerSubtype;

    move-result-object v13

    .line 147
    .local v13, subtype:Landroid/view/textservice/SpellCheckerSubtype;
    invoke-virtual {v13}, Landroid/view/textservice/SpellCheckerSubtype;->getLocale()Ljava/lang/String;

    move-result-object v16

    .line 148
    .local v16, tempSubtypeLocale:Ljava/lang/String;
    move-object/from16 v0, v16

    invoke-virtual {v0, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_86

    .line 149
    move-object v14, v13

    .line 157
    .end local v8           #i:I
    .end local v10           #localeStr:Ljava/lang/String;
    .end local v13           #subtype:Landroid/view/textservice/SpellCheckerSubtype;
    .end local v16           #tempSubtypeLocale:Ljava/lang/String;
    :cond_82
    if-nez v14, :cond_a0

    .line 158
    const/4 v12, 0x0

    goto :goto_1d

    .line 151
    .restart local v8       #i:I
    .restart local v10       #localeStr:Ljava/lang/String;
    .restart local v13       #subtype:Landroid/view/textservice/SpellCheckerSubtype;
    .restart local v16       #tempSubtypeLocale:Ljava/lang/String;
    :cond_86
    invoke-virtual {v10}, Ljava/lang/String;->length()I

    move-result v1

    const/4 v2, 0x2

    if-lt v1, v2, :cond_9d

    invoke-virtual/range {v16 .. v16}, Ljava/lang/String;->length()I

    move-result v1

    const/4 v2, 0x2

    if-lt v1, v2, :cond_9d

    move-object/from16 v0, v16

    invoke-virtual {v10, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_9d

    .line 153
    move-object v14, v13

    .line 145
    :cond_9d
    add-int/lit8 v8, v8, 0x1

    goto :goto_6b

    .line 160
    .end local v8           #i:I
    .end local v10           #localeStr:Ljava/lang/String;
    .end local v13           #subtype:Landroid/view/textservice/SpellCheckerSubtype;
    .end local v16           #tempSubtypeLocale:Ljava/lang/String;
    :cond_a0
    new-instance v12, Landroid/view/textservice/SpellCheckerSession;

    sget-object v1, Landroid/view/textservice/TextServicesManager;->sService:Lcom/android/internal/textservice/ITextServicesManager;

    move-object/from16 v0, p3

    invoke-direct {v12, v11, v1, v0, v14}, Landroid/view/textservice/SpellCheckerSession;-><init>(Landroid/view/textservice/SpellCheckerInfo;Lcom/android/internal/textservice/ITextServicesManager;Landroid/view/textservice/SpellCheckerSession$SpellCheckerSessionListener;Landroid/view/textservice/SpellCheckerSubtype;)V

    .line 163
    .local v12, session:Landroid/view/textservice/SpellCheckerSession;
    :try_start_a9
    sget-object v1, Landroid/view/textservice/TextServicesManager;->sService:Lcom/android/internal/textservice/ITextServicesManager;

    invoke-virtual {v11}, Landroid/view/textservice/SpellCheckerInfo;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v14}, Landroid/view/textservice/SpellCheckerSubtype;->getLocale()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v12}, Landroid/view/textservice/SpellCheckerSession;->getTextServicesSessionListener()Lcom/android/internal/textservice/ITextServicesSessionListener;

    move-result-object v4

    invoke-virtual {v12}, Landroid/view/textservice/SpellCheckerSession;->getSpellCheckerSessionListener()Lcom/android/internal/textservice/ISpellCheckerSessionListener;

    move-result-object v5

    move-object/from16 v6, p1

    invoke-interface/range {v1 .. v6}, Lcom/android/internal/textservice/ITextServicesManager;->getSpellCheckerService(Ljava/lang/String;Ljava/lang/String;Lcom/android/internal/textservice/ITextServicesSessionListener;Lcom/android/internal/textservice/ISpellCheckerSessionListener;Landroid/os/Bundle;)V
    :try_end_c0
    .catch Landroid/os/RemoteException; {:try_start_a9 .. :try_end_c0} :catch_c2

    goto/16 :goto_1d

    .line 166
    :catch_c2
    move-exception v7

    .line 167
    .restart local v7       #e:Landroid/os/RemoteException;
    const/4 v12, 0x0

    goto/16 :goto_1d
.end method

.method public setCurrentSpellChecker(Landroid/view/textservice/SpellCheckerInfo;)V
    .registers 6
    .parameter "sci"

    .prologue
    .line 205
    if-nez p1, :cond_24

    .line 206
    :try_start_2
    new-instance v1, Ljava/lang/NullPointerException;

    const-string v2, "SpellCheckerInfo is null."

    invoke-direct {v1, v2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v1
    :try_end_a
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_a} :catch_a

    .line 209
    :catch_a
    move-exception v0

    .line 210
    .local v0, e:Landroid/os/RemoteException;
    sget-object v1, Landroid/view/textservice/TextServicesManager;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Error in setCurrentSpellChecker: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 212
    .end local v0           #e:Landroid/os/RemoteException;
    :goto_23
    return-void

    .line 208
    :cond_24
    :try_start_24
    sget-object v1, Landroid/view/textservice/TextServicesManager;->sService:Lcom/android/internal/textservice/ITextServicesManager;

    const/4 v2, 0x0

    invoke-virtual {p1}, Landroid/view/textservice/SpellCheckerInfo;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/android/internal/textservice/ITextServicesManager;->setCurrentSpellChecker(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2e
    .catch Landroid/os/RemoteException; {:try_start_24 .. :try_end_2e} :catch_a

    goto :goto_23
.end method

.method public setSpellCheckerEnabled(Z)V
    .registers 6
    .parameter "enabled"

    .prologue
    .line 250
    :try_start_0
    sget-object v1, Landroid/view/textservice/TextServicesManager;->sService:Lcom/android/internal/textservice/ITextServicesManager;

    invoke-interface {v1, p1}, Lcom/android/internal/textservice/ITextServicesManager;->setSpellCheckerEnabled(Z)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    .line 254
    :goto_5
    return-void

    .line 251
    :catch_6
    move-exception v0

    .line 252
    .local v0, e:Landroid/os/RemoteException;
    sget-object v1, Landroid/view/textservice/TextServicesManager;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Error in setSpellCheckerEnabled:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_5
.end method

.method public setSpellCheckerSubtype(Landroid/view/textservice/SpellCheckerSubtype;)V
    .registers 7
    .parameter "subtype"

    .prologue
    .line 234
    if-nez p1, :cond_a

    .line 235
    const/4 v1, 0x0

    .line 239
    .local v1, hashCode:I
    :goto_3
    :try_start_3
    sget-object v2, Landroid/view/textservice/TextServicesManager;->sService:Lcom/android/internal/textservice/ITextServicesManager;

    const/4 v3, 0x0

    invoke-interface {v2, v3, v1}, Lcom/android/internal/textservice/ITextServicesManager;->setCurrentSpellCheckerSubtype(Ljava/lang/String;I)V

    .line 243
    .end local v1           #hashCode:I
    :goto_9
    return-void

    .line 237
    :cond_a
    invoke-virtual {p1}, Landroid/view/textservice/SpellCheckerSubtype;->hashCode()I
    :try_end_d
    .catch Landroid/os/RemoteException; {:try_start_3 .. :try_end_d} :catch_f

    move-result v1

    .restart local v1       #hashCode:I
    goto :goto_3

    .line 240
    .end local v1           #hashCode:I
    :catch_f
    move-exception v0

    .line 241
    .local v0, e:Landroid/os/RemoteException;
    sget-object v2, Landroid/view/textservice/TextServicesManager;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Error in setSpellCheckerSubtype:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_9
.end method
