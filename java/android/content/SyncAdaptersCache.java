// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.content.pm.RegisteredServicesCache;
import android.content.pm.XmlSerializerAndParser;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.*;

// Referenced classes of package android.content:
//            SyncAdapterType, Context

class SyncAdaptersCache extends RegisteredServicesCache {
    static class MySerializer
        implements XmlSerializerAndParser {

        public SyncAdapterType createFromXml(XmlPullParser xmlpullparser) throws IOException, XmlPullParserException {
            return SyncAdapterType.newKey(xmlpullparser.getAttributeValue(null, "authority"), xmlpullparser.getAttributeValue(null, "accountType"));
        }

        public volatile Object createFromXml(XmlPullParser xmlpullparser) throws IOException, XmlPullParserException {
            return createFromXml(xmlpullparser);
        }

        public void writeAsXml(SyncAdapterType syncadaptertype, XmlSerializer xmlserializer) throws IOException {
            xmlserializer.attribute(null, "authority", syncadaptertype.authority);
            xmlserializer.attribute(null, "accountType", syncadaptertype.accountType);
        }

        public volatile void writeAsXml(Object obj, XmlSerializer xmlserializer) throws IOException {
            writeAsXml((SyncAdapterType)obj, xmlserializer);
        }

        MySerializer() {
        }
    }


    SyncAdaptersCache(Context context) {
        super(context, "android.content.SyncAdapter", "android.content.SyncAdapter", "sync-adapter", sSerializer);
    }

    public SyncAdapterType parseServiceAttributes(Resources resources, String s, AttributeSet attributeset) {
        TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.SyncAdapter);
        String s1;
        String s2;
        s1 = typedarray.getString(2);
        s2 = typedarray.getString(1);
        if(s1 != null && s2 != null) goto _L2; else goto _L1
_L1:
        SyncAdapterType syncadaptertype;
        syncadaptertype = null;
        typedarray.recycle();
_L4:
        return syncadaptertype;
_L2:
        syncadaptertype = new SyncAdapterType(s1, s2, typedarray.getBoolean(3, true), typedarray.getBoolean(4, true), typedarray.getBoolean(6, false), typedarray.getBoolean(5, false), typedarray.getString(0));
        typedarray.recycle();
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        typedarray.recycle();
        throw exception;
    }

    public volatile Object parseServiceAttributes(Resources resources, String s, AttributeSet attributeset) {
        return parseServiceAttributes(resources, s, attributeset);
    }

    private static final String ATTRIBUTES_NAME = "sync-adapter";
    private static final String SERVICE_INTERFACE = "android.content.SyncAdapter";
    private static final String SERVICE_META_DATA = "android.content.SyncAdapter";
    private static final String TAG = "Account";
    private static final MySerializer sSerializer = new MySerializer();

}
