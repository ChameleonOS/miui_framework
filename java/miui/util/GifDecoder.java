// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.util;

import android.graphics.Bitmap;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Vector;

public class GifDecoder {
    private static class GifFrame {

        public void recycle() {
            if(image != null && !image.isRecycled())
                image.recycle();
        }

        public int delay;
        public Bitmap image;

        public GifFrame(Bitmap bitmap, int i) {
            image = bitmap;
            delay = i;
        }
    }


    public GifDecoder() {
        mMaxDecodeSize = 0x100000L;
        loopCount = 1;
        block = new byte[256];
        blockSize = 0;
        dispose = 0;
        lastDispose = 0;
        transparency = false;
        delay = 0;
        mCancel = false;
        calledOnce = false;
    }

    public static boolean isGifStream(InputStream inputstream) {
        boolean flag = false;
        if(inputstream == null) goto _L2; else goto _L1
_L1:
        String s;
        int i;
        s = "";
        i = 0;
_L7:
        if(i >= 6) goto _L4; else goto _L3
_L3:
        int j = readOneByte(inputstream);
        if(j != -1) goto _L5; else goto _L4
_L4:
        flag = s.startsWith("GIF");
_L2:
        return flag;
_L5:
        s = (new StringBuilder()).append(s).append((char)j).toString();
        i++;
        if(true) goto _L7; else goto _L6
_L6:
    }

