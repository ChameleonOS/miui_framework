.class Landroid/view/ViewGroup$ViewLocationHolder;
.super Ljava/lang/Object;
.source "ViewGroup.java"

# interfaces
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/view/ViewGroup;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "ViewLocationHolder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Comparable",
        "<",
        "Landroid/view/ViewGroup$ViewLocationHolder;",
        ">;"
    }
.end annotation


# static fields
.field private static final MAX_POOL_SIZE:I = 0x20

.field private static sPool:Landroid/view/ViewGroup$ViewLocationHolder;

.field private static final sPoolLock:Ljava/lang/Object;

.field private static sPoolSize:I


# instance fields
.field private mIsPooled:Z

.field private mLayoutDirection:I

.field private final mLocation:Landroid/graphics/Rect;

.field private mNext:Landroid/view/ViewGroup$ViewLocationHolder;

.field public mView:Landroid/view/View;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Landroid/view/ViewGroup$ViewLocationHolder;->sPoolLock:Ljava/lang/Object;

    return-void
.end method

.method constructor <init>()V
    .registers 2

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/view/ViewGroup$ViewLocationHolder;->mLocation:Landroid/graphics/Rect;

    return-void
.end method

.method private clear()V
    .registers 3

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/view/ViewGroup$ViewLocationHolder;->mView:Landroid/view/View;

    iget-object v0, p0, Landroid/view/ViewGroup$ViewLocationHolder;->mLocation:Landroid/graphics/Rect;

    invoke-virtual {v0, v1, v1, v1, v1}, Landroid/graphics/Rect;->set(IIII)V

    return-void
.end method

.method private init(Landroid/view/ViewGroup;Landroid/view/View;)V
    .registers 5
    .parameter "root"
    .parameter "view"

    .prologue
    iget-object v0, p0, Landroid/view/ViewGroup$ViewLocationHolder;->mLocation:Landroid/graphics/Rect;

    .local v0, viewLocation:Landroid/graphics/Rect;
    invoke-virtual {p2, v0}, Landroid/view/View;->getDrawingRect(Landroid/graphics/Rect;)V

    invoke-virtual {p1, p2, v0}, Landroid/view/ViewGroup;->offsetDescendantRectToMyCoords(Landroid/view/View;Landroid/graphics/Rect;)V

    iput-object p2, p0, Landroid/view/ViewGroup$ViewLocationHolder;->mView:Landroid/view/View;

    invoke-virtual {p1}, Landroid/view/ViewGroup;->getResolvedLayoutDirection()I

    move-result v1

    iput v1, p0, Landroid/view/ViewGroup$ViewLocationHolder;->mLayoutDirection:I

    return-void
.end method

.method public static obtain(Landroid/view/ViewGroup;Landroid/view/View;)Landroid/view/ViewGroup$ViewLocationHolder;
    .registers 6
    .parameter "root"
    .parameter "view"

    .prologue
    const/4 v0, 0x0

    .local v0, holder:Landroid/view/ViewGroup$ViewLocationHolder;
    sget-object v3, Landroid/view/ViewGroup$ViewLocationHolder;->sPoolLock:Ljava/lang/Object;

    monitor-enter v3

    :try_start_4
    sget-object v2, Landroid/view/ViewGroup$ViewLocationHolder;->sPool:Landroid/view/ViewGroup$ViewLocationHolder;

    if-eqz v2, :cond_1f

    sget-object v0, Landroid/view/ViewGroup$ViewLocationHolder;->sPool:Landroid/view/ViewGroup$ViewLocationHolder;

    iget-object v2, v0, Landroid/view/ViewGroup$ViewLocationHolder;->mNext:Landroid/view/ViewGroup$ViewLocationHolder;

    sput-object v2, Landroid/view/ViewGroup$ViewLocationHolder;->sPool:Landroid/view/ViewGroup$ViewLocationHolder;

    const/4 v2, 0x0

    iput-object v2, v0, Landroid/view/ViewGroup$ViewLocationHolder;->mNext:Landroid/view/ViewGroup$ViewLocationHolder;

    const/4 v2, 0x0

    iput-boolean v2, v0, Landroid/view/ViewGroup$ViewLocationHolder;->mIsPooled:Z

    sget v2, Landroid/view/ViewGroup$ViewLocationHolder;->sPoolSize:I

    add-int/lit8 v2, v2, -0x1

    sput v2, Landroid/view/ViewGroup$ViewLocationHolder;->sPoolSize:I

    :goto_1a
    invoke-direct {v0, p0, p1}, Landroid/view/ViewGroup$ViewLocationHolder;->init(Landroid/view/ViewGroup;Landroid/view/View;)V

    monitor-exit v3

    return-object v0

    :cond_1f
    new-instance v1, Landroid/view/ViewGroup$ViewLocationHolder;

    invoke-direct {v1}, Landroid/view/ViewGroup$ViewLocationHolder;-><init>()V

    .end local v0           #holder:Landroid/view/ViewGroup$ViewLocationHolder;
    .local v1, holder:Landroid/view/ViewGroup$ViewLocationHolder;
    move-object v0, v1

    .end local v1           #holder:Landroid/view/ViewGroup$ViewLocationHolder;
    .restart local v0       #holder:Landroid/view/ViewGroup$ViewLocationHolder;
    goto :goto_1a

    :catchall_26
    move-exception v2

    monitor-exit v3
    :try_end_28
    .catchall {:try_start_4 .. :try_end_28} :catchall_26

    throw v2
