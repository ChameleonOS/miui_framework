.class public Landroid/app/MiuiDownloadManager$Request;
.super Landroid/app/DownloadManager$Request;
.source "MiuiDownloadManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/app/MiuiDownloadManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Request"
.end annotation


# instance fields
.field private mAppointName:Ljava/lang/String;

.field private mBypassRecommendedSizeLimit:Z

.field private mColumnAppData:Ljava/lang/String;

.field private mNotificationClass:Ljava/lang/String;

.field private mUserAgent:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/net/Uri;)V
    .registers 2
    .parameter "uri"

    .prologue
    .line 149
    invoke-direct {p0, p1}, Landroid/app/DownloadManager$Request;-><init>(Landroid/net/Uri;)V

    .line 150
    return-void
.end method

.method private putIfNonNull(Landroid/content/ContentValues;Ljava/lang/String;Ljava/lang/Object;)V
    .registers 5
    .parameter "contentValues"
    .parameter "key"
    .parameter "value"

    .prologue
    .line 205
    if-eqz p3, :cond_9

    .line 206
    invoke-virtual {p3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, p2, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 208
    :cond_9
    return-void
.end method


# virtual methods
.method public setAppData(Ljava/lang/String;)Landroid/app/MiuiDownloadManager$Request;
    .registers 2
    .parameter "appData"

    .prologue
    .line 165
    iput-object p1, p0, Landroid/app/MiuiDownloadManager$Request;->mColumnAppData:Ljava/lang/String;

    .line 166
    return-object p0
.end method

.method public setAppointName(Ljava/lang/String;)Landroid/app/MiuiDownloadManager$Request;
    .registers 2
    .parameter "appointName"

    .prologue
    .line 157
    iput-object p1, p0, Landroid/app/MiuiDownloadManager$Request;->mAppointName:Ljava/lang/String;

    .line 158
    return-object p0
.end method

.method public setBypassRecommendedSizeLimit(Z)V
    .registers 2
    .parameter "bypass"

    .prologue
    .line 188
    iput-boolean p1, p0, Landroid/app/MiuiDownloadManager$Request;->mBypassRecommendedSizeLimit:Z

    .line 189
    return-void
.end method

.method public setNotificationClass(Ljava/lang/String;)Landroid/app/MiuiDownloadManager$Request;
    .registers 2
    .parameter "notificationClass"

    .prologue
    .line 173
    iput-object p1, p0, Landroid/app/MiuiDownloadManager$Request;->mNotificationClass:Ljava/lang/String;

    .line 174
    return-object p0
.end method

.method public setUserAgent(Ljava/lang/String;)V
    .registers 2
    .parameter "agent"

    .prologue
    .line 181
    iput-object p1, p0, Landroid/app/MiuiDownloadManager$Request;->mUserAgent:Ljava/lang/String;

    .line 182
    return-void
.end method

.method protected toContentValues(Ljava/lang/String;)Landroid/content/ContentValues;
    .registers 5
    .parameter "packageName"

    .prologue
    .line 195
    invoke-super {p0, p1}, Landroid/app/DownloadManager$Request;->toContentValues(Ljava/lang/String;)Landroid/content/ContentValues;

    move-result-object v0

    .line 196
    .local v0, values:Landroid/content/ContentValues;
    const-string v1, "entity"

    iget-object v2, p0, Landroid/app/MiuiDownloadManager$Request;->mColumnAppData:Ljava/lang/String;

    invoke-direct {p0, v0, v1, v2}, Landroid/app/MiuiDownloadManager$Request;->putIfNonNull(Landroid/content/ContentValues;Ljava/lang/String;Ljava/lang/Object;)V

    .line 197
    const-string v1, "appointname"

    iget-object v2, p0, Landroid/app/MiuiDownloadManager$Request;->mAppointName:Ljava/lang/String;

    invoke-direct {p0, v0, v1, v2}, Landroid/app/MiuiDownloadManager$Request;->putIfNonNull(Landroid/content/ContentValues;Ljava/lang/String;Ljava/lang/Object;)V

    .line 198
    const-string/jumbo v1, "notificationclass"

    iget-object v2, p0, Landroid/app/MiuiDownloadManager$Request;->mNotificationClass:Ljava/lang/String;

    invoke-direct {p0, v0, v1, v2}, Landroid/app/MiuiDownloadManager$Request;->putIfNonNull(Landroid/content/ContentValues;Ljava/lang/String;Ljava/lang/Object;)V

    .line 199
    const-string/jumbo v1, "useragent"

    iget-object v2, p0, Landroid/app/MiuiDownloadManager$Request;->mUserAgent:Ljava/lang/String;

    invoke-direct {p0, v0, v1, v2}, Landroid/app/MiuiDownloadManager$Request;->putIfNonNull(Landroid/content/ContentValues;Ljava/lang/String;Ljava/lang/Object;)V

    .line 200
    const-string v1, "bypass_recommended_size_limit"

    iget-boolean v2, p0, Landroid/app/MiuiDownloadManager$Request;->mBypassRecommendedSizeLimit:Z

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 201
    return-object v0
.end method
