.class public Landroid/content/pm/ActivityInfo;
.super Landroid/content/pm/ComponentInfo;
.source "ActivityInfo.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CONFIG_FONT_SCALE:I = 0x40000000

.field public static final CONFIG_KEYBOARD:I = 0x10

.field public static final CONFIG_KEYBOARD_HIDDEN:I = 0x20

.field public static final CONFIG_LOCALE:I = 0x4

.field public static final CONFIG_MCC:I = 0x1

.field public static final CONFIG_MNC:I = 0x2

.field public static CONFIG_NATIVE_BITS:[I = null

.field public static final CONFIG_NAVIGATION:I = 0x40

.field public static final CONFIG_ORIENTATION:I = 0x80

.field public static final CONFIG_SCREEN_LAYOUT:I = 0x100

.field public static final CONFIG_SCREEN_SIZE:I = 0x400

.field public static final CONFIG_SMALLEST_SCREEN_SIZE:I = 0x800

.field public static final CONFIG_TOUCHSCREEN:I = 0x8

.field public static final CONFIG_UI_MODE:I = 0x200

.field public static final CREATOR:Landroid/os/Parcelable$Creator; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/content/pm/ActivityInfo;",
            ">;"
        }
    .end annotation
.end field

.field public static final FLAG_ALLOW_TASK_REPARENTING:I = 0x40

.field public static final FLAG_ALWAYS_RETAIN_TASK_STATE:I = 0x8

.field public static final FLAG_CLEAR_TASK_ON_LAUNCH:I = 0x4

.field public static final FLAG_EXCLUDE_FROM_RECENTS:I = 0x20

.field public static final FLAG_FINISH_ON_CLOSE_SYSTEM_DIALOGS:I = 0x100

.field public static final FLAG_FINISH_ON_TASK_LAUNCH:I = 0x2

.field public static final FLAG_HARDWARE_ACCELERATED:I = 0x200

.field public static final FLAG_IMMERSIVE:I = 0x400

.field public static final FLAG_MULTIPROCESS:I = 0x1

.field public static final FLAG_NO_HISTORY:I = 0x80

.field public static final FLAG_STATE_NOT_NEEDED:I = 0x10

.field public static final LAUNCH_MULTIPLE:I = 0x0

.field public static final LAUNCH_SINGLE_INSTANCE:I = 0x3

.field public static final LAUNCH_SINGLE_TASK:I = 0x2

.field public static final LAUNCH_SINGLE_TOP:I = 0x1

.field public static final SCREEN_ORIENTATION_BEHIND:I = 0x3

.field public static final SCREEN_ORIENTATION_FULL_SENSOR:I = 0xa

.field public static final SCREEN_ORIENTATION_LANDSCAPE:I = 0x0

.field public static final SCREEN_ORIENTATION_NOSENSOR:I = 0x5

.field public static final SCREEN_ORIENTATION_PORTRAIT:I = 0x1

.field public static final SCREEN_ORIENTATION_REVERSE_LANDSCAPE:I = 0x8

.field public static final SCREEN_ORIENTATION_REVERSE_PORTRAIT:I = 0x9

.field public static final SCREEN_ORIENTATION_SENSOR:I = 0x4

.field public static final SCREEN_ORIENTATION_SENSOR_LANDSCAPE:I = 0x6

.field public static final SCREEN_ORIENTATION_SENSOR_PORTRAIT:I = 0x7

.field public static final SCREEN_ORIENTATION_UNSPECIFIED:I = -0x1

.field public static final SCREEN_ORIENTATION_USER:I = 0x2

.field public static final UIOPTION_SPLIT_ACTION_BAR_WHEN_NARROW:I = 0x1


# instance fields
.field public configChanges:I

.field public flags:I

.field public launchMode:I

.field public parentActivityName:Ljava/lang/String;

.field public permission:Ljava/lang/String;

.field public screenOrientation:I

