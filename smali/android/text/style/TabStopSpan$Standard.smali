.class public Landroid/text/style/TabStopSpan$Standard;
.super Ljava/lang/Object;
.source "TabStopSpan.java"

# interfaces
.implements Landroid/text/style/TabStopSpan;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/text/style/TabStopSpan;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Standard"
.end annotation


# instance fields
.field private mTab:I


# direct methods
.method public constructor <init>(I)V
    .registers 2
    .parameter "where"

    .prologue
    .line 44
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 45
    iput p1, p0, Landroid/text/style/TabStopSpan$Standard;->mTab:I

    .line 46
    return-void
.end method


# virtual methods
.method public getTabStop()I
    .registers 2

    .prologue
    .line 49
    iget v0, p0, Landroid/text/style/TabStopSpan$Standard;->mTab:I

    return v0
.end method
