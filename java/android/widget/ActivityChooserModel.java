// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.*;
import android.content.pm.*;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import com.android.internal.content.PackageMonitor;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import org.xmlpull.v1.*;

public class ActivityChooserModel extends DataSetObservable {
    private final class DataModelPackageMonitor extends PackageMonitor {

        public void onSomePackagesChanged() {
            mReloadActivities = true;
        }

        final ActivityChooserModel this$0;

        private DataModelPackageMonitor() {
            this$0 = ActivityChooserModel.this;
            super();
        }

    }

    private final class PersistHistoryAsyncTask extends AsyncTask {

        public volatile Object doInBackground(Object aobj[]) {
            return doInBackground(aobj);
        }

        public transient Void doInBackground(Object aobj[]) {
            List list;
            String s;
            list = (List)aobj[0];
            s = (String)aobj[1];
            FileOutputStream fileoutputstream = mContext.openFileOutput(s, 0);
            XmlSerializer xmlserializer = Xml.newSerializer();
            int i;
            int j;
            xmlserializer.setOutput(fileoutputstream, null);
            xmlserializer.startDocument("UTF-8", Boolean.valueOf(true));
            xmlserializer.startTag(null, "historical-records");
            i = list.size();
            j = 0;
_L3:
            if(j >= i) goto _L2; else goto _L1
_L1:
            HistoricalRecord historicalrecord = (HistoricalRecord)list.remove(0);
            xmlserializer.startTag(null, "historical-record");
            xmlserializer.attribute(null, "activity", historicalrecord.activity.flattenToString());
            xmlserializer.attribute(null, "time", String.valueOf(historicalrecord.time));
            xmlserializer.attribute(null, "weight", String.valueOf(historicalrecord.weight));
            xmlserializer.endTag(null, "historical-record");
            j++;
              goto _L3
            FileNotFoundException filenotfoundexception;
            filenotfoundexception;
            Log.e(ActivityChooserModel.LOG_TAG, (new StringBuilder()).append("Error writing historical recrod file: ").append(s).toString(), filenotfoundexception);
_L5:
            return null;
_L2:
            xmlserializer.endTag(null, "historical-records");
            xmlserializer.endDocument();
            mCanReadHistoricalData = true;
            IllegalArgumentException illegalargumentexception;
            if(fileoutputstream != null)
                try {
                    fileoutputstream.close();
                }
                catch(IOException ioexception2) { }
            continue; /* Loop/switch isn't completed */
            illegalargumentexception;
            Log.e(ActivityChooserModel.LOG_TAG, (new StringBuilder()).append("Error writing historical recrod file: ").append(mHistoryFileName).toString(), illegalargumentexception);
            mCanReadHistoricalData = true;
            if(fileoutputstream == null)
                continue; /* Loop/switch isn't completed */
            fileoutputstream.close();
            continue; /* Loop/switch isn't completed */
            IllegalStateException illegalstateexception;
            illegalstateexception;
            Log.e(ActivityChooserModel.LOG_TAG, (new StringBuilder()).append("Error writing historical recrod file: ").append(mHistoryFileName).toString(), illegalstateexception);
            mCanReadHistoricalData = true;
            if(fileoutputstream == null)
                continue; /* Loop/switch isn't completed */
            fileoutputstream.close();
            continue; /* Loop/switch isn't completed */
            IOException ioexception1;
            ioexception1;
            Log.e(ActivityChooserModel.LOG_TAG, (new StringBuilder()).append("Error writing historical recrod file: ").append(mHistoryFileName).toString(), ioexception1);
            mCanReadHistoricalData = true;
            if(fileoutputstream == null)
                continue; /* Loop/switch isn't completed */
            fileoutputstream.close();
            if(true) goto _L5; else goto _L4
_L4:
            Exception exception;
            exception;
            mCanReadHistoricalData = true;
            if(fileoutputstream != null)
                try {
                    fileoutputstream.close();
                }
                catch(IOException ioexception) { }
            throw exception;
        }

        final ActivityChooserModel this$0;

        private PersistHistoryAsyncTask() {
            this$0 = ActivityChooserModel.this;
            super();
        }

    }

