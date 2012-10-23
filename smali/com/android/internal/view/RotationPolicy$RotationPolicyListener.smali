.class public abstract Lcom/android/internal/view/RotationPolicy$RotationPolicyListener;
.super Ljava/lang/Object;
.source "RotationPolicy.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/view/RotationPolicy;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "RotationPolicyListener"
.end annotation


# instance fields
.field final mObserver:Landroid/database/ContentObserver;


# direct methods
.method public constructor <init>()V
    .registers 3

    .prologue
    .line 148
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 149
    new-instance v0, Lcom/android/internal/view/RotationPolicy$RotationPolicyListener$1;

    new-instance v1, Landroid/os/Handler;

    invoke-direct {v1}, Landroid/os/Handler;-><init>()V

    invoke-direct {v0, p0, v1}, Lcom/android/internal/view/RotationPolicy$RotationPolicyListener$1;-><init>(Lcom/android/internal/view/RotationPolicy$RotationPolicyListener;Landroid/os/Handler;)V

    iput-object v0, p0, Lcom/android/internal/view/RotationPolicy$RotationPolicyListener;->mObserver:Landroid/database/ContentObserver;

    return-void
.end method


# virtual methods
.method public abstract onChange()V
.end method
