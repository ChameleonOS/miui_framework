.class public Lmiui/content/res/ExtraConfiguration;
.super Ljava/lang/Object;
.source "ExtraConfiguration.java"

# interfaces
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Comparable",
        "<",
        "Lmiui/content/res/ExtraConfiguration;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONTACTS_PKG_NAME:Ljava/lang/String; = "com.android.contacts"

.field public static final LAUNCHER_PKG_NAME:Ljava/lang/String; = "com.miui.home"

.field public static final MMS_PKG_NAME:Ljava/lang/String; = "com.android.mms"

.field public static final SETTINGS_PKG_NAME:Ljava/lang/String; = "com.android.settings"

.field public static final SYSTEMUI_PKG_NAME:Ljava/lang/String; = "com.android.systemui"

.field public static final SYSTEM_INTRESTE_CHANGE_FLAG:J = 0x10007899L

.field public static final THEME_FLAG_ALARM:J = 0x400L

.field public static final THEME_FLAG_AUDIO_EFFECT:J = 0x8000L

.field public static final THEME_FLAG_BOOT_ANIMATION:J = 0x20L

.field public static final THEME_FLAG_BOOT_AUDIO:J = 0x40L

.field public static final THEME_FLAG_CLOCK:J = 0x10000L

.field public static final THEME_FLAG_CONTACT:J = 0x800L

.field public static final THEME_FLAG_FONT:J = 0x10L

.field public static final THEME_FLAG_FRAMEWORK:J = 0x1L

.field public static final THEME_FLAG_ICON:J = 0x8L

.field public static final THEME_FLAG_LAST:J = 0x20000L

.field public static final THEME_FLAG_LAUNCHER:J = 0x4000L

.field public static final THEME_FLAG_LOCKSCREEN:J = 0x4L

.field public static final THEME_FLAG_LOCKSTYLE:J = 0x1000L

.field public static final THEME_FLAG_MMS:J = 0x80L

.field public static final THEME_FLAG_NOTIFICATION:J = 0x200L

.field public static final THEME_FLAG_PHOTO_FRAME:J = 0x20000L

.field public static final THEME_FLAG_RINGTONE:J = 0x100L

.field public static final THEME_FLAG_STATUSBAR:J = 0x2000L

.field public static final THEME_FLAG_THIRD_APP:J = 0x10000000L

.field public static final THEME_FLAG_WALLPAPER:J = 0x2L

.field private static final needRestartActivitySet:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public themeChanged:I

.field public themeChangedFlags:J


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedSet(Ljava/util/Set;)Ljava/util/Set;

    move-result-object v0

    sput-object v0, Lmiui/content/res/ExtraConfiguration;->needRestartActivitySet:Ljava/util/Set;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static addNeedRestartActivity(J)V
    .registers 4
    .parameter "themeChangeFlags"

    .prologue
    invoke-static {p0, p1}, Lmiui/content/res/ExtraConfiguration;->needRestartLauncher(J)Z

    move-result v0

    if-eqz v0, :cond_d

    sget-object v0, Lmiui/content/res/ExtraConfiguration;->needRestartActivitySet:Ljava/util/Set;

    const-string v1, "com.miui.home"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    :cond_d
    invoke-static {p0, p1}, Lmiui/content/res/ExtraConfiguration;->needRestartSettings(J)Z

    move-result v0

    if-eqz v0, :cond_1a

    sget-object v0, Lmiui/content/res/ExtraConfiguration;->needRestartActivitySet:Ljava/util/Set;

    const-string v1, "com.android.settings"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    :cond_1a
    invoke-static {p0, p1}, Lmiui/content/res/ExtraConfiguration;->needRestartMms(J)Z

    move-result v0

    if-eqz v0, :cond_27

    sget-object v0, Lmiui/content/res/ExtraConfiguration;->needRestartActivitySet:Ljava/util/Set;

    const-string v1, "com.android.mms"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    :cond_27
    invoke-static {p0, p1}, Lmiui/content/res/ExtraConfiguration;->needRestartContacts(J)Z

    move-result v0

    if-eqz v0, :cond_34

    sget-object v0, Lmiui/content/res/ExtraConfiguration;->needRestartActivitySet:Ljava/util/Set;

    const-string v1, "com.android.contacts"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    :cond_34
    return-void
.end method

