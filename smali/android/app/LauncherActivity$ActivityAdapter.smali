.class Landroid/app/LauncherActivity$ActivityAdapter;
.super Landroid/widget/BaseAdapter;
.source "LauncherActivity.java"

# interfaces
.implements Landroid/widget/Filterable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/app/LauncherActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ActivityAdapter"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/app/LauncherActivity$ActivityAdapter$ArrayFilter;
    }
.end annotation


# instance fields
.field private final lock:Ljava/lang/Object;

.field protected mActivitiesList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/app/LauncherActivity$ListItem;",
            ">;"
        }
    .end annotation
.end field

.field private mFilter:Landroid/widget/Filter;

.field protected final mIconResizer:Landroid/app/LauncherActivity$IconResizer;

.field protected final mInflater:Landroid/view/LayoutInflater;

.field private mOriginalValues:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/app/LauncherActivity$ListItem;",
            ">;"
        }
    .end annotation
.end field

.field private final mShowIcons:Z

.field final synthetic this$0:Landroid/app/LauncherActivity;


# direct methods
.method public constructor <init>(Landroid/app/LauncherActivity;Landroid/app/LauncherActivity$IconResizer;)V
    .registers 4
    .parameter
    .parameter "resizer"

    .prologue
    .line 108
    iput-object p1, p0, Landroid/app/LauncherActivity$ActivityAdapter;->this$0:Landroid/app/LauncherActivity;

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 97
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/app/LauncherActivity$ActivityAdapter;->lock:Ljava/lang/Object;

    .line 109
    iput-object p2, p0, Landroid/app/LauncherActivity$ActivityAdapter;->mIconResizer:Landroid/app/LauncherActivity$IconResizer;

    .line 110
    const-string v0, "layout_inflater"

    invoke-virtual {p1, v0}, Landroid/app/LauncherActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    iput-object v0, p0, Landroid/app/LauncherActivity$ActivityAdapter;->mInflater:Landroid/view/LayoutInflater;

    .line 112
    invoke-virtual {p1}, Landroid/app/LauncherActivity;->onEvaluateShowIcons()Z

    move-result v0

    iput-boolean v0, p0, Landroid/app/LauncherActivity$ActivityAdapter;->mShowIcons:Z

    .line 113
    invoke-virtual {p1}, Landroid/app/LauncherActivity;->makeListItems()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Landroid/app/LauncherActivity$ActivityAdapter;->mActivitiesList:Ljava/util/List;

    .line 114
    return-void
.end method

