.class public Landroid/content/MutableContextWrapper;
.super Landroid/content/ContextWrapper;
.source "MutableContextWrapper.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 2
    .parameter "base"

    .prologue
    .line 25
    invoke-direct {p0, p1}, Landroid/content/ContextWrapper;-><init>(Landroid/content/Context;)V

    .line 26
    return-void
.end method


# virtual methods
.method public setBaseContext(Landroid/content/Context;)V
    .registers 2
    .parameter "base"

    .prologue
    .line 36
    iput-object p1, p0, Landroid/content/ContextWrapper;->mBase:Landroid/content/Context;

    .line 37
    return-void
.end method
