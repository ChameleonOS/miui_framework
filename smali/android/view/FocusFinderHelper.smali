.class public Landroid/view/FocusFinderHelper;
.super Ljava/lang/Object;
.source "FocusFinderHelper.java"


# instance fields
.field private mFocusFinder:Landroid/view/FocusFinder;


# direct methods
.method public constructor <init>(Landroid/view/FocusFinder;)V
    .registers 2
    .parameter "focusFinder"

    .prologue
    .line 32
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 33
    iput-object p1, p0, Landroid/view/FocusFinderHelper;->mFocusFinder:Landroid/view/FocusFinder;

    .line 34
    return-void
.end method

.method public static majorAxisDistance(ILandroid/graphics/Rect;Landroid/graphics/Rect;)I
    .registers 4
    .parameter "direction"
    .parameter "source"
    .parameter "dest"

    .prologue
    .line 53
    invoke-static {p0, p1, p2}, Landroid/view/FocusFinder;->majorAxisDistance(ILandroid/graphics/Rect;Landroid/graphics/Rect;)I

    move-result v0

    return v0
.end method

.method public static majorAxisDistanceToFarEdge(ILandroid/graphics/Rect;Landroid/graphics/Rect;)I
    .registers 4
    .parameter "direction"
    .parameter "source"
    .parameter "dest"

    .prologue
    .line 57
    invoke-static {p0, p1, p2}, Landroid/view/FocusFinder;->majorAxisDistanceToFarEdge(ILandroid/graphics/Rect;Landroid/graphics/Rect;)I

    move-result v0

    return v0
.end method


# virtual methods
.method public beamBeats(ILandroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Rect;)Z
    .registers 6
    .parameter "direction"
    .parameter "source"
    .parameter "rect1"
    .parameter "rect2"

    .prologue
    .line 41
    iget-object v0, p0, Landroid/view/FocusFinderHelper;->mFocusFinder:Landroid/view/FocusFinder;

    invoke-virtual {v0, p1, p2, p3, p4}, Landroid/view/FocusFinder;->beamBeats(ILandroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Rect;)Z

    move-result v0

    return v0
.end method

.method public beamsOverlap(ILandroid/graphics/Rect;Landroid/graphics/Rect;)Z
    .registers 5
    .parameter "direction"
    .parameter "rect1"
    .parameter "rect2"

    .prologue
    .line 49
    iget-object v0, p0, Landroid/view/FocusFinderHelper;->mFocusFinder:Landroid/view/FocusFinder;

    invoke-virtual {v0, p1, p2, p3}, Landroid/view/FocusFinder;->beamsOverlap(ILandroid/graphics/Rect;Landroid/graphics/Rect;)Z

    move-result v0

    return v0
.end method

.method public isBetterCandidate(ILandroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Rect;)Z
    .registers 6
    .parameter "direction"
    .parameter "source"
    .parameter "rect1"
    .parameter "rect2"

    .prologue
    .line 37
    iget-object v0, p0, Landroid/view/FocusFinderHelper;->mFocusFinder:Landroid/view/FocusFinder;

    invoke-virtual {v0, p1, p2, p3, p4}, Landroid/view/FocusFinder;->isBetterCandidate(ILandroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Rect;)Z

    move-result v0

    return v0
.end method

.method public isCandidate(Landroid/graphics/Rect;Landroid/graphics/Rect;I)Z
    .registers 5
    .parameter "srcRect"
    .parameter "destRect"
    .parameter "direction"

    .prologue
    .line 45
    iget-object v0, p0, Landroid/view/FocusFinderHelper;->mFocusFinder:Landroid/view/FocusFinder;

    invoke-virtual {v0, p1, p2, p3}, Landroid/view/FocusFinder;->isCandidate(Landroid/graphics/Rect;Landroid/graphics/Rect;I)Z

    move-result v0

    return v0
.end method
