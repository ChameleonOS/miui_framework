.class public Landroid/text/Spannable$Factory;
.super Ljava/lang/Object;
.source "Spannable.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/text/Spannable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Factory"
.end annotation


# static fields
.field private static sInstance:Landroid/text/Spannable$Factory;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 53
    new-instance v0, Landroid/text/Spannable$Factory;

    invoke-direct {v0}, Landroid/text/Spannable$Factory;-><init>()V

    sput-object v0, Landroid/text/Spannable$Factory;->sInstance:Landroid/text/Spannable$Factory;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 52
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getInstance()Landroid/text/Spannable$Factory;
    .registers 1

    .prologue
    .line 59
    sget-object v0, Landroid/text/Spannable$Factory;->sInstance:Landroid/text/Spannable$Factory;

    return-object v0
.end method


# virtual methods
.method public newSpannable(Ljava/lang/CharSequence;)Landroid/text/Spannable;
    .registers 3
    .parameter "source"

    .prologue
    .line 67
    new-instance v0, Landroid/text/SpannableString;

    invoke-direct {v0, p1}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    return-object v0
.end method
