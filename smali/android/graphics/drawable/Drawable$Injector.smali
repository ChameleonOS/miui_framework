.class Landroid/graphics/drawable/Drawable$Injector;
.super Ljava/lang/Object;
.source "Drawable.java"


# annotations
.annotation build Landroid/annotation/MiuiHook;
    value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_CLASS:Landroid/annotation/MiuiHook$MiuiHookType;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/graphics/drawable/Drawable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Injector"
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static compareStateSet(Landroid/graphics/drawable/Drawable;[I)Z
    .registers 9
    .parameter "d"
    .parameter "stateSet"

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getState()[I

    move-result-object v0

    .local v0, drawableStateSet:[I
    if-ne p1, v0, :cond_a

    move v3, v4

    :cond_9
    :goto_9
    return v3

    :cond_a
    if-nez p1, :cond_15

    array-length v5, v0

    if-eqz v5, :cond_13

    aget v5, v0, v3

    if-nez v5, :cond_9

    :cond_13
    move v3, v4

    goto :goto_9

    :cond_15
    array-length v5, p1

    array-length v6, v0

    if-le v5, v6, :cond_26

    array-length v5, v0

    array-length v6, p1

    add-int/2addr v5, v6

    new-array v2, v5, [I

    .local v2, newStates:[I
    array-length v5, v0

    invoke-static {v0, v3, v2, v3, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    move-object v0, v2

    invoke-virtual {p0, v2}, Landroid/graphics/drawable/Drawable;->setStateInternal([I)V

    .end local v2           #newStates:[I
    :cond_26
    const/4 v1, 0x0

    .local v1, i:I
    :goto_27
    array-length v5, p1

    if-ge v1, v5, :cond_33

    aget v5, p1, v1

    aget v6, v0, v1

    if-ne v5, v6, :cond_9

    add-int/lit8 v1, v1, 0x1

    goto :goto_27

    :cond_33
    array-length v5, v0

    array-length v6, p1

    if-eq v5, v6, :cond_3c

    array-length v5, p1

    aget v5, v0, v5

    if-nez v5, :cond_9

    :cond_3c
    move v3, v4

    goto :goto_9
.end method

.method static copyStateSet(Landroid/graphics/drawable/Drawable;[I)V
    .registers 6
    .parameter "d"
    .parameter "stateSet"

    .prologue
    const/4 v3, 0x0

    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getState()[I

    move-result-object v0

    .local v0, drawableStateSet:[I
    if-nez p1, :cond_c

    array-length v1, v0

    invoke-static {v0, v3, v1, v3}, Ljava/util/Arrays;->fill([IIII)V

    :goto_b
    return-void

    :cond_c
    array-length v1, p1

    invoke-static {p1, v3, v0, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    array-length v1, p1

    array-length v2, v0

    invoke-static {v0, v1, v2, v3}, Ljava/util/Arrays;->fill([IIII)V

    goto :goto_b
.end method

.method static miuiSetState(Landroid/graphics/drawable/Drawable;[I)Z
    .registers 3
    .parameter "d"
    .parameter "stateSet"

    .prologue
    invoke-static {p0, p1}, Landroid/graphics/drawable/Drawable$Injector;->compareStateSet(Landroid/graphics/drawable/Drawable;[I)Z

    move-result v0

    if-nez v0, :cond_e

    invoke-static {p0, p1}, Landroid/graphics/drawable/Drawable$Injector;->copyStateSet(Landroid/graphics/drawable/Drawable;[I)V

    invoke-virtual {p0, p1}, Landroid/graphics/drawable/Drawable;->onStateChange([I)Z

    move-result v0

    :goto_d
    return v0

    :cond_e
    const/4 v0, 0x0

    goto :goto_d
.end method
