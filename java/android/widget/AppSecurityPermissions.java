// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.pm.*;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import java.text.Collator;
import java.util.*;

// Referenced classes of package android.widget:
//            LinearLayout, TextView, ImageView

public class AppSecurityPermissions
    implements android.view.View.OnClickListener {
    private static class PermissionInfoComparator
        implements Comparator {

        public final int compare(PermissionInfo permissioninfo, PermissionInfo permissioninfo1) {
            CharSequence charsequence = permissioninfo.loadLabel(mPm);
            CharSequence charsequence1 = permissioninfo1.loadLabel(mPm);
            return sCollator.compare(charsequence, charsequence1);
        }

        public volatile int compare(Object obj, Object obj1) {
            return compare((PermissionInfo)obj, (PermissionInfo)obj1);
        }

        private PackageManager mPm;
        private final Collator sCollator = Collator.getInstance();

        PermissionInfoComparator(PackageManager packagemanager) {
            mPm = packagemanager;
        }
    }

    private static final class State extends Enum {

        public static State valueOf(String s) {
            return (State)Enum.valueOf(android/widget/AppSecurityPermissions$State, s);
        }

        public static State[] values() {
            return (State[])$VALUES.clone();
        }

        private static final State $VALUES[];
        public static final State BOTH;
        public static final State DANGEROUS_ONLY;
        public static final State NORMAL_ONLY;
        public static final State NO_PERMS;

        static  {
            NO_PERMS = new State("NO_PERMS", 0);
            DANGEROUS_ONLY = new State("DANGEROUS_ONLY", 1);
            NORMAL_ONLY = new State("NORMAL_ONLY", 2);
            BOTH = new State("BOTH", 3);
            State astate[] = new State[4];
            astate[0] = NO_PERMS;
            astate[1] = DANGEROUS_ONLY;
            astate[2] = NORMAL_ONLY;
            astate[3] = BOTH;
            $VALUES = astate;
        }

        private State(String s, int i) {
            super(s, i);
        }
    }


    public AppSecurityPermissions(Context context, android.content.pm.PackageParser.Package package1) {
        localLOGV = false;
        mDefaultGrpName = "DefaultGrp";
        mContext = context;
        mPm = mContext.getPackageManager();
        mPermsList = new ArrayList();
        HashSet hashset = new HashSet();
        if(package1 != null) {
            if(package1.requestedPermissions != null) {
                ArrayList arraylist = package1.requestedPermissions;
                int i = arraylist.size();
                if(i > 0)
                    extractPerms((String[])arraylist.toArray(new String[i]), hashset);
            }
            Iterator iterator;
            if(package1.mSharedUserId != null)
                try {
                    getAllUsedPermissions(mPm.getUidForSharedUser(package1.mSharedUserId), hashset);
                }
                catch(android.content.pm.PackageManager.NameNotFoundException namenotfoundexception) {
                    Log.w("AppSecurityPermissions", (new StringBuilder()).append("Could'nt retrieve shared user id for:").append(package1.packageName).toString());
                }
            iterator = hashset.iterator();
            while(iterator.hasNext())  {
                PermissionInfo permissioninfo = (PermissionInfo)iterator.next();
                mPermsList.add(permissioninfo);
            }
        }
    }

    public AppSecurityPermissions(Context context, String s) {
        HashSet hashset;
        localLOGV = false;
        mDefaultGrpName = "DefaultGrp";
        mContext = context;
        mPm = mContext.getPackageManager();
        mPermsList = new ArrayList();
        hashset = new HashSet();
        PackageInfo packageinfo = mPm.getPackageInfo(s, 4096);
        if(packageinfo.applicationInfo != null && packageinfo.applicationInfo.uid != -1)
            getAllUsedPermissions(packageinfo.applicationInfo.uid, hashset);
        PermissionInfo permissioninfo;
        for(Iterator iterator = hashset.iterator(); iterator.hasNext(); mPermsList.add(permissioninfo))
            permissioninfo = (PermissionInfo)iterator.next();

        break MISSING_BLOCK_LABEL_169;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        Log.w("AppSecurityPermissions", (new StringBuilder()).append("Could'nt retrieve permissions for package:").append(s).toString());
    }

    public AppSecurityPermissions(Context context, List list) {
        localLOGV = false;
        mDefaultGrpName = "DefaultGrp";
        mContext = context;
        mPm = mContext.getPackageManager();
        mPermsList = list;
    }

    private void aggregateGroupDescs(Map map, Map map1) {
        if(map != null && map1 != null) {
            Iterator iterator = map.keySet().iterator();
            while(iterator.hasNext())  {
                String s = null;
                String s1 = (String)iterator.next();
                List list = (List)map.get(s1);
                if(list != null) {
                    for(Iterator iterator1 = list.iterator(); iterator1.hasNext();)
                        s = formatPermissions(s, ((PermissionInfo)iterator1.next()).loadLabel(mPm));

                    if(s != null) {
                        if(localLOGV)
                            Log.i("AppSecurityPermissions", (new StringBuilder()).append("Group:").append(s1).append(" description:").append(s.toString()).toString());
                        map1.put(s1, s.toString());
                    }
                }
            }
        }
    }

    private String canonicalizeGroupDesc(String s) {
        String s1;
        if(s == null || s.length() == 0) {
            s1 = null;
        } else {
            int i = s.length();
            if(s.charAt(i - 1) == '.')
                s = s.substring(0, i - 1);
            s1 = s;
        }
        return s1;
    }

    private void displayNoPermissions() {
        mNoPermsView.setVisibility(0);
    }

    private void displayPermissions(boolean flag) {
        Map map;
        LinearLayout linearlayout;
        if(flag)
            map = mDangerousMap;
        else
            map = mNormalMap;
        if(flag)
            linearlayout = mDangerousList;
        else
            linearlayout = mNonDangerousList;
        linearlayout.removeAllViews();
        String s;
        CharSequence charsequence;
        for(Iterator iterator = map.keySet().iterator(); iterator.hasNext(); linearlayout.addView(getPermissionItemView(charsequence, (CharSequence)map.get(s), flag))) {
            s = (String)iterator.next();
            charsequence = getGroupLabel(s);
            if(localLOGV)
                Log.i("AppSecurityPermissions", (new StringBuilder()).append("Adding view group:").append(charsequence).append(", desc:").append((String)map.get(s)).toString());
        }

    }

    private void extractPerms(String as[], Set set) {
        if(as != null && as.length != 0) {
            int i = as.length;
            int j = 0;
            while(j < i)  {
                String s = as[j];
                try {
                    PermissionInfo permissioninfo = mPm.getPermissionInfo(s, 0);
                    if(permissioninfo != null)
                        set.add(permissioninfo);
                }
                catch(android.content.pm.PackageManager.NameNotFoundException namenotfoundexception) {
                    Log.i("AppSecurityPermissions", (new StringBuilder()).append("Ignoring unknown permission:").append(s).toString());
                }
                j++;
            }
        }
    }

    private String formatPermissions(String s, CharSequence charsequence) {
        String s3;
        if(s == null) {
            if(charsequence == null)
                s3 = null;
            else
                s3 = charsequence.toString();
        } else {
            String s1 = canonicalizeGroupDesc(s);
            if(charsequence == null) {
                s3 = s1;
            } else {
                String s2 = mPermFormat;
                Object aobj[] = new Object[2];
                aobj[0] = s1;
                aobj[1] = charsequence.toString();
                s3 = String.format(s2, aobj);
            }
        }
        return s3;
    }

    private void getAllUsedPermissions(int i, Set set) {
        String as[] = mPm.getPackagesForUid(i);
        if(as != null && as.length != 0) {
            int j = as.length;
            int k = 0;
            while(k < j)  {
                getPermissionsForPackage(as[k], set);
                k++;
            }
        }
    }

    private CharSequence getGroupLabel(String s) {
        if(s != null) goto _L2; else goto _L1
_L1:
        Object obj = mDefaultGrpLabel;
_L4:
        return ((CharSequence) (obj));
_L2:
        obj = (CharSequence)mGroupLabelCache.get(s);
        if(obj != null)
            continue; /* Loop/switch isn't completed */
        PermissionGroupInfo permissiongroupinfo = mPm.getPermissionGroupInfo(s, 0);
        String s1 = permissiongroupinfo.loadLabel(mPm).toString();
        mGroupLabelCache.put(s, s1);
        obj = s1;
        continue; /* Loop/switch isn't completed */
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        Log.i("AppSecurityPermissions", (new StringBuilder()).append("Invalid group name:").append(s).toString());
        obj = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static View getPermissionItemView(Context context, LayoutInflater layoutinflater, CharSequence charsequence, CharSequence charsequence1, boolean flag, Drawable drawable) {
        View view = layoutinflater.inflate(0x1090029, null);
        TextView textview = (TextView)view.findViewById(0x102025e);
        TextView textview1 = (TextView)view.findViewById(0x102025f);
        ((ImageView)view.findViewById(0x102025d)).setImageDrawable(drawable);
        if(charsequence != null) {
            textview.setText(charsequence);
            textview1.setText(charsequence1);
        } else {
            textview.setText(charsequence1);
            textview1.setVisibility(8);
        }
        return view;
    }

    public static View getPermissionItemView(Context context, CharSequence charsequence, CharSequence charsequence1, boolean flag) {
        LayoutInflater layoutinflater = (LayoutInflater)context.getSystemService("layout_inflater");
        Resources resources = context.getResources();
        int i;
        if(flag)
            i = 0x10802b3;
        else
            i = 0x108035c;
        return getPermissionItemView(context, layoutinflater, charsequence, charsequence1, flag, resources.getDrawable(i));
    }

    private View getPermissionItemView(CharSequence charsequence, CharSequence charsequence1, boolean flag) {
        Context context = mContext;
        LayoutInflater layoutinflater = mInflater;
        Drawable drawable;
        if(flag)
            drawable = mDangerousIcon;
        else
            drawable = mNormalIcon;
        return getPermissionItemView(context, layoutinflater, charsequence, charsequence1, flag, drawable);
    }

    private void getPermissionsForPackage(String s, Set set) {
        PackageInfo packageinfo = mPm.getPackageInfo(s, 4096);
        if(packageinfo != null && packageinfo.requestedPermissions != null)
            extractPerms(packageinfo.requestedPermissions, set);
_L2:
        return;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        Log.w("AppSecurityPermissions", (new StringBuilder()).append("Could'nt retrieve permissions for package:").append(s).toString());
        if(true) goto _L2; else goto _L1
_L1:
    }

    private boolean isDisplayablePermission(PermissionInfo permissioninfo) {
        boolean flag = true;
        if(permissioninfo.protectionLevel != flag && permissioninfo.protectionLevel != 0)
            flag = false;
        return flag;
    }

    private void setPermissions(List list) {
        mGroupLabelCache = new HashMap();
        mGroupLabelCache.put(mDefaultGrpName, mDefaultGrpLabel);
        mDangerousMap = new HashMap();
        mNormalMap = new HashMap();
        HashMap hashmap = new HashMap();
        HashMap hashmap1 = new HashMap();
        PermissionInfoComparator permissioninfocomparator = new PermissionInfoComparator(mPm);
        if(list != null) {
            Iterator iterator = list.iterator();
            do {
                if(!iterator.hasNext())
                    break;
                PermissionInfo permissioninfo = (PermissionInfo)iterator.next();
                if(localLOGV)
                    Log.i("AppSecurityPermissions", (new StringBuilder()).append("Processing permission:").append(((PackageItemInfo) (permissioninfo)).name).toString());
                if(!isDisplayablePermission(permissioninfo)) {
                    if(localLOGV)
                        Log.i("AppSecurityPermissions", (new StringBuilder()).append("Permission:").append(((PackageItemInfo) (permissioninfo)).name).append(" is not displayable").toString());
                } else {
                    HashMap hashmap2;
                    String s;
                    List list1;
                    if(permissioninfo.protectionLevel == 1)
                        hashmap2 = hashmap;
                    else
                        hashmap2 = hashmap1;
                    if(permissioninfo.group == null)
                        s = mDefaultGrpName;
                    else
                        s = permissioninfo.group;
                    if(localLOGV)
                        Log.i("AppSecurityPermissions", (new StringBuilder()).append("Permission:").append(((PackageItemInfo) (permissioninfo)).name).append(" belongs to group:").append(s).toString());
                    list1 = (List)hashmap2.get(s);
                    if(list1 == null) {
                        ArrayList arraylist = new ArrayList();
                        hashmap2.put(s, arraylist);
                        arraylist.add(permissioninfo);
                    } else {
                        int i = Collections.binarySearch(list1, permissioninfo, permissioninfocomparator);
                        if(localLOGV)
                            Log.i("AppSecurityPermissions", (new StringBuilder()).append("idx=").append(i).append(", list.size=").append(list1.size()).toString());
                        if(i < 0)
                            list1.add(-1 + -i, permissioninfo);
                    }
                }
            } while(true);
            aggregateGroupDescs(hashmap, mDangerousMap);
            aggregateGroupDescs(hashmap1, mNormalMap);
        }
        mCurrentState = State.NO_PERMS;
        if(mDangerousMap.size() <= 0) goto _L2; else goto _L1
_L1:
        State state;
        if(mNormalMap.size() > 0)
            state = State.BOTH;
        else
            state = State.DANGEROUS_ONLY;
        mCurrentState = state;
_L4:
        if(localLOGV)
            Log.i("AppSecurityPermissions", (new StringBuilder()).append("mCurrentState=").append(mCurrentState).toString());
        showPermissions();
        return;
_L2:
        if(mNormalMap.size() > 0)
            mCurrentState = State.NORMAL_ONLY;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void showPermissions() {
        class _cls1 {

            static final int $SwitchMap$android$widget$AppSecurityPermissions$State[];

            static  {
                $SwitchMap$android$widget$AppSecurityPermissions$State = new int[State.values().length];
                NoSuchFieldError nosuchfielderror3;
                try {
                    $SwitchMap$android$widget$AppSecurityPermissions$State[State.NO_PERMS.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                try {
                    $SwitchMap$android$widget$AppSecurityPermissions$State[State.DANGEROUS_ONLY.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                try {
                    $SwitchMap$android$widget$AppSecurityPermissions$State[State.NORMAL_ONLY.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror2) { }
                $SwitchMap$android$widget$AppSecurityPermissions$State[State.BOTH.ordinal()] = 4;
_L2:
                return;
                nosuchfielderror3;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        _cls1..SwitchMap.android.widget.AppSecurityPermissions.State[mCurrentState.ordinal()];
        JVM INSTR tableswitch 1 4: default 40
    //                   1 41
    //                   2 48
    //                   3 56
    //                   4 64;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        displayNoPermissions();
        continue; /* Loop/switch isn't completed */
_L3:
        displayPermissions(true);
        continue; /* Loop/switch isn't completed */
_L4:
        displayPermissions(false);
        continue; /* Loop/switch isn't completed */
_L5:
        displayPermissions(true);
        if(mExpanded) {
            displayPermissions(false);
            mShowMoreIcon.setImageDrawable(mShowMaxIcon);
            mShowMoreText.setText(0x1040427);
            mNonDangerousList.setVisibility(0);
        } else {
            mShowMoreIcon.setImageDrawable(mShowMinIcon);
            mShowMoreText.setText(0x1040428);
            mNonDangerousList.setVisibility(8);
        }
        mShowMore.setVisibility(0);
        if(true) goto _L1; else goto _L6
_L6:
    }

    public int getPermissionCount() {
        return mPermsList.size();
    }

    public View getPermissionsView() {
        mInflater = (LayoutInflater)mContext.getSystemService("layout_inflater");
        mPermsView = (LinearLayout)mInflater.inflate(0x109002b, null);
        mShowMore = mPermsView.findViewById(0x1020262);
        mShowMoreIcon = (ImageView)mShowMore.findViewById(0x1020264);
        mShowMoreText = (TextView)mShowMore.findViewById(0x1020263);
        mDangerousList = (LinearLayout)mPermsView.findViewById(0x1020261);
        mNonDangerousList = (LinearLayout)mPermsView.findViewById(0x1020265);
        mNoPermsView = mPermsView.findViewById(0x1020260);
        mShowMore.setClickable(true);
        mShowMore.setOnClickListener(this);
        mShowMore.setFocusable(true);
        mDefaultGrpLabel = mContext.getString(0x1040424);
        mPermFormat = mContext.getString(0x1040425);
        mNormalIcon = mContext.getResources().getDrawable(0x108035c);
        mDangerousIcon = mContext.getResources().getDrawable(0x10802b3);
        mShowMaxIcon = mContext.getResources().getDrawable(0x108026f);
        mShowMinIcon = mContext.getResources().getDrawable(0x1080276);
        setPermissions(mPermsList);
        return mPermsView;
    }

    public void onClick(View view) {
        if(localLOGV)
            Log.i("AppSecurityPermissions", (new StringBuilder()).append("mExpanded=").append(mExpanded).toString());
        boolean flag;
        if(!mExpanded)
            flag = true;
        else
            flag = false;
        mExpanded = flag;
        showPermissions();
    }

    private static final String TAG = "AppSecurityPermissions";
    private boolean localLOGV;
    private Context mContext;
    private State mCurrentState;
    private Drawable mDangerousIcon;
    private LinearLayout mDangerousList;
    private Map mDangerousMap;
    private String mDefaultGrpLabel;
    private String mDefaultGrpName;
    private boolean mExpanded;
    private HashMap mGroupLabelCache;
    private LayoutInflater mInflater;
    private View mNoPermsView;
    private LinearLayout mNonDangerousList;
    private Drawable mNormalIcon;
    private Map mNormalMap;
    private String mPermFormat;
    private List mPermsList;
    private LinearLayout mPermsView;
    private PackageManager mPm;
    private Drawable mShowMaxIcon;
    private Drawable mShowMinIcon;
    private View mShowMore;
    private ImageView mShowMoreIcon;
    private TextView mShowMoreText;
}
