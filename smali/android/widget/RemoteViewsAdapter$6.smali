.class Landroid/widget/RemoteViewsAdapter$6;
.super Ljava/lang/Object;
.source "RemoteViewsAdapter.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/widget/RemoteViewsAdapter;->notifyDataSetChanged()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/widget/RemoteViewsAdapter;


# direct methods
.method constructor <init>(Landroid/widget/RemoteViewsAdapter;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Landroid/widget/RemoteViewsAdapter$6;->this$0:Landroid/widget/RemoteViewsAdapter;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/widget/RemoteViewsAdapter$6;->this$0:Landroid/widget/RemoteViewsAdapter;

    #calls: Landroid/widget/RemoteViewsAdapter;->onNotifyDataSetChanged()V
    invoke-static {v0}, Landroid/widget/RemoteViewsAdapter;->access$100(Landroid/widget/RemoteViewsAdapter;)V

    return-void
.end method
