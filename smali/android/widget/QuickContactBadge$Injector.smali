.class Landroid/widget/QuickContactBadge$Injector;
.super Ljava/lang/Object;
.source "QuickContactBadge.java"


# annotations
.annotation build Landroid/annotation/MiuiHook;
    value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_CLASS:Landroid/annotation/MiuiHook$MiuiHookType;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/QuickContactBadge;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Injector"
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 50
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static showQuickContactForStranger(Landroid/widget/QuickContactBadge;ZLandroid/net/Uri;Landroid/net/Uri;)Landroid/net/Uri;
    .registers 7
    .parameter "badge"
    .parameter "trigger"
    .parameter "lookupUri"
    .parameter "createUri"

    .prologue
    .line 52
    if-eqz p1, :cond_5

    if-eqz p2, :cond_5

    .line 57
    .end local p3
    :goto_4
    return-object p3

    .line 55
    .restart local p3
    :cond_5
    invoke-virtual {p0}, Landroid/widget/QuickContactBadge;->getContext()Landroid/content/Context;

    move-result-object v0

    const/4 v1, 0x3

    iget-object v2, p0, Landroid/widget/QuickContactBadge;->mExcludeMimes:[Ljava/lang/String;

    invoke-static {v0, p0, p3, v1, v2}, Landroid/provider/ContactsContract$QuickContact;->showQuickContact(Landroid/content/Context;Landroid/view/View;Landroid/net/Uri;I[Ljava/lang/String;)V

    .line 57
    const/4 p3, 0x0

    goto :goto_4
.end method
