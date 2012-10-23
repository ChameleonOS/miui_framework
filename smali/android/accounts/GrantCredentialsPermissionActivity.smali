.class public Landroid/accounts/GrantCredentialsPermissionActivity;
.super Landroid/app/Activity;
.source "GrantCredentialsPermissionActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# static fields
.field public static final EXTRAS_ACCOUNT:Ljava/lang/String; = "account"

.field public static final EXTRAS_ACCOUNT_TYPE_LABEL:Ljava/lang/String; = "accountTypeLabel"

.field public static final EXTRAS_AUTH_TOKEN_LABEL:Ljava/lang/String; = "authTokenLabel"

.field public static final EXTRAS_AUTH_TOKEN_TYPE:Ljava/lang/String; = "authTokenType"

.field public static final EXTRAS_PACKAGES:Ljava/lang/String; = "application"

.field public static final EXTRAS_REQUESTING_UID:Ljava/lang/String; = "uid"

.field public static final EXTRAS_RESPONSE:Ljava/lang/String; = "response"


# instance fields
.field private mAccount:Landroid/accounts/Account;

.field private mAuthTokenType:Ljava/lang/String;

.field protected mInflater:Landroid/view/LayoutInflater;

.field private mResultBundle:Landroid/os/Bundle;

.field private mUid:I


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 38
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 49
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/accounts/GrantCredentialsPermissionActivity;->mResultBundle:Landroid/os/Bundle;

    return-void
.end method

