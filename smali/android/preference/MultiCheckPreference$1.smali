.class Landroid/preference/MultiCheckPreference$1;
.super Ljava/lang/Object;
.source "MultiCheckPreference.java"

# interfaces
.implements Landroid/content/DialogInterface$OnMultiChoiceClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/preference/MultiCheckPreference;->onPrepareDialogBuilder(Landroid/app/AlertDialog$Builder;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/preference/MultiCheckPreference;


# direct methods
.method constructor <init>(Landroid/preference/MultiCheckPreference;)V
    .registers 2
    .parameter

    .prologue
    .line 242
    iput-object p1, p0, Landroid/preference/MultiCheckPreference$1;->this$0:Landroid/preference/MultiCheckPreference;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;IZ)V
    .registers 5
    .parameter "dialog"
    .parameter "which"
    .parameter "isChecked"

    .prologue
    .line 245
    iget-object v0, p0, Landroid/preference/MultiCheckPreference$1;->this$0:Landroid/preference/MultiCheckPreference;

    #getter for: Landroid/preference/MultiCheckPreference;->mSetValues:[Z
    invoke-static {v0}, Landroid/preference/MultiCheckPreference;->access$000(Landroid/preference/MultiCheckPreference;)[Z

    move-result-object v0

    aput-boolean p3, v0, p2

    .line 246
    return-void
.end method
