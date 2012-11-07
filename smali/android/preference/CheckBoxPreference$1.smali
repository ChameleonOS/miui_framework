.class Landroid/preference/CheckBoxPreference$1;
.super Ljava/lang/Object;
.source "CheckBoxPreference.java"

# interfaces
.implements Lmiui/widget/SlidingButton$OnCheckedChangedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/preference/CheckBoxPreference;->setSlidingButtonListener(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/preference/CheckBoxPreference;

.field final synthetic val$slidingButton:Lmiui/widget/SlidingButton;


# direct methods
.method constructor <init>(Landroid/preference/CheckBoxPreference;Lmiui/widget/SlidingButton;)V
    .registers 3
    .parameter
    .parameter

    .prologue
    .line 80
    iput-object p1, p0, Landroid/preference/CheckBoxPreference$1;->this$0:Landroid/preference/CheckBoxPreference;

    iput-object p2, p0, Landroid/preference/CheckBoxPreference$1;->val$slidingButton:Lmiui/widget/SlidingButton;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Z)V
    .registers 4
    .parameter "isChecked"

    .prologue
    .line 83
    iget-object v0, p0, Landroid/preference/CheckBoxPreference$1;->this$0:Landroid/preference/CheckBoxPreference;

    iget-object v1, p0, Landroid/preference/CheckBoxPreference$1;->this$0:Landroid/preference/CheckBoxPreference;

    invoke-virtual {v1}, Landroid/preference/CheckBoxPreference;->getPreferenceManager()Landroid/preference/PreferenceManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/preference/PreferenceManager;->getPreferenceScreen()Landroid/preference/PreferenceScreen;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/preference/CheckBoxPreference;->performClick(Landroid/preference/PreferenceScreen;)V

    .line 84
    iget-object v0, p0, Landroid/preference/CheckBoxPreference$1;->this$0:Landroid/preference/CheckBoxPreference;

    invoke-virtual {v0}, Landroid/preference/CheckBoxPreference;->isChecked()Z

    move-result v0

    if-eq p1, v0, :cond_2a

    .line 85
    iget-object v0, p0, Landroid/preference/CheckBoxPreference$1;->val$slidingButton:Lmiui/widget/SlidingButton;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lmiui/widget/SlidingButton;->setOnCheckedChangedListener(Lmiui/widget/SlidingButton$OnCheckedChangedListener;)V

    .line 86
    iget-object v1, p0, Landroid/preference/CheckBoxPreference$1;->val$slidingButton:Lmiui/widget/SlidingButton;

    if-nez p1, :cond_2b

    const/4 v0, 0x1

    :goto_22
    invoke-virtual {v1, v0}, Lmiui/widget/SlidingButton;->setChecked(Z)V

    .line 87
    iget-object v0, p0, Landroid/preference/CheckBoxPreference$1;->val$slidingButton:Lmiui/widget/SlidingButton;

    invoke-virtual {v0, p0}, Lmiui/widget/SlidingButton;->setOnCheckedChangedListener(Lmiui/widget/SlidingButton$OnCheckedChangedListener;)V

    .line 89
    :cond_2a
    return-void

    .line 86
    :cond_2b
    const/4 v0, 0x0

    goto :goto_22
.end method
