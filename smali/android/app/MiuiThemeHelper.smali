.class public Landroid/app/MiuiThemeHelper;
.super Ljava/lang/Object;
.source "MiuiThemeHelper.java"


# static fields
.field public static final MIUI_RES_PATH:Ljava/lang/String; = "/system/framework/framework-miui-res.apk"

.field private static final TAG:Ljava/lang/String; = "IconHelper"


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    .line 30
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 31
    return-void
.end method

.method public static addExtraAssetPaths(Landroid/content/res/AssetManager;)V
    .registers 2
    .parameter "am"

    .prologue
    .line 94
    const-string v0, "/system/framework/framework-miui-res.apk"

    invoke-virtual {p0, v0}, Landroid/content/res/AssetManager;->addAssetPath(Ljava/lang/String;)I

    .line 95
    return-void
.end method

.method public static copyExtraConfigurations(Landroid/content/res/Configuration;Landroid/content/res/Configuration;)V
    .registers 4
    .parameter "srcConfig"
    .parameter "desConfig"

    .prologue
    .line 98
    iget-object v0, p1, Landroid/content/res/Configuration;->extraConfig:Lmiui/content/res/ExtraConfiguration;

    iget-object v1, p0, Landroid/content/res/Configuration;->extraConfig:Lmiui/content/res/ExtraConfiguration;

    iget v1, v1, Lmiui/content/res/ExtraConfiguration;->themeChanged:I

    iput v1, v0, Lmiui/content/res/ExtraConfiguration;->themeChanged:I

    .line 99
    return-void
.end method

