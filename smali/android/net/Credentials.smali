.class public Landroid/net/Credentials;
.super Ljava/lang/Object;
.source "Credentials.java"


# instance fields
.field private final gid:I

.field private final pid:I

.field private final uid:I


# direct methods
.method public constructor <init>(III)V
    .registers 4
    .parameter "pid"
    .parameter "uid"
    .parameter "gid"

    .prologue
    .line 31
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 32
    iput p1, p0, Landroid/net/Credentials;->pid:I

    .line 33
    iput p2, p0, Landroid/net/Credentials;->uid:I

    .line 34
    iput p3, p0, Landroid/net/Credentials;->gid:I

    .line 35
    return-void
.end method


# virtual methods
.method public getGid()I
    .registers 2

    .prologue
    .line 46
    iget v0, p0, Landroid/net/Credentials;->gid:I

    return v0
.end method

.method public getPid()I
    .registers 2

    .prologue
    .line 38
    iget v0, p0, Landroid/net/Credentials;->pid:I

    return v0
.end method

.method public getUid()I
    .registers 2

    .prologue
    .line 42
    iget v0, p0, Landroid/net/Credentials;->uid:I

    return v0
.end method
