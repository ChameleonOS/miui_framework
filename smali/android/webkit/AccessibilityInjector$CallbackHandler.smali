.class Landroid/webkit/AccessibilityInjector$CallbackHandler;
.super Ljava/lang/Object;
.source "AccessibilityInjector.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/AccessibilityInjector;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "CallbackHandler"
.end annotation


# static fields
.field private static final JAVASCRIPT_ACTION_TEMPLATE:Ljava/lang/String; = "javascript:(function() { %s.onResult(%d, %s); })();"

.field private static final RESULT_TIMEOUT:J = 0x1388L


# instance fields
.field private final mInterfaceName:Ljava/lang/String;

.field private mResult:Z

.field private mResultId:J

.field private final mResultIdCounter:Ljava/util/concurrent/atomic/AtomicInteger;

.field private final mResultLock:Ljava/lang/Object;


# direct methods
.method private constructor <init>(Ljava/lang/String;)V
    .registers 4
    .parameter "interfaceName"

    .prologue
    .line 527
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 520
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    iput-object v0, p0, Landroid/webkit/AccessibilityInjector$CallbackHandler;->mResultIdCounter:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 521
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/webkit/AccessibilityInjector$CallbackHandler;->mResultLock:Ljava/lang/Object;

    .line 524
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/webkit/AccessibilityInjector$CallbackHandler;->mResult:Z

    .line 525
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Landroid/webkit/AccessibilityInjector$CallbackHandler;->mResultId:J

    .line 528
    iput-object p1, p0, Landroid/webkit/AccessibilityInjector$CallbackHandler;->mInterfaceName:Ljava/lang/String;

    .line 529
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;Landroid/webkit/AccessibilityInjector$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 513
    invoke-direct {p0, p1}, Landroid/webkit/AccessibilityInjector$CallbackHandler;-><init>(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$100(Landroid/webkit/AccessibilityInjector$CallbackHandler;Landroid/webkit/WebView;Ljava/lang/String;)Z
    .registers 4
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"

    .prologue
    .line 513
    invoke-direct {p0, p1, p2}, Landroid/webkit/AccessibilityInjector$CallbackHandler;->performAction(Landroid/webkit/WebView;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method private clearResultLocked()V
    .registers 3

    .prologue
    .line 566
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Landroid/webkit/AccessibilityInjector$CallbackHandler;->mResultId:J

    .line 567
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/webkit/AccessibilityInjector$CallbackHandler;->mResult:Z

    .line 568
    return-void
.end method

.method private getResultAndClear(I)Z
    .registers 6
    .parameter "resultId"

    .prologue
    .line 554
    iget-object v3, p0, Landroid/webkit/AccessibilityInjector$CallbackHandler;->mResultLock:Ljava/lang/Object;

    monitor-enter v3

    .line 555
    :try_start_3
    invoke-direct {p0, p1}, Landroid/webkit/AccessibilityInjector$CallbackHandler;->waitForResultTimedLocked(I)Z

    move-result v1

    .line 556
    .local v1, success:Z
    if-eqz v1, :cond_10

    iget-boolean v0, p0, Landroid/webkit/AccessibilityInjector$CallbackHandler;->mResult:Z

    .line 557
    .local v0, result:Z
    :goto_b
    invoke-direct {p0}, Landroid/webkit/AccessibilityInjector$CallbackHandler;->clearResultLocked()V

    .line 558
    monitor-exit v3

    return v0

    .line 556
    .end local v0           #result:Z
    :cond_10
    const/4 v0, 0x0

    goto :goto_b

    .line 559
    .end local v1           #success:Z
    :catchall_12
    move-exception v2

    monitor-exit v3
    :try_end_14
    .catchall {:try_start_3 .. :try_end_14} :catchall_12

    throw v2
.end method

.method private performAction(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .registers 9
    .parameter "webView"
    .parameter "code"

    .prologue
    .line 539
    iget-object v2, p0, Landroid/webkit/AccessibilityInjector$CallbackHandler;->mResultIdCounter:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v2}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndIncrement()I

    move-result v0

    .line 540
    .local v0, resultId:I
    const-string v2, "javascript:(function() { %s.onResult(%d, %s); })();"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Landroid/webkit/AccessibilityInjector$CallbackHandler;->mInterfaceName:Ljava/lang/String;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x2

    aput-object p2, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 542
    .local v1, url:Ljava/lang/String;
    invoke-virtual {p1, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 544
    invoke-direct {p0, v0}, Landroid/webkit/AccessibilityInjector$CallbackHandler;->getResultAndClear(I)Z

    move-result v2

    return v2
.end method

.method private waitForResultTimedLocked(I)Z
    .registers 13
    .parameter "resultId"

    .prologue
    const/4 v6, 0x0

    .line 577
    const-wide/16 v4, 0x1388

    .line 578
    .local v4, waitTimeMillis:J
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v2

    .line 581
    .local v2, startTimeMillis:J
    :goto_7
    :try_start_7
    iget-wide v7, p0, Landroid/webkit/AccessibilityInjector$CallbackHandler;->mResultId:J

    int-to-long v9, p1

    cmp-long v7, v7, v9

    if-nez v7, :cond_10

    .line 582
    const/4 v6, 0x1

    .line 590
    :cond_f
    return v6

    .line 584
    :cond_10
    iget-wide v7, p0, Landroid/webkit/AccessibilityInjector$CallbackHandler;->mResultId:J

    int-to-long v9, p1

    cmp-long v7, v7, v9

    if-gtz v7, :cond_f

    .line 587
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v7

    sub-long v0, v7, v2

    .line 588
    .local v0, elapsedTimeMillis:J
    const-wide/16 v7, 0x1388

    sub-long v4, v7, v0

    .line 589
    const-wide/16 v7, 0x0

    cmp-long v7, v4, v7

    if-lez v7, :cond_f

    .line 592
    iget-object v7, p0, Landroid/webkit/AccessibilityInjector$CallbackHandler;->mResultLock:Ljava/lang/Object;

    invoke-virtual {v7, v4, v5}, Ljava/lang/Object;->wait(J)V
    :try_end_2c
    .catch Ljava/lang/InterruptedException; {:try_start_7 .. :try_end_2c} :catch_2d

    goto :goto_7

    .line 593
    .end local v0           #elapsedTimeMillis:J
    :catch_2d
    move-exception v7

    goto :goto_7
.end method


# virtual methods
.method public onResult(Ljava/lang/String;Ljava/lang/String;)V
    .registers 10
    .parameter "id"
    .parameter "result"

    .prologue
    .line 611
    :try_start_0
    invoke-static {p1}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
    :try_end_3
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_3} :catch_1c

    move-result-wide v1

    .line 616
    .local v1, resultId:J
    iget-object v4, p0, Landroid/webkit/AccessibilityInjector$CallbackHandler;->mResultLock:Ljava/lang/Object;

    monitor-enter v4

    .line 617
    :try_start_7
    iget-wide v5, p0, Landroid/webkit/AccessibilityInjector$CallbackHandler;->mResultId:J

    cmp-long v3, v1, v5

    if-lez v3, :cond_15

    .line 618
    invoke-static {p2}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v3

    iput-boolean v3, p0, Landroid/webkit/AccessibilityInjector$CallbackHandler;->mResult:Z

    .line 619
    iput-wide v1, p0, Landroid/webkit/AccessibilityInjector$CallbackHandler;->mResultId:J

    .line 621
    :cond_15
    iget-object v3, p0, Landroid/webkit/AccessibilityInjector$CallbackHandler;->mResultLock:Ljava/lang/Object;

    invoke-virtual {v3}, Ljava/lang/Object;->notifyAll()V

    .line 622
    monitor-exit v4

    .line 623
    .end local v1           #resultId:J
    :goto_1b
    return-void

    .line 612
    :catch_1c
    move-exception v0

    .line 613
    .local v0, e:Ljava/lang/NumberFormatException;
    goto :goto_1b

    .line 622
    .end local v0           #e:Ljava/lang/NumberFormatException;
    .restart local v1       #resultId:J
    :catchall_1e
    move-exception v3

    monitor-exit v4
    :try_end_20
    .catchall {:try_start_7 .. :try_end_20} :catchall_1e

    throw v3
.end method
