.class public abstract Landroid/app/FragmentManager;
.super Ljava/lang/Object;
.source "FragmentManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/app/FragmentManager$OnBackStackChangedListener;,
        Landroid/app/FragmentManager$BackStackEntry;
    }
.end annotation


# static fields
.field public static final POP_BACK_STACK_INCLUSIVE:I = 0x1


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 62
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 117
    return-void
.end method

.method public static enableDebugLogging(Z)V
    .registers 1
    .parameter "enabled"

    .prologue
    .line 336
    sput-boolean p0, Landroid/app/FragmentManagerImpl;->DEBUG:Z

    .line 337
    return-void
.end method


# virtual methods
.method public abstract addOnBackStackChangedListener(Landroid/app/FragmentManager$OnBackStackChangedListener;)V
.end method

.method public abstract beginTransaction()Landroid/app/FragmentTransaction;
.end method

.method public abstract dump(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
.end method

.method public abstract executePendingTransactions()Z
.end method

.method public abstract findFragmentById(I)Landroid/app/Fragment;
.end method

.method public abstract findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;
.end method

.method public abstract getBackStackEntryAt(I)Landroid/app/FragmentManager$BackStackEntry;
.end method

.method public abstract getBackStackEntryCount()I
.end method

.method public abstract getFragment(Landroid/os/Bundle;Ljava/lang/String;)Landroid/app/Fragment;
.end method

.method public invalidateOptionsMenu()V
    .registers 1

    .prologue
    .line 343
    return-void
.end method

.method public openTransaction()Landroid/app/FragmentTransaction;
    .registers 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 142
    invoke-virtual {p0}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v0

    return-object v0
.end method

.method public abstract popBackStack()V
.end method

.method public abstract popBackStack(II)V
.end method

.method public abstract popBackStack(Ljava/lang/String;I)V
.end method

.method public abstract popBackStackImmediate()Z
.end method

.method public abstract popBackStackImmediate(II)Z
.end method

.method public abstract popBackStackImmediate(Ljava/lang/String;I)Z
.end method

.method public abstract putFragment(Landroid/os/Bundle;Ljava/lang/String;Landroid/app/Fragment;)V
.end method

.method public abstract removeOnBackStackChangedListener(Landroid/app/FragmentManager$OnBackStackChangedListener;)V
.end method

.method public abstract saveFragmentInstanceState(Landroid/app/Fragment;)Landroid/app/Fragment$SavedState;
.end method
