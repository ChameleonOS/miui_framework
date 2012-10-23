.class public Landroid/app/PreferenceDialog;
.super Landroid/app/Dialog;
.source "PreferenceDialog.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;I)V
    .registers 3
    .parameter "context"
    .parameter "themeResId"

    .prologue
    .line 9
    invoke-direct {p0, p1, p2}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 10
    return-void
.end method


# virtual methods
.method public onMenuItemSelected(ILandroid/view/MenuItem;)Z
    .registers 4
    .parameter "featureId"
    .parameter "item"

    .prologue
    .line 14
    invoke-interface {p2}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    packed-switch v0, :pswitch_data_12

    .line 20
    invoke-super {p0, p1, p2}, Landroid/app/Dialog;->onMenuItemSelected(ILandroid/view/MenuItem;)Z

    move-result v0

    :goto_b
    return v0

    .line 16
    :pswitch_c
    invoke-virtual {p0}, Landroid/app/PreferenceDialog;->dismiss()V

    .line 17
    const/4 v0, 0x1

    goto :goto_b

    .line 14
    nop

    :pswitch_data_12
    .packed-switch 0x102002c
        :pswitch_c
    .end packed-switch
.end method
