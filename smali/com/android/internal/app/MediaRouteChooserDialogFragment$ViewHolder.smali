.class Lcom/android/internal/app/MediaRouteChooserDialogFragment$ViewHolder;
.super Ljava/lang/Object;
.source "MediaRouteChooserDialogFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/app/MediaRouteChooserDialogFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ViewHolder"
.end annotation


# instance fields
.field public check:Landroid/widget/CheckBox;

.field public expandGroupButton:Landroid/widget/ImageButton;

.field public expandGroupListener:Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteAdapter$ExpandGroupListener;

.field public icon:Landroid/widget/ImageView;

.field public position:I

.field public text1:Landroid/widget/TextView;

.field public text2:Landroid/widget/TextView;


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    .line 199
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/android/internal/app/MediaRouteChooserDialogFragment$1;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 199
    invoke-direct {p0}, Lcom/android/internal/app/MediaRouteChooserDialogFragment$ViewHolder;-><init>()V

    return-void
.end method
