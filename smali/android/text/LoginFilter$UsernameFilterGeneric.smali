.class public Landroid/text/LoginFilter$UsernameFilterGeneric;
.super Landroid/text/LoginFilter;
.source "LoginFilter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/text/LoginFilter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UsernameFilterGeneric"
.end annotation


# static fields
.field private static final mAllowed:Ljava/lang/String; = "@_-+."


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 168
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroid/text/LoginFilter;-><init>(Z)V

    .line 169
    return-void
.end method

.method public constructor <init>(Z)V
    .registers 2
    .parameter "appendInvalid"

    .prologue
    .line 172
    invoke-direct {p0, p1}, Landroid/text/LoginFilter;-><init>(Z)V

    .line 173
    return-void
.end method


# virtual methods
.method public isAllowed(C)Z
    .registers 5
    .parameter "c"

    .prologue
    const/4 v0, 0x1

    .line 178
    const/16 v1, 0x30

    if-gt v1, p1, :cond_a

    const/16 v1, 0x39

    if-gt p1, v1, :cond_a

    .line 186
    :cond_9
    :goto_9
    return v0

    .line 180
    :cond_a
    const/16 v1, 0x61

    if-gt v1, p1, :cond_12

    const/16 v1, 0x7a

    if-le p1, v1, :cond_9

    .line 182
    :cond_12
    const/16 v1, 0x41

    if-gt v1, p1, :cond_1a

    const/16 v1, 0x5a

    if-le p1, v1, :cond_9

    .line 184
    :cond_1a
    const-string v1, "@_-+."

    invoke-virtual {v1, p1}, Ljava/lang/String;->indexOf(I)I

    move-result v1

    const/4 v2, -0x1

    if-ne v1, v2, :cond_9

    .line 186
    const/4 v0, 0x0

    goto :goto_9
.end method
