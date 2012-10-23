// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.preference;

import android.app.*;
import android.content.Context;
import android.content.Intent;
import android.content.res.*;
import android.os.*;
import android.text.TextUtils;
import android.util.TypedValue;
import android.util.Xml;
import android.view.*;
import android.widget.*;
import com.android.internal.util.XmlUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.preference:
//            PreferenceScreen, PreferenceManager, Preference, PreferenceFragment

public abstract class PreferenceActivity extends ListActivity
    implements PreferenceManager.OnPreferenceTreeClickListener, PreferenceFragment.OnPreferenceStartFragmentCallback {
    public static final class Header
        implements Parcelable {

        public int describeContents() {
            return 0;
        }

        public CharSequence getBreadCrumbShortTitle(Resources resources) {
            CharSequence charsequence;
            if(breadCrumbShortTitleRes != 0)
                charsequence = resources.getText(breadCrumbShortTitleRes);
            else
                charsequence = breadCrumbShortTitle;
            return charsequence;
        }

        public CharSequence getBreadCrumbTitle(Resources resources) {
            CharSequence charsequence;
            if(breadCrumbTitleRes != 0)
                charsequence = resources.getText(breadCrumbTitleRes);
            else
                charsequence = breadCrumbTitle;
            return charsequence;
        }

        public CharSequence getSummary(Resources resources) {
            CharSequence charsequence;
            if(summaryRes != 0)
                charsequence = resources.getText(summaryRes);
            else
                charsequence = summary;
            return charsequence;
        }

        public CharSequence getTitle(Resources resources) {
            CharSequence charsequence;
            if(titleRes != 0)
                charsequence = resources.getText(titleRes);
            else
                charsequence = title;
            return charsequence;
        }

        public void readFromParcel(Parcel parcel) {
            id = parcel.readLong();
            titleRes = parcel.readInt();
            title = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            summaryRes = parcel.readInt();
            summary = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            breadCrumbTitleRes = parcel.readInt();
            breadCrumbTitle = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            breadCrumbShortTitleRes = parcel.readInt();
            breadCrumbShortTitle = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            iconRes = parcel.readInt();
            fragment = parcel.readString();
            fragmentArguments = parcel.readBundle();
            if(parcel.readInt() != 0)
                intent = (Intent)Intent.CREATOR.createFromParcel(parcel);
            extras = parcel.readBundle();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(id);
            parcel.writeInt(titleRes);
            TextUtils.writeToParcel(title, parcel, i);
            parcel.writeInt(summaryRes);
            TextUtils.writeToParcel(summary, parcel, i);
            parcel.writeInt(breadCrumbTitleRes);
            TextUtils.writeToParcel(breadCrumbTitle, parcel, i);
            parcel.writeInt(breadCrumbShortTitleRes);
            TextUtils.writeToParcel(breadCrumbShortTitle, parcel, i);
            parcel.writeInt(iconRes);
            parcel.writeString(fragment);
            parcel.writeBundle(fragmentArguments);
            if(intent != null) {
                parcel.writeInt(1);
                intent.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeBundle(extras);
        }

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public Header createFromParcel(Parcel parcel) {
                return new Header(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public Header[] newArray(int i) {
                return new Header[i];
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

        };
        public CharSequence breadCrumbShortTitle;
        public int breadCrumbShortTitleRes;
        public CharSequence breadCrumbTitle;
        public int breadCrumbTitleRes;
        public Bundle extras;
        public String fragment;
        public Bundle fragmentArguments;
        public int iconRes;
        public long id;
        public Intent intent;
        public CharSequence summary;
        public int summaryRes;
        public CharSequence title;
        public int titleRes;


        public Header() {
            id = -1L;
        }

        Header(Parcel parcel) {
            id = -1L;
            readFromParcel(parcel);
        }
    }

    private static class HeaderAdapter extends ArrayAdapter {
        private static class HeaderViewHolder {

            ImageView icon;
            TextView summary;
            TextView title;

            private HeaderViewHolder() {
            }

        }


        public View getView(int i, View view, ViewGroup viewgroup) {
            View view1;
            HeaderViewHolder headerviewholder;
            Header header;
            CharSequence charsequence;
            if(view == null) {
                view1 = mInflater.inflate(0x1090083, viewgroup, false);
                headerviewholder = new HeaderViewHolder();
                headerviewholder.icon = (ImageView)view1.findViewById(0x1020006);
                headerviewholder.title = (TextView)view1.findViewById(0x1020016);
                headerviewholder.summary = (TextView)view1.findViewById(0x1020010);
                view1.setTag(headerviewholder);
            } else {
                view1 = view;
                headerviewholder = (HeaderViewHolder)view1.getTag();
            }
            header = (Header)getItem(i);
            headerviewholder.icon.setImageResource(header.iconRes);
            headerviewholder.title.setText(header.getTitle(getContext().getResources()));
            charsequence = header.getSummary(getContext().getResources());
            if(!TextUtils.isEmpty(charsequence)) {
                headerviewholder.summary.setVisibility(0);
                headerviewholder.summary.setText(charsequence);
            } else {
                headerviewholder.summary.setVisibility(8);
            }
            return view1;
        }

        private LayoutInflater mInflater;

        public HeaderAdapter(Context context, List list) {
            super(context, 0, list);
            mInflater = (LayoutInflater)context.getSystemService("layout_inflater");
        }
    }


    public PreferenceActivity() {
        mHandler = new Handler() ;
    }

    private void bindPreferences() {
        PreferenceScreen preferencescreen = getPreferenceScreen();
        if(preferencescreen != null) {
            preferencescreen.bind(getListView());
            if(mSavedInstanceState != null) {
                onRestoreInstanceState(mSavedInstanceState);
                mSavedInstanceState = null;
            }
        }
    }

    private void postBindPreferences() {
        if(!mHandler.hasMessages(1))
            mHandler.obtainMessage(1).sendToTarget();
    }

    private void requirePreferenceManager() {
        if(mPreferenceManager == null) {
            if(super.mAdapter == null)
                throw new RuntimeException("This should be called after super.onCreate.");
            else
                throw new RuntimeException("Modern two-pane PreferenceActivity requires use of a PreferenceFragment");
        } else {
            return;
        }
    }

    private void switchToHeaderInner(String s, Bundle bundle, int i) {
        getFragmentManager().popBackStack(":android:prefs", 1);
        Fragment fragment = Fragment.instantiate(this, s, bundle);
        FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
        fragmenttransaction.setTransition(4099);
        fragmenttransaction.replace(0x1020303, fragment);
        fragmenttransaction.commitAllowingStateLoss();
    }

    public void addPreferencesFromIntent(Intent intent) {
        requirePreferenceManager();
        setPreferenceScreen(mPreferenceManager.inflateFromIntent(intent, getPreferenceScreen()));
    }

    public void addPreferencesFromResource(int i) {
        requirePreferenceManager();
        setPreferenceScreen(mPreferenceManager.inflateFromResource(this, i, getPreferenceScreen()));
    }

    Header findBestMatchingHeader(Header header, ArrayList arraylist) {
        ArrayList arraylist1;
        int i;
        arraylist1 = new ArrayList();
        i = 0;
_L7:
        if(i >= arraylist.size()) goto _L2; else goto _L1
_L1:
        Header header2 = (Header)arraylist.get(i);
        if(header != header2 && (header.id == -1L || header.id != header2.id)) goto _L4; else goto _L3
_L3:
        arraylist1.clear();
        arraylist1.add(header2);
_L2:
        int j = arraylist1.size();
        if(j != 1) goto _L6; else goto _L5
_L5:
        Header header1 = (Header)arraylist1.get(0);
_L9:
        return header1;
_L4:
        if(header.fragment != null) {
            if(header.fragment.equals(header2.fragment))
                arraylist1.add(header2);
        } else
        if(header.intent != null) {
            if(header.intent.equals(header2.intent))
                arraylist1.add(header2);
        } else
        if(header.title != null && header.title.equals(header2.title))
            arraylist1.add(header2);
        i++;
          goto _L7
_L6:
        int k;
        if(j <= 1)
            break MISSING_BLOCK_LABEL_295;
        k = 0;
_L10:
        if(k >= j)
            break MISSING_BLOCK_LABEL_295;
        header1 = (Header)arraylist1.get(k);
        if(header.fragmentArguments != null && header.fragmentArguments.equals(header1.fragmentArguments) || header.extras != null && header.extras.equals(header1.extras) || header.title != null && header.title.equals(header1.title)) goto _L9; else goto _L8
_L8:
        k++;
          goto _L10
        header1 = null;
          goto _L9
    }

    public Preference findPreference(CharSequence charsequence) {
        Preference preference;
        if(mPreferenceManager == null)
            preference = null;
        else
            preference = mPreferenceManager.findPreference(charsequence);
        return preference;
    }

    public void finishPreferencePanel(Fragment fragment, int i, Intent intent) {
        if(!mSinglePane) goto _L2; else goto _L1
_L1:
        setResult(i, intent);
        finish();
_L4:
        return;
_L2:
        onBackPressed();
        if(fragment != null && fragment.getTargetFragment() != null)
            fragment.getTargetFragment().onActivityResult(fragment.getTargetRequestCode(), i, intent);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public List getHeaders() {
        return mHeaders;
    }

    protected Button getNextButton() {
        return mNextButton;
    }

    public PreferenceManager getPreferenceManager() {
        return mPreferenceManager;
    }

    public PreferenceScreen getPreferenceScreen() {
        PreferenceScreen preferencescreen;
        if(mPreferenceManager != null)
            preferencescreen = mPreferenceManager.getPreferenceScreen();
        else
            preferencescreen = null;
        return preferencescreen;
    }

    public boolean hasHeaders() {
        boolean flag;
        if(getListView().getVisibility() == 0 && mPreferenceManager == null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    protected boolean hasNextButton() {
        boolean flag;
        if(mNextButton != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void invalidateHeaders() {
        if(!mHandler.hasMessages(2))
            mHandler.sendEmptyMessage(2);
    }

    public boolean isMultiPane() {
        boolean flag;
        if(hasHeaders() && mPrefsContainer.getVisibility() == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void loadHeadersFromResource(int i, List list) {
        XmlResourceParser xmlresourceparser = null;
        android.util.AttributeSet attributeset;
        xmlresourceparser = getResources().getXml(i);
        attributeset = Xml.asAttributeSet(xmlresourceparser);
        int j;
        do
            j = xmlresourceparser.next();
        while(j != 1 && j != 2);
        String s = xmlresourceparser.getName();
        if(!"preference-headers".equals(s))
            throw new RuntimeException((new StringBuilder()).append("XML document must start with <preference-headers> tag; found").append(s).append(" at ").append(xmlresourceparser.getPositionDescription()).toString());
        break MISSING_BLOCK_LABEL_130;
        XmlPullParserException xmlpullparserexception;
        xmlpullparserexception;
        throw new RuntimeException("Error parsing headers", xmlpullparserexception);
        Exception exception;
        exception;
        if(xmlresourceparser != null)
            xmlresourceparser.close();
        throw exception;
        Bundle bundle = null;
        int k = xmlresourceparser.getDepth();
_L23:
        Header header;
        TypedArray typedarray;
        TypedValue typedvalue;
        int l;
        do {
            l = xmlresourceparser.next();
            if(l == 1 || l == 3 && xmlresourceparser.getDepth() <= k)
                break MISSING_BLOCK_LABEL_670;
        } while(l == 3 || l == 4);
        if(!"header".equals(xmlresourceparser.getName()))
            break MISSING_BLOCK_LABEL_663;
        header = new Header();
        typedarray = getResources().obtainAttributes(attributeset, com.android.internal.R.styleable.PreferenceHeader);
        header.id = typedarray.getResourceId(1, -1);
        typedvalue = typedarray.peekValue(2);
        if(typedvalue == null || typedvalue.type != 3) goto _L2; else goto _L1
_L1:
        if(typedvalue.resourceId == 0) goto _L4; else goto _L3
_L3:
        header.titleRes = typedvalue.resourceId;
_L2:
        TypedValue typedvalue1 = typedarray.peekValue(3);
        if(typedvalue1 == null || typedvalue1.type != 3) goto _L6; else goto _L5
_L5:
        if(typedvalue1.resourceId == 0) goto _L8; else goto _L7
_L7:
        header.summaryRes = typedvalue1.resourceId;
_L6:
        TypedValue typedvalue2 = typedarray.peekValue(5);
        if(typedvalue2 == null || typedvalue2.type != 3) goto _L10; else goto _L9
_L9:
        if(typedvalue2.resourceId == 0) goto _L12; else goto _L11
_L11:
        header.breadCrumbTitleRes = typedvalue2.resourceId;
_L10:
        TypedValue typedvalue3 = typedarray.peekValue(6);
        if(typedvalue3 == null || typedvalue3.type != 3) goto _L14; else goto _L13
_L13:
        if(typedvalue3.resourceId == 0) goto _L16; else goto _L15
_L15:
        header.breadCrumbShortTitleRes = typedvalue3.resourceId;
_L14:
        int i1;
        header.iconRes = typedarray.getResourceId(0, 0);
        header.fragment = typedarray.getString(4);
        typedarray.recycle();
        if(bundle == null)
            bundle = new Bundle();
        i1 = xmlresourceparser.getDepth();
_L20:
        int j1 = xmlresourceparser.next();
        if(j1 == 1 || j1 == 3 && xmlresourceparser.getDepth() <= i1) goto _L18; else goto _L17
_L17:
        if(j1 == 3 || j1 == 4) goto _L20; else goto _L19
_L19:
        String s1 = xmlresourceparser.getName();
        if(!s1.equals("extra")) goto _L22; else goto _L21
_L21:
        getResources().parseBundleExtra("extra", attributeset, bundle);
        XmlUtils.skipCurrentTag(xmlresourceparser);
          goto _L20
        IOException ioexception;
        ioexception;
        throw new RuntimeException("Error parsing headers", ioexception);
_L4:
        header.title = typedvalue.string;
          goto _L2
_L8:
        header.summary = typedvalue1.string;
          goto _L6
_L12:
        header.breadCrumbTitle = typedvalue2.string;
          goto _L10
_L16:
        header.breadCrumbShortTitle = typedvalue3.string;
          goto _L14
_L22:
        if(s1.equals("intent"))
            header.intent = Intent.parseIntent(getResources(), xmlresourceparser, attributeset);
        else
            XmlUtils.skipCurrentTag(xmlresourceparser);
          goto _L20
_L18:
        if(bundle.size() > 0) {
            header.fragmentArguments = bundle;
            bundle = null;
        }
        list.add(header);
          goto _L23
        XmlUtils.skipCurrentTag(xmlresourceparser);
          goto _L23
        if(xmlresourceparser != null)
            xmlresourceparser.close();
        return;
    }

    protected void onActivityResult(int i, int j, Intent intent) {
        onActivityResult(i, j, intent);
        if(mPreferenceManager != null)
            mPreferenceManager.dispatchActivityResult(i, j, intent);
    }

    public void onBuildHeaders(List list) {
    }

    public Intent onBuildStartFragmentIntent(String s, Bundle bundle, int i, int j) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setClass(this, getClass());
        intent.putExtra(":android:show_fragment", s);
        intent.putExtra(":android:show_fragment_args", bundle);
        intent.putExtra(":android:show_fragment_title", i);
        intent.putExtra(":android:show_fragment_short_title", j);
        intent.putExtra(":android:no_headers", true);
        return intent;
    }

    public void onContentChanged() {
        onContentChanged();
        if(mPreferenceManager != null)
            postBindPreferences();
    }

    protected void onCreate(Bundle bundle) {
        onCreate(bundle);
        setContentView(0x1090087);
        mListFooter = (FrameLayout)findViewById(0x1020301);
        mPrefsContainer = (ViewGroup)findViewById(0x1020302);
        boolean flag;
        String s;
        Bundle bundle1;
        int i;
        int j;
        if(onIsHidingHeaders() || !onIsMultiPane())
            flag = true;
        else
            flag = false;
        mSinglePane = flag;
        s = getIntent().getStringExtra(":android:show_fragment");
        bundle1 = getIntent().getBundleExtra(":android:show_fragment_args");
        i = getIntent().getIntExtra(":android:show_fragment_title", 0);
        j = getIntent().getIntExtra(":android:show_fragment_short_title", 0);
        if(bundle != null) {
            ArrayList arraylist = bundle.getParcelableArrayList(":android:headers");
            if(arraylist != null) {
                mHeaders.addAll(arraylist);
                int k = bundle.getInt(":android:cur_header", -1);
                if(k >= 0 && k < mHeaders.size())
                    setSelectedHeader((Header)mHeaders.get(k));
            }
        } else
        if(s != null && mSinglePane) {
            switchToHeader(s, bundle1);
            if(i != 0) {
                CharSequence charsequence2 = getText(i);
                CharSequence charsequence3;
                if(j != 0)
                    charsequence3 = getText(j);
                else
                    charsequence3 = null;
                showBreadCrumbs(charsequence2, charsequence3);
            }
        } else {
            onBuildHeaders(mHeaders);
            if(mHeaders.size() > 0 && !mSinglePane)
                if(s == null)
                    switchToHeader(onGetInitialHeader());
                else
                    switchToHeader(s, bundle1);
        }
        if(s != null && mSinglePane) {
            findViewById(0x1020300).setVisibility(8);
            mPrefsContainer.setVisibility(0);
            if(i != 0) {
                CharSequence charsequence = getText(i);
                Intent intent;
                android.view.View.OnClickListener onclicklistener;
                Button button1;
                android.view.View.OnClickListener onclicklistener1;
                Button button2;
                android.view.View.OnClickListener onclicklistener2;
                CharSequence charsequence1;
                if(j != 0)
                    charsequence1 = getText(j);
                else
                    charsequence1 = null;
                showBreadCrumbs(charsequence, charsequence1);
            }
        } else
        if(mHeaders.size() > 0) {
            HeaderAdapter headeradapter = new HeaderAdapter(this, mHeaders);
            setListAdapter(headeradapter);
            if(!mSinglePane) {
                getListView().setChoiceMode(1);
                if(mCurHeader != null)
                    setSelectedHeader(mCurHeader);
                mPrefsContainer.setVisibility(0);
            }
        } else {
            setContentView(0x1090088);
            mListFooter = (FrameLayout)findViewById(0x1020301);
            mPrefsContainer = (ViewGroup)findViewById(0x1020303);
            PreferenceManager preferencemanager = new PreferenceManager(this, 100);
            mPreferenceManager = preferencemanager;
            mPreferenceManager.setOnPreferenceTreeClickListener(this);
        }
        intent = getIntent();
        if(intent.getBooleanExtra("extra_prefs_show_button_bar", false)) {
            findViewById(0x102026d).setVisibility(0);
            Button button = (Button)findViewById(0x1020304);
            onclicklistener = new android.view.View.OnClickListener() {

                public void onClick(View view) {
                    setResult(0);
                    finish();
                }

                final PreferenceActivity this$0;

             {
                this$0 = PreferenceActivity.this;
                super();
            }
            };
            button.setOnClickListener(onclicklistener);
            button1 = (Button)findViewById(0x1020305);
            onclicklistener1 = new android.view.View.OnClickListener() {

                public void onClick(View view) {
                    setResult(-1);
                    finish();
                }

                final PreferenceActivity this$0;

             {
                this$0 = PreferenceActivity.this;
                super();
            }
            };
            button1.setOnClickListener(onclicklistener1);
            mNextButton = (Button)findViewById(0x1020306);
            button2 = mNextButton;
            onclicklistener2 = new android.view.View.OnClickListener() {

                public void onClick(View view) {
                    setResult(-1);
                    finish();
                }

                final PreferenceActivity this$0;

             {
                this$0 = PreferenceActivity.this;
                super();
            }
            };
            button2.setOnClickListener(onclicklistener2);
            if(intent.hasExtra("extra_prefs_set_next_text")) {
                String s2 = intent.getStringExtra("extra_prefs_set_next_text");
                if(TextUtils.isEmpty(s2))
                    mNextButton.setVisibility(8);
                else
                    mNextButton.setText(s2);
            }
            if(intent.hasExtra("extra_prefs_set_back_text")) {
                String s1 = intent.getStringExtra("extra_prefs_set_back_text");
                if(TextUtils.isEmpty(s1))
                    button.setVisibility(8);
                else
                    button.setText(s1);
            }
            if(intent.getBooleanExtra("extra_prefs_show_skip", false))
                button1.setVisibility(0);
        }
    }

    protected void onDestroy() {
        onDestroy();
        if(mPreferenceManager != null)
            mPreferenceManager.dispatchActivityDestroy();
    }

    public Header onGetInitialHeader() {
        return (Header)mHeaders.get(0);
    }

    public Header onGetNewHeader() {
        return null;
    }

    public void onHeaderClick(Header header, int i) {
        if(header.fragment == null) goto _L2; else goto _L1
_L1:
        if(mSinglePane) {
            int j = header.breadCrumbTitleRes;
            int k = header.breadCrumbShortTitleRes;
            if(j == 0) {
                j = header.titleRes;
                k = 0;
            }
            startWithFragment(header.fragment, header.fragmentArguments, null, 0, j, k);
        } else {
            switchToHeader(header);
        }
_L4:
        return;
_L2:
        if(header.intent != null)
            startActivity(header.intent);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean onIsHidingHeaders() {
        return getIntent().getBooleanExtra(":android:no_headers", false);
    }

    public boolean onIsMultiPane() {
        return getResources().getBoolean(0x1110003);
    }

    protected void onListItemClick(ListView listview, View view, int i, long l) {
        onListItemClick(listview, view, i, l);
        if(super.mAdapter != null) {
            Object obj = super.mAdapter.getItem(i);
            if(obj instanceof Header)
                onHeaderClick((Header)obj, i);
        }
    }

    protected void onNewIntent(Intent intent) {
        if(mPreferenceManager != null)
            mPreferenceManager.dispatchNewIntent(intent);
    }

    public boolean onPreferenceStartFragment(PreferenceFragment preferencefragment, Preference preference) {
        startPreferencePanel(preference.getFragment(), preference.getExtras(), preference.getTitleRes(), preference.getTitle(), null, 0);
        return true;
    }

    public boolean onPreferenceTreeClick(PreferenceScreen preferencescreen, Preference preference) {
        return false;
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        if(mPreferenceManager == null) goto _L2; else goto _L1
_L1:
        Bundle bundle1 = bundle.getBundle(":android:preferences");
        if(bundle1 == null) goto _L2; else goto _L3
_L3:
        PreferenceScreen preferencescreen = getPreferenceScreen();
        if(preferencescreen == null) goto _L2; else goto _L4
_L4:
        preferencescreen.restoreHierarchyState(bundle1);
        mSavedInstanceState = bundle;
_L6:
        return;
_L2:
        onRestoreInstanceState(bundle);
        if(true) goto _L6; else goto _L5
_L5:
    }

    protected void onSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        if(mHeaders.size() > 0) {
            bundle.putParcelableArrayList(":android:headers", mHeaders);
            if(mCurHeader != null) {
                int i = mHeaders.indexOf(mCurHeader);
                if(i >= 0)
                    bundle.putInt(":android:cur_header", i);
            }
        }
        if(mPreferenceManager != null) {
            PreferenceScreen preferencescreen = getPreferenceScreen();
            if(preferencescreen != null) {
                Bundle bundle1 = new Bundle();
                preferencescreen.saveHierarchyState(bundle1);
                bundle.putBundle(":android:preferences", bundle1);
            }
        }
    }

    protected void onStop() {
        onStop();
        if(mPreferenceManager != null)
            mPreferenceManager.dispatchActivityStop();
    }

    public void setListFooter(View view) {
        mListFooter.removeAllViews();
        mListFooter.addView(view, new LayoutParams(-1, -2));
    }

    public void setParentTitle(CharSequence charsequence, CharSequence charsequence1, android.view.View.OnClickListener onclicklistener) {
        if(mFragmentBreadCrumbs != null)
            mFragmentBreadCrumbs.setParentTitle(charsequence, charsequence1, onclicklistener);
    }

    public void setPreferenceScreen(PreferenceScreen preferencescreen) {
        requirePreferenceManager();
        if(mPreferenceManager.setPreferences(preferencescreen) && preferencescreen != null) {
            postBindPreferences();
            CharSequence charsequence = getPreferenceScreen().getTitle();
            if(charsequence != null)
                setTitle(charsequence);
        }
    }

    void setSelectedHeader(Header header) {
        mCurHeader = header;
        int i = mHeaders.indexOf(header);
        if(i >= 0)
            getListView().setItemChecked(i, true);
        else
            getListView().clearChoices();
        showBreadCrumbs(header);
    }

    void showBreadCrumbs(Header header) {
        if(header != null) {
            CharSequence charsequence = header.getBreadCrumbTitle(getResources());
            if(charsequence == null)
                charsequence = header.getTitle(getResources());
            if(charsequence == null)
                charsequence = getTitle();
            showBreadCrumbs(charsequence, header.getBreadCrumbShortTitle(getResources()));
        } else {
            showBreadCrumbs(getTitle(), null);
        }
    }

    public void showBreadCrumbs(CharSequence charsequence, CharSequence charsequence1) {
        if(mFragmentBreadCrumbs != null) goto _L2; else goto _L1
_L1:
        View view = findViewById(0x1020016);
        try {
            mFragmentBreadCrumbs = (FragmentBreadCrumbs)view;
        }
        catch(ClassCastException classcastexception) {
            continue; /* Loop/switch isn't completed */
        }
        if(mFragmentBreadCrumbs != null) goto _L4; else goto _L3
_L3:
        if(charsequence != null)
            setTitle(charsequence);
_L6:
        return;
_L4:
        mFragmentBreadCrumbs.setMaxVisible(2);
        mFragmentBreadCrumbs.setActivity(this);
_L2:
        mFragmentBreadCrumbs.setTitle(charsequence, charsequence1);
        mFragmentBreadCrumbs.setParentTitle(null, null, null);
        if(true) goto _L6; else goto _L5
_L5:
    }

    public void startPreferenceFragment(Fragment fragment, boolean flag) {
        FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
        fragmenttransaction.replace(0x1020303, fragment);
        if(flag) {
            fragmenttransaction.setTransition(4097);
            fragmenttransaction.addToBackStack(":android:prefs");
        } else {
            fragmenttransaction.setTransition(4099);
        }
        fragmenttransaction.commitAllowingStateLoss();
    }

    public void startPreferencePanel(String s, Bundle bundle, int i, CharSequence charsequence, Fragment fragment, int j) {
        if(!mSinglePane) goto _L2; else goto _L1
_L1:
        startWithFragment(s, bundle, fragment, j, i, 0);
_L4:
        return;
_L2:
        FragmentTransaction fragmenttransaction;
        Fragment fragment1 = Fragment.instantiate(this, s, bundle);
        if(fragment != null)
            fragment1.setTargetFragment(fragment, j);
        fragmenttransaction = getFragmentManager().beginTransaction();
        fragmenttransaction.replace(0x1020303, fragment1);
        if(i == 0)
            break; /* Loop/switch isn't completed */
        fragmenttransaction.setBreadCrumbTitle(i);
_L6:
        fragmenttransaction.setTransition(4097);
        fragmenttransaction.addToBackStack(":android:prefs");
        fragmenttransaction.commitAllowingStateLoss();
        if(true) goto _L4; else goto _L3
_L3:
        if(charsequence == null) goto _L6; else goto _L5
_L5:
        fragmenttransaction.setBreadCrumbTitle(charsequence);
          goto _L6
    }

    public void startWithFragment(String s, Bundle bundle, Fragment fragment, int i) {
        startWithFragment(s, bundle, fragment, i, 0, 0);
    }

    public void startWithFragment(String s, Bundle bundle, Fragment fragment, int i, int j, int k) {
        Intent intent = onBuildStartFragmentIntent(s, bundle, j, k);
        if(fragment == null)
            startActivity(intent);
        else
            fragment.startActivityForResult(intent, i);
    }

    public void switchToHeader(Header header) {
        if(mCurHeader == header) {
            getFragmentManager().popBackStack(":android:prefs", 1);
        } else {
            int i = mHeaders.indexOf(header) - mHeaders.indexOf(mCurHeader);
            switchToHeaderInner(header.fragment, header.fragmentArguments, i);
            setSelectedHeader(header);
        }
    }

    public void switchToHeader(String s, Bundle bundle) {
        setSelectedHeader(null);
        switchToHeaderInner(s, bundle, 0);
    }

    private static final String BACK_STACK_PREFS = ":android:prefs";
    private static final String CUR_HEADER_TAG = ":android:cur_header";
    public static final String EXTRA_NO_HEADERS = ":android:no_headers";
    private static final String EXTRA_PREFS_SET_BACK_TEXT = "extra_prefs_set_back_text";
    private static final String EXTRA_PREFS_SET_NEXT_TEXT = "extra_prefs_set_next_text";
    private static final String EXTRA_PREFS_SHOW_BUTTON_BAR = "extra_prefs_show_button_bar";
    private static final String EXTRA_PREFS_SHOW_SKIP = "extra_prefs_show_skip";
    public static final String EXTRA_SHOW_FRAGMENT = ":android:show_fragment";
    public static final String EXTRA_SHOW_FRAGMENT_ARGUMENTS = ":android:show_fragment_args";
    public static final String EXTRA_SHOW_FRAGMENT_SHORT_TITLE = ":android:show_fragment_short_title";
    public static final String EXTRA_SHOW_FRAGMENT_TITLE = ":android:show_fragment_title";
    private static final int FIRST_REQUEST_CODE = 100;
    private static final String HEADERS_TAG = ":android:headers";
    public static final long HEADER_ID_UNDEFINED = -1L;
    private static final int MSG_BIND_PREFERENCES = 1;
    private static final int MSG_BUILD_HEADERS = 2;
    private static final String PREFERENCES_TAG = ":android:preferences";
    private Header mCurHeader;
    private FragmentBreadCrumbs mFragmentBreadCrumbs;
    private Handler mHandler;
    private final ArrayList mHeaders = new ArrayList();
    private FrameLayout mListFooter;
    private Button mNextButton;
    private PreferenceManager mPreferenceManager;
    private ViewGroup mPrefsContainer;
    private Bundle mSavedInstanceState;
    private boolean mSinglePane;





}
