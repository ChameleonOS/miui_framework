// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.preference;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import com.android.internal.util.XmlUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.preference:
//            GenericInflater, Preference, PreferenceGroup, PreferenceManager

class PreferenceInflater extends GenericInflater {

    public PreferenceInflater(Context context, PreferenceManager preferencemanager) {
        super(context);
        init(preferencemanager);
    }

    PreferenceInflater(GenericInflater genericinflater, PreferenceManager preferencemanager, Context context) {
        super(genericinflater, context);
        init(preferencemanager);
    }

    private void init(PreferenceManager preferencemanager) {
        mPreferenceManager = preferencemanager;
        setDefaultPackage("android.preference.");
    }

    public GenericInflater cloneInContext(Context context) {
        return new PreferenceInflater(this, mPreferenceManager, context);
    }

    protected boolean onCreateCustomFromTag(XmlPullParser xmlpullparser, Preference preference, AttributeSet attributeset) throws XmlPullParserException {
        boolean flag = true;
        String s = xmlpullparser.getName();
        if(s.equals("intent")) {
            Intent intent;
            try {
                intent = Intent.parseIntent(getContext().getResources(), xmlpullparser, attributeset);
            }
            catch(IOException ioexception1) {
                XmlPullParserException xmlpullparserexception1 = new XmlPullParserException("Error parsing preference");
                xmlpullparserexception1.initCause(ioexception1);
                throw xmlpullparserexception1;
            }
            if(intent != null)
                preference.setIntent(intent);
        } else
        if(s.equals("extra")) {
            getContext().getResources().parseBundleExtra("extra", attributeset, preference.getExtras());
            try {
                XmlUtils.skipCurrentTag(xmlpullparser);
            }
            catch(IOException ioexception) {
                XmlPullParserException xmlpullparserexception = new XmlPullParserException("Error parsing preference");
                xmlpullparserexception.initCause(ioexception);
                throw xmlpullparserexception;
            }
        } else {
            flag = false;
        }
        return flag;
    }

    protected volatile boolean onCreateCustomFromTag(XmlPullParser xmlpullparser, Object obj, AttributeSet attributeset) throws XmlPullParserException {
        return onCreateCustomFromTag(xmlpullparser, (Preference)obj, attributeset);
    }

    protected volatile GenericInflater.Parent onMergeRoots(GenericInflater.Parent parent, boolean flag, GenericInflater.Parent parent1) {
        return onMergeRoots((PreferenceGroup)parent, flag, (PreferenceGroup)parent1);
    }

    protected PreferenceGroup onMergeRoots(PreferenceGroup preferencegroup, boolean flag, PreferenceGroup preferencegroup1) {
        if(preferencegroup == null)
            preferencegroup1.onAttachedToHierarchy(mPreferenceManager);
        else
            preferencegroup1 = preferencegroup;
        return preferencegroup1;
    }

    private static final String EXTRA_TAG_NAME = "extra";
    private static final String INTENT_TAG_NAME = "intent";
    private static final String TAG = "PreferenceInflater";
    private PreferenceManager mPreferenceManager;
}
