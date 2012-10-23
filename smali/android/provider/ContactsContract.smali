.class public final Landroid/provider/ContactsContract;
.super Ljava/lang/Object;
.source "ContactsContract.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/provider/ContactsContract$1;,
        Landroid/provider/ContactsContract$Intents;,
        Landroid/provider/ContactsContract$DisplayPhoto;,
        Landroid/provider/ContactsContract$QuickContact;,
        Landroid/provider/ContactsContract$DataUsageFeedback;,
        Landroid/provider/ContactsContract$ProviderStatus;,
        Landroid/provider/ContactsContract$Settings;,
        Landroid/provider/ContactsContract$SettingsColumns;,
        Landroid/provider/ContactsContract$AggregationExceptions;,
        Landroid/provider/ContactsContract$Groups;,
        Landroid/provider/ContactsContract$GroupsColumns;,
        Landroid/provider/ContactsContract$CommonDataKinds;,
        Landroid/provider/ContactsContract$SearchSnippetColumns;,
        Landroid/provider/ContactsContract$Presence;,
        Landroid/provider/ContactsContract$StatusUpdates;,
        Landroid/provider/ContactsContract$PresenceColumns;,
        Landroid/provider/ContactsContract$PhoneLookup;,
        Landroid/provider/ContactsContract$PhoneLookupColumns;,
        Landroid/provider/ContactsContract$RawContactsEntity;,
        Landroid/provider/ContactsContract$Data;,
        Landroid/provider/ContactsContract$DataColumnsWithJoins;,
        Landroid/provider/ContactsContract$DataColumns;,
        Landroid/provider/ContactsContract$PhotoFilesColumns;,
        Landroid/provider/ContactsContract$PhotoFiles;,
        Landroid/provider/ContactsContract$StreamItemPhotosColumns;,
        Landroid/provider/ContactsContract$StreamItemPhotos;,
        Landroid/provider/ContactsContract$StreamItemsColumns;,
        Landroid/provider/ContactsContract$StreamItems;,
        Landroid/provider/ContactsContract$StatusColumns;,
        Landroid/provider/ContactsContract$RawContacts;,
        Landroid/provider/ContactsContract$RawContactsColumns;,
        Landroid/provider/ContactsContract$Profile;,
        Landroid/provider/ContactsContract$Contacts;,
        Landroid/provider/ContactsContract$ContactCounts;,
        Landroid/provider/ContactsContract$ContactNameColumns;,
        Landroid/provider/ContactsContract$DisplayNameSources;,
        Landroid/provider/ContactsContract$PhoneticNameStyle;,
        Landroid/provider/ContactsContract$FullNameStyle;,
        Landroid/provider/ContactsContract$ContactStatusColumns;,
        Landroid/provider/ContactsContract$ContactsColumns;,
        Landroid/provider/ContactsContract$ContactOptionsColumns;,
        Landroid/provider/ContactsContract$SyncColumns;,
        Landroid/provider/ContactsContract$BaseSyncColumns;,
        Landroid/provider/ContactsContract$ProfileSyncState;,
        Landroid/provider/ContactsContract$SyncState;,
        Landroid/provider/ContactsContract$SyncStateColumns;,
        Landroid/provider/ContactsContract$Directory;,
        Landroid/provider/ContactsContract$Preferences;,
        Landroid/provider/ContactsContract$Authorization;
    }
.end annotation


# static fields
.field public static final AUTHORITY:Ljava/lang/String; = "com.android.contacts"

.field public static final AUTHORITY_URI:Landroid/net/Uri; = null

.field public static final CALLER_IS_SYNCADAPTER:Ljava/lang/String; = "caller_is_syncadapter"

.field public static final DEFERRED_SNIPPETING:Ljava/lang/String; = "deferred_snippeting"

.field public static final DEFERRED_SNIPPETING_QUERY:Ljava/lang/String; = "deferred_snippeting_query"

.field public static final DIRECTORY_PARAM_KEY:Ljava/lang/String; = "directory"

.field public static final LIMIT_PARAM_KEY:Ljava/lang/String; = "limit"

.field public static final PRIMARY_ACCOUNT_NAME:Ljava/lang/String; = "name_for_primary_account"

.field public static final PRIMARY_ACCOUNT_TYPE:Ljava/lang/String; = "type_for_primary_account"

.field public static final REMOVE_DUPLICATE_ENTRIES:Ljava/lang/String; = "remove_duplicate_entries"

.field private static SPLIT_PATTERN:Ljava/util/regex/Pattern; = null

