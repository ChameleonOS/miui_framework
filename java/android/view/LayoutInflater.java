// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.content.Context;
import android.content.res.*;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Xml;
import android.widget.FrameLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.view:
//            InflateException, ViewGroup, View, ViewStub

public abstract class LayoutInflater {
    private static class BlinkLayout extends FrameLayout {

        private void makeBlink() {
            Message message = mHandler.obtainMessage(66);
            mHandler.sendMessageDelayed(message, 500L);
        }

        protected void dispatchDraw(Canvas canvas) {
            if(mBlinkState)
                super.dispatchDraw(canvas);
        }

        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            mBlink = true;
            mBlinkState = true;
            makeBlink();
        }

        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            mBlink = false;
            mBlinkState = true;
            mHandler.removeMessages(66);
        }

        private static final int BLINK_DELAY = 500;
        private static final int MESSAGE_BLINK = 66;
        private boolean mBlink;
        private boolean mBlinkState;
        private final Handler mHandler = new Handler(new android.os.Handler.Callback() {

            public boolean handleMessage(Message message) {
                boolean flag = true;
                boolean flag1 = false;
                if(message.what == 66) {
                    if(mBlink) {
                        BlinkLayout blinklayout = BlinkLayout.this;
                        if(!mBlinkState)
                            flag1 = flag;
                        blinklayout.mBlinkState = flag1;
                        makeBlink();
                    }
                    invalidate();
                } else {
                    flag = false;
                }
                return flag;
            }

            final BlinkLayout this$0;

                 {
                    this$0 = BlinkLayout.this;
                    super();
                }
        });




