// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.webkit:
//            Plugin

public class PluginList {

    public PluginList() {
        mPlugins = new ArrayList();
    }

    /**
     * @deprecated Method addPlugin is deprecated
     */

    public void addPlugin(Plugin plugin) {
        this;
        JVM INSTR monitorenter ;
        if(!mPlugins.contains(plugin))
            mPlugins.add(plugin);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method clear is deprecated
     */

    public void clear() {
        this;
        JVM INSTR monitorenter ;
        mPlugins.clear();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getList is deprecated
     */

    public List getList() {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist = mPlugins;
        this;
        JVM INSTR monitorexit ;
        return arraylist;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method pluginClicked is deprecated
     */

    public void pluginClicked(Context context, int i) {
        this;
        JVM INSTR monitorenter ;
        Exception exception;
        try {
            ((Plugin)mPlugins.get(i)).dispatchClickEvent(context);
        }
        catch(IndexOutOfBoundsException indexoutofboundsexception) { }
        finally {
            this;
        }
        return;
        throw exception;
    }

    /**
     * @deprecated Method removePlugin is deprecated
     */

    public void removePlugin(Plugin plugin) {
        this;
        JVM INSTR monitorenter ;
        int i = mPlugins.indexOf(plugin);
        if(i != -1)
            mPlugins.remove(i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private ArrayList mPlugins;
}
