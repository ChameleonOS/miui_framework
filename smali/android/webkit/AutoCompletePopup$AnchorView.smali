.class Landroid/webkit/AutoCompletePopup$AnchorView;
.super Landroid/view/View;
.source "AutoCompletePopup.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/AutoCompletePopup;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "AnchorView"
.end annotation


# direct methods
.method constructor <init>(Landroid/content/Context;)V
    .registers 3
    .parameter "context"

    .prologue
    .line 37
    invoke-direct {p0, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 38
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Landroid/webkit/AutoCompletePopup$AnchorView;->setFocusable(Z)V

    .line 39
    const/4 v0, 0x4

    invoke-virtual {p0, v0}, Landroid/webkit/AutoCompletePopup$AnchorView;->setVisibility(I)V

    .line 40
    return-void
.end method
