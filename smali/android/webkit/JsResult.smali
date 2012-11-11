.class public Landroid/webkit/JsResult;
.super Ljava/lang/Object;
.source "JsResult.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/webkit/JsResult$ResultReceiver;
    }
.end annotation


# instance fields
.field private final mReceiver:Landroid/webkit/JsResult$ResultReceiver;

.field private mResult:Z


# direct methods
.method public constructor <init>(Landroid/webkit/JsResult$ResultReceiver;)V
    .registers 2
    .parameter "receiver"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroid/webkit/JsResult;->mReceiver:Landroid/webkit/JsResult$ResultReceiver;

    return-void
.end method

.method private final wakeUp()V
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/webkit/JsResult;->mReceiver:Landroid/webkit/JsResult$ResultReceiver;

    invoke-interface {v0, p0}, Landroid/webkit/JsResult$ResultReceiver;->onJsResultComplete(Landroid/webkit/JsResult;)V

    return-void
.end method


# virtual methods
.method public final cancel()V
    .registers 2

    .prologue
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/webkit/JsResult;->mResult:Z

    invoke-direct {p0}, Landroid/webkit/JsResult;->wakeUp()V

    return-void
.end method

.method public final confirm()V
    .registers 2

    .prologue
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/webkit/JsResult;->mResult:Z

    invoke-direct {p0}, Landroid/webkit/JsResult;->wakeUp()V

    return-void
.end method

.method public final getResult()Z
    .registers 2

    .prologue
    iget-boolean v0, p0, Landroid/webkit/JsResult;->mResult:Z

    return v0
.end method
