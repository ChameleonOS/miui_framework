.class Landroid/view/ViewGroup$ChildListForAccessibility;
.super Ljava/lang/Object;
.source "ViewGroup.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/view/ViewGroup;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "ChildListForAccessibility"
.end annotation


# static fields
.field private static final MAX_POOL_SIZE:I = 0x20

.field private static sPool:Landroid/view/ViewGroup$ChildListForAccessibility;

.field private static final sPoolLock:Ljava/lang/Object;

.field private static sPoolSize:I


# instance fields
.field private final mChildren:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field private final mHolders:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/view/ViewGroup$ViewLocationHolder;",
            ">;"
        }
    .end annotation
.end field

.field private mIsPooled:Z

.field private mNext:Landroid/view/ViewGroup$ChildListForAccessibility;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Landroid/view/ViewGroup$ChildListForAccessibility;->sPoolLock:Ljava/lang/Object;

    return-void
.end method

.method constructor <init>()V
    .registers 2

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/view/ViewGroup$ChildListForAccessibility;->mChildren:Ljava/util/ArrayList;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/view/ViewGroup$ChildListForAccessibility;->mHolders:Ljava/util/ArrayList;

    return-void
.end method

.method private clear()V
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/view/ViewGroup$ChildListForAccessibility;->mChildren:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    return-void
.end method

