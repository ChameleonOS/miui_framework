.class Lcom/android/internal/database/SortCursor$1;
.super Landroid/database/DataSetObserver;
.source "SortCursor.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/database/SortCursor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/internal/database/SortCursor;


# direct methods
.method constructor <init>(Lcom/android/internal/database/SortCursor;)V
    .registers 2
    .parameter

    .prologue
    .line 40
    iput-object p1, p0, Lcom/android/internal/database/SortCursor$1;->this$0:Lcom/android/internal/database/SortCursor;

    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    return-void
.end method


# virtual methods
.method public onChanged()V
    .registers 3

    .prologue
    .line 46
    iget-object v0, p0, Lcom/android/internal/database/SortCursor$1;->this$0:Lcom/android/internal/database/SortCursor;

    const/4 v1, -0x1

    #setter for: Landroid/database/AbstractCursor;->mPos:I
    invoke-static {v0, v1}, Lcom/android/internal/database/SortCursor;->access$002(Lcom/android/internal/database/SortCursor;I)I

    .line 47
    return-void
.end method

.method public onInvalidated()V
    .registers 3

    .prologue
    .line 51
    iget-object v0, p0, Lcom/android/internal/database/SortCursor$1;->this$0:Lcom/android/internal/database/SortCursor;

    const/4 v1, -0x1

    #setter for: Landroid/database/AbstractCursor;->mPos:I
    invoke-static {v0, v1}, Lcom/android/internal/database/SortCursor;->access$102(Lcom/android/internal/database/SortCursor;I)I

    .line 52
    return-void
.end method
