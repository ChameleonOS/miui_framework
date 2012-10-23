.class public Landroid/widget/AppSecurityPermissions;
.super Ljava/lang/Object;
.source "AppSecurityPermissions.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/widget/AppSecurityPermissions$1;,
        Landroid/widget/AppSecurityPermissions$PermissionInfoComparator;,
        Landroid/widget/AppSecurityPermissions$State;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "AppSecurityPermissions"


# instance fields
.field private localLOGV:Z

.field private mContext:Landroid/content/Context;

.field private mCurrentState:Landroid/widget/AppSecurityPermissions$State;

.field private mDangerousIcon:Landroid/graphics/drawable/Drawable;

.field private mDangerousList:Landroid/widget/LinearLayout;

.field private mDangerousMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mDefaultGrpLabel:Ljava/lang/String;

.field private mDefaultGrpName:Ljava/lang/String;

.field private mExpanded:Z

.field private mGroupLabelCache:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/CharSequence;",
            ">;"
        }
    .end annotation
.end field

.field private mInflater:Landroid/view/LayoutInflater;

.field private mNoPermsView:Landroid/view/View;

.field private mNonDangerousList:Landroid/widget/LinearLayout;

.field private mNormalIcon:Landroid/graphics/drawable/Drawable;

.field private mNormalMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mPermFormat:Ljava/lang/String;

.field private mPermsList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/content/pm/PermissionInfo;",
            ">;"
        }
    .end annotation
.end field

.field private mPermsView:Landroid/widget/LinearLayout;

.field private mPm:Landroid/content/pm/PackageManager;

.field private mShowMaxIcon:Landroid/graphics/drawable/Drawable;

.field private mShowMinIcon:Landroid/graphics/drawable/Drawable;

.field private mShowMore:Landroid/view/View;

.field private mShowMoreIcon:Landroid/widget/ImageView;

