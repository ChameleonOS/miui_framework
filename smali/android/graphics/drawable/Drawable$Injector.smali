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
    .line 121
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static compareStateSet(Landroid/graphics/drawable/Drawable;[I)Z
    .registers 8
    .parameter "d"
    .parameter "stateSet"

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 131
    #getter for: Landroid/graphics/drawable/Drawable;->mStateSet:[I
    invoke-static {p0}, Landroid/graphics/drawable/Drawable;->access$000(Landroid/graphics/drawable/Drawable;)[I

    move-result-object v4

    if-ne p1, v4, :cond_9

    .line 150
    :cond_8
    :goto_8
    return v2

    .line 135
    :cond_9
    if-nez p1, :cond_15

    .line 136
    #getter for: Landroid/graphics/drawable/Drawable;->mStateSet:[I
    invoke-static {p0}, Landroid/graphics/drawable/Drawable;->access$000(Landroid/graphics/drawable/Drawable;)[I

    move-result-object v4

    aget v4, v4, v3

    if-eqz v4, :cond_8

    move v2, v3

    goto :goto_8

    .line 139
    :cond_15
    array-length v4, p1

    #getter for: Landroid/graphics/drawable/Drawable;->mStateSet:[I
    invoke-static {p0}, Landroid/graphics/drawable/Drawable;->access$000(Landroid/graphics/drawable/Drawable;)[I

    move-result-object v5

    array-length v5, v5

    if-le v4, v5, :cond_35

    .line 140
    #getter for: Landroid/graphics/drawable/Drawable;->mStateSet:[I
    invoke-static {p0}, Landroid/graphics/drawable/Drawable;->access$000(Landroid/graphics/drawable/Drawable;)[I

    move-result-object v4

    array-length v4, v4

    array-length v5, p1

    add-int/2addr v4, v5

    new-array v1, v4, [I

    .line 141
    .local v1, newStates:[I
    #getter for: Landroid/graphics/drawable/Drawable;->mStateSet:[I
    invoke-static {p0}, Landroid/graphics/drawable/Drawable;->access$000(Landroid/graphics/drawable/Drawable;)[I

    move-result-object v4

    #getter for: Landroid/graphics/drawable/Drawable;->mStateSet:[I
    invoke-static {p0}, Landroid/graphics/drawable/Drawable;->access$000(Landroid/graphics/drawable/Drawable;)[I

    move-result-object v5

    array-length v5, v5

    invoke-static {v4, v3, v1, v3, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 142
    #setter for: Landroid/graphics/drawable/Drawable;->mStateSet:[I
    invoke-static {p0, v1}, Landroid/graphics/drawable/Drawable;->access$002(Landroid/graphics/drawable/Drawable;[I)[I

    .line 145
    .end local v1           #newStates:[I
    :cond_35
    const/4 v0, 0x0

    .local v0, i:I
    :goto_36
    array-length v4, p1

    if-ge v0, v4, :cond_48

    .line 146
    aget v4, p1, v0

    #getter for: Landroid/graphics/drawable/Drawable;->mStateSet:[I
    invoke-static {p0}, Landroid/graphics/drawable/Drawable;->access$000(Landroid/graphics/drawable/Drawable;)[I

    move-result-object v5

    aget v5, v5, v0

    if-eq v4, v5, :cond_45

    move v2, v3

    .line 147
    goto :goto_8

    .line 145
    :cond_45
    add-int/lit8 v0, v0, 0x1

    goto :goto_36

    .line 150
    :cond_48
    #getter for: Landroid/graphics/drawable/Drawable;->mStateSet:[I
    invoke-static {p0}, Landroid/graphics/drawable/Drawable;->access$000(Landroid/graphics/drawable/Drawable;)[I

    move-result-object v4

    array-length v4, v4

    array-length v5, p1

    if-eq v4, v5, :cond_59

    #getter for: Landroid/graphics/drawable/Drawable;->mStateSet:[I
    invoke-static {p0}, Landroid/graphics/drawable/Drawable;->access$000(Landroid/graphics/drawable/Drawable;)[I

    move-result-object v4

    array-length v5, p1

    aget v4, v4, v5

    if-nez v4, :cond_5a

    :cond_59
    move v3, v2

    :cond_5a
    move v2, v3

    goto :goto_8
.end method

.method static copyStateSet(Landroid/graphics/drawable/Drawable;[I)V
    .registers 6
    .parameter "d"
    .parameter "stateSet"

    .prologue
    const/4 v3, 0x0

    .line 155
    if-nez p1, :cond_10

    .line 156
    #getter for: Landroid/graphics/drawable/Drawable;->mStateSet:[I
    invoke-static {p0}, Landroid/graphics/drawable/Drawable;->access$000(Landroid/graphics/drawable/Drawable;)[I

    move-result-object v0

    #getter for: Landroid/graphics/drawable/Drawable;->mStateSet:[I
    invoke-static {p0}, Landroid/graphics/drawable/Drawable;->access$000(Landroid/graphics/drawable/Drawable;)[I

    move-result-object v1

    array-length v1, v1

    invoke-static {v0, v3, v1, v3}, Ljava/util/Arrays;->fill([IIII)V

    .line 161
    :goto_f
    return-void

    .line 158
    :cond_10
    #getter for: Landroid/graphics/drawable/Drawable;->mStateSet:[I
    invoke-static {p0}, Landroid/graphics/drawable/Drawable;->access$000(Landroid/graphics/drawable/Drawable;)[I

    move-result-object v0

    array-length v1, p1

    invoke-static {p1, v3, v0, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 159
    #getter for: Landroid/graphics/drawable/Drawable;->mStateSet:[I
    invoke-static {p0}, Landroid/graphics/drawable/Drawable;->access$000(Landroid/graphics/drawable/Drawable;)[I

    move-result-object v0

    array-length v1, p1

    #getter for: Landroid/graphics/drawable/Drawable;->mStateSet:[I
    invoke-static {p0}, Landroid/graphics/drawable/Drawable;->access$000(Landroid/graphics/drawable/Drawable;)[I

    move-result-object v2

    array-length v2, v2

    invoke-static {v0, v1, v2, v3}, Ljava/util/Arrays;->fill([IIII)V

    goto :goto_f
.end method

.method static miuiSetState(Landroid/graphics/drawable/Drawable;[I)Z
    .registers 3
    .parameter "d"
    .parameter "stateSet"

    .prologue
    .line 123
    invoke-static {p0, p1}, Landroid/graphics/drawable/Drawable$Injector;->compareStateSet(Landroid/graphics/drawable/Drawable;[I)Z

    move-result v0

    if-nez v0, :cond_e

    .line 124
    invoke-static {p0, p1}, Landroid/graphics/drawable/Drawable$Injector;->copyStateSet(Landroid/graphics/drawable/Drawable;[I)V

    .line 125
    invoke-virtual {p0, p1}, Landroid/graphics/drawable/Drawable;->onStateChange([I)Z

    move-result v0

    .line 127
    :goto_d
    return v0

    :cond_e
    const/4 v0, 0x0

    goto :goto_d
.end method
