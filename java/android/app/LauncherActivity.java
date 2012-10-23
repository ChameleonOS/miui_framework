// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.Intent;
import android.content.pm.*;
import android.content.res.Resources;
import android.graphics.*;
import android.graphics.drawable.*;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import java.util.*;

// Referenced classes of package android.app:
//            ListActivity

public abstract class LauncherActivity extends ListActivity {
    public class IconResizer {

        public Drawable createIconThumbnail(Drawable drawable) {
            int i = mIconWidth;
            int j = mIconHeight;
            int k = drawable.getIntrinsicWidth();
            int l = drawable.getIntrinsicHeight();
            if(drawable instanceof PaintDrawable) {
                PaintDrawable paintdrawable = (PaintDrawable)drawable;
                paintdrawable.setIntrinsicWidth(i);
                paintdrawable.setIntrinsicHeight(j);
            }
            if(i > 0 && j > 0)
                if(i < k || j < l) {
                    float f = (float)k / (float)l;
                    android.graphics.Bitmap.Config config;
                    Bitmap bitmap;
                    Canvas canvas;
                    int i1;
                    int j1;
                    if(k > l)
                        j = (int)((float)i / f);
                    else
                    if(l > k)
                        i = (int)(f * (float)j);
                    if(drawable.getOpacity() != -1)
                        config = android.graphics.Bitmap.Config.ARGB_8888;
                    else
                        config = android.graphics.Bitmap.Config.RGB_565;
                    bitmap = Bitmap.createBitmap(mIconWidth, mIconHeight, config);
                    canvas = mCanvas;
                    canvas.setBitmap(bitmap);
                    mOldBounds.set(drawable.getBounds());
                    i1 = (mIconWidth - i) / 2;
                    j1 = (mIconHeight - j) / 2;
                    drawable.setBounds(i1, j1, i1 + i, j1 + j);
                    drawable.draw(canvas);
                    drawable.setBounds(mOldBounds);
                    drawable = new BitmapDrawable(getResources(), bitmap);
                    canvas.setBitmap(null);
                } else
                if(k < i && l < j) {
                    android.graphics.Bitmap.Config config1 = android.graphics.Bitmap.Config.ARGB_8888;
                    Bitmap bitmap1 = Bitmap.createBitmap(mIconWidth, mIconHeight, config1);
                    Canvas canvas1 = mCanvas;
                    canvas1.setBitmap(bitmap1);
                    mOldBounds.set(drawable.getBounds());
                    int k1 = (i - k) / 2;
                    int l1 = (j - l) / 2;
                    drawable.setBounds(k1, l1, k1 + k, l1 + l);
                    drawable.draw(canvas1);
                    drawable.setBounds(mOldBounds);
                    drawable = new BitmapDrawable(getResources(), bitmap1);
                    canvas1.setBitmap(null);
                }
            return drawable;
        }

        private Canvas mCanvas;
        private int mIconHeight;
        private int mIconWidth;
        private final Rect mOldBounds = new Rect();
        final LauncherActivity this$0;

        public IconResizer() {
            this$0 = LauncherActivity.this;
            super();
            mIconWidth = -1;
            mIconHeight = -1;
            mCanvas = new Canvas();
            mCanvas.setDrawFilter(new PaintFlagsDrawFilter(4, 2));
            int i = (int)getResources().getDimension(0x1050000);
            mIconHeight = i;
            mIconWidth = i;
        }
    }

