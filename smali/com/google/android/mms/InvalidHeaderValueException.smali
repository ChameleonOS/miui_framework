.class public Lcom/google/android/mms/InvalidHeaderValueException;
.super Lcom/google/android/mms/MmsException;
.source "InvalidHeaderValueException.java"


# static fields
.field private static final serialVersionUID:J = -0x1c7f1651e1e18aa6L


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct {p0}, Lcom/google/android/mms/MmsException;-><init>()V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .registers 2
    .parameter "message"

    .prologue
    invoke-direct {p0, p1}, Lcom/google/android/mms/MmsException;-><init>(Ljava/lang/String;)V

    return-void
.end method
