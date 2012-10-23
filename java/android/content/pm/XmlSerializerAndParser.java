// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import java.io.IOException;
import org.xmlpull.v1.*;

public interface XmlSerializerAndParser {

    public abstract Object createFromXml(XmlPullParser xmlpullparser) throws IOException, XmlPullParserException;

    public abstract void writeAsXml(Object obj, XmlSerializer xmlserializer) throws IOException;
}
