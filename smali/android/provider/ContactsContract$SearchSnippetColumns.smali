.class public Landroid/provider/ContactsContract$SearchSnippetColumns;
.super Ljava/lang/Object;
.source "ContactsContract.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/provider/ContactsContract;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SearchSnippetColumns"
.end annotation


# static fields
.field public static final DEFERRED_SNIPPETING_KEY:Ljava/lang/String; = "deferred_snippeting"

.field public static final SNIPPET:Ljava/lang/String; = "snippet"

.field public static final SNIPPET_ARGS_PARAM_KEY:Ljava/lang/String; = "snippet_args"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 4996
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