.method public static getScaleMode()I
    .registers 3

    .prologue
    const/4 v1, 0x1

    .local v1, scale:I
    :try_start_1
    invoke-static {}, Landroid/app/ActivityManagerNative;->getDefault()Landroid/app/IActivityManager;

    move-result-object v2

    invoke-interface {v2}, Landroid/app/IActivityManager;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    .local v0, config:Landroid/content/res/Configuration;
    if-eqz v0, :cond_20

    iget v2, v0, Landroid/content/res/Configuration;->uiMode:I
    :try_end_d
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_d} :catch_21

    and-int/lit8 v1, v2, 0xf

    const/16 v2, 0xc

    if-eq v1, v2, :cond_20

    const/16 v2, 0xd

    if-eq v1, v2, :cond_20

    const/16 v2, 0xe

    if-eq v1, v2, :cond_20

    const/16 v2, 0xf

    if-eq v1, v2, :cond_20

    const/4 v1, 0x1

    .end local v0           #config:Landroid/content/res/Configuration;
    :cond_20
    :goto_20
    return v1

    :catch_21
    move-exception v2

    goto :goto_20
.end method

.method public static needNewResources(I)Z
    .registers 2
    .parameter "configChanges"

    .prologue
    const/high16 v0, -0x8000

    and-int/2addr v0, p0

    if-eqz v0, :cond_7

    const/4 v0, 0x1

    :goto_6
    return v0

    :cond_7
    const/4 v0, 0x0

    goto :goto_6
.end method

.method public static needRestart3rdApp(J)Z
    .registers 6
    .parameter "themeChangeFlags"

    .prologue
    const-wide/32 v0, 0x10000011

    and-long/2addr v0, p0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_c

    const/4 v0, 0x1

    :goto_b
    return v0

    :cond_c
    const/4 v0, 0x0

    goto :goto_b
.end method

