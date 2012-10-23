// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.*;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.*;
import android.view.*;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;

// Referenced classes of package android.app:
//            Dialog, SearchableInfo, SearchManager

public class SearchDialog extends Dialog {
    public static class SearchBar extends LinearLayout {

        public void setSearchDialog(SearchDialog searchdialog) {
            mSearchDialog = searchdialog;
        }

        public ActionMode startActionModeForChild(View view, android.view.ActionMode.Callback callback) {
            return null;
        }

        private SearchDialog mSearchDialog;

        public SearchBar(Context context) {
            super(context);
        }

        public SearchBar(Context context, AttributeSet attributeset) {
            super(context, attributeset);
        }
    }


    public SearchDialog(Context context, SearchManager searchmanager) {
        super(context, resolveDialogTheme(context));
        mConfChangeListener = new BroadcastReceiver() {

            public void onReceive(Context context1, Intent intent) {
                if(intent.getAction().equals("android.intent.action.CONFIGURATION_CHANGED"))
                    onConfigurationChanged();
            }

            final SearchDialog this$0;

             {
                this$0 = SearchDialog.this;
                super();
            }
        };
        mVoiceWebSearchIntent.addFlags(0x10000000);
        mVoiceWebSearchIntent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        mVoiceAppSearchIntent.addFlags(0x10000000);
    }

    private void createContentView() {
        setContentView(0x109009f);
        ((SearchBar)findViewById(0x1020324)).setSearchDialog(this);
        mSearchView = (SearchView)findViewById(0x1020326);
        mSearchView.setIconified(false);
        mSearchView.setOnCloseListener(mOnCloseListener);
        mSearchView.setOnQueryTextListener(mOnQueryChangeListener);
        mSearchView.setOnSuggestionListener(mOnSuggestionSelectionListener);
        mSearchView.onActionViewExpanded();
        mCloseSearch = findViewById(0x1020027);
        mCloseSearch.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view) {
                dismiss();
            }

            final SearchDialog this$0;

