.class Landroid/view/LayoutInflater$FactoryMerger;
.super Ljava/lang/Object;
.source "LayoutInflater.java"

# interfaces
.implements Landroid/view/LayoutInflater$Factory2;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/view/LayoutInflater;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "FactoryMerger"
.end annotation


# instance fields
.field private final mF1:Landroid/view/LayoutInflater$Factory;

.field private final mF12:Landroid/view/LayoutInflater$Factory2;

.field private final mF2:Landroid/view/LayoutInflater$Factory;

.field private final mF22:Landroid/view/LayoutInflater$Factory2;


# direct methods
.method constructor <init>(Landroid/view/LayoutInflater$Factory;Landroid/view/LayoutInflater$Factory2;Landroid/view/LayoutInflater$Factory;Landroid/view/LayoutInflater$Factory2;)V
    .registers 5
    .parameter "f1"
    .parameter "f12"
    .parameter "f2"
    .parameter "f22"

    .prologue
    .line 154
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 155
    iput-object p1, p0, Landroid/view/LayoutInflater$FactoryMerger;->mF1:Landroid/view/LayoutInflater$Factory;

    .line 156
    iput-object p3, p0, Landroid/view/LayoutInflater$FactoryMerger;->mF2:Landroid/view/LayoutInflater$Factory;

    .line 157
    iput-object p2, p0, Landroid/view/LayoutInflater$FactoryMerger;->mF12:Landroid/view/LayoutInflater$Factory2;

    .line 158
    iput-object p4, p0, Landroid/view/LayoutInflater$FactoryMerger;->mF22:Landroid/view/LayoutInflater$Factory2;

    .line 159
    return-void
.end method


# virtual methods
.method public onCreateView(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;
    .registers 7
    .parameter "parent"
    .parameter "name"
    .parameter "context"
    .parameter "attrs"

    .prologue
    .line 168
    iget-object v1, p0, Landroid/view/LayoutInflater$FactoryMerger;->mF12:Landroid/view/LayoutInflater$Factory2;

    if-eqz v1, :cond_d

    iget-object v1, p0, Landroid/view/LayoutInflater$FactoryMerger;->mF12:Landroid/view/LayoutInflater$Factory2;

    invoke-interface {v1, p1, p2, p3, p4}, Landroid/view/LayoutInflater$Factory2;->onCreateView(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v0

    .line 170
    .local v0, v:Landroid/view/View;
    :goto_a
    if-eqz v0, :cond_14

    .line 171
    .end local v0           #v:Landroid/view/View;
    :goto_c
    return-object v0

    .line 168
    :cond_d
    iget-object v1, p0, Landroid/view/LayoutInflater$FactoryMerger;->mF1:Landroid/view/LayoutInflater$Factory;

    invoke-interface {v1, p2, p3, p4}, Landroid/view/LayoutInflater$Factory;->onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v0

    goto :goto_a

    .line 171
    .restart local v0       #v:Landroid/view/View;
    :cond_14
    iget-object v1, p0, Landroid/view/LayoutInflater$FactoryMerger;->mF22:Landroid/view/LayoutInflater$Factory2;

    if-eqz v1, :cond_20

    iget-object v1, p0, Landroid/view/LayoutInflater$FactoryMerger;->mF22:Landroid/view/LayoutInflater$Factory2;

    invoke-interface {v1, p1, p2, p3, p4}, Landroid/view/LayoutInflater$Factory2;->onCreateView(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v1

    :goto_1e
    move-object v0, v1

    goto :goto_c

    :cond_20
    iget-object v1, p0, Landroid/view/LayoutInflater$FactoryMerger;->mF2:Landroid/view/LayoutInflater$Factory;

    invoke-interface {v1, p2, p3, p4}, Landroid/view/LayoutInflater$Factory;->onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v1

    goto :goto_1e
.end method

.method public onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;
    .registers 6
    .parameter "name"
    .parameter "context"
    .parameter "attrs"

    .prologue
    .line 162
    iget-object v1, p0, Landroid/view/LayoutInflater$FactoryMerger;->mF1:Landroid/view/LayoutInflater$Factory;

    invoke-interface {v1, p1, p2, p3}, Landroid/view/LayoutInflater$Factory;->onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v0

    .line 163
    .local v0, v:Landroid/view/View;
    if-eqz v0, :cond_9

    .line 164
    .end local v0           #v:Landroid/view/View;
    :goto_8
    return-object v0

    .restart local v0       #v:Landroid/view/View;
    :cond_9
    iget-object v1, p0, Landroid/view/LayoutInflater$FactoryMerger;->mF2:Landroid/view/LayoutInflater$Factory;

    invoke-interface {v1, p1, p2, p3}, Landroid/view/LayoutInflater$Factory;->onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v0

    goto :goto_8
.end method
