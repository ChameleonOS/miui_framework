.class Landroid/os/StrictMode$ThreadSpanState;
.super Ljava/lang/Object;
.source "StrictMode.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/os/StrictMode;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ThreadSpanState"
.end annotation


# instance fields
.field public mActiveHead:Landroid/os/StrictMode$Span;

.field public mActiveSize:I

.field public mFreeListHead:Landroid/os/StrictMode$Span;

.field public mFreeListSize:I


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    .line 1782
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/os/StrictMode$1;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 1782
    invoke-direct {p0}, Landroid/os/StrictMode$ThreadSpanState;-><init>()V

    return-void
.end method
