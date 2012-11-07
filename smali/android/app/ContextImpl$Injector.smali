.class Landroid/app/ContextImpl$Injector;
.super Ljava/lang/Object;
.source "ContextImpl.java"


# annotations
.annotation build Landroid/annotation/MiuiHook;
    value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_CLASS:Landroid/annotation/MiuiHook$MiuiHookType;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/app/ContextImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Injector"
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 153
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static checkPriority(Landroid/app/ContextImpl;Landroid/content/IntentFilter;)V
    .registers 5
    .parameter "context"
    .parameter "filter"

    .prologue
    .line 155
    iget-object v1, p0, Landroid/app/ContextImpl;->mPackageInfo:Landroid/app/LoadedApk;

    if-eqz v1, :cond_1f

    .line 156
    iget-object v1, p0, Landroid/app/ContextImpl;->mPackageInfo:Landroid/app/LoadedApk;

    invoke-virtual {v1}, Landroid/app/LoadedApk;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    .line 157
    .local v0, ai:Landroid/content/pm/ApplicationInfo;
    if-eqz v0, :cond_1f

    iget v1, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/lit8 v1, v1, 0x1

    if-nez v1, :cond_1f

    .line 158
    invoke-virtual {p1}, Landroid/content/IntentFilter;->getPriority()I

    move-result v1

    const/16 v2, 0x3e8

    if-lt v1, v2, :cond_20

    .line 159
    const/16 v1, 0x3e7

    invoke-virtual {p1, v1}, Landroid/content/IntentFilter;->setPriority(I)V

    .line 165
    .end local v0           #ai:Landroid/content/pm/ApplicationInfo;
    :cond_1f
    :goto_1f
    return-void

    .line 160
    .restart local v0       #ai:Landroid/content/pm/ApplicationInfo;
    :cond_20
    invoke-virtual {p1}, Landroid/content/IntentFilter;->getPriority()I

    move-result v1

    const/16 v2, -0x3e8

    if-gt v1, v2, :cond_1f

    .line 161
    const/16 v1, -0x3e7

    invoke-virtual {p1, v1}, Landroid/content/IntentFilter;->setPriority(I)V

    goto :goto_1f
.end method
