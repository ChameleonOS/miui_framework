.class public Landroid/hardware/SensorEvent;
.super Ljava/lang/Object;
.source "SensorEvent.java"


# instance fields
.field public accuracy:I

.field public sensor:Landroid/hardware/Sensor;

.field public timestamp:J

.field public final values:[F


# direct methods
.method constructor <init>(I)V
    .registers 3
    .parameter "size"

    .prologue
    .line 455
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 456
    new-array v0, p1, [F

    iput-object v0, p0, Landroid/hardware/SensorEvent;->values:[F

    .line 457
    return-void
.end method
