.class public abstract Landroid/app/LauncherActivity;
.super Landroid/app/ListActivity;
.source "LauncherActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/app/LauncherActivity$IconResizer;,
        Landroid/app/LauncherActivity$ActivityAdapter;,
        Landroid/app/LauncherActivity$ListItem;
    }
.end annotation


# instance fields
.field mIconResizer:Landroid/app/LauncherActivity$IconResizer;

.field mIntent:Landroid/content/Intent;

.field mPackageManager:Landroid/content/pm/PackageManager;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct {p0}, Landroid/app/ListActivity;-><init>()V

    return-void
.end method

.method private updateAlertTitle()V
    .registers 3

    .prologue
    const v1, 0x102024d

    invoke-virtual {p0, v1}, Landroid/app/LauncherActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .local v0, alertTitle:Landroid/widget/TextView;
    if-eqz v0, :cond_12

    invoke-virtual {p0}, Landroid/app/LauncherActivity;->getTitle()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :cond_12
    return-void
.end method

.method private updateButtonText()V
    .registers 3

    .prologue
    const v1, 0x1020019

    invoke-virtual {p0, v1}, Landroid/app/LauncherActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .local v0, cancelButton:Landroid/widget/Button;
    if-eqz v0, :cond_13

    new-instance v1, Landroid/app/LauncherActivity$1;

    invoke-direct {v1, p0}, Landroid/app/LauncherActivity$1;-><init>(Landroid/app/LauncherActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    :cond_13
    return-void
.end method


# virtual methods
.method protected getTargetIntent()Landroid/content/Intent;
    .registers 2

    .prologue
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    return-object v0
.end method

.method protected intentForPosition(I)Landroid/content/Intent;
    .registers 4
    .parameter "position"

    .prologue
    iget-object v0, p0, Landroid/app/ListActivity;->mAdapter:Landroid/widget/ListAdapter;

    check-cast v0, Landroid/app/LauncherActivity$ActivityAdapter;

    .local v0, adapter:Landroid/app/LauncherActivity$ActivityAdapter;
    invoke-virtual {v0, p1}, Landroid/app/LauncherActivity$ActivityAdapter;->intentForPosition(I)Landroid/content/Intent;

    move-result-object v1

    return-object v1
.end method

.method protected itemForPosition(I)Landroid/app/LauncherActivity$ListItem;
    .registers 4
    .parameter "position"

    .prologue
    iget-object v0, p0, Landroid/app/ListActivity;->mAdapter:Landroid/widget/ListAdapter;

    check-cast v0, Landroid/app/LauncherActivity$ActivityAdapter;

    .local v0, adapter:Landroid/app/LauncherActivity$ActivityAdapter;
    invoke-virtual {v0, p1}, Landroid/app/LauncherActivity$ActivityAdapter;->itemForPosition(I)Landroid/app/LauncherActivity$ListItem;

    move-result-object v1

    return-object v1
.end method

.method public makeListItems()Ljava/util/List;
    .registers 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Landroid/app/LauncherActivity$ListItem;",
            ">;"
        }
    .end annotation

    .prologue
    iget-object v5, p0, Landroid/app/LauncherActivity;->mIntent:Landroid/content/Intent;

    invoke-virtual {p0, v5}, Landroid/app/LauncherActivity;->onQueryPackageManager(Landroid/content/Intent;)Ljava/util/List;

    move-result-object v1

    .local v1, list:Ljava/util/List;,"Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    new-instance v5, Landroid/content/pm/ResolveInfo$DisplayNameComparator;

    iget-object v6, p0, Landroid/app/LauncherActivity;->mPackageManager:Landroid/content/pm/PackageManager;

    invoke-direct {v5, v6}, Landroid/content/pm/ResolveInfo$DisplayNameComparator;-><init>(Landroid/content/pm/PackageManager;)V

    invoke-static {v1, v5}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    new-instance v4, Ljava/util/ArrayList;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v5

    invoke-direct {v4, v5}, Ljava/util/ArrayList;-><init>(I)V

    .local v4, result:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/app/LauncherActivity$ListItem;>;"
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    .local v2, listSize:I
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1e
    if-ge v0, v2, :cond_34

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/content/pm/ResolveInfo;

    .local v3, resolveInfo:Landroid/content/pm/ResolveInfo;
    new-instance v5, Landroid/app/LauncherActivity$ListItem;

    iget-object v6, p0, Landroid/app/LauncherActivity;->mPackageManager:Landroid/content/pm/PackageManager;

    const/4 v7, 0x0

    invoke-direct {v5, v6, v3, v7}, Landroid/app/LauncherActivity$ListItem;-><init>(Landroid/content/pm/PackageManager;Landroid/content/pm/ResolveInfo;Landroid/app/LauncherActivity$IconResizer;)V

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 v0, v0, 0x1

    goto :goto_1e

    .end local v3           #resolveInfo:Landroid/content/pm/ResolveInfo;
    :cond_34
    return-object v4
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .registers 5
    .parameter "icicle"

    .prologue
    const/4 v2, 0x1

    invoke-super {p0, p1}, Landroid/app/ListActivity;->onCreate(Landroid/os/Bundle;)V

    invoke-virtual {p0}, Landroid/app/LauncherActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    iput-object v0, p0, Landroid/app/LauncherActivity;->mPackageManager:Landroid/content/pm/PackageManager;

    const/4 v0, 0x5

    invoke-virtual {p0, v0}, Landroid/app/LauncherActivity;->requestWindowFeature(I)Z

    invoke-virtual {p0, v2}, Landroid/app/LauncherActivity;->setProgressBarIndeterminateVisibility(Z)V

    invoke-virtual {p0}, Landroid/app/LauncherActivity;->onSetContentView()V

    new-instance v0, Landroid/app/LauncherActivity$IconResizer;

    invoke-direct {v0, p0}, Landroid/app/LauncherActivity$IconResizer;-><init>(Landroid/app/LauncherActivity;)V

    iput-object v0, p0, Landroid/app/LauncherActivity;->mIconResizer:Landroid/app/LauncherActivity$IconResizer;

    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Landroid/app/LauncherActivity;->getTargetIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Intent;)V

    iput-object v0, p0, Landroid/app/LauncherActivity;->mIntent:Landroid/content/Intent;

    iget-object v0, p0, Landroid/app/LauncherActivity;->mIntent:Landroid/content/Intent;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    new-instance v0, Landroid/app/LauncherActivity$ActivityAdapter;

    iget-object v1, p0, Landroid/app/LauncherActivity;->mIconResizer:Landroid/app/LauncherActivity$IconResizer;

    invoke-direct {v0, p0, v1}, Landroid/app/LauncherActivity$ActivityAdapter;-><init>(Landroid/app/LauncherActivity;Landroid/app/LauncherActivity$IconResizer;)V

    iput-object v0, p0, Landroid/app/ListActivity;->mAdapter:Landroid/widget/ListAdapter;

    iget-object v0, p0, Landroid/app/ListActivity;->mAdapter:Landroid/widget/ListAdapter;

    invoke-virtual {p0, v0}, Landroid/app/LauncherActivity;->setListAdapter(Landroid/widget/ListAdapter;)V

    invoke-virtual {p0}, Landroid/app/LauncherActivity;->getListView()Landroid/widget/ListView;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/ListView;->setTextFilterEnabled(Z)V

    invoke-direct {p0}, Landroid/app/LauncherActivity;->updateAlertTitle()V

    invoke-direct {p0}, Landroid/app/LauncherActivity;->updateButtonText()V

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Landroid/app/LauncherActivity;->setProgressBarIndeterminateVisibility(Z)V

    return-void
