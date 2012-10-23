.class final Lmiui/util/MiuiDateUtils$2;
.super Lmiui/util/SimplePool$Manager;
.source "MiuiDateUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/util/MiuiDateUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lmiui/util/SimplePool$Manager",
        "<",
        "Landroid/text/format/Time;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 28
    invoke-direct {p0}, Lmiui/util/SimplePool$Manager;-><init>()V

    return-void
.end method


# virtual methods
.method public createInstance()Landroid/text/format/Time;
    .registers 2

    .prologue
    .line 31
    new-instance v0, Landroid/text/format/Time;

    invoke-direct {v0}, Landroid/text/format/Time;-><init>()V

    return-object v0
.end method

.method public bridge synthetic createInstance()Ljava/lang/Object;
    .registers 2

    .prologue
    .line 28
    invoke-virtual {p0}, Lmiui/util/MiuiDateUtils$2;->createInstance()Landroid/text/format/Time;

    move-result-object v0

    return-object v0
.end method
