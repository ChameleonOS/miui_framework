.class final enum Landroid/widget/AppSecurityPermissions$State;
.super Ljava/lang/Enum;
.source "AppSecurityPermissions.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/AppSecurityPermissions;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "State"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Landroid/widget/AppSecurityPermissions$State;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Landroid/widget/AppSecurityPermissions$State;

.field public static final enum BOTH:Landroid/widget/AppSecurityPermissions$State;

.field public static final enum DANGEROUS_ONLY:Landroid/widget/AppSecurityPermissions$State;

.field public static final enum NORMAL_ONLY:Landroid/widget/AppSecurityPermissions$State;

.field public static final enum NO_PERMS:Landroid/widget/AppSecurityPermissions$State;


# direct methods
.method static constructor <clinit>()V
    .registers 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 58
    new-instance v0, Landroid/widget/AppSecurityPermissions$State;

    const-string v1, "NO_PERMS"

    invoke-direct {v0, v1, v2}, Landroid/widget/AppSecurityPermissions$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/widget/AppSecurityPermissions$State;->NO_PERMS:Landroid/widget/AppSecurityPermissions$State;

    .line 59
    new-instance v0, Landroid/widget/AppSecurityPermissions$State;

    const-string v1, "DANGEROUS_ONLY"

    invoke-direct {v0, v1, v3}, Landroid/widget/AppSecurityPermissions$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/widget/AppSecurityPermissions$State;->DANGEROUS_ONLY:Landroid/widget/AppSecurityPermissions$State;

    .line 60
    new-instance v0, Landroid/widget/AppSecurityPermissions$State;

    const-string v1, "NORMAL_ONLY"

    invoke-direct {v0, v1, v4}, Landroid/widget/AppSecurityPermissions$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/widget/AppSecurityPermissions$State;->NORMAL_ONLY:Landroid/widget/AppSecurityPermissions$State;

    .line 61
    new-instance v0, Landroid/widget/AppSecurityPermissions$State;

    const-string v1, "BOTH"

    invoke-direct {v0, v1, v5}, Landroid/widget/AppSecurityPermissions$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/widget/AppSecurityPermissions$State;->BOTH:Landroid/widget/AppSecurityPermissions$State;

    .line 57
    const/4 v0, 0x4

    new-array v0, v0, [Landroid/widget/AppSecurityPermissions$State;

    sget-object v1, Landroid/widget/AppSecurityPermissions$State;->NO_PERMS:Landroid/widget/AppSecurityPermissions$State;

    aput-object v1, v0, v2

    sget-object v1, Landroid/widget/AppSecurityPermissions$State;->DANGEROUS_ONLY:Landroid/widget/AppSecurityPermissions$State;

    aput-object v1, v0, v3

    sget-object v1, Landroid/widget/AppSecurityPermissions$State;->NORMAL_ONLY:Landroid/widget/AppSecurityPermissions$State;

    aput-object v1, v0, v4

    sget-object v1, Landroid/widget/AppSecurityPermissions$State;->BOTH:Landroid/widget/AppSecurityPermissions$State;

    aput-object v1, v0, v5

    sput-object v0, Landroid/widget/AppSecurityPermissions$State;->$VALUES:[Landroid/widget/AppSecurityPermissions$State;

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
    .line 57
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Landroid/widget/AppSecurityPermissions$State;
    .registers 2
    .parameter "name"

    .prologue
    .line 57
    const-class v0, Landroid/widget/AppSecurityPermissions$State;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Landroid/widget/AppSecurityPermissions$State;

    return-object v0
.end method

.method public static values()[Landroid/widget/AppSecurityPermissions$State;
    .registers 1

    .prologue
    .line 57
    sget-object v0, Landroid/widget/AppSecurityPermissions$State;->$VALUES:[Landroid/widget/AppSecurityPermissions$State;

    invoke-virtual {v0}, [Landroid/widget/AppSecurityPermissions$State;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/widget/AppSecurityPermissions$State;

    return-object v0
.end method
