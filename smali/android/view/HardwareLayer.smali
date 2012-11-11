.class abstract Landroid/view/HardwareLayer;
.super Ljava/lang/Object;
.source "HardwareLayer.java"


# static fields
.field static final DIMENSION_UNDEFINED:I = -0x1


# instance fields
.field mDisplayList:Landroid/view/DisplayList;

.field mHeight:I

.field mOpaque:Z

.field mWidth:I


# direct methods
.method constructor <init>()V
    .registers 3

    .prologue
    const/4 v1, -0x1

    const/4 v0, 0x0

    invoke-direct {p0, v1, v1, v0}, Landroid/view/HardwareLayer;-><init>(IIZ)V

    return-void
.end method

.method constructor <init>(IIZ)V
    .registers 4
    .parameter "width"
    .parameter "height"
    .parameter "isOpaque"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Landroid/view/HardwareLayer;->mWidth:I

    iput p2, p0, Landroid/view/HardwareLayer;->mHeight:I

    iput-boolean p3, p0, Landroid/view/HardwareLayer;->mOpaque:Z

    return-void
.end method


# virtual methods
.method abstract copyInto(Landroid/graphics/Bitmap;)Z
.end method

.method abstract destroy()V
.end method

.method abstract end(Landroid/graphics/Canvas;)V
.end method

.method abstract flush()V
.end method

.method abstract getCanvas()Landroid/view/HardwareCanvas;
.end method

.method getDisplayList()Landroid/view/DisplayList;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/view/HardwareLayer;->mDisplayList:Landroid/view/DisplayList;

    return-object v0
.end method

.method getHeight()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/view/HardwareLayer;->mHeight:I

    return v0
.end method

.method getWidth()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/view/HardwareLayer;->mWidth:I

    return v0
.end method

.method isOpaque()Z
    .registers 2

    .prologue
    iget-boolean v0, p0, Landroid/view/HardwareLayer;->mOpaque:Z

    return v0
.end method

.method abstract isValid()Z
.end method

.method abstract redraw(Landroid/view/DisplayList;Landroid/graphics/Rect;)V
.end method

.method abstract resize(II)V
.end method

.method setDisplayList(Landroid/view/DisplayList;)V
    .registers 2
    .parameter "displayList"

    .prologue
    iput-object p1, p0, Landroid/view/HardwareLayer;->mDisplayList:Landroid/view/DisplayList;

    return-void
.end method

.method abstract setTransform(Landroid/graphics/Matrix;)V
.end method

.method abstract start(Landroid/graphics/Canvas;)Landroid/view/HardwareCanvas;
.end method

.method update(IIZ)V
    .registers 4
    .parameter "width"
    .parameter "height"
    .parameter "isOpaque"

    .prologue
    iput p1, p0, Landroid/view/HardwareLayer;->mWidth:I

    iput p2, p0, Landroid/view/HardwareLayer;->mHeight:I

    iput-boolean p3, p0, Landroid/view/HardwareLayer;->mOpaque:Z

    return-void
.end method
