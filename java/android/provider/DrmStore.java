// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.provider;

import android.content.*;
import android.drm.mobile1.DrmRawContent;
import android.drm.mobile1.DrmRightsManager;
import android.net.Uri;
import android.util.Log;
import java.io.*;
import java.nio.channels.FileChannel;

// Referenced classes of package android.provider:
//            BaseColumns

public final class DrmStore {
    public static interface Audio
        extends Columns {

        public static final Uri CONTENT_URI = Uri.parse("content://drm/audio");

    }

    public static interface Images
        extends Columns {

        public static final Uri CONTENT_URI = Uri.parse("content://drm/images");

    }

    public static interface Columns
        extends BaseColumns {

        public static final String DATA = "_data";
        public static final String MIME_TYPE = "mime_type";
        public static final String SIZE = "_size";
        public static final String TITLE = "title";
    }


    public DrmStore() {
    }

    public static final Intent addDrmFile(ContentResolver contentresolver, File file, String s) {
        FileInputStream fileinputstream;
        Intent intent;
        fileinputstream = null;
        intent = null;
        FileInputStream fileinputstream1 = new FileInputStream(file);
        if(s != null)
            break MISSING_BLOCK_LABEL_45;
        s = file.getName();
        int i = s.lastIndexOf('.');
        if(i > 0)
            s = s.substring(0, i);
        Intent intent1 = addDrmFile(contentresolver, fileinputstream1, s);
        intent = intent1;
        if(fileinputstream1 != null)
            try {
                fileinputstream1.close();
            }
            catch(IOException ioexception2) {
                Log.e("DrmStore", "IOException in DrmStore.addDrmFile()", ioexception2);
            }
_L1:
        return intent;
        Exception exception;
        exception;
_L4:
        Log.e("DrmStore", "pushing file failed", exception);
        if(fileinputstream != null)
            try {
                fileinputstream.close();
            }
            catch(IOException ioexception1) {
                Log.e("DrmStore", "IOException in DrmStore.addDrmFile()", ioexception1);
            }
          goto _L1
        Exception exception1;
        exception1;
_L3:
        if(fileinputstream != null)
            try {
                fileinputstream.close();
            }
            catch(IOException ioexception) {
                Log.e("DrmStore", "IOException in DrmStore.addDrmFile()", ioexception);
            }
        throw exception1;
        exception1;
        fileinputstream = fileinputstream1;
        if(true) goto _L3; else goto _L2
_L2:
        exception;
        fileinputstream = fileinputstream1;
          goto _L4
    }

    public static final Intent addDrmFile(ContentResolver contentresolver, FileInputStream fileinputstream, String s) {
        OutputStream outputstream;
        Intent intent;
        outputstream = null;
        intent = null;
        String s1;
        long l;
        InputStream inputstream;
        Uri uri;
        DrmRawContent drmrawcontent = new DrmRawContent(fileinputstream, fileinputstream.available(), "application/vnd.oma.drm.message");
        s1 = drmrawcontent.getContentType();
        l = fileinputstream.getChannel().size();
        inputstream = drmrawcontent.getContentInputStream(DrmRightsManager.getInstance().queryRights(drmrawcontent));
        uri = null;
        if(!s1.startsWith("audio/")) goto _L2; else goto _L1
_L1:
        uri = Audio.CONTENT_URI;
_L7:
        if(uri == null) goto _L4; else goto _L3
_L3:
        Uri uri1;
        ContentValues contentvalues = new ContentValues(3);
        contentvalues.put("title", s);
        contentvalues.put("_size", Long.valueOf(l));
        contentvalues.put("mime_type", s1);
        uri1 = contentresolver.insert(uri, contentvalues);
        if(uri1 == null) goto _L4; else goto _L5
_L5:
        outputstream = contentresolver.openOutputStream(uri1);
        byte abyte0[] = new byte[1000];
        do {
            int i = inputstream.read(abyte0);
            if(i == -1)
                break;
            outputstream.write(abyte0, 0, i);
        } while(true);
          goto _L6
        Exception exception1;
        exception1;
_L11:
        Log.e("DrmStore", "pushing file failed", exception1);
        if(fileinputstream == null)
            break MISSING_BLOCK_LABEL_191;
        fileinputstream.close();
        if(outputstream != null)
            outputstream.close();
_L8:
        return intent;
_L2:
        if(s1.startsWith("image/"))
            uri = Images.CONTENT_URI;
        else
            Log.w("DrmStore", (new StringBuilder()).append("unsupported mime type ").append(s1).toString());
          goto _L7
        Exception exception;
        exception;
_L10:
        if(fileinputstream == null)
            break MISSING_BLOCK_LABEL_259;
        fileinputstream.close();
        if(outputstream != null)
            outputstream.close();
_L9:
        throw exception;
_L6:
        Intent intent1 = new Intent();
        intent1.setDataAndType(uri1, s1);
        intent = intent1;
_L4:
        if(fileinputstream == null)
            break MISSING_BLOCK_LABEL_301;
        fileinputstream.close();
        if(outputstream != null)
            outputstream.close();
          goto _L8
        IOException ioexception2;
        ioexception2;
        Log.e("DrmStore", "IOException in DrmStore.addDrmFile()", ioexception2);
          goto _L8
        IOException ioexception1;
        ioexception1;
        Log.e("DrmStore", "IOException in DrmStore.addDrmFile()", ioexception1);
          goto _L8
        IOException ioexception;
        ioexception;
        Log.e("DrmStore", "IOException in DrmStore.addDrmFile()", ioexception);
          goto _L9
        exception;
          goto _L10
        exception1;
        intent = intent1;
          goto _L11
    }

    public static void enforceAccessDrmPermission(Context context) {
        if(context.checkCallingOrSelfPermission("android.permission.ACCESS_DRM") != 0)
            throw new SecurityException("Requires DRM permission");
        else
            return;
    }

    private static final String ACCESS_DRM_PERMISSION = "android.permission.ACCESS_DRM";
    public static final String AUTHORITY = "drm";
    private static final String TAG = "DrmStore";
}
