.class public Landroid/content/SyncStorageEngine$SyncHistoryItem;
.super Ljava/lang/Object;
.source "SyncStorageEngine.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/content/SyncStorageEngine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SyncHistoryItem"
.end annotation


# instance fields
.field authorityId:I

.field downstreamActivity:J

.field elapsedTime:J

.field event:I

.field eventTime:J

.field historyId:I

.field initialization:Z

.field mesg:Ljava/lang/String;

.field source:I

.field upstreamActivity:J


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 237
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
