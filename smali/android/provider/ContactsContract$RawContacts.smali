.class public final Landroid/provider/ContactsContract$RawContacts;
.super Ljava/lang/Object;
.source "ContactsContract.java"

# interfaces
.implements Landroid/provider/BaseColumns;
.implements Landroid/provider/ContactsContract$RawContactsColumns;
.implements Landroid/provider/ContactsContract$ContactOptionsColumns;
.implements Landroid/provider/ContactsContract$ContactNameColumns;
.implements Landroid/provider/ContactsContract$SyncColumns;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/provider/ContactsContract;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "RawContacts"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/provider/ContactsContract$RawContacts$EntityIteratorImpl;,
        Landroid/provider/ContactsContract$RawContacts$DisplayPhoto;,
        Landroid/provider/ContactsContract$RawContacts$StreamItems;,
        Landroid/provider/ContactsContract$RawContacts$Entity;,
        Landroid/provider/ContactsContract$RawContacts$Data;
    }
.end annotation


# static fields
.field public static final AGGREGATION_MODE_DEFAULT:I = 0x0

.field public static final AGGREGATION_MODE_DISABLED:I = 0x3

.field public static final AGGREGATION_MODE_IMMEDIATE:I = 0x1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final AGGREGATION_MODE_SUSPENDED:I = 0x2

.field public static final CONTENT_ITEM_TYPE:Ljava/lang/String; = "vnd.android.cursor.item/raw_contact"

.field public static final CONTENT_TYPE:Ljava/lang/String; = "vnd.android.cursor.dir/raw_contact"

.field public static final CONTENT_URI:Landroid/net/Uri;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    .line 2591
    sget-object v0, Landroid/provider/ContactsContract;->AUTHORITY_URI:Landroid/net/Uri;

    const-string/jumbo v1, "raw_contacts"

    invoke-static {v0, v1}, Landroid/net/Uri;->withAppendedPath(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Landroid/provider/ContactsContract$RawContacts;->CONTENT_URI:Landroid/net/Uri;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .prologue
    .line 2584
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 2585
    return-void
.end method

.method public static getContactLookupUri(Landroid/content/ContentResolver;Landroid/net/Uri;)Landroid/net/Uri;
    .registers 13
    .parameter "resolver"
    .parameter "rawContactUri"

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    const/4 v3, 0x0

    .line 2661
    const-string v0, "data"

    invoke-static {p1, v0}, Landroid/net/Uri;->withAppendedPath(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 2662
    .local v1, dataUri:Landroid/net/Uri;
    const/4 v0, 0x2

    new-array v2, v0, [Ljava/lang/String;

    const-string v0, "contact_id"

    aput-object v0, v2, v4

    const-string v0, "lookup"

    aput-object v0, v2, v5

    move-object v0, p0

    move-object v4, v3

    move-object v5, v3

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 2666
    .local v8, cursor:Landroid/database/Cursor;
    const/4 v10, 0x0

    .line 2668
    .local v10, lookupUri:Landroid/net/Uri;
    if-eqz v8, :cond_38

    :try_start_1e
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_38

    .line 2669
    const/4 v0, 0x0

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v6

    .line 2670
    .local v6, contactId:J
    const/4 v0, 0x1

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v9

    .line 2671
    .local v9, lookupKey:Ljava/lang/String;
    invoke-static {v6, v7, v9}, Landroid/provider/ContactsContract$Contacts;->getLookupUri(JLjava/lang/String;)Landroid/net/Uri;
    :try_end_31
    .catchall {:try_start_1e .. :try_end_31} :catchall_3e

    move-result-object v10

    .line 2674
    .end local v10           #lookupUri:Landroid/net/Uri;
    if-eqz v8, :cond_37

    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 2676
    .end local v6           #contactId:J
    .end local v9           #lookupKey:Ljava/lang/String;
    :cond_37
    :goto_37
    return-object v10

    .line 2674
    .restart local v10       #lookupUri:Landroid/net/Uri;
    :cond_38
    if-eqz v8, :cond_37

    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    goto :goto_37

    :catchall_3e
    move-exception v0

    if-eqz v8, :cond_44

    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    :cond_44
    throw v0
.end method

.method public static newEntityIterator(Landroid/database/Cursor;)Landroid/content/EntityIterator;
    .registers 2
    .parameter "cursor"

    .prologue
    .line 2823
    new-instance v0, Landroid/provider/ContactsContract$RawContacts$EntityIteratorImpl;

    invoke-direct {v0, p0}, Landroid/provider/ContactsContract$RawContacts$EntityIteratorImpl;-><init>(Landroid/database/Cursor;)V

    return-object v0
.end method
