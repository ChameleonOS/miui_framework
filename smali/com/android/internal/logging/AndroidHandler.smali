.class public Lcom/android/internal/logging/AndroidHandler;
.super Ljava/util/logging/Handler;
.source "AndroidHandler.java"

# interfaces
.implements Ldalvik/system/DalvikLogHandler;


# static fields
.field private static final THE_FORMATTER:Ljava/util/logging/Formatter;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    new-instance v0, Lcom/android/internal/logging/AndroidHandler$1;

    invoke-direct {v0}, Lcom/android/internal/logging/AndroidHandler$1;-><init>()V

    sput-object v0, Lcom/android/internal/logging/AndroidHandler;->THE_FORMATTER:Ljava/util/logging/Formatter;

    return-void
.end method

.method public constructor <init>()V
    .registers 2

    .prologue
    invoke-direct {p0}, Ljava/util/logging/Handler;-><init>()V

    sget-object v0, Lcom/android/internal/logging/AndroidHandler;->THE_FORMATTER:Ljava/util/logging/Formatter;

    invoke-virtual {p0, v0}, Lcom/android/internal/logging/AndroidHandler;->setFormatter(Ljava/util/logging/Formatter;)V

    return-void
.end method

.method static getAndroidLevel(Ljava/util/logging/Level;)I
    .registers 3
    .parameter "level"

    .prologue
    invoke-virtual {p0}, Ljava/util/logging/Level;->intValue()I

    move-result v0

    .local v0, value:I
    const/16 v1, 0x3e8

    if-lt v0, v1, :cond_a

    const/4 v1, 0x6

    :goto_9
    return v1

    :cond_a
    const/16 v1, 0x384

    if-lt v0, v1, :cond_10

    const/4 v1, 0x5

    goto :goto_9

    :cond_10
    const/16 v1, 0x320

    if-lt v0, v1, :cond_16

    const/4 v1, 0x4

    goto :goto_9

    :cond_16
    const/4 v1, 0x3

    goto :goto_9
.end method


# virtual methods
.method public close()V
    .registers 1

    .prologue
    return-void
.end method

.method public flush()V
    .registers 1

    .prologue
    return-void
.end method

.method public publish(Ljava/util/logging/LogRecord;)V
    .registers 8
    .parameter "record"

    .prologue
    invoke-virtual {p1}, Ljava/util/logging/LogRecord;->getLevel()Ljava/util/logging/Level;

    move-result-object v4

    invoke-static {v4}, Lcom/android/internal/logging/AndroidHandler;->getAndroidLevel(Ljava/util/logging/Level;)I

    move-result v1

    .local v1, level:I
    invoke-virtual {p1}, Ljava/util/logging/LogRecord;->getLoggerName()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ldalvik/system/DalvikLogging;->loggerNameToTag(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .local v3, tag:Ljava/lang/String;
    invoke-static {v3, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v4

    if-nez v4, :cond_17

    :goto_16
    return-void

    :cond_17
    :try_start_17
    invoke-virtual {p0}, Lcom/android/internal/logging/AndroidHandler;->getFormatter()Ljava/util/logging/Formatter;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/util/logging/Formatter;->format(Ljava/util/logging/LogRecord;)Ljava/lang/String;

    move-result-object v2

    .local v2, message:Ljava/lang/String;
    invoke-static {v1, v3, v2}, Landroid/util/Log;->println(ILjava/lang/String;Ljava/lang/String;)I
    :try_end_22
    .catch Ljava/lang/RuntimeException; {:try_start_17 .. :try_end_22} :catch_23

    goto :goto_16

    .end local v2           #message:Ljava/lang/String;
    :catch_23
    move-exception v0

    .local v0, e:Ljava/lang/RuntimeException;
    const-string v4, "AndroidHandler"

    const-string v5, "Error logging message."

    invoke-static {v4, v5, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_16
.end method

.method public publish(Ljava/util/logging/Logger;Ljava/lang/String;Ljava/util/logging/Level;Ljava/lang/String;)V
    .registers 9
    .parameter "source"
    .parameter "tag"
    .parameter "level"
    .parameter "message"

    .prologue
    invoke-static {p3}, Lcom/android/internal/logging/AndroidHandler;->getAndroidLevel(Ljava/util/logging/Level;)I

    move-result v1

    .local v1, priority:I
    invoke-static {p2, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v2

    if-nez v2, :cond_b

    :goto_a
    return-void

    :cond_b
    :try_start_b
    invoke-static {v1, p2, p4}, Landroid/util/Log;->println(ILjava/lang/String;Ljava/lang/String;)I
    :try_end_e
    .catch Ljava/lang/RuntimeException; {:try_start_b .. :try_end_e} :catch_f

    goto :goto_a

    :catch_f
    move-exception v0

    .local v0, e:Ljava/lang/RuntimeException;
    const-string v2, "AndroidHandler"

    const-string v3, "Error logging message."

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_a
.end method