    protected static int readOneByte(InputStream inputstream) {
        int j = inputstream.read();
        int i = j;
_L2:
        return i;
        Exception exception;
        exception;
        i = -1;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private void requestCancel() {
    }

    protected void decodeBitmapData() {
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        int i4;
        i = iw * ih;
        if(pixels == null || pixels.length < i)
            pixels = new byte[i];
        if(prefix == null)
            prefix = new short[4096];
        if(suffix == null)
            suffix = new byte[4096];
        if(pixelStack == null)
            pixelStack = new byte[4097];
        j = read();
        k = 1 << j;
        l = k + 1;
        i1 = k + 2;
        j1 = -1;
        k1 = j + 1;
        l1 = -1 + (1 << k1);
        for(int i2 = 0; i2 < k; i2++) {
            prefix[i2] = 0;
            suffix[i2] = (byte)i2;
        }

        j2 = 0;
        k2 = 0;
        l2 = 0;
        i3 = 0;
        j3 = 0;
        k3 = 0;
        l3 = 0;
        i4 = 0;
_L5:
        if(k3 >= i) goto _L2; else goto _L1
_L1:
        if(i4 != 0)
            break MISSING_BLOCK_LABEL_625;
        if(i3 >= k1) goto _L4; else goto _L3
_L3:
        if(l2 == 0) {
            l2 = readBlock();
            int j4;
            if(l2 <= 0) {
                i4;
                break MISSING_BLOCK_LABEL_212;
            }
            j2 = 0;
        }
        j3 += (0xff & block[j2]) << i3;
        i3 += 8;
        j2++;
        l2--;
          goto _L5
_L4:
        j5 = j3 & l1;
        j3 >>= k1;
        i3 -= k1;
        if(j5 > i1) goto _L2; else goto _L6
_L6:
label0:
        {
            if(j5 != l)
                break label0;
            i4;
        }
          goto _L7
        if(j5 == k) {
            k1 = j + 1;
            l1 = -1 + (1 << k1);
            i1 = k + 2;
            j1 = -1;
        } else {
label1:
            {
                if(j1 != -1)
                    break label1;
                byte abyte4[] = pixelStack;
                int j6 = i4 + 1;
                abyte4[i4] = suffix[j5];
                j1 = j5;
                k2 = j5;
                i4 = j6;
            }
        }
          goto _L5
label2:
        {
            k5 = j5;
            if(j5 == i1) {
                byte abyte3[] = pixelStack;
                int i6 = i4 + 1;
                abyte3[i4] = (byte)k2;
                j5 = j1;
                i4 = i6;
            }
            while(j5 > k)  {
                byte abyte2[] = pixelStack;
                int l5 = i4 + 1;
                abyte2[i4] = suffix[j5];
                j5 = prefix[j5];
                i4 = l5;
            }
            k2 = 0xff & suffix[j5];
            if(i1 < 4096)
                break label2;
            i4;
        }
          goto _L7
        int k4;
        byte abyte1[] = pixelStack;
        k4 = i4 + 1;
        abyte1[i4] = (byte)k2;
        prefix[i1] = (short)j1;
        suffix[i1] = (byte)k2;
        if((++i1 & l1) == 0 && i1 < 4096) {
            k1++;
            l1 += i1;
        }
        j1 = k5;
_L8:
        int l4 = k4 - 1;
        byte abyte0[] = pixels;
        int i5 = l3 + 1;
        abyte0[l3] = pixelStack[l4];
        k3++;
        l3 = i5;
        i4 = l4;
          goto _L5
_L7:
        int j5;
        int k5;
        for(j4 = l3; j4 < i; j4++)
            pixels[j4] = 0;

        return;
_L2:
        i4;
          goto _L7
        k4 = i4;
          goto _L8
    }

    protected boolean err() {
        boolean flag;
        if(status != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public Bitmap getBitmap() {
        return getFrame(0);
    }

    public int getDelay(int i) {
        delay = -1;
        int j = getFrameCount();
        if(i >= 0 && i < j)
            delay = ((GifFrame)frames.elementAt(i)).delay;
        return delay;
    }

    public Bitmap getFrame(int i) {
        int j = getFrameCount();
        Bitmap bitmap;
        if(j <= 0) {
            bitmap = null;
        } else {
            int k = i % j;
            bitmap = ((GifFrame)frames.elementAt(k)).image;
        }
        return bitmap;
    }

    public int getFrameCount() {
        int i;
        if(frames == null)
            i = 0;
        else
            i = frames.size();
        return i;
    }

    public int getHeight() {
        return height;
    }

    public int getLoopCount() {
        return loopCount;
    }

    public int getRealFrameCount() {
        int i;
        if(mDecodeToTheEnd)
            i = mDecodedFrames;
        else
            i = 0;
        return i;
    }

    public int getWidth() {
        return width;
    }

    protected void init() {
        status = 0;
        frames = new Vector();
        gct = null;
        lct = null;
    }

    public boolean isDecodeToTheEnd() {
        return mDecodeToTheEnd;
    }

    protected int read() {
        int i = 0;
        int j = in.read();
        i = j;
_L2:
        return i;
        Exception exception;
        exception;
        status = 1;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int read(InputStream inputstream) {
        mDecodeToTheEnd = false;
        if(calledOnce)
            throw new IllegalStateException("decoder cannot be called more than once");
        calledOnce = true;
        init();
        if(inputstream != null) {
            in = new BufferedInputStream(inputstream);
            try {
                readHeader();
                if(!mCancel && !err()) {
                    readContents();
                    if(getFrameCount() < 0)
                        status = 1;
                }
            }
            catch(OutOfMemoryError outofmemoryerror) {
                status = 2;
                recycle();
            }
        } else {
            status = 2;
        }
        if(mCancel) {
            recycle();
            status = 3;
        }
        return status;
    }

    protected void readBitmap() {
        ix = readShort();
        iy = readShort();
        iw = readShort();
        ih = readShort();
        int i = read();
        boolean flag;
        boolean flag1;
        int j;
        if((i & 0x80) != 0)
            flag = true;
        else
            flag = false;
        lctFlag = flag;
        lctSize = 2 << (i & 7);
        if((i & 0x40) != 0)
            flag1 = true;
        else
            flag1 = false;
        interlace = flag1;
        if(lctFlag) {
            lct = readColorTable(lctSize);
            act = lct;
        } else {
            act = gct;
            if(bgIndex == transIndex)
                bgColor = 0;
        }
        j = 0;
        if(transparency) {
            j = act[transIndex];
            act[transIndex] = 0;
        }
        if(act == null)
            status = 1;
        if(!err()) {
            decodeBitmapData();
            skip();
            if(!err() && !mCancel) {
                setPixels();
                if(mDecodedFrames >= mStartFrame)
                    frames.addElement(new GifFrame(image, delay));
                mDecodedFrames = 1 + mDecodedFrames;
                if(transparency)
                    act[transIndex] = j;
                resetFrame();
            }
        }
    }

    protected int readBlock() {
        int i;
        blockSize = read();
        i = 0;
        if(blockSize <= 0) goto _L2; else goto _L1
_L1:
        if(i >= blockSize) goto _L4; else goto _L3
_L3:
        int j = in.read(block, i, blockSize - i);
        if(j != -1) goto _L5; else goto _L4
_L4:
        if(i < blockSize)
            status = 1;
_L2:
        return i;
_L5:
        i += j;
          goto _L1
        Exception exception;
        exception;
        exception.printStackTrace();
          goto _L4
    }

    protected int[] readColorTable(int i) {
        int j;
        int ai[];
        byte abyte0[];
        int k;
        j = i * 3;
        ai = null;
        abyte0 = new byte[j];
        k = 0;
        int i3 = in.read(abyte0, 0, abyte0.length);
        k = i3;
_L1:
        Exception exception;
        if(k < j) {
            status = 1;
        } else {
            ai = new int[256];
            int l = 0;
            int i1 = 0;
            while(i1 < i)  {
                int j1 = l + 1;
                int k1 = 0xff & abyte0[l];
                int l1 = j1 + 1;
                int i2 = 0xff & abyte0[j1];
                int j2 = l1 + 1;
                int k2 = 0xff & abyte0[l1];
                int l2 = i1 + 1;
                ai[i1] = k2 | (0xff000000 | k1 << 16 | i2 << 8);
                l = j2;
                i1 = l2;
            }
        }
        return ai;
        exception;
        exception.printStackTrace();
          goto _L1
    }

    protected void readContents() {
        mDecodedFrames = 0;
        boolean flag = false;
label0:
        do
            do {
                if(flag || err() || mCancel)
                    return;
                switch(read()) {
                default:
                    status = 1;
                    break;

                case 44: // ','
                    int j = frames.size();
                    readBitmap();
                    if(frames.size() > j)
                        mDecodeBmSize = mDecodeBmSize + (long)(image.getRowBytes() * image.getHeight());
                    if(mDecodeBmSize > mMaxDecodeSize)
                        flag = true;
                    break;

                case 33: // '!'
                    switch(read()) {
                    default:
                        skip();
                        break;

                    case 249: 
                        readGraphicControlExt();
                        break;

                    case 255: 
                        readBlock();
                        String s = "";
                        for(int i = 0; i < 11; i++)
                            s = (new StringBuilder()).append(s).append((char)block[i]).toString();

                        if(s.equals("NETSCAPE2.0"))
                            readNetscapeExt();
                        else
                            skip();
                        break;

                    case 254: 
                        skip();
                        break;

                    case 1: // '\001'
                        skip();
                        break;
                    }
                    continue label0;

                case 59: // ';'
                    flag = true;
                    mDecodeToTheEnd = true;
                    continue label0;
                }
            } while(true);
        while(true);
    }

    protected void readGraphicControlExt() {
        boolean flag = true;
        read();
        int i = read();
        dispose = (i & 0x1c) >> 2;
        if(dispose == 0)
            dispose = ((flag) ? 1 : 0);
        if((i & 1) == 0)
            flag = false;
        transparency = flag;
        delay = 10 * readShort();
        if(delay <= 0)
            delay = 100;
        transIndex = read();
        read();
    }

    protected void readHeader() {
        if(!mCancel) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s = "";
        for(int i = 0; i < 6; i++)
            s = (new StringBuilder()).append(s).append((char)read()).toString();

        if(!s.startsWith("GIF")) {
            status = 1;
        } else {
            readLSD();
            if(gctFlag && !err()) {
                gct = readColorTable(gctSize);
                bgColor = gct[bgIndex];
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    protected void readLSD() {
        width = readShort();
        height = readShort();
        int i = read();
        boolean flag;
        if((i & 0x80) != 0)
            flag = true;
        else
            flag = false;
        gctFlag = flag;
        gctSize = 2 << (i & 7);
        bgIndex = read();
        pixelAspect = read();
    }

    protected void readNetscapeExt() {
        do {
            readBlock();
            if(block[0] == 1)
                loopCount = 0xff & block[1] | (0xff & block[2]) << 8;
        } while(blockSize > 0 && !err());
    }

    protected int readShort() {
        return read() | read() << 8;
    }

    public void recycle() {
        if(frames != null) {
            int i = frames.size();
            for(int j = 0; j < i; j++)
                ((GifFrame)frames.elementAt(j)).recycle();

        }
    }

    public void requestCancelDecode() {
        mCancel = true;
        requestCancel();
    }

    protected void resetFrame() {
        lastDispose = dispose;
        lrx = ix;
        lry = iy;
        lrw = iw;
        lrh = ih;
        lastBitmap = image;
        lastBgColor = bgColor;
        dispose = 0;
        transparency = false;
        delay = 0;
        lct = null;
    }

    public void setMaxDecodeSize(long l) {
        mMaxDecodeSize = l;
    }

    protected void setPixels() {
        int i;
        byte byte0;
        int j;
        int k;
        if(dest == null)
            dest = new int[width * height];
        if(lastDispose > 0) {
            if(lastDispose == 3) {
                int j4 = -2 + getFrameCount();
                int i3;
                int l3;
                int i4;
                if(j4 > 0) {
                    Bitmap bitmap = getFrame(j4 - 1);
                    if(!bitmap.equals(lastBitmap)) {
                        lastBitmap = bitmap;
                        lastBitmap.getPixels(dest, 0, width, 0, 0, width, height);
                    }
                } else {
                    lastBitmap = null;
                    dest = new int[width * height];
                }
            }
            if(lastBitmap != null && lastDispose == 2) {
                i3 = 0;
                if(!transparency)
                    i3 = lastBgColor;
                int j3 = lry * width + lrx;
                for(int k3 = 0; k3 < lrh; k3++) {
                    l3 = j3 + lrw;
                    for(i4 = j3; i4 < l3; i4++)
                        dest[i4] = i3;

                    j3 += width;
                }

            }
        }
        i = 1;
        byte0 = 8;
        j = 0;
        k = 0;
_L11:
        if(k >= ih) goto _L2; else goto _L1
_L1:
        int l = k;
        if(!interlace) goto _L4; else goto _L3
_L3:
        if(j < ih) goto _L6; else goto _L5
_L5:
        ++i;
        JVM INSTR tableswitch 2 4: default 304
    //                   2 449
    //                   3 454
    //                   4 461;
           goto _L6 _L7 _L8 _L9
_L6:
        l = j;
        j += byte0;
_L4:
        int i1 = l + iy;
        if(i1 >= height)
            continue; /* Loop/switch isn't completed */
        int j1 = i1 * width;
        int k1 = j1 + ix;
        int l1 = k1 + iw;
        if(j1 + width < l1)
            l1 = j1 + width;
        int i2 = k * iw;
        do {
            if(k1 >= l1)
                continue; /* Loop/switch isn't completed */
            byte abyte0[] = pixels;
            int j2 = i2 + 1;
            int k2 = 0xff & abyte0[i2];
            int l2 = act[k2];
            if(l2 != 0)
                dest[k1] = l2;
            k1++;
            i2 = j2;
        } while(true);
_L7:
        j = 4;
        continue; /* Loop/switch isn't completed */
_L8:
        j = 2;
        byte0 = 4;
        continue; /* Loop/switch isn't completed */
_L9:
        j = 1;
        byte0 = 2;
        if(true) goto _L6; else goto _L10
_L10:
        k++;
          goto _L11
_L2:
        if(mDecodedFrames <= mStartFrame && image != null && !image.isRecycled())
            image.recycle();
        image = Bitmap.createBitmap(dest, width, height, android.graphics.Bitmap.Config.ARGB_8888);
        return;
    }

    public void setStartFrame(int i) {
        mStartFrame = i;
    }

    protected void skip() {
        do
            readBlock();
        while(blockSize > 0 && !err());
    }

    public static final int MAX_DECODE_SIZE = 0x100000;
    protected static final int MAX_STACK_SIZE = 4096;
    public static final int STATUS_DECODE_CANCEL = 3;
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OK = 0;
    public static final int STATUS_OPEN_ERROR = 2;
    protected int act[];
    protected int bgColor;
    protected int bgIndex;
    protected byte block[];
    protected int blockSize;
    private boolean calledOnce;
    protected int delay;
    private int dest[];
    protected int dispose;
    protected Vector frames;
    protected int gct[];
    protected boolean gctFlag;
    protected int gctSize;
    private int height;
    protected int ih;
    protected Bitmap image;
    protected BufferedInputStream in;
    protected boolean interlace;
    protected int iw;
    protected int ix;
    protected int iy;
    protected int lastBgColor;
    protected Bitmap lastBitmap;
    protected int lastDispose;
    protected int lct[];
    protected boolean lctFlag;
    protected int lctSize;
    protected int loopCount;
    protected int lrh;
    protected int lrw;
    protected int lrx;
    protected int lry;
    private boolean mCancel;
    private long mDecodeBmSize;
    private boolean mDecodeToTheEnd;
    private int mDecodedFrames;
    private long mMaxDecodeSize;
    private int mStartFrame;
    protected int pixelAspect;
    protected byte pixelStack[];
    protected byte pixels[];
    protected short prefix[];
    protected int status;
    protected byte suffix[];
    protected int transIndex;
    protected boolean transparency;
    private int width;
}