.method private getAccountLabel(Landroid/accounts/Account;)Ljava/lang/String;
    .registers 9
    .parameter "account"

    .prologue
    .line 136
    invoke-static {p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v5

    invoke-virtual {v5}, Landroid/accounts/AccountManager;->getAuthenticatorTypes()[Landroid/accounts/AuthenticatorDescription;

    move-result-object v1

    .line 138
    .local v1, authenticatorTypes:[Landroid/accounts/AuthenticatorDescription;
    const/4 v4, 0x0

    .local v4, i:I
    array-length v0, v1

    .local v0, N:I
    :goto_a
    if-ge v4, v0, :cond_31

    .line 139
    aget-object v2, v1, v4

    .line 140
    .local v2, desc:Landroid/accounts/AuthenticatorDescription;
    iget-object v5, v2, Landroid/accounts/AuthenticatorDescription;->type:Ljava/lang/String;

    iget-object v6, p1, Landroid/accounts/Account;->type:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2e

    .line 142
    :try_start_18
    iget-object v5, v2, Landroid/accounts/AuthenticatorDescription;->packageName:Ljava/lang/String;

    const/4 v6, 0x0

    invoke-virtual {p0, v5, v6}, Landroid/accounts/GrantCredentialsPermissionActivity;->createPackageContext(Ljava/lang/String;I)Landroid/content/Context;

    move-result-object v5

    iget v6, v2, Landroid/accounts/AuthenticatorDescription;->labelId:I

    invoke-virtual {v5, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;
    :try_end_24
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_18 .. :try_end_24} :catch_26
    .catch Landroid/content/res/Resources$NotFoundException; {:try_start_18 .. :try_end_24} :catch_2a

    move-result-object v5

    .line 150
    .end local v2           #desc:Landroid/accounts/AuthenticatorDescription;
    :goto_25
    return-object v5

    .line 143
    .restart local v2       #desc:Landroid/accounts/AuthenticatorDescription;
    :catch_26
    move-exception v3

    .line 144
    .local v3, e:Landroid/content/pm/PackageManager$NameNotFoundException;
    iget-object v5, p1, Landroid/accounts/Account;->type:Ljava/lang/String;

    goto :goto_25

    .line 145
    .end local v3           #e:Landroid/content/pm/PackageManager$NameNotFoundException;
    :catch_2a
    move-exception v3

    .line 146
    .local v3, e:Landroid/content/res/Resources$NotFoundException;
    iget-object v5, p1, Landroid/accounts/Account;->type:Ljava/lang/String;

    goto :goto_25

    .line 138
    .end local v3           #e:Landroid/content/res/Resources$NotFoundException;
    :cond_2e
    add-int/lit8 v4, v4, 0x1

    goto :goto_a

    .line 150
    .end local v2           #desc:Landroid/accounts/AuthenticatorDescription;
    :cond_31
    iget-object v5, p1, Landroid/accounts/Account;->type:Ljava/lang/String;

    goto :goto_25
.end method

.method private newPackageView(Ljava/lang/String;)Landroid/view/View;
    .registers 6
    .parameter "packageLabel"

    .prologue
    .line 154
    iget-object v1, p0, Landroid/accounts/GrantCredentialsPermissionActivity;->mInflater:Landroid/view/LayoutInflater;

    const v2, 0x109007b

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 155
    .local v0, view:Landroid/view/View;
    const v1, 0x10202ff

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    invoke-virtual {v1, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 156
    return-object v0
.end method


# virtual methods
.method public finish()V
    .registers 5

    .prologue
    .line 186
    invoke-virtual {p0}, Landroid/accounts/GrantCredentialsPermissionActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 187
    .local v0, intent:Landroid/content/Intent;
    const-string/jumbo v2, "response"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Landroid/accounts/AccountAuthenticatorResponse;

    .line 188
    .local v1, response:Landroid/accounts/AccountAuthenticatorResponse;
    if-eqz v1, :cond_18

    .line 190
    iget-object v2, p0, Landroid/accounts/GrantCredentialsPermissionActivity;->mResultBundle:Landroid/os/Bundle;

    if-eqz v2, :cond_1c

    .line 191
    iget-object v2, p0, Landroid/accounts/GrantCredentialsPermissionActivity;->mResultBundle:Landroid/os/Bundle;

    invoke-virtual {v1, v2}, Landroid/accounts/AccountAuthenticatorResponse;->onResult(Landroid/os/Bundle;)V

    .line 196
    :cond_18
    :goto_18
    invoke-super {p0}, Landroid/app/Activity;->finish()V

    .line 197
    return-void

    .line 193
    :cond_1c
    const/4 v2, 0x4

    const-string v3, "canceled"

    invoke-virtual {v1, v2, v3}, Landroid/accounts/AccountAuthenticatorResponse;->onError(ILjava/lang/String;)V

    goto :goto_18
.end method

.method public onClick(Landroid/view/View;)V
    .registers 9
    .parameter "v"

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 160
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v1

    packed-switch v1, :pswitch_data_42

    .line 174
    :goto_9
    invoke-virtual {p0}, Landroid/accounts/GrantCredentialsPermissionActivity;->finish()V

    .line 175
    return-void

    .line 162
    :pswitch_d
    invoke-static {p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v1

    iget-object v2, p0, Landroid/accounts/GrantCredentialsPermissionActivity;->mAccount:Landroid/accounts/Account;

    iget-object v3, p0, Landroid/accounts/GrantCredentialsPermissionActivity;->mAuthTokenType:Ljava/lang/String;

    iget v4, p0, Landroid/accounts/GrantCredentialsPermissionActivity;->mUid:I

    invoke-virtual {v1, v2, v3, v4, v6}, Landroid/accounts/AccountManager;->updateAppPermission(Landroid/accounts/Account;Ljava/lang/String;IZ)V

    .line 163
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 164
    .local v0, result:Landroid/content/Intent;
    const-string/jumbo v1, "retry"

    invoke-virtual {v0, v1, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 165
    const/4 v1, -0x1

    invoke-virtual {p0, v1, v0}, Landroid/accounts/GrantCredentialsPermissionActivity;->setResult(ILandroid/content/Intent;)V

    .line 166
    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {p0, v1}, Landroid/accounts/GrantCredentialsPermissionActivity;->setAccountAuthenticatorResult(Landroid/os/Bundle;)V

    goto :goto_9

    .line 170
    .end local v0           #result:Landroid/content/Intent;
    :pswitch_31
    invoke-static {p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v1

    iget-object v2, p0, Landroid/accounts/GrantCredentialsPermissionActivity;->mAccount:Landroid/accounts/Account;

    iget-object v3, p0, Landroid/accounts/GrantCredentialsPermissionActivity;->mAuthTokenType:Ljava/lang/String;

    iget v4, p0, Landroid/accounts/GrantCredentialsPermissionActivity;->mUid:I

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/accounts/AccountManager;->updateAppPermission(Landroid/accounts/Account;Ljava/lang/String;IZ)V

    .line 171
    invoke-virtual {p0, v5}, Landroid/accounts/GrantCredentialsPermissionActivity;->setResult(I)V

    goto :goto_9

    .line 160
    :pswitch_data_42
    .packed-switch 0x1020281
        :pswitch_31
        :pswitch_d
    .end packed-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .registers 23
    .parameter "savedInstanceState"

    .prologue
    .line 53
    invoke-super/range {p0 .. p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 54
    const v17, 0x1090043

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/accounts/GrantCredentialsPermissionActivity;->setContentView(I)V

    .line 55
    const v17, 0x1040470

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/accounts/GrantCredentialsPermissionActivity;->setTitle(I)V

    .line 57
    const-string v17, "layout_inflater"

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/accounts/GrantCredentialsPermissionActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Landroid/view/LayoutInflater;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Landroid/accounts/GrantCredentialsPermissionActivity;->mInflater:Landroid/view/LayoutInflater;

    .line 59
    invoke-virtual/range {p0 .. p0}, Landroid/accounts/GrantCredentialsPermissionActivity;->getIntent()Landroid/content/Intent;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v9

    .line 60
    .local v9, extras:Landroid/os/Bundle;
    if-nez v9, :cond_40

    .line 62
    const/16 v17, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/accounts/GrantCredentialsPermissionActivity;->setResult(I)V

    .line 63
    invoke-virtual/range {p0 .. p0}, Landroid/accounts/GrantCredentialsPermissionActivity;->finish()V

    .line 133
    :goto_3f
    return-void

    .line 68
    :cond_40
    const-string v17, "account"

    move-object/from16 v0, v17

    invoke-virtual {v9, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v17

    check-cast v17, Landroid/accounts/Account;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Landroid/accounts/GrantCredentialsPermissionActivity;->mAccount:Landroid/accounts/Account;

    .line 69
    const-string v17, "authTokenType"

    move-object/from16 v0, v17

    invoke-virtual {v9, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Landroid/accounts/GrantCredentialsPermissionActivity;->mAuthTokenType:Ljava/lang/String;

    .line 70
    const-string/jumbo v17, "uid"

    move-object/from16 v0, v17

    invoke-virtual {v9, v0}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v17

    move/from16 v0, v17

    move-object/from16 v1, p0

    iput v0, v1, Landroid/accounts/GrantCredentialsPermissionActivity;->mUid:I

    .line 71
    invoke-virtual/range {p0 .. p0}, Landroid/accounts/GrantCredentialsPermissionActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v16

    .line 72
    .local v16, pm:Landroid/content/pm/PackageManager;
    move-object/from16 v0, p0

    iget v0, v0, Landroid/accounts/GrantCredentialsPermissionActivity;->mUid:I

    move/from16 v17, v0

    invoke-virtual/range {v16 .. v17}, Landroid/content/pm/PackageManager;->getPackagesForUid(I)[Ljava/lang/String;

    move-result-object v13

    .line 74
    .local v13, packages:[Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/accounts/GrantCredentialsPermissionActivity;->mAccount:Landroid/accounts/Account;

    move-object/from16 v17, v0

    if-eqz v17, :cond_8d

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/accounts/GrantCredentialsPermissionActivity;->mAuthTokenType:Ljava/lang/String;

    move-object/from16 v17, v0

    if-eqz v17, :cond_8d

    if-nez v13, :cond_9a

    .line 76
    :cond_8d
    const/16 v17, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/accounts/GrantCredentialsPermissionActivity;->setResult(I)V

    .line 77
    invoke-virtual/range {p0 .. p0}, Landroid/accounts/GrantCredentialsPermissionActivity;->finish()V

    goto :goto_3f

    .line 83
    :cond_9a
    :try_start_9a
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/accounts/GrantCredentialsPermissionActivity;->mAccount:Landroid/accounts/Account;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-direct {v0, v1}, Landroid/accounts/GrantCredentialsPermissionActivity;->getAccountLabel(Landroid/accounts/Account;)Ljava/lang/String;
    :try_end_a7
    .catch Ljava/lang/IllegalArgumentException; {:try_start_9a .. :try_end_a7} :catch_13e

    move-result-object v4

    .line 91
    .local v4, accountTypeLabel:Ljava/lang/String;
    const v17, 0x102027e

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/accounts/GrantCredentialsPermissionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/TextView;

    .line 92
    .local v6, authTokenTypeView:Landroid/widget/TextView;
    const/16 v17, 0x8

    move/from16 v0, v17

    invoke-virtual {v6, v0}, Landroid/widget/TextView;->setVisibility(I)V

    .line 94
    new-instance v7, Landroid/accounts/GrantCredentialsPermissionActivity$1;

    move-object/from16 v0, p0

    invoke-direct {v7, v0, v6}, Landroid/accounts/GrantCredentialsPermissionActivity$1;-><init>(Landroid/accounts/GrantCredentialsPermissionActivity;Landroid/widget/TextView;)V

    .line 114
    .local v7, callback:Landroid/accounts/AccountManagerCallback;,"Landroid/accounts/AccountManagerCallback<Ljava/lang/String;>;"
    invoke-static/range {p0 .. p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v17

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/accounts/GrantCredentialsPermissionActivity;->mAccount:Landroid/accounts/Account;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    iget-object v0, v0, Landroid/accounts/Account;->type:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/accounts/GrantCredentialsPermissionActivity;->mAuthTokenType:Ljava/lang/String;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    move-object/from16 v2, v19

    move-object/from16 v3, v20

    invoke-virtual {v0, v1, v2, v7, v3}, Landroid/accounts/AccountManager;->getAuthTokenLabel(Ljava/lang/String;Ljava/lang/String;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;

    .line 116
    const v17, 0x1020282

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/accounts/GrantCredentialsPermissionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v17

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 117
    const v17, 0x1020281

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/accounts/GrantCredentialsPermissionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v17

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 119
    const v17, 0x102027a

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/accounts/GrantCredentialsPermissionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Landroid/widget/LinearLayout;

    .line 121
    .local v14, packagesListView:Landroid/widget/LinearLayout;
    move-object v5, v13

    .local v5, arr$:[Ljava/lang/String;
    array-length v11, v5

    .local v11, len$:I
    const/4 v10, 0x0

    .local v10, i$:I
    :goto_11a
    if-ge v10, v11, :cond_150

    aget-object v15, v5, v10

    .line 124
    .local v15, pkg:Ljava/lang/String;
    const/16 v17, 0x0

    :try_start_120
    move-object/from16 v0, v16

    move/from16 v1, v17

    invoke-virtual {v0, v15, v1}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v17

    invoke-virtual/range {v16 .. v17}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/Object;->toString()Ljava/lang/String;
    :try_end_12f
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_120 .. :try_end_12f} :catch_14d

    move-result-object v12

    .line 128
    .local v12, packageLabel:Ljava/lang/String;
    :goto_130
    move-object/from16 v0, p0

    invoke-direct {v0, v12}, Landroid/accounts/GrantCredentialsPermissionActivity;->newPackageView(Ljava/lang/String;)Landroid/view/View;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v14, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 121
    add-int/lit8 v10, v10, 0x1

    goto :goto_11a

    .line 84
    .end local v4           #accountTypeLabel:Ljava/lang/String;
    .end local v5           #arr$:[Ljava/lang/String;
    .end local v6           #authTokenTypeView:Landroid/widget/TextView;
    .end local v7           #callback:Landroid/accounts/AccountManagerCallback;,"Landroid/accounts/AccountManagerCallback<Ljava/lang/String;>;"
    .end local v10           #i$:I
    .end local v11           #len$:I
    .end local v12           #packageLabel:Ljava/lang/String;
    .end local v14           #packagesListView:Landroid/widget/LinearLayout;
    .end local v15           #pkg:Ljava/lang/String;
    :catch_13e
    move-exception v8

    .line 86
    .local v8, e:Ljava/lang/IllegalArgumentException;
    const/16 v17, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/accounts/GrantCredentialsPermissionActivity;->setResult(I)V

    .line 87
    invoke-virtual/range {p0 .. p0}, Landroid/accounts/GrantCredentialsPermissionActivity;->finish()V

    goto/16 :goto_3f

    .line 125
    .end local v8           #e:Ljava/lang/IllegalArgumentException;
    .restart local v4       #accountTypeLabel:Ljava/lang/String;
    .restart local v5       #arr$:[Ljava/lang/String;
    .restart local v6       #authTokenTypeView:Landroid/widget/TextView;
    .restart local v7       #callback:Landroid/accounts/AccountManagerCallback;,"Landroid/accounts/AccountManagerCallback<Ljava/lang/String;>;"
    .restart local v10       #i$:I
    .restart local v11       #len$:I
    .restart local v14       #packagesListView:Landroid/widget/LinearLayout;
    .restart local v15       #pkg:Ljava/lang/String;
    :catch_14d
    move-exception v8

    .line 126
    .local v8, e:Landroid/content/pm/PackageManager$NameNotFoundException;
    move-object v12, v15

    .restart local v12       #packageLabel:Ljava/lang/String;
    goto :goto_130

    .line 131
    .end local v8           #e:Landroid/content/pm/PackageManager$NameNotFoundException;
    .end local v12           #packageLabel:Ljava/lang/String;
    .end local v15           #pkg:Ljava/lang/String;
    :cond_150
    const v17, 0x102027d

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/accounts/GrantCredentialsPermissionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v17

    check-cast v17, Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/accounts/GrantCredentialsPermissionActivity;->mAccount:Landroid/accounts/Account;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    iget-object v0, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    move-object/from16 v18, v0

    invoke-virtual/range {v17 .. v18}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 132
    const v17, 0x102027c

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/accounts/GrantCredentialsPermissionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v17

    check-cast v17, Landroid/widget/TextView;

    move-object/from16 v0, v17

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_3f
.end method

.method public final setAccountAuthenticatorResult(Landroid/os/Bundle;)V
    .registers 2
    .parameter "result"

    .prologue
    .line 178
    iput-object p1, p0, Landroid/accounts/GrantCredentialsPermissionActivity;->mResultBundle:Landroid/os/Bundle;

    .line 179
    return-void
.end method
