.class public Landroid/accounts/ChooseTypeAndAccountActivity;
.super Landroid/app/Activity;
.source "ChooseTypeAndAccountActivity.java"

# interfaces
.implements Landroid/accounts/AccountManagerCallback;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/app/Activity;",
        "Landroid/accounts/AccountManagerCallback",
        "<",
        "Landroid/os/Bundle;",
        ">;"
    }
.end annotation


# static fields
.field public static final EXTRA_ADD_ACCOUNT_AUTH_TOKEN_TYPE_STRING:Ljava/lang/String; = "authTokenType"

.field public static final EXTRA_ADD_ACCOUNT_OPTIONS_BUNDLE:Ljava/lang/String; = "addAccountOptions"

.field public static final EXTRA_ADD_ACCOUNT_REQUIRED_FEATURES_STRING_ARRAY:Ljava/lang/String; = "addAccountRequiredFeatures"

.field public static final EXTRA_ALLOWABLE_ACCOUNTS_ARRAYLIST:Ljava/lang/String; = "allowableAccounts"

.field public static final EXTRA_ALLOWABLE_ACCOUNT_TYPES_STRING_ARRAY:Ljava/lang/String; = "allowableAccountTypes"

.field public static final EXTRA_ALWAYS_PROMPT_FOR_ACCOUNT:Ljava/lang/String; = "alwaysPromptForAccount"

.field public static final EXTRA_DESCRIPTION_TEXT_OVERRIDE:Ljava/lang/String; = "descriptionTextOverride"

.field public static final EXTRA_SELECTED_ACCOUNT:Ljava/lang/String; = "selectedAccount"

.field private static final KEY_INSTANCE_STATE_EXISTING_ACCOUNTS:Ljava/lang/String; = "existingAccounts"

.field private static final KEY_INSTANCE_STATE_PENDING_REQUEST:Ljava/lang/String; = "pendingRequest"

.field private static final KEY_INSTANCE_STATE_SELECTED_ACCOUNT_NAME:Ljava/lang/String; = "selectedAccountName"

.field private static final KEY_INSTANCE_STATE_SELECTED_ADD_ACCOUNT:Ljava/lang/String; = "selectedAddAccount"

.field public static final REQUEST_ADD_ACCOUNT:I = 0x2

.field public static final REQUEST_CHOOSE_TYPE:I = 0x1

.field public static final REQUEST_NULL:I = 0x0

.field private static final SELECTED_ITEM_NONE:I = -0x1

.field private static final TAG:Ljava/lang/String; = "AccountChooser"


# instance fields
.field private mAccounts:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/accounts/Account;",
            ">;"
        }
    .end annotation
.end field

