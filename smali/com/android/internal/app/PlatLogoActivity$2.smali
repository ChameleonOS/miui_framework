.class Lcom/android/internal/app/PlatLogoActivity$2;
.super Ljava/lang/Object;
.source "PlatLogoActivity.java"

# interfaces
.implements Landroid/view/View$OnLongClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/internal/app/PlatLogoActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/internal/app/PlatLogoActivity;


# direct methods
.method constructor <init>(Lcom/android/internal/app/PlatLogoActivity;)V
    .registers 2
    .parameter

    .prologue
    .line 109
    iput-object p1, p0, Lcom/android/internal/app/PlatLogoActivity$2;->this$0:Lcom/android/internal/app/PlatLogoActivity;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLongClick(Landroid/view/View;)Z
    .registers 6
    .parameter "v"

    .prologue
    .line 113
    :try_start_0
    iget-object v1, p0, Lcom/android/internal/app/PlatLogoActivity$2;->this$0:Lcom/android/internal/app/PlatLogoActivity;

    new-instance v2, Landroid/content/Intent;

    const-string v3, "android.intent.action.MAIN"

    invoke-direct {v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const v3, 0x10808000

    invoke-virtual {v2, v3}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    move-result-object v2

    const-string v3, "com.android.internal.category.PLATLOGO"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/android/internal/app/PlatLogoActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_19
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_19} :catch_20

    .line 122
    :goto_19
    iget-object v1, p0, Lcom/android/internal/app/PlatLogoActivity$2;->this$0:Lcom/android/internal/app/PlatLogoActivity;

    invoke-virtual {v1}, Lcom/android/internal/app/PlatLogoActivity;->finish()V

    .line 123
    const/4 v1, 0x1

    return v1

    .line 119
    :catch_20
    move-exception v0

    .line 120
    .local v0, ex:Landroid/content/ActivityNotFoundException;
    const-string v1, "PlatLogoActivity"

    const-string v2, "Couldn\'t find a bag of beans."

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_19
.end method