    private class ActivityAdapter extends BaseAdapter
        implements Filterable {
        private class ArrayFilter extends Filter {

            protected android.widget.Filter.FilterResults performFiltering(CharSequence charsequence) {
                android.widget.Filter.FilterResults filterresults;
                filterresults = new android.widget.Filter.FilterResults();
                if(mOriginalValues == null)
                    synchronized(lock) {
                        mOriginalValues = new ArrayList(mActivitiesList);
                    }
                if(charsequence != null && charsequence.length() != 0) goto _L2; else goto _L1
_L1:
                synchronized(lock) {
                    ArrayList arraylist = new ArrayList(mOriginalValues);
                    filterresults.values = arraylist;
                    filterresults.count = arraylist.size();
                }
_L4:
                return filterresults;
                exception1;
                obj1;
                JVM INSTR monitorexit ;
                throw exception1;
                exception;
                obj;
                JVM INSTR monitorexit ;
                throw exception;
_L2:
                ArrayList arraylist2;
label0:
                {
                    String s = charsequence.toString().toLowerCase();
                    ArrayList arraylist1 = mOriginalValues;
                    int i = arraylist1.size();
                    arraylist2 = new ArrayList(i);
                    int j = 0;
                    do {
                        if(j >= i)
                            break label0;
                        ListItem listitem = (ListItem)arraylist1.get(j);
                        String as[] = listitem.label.toString().toLowerCase().split(" ");
                        int k = as.length;
                        int l = 0;
                        do {
label1:
                            {
                                if(l < k) {
                                    if(!as[l].startsWith(s))
                                        break label1;
                                    arraylist2.add(listitem);
                                }
                                j++;
                            }
                            if(true)
                                break;
                            l++;
                        } while(true);
                    } while(true);
                }
                filterresults.values = arraylist2;
                filterresults.count = arraylist2.size();
                if(true) goto _L4; else goto _L3
_L3:
            }

            protected void publishResults(CharSequence charsequence, android.widget.Filter.FilterResults filterresults) {
                mActivitiesList = (List)filterresults.values;
                if(filterresults.count > 0)
                    notifyDataSetChanged();
                else
                    notifyDataSetInvalidated();
            }

            final ActivityAdapter this$1;

            private ArrayFilter() {
                this$1 = ActivityAdapter.this;
                super();
            }

        }


        private void bindView(View view, ListItem listitem) {
            TextView textview = (TextView)view;
            textview.setText(listitem.label);
            if(mShowIcons) {
                if(listitem.icon == null)
                    listitem.icon = mIconResizer.createIconThumbnail(listitem.resolveInfo.loadIcon(getPackageManager()));
                textview.setCompoundDrawablesWithIntrinsicBounds(listitem.icon, null, null, null);
            }
        }

        public int getCount() {
            int i;
            if(mActivitiesList != null)
                i = mActivitiesList.size();
            else
                i = 0;
            return i;
        }

        public Filter getFilter() {
            if(mFilter == null)
                mFilter = new ArrayFilter();
            return mFilter;
        }

        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        public long getItemId(int i) {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup) {
            View view1;
            if(view == null)
                view1 = mInflater.inflate(0x1090021, viewgroup, false);
            else
                view1 = view;
            bindView(view1, (ListItem)mActivitiesList.get(i));
            return view1;
        }

        public Intent intentForPosition(int i) {
            if(mActivitiesList != null) goto _L2; else goto _L1
_L1:
            Intent intent = null;
_L4:
            return intent;
_L2:
            intent = new Intent(mIntent);
            ListItem listitem = (ListItem)mActivitiesList.get(i);
            intent.setClassName(listitem.packageName, listitem.className);
            if(listitem.extras != null)
                intent.putExtras(listitem.extras);
            if(true) goto _L4; else goto _L3
_L3:
        }

        public ListItem itemForPosition(int i) {
            ListItem listitem;
            if(mActivitiesList == null)
                listitem = null;
            else
                listitem = (ListItem)mActivitiesList.get(i);
            return listitem;
        }

        private final Object lock = new Object();
        protected List mActivitiesList;
        private Filter mFilter;
        protected final IconResizer mIconResizer;
        protected final LayoutInflater mInflater;
        private ArrayList mOriginalValues;
        private final boolean mShowIcons;
        final LauncherActivity this$0;



/*
        static ArrayList access$102(ActivityAdapter activityadapter, ArrayList arraylist) {
            activityadapter.mOriginalValues = arraylist;
            return arraylist;
        }

*/


        public ActivityAdapter(IconResizer iconresizer) {
            this$0 = LauncherActivity.this;
            super();
            mIconResizer = iconresizer;
            mInflater = (LayoutInflater)getSystemService("layout_inflater");
            mShowIcons = onEvaluateShowIcons();
            mActivitiesList = makeListItems();
        }
    }

