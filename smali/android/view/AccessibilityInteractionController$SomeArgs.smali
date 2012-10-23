.class Landroid/view/AccessibilityInteractionController$SomeArgs;
.super Ljava/lang/Object;
.source "AccessibilityInteractionController.java"

# interfaces
.implements Landroid/util/Poolable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/view/AccessibilityInteractionController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SomeArgs"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/util/Poolable",
        "<",
        "Landroid/view/AccessibilityInteractionController$SomeArgs;",
        ">;"
    }
.end annotation


# instance fields
.field public arg1:Ljava/lang/Object;

.field public arg2:Ljava/lang/Object;

.field public argi1:I

.field public argi2:I

.field public argi3:I

.field private mIsPooled:Z

.field private mNext:Landroid/view/AccessibilityInteractionController$SomeArgs;

.field final synthetic this$0:Landroid/view/AccessibilityInteractionController;


# direct methods
.method private constructor <init>(Landroid/view/AccessibilityInteractionController;)V
    .registers 2
    .parameter

    .prologue
    .line 95
    iput-object p1, p0, Landroid/view/AccessibilityInteractionController$SomeArgs;->this$0:Landroid/view/AccessibilityInteractionController;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/view/AccessibilityInteractionController;Landroid/view/AccessibilityInteractionController$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 95
    invoke-direct {p0, p1}, Landroid/view/AccessibilityInteractionController$SomeArgs;-><init>(Landroid/view/AccessibilityInteractionController;)V

    return-void
.end method

.method static synthetic access$200(Landroid/view/AccessibilityInteractionController$SomeArgs;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 95
    invoke-direct {p0}, Landroid/view/AccessibilityInteractionController$SomeArgs;->clear()V

    return-void
.end method

.method private clear()V
    .registers 3

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x0

    .line 122
    iput-object v1, p0, Landroid/view/AccessibilityInteractionController$SomeArgs;->arg1:Ljava/lang/Object;

    .line 123
    iput-object v1, p0, Landroid/view/AccessibilityInteractionController$SomeArgs;->arg2:Ljava/lang/Object;

    .line 124
    iput v0, p0, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi1:I

    .line 125
    iput v0, p0, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi2:I

    .line 126
    iput v0, p0, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi3:I

    .line 127
    return-void
.end method


# virtual methods
.method public getNextPoolable()Landroid/view/AccessibilityInteractionController$SomeArgs;
    .registers 2

    .prologue
    .line 106
    iget-object v0, p0, Landroid/view/AccessibilityInteractionController$SomeArgs;->mNext:Landroid/view/AccessibilityInteractionController$SomeArgs;

    return-object v0
.end method

.method public bridge synthetic getNextPoolable()Ljava/lang/Object;
    .registers 2

    .prologue
    .line 95
    invoke-virtual {p0}, Landroid/view/AccessibilityInteractionController$SomeArgs;->getNextPoolable()Landroid/view/AccessibilityInteractionController$SomeArgs;

    move-result-object v0

    return-object v0
.end method

.method public isPooled()Z
    .registers 2

    .prologue
    .line 110
    iget-boolean v0, p0, Landroid/view/AccessibilityInteractionController$SomeArgs;->mIsPooled:Z

    return v0
.end method

.method public setNextPoolable(Landroid/view/AccessibilityInteractionController$SomeArgs;)V
    .registers 2
    .parameter "args"

    .prologue
    .line 114
    iput-object p1, p0, Landroid/view/AccessibilityInteractionController$SomeArgs;->mNext:Landroid/view/AccessibilityInteractionController$SomeArgs;

    .line 115
    return-void
.end method

.method public bridge synthetic setNextPoolable(Ljava/lang/Object;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 95
    check-cast p1, Landroid/view/AccessibilityInteractionController$SomeArgs;

    .end local p1
    invoke-virtual {p0, p1}, Landroid/view/AccessibilityInteractionController$SomeArgs;->setNextPoolable(Landroid/view/AccessibilityInteractionController$SomeArgs;)V

    return-void
.end method

.method public setPooled(Z)V
    .registers 2
    .parameter "isPooled"

    .prologue
    .line 118
    iput-boolean p1, p0, Landroid/view/AccessibilityInteractionController$SomeArgs;->mIsPooled:Z

    .line 119
    return-void
.end method
