.class final Landroid/view/accessibility/AccessibilityEvent$1;
.super Ljava/lang/Object;
.source "AccessibilityEvent.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/view/accessibility/AccessibilityEvent;
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
        "Landroid/view/accessibility/AccessibilityEvent;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 1132
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/view/accessibility/AccessibilityEvent;
    .registers 3
    .parameter "parcel"

    .prologue
    .line 1134
    invoke-static {}, Landroid/view/accessibility/AccessibilityEvent;->obtain()Landroid/view/accessibility/AccessibilityEvent;

    move-result-object v0

    .line 1135
    .local v0, event:Landroid/view/accessibility/AccessibilityEvent;
    invoke-virtual {v0, p1}, Landroid/view/accessibility/AccessibilityEvent;->initFromParcel(Landroid/os/Parcel;)V

    .line 1136
    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 1132
    invoke-virtual {p0, p1}, Landroid/view/accessibility/AccessibilityEvent$1;->createFromParcel(Landroid/os/Parcel;)Landroid/view/accessibility/AccessibilityEvent;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/view/accessibility/AccessibilityEvent;
    .registers 3
    .parameter "size"

    .prologue
    .line 1140
    new-array v0, p1, [Landroid/view/accessibility/AccessibilityEvent;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 1132
    invoke-virtual {p0, p1}, Landroid/view/accessibility/AccessibilityEvent$1;->newArray(I)[Landroid/view/accessibility/AccessibilityEvent;

    move-result-object v0

    return-object v0
.end method
