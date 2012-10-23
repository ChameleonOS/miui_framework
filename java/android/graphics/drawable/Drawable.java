// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.*;
import android.util.*;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.graphics.drawable:
//            StateListDrawable, LevelListDrawable, LayerDrawable, TransitionDrawable, 
//            ColorDrawable, GradientDrawable, ScaleDrawable, ClipDrawable, 
//            RotateDrawable, AnimatedRotateDrawable, AnimationDrawable, InsetDrawable, 
//            BitmapDrawable, NinePatchDrawable

public abstract class Drawable {
    public static abstract class ConstantState {

        public abstract int getChangingConfigurations();

        public abstract Drawable newDrawable();

        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        public ConstantState() {
        }
    }

    public static interface Callback2
        extends Callback {

        public abstract int getResolvedLayoutDirection(Drawable drawable);
    }

    public static interface Callback {

        public abstract void invalidateDrawable(Drawable drawable);

        public abstract void scheduleDrawable(Drawable drawable, Runnable runnable, long l);

        public abstract void unscheduleDrawable(Drawable drawable, Runnable runnable);
    }


    public Drawable() {
        mStateSet = StateSet.WILD_CARD;
        mLevel = 0;
        mChangingConfigurations = 0;
        mBounds = ZERO_BOUNDS_RECT;
        mCallback = null;
        mVisible = true;
    }

