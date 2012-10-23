// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.util.Log;

public class FaceDetector {
    public class Face {

        public float confidence() {
            return mConfidence;
        }

        public float eyesDistance() {
            return mEyesDist;
        }

        public void getMidPoint(PointF pointf) {
            pointf.set(mMidPointX, mMidPointY);
        }

        public float pose(int i) {
            float f;
            if(i == 0)
                f = mPoseEulerX;
            else
            if(i == 1)
                f = mPoseEulerY;
            else
            if(i == 2)
                f = mPoseEulerZ;
            else
                throw new IllegalArgumentException();
            return f;
        }

        public static final float CONFIDENCE_THRESHOLD = 0.4F;
        public static final int EULER_X = 0;
        public static final int EULER_Y = 1;
        public static final int EULER_Z = 2;
        private float mConfidence;
        private float mEyesDist;
        private float mMidPointX;
        private float mMidPointY;
        private float mPoseEulerX;
        private float mPoseEulerY;
        private float mPoseEulerZ;
        final FaceDetector this$0;

        private Face() {
            this$0 = FaceDetector.this;
            super();
        }

    }


    public FaceDetector(int i, int j, int k) {
        if(sInitialized) {
            fft_initialize(i, j, k);
            mWidth = i;
            mHeight = j;
            mMaxFaces = k;
            mBWBuffer = new byte[i * j];
        }
    }

    private native void fft_destroy();

    private native int fft_detect(Bitmap bitmap);

    private native void fft_get_face(Face face, int i);

    private native int fft_initialize(int i, int j, int k);

    private static native void nativeClassInit();

    protected void finalize() throws Throwable {
        fft_destroy();
    }

    public int findFaces(Bitmap bitmap, Face aface[]) {
        int i;
        if(!sInitialized) {
            i = 0;
        } else {
            if(bitmap.getWidth() != mWidth || bitmap.getHeight() != mHeight)
                throw new IllegalArgumentException("bitmap size doesn't match initialization");
            if(aface.length < mMaxFaces)
                throw new IllegalArgumentException("faces[] smaller than maxFaces");
            i = fft_detect(bitmap);
            if(i >= mMaxFaces)
                i = mMaxFaces;
            int j = 0;
            while(j < i)  {
                if(aface[j] == null)
                    aface[j] = new Face();
                fft_get_face(aface[j], j);
                j++;
            }
        }
        return i;
    }

    private static boolean sInitialized = false;
    private byte mBWBuffer[];
    private int mDCR;
    private int mFD;
    private int mHeight;
    private int mMaxFaces;
    private int mSDK;
    private int mWidth;

    static  {
        System.loadLibrary("FFTEm");
        nativeClassInit();
        sInitialized = true;
_L1:
        return;
        UnsatisfiedLinkError unsatisfiedlinkerror;
        unsatisfiedlinkerror;
        Log.d("FFTEm", "face detection library not found!");
          goto _L1
    }
}
