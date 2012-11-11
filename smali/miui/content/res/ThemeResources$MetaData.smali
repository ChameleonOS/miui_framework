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
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lmiui/content/res/ThemeResources$MetaData;->themePath:Ljava/lang/String;

    iput-boolean p2, p0, Lmiui/content/res/ThemeResources$MetaData;->supportInt:Z

    iput-boolean p3, p0, Lmiui/content/res/ThemeResources$MetaData;->supportCharSequence:Z

    iput-boolean p4, p0, Lmiui/content/res/ThemeResources$MetaData;->supportFile:Z

    return-void
.end method