    private final class DefaultSorter
        implements ActivitySorter {

        public void sort(Intent intent, List list, List list1) {
            Map map = mPackageNameToActivityMap;
            map.clear();
            int i = list.size();
            for(int j = 0; j < i; j++) {
                ActivityResolveInfo activityresolveinfo1 = (ActivityResolveInfo)list.get(j);
                activityresolveinfo1.weight = 0.0F;
                map.put(((PackageItemInfo) (activityresolveinfo1.resolveInfo.activityInfo)).packageName, activityresolveinfo1);
            }

            int k = -1 + list1.size();
            float f = 1.0F;
            for(int l = k; l >= 0; l--) {
                HistoricalRecord historicalrecord = (HistoricalRecord)list1.get(l);
                ActivityResolveInfo activityresolveinfo = (ActivityResolveInfo)map.get(historicalrecord.activity.getPackageName());
                if(activityresolveinfo != null) {
                    activityresolveinfo.weight = activityresolveinfo.weight + f * historicalrecord.weight;
                    f *= 0.95F;
                }
            }

            Collections.sort(list);
        }

        private static final float WEIGHT_DECAY_COEFFICIENT = 0.95F;
        private final Map mPackageNameToActivityMap;
        final ActivityChooserModel this$0;

        private DefaultSorter() {
            this$0 = ActivityChooserModel.this;
            super();
            mPackageNameToActivityMap = new HashMap();
        }

    }

    public final class ActivityResolveInfo
        implements Comparable {

        public int compareTo(ActivityResolveInfo activityresolveinfo) {
            return Float.floatToIntBits(activityresolveinfo.weight) - Float.floatToIntBits(weight);
        }

        public volatile int compareTo(Object obj) {
            return compareTo((ActivityResolveInfo)obj);
        }

        public boolean equals(Object obj) {
            boolean flag = true;
            if(this != obj) goto _L2; else goto _L1
_L1:
            return flag;
_L2:
            if(obj == null)
                flag = false;
            else
            if(getClass() != obj.getClass()) {
                flag = false;
            } else {
                ActivityResolveInfo activityresolveinfo = (ActivityResolveInfo)obj;
                if(Float.floatToIntBits(weight) != Float.floatToIntBits(activityresolveinfo.weight))
                    flag = false;
            }
            if(true) goto _L1; else goto _L3
_L3:
        }

        public int hashCode() {
            return 31 + Float.floatToIntBits(weight);
        }

        public String toString() {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("[");
            stringbuilder.append("resolveInfo:").append(resolveInfo.toString());
            stringbuilder.append("; weight:").append(new BigDecimal(weight));
            stringbuilder.append("]");
            return stringbuilder.toString();
        }

        public final ResolveInfo resolveInfo;
        final ActivityChooserModel this$0;
        public float weight;

        public ActivityResolveInfo(ResolveInfo resolveinfo) {
            this$0 = ActivityChooserModel.this;
            super();
            resolveInfo = resolveinfo;
        }
    }

    public static final class HistoricalRecord {

