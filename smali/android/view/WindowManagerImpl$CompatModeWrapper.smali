.class Landroid/view/WindowManagerImpl$CompatModeWrapper;
.super Ljava/lang/Object;
.source "WindowManagerImpl.java"

# interfaces
.implements Landroid/view/WindowManager;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/view/WindowManagerImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "CompatModeWrapper"
.end annotation


# instance fields
.field private final mCompatibilityInfo:Landroid/view/CompatibilityInfoHolder;

.field private final mDefaultDisplay:Landroid/view/Display;

.field private final mWindowManager:Landroid/view/WindowManagerImpl;


# direct methods
.method constructor <init>(Landroid/view/WindowManager;Landroid/view/CompatibilityInfoHolder;)V
    .registers 4
    .parameter "wm"
    .parameter "ci"

    .prologue
    .line 128
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 129
    instance-of v0, p1, Landroid/view/WindowManagerImpl$CompatModeWrapper;

    if-eqz v0, :cond_1a

    check-cast p1, Landroid/view/WindowManagerImpl$CompatModeWrapper;

    .end local p1
    iget-object p1, p1, Landroid/view/WindowManagerImpl$CompatModeWrapper;->mWindowManager:Landroid/view/WindowManagerImpl;

    :goto_b
    iput-object p1, p0, Landroid/view/WindowManagerImpl$CompatModeWrapper;->mWindowManager:Landroid/view/WindowManagerImpl;

    .line 136
    if-nez p2, :cond_1d

    .line 137
    iget-object v0, p0, Landroid/view/WindowManagerImpl$CompatModeWrapper;->mWindowManager:Landroid/view/WindowManagerImpl;

    invoke-virtual {v0}, Landroid/view/WindowManagerImpl;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    iput-object v0, p0, Landroid/view/WindowManagerImpl$CompatModeWrapper;->mDefaultDisplay:Landroid/view/Display;

    .line 144
    :goto_17
    iput-object p2, p0, Landroid/view/WindowManagerImpl$CompatModeWrapper;->mCompatibilityInfo:Landroid/view/CompatibilityInfoHolder;

    .line 145
    return-void

    .line 129
    .restart local p1
    :cond_1a
    check-cast p1, Landroid/view/WindowManagerImpl;

    goto :goto_b

    .line 140
    .end local p1
    :cond_1d
    iget-object v0, p0, Landroid/view/WindowManagerImpl$CompatModeWrapper;->mWindowManager:Landroid/view/WindowManagerImpl;

    invoke-virtual {v0}, Landroid/view/WindowManagerImpl;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Display;->getDisplayId()I

    move-result v0

    invoke-static {v0, p2}, Landroid/view/Display;->createCompatibleDisplay(ILandroid/view/CompatibilityInfoHolder;)Landroid/view/Display;

    move-result-object v0

    iput-object v0, p0, Landroid/view/WindowManagerImpl$CompatModeWrapper;->mDefaultDisplay:Landroid/view/Display;

    goto :goto_17
.end method


# virtual methods
.method public addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    .registers 5
    .parameter "view"
    .parameter "params"

    .prologue
    .line 149
    iget-object v0, p0, Landroid/view/WindowManagerImpl$CompatModeWrapper;->mWindowManager:Landroid/view/WindowManagerImpl;

    iget-object v1, p0, Landroid/view/WindowManagerImpl$CompatModeWrapper;->mCompatibilityInfo:Landroid/view/CompatibilityInfoHolder;

    invoke-virtual {v0, p1, p2, v1}, Landroid/view/WindowManagerImpl;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;Landroid/view/CompatibilityInfoHolder;)V

    .line 150
    return-void
.end method

.method public getDefaultDisplay()Landroid/view/Display;
    .registers 2

    .prologue
    .line 165
    iget-object v0, p0, Landroid/view/WindowManagerImpl$CompatModeWrapper;->mDefaultDisplay:Landroid/view/Display;

    return-object v0
.end method

.method public isHardwareAccelerated()Z
    .registers 2

    .prologue
    .line 175
    iget-object v0, p0, Landroid/view/WindowManagerImpl$CompatModeWrapper;->mWindowManager:Landroid/view/WindowManagerImpl;

    invoke-virtual {v0}, Landroid/view/WindowManagerImpl;->isHardwareAccelerated()Z

    move-result v0

    return v0
.end method

.method public removeView(Landroid/view/View;)V
    .registers 3
    .parameter "view"

    .prologue
    .line 160
    iget-object v0, p0, Landroid/view/WindowManagerImpl$CompatModeWrapper;->mWindowManager:Landroid/view/WindowManagerImpl;

    invoke-virtual {v0, p1}, Landroid/view/WindowManagerImpl;->removeView(Landroid/view/View;)V

    .line 161
    return-void
.end method

.method public removeViewImmediate(Landroid/view/View;)V
    .registers 3
    .parameter "view"

    .prologue
    .line 170
    iget-object v0, p0, Landroid/view/WindowManagerImpl$CompatModeWrapper;->mWindowManager:Landroid/view/WindowManagerImpl;

    invoke-virtual {v0, p1}, Landroid/view/WindowManagerImpl;->removeViewImmediate(Landroid/view/View;)V

    .line 171
    return-void
.end method

.method public updateViewLayout(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    .registers 4
    .parameter "view"
    .parameter "params"

    .prologue
    .line 154
    iget-object v0, p0, Landroid/view/WindowManagerImpl$CompatModeWrapper;->mWindowManager:Landroid/view/WindowManagerImpl;

    invoke-virtual {v0, p1, p2}, Landroid/view/WindowManagerImpl;->updateViewLayout(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 156
    return-void
.end method
