.class public final Landroid/content/res/MiuiResources$MIUITheme;
.super Landroid/content/res/Resources$Theme;
.source "MiuiResources.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/content/res/MiuiResources;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "MIUITheme"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/content/res/MiuiResources;


# direct methods
.method public constructor <init>(Landroid/content/res/MiuiResources;)V
    .registers 2
    .parameter

    .prologue
    .line 82
    iput-object p1, p0, Landroid/content/res/MiuiResources$MIUITheme;->this$0:Landroid/content/res/MiuiResources;

    invoke-direct {p0, p1}, Landroid/content/res/Resources$Theme;-><init>(Landroid/content/res/Resources;)V

    return-void
.end method


# virtual methods
.method public obtainStyledAttributes(I[I)Landroid/content/res/TypedArray;
    .registers 5
    .parameter "resid"
    .parameter "attrs"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/content/res/Resources$NotFoundException;
        }
    .end annotation

    .prologue
    .line 91
    iget-object v0, p0, Landroid/content/res/MiuiResources$MIUITheme;->this$0:Landroid/content/res/MiuiResources;

    invoke-super {p0, p1, p2}, Landroid/content/res/Resources$Theme;->obtainStyledAttributes(I[I)Landroid/content/res/TypedArray;

    move-result-object v1

    #calls: Landroid/content/res/MiuiResources;->replaceTypedArray(Landroid/content/res/TypedArray;)Landroid/content/res/TypedArray;
    invoke-static {v0, v1}, Landroid/content/res/MiuiResources;->access$000(Landroid/content/res/MiuiResources;Landroid/content/res/TypedArray;)Landroid/content/res/TypedArray;

    move-result-object v0

    return-object v0
.end method

.method public obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    .registers 7
    .parameter "set"
    .parameter "attrs"
    .parameter "defStyleAttr"
    .parameter "defStyleRes"

    .prologue
    .line 96
    iget-object v0, p0, Landroid/content/res/MiuiResources$MIUITheme;->this$0:Landroid/content/res/MiuiResources;

    invoke-super {p0, p1, p2, p3, p4}, Landroid/content/res/Resources$Theme;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v1

    #calls: Landroid/content/res/MiuiResources;->replaceTypedArray(Landroid/content/res/TypedArray;)Landroid/content/res/TypedArray;
    invoke-static {v0, v1}, Landroid/content/res/MiuiResources;->access$000(Landroid/content/res/MiuiResources;Landroid/content/res/TypedArray;)Landroid/content/res/TypedArray;

    move-result-object v0

    return-object v0
.end method

.method public obtainStyledAttributes([I)Landroid/content/res/TypedArray;
    .registers 4
    .parameter "attrs"

    .prologue
    .line 86
    iget-object v0, p0, Landroid/content/res/MiuiResources$MIUITheme;->this$0:Landroid/content/res/MiuiResources;

    invoke-super {p0, p1}, Landroid/content/res/Resources$Theme;->obtainStyledAttributes([I)Landroid/content/res/TypedArray;

    move-result-object v1

    #calls: Landroid/content/res/MiuiResources;->replaceTypedArray(Landroid/content/res/TypedArray;)Landroid/content/res/TypedArray;
    invoke-static {v0, v1}, Landroid/content/res/MiuiResources;->access$000(Landroid/content/res/MiuiResources;Landroid/content/res/TypedArray;)Landroid/content/res/TypedArray;

    move-result-object v0

    return-object v0
.end method
