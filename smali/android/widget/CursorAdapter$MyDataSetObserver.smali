.class Landroid/widget/CursorAdapter$MyDataSetObserver;
.super Landroid/database/DataSetObserver;
.source "CursorAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/CursorAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "MyDataSetObserver"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/widget/CursorAdapter;


# direct methods
.method private constructor <init>(Landroid/widget/CursorAdapter;)V
    .registers 2
    .parameter

    .prologue
    .line 463
    iput-object p1, p0, Landroid/widget/CursorAdapter$MyDataSetObserver;->this$0:Landroid/widget/CursorAdapter;

    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/widget/CursorAdapter;Landroid/widget/CursorAdapter$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 463
    invoke-direct {p0, p1}, Landroid/widget/CursorAdapter$MyDataSetObserver;-><init>(Landroid/widget/CursorAdapter;)V

    return-void
.end method


# virtual methods
.method public onChanged()V
    .registers 3

    .prologue
    .line 466
    iget-object v0, p0, Landroid/widget/CursorAdapter$MyDataSetObserver;->this$0:Landroid/widget/CursorAdapter;

    const/4 v1, 0x1

    iput-boolean v1, v0, Landroid/widget/CursorAdapter;->mDataValid:Z

    .line 467
    iget-object v0, p0, Landroid/widget/CursorAdapter$MyDataSetObserver;->this$0:Landroid/widget/CursorAdapter;

    invoke-virtual {v0}, Landroid/widget/CursorAdapter;->notifyDataSetChanged()V

    .line 468
    return-void
.end method

.method public onInvalidated()V
    .registers 3

    .prologue
    .line 472
    iget-object v0, p0, Landroid/widget/CursorAdapter$MyDataSetObserver;->this$0:Landroid/widget/CursorAdapter;

    const/4 v1, 0x0

    iput-boolean v1, v0, Landroid/widget/CursorAdapter;->mDataValid:Z

    .line 473
    iget-object v0, p0, Landroid/widget/CursorAdapter$MyDataSetObserver;->this$0:Landroid/widget/CursorAdapter;

    invoke-virtual {v0}, Landroid/widget/CursorAdapter;->notifyDataSetInvalidated()V

    .line 474
    return-void
.end method
