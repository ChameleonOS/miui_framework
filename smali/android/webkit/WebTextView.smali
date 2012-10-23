.class abstract Landroid/webkit/WebTextView;
.super Ljava/lang/Object;
.source "WebTextView.java"


# static fields
.field static final EMAIL:I = 0x4

.field static final FORM_NOT_AUTOFILLABLE:I = -0x1

.field private static final LOGTAG:Ljava/lang/String; = "WebTextView"

.field static final NORMAL_TEXT_FIELD:I = 0x0

.field static final NUMBER:I = 0x5

.field static final PASSWORD:I = 0x2

.field static final SEARCH:I = 0x3

.field static final TELEPHONE:I = 0x6

.field static final TEXT_AREA:I = 0x1

.field static final URL:I = 0x7


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 25
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static urlForAutoCompleteData(Ljava/lang/String;)Ljava/lang/String;
    .registers 7
    .parameter "urlString"

    .prologue
    .line 43
    const/4 v1, 0x0

    .line 45
    .local v1, url:Ljava/net/URL;
    :try_start_1
    new-instance v2, Ljava/net/URL;

    invoke-direct {v2, p0}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_6
    .catch Ljava/net/MalformedURLException; {:try_start_1 .. :try_end_6} :catch_31

    .end local v1           #url:Ljava/net/URL;
    .local v2, url:Ljava/net/URL;
    move-object v1, v2

    .line 50
    .end local v2           #url:Ljava/net/URL;
    .restart local v1       #url:Ljava/net/URL;
    :goto_7
    if-eqz v1, :cond_4b

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1}, Ljava/net/URL;->getProtocol()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "://"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1}, Ljava/net/URL;->getPath()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    :goto_30
    return-object v3

    .line 46
    :catch_31
    move-exception v0

    .line 47
    .local v0, e:Ljava/net/MalformedURLException;
    const-string v3, "WebTextView"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Unable to parse URL "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_7

    .line 50
    .end local v0           #e:Ljava/net/MalformedURLException;
    :cond_4b
    const/4 v3, 0x0

    goto :goto_30
.end method
