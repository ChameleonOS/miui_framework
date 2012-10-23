.class public Landroid/service/dreams/Dream;
.super Landroid/app/Service;
.source "Dream.java"

# interfaces
.implements Landroid/view/Window$Callback;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/service/dreams/Dream$IDreamServiceWrapper;
    }
.end annotation


# static fields
.field private static final DEBUG:Z = true

.field public static final SERVICE_INTERFACE:Ljava/lang/String; = "android.service.dreams.Dream"

.field private static final TAG:Ljava/lang/String; = "Dream"


# instance fields
.field mFinished:Z

.field final mHandler:Landroid/os/Handler;

.field private mInteractive:Z

.field private mSandman:Landroid/service/dreams/IDreamManager;

.field private mWindow:Landroid/view/Window;

.field private mWindowManager:Landroid/view/WindowManager;


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 40
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 61
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Landroid/service/dreams/Dream;->mHandler:Landroid/os/Handler;

    .line 63
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/service/dreams/Dream;->mFinished:Z

    .line 375
    return-void
.end method

.method static synthetic access$000(Landroid/service/dreams/Dream;)Landroid/view/Window;
    .registers 2
    .parameter "x0"

    .prologue
    .line 40
    iget-object v0, p0, Landroid/service/dreams/Dream;->mWindow:Landroid/view/Window;

    return-object v0
.end method


# virtual methods
.method public addContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    .registers 4
    .parameter "view"
    .parameter "params"

    .prologue
    .line 275
    invoke-virtual {p0}, Landroid/service/dreams/Dream;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Landroid/view/Window;->addContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 276
    return-void
.end method

