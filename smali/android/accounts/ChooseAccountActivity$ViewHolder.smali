.class Landroid/accounts/ChooseAccountActivity$ViewHolder;
.super Ljava/lang/Object;
.source "ChooseAccountActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/accounts/ChooseAccountActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ViewHolder"
.end annotation


# instance fields
.field icon:Landroid/widget/ImageView;

.field text:Landroid/widget/TextView;


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    .line 150
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/accounts/ChooseAccountActivity$1;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 150
    invoke-direct {p0}, Landroid/accounts/ChooseAccountActivity$ViewHolder;-><init>()V

    return-void
.end method