.field private mExistingAccounts:[Landroid/os/Parcelable;

.field private mOkButton:Landroid/widget/Button;

.field private mPendingRequest:I

.field private mSelectedItemIndex:I


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 42
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 109
    const/4 v0, 0x0

    iput v0, p0, Landroid/accounts/ChooseTypeAndAccountActivity;->mPendingRequest:I

    .line 110
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/accounts/ChooseTypeAndAccountActivity;->mExistingAccounts:[Landroid/os/Parcelable;

    return-void
.end method

.method static synthetic access$002(Landroid/accounts/ChooseTypeAndAccountActivity;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 42
    iput p1, p0, Landroid/accounts/ChooseTypeAndAccountActivity;->mSelectedItemIndex:I

    return p1
.end method

.method static synthetic access$100(Landroid/accounts/ChooseTypeAndAccountActivity;)Landroid/widget/Button;
    .registers 2
    .parameter "x0"

    .prologue
    .line 42
    iget-object v0, p0, Landroid/accounts/ChooseTypeAndAccountActivity;->mOkButton:Landroid/widget/Button;

    return-object v0
.end method

.method private onAccountSelected(Landroid/accounts/Account;)V
    .registers 5
    .parameter "account"

    .prologue
    .line 450
    const-string v0, "AccountChooser"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "selected account "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 451
    iget-object v0, p1, Landroid/accounts/Account;->name:Ljava/lang/String;

    iget-object v1, p1, Landroid/accounts/Account;->type:Ljava/lang/String;

    invoke-direct {p0, v0, v1}, Landroid/accounts/ChooseTypeAndAccountActivity;->setResultAndFinish(Ljava/lang/String;Ljava/lang/String;)V

    .line 452
    return-void
.end method

.method private setResultAndFinish(Ljava/lang/String;Ljava/lang/String;)V
    .registers 7
    .parameter "accountName"
    .parameter "accountType"

    .prologue
    .line 455
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 456
    .local v0, bundle:Landroid/os/Bundle;
    const-string v1, "authAccount"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 457
    const-string v1, "accountType"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 458
    const/4 v1, -0x1

    new-instance v2, Landroid/content/Intent;

    invoke-direct {v2}, Landroid/content/Intent;-><init>()V

    invoke-virtual {v2, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Landroid/accounts/ChooseTypeAndAccountActivity;->setResult(ILandroid/content/Intent;)V

    .line 459
    const-string v1, "AccountChooser"

    const/4 v2, 0x2

    invoke-static {v1, v2}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v1

    if-eqz v1, :cond_47

    .line 460
    const-string v1, "AccountChooser"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "ChooseTypeAndAccountActivity.setResultAndFinish: selected account "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 463
    :cond_47
    invoke-virtual {p0}, Landroid/accounts/ChooseTypeAndAccountActivity;->finish()V

    .line 464
    return-void
.end method

.method private startChooseAccountTypeActivity()V
    .registers 6

    .prologue
    const/4 v4, 0x1

    .line 467
    const-string v1, "AccountChooser"

    const/4 v2, 0x2

    invoke-static {v1, v2}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v1

    if-eqz v1, :cond_11

    .line 468
    const-string v1, "AccountChooser"

    const-string v2, "ChooseAccountTypeActivity.startChooseAccountTypeActivity()"

    invoke-static {v1, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 470
    :cond_11
    new-instance v0, Landroid/content/Intent;

    const-class v1, Landroid/accounts/ChooseAccountTypeActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 471
    .local v0, intent:Landroid/content/Intent;
    const/high16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 472
    const-string v1, "allowableAccountTypes"

    invoke-virtual {p0}, Landroid/accounts/ChooseTypeAndAccountActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string v3, "allowableAccountTypes"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->getStringArrayExtra(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/Intent;

    .line 474
    const-string v1, "addAccountOptions"

    invoke-virtual {p0}, Landroid/accounts/ChooseTypeAndAccountActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string v3, "addAccountOptions"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 476
    const-string v1, "addAccountRequiredFeatures"

    invoke-virtual {p0}, Landroid/accounts/ChooseTypeAndAccountActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string v3, "addAccountRequiredFeatures"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->getStringArrayExtra(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/Intent;

    .line 478
    const-string v1, "authTokenType"

    invoke-virtual {p0}, Landroid/accounts/ChooseTypeAndAccountActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string v3, "authTokenType"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 480
    invoke-virtual {p0, v0, v4}, Landroid/accounts/ChooseTypeAndAccountActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 481
    iput v4, p0, Landroid/accounts/ChooseTypeAndAccountActivity;->mPendingRequest:I

    .line 482
    return-void
.end method


# virtual methods
.method protected onActivityResult(IILandroid/content/Intent;)V
    .registers 18
    .parameter "requestCode"
    .parameter "resultCode"
    .parameter "data"

    .prologue
    .line 339
    const-string v11, "AccountChooser"

    const/4 v12, 0x2

    invoke-static {v11, v12}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v11

    if-eqz v11, :cond_52

    .line 340
    if-eqz p3, :cond_18

    invoke-virtual/range {p3 .. p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v11

    if-eqz v11, :cond_18

    invoke-virtual/range {p3 .. p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v11

    invoke-virtual {v11}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    .line 341
    :cond_18
    if-eqz p3, :cond_67

    invoke-virtual/range {p3 .. p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v7

    .line 342
    .local v7, extras:Landroid/os/Bundle;
    :goto_1e
    const-string v11, "AccountChooser"

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "ChooseTypeAndAccountActivity.onActivityResult(reqCode="

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, ", resCode="

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    move/from16 v0, p2

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, ", extras="

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, ")"

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 347
    .end local v7           #extras:Landroid/os/Bundle;
    :cond_52
    const/4 v11, 0x0

    iput v11, p0, Landroid/accounts/ChooseTypeAndAccountActivity;->mPendingRequest:I

    .line 349
    if-nez p2, :cond_69

    .line 352
    iget-object v11, p0, Landroid/accounts/ChooseTypeAndAccountActivity;->mAccounts:Ljava/util/ArrayList;

    invoke-virtual {v11}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v11

    if-eqz v11, :cond_66

    .line 353
    const/4 v11, 0x0

    invoke-virtual {p0, v11}, Landroid/accounts/ChooseTypeAndAccountActivity;->setResult(I)V

    .line 354
    invoke-virtual {p0}, Landroid/accounts/ChooseTypeAndAccountActivity;->finish()V

    .line 407
    :cond_66
    :goto_66
    return-void

    .line 341
    :cond_67
    const/4 v7, 0x0

    goto :goto_1e

    .line 359
    :cond_69
    const/4 v11, -0x1

    move/from16 v0, p2

    if-ne v0, v11, :cond_8f

    .line 360
    const/4 v11, 0x1

    if-ne p1, v11, :cond_a7

    .line 361
    if-eqz p3, :cond_81

    .line 362
    const-string v11, "accountType"

    move-object/from16 v0, p3

    invoke-virtual {v0, v11}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 363
    .local v4, accountType:Ljava/lang/String;
    if-eqz v4, :cond_81

    .line 364
    invoke-virtual {p0, v4}, Landroid/accounts/ChooseTypeAndAccountActivity;->runAddAccountForAuthenticator(Ljava/lang/String;)V

    goto :goto_66

    .line 368
    .end local v4           #accountType:Ljava/lang/String;
    :cond_81
    const-string v11, "AccountChooser"

    const-string v12, "ChooseTypeAndAccountActivity.onActivityResult: unable to find account type, pretending the request was canceled"

    invoke-static {v11, v12}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 399
    :cond_88
    const-string v11, "AccountChooser"

    const-string v12, "ChooseTypeAndAccountActivity.onActivityResult: unable to find added account, pretending the request was canceled"

    invoke-static {v11, v12}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 402
    :cond_8f
    const-string v11, "AccountChooser"

    const/4 v12, 0x2

    invoke-static {v11, v12}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v11

    if-eqz v11, :cond_9f

    .line 403
    const-string v11, "AccountChooser"

    const-string v12, "ChooseTypeAndAccountActivity.onActivityResult: canceled"

    invoke-static {v11, v12}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 405
    :cond_9f
    const/4 v11, 0x0

    invoke-virtual {p0, v11}, Landroid/accounts/ChooseTypeAndAccountActivity;->setResult(I)V

    .line 406
    invoke-virtual {p0}, Landroid/accounts/ChooseTypeAndAccountActivity;->finish()V

    goto :goto_66

    .line 370
    :cond_a7
    const/4 v11, 0x2

    if-ne p1, v11, :cond_88

    .line 371
    const/4 v2, 0x0

    .line 372
    .local v2, accountName:Ljava/lang/String;
    const/4 v4, 0x0

    .line 374
    .restart local v4       #accountType:Ljava/lang/String;
    if-eqz p3, :cond_be

    .line 375
    const-string v11, "authAccount"

    move-object/from16 v0, p3

    invoke-virtual {v0, v11}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 376
    const-string v11, "accountType"

    move-object/from16 v0, p3

    invoke-virtual {v0, v11}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 379
    :cond_be
    if-eqz v2, :cond_c2

    if-nez v4, :cond_f0

    .line 380
    :cond_c2
    invoke-static {p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v11

    invoke-virtual {v11}, Landroid/accounts/AccountManager;->getAccounts()[Landroid/accounts/Account;

    move-result-object v6

    .line 381
    .local v6, currentAccounts:[Landroid/accounts/Account;
    new-instance v10, Ljava/util/HashSet;

    invoke-direct {v10}, Ljava/util/HashSet;-><init>()V

    .line 382
    .local v10, preExistingAccounts:Ljava/util/Set;,"Ljava/util/Set<Landroid/accounts/Account;>;"
    iget-object v5, p0, Landroid/accounts/ChooseTypeAndAccountActivity;->mExistingAccounts:[Landroid/os/Parcelable;

    .local v5, arr$:[Landroid/os/Parcelable;
    array-length v9, v5

    .local v9, len$:I
    const/4 v8, 0x0

    .local v8, i$:I
    :goto_d3
    if-ge v8, v9, :cond_df

    aget-object v3, v5, v8

    .line 383
    .local v3, accountParcel:Landroid/os/Parcelable;
    check-cast v3, Landroid/accounts/Account;

    .end local v3           #accountParcel:Landroid/os/Parcelable;
    invoke-interface {v10, v3}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 382
    add-int/lit8 v8, v8, 0x1

    goto :goto_d3

    .line 385
    :cond_df
    move-object v5, v6

    .local v5, arr$:[Landroid/accounts/Account;
    array-length v9, v5

    const/4 v8, 0x0

    :goto_e2
    if-ge v8, v9, :cond_f0

    aget-object v1, v5, v8

    .line 386
    .local v1, account:Landroid/accounts/Account;
    invoke-interface {v10, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_f9

    .line 387
    iget-object v2, v1, Landroid/accounts/Account;->name:Ljava/lang/String;

    .line 388
    iget-object v4, v1, Landroid/accounts/Account;->type:Ljava/lang/String;

    .line 394
    .end local v1           #account:Landroid/accounts/Account;
    .end local v5           #arr$:[Landroid/accounts/Account;
    .end local v6           #currentAccounts:[Landroid/accounts/Account;
    .end local v8           #i$:I
    .end local v9           #len$:I
    .end local v10           #preExistingAccounts:Ljava/util/Set;,"Ljava/util/Set<Landroid/accounts/Account;>;"
    :cond_f0
    if-nez v2, :cond_f4

    if-eqz v4, :cond_88

    .line 395
    :cond_f4
    invoke-direct {p0, v2, v4}, Landroid/accounts/ChooseTypeAndAccountActivity;->setResultAndFinish(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_66

    .line 385
    .restart local v1       #account:Landroid/accounts/Account;
    .restart local v5       #arr$:[Landroid/accounts/Account;
    .restart local v6       #currentAccounts:[Landroid/accounts/Account;
    .restart local v8       #i$:I
    .restart local v9       #len$:I
    .restart local v10       #preExistingAccounts:Ljava/util/Set;,"Ljava/util/Set<Landroid/accounts/Account;>;"
    :cond_f9
    add-int/lit8 v8, v8, 0x1

    goto :goto_e2
.end method

.method public onCancelButtonClicked(Landroid/view/View;)V
    .registers 2
    .parameter "view"

    .prologue
    .line 321
    invoke-virtual {p0}, Landroid/accounts/ChooseTypeAndAccountActivity;->onBackPressed()V

    .line 322
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .registers 36
    .parameter "savedInstanceState"

    .prologue
    .line 116
    invoke-super/range {p0 .. p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 117
    const-string v31, "AccountChooser"

    const/16 v32, 0x2

    invoke-static/range {v31 .. v32}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v31

    if-eqz v31, :cond_2f

    .line 118
    const-string v31, "AccountChooser"

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "ChooseTypeAndAccountActivity.onCreate(savedInstanceState="

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    move-object/from16 v0, v32

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v33, ")"

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-static/range {v31 .. v32}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 123
    :cond_2f
    invoke-static/range {p0 .. p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v5

    .line 124
    .local v5, accountManager:Landroid/accounts/AccountManager;
    invoke-virtual/range {p0 .. p0}, Landroid/accounts/ChooseTypeAndAccountActivity;->getIntent()Landroid/content/Intent;

    move-result-object v16

    .line 126
    .local v16, intent:Landroid/content/Intent;
    const/16 v22, 0x0

    .line 127
    .local v22, selectedAccountName:Ljava/lang/String;
    const/16 v23, 0x0

    .line 129
    .local v23, selectedAddNewAccount:Z
    if-eqz p1, :cond_c0

    .line 130
    const-string/jumbo v31, "pendingRequest"

    move-object/from16 v0, p1

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v31

    move/from16 v0, v31

    move-object/from16 v1, p0

    iput v0, v1, Landroid/accounts/ChooseTypeAndAccountActivity;->mPendingRequest:I

    .line 131
    const-string v31, "existingAccounts"

    move-object/from16 v0, p1

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelableArray(Ljava/lang/String;)[Landroid/os/Parcelable;

    move-result-object v31

    move-object/from16 v0, v31

    move-object/from16 v1, p0

    iput-object v0, v1, Landroid/accounts/ChooseTypeAndAccountActivity;->mExistingAccounts:[Landroid/os/Parcelable;

    .line 135
    const-string/jumbo v31, "selectedAccountName"

    move-object/from16 v0, p1

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    .line 138
    const-string/jumbo v31, "selectedAddAccount"

    const/16 v32, 0x0

    move-object/from16 v0, p1

    move-object/from16 v1, v31

    move/from16 v2, v32

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v23

    .line 151
    :cond_78
    :goto_78
    const-string v31, "AccountChooser"

    const/16 v32, 0x2

    invoke-static/range {v31 .. v32}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v31

    if-eqz v31, :cond_9f

    .line 152
    const-string v31, "AccountChooser"

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v33, "selected account name is "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    move-object/from16 v0, v32

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-static/range {v31 .. v32}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 156
    :cond_9f
    new-instance v29, Ljava/util/HashMap;

    invoke-direct/range {v29 .. v29}, Ljava/util/HashMap;-><init>()V

    .line 158
    .local v29, typeToAuthDescription:Ljava/util/HashMap;,"Ljava/util/HashMap<Ljava/lang/String;Landroid/accounts/AuthenticatorDescription;>;"
    invoke-virtual {v5}, Landroid/accounts/AccountManager;->getAuthenticatorTypes()[Landroid/accounts/AuthenticatorDescription;

    move-result-object v9

    .local v9, arr$:[Landroid/accounts/AuthenticatorDescription;
    array-length v0, v9

    move/from16 v17, v0

    .local v17, len$:I
    const/4 v15, 0x0

    .local v15, i$:I
    :goto_ac
    move/from16 v0, v17

    if-ge v15, v0, :cond_e6

    aget-object v10, v9, v15

    .line 159
    .local v10, desc:Landroid/accounts/AuthenticatorDescription;
    iget-object v0, v10, Landroid/accounts/AuthenticatorDescription;->type:Ljava/lang/String;

    move-object/from16 v31, v0

    move-object/from16 v0, v29

    move-object/from16 v1, v31

    invoke-virtual {v0, v1, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 158
    add-int/lit8 v15, v15, 0x1

    goto :goto_ac

    .line 141
    .end local v9           #arr$:[Landroid/accounts/AuthenticatorDescription;
    .end local v10           #desc:Landroid/accounts/AuthenticatorDescription;
    .end local v15           #i$:I
    .end local v17           #len$:I
    .end local v29           #typeToAuthDescription:Ljava/util/HashMap;,"Ljava/util/HashMap<Ljava/lang/String;Landroid/accounts/AuthenticatorDescription;>;"
    :cond_c0
    const/16 v31, 0x0

    move/from16 v0, v31

    move-object/from16 v1, p0

    iput v0, v1, Landroid/accounts/ChooseTypeAndAccountActivity;->mPendingRequest:I

    .line 142
    const/16 v31, 0x0

    move-object/from16 v0, v31

    move-object/from16 v1, p0

    iput-object v0, v1, Landroid/accounts/ChooseTypeAndAccountActivity;->mExistingAccounts:[Landroid/os/Parcelable;

    .line 145
    const-string/jumbo v31, "selectedAccount"

    move-object/from16 v0, v16

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v21

    check-cast v21, Landroid/accounts/Account;

    .line 146
    .local v21, selectedAccount:Landroid/accounts/Account;
    if-eqz v21, :cond_78

    .line 147
    move-object/from16 v0, v21

    iget-object v0, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    move-object/from16 v22, v0

    goto :goto_78

    .line 163
    .end local v21           #selectedAccount:Landroid/accounts/Account;
    .restart local v9       #arr$:[Landroid/accounts/AuthenticatorDescription;
    .restart local v15       #i$:I
    .restart local v17       #len$:I
    .restart local v29       #typeToAuthDescription:Ljava/util/HashMap;,"Ljava/util/HashMap<Ljava/lang/String;Landroid/accounts/AuthenticatorDescription;>;"
    :cond_e6
    const/16 v24, 0x0

    .line 164
    .local v24, setOfAllowableAccounts:Ljava/util/Set;,"Ljava/util/Set<Landroid/accounts/Account;>;"
    const-string v31, "allowableAccounts"

    move-object/from16 v0, v16

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getParcelableArrayListExtra(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v30

    .line 166
    .local v30, validAccounts:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/os/Parcelable;>;"
    if-eqz v30, :cond_11b

    .line 167
    new-instance v24, Ljava/util/HashSet;

    .end local v24           #setOfAllowableAccounts:Ljava/util/Set;,"Ljava/util/Set<Landroid/accounts/Account;>;"
    invoke-virtual/range {v30 .. v30}, Ljava/util/ArrayList;->size()I

    move-result v31

    move-object/from16 v0, v24

    move/from16 v1, v31

    invoke-direct {v0, v1}, Ljava/util/HashSet;-><init>(I)V

    .line 168
    .restart local v24       #setOfAllowableAccounts:Ljava/util/Set;,"Ljava/util/Set<Landroid/accounts/Account;>;"
    invoke-virtual/range {v30 .. v30}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v15

    .local v15, i$:Ljava/util/Iterator;
    :goto_105
    invoke-interface {v15}, Ljava/util/Iterator;->hasNext()Z

    move-result v31

    if-eqz v31, :cond_11b

    invoke-interface {v15}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Landroid/os/Parcelable;

    .line 169
    .local v20, parcelable:Landroid/os/Parcelable;
    check-cast v20, Landroid/accounts/Account;

    .end local v20           #parcelable:Landroid/os/Parcelable;
    move-object/from16 v0, v24

    move-object/from16 v1, v20

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_105

    .line 175
    .end local v15           #i$:Ljava/util/Iterator;
    :cond_11b
    const/16 v26, 0x0

    .line 176
    .local v26, setOfRelevantAccountTypes:Ljava/util/Set;,"Ljava/util/Set<Ljava/lang/String;>;"
    const-string v31, "allowableAccountTypes"

    move-object/from16 v0, v16

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringArrayExtra(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v8

    .line 178
    .local v8, allowedAccountTypes:[Ljava/lang/String;
    if-eqz v8, :cond_1a1

    .line 180
    new-instance v26, Ljava/util/HashSet;

    .end local v26           #setOfRelevantAccountTypes:Ljava/util/Set;,"Ljava/util/Set<Ljava/lang/String;>;"
    array-length v0, v8

    move/from16 v31, v0

    move-object/from16 v0, v26

    move/from16 v1, v31

    invoke-direct {v0, v1}, Ljava/util/HashSet;-><init>(I)V

    .line 181
    .restart local v26       #setOfRelevantAccountTypes:Ljava/util/Set;,"Ljava/util/Set<Ljava/lang/String;>;"
    new-instance v25, Ljava/util/HashSet;

    array-length v0, v8

    move/from16 v31, v0

    move-object/from16 v0, v25

    move/from16 v1, v31

    invoke-direct {v0, v1}, Ljava/util/HashSet;-><init>(I)V

    .line 182
    .local v25, setOfAllowedAccountTypes:Ljava/util/Set;,"Ljava/util/Set<Ljava/lang/String;>;"
    move-object v9, v8

    .local v9, arr$:[Ljava/lang/String;
    array-length v0, v9

    move/from16 v17, v0

    const/4 v15, 0x0

    .local v15, i$:I
    :goto_146
    move/from16 v0, v17

    if-ge v15, v0, :cond_156

    aget-object v28, v9, v15

    .line 183
    .local v28, type:Ljava/lang/String;
    move-object/from16 v0, v25

    move-object/from16 v1, v28

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 182
    add-int/lit8 v15, v15, 0x1

    goto :goto_146

    .line 186
    .end local v28           #type:Ljava/lang/String;
    :cond_156
    invoke-static/range {p0 .. p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v31

    invoke-virtual/range {v31 .. v31}, Landroid/accounts/AccountManager;->getAuthenticatorTypes()[Landroid/accounts/AuthenticatorDescription;

    move-result-object v13

    .line 187
    .local v13, descs:[Landroid/accounts/AuthenticatorDescription;
    new-instance v27, Ljava/util/HashSet;

    array-length v0, v13

    move/from16 v31, v0

    move-object/from16 v0, v27

    move/from16 v1, v31

    invoke-direct {v0, v1}, Ljava/util/HashSet;-><init>(I)V

    .line 188
    .local v27, supportedAccountTypes:Ljava/util/Set;,"Ljava/util/Set<Ljava/lang/String;>;"
    move-object v9, v13

    .local v9, arr$:[Landroid/accounts/AuthenticatorDescription;
    array-length v0, v9

    move/from16 v17, v0

    const/4 v15, 0x0

    :goto_16f
    move/from16 v0, v17

    if-ge v15, v0, :cond_183

    aget-object v10, v9, v15

    .line 189
    .restart local v10       #desc:Landroid/accounts/AuthenticatorDescription;
    iget-object v0, v10, Landroid/accounts/AuthenticatorDescription;->type:Ljava/lang/String;

    move-object/from16 v31, v0

    move-object/from16 v0, v27

    move-object/from16 v1, v31

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 188
    add-int/lit8 v15, v15, 0x1

    goto :goto_16f

    .line 192
    .end local v10           #desc:Landroid/accounts/AuthenticatorDescription;
    :cond_183
    invoke-interface/range {v25 .. v25}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v15

    .local v15, i$:Ljava/util/Iterator;
    :cond_187
    :goto_187
    invoke-interface {v15}, Ljava/util/Iterator;->hasNext()Z

    move-result v31

    if-eqz v31, :cond_1a1

    invoke-interface {v15}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    .line 193
    .local v7, acctType:Ljava/lang/String;
    move-object/from16 v0, v27

    invoke-interface {v0, v7}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v31

    if-eqz v31, :cond_187

    .line 194
    move-object/from16 v0, v26

    invoke-interface {v0, v7}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_187

    .line 202
    .end local v7           #acctType:Ljava/lang/String;
    .end local v13           #descs:[Landroid/accounts/AuthenticatorDescription;
    .end local v15           #i$:Ljava/util/Iterator;
    .end local v25           #setOfAllowedAccountTypes:Ljava/util/Set;,"Ljava/util/Set<Ljava/lang/String;>;"
    .end local v27           #supportedAccountTypes:Ljava/util/Set;,"Ljava/util/Set<Ljava/lang/String;>;"
    :cond_1a1
    invoke-virtual {v5}, Landroid/accounts/AccountManager;->getAccounts()[Landroid/accounts/Account;

    move-result-object v6

    .line 203
    .local v6, accounts:[Landroid/accounts/Account;
    new-instance v31, Ljava/util/ArrayList;

    array-length v0, v6

    move/from16 v32, v0

    invoke-direct/range {v31 .. v32}, Ljava/util/ArrayList;-><init>(I)V

    move-object/from16 v0, v31

    move-object/from16 v1, p0

    iput-object v0, v1, Landroid/accounts/ChooseTypeAndAccountActivity;->mAccounts:Ljava/util/ArrayList;

    .line 204
    const/16 v31, -0x1

    move/from16 v0, v31

    move-object/from16 v1, p0

    iput v0, v1, Landroid/accounts/ChooseTypeAndAccountActivity;->mSelectedItemIndex:I

    .line 205
    move-object v9, v6

    .local v9, arr$:[Landroid/accounts/Account;
    array-length v0, v9

    move/from16 v17, v0

    const/4 v15, 0x0

    .local v15, i$:I
    :goto_1c0
    move/from16 v0, v17

    if-ge v15, v0, :cond_20d

    aget-object v4, v9, v15

    .line 206
    .local v4, account:Landroid/accounts/Account;
    if-eqz v24, :cond_1d3

    move-object/from16 v0, v24

    invoke-interface {v0, v4}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v31

    if-nez v31, :cond_1d3

    .line 205
    :cond_1d0
    :goto_1d0
    add-int/lit8 v15, v15, 0x1

    goto :goto_1c0

    .line 210
    :cond_1d3
    if-eqz v26, :cond_1e3

    iget-object v0, v4, Landroid/accounts/Account;->type:Ljava/lang/String;

    move-object/from16 v31, v0

    move-object/from16 v0, v26

    move-object/from16 v1, v31

    invoke-interface {v0, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v31

    if-eqz v31, :cond_1d0

    .line 214
    :cond_1e3
    iget-object v0, v4, Landroid/accounts/Account;->name:Ljava/lang/String;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v31

    if-eqz v31, :cond_201

    .line 215
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/accounts/ChooseTypeAndAccountActivity;->mAccounts:Ljava/util/ArrayList;

    move-object/from16 v31, v0

    invoke-virtual/range {v31 .. v31}, Ljava/util/ArrayList;->size()I

    move-result v31

    move/from16 v0, v31

    move-object/from16 v1, p0

    iput v0, v1, Landroid/accounts/ChooseTypeAndAccountActivity;->mSelectedItemIndex:I

    .line 217
    :cond_201
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/accounts/ChooseTypeAndAccountActivity;->mAccounts:Ljava/util/ArrayList;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1d0

    .line 220
    .end local v4           #account:Landroid/accounts/Account;
    :cond_20d
    move-object/from16 v0, p0

    iget v0, v0, Landroid/accounts/ChooseTypeAndAccountActivity;->mPendingRequest:I

    move/from16 v31, v0

    if-nez v31, :cond_285

    .line 223
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/accounts/ChooseTypeAndAccountActivity;->mAccounts:Ljava/util/ArrayList;

    move-object/from16 v31, v0

    invoke-virtual/range {v31 .. v31}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v31

    if-eqz v31, :cond_243

    .line 224
    invoke-interface/range {v26 .. v26}, Ljava/util/Set;->size()I

    move-result v31

    const/16 v32, 0x1

    move/from16 v0, v31

    move/from16 v1, v32

    if-ne v0, v1, :cond_23f

    .line 225
    invoke-interface/range {v26 .. v26}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v31

    invoke-interface/range {v31 .. v31}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v31

    check-cast v31, Ljava/lang/String;

    move-object/from16 v0, p0

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/accounts/ChooseTypeAndAccountActivity;->runAddAccountForAuthenticator(Ljava/lang/String;)V

    .line 292
    :goto_23e
    return-void

    .line 227
    :cond_23f
    invoke-direct/range {p0 .. p0}, Landroid/accounts/ChooseTypeAndAccountActivity;->startChooseAccountTypeActivity()V

    goto :goto_23e

    .line 233
    :cond_243
    const-string v31, "alwaysPromptForAccount"

    const/16 v32, 0x0

    move-object/from16 v0, v16

    move-object/from16 v1, v31

    move/from16 v2, v32

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v31

    if-nez v31, :cond_285

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/accounts/ChooseTypeAndAccountActivity;->mAccounts:Ljava/util/ArrayList;

    move-object/from16 v31, v0

    invoke-virtual/range {v31 .. v31}, Ljava/util/ArrayList;->size()I

    move-result v31

    const/16 v32, 0x1

    move/from16 v0, v31

    move/from16 v1, v32

    if-ne v0, v1, :cond_285

    .line 235
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/accounts/ChooseTypeAndAccountActivity;->mAccounts:Ljava/util/ArrayList;

    move-object/from16 v31, v0

    const/16 v32, 0x0

    invoke-virtual/range {v31 .. v32}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/accounts/Account;

    .line 236
    .restart local v4       #account:Landroid/accounts/Account;
    iget-object v0, v4, Landroid/accounts/Account;->name:Ljava/lang/String;

    move-object/from16 v31, v0

    iget-object v0, v4, Landroid/accounts/Account;->type:Ljava/lang/String;

    move-object/from16 v32, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v31

    move-object/from16 v2, v32

    invoke-direct {v0, v1, v2}, Landroid/accounts/ChooseTypeAndAccountActivity;->setResultAndFinish(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_23e

    .line 243
    .end local v4           #account:Landroid/accounts/Account;
    :cond_285
    const v31, 0x1090034

    move-object/from16 v0, p0

    move/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/accounts/ChooseTypeAndAccountActivity;->setContentView(I)V

    .line 246
    const-string v31, "descriptionTextOverride"

    move-object/from16 v0, v16

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 248
    .local v11, descriptionOverride:Ljava/lang/String;
    const v31, 0x102026c

    move-object/from16 v0, p0

    move/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/accounts/ChooseTypeAndAccountActivity;->findViewById(I)Landroid/view/View;

    move-result-object v12

    check-cast v12, Landroid/widget/TextView;

    .line 249
    .local v12, descriptionView:Landroid/widget/TextView;
    invoke-static {v11}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v31

    if-nez v31, :cond_2e9

    .line 250
    invoke-virtual {v12, v11}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 257
    :goto_2af
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/accounts/ChooseTypeAndAccountActivity;->mAccounts:Ljava/util/ArrayList;

    move-object/from16 v31, v0

    invoke-virtual/range {v31 .. v31}, Ljava/util/ArrayList;->size()I

    move-result v31

    add-int/lit8 v31, v31, 0x1

    move/from16 v0, v31

    new-array v0, v0, [Ljava/lang/String;

    move-object/from16 v19, v0

    .line 258
    .local v19, listItems:[Ljava/lang/String;
    const/4 v14, 0x0

    .local v14, i:I
    :goto_2c2
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/accounts/ChooseTypeAndAccountActivity;->mAccounts:Ljava/util/ArrayList;

    move-object/from16 v31, v0

    invoke-virtual/range {v31 .. v31}, Ljava/util/ArrayList;->size()I

    move-result v31

    move/from16 v0, v31

    if-ge v14, v0, :cond_2f1

    .line 259
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/accounts/ChooseTypeAndAccountActivity;->mAccounts:Ljava/util/ArrayList;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    invoke-virtual {v0, v14}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v31

    check-cast v31, Landroid/accounts/Account;

    move-object/from16 v0, v31

    iget-object v0, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    move-object/from16 v31, v0

    aput-object v31, v19, v14

    .line 258
    add-int/lit8 v14, v14, 0x1

    goto :goto_2c2

    .line 252
    .end local v14           #i:I
    .end local v19           #listItems:[Ljava/lang/String;
    :cond_2e9
    const/16 v31, 0x8

    move/from16 v0, v31

    invoke-virtual {v12, v0}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_2af

    .line 261
    .restart local v14       #i:I
    .restart local v19       #listItems:[Ljava/lang/String;
    :cond_2f1
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/accounts/ChooseTypeAndAccountActivity;->mAccounts:Ljava/util/ArrayList;

    move-object/from16 v31, v0

    invoke-virtual/range {v31 .. v31}, Ljava/util/ArrayList;->size()I

    move-result v31

    invoke-virtual/range {p0 .. p0}, Landroid/accounts/ChooseTypeAndAccountActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v32

    const v33, 0x10404a8

    invoke-virtual/range {v32 .. v33}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v32

    aput-object v32, v19, v31

    .line 264
    const v31, 0x102000a

    move-object/from16 v0, p0

    move/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/accounts/ChooseTypeAndAccountActivity;->findViewById(I)Landroid/view/View;

    move-result-object v18

    check-cast v18, Landroid/widget/ListView;

    .line 265
    .local v18, list:Landroid/widget/ListView;
    new-instance v31, Landroid/widget/ArrayAdapter;

    const v32, 0x109000f

    move-object/from16 v0, v31

    move-object/from16 v1, p0

    move/from16 v2, v32

    move-object/from16 v3, v19

    invoke-direct {v0, v1, v2, v3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;I[Ljava/lang/Object;)V

    move-object/from16 v0, v18

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 267
    const/16 v31, 0x1

    move-object/from16 v0, v18

    move/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setChoiceMode(I)V

    .line 268
    const/16 v31, 0x0

    move-object/from16 v0, v18

    move/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setItemsCanFocus(Z)V

    .line 269
    new-instance v31, Landroid/accounts/ChooseTypeAndAccountActivity$1;

    move-object/from16 v0, v31

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Landroid/accounts/ChooseTypeAndAccountActivity$1;-><init>(Landroid/accounts/ChooseTypeAndAccountActivity;)V

    move-object/from16 v0, v18

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 279
    if-eqz v23, :cond_360

    .line 280
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/accounts/ChooseTypeAndAccountActivity;->mAccounts:Ljava/util/ArrayList;

    move-object/from16 v31, v0

    invoke-virtual/range {v31 .. v31}, Ljava/util/ArrayList;->size()I

    move-result v31

    move/from16 v0, v31

    move-object/from16 v1, p0

    iput v0, v1, Landroid/accounts/ChooseTypeAndAccountActivity;->mSelectedItemIndex:I

    .line 282
    :cond_360
    move-object/from16 v0, p0

    iget v0, v0, Landroid/accounts/ChooseTypeAndAccountActivity;->mSelectedItemIndex:I

    move/from16 v31, v0

    const/16 v32, -0x1

    move/from16 v0, v31

    move/from16 v1, v32

    if-eq v0, v1, :cond_3ad

    .line 283
    move-object/from16 v0, p0

    iget v0, v0, Landroid/accounts/ChooseTypeAndAccountActivity;->mSelectedItemIndex:I

    move/from16 v31, v0

    const/16 v32, 0x1

    move-object/from16 v0, v18

    move/from16 v1, v31

    move/from16 v2, v32

    invoke-virtual {v0, v1, v2}, Landroid/widget/ListView;->setItemChecked(IZ)V

    .line 284
    const-string v31, "AccountChooser"

    const/16 v32, 0x2

    invoke-static/range {v31 .. v32}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v31

    if-eqz v31, :cond_3ad

    .line 285
    const-string v31, "AccountChooser"

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "List item "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    move-object/from16 v0, p0

    iget v0, v0, Landroid/accounts/ChooseTypeAndAccountActivity;->mSelectedItemIndex:I

    move/from16 v33, v0

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v33, " should be selected"

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-static/range {v31 .. v32}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 290
    :cond_3ad
    const v31, 0x102001a

    move-object/from16 v0, p0

    move/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/accounts/ChooseTypeAndAccountActivity;->findViewById(I)Landroid/view/View;

    move-result-object v31

    check-cast v31, Landroid/widget/Button;

    move-object/from16 v0, v31

    move-object/from16 v1, p0

    iput-object v0, v1, Landroid/accounts/ChooseTypeAndAccountActivity;->mOkButton:Landroid/widget/Button;

    .line 291
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/accounts/ChooseTypeAndAccountActivity;->mOkButton:Landroid/widget/Button;

    move-object/from16 v32, v0

    move-object/from16 v0, p0

    iget v0, v0, Landroid/accounts/ChooseTypeAndAccountActivity;->mSelectedItemIndex:I

    move/from16 v31, v0

    const/16 v33, -0x1

    move/from16 v0, v31

    move/from16 v1, v33

    if-eq v0, v1, :cond_3df

    const/16 v31, 0x1

    :goto_3d6
    move-object/from16 v0, v32

    move/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setEnabled(Z)V

    goto/16 :goto_23e

    :cond_3df
    const/16 v31, 0x0

    goto :goto_3d6
.end method

.method protected onDestroy()V
    .registers 3

    .prologue
    .line 296
    const-string v0, "AccountChooser"

    const/4 v1, 0x2

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_10

    .line 297
    const-string v0, "AccountChooser"

    const-string v1, "ChooseTypeAndAccountActivity.onDestroy()"

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 299
    :cond_10
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 300
    return-void
.end method

.method public onOkButtonClicked(Landroid/view/View;)V
    .registers 4
    .parameter "view"

    .prologue
    .line 325
    iget v0, p0, Landroid/accounts/ChooseTypeAndAccountActivity;->mSelectedItemIndex:I

    iget-object v1, p0, Landroid/accounts/ChooseTypeAndAccountActivity;->mAccounts:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ne v0, v1, :cond_e

    .line 327
    invoke-direct {p0}, Landroid/accounts/ChooseTypeAndAccountActivity;->startChooseAccountTypeActivity()V

    .line 331
    :cond_d
    :goto_d
    return-void

    .line 328
    :cond_e
    iget v0, p0, Landroid/accounts/ChooseTypeAndAccountActivity;->mSelectedItemIndex:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_d

    .line 329
    iget-object v0, p0, Landroid/accounts/ChooseTypeAndAccountActivity;->mAccounts:Ljava/util/ArrayList;

    iget v1, p0, Landroid/accounts/ChooseTypeAndAccountActivity;->mSelectedItemIndex:I

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/accounts/Account;

    invoke-direct {p0, v0}, Landroid/accounts/ChooseTypeAndAccountActivity;->onAccountSelected(Landroid/accounts/Account;)V

    goto :goto_d
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .registers 5
    .parameter "outState"

    .prologue
    .line 304
    invoke-super {p0, p1}, Landroid/app/Activity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 305
    const-string/jumbo v0, "pendingRequest"

    iget v1, p0, Landroid/accounts/ChooseTypeAndAccountActivity;->mPendingRequest:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 306
    iget v0, p0, Landroid/accounts/ChooseTypeAndAccountActivity;->mPendingRequest:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_17

    .line 307
    const-string v0, "existingAccounts"

    iget-object v1, p0, Landroid/accounts/ChooseTypeAndAccountActivity;->mExistingAccounts:[Landroid/os/Parcelable;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelableArray(Ljava/lang/String;[Landroid/os/Parcelable;)V

    .line 309
    :cond_17
    iget v0, p0, Landroid/accounts/ChooseTypeAndAccountActivity;->mSelectedItemIndex:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_2d

    .line 310
    iget v0, p0, Landroid/accounts/ChooseTypeAndAccountActivity;->mSelectedItemIndex:I

    iget-object v1, p0, Landroid/accounts/ChooseTypeAndAccountActivity;->mAccounts:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ne v0, v1, :cond_2e

    .line 311
    const-string/jumbo v0, "selectedAddAccount"

    const/4 v1, 0x1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 318
    :cond_2d
    :goto_2d
    return-void

    .line 313
    :cond_2e
    const-string/jumbo v0, "selectedAddAccount"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 314
    const-string/jumbo v1, "selectedAccountName"

    iget-object v0, p0, Landroid/accounts/ChooseTypeAndAccountActivity;->mAccounts:Ljava/util/ArrayList;

    iget v2, p0, Landroid/accounts/ChooseTypeAndAccountActivity;->mSelectedItemIndex:I

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/accounts/Account;

    iget-object v0, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2d
.end method

.method public run(Landroid/accounts/AccountManagerFuture;)V
    .registers 8
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/accounts/AccountManagerFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 426
    .local p1, accountManagerFuture:Landroid/accounts/AccountManagerFuture;,"Landroid/accounts/AccountManagerFuture<Landroid/os/Bundle;>;"
    :try_start_0
    invoke-interface {p1}, Landroid/accounts/AccountManagerFuture;->getResult()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/Bundle;

    .line 427
    .local v0, accountManagerResult:Landroid/os/Bundle;
    const-string v4, "intent"

    invoke-virtual {v0, v4}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v3

    check-cast v3, Landroid/content/Intent;

    .line 429
    .local v3, intent:Landroid/content/Intent;
    if-eqz v3, :cond_37

    .line 430
    const/4 v4, 0x2

    iput v4, p0, Landroid/accounts/ChooseTypeAndAccountActivity;->mPendingRequest:I

    .line 431
    invoke-static {p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v4

    invoke-virtual {v4}, Landroid/accounts/AccountManager;->getAccounts()[Landroid/accounts/Account;

    move-result-object v4

    iput-object v4, p0, Landroid/accounts/ChooseTypeAndAccountActivity;->mExistingAccounts:[Landroid/os/Parcelable;

    .line 432
    invoke-virtual {v3}, Landroid/content/Intent;->getFlags()I

    move-result v4

    const v5, -0x10000001

    and-int/2addr v4, v5

    invoke-virtual {v3, v4}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 433
    const/4 v4, 0x2

    invoke-virtual {p0, v3, v4}, Landroid/accounts/ChooseTypeAndAccountActivity;->startActivityForResult(Landroid/content/Intent;I)V
    :try_end_2c
    .catch Landroid/accounts/OperationCanceledException; {:try_start_0 .. :try_end_2c} :catch_2d
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_2c} :catch_54
    .catch Landroid/accounts/AuthenticatorException; {:try_start_0 .. :try_end_2c} :catch_36

    .line 447
    .end local v0           #accountManagerResult:Landroid/os/Bundle;
    .end local v3           #intent:Landroid/content/Intent;
    :goto_2c
    return-void

    .line 436
    :catch_2d
    move-exception v2

    .line 437
    .local v2, e:Landroid/accounts/OperationCanceledException;
    const/4 v4, 0x0

    invoke-virtual {p0, v4}, Landroid/accounts/ChooseTypeAndAccountActivity;->setResult(I)V

    .line 438
    invoke-virtual {p0}, Landroid/accounts/ChooseTypeAndAccountActivity;->finish()V

    goto :goto_2c

    .line 441
    .end local v2           #e:Landroid/accounts/OperationCanceledException;
    :catch_36
    move-exception v4

    .line 443
    :cond_37
    :goto_37
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 444
    .local v1, bundle:Landroid/os/Bundle;
    const-string v4, "errorMessage"

    const-string v5, "error communicating with server"

    invoke-virtual {v1, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 445
    const/4 v4, -0x1

    new-instance v5, Landroid/content/Intent;

    invoke-direct {v5}, Landroid/content/Intent;-><init>()V

    invoke-virtual {v5, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    move-result-object v5

    invoke-virtual {p0, v4, v5}, Landroid/accounts/ChooseTypeAndAccountActivity;->setResult(ILandroid/content/Intent;)V

    .line 446
    invoke-virtual {p0}, Landroid/accounts/ChooseTypeAndAccountActivity;->finish()V

    goto :goto_2c

    .line 440
    .end local v1           #bundle:Landroid/os/Bundle;
    :catch_54
    move-exception v4

    goto :goto_37
.end method

.method protected runAddAccountForAuthenticator(Ljava/lang/String;)V
    .registers 10
    .parameter "type"

    .prologue
    const/4 v5, 0x0

    .line 410
    const-string v0, "AccountChooser"

    const/4 v1, 0x2

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_23

    .line 411
    const-string v0, "AccountChooser"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "runAddAccountForAuthenticator: "

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 413
    :cond_23
    invoke-virtual {p0}, Landroid/accounts/ChooseTypeAndAccountActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "addAccountOptions"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v4

    .line 415
    .local v4, options:Landroid/os/Bundle;
    invoke-virtual {p0}, Landroid/accounts/ChooseTypeAndAccountActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "addAccountRequiredFeatures"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringArrayExtra(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 417
    .local v3, requiredFeatures:[Ljava/lang/String;
    invoke-virtual {p0}, Landroid/accounts/ChooseTypeAndAccountActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "authTokenType"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 419
    .local v2, authTokenType:Ljava/lang/String;
    invoke-static {p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v0

    move-object v1, p1

    move-object v6, p0

    move-object v7, v5

    invoke-virtual/range {v0 .. v7}, Landroid/accounts/AccountManager;->addAccount(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/os/Bundle;Landroid/app/Activity;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;

    .line 421
    return-void
.end method
