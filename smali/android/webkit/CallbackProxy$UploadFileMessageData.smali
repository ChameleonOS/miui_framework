.class Landroid/webkit/CallbackProxy$UploadFileMessageData;
.super Ljava/lang/Object;
.source "CallbackProxy.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/CallbackProxy;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "UploadFileMessageData"
.end annotation


# instance fields
.field private mAcceptType:Ljava/lang/String;

.field private mCallback:Landroid/webkit/CallbackProxy$UploadFile;

.field private mCapture:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/webkit/CallbackProxy$UploadFile;Ljava/lang/String;Ljava/lang/String;)V
    .registers 4
    .parameter "uploadFile"
    .parameter "acceptType"
    .parameter "capture"

    .prologue
    .line 1548
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 1549
    iput-object p1, p0, Landroid/webkit/CallbackProxy$UploadFileMessageData;->mCallback:Landroid/webkit/CallbackProxy$UploadFile;

    .line 1550
    iput-object p2, p0, Landroid/webkit/CallbackProxy$UploadFileMessageData;->mAcceptType:Ljava/lang/String;

    .line 1551
    iput-object p3, p0, Landroid/webkit/CallbackProxy$UploadFileMessageData;->mCapture:Ljava/lang/String;

    .line 1552
    return-void
.end method


# virtual methods
.method public getAcceptType()Ljava/lang/String;
    .registers 2

    .prologue
    .line 1559
    iget-object v0, p0, Landroid/webkit/CallbackProxy$UploadFileMessageData;->mAcceptType:Ljava/lang/String;

    return-object v0
.end method

.method public getCapture()Ljava/lang/String;
    .registers 2

    .prologue
    .line 1563
    iget-object v0, p0, Landroid/webkit/CallbackProxy$UploadFileMessageData;->mCapture:Ljava/lang/String;

    return-object v0
.end method

.method public getUploadFile()Landroid/webkit/CallbackProxy$UploadFile;
    .registers 2

    .prologue
    .line 1555
    iget-object v0, p0, Landroid/webkit/CallbackProxy$UploadFileMessageData;->mCallback:Landroid/webkit/CallbackProxy$UploadFile;

    return-object v0
.end method
