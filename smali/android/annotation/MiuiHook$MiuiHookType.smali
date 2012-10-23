.class public final enum Landroid/annotation/MiuiHook$MiuiHookType;
.super Ljava/lang/Enum;
.source "MiuiHook.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/annotation/MiuiHook;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "MiuiHookType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Landroid/annotation/MiuiHook$MiuiHookType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Landroid/annotation/MiuiHook$MiuiHookType;

.field public static final enum CHANGE_ACCESS:Landroid/annotation/MiuiHook$MiuiHookType;

.field public static final enum CHANGE_BASE_CLASS:Landroid/annotation/MiuiHook$MiuiHookType;

.field public static final enum CHANGE_CODE:Landroid/annotation/MiuiHook$MiuiHookType;

.field public static final enum CHANGE_CODE_AND_ACCESS:Landroid/annotation/MiuiHook$MiuiHookType;

.field public static final enum CHANGE_PARAMETER:Landroid/annotation/MiuiHook$MiuiHookType;

.field public static final enum CHANGE_PARAMETER_AND_ACCESS:Landroid/annotation/MiuiHook$MiuiHookType;

.field public static final enum NEW_CLASS:Landroid/annotation/MiuiHook$MiuiHookType;

.field public static final enum NEW_FIELD:Landroid/annotation/MiuiHook$MiuiHookType;

.field public static final enum NEW_METHOD:Landroid/annotation/MiuiHook$MiuiHookType;


# direct methods
.method static constructor <clinit>()V
    .registers 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 9
    new-instance v0, Landroid/annotation/MiuiHook$MiuiHookType;

    const-string v1, "CHANGE_ACCESS"

    invoke-direct {v0, v1, v3}, Landroid/annotation/MiuiHook$MiuiHookType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/annotation/MiuiHook$MiuiHookType;->CHANGE_ACCESS:Landroid/annotation/MiuiHook$MiuiHookType;

    .line 10
    new-instance v0, Landroid/annotation/MiuiHook$MiuiHookType;

    const-string v1, "CHANGE_CODE"

    invoke-direct {v0, v1, v4}, Landroid/annotation/MiuiHook$MiuiHookType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/annotation/MiuiHook$MiuiHookType;->CHANGE_CODE:Landroid/annotation/MiuiHook$MiuiHookType;

    new-instance v0, Landroid/annotation/MiuiHook$MiuiHookType;

    const-string v1, "CHANGE_CODE_AND_ACCESS"

    invoke-direct {v0, v1, v5}, Landroid/annotation/MiuiHook$MiuiHookType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/annotation/MiuiHook$MiuiHookType;->CHANGE_CODE_AND_ACCESS:Landroid/annotation/MiuiHook$MiuiHookType;

    .line 11
    new-instance v0, Landroid/annotation/MiuiHook$MiuiHookType;

    const-string v1, "CHANGE_PARAMETER"

    invoke-direct {v0, v1, v6}, Landroid/annotation/MiuiHook$MiuiHookType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/annotation/MiuiHook$MiuiHookType;->CHANGE_PARAMETER:Landroid/annotation/MiuiHook$MiuiHookType;

    new-instance v0, Landroid/annotation/MiuiHook$MiuiHookType;

    const-string v1, "CHANGE_PARAMETER_AND_ACCESS"

    invoke-direct {v0, v1, v7}, Landroid/annotation/MiuiHook$MiuiHookType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/annotation/MiuiHook$MiuiHookType;->CHANGE_PARAMETER_AND_ACCESS:Landroid/annotation/MiuiHook$MiuiHookType;

    new-instance v0, Landroid/annotation/MiuiHook$MiuiHookType;

    const-string v1, "CHANGE_BASE_CLASS"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Landroid/annotation/MiuiHook$MiuiHookType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/annotation/MiuiHook$MiuiHookType;->CHANGE_BASE_CLASS:Landroid/annotation/MiuiHook$MiuiHookType;

    .line 12
    new-instance v0, Landroid/annotation/MiuiHook$MiuiHookType;

    const-string v1, "NEW_CLASS"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Landroid/annotation/MiuiHook$MiuiHookType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/annotation/MiuiHook$MiuiHookType;->NEW_CLASS:Landroid/annotation/MiuiHook$MiuiHookType;

    new-instance v0, Landroid/annotation/MiuiHook$MiuiHookType;

    const-string v1, "NEW_FIELD"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Landroid/annotation/MiuiHook$MiuiHookType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/annotation/MiuiHook$MiuiHookType;->NEW_FIELD:Landroid/annotation/MiuiHook$MiuiHookType;

    new-instance v0, Landroid/annotation/MiuiHook$MiuiHookType;

    const-string v1, "NEW_METHOD"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Landroid/annotation/MiuiHook$MiuiHookType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/annotation/MiuiHook$MiuiHookType;->NEW_METHOD:Landroid/annotation/MiuiHook$MiuiHookType;

    .line 8
    const/16 v0, 0x9

    new-array v0, v0, [Landroid/annotation/MiuiHook$MiuiHookType;

    sget-object v1, Landroid/annotation/MiuiHook$MiuiHookType;->CHANGE_ACCESS:Landroid/annotation/MiuiHook$MiuiHookType;

    aput-object v1, v0, v3

    sget-object v1, Landroid/annotation/MiuiHook$MiuiHookType;->CHANGE_CODE:Landroid/annotation/MiuiHook$MiuiHookType;

    aput-object v1, v0, v4

    sget-object v1, Landroid/annotation/MiuiHook$MiuiHookType;->CHANGE_CODE_AND_ACCESS:Landroid/annotation/MiuiHook$MiuiHookType;

    aput-object v1, v0, v5

    sget-object v1, Landroid/annotation/MiuiHook$MiuiHookType;->CHANGE_PARAMETER:Landroid/annotation/MiuiHook$MiuiHookType;

    aput-object v1, v0, v6

    sget-object v1, Landroid/annotation/MiuiHook$MiuiHookType;->CHANGE_PARAMETER_AND_ACCESS:Landroid/annotation/MiuiHook$MiuiHookType;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Landroid/annotation/MiuiHook$MiuiHookType;->CHANGE_BASE_CLASS:Landroid/annotation/MiuiHook$MiuiHookType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Landroid/annotation/MiuiHook$MiuiHookType;->NEW_CLASS:Landroid/annotation/MiuiHook$MiuiHookType;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Landroid/annotation/MiuiHook$MiuiHookType;->NEW_FIELD:Landroid/annotation/MiuiHook$MiuiHookType;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Landroid/annotation/MiuiHook$MiuiHookType;->NEW_METHOD:Landroid/annotation/MiuiHook$MiuiHookType;

    aput-object v2, v0, v1

    sput-object v0, Landroid/annotation/MiuiHook$MiuiHookType;->$VALUES:[Landroid/annotation/MiuiHook$MiuiHookType;

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
    .line 8
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Landroid/annotation/MiuiHook$MiuiHookType;
    .registers 2
    .parameter "name"

    .prologue
    .line 8
    const-class v0, Landroid/annotation/MiuiHook$MiuiHookType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Landroid/annotation/MiuiHook$MiuiHookType;

    return-object v0
.end method

.method public static values()[Landroid/annotation/MiuiHook$MiuiHookType;
    .registers 1

    .prologue
    .line 8
    sget-object v0, Landroid/annotation/MiuiHook$MiuiHookType;->$VALUES:[Landroid/annotation/MiuiHook$MiuiHookType;

    invoke-virtual {v0}, [Landroid/annotation/MiuiHook$MiuiHookType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/annotation/MiuiHook$MiuiHookType;

    return-object v0
.end method
