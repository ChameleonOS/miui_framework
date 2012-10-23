// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.renderscript;

import android.content.res.AssetManager;
import android.content.res.Resources;
import java.io.File;
import java.io.InputStream;

// Referenced classes of package android.renderscript:
//            BaseObj, RenderScript, RSRuntimeException, Mesh

public class FileA3D extends BaseObj {
    public static class IndexEntry {

        /**
         * @deprecated Method internalCreate is deprecated
         */

        static BaseObj internalCreate(RenderScript renderscript, IndexEntry indexentry) {
            BaseObj baseobj = null;
            android/renderscript/FileA3D$IndexEntry;
            JVM INSTR monitorenter ;
            if(indexentry.mLoadedObj == null) goto _L2; else goto _L1
_L1:
            baseobj = indexentry.mLoadedObj;
_L4:
            android/renderscript/FileA3D$IndexEntry;
            JVM INSTR monitorexit ;
            return baseobj;
_L2:
            if(indexentry.mEntryType == EntryType.UNKNOWN) goto _L4; else goto _L3
_L3:
            int i = renderscript.nFileA3DGetEntryByIndex(indexentry.mID, indexentry.mIndex);
            if(i == 0) goto _L4; else goto _L5
_L5:
            class _cls1 {

                static final int $SwitchMap$android$renderscript$FileA3D$EntryType[];

                static  {
                    $SwitchMap$android$renderscript$FileA3D$EntryType = new int[EntryType.values().length];
                    $SwitchMap$android$renderscript$FileA3D$EntryType[EntryType.MESH.ordinal()] = 1;
_L2:
                    return;
                    NoSuchFieldError nosuchfielderror;
                    nosuchfielderror;
                    if(true) goto _L2; else goto _L1
_L1:
                }
            }

            _cls1..SwitchMap.android.renderscript.FileA3D.EntryType[indexentry.mEntryType.ordinal()];
            JVM INSTR tableswitch 1 1: default 80
        //                       1 95;
               goto _L6 _L7
_L6:
            if(false) goto _L9; else goto _L8
_L9:
            if(true) goto _L4; else goto _L10
_L10:
_L8:
            indexentry.mLoadedObj.updateFromNative();
            baseobj = indexentry.mLoadedObj;
              goto _L4
_L7:
            indexentry.mLoadedObj = new Mesh(i, renderscript);
              goto _L8
            Exception exception;
            exception;
            throw exception;
        }

        public EntryType getEntryType() {
            return mEntryType;
        }

        public Mesh getMesh() {
            return (Mesh)getObject();
        }

        public String getName() {
            return mName;
        }

        public BaseObj getObject() {
            mRS.validate();
            return internalCreate(mRS, this);
        }

        EntryType mEntryType;
        int mID;
        int mIndex;
        BaseObj mLoadedObj;
        String mName;
        RenderScript mRS;

        IndexEntry(RenderScript renderscript, int i, int j, String s, EntryType entrytype) {
            mRS = renderscript;
            mIndex = i;
            mID = j;
            mName = s;
            mEntryType = entrytype;
            mLoadedObj = null;
        }
    }

    public static final class EntryType extends Enum {

        static EntryType toEntryType(int i) {
            return values()[i];
        }

        public static EntryType valueOf(String s) {
            return (EntryType)Enum.valueOf(android/renderscript/FileA3D$EntryType, s);
        }

        public static EntryType[] values() {
            return (EntryType[])$VALUES.clone();
        }

        private static final EntryType $VALUES[];
        public static final EntryType MESH;
        public static final EntryType UNKNOWN;
        int mID;

        static  {
            UNKNOWN = new EntryType("UNKNOWN", 0, 0);
            MESH = new EntryType("MESH", 1, 1);
            EntryType aentrytype[] = new EntryType[2];
            aentrytype[0] = UNKNOWN;
            aentrytype[1] = MESH;
            $VALUES = aentrytype;
        }

        private EntryType(String s, int i, int j) {
            super(s, i);
            mID = j;
        }
    }


    FileA3D(int i, RenderScript renderscript, InputStream inputstream) {
        super(i, renderscript);
        mInputStream = inputstream;
    }

    public static FileA3D createFromAsset(RenderScript renderscript, AssetManager assetmanager, String s) {
        renderscript.validate();
        int i = renderscript.nFileA3DCreateFromAsset(assetmanager, s);
        if(i == 0) {
            throw new RSRuntimeException((new StringBuilder()).append("Unable to create a3d file from asset ").append(s).toString());
        } else {
            FileA3D filea3d = new FileA3D(i, renderscript, null);
            filea3d.initEntries();
            return filea3d;
        }
    }

    public static FileA3D createFromFile(RenderScript renderscript, File file) {
        return createFromFile(renderscript, file.getAbsolutePath());
    }

    public static FileA3D createFromFile(RenderScript renderscript, String s) {
        int i = renderscript.nFileA3DCreateFromFile(s);
        if(i == 0) {
            throw new RSRuntimeException((new StringBuilder()).append("Unable to create a3d file from ").append(s).toString());
        } else {
            FileA3D filea3d = new FileA3D(i, renderscript, null);
            filea3d.initEntries();
            return filea3d;
        }
    }

    public static FileA3D createFromResource(RenderScript renderscript, Resources resources, int i) {
        renderscript.validate();
        InputStream inputstream;
        try {
            inputstream = resources.openRawResource(i);
        }
        catch(Exception exception) {
            throw new RSRuntimeException((new StringBuilder()).append("Unable to open resource ").append(i).toString());
        }
        if(inputstream instanceof android.content.res.AssetManager.AssetInputStream) {
            int j = renderscript.nFileA3DCreateFromAssetStream(((android.content.res.AssetManager.AssetInputStream)inputstream).getAssetInt());
            if(j == 0) {
                throw new RSRuntimeException((new StringBuilder()).append("Unable to create a3d file from resource ").append(i).toString());
            } else {
                FileA3D filea3d = new FileA3D(j, renderscript, inputstream);
                filea3d.initEntries();
                return filea3d;
            }
        } else {
            throw new RSRuntimeException("Unsupported asset stream");
        }
    }

    private void initEntries() {
        int i = super.mRS.nFileA3DGetNumIndexEntries(getID(super.mRS));
        if(i > 0) {
            mFileEntries = new IndexEntry[i];
            int ai[] = new int[i];
            String as[] = new String[i];
            super.mRS.nFileA3DGetIndexEntries(getID(super.mRS), i, ai, as);
            int j = 0;
            while(j < i)  {
                mFileEntries[j] = new IndexEntry(super.mRS, j, getID(super.mRS), as[j], EntryType.toEntryType(ai[j]));
                j++;
            }
        }
    }

    public IndexEntry getIndexEntry(int i) {
        IndexEntry indexentry;
        if(getIndexEntryCount() == 0 || i < 0 || i >= mFileEntries.length)
            indexentry = null;
        else
            indexentry = mFileEntries[i];
        return indexentry;
    }

    public int getIndexEntryCount() {
        int i;
        if(mFileEntries == null)
            i = 0;
        else
            i = mFileEntries.length;
        return i;
    }

    IndexEntry mFileEntries[];
    InputStream mInputStream;
}