.method private init(Landroid/view/ViewGroup;Z)V
    .registers 10
    .parameter "parent"
    .parameter "sort"

    .prologue
    iget-object v2, p0, Landroid/view/ViewGroup$ChildListForAccessibility;->mChildren:Ljava/util/ArrayList;

    .local v2, children:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/View;>;"
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v1

    .local v1, childCount:I
    const/4 v5, 0x0

    .local v5, i:I
    :goto_7
    if-ge v5, v1, :cond_13

    invoke-virtual {p1, v5}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .local v0, child:Landroid/view/View;
    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 v5, v5, 0x1

    goto :goto_7

    .end local v0           #child:Landroid/view/View;
    :cond_13
    if-eqz p2, :cond_44

    iget-object v4, p0, Landroid/view/ViewGroup$ChildListForAccessibility;->mHolders:Ljava/util/ArrayList;

    .local v4, holders:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/ViewGroup$ViewLocationHolder;>;"
    const/4 v5, 0x0

    :goto_18
    if-ge v5, v1, :cond_2a

    invoke-virtual {v2, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    .restart local v0       #child:Landroid/view/View;
    invoke-static {p1, v0}, Landroid/view/ViewGroup$ViewLocationHolder;->obtain(Landroid/view/ViewGroup;Landroid/view/View;)Landroid/view/ViewGroup$ViewLocationHolder;

    move-result-object v3

    .local v3, holder:Landroid/view/ViewGroup$ViewLocationHolder;
    invoke-virtual {v4, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 v5, v5, 0x1

    goto :goto_18

    .end local v0           #child:Landroid/view/View;
    .end local v3           #holder:Landroid/view/ViewGroup$ViewLocationHolder;
    :cond_2a
    invoke-static {v4}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    const/4 v5, 0x0

    :goto_2e
    if-ge v5, v1, :cond_41

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/view/ViewGroup$ViewLocationHolder;

    .restart local v3       #holder:Landroid/view/ViewGroup$ViewLocationHolder;
    iget-object v6, v3, Landroid/view/ViewGroup$ViewLocationHolder;->mView:Landroid/view/View;

    invoke-virtual {v2, v5, v6}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {v3}, Landroid/view/ViewGroup$ViewLocationHolder;->recycle()V

    add-int/lit8 v5, v5, 0x1

    goto :goto_2e

    .end local v3           #holder:Landroid/view/ViewGroup$ViewLocationHolder;
    :cond_41
    invoke-virtual {v4}, Ljava/util/ArrayList;->clear()V

    .end local v4           #holders:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/ViewGroup$ViewLocationHolder;>;"
    :cond_44
    return-void
.end method

.method public static obtain(Landroid/view/ViewGroup;Z)Landroid/view/ViewGroup$ChildListForAccessibility;
    .registers 6
    .parameter "parent"
    .parameter "sort"

    .prologue
    const/4 v0, 0x0

    .local v0, list:Landroid/view/ViewGroup$ChildListForAccessibility;
    sget-object v3, Landroid/view/ViewGroup$ChildListForAccessibility;->sPoolLock:Ljava/lang/Object;

    monitor-enter v3

    :try_start_4
    sget-object v2, Landroid/view/ViewGroup$ChildListForAccessibility;->sPool:Landroid/view/ViewGroup$ChildListForAccessibility;

    if-eqz v2, :cond_1f

    sget-object v0, Landroid/view/ViewGroup$ChildListForAccessibility;->sPool:Landroid/view/ViewGroup$ChildListForAccessibility;

    iget-object v2, v0, Landroid/view/ViewGroup$ChildListForAccessibility;->mNext:Landroid/view/ViewGroup$ChildListForAccessibility;

    sput-object v2, Landroid/view/ViewGroup$ChildListForAccessibility;->sPool:Landroid/view/ViewGroup$ChildListForAccessibility;

    const/4 v2, 0x0

    iput-object v2, v0, Landroid/view/ViewGroup$ChildListForAccessibility;->mNext:Landroid/view/ViewGroup$ChildListForAccessibility;

    const/4 v2, 0x0

    iput-boolean v2, v0, Landroid/view/ViewGroup$ChildListForAccessibility;->mIsPooled:Z

    sget v2, Landroid/view/ViewGroup$ChildListForAccessibility;->sPoolSize:I

    add-int/lit8 v2, v2, -0x1

    sput v2, Landroid/view/ViewGroup$ChildListForAccessibility;->sPoolSize:I

    :goto_1a
    invoke-direct {v0, p0, p1}, Landroid/view/ViewGroup$ChildListForAccessibility;->init(Landroid/view/ViewGroup;Z)V

    monitor-exit v3

    return-object v0

    :cond_1f
    new-instance v1, Landroid/view/ViewGroup$ChildListForAccessibility;

    invoke-direct {v1}, Landroid/view/ViewGroup$ChildListForAccessibility;-><init>()V

    .end local v0           #list:Landroid/view/ViewGroup$ChildListForAccessibility;
    .local v1, list:Landroid/view/ViewGroup$ChildListForAccessibility;
    move-object v0, v1

    .end local v1           #list:Landroid/view/ViewGroup$ChildListForAccessibility;
    .restart local v0       #list:Landroid/view/ViewGroup$ChildListForAccessibility;
    goto :goto_1a

    :catchall_26
    move-exception v2

    monitor-exit v3
    :try_end_28
    .catchall {:try_start_4 .. :try_end_28} :catchall_26

    throw v2
.end method


# virtual methods
.method public getChildAt(I)Landroid/view/View;
    .registers 3
    .parameter "index"

    .prologue
    iget-object v0, p0, Landroid/view/ViewGroup$ChildListForAccessibility;->mChildren:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    return-object v0
.end method

.method public getChildCount()I
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/view/ViewGroup$ChildListForAccessibility;->mChildren:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getChildIndex(Landroid/view/View;)I
    .registers 3
    .parameter "child"

    .prologue
    iget-object v0, p0, Landroid/view/ViewGroup$ChildListForAccessibility;->mChildren:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public recycle()V
    .registers 4

    .prologue
    iget-boolean v0, p0, Landroid/view/ViewGroup$ChildListForAccessibility;->mIsPooled:Z

    if-eqz v0, :cond_c

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Instance already recycled."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_c
    invoke-direct {p0}, Landroid/view/ViewGroup$ChildListForAccessibility;->clear()V

    sget-object v1, Landroid/view/ViewGroup$ChildListForAccessibility;->sPoolLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_12
    sget v0, Landroid/view/ViewGroup$ChildListForAccessibility;->sPoolSize:I

    const/16 v2, 0x20

    if-ge v0, v2, :cond_27

    sget-object v0, Landroid/view/ViewGroup$ChildListForAccessibility;->sPool:Landroid/view/ViewGroup$ChildListForAccessibility;

    iput-object v0, p0, Landroid/view/ViewGroup$ChildListForAccessibility;->mNext:Landroid/view/ViewGroup$ChildListForAccessibility;

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/view/ViewGroup$ChildListForAccessibility;->mIsPooled:Z

    sput-object p0, Landroid/view/ViewGroup$ChildListForAccessibility;->sPool:Landroid/view/ViewGroup$ChildListForAccessibility;

    sget v0, Landroid/view/ViewGroup$ChildListForAccessibility;->sPoolSize:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Landroid/view/ViewGroup$ChildListForAccessibility;->sPoolSize:I

    :cond_27
    monitor-exit v1

    return-void

    :catchall_29
    move-exception v0

    monitor-exit v1
    :try_end_2b
    .catchall {:try_start_12 .. :try_end_2b} :catchall_29

    throw v0
.end method
