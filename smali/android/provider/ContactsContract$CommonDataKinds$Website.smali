.class public final Landroid/provider/ContactsContract$CommonDataKinds$Website;
.super Ljava/lang/Object;
.source "ContactsContract.java"

# interfaces
.implements Landroid/provider/ContactsContract$DataColumnsWithJoins;
.implements Landroid/provider/ContactsContract$CommonDataKinds$CommonColumns;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/provider/ContactsContract$CommonDataKinds;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Website"
.end annotation


# static fields
.field public static final CONTENT_ITEM_TYPE:Ljava/lang/String; = "vnd.android.cursor.item/website"

.field public static final TYPE_BLOG:I = 0x2

.field public static final TYPE_FTP:I = 0x6

.field public static final TYPE_HOME:I = 0x4

.field public static final TYPE_HOMEPAGE:I = 0x1

.field public static final TYPE_OTHER:I = 0x7

.field public static final TYPE_PROFILE:I = 0x3

.field public static final TYPE_WORK:I = 0x5

.field public static final URL:Ljava/lang/String; = "data1"


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    .line 6659
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
