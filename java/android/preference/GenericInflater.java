// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.preference;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

abstract class GenericInflater {
    private static class FactoryMerger
        implements Factory {

        public Object onCreateItem(String s, Context context, AttributeSet attributeset) {
            Object obj = mF1.onCreateItem(s, context, attributeset);
            if(obj == null)
                obj = mF2.onCreateItem(s, context, attributeset);
            return obj;
        }

        private final Factory mF1;
        private final Factory mF2;

        FactoryMerger(Factory factory, Factory factory1) {
            mF1 = factory;
            mF2 = factory1;
        }
    }

    public static interface Factory {

        public abstract Object onCreateItem(String s, Context context, AttributeSet attributeset);
    }

    public static interface Parent {

        public abstract void addItemFromInflater(Object obj);
    }


    protected GenericInflater(Context context) {
        DEBUG = false;
        mConstructorArgs = new Object[2];
        mContext = context;
    }

    protected GenericInflater(GenericInflater genericinflater, Context context) {
        DEBUG = false;
        mConstructorArgs = new Object[2];
        mContext = context;
        mFactory = genericinflater.mFactory;
    }

    private final Object createItemFromTag(XmlPullParser xmlpullparser, String s, AttributeSet attributeset) {
        Object obj;
label0:
        {
            obj = null;
            Object obj1;
            try {
                if(mFactory != null)
                    obj = mFactory.onCreateItem(s, mContext, attributeset);
                if(obj != null)
                    break label0;
                if(-1 == s.indexOf('.')) {
                    obj = onCreateItem(s, attributeset);
                    break label0;
                }
                obj1 = createItem(s, null, attributeset);
            }
            catch(InflateException inflateexception2) {
                throw inflateexception2;
            }
            catch(ClassNotFoundException classnotfoundexception) {
                InflateException inflateexception1 = new InflateException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Error inflating class ").append(s).toString());
                inflateexception1.initCause(classnotfoundexception);
                throw inflateexception1;
            }
            catch(Exception exception) {
                InflateException inflateexception = new InflateException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Error inflating class ").append(s).toString());
                inflateexception.initCause(exception);
                throw inflateexception;
            }
            obj = obj1;
        }
        return obj;
    }

    private void rInflate(XmlPullParser xmlpullparser, Object obj, AttributeSet attributeset) throws XmlPullParserException, IOException {
        int i = xmlpullparser.getDepth();
        do {
            int j = xmlpullparser.next();
            if(j == 3 && xmlpullparser.getDepth() <= i || j == 1)
                break;
            if(j == 2 && !onCreateCustomFromTag(xmlpullparser, obj, attributeset)) {
                Object obj1 = createItemFromTag(xmlpullparser, xmlpullparser.getName(), attributeset);
                ((Parent)obj).addItemFromInflater(obj1);
                rInflate(xmlpullparser, obj1, attributeset);
            }
        } while(true);
    }

    public abstract GenericInflater cloneInContext(Context context);

    public final Object createItem(String s, String s1, AttributeSet attributeset) throws ClassNotFoundException, InflateException {
        Constructor constructor = (Constructor)sConstructorMap.get(s);
        if(constructor != null) goto _L2; else goto _L1
_L1:
        ClassLoader classloader;
        String s2;
        classloader = mContext.getClassLoader();
        if(s1 == null)
            break MISSING_BLOCK_LABEL_98;
        s2 = (new StringBuilder()).append(s1).append(s).toString();
_L3:
        constructor = classloader.loadClass(s2).getConstructor(mConstructorSignature);
        sConstructorMap.put(s, constructor);
_L2:
        Object obj;
        Object aobj[] = mConstructorArgs;
        aobj[1] = attributeset;
        obj = constructor.newInstance(aobj);
        return obj;
        s2 = s;
          goto _L3
        NoSuchMethodException nosuchmethodexception;
        nosuchmethodexception;
        StringBuilder stringbuilder = (new StringBuilder()).append(attributeset.getPositionDescription()).append(": Error inflating class ");
        if(s1 != null)
            s = (new StringBuilder()).append(s1).append(s).toString();
        InflateException inflateexception1 = new InflateException(stringbuilder.append(s).toString());
        inflateexception1.initCause(nosuchmethodexception);
        throw inflateexception1;
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        throw classnotfoundexception;
        Exception exception;
        exception;
        InflateException inflateexception = new InflateException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Error inflating class ").append(constructor.getClass().getName()).toString());
        inflateexception.initCause(exception);
        throw inflateexception;
    }

