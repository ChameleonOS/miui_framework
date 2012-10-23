.class public Lcom/android/internal/telephony/MiuiIccProvider;
.super Lcom/android/internal/telephony/IccProvider;
.source "MiuiIccProvider.java"


# static fields
.field private static final ADNCAPACITY:I = 0x5

.field private static final FREEADN:I = 0x4


# direct methods
.method static constructor <clinit>()V
    .registers 4

    .prologue
    .line 16
    sget-object v0, Lcom/android/internal/telephony/MiuiIccProvider;->URL_MATCHER:Landroid/content/UriMatcher;

    const-string v1, "icc"

    const-string v2, "freeadn"

    const/4 v3, 0x4

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 17
    sget-object v0, Lcom/android/internal/telephony/MiuiIccProvider;->URL_MATCHER:Landroid/content/UriMatcher;

    const-string v1, "icc"

    const-string v2, "adncapacity"

    const/4 v3, 0x5

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 18
    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/android/internal/telephony/IccProvider;-><init>()V

    return-void
.end method

.method private getAdnCapacity()Landroid/database/MatrixCursor;
    .registers 9

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 69
    const/4 v0, 0x0

    .line 70
    .local v0, capacity:I
    new-instance v2, Landroid/database/MatrixCursor;

    new-array v4, v6, [Ljava/lang/String;

    const-string v5, "count"

    aput-object v5, v4, v7

    invoke-direct {v2, v4, v6}, Landroid/database/MatrixCursor;-><init>([Ljava/lang/String;I)V

    .line 74
    .local v2, cursor:Landroid/database/MatrixCursor;
    :try_start_e
    const-string/jumbo v4, "simphonebook"

    invoke-static {v4}, Landroid/os/ServiceManager;->getService(Ljava/lang/String;)Landroid/os/IBinder;

    move-result-object v4

    invoke-static {v4}, Lcom/android/internal/telephony/IIccPhoneBook$Stub;->asInterface(Landroid/os/IBinder;)Lcom/android/internal/telephony/IIccPhoneBook;

    move-result-object v3

    .line 76
    .local v3, iccIpb:Lcom/android/internal/telephony/IIccPhoneBook;
    if-eqz v3, :cond_1f

    .line 77
    invoke-interface {v3}, Lcom/android/internal/telephony/IIccPhoneBook;->getAdnCapacity()I
    :try_end_1e
    .catch Landroid/os/RemoteException; {:try_start_e .. :try_end_1e} :catch_2d
    .catch Ljava/lang/SecurityException; {:try_start_e .. :try_end_1e} :catch_2b

    move-result v0

    .line 85
    .end local v3           #iccIpb:Lcom/android/internal/telephony/IIccPhoneBook;
    :cond_1f
    :goto_1f
    new-array v1, v6, [Ljava/lang/Object;

    .line 86
    .local v1, count:[Ljava/lang/Object;
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v1, v7

    .line 87
    invoke-virtual {v2, v1}, Landroid/database/MatrixCursor;->addRow([Ljava/lang/Object;)V

    .line 88
    return-object v2

    .line 81
    .end local v1           #count:[Ljava/lang/Object;
    :catch_2b
    move-exception v4

    goto :goto_1f

    .line 79
    :catch_2d
    move-exception v4

    goto :goto_1f
.end method

.method private getFreeAdn()Landroid/database/MatrixCursor;
    .registers 9

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 45
    const/4 v2, 0x0

    .line 46
    .local v2, freeAdn:I
    new-instance v1, Landroid/database/MatrixCursor;

    new-array v4, v6, [Ljava/lang/String;

    const-string v5, "count"

    aput-object v5, v4, v7

    invoke-direct {v1, v4, v6}, Landroid/database/MatrixCursor;-><init>([Ljava/lang/String;I)V

    .line 50
    .local v1, cursor:Landroid/database/MatrixCursor;
    :try_start_e
    const-string/jumbo v4, "simphonebook"

    invoke-static {v4}, Landroid/os/ServiceManager;->getService(Ljava/lang/String;)Landroid/os/IBinder;

    move-result-object v4

    invoke-static {v4}, Lcom/android/internal/telephony/IIccPhoneBook$Stub;->asInterface(Landroid/os/IBinder;)Lcom/android/internal/telephony/IIccPhoneBook;

    move-result-object v3

    .line 52
    .local v3, iccIpb:Lcom/android/internal/telephony/IIccPhoneBook;
    if-eqz v3, :cond_1f

    .line 53
    invoke-interface {v3}, Lcom/android/internal/telephony/IIccPhoneBook;->getFreeAdn()I
    :try_end_1e
    .catch Landroid/os/RemoteException; {:try_start_e .. :try_end_1e} :catch_2d
    .catch Ljava/lang/SecurityException; {:try_start_e .. :try_end_1e} :catch_2b

    move-result v2

    .line 62
    .end local v3           #iccIpb:Lcom/android/internal/telephony/IIccPhoneBook;
    :cond_1f
    :goto_1f
    new-array v0, v6, [Ljava/lang/Object;

    .line 63
    .local v0, count:[Ljava/lang/Object;
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v0, v7

    .line 64
    invoke-virtual {v1, v0}, Landroid/database/MatrixCursor;->addRow([Ljava/lang/Object;)V

    .line 65
    return-object v1

    .line 57
    .end local v0           #count:[Ljava/lang/Object;
    :catch_2b
    move-exception v4

    goto :goto_1f

    .line 55
    :catch_2d
    move-exception v4

    goto :goto_1f
.end method


# virtual methods
.method public getType(Landroid/net/Uri;)Ljava/lang/String;
    .registers 3
    .parameter "url"

    .prologue
    .line 35
    sget-object v0, Lcom/android/internal/telephony/MiuiIccProvider;->URL_MATCHER:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    packed-switch v0, :pswitch_data_12

    .line 41
    invoke-super {p0, p1}, Lcom/android/internal/telephony/IccProvider;->getType(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v0

    :goto_d
    return-object v0

    .line 38
    :pswitch_e
    const-string/jumbo v0, "vnd.android.cursor.dir/sim-contact"

    goto :goto_d

    .line 35
    :pswitch_data_12
    .packed-switch 0x4
        :pswitch_e
        :pswitch_e
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
    .line 24
    sget-object v0, Lcom/android/internal/telephony/MiuiIccProvider;->URL_MATCHER:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    packed-switch v0, :pswitch_data_18

    .line 30
    invoke-super/range {p0 .. p5}, Lcom/android/internal/telephony/IccProvider;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    :goto_d
    return-object v0

    .line 26
    :pswitch_e
    invoke-direct {p0}, Lcom/android/internal/telephony/MiuiIccProvider;->getFreeAdn()Landroid/database/MatrixCursor;

    move-result-object v0

    goto :goto_d

    .line 28
    :pswitch_13
    invoke-direct {p0}, Lcom/android/internal/telephony/MiuiIccProvider;->getAdnCapacity()Landroid/database/MatrixCursor;

    move-result-object v0

    goto :goto_d

    .line 24
    :pswitch_data_18
    .packed-switch 0x4
        :pswitch_e
        :pswitch_13
    .end packed-switch
.end method
