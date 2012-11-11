.class public Lcom/miui/internal/app/DisclaimerActivity;
.super Lcom/android/internal/app/AlertActivity;
.source "DisclaimerActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/miui/internal/app/DisclaimerActivity$IntentSpan;
    }
.end annotation


# static fields
.field public static final STOP_PACKAGE_NAME:Ljava/lang/String; = "stop_package_name"

.field private static mPredefinePackages:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field static final sPredefinedPackage:[Ljava/lang/String;


# instance fields
.field public mStopPackageName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 7

    .prologue
    const/4 v4, 0x4

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    const-string v6, "com.miui.player"

    aput-object v6, v4, v5

    const/4 v5, 0x1

    const-string v6, "com.xiaomi.market"

    aput-object v6, v4, v5

    const/4 v5, 0x2

    const-string v6, "com.miui.backup"

    aput-object v6, v4, v5

    const/4 v5, 0x3

    const-string v6, "com.android.updater"

    aput-object v6, v4, v5

    sput-object v4, Lcom/miui/internal/app/DisclaimerActivity;->sPredefinedPackage:[Ljava/lang/String;

    new-instance v4, Ljava/util/HashSet;

    sget-object v5, Lcom/miui/internal/app/DisclaimerActivity;->sPredefinedPackage:[Ljava/lang/String;

    array-length v5, v5

    invoke-direct {v4, v5}, Ljava/util/HashSet;-><init>(I)V

    sput-object v4, Lcom/miui/internal/app/DisclaimerActivity;->mPredefinePackages:Ljava/util/HashSet;

    sget-object v0, Lcom/miui/internal/app/DisclaimerActivity;->sPredefinedPackage:[Ljava/lang/String;

    .local v0, arr$:[Ljava/lang/String;
    array-length v2, v0

    .local v2, len$:I
    const/4 v1, 0x0

    .local v1, i$:I
    :goto_27
    if-ge v1, v2, :cond_33

    aget-object v3, v0, v1

    .local v3, packageName:Ljava/lang/String;
    sget-object v4, Lcom/miui/internal/app/DisclaimerActivity;->mPredefinePackages:Ljava/util/HashSet;

    invoke-virtual {v4, v3}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    add-int/lit8 v1, v1, 0x1

    goto :goto_27

    .end local v3           #packageName:Ljava/lang/String;
    :cond_33
    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct {p0}, Lcom/android/internal/app/AlertActivity;-><init>()V

    return-void
.end method

.method private forceStopPackage()V
    .registers 3

    .prologue
    iget-object v1, p0, Lcom/miui/internal/app/DisclaimerActivity;->mStopPackageName:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_15

    const-string v1, "activity"

    invoke-virtual {p0, v1}, Lcom/miui/internal/app/DisclaimerActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    .local v0, am:Landroid/app/ActivityManager;
    iget-object v1, p0, Lcom/miui/internal/app/DisclaimerActivity;->mStopPackageName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/app/ActivityManager;->forceStopPackage(Ljava/lang/String;)V

    .end local v0           #am:Landroid/app/ActivityManager;
    :cond_15
    return-void
.end method

.method public static requestApproval(Landroid/content/Context;Ljava/lang/String;)Z
    .registers 6
    .parameter "context"
    .parameter "packageName"

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_1c

    sget-object v2, Lcom/miui/internal/app/DisclaimerActivity;->mPredefinePackages:Ljava/util/HashSet;

    invoke-virtual {v2, p1}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1c

    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    const-string v3, "confirm_miui_disclaimer"

    invoke-static {v2, v3, v1}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v2

    if-ne v2, v0, :cond_1d

    :cond_1c
    move v0, v1

    :cond_1d
    return v0
.end method


# virtual methods
.method public onBackPressed()V
    .registers 2

    .prologue
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/miui/internal/app/DisclaimerActivity;->setResult(I)V

    invoke-direct {p0}, Lcom/miui/internal/app/DisclaimerActivity;->forceStopPackage()V

    invoke-virtual {p0}, Lcom/miui/internal/app/DisclaimerActivity;->finish()V

    invoke-super {p0}, Lcom/android/internal/app/AlertActivity;->onBackPressed()V

    return-void
.end method

.method public onClick(Landroid/content/DialogInterface;I)V
    .registers 6
    .parameter "dialog"
    .parameter "which"

    .prologue
    const/4 v2, 0x1

    const/4 v0, -0x1

    if-ne p2, v0, :cond_14

    invoke-virtual {p0}, Lcom/miui/internal/app/DisclaimerActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const-string v1, "confirm_miui_disclaimer"

    invoke-static {v0, v1, v2}, Landroid/provider/Settings$System;->putInt(Landroid/content/ContentResolver;Ljava/lang/String;I)Z

    invoke-virtual {p0, v2}, Lcom/miui/internal/app/DisclaimerActivity;->setResult(I)V

    :cond_10
    :goto_10
    invoke-virtual {p0}, Lcom/miui/internal/app/DisclaimerActivity;->finish()V

    return-void

    :cond_14
    const/4 v0, -0x2

    if-ne p2, v0, :cond_10

    invoke-direct {p0}, Lcom/miui/internal/app/DisclaimerActivity;->forceStopPackage()V

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/miui/internal/app/DisclaimerActivity;->setResult(I)V

    goto :goto_10
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .registers 15
    .parameter "icicle"

    .prologue
    const/16 v12, 0x21

    invoke-super {p0, p1}, Lcom/android/internal/app/AlertActivity;->onCreate(Landroid/os/Bundle;)V

    invoke-virtual {p0}, Lcom/miui/internal/app/DisclaimerActivity;->getWindow()Landroid/view/Window;

    move-result-object v8

    const v9, 0x106000d

    invoke-virtual {v8, v9}, Landroid/view/Window;->setBackgroundDrawableResource(I)V

    invoke-virtual {p0}, Lcom/miui/internal/app/DisclaimerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v8

    const-string/jumbo v9, "stop_package_name"

    invoke-virtual {v8, v9}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    iput-object v8, p0, Lcom/miui/internal/app/DisclaimerActivity;->mStopPackageName:Ljava/lang/String;

    const v8, 0x60c0033

    invoke-virtual {p0, v8}, Lcom/miui/internal/app/DisclaimerActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    .local v2, s1:Ljava/lang/String;
    const v8, 0x60c0034

    invoke-virtual {p0, v8}, Lcom/miui/internal/app/DisclaimerActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    .local v3, s2:Ljava/lang/String;
    const v8, 0x60c0035

    invoke-virtual {p0, v8}, Lcom/miui/internal/app/DisclaimerActivity;->getString(I)Ljava/lang/String;

    move-result-object v4

    .local v4, s3:Ljava/lang/String;
    const v8, 0x60c0036

    invoke-virtual {p0, v8}, Lcom/miui/internal/app/DisclaimerActivity;->getString(I)Ljava/lang/String;

    move-result-object v5

    .local v5, s4:Ljava/lang/String;
    const v8, 0x60c0037

    invoke-virtual {p0, v8}, Lcom/miui/internal/app/DisclaimerActivity;->getString(I)Ljava/lang/String;

    move-result-object v6

    .local v6, s5:Ljava/lang/String;
    new-instance v7, Landroid/text/SpannableStringBuilder;

    invoke-direct {v7}, Landroid/text/SpannableStringBuilder;-><init>()V

    .local v7, ss:Landroid/text/SpannableStringBuilder;
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    new-instance v8, Lcom/miui/internal/app/DisclaimerActivity$IntentSpan;

    sget-object v9, Lcom/miui/internal/app/MiuiLicenseActivity;->URL_MIUI_USER_AGREEMENT:Ljava/lang/String;

    invoke-direct {v8, p0, v9}, Lcom/miui/internal/app/DisclaimerActivity$IntentSpan;-><init>(Lcom/miui/internal/app/DisclaimerActivity;Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v9

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v10

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v11

    add-int/2addr v10, v11

    invoke-virtual {v7, v8, v9, v10, v12}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    new-instance v8, Lcom/miui/internal/app/DisclaimerActivity$IntentSpan;

    sget-object v9, Lcom/miui/internal/app/MiuiLicenseActivity;->URL_MIUI_PRIVACY_POLICY:Ljava/lang/String;

    invoke-direct {v8, p0, v9}, Lcom/miui/internal/app/DisclaimerActivity$IntentSpan;-><init>(Lcom/miui/internal/app/DisclaimerActivity;Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v9

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v10

    add-int/2addr v9, v10

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v10

    add-int/2addr v9, v10

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v10

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v11

    add-int/2addr v10, v11

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v11

    add-int/2addr v10, v11

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v11

    add-int/2addr v10, v11

    invoke-virtual {v7, v8, v9, v10, v12}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    iget-object v1, p0, Lcom/android/internal/app/AlertActivity;->mAlertParams:Lcom/android/internal/app/AlertController$AlertParams;

    .local v1, p:Lcom/android/internal/app/AlertController$AlertParams;
    const v8, 0x108009b

    iput v8, v1, Lcom/android/internal/app/AlertController$AlertParams;->mIconId:I

    iput-object v7, v1, Lcom/android/internal/app/AlertController$AlertParams;->mMessage:Ljava/lang/CharSequence;

    const v8, 0x104000a

    invoke-virtual {p0, v8}, Lcom/miui/internal/app/DisclaimerActivity;->getString(I)Ljava/lang/String;

    move-result-object v8

    iput-object v8, v1, Lcom/android/internal/app/AlertController$AlertParams;->mPositiveButtonText:Ljava/lang/CharSequence;

    iput-object p0, v1, Lcom/android/internal/app/AlertController$AlertParams;->mPositiveButtonListener:Landroid/content/DialogInterface$OnClickListener;

    const/high16 v8, 0x104

    invoke-virtual {p0, v8}, Lcom/miui/internal/app/DisclaimerActivity;->getString(I)Ljava/lang/String;

    move-result-object v8

    iput-object v8, v1, Lcom/android/internal/app/AlertController$AlertParams;->mNegativeButtonText:Ljava/lang/CharSequence;

    iput-object p0, v1, Lcom/android/internal/app/AlertController$AlertParams;->mNegativeButtonListener:Landroid/content/DialogInterface$OnClickListener;

    invoke-virtual {p0}, Lcom/miui/internal/app/DisclaimerActivity;->setupAlert()V

    invoke-virtual {p0}, Lcom/miui/internal/app/DisclaimerActivity;->getWindow()Landroid/view/Window;

    move-result-object v8

    const v9, 0x102000b

    invoke-virtual {v8, v9}, Landroid/view/Window;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .local v0, messageText:Landroid/widget/TextView;
    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v8

    invoke-virtual {v0, v8}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    return-void
.end method
