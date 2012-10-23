.class public final Landroid/provider/DrmStore;
.super Ljava/lang/Object;
.source "DrmStore.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/provider/DrmStore$Audio;,
        Landroid/provider/DrmStore$Images;,
        Landroid/provider/DrmStore$Columns;
    }
.end annotation


# static fields
.field private static final ACCESS_DRM_PERMISSION:Ljava/lang/String; = "android.permission.ACCESS_DRM"

.field public static final AUTHORITY:Ljava/lang/String; = "drm"

.field private static final TAG:Ljava/lang/String; = "DrmStore"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 41
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 89
    return-void
.end method

.method public static final addDrmFile(Landroid/content/ContentResolver;Ljava/io/File;Ljava/lang/String;)Landroid/content/Intent;
    .registers 11
    .parameter "cr"
    .parameter "file"
    .parameter "title"

    .prologue
    .line 103
    const/4 v1, 0x0

    .line 104
    .local v1, fis:Ljava/io/FileInputStream;
    const/4 v4, 0x0

    .line 107
    .local v4, result:Landroid/content/Intent;
    :try_start_2
    new-instance v2, Ljava/io/FileInputStream;

    invoke-direct {v2, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    :try_end_7
    .catchall {:try_start_2 .. :try_end_7} :catchall_47
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_7} :catch_2f

    .line 108
    .end local v1           #fis:Ljava/io/FileInputStream;
    .local v2, fis:Ljava/io/FileInputStream;
    if-nez p2, :cond_1a

    .line 109
    :try_start_9
    invoke-virtual {p1}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object p2

    .line 110
    const/16 v5, 0x2e

    invoke-virtual {p2, v5}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v3

    .line 111
    .local v3, lastDot:I
    if-lez v3, :cond_1a

    .line 112
    const/4 v5, 0x0

    invoke-virtual {p2, v5, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p2

    .line 115
    .end local v3           #lastDot:I
    :cond_1a
    invoke-static {p0, v2, p2}, Landroid/provider/DrmStore;->addDrmFile(Landroid/content/ContentResolver;Ljava/io/FileInputStream;Ljava/lang/String;)Landroid/content/Intent;
    :try_end_1d
    .catchall {:try_start_9 .. :try_end_1d} :catchall_57
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_1d} :catch_5a

    move-result-object v4

    .line 120
    if-eqz v2, :cond_23

    .line 121
    :try_start_20
    invoke-virtual {v2}, Ljava/io/FileInputStream;->close()V
    :try_end_23
    .catch Ljava/io/IOException; {:try_start_20 .. :try_end_23} :catch_25

    :cond_23
    move-object v1, v2

    .line 127
    .end local v2           #fis:Ljava/io/FileInputStream;
    .restart local v1       #fis:Ljava/io/FileInputStream;
    :cond_24
    :goto_24
    return-object v4

    .line 122
    .end local v1           #fis:Ljava/io/FileInputStream;
    .restart local v2       #fis:Ljava/io/FileInputStream;
    :catch_25
    move-exception v0

    .line 123
    .local v0, e:Ljava/io/IOException;
    const-string v5, "DrmStore"

    const-string v6, "IOException in DrmStore.addDrmFile()"

    invoke-static {v5, v6, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    move-object v1, v2

    .line 125
    .end local v2           #fis:Ljava/io/FileInputStream;
    .restart local v1       #fis:Ljava/io/FileInputStream;
    goto :goto_24

    .line 116
    .end local v0           #e:Ljava/io/IOException;
    :catch_2f
    move-exception v0

    .line 117
    .local v0, e:Ljava/lang/Exception;
    :goto_30
    :try_start_30
    const-string v5, "DrmStore"

    const-string/jumbo v6, "pushing file failed"

    invoke-static {v5, v6, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_38
    .catchall {:try_start_30 .. :try_end_38} :catchall_47

    .line 120
    if-eqz v1, :cond_24

    .line 121
    :try_start_3a
    invoke-virtual {v1}, Ljava/io/FileInputStream;->close()V
    :try_end_3d
    .catch Ljava/io/IOException; {:try_start_3a .. :try_end_3d} :catch_3e

    goto :goto_24

    .line 122
    :catch_3e
    move-exception v0

    .line 123
    .local v0, e:Ljava/io/IOException;
    const-string v5, "DrmStore"

    const-string v6, "IOException in DrmStore.addDrmFile()"

    invoke-static {v5, v6, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_24

    .line 119
    .end local v0           #e:Ljava/io/IOException;
    :catchall_47
    move-exception v5

    .line 120
    :goto_48
    if-eqz v1, :cond_4d

    .line 121
    :try_start_4a
    invoke-virtual {v1}, Ljava/io/FileInputStream;->close()V
    :try_end_4d
    .catch Ljava/io/IOException; {:try_start_4a .. :try_end_4d} :catch_4e

    .line 124
    :cond_4d
    :goto_4d
    throw v5

    .line 122
    :catch_4e
    move-exception v0

    .line 123
    .restart local v0       #e:Ljava/io/IOException;
    const-string v6, "DrmStore"

    const-string v7, "IOException in DrmStore.addDrmFile()"

    invoke-static {v6, v7, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_4d

    .line 119
    .end local v0           #e:Ljava/io/IOException;
    .end local v1           #fis:Ljava/io/FileInputStream;
    .restart local v2       #fis:Ljava/io/FileInputStream;
    :catchall_57
    move-exception v5

    move-object v1, v2

    .end local v2           #fis:Ljava/io/FileInputStream;
    .restart local v1       #fis:Ljava/io/FileInputStream;
    goto :goto_48

    .line 116
    .end local v1           #fis:Ljava/io/FileInputStream;
    .restart local v2       #fis:Ljava/io/FileInputStream;
    :catch_5a
    move-exception v0

    move-object v1, v2

    .end local v2           #fis:Ljava/io/FileInputStream;
    .restart local v1       #fis:Ljava/io/FileInputStream;
    goto :goto_30
.end method

.method public static final addDrmFile(Landroid/content/ContentResolver;Ljava/io/FileInputStream;Ljava/lang/String;)Landroid/content/Intent;
    .registers 25
    .parameter "cr"
    .parameter "fis"
    .parameter "title"

    .prologue
    .line 139
    const/4 v10, 0x0

    .line 140
    .local v10, os:Ljava/io/OutputStream;
    const/4 v11, 0x0

    .line 143
    .local v11, result:Landroid/content/Intent;
    :try_start_2
    new-instance v4, Landroid/drm/mobile1/DrmRawContent;

    invoke-virtual/range {p1 .. p1}, Ljava/io/FileInputStream;->available()I

    move-result v19

    const-string v20, "application/vnd.oma.drm.message"

    move-object/from16 v0, p1

    move/from16 v1, v19

    move-object/from16 v2, v20

    invoke-direct {v4, v0, v1, v2}, Landroid/drm/mobile1/DrmRawContent;-><init>(Ljava/io/InputStream;ILjava/lang/String;)V

    .line 145
    .local v4, content:Landroid/drm/mobile1/DrmRawContent;
    invoke-virtual {v4}, Landroid/drm/mobile1/DrmRawContent;->getContentType()Ljava/lang/String;

    move-result-object v9

    .line 146
    .local v9, mimeType:Ljava/lang/String;
    invoke-virtual/range {p1 .. p1}, Ljava/io/FileInputStream;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/nio/channels/FileChannel;->size()J

    move-result-wide v14

    .line 148
    .local v14, size:J
    invoke-static {}, Landroid/drm/mobile1/DrmRightsManager;->getInstance()Landroid/drm/mobile1/DrmRightsManager;

    move-result-object v8

    .line 149
    .local v8, manager:Landroid/drm/mobile1/DrmRightsManager;
    invoke-virtual {v8, v4}, Landroid/drm/mobile1/DrmRightsManager;->queryRights(Landroid/drm/mobile1/DrmRawContent;)Landroid/drm/mobile1/DrmRights;

    move-result-object v13

    .line 150
    .local v13, rights:Landroid/drm/mobile1/DrmRights;
    invoke-virtual {v4, v13}, Landroid/drm/mobile1/DrmRawContent;->getContentInputStream(Landroid/drm/mobile1/DrmRights;)Ljava/io/InputStream;

    move-result-object v16

    .line 152
    .local v16, stream:Ljava/io/InputStream;
    const/4 v5, 0x0

    .line 153
    .local v5, contentUri:Landroid/net/Uri;
    const-string v19, "audio/"

    move-object/from16 v0, v19

    invoke-virtual {v9, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_a4

    .line 154
    sget-object v5, Landroid/provider/DrmStore$Audio;->CONTENT_URI:Landroid/net/Uri;

    .line 161
    :goto_38
    if-eqz v5, :cond_e5

    .line 162
    new-instance v18, Landroid/content/ContentValues;

    const/16 v19, 0x3

    invoke-direct/range {v18 .. v19}, Landroid/content/ContentValues;-><init>(I)V

    .line 163
    .local v18, values:Landroid/content/ContentValues;
    const-string/jumbo v19, "title"

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    move-object/from16 v2, p2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 164
    const-string v19, "_size"

    invoke-static {v14, v15}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v20

    invoke-virtual/range {v18 .. v20}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 165
    const-string/jumbo v19, "mime_type"

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-virtual {v0, v1, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 167
    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-virtual {v0, v5, v1}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    move-result-object v17

    .line 168
    .local v17, uri:Landroid/net/Uri;
    if-eqz v17, :cond_e5

    .line 169
    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/content/ContentResolver;->openOutputStream(Landroid/net/Uri;)Ljava/io/OutputStream;

    move-result-object v10

    .line 171
    const/16 v19, 0x3e8

    move/from16 v0, v19

    new-array v3, v0, [B

    .line 174
    .local v3, buffer:[B
    :goto_78
    move-object/from16 v0, v16

    invoke-virtual {v0, v3}, Ljava/io/InputStream;->read([B)I

    move-result v6

    .local v6, count:I
    const/16 v19, -0x1

    move/from16 v0, v19

    if-eq v6, v0, :cond_da

    .line 175
    const/16 v19, 0x0

    move/from16 v0, v19

    invoke-virtual {v10, v3, v0, v6}, Ljava/io/OutputStream;->write([BII)V
    :try_end_8b
    .catchall {:try_start_2 .. :try_end_8b} :catchall_ce
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_8b} :catch_8c

    goto :goto_78

    .line 182
    .end local v3           #buffer:[B
    .end local v4           #content:Landroid/drm/mobile1/DrmRawContent;
    .end local v5           #contentUri:Landroid/net/Uri;
    .end local v6           #count:I
    .end local v8           #manager:Landroid/drm/mobile1/DrmRightsManager;
    .end local v9           #mimeType:Ljava/lang/String;
    .end local v13           #rights:Landroid/drm/mobile1/DrmRights;
    .end local v14           #size:J
    .end local v16           #stream:Ljava/io/InputStream;
    .end local v17           #uri:Landroid/net/Uri;
    .end local v18           #values:Landroid/content/ContentValues;
    :catch_8c
    move-exception v7

    .line 183
    .local v7, e:Ljava/lang/Exception;
    :goto_8d
    :try_start_8d
    const-string v19, "DrmStore"

    const-string/jumbo v20, "pushing file failed"

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-static {v0, v1, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_99
    .catchall {:try_start_8d .. :try_end_99} :catchall_ce

    .line 186
    if-eqz p1, :cond_9e

    .line 187
    :try_start_9b
    invoke-virtual/range {p1 .. p1}, Ljava/io/FileInputStream;->close()V

    .line 188
    :cond_9e
    if-eqz v10, :cond_a3

    .line 189
    invoke-virtual {v10}, Ljava/io/OutputStream;->close()V
    :try_end_a3
    .catch Ljava/io/IOException; {:try_start_9b .. :try_end_a3} :catch_fd

    .line 195
    .end local v7           #e:Ljava/lang/Exception;
    :cond_a3
    :goto_a3
    return-object v11

    .line 155
    .restart local v4       #content:Landroid/drm/mobile1/DrmRawContent;
    .restart local v5       #contentUri:Landroid/net/Uri;
    .restart local v8       #manager:Landroid/drm/mobile1/DrmRightsManager;
    .restart local v9       #mimeType:Ljava/lang/String;
    .restart local v13       #rights:Landroid/drm/mobile1/DrmRights;
    .restart local v14       #size:J
    .restart local v16       #stream:Ljava/io/InputStream;
    :cond_a4
    :try_start_a4
    const-string v19, "image/"

    move-object/from16 v0, v19

    invoke-virtual {v9, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_b1

    .line 156
    sget-object v5, Landroid/provider/DrmStore$Images;->CONTENT_URI:Landroid/net/Uri;

    goto :goto_38

    .line 158
    :cond_b1
    const-string v19, "DrmStore"

    new-instance v20, Ljava/lang/StringBuilder;

    invoke-direct/range {v20 .. v20}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v21, "unsupported mime type "

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v20

    invoke-static/range {v19 .. v20}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_cc
    .catchall {:try_start_a4 .. :try_end_cc} :catchall_ce
    .catch Ljava/lang/Exception; {:try_start_a4 .. :try_end_cc} :catch_8c

    goto/16 :goto_38

    .line 185
    .end local v4           #content:Landroid/drm/mobile1/DrmRawContent;
    .end local v5           #contentUri:Landroid/net/Uri;
    .end local v8           #manager:Landroid/drm/mobile1/DrmRightsManager;
    .end local v9           #mimeType:Ljava/lang/String;
    .end local v13           #rights:Landroid/drm/mobile1/DrmRights;
    .end local v14           #size:J
    .end local v16           #stream:Ljava/io/InputStream;
    :catchall_ce
    move-exception v19

    .line 186
    :goto_cf
    if-eqz p1, :cond_d4

    .line 187
    :try_start_d1
    invoke-virtual/range {p1 .. p1}, Ljava/io/FileInputStream;->close()V

    .line 188
    :cond_d4
    if-eqz v10, :cond_d9

    .line 189
    invoke-virtual {v10}, Ljava/io/OutputStream;->close()V
    :try_end_d9
    .catch Ljava/io/IOException; {:try_start_d1 .. :try_end_d9} :catch_10a

    .line 192
    :cond_d9
    :goto_d9
    throw v19

    .line 177
    .restart local v3       #buffer:[B
    .restart local v4       #content:Landroid/drm/mobile1/DrmRawContent;
    .restart local v5       #contentUri:Landroid/net/Uri;
    .restart local v6       #count:I
    .restart local v8       #manager:Landroid/drm/mobile1/DrmRightsManager;
    .restart local v9       #mimeType:Ljava/lang/String;
    .restart local v13       #rights:Landroid/drm/mobile1/DrmRights;
    .restart local v14       #size:J
    .restart local v16       #stream:Ljava/io/InputStream;
    .restart local v17       #uri:Landroid/net/Uri;
    .restart local v18       #values:Landroid/content/ContentValues;
    :cond_da
    :try_start_da
    new-instance v12, Landroid/content/Intent;

    invoke-direct {v12}, Landroid/content/Intent;-><init>()V
    :try_end_df
    .catchall {:try_start_da .. :try_end_df} :catchall_ce
    .catch Ljava/lang/Exception; {:try_start_da .. :try_end_df} :catch_8c

    .line 178
    .end local v11           #result:Landroid/content/Intent;
    .local v12, result:Landroid/content/Intent;
    :try_start_df
    move-object/from16 v0, v17

    invoke-virtual {v12, v0, v9}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;
    :try_end_e4
    .catchall {:try_start_df .. :try_end_e4} :catchall_117
    .catch Ljava/lang/Exception; {:try_start_df .. :try_end_e4} :catch_11a

    move-object v11, v12

    .line 186
    .end local v3           #buffer:[B
    .end local v6           #count:I
    .end local v12           #result:Landroid/content/Intent;
    .end local v17           #uri:Landroid/net/Uri;
    .end local v18           #values:Landroid/content/ContentValues;
    .restart local v11       #result:Landroid/content/Intent;
    :cond_e5
    if-eqz p1, :cond_ea

    .line 187
    :try_start_e7
    invoke-virtual/range {p1 .. p1}, Ljava/io/FileInputStream;->close()V

    .line 188
    :cond_ea
    if-eqz v10, :cond_a3

    .line 189
    invoke-virtual {v10}, Ljava/io/OutputStream;->close()V
    :try_end_ef
    .catch Ljava/io/IOException; {:try_start_e7 .. :try_end_ef} :catch_f0

    goto :goto_a3

    .line 190
    :catch_f0
    move-exception v7

    .line 191
    .local v7, e:Ljava/io/IOException;
    const-string v19, "DrmStore"

    const-string v20, "IOException in DrmStore.addDrmFile()"

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-static {v0, v1, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_a3

    .line 190
    .end local v4           #content:Landroid/drm/mobile1/DrmRawContent;
    .end local v5           #contentUri:Landroid/net/Uri;
    .end local v8           #manager:Landroid/drm/mobile1/DrmRightsManager;
    .end local v9           #mimeType:Ljava/lang/String;
    .end local v13           #rights:Landroid/drm/mobile1/DrmRights;
    .end local v14           #size:J
    .end local v16           #stream:Ljava/io/InputStream;
    .local v7, e:Ljava/lang/Exception;
    :catch_fd
    move-exception v7

    .line 191
    .local v7, e:Ljava/io/IOException;
    const-string v19, "DrmStore"

    const-string v20, "IOException in DrmStore.addDrmFile()"

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-static {v0, v1, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_a3

    .line 190
    .end local v7           #e:Ljava/io/IOException;
    :catch_10a
    move-exception v7

    .line 191
    .restart local v7       #e:Ljava/io/IOException;
    const-string v20, "DrmStore"

    const-string v21, "IOException in DrmStore.addDrmFile()"

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-static {v0, v1, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_d9

    .line 185
    .end local v7           #e:Ljava/io/IOException;
    .end local v11           #result:Landroid/content/Intent;
    .restart local v3       #buffer:[B
    .restart local v4       #content:Landroid/drm/mobile1/DrmRawContent;
    .restart local v5       #contentUri:Landroid/net/Uri;
    .restart local v6       #count:I
    .restart local v8       #manager:Landroid/drm/mobile1/DrmRightsManager;
    .restart local v9       #mimeType:Ljava/lang/String;
    .restart local v12       #result:Landroid/content/Intent;
    .restart local v13       #rights:Landroid/drm/mobile1/DrmRights;
    .restart local v14       #size:J
    .restart local v16       #stream:Ljava/io/InputStream;
    .restart local v17       #uri:Landroid/net/Uri;
    .restart local v18       #values:Landroid/content/ContentValues;
    :catchall_117
    move-exception v19

    move-object v11, v12

    .end local v12           #result:Landroid/content/Intent;
    .restart local v11       #result:Landroid/content/Intent;
    goto :goto_cf

    .line 182
    .end local v11           #result:Landroid/content/Intent;
    .restart local v12       #result:Landroid/content/Intent;
    :catch_11a
    move-exception v7

    move-object v11, v12

    .end local v12           #result:Landroid/content/Intent;
    .restart local v11       #result:Landroid/content/Intent;
    goto/16 :goto_8d
.end method

.method public static enforceAccessDrmPermission(Landroid/content/Context;)V
    .registers 3
    .parameter "context"

    .prologue
    .line 205
    const-string v0, "android.permission.ACCESS_DRM"

    invoke-virtual {p0, v0}, Landroid/content/Context;->checkCallingOrSelfPermission(Ljava/lang/String;)I

    move-result v0

    if-eqz v0, :cond_10

    .line 207
    new-instance v0, Ljava/lang/SecurityException;

    const-string v1, "Requires DRM permission"

    invoke-direct {v0, v1}, Ljava/lang/SecurityException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 209
    :cond_10
    return-void
.end method
