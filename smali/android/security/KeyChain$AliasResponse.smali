.class Landroid/security/KeyChain$AliasResponse;
.super Landroid/security/IKeyChainAliasCallback$Stub;
.source "KeyChain.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/security/KeyChain;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "AliasResponse"
.end annotation


# instance fields
.field private final keyChainAliasResponse:Landroid/security/KeyChainAliasCallback;


# direct methods
.method private constructor <init>(Landroid/security/KeyChainAliasCallback;)V
    .registers 2
    .parameter "keyChainAliasResponse"

    .prologue
    .line 284
    invoke-direct {p0}, Landroid/security/IKeyChainAliasCallback$Stub;-><init>()V

    .line 285
    iput-object p1, p0, Landroid/security/KeyChain$AliasResponse;->keyChainAliasResponse:Landroid/security/KeyChainAliasCallback;

    .line 286
    return-void
.end method

.method synthetic constructor <init>(Landroid/security/KeyChainAliasCallback;Landroid/security/KeyChain$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 282
    invoke-direct {p0, p1}, Landroid/security/KeyChain$AliasResponse;-><init>(Landroid/security/KeyChainAliasCallback;)V

    return-void
.end method


# virtual methods
.method public alias(Ljava/lang/String;)V
    .registers 3
    .parameter "alias"

    .prologue
    .line 288
    iget-object v0, p0, Landroid/security/KeyChain$AliasResponse;->keyChainAliasResponse:Landroid/security/KeyChainAliasCallback;

    invoke-interface {v0, p1}, Landroid/security/KeyChainAliasCallback;->alias(Ljava/lang/String;)V

    .line 289
    return-void
.end method
