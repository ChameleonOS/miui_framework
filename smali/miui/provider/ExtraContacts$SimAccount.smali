.class public final Lmiui/provider/ExtraContacts$SimAccount;
.super Ljava/lang/Object;
.source "ExtraContacts.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/provider/ExtraContacts;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "SimAccount"
.end annotation


# static fields
.field public static final ACTION_CLEAR_SIM_CONTACTS:Ljava/lang/String; = "com.android.contacts.intent.clear_sim_contacts"

.field public static final ACTION_SYNC_SIM_CONTACTS:Ljava/lang/String; = "com.android.contacts.intent.sync_sim_contacts"

.field public static NAME:Ljava/lang/String; = null

.field public static final SIM_NEW_NUMBER:Ljava/lang/String; = "newNumber"

.field public static final SIM_NEW_TAG:Ljava/lang/String; = "newTag"

.field public static final SIM_NUMBER:Ljava/lang/String; = "number"

.field public static final SIM_TAG:Ljava/lang/String; = "tag"

.field public static final TYPE:Ljava/lang/String; = "com.android.contacts.sim"

.field public static final URI_ADN:Ljava/lang/String; = "content://icc/adn"

.field public static final URI_ADN_CAPACITY:Ljava/lang/String; = "content://icc/adncapacity"

.field public static final URI_FREE_ADN:Ljava/lang/String; = "content://icc/freeadn"


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 651
    const-string v0, "SIM"

    sput-object v0, Lmiui/provider/ExtraContacts$SimAccount;->NAME:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 650
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
