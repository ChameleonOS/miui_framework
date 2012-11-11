.class public Lmiui/provider/Notes$DataConstants;
.super Ljava/lang/Object;
.source "Notes.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/provider/Notes;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DataConstants"
.end annotation


# static fields
.field public static final CALL_NOTE:Ljava/lang/String; = "vnd.android.cursor.item/call_note"

.field public static final NOTE:Ljava/lang/String; = "vnd.android.cursor.item/text_note"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
