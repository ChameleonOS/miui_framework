// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.*;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.IWindowSession;
import android.view.ViewRootImpl;
import java.io.*;

// Referenced classes of package android.app:
//            IWallpaperManager, WallpaperInfo

public class WallpaperManager {
    static class Globals extends IWallpaperManagerCallback.Stub {

        private Bitmap getCurrentWallpaperLocked() {
            Bundle bundle;
            ParcelFileDescriptor parcelfiledescriptor;
            bundle = new Bundle();
            parcelfiledescriptor = mService.getWallpaper(this, bundle);
            if(parcelfiledescriptor == null) goto _L2; else goto _L1
_L1:
            int i;
            int j;
            i = bundle.getInt("width", 0);
            j = bundle.getInt("height", 0);
            Bitmap bitmap1;
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            bitmap1 = WallpaperManager.generateBitmap(BitmapFactory.decodeFileDescriptor(parcelfiledescriptor.getFileDescriptor(), null, options), i, j);
            Bitmap bitmap = bitmap1;
            parcelfiledescriptor.close();
_L4:
            return bitmap;
            OutOfMemoryError outofmemoryerror;
            outofmemoryerror;
            Log.w(WallpaperManager.TAG, "Can't decode file", outofmemoryerror);
            Exception exception;
            try {
                parcelfiledescriptor.close();
            }
            catch(IOException ioexception1) { }
            catch(RemoteException remoteexception) { }
_L2:
            bitmap = null;
            continue; /* Loop/switch isn't completed */
            exception;
            try {
                parcelfiledescriptor.close();
            }
            catch(IOException ioexception) { }
            throw exception;
            IOException ioexception2;
            ioexception2;
            if(true) goto _L4; else goto _L3
_L3:
        }

        private Bitmap getDefaultWallpaperLocked(Context context) {
            InputStream inputstream = context.getResources().openRawResource(0x1080220);
            if(inputstream == null) goto _L2; else goto _L1
_L1:
            int i;
            int j;
            i = mService.getWidthHint();
            j = mService.getHeightHint();
            Bitmap bitmap1 = WallpaperManager.generateBitmap(BitmapFactory.decodeStream(inputstream, null, new android.graphics.BitmapFactory.Options()), i, j);
            Bitmap bitmap = bitmap1;
            inputstream.close();
_L4:
            return bitmap;
            OutOfMemoryError outofmemoryerror;
            outofmemoryerror;
            Log.w(WallpaperManager.TAG, "Can't decode stream", outofmemoryerror);
            Exception exception;
            try {
                inputstream.close();
            }
            catch(IOException ioexception1) { }
            catch(RemoteException remoteexception) { }
_L2:
            bitmap = null;
            continue; /* Loop/switch isn't completed */
            exception;
            try {
                inputstream.close();
            }
            catch(IOException ioexception) { }
            throw exception;
            IOException ioexception2;
            ioexception2;
            if(true) goto _L4; else goto _L3
_L3:
        }

        public void forgetLoadedWallpaper() {
            this;
            JVM INSTR monitorenter ;
            mWallpaper = null;
            mDefaultWallpaper = null;
            return;
        }

        public void onWallpaperChanged() {
            mHandler.sendEmptyMessage(1);
        }

        public Bitmap peekWallpaperBitmap(Context context, boolean flag) {
            this;
            JVM INSTR monitorenter ;
            if(mWallpaper == null) goto _L2; else goto _L1
_L1:
            Bitmap bitmap = mWallpaper;
              goto _L3
_L2:
            if(mDefaultWallpaper == null) goto _L5; else goto _L4
_L4:
            bitmap = mDefaultWallpaper;
              goto _L3
            Exception exception;
            exception;
            throw exception;
_L5:
            mWallpaper = null;
            try {
                mWallpaper = getCurrentWallpaperLocked();
            }
            catch(OutOfMemoryError outofmemoryerror) {
                Log.w(WallpaperManager.TAG, "No memory load current wallpaper", outofmemoryerror);
            }
            if(!flag) goto _L7; else goto _L6
_L6:
            if(mWallpaper != null) goto _L9; else goto _L8
_L8:
            mDefaultWallpaper = getDefaultWallpaperLocked(context);
            bitmap = mDefaultWallpaper;
            this;
            JVM INSTR monitorexit ;
              goto _L3
_L9:
            mDefaultWallpaper = null;
_L7:
            bitmap = mWallpaper;
            this;
            JVM INSTR monitorexit ;
_L3:
            return bitmap;
        }