    public static Drawable createFromPath(String s) {
        Drawable drawable = null;
        if(s != null) goto _L2; else goto _L1
_L1:
        return drawable;
_L2:
        Bitmap bitmap = BitmapFactory.decodeFile(s);
        if(bitmap != null)
            drawable = drawableFromBitmap(null, bitmap, null, null, null, s);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static Drawable createFromResourceStream(Resources resources, TypedValue typedvalue, InputStream inputstream, String s) {
        return createFromResourceStream(resources, typedvalue, inputstream, s, null);
    }

    public static Drawable createFromResourceStream(Resources resources, TypedValue typedvalue, InputStream inputstream, String s, android.graphics.BitmapFactory.Options options) {
        Drawable drawable = null;
        if(inputstream != null) goto _L2; else goto _L1
_L1:
        return drawable;
_L2:
        Rect rect = new Rect();
        if(options == null)
            options = new android.graphics.BitmapFactory.Options();
        options.inScreenDensity = DisplayMetrics.DENSITY_DEVICE;
        Bitmap bitmap = BitmapFactory.decodeResourceStream(resources, typedvalue, inputstream, rect, options);
        if(bitmap != null) {
            byte abyte0[] = bitmap.getNinePatchChunk();
            if(abyte0 == null || !NinePatch.isNinePatchChunk(abyte0)) {
                abyte0 = null;
                rect = null;
            }
            int ai[] = bitmap.getLayoutBounds();
            Rect rect1 = null;
            if(ai != null)
                rect1 = new Rect(ai[0], ai[1], ai[2], ai[3]);
            drawable = drawableFromBitmap(resources, bitmap, abyte0, rect, rect1, s);
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static Drawable createFromStream(InputStream inputstream, String s) {
        return createFromResourceStream(null, null, inputstream, s, null);
    }

    public static Drawable createFromXml(Resources resources, XmlPullParser xmlpullparser) throws XmlPullParserException, IOException {
        AttributeSet attributeset = Xml.asAttributeSet(xmlpullparser);
        int i;
        do
            i = xmlpullparser.next();
        while(i != 2 && i != 1);
        if(i != 2)
            throw new XmlPullParserException("No start tag found");
        Drawable drawable = createFromXmlInner(resources, xmlpullparser, attributeset);
        if(drawable == null)
            throw new RuntimeException((new StringBuilder()).append("Unknown initial tag: ").append(xmlpullparser.getName()).toString());
        else
            return drawable;
    }

    public static Drawable createFromXmlInner(Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset) throws XmlPullParserException, IOException {
        String s = xmlpullparser.getName();
        if(!s.equals("selector")) goto _L2; else goto _L1
_L1:
        Object obj = new StateListDrawable();
_L4:
        ((Drawable) (obj)).inflate(resources, xmlpullparser, attributeset);
        return ((Drawable) (obj));
_L2:
        if(s.equals("level-list")) {
            obj = new LevelListDrawable();
            continue; /* Loop/switch isn't completed */
        }
        if(s.equals("layer-list")) {
            obj = new LayerDrawable();
            continue; /* Loop/switch isn't completed */
        }
        if(s.equals("transition")) {
            obj = new TransitionDrawable();
            continue; /* Loop/switch isn't completed */
        }
        if(s.equals("color")) {
            obj = new ColorDrawable();
            continue; /* Loop/switch isn't completed */
        }
        if(s.equals("shape")) {
            obj = new GradientDrawable();
            continue; /* Loop/switch isn't completed */
        }
        if(s.equals("scale")) {
            obj = new ScaleDrawable();
            continue; /* Loop/switch isn't completed */
        }
        if(s.equals("clip")) {
            obj = new ClipDrawable();
            continue; /* Loop/switch isn't completed */
        }
        if(s.equals("rotate")) {
            obj = new RotateDrawable();
            continue; /* Loop/switch isn't completed */
        }
        if(s.equals("animated-rotate")) {
            obj = new AnimatedRotateDrawable();
            continue; /* Loop/switch isn't completed */
        }
        if(s.equals("animation-list")) {
            obj = new AnimationDrawable();
            continue; /* Loop/switch isn't completed */
        }
        if(s.equals("inset")) {
            obj = new InsetDrawable();
            continue; /* Loop/switch isn't completed */
        }
        if(s.equals("bitmap")) {
            obj = new BitmapDrawable(resources);
            if(resources != null)
                ((BitmapDrawable)obj).setTargetDensity(resources.getDisplayMetrics());
            continue; /* Loop/switch isn't completed */
        }
        if(!s.equals("nine-patch"))
            break; /* Loop/switch isn't completed */
        obj = new NinePatchDrawable();
        if(resources != null)
            ((NinePatchDrawable)obj).setTargetDensity(resources.getDisplayMetrics());
        if(true) goto _L4; else goto _L3
_L3:
        throw new XmlPullParserException((new StringBuilder()).append(xmlpullparser.getPositionDescription()).append(": invalid drawable tag ").append(s).toString());
    }

    private static Drawable drawableFromBitmap(Resources resources, Bitmap bitmap, byte abyte0[], Rect rect, Rect rect1, String s) {
        Object obj;
        if(abyte0 != null)
            obj = new NinePatchDrawable(resources, bitmap, abyte0, rect, rect1, s);
        else
            obj = new BitmapDrawable(resources, bitmap);
        return ((Drawable) (obj));
    }

    public static int resolveOpacity(int i, int j) {
        if(i != j)
            if(i == 0 || j == 0)
                i = 0;
            else
            if(i == -3 || j == -3)
                i = -3;
            else
            if(i == -2 || j == -2)
                i = -2;
            else
                i = -1;
        return i;
    }

    public void clearColorFilter() {
        setColorFilter(null);
    }

    public final Rect copyBounds() {
        return new Rect(mBounds);
    }

    public final void copyBounds(Rect rect) {
        rect.set(mBounds);
    }

    public abstract void draw(Canvas canvas);

    public final Rect getBounds() {
        if(mBounds == ZERO_BOUNDS_RECT)
            mBounds = new Rect();
        return mBounds;
    }

    public Callback getCallback() {
        Callback callback;
        if(mCallback != null)
            callback = (Callback)mCallback.get();
        else
            callback = null;
        return callback;
    }

    public int getChangingConfigurations() {
        return mChangingConfigurations;
    }

    public ConstantState getConstantState() {
        return null;
    }

    public Drawable getCurrent() {
        return this;
    }

    public int getIntrinsicHeight() {
        return -1;
    }

    public int getIntrinsicWidth() {
        return -1;
    }

    public Insets getLayoutInsets() {
        return Insets.NONE;
    }

    public final int getLevel() {
        return mLevel;
    }

    public int getMinimumHeight() {
        int i = getIntrinsicHeight();
        if(i <= 0)
            i = 0;
        return i;
    }

    public int getMinimumWidth() {
        int i = getIntrinsicWidth();
        if(i <= 0)
            i = 0;
        return i;
    }

    public abstract int getOpacity();

    public boolean getPadding(Rect rect) {
        rect.set(0, 0, 0, 0);
        return false;
    }

    public int getResolvedLayoutDirectionSelf() {
        Callback callback = getCallback();
        int i;
        if(callback == null || !(callback instanceof Callback2))
            i = 0;
        else
            i = ((Callback2)callback).getResolvedLayoutDirection(this);
        return i;
    }

    public int[] getState() {
        return mStateSet;
    }

    public Region getTransparentRegion() {
        return null;
    }

    public void inflate(Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset) throws XmlPullParserException, IOException {
        TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.Drawable);
        inflateWithAttributes(resources, xmlpullparser, typedarray, 0);
        typedarray.recycle();
    }

    void inflateWithAttributes(Resources resources, XmlPullParser xmlpullparser, TypedArray typedarray, int i) throws XmlPullParserException, IOException {
        mVisible = typedarray.getBoolean(i, mVisible);
    }

    public void invalidateSelf() {
        Callback callback = getCallback();
        if(callback != null)
            callback.invalidateDrawable(this);
    }

    public boolean isStateful() {
        return false;
    }

    public final boolean isVisible() {
        return mVisible;
    }

    public void jumpToCurrentState() {
    }

    public Drawable mutate() {
        return this;
    }

    protected void onBoundsChange(Rect rect) {
    }

    protected boolean onLevelChange(int i) {
        return false;
    }

    protected boolean onStateChange(int ai[]) {
        return false;
    }

    public void scheduleSelf(Runnable runnable, long l) {
        Callback callback = getCallback();
        if(callback != null)
            callback.scheduleDrawable(this, runnable, l);
    }

    public abstract void setAlpha(int i);

    public void setBounds(int i, int j, int k, int l) {
        Rect rect = mBounds;
        if(rect == ZERO_BOUNDS_RECT) {
            rect = new Rect();
            mBounds = rect;
        }
        if(rect.left != i || rect.top != j || rect.right != k || rect.bottom != l) {
            mBounds.set(i, j, k, l);
            onBoundsChange(mBounds);
        }
    }

    public void setBounds(Rect rect) {
        setBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public final void setCallback(Callback callback) {
        mCallback = new WeakReference(callback);
    }

    public void setChangingConfigurations(int i) {
        mChangingConfigurations = i;
    }

    public void setColorFilter(int i, android.graphics.PorterDuff.Mode mode) {
        setColorFilter(((ColorFilter) (new PorterDuffColorFilter(i, mode))));
    }

    public abstract void setColorFilter(ColorFilter colorfilter);

    public void setDither(boolean flag) {
    }

    public void setFilterBitmap(boolean flag) {
    }

    public final boolean setLevel(int i) {
        boolean flag;
        if(mLevel != i) {
            mLevel = i;
            flag = onLevelChange(i);
        } else {
            flag = false;
        }
        return flag;
    }

    public boolean setState(int ai[]) {
        boolean flag;
        if(!Arrays.equals(mStateSet, ai)) {
            mStateSet = ai;
            flag = onStateChange(ai);
        } else {
            flag = false;
        }
        return flag;
    }

    public boolean setVisible(boolean flag, boolean flag1) {
        boolean flag2;
        if(mVisible != flag)
            flag2 = true;
        else
            flag2 = false;
        if(flag2) {
            mVisible = flag;
            invalidateSelf();
        }
        return flag2;
    }

    public void unscheduleSelf(Runnable runnable) {
        Callback callback = getCallback();
        if(callback != null)
            callback.unscheduleDrawable(this, runnable);
    }

    private static final Rect ZERO_BOUNDS_RECT = new Rect();
    private Rect mBounds;
    private WeakReference mCallback;
    private int mChangingConfigurations;
    private int mLevel;
    private int mStateSet[];
    private boolean mVisible;

}
