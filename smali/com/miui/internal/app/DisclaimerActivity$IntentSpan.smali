.class Lcom/miui/internal/app/DisclaimerActivity$IntentSpan;
.super Landroid/text/style/ClickableSpan;
.source "DisclaimerActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/miui/internal/app/DisclaimerActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "IntentSpan"
.end annotation


# instance fields
.field private mUrl:Ljava/lang/String;

.field final synthetic this$0:Lcom/miui/internal/app/DisclaimerActivity;


# direct methods
.method public constructor <init>(Lcom/miui/internal/app/DisclaimerActivity;Ljava/lang/String;)V
    .registers 3
    .parameter
    .parameter "url"

    .prologue
    iput-object p1, p0, Lcom/miui/internal/app/DisclaimerActivity$IntentSpan;->this$0:Lcom/miui/internal/app/DisclaimerActivity;

    invoke-direct {p0}, Landroid/text/style/ClickableSpan;-><init>()V

    iput-object p2, p0, Lcom/miui/internal/app/DisclaimerActivity$IntentSpan;->mUrl:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .registers 5
    .parameter "widget"

    .prologue
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.MIUI_LICENSE"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .local v0, intent:Landroid/content/Intent;
    sget-object v1, Lcom/miui/internal/app/MiuiLicenseActivity;->EXTRA_MIUI_DOC_URL:Ljava/lang/String;

    iget-object v2, p0, Lcom/miui/internal/app/DisclaimerActivity$IntentSpan;->mUrl:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    iget-object v1, p0, Lcom/miui/internal/app/DisclaimerActivity$IntentSpan;->this$0:Lcom/miui/internal/app/DisclaimerActivity;

    invoke-virtual {v1, v0}, Lcom/miui/internal/app/DisclaimerActivity;->startActivity(Landroid/content/Intent;)V

    return-void
.end method

.method public updateDrawState(Landroid/text/TextPaint;)V
    .registers 3
    .parameter "ds"

    .prologue
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setUnderlineText(Z)V

    const v0, -0xffff01

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setColor(I)V

    return-void
.end method