.end method

.method protected onEvaluateShowIcons()Z
    .registers 2

    .prologue
    const/4 v0, 0x1

    return v0
.end method

.method protected onListItemClick(Landroid/widget/ListView;Landroid/view/View;IJ)V
    .registers 7
    .parameter "l"
    .parameter "v"
    .parameter "position"
    .parameter "id"

    .prologue
    invoke-virtual {p0, p3}, Landroid/app/LauncherActivity;->intentForPosition(I)Landroid/content/Intent;

    move-result-object v0

    .local v0, intent:Landroid/content/Intent;
    invoke-virtual {p0, v0}, Landroid/app/LauncherActivity;->startActivity(Landroid/content/Intent;)V

    return-void
.end method

.method protected onQueryPackageManager(Landroid/content/Intent;)Ljava/util/List;
    .registers 4
    .parameter "queryIntent"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Intent;",
            ")",
            "Ljava/util/List",
            "<",
            "Landroid/content/pm/ResolveInfo;",
            ">;"
        }
    .end annotation

    .prologue
    iget-object v0, p0, Landroid/app/LauncherActivity;->mPackageManager:Landroid/content/pm/PackageManager;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method protected onSetContentView()V
    .registers 2

    .prologue
    const v0, 0x1090020

    invoke-virtual {p0, v0}, Landroid/app/LauncherActivity;->setContentView(I)V

    return-void
.end method

.method public setTitle(I)V
    .registers 2
    .parameter "titleId"

    .prologue
    invoke-super {p0, p1}, Landroid/app/ListActivity;->setTitle(I)V

    invoke-direct {p0}, Landroid/app/LauncherActivity;->updateAlertTitle()V

    return-void
.end method

.method public setTitle(Ljava/lang/CharSequence;)V
    .registers 2
    .parameter "title"

    .prologue
    invoke-super {p0, p1}, Landroid/app/ListActivity;->setTitle(Ljava/lang/CharSequence;)V

    invoke-direct {p0}, Landroid/app/LauncherActivity;->updateAlertTitle()V

    return-void
.end method
