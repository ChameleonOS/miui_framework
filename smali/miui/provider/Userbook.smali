.class public Lmiui/provider/Userbook;
.super Ljava/lang/Object;
.source "Userbook.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmiui/provider/Userbook$Columns;
    }
.end annotation


# static fields
.field public static final AUTHORITY:Ljava/lang/String; = "userbook"

.field public static final CONTENT_URI:Landroid/net/Uri; = null

.field private static final SELECTION:Ljava/lang/String; = "package=? AND feature=?"


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 21
    const-string v0, "content://userbook/feature"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lmiui/provider/Userbook;->CONTENT_URI:Landroid/net/Uri;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 15
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 25
    return-void
.end method

.method public static delete(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)I
    .registers 7
    .parameter "cr"
    .parameter "packageName"
    .parameter "featureKey"

    .prologue
    .line 145
    sget-object v0, Lmiui/provider/Userbook;->CONTENT_URI:Landroid/net/Uri;

    const-string/jumbo v1, "package=? AND feature=?"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    const/4 v3, 0x1

    aput-object p2, v2, v3

    invoke-virtual {p0, v0, v1, v2}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public static getAchieved(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;Z)Z
    .registers 5
    .parameter "cr"
    .parameter "packageName"
    .parameter "featureKey"
    .parameter "defValue"

    .prologue
    .line 134
    const-string v0, "achieved"

    invoke-static {p0, p1, p2, p3, v0}, Lmiui/provider/Userbook;->getState(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static getPackageAchievedFeatures(Landroid/content/ContentResolver;Ljava/lang/String;Z)Ljava/util/List;
    .registers 7
    .parameter "cr"
    .parameter "packageName"
    .parameter "achieved"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/ContentResolver;",
            "Ljava/lang/String;",
            "Z)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    .line 170
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "achieved="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    if-ne p2, v1, :cond_1b

    :goto_e
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 171
    .local v0, selection:Ljava/lang/String;
    invoke-static {p0, p1, v0}, Lmiui/provider/Userbook;->getPackageFeatures(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    return-object v1

    .line 170
    .end local v0           #selection:Ljava/lang/String;
    :cond_1b
    const/4 v1, 0x0

    goto :goto_e
.end method

.method private static getPackageFeatures(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    .registers 12
    .parameter "cr"
    .parameter "packageName"
    .parameter "selection"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/ContentResolver;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    const/4 v8, 0x0

    .line 176
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " AND package=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    .line 177
    sget-object v1, Lmiui/provider/Userbook;->CONTENT_URI:Landroid/net/Uri;

    const/4 v0, 0x1

    new-array v2, v0, [Ljava/lang/String;

    const-string v0, "feature"

    aput-object v0, v2, v8

    move-object v0, p0

    move-object v3, p2

    move-object v5, v4

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 179
    .local v6, c:Landroid/database/Cursor;
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 180
    .local v7, list:Ljava/util/List;,"Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v6, :cond_4c

    .line 181
    invoke-interface {v6}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_49

    .line 183
    :cond_3c
    invoke-interface {v6, v8}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-interface {v7, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 184
    invoke-interface {v6}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-nez v0, :cond_3c

    .line 186
    :cond_49
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 188
    :cond_4c
    return-object v7
.end method

.method public static getPackageReadFeatures(Landroid/content/ContentResolver;Ljava/lang/String;Z)Ljava/util/List;
    .registers 7
    .parameter "cr"
    .parameter "packageName"
    .parameter "read"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/ContentResolver;",
            "Ljava/lang/String;",
            "Z)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    .line 157
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "read="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    if-ne p2, v1, :cond_1c

    :goto_f
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 158
    .local v0, selection:Ljava/lang/String;
    invoke-static {p0, p1, v0}, Lmiui/provider/Userbook;->getPackageFeatures(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    return-object v1

    .line 157
    .end local v0           #selection:Ljava/lang/String;
    :cond_1c
    const/4 v1, 0x0

    goto :goto_f
.end method

.method public static getRead(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;Z)Z
    .registers 5
    .parameter "cr"
    .parameter "packageName"
    .parameter "featureKey"
    .parameter "defValue"

    .prologue
    .line 121
    const-string/jumbo v0, "read"

    invoke-static {p0, p1, p2, p3, v0}, Lmiui/provider/Userbook;->getState(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Z

    move-result v0

    return v0
.end method

.method private static getState(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Z
    .registers 15
    .parameter "cr"
    .parameter "packageName"
    .parameter "featureKey"
    .parameter "defValue"
    .parameter "projection"

    .prologue
    const/4 v8, 0x1

    const/4 v9, 0x0

    .line 193
    move v7, p3

    .line 194
    .local v7, state:Z
    sget-object v1, Lmiui/provider/Userbook;->CONTENT_URI:Landroid/net/Uri;

    new-array v2, v8, [Ljava/lang/String;

    aput-object p4, v2, v9

    const-string/jumbo v3, "package=? AND feature=?"

    const/4 v0, 0x2

    new-array v4, v0, [Ljava/lang/String;

    aput-object p1, v4, v9

    aput-object p2, v4, v8

    const/4 v5, 0x0

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 197
    .local v6, c:Landroid/database/Cursor;
    if-eqz v6, :cond_2b

    .line 198
    invoke-interface {v6}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_28

    .line 199
    invoke-interface {v6, v9}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    if-lez v0, :cond_2c

    move v7, v8

    .line 201
    :cond_28
    :goto_28
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 204
    :cond_2b
    return v7

    :cond_2c
    move v7, v9

    .line 199
    goto :goto_28
.end method

.method private static insertOrUpdate(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    .registers 14
    .parameter "cr"
    .parameter "packageName"
    .parameter "featureKey"
    .parameter "achieved"
    .parameter "projection"

    .prologue
    .line 209
    sget-object v1, Lmiui/provider/Userbook;->CONTENT_URI:Landroid/net/Uri;

    const/4 v0, 0x1

    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    aput-object p4, v2, v0

    const-string/jumbo v3, "package=? AND feature=?"

    const/4 v0, 0x2

    new-array v4, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    aput-object p1, v4, v0

    const/4 v0, 0x1

    aput-object p2, v4, v0

    const/4 v5, 0x0

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 214
    .local v6, c:Landroid/database/Cursor;
    const/4 v7, 0x0

    .line 215
    .local v7, exist:Z
    if-eqz v6, :cond_24

    .line 216
    invoke-interface {v6}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v7

    .line 217
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 220
    :cond_24
    new-instance v8, Landroid/content/ContentValues;

    invoke-direct {v8}, Landroid/content/ContentValues;-><init>()V

    .line 221
    .local v8, values:Landroid/content/ContentValues;
    const/4 v0, 0x1

    if-ne p3, v0, :cond_48

    const/4 v0, 0x1

    :goto_2d
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v8, p4, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 222
    if-eqz v7, :cond_4a

    .line 223
    sget-object v0, Lmiui/provider/Userbook;->CONTENT_URI:Landroid/net/Uri;

    const-string/jumbo v1, "package=? AND feature=?"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    const/4 v3, 0x1

    aput-object p2, v2, v3

    invoke-virtual {p0, v0, v8, v1, v2}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 229
    :goto_47
    return-void

    .line 221
    :cond_48
    const/4 v0, 0x0

    goto :goto_2d

    .line 225
    :cond_4a
    const-string/jumbo v0, "package"

    invoke-virtual {v8, v0, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 226
    const-string v0, "feature"

    invoke-virtual {v8, v0, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 227
    sget-object v0, Lmiui/provider/Userbook;->CONTENT_URI:Landroid/net/Uri;

    invoke-virtual {p0, v0, v8}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    goto :goto_47
.end method

.method public static setAchieved(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;Z)V
    .registers 5
    .parameter "cr"
    .parameter "packageName"
    .parameter "featureKey"
    .parameter "achieved"

    .prologue
    .line 108
    const-string v0, "achieved"

    invoke-static {p0, p1, p2, p3, v0}, Lmiui/provider/Userbook;->insertOrUpdate(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V

    .line 109
    return-void
.end method

.method public static setRead(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;Z)V
    .registers 5
    .parameter "cr"
    .parameter "packageName"
    .parameter "featureKey"
    .parameter "read"

    .prologue
    .line 93
    const-string/jumbo v0, "read"

    invoke-static {p0, p1, p2, p3, v0}, Lmiui/provider/Userbook;->insertOrUpdate(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V

    .line 94
    return-void
.end method