        private static final int MSG_CLEAR_WALLPAPER = 1;
        private Bitmap mDefaultWallpaper;
        private final Handler mHandler;
        private IWallpaperManager mService;
        private Bitmap mWallpaper;


/*
        static Bitmap access$002(Globals globals, Bitmap bitmap) {
            globals.mWallpaper = bitmap;
            return bitmap;
        }

*/


/*
        static Bitmap access$102(Globals globals, Bitmap bitmap) {
            globals.mDefaultWallpaper = bitmap;
            return bitmap;
        }

*/


        Globals(Looper looper) {
            mService = IWallpaperManager.Stub.asInterface(ServiceManager.getService("wallpaper"));
            mHandler = new Handler(looper) {

                public void handleMessage(Message message) {
                    message.what;
                    JVM INSTR tableswitch 1 1: default 24
                //                               1 25;
                       goto _L1 _L2
_L1:
                    return;
_L2:
                    this;
                    JVM INSTR monitorenter ;
                    mWallpaper = null;
                    mDefaultWallpaper = null;
                    if(true) goto _L1; else goto _L3
_L3:
                }

                final Globals this$0;

                 {
                    this$0 = Globals.this;
                    super(looper);
                }
            };
        }
    }

    static class FastBitmapDrawable extends Drawable {

        public void draw(Canvas canvas) {
            canvas.drawBitmap(mBitmap, mDrawLeft, mDrawTop, mPaint);
        }

        public int getIntrinsicHeight() {
            return mHeight;
        }

        public int getIntrinsicWidth() {
            return mWidth;
        }

        public int getMinimumHeight() {
            return mHeight;
        }

        public int getMinimumWidth() {
            return mWidth;
        }

        public int getOpacity() {
            return -1;
        }

        public void setAlpha(int i) {
            throw new UnsupportedOperationException("Not supported with this drawable");
        }

        public void setBounds(int i, int j, int k, int l) {
            mDrawLeft = i + (k - i - mWidth) / 2;
            mDrawTop = j + (l - j - mHeight) / 2;
        }

        public void setColorFilter(ColorFilter colorfilter) {
            throw new UnsupportedOperationException("Not supported with this drawable");
        }

        public void setDither(boolean flag) {
            throw new UnsupportedOperationException("Not supported with this drawable");
        }

        public void setFilterBitmap(boolean flag) {
            throw new UnsupportedOperationException("Not supported with this drawable");
        }

        private final Bitmap mBitmap;
        private int mDrawLeft;
        private int mDrawTop;
        private final int mHeight;
        private final Paint mPaint;
        private final int mWidth;

