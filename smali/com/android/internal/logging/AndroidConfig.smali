.class public Lcom/android/internal/logging/AndroidConfig;
.super Ljava/lang/Object;
.source "AndroidConfig.java"


# direct methods
.method public constructor <init>()V
    .registers 5

    .prologue
    .line 34
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 37
    :try_start_3
    const-string v2, ""

    invoke-static {v2}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v1

    .line 38
    .local v1, rootLogger:Ljava/util/logging/Logger;
    new-instance v2, Lcom/android/internal/logging/AndroidHandler;

    invoke-direct {v2}, Lcom/android/internal/logging/AndroidHandler;-><init>()V

    invoke-virtual {v1, v2}, Ljava/util/logging/Logger;->addHandler(Ljava/util/logging/Handler;)V

    .line 39
    sget-object v2, Ljava/util/logging/Level;->INFO:Ljava/util/logging/Level;

    invoke-virtual {v1, v2}, Ljava/util/logging/Logger;->setLevel(Ljava/util/logging/Level;)V

    .line 42
    const-string/jumbo v2, "org.apache"

    invoke-static {v2}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v2

    sget-object v3, Ljava/util/logging/Level;->WARNING:Ljava/util/logging/Level;

    invoke-virtual {v2, v3}, Ljava/util/logging/Logger;->setLevel(Ljava/util/logging/Level;)V
    :try_end_22
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_22} :catch_23

    .line 46
    .end local v1           #rootLogger:Ljava/util/logging/Logger;
    :goto_22
    return-void

    .line 43
    :catch_23
    move-exception v0

    .line 44
    .local v0, ex:Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_22
.end method
