.class synthetic Landroid/renderscript/ProgramFragmentFixedFunction$1;
.super Ljava/lang/Object;
.source "ProgramFragmentFixedFunction.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/renderscript/ProgramFragmentFixedFunction;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1008
    name = null
.end annotation


# static fields
.field static final synthetic $SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$EnvMode:[I

.field static final synthetic $SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$Format:[I


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .prologue
    .line 184
    invoke-static {}, Landroid/renderscript/ProgramFragmentFixedFunction$Builder$EnvMode;->values()[Landroid/renderscript/ProgramFragmentFixedFunction$Builder$EnvMode;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Landroid/renderscript/ProgramFragmentFixedFunction$1;->$SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$EnvMode:[I

    :try_start_9
    sget-object v0, Landroid/renderscript/ProgramFragmentFixedFunction$1;->$SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$EnvMode:[I

    sget-object v1, Landroid/renderscript/ProgramFragmentFixedFunction$Builder$EnvMode;->REPLACE:Landroid/renderscript/ProgramFragmentFixedFunction$Builder$EnvMode;

    invoke-virtual {v1}, Landroid/renderscript/ProgramFragmentFixedFunction$Builder$EnvMode;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_14
    .catch Ljava/lang/NoSuchFieldError; {:try_start_9 .. :try_end_14} :catch_6c

    :goto_14
    :try_start_14
    sget-object v0, Landroid/renderscript/ProgramFragmentFixedFunction$1;->$SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$EnvMode:[I

    sget-object v1, Landroid/renderscript/ProgramFragmentFixedFunction$Builder$EnvMode;->MODULATE:Landroid/renderscript/ProgramFragmentFixedFunction$Builder$EnvMode;

    invoke-virtual {v1}, Landroid/renderscript/ProgramFragmentFixedFunction$Builder$EnvMode;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_1f
    .catch Ljava/lang/NoSuchFieldError; {:try_start_14 .. :try_end_1f} :catch_6a

    :goto_1f
    :try_start_1f
    sget-object v0, Landroid/renderscript/ProgramFragmentFixedFunction$1;->$SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$EnvMode:[I

    sget-object v1, Landroid/renderscript/ProgramFragmentFixedFunction$Builder$EnvMode;->DECAL:Landroid/renderscript/ProgramFragmentFixedFunction$Builder$EnvMode;

    invoke-virtual {v1}, Landroid/renderscript/ProgramFragmentFixedFunction$Builder$EnvMode;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_2a
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1f .. :try_end_2a} :catch_68

    .line 186
    :goto_2a
    invoke-static {}, Landroid/renderscript/ProgramFragmentFixedFunction$Builder$Format;->values()[Landroid/renderscript/ProgramFragmentFixedFunction$Builder$Format;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Landroid/renderscript/ProgramFragmentFixedFunction$1;->$SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$Format:[I

    :try_start_33
    sget-object v0, Landroid/renderscript/ProgramFragmentFixedFunction$1;->$SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$Format:[I

    sget-object v1, Landroid/renderscript/ProgramFragmentFixedFunction$Builder$Format;->ALPHA:Landroid/renderscript/ProgramFragmentFixedFunction$Builder$Format;

    invoke-virtual {v1}, Landroid/renderscript/ProgramFragmentFixedFunction$Builder$Format;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_3e
    .catch Ljava/lang/NoSuchFieldError; {:try_start_33 .. :try_end_3e} :catch_66

    :goto_3e
    :try_start_3e
    sget-object v0, Landroid/renderscript/ProgramFragmentFixedFunction$1;->$SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$Format:[I

    sget-object v1, Landroid/renderscript/ProgramFragmentFixedFunction$Builder$Format;->LUMINANCE_ALPHA:Landroid/renderscript/ProgramFragmentFixedFunction$Builder$Format;

    invoke-virtual {v1}, Landroid/renderscript/ProgramFragmentFixedFunction$Builder$Format;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_49
    .catch Ljava/lang/NoSuchFieldError; {:try_start_3e .. :try_end_49} :catch_64

    :goto_49
    :try_start_49
    sget-object v0, Landroid/renderscript/ProgramFragmentFixedFunction$1;->$SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$Format:[I

    sget-object v1, Landroid/renderscript/ProgramFragmentFixedFunction$Builder$Format;->RGB:Landroid/renderscript/ProgramFragmentFixedFunction$Builder$Format;

    invoke-virtual {v1}, Landroid/renderscript/ProgramFragmentFixedFunction$Builder$Format;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_54
    .catch Ljava/lang/NoSuchFieldError; {:try_start_49 .. :try_end_54} :catch_62

    :goto_54
    :try_start_54
    sget-object v0, Landroid/renderscript/ProgramFragmentFixedFunction$1;->$SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$Format:[I

    sget-object v1, Landroid/renderscript/ProgramFragmentFixedFunction$Builder$Format;->RGBA:Landroid/renderscript/ProgramFragmentFixedFunction$Builder$Format;

    invoke-virtual {v1}, Landroid/renderscript/ProgramFragmentFixedFunction$Builder$Format;->ordinal()I

    move-result v1

    const/4 v2, 0x4

    aput v2, v0, v1
    :try_end_5f
    .catch Ljava/lang/NoSuchFieldError; {:try_start_54 .. :try_end_5f} :catch_60

    :goto_5f
    return-void

    :catch_60
    move-exception v0

    goto :goto_5f

    :catch_62
    move-exception v0

    goto :goto_54

    :catch_64
    move-exception v0

    goto :goto_49

    :catch_66
    move-exception v0

    goto :goto_3e

    .line 184
    :catch_68
    move-exception v0

    goto :goto_2a

    :catch_6a
    move-exception v0

    goto :goto_1f

    :catch_6c
    move-exception v0

    goto :goto_14
.end method
