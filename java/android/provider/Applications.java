// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.provider;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.List;

// Referenced classes of package android.provider:
//            BaseColumns

public class Applications {
    public static interface ApplicationColumns
        extends BaseColumns {

        public static final String ICON = "icon";
        public static final String NAME = "name";
        public static final String URI = "uri";
    }


    private Applications() {
    }

    public static Uri componentNameToUri(String s, String s1) {
        return CONTENT_URI.buildUpon().appendEncodedPath("applications").appendPath(s).appendPath(s1).build();
    }

    public static Cursor search(ContentResolver contentresolver, String s) {
        return contentresolver.query(CONTENT_URI.buildUpon().appendPath("search").appendPath(s).build(), null, null, null, null);
    }

    public static ComponentName uriToComponentName(Uri uri) {
        ComponentName componentname;
        componentname = null;
        break MISSING_BLOCK_LABEL_2;
        while(true)  {
            do
                return componentname;
            while(uri == null || !"content".equals(uri.getScheme()) || !"applications".equals(uri.getAuthority()));
            List list = uri.getPathSegments();
            if(list.size() == 3 && "applications".equals(list.get(0)))
                componentname = new ComponentName((String)list.get(1), (String)list.get(2));
        }
    }

    public static final String APPLICATION_DIR_TYPE = "vnd.android.cursor.dir/vnd.android.application";
    public static final String APPLICATION_ITEM_TYPE = "vnd.android.cursor.item/vnd.android.application";
    public static final String APPLICATION_PATH = "applications";
    private static final String APPLICATION_SUB_TYPE = "vnd.android.application";
    public static final String AUTHORITY = "applications";
    public static final Uri CONTENT_URI = Uri.parse("content://applications");
    public static final String SEARCH_PATH = "search";

}