.method public static getDrawable(Landroid/content/pm/PackageManager;Ljava/lang/String;ILandroid/content/pm/ApplicationInfo;Landroid/content/pm/PackageItemInfo;Z)Landroid/graphics/drawable/Drawable;
    .registers 7
    .parameter "pm"
    .parameter "packageName"
    .parameter "resid"
    .parameter "appInfo"
    .parameter "info"
    .parameter "customized"

    .prologue
    .line 87
    if-eqz p5, :cond_4

    if-nez p4, :cond_9

    .line 88
    :cond_4
    invoke-virtual {p0, p1, p2, p3}, Landroid/content/pm/PackageManager;->getDrawable(Ljava/lang/String;ILandroid/content/pm/ApplicationInfo;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 90
    :goto_8
    return-object v0

    :cond_9
    iget-object v0, p4, Landroid/content/pm/PackageItemInfo;->name:Ljava/lang/String;

    invoke-static {p0, p1, p2, p3, v0}, Landroid/app/MiuiThemeHelper;->getDrawable(Landroid/content/pm/PackageManager;Ljava/lang/String;ILandroid/content/pm/ApplicationInfo;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    goto :goto_8
.end method

.method public static getDrawable(Landroid/content/pm/PackageManager;Ljava/lang/String;ILandroid/content/pm/ApplicationInfo;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    .registers 12
    .parameter "pm"
    .parameter "packageName"
    .parameter "resid"
    .parameter "appInfo"
    .parameter "activityName"

    .prologue
    .line 51
    invoke-static {p1, p4}, Lmiui/content/res/IconCustomizer;->getFileName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 54
    .local v2, fileName:Ljava/lang/String;
    new-instance v3, Landroid/app/ApplicationPackageManager$ResourceName;

    invoke-direct {v3, v2, p2}, Landroid/app/ApplicationPackageManager$ResourceName;-><init>(Ljava/lang/String;I)V

    .line 55
    .local v3, name:Landroid/app/ApplicationPackageManager$ResourceName;
    invoke-static {v3}, Landroid/app/ApplicationPackageManager;->getCachedIcon(Landroid/app/ApplicationPackageManager$ResourceName;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 56
    .local v0, dr:Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_11

    move-object v1, v0

    .line 82
    .end local v0           #dr:Landroid/graphics/drawable/Drawable;
    .local v1, dr:Landroid/graphics/drawable/Drawable;
    :goto_10
    return-object v1

    .line 60
    .end local v1           #dr:Landroid/graphics/drawable/Drawable;
    .restart local v0       #dr:Landroid/graphics/drawable/Drawable;
    :cond_11
    invoke-static {p1}, Lmiui/content/res/IconCustomizer;->isExclude(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2e

    invoke-static {}, Lmiui/content/res/ThemeResources;->getSystem()Lmiui/content/res/ThemeResourcesSystem;

    move-result-object v4

    const-string v5, "icon_mask.png"

    invoke-virtual {v4, v5}, Lmiui/content/res/ThemeResourcesSystem;->hasIcon(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2e

    .line 61
    invoke-virtual {p0, p1, p2, p3}, Landroid/content/pm/PackageManager;->getDrawable(Ljava/lang/String;ILandroid/content/pm/ApplicationInfo;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 79
    :cond_27
    :goto_27
    if-eqz v0, :cond_2c

    .line 80
    invoke-static {v3, v0}, Landroid/app/ApplicationPackageManager;->putCachedIcon(Landroid/app/ApplicationPackageManager$ResourceName;Landroid/graphics/drawable/Drawable;)V

    :cond_2c
    move-object v1, v0

    .line 82
    .end local v0           #dr:Landroid/graphics/drawable/Drawable;
    .restart local v1       #dr:Landroid/graphics/drawable/Drawable;
    goto :goto_10

    .line 63
    .end local v1           #dr:Landroid/graphics/drawable/Drawable;
    .restart local v0       #dr:Landroid/graphics/drawable/Drawable;
    :cond_2e
    invoke-static {v2}, Lmiui/content/res/IconCustomizer;->getCustomizedIconDrawable(Ljava/lang/String;)Landroid/graphics/drawable/BitmapDrawable;

    move-result-object v0

    .line 64
    if-nez v0, :cond_27

    .line 69
    invoke-virtual {p0, p1, p2, p3}, Landroid/content/pm/PackageManager;->getDrawable(Ljava/lang/String;ILandroid/content/pm/ApplicationInfo;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 70
    if-eqz v0, :cond_27

    .line 71
    const-string v4, "IconHelper"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Generate customized icon for "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 72
    invoke-static {v0}, Lmiui/content/res/IconCustomizer;->generateIconDrawable(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/BitmapDrawable;

    move-result-object v0

    move-object v4, v0

    .line 73
    check-cast v4, Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v4}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v4

    invoke-static {v2, v4}, Lmiui/content/res/IconCustomizer;->saveCustomizedIconBitmap(Ljava/lang/String;Landroid/graphics/Bitmap;)V

    goto :goto_27
.end method

.method public static handleExtraConfigurationChanges(I)V
    .registers 2
    .parameter "changes"

    .prologue
    .line 102
    const/high16 v0, -0x8000

    and-int/2addr v0, p0

    if-eqz v0, :cond_b

    .line 103
    invoke-static {}, Landroid/graphics/Canvas;->freeCaches()V

    .line 104
    invoke-static {}, Lmiui/content/res/IconCustomizer;->clearCache()V

    .line 106
    :cond_b
    return-void
.end method

.method public static handleExtraConfigurationChanges(ILandroid/content/res/Configuration;Landroid/content/Context;Landroid/os/Handler;)V
    .registers 7
    .parameter "changes"
    .parameter "config"
    .parameter "context"
    .parameter "handler"

    .prologue
    .line 110
    const/high16 v2, -0x8000

    and-int/2addr v2, p0

    if-eqz v2, :cond_f

    .line 111
    iget-object v2, p1, Landroid/content/res/Configuration;->extraConfig:Lmiui/content/res/ExtraConfiguration;

    iget-wide v0, v2, Lmiui/content/res/ExtraConfiguration;->themeChangedFlags:J

    .line 112
    .local v0, flag:J
    invoke-static {v0, v1}, Lmiui/content/res/ExtraConfiguration;->addNeedRestartActivity(J)V

    .line 113
    invoke-static {p0}, Landroid/app/MiuiThemeHelper;->handleExtraConfigurationChanges(I)V

    .line 115
    .end local v0           #flag:J
    :cond_f
    return-void
.end method

.method public static isCompatibilityMode(I)Z
    .registers 2
    .parameter "appFlags"

    .prologue
    .line 206
    const/high16 v0, 0x800

    and-int/2addr v0, p0

    if-eqz v0, :cond_7

    const/4 v0, 0x1

    :goto_6
    return v0

    :cond_7
    const/4 v0, 0x0

    goto :goto_6
.end method

.method public static isCustomizedIcon(Landroid/content/IntentFilter;)Z
    .registers 4
    .parameter "filter"

    .prologue
    .line 38
    if-eqz p0, :cond_1b

    .line 39
    invoke-virtual {p0}, Landroid/content/IntentFilter;->countCategories()I

    move-result v1

    add-int/lit8 v0, v1, -0x1

    .local v0, i:I
    :goto_8
    if-ltz v0, :cond_1b

    .line 40
    const-string v1, "android.intent.category.LAUNCHER"

    invoke-virtual {p0, v0}, Landroid/content/IntentFilter;->getCategory(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_18

    .line 41
    const/4 v1, 0x1

    .line 45
    .end local v0           #i:I
    :goto_17
    return v1

    .line 39
    .restart local v0       #i:I
    :cond_18
    add-int/lit8 v0, v0, -0x1

    goto :goto_8

    .line 45
    .end local v0           #i:I
    :cond_1b
    const/4 v1, 0x0

    goto :goto_17
.end method

.method public static needRestartActivity(Ljava/lang/String;ILandroid/content/res/Configuration;)Z
    .registers 5
    .parameter "packageName"
    .parameter "changes"
    .parameter "config"

    .prologue
    .line 118
    const/high16 v0, -0x8000

    if-ne p1, v0, :cond_16

    .line 119
    invoke-static {p0}, Lmiui/content/res/ExtraConfiguration;->removeNeedRestartActivity(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_16

    iget-object v0, p2, Landroid/content/res/Configuration;->extraConfig:Lmiui/content/res/ExtraConfiguration;

    iget-wide v0, v0, Lmiui/content/res/ExtraConfiguration;->themeChangedFlags:J

    invoke-static {p0, v0, v1}, Lmiui/content/res/ExtraConfiguration;->needRestartActivity(Ljava/lang/String;J)Z

    move-result v0

    if-nez v0, :cond_16

    .line 121
    const/4 v0, 0x1

    .line 124
    :goto_15
    return v0

    :cond_16
    const/4 v0, 0x0

    goto :goto_15
.end method

.method public static parseDimension(Ljava/lang/String;)Ljava/lang/Integer;
    .registers 16
    .parameter "value"

    .prologue
    .line 128
    const/4 v8, -0x4

    .line 129
    .local v8, intPos:I
    const/4 v2, -0x3

    .line 130
    .local v2, dotPos:I
    const/4 v6, -0x2

    .line 131
    .local v6, fractionPos:I
    const/4 v11, -0x1

    .line 132
    .local v11, unitPos:I
    const/4 v7, 0x0

    .local v7, i:I
    :goto_5
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v13

    if-ge v7, v13, :cond_3b

    .line 133
    invoke-virtual {p0, v7}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 134
    .local v0, c:C
    const/4 v13, -0x4

    if-ne v8, v13, :cond_1b

    const/16 v13, 0x30

    if-lt v0, v13, :cond_1b

    const/16 v13, 0x39

    if-gt v0, v13, :cond_1b

    .line 135
    move v8, v7

    .line 137
    :cond_1b
    const/4 v13, -0x3

    if-ne v2, v13, :cond_23

    const/16 v13, 0x2e

    if-ne v0, v13, :cond_23

    .line 138
    move v2, v7

    .line 140
    :cond_23
    const/4 v13, -0x3

    if-eq v2, v13, :cond_2f

    const/16 v13, 0x30

    if-lt v0, v13, :cond_2f

    const/16 v13, 0x39

    if-gt v0, v13, :cond_2f

    .line 141
    move v6, v7

    .line 143
    :cond_2f
    const/4 v13, -0x1

    if-ne v11, v13, :cond_96

    const/16 v13, 0x61

    if-lt v0, v13, :cond_96

    const/16 v13, 0x7a

    if-gt v0, v13, :cond_96

    .line 144
    move v11, v7

    .line 148
    .end local v0           #c:C
    :cond_3b
    const/4 v4, 0x0

    .line 149
    .local v4, f:F
    const/4 v5, 0x0

    .line 150
    .local v5, fraction:I
    const/4 v12, 0x0

    .line 151
    .local v12, unitType:I
    const/4 v9, 0x0

    .line 153
    .local v9, mantissaShift:I
    const/4 v13, -0x1

    if-eq v11, v13, :cond_fc

    if-ge v2, v6, :cond_fc

    if-ge v6, v11, :cond_fc

    .line 155
    const/4 v13, 0x0

    :try_start_47
    invoke-virtual {p0, v13, v11}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v13

    invoke-static {v13}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F
    :try_end_4e
    .catch Ljava/lang/NumberFormatException; {:try_start_47 .. :try_end_4e} :catch_9a

    move-result v4

    .line 159
    const/4 v13, -0x3

    if-eq v2, v13, :cond_5d

    const/4 v13, -0x2

    if-eq v6, v13, :cond_5d

    .line 161
    :try_start_55
    invoke-virtual {p0, v6, v11}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v13

    invoke-static {v13}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_5c
    .catch Ljava/lang/NumberFormatException; {:try_start_55 .. :try_end_5c} :catch_9d

    move-result v5

    .line 166
    :cond_5d
    const/16 v13, 0x100

    if-ge v5, v13, :cond_a0

    .line 167
    const/high16 v13, 0x4380

    mul-float/2addr v4, v13

    .line 178
    :cond_64
    :goto_64
    invoke-virtual {p0, v11}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v10

    .line 179
    .local v10, unit:Ljava/lang/String;
    const-string/jumbo v13, "px"

    invoke-virtual {v10, v13}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v13

    if-eqz v13, :cond_bc

    .line 180
    const/4 v12, 0x0

    .line 195
    :goto_72
    float-to-int v13, v4

    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    .line 196
    .local v1, complex:Ljava/lang/Integer;
    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v13

    and-int/lit16 v13, v13, -0x100

    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    .line 197
    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v13

    shl-int/lit8 v14, v9, 0x4

    or-int/2addr v13, v14

    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    .line 198
    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v13

    or-int/2addr v13, v12

    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    .line 202
    .end local v1           #complex:Ljava/lang/Integer;
    .end local v10           #unit:Ljava/lang/String;
    :goto_95
    return-object v1

    .line 132
    .end local v4           #f:F
    .end local v5           #fraction:I
    .end local v9           #mantissaShift:I
    .end local v12           #unitType:I
    .restart local v0       #c:C
    :cond_96
    add-int/lit8 v7, v7, 0x1

    goto/16 :goto_5

    .line 156
    .end local v0           #c:C
    .restart local v4       #f:F
    .restart local v5       #fraction:I
    .restart local v9       #mantissaShift:I
    .restart local v12       #unitType:I
    :catch_9a
    move-exception v3

    .line 157
    .local v3, e:Ljava/lang/NumberFormatException;
    const/4 v1, 0x0

    goto :goto_95

    .line 162
    .end local v3           #e:Ljava/lang/NumberFormatException;
    :catch_9d
    move-exception v3

    .line 163
    .restart local v3       #e:Ljava/lang/NumberFormatException;
    const/4 v1, 0x0

    goto :goto_95

    .line 168
    .end local v3           #e:Ljava/lang/NumberFormatException;
    :cond_a0
    const v13, 0x8000

    if-ge v5, v13, :cond_aa

    .line 169
    const/high16 v13, 0x4700

    mul-float/2addr v4, v13

    .line 170
    const/4 v9, 0x1

    goto :goto_64

    .line 171
    :cond_aa
    const/high16 v13, 0x4000

    if-ge v5, v13, :cond_b3

    .line 172
    const/high16 v13, 0x4e80

    mul-float/2addr v4, v13

    .line 173
    const/4 v9, 0x2

    goto :goto_64

    .line 174
    :cond_b3
    const/high16 v13, 0x20

    if-ge v5, v13, :cond_64

    .line 175
    const/high16 v13, 0x4a00

    mul-float/2addr v4, v13

    .line 176
    const/4 v9, 0x3

    goto :goto_64

    .line 181
    .restart local v10       #unit:Ljava/lang/String;
    :cond_bc
    const-string v13, "dp"

    invoke-virtual {v10, v13}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v13

    if-nez v13, :cond_cc

    const-string v13, "dip"

    invoke-virtual {v10, v13}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v13

    if-eqz v13, :cond_ce

    .line 182
    :cond_cc
    const/4 v12, 0x1

    goto :goto_72

    .line 183
    :cond_ce
    const-string/jumbo v13, "sp"

    invoke-virtual {v10, v13}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v13

    if-eqz v13, :cond_d9

    .line 184
    const/4 v12, 0x2

    goto :goto_72

    .line 185
    :cond_d9
    const-string/jumbo v13, "pt"

    invoke-virtual {v10, v13}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v13

    if-eqz v13, :cond_e4

    .line 186
    const/4 v12, 0x3

    goto :goto_72

    .line 187
    :cond_e4
    const-string v13, "in"

    invoke-virtual {v10, v13}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v13

    if-eqz v13, :cond_ee

    .line 188
    const/4 v12, 0x4

    goto :goto_72

    .line 189
    :cond_ee
    const-string/jumbo v13, "mm"

    invoke-virtual {v10, v13}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v13

    if-eqz v13, :cond_fa

    .line 190
    const/4 v12, 0x5

    goto/16 :goto_72

    .line 192
    :cond_fa
    const/4 v1, 0x0

    goto :goto_95

    .line 200
    .end local v10           #unit:Ljava/lang/String;
    :cond_fc
    const/4 v1, 0x0

    goto :goto_95
.end method
