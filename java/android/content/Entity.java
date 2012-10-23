// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package android.content:
//            ContentValues

public final class Entity {
    public static class NamedContentValues {

        public final Uri uri;
        public final ContentValues values;

        public NamedContentValues(Uri uri1, ContentValues contentvalues) {
            uri = uri1;
            values = contentvalues;
        }
    }


    public Entity(ContentValues contentvalues) {
        mValues = contentvalues;
    }

    public void addSubValue(Uri uri, ContentValues contentvalues) {
        mSubValues.add(new NamedContentValues(uri, contentvalues));
    }

    public ContentValues getEntityValues() {
        return mValues;
    }

    public ArrayList getSubValues() {
        return mSubValues;
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Entity: ").append(getEntityValues());
        NamedContentValues namedcontentvalues;
        for(Iterator iterator = getSubValues().iterator(); iterator.hasNext(); stringbuilder.append("\n  -> ").append(namedcontentvalues.values)) {
            namedcontentvalues = (NamedContentValues)iterator.next();
            stringbuilder.append("\n  ").append(namedcontentvalues.uri);
        }

        return stringbuilder.toString();
    }

    private final ArrayList mSubValues = new ArrayList();
    private final ContentValues mValues;
}
