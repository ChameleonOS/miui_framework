// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.os.*;
import android.text.TextUtils;
import android.util.Log;

// Referenced classes of package android.view:
//            ViewManager, Display, View

public interface WindowManager
    extends ViewManager {
    public static class LayoutParams extends ViewGroup.LayoutParams
        implements Parcelable {

        public static boolean mayUseInputMethod(int i) {
            0x20008 & i;
            JVM INSTR lookupswitch 2: default 32
        //                       0: 36
        //                       131080: 36;
               goto _L1 _L2 _L2
_L1:
            boolean flag = false;
_L4:
            return flag;
_L2:
            flag = true;
            if(true) goto _L4; else goto _L3
_L3:
        }

        void backup() {
            int ai[] = mCompatibilityParamsBackup;
            if(ai == null) {
                ai = new int[4];
                mCompatibilityParamsBackup = ai;
            }
            ai[0] = x;
            ai[1] = y;
            ai[2] = super.width;
            ai[3] = super.height;
        }

        public final int copyFrom(LayoutParams layoutparams) {
            int i = 0;
            if(super.width != ((ViewGroup.LayoutParams) (layoutparams)).width) {
                super.width = ((ViewGroup.LayoutParams) (layoutparams)).width;
                i = false | true;
            }
            if(super.height != ((ViewGroup.LayoutParams) (layoutparams)).height) {
                super.height = ((ViewGroup.LayoutParams) (layoutparams)).height;
                i |= 1;
            }
            if(x != layoutparams.x) {
                x = layoutparams.x;
                i |= 1;
            }
            if(y != layoutparams.y) {
                y = layoutparams.y;
                i |= 1;
            }
            if(horizontalWeight != layoutparams.horizontalWeight) {
                horizontalWeight = layoutparams.horizontalWeight;
                i |= 1;
            }
            if(verticalWeight != layoutparams.verticalWeight) {
                verticalWeight = layoutparams.verticalWeight;
                i |= 1;
            }
            if(horizontalMargin != layoutparams.horizontalMargin) {
                horizontalMargin = layoutparams.horizontalMargin;
                i |= 1;
            }
            if(verticalMargin != layoutparams.verticalMargin) {
                verticalMargin = layoutparams.verticalMargin;
                i |= 1;
            }
            if(type != layoutparams.type) {
                type = layoutparams.type;
                i |= 2;
            }
            if(flags != layoutparams.flags) {
                flags = layoutparams.flags;
                i |= 4;
            }
            if(privateFlags != layoutparams.privateFlags) {
                privateFlags = layoutparams.privateFlags;
                i |= 0x10000;
            }
            if(softInputMode != layoutparams.softInputMode) {
                softInputMode = layoutparams.softInputMode;
                i |= 0x200;
            }
            if(gravity != layoutparams.gravity) {
                gravity = layoutparams.gravity;
                i |= 1;
            }
            if(format != layoutparams.format) {
                format = layoutparams.format;
                i |= 8;
            }
            if(windowAnimations != layoutparams.windowAnimations) {
                windowAnimations = layoutparams.windowAnimations;
                i |= 0x10;
            }
            if(token == null)
                token = layoutparams.token;
            if(packageName == null)
                packageName = layoutparams.packageName;
            if(!mTitle.equals(layoutparams.mTitle)) {
                mTitle = layoutparams.mTitle;
                i |= 0x40;
            }
            if(alpha != layoutparams.alpha) {
                alpha = layoutparams.alpha;
                i |= 0x80;
            }
            if(dimAmount != layoutparams.dimAmount) {
                dimAmount = layoutparams.dimAmount;
                i |= 0x20;
            }
            if(screenBrightness != layoutparams.screenBrightness) {
                screenBrightness = layoutparams.screenBrightness;
                i |= 0x800;
            }
            if(buttonBrightness != layoutparams.buttonBrightness) {
                buttonBrightness = layoutparams.buttonBrightness;
                i |= 0x1000;
            }
            if(screenOrientation != layoutparams.screenOrientation) {
                screenOrientation = layoutparams.screenOrientation;
                i |= 0x400;
            }
            if(systemUiVisibility != layoutparams.systemUiVisibility || subtreeSystemUiVisibility != layoutparams.subtreeSystemUiVisibility) {
                systemUiVisibility = layoutparams.systemUiVisibility;
                subtreeSystemUiVisibility = layoutparams.subtreeSystemUiVisibility;
                i |= 0x2000;
            }
            if(hasSystemUiListeners != layoutparams.hasSystemUiListeners) {
                hasSystemUiListeners = layoutparams.hasSystemUiListeners;
                i |= 0x4000;
            }
            if(inputFeatures != layoutparams.inputFeatures) {
                inputFeatures = layoutparams.inputFeatures;
                i |= 0x8000;
            }
            return i;
        }

        public String debug(String s) {
            Log.d("Debug", (new StringBuilder()).append(s).append("Contents of ").append(this).append(":").toString());
            Log.d("Debug", super.debug(""));
            Log.d("Debug", "");
            Log.d("Debug", (new StringBuilder()).append("WindowManager.LayoutParams={title=").append(mTitle).append("}").toString());
            return "";
        }

        public int describeContents() {
            return 0;
        }

        public final CharSequence getTitle() {
            return mTitle;
        }

        void restore() {
            int ai[] = mCompatibilityParamsBackup;
            if(ai != null) {
                x = ai[0];
                y = ai[1];
                super.width = ai[2];
                super.height = ai[3];
            }
        }

        public void scale(float f) {
            x = (int)(0.5F + f * (float)x);
            y = (int)(0.5F + f * (float)y);
            if(super.width > 0)
                super.width = (int)(0.5F + f * (float)super.width);
            if(super.height > 0)
                super.height = (int)(0.5F + f * (float)super.height);
        }

        public final void setTitle(CharSequence charsequence) {
            if(charsequence == null)
                charsequence = "";
            mTitle = TextUtils.stringOrSpannedString(charsequence);
        }

        public String toString() {
            StringBuilder stringbuilder = new StringBuilder(256);
            stringbuilder.append("WM.LayoutParams{");
            stringbuilder.append("(");
            stringbuilder.append(x);
            stringbuilder.append(',');
            stringbuilder.append(y);
            stringbuilder.append(")(");
            Object obj;
            Object obj1;
            if(super.width == -1)
                obj = "fill";
            else
            if(super.width == -2)
                obj = "wrap";
            else
                obj = Integer.valueOf(super.width);
            stringbuilder.append(obj);
            stringbuilder.append('x');
            if(super.height == -1)
                obj1 = "fill";
            else
            if(super.height == -2)
                obj1 = "wrap";
            else
                obj1 = Integer.valueOf(super.height);
            stringbuilder.append(obj1);
            stringbuilder.append(")");
            if(horizontalMargin != 0.0F) {
                stringbuilder.append(" hm=");
                stringbuilder.append(horizontalMargin);
            }
            if(verticalMargin != 0.0F) {
                stringbuilder.append(" vm=");
                stringbuilder.append(verticalMargin);
            }
            if(gravity != 0) {
                stringbuilder.append(" gr=#");
                stringbuilder.append(Integer.toHexString(gravity));
            }
            if(softInputMode != 0) {
                stringbuilder.append(" sim=#");
                stringbuilder.append(Integer.toHexString(softInputMode));
            }
            stringbuilder.append(" ty=");
            stringbuilder.append(type);
            stringbuilder.append(" fl=#");
            stringbuilder.append(Integer.toHexString(flags));
            if(privateFlags != 0)
                stringbuilder.append(" pfl=0x").append(Integer.toHexString(privateFlags));
            if(format != -1) {
                stringbuilder.append(" fmt=");
                stringbuilder.append(format);
            }
            if(windowAnimations != 0) {
                stringbuilder.append(" wanim=0x");
                stringbuilder.append(Integer.toHexString(windowAnimations));
            }
            if(screenOrientation != -1) {
                stringbuilder.append(" or=");
                stringbuilder.append(screenOrientation);
            }
            if(alpha != 1.0F) {
                stringbuilder.append(" alpha=");
                stringbuilder.append(alpha);
            }
            if(screenBrightness != -1F) {
                stringbuilder.append(" sbrt=");
                stringbuilder.append(screenBrightness);
            }
            if(buttonBrightness != -1F) {
                stringbuilder.append(" bbrt=");
                stringbuilder.append(buttonBrightness);
            }
            if((0x20000000 & flags) != 0)
                stringbuilder.append(" compatible=true");
            if(systemUiVisibility != 0) {
                stringbuilder.append(" sysui=0x");
                stringbuilder.append(Integer.toHexString(systemUiVisibility));
            }
            if(subtreeSystemUiVisibility != 0) {
                stringbuilder.append(" vsysui=0x");
                stringbuilder.append(Integer.toHexString(subtreeSystemUiVisibility));
            }
            if(hasSystemUiListeners) {
                stringbuilder.append(" sysuil=");
                stringbuilder.append(hasSystemUiListeners);
            }
            if(inputFeatures != 0)
                stringbuilder.append(" if=0x").append(Integer.toHexString(inputFeatures));
            stringbuilder.append('}');
            return stringbuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(super.width);
            parcel.writeInt(super.height);
            parcel.writeInt(x);
            parcel.writeInt(y);
            parcel.writeInt(type);
            parcel.writeInt(flags);
            parcel.writeInt(privateFlags);
            parcel.writeInt(softInputMode);
            parcel.writeInt(gravity);
            parcel.writeFloat(horizontalMargin);
            parcel.writeFloat(verticalMargin);
            parcel.writeInt(format);
            parcel.writeInt(windowAnimations);
            parcel.writeFloat(alpha);
            parcel.writeFloat(dimAmount);
            parcel.writeFloat(screenBrightness);
            parcel.writeFloat(buttonBrightness);
            parcel.writeStrongBinder(token);
            parcel.writeString(packageName);
            TextUtils.writeToParcel(mTitle, parcel, i);
            parcel.writeInt(screenOrientation);
            parcel.writeInt(systemUiVisibility);
            parcel.writeInt(subtreeSystemUiVisibility);
            int j;
            if(hasSystemUiListeners)
                j = 1;
            else
                j = 0;
            parcel.writeInt(j);
            parcel.writeInt(inputFeatures);
        }

        public static final int ALPHA_CHANGED = 128;
        public static final int ANIMATION_CHANGED = 16;
        public static final float BRIGHTNESS_OVERRIDE_FULL = 1F;
        public static final float BRIGHTNESS_OVERRIDE_NONE = -1F;
        public static final float BRIGHTNESS_OVERRIDE_OFF = 0F;
        public static final int BUTTON_BRIGHTNESS_CHANGED = 4096;
        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public LayoutParams[] newArray(int i) {
                return new LayoutParams[i];
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

        };
        public static final int DIM_AMOUNT_CHANGED = 32;
        public static final int EVERYTHING_CHANGED = -1;
        public static final int FIRST_APPLICATION_WINDOW = 1;
        public static final int FIRST_SUB_WINDOW = 1000;
        public static final int FIRST_SYSTEM_WINDOW = 2000;
        public static final int FLAGS_CHANGED = 4;
        public static final int FLAG_ALLOW_LOCK_WHILE_SCREEN_ON = 1;
        public static final int FLAG_ALT_FOCUSABLE_IM = 0x20000;
        public static final int FLAG_BLUR_BEHIND = 4;
        public static final int FLAG_COMPATIBLE_WINDOW = 0x20000000;
        public static final int FLAG_DIM_BEHIND = 2;
        public static final int FLAG_DISMISS_KEYGUARD = 0x400000;
        public static final int FLAG_DITHER = 4096;
        public static final int FLAG_FORCE_NOT_FULLSCREEN = 2048;
        public static final int FLAG_FULLSCREEN = 1024;
        public static final int FLAG_HARDWARE_ACCELERATED = 0x1000000;
        public static final int FLAG_IGNORE_CHEEK_PRESSES = 32768;
        public static final int FLAG_KEEP_SCREEN_ON = 128;
        public static final int FLAG_LAYOUT_INSET_DECOR = 0x10000;
        public static final int FLAG_LAYOUT_IN_SCREEN = 256;
        public static final int FLAG_LAYOUT_NO_LIMITS = 512;
        public static final int FLAG_NEEDS_MENU_KEY = 0x8000000;
        public static final int FLAG_NOT_FOCUSABLE = 8;
        public static final int FLAG_NOT_TOUCHABLE = 16;
        public static final int FLAG_NOT_TOUCH_MODAL = 32;
        public static final int FLAG_SCALED = 16384;
        public static final int FLAG_SECURE = 8192;
        public static final int FLAG_SHOW_WALLPAPER = 0x100000;
        public static final int FLAG_SHOW_WHEN_LOCKED = 0x80000;
        public static final int FLAG_SLIPPERY = 0x4000000;
        public static final int FLAG_SPLIT_TOUCH = 0x800000;
        public static final int FLAG_SYSTEM_ERROR = 0x40000000;
        public static final int FLAG_TOUCHABLE_WHEN_WAKING = 64;
        public static final int FLAG_TURN_SCREEN_ON = 0x200000;
        public static final int FLAG_WATCH_OUTSIDE_TOUCH = 0x40000;
        public static final int FORMAT_CHANGED = 8;
        public static final int INPUT_FEATURES_CHANGED = 32768;
        public static final int INPUT_FEATURE_DISABLE_POINTER_GESTURES = 1;
        public static final int INPUT_FEATURE_NO_INPUT_CHANNEL = 2;
        public static final int LAST_APPLICATION_WINDOW = 99;
        public static final int LAST_SUB_WINDOW = 1999;
        public static final int LAST_SYSTEM_WINDOW = 2999;
        public static final int LAYOUT_CHANGED = 1;
        public static final int MEMORY_TYPE_CHANGED = 256;
        public static final int MEMORY_TYPE_GPU = 2;
        public static final int MEMORY_TYPE_HARDWARE = 1;
        public static final int MEMORY_TYPE_NORMAL = 0;
        public static final int MEMORY_TYPE_PUSH_BUFFERS = 3;
        public static final int PRIVATE_FLAGS_CHANGED = 0x10000;
        public static final int PRIVATE_FLAG_FAKE_HARDWARE_ACCELERATED = 1;
        public static final int PRIVATE_FLAG_FORCE_HARDWARE_ACCELERATED = 2;
        public static final int PRIVATE_FLAG_SET_NEEDS_MENU_KEY = 8;
        public static final int PRIVATE_FLAG_WANTS_OFFSET_NOTIFICATIONS = 4;
        public static final int SCREEN_BRIGHTNESS_CHANGED = 2048;
        public static final int SCREEN_ORIENTATION_CHANGED = 1024;
        public static final int SOFT_INPUT_ADJUST_NOTHING = 48;
        public static final int SOFT_INPUT_ADJUST_PAN = 32;
        public static final int SOFT_INPUT_ADJUST_RESIZE = 16;
        public static final int SOFT_INPUT_ADJUST_UNSPECIFIED = 0;
        public static final int SOFT_INPUT_IS_FORWARD_NAVIGATION = 256;
        public static final int SOFT_INPUT_MASK_ADJUST = 240;
        public static final int SOFT_INPUT_MASK_STATE = 15;
        public static final int SOFT_INPUT_MODE_CHANGED = 512;
        public static final int SOFT_INPUT_STATE_ALWAYS_HIDDEN = 3;
        public static final int SOFT_INPUT_STATE_ALWAYS_VISIBLE = 5;
        public static final int SOFT_INPUT_STATE_HIDDEN = 2;
        public static final int SOFT_INPUT_STATE_UNCHANGED = 1;
        public static final int SOFT_INPUT_STATE_UNSPECIFIED = 0;
        public static final int SOFT_INPUT_STATE_VISIBLE = 4;
        public static final int SYSTEM_UI_LISTENER_CHANGED = 16384;
        public static final int SYSTEM_UI_VISIBILITY_CHANGED = 8192;
        public static final int TITLE_CHANGED = 64;
        public static final int TYPE_APPLICATION = 2;
        public static final int TYPE_APPLICATION_ATTACHED_DIALOG = 1003;
        public static final int TYPE_APPLICATION_MEDIA = 1001;
        public static final int TYPE_APPLICATION_MEDIA_OVERLAY = 1004;
        public static final int TYPE_APPLICATION_PANEL = 1000;
        public static final int TYPE_APPLICATION_STARTING = 3;
        public static final int TYPE_APPLICATION_SUB_PANEL = 1002;
        public static final int TYPE_BASE_APPLICATION = 1;
        public static final int TYPE_BOOT_PROGRESS = 2021;
        public static final int TYPE_CHANGED = 2;
        public static final int TYPE_DRAG = 2016;
        public static final int TYPE_DREAM = 2023;
        public static final int TYPE_HIDDEN_NAV_CONSUMER = 2022;
        public static final int TYPE_INPUT_METHOD = 2011;
        public static final int TYPE_INPUT_METHOD_DIALOG = 2012;
        public static final int TYPE_KEYGUARD = 2004;
        public static final int TYPE_KEYGUARD_DIALOG = 2009;
        public static final int TYPE_NAVIGATION_BAR = 2019;
        public static final int TYPE_NAVIGATION_BAR_PANEL = 2024;
        public static final int TYPE_PHONE = 2002;
        public static final int TYPE_POINTER = 2018;
        public static final int TYPE_PRIORITY_PHONE = 2007;
        public static final int TYPE_SEARCH_BAR = 2001;
        public static final int TYPE_SECURE_SYSTEM_OVERLAY = 2015;
        public static final int TYPE_STATUS_BAR = 2000;
        public static final int TYPE_STATUS_BAR_PANEL = 2014;
        public static final int TYPE_STATUS_BAR_SUB_PANEL = 2017;
        public static final int TYPE_SYSTEM_ALERT = 2003;
        public static final int TYPE_SYSTEM_DIALOG = 2008;
        public static final int TYPE_SYSTEM_ERROR = 2010;
        public static final int TYPE_SYSTEM_OVERLAY = 2006;
        public static final int TYPE_TOAST = 2005;
        public static final int TYPE_VOLUME_OVERLAY = 2020;
        public static final int TYPE_WALLPAPER = 2013;
        public float alpha;
        public float buttonBrightness;
        public float dimAmount;
        public int flags;
        public int format;
        public int gravity;
        public boolean hasSystemUiListeners;
        public float horizontalMargin;
        public float horizontalWeight;
        public int inputFeatures;
        private int mCompatibilityParamsBackup[];
        private CharSequence mTitle;
        public int memoryType;
        public String packageName;
        public int privateFlags;
        public float screenBrightness;
        public int screenOrientation;
        public int softInputMode;
        public int subtreeSystemUiVisibility;
        public int systemUiVisibility;
        public IBinder token;
        public int type;
        public float verticalMargin;
        public float verticalWeight;
        public int windowAnimations;
        public int x;
        public int y;


        public LayoutParams() {
            super(-1, -1);
            alpha = 1.0F;
            dimAmount = 1.0F;
            screenBrightness = -1F;
            buttonBrightness = -1F;
            token = null;
            packageName = null;
            screenOrientation = -1;
            mCompatibilityParamsBackup = null;
            mTitle = "";
            type = 2;
            format = -1;
        }

        public LayoutParams(int i) {
            super(-1, -1);
            alpha = 1.0F;
            dimAmount = 1.0F;
            screenBrightness = -1F;
            buttonBrightness = -1F;
            token = null;
            packageName = null;
            screenOrientation = -1;
            mCompatibilityParamsBackup = null;
            mTitle = "";
            type = i;
            format = -1;
        }

        public LayoutParams(int i, int j) {
            super(-1, -1);
            alpha = 1.0F;
            dimAmount = 1.0F;
            screenBrightness = -1F;
            buttonBrightness = -1F;
            token = null;
            packageName = null;
            screenOrientation = -1;
            mCompatibilityParamsBackup = null;
            mTitle = "";
            type = i;
            flags = j;
            format = -1;
        }

        public LayoutParams(int i, int j, int k) {
            super(-1, -1);
            alpha = 1.0F;
            dimAmount = 1.0F;
            screenBrightness = -1F;
            buttonBrightness = -1F;
            token = null;
            packageName = null;
            screenOrientation = -1;
            mCompatibilityParamsBackup = null;
            mTitle = "";
            type = i;
            flags = j;
            format = k;
        }

        public LayoutParams(int i, int j, int k, int l, int i1) {
            super(i, j);
            alpha = 1.0F;
            dimAmount = 1.0F;
            screenBrightness = -1F;
            buttonBrightness = -1F;
            token = null;
            packageName = null;
            screenOrientation = -1;
            mCompatibilityParamsBackup = null;
            mTitle = "";
            type = k;
            flags = l;
            format = i1;
        }

        public LayoutParams(int i, int j, int k, int l, int i1, int j1, int k1) {
            super(i, j);
            alpha = 1.0F;
            dimAmount = 1.0F;
            screenBrightness = -1F;
            buttonBrightness = -1F;
            token = null;
            packageName = null;
            screenOrientation = -1;
            mCompatibilityParamsBackup = null;
            mTitle = "";
            x = k;
            y = l;
            type = i1;
            flags = j1;
            format = k1;
        }

        public LayoutParams(Parcel parcel) {
            alpha = 1.0F;
            dimAmount = 1.0F;
            screenBrightness = -1F;
            buttonBrightness = -1F;
            token = null;
            packageName = null;
            screenOrientation = -1;
            mCompatibilityParamsBackup = null;
            mTitle = "";
            super.width = parcel.readInt();
            super.height = parcel.readInt();
            x = parcel.readInt();
            y = parcel.readInt();
            type = parcel.readInt();
            flags = parcel.readInt();
            privateFlags = parcel.readInt();
            softInputMode = parcel.readInt();
            gravity = parcel.readInt();
            horizontalMargin = parcel.readFloat();
            verticalMargin = parcel.readFloat();
            format = parcel.readInt();
            windowAnimations = parcel.readInt();
            alpha = parcel.readFloat();
            dimAmount = parcel.readFloat();
            screenBrightness = parcel.readFloat();
            buttonBrightness = parcel.readFloat();
            token = parcel.readStrongBinder();
            packageName = parcel.readString();
            mTitle = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            screenOrientation = parcel.readInt();
            systemUiVisibility = parcel.readInt();
            subtreeSystemUiVisibility = parcel.readInt();
            boolean flag;
            if(parcel.readInt() != 0)
                flag = true;
            else
                flag = false;
            hasSystemUiListeners = flag;
            inputFeatures = parcel.readInt();
        }
    }

    public static class BadTokenException extends RuntimeException {

        public BadTokenException() {
        }

        public BadTokenException(String s) {
            super(s);
        }
    }


    public abstract Display getDefaultDisplay();

    public abstract boolean isHardwareAccelerated();

    public abstract void removeViewImmediate(View view);
}
