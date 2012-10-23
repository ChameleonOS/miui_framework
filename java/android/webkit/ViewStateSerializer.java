// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.graphics.Point;
import java.io.*;

class ViewStateSerializer {

    private ViewStateSerializer() {
    }

    static WebViewCore.DrawData deserializeViewState(InputStream inputstream) throws IOException {
        DataInputStream datainputstream = new DataInputStream(inputstream);
        int i = datainputstream.readInt();
        if(i > 1) {
            throw new IOException((new StringBuilder()).append("Unexpected version: ").append(i).toString());
        } else {
            int j = datainputstream.readInt();
            int k = datainputstream.readInt();
            int l = nativeDeserializeViewState(i, datainputstream, new byte[16384]);
            WebViewCore.DrawData drawdata = new WebViewCore.DrawData();
            drawdata.mViewState = new WebViewCore.ViewState();
            drawdata.mContentSize = new Point(j, k);
            drawdata.mBaseLayer = l;
            inputstream.close();
            return drawdata;
        }
    }

    private static native int nativeDeserializeViewState(int i, InputStream inputstream, byte abyte0[]);

    private static native boolean nativeSerializeViewState(int i, OutputStream outputstream, byte abyte0[]);

    static boolean serializeViewState(OutputStream outputstream, WebViewCore.DrawData drawdata) throws IOException {
        int i = drawdata.mBaseLayer;
        boolean flag;
        if(i == 0) {
            flag = false;
        } else {
            DataOutputStream dataoutputstream = new DataOutputStream(outputstream);
            dataoutputstream.writeInt(1);
            dataoutputstream.writeInt(drawdata.mContentSize.x);
            dataoutputstream.writeInt(drawdata.mContentSize.y);
            flag = nativeSerializeViewState(i, dataoutputstream, new byte[16384]);
        }
        return flag;
    }

    static final int VERSION = 1;
    private static final int WORKING_STREAM_STORAGE = 16384;
}
