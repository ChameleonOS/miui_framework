// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.textservice;

import android.os.*;
import android.util.Log;
import com.android.internal.textservice.ITextServicesManager;
import java.util.Locale;

// Referenced classes of package android.view.textservice:
//            SpellCheckerSubtype, SpellCheckerInfo, SpellCheckerSession

public final class TextServicesManager {

    private TextServicesManager() {
        if(sService == null)
            sService = com.android.internal.textservice.ITextServicesManager.Stub.asInterface(ServiceManager.getService("textservices"));
    }

    public static TextServicesManager getInstance() {
        android/view/textservice/TextServicesManager;
        JVM INSTR monitorenter ;
        TextServicesManager textservicesmanager;
        if(sInstance == null)
            break MISSING_BLOCK_LABEL_19;
        textservicesmanager = sInstance;
        android/view/textservice/TextServicesManager;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_45;
        sInstance = new TextServicesManager();
        android/view/textservice/TextServicesManager;
        JVM INSTR monitorexit ;
        textservicesmanager = sInstance;
        break MISSING_BLOCK_LABEL_45;
        Exception exception;
        exception;
        android/view/textservice/TextServicesManager;
        JVM INSTR monitorexit ;
        throw exception;
        return textservicesmanager;
    }

    public SpellCheckerInfo getCurrentSpellChecker() {
        SpellCheckerInfo spellcheckerinfo = null;
        SpellCheckerInfo spellcheckerinfo1 = sService.getCurrentSpellChecker(null);
        spellcheckerinfo = spellcheckerinfo1;
_L2:
        return spellcheckerinfo;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public SpellCheckerSubtype getCurrentSpellCheckerSubtype(boolean flag) {
        SpellCheckerSubtype spellcheckersubtype = null;
        SpellCheckerSubtype spellcheckersubtype1 = sService.getCurrentSpellCheckerSubtype(null, flag);
        spellcheckersubtype = spellcheckersubtype1;
_L2:
        return spellcheckersubtype;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, (new StringBuilder()).append("Error in getCurrentSpellCheckerSubtype: ").append(remoteexception).toString());
        if(true) goto _L2; else goto _L1
_L1:
    }

    public SpellCheckerInfo[] getEnabledSpellCheckers() {
        SpellCheckerInfo aspellcheckerinfo1[] = sService.getEnabledSpellCheckers();
        SpellCheckerInfo aspellcheckerinfo[] = aspellcheckerinfo1;
_L2:
        return aspellcheckerinfo;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, (new StringBuilder()).append("Error in getEnabledSpellCheckers: ").append(remoteexception).toString());
        aspellcheckerinfo = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean isSpellCheckerEnabled() {
        boolean flag1 = sService.isSpellCheckerEnabled();
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, (new StringBuilder()).append("Error in isSpellCheckerEnabled:").append(remoteexception).toString());
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public SpellCheckerSession newSpellCheckerSession(Bundle bundle, Locale locale, SpellCheckerSession.SpellCheckerSessionListener spellcheckersessionlistener, boolean flag) {
        if(spellcheckersessionlistener == null)
            throw new NullPointerException();
        if(!flag && locale == null)
            throw new IllegalArgumentException("Locale should not be null if you don't refer settings.");
        if(!flag || isSpellCheckerEnabled()) goto _L2; else goto _L1
_L1:
        SpellCheckerSession spellcheckersession = null;
_L3:
        return spellcheckersession;
_L2:
        SpellCheckerInfo spellcheckerinfo = sService.getCurrentSpellChecker(null);
        if(spellcheckerinfo != null)
            break MISSING_BLOCK_LABEL_79;
        spellcheckersession = null;
          goto _L3
        RemoteException remoteexception;
        remoteexception;
        spellcheckersession = null;
          goto _L3
        SpellCheckerSubtype spellcheckersubtype = null;
        if(!flag) goto _L5; else goto _L4
_L4:
label0:
        {
            spellcheckersubtype = getCurrentSpellCheckerSubtype(true);
            if(spellcheckersubtype != null)
                break label0;
            spellcheckersession = null;
        }
          goto _L3
        if(locale == null) goto _L7; else goto _L6
_L6:
        String s2;
        String s3;
        s2 = spellcheckersubtype.getLocale();
        s3 = locale.toString();
        if(s2.length() >= 2 && s3.length() >= 2 && s2.substring(0, 2).equals(s3.substring(0, 2))) goto _L7; else goto _L8
_L8:
        spellcheckersession = null;
          goto _L3
_L5:
        String s;
        int i;
        s = locale.toString();
        i = 0;
_L9:
        SpellCheckerSubtype spellcheckersubtype1;
        String s1;
        if(i < spellcheckerinfo.getSubtypeCount()) {
            spellcheckersubtype1 = spellcheckerinfo.getSubtypeAt(i);
            s1 = spellcheckersubtype1.getLocale();
            if(!s1.equals(s))
                break MISSING_BLOCK_LABEL_226;
            spellcheckersubtype = spellcheckersubtype1;
        }
_L7:
        if(spellcheckersubtype == null) {
            spellcheckersession = null;
        } else {
            spellcheckersession = new SpellCheckerSession(spellcheckerinfo, sService, spellcheckersessionlistener, spellcheckersubtype);
            try {
                sService.getSpellCheckerService(spellcheckerinfo.getId(), spellcheckersubtype.getLocale(), spellcheckersession.getTextServicesSessionListener(), spellcheckersession.getSpellCheckerSessionListener(), bundle);
            }
            catch(RemoteException remoteexception1) {
                spellcheckersession = null;
            }
        }
          goto _L3
        if(s.length() >= 2 && s1.length() >= 2 && s.startsWith(s1))
            spellcheckersubtype = spellcheckersubtype1;
        i++;
          goto _L9
    }

    public void setCurrentSpellChecker(SpellCheckerInfo spellcheckerinfo) {
        if(spellcheckerinfo != null)
            break MISSING_BLOCK_LABEL_42;
        try {
            throw new NullPointerException("SpellCheckerInfo is null.");
        }
        catch(RemoteException remoteexception) {
            Log.e(TAG, (new StringBuilder()).append("Error in setCurrentSpellChecker: ").append(remoteexception).toString());
        }
_L1:
        return;
        sService.setCurrentSpellChecker(null, spellcheckerinfo.getId());
          goto _L1
    }

    public void setSpellCheckerEnabled(boolean flag) {
        sService.setSpellCheckerEnabled(flag);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, (new StringBuilder()).append("Error in setSpellCheckerEnabled:").append(remoteexception).toString());
          goto _L1
    }

    public void setSpellCheckerSubtype(SpellCheckerSubtype spellcheckersubtype) {
        if(spellcheckersubtype != null) goto _L2; else goto _L1
_L1:
        int j = 0;
_L4:
        sService.setCurrentSpellCheckerSubtype(null, j);
        break; /* Loop/switch isn't completed */
_L2:
        int i = spellcheckersubtype.hashCode();
        j = i;
        if(true) goto _L4; else goto _L3
        RemoteException remoteexception;
        remoteexception;
        Log.e(TAG, (new StringBuilder()).append("Error in setSpellCheckerSubtype:").append(remoteexception).toString());
_L3:
    }

    private static final boolean DBG;
    private static final String TAG = android/view/textservice/TextServicesManager.getSimpleName();
    private static TextServicesManager sInstance;
    private static ITextServicesManager sService;

}
