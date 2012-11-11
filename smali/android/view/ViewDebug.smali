.class public Landroid/view/ViewDebug;
.super Ljava/lang/Object;
.source "ViewDebug.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/view/ViewDebug$ViewOperation;,
        Landroid/view/ViewDebug$RecyclerTraceType;,
        Landroid/view/ViewDebug$HierarchyTraceType;,
        Landroid/view/ViewDebug$CapturedViewProperty;,
        Landroid/view/ViewDebug$FlagToString;,
        Landroid/view/ViewDebug$IntToString;,
        Landroid/view/ViewDebug$ExportedProperty;
    }
.end annotation


# static fields
.field private static final CAPTURE_TIMEOUT:I = 0xfa0

.field public static final DEBUG_DRAG:Z = false

.field private static final REMOTE_COMMAND_CAPTURE:Ljava/lang/String; = "CAPTURE"

.field private static final REMOTE_COMMAND_CAPTURE_LAYERS:Ljava/lang/String; = "CAPTURE_LAYERS"

.field private static final REMOTE_COMMAND_DUMP:Ljava/lang/String; = "DUMP"

.field private static final REMOTE_COMMAND_INVALIDATE:Ljava/lang/String; = "INVALIDATE"

.field private static final REMOTE_COMMAND_OUTPUT_DISPLAYLIST:Ljava/lang/String; = "OUTPUT_DISPLAYLIST"

.field private static final REMOTE_COMMAND_REQUEST_LAYOUT:Ljava/lang/String; = "REQUEST_LAYOUT"

.field private static final REMOTE_PROFILE:Ljava/lang/String; = "PROFILE"

.field public static final TRACE_HIERARCHY:Z
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final TRACE_RECYCLER:Z
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field private static mCapturedViewFieldsForClasses:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Class",
            "<*>;[",
            "Ljava/lang/reflect/Field;",
            ">;"
        }
    .end annotation
.end field

.field private static mCapturedViewMethodsForClasses:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Class",
            "<*>;[",
            "Ljava/lang/reflect/Method;",
            ">;"
        }
    .end annotation
.end field

.field private static sAnnotations:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/reflect/AccessibleObject;",
            "Landroid/view/ViewDebug$ExportedProperty;",
            ">;"
        }
    .end annotation
.end field

.field private static sFieldsForClasses:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Class",
            "<*>;[",
            "Ljava/lang/reflect/Field;",
            ">;"
        }
    .end annotation
.end field

.field private static sMethodsForClasses:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Class",
            "<*>;[",
            "Ljava/lang/reflect/Method;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    const/4 v0, 0x0

    sput-object v0, Landroid/view/ViewDebug;->mCapturedViewMethodsForClasses:Ljava/util/HashMap;

    sput-object v0, Landroid/view/ViewDebug;->mCapturedViewFieldsForClasses:Ljava/util/HashMap;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static capture(Landroid/view/View;Ljava/io/OutputStream;Ljava/lang/String;)V
    .registers 10
    .parameter "root"
    .parameter "clientStream"
    .parameter "parameter"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v6, 0x1

    invoke-static {p0, p2}, Landroid/view/ViewDebug;->findView(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;

    move-result-object v1

    .local v1, captureView:Landroid/view/View;
    const/4 v4, 0x0

    invoke-static {v1, v4}, Landroid/view/ViewDebug;->performViewCapture(Landroid/view/View;Z)Landroid/graphics/Bitmap;

    move-result-object v0

    .local v0, b:Landroid/graphics/Bitmap;
    if-nez v0, :cond_19

    const-string v4, "View"

    const-string v5, "Failed to create capture bitmap!"

    invoke-static {v4, v5}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    sget-object v4, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v6, v6, v4}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v0

    :cond_19
    const/4 v2, 0x0

    .local v2, out:Ljava/io/BufferedOutputStream;
    :try_start_1a
    new-instance v3, Ljava/io/BufferedOutputStream;

    const v4, 0x8000

    invoke-direct {v3, p1, v4}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;I)V
    :try_end_22
    .catchall {:try_start_1a .. :try_end_22} :catchall_35

    .end local v2           #out:Ljava/io/BufferedOutputStream;
    .local v3, out:Ljava/io/BufferedOutputStream;
    :try_start_22
    sget-object v4, Landroid/graphics/Bitmap$CompressFormat;->PNG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v5, 0x64

    invoke-virtual {v0, v4, v5, v3}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    invoke-virtual {v3}, Ljava/io/BufferedOutputStream;->flush()V
    :try_end_2c
    .catchall {:try_start_22 .. :try_end_2c} :catchall_3f

    if-eqz v3, :cond_31

    invoke-virtual {v3}, Ljava/io/BufferedOutputStream;->close()V

    :cond_31
    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    return-void

    .end local v3           #out:Ljava/io/BufferedOutputStream;
    .restart local v2       #out:Ljava/io/BufferedOutputStream;
    :catchall_35
    move-exception v4

    :goto_36
    if-eqz v2, :cond_3b

    invoke-virtual {v2}, Ljava/io/BufferedOutputStream;->close()V

    :cond_3b
    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    throw v4

    .end local v2           #out:Ljava/io/BufferedOutputStream;
    .restart local v3       #out:Ljava/io/BufferedOutputStream;
    :catchall_3f
    move-exception v4

    move-object v2, v3

    .end local v3           #out:Ljava/io/BufferedOutputStream;
    .restart local v2       #out:Ljava/io/BufferedOutputStream;
    goto :goto_36
.end method

.method private static captureLayers(Landroid/view/View;Ljava/io/DataOutputStream;)V
    .registers 5
    .parameter "root"
    .parameter "clientStream"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    :try_start_0
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V
    :try_end_5
    .catchall {:try_start_0 .. :try_end_5} :catchall_2a

    .local v0, outRect:Landroid/graphics/Rect;
    :try_start_5
    iget-object v1, p0, Landroid/view/View;->mAttachInfo:Landroid/view/View$AttachInfo;

    iget-object v1, v1, Landroid/view/View$AttachInfo;->mSession:Landroid/view/IWindowSession;

    iget-object v2, p0, Landroid/view/View;->mAttachInfo:Landroid/view/View$AttachInfo;

    iget-object v2, v2, Landroid/view/View$AttachInfo;->mWindow:Landroid/view/IWindow;

    invoke-interface {v1, v2, v0}, Landroid/view/IWindowSession;->getDisplayFrame(Landroid/view/IWindow;Landroid/graphics/Rect;)V
    :try_end_10
    .catchall {:try_start_5 .. :try_end_10} :catchall_2a
    .catch Landroid/os/RemoteException; {:try_start_5 .. :try_end_10} :catch_2f

    :goto_10
    :try_start_10
    invoke-virtual {v0}, Landroid/graphics/Rect;->width()I

    move-result v1

    invoke-virtual {p1, v1}, Ljava/io/DataOutputStream;->writeInt(I)V

    invoke-virtual {v0}, Landroid/graphics/Rect;->height()I

    move-result v1

    invoke-virtual {p1, v1}, Ljava/io/DataOutputStream;->writeInt(I)V

    const/4 v1, 0x1

    invoke-static {p0, p1, v1}, Landroid/view/ViewDebug;->captureViewLayer(Landroid/view/View;Ljava/io/DataOutputStream;Z)V

    const/4 v1, 0x2

    invoke-virtual {p1, v1}, Ljava/io/DataOutputStream;->write(I)V
    :try_end_26
    .catchall {:try_start_10 .. :try_end_26} :catchall_2a

    invoke-virtual {p1}, Ljava/io/DataOutputStream;->close()V

    return-void

    .end local v0           #outRect:Landroid/graphics/Rect;
    :catchall_2a
    move-exception v1

    invoke-virtual {p1}, Ljava/io/DataOutputStream;->close()V

    throw v1

    .restart local v0       #outRect:Landroid/graphics/Rect;
    :catch_2f
    move-exception v1

    goto :goto_10
.end method

