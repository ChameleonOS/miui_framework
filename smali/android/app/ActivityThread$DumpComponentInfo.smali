.class final Landroid/app/ActivityThread$DumpComponentInfo;
.super Ljava/lang/Object;
.source "ActivityThread.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/app/ActivityThread;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "DumpComponentInfo"
.end annotation


# instance fields
.field args:[Ljava/lang/String;

.field fd:Landroid/os/ParcelFileDescriptor;

.field prefix:Ljava/lang/String;

.field token:Landroid/os/IBinder;


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