.method final attach(Landroid/os/IBinder;)V
    .registers 9
    .parameter "windowToken"

    .prologue
    const/16 v6, 0x7e7

    const/4 v5, 0x1

    .line 327
    const-string v1, "Dream"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Dream attached on thread "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Thread;->getId()J

    move-result-wide v3

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Slog;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 329
    invoke-static {p0}, Lcom/android/internal/policy/PolicyManager;->makeNewWindow(Landroid/content/Context;)Landroid/view/Window;

    move-result-object v1

    iput-object v1, p0, Landroid/service/dreams/Dream;->mWindow:Landroid/view/Window;

    .line 330
    iget-object v1, p0, Landroid/service/dreams/Dream;->mWindow:Landroid/view/Window;

    invoke-virtual {v1, p0}, Landroid/view/Window;->setCallback(Landroid/view/Window$Callback;)V

    .line 331
    iget-object v1, p0, Landroid/service/dreams/Dream;->mWindow:Landroid/view/Window;

    invoke-virtual {v1, v5}, Landroid/view/Window;->requestFeature(I)Z

    .line 332
    iget-object v1, p0, Landroid/service/dreams/Dream;->mWindow:Landroid/view/Window;

    new-instance v2, Landroid/graphics/drawable/ColorDrawable;

    const/high16 v3, -0x100

    invoke-direct {v2, v3}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v1, v2}, Landroid/view/Window;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 334
    const-string v1, "Dream"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "attaching window token: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " to window of type "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Slog;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 337
    iget-object v1, p0, Landroid/service/dreams/Dream;->mWindow:Landroid/view/Window;

    invoke-virtual {v1}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v0

    .line 338
    .local v0, lp:Landroid/view/WindowManager$LayoutParams;
    iput v6, v0, Landroid/view/WindowManager$LayoutParams;->type:I

    .line 339
    iput-object p1, v0, Landroid/view/WindowManager$LayoutParams;->token:Landroid/os/IBinder;

    .line 340
    const v1, 0x10301ed

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->windowAnimations:I

    .line 344
    const-string v1, "Dream"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "created and attached window: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Landroid/service/dreams/Dream;->mWindow:Landroid/view/Window;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Slog;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 346
    iget-object v1, p0, Landroid/service/dreams/Dream;->mWindow:Landroid/view/Window;

    const/4 v2, 0x0

    const-string v3, "dream"

    invoke-virtual {v1, v2, p1, v3, v5}, Landroid/view/Window;->setWindowManager(Landroid/view/WindowManager;Landroid/os/IBinder;Ljava/lang/String;Z)V

    .line 347
    iget-object v1, p0, Landroid/service/dreams/Dream;->mWindow:Landroid/view/Window;

    invoke-virtual {v1}, Landroid/view/Window;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v1

    iput-object v1, p0, Landroid/service/dreams/Dream;->mWindowManager:Landroid/view/WindowManager;

    .line 350
    iget-object v1, p0, Landroid/service/dreams/Dream;->mHandler:Landroid/os/Handler;

    new-instance v2, Landroid/service/dreams/Dream$1;

    invoke-direct {v2, p0}, Landroid/service/dreams/Dream$1;-><init>(Landroid/service/dreams/Dream;)V

    invoke-virtual {v1, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 357
    return-void
.end method

.method public dispatchGenericMotionEvent(Landroid/view/MotionEvent;)Z
    .registers 3
    .parameter "event"

    .prologue
    .line 104
    iget-boolean v0, p0, Landroid/service/dreams/Dream;->mInteractive:Z

    if-nez v0, :cond_9

    .line 105
    invoke-virtual {p0}, Landroid/service/dreams/Dream;->finish()V

    .line 106
    const/4 v0, 0x1

    .line 108
    :goto_8
    return v0

    :cond_9
    iget-object v0, p0, Landroid/service/dreams/Dream;->mWindow:Landroid/view/Window;

    invoke-virtual {v0, p1}, Landroid/view/Window;->superDispatchGenericMotionEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_8
.end method

.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .registers 3
    .parameter "event"

    .prologue
    .line 68
    iget-boolean v0, p0, Landroid/service/dreams/Dream;->mInteractive:Z

    if-nez v0, :cond_9

    .line 69
    invoke-virtual {p0}, Landroid/service/dreams/Dream;->finish()V

    .line 70
    const/4 v0, 0x1

    .line 72
    :goto_8
    return v0

    :cond_9
    iget-object v0, p0, Landroid/service/dreams/Dream;->mWindow:Landroid/view/Window;

    invoke-virtual {v0, p1}, Landroid/view/Window;->superDispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_8
.end method

.method public dispatchKeyShortcutEvent(Landroid/view/KeyEvent;)Z
    .registers 3
    .parameter "event"

    .prologue
    .line 77
    iget-boolean v0, p0, Landroid/service/dreams/Dream;->mInteractive:Z

    if-nez v0, :cond_9

    .line 78
    invoke-virtual {p0}, Landroid/service/dreams/Dream;->finish()V

    .line 79
    const/4 v0, 0x1

    .line 81
    :goto_8
    return v0

    :cond_9
    iget-object v0, p0, Landroid/service/dreams/Dream;->mWindow:Landroid/view/Window;

    invoke-virtual {v0, p1}, Landroid/view/Window;->superDispatchKeyShortcutEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_8
.end method

.method public dispatchPopulateAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)Z
    .registers 3
    .parameter "event"

    .prologue
    .line 113
    const/4 v0, 0x0

    return v0
.end method

.method public dispatchTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 3
    .parameter "event"

    .prologue
    .line 86
    iget-boolean v0, p0, Landroid/service/dreams/Dream;->mInteractive:Z

    if-nez v0, :cond_9

    .line 87
    invoke-virtual {p0}, Landroid/service/dreams/Dream;->finish()V

    .line 88
    const/4 v0, 0x1

    .line 90
    :goto_8
    return v0

    :cond_9
    iget-object v0, p0, Landroid/service/dreams/Dream;->mWindow:Landroid/view/Window;

    invoke-virtual {v0, p1}, Landroid/view/Window;->superDispatchTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_8
.end method

.method public dispatchTrackballEvent(Landroid/view/MotionEvent;)Z
    .registers 3
    .parameter "event"

    .prologue
    .line 95
    iget-boolean v0, p0, Landroid/service/dreams/Dream;->mInteractive:Z

    if-nez v0, :cond_9

    .line 96
    invoke-virtual {p0}, Landroid/service/dreams/Dream;->finish()V

    .line 97
    const/4 v0, 0x1

    .line 99
    :goto_8
    return v0

    :cond_9
    iget-object v0, p0, Landroid/service/dreams/Dream;->mWindow:Landroid/view/Window;

    invoke-virtual {v0, p1}, Landroid/view/Window;->superDispatchTrackballEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_8
