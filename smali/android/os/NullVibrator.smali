.class public Landroid/os/NullVibrator;
.super Landroid/os/Vibrator;
.source "NullVibrator.java"


# static fields
.field private static final sInstance:Landroid/os/NullVibrator;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    new-instance v0, Landroid/os/NullVibrator;

    invoke-direct {v0}, Landroid/os/NullVibrator;-><init>()V

    sput-object v0, Landroid/os/NullVibrator;->sInstance:Landroid/os/NullVibrator;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .prologue
    invoke-direct {p0}, Landroid/os/Vibrator;-><init>()V

    return-void
.end method

.method public static getInstance()Landroid/os/NullVibrator;
    .registers 1

    .prologue
    sget-object v0, Landroid/os/NullVibrator;->sInstance:Landroid/os/NullVibrator;

    return-object v0
.end method


# virtual methods
.method public cancel()V
    .registers 1

    .prologue
    return-void
.end method

.method public hasVibrator()Z
    .registers 2

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public vibrate(J)V
    .registers 3
    .parameter "milliseconds"

    .prologue
    return-void
.end method

.method public vibrate([JI)V
    .registers 4
    .parameter "pattern"
    .parameter "repeat"

    .prologue
    array-length v0, p1

    if-lt p2, v0, :cond_9

    new-instance v0, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v0

    :cond_9
    return-void
.end method
