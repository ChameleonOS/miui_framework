.class public Landroid/app/backup/FullBackup;
.super Ljava/lang/Object;
.source "FullBackup.java"


# static fields
.field public static final APK_TREE_TOKEN:Ljava/lang/String; = "a"

.field public static final APPS_PREFIX:Ljava/lang/String; = "apps/"

.field public static final CACHE_TREE_TOKEN:Ljava/lang/String; = "c"

.field public static final CONF_TOKEN_INTENT_EXTRA:Ljava/lang/String; = "conftoken"

.field public static final DATABASE_TREE_TOKEN:Ljava/lang/String; = "db"

.field public static final DATA_TREE_TOKEN:Ljava/lang/String; = "f"

.field public static final FULL_BACKUP_INTENT_ACTION:Ljava/lang/String; = "fullback"

.field public static final FULL_RESTORE_INTENT_ACTION:Ljava/lang/String; = "fullrest"

.field public static final OBB_TREE_TOKEN:Ljava/lang/String; = "obb"

.field public static final ROOT_TREE_TOKEN:Ljava/lang/String; = "r"

.field public static final SHAREDPREFS_TREE_TOKEN:Ljava/lang/String; = "sp"

.field public static final SHARED_PREFIX:Ljava/lang/String; = "shared/"

.field public static final SHARED_STORAGE_TOKEN:Ljava/lang/String; = "shared"

.field static final TAG:Ljava/lang/String; = "FullBackup"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 40
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static native backupToTar(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/app/backup/BackupDataOutput;)I
.end method

