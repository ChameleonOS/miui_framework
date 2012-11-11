.class Landroid/telephony/TelephonyManager$Injector;
.super Ljava/lang/Object;
.source "TelephonyManager.java"


# annotations
.annotation build Landroid/annotation/MiuiHook;
    value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_CLASS:Landroid/annotation/MiuiHook$MiuiHookType;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/telephony/TelephonyManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Injector"
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static getSimOperator(Ljava/lang/String;)Ljava/lang/String;
    .registers 2
    .parameter "op"

    .prologue
    invoke-static {}, Landroid/telephony/TelephonyManager;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lmiui/telephony/ExtraTelephonyManager;->getSimOperator(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