        public boolean equals(Object obj) {
            boolean flag = true;
            if(this != obj) goto _L2; else goto _L1
_L1:
            return flag;
_L2:
            if(obj == null) {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            if(getClass() != obj.getClass()) {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            HistoricalRecord historicalrecord = (HistoricalRecord)obj;
            if(activity == null) {
                if(historicalrecord.activity != null) {
                    flag = false;
                    continue; /* Loop/switch isn't completed */
                }
            } else
            if(!activity.equals(historicalrecord.activity)) {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            if(time != historicalrecord.time)
                flag = false;
            else
            if(Float.floatToIntBits(weight) != Float.floatToIntBits(historicalrecord.weight))
                flag = false;
            if(true) goto _L1; else goto _L3
_L3:
        }

        public int hashCode() {
            int i;
            if(activity == null)
                i = 0;
            else
                i = activity.hashCode();
            return 31 * (31 * (i + 31) + (int)(time ^ time >>> 32)) + Float.floatToIntBits(weight);
        }

        public String toString() {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("[");
            stringbuilder.append("; activity:").append(activity);
            stringbuilder.append("; time:").append(time);
            stringbuilder.append("; weight:").append(new BigDecimal(weight));
            stringbuilder.append("]");
            return stringbuilder.toString();
        }

        public final ComponentName activity;
        public final long time;
        public final float weight;

        public HistoricalRecord(ComponentName componentname, long l, float f) {
            activity = componentname;
            time = l;
            weight = f;
        }

        public HistoricalRecord(String s, long l, float f) {
            this(ComponentName.unflattenFromString(s), l, f);
        }
    }

    public static interface OnChooseActivityListener {

        public abstract boolean onChooseActivity(ActivityChooserModel activitychoosermodel, Intent intent);
    }

    public static interface ActivitySorter {

        public abstract void sort(Intent intent, List list, List list1);
    }

    public static interface ActivityChooserModelClient {

        public abstract void setActivityChooserModel(ActivityChooserModel activitychoosermodel);
    }


    private ActivityChooserModel(Context context, String s) {
        mActivitySorter = new DefaultSorter();
        mHistoryMaxSize = 50;
        mCanReadHistoricalData = true;
        mReadShareHistoryCalled = false;
        mHistoricalRecordsChanged = true;
        mReloadActivities = false;
        mContext = context.getApplicationContext();
        if(!TextUtils.isEmpty(s) && !s.endsWith(".xml"))
            mHistoryFileName = (new StringBuilder()).append(s).append(".xml").toString();
        else
            mHistoryFileName = s;
        mPackageMonitor.register(mContext, null, true);
    }

    private boolean addHisoricalRecord(HistoricalRecord historicalrecord) {
        boolean flag = mHistoricalRecords.add(historicalrecord);
        if(flag) {
            mHistoricalRecordsChanged = true;
            pruneExcessiveHistoricalRecordsIfNeeded();
            persistHistoricalDataIfNeeded();
            sortActivitiesIfNeeded();
            notifyChanged();
        }
        return flag;
    }

    private void ensureConsistentState() {
        boolean flag = loadActivitiesIfNeeded() | readHistoricalDataIfNeeded();
        pruneExcessiveHistoricalRecordsIfNeeded();
        if(flag) {
            sortActivitiesIfNeeded();
            notifyChanged();
        }
    }

    public static ActivityChooserModel get(Context context, String s) {
        Object obj = sRegistryLock;
        obj;
        JVM INSTR monitorenter ;
        ActivityChooserModel activitychoosermodel = (ActivityChooserModel)sDataModelRegistry.get(s);
        if(activitychoosermodel == null) {
            activitychoosermodel = new ActivityChooserModel(context, s);
            sDataModelRegistry.put(s, activitychoosermodel);
        }
        return activitychoosermodel;
    }

    private boolean loadActivitiesIfNeeded() {
        boolean flag = false;
        if(mReloadActivities && mIntent != null) {
            mReloadActivities = false;
            mActivities.clear();
            List list = mContext.getPackageManager().queryIntentActivities(mIntent, 0);
            int i = list.size();
            for(int j = 0; j < i; j++) {
                ResolveInfo resolveinfo = (ResolveInfo)list.get(j);
                mActivities.add(new ActivityResolveInfo(resolveinfo));
            }

            flag = true;
        }
        return flag;
    }

    private void persistHistoricalDataIfNeeded() {
        if(!mReadShareHistoryCalled)
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        if(mHistoricalRecordsChanged) goto _L2; else goto _L1
_L1:
        return;
_L2:
        mHistoricalRecordsChanged = false;
        if(!TextUtils.isEmpty(mHistoryFileName)) {
            PersistHistoryAsyncTask persisthistoryasynctask = new PersistHistoryAsyncTask();
            java.util.concurrent.Executor executor = AsyncTask.SERIAL_EXECUTOR;
            Object aobj[] = new Object[2];
            aobj[0] = new ArrayList(mHistoricalRecords);
            aobj[1] = mHistoryFileName;
            persisthistoryasynctask.executeOnExecutor(executor, aobj);
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void pruneExcessiveHistoricalRecordsIfNeeded() {
        int i = mHistoricalRecords.size() - mHistoryMaxSize;
        if(i > 0) {
            mHistoricalRecordsChanged = true;
            int j = 0;
            while(j < i)  {
                HistoricalRecord _tmp = (HistoricalRecord)mHistoricalRecords.remove(0);
                j++;
            }
        }
    }

    private boolean readHistoricalDataIfNeeded() {
        boolean flag = true;
        if(mCanReadHistoricalData && mHistoricalRecordsChanged && !TextUtils.isEmpty(mHistoryFileName)) {
            mCanReadHistoricalData = false;
            mReadShareHistoryCalled = flag;
            readHistoricalDataImpl();
        } else {
            flag = false;
        }
        return flag;
    }

    private void readHistoricalDataImpl() {
        FileInputStream fileinputstream = mContext.openFileInput(mHistoryFileName);
        XmlPullParser xmlpullparser;
        xmlpullparser = Xml.newPullParser();
        xmlpullparser.setInput(fileinputstream, null);
        for(int i = 0; i != 1 && i != 2; i = xmlpullparser.next());
        if(!"historical-records".equals(xmlpullparser.getName()))
            throw new XmlPullParserException("Share records file does not start with historical-records tag.");
        break MISSING_BLOCK_LABEL_129;
        XmlPullParserException xmlpullparserexception;
        xmlpullparserexception;
        Log.e(LOG_TAG, (new StringBuilder()).append("Error reading historical recrod file: ").append(mHistoryFileName).toString(), xmlpullparserexception);
        if(fileinputstream != null)
            try {
                fileinputstream.close();
            }
            catch(IOException ioexception2) { }
        break MISSING_BLOCK_LABEL_322;
        List list;
        list = mHistoricalRecords;
        list.clear();
_L4:
        int j = xmlpullparser.next();
        if(j != 1) goto _L2; else goto _L1
_L1:
        if(fileinputstream == null)
            break MISSING_BLOCK_LABEL_322;
        fileinputstream.close();
        break MISSING_BLOCK_LABEL_322;
_L2:
        if(j == 3 || j == 4) goto _L4; else goto _L3
_L3:
        if(!"historical-record".equals(xmlpullparser.getName()))
            throw new XmlPullParserException("Share records file not well-formed.");
        break MISSING_BLOCK_LABEL_251;
        IOException ioexception1;
        ioexception1;
        Log.e(LOG_TAG, (new StringBuilder()).append("Error reading historical recrod file: ").append(mHistoryFileName).toString(), ioexception1);
        if(fileinputstream == null)
            break MISSING_BLOCK_LABEL_322;
        fileinputstream.close();
        break MISSING_BLOCK_LABEL_322;
        list.add(new HistoricalRecord(xmlpullparser.getAttributeValue(null, "activity"), Long.parseLong(xmlpullparser.getAttributeValue(null, "time")), Float.parseFloat(xmlpullparser.getAttributeValue(null, "weight"))));
          goto _L4
        Exception exception;
        exception;
        if(fileinputstream != null)
            try {
                fileinputstream.close();
            }
            catch(IOException ioexception) { }
        throw exception;
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
    }

    private boolean sortActivitiesIfNeeded() {
        boolean flag;
        if(mActivitySorter != null && mIntent != null && !mActivities.isEmpty() && !mHistoricalRecords.isEmpty()) {
            mActivitySorter.sort(mIntent, mActivities, Collections.unmodifiableList(mHistoricalRecords));
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public Intent chooseActivity(int i) {
        Object obj = mInstanceLock;
        obj;
        JVM INSTR monitorenter ;
        Intent intent;
label0:
        {
            ensureConsistentState();
            ActivityResolveInfo activityresolveinfo = (ActivityResolveInfo)mActivities.get(i);
            ComponentName componentname = new ComponentName(((PackageItemInfo) (activityresolveinfo.resolveInfo.activityInfo)).packageName, ((PackageItemInfo) (activityresolveinfo.resolveInfo.activityInfo)).name);
            intent = new Intent(mIntent);
            intent.setComponent(componentname);
            if(mActivityChoserModelPolicy != null) {
                Intent intent1 = new Intent(intent);
                if(mActivityChoserModelPolicy.onChooseActivity(this, intent1)) {
                    intent = null;
                    break label0;
                }
            }
            addHisoricalRecord(new HistoricalRecord(componentname, System.currentTimeMillis(), 1.0F));
        }
        return intent;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        mPackageMonitor.unregister();
    }

    public ResolveInfo getActivity(int i) {
        Object obj = mInstanceLock;
        obj;
        JVM INSTR monitorenter ;
        ensureConsistentState();
        ResolveInfo resolveinfo = ((ActivityResolveInfo)mActivities.get(i)).resolveInfo;
        return resolveinfo;
    }

    public int getActivityCount() {
        Object obj = mInstanceLock;
        obj;
        JVM INSTR monitorenter ;
        ensureConsistentState();
        int i = mActivities.size();
        return i;
    }

    public int getActivityIndex(ResolveInfo resolveinfo) {
        Object obj = mInstanceLock;
        obj;
        JVM INSTR monitorenter ;
        ensureConsistentState();
        List list = mActivities;
        int i = list.size();
        int j = 0;
        do {
label0:
            {
                if(j < i) {
                    if(((ActivityResolveInfo)list.get(j)).resolveInfo != resolveinfo)
                        break label0;
                } else {
                    j = -1;
                }
                return j;
            }
            j++;
        } while(true);
    }

    public ResolveInfo getDefaultActivity() {
        Object obj = mInstanceLock;
        obj;
        JVM INSTR monitorenter ;
        ensureConsistentState();
        ResolveInfo resolveinfo;
        if(!mActivities.isEmpty())
            resolveinfo = ((ActivityResolveInfo)mActivities.get(0)).resolveInfo;
        else
            resolveinfo = null;
        return resolveinfo;
    }

    public int getHistoryMaxSize() {
        Object obj = mInstanceLock;
        obj;
        JVM INSTR monitorenter ;
        int i = mHistoryMaxSize;
        return i;
    }

    public int getHistorySize() {
        Object obj = mInstanceLock;
        obj;
        JVM INSTR monitorenter ;
        ensureConsistentState();
        int i = mHistoricalRecords.size();
        return i;
    }

    public Intent getIntent() {
        Object obj = mInstanceLock;
        obj;
        JVM INSTR monitorenter ;
        Intent intent = mIntent;
        return intent;
    }

    public void setActivitySorter(ActivitySorter activitysorter) {
        Object obj = mInstanceLock;
        obj;
        JVM INSTR monitorenter ;
        if(mActivitySorter != activitysorter) {
            mActivitySorter = activitysorter;
            if(sortActivitiesIfNeeded())
                notifyChanged();
        }
        return;
    }

    public void setDefaultActivity(int i) {
        Object obj = mInstanceLock;
        obj;
        JVM INSTR monitorenter ;
        ensureConsistentState();
        ActivityResolveInfo activityresolveinfo = (ActivityResolveInfo)mActivities.get(i);
        ActivityResolveInfo activityresolveinfo1 = (ActivityResolveInfo)mActivities.get(0);
        float f;
        if(activityresolveinfo1 != null)
            f = 5F + (activityresolveinfo1.weight - activityresolveinfo.weight);
        else
            f = 1.0F;
        addHisoricalRecord(new HistoricalRecord(new ComponentName(((PackageItemInfo) (activityresolveinfo.resolveInfo.activityInfo)).packageName, ((PackageItemInfo) (activityresolveinfo.resolveInfo.activityInfo)).name), System.currentTimeMillis(), f));
        return;
    }

    public void setHistoryMaxSize(int i) {
        Object obj = mInstanceLock;
        obj;
        JVM INSTR monitorenter ;
        if(mHistoryMaxSize != i) {
            mHistoryMaxSize = i;
            pruneExcessiveHistoricalRecordsIfNeeded();
            if(sortActivitiesIfNeeded())
                notifyChanged();
        }
        return;
    }

    public void setIntent(Intent intent) {
        Object obj = mInstanceLock;
        obj;
        JVM INSTR monitorenter ;
        if(mIntent != intent) {
            mIntent = intent;
            mReloadActivities = true;
            ensureConsistentState();
        }
        return;
    }

    public void setOnChooseActivityListener(OnChooseActivityListener onchooseactivitylistener) {
        Object obj = mInstanceLock;
        obj;
        JVM INSTR monitorenter ;
        mActivityChoserModelPolicy = onchooseactivitylistener;
        return;
    }

    private static final String ATTRIBUTE_ACTIVITY = "activity";
    private static final String ATTRIBUTE_TIME = "time";
    private static final String ATTRIBUTE_WEIGHT = "weight";
    private static final boolean DEBUG = false;
    private static final int DEFAULT_ACTIVITY_INFLATION = 5;
    private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1F;
    public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
    private static final String HISTORY_FILE_EXTENSION = ".xml";
    private static final int INVALID_INDEX = -1;
    private static final String LOG_TAG = android/widget/ActivityChooserModel.getSimpleName();
    private static final String TAG_HISTORICAL_RECORD = "historical-record";
    private static final String TAG_HISTORICAL_RECORDS = "historical-records";
    private static final Map sDataModelRegistry = new HashMap();
    private static final Object sRegistryLock = new Object();
    private final List mActivities = new ArrayList();
    private OnChooseActivityListener mActivityChoserModelPolicy;
    private ActivitySorter mActivitySorter;
    private boolean mCanReadHistoricalData;
    private final Context mContext;
    private final List mHistoricalRecords = new ArrayList();
    private boolean mHistoricalRecordsChanged;
    private final String mHistoryFileName;
    private int mHistoryMaxSize;
    private final Object mInstanceLock = new Object();
    private Intent mIntent;
    private final PackageMonitor mPackageMonitor = new DataModelPackageMonitor();
    private boolean mReadShareHistoryCalled;
    private boolean mReloadActivities;






/*
    static boolean access$602(ActivityChooserModel activitychoosermodel, boolean flag) {
        activitychoosermodel.mCanReadHistoricalData = flag;
        return flag;
    }

*/


/*
    static boolean access$702(ActivityChooserModel activitychoosermodel, boolean flag) {
        activitychoosermodel.mReloadActivities = flag;
        return flag;
    }

*/
}
