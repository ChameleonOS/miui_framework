.class final Landroid/appwidget/AppWidgetProviderInfo$1;
.super Ljava/lang/Object;
.source "AppWidgetProviderInfo.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/appwidget/AppWidgetProviderInfo;
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
        "Landroid/appwidget/AppWidgetProviderInfo;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 228
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/appwidget/AppWidgetProviderInfo;
    .registers 3
    .parameter "parcel"

    .prologue
    .line 231
    new-instance v0, Landroid/appwidget/AppWidgetProviderInfo;

    invoke-direct {v0, p1}, Landroid/appwidget/AppWidgetProviderInfo;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 228
    invoke-virtual {p0, p1}, Landroid/appwidget/AppWidgetProviderInfo$1;->createFromParcel(Landroid/os/Parcel;)Landroid/appwidget/AppWidgetProviderInfo;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/appwidget/AppWidgetProviderInfo;
    .registers 3
    .parameter "size"

    .prologue
    .line 236
    new-array v0, p1, [Landroid/appwidget/AppWidgetProviderInfo;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 228
    invoke-virtual {p0, p1}, Landroid/appwidget/AppWidgetProviderInfo$1;->newArray(I)[Landroid/appwidget/AppWidgetProviderInfo;

    move-result-object v0

    return-object v0
.end method
