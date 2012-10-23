// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.*;
import java.util.*;

// Referenced classes of package android.widget:
//            BaseAdapter, Filterable, TextView, Filter

public class ArrayAdapter extends BaseAdapter
    implements Filterable {
    private class ArrayFilter extends Filter {

        protected Filter.FilterResults performFiltering(CharSequence charsequence) {
            Filter.FilterResults filterresults;
            filterresults = new Filter.FilterResults();
            if(mOriginalValues == null)
                synchronized(mLock) {
                    mOriginalValues = new ArrayList(mObjects);
                }
            if(charsequence != null && charsequence.length() != 0) goto _L2; else goto _L1
_L1:
            ArrayList arraylist;
            synchronized(mLock) {
                arraylist = new ArrayList(mOriginalValues);
            }
            filterresults.values = arraylist;
            filterresults.count = arraylist.size();
_L10:
            return filterresults;
            exception2;
            obj3;
            JVM INSTR monitorexit ;
            throw exception2;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
_L2:
            String s;
            ArrayList arraylist1;
            int i;
            ArrayList arraylist2;
            int j;
            s = charsequence.toString().toLowerCase();
            synchronized(mLock) {
                arraylist1 = new ArrayList(mOriginalValues);
            }
            i = arraylist1.size();
            arraylist2 = new ArrayList();
            j = 0;
_L4:
            Object obj2;
            String s1;
            if(j >= i)
                break MISSING_BLOCK_LABEL_299;
            obj2 = arraylist1.get(j);
            s1 = obj2.toString().toLowerCase();
            if(!s1.startsWith(s))
                break; /* Loop/switch isn't completed */
            arraylist2.add(obj2);
_L6:
            j++;
            if(true) goto _L4; else goto _L3
            exception1;
            obj1;
            JVM INSTR monitorexit ;
            throw exception1;
_L3:
            String as[];
            int k;
            int l;
            as = s1.split(" ");
            k = as.length;
            l = 0;
_L8:
            if(l >= k) goto _L6; else goto _L5
_L5:
label0:
            {
                if(!as[l].startsWith(s))
                    break label0;
                arraylist2.add(obj2);
            }
            if(true) goto _L6; else goto _L7
_L7:
            l++;
              goto _L8
            filterresults.values = arraylist2;
            filterresults.count = arraylist2.size();
            if(true) goto _L10; else goto _L9
_L9:
        }

        protected void publishResults(CharSequence charsequence, Filter.FilterResults filterresults) {
            mObjects = (List)filterresults.values;
            if(filterresults.count > 0)
                notifyDataSetChanged();
            else
                notifyDataSetInvalidated();
        }

        final ArrayAdapter this$0;

        private ArrayFilter() {
            this$0 = ArrayAdapter.this;
            super();
        }

    }


    public ArrayAdapter(Context context, int i) {
        mLock = new Object();
        mFieldId = 0;
        mNotifyOnChange = true;
        init(context, i, 0, new ArrayList());
    }

    public ArrayAdapter(Context context, int i, int j) {
        mLock = new Object();
        mFieldId = 0;
        mNotifyOnChange = true;
        init(context, i, j, new ArrayList());
    }

    public ArrayAdapter(Context context, int i, int j, List list) {
        mLock = new Object();
        mFieldId = 0;
        mNotifyOnChange = true;
        init(context, i, j, list);
    }

    public ArrayAdapter(Context context, int i, int j, Object aobj[]) {
        mLock = new Object();
        mFieldId = 0;
        mNotifyOnChange = true;
        init(context, i, j, Arrays.asList(aobj));
    }

    public ArrayAdapter(Context context, int i, List list) {
        mLock = new Object();
        mFieldId = 0;
        mNotifyOnChange = true;
        init(context, i, 0, list);
    }

    public ArrayAdapter(Context context, int i, Object aobj[]) {
        mLock = new Object();
        mFieldId = 0;
        mNotifyOnChange = true;
        init(context, i, 0, Arrays.asList(aobj));
    }

    public static ArrayAdapter createFromResource(Context context, int i, int j) {
        return new ArrayAdapter(context, j, context.getResources().getTextArray(i));
    }

    private View createViewFromResource(int i, View view, ViewGroup viewgroup, int j) {
        View view1;
        TextView textview;
        if(view == null)
            view1 = mInflater.inflate(j, viewgroup, false);
        else
            view1 = view;
        if(mFieldId != 0)
            break MISSING_BLOCK_LABEL_65;
        textview = (TextView)view1;
_L1:
        Object obj = getItem(i);
        ClassCastException classcastexception;
        if(obj instanceof CharSequence)
            textview.setText((CharSequence)obj);
        else
            textview.setText(obj.toString());
        return view1;
        try {
            textview = (TextView)view1.findViewById(mFieldId);
        }
        // Misplaced declaration of an exception variable
        catch(ClassCastException classcastexception) {
            Log.e("ArrayAdapter", "You must supply a resource ID for a TextView");
            throw new IllegalStateException("ArrayAdapter requires the resource ID to be a TextView", classcastexception);
        }
          goto _L1
    }

    private void init(Context context, int i, int j, List list) {
        mContext = context;
        mInflater = (LayoutInflater)context.getSystemService("layout_inflater");
        mDropDownResource = i;
        mResource = i;
        mObjects = list;
        mFieldId = j;
    }

    public void add(Object obj) {
        Object obj1 = mLock;
        obj1;
        JVM INSTR monitorenter ;
        if(mOriginalValues == null)
            break MISSING_BLOCK_LABEL_37;
        mOriginalValues.add(obj);
_L2:
        if(mNotifyOnChange)
            notifyDataSetChanged();
        return;
        mObjects.add(obj);
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public void addAll(Collection collection) {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        if(mOriginalValues == null)
            break MISSING_BLOCK_LABEL_37;
        mOriginalValues.addAll(collection);
_L2:
        if(mNotifyOnChange)
            notifyDataSetChanged();
        return;
        mObjects.addAll(collection);
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public transient void addAll(Object aobj[]) {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        if(mOriginalValues == null)
            break MISSING_BLOCK_LABEL_37;
        Collections.addAll(mOriginalValues, aobj);
_L2:
        if(mNotifyOnChange)
            notifyDataSetChanged();
        return;
        Collections.addAll(mObjects, aobj);
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public void clear() {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        if(mOriginalValues == null)
            break MISSING_BLOCK_LABEL_35;
        mOriginalValues.clear();
_L2:
        if(mNotifyOnChange)
            notifyDataSetChanged();
        return;
        mObjects.clear();
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public Context getContext() {
        return mContext;
    }

    public int getCount() {
        return mObjects.size();
    }

    public View getDropDownView(int i, View view, ViewGroup viewgroup) {
        return createViewFromResource(i, view, viewgroup, mDropDownResource);
    }

    public Filter getFilter() {
        if(mFilter == null)
            mFilter = new ArrayFilter();
        return mFilter;
    }

    public Object getItem(int i) {
        return mObjects.get(i);
    }

    public long getItemId(int i) {
        return (long)i;
    }

    public int getPosition(Object obj) {
        return mObjects.indexOf(obj);
    }

    public View getView(int i, View view, ViewGroup viewgroup) {
        return createViewFromResource(i, view, viewgroup, mResource);
    }

    public void insert(Object obj, int i) {
        Object obj1 = mLock;
        obj1;
        JVM INSTR monitorenter ;
        if(mOriginalValues == null)
            break MISSING_BLOCK_LABEL_37;
        mOriginalValues.add(i, obj);
_L2:
        if(mNotifyOnChange)
            notifyDataSetChanged();
        return;
        mObjects.add(i, obj);
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        mNotifyOnChange = true;
    }

    public void remove(Object obj) {
        Object obj1 = mLock;
        obj1;
        JVM INSTR monitorenter ;
        if(mOriginalValues == null)
            break MISSING_BLOCK_LABEL_37;
        mOriginalValues.remove(obj);
_L2:
        if(mNotifyOnChange)
            notifyDataSetChanged();
        return;
        mObjects.remove(obj);
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public void setDropDownViewResource(int i) {
        mDropDownResource = i;
    }

    public void setNotifyOnChange(boolean flag) {
        mNotifyOnChange = flag;
    }

    public void sort(Comparator comparator) {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        if(mOriginalValues == null)
            break MISSING_BLOCK_LABEL_36;
        Collections.sort(mOriginalValues, comparator);
_L2:
        if(mNotifyOnChange)
            notifyDataSetChanged();
        return;
        Collections.sort(mObjects, comparator);
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    private Context mContext;
    private int mDropDownResource;
    private int mFieldId;
    private ArrayFilter mFilter;
    private LayoutInflater mInflater;
    private final Object mLock;
    private boolean mNotifyOnChange;
    private List mObjects;
    private ArrayList mOriginalValues;
    private int mResource;



/*
    static ArrayList access$102(ArrayAdapter arrayadapter, ArrayList arraylist) {
        arrayadapter.mOriginalValues = arraylist;
        return arraylist;
    }

*/




/*
    static List access$302(ArrayAdapter arrayadapter, List list) {
        arrayadapter.mObjects = list;
        return list;
    }

*/
}
