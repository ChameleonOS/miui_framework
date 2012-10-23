.class Landroid/accounts/AccountManagerService$UserAccounts;
.super Ljava/lang/Object;
.source "AccountManagerService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/accounts/AccountManagerService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "UserAccounts"
.end annotation


# instance fields
.field private final accountCache:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "[",
            "Landroid/accounts/Account;",
            ">;"
        }
    .end annotation
.end field

.field private authTokenCache:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Landroid/accounts/Account;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field private final cacheLock:Ljava/lang/Object;

.field private final credentialsPermissionNotificationIds:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Landroid/util/Pair",
            "<",
            "Landroid/util/Pair",
            "<",
            "Landroid/accounts/Account;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/Integer;",
            ">;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private final openHelper:Landroid/accounts/AccountManagerService$DatabaseHelper;

.field private final signinRequiredNotificationIds:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Landroid/accounts/Account;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private userDataCache:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Landroid/accounts/Account;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field private final userId:I


# direct methods
.method constructor <init>(Landroid/content/Context;I)V
    .registers 5
    .parameter "context"
    .parameter "userId"

    .prologue
    .line 175
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 159
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/accounts/AccountManagerService$UserAccounts;->credentialsPermissionNotificationIds:Ljava/util/HashMap;

    .line 162
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/accounts/AccountManagerService$UserAccounts;->signinRequiredNotificationIds:Ljava/util/HashMap;

    .line 164
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/accounts/AccountManagerService$UserAccounts;->cacheLock:Ljava/lang/Object;

    .line 166
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v0, p0, Landroid/accounts/AccountManagerService$UserAccounts;->accountCache:Ljava/util/HashMap;

    .line 169
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/accounts/AccountManagerService$UserAccounts;->userDataCache:Ljava/util/HashMap;

    .line 172
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/accounts/AccountManagerService$UserAccounts;->authTokenCache:Ljava/util/HashMap;

    .line 176
    iput p2, p0, Landroid/accounts/AccountManagerService$UserAccounts;->userId:I

    .line 177
    iget-object v1, p0, Landroid/accounts/AccountManagerService$UserAccounts;->cacheLock:Ljava/lang/Object;

    monitor-enter v1

    .line 178
    :try_start_32
    new-instance v0, Landroid/accounts/AccountManagerService$DatabaseHelper;

    invoke-direct {v0, p1, p2}, Landroid/accounts/AccountManagerService$DatabaseHelper;-><init>(Landroid/content/Context;I)V

    iput-object v0, p0, Landroid/accounts/AccountManagerService$UserAccounts;->openHelper:Landroid/accounts/AccountManagerService$DatabaseHelper;

    .line 179
    monitor-exit v1

    .line 180
    return-void

    .line 179
    :catchall_3b
    move-exception v0

    monitor-exit v1
    :try_end_3d
    .catchall {:try_start_32 .. :try_end_3d} :catchall_3b

    throw v0
.end method

.method static synthetic access$1300(Landroid/accounts/AccountManagerService$UserAccounts;)Ljava/util/HashMap;
    .registers 2
    .parameter "x0"

    .prologue
    .line 156
    iget-object v0, p0, Landroid/accounts/AccountManagerService$UserAccounts;->signinRequiredNotificationIds:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$200(Landroid/accounts/AccountManagerService$UserAccounts;)Ljava/lang/Object;
    .registers 2
    .parameter "x0"

    .prologue
    .line 156
    iget-object v0, p0, Landroid/accounts/AccountManagerService$UserAccounts;->cacheLock:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$300(Landroid/accounts/AccountManagerService$UserAccounts;)Landroid/accounts/AccountManagerService$DatabaseHelper;
    .registers 2
    .parameter "x0"

    .prologue
    .line 156
    iget-object v0, p0, Landroid/accounts/AccountManagerService$UserAccounts;->openHelper:Landroid/accounts/AccountManagerService$DatabaseHelper;

    return-object v0
.end method

.method static synthetic access$400(Landroid/accounts/AccountManagerService$UserAccounts;)Ljava/util/HashMap;
    .registers 2
    .parameter "x0"

    .prologue
    .line 156
    iget-object v0, p0, Landroid/accounts/AccountManagerService$UserAccounts;->accountCache:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$500(Landroid/accounts/AccountManagerService$UserAccounts;)Ljava/util/HashMap;
    .registers 2
    .parameter "x0"

    .prologue
    .line 156
    iget-object v0, p0, Landroid/accounts/AccountManagerService$UserAccounts;->userDataCache:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$600(Landroid/accounts/AccountManagerService$UserAccounts;)Ljava/util/HashMap;
    .registers 2
    .parameter "x0"

    .prologue
    .line 156
    iget-object v0, p0, Landroid/accounts/AccountManagerService$UserAccounts;->authTokenCache:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$700(Landroid/accounts/AccountManagerService$UserAccounts;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 156
    iget v0, p0, Landroid/accounts/AccountManagerService$UserAccounts;->userId:I

    return v0
.end method

.method static synthetic access$800(Landroid/accounts/AccountManagerService$UserAccounts;)Ljava/util/HashMap;
    .registers 2
    .parameter "x0"

    .prologue
    .line 156
    iget-object v0, p0, Landroid/accounts/AccountManagerService$UserAccounts;->credentialsPermissionNotificationIds:Ljava/util/HashMap;

    return-object v0
.end method