.end method


# virtual methods
.method public compareTo(Landroid/view/ViewGroup$ViewLocationHolder;)I
    .registers 9
    .parameter "another"

    .prologue
    const/4 v1, 0x1

    if-nez p1, :cond_4

    :cond_3
    :goto_3
    return v1

    :cond_4
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v6

    if-ne v5, v6, :cond_3

    iget-object v5, p0, Landroid/view/ViewGroup$ViewLocationHolder;->mLocation:Landroid/graphics/Rect;

    iget v5, v5, Landroid/graphics/Rect;->bottom:I

    iget-object v6, p1, Landroid/view/ViewGroup$ViewLocationHolder;->mLocation:Landroid/graphics/Rect;

    iget v6, v6, Landroid/graphics/Rect;->top:I

    sub-int/2addr v5, v6

    if-gtz v5, :cond_1b

    const/4 v1, -0x1

    goto :goto_3

    :cond_1b
    iget-object v5, p0, Landroid/view/ViewGroup$ViewLocationHolder;->mLocation:Landroid/graphics/Rect;

    iget v5, v5, Landroid/graphics/Rect;->top:I

    iget-object v6, p1, Landroid/view/ViewGroup$ViewLocationHolder;->mLocation:Landroid/graphics/Rect;

    iget v6, v6, Landroid/graphics/Rect;->bottom:I

    sub-int/2addr v5, v6

    if-gez v5, :cond_3

    iget v5, p0, Landroid/view/ViewGroup$ViewLocationHolder;->mLayoutDirection:I

    if-nez v5, :cond_44

    iget-object v5, p0, Landroid/view/ViewGroup$ViewLocationHolder;->mLocation:Landroid/graphics/Rect;

    iget v5, v5, Landroid/graphics/Rect;->left:I

    iget-object v6, p1, Landroid/view/ViewGroup$ViewLocationHolder;->mLocation:Landroid/graphics/Rect;

    iget v6, v6, Landroid/graphics/Rect;->left:I

    sub-int v1, v5, v6

    .local v1, leftDifference:I
    if-nez v1, :cond_3

    .end local v1           #leftDifference:I
    :cond_36
    iget-object v5, p0, Landroid/view/ViewGroup$ViewLocationHolder;->mLocation:Landroid/graphics/Rect;

    iget v5, v5, Landroid/graphics/Rect;->top:I

    iget-object v6, p1, Landroid/view/ViewGroup$ViewLocationHolder;->mLocation:Landroid/graphics/Rect;

    iget v6, v6, Landroid/graphics/Rect;->top:I

    sub-int v3, v5, v6

    .local v3, topDiference:I
    if-eqz v3, :cond_52

    move v1, v3

    goto :goto_3

    .end local v3           #topDiference:I
    :cond_44
    iget-object v5, p0, Landroid/view/ViewGroup$ViewLocationHolder;->mLocation:Landroid/graphics/Rect;

    iget v5, v5, Landroid/graphics/Rect;->right:I

    iget-object v6, p1, Landroid/view/ViewGroup$ViewLocationHolder;->mLocation:Landroid/graphics/Rect;

    iget v6, v6, Landroid/graphics/Rect;->right:I

    sub-int v2, v5, v6

    .local v2, rightDifference:I
    if-eqz v2, :cond_36

    neg-int v1, v2

    goto :goto_3

    .end local v2           #rightDifference:I
    .restart local v3       #topDiference:I
    :cond_52
    iget-object v5, p0, Landroid/view/ViewGroup$ViewLocationHolder;->mLocation:Landroid/graphics/Rect;

    invoke-virtual {v5}, Landroid/graphics/Rect;->height()I

    move-result v5

    iget-object v6, p1, Landroid/view/ViewGroup$ViewLocationHolder;->mLocation:Landroid/graphics/Rect;

    invoke-virtual {v6}, Landroid/graphics/Rect;->height()I

    move-result v6

    sub-int v0, v5, v6

    .local v0, heightDiference:I
    if-eqz v0, :cond_64

    neg-int v1, v0

    goto :goto_3

    :cond_64
    iget-object v5, p0, Landroid/view/ViewGroup$ViewLocationHolder;->mLocation:Landroid/graphics/Rect;

    invoke-virtual {v5}, Landroid/graphics/Rect;->width()I

    move-result v5

    iget-object v6, p1, Landroid/view/ViewGroup$ViewLocationHolder;->mLocation:Landroid/graphics/Rect;

    invoke-virtual {v6}, Landroid/graphics/Rect;->width()I

    move-result v6

    sub-int v4, v5, v6

    .local v4, widthDiference:I
    if-eqz v4, :cond_76

    neg-int v1, v4

    goto :goto_3

    :cond_76
    iget-object v5, p0, Landroid/view/ViewGroup$ViewLocationHolder;->mView:Landroid/view/View;

    invoke-virtual {v5}, Landroid/view/View;->getAccessibilityViewId()I

    move-result v5

    iget-object v6, p1, Landroid/view/ViewGroup$ViewLocationHolder;->mView:Landroid/view/View;

    invoke-virtual {v6}, Landroid/view/View;->getAccessibilityViewId()I

    move-result v6

    sub-int v1, v5, v6

    goto/16 :goto_3
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .registers 3
    .parameter "x0"

    .prologue
    check-cast p1, Landroid/view/ViewGroup$ViewLocationHolder;

    .end local p1
    invoke-virtual {p0, p1}, Landroid/view/ViewGroup$ViewLocationHolder;->compareTo(Landroid/view/ViewGroup$ViewLocationHolder;)I

    move-result v0

    return v0
