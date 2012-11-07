.class public Landroid/app/MiuiDownloadManager$Query;
.super Landroid/app/DownloadManager$Query;
.source "MiuiDownloadManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/app/MiuiDownloadManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Query"
.end annotation


# instance fields
.field private mAppendedClause:Ljava/lang/String;

.field private mColumnAppData:Ljava/lang/String;

.field private mColumnNotificationPackage:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 214
    invoke-direct {p0}, Landroid/app/DownloadManager$Query;-><init>()V

    return-void
.end method


# virtual methods
.method addExtraSelectionParts(Ljava/util/List;)V
    .registers 8
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, selectionParts:Ljava/util/List;,"Ljava/util/List<Ljava/lang/String;>;"
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 271
    invoke-super {p0, p1}, Landroid/app/DownloadManager$Query;->addExtraSelectionParts(Ljava/util/List;)V

    .line 272
    iget-object v0, p0, Landroid/app/MiuiDownloadManager$Query;->mColumnAppData:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_21

    .line 273
    const-string v0, "%s=\'%s\'"

    new-array v1, v5, [Ljava/lang/Object;

    const-string v2, "entity"

    aput-object v2, v1, v3

    iget-object v2, p0, Landroid/app/MiuiDownloadManager$Query;->mColumnAppData:Ljava/lang/String;

    aput-object v2, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 275
    :cond_21
    iget-object v0, p0, Landroid/app/MiuiDownloadManager$Query;->mColumnNotificationPackage:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3d

    .line 276
    const-string v0, "%s=\'%s\'"

    new-array v1, v5, [Ljava/lang/Object;

    const-string/jumbo v2, "notificationpackage"

    aput-object v2, v1, v3

    iget-object v2, p0, Landroid/app/MiuiDownloadManager$Query;->mColumnNotificationPackage:Ljava/lang/String;

    aput-object v2, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 279
    :cond_3d
    iget-object v0, p0, Landroid/app/MiuiDownloadManager$Query;->mAppendedClause:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_4a

    .line 280
    iget-object v0, p0, Landroid/app/MiuiDownloadManager$Query;->mAppendedClause:Ljava/lang/String;

    invoke-interface {p1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 282
    :cond_4a
    return-void
.end method

.method public bridge synthetic orderBy(Ljava/lang/String;I)Landroid/app/DownloadManager$Query;
    .registers 4
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 214
    invoke-virtual {p0, p1, p2}, Landroid/app/MiuiDownloadManager$Query;->orderBy(Ljava/lang/String;I)Landroid/app/MiuiDownloadManager$Query;

    move-result-object v0

    return-object v0
.end method

.method public orderBy(Ljava/lang/String;I)Landroid/app/MiuiDownloadManager$Query;
    .registers 6
    .parameter "column"
    .parameter "direction"

    .prologue
    .line 257
    const/4 v0, 0x1

    if-eq p2, v0, :cond_1f

    const/4 v0, 0x2

    if-eq p2, v0, :cond_1f

    .line 258
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid direction: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 260
    :cond_1f
    const-string v0, "_id"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_30

    .line 261
    const-string v0, "_id"

    invoke-virtual {p0, v0}, Landroid/app/MiuiDownloadManager$Query;->setOrderByColumn(Ljava/lang/String;)V

    .line 262
    invoke-virtual {p0, p2}, Landroid/app/MiuiDownloadManager$Query;->setOrderDirection(I)V

    .line 266
    :goto_2f
    return-object p0

    .line 265
    :cond_30
    invoke-super {p0, p1, p2}, Landroid/app/DownloadManager$Query;->orderBy(Ljava/lang/String;I)Landroid/app/DownloadManager$Query;

    goto :goto_2f
.end method

.method public setFilterByAppData(Ljava/lang/String;)Landroid/app/MiuiDownloadManager$Query;
    .registers 2
    .parameter "appData"

    .prologue
    .line 224
    iput-object p1, p0, Landroid/app/MiuiDownloadManager$Query;->mColumnAppData:Ljava/lang/String;

    .line 225
    return-object p0
.end method

.method public setFilterByAppendedClause(Ljava/lang/String;)Landroid/app/MiuiDownloadManager$Query;
    .registers 2
    .parameter "appendedClause"

    .prologue
    .line 243
    iput-object p1, p0, Landroid/app/MiuiDownloadManager$Query;->mAppendedClause:Ljava/lang/String;

    .line 244
    return-object p0
.end method

.method public setFilterByNotificationPackage(Ljava/lang/String;)Landroid/app/MiuiDownloadManager$Query;
    .registers 2
    .parameter "notificationPackage"

    .prologue
    .line 233
    iput-object p1, p0, Landroid/app/MiuiDownloadManager$Query;->mColumnNotificationPackage:Ljava/lang/String;

    .line 234
    return-object p0
.end method
