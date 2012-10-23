.class public final Landroid/view/InputChannel;
.super Ljava/lang/Object;
.source "InputChannel.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/view/InputChannel;",
            ">;"
        }
    .end annotation
.end field

.field private static final DEBUG:Z = false

.field private static final TAG:Ljava/lang/String; = "InputChannel"


# instance fields
.field private mPtr:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 35
    new-instance v0, Landroid/view/InputChannel$1;

    invoke-direct {v0}, Landroid/view/InputChannel$1;-><init>()V

    sput-object v0, Landroid/view/InputChannel;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 65
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 66
    return-void
.end method

.method private native nativeDispose(Z)V
.end method

.method private native nativeGetName()Ljava/lang/String;
.end method

.method private static native nativeOpenInputChannelPair(Ljava/lang/String;)[Landroid/view/InputChannel;
.end method

.method private native nativeReadFromParcel(Landroid/os/Parcel;)V
.end method

.method private native nativeTransferTo(Landroid/view/InputChannel;)V
.end method

.method private native nativeWriteToParcel(Landroid/os/Parcel;)V
.end method

.method public static openInputChannelPair(Ljava/lang/String;)[Landroid/view/InputChannel;
    .registers 3
    .parameter "name"

    .prologue
    .line 84
    if-nez p0, :cond_b

    .line 85
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "name must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 91
    :cond_b
    invoke-static {p0}, Landroid/view/InputChannel;->nativeOpenInputChannelPair(Ljava/lang/String;)[Landroid/view/InputChannel;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    .line 127
    const/4 v0, 0x1

    return v0
.end method

.method public dispose()V
    .registers 2

    .prologue
    .line 109
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroid/view/InputChannel;->nativeDispose(Z)V

    .line 110
    return-void
.end method

.method protected finalize()V
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 71
    const/4 v0, 0x1

    :try_start_1
    invoke-direct {p0, v0}, Landroid/view/InputChannel;->nativeDispose(Z)V
    :try_end_4
    .catchall {:try_start_1 .. :try_end_4} :catchall_8

    .line 73
    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    .line 75
    return-void

    .line 73
    :catchall_8
    move-exception v0

    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    throw v0
.end method

.method public getName()Ljava/lang/String;
    .registers 2

    .prologue
    .line 99
    invoke-direct {p0}, Landroid/view/InputChannel;->nativeGetName()Ljava/lang/String;

    move-result-object v0

    .line 100
    .local v0, name:Ljava/lang/String;
    if-eqz v0, :cond_7

    .end local v0           #name:Ljava/lang/String;
    :goto_6
    return-object v0

    .restart local v0       #name:Ljava/lang/String;
    :cond_7
    const-string/jumbo v0, "uninitialized"

    goto :goto_6
.end method

.method public readFromParcel(Landroid/os/Parcel;)V
    .registers 4
    .parameter "in"

    .prologue
    .line 131
    if-nez p1, :cond_a

    .line 132
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "in must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 135
    :cond_a
    invoke-direct {p0, p1}, Landroid/view/InputChannel;->nativeReadFromParcel(Landroid/os/Parcel;)V

    .line 136
    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 2

    .prologue
    .line 152
    invoke-virtual {p0}, Landroid/view/InputChannel;->getName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public transferTo(Landroid/view/InputChannel;)V
    .registers 4
    .parameter "outParameter"

    .prologue
    .line 119
    if-nez p1, :cond_b

    .line 120
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "outParameter must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 123
    :cond_b
    invoke-direct {p0, p1}, Landroid/view/InputChannel;->nativeTransferTo(Landroid/view/InputChannel;)V

    .line 124
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 5
    .parameter "out"
    .parameter "flags"

    .prologue
    .line 139
    if-nez p1, :cond_b

    .line 140
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "out must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 143
    :cond_b
    invoke-direct {p0, p1}, Landroid/view/InputChannel;->nativeWriteToParcel(Landroid/os/Parcel;)V

    .line 145
    and-int/lit8 v0, p2, 0x1

    if-eqz v0, :cond_15

    .line 146
    invoke-virtual {p0}, Landroid/view/InputChannel;->dispose()V

    .line 148
    :cond_15
    return-void
.end method
