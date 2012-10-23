.class public abstract Landroid/view/accessibility/AccessibilityNodeProvider;
.super Ljava/lang/Object;
.source "AccessibilityNodeProvider.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 70
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public accessibilityFocusSearch(II)Landroid/view/accessibility/AccessibilityNodeInfo;
    .registers 4
    .parameter "direction"
    .parameter "virtualViewId"

    .prologue
    .line 189
    const/4 v0, 0x0

    return-object v0
.end method

.method public createAccessibilityNodeInfo(I)Landroid/view/accessibility/AccessibilityNodeInfo;
    .registers 3
    .parameter "virtualViewId"

    .prologue
    .line 96
    const/4 v0, 0x0

    return-object v0
.end method

.method public findAccessibilityFocus(I)Landroid/view/accessibility/AccessibilityNodeInfo;
    .registers 3
    .parameter "virtualViewId"

    .prologue
    .line 157
    const/4 v0, 0x0

    return-object v0
.end method

.method public findAccessibilityNodeInfosByText(Ljava/lang/String;I)Ljava/util/List;
    .registers 4
    .parameter "text"
    .parameter "virtualViewId"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I)",
            "Ljava/util/List",
            "<",
            "Landroid/view/accessibility/AccessibilityNodeInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 133
    const/4 v0, 0x0

    return-object v0
.end method

.method public performAction(IILandroid/os/Bundle;)Z
    .registers 5
    .parameter "virtualViewId"
    .parameter "action"
    .parameter "arguments"

    .prologue
    .line 114
    const/4 v0, 0x0

    return v0
.end method
