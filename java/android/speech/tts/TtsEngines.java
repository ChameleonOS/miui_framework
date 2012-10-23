// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.speech.tts;

import android.content.Context;
import android.content.Intent;
import android.content.pm.*;
import android.content.res.*;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.*;
import org.xmlpull.v1.XmlPullParserException;

public class TtsEngines {
    private static class EngineInfoComparator
        implements Comparator {

        public int compare(TextToSpeech.EngineInfo engineinfo, TextToSpeech.EngineInfo engineinfo1) {
            int i;
            if(engineinfo.system && !engineinfo1.system)
                i = -1;
            else
            if(engineinfo1.system && !engineinfo.system)
                i = 1;
            else
                i = engineinfo1.priority - engineinfo.priority;
            return i;
        }

        public volatile int compare(Object obj, Object obj1) {
            return compare((TextToSpeech.EngineInfo)obj, (TextToSpeech.EngineInfo)obj1);
        }

        static EngineInfoComparator INSTANCE = new EngineInfoComparator();


        private EngineInfoComparator() {
        }
    }


    public TtsEngines(Context context) {
        mContext = context;
    }

    private String getDefaultLocale() {
        Locale locale = Locale.getDefault();
        String s = locale.getISO3Language();
        String s1;
        if(TextUtils.isEmpty(s)) {
            Log.w("TtsEngines", "Default locale is empty.");
            s1 = "";
        } else
        if(!TextUtils.isEmpty(locale.getISO3Country())) {
            String s2 = (new StringBuilder()).append(s).append("-").append(locale.getISO3Country()).toString();
            if(!TextUtils.isEmpty(locale.getVariant()))
                s2 = (new StringBuilder()).append(s2).append("-").append(locale.getVariant()).toString();
            s1 = s2;
        } else {
            s1 = s;
        }
        return s1;
    }

    private TextToSpeech.EngineInfo getEngineInfo(ResolveInfo resolveinfo, PackageManager packagemanager) {
        ServiceInfo serviceinfo = resolveinfo.serviceInfo;
        TextToSpeech.EngineInfo engineinfo;
        if(serviceinfo != null) {
            engineinfo = new TextToSpeech.EngineInfo();
            engineinfo.name = ((PackageItemInfo) (serviceinfo)).packageName;
            CharSequence charsequence = serviceinfo.loadLabel(packagemanager);
            String s;
            if(TextUtils.isEmpty(charsequence))
                s = engineinfo.name;
            else
                s = charsequence.toString();
            engineinfo.label = s;
            engineinfo.icon = serviceinfo.getIconResource();
            engineinfo.priority = resolveinfo.priority;
            engineinfo.system = isSystemEngine(serviceinfo);
        } else {
            engineinfo = null;
        }
        return engineinfo;
    }

