.class final Landroid/view/inputmethod/CompletionInfo$1;
.super Ljava/lang/Object;
.source "CompletionInfo.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/view/inputmethod/CompletionInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable$Creator",
        "<",
        "Landroid/view/inputmethod/CompletionInfo;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 116
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/view/inputmethod/CompletionInfo;
    .registers 4
    .parameter "source"

    .prologue
    .line 118
    new-instance v0, Landroid/view/inputmethod/CompletionInfo;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Landroid/view/inputmethod/CompletionInfo;-><init>(Landroid/os/Parcel;Landroid/view/inputmethod/CompletionInfo$1;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 116
    invoke-virtual {p0, p1}, Landroid/view/inputmethod/CompletionInfo$1;->createFromParcel(Landroid/os/Parcel;)Landroid/view/inputmethod/CompletionInfo;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/view/inputmethod/CompletionInfo;
    .registers 3
    .parameter "size"

    .prologue
    .line 122
    new-array v0, p1, [Landroid/view/inputmethod/CompletionInfo;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 116
    invoke-virtual {p0, p1}, Landroid/view/inputmethod/CompletionInfo$1;->newArray(I)[Landroid/view/inputmethod/CompletionInfo;

    move-result-object v0

    return-object v0
.end method
