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

    .line 47
    const/4 v0, 0x0

    invoke-direct {p0, v1, v1, v0}, Landroid/view/HardwareLayer;-><init>(IIZ)V

    .line 48
    return-void
.end method

.method constructor <init>(IIZ)V
    .registers 4
    .parameter "width"
    .parameter "height"
    .parameter "isOpaque"

    .prologue
    .line 58
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 59
    iput p1, p0, Landroid/view/HardwareLayer;->mWidth:I

    .line 60
    iput p2, p0, Landroid/view/HardwareLayer;->mHeight:I

    .line 61
    iput-boolean p3, p0, Landroid/view/HardwareLayer;->mOpaque:Z

    .line 62
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
    .line 88
    iget-object v0, p0, Landroid/view/HardwareLayer;->mDisplayList:Landroid/view/DisplayList;

    return-object v0
.end method

.method getHeight()I
    .registers 2

    .prologue
    .line 79
    iget v0, p0, Landroid/view/HardwareLayer;->mHeight:I

    return v0
.end method

.method getWidth()I
    .registers 2

    .prologue
    .line 70
    iget v0, p0, Landroid/view/HardwareLayer;->mWidth:I

    return v0
.end method

.method isOpaque()Z
    .registers 2

    .prologue
    .line 106
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
    .line 97
    iput-object p1, p0, Landroid/view/HardwareLayer;->mDisplayList:Landroid/view/DisplayList;

    .line 98
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
    .line 175
    iput p1, p0, Landroid/view/HardwareLayer;->mWidth:I

    .line 176
    iput p2, p0, Landroid/view/HardwareLayer;->mHeight:I

    .line 177
    iput-boolean p3, p0, Landroid/view/HardwareLayer;->mOpaque:Z

    .line 178
    return-void
.end method