    public Context getContext() {
        return mContext;
    }

    public String getDefaultPackage() {
        return mDefaultPackage;
    }

    public final Factory getFactory() {
        return mFactory;
    }

    public Object inflate(int i, Parent parent) {
        boolean flag;
        if(parent != null)
            flag = true;
        else
            flag = false;
        return inflate(i, parent, flag);
    }

    public Object inflate(int i, Parent parent, boolean flag) {
        XmlResourceParser xmlresourceparser = getContext().getResources().getXml(i);
        Object obj = inflate(((XmlPullParser) (xmlresourceparser)), parent, flag);
        xmlresourceparser.close();
        return obj;
        Exception exception;
        exception;
        xmlresourceparser.close();
        throw exception;
    }

    public Object inflate(XmlPullParser xmlpullparser, Parent parent) {
        boolean flag;
        if(parent != null)
            flag = true;
        else
            flag = false;
        return inflate(xmlpullparser, parent, flag);
    }

    public Object inflate(XmlPullParser xmlpullparser, Parent parent, boolean flag) {
        Object aobj[] = mConstructorArgs;
        aobj;
        JVM INSTR monitorenter ;
        AttributeSet attributeset;
        attributeset = Xml.asAttributeSet(xmlpullparser);
        mConstructorArgs[0] = mContext;
        Exception exception;
        Parent parent1;
        try {
            int i;
            do
                i = xmlpullparser.next();
            while(i != 2 && i != 1);
            if(i != 2)
                throw new InflateException((new StringBuilder()).append(xmlpullparser.getPositionDescription()).append(": No start tag found!").toString());
        }
        catch(InflateException inflateexception2) {
            throw inflateexception2;
        }
        catch(XmlPullParserException xmlpullparserexception) {
            InflateException inflateexception1 = new InflateException(xmlpullparserexception.getMessage());
            inflateexception1.initCause(xmlpullparserexception);
            throw inflateexception1;
        }
        catch(IOException ioexception) {
            InflateException inflateexception = new InflateException((new StringBuilder()).append(xmlpullparser.getPositionDescription()).append(": ").append(ioexception.getMessage()).toString());
            inflateexception.initCause(ioexception);
            throw inflateexception;
        }
        break MISSING_BLOCK_LABEL_96;
        exception;
        throw exception;
        parent1 = onMergeRoots(parent, flag, (Parent)createItemFromTag(xmlpullparser, xmlpullparser.getName(), attributeset));
        rInflate(xmlpullparser, parent1, attributeset);
        aobj;
        JVM INSTR monitorexit ;
        return parent1;
    }

    protected boolean onCreateCustomFromTag(XmlPullParser xmlpullparser, Object obj, AttributeSet attributeset) throws XmlPullParserException {
        return false;
    }

    protected Object onCreateItem(String s, AttributeSet attributeset) throws ClassNotFoundException {
        return createItem(s, mDefaultPackage, attributeset);
    }

    protected Parent onMergeRoots(Parent parent, boolean flag, Parent parent1) {
        return parent1;
    }

    public void setDefaultPackage(String s) {
        mDefaultPackage = s;
    }

    public void setFactory(Factory factory) {
        if(mFactorySet)
            throw new IllegalStateException("A factory has already been set on this inflater");
        if(factory == null)
            throw new NullPointerException("Given factory can not be null");
        mFactorySet = true;
        if(mFactory == null)
            mFactory = factory;
        else
            mFactory = new FactoryMerger(factory, mFactory);
    }

    private static final Class mConstructorSignature[];
    private static final HashMap sConstructorMap = new HashMap();
    private final boolean DEBUG;
    private final Object mConstructorArgs[];
    protected final Context mContext;
    private String mDefaultPackage;
    private Factory mFactory;
    private boolean mFactorySet;

    static  {
        Class aclass[] = new Class[2];
        aclass[0] = android/content/Context;
        aclass[1] = android/util/AttributeSet;
        mConstructorSignature = aclass;
    }
}