.field public softInputMode:I

.field public targetActivity:Ljava/lang/String;

.field public taskAffinity:Ljava/lang/String;

.field public theme:I

.field public uiOptions:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    const/16 v0, 0xc

    new-array v0, v0, [I

    fill-array-data v0, :array_12

    sput-object v0, Landroid/content/pm/ActivityInfo;->CONFIG_NATIVE_BITS:[I

    new-instance v0, Landroid/content/pm/ActivityInfo$1;

    invoke-direct {v0}, Landroid/content/pm/ActivityInfo$1;-><init>()V

    sput-object v0, Landroid/content/pm/ActivityInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void

    nop

    :array_12
    .array-data 0x4
        0x1t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
        0x4t 0x0t 0x0t 0x0t
        0x8t 0x0t 0x0t 0x0t
        0x10t 0x0t 0x0t 0x0t
        0x20t 0x0t 0x0t 0x0t
        0x40t 0x0t 0x0t 0x0t
        0x80t 0x0t 0x0t 0x0t
        0x0t 0x8t 0x0t 0x0t
        0x0t 0x10t 0x0t 0x0t
        0x0t 0x2t 0x0t 0x0t
        0x0t 0x20t 0x0t 0x0t
    .end array-data
.end method

.method public constructor <init>()V
    .registers 2

    .prologue
    invoke-direct {p0}, Landroid/content/pm/ComponentInfo;-><init>()V

    const/4 v0, -0x1

    iput v0, p0, Landroid/content/pm/ActivityInfo;->screenOrientation:I

    const/4 v0, 0x0

    iput v0, p0, Landroid/content/pm/ActivityInfo;->uiOptions:I

    return-void
.end method

.method public constructor <init>(Landroid/content/pm/ActivityInfo;)V
    .registers 3
    .parameter "orig"

    .prologue
    invoke-direct {p0, p1}, Landroid/content/pm/ComponentInfo;-><init>(Landroid/content/pm/ComponentInfo;)V

    const/4 v0, -0x1

    iput v0, p0, Landroid/content/pm/ActivityInfo;->screenOrientation:I

    const/4 v0, 0x0

    iput v0, p0, Landroid/content/pm/ActivityInfo;->uiOptions:I

    iget v0, p1, Landroid/content/pm/ActivityInfo;->theme:I

    iput v0, p0, Landroid/content/pm/ActivityInfo;->theme:I

    iget v0, p1, Landroid/content/pm/ActivityInfo;->launchMode:I

    iput v0, p0, Landroid/content/pm/ActivityInfo;->launchMode:I

    iget-object v0, p1, Landroid/content/pm/ActivityInfo;->permission:Ljava/lang/String;

    iput-object v0, p0, Landroid/content/pm/ActivityInfo;->permission:Ljava/lang/String;

    iget-object v0, p1, Landroid/content/pm/ActivityInfo;->taskAffinity:Ljava/lang/String;

    iput-object v0, p0, Landroid/content/pm/ActivityInfo;->taskAffinity:Ljava/lang/String;

    iget-object v0, p1, Landroid/content/pm/ActivityInfo;->targetActivity:Ljava/lang/String;

    iput-object v0, p0, Landroid/content/pm/ActivityInfo;->targetActivity:Ljava/lang/String;

    iget v0, p1, Landroid/content/pm/ActivityInfo;->flags:I

    iput v0, p0, Landroid/content/pm/ActivityInfo;->flags:I

    iget v0, p1, Landroid/content/pm/ActivityInfo;->screenOrientation:I

    iput v0, p0, Landroid/content/pm/ActivityInfo;->screenOrientation:I

    iget v0, p1, Landroid/content/pm/ActivityInfo;->configChanges:I

    iput v0, p0, Landroid/content/pm/ActivityInfo;->configChanges:I

    iget v0, p1, Landroid/content/pm/ActivityInfo;->softInputMode:I

    iput v0, p0, Landroid/content/pm/ActivityInfo;->softInputMode:I

    iget v0, p1, Landroid/content/pm/ActivityInfo;->uiOptions:I

    iput v0, p0, Landroid/content/pm/ActivityInfo;->uiOptions:I

    iget-object v0, p1, Landroid/content/pm/ActivityInfo;->parentActivityName:Ljava/lang/String;

    iput-object v0, p0, Landroid/content/pm/ActivityInfo;->parentActivityName:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .registers 3
    .parameter "source"

    .prologue
    invoke-direct {p0, p1}, Landroid/content/pm/ComponentInfo;-><init>(Landroid/os/Parcel;)V

    const/4 v0, -0x1

    iput v0, p0, Landroid/content/pm/ActivityInfo;->screenOrientation:I

    const/4 v0, 0x0

    iput v0, p0, Landroid/content/pm/ActivityInfo;->uiOptions:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/content/pm/ActivityInfo;->theme:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/content/pm/ActivityInfo;->launchMode:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/content/pm/ActivityInfo;->permission:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/content/pm/ActivityInfo;->taskAffinity:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/content/pm/ActivityInfo;->targetActivity:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/content/pm/ActivityInfo;->flags:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/content/pm/ActivityInfo;->screenOrientation:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/content/pm/ActivityInfo;->configChanges:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/content/pm/ActivityInfo;->softInputMode:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/content/pm/ActivityInfo;->uiOptions:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/content/pm/ActivityInfo;->parentActivityName:Ljava/lang/String;

    return-void
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;Landroid/content/pm/ActivityInfo$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Landroid/content/pm/ActivityInfo;-><init>(Landroid/os/Parcel;)V

    return-void
.end method

.method public static activityInfoConfigToNative(I)I
    .registers 4
    .parameter "input"

    .prologue
    const/4 v1, 0x0

    .local v1, output:I
    const/4 v0, 0x0

    .local v0, i:I
    :goto_2
    sget-object v2, Landroid/content/pm/ActivityInfo;->CONFIG_NATIVE_BITS:[I

    array-length v2, v2

    if-ge v0, v2, :cond_14

    const/4 v2, 0x1

    shl-int/2addr v2, v0

    and-int/2addr v2, p0

    if-eqz v2, :cond_11

    sget-object v2, Landroid/content/pm/ActivityInfo;->CONFIG_NATIVE_BITS:[I

    aget v2, v2, v0

    or-int/2addr v1, v2

    :cond_11
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    :cond_14
    return v1
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public dump(Landroid/util/Printer;Ljava/lang/String;)V
    .registers 5
    .parameter "pw"
    .parameter "prefix"

    .prologue
    invoke-super {p0, p1, p2}, Landroid/content/pm/ComponentInfo;->dumpFront(Landroid/util/Printer;Ljava/lang/String;)V

    iget-object v0, p0, Landroid/content/pm/ActivityInfo;->permission:Ljava/lang/String;

    if-eqz v0, :cond_24

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "permission="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Landroid/content/pm/ActivityInfo;->permission:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v0}, Landroid/util/Printer;->println(Ljava/lang/String;)V

    :cond_24
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "taskAffinity="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Landroid/content/pm/ActivityInfo;->taskAffinity:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " targetActivity="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Landroid/content/pm/ActivityInfo;->targetActivity:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v0}, Landroid/util/Printer;->println(Ljava/lang/String;)V

    iget v0, p0, Landroid/content/pm/ActivityInfo;->launchMode:I

    if-nez v0, :cond_59

    iget v0, p0, Landroid/content/pm/ActivityInfo;->flags:I

    if-nez v0, :cond_59

    iget v0, p0, Landroid/content/pm/ActivityInfo;->theme:I

    if-eqz v0, :cond_95

    :cond_59
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "launchMode="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroid/content/pm/ActivityInfo;->launchMode:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " flags=0x"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroid/content/pm/ActivityInfo;->flags:I

    invoke-static {v1}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " theme=0x"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroid/content/pm/ActivityInfo;->theme:I

    invoke-static {v1}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v0}, Landroid/util/Printer;->println(Ljava/lang/String;)V

    :cond_95
    iget v0, p0, Landroid/content/pm/ActivityInfo;->screenOrientation:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_a2

    iget v0, p0, Landroid/content/pm/ActivityInfo;->configChanges:I

    if-nez v0, :cond_a2

    iget v0, p0, Landroid/content/pm/ActivityInfo;->softInputMode:I

    if-eqz v0, :cond_df

    :cond_a2
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "screenOrientation="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroid/content/pm/ActivityInfo;->screenOrientation:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " configChanges=0x"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroid/content/pm/ActivityInfo;->configChanges:I

    invoke-static {v1}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " softInputMode=0x"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroid/content/pm/ActivityInfo;->softInputMode:I

    invoke-static {v1}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v0}, Landroid/util/Printer;->println(Ljava/lang/String;)V

    :cond_df
    iget v0, p0, Landroid/content/pm/ActivityInfo;->uiOptions:I

    if-eqz v0, :cond_103

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " uiOptions=0x"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroid/content/pm/ActivityInfo;->uiOptions:I

    invoke-static {v1}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v0}, Landroid/util/Printer;->println(Ljava/lang/String;)V

    :cond_103
    invoke-super {p0, p1, p2}, Landroid/content/pm/ComponentInfo;->dumpBack(Landroid/util/Printer;Ljava/lang/String;)V

    return-void
