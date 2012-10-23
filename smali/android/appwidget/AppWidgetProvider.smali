.class public Landroid/appwidget/AppWidgetProvider;
.super Landroid/content/BroadcastReceiver;
.source "AppWidgetProvider.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 46
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 47
    return-void
.end method


# virtual methods
.method public onAppWidgetOptionsChanged(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;ILandroid/os/Bundle;)V
    .registers 5
    .parameter "context"
    .parameter "appWidgetManager"
    .parameter "appWidgetId"
    .parameter "newOptions"

    .prologue
    .line 133
    return-void
.end method

.method public onDeleted(Landroid/content/Context;[I)V
    .registers 3
    .parameter "context"
    .parameter "appWidgetIds"

    .prologue
    .line 149
    return-void
.end method

.method public onDisabled(Landroid/content/Context;)V
    .registers 2
    .parameter "context"

    .prologue
    .line 183
    return-void
.end method

.method public onEnabled(Landroid/content/Context;)V
    .registers 2
    .parameter "context"

    .prologue
    .line 168
    return-void
.end method

.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .registers 10
    .parameter "context"
    .parameter "intent"

    .prologue
    .line 60
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 61
    .local v0, action:Ljava/lang/String;
    const-string v5, "android.appwidget.action.APPWIDGET_UPDATE"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_25

    .line 62
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v3

    .line 63
    .local v3, extras:Landroid/os/Bundle;
    if-eqz v3, :cond_24

    .line 64
    const-string v5, "appWidgetIds"

    invoke-virtual {v3, v5}, Landroid/os/Bundle;->getIntArray(Ljava/lang/String;)[I

    move-result-object v2

    .line 65
    .local v2, appWidgetIds:[I
    if-eqz v2, :cond_24

    array-length v5, v2

    if-lez v5, :cond_24

    .line 66
    invoke-static {p1}, Landroid/appwidget/AppWidgetManager;->getInstance(Landroid/content/Context;)Landroid/appwidget/AppWidgetManager;

    move-result-object v5

    invoke-virtual {p0, p1, v5, v2}, Landroid/appwidget/AppWidgetProvider;->onUpdate(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;[I)V

    .line 93
    .end local v2           #appWidgetIds:[I
    .end local v3           #extras:Landroid/os/Bundle;
    :cond_24
    :goto_24
    return-void

    .line 70
    :cond_25
    const-string v5, "android.appwidget.action.APPWIDGET_DELETED"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_4b

    .line 71
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v3

    .line 72
    .restart local v3       #extras:Landroid/os/Bundle;
    if-eqz v3, :cond_24

    const-string v5, "appWidgetId"

    invoke-virtual {v3, v5}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_24

    .line 73
    const-string v5, "appWidgetId"

    invoke-virtual {v3, v5}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    .line 74
    .local v1, appWidgetId:I
    const/4 v5, 0x1

    new-array v5, v5, [I

    const/4 v6, 0x0

    aput v1, v5, v6

    invoke-virtual {p0, p1, v5}, Landroid/appwidget/AppWidgetProvider;->onDeleted(Landroid/content/Context;[I)V

    goto :goto_24

    .line 77
    .end local v1           #appWidgetId:I
    .end local v3           #extras:Landroid/os/Bundle;
    :cond_4b
    const-string v5, "android.appwidget.action.APPWIDGET_UPDATE_OPTIONS"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_7d

    .line 78
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v3

    .line 79
    .restart local v3       #extras:Landroid/os/Bundle;
    if-eqz v3, :cond_24

    const-string v5, "appWidgetId"

    invoke-virtual {v3, v5}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_24

    const-string v5, "appWidgetOptions"

    invoke-virtual {v3, v5}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_24

    .line 81
    const-string v5, "appWidgetId"

    invoke-virtual {v3, v5}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    .line 82
    .restart local v1       #appWidgetId:I
    const-string v5, "appWidgetOptions"

    invoke-virtual {v3, v5}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v4

    .line 83
    .local v4, widgetExtras:Landroid/os/Bundle;
    invoke-static {p1}, Landroid/appwidget/AppWidgetManager;->getInstance(Landroid/content/Context;)Landroid/appwidget/AppWidgetManager;

    move-result-object v5

    invoke-virtual {p0, p1, v5, v1, v4}, Landroid/appwidget/AppWidgetProvider;->onAppWidgetOptionsChanged(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;ILandroid/os/Bundle;)V

    goto :goto_24

    .line 87
    .end local v1           #appWidgetId:I
    .end local v3           #extras:Landroid/os/Bundle;
    .end local v4           #widgetExtras:Landroid/os/Bundle;
    :cond_7d
    const-string v5, "android.appwidget.action.APPWIDGET_ENABLED"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_89

    .line 88
    invoke-virtual {p0, p1}, Landroid/appwidget/AppWidgetProvider;->onEnabled(Landroid/content/Context;)V

    goto :goto_24

    .line 90
    :cond_89
    const-string v5, "android.appwidget.action.APPWIDGET_DISABLED"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_24

    .line 91
    invoke-virtual {p0, p1}, Landroid/appwidget/AppWidgetProvider;->onDisabled(Landroid/content/Context;)V

    goto :goto_24
.end method

.method public onUpdate(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;[I)V
    .registers 4
    .parameter "context"
    .parameter "appWidgetManager"
    .parameter "appWidgetIds"

    .prologue
    .line 114
    return-void
.end method
