.class public Landroid/app/AliasActivity;
.super Landroid/app/Activity;
.source "AliasActivity.java"


# instance fields
.field public final ALIAS_META_DATA:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 43
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 50
    const-string v0, "android.app.alias"

    iput-object v0, p0, Landroid/app/AliasActivity;->ALIAS_META_DATA:Ljava/lang/String;

    return-void
.end method

.method private parseAlias(Lorg/xmlpull/v1/XmlPullParser;)Landroid/content/Intent;
    .registers 11
    .parameter "parser"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v8, 0x3

    const/4 v7, 0x1

    .line 89
    invoke-static {p1}, Landroid/util/Xml;->asAttributeSet(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;

    move-result-object v0

    .line 91
    .local v0, attrs:Landroid/util/AttributeSet;
    const/4 v2, 0x0

    .line 95
    .local v2, intent:Landroid/content/Intent;
    :cond_7
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v5

    .local v5, type:I
    if-eq v5, v7, :cond_10

    const/4 v6, 0x2

    if-ne v5, v6, :cond_7

    .line 98
    :cond_10
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v3

    .line 99
    .local v3, nodeName:Ljava/lang/String;
    const-string v6, "alias"

    invoke-virtual {v6, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_43

    .line 100
    new-instance v6, Ljava/lang/RuntimeException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Alias meta-data must start with <alias> tag; found"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " at "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 105
    :cond_43
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v4

    .line 107
    .local v4, outerDepth:I
    :cond_47
    :goto_47
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v5

    if-eq v5, v7, :cond_76

    if-ne v5, v8, :cond_55

    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v6

    if-le v6, v4, :cond_76

    .line 108
    :cond_55
    if-eq v5, v8, :cond_47

    const/4 v6, 0x4

    if-eq v5, v6, :cond_47

    .line 112
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v3

    .line 113
    const-string v6, "intent"

    invoke-virtual {v6, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_72

    .line 114
    invoke-virtual {p0}, Landroid/app/AliasActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-static {v6, p1, v0}, Landroid/content/Intent;->parseIntent(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;)Landroid/content/Intent;

    move-result-object v1

    .line 115
    .local v1, gotIntent:Landroid/content/Intent;
    if-nez v2, :cond_47

    move-object v2, v1

    goto :goto_47

    .line 117
    .end local v1           #gotIntent:Landroid/content/Intent;
    :cond_72
    invoke-static {p1}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto :goto_47

    .line 121
    :cond_76
    return-object v2
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .registers 9
    .parameter "savedInstanceState"

    .prologue
    .line 54
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 56
    const/4 v3, 0x0

    .line 58
    .local v3, parser:Landroid/content/res/XmlResourceParser;
    :try_start_4
    invoke-virtual {p0}, Landroid/app/AliasActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    invoke-virtual {p0}, Landroid/app/AliasActivity;->getComponentName()Landroid/content/ComponentName;

    move-result-object v5

    const/16 v6, 0x80

    invoke-virtual {v4, v5, v6}, Landroid/content/pm/PackageManager;->getActivityInfo(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;

    move-result-object v0

    .line 60
    .local v0, ai:Landroid/content/pm/ActivityInfo;
    invoke-virtual {p0}, Landroid/app/AliasActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    const-string v5, "android.app.alias"

    invoke-virtual {v0, v4, v5}, Landroid/content/pm/ActivityInfo;->loadXmlMetaData(Landroid/content/pm/PackageManager;Ljava/lang/String;)Landroid/content/res/XmlResourceParser;

    move-result-object v3

    .line 62
    if-nez v3, :cond_36

    .line 63
    new-instance v4, Ljava/lang/RuntimeException;

    const-string v5, "Alias requires a meta-data field android.app.alias"

    invoke-direct {v4, v5}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v4
    :try_end_26
    .catchall {:try_start_4 .. :try_end_26} :catchall_2f
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_4 .. :try_end_26} :catch_26
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_4 .. :try_end_26} :catch_44
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_26} :catch_59

    .line 76
    .end local v0           #ai:Landroid/content/pm/ActivityInfo;
    :catch_26
    move-exception v1

    .line 77
    .local v1, e:Landroid/content/pm/PackageManager$NameNotFoundException;
    :try_start_27
    new-instance v4, Ljava/lang/RuntimeException;

    const-string v5, "Error parsing alias"

    invoke-direct {v4, v5, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v4
    :try_end_2f
    .catchall {:try_start_27 .. :try_end_2f} :catchall_2f

    .line 83
    .end local v1           #e:Landroid/content/pm/PackageManager$NameNotFoundException;
    :catchall_2f
    move-exception v4

    if-eqz v3, :cond_35

    invoke-interface {v3}, Landroid/content/res/XmlResourceParser;->close()V

    :cond_35
    throw v4

    .line 67
    .restart local v0       #ai:Landroid/content/pm/ActivityInfo;
    :cond_36
    :try_start_36
    invoke-direct {p0, v3}, Landroid/app/AliasActivity;->parseAlias(Lorg/xmlpull/v1/XmlPullParser;)Landroid/content/Intent;

    move-result-object v2

    .line 68
    .local v2, intent:Landroid/content/Intent;
    if-nez v2, :cond_4d

    .line 69
    new-instance v4, Ljava/lang/RuntimeException;

    const-string v5, "No <intent> tag found in alias description"

    invoke-direct {v4, v5}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v4
    :try_end_44
    .catchall {:try_start_36 .. :try_end_44} :catchall_2f
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_36 .. :try_end_44} :catch_26
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_36 .. :try_end_44} :catch_44
    .catch Ljava/io/IOException; {:try_start_36 .. :try_end_44} :catch_59

    .line 78
    .end local v0           #ai:Landroid/content/pm/ActivityInfo;
    .end local v2           #intent:Landroid/content/Intent;
    :catch_44
    move-exception v1

    .line 79
    .local v1, e:Lorg/xmlpull/v1/XmlPullParserException;
    :try_start_45
    new-instance v4, Ljava/lang/RuntimeException;

    const-string v5, "Error parsing alias"

    invoke-direct {v4, v5, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v4
    :try_end_4d
    .catchall {:try_start_45 .. :try_end_4d} :catchall_2f

    .line 73
    .end local v1           #e:Lorg/xmlpull/v1/XmlPullParserException;
    .restart local v0       #ai:Landroid/content/pm/ActivityInfo;
    .restart local v2       #intent:Landroid/content/Intent;
    :cond_4d
    :try_start_4d
    invoke-virtual {p0, v2}, Landroid/app/AliasActivity;->startActivity(Landroid/content/Intent;)V

    .line 74
    invoke-virtual {p0}, Landroid/app/AliasActivity;->finish()V
    :try_end_53
    .catchall {:try_start_4d .. :try_end_53} :catchall_2f
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_4d .. :try_end_53} :catch_26
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_4d .. :try_end_53} :catch_44
    .catch Ljava/io/IOException; {:try_start_4d .. :try_end_53} :catch_59

    .line 83
    if-eqz v3, :cond_58

    invoke-interface {v3}, Landroid/content/res/XmlResourceParser;->close()V

    .line 85
    :cond_58
    return-void

    .line 80
    .end local v0           #ai:Landroid/content/pm/ActivityInfo;
    .end local v2           #intent:Landroid/content/Intent;
    :catch_59
    move-exception v1

    .line 81
    .local v1, e:Ljava/io/IOException;
    :try_start_5a
    new-instance v4, Ljava/lang/RuntimeException;

    const-string v5, "Error parsing alias"

    invoke-direct {v4, v5, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v4
    :try_end_62
    .catchall {:try_start_5a .. :try_end_62} :catchall_2f
.end method
