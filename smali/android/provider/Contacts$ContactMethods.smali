.class public final Landroid/provider/Contacts$ContactMethods;
.super Ljava/lang/Object;
.source "Contacts.java"

# interfaces
.implements Landroid/provider/BaseColumns;
.implements Landroid/provider/Contacts$ContactMethodsColumns;
.implements Landroid/provider/Contacts$PeopleColumns;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/provider/Contacts;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "ContactMethods"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/provider/Contacts$ContactMethods$ProviderNames;
    }
.end annotation

.annotation runtime Ljava/lang/Deprecated;
.end annotation


# static fields
.field public static final CONTENT_EMAIL_ITEM_TYPE:Ljava/lang/String; = "vnd.android.cursor.item/email"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final CONTENT_EMAIL_TYPE:Ljava/lang/String; = "vnd.android.cursor.dir/email"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final CONTENT_EMAIL_URI:Landroid/net/Uri; = null
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final CONTENT_IM_ITEM_TYPE:Ljava/lang/String; = "vnd.android.cursor.item/jabber-im"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final CONTENT_POSTAL_ITEM_TYPE:Ljava/lang/String; = "vnd.android.cursor.item/postal-address"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final CONTENT_POSTAL_TYPE:Ljava/lang/String; = "vnd.android.cursor.dir/postal-address"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final CONTENT_TYPE:Ljava/lang/String; = "vnd.android.cursor.dir/contact-methods"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final CONTENT_URI:Landroid/net/Uri; = null
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final DEFAULT_SORT_ORDER:Ljava/lang/String; = "name ASC"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final PERSON_ID:Ljava/lang/String; = "person"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final POSTAL_LOCATION_LATITUDE:Ljava/lang/String; = "data"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final POSTAL_LOCATION_LONGITUDE:Ljava/lang/String; = "aux_data"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final PROTOCOL_AIM:I = 0x0
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final PROTOCOL_GOOGLE_TALK:I = 0x5
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final PROTOCOL_ICQ:I = 0x6
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final PROTOCOL_JABBER:I = 0x7
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final PROTOCOL_MSN:I = 0x1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final PROTOCOL_QQ:I = 0x4
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final PROTOCOL_SKYPE:I = 0x3
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final PROTOCOL_YAHOO:I = 0x2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 1472
    const-string v0, "content://contacts/contact_methods"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Landroid/provider/Contacts$ContactMethods;->CONTENT_URI:Landroid/net/Uri;

    .line 1480
    const-string v0, "content://contacts/contact_methods/email"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Landroid/provider/Contacts$ContactMethods;->CONTENT_EMAIL_URI:Landroid/net/Uri;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .prologue
    .line 1391
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static decodeImProtocol(Ljava/lang/String;)Ljava/lang/Object;
    .registers 4
    .parameter "encodedString"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1320
    if-nez p0, :cond_4

    .line 1321
    const/4 v0, 0x0

    .line 1329
    :goto_3
    return-object v0

    .line 1324
    :cond_4
    const-string/jumbo v0, "pre:"

    invoke-virtual {p0, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1b

    .line 1325
    const/4 v0, 0x4

    invoke-virtual {p0, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    goto :goto_3

    .line 1328
    :cond_1b
    const-string v0, "custom:"

    invoke-virtual {p0, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_29

    .line 1329
    const/4 v0, 0x7

    invoke-virtual {p0, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_3

    .line 1332
    :cond_29
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "the value is not a valid encoded protocol, "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static encodeCustomImProtocol(Ljava/lang/String;)Ljava/lang/String;
    .registers 3
    .parameter "protocolString"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1312
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "custom:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static encodePredefinedImProtocol(I)Ljava/lang/String;
    .registers 3
    .parameter "protocol"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1304
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "pre:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static final getDisplayLabel(Landroid/content/Context;IILjava/lang/CharSequence;)Ljava/lang/CharSequence;
    .registers 10
    .parameter "context"
    .parameter "kind"
    .parameter "type"
    .parameter "label"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    const/4 v5, 0x0

    .line 1399
    const-string v0, ""

    .line 1400
    .local v0, display:Ljava/lang/CharSequence;
    packed-switch p1, :pswitch_data_4a

    .line 1436
    const v3, 0x104000f

    invoke-virtual {p0, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 1438
    :cond_d
    :goto_d
    return-object v0

    .line 1402
    :pswitch_e
    if-eqz p2, :cond_23

    .line 1403
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const/high16 v4, 0x107

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getTextArray(I)[Ljava/lang/CharSequence;

    move-result-object v2

    .line 1406
    .local v2, labels:[Ljava/lang/CharSequence;
    add-int/lit8 v3, p2, -0x1

    :try_start_1c
    aget-object v0, v2, v3
    :try_end_1e
    .catch Ljava/lang/ArrayIndexOutOfBoundsException; {:try_start_1c .. :try_end_1e} :catch_1f

    goto :goto_d

    .line 1407
    :catch_1f
    move-exception v1

    .line 1408
    .local v1, e:Ljava/lang/ArrayIndexOutOfBoundsException;
    aget-object v0, v2, v5

    goto :goto_d

    .line 1411
    .end local v1           #e:Ljava/lang/ArrayIndexOutOfBoundsException;
    .end local v2           #labels:[Ljava/lang/CharSequence;
    :cond_23
    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_d

    .line 1412
    move-object v0, p3

    goto :goto_d

    .line 1419
    :pswitch_2b
    if-eqz p2, :cond_41

    .line 1420
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x1070004

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getTextArray(I)[Ljava/lang/CharSequence;

    move-result-object v2

    .line 1423
    .restart local v2       #labels:[Ljava/lang/CharSequence;
    add-int/lit8 v3, p2, -0x1

    :try_start_3a
    aget-object v0, v2, v3
    :try_end_3c
    .catch Ljava/lang/ArrayIndexOutOfBoundsException; {:try_start_3a .. :try_end_3c} :catch_3d

    goto :goto_d

    .line 1424
    :catch_3d
    move-exception v1

    .line 1425
    .restart local v1       #e:Ljava/lang/ArrayIndexOutOfBoundsException;
    aget-object v0, v2, v5

    goto :goto_d

    .line 1428
    .end local v1           #e:Ljava/lang/ArrayIndexOutOfBoundsException;
    .end local v2           #labels:[Ljava/lang/CharSequence;
    :cond_41
    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_d

    .line 1429
    move-object v0, p3

    goto :goto_d

    .line 1400
    nop

    :pswitch_data_4a
    .packed-switch 0x1
        :pswitch_e
        :pswitch_2b
    .end packed-switch
.end method

.method public static lookupProviderNameFromId(I)Ljava/lang/String;
    .registers 2
    .parameter "protocol"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1367
    packed-switch p0, :pswitch_data_1e

    .line 1385
    const/4 v0, 0x0

    :goto_4
    return-object v0

    .line 1369
    :pswitch_5
    const-string v0, "GTalk"

    goto :goto_4

    .line 1371
    :pswitch_8
    const-string v0, "AIM"

    goto :goto_4

    .line 1373
    :pswitch_b
    const-string v0, "MSN"

    goto :goto_4

    .line 1375
    :pswitch_e
    const-string v0, "Yahoo"

    goto :goto_4

    .line 1377
    :pswitch_11
    const-string v0, "ICQ"

    goto :goto_4

    .line 1379
    :pswitch_14
    const-string v0, "JABBER"

    goto :goto_4

    .line 1381
    :pswitch_17
    const-string v0, "SKYPE"

    goto :goto_4

    .line 1383
    :pswitch_1a
    const-string v0, "QQ"

    goto :goto_4

    .line 1367
    nop

    :pswitch_data_1e
    .packed-switch 0x0
        :pswitch_8
        :pswitch_b
        :pswitch_e
        :pswitch_17
        :pswitch_1a
        :pswitch_5
        :pswitch_11
        :pswitch_14
    .end packed-switch
.end method


# virtual methods
.method public addPostalLocation(Landroid/content/Context;JDD)V
    .registers 16
    .parameter "context"
    .parameter "postalId"
    .parameter "latitude"
    .parameter "longitude"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    const/4 v7, 0x0

    .line 1453
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    .line 1455
    .local v3, resolver:Landroid/content/ContentResolver;
    new-instance v4, Landroid/content/ContentValues;

    const/4 v5, 0x2

    invoke-direct {v4, v5}, Landroid/content/ContentValues;-><init>(I)V

    .line 1456
    .local v4, values:Landroid/content/ContentValues;
    const-string v5, "data"

    invoke-static {p4, p5}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Double;)V

    .line 1457
    const-string v5, "aux_data"

    invoke-static {p6, p7}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Double;)V

    .line 1458
    sget-object v5, Landroid/provider/Contacts$ContactMethods;->CONTENT_URI:Landroid/net/Uri;

    invoke-virtual {v3, v5, v4}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    move-result-object v0

    .line 1459
    .local v0, loc:Landroid/net/Uri;
    invoke-static {v0}, Landroid/content/ContentUris;->parseId(Landroid/net/Uri;)J

    move-result-wide v1

    .line 1462
    .local v1, locId:J
    invoke-virtual {v4}, Landroid/content/ContentValues;->clear()V

    .line 1463
    const-string v5, "aux_data"

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1464
    sget-object v5, Landroid/provider/Contacts$ContactMethods;->CONTENT_URI:Landroid/net/Uri;

    invoke-static {v5, p2, p3}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v5

    invoke-virtual {v3, v5, v4, v7, v7}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 1465
    return-void
.end method
