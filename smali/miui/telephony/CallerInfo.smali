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

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_64

    iget-boolean v0, p2, Lcom/android/internal/telephony/CallerInfo;->contactExists:Z

    if-nez v0, :cond_64

    iget-object v0, p2, Lcom/android/internal/telephony/CallerInfo;->extra:Lmiui/telephony/ExtraCallerInfo;

    iget-boolean v0, v0, Lmiui/telephony/ExtraCallerInfo;->isSpNumber:Z

    if-nez v0, :cond_64

    invoke-static {p1}, Lmiui/telephony/PhoneNumberUtils$PhoneNumber;->parse(Ljava/lang/CharSequence;)Lmiui/telephony/PhoneNumberUtils$PhoneNumber;

    move-result-object v10

    .local v10, pn:Lmiui/telephony/PhoneNumberUtils$PhoneNumber;
    invoke-virtual {v10}, Lmiui/telephony/PhoneNumberUtils$PhoneNumber;->getEffectiveNumber()Ljava/lang/String;

    move-result-object v6

    .local v6, address:Ljava/lang/String;
    invoke-virtual {v10}, Lmiui/telephony/PhoneNumberUtils$PhoneNumber;->recycle()V

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

    .local v7, cursor:Landroid/database/Cursor;
    if-eqz v7, :cond_64

    :try_start_36
    invoke-interface {v7}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_61

    iget-object v0, p2, Lcom/android/internal/telephony/CallerInfo;->extra:Lmiui/telephony/ExtraCallerInfo;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lmiui/telephony/ExtraCallerInfo;->isSpNumber:Z

    iget-object v0, p2, Lcom/android/internal/telephony/CallerInfo;->extra:Lmiui/telephony/ExtraCallerInfo;

    const/4 v1, 0x0

    invoke-interface {v7, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lmiui/telephony/ExtraCallerInfo;->displayName:Ljava/lang/String;

    const/4 v0, 0x1

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getBlob(I)[B

    move-result-object v9

    .local v9, photoData:[B
    if-eqz v9, :cond_61

    new-instance v8, Ljava/io/ByteArrayInputStream;

    invoke-direct {v8, v9}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    .local v8, inputStream:Ljava/io/InputStream;
    if-eqz v8, :cond_61

    invoke-static {v8, p1}, Landroid/graphics/drawable/Drawable;->createFromStream(Ljava/io/InputStream;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p2, Lcom/android/internal/telephony/CallerInfo;->cachedPhoto:Landroid/graphics/drawable/Drawable;

    const/4 v0, 0x1

    iput-boolean v0, p2, Lcom/android/internal/telephony/CallerInfo;->isCachedPhotoCurrent:Z
    :try_end_61
    .catchall {:try_start_36 .. :try_end_61} :catchall_65

    .end local v8           #inputStream:Ljava/io/InputStream;
    .end local v9           #photoData:[B
    :cond_61
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    .end local v6           #address:Ljava/lang/String;
    .end local v7           #cursor:Landroid/database/Cursor;
    .end local v10           #pn:Lmiui/telephony/PhoneNumberUtils$PhoneNumber;
    :cond_64
    return-object p2

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
    invoke-virtual {p0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    .local v2, url:Ljava/lang/String;
    move-object v1, p1

    .local v1, columnName:Ljava/lang/String;
    const-string v3, "content://com.android.contacts/data/phones"

    invoke-virtual {v2, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_15

    const-string v3, "content://com.android.contacts/data"

    invoke-virtual {v2, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_20

    :cond_15
    const-string/jumbo v3, "number"

    invoke-virtual {v3, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_27

    const-string v1, "data1"

    :cond_20
    :goto_20
    if-eqz v1, :cond_4a

    invoke-interface {p2, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    .local v0, columnIndex:I
    :goto_26
    return v0

    .end local v0           #columnIndex:I
    :cond_27
    const-string/jumbo v3, "type"

    invoke-virtual {v3, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_33

    const-string v1, "data2"

    goto :goto_20

    :cond_33
    const-string v3, "label"

    invoke-virtual {v3, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3e

    const-string v1, "data3"

    goto :goto_20

    :cond_3e
    const-string/jumbo v3, "normalized_number"

    invoke-virtual {v3, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_20

    const-string v1, "data4"

    goto :goto_20

    :cond_4a
    const/4 v0, -0x1

    goto :goto_26
.end method

.method public static getPresentation(Ljava/lang/CharSequence;)I
    .registers 2
    .parameter "number"

    .prologue
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_e

    const-string v0, "-1"

    invoke-static {p0, v0}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_11

    :cond_e
    sget v0, Lcom/android/internal/telephony/Connection;->PRESENTATION_UNKNOWN:I

    :goto_10
    return v0

    :cond_11
    const-string v0, "-2"

    invoke-static {p0, v0}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1c

    sget v0, Lcom/android/internal/telephony/Connection;->PRESENTATION_RESTRICTED:I

    goto :goto_10

    :cond_1c
    const-string v0, "-3"

    invoke-static {p0, v0}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_27

    sget v0, Lcom/android/internal/telephony/Connection;->PRESENTATION_PAYPHONE:I

    goto :goto_10

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

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .local v0, builder:Ljava/lang/StringBuilder;
    iget-object v5, p1, Lcom/android/internal/telephony/CallerInfo;->name:Ljava/lang/String;

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v5

    const/4 v6, 0x1

    if-le v5, v6, :cond_51

    const-string v5, "display_name"

    invoke-interface {p2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .local v1, columnIndex:I
    const/4 v5, -0x1

    if-eq v1, v5, :cond_51

    new-instance v4, Ljava/util/HashSet;

    invoke-direct {v4}, Ljava/util/HashSet;-><init>()V

    .local v4, names:Ljava/util/HashSet;,"Ljava/util/HashSet<Ljava/lang/String;>;"
    iget-object v5, p1, Lcom/android/internal/telephony/CallerInfo;->name:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    const v5, 0x60c016c

    invoke-virtual {p0, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .local v2, delimiter:Ljava/lang/String;
    :cond_2d
    :goto_2d
    invoke-interface {p2}, Landroid/database/Cursor;->moveToNext()Z

    move-result v5

    if-eqz v5, :cond_51

    invoke-interface {p2, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    .local v3, name:Ljava/lang/String;
    invoke-virtual {v4, v3}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_2d

    invoke-virtual {v4}, Ljava/util/HashSet;->size()I

    move-result v5

    const/4 v6, 0x3

    if-lt v5, v6, :cond_5a

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " ..."

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .end local v1           #columnIndex:I
    .end local v2           #delimiter:Ljava/lang/String;
    .end local v3           #name:Ljava/lang/String;
    .end local v4           #names:Ljava/util/HashSet;,"Ljava/util/HashSet<Ljava/lang/String;>;"
    :cond_51
    iget-object v5, p1, Lcom/android/internal/telephony/CallerInfo;->extra:Lmiui/telephony/ExtraCallerInfo;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    iput-object v6, v5, Lmiui/telephony/ExtraCallerInfo;->displayName:Ljava/lang/String;

    return-void

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

    invoke-virtual {v4, v3}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    goto :goto_2d
.end method
