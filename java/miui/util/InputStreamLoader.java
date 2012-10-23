// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.util;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.*;
import java.util.zip.ZipFile;

public class InputStreamLoader {

    public InputStreamLoader(Context context, Uri uri) {
        if("file".equals(uri.getScheme())) {
            mPath = uri.getPath();
        } else {
            mContext = context;
            mUri = uri;
        }
    }

    public InputStreamLoader(String s) {
        mPath = s;
    }

    public InputStreamLoader(String s, String s1) {
        mZipPath = s;
        mPath = s1;
    }

    public InputStreamLoader(byte abyte0[]) {
        mByteArrayInputStream = new ByteArrayInputStream(abyte0);
    }

    public void close() {
        if(mInputStream != null)
            mInputStream.close();
        if(mZipFile != null)
            mZipFile.close();
_L2:
        return;
        IOException ioexception;
        ioexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public InputStream get() {
        close();
        if(mUri == null) goto _L2; else goto _L1
_L1:
        mInputStream = mContext.getContentResolver().openInputStream(mUri);
_L4:
        if(mInputStream != null && !(mInputStream instanceof ByteArrayInputStream))
            mInputStream = new BufferedInputStream(mInputStream, 16384);
        return mInputStream;
_L2:
        try {
            if(mZipPath != null) {
                mZipFile = new ZipFile(mZipPath);
                mInputStream = mZipFile.getInputStream(mZipFile.getEntry(mPath));
            } else
            if(mPath != null)
                mInputStream = new FileInputStream(mPath);
            else
            if(mByteArrayInputStream != null) {
                mByteArrayInputStream.reset();
                mInputStream = mByteArrayInputStream;
            }
        }
        catch(Exception exception) { }
        if(true) goto _L4; else goto _L3
_L3:
    }

    ByteArrayInputStream mByteArrayInputStream;
    private Context mContext;
    private InputStream mInputStream;
    private String mPath;
    private Uri mUri;
    private ZipFile mZipFile;
    private String mZipPath;
}
