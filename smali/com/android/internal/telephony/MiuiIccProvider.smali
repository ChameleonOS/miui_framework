.class public Lcom/android/internal/telephony/MiuiIccProvider;
.super Lcom/android/internal/telephony/IccProvider;
.source "MiuiIccProvider.java"


# static fields
.field private static final ADNCAPACITY:I = 0x5

.field private static final DBG:Z = false

.field private static final FREEADN:I = 0x4

.field private static final TAG:Ljava/lang/String; = "IccProvider"


# direct methods
.method static constructor <clinit>()V
    .registers 4

    .prologue
    .line 20
    invoke-static {}, Lcom/android/internal/telephony/MiuiIccProvider;->getURL_MATCHER()Landroid/content/UriMatcher;

    move-result-object v0

    const-string v1, "icc"

    const-string v2, "freeadn"

    const/4 v3, 0x4

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 21
    invoke-static {}, Lcom/android/internal/telephony/MiuiIccProvider;->getURL_MATCHER()Landroid/content/UriMatcher;

    move-result-object v0

    const-string v1, "icc"

    const-string v2, "adncapacity"

    const/4 v3, 0x5

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 22
    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/android/internal/telephony/IccProvider;-><init>()V

    return-void
.end method

.method private getAdnCapacity()Landroid/database/MatrixCursor;
    .registers 9

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 73
    const/4 v0, 0x0

    .line 74
    .local v0, capacity:I
    new-instance v2, Landroid/database/MatrixCursor;

    new-array v4, v6, [Ljava/lang/String;

    const-string v5, "count"

    aput-object v5, v4, v7

    invoke-direct {v2, v4, v6}, Landroid/database/MatrixCursor;-><init>([Ljava/lang/String;I)V

    .line 78
    .local v2, cursor:Landroid/database/MatrixCursor;
    :try_start_e
    const-string/jumbo v4, "simphonebook"

    invoke-static {v4}, Landroid/os/ServiceManager;->getService(Ljava/lang/String;)Landroid/os/IBinder;

    move-result-object v4

    invoke-static {v4}, Lcom/android/internal/telephony/IIccPhoneBook$Stub;->asInterface(Landroid/os/IBinder;)Lcom/android/internal/telephony/IIccPhoneBook;

    move-result-object v3

    .line 80
    .local v3, iccIpb:Lcom/android/internal/telephony/IIccPhoneBook;
    if-eqz v3, :cond_1f

    .line 81
    invoke-interface {v3}, Lcom/android/internal/telephony/IIccPhoneBook;->getAdnCapacity()I
    :try_end_1e
    .catch Landroid/os/RemoteException; {:try_start_e .. :try_end_1e} :catch_2d
    .catch Ljava/lang/SecurityException; {:try_start_e .. :try_end_1e} :catch_2b

    move-result v0

    .line 89
    .end local v3           #iccIpb:Lcom/android/internal/telephony/IIccPhoneBook;
    :cond_1f
    :goto_1f
    new-array v1, v6, [Ljava/lang/Object;

    .line 90
    .local v1, count:[Ljava/lang/Object;
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v1, v7

    .line 91
    invoke-virtual {v2, v1}, Landroid/database/MatrixCursor;->addRow([Ljava/lang/Object;)V

    .line 92
    return-object v2

    .line 85
    .end local v1           #count:[Ljava/lang/Object;
    :catch_2b
    move-exception v4

    goto :goto_1f

    .line 83
    :catch_2d
    move-exception v4

    goto :goto_1f
.end method

.method private getFreeAdn()Landroid/database/MatrixCursor;
    .registers 9

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 49
    const/4 v2, 0x0

    .line 50
    .local v2, freeAdn:I
    new-instance v1, Landroid/database/MatrixCursor;

    new-array v4, v6, [Ljava/lang/String;

    const-string v5, "count"

    aput-object v5, v4, v7

    invoke-direct {v1, v4, v6}, Landroid/database/MatrixCursor;-><init>([Ljava/lang/String;I)V

    .line 54
    .local v1, cursor:Landroid/database/MatrixCursor;
    :try_start_e
    const-string/jumbo v4, "simphonebook"

    invoke-static {v4}, Landroid/os/ServiceManager;->getService(Ljava/lang/String;)Landroid/os/IBinder;

    move-result-object v4

    invoke-static {v4}, Lcom/android/internal/telephony/IIccPhoneBook$Stub;->asInterface(Landroid/os/IBinder;)Lcom/android/internal/telephony/IIccPhoneBook;

    move-result-object v3

    .line 56
    .local v3, iccIpb:Lcom/android/internal/telephony/IIccPhoneBook;
    if-eqz v3, :cond_1f

    .line 57
    invoke-interface {v3}, Lcom/android/internal/telephony/IIccPhoneBook;->getFreeAdn()I
    :try_end_1e
    .catch Landroid/os/RemoteException; {:try_start_e .. :try_end_1e} :catch_2d
    .catch Ljava/lang/SecurityException; {:try_start_e .. :try_end_1e} :catch_2b

    move-result v2

    .line 66
    .end local v3           #iccIpb:Lcom/android/internal/telephony/IIccPhoneBook;
    :cond_1f
    :goto_1f
    new-array v0, v6, [Ljava/lang/Object;

    .line 67
    .local v0, count:[Ljava/lang/Object;
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v0, v7

    .line 68
    invoke-virtual {v1, v0}, Landroid/database/MatrixCursor;->addRow([Ljava/lang/Object;)V

    .line 69
    return-object v1

    .line 61
    .end local v0           #count:[Ljava/lang/Object;
    :catch_2b
    move-exception v4

    goto :goto_1f

    .line 59
    :catch_2d
    move-exception v4

    goto :goto_1f
.end method

.method private log(Ljava/lang/String;)V
    .registers 5
    .parameter "msg"

    .prologue
    .line 96
    const-string v0, "IccProvider"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "[IccProvider] "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 97
    return-void
.end method


# virtual methods
.method public getType(Landroid/net/Uri;)Ljava/lang/String;
    .registers 3
    .parameter "url"

    .prologue
    .line 39
    invoke-static {}, Lcom/android/internal/telephony/MiuiIccProvider;->getURL_MATCHER()Landroid/content/UriMatcher;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    packed-switch v0, :pswitch_data_14

    .line 45
    invoke-super {p0, p1}, Lcom/android/internal/telephony/IccProvider;->getType(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v0

    :goto_f
    return-object v0

    .line 42
    :pswitch_10
    const-string/jumbo v0, "vnd.android.cursor.dir/sim-contact"

    goto :goto_f

    .line 39
    :pswitch_data_14
    .packed-switch 0x4
        :pswitch_10
        :pswitch_10
    .end packed-switch
.end method

.method public query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .registers 7
    .parameter "url"
    .parameter "projection"
    .parameter "selection"
    .parameter "selectionArgs"
    .parameter "sort"

    .prologue
    .line 28
    invoke-static {}, Lcom/android/internal/telephony/MiuiIccProvider;->getURL_MATCHER()Landroid/content/UriMatcher;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    packed-switch v0, :pswitch_data_1a

    .line 34
    invoke-super/range {p0 .. p5}, Lcom/android/internal/telephony/IccProvider;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    :goto_f
    return-object v0

    .line 30
    :pswitch_10
    invoke-direct {p0}, Lcom/android/internal/telephony/MiuiIccProvider;->getFreeAdn()Landroid/database/MatrixCursor;

    move-result-object v0

    goto :goto_f

    .line 32
    :pswitch_15
    invoke-direct {p0}, Lcom/android/internal/telephony/MiuiIccProvider;->getAdnCapacity()Landroid/database/MatrixCursor;

    move-result-object v0

    goto :goto_f

    .line 28
    :pswitch_data_1a
    .packed-switch 0x4
        :pswitch_10
        :pswitch_15
    .end packed-switch
.end method
