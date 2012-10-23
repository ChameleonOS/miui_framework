// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.app;

import android.app.*;
import android.app.backup.BackupManager;
import android.content.Context;
import android.content.res.*;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.widget.*;
import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;
import miui.util.ExtraLocalePicker;

public class LocalePicker extends ListFragment {
    public static class LocaleInfo
        implements Comparable {

        public int compareTo(LocaleInfo localeinfo) {
            return sCollator.compare(label, localeinfo.label);
        }

        public volatile int compareTo(Object obj) {
            return compareTo((LocaleInfo)obj);
        }

        public String getLabel() {
            return label;
        }

        public Locale getLocale() {
            return locale;
        }

        public String toString() {
            return label;
        }

        static final Collator sCollator = Collator.getInstance();
        String label;
        Locale locale;


        public LocaleInfo(String s, Locale locale1) {
            label = s;
            locale = locale1;
        }
    }

    public static interface LocaleSelectionListener {

        public abstract void onLocaleSelected(Locale locale);
    }


    public LocalePicker() {
    }

    public static ArrayAdapter constructAdapter(Context context) {
        return constructAdapter(context, 0x1090064, 0x1020176);
    }

    public static ArrayAdapter constructAdapter(Context context, int i, int j) {
        Resources resources = context.getResources();
        String as[] = Resources.getSystem().getAssets().getLocales();
        String as1[] = resources.getStringArray(0x1070007);
        String as2[] = resources.getStringArray(0x1070008);
        Arrays.sort(as);
        int k = as.length;
        LocaleInfo alocaleinfo[] = new LocaleInfo[k];
        int l = 0;
        int i1 = 0;
        while(l < k)  {
            String s = as[l];
            LocaleInfo alocaleinfo1[];
            int j1;
            ArrayAdapter arrayadapter;
            int k1;
            if(s.length() == 5) {
                String s1 = s.substring(0, 2);
                Locale locale = new Locale(s1, s.substring(3, 5));
                if(i1 == 0) {
                    k1 = i1 + 1;
                    LocaleInfo localeinfo2 = new LocaleInfo(toTitleCase(locale.getDisplayLanguage(locale)), locale);
                    alocaleinfo[i1] = localeinfo2;
                } else
                if(alocaleinfo[i1 - 1].locale.getLanguage().equals(s1)) {
                    alocaleinfo[i1 - 1].label = toTitleCase(getDisplayName(alocaleinfo[i1 - 1].locale, as1, as2));
                    k1 = i1 + 1;
                    LocaleInfo localeinfo1 = new LocaleInfo(toTitleCase(getDisplayName(locale, as1, as2)), locale);
                    alocaleinfo[i1] = localeinfo1;
                } else {
                    String s2;
                    LocaleInfo localeinfo;
                    if(s.equals("zz_ZZ"))
                        s2 = "Pseudo...";
                    else
                        s2 = toTitleCase(locale.getDisplayLanguage(locale));
                    k1 = i1 + 1;
                    localeinfo = new LocaleInfo(s2, locale);
                    alocaleinfo[i1] = localeinfo;
                }
            } else {
                k1 = i1;
            }
            l++;
            i1 = k1;
        }
        alocaleinfo1 = new LocaleInfo[i1];
        for(j1 = 0; j1 < i1; j1++)
            alocaleinfo1[j1] = alocaleinfo[j1];

        Arrays.sort(alocaleinfo1);
        ExtraLocalePicker.adjustLocaleOrder(alocaleinfo1);
        arrayadapter = new ArrayAdapter(context, i, j, alocaleinfo1);
        return arrayadapter;
    }

    private static String getDisplayName(Locale locale, String as[], String as1[]) {
        String s;
        int i;
        s = locale.toString();
        i = 0;
_L3:
        if(i >= as.length)
            break MISSING_BLOCK_LABEL_41;
        if(!as[i].equals(s)) goto _L2; else goto _L1
_L1:
        String s1 = as1[i];
_L4:
        return s1;
_L2:
        i++;
          goto _L3
        s1 = locale.getDisplayName(locale);
          goto _L4
    }

    private static String toTitleCase(String s) {
        if(s.length() != 0)
            s = (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
        return s;
    }

    public static void updateLocale(Locale locale) {
        IActivityManager iactivitymanager = ActivityManagerNative.getDefault();
        Configuration configuration = iactivitymanager.getConfiguration();
        configuration.locale = locale;
        configuration.userSetLocale = true;
        iactivitymanager.updateConfiguration(configuration);
        BackupManager.dataChanged("com.android.providers.settings");
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setListAdapter(constructAdapter(getActivity()));
    }

    public void onListItemClick(ListView listview, View view, int i, long l) {
        if(mListener != null) {
            Locale locale = ((LocaleInfo)getListAdapter().getItem(i)).locale;
            mListener.onLocaleSelected(locale);
        }
    }

    public void onResume() {
        super.onResume();
        getListView().requestFocus();
    }

    public void setLocaleSelectionListener(LocaleSelectionListener localeselectionlistener) {
        mListener = localeselectionlistener;
    }

    private static final boolean DEBUG = false;
    private static final String TAG = "LocalePicker";
    LocaleSelectionListener mListener;
}
