.class Landroid/widget/CursorFilter;
.super Landroid/widget/Filter;
.source "CursorFilter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/widget/CursorFilter$CursorFilterClient;
    }
.end annotation


# instance fields
.field mClient:Landroid/widget/CursorFilter$CursorFilterClient;


# direct methods
.method constructor <init>(Landroid/widget/CursorFilter$CursorFilterClient;)V
    .registers 2
    .parameter "client"

    .prologue
    .line 38
    invoke-direct {p0}, Landroid/widget/Filter;-><init>()V

    .line 39
    iput-object p1, p0, Landroid/widget/CursorFilter;->mClient:Landroid/widget/CursorFilter$CursorFilterClient;

    .line 40
    return-void
.end method


# virtual methods
.method public convertResultToString(Ljava/lang/Object;)Ljava/lang/CharSequence;
    .registers 3
    .parameter "resultValue"

    .prologue
    .line 44
    iget-object v0, p0, Landroid/widget/CursorFilter;->mClient:Landroid/widget/CursorFilter$CursorFilterClient;

    check-cast p1, Landroid/database/Cursor;

    .end local p1
    invoke-interface {v0, p1}, Landroid/widget/CursorFilter$CursorFilterClient;->convertToString(Landroid/database/Cursor;)Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method protected performFiltering(Ljava/lang/CharSequence;)Landroid/widget/Filter$FilterResults;
    .registers 5
    .parameter "constraint"

    .prologue
    .line 49
    iget-object v2, p0, Landroid/widget/CursorFilter;->mClient:Landroid/widget/CursorFilter$CursorFilterClient;

    invoke-interface {v2, p1}, Landroid/widget/CursorFilter$CursorFilterClient;->runQueryOnBackgroundThread(Ljava/lang/CharSequence;)Landroid/database/Cursor;

    move-result-object v0

    .line 51
    .local v0, cursor:Landroid/database/Cursor;
    new-instance v1, Landroid/widget/Filter$FilterResults;

    invoke-direct {v1}, Landroid/widget/Filter$FilterResults;-><init>()V

    .line 52
    .local v1, results:Landroid/widget/Filter$FilterResults;
    if-eqz v0, :cond_16

    .line 53
    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v2

    iput v2, v1, Landroid/widget/Filter$FilterResults;->count:I

    .line 54
    iput-object v0, v1, Landroid/widget/Filter$FilterResults;->values:Ljava/lang/Object;

    .line 59
    :goto_15
    return-object v1

    .line 56
    :cond_16
    const/4 v2, 0x0

    iput v2, v1, Landroid/widget/Filter$FilterResults;->count:I

    .line 57
    const/4 v2, 0x0

    iput-object v2, v1, Landroid/widget/Filter$FilterResults;->values:Ljava/lang/Object;

    goto :goto_15
.end method

.method protected publishResults(Ljava/lang/CharSequence;Landroid/widget/Filter$FilterResults;)V
    .registers 6
    .parameter "constraint"
    .parameter "results"

    .prologue
    .line 64
    iget-object v1, p0, Landroid/widget/CursorFilter;->mClient:Landroid/widget/CursorFilter$CursorFilterClient;

    invoke-interface {v1}, Landroid/widget/CursorFilter$CursorFilterClient;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    .line 66
    .local v0, oldCursor:Landroid/database/Cursor;
    iget-object v1, p2, Landroid/widget/Filter$FilterResults;->values:Ljava/lang/Object;

    if-eqz v1, :cond_17

    iget-object v1, p2, Landroid/widget/Filter$FilterResults;->values:Ljava/lang/Object;

    if-eq v1, v0, :cond_17

    .line 67
    iget-object v2, p0, Landroid/widget/CursorFilter;->mClient:Landroid/widget/CursorFilter$CursorFilterClient;

    iget-object v1, p2, Landroid/widget/Filter$FilterResults;->values:Ljava/lang/Object;

    check-cast v1, Landroid/database/Cursor;

    invoke-interface {v2, v1}, Landroid/widget/CursorFilter$CursorFilterClient;->changeCursor(Landroid/database/Cursor;)V

    .line 69
    :cond_17
    return-void
.end method
