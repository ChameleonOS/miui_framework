.class Landroid/appwidget/AppWidgetHost$Callbacks;
.super Lcom/android/internal/appwidget/IAppWidgetHost$Stub;
.source "AppWidgetHost.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/appwidget/AppWidgetHost;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "Callbacks"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/appwidget/AppWidgetHost;


# direct methods
.method constructor <init>(Landroid/appwidget/AppWidgetHost;)V
    .registers 2
    .parameter

    .prologue
    .line 53
    iput-object p1, p0, Landroid/appwidget/AppWidgetHost$Callbacks;->this$0:Landroid/appwidget/AppWidgetHost;

    invoke-direct {p0}, Lcom/android/internal/appwidget/IAppWidgetHost$Stub;-><init>()V

    return-void
.end method


# virtual methods
.method public providerChanged(ILandroid/appwidget/AppWidgetProviderInfo;)V
    .registers 6
    .parameter "appWidgetId"
    .parameter "info"

    .prologue
    .line 62
    iget-object v1, p0, Landroid/appwidget/AppWidgetHost$Callbacks;->this$0:Landroid/appwidget/AppWidgetHost;

    iget-object v1, v1, Landroid/appwidget/AppWidgetHost;->mHandler:Landroid/os/Handler;

    const/4 v2, 0x2

    invoke-virtual {v1, v2}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    .line 63
    .local v0, msg:Landroid/os/Message;
    iput p1, v0, Landroid/os/Message;->arg1:I

    .line 64
    iput-object p2, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 65
    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    .line 66
    return-void
.end method

.method public updateAppWidget(ILandroid/widget/RemoteViews;)V
    .registers 6
    .parameter "appWidgetId"
    .parameter "views"

    .prologue
    .line 55
    iget-object v1, p0, Landroid/appwidget/AppWidgetHost$Callbacks;->this$0:Landroid/appwidget/AppWidgetHost;

    iget-object v1, v1, Landroid/appwidget/AppWidgetHost;->mHandler:Landroid/os/Handler;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    .line 56
    .local v0, msg:Landroid/os/Message;
    iput p1, v0, Landroid/os/Message;->arg1:I

    .line 57
    iput-object p2, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 58
    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    .line 59
    return-void
.end method

.method public viewDataChanged(II)V
    .registers 6
    .parameter "appWidgetId"
    .parameter "viewId"

    .prologue
    .line 69
    iget-object v1, p0, Landroid/appwidget/AppWidgetHost$Callbacks;->this$0:Landroid/appwidget/AppWidgetHost;

    iget-object v1, v1, Landroid/appwidget/AppWidgetHost;->mHandler:Landroid/os/Handler;

    const/4 v2, 0x3

    invoke-virtual {v1, v2}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    .line 70
    .local v0, msg:Landroid/os/Message;
    iput p1, v0, Landroid/os/Message;->arg1:I

    .line 71
    iput p2, v0, Landroid/os/Message;->arg2:I

    .line 72
    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    .line 73
    return-void
.end method
