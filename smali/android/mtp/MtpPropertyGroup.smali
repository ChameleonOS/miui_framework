.class Landroid/mtp/MtpPropertyGroup;
.super Ljava/lang/Object;
.source "MtpPropertyGroup.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/mtp/MtpPropertyGroup$Property;
    }
.end annotation


# static fields
.field private static final FORMAT_WHERE:Ljava/lang/String; = "format=?"

.field private static final ID_FORMAT_WHERE:Ljava/lang/String; = "_id=? AND format=?"

.field private static final ID_WHERE:Ljava/lang/String; = "_id=?"

.field private static final PARENT_FORMAT_WHERE:Ljava/lang/String; = "parent=? AND format=?"

.field private static final PARENT_WHERE:Ljava/lang/String; = "parent=?"

.field private static final TAG:Ljava/lang/String; = "MtpPropertyGroup"


# instance fields
.field private mColumns:[Ljava/lang/String;

.field private final mDatabase:Landroid/mtp/MtpDatabase;

.field private final mProperties:[Landroid/mtp/MtpPropertyGroup$Property;

.field private final mProvider:Landroid/content/IContentProvider;

.field private final mUri:Landroid/net/Uri;

.field private final mVolumeName:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/mtp/MtpDatabase;Landroid/content/IContentProvider;Ljava/lang/String;[I)V
    .registers 10
    .parameter "database"
    .parameter "provider"
    .parameter "volume"
    .parameter "properties"

    .prologue
    .line 69
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 70
    iput-object p1, p0, Landroid/mtp/MtpPropertyGroup;->mDatabase:Landroid/mtp/MtpDatabase;

    .line 71
    iput-object p2, p0, Landroid/mtp/MtpPropertyGroup;->mProvider:Landroid/content/IContentProvider;

    .line 72
    iput-object p3, p0, Landroid/mtp/MtpPropertyGroup;->mVolumeName:Ljava/lang/String;

    .line 73
    invoke-static {p3}, Landroid/provider/MediaStore$Files;->getMtpObjectsUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    iput-object v3, p0, Landroid/mtp/MtpPropertyGroup;->mUri:Landroid/net/Uri;

    .line 75
    array-length v1, p4

    .line 76
    .local v1, count:I
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    .line 77
    .local v0, columns:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/String;>;"
    const-string v3, "_id"

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 79
    new-array v3, v1, [Landroid/mtp/MtpPropertyGroup$Property;

    iput-object v3, p0, Landroid/mtp/MtpPropertyGroup;->mProperties:[Landroid/mtp/MtpPropertyGroup$Property;

    .line 80
    const/4 v2, 0x0

    .local v2, i:I
    :goto_1f
    if-ge v2, v1, :cond_2e

    .line 81
    iget-object v3, p0, Landroid/mtp/MtpPropertyGroup;->mProperties:[Landroid/mtp/MtpPropertyGroup$Property;

    aget v4, p4, v2

    invoke-direct {p0, v4, v0}, Landroid/mtp/MtpPropertyGroup;->createProperty(ILjava/util/ArrayList;)Landroid/mtp/MtpPropertyGroup$Property;

    move-result-object v4

    aput-object v4, v3, v2

    .line 80
    add-int/lit8 v2, v2, 0x1

    goto :goto_1f

    .line 83
    :cond_2e
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    .line 84
    new-array v3, v1, [Ljava/lang/String;

    iput-object v3, p0, Landroid/mtp/MtpPropertyGroup;->mColumns:[Ljava/lang/String;

    .line 85
    const/4 v2, 0x0

    :goto_37
    if-ge v2, v1, :cond_46

    .line 86
    iget-object v4, p0, Landroid/mtp/MtpPropertyGroup;->mColumns:[Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    aput-object v3, v4, v2

    .line 85
    add-int/lit8 v2, v2, 0x1

    goto :goto_37

    .line 88
    :cond_46
    return-void
.end method

.method private createProperty(ILjava/util/ArrayList;)Landroid/mtp/MtpPropertyGroup$Property;
    .registers 8
    .parameter "code"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Landroid/mtp/MtpPropertyGroup$Property;"
        }
    .end annotation

    .prologue
    .line 91
    .local p2, columns:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/String;>;"
    const/4 v0, 0x0

    .line 94
    .local v0, column:Ljava/lang/String;
    sparse-switch p1, :sswitch_data_9e

    .line 175
    const/4 v1, 0x0

    .line 176
    .local v1, type:I
    const-string v2, "MtpPropertyGroup"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "unsupported property "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 180
    :goto_1e
    if-eqz v0, :cond_97

    .line 181
    invoke-virtual {p2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 182
    new-instance v2, Landroid/mtp/MtpPropertyGroup$Property;

    invoke-virtual {p2}, Ljava/util/ArrayList;->size()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    invoke-direct {v2, p0, p1, v1, v3}, Landroid/mtp/MtpPropertyGroup$Property;-><init>(Landroid/mtp/MtpPropertyGroup;III)V

    .line 184
    :goto_2e
    return-object v2

    .line 96
    .end local v1           #type:I
    :sswitch_2f
    const-string/jumbo v0, "storage_id"

    .line 97
    const/4 v1, 0x6

    .line 98
    .restart local v1       #type:I
    goto :goto_1e

    .line 100
    .end local v1           #type:I
    :sswitch_34
    const-string v0, "format"

    .line 101
    const/4 v1, 0x4

    .line 102
    .restart local v1       #type:I
    goto :goto_1e

    .line 105
    .end local v1           #type:I
    :sswitch_38
    const/4 v1, 0x4

    .line 106
    .restart local v1       #type:I
    goto :goto_1e

    .line 108
    .end local v1           #type:I
    :sswitch_3a
    const-string v0, "_size"

    .line 109
    const/16 v1, 0x8

    .line 110
    .restart local v1       #type:I
    goto :goto_1e

    .line 112
    .end local v1           #type:I
    :sswitch_3f
    const-string v0, "_data"

    .line 113
    const v1, 0xffff

    .line 114
    .restart local v1       #type:I
    goto :goto_1e

    .line 116
    .end local v1           #type:I
    :sswitch_45
    const-string/jumbo v0, "title"

    .line 117
    const v1, 0xffff

    .line 118
    .restart local v1       #type:I
    goto :goto_1e

    .line 120
    .end local v1           #type:I
    :sswitch_4c
    const-string v0, "date_modified"

    .line 121
    const v1, 0xffff

    .line 122
    .restart local v1       #type:I
    goto :goto_1e

    .line 124
    .end local v1           #type:I
    :sswitch_52
    const-string v0, "date_added"

    .line 125
    const v1, 0xffff

    .line 126
    .restart local v1       #type:I
    goto :goto_1e

    .line 128
    .end local v1           #type:I
    :sswitch_58
    const-string/jumbo v0, "year"

    .line 129
    const v1, 0xffff

    .line 130
    .restart local v1       #type:I
    goto :goto_1e

    .line 132
    .end local v1           #type:I
    :sswitch_5f
    const-string/jumbo v0, "parent"

    .line 133
    const/4 v1, 0x6

    .line 134
    .restart local v1       #type:I
    goto :goto_1e

    .line 137
    .end local v1           #type:I
    :sswitch_64
    const-string/jumbo v0, "storage_id"

    .line 138
    const/16 v1, 0xa

    .line 139
    .restart local v1       #type:I
    goto :goto_1e

    .line 141
    .end local v1           #type:I
    :sswitch_6a
    const-string v0, "duration"

    .line 142
    const/4 v1, 0x6

    .line 143
    .restart local v1       #type:I
    goto :goto_1e

    .line 145
    .end local v1           #type:I
    :sswitch_6e
    const-string/jumbo v0, "track"

    .line 146
    const/4 v1, 0x4

    .line 147
    .restart local v1       #type:I
    goto :goto_1e

    .line 149
    .end local v1           #type:I
    :sswitch_73
    const-string v0, "_display_name"

    .line 150
    const v1, 0xffff

    .line 151
    .restart local v1       #type:I
    goto :goto_1e

    .line 153
    .end local v1           #type:I
    :sswitch_79
    const v1, 0xffff

    .line 154
    .restart local v1       #type:I
    goto :goto_1e

    .line 156
    .end local v1           #type:I
    :sswitch_7d
    const v1, 0xffff

    .line 157
    .restart local v1       #type:I
    goto :goto_1e

    .line 159
    .end local v1           #type:I
    :sswitch_81
    const-string v0, "album_artist"

    .line 160
    const v1, 0xffff

    .line 161
    .restart local v1       #type:I
    goto :goto_1e

    .line 164
    .end local v1           #type:I
    :sswitch_87
    const v1, 0xffff

    .line 165
    .restart local v1       #type:I
    goto :goto_1e

    .line 167
    .end local v1           #type:I
    :sswitch_8b
    const-string v0, "composer"

    .line 168
    const v1, 0xffff

    .line 169
    .restart local v1       #type:I
    goto :goto_1e

    .line 171
    .end local v1           #type:I
    :sswitch_91
    const-string v0, "description"

    .line 172
    const v1, 0xffff

    .line 173
    .restart local v1       #type:I
    goto :goto_1e

    .line 184
    :cond_97
    new-instance v2, Landroid/mtp/MtpPropertyGroup$Property;

    const/4 v3, -0x1

    invoke-direct {v2, p0, p1, v1, v3}, Landroid/mtp/MtpPropertyGroup$Property;-><init>(Landroid/mtp/MtpPropertyGroup;III)V

    goto :goto_2e

    .line 94
    :sswitch_data_9e
    .sparse-switch
        0xdc01 -> :sswitch_2f
        0xdc02 -> :sswitch_34
        0xdc03 -> :sswitch_38
        0xdc04 -> :sswitch_3a
        0xdc07 -> :sswitch_3f
        0xdc09 -> :sswitch_4c
        0xdc0b -> :sswitch_5f
        0xdc41 -> :sswitch_64
        0xdc44 -> :sswitch_45
        0xdc46 -> :sswitch_79
        0xdc48 -> :sswitch_91
        0xdc4e -> :sswitch_52
        0xdc89 -> :sswitch_6a
        0xdc8b -> :sswitch_6e
        0xdc8c -> :sswitch_87
        0xdc96 -> :sswitch_8b
        0xdc99 -> :sswitch_58
        0xdc9a -> :sswitch_7d
        0xdc9b -> :sswitch_81
        0xdce0 -> :sswitch_73
    .end sparse-switch
.end method

.method private native format_date_time(J)Ljava/lang/String;
.end method

.method private static nameFromPath(Ljava/lang/String;)Ljava/lang/String;
    .registers 6
    .parameter "path"

    .prologue
    .line 272
    const/4 v2, 0x0

    .line 273
    .local v2, start:I
    const/16 v3, 0x2f

    invoke-virtual {p0, v3}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v1

    .line 274
    .local v1, lastSlash:I
    if-ltz v1, :cond_b

    .line 275
    add-int/lit8 v2, v1, 0x1

    .line 277
    :cond_b
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    .line 278
    .local v0, end:I
    sub-int v3, v0, v2

    const/16 v4, 0xff

    if-le v3, v4, :cond_17

    .line 279
    add-int/lit16 v0, v2, 0xff

    .line 281
    :cond_17
    invoke-virtual {p0, v2, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method

.method private queryAudio(ILjava/lang/String;)Ljava/lang/String;
    .registers 13
    .parameter "id"
    .parameter "column"

    .prologue
    const/4 v9, 0x0

    .line 210
    const/4 v7, 0x0

    .line 212
    .local v7, c:Landroid/database/Cursor;
    :try_start_2
    iget-object v0, p0, Landroid/mtp/MtpPropertyGroup;->mProvider:Landroid/content/IContentProvider;

    iget-object v1, p0, Landroid/mtp/MtpPropertyGroup;->mVolumeName:Ljava/lang/String;

    invoke-static {v1}, Landroid/provider/MediaStore$Audio$Media;->getContentUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "_id"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    aput-object p2, v2, v3

    const-string v3, "_id=?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-interface/range {v0 .. v6}, Landroid/content/IContentProvider;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/os/ICancellationSignal;)Landroid/database/Cursor;

    move-result-object v7

    .line 215
    if-eqz v7, :cond_3a

    invoke-interface {v7}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_3a

    .line 216
    const/4 v0, 0x1

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_33
    .catchall {:try_start_2 .. :try_end_33} :catchall_47
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_33} :catch_3f

    move-result-object v0

    .line 223
    if-eqz v7, :cond_39

    .line 224
    :goto_36
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    .line 221
    :cond_39
    :goto_39
    return-object v0

    .line 218
    :cond_3a
    :try_start_3a
    const-string v0, ""
    :try_end_3c
    .catchall {:try_start_3a .. :try_end_3c} :catchall_47
    .catch Ljava/lang/Exception; {:try_start_3a .. :try_end_3c} :catch_3f

    .line 223
    if-eqz v7, :cond_39

    goto :goto_36

    .line 220
    :catch_3f
    move-exception v8

    .line 223
    .local v8, e:Ljava/lang/Exception;
    if-eqz v7, :cond_45

    .line 224
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    :cond_45
    move-object v0, v9

    .line 221
    goto :goto_39

    .line 223
    .end local v8           #e:Ljava/lang/Exception;
    :catchall_47
    move-exception v0

    if-eqz v7, :cond_4d

    .line 224
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    .line 223
    :cond_4d
    throw v0
.end method

.method private queryGenre(I)Ljava/lang/String;
    .registers 12
    .parameter "id"

    .prologue
    const/4 v9, 0x0

    .line 230
    const/4 v7, 0x0

    .line 232
    .local v7, c:Landroid/database/Cursor;
    :try_start_2
    iget-object v0, p0, Landroid/mtp/MtpPropertyGroup;->mVolumeName:Ljava/lang/String;

    invoke-static {v0, p1}, Landroid/provider/MediaStore$Audio$Genres;->getContentUriForAudioId(Ljava/lang/String;I)Landroid/net/Uri;

    move-result-object v1

    .line 233
    .local v1, uri:Landroid/net/Uri;
    iget-object v0, p0, Landroid/mtp/MtpPropertyGroup;->mProvider:Landroid/content/IContentProvider;

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "_id"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    const-string/jumbo v4, "name"

    aput-object v4, v2, v3

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-interface/range {v0 .. v6}, Landroid/content/IContentProvider;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/os/ICancellationSignal;)Landroid/database/Cursor;

    move-result-object v7

    .line 236
    if-eqz v7, :cond_33

    invoke-interface {v7}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_33

    .line 237
    const/4 v0, 0x1

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_2c
    .catchall {:try_start_2 .. :try_end_2c} :catchall_48
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2c} :catch_38

    move-result-object v0

    .line 245
    if-eqz v7, :cond_32

    .line 246
    :goto_2f
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    .line 243
    .end local v1           #uri:Landroid/net/Uri;
    :cond_32
    :goto_32
    return-object v0

    .line 239
    .restart local v1       #uri:Landroid/net/Uri;
    :cond_33
    :try_start_33
    const-string v0, ""
    :try_end_35
    .catchall {:try_start_33 .. :try_end_35} :catchall_48
    .catch Ljava/lang/Exception; {:try_start_33 .. :try_end_35} :catch_38

    .line 245
    if-eqz v7, :cond_32

    goto :goto_2f

    .line 241
    .end local v1           #uri:Landroid/net/Uri;
    :catch_38
    move-exception v8

    .line 242
    .local v8, e:Ljava/lang/Exception;
    :try_start_39
    const-string v0, "MtpPropertyGroup"

    const-string/jumbo v2, "queryGenre exception"

    invoke-static {v0, v2, v8}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_41
    .catchall {:try_start_39 .. :try_end_41} :catchall_48

    .line 245
    if-eqz v7, :cond_46

    .line 246
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    :cond_46
    move-object v0, v9

    .line 243
    goto :goto_32

    .line 245
    .end local v8           #e:Ljava/lang/Exception;
    :catchall_48
    move-exception v0

    if-eqz v7, :cond_4e

    .line 246
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    .line 245
    :cond_4e
    throw v0
.end method

.method private queryLong(ILjava/lang/String;)Ljava/lang/Long;
    .registers 12
    .parameter "id"
    .parameter "column"

    .prologue
    const/4 v8, 0x0

    .line 252
    const/4 v7, 0x0

    .line 255
    .local v7, c:Landroid/database/Cursor;
    :try_start_2
    iget-object v0, p0, Landroid/mtp/MtpPropertyGroup;->mProvider:Landroid/content/IContentProvider;

    iget-object v1, p0, Landroid/mtp/MtpPropertyGroup;->mUri:Landroid/net/Uri;

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "_id"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    aput-object p2, v2, v3

    const-string v3, "_id=?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-interface/range {v0 .. v6}, Landroid/content/IContentProvider;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/os/ICancellationSignal;)Landroid/database/Cursor;

    move-result-object v7

    .line 258
    if-eqz v7, :cond_4a

    invoke-interface {v7}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_4a

    .line 259
    new-instance v0, Ljava/lang/Long;

    const/4 v1, 0x1

    invoke-interface {v7, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v1

    invoke-direct {v0, v1, v2}, Ljava/lang/Long;-><init>(J)V
    :try_end_35
    .catchall {:try_start_2 .. :try_end_35} :catchall_3b
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_35} :catch_42

    .line 263
    if-eqz v7, :cond_3a

    .line 264
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    .line 267
    :cond_3a
    :goto_3a
    return-object v0

    .line 263
    :catchall_3b
    move-exception v0

    if-eqz v7, :cond_41

    .line 264
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    .line 263
    :cond_41
    throw v0

    .line 261
    :catch_42
    move-exception v0

    .line 263
    if-eqz v7, :cond_48

    .line 264
    :goto_45
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    :cond_48
    move-object v0, v8

    .line 267
    goto :goto_3a

    .line 263
    :cond_4a
    if-eqz v7, :cond_48

    goto :goto_45
.end method

.method private queryString(ILjava/lang/String;)Ljava/lang/String;
    .registers 13
    .parameter "id"
    .parameter "column"

    .prologue
    const/4 v9, 0x0

    .line 189
    const/4 v7, 0x0

    .line 192
    .local v7, c:Landroid/database/Cursor;
    :try_start_2
    iget-object v0, p0, Landroid/mtp/MtpPropertyGroup;->mProvider:Landroid/content/IContentProvider;

    iget-object v1, p0, Landroid/mtp/MtpPropertyGroup;->mUri:Landroid/net/Uri;

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "_id"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    aput-object p2, v2, v3

    const-string v3, "_id=?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-interface/range {v0 .. v6}, Landroid/content/IContentProvider;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/os/ICancellationSignal;)Landroid/database/Cursor;

    move-result-object v7

    .line 195
    if-eqz v7, :cond_36

    invoke-interface {v7}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_36

    .line 196
    const/4 v0, 0x1

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_2f
    .catchall {:try_start_2 .. :try_end_2f} :catchall_43
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2f} :catch_3b

    move-result-object v0

    .line 203
    if-eqz v7, :cond_35

    .line 204
    :goto_32
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    .line 201
    :cond_35
    :goto_35
    return-object v0

    .line 198
    :cond_36
    :try_start_36
    const-string v0, ""
    :try_end_38
    .catchall {:try_start_36 .. :try_end_38} :catchall_43
    .catch Ljava/lang/Exception; {:try_start_36 .. :try_end_38} :catch_3b

    .line 203
    if-eqz v7, :cond_35

    goto :goto_32

    .line 200
    :catch_3b
    move-exception v8

    .line 203
    .local v8, e:Ljava/lang/Exception;
    if-eqz v7, :cond_41

    .line 204
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    :cond_41
    move-object v0, v9

    .line 201
    goto :goto_35

    .line 203
    .end local v8           #e:Ljava/lang/Exception;
    :catchall_43
    move-exception v0

    if-eqz v7, :cond_49

    .line 204
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    .line 203
    :cond_49
    throw v0
.end method


# virtual methods
.method getPropertyList(III)Landroid/mtp/MtpPropertyList;
    .registers 35
    .parameter "handle"
    .parameter "format"
    .parameter "depth"

    .prologue
    .line 286
    const/4 v2, 0x1

    move/from16 v0, p3

    if-le v0, v2, :cond_f

    .line 289
    new-instance v7, Landroid/mtp/MtpPropertyList;

    const/4 v2, 0x0

    const v3, 0xa808

    invoke-direct {v7, v2, v3}, Landroid/mtp/MtpPropertyList;-><init>(II)V

    .line 438
    :cond_e
    :goto_e
    return-object v7

    .line 294
    :cond_f
    if-nez p2, :cond_61

    .line 295
    const/4 v2, -0x1

    move/from16 v0, p1

    if-ne v0, v2, :cond_4b

    .line 297
    const/4 v5, 0x0

    .line 298
    .local v5, where:Ljava/lang/String;
    const/4 v6, 0x0

    .line 322
    .local v6, whereArgs:[Ljava/lang/String;
    :goto_18
    const/16 v19, 0x0

    .line 325
    .local v19, c:Landroid/database/Cursor;
    if-gtz p3, :cond_29

    const/4 v2, -0x1

    move/from16 v0, p1

    if-eq v0, v2, :cond_29

    :try_start_21
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/mtp/MtpPropertyGroup;->mColumns:[Ljava/lang/String;

    array-length v2, v2

    const/4 v3, 0x1

    if-le v2, v3, :cond_90

    .line 326
    :cond_29
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/mtp/MtpPropertyGroup;->mProvider:Landroid/content/IContentProvider;

    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/mtp/MtpPropertyGroup;->mUri:Landroid/net/Uri;

    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/mtp/MtpPropertyGroup;->mColumns:[Ljava/lang/String;

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-interface/range {v2 .. v8}, Landroid/content/IContentProvider;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/os/ICancellationSignal;)Landroid/database/Cursor;

    move-result-object v19

    .line 327
    if-nez v19, :cond_90

    .line 328
    new-instance v7, Landroid/mtp/MtpPropertyList;

    const/4 v2, 0x0

    const/16 v3, 0x2009

    invoke-direct {v7, v2, v3}, Landroid/mtp/MtpPropertyList;-><init>(II)V
    :try_end_45
    .catchall {:try_start_21 .. :try_end_45} :catchall_117
    .catch Landroid/os/RemoteException; {:try_start_21 .. :try_end_45} :catch_fa

    .line 440
    if-eqz v19, :cond_e

    .line 441
    :goto_47
    invoke-interface/range {v19 .. v19}, Landroid/database/Cursor;->close()V

    goto :goto_e

    .line 300
    .end local v5           #where:Ljava/lang/String;
    .end local v6           #whereArgs:[Ljava/lang/String;
    .end local v19           #c:Landroid/database/Cursor;
    :cond_4b
    const/4 v2, 0x1

    new-array v6, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    invoke-static/range {p1 .. p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v6, v2

    .line 301
    .restart local v6       #whereArgs:[Ljava/lang/String;
    const/4 v2, 0x1

    move/from16 v0, p3

    if-ne v0, v2, :cond_5e

    .line 302
    const-string/jumbo v5, "parent=?"

    .restart local v5       #where:Ljava/lang/String;
    goto :goto_18

    .line 304
    .end local v5           #where:Ljava/lang/String;
    :cond_5e
    const-string v5, "_id=?"

    .restart local v5       #where:Ljava/lang/String;
    goto :goto_18

    .line 308
    .end local v5           #where:Ljava/lang/String;
    .end local v6           #whereArgs:[Ljava/lang/String;
    :cond_61
    const/4 v2, -0x1

    move/from16 v0, p1

    if-ne v0, v2, :cond_73

    .line 310
    const-string v5, "format=?"

    .line 311
    .restart local v5       #where:Ljava/lang/String;
    const/4 v2, 0x1

    new-array v6, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    invoke-static/range {p2 .. p2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v6, v2

    .restart local v6       #whereArgs:[Ljava/lang/String;
    goto :goto_18

    .line 313
    .end local v5           #where:Ljava/lang/String;
    .end local v6           #whereArgs:[Ljava/lang/String;
    :cond_73
    const/4 v2, 0x2

    new-array v6, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    invoke-static/range {p1 .. p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v6, v2

    const/4 v2, 0x1

    invoke-static/range {p2 .. p2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v6, v2

    .line 314
    .restart local v6       #whereArgs:[Ljava/lang/String;
    const/4 v2, 0x1

    move/from16 v0, p3

    if-ne v0, v2, :cond_8d

    .line 315
    const-string/jumbo v5, "parent=? AND format=?"

    .restart local v5       #where:Ljava/lang/String;
    goto :goto_18

    .line 317
    .end local v5           #where:Ljava/lang/String;
    :cond_8d
    const-string v5, "_id=? AND format=?"

    .restart local v5       #where:Ljava/lang/String;
    goto :goto_18

    .line 332
    .restart local v19       #c:Landroid/database/Cursor;
    :cond_90
    if-nez v19, :cond_ec

    const/16 v21, 0x1

    .line 333
    .local v21, count:I
    :goto_94
    :try_start_94
    new-instance v7, Landroid/mtp/MtpPropertyList;

    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/mtp/MtpPropertyGroup;->mProperties:[Landroid/mtp/MtpPropertyGroup$Property;

    array-length v2, v2

    mul-int v2, v2, v21

    const/16 v3, 0x2001

    invoke-direct {v7, v2, v3}, Landroid/mtp/MtpPropertyList;-><init>(II)V

    .line 337
    .local v7, result:Landroid/mtp/MtpPropertyList;
    const/16 v26, 0x0

    .local v26, objectIndex:I
    :goto_a4
    move/from16 v0, v26

    move/from16 v1, v21

    if-ge v0, v1, :cond_21a

    .line 338
    if-eqz v19, :cond_b9

    .line 339
    invoke-interface/range {v19 .. v19}, Landroid/database/Cursor;->moveToNext()Z

    .line 340
    const/4 v2, 0x0

    move-object/from16 v0, v19

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    long-to-int v0, v2

    move/from16 p1, v0

    .line 344
    :cond_b9
    const/16 v28, 0x0

    .local v28, propertyIndex:I
    :goto_bb
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/mtp/MtpPropertyGroup;->mProperties:[Landroid/mtp/MtpPropertyGroup$Property;

    array-length v2, v2

    move/from16 v0, v28

    if-ge v0, v2, :cond_216

    .line 345
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/mtp/MtpPropertyGroup;->mProperties:[Landroid/mtp/MtpPropertyGroup$Property;

    aget-object v27, v2, v28

    .line 346
    .local v27, property:Landroid/mtp/MtpPropertyGroup$Property;
    move-object/from16 v0, v27

    iget v9, v0, Landroid/mtp/MtpPropertyGroup$Property;->code:I

    .line 347
    .local v9, propertyCode:I
    move-object/from16 v0, v27

    iget v0, v0, Landroid/mtp/MtpPropertyGroup$Property;->column:I

    move/from16 v20, v0

    .line 350
    .local v20, column:I
    sparse-switch v9, :sswitch_data_21e

    .line 423
    move-object/from16 v0, v27

    iget v2, v0, Landroid/mtp/MtpPropertyGroup$Property;->type:I

    const v3, 0xffff

    if-ne v2, v3, :cond_1ec

    .line 424
    invoke-interface/range {v19 .. v20}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    move/from16 v0, p1

    invoke-virtual {v7, v0, v9, v2}, Landroid/mtp/MtpPropertyList;->append(IILjava/lang/String;)V

    .line 344
    :goto_e9
    add-int/lit8 v28, v28, 0x1

    goto :goto_bb

    .line 332
    .end local v7           #result:Landroid/mtp/MtpPropertyList;
    .end local v9           #propertyCode:I
    .end local v20           #column:I
    .end local v21           #count:I
    .end local v26           #objectIndex:I
    .end local v27           #property:Landroid/mtp/MtpPropertyGroup$Property;
    .end local v28           #propertyIndex:I
    :cond_ec
    invoke-interface/range {v19 .. v19}, Landroid/database/Cursor;->getCount()I

    move-result v21

    goto :goto_94

    .line 353
    .restart local v7       #result:Landroid/mtp/MtpPropertyList;
    .restart local v9       #propertyCode:I
    .restart local v20       #column:I
    .restart local v21       #count:I
    .restart local v26       #objectIndex:I
    .restart local v27       #property:Landroid/mtp/MtpPropertyGroup$Property;
    .restart local v28       #propertyIndex:I
    :sswitch_f1
    const/4 v10, 0x4

    const-wide/16 v11, 0x0

    move/from16 v8, p1

    invoke-virtual/range {v7 .. v12}, Landroid/mtp/MtpPropertyList;->append(IIIJ)V
    :try_end_f9
    .catchall {:try_start_94 .. :try_end_f9} :catchall_117
    .catch Landroid/os/RemoteException; {:try_start_94 .. :try_end_f9} :catch_fa

    goto :goto_e9

    .line 437
    .end local v7           #result:Landroid/mtp/MtpPropertyList;
    .end local v9           #propertyCode:I
    .end local v20           #column:I
    .end local v21           #count:I
    .end local v26           #objectIndex:I
    .end local v27           #property:Landroid/mtp/MtpPropertyGroup$Property;
    .end local v28           #propertyIndex:I
    :catch_fa
    move-exception v23

    .line 438
    .local v23, e:Landroid/os/RemoteException;
    :try_start_fb
    new-instance v7, Landroid/mtp/MtpPropertyList;

    const/4 v2, 0x0

    const/16 v3, 0x2002

    invoke-direct {v7, v2, v3}, Landroid/mtp/MtpPropertyList;-><init>(II)V
    :try_end_103
    .catchall {:try_start_fb .. :try_end_103} :catchall_117

    .line 440
    if-eqz v19, :cond_e

    goto/16 :goto_47

    .line 357
    .end local v23           #e:Landroid/os/RemoteException;
    .restart local v7       #result:Landroid/mtp/MtpPropertyList;
    .restart local v9       #propertyCode:I
    .restart local v20       #column:I
    .restart local v21       #count:I
    .restart local v26       #objectIndex:I
    .restart local v27       #property:Landroid/mtp/MtpPropertyGroup$Property;
    .restart local v28       #propertyIndex:I
    :sswitch_107
    :try_start_107
    invoke-interface/range {v19 .. v20}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v29

    .line 358
    .local v29, value:Ljava/lang/String;
    if-eqz v29, :cond_11e

    .line 359
    invoke-static/range {v29 .. v29}, Landroid/mtp/MtpPropertyGroup;->nameFromPath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move/from16 v0, p1

    invoke-virtual {v7, v0, v9, v2}, Landroid/mtp/MtpPropertyList;->append(IILjava/lang/String;)V
    :try_end_116
    .catchall {:try_start_107 .. :try_end_116} :catchall_117
    .catch Landroid/os/RemoteException; {:try_start_107 .. :try_end_116} :catch_fa

    goto :goto_e9

    .line 440
    .end local v7           #result:Landroid/mtp/MtpPropertyList;
    .end local v9           #propertyCode:I
    .end local v20           #column:I
    .end local v21           #count:I
    .end local v26           #objectIndex:I
    .end local v27           #property:Landroid/mtp/MtpPropertyGroup$Property;
    .end local v28           #propertyIndex:I
    .end local v29           #value:Ljava/lang/String;
    :catchall_117
    move-exception v2

    if-eqz v19, :cond_11d

    .line 441
    invoke-interface/range {v19 .. v19}, Landroid/database/Cursor;->close()V

    .line 440
    :cond_11d
    throw v2

    .line 361
    .restart local v7       #result:Landroid/mtp/MtpPropertyList;
    .restart local v9       #propertyCode:I
    .restart local v20       #column:I
    .restart local v21       #count:I
    .restart local v26       #objectIndex:I
    .restart local v27       #property:Landroid/mtp/MtpPropertyGroup$Property;
    .restart local v28       #propertyIndex:I
    .restart local v29       #value:Ljava/lang/String;
    :cond_11e
    const/16 v2, 0x2009

    :try_start_120
    invoke-virtual {v7, v2}, Landroid/mtp/MtpPropertyList;->setResult(I)V

    goto :goto_e9

    .line 366
    .end local v29           #value:Ljava/lang/String;
    :sswitch_124
    invoke-interface/range {v19 .. v20}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v25

    .line 368
    .local v25, name:Ljava/lang/String;
    if-nez v25, :cond_135

    .line 369
    const-string/jumbo v2, "name"

    move-object/from16 v0, p0

    move/from16 v1, p1

    invoke-direct {v0, v1, v2}, Landroid/mtp/MtpPropertyGroup;->queryString(ILjava/lang/String;)Ljava/lang/String;

    move-result-object v25

    .line 372
    :cond_135
    if-nez v25, :cond_147

    .line 373
    const-string v2, "_data"

    move-object/from16 v0, p0

    move/from16 v1, p1

    invoke-direct {v0, v1, v2}, Landroid/mtp/MtpPropertyGroup;->queryString(ILjava/lang/String;)Ljava/lang/String;

    move-result-object v25

    .line 374
    if-eqz v25, :cond_147

    .line 375
    invoke-static/range {v25 .. v25}, Landroid/mtp/MtpPropertyGroup;->nameFromPath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v25

    .line 378
    :cond_147
    if-eqz v25, :cond_151

    .line 379
    move/from16 v0, p1

    move-object/from16 v1, v25

    invoke-virtual {v7, v0, v9, v1}, Landroid/mtp/MtpPropertyList;->append(IILjava/lang/String;)V

    goto :goto_e9

    .line 381
    :cond_151
    const/16 v2, 0x2009

    invoke-virtual {v7, v2}, Landroid/mtp/MtpPropertyList;->setResult(I)V

    goto :goto_e9

    .line 387
    .end local v25           #name:Ljava/lang/String;
    :sswitch_157
    invoke-interface/range {v19 .. v20}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    int-to-long v2, v2

    move-object/from16 v0, p0

    invoke-direct {v0, v2, v3}, Landroid/mtp/MtpPropertyGroup;->format_date_time(J)Ljava/lang/String;

    move-result-object v2

    move/from16 v0, p1

    invoke-virtual {v7, v0, v9, v2}, Landroid/mtp/MtpPropertyList;->append(IILjava/lang/String;)V

    goto :goto_e9

    .line 391
    :sswitch_168
    invoke-interface/range {v19 .. v20}, Landroid/database/Cursor;->getInt(I)I

    move-result v30

    .line 392
    .local v30, year:I
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static/range {v30 .. v30}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "0101T000000"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    .line 393
    .local v22, dateTime:Ljava/lang/String;
    move/from16 v0, p1

    move-object/from16 v1, v22

    invoke-virtual {v7, v0, v9, v1}, Landroid/mtp/MtpPropertyList;->append(IILjava/lang/String;)V

    goto/16 :goto_e9

    .line 397
    .end local v22           #dateTime:Ljava/lang/String;
    .end local v30           #year:I
    :sswitch_18c
    invoke-interface/range {v19 .. v20}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v11

    .line 398
    .local v11, puid:J
    const/16 v2, 0x20

    shl-long/2addr v11, v2

    .line 399
    move/from16 v0, p1

    int-to-long v2, v0

    add-long/2addr v11, v2

    .line 400
    const/16 v10, 0xa

    move/from16 v8, p1

    invoke-virtual/range {v7 .. v12}, Landroid/mtp/MtpPropertyList;->append(IIIJ)V

    goto/16 :goto_e9

    .line 403
    .end local v11           #puid:J
    :sswitch_1a0
    const/16 v16, 0x4

    invoke-interface/range {v19 .. v20}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    rem-int/lit16 v2, v2, 0x3e8

    int-to-long v0, v2

    move-wide/from16 v17, v0

    move-object v13, v7

    move/from16 v14, p1

    move v15, v9

    invoke-virtual/range {v13 .. v18}, Landroid/mtp/MtpPropertyList;->append(IIIJ)V

    goto/16 :goto_e9

    .line 407
    :sswitch_1b4
    const-string v2, "artist"

    move-object/from16 v0, p0

    move/from16 v1, p1

    invoke-direct {v0, v1, v2}, Landroid/mtp/MtpPropertyGroup;->queryAudio(ILjava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move/from16 v0, p1

    invoke-virtual {v7, v0, v9, v2}, Landroid/mtp/MtpPropertyList;->append(IILjava/lang/String;)V

    goto/16 :goto_e9

    .line 411
    :sswitch_1c5
    const-string v2, "album"

    move-object/from16 v0, p0

    move/from16 v1, p1

    invoke-direct {v0, v1, v2}, Landroid/mtp/MtpPropertyGroup;->queryAudio(ILjava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move/from16 v0, p1

    invoke-virtual {v7, v0, v9, v2}, Landroid/mtp/MtpPropertyList;->append(IILjava/lang/String;)V

    goto/16 :goto_e9

    .line 415
    :sswitch_1d6
    invoke-direct/range {p0 .. p1}, Landroid/mtp/MtpPropertyGroup;->queryGenre(I)Ljava/lang/String;

    move-result-object v24

    .line 416
    .local v24, genre:Ljava/lang/String;
    if-eqz v24, :cond_1e5

    .line 417
    move/from16 v0, p1

    move-object/from16 v1, v24

    invoke-virtual {v7, v0, v9, v1}, Landroid/mtp/MtpPropertyList;->append(IILjava/lang/String;)V

    goto/16 :goto_e9

    .line 419
    :cond_1e5
    const/16 v2, 0x2009

    invoke-virtual {v7, v2}, Landroid/mtp/MtpPropertyList;->setResult(I)V

    goto/16 :goto_e9

    .line 425
    .end local v24           #genre:Ljava/lang/String;
    :cond_1ec
    move-object/from16 v0, v27

    iget v2, v0, Landroid/mtp/MtpPropertyGroup$Property;->type:I

    if-nez v2, :cond_203

    .line 426
    move-object/from16 v0, v27

    iget v0, v0, Landroid/mtp/MtpPropertyGroup$Property;->type:I

    move/from16 v16, v0

    const-wide/16 v17, 0x0

    move-object v13, v7

    move/from16 v14, p1

    move v15, v9

    invoke-virtual/range {v13 .. v18}, Landroid/mtp/MtpPropertyList;->append(IIIJ)V

    goto/16 :goto_e9

    .line 428
    :cond_203
    move-object/from16 v0, v27

    iget v0, v0, Landroid/mtp/MtpPropertyGroup$Property;->type:I

    move/from16 v16, v0

    invoke-interface/range {v19 .. v20}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v17

    move-object v13, v7

    move/from16 v14, p1

    move v15, v9

    invoke-virtual/range {v13 .. v18}, Landroid/mtp/MtpPropertyList;->append(IIIJ)V
    :try_end_214
    .catchall {:try_start_120 .. :try_end_214} :catchall_117
    .catch Landroid/os/RemoteException; {:try_start_120 .. :try_end_214} :catch_fa

    goto/16 :goto_e9

    .line 337
    .end local v9           #propertyCode:I
    .end local v20           #column:I
    .end local v27           #property:Landroid/mtp/MtpPropertyGroup$Property;
    :cond_216
    add-int/lit8 v26, v26, 0x1

    goto/16 :goto_a4

    .line 440
    .end local v28           #propertyIndex:I
    :cond_21a
    if-eqz v19, :cond_e

    goto/16 :goto_47

    .line 350
    :sswitch_data_21e
    .sparse-switch
        0xdc03 -> :sswitch_f1
        0xdc07 -> :sswitch_107
        0xdc09 -> :sswitch_157
        0xdc41 -> :sswitch_18c
        0xdc44 -> :sswitch_124
        0xdc46 -> :sswitch_1b4
        0xdc4e -> :sswitch_157
        0xdc8b -> :sswitch_1a0
        0xdc8c -> :sswitch_1d6
        0xdc99 -> :sswitch_168
        0xdc9a -> :sswitch_1c5
    .end sparse-switch
.end method
