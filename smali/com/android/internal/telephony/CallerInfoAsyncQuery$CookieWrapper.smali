.class final Lcom/android/internal/telephony/CallerInfoAsyncQuery$CookieWrapper;
.super Ljava/lang/Object;
.source "CallerInfoAsyncQuery.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/telephony/CallerInfoAsyncQuery;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "CookieWrapper"
.end annotation


# instance fields
.field public cookie:Ljava/lang/Object;

.field public event:I

.field public listener:Lcom/android/internal/telephony/CallerInfoAsyncQuery$OnQueryCompleteListener;

.field public number:Ljava/lang/String;


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    .line 77
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/android/internal/telephony/CallerInfoAsyncQuery$1;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 77
    invoke-direct {p0}, Lcom/android/internal/telephony/CallerInfoAsyncQuery$CookieWrapper;-><init>()V

    return-void
.end method