    private String getV1Locale() {
        String s;
        String s1;
        String s2;
        android.content.ContentResolver contentresolver = mContext.getContentResolver();
        s = android.provider.Settings.Secure.getString(contentresolver, "tts_default_lang");
        s1 = android.provider.Settings.Secure.getString(contentresolver, "tts_default_country");
        s2 = android.provider.Settings.Secure.getString(contentresolver, "tts_default_variant");
        if(!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        String s3 = getDefaultLocale();
_L4:
        return s3;
_L2:
        s3 = s;
        if(!TextUtils.isEmpty(s1)) {
            s3 = (new StringBuilder()).append(s3).append("-").append(s1).toString();
            if(!TextUtils.isEmpty(s2))
                s3 = (new StringBuilder()).append(s3).append("-").append(s2).toString();
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private boolean isSystemEngine(ServiceInfo serviceinfo) {
        ApplicationInfo applicationinfo = ((ComponentInfo) (serviceinfo)).applicationInfo;
        boolean flag;
        if(applicationinfo != null && (1 & applicationinfo.flags) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static String parseEnginePrefFromList(String s, String s1) {
        String s2 = null;
        if(!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return s2;
_L2:
        String as[] = s.split(",");
        int i = as.length;
        int j = 0;
        do {
            if(j < i) {
label0:
                {
                    String s3 = as[j];
                    int k = s3.indexOf(':');
                    if(k <= 0 || !s1.equals(s3.substring(0, k)))
                        break label0;
                    s2 = s3.substring(k + 1);
                }
            }
            if(true)
                continue;
            j++;
        } while(true);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static String[] parseLocalePref(String s) {
        String as[] = new String[3];
        as[0] = "";
        as[1] = "";
        as[2] = "";
        if(!TextUtils.isEmpty(s)) {
            String as1[] = s.split("-");
            System.arraycopy(as1, 0, as, 0, as1.length);
        }
        return as;
    }

    private String settingsActivityFromServiceInfo(ServiceInfo serviceinfo, PackageManager packagemanager) {
        XmlResourceParser xmlresourceparser = null;
        xmlresourceparser = serviceinfo.loadXmlMetaData(packagemanager, "android.speech.tts");
        if(xmlresourceparser != null) goto _L2; else goto _L1
_L1:
        Log.w("TtsEngines", (new StringBuilder()).append("No meta-data found for :").append(serviceinfo).toString());
        String s;
        if(xmlresourceparser != null)
            xmlresourceparser.close();
        s = null;
_L3:
        return s;
_L2:
        Resources resources;
        resources = packagemanager.getResourcesForApplication(((ComponentInfo) (serviceinfo)).applicationInfo);
        int i;
        do {
            i = xmlresourceparser.next();
            if(i == 1)
                break MISSING_BLOCK_LABEL_194;
        } while(i != 2);
        if("tts-engine".equals(xmlresourceparser.getName()))
            break MISSING_BLOCK_LABEL_154;
        Log.w("TtsEngines", (new StringBuilder()).append("Package ").append(serviceinfo).append(" uses unknown tag :").append(xmlresourceparser.getName()).toString());
        if(xmlresourceparser != null)
            xmlresourceparser.close();
        s = null;
          goto _L3
        TypedArray typedarray = resources.obtainAttributes(Xml.asAttributeSet(xmlresourceparser), com.android.internal.R.styleable.TextToSpeechEngine);
        s = typedarray.getString(0);
        typedarray.recycle();
        if(xmlresourceparser != null)
            xmlresourceparser.close();
          goto _L3
        if(xmlresourceparser != null)
            xmlresourceparser.close();
        s = null;
          goto _L3
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        Log.w("TtsEngines", (new StringBuilder()).append("Could not load resources for : ").append(serviceinfo).toString());
        if(xmlresourceparser != null)
            xmlresourceparser.close();
        s = null;
          goto _L3
        XmlPullParserException xmlpullparserexception;
        xmlpullparserexception;
        Log.w("TtsEngines", (new StringBuilder()).append("Error parsing metadata for ").append(serviceinfo).append(":").append(xmlpullparserexception).toString());
        if(xmlresourceparser != null)
            xmlresourceparser.close();
        s = null;
          goto _L3
        IOException ioexception;
        ioexception;
        Log.w("TtsEngines", (new StringBuilder()).append("Error parsing metadata for ").append(serviceinfo).append(":").append(ioexception).toString());
        if(xmlresourceparser != null)
            xmlresourceparser.close();
        s = null;
          goto _L3
        Exception exception;
        exception;
        if(xmlresourceparser != null)
            xmlresourceparser.close();
        throw exception;
    }

    private String updateValueInCommaSeparatedList(String s, String s1, String s2) {
        StringBuilder stringbuilder = new StringBuilder();
        if(!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        stringbuilder.append(s1).append(':').append(s2);
_L4:
        return stringbuilder.toString();
_L2:
        String as[] = s.split(",");
        boolean flag = true;
        boolean flag1 = false;
        int i = as.length;
        int j = 0;
        while(j < i)  {
            String s3 = as[j];
            int k = s3.indexOf(':');
            if(k > 0)
                if(s1.equals(s3.substring(0, k))) {
                    if(flag)
                        flag = false;
                    else
                        stringbuilder.append(',');
                    flag1 = true;
                    stringbuilder.append(s1).append(':').append(s2);
                } else {
                    if(flag)
                        flag = false;
                    else
                        stringbuilder.append(',');
                    stringbuilder.append(s3);
                }
            j++;
        }
        if(!flag1) {
            stringbuilder.append(',');
            stringbuilder.append(s1).append(':').append(s2);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public String getDefaultEngine() {
        String s = android.provider.Settings.Secure.getString(mContext.getContentResolver(), "tts_default_synth");
        if(!isEngineInstalled(s))
            s = getHighestRankedEngineName();
        return s;
    }

    public TextToSpeech.EngineInfo getEngineInfo(String s) {
        PackageManager packagemanager = mContext.getPackageManager();
        Intent intent = new Intent("android.intent.action.TTS_SERVICE");
        intent.setPackage(s);
        List list = packagemanager.queryIntentServices(intent, 0x10000);
        TextToSpeech.EngineInfo engineinfo;
        if(list != null && list.size() == 1)
            engineinfo = getEngineInfo((ResolveInfo)list.get(0), packagemanager);
        else
            engineinfo = null;
        return engineinfo;
    }

    public List getEngines() {
        PackageManager packagemanager = mContext.getPackageManager();
        List list = packagemanager.queryIntentServices(new Intent("android.intent.action.TTS_SERVICE"), 0x10000);
        Object obj;
        if(list == null) {
            obj = Collections.emptyList();
        } else {
            obj = new ArrayList(list.size());
            Iterator iterator = list.iterator();
            do {
                if(!iterator.hasNext())
                    break;
                TextToSpeech.EngineInfo engineinfo = getEngineInfo((ResolveInfo)iterator.next(), packagemanager);
                if(engineinfo != null)
                    ((List) (obj)).add(engineinfo);
            } while(true);
            Collections.sort(((List) (obj)), EngineInfoComparator.INSTANCE);
        }
        return ((List) (obj));
    }

    public String getHighestRankedEngineName() {
        List list = getEngines();
        String s;
        if(list.size() > 0 && ((TextToSpeech.EngineInfo)list.get(0)).system)
            s = ((TextToSpeech.EngineInfo)list.get(0)).name;
        else
            s = null;
        return s;
    }

    public String getLocalePrefForEngine(String s) {
        String s1 = parseEnginePrefFromList(android.provider.Settings.Secure.getString(mContext.getContentResolver(), "tts_default_locale"), s);
        if(TextUtils.isEmpty(s1))
            s1 = getV1Locale();
        return s1;
    }

    public Intent getSettingsIntent(String s) {
        PackageManager packagemanager;
        List list;
        packagemanager = mContext.getPackageManager();
        Intent intent = new Intent("android.intent.action.TTS_SERVICE");
        intent.setPackage(s);
        list = packagemanager.queryIntentServices(intent, 0x10080);
        if(list == null || list.size() != 1) goto _L2; else goto _L1
_L1:
        ServiceInfo serviceinfo = ((ResolveInfo)list.get(0)).serviceInfo;
        if(serviceinfo == null) goto _L2; else goto _L3
_L3:
        String s1 = settingsActivityFromServiceInfo(serviceinfo, packagemanager);
        if(s1 == null) goto _L2; else goto _L4
_L4:
        Intent intent1;
        intent1 = new Intent();
        intent1.setClassName(s, s1);
_L6:
        return intent1;
_L2:
        intent1 = null;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public boolean isEngineInstalled(String s) {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        if(s != null && getEngineInfo(s) != null)
            flag = true;
        return flag;
    }

    /**
     * @deprecated Method updateLocalePrefForEngine is deprecated
     */

    public void updateLocalePrefForEngine(String s, String s1) {
        this;
        JVM INSTR monitorenter ;
        String s2 = updateValueInCommaSeparatedList(android.provider.Settings.Secure.getString(mContext.getContentResolver(), "tts_default_locale"), s, s1);
        android.provider.Settings.Secure.putString(mContext.getContentResolver(), "tts_default_locale", s2.toString());
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private static final boolean DBG = false;
    private static final String LOCALE_DELIMITER = "-";
    private static final String TAG = "TtsEngines";
    private static final String XML_TAG_NAME = "tts-engine";
    private final Context mContext;
}
