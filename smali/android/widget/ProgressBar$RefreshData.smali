.class Landroid/widget/ProgressBar$RefreshData;
.super Ljava/lang/Object;
.source "ProgressBar.java"

# interfaces
.implements Landroid/util/Poolable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/ProgressBar;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "RefreshData"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/util/Poolable",
        "<",
        "Landroid/widget/ProgressBar$RefreshData;",
        ">;"
    }
.end annotation


# static fields
.field private static final POOL_MAX:I = 0x18

.field private static final sPool:Landroid/util/Pool;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/Pool",
            "<",
            "Landroid/widget/ProgressBar$RefreshData;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public fromUser:Z

.field public id:I

.field private mIsPooled:Z

.field private mNext:Landroid/widget/ProgressBar$RefreshData;

.field public progress:I


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    .line 593
    new-instance v0, Landroid/widget/ProgressBar$RefreshData$1;

    invoke-direct {v0}, Landroid/widget/ProgressBar$RefreshData$1;-><init>()V

    const/16 v1, 0x18

    invoke-static {v0, v1}, Landroid/util/Pools;->finitePool(Landroid/util/PoolableManager;I)Landroid/util/Pool;

    move-result-object v0

    invoke-static {v0}, Landroid/util/Pools;->synchronizedPool(Landroid/util/Pool;)Landroid/util/Pool;

    move-result-object v0

    sput-object v0, Landroid/widget/ProgressBar$RefreshData;->sPool:Landroid/util/Pool;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .prologue
    .line 584
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/widget/ProgressBar$1;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 584
    invoke-direct {p0}, Landroid/widget/ProgressBar$RefreshData;-><init>()V

    return-void
.end method

.method public static obtain(IIZ)Landroid/widget/ProgressBar$RefreshData;
    .registers 5
    .parameter "id"
    .parameter "progress"
    .parameter "fromUser"

    .prologue
    .line 610
    sget-object v1, Landroid/widget/ProgressBar$RefreshData;->sPool:Landroid/util/Pool;

    invoke-interface {v1}, Landroid/util/Pool;->acquire()Landroid/util/Poolable;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar$RefreshData;

    .line 611
    .local v0, rd:Landroid/widget/ProgressBar$RefreshData;
    iput p0, v0, Landroid/widget/ProgressBar$RefreshData;->id:I

    .line 612
    iput p1, v0, Landroid/widget/ProgressBar$RefreshData;->progress:I

    .line 613
    iput-boolean p2, v0, Landroid/widget/ProgressBar$RefreshData;->fromUser:Z

    .line 614
    return-object v0
.end method


# virtual methods
.method public getNextPoolable()Landroid/widget/ProgressBar$RefreshData;
    .registers 2

    .prologue
    .line 628
    iget-object v0, p0, Landroid/widget/ProgressBar$RefreshData;->mNext:Landroid/widget/ProgressBar$RefreshData;

    return-object v0
.end method

.method public bridge synthetic getNextPoolable()Ljava/lang/Object;
    .registers 2

    .prologue
    .line 584
    invoke-virtual {p0}, Landroid/widget/ProgressBar$RefreshData;->getNextPoolable()Landroid/widget/ProgressBar$RefreshData;

    move-result-object v0

    return-object v0
.end method

.method public isPooled()Z
    .registers 2

    .prologue
    .line 633
    iget-boolean v0, p0, Landroid/widget/ProgressBar$RefreshData;->mIsPooled:Z

    return v0
.end method

.method public recycle()V
    .registers 2

    .prologue
    .line 618
    sget-object v0, Landroid/widget/ProgressBar$RefreshData;->sPool:Landroid/util/Pool;

    invoke-interface {v0, p0}, Landroid/util/Pool;->release(Landroid/util/Poolable;)V

    .line 619
    return-void
.end method

.method public setNextPoolable(Landroid/widget/ProgressBar$RefreshData;)V
    .registers 2
    .parameter "element"

    .prologue
    .line 623
    iput-object p1, p0, Landroid/widget/ProgressBar$RefreshData;->mNext:Landroid/widget/ProgressBar$RefreshData;

    .line 624
    return-void
.end method

.method public bridge synthetic setNextPoolable(Ljava/lang/Object;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 584
    check-cast p1, Landroid/widget/ProgressBar$RefreshData;

    .end local p1
    invoke-virtual {p0, p1}, Landroid/widget/ProgressBar$RefreshData;->setNextPoolable(Landroid/widget/ProgressBar$RefreshData;)V

    return-void
.end method

.method public setPooled(Z)V
    .registers 2
    .parameter "isPooled"

    .prologue
    .line 638
    iput-boolean p1, p0, Landroid/widget/ProgressBar$RefreshData;->mIsPooled:Z

    .line 639
    return-void
.end method