        private FastBitmapDrawable(Bitmap bitmap) {
            mBitmap = bitmap;
            mWidth = bitmap.getWidth();
            mHeight = bitmap.getHeight();
            setBounds(0, 0, mWidth, mHeight);
            mPaint = new Paint();
            mPaint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC));
        }

    }


    WallpaperManager(Context context, Handler handler) {
        mWallpaperXStep = -1F;
        mWallpaperYStep = -1F;
        mContext = context;
        initGlobals(context.getMainLooper());
    }

    static Bitmap generateBitmap(Bitmap bitmap, int i, int j) {
        if(bitmap != null) goto _L2; else goto _L1
_L1:
        bitmap = null;
_L9:
        return bitmap;
_L2:
        bitmap.setDensity(DisplayMetrics.DENSITY_DEVICE);
        if(i <= 0 || j <= 0 || bitmap.getWidth() == i && bitmap.getHeight() == j)
            continue; /* Loop/switch isn't completed */
        Bitmap bitmap1;
        Canvas canvas;
        Rect rect;
        int k;
        int l;
        bitmap1 = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
        bitmap1.setDensity(DisplayMetrics.DENSITY_DEVICE);
        canvas = new Canvas(bitmap1);
        rect = new Rect();
        rect.right = bitmap.getWidth();
        rect.bottom = bitmap.getHeight();
        k = i - rect.right;
        l = j - rect.bottom;
        if(k <= 0 && l <= 0) goto _L4; else goto _L3
_L3:
        if(k <= l) goto _L6; else goto _L5
_L5:
        float f1 = (float)i / (float)rect.right;
_L7:
        rect.right = (int)(f1 * (float)rect.right);
        rect.bottom = (int)(f1 * (float)rect.bottom);
        k = i - rect.right;
        l = j - rect.bottom;
_L4:
        rect.offset(k / 2, l / 2);
        Paint paint = new Paint();
        paint.setFilterBitmap(true);
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC));
        canvas.drawBitmap(bitmap, null, rect, paint);
        bitmap.recycle();
        canvas.setBitmap(null);
        bitmap = bitmap1;
        continue; /* Loop/switch isn't completed */
_L6:
        float f;
        int i1;
        f = j;
        i1 = rect.bottom;
        f1 = f / (float)i1;
          goto _L7
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        Log.w(TAG, "Can't generate default bitmap", outofmemoryerror);
        if(true) goto _L9; else goto _L8
