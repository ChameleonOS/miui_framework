.class public final Lmiui/security/ChooseLockSettingsHelper;
.super Ljava/lang/Object;
.source "ChooseLockSettingsHelper.java"


# static fields
.field public static final DISABLE_ACCESS_CONTROL:I = 0x1

.field public static final DISABLE_AC_FOR_PRIVACY_MODE:I = 0x3

.field public static final DISABLE_PRIVACY_MODE:I = 0x4

.field public static final ENABLE_AC_FOR_PRIVACY_MODE:I = 0x2

.field public static final EXTRA_CONFIRM_PURPOSE:Ljava/lang/String; = "confirm_purpose"

.field public static final EXTRA_KEY_PASSWORD:Ljava/lang/String; = "password"

.field public static final FOOTER_TEXT:Ljava/lang/String; = "com.android.settings.ConfirmLockPattern.footer"

.field public static final FOOTER_WRONG_TEXT:Ljava/lang/String; = "com.android.settings.ConfirmLockPattern.footer_wrong"

.field public static final HEADER_TEXT:Ljava/lang/String; = "com.android.settings.ConfirmLockPattern.header"

.field public static final HEADER_WRONG_TEXT:Ljava/lang/String; = "com.android.settings.ConfirmLockPattern.header_wrong"

.field private static final NO_REQUEST_FOR_ACTIVITY_RESULT:I = -0x400


# instance fields
.field private mActivity:Landroid/app/Activity;

.field private mContext:Landroid/content/Context;

.field private mFragment:Landroid/app/Fragment;

.field private mLockPatternUtils:Lmiui/security/MiuiLockPatternUtils;


# direct methods
.method public constructor <init>(Landroid/app/Activity;)V
    .registers 2
    .parameter "activity"

    .prologue
    invoke-direct {p0, p1}, Lmiui/security/ChooseLockSettingsHelper;-><init>(Landroid/content/Context;)V

    iput-object p1, p0, Lmiui/security/ChooseLockSettingsHelper;->mActivity:Landroid/app/Activity;

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Landroid/app/Fragment;)V
    .registers 3
    .parameter "activity"
    .parameter "fragment"

    .prologue
    invoke-direct {p0, p1}, Lmiui/security/ChooseLockSettingsHelper;-><init>(Landroid/app/Activity;)V

    iput-object p2, p0, Lmiui/security/ChooseLockSettingsHelper;->mFragment:Landroid/app/Fragment;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .registers 4
    .parameter "context"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lmiui/security/ChooseLockSettingsHelper;->mContext:Landroid/content/Context;

    new-instance v0, Lmiui/security/MiuiLockPatternUtils;

    iget-object v1, p0, Lmiui/security/ChooseLockSettingsHelper;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lmiui/security/MiuiLockPatternUtils;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lmiui/security/ChooseLockSettingsHelper;->mLockPatternUtils:Lmiui/security/MiuiLockPatternUtils;

    return-void
.end method

