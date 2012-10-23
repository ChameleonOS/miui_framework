// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.media.AudioSystem;
import android.media.audiofx.Visualizer;
import android.os.SystemProperties;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

public class SpectrumVisualizer extends ImageView {
    class SymmetryDotBar
        implements DotBarDrawer {

        public void drawDotBar(Canvas canvas, int i) {
            int j = (int)(0.5D + (double)(((float)mDotbarHeight * (1.0F - mPointData[i])) / (float)mCellSize)) * mCellSize;
            if(j < mDotbarHeight)
                canvas.drawBitmap(mPixels, j * mCellSize, mCellSize, i * mCellSize, j, mCellSize, mDotbarHeight - j, true, mPaint);
            int k = (int)(0.5D + (double)(((float)mShadowDotbarHeight * mPointData[i]) / (float)mCellSize)) * mCellSize;
            if(k > mShadowDotbarHeight)
                k = mShadowDotbarHeight;
            if(k > 0)
                canvas.drawBitmap(mShadowPixels, 0, mCellSize, i * mCellSize, mDotbarHeight, mCellSize, k, true, mPaint);
        }

        final SpectrumVisualizer this$0;

        SymmetryDotBar() {
            this$0 = SpectrumVisualizer.this;
            super();
        }
    }

    class AsymmetryDotBar
        implements DotBarDrawer {

        public void drawDotBar(Canvas canvas, int i) {
            int j = (int)(0.5D + (double)(((float)mDotbarHeight * (1.0F - mPointData[i])) / (float)mCellSize)) * mCellSize;
            if(j < mDotbarHeight)
                canvas.drawBitmap(mPixels, j * mCellSize, mCellSize, i * mCellSize, j, mCellSize, mDotbarHeight - j, true, mPaint);
        }

        final SpectrumVisualizer this$0;

        AsymmetryDotBar() {
            this$0 = SpectrumVisualizer.this;
            super();
        }
    }

    private static interface DotBarDrawer {

        public abstract void drawDotBar(Canvas canvas, int i);
    }


    public SpectrumVisualizer(Context context) {
        super(context);
        mPaint = new Paint();
        mSampleBuf = new short[160];
        mSoftDrawEnabled = true;
        MAX_VALID_SAMPLE = 20;
        init(context, null);
    }

    public SpectrumVisualizer(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mPaint = new Paint();
        mSampleBuf = new short[160];
        mSoftDrawEnabled = true;
        MAX_VALID_SAMPLE = 20;
        init(context, attributeset);
    }

    public SpectrumVisualizer(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mPaint = new Paint();
        mSampleBuf = new short[160];
        mSoftDrawEnabled = true;
        MAX_VALID_SAMPLE = 20;
        init(context, attributeset);
    }

    private void drawInternal(Canvas canvas) {
        mPaint.setAlpha(255);
        int i = mVisualizationWidthNum - mAlphaWidthNum;
        for(int j = mAlphaWidthNum; j < i; j++)
            mDrawer.drawDotBar(canvas, j);

        for(int k = mAlphaWidthNum; k > 0; k--) {
            mPaint.setAlpha((k * 255) / mAlphaWidthNum);
            mDrawer.drawDotBar(canvas, k - 1);
            mDrawer.drawDotBar(canvas, mVisualizationWidthNum - k);
        }

    }

