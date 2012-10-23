// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.animation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.view.animation:
//            AnimationSet, AlphaAnimation, ScaleAnimation, RotateAnimation, 
//            TranslateAnimation, LinearInterpolator, AccelerateInterpolator, DecelerateInterpolator, 
//            AccelerateDecelerateInterpolator, CycleInterpolator, AnticipateInterpolator, OvershootInterpolator, 
//            AnticipateOvershootInterpolator, BounceInterpolator, LayoutAnimationController, GridLayoutAnimationController, 
//            Animation, Interpolator

public class AnimationUtils {

    public AnimationUtils() {
    }

    private static Animation createAnimationFromXml(Context context, XmlPullParser xmlpullparser) throws XmlPullParserException, IOException {
        return createAnimationFromXml(context, xmlpullparser, null, Xml.asAttributeSet(xmlpullparser));
    }

    private static Animation createAnimationFromXml(Context context, XmlPullParser xmlpullparser, AnimationSet animationset, AttributeSet attributeset) throws XmlPullParserException, IOException {
        Object obj = null;
        int i = xmlpullparser.getDepth();
        do {
            int j = xmlpullparser.next();
            if((j != 3 || xmlpullparser.getDepth() > i) && j != 1) {
                if(j == 2) {
                    String s = xmlpullparser.getName();
                    if(s.equals("set")) {
                        obj = new AnimationSet(context, attributeset);
                        createAnimationFromXml(context, xmlpullparser, (AnimationSet)obj, attributeset);
                    } else
                    if(s.equals("alpha"))
                        obj = new AlphaAnimation(context, attributeset);
                    else
                    if(s.equals("scale"))
                        obj = new ScaleAnimation(context, attributeset);
                    else
                    if(s.equals("rotate"))
                        obj = new RotateAnimation(context, attributeset);
                    else
                    if(s.equals("translate"))
                        obj = new TranslateAnimation(context, attributeset);
                    else
                        throw new RuntimeException((new StringBuilder()).append("Unknown animation name: ").append(xmlpullparser.getName()).toString());
                    if(animationset != null)
                        animationset.addAnimation(((Animation) (obj)));
                }
            } else {
                return ((Animation) (obj));
            }
        } while(true);
    }

    private static Interpolator createInterpolatorFromXml(Context context, XmlPullParser xmlpullparser) throws XmlPullParserException, IOException {
        Object obj = null;
        int i = xmlpullparser.getDepth();
        do {
            int j = xmlpullparser.next();
            if(j == 3 && xmlpullparser.getDepth() <= i || j == 1)
                break;
            if(j == 2) {
                AttributeSet attributeset = Xml.asAttributeSet(xmlpullparser);
                String s = xmlpullparser.getName();
                if(s.equals("linearInterpolator"))
                    obj = new LinearInterpolator(context, attributeset);
                else
                if(s.equals("accelerateInterpolator"))
                    obj = new AccelerateInterpolator(context, attributeset);
                else
                if(s.equals("decelerateInterpolator"))
                    obj = new DecelerateInterpolator(context, attributeset);
                else
                if(s.equals("accelerateDecelerateInterpolator"))
                    obj = new AccelerateDecelerateInterpolator(context, attributeset);
                else
                if(s.equals("cycleInterpolator"))
                    obj = new CycleInterpolator(context, attributeset);
                else
                if(s.equals("anticipateInterpolator"))
                    obj = new AnticipateInterpolator(context, attributeset);
                else
                if(s.equals("overshootInterpolator"))
                    obj = new OvershootInterpolator(context, attributeset);
                else
                if(s.equals("anticipateOvershootInterpolator"))
                    obj = new AnticipateOvershootInterpolator(context, attributeset);
                else
                if(s.equals("bounceInterpolator"))
                    obj = new BounceInterpolator(context, attributeset);
                else
                    throw new RuntimeException((new StringBuilder()).append("Unknown interpolator name: ").append(xmlpullparser.getName()).toString());
            }
        } while(true);
        return ((Interpolator) (obj));
    }

    private static LayoutAnimationController createLayoutAnimationFromXml(Context context, XmlPullParser xmlpullparser) throws XmlPullParserException, IOException {
        return createLayoutAnimationFromXml(context, xmlpullparser, Xml.asAttributeSet(xmlpullparser));
    }

    private static LayoutAnimationController createLayoutAnimationFromXml(Context context, XmlPullParser xmlpullparser, AttributeSet attributeset) throws XmlPullParserException, IOException {
        Object obj = null;
        int i = xmlpullparser.getDepth();
        do {
            int j = xmlpullparser.next();
            if(j == 3 && xmlpullparser.getDepth() <= i || j == 1)
                break;
            if(j == 2) {
                String s = xmlpullparser.getName();
                if("layoutAnimation".equals(s))
                    obj = new LayoutAnimationController(context, attributeset);
                else
                if("gridLayoutAnimation".equals(s))
                    obj = new GridLayoutAnimationController(context, attributeset);
                else
                    throw new RuntimeException((new StringBuilder()).append("Unknown layout animation name: ").append(s).toString());
            }
        } while(true);
        return ((LayoutAnimationController) (obj));
    }

