.class public Landroid/view/HapticFeedbackConstants;
.super Ljava/lang/Object;
.source "HapticFeedbackConstants.java"


# static fields
.field public static final FLAG_IGNORE_GLOBAL_SETTING:I = 0x2

.field public static final FLAG_IGNORE_VIEW_SETTING:I = 0x1

.field public static final FLAG_WHEN_ENABLED_EXPLICITLY:I = 0x4
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_FIELD:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation
.end field

.field public static final KEYBOARD_TAP:I = 0x3

.field public static final LONG_PRESS:I = 0x0

.field public static final SAFE_MODE_DISABLED:I = 0x2710

.field public static final SAFE_MODE_ENABLED:I = 0x2711

.field public static final VIRTUAL_KEY:I = 0x1

.field public static final VIRTUAL_RELEASED:I = 0x2
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_FIELD:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation
.end field


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
