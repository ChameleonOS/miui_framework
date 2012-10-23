.class public Lmiui/provider/Telocation;
.super Ljava/lang/Object;
.source "Telocation.java"


# static fields
.field public static final ACTION_ADD_CUSTOM_LOCATION:Ljava/lang/String; = "action_add_custom_location"

.field public static final ACTION_EDIT_CUSTOM_LOCATION:Ljava/lang/String; = "action_edit_custom_location"

.field public static final AUTHORITY:Ljava/lang/String; = "telocation"

.field public static final CONTENT_CUSTOM_LOCATION_TYPE:Ljava/lang/String; = "vnd.android.cursor.dir/custom_telocations"

.field public static final CONTENT_CUSTOM_LOCATION_URI:Landroid/net/Uri; = null

.field public static final CUSTOM_ID_COLUMN_INDEX:I = 0x0

.field public static final CUSTOM_LOCATION_COLUMN:Ljava/lang/String; = "location"

.field public static final CUSTOM_LOCATION_COLUMN_INDEX:I = 0x2

.field public static final CUSTOM_NUMBER_COLUMN:Ljava/lang/String; = "number"

.field public static final CUSTOM_NUMBER_COLUMN_INDEX:I = 0x1

.field public static final CUSTOM_TYPE_COLUMN:Ljava/lang/String; = "type"

.field public static final CUSTOM_TYPE_COLUMN_INDEX:I = 0x3

.field public static final LOCATION_MATCH:Ljava/lang/String; = "customlocations"

.field public static final TYPE_JITUAN:I = 0x2

.field public static final TYPE_MOB:I = 0x1

.field public static final TYPE_TEL:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 53
    const-string v0, "content://telocation/customlocations"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lmiui/provider/Telocation;->CONTENT_CUSTOM_LOCATION_URI:Landroid/net/Uri;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 10
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
