.class public Lmiui/telephony/phonenumber/ChineseTelocation;
.super Ljava/lang/Object;
.source "ChineseTelocation.java"


# static fields
.field private static final AREA_CODES_INDEX:[S = null

.field private static final DATA_PATH:Ljava/lang/String; = "/etc/telocation.td"

.field private static final EMPTY:Ljava/lang/String; = ""

#the value of this static final field might be set in the static constructor
.field private static final FILE_HEADER_SIZE:I = 0x0

.field private static final FILE_VERSION:I = 0x1

.field private static final INDEX_NONE:I = 0x0

.field private static final MAX_MOB_UNIQUE_ID:I = 0xdbb9f

.field private static final MAX_TEL_UNIQUE_ID:I = 0x3e7

.field private static final MIN_MOB_UNIQUE_ID:I = 0x493e0

.field private static final MIN_TEL_UNIQUE_ID:I = 0x1

.field private static final TAG:Ljava/lang/String; = "ChineseTelocation"

.field private static final UNIQUE_ID_NONE:I

.field private static sInstance:Lmiui/telephony/phonenumber/ChineseTelocation;


# instance fields
.field private mAllowTelocation:Z

.field private mContext:Landroid/content/Context;

.field private mCustomLocationObserver:Landroid/database/ContentObserver;

.field private mFile:Ljava/io/RandomAccessFile;

.field private mGroupCustomLocations:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mNormalCustomLocations:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mSettingObserver:Landroid/database/ContentObserver;


# direct methods
.method static constructor <clinit>()V
    .registers 7

    .prologue
    const/4 v6, 0x0

    sget-object v4, Lmiui/telephony/phonenumber/TelocationConstants;->FILE_TAG:[B

    array-length v4, v4

    add-int/lit8 v4, v4, 0x4

    const-string v5, "1469b751a02f88d66bf98dc1ee131904f4073126"

    invoke-virtual {v5}, Ljava/lang/String;->getBytes()[B

    move-result-object v5

    array-length v5, v5

    add-int/2addr v4, v5

    add-int/lit8 v4, v4, 0x4

    add-int/lit8 v4, v4, 0x4

    add-int/lit8 v4, v4, 0x0

    sput v4, Lmiui/telephony/phonenumber/ChineseTelocation;->FILE_HEADER_SIZE:I

    new-instance v4, Lmiui/telephony/phonenumber/ChineseTelocation;

    invoke-direct {v4}, Lmiui/telephony/phonenumber/ChineseTelocation;-><init>()V

    sput-object v4, Lmiui/telephony/phonenumber/ChineseTelocation;->sInstance:Lmiui/telephony/phonenumber/ChineseTelocation;

    const/16 v4, 0x3e8

    new-array v4, v4, [S

    sput-object v4, Lmiui/telephony/phonenumber/ChineseTelocation;->AREA_CODES_INDEX:[S

    sget-object v4, Lmiui/telephony/phonenumber/ChineseTelocation;->AREA_CODES_INDEX:[S

    invoke-static {v4, v6}, Ljava/util/Arrays;->fill([SS)V

    const/4 v1, 0x1

    .local v1, i:I
    const/16 v3, 0x147

    .local v3, len:I
    :goto_2b
    if-ge v1, v3, :cond_5c

    sget-object v4, Lmiui/telephony/phonenumber/TelocationConstants;->AREA_CODES:[Ljava/lang/String;

    aget-object v0, v4, v1

    .local v0, c:Ljava/lang/String;
    invoke-virtual {v0, v6}, Ljava/lang/String;->charAt(I)C

    move-result v4

    add-int/lit8 v4, v4, -0x30

    mul-int/lit8 v4, v4, 0xa

    const/4 v5, 0x1

    invoke-virtual {v0, v5}, Ljava/lang/String;->charAt(I)C

    move-result v5

    add-int/lit8 v5, v5, -0x30

    add-int v2, v4, v5

    .local v2, index:I
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v4

    const/4 v5, 0x3

    if-ne v4, v5, :cond_54

    mul-int/lit8 v4, v2, 0xa

    const/4 v5, 0x2

    invoke-virtual {v0, v5}, Ljava/lang/String;->charAt(I)C

    move-result v5

    add-int/lit8 v5, v5, -0x30

    add-int v2, v4, v5

    :cond_54
    sget-object v4, Lmiui/telephony/phonenumber/ChineseTelocation;->AREA_CODES_INDEX:[S

    int-to-short v5, v1

    aput-short v5, v4, v2

    add-int/lit8 v1, v1, 0x1

    goto :goto_2b

    .end local v0           #c:Ljava/lang/String;
    .end local v2           #index:I
    :cond_5c
    return-void
.end method

.method private constructor <init>()V
    .registers 14

    .prologue
    const/4 v12, 0x0

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    new-instance v8, Ljava/util/HashMap;

    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    iput-object v8, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mNormalCustomLocations:Ljava/util/HashMap;

    new-instance v8, Ljava/util/HashMap;

    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    iput-object v8, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mGroupCustomLocations:Ljava/util/HashMap;

    const/4 v4, 0x1

    .local v4, success:Z
    :try_start_13
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    .local v5, times:J
    new-instance v2, Ljava/io/File;

    const-string v8, "/etc/telocation.td"

    invoke-direct {v2, v8}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .local v2, file:Ljava/io/File;
    new-instance v8, Ljava/io/RandomAccessFile;

    const-string/jumbo v9, "r"

    invoke-direct {v8, v2, v9}, Ljava/io/RandomAccessFile;-><init>(Ljava/io/File;Ljava/lang/String;)V

    iput-object v8, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mFile:Ljava/io/RandomAccessFile;

    sget-object v8, Lmiui/telephony/phonenumber/TelocationConstants;->FILE_TAG:[B

    array-length v8, v8

    new-array v3, v8, [B

    .local v3, fileTag:[B
    iget-object v8, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mFile:Ljava/io/RandomAccessFile;

    invoke-virtual {v8, v3}, Ljava/io/RandomAccessFile;->read([B)I

    sget-object v8, Lmiui/telephony/phonenumber/TelocationConstants;->FILE_TAG:[B

    invoke-static {v3, v8}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v8

    if-nez v8, :cond_50

    const-string v8, "ChineseTelocation"

    const-string v9, "Unknow file type for /etc/telocation.td, NO mobile telocation supported!"

    invoke-static {v8, v9}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_41
    .catchall {:try_start_13 .. :try_end_41} :catchall_103
    .catch Ljava/io/FileNotFoundException; {:try_start_13 .. :try_end_41} :catch_d1
    .catch Ljava/io/IOException; {:try_start_13 .. :try_end_41} :catch_ea

    const/4 v4, 0x0

    if-nez v4, :cond_4f

    iget-object v8, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mFile:Ljava/io/RandomAccessFile;

    if-eqz v8, :cond_4f

    :try_start_48
    iget-object v8, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mFile:Ljava/io/RandomAccessFile;
    :try_end_4a
    .catch Ljava/io/IOException; {:try_start_48 .. :try_end_4a} :catch_11b

    :try_start_4a
    invoke-virtual {v8}, Ljava/io/RandomAccessFile;->close()V
    :try_end_4d
    .catch Ljava/io/IOException; {:try_start_4a .. :try_end_4d} :catch_11e

    .end local v2           #file:Ljava/io/File;
    .end local v3           #fileTag:[B
    .end local v5           #times:J
    :goto_4d
    iput-object v12, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mFile:Ljava/io/RandomAccessFile;

    :cond_4f
    return-void

    .restart local v2       #file:Ljava/io/File;
    .restart local v3       #fileTag:[B
    .restart local v5       #times:J
    :cond_50
    :try_start_50
    iget-object v8, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mFile:Ljava/io/RandomAccessFile;

    invoke-virtual {v8}, Ljava/io/RandomAccessFile;->readInt()I

    move-result v8

    new-array v0, v8, [B

    .local v0, digestBytes:[B
    iget-object v8, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mFile:Ljava/io/RandomAccessFile;

    invoke-virtual {v8, v0}, Ljava/io/RandomAccessFile;->read([B)I

    const-string v8, "1469b751a02f88d66bf98dc1ee131904f4073126"

    new-instance v9, Ljava/lang/String;

    invoke-direct {v9, v0}, Ljava/lang/String;-><init>([B)V

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_80

    const-string v8, "ChineseTelocation"

    const-string v9, "Unmatched digest for /etc/telocation.td, NO mobile telocation supported!"

    invoke-static {v8, v9}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_71
    .catchall {:try_start_50 .. :try_end_71} :catchall_103
    .catch Ljava/io/FileNotFoundException; {:try_start_50 .. :try_end_71} :catch_d1
    .catch Ljava/io/IOException; {:try_start_50 .. :try_end_71} :catch_ea

    const/4 v4, 0x0

    if-nez v4, :cond_4f

    iget-object v8, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mFile:Ljava/io/RandomAccessFile;

    if-eqz v8, :cond_4f

    :try_start_78
    iget-object v8, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mFile:Ljava/io/RandomAccessFile;
    :try_end_7a
    .catch Ljava/io/IOException; {:try_start_78 .. :try_end_7a} :catch_118

    :try_start_7a
    invoke-virtual {v8}, Ljava/io/RandomAccessFile;->close()V
    :try_end_7d
    .catch Ljava/io/IOException; {:try_start_7a .. :try_end_7d} :catch_7e

    goto :goto_4d

    :catch_7e
    move-exception v8

    goto :goto_4d

    :cond_80
    :try_start_80
    iget-object v8, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mFile:Ljava/io/RandomAccessFile;

    invoke-virtual {v8}, Ljava/io/RandomAccessFile;->readInt()I

    move-result v7

    .local v7, version:I
    const/4 v8, 0x1

    if-eq v8, v7, :cond_9f

    const-string v8, "ChineseTelocation"

    const-string v9, "Unmatched version for /etc/telocation.td, NO mobile telocation supported!"

    invoke-static {v8, v9}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_90
    .catchall {:try_start_80 .. :try_end_90} :catchall_103
    .catch Ljava/io/FileNotFoundException; {:try_start_80 .. :try_end_90} :catch_d1
    .catch Ljava/io/IOException; {:try_start_80 .. :try_end_90} :catch_ea

    const/4 v4, 0x0

    if-nez v4, :cond_4f

    iget-object v8, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mFile:Ljava/io/RandomAccessFile;

    if-eqz v8, :cond_4f

    :try_start_97
    iget-object v8, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mFile:Ljava/io/RandomAccessFile;
    :try_end_99
    .catch Ljava/io/IOException; {:try_start_97 .. :try_end_99} :catch_115

    :try_start_99
    invoke-virtual {v8}, Ljava/io/RandomAccessFile;->close()V
    :try_end_9c
    .catch Ljava/io/IOException; {:try_start_99 .. :try_end_9c} :catch_9d

    goto :goto_4d

    :catch_9d
    move-exception v8

    goto :goto_4d

    :cond_9f
    :try_start_9f
    const-string v8, "ChineseTelocation"

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "["

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v10

    sub-long/2addr v10, v5

    invoke-virtual {v9, v10, v11}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "]ms to load data file"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_c2
    .catchall {:try_start_9f .. :try_end_c2} :catchall_103
    .catch Ljava/io/FileNotFoundException; {:try_start_9f .. :try_end_c2} :catch_d1
    .catch Ljava/io/IOException; {:try_start_9f .. :try_end_c2} :catch_ea

    if-nez v4, :cond_4f

    iget-object v8, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mFile:Ljava/io/RandomAccessFile;

    if-eqz v8, :cond_4f

    :try_start_c8
    iget-object v8, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mFile:Ljava/io/RandomAccessFile;
    :try_end_ca
    .catch Ljava/io/IOException; {:try_start_c8 .. :try_end_ca} :catch_112

    :try_start_ca
    invoke-virtual {v8}, Ljava/io/RandomAccessFile;->close()V
    :try_end_cd
    .catch Ljava/io/IOException; {:try_start_ca .. :try_end_cd} :catch_ce

    goto :goto_4d

    :catch_ce
    move-exception v8

    goto/16 :goto_4d

    .end local v0           #digestBytes:[B
    .end local v2           #file:Ljava/io/File;
    .end local v3           #fileTag:[B
    .end local v5           #times:J
    .end local v7           #version:I
    :catch_d1
    move-exception v1

    .local v1, e:Ljava/io/FileNotFoundException;
    :try_start_d2
    const-string v8, "ChineseTelocation"

    const-string v9, "Can\'t find /etc/telocation.td, NO mobile telocation supported!"

    invoke-static {v8, v9}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_d9
    .catchall {:try_start_d2 .. :try_end_d9} :catchall_103

    const/4 v4, 0x0

    if-nez v4, :cond_4f

    iget-object v8, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mFile:Ljava/io/RandomAccessFile;

    if-eqz v8, :cond_4f

    :try_start_e0
    iget-object v8, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mFile:Ljava/io/RandomAccessFile;

    invoke-virtual {v8}, Ljava/io/RandomAccessFile;->close()V
    :try_end_e5
    .catch Ljava/io/IOException; {:try_start_e0 .. :try_end_e5} :catch_e7

    goto/16 :goto_4d

    :catch_e7
    move-exception v8

    goto/16 :goto_4d

    .end local v1           #e:Ljava/io/FileNotFoundException;
    :catch_ea
    move-exception v1

    .local v1, e:Ljava/io/IOException;
    :try_start_eb
    const-string v8, "ChineseTelocation"

    const-string v9, "Can\'t read /etc/telocation.td, NO mobile telocation supported!"

    invoke-static {v8, v9}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_f2
    .catchall {:try_start_eb .. :try_end_f2} :catchall_103

    const/4 v4, 0x0

    if-nez v4, :cond_4f

    iget-object v8, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mFile:Ljava/io/RandomAccessFile;

    if-eqz v8, :cond_4f

    :try_start_f9
    iget-object v8, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mFile:Ljava/io/RandomAccessFile;
    :try_end_fb
    .catch Ljava/io/IOException; {:try_start_f9 .. :try_end_fb} :catch_121

    :try_start_fb
    invoke-virtual {v8}, Ljava/io/RandomAccessFile;->close()V
    :try_end_fe
    .catch Ljava/io/IOException; {:try_start_fb .. :try_end_fe} :catch_100

    goto/16 :goto_4d

    :catch_100
    move-exception v8

    goto/16 :goto_4d

    .end local v1           #e:Ljava/io/IOException;
    :catchall_103
    move-exception v8

    if-nez v4, :cond_111

    iget-object v9, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mFile:Ljava/io/RandomAccessFile;

    if-eqz v9, :cond_111

    :try_start_10a
    iget-object v9, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mFile:Ljava/io/RandomAccessFile;

    invoke-virtual {v9}, Ljava/io/RandomAccessFile;->close()V
    :try_end_10f
    .catch Ljava/io/IOException; {:try_start_10a .. :try_end_10f} :catch_124

    :goto_10f
    iput-object v12, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mFile:Ljava/io/RandomAccessFile;

    :cond_111
    throw v8

    .restart local v0       #digestBytes:[B
    .restart local v2       #file:Ljava/io/File;
    .restart local v3       #fileTag:[B
    .restart local v5       #times:J
    .restart local v7       #version:I
    :catch_112
    move-exception v8

    goto/16 :goto_4d

    :catch_115
    move-exception v8

    goto/16 :goto_4d

    .end local v7           #version:I
    :catch_118
    move-exception v8

    goto/16 :goto_4d

    .end local v0           #digestBytes:[B
    :catch_11b
    move-exception v8

    goto/16 :goto_4d

    :catch_11e
    move-exception v8

    goto/16 :goto_4d

    .end local v2           #file:Ljava/io/File;
    .end local v3           #fileTag:[B
    .end local v5           #times:J
    .restart local v1       #e:Ljava/io/IOException;
    :catch_121
    move-exception v8

    goto/16 :goto_4d

    .end local v1           #e:Ljava/io/IOException;
    :catch_124
    move-exception v9

    goto :goto_10f
.end method

.method static synthetic access$000(Lmiui/telephony/phonenumber/ChineseTelocation;)V
    .registers 1
    .parameter "x0"

    .prologue
    invoke-direct {p0}, Lmiui/telephony/phonenumber/ChineseTelocation;->updateTelocationSetting()V

    return-void
.end method

.method static synthetic access$100(Lmiui/telephony/phonenumber/ChineseTelocation;)V
    .registers 1
    .parameter "x0"

    .prologue
    invoke-direct {p0}, Lmiui/telephony/phonenumber/ChineseTelocation;->updateCustomLocation()V

    return-void
.end method

.method private convertUniqIdToIndex(I)I
    .registers 7
    .parameter "id"

    .prologue
    const v2, 0x493e0

    const/4 v1, 0x1

    if-lt p1, v1, :cond_c

    const/16 v1, 0x3e7

    if-gt p1, v1, :cond_c

    move v1, p1

    :goto_b
    return v1

    :cond_c
    if-lt p1, v2, :cond_37

    const v1, 0xdbb9f

    if-gt p1, v1, :cond_37

    sub-int/2addr p1, v2

    shl-int/lit8 v1, p1, 0x1

    sget v2, Lmiui/telephony/phonenumber/ChineseTelocation;->FILE_HEADER_SIZE:I

    add-int v0, v1, v2

    .local v0, offset:I
    iget-object v1, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mFile:Ljava/io/RandomAccessFile;

    if-eqz v1, :cond_37

    int-to-long v1, v0

    :try_start_1f
    iget-object v3, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mFile:Ljava/io/RandomAccessFile;

    invoke-virtual {v3}, Ljava/io/RandomAccessFile;->length()J

    move-result-wide v3

    cmp-long v1, v1, v3

    if-gez v1, :cond_37

    iget-object v1, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mFile:Ljava/io/RandomAccessFile;

    int-to-long v2, v0

    invoke-virtual {v1, v2, v3}, Ljava/io/RandomAccessFile;->seek(J)V

    iget-object v1, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mFile:Ljava/io/RandomAccessFile;

    invoke-virtual {v1}, Ljava/io/RandomAccessFile;->readShort()S
    :try_end_34
    .catch Ljava/io/IOException; {:try_start_1f .. :try_end_34} :catch_36

    move-result v1

    goto :goto_b

    :catch_36
    move-exception v1

    .end local v0           #offset:I
    :cond_37
    const/4 v1, 0x0

    goto :goto_b
.end method

.method private findCustomLocation(ILjava/lang/CharSequence;II)Ljava/lang/String;
    .registers 13
    .parameter "id"
    .parameter "cs"
    .parameter "start"
    .parameter "length"

    .prologue
    const/4 v4, 0x0

    .local v4, location:Ljava/lang/String;
    if-lez p1, :cond_f

    iget-object v6, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mNormalCustomLocations:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    .end local v4           #location:Ljava/lang/String;
    check-cast v4, Ljava/lang/String;

    .restart local v4       #location:Ljava/lang/String;
    :cond_f
    if-nez v4, :cond_60

    iget-object v6, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mGroupCustomLocations:Ljava/util/HashMap;

    invoke-virtual {v6}, Ljava/util/HashMap;->size()I

    move-result v6

    if-lez v6, :cond_60

    iget-object v6, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mGroupCustomLocations:Ljava/util/HashMap;

    invoke-virtual {v6}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, i$:Ljava/util/Iterator;
    :cond_23
    :goto_23
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_60

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .local v2, key:Ljava/lang/String;
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v6

    if-ne p4, v6, :cond_23

    const/4 v5, 0x1

    .local v5, matched:Z
    const/4 v0, 0x0

    .local v0, i:I
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v3

    .local v3, len:I
    :goto_3b
    if-ge v0, v3, :cond_52

    invoke-virtual {v2, v0}, Ljava/lang/String;->charAt(I)C

    move-result v6

    const/16 v7, 0x23

    if-eq v6, v7, :cond_5d

    invoke-virtual {v2, v0}, Ljava/lang/String;->charAt(I)C

    move-result v6

    add-int v7, p3, v0

    invoke-interface {p2, v7}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v7

    if-eq v6, v7, :cond_5d

    const/4 v5, 0x0

    :cond_52
    if-eqz v5, :cond_23

    iget-object v6, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mGroupCustomLocations:Ljava/util/HashMap;

    invoke-virtual {v6, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    .end local v4           #location:Ljava/lang/String;
    check-cast v4, Ljava/lang/String;

    .restart local v4       #location:Ljava/lang/String;
    goto :goto_23

    :cond_5d
    add-int/lit8 v0, v0, 0x1

    goto :goto_3b

    .end local v0           #i:I
    .end local v1           #i$:Ljava/util/Iterator;
    .end local v2           #key:Ljava/lang/String;
    .end local v3           #len:I
    .end local v5           #matched:Z
    :cond_60
    if-nez v4, :cond_64

    const-string v4, ""

    :cond_64
    return-object v4
.end method

.method public static getInstance()Lmiui/telephony/phonenumber/ChineseTelocation;
    .registers 1

    .prologue
    sget-object v0, Lmiui/telephony/phonenumber/ChineseTelocation;->sInstance:Lmiui/telephony/phonenumber/ChineseTelocation;

    return-object v0
.end method

.method private initObserver(Landroid/content/Context;)V
    .registers 7
    .parameter "context"

    .prologue
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iput-object v1, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mContext:Landroid/content/Context;

    iget-object v1, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mContext:Landroid/content/Context;

    if-nez v1, :cond_c

    iput-object p1, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mContext:Landroid/content/Context;

    :cond_c
    invoke-direct {p0}, Lmiui/telephony/phonenumber/ChineseTelocation;->updateTelocationSetting()V

    invoke-direct {p0}, Lmiui/telephony/phonenumber/ChineseTelocation;->updateCustomLocation()V

    new-instance v0, Landroid/os/Handler;

    iget-object v1, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .local v0, h:Landroid/os/Handler;
    new-instance v1, Lmiui/telephony/phonenumber/ChineseTelocation$1;

    invoke-direct {v1, p0, v0}, Lmiui/telephony/phonenumber/ChineseTelocation$1;-><init>(Lmiui/telephony/phonenumber/ChineseTelocation;Landroid/os/Handler;)V

    iput-object v1, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mSettingObserver:Landroid/database/ContentObserver;

    iget-object v1, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const-string v2, "enable_telocation"

    invoke-static {v2}, Landroid/provider/Settings$System;->getUriFor(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    const/4 v3, 0x0

    iget-object v4, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mSettingObserver:Landroid/database/ContentObserver;

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/ContentResolver;->registerContentObserver(Landroid/net/Uri;ZLandroid/database/ContentObserver;)V

    new-instance v1, Lmiui/telephony/phonenumber/ChineseTelocation$2;

    invoke-direct {v1, p0, v0}, Lmiui/telephony/phonenumber/ChineseTelocation$2;-><init>(Lmiui/telephony/phonenumber/ChineseTelocation;Landroid/os/Handler;)V

    iput-object v1, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mCustomLocationObserver:Landroid/database/ContentObserver;

    iget-object v1, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    sget-object v2, Lmiui/provider/Telocation;->CONTENT_CUSTOM_LOCATION_URI:Landroid/net/Uri;

    const/4 v3, 0x1

    iget-object v4, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mCustomLocationObserver:Landroid/database/ContentObserver;

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/ContentResolver;->registerContentObserver(Landroid/net/Uri;ZLandroid/database/ContentObserver;)V

    return-void
.end method

.method private updateCustomLocation()V
    .registers 13

    .prologue
    iget-object v0, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mNormalCustomLocations:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    iget-object v0, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mGroupCustomLocations:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    iget-boolean v0, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mAllowTelocation:Z

    if-eqz v0, :cond_8e

    const/4 v6, 0x0

    .local v6, cursor:Landroid/database/Cursor;
    :try_start_f
    iget-object v0, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lmiui/provider/Telocation;->CONTENT_CUSTOM_LOCATION_URI:Landroid/net/Uri;

    const/4 v2, 0x4

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "_id"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    const-string/jumbo v4, "number"

    aput-object v4, v2, v3

    const/4 v3, 0x2

    const-string/jumbo v4, "location"

    aput-object v4, v2, v3

    const/4 v3, 0x3

    const-string/jumbo v4, "type"

    aput-object v4, v2, v3

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    if-eqz v6, :cond_89

    :cond_3a
    :goto_3a
    invoke-interface {v6}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_89

    const/4 v0, 0x3

    invoke-interface {v6, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v11

    .local v11, type:I
    const/4 v0, 0x1

    invoke-interface {v6, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v9

    .local v9, number:Ljava/lang/String;
    const/4 v0, 0x2

    invoke-interface {v6, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v8

    .local v8, location:Ljava/lang/String;
    packed-switch v11, :pswitch_data_90

    goto :goto_3a

    :pswitch_53
    const/4 v10, 0x0

    .local v10, start:I
    const-string v0, "+86"

    invoke-virtual {v9, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_79

    const/4 v10, 0x3

    :cond_5d
    :goto_5d
    invoke-virtual {v9}, Ljava/lang/String;->length()I

    move-result v0

    const/4 v1, 0x1

    invoke-virtual {p0, v9, v10, v0, v1}, Lmiui/telephony/phonenumber/ChineseTelocation;->getUniqId(Ljava/lang/CharSequence;IIZ)I

    move-result v7

    .local v7, id:I
    if-eqz v7, :cond_3a

    iget-object v0, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mNormalCustomLocations:Ljava/util/HashMap;

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_71
    .catchall {:try_start_f .. :try_end_71} :catchall_72

    goto :goto_3a

    .end local v7           #id:I
    .end local v8           #location:Ljava/lang/String;
    .end local v9           #number:Ljava/lang/String;
    .end local v10           #start:I
    .end local v11           #type:I
    :catchall_72
    move-exception v0

    if-eqz v6, :cond_78

    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    :cond_78
    throw v0

    .restart local v8       #location:Ljava/lang/String;
    .restart local v9       #number:Ljava/lang/String;
    .restart local v10       #start:I
    .restart local v11       #type:I
    :cond_79
    :try_start_79
    const-string v0, "0086"

    invoke-virtual {v9, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5d

    const/4 v10, 0x4

    goto :goto_5d

    .end local v10           #start:I
    :pswitch_83
    iget-object v0, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mGroupCustomLocations:Ljava/util/HashMap;

    invoke-virtual {v0, v9, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_88
    .catchall {:try_start_79 .. :try_end_88} :catchall_72

    goto :goto_3a

    .end local v8           #location:Ljava/lang/String;
    .end local v9           #number:Ljava/lang/String;
    .end local v11           #type:I
    :cond_89
    if-eqz v6, :cond_8e

    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .end local v6           #cursor:Landroid/database/Cursor;
    :cond_8e
    return-void

    nop

    :pswitch_data_90
    .packed-switch 0x0
        :pswitch_53
        :pswitch_53
        :pswitch_83
    .end packed-switch
.end method

.method private updateTelocationSetting()V
    .registers 4

    .prologue
    const/4 v0, 0x1

    iget-object v1, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const-string v2, "enable_telocation"

    invoke-static {v1, v2, v0}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v1

    if-eqz v1, :cond_15

    :goto_f
    iput-boolean v0, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mAllowTelocation:Z

    invoke-direct {p0}, Lmiui/telephony/phonenumber/ChineseTelocation;->updateCustomLocation()V

    return-void

    :cond_15
    const/4 v0, 0x0

    goto :goto_f
.end method


# virtual methods
.method protected finalize()V
    .registers 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    iget-object v0, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mFile:Ljava/io/RandomAccessFile;

    if-eqz v0, :cond_9

    :try_start_4
    iget-object v0, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mFile:Ljava/io/RandomAccessFile;

    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->close()V
    :try_end_9
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_9} :catch_2b

    :cond_9
    :goto_9
    iget-object v0, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mSettingObserver:Landroid/database/ContentObserver;

    if-eqz v0, :cond_18

    iget-object v0, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    iget-object v1, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mSettingObserver:Landroid/database/ContentObserver;

    invoke-virtual {v0, v1}, Landroid/content/ContentResolver;->unregisterContentObserver(Landroid/database/ContentObserver;)V

    :cond_18
    iget-object v0, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mCustomLocationObserver:Landroid/database/ContentObserver;

    if-eqz v0, :cond_27

    iget-object v0, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    iget-object v1, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mCustomLocationObserver:Landroid/database/ContentObserver;

    invoke-virtual {v0, v1}, Landroid/content/ContentResolver;->unregisterContentObserver(Landroid/database/ContentObserver;)V

    :cond_27
    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    return-void

    :catch_2b
    move-exception v0

    goto :goto_9
.end method

.method public getAreaCode(Landroid/content/Context;Ljava/lang/CharSequence;II)Ljava/lang/String;
    .registers 8
    .parameter "context"
    .parameter "cs"
    .parameter "start"
    .parameter "length"

    .prologue
    const/4 v1, 0x1

    invoke-virtual {p0, p2, p3, p4, v1}, Lmiui/telephony/phonenumber/ChineseTelocation;->getUniqId(Ljava/lang/CharSequence;IIZ)I

    move-result v0

    .local v0, id:I
    sget-object v1, Lmiui/telephony/phonenumber/TelocationConstants;->AREA_CODES:[Ljava/lang/String;

    invoke-direct {p0, v0}, Lmiui/telephony/phonenumber/ChineseTelocation;->convertUniqIdToIndex(I)I

    move-result v2

    aget-object v1, v1, v2

    return-object v1
.end method

.method public getExternalLocation(Landroid/content/Context;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/util/Locale;)Ljava/lang/String;
    .registers 10
    .parameter "context"
    .parameter "countryCode"
    .parameter "number"
    .parameter "locale"

    .prologue
    iget-object v0, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mContext:Landroid/content/Context;

    if-nez v0, :cond_7

    invoke-direct {p0, p1}, Lmiui/telephony/phonenumber/ChineseTelocation;->initObserver(Landroid/content/Context;)V

    :cond_7
    iget-boolean v0, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mAllowTelocation:Z

    if-nez v0, :cond_d

    const/4 v0, 0x0

    :goto_c
    return-object v0

    :cond_d
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_21

    invoke-static {}, Lmiui/telephony/phonenumber/CountryCode;->getUserDefinedCountryCode()Ljava/lang/String;

    move-result-object p2

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_21

    invoke-static {}, Lmiui/telephony/phonenumber/CountryCode;->getIccCountryCode()Ljava/lang/String;

    move-result-object p2

    :cond_21
    :try_start_21
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_49

    invoke-static {}, Lcom/android/i18n/phonenumbers/geocoding/PhoneNumberOfflineGeocoder;->getInstance()Lcom/android/i18n/phonenumbers/geocoding/PhoneNumberOfflineGeocoder;

    move-result-object v0

    invoke-static {}, Lcom/android/i18n/phonenumbers/PhoneNumberUtil;->getInstance()Lcom/android/i18n/phonenumbers/PhoneNumberUtil;

    move-result-object v1

    invoke-virtual {p3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {}, Lcom/android/i18n/phonenumbers/PhoneNumberUtil;->getInstance()Lcom/android/i18n/phonenumbers/PhoneNumberUtil;

    move-result-object v3

    invoke-static {p2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    invoke-virtual {v3, v4}, Lcom/android/i18n/phonenumbers/PhoneNumberUtil;->getRegionCodeForCountryCode(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/android/i18n/phonenumbers/PhoneNumberUtil;->parse(Ljava/lang/String;Ljava/lang/String;)Lcom/android/i18n/phonenumbers/Phonenumber$PhoneNumber;

    move-result-object v1

    invoke-virtual {v0, v1, p4}, Lcom/android/i18n/phonenumbers/geocoding/PhoneNumberOfflineGeocoder;->getDescriptionForNumber(Lcom/android/i18n/phonenumbers/Phonenumber$PhoneNumber;Ljava/util/Locale;)Ljava/lang/String;
    :try_end_46
    .catch Ljava/lang/Exception; {:try_start_21 .. :try_end_46} :catch_48

    move-result-object v0

    goto :goto_c

    :catch_48
    move-exception v0

    :cond_49
    const-string v0, ""

    goto :goto_c
.end method

.method public getLocation(Landroid/content/Context;Ljava/lang/CharSequence;IIZ)Ljava/lang/String;
    .registers 10
    .parameter "context"
    .parameter "cs"
    .parameter "start"
    .parameter "length"
    .parameter "withAreaCode"

    .prologue
    iget-object v2, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mContext:Landroid/content/Context;

    if-nez v2, :cond_7

    invoke-direct {p0, p1}, Lmiui/telephony/phonenumber/ChineseTelocation;->initObserver(Landroid/content/Context;)V

    :cond_7
    iget-boolean v2, p0, Lmiui/telephony/phonenumber/ChineseTelocation;->mAllowTelocation:Z

    if-nez v2, :cond_d

    const/4 v1, 0x0

    :cond_c
    :goto_c
    return-object v1

    :cond_d
    const/4 v0, -0x1

    .local v0, id:I
    if-eqz p5, :cond_15

    const/4 v2, 0x1

    invoke-virtual {p0, p2, p3, p4, v2}, Lmiui/telephony/phonenumber/ChineseTelocation;->getUniqId(Ljava/lang/CharSequence;IIZ)I

    move-result v0

    :cond_15
    invoke-direct {p0, v0, p2, p3, p4}, Lmiui/telephony/phonenumber/ChineseTelocation;->findCustomLocation(ILjava/lang/CharSequence;II)Ljava/lang/String;

    move-result-object v1

    .local v1, location:Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_c

    if-lez v0, :cond_c

    sget-object v2, Lmiui/telephony/phonenumber/TelocationConstants;->AREA_LOCATIONS:[Ljava/lang/String;

    invoke-direct {p0, v0}, Lmiui/telephony/phonenumber/ChineseTelocation;->convertUniqIdToIndex(I)I

    move-result v3

    aget-object v1, v2, v3

    goto :goto_c
.end method

.method getUniqId(Ljava/lang/CharSequence;IIZ)I
    .registers 11
    .parameter "cs"
    .parameter "start"
    .parameter "length"
    .parameter "enableMobile"

    .prologue
    const/16 v5, 0xa

    const/4 v1, 0x0

    const/16 v4, 0x30

    if-lez p3, :cond_11

    invoke-interface {p1, p2}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v2

    if-ne v2, v4, :cond_11

    add-int/lit8 p2, p2, 0x1

    add-int/lit8 p3, p3, -0x1

    :cond_11
    const/4 v2, 0x1

    if-gt p3, v2, :cond_16

    move v0, v1

    :cond_15
    :goto_15
    return v0

    :cond_16
    invoke-interface {p1, p2}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v2

    packed-switch v2, :pswitch_data_de

    const/4 v2, 0x2

    if-le p3, v2, :cond_da

    invoke-interface {p1, p2}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v1

    add-int/lit8 v1, v1, -0x30

    mul-int/lit8 v1, v1, 0xa

    add-int/lit8 v2, p2, 0x1

    invoke-interface {p1, v2}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v2

    add-int/lit8 v2, v2, -0x30

    add-int/2addr v1, v2

    mul-int/lit8 v1, v1, 0xa

    add-int/lit8 v2, p2, 0x2

    invoke-interface {p1, v2}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v2

    add-int/lit8 v2, v2, -0x30

    add-int v0, v1, v2

    .local v0, index:I
    sget-object v1, Lmiui/telephony/phonenumber/ChineseTelocation;->AREA_CODES_INDEX:[S

    aget-short v0, v1, v0

    goto :goto_15

    .end local v0           #index:I
    :pswitch_42
    add-int/lit8 v2, p2, 0x1

    invoke-interface {p1, v2}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v2

    if-ne v2, v4, :cond_4f

    sget-object v1, Lmiui/telephony/phonenumber/ChineseTelocation;->AREA_CODES_INDEX:[S

    aget-short v0, v1, v5

    goto :goto_15

    :cond_4f
    if-eqz p4, :cond_da

    const/4 v2, 0x6

    if-le p3, v2, :cond_da

    add-int/lit8 v2, p2, 0x1

    invoke-interface {p1, v2}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v2

    add-int/lit8 v2, v2, -0x30

    const v3, 0x186a0

    mul-int/2addr v2, v3

    add-int/lit8 v3, p2, 0x2

    invoke-interface {p1, v3}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v3

    add-int/lit8 v3, v3, -0x30

    mul-int/lit16 v3, v3, 0x2710

    add-int/2addr v2, v3

    add-int/lit8 v3, p2, 0x3

    invoke-interface {p1, v3}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v3

    add-int/lit8 v3, v3, -0x30

    mul-int/lit16 v3, v3, 0x3e8

    add-int/2addr v2, v3

    add-int/lit8 v3, p2, 0x4

    invoke-interface {p1, v3}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v3

    add-int/lit8 v3, v3, -0x30

    mul-int/lit8 v3, v3, 0x64

    add-int/2addr v2, v3

    add-int/lit8 v3, p2, 0x5

    invoke-interface {p1, v3}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v3

    add-int/lit8 v3, v3, -0x30

    mul-int/lit8 v3, v3, 0xa

    add-int/2addr v2, v3

    add-int/lit8 v3, p2, 0x6

    invoke-interface {p1, v3}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v3

    add-int/lit8 v3, v3, -0x30

    add-int v0, v2, v3

    .restart local v0       #index:I
    const v2, 0x1388d

    if-ne v0, v2, :cond_15

    if-le p3, v5, :cond_15

    add-int/lit8 v2, p2, 0x7

    invoke-interface {p1, v2}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v2

    const/16 v3, 0x38

    if-ne v2, v3, :cond_15

    add-int/lit8 v2, p2, 0x8

    invoke-interface {p1, v2}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v2

    if-ne v2, v4, :cond_15

    add-int/lit8 v2, p2, 0x9

    invoke-interface {p1, v2}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v2

    if-ne v2, v4, :cond_15

    add-int/lit8 v2, p2, 0xa

    invoke-interface {p1, v2}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v2

    if-ne v2, v4, :cond_15

    move v0, v1

    goto/16 :goto_15

    .end local v0           #index:I
    :pswitch_c2
    invoke-interface {p1, p2}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v1

    add-int/lit8 v1, v1, -0x30

    mul-int/lit8 v1, v1, 0xa

    add-int/lit8 v2, p2, 0x1

    invoke-interface {p1, v2}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v2

    add-int/lit8 v2, v2, -0x30

    add-int v0, v1, v2

    .restart local v0       #index:I
    sget-object v1, Lmiui/telephony/phonenumber/ChineseTelocation;->AREA_CODES_INDEX:[S

    aget-short v0, v1, v0

    goto/16 :goto_15

    .end local v0           #index:I
    :cond_da
    :pswitch_da
    move v0, v1

    goto/16 :goto_15

    nop

    :pswitch_data_de
    .packed-switch 0x30
        :pswitch_da
        :pswitch_42
        :pswitch_c2
    .end packed-switch
.end method

.method public parseAreaCode(Ljava/lang/CharSequence;II)Ljava/lang/String;
    .registers 7
    .parameter "cs"
    .parameter "start"
    .parameter "length"

    .prologue
    const/4 v1, 0x0

    invoke-virtual {p0, p1, p2, p3, v1}, Lmiui/telephony/phonenumber/ChineseTelocation;->getUniqId(Ljava/lang/CharSequence;IIZ)I

    move-result v0

    .local v0, id:I
    sget-object v1, Lmiui/telephony/phonenumber/TelocationConstants;->AREA_CODES:[Ljava/lang/String;

    invoke-direct {p0, v0}, Lmiui/telephony/phonenumber/ChineseTelocation;->convertUniqIdToIndex(I)I

    move-result v2

    aget-object v1, v1, v2

    return-object v1
.end method
