// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.renderscript;

import java.io.UnsupportedEncodingException;

// Referenced classes of package android.renderscript:
//            BaseObj, RenderScript, Allocation, RSIllegalArgumentException, 
//            FieldPacker, Element, Type

public class Script extends BaseObj {
    public static class FieldBase {

        public Allocation getAllocation() {
            return mAllocation;
        }

        public Element getElement() {
            return mElement;
        }

        public Type getType() {
            return mAllocation.getType();
        }

        protected void init(RenderScript renderscript, int i) {
            mAllocation = Allocation.createSized(renderscript, mElement, i, 1);
        }

        protected void init(RenderScript renderscript, int i, int j) {
            mAllocation = Allocation.createSized(renderscript, mElement, i, j | 1);
        }

        public void updateAllocation() {
        }

        protected Allocation mAllocation;
        protected Element mElement;

        protected FieldBase() {
        }
    }

    public static class Builder {

        RenderScript mRS;

        Builder(RenderScript renderscript) {
            mRS = renderscript;
        }
    }


    Script(int i, RenderScript renderscript) {
        super(i, renderscript);
    }

    public void bindAllocation(Allocation allocation, int i) {
        super.mRS.validate();
        if(allocation != null)
            super.mRS.nScriptBindAllocation(getID(super.mRS), allocation.getID(super.mRS), i);
        else
            super.mRS.nScriptBindAllocation(getID(super.mRS), 0, i);
    }

    protected void forEach(int i, Allocation allocation, Allocation allocation1, FieldPacker fieldpacker) {
        if(allocation == null && allocation1 == null)
            throw new RSIllegalArgumentException("At least one of ain or aout is required to be non-null.");
        int j = 0;
        if(allocation != null)
            j = allocation.getID(super.mRS);
        int k = 0;
        if(allocation1 != null)
            k = allocation1.getID(super.mRS);
        byte abyte0[] = null;
        if(fieldpacker != null)
            abyte0 = fieldpacker.getData();
        super.mRS.nScriptForEach(getID(super.mRS), i, j, k, abyte0);
    }

    protected void invoke(int i) {
        super.mRS.nScriptInvoke(getID(super.mRS), i);
    }

    protected void invoke(int i, FieldPacker fieldpacker) {
        if(fieldpacker != null)
            super.mRS.nScriptInvokeV(getID(super.mRS), i, fieldpacker.getData());
        else
            super.mRS.nScriptInvoke(getID(super.mRS), i);
    }

    public void setTimeZone(String s) {
        super.mRS.validate();
        try {
            super.mRS.nScriptSetTimeZone(getID(super.mRS), s.getBytes("UTF-8"));
            return;
        }
        catch(UnsupportedEncodingException unsupportedencodingexception) {
            throw new RuntimeException(unsupportedencodingexception);
        }
    }

    public void setVar(int i, double d) {
        super.mRS.nScriptSetVarD(getID(super.mRS), i, d);
    }

    public void setVar(int i, float f) {
        super.mRS.nScriptSetVarF(getID(super.mRS), i, f);
    }

    public void setVar(int i, int j) {
        super.mRS.nScriptSetVarI(getID(super.mRS), i, j);
    }

    public void setVar(int i, long l) {
        super.mRS.nScriptSetVarJ(getID(super.mRS), i, l);
    }

    public void setVar(int i, BaseObj baseobj) {
        RenderScript renderscript = super.mRS;
        int j = getID(super.mRS);
        int k;
        if(baseobj == null)
            k = 0;
        else
            k = baseobj.getID(super.mRS);
        renderscript.nScriptSetVarObj(j, i, k);
    }

    public void setVar(int i, FieldPacker fieldpacker) {
        super.mRS.nScriptSetVarV(getID(super.mRS), i, fieldpacker.getData());
    }

    public void setVar(int i, FieldPacker fieldpacker, Element element, int ai[]) {
        super.mRS.nScriptSetVarVE(getID(super.mRS), i, fieldpacker.getData(), element.getID(super.mRS), ai);
    }

    public void setVar(int i, boolean flag) {
        RenderScript renderscript = super.mRS;
        int j = getID(super.mRS);
        int k;
        if(flag)
            k = 1;
        else
            k = 0;
        renderscript.nScriptSetVarI(j, i, k);
    }
}
