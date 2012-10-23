.class public Landroid/os/FileUtils;
.super Ljava/lang/Object;
.source "FileUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/os/FileUtils$FileStatus;
    }
.end annotation


# static fields
.field private static final SAFE_FILENAME_PATTERN:Ljava/util/regex/Pattern; = null

.field public static final S_IRGRP:I = 0x20

.field public static final S_IROTH:I = 0x4

.field public static final S_IRUSR:I = 0x100

.field public static final S_IRWXG:I = 0x38

.field public static final S_IRWXO:I = 0x7

.field public static final S_IRWXU:I = 0x1c0

.field public static final S_IWGRP:I = 0x10

.field public static final S_IWOTH:I = 0x2

.field public static final S_IWUSR:I = 0x80

.field public static final S_IXGRP:I = 0x8

.field public static final S_IXOTH:I = 0x1

.field public static final S_IXUSR:I = 0x40


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 95
    const-string v0, "[\\w%+,./=_-]+"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Landroid/os/FileUtils;->SAFE_FILENAME_PATTERN:Ljava/util/regex/Pattern;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 38
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 60
    return-void
.end method

.method public static checksumCrc32(Ljava/io/File;)J
    .registers 8
    .parameter "file"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/FileNotFoundException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 266
    new-instance v1, Ljava/util/zip/CRC32;

    invoke-direct {v1}, Ljava/util/zip/CRC32;-><init>()V

    .line 267
    .local v1, checkSummer:Ljava/util/zip/CRC32;
    const/4 v2, 0x0

    .line 270
    .local v2, cis:Ljava/util/zip/CheckedInputStream;
    :try_start_6
    new-instance v3, Ljava/util/zip/CheckedInputStream;

    new-instance v4, Ljava/io/FileInputStream;

    invoke-direct {v4, p0}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-direct {v3, v4, v1}, Ljava/util/zip/CheckedInputStream;-><init>(Ljava/io/InputStream;Ljava/util/zip/Checksum;)V
    :try_end_10
    .catchall {:try_start_6 .. :try_end_10} :catchall_24

    .line 271
    .end local v2           #cis:Ljava/util/zip/CheckedInputStream;
    .local v3, cis:Ljava/util/zip/CheckedInputStream;
    const/16 v4, 0x80

    :try_start_12
    new-array v0, v4, [B

    .line 272
    .local v0, buf:[B
    :cond_14
    invoke-virtual {v3, v0}, Ljava/util/zip/CheckedInputStream;->read([B)I

    move-result v4

    if-gez v4, :cond_14

    .line 275
    invoke-virtual {v1}, Ljava/util/zip/CRC32;->getValue()J
    :try_end_1d
    .catchall {:try_start_12 .. :try_end_1d} :catchall_2f

    move-result-wide v4

    .line 277
    if-eqz v3, :cond_23

    .line 279
    :try_start_20
    invoke-virtual {v3}, Ljava/util/zip/CheckedInputStream;->close()V
    :try_end_23
    .catch Ljava/io/IOException; {:try_start_20 .. :try_end_23} :catch_2b

    .line 281
    :cond_23
    :goto_23
    return-wide v4

    .line 277
    .end local v0           #buf:[B
    .end local v3           #cis:Ljava/util/zip/CheckedInputStream;
    .restart local v2       #cis:Ljava/util/zip/CheckedInputStream;
    :catchall_24
    move-exception v4

    :goto_25
    if-eqz v2, :cond_2a

    .line 279
    :try_start_27
    invoke-virtual {v2}, Ljava/util/zip/CheckedInputStream;->close()V
    :try_end_2a
    .catch Ljava/io/IOException; {:try_start_27 .. :try_end_2a} :catch_2d

    .line 281
    :cond_2a
    :goto_2a
    throw v4

    .line 280
    .end local v2           #cis:Ljava/util/zip/CheckedInputStream;
    .restart local v0       #buf:[B
    .restart local v3       #cis:Ljava/util/zip/CheckedInputStream;
    :catch_2b
    move-exception v6

    goto :goto_23

    .end local v0           #buf:[B
    .end local v3           #cis:Ljava/util/zip/CheckedInputStream;
    .restart local v2       #cis:Ljava/util/zip/CheckedInputStream;
    :catch_2d
    move-exception v5

    goto :goto_2a

    .line 277
    .end local v2           #cis:Ljava/util/zip/CheckedInputStream;
    .restart local v3       #cis:Ljava/util/zip/CheckedInputStream;
    :catchall_2f
    move-exception v4

    move-object v2, v3

    .end local v3           #cis:Ljava/util/zip/CheckedInputStream;
    .restart local v2       #cis:Ljava/util/zip/CheckedInputStream;
    goto :goto_25
.end method

.method public static copyFile(Ljava/io/File;Ljava/io/File;)Z
    .registers 6
    .parameter "srcFile"
    .parameter "destFile"

    .prologue
    .line 132
    const/4 v2, 0x0

    .line 134
    .local v2, result:Z
    :try_start_1
    new-instance v1, Ljava/io/FileInputStream;

    invoke-direct {v1, p0}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_6} :catch_13

    .line 136
    .local v1, in:Ljava/io/InputStream;
    :try_start_6
    invoke-static {v1, p1}, Landroid/os/FileUtils;->copyToFile(Ljava/io/InputStream;Ljava/io/File;)Z
    :try_end_9
    .catchall {:try_start_6 .. :try_end_9} :catchall_e

    move-result v2

    .line 138
    :try_start_a
    invoke-virtual {v1}, Ljava/io/FileInputStream;->close()V

    .line 143
    .end local v1           #in:Ljava/io/InputStream;
    :goto_d
    return v2

    .line 138
    .restart local v1       #in:Ljava/io/InputStream;
    :catchall_e
    move-exception v3

    invoke-virtual {v1}, Ljava/io/FileInputStream;->close()V

    throw v3
    :try_end_13
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_13} :catch_13

    .line 140
    .end local v1           #in:Ljava/io/InputStream;
    :catch_13
    move-exception v0

    .line 141
    .local v0, e:Ljava/io/IOException;
    const/4 v2, 0x0

    goto :goto_d
.end method

.method public static copyToFile(Ljava/io/InputStream;Ljava/io/File;)Z
    .registers 9
    .parameter "inputStream"
    .parameter "destFile"

    .prologue
    const/4 v4, 0x0

    .line 152
    :try_start_1
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v5

    if-eqz v5, :cond_a

    .line 153
    invoke-virtual {p1}, Ljava/io/File;->delete()Z

    .line 155
    :cond_a
    new-instance v3, Ljava/io/FileOutputStream;

    invoke-direct {v3, p1}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    :try_end_f
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_f} :catch_2d

    .line 157
    .local v3, out:Ljava/io/FileOutputStream;
    const/16 v5, 0x1000

    :try_start_11
    new-array v0, v5, [B

    .line 159
    .local v0, buffer:[B
    :goto_13
    invoke-virtual {p0, v0}, Ljava/io/InputStream;->read([B)I

    move-result v1

    .local v1, bytesRead:I
    if-ltz v1, :cond_2f

    .line 160
    const/4 v5, 0x0

    invoke-virtual {v3, v0, v5, v1}, Ljava/io/FileOutputStream;->write([BII)V
    :try_end_1d
    .catchall {:try_start_11 .. :try_end_1d} :catchall_1e

    goto :goto_13

    .line 163
    .end local v0           #buffer:[B
    .end local v1           #bytesRead:I
    :catchall_1e
    move-exception v5

    :try_start_1f
    invoke-virtual {v3}, Ljava/io/FileOutputStream;->flush()V
    :try_end_22
    .catch Ljava/io/IOException; {:try_start_1f .. :try_end_22} :catch_2d

    .line 165
    :try_start_22
    invoke-virtual {v3}, Ljava/io/FileOutputStream;->getFD()Ljava/io/FileDescriptor;

    move-result-object v6

    invoke-virtual {v6}, Ljava/io/FileDescriptor;->sync()V
    :try_end_29
    .catch Ljava/io/IOException; {:try_start_22 .. :try_end_29} :catch_3e

    .line 168
    :goto_29
    :try_start_29
    invoke-virtual {v3}, Ljava/io/FileOutputStream;->close()V

    throw v5

    .line 171
    .end local v3           #out:Ljava/io/FileOutputStream;
    :catch_2d
    move-exception v2

    .line 172
    :goto_2e
    return v4

    .line 163
    .restart local v0       #buffer:[B
    .restart local v1       #bytesRead:I
    .restart local v3       #out:Ljava/io/FileOutputStream;
    :cond_2f
    invoke-virtual {v3}, Ljava/io/FileOutputStream;->flush()V
    :try_end_32
    .catch Ljava/io/IOException; {:try_start_29 .. :try_end_32} :catch_2d

    .line 165
    :try_start_32
    invoke-virtual {v3}, Ljava/io/FileOutputStream;->getFD()Ljava/io/FileDescriptor;

    move-result-object v5

    invoke-virtual {v5}, Ljava/io/FileDescriptor;->sync()V
    :try_end_39
    .catch Ljava/io/IOException; {:try_start_32 .. :try_end_39} :catch_40

    .line 168
    :goto_39
    :try_start_39
    invoke-virtual {v3}, Ljava/io/FileOutputStream;->close()V
    :try_end_3c
    .catch Ljava/io/IOException; {:try_start_39 .. :try_end_3c} :catch_2d

    .line 170
    const/4 v4, 0x1

    goto :goto_2e

    .line 166
    .end local v0           #buffer:[B
    .end local v1           #bytesRead:I
    :catch_3e
    move-exception v6

    goto :goto_29

    .restart local v0       #buffer:[B
    .restart local v1       #bytesRead:I
    :catch_40
    move-exception v5

    goto :goto_39
.end method

.method public static native getFatVolumeId(Ljava/lang/String;)I
.end method

.method public static getFileStatus(Ljava/lang/String;Landroid/os/FileUtils$FileStatus;)Z
    .registers 3
    .parameter "path"
    .parameter "status"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 88
    invoke-static {}, Landroid/os/StrictMode;->noteDiskRead()V

    .line 89
    invoke-static {p0, p1}, Landroid/os/FileUtils;->getFileStatusNative(Ljava/lang/String;Landroid/os/FileUtils$FileStatus;)Z

    move-result v0

    return v0
.end method

.method private static native getFileStatusNative(Ljava/lang/String;Landroid/os/FileUtils$FileStatus;)Z
.end method

.method public static native getPermissions(Ljava/lang/String;[I)I
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public static isFilenameSafe(Ljava/io/File;)Z
    .registers 3
    .parameter "file"

    .prologue
    .line 184
    sget-object v0, Landroid/os/FileUtils;->SAFE_FILENAME_PATTERN:Ljava/util/regex/Pattern;

    invoke-virtual {p0}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/regex/Matcher;->matches()Z

    move-result v0

    return v0
.end method

.method public static readTextFile(Ljava/io/File;ILjava/lang/String;)Ljava/lang/String;
    .registers 16
    .parameter "file"
    .parameter "max"
    .parameter "ellipsis"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const-wide/16 v11, 0x0

    .line 196
    new-instance v2, Ljava/io/FileInputStream;

    invoke-direct {v2, p0}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 198
    .local v2, input:Ljava/io/InputStream;
    :try_start_7
    invoke-virtual {p0}, Ljava/io/File;->length()J

    move-result-wide v7

    .line 199
    .local v7, size:J
    if-gtz p1, :cond_13

    cmp-long v10, v7, v11

    if-lez v10, :cond_62

    if-nez p1, :cond_62

    .line 200
    :cond_13
    cmp-long v10, v7, v11

    if-lez v10, :cond_1f

    if-eqz p1, :cond_1e

    int-to-long v10, p1

    cmp-long v10, v7, v10

    if-gez v10, :cond_1f

    :cond_1e
    long-to-int p1, v7

    .line 201
    :cond_1f
    add-int/lit8 v10, p1, 0x1

    new-array v1, v10, [B

    .line 202
    .local v1, data:[B
    invoke-virtual {v2, v1}, Ljava/io/FileInputStream;->read([B)I

    move-result v5

    .line 203
    .local v5, length:I
    if-gtz v5, :cond_2f

    const-string v10, ""
    :try_end_2b
    .catchall {:try_start_7 .. :try_end_2b} :catchall_e5

    .line 238
    invoke-virtual {v2}, Ljava/io/FileInputStream;->close()V

    .end local v5           #length:I
    :goto_2e
    return-object v10

    .line 204
    .restart local v5       #length:I
    :cond_2f
    if-gt v5, p1, :cond_3b

    :try_start_31
    new-instance v10, Ljava/lang/String;

    const/4 v11, 0x0

    invoke-direct {v10, v1, v11, v5}, Ljava/lang/String;-><init>([BII)V
    :try_end_37
    .catchall {:try_start_31 .. :try_end_37} :catchall_e5

    .line 238
    invoke-virtual {v2}, Ljava/io/FileInputStream;->close()V

    goto :goto_2e

    .line 205
    :cond_3b
    if-nez p2, :cond_47

    :try_start_3d
    new-instance v10, Ljava/lang/String;

    const/4 v11, 0x0

    invoke-direct {v10, v1, v11, p1}, Ljava/lang/String;-><init>([BII)V
    :try_end_43
    .catchall {:try_start_3d .. :try_end_43} :catchall_e5

    .line 238
    invoke-virtual {v2}, Ljava/io/FileInputStream;->close()V

    goto :goto_2e

    .line 206
    :cond_47
    :try_start_47
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    new-instance v11, Ljava/lang/String;

    const/4 v12, 0x0

    invoke-direct {v11, v1, v12, p1}, Ljava/lang/String;-><init>([BII)V

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_5d
    .catchall {:try_start_47 .. :try_end_5d} :catchall_e5

    move-result-object v10

    .line 238
    invoke-virtual {v2}, Ljava/io/FileInputStream;->close()V

    goto :goto_2e

    .line 207
    .end local v1           #data:[B
    .end local v5           #length:I
    :cond_62
    if-gez p1, :cond_c6

    .line 209
    const/4 v6, 0x0

    .line 210
    .local v6, rolled:Z
    const/4 v3, 0x0

    .local v3, last:[B
    const/4 v1, 0x0

    .line 212
    .restart local v1       #data:[B
    :cond_67
    if-eqz v3, :cond_6a

    const/4 v6, 0x1

    .line 213
    :cond_6a
    move-object v9, v3

    .local v9, tmp:[B
    move-object v3, v1

    move-object v1, v9

    .line 214
    if-nez v1, :cond_72

    neg-int v10, p1

    :try_start_70
    new-array v1, v10, [B

    .line 215
    :cond_72
    invoke-virtual {v2, v1}, Ljava/io/FileInputStream;->read([B)I

    move-result v4

    .line 216
    .local v4, len:I
    array-length v10, v1

    if-eq v4, v10, :cond_67

    .line 218
    if-nez v3, :cond_83

    if-gtz v4, :cond_83

    const-string v10, ""
    :try_end_7f
    .catchall {:try_start_70 .. :try_end_7f} :catchall_e5

    .line 238
    invoke-virtual {v2}, Ljava/io/FileInputStream;->close()V

    goto :goto_2e

    .line 219
    :cond_83
    if-nez v3, :cond_8f

    :try_start_85
    new-instance v10, Ljava/lang/String;

    const/4 v11, 0x0

    invoke-direct {v10, v1, v11, v4}, Ljava/lang/String;-><init>([BII)V
    :try_end_8b
    .catchall {:try_start_85 .. :try_end_8b} :catchall_e5

    .line 238
    invoke-virtual {v2}, Ljava/io/FileInputStream;->close()V

    goto :goto_2e

    .line 220
    :cond_8f
    if-lez v4, :cond_9e

    .line 221
    const/4 v6, 0x1

    .line 222
    const/4 v10, 0x0

    :try_start_93
    array-length v11, v3

    sub-int/2addr v11, v4

    invoke-static {v3, v4, v3, v10, v11}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 223
    const/4 v10, 0x0

    array-length v11, v3

    sub-int/2addr v11, v4

    invoke-static {v1, v10, v3, v11, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 225
    :cond_9e
    if-eqz p2, :cond_a2

    if-nez v6, :cond_ab

    :cond_a2
    new-instance v10, Ljava/lang/String;

    invoke-direct {v10, v3}, Ljava/lang/String;-><init>([B)V
    :try_end_a7
    .catchall {:try_start_93 .. :try_end_a7} :catchall_e5

    .line 238
    invoke-virtual {v2}, Ljava/io/FileInputStream;->close()V

    goto :goto_2e

    .line 226
    :cond_ab
    :try_start_ab
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v10, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    new-instance v11, Ljava/lang/String;

    invoke-direct {v11, v3}, Ljava/lang/String;-><init>([B)V

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_c0
    .catchall {:try_start_ab .. :try_end_c0} :catchall_e5

    move-result-object v10

    .line 238
    invoke-virtual {v2}, Ljava/io/FileInputStream;->close()V

    goto/16 :goto_2e

    .line 228
    .end local v1           #data:[B
    .end local v3           #last:[B
    .end local v4           #len:I
    .end local v6           #rolled:Z
    .end local v9           #tmp:[B
    :cond_c6
    :try_start_c6
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 230
    .local v0, contents:Ljava/io/ByteArrayOutputStream;
    const/16 v10, 0x400

    new-array v1, v10, [B

    .line 232
    .restart local v1       #data:[B
    :cond_cf
    invoke-virtual {v2, v1}, Ljava/io/FileInputStream;->read([B)I

    move-result v4

    .line 233
    .restart local v4       #len:I
    if-lez v4, :cond_d9

    const/4 v10, 0x0

    invoke-virtual {v0, v1, v10, v4}, Ljava/io/ByteArrayOutputStream;->write([BII)V

    .line 234
    :cond_d9
    array-length v10, v1

    if-eq v4, v10, :cond_cf

    .line 235
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toString()Ljava/lang/String;
    :try_end_df
    .catchall {:try_start_c6 .. :try_end_df} :catchall_e5

    move-result-object v10

    .line 238
    invoke-virtual {v2}, Ljava/io/FileInputStream;->close()V

    goto/16 :goto_2e

    .end local v0           #contents:Ljava/io/ByteArrayOutputStream;
    .end local v1           #data:[B
    .end local v4           #len:I
    .end local v7           #size:J
    :catchall_e5
    move-exception v10

    invoke-virtual {v2}, Ljava/io/FileInputStream;->close()V

    throw v10
.end method

.method public static native setPermissions(Ljava/lang/String;III)I
.end method

.method public static native setUMask(I)I
.end method

.method public static stringToFile(Ljava/lang/String;Ljava/lang/String;)V
    .registers 4
    .parameter "filename"
    .parameter "string"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 250
    new-instance v0, Ljava/io/FileWriter;

    invoke-direct {v0, p0}, Ljava/io/FileWriter;-><init>(Ljava/lang/String;)V

    .line 252
    .local v0, out:Ljava/io/FileWriter;
    :try_start_5
    invoke-virtual {v0, p1}, Ljava/io/FileWriter;->write(Ljava/lang/String;)V
    :try_end_8
    .catchall {:try_start_5 .. :try_end_8} :catchall_c

    .line 254
    invoke-virtual {v0}, Ljava/io/FileWriter;->close()V

    .line 256
    return-void

    .line 254
    :catchall_c
    move-exception v1

    invoke-virtual {v0}, Ljava/io/FileWriter;->close()V

    throw v1
.end method

.method public static sync(Ljava/io/FileOutputStream;)Z
    .registers 2
    .parameter "stream"

    .prologue
    .line 120
    if-eqz p0, :cond_9

    .line 121
    :try_start_2
    invoke-virtual {p0}, Ljava/io/FileOutputStream;->getFD()Ljava/io/FileDescriptor;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/FileDescriptor;->sync()V
    :try_end_9
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_9} :catch_b

    .line 123
    :cond_9
    const/4 v0, 0x1

    .line 126
    :goto_a
    return v0

    .line 124
    :catch_b
    move-exception v0

    .line 126
    const/4 v0, 0x0

    goto :goto_a
.end method
