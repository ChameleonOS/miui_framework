.class public final Lmiui/provider/ExtraContacts$SmartDialer;
.super Ljava/lang/Object;
.source "ExtraContacts.java"

# interfaces
.implements Landroid/provider/BaseColumns;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/provider/ExtraContacts;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "SmartDialer"
.end annotation


# static fields
.field public static final CALL_COUNT:Ljava/lang/String; = "call_count"

.field public static final CALL_DATE:Ljava/lang/String; = "call_date"

.field public static final CALL_DURATION:Ljava/lang/String; = "call_duration"

.field public static final CALL_TYPE:Ljava/lang/String; = "call_type"

.field public static final CONTACT_ID:Ljava/lang/String; = "contact_id"

.field public static final CONTACT_SP_DIVIDER_ID:I = -0x63

.field public static final CONTENT_REBUILDT9_URI:Landroid/net/Uri; = null

.field public static final CONTENT_URI:Landroid/net/Uri; = null

.field public static final COUNTRY_ISO:Ljava/lang/String; = "country_iso"

.field public static final CREATE_CONTACT_TAG:I = -0x7

.field public static final CREATE_OR_EDIT_CONTACT_TAG:I = -0x6

.field public static final DATA_ID:Ljava/lang/String; = "data_id"

.field public static final EXTRA_CONTACT_SP_DIVIDER_POS:Ljava/lang/String; = "contact_sp_divider_pos_in_t9_cursor"

.field public static final FIREWALL_TYPE:Ljava/lang/String; = "firewall_type"

.field public static final FORWARDED_CALL:Ljava/lang/String; = "forwarded_call"

.field public static final INFORMATION_ONLY_TAG:I = -0x8

.field public static final IS_NEW:Ljava/lang/String; = "is_new"

.field public static final MISSED_COUNT:Ljava/lang/String; = "missed_count"

.field public static final NAME:Ljava/lang/String; = "name"

.field public static final NORMALIZED_NUMBER:Ljava/lang/String; = "normalized_number"

.field public static final NUMBER:Ljava/lang/String; = "number"

.field public static final PHOTO_ID:Ljava/lang/String; = "photo_id"

.field public static final SEND_SMS_TAG:I = -0x9

.field public static final SP_CONTACT_START_ID:I = -0x64

.field public static final VOICEMAIL_URI:Ljava/lang/String; = "voicemail_uri"


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    sget-object v0, Landroid/provider/ContactsContract;->AUTHORITY_URI:Landroid/net/Uri;

    const-string/jumbo v1, "search_t9"

    invoke-static {v0, v1}, Landroid/net/Uri;->withAppendedPath(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lmiui/provider/ExtraContacts$SmartDialer;->CONTENT_URI:Landroid/net/Uri;

    sget-object v0, Landroid/provider/ContactsContract;->AUTHORITY_URI:Landroid/net/Uri;

    const-string/jumbo v1, "rebuild_t9_index"

    invoke-static {v0, v1}, Landroid/net/Uri;->withAppendedPath(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lmiui/provider/ExtraContacts$SmartDialer;->CONTENT_REBUILDT9_URI:Landroid/net/Uri;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
