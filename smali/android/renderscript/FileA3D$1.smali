.class synthetic Landroid/renderscript/FileA3D$1;
.super Ljava/lang/Object;
.source "FileA3D.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/renderscript/FileA3D;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1008
    name = null
.end annotation


# static fields
.field static final synthetic $SwitchMap$android$renderscript$FileA3D$EntryType:[I


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .prologue
    .line 148
    invoke-static {}, Landroid/renderscript/FileA3D$EntryType;->values()[Landroid/renderscript/FileA3D$EntryType;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Landroid/renderscript/FileA3D$1;->$SwitchMap$android$renderscript$FileA3D$EntryType:[I

    :try_start_9
    sget-object v0, Landroid/renderscript/FileA3D$1;->$SwitchMap$android$renderscript$FileA3D$EntryType:[I

    sget-object v1, Landroid/renderscript/FileA3D$EntryType;->MESH:Landroid/renderscript/FileA3D$EntryType;

    invoke-virtual {v1}, Landroid/renderscript/FileA3D$EntryType;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_14
    .catch Ljava/lang/NoSuchFieldError; {:try_start_9 .. :try_end_14} :catch_15

    :goto_14
    return-void

    :catch_15
    move-exception v0

    goto :goto_14
.end method
