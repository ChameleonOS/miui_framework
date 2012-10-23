.class public final Landroid/provider/ContactsContract$RawContacts$Data;
.super Ljava/lang/Object;
.source "ContactsContract.java"

# interfaces
.implements Landroid/provider/BaseColumns;
.implements Landroid/provider/ContactsContract$DataColumns;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/provider/ContactsContract$RawContacts;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Data"
.end annotation


# static fields
.field public static final CONTENT_DIRECTORY:Ljava/lang/String; = "data"


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    .line 2688
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 2689
    return-void
.end method
