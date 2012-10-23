.class public Lcom/android/internal/app/ChooserActivity;
.super Lcom/android/internal/app/ResolverActivity;
.source "ChooserActivity.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 24
    invoke-direct {p0}, Lcom/android/internal/app/ResolverActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .registers 13
    .parameter "savedInstanceState"

    .prologue
    .line 27
    invoke-virtual {p0}, Lcom/android/internal/app/ChooserActivity;->getIntent()Landroid/content/Intent;

    move-result-object v8

    .line 28
    .local v8, intent:Landroid/content/Intent;
    const-string v0, "android.intent.extra.INTENT"

    invoke-virtual {v8, v0}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v10

    .line 29
    .local v10, targetParcelable:Landroid/os/Parcelable;
    instance-of v0, v10, Landroid/content/Intent;

    if-nez v0, :cond_2a

    .line 30
    const-string v0, "ChooseActivity"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Target is not an intent: "

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 31
    invoke-virtual {p0}, Lcom/android/internal/app/ChooserActivity;->finish()V

    .line 54
    :goto_29
    return-void

    :cond_2a
    move-object v2, v10

    .line 34
    check-cast v2, Landroid/content/Intent;

    .line 35
    .local v2, target:Landroid/content/Intent;
    const-string v0, "android.intent.extra.TITLE"

    invoke-virtual {v8, v0}, Landroid/content/Intent;->getCharSequenceExtra(Ljava/lang/String;)Ljava/lang/CharSequence;

    move-result-object v3

    .line 36
    .local v3, title:Ljava/lang/CharSequence;
    if-nez v3, :cond_40

    .line 37
    invoke-virtual {p0}, Lcom/android/internal/app/ChooserActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x10403cc

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getText(I)Ljava/lang/CharSequence;

    move-result-object v3

    .line 39
    :cond_40
    const-string v0, "android.intent.extra.INITIAL_INTENTS"

    invoke-virtual {v8, v0}, Landroid/content/Intent;->getParcelableArrayExtra(Ljava/lang/String;)[Landroid/os/Parcelable;

    move-result-object v9

    .line 40
    .local v9, pa:[Landroid/os/Parcelable;
    const/4 v4, 0x0

    .line 41
    .local v4, initialIntents:[Landroid/content/Intent;
    if-eqz v9, :cond_87

    .line 42
    array-length v0, v9

    new-array v4, v0, [Landroid/content/Intent;

    .line 43
    const/4 v7, 0x0

    .local v7, i:I
    :goto_4d
    array-length v0, v9

    if-ge v7, v0, :cond_87

    .line 44
    aget-object v0, v9, v7

    instance-of v0, v0, Landroid/content/Intent;

    if-nez v0, :cond_7e

    .line 45
    const-string v0, "ChooseActivity"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Initial intent #"

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v5, " not an Intent: "

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    aget-object v5, v9, v7

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 47
    invoke-virtual {p0}, Lcom/android/internal/app/ChooserActivity;->finish()V

    goto :goto_29

    .line 50
    :cond_7e
    aget-object v0, v9, v7

    check-cast v0, Landroid/content/Intent;

    aput-object v0, v4, v7

    .line 43
    add-int/lit8 v7, v7, 0x1

    goto :goto_4d

    .line 53
    .end local v7           #i:I
    :cond_87
    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    invoke-super/range {v0 .. v6}, Lcom/android/internal/app/ResolverActivity;->onCreate(Landroid/os/Bundle;Landroid/content/Intent;Ljava/lang/CharSequence;[Landroid/content/Intent;Ljava/util/List;Z)V

    goto :goto_29
.end method