/*
        static boolean access$102(BlinkLayout blinklayout, boolean flag) {
            blinklayout.mBlinkState = flag;
            return flag;
        }

*/


        public BlinkLayout(Context context, AttributeSet attributeset) {
            super(context, attributeset);
        }
    }

    private static class FactoryMerger
        implements Factory2 {

        public View onCreateView(View view, String s, Context context, AttributeSet attributeset) {
            View view1;
            if(mF12 != null)
                view1 = mF12.onCreateView(view, s, context, attributeset);
            else
                view1 = mF1.onCreateView(s, context, attributeset);
            if(view1 == null) {
                View view2;
                if(mF22 != null)
                    view2 = mF22.onCreateView(view, s, context, attributeset);
                else
                    view2 = mF2.onCreateView(s, context, attributeset);
                view1 = view2;
            }
            return view1;
        }

        public View onCreateView(String s, Context context, AttributeSet attributeset) {
            View view = mF1.onCreateView(s, context, attributeset);
            if(view == null)
                view = mF2.onCreateView(s, context, attributeset);
            return view;
        }

        private final Factory mF1;
        private final Factory2 mF12;
        private final Factory mF2;
        private final Factory2 mF22;

        FactoryMerger(Factory factory, Factory2 factory2, Factory factory1, Factory2 factory2_1) {
            mF1 = factory;
            mF2 = factory1;
            mF12 = factory2;
            mF22 = factory2_1;
        }
    }

    public static interface Factory2
        extends Factory {

        public abstract View onCreateView(View view, String s, Context context, AttributeSet attributeset);
    }

    public static interface Factory {

        public abstract View onCreateView(String s, Context context, AttributeSet attributeset);
    }

    public static interface Filter {

        public abstract boolean onLoadClass(Class class1);
    }


    protected LayoutInflater(Context context) {
        DEBUG = false;
        mConstructorArgs = new Object[2];
        mContext = context;
    }

    protected LayoutInflater(LayoutInflater layoutinflater, Context context) {
        DEBUG = false;
        mConstructorArgs = new Object[2];
        mContext = context;
        mFactory = layoutinflater.mFactory;
        mFactory2 = layoutinflater.mFactory2;
        mPrivateFactory = layoutinflater.mPrivateFactory;
        mFilter = layoutinflater.mFilter;
    }

    private void failNotAllowed(String s, String s1, AttributeSet attributeset) {
        StringBuilder stringbuilder = (new StringBuilder()).append(attributeset.getPositionDescription()).append(": Class not allowed to be inflated ");
        if(s1 != null)
            s = (new StringBuilder()).append(s1).append(s).toString();
        throw new InflateException(stringbuilder.append(s).toString());
    }

    public static LayoutInflater from(Context context) {
        LayoutInflater layoutinflater = (LayoutInflater)context.getSystemService("layout_inflater");
        if(layoutinflater == null)
            throw new AssertionError("LayoutInflater not found.");
        else
            return layoutinflater;
    }

    private void parseInclude(XmlPullParser xmlpullparser, View view, AttributeSet attributeset) throws XmlPullParserException, IOException {
        if(!(view instanceof ViewGroup)) goto _L2; else goto _L1
_L1:
        XmlResourceParser xmlresourceparser;
        int i = attributeset.getAttributeResourceValue(null, "layout", 0);
        if(i == 0) {
            String s1 = attributeset.getAttributeValue(null, "layout");
            if(s1 == null)
                throw new InflateException("You must specifiy a layout in the include tag: <include layout=\"@layout/layoutID\" />");
            else
                throw new InflateException((new StringBuilder()).append("You must specifiy a valid layout reference. The layout ID ").append(s1).append(" is not valid.").toString());
        }
        xmlresourceparser = getContext().getResources().getLayout(i);
        AttributeSet attributeset1;
        attributeset1 = Xml.asAttributeSet(xmlresourceparser);
        int j;
        do
            j = xmlresourceparser.next();
        while(j != 2 && j != 1);
        if(j != 2)
            throw new InflateException((new StringBuilder()).append(xmlresourceparser.getPositionDescription()).append(": No start tag found!").toString());
        break MISSING_BLOCK_LABEL_176;
        Exception exception;
        exception;
        xmlresourceparser.close();
        throw exception;
        String s = xmlresourceparser.getName();
        if(!"merge".equals(s)) goto _L4; else goto _L3
_L3:
        rInflate(xmlresourceparser, view, attributeset1, false);
_L15:
        xmlresourceparser.close();
        int i1 = xmlpullparser.getDepth();
        int j1;
        do
            j1 = xmlpullparser.next();
        while((j1 != 3 || xmlpullparser.getDepth() > i1) && j1 != 1);
        return;
_L4:
        View view1;
        ViewGroup viewgroup;
        view1 = createViewFromTag(view, s, attributeset1);
        viewgroup = (ViewGroup)view;
        ViewGroup.LayoutParams layoutparams1 = viewgroup.generateLayoutParams(attributeset);
        if(layoutparams1 == null)
            break MISSING_BLOCK_LABEL_289;
        view1.setLayoutParams(layoutparams1);
_L7:
        int l;
        rInflate(xmlresourceparser, view1, attributeset1, true);
        TypedArray typedarray = mContext.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.View, 0, 0);
        int k = typedarray.getResourceId(8, -1);
        l = typedarray.getInt(20, -1);
        typedarray.recycle();
        if(k != -1)
            view1.setId(k);
          goto _L5
_L8:
        viewgroup.addView(view1);
        continue; /* Loop/switch isn't completed */
        RuntimeException runtimeexception;
        runtimeexception;
        ViewGroup.LayoutParams layoutparams = viewgroup.generateLayoutParams(attributeset1);
        if(layoutparams == null) goto _L7; else goto _L6
_L6:
        view1.setLayoutParams(layoutparams);
          goto _L7
        Exception exception1;
        exception1;
        if(false)
            view1.setLayoutParams(null);
        throw exception1;
_L10:
        view1.setVisibility(0);
          goto _L8
_L11:
        view1.setVisibility(4);
          goto _L8
_L12:
        view1.setVisibility(8);
          goto _L8
_L2:
        throw new InflateException("<include /> can only be used inside of a ViewGroup");
_L5:
        l;
        JVM INSTR tableswitch 0 2: default 359
    //                   0 410
    //                   1 419
    //                   2 428;
           goto _L9 _L10 _L11 _L12
_L9:
        if(true) goto _L8; else goto _L13
_L13:
        if(true) goto _L15; else goto _L14
