.class Landroid/accounts/ChooseAccountTypeActivity$AccountArrayAdapter;
.super Landroid/widget/ArrayAdapter;
.source "ChooseAccountTypeActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/accounts/ChooseAccountTypeActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "AccountArrayAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Landroid/accounts/ChooseAccountTypeActivity$AuthInfo;",
        ">;"
    }
.end annotation


# instance fields
.field private mInfos:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/accounts/ChooseAccountTypeActivity$AuthInfo;",
            ">;"
        }
    .end annotation
.end field

.field private mLayoutInflater:Landroid/view/LayoutInflater;


# direct methods
.method public constructor <init>(Landroid/content/Context;ILjava/util/ArrayList;)V
    .registers 5
    .parameter "context"
    .parameter "textViewResourceId"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "I",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/accounts/ChooseAccountTypeActivity$AuthInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 177
    .local p3, infos:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/accounts/ChooseAccountTypeActivity$AuthInfo;>;"
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 178
    iput-object p3, p0, Landroid/accounts/ChooseAccountTypeActivity$AccountArrayAdapter;->mInfos:Ljava/util/ArrayList;

    .line 179
    const-string v0, "layout_inflater"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    iput-object v0, p0, Landroid/accounts/ChooseAccountTypeActivity$AccountArrayAdapter;->mLayoutInflater:Landroid/view/LayoutInflater;

    .line 181
    return-void
.end method


# virtual methods
.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .registers 8
    .parameter "position"
    .parameter "convertView"
    .parameter "parent"

    .prologue
    const/4 v3, 0x0

    .line 187
    if-nez p2, :cond_49

    .line 188
    iget-object v1, p0, Landroid/accounts/ChooseAccountTypeActivity$AccountArrayAdapter;->mLayoutInflater:Landroid/view/LayoutInflater;

    const v2, 0x1090032

    invoke-virtual {v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 189
    new-instance v0, Landroid/accounts/ChooseAccountTypeActivity$ViewHolder;

    invoke-direct {v0, v3}, Landroid/accounts/ChooseAccountTypeActivity$ViewHolder;-><init>(Landroid/accounts/ChooseAccountTypeActivity$1;)V

    .line 190
    .local v0, holder:Landroid/accounts/ChooseAccountTypeActivity$ViewHolder;
    const v1, 0x102026b

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, v0, Landroid/accounts/ChooseAccountTypeActivity$ViewHolder;->text:Landroid/widget/TextView;

    .line 191
    const v1, 0x102026a

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, v0, Landroid/accounts/ChooseAccountTypeActivity$ViewHolder;->icon:Landroid/widget/ImageView;

    .line 192
    invoke-virtual {p2, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 197
    :goto_2a
    iget-object v2, v0, Landroid/accounts/ChooseAccountTypeActivity$ViewHolder;->text:Landroid/widget/TextView;

    iget-object v1, p0, Landroid/accounts/ChooseAccountTypeActivity$AccountArrayAdapter;->mInfos:Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/accounts/ChooseAccountTypeActivity$AuthInfo;

    iget-object v1, v1, Landroid/accounts/ChooseAccountTypeActivity$AuthInfo;->name:Ljava/lang/String;

    invoke-virtual {v2, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 198
    iget-object v2, v0, Landroid/accounts/ChooseAccountTypeActivity$ViewHolder;->icon:Landroid/widget/ImageView;

    iget-object v1, p0, Landroid/accounts/ChooseAccountTypeActivity$AccountArrayAdapter;->mInfos:Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/accounts/ChooseAccountTypeActivity$AuthInfo;

    iget-object v1, v1, Landroid/accounts/ChooseAccountTypeActivity$AuthInfo;->drawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v2, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 200
    return-object p2

    .line 194
    .end local v0           #holder:Landroid/accounts/ChooseAccountTypeActivity$ViewHolder;
    :cond_49
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/accounts/ChooseAccountTypeActivity$ViewHolder;

    .restart local v0       #holder:Landroid/accounts/ChooseAccountTypeActivity$ViewHolder;
    goto :goto_2a
.end method
