// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;

import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package android.graphics:
//            Canvas, Bitmap

public class Picture {
    private static class RecordingCanvas extends Canvas {

        public void drawPicture(Picture picture) {
            if(mPicture == picture) {
                throw new RuntimeException("Cannot draw a picture into its recording canvas");
            } else {
                super.drawPicture(picture);
                return;
            }
        }

        public void setBitmap(Bitmap bitmap) {
            throw new RuntimeException("Cannot call setBitmap on a picture canvas");
        }

        private final Picture mPicture;

        public RecordingCanvas(Picture picture, int i) {
            super(i);
            mPicture = picture;
        }
    }


    public Picture() {
        this(nativeConstructor(0), false);
    }

    private Picture(int i, boolean flag) {
        if(i == 0) {
            throw new RuntimeException();
        } else {
            mNativePicture = i;
            createdFromStream = flag;
            return;
        }
    }

    public Picture(Picture picture) {
        int i;
        if(picture != null)
            i = picture.mNativePicture;
        else
            i = 0;
        this(nativeConstructor(i), false);
    }

    public static Picture createFromStream(InputStream inputstream) {
        return new Picture(nativeCreateFromStream(inputstream, new byte[16384]), true);
    }

    private static native int nativeBeginRecording(int i, int j, int k);

    private static native int nativeConstructor(int i);

    private static native int nativeCreateFromStream(InputStream inputstream, byte abyte0[]);

    private static native void nativeDestructor(int i);

    private static native void nativeDraw(int i, int j);

    private static native void nativeEndRecording(int i);

    private static native boolean nativeWriteToStream(int i, OutputStream outputstream, byte abyte0[]);

    public Canvas beginRecording(int i, int j) {
        mRecordingCanvas = new RecordingCanvas(this, nativeBeginRecording(mNativePicture, i, j));
        return mRecordingCanvas;
    }

    public void draw(Canvas canvas) {
        if(mRecordingCanvas != null)
            endRecording();
        nativeDraw(canvas.mNativeCanvas, mNativePicture);
    }

    public void endRecording() {
        if(mRecordingCanvas != null) {
            mRecordingCanvas = null;
            nativeEndRecording(mNativePicture);
        }
    }

    protected void finalize() throws Throwable {
        nativeDestructor(mNativePicture);
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public native int getHeight();

    public native int getWidth();

    final int ni() {
        return mNativePicture;
    }

    public void writeToStream(OutputStream outputstream) {
        if(outputstream == null)
            throw new NullPointerException();
        if(!nativeWriteToStream(mNativePicture, outputstream, new byte[16384]))
            throw new RuntimeException();
        else
            return;
    }

    private static final int WORKING_STREAM_STORAGE = 16384;
    public final boolean createdFromStream;
    private final int mNativePicture;
    private Canvas mRecordingCanvas;
}