    public static class ListItem {

        public String className;
        public Bundle extras;
        public Drawable icon;
        public CharSequence label;
        public String packageName;
        public ResolveInfo resolveInfo;

        public ListItem() {
        }

        ListItem(PackageManager packagemanager, ResolveInfo resolveinfo, IconResizer iconresizer) {
            resolveInfo = resolveinfo;
            label = resolveinfo.loadLabel(packagemanager);
            Object obj = resolveinfo.activityInfo;
            if(obj == null)
                obj = resolveinfo.serviceInfo;
            if(label == null && obj != null)
                label = ((PackageItemInfo) (resolveinfo.activityInfo)).name;
            if(iconresizer != null)
                icon = iconresizer.createIconThumbnail(resolveinfo.loadIcon(packagemanager));
            packageName = ((PackageItemInfo) (((ComponentInfo) (obj)).applicationInfo)).packageName;
            className = ((PackageItemInfo) (obj)).name;
        }
    }


    public LauncherActivity() {
    }

    private void updateAlertTitle() {
        TextView textview = (TextView)findViewById(0x102024d);
        if(textview != null)
            textview.setText(getTitle());
    }

    private void updateButtonText() {
        Button button = (Button)findViewById(0x1020019);
        if(button != null)
            button.setOnClickListener(new android.view.View.OnClickListener() {

                public void onClick(View view) {
                    finish();
                }

                final LauncherActivity this$0;

             {
                this$0 = LauncherActivity.this;
                super();
            }
            });
    }

    protected Intent getTargetIntent() {
        return new Intent();
    }

    protected Intent intentForPosition(int i) {
        return ((ActivityAdapter)super.mAdapter).intentForPosition(i);
    }

    protected ListItem itemForPosition(int i) {
        return ((ActivityAdapter)super.mAdapter).itemForPosition(i);
    }

    public List makeListItems() {
        List list = onQueryPackageManager(mIntent);
        Collections.sort(list, new android.content.pm.ResolveInfo.DisplayNameComparator(mPackageManager));
        ArrayList arraylist = new ArrayList(list.size());
        int i = list.size();
        for(int j = 0; j < i; j++) {
            ResolveInfo resolveinfo = (ResolveInfo)list.get(j);
            arraylist.add(new ListItem(mPackageManager, resolveinfo, null));
        }

        return arraylist;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mPackageManager = getPackageManager();
        requestWindowFeature(5);
        setProgressBarIndeterminateVisibility(true);
        onSetContentView();
        mIconResizer = new IconResizer();
        mIntent = new Intent(getTargetIntent());
        mIntent.setComponent(null);
        super.mAdapter = new ActivityAdapter(mIconResizer);
        setListAdapter(super.mAdapter);
        getListView().setTextFilterEnabled(true);
        updateAlertTitle();
        updateButtonText();
        setProgressBarIndeterminateVisibility(false);
    }

    protected boolean onEvaluateShowIcons() {
        return true;
    }

    protected void onListItemClick(ListView listview, View view, int i, long l) {
        startActivity(intentForPosition(i));
    }

    protected List onQueryPackageManager(Intent intent) {
        return mPackageManager.queryIntentActivities(intent, 0);
    }

    protected void onSetContentView() {
        setContentView(0x1090020);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        updateAlertTitle();
    }

    public void setTitle(CharSequence charsequence) {
        super.setTitle(charsequence);
        updateAlertTitle();
    }

    IconResizer mIconResizer;
    Intent mIntent;
    PackageManager mPackageManager;
}
