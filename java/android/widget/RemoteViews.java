// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.appwidget.AppWidgetHostView;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.*;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.*;
import android.text.TextUtils;
import android.util.Log;
import android.view.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;

// Referenced classes of package android.widget:
//            TextView, ImageView, AbsListView, AdapterViewAnimator, 
//            AdapterView

public class RemoteViews
    implements Parcelable, android.view.LayoutInflater.Filter {
    private class MemoryUsageCounter {

        public void addBitmapMemory(Bitmap bitmap) {
            android.graphics.Bitmap.Config config;
            byte byte0;
            config = bitmap.getConfig();
            byte0 = 4;
            if(config == null) goto _L2; else goto _L1
_L1:
            class _cls2 {

                static final int $SwitchMap$android$graphics$Bitmap$Config[];

                static  {
                    $SwitchMap$android$graphics$Bitmap$Config = new int[android.graphics.Bitmap.Config.values().length];
                    NoSuchFieldError nosuchfielderror3;
                    try {
                        $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.ALPHA_8.ordinal()] = 1;
                    }
                    catch(NoSuchFieldError nosuchfielderror) { }
                    try {
                        $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.RGB_565.ordinal()] = 2;
                    }
                    catch(NoSuchFieldError nosuchfielderror1) { }
                    try {
                        $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.ARGB_4444.ordinal()] = 3;
                    }
                    catch(NoSuchFieldError nosuchfielderror2) { }
                    $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.ARGB_8888.ordinal()] = 4;
_L2:
                    return;
                    nosuchfielderror3;
                    if(true) goto _L2; else goto _L1
_L1:
                }
            }

            _cls2..SwitchMap.android.graphics.Bitmap.Config[config.ordinal()];
            JVM INSTR tableswitch 1 4: default 48
        //                       1 64
        //                       2 69
        //                       3 69
        //                       4 74;
               goto _L2 _L3 _L4 _L4 _L5
_L2:
            increment(byte0 * (bitmap.getWidth() * bitmap.getHeight()));
            return;
_L3:
            byte0 = 1;
            continue; /* Loop/switch isn't completed */
_L4:
            byte0 = 2;
            continue; /* Loop/switch isn't completed */
_L5:
            byte0 = 4;
            if(true) goto _L2; else goto _L6