.method static synthetic access$100(Landroid/app/LauncherActivity$ActivityAdapter;)Ljava/util/ArrayList;
    .registers 2
    .parameter "x0"

    .prologue
    .line 96
    iget-object v0, p0, Landroid/app/LauncherActivity$ActivityAdapter;->mOriginalValues:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$102(Landroid/app/LauncherActivity$ActivityAdapter;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 96
    iput-object p1, p0, Landroid/app/LauncherActivity$ActivityAdapter;->mOriginalValues:Ljava/util/ArrayList;

    return-object p1
.end method

.method static synthetic access$200(Landroid/app/LauncherActivity$ActivityAdapter;)Ljava/lang/Object;
    .registers 2
    .parameter "x0"

    .prologue
    .line 96
    iget-object v0, p0, Landroid/app/LauncherActivity$ActivityAdapter;->lock:Ljava/lang/Object;

    return-object v0
.end method

.method private bindView(Landroid/view/View;Landroid/app/LauncherActivity$ListItem;)V
    .registers 8
    .parameter "view"
    .parameter "item"

    .prologue
    const/4 v4, 0x0

    .line 163
    move-object v0, p1

    check-cast v0, Landroid/widget/TextView;

    .line 164
    .local v0, text:Landroid/widget/TextView;
    iget-object v1, p2, Landroid/app/LauncherActivity$ListItem;->label:Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 165
    iget-boolean v1, p0, Landroid/app/LauncherActivity$ActivityAdapter;->mShowIcons:Z

    if-eqz v1, :cond_2a

    .line 166
    iget-object v1, p2, Landroid/app/LauncherActivity$ListItem;->icon:Landroid/graphics/drawable/Drawable;

    if-nez v1, :cond_25

    .line 167
    iget-object v1, p0, Landroid/app/LauncherActivity$ActivityAdapter;->mIconResizer:Landroid/app/LauncherActivity$IconResizer;

    iget-object v2, p2, Landroid/app/LauncherActivity$ListItem;->resolveInfo:Landroid/content/pm/ResolveInfo;

    iget-object v3, p0, Landroid/app/LauncherActivity$ActivityAdapter;->this$0:Landroid/app/LauncherActivity;

    invoke-virtual {v3}, Landroid/app/LauncherActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/content/pm/ResolveInfo;->loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/app/LauncherActivity$IconResizer;->createIconThumbnail(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    iput-object v1, p2, Landroid/app/LauncherActivity$ListItem;->icon:Landroid/graphics/drawable/Drawable;

    .line 169
    :cond_25
    iget-object v1, p2, Landroid/app/LauncherActivity$ListItem;->icon:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, v1, v4, v4, v4}, Landroid/widget/TextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 171
    :cond_2a
    return-void
.end method


# virtual methods
.method public getCount()I
    .registers 2

    .prologue
    .line 139
    iget-object v0, p0, Landroid/app/LauncherActivity$ActivityAdapter;->mActivitiesList:Ljava/util/List;

    if-eqz v0, :cond_b

    iget-object v0, p0, Landroid/app/LauncherActivity$ActivityAdapter;->mActivitiesList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    :goto_a
    return v0

    :cond_b
    const/4 v0, 0x0

    goto :goto_a
.end method

.method public getFilter()Landroid/widget/Filter;
    .registers 3

    .prologue
    .line 174
    iget-object v0, p0, Landroid/app/LauncherActivity$ActivityAdapter;->mFilter:Landroid/widget/Filter;

    if-nez v0, :cond_c

    .line 175
    new-instance v0, Landroid/app/LauncherActivity$ActivityAdapter$ArrayFilter;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Landroid/app/LauncherActivity$ActivityAdapter$ArrayFilter;-><init>(Landroid/app/LauncherActivity$ActivityAdapter;Landroid/app/LauncherActivity$1;)V

    iput-object v0, p0, Landroid/app/LauncherActivity$ActivityAdapter;->mFilter:Landroid/widget/Filter;

    .line 177
    :cond_c
    iget-object v0, p0, Landroid/app/LauncherActivity$ActivityAdapter;->mFilter:Landroid/widget/Filter;

    return-object v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .registers 3
    .parameter "position"

    .prologue
    .line 143
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .registers 4
    .parameter "position"

    .prologue
    .line 147
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .registers 8
    .parameter "position"
    .parameter "convertView"
    .parameter "parent"

    .prologue
    .line 152
    if-nez p2, :cond_18

    .line 153
    iget-object v1, p0, Landroid/app/LauncherActivity$ActivityAdapter;->mInflater:Landroid/view/LayoutInflater;

    const v2, 0x1090021

    const/4 v3, 0x0

    invoke-virtual {v1, v2, p3, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 158
    .local v0, view:Landroid/view/View;
    :goto_c
    iget-object v1, p0, Landroid/app/LauncherActivity$ActivityAdapter;->mActivitiesList:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/LauncherActivity$ListItem;

    invoke-direct {p0, v0, v1}, Landroid/app/LauncherActivity$ActivityAdapter;->bindView(Landroid/view/View;Landroid/app/LauncherActivity$ListItem;)V

    .line 159
    return-object v0

    .line 156
    .end local v0           #view:Landroid/view/View;
    :cond_18
    move-object v0, p2

    .restart local v0       #view:Landroid/view/View;
    goto :goto_c
.end method

.method public intentForPosition(I)Landroid/content/Intent;
    .registers 6
    .parameter "position"

    .prologue
    .line 117
    iget-object v2, p0, Landroid/app/LauncherActivity$ActivityAdapter;->mActivitiesList:Ljava/util/List;

    if-nez v2, :cond_6

    .line 118
    const/4 v0, 0x0

    .line 127
    :cond_5
    :goto_5
    return-object v0

    .line 121
    :cond_6
    new-instance v0, Landroid/content/Intent;

    iget-object v2, p0, Landroid/app/LauncherActivity$ActivityAdapter;->this$0:Landroid/app/LauncherActivity;

    iget-object v2, v2, Landroid/app/LauncherActivity;->mIntent:Landroid/content/Intent;

    invoke-direct {v0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Intent;)V

    .line 122
    .local v0, intent:Landroid/content/Intent;
    iget-object v2, p0, Landroid/app/LauncherActivity$ActivityAdapter;->mActivitiesList:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/LauncherActivity$ListItem;

    .line 123
    .local v1, item:Landroid/app/LauncherActivity$ListItem;
    iget-object v2, v1, Landroid/app/LauncherActivity$ListItem;->packageName:Ljava/lang/String;

    iget-object v3, v1, Landroid/app/LauncherActivity$ListItem;->className:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->setClassName(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 124
    iget-object v2, v1, Landroid/app/LauncherActivity$ListItem;->extras:Landroid/os/Bundle;

    if-eqz v2, :cond_5

    .line 125
    iget-object v2, v1, Landroid/app/LauncherActivity$ListItem;->extras:Landroid/os/Bundle;

    invoke-virtual {v0, v2}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    goto :goto_5
.end method

.method public itemForPosition(I)Landroid/app/LauncherActivity$ListItem;
    .registers 3
    .parameter "position"

    .prologue
    .line 131
    iget-object v0, p0, Landroid/app/LauncherActivity$ActivityAdapter;->mActivitiesList:Ljava/util/List;

    if-nez v0, :cond_6

    .line 132
    const/4 v0, 0x0

    .line 135
    :goto_5
    return-object v0

    :cond_6
    iget-object v0, p0, Landroid/app/LauncherActivity$ActivityAdapter;->mActivitiesList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/LauncherActivity$ListItem;

    goto :goto_5
.end method
