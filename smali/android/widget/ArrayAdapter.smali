.class public Landroid/widget/ArrayAdapter;
.super Landroid/widget/BaseAdapter;
.source "ArrayAdapter.java"

# interfaces
.implements Landroid/widget/Filterable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/widget/ArrayAdapter$1;,
        Landroid/widget/ArrayAdapter$ArrayFilter;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Landroid/widget/BaseAdapter;",
        "Landroid/widget/Filterable;"
    }
.end annotation


# instance fields
.field private mContext:Landroid/content/Context;

.field private mDropDownResource:I

.field private mFieldId:I

.field private mFilter:Landroid/widget/ArrayAdapter$ArrayFilter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/widget/ArrayAdapter",
            "<TT;>.ArrayFilter;"
        }
    .end annotation
.end field

.field private mInflater:Landroid/view/LayoutInflater;

.field private final mLock:Ljava/lang/Object;

.field private mNotifyOnChange:Z

.field private mObjects:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation
.end field

.field private mOriginalValues:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<TT;>;"
        }
    .end annotation
.end field

.field private mResource:I


# direct methods
.method public constructor <init>(Landroid/content/Context;I)V
    .registers 5
    .parameter "context"
    .parameter "textViewResourceId"

    .prologue
    .local p0, this:Landroid/widget/ArrayAdapter;,"Landroid/widget/ArrayAdapter<TT;>;"
    const/4 v1, 0x0

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/widget/ArrayAdapter;->mLock:Ljava/lang/Object;

    iput v1, p0, Landroid/widget/ArrayAdapter;->mFieldId:I

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/widget/ArrayAdapter;->mNotifyOnChange:Z

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-direct {p0, p1, p2, v1, v0}, Landroid/widget/ArrayAdapter;->init(Landroid/content/Context;IILjava/util/List;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;II)V
    .registers 5
    .parameter "context"
    .parameter "resource"
    .parameter "textViewResourceId"

    .prologue
    .local p0, this:Landroid/widget/ArrayAdapter;,"Landroid/widget/ArrayAdapter<TT;>;"
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/widget/ArrayAdapter;->mLock:Ljava/lang/Object;

    const/4 v0, 0x0

    iput v0, p0, Landroid/widget/ArrayAdapter;->mFieldId:I

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/widget/ArrayAdapter;->mNotifyOnChange:Z

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-direct {p0, p1, p2, p3, v0}, Landroid/widget/ArrayAdapter;->init(Landroid/content/Context;IILjava/util/List;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;IILjava/util/List;)V
    .registers 6
    .parameter "context"
    .parameter "resource"
    .parameter "textViewResourceId"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "II",
            "Ljava/util/List",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .local p0, this:Landroid/widget/ArrayAdapter;,"Landroid/widget/ArrayAdapter<TT;>;"
    .local p4, objects:Ljava/util/List;,"Ljava/util/List<TT;>;"
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/widget/ArrayAdapter;->mLock:Ljava/lang/Object;

    const/4 v0, 0x0

    iput v0, p0, Landroid/widget/ArrayAdapter;->mFieldId:I

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/widget/ArrayAdapter;->mNotifyOnChange:Z

    invoke-direct {p0, p1, p2, p3, p4}, Landroid/widget/ArrayAdapter;->init(Landroid/content/Context;IILjava/util/List;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;II[Ljava/lang/Object;)V
    .registers 6
    .parameter "context"
    .parameter "resource"
    .parameter "textViewResourceId"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "II[TT;)V"
        }
    .end annotation

    .prologue
    .local p0, this:Landroid/widget/ArrayAdapter;,"Landroid/widget/ArrayAdapter<TT;>;"
    .local p4, objects:[Ljava/lang/Object;,"[TT;"
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/widget/ArrayAdapter;->mLock:Ljava/lang/Object;

    const/4 v0, 0x0

    iput v0, p0, Landroid/widget/ArrayAdapter;->mFieldId:I

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/widget/ArrayAdapter;->mNotifyOnChange:Z

    invoke-static {p4}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-direct {p0, p1, p2, p3, v0}, Landroid/widget/ArrayAdapter;->init(Landroid/content/Context;IILjava/util/List;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;ILjava/util/List;)V
    .registers 6
    .parameter "context"
    .parameter "textViewResourceId"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "I",
            "Ljava/util/List",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .local p0, this:Landroid/widget/ArrayAdapter;,"Landroid/widget/ArrayAdapter<TT;>;"
    .local p3, objects:Ljava/util/List;,"Ljava/util/List<TT;>;"
    const/4 v1, 0x0

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/widget/ArrayAdapter;->mLock:Ljava/lang/Object;

    iput v1, p0, Landroid/widget/ArrayAdapter;->mFieldId:I

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/widget/ArrayAdapter;->mNotifyOnChange:Z

    invoke-direct {p0, p1, p2, v1, p3}, Landroid/widget/ArrayAdapter;->init(Landroid/content/Context;IILjava/util/List;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;I[Ljava/lang/Object;)V
    .registers 6
    .parameter "context"
    .parameter "textViewResourceId"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "I[TT;)V"
        }
    .end annotation

    .prologue
    .local p0, this:Landroid/widget/ArrayAdapter;,"Landroid/widget/ArrayAdapter<TT;>;"
    .local p3, objects:[Ljava/lang/Object;,"[TT;"
    const/4 v1, 0x0

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/widget/ArrayAdapter;->mLock:Ljava/lang/Object;

    iput v1, p0, Landroid/widget/ArrayAdapter;->mFieldId:I

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/widget/ArrayAdapter;->mNotifyOnChange:Z

    invoke-static {p3}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-direct {p0, p1, p2, v1, v0}, Landroid/widget/ArrayAdapter;->init(Landroid/content/Context;IILjava/util/List;)V

    return-void
.end method

.method static synthetic access$100(Landroid/widget/ArrayAdapter;)Ljava/util/ArrayList;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mOriginalValues:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$102(Landroid/widget/ArrayAdapter;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput-object p1, p0, Landroid/widget/ArrayAdapter;->mOriginalValues:Ljava/util/ArrayList;

    return-object p1
.end method

.method static synthetic access$200(Landroid/widget/ArrayAdapter;)Ljava/lang/Object;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mLock:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$300(Landroid/widget/ArrayAdapter;)Ljava/util/List;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mObjects:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$302(Landroid/widget/ArrayAdapter;Ljava/util/List;)Ljava/util/List;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput-object p1, p0, Landroid/widget/ArrayAdapter;->mObjects:Ljava/util/List;

    return-object p1
.end method

.method public static createFromResource(Landroid/content/Context;II)Landroid/widget/ArrayAdapter;
    .registers 5
    .parameter "context"
    .parameter "textArrayResId"
    .parameter "textViewResId"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "II)",
            "Landroid/widget/ArrayAdapter",
            "<",
            "Ljava/lang/CharSequence;",
            ">;"
        }
    .end annotation

    .prologue
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, p1}, Landroid/content/res/Resources;->getTextArray(I)[Ljava/lang/CharSequence;

    move-result-object v0

    .local v0, strings:[Ljava/lang/CharSequence;
    new-instance v1, Landroid/widget/ArrayAdapter;

    invoke-direct {v1, p0, p2, v0}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;I[Ljava/lang/Object;)V

    return-object v1
.end method

.method private createViewFromResource(ILandroid/view/View;Landroid/view/ViewGroup;I)Landroid/view/View;
    .registers 12
    .parameter "position"
    .parameter "convertView"
    .parameter "parent"
    .parameter "resource"

    .prologue
    .local p0, this:Landroid/widget/ArrayAdapter;,"Landroid/widget/ArrayAdapter<TT;>;"
    if-nez p2, :cond_1f

    iget-object v5, p0, Landroid/widget/ArrayAdapter;->mInflater:Landroid/view/LayoutInflater;

    const/4 v6, 0x0

    invoke-virtual {v5, p4, p3, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v4

    .local v4, view:Landroid/view/View;
    :goto_9
    :try_start_9
    iget v5, p0, Landroid/widget/ArrayAdapter;->mFieldId:I

    if-nez v5, :cond_21

    move-object v0, v4

    check-cast v0, Landroid/widget/TextView;

    move-object v3, v0
    :try_end_11
    .catch Ljava/lang/ClassCastException; {:try_start_9 .. :try_end_11} :catch_2a

    .local v3, text:Landroid/widget/TextView;
    :goto_11
    invoke-virtual {p0, p1}, Landroid/widget/ArrayAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v2

    .local v2, item:Ljava/lang/Object;,"TT;"
    instance-of v5, v2, Ljava/lang/CharSequence;

    if-eqz v5, :cond_3a

    check-cast v2, Ljava/lang/CharSequence;

    .end local v2           #item:Ljava/lang/Object;,"TT;"
    invoke-virtual {v3, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :goto_1e
    return-object v4

    .end local v3           #text:Landroid/widget/TextView;
    .end local v4           #view:Landroid/view/View;
    :cond_1f
    move-object v4, p2

    .restart local v4       #view:Landroid/view/View;
    goto :goto_9

    :cond_21
    :try_start_21
    iget v5, p0, Landroid/widget/ArrayAdapter;->mFieldId:I

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;
    :try_end_29
    .catch Ljava/lang/ClassCastException; {:try_start_21 .. :try_end_29} :catch_2a

    .restart local v3       #text:Landroid/widget/TextView;
    goto :goto_11

    .end local v3           #text:Landroid/widget/TextView;
    :catch_2a
    move-exception v1

    .local v1, e:Ljava/lang/ClassCastException;
    const-string v5, "ArrayAdapter"

    const-string v6, "You must supply a resource ID for a TextView"

    invoke-static {v5, v6}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    new-instance v5, Ljava/lang/IllegalStateException;

    const-string v6, "ArrayAdapter requires the resource ID to be a TextView"

    invoke-direct {v5, v6, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v5

    .end local v1           #e:Ljava/lang/ClassCastException;
    .restart local v2       #item:Ljava/lang/Object;,"TT;"
    .restart local v3       #text:Landroid/widget/TextView;
    :cond_3a
    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_1e
.end method

.method private init(Landroid/content/Context;IILjava/util/List;)V
    .registers 6
    .parameter "context"
    .parameter "resource"
    .parameter "textViewResourceId"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "II",
            "Ljava/util/List",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .local p0, this:Landroid/widget/ArrayAdapter;,"Landroid/widget/ArrayAdapter<TT;>;"
    .local p4, objects:Ljava/util/List;,"Ljava/util/List<TT;>;"
    iput-object p1, p0, Landroid/widget/ArrayAdapter;->mContext:Landroid/content/Context;

    const-string v0, "layout_inflater"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    iput-object v0, p0, Landroid/widget/ArrayAdapter;->mInflater:Landroid/view/LayoutInflater;

    iput p2, p0, Landroid/widget/ArrayAdapter;->mDropDownResource:I

    iput p2, p0, Landroid/widget/ArrayAdapter;->mResource:I

    iput-object p4, p0, Landroid/widget/ArrayAdapter;->mObjects:Ljava/util/List;

    iput p3, p0, Landroid/widget/ArrayAdapter;->mFieldId:I

    return-void
.end method


# virtual methods
.method public add(Ljava/lang/Object;)V
    .registers 4
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .local p0, this:Landroid/widget/ArrayAdapter;,"Landroid/widget/ArrayAdapter<TT;>;"
    .local p1, object:Ljava/lang/Object;,"TT;"
    iget-object v1, p0, Landroid/widget/ArrayAdapter;->mLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_3
    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mOriginalValues:Ljava/util/ArrayList;

    if-eqz v0, :cond_15

    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mOriginalValues:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :goto_c
    monitor-exit v1
    :try_end_d
    .catchall {:try_start_3 .. :try_end_d} :catchall_1b

    iget-boolean v0, p0, Landroid/widget/ArrayAdapter;->mNotifyOnChange:Z

    if-eqz v0, :cond_14

    invoke-virtual {p0}, Landroid/widget/ArrayAdapter;->notifyDataSetChanged()V

    :cond_14
    return-void

    :cond_15
    :try_start_15
    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mObjects:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_c

    :catchall_1b
    move-exception v0

    monitor-exit v1
    :try_end_1d
    .catchall {:try_start_15 .. :try_end_1d} :catchall_1b

    throw v0
.end method

.method public addAll(Ljava/util/Collection;)V
    .registers 4
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<+TT;>;)V"
        }
    .end annotation

    .prologue
    .local p0, this:Landroid/widget/ArrayAdapter;,"Landroid/widget/ArrayAdapter<TT;>;"
    .local p1, collection:Ljava/util/Collection;,"Ljava/util/Collection<+TT;>;"
    iget-object v1, p0, Landroid/widget/ArrayAdapter;->mLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_3
    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mOriginalValues:Ljava/util/ArrayList;

    if-eqz v0, :cond_15

    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mOriginalValues:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    :goto_c
    monitor-exit v1
    :try_end_d
    .catchall {:try_start_3 .. :try_end_d} :catchall_1b

    iget-boolean v0, p0, Landroid/widget/ArrayAdapter;->mNotifyOnChange:Z

    if-eqz v0, :cond_14

    invoke-virtual {p0}, Landroid/widget/ArrayAdapter;->notifyDataSetChanged()V

    :cond_14
    return-void

    :cond_15
    :try_start_15
    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mObjects:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    goto :goto_c

    :catchall_1b
    move-exception v0

    monitor-exit v1
    :try_end_1d
    .catchall {:try_start_15 .. :try_end_1d} :catchall_1b

    throw v0
.end method

.method public varargs addAll([Ljava/lang/Object;)V
    .registers 4
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([TT;)V"
        }
    .end annotation

    .prologue
    .local p0, this:Landroid/widget/ArrayAdapter;,"Landroid/widget/ArrayAdapter<TT;>;"
    .local p1, items:[Ljava/lang/Object;,"[TT;"
    iget-object v1, p0, Landroid/widget/ArrayAdapter;->mLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_3
    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mOriginalValues:Ljava/util/ArrayList;

    if-eqz v0, :cond_15

    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mOriginalValues:Ljava/util/ArrayList;

    invoke-static {v0, p1}, Ljava/util/Collections;->addAll(Ljava/util/Collection;[Ljava/lang/Object;)Z

    :goto_c
    monitor-exit v1
    :try_end_d
    .catchall {:try_start_3 .. :try_end_d} :catchall_1b

    iget-boolean v0, p0, Landroid/widget/ArrayAdapter;->mNotifyOnChange:Z

    if-eqz v0, :cond_14

    invoke-virtual {p0}, Landroid/widget/ArrayAdapter;->notifyDataSetChanged()V

    :cond_14
    return-void

    :cond_15
    :try_start_15
    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mObjects:Ljava/util/List;

    invoke-static {v0, p1}, Ljava/util/Collections;->addAll(Ljava/util/Collection;[Ljava/lang/Object;)Z

    goto :goto_c

    :catchall_1b
    move-exception v0

    monitor-exit v1
    :try_end_1d
    .catchall {:try_start_15 .. :try_end_1d} :catchall_1b

    throw v0
.end method

.method public clear()V
    .registers 3

    .prologue
    .local p0, this:Landroid/widget/ArrayAdapter;,"Landroid/widget/ArrayAdapter<TT;>;"
    iget-object v1, p0, Landroid/widget/ArrayAdapter;->mLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_3
    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mOriginalValues:Ljava/util/ArrayList;

    if-eqz v0, :cond_15

    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mOriginalValues:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    :goto_c
    monitor-exit v1
    :try_end_d
    .catchall {:try_start_3 .. :try_end_d} :catchall_1b

    iget-boolean v0, p0, Landroid/widget/ArrayAdapter;->mNotifyOnChange:Z

    if-eqz v0, :cond_14

    invoke-virtual {p0}, Landroid/widget/ArrayAdapter;->notifyDataSetChanged()V

    :cond_14
    return-void

    :cond_15
    :try_start_15
    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mObjects:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    goto :goto_c

    :catchall_1b
    move-exception v0

    monitor-exit v1
    :try_end_1d
    .catchall {:try_start_15 .. :try_end_1d} :catchall_1b

    throw v0
.end method

.method public getContext()Landroid/content/Context;
    .registers 2

    .prologue
    .local p0, this:Landroid/widget/ArrayAdapter;,"Landroid/widget/ArrayAdapter<TT;>;"
    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method public getCount()I
    .registers 2

    .prologue
    .local p0, this:Landroid/widget/ArrayAdapter;,"Landroid/widget/ArrayAdapter<TT;>;"
    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mObjects:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getDropDownView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .registers 5
    .parameter "position"
    .parameter "convertView"
    .parameter "parent"

    .prologue
    .local p0, this:Landroid/widget/ArrayAdapter;,"Landroid/widget/ArrayAdapter<TT;>;"
    iget v0, p0, Landroid/widget/ArrayAdapter;->mDropDownResource:I

    invoke-direct {p0, p1, p2, p3, v0}, Landroid/widget/ArrayAdapter;->createViewFromResource(ILandroid/view/View;Landroid/view/ViewGroup;I)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public getFilter()Landroid/widget/Filter;
    .registers 3

    .prologue
    .local p0, this:Landroid/widget/ArrayAdapter;,"Landroid/widget/ArrayAdapter<TT;>;"
    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mFilter:Landroid/widget/ArrayAdapter$ArrayFilter;

    if-nez v0, :cond_c

    new-instance v0, Landroid/widget/ArrayAdapter$ArrayFilter;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Landroid/widget/ArrayAdapter$ArrayFilter;-><init>(Landroid/widget/ArrayAdapter;Landroid/widget/ArrayAdapter$1;)V

    iput-object v0, p0, Landroid/widget/ArrayAdapter;->mFilter:Landroid/widget/ArrayAdapter$ArrayFilter;

    :cond_c
    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mFilter:Landroid/widget/ArrayAdapter$ArrayFilter;

    return-object v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .registers 3
    .parameter "position"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)TT;"
        }
    .end annotation

    .prologue
    .local p0, this:Landroid/widget/ArrayAdapter;,"Landroid/widget/ArrayAdapter<TT;>;"
    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mObjects:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .registers 4
    .parameter "position"

    .prologue
    .local p0, this:Landroid/widget/ArrayAdapter;,"Landroid/widget/ArrayAdapter<TT;>;"
    int-to-long v0, p1

    return-wide v0
.end method

.method public getPosition(Ljava/lang/Object;)I
    .registers 3
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)I"
        }
    .end annotation

    .prologue
    .local p0, this:Landroid/widget/ArrayAdapter;,"Landroid/widget/ArrayAdapter<TT;>;"
    .local p1, item:Ljava/lang/Object;,"TT;"
    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mObjects:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .registers 5
    .parameter "position"
    .parameter "convertView"
    .parameter "parent"

    .prologue
    .local p0, this:Landroid/widget/ArrayAdapter;,"Landroid/widget/ArrayAdapter<TT;>;"
    iget v0, p0, Landroid/widget/ArrayAdapter;->mResource:I

    invoke-direct {p0, p1, p2, p3, v0}, Landroid/widget/ArrayAdapter;->createViewFromResource(ILandroid/view/View;Landroid/view/ViewGroup;I)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public insert(Ljava/lang/Object;I)V
    .registers 5
    .parameter
    .parameter "index"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;I)V"
        }
    .end annotation

    .prologue
    .local p0, this:Landroid/widget/ArrayAdapter;,"Landroid/widget/ArrayAdapter<TT;>;"
    .local p1, object:Ljava/lang/Object;,"TT;"
    iget-object v1, p0, Landroid/widget/ArrayAdapter;->mLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_3
    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mOriginalValues:Ljava/util/ArrayList;

    if-eqz v0, :cond_15

    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mOriginalValues:Ljava/util/ArrayList;

    invoke-virtual {v0, p2, p1}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    :goto_c
    monitor-exit v1
    :try_end_d
    .catchall {:try_start_3 .. :try_end_d} :catchall_1b

    iget-boolean v0, p0, Landroid/widget/ArrayAdapter;->mNotifyOnChange:Z

    if-eqz v0, :cond_14

    invoke-virtual {p0}, Landroid/widget/ArrayAdapter;->notifyDataSetChanged()V

    :cond_14
    return-void

    :cond_15
    :try_start_15
    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mObjects:Ljava/util/List;

    invoke-interface {v0, p2, p1}, Ljava/util/List;->add(ILjava/lang/Object;)V

    goto :goto_c

    :catchall_1b
    move-exception v0

    monitor-exit v1
    :try_end_1d
    .catchall {:try_start_15 .. :try_end_1d} :catchall_1b

    throw v0
.end method

.method public notifyDataSetChanged()V
    .registers 2

    .prologue
    .local p0, this:Landroid/widget/ArrayAdapter;,"Landroid/widget/ArrayAdapter<TT;>;"
    invoke-super {p0}, Landroid/widget/BaseAdapter;->notifyDataSetChanged()V

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/widget/ArrayAdapter;->mNotifyOnChange:Z

    return-void
.end method

.method public remove(Ljava/lang/Object;)V
    .registers 4
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .local p0, this:Landroid/widget/ArrayAdapter;,"Landroid/widget/ArrayAdapter<TT;>;"
    .local p1, object:Ljava/lang/Object;,"TT;"
    iget-object v1, p0, Landroid/widget/ArrayAdapter;->mLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_3
    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mOriginalValues:Ljava/util/ArrayList;

    if-eqz v0, :cond_15

    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mOriginalValues:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    :goto_c
    monitor-exit v1
    :try_end_d
    .catchall {:try_start_3 .. :try_end_d} :catchall_1b

    iget-boolean v0, p0, Landroid/widget/ArrayAdapter;->mNotifyOnChange:Z

    if-eqz v0, :cond_14

    invoke-virtual {p0}, Landroid/widget/ArrayAdapter;->notifyDataSetChanged()V

    :cond_14
    return-void

    :cond_15
    :try_start_15
    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mObjects:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_c

    :catchall_1b
    move-exception v0

    monitor-exit v1
    :try_end_1d
    .catchall {:try_start_15 .. :try_end_1d} :catchall_1b

    throw v0
.end method

.method public setDropDownViewResource(I)V
    .registers 2
    .parameter "resource"

    .prologue
    .local p0, this:Landroid/widget/ArrayAdapter;,"Landroid/widget/ArrayAdapter<TT;>;"
    iput p1, p0, Landroid/widget/ArrayAdapter;->mDropDownResource:I

    return-void
.end method

.method public setNotifyOnChange(Z)V
    .registers 2
    .parameter "notifyOnChange"

    .prologue
    .local p0, this:Landroid/widget/ArrayAdapter;,"Landroid/widget/ArrayAdapter<TT;>;"
    iput-boolean p1, p0, Landroid/widget/ArrayAdapter;->mNotifyOnChange:Z

    return-void
.end method

.method public sort(Ljava/util/Comparator;)V
    .registers 4
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Comparator",
            "<-TT;>;)V"
        }
    .end annotation

    .prologue
    .local p0, this:Landroid/widget/ArrayAdapter;,"Landroid/widget/ArrayAdapter<TT;>;"
    .local p1, comparator:Ljava/util/Comparator;,"Ljava/util/Comparator<-TT;>;"
    iget-object v1, p0, Landroid/widget/ArrayAdapter;->mLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_3
    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mOriginalValues:Ljava/util/ArrayList;

    if-eqz v0, :cond_15

    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mOriginalValues:Ljava/util/ArrayList;

    invoke-static {v0, p1}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    :goto_c
    monitor-exit v1
    :try_end_d
    .catchall {:try_start_3 .. :try_end_d} :catchall_1b

    iget-boolean v0, p0, Landroid/widget/ArrayAdapter;->mNotifyOnChange:Z

    if-eqz v0, :cond_14

    invoke-virtual {p0}, Landroid/widget/ArrayAdapter;->notifyDataSetChanged()V

    :cond_14
    return-void

    :cond_15
    :try_start_15
    iget-object v0, p0, Landroid/widget/ArrayAdapter;->mObjects:Ljava/util/List;

    invoke-static {v0, p1}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    goto :goto_c

    :catchall_1b
    move-exception v0

    monitor-exit v1
    :try_end_1d
    .catchall {:try_start_15 .. :try_end_1d} :catchall_1b

    throw v0
.end method
