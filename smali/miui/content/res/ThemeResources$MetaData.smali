.class public final Lmiui/content/res/ThemeResources$MetaData;
.super Ljava/lang/Object;
.source "ThemeResources.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/content/res/ThemeResources;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1c
    name = "MetaData"
.end annotation


# instance fields
.field public supportCharSequence:Z

.field public supportFile:Z

.field public supportInt:Z

.field public themePath:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;ZZZ)V
    .registers 5
    .parameter "themePath"
    .parameter "supportInt"
    .parameter "supportCharSequence"
    .parameter "supportFile"

    .prologue
    .line 24
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput-object p1, p0, Lmiui/content/res/ThemeResources$MetaData;->themePath:Ljava/lang/String;

    .line 26
    iput-boolean p2, p0, Lmiui/content/res/ThemeResources$MetaData;->supportInt:Z

    .line 27
    iput-boolean p3, p0, Lmiui/content/res/ThemeResources$MetaData;->supportCharSequence:Z

    .line 28
    iput-boolean p4, p0, Lmiui/content/res/ThemeResources$MetaData;->supportFile:Z

    .line 29
    return-void
.end method