.method private confirmPassword(I)Z
    .registers 5
    .parameter "request"

    .prologue
    iget-object v1, p0, Lmiui/security/ChooseLockSettingsHelper;->mLockPatternUtils:Lmiui/security/MiuiLockPatternUtils;

    invoke-virtual {v1}, Lmiui/security/MiuiLockPatternUtils;->isLockPasswordEnabled()Z

    move-result v1

    if-nez v1, :cond_a

    const/4 v1, 0x0

    :goto_9
    return v1

    :cond_a
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .local v0, intent:Landroid/content/Intent;
    const-string v1, "com.android.settings"

    const-string v2, "com.android.settings.ConfirmLockPassword"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setClassName(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    const/16 v1, -0x400

    if-ne p1, v1, :cond_26

    const/high16 v1, 0x1000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    iget-object v1, p0, Lmiui/security/ChooseLockSettingsHelper;->mContext:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    :goto_24
    const/4 v1, 0x1

    goto :goto_9

    :cond_26
    iget-object v1, p0, Lmiui/security/ChooseLockSettingsHelper;->mFragment:Landroid/app/Fragment;

    if-eqz v1, :cond_30

    iget-object v1, p0, Lmiui/security/ChooseLockSettingsHelper;->mFragment:Landroid/app/Fragment;

    invoke-virtual {v1, v0, p1}, Landroid/app/Fragment;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_24

    :cond_30
    iget-object v1, p0, Lmiui/security/ChooseLockSettingsHelper;->mActivity:Landroid/app/Activity;

    invoke-virtual {v1, v0, p1}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_24
.end method

.method private confirmPattern(ILjava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    .registers 7
    .parameter "request"
    .parameter "message"
    .parameter "details"

    .prologue
    iget-object v1, p0, Lmiui/security/ChooseLockSettingsHelper;->mLockPatternUtils:Lmiui/security/MiuiLockPatternUtils;

    invoke-virtual {v1}, Lmiui/security/MiuiLockPatternUtils;->isLockPatternEnabled()Z

    move-result v1

    if-eqz v1, :cond_10

    iget-object v1, p0, Lmiui/security/ChooseLockSettingsHelper;->mLockPatternUtils:Lmiui/security/MiuiLockPatternUtils;

    invoke-virtual {v1}, Lmiui/security/MiuiLockPatternUtils;->savedPatternExists()Z

    move-result v1

    if-nez v1, :cond_12

    :cond_10
    const/4 v1, 0x0

    :goto_11
    return v1

    :cond_12
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .local v0, intent:Landroid/content/Intent;
    const-string v1, "com.android.settings.ConfirmLockPattern.header"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/CharSequence;)Landroid/content/Intent;

    const-string v1, "com.android.settings.ConfirmLockPattern.footer"

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/CharSequence;)Landroid/content/Intent;

    const-string v1, "com.android.settings"

    const-string v2, "com.android.settings.ConfirmLockPattern"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setClassName(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    const/16 v1, -0x400

    if-ne p1, v1, :cond_38

    const/high16 v1, 0x1000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    iget-object v1, p0, Lmiui/security/ChooseLockSettingsHelper;->mContext:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    :goto_36
    const/4 v1, 0x1

    goto :goto_11

    :cond_38
    iget-object v1, p0, Lmiui/security/ChooseLockSettingsHelper;->mFragment:Landroid/app/Fragment;

    if-eqz v1, :cond_42

    iget-object v1, p0, Lmiui/security/ChooseLockSettingsHelper;->mFragment:Landroid/app/Fragment;

    invoke-virtual {v1, v0, p1}, Landroid/app/Fragment;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_36

    :cond_42
    iget-object v1, p0, Lmiui/security/ChooseLockSettingsHelper;->mActivity:Landroid/app/Activity;

    invoke-virtual {v1, v0, p1}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_36
.end method


# virtual methods
.method public isACLockEnabled()Z
    .registers 5

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    iget-object v2, p0, Lmiui/security/ChooseLockSettingsHelper;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    const-string v3, "access_control_lock_enabled"

    invoke-static {v2, v3, v1}, Landroid/provider/Settings$Secure;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v2

    if-ne v0, v2, :cond_19

    iget-object v2, p0, Lmiui/security/ChooseLockSettingsHelper;->mLockPatternUtils:Lmiui/security/MiuiLockPatternUtils;

    invoke-virtual {v2}, Lmiui/security/MiuiLockPatternUtils;->savedAccessControlExists()Z

    move-result v2

    if-eqz v2, :cond_19

    :goto_18
    return v0

    :cond_19
    move v0, v1

    goto :goto_18
.end method

.method public isPasswordForPrivacyModeEnabled()Z
    .registers 5

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    iget-object v2, p0, Lmiui/security/ChooseLockSettingsHelper;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    const-string/jumbo v3, "password_for_privacymode"

    invoke-static {v2, v3, v1}, Landroid/provider/Settings$Secure;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v2

    if-ne v0, v2, :cond_12

    :goto_11
    return v0

    :cond_12
    move v0, v1

    goto :goto_11
.end method

.method public isPrivacyModeEnabled()Z
    .registers 5

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    iget-object v2, p0, Lmiui/security/ChooseLockSettingsHelper;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    const-string/jumbo v3, "privacy_mode_enabled"

    invoke-static {v2, v3, v1}, Landroid/provider/Settings$Secure;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v2

    if-ne v0, v2, :cond_12

    :goto_11
    return v0

    :cond_12
    move v0, v1

    goto :goto_11
.end method

.method public launchConfirmationActivity(ILjava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    .registers 6
    .parameter "request"
    .parameter "message"
    .parameter "details"

    .prologue
    iget-object v1, p0, Lmiui/security/ChooseLockSettingsHelper;->mActivity:Landroid/app/Activity;

    if-nez v1, :cond_6

    const/4 v0, 0x0

    :goto_5
    return v0

    :cond_6
    const/4 v0, 0x0

    .local v0, launched:Z
    iget-object v1, p0, Lmiui/security/ChooseLockSettingsHelper;->mLockPatternUtils:Lmiui/security/MiuiLockPatternUtils;

    invoke-virtual {v1}, Lmiui/security/MiuiLockPatternUtils;->getKeyguardStoredPasswordQuality()I

    move-result v1

    sparse-switch v1, :sswitch_data_1c

    goto :goto_5

    :sswitch_11
    invoke-direct {p0, p1, p2, p3}, Lmiui/security/ChooseLockSettingsHelper;->confirmPattern(ILjava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v0

    goto :goto_5

    :sswitch_16
    invoke-direct {p0, p1}, Lmiui/security/ChooseLockSettingsHelper;->confirmPassword(I)Z

    move-result v0

    goto :goto_5

    nop

    :sswitch_data_1c
    .sparse-switch
        0x10000 -> :sswitch_11
        0x20000 -> :sswitch_16
        0x40000 -> :sswitch_16
        0x50000 -> :sswitch_16
        0x60000 -> :sswitch_16
    .end sparse-switch
.end method

.method public launchConfirmationActivity(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    .registers 6
    .parameter "message"
    .parameter "details"

    .prologue
    const/16 v2, -0x400

    const/4 v0, 0x0

    .local v0, launched:Z
    iget-object v1, p0, Lmiui/security/ChooseLockSettingsHelper;->mLockPatternUtils:Lmiui/security/MiuiLockPatternUtils;

    invoke-virtual {v1}, Lmiui/security/MiuiLockPatternUtils;->getKeyguardStoredPasswordQuality()I

    move-result v1

    sparse-switch v1, :sswitch_data_18

    :goto_c
    return v0

    :sswitch_d
    invoke-direct {p0, v2, p1, p2}, Lmiui/security/ChooseLockSettingsHelper;->confirmPattern(ILjava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v0

    goto :goto_c

    :sswitch_12
    invoke-direct {p0, v2}, Lmiui/security/ChooseLockSettingsHelper;->confirmPassword(I)Z

    move-result v0

    goto :goto_c

    nop

    :sswitch_data_18
    .sparse-switch
        0x10000 -> :sswitch_d
        0x20000 -> :sswitch_12
        0x40000 -> :sswitch_12
        0x50000 -> :sswitch_12
        0x60000 -> :sswitch_12
    .end sparse-switch
.end method

.method public setACLockEnabled(Z)V
    .registers 5
    .parameter "enabled"

    .prologue
    iget-object v0, p0, Lmiui/security/ChooseLockSettingsHelper;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const-string v2, "access_control_lock_enabled"

    if-eqz p1, :cond_17

    const/4 v0, 0x1

    :goto_b
    invoke-static {v1, v2, v0}, Landroid/provider/Settings$Secure;->putInt(Landroid/content/ContentResolver;Ljava/lang/String;I)Z

    if-nez p1, :cond_16

    iget-object v0, p0, Lmiui/security/ChooseLockSettingsHelper;->mLockPatternUtils:Lmiui/security/MiuiLockPatternUtils;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lmiui/security/MiuiLockPatternUtils;->saveACLockPattern(Ljava/util/List;)V

    :cond_16
    return-void

    :cond_17
    const/4 v0, 0x0

    goto :goto_b
.end method

.method public setPasswordForPrivacyModeEnabled(Z)V
    .registers 5
    .parameter "enabled"

    .prologue
    iget-object v0, p0, Lmiui/security/ChooseLockSettingsHelper;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const-string/jumbo v2, "password_for_privacymode"

    if-eqz p1, :cond_10

    const/4 v0, 0x1

    :goto_c
    invoke-static {v1, v2, v0}, Landroid/provider/Settings$Secure;->putInt(Landroid/content/ContentResolver;Ljava/lang/String;I)Z

    return-void

    :cond_10
    const/4 v0, 0x0

    goto :goto_c
.end method

.method public setPrivacyModeEnabled(Z)V
    .registers 7
    .parameter "enabled"

    .prologue
    iget-object v2, p0, Lmiui/security/ChooseLockSettingsHelper;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    const-string/jumbo v4, "privacy_mode_enabled"

    if-eqz p1, :cond_31

    const/4 v2, 0x1

    :goto_c
    invoke-static {v3, v4, v2}, Landroid/provider/Settings$Secure;->putInt(Landroid/content/ContentResolver;Ljava/lang/String;I)Z

    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.PRIVACY_MODE_CHANGED"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .local v1, i:Landroid/content/Intent;
    const-string/jumbo v2, "privacy_mode_enabled"

    invoke-virtual {v1, v2, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    iget-object v2, p0, Lmiui/security/ChooseLockSettingsHelper;->mContext:Landroid/content/Context;

    invoke-virtual {v2, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    iget-object v2, p0, Lmiui/security/ChooseLockSettingsHelper;->mContext:Landroid/content/Context;

    const-string v3, "activity"

    invoke-virtual {v2, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    .local v0, am:Landroid/app/ActivityManager;
    const-string v2, "com.android.gallery3d"

    invoke-virtual {v0, v2}, Landroid/app/ActivityManager;->forceStopPackage(Ljava/lang/String;)V

    return-void

    .end local v0           #am:Landroid/app/ActivityManager;
    .end local v1           #i:Landroid/content/Intent;
    :cond_31
    const/4 v2, 0x0

    goto :goto_c
.end method

.method public utils()Lmiui/security/MiuiLockPatternUtils;
    .registers 2

    .prologue
    iget-object v0, p0, Lmiui/security/ChooseLockSettingsHelper;->mLockPatternUtils:Lmiui/security/MiuiLockPatternUtils;

    return-object v0
.end method
