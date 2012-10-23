.class Lmiui/security/MiuiLockPatternUtils$PasswordFileObserver;
.super Landroid/os/FileObserver;
.source "MiuiLockPatternUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/security/MiuiLockPatternUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "PasswordFileObserver"
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/String;I)V
    .registers 3
    .parameter "path"
    .parameter "mask"

    .prologue
    .line 34
    invoke-direct {p0, p1, p2}, Landroid/os/FileObserver;-><init>(Ljava/lang/String;I)V

    .line 35
    return-void
.end method


# virtual methods
.method public onEvent(ILjava/lang/String;)V
    .registers 9
    .parameter "event"
    .parameter "path"

    .prologue
    .line 39
    const-string v0, "access_control.key"

    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2a

    .line 40
    const-string v0, "MiuiLockPatternUtils"

    const-string v1, "access control password file changed"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 41
    invoke-static {}, Lmiui/security/MiuiLockPatternUtils;->access$100()Ljava/util/concurrent/atomic/AtomicBoolean;

    move-result-object v1

    new-instance v0, Ljava/io/File;

    invoke-static {}, Lmiui/security/MiuiLockPatternUtils;->access$000()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->length()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v0, v2, v4

    if-lez v0, :cond_2b

    const/4 v0, 0x1

    :goto_27
    invoke-virtual {v1, v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 43
    :cond_2a
    return-void

    .line 41
    :cond_2b
    const/4 v0, 0x0

    goto :goto_27
.end method