.field public static final STREQUENT_PHONE_ONLY:Ljava/lang/String; = "strequent_phone_only"


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 117
    const-string v0, "content://com.android.contacts"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Landroid/provider/ContactsContract;->AUTHORITY_URI:Landroid/net/Uri;

    .line 8430
    const-string v0, "([\\w-\\.]+)@((?:[\\w]+\\.)+)([a-zA-Z]{2,4})|[\\w]+"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Landroid/provider/ContactsContract;->SPLIT_PATTERN:Ljava/util/regex/Pattern;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 113
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 7816
    return-void
.end method

.method public static isProfileId(J)Z
    .registers 4
    .parameter "id"

    .prologue
    .line 2112
    const-wide v0, 0x7fffffff80000000L

    cmp-long v0, p0, v0

    if-ltz v0, :cond_b

    const/4 v0, 0x1

    :goto_a
    return v0

    :cond_b
    const/4 v0, 0x0

    goto :goto_a
.end method

.method public static snippetize(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;CCLjava/lang/String;I)Ljava/lang/String;
    .registers 36
    .parameter "content"
    .parameter "displayName"
    .parameter "query"
    .parameter "snippetStartMatch"
    .parameter "snippetEndMatch"
    .parameter "snippetEllipsis"
    .parameter "snippetMaxTokens"

    .prologue
    .line 8338
    if-eqz p2, :cond_27

    invoke-virtual/range {p2 .. p2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v13

    .line 8339
    .local v13, lowerQuery:Ljava/lang/String;
    :goto_6
    invoke-static/range {p0 .. p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v24

    if-nez v24, :cond_24

    invoke-static/range {p2 .. p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v24

    if-nez v24, :cond_24

    invoke-static/range {p1 .. p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v24

    if-nez v24, :cond_24

    invoke-virtual/range {p0 .. p0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v24

    move-object/from16 v0, v24

    invoke-virtual {v0, v13}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v24

    if-nez v24, :cond_29

    .line 8341
    :cond_24
    const/16 v24, 0x0

    .line 8421
    :goto_26
    return-object v24

    .line 8338
    .end local v13           #lowerQuery:Ljava/lang/String;
    :cond_27
    const/4 v13, 0x0

    goto :goto_6

    .line 8346
    .restart local v13       #lowerQuery:Ljava/lang/String;
    :cond_29
    if-eqz p1, :cond_61

    invoke-virtual/range {p1 .. p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v12

    .line 8347
    .local v12, lowerDisplayName:Ljava/lang/String;
    :goto_2f
    new-instance v19, Ljava/util/ArrayList;

    invoke-direct/range {v19 .. v19}, Ljava/util/ArrayList;-><init>()V

    .line 8348
    .local v19, nameTokens:Ljava/util/List;,"Ljava/util/List<Ljava/lang/String;>;"
    new-instance v18, Ljava/util/ArrayList;

    invoke-direct/range {v18 .. v18}, Ljava/util/ArrayList;-><init>()V

    .line 8349
    .local v18, nameTokenOffsets:Ljava/util/List;,"Ljava/util/List<Ljava/lang/Integer;>;"
    invoke-virtual {v12}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v24

    move-object/from16 v0, v24

    move-object/from16 v1, v19

    move-object/from16 v2, v18

    invoke-static {v0, v1, v2}, Landroid/provider/ContactsContract;->split(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V

    .line 8350
    invoke-interface/range {v19 .. v19}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .local v8, i$:Ljava/util/Iterator;
    :cond_4a
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v24

    if-eqz v24, :cond_64

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Ljava/lang/String;

    .line 8351
    .local v17, nameToken:Ljava/lang/String;
    move-object/from16 v0, v17

    invoke-virtual {v0, v13}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v24

    if-eqz v24, :cond_4a

    .line 8352
    const/16 v24, 0x0

    goto :goto_26

    .line 8346
    .end local v8           #i$:Ljava/util/Iterator;
    .end local v12           #lowerDisplayName:Ljava/lang/String;
    .end local v17           #nameToken:Ljava/lang/String;
    .end local v18           #nameTokenOffsets:Ljava/util/List;,"Ljava/util/List<Ljava/lang/Integer;>;"
    .end local v19           #nameTokens:Ljava/util/List;,"Ljava/util/List<Ljava/lang/String;>;"
    :cond_61
    const-string v12, ""

    goto :goto_2f

    .line 8356
    .restart local v8       #i$:Ljava/util/Iterator;
    .restart local v12       #lowerDisplayName:Ljava/lang/String;
    .restart local v18       #nameTokenOffsets:Ljava/util/List;,"Ljava/util/List<Ljava/lang/Integer;>;"
    .restart local v19       #nameTokens:Ljava/util/List;,"Ljava/util/List<Ljava/lang/String;>;"
    :cond_64
    const-string v24, "\n"

    move-object/from16 v0, p0

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    .line 8359
    .local v5, contentLines:[Ljava/lang/String;
    move-object v3, v5

    .local v3, arr$:[Ljava/lang/String;
    array-length v10, v3

    .local v10, len$:I
    const/4 v8, 0x0

    .local v8, i$:I
    :goto_71
    if-ge v8, v10, :cond_194

    aget-object v4, v3, v8

    .line 8360
    .local v4, contentLine:Ljava/lang/String;
    invoke-virtual {v4}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v24

    move-object/from16 v0, v24

    invoke-virtual {v0, v13}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v24

    if-eqz v24, :cond_190

    .line 8363
    new-instance v11, Ljava/util/ArrayList;

    invoke-direct {v11}, Ljava/util/ArrayList;-><init>()V

    .line 8364
    .local v11, lineTokens:Ljava/util/List;,"Ljava/util/List<Ljava/lang/String;>;"
    new-instance v23, Ljava/util/ArrayList;

    invoke-direct/range {v23 .. v23}, Ljava/util/ArrayList;-><init>()V

    .line 8365
    .local v23, tokenOffsets:Ljava/util/List;,"Ljava/util/List<Ljava/lang/Integer;>;"
    invoke-virtual {v4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v24

    move-object/from16 v0, v24

    move-object/from16 v1, v23

    invoke-static {v0, v11, v1}, Landroid/provider/ContactsContract;->split(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V

    .line 8369
    new-instance v16, Ljava/util/ArrayList;

    invoke-direct/range {v16 .. v16}, Ljava/util/ArrayList;-><init>()V

    .line 8371
    .local v16, markedTokens:Ljava/util/List;,"Ljava/util/List<Ljava/lang/String;>;"
    const/4 v6, -0x1

    .line 8372
    .local v6, firstToken:I
    const/4 v9, -0x1

    .line 8373
    .local v9, lastToken:I
    const/4 v7, 0x0

    .local v7, i:I
    :goto_9e
    invoke-interface {v11}, Ljava/util/List;->size()I

    move-result v24

    move/from16 v0, v24

    if-ge v7, v0, :cond_11b

    .line 8374
    invoke-interface {v11, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v22

    check-cast v22, Ljava/lang/String;

    .line 8375
    .local v22, token:Ljava/lang/String;
    invoke-virtual/range {v22 .. v22}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v14

    .line 8376
    .local v14, lowerToken:Ljava/lang/String;
    invoke-virtual {v14, v13}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v24

    if-eqz v24, :cond_113

    .line 8379
    new-instance v24, Ljava/lang/StringBuilder;

    invoke-direct/range {v24 .. v24}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v24

    move/from16 v1, p3

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v24

    move-object/from16 v0, v24

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    move-object/from16 v0, v24

    move/from16 v1, p4

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v24

    move-object/from16 v0, v16

    move-object/from16 v1, v24

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 8383
    const/16 v24, -0x1

    move/from16 v0, v24

    if-ne v6, v0, :cond_110

    .line 8384
    const/16 v24, 0x0

    invoke-static/range {p6 .. p6}, Ljava/lang/Math;->abs(I)I

    move-result v25

    move/from16 v0, v25

    int-to-double v0, v0

    move-wide/from16 v25, v0

    const-wide/high16 v27, 0x4000

    div-double v25, v25, v27

    invoke-static/range {v25 .. v26}, Ljava/lang/Math;->floor(D)D

    move-result-wide v25

    move-wide/from16 v0, v25

    double-to-int v0, v0

    move/from16 v25, v0

    sub-int v25, v7, v25

    invoke-static/range {v24 .. v25}, Ljava/lang/Math;->max(II)I

    move-result v6

    .line 8388
    invoke-interface {v11}, Ljava/util/List;->size()I

    move-result v24

    invoke-static/range {p6 .. p6}, Ljava/lang/Math;->abs(I)I

    move-result v25

    add-int v25, v25, v6

    invoke-static/range {v24 .. v25}, Ljava/lang/Math;->min(II)I

    move-result v9

    .line 8373
    :cond_110
    :goto_110
    add-int/lit8 v7, v7, 0x1

    goto :goto_9e

    .line 8393
    :cond_113
    move-object/from16 v0, v16

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_110

    .line 8398
    .end local v14           #lowerToken:Ljava/lang/String;
    .end local v22           #token:Ljava/lang/String;
    :cond_11b
    const/16 v24, -0x1

    move/from16 v0, v24

    if-le v6, v0, :cond_190

    .line 8399
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    .line 8400
    .local v21, sb:Ljava/lang/StringBuilder;
    if-lez v6, :cond_12f

    .line 8401
    move-object/from16 v0, v21

    move-object/from16 v1, p5

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 8403
    :cond_12f
    move v7, v6

    :goto_130
    if-ge v7, v9, :cond_17b

    .line 8404
    move-object/from16 v0, v16

    invoke-interface {v0, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Ljava/lang/String;

    .line 8405
    .local v15, markedToken:Ljava/lang/String;
    invoke-interface {v11, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Ljava/lang/String;

    .line 8406
    .local v20, originalToken:Ljava/lang/String;
    move-object/from16 v0, v21

    invoke-virtual {v0, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 8407
    add-int/lit8 v24, v9, -0x1

    move/from16 v0, v24

    if-ge v7, v0, :cond_178

    .line 8409
    move-object/from16 v0, v23

    invoke-interface {v0, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v24

    check-cast v24, Ljava/lang/Integer;

    invoke-virtual/range {v24 .. v24}, Ljava/lang/Integer;->intValue()I

    move-result v24

    invoke-virtual/range {v20 .. v20}, Ljava/lang/String;->length()I

    move-result v25

    add-int v25, v25, v24

    add-int/lit8 v24, v7, 0x1

    invoke-interface/range {v23 .. v24}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v24

    check-cast v24, Ljava/lang/Integer;

    invoke-virtual/range {v24 .. v24}, Ljava/lang/Integer;->intValue()I

    move-result v24

    move/from16 v0, v25

    move/from16 v1, v24

    invoke-virtual {v4, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v24

    move-object/from16 v0, v21

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 8403
    :cond_178
    add-int/lit8 v7, v7, 0x1

    goto :goto_130

    .line 8414
    .end local v15           #markedToken:Ljava/lang/String;
    .end local v20           #originalToken:Ljava/lang/String;
    :cond_17b
    invoke-interface {v11}, Ljava/util/List;->size()I

    move-result v24

    move/from16 v0, v24

    if-ge v9, v0, :cond_18a

    .line 8415
    move-object/from16 v0, v21

    move-object/from16 v1, p5

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 8417
    :cond_18a
    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v24

    goto/16 :goto_26

    .line 8359
    .end local v6           #firstToken:I
    .end local v7           #i:I
    .end local v9           #lastToken:I
    .end local v11           #lineTokens:Ljava/util/List;,"Ljava/util/List<Ljava/lang/String;>;"
    .end local v16           #markedTokens:Ljava/util/List;,"Ljava/util/List<Ljava/lang/String;>;"
    .end local v21           #sb:Ljava/lang/StringBuilder;
    .end local v23           #tokenOffsets:Ljava/util/List;,"Ljava/util/List<Ljava/lang/Integer;>;"
    :cond_190
    add-int/lit8 v8, v8, 0x1

    goto/16 :goto_71

    .line 8421
    .end local v4           #contentLine:Ljava/lang/String;
    :cond_194
    const/16 v24, 0x0

    goto/16 :goto_26
.end method

.method private static split(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V
    .registers 5
    .parameter "content"
    .parameter
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 8444
    .local p1, tokens:Ljava/util/List;,"Ljava/util/List<Ljava/lang/String;>;"
    .local p2, offsets:Ljava/util/List;,"Ljava/util/List<Ljava/lang/Integer;>;"
    sget-object v1, Landroid/provider/ContactsContract;->SPLIT_PATTERN:Ljava/util/regex/Pattern;

    invoke-virtual {v1, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    .line 8445
    .local v0, matcher:Ljava/util/regex/Matcher;
    :goto_6
    invoke-virtual {v0}, Ljava/util/regex/Matcher;->find()Z

    move-result v1

    if-eqz v1, :cond_1f

    .line 8446
    invoke-virtual {v0}, Ljava/util/regex/Matcher;->group()Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 8447
    invoke-virtual {v0}, Ljava/util/regex/Matcher;->start()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {p2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_6

    .line 8449
    :cond_1f
    return-void
.end method
