.class public Landroid/util/EventLogTags;
.super Ljava/lang/Object;
.source "EventLogTags.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/util/EventLogTags$Description;
    }
.end annotation

.annotation runtime Ljava/lang/Deprecated;
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 44
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public constructor <init>(Ljava/io/BufferedReader;)V
    .registers 2
    .parameter "input"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 46
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get(I)Landroid/util/EventLogTags$Description;
    .registers 3
    .parameter "tag"

    .prologue
    .line 50
    const/4 v0, 0x0

    return-object v0
.end method

.method public get(Ljava/lang/String;)Landroid/util/EventLogTags$Description;
    .registers 3
    .parameter "name"

    .prologue
    .line 48
    const/4 v0, 0x0

    return-object v0
.end method
