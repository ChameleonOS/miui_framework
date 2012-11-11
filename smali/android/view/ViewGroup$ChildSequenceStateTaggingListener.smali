.class public interface abstract Landroid/view/ViewGroup$ChildSequenceStateTaggingListener;
.super Ljava/lang/Object;
.source "ViewGroup.java"


# annotations
.annotation build Landroid/annotation/MiuiHook;
    value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_CLASS:Landroid/annotation/MiuiHook$MiuiHookType;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/view/ViewGroup;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "ChildSequenceStateTaggingListener"
.end annotation


# virtual methods
.method public abstract onTaggingFirstChildSequenceState(Landroid/view/ViewGroup;Landroid/view/View;)Z
.end method

.method public abstract onTaggingLastChildSequenceState(Landroid/view/ViewGroup;Landroid/view/View;)Z
.end method
