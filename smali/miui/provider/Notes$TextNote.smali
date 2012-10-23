.class public final Lmiui/provider/Notes$TextNote;
.super Ljava/lang/Object;
.source "Notes.java"

# interfaces
.implements Lmiui/provider/Notes$DataColumns;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/provider/Notes;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "TextNote"
.end annotation


# static fields
.field public static final CONTENT_ITEM_TYPE:Ljava/lang/String; = "vnd.android.cursor.item/text_note"

.field public static final CONTENT_TYPE:Ljava/lang/String; = "vnd.android.cursor.dir/text_note"

.field public static final CONTENT_URI:Landroid/net/Uri; = null

.field public static final MODE:Ljava/lang/String; = "data1"

.field public static final MODE_CHECK_LIST:I = 0x1


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 251
    const-string v0, "content://notes/text_note"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lmiui/provider/Notes$TextNote;->CONTENT_URI:Landroid/net/Uri;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 238
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
