.class Landroid/webkit/WebViewClassic$6;
.super Ljava/lang/Object;
.source "WebViewClassic.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/webkit/WebViewClassic;->savePicture(Landroid/os/Bundle;Ljava/io/File;)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/webkit/WebViewClassic;

.field final synthetic val$dest:Ljava/io/File;

.field final synthetic val$p:Landroid/graphics/Picture;

.field final synthetic val$temp:Ljava/io/File;


# direct methods
.method constructor <init>(Landroid/webkit/WebViewClassic;Ljava/io/File;Landroid/graphics/Picture;Ljava/io/File;)V
    .registers 5
    .parameter
    .parameter
    .parameter
    .parameter

    .prologue
    .line 2303
    iput-object p1, p0, Landroid/webkit/WebViewClassic$6;->this$0:Landroid/webkit/WebViewClassic;

    iput-object p2, p0, Landroid/webkit/WebViewClassic$6;->val$temp:Ljava/io/File;

    iput-object p3, p0, Landroid/webkit/WebViewClassic$6;->val$p:Landroid/graphics/Picture;

    iput-object p4, p0, Landroid/webkit/WebViewClassic$6;->val$dest:Ljava/io/File;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 5

    .prologue
    .line 2306
    const/4 v0, 0x0

    .line 2308
    .local v0, out:Ljava/io/FileOutputStream;
    :try_start_1
    new-instance v1, Ljava/io/FileOutputStream;

    iget-object v2, p0, Landroid/webkit/WebViewClassic$6;->val$temp:Ljava/io/File;

    invoke-direct {v1, v2}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    :try_end_8
    .catchall {:try_start_1 .. :try_end_8} :catchall_20
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_8} :catch_2c

    .line 2309
    .end local v0           #out:Ljava/io/FileOutputStream;
    .local v1, out:Ljava/io/FileOutputStream;
    :try_start_8
    iget-object v2, p0, Landroid/webkit/WebViewClassic$6;->val$p:Landroid/graphics/Picture;

    invoke-virtual {v2, v1}, Landroid/graphics/Picture;->writeToStream(Ljava/io/OutputStream;)V

    .line 2312
    iget-object v2, p0, Landroid/webkit/WebViewClassic$6;->val$temp:Ljava/io/File;

    iget-object v3, p0, Landroid/webkit/WebViewClassic$6;->val$dest:Ljava/io/File;

    invoke-virtual {v2, v3}, Ljava/io/File;->renameTo(Ljava/io/File;)Z
    :try_end_14
    .catchall {:try_start_8 .. :try_end_14} :catchall_3e
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_14} :catch_41

    .line 2316
    if-eqz v1, :cond_19

    .line 2318
    :try_start_16
    invoke-virtual {v1}, Ljava/io/FileOutputStream;->close()V
    :try_end_19
    .catch Ljava/lang/Exception; {:try_start_16 .. :try_end_19} :catch_3c

    .line 2323
    :cond_19
    :goto_19
    iget-object v2, p0, Landroid/webkit/WebViewClassic$6;->val$temp:Ljava/io/File;

    invoke-virtual {v2}, Ljava/io/File;->delete()Z

    move-object v0, v1

    .line 2325
    .end local v1           #out:Ljava/io/FileOutputStream;
    .restart local v0       #out:Ljava/io/FileOutputStream;
    :goto_1f
    return-void

    .line 2316
    :catchall_20
    move-exception v2

    :goto_21
    if-eqz v0, :cond_26

    .line 2318
    :try_start_23
    invoke-virtual {v0}, Ljava/io/FileOutputStream;->close()V
    :try_end_26
    .catch Ljava/lang/Exception; {:try_start_23 .. :try_end_26} :catch_3a

    .line 2323
    :cond_26
    :goto_26
    iget-object v3, p0, Landroid/webkit/WebViewClassic$6;->val$temp:Ljava/io/File;

    invoke-virtual {v3}, Ljava/io/File;->delete()Z

    .line 2316
    throw v2

    .line 2313
    :catch_2c
    move-exception v2

    .line 2316
    :goto_2d
    if-eqz v0, :cond_32

    .line 2318
    :try_start_2f
    invoke-virtual {v0}, Ljava/io/FileOutputStream;->close()V
    :try_end_32
    .catch Ljava/lang/Exception; {:try_start_2f .. :try_end_32} :catch_38

    .line 2323
    :cond_32
    :goto_32
    iget-object v2, p0, Landroid/webkit/WebViewClassic$6;->val$temp:Ljava/io/File;

    invoke-virtual {v2}, Ljava/io/File;->delete()Z

    goto :goto_1f

    .line 2319
    :catch_38
    move-exception v2

    goto :goto_32

    :catch_3a
    move-exception v3

    goto :goto_26

    .end local v0           #out:Ljava/io/FileOutputStream;
    .restart local v1       #out:Ljava/io/FileOutputStream;
    :catch_3c
    move-exception v2

    goto :goto_19

    .line 2316
    :catchall_3e
    move-exception v2

    move-object v0, v1

    .end local v1           #out:Ljava/io/FileOutputStream;
    .restart local v0       #out:Ljava/io/FileOutputStream;
    goto :goto_21

    .line 2313
    .end local v0           #out:Ljava/io/FileOutputStream;
    .restart local v1       #out:Ljava/io/FileOutputStream;
    :catch_41
    move-exception v2

    move-object v0, v1

    .end local v1           #out:Ljava/io/FileOutputStream;
    .restart local v0       #out:Ljava/io/FileOutputStream;
    goto :goto_2d
.end method
