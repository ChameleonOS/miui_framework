.class final Landroid/text/style/SuggestionSpan$1;
.super Ljava/lang/Object;
.source "SuggestionSpan.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/text/style/SuggestionSpan;
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
        "Landroid/text/style/SuggestionSpan;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 277
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/text/style/SuggestionSpan;
    .registers 3
    .parameter "source"

    .prologue
    .line 280
    new-instance v0, Landroid/text/style/SuggestionSpan;

    invoke-direct {v0, p1}, Landroid/text/style/SuggestionSpan;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 277
    invoke-virtual {p0, p1}, Landroid/text/style/SuggestionSpan$1;->createFromParcel(Landroid/os/Parcel;)Landroid/text/style/SuggestionSpan;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/text/style/SuggestionSpan;
    .registers 3
    .parameter "size"

    .prologue
    .line 285
    new-array v0, p1, [Landroid/text/style/SuggestionSpan;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 277
    invoke-virtual {p0, p1}, Landroid/text/style/SuggestionSpan$1;->newArray(I)[Landroid/text/style/SuggestionSpan;

    move-result-object v0

    return-object v0
.end method
