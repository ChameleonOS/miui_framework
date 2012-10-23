// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.renderscript;

import android.content.res.Resources;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package android.renderscript:
//            Script, RSRuntimeException, RenderScript

public class ScriptC extends Script {

    protected ScriptC(int i, RenderScript renderscript) {
        super(i, renderscript);
    }

    protected ScriptC(RenderScript renderscript, Resources resources, int i) {
        super(0, renderscript);
        int j = internalCreate(renderscript, resources, i);
        if(j == 0) {
            throw new RSRuntimeException("Loading of ScriptC script failed.");
        } else {
            setID(j);
            return;
        }
    }

    /**
     * @deprecated Method internalCreate is deprecated
     */

    private static int internalCreate(RenderScript renderscript, Resources resources, int i) {
        android/renderscript/ScriptC;
        JVM INSTR monitorenter ;
        InputStream inputstream = resources.openRawResource(i);
        byte abyte0[];
        int j;
        abyte0 = new byte[1024];
        j = 0;
_L1:
        int l;
        int k = abyte0.length - j;
        if(k == 0) {
            byte abyte1[] = new byte[2 * abyte0.length];
            System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
            abyte0 = abyte1;
            k = abyte0.length - j;
        }
        l = inputstream.read(abyte0, j, k);
        if(l > 0)
            break MISSING_BLOCK_LABEL_143;
        inputstream.close();
        int i1;
        String s = resources.getResourceEntryName(i);
        Log.v("ScriptC", (new StringBuilder()).append("Create script for resource = ").append(s).toString());
        i1 = renderscript.nScriptCCreate(s, RenderScript.mCachePath, abyte0, j);
        android/renderscript/ScriptC;
        JVM INSTR monitorexit ;
        return i1;
        j += l;
          goto _L1
        Exception exception1;
        exception1;
        Exception exception;
        try {
            inputstream.close();
            throw exception1;
        }
        catch(IOException ioexception) { }
        finally {
            android/renderscript/ScriptC;
        }
        throw new android.content.res.Resources.NotFoundException();
        throw exception;
    }

    private static final String TAG = "ScriptC";
}
