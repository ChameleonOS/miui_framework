.class final Landroid/view/ViewRootImpl$TrackballAxis;
.super Ljava/lang/Object;
.source "ViewRootImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/view/ViewRootImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "TrackballAxis"
.end annotation


# static fields
.field static final ACCEL_MOVE_SCALING_FACTOR:F = 0.025f

.field static final FAST_MOVE_TIME:J = 0x96L

.field static final MAX_ACCELERATION:F = 20.0f


# instance fields
.field absPosition:F

.field acceleration:F

.field dir:I

.field lastMoveTime:J

.field nonAccelMovement:I

.field position:F

.field step:I


# direct methods
.method constructor <init>()V
    .registers 3

    .prologue
    .line 4852
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 4875
    const/high16 v0, 0x3f80

    iput v0, p0, Landroid/view/ViewRootImpl$TrackballAxis;->acceleration:F

    .line 4876
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Landroid/view/ViewRootImpl$TrackballAxis;->lastMoveTime:J

    return-void
.end method


# virtual methods
.method collect(FJLjava/lang/String;)F
    .registers 13
    .parameter "off"
    .parameter "time"
    .parameter "axis"

    .prologue
    .line 4901
    const/4 v6, 0x0

    cmpl-float v6, p1, v6

    if-lez v6, :cond_55

    .line 4902
    const/high16 v6, 0x4316

    mul-float/2addr v6, p1

    float-to-long v3, v6

    .line 4903
    .local v3, normTime:J
    iget v6, p0, Landroid/view/ViewRootImpl$TrackballAxis;->dir:I

    if-gez v6, :cond_1b

    .line 4905
    const/4 v6, 0x0

    iput v6, p0, Landroid/view/ViewRootImpl$TrackballAxis;->position:F

    .line 4906
    const/4 v6, 0x0

    iput v6, p0, Landroid/view/ViewRootImpl$TrackballAxis;->step:I

    .line 4907
    const/high16 v6, 0x3f80

    iput v6, p0, Landroid/view/ViewRootImpl$TrackballAxis;->acceleration:F

    .line 4908
    const-wide/16 v6, 0x0

    iput-wide v6, p0, Landroid/view/ViewRootImpl$TrackballAxis;->lastMoveTime:J

    .line 4910
    :cond_1b
    const/4 v6, 0x1

    iput v6, p0, Landroid/view/ViewRootImpl$TrackballAxis;->dir:I

    .line 4928
    :goto_1e
    const-wide/16 v6, 0x0

    cmp-long v6, v3, v6

    if-lez v6, :cond_47

    .line 4929
    iget-wide v6, p0, Landroid/view/ViewRootImpl$TrackballAxis;->lastMoveTime:J

    sub-long v1, p2, v6

    .line 4930
    .local v1, delta:J
    iput-wide p2, p0, Landroid/view/ViewRootImpl$TrackballAxis;->lastMoveTime:J

    .line 4931
    iget v0, p0, Landroid/view/ViewRootImpl$TrackballAxis;->acceleration:F

    .line 4932
    .local v0, acc:F
    cmp-long v6, v1, v3

    if-gez v6, :cond_7b

    .line 4934
    sub-long v6, v3, v1

    long-to-float v6, v6

    const v7, 0x3ccccccd

    mul-float v5, v6, v7

    .line 4935
    .local v5, scale:F
    const/high16 v6, 0x3f80

    cmpl-float v6, v5, v6

    if-lez v6, :cond_3f

    mul-float/2addr v0, v5

    .line 4939
    :cond_3f
    const/high16 v6, 0x41a0

    cmpg-float v6, v0, v6

    if-gez v6, :cond_78

    .end local v0           #acc:F
    :goto_45
    iput v0, p0, Landroid/view/ViewRootImpl$TrackballAxis;->acceleration:F

    .line 4950
    .end local v1           #delta:J
    .end local v5           #scale:F
    :cond_47
    :goto_47
    iget v6, p0, Landroid/view/ViewRootImpl$TrackballAxis;->position:F

    add-float/2addr v6, p1

    iput v6, p0, Landroid/view/ViewRootImpl$TrackballAxis;->position:F

    .line 4951
    iget v6, p0, Landroid/view/ViewRootImpl$TrackballAxis;->position:F

    invoke-static {v6}, Ljava/lang/Math;->abs(F)F

    move-result v6

    iput v6, p0, Landroid/view/ViewRootImpl$TrackballAxis;->absPosition:F

    return v6

    .line 4911
    .end local v3           #normTime:J
    :cond_55
    const/4 v6, 0x0

    cmpg-float v6, p1, v6

    if-gez v6, :cond_75

    .line 4912
    neg-float v6, p1

    const/high16 v7, 0x4316

    mul-float/2addr v6, v7

    float-to-long v3, v6

    .line 4913
    .restart local v3       #normTime:J
    iget v6, p0, Landroid/view/ViewRootImpl$TrackballAxis;->dir:I

    if-lez v6, :cond_71

    .line 4915
    const/4 v6, 0x0

    iput v6, p0, Landroid/view/ViewRootImpl$TrackballAxis;->position:F

    .line 4916
    const/4 v6, 0x0

    iput v6, p0, Landroid/view/ViewRootImpl$TrackballAxis;->step:I

    .line 4917
    const/high16 v6, 0x3f80

    iput v6, p0, Landroid/view/ViewRootImpl$TrackballAxis;->acceleration:F

    .line 4918
    const-wide/16 v6, 0x0

    iput-wide v6, p0, Landroid/view/ViewRootImpl$TrackballAxis;->lastMoveTime:J

    .line 4920
    :cond_71
    const/4 v6, -0x1

    iput v6, p0, Landroid/view/ViewRootImpl$TrackballAxis;->dir:I

    goto :goto_1e

    .line 4922
    .end local v3           #normTime:J
    :cond_75
    const-wide/16 v3, 0x0

    .restart local v3       #normTime:J
    goto :goto_1e

    .line 4939
    .restart local v0       #acc:F
    .restart local v1       #delta:J
    .restart local v5       #scale:F
    :cond_78
    const/high16 v0, 0x41a0

    goto :goto_45

    .line 4942
    .end local v5           #scale:F
    :cond_7b
    sub-long v6, v1, v3

    long-to-float v6, v6

    const v7, 0x3ccccccd

    mul-float v5, v6, v7

    .line 4943
    .restart local v5       #scale:F
    const/high16 v6, 0x3f80

    cmpl-float v6, v5, v6

    if-lez v6, :cond_8a

    div-float/2addr v0, v5

    .line 4947
    :cond_8a
    const/high16 v6, 0x3f80

    cmpl-float v6, v0, v6

    if-lez v6, :cond_93

    .end local v0           #acc:F
    :goto_90
    iput v0, p0, Landroid/view/ViewRootImpl$TrackballAxis;->acceleration:F

    goto :goto_47

    .restart local v0       #acc:F
    :cond_93
    const/high16 v0, 0x3f80

    goto :goto_90
