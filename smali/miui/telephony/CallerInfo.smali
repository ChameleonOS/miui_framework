.class public Lmiui/telephony/CallerInfo;
.super Ljava/lang/Object;
.source "CallerInfo.java"


# static fields
.field public static final PAYPHONE_NUMBER:Ljava/lang/String; = "-3"

.field public static final PRIVATE_NUMBER:Ljava/lang/String; = "-2"

.field private static final SP_NAME_COLUMN:I = 0x0

.field private static final SP_PHOTO_COLUMN:I = 0x1

.field private static final SP_PROJECTION:[Ljava/lang/String; = null

.field public static final UNKNOWN_NUMBER:Ljava/lang/String; = "-1"


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .prologue
    .line 27
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string/jumbo v2, "name"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string/jumbo v2, "photo"

    aput-object v2, v0, v1

    sput-object v0, Lmiui/telephony/CallerInfo;->SP_PROJECTION:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 21
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static doSpNumberQuery(Landroid/content/Context;Ljava/lang/String;Lcom/android/internal/telephony/CallerInfo;)Lcom/android/internal/telephony/CallerInfo;
    .registers 14
    .parameter "context"
    .parameter "number"
    .parameter "previousResult"

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x1

    .line 78
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_64

    iget-boolean v0, p2, Lcom/android/internal/telephony/CallerInfo;->contactExists:Z

    if-nez v0, :cond_64

    iget-object v0, p2, Lcom/android/internal/telephony/CallerInfo;->extra:Lmiui/telephony/ExtraCallerInfo;

    iget-boolean v0, v0, Lmiui/telephony/ExtraCallerInfo;->isSpNumber:Z

    if-nez v0, :cond_64

    .line 80
    invoke-static {p1}, Lmiui/telephony/PhoneNumberUtils$PhoneNumber;->parse(Ljava/lang/CharSequence;)Lmiui/telephony/PhoneNumberUtils$PhoneNumber;

    move-result-object v10

    .line 81
    .local v10, pn:Lmiui/telephony/PhoneNumberUtils$PhoneNumber;
    invoke-virtual {v10}, Lmiui/telephony/PhoneNumberUtils$PhoneNumber;->getEffectiveNumber()Ljava/lang/String;

    move-result-object v6

    .line 82
    .local v6, address:Ljava/lang/String;
    invoke-virtual {v10}, Lmiui/telephony/PhoneNumberUtils$PhoneNumber;->recycle()V

    .line 83
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const-string v1, "content://yellowpage/sp"

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    sget-object v2, Lmiui/telephony/CallerInfo;->SP_PROJECTION:[Ljava/lang/String;

    const-string v3, "addr=?"

    new-array v4, v4, [Ljava/lang/String;

    aput-object v6, v4, v5

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v7

    .line 86
    .local v7, cursor:Landroid/database/Cursor;
    if-eqz v7, :cond_64

    .line 88
    :try_start_36
    invoke-interface {v7}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_61

    .line 89
    iget-object v0, p2, Lcom/android/internal/telephony/CallerInfo;->extra:Lmiui/telephony/ExtraCallerInfo;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lmiui/telephony/ExtraCallerInfo;->isSpNumber:Z

    .line 90
    iget-object v0, p2, Lcom/android/internal/telephony/CallerInfo;->extra:Lmiui/telephony/ExtraCallerInfo;

    const/4 v1, 0x0

    invoke-interface {v7, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lmiui/telephony/ExtraCallerInfo;->displayName:Ljava/lang/String;

    .line 91
    const/4 v0, 0x1

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getBlob(I)[B

    move-result-object v9

    .line 92
    .local v9, photoData:[B
    if-eqz v9, :cond_61

    .line 93
    new-instance v8, Ljava/io/ByteArrayInputStream;

    invoke-direct {v8, v9}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    .line 94
    .local v8, inputStream:Ljava/io/InputStream;
    if-eqz v8, :cond_61

    .line 95
    invoke-static {v8, p1}, Landroid/graphics/drawable/Drawable;->createFromStream(Ljava/io/InputStream;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p2, Lcom/android/internal/telephony/CallerInfo;->cachedPhoto:Landroid/graphics/drawable/Drawable;

    .line 96
    const/4 v0, 0x1

    iput-boolean v0, p2, Lcom/android/internal/telephony/CallerInfo;->isCachedPhotoCurrent:Z
    :try_end_61
    .catchall {:try_start_36 .. :try_end_61} :catchall_65

    .line 101
    .end local v8           #inputStream:Ljava/io/InputStream;
    .end local v9           #photoData:[B
    :cond_61
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    .line 105
    .end local v6           #address:Ljava/lang/String;
    .end local v7           #cursor:Landroid/database/Cursor;
    .end local v10           #pn:Lmiui/telephony/PhoneNumberUtils$PhoneNumber;
    :cond_64
    return-object p2

    .line 101
    .restart local v6       #address:Ljava/lang/String;
    .restart local v7       #cursor:Landroid/database/Cursor;
    .restart local v10       #pn:Lmiui/telephony/PhoneNumberUtils$PhoneNumber;
    :catchall_65
    move-exception v0

    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    throw v0
.end method

.method public static getColumnIndex(Landroid/net/Uri;Ljava/lang/String;Landroid/database/Cursor;)I
    .registers 7
    .parameter "contactRef"
    .parameter "defaultName"
    .parameter "cursor"

    .prologue
    .line 109
    invoke-virtual {p0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    .line 110
    .local v2, url:Ljava/lang/String;
    move-object v1, p1

    .line 111
    .local v1, columnName:Ljava/lang/String;
    const-string v3, "content://com.android.contacts/data/phones"

    invoke-virtual {v2, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_15

    const-string v3, "content://com.android.contacts/data"

    invoke-virtual {v2, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_20

    .line 113
    :cond_15
    const-string/jumbo v3, "number"

    invoke-virtual {v3, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_27

    .line 114
    const-string v1, "data1"

    .line 123
    :cond_20
    :goto_20
    if-eqz v1, :cond_4a

    invoke-interface {p2, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    .line 124
    .local v0, columnIndex:I
    :goto_26
    return v0

    .line 115
    .end local v0           #columnIndex:I
    :cond_27
    const-string/jumbo v3, "type"

    invoke-virtual {v3, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_33

    .line 116
    const-string v1, "data2"

    goto :goto_20

    .line 117
    :cond_33
    const-string v3, "label"

    invoke-virtual {v3, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3e

    .line 118
    const-string v1, "data3"

    goto :goto_20

    .line 119
    :cond_3e
    const-string/jumbo v3, "normalized_number"

    invoke-virtual {v3, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_20

    .line 120
    const-string v1, "data4"

    goto :goto_20

    .line 123
    :cond_4a
    const/4 v0, -0x1

    goto :goto_26
.end method

.method public static getPresentation(Ljava/lang/CharSequence;)I
    .registers 2
    .parameter "number"

    .prologue
    .line 40
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_e

    const-string v0, "-1"

    invoke-static {p0, v0}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_11

    .line 42
    :cond_e
    sget v0, Lcom/android/internal/telephony/Connection;->PRESENTATION_UNKNOWN:I

    .line 48
    :goto_10
    return v0

    .line 43
    :cond_11
    const-string v0, "-2"

    invoke-static {p0, v0}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1c

    .line 44
    sget v0, Lcom/android/internal/telephony/Connection;->PRESENTATION_RESTRICTED:I

    goto :goto_10

    .line 45
    :cond_1c
    const-string v0, "-3"

    invoke-static {p0, v0}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_27

    .line 46
    sget v0, Lcom/android/internal/telephony/Connection;->PRESENTATION_PAYPHONE:I

    goto :goto_10

    .line 48
    :cond_27
    sget v0, Lcom/android/internal/telephony/Connection;->PRESENTATION_ALLOWED:I

    goto :goto_10
.end method

.method public static updateDisplayName(Landroid/content/Context;Lcom/android/internal/telephony/CallerInfo;Landroid/database/Cursor;)V
    .registers 11
    .parameter "context"
    .parameter "ci"
    .parameter "cursor"

    .prologue
    const/16 v7, 0x20

    .line 52
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 53
    .local v0, builder:Ljava/lang/StringBuilder;
    iget-object v5, p1, Lcom/android/internal/telephony/CallerInfo;->name:Ljava/lang/String;

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 54
    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v5

    const/4 v6, 0x1

    if-le v5, v6, :cond_51

    .line 55
    const-string v5, "display_name"

    invoke-interface {p2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 56
    .local v1, columnIndex:I
    const/4 v5, -0x1

    if-eq v1, v5, :cond_51

    .line 57
    new-instance v4, Ljava/util/HashSet;

    invoke-direct {v4}, Ljava/util/HashSet;-><init>()V

    .line 58
    .local v4, names:Ljava/util/HashSet;,"Ljava/util/HashSet<Ljava/lang/String;>;"
    iget-object v5, p1, Lcom/android/internal/telephony/CallerInfo;->name:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 59
    const v5, 0x60c016c

    invoke-virtual {p0, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 60
    .local v2, delimiter:Ljava/lang/String;
    :cond_2d
    :goto_2d
    invoke-interface {p2}, Landroid/database/Cursor;->moveToNext()Z

    move-result v5

    if-eqz v5, :cond_51

    .line 61
    invoke-interface {p2, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 62
    .local v3, name:Ljava/lang/String;
    invoke-virtual {v4, v3}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_2d

    .line 63
    invoke-virtual {v4}, Ljava/util/HashSet;->size()I

    move-result v5

    const/4 v6, 0x3

    if-lt v5, v6, :cond_5a

    .line 64
    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " ..."

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 73
    .end local v1           #columnIndex:I
    .end local v2           #delimiter:Ljava/lang/String;
    .end local v3           #name:Ljava/lang/String;
    .end local v4           #names:Ljava/util/HashSet;,"Ljava/util/HashSet<Ljava/lang/String;>;"
    :cond_51
    iget-object v5, p1, Lcom/android/internal/telephony/CallerInfo;->extra:Lmiui/telephony/ExtraCallerInfo;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    iput-object v6, v5, Lmiui/telephony/ExtraCallerInfo;->displayName:Ljava/lang/String;

    .line 74
    return-void

    .line 67
    .restart local v1       #columnIndex:I
    .restart local v2       #delimiter:Ljava/lang/String;
    .restart local v3       #name:Ljava/lang/String;
    .restart local v4       #names:Ljava/util/HashSet;,"Ljava/util/HashSet<Ljava/lang/String;>;"
    :cond_5a
    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 68
    invoke-virtual {v4, v3}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    goto :goto_2d
.end method
