.class Landroid/net/http/Timer;
.super Ljava/lang/Object;
.source "Timer.java"


# instance fields
.field private mLast:J

.field private mStart:J


# direct methods
.method public constructor <init>()V
    .registers 3

    .prologue
    .line 30
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 31
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Landroid/net/http/Timer;->mLast:J

    iput-wide v0, p0, Landroid/net/http/Timer;->mStart:J

    .line 32
    return-void
.end method


# virtual methods
.method public mark(Ljava/lang/String;)V
    .registers 4
    .parameter "message"

    .prologue
    .line 35
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    .line 39
    .local v0, now:J
    iput-wide v0, p0, Landroid/net/http/Timer;->mLast:J

    .line 40
    return-void
.end method
