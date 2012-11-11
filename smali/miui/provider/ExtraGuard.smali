.class public final Lmiui/provider/ExtraGuard;
.super Ljava/lang/Object;
.source "ExtraGuard.java"


# static fields
.field private static final NATIVE_SCAN_URI:Landroid/net/Uri; = null

.field private static final SMS_BLACK:I = 0x2

.field private static final SMS_CHECK_URI:Landroid/net/Uri; = null

.field private static final SMS_WHITE:I = 0x1

.field private static final VIRUS_BLACK:I = 0x2

.field private static final VIRUS_GRAY:I = 0x3

.field private static final VIRUS_WHITE:I = 0x1


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    const-string v0, "content://com.ijinshan.mguard.provider.MoSecurityProvider/Native_Scan"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lmiui/provider/ExtraGuard;->NATIVE_SCAN_URI:Landroid/net/Uri;

    const-string v0, "content://com.ijinshan.mguard.provider.MoSecurityProvider/SmsCheck"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lmiui/provider/ExtraGuard;->SMS_CHECK_URI:Landroid/net/Uri;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static checkApk(Landroid/content/Context;Landroid/net/Uri;)Z
    .registers 15
    .parameter "context"
    .parameter "uri"

    .prologue
    const/4 v11, 0x1

    const/4 v12, 0x0

    const/4 v2, 0x0

    if-nez p1, :cond_6

    :cond_5
    :goto_5
    return v12

    :cond_6
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .local v0, resolver:Landroid/content/ContentResolver;
    const/4 v8, 0x0

    .local v8, path:Ljava/lang/String;
    invoke-virtual {p1}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v10

    .local v10, scheme:Ljava/lang/String;
    const-string v1, "content"

    invoke-virtual {v1, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_52

    move-object v1, p1

    move-object v3, v2

    move-object v4, v2

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .local v6, cursor:Landroid/database/Cursor;
    if-eqz v6, :cond_34

    invoke-interface {v6}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_31

    const-string v1, "_data"

    invoke-interface {v6, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v7

    .local v7, index:I
    invoke-interface {v6, v7}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v8

    .end local v7           #index:I
    :cond_31
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .end local v6           #cursor:Landroid/database/Cursor;
    :cond_34
    :goto_34
    invoke-static {v8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_5

    :try_start_3a
    sget-object v1, Lmiui/provider/ExtraGuard;->NATIVE_SCAN_URI:Landroid/net/Uri;

    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    const/4 v3, 0x0

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    aput-object v8, v4, v5

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_4b
    .catch Ljava/lang/Exception; {:try_start_3a .. :try_end_4b} :catch_63

    move-result v9

    .local v9, result:I
    const/4 v1, 0x2

    if-eq v9, v1, :cond_61

    move v1, v11

    :goto_50
    move v12, v1

    goto :goto_5

    .end local v9           #result:I
    :cond_52
    if-eqz v10, :cond_5c

    const-string v1, "file"

    invoke-virtual {v1, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_34

    :cond_5c
    invoke-virtual {p1}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v8

    goto :goto_34

    .restart local v9       #result:I
    :cond_61
    move v1, v12

    goto :goto_50

    .end local v9           #result:I
    :catch_63
    move-exception v1

    move v12, v11

    goto :goto_5
.end method

.method public static checkSms(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    .registers 13
    .parameter "context"
    .parameter "address"
    .parameter "body"

    .prologue
    const/4 v9, 0x2

    const/4 v2, 0x1

    const/4 v3, 0x0

    :try_start_3
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .local v0, resolver:Landroid/content/ContentResolver;
    sget-object v4, Lmiui/provider/ExtraGuard;->SMS_CHECK_URI:Landroid/net/Uri;

    new-instance v5, Landroid/content/ContentValues;

    invoke-direct {v5}, Landroid/content/ContentValues;-><init>()V

    const/4 v6, 0x0

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/String;

    const/4 v8, 0x0

    aput-object p1, v7, v8

    const/4 v8, 0x1

    aput-object p2, v7, v8

    invoke-virtual {v0, v4, v5, v6, v7}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1b
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_1b} :catch_21

    move-result v1

    .local v1, result:I
    if-ne v1, v9, :cond_1f

    .end local v0           #resolver:Landroid/content/ContentResolver;
    .end local v1           #result:I
    :goto_1e
    return v2

    .restart local v0       #resolver:Landroid/content/ContentResolver;
    .restart local v1       #result:I
    :cond_1f
    move v2, v3

    goto :goto_1e

    .end local v0           #resolver:Landroid/content/ContentResolver;
    .end local v1           #result:I
    :catch_21
    move-exception v2

    move v2, v3

    goto :goto_1e
.end method
