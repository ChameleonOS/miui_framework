.class Landroid/accounts/AccountAuthenticatorCache;
.super Landroid/content/pm/RegisteredServicesCache;
.source "AccountAuthenticatorCache.java"

# interfaces
.implements Landroid/accounts/IAccountAuthenticatorCache;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/accounts/AccountAuthenticatorCache$1;,
        Landroid/accounts/AccountAuthenticatorCache$MySerializer;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/content/pm/RegisteredServicesCache",
        "<",
        "Landroid/accounts/AuthenticatorDescription;",
        ">;",
        "Landroid/accounts/IAccountAuthenticatorCache;"
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "Account"

.field private static final sSerializer:Landroid/accounts/AccountAuthenticatorCache$MySerializer;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    new-instance v0, Landroid/accounts/AccountAuthenticatorCache$MySerializer;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Landroid/accounts/AccountAuthenticatorCache$MySerializer;-><init>(Landroid/accounts/AccountAuthenticatorCache$1;)V

    sput-object v0, Landroid/accounts/AccountAuthenticatorCache;->sSerializer:Landroid/accounts/AccountAuthenticatorCache$MySerializer;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .registers 8
    .parameter "context"

    .prologue
    const-string v2, "android.accounts.AccountAuthenticator"

    const-string v3, "android.accounts.AccountAuthenticator"

    const-string v4, "account-authenticator"

    sget-object v5, Landroid/accounts/AccountAuthenticatorCache;->sSerializer:Landroid/accounts/AccountAuthenticatorCache$MySerializer;

    move-object v0, p0

    move-object v1, p1

    invoke-direct/range {v0 .. v5}, Landroid/content/pm/RegisteredServicesCache;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/pm/XmlSerializerAndParser;)V

    return-void
.end method


# virtual methods
.method public bridge synthetic getServiceInfo(Landroid/accounts/AuthenticatorDescription;)Landroid/content/pm/RegisteredServicesCache$ServiceInfo;
    .registers 3
    .parameter "x0"

    .prologue
    invoke-super {p0, p1}, Landroid/content/pm/RegisteredServicesCache;->getServiceInfo(Ljava/lang/Object;)Landroid/content/pm/RegisteredServicesCache$ServiceInfo;

    move-result-object v0

    return-object v0
.end method

.method public parseServiceAttributes(Landroid/content/res/Resources;Ljava/lang/String;Landroid/util/AttributeSet;)Landroid/accounts/AuthenticatorDescription;
    .registers 13
    .parameter "res"
    .parameter "packageName"
    .parameter "attrs"

    .prologue
    sget-object v0, Lcom/android/internal/R$styleable;->AccountAuthenticator:[I

    invoke-virtual {p1, p3, v0}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v8

    .local v8, sa:Landroid/content/res/TypedArray;
    const/4 v0, 0x2

    :try_start_7
    invoke-virtual {v8, v0}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v1

    .local v1, accountType:Ljava/lang/String;
    const/4 v0, 0x0

    const/4 v2, 0x0

    invoke-virtual {v8, v0, v2}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v3

    .local v3, labelId:I
    const/4 v0, 0x1

    const/4 v2, 0x0

    invoke-virtual {v8, v0, v2}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v4

    .local v4, iconId:I
    const/4 v0, 0x3

    const/4 v2, 0x0

    invoke-virtual {v8, v0, v2}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v5

    .local v5, smallIconId:I
    const/4 v0, 0x4

    const/4 v2, 0x0

    invoke-virtual {v8, v0, v2}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v6

    .local v6, prefId:I
    const/4 v0, 0x5

    const/4 v2, 0x0

    invoke-virtual {v8, v0, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v7

    .local v7, customTokens:Z
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    :try_end_2c
    .catchall {:try_start_7 .. :try_end_2c} :catchall_3b

    move-result v0

    if-eqz v0, :cond_34

    const/4 v0, 0x0

    :goto_30
    invoke-virtual {v8}, Landroid/content/res/TypedArray;->recycle()V

    return-object v0

    :cond_34
    :try_start_34
    new-instance v0, Landroid/accounts/AuthenticatorDescription;

    move-object v2, p2

    invoke-direct/range {v0 .. v7}, Landroid/accounts/AuthenticatorDescription;-><init>(Ljava/lang/String;Ljava/lang/String;IIIIZ)V
    :try_end_3a
    .catchall {:try_start_34 .. :try_end_3a} :catchall_3b

    goto :goto_30

    .end local v1           #accountType:Ljava/lang/String;
    .end local v3           #labelId:I
    .end local v4           #iconId:I
    .end local v5           #smallIconId:I
    .end local v6           #prefId:I
    .end local v7           #customTokens:Z
    :catchall_3b
    move-exception v0

    invoke-virtual {v8}, Landroid/content/res/TypedArray;->recycle()V

    throw v0
.end method

.method public bridge synthetic parseServiceAttributes(Landroid/content/res/Resources;Ljava/lang/String;Landroid/util/AttributeSet;)Ljava/lang/Object;
    .registers 5
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"

    .prologue
    invoke-virtual {p0, p1, p2, p3}, Landroid/accounts/AccountAuthenticatorCache;->parseServiceAttributes(Landroid/content/res/Resources;Ljava/lang/String;Landroid/util/AttributeSet;)Landroid/accounts/AuthenticatorDescription;

    move-result-object v0

    return-object v0
.end method