.method private static captureViewLayer(Landroid/view/View;Ljava/io/DataOutputStream;Z)V
    .registers 16
    .parameter "view"
    .parameter "clientStream"
    .parameter "visible"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v10, 0x0

    const/4 v9, 0x1

    invoke-virtual {p0}, Landroid/view/View;->getVisibility()I

    move-result v11

    if-nez v11, :cond_8f

    if-eqz p2, :cond_8f

    move v6, v9

    .local v6, localVisible:Z
    :goto_b
    iget v11, p0, Landroid/view/View;->mPrivateFlags:I

    and-int/lit16 v11, v11, 0x80

    const/16 v12, 0x80

    if-eq v11, v12, :cond_77

    invoke-virtual {p0}, Landroid/view/View;->getId()I

    move-result v5

    .local v5, id:I
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v7

    .local v7, name:Ljava/lang/String;
    const/4 v11, -0x1

    if-eq v5, v11, :cond_2e

    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v11

    invoke-static {v11, v5}, Landroid/view/ViewDebug;->resolveId(Landroid/content/Context;I)Ljava/lang/Object;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    :cond_2e
    invoke-virtual {p1, v9}, Ljava/io/DataOutputStream;->write(I)V

    invoke-virtual {p1, v7}, Ljava/io/DataOutputStream;->writeUTF(Ljava/lang/String;)V

    if-eqz v6, :cond_92

    move v11, v9

    :goto_37
    invoke-virtual {p1, v11}, Ljava/io/DataOutputStream;->writeByte(I)V

    const/4 v11, 0x2

    new-array v8, v11, [I

    .local v8, position:[I
    invoke-virtual {p0, v8}, Landroid/view/View;->getLocationInWindow([I)V

    aget v10, v8, v10

    invoke-virtual {p1, v10}, Ljava/io/DataOutputStream;->writeInt(I)V

    aget v10, v8, v9

    invoke-virtual {p1, v10}, Ljava/io/DataOutputStream;->writeInt(I)V

    invoke-virtual {p1}, Ljava/io/DataOutputStream;->flush()V

    invoke-static {p0, v9}, Landroid/view/ViewDebug;->performViewCapture(Landroid/view/View;Z)Landroid/graphics/Bitmap;

    move-result-object v1

    .local v1, b:Landroid/graphics/Bitmap;
    if-eqz v1, :cond_74

    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v9

    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v10

    mul-int/2addr v9, v10

    mul-int/lit8 v9, v9, 0x2

    invoke-direct {v0, v9}, Ljava/io/ByteArrayOutputStream;-><init>(I)V

    .local v0, arrayOut:Ljava/io/ByteArrayOutputStream;
    sget-object v9, Landroid/graphics/Bitmap$CompressFormat;->PNG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v10, 0x64

    invoke-virtual {v1, v9, v10, v0}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->size()I

    move-result v9

    invoke-virtual {p1, v9}, Ljava/io/DataOutputStream;->writeInt(I)V

    invoke-virtual {v0, p1}, Ljava/io/ByteArrayOutputStream;->writeTo(Ljava/io/OutputStream;)V

    .end local v0           #arrayOut:Ljava/io/ByteArrayOutputStream;
    :cond_74
    invoke-virtual {p1}, Ljava/io/DataOutputStream;->flush()V

    .end local v1           #b:Landroid/graphics/Bitmap;
    .end local v5           #id:I
    .end local v7           #name:Ljava/lang/String;
    .end local v8           #position:[I
    :cond_77
    instance-of v9, p0, Landroid/view/ViewGroup;

    if-eqz v9, :cond_94

    move-object v3, p0

    check-cast v3, Landroid/view/ViewGroup;

    .local v3, group:Landroid/view/ViewGroup;
    invoke-virtual {v3}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v2

    .local v2, count:I
    const/4 v4, 0x0

    .local v4, i:I
    :goto_83
    if-ge v4, v2, :cond_94

    invoke-virtual {v3, v4}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v9

    invoke-static {v9, p1, v6}, Landroid/view/ViewDebug;->captureViewLayer(Landroid/view/View;Ljava/io/DataOutputStream;Z)V

    add-int/lit8 v4, v4, 0x1

    goto :goto_83

    .end local v2           #count:I
    .end local v3           #group:Landroid/view/ViewGroup;
    .end local v4           #i:I
    .end local v6           #localVisible:Z
    :cond_8f
    move v6, v10

    goto/16 :goto_b

    .restart local v5       #id:I
    .restart local v6       #localVisible:Z
    .restart local v7       #name:Ljava/lang/String;
    :cond_92
    move v11, v10

    goto :goto_37

    .end local v5           #id:I
    .end local v7           #name:Ljava/lang/String;
    :cond_94
    return-void
.end method

.method private static capturedViewExportFields(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/String;
    .registers 13
    .parameter "obj"
    .parameter
    .parameter "prefix"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .local p1, klass:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    if-nez p0, :cond_6

    const-string/jumbo v7, "null"

    :goto_5
    return-object v7

    :cond_6
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .local v5, sb:Ljava/lang/StringBuilder;
    invoke-static {p1}, Landroid/view/ViewDebug;->capturedViewGetPropertyFields(Ljava/lang/Class;)[Ljava/lang/reflect/Field;

    move-result-object v3

    .local v3, fields:[Ljava/lang/reflect/Field;
    array-length v0, v3

    .local v0, count:I
    const/4 v4, 0x0

    .local v4, i:I
    :goto_11
    if-ge v4, v0, :cond_4a

    aget-object v1, v3, v4

    .local v1, field:Ljava/lang/reflect/Field;
    :try_start_15
    invoke-virtual {v1, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .local v2, fieldValue:Ljava/lang/Object;
    invoke-virtual {v5, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v7, "="

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    if-eqz v2, :cond_41

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    const-string v8, "\n"

    const-string v9, "\\n"

    invoke-virtual {v7, v8, v9}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v6

    .local v6, value:Ljava/lang/String;
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .end local v6           #value:Ljava/lang/String;
    :goto_39
    const/16 v7, 0x20

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .end local v2           #fieldValue:Ljava/lang/Object;
    :goto_3e
    add-int/lit8 v4, v4, 0x1

    goto :goto_11

    .restart local v2       #fieldValue:Ljava/lang/Object;
    :cond_41
    const-string/jumbo v7, "null"

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_47
    .catch Ljava/lang/IllegalAccessException; {:try_start_15 .. :try_end_47} :catch_48

    goto :goto_39

    .end local v2           #fieldValue:Ljava/lang/Object;
    :catch_48
    move-exception v7

    goto :goto_3e

    .end local v1           #field:Ljava/lang/reflect/Field;
    :cond_4a
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    goto :goto_5
.end method

.method private static capturedViewExportMethods(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/String;
    .registers 15
    .parameter "obj"
    .parameter
    .parameter "prefix"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .local p1, klass:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    if-nez p0, :cond_6

    const-string/jumbo v9, "null"

    :goto_5
    return-object v9

    :cond_6
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    .local v7, sb:Ljava/lang/StringBuilder;
    invoke-static {p1}, Landroid/view/ViewDebug;->capturedViewGetPropertyMethods(Ljava/lang/Class;)[Ljava/lang/reflect/Method;

    move-result-object v4

    .local v4, methods:[Ljava/lang/reflect/Method;
    array-length v0, v4

    .local v0, count:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_11
    if-ge v1, v0, :cond_80

    aget-object v2, v4, v1

    .local v2, method:Ljava/lang/reflect/Method;
    const/4 v9, 0x0

    :try_start_16
    check-cast v9, [Ljava/lang/Object;

    invoke-virtual {v2, p0, v9}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .local v3, methodValue:Ljava/lang/Object;
    invoke-virtual {v2}, Ljava/lang/reflect/Method;->getReturnType()Ljava/lang/Class;

    move-result-object v6

    .local v6, returnType:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    const-class v9, Landroid/view/ViewDebug$CapturedViewProperty;

    invoke-virtual {v2, v9}, Ljava/lang/reflect/Method;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v5

    check-cast v5, Landroid/view/ViewDebug$CapturedViewProperty;

    .local v5, property:Landroid/view/ViewDebug$CapturedViewProperty;
    invoke-interface {v5}, Landroid/view/ViewDebug$CapturedViewProperty;->retrieveReturn()Z

    move-result v9

    if-eqz v9, :cond_4f

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2}, Ljava/lang/reflect/Method;->getName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "#"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v3, v6, v9}, Landroid/view/ViewDebug;->capturedViewExportMethods(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .end local v3           #methodValue:Ljava/lang/Object;
    .end local v5           #property:Landroid/view/ViewDebug$CapturedViewProperty;
    .end local v6           #returnType:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    :goto_4c
    add-int/lit8 v1, v1, 0x1

    goto :goto_11

    .restart local v3       #methodValue:Ljava/lang/Object;
    .restart local v5       #property:Landroid/view/ViewDebug$CapturedViewProperty;
    .restart local v6       #returnType:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    :cond_4f
    invoke-virtual {v7, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/reflect/Method;->getName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v9, "()="

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    if-eqz v3, :cond_77

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v9

    const-string v10, "\n"

    const-string v11, "\\n"

    invoke-virtual {v9, v10, v11}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v8

    .local v8, value:Ljava/lang/String;
    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .end local v8           #value:Ljava/lang/String;
    :goto_6f
    const-string v9, "; "

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_4c

    .end local v3           #methodValue:Ljava/lang/Object;
    .end local v5           #property:Landroid/view/ViewDebug$CapturedViewProperty;
    .end local v6           #returnType:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    :catch_75
    move-exception v9

    goto :goto_4c

    .restart local v3       #methodValue:Ljava/lang/Object;
    .restart local v5       #property:Landroid/view/ViewDebug$CapturedViewProperty;
    .restart local v6       #returnType:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    :cond_77
    const-string/jumbo v9, "null"

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_7d
    .catch Ljava/lang/IllegalAccessException; {:try_start_16 .. :try_end_7d} :catch_75
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_16 .. :try_end_7d} :catch_7e

    goto :goto_6f

    .end local v3           #methodValue:Ljava/lang/Object;
    .end local v5           #property:Landroid/view/ViewDebug$CapturedViewProperty;
    .end local v6           #returnType:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    :catch_7e
    move-exception v9

    goto :goto_4c

    .end local v2           #method:Ljava/lang/reflect/Method;
    :cond_80
    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    goto :goto_5
.end method

.method private static capturedViewGetPropertyFields(Ljava/lang/Class;)[Ljava/lang/reflect/Field;
    .registers 9
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)[",
            "Ljava/lang/reflect/Field;"
        }
    .end annotation

    .prologue
    .local p0, klass:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    sget-object v7, Landroid/view/ViewDebug;->mCapturedViewFieldsForClasses:Ljava/util/HashMap;

    if-nez v7, :cond_b

    new-instance v7, Ljava/util/HashMap;

    invoke-direct {v7}, Ljava/util/HashMap;-><init>()V

    sput-object v7, Landroid/view/ViewDebug;->mCapturedViewFieldsForClasses:Ljava/util/HashMap;

    :cond_b
    sget-object v6, Landroid/view/ViewDebug;->mCapturedViewFieldsForClasses:Ljava/util/HashMap;

    .local v6, map:Ljava/util/HashMap;,"Ljava/util/HashMap<Ljava/lang/Class<*>;[Ljava/lang/reflect/Field;>;"
    invoke-virtual {v6, p0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Ljava/lang/reflect/Field;

    .local v2, fields:[Ljava/lang/reflect/Field;
    if-eqz v2, :cond_17

    move-object v3, v2

    .end local v2           #fields:[Ljava/lang/reflect/Field;
    .local v3, fields:[Ljava/lang/reflect/Field;
    :goto_16
    return-object v3

    .end local v3           #fields:[Ljava/lang/reflect/Field;
    .restart local v2       #fields:[Ljava/lang/reflect/Field;
    :cond_17
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .local v4, foundFields:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/reflect/Field;>;"
    invoke-virtual {p0}, Ljava/lang/Class;->getFields()[Ljava/lang/reflect/Field;

    move-result-object v2

    array-length v0, v2

    .local v0, count:I
    const/4 v5, 0x0

    .local v5, i:I
    :goto_22
    if-ge v5, v0, :cond_38

    aget-object v1, v2, v5

    .local v1, field:Ljava/lang/reflect/Field;
    const-class v7, Landroid/view/ViewDebug$CapturedViewProperty;

    invoke-virtual {v1, v7}, Ljava/lang/reflect/Field;->isAnnotationPresent(Ljava/lang/Class;)Z

    move-result v7

    if-eqz v7, :cond_35

    const/4 v7, 0x1

    invoke-virtual {v1, v7}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    invoke-virtual {v4, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_35
    add-int/lit8 v5, v5, 0x1

    goto :goto_22

    .end local v1           #field:Ljava/lang/reflect/Field;
    :cond_38
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v7

    new-array v7, v7, [Ljava/lang/reflect/Field;

    invoke-virtual {v4, v7}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v2

    .end local v2           #fields:[Ljava/lang/reflect/Field;
    check-cast v2, [Ljava/lang/reflect/Field;

    .restart local v2       #fields:[Ljava/lang/reflect/Field;
    invoke-virtual {v6, p0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-object v3, v2

    .end local v2           #fields:[Ljava/lang/reflect/Field;
    .restart local v3       #fields:[Ljava/lang/reflect/Field;
    goto :goto_16
.end method

.method private static capturedViewGetPropertyMethods(Ljava/lang/Class;)[Ljava/lang/reflect/Method;
    .registers 10
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)[",
            "Ljava/lang/reflect/Method;"
        }
    .end annotation

    .prologue
    .local p0, klass:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    sget-object v7, Landroid/view/ViewDebug;->mCapturedViewMethodsForClasses:Ljava/util/HashMap;

    if-nez v7, :cond_b

    new-instance v7, Ljava/util/HashMap;

    invoke-direct {v7}, Ljava/util/HashMap;-><init>()V

    sput-object v7, Landroid/view/ViewDebug;->mCapturedViewMethodsForClasses:Ljava/util/HashMap;

    :cond_b
    sget-object v3, Landroid/view/ViewDebug;->mCapturedViewMethodsForClasses:Ljava/util/HashMap;

    .local v3, map:Ljava/util/HashMap;,"Ljava/util/HashMap<Ljava/lang/Class<*>;[Ljava/lang/reflect/Method;>;"
    invoke-virtual {v3, p0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, [Ljava/lang/reflect/Method;

    .local v5, methods:[Ljava/lang/reflect/Method;
    if-eqz v5, :cond_17

    move-object v6, v5

    .end local v5           #methods:[Ljava/lang/reflect/Method;
    .local v6, methods:[Ljava/lang/reflect/Method;
    :goto_16
    return-object v6

    .end local v6           #methods:[Ljava/lang/reflect/Method;
    .restart local v5       #methods:[Ljava/lang/reflect/Method;
    :cond_17
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .local v1, foundMethods:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/reflect/Method;>;"
    invoke-virtual {p0}, Ljava/lang/Class;->getMethods()[Ljava/lang/reflect/Method;

    move-result-object v5

    array-length v0, v5

    .local v0, count:I
    const/4 v2, 0x0

    .local v2, i:I
    :goto_22
    if-ge v2, v0, :cond_47

    aget-object v4, v5, v2

    .local v4, method:Ljava/lang/reflect/Method;
    invoke-virtual {v4}, Ljava/lang/reflect/Method;->getParameterTypes()[Ljava/lang/Class;

    move-result-object v7

    array-length v7, v7

    if-nez v7, :cond_44

    const-class v7, Landroid/view/ViewDebug$CapturedViewProperty;

    invoke-virtual {v4, v7}, Ljava/lang/reflect/Method;->isAnnotationPresent(Ljava/lang/Class;)Z

    move-result v7

    if-eqz v7, :cond_44

    invoke-virtual {v4}, Ljava/lang/reflect/Method;->getReturnType()Ljava/lang/Class;

    move-result-object v7

    const-class v8, Ljava/lang/Void;

    if-eq v7, v8, :cond_44

    const/4 v7, 0x1

    invoke-virtual {v4, v7}, Ljava/lang/reflect/Method;->setAccessible(Z)V

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_44
    add-int/lit8 v2, v2, 0x1

    goto :goto_22

    .end local v4           #method:Ljava/lang/reflect/Method;
    :cond_47
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v7

    new-array v7, v7, [Ljava/lang/reflect/Method;

    invoke-virtual {v1, v7}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v5

    .end local v5           #methods:[Ljava/lang/reflect/Method;
    check-cast v5, [Ljava/lang/reflect/Method;

    .restart local v5       #methods:[Ljava/lang/reflect/Method;
    invoke-virtual {v3, p0, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-object v6, v5

    .end local v5           #methods:[Ljava/lang/reflect/Method;
    .restart local v6       #methods:[Ljava/lang/reflect/Method;
    goto :goto_16
.end method

.method static dispatchCommand(Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/io/OutputStream;)V
    .registers 7
    .parameter "view"
    .parameter "command"
    .parameter "parameters"
    .parameter "clientStream"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    invoke-virtual {p0}, Landroid/view/View;->getRootView()Landroid/view/View;

    move-result-object p0

    const-string v1, "DUMP"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_11

    invoke-static {p0, p3}, Landroid/view/ViewDebug;->dump(Landroid/view/View;Ljava/io/OutputStream;)V

    :cond_10
    :goto_10
    return-void

    :cond_11
    const-string v1, "CAPTURE_LAYERS"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_22

    new-instance v1, Ljava/io/DataOutputStream;

    invoke-direct {v1, p3}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V

    invoke-static {p0, v1}, Landroid/view/ViewDebug;->captureLayers(Landroid/view/View;Ljava/io/DataOutputStream;)V

    goto :goto_10

    :cond_22
    const-string v1, " "

    invoke-virtual {p2, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .local v0, params:[Ljava/lang/String;
    const-string v1, "CAPTURE"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_36

    aget-object v1, v0, v2

    invoke-static {p0, p3, v1}, Landroid/view/ViewDebug;->capture(Landroid/view/View;Ljava/io/OutputStream;Ljava/lang/String;)V

    goto :goto_10

    :cond_36
    const-string v1, "OUTPUT_DISPLAYLIST"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_44

    aget-object v1, v0, v2

    invoke-static {p0, v1}, Landroid/view/ViewDebug;->outputDisplayList(Landroid/view/View;Ljava/lang/String;)V

    goto :goto_10

    :cond_44
    const-string v1, "INVALIDATE"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_52

    aget-object v1, v0, v2

    invoke-static {p0, v1}, Landroid/view/ViewDebug;->invalidate(Landroid/view/View;Ljava/lang/String;)V

    goto :goto_10

    :cond_52
    const-string v1, "REQUEST_LAYOUT"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_60

    aget-object v1, v0, v2

    invoke-static {p0, v1}, Landroid/view/ViewDebug;->requestLayout(Landroid/view/View;Ljava/lang/String;)V

    goto :goto_10

    :cond_60
    const-string v1, "PROFILE"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_10

    aget-object v1, v0, v2

    invoke-static {p0, p3, v1}, Landroid/view/ViewDebug;->profile(Landroid/view/View;Ljava/io/OutputStream;Ljava/lang/String;)V

    goto :goto_10
.end method

.method private static dump(Landroid/view/View;Ljava/io/OutputStream;)V
    .registers 10
    .parameter "root"
    .parameter "clientStream"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .local v3, out:Ljava/io/BufferedWriter;
    :try_start_1
    new-instance v4, Ljava/io/BufferedWriter;

    new-instance v6, Ljava/io/OutputStreamWriter;

    const-string/jumbo v7, "utf-8"

    invoke-direct {v6, p1, v7}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;Ljava/lang/String;)V

    const v7, 0x8000

    invoke-direct {v4, v6, v7}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;I)V
    :try_end_11
    .catchall {:try_start_1 .. :try_end_11} :catchall_42
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_11} :catch_34

    .end local v3           #out:Ljava/io/BufferedWriter;
    .local v4, out:Ljava/io/BufferedWriter;
    :try_start_11
    invoke-virtual {p0}, Landroid/view/View;->getRootView()Landroid/view/View;

    move-result-object v5

    .local v5, view:Landroid/view/View;
    instance-of v6, v5, Landroid/view/ViewGroup;

    if-eqz v6, :cond_25

    move-object v0, v5

    check-cast v0, Landroid/view/ViewGroup;

    move-object v2, v0

    .local v2, group:Landroid/view/ViewGroup;
    invoke-virtual {v2}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v6

    const/4 v7, 0x0

    invoke-static {v6, v2, v4, v7}, Landroid/view/ViewDebug;->dumpViewHierarchyWithProperties(Landroid/content/Context;Landroid/view/ViewGroup;Ljava/io/BufferedWriter;I)V

    .end local v2           #group:Landroid/view/ViewGroup;
    :cond_25
    const-string v6, "DONE."

    invoke-virtual {v4, v6}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    invoke-virtual {v4}, Ljava/io/BufferedWriter;->newLine()V
    :try_end_2d
    .catchall {:try_start_11 .. :try_end_2d} :catchall_49
    .catch Ljava/lang/Exception; {:try_start_11 .. :try_end_2d} :catch_4c

    if-eqz v4, :cond_4f

    invoke-virtual {v4}, Ljava/io/BufferedWriter;->close()V

    move-object v3, v4

    .end local v4           #out:Ljava/io/BufferedWriter;
    .end local v5           #view:Landroid/view/View;
    .restart local v3       #out:Ljava/io/BufferedWriter;
    :cond_33
    :goto_33
    return-void

    :catch_34
    move-exception v1

    .local v1, e:Ljava/lang/Exception;
    :goto_35
    :try_start_35
    const-string v6, "View"

    const-string v7, "Problem dumping the view:"

    invoke-static {v6, v7, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_3c
    .catchall {:try_start_35 .. :try_end_3c} :catchall_42

    if-eqz v3, :cond_33

    invoke-virtual {v3}, Ljava/io/BufferedWriter;->close()V

    goto :goto_33

    .end local v1           #e:Ljava/lang/Exception;
    :catchall_42
    move-exception v6

    :goto_43
    if-eqz v3, :cond_48

    invoke-virtual {v3}, Ljava/io/BufferedWriter;->close()V

    :cond_48
    throw v6

    .end local v3           #out:Ljava/io/BufferedWriter;
    .restart local v4       #out:Ljava/io/BufferedWriter;
    :catchall_49
    move-exception v6

    move-object v3, v4

    .end local v4           #out:Ljava/io/BufferedWriter;
    .restart local v3       #out:Ljava/io/BufferedWriter;
    goto :goto_43

    .end local v3           #out:Ljava/io/BufferedWriter;
    .restart local v4       #out:Ljava/io/BufferedWriter;
    :catch_4c
    move-exception v1

    move-object v3, v4

    .end local v4           #out:Ljava/io/BufferedWriter;
    .restart local v3       #out:Ljava/io/BufferedWriter;
    goto :goto_35

    .end local v3           #out:Ljava/io/BufferedWriter;
    .restart local v4       #out:Ljava/io/BufferedWriter;
    .restart local v5       #view:Landroid/view/View;
    :cond_4f
    move-object v3, v4

    .end local v4           #out:Ljava/io/BufferedWriter;
    .restart local v3       #out:Ljava/io/BufferedWriter;
    goto :goto_33
.end method

.method public static dumpCapturedView(Ljava/lang/String;Ljava/lang/Object;)V
    .registers 6
    .parameter "tag"
    .parameter "view"

    .prologue
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    .local v0, klass:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    new-instance v1, Ljava/lang/StringBuilder;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ": "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .local v1, sb:Ljava/lang/StringBuilder;
    const-string v2, ""

    invoke-static {p1, v0, v2}, Landroid/view/ViewDebug;->capturedViewExportFields(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, ""

    invoke-static {p1, v0, v2}, Landroid/view/ViewDebug;->capturedViewExportMethods(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {p0, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return-void
.end method

.method private static dumpViewHierarchyWithProperties(Landroid/content/Context;Landroid/view/ViewGroup;Ljava/io/BufferedWriter;I)V
    .registers 8
    .parameter "context"
    .parameter "group"
    .parameter "out"
    .parameter "level"

    .prologue
    invoke-static {p0, p1, p2, p3}, Landroid/view/ViewDebug;->dumpViewWithProperties(Landroid/content/Context;Landroid/view/View;Ljava/io/BufferedWriter;I)Z

    move-result v3

    if-nez v3, :cond_7

    :cond_6
    return-void

    :cond_7
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v0

    .local v0, count:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_c
    if-ge v1, v0, :cond_6

    invoke-virtual {p1, v1}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .local v2, view:Landroid/view/View;
    instance-of v3, v2, Landroid/view/ViewGroup;

    if-eqz v3, :cond_20

    check-cast v2, Landroid/view/ViewGroup;

    .end local v2           #view:Landroid/view/View;
    add-int/lit8 v3, p3, 0x1

    invoke-static {p0, v2, p2, v3}, Landroid/view/ViewDebug;->dumpViewHierarchyWithProperties(Landroid/content/Context;Landroid/view/ViewGroup;Ljava/io/BufferedWriter;I)V

    :goto_1d
    add-int/lit8 v1, v1, 0x1

    goto :goto_c

    .restart local v2       #view:Landroid/view/View;
    :cond_20
    add-int/lit8 v3, p3, 0x1

    invoke-static {p0, v2, p2, v3}, Landroid/view/ViewDebug;->dumpViewWithProperties(Landroid/content/Context;Landroid/view/View;Ljava/io/BufferedWriter;I)Z

    goto :goto_1d
.end method

.method private static dumpViewProperties(Landroid/content/Context;Ljava/lang/Object;Ljava/io/BufferedWriter;)V
    .registers 4
    .parameter "context"
    .parameter "view"
    .parameter "out"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const-string v0, ""

    invoke-static {p0, p1, p2, v0}, Landroid/view/ViewDebug;->dumpViewProperties(Landroid/content/Context;Ljava/lang/Object;Ljava/io/BufferedWriter;Ljava/lang/String;)V

    return-void
.end method

.method private static dumpViewProperties(Landroid/content/Context;Ljava/lang/Object;Ljava/io/BufferedWriter;Ljava/lang/String;)V
    .registers 6
    .parameter "context"
    .parameter "view"
    .parameter "out"
    .parameter "prefix"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    .local v0, klass:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    :cond_4
    invoke-static {p0, p1, p2, v0, p3}, Landroid/view/ViewDebug;->exportFields(Landroid/content/Context;Ljava/lang/Object;Ljava/io/BufferedWriter;Ljava/lang/Class;Ljava/lang/String;)V

    invoke-static {p0, p1, p2, v0, p3}, Landroid/view/ViewDebug;->exportMethods(Landroid/content/Context;Ljava/lang/Object;Ljava/io/BufferedWriter;Ljava/lang/Class;Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Class;->getSuperclass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Ljava/lang/Object;

    if-ne v0, v1, :cond_4

    return-void
.end method

.method private static dumpViewWithProperties(Landroid/content/Context;Landroid/view/View;Ljava/io/BufferedWriter;I)Z
    .registers 8
    .parameter "context"
    .parameter "view"
    .parameter "out"
    .parameter "level"

    .prologue
    const/4 v1, 0x0

    .local v1, i:I
    :goto_1
    if-ge v1, p3, :cond_b

    const/16 v2, 0x20

    :try_start_5
    invoke-virtual {p2, v2}, Ljava/io/BufferedWriter;->write(I)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    :cond_b
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p2, v2}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    const/16 v2, 0x40

    invoke-virtual {p2, v2}, Ljava/io/BufferedWriter;->write(I)V

    invoke-virtual {p1}, Ljava/lang/Object;->hashCode()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p2, v2}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    const/16 v2, 0x20

    invoke-virtual {p2, v2}, Ljava/io/BufferedWriter;->write(I)V

    invoke-static {p0, p1, p2}, Landroid/view/ViewDebug;->dumpViewProperties(Landroid/content/Context;Ljava/lang/Object;Ljava/io/BufferedWriter;)V

    invoke-virtual {p2}, Ljava/io/BufferedWriter;->newLine()V
    :try_end_31
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_31} :catch_33

    const/4 v2, 0x1

    :goto_32
    return v2

    :catch_33
    move-exception v0

    .local v0, e:Ljava/io/IOException;
    const-string v2, "View"

    const-string v3, "Error while dumping hierarchy tree"

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    const/4 v2, 0x0

    goto :goto_32
.end method

.method private static exportFields(Landroid/content/Context;Ljava/lang/Object;Ljava/io/BufferedWriter;Ljava/lang/Class;Ljava/lang/String;)V
    .registers 28
    .parameter "context"
    .parameter "view"
    .parameter "out"
    .parameter
    .parameter "prefix"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/Object;",
            "Ljava/io/BufferedWriter;",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .local p3, klass:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    invoke-static/range {p3 .. p3}, Landroid/view/ViewDebug;->getExportedPropertyFields(Ljava/lang/Class;)[Ljava/lang/reflect/Field;

    move-result-object v12

    .local v12, fields:[Ljava/lang/reflect/Field;
    array-length v9, v12

    .local v9, count:I
    const/4 v14, 0x0

    .local v14, i:I
    :goto_6
    if-ge v14, v9, :cond_126

    aget-object v10, v12, v14

    .local v10, field:Ljava/lang/reflect/Field;
    const/4 v11, 0x0

    .local v11, fieldValue:Ljava/lang/Object;
    :try_start_b
    invoke-virtual {v10}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v22

    .local v22, type:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    sget-object v2, Landroid/view/ViewDebug;->sAnnotations:Ljava/util/HashMap;

    invoke-virtual {v2, v10}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/view/ViewDebug$ExportedProperty;

    .local v4, property:Landroid/view/ViewDebug$ExportedProperty;
    invoke-interface {v4}, Landroid/view/ViewDebug$ExportedProperty;->category()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    if-eqz v2, :cond_7b

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {v4}, Landroid/view/ViewDebug$ExportedProperty;->category()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    .local v8, categoryPrefix:Ljava/lang/String;
    :goto_38
    sget-object v2, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    move-object/from16 v0, v22

    if-ne v0, v2, :cond_e8

    invoke-interface {v4}, Landroid/view/ViewDebug$ExportedProperty;->resolveId()Z

    move-result v2

    if-eqz v2, :cond_7e

    if-eqz p0, :cond_7e

    move-object/from16 v0, p1

    invoke-virtual {v10, v0}, Ljava/lang/reflect/Field;->getInt(Ljava/lang/Object;)I

    move-result v15

    .local v15, id:I
    move-object/from16 v0, p0

    invoke-static {v0, v15}, Landroid/view/ViewDebug;->resolveId(Landroid/content/Context;I)Ljava/lang/Object;

    move-result-object v11

    .end local v11           #fieldValue:Ljava/lang/Object;
    .end local v15           #id:I
    :cond_52
    :goto_52
    if-nez v11, :cond_5a

    move-object/from16 v0, p1

    invoke-virtual {v10, v0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    :cond_5a
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, p4

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v10}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v3

    const-string v7, ""

    move-object/from16 v0, p2

    invoke-static {v0, v2, v3, v7, v11}, Landroid/view/ViewDebug;->writeEntry(Ljava/io/BufferedWriter;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .end local v4           #property:Landroid/view/ViewDebug$ExportedProperty;
    .end local v8           #categoryPrefix:Ljava/lang/String;
    .end local v22           #type:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    :goto_78
    add-int/lit8 v14, v14, 0x1

    goto :goto_6

    .restart local v4       #property:Landroid/view/ViewDebug$ExportedProperty;
    .restart local v11       #fieldValue:Ljava/lang/Object;
    .restart local v22       #type:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    :cond_7b
    const-string v8, ""

    goto :goto_38

    .restart local v8       #categoryPrefix:Ljava/lang/String;
    :cond_7e
    invoke-interface {v4}, Landroid/view/ViewDebug$ExportedProperty;->flagMapping()[Landroid/view/ViewDebug$FlagToString;

    move-result-object v13

    .local v13, flagsMapping:[Landroid/view/ViewDebug$FlagToString;
    array-length v2, v13

    if-lez v2, :cond_b3

    move-object/from16 v0, p1

    invoke-virtual {v10, v0}, Ljava/lang/reflect/Field;->getInt(Ljava/lang/Object;)I

    move-result v16

    .local v16, intValue:I
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, p4

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v10}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/16 v3, 0x5f

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .local v6, valuePrefix:Ljava/lang/String;
    move-object/from16 v0, p2

    move/from16 v1, v16

    invoke-static {v0, v13, v1, v6}, Landroid/view/ViewDebug;->exportUnrolledFlags(Ljava/io/BufferedWriter;[Landroid/view/ViewDebug$FlagToString;ILjava/lang/String;)V

    .end local v6           #valuePrefix:Ljava/lang/String;
    .end local v16           #intValue:I
    :cond_b3
    invoke-interface {v4}, Landroid/view/ViewDebug$ExportedProperty;->mapping()[Landroid/view/ViewDebug$IntToString;

    move-result-object v19

    .local v19, mapping:[Landroid/view/ViewDebug$IntToString;
    move-object/from16 v0, v19

    array-length v2, v0

    if-lez v2, :cond_52

    move-object/from16 v0, p1

    invoke-virtual {v10, v0}, Ljava/lang/reflect/Field;->getInt(Ljava/lang/Object;)I

    move-result v16

    .restart local v16       #intValue:I
    move-object/from16 v0, v19

    array-length v0, v0

    move/from16 v20, v0

    .local v20, mappingCount:I
    const/16 v17, 0x0

    .local v17, j:I
    :goto_c9
    move/from16 v0, v17

    move/from16 v1, v20

    if-ge v0, v1, :cond_dd

    aget-object v18, v19, v17

    .local v18, mapped:Landroid/view/ViewDebug$IntToString;
    invoke-interface/range {v18 .. v18}, Landroid/view/ViewDebug$IntToString;->from()I

    move-result v2

    move/from16 v0, v16

    if-ne v2, v0, :cond_e5

    invoke-interface/range {v18 .. v18}, Landroid/view/ViewDebug$IntToString;->to()Ljava/lang/String;

    move-result-object v11

    .end local v11           #fieldValue:Ljava/lang/Object;
    .end local v18           #mapped:Landroid/view/ViewDebug$IntToString;
    :cond_dd
    if-nez v11, :cond_52

    invoke-static/range {v16 .. v16}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    .local v11, fieldValue:Ljava/lang/Integer;
    goto/16 :goto_52

    .local v11, fieldValue:Ljava/lang/Object;
    .restart local v18       #mapped:Landroid/view/ViewDebug$IntToString;
    :cond_e5
    add-int/lit8 v17, v17, 0x1

    goto :goto_c9

    .end local v13           #flagsMapping:[Landroid/view/ViewDebug$FlagToString;
    .end local v16           #intValue:I
    .end local v17           #j:I
    .end local v18           #mapped:Landroid/view/ViewDebug$IntToString;
    .end local v19           #mapping:[Landroid/view/ViewDebug$IntToString;
    .end local v20           #mappingCount:I
    :cond_e8
    const-class v2, [I

    move-object/from16 v0, v22

    if-ne v0, v2, :cond_127

    move-object/from16 v0, p1

    invoke-virtual {v10, v0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [I

    move-object v0, v2

    check-cast v0, [I

    move-object v5, v0

    .local v5, array:[I
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, p4

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v10}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/16 v3, 0x5f

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .restart local v6       #valuePrefix:Ljava/lang/String;
    const-string v21, ""

    .local v21, suffix:Ljava/lang/String;
    const-string v7, ""

    move-object/from16 v2, p0

    move-object/from16 v3, p2

    invoke-static/range {v2 .. v7}, Landroid/view/ViewDebug;->exportUnrolledArray(Landroid/content/Context;Ljava/io/BufferedWriter;Landroid/view/ViewDebug$ExportedProperty;[ILjava/lang/String;Ljava/lang/String;)V

    .end local v4           #property:Landroid/view/ViewDebug$ExportedProperty;
    .end local v5           #array:[I
    .end local v6           #valuePrefix:Ljava/lang/String;
    .end local v8           #categoryPrefix:Ljava/lang/String;
    .end local v10           #field:Ljava/lang/reflect/Field;
    .end local v11           #fieldValue:Ljava/lang/Object;
    .end local v21           #suffix:Ljava/lang/String;
    .end local v22           #type:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    :cond_126
    return-void

    .restart local v4       #property:Landroid/view/ViewDebug$ExportedProperty;
    .restart local v8       #categoryPrefix:Ljava/lang/String;
    .restart local v10       #field:Ljava/lang/reflect/Field;
    .restart local v11       #fieldValue:Ljava/lang/Object;
    .restart local v22       #type:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    :cond_127
    invoke-virtual/range {v22 .. v22}, Ljava/lang/Class;->isPrimitive()Z

    move-result v2

    if-nez v2, :cond_52

    invoke-interface {v4}, Landroid/view/ViewDebug$ExportedProperty;->deepExport()Z

    move-result v2

    if-eqz v2, :cond_52

    move-object/from16 v0, p1

    invoke-virtual {v10, v0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p4

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface {v4}, Landroid/view/ViewDebug$ExportedProperty;->prefix()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-static {v0, v2, v1, v3}, Landroid/view/ViewDebug;->dumpViewProperties(Landroid/content/Context;Ljava/lang/Object;Ljava/io/BufferedWriter;Ljava/lang/String;)V
    :try_end_157
    .catch Ljava/lang/IllegalAccessException; {:try_start_b .. :try_end_157} :catch_159

    goto/16 :goto_78

    .end local v4           #property:Landroid/view/ViewDebug$ExportedProperty;
    .end local v8           #categoryPrefix:Ljava/lang/String;
    .end local v11           #fieldValue:Ljava/lang/Object;
    .end local v22           #type:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    :catch_159
    move-exception v2

    goto/16 :goto_78
.end method

.method private static exportMethods(Landroid/content/Context;Ljava/lang/Object;Ljava/io/BufferedWriter;Ljava/lang/Class;Ljava/lang/String;)V
    .registers 30
    .parameter "context"
    .parameter "view"
    .parameter "out"
    .parameter
    .parameter "prefix"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/Object;",
            "Ljava/io/BufferedWriter;",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .local p3, klass:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    invoke-static/range {p3 .. p3}, Landroid/view/ViewDebug;->getExportedPropertyMethods(Ljava/lang/Class;)[Ljava/lang/reflect/Method;

    move-result-object v22

    .local v22, methods:[Ljava/lang/reflect/Method;
    move-object/from16 v0, v22

    array-length v10, v0

    .local v10, count:I
    const/4 v12, 0x0

    .local v12, i:I
    :goto_8
    if-ge v12, v10, :cond_12c

    aget-object v20, v22, v12

    .local v20, method:Ljava/lang/reflect/Method;
    const/4 v3, 0x0

    :try_start_d
    check-cast v3, [Ljava/lang/Object;

    move-object/from16 v0, v20

    move-object/from16 v1, p1

    invoke-virtual {v0, v1, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v21

    .local v21, methodValue:Ljava/lang/Object;
    invoke-virtual/range {v20 .. v20}, Ljava/lang/reflect/Method;->getReturnType()Ljava/lang/Class;

    move-result-object v23

    .local v23, returnType:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    sget-object v3, Landroid/view/ViewDebug;->sAnnotations:Ljava/util/HashMap;

    move-object/from16 v0, v20

    invoke-virtual {v3, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/view/ViewDebug$ExportedProperty;

    .local v5, property:Landroid/view/ViewDebug$ExportedProperty;
    invoke-interface {v5}, Landroid/view/ViewDebug$ExportedProperty;->category()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    if-eqz v3, :cond_83

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {v5}, Landroid/view/ViewDebug$ExportedProperty;->category()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ":"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    .local v9, categoryPrefix:Ljava/lang/String;
    :goto_46
    sget-object v3, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    move-object/from16 v0, v23

    if-ne v0, v3, :cond_f3

    invoke-interface {v5}, Landroid/view/ViewDebug$ExportedProperty;->resolveId()Z

    move-result v3

    if-eqz v3, :cond_86

    if-eqz p0, :cond_86

    check-cast v21, Ljava/lang/Integer;

    .end local v21           #methodValue:Ljava/lang/Object;
    invoke-virtual/range {v21 .. v21}, Ljava/lang/Integer;->intValue()I

    move-result v13

    .local v13, id:I
    move-object/from16 v0, p0

    invoke-static {v0, v13}, Landroid/view/ViewDebug;->resolveId(Landroid/content/Context;I)Ljava/lang/Object;

    move-result-object v21

    .end local v13           #id:I
    :cond_60
    :goto_60
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p4

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual/range {v20 .. v20}, Ljava/lang/reflect/Method;->getName()Ljava/lang/String;

    move-result-object v4

    const-string v8, "()"

    move-object/from16 v0, p2

    move-object/from16 v1, v21

    invoke-static {v0, v3, v4, v8, v1}, Landroid/view/ViewDebug;->writeEntry(Ljava/io/BufferedWriter;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .end local v5           #property:Landroid/view/ViewDebug$ExportedProperty;
    .end local v9           #categoryPrefix:Ljava/lang/String;
    .end local v23           #returnType:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    :goto_80
    add-int/lit8 v12, v12, 0x1

    goto :goto_8

    .restart local v5       #property:Landroid/view/ViewDebug$ExportedProperty;
    .restart local v21       #methodValue:Ljava/lang/Object;
    .restart local v23       #returnType:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    :cond_83
    const-string v9, ""

    goto :goto_46

    .restart local v9       #categoryPrefix:Ljava/lang/String;
    :cond_86
    invoke-interface {v5}, Landroid/view/ViewDebug$ExportedProperty;->flagMapping()[Landroid/view/ViewDebug$FlagToString;

    move-result-object v11

    .local v11, flagsMapping:[Landroid/view/ViewDebug$FlagToString;
    array-length v3, v11

    if-lez v3, :cond_bc

    move-object/from16 v0, v21

    check-cast v0, Ljava/lang/Integer;

    move-object v3, v0

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v14

    .local v14, intValue:I
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p4

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual/range {v20 .. v20}, Ljava/lang/reflect/Method;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0x5f

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .local v7, valuePrefix:Ljava/lang/String;
    move-object/from16 v0, p2

    invoke-static {v0, v11, v14, v7}, Landroid/view/ViewDebug;->exportUnrolledFlags(Ljava/io/BufferedWriter;[Landroid/view/ViewDebug$FlagToString;ILjava/lang/String;)V

    .end local v7           #valuePrefix:Ljava/lang/String;
    .end local v14           #intValue:I
    :cond_bc
    invoke-interface {v5}, Landroid/view/ViewDebug$ExportedProperty;->mapping()[Landroid/view/ViewDebug$IntToString;

    move-result-object v18

    .local v18, mapping:[Landroid/view/ViewDebug$IntToString;
    move-object/from16 v0, v18

    array-length v3, v0

    if-lez v3, :cond_60

    move-object/from16 v0, v21

    check-cast v0, Ljava/lang/Integer;

    move-object v3, v0

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v14

    .restart local v14       #intValue:I
    const/16 v16, 0x0

    .local v16, mapped:Z
    move-object/from16 v0, v18

    array-length v0, v0

    move/from16 v19, v0

    .local v19, mappingCount:I
    const/4 v15, 0x0

    .local v15, j:I
    :goto_d6
    move/from16 v0, v19

    if-ge v15, v0, :cond_e8

    aget-object v17, v18, v15

    .local v17, mapper:Landroid/view/ViewDebug$IntToString;
    invoke-interface/range {v17 .. v17}, Landroid/view/ViewDebug$IntToString;->from()I

    move-result v3

    if-ne v3, v14, :cond_f0

    invoke-interface/range {v17 .. v17}, Landroid/view/ViewDebug$IntToString;->to()Ljava/lang/String;

    move-result-object v21

    .local v21, methodValue:Ljava/lang/String;
    const/16 v16, 0x1

    .end local v17           #mapper:Landroid/view/ViewDebug$IntToString;
    .end local v21           #methodValue:Ljava/lang/String;
    :cond_e8
    if-nez v16, :cond_60

    invoke-static {v14}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v21

    .local v21, methodValue:Ljava/lang/Integer;
    goto/16 :goto_60

    .restart local v17       #mapper:Landroid/view/ViewDebug$IntToString;
    .local v21, methodValue:Ljava/lang/Object;
    :cond_f0
    add-int/lit8 v15, v15, 0x1

    goto :goto_d6

    .end local v11           #flagsMapping:[Landroid/view/ViewDebug$FlagToString;
    .end local v14           #intValue:I
    .end local v15           #j:I
    .end local v16           #mapped:Z
    .end local v17           #mapper:Landroid/view/ViewDebug$IntToString;
    .end local v18           #mapping:[Landroid/view/ViewDebug$IntToString;
    .end local v19           #mappingCount:I
    :cond_f3
    const-class v3, [I

    move-object/from16 v0, v23

    if-ne v0, v3, :cond_12d

    check-cast v21, [I

    .end local v21           #methodValue:Ljava/lang/Object;
    move-object/from16 v0, v21

    check-cast v0, [I

    move-object v6, v0

    .local v6, array:[I
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p4

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual/range {v20 .. v20}, Ljava/lang/reflect/Method;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0x5f

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .restart local v7       #valuePrefix:Ljava/lang/String;
    const-string v24, "()"

    .local v24, suffix:Ljava/lang/String;
    const-string v8, "()"

    move-object/from16 v3, p0

    move-object/from16 v4, p2

    invoke-static/range {v3 .. v8}, Landroid/view/ViewDebug;->exportUnrolledArray(Landroid/content/Context;Ljava/io/BufferedWriter;Landroid/view/ViewDebug$ExportedProperty;[ILjava/lang/String;Ljava/lang/String;)V

    .end local v5           #property:Landroid/view/ViewDebug$ExportedProperty;
    .end local v6           #array:[I
    .end local v7           #valuePrefix:Ljava/lang/String;
    .end local v9           #categoryPrefix:Ljava/lang/String;
    .end local v20           #method:Ljava/lang/reflect/Method;
    .end local v23           #returnType:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    .end local v24           #suffix:Ljava/lang/String;
    :cond_12c
    return-void

    .restart local v5       #property:Landroid/view/ViewDebug$ExportedProperty;
    .restart local v9       #categoryPrefix:Ljava/lang/String;
    .restart local v20       #method:Ljava/lang/reflect/Method;
    .restart local v21       #methodValue:Ljava/lang/Object;
    .restart local v23       #returnType:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    :cond_12d
    invoke-virtual/range {v23 .. v23}, Ljava/lang/Class;->isPrimitive()Z

    move-result v3

    if-nez v3, :cond_60

    invoke-interface {v5}, Landroid/view/ViewDebug$ExportedProperty;->deepExport()Z

    move-result v3

    if-eqz v3, :cond_60

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p4

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface {v5}, Landroid/view/ViewDebug$ExportedProperty;->prefix()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    move-object/from16 v2, p2

    invoke-static {v0, v1, v2, v3}, Landroid/view/ViewDebug;->dumpViewProperties(Landroid/content/Context;Ljava/lang/Object;Ljava/io/BufferedWriter;Ljava/lang/String;)V
    :try_end_159
    .catch Ljava/lang/IllegalAccessException; {:try_start_d .. :try_end_159} :catch_15b
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_d .. :try_end_159} :catch_15e

    goto/16 :goto_80

    .end local v5           #property:Landroid/view/ViewDebug$ExportedProperty;
    .end local v9           #categoryPrefix:Ljava/lang/String;
    .end local v21           #methodValue:Ljava/lang/Object;
    .end local v23           #returnType:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    :catch_15b
    move-exception v3

    goto/16 :goto_80

    :catch_15e
    move-exception v3

    goto/16 :goto_80
.end method

.method private static exportUnrolledArray(Landroid/content/Context;Ljava/io/BufferedWriter;Landroid/view/ViewDebug$ExportedProperty;[ILjava/lang/String;Ljava/lang/String;)V
    .registers 23
    .parameter "context"
    .parameter "out"
    .parameter "property"
    .parameter "array"
    .parameter "prefix"
    .parameter "suffix"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    invoke-interface/range {p2 .. p2}, Landroid/view/ViewDebug$ExportedProperty;->indexMapping()[Landroid/view/ViewDebug$IntToString;

    move-result-object v5

    .local v5, indexMapping:[Landroid/view/ViewDebug$IntToString;
    array-length v0, v5

    move/from16 v16, v0

    if-lez v16, :cond_6a

    const/4 v3, 0x1

    .local v3, hasIndexMapping:Z
    :goto_a
    invoke-interface/range {p2 .. p2}, Landroid/view/ViewDebug$ExportedProperty;->mapping()[Landroid/view/ViewDebug$IntToString;

    move-result-object v10

    .local v10, mapping:[Landroid/view/ViewDebug$IntToString;
    array-length v0, v10

    move/from16 v16, v0

    if-lez v16, :cond_6c

    const/4 v4, 0x1

    .local v4, hasMapping:Z
    :goto_14
    invoke-interface/range {p2 .. p2}, Landroid/view/ViewDebug$ExportedProperty;->resolveId()Z

    move-result v16

    if-eqz v16, :cond_6e

    if-eqz p0, :cond_6e

    const/4 v13, 0x1

    .local v13, resolveId:Z
    :goto_1d
    move-object/from16 v0, p3

    array-length v15, v0

    .local v15, valuesCount:I
    const/4 v7, 0x0

    .local v7, j:I
    :goto_21
    if-ge v7, v15, :cond_7b

    const/4 v14, 0x0

    .local v14, value:Ljava/lang/String;
    aget v6, p3, v7

    .local v6, intValue:I
    invoke-static {v7}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v12

    .local v12, name:Ljava/lang/String;
    if-eqz v3, :cond_3e

    array-length v11, v5

    .local v11, mappingCount:I
    const/4 v8, 0x0

    .local v8, k:I
    :goto_2e
    if-ge v8, v11, :cond_3e

    aget-object v9, v5, v8

    .local v9, mapped:Landroid/view/ViewDebug$IntToString;
    invoke-interface {v9}, Landroid/view/ViewDebug$IntToString;->from()I

    move-result v16

    move/from16 v0, v16

    if-ne v0, v7, :cond_70

    invoke-interface {v9}, Landroid/view/ViewDebug$IntToString;->to()Ljava/lang/String;

    move-result-object v12

    .end local v8           #k:I
    .end local v9           #mapped:Landroid/view/ViewDebug$IntToString;
    .end local v11           #mappingCount:I
    :cond_3e
    if-eqz v4, :cond_52

    array-length v11, v10

    .restart local v11       #mappingCount:I
    const/4 v8, 0x0

    .restart local v8       #k:I
    :goto_42
    if-ge v8, v11, :cond_52

    aget-object v9, v10, v8

    .restart local v9       #mapped:Landroid/view/ViewDebug$IntToString;
    invoke-interface {v9}, Landroid/view/ViewDebug$IntToString;->from()I

    move-result v16

    move/from16 v0, v16

    if-ne v0, v6, :cond_73

    invoke-interface {v9}, Landroid/view/ViewDebug$IntToString;->to()Ljava/lang/String;

    move-result-object v14

    .end local v8           #k:I
    .end local v9           #mapped:Landroid/view/ViewDebug$IntToString;
    .end local v11           #mappingCount:I
    :cond_52
    if-eqz v13, :cond_76

    if-nez v14, :cond_5e

    move-object/from16 v0, p0

    invoke-static {v0, v6}, Landroid/view/ViewDebug;->resolveId(Landroid/content/Context;I)Ljava/lang/Object;

    move-result-object v14

    .end local v14           #value:Ljava/lang/String;
    check-cast v14, Ljava/lang/String;

    .restart local v14       #value:Ljava/lang/String;
    :cond_5e
    :goto_5e
    move-object/from16 v0, p1

    move-object/from16 v1, p4

    move-object/from16 v2, p5

    invoke-static {v0, v1, v12, v2, v14}, Landroid/view/ViewDebug;->writeEntry(Ljava/io/BufferedWriter;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    add-int/lit8 v7, v7, 0x1

    goto :goto_21

    .end local v3           #hasIndexMapping:Z
    .end local v4           #hasMapping:Z
    .end local v6           #intValue:I
    .end local v7           #j:I
    .end local v10           #mapping:[Landroid/view/ViewDebug$IntToString;
    .end local v12           #name:Ljava/lang/String;
    .end local v13           #resolveId:Z
    .end local v14           #value:Ljava/lang/String;
    .end local v15           #valuesCount:I
    :cond_6a
    const/4 v3, 0x0

    goto :goto_a

    .restart local v3       #hasIndexMapping:Z
    .restart local v10       #mapping:[Landroid/view/ViewDebug$IntToString;
    :cond_6c
    const/4 v4, 0x0

    goto :goto_14

    .restart local v4       #hasMapping:Z
    :cond_6e
    const/4 v13, 0x0

    goto :goto_1d

    .restart local v6       #intValue:I
    .restart local v7       #j:I
    .restart local v8       #k:I
    .restart local v9       #mapped:Landroid/view/ViewDebug$IntToString;
    .restart local v11       #mappingCount:I
    .restart local v12       #name:Ljava/lang/String;
    .restart local v13       #resolveId:Z
    .restart local v14       #value:Ljava/lang/String;
    .restart local v15       #valuesCount:I
    :cond_70
    add-int/lit8 v8, v8, 0x1

    goto :goto_2e

    :cond_73
    add-int/lit8 v8, v8, 0x1

    goto :goto_42

    .end local v8           #k:I
    .end local v9           #mapped:Landroid/view/ViewDebug$IntToString;
    .end local v11           #mappingCount:I
    :cond_76
    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v14

    goto :goto_5e

    .end local v6           #intValue:I
    .end local v12           #name:Ljava/lang/String;
    .end local v14           #value:Ljava/lang/String;
    :cond_7b
    return-void
.end method

.method private static exportUnrolledFlags(Ljava/io/BufferedWriter;[Landroid/view/ViewDebug$FlagToString;ILjava/lang/String;)V
    .registers 14
    .parameter "out"
    .parameter "mapping"
    .parameter "intValue"
    .parameter "prefix"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    array-length v0, p1

    .local v0, count:I
    const/4 v3, 0x0

    .local v3, j:I
    :goto_2
    if-ge v3, v0, :cond_44

    aget-object v1, p1, v3

    .local v1, flagMapping:Landroid/view/ViewDebug$FlagToString;
    invoke-interface {v1}, Landroid/view/ViewDebug$FlagToString;->outputIf()Z

    move-result v2

    .local v2, ifTrue:Z
    invoke-interface {v1}, Landroid/view/ViewDebug$FlagToString;->mask()I

    move-result v8

    and-int v4, p2, v8

    .local v4, maskResult:I
    invoke-interface {v1}, Landroid/view/ViewDebug$FlagToString;->equals()I

    move-result v8

    if-ne v4, v8, :cond_42

    const/4 v6, 0x1

    .local v6, test:Z
    :goto_17
    if-eqz v6, :cond_1b

    if-nez v2, :cond_1f

    :cond_1b
    if-nez v6, :cond_3f

    if-nez v2, :cond_3f

    :cond_1f
    invoke-interface {v1}, Landroid/view/ViewDebug$FlagToString;->name()Ljava/lang/String;

    move-result-object v5

    .local v5, name:Ljava/lang/String;
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "0x"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-static {v4}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .local v7, value:Ljava/lang/String;
    const-string v8, ""

    invoke-static {p0, p3, v5, v8, v7}, Landroid/view/ViewDebug;->writeEntry(Ljava/io/BufferedWriter;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .end local v5           #name:Ljava/lang/String;
    .end local v7           #value:Ljava/lang/String;
    :cond_3f
    add-int/lit8 v3, v3, 0x1

    goto :goto_2

    .end local v6           #test:Z
    :cond_42
    const/4 v6, 0x0

    goto :goto_17

    .end local v1           #flagMapping:Landroid/view/ViewDebug$FlagToString;
    .end local v2           #ifTrue:Z
    .end local v4           #maskResult:I
    :cond_44
    return-void
.end method

.method private static findView(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;
    .registers 10
    .parameter "root"
    .parameter "parameter"

    .prologue
    const/4 v5, 0x0

    const/16 v6, 0x40

    invoke-virtual {p1, v6}, Ljava/lang/String;->indexOf(I)I

    move-result v6

    const/4 v7, -0x1

    if-eq v6, v7, :cond_2c

    const-string v6, "@"

    invoke-virtual {p1, v6}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .local v3, ids:[Ljava/lang/String;
    const/4 v6, 0x0

    aget-object v0, v3, v6

    .local v0, className:Ljava/lang/String;
    const/4 v6, 0x1

    aget-object v6, v3, v6

    const/16 v7, 0x10

    invoke-static {v6, v7}, Ljava/lang/Long;->parseLong(Ljava/lang/String;I)J

    move-result-wide v6

    long-to-int v1, v6

    .local v1, hashCode:I
    invoke-virtual {p0}, Landroid/view/View;->getRootView()Landroid/view/View;

    move-result-object v4

    .local v4, view:Landroid/view/View;
    instance-of v6, v4, Landroid/view/ViewGroup;

    if-eqz v6, :cond_2b

    check-cast v4, Landroid/view/ViewGroup;

    .end local v4           #view:Landroid/view/View;
    invoke-static {v4, v0, v1}, Landroid/view/ViewDebug;->findView(Landroid/view/ViewGroup;Ljava/lang/String;I)Landroid/view/View;

    move-result-object v5

    .end local v0           #className:Ljava/lang/String;
    .end local v1           #hashCode:I
    .end local v3           #ids:[Ljava/lang/String;
    :cond_2b
    :goto_2b
    return-object v5

    :cond_2c
    invoke-virtual {p0}, Landroid/view/View;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6, p1, v5, v5}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v2

    .local v2, id:I
    invoke-virtual {p0}, Landroid/view/View;->getRootView()Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    goto :goto_2b
.end method

.method private static findView(Landroid/view/ViewGroup;Ljava/lang/String;I)Landroid/view/View;
    .registers 8
    .parameter "group"
    .parameter "className"
    .parameter "hashCode"

    .prologue
    invoke-static {p0, p1, p2}, Landroid/view/ViewDebug;->isRequestedView(Landroid/view/View;Ljava/lang/String;I)Z

    move-result v4

    if-eqz v4, :cond_7

    .end local p0
    :goto_6
    return-object p0

    .restart local p0
    :cond_7
    invoke-virtual {p0}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v0

    .local v0, count:I
    const/4 v2, 0x0

    .local v2, i:I
    :goto_c
    if-ge v2, v0, :cond_2b

    invoke-virtual {p0, v2}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .local v3, view:Landroid/view/View;
    instance-of v4, v3, Landroid/view/ViewGroup;

    if-eqz v4, :cond_20

    check-cast v3, Landroid/view/ViewGroup;

    .end local v3           #view:Landroid/view/View;
    invoke-static {v3, p1, p2}, Landroid/view/ViewDebug;->findView(Landroid/view/ViewGroup;Ljava/lang/String;I)Landroid/view/View;

    move-result-object v1

    .local v1, found:Landroid/view/View;
    if-eqz v1, :cond_28

    move-object p0, v1

    goto :goto_6

    .end local v1           #found:Landroid/view/View;
    .restart local v3       #view:Landroid/view/View;
    :cond_20
    invoke-static {v3, p1, p2}, Landroid/view/ViewDebug;->isRequestedView(Landroid/view/View;Ljava/lang/String;I)Z

    move-result v4

    if-eqz v4, :cond_28

    move-object p0, v3

    goto :goto_6

    .end local v3           #view:Landroid/view/View;
    :cond_28
    add-int/lit8 v2, v2, 0x1

    goto :goto_c

    :cond_2b
    const/4 p0, 0x0

    goto :goto_6
.end method

.method private static getExportedPropertyFields(Ljava/lang/Class;)[Ljava/lang/reflect/Field;
    .registers 10
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)[",
            "Ljava/lang/reflect/Field;"
        }
    .end annotation

    .prologue
    .local p0, klass:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    sget-object v7, Landroid/view/ViewDebug;->sFieldsForClasses:Ljava/util/HashMap;

    if-nez v7, :cond_b

    new-instance v7, Ljava/util/HashMap;

    invoke-direct {v7}, Ljava/util/HashMap;-><init>()V

    sput-object v7, Landroid/view/ViewDebug;->sFieldsForClasses:Ljava/util/HashMap;

    :cond_b
    sget-object v7, Landroid/view/ViewDebug;->sAnnotations:Ljava/util/HashMap;

    if-nez v7, :cond_18

    new-instance v7, Ljava/util/HashMap;

    const/16 v8, 0x200

    invoke-direct {v7, v8}, Ljava/util/HashMap;-><init>(I)V

    sput-object v7, Landroid/view/ViewDebug;->sAnnotations:Ljava/util/HashMap;

    :cond_18
    sget-object v6, Landroid/view/ViewDebug;->sFieldsForClasses:Ljava/util/HashMap;

    .local v6, map:Ljava/util/HashMap;,"Ljava/util/HashMap<Ljava/lang/Class<*>;[Ljava/lang/reflect/Field;>;"
    invoke-virtual {v6, p0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Ljava/lang/reflect/Field;

    .local v2, fields:[Ljava/lang/reflect/Field;
    if-eqz v2, :cond_24

    move-object v3, v2

    .end local v2           #fields:[Ljava/lang/reflect/Field;
    .local v3, fields:[Ljava/lang/reflect/Field;
    :goto_23
    return-object v3

    .end local v3           #fields:[Ljava/lang/reflect/Field;
    .restart local v2       #fields:[Ljava/lang/reflect/Field;
    :cond_24
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .local v4, foundFields:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/reflect/Field;>;"
    invoke-virtual {p0}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v2

    array-length v0, v2

    .local v0, count:I
    const/4 v5, 0x0

    .local v5, i:I
    :goto_2f
    if-ge v5, v0, :cond_50

    aget-object v1, v2, v5

    .local v1, field:Ljava/lang/reflect/Field;
    const-class v7, Landroid/view/ViewDebug$ExportedProperty;

    invoke-virtual {v1, v7}, Ljava/lang/reflect/Field;->isAnnotationPresent(Ljava/lang/Class;)Z

    move-result v7

    if-eqz v7, :cond_4d

    const/4 v7, 0x1

    invoke-virtual {v1, v7}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    invoke-virtual {v4, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    sget-object v7, Landroid/view/ViewDebug;->sAnnotations:Ljava/util/HashMap;

    const-class v8, Landroid/view/ViewDebug$ExportedProperty;

    invoke-virtual {v1, v8}, Ljava/lang/reflect/Field;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v8

    invoke-virtual {v7, v1, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_4d
    add-int/lit8 v5, v5, 0x1

    goto :goto_2f

    .end local v1           #field:Ljava/lang/reflect/Field;
    :cond_50
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v7

    new-array v7, v7, [Ljava/lang/reflect/Field;

    invoke-virtual {v4, v7}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v2

    .end local v2           #fields:[Ljava/lang/reflect/Field;
    check-cast v2, [Ljava/lang/reflect/Field;

    .restart local v2       #fields:[Ljava/lang/reflect/Field;
    invoke-virtual {v6, p0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-object v3, v2

    .end local v2           #fields:[Ljava/lang/reflect/Field;
    .restart local v3       #fields:[Ljava/lang/reflect/Field;
    goto :goto_23
.end method

.method private static getExportedPropertyMethods(Ljava/lang/Class;)[Ljava/lang/reflect/Method;
    .registers 10
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)[",
            "Ljava/lang/reflect/Method;"
        }
    .end annotation

    .prologue
    .local p0, klass:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    sget-object v7, Landroid/view/ViewDebug;->sMethodsForClasses:Ljava/util/HashMap;

    if-nez v7, :cond_d

    new-instance v7, Ljava/util/HashMap;

    const/16 v8, 0x64

    invoke-direct {v7, v8}, Ljava/util/HashMap;-><init>(I)V

    sput-object v7, Landroid/view/ViewDebug;->sMethodsForClasses:Ljava/util/HashMap;

    :cond_d
    sget-object v7, Landroid/view/ViewDebug;->sAnnotations:Ljava/util/HashMap;

    if-nez v7, :cond_1a

    new-instance v7, Ljava/util/HashMap;

    const/16 v8, 0x200

    invoke-direct {v7, v8}, Ljava/util/HashMap;-><init>(I)V

    sput-object v7, Landroid/view/ViewDebug;->sAnnotations:Ljava/util/HashMap;

    :cond_1a
    sget-object v3, Landroid/view/ViewDebug;->sMethodsForClasses:Ljava/util/HashMap;

    .local v3, map:Ljava/util/HashMap;,"Ljava/util/HashMap<Ljava/lang/Class<*>;[Ljava/lang/reflect/Method;>;"
    invoke-virtual {v3, p0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, [Ljava/lang/reflect/Method;

    .local v5, methods:[Ljava/lang/reflect/Method;
    if-eqz v5, :cond_26

    move-object v6, v5

    .end local v5           #methods:[Ljava/lang/reflect/Method;
    .local v6, methods:[Ljava/lang/reflect/Method;
    :goto_25
    return-object v6

    .end local v6           #methods:[Ljava/lang/reflect/Method;
    .restart local v5       #methods:[Ljava/lang/reflect/Method;
    :cond_26
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .local v1, foundMethods:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/reflect/Method;>;"
    invoke-virtual {p0}, Ljava/lang/Class;->getDeclaredMethods()[Ljava/lang/reflect/Method;

    move-result-object v5

    array-length v0, v5

    .local v0, count:I
    const/4 v2, 0x0

    .local v2, i:I
    :goto_31
    if-ge v2, v0, :cond_61

    aget-object v4, v5, v2

    .local v4, method:Ljava/lang/reflect/Method;
    invoke-virtual {v4}, Ljava/lang/reflect/Method;->getParameterTypes()[Ljava/lang/Class;

    move-result-object v7

    array-length v7, v7

    if-nez v7, :cond_5e

    const-class v7, Landroid/view/ViewDebug$ExportedProperty;

    invoke-virtual {v4, v7}, Ljava/lang/reflect/Method;->isAnnotationPresent(Ljava/lang/Class;)Z

    move-result v7

    if-eqz v7, :cond_5e

    invoke-virtual {v4}, Ljava/lang/reflect/Method;->getReturnType()Ljava/lang/Class;

    move-result-object v7

    const-class v8, Ljava/lang/Void;

    if-eq v7, v8, :cond_5e

    const/4 v7, 0x1

    invoke-virtual {v4, v7}, Ljava/lang/reflect/Method;->setAccessible(Z)V

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    sget-object v7, Landroid/view/ViewDebug;->sAnnotations:Ljava/util/HashMap;

    const-class v8, Landroid/view/ViewDebug$ExportedProperty;

    invoke-virtual {v4, v8}, Ljava/lang/reflect/Method;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v8

    invoke-virtual {v7, v4, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_5e
    add-int/lit8 v2, v2, 0x1

    goto :goto_31

    .end local v4           #method:Ljava/lang/reflect/Method;
    :cond_61
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v7

    new-array v7, v7, [Ljava/lang/reflect/Method;

    invoke-virtual {v1, v7}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v5

    .end local v5           #methods:[Ljava/lang/reflect/Method;
    check-cast v5, [Ljava/lang/reflect/Method;

    .restart local v5       #methods:[Ljava/lang/reflect/Method;
    invoke-virtual {v3, p0, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-object v6, v5

    .end local v5           #methods:[Ljava/lang/reflect/Method;
    .restart local v6       #methods:[Ljava/lang/reflect/Method;
    goto :goto_25
.end method

.method public static getViewInstanceCount()J
    .registers 2

    .prologue
    const-class v0, Landroid/view/View;

    invoke-static {v0}, Landroid/os/Debug;->countInstancesOfClass(Ljava/lang/Class;)J

    move-result-wide v0

    return-wide v0
.end method

.method public static getViewRootImplCount()J
    .registers 2

    .prologue
    const-class v0, Landroid/view/ViewRootImpl;

    invoke-static {v0}, Landroid/os/Debug;->countInstancesOfClass(Ljava/lang/Class;)J

    move-result-wide v0

    return-wide v0
.end method

.method private static invalidate(Landroid/view/View;Ljava/lang/String;)V
    .registers 3
    .parameter "root"
    .parameter "parameter"

    .prologue
    invoke-static {p0, p1}, Landroid/view/ViewDebug;->findView(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;

    move-result-object v0

    .local v0, view:Landroid/view/View;
    if-eqz v0, :cond_9

    invoke-virtual {v0}, Landroid/view/View;->postInvalidate()V

    :cond_9
    return-void
.end method

.method private static isRequestedView(Landroid/view/View;Ljava/lang/String;I)Z
    .registers 4
    .parameter "view"
    .parameter "className"
    .parameter "hashCode"

    .prologue
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_16

    invoke-virtual {p0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    if-ne v0, p2, :cond_16

    const/4 v0, 0x1

    :goto_15
    return v0

    :cond_16
    const/4 v0, 0x0

    goto :goto_15
.end method

.method private static outputDisplayList(Landroid/view/View;Ljava/lang/String;)V
    .registers 4
    .parameter "root"
    .parameter "parameter"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    invoke-static {p0, p1}, Landroid/view/ViewDebug;->findView(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;

    move-result-object v0

    .local v0, view:Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getViewRootImpl()Landroid/view/ViewRootImpl;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/view/ViewRootImpl;->outputDisplayList(Landroid/view/View;)V

    return-void
.end method

.method private static performViewCapture(Landroid/view/View;Z)Landroid/graphics/Bitmap;
    .registers 8
    .parameter "captureView"
    .parameter "skpiChildren"

    .prologue
    const/4 v3, 0x1

    if-eqz p0, :cond_3d

    new-instance v2, Ljava/util/concurrent/CountDownLatch;

    invoke-direct {v2, v3}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    .local v2, latch:Ljava/util/concurrent/CountDownLatch;
    new-array v0, v3, [Landroid/graphics/Bitmap;

    .local v0, cache:[Landroid/graphics/Bitmap;
    new-instance v3, Landroid/view/ViewDebug$6;

    invoke-direct {v3, v0, p0, p1, v2}, Landroid/view/ViewDebug$6;-><init>([Landroid/graphics/Bitmap;Landroid/view/View;ZLjava/util/concurrent/CountDownLatch;)V

    invoke-virtual {p0, v3}, Landroid/view/View;->post(Ljava/lang/Runnable;)Z

    const-wide/16 v3, 0xfa0

    :try_start_14
    sget-object v5, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v2, v3, v4, v5}, Ljava/util/concurrent/CountDownLatch;->await(JLjava/util/concurrent/TimeUnit;)Z

    const/4 v3, 0x0

    aget-object v3, v0, v3
    :try_end_1c
    .catch Ljava/lang/InterruptedException; {:try_start_14 .. :try_end_1c} :catch_1d

    .end local v0           #cache:[Landroid/graphics/Bitmap;
    .end local v2           #latch:Ljava/util/concurrent/CountDownLatch;
    :goto_1c
    return-object v3

    .restart local v0       #cache:[Landroid/graphics/Bitmap;
    .restart local v2       #latch:Ljava/util/concurrent/CountDownLatch;
    :catch_1d
    move-exception v1

    .local v1, e:Ljava/lang/InterruptedException;
    const-string v3, "View"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Could not complete the capture of the view "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Thread;->interrupt()V

    .end local v0           #cache:[Landroid/graphics/Bitmap;
    .end local v1           #e:Ljava/lang/InterruptedException;
    .end local v2           #latch:Ljava/util/concurrent/CountDownLatch;
    :cond_3d
    const/4 v3, 0x0

    goto :goto_1c
.end method

.method private static profile(Landroid/view/View;Ljava/io/OutputStream;Ljava/lang/String;)V
    .registers 9
    .parameter "root"
    .parameter "clientStream"
    .parameter "parameter"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    invoke-static {p0, p2}, Landroid/view/ViewDebug;->findView(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;

    move-result-object v3

    .local v3, view:Landroid/view/View;
    const/4 v1, 0x0

    .local v1, out:Ljava/io/BufferedWriter;
    :try_start_5
    new-instance v2, Ljava/io/BufferedWriter;

    new-instance v4, Ljava/io/OutputStreamWriter;

    invoke-direct {v4, p1}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;)V

    const v5, 0x8000

    invoke-direct {v2, v4, v5}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;I)V
    :try_end_12
    .catchall {:try_start_5 .. :try_end_12} :catchall_3e
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_12} :catch_48

    .end local v1           #out:Ljava/io/BufferedWriter;
    .local v2, out:Ljava/io/BufferedWriter;
    if-eqz v3, :cond_26

    :try_start_14
    invoke-static {v3, v2}, Landroid/view/ViewDebug;->profileViewAndChildren(Landroid/view/View;Ljava/io/BufferedWriter;)V

    :goto_17
    const-string v4, "DONE."

    invoke-virtual {v2, v4}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/io/BufferedWriter;->newLine()V
    :try_end_1f
    .catchall {:try_start_14 .. :try_end_1f} :catchall_45
    .catch Ljava/lang/Exception; {:try_start_14 .. :try_end_1f} :catch_2f

    if-eqz v2, :cond_4a

    invoke-virtual {v2}, Ljava/io/BufferedWriter;->close()V

    move-object v1, v2

    .end local v2           #out:Ljava/io/BufferedWriter;
    .restart local v1       #out:Ljava/io/BufferedWriter;
    :cond_25
    :goto_25
    return-void

    .end local v1           #out:Ljava/io/BufferedWriter;
    .restart local v2       #out:Ljava/io/BufferedWriter;
    :cond_26
    :try_start_26
    const-string v4, "-1 -1 -1"

    invoke-virtual {v2, v4}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/io/BufferedWriter;->newLine()V
    :try_end_2e
    .catchall {:try_start_26 .. :try_end_2e} :catchall_45
    .catch Ljava/lang/Exception; {:try_start_26 .. :try_end_2e} :catch_2f

    goto :goto_17

    :catch_2f
    move-exception v0

    move-object v1, v2

    .end local v2           #out:Ljava/io/BufferedWriter;
    .local v0, e:Ljava/lang/Exception;
    .restart local v1       #out:Ljava/io/BufferedWriter;
    :goto_31
    :try_start_31
    const-string v4, "View"

    const-string v5, "Problem profiling the view:"

    invoke-static {v4, v5, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_38
    .catchall {:try_start_31 .. :try_end_38} :catchall_3e

    if-eqz v1, :cond_25

    invoke-virtual {v1}, Ljava/io/BufferedWriter;->close()V

    goto :goto_25

    .end local v0           #e:Ljava/lang/Exception;
    :catchall_3e
    move-exception v4

    :goto_3f
    if-eqz v1, :cond_44

    invoke-virtual {v1}, Ljava/io/BufferedWriter;->close()V

    :cond_44
    throw v4

    .end local v1           #out:Ljava/io/BufferedWriter;
    .restart local v2       #out:Ljava/io/BufferedWriter;
    :catchall_45
    move-exception v4

    move-object v1, v2

    .end local v2           #out:Ljava/io/BufferedWriter;
    .restart local v1       #out:Ljava/io/BufferedWriter;
    goto :goto_3f

    :catch_48
    move-exception v0

    goto :goto_31

    .end local v1           #out:Ljava/io/BufferedWriter;
    .restart local v2       #out:Ljava/io/BufferedWriter;
    :cond_4a
    move-object v1, v2

    .end local v2           #out:Ljava/io/BufferedWriter;
    .restart local v1       #out:Ljava/io/BufferedWriter;
    goto :goto_25
.end method

.method private static profileViewAndChildren(Landroid/view/View;Ljava/io/BufferedWriter;)V
    .registers 3
    .parameter "view"
    .parameter "out"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x1

    invoke-static {p0, p1, v0}, Landroid/view/ViewDebug;->profileViewAndChildren(Landroid/view/View;Ljava/io/BufferedWriter;Z)V

    return-void
.end method

.method private static profileViewAndChildren(Landroid/view/View;Ljava/io/BufferedWriter;Z)V
    .registers 14
    .parameter "view"
    .parameter "out"
    .parameter "root"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v10, 0x20

    const-wide/16 v1, 0x0

    if-nez p2, :cond_c

    iget v9, p0, Landroid/view/View;->mPrivateFlags:I

    and-int/lit16 v9, v9, 0x800

    if-eqz v9, :cond_74

    :cond_c
    new-instance v9, Landroid/view/ViewDebug$2;

    invoke-direct {v9, p0}, Landroid/view/ViewDebug$2;-><init>(Landroid/view/View;)V

    invoke-static {p0, v9}, Landroid/view/ViewDebug;->profileViewOperation(Landroid/view/View;Landroid/view/ViewDebug$ViewOperation;)J

    move-result-wide v5

    .local v5, durationMeasure:J
    :goto_15
    if-nez p2, :cond_1d

    iget v9, p0, Landroid/view/View;->mPrivateFlags:I

    and-int/lit16 v9, v9, 0x2000

    if-eqz v9, :cond_76

    :cond_1d
    new-instance v9, Landroid/view/ViewDebug$3;

    invoke-direct {v9, p0}, Landroid/view/ViewDebug$3;-><init>(Landroid/view/View;)V

    invoke-static {p0, v9}, Landroid/view/ViewDebug;->profileViewOperation(Landroid/view/View;Landroid/view/ViewDebug$ViewOperation;)J

    move-result-wide v3

    .local v3, durationLayout:J
    :goto_26
    if-nez p2, :cond_34

    invoke-virtual {p0}, Landroid/view/View;->willNotDraw()Z

    move-result v9

    if-eqz v9, :cond_34

    iget v9, p0, Landroid/view/View;->mPrivateFlags:I

    and-int/lit8 v9, v9, 0x20

    if-eqz v9, :cond_3d

    :cond_34
    new-instance v9, Landroid/view/ViewDebug$4;

    invoke-direct {v9, p0}, Landroid/view/ViewDebug$4;-><init>(Landroid/view/View;)V

    invoke-static {p0, v9}, Landroid/view/ViewDebug;->profileViewOperation(Landroid/view/View;Landroid/view/ViewDebug$ViewOperation;)J

    move-result-wide v1

    .local v1, durationDraw:J
    :cond_3d
    invoke-static {v5, v6}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {p1, v9}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    invoke-virtual {p1, v10}, Ljava/io/BufferedWriter;->write(I)V

    invoke-static {v3, v4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {p1, v9}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    invoke-virtual {p1, v10}, Ljava/io/BufferedWriter;->write(I)V

    invoke-static {v1, v2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {p1, v9}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    invoke-virtual {p1}, Ljava/io/BufferedWriter;->newLine()V

    instance-of v9, p0, Landroid/view/ViewGroup;

    if-eqz v9, :cond_78

    move-object v7, p0

    check-cast v7, Landroid/view/ViewGroup;

    .local v7, group:Landroid/view/ViewGroup;
    invoke-virtual {v7}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v0

    .local v0, count:I
    const/4 v8, 0x0

    .local v8, i:I
    :goto_67
    if-ge v8, v0, :cond_78

    invoke-virtual {v7, v8}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v9

    const/4 v10, 0x0

    invoke-static {v9, p1, v10}, Landroid/view/ViewDebug;->profileViewAndChildren(Landroid/view/View;Ljava/io/BufferedWriter;Z)V

    add-int/lit8 v8, v8, 0x1

    goto :goto_67

    .end local v0           #count:I
    .end local v1           #durationDraw:J
    .end local v3           #durationLayout:J
    .end local v5           #durationMeasure:J
    .end local v7           #group:Landroid/view/ViewGroup;
    .end local v8           #i:I
    :cond_74
    move-wide v5, v1

    goto :goto_15

    .restart local v5       #durationMeasure:J
    :cond_76
    move-wide v3, v1

    goto :goto_26

    .restart local v1       #durationDraw:J
    .restart local v3       #durationLayout:J
    :cond_78
    return-void
.end method

.method private static profileViewOperation(Landroid/view/View;Landroid/view/ViewDebug$ViewOperation;)J
    .registers 10
    .parameter "view"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Landroid/view/View;",
            "Landroid/view/ViewDebug$ViewOperation",
            "<TT;>;)J"
        }
    .end annotation

    .prologue
    .local p1, operation:Landroid/view/ViewDebug$ViewOperation;,"Landroid/view/ViewDebug$ViewOperation<TT;>;"
    const-wide/16 v3, -0x1

    const/4 v5, 0x1

    new-instance v2, Ljava/util/concurrent/CountDownLatch;

    invoke-direct {v2, v5}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    .local v2, latch:Ljava/util/concurrent/CountDownLatch;
    new-array v0, v5, [J

    .local v0, duration:[J
    new-instance v5, Landroid/view/ViewDebug$5;

    invoke-direct {v5, p1, v0, v2}, Landroid/view/ViewDebug$5;-><init>(Landroid/view/ViewDebug$ViewOperation;[JLjava/util/concurrent/CountDownLatch;)V

    invoke-virtual {p0, v5}, Landroid/view/View;->post(Ljava/lang/Runnable;)Z

    const-wide/16 v5, 0xfa0

    :try_start_14
    sget-object v7, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v2, v5, v6, v7}, Ljava/util/concurrent/CountDownLatch;->await(JLjava/util/concurrent/TimeUnit;)Z

    move-result v5

    if-nez v5, :cond_56

    const-string v5, "View"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Could not complete the profiling of the view "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_34
    .catch Ljava/lang/InterruptedException; {:try_start_14 .. :try_end_34} :catch_35

    :goto_34
    return-wide v3

    :catch_35
    move-exception v1

    .local v1, e:Ljava/lang/InterruptedException;
    const-string v5, "View"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Could not complete the profiling of the view "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Thread;->interrupt()V

    goto :goto_34

    .end local v1           #e:Ljava/lang/InterruptedException;
    :cond_56
    const/4 v3, 0x0

    aget-wide v3, v0, v3

    goto :goto_34
.end method

.method private static requestLayout(Landroid/view/View;Ljava/lang/String;)V
    .registers 4
    .parameter "root"
    .parameter "parameter"

    .prologue
    invoke-static {p0, p1}, Landroid/view/ViewDebug;->findView(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;

    move-result-object v0

    .local v0, view:Landroid/view/View;
    if-eqz v0, :cond_e

    new-instance v1, Landroid/view/ViewDebug$1;

    invoke-direct {v1, v0}, Landroid/view/ViewDebug$1;-><init>(Landroid/view/View;)V

    invoke-virtual {p0, v1}, Landroid/view/View;->post(Ljava/lang/Runnable;)Z

    :cond_e
    return-void
.end method

.method static resolveId(Landroid/content/Context;I)Ljava/lang/Object;
    .registers 7
    .parameter "context"
    .parameter "id"

    .prologue
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .local v2, resources:Landroid/content/res/Resources;
    if-ltz p1, :cond_3f

    :try_start_6
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p1}, Landroid/content/res/Resources;->getResourceTypeName(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0x2f

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v2, p1}, Landroid/content/res/Resources;->getResourceEntryName(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_24
    .catch Landroid/content/res/Resources$NotFoundException; {:try_start_6 .. :try_end_24} :catch_26

    move-result-object v1

    .local v1, fieldValue:Ljava/lang/String;
    :goto_25
    return-object v1

    .end local v1           #fieldValue:Ljava/lang/String;
    :catch_26
    move-exception v0

    .local v0, e:Landroid/content/res/Resources$NotFoundException;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "id/0x"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {p1}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .restart local v1       #fieldValue:Ljava/lang/String;
    goto :goto_25

    .end local v0           #e:Landroid/content/res/Resources$NotFoundException;
    .end local v1           #fieldValue:Ljava/lang/String;
    :cond_3f
    const-string v1, "NO_ID"

    .restart local v1       #fieldValue:Ljava/lang/String;
    goto :goto_25
.end method

.method public static startHierarchyTracing(Ljava/lang/String;Landroid/view/View;)V
    .registers 2
    .parameter "prefix"
    .parameter "view"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    return-void
.end method

.method public static startRecyclerTracing(Ljava/lang/String;Landroid/view/View;)V
    .registers 2
    .parameter "prefix"
    .parameter "view"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    return-void
.end method

.method public static stopHierarchyTracing()V
    .registers 0
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    return-void
.end method

.method public static stopRecyclerTracing()V
    .registers 0
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    return-void
.end method

.method public static trace(Landroid/view/View;Landroid/view/ViewDebug$HierarchyTraceType;)V
    .registers 2
    .parameter "view"
    .parameter "type"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    return-void
.end method

.method public static varargs trace(Landroid/view/View;Landroid/view/ViewDebug$RecyclerTraceType;[I)V
    .registers 3
    .parameter "view"
    .parameter "type"
    .parameter "parameters"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    return-void
.end method

.method private static writeEntry(Ljava/io/BufferedWriter;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    .registers 6
    .parameter "out"
    .parameter "prefix"
    .parameter "name"
    .parameter "suffix"
    .parameter "value"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    invoke-virtual {p0, p1}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    invoke-virtual {p0, p2}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    invoke-virtual {p0, p3}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    const-string v0, "="

    invoke-virtual {p0, v0}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    invoke-static {p0, p4}, Landroid/view/ViewDebug;->writeValue(Ljava/io/BufferedWriter;Ljava/lang/Object;)V

    const/16 v0, 0x20

    invoke-virtual {p0, v0}, Ljava/io/BufferedWriter;->write(I)V

    return-void
.end method

.method private static writeValue(Ljava/io/BufferedWriter;Ljava/lang/Object;)V
    .registers 6
    .parameter "out"
    .parameter "value"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    if-eqz p1, :cond_22

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "\n"

    const-string v3, "\\n"

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .local v0, output:Ljava/lang/String;
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    const-string v1, ","

    invoke-virtual {p0, v1}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    .end local v0           #output:Ljava/lang/String;
    :goto_21
    return-void

    :cond_22
    const-string v1, "4,null"

    invoke-virtual {p0, v1}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    goto :goto_21
.end method
