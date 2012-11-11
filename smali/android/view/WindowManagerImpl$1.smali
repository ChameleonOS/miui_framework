.class Landroid/view/WindowManagerImpl$1;
.super Ljava/lang/Object;
.source "WindowManagerImpl.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/view/WindowManagerImpl;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;Landroid/view/CompatibilityInfoHolder;Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/view/WindowManagerImpl;


# direct methods
.method constructor <init>(Landroid/view/WindowManagerImpl;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Landroid/view/WindowManagerImpl$1;->this$0:Landroid/view/WindowManagerImpl;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 6

    .prologue
    monitor-enter p0

    :try_start_1
    monitor-enter p0
    :try_end_2
    .catchall {:try_start_1 .. :try_end_2} :catchall_1a

    :try_start_2
    iget-object v4, p0, Landroid/view/WindowManagerImpl$1;->this$0:Landroid/view/WindowManagerImpl;

    #getter for: Landroid/view/WindowManagerImpl;->mRoots:[Landroid/view/ViewRootImpl;
    invoke-static {v4}, Landroid/view/WindowManagerImpl;->access$000(Landroid/view/WindowManagerImpl;)[Landroid/view/ViewRootImpl;

    move-result-object v0

    .local v0, arr$:[Landroid/view/ViewRootImpl;
    array-length v2, v0

    .local v2, len$:I
    const/4 v1, 0x0

    .local v1, i$:I
    :goto_a
    if-ge v1, v2, :cond_14

    aget-object v3, v0, v1

    .local v3, root:Landroid/view/ViewRootImpl;
    invoke-virtual {v3}, Landroid/view/ViewRootImpl;->loadSystemProperties()V

    add-int/lit8 v1, v1, 0x1

    goto :goto_a

    .end local v3           #root:Landroid/view/ViewRootImpl;
    :cond_14
    monitor-exit p0
    :try_end_15
    .catchall {:try_start_2 .. :try_end_15} :catchall_17

    :try_start_15
    monitor-exit p0
    :try_end_16
    .catchall {:try_start_15 .. :try_end_16} :catchall_1a

    return-void

    .end local v0           #arr$:[Landroid/view/ViewRootImpl;
    .end local v1           #i$:I
    .end local v2           #len$:I
    :catchall_17
    move-exception v4

    :try_start_18
    monitor-exit p0
    :try_end_19
    .catchall {:try_start_18 .. :try_end_19} :catchall_17

    :try_start_19
    throw v4

    :catchall_1a
    move-exception v4

    monitor-exit p0
    :try_end_1c
    .catchall {:try_start_19 .. :try_end_1c} :catchall_1a

    throw v4
.end method
