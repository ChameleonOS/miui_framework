.class Lmiui/preference/WeekdayPreference$1;
.super Ljava/lang/Object;
.source "WeekdayPreference.java"

# interfaces
.implements Landroid/content/DialogInterface$OnMultiChoiceClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lmiui/preference/WeekdayPreference;->onPrepareDialogBuilder(Landroid/app/AlertDialog$Builder;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lmiui/preference/WeekdayPreference;


# direct methods
.method constructor <init>(Lmiui/preference/WeekdayPreference;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Lmiui/preference/WeekdayPreference$1;->this$0:Lmiui/preference/WeekdayPreference;

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
    iget-object v0, p0, Lmiui/preference/WeekdayPreference$1;->this$0:Lmiui/preference/WeekdayPreference;

    #getter for: Lmiui/preference/WeekdayPreference;->mNewDaysOfWeek:Lmiui/preference/WeekdayPreference$DaysOfWeek;
    invoke-static {v0}, Lmiui/preference/WeekdayPreference;->access$000(Lmiui/preference/WeekdayPreference;)Lmiui/preference/WeekdayPreference$DaysOfWeek;

    move-result-object v0

    invoke-virtual {v0, p2, p3}, Lmiui/preference/WeekdayPreference$DaysOfWeek;->set(IZ)V

    return-void
.end method
