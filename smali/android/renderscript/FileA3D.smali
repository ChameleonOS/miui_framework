.class public Landroid/renderscript/FileA3D;
.super Landroid/renderscript/BaseObj;
.source "FileA3D.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/renderscript/FileA3D$1;,
        Landroid/renderscript/FileA3D$IndexEntry;,
        Landroid/renderscript/FileA3D$EntryType;
    }
.end annotation


# instance fields
.field mFileEntries:[Landroid/renderscript/FileA3D$IndexEntry;

.field mInputStream:Ljava/io/InputStream;


# direct methods
.method constructor <init>(ILandroid/renderscript/RenderScript;Ljava/io/InputStream;)V
    .registers 4
    .parameter "id"
    .parameter "rs"
    .parameter "stream"

    .prologue
    .line 172
    invoke-direct {p0, p1, p2}, Landroid/renderscript/BaseObj;-><init>(ILandroid/renderscript/RenderScript;)V

    .line 173
    iput-object p3, p0, Landroid/renderscript/FileA3D;->mInputStream:Ljava/io/InputStream;

    .line 174
    return-void
.end method

.method public static createFromAsset(Landroid/renderscript/RenderScript;Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/renderscript/FileA3D;
    .registers 8
    .parameter "rs"
    .parameter "mgr"
    .parameter "path"

    .prologue
    .line 233
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 234
    invoke-virtual {p0, p1, p2}, Landroid/renderscript/RenderScript;->nFileA3DCreateFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)I

    move-result v1

    .line 236
    .local v1, fileId:I
    if-nez v1, :cond_22

    .line 237
    new-instance v2, Landroid/renderscript/RSRuntimeException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unable to create a3d file from asset "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/renderscript/RSRuntimeException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 239
    :cond_22
    new-instance v0, Landroid/renderscript/FileA3D;

    const/4 v2, 0x0

    invoke-direct {v0, v1, p0, v2}, Landroid/renderscript/FileA3D;-><init>(ILandroid/renderscript/RenderScript;Ljava/io/InputStream;)V

    .line 240
    .local v0, fa3d:Landroid/renderscript/FileA3D;
    invoke-direct {v0}, Landroid/renderscript/FileA3D;->initEntries()V

    .line 241
    return-object v0
.end method

.method public static createFromFile(Landroid/renderscript/RenderScript;Ljava/io/File;)Landroid/renderscript/FileA3D;
    .registers 3
    .parameter "rs"
    .parameter "path"

    .prologue
    .line 274
    invoke-virtual {p1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Landroid/renderscript/FileA3D;->createFromFile(Landroid/renderscript/RenderScript;Ljava/lang/String;)Landroid/renderscript/FileA3D;

    move-result-object v0

    return-object v0
.end method

.method public static createFromFile(Landroid/renderscript/RenderScript;Ljava/lang/String;)Landroid/renderscript/FileA3D;
    .registers 7
    .parameter "rs"
    .parameter "path"

    .prologue
    .line 254
    invoke-virtual {p0, p1}, Landroid/renderscript/RenderScript;->nFileA3DCreateFromFile(Ljava/lang/String;)I

    move-result v1

    .line 256
    .local v1, fileId:I
    if-nez v1, :cond_1f

    .line 257
    new-instance v2, Landroid/renderscript/RSRuntimeException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unable to create a3d file from "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/renderscript/RSRuntimeException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 259
    :cond_1f
    new-instance v0, Landroid/renderscript/FileA3D;

    const/4 v2, 0x0

    invoke-direct {v0, v1, p0, v2}, Landroid/renderscript/FileA3D;-><init>(ILandroid/renderscript/RenderScript;Ljava/io/InputStream;)V

    .line 260
    .local v0, fa3d:Landroid/renderscript/FileA3D;
    invoke-direct {v0}, Landroid/renderscript/FileA3D;->initEntries()V

    .line 261
    return-object v0
.end method

.method public static createFromResource(Landroid/renderscript/RenderScript;Landroid/content/res/Resources;I)Landroid/renderscript/FileA3D;
    .registers 11
    .parameter "rs"
    .parameter "res"
    .parameter "id"

    .prologue
    .line 289
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 290
    const/4 v4, 0x0

    .line 292
    .local v4, is:Ljava/io/InputStream;
    :try_start_4
    invoke-virtual {p1, p2}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_7} :catch_33

    move-result-object v4

    .line 297
    const/4 v3, 0x0

    .line 298
    .local v3, fileId:I
    instance-of v5, v4, Landroid/content/res/AssetManager$AssetInputStream;

    if-eqz v5, :cond_4d

    move-object v5, v4

    .line 299
    check-cast v5, Landroid/content/res/AssetManager$AssetInputStream;

    invoke-virtual {v5}, Landroid/content/res/AssetManager$AssetInputStream;->getAssetInt()I

    move-result v0

    .line 300
    .local v0, asset:I
    invoke-virtual {p0, v0}, Landroid/renderscript/RenderScript;->nFileA3DCreateFromAssetStream(I)I

    move-result v3

    .line 305
    if-nez v3, :cond_55

    .line 306
    new-instance v5, Landroid/renderscript/RSRuntimeException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Unable to create a3d file from resource "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Landroid/renderscript/RSRuntimeException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 293
    .end local v0           #asset:I
    .end local v3           #fileId:I
    :catch_33
    move-exception v1

    .line 294
    .local v1, e:Ljava/lang/Exception;
    new-instance v5, Landroid/renderscript/RSRuntimeException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Unable to open resource "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Landroid/renderscript/RSRuntimeException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 302
    .end local v1           #e:Ljava/lang/Exception;
    .restart local v3       #fileId:I
    :cond_4d
    new-instance v5, Landroid/renderscript/RSRuntimeException;

    const-string v6, "Unsupported asset stream"

    invoke-direct {v5, v6}, Landroid/renderscript/RSRuntimeException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 308
    .restart local v0       #asset:I
    :cond_55
    new-instance v2, Landroid/renderscript/FileA3D;

    invoke-direct {v2, v3, p0, v4}, Landroid/renderscript/FileA3D;-><init>(ILandroid/renderscript/RenderScript;Ljava/io/InputStream;)V

    .line 309
    .local v2, fa3d:Landroid/renderscript/FileA3D;
    invoke-direct {v2}, Landroid/renderscript/FileA3D;->initEntries()V

    .line 310
    return-object v2
.end method

.method private initEntries()V
    .registers 11

    .prologue
    .line 177
    iget-object v0, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    iget-object v1, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {p0, v1}, Landroid/renderscript/FileA3D;->getID(Landroid/renderscript/RenderScript;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/renderscript/RenderScript;->nFileA3DGetNumIndexEntries(I)I

    move-result v8

    .line 178
    .local v8, numFileEntries:I
    if-gtz v8, :cond_f

    .line 191
    :cond_e
    return-void

    .line 182
    :cond_f
    new-array v0, v8, [Landroid/renderscript/FileA3D$IndexEntry;

    iput-object v0, p0, Landroid/renderscript/FileA3D;->mFileEntries:[Landroid/renderscript/FileA3D$IndexEntry;

    .line 183
    new-array v6, v8, [I

    .line 184
    .local v6, ids:[I
    new-array v7, v8, [Ljava/lang/String;

    .line 186
    .local v7, names:[Ljava/lang/String;
    iget-object v0, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    iget-object v1, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {p0, v1}, Landroid/renderscript/FileA3D;->getID(Landroid/renderscript/RenderScript;)I

    move-result v1

    invoke-virtual {v0, v1, v8, v6, v7}, Landroid/renderscript/RenderScript;->nFileA3DGetIndexEntries(II[I[Ljava/lang/String;)V

    .line 188
    const/4 v2, 0x0

    .local v2, i:I
    :goto_23
    if-ge v2, v8, :cond_e

    .line 189
    iget-object v9, p0, Landroid/renderscript/FileA3D;->mFileEntries:[Landroid/renderscript/FileA3D$IndexEntry;

    new-instance v0, Landroid/renderscript/FileA3D$IndexEntry;

    iget-object v1, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    iget-object v3, p0, Landroid/renderscript/BaseObj;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {p0, v3}, Landroid/renderscript/FileA3D;->getID(Landroid/renderscript/RenderScript;)I

    move-result v3

    aget-object v4, v7, v2

    aget v5, v6, v2

    invoke-static {v5}, Landroid/renderscript/FileA3D$EntryType;->toEntryType(I)Landroid/renderscript/FileA3D$EntryType;

    move-result-object v5

    invoke-direct/range {v0 .. v5}, Landroid/renderscript/FileA3D$IndexEntry;-><init>(Landroid/renderscript/RenderScript;IILjava/lang/String;Landroid/renderscript/FileA3D$EntryType;)V

    aput-object v0, v9, v2

    .line 188
    add-int/lit8 v2, v2, 0x1

    goto :goto_23
.end method


# virtual methods
.method public getIndexEntry(I)Landroid/renderscript/FileA3D$IndexEntry;
    .registers 3
    .parameter "index"

    .prologue
    .line 216
    invoke-virtual {p0}, Landroid/renderscript/FileA3D;->getIndexEntryCount()I

    move-result v0

    if-eqz v0, :cond_d

    if-ltz p1, :cond_d

    iget-object v0, p0, Landroid/renderscript/FileA3D;->mFileEntries:[Landroid/renderscript/FileA3D$IndexEntry;

    array-length v0, v0

    if-lt p1, v0, :cond_f

    .line 217
    :cond_d
    const/4 v0, 0x0

    .line 219
    :goto_e
    return-object v0

    :cond_f
    iget-object v0, p0, Landroid/renderscript/FileA3D;->mFileEntries:[Landroid/renderscript/FileA3D$IndexEntry;

    aget-object v0, v0, p1

    goto :goto_e
.end method

.method public getIndexEntryCount()I
    .registers 2

    .prologue
    .line 200
    iget-object v0, p0, Landroid/renderscript/FileA3D;->mFileEntries:[Landroid/renderscript/FileA3D$IndexEntry;

    if-nez v0, :cond_6

    .line 201
    const/4 v0, 0x0

    .line 203
    :goto_5
    return v0

    :cond_6
    iget-object v0, p0, Landroid/renderscript/FileA3D;->mFileEntries:[Landroid/renderscript/FileA3D$IndexEntry;

    array-length v0, v0

    goto :goto_5
.end method
