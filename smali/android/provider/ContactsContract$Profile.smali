.class public final Landroid/provider/ContactsContract$Profile;
.super Ljava/lang/Object;
.source "ContactsContract.java"

# interfaces
.implements Landroid/provider/BaseColumns;
.implements Landroid/provider/ContactsContract$ContactsColumns;
.implements Landroid/provider/ContactsContract$ContactOptionsColumns;
.implements Landroid/provider/ContactsContract$ContactNameColumns;
.implements Landroid/provider/ContactsContract$ContactStatusColumns;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/provider/ContactsContract;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Profile"
.end annotation


# static fields
.field public static final CONTENT_RAW_CONTACTS_URI:Landroid/net/Uri; = null

.field public static final CONTENT_URI:Landroid/net/Uri; = null

.field public static final CONTENT_VCARD_URI:Landroid/net/Uri; = null

.field public static final MIN_ID:J = 0x7fffffff80000000L


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    .line 2068
    sget-object v0, Landroid/provider/ContactsContract;->AUTHORITY_URI:Landroid/net/Uri;

    const-string/jumbo v1, "profile"

    invoke-static {v0, v1}, Landroid/net/Uri;->withAppendedPath(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Landroid/provider/ContactsContract$Profile;->CONTENT_URI:Landroid/net/Uri;

    .line 2076
    sget-object v0, Landroid/provider/ContactsContract$Profile;->CONTENT_URI:Landroid/net/Uri;

    const-string v1, "as_vcard"

    invoke-static {v0, v1}, Landroid/net/Uri;->withAppendedPath(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Landroid/provider/ContactsContract$Profile;->CONTENT_VCARD_URI:Landroid/net/Uri;

    .line 2086
    sget-object v0, Landroid/provider/ContactsContract$Profile;->CONTENT_URI:Landroid/net/Uri;

    const-string/jumbo v1, "raw_contacts"

    invoke-static {v0, v1}, Landroid/net/Uri;->withAppendedPath(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Landroid/provider/ContactsContract$Profile;->CONTENT_RAW_CONTACTS_URI:Landroid/net/Uri;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .prologue
    .line 2061
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 2062
    return-void
.end method
