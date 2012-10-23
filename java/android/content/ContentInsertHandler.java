// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import java.io.IOException;
import java.io.InputStream;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

// Referenced classes of package android.content:
//            ContentResolver

public interface ContentInsertHandler
    extends ContentHandler {

    public abstract void insert(ContentResolver contentresolver, InputStream inputstream) throws IOException, SAXException;

    public abstract void insert(ContentResolver contentresolver, String s) throws SAXException;
}
