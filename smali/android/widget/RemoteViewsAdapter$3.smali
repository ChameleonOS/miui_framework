.class Landroid/widget/RemoteViewsAdapter$3;
.super Ljava/lang/Object;
.source "RemoteViewsAdapter.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/widget/RemoteViewsAdapter;->updateRemoteViews(IZZ)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/widget/RemoteViewsAdapter;

.field final synthetic val$position:I

.field final synthetic val$rv:Landroid/widget/RemoteViews;

.field final synthetic val$typeId:I


# direct methods
.method constructor <init>(Landroid/widget/RemoteViewsAdapter;ILandroid/widget/RemoteViews;I)V
    .registers 5
    .parameter
    .parameter
    .parameter
    .parameter

    .prologue
    .line 873
    iput-object p1, p0, Landroid/widget/RemoteViewsAdapter$3;->this$0:Landroid/widget/RemoteViewsAdapter;

    iput p2, p0, Landroid/widget/RemoteViewsAdapter$3;->val$position:I

    iput-object p3, p0, Landroid/widget/RemoteViewsAdapter$3;->val$rv:Landroid/widget/RemoteViews;

    iput p4, p0, Landroid/widget/RemoteViewsAdapter$3;->val$typeId:I

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 5

    .prologue
    .line 876
    iget-object v0, p0, Landroid/widget/RemoteViewsAdapter$3;->this$0:Landroid/widget/RemoteViewsAdapter;

    #getter for: Landroid/widget/RemoteViewsAdapter;->mRequestedViews:Landroid/widget/RemoteViewsAdapter$RemoteViewsFrameLayoutRefSet;
    invoke-static {v0}, Landroid/widget/RemoteViewsAdapter;->access$1500(Landroid/widget/RemoteViewsAdapter;)Landroid/widget/RemoteViewsAdapter$RemoteViewsFrameLayoutRefSet;

    move-result-object v0

    iget v1, p0, Landroid/widget/RemoteViewsAdapter$3;->val$position:I

    iget-object v2, p0, Landroid/widget/RemoteViewsAdapter$3;->val$rv:Landroid/widget/RemoteViews;

    iget v3, p0, Landroid/widget/RemoteViewsAdapter$3;->val$typeId:I

    invoke-virtual {v0, v1, v2, v3}, Landroid/widget/RemoteViewsAdapter$RemoteViewsFrameLayoutRefSet;->notifyOnRemoteViewsLoaded(ILandroid/widget/RemoteViews;I)V

    .line 877
    return-void
.end method
