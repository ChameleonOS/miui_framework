.class Landroid/webkit/WebViewCore$GeolocationPermissionsData;
.super Ljava/lang/Object;
.source "WebViewCore.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/WebViewCore;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "GeolocationPermissionsData"
.end annotation


# instance fields
.field mAllow:Z

.field mOrigin:Ljava/lang/String;

.field mRemember:Z


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
