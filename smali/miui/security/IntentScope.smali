.class public Lmiui/security/IntentScope;
.super Ljava/lang/Object;
.source "IntentScope.java"


# static fields
.field public static final PACKAGE_NAME_PHONE:Ljava/lang/String; = "com.android.phone"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static processIntentScope(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)Landroid/content/Intent;
    .registers 3
    .parameter "context"
    .parameter "intent"
    .parameter "packageName"

    .prologue
    if-eqz p1, :cond_5

    invoke-virtual {p1, p2}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    :cond_5
    return-object p1
.end method
