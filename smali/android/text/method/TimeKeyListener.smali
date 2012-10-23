.class public Landroid/text/method/TimeKeyListener;
.super Landroid/text/method/NumberKeyListener;
.source "TimeKeyListener.java"


# static fields
.field public static final CHARACTERS:[C

.field private static sInstance:Landroid/text/method/TimeKeyListener;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 56
    const/16 v0, 0xe

    new-array v0, v0, [C

    fill-array-data v0, :array_a

    sput-object v0, Landroid/text/method/TimeKeyListener;->CHARACTERS:[C

    return-void

    :array_a
    .array-data 0x2
        0x30t 0x0t
        0x31t 0x0t
        0x32t 0x0t
        0x33t 0x0t
        0x34t 0x0t
        0x35t 0x0t
        0x36t 0x0t
        0x37t 0x0t
        0x38t 0x0t
        0x39t 0x0t
        0x61t 0x0t
        0x6dt 0x0t
        0x70t 0x0t
        0x3at 0x0t
    .end array-data
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 29
    invoke-direct {p0}, Landroid/text/method/NumberKeyListener;-><init>()V

    return-void
.end method

.method public static getInstance()Landroid/text/method/TimeKeyListener;
    .registers 1

    .prologue
    .line 43
    sget-object v0, Landroid/text/method/TimeKeyListener;->sInstance:Landroid/text/method/TimeKeyListener;

    if-eqz v0, :cond_7

    .line 44
    sget-object v0, Landroid/text/method/TimeKeyListener;->sInstance:Landroid/text/method/TimeKeyListener;

    .line 47
    :goto_6
    return-object v0

    .line 46
    :cond_7
    new-instance v0, Landroid/text/method/TimeKeyListener;

    invoke-direct {v0}, Landroid/text/method/TimeKeyListener;-><init>()V

    sput-object v0, Landroid/text/method/TimeKeyListener;->sInstance:Landroid/text/method/TimeKeyListener;

    .line 47
    sget-object v0, Landroid/text/method/TimeKeyListener;->sInstance:Landroid/text/method/TimeKeyListener;

    goto :goto_6
.end method


# virtual methods
.method protected getAcceptedChars()[C
    .registers 2

    .prologue
    .line 39
    sget-object v0, Landroid/text/method/TimeKeyListener;->CHARACTERS:[C

    return-object v0
.end method

.method public getInputType()I
    .registers 2

    .prologue
    .line 32
    const/16 v0, 0x24

    return v0
.end method
