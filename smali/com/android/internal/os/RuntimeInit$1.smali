.class final Lcom/android/internal/os/RuntimeInit$1;
.super Lorg/apache/harmony/luni/internal/util/TimezoneGetter;
.source "RuntimeInit.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/internal/os/RuntimeInit;->commonInit()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 101
    invoke-direct {p0}, Lorg/apache/harmony/luni/internal/util/TimezoneGetter;-><init>()V

    return-void
.end method


# virtual methods
.method public getId()Ljava/lang/String;
    .registers 2

    .prologue
    .line 104
    const-string/jumbo v0, "persist.sys.timezone"

    invoke-static {v0}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
