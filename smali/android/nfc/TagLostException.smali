.class public Landroid/nfc/TagLostException;
.super Ljava/io/IOException;
.source "TagLostException.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct {p0}, Ljava/io/IOException;-><init>()V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .registers 2
    .parameter "message"

    .prologue
    invoke-direct {p0, p1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    return-void
.end method
