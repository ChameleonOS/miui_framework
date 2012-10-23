.class Landroid/widget/ShareActionProvider$ShareAcitivityChooserModelPolicy;
.super Ljava/lang/Object;
.source "ShareActionProvider.java"

# interfaces
.implements Landroid/widget/ActivityChooserModel$OnChooseActivityListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/ShareActionProvider;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ShareAcitivityChooserModelPolicy"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/widget/ShareActionProvider;


# direct methods
.method private constructor <init>(Landroid/widget/ShareActionProvider;)V
    .registers 2
    .parameter

    .prologue
    .line 330
    iput-object p1, p0, Landroid/widget/ShareActionProvider$ShareAcitivityChooserModelPolicy;->this$0:Landroid/widget/ShareActionProvider;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/widget/ShareActionProvider;Landroid/widget/ShareActionProvider$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 330
    invoke-direct {p0, p1}, Landroid/widget/ShareActionProvider$ShareAcitivityChooserModelPolicy;-><init>(Landroid/widget/ShareActionProvider;)V

    return-void
.end method


# virtual methods
.method public onChooseActivity(Landroid/widget/ActivityChooserModel;Landroid/content/Intent;)Z
    .registers 5
    .parameter "host"
    .parameter "intent"

    .prologue
    .line 333
    iget-object v0, p0, Landroid/widget/ShareActionProvider$ShareAcitivityChooserModelPolicy;->this$0:Landroid/widget/ShareActionProvider;

    #getter for: Landroid/widget/ShareActionProvider;->mOnShareTargetSelectedListener:Landroid/widget/ShareActionProvider$OnShareTargetSelectedListener;
    invoke-static {v0}, Landroid/widget/ShareActionProvider;->access$400(Landroid/widget/ShareActionProvider;)Landroid/widget/ShareActionProvider$OnShareTargetSelectedListener;

    move-result-object v0

    if-eqz v0, :cond_13

    .line 334
    iget-object v0, p0, Landroid/widget/ShareActionProvider$ShareAcitivityChooserModelPolicy;->this$0:Landroid/widget/ShareActionProvider;

    #getter for: Landroid/widget/ShareActionProvider;->mOnShareTargetSelectedListener:Landroid/widget/ShareActionProvider$OnShareTargetSelectedListener;
    invoke-static {v0}, Landroid/widget/ShareActionProvider;->access$400(Landroid/widget/ShareActionProvider;)Landroid/widget/ShareActionProvider$OnShareTargetSelectedListener;

    move-result-object v0

    iget-object v1, p0, Landroid/widget/ShareActionProvider$ShareAcitivityChooserModelPolicy;->this$0:Landroid/widget/ShareActionProvider;

    invoke-interface {v0, v1, p2}, Landroid/widget/ShareActionProvider$OnShareTargetSelectedListener;->onShareTargetSelected(Landroid/widget/ShareActionProvider;Landroid/content/Intent;)Z

    .line 337
    :cond_13
    const/4 v0, 0x0

    return v0
.end method
