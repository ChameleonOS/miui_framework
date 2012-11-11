.class final Landroid/widget/ActivityChooserModel$PersistHistoryAsyncTask;
.super Landroid/os/AsyncTask;
.source "ActivityChooserModel.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/ActivityChooserModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "PersistHistoryAsyncTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Object;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Landroid/widget/ActivityChooserModel;


# direct methods
.method private constructor <init>(Landroid/widget/ActivityChooserModel;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Landroid/widget/ActivityChooserModel$PersistHistoryAsyncTask;->this$0:Landroid/widget/ActivityChooserModel;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/widget/ActivityChooserModel;Landroid/widget/ActivityChooserModel$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Landroid/widget/ActivityChooserModel$PersistHistoryAsyncTask;-><init>(Landroid/widget/ActivityChooserModel;)V

    return-void
.end method


# virtual methods
.method public bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    invoke-virtual {p0, p1}, Landroid/widget/ActivityChooserModel$PersistHistoryAsyncTask;->doInBackground([Ljava/lang/Object;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method public varargs doInBackground([Ljava/lang/Object;)Ljava/lang/Void;
    .registers 17
    .parameter "args"

    .prologue
    const/4 v11, 0x0

    aget-object v2, p1, v11

    check-cast v2, Ljava/util/List;

    .local v2, historicalRecords:Ljava/util/List;,"Ljava/util/List<Landroid/widget/ActivityChooserModel$HistoricalRecord;>;"
    const/4 v11, 0x1

    aget-object v3, p1, v11

    check-cast v3, Ljava/lang/String;

    .local v3, hostoryFileName:Ljava/lang/String;
    const/4 v1, 0x0

    .local v1, fos:Ljava/io/FileOutputStream;
    :try_start_b
    iget-object v11, p0, Landroid/widget/ActivityChooserModel$PersistHistoryAsyncTask;->this$0:Landroid/widget/ActivityChooserModel;

    #getter for: Landroid/widget/ActivityChooserModel;->mContext:Landroid/content/Context;
    invoke-static {v11}, Landroid/widget/ActivityChooserModel;->access$300(Landroid/widget/ActivityChooserModel;)Landroid/content/Context;

    move-result-object v11

    const/4 v12, 0x0

    invoke-virtual {v11, v3, v12}, Landroid/content/Context;->openFileOutput(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    :try_end_15
    .catch Ljava/io/FileNotFoundException; {:try_start_b .. :try_end_15} :catch_71

    move-result-object v1

    invoke-static {}, Landroid/util/Xml;->newSerializer()Lorg/xmlpull/v1/XmlSerializer;

    move-result-object v10

    .local v10, serializer:Lorg/xmlpull/v1/XmlSerializer;
    const/4 v11, 0x0

    :try_start_1b
    invoke-interface {v10, v1, v11}, Lorg/xmlpull/v1/XmlSerializer;->setOutput(Ljava/io/OutputStream;Ljava/lang/String;)V

    const-string v11, "UTF-8"

    const/4 v12, 0x1

    invoke-static {v12}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v12

    invoke-interface {v10, v11, v12}, Lorg/xmlpull/v1/XmlSerializer;->startDocument(Ljava/lang/String;Ljava/lang/Boolean;)V

    const/4 v11, 0x0

    const-string v12, "historical-records"

    invoke-interface {v10, v11, v12}, Lorg/xmlpull/v1/XmlSerializer;->startTag(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v9

    .local v9, recordCount:I
    const/4 v4, 0x0

    .local v4, i:I
    :goto_33
    if-ge v4, v9, :cond_8e

    const/4 v11, 0x0

    invoke-interface {v2, v11}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/widget/ActivityChooserModel$HistoricalRecord;

    .local v8, record:Landroid/widget/ActivityChooserModel$HistoricalRecord;
    const/4 v11, 0x0

    const-string v12, "historical-record"

    invoke-interface {v10, v11, v12}, Lorg/xmlpull/v1/XmlSerializer;->startTag(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;

    const/4 v11, 0x0

    const-string v12, "activity"

    iget-object v13, v8, Landroid/widget/ActivityChooserModel$HistoricalRecord;->activity:Landroid/content/ComponentName;

    invoke-virtual {v13}, Landroid/content/ComponentName;->flattenToString()Ljava/lang/String;

    move-result-object v13

    invoke-interface {v10, v11, v12, v13}, Lorg/xmlpull/v1/XmlSerializer;->attribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;

    const/4 v11, 0x0

    const-string/jumbo v12, "time"

    iget-wide v13, v8, Landroid/widget/ActivityChooserModel$HistoricalRecord;->time:J

    invoke-static {v13, v14}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v13

    invoke-interface {v10, v11, v12, v13}, Lorg/xmlpull/v1/XmlSerializer;->attribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;

    const/4 v11, 0x0

    const-string/jumbo v12, "weight"

    iget v13, v8, Landroid/widget/ActivityChooserModel$HistoricalRecord;->weight:F

    invoke-static {v13}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v13

    invoke-interface {v10, v11, v12, v13}, Lorg/xmlpull/v1/XmlSerializer;->attribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;

    const/4 v11, 0x0

    const-string v12, "historical-record"

    invoke-interface {v10, v11, v12}, Lorg/xmlpull/v1/XmlSerializer;->endTag(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    :try_end_6e
    .catchall {:try_start_1b .. :try_end_6e} :catchall_12e
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1b .. :try_end_6e} :catch_a4
    .catch Ljava/lang/IllegalStateException; {:try_start_1b .. :try_end_6e} :catch_d3
    .catch Ljava/io/IOException; {:try_start_1b .. :try_end_6e} :catch_100

    add-int/lit8 v4, v4, 0x1

    goto :goto_33

    .end local v4           #i:I
    .end local v8           #record:Landroid/widget/ActivityChooserModel$HistoricalRecord;
    .end local v9           #recordCount:I
    .end local v10           #serializer:Lorg/xmlpull/v1/XmlSerializer;
    :catch_71
    move-exception v0

    .local v0, fnfe:Ljava/io/FileNotFoundException;
    invoke-static {}, Landroid/widget/ActivityChooserModel;->access$400()Ljava/lang/String;

    move-result-object v11

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "Error writing historical recrod file: "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    const/4 v11, 0x0

    .end local v0           #fnfe:Ljava/io/FileNotFoundException;
    :goto_8d
    return-object v11

    .restart local v4       #i:I
    .restart local v9       #recordCount:I
    .restart local v10       #serializer:Lorg/xmlpull/v1/XmlSerializer;
    :cond_8e
    const/4 v11, 0x0

    :try_start_8f
    const-string v12, "historical-records"

    invoke-interface {v10, v11, v12}, Lorg/xmlpull/v1/XmlSerializer;->endTag(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;

    invoke-interface {v10}, Lorg/xmlpull/v1/XmlSerializer;->endDocument()V
    :try_end_97
    .catchall {:try_start_8f .. :try_end_97} :catchall_12e
    .catch Ljava/lang/IllegalArgumentException; {:try_start_8f .. :try_end_97} :catch_a4
    .catch Ljava/lang/IllegalStateException; {:try_start_8f .. :try_end_97} :catch_d3
    .catch Ljava/io/IOException; {:try_start_8f .. :try_end_97} :catch_100

    iget-object v11, p0, Landroid/widget/ActivityChooserModel$PersistHistoryAsyncTask;->this$0:Landroid/widget/ActivityChooserModel;

    const/4 v12, 0x1

    #setter for: Landroid/widget/ActivityChooserModel;->mCanReadHistoricalData:Z
    invoke-static {v11, v12}, Landroid/widget/ActivityChooserModel;->access$602(Landroid/widget/ActivityChooserModel;Z)Z

    if-eqz v1, :cond_a2

    :try_start_9f
    invoke-virtual {v1}, Ljava/io/FileOutputStream;->close()V
    :try_end_a2
    .catch Ljava/io/IOException; {:try_start_9f .. :try_end_a2} :catch_d1

    .end local v4           #i:I
    .end local v9           #recordCount:I
    :cond_a2
    :goto_a2
    const/4 v11, 0x0

    goto :goto_8d

    :catch_a4
    move-exception v5

    .local v5, iae:Ljava/lang/IllegalArgumentException;
    :try_start_a5
    invoke-static {}, Landroid/widget/ActivityChooserModel;->access$400()Ljava/lang/String;

    move-result-object v11

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "Error writing historical recrod file: "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    iget-object v13, p0, Landroid/widget/ActivityChooserModel$PersistHistoryAsyncTask;->this$0:Landroid/widget/ActivityChooserModel;

    #getter for: Landroid/widget/ActivityChooserModel;->mHistoryFileName:Ljava/lang/String;
    invoke-static {v13}, Landroid/widget/ActivityChooserModel;->access$500(Landroid/widget/ActivityChooserModel;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_c5
    .catchall {:try_start_a5 .. :try_end_c5} :catchall_12e

    iget-object v11, p0, Landroid/widget/ActivityChooserModel$PersistHistoryAsyncTask;->this$0:Landroid/widget/ActivityChooserModel;

    const/4 v12, 0x1

    #setter for: Landroid/widget/ActivityChooserModel;->mCanReadHistoricalData:Z
    invoke-static {v11, v12}, Landroid/widget/ActivityChooserModel;->access$602(Landroid/widget/ActivityChooserModel;Z)Z

    if-eqz v1, :cond_a2

    :try_start_cd
    invoke-virtual {v1}, Ljava/io/FileOutputStream;->close()V
    :try_end_d0
    .catch Ljava/io/IOException; {:try_start_cd .. :try_end_d0} :catch_d1

    goto :goto_a2

    .end local v5           #iae:Ljava/lang/IllegalArgumentException;
    :catch_d1
    move-exception v11

    goto :goto_a2

    :catch_d3
    move-exception v7

    .local v7, ise:Ljava/lang/IllegalStateException;
    :try_start_d4
    invoke-static {}, Landroid/widget/ActivityChooserModel;->access$400()Ljava/lang/String;

    move-result-object v11

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "Error writing historical recrod file: "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    iget-object v13, p0, Landroid/widget/ActivityChooserModel$PersistHistoryAsyncTask;->this$0:Landroid/widget/ActivityChooserModel;

    #getter for: Landroid/widget/ActivityChooserModel;->mHistoryFileName:Ljava/lang/String;
    invoke-static {v13}, Landroid/widget/ActivityChooserModel;->access$500(Landroid/widget/ActivityChooserModel;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_f4
    .catchall {:try_start_d4 .. :try_end_f4} :catchall_12e

    iget-object v11, p0, Landroid/widget/ActivityChooserModel$PersistHistoryAsyncTask;->this$0:Landroid/widget/ActivityChooserModel;

    const/4 v12, 0x1

    #setter for: Landroid/widget/ActivityChooserModel;->mCanReadHistoricalData:Z
    invoke-static {v11, v12}, Landroid/widget/ActivityChooserModel;->access$602(Landroid/widget/ActivityChooserModel;Z)Z

    if-eqz v1, :cond_a2

    :try_start_fc
    invoke-virtual {v1}, Ljava/io/FileOutputStream;->close()V
    :try_end_ff
    .catch Ljava/io/IOException; {:try_start_fc .. :try_end_ff} :catch_d1

    goto :goto_a2

    .end local v7           #ise:Ljava/lang/IllegalStateException;
    :catch_100
    move-exception v6

    .local v6, ioe:Ljava/io/IOException;
    :try_start_101
    invoke-static {}, Landroid/widget/ActivityChooserModel;->access$400()Ljava/lang/String;

    move-result-object v11

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "Error writing historical recrod file: "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    iget-object v13, p0, Landroid/widget/ActivityChooserModel$PersistHistoryAsyncTask;->this$0:Landroid/widget/ActivityChooserModel;

    #getter for: Landroid/widget/ActivityChooserModel;->mHistoryFileName:Ljava/lang/String;
    invoke-static {v13}, Landroid/widget/ActivityChooserModel;->access$500(Landroid/widget/ActivityChooserModel;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12, v6}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_121
    .catchall {:try_start_101 .. :try_end_121} :catchall_12e

    iget-object v11, p0, Landroid/widget/ActivityChooserModel$PersistHistoryAsyncTask;->this$0:Landroid/widget/ActivityChooserModel;

    const/4 v12, 0x1

    #setter for: Landroid/widget/ActivityChooserModel;->mCanReadHistoricalData:Z
    invoke-static {v11, v12}, Landroid/widget/ActivityChooserModel;->access$602(Landroid/widget/ActivityChooserModel;Z)Z

    if-eqz v1, :cond_a2

    :try_start_129
    invoke-virtual {v1}, Ljava/io/FileOutputStream;->close()V
    :try_end_12c
    .catch Ljava/io/IOException; {:try_start_129 .. :try_end_12c} :catch_d1

    goto/16 :goto_a2

    .end local v6           #ioe:Ljava/io/IOException;
    :catchall_12e
    move-exception v11

    iget-object v12, p0, Landroid/widget/ActivityChooserModel$PersistHistoryAsyncTask;->this$0:Landroid/widget/ActivityChooserModel;

    const/4 v13, 0x1

    #setter for: Landroid/widget/ActivityChooserModel;->mCanReadHistoricalData:Z
    invoke-static {v12, v13}, Landroid/widget/ActivityChooserModel;->access$602(Landroid/widget/ActivityChooserModel;Z)Z

    if-eqz v1, :cond_13a

    :try_start_137
    invoke-virtual {v1}, Ljava/io/FileOutputStream;->close()V
    :try_end_13a
    .catch Ljava/io/IOException; {:try_start_137 .. :try_end_13a} :catch_13b

    :cond_13a
    :goto_13a
    throw v11

    :catch_13b
    move-exception v12

    goto :goto_13a
.end method