.method public static restoreFile(Landroid/os/ParcelFileDescriptor;JIJJLjava/io/File;)V
    .registers 26
    .parameter "data"
    .parameter "size"
    .parameter "type"
    .parameter "mode"
    .parameter "mtime"
    .parameter "outFile"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 93
    const/4 v13, 0x2

    move/from16 v0, p3

    if-ne v0, v13, :cond_26

    .line 97
    if-eqz p8, :cond_a

    invoke-virtual/range {p8 .. p8}, Ljava/io/File;->mkdirs()Z

    .line 147
    :cond_a
    :goto_a
    const-wide/16 v13, 0x0

    cmp-long v13, p4, v13

    if-ltz v13, :cond_25

    if-eqz p8, :cond_25

    .line 149
    :try_start_12
    sget-object v13, Llibcore/io/Libcore;->os:Llibcore/io/Os;

    invoke-virtual/range {p8 .. p8}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v14

    move-wide/from16 v0, p4

    long-to-int v15, v0

    invoke-interface {v13, v14, v15}, Llibcore/io/Os;->chmod(Ljava/lang/String;I)V
    :try_end_1e
    .catch Llibcore/io/ErrnoException; {:try_start_12 .. :try_end_1e} :catch_e0

    .line 153
    :goto_1e
    move-object/from16 v0, p8

    move-wide/from16 v1, p6

    invoke-virtual {v0, v1, v2}, Ljava/io/File;->setLastModified(J)Z

    .line 155
    :cond_25
    return-void

    .line 99
    :cond_26
    const/4 v9, 0x0

    .line 103
    .local v9, out:Ljava/io/FileOutputStream;
    if-eqz p8, :cond_3e

    .line 104
    :try_start_29
    invoke-virtual/range {p8 .. p8}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v11

    .line 105
    .local v11, parent:Ljava/io/File;
    invoke-virtual {v11}, Ljava/io/File;->exists()Z

    move-result v13

    if-nez v13, :cond_36

    .line 110
    invoke-virtual {v11}, Ljava/io/File;->mkdirs()Z

    .line 112
    :cond_36
    new-instance v10, Ljava/io/FileOutputStream;

    move-object/from16 v0, p8

    invoke-direct {v10, v0}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    :try_end_3d
    .catch Ljava/io/IOException; {:try_start_29 .. :try_end_3d} :catch_8f

    .end local v9           #out:Ljava/io/FileOutputStream;
    .local v10, out:Ljava/io/FileOutputStream;
    move-object v9, v10

    .line 118
    .end local v10           #out:Ljava/io/FileOutputStream;
    .end local v11           #parent:Ljava/io/File;
    .restart local v9       #out:Ljava/io/FileOutputStream;
    :cond_3e
    :goto_3e
    const v13, 0x8000

    new-array v3, v13, [B

    .line 119
    .local v3, buffer:[B
    move-wide/from16 v7, p1

    .line 120
    .local v7, origSize:J
    new-instance v6, Ljava/io/FileInputStream;

    invoke-virtual/range {p0 .. p0}, Landroid/os/ParcelFileDescriptor;->getFileDescriptor()Ljava/io/FileDescriptor;

    move-result-object v13

    invoke-direct {v6, v13}, Ljava/io/FileInputStream;-><init>(Ljava/io/FileDescriptor;)V

    .line 121
    .local v6, in:Ljava/io/FileInputStream;
    :goto_4e
    const-wide/16 v13, 0x0

    cmp-long v13, p1, v13

    if-lez v13, :cond_88

    .line 122
    array-length v13, v3

    int-to-long v13, v13

    cmp-long v13, p1, v13

    if-lez v13, :cond_ad

    array-length v12, v3

    .line 123
    .local v12, toRead:I
    :goto_5b
    const/4 v13, 0x0

    invoke-virtual {v6, v3, v13, v12}, Ljava/io/FileInputStream;->read([BII)I

    move-result v5

    .line 124
    .local v5, got:I
    if-gtz v5, :cond_b1

    .line 125
    const-string v13, "FullBackup"

    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    const-string v15, "Incomplete read: expected "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    move-wide/from16 v0, p1

    invoke-virtual {v14, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v14

    const-string v15, " but got "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    sub-long v15, v7, p1

    invoke-virtual/range {v14 .. v16}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-static {v13, v14}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 143
    .end local v5           #got:I
    .end local v12           #toRead:I
    :cond_88
    if-eqz v9, :cond_a

    invoke-virtual {v9}, Ljava/io/FileOutputStream;->close()V

    goto/16 :goto_a

    .line 114
    .end local v3           #buffer:[B
    .end local v6           #in:Ljava/io/FileInputStream;
    .end local v7           #origSize:J
    :catch_8f
    move-exception v4

    .line 115
    .local v4, e:Ljava/io/IOException;
    const-string v13, "FullBackup"

    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    const-string v15, "Unable to create/open file "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual/range {p8 .. p8}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-static {v13, v14, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_3e

    .line 122
    .end local v4           #e:Ljava/io/IOException;
    .restart local v3       #buffer:[B
    .restart local v6       #in:Ljava/io/FileInputStream;
    .restart local v7       #origSize:J
    :cond_ad
    move-wide/from16 v0, p1

    long-to-int v12, v0

    goto :goto_5b

    .line 129
    .restart local v5       #got:I
    .restart local v12       #toRead:I
    :cond_b1
    if-eqz v9, :cond_b7

    .line 131
    const/4 v13, 0x0

    :try_start_b4
    invoke-virtual {v9, v3, v13, v5}, Ljava/io/FileOutputStream;->write([BII)V
    :try_end_b7
    .catch Ljava/io/IOException; {:try_start_b4 .. :try_end_b7} :catch_bb

    .line 141
    :cond_b7
    :goto_b7
    int-to-long v13, v5

    sub-long p1, p1, v13

    .line 142
    goto :goto_4e

    .line 132
    :catch_bb
    move-exception v4

    .line 135
    .restart local v4       #e:Ljava/io/IOException;
    const-string v13, "FullBackup"

    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    const-string v15, "Unable to write to file "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual/range {p8 .. p8}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-static {v13, v14, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 136
    invoke-virtual {v9}, Ljava/io/FileOutputStream;->close()V

    .line 137
    const/4 v9, 0x0

    .line 138
    invoke-virtual/range {p8 .. p8}, Ljava/io/File;->delete()Z

    goto :goto_b7

    .line 150
    .end local v3           #buffer:[B
    .end local v4           #e:Ljava/io/IOException;
    .end local v5           #got:I
    .end local v6           #in:Ljava/io/FileInputStream;
    .end local v7           #origSize:J
    .end local v9           #out:Ljava/io/FileOutputStream;
    .end local v12           #toRead:I
    :catch_e0
    move-exception v4

    .line 151
    .local v4, e:Llibcore/io/ErrnoException;
    invoke-virtual {v4}, Llibcore/io/ErrnoException;->rethrowAsIOException()Ljava/io/IOException;

    goto/16 :goto_1e
.end method
