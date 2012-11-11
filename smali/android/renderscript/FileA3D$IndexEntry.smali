.class public Landroid/renderscript/FileA3D$IndexEntry;
.super Ljava/lang/Object;
.source "FileA3D.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/renderscript/FileA3D;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "IndexEntry"
.end annotation


# instance fields
.field mEntryType:Landroid/renderscript/FileA3D$EntryType;

.field mID:I

.field mIndex:I

.field mLoadedObj:Landroid/renderscript/BaseObj;

.field mName:Ljava/lang/String;

.field mRS:Landroid/renderscript/RenderScript;


# direct methods
.method constructor <init>(Landroid/renderscript/RenderScript;IILjava/lang/String;Landroid/renderscript/FileA3D$EntryType;)V
    .registers 7
    .parameter "rs"
    .parameter "index"
    .parameter "id"
    .parameter "name"
    .parameter "type"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroid/renderscript/FileA3D$IndexEntry;->mRS:Landroid/renderscript/RenderScript;

    iput p2, p0, Landroid/renderscript/FileA3D$IndexEntry;->mIndex:I

    iput p3, p0, Landroid/renderscript/FileA3D$IndexEntry;->mID:I

    iput-object p4, p0, Landroid/renderscript/FileA3D$IndexEntry;->mName:Ljava/lang/String;

    iput-object p5, p0, Landroid/renderscript/FileA3D$IndexEntry;->mEntryType:Landroid/renderscript/FileA3D$EntryType;

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/renderscript/FileA3D$IndexEntry;->mLoadedObj:Landroid/renderscript/BaseObj;

    return-void
.end method

.method static declared-synchronized internalCreate(Landroid/renderscript/RenderScript;Landroid/renderscript/FileA3D$IndexEntry;)Landroid/renderscript/BaseObj;
    .registers 7
    .parameter "rs"
    .parameter "entry"

    .prologue
    const/4 v1, 0x0

    const-class v2, Landroid/renderscript/FileA3D$IndexEntry;

    monitor-enter v2

    :try_start_4
    iget-object v3, p1, Landroid/renderscript/FileA3D$IndexEntry;->mLoadedObj:Landroid/renderscript/BaseObj;

    if-eqz v3, :cond_c

    iget-object v1, p1, Landroid/renderscript/FileA3D$IndexEntry;->mLoadedObj:Landroid/renderscript/BaseObj;
    :try_end_a
    .catchall {:try_start_4 .. :try_end_a} :catchall_39

    :cond_a
    :goto_a
    monitor-exit v2

    return-object v1

    :cond_c
    :try_start_c
    iget-object v3, p1, Landroid/renderscript/FileA3D$IndexEntry;->mEntryType:Landroid/renderscript/FileA3D$EntryType;

    sget-object v4, Landroid/renderscript/FileA3D$EntryType;->UNKNOWN:Landroid/renderscript/FileA3D$EntryType;

    if-eq v3, v4, :cond_a

    iget v3, p1, Landroid/renderscript/FileA3D$IndexEntry;->mID:I

    iget v4, p1, Landroid/renderscript/FileA3D$IndexEntry;->mIndex:I

    invoke-virtual {p0, v3, v4}, Landroid/renderscript/RenderScript;->nFileA3DGetEntryByIndex(II)I

    move-result v0

    .local v0, objectID:I
    if-eqz v0, :cond_a

    sget-object v1, Landroid/renderscript/FileA3D$1;->$SwitchMap$android$renderscript$FileA3D$EntryType:[I

    iget-object v3, p1, Landroid/renderscript/FileA3D$IndexEntry;->mEntryType:Landroid/renderscript/FileA3D$EntryType;

    invoke-virtual {v3}, Landroid/renderscript/FileA3D$EntryType;->ordinal()I

    move-result v3

    aget v1, v1, v3

    packed-switch v1, :pswitch_data_3c

    :goto_29
    iget-object v1, p1, Landroid/renderscript/FileA3D$IndexEntry;->mLoadedObj:Landroid/renderscript/BaseObj;

    invoke-virtual {v1}, Landroid/renderscript/BaseObj;->updateFromNative()V

    iget-object v1, p1, Landroid/renderscript/FileA3D$IndexEntry;->mLoadedObj:Landroid/renderscript/BaseObj;

    goto :goto_a

    :pswitch_31
    new-instance v1, Landroid/renderscript/Mesh;

    invoke-direct {v1, v0, p0}, Landroid/renderscript/Mesh;-><init>(ILandroid/renderscript/RenderScript;)V

    iput-object v1, p1, Landroid/renderscript/FileA3D$IndexEntry;->mLoadedObj:Landroid/renderscript/BaseObj;
    :try_end_38
    .catchall {:try_start_c .. :try_end_38} :catchall_39

    goto :goto_29

    .end local v0           #objectID:I
    :catchall_39
    move-exception v1

    monitor-exit v2

    throw v1

    :pswitch_data_3c
    .packed-switch 0x1
        :pswitch_31
    .end packed-switch
.end method


# virtual methods
.method public getEntryType()Landroid/renderscript/FileA3D$EntryType;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/renderscript/FileA3D$IndexEntry;->mEntryType:Landroid/renderscript/FileA3D$EntryType;

    return-object v0
.end method

.method public getMesh()Landroid/renderscript/Mesh;
    .registers 2

    .prologue
    invoke-virtual {p0}, Landroid/renderscript/FileA3D$IndexEntry;->getObject()Landroid/renderscript/BaseObj;

    move-result-object v0

    check-cast v0, Landroid/renderscript/Mesh;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/renderscript/FileA3D$IndexEntry;->mName:Ljava/lang/String;

    return-object v0
.end method

.method public getObject()Landroid/renderscript/BaseObj;
    .registers 3

    .prologue
    iget-object v1, p0, Landroid/renderscript/FileA3D$IndexEntry;->mRS:Landroid/renderscript/RenderScript;

    invoke-virtual {v1}, Landroid/renderscript/RenderScript;->validate()V

    iget-object v1, p0, Landroid/renderscript/FileA3D$IndexEntry;->mRS:Landroid/renderscript/RenderScript;

    invoke-static {v1, p0}, Landroid/renderscript/FileA3D$IndexEntry;->internalCreate(Landroid/renderscript/RenderScript;Landroid/renderscript/FileA3D$IndexEntry;)Landroid/renderscript/BaseObj;

    move-result-object v0

    .local v0, obj:Landroid/renderscript/BaseObj;
    return-object v0
.end method
