.class public Landroid/content/IntentFilter$MalformedMimeTypeException;
.super Landroid/util/AndroidException;
.source "IntentFilter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/content/IntentFilter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MalformedMimeTypeException"
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 306
    invoke-direct {p0}, Landroid/util/AndroidException;-><init>()V

    .line 307
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .registers 2
    .parameter "name"

    .prologue
    .line 310
    invoke-direct {p0, p1}, Landroid/util/AndroidException;-><init>(Ljava/lang/String;)V

    .line 311
    return-void
.end method