.end method

.method public findViewById(I)Landroid/view/View;
    .registers 3
    .parameter "id"

    .prologue
    .line 308
    invoke-virtual {p0}, Landroid/service/dreams/Dream;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/view/Window;->findViewById(I)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public finish()V
    .registers 2

    .prologue
    .line 365
    iget-boolean v0, p0, Landroid/service/dreams/Dream;->mFinished:Z

    if-eqz v0, :cond_5

    .line 373
    :goto_4
    return-void

    .line 367
    :cond_5
    :try_start_5
    iget-object v0, p0, Landroid/service/dreams/Dream;->mSandman:Landroid/service/dreams/IDreamManager;

    invoke-interface {v0}, Landroid/service/dreams/IDreamManager;->awaken()V

    .line 368
    invoke-virtual {p0}, Landroid/service/dreams/Dream;->stopSelf()V

    .line 369
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/service/dreams/Dream;->mFinished:Z
    :try_end_10
    .catch Landroid/os/RemoteException; {:try_start_5 .. :try_end_10} :catch_11

    goto :goto_4

    .line 370
    :catch_11
    move-exception v0

    goto :goto_4
.end method

.method public getWindow()Landroid/view/Window;
    .registers 2

    .prologue
    .line 197
    iget-object v0, p0, Landroid/service/dreams/Dream;->mWindow:Landroid/view/Window;

    return-object v0
.end method

.method public getWindowManager()Landroid/view/WindowManager;
    .registers 2

    .prologue
    .line 193
    iget-object v0, p0, Landroid/service/dreams/Dream;->mWindowManager:Landroid/view/WindowManager;

    return-object v0
.end method

.method public isInteractive()Z
    .registers 2

    .prologue
    .line 289
    iget-boolean v0, p0, Landroid/service/dreams/Dream;->mInteractive:Z

    return v0
.end method

.method protected lightsOut()V
    .registers 3

    .prologue
    .line 295
    iget-object v1, p0, Landroid/service/dreams/Dream;->mWindow:Landroid/view/Window;

    invoke-virtual {v1}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    .line 296
    .local v0, v:Landroid/view/View;
    if-eqz v0, :cond_c

    .line 297
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/view/View;->setSystemUiVisibility(I)V

    .line 299
    :cond_c
    return-void
.end method

.method public onActionModeFinished(Landroid/view/ActionMode;)V
    .registers 2
    .parameter "mode"

    .prologue
    .line 189
    return-void
.end method

.method public onActionModeStarted(Landroid/view/ActionMode;)V
    .registers 2
    .parameter "mode"

    .prologue
    .line 185
    return-void
.end method

.method public onAttachedToWindow()V
    .registers 3

    .prologue
    .line 158
    iget-object v0, p0, Landroid/service/dreams/Dream;->mWindow:Landroid/view/Window;

    const v1, 0x80001

    invoke-virtual {v0, v1}, Landroid/view/Window;->addFlags(I)V

    .line 162
    invoke-virtual {p0}, Landroid/service/dreams/Dream;->lightsOut()V

    .line 163
    return-void
.end method

.method public final onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .registers 3
    .parameter "intent"

    .prologue
    .line 390
    new-instance v0, Landroid/service/dreams/Dream$IDreamServiceWrapper;

    invoke-direct {v0, p0}, Landroid/service/dreams/Dream$IDreamServiceWrapper;-><init>(Landroid/service/dreams/Dream;)V

    return-object v0
.end method

.method public onContentChanged()V
    .registers 1

    .prologue
    .line 149
    return-void
.end method

.method public onCreate()V
    .registers 5

    .prologue
    .line 207
    invoke-super {p0}, Landroid/app/Service;->onCreate()V

    .line 209
    const-string v0, "Dream"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Dream created on thread "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Thread;->getId()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Slog;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 211
    const-string v0, "dreams"

    invoke-static {v0}, Landroid/os/ServiceManager;->getService(Ljava/lang/String;)Landroid/os/IBinder;

    move-result-object v0

    invoke-static {v0}, Landroid/service/dreams/IDreamManager$Stub;->asInterface(Landroid/os/IBinder;)Landroid/service/dreams/IDreamManager;

    move-result-object v0

    iput-object v0, p0, Landroid/service/dreams/Dream;->mSandman:Landroid/service/dreams/IDreamManager;

    .line 212
    return-void
