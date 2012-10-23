// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.app;

import android.app.*;
import android.content.*;
import android.content.pm.*;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.*;
import android.util.Log;
import android.view.*;
import android.widget.*;
import com.android.internal.content.PackageMonitor;
import java.util.*;

// Referenced classes of package com.android.internal.app:
//            AlertActivity

public class ResolverActivity extends AlertActivity
    implements android.widget.AdapterView.OnItemClickListener {
    class ItemLongClickListener
        implements android.widget.AdapterView.OnItemLongClickListener {

        public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l) {
            ResolveInfo resolveinfo = mAdapter.resolveInfoForPosition(i);
            showAppDetails(resolveinfo);
            return true;
        }

        final ResolverActivity this$0;

        ItemLongClickListener() {
            this$0 = ResolverActivity.this;
            super();
        }
    }

    private final class ResolveListAdapter extends BaseAdapter {

        private final void bindView(View view, DisplayResolveInfo displayresolveinfo) {
            TextView textview = (TextView)view.findViewById(0x1020014);
            TextView textview1 = (TextView)view.findViewById(0x1020015);
            ImageView imageview = (ImageView)view.findViewById(0x1020006);
            textview.setText(displayresolveinfo.displayLabel);
            if(mShowExtended) {
                textview1.setVisibility(0);
                textview1.setText(displayresolveinfo.extendedInfo);
            } else {
                textview1.setVisibility(8);
            }
            if(displayresolveinfo.displayIcon == null)
                displayresolveinfo.displayIcon = displayresolveinfo.ri.loadIcon(mPm);
            imageview.setImageDrawable(displayresolveinfo.displayIcon);
        }

        private void processGroup(List list, int i, int j, ResolveInfo resolveinfo, CharSequence charsequence) {
            if(1 + (j - i) != 1) goto _L2; else goto _L1
_L1:
            mList.add(new DisplayResolveInfo(resolveinfo, charsequence, null, null));
_L5:
            return;
_L2:
            boolean flag;
            CharSequence charsequence1;
            mShowExtended = true;
            flag = false;
            charsequence1 = ((ComponentInfo) (resolveinfo.activityInfo)).applicationInfo.loadLabel(mPm);
            if(charsequence1 == null)
                flag = true;
            if(flag) goto _L4; else goto _L3
_L3:
            HashSet hashset;
            int k;
            hashset = new HashSet();
            hashset.add(charsequence1);
            k = i + 1;
_L6:
            CharSequence charsequence2;
            if(k <= j) {
                charsequence2 = ((ComponentInfo) (((ResolveInfo)list.get(k)).activityInfo)).applicationInfo.loadLabel(mPm);
                if(charsequence2 != null && !hashset.contains(charsequence2))
                    break MISSING_BLOCK_LABEL_229;
                flag = true;
            }
            hashset.clear();
_L4:
            int l = i;
            while(l <= j)  {
                ResolveInfo resolveinfo1 = (ResolveInfo)list.get(l);
                if(flag)
                    mList.add(new DisplayResolveInfo(resolveinfo1, charsequence, ((PackageItemInfo) (resolveinfo1.activityInfo)).packageName, null));
                else
                    mList.add(new DisplayResolveInfo(resolveinfo1, charsequence, ((ComponentInfo) (resolveinfo1.activityInfo)).applicationInfo.loadLabel(mPm), null));
                l++;
            }
              goto _L5
            hashset.add(charsequence2);
            k++;
              goto _L6
        }

        private void rebuildList() {
            if(mBaseResolveList != null) {
                mCurrentResolveList = mBaseResolveList;
            } else {
                PackageManager packagemanager = mPm;
                Intent intent = mIntent;
                byte byte0;
                if(mAlwaysUseOption)
                    byte0 = 64;
                else
                    byte0 = 0;
                mCurrentResolveList = packagemanager.queryIntentActivities(intent, byte0 | 0x10000);
                if(mCurrentResolveList != null) {
                    int i = -1 + mCurrentResolveList.size();
                    while(i >= 0)  {
                        ActivityInfo activityinfo = ((ResolveInfo)mCurrentResolveList.get(i)).activityInfo;
                        if(ActivityManager.checkComponentPermission(activityinfo.permission, mLaunchedFromUid, ((ComponentInfo) (activityinfo)).applicationInfo.uid, ((ComponentInfo) (activityinfo)).exported) != 0)
                            mCurrentResolveList.remove(i);
                        i--;
                    }
                }
            }
            if(mCurrentResolveList != null) {
                int j = mCurrentResolveList.size();
                if(j > 0) {
                    ResolveInfo resolveinfo = (ResolveInfo)mCurrentResolveList.get(0);
                    for(int k = 1; k < j; k++) {
                        ResolveInfo resolveinfo4 = (ResolveInfo)mCurrentResolveList.get(k);
                        if(resolveinfo.priority == resolveinfo4.priority && resolveinfo.isDefault == resolveinfo4.isDefault)
                            continue;
                        for(; k < j; j--)
                            mCurrentResolveList.remove(k);

                    }

                    if(j > 1) {
                        android.content.pm.ResolveInfo.DisplayNameComparator displaynamecomparator = new android.content.pm.ResolveInfo.DisplayNameComparator(mPm);
                        Collections.sort(mCurrentResolveList, displaynamecomparator);
                    }
                    mList = new ArrayList();
                    if(mInitialIntents != null) {
                        int j1 = 0;
                        do {
                            int k1 = mInitialIntents.length;
                            if(j1 >= k1)
                                break;
                            Intent intent1 = mInitialIntents[j1];
                            if(intent1 != null) {
                                ActivityInfo activityinfo1 = intent1.resolveActivityInfo(getPackageManager(), 0);
                                if(activityinfo1 == null) {
                                    Log.w("ResolverActivity", (new StringBuilder()).append("No activity found for ").append(intent1).toString());
                                } else {
                                    ResolveInfo resolveinfo3 = new ResolveInfo();
                                    resolveinfo3.activityInfo = activityinfo1;
                                    if(intent1 instanceof LabeledIntent) {
                                        LabeledIntent labeledintent = (LabeledIntent)intent1;
                                        resolveinfo3.resolvePackageName = labeledintent.getSourcePackage();
                                        resolveinfo3.labelRes = labeledintent.getLabelResource();
                                        resolveinfo3.nonLocalizedLabel = labeledintent.getNonLocalizedLabel();
                                        resolveinfo3.icon = labeledintent.getIconResource();
                                    }
                                    mList.add(new DisplayResolveInfo(resolveinfo3, resolveinfo3.loadLabel(getPackageManager()), null, intent1));
                                }
                            }
                            j1++;
                        } while(true);
                    }
                    ResolveInfo resolveinfo1 = (ResolveInfo)mCurrentResolveList.get(0);
                    int l = 0;
                    Object obj = resolveinfo1.loadLabel(mPm);
                    mShowExtended = false;
                    int i1 = 1;
                    while(i1 < j)  {
                        if(obj == null)
                            obj = ((PackageItemInfo) (resolveinfo1.activityInfo)).packageName;
                        ResolveInfo resolveinfo2 = (ResolveInfo)mCurrentResolveList.get(i1);
                        Object obj1 = resolveinfo2.loadLabel(mPm);
                        if(obj1 == null)
                            obj1 = ((PackageItemInfo) (resolveinfo2.activityInfo)).packageName;
                        if(!obj1.equals(obj)) {
                            processGroup(mCurrentResolveList, l, i1 - 1, resolveinfo1, ((CharSequence) (obj)));
                            resolveinfo1 = resolveinfo2;
                            obj = obj1;
                            l = i1;
                        }
                        i1++;
                    }
                    processGroup(mCurrentResolveList, l, j - 1, resolveinfo1, ((CharSequence) (obj)));
                }
            }
        }

        public int getCount() {
            int i;
            if(mList != null)
                i = mList.size();
            else
                i = 0;
            return i;
        }

        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        public long getItemId(int i) {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup) {
            View view1;
            if(view == null) {
                view1 = mInflater.inflate(0x1090093, viewgroup, false);
                android.view.ViewGroup.LayoutParams layoutparams = ((ImageView)view1.findViewById(0x1020006)).getLayoutParams();
                int j = mIconSize;
                layoutparams.height = j;
                layoutparams.width = j;
            } else {
                view1 = view;
            }
            bindView(view1, (DisplayResolveInfo)mList.get(i));
            return view1;
        }

        public void handlePackagesChanged() {
            int i = getCount();
            rebuildList();
            notifyDataSetChanged();
            if(mList.size() <= 0)
                finish();
            if(getCount() != i)
                resizeGrid();
        }

        public Intent intentForPosition(int i) {
            Intent intent1;
            if(mList == null) {
                intent1 = null;
            } else {
                DisplayResolveInfo displayresolveinfo = (DisplayResolveInfo)mList.get(i);
                Intent intent;
                ActivityInfo activityinfo;
                if(displayresolveinfo.origIntent != null)
                    intent = displayresolveinfo.origIntent;
                else
                    intent = mIntent;
                intent1 = new Intent(intent);
                intent1.addFlags(0x3000000);
                activityinfo = displayresolveinfo.ri.activityInfo;
                intent1.setComponent(new ComponentName(((PackageItemInfo) (((ComponentInfo) (activityinfo)).applicationInfo)).packageName, ((PackageItemInfo) (activityinfo)).name));
            }
            return intent1;
        }

        public ResolveInfo resolveInfoForPosition(int i) {
            ResolveInfo resolveinfo;
            if(mList == null)
                resolveinfo = null;
            else
                resolveinfo = ((DisplayResolveInfo)mList.get(i)).ri;
            return resolveinfo;
        }

        private final List mBaseResolveList;
        private List mCurrentResolveList;
        private final LayoutInflater mInflater;
        private final Intent mInitialIntents[];
        private final Intent mIntent;
        private final int mLaunchedFromUid;
        private List mList;
        final ResolverActivity this$0;


        public ResolveListAdapter(Context context, Intent intent, Intent aintent[], List list, int i) {
            this$0 = ResolverActivity.this;
            super();
            mIntent = new Intent(intent);
            mIntent.setComponent(null);
            mInitialIntents = aintent;
            mBaseResolveList = list;
            mLaunchedFromUid = i;
            mInflater = (LayoutInflater)context.getSystemService("layout_inflater");
            rebuildList();
        }
    }

    private final class DisplayResolveInfo {

        Drawable displayIcon;
        CharSequence displayLabel;
        CharSequence extendedInfo;
        Intent origIntent;
        ResolveInfo ri;
        final ResolverActivity this$0;

        DisplayResolveInfo(ResolveInfo resolveinfo, CharSequence charsequence, CharSequence charsequence1, Intent intent) {
            this$0 = ResolverActivity.this;
            super();
            ri = resolveinfo;
            displayLabel = charsequence;
            extendedInfo = charsequence1;
            origIntent = intent;
        }
    }


    public ResolverActivity() {
    }

    private Intent makeMyIntent() {
        Intent intent = new Intent(getIntent());
        intent.setFlags(0xff7fffff & intent.getFlags());
        return intent;
    }

    Drawable getIcon(Resources resources, int i) {
        Drawable drawable1 = resources.getDrawableForDensity(i, mIconDpi);
        Drawable drawable = drawable1;
_L2:
        return drawable;
        android.content.res.Resources.NotFoundException notfoundexception;
        notfoundexception;
        drawable = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    Drawable loadIconForResolveInfo(ResolveInfo resolveinfo) {
        if(resolveinfo.resolvePackageName == null || resolveinfo.icon == 0) goto _L2; else goto _L1
_L1:
        Drawable drawable = getIcon(mPm.getResourcesForApplication(resolveinfo.resolvePackageName), resolveinfo.icon);
        if(drawable == null) goto _L2; else goto _L3
_L2:
        int i = resolveinfo.getIconResource();
        if(i == 0) goto _L5; else goto _L4
_L4:
        Drawable drawable1 = getIcon(mPm.getResourcesForApplication(((PackageItemInfo) (resolveinfo.activityInfo)).packageName), i);
        drawable = drawable1;
        if(drawable != null) goto _L3; else goto _L5
_L5:
        drawable = resolveinfo.loadIcon(mPm);
        break; /* Loop/switch isn't completed */
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        Log.e("ResolverActivity", "Couldn't find resources for package", namenotfoundexception);
        if(true) goto _L5; else goto _L3
_L3:
        return drawable;
    }

    public void onButtonClick(View view) {
        int i = view.getId();
        int j = mGrid.getCheckedItemPosition();
        boolean flag;
        if(i == 0x1020317)
            flag = true;
        else
            flag = false;
        startSelected(j, flag);
        dismiss();
    }

    protected void onCreate(Bundle bundle) {
        onCreate(bundle, makeMyIntent(), getResources().getText(0x10403c9), null, null, true);
    }

    protected void onCreate(Bundle bundle, Intent intent, CharSequence charsequence, Intent aintent[], List list, boolean flag) {
        AlertController.AlertParams alertparams;
        int i;
        setTheme(0x1030302);
        super.onCreate(bundle);
        ActivityManager activitymanager;
        try {
            mLaunchedFromUid = ActivityManagerNative.getDefault().getLaunchedFromUid(getActivityToken());
        }
        catch(RemoteException remoteexception) {
            mLaunchedFromUid = -1;
        }
        mPm = getPackageManager();
        mAlwaysUseOption = flag;
        mMaxColumns = getResources().getInteger(0x10e0032);
        intent.setComponent(null);
        alertparams = super.mAlertParams;
        alertparams.mTitle = charsequence;
        mPackageMonitor.register(this, getMainLooper(), false);
        mRegistered = true;
        activitymanager = (ActivityManager)getSystemService("activity");
        mIconDpi = activitymanager.getLauncherLargeIconDensity();
        mIconSize = activitymanager.getLauncherLargeIconSize();
        mAdapter = new ResolveListAdapter(this, intent, aintent, list, mLaunchedFromUid);
        i = mAdapter.getCount();
        if(mLaunchedFromUid >= 0 && !UserId.isIsolated(mLaunchedFromUid)) goto _L2; else goto _L1
_L1:
        finish();
_L5:
        return;
_L2:
        if(i <= 1) goto _L4; else goto _L3
_L3:
        alertparams.mView = getLayoutInflater().inflate(0x1090094, null);
        mGrid = (GridView)alertparams.mView.findViewById(0x1020316);
        mGrid.setAdapter(mAdapter);
        mGrid.setOnItemClickListener(this);
        mGrid.setOnItemLongClickListener(new ItemLongClickListener());
        if(flag)
            mGrid.setChoiceMode(1);
        resizeGrid();
_L6:
        setupAlert();
        if(flag) {
            ViewGroup viewgroup = (ViewGroup)findViewById(0x102026d);
            if(viewgroup != null) {
                viewgroup.setVisibility(0);
                mAlwaysButton = (Button)viewgroup.findViewById(0x1020317);
                mOnceButton = (Button)viewgroup.findViewById(0x1020318);
            } else {
                mAlwaysUseOption = false;
            }
        }
          goto _L5
_L4:
label0:
        {
            if(i != 1)
                break label0;
            startActivity(mAdapter.intentForPosition(0));
            mPackageMonitor.unregister();
            mRegistered = false;
            finish();
        }
          goto _L5
        alertparams.mMessage = getResources().getText(0x10403ce);
          goto _L6
    }

    protected void onIntentSelected(ResolveInfo resolveinfo, Intent intent, boolean flag) {
label0:
        {
            IntentFilter intentfilter;
            String s2;
label1:
            {
                if(!flag)
                    break label0;
                intentfilter = new IntentFilter();
                if(intent.getAction() != null)
                    intentfilter.addAction(intent.getAction());
                Set set = intent.getCategories();
                if(set != null) {
                    for(Iterator iterator2 = set.iterator(); iterator2.hasNext(); intentfilter.addCategory((String)iterator2.next()));
                }
                intentfilter.addCategory("android.intent.category.DEFAULT");
                int i = 0xfff0000 & resolveinfo.match;
                Uri uri = intent.getData();
                if(i == 0x600000) {
                    String s3 = intent.resolveType(this);
                    int j;
                    int l;
                    ResolveInfo resolveinfo1;
                    Iterator iterator;
                    Iterator iterator1;
                    String s;
                    PatternMatcher patternmatcher;
                    android.content.IntentFilter.AuthorityEntry authorityentry;
                    int i1;
                    String s1;
                    if(s3 != null)
                        try {
                            intentfilter.addDataType(s3);
                        }
                        catch(android.content.IntentFilter.MalformedMimeTypeException malformedmimetypeexception) {
                            Log.w("ResolverActivity", malformedmimetypeexception);
                            intentfilter = null;
                        }
                }
                if(uri == null || uri.getScheme() == null || i == 0x600000 && ("file".equals(uri.getScheme()) || "content".equals(uri.getScheme())))
                    break label1;
                intentfilter.addDataScheme(uri.getScheme());
                iterator = resolveinfo.filter.authoritiesIterator();
                if(iterator != null)
                    do {
                        if(!iterator.hasNext())
                            break;
                        authorityentry = (android.content.IntentFilter.AuthorityEntry)iterator.next();
                        if(authorityentry.match(uri) < 0)
                            continue;
                        i1 = authorityentry.getPort();
                        s1 = authorityentry.getHost();
                        if(i1 >= 0)
                            s2 = Integer.toString(i1);
                        else
                            s2 = null;
                        intentfilter.addDataAuthority(s1, s2);
                        break;
                    } while(true);
                iterator1 = resolveinfo.filter.pathsIterator();
                if(iterator1 == null)
                    break label1;
                s = uri.getPath();
                do {
                    if(s == null || !iterator1.hasNext())
                        break label1;
                    patternmatcher = (PatternMatcher)iterator1.next();
                } while(!patternmatcher.match(s));
                intentfilter.addDataPath(patternmatcher.getPath(), patternmatcher.getType());
            }
            if(intentfilter != null) {
                j = mAdapter.mList.size();
                ComponentName acomponentname[] = new ComponentName[j];
                int k = 0;
                for(l = 0; l < j; l++) {
                    resolveinfo1 = ((DisplayResolveInfo)mAdapter.mList.get(l)).ri;
                    acomponentname[l] = new ComponentName(((PackageItemInfo) (resolveinfo1.activityInfo)).packageName, ((PackageItemInfo) (resolveinfo1.activityInfo)).name);
                    if(resolveinfo1.match > k)
                        k = resolveinfo1.match;
                }

                getPackageManager().addPreferredActivity(intentfilter, k, acomponentname, intent.getComponent());
            }
        }
        if(intent != null)
            startActivity(intent);
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l) {
        boolean flag = false;
        if(mAlwaysUseOption) {
            int j = mGrid.getCheckedItemPosition();
            if(j != -1)
                flag = true;
            mAlwaysButton.setEnabled(flag);
            mOnceButton.setEnabled(flag);
            if(flag)
                mGrid.smoothScrollToPosition(j);
        } else {
            startSelected(i, false);
        }
    }

    protected void onRestart() {
        super.onRestart();
        if(!mRegistered) {
            mPackageMonitor.register(this, getMainLooper(), false);
            mRegistered = true;
        }
        mAdapter.handlePackagesChanged();
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if(mAlwaysUseOption) {
            int i = mGrid.getCheckedItemPosition();
            boolean flag;
            if(i != -1)
                flag = true;
            else
                flag = false;
            mAlwaysButton.setEnabled(flag);
            mOnceButton.setEnabled(flag);
            if(flag)
                mGrid.setSelection(i);
        }
    }

    protected void onStop() {
        super.onStop();
        if(mRegistered) {
            mPackageMonitor.unregister();
            mRegistered = false;
        }
        if((0x10000000 & getIntent().getFlags()) != 0 && !isChangingConfigurations())
            finish();
    }

    void resizeGrid() {
        int i = mAdapter.getCount();
        mGrid.setNumColumns(Math.min(i, mMaxColumns));
    }

    void showAppDetails(ResolveInfo resolveinfo) {
        startActivity((new Intent()).setAction("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts("package", ((PackageItemInfo) (resolveinfo.activityInfo)).packageName, null)));
    }

    void startSelected(int i, boolean flag) {
        onIntentSelected(mAdapter.resolveInfoForPosition(i), mAdapter.intentForPosition(i), flag);
        finish();
    }

    private static final String TAG = "ResolverActivity";
    private ResolveListAdapter mAdapter;
    private Button mAlwaysButton;
    private boolean mAlwaysUseOption;
    private GridView mGrid;
    private int mIconDpi;
    private int mIconSize;
    private int mLaunchedFromUid;
    private int mMaxColumns;
    private Button mOnceButton;
    private final PackageMonitor mPackageMonitor = new PackageMonitor() {

        public void onSomePackagesChanged() {
            mAdapter.handlePackagesChanged();
        }

        final ResolverActivity this$0;

             {
                this$0 = ResolverActivity.this;
                super();
            }
    };
    private PackageManager mPm;
    private boolean mRegistered;
    private boolean mShowExtended;






/*
    static boolean access$402(ResolverActivity resolveractivity, boolean flag) {
        resolveractivity.mShowExtended = flag;
        return flag;
    }

*/

}
