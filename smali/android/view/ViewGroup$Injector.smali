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
    .line 84
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static tagAddingChildSequenceState(Landroid/view/ViewGroup;[Landroid/view/View;II)V
    .registers 10
    .parameter "vg"
    .parameter "children"
    .parameter "childrenCount"
    .parameter "index"

    .prologue
    const v5, 0x10100a6

    const v4, 0x10100a4

    const/4 v3, 0x1

    const v2, 0x10100a5

    const/4 v1, 0x0

    .line 86
    instance-of v0, p0, Landroid/widget/AbsListView;

    if-eqz v0, :cond_10

    .line 112
    :goto_f
    :pswitch_f
    return-void

    .line 91
    :cond_10
    packed-switch p2, :pswitch_data_4c

    .line 102
    add-int/lit8 v0, p2, -0x1

    if-ne p3, v0, :cond_38

    .line 103
    aget-object v0, p1, p3

    invoke-virtual {v0, v5}, Landroid/view/View;->setAdditionalState(I)V

    .line 104
    add-int/lit8 v0, p3, -0x1

    aget-object v0, p1, v0

    invoke-virtual {v0, v2}, Landroid/view/View;->setAdditionalState(I)V

    goto :goto_f

    .line 95
    :pswitch_24
    aget-object v0, p1, v1

    const v1, 0x10100a3

    invoke-virtual {v0, v1}, Landroid/view/View;->setAdditionalState(I)V

    goto :goto_f

    .line 98
    :pswitch_2d
    aget-object v0, p1, v1

    invoke-virtual {v0, v4}, Landroid/view/View;->setAdditionalState(I)V

    .line 99
    aget-object v0, p1, v3

    invoke-virtual {v0, v5}, Landroid/view/View;->setAdditionalState(I)V

    goto :goto_f

    .line 105
    :cond_38
    if-nez p3, :cond_45

    .line 106
    aget-object v0, p1, v1

    invoke-virtual {v0, v4}, Landroid/view/View;->setAdditionalState(I)V

    .line 107
    aget-object v0, p1, v3

    invoke-virtual {v0, v2}, Landroid/view/View;->setAdditionalState(I)V

    goto :goto_f

    .line 109
    :cond_45
    aget-object v0, p1, p3

    invoke-virtual {v0, v2}, Landroid/view/View;->setAdditionalState(I)V

    goto :goto_f

    .line 91
    nop

    :pswitch_data_4c
    .packed-switch 0x0
        :pswitch_f
        :pswitch_24
        :pswitch_2d
    .end packed-switch
.end method

.method static tagRemovingChildSequenceState(Landroid/view/ViewGroup;[Landroid/view/View;I)V
    .registers 5
    .parameter "vg"
    .parameter "children"
    .parameter "childrenCount"

    .prologue
    const/4 v1, 0x0

    .line 115
    instance-of v0, p0, Landroid/widget/AbsListView;

    if-eqz v0, :cond_6

    .line 130
    :goto_5
    :pswitch_5
    return-void

    .line 120
    :cond_6
    packed-switch p2, :pswitch_data_26

    .line 127
    aget-object v0, p1, v1

    const v1, 0x10100a4

    invoke-virtual {v0, v1}, Landroid/view/View;->setAdditionalState(I)V

    .line 128
    add-int/lit8 v0, p2, -0x1

    aget-object v0, p1, v0

    const v1, 0x10100a6

    invoke-virtual {v0, v1}, Landroid/view/View;->setAdditionalState(I)V

    goto :goto_5

    .line 124
    :pswitch_1c
    aget-object v0, p1, v1

    const v1, 0x10100a3

    invoke-virtual {v0, v1}, Landroid/view/View;->setAdditionalState(I)V

    goto :goto_5

    .line 120
    nop

    :pswitch_data_26
    .packed-switch 0x0
        :pswitch_5
        :pswitch_1c
    .end packed-switch
.end method

.method static unTagChildSequenceState(Landroid/view/ViewGroup;[Landroid/view/View;III)V
    .registers 9
    .parameter "vg"
    .parameter "children"
    .parameter "childrenCount"
    .parameter "start"
    .parameter "count"

    .prologue
    .line 133
    instance-of v2, p0, Landroid/widget/AbsListView;

    if-eqz v2, :cond_5

    .line 147
    :cond_4
    return-void

    .line 138
    :cond_5
    if-eqz p4, :cond_4

    if-ltz p3, :cond_4

    if-ge p3, p2, :cond_4

    .line 139
    sub-int v1, p2, p3

    .line 140
    .local v1, validCount:I
    if-le p4, v1, :cond_10

    .line 141
    move p4, v1

    .line 143
    :cond_10
    const/4 v0, 0x0

    .local v0, i:I
    :goto_11
    if-ge v0, p4, :cond_4

    .line 144
    add-int v2, p3, v0

    aget-object v2, p1, v2

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/View;->setAdditionalState(I)V

    .line 143
    add-int/lit8 v0, v0, 0x1

    goto :goto_11
.end method
