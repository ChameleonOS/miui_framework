.class final Landroid/view/ViewGroup$HoverTarget;
.super Ljava/lang/Object;
.source "ViewGroup.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/view/ViewGroup;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "HoverTarget"
.end annotation


# static fields
.field private static final MAX_RECYCLED:I = 0x20

.field private static sRecycleBin:Landroid/view/ViewGroup$HoverTarget;

.field private static final sRecycleLock:Ljava/lang/Object;

.field private static sRecycledCount:I


# instance fields
.field public child:Landroid/view/View;

.field public next:Landroid/view/ViewGroup$HoverTarget;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 5831
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Landroid/view/ViewGroup$HoverTarget;->sRecycleLock:Ljava/lang/Object;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .prologue
    .line 5841
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 5842
    return-void
.end method

.method public static obtain(Landroid/view/View;)Landroid/view/ViewGroup$HoverTarget;
    .registers 4
    .parameter "child"

    .prologue
    .line 5846
    sget-object v2, Landroid/view/ViewGroup$HoverTarget;->sRecycleLock:Ljava/lang/Object;

    monitor-enter v2

    .line 5847
    :try_start_3
    sget-object v1, Landroid/view/ViewGroup$HoverTarget;->sRecycleBin:Landroid/view/ViewGroup$HoverTarget;

    if-nez v1, :cond_10

    .line 5848
    new-instance v0, Landroid/view/ViewGroup$HoverTarget;

    invoke-direct {v0}, Landroid/view/ViewGroup$HoverTarget;-><init>()V

    .line 5855
    .local v0, target:Landroid/view/ViewGroup$HoverTarget;
    :goto_c
    monitor-exit v2
    :try_end_d
    .catchall {:try_start_3 .. :try_end_d} :catchall_20

    .line 5856
    iput-object p0, v0, Landroid/view/ViewGroup$HoverTarget;->child:Landroid/view/View;

    .line 5857
    return-object v0

    .line 5850
    .end local v0           #target:Landroid/view/ViewGroup$HoverTarget;
    :cond_10
    :try_start_10
    sget-object v0, Landroid/view/ViewGroup$HoverTarget;->sRecycleBin:Landroid/view/ViewGroup$HoverTarget;

    .line 5851
    .restart local v0       #target:Landroid/view/ViewGroup$HoverTarget;
    iget-object v1, v0, Landroid/view/ViewGroup$HoverTarget;->next:Landroid/view/ViewGroup$HoverTarget;

    sput-object v1, Landroid/view/ViewGroup$HoverTarget;->sRecycleBin:Landroid/view/ViewGroup$HoverTarget;

    .line 5852
    sget v1, Landroid/view/ViewGroup$HoverTarget;->sRecycledCount:I

    add-int/lit8 v1, v1, -0x1

    sput v1, Landroid/view/ViewGroup$HoverTarget;->sRecycledCount:I

    .line 5853
    const/4 v1, 0x0

    iput-object v1, v0, Landroid/view/ViewGroup$HoverTarget;->next:Landroid/view/ViewGroup$HoverTarget;

    goto :goto_c

    .line 5855
    .end local v0           #target:Landroid/view/ViewGroup$HoverTarget;
    :catchall_20
    move-exception v1

    monitor-exit v2
    :try_end_22
    .catchall {:try_start_10 .. :try_end_22} :catchall_20

    throw v1
.end method


# virtual methods
.method public recycle()V
    .registers 4

    .prologue
    .line 5861
    sget-object v1, Landroid/view/ViewGroup$HoverTarget;->sRecycleLock:Ljava/lang/Object;

    monitor-enter v1

    .line 5862
    :try_start_3
    sget v0, Landroid/view/ViewGroup$HoverTarget;->sRecycledCount:I

    const/16 v2, 0x20

    if-ge v0, v2, :cond_1a

    .line 5863
    sget-object v0, Landroid/view/ViewGroup$HoverTarget;->sRecycleBin:Landroid/view/ViewGroup$HoverTarget;

    iput-object v0, p0, Landroid/view/ViewGroup$HoverTarget;->next:Landroid/view/ViewGroup$HoverTarget;

    .line 5864
    sput-object p0, Landroid/view/ViewGroup$HoverTarget;->sRecycleBin:Landroid/view/ViewGroup$HoverTarget;

    .line 5865
    sget v0, Landroid/view/ViewGroup$HoverTarget;->sRecycledCount:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Landroid/view/ViewGroup$HoverTarget;->sRecycledCount:I

    .line 5869
    :goto_15
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/view/ViewGroup$HoverTarget;->child:Landroid/view/View;

    .line 5870
    monitor-exit v1

    .line 5871
    return-void

    .line 5867
    :cond_1a
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/view/ViewGroup$HoverTarget;->next:Landroid/view/ViewGroup$HoverTarget;

    goto :goto_15

    .line 5870
    :catchall_1e
    move-exception v0

    monitor-exit v1
    :try_end_20
    .catchall {:try_start_3 .. :try_end_20} :catchall_1e

    throw v0
.end method
