.class Lcom/android/internal/view/menu/ActionMenuPresenter$Injector;
.super Ljava/lang/Object;
.source "ActionMenuPresenter.java"


# annotations
.annotation build Landroid/annotation/MiuiHook;
    value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_CLASS:Landroid/annotation/MiuiHook$MiuiHookType;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/view/menu/ActionMenuPresenter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Injector"
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 46
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static showsOverflowMenuButton(Lcom/android/internal/view/ActionBarPolicy;)Z
    .registers 2
    .parameter "abp"

    .prologue
    .line 47
    const/4 v0, 0x0

    return v0
.end method
