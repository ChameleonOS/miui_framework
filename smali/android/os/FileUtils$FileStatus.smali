.class public final Landroid/os/FileUtils$FileStatus;
.super Ljava/lang/Object;
.source "FileUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/os/FileUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "FileStatus"
.end annotation

.annotation runtime Ljava/lang/Deprecated;
.end annotation


# instance fields
.field public atime:J

.field public blksize:I

.field public blocks:J

.field public ctime:J

.field public dev:I

.field public gid:I

.field public ino:I

.field public mode:I

.field public mtime:J

.field public nlink:I

.field public rdev:I

.field public size:J

.field public uid:I


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 61
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
