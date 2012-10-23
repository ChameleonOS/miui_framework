.class final Lmiui/util/MiuiDateUtils$1;
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
        "Ljava/nio/CharBuffer;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 16
    invoke-direct {p0}, Lmiui/util/SimplePool$Manager;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic createInstance()Ljava/lang/Object;
    .registers 2

    .prologue
    .line 16
    invoke-virtual {p0}, Lmiui/util/MiuiDateUtils$1;->createInstance()Ljava/nio/CharBuffer;

    move-result-object v0

    return-object v0
.end method

.method public createInstance()Ljava/nio/CharBuffer;
    .registers 2

    .prologue
    .line 19
    const/16 v0, 0x40

    invoke-static {v0}, Ljava/nio/CharBuffer;->allocate(I)Ljava/nio/CharBuffer;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic onRelease(Ljava/lang/Object;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 16
    check-cast p1, Ljava/nio/CharBuffer;

    .end local p1
    invoke-virtual {p0, p1}, Lmiui/util/MiuiDateUtils$1;->onRelease(Ljava/nio/CharBuffer;)V

    return-void
.end method

.method public onRelease(Ljava/nio/CharBuffer;)V
    .registers 2
    .parameter "element"

    .prologue
    .line 23
    invoke-virtual {p1}, Ljava/nio/CharBuffer;->clear()Ljava/nio/Buffer;

    .line 24
    return-void
.end method