    public static long currentAnimationTimeMillis() {
        return SystemClock.uptimeMillis();
    }

    public static Animation loadAnimation(Context context, int i) throws android.content.res.Resources.NotFoundException {
        XmlResourceParser xmlresourceparser = null;
        Animation animation;
        xmlresourceparser = context.getResources().getAnimation(i);
        animation = createAnimationFromXml(context, xmlresourceparser);
        if(xmlresourceparser != null)
            xmlresourceparser.close();
        return animation;
        XmlPullParserException xmlpullparserexception;
        xmlpullparserexception;
        android.content.res.Resources.NotFoundException notfoundexception1 = new android.content.res.Resources.NotFoundException((new StringBuilder()).append("Can't load animation resource ID #0x").append(Integer.toHexString(i)).toString());
        notfoundexception1.initCause(xmlpullparserexception);
        throw notfoundexception1;
        Exception exception;
        exception;
        if(xmlresourceparser != null)
            xmlresourceparser.close();
        throw exception;
        IOException ioexception;
        ioexception;
        android.content.res.Resources.NotFoundException notfoundexception = new android.content.res.Resources.NotFoundException((new StringBuilder()).append("Can't load animation resource ID #0x").append(Integer.toHexString(i)).toString());
        notfoundexception.initCause(ioexception);
        throw notfoundexception;
    }

    public static Interpolator loadInterpolator(Context context, int i) throws android.content.res.Resources.NotFoundException {
        XmlResourceParser xmlresourceparser = null;
        Interpolator interpolator;
        xmlresourceparser = context.getResources().getAnimation(i);
        interpolator = createInterpolatorFromXml(context, xmlresourceparser);
        if(xmlresourceparser != null)
            xmlresourceparser.close();
        return interpolator;
        XmlPullParserException xmlpullparserexception;
        xmlpullparserexception;
        android.content.res.Resources.NotFoundException notfoundexception1 = new android.content.res.Resources.NotFoundException((new StringBuilder()).append("Can't load animation resource ID #0x").append(Integer.toHexString(i)).toString());
        notfoundexception1.initCause(xmlpullparserexception);
        throw notfoundexception1;
        Exception exception;
        exception;
        if(xmlresourceparser != null)
            xmlresourceparser.close();
        throw exception;
        IOException ioexception;
        ioexception;
        android.content.res.Resources.NotFoundException notfoundexception = new android.content.res.Resources.NotFoundException((new StringBuilder()).append("Can't load animation resource ID #0x").append(Integer.toHexString(i)).toString());
        notfoundexception.initCause(ioexception);
        throw notfoundexception;
    }

    public static LayoutAnimationController loadLayoutAnimation(Context context, int i) throws android.content.res.Resources.NotFoundException {
        XmlResourceParser xmlresourceparser = null;
        LayoutAnimationController layoutanimationcontroller;
        xmlresourceparser = context.getResources().getAnimation(i);
        layoutanimationcontroller = createLayoutAnimationFromXml(context, xmlresourceparser);
        if(xmlresourceparser != null)
            xmlresourceparser.close();
        return layoutanimationcontroller;
        XmlPullParserException xmlpullparserexception;
        xmlpullparserexception;
        android.content.res.Resources.NotFoundException notfoundexception1 = new android.content.res.Resources.NotFoundException((new StringBuilder()).append("Can't load animation resource ID #0x").append(Integer.toHexString(i)).toString());
        notfoundexception1.initCause(xmlpullparserexception);
        throw notfoundexception1;
        Exception exception;
        exception;
        if(xmlresourceparser != null)
            xmlresourceparser.close();
        throw exception;
        IOException ioexception;
        ioexception;
        android.content.res.Resources.NotFoundException notfoundexception = new android.content.res.Resources.NotFoundException((new StringBuilder()).append("Can't load animation resource ID #0x").append(Integer.toHexString(i)).toString());
        notfoundexception.initCause(ioexception);
        throw notfoundexception;
    }

    public static Animation makeInAnimation(Context context, boolean flag) {
        Animation animation;
        if(flag)
            animation = loadAnimation(context, 0x10a0002);
        else
            animation = loadAnimation(context, 0x10a004f);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.setStartTime(currentAnimationTimeMillis());
        return animation;
    }

    public static Animation makeInChildBottomAnimation(Context context) {
        Animation animation = loadAnimation(context, 0x10a004e);
        animation.setInterpolator(new AccelerateInterpolator());
        animation.setStartTime(currentAnimationTimeMillis());
        return animation;
    }

    public static Animation makeOutAnimation(Context context, boolean flag) {
        Animation animation;
        if(flag)
            animation = loadAnimation(context, 0x10a0003);
        else
            animation = loadAnimation(context, 0x10a0052);
        animation.setInterpolator(new AccelerateInterpolator());
        animation.setStartTime(currentAnimationTimeMillis());
        return animation;
    }

    private static final int SEQUENTIALLY = 1;
    private static final int TOGETHER;
}
