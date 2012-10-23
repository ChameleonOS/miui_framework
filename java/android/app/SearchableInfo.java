// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.*;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.*;
import java.io.IOException;
import java.util.*;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class SearchableInfo
    implements Parcelable {
    public static class ActionKeyInfo
        implements Parcelable {

        public int describeContents() {
            return 0;
        }

        public int getKeyCode() {
            return mKeyCode;
        }

        public String getQueryActionMsg() {
            return mQueryActionMsg;
        }

        public String getSuggestActionMsg() {
            return mSuggestActionMsg;
        }

        public String getSuggestActionMsgColumn() {
            return mSuggestActionMsgColumn;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(mKeyCode);
            parcel.writeString(mQueryActionMsg);
            parcel.writeString(mSuggestActionMsg);
            parcel.writeString(mSuggestActionMsgColumn);
        }

        private final int mKeyCode;
        private final String mQueryActionMsg;
        private final String mSuggestActionMsg;
        private final String mSuggestActionMsgColumn;

        ActionKeyInfo(Context context, AttributeSet attributeset) {
            TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.SearchableActionKey);
            mKeyCode = typedarray.getInt(0, 0);
            mQueryActionMsg = typedarray.getString(1);
            mSuggestActionMsg = typedarray.getString(2);
            mSuggestActionMsgColumn = typedarray.getString(3);
            typedarray.recycle();
            if(mKeyCode == 0)
                throw new IllegalArgumentException("No keycode.");
            if(mQueryActionMsg == null && mSuggestActionMsg == null && mSuggestActionMsgColumn == null)
                throw new IllegalArgumentException("No message information.");
            else
                return;
        }

        private ActionKeyInfo(Parcel parcel) {
            mKeyCode = parcel.readInt();
            mQueryActionMsg = parcel.readString();
            mSuggestActionMsg = parcel.readString();
            mSuggestActionMsgColumn = parcel.readString();
        }

    }


    private SearchableInfo(Context context, AttributeSet attributeset, ComponentName componentname) {
        mActionKeys = null;
        mSearchActivity = componentname;
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.Searchable);
        mSearchMode = typedarray.getInt(3, 0);
        mLabelId = typedarray.getResourceId(0, 0);
        mHintId = typedarray.getResourceId(2, 0);
        mIconId = typedarray.getResourceId(1, 0);
        mSearchButtonText = typedarray.getResourceId(9, 0);
        mSearchInputType = typedarray.getInt(10, 1);
        mSearchImeOptions = typedarray.getInt(16, 2);
        mIncludeInGlobalSearch = typedarray.getBoolean(18, false);
        mQueryAfterZeroResults = typedarray.getBoolean(19, false);
        mAutoUrlDetect = typedarray.getBoolean(21, false);
        mSettingsDescriptionId = typedarray.getResourceId(20, 0);
        mSuggestAuthority = typedarray.getString(4);
        mSuggestPath = typedarray.getString(5);
        mSuggestSelection = typedarray.getString(6);
        mSuggestIntentAction = typedarray.getString(7);
        mSuggestIntentData = typedarray.getString(8);
        mSuggestThreshold = typedarray.getInt(17, 0);
        mVoiceSearchMode = typedarray.getInt(11, 0);
        mVoiceLanguageModeId = typedarray.getResourceId(12, 0);
        mVoicePromptTextId = typedarray.getResourceId(13, 0);
        mVoiceLanguageId = typedarray.getResourceId(14, 0);
        mVoiceMaxResults = typedarray.getInt(15, 0);
        typedarray.recycle();
        String s = null;
        if(mSuggestAuthority != null) {
            android.content.pm.ProviderInfo providerinfo = context.getPackageManager().resolveContentProvider(mSuggestAuthority, 0);
            if(providerinfo != null)
                s = ((PackageItemInfo) (providerinfo)).packageName;
        }
        mSuggestProviderPackage = s;
        if(mLabelId == 0)
            throw new IllegalArgumentException("Search label must be a resource reference.");
        else
            return;
    }

    SearchableInfo(Parcel parcel) {
        boolean flag = true;
        super();
        mActionKeys = null;
        mLabelId = parcel.readInt();
        mSearchActivity = ComponentName.readFromParcel(parcel);
        mHintId = parcel.readInt();
        mSearchMode = parcel.readInt();
        mIconId = parcel.readInt();
        mSearchButtonText = parcel.readInt();
        mSearchInputType = parcel.readInt();
        mSearchImeOptions = parcel.readInt();
        boolean flag1;
        boolean flag2;
        if(parcel.readInt() != 0)
            flag1 = flag;
        else
            flag1 = false;
        mIncludeInGlobalSearch = flag1;
        if(parcel.readInt() != 0)
            flag2 = flag;
        else
            flag2 = false;
        mQueryAfterZeroResults = flag2;
        if(parcel.readInt() == 0)
            flag = false;
        mAutoUrlDetect = flag;
        mSettingsDescriptionId = parcel.readInt();
        mSuggestAuthority = parcel.readString();
        mSuggestPath = parcel.readString();
        mSuggestSelection = parcel.readString();
        mSuggestIntentAction = parcel.readString();
        mSuggestIntentData = parcel.readString();
        mSuggestThreshold = parcel.readInt();
        for(int i = parcel.readInt(); i > 0; i--)
            addActionKey(new ActionKeyInfo(parcel));

        mSuggestProviderPackage = parcel.readString();
        mVoiceSearchMode = parcel.readInt();
        mVoiceLanguageModeId = parcel.readInt();
        mVoicePromptTextId = parcel.readInt();
        mVoiceLanguageId = parcel.readInt();
        mVoiceMaxResults = parcel.readInt();
    }

    private void addActionKey(ActionKeyInfo actionkeyinfo) {
        if(mActionKeys == null)
            mActionKeys = new HashMap();
        mActionKeys.put(Integer.valueOf(actionkeyinfo.getKeyCode()), actionkeyinfo);
    }

    private static Context createActivityContext(Context context, ComponentName componentname) {
        Context context1 = null;
        Context context2 = context.createPackageContext(componentname.getPackageName(), 0);
        context1 = context2;
_L2:
        return context1;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        Log.e("SearchableInfo", (new StringBuilder()).append("Package not found ").append(componentname.getPackageName()).toString());
        continue; /* Loop/switch isn't completed */
        SecurityException securityexception;
        securityexception;
        Log.e("SearchableInfo", (new StringBuilder()).append("Can't make context for ").append(componentname.getPackageName()).toString(), securityexception);
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static SearchableInfo getActivityMetaData(Context context, ActivityInfo activityinfo) {
        XmlResourceParser xmlresourceparser = activityinfo.loadXmlMetaData(context.getPackageManager(), "android.app.searchable");
        SearchableInfo searchableinfo;
        if(xmlresourceparser == null) {
            searchableinfo = null;
        } else {
            searchableinfo = getActivityMetaData(context, ((XmlPullParser) (xmlresourceparser)), new ComponentName(((PackageItemInfo) (activityinfo)).packageName, ((PackageItemInfo) (activityinfo)).name));
            xmlresourceparser.close();
        }
        return searchableinfo;
    }

    private static SearchableInfo getActivityMetaData(Context context, XmlPullParser xmlpullparser, ComponentName componentname) {
        Context context1 = createActivityContext(context, componentname);
        if(context1 != null) goto _L2; else goto _L1
_L1:
        SearchableInfo searchableinfo = null;
_L8:
        return searchableinfo;
_L2:
        int i = xmlpullparser.next();
        int j;
        j = i;
        searchableinfo = null;
_L7:
        if(j == 1) goto _L4; else goto _L3
_L3:
        if(j != 2)
            break MISSING_BLOCK_LABEL_369;
        if(!xmlpullparser.getName().equals("searchable")) goto _L6; else goto _L5
_L5:
        AttributeSet attributeset1 = Xml.asAttributeSet(xmlpullparser);
        if(attributeset1 == null)
            break MISSING_BLOCK_LABEL_369;
        SearchableInfo searchableinfo1 = new SearchableInfo(context1, attributeset1, componentname);
_L11:
        int k = xmlpullparser.next();
        j = k;
        searchableinfo = searchableinfo1;
          goto _L7
        IllegalArgumentException illegalargumentexception1;
        illegalargumentexception1;
        Log.w("SearchableInfo", (new StringBuilder()).append("Invalid searchable metadata for ").append(componentname.flattenToShortString()).append(": ").append(illegalargumentexception1.getMessage()).toString());
        searchableinfo;
        searchableinfo = null;
          goto _L8
_L6:
        if(!xmlpullparser.getName().equals("actionkey"))
            break MISSING_BLOCK_LABEL_369;
        if(searchableinfo != null) goto _L10; else goto _L9
_L9:
        searchableinfo;
        searchableinfo = null;
          goto _L8
_L10:
        AttributeSet attributeset = Xml.asAttributeSet(xmlpullparser);
        if(attributeset == null)
            break MISSING_BLOCK_LABEL_369;
        searchableinfo.addActionKey(new ActionKeyInfo(context1, attributeset));
        searchableinfo1 = searchableinfo;
          goto _L11
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        Log.w("SearchableInfo", (new StringBuilder()).append("Invalid action key for ").append(componentname.flattenToShortString()).append(": ").append(illegalargumentexception.getMessage()).toString());
        searchableinfo;
        searchableinfo = null;
          goto _L8
        XmlPullParserException xmlpullparserexception;
        xmlpullparserexception;
_L13:
        Log.w("SearchableInfo", (new StringBuilder()).append("Reading searchable metadata for ").append(componentname.flattenToShortString()).toString(), xmlpullparserexception);
        searchableinfo = null;
          goto _L8
        IOException ioexception;
        ioexception;
_L12:
        Log.w("SearchableInfo", (new StringBuilder()).append("Reading searchable metadata for ").append(componentname.flattenToShortString()).toString(), ioexception);
        searchableinfo = null;
          goto _L8
_L4:
        searchableinfo;
          goto _L8
        ioexception;
        searchableinfo;
          goto _L12
        xmlpullparserexception;
        searchableinfo;
          goto _L13
        searchableinfo1 = searchableinfo;
          goto _L11
    }

    public boolean autoUrlDetect() {
        return mAutoUrlDetect;
    }

    public int describeContents() {
        return 0;
    }

    public ActionKeyInfo findActionKey(int i) {
        ActionKeyInfo actionkeyinfo;
        if(mActionKeys == null)
            actionkeyinfo = null;
        else
            actionkeyinfo = (ActionKeyInfo)mActionKeys.get(Integer.valueOf(i));
        return actionkeyinfo;
    }

    public Context getActivityContext(Context context) {
        return createActivityContext(context, mSearchActivity);
    }

    public int getHintId() {
        return mHintId;
    }

    public int getIconId() {
        return mIconId;
    }

    public int getImeOptions() {
        return mSearchImeOptions;
    }

    public int getInputType() {
        return mSearchInputType;
    }

    public int getLabelId() {
        return mLabelId;
    }

    public Context getProviderContext(Context context, Context context1) {
        Context context2 = null;
        if(!mSearchActivity.getPackageName().equals(mSuggestProviderPackage)) goto _L2; else goto _L1
_L1:
        return context1;
_L2:
        if(mSuggestProviderPackage == null)
            break MISSING_BLOCK_LABEL_42;
        Context context3 = context.createPackageContext(mSuggestProviderPackage, 0);
        context2 = context3;
_L4:
        context1 = context2;
        if(true) goto _L1; else goto _L3
_L3:
        SecurityException securityexception;
        securityexception;
          goto _L4
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
          goto _L4
    }

    public ComponentName getSearchActivity() {
        return mSearchActivity;
    }

    public int getSearchButtonText() {
        return mSearchButtonText;
    }

    public int getSettingsDescriptionId() {
        return mSettingsDescriptionId;
    }

    public String getSuggestAuthority() {
        return mSuggestAuthority;
    }

    public String getSuggestIntentAction() {
        return mSuggestIntentAction;
    }

    public String getSuggestIntentData() {
        return mSuggestIntentData;
    }

    public String getSuggestPackage() {
        return mSuggestProviderPackage;
    }

    public String getSuggestPath() {
        return mSuggestPath;
    }

    public String getSuggestSelection() {
        return mSuggestSelection;
    }

    public int getSuggestThreshold() {
        return mSuggestThreshold;
    }

    public int getVoiceLanguageId() {
        return mVoiceLanguageId;
    }

    public int getVoiceLanguageModeId() {
        return mVoiceLanguageModeId;
    }

    public int getVoiceMaxResults() {
        return mVoiceMaxResults;
    }

    public int getVoicePromptTextId() {
        return mVoicePromptTextId;
    }

    public boolean getVoiceSearchEnabled() {
        boolean flag;
        if((1 & mVoiceSearchMode) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean getVoiceSearchLaunchRecognizer() {
        boolean flag;
        if((4 & mVoiceSearchMode) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean getVoiceSearchLaunchWebSearch() {
        boolean flag;
        if((2 & mVoiceSearchMode) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean queryAfterZeroResults() {
        return mQueryAfterZeroResults;
    }

    public boolean shouldIncludeInGlobalSearch() {
        return mIncludeInGlobalSearch;
    }

    public boolean shouldRewriteQueryFromData() {
        boolean flag;
        if((0x10 & mSearchMode) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean shouldRewriteQueryFromText() {
        boolean flag;
        if((0x20 & mSearchMode) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean useBadgeIcon() {
        boolean flag;
        if((8 & mSearchMode) != 0 && mIconId != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean useBadgeLabel() {
        boolean flag;
        if((4 & mSearchMode) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int j = 1;
        parcel.writeInt(mLabelId);
        mSearchActivity.writeToParcel(parcel, i);
        parcel.writeInt(mHintId);
        parcel.writeInt(mSearchMode);
        parcel.writeInt(mIconId);
        parcel.writeInt(mSearchButtonText);
        parcel.writeInt(mSearchInputType);
        parcel.writeInt(mSearchImeOptions);
        int k;
        int l;
        if(mIncludeInGlobalSearch)
            k = j;
        else
            k = 0;
        parcel.writeInt(k);
        if(mQueryAfterZeroResults)
            l = j;
        else
            l = 0;
        parcel.writeInt(l);
        if(!mAutoUrlDetect)
            j = 0;
        parcel.writeInt(j);
        parcel.writeInt(mSettingsDescriptionId);
        parcel.writeString(mSuggestAuthority);
        parcel.writeString(mSuggestPath);
        parcel.writeString(mSuggestSelection);
        parcel.writeString(mSuggestIntentAction);
        parcel.writeString(mSuggestIntentData);
        parcel.writeInt(mSuggestThreshold);
        if(mActionKeys == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(mActionKeys.size());
            Iterator iterator = mActionKeys.values().iterator();
            while(iterator.hasNext()) 
                ((ActionKeyInfo)iterator.next()).writeToParcel(parcel, i);
        }
        parcel.writeString(mSuggestProviderPackage);
        parcel.writeInt(mVoiceSearchMode);
        parcel.writeInt(mVoiceLanguageModeId);
        parcel.writeInt(mVoicePromptTextId);
        parcel.writeInt(mVoiceLanguageId);
        parcel.writeInt(mVoiceMaxResults);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SearchableInfo createFromParcel(Parcel parcel) {
            return new SearchableInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public SearchableInfo[] newArray(int i) {
            return new SearchableInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final boolean DBG = false;
    private static final String LOG_TAG = "SearchableInfo";
    private static final String MD_LABEL_SEARCHABLE = "android.app.searchable";
    private static final String MD_XML_ELEMENT_SEARCHABLE = "searchable";
    private static final String MD_XML_ELEMENT_SEARCHABLE_ACTION_KEY = "actionkey";
    private static final int SEARCH_MODE_BADGE_ICON = 8;
    private static final int SEARCH_MODE_BADGE_LABEL = 4;
    private static final int SEARCH_MODE_QUERY_REWRITE_FROM_DATA = 16;
    private static final int SEARCH_MODE_QUERY_REWRITE_FROM_TEXT = 32;
    private static final int VOICE_SEARCH_LAUNCH_RECOGNIZER = 4;
    private static final int VOICE_SEARCH_LAUNCH_WEB_SEARCH = 2;
    private static final int VOICE_SEARCH_SHOW_BUTTON = 1;
    private HashMap mActionKeys;
    private final boolean mAutoUrlDetect;
    private final int mHintId;
    private final int mIconId;
    private final boolean mIncludeInGlobalSearch;
    private final int mLabelId;
    private final boolean mQueryAfterZeroResults;
    private final ComponentName mSearchActivity;
    private final int mSearchButtonText;
    private final int mSearchImeOptions;
    private final int mSearchInputType;
    private final int mSearchMode;
    private final int mSettingsDescriptionId;
    private final String mSuggestAuthority;
    private final String mSuggestIntentAction;
    private final String mSuggestIntentData;
    private final String mSuggestPath;
    private final String mSuggestProviderPackage;
    private final String mSuggestSelection;
    private final int mSuggestThreshold;
    private final int mVoiceLanguageId;
    private final int mVoiceLanguageModeId;
    private final int mVoiceMaxResults;
    private final int mVoicePromptTextId;
    private final int mVoiceSearchMode;

}