.end method

.method generate(F)I
    .registers 10
    .parameter "precision"

    .prologue
    const/4 v3, 0x1

    const/high16 v5, 0x4000

    const/high16 v6, 0x3f80

    .line 4966
    const/4 v2, 0x0

    .line 4967
    .local v2, movement:I
    const/4 v4, 0x0

    iput v4, p0, Landroid/view/ViewRootImpl$TrackballAxis;->nonAccelMovement:I

    .line 4969
    :goto_9
    iget v4, p0, Landroid/view/ViewRootImpl$TrackballAxis;->position:F

    const/4 v7, 0x0

    cmpl-float v4, v4, v7

    if-ltz v4, :cond_1d

    move v1, v3

    .line 4970
    .local v1, dir:I
    :goto_11
    iget v4, p0, Landroid/view/ViewRootImpl$TrackballAxis;->step:I

    packed-switch v4, :pswitch_data_78

    .line 5003
    iget v4, p0, Landroid/view/ViewRootImpl$TrackballAxis;->absPosition:F

    cmpg-float v4, v4, v6

    if-gez v4, :cond_51

    .line 5004
    :cond_1c
    return v2

    .line 4969
    .end local v1           #dir:I
    :cond_1d
    const/4 v1, -0x1

    goto :goto_11

    .line 4975
    .restart local v1       #dir:I
    :pswitch_1f
    iget v4, p0, Landroid/view/ViewRootImpl$TrackballAxis;->absPosition:F

    cmpg-float v4, v4, p1

    if-ltz v4, :cond_1c

    .line 4978
    add-int/2addr v2, v1

    .line 4979
    iget v4, p0, Landroid/view/ViewRootImpl$TrackballAxis;->nonAccelMovement:I

    add-int/2addr v4, v1

    iput v4, p0, Landroid/view/ViewRootImpl$TrackballAxis;->nonAccelMovement:I

    .line 4980
    iput v3, p0, Landroid/view/ViewRootImpl$TrackballAxis;->step:I

    goto :goto_9

    .line 4986
    :pswitch_2e
    iget v4, p0, Landroid/view/ViewRootImpl$TrackballAxis;->absPosition:F

    cmpg-float v4, v4, v5

    if-ltz v4, :cond_1c

    .line 4989
    add-int/2addr v2, v1

    .line 4990
    iget v4, p0, Landroid/view/ViewRootImpl$TrackballAxis;->nonAccelMovement:I

    add-int/2addr v4, v1

    iput v4, p0, Landroid/view/ViewRootImpl$TrackballAxis;->nonAccelMovement:I

    .line 4991
    iget v7, p0, Landroid/view/ViewRootImpl$TrackballAxis;->position:F

    if-lez v1, :cond_4f

    const/high16 v4, -0x4000

    :goto_40
    add-float/2addr v4, v7

    iput v4, p0, Landroid/view/ViewRootImpl$TrackballAxis;->position:F

    .line 4992
    iget v4, p0, Landroid/view/ViewRootImpl$TrackballAxis;->position:F

    invoke-static {v4}, Ljava/lang/Math;->abs(F)F

    move-result v4

    iput v4, p0, Landroid/view/ViewRootImpl$TrackballAxis;->absPosition:F

    .line 4993
    const/4 v4, 0x2

    iput v4, p0, Landroid/view/ViewRootImpl$TrackballAxis;->step:I

    goto :goto_9

    :cond_4f
    move v4, v5

    .line 4991
    goto :goto_40

    .line 5006
    :cond_51
    add-int/2addr v2, v1

    .line 5007
    iget v7, p0, Landroid/view/ViewRootImpl$TrackballAxis;->position:F

    if-ltz v1, :cond_72

    const/high16 v4, -0x4080

    :goto_58
    add-float/2addr v4, v7

    iput v4, p0, Landroid/view/ViewRootImpl$TrackballAxis;->position:F

    .line 5008
    iget v4, p0, Landroid/view/ViewRootImpl$TrackballAxis;->position:F

    invoke-static {v4}, Ljava/lang/Math;->abs(F)F

    move-result v4

    iput v4, p0, Landroid/view/ViewRootImpl$TrackballAxis;->absPosition:F

    .line 5009
    iget v0, p0, Landroid/view/ViewRootImpl$TrackballAxis;->acceleration:F

    .line 5010
    .local v0, acc:F
    const v4, 0x3f8ccccd

    mul-float/2addr v0, v4

    .line 5011
    const/high16 v4, 0x41a0

    cmpg-float v4, v0, v4

    if-gez v4, :cond_74

    .end local v0           #acc:F
    :goto_6f
    iput v0, p0, Landroid/view/ViewRootImpl$TrackballAxis;->acceleration:F

    goto :goto_9

    :cond_72
    move v4, v6

    .line 5007
    goto :goto_58

    .line 5011
    .restart local v0       #acc:F
    :cond_74
    iget v0, p0, Landroid/view/ViewRootImpl$TrackballAxis;->acceleration:F

    goto :goto_6f

    .line 4970
    nop

    :pswitch_data_78
    .packed-switch 0x0
        :pswitch_1f
        :pswitch_2e
    .end packed-switch
.end method

.method reset(I)V
    .registers 4
    .parameter "_step"

    .prologue
    .line 4882
    const/4 v0, 0x0

    iput v0, p0, Landroid/view/ViewRootImpl$TrackballAxis;->position:F

    .line 4883
    const/high16 v0, 0x3f80

    iput v0, p0, Landroid/view/ViewRootImpl$TrackballAxis;->acceleration:F

    .line 4884
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Landroid/view/ViewRootImpl$TrackballAxis;->lastMoveTime:J

    .line 4885
    iput p1, p0, Landroid/view/ViewRootImpl$TrackballAxis;->step:I

    .line 4886
    const/4 v0, 0x0

    iput v0, p0, Landroid/view/ViewRootImpl$TrackballAxis;->dir:I

    .line 4887
    return-void
.end method