.field private mShowMoreText:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/content/pm/PackageParser$Package;)V
    .registers 13
    .parameter "context"
    .parameter "pkg"

    .prologue
    .line 117
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 65
    const/4 v7, 0x0

    iput-boolean v7, p0, Landroid/widget/AppSecurityPermissions;->localLOGV:Z

    .line 74
    const-string v7, "DefaultGrp"

    iput-object v7, p0, Landroid/widget/AppSecurityPermissions;->mDefaultGrpName:Ljava/lang/String;

    .line 118
    iput-object p1, p0, Landroid/widget/AppSecurityPermissions;->mContext:Landroid/content/Context;

    .line 119
    iget-object v7, p0, Landroid/widget/AppSecurityPermissions;->mContext:Landroid/content/Context;

    invoke-virtual {v7}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v7

    iput-object v7, p0, Landroid/widget/AppSecurityPermissions;->mPm:Landroid/content/pm/PackageManager;

    .line 120
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    iput-object v7, p0, Landroid/widget/AppSecurityPermissions;->mPermsList:Ljava/util/List;

    .line 121
    new-instance v2, Ljava/util/HashSet;

    invoke-direct {v2}, Ljava/util/HashSet;-><init>()V

    .line 122
    .local v2, permSet:Ljava/util/Set;,"Ljava/util/Set<Landroid/content/pm/PermissionInfo;>;"
    if-nez p2, :cond_23

    .line 147
    :cond_22
    return-void

    .line 126
    :cond_23
    iget-object v7, p2, Landroid/content/pm/PackageParser$Package;->requestedPermissions:Ljava/util/ArrayList;

    if-eqz v7, :cond_3a

    .line 127
    iget-object v5, p2, Landroid/content/pm/PackageParser$Package;->requestedPermissions:Ljava/util/ArrayList;

    .line 128
    .local v5, strList:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v4

    .line 129
    .local v4, size:I
    if-lez v4, :cond_3a

    .line 130
    new-array v7, v4, [Ljava/lang/String;

    invoke-virtual {v5, v7}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v7

    check-cast v7, [Ljava/lang/String;

    invoke-direct {p0, v7, v2}, Landroid/widget/AppSecurityPermissions;->extractPerms([Ljava/lang/String;Ljava/util/Set;)V

    .line 134
    .end local v4           #size:I
    .end local v5           #strList:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/String;>;"
    :cond_3a
    iget-object v7, p2, Landroid/content/pm/PackageParser$Package;->mSharedUserId:Ljava/lang/String;

    if-eqz v7, :cond_49

    .line 137
    :try_start_3e
    iget-object v7, p0, Landroid/widget/AppSecurityPermissions;->mPm:Landroid/content/pm/PackageManager;

    iget-object v8, p2, Landroid/content/pm/PackageParser$Package;->mSharedUserId:Ljava/lang/String;

    invoke-virtual {v7, v8}, Landroid/content/pm/PackageManager;->getUidForSharedUser(Ljava/lang/String;)I

    move-result v3

    .line 138
    .local v3, sharedUid:I
    invoke-direct {p0, v3, v2}, Landroid/widget/AppSecurityPermissions;->getAllUsedPermissions(ILjava/util/Set;)V
    :try_end_49
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_3e .. :try_end_49} :catch_5f

    .line 144
    .end local v3           #sharedUid:I
    :cond_49
    :goto_49
    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, i$:Ljava/util/Iterator;
    :goto_4d
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_22

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/content/pm/PermissionInfo;

    .line 145
    .local v6, tmpInfo:Landroid/content/pm/PermissionInfo;
    iget-object v7, p0, Landroid/widget/AppSecurityPermissions;->mPermsList:Ljava/util/List;

    invoke-interface {v7, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_4d

    .line 139
    .end local v1           #i$:Ljava/util/Iterator;
    .end local v6           #tmpInfo:Landroid/content/pm/PermissionInfo;
    :catch_5f
    move-exception v0

    .line 140
    .local v0, e:Landroid/content/pm/PackageManager$NameNotFoundException;
    const-string v7, "AppSecurityPermissions"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Could\'nt retrieve shared user id for:"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    iget-object v9, p2, Landroid/content/pm/PackageParser$Package;->packageName:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_49
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .registers 11
    .parameter "context"
    .parameter "packageName"

    .prologue
    .line 96
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 65
    const/4 v5, 0x0

    iput-boolean v5, p0, Landroid/widget/AppSecurityPermissions;->localLOGV:Z

    .line 74
    const-string v5, "DefaultGrp"

    iput-object v5, p0, Landroid/widget/AppSecurityPermissions;->mDefaultGrpName:Ljava/lang/String;

    .line 97
    iput-object p1, p0, Landroid/widget/AppSecurityPermissions;->mContext:Landroid/content/Context;

    .line 98
    iget-object v5, p0, Landroid/widget/AppSecurityPermissions;->mContext:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    iput-object v5, p0, Landroid/widget/AppSecurityPermissions;->mPm:Landroid/content/pm/PackageManager;

    .line 99
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    iput-object v5, p0, Landroid/widget/AppSecurityPermissions;->mPermsList:Ljava/util/List;

    .line 100
    new-instance v2, Ljava/util/HashSet;

    invoke-direct {v2}, Ljava/util/HashSet;-><init>()V

    .line 103
    .local v2, permSet:Ljava/util/Set;,"Ljava/util/Set<Landroid/content/pm/PermissionInfo;>;"
    :try_start_20
    iget-object v5, p0, Landroid/widget/AppSecurityPermissions;->mPm:Landroid/content/pm/PackageManager;

    const/16 v6, 0x1000

    invoke-virtual {v5, p2, v6}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_27
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_20 .. :try_end_27} :catch_50

    move-result-object v3

    .line 109
    .local v3, pkgInfo:Landroid/content/pm/PackageInfo;
    iget-object v5, v3, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    if-eqz v5, :cond_3a

    iget-object v5, v3, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v5, v5, Landroid/content/pm/ApplicationInfo;->uid:I

    const/4 v6, -0x1

    if-eq v5, v6, :cond_3a

    .line 110
    iget-object v5, v3, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v5, v5, Landroid/content/pm/ApplicationInfo;->uid:I

    invoke-direct {p0, v5, v2}, Landroid/widget/AppSecurityPermissions;->getAllUsedPermissions(ILjava/util/Set;)V

    .line 112
    :cond_3a
    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, i$:Ljava/util/Iterator;
    :goto_3e
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_69

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/content/pm/PermissionInfo;

    .line 113
    .local v4, tmpInfo:Landroid/content/pm/PermissionInfo;
    iget-object v5, p0, Landroid/widget/AppSecurityPermissions;->mPermsList:Ljava/util/List;

    invoke-interface {v5, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_3e

    .line 104
    .end local v1           #i$:Ljava/util/Iterator;
    .end local v3           #pkgInfo:Landroid/content/pm/PackageInfo;
    .end local v4           #tmpInfo:Landroid/content/pm/PermissionInfo;
    :catch_50
    move-exception v0

    .line 105
    .local v0, e:Landroid/content/pm/PackageManager$NameNotFoundException;
    const-string v5, "AppSecurityPermissions"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Could\'nt retrieve permissions for package:"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 115
    .end local v0           #e:Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_69
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/util/List;)V
    .registers 4
    .parameter "context"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Landroid/content/pm/PermissionInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 90
    .local p2, permList:Ljava/util/List;,"Ljava/util/List<Landroid/content/pm/PermissionInfo;>;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 65
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/widget/AppSecurityPermissions;->localLOGV:Z

    .line 74
    const-string v0, "DefaultGrp"

    iput-object v0, p0, Landroid/widget/AppSecurityPermissions;->mDefaultGrpName:Ljava/lang/String;

    .line 91
    iput-object p1, p0, Landroid/widget/AppSecurityPermissions;->mContext:Landroid/content/Context;

    .line 92
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    iput-object v0, p0, Landroid/widget/AppSecurityPermissions;->mPm:Landroid/content/pm/PackageManager;

    .line 93
    iput-object p2, p0, Landroid/widget/AppSecurityPermissions;->mPermsList:Ljava/util/List;

    .line 94
    return-void
.end method

.method private aggregateGroupDescs(Ljava/util/Map;Ljava/util/Map;)V
    .registers 14
    .parameter
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Landroid/content/pm/PermissionInfo;",
            ">;>;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 391
    .local p1, map:Ljava/util/Map;,"Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Landroid/content/pm/PermissionInfo;>;>;"
    .local p2, retMap:Ljava/util/Map;,"Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-nez p1, :cond_3

    .line 416
    :cond_2
    return-void

    .line 394
    :cond_3
    if-eqz p2, :cond_2

    .line 397
    invoke-interface {p1}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v2

    .line 398
    .local v2, grpNames:Ljava/util/Set;,"Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .line 399
    .local v3, grpNamesIter:Ljava/util/Iterator;,"Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_d
    :goto_d
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_2

    .line 400
    const/4 v0, 0x0

    .line 401
    .local v0, grpDesc:Ljava/lang/String;
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 402
    .local v1, grpNameKey:Ljava/lang/String;
    invoke-interface {p1, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    .line 403
    .local v4, grpPermsList:Ljava/util/List;,"Ljava/util/List<Landroid/content/pm/PermissionInfo;>;"
    if-eqz v4, :cond_d

    .line 406
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .local v5, i$:Ljava/util/Iterator;
    :goto_26
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_3d

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/content/pm/PermissionInfo;

    .line 407
    .local v7, permInfo:Landroid/content/pm/PermissionInfo;
    iget-object v8, p0, Landroid/widget/AppSecurityPermissions;->mPm:Landroid/content/pm/PackageManager;

    invoke-virtual {v7, v8}, Landroid/content/pm/PermissionInfo;->loadLabel(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;

    move-result-object v6

    .line 408
    .local v6, permDesc:Ljava/lang/CharSequence;
    invoke-direct {p0, v0, v6}, Landroid/widget/AppSecurityPermissions;->formatPermissions(Ljava/lang/String;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 409
    goto :goto_26

    .line 411
    .end local v6           #permDesc:Ljava/lang/CharSequence;
    .end local v7           #permInfo:Landroid/content/pm/PermissionInfo;
    :cond_3d
    if-eqz v0, :cond_d

    .line 412
    iget-boolean v8, p0, Landroid/widget/AppSecurityPermissions;->localLOGV:Z

    if-eqz v8, :cond_69

    const-string v8, "AppSecurityPermissions"

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Group:"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, " description:"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 413
    :cond_69
    invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-interface {p2, v1, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_d
.end method

.method private canonicalizeGroupDesc(Ljava/lang/String;)Ljava/lang/String;
    .registers 5
    .parameter "groupDesc"

    .prologue
    .line 241
    if-eqz p1, :cond_8

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_a

    .line 242
    :cond_8
    const/4 v1, 0x0

    .line 249
    :goto_9
    return-object v1

    .line 245
    :cond_a
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    .line 246
    .local v0, len:I
    add-int/lit8 v1, v0, -0x1

    invoke-virtual {p1, v1}, Ljava/lang/String;->charAt(I)C

    move-result v1

    const/16 v2, 0x2e

    if-ne v1, v2, :cond_1f

    .line 247
    const/4 v1, 0x0

    add-int/lit8 v2, v0, -0x1

    invoke-virtual {p1, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p1

    :cond_1f
    move-object v1, p1

    .line 249
    goto :goto_9
.end method

.method private displayNoPermissions()V
    .registers 3

    .prologue
    .line 316
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mNoPermsView:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 317
    return-void
.end method

.method private displayPermissions(Z)V
    .registers 11
    .parameter "dangerous"

    .prologue
    .line 299
    if-eqz p1, :cond_5d

    iget-object v3, p0, Landroid/widget/AppSecurityPermissions;->mDangerousMap:Ljava/util/Map;

    .line 300
    .local v3, permInfoMap:Ljava/util/Map;,"Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :goto_4
    if-eqz p1, :cond_60

    iget-object v5, p0, Landroid/widget/AppSecurityPermissions;->mDangerousList:Landroid/widget/LinearLayout;

    .line 301
    .local v5, permListView:Landroid/widget/LinearLayout;
    :goto_8
    invoke-virtual {v5}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 303
    invoke-interface {v3}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v4

    .line 304
    .local v4, permInfoStrSet:Ljava/util/Set;,"Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, i$:Ljava/util/Iterator;
    :goto_13
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_63

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 305
    .local v2, loopPermGrpInfoStr:Ljava/lang/String;
    invoke-direct {p0, v2}, Landroid/widget/AppSecurityPermissions;->getGroupLabel(Ljava/lang/String;)Ljava/lang/CharSequence;

    move-result-object v0

    .line 308
    .local v0, grpLabel:Ljava/lang/CharSequence;
    iget-boolean v6, p0, Landroid/widget/AppSecurityPermissions;->localLOGV:Z

    if-eqz v6, :cond_4f

    const-string v7, "AppSecurityPermissions"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Adding view group:"

    invoke-virtual {v6, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v8, ", desc:"

    invoke-virtual {v6, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-interface {v3, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-virtual {v8, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v7, v6}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 310
    :cond_4f
    invoke-interface {v3, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/CharSequence;

    invoke-direct {p0, v0, v6, p1}, Landroid/widget/AppSecurityPermissions;->getPermissionItemView(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Landroid/view/View;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    goto :goto_13

    .line 299
    .end local v0           #grpLabel:Ljava/lang/CharSequence;
    .end local v1           #i$:Ljava/util/Iterator;
    .end local v2           #loopPermGrpInfoStr:Ljava/lang/String;
    .end local v3           #permInfoMap:Ljava/util/Map;,"Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v4           #permInfoStrSet:Ljava/util/Set;,"Ljava/util/Set<Ljava/lang/String;>;"
    .end local v5           #permListView:Landroid/widget/LinearLayout;
    :cond_5d
    iget-object v3, p0, Landroid/widget/AppSecurityPermissions;->mNormalMap:Ljava/util/Map;

    goto :goto_4

    .line 300
    .restart local v3       #permInfoMap:Ljava/util/Map;,"Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_60
    iget-object v5, p0, Landroid/widget/AppSecurityPermissions;->mNonDangerousList:Landroid/widget/LinearLayout;

    goto :goto_8

    .line 313
    .restart local v1       #i$:Ljava/util/Iterator;
    .restart local v4       #permInfoStrSet:Ljava/util/Set;,"Ljava/util/Set<Ljava/lang/String;>;"
    .restart local v5       #permListView:Landroid/widget/LinearLayout;
    :cond_63
    return-void
.end method

.method private extractPerms([Ljava/lang/String;Ljava/util/Set;)V
    .registers 12
    .parameter "strList"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/String;",
            "Ljava/util/Set",
            "<",
            "Landroid/content/pm/PermissionInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 187
    .local p2, permSet:Ljava/util/Set;,"Ljava/util/Set<Landroid/content/pm/PermissionInfo;>;"
    if-eqz p1, :cond_5

    array-length v6, p1

    if-nez v6, :cond_6

    .line 200
    :cond_5
    return-void

    .line 190
    :cond_6
    move-object v0, p1

    .local v0, arr$:[Ljava/lang/String;
    array-length v3, v0

    .local v3, len$:I
    const/4 v2, 0x0

    .local v2, i$:I
    :goto_9
    if-ge v2, v3, :cond_5

    aget-object v4, v0, v2

    .line 192
    .local v4, permName:Ljava/lang/String;
    :try_start_d
    iget-object v6, p0, Landroid/widget/AppSecurityPermissions;->mPm:Landroid/content/pm/PackageManager;

    const/4 v7, 0x0

    invoke-virtual {v6, v4, v7}, Landroid/content/pm/PackageManager;->getPermissionInfo(Ljava/lang/String;I)Landroid/content/pm/PermissionInfo;

    move-result-object v5

    .line 193
    .local v5, tmpPermInfo:Landroid/content/pm/PermissionInfo;
    if-eqz v5, :cond_19

    .line 194
    invoke-interface {p2, v5}, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    :try_end_19
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_d .. :try_end_19} :catch_1c

    .line 190
    .end local v5           #tmpPermInfo:Landroid/content/pm/PermissionInfo;
    :cond_19
    :goto_19
    add-int/lit8 v2, v2, 0x1

    goto :goto_9

    .line 196
    :catch_1c
    move-exception v1

    .line 197
    .local v1, e:Landroid/content/pm/PackageManager$NameNotFoundException;
    const-string v6, "AppSecurityPermissions"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Ignoring unknown permission:"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_19
.end method

.method private formatPermissions(Ljava/lang/String;Ljava/lang/CharSequence;)Ljava/lang/String;
    .registers 7
    .parameter "groupDesc"
    .parameter "permDesc"

    .prologue
    .line 259
    if-nez p1, :cond_b

    .line 260
    if-nez p2, :cond_6

    .line 261
    const/4 v0, 0x0

    .line 270
    :goto_5
    return-object v0

    .line 263
    :cond_6
    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_5

    .line 265
    :cond_b
    invoke-direct {p0, p1}, Landroid/widget/AppSecurityPermissions;->canonicalizeGroupDesc(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .line 266
    if-nez p2, :cond_13

    move-object v0, p1

    .line 267
    goto :goto_5

    .line 270
    :cond_13
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mPermFormat:Ljava/lang/String;

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    const/4 v2, 0x1

    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_5
.end method

.method private getAllUsedPermissions(ILjava/util/Set;)V
    .registers 9
    .parameter "sharedUid"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/Set",
            "<",
            "Landroid/content/pm/PermissionInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 163
    .local p2, permSet:Ljava/util/Set;,"Ljava/util/Set<Landroid/content/pm/PermissionInfo;>;"
    iget-object v5, p0, Landroid/widget/AppSecurityPermissions;->mPm:Landroid/content/pm/PackageManager;

    invoke-virtual {v5, p1}, Landroid/content/pm/PackageManager;->getPackagesForUid(I)[Ljava/lang/String;

    move-result-object v4

    .line 164
    .local v4, sharedPkgList:[Ljava/lang/String;
    if-eqz v4, :cond_b

    array-length v5, v4

    if-nez v5, :cond_c

    .line 170
    :cond_b
    return-void

    .line 167
    :cond_c
    move-object v0, v4

    .local v0, arr$:[Ljava/lang/String;
    array-length v2, v0

    .local v2, len$:I
    const/4 v1, 0x0

    .local v1, i$:I
    :goto_f
    if-ge v1, v2, :cond_b

    aget-object v3, v0, v1

    .line 168
    .local v3, sharedPkg:Ljava/lang/String;
    invoke-direct {p0, v3, p2}, Landroid/widget/AppSecurityPermissions;->getPermissionsForPackage(Ljava/lang/String;Ljava/util/Set;)V

    .line 167
    add-int/lit8 v1, v1, 0x1

    goto :goto_f
.end method

.method private getGroupLabel(Ljava/lang/String;)Ljava/lang/CharSequence;
    .registers 9
    .parameter "grpName"

    .prologue
    .line 274
    if-nez p1, :cond_5

    .line 276
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mDefaultGrpLabel:Ljava/lang/String;

    .line 291
    :cond_4
    :goto_4
    return-object v0

    .line 278
    :cond_5
    iget-object v4, p0, Landroid/widget/AppSecurityPermissions;->mGroupLabelCache:Ljava/util/HashMap;

    invoke-virtual {v4, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    .line 279
    .local v0, cachedLabel:Ljava/lang/CharSequence;
    if-nez v0, :cond_4

    .line 284
    :try_start_f
    iget-object v4, p0, Landroid/widget/AppSecurityPermissions;->mPm:Landroid/content/pm/PackageManager;

    const/4 v5, 0x0

    invoke-virtual {v4, p1, v5}, Landroid/content/pm/PackageManager;->getPermissionGroupInfo(Ljava/lang/String;I)Landroid/content/pm/PermissionGroupInfo;
    :try_end_15
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_f .. :try_end_15} :catch_27

    move-result-object v3

    .line 289
    .local v3, pgi:Landroid/content/pm/PermissionGroupInfo;
    iget-object v4, p0, Landroid/widget/AppSecurityPermissions;->mPm:Landroid/content/pm/PackageManager;

    invoke-virtual {v3, v4}, Landroid/content/pm/PermissionGroupInfo;->loadLabel(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    .line 290
    .local v2, label:Ljava/lang/CharSequence;
    iget-object v4, p0, Landroid/widget/AppSecurityPermissions;->mGroupLabelCache:Ljava/util/HashMap;

    invoke-virtual {v4, p1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-object v0, v2

    .line 291
    goto :goto_4

    .line 285
    .end local v2           #label:Ljava/lang/CharSequence;
    .end local v3           #pgi:Landroid/content/pm/PermissionGroupInfo;
    :catch_27
    move-exception v1

    .line 286
    .local v1, e:Landroid/content/pm/PackageManager$NameNotFoundException;
    const-string v4, "AppSecurityPermissions"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Invalid group name:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 287
    const/4 v0, 0x0

    goto :goto_4
.end method

.method private static getPermissionItemView(Landroid/content/Context;Landroid/view/LayoutInflater;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLandroid/graphics/drawable/Drawable;)Landroid/view/View;
    .registers 12
    .parameter "context"
    .parameter "inflater"
    .parameter "grpName"
    .parameter "permList"
    .parameter "dangerous"
    .parameter "icon"

    .prologue
    .line 327
    const v4, 0x1090029

    const/4 v5, 0x0

    invoke-virtual {p1, v4, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    .line 329
    .local v3, permView:Landroid/view/View;
    const v4, 0x102025e

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 330
    .local v2, permGrpView:Landroid/widget/TextView;
    const v4, 0x102025f

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 332
    .local v1, permDescView:Landroid/widget/TextView;
    const v4, 0x102025d

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 333
    .local v0, imgView:Landroid/widget/ImageView;
    invoke-virtual {v0, p5}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 334
    if-eqz p2, :cond_2f

    .line 335
    invoke-virtual {v2, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 336
    invoke-virtual {v1, p3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 341
    :goto_2e
    return-object v3

    .line 338
    :cond_2f
    invoke-virtual {v2, p3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 339
    const/16 v4, 0x8

    invoke-virtual {v1, v4}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_2e
.end method

.method public static getPermissionItemView(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Landroid/view/View;
    .registers 10
    .parameter "context"
    .parameter "grpName"
    .parameter "description"
    .parameter "dangerous"

    .prologue
    .line 154
    const-string v0, "layout_inflater"

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/LayoutInflater;

    .line 156
    .local v1, inflater:Landroid/view/LayoutInflater;
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    if-eqz p3, :cond_1e

    const v0, 0x10802b3

    :goto_11
    invoke-virtual {v2, v0}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    .local v5, icon:Landroid/graphics/drawable/Drawable;
    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move v4, p3

    .line 158
    invoke-static/range {v0 .. v5}, Landroid/widget/AppSecurityPermissions;->getPermissionItemView(Landroid/content/Context;Landroid/view/LayoutInflater;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLandroid/graphics/drawable/Drawable;)Landroid/view/View;

    move-result-object v0

    return-object v0

    .line 156
    .end local v5           #icon:Landroid/graphics/drawable/Drawable;
    :cond_1e
    const v0, 0x108035c

    goto :goto_11
.end method

.method private getPermissionItemView(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Landroid/view/View;
    .registers 10
    .parameter "grpName"
    .parameter "permList"
    .parameter "dangerous"

    .prologue
    .line 321
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mContext:Landroid/content/Context;

    iget-object v1, p0, Landroid/widget/AppSecurityPermissions;->mInflater:Landroid/view/LayoutInflater;

    if-eqz p3, :cond_10

    iget-object v5, p0, Landroid/widget/AppSecurityPermissions;->mDangerousIcon:Landroid/graphics/drawable/Drawable;

    :goto_8
    move-object v2, p1

    move-object v3, p2

    move v4, p3

    invoke-static/range {v0 .. v5}, Landroid/widget/AppSecurityPermissions;->getPermissionItemView(Landroid/content/Context;Landroid/view/LayoutInflater;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLandroid/graphics/drawable/Drawable;)Landroid/view/View;

    move-result-object v0

    return-object v0

    :cond_10
    iget-object v5, p0, Landroid/widget/AppSecurityPermissions;->mNormalIcon:Landroid/graphics/drawable/Drawable;

    goto :goto_8
.end method

.method private getPermissionsForPackage(Ljava/lang/String;Ljava/util/Set;)V
    .registers 8
    .parameter "packageName"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Set",
            "<",
            "Landroid/content/pm/PermissionInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 176
    .local p2, permSet:Ljava/util/Set;,"Ljava/util/Set<Landroid/content/pm/PermissionInfo;>;"
    :try_start_0
    iget-object v2, p0, Landroid/widget/AppSecurityPermissions;->mPm:Landroid/content/pm/PackageManager;

    const/16 v3, 0x1000

    invoke-virtual {v2, p1, v3}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_7
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_7} :catch_14

    move-result-object v1

    .line 181
    .local v1, pkgInfo:Landroid/content/pm/PackageInfo;
    if-eqz v1, :cond_13

    iget-object v2, v1, Landroid/content/pm/PackageInfo;->requestedPermissions:[Ljava/lang/String;

    if-eqz v2, :cond_13

    .line 182
    iget-object v2, v1, Landroid/content/pm/PackageInfo;->requestedPermissions:[Ljava/lang/String;

    invoke-direct {p0, v2, p2}, Landroid/widget/AppSecurityPermissions;->extractPerms([Ljava/lang/String;Ljava/util/Set;)V

    .line 184
    .end local v1           #pkgInfo:Landroid/content/pm/PackageInfo;
    :cond_13
    :goto_13
    return-void

    .line 177
    :catch_14
    move-exception v0

    .line 178
    .local v0, e:Landroid/content/pm/PackageManager$NameNotFoundException;
    const-string v2, "AppSecurityPermissions"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Could\'nt retrieve permissions for package:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_13
.end method

.method private isDisplayablePermission(Landroid/content/pm/PermissionInfo;)Z
    .registers 4
    .parameter "pInfo"

    .prologue
    const/4 v0, 0x1

    .line 377
    iget v1, p1, Landroid/content/pm/PermissionInfo;->protectionLevel:I

    if-eq v1, v0, :cond_9

    iget v1, p1, Landroid/content/pm/PermissionInfo;->protectionLevel:I

    if-nez v1, :cond_a

    .line 381
    :cond_9
    :goto_9
    return v0

    :cond_a
    const/4 v0, 0x0

    goto :goto_9
.end method

.method private setPermissions(Ljava/util/List;)V
    .registers 14
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Landroid/content/pm/PermissionInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 432
    .local p1, permList:Ljava/util/List;,"Ljava/util/List<Landroid/content/pm/PermissionInfo;>;"
    new-instance v9, Ljava/util/HashMap;

    invoke-direct {v9}, Ljava/util/HashMap;-><init>()V

    iput-object v9, p0, Landroid/widget/AppSecurityPermissions;->mGroupLabelCache:Ljava/util/HashMap;

    .line 434
    iget-object v9, p0, Landroid/widget/AppSecurityPermissions;->mGroupLabelCache:Ljava/util/HashMap;

    iget-object v10, p0, Landroid/widget/AppSecurityPermissions;->mDefaultGrpName:Ljava/lang/String;

    iget-object v11, p0, Landroid/widget/AppSecurityPermissions;->mDefaultGrpLabel:Ljava/lang/String;

    invoke-virtual {v9, v10, v11}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 438
    new-instance v9, Ljava/util/HashMap;

    invoke-direct {v9}, Ljava/util/HashMap;-><init>()V

    iput-object v9, p0, Landroid/widget/AppSecurityPermissions;->mDangerousMap:Ljava/util/Map;

    .line 441
    new-instance v9, Ljava/util/HashMap;

    invoke-direct {v9}, Ljava/util/HashMap;-><init>()V

    iput-object v9, p0, Landroid/widget/AppSecurityPermissions;->mNormalMap:Ljava/util/Map;

    .line 445
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 447
    .local v0, dangerousMap:Ljava/util/Map;,"Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Landroid/content/pm/PermissionInfo;>;>;"
    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    .line 449
    .local v5, normalMap:Ljava/util/Map;,"Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Landroid/content/pm/PermissionInfo;>;>;"
    new-instance v7, Landroid/widget/AppSecurityPermissions$PermissionInfoComparator;

    iget-object v9, p0, Landroid/widget/AppSecurityPermissions;->mPm:Landroid/content/pm/PackageManager;

    invoke-direct {v7, v9}, Landroid/widget/AppSecurityPermissions$PermissionInfoComparator;-><init>(Landroid/content/pm/PackageManager;)V

    .line 451
    .local v7, permComparator:Landroid/widget/AppSecurityPermissions$PermissionInfoComparator;
    if-eqz p1, :cond_11a

    .line 453
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, i$:Ljava/util/Iterator;
    :cond_35
    :goto_35
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_110

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/content/pm/PermissionInfo;

    .line 454
    .local v6, pInfo:Landroid/content/pm/PermissionInfo;
    iget-boolean v9, p0, Landroid/widget/AppSecurityPermissions;->localLOGV:Z

    if-eqz v9, :cond_5f

    const-string v9, "AppSecurityPermissions"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Processing permission:"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    iget-object v11, v6, Landroid/content/pm/PackageItemInfo;->name:Ljava/lang/String;

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 455
    :cond_5f
    invoke-direct {p0, v6}, Landroid/widget/AppSecurityPermissions;->isDisplayablePermission(Landroid/content/pm/PermissionInfo;)Z

    move-result v9

    if-nez v9, :cond_8a

    .line 456
    iget-boolean v9, p0, Landroid/widget/AppSecurityPermissions;->localLOGV:Z

    if-eqz v9, :cond_35

    const-string v9, "AppSecurityPermissions"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Permission:"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    iget-object v11, v6, Landroid/content/pm/PackageItemInfo;->name:Ljava/lang/String;

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, " is not displayable"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_35

    .line 459
    :cond_8a
    iget v9, v6, Landroid/content/pm/PermissionInfo;->protectionLevel:I

    const/4 v10, 0x1

    if-ne v9, v10, :cond_d3

    move-object v8, v0

    .line 462
    .local v8, permInfoMap:Ljava/util/Map;,"Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Landroid/content/pm/PermissionInfo;>;>;"
    :goto_90
    iget-object v9, v6, Landroid/content/pm/PermissionInfo;->group:Ljava/lang/String;

    if-nez v9, :cond_d5

    iget-object v1, p0, Landroid/widget/AppSecurityPermissions;->mDefaultGrpName:Ljava/lang/String;

    .line 463
    .local v1, grpName:Ljava/lang/String;
    :goto_96
    iget-boolean v9, p0, Landroid/widget/AppSecurityPermissions;->localLOGV:Z

    if-eqz v9, :cond_be

    const-string v9, "AppSecurityPermissions"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Permission:"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    iget-object v11, v6, Landroid/content/pm/PackageItemInfo;->name:Ljava/lang/String;

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, " belongs to group:"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 464
    :cond_be
    invoke-interface {v8, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/List;

    .line 465
    .local v2, grpPermsList:Ljava/util/List;,"Ljava/util/List<Landroid/content/pm/PermissionInfo;>;"
    if-nez v2, :cond_d8

    .line 466
    new-instance v2, Ljava/util/ArrayList;

    .end local v2           #grpPermsList:Ljava/util/List;,"Ljava/util/List<Landroid/content/pm/PermissionInfo;>;"
    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 467
    .restart local v2       #grpPermsList:Ljava/util/List;,"Ljava/util/List<Landroid/content/pm/PermissionInfo;>;"
    invoke-interface {v8, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 468
    invoke-interface {v2, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_35

    .end local v1           #grpName:Ljava/lang/String;
    .end local v2           #grpPermsList:Ljava/util/List;,"Ljava/util/List<Landroid/content/pm/PermissionInfo;>;"
    .end local v8           #permInfoMap:Ljava/util/Map;,"Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Landroid/content/pm/PermissionInfo;>;>;"
    :cond_d3
    move-object v8, v5

    .line 459
    goto :goto_90

    .line 462
    .restart local v8       #permInfoMap:Ljava/util/Map;,"Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Landroid/content/pm/PermissionInfo;>;>;"
    :cond_d5
    iget-object v1, v6, Landroid/content/pm/PermissionInfo;->group:Ljava/lang/String;

    goto :goto_96

    .line 470
    .restart local v1       #grpName:Ljava/lang/String;
    .restart local v2       #grpPermsList:Ljava/util/List;,"Ljava/util/List<Landroid/content/pm/PermissionInfo;>;"
    :cond_d8
    invoke-static {v2, v6, v7}, Ljava/util/Collections;->binarySearch(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;)I

    move-result v4

    .line 471
    .local v4, idx:I
    iget-boolean v9, p0, Landroid/widget/AppSecurityPermissions;->localLOGV:Z

    if-eqz v9, :cond_106

    const-string v9, "AppSecurityPermissions"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "idx="

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, ", list.size="

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 472
    :cond_106
    if-gez v4, :cond_35

    .line 473
    neg-int v9, v4

    add-int/lit8 v4, v9, -0x1

    .line 474
    invoke-interface {v2, v4, v6}, Ljava/util/List;->add(ILjava/lang/Object;)V

    goto/16 :goto_35

    .line 480
    .end local v1           #grpName:Ljava/lang/String;
    .end local v2           #grpPermsList:Ljava/util/List;,"Ljava/util/List<Landroid/content/pm/PermissionInfo;>;"
    .end local v4           #idx:I
    .end local v6           #pInfo:Landroid/content/pm/PermissionInfo;
    .end local v8           #permInfoMap:Ljava/util/Map;,"Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Landroid/content/pm/PermissionInfo;>;>;"
    :cond_110
    iget-object v9, p0, Landroid/widget/AppSecurityPermissions;->mDangerousMap:Ljava/util/Map;

    invoke-direct {p0, v0, v9}, Landroid/widget/AppSecurityPermissions;->aggregateGroupDescs(Ljava/util/Map;Ljava/util/Map;)V

    .line 481
    iget-object v9, p0, Landroid/widget/AppSecurityPermissions;->mNormalMap:Ljava/util/Map;

    invoke-direct {p0, v5, v9}, Landroid/widget/AppSecurityPermissions;->aggregateGroupDescs(Ljava/util/Map;Ljava/util/Map;)V

    .line 484
    .end local v3           #i$:Ljava/util/Iterator;
    :cond_11a
    sget-object v9, Landroid/widget/AppSecurityPermissions$State;->NO_PERMS:Landroid/widget/AppSecurityPermissions$State;

    iput-object v9, p0, Landroid/widget/AppSecurityPermissions;->mCurrentState:Landroid/widget/AppSecurityPermissions$State;

    .line 485
    iget-object v9, p0, Landroid/widget/AppSecurityPermissions;->mDangerousMap:Ljava/util/Map;

    invoke-interface {v9}, Ljava/util/Map;->size()I

    move-result v9

    if-lez v9, :cond_158

    .line 486
    iget-object v9, p0, Landroid/widget/AppSecurityPermissions;->mNormalMap:Ljava/util/Map;

    invoke-interface {v9}, Ljava/util/Map;->size()I

    move-result v9

    if-lez v9, :cond_155

    sget-object v9, Landroid/widget/AppSecurityPermissions$State;->BOTH:Landroid/widget/AppSecurityPermissions$State;

    :goto_130
    iput-object v9, p0, Landroid/widget/AppSecurityPermissions;->mCurrentState:Landroid/widget/AppSecurityPermissions$State;

    .line 490
    :cond_132
    :goto_132
    iget-boolean v9, p0, Landroid/widget/AppSecurityPermissions;->localLOGV:Z

    if-eqz v9, :cond_151

    const-string v9, "AppSecurityPermissions"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v11, "mCurrentState="

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    iget-object v11, p0, Landroid/widget/AppSecurityPermissions;->mCurrentState:Landroid/widget/AppSecurityPermissions$State;

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 491
    :cond_151
    invoke-direct {p0}, Landroid/widget/AppSecurityPermissions;->showPermissions()V

    .line 492
    return-void

    .line 486
    :cond_155
    sget-object v9, Landroid/widget/AppSecurityPermissions$State;->DANGEROUS_ONLY:Landroid/widget/AppSecurityPermissions$State;

    goto :goto_130

    .line 487
    :cond_158
    iget-object v9, p0, Landroid/widget/AppSecurityPermissions;->mNormalMap:Ljava/util/Map;

    invoke-interface {v9}, Ljava/util/Map;->size()I

    move-result v9

    if-lez v9, :cond_132

    .line 488
    sget-object v9, Landroid/widget/AppSecurityPermissions$State;->NORMAL_ONLY:Landroid/widget/AppSecurityPermissions$State;

    iput-object v9, p0, Landroid/widget/AppSecurityPermissions;->mCurrentState:Landroid/widget/AppSecurityPermissions$State;

    goto :goto_132
.end method

.method private showPermissions()V
    .registers 5

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 346
    sget-object v0, Landroid/widget/AppSecurityPermissions$1;->$SwitchMap$android$widget$AppSecurityPermissions$State:[I

    iget-object v1, p0, Landroid/widget/AppSecurityPermissions;->mCurrentState:Landroid/widget/AppSecurityPermissions$State;

    invoke-virtual {v1}, Landroid/widget/AppSecurityPermissions$State;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_58

    .line 374
    :goto_f
    return-void

    .line 348
    :pswitch_10
    invoke-direct {p0}, Landroid/widget/AppSecurityPermissions;->displayNoPermissions()V

    goto :goto_f

    .line 352
    :pswitch_14
    invoke-direct {p0, v3}, Landroid/widget/AppSecurityPermissions;->displayPermissions(Z)V

    goto :goto_f

    .line 356
    :pswitch_18
    invoke-direct {p0, v2}, Landroid/widget/AppSecurityPermissions;->displayPermissions(Z)V

    goto :goto_f

    .line 360
    :pswitch_1c
    invoke-direct {p0, v3}, Landroid/widget/AppSecurityPermissions;->displayPermissions(Z)V

    .line 361
    iget-boolean v0, p0, Landroid/widget/AppSecurityPermissions;->mExpanded:Z

    if-eqz v0, :cond_40

    .line 362
    invoke-direct {p0, v2}, Landroid/widget/AppSecurityPermissions;->displayPermissions(Z)V

    .line 363
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mShowMoreIcon:Landroid/widget/ImageView;

    iget-object v1, p0, Landroid/widget/AppSecurityPermissions;->mShowMaxIcon:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 364
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mShowMoreText:Landroid/widget/TextView;

    const v1, 0x1040427

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 365
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mNonDangerousList:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 371
    :goto_3a
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mShowMore:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    goto :goto_f

    .line 367
    :cond_40
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mShowMoreIcon:Landroid/widget/ImageView;

    iget-object v1, p0, Landroid/widget/AppSecurityPermissions;->mShowMinIcon:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 368
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mShowMoreText:Landroid/widget/TextView;

    const v1, 0x1040428

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 369
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mNonDangerousList:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_3a

    .line 346
    nop

    :pswitch_data_58
    .packed-switch 0x1
        :pswitch_10
        :pswitch_14
        :pswitch_18
        :pswitch_1c
    .end packed-switch
.end method


# virtual methods
.method public getPermissionCount()I
    .registers 2

    .prologue
    .line 203
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mPermsList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getPermissionsView()Landroid/view/View;
    .registers 5

    .prologue
    const/4 v3, 0x1

    .line 208
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mContext:Landroid/content/Context;

    const-string v1, "layout_inflater"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    iput-object v0, p0, Landroid/widget/AppSecurityPermissions;->mInflater:Landroid/view/LayoutInflater;

    .line 209
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mInflater:Landroid/view/LayoutInflater;

    const v1, 0x109002b

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Landroid/widget/AppSecurityPermissions;->mPermsView:Landroid/widget/LinearLayout;

    .line 210
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mPermsView:Landroid/widget/LinearLayout;

    const v1, 0x1020262

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Landroid/widget/AppSecurityPermissions;->mShowMore:Landroid/view/View;

    .line 211
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mShowMore:Landroid/view/View;

    const v1, 0x1020264

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Landroid/widget/AppSecurityPermissions;->mShowMoreIcon:Landroid/widget/ImageView;

    .line 212
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mShowMore:Landroid/view/View;

    const v1, 0x1020263

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Landroid/widget/AppSecurityPermissions;->mShowMoreText:Landroid/widget/TextView;

    .line 213
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mPermsView:Landroid/widget/LinearLayout;

    const v1, 0x1020261

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Landroid/widget/AppSecurityPermissions;->mDangerousList:Landroid/widget/LinearLayout;

    .line 214
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mPermsView:Landroid/widget/LinearLayout;

    const v1, 0x1020265

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Landroid/widget/AppSecurityPermissions;->mNonDangerousList:Landroid/widget/LinearLayout;

    .line 215
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mPermsView:Landroid/widget/LinearLayout;

    const v1, 0x1020260

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Landroid/widget/AppSecurityPermissions;->mNoPermsView:Landroid/view/View;

    .line 218
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mShowMore:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setClickable(Z)V

    .line 219
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mShowMore:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 220
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mShowMore:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setFocusable(Z)V

    .line 223
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mContext:Landroid/content/Context;

    const v1, 0x1040424

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/widget/AppSecurityPermissions;->mDefaultGrpLabel:Ljava/lang/String;

    .line 224
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mContext:Landroid/content/Context;

    const v1, 0x1040425

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/widget/AppSecurityPermissions;->mPermFormat:Ljava/lang/String;

    .line 225
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x108035c

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Landroid/widget/AppSecurityPermissions;->mNormalIcon:Landroid/graphics/drawable/Drawable;

    .line 226
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x10802b3

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Landroid/widget/AppSecurityPermissions;->mDangerousIcon:Landroid/graphics/drawable/Drawable;

    .line 227
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x108026f

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Landroid/widget/AppSecurityPermissions;->mShowMaxIcon:Landroid/graphics/drawable/Drawable;

    .line 228
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x1080276

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Landroid/widget/AppSecurityPermissions;->mShowMinIcon:Landroid/graphics/drawable/Drawable;

    .line 231
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mPermsList:Ljava/util/List;

    invoke-direct {p0, v0}, Landroid/widget/AppSecurityPermissions;->setPermissions(Ljava/util/List;)V

    .line 232
    iget-object v0, p0, Landroid/widget/AppSecurityPermissions;->mPermsView:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method public onClick(Landroid/view/View;)V
    .registers 5
    .parameter "v"

    .prologue
    .line 495
    iget-boolean v0, p0, Landroid/widget/AppSecurityPermissions;->localLOGV:Z

    if-eqz v0, :cond_1f

    const-string v0, "AppSecurityPermissions"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "mExpanded="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, p0, Landroid/widget/AppSecurityPermissions;->mExpanded:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 496
    :cond_1f
    iget-boolean v0, p0, Landroid/widget/AppSecurityPermissions;->mExpanded:Z

    if-nez v0, :cond_2a

    const/4 v0, 0x1

    :goto_24
    iput-boolean v0, p0, Landroid/widget/AppSecurityPermissions;->mExpanded:Z

    .line 497
    invoke-direct {p0}, Landroid/widget/AppSecurityPermissions;->showPermissions()V

    .line 498
    return-void

    .line 496
    :cond_2a
    const/4 v0, 0x0

    goto :goto_24
.end method