.end method

.method public getRealConfigChanged()I
    .registers 3

    .prologue
    iget-object v0, p0, Landroid/content/pm/ComponentInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v0, v0, Landroid/content/pm/ApplicationInfo;->targetSdkVersion:I

    const/16 v1, 0xd

    if-ge v0, v1, :cond_f

    iget v0, p0, Landroid/content/pm/ActivityInfo;->configChanges:I

    or-int/lit16 v0, v0, 0x400

    or-int/lit16 v0, v0, 0x800

    :goto_e
    return v0

    :cond_f
    iget v0, p0, Landroid/content/pm/ActivityInfo;->configChanges:I

    goto :goto_e
.end method

.method public final getThemeResource()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/content/pm/ActivityInfo;->theme:I

    if-eqz v0, :cond_7

    iget v0, p0, Landroid/content/pm/ActivityInfo;->theme:I

    :goto_6
    return v0

    :cond_7
    iget-object v0, p0, Landroid/content/pm/ComponentInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v0, v0, Landroid/content/pm/ApplicationInfo;->theme:I

    goto :goto_6
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    .prologue
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "ActivityInfo{"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {p0}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Landroid/content/pm/PackageItemInfo;->name:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 4
    .parameter "dest"
    .parameter "parcelableFlags"

    .prologue
    invoke-super {p0, p1, p2}, Landroid/content/pm/ComponentInfo;->writeToParcel(Landroid/os/Parcel;I)V

    iget v0, p0, Landroid/content/pm/ActivityInfo;->theme:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Landroid/content/pm/ActivityInfo;->launchMode:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget-object v0, p0, Landroid/content/pm/ActivityInfo;->permission:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object v0, p0, Landroid/content/pm/ActivityInfo;->taskAffinity:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object v0, p0, Landroid/content/pm/ActivityInfo;->targetActivity:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget v0, p0, Landroid/content/pm/ActivityInfo;->flags:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Landroid/content/pm/ActivityInfo;->screenOrientation:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Landroid/content/pm/ActivityInfo;->configChanges:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Landroid/content/pm/ActivityInfo;->softInputMode:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Landroid/content/pm/ActivityInfo;->uiOptions:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget-object v0, p0, Landroid/content/pm/ActivityInfo;->parentActivityName:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    return-void
.end method
