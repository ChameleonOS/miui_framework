.class public Landroid/webkit/JsPromptResult;
.super Landroid/webkit/JsResult;
.source "JsPromptResult.java"


# instance fields
.field private mStringResult:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/webkit/JsResult$ResultReceiver;)V
    .registers 2
    .parameter "receiver"

    .prologue
    .line 43
    invoke-direct {p0, p1}, Landroid/webkit/JsResult;-><init>(Landroid/webkit/JsResult$ResultReceiver;)V

    .line 44
    return-void
.end method


# virtual methods
.method public confirm(Ljava/lang/String;)V
    .registers 2
    .parameter "result"

    .prologue
    .line 35
    iput-object p1, p0, Landroid/webkit/JsPromptResult;->mStringResult:Ljava/lang/String;

    .line 36
    invoke-virtual {p0}, Landroid/webkit/JsPromptResult;->confirm()V

    .line 37
    return-void
.end method

.method public getStringResult()Ljava/lang/String;
    .registers 2

    .prologue
    .line 50
    iget-object v0, p0, Landroid/webkit/JsPromptResult;->mStringResult:Ljava/lang/String;

    return-object v0
.end method
