.class public final Landroid/provider/ContactsContract$StreamItemPhotos;
.super Ljava/lang/Object;
.source "ContactsContract.java"

# interfaces
.implements Landroid/provider/BaseColumns;
.implements Landroid/provider/ContactsContract$StreamItemPhotosColumns;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/provider/ContactsContract;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "StreamItemPhotos"
.end annotation


# static fields
.field public static final PHOTO:Ljava/lang/String; = "photo"


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    .line 3590
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 3591
    return-void
.end method
