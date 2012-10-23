// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.provider;

import android.net.Uri;

public class Notes {
    public static final class CallNote
        implements DataColumns {

        public static final String CALL_DATE = "data1";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/call_note";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/call_note";
        public static final Uri CONTENT_URI = Uri.parse("content://notes/call_note");
        public static final String PHONE_NUMBER = "data3";


        public CallNote() {
        }
    }

    public static final class TextNote
        implements DataColumns {

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/text_note";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/text_note";
        public static final Uri CONTENT_URI = Uri.parse("content://notes/text_note");
        public static final String MODE = "data1";
        public static final int MODE_CHECK_LIST = 1;


        public TextNote() {
        }
    }

    public static interface DataColumns {

        public static final String CONTENT = "content";
        public static final String CREATED_DATE = "created_date";
        public static final String DATA1 = "data1";
        public static final String DATA2 = "data2";
        public static final String DATA3 = "data3";
        public static final String DATA4 = "data4";
        public static final String DATA5 = "data5";
        public static final String ID = "_id";
        public static final String MIME_TYPE = "mime_type";
        public static final String MODIFIED_DATE = "modified_date";
        public static final String NOTE_ID = "note_id";
    }

    public static interface NoteColumns {

        public static final String ALERTED_DATE = "alert_date";
        public static final String BG_COLOR_ID = "bg_color_id";
        public static final String CREATED_DATE = "created_date";
        public static final String GTASK_ID = "gtask_id";
        public static final String HAS_ATTACHMENT = "has_attachment";
        public static final String ID = "_id";
        public static final String LOCAL_MODIFIED = "local_modified";
        public static final String MODIFIED_DATE = "modified_date";
        public static final String NOTES_COUNT = "notes_count";
        public static final String ORIGIN_PARENT_ID = "origin_parent_id";
        public static final String PARENT_ID = "parent_id";
        public static final String SNIPPET = "snippet";
        public static final String SORT = "sort";
        public static final String SUBJECT = "subject";
        public static final String SYNC_ID = "sync_id";
        public static final String TYPE = "type";
        public static final String VERSION = "version";
        public static final String WIDGET_ID = "widget_id";
        public static final String WIDGET_TYPE = "widget_type";
    }

    public static class DataConstants {

        public static final String CALL_NOTE = "vnd.android.cursor.item/call_note";
        public static final String NOTE = "vnd.android.cursor.item/text_note";

        public DataConstants() {
        }
    }


    public Notes() {
    }

    public static final String AUTHORITY = "notes";
    public static final Uri CONTENT_DATA_URI = Uri.parse("content://notes/data");
    public static final Uri CONTENT_NOTE_URI = Uri.parse("content://notes/note");
    public static final int ID_CALL_RECORD_FOLDER = -2;
    public static final int ID_ROOT_FOLDER = 0;
    public static final int ID_TEMPARAY_FOLDER = -1;
    public static final int ID_TRASH_FOLER = -3;
    public static final String INTENT_EXTRA_ALERT_DATE = "com.miui.notes.alert_date";
    public static final String INTENT_EXTRA_BACKGROUND_ID = "com.miui.notes.background_color_id";
    public static final String INTENT_EXTRA_CALL_DATE = "com.miui.notes.call_date";
    public static final String INTENT_EXTRA_FOLDER_ID = "com.miui.notes.folder_id";
    public static final String INTENT_EXTRA_WIDGET_ID = "com.miui.notes.widget_id";
    public static final String INTENT_EXTRA_WIDGET_TYPE = "com.miui.notes.widget_type";
    public static final String TAG = "Notes";
    public static final int TYPE_FOLDER = 1;
    public static final int TYPE_NOTE = 0;
    public static final int TYPE_SYSTEM = 2;
    public static final int TYPE_WIDGET_2X = 0;
    public static final int TYPE_WIDGET_4X = 1;
    public static final int TYPE_WIDGET_INVALIDE = -1;

}
