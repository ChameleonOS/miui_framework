.class public Landroid/text/LoginFilter$PasswordFilterGMail;
.super Landroid/text/LoginFilter;
.source "LoginFilter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/text/LoginFilter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PasswordFilterGMail"
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 198
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroid/text/LoginFilter;-><init>(Z)V

    .line 199
    return-void
.end method

.method public constructor <init>(Z)V
    .registers 2
    .parameter "appendInvalid"

    .prologue
    .line 202
    invoke-direct {p0, p1}, Landroid/text/LoginFilter;-><init>(Z)V

    .line 203
    return-void
.end method


# virtual methods
.method public isAllowed(C)Z
    .registers 4
    .parameter "c"

    .prologue
    const/4 v0, 0x1

    .line 208
    const/16 v1, 0x20

    if-gt v1, p1, :cond_a

    const/16 v1, 0x7f

    if-gt p1, v1, :cond_a

    .line 213
    :cond_9
    :goto_9
    return v0

    .line 211
    :cond_a
    const/16 v1, 0xa0

    if-gt v1, p1, :cond_12

    const/16 v1, 0xff

    if-le p1, v1, :cond_9

    .line 213
    :cond_12
    const/4 v0, 0x0

    goto :goto_9
.end method
