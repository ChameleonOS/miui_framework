.class Landroid/preference/PreferenceActivity$HeaderAdapter$HeaderViewHolder;
.super Ljava/lang/Object;
.source "PreferenceActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/preference/PreferenceActivity$HeaderAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "HeaderViewHolder"
.end annotation


# instance fields
.field icon:Landroid/widget/ImageView;

.field summary:Landroid/widget/TextView;

.field title:Landroid/widget/TextView;


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    .line 242
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/preference/PreferenceActivity$1;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 242
    invoke-direct {p0}, Landroid/preference/PreferenceActivity$HeaderAdapter$HeaderViewHolder;-><init>()V

    return-void
.end method
