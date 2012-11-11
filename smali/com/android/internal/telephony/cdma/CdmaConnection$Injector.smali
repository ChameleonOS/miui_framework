.class Lcom/android/internal/telephony/cdma/CdmaConnection$Injector;
.super Ljava/lang/Object;
.source "CdmaConnection.java"


# annotations
.annotation build Landroid/annotation/MiuiHook;
    value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_CLASS:Landroid/annotation/MiuiHook$MiuiHookType;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/telephony/cdma/CdmaConnection;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Injector"
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static nullifyString(Ljava/lang/String;)Ljava/lang/String;
    .registers 2
    .parameter "str"

    .prologue
    const/4 v0, 0x0

    return-object v0
.end method

.method static setPostDialState(Lcom/android/internal/telephony/cdma/CdmaConnection;Lcom/android/internal/telephony/Connection$PostDialState;)V
    .registers 2
    .parameter "conn"
    .parameter "s"

    .prologue
    return-void
.end method
