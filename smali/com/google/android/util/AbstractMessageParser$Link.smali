.class public Lcom/google/android/util/AbstractMessageParser$Link;
.super Lcom/google/android/util/AbstractMessageParser$Token;
.source "AbstractMessageParser.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/util/AbstractMessageParser;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Link"
.end annotation


# instance fields
.field private url:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .registers 4
    .parameter "url"
    .parameter "text"

    .prologue
    .line 793
    sget-object v0, Lcom/google/android/util/AbstractMessageParser$Token$Type;->LINK:Lcom/google/android/util/AbstractMessageParser$Token$Type;

    invoke-direct {p0, v0, p2}, Lcom/google/android/util/AbstractMessageParser$Token;-><init>(Lcom/google/android/util/AbstractMessageParser$Token$Type;Ljava/lang/String;)V

    .line 794
    iput-object p1, p0, Lcom/google/android/util/AbstractMessageParser$Link;->url:Ljava/lang/String;

    .line 795
    return-void
.end method


# virtual methods
.method public getInfo()Ljava/util/List;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 802
    invoke-super {p0}, Lcom/google/android/util/AbstractMessageParser$Token;->getInfo()Ljava/util/List;

    move-result-object v0

    .line 803
    .local v0, info:Ljava/util/List;,"Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual {p0}, Lcom/google/android/util/AbstractMessageParser$Link;->getURL()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 804
    invoke-virtual {p0}, Lcom/google/android/util/AbstractMessageParser$Link;->getRawText()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 805
    return-object v0
.end method

.method public getURL()Ljava/lang/String;
    .registers 2

    .prologue
    .line 797
    iget-object v0, p0, Lcom/google/android/util/AbstractMessageParser$Link;->url:Ljava/lang/String;

    return-object v0
.end method

.method public isHtml()Z
    .registers 2

    .prologue
    .line 799
    const/4 v0, 0x0

    return v0
.end method
