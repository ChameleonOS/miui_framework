.class public Landroid/bluetooth/BluetoothClass$Device$Major;
.super Ljava/lang/Object;
.source "BluetoothClass.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/bluetooth/BluetoothClass$Device;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Major"
.end annotation


# static fields
.field public static final AUDIO_VIDEO:I = 0x400

.field private static final BITMASK:I = 0x1f00

.field public static final COMPUTER:I = 0x100

.field public static final HEALTH:I = 0x900

.field public static final IMAGING:I = 0x600

.field public static final MISC:I = 0x0

.field public static final NETWORKING:I = 0x300

.field public static final PERIPHERAL:I = 0x500

.field public static final PHONE:I = 0x200

.field public static final TOY:I = 0x800

.field public static final UNCATEGORIZED:I = 0x1f00

.field public static final WEARABLE:I = 0x700


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 150
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
