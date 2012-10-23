.class public final Lmiui/telephony/PhoneNumberUtils$TelocationAsyncQueryHandler$TelocationWorkerArgs;
.super Ljava/lang/Object;
.source "PhoneNumberUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/telephony/PhoneNumberUtils$TelocationAsyncQueryHandler;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1c
    name = "TelocationWorkerArgs"
.end annotation


# instance fields
.field public context:Landroid/content/Context;

.field public cookie1:Ljava/lang/Object;

.field public cookie2:Ljava/lang/Object;

.field public cookie3:Ljava/lang/Object;

.field public cookie4:Ljava/lang/Object;

.field public handler:Landroid/os/Handler;

.field public listener:Lmiui/telephony/PhoneNumberUtils$TelocationQueryListener;

.field public location:Ljava/lang/String;

.field public phoneNumber:Ljava/lang/String;


# direct methods
.method protected constructor <init>()V
    .registers 1

    .prologue
    .line 702
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
