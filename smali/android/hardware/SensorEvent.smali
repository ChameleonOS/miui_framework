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
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    new-array v0, p1, [F

    iput-object v0, p0, Landroid/hardware/SensorEvent;->values:[F

    return-void
.end method