    private Bitmap drawToBitmap() {
        Bitmap bitmap = mCachedBitmap;
        Canvas canvas = mCachedCanvas;
        if(bitmap != null && (bitmap.getWidth() != getWidth() || bitmap.getHeight() != getHeight())) {
            bitmap.recycle();
            bitmap = null;
        }
        if(bitmap == null) {
            bitmap = Bitmap.createBitmap(getWidth(), getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            mCachedBitmap = bitmap;
            canvas = new Canvas(bitmap);
            mCachedCanvas = canvas;
        }
        canvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
        drawInternal(canvas);
        return bitmap;
    }

    private void init(Context context, AttributeSet attributeset) {
        android.graphics.drawable.Drawable drawable = null;
        android.graphics.drawable.Drawable drawable1 = null;
        android.graphics.drawable.Drawable drawable2 = null;
        boolean flag = false;
        mEnableDrawing = true;
        mIsNeedCareStreamActive = true;
        mAlphaWidthNum = 0;
        if(attributeset != null) {
            TypedArray typedarray = context.obtainStyledAttributes(attributeset, miui.R.styleable.SpectrumVisualizer);
            drawable = typedarray.getDrawable(3);
            drawable1 = typedarray.getDrawable(1);
            drawable2 = typedarray.getDrawable(2);
            flag = typedarray.getBoolean(0, false);
            mAlphaWidthNum = typedarray.getInt(4, mAlphaWidthNum);
            mIsEnableUpdate = typedarray.getBoolean(5, false);
            mIsNeedCareStreamActive = typedarray.getBoolean(6, false);
            typedarray.recycle();
        }
        if(drawable == null)
            drawable = context.getResources().getDrawable(0x6020105);
        Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
        if(drawable1 == null)
            drawable1 = context.getResources().getDrawable(0x6020106);
        Bitmap bitmap1 = ((BitmapDrawable)drawable1).getBitmap();
        Bitmap bitmap2 = null;
        if(flag) {
            if(drawable2 == null)
                drawable2 = context.getResources().getDrawable(0x6020107);
            bitmap2 = ((BitmapDrawable)drawable2).getBitmap();
        }
        setBitmaps(bitmap, bitmap1, bitmap2);
    }

    public void enableDrawing(boolean flag) {
        mEnableDrawing = flag;
    }

    public void enableUpdate(boolean flag) {
        if(mIsEnableUpdate == flag) goto _L2; else goto _L1
_L1:
        if(!flag || mVisualizer != null) goto _L4; else goto _L3
_L3:
        if(!IS_LPA_DECODE) goto _L6; else goto _L5
_L5:
        Log.v("SpectrumVisualizer", "lpa decode is on, can't enable");
_L7:
        mIsEnableUpdate = flag;
        break; /* Loop/switch isn't completed */
_L6:
        mVisualizer = new Visualizer(0);
        if(!mVisualizer.getEnabled()) {
            mVisualizer.setCaptureSize(512);
            mVisualizer.setDataCaptureListener(mOnDataCaptureListener, Visualizer.getMaxCaptureRate(), false, true);
            mVisualizer.setEnabled(true);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if(!flag && mVisualizer != null) {
            mVisualizer.setEnabled(false);
            Thread.sleep(50L);
            mVisualizer.release();
            mVisualizer = null;
        }
        if(true) goto _L7; else goto _L2
        RuntimeException runtimeexception;
        runtimeexception;
          goto _L2
        InterruptedException interruptedexception;
        interruptedexception;
        interruptedexception.printStackTrace();
_L2:
        return;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        if(true) goto _L2; else goto _L8
_L8:
    }

    public int getVisualHeight() {
        return mVisualizationHeight;
    }

    public int getVisualWidth() {
        return mVisualizationWidth;
    }

    public boolean isUpdateEnabled() {
        return mIsEnableUpdate;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mEnableDrawing)
            if(mSoftDrawEnabled)
                canvas.drawBitmap(drawToBitmap(), 0.0F, 0.0F, null);
            else
                drawInternal(canvas);
    }

    public void setBitmaps(Bitmap bitmap, Bitmap bitmap1, Bitmap bitmap2) {
        setImageBitmap(bitmap);
        mVisualizationWidth = bitmap.getWidth();
        mVisualizationHeight = bitmap.getHeight();
        mCellSize = bitmap1.getWidth();
        mDotbarHeight = bitmap1.getHeight();
        if(mDotbarHeight > mVisualizationHeight)
            mDotbarHeight = mVisualizationHeight;
        mPixels = new int[mCellSize * mDotbarHeight];
        bitmap1.getPixels(mPixels, 0, mCellSize, 0, 0, mCellSize, mDotbarHeight);
        mVisualizationWidthNum = mVisualizationWidth / mCellSize;
        mVisualizationHeightNum = mDotbarHeight / mCellSize;
        SAMPLE_SCALE_FACTOR = 20F / (float)mVisualizationHeightNum;
        INDEX_SCALE_FACTOR = (float)Math.log(mVisualizationWidthNum / 3);
        VISUALIZE_DESC_HEIGHT = 1.0F / (float)mVisualizationHeightNum;
        mPointData = new float[mVisualizationWidthNum];
        if(mAlphaWidthNum == 0)
            mAlphaWidthNum = mVisualizationWidthNum / 2;
        mShadowPixels = null;
        if(bitmap2 != null) {
            mShadowDotbarHeight = bitmap2.getHeight();
            if(mShadowDotbarHeight + mDotbarHeight > mVisualizationHeight)
                mShadowDotbarHeight = mVisualizationHeight - mDotbarHeight;
            if(mShadowDotbarHeight < mCellSize) {
                mDrawer = new AsymmetryDotBar();
            } else {
                mShadowPixels = new int[mCellSize * mShadowDotbarHeight];
                bitmap2.getPixels(mShadowPixels, 0, mCellSize, 0, 0, mCellSize, mShadowDotbarHeight);
                mDrawer = new SymmetryDotBar();
            }
        } else {
            mDrawer = new AsymmetryDotBar();
        }
    }

    public void setSoftDrawEnabled(boolean flag) {
        mSoftDrawEnabled = flag;
        if(!flag && mCachedBitmap != null) {
            mCachedBitmap.recycle();
            mCachedBitmap = null;
            mCachedCanvas = null;
        }
    }

    void update(byte abyte0[]) {
        if(!mIsNeedCareStreamActive || AudioSystem.isStreamActive(3, 0)) goto _L2; else goto _L1
_L1:
        enableDrawing(false);
_L4:
        return;
_L2:
        enableDrawing(true);
        if(abyte0 != null) {
            short aword0[] = mSampleBuf;
            int i = aword0.length;
            int j = 0;
            while(j < i)  {
                byte byte0 = abyte0[j * 2];
                byte byte1 = abyte0[1 + j * 2];
                int k1 = (int)Math.sqrt(byte0 * byte0 + byte1 * byte1);
                if(k1 >= 32767)
                    k1 = 32767;
                aword0[j] = (short)k1;
                j++;
            }
            int k = 0;
            int l = 0;
            int i1 = 0;
            while(i1 < mVisualizationWidthNum)  {
                int j1 = 0;
                for(; l < i; l += mVisualizationWidthNum) {
                    j1 = Math.max(j1, aword0[k]);
                    k++;
                }

                l -= i;
                float f;
                float f1;
                if(j1 > 1) {
                    float f2 = (float)(Math.log(i1 + 2) / (double)INDEX_SCALE_FACTOR);
                    f = f2 * (f2 * (float)(j1 - 1));
                } else {
                    f = 0.0F;
                }
                if(f > 20F)
                    f1 = mVisualizationHeightNum;
                else
                    f1 = f / SAMPLE_SCALE_FACTOR;
                mPointData[i1] = Math.max(f1 / (float)mVisualizationHeightNum, mPointData[i1] - VISUALIZE_DESC_HEIGHT);
                i1++;
            }
            invalidate();
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static final int CONSIDER_SAMPLE_LENGTH = 160;
    public static boolean IS_LPA_DECODE = false;
    private static final int RES_DEFAULT_SLIDING_DOT_BAR_ID = 0x6020106;
    private static final int RES_DEFAULT_SLIDING_PANEL_ID = 0x6020105;
    private static final int RES_DEFAULT_SLIDING_SHADOW_DOT_BAR_ID = 0x6020107;
    private static final String TAG = "SpectrumVisualizer";
    private static final int VISUALIZATION_SAMPLE_LENGTH = 256;
    private float INDEX_SCALE_FACTOR;
    private final int MAX_VALID_SAMPLE;
    private float SAMPLE_SCALE_FACTOR;
    private float VISUALIZE_DESC_HEIGHT;
    int mAlphaWidthNum;
    private Bitmap mCachedBitmap;
    private Canvas mCachedCanvas;
    int mCellSize;
    int mDotbarHeight;
    private DotBarDrawer mDrawer;
    private boolean mEnableDrawing;
    private boolean mIsEnableUpdate;
    private boolean mIsNeedCareStreamActive;
    private android.media.audiofx.Visualizer.OnDataCaptureListener mOnDataCaptureListener = new android.media.audiofx.Visualizer.OnDataCaptureListener() {

        public void onFftDataCapture(Visualizer visualizer, byte abyte0[], int i) {
            update(abyte0);
        }

        public void onWaveFormDataCapture(Visualizer visualizer, byte abyte0[], int i) {
        }

        final SpectrumVisualizer this$0;

             {
                this$0 = SpectrumVisualizer.this;
                super();
            }
    };
    Paint mPaint;
    int mPixels[];
    float mPointData[];
    private short mSampleBuf[];
    int mShadowDotbarHeight;
    int mShadowPixels[];
    private boolean mSoftDrawEnabled;
    private int mVisualizationHeight;
    int mVisualizationHeightNum;
    private int mVisualizationWidth;
    int mVisualizationWidthNum;
    private Visualizer mVisualizer;

    static  {
        IS_LPA_DECODE = SystemProperties.getBoolean("persist.sys.lpa.decode", false);
    }
}
