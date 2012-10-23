// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.renderscript;

import java.io.UnsupportedEncodingException;

// Referenced classes of package android.renderscript:
//            RenderScript, RSIllegalArgumentException, RSInvalidStateException, RSRuntimeException

public class BaseObj {

    BaseObj(int i, RenderScript renderscript) {
        renderscript.validate();
        mRS = renderscript;
        mID = i;
        mDestroyed = false;
    }

    void checkValid() {
        if(mID == 0)
            throw new RSIllegalArgumentException("Invalid object.");
        else
            return;
    }

    /**
     * @deprecated Method destroy is deprecated
     */

    public void destroy() {
        this;
        JVM INSTR monitorenter ;
        if(mDestroyed)
            throw new RSInvalidStateException("Object already destroyed.");
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        mDestroyed = true;
        mRS.nObjDestroy(mID);
        this;
        JVM INSTR monitorexit ;
    }

    public boolean equals(Object obj) {
        boolean flag = true;
        if(this != obj) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(getClass() != obj.getClass()) {
            flag = false;
        } else {
            BaseObj baseobj = (BaseObj)obj;
            if(mID != baseobj.mID)
                flag = false;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    protected void finalize() throws Throwable {
        if(!mDestroyed) {
            if(mID != 0 && mRS.isAlive())
                mRS.nObjDestroy(mID);
            mRS = null;
            mID = 0;
            mDestroyed = true;
        }
        super.finalize();
    }

    int getID(RenderScript renderscript) {
        mRS.validate();
        if(mDestroyed)
            throw new RSInvalidStateException("using a destroyed object.");
        if(mID == 0)
            throw new RSRuntimeException("Internal error: Object id 0.");
        if(renderscript != null && renderscript != mRS)
            throw new RSInvalidStateException("using object with mismatched context.");
        else
            return mID;
    }

    public String getName() {
        return mName;
    }

    public int hashCode() {
        return mID;
    }

    void setID(int i) {
        if(mID != 0) {
            throw new RSRuntimeException("Internal Error, reset of object ID.");
        } else {
            mID = i;
            return;
        }
    }

    public void setName(String s) {
        if(s == null)
            throw new RSIllegalArgumentException("setName requires a string of non-zero length.");
        if(s.length() < 1)
            throw new RSIllegalArgumentException("setName does not accept a zero length string.");
        if(mName != null)
            throw new RSIllegalArgumentException("setName object already has a name.");
        try {
            byte abyte0[] = s.getBytes("UTF-8");
            mRS.nAssignName(mID, abyte0);
            mName = s;
            return;
        }
        catch(UnsupportedEncodingException unsupportedencodingexception) {
            throw new RuntimeException(unsupportedencodingexception);
        }
    }

    void updateFromNative() {
        mRS.validate();
        mName = mRS.nGetName(getID(mRS));
    }

    private boolean mDestroyed;
    private int mID;
    private String mName;
    RenderScript mRS;
}
