.class Landroid/content/SyncManager$10;
.super Ljava/lang/Object;
.source "SyncManager.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/content/SyncManager;->dumpRecentHistory(Ljava/io/PrintWriter;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Landroid/content/SyncManager$AuthoritySyncStats;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Landroid/content/SyncManager;


# direct methods
.method constructor <init>(Landroid/content/SyncManager;)V
    .registers 2
    .parameter

    .prologue
    .line 1308
    iput-object p1, p0, Landroid/content/SyncManager$10;->this$0:Landroid/content/SyncManager;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public compare(Landroid/content/SyncManager$AuthoritySyncStats;Landroid/content/SyncManager$AuthoritySyncStats;)I
    .registers 8
    .parameter "lhs"
    .parameter "rhs"

    .prologue
    .line 1312
    iget v1, p2, Landroid/content/SyncManager$AuthoritySyncStats;->times:I

    iget v2, p1, Landroid/content/SyncManager$AuthoritySyncStats;->times:I

    invoke-static {v1, v2}, Ljava/lang/Integer;->compare(II)I

    move-result v0

    .line 1313
    .local v0, compare:I
    if-nez v0, :cond_12

    .line 1314
    iget-wide v1, p2, Landroid/content/SyncManager$AuthoritySyncStats;->elapsedTime:J

    iget-wide v3, p1, Landroid/content/SyncManager$AuthoritySyncStats;->elapsedTime:J

    invoke-static {v1, v2, v3, v4}, Ljava/lang/Long;->compare(JJ)I

    move-result v0

    .line 1316
    :cond_12
    return v0
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .registers 4
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 1308
    check-cast p1, Landroid/content/SyncManager$AuthoritySyncStats;

    .end local p1
    check-cast p2, Landroid/content/SyncManager$AuthoritySyncStats;

    .end local p2
    invoke-virtual {p0, p1, p2}, Landroid/content/SyncManager$10;->compare(Landroid/content/SyncManager$AuthoritySyncStats;Landroid/content/SyncManager$AuthoritySyncStats;)I

    move-result v0

    return v0
.end method
