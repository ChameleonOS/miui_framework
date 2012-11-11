.class Landroid/view/ViewGroup$Injector;
.super Ljava/lang/Object;
.source "ViewGroup.java"


# annotations
.annotation build Landroid/annotation/MiuiHook;
    value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_CLASS:Landroid/annotation/MiuiHook$MiuiHookType;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/view/ViewGroup;
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

.method static tagChildSequenceState(Landroid/view/ViewGroup;)V
    .registers 12
    .parameter "v"

    .prologue
    const/4 v5, 0x1

    .local v5, isFirst:Z
    const/4 v7, 0x0

    .local v7, taggingChild:Landroid/view/View;
    const/4 v6, 0x1

    .local v6, prevDiff:Z
    const/4 v8, -0x1

    .local v8, taggingChildDrawableId:I
    const/4 v4, 0x0

    .local v4, i:I
    :goto_5
    #getter for: Landroid/view/ViewGroup;->mChildrenCount:I
    invoke-static {p0}, Landroid/view/ViewGroup;->access$000(Landroid/view/ViewGroup;)I

    move-result v10

    if-ge v4, v10, :cond_76

    #getter for: Landroid/view/ViewGroup;->mChildren:[Landroid/view/View;
    invoke-static {p0}, Landroid/view/ViewGroup;->access$100(Landroid/view/ViewGroup;)[Landroid/view/View;

    move-result-object v10

    aget-object v0, v10, v4

    .local v0, child:Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .local v1, d:Landroid/graphics/drawable/Drawable;
    if-eqz v1, :cond_29

    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getId()I

    move-result v3

    .local v3, drawableId:I
    :goto_1b
    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v9

    .local v9, visibility:I
    const/4 v10, -0x1

    if-ne v3, v10, :cond_23

    const/4 v9, 0x4

    :cond_23
    sparse-switch v9, :sswitch_data_a0

    :goto_26
    add-int/lit8 v4, v4, 0x1

    goto :goto_5

    .end local v3           #drawableId:I
    .end local v9           #visibility:I
    :cond_29
    const/4 v3, -0x1

    goto :goto_1b

    .restart local v3       #drawableId:I
    .restart local v9       #visibility:I
    :sswitch_2b
    if-eqz v5, :cond_3d

    const/4 v5, 0x0

    iget-object v10, p0, Landroid/view/ViewGroup;->mChildSequenceStateTaggingListener:Landroid/view/ViewGroup$ChildSequenceStateTaggingListener;

    if-nez v10, :cond_36

    const/4 v6, 0x1

    :goto_33
    move v8, v3

    move-object v7, v0

    goto :goto_26

    :cond_36
    iget-object v10, p0, Landroid/view/ViewGroup;->mChildSequenceStateTaggingListener:Landroid/view/ViewGroup$ChildSequenceStateTaggingListener;

    invoke-interface {v10, p0, v0}, Landroid/view/ViewGroup$ChildSequenceStateTaggingListener;->onTaggingFirstChildSequenceState(Landroid/view/ViewGroup;Landroid/view/View;)Z

    move-result v6

    goto :goto_33

    :cond_3d
    if-nez v7, :cond_41

    const/4 v6, 0x1

    goto :goto_33

    :cond_41
    if-eq v3, v8, :cond_50

    const/4 v2, 0x1

    .local v2, diff:Z
    :goto_44
    if-eqz v6, :cond_56

    if-eqz v2, :cond_52

    const v10, 0x10100a3

    :goto_4b
    invoke-virtual {v7, v10}, Landroid/view/View;->setAdditionalState(I)V

    :goto_4e
    move v6, v2

    goto :goto_33

    .end local v2           #diff:Z
    :cond_50
    const/4 v2, 0x0

    goto :goto_44

    .restart local v2       #diff:Z
    :cond_52
    const v10, 0x10100a4

    goto :goto_4b

    :cond_56
    if-eqz v2, :cond_5f

    const v10, 0x10100a6

    :goto_5b
    invoke-virtual {v7, v10}, Landroid/view/View;->setAdditionalState(I)V

    goto :goto_4e

    :cond_5f
    const v10, 0x10100a5

    goto :goto_5b

    .end local v2           #diff:Z
    :sswitch_63
    const/4 v5, 0x0

    if-eqz v7, :cond_6e

    if-eqz v6, :cond_72

    const v10, 0x10100a3

    :goto_6b
    invoke-virtual {v7, v10}, Landroid/view/View;->setAdditionalState(I)V

    :cond_6e
    const/4 v6, 0x1

    const/4 v8, -0x1

    const/4 v7, 0x0

    goto :goto_26

    :cond_72
    const v10, 0x10100a6

    goto :goto_6b

    .end local v0           #child:Landroid/view/View;
    .end local v1           #d:Landroid/graphics/drawable/Drawable;
    .end local v3           #drawableId:I
    .end local v9           #visibility:I
    :cond_76
    if-eqz v7, :cond_87

    iget-object v10, p0, Landroid/view/ViewGroup;->mChildSequenceStateTaggingListener:Landroid/view/ViewGroup$ChildSequenceStateTaggingListener;

    if-nez v10, :cond_88

    const/4 v2, 0x1

    .restart local v2       #diff:Z
    :goto_7d
    if-eqz v6, :cond_93

    if-eqz v2, :cond_8f

    const v10, 0x10100a3

    :goto_84
    invoke-virtual {v7, v10}, Landroid/view/View;->setAdditionalState(I)V

    .end local v2           #diff:Z
    :cond_87
    :goto_87
    return-void

    :cond_88
    iget-object v10, p0, Landroid/view/ViewGroup;->mChildSequenceStateTaggingListener:Landroid/view/ViewGroup$ChildSequenceStateTaggingListener;

    invoke-interface {v10, p0, v7}, Landroid/view/ViewGroup$ChildSequenceStateTaggingListener;->onTaggingLastChildSequenceState(Landroid/view/ViewGroup;Landroid/view/View;)Z

    move-result v2

    goto :goto_7d

    .restart local v2       #diff:Z
    :cond_8f
    const v10, 0x10100a4

    goto :goto_84

    :cond_93
    if-eqz v2, :cond_9c

    const v10, 0x10100a6

    :goto_98
    invoke-virtual {v7, v10}, Landroid/view/View;->setAdditionalState(I)V

    goto :goto_87

    :cond_9c
    const v10, 0x10100a5

    goto :goto_98

    :sswitch_data_a0
    .sparse-switch
        0x0 -> :sswitch_2b
        0x4 -> :sswitch_63
    .end sparse-switch
.end method