_L14:
    }

    private void parseRequestFocus(XmlPullParser xmlpullparser, View view) throws XmlPullParserException, IOException {
        view.requestFocus();
        int i = xmlpullparser.getDepth();
        int j;
        do
            j = xmlpullparser.next();
        while((j != 3 || xmlpullparser.getDepth() > i) && j != 1);
    }

    public abstract LayoutInflater cloneInContext(Context context);

    public final View createView(String s, String s1, AttributeSet attributeset) throws ClassNotFoundException, InflateException {
        boolean flag;
        Constructor constructor;
        Class class1;
        flag = true;
        constructor = (Constructor)sConstructorMap.get(s);
        class1 = null;
        if(constructor != null) goto _L2; else goto _L1
_L1:
        ClassLoader classloader1;
        String s4;
        classloader1 = mContext.getClassLoader();
        if(s1 == null)
            break MISSING_BLOCK_LABEL_559;
        s4 = (new StringBuilder()).append(s1).append(s).toString();
_L12:
        class1 = classloader1.loadClass(s4).asSubclass(android/view/View);
        if(mFilter != null && class1 != null && !mFilter.onLoadClass(class1))
            failNotAllowed(s, s1, attributeset);
        constructor = class1.getConstructor(mConstructorSignature);
        sConstructorMap.put(s, constructor);
_L5:
        View view;
        Object aobj[] = mConstructorArgs;
        aobj[1] = attributeset;
        view = (View)constructor.newInstance(aobj);
        if(view instanceof ViewStub)
            ((ViewStub)view).setLayoutInflater(this);
          goto _L3
_L2:
        if(mFilter == null) goto _L5; else goto _L4
_L4:
        Boolean boolean1 = (Boolean)mFilterMap.get(s);
        if(boolean1 != null) goto _L7; else goto _L6
_L6:
        ClassLoader classloader = mContext.getClassLoader();
        if(s1 == null) goto _L9; else goto _L8
_L8:
        String s3 = (new StringBuilder()).append(s1).append(s).toString();
_L10:
        class1 = classloader.loadClass(s3).asSubclass(android/view/View);
        NoSuchMethodException nosuchmethodexception;
        if(class1 == null || !mFilter.onLoadClass(class1))
            flag = false;
        mFilterMap.put(s, Boolean.valueOf(flag));
        if(!flag)
            failNotAllowed(s, s1, attributeset);
          goto _L5
        nosuchmethodexception;
        StringBuilder stringbuilder2 = (new StringBuilder()).append(attributeset.getPositionDescription()).append(": Error inflating class ");
        if(s1 != null)
            s = (new StringBuilder()).append(s1).append(s).toString();
        InflateException inflateexception2 = new InflateException(stringbuilder2.append(s).toString());
        inflateexception2.initCause(nosuchmethodexception);
        throw inflateexception2;
_L9:
        s3 = s;
          goto _L10
_L7:
        if(!boolean1.equals(Boolean.FALSE)) goto _L5; else goto _L11
_L11:
        failNotAllowed(s, s1, attributeset);
          goto _L5
        ClassCastException classcastexception;
        classcastexception;
        StringBuilder stringbuilder1 = (new StringBuilder()).append(attributeset.getPositionDescription()).append(": Class is not a View ");
        if(s1 != null)
            s = (new StringBuilder()).append(s1).append(s).toString();
        InflateException inflateexception1 = new InflateException(stringbuilder1.append(s).toString());
        inflateexception1.initCause(classcastexception);
        throw inflateexception1;
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        throw classnotfoundexception;
        Exception exception;
        exception;
        StringBuilder stringbuilder = (new StringBuilder()).append(attributeset.getPositionDescription()).append(": Error inflating class ");
        String s2;
        InflateException inflateexception;
        if(class1 == null)
            s2 = "<unknown>";
        else
            s2 = class1.getName();
        inflateexception = new InflateException(stringbuilder.append(s2).toString());
        inflateexception.initCause(exception);
        throw inflateexception;
_L3:
        return view;
        s4 = s;
          goto _L12
    }

    View createViewFromTag(View view, String s, AttributeSet attributeset) {
        if(s.equals("view"))
            s = attributeset.getAttributeValue(null, "class");
        View view1;
        if(mFactory2 != null) {
            view1 = mFactory2.onCreateView(view, s, mContext, attributeset);
        } else {
            if(mFactory == null)
                break MISSING_BLOCK_LABEL_257;
            view1 = mFactory.onCreateView(s, mContext, attributeset);
        }
_L5:
        if(view1 == null && mPrivateFactory != null)
            view1 = mPrivateFactory.onCreateView(view, s, mContext, attributeset);
        if(view1 != null) goto _L2; else goto _L1
_L1:
        if(-1 != s.indexOf('.')) goto _L4; else goto _L3
_L3:
        view1 = onCreateView(view, s, attributeset);
          goto _L2
_L4:
        View view2 = createView(s, null, attributeset);
        view1 = view2;
          goto _L2
        InflateException inflateexception2;
        inflateexception2;
        throw inflateexception2;
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        InflateException inflateexception1 = new InflateException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Error inflating class ").append(s).toString());
        inflateexception1.initCause(classnotfoundexception);
        throw inflateexception1;
        Exception exception;
        exception;
        InflateException inflateexception = new InflateException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Error inflating class ").append(s).toString());
        inflateexception.initCause(exception);
        throw inflateexception;
_L2:
        return view1;
        view1 = null;
          goto _L5
    }

    public Context getContext() {
        return mContext;
    }

    public final Factory getFactory() {
        return mFactory;
    }

    public final Factory2 getFactory2() {
        return mFactory2;
    }

    public Filter getFilter() {
        return mFilter;
    }

    public View inflate(int i, ViewGroup viewgroup) {
        boolean flag;
        if(viewgroup != null)
            flag = true;
        else
            flag = false;
        return inflate(i, viewgroup, flag);
    }

    public View inflate(int i, ViewGroup viewgroup, boolean flag) {
        XmlResourceParser xmlresourceparser = getContext().getResources().getLayout(i);
        View view = inflate(((XmlPullParser) (xmlresourceparser)), viewgroup, flag);
        xmlresourceparser.close();
        return view;
        Exception exception;
        exception;
        xmlresourceparser.close();
        throw exception;
    }

    public View inflate(XmlPullParser xmlpullparser, ViewGroup viewgroup) {
        boolean flag;
        if(viewgroup != null)
            flag = true;
        else
            flag = false;
        return inflate(xmlpullparser, viewgroup, flag);
    }

    public View inflate(XmlPullParser xmlpullparser, ViewGroup viewgroup, boolean flag) {
        Object aobj[] = mConstructorArgs;
        aobj;
        JVM INSTR monitorenter ;
        AttributeSet attributeset;
        Context context;
        attributeset = Xml.asAttributeSet(xmlpullparser);
        context = (Context)mConstructorArgs[0];
        mConstructorArgs[0] = mContext;
        Object obj = viewgroup;
        int i;
        do
            i = xmlpullparser.next();
        while(i != 2 && i != 1);
        if(i != 2)
            throw new InflateException((new StringBuilder()).append(xmlpullparser.getPositionDescription()).append(": No start tag found!").toString());
        break MISSING_BLOCK_LABEL_152;
        XmlPullParserException xmlpullparserexception;
        xmlpullparserexception;
        InflateException inflateexception1 = new InflateException(xmlpullparserexception.getMessage());
        inflateexception1.initCause(xmlpullparserexception);
        throw inflateexception1;
        Exception exception1;
        exception1;
        mConstructorArgs[0] = context;
        mConstructorArgs[1] = null;
        throw exception1;
        Exception exception;
        exception;
        throw exception;
        String s = xmlpullparser.getName();
        if(!"merge".equals(s)) goto _L2; else goto _L1
_L1:
        if(viewgroup == null || !flag)
            throw new InflateException("<merge /> can be used only with a valid ViewGroup root and attachToRoot=true");
          goto _L3
        IOException ioexception;
        ioexception;
        InflateException inflateexception = new InflateException((new StringBuilder()).append(xmlpullparser.getPositionDescription()).append(": ").append(ioexception.getMessage()).toString());
        inflateexception.initCause(ioexception);
        throw inflateexception;
_L3:
        rInflate(xmlpullparser, viewgroup, attributeset, false);
_L8:
        mConstructorArgs[0] = context;
        mConstructorArgs[1] = null;
        aobj;
        JVM INSTR monitorexit ;
        return ((View) (obj));
_L2:
        if(!"blink".equals(s)) goto _L5; else goto _L4
_L4:
        Object obj1 = new BlinkLayout(mContext, attributeset);
_L6:
        ViewGroup.LayoutParams layoutparams = null;
        if(viewgroup != null) {
            layoutparams = viewgroup.generateLayoutParams(attributeset);
            if(!flag)
                ((View) (obj1)).setLayoutParams(layoutparams);
        }
        rInflate(xmlpullparser, ((View) (obj1)), attributeset, true);
        if(viewgroup != null && flag)
            viewgroup.addView(((View) (obj1)), layoutparams);
        break MISSING_BLOCK_LABEL_372;
_L5:
        View view = createViewFromTag(viewgroup, s, attributeset);
        obj1 = view;
          goto _L6
        if(viewgroup == null || !flag)
            obj = obj1;
        if(true) goto _L8; else goto _L7
_L7:
    }

    protected View onCreateView(View view, String s, AttributeSet attributeset) throws ClassNotFoundException {
        return onCreateView(s, attributeset);
    }

    protected View onCreateView(String s, AttributeSet attributeset) throws ClassNotFoundException {
        return createView(s, "android.view.", attributeset);
    }

    void rInflate(XmlPullParser xmlpullparser, View view, AttributeSet attributeset, boolean flag) throws XmlPullParserException, IOException {
        int i = xmlpullparser.getDepth();
        do {
            int j = xmlpullparser.next();
            if(j == 3 && xmlpullparser.getDepth() <= i || j == 1)
                break;
            if(j == 2) {
                String s = xmlpullparser.getName();
                if("requestFocus".equals(s))
                    parseRequestFocus(xmlpullparser, view);
                else
                if("include".equals(s)) {
                    if(xmlpullparser.getDepth() == 0)
                        throw new InflateException("<include /> cannot be the root element");
                    parseInclude(xmlpullparser, view, attributeset);
                } else {
                    if("merge".equals(s))
                        throw new InflateException("<merge /> must be the root element");
                    if("blink".equals(s)) {
                        BlinkLayout blinklayout = new BlinkLayout(mContext, attributeset);
                        ViewGroup viewgroup = (ViewGroup)view;
                        ViewGroup.LayoutParams layoutparams = viewgroup.generateLayoutParams(attributeset);
                        rInflate(xmlpullparser, ((View) (blinklayout)), attributeset, true);
                        viewgroup.addView(blinklayout, layoutparams);
                    } else {
                        View view1 = createViewFromTag(view, s, attributeset);
                        ViewGroup viewgroup1 = (ViewGroup)view;
                        ViewGroup.LayoutParams layoutparams1 = viewgroup1.generateLayoutParams(attributeset);
                        rInflate(xmlpullparser, view1, attributeset, true);
                        viewgroup1.addView(view1, layoutparams1);
                    }
                }
            }
        } while(true);
        if(flag)
            view.onFinishInflate();
    }

    public void setFactory(Factory factory) {
        if(mFactorySet)
            throw new IllegalStateException("A factory has already been set on this LayoutInflater");
        if(factory == null)
            throw new NullPointerException("Given factory can not be null");
        mFactorySet = true;
        if(mFactory == null)
            mFactory = factory;
        else
            mFactory = new FactoryMerger(factory, null, mFactory, mFactory2);
    }

    public void setFactory2(Factory2 factory2) {
        if(mFactorySet)
            throw new IllegalStateException("A factory has already been set on this LayoutInflater");
        if(factory2 == null)
            throw new NullPointerException("Given factory can not be null");
        mFactorySet = true;
        if(mFactory == null) {
            mFactory2 = factory2;
            mFactory = factory2;
        } else {
            mFactory = new FactoryMerger(factory2, factory2, mFactory, mFactory2);
        }
    }

    public void setFilter(Filter filter) {
        mFilter = filter;
        if(filter != null)
            mFilterMap = new HashMap();
    }

    public void setPrivateFactory(Factory2 factory2) {
        mPrivateFactory = factory2;
    }

    private static final String TAG_1995 = "blink";
    private static final String TAG_INCLUDE = "include";
    private static final String TAG_MERGE = "merge";
    private static final String TAG_REQUEST_FOCUS = "requestFocus";
    static final Class mConstructorSignature[];
    private static final HashMap sConstructorMap = new HashMap();
    private final boolean DEBUG;
    final Object mConstructorArgs[];
    protected final Context mContext;
    private Factory mFactory;
    private Factory2 mFactory2;
    private boolean mFactorySet;
    private Filter mFilter;
    private HashMap mFilterMap;
    private Factory2 mPrivateFactory;

    static  {
        Class aclass[] = new Class[2];
        aclass[0] = android/content/Context;
        aclass[1] = android/util/AttributeSet;
        mConstructorSignature = aclass;
    }
}
