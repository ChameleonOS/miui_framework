.class Landroid/renderscript/ProgramFragmentFixedFunction$Builder$Slot;
.super Ljava/lang/Object;
.source "ProgramFragmentFixedFunction.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/renderscript/ProgramFragmentFixedFunction$Builder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "Slot"
.end annotation


# instance fields
.field env:Landroid/renderscript/ProgramFragmentFixedFunction$Builder$EnvMode;

.field format:Landroid/renderscript/ProgramFragmentFixedFunction$Builder$Format;

.field final synthetic this$0:Landroid/renderscript/ProgramFragmentFixedFunction$Builder;


# direct methods
.method constructor <init>(Landroid/renderscript/ProgramFragmentFixedFunction$Builder;Landroid/renderscript/ProgramFragmentFixedFunction$Builder$EnvMode;Landroid/renderscript/ProgramFragmentFixedFunction$Builder$Format;)V
    .registers 4
    .parameter
    .parameter "_env"
    .parameter "_fmt"

    .prologue
    .line 156
    iput-object p1, p0, Landroid/renderscript/ProgramFragmentFixedFunction$Builder$Slot;->this$0:Landroid/renderscript/ProgramFragmentFixedFunction$Builder;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 157
    iput-object p2, p0, Landroid/renderscript/ProgramFragmentFixedFunction$Builder$Slot;->env:Landroid/renderscript/ProgramFragmentFixedFunction$Builder$EnvMode;

    .line 158
    iput-object p3, p0, Landroid/renderscript/ProgramFragmentFixedFunction$Builder$Slot;->format:Landroid/renderscript/ProgramFragmentFixedFunction$Builder$Format;

    .line 159
    return-void
.end method
