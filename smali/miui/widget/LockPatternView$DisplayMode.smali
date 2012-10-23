.class public final enum Lmiui/widget/LockPatternView$DisplayMode;
.super Ljava/lang/Enum;
.source "LockPatternView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/widget/LockPatternView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "DisplayMode"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lmiui/widget/LockPatternView$DisplayMode;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lmiui/widget/LockPatternView$DisplayMode;

.field public static final enum Animate:Lmiui/widget/LockPatternView$DisplayMode;

.field public static final enum Correct:Lmiui/widget/LockPatternView$DisplayMode;

.field public static final enum Wrong:Lmiui/widget/LockPatternView$DisplayMode;


# direct methods
.method static constructor <clinit>()V
    .registers 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 138
    new-instance v0, Lmiui/widget/LockPatternView$DisplayMode;

    const-string v1, "Correct"

    invoke-direct {v0, v1, v2}, Lmiui/widget/LockPatternView$DisplayMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lmiui/widget/LockPatternView$DisplayMode;->Correct:Lmiui/widget/LockPatternView$DisplayMode;

    .line 143
    new-instance v0, Lmiui/widget/LockPatternView$DisplayMode;

    const-string v1, "Animate"

    invoke-direct {v0, v1, v3}, Lmiui/widget/LockPatternView$DisplayMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lmiui/widget/LockPatternView$DisplayMode;->Animate:Lmiui/widget/LockPatternView$DisplayMode;

    .line 148
    new-instance v0, Lmiui/widget/LockPatternView$DisplayMode;

    const-string v1, "Wrong"

    invoke-direct {v0, v1, v4}, Lmiui/widget/LockPatternView$DisplayMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lmiui/widget/LockPatternView$DisplayMode;->Wrong:Lmiui/widget/LockPatternView$DisplayMode;

    .line 133
    const/4 v0, 0x3

    new-array v0, v0, [Lmiui/widget/LockPatternView$DisplayMode;

    sget-object v1, Lmiui/widget/LockPatternView$DisplayMode;->Correct:Lmiui/widget/LockPatternView$DisplayMode;

    aput-object v1, v0, v2

    sget-object v1, Lmiui/widget/LockPatternView$DisplayMode;->Animate:Lmiui/widget/LockPatternView$DisplayMode;

    aput-object v1, v0, v3

    sget-object v1, Lmiui/widget/LockPatternView$DisplayMode;->Wrong:Lmiui/widget/LockPatternView$DisplayMode;

    aput-object v1, v0, v4

    sput-object v0, Lmiui/widget/LockPatternView$DisplayMode;->$VALUES:[Lmiui/widget/LockPatternView$DisplayMode;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .registers 3
    .parameter
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 133
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lmiui/widget/LockPatternView$DisplayMode;
    .registers 2
    .parameter "name"

    .prologue
    .line 133
    const-class v0, Lmiui/widget/LockPatternView$DisplayMode;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lmiui/widget/LockPatternView$DisplayMode;

    return-object v0
.end method

.method public static values()[Lmiui/widget/LockPatternView$DisplayMode;
    .registers 1

    .prologue
    .line 133
    sget-object v0, Lmiui/widget/LockPatternView$DisplayMode;->$VALUES:[Lmiui/widget/LockPatternView$DisplayMode;

    invoke-virtual {v0}, [Lmiui/widget/LockPatternView$DisplayMode;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lmiui/widget/LockPatternView$DisplayMode;

    return-object v0
.end method
