.class public Landroid/util/EventLogTags$Description;
.super Ljava/lang/Object;
.source "EventLogTags.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/util/EventLogTags;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Description"
.end annotation


# instance fields
.field public final mName:Ljava/lang/String;

.field public final mTag:I


# direct methods
.method constructor <init>(ILjava/lang/String;)V
    .registers 3
    .parameter "tag"
    .parameter "name"

    .prologue
    .line 38
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 39
    iput p1, p0, Landroid/util/EventLogTags$Description;->mTag:I

    .line 40
    iput-object p2, p0, Landroid/util/EventLogTags$Description;->mName:Ljava/lang/String;

    .line 41
    return-void
.end method
