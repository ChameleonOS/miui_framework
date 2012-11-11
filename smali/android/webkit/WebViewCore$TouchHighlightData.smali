.class Landroid/webkit/WebViewCore$TouchHighlightData;
.super Ljava/lang/Object;
.source "WebViewCore.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/WebViewCore;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "TouchHighlightData"
.end annotation


# instance fields
.field mNativeLayer:I

.field mNativeLayerRect:Landroid/graphics/Rect;

.field mSlop:I

.field mX:I

.field mY:I


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