_L6:
        }

        public void clear() {
            mMemoryUsage = 0;
        }

        public int getMemoryUsage() {
            return mMemoryUsage;
        }

        public void increment(int i) {
            mMemoryUsage = i + mMemoryUsage;
        }

        int mMemoryUsage;
        final RemoteViews this$0;

        private MemoryUsageCounter() {
            this$0 = RemoteViews.this;
            super();
        }

    }

    private class ViewPaddingAction extends Action {

        public void apply(View view, ViewGroup viewgroup, OnClickHandler onclickhandler) {
            view.getContext();
            View view1 = view.findViewById(viewId);
            if(view1 != null)
                view1.setPadding(left, top, right, bottom);
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(14);
            parcel.writeInt(viewId);
            parcel.writeInt(left);
            parcel.writeInt(top);
            parcel.writeInt(right);
            parcel.writeInt(bottom);
        }

        public static final int TAG = 14;
        int bottom;
        int left;
        int right;
        final RemoteViews this$0;
        int top;
        int viewId;

        public ViewPaddingAction(int i, int j, int k, int l, int i1) {
            this$0 = RemoteViews.this;
            super();
            viewId = i;
            left = j;
            top = k;
            right = l;
            bottom = i1;
        }

        public ViewPaddingAction(Parcel parcel) {
            this$0 = RemoteViews.this;
            super();
            viewId = parcel.readInt();
            left = parcel.readInt();
            top = parcel.readInt();
            right = parcel.readInt();
            bottom = parcel.readInt();
        }
    }

    private class TextViewSizeAction extends Action {

        public void apply(View view, ViewGroup viewgroup, OnClickHandler onclickhandler) {
            view.getContext();
            TextView textview = (TextView)view.findViewById(viewId);
            if(textview != null)
                textview.setTextSize(units, size);
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(13);
            parcel.writeInt(viewId);
            parcel.writeInt(units);
            parcel.writeFloat(size);
        }

        public static final int TAG = 13;
        float size;
        final RemoteViews this$0;
        int units;
        int viewId;

        public TextViewSizeAction(int i, int j, float f) {
            this$0 = RemoteViews.this;
            super();
            viewId = i;
            units = j;
            size = f;
        }

        public TextViewSizeAction(Parcel parcel) {
            this$0 = RemoteViews.this;
            super();
            viewId = parcel.readInt();
            units = parcel.readInt();
            size = parcel.readFloat();
        }
    }

    private class TextViewDrawableAction extends Action {

        public void apply(View view, ViewGroup viewgroup, OnClickHandler onclickhandler) {
            view.getContext();
            TextView textview = (TextView)view.findViewById(viewId);
            if(textview != null)
                if(isRelative)
                    textview.setCompoundDrawablesRelativeWithIntrinsicBounds(d1, d2, d3, d4);
                else
                    textview.setCompoundDrawablesWithIntrinsicBounds(d1, d2, d3, d4);
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(11);
            parcel.writeInt(viewId);
            int j;
            if(isRelative)
                j = 1;
            else
                j = 0;
            parcel.writeInt(j);
            parcel.writeInt(d1);
            parcel.writeInt(d2);
            parcel.writeInt(d3);
            parcel.writeInt(d4);
        }

        public static final int TAG = 11;
        int d1;
        int d2;
        int d3;
        int d4;
        boolean isRelative;
        final RemoteViews this$0;
        int viewId;

        public TextViewDrawableAction(int i, boolean flag, int j, int k, int l, int i1) {
            this$0 = RemoteViews.this;
            super();
            isRelative = false;
            viewId = i;
            isRelative = flag;
            d1 = j;
            d2 = k;
            d3 = l;
            d4 = i1;
        }

        public TextViewDrawableAction(Parcel parcel) {
            boolean flag = false;
            this$0 = RemoteViews.this;
            super();
            isRelative = false;
            viewId = parcel.readInt();
            if(parcel.readInt() != 0)
                flag = true;
            isRelative = flag;
            d1 = parcel.readInt();
            d2 = parcel.readInt();
            d3 = parcel.readInt();
            d4 = parcel.readInt();
        }
    }

    private class ViewGroupAction extends Action {

        public void apply(View view, ViewGroup viewgroup, OnClickHandler onclickhandler) {
            Context context = view.getContext();
            ViewGroup viewgroup1 = (ViewGroup)view.findViewById(viewId);
            if(viewgroup1 != null)
                if(nestedViews != null)
                    viewgroup1.addView(nestedViews.apply(context, viewgroup1, onclickhandler));
                else
                    viewgroup1.removeAllViews();
        }

        public void setBitmapCache(BitmapCache bitmapcache) {
            if(nestedViews != null)
                nestedViews.setBitmapCache(bitmapcache);
        }

        public void updateMemoryUsageEstimate(MemoryUsageCounter memoryusagecounter) {
            if(nestedViews != null)
                memoryusagecounter.increment(nestedViews.estimateMemoryUsage());
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(4);
            parcel.writeInt(viewId);
            if(nestedViews != null) {
                parcel.writeInt(1);
                nestedViews.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }

        public static final int TAG = 4;
        RemoteViews nestedViews;
        final RemoteViews this$0;
        int viewId;

        public ViewGroupAction(int i, RemoteViews remoteviews1) {
            this$0 = RemoteViews.this;
            super();
            viewId = i;
            nestedViews = remoteviews1;
            if(remoteviews1 != null)
                configureRemoteViewsAsChild(remoteviews1);
        }

        public ViewGroupAction(Parcel parcel, BitmapCache bitmapcache) {
            this$0 = RemoteViews.this;
            super();
            viewId = parcel.readInt();
            boolean flag;
            if(parcel.readInt() == 0)
                flag = true;
            else
                flag = false;
            if(!flag)
                nestedViews = new RemoteViews(parcel, bitmapcache);
            else
                nestedViews = null;
        }
    }

    private class ReflectionAction extends Action {

        private Class getParameterType() {
            type;
            JVM INSTR tableswitch 1 14: default 76
        //                       1 80
        //                       2 87
        //                       3 94
        //                       4 101
        //                       5 108
        //                       6 115
        //                       7 122
        //                       8 129
        //                       9 136
        //                       10 142
        //                       11 148
        //                       12 154
        //                       13 160
        //                       14 166;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L1:
            Object obj = null;
_L17:
            return ((Class) (obj));
_L2:
            obj = Boolean.TYPE;
            continue; /* Loop/switch isn't completed */
_L3:
            obj = Byte.TYPE;
            continue; /* Loop/switch isn't completed */
_L4:
            obj = Short.TYPE;
            continue; /* Loop/switch isn't completed */
_L5:
            obj = Integer.TYPE;
            continue; /* Loop/switch isn't completed */
_L6:
            obj = Long.TYPE;
            continue; /* Loop/switch isn't completed */
_L7:
            obj = Float.TYPE;
            continue; /* Loop/switch isn't completed */
_L8:
            obj = Double.TYPE;
            continue; /* Loop/switch isn't completed */
_L9:
            obj = Character.TYPE;
            continue; /* Loop/switch isn't completed */
_L10:
            obj = java/lang/String;
            continue; /* Loop/switch isn't completed */
_L11:
            obj = java/lang/CharSequence;
            continue; /* Loop/switch isn't completed */
_L12:
            obj = android/net/Uri;
            continue; /* Loop/switch isn't completed */
_L13:
            obj = android/graphics/Bitmap;
            continue; /* Loop/switch isn't completed */
_L14:
            obj = android/os/Bundle;
            continue; /* Loop/switch isn't completed */
_L15:
            obj = android/content/Intent;
            if(true) goto _L17; else goto _L16
_L16:
        }

        public void apply(View view, ViewGroup viewgroup, OnClickHandler onclickhandler) {
            View view1 = view.findViewById(viewId);
            if(view1 != null) {
                Class class1 = getParameterType();
                if(class1 == null)
                    throw new ActionException((new StringBuilder()).append("bad type: ").append(type).toString());
                Class class2 = view1.getClass();
                Method method;
                try {
                    String s = methodName;
                    Class aclass[] = new Class[1];
                    aclass[0] = getParameterType();
                    method = class2.getMethod(s, aclass);
                }
                catch(NoSuchMethodException nosuchmethodexception) {
                    throw new ActionException((new StringBuilder()).append("view: ").append(class2.getName()).append(" doesn't have method: ").append(methodName).append("(").append(class1.getName()).append(")").toString());
                }
                if(!method.isAnnotationPresent(android/view/RemotableViewMethod))
                    throw new ActionException((new StringBuilder()).append("view: ").append(class2.getName()).append(" can't use method with RemoteViews: ").append(methodName).append("(").append(class1.getName()).append(")").toString());
                try {
                    Object aobj[] = new Object[1];
                    aobj[0] = value;
                    method.invoke(view1, aobj);
                }
                catch(Exception exception) {
                    throw new ActionException(exception);
                }
            }
        }

        public void updateMemoryUsageEstimate(MemoryUsageCounter memoryusagecounter) {
            type;
            JVM INSTR tableswitch 12 12: default 24
        //                       12 25;
               goto _L1 _L2
_L1:
            return;
_L2:
            if(value != null)
                memoryusagecounter.addBitmapMemory((Bitmap)value);
            if(true) goto _L1; else goto _L3
_L3:
        }

        public void writeToParcel(Parcel parcel, int i) {
            int j;
            j = 1;
            parcel.writeInt(2);
            parcel.writeInt(viewId);
            parcel.writeString(methodName);
            parcel.writeInt(type);
            type;
            JVM INSTR tableswitch 1 14: default 104
        //                       1 105
        //                       2 136
        //                       3 153
        //                       4 170
        //                       5 187
        //                       6 204
        //                       7 221
        //                       8 238
        //                       9 255
        //                       10 269
        //                       11 284
        //                       12 323
        //                       13 362
        //                       14 376;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L1:
            return;
_L2:
            int k;
            if(((Boolean)value).booleanValue())
                k = j;
            else
                k = 0;
            parcel.writeInt(k);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.writeByte(((Byte)value).byteValue());
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.writeInt(((Short)value).shortValue());
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.writeInt(((Integer)value).intValue());
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.writeLong(((Long)value).longValue());
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.writeFloat(((Float)value).floatValue());
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.writeDouble(((Double)value).doubleValue());
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.writeInt(((Character)value).charValue());
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.writeString((String)value);
            continue; /* Loop/switch isn't completed */
_L11:
            TextUtils.writeToParcel((CharSequence)value, parcel, i);
            continue; /* Loop/switch isn't completed */
_L12:
            if(value == null)
                j = 0;
            parcel.writeInt(j);
            if(value != null)
                ((Uri)value).writeToParcel(parcel, i);
            continue; /* Loop/switch isn't completed */
_L13:
            if(value == null)
                j = 0;
            parcel.writeInt(j);
            if(value != null)
                ((Bitmap)value).writeToParcel(parcel, i);
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.writeBundle((Bundle)value);
            continue; /* Loop/switch isn't completed */
_L15:
            if(value == null)
                j = 0;
            parcel.writeInt(j);
            if(value != null)
                ((Intent)value).writeToParcel(parcel, i);
            if(true) goto _L1; else goto _L16
_L16:
        }

        static final int BITMAP = 12;
        static final int BOOLEAN = 1;
        static final int BUNDLE = 13;
        static final int BYTE = 2;
        static final int CHAR = 8;
        static final int CHAR_SEQUENCE = 10;
        static final int DOUBLE = 7;
        static final int FLOAT = 6;
        static final int INT = 4;
        static final int INTENT = 14;
        static final int LONG = 5;
        static final int SHORT = 3;
        static final int STRING = 9;
        static final int TAG = 2;
        static final int URI = 11;
        String methodName;
        final RemoteViews this$0;
        int type;
        Object value;
        int viewId;

        ReflectionAction(int i, String s, int j, Object obj) {
            this$0 = RemoteViews.this;
            super();
            viewId = i;
            methodName = s;
            type = j;
            value = obj;
        }

        ReflectionAction(Parcel parcel) {
            this$0 = RemoteViews.this;
            super();
            viewId = parcel.readInt();
            methodName = parcel.readString();
            type = parcel.readInt();
            type;
            JVM INSTR tableswitch 1 14: default 108
        //                       1 109
        //                       2 134
        //                       3 148
        //                       4 163
        //                       5 177
        //                       6 191
        //                       7 205
        //                       8 219
        //                       9 234
        //                       10 245
        //                       11 261
        //                       12 284
        //                       13 307
        //                       14 318;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L1:
            return;
_L2:
            boolean flag;
            if(parcel.readInt() != 0)
                flag = true;
            else
                flag = false;
            value = Boolean.valueOf(flag);
            continue; /* Loop/switch isn't completed */
_L3:
            value = Byte.valueOf(parcel.readByte());
            continue; /* Loop/switch isn't completed */
_L4:
            value = Short.valueOf((short)parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L5:
            value = Integer.valueOf(parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L6:
            value = Long.valueOf(parcel.readLong());
            continue; /* Loop/switch isn't completed */
_L7:
            value = Float.valueOf(parcel.readFloat());
            continue; /* Loop/switch isn't completed */
_L8:
            value = Double.valueOf(parcel.readDouble());
            continue; /* Loop/switch isn't completed */
_L9:
            value = Character.valueOf((char)parcel.readInt());
            continue; /* Loop/switch isn't completed */
_L10:
            value = parcel.readString();
            continue; /* Loop/switch isn't completed */
_L11:
            value = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            continue; /* Loop/switch isn't completed */
_L12:
            if(parcel.readInt() != 0)
                value = Uri.CREATOR.createFromParcel(parcel);
            continue; /* Loop/switch isn't completed */
_L13:
            if(parcel.readInt() != 0)
                value = Bitmap.CREATOR.createFromParcel(parcel);
            continue; /* Loop/switch isn't completed */
_L14:
            value = parcel.readBundle();
            continue; /* Loop/switch isn't completed */
_L15:
            if(parcel.readInt() != 0)
                value = Intent.CREATOR.createFromParcel(parcel);
            if(true) goto _L1; else goto _L16
_L16:
        }
    }

    private class BitmapReflectionAction extends Action {

        public void apply(View view, ViewGroup viewgroup, OnClickHandler onclickhandler) throws ActionException {
            (new ReflectionAction(viewId, methodName, 12, bitmap)).apply(view, viewgroup, onclickhandler);
        }

        public void setBitmapCache(BitmapCache bitmapcache) {
            bitmapId = bitmapcache.getBitmapId(bitmap);
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(12);
            parcel.writeInt(viewId);
            parcel.writeString(methodName);
            parcel.writeInt(bitmapId);
        }

        public static final int TAG = 12;
        Bitmap bitmap;
        int bitmapId;
        String methodName;
        final RemoteViews this$0;
        int viewId;

        BitmapReflectionAction(int i, String s, Bitmap bitmap1) {
            this$0 = RemoteViews.this;
            super();
            bitmap = bitmap1;
            viewId = i;
            methodName = s;
            bitmapId = mBitmapCache.getBitmapId(bitmap1);
        }

        BitmapReflectionAction(Parcel parcel) {
            this$0 = RemoteViews.this;
            super();
            viewId = parcel.readInt();
            methodName = parcel.readString();
            bitmapId = parcel.readInt();
            bitmap = mBitmapCache.getBitmapForId(bitmapId);
        }
    }

    private static class BitmapCache {

        public void addBitmapMemory(MemoryUsageCounter memoryusagecounter) {
            for(int i = 0; i < mBitmaps.size(); i++)
                memoryusagecounter.addBitmapMemory((Bitmap)mBitmaps.get(i));

        }

        public void assimilate(BitmapCache bitmapcache) {
            ArrayList arraylist = bitmapcache.mBitmaps;
            int i = arraylist.size();
            for(int j = 0; j < i; j++) {
                Bitmap bitmap = (Bitmap)arraylist.get(j);
                if(!mBitmaps.contains(bitmap))
                    mBitmaps.add(bitmap);
            }

        }

        public Bitmap getBitmapForId(int i) {
            Bitmap bitmap;
            if(i == -1 || i >= mBitmaps.size())
                bitmap = null;
            else
                bitmap = (Bitmap)mBitmaps.get(i);
            return bitmap;
        }

        public int getBitmapId(Bitmap bitmap) {
            int i;
            if(bitmap == null)
                i = -1;
            else
            if(mBitmaps.contains(bitmap)) {
                i = mBitmaps.indexOf(bitmap);
            } else {
                mBitmaps.add(bitmap);
                i = -1 + mBitmaps.size();
            }
            return i;
        }

        public void writeBitmapsToParcel(Parcel parcel, int i) {
            int j = mBitmaps.size();
            parcel.writeInt(j);
            for(int k = 0; k < j; k++)
                ((Bitmap)mBitmaps.get(k)).writeToParcel(parcel, i);

        }

        ArrayList mBitmaps;

        public BitmapCache() {
            mBitmaps = new ArrayList();
        }

        public BitmapCache(Parcel parcel) {
            int i = parcel.readInt();
            mBitmaps = new ArrayList();
            for(int j = 0; j < i; j++) {
                Bitmap bitmap = (Bitmap)Bitmap.CREATOR.createFromParcel(parcel);
                mBitmaps.add(bitmap);
            }

        }
    }

    private class ReflectionActionWithoutParams extends Action {

        public void apply(View view, ViewGroup viewgroup, OnClickHandler onclickhandler) {
            View view1 = view.findViewById(viewId);
            if(view1 != null) {
                Class class1 = view1.getClass();
                Method method;
                try {
                    method = class1.getMethod(methodName, new Class[0]);
                }
                catch(NoSuchMethodException nosuchmethodexception) {
                    throw new ActionException((new StringBuilder()).append("view: ").append(class1.getName()).append(" doesn't have method: ").append(methodName).append("()").toString());
                }
                if(!method.isAnnotationPresent(android/view/RemotableViewMethod))
                    throw new ActionException((new StringBuilder()).append("view: ").append(class1.getName()).append(" can't use method with RemoteViews: ").append(methodName).append("()").toString());
                try {
                    method.invoke(view1, new Object[0]);
                }
                catch(Exception exception) {
                    throw new ActionException(exception);
                }
            }
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(5);
            parcel.writeInt(viewId);
            parcel.writeString(methodName);
        }

        public static final int TAG = 5;
        String methodName;
        final RemoteViews this$0;
        int viewId;

        ReflectionActionWithoutParams(int i, String s) {
            this$0 = RemoteViews.this;
            super();
            viewId = i;
            methodName = s;
        }

        ReflectionActionWithoutParams(Parcel parcel) {
            this$0 = RemoteViews.this;
            super();
            viewId = parcel.readInt();
            methodName = parcel.readString();
        }
    }

    private class SetDrawableParameters extends Action {

        public void apply(View view, ViewGroup viewgroup, OnClickHandler onclickhandler) {
            View view1 = view.findViewById(viewId);
            if(view1 != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            Drawable drawable;
            drawable = null;
            if(!targetBackground)
                break; /* Loop/switch isn't completed */
            drawable = view1.getBackground();
_L5:
            if(drawable != null) {
                if(alpha != -1)
                    drawable.setAlpha(alpha);
                if(colorFilter != -1 && filterMode != null)
                    drawable.setColorFilter(colorFilter, filterMode);
                if(level != -1)
                    drawable.setLevel(level);
            }
            if(true) goto _L1; else goto _L3
_L3:
            if(!(view1 instanceof ImageView)) goto _L5; else goto _L4
_L4:
            drawable = ((ImageView)view1).getDrawable();
              goto _L5
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(3);
            parcel.writeInt(viewId);
            int j;
            if(targetBackground)
                j = 1;
            else
                j = 0;
            parcel.writeInt(j);
            parcel.writeInt(alpha);
            parcel.writeInt(colorFilter);
            if(filterMode != null) {
                parcel.writeInt(1);
                parcel.writeString(filterMode.toString());
            } else {
                parcel.writeInt(0);
            }
            parcel.writeInt(level);
        }

        public static final int TAG = 3;
        int alpha;
        int colorFilter;
        android.graphics.PorterDuff.Mode filterMode;
        int level;
        boolean targetBackground;
        final RemoteViews this$0;
        int viewId;

        public SetDrawableParameters(int i, boolean flag, int j, int k, android.graphics.PorterDuff.Mode mode, int l) {
            this$0 = RemoteViews.this;
            super();
            viewId = i;
            targetBackground = flag;
            alpha = j;
            colorFilter = k;
            filterMode = mode;
            level = l;
        }

        public SetDrawableParameters(Parcel parcel) {
            this$0 = RemoteViews.this;
            super();
            viewId = parcel.readInt();
            boolean flag;
            boolean flag1;
            if(parcel.readInt() != 0)
                flag = true;
            else
                flag = false;
            targetBackground = flag;
            alpha = parcel.readInt();
            colorFilter = parcel.readInt();
            if(parcel.readInt() != 0)
                flag1 = true;
            else
                flag1 = false;
            if(flag1)
                filterMode = android.graphics.PorterDuff.Mode.valueOf(parcel.readString());
            else
                filterMode = null;
            level = parcel.readInt();
        }
    }

    private class SetOnClickPendingIntent extends Action {

        public void apply(View view, ViewGroup viewgroup, final OnClickHandler handler) {
            View view1 = view.findViewById(viewId);
            if(view1 != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            if(mIsWidgetCollectionChild) {
                Log.w("RemoteViews", (new StringBuilder()).append("Cannot setOnClickPendingIntent for collection item (id: ").append(viewId).append(")").toString());
                ApplicationInfo applicationinfo = view.getContext().getApplicationInfo();
                if(applicationinfo != null && applicationinfo.targetSdkVersion >= 16)
                    continue; /* Loop/switch isn't completed */
            }
            if(view1 != null) {
                android.view.View.OnClickListener onclicklistener = null;
                if(pendingIntent != null)
                    onclicklistener = new android.view.View.OnClickListener() {

                        public void onClick(View view2) {
                            float f = view2.getContext().getResources().getCompatibilityInfo().applicationScale;
                            int ai[] = new int[2];
                            view2.getLocationOnScreen(ai);
                            Rect rect = new Rect();
                            rect.left = (int)(0.5F + f * (float)ai[0]);
                            rect.top = (int)(0.5F + f * (float)ai[1]);
                            rect.right = (int)(0.5F + f * (float)(ai[0] + view2.getWidth()));
                            rect.bottom = (int)(0.5F + f * (float)(ai[1] + view2.getHeight()));
                            Intent intent = new Intent();
                            intent.setSourceBounds(rect);
                            handler.onClickHandler(view2, pendingIntent, intent);
                        }

                        final SetOnClickPendingIntent this$1;
                        final OnClickHandler val$handler;

                 {
                    this$1 = SetOnClickPendingIntent.this;
                    handler = onclickhandler;
                    super();
                }
                    };
                view1.setOnClickListener(onclicklistener);
            }
            if(true) goto _L1; else goto _L3
_L3:
        }

        public void writeToParcel(Parcel parcel, int i) {
            int j = 1;
            parcel.writeInt(j);
            parcel.writeInt(viewId);
            if(pendingIntent == null)
                j = 0;
            parcel.writeInt(j);
            if(pendingIntent != null)
                pendingIntent.writeToParcel(parcel, 0);
        }

        public static final int TAG = 1;
        PendingIntent pendingIntent;
        final RemoteViews this$0;
        int viewId;

        public SetOnClickPendingIntent(int i, PendingIntent pendingintent) {
            this$0 = RemoteViews.this;
            super();
            viewId = i;
            pendingIntent = pendingintent;
        }

        public SetOnClickPendingIntent(Parcel parcel) {
            this$0 = RemoteViews.this;
            super();
            viewId = parcel.readInt();
            if(parcel.readInt() != 0)
                pendingIntent = PendingIntent.readPendingIntentOrNullFromParcel(parcel);
        }
    }

    private class SetRemoteViewsAdapterIntent extends Action {

        public void apply(View view, ViewGroup viewgroup, OnClickHandler onclickhandler) {
            View view1 = view.findViewById(viewId);
            if(view1 != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            if(!(viewgroup instanceof AppWidgetHostView))
                Log.e("RemoteViews", (new StringBuilder()).append("SetRemoteViewsAdapterIntent action can only be used for AppWidgets (root id: ").append(viewId).append(")").toString());
            else
            if(!(view1 instanceof AbsListView) && !(view1 instanceof AdapterViewAnimator)) {
                Log.e("RemoteViews", (new StringBuilder()).append("Cannot setRemoteViewsAdapter on a view which is not an AbsListView or AdapterViewAnimator (id: ").append(viewId).append(")").toString());
            } else {
                AppWidgetHostView appwidgethostview = (AppWidgetHostView)viewgroup;
                intent.putExtra("remoteAdapterAppWidgetId", appwidgethostview.getAppWidgetId());
                if(view1 instanceof AbsListView)
                    ((AbsListView)view1).setRemoteViewsAdapter(intent);
                else
                if(view1 instanceof AdapterViewAnimator)
                    ((AdapterViewAnimator)view1).setRemoteViewsAdapter(intent);
            }
            if(true) goto _L1; else goto _L3
_L3:
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(10);
            parcel.writeInt(viewId);
            intent.writeToParcel(parcel, i);
        }

        public static final int TAG = 10;
        Intent intent;
        final RemoteViews this$0;
        int viewId;

        public SetRemoteViewsAdapterIntent(int i, Intent intent1) {
            this$0 = RemoteViews.this;
            super();
            viewId = i;
            intent = intent1;
        }

        public SetRemoteViewsAdapterIntent(Parcel parcel) {
            this$0 = RemoteViews.this;
            super();
            viewId = parcel.readInt();
            intent = (Intent)Intent.CREATOR.createFromParcel(parcel);
        }
    }

    private class SetPendingIntentTemplate extends Action {

        public void apply(View view, ViewGroup viewgroup, final OnClickHandler handler) {
            View view1 = view.findViewById(viewId);
            if(view1 != null)
                if(view1 instanceof AdapterView) {
                    AdapterView adapterview = (AdapterView)view1;
                    adapterview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        public void onItemClick(AdapterView adapterview1, View view2, int i, long l) {
                            if(!(view2 instanceof ViewGroup)) goto _L2; else goto _L1
_L1:
                            ViewGroup viewgroup1;
                            viewgroup1 = (ViewGroup)view2;
                            if(adapterview1 instanceof AdapterViewAnimator)
                                viewgroup1 = (ViewGroup)viewgroup1.getChildAt(0);
                            if(viewgroup1 != null) goto _L3; else goto _L2
_L2:
                            return;
_L3:
                            Intent intent = null;
                            int j = viewgroup1.getChildCount();
                            int k = 0;
                            do {
label0:
                                {
                                    if(k < j) {
                                        Object obj = viewgroup1.getChildAt(k).getTag(0x1020239);
                                        if(!(obj instanceof Intent))
                                            break label0;
                                        intent = (Intent)obj;
                                    }
                                    if(intent != null) {
                                        float f = view2.getContext().getResources().getCompatibilityInfo().applicationScale;
                                        int ai[] = new int[2];
                                        view2.getLocationOnScreen(ai);
                                        Rect rect = new Rect();
                                        rect.left = (int)(0.5F + f * (float)ai[0]);
                                        rect.top = (int)(0.5F + f * (float)ai[1]);
                                        rect.right = (int)(0.5F + f * (float)(ai[0] + view2.getWidth()));
                                        rect.bottom = (int)(0.5F + f * (float)(ai[1] + view2.getHeight()));
                                        (new Intent()).setSourceBounds(rect);
                                        handler.onClickHandler(view2, pendingIntentTemplate, intent);
                                    }
                                }
                                if(true)
                                    continue;
                                k++;
                            } while(true);
                            if(true) goto _L2; else goto _L4
_L4:
                        }

                        final SetPendingIntentTemplate this$1;
                        final OnClickHandler val$handler;

                 {
                    this$1 = SetPendingIntentTemplate.this;
                    handler = onclickhandler;
                    super();
                }
                    });
                    adapterview.setTag(pendingIntentTemplate);
                } else {
                    Log.e("RemoteViews", (new StringBuilder()).append("Cannot setPendingIntentTemplate on a view which is notan AdapterView (id: ").append(viewId).append(")").toString());
                }
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(8);
            parcel.writeInt(viewId);
            pendingIntentTemplate.writeToParcel(parcel, 0);
        }

        public static final int TAG = 8;
        PendingIntent pendingIntentTemplate;
        final RemoteViews this$0;
        int viewId;

        public SetPendingIntentTemplate(int i, PendingIntent pendingintent) {
            this$0 = RemoteViews.this;
            super();
            viewId = i;
            pendingIntentTemplate = pendingintent;
        }

        public SetPendingIntentTemplate(Parcel parcel) {
            this$0 = RemoteViews.this;
            super();
            viewId = parcel.readInt();
            pendingIntentTemplate = PendingIntent.readPendingIntentOrNullFromParcel(parcel);
        }
    }

    private class SetOnClickFillInIntent extends Action {

        public void apply(View view, ViewGroup viewgroup, final OnClickHandler handler) {
            View view1 = view.findViewById(viewId);
            if(view1 != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            if(!mIsWidgetCollectionChild)
                Log.e("RemoteViews", "The method setOnClickFillInIntent is available only from RemoteViewsFactory (ie. on collection items).");
            else
            if(view1 == view)
                view1.setTagInternal(0x1020239, fillInIntent);
            else
            if(view1 != null && fillInIntent != null)
                view1.setOnClickListener(new android.view.View.OnClickListener() {

                    public void onClick(View view2) {
                        View view3;
                        for(view3 = (View)view2.getParent(); !(view3 instanceof AdapterView) && !(view3 instanceof AppWidgetHostView); view3 = (View)view3.getParent());
                        if(view3 instanceof AppWidgetHostView)
                            Log.e("RemoteViews", "Collection item doesn't have AdapterView parent");
                        else
                        if(!(view3.getTag() instanceof PendingIntent)) {
                            Log.e("RemoteViews", "Attempting setOnClickFillInIntent without calling setPendingIntentTemplate on parent.");
                        } else {
                            PendingIntent pendingintent = (PendingIntent)view3.getTag();
                            float f = view2.getContext().getResources().getCompatibilityInfo().applicationScale;
                            int ai[] = new int[2];
                            view2.getLocationOnScreen(ai);
                            Rect rect = new Rect();
                            rect.left = (int)(0.5F + f * (float)ai[0]);
                            rect.top = (int)(0.5F + f * (float)ai[1]);
                            rect.right = (int)(0.5F + f * (float)(ai[0] + view2.getWidth()));
                            rect.bottom = (int)(0.5F + f * (float)(ai[1] + view2.getHeight()));
                            fillInIntent.setSourceBounds(rect);
                            handler.onClickHandler(view2, pendingintent, fillInIntent);
                        }
                    }

                    final SetOnClickFillInIntent this$1;
                    final OnClickHandler val$handler;

                 {
                    this$1 = SetOnClickFillInIntent.this;
                    handler = onclickhandler;
                    super();
                }
                });
            if(true) goto _L1; else goto _L3
_L3:
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(9);
            parcel.writeInt(viewId);
            fillInIntent.writeToParcel(parcel, 0);
        }

        public static final int TAG = 9;
        Intent fillInIntent;
        final RemoteViews this$0;
        int viewId;

        public SetOnClickFillInIntent(int i, Intent intent) {
            this$0 = RemoteViews.this;
            super();
            viewId = i;
            fillInIntent = intent;
        }

        public SetOnClickFillInIntent(Parcel parcel) {
            this$0 = RemoteViews.this;
            super();
            viewId = parcel.readInt();
            fillInIntent = (Intent)Intent.CREATOR.createFromParcel(parcel);
        }
    }

    private class SetEmptyView extends Action {

        public void apply(View view, ViewGroup viewgroup, OnClickHandler onclickhandler) {
            View view1 = view.findViewById(viewId);
            if(view1 instanceof AdapterView) goto _L2; else goto _L1
_L1:
            return;
_L2:
            AdapterView adapterview = (AdapterView)view1;
            View view2 = view.findViewById(emptyViewId);
            if(view2 != null)
                adapterview.setEmptyView(view2);
            if(true) goto _L1; else goto _L3
_L3:
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(6);
            parcel.writeInt(viewId);
            parcel.writeInt(emptyViewId);
        }

        public static final int TAG = 6;
        int emptyViewId;
        final RemoteViews this$0;
        int viewId;

        SetEmptyView(int i, int j) {
            this$0 = RemoteViews.this;
            super();
            viewId = i;
            emptyViewId = j;
        }

        SetEmptyView(Parcel parcel) {
            this$0 = RemoteViews.this;
            super();
            viewId = parcel.readInt();
            emptyViewId = parcel.readInt();
        }
    }

    private static abstract class Action
        implements Parcelable {

        public abstract void apply(View view, ViewGroup viewgroup, OnClickHandler onclickhandler) throws ActionException;

        public int describeContents() {
            return 0;
        }

        public void setBitmapCache(BitmapCache bitmapcache) {
        }

        public void updateMemoryUsageEstimate(MemoryUsageCounter memoryusagecounter) {
        }

        private Action() {
        }

    }

    public static class OnClickHandler {

        public boolean onClickHandler(View view, PendingIntent pendingintent, Intent intent) {
            Context context = view.getContext();
            ActivityOptions activityoptions = ActivityOptions.makeScaleUpAnimation(view, 0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            context.startIntentSender(pendingintent.getIntentSender(), intent, 0x10000000, 0x10000000, 0, activityoptions.toBundle());
            boolean flag = true;
_L2:
            return flag;
            android.content.IntentSender.SendIntentException sendintentexception;
            sendintentexception;
            Log.e("RemoteViews", "Cannot send pending intent: ", sendintentexception);
            flag = false;
            continue; /* Loop/switch isn't completed */
            Exception exception;
            exception;
            Log.e("RemoteViews", "Cannot send pending intent due to unknown exception: ", exception);
            flag = false;
            if(true) goto _L2; else goto _L1
_L1:
        }

        public OnClickHandler() {
        }
    }

    public static class ActionException extends RuntimeException {

        public ActionException(Exception exception) {
            super(exception);
        }

        public ActionException(String s) {
            super(s);
        }
    }

    public static interface RemoteView
        extends Annotation {
    }


    public RemoteViews(Parcel parcel) {
        this(parcel, ((BitmapCache) (null)));
    }

    private RemoteViews(Parcel parcel, BitmapCache bitmapcache) {
        int k;
        boolean flag = true;
        super();
        mIsRoot = flag;
        mLandscape = null;
        mPortrait = null;
        mIsWidgetCollectionChild = false;
        int i = parcel.readInt();
        int j;
        int l;
        if(bitmapcache == null) {
            mBitmapCache = new BitmapCache(parcel);
        } else {
            setBitmapCache(bitmapcache);
            setNotRoot();
        }
        if(i != 0)
            break MISSING_BLOCK_LABEL_513;
        mPackage = parcel.readString();
        mLayoutId = parcel.readInt();
        if(parcel.readInt() != flag)
            flag = false;
        mIsWidgetCollectionChild = flag;
        j = parcel.readInt();
        if(j <= 0)
            break MISSING_BLOCK_LABEL_567;
        mActions = new ArrayList(j);
        k = 0;
_L16:
        if(k >= j)
            break MISSING_BLOCK_LABEL_567;
        l = parcel.readInt();
        l;
        JVM INSTR tableswitch 1 14: default 196
    //                   1 246
    //                   2 289
    //                   3 269
    //                   4 309
    //                   5 333
    //                   6 353
    //                   7 196
    //                   8 373
    //                   9 393
    //                   10 413
    //                   11 433
    //                   12 493
    //                   13 453
    //                   14 473;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L1 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L12:
        break MISSING_BLOCK_LABEL_493;
_L4:
        break; /* Loop/switch isn't completed */
_L1:
        throw new ActionException((new StringBuilder()).append("Tag ").append(l).append(" not found").toString());
_L2:
        mActions.add(new SetOnClickPendingIntent(parcel));
_L17:
        k++;
        if(true) goto _L16; else goto _L15
_L15:
        mActions.add(new SetDrawableParameters(parcel));
          goto _L17
_L3:
        mActions.add(new ReflectionAction(parcel));
          goto _L17
_L5:
        mActions.add(new ViewGroupAction(parcel, mBitmapCache));
          goto _L17
_L6:
        mActions.add(new ReflectionActionWithoutParams(parcel));
          goto _L17
_L7:
        mActions.add(new SetEmptyView(parcel));
          goto _L17
_L8:
        mActions.add(new SetPendingIntentTemplate(parcel));
          goto _L17
_L9:
        mActions.add(new SetOnClickFillInIntent(parcel));
          goto _L17
_L10:
        mActions.add(new SetRemoteViewsAdapterIntent(parcel));
          goto _L17
_L11:
        mActions.add(new TextViewDrawableAction(parcel));
          goto _L17
_L13:
        mActions.add(new TextViewSizeAction(parcel));
          goto _L17
_L14:
        mActions.add(new ViewPaddingAction(parcel));
          goto _L17
        mActions.add(new BitmapReflectionAction(parcel));
          goto _L17
        mLandscape = new RemoteViews(parcel, mBitmapCache);
        mPortrait = new RemoteViews(parcel, mBitmapCache);
        mPackage = mPortrait.getPackage();
        mLayoutId = mPortrait.getLayoutId();
        mMemoryUsageCounter = new MemoryUsageCounter();
        recalculateMemoryUsage();
        return;
    }


    public RemoteViews(RemoteViews remoteviews, RemoteViews remoteviews1) {
        mIsRoot = true;
        mLandscape = null;
        mPortrait = null;
        mIsWidgetCollectionChild = false;
        if(remoteviews == null || remoteviews1 == null)
            throw new RuntimeException("Both RemoteViews must be non-null");
        if(remoteviews.getPackage().compareTo(remoteviews1.getPackage()) != 0) {
            throw new RuntimeException("Both RemoteViews must share the same package");
        } else {
            mPackage = remoteviews1.getPackage();
            mLayoutId = remoteviews1.getLayoutId();
            mLandscape = remoteviews;
            mPortrait = remoteviews1;
            mMemoryUsageCounter = new MemoryUsageCounter();
            mBitmapCache = new BitmapCache();
            configureRemoteViewsAsChild(remoteviews);
            configureRemoteViewsAsChild(remoteviews1);
            recalculateMemoryUsage();
            return;
        }
    }

    public RemoteViews(String s, int i) {
        mIsRoot = true;
        mLandscape = null;
        mPortrait = null;
        mIsWidgetCollectionChild = false;
        mPackage = s;
        mLayoutId = i;
        mBitmapCache = new BitmapCache();
        mMemoryUsageCounter = new MemoryUsageCounter();
        recalculateMemoryUsage();
    }

    private void addAction(Action action) {
        if(hasLandscapeAndPortraitLayouts())
            throw new RuntimeException("RemoteViews specifying separate landscape and portrait layouts cannot be modified. Instead, fully configure the landscape and portrait layouts individually before constructing the combined layout.");
        if(mActions == null)
            mActions = new ArrayList();
        mActions.add(action);
        action.updateMemoryUsageEstimate(mMemoryUsageCounter);
    }

    private void configureRemoteViewsAsChild(RemoteViews remoteviews) {
        mBitmapCache.assimilate(remoteviews.mBitmapCache);
        remoteviews.setBitmapCache(mBitmapCache);
        remoteviews.setNotRoot();
    }

    private RemoteViews getRemoteViewsToApply(Context context) {
        if(hasLandscapeAndPortraitLayouts())
            if(context.getResources().getConfiguration().orientation == 2)
                this = mLandscape;
            else
                this = mPortrait;
        return this;
    }

    private boolean hasLandscapeAndPortraitLayouts() {
        boolean flag;
        if(mLandscape != null && mPortrait != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private void performApply(View view, ViewGroup viewgroup, OnClickHandler onclickhandler) {
        if(mActions != null) {
            int i = mActions.size();
            for(int j = 0; j < i; j++)
                ((Action)mActions.get(j)).apply(view, viewgroup, onclickhandler);

        }
    }

    private Context prepareContext(Context context) {
        String s = mPackage;
        if(s == null) goto _L2; else goto _L1
_L1:
        Context context1;
        Context context2;
        try {
            context2 = context.createPackageContext(s, 4);
        }
        catch(android.content.pm.PackageManager.NameNotFoundException namenotfoundexception) {
            Log.e("RemoteViews", (new StringBuilder()).append("Package name ").append(s).append(" not found").toString());
            context1 = context;
            continue; /* Loop/switch isn't completed */
        }
        context1 = context2;
_L4:
        return context1;
_L2:
        context1 = context;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void recalculateMemoryUsage() {
        mMemoryUsageCounter.clear();
        if(!hasLandscapeAndPortraitLayouts()) {
            if(mActions != null) {
                int i = mActions.size();
                for(int j = 0; j < i; j++)
                    ((Action)mActions.get(j)).updateMemoryUsageEstimate(mMemoryUsageCounter);

            }
            if(mIsRoot)
                mBitmapCache.addBitmapMemory(mMemoryUsageCounter);
        } else {
            mMemoryUsageCounter.increment(mLandscape.estimateMemoryUsage());
            mMemoryUsageCounter.increment(mPortrait.estimateMemoryUsage());
            mBitmapCache.addBitmapMemory(mMemoryUsageCounter);
        }
    }

    private void setBitmapCache(BitmapCache bitmapcache) {
        mBitmapCache = bitmapcache;
        if(!hasLandscapeAndPortraitLayouts()) {
            if(mActions != null) {
                int i = mActions.size();
                for(int j = 0; j < i; j++)
                    ((Action)mActions.get(j)).setBitmapCache(bitmapcache);

            }
        } else {
            mLandscape.setBitmapCache(bitmapcache);
            mPortrait.setBitmapCache(bitmapcache);
        }
    }

    public void addView(int i, RemoteViews remoteviews) {
        addAction(new ViewGroupAction(i, remoteviews));
    }

    public View apply(Context context, ViewGroup viewgroup) {
        return apply(context, viewgroup, DEFAULT_ON_CLICK_HANDLER);
    }

    public View apply(Context context, ViewGroup viewgroup, OnClickHandler onclickhandler) {
        RemoteViews remoteviews = getRemoteViewsToApply(context);
        Context context1 = prepareContext(context);
        context1.setTheme(mDefaultTheme);
        LayoutInflater layoutinflater = ((LayoutInflater)context1.getSystemService("layout_inflater")).cloneInContext(context1);
        layoutinflater.setFilter(this);
        View view = layoutinflater.inflate(remoteviews.getLayoutId(), viewgroup, false);
        remoteviews.performApply(view, viewgroup, onclickhandler);
        return view;
    }

    public RemoteViews clone() {
        RemoteViews remoteviews;
        if(!hasLandscapeAndPortraitLayouts()) {
            remoteviews = new RemoteViews(mPackage, mLayoutId);
            if(mActions != null)
                remoteviews.mActions = (ArrayList)mActions.clone();
        } else {
            remoteviews = new RemoteViews(mLandscape.clone(), mPortrait.clone());
        }
        remoteviews.recalculateMemoryUsage();
        return remoteviews;
    }

    public volatile Object clone() throws CloneNotSupportedException {
        return clone();
    }

    public int describeContents() {
        return 0;
    }

    public int estimateMemoryUsage() {
        return mMemoryUsageCounter.getMemoryUsage();
    }

    public int getLayoutId() {
        return mLayoutId;
    }

    public String getPackage() {
        return mPackage;
    }

    public boolean onLoadClass(Class class1) {
        return class1.isAnnotationPresent(android/widget/RemoteViews$RemoteView);
    }

    public void reapply(Context context, View view) {
        reapply(context, view, DEFAULT_ON_CLICK_HANDLER);
    }

    public void reapply(Context context, View view, OnClickHandler onclickhandler) {
        RemoteViews remoteviews = getRemoteViewsToApply(context);
        if(hasLandscapeAndPortraitLayouts() && view.getId() != remoteviews.getLayoutId()) {
            throw new RuntimeException("Attempting to re-apply RemoteViews to a view that that does not share the same root layout id.");
        } else {
            prepareContext(context);
            remoteviews.performApply(view, (ViewGroup)view.getParent(), onclickhandler);
            return;
        }
    }

    public void removeAllViews(int i) {
        addAction(new ViewGroupAction(i, null));
    }

    public void setBitmap(int i, String s, Bitmap bitmap) {
        addAction(new BitmapReflectionAction(i, s, bitmap));
    }

    public void setBoolean(int i, String s, boolean flag) {
        addAction(new ReflectionAction(i, s, 1, Boolean.valueOf(flag)));
    }

    public void setBundle(int i, String s, Bundle bundle) {
        addAction(new ReflectionAction(i, s, 13, bundle));
    }

    public void setByte(int i, String s, byte byte0) {
        addAction(new ReflectionAction(i, s, 2, Byte.valueOf(byte0)));
    }

    public void setChar(int i, String s, char c) {
        addAction(new ReflectionAction(i, s, 8, Character.valueOf(c)));
    }

    public void setCharSequence(int i, String s, CharSequence charsequence) {
        addAction(new ReflectionAction(i, s, 10, charsequence));
    }

    public void setChronometer(int i, long l, String s, boolean flag) {
        setLong(i, "setBase", l);
        setString(i, "setFormat", s);
        setBoolean(i, "setStarted", flag);
    }

    public void setContentDescription(int i, CharSequence charsequence) {
        setCharSequence(i, "setContentDescription", charsequence);
    }

    public void setDefaultTheme(int i) {
        mDefaultTheme = i;
    }

    public void setDisplayedChild(int i, int j) {
        setInt(i, "setDisplayedChild", j);
    }

    public void setDouble(int i, String s, double d) {
        addAction(new ReflectionAction(i, s, 7, Double.valueOf(d)));
    }

    public void setDrawableParameters(int i, boolean flag, int j, int k, android.graphics.PorterDuff.Mode mode, int l) {
        addAction(new SetDrawableParameters(i, flag, j, k, mode, l));
    }

    public void setEmptyView(int i, int j) {
        addAction(new SetEmptyView(i, j));
    }

    public void setFloat(int i, String s, float f) {
        addAction(new ReflectionAction(i, s, 6, Float.valueOf(f)));
    }

    public void setImageViewBitmap(int i, Bitmap bitmap) {
        setBitmap(i, "setImageBitmap", bitmap);
    }

    public void setImageViewResource(int i, int j) {
        setInt(i, "setImageResource", j);
    }

    public void setImageViewUri(int i, Uri uri) {
        setUri(i, "setImageURI", uri);
    }

    public void setInt(int i, String s, int j) {
        addAction(new ReflectionAction(i, s, 4, Integer.valueOf(j)));
    }

    public void setIntent(int i, String s, Intent intent) {
        addAction(new ReflectionAction(i, s, 14, intent));
    }

    void setIsWidgetCollectionChild(boolean flag) {
        mIsWidgetCollectionChild = flag;
    }

    public void setLong(int i, String s, long l) {
        addAction(new ReflectionAction(i, s, 5, Long.valueOf(l)));
    }

    void setNotRoot() {
        mIsRoot = false;
    }

    public void setOnClickFillInIntent(int i, Intent intent) {
        addAction(new SetOnClickFillInIntent(i, intent));
    }

    public void setOnClickPendingIntent(int i, PendingIntent pendingintent) {
        addAction(new SetOnClickPendingIntent(i, pendingintent));
    }

    public void setPendingIntentTemplate(int i, PendingIntent pendingintent) {
        addAction(new SetPendingIntentTemplate(i, pendingintent));
    }

    public void setProgressBar(int i, int j, int k, boolean flag) {
        setBoolean(i, "setIndeterminate", flag);
        if(!flag) {
            setInt(i, "setMax", j);
            setInt(i, "setProgress", k);
        }
    }

    public void setRelativeScrollPosition(int i, int j) {
        setInt(i, "smoothScrollByOffset", j);
    }

    public void setRemoteAdapter(int i, int j, Intent intent) {
        setRemoteAdapter(j, intent);
    }

    public void setRemoteAdapter(int i, Intent intent) {
        addAction(new SetRemoteViewsAdapterIntent(i, intent));
    }

    public void setScrollPosition(int i, int j) {
        setInt(i, "smoothScrollToPosition", j);
    }

    public void setShort(int i, String s, short word0) {
        addAction(new ReflectionAction(i, s, 3, Short.valueOf(word0)));
    }

    public void setString(int i, String s, String s1) {
        addAction(new ReflectionAction(i, s, 9, s1));
    }

    public void setTextColor(int i, int j) {
        setInt(i, "setTextColor", j);
    }

    public void setTextViewCompoundDrawables(int i, int j, int k, int l, int i1) {
        addAction(new TextViewDrawableAction(i, false, j, k, l, i1));
    }

    public void setTextViewCompoundDrawablesRelative(int i, int j, int k, int l, int i1) {
        addAction(new TextViewDrawableAction(i, true, j, k, l, i1));
    }

    public void setTextViewText(int i, CharSequence charsequence) {
        setCharSequence(i, "setText", charsequence);
    }

    public void setTextViewTextSize(int i, int j, float f) {
        addAction(new TextViewSizeAction(i, j, f));
    }

    public void setUri(int i, String s, Uri uri) {
        addAction(new ReflectionAction(i, s, 11, uri));
    }

    public void setViewPadding(int i, int j, int k, int l, int i1) {
        addAction(new ViewPaddingAction(i, j, k, l, i1));
    }

    public void setViewVisibility(int i, int j) {
        setInt(i, "setVisibility", j);
    }

    public void showNext(int i) {
        addAction(new ReflectionActionWithoutParams(i, "showNext"));
    }

    public void showPrevious(int i) {
        addAction(new ReflectionActionWithoutParams(i, "showPrevious"));
    }

    public void writeToParcel(Parcel parcel, int i) {
        int j = 1;
        if(!hasLandscapeAndPortraitLayouts()) {
            parcel.writeInt(0);
            if(mIsRoot)
                mBitmapCache.writeBitmapsToParcel(parcel, i);
            parcel.writeString(mPackage);
            parcel.writeInt(mLayoutId);
            int k;
            if(!mIsWidgetCollectionChild)
                j = 0;
            parcel.writeInt(j);
            if(mActions != null)
                k = mActions.size();
            else
                k = 0;
            parcel.writeInt(k);
            for(int l = 0; l < k; l++)
                ((Action)mActions.get(l)).writeToParcel(parcel, 0);

        } else {
            parcel.writeInt(j);
            if(mIsRoot)
                mBitmapCache.writeBitmapsToParcel(parcel, i);
            mLandscape.writeToParcel(parcel, i);
            mPortrait.writeToParcel(parcel, i);
        }
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public RemoteViews createFromParcel(Parcel parcel) {
            return new RemoteViews(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public RemoteViews[] newArray(int i) {
            return new RemoteViews[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final OnClickHandler DEFAULT_ON_CLICK_HANDLER = new OnClickHandler();
    static final String EXTRA_REMOTEADAPTER_APPWIDGET_ID = "remoteAdapterAppWidgetId";
    private static final String LOG_TAG = "RemoteViews";
    private static final int MODE_HAS_LANDSCAPE_AND_PORTRAIT = 1;
    private static final int MODE_NORMAL;
    private ArrayList mActions;
    private BitmapCache mBitmapCache;
    int mDefaultTheme;
    private boolean mIsRoot;
    private boolean mIsWidgetCollectionChild;
    private RemoteViews mLandscape;
    private final int mLayoutId;
    private MemoryUsageCounter mMemoryUsageCounter;
    private final String mPackage;
    private RemoteViews mPortrait;





}
