.class public abstract Landroid/text/style/CharacterStyle;
.super Ljava/lang/Object;
.source "CharacterStyle.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/text/style/CharacterStyle$Passthrough;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 26
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 60
    return-void
.end method

.method public static wrap(Landroid/text/style/CharacterStyle;)Landroid/text/style/CharacterStyle;
    .registers 2
    .parameter "cs"

    .prologue
    .line 37
    instance-of v0, p0, Landroid/text/style/MetricAffectingSpan;

    if-eqz v0, :cond_c

    .line 38
    new-instance v0, Landroid/text/style/MetricAffectingSpan$Passthrough;

    check-cast p0, Landroid/text/style/MetricAffectingSpan;

    .end local p0
    invoke-direct {v0, p0}, Landroid/text/style/MetricAffectingSpan$Passthrough;-><init>(Landroid/text/style/MetricAffectingSpan;)V

    .line 40
    .restart local p0
    :goto_b
    return-object v0

    :cond_c
    new-instance v0, Landroid/text/style/CharacterStyle$Passthrough;

    invoke-direct {v0, p0}, Landroid/text/style/CharacterStyle$Passthrough;-><init>(Landroid/text/style/CharacterStyle;)V

    goto :goto_b
.end method


# virtual methods
.method public getUnderlying()Landroid/text/style/CharacterStyle;
    .registers 1

    .prologue
    .line 50
    return-object p0
.end method

.method public abstract updateDrawState(Landroid/text/TextPaint;)V
.end method
