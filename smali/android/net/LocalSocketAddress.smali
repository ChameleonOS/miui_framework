.class public Landroid/net/LocalSocketAddress;
.super Ljava/lang/Object;
.source "LocalSocketAddress.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/net/LocalSocketAddress$Namespace;
    }
.end annotation


# instance fields
.field private final name:Ljava/lang/String;

.field private final namespace:Landroid/net/LocalSocketAddress$Namespace;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .registers 3
    .parameter "name"

    .prologue
    .line 80
    sget-object v0, Landroid/net/LocalSocketAddress$Namespace;->ABSTRACT:Landroid/net/LocalSocketAddress$Namespace;

    invoke-direct {p0, p1, v0}, Landroid/net/LocalSocketAddress;-><init>(Ljava/lang/String;Landroid/net/LocalSocketAddress$Namespace;)V

    .line 81
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Landroid/net/LocalSocketAddress$Namespace;)V
    .registers 3
    .parameter "name"
    .parameter "namespace"

    .prologue
    .line 68
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 69
    iput-object p1, p0, Landroid/net/LocalSocketAddress;->name:Ljava/lang/String;

    .line 70
    iput-object p2, p0, Landroid/net/LocalSocketAddress;->namespace:Landroid/net/LocalSocketAddress$Namespace;

    .line 71
    return-void
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .registers 2

    .prologue
    .line 89
    iget-object v0, p0, Landroid/net/LocalSocketAddress;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getNamespace()Landroid/net/LocalSocketAddress$Namespace;
    .registers 2

    .prologue
    .line 98
    iget-object v0, p0, Landroid/net/LocalSocketAddress;->namespace:Landroid/net/LocalSocketAddress$Namespace;

    return-object v0
.end method