.method public static needRestartActivity(Ljava/lang/String;J)Z
    .registers 4
    .parameter "packageName"
    .parameter "themeChangeFlags"

    .prologue
    if-eqz p0, :cond_36

    const-string v0, "com.miui.home"

    invoke-virtual {p0, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_f

    invoke-static {p1, p2}, Lmiui/content/res/ExtraConfiguration;->needRestartLauncher(J)Z

    move-result v0

    :goto_e
    return v0

    :cond_f
    const-string v0, "com.android.settings"

    invoke-virtual {p0, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1c

    invoke-static {p1, p2}, Lmiui/content/res/ExtraConfiguration;->needRestartSettings(J)Z

    move-result v0

    goto :goto_e

    :cond_1c
    const-string v0, "com.android.mms"

    invoke-virtual {p0, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_29

    invoke-static {p1, p2}, Lmiui/content/res/ExtraConfiguration;->needRestartMms(J)Z

    move-result v0

    goto :goto_e

    :cond_29
    const-string v0, "com.android.contacts"

    invoke-virtual {p0, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_36

    invoke-static {p1, p2}, Lmiui/content/res/ExtraConfiguration;->needRestartContacts(J)Z

    move-result v0

    goto :goto_e

    :cond_36
    invoke-static {p1, p2}, Lmiui/content/res/ExtraConfiguration;->needRestart3rdApp(J)Z

    move-result v0

    goto :goto_e
.end method

.method public static needRestartContacts(J)Z
    .registers 6
    .parameter "themeChangeFlags"

    .prologue
    const-wide/16 v0, 0x811

    and-long/2addr v0, p0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_b

    const/4 v0, 0x1

    :goto_a
    return v0

    :cond_b
    const/4 v0, 0x0

    goto :goto_a
.end method

.method public static needRestartLauncher(J)Z
    .registers 6
    .parameter "themeChangeFlags"

    .prologue
    const-wide/16 v0, 0x4019

    and-long/2addr v0, p0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_b

    const/4 v0, 0x1

    :goto_a
    return v0

    :cond_b
    const/4 v0, 0x0

    goto :goto_a
.end method

.method public static needRestartMms(J)Z
    .registers 6
    .parameter "themeChangeFlags"

    .prologue
    const-wide/16 v0, 0x91

    and-long/2addr v0, p0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_b

    const/4 v0, 0x1

    :goto_a
    return v0

    :cond_b
    const/4 v0, 0x0

    goto :goto_a
.end method

.method public static needRestartSettings(J)Z
    .registers 6
    .parameter "themeChangeFlags"

    .prologue
    const-wide/16 v0, 0x19

    and-long/2addr v0, p0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_b

    const/4 v0, 0x1

    :goto_a
    return v0

    :cond_b
    const/4 v0, 0x0

    goto :goto_a
.end method

.method public static needRestartStatusBar(J)Z
    .registers 6
    .parameter "themeChangeFlags"

    .prologue
    const-wide/16 v0, 0x2019

    and-long/2addr v0, p0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_b

    const/4 v0, 0x1

    :goto_a
    return v0

    :cond_b
    const/4 v0, 0x0

    goto :goto_a
.end method

.method public static removeNeedRestartActivity(Ljava/lang/String;)Z
    .registers 2
    .parameter "pkgName"

    .prologue
    sget-object v0, Lmiui/content/res/ExtraConfiguration;->needRestartActivitySet:Ljava/util/Set;

    invoke-interface {v0, p0}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method


# virtual methods
.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .registers 3
    .parameter "x0"

    .prologue
    check-cast p1, Lmiui/content/res/ExtraConfiguration;

    .end local p1
    invoke-virtual {p0, p1}, Lmiui/content/res/ExtraConfiguration;->compareTo(Lmiui/content/res/ExtraConfiguration;)I

    move-result v0

    return v0
.end method

.method public compareTo(Lmiui/content/res/ExtraConfiguration;)I
    .registers 5
    .parameter "that"

    .prologue
    const/4 v0, 0x0

    .local v0, n:I
    iget v1, p0, Lmiui/content/res/ExtraConfiguration;->themeChanged:I

    iget v2, p1, Lmiui/content/res/ExtraConfiguration;->themeChanged:I

    sub-int v0, v1, v2

    if-eqz v0, :cond_9

    :cond_9
    return v0
.end method

.method public diff(Lmiui/content/res/ExtraConfiguration;)I
    .registers 5
    .parameter "delta"

    .prologue
    const/4 v0, 0x0

    .local v0, changed:I
    iget v1, p0, Lmiui/content/res/ExtraConfiguration;->themeChanged:I

    iget v2, p1, Lmiui/content/res/ExtraConfiguration;->themeChanged:I

    if-ge v1, v2, :cond_a

    const/high16 v1, -0x8000

    or-int/2addr v0, v1

    :cond_a
    return v0
.end method

.method public hashCode()I
    .registers 4

    .prologue
    iget v0, p0, Lmiui/content/res/ExtraConfiguration;->themeChanged:I

    iget-wide v1, p0, Lmiui/content/res/ExtraConfiguration;->themeChangedFlags:J

    long-to-int v1, v1

    add-int/2addr v0, v1

    return v0
.end method

.method public readFromParcel(Landroid/os/Parcel;)V
    .registers 4
    .parameter "source"

    .prologue
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lmiui/content/res/ExtraConfiguration;->themeChanged:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lmiui/content/res/ExtraConfiguration;->themeChangedFlags:J

    return-void
.end method

.method public setTo(Lmiui/content/res/ExtraConfiguration;)V
    .registers 4
    .parameter "o"

    .prologue
    iget v0, p1, Lmiui/content/res/ExtraConfiguration;->themeChanged:I

    iput v0, p0, Lmiui/content/res/ExtraConfiguration;->themeChanged:I

    iget-wide v0, p1, Lmiui/content/res/ExtraConfiguration;->themeChangedFlags:J

    iput-wide v0, p0, Lmiui/content/res/ExtraConfiguration;->themeChangedFlags:J

    return-void
.end method

.method public setToDefaults()V
    .registers 3

    .prologue
    const/4 v0, 0x0

    iput v0, p0, Lmiui/content/res/ExtraConfiguration;->themeChanged:I

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lmiui/content/res/ExtraConfiguration;->themeChangedFlags:J

    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    .prologue
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .local v0, sb:Ljava/lang/StringBuilder;
    const-string v1, " themeChanged="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Lmiui/content/res/ExtraConfiguration;->themeChanged:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, " themeChangedFlags="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v1, p0, Lmiui/content/res/ExtraConfiguration;->themeChangedFlags:J

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public updateFrom(Lmiui/content/res/ExtraConfiguration;)I
    .registers 5
    .parameter "delta"

    .prologue
    const/4 v0, 0x0

    .local v0, changed:I
    iget v1, p0, Lmiui/content/res/ExtraConfiguration;->themeChanged:I

    iget v2, p1, Lmiui/content/res/ExtraConfiguration;->themeChanged:I

    if-ge v1, v2, :cond_12

    const/high16 v1, -0x8000

    or-int/2addr v0, v1

    iget v1, p1, Lmiui/content/res/ExtraConfiguration;->themeChanged:I

    iput v1, p0, Lmiui/content/res/ExtraConfiguration;->themeChanged:I

    iget-wide v1, p1, Lmiui/content/res/ExtraConfiguration;->themeChangedFlags:J

    iput-wide v1, p0, Lmiui/content/res/ExtraConfiguration;->themeChangedFlags:J

    :cond_12
    return v0
.end method

.method public updateTheme(J)V
    .registers 4
    .parameter "changedFlags"

    .prologue
    iget v0, p0, Lmiui/content/res/ExtraConfiguration;->themeChanged:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lmiui/content/res/ExtraConfiguration;->themeChanged:I

    iput-wide p1, p0, Lmiui/content/res/ExtraConfiguration;->themeChangedFlags:J

    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 5
    .parameter "dest"
    .parameter "flags"

    .prologue
    iget v0, p0, Lmiui/content/res/ExtraConfiguration;->themeChanged:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget-wide v0, p0, Lmiui/content/res/ExtraConfiguration;->themeChangedFlags:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    return-void
.end method
