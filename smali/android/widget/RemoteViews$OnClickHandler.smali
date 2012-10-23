.class public Landroid/widget/RemoteViews$OnClickHandler;
.super Ljava/lang/Object;
.source "RemoteViews.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/RemoteViews;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "OnClickHandler"
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 157
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClickHandler(Landroid/view/View;Landroid/app/PendingIntent;Landroid/content/Intent;)Z
    .registers 14
    .parameter "view"
    .parameter "pendingIntent"
    .parameter "fillInIntent"

    .prologue
    const/4 v9, 0x0

    .line 162
    :try_start_1
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 163
    .local v0, context:Landroid/content/Context;
    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-virtual {p1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v3

    invoke-virtual {p1}, Landroid/view/View;->getMeasuredHeight()I

    move-result v4

    invoke-static {p1, v1, v2, v3, v4}, Landroid/app/ActivityOptions;->makeScaleUpAnimation(Landroid/view/View;IIII)Landroid/app/ActivityOptions;

    move-result-object v8

    .line 166
    .local v8, opts:Landroid/app/ActivityOptions;
    invoke-virtual {p2}, Landroid/app/PendingIntent;->getIntentSender()Landroid/content/IntentSender;

    move-result-object v1

    const/high16 v3, 0x1000

    const/high16 v4, 0x1000

    const/4 v5, 0x0

    invoke-virtual {v8}, Landroid/app/ActivityOptions;->toBundle()Landroid/os/Bundle;

    move-result-object v6

    move-object v2, p3

    invoke-virtual/range {v0 .. v6}, Landroid/content/Context;->startIntentSender(Landroid/content/IntentSender;Landroid/content/Intent;IIILandroid/os/Bundle;)V
    :try_end_24
    .catch Landroid/content/IntentSender$SendIntentException; {:try_start_1 .. :try_end_24} :catch_26
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_24} :catch_30

    .line 178
    const/4 v1, 0x1

    .end local v0           #context:Landroid/content/Context;
    .end local v8           #opts:Landroid/app/ActivityOptions;
    :goto_25
    return v1

    .line 170
    :catch_26
    move-exception v7

    .line 171
    .local v7, e:Landroid/content/IntentSender$SendIntentException;
    const-string v1, "RemoteViews"

    const-string v2, "Cannot send pending intent: "

    invoke-static {v1, v2, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    move v1, v9

    .line 172
    goto :goto_25

    .line 173
    .end local v7           #e:Landroid/content/IntentSender$SendIntentException;
    :catch_30
    move-exception v7

    .line 174
    .local v7, e:Ljava/lang/Exception;
    const-string v1, "RemoteViews"

    const-string v2, "Cannot send pending intent due to unknown exception: "

    invoke-static {v1, v2, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    move v1, v9

    .line 176
    goto :goto_25
.end method