             {
                this$0 = SearchDialog.this;
                super();
            }
        });
        mBadgeLabel = (TextView)mSearchView.findViewById(0x1020328);
        mSearchAutoComplete = (AutoCompleteTextView)mSearchView.findViewById(0x102032d);
        mAppIcon = (ImageView)findViewById(0x1020325);
        mSearchPlate = mSearchView.findViewById(0x102032c);
        mWorkingSpinner = getContext().getResources().getDrawable(0x10804de);
        setWorking(false);
        mBadgeLabel.setVisibility(8);
        mSearchAutoCompleteImeOptions = mSearchAutoComplete.getImeOptions();
    }

    private Intent createIntent(String s, Uri uri, String s1, String s2, int i, String s3) {
        Intent intent = new Intent(s);
        intent.addFlags(0x10000000);
        if(uri != null)
            intent.setData(uri);
        intent.putExtra("user_query", mUserQuery);
        if(s2 != null)
            intent.putExtra("query", s2);
        if(s1 != null)
            intent.putExtra("intent_extra_data_key", s1);
        if(mAppSearchData != null)
            intent.putExtra("app_data", mAppSearchData);
        if(i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", s3);
        }
        intent.setComponent(mSearchable.getSearchActivity());
        return intent;
    }

    private boolean doShow(String s, boolean flag, ComponentName componentname, Bundle bundle) {
        boolean flag1;
        if(!show(componentname, bundle)) {
            flag1 = false;
        } else {
            setUserQuery(s);
            if(flag)
                mSearchAutoComplete.selectAll();
            flag1 = true;
        }
        return flag1;
    }

    private boolean isEmpty(AutoCompleteTextView autocompletetextview) {
        boolean flag;
        if(TextUtils.getTrimmedLength(autocompletetextview.getText()) == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    static boolean isLandscapeMode(Context context) {
        boolean flag;
        if(context.getResources().getConfiguration().orientation == 2)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private boolean isOutOfBounds(View view, MotionEvent motionevent) {
        int i = (int)motionevent.getX();
        int j = (int)motionevent.getY();
        int k = ViewConfiguration.get(super.mContext).getScaledWindowTouchSlop();
        boolean flag;
        if(i < -k || j < -k || i > k + view.getWidth() || j > k + view.getHeight())
            flag = true;
        else
            flag = false;
        return flag;
    }

    private void launchIntent(Intent intent) {
        if(intent != null) {
            Log.d("SearchDialog", (new StringBuilder()).append("launching ").append(intent).toString());
            try {
                getContext().startActivity(intent);
                dismiss();
            }
            catch(RuntimeException runtimeexception) {
                Log.e("SearchDialog", (new StringBuilder()).append("Failed launch activity: ").append(intent).toString(), runtimeexception);
            }
        }
    }

    private boolean onClosePressed() {
        boolean flag;
        if(isEmpty(mSearchAutoComplete)) {
            dismiss();
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    static int resolveDialogTheme(Context context) {
        TypedValue typedvalue = new TypedValue();
        context.getTheme().resolveAttribute(0x10103d8, typedvalue, true);
        return typedvalue.resourceId;
    }

    private void setUserQuery(String s) {
        if(s == null)
            s = "";
        mUserQuery = s;
        mSearchAutoComplete.setText(s);
        mSearchAutoComplete.setSelection(s.length());
    }

    private boolean show(ComponentName componentname, Bundle bundle) {
        mSearchable = ((SearchManager)super.mContext.getSystemService("search")).getSearchableInfo(componentname);
        boolean flag;
        if(mSearchable == null) {
            flag = false;
        } else {
            mLaunchComponent = componentname;
            mAppSearchData = bundle;
            mActivityContext = mSearchable.getActivityContext(getContext());
            if(!isShowing()) {
                createContentView();
                mSearchView.setSearchableInfo(mSearchable);
                mSearchView.setAppSearchData(mAppSearchData);
                show();
            }
            updateUI();
            flag = true;
        }
        return flag;
    }

    private void updateSearchAppIcon() {
        PackageManager packagemanager = getContext().getPackageManager();
        Drawable drawable1 = packagemanager.getApplicationIcon(((ComponentInfo) (packagemanager.getActivityInfo(mLaunchComponent, 0))).applicationInfo);
        Drawable drawable = drawable1;
_L2:
        mAppIcon.setImageDrawable(drawable);
        mAppIcon.setVisibility(0);
        mSearchPlate.setPadding(7, mSearchPlate.getPaddingTop(), mSearchPlate.getPaddingRight(), mSearchPlate.getPaddingBottom());
        return;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        drawable = packagemanager.getDefaultActivityIcon();
        Log.w("SearchDialog", (new StringBuilder()).append(mLaunchComponent).append(" not found, using generic app icon").toString());
        if(true) goto _L2; else goto _L1
_L1:
    }

    private void updateSearchAutoComplete() {
        mSearchAutoComplete.setDropDownDismissedOnCompletion(false);
        mSearchAutoComplete.setForceIgnoreOutsideTouch(false);
    }

    private void updateSearchBadge() {
        byte byte0;
        Drawable drawable;
        Object obj;
        byte0 = 8;
        drawable = null;
        obj = null;
        if(!mSearchable.useBadgeIcon()) goto _L2; else goto _L1
_L1:
        drawable = mActivityContext.getResources().getDrawable(mSearchable.getIconId());
        byte0 = 0;
_L4:
        mBadgeLabel.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        mBadgeLabel.setText(((CharSequence) (obj)));
        mBadgeLabel.setVisibility(byte0);
        return;
_L2:
        if(mSearchable.useBadgeLabel()) {
            obj = mActivityContext.getResources().getText(mSearchable.getLabelId()).toString();
            byte0 = 0;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void updateUI() {
        if(mSearchable != null) {
            super.mDecor.setVisibility(0);
            updateSearchAutoComplete();
            updateSearchAppIcon();
            updateSearchBadge();
            int i = mSearchable.getInputType();
            if((i & 0xf) == 1) {
                i &= 0xfffeffff;
                if(mSearchable.getSuggestAuthority() != null)
                    i |= 0x10000;
            }
            mSearchAutoComplete.setInputType(i);
            mSearchAutoCompleteImeOptions = mSearchable.getImeOptions();
            mSearchAutoComplete.setImeOptions(mSearchAutoCompleteImeOptions);
            if(mSearchable.getVoiceSearchEnabled())
                mSearchAutoComplete.setPrivateImeOptions("nm");
            else
                mSearchAutoComplete.setPrivateImeOptions(null);
        }
    }

    public void hide() {
        if(isShowing()) {
            InputMethodManager inputmethodmanager = (InputMethodManager)getContext().getSystemService("input_method");
            if(inputmethodmanager != null)
                inputmethodmanager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
            super.hide();
        }
    }

    public void launchQuerySearch() {
        launchQuerySearch(0, null);
    }

    protected void launchQuerySearch(int i, String s) {
        launchIntent(createIntent("android.intent.action.SEARCH", null, null, mSearchAutoComplete.getText().toString(), i, s));
    }

    public void onBackPressed() {
        InputMethodManager inputmethodmanager = (InputMethodManager)getContext().getSystemService("input_method");
        if(inputmethodmanager == null || !inputmethodmanager.isFullscreenMode() || !inputmethodmanager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0))
            cancel();
    }

    public void onConfigurationChanged() {
        if(mSearchable != null && isShowing()) {
            updateSearchAppIcon();
            updateSearchBadge();
            if(isLandscapeMode(getContext()))
                mSearchAutoComplete.ensureImeVisible(true);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        android.view.WindowManager.LayoutParams layoutparams = window.getAttributes();
        layoutparams.width = -1;
        layoutparams.height = -1;
        layoutparams.gravity = 55;
        layoutparams.softInputMode = 16;
        window.setAttributes(layoutparams);
        setCanceledOnTouchOutside(true);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        if(bundle != null) {
            ComponentName componentname = (ComponentName)bundle.getParcelable("comp");
            Bundle bundle1 = bundle.getBundle("data");
            if(doShow(bundle.getString("uQry"), false, componentname, bundle1));
        }
    }

    public Bundle onSaveInstanceState() {
        Bundle bundle;
        if(!isShowing()) {
            bundle = null;
        } else {
            bundle = new Bundle();
            bundle.putParcelable("comp", mLaunchComponent);
            bundle.putBundle("data", mAppSearchData);
            bundle.putString("uQry", mUserQuery);
        }
        return bundle;
    }

    public void onStart() {
        super.onStart();
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.intent.action.CONFIGURATION_CHANGED");
        getContext().registerReceiver(mConfChangeListener, intentfilter);
    }

    public void onStop() {
        super.onStop();
        getContext().unregisterReceiver(mConfChangeListener);
        mLaunchComponent = null;
        mAppSearchData = null;
        mSearchable = null;
        mUserQuery = null;
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        boolean flag;
        if(!mSearchAutoComplete.isPopupShowing() && isOutOfBounds(mSearchPlate, motionevent)) {
            cancel();
            flag = true;
        } else {
            flag = super.onTouchEvent(motionevent);
        }
        return flag;
    }

    public void setListSelection(int i) {
        mSearchAutoComplete.setListSelection(i);
    }

    public void setWorking(boolean flag) {
        Drawable drawable = mWorkingSpinner;
        char c;
        if(flag)
            c = '\377';
        else
            c = '\0';
        drawable.setAlpha(c);
        mWorkingSpinner.setVisible(flag, false);
        mWorkingSpinner.invalidateSelf();
    }

    public boolean show(String s, boolean flag, ComponentName componentname, Bundle bundle) {
        boolean flag1 = doShow(s, flag, componentname, bundle);
        if(flag1)
            mSearchAutoComplete.showDropDownAfterLayout();
        return flag1;
    }

    private static final boolean DBG = false;
    private static final String IME_OPTION_NO_MICROPHONE = "nm";
    private static final String INSTANCE_KEY_APPDATA = "data";
    private static final String INSTANCE_KEY_COMPONENT = "comp";
    private static final String INSTANCE_KEY_USER_QUERY = "uQry";
    private static final String LOG_TAG = "SearchDialog";
    private static final int SEARCH_PLATE_LEFT_PADDING_NON_GLOBAL = 7;
    private Context mActivityContext;
    private ImageView mAppIcon;
    private Bundle mAppSearchData;
    private TextView mBadgeLabel;
    private View mCloseSearch;
    private BroadcastReceiver mConfChangeListener;
    private ComponentName mLaunchComponent;
    private final android.widget.SearchView.OnCloseListener mOnCloseListener = new android.widget.SearchView.OnCloseListener() {

        public boolean onClose() {
            return onClosePressed();
        }

        final SearchDialog this$0;

             {
                this$0 = SearchDialog.this;
                super();
            }
    };
    private final android.widget.SearchView.OnQueryTextListener mOnQueryChangeListener = new android.widget.SearchView.OnQueryTextListener() {

        public boolean onQueryTextChange(String s) {
            return false;
        }

        public boolean onQueryTextSubmit(String s) {
            dismiss();
            return false;
        }

        final SearchDialog this$0;

             {
                this$0 = SearchDialog.this;
                super();
            }
    };
    private final android.widget.SearchView.OnSuggestionListener mOnSuggestionSelectionListener = new android.widget.SearchView.OnSuggestionListener() {

        public boolean onSuggestionClick(int i) {
            dismiss();
            return false;
        }

        public boolean onSuggestionSelect(int i) {
            return false;
        }

        final SearchDialog this$0;

             {
                this$0 = SearchDialog.this;
                super();
            }
    };
    private AutoCompleteTextView mSearchAutoComplete;
    private int mSearchAutoCompleteImeOptions;
    private View mSearchPlate;
    private SearchView mSearchView;
    private SearchableInfo mSearchable;
    private String mUserQuery;
    private final Intent mVoiceAppSearchIntent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
    private final Intent mVoiceWebSearchIntent = new Intent("android.speech.action.WEB_SEARCH");
    private Drawable mWorkingSpinner;

}
