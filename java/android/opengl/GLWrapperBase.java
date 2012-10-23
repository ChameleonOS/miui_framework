// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.opengl;

import javax.microedition.khronos.opengles.*;

abstract class GLWrapperBase
    implements GL, GL10, GL10Ext, GL11, GL11Ext, GL11ExtensionPack {

    public GLWrapperBase(GL gl) {
        mgl = (GL10)gl;
        if(gl instanceof GL10Ext)
            mgl10Ext = (GL10Ext)gl;
        if(gl instanceof GL11)
            mgl11 = (GL11)gl;
        if(gl instanceof GL11Ext)
            mgl11Ext = (GL11Ext)gl;
        if(gl instanceof GL11ExtensionPack)
            mgl11ExtensionPack = (GL11ExtensionPack)gl;
    }

    protected GL10 mgl;
    protected GL10Ext mgl10Ext;
    protected GL11 mgl11;
    protected GL11Ext mgl11Ext;
    protected GL11ExtensionPack mgl11ExtensionPack;
}
