.class public Landroid/app/UiModeManager;
.super Ljava/lang/Object;
.source "UiModeManager.java"


# static fields
.field public static ACTION_ENTER_CAR_MODE:Ljava/lang/String; = null

.field public static ACTION_ENTER_DESK_MODE:Ljava/lang/String; = null

.field public static ACTION_EXIT_CAR_MODE:Ljava/lang/String; = null

.field public static ACTION_EXIT_DESK_MODE:Ljava/lang/String; = null

.field public static final DISABLE_CAR_MODE_GO_HOME:I = 0x1

.field public static final ENABLE_CAR_MODE_GO_CAR_HOME:I = 0x1

.field public static final MODE_NIGHT_AUTO:I = 0x0

.field public static final MODE_NIGHT_NO:I = 0x1

.field public static final MODE_NIGHT_YES:I = 0x2

.field private static final TAG:Ljava/lang/String; = "UiModeManager"


# instance fields
.field private mService:Landroid/app/IUiModeManager;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 66
    const-string v0, "android.app.action.ENTER_CAR_MODE"

    sput-object v0, Landroid/app/UiModeManager;->ACTION_ENTER_CAR_MODE:Ljava/lang/String;

    .line 73
    const-string v0, "android.app.action.EXIT_CAR_MODE"

    sput-object v0, Landroid/app/UiModeManager;->ACTION_EXIT_CAR_MODE:Ljava/lang/String;

    .line 87
    const-string v0, "android.app.action.ENTER_DESK_MODE"

    sput-object v0, Landroid/app/UiModeManager;->ACTION_ENTER_DESK_MODE:Ljava/lang/String;

    .line 94
    const-string v0, "android.app.action.EXIT_DESK_MODE"

    sput-object v0, Landroid/app/UiModeManager;->ACTION_EXIT_DESK_MODE:Ljava/lang/String;

    return-void
.end method

.method constructor <init>()V
    .registers 2

    .prologue
    .line 113
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 114
    const-string/jumbo v0, "uimode"

    invoke-static {v0}, Landroid/os/ServiceManager;->getService(Ljava/lang/String;)Landroid/os/IBinder;

    move-result-object v0

    invoke-static {v0}, Landroid/app/IUiModeManager$Stub;->asInterface(Landroid/os/IBinder;)Landroid/app/IUiModeManager;

    move-result-object v0

    iput-object v0, p0, Landroid/app/UiModeManager;->mService:Landroid/app/IUiModeManager;

    .line 116
    return-void
.end method


# virtual methods
.method public disableCarMode(I)V
    .registers 5
    .parameter "flags"

    .prologue
    .line 157
    iget-object v1, p0, Landroid/app/UiModeManager;->mService:Landroid/app/IUiModeManager;

    if-eqz v1, :cond_9

    .line 159
    :try_start_4
    iget-object v1, p0, Landroid/app/UiModeManager;->mService:Landroid/app/IUiModeManager;

    invoke-interface {v1, p1}, Landroid/app/IUiModeManager;->disableCarMode(I)V
    :try_end_9
    .catch Landroid/os/RemoteException; {:try_start_4 .. :try_end_9} :catch_a

    .line 164
    :cond_9
    :goto_9
    return-void

    .line 160
    :catch_a
    move-exception v0

    .line 161
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "UiModeManager"

    const-string v2, "disableCarMode: RemoteException"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_9
.end method

.method public enableCarMode(I)V
    .registers 5
    .parameter "flags"

    .prologue
    .line 134
    iget-object v1, p0, Landroid/app/UiModeManager;->mService:Landroid/app/IUiModeManager;

    if-eqz v1, :cond_9

    .line 136
    :try_start_4
    iget-object v1, p0, Landroid/app/UiModeManager;->mService:Landroid/app/IUiModeManager;

    invoke-interface {v1, p1}, Landroid/app/IUiModeManager;->enableCarMode(I)V
    :try_end_9
    .catch Landroid/os/RemoteException; {:try_start_4 .. :try_end_9} :catch_a

    .line 141
    :cond_9
    :goto_9
    return-void

    .line 137
    :catch_a
    move-exception v0

    .line 138
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "UiModeManager"

    const-string v2, "disableCarMode: RemoteException"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_9
.end method

.method public getCurrentModeType()I
    .registers 4

    .prologue
    .line 174
    iget-object v1, p0, Landroid/app/UiModeManager;->mService:Landroid/app/IUiModeManager;

    if-eqz v1, :cond_13

    .line 176
    :try_start_4
    iget-object v1, p0, Landroid/app/UiModeManager;->mService:Landroid/app/IUiModeManager;

    invoke-interface {v1}, Landroid/app/IUiModeManager;->getCurrentModeType()I
    :try_end_9
    .catch Landroid/os/RemoteException; {:try_start_4 .. :try_end_9} :catch_b

    move-result v1

    .line 181
    :goto_a
    return v1

    .line 177
    :catch_b
    move-exception v0

    .line 178
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "UiModeManager"

    const-string v2, "getCurrentModeType: RemoteException"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 181
    .end local v0           #e:Landroid/os/RemoteException;
    :cond_13
    const/4 v1, 0x1

    goto :goto_a
.end method

.method public getNightMode()I
    .registers 4

    .prologue
    .line 215
    iget-object v1, p0, Landroid/app/UiModeManager;->mService:Landroid/app/IUiModeManager;

    if-eqz v1, :cond_13

    .line 217
    :try_start_4
    iget-object v1, p0, Landroid/app/UiModeManager;->mService:Landroid/app/IUiModeManager;

    invoke-interface {v1}, Landroid/app/IUiModeManager;->getNightMode()I
    :try_end_9
    .catch Landroid/os/RemoteException; {:try_start_4 .. :try_end_9} :catch_b

    move-result v1

    .line 222
    :goto_a
    return v1

    .line 218
    :catch_b
    move-exception v0

    .line 219
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "UiModeManager"

    const-string v2, "getNightMode: RemoteException"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 222
    .end local v0           #e:Landroid/os/RemoteException;
    :cond_13
    const/4 v1, -0x1

    goto :goto_a
.end method

.method public setNightMode(I)V
    .registers 5
    .parameter "mode"

    .prologue
    .line 199
    iget-object v1, p0, Landroid/app/UiModeManager;->mService:Landroid/app/IUiModeManager;

    if-eqz v1, :cond_9

    .line 201
    :try_start_4
    iget-object v1, p0, Landroid/app/UiModeManager;->mService:Landroid/app/IUiModeManager;

    invoke-interface {v1, p1}, Landroid/app/IUiModeManager;->setNightMode(I)V
    :try_end_9
    .catch Landroid/os/RemoteException; {:try_start_4 .. :try_end_9} :catch_a

    .line 206
    :cond_9
    :goto_9
    return-void

    .line 202
    :catch_a
    move-exception v0

    .line 203
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "UiModeManager"

    const-string/jumbo v2, "setNightMode: RemoteException"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_9
.end method
