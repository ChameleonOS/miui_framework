.class Landroid/appwidget/AppWidgetHostView$ParcelableSparseArray;
.super Landroid/util/SparseArray;
.source "AppWidgetHostView.java"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/appwidget/AppWidgetHostView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ParcelableSparseArray"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/util/SparseArray",
        "<",
        "Landroid/os/Parcelable;",
        ">;",
        "Landroid/os/Parcelable;"
    }
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/appwidget/AppWidgetHostView$ParcelableSparseArray;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 547
    new-instance v0, Landroid/appwidget/AppWidgetHostView$ParcelableSparseArray$1;

    invoke-direct {v0}, Landroid/appwidget/AppWidgetHostView$ParcelableSparseArray$1;-><init>()V

    sput-object v0, Landroid/appwidget/AppWidgetHostView$ParcelableSparseArray;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .prologue
    .line 533
    invoke-direct {p0}, Landroid/util/SparseArray;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/appwidget/AppWidgetHostView$1;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 533
    invoke-direct {p0}, Landroid/appwidget/AppWidgetHostView$ParcelableSparseArray;-><init>()V

    return-void
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    .line 535
    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 7
    .parameter "dest"
    .parameter "flags"

    .prologue
    .line 539
    invoke-virtual {p0}, Landroid/appwidget/AppWidgetHostView$ParcelableSparseArray;->size()I

    move-result v0

    .line 540
    .local v0, count:I
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 541
    const/4 v1, 0x0

    .local v1, i:I
    :goto_8
    if-ge v1, v0, :cond_1e

    .line 542
    invoke-virtual {p0, v1}, Landroid/appwidget/AppWidgetHostView$ParcelableSparseArray;->keyAt(I)I

    move-result v2

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 543
    invoke-virtual {p0, v1}, Landroid/appwidget/AppWidgetHostView$ParcelableSparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/os/Parcelable;

    const/4 v3, 0x0

    invoke-virtual {p1, v2, v3}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 541
    add-int/lit8 v1, v1, 0x1

    goto :goto_8

    .line 545
    :cond_1e
    return-void
.end method