_L8:
    }

    public static WallpaperManager getInstance(Context context) {
        return (WallpaperManager)context.getSystemService("wallpaper");
    }

    static void initGlobals(Looper looper) {
        Object obj = sSync;
        obj;
        JVM INSTR monitorenter ;
        if(sGlobals == null)
            sGlobals = new Globals(looper);
        return;
    }

    private void setWallpaper(InputStream inputstream, FileOutputStream fileoutputstream) throws IOException {
        byte abyte0[] = new byte[32768];
        do {
            int i = inputstream.read(abyte0);
            if(i > 0)
                fileoutputstream.write(abyte0, 0, i);
            else
                return;
        } while(true);
    }

    public void clear() throws IOException {
        setResource(0x1080220);
    }

    public void clearWallpaperOffsets(IBinder ibinder) {
        ViewRootImpl.getWindowSession(mContext.getMainLooper()).setWallpaperPosition(ibinder, -1F, -1F, -1F, -1F);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void forgetLoadedWallpaper() {
        sGlobals.forgetLoadedWallpaper();
    }

    public Bitmap getBitmap() {
        return sGlobals.peekWallpaperBitmap(mContext, true);
    }

    public int getDesiredMinimumHeight() {
        int i = 0;
        if(sGlobals.mService != null) goto _L2; else goto _L1
_L1:
        Log.w(TAG, "WallpaperService not running");
_L4:
        return i;
_L2:
        int j = sGlobals.mService.getHeightHint();
        i = j;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getDesiredMinimumWidth() {
        int i = 0;
        if(sGlobals.mService != null) goto _L2; else goto _L1
_L1:
        Log.w(TAG, "WallpaperService not running");
_L4:
        return i;
_L2:
        int j = sGlobals.mService.getWidthHint();
        i = j;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public Drawable getDrawable() {
        Bitmap bitmap = sGlobals.peekWallpaperBitmap(mContext, true);
        BitmapDrawable bitmapdrawable;
        if(bitmap != null) {
            bitmapdrawable = new BitmapDrawable(mContext.getResources(), bitmap);
            bitmapdrawable.setDither(false);
        } else {
            bitmapdrawable = null;
        }
        return bitmapdrawable;
    }

    public Drawable getFastDrawable() {
        Bitmap bitmap = sGlobals.peekWallpaperBitmap(mContext, true);
        FastBitmapDrawable fastbitmapdrawable;
        if(bitmap != null)
            fastbitmapdrawable = new FastBitmapDrawable(bitmap);
        else
            fastbitmapdrawable = null;
        return fastbitmapdrawable;
    }

    public IWallpaperManager getIWallpaperManager() {
        return sGlobals.mService;
    }

    public WallpaperInfo getWallpaperInfo() {
        WallpaperInfo wallpaperinfo = null;
        WallpaperInfo wallpaperinfo1;
        if(sGlobals.mService == null) {
            Log.w(TAG, "WallpaperService not running");
            break MISSING_BLOCK_LABEL_41;
        }
        wallpaperinfo1 = sGlobals.mService.getWallpaperInfo();
        wallpaperinfo = wallpaperinfo1;
        break MISSING_BLOCK_LABEL_41;
        RemoteException remoteexception;
        remoteexception;
        return wallpaperinfo;
    }

    public Drawable peekDrawable() {
        Bitmap bitmap = sGlobals.peekWallpaperBitmap(mContext, false);
        BitmapDrawable bitmapdrawable;
        if(bitmap != null) {
            bitmapdrawable = new BitmapDrawable(mContext.getResources(), bitmap);
            bitmapdrawable.setDither(false);
        } else {
            bitmapdrawable = null;
        }
        return bitmapdrawable;
    }

    public Drawable peekFastDrawable() {
        Bitmap bitmap = sGlobals.peekWallpaperBitmap(mContext, false);
        FastBitmapDrawable fastbitmapdrawable;
        if(bitmap != null)
            fastbitmapdrawable = new FastBitmapDrawable(bitmap);
        else
            fastbitmapdrawable = null;
        return fastbitmapdrawable;
    }

    public void sendWallpaperCommand(IBinder ibinder, String s, int i, int j, int k, Bundle bundle) {
        ViewRootImpl.getWindowSession(mContext.getMainLooper()).sendWallpaperCommand(ibinder, s, i, j, k, bundle, false);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setBitmap(Bitmap bitmap) throws IOException {
        if(sGlobals.mService != null) goto _L2; else goto _L1
_L1:
        Log.w(TAG, "WallpaperService not running");
_L4:
        return;
_L2:
        ParcelFileDescriptor parcelfiledescriptor = sGlobals.mService.setWallpaper(null);
        if(parcelfiledescriptor == null) goto _L4; else goto _L3
_L3:
        android.os.ParcelFileDescriptor.AutoCloseOutputStream autocloseoutputstream = null;
        android.os.ParcelFileDescriptor.AutoCloseOutputStream autocloseoutputstream1 = new android.os.ParcelFileDescriptor.AutoCloseOutputStream(parcelfiledescriptor);
        bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 90, autocloseoutputstream1);
        if(autocloseoutputstream1 == null) goto _L4; else goto _L5
_L5:
        autocloseoutputstream1.close();
          goto _L4
_L6:
        Exception exception;
        if(autocloseoutputstream != null)
            autocloseoutputstream.close();
        throw exception;
        exception;
        autocloseoutputstream = autocloseoutputstream1;
          goto _L6
        RemoteException remoteexception;
        remoteexception;
          goto _L4
        exception;
          goto _L6
    }

    public void setResource(int i) throws IOException {
        if(sGlobals.mService != null) goto _L2; else goto _L1
_L1:
        Log.w(TAG, "WallpaperService not running");
_L4:
        return;
_L2:
        Resources resources;
        ParcelFileDescriptor parcelfiledescriptor;
        resources = mContext.getResources();
        parcelfiledescriptor = sGlobals.mService.setWallpaper((new StringBuilder()).append("res:").append(resources.getResourceName(i)).toString());
        if(parcelfiledescriptor == null) goto _L4; else goto _L3
_L3:
        android.os.ParcelFileDescriptor.AutoCloseOutputStream autocloseoutputstream = null;
        android.os.ParcelFileDescriptor.AutoCloseOutputStream autocloseoutputstream1 = new android.os.ParcelFileDescriptor.AutoCloseOutputStream(parcelfiledescriptor);
        setWallpaper(resources.openRawResource(i), autocloseoutputstream1);
        if(autocloseoutputstream1 == null) goto _L4; else goto _L5
_L5:
        autocloseoutputstream1.close();
          goto _L4
_L6:
        Exception exception;
        if(autocloseoutputstream != null)
            autocloseoutputstream.close();
        throw exception;
        exception;
        autocloseoutputstream = autocloseoutputstream1;
          goto _L6
        RemoteException remoteexception;
        remoteexception;
          goto _L4
        exception;
          goto _L6
    }

    public void setStream(InputStream inputstream) throws IOException {
        if(sGlobals.mService != null) goto _L2; else goto _L1
_L1:
        Log.w(TAG, "WallpaperService not running");
_L4:
        return;
_L2:
        ParcelFileDescriptor parcelfiledescriptor = sGlobals.mService.setWallpaper(null);
        if(parcelfiledescriptor == null) goto _L4; else goto _L3
_L3:
        android.os.ParcelFileDescriptor.AutoCloseOutputStream autocloseoutputstream = null;
        android.os.ParcelFileDescriptor.AutoCloseOutputStream autocloseoutputstream1 = new android.os.ParcelFileDescriptor.AutoCloseOutputStream(parcelfiledescriptor);
        setWallpaper(inputstream, autocloseoutputstream1);
        if(autocloseoutputstream1 == null) goto _L4; else goto _L5
_L5:
        autocloseoutputstream1.close();
          goto _L4
_L6:
        Exception exception;
        if(autocloseoutputstream != null)
            autocloseoutputstream.close();
        throw exception;
        exception;
        autocloseoutputstream = autocloseoutputstream1;
          goto _L6
        RemoteException remoteexception;
        remoteexception;
          goto _L4
        exception;
          goto _L6
    }

    public void setWallpaperOffsetSteps(float f, float f1) {
        mWallpaperXStep = f;
        mWallpaperYStep = f1;
    }

    public void setWallpaperOffsets(IBinder ibinder, float f, float f1) {
        ViewRootImpl.getWindowSession(mContext.getMainLooper()).setWallpaperPosition(ibinder, f, f1, mWallpaperXStep, mWallpaperYStep);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void suggestDesiredDimensions(int i, int j) {
        try {
            if(sGlobals.mService == null)
                Log.w(TAG, "WallpaperService not running");
            else
                sGlobals.mService.setDimensionHints(i, j);
        }
        catch(RemoteException remoteexception) { }
    }

    public static final String ACTION_CHANGE_LIVE_WALLPAPER = "android.service.wallpaper.CHANGE_LIVE_WALLPAPER";
    public static final String ACTION_LIVE_WALLPAPER_CHOOSER = "android.service.wallpaper.LIVE_WALLPAPER_CHOOSER";
    public static final String COMMAND_DROP = "android.home.drop";
    public static final String COMMAND_SECONDARY_TAP = "android.wallpaper.secondaryTap";
    public static final String COMMAND_TAP = "android.wallpaper.tap";
    private static boolean DEBUG = false;
    public static final String EXTRA_LIVE_WALLPAPER_COMPONENT = "android.service.wallpaper.extra.LIVE_WALLPAPER_COMPONENT";
    private static String TAG = "WallpaperManager";
    public static final String WALLPAPER_PREVIEW_META_DATA = "android.wallpaper.preview";
    private static Globals sGlobals;
    private static final Object sSync = new Object[0];
    private final Context mContext;
    private float mWallpaperXStep;
    private float mWallpaperYStep;

    static  {
        DEBUG = false;
    }

}
