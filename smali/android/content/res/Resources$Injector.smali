.class Landroid/content/res/Resources$Injector;
.super Ljava/lang/Object;
.source "Resources.java"


# annotations
.annotation build Landroid/annotation/MiuiHook;
    value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_CLASS:Landroid/annotation/MiuiHook$MiuiHookType;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/content/res/Resources;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Injector"
.end annotation


# static fields
.field private static mId:I


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static createFromResourceStream(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/drawable/Drawable;
    .registers 7
    .parameter "res"
    .parameter "value"
    .parameter "is"
    .parameter "srcName"
    .parameter "opts"

    .prologue
    sget v1, Landroid/content/res/Resources$Injector;->mId:I

    invoke-virtual {p0, p1, v1}, Landroid/content/res/Resources;->loadOverlayDrawable(Landroid/util/TypedValue;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .local v0, dr:Landroid/graphics/drawable/Drawable;
    if-nez v0, :cond_c

    invoke-static {p0, p1, p2, p3, p4}, Landroid/graphics/drawable/Drawable;->createFromResourceStream(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    :cond_c
    return-object v0
.end method

.method static setDrawableId(I)V
    .registers 1
    .parameter "id"

    .prologue
    sput p0, Landroid/content/res/Resources$Injector;->mId:I

    return-void
.end method
