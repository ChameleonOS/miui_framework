.class public final Lmiui/provider/ExtraTelephony$Threads$Intents;
.super Ljava/lang/Object;
.source "ExtraTelephony.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/provider/ExtraTelephony$Threads;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Intents"
.end annotation


# static fields
.field public static final THREADS_OBSOLETED_ACTION:Ljava/lang/String; = "android.intent.action.SMS_THREADS_OBSOLETED_ACTION"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 363
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