.end method

.method public onCreatePanelMenu(ILandroid/view/Menu;)Z
    .registers 4
    .parameter "featureId"
    .parameter "menu"

    .prologue
    .line 123
    const/4 v0, 0x0

    return v0
.end method

.method public onCreatePanelView(I)Landroid/view/View;
    .registers 3
    .parameter "featureId"

    .prologue
    .line 118
    const/4 v0, 0x0

    return-object v0
.end method

.method public onDestroy()V
    .registers 3

    .prologue
    .line 316
    invoke-super {p0}, Landroid/app/Service;->onDestroy()V

    .line 317
    iget-object v0, p0, Landroid/service/dreams/Dream;->mWindowManager:Landroid/view/WindowManager;

    iget-object v1, p0, Landroid/service/dreams/Dream;->mWindow:Landroid/view/Window;

    invoke-virtual {v1}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v1

    invoke-interface {v0, v1}, Landroid/view/WindowManager;->removeView(Landroid/view/View;)V

    .line 318
    return-void
.end method

.method public onDetachedFromWindow()V
    .registers 1

    .prologue
    .line 167
    return-void
.end method

.method public onMenuItemSelected(ILandroid/view/MenuItem;)Z
    .registers 4
    .parameter "featureId"
    .parameter "item"

    .prologue
    .line 138
    const/4 v0, 0x0

    return v0
.end method

.method public onMenuOpened(ILandroid/view/Menu;)Z
    .registers 4
    .parameter "featureId"
    .parameter "menu"

    .prologue
    .line 133
    const/4 v0, 0x0

    return v0
.end method

.method public onPanelClosed(ILandroid/view/Menu;)V
    .registers 3
    .parameter "featureId"
    .parameter "menu"

    .prologue
    .line 171
    return-void
.end method

.method public onPreparePanel(ILandroid/view/View;Landroid/view/Menu;)Z
    .registers 5
    .parameter "featureId"
    .parameter "view"
    .parameter "menu"

    .prologue
    .line 128
    const/4 v0, 0x0

    return v0
.end method

.method public onSearchRequested()Z
    .registers 2

    .prologue
    .line 175
    const/4 v0, 0x0

    return v0
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .registers 5
    .parameter "intent"
    .parameter "flags"
    .parameter "startId"

    .prologue
    .line 223
    invoke-super {p0, p1, p2, p3}, Landroid/app/Service;->onStartCommand(Landroid/content/Intent;II)I

    move-result v0

    return v0
.end method

.method public onWindowAttributesChanged(Landroid/view/WindowManager$LayoutParams;)V
    .registers 2
    .parameter "attrs"

    .prologue
    .line 144
    return-void
.end method

.method public onWindowFocusChanged(Z)V
    .registers 2
    .parameter "hasFocus"

    .prologue
    .line 154
    return-void
.end method

.method public onWindowStartingActionMode(Landroid/view/ActionMode$Callback;)Landroid/view/ActionMode;
    .registers 3
    .parameter "callback"

    .prologue
    .line 180
    const/4 v0, 0x0

    return-object v0
.end method

.method public setContentView(I)V
    .registers 3
    .parameter "layoutResID"

    .prologue
    .line 236
    invoke-virtual {p0}, Landroid/service/dreams/Dream;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/view/Window;->setContentView(I)V

    .line 237
    return-void
.end method

.method public setContentView(Landroid/view/View;)V
    .registers 3
    .parameter "view"

    .prologue
    .line 250
    invoke-virtual {p0}, Landroid/service/dreams/Dream;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/view/Window;->setContentView(Landroid/view/View;)V

    .line 251
    return-void
.end method

.method public setContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    .registers 4
    .parameter "view"
    .parameter "params"

    .prologue
    .line 265
    invoke-virtual {p0}, Landroid/service/dreams/Dream;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Landroid/view/Window;->setContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 266
    return-void
.end method

.method public setInteractive(Z)V
    .registers 2
    .parameter "mInteractive"

    .prologue
    .line 282
    iput-boolean p1, p0, Landroid/service/dreams/Dream;->mInteractive:Z

    .line 283
    return-void
.end method