.end method

.method public recycle()V
    .registers 4

    .prologue
    iget-boolean v0, p0, Landroid/view/ViewGroup$ViewLocationHolder;->mIsPooled:Z

    if-eqz v0, :cond_c

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Instance already recycled."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_c
    invoke-direct {p0}, Landroid/view/ViewGroup$ViewLocationHolder;->clear()V

    sget-object v1, Landroid/view/ViewGroup$ViewLocationHolder;->sPoolLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_12
    sget v0, Landroid/view/ViewGroup$ViewLocationHolder;->sPoolSize:I

    const/16 v2, 0x20

    if-ge v0, v2, :cond_27

    sget-object v0, Landroid/view/ViewGroup$ViewLocationHolder;->sPool:Landroid/view/ViewGroup$ViewLocationHolder;

    iput-object v0, p0, Landroid/view/ViewGroup$ViewLocationHolder;->mNext:Landroid/view/ViewGroup$ViewLocationHolder;

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/view/ViewGroup$ViewLocationHolder;->mIsPooled:Z

    sput-object p0, Landroid/view/ViewGroup$ViewLocationHolder;->sPool:Landroid/view/ViewGroup$ViewLocationHolder;

    sget v0, Landroid/view/ViewGroup$ViewLocationHolder;->sPoolSize:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Landroid/view/ViewGroup$ViewLocationHolder;->sPoolSize:I

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
