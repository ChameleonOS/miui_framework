.class public interface abstract Lmiui/provider/ExtraContacts$T9Query;
.super Ljava/lang/Object;
.source "ExtraContacts.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/provider/ExtraContacts;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "T9Query"
.end annotation


# static fields
.field public static final COLUMNS:[Ljava/lang/String; = null

.field public static final CONTACT_ID:I = 0x1

.field public static final COUNT:I = 0x5

.field public static final COUNTRY_ISO:I = 0x10

.field public static final DATA_ID:I = 0x13

.field public static final DATE:I = 0x8

.field public static final DURATION:I = 0x9

.field public static final FIREWALL_TYPE:I = 0xd

.field public static final FORWARDED_CALL:I = 0xe

.field public static final MISSED_COUNT:I = 0xa

.field public static final NAME:I = 0x2

.field public static final NEW:I = 0x6

.field public static final NORMALIZED_NUMBER:I = 0x12

.field public static final NUMBER:I = 0x3

.field public static final PHOTO_ID:I = 0x4

.field public static final T9DISPLAY_STRING:I = 0xf

.field public static final T9KEY_TYPE:I = 0xb

.field public static final T9MATCH_DETAIL:I = 0xc

.field public static final TYPE:I = 0x7

.field public static final VOICEMAIL_URI:I = 0x11

.field public static final _ID:I


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .prologue
    .line 92
    const/16 v0, 0x14

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "_id"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "contact_id"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string/jumbo v2, "name"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string/jumbo v2, "number"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string/jumbo v2, "photo_id"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string v2, "call_count"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "is_new"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "call_type"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "call_date"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "call_duration"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string/jumbo v2, "missed_count"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "key_type"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string/jumbo v2, "match_detail"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string v2, "firewall_type"

    aput-object v2, v0, v1

    const/16 v1, 0xe

    const-string v2, "forwarded_call"

    aput-object v2, v0, v1

    const/16 v1, 0xf

    const-string v2, "display_string"

    aput-object v2, v0, v1

    const/16 v1, 0x10

    const-string v2, "country_iso"

    aput-object v2, v0, v1

    const/16 v1, 0x11

    const-string/jumbo v2, "voicemail_uri"

    aput-object v2, v0, v1

    const/16 v1, 0x12

    const-string/jumbo v2, "normalized_number"

    aput-object v2, v0, v1

    const/16 v1, 0x13

    const-string v2, "data_id"

    aput-object v2, v0, v1

    sput-object v0, Lmiui/provider/ExtraContacts$T9Query;->COLUMNS:[Ljava/lang/String;

    return-void
.end method
