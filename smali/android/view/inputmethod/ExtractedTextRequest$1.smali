.class final Landroid/view/inputmethod/ExtractedTextRequest$1;
.super Ljava/lang/Object;
.source "ExtractedTextRequest.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/view/inputmethod/ExtractedTextRequest;
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
        "Landroid/view/inputmethod/ExtractedTextRequest;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 68
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/view/inputmethod/ExtractedTextRequest;
    .registers 4
    .parameter "source"

    .prologue
    .line 70
    new-instance v0, Landroid/view/inputmethod/ExtractedTextRequest;

    invoke-direct {v0}, Landroid/view/inputmethod/ExtractedTextRequest;-><init>()V

    .line 71
    .local v0, res:Landroid/view/inputmethod/ExtractedTextRequest;
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    iput v1, v0, Landroid/view/inputmethod/ExtractedTextRequest;->token:I

    .line 72
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    iput v1, v0, Landroid/view/inputmethod/ExtractedTextRequest;->flags:I

    .line 73
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    iput v1, v0, Landroid/view/inputmethod/ExtractedTextRequest;->hintMaxLines:I

    .line 74
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    iput v1, v0, Landroid/view/inputmethod/ExtractedTextRequest;->hintMaxChars:I

    .line 75
    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 68
    invoke-virtual {p0, p1}, Landroid/view/inputmethod/ExtractedTextRequest$1;->createFromParcel(Landroid/os/Parcel;)Landroid/view/inputmethod/ExtractedTextRequest;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/view/inputmethod/ExtractedTextRequest;
    .registers 3
    .parameter "size"

    .prologue
    .line 79
    new-array v0, p1, [Landroid/view/inputmethod/ExtractedTextRequest;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 68
    invoke-virtual {p0, p1}, Landroid/view/inputmethod/ExtractedTextRequest$1;->newArray(I)[Landroid/view/inputmethod/ExtractedTextRequest;

    move-result-object v0

    return-object v0
.end method
