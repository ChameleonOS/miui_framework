.class public Landroid/content/pm/PackageParser$IntentInfo;
.super Landroid/content/IntentFilter;
.source "PackageParser.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/content/pm/PackageParser;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "IntentInfo"
.end annotation


# instance fields
.field public hasDefault:Z

.field public icon:I

.field public labelRes:I

.field public logo:I

.field public nonLocalizedLabel:Ljava/lang/CharSequence;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 3691
    invoke-direct {p0}, Landroid/content/IntentFilter;-><init>()V

    return-void
.end method
