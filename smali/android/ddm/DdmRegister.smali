.class public Landroid/ddm/DdmRegister;
.super Ljava/lang/Object;
.source "DdmRegister.java"


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    .line 28
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static registerHandlers()V
    .registers 0

    .prologue
    .line 48
    invoke-static {}, Landroid/ddm/DdmHandleHello;->register()V

    .line 49
    invoke-static {}, Landroid/ddm/DdmHandleThread;->register()V

    .line 50
    invoke-static {}, Landroid/ddm/DdmHandleHeap;->register()V

    .line 51
    invoke-static {}, Landroid/ddm/DdmHandleNativeHeap;->register()V

    .line 52
    invoke-static {}, Landroid/ddm/DdmHandleProfiling;->register()V

    .line 53
    invoke-static {}, Landroid/ddm/DdmHandleExit;->register()V

    .line 55
    invoke-static {}, Lorg/apache/harmony/dalvik/ddmc/DdmServer;->registrationComplete()V

    .line 56
    return-void
.end method
