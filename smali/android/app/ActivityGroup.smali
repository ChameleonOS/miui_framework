.class public Landroid/app/ActivityGroup;
.super Landroid/app/Activity;
.source "ActivityGroup.java"


# annotations
.annotation runtime Ljava/lang/Deprecated;
.end annotation


# static fields
.field static final PARENT_NON_CONFIG_INSTANCE_KEY:Ljava/lang/String; = "android:parent_non_config_instance"

.field private static final STATES_KEY:Ljava/lang/String; = "android:states"


# instance fields
.field protected mLocalActivityManager:Landroid/app/LocalActivityManager;


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 43
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Landroid/app/ActivityGroup;-><init>(Z)V

    .line 44
    return-void
.end method

.method public constructor <init>(Z)V
    .registers 3
    .parameter "singleActivityMode"

    .prologue
    .line 46
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 47
    new-instance v0, Landroid/app/LocalActivityManager;

    invoke-direct {v0, p0, p1}, Landroid/app/LocalActivityManager;-><init>(Landroid/app/Activity;Z)V

    iput-object v0, p0, Landroid/app/ActivityGroup;->mLocalActivityManager:Landroid/app/LocalActivityManager;

    .line 48
    return-void
.end method


# virtual methods
.method dispatchActivityResult(Ljava/lang/String;IILandroid/content/Intent;)V
    .registers 7
    .parameter "who"
    .parameter "requestCode"
    .parameter "resultCode"
    .parameter "data"

    .prologue
    .line 113
    if-eqz p1, :cond_e

    .line 114
    iget-object v1, p0, Landroid/app/ActivityGroup;->mLocalActivityManager:Landroid/app/LocalActivityManager;

    invoke-virtual {v1, p1}, Landroid/app/LocalActivityManager;->getActivity(Ljava/lang/String;)Landroid/app/Activity;

    move-result-object v0

    .line 121
    .local v0, act:Landroid/app/Activity;
    if-eqz v0, :cond_e

    .line 122
    invoke-virtual {v0, p2, p3, p4}, Landroid/app/Activity;->onActivityResult(IILandroid/content/Intent;)V

    .line 127
    .end local v0           #act:Landroid/app/Activity;
    :goto_d
    return-void

    .line 126
    :cond_e
    invoke-super {p0, p1, p2, p3, p4}, Landroid/app/Activity;->dispatchActivityResult(Ljava/lang/String;IILandroid/content/Intent;)V

    goto :goto_d
.end method

.method public getCurrentActivity()Landroid/app/Activity;
    .registers 2

    .prologue
    .line 103
    iget-object v0, p0, Landroid/app/ActivityGroup;->mLocalActivityManager:Landroid/app/LocalActivityManager;

    invoke-virtual {v0}, Landroid/app/LocalActivityManager;->getCurrentActivity()Landroid/app/Activity;

    move-result-object v0

    return-object v0
.end method

.method public final getLocalActivityManager()Landroid/app/LocalActivityManager;
    .registers 2

    .prologue
    .line 107
    iget-object v0, p0, Landroid/app/ActivityGroup;->mLocalActivityManager:Landroid/app/LocalActivityManager;

    return-object v0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .registers 4
    .parameter "savedInstanceState"

    .prologue
    .line 52
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 53
    if-eqz p1, :cond_11

    const-string v1, "android:states"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 55
    .local v0, states:Landroid/os/Bundle;
    :goto_b
    iget-object v1, p0, Landroid/app/ActivityGroup;->mLocalActivityManager:Landroid/app/LocalActivityManager;

    invoke-virtual {v1, v0}, Landroid/app/LocalActivityManager;->dispatchCreate(Landroid/os/Bundle;)V

    .line 56
    return-void

    .line 53
    .end local v0           #states:Landroid/os/Bundle;
    :cond_11
    const/4 v0, 0x0

    goto :goto_b
.end method

.method protected onDestroy()V
    .registers 3

    .prologue
    .line 87
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 88
    iget-object v0, p0, Landroid/app/ActivityGroup;->mLocalActivityManager:Landroid/app/LocalActivityManager;

    invoke-virtual {p0}, Landroid/app/ActivityGroup;->isFinishing()Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/app/LocalActivityManager;->dispatchDestroy(Z)V

    .line 89
    return-void
.end method

.method protected onPause()V
    .registers 3

    .prologue
    .line 75
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 76
    iget-object v0, p0, Landroid/app/ActivityGroup;->mLocalActivityManager:Landroid/app/LocalActivityManager;

    invoke-virtual {p0}, Landroid/app/ActivityGroup;->isFinishing()Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/app/LocalActivityManager;->dispatchPause(Z)V

    .line 77
    return-void
.end method

.method protected onResume()V
    .registers 2

    .prologue
    .line 60
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 61
    iget-object v0, p0, Landroid/app/ActivityGroup;->mLocalActivityManager:Landroid/app/LocalActivityManager;

    invoke-virtual {v0}, Landroid/app/LocalActivityManager;->dispatchResume()V

    .line 62
    return-void
.end method

.method public onRetainNonConfigurationChildInstances()Ljava/util/HashMap;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 99
    iget-object v0, p0, Landroid/app/ActivityGroup;->mLocalActivityManager:Landroid/app/LocalActivityManager;

    invoke-virtual {v0}, Landroid/app/LocalActivityManager;->dispatchRetainNonConfigurationInstance()Ljava/util/HashMap;

    move-result-object v0

    return-object v0
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .registers 4
    .parameter "outState"

    .prologue
    .line 66
    invoke-super {p0, p1}, Landroid/app/Activity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 67
    iget-object v1, p0, Landroid/app/ActivityGroup;->mLocalActivityManager:Landroid/app/LocalActivityManager;

    invoke-virtual {v1}, Landroid/app/LocalActivityManager;->saveInstanceState()Landroid/os/Bundle;

    move-result-object v0

    .line 68
    .local v0, state:Landroid/os/Bundle;
    if-eqz v0, :cond_10

    .line 69
    const-string v1, "android:states"

    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 71
    :cond_10
    return-void
.end method

.method protected onStop()V
    .registers 2

    .prologue
    .line 81
    invoke-super {p0}, Landroid/app/Activity;->onStop()V

    .line 82
    iget-object v0, p0, Landroid/app/ActivityGroup;->mLocalActivityManager:Landroid/app/LocalActivityManager;

    invoke-virtual {v0}, Landroid/app/LocalActivityManager;->dispatchStop()V

    .line 83
    return-void
.end method
