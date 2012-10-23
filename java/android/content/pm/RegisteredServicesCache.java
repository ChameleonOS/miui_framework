// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import android.content.*;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Environment;
import android.os.Handler;
import android.util.*;
import com.android.internal.os.AtomicFile;
import com.android.internal.util.FastXmlSerializer;
import com.google.android.collect.Lists;
import com.google.android.collect.Maps;
import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import org.xmlpull.v1.*;

// Referenced classes of package android.content.pm:
//            PackageManager, PackageInfo, ApplicationInfo, ResolveInfo, 
//            PackageItemInfo, ServiceInfo, ComponentInfo, XmlSerializerAndParser, 
//            RegisteredServicesCacheListener

public abstract class RegisteredServicesCache {
    public static class ServiceInfo {

        public String toString() {
            return (new StringBuilder()).append("ServiceInfo: ").append(type).append(", ").append(componentName).append(", uid ").append(uid).toString();
        }

        public final ComponentName componentName;
        public final Object type;
        public final int uid;

        public ServiceInfo(Object obj, ComponentName componentname, int i) {
            type = obj;
            componentName = componentname;
            uid = i;
        }
    }


    public RegisteredServicesCache(Context context, String s, String s1, String s2, XmlSerializerAndParser xmlserializerandparser) {
        mContext = context;
        mInterfaceName = s;
        mMetaDataName = s1;
        mAttributesName = s2;
        mSerializerAndParser = xmlserializerandparser;
        mPersistentServicesFile = new AtomicFile(new File(new File(new File(Environment.getDataDirectory(), "system"), "registered_services"), (new StringBuilder()).append(s).append(".xml").toString()));
        generateServicesMap();
        BroadcastReceiver broadcastreceiver = new BroadcastReceiver() {

            public void onReceive(Context context1, Intent intent) {
                generateServicesMap();
            }

            final RegisteredServicesCache this$0;

             {
                this$0 = RegisteredServicesCache.this;
                super();
            }
        };
        mReceiver = new AtomicReference(broadcastreceiver);
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentfilter.addAction("android.intent.action.PACKAGE_CHANGED");
        intentfilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentfilter.addDataScheme("package");
        mContext.registerReceiver(broadcastreceiver, intentfilter);
        IntentFilter intentfilter1 = new IntentFilter();
        intentfilter1.addAction("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE");
        intentfilter1.addAction("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE");
        mContext.registerReceiver(broadcastreceiver, intentfilter1);
    }

    private boolean containsType(ArrayList arraylist, Object obj) {
        int i;
        int j;
        i = 0;
        j = arraylist.size();
_L3:
        if(i >= j)
            break MISSING_BLOCK_LABEL_44;
        if(!((ServiceInfo)arraylist.get(i)).type.equals(obj)) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        i++;
          goto _L3
        flag = false;
          goto _L4
    }

    private boolean containsTypeAndUid(ArrayList arraylist, Object obj, int i) {
        int j;
        int k;
        j = 0;
        k = arraylist.size();
_L3:
        ServiceInfo serviceinfo;
        if(j >= k)
            break MISSING_BLOCK_LABEL_60;
        serviceinfo = (ServiceInfo)arraylist.get(j);
        if(!serviceinfo.type.equals(obj) || serviceinfo.uid != i) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        j++;
          goto _L3
        flag = false;
          goto _L4
    }

    private boolean inSystemImage(int i) {
        boolean flag;
        String as[];
        int j;
        int k;
        flag = false;
        as = mContext.getPackageManager().getPackagesForUid(i);
        j = as.length;
        k = 0;
_L4:
        String s;
        if(k >= j)
            break MISSING_BLOCK_LABEL_64;
        s = as[k];
        int l = mContext.getPackageManager().getPackageInfo(s, 0).applicationInfo.flags;
        if((l & 1) == 0)
            break MISSING_BLOCK_LABEL_71;
        flag = true;
_L2:
        return flag;
        PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        if(true) goto _L2; else goto _L1
_L1:
        k++;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void notifyListener(final Object type, final boolean removed) {
        final RegisteredServicesCacheListener listener2;
        Handler handler;
        if(Log.isLoggable("PackageManager", 2)) {
            StringBuilder stringbuilder = (new StringBuilder()).append("notifyListener: ").append(type).append(" is ");
            String s;
            if(removed)
                s = "removed";
            else
                s = "added";
            Log.d("PackageManager", stringbuilder.append(s).toString());
        }
        this;
        JVM INSTR monitorenter ;
        listener2 = mListener;
        handler = mHandler;
        this;
        JVM INSTR monitorexit ;
        Exception exception;
        if(listener2 != null)
            handler.post(new Runnable() {

                public void run() {
                    listener2.onServiceChanged(type, removed);
                }

                final RegisteredServicesCache this$0;
                final RegisteredServicesCacheListener val$listener2;
                final boolean val$removed;
                final Object val$type;

             {
                this$0 = RegisteredServicesCache.this;
                listener2 = registeredservicescachelistener;
                type = obj;
                removed = flag;
                super();
            }
            });
        return;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private ServiceInfo parseServiceInfo(ResolveInfo resolveinfo) throws XmlPullParserException, IOException {
        android.content.pm.ServiceInfo serviceinfo;
        ComponentName componentname;
        PackageManager packagemanager;
        XmlResourceParser xmlresourceparser;
label0:
        {
            serviceinfo = resolveinfo.serviceInfo;
            componentname = new ComponentName(((PackageItemInfo) (serviceinfo)).packageName, ((PackageItemInfo) (serviceinfo)).name);
            packagemanager = mContext.getPackageManager();
            xmlresourceparser = null;
            try {
                xmlresourceparser = serviceinfo.loadXmlMetaData(packagemanager, mMetaDataName);
                if(xmlresourceparser == null)
                    throw new XmlPullParserException((new StringBuilder()).append("No ").append(mMetaDataName).append(" meta-data").toString());
                break label0;
            }
            catch(PackageManager.NameNotFoundException namenotfoundexception) { }
            finally {
                if(xmlresourceparser != null)
                    xmlresourceparser.close();
                throw exception;
            }
        }
        throw new XmlPullParserException((new StringBuilder()).append("Unable to load resources for pacakge ").append(((PackageItemInfo) (serviceinfo)).packageName).toString());
        Object obj;
        AttributeSet attributeset = Xml.asAttributeSet(xmlresourceparser);
        int i;
        do
            i = xmlresourceparser.next();
        while(i != 1 && i != 2);
        String s = xmlresourceparser.getName();
        if(!mAttributesName.equals(s))
            throw new XmlPullParserException((new StringBuilder()).append("Meta-data does not start with ").append(mAttributesName).append(" tag").toString());
        obj = parseServiceAttributes(packagemanager.getResourcesForApplication(((ComponentInfo) (serviceinfo)).applicationInfo), ((PackageItemInfo) (serviceinfo)).packageName, attributeset);
        if(obj != null) goto _L2; else goto _L1
_L1:
        ServiceInfo serviceinfo1;
        serviceinfo1 = null;
        if(xmlresourceparser != null)
            xmlresourceparser.close();
_L4:
        return serviceinfo1;
_L2:
        serviceinfo1 = new ServiceInfo(obj, componentname, ((ComponentInfo) (resolveinfo.serviceInfo)).applicationInfo.uid);
        if(xmlresourceparser != null)
            xmlresourceparser.close();
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void readPersistentServicesLocked() {
        mPersistentServices = Maps.newHashMap();
        if(mSerializerAndParser != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        FileInputStream fileinputstream = null;
        boolean flag;
        if(mPersistentServicesFile.getBaseFile().exists())
            break MISSING_BLOCK_LABEL_61;
        flag = true;
_L3:
        boolean flag1;
        mPersistentServicesFileDidNotExist = flag;
        flag1 = mPersistentServicesFileDidNotExist;
        if(flag1) {
            if(false)
                try {
                    throw null;
                }
                catch(IOException ioexception3) { }
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_67;
        flag = false;
          goto _L3
        XmlPullParser xmlpullparser;
        fileinputstream = mPersistentServicesFile.openRead();
        xmlpullparser = Xml.newPullParser();
        xmlpullparser.setInput(fileinputstream, null);
        for(int i = xmlpullparser.getEventType(); i != 2; i = xmlpullparser.next());
        if(!"services".equals(xmlpullparser.getName())) goto _L5; else goto _L4
_L4:
        int j = xmlpullparser.next();
_L9:
        if(j != 2 || xmlpullparser.getDepth() != 2 || !"service".equals(xmlpullparser.getName())) goto _L7; else goto _L6
_L6:
        Object obj = mSerializerAndParser.createFromXml(xmlpullparser);
        if(obj != null) goto _L8; else goto _L5
_L5:
        if(fileinputstream != null)
            try {
                fileinputstream.close();
            }
            catch(IOException ioexception2) { }
        continue; /* Loop/switch isn't completed */
_L8:
        int l = Integer.parseInt(xmlpullparser.getAttributeValue(null, "uid"));
        mPersistentServices.put(obj, Integer.valueOf(l));
_L7:
        int k = xmlpullparser.next();
        j = k;
        if(j != 1) goto _L9; else goto _L5
        Exception exception1;
        exception1;
        Log.w("PackageManager", "Error reading persistent services, starting from scratch", exception1);
        if(fileinputstream != null)
            try {
                fileinputstream.close();
            }
            catch(IOException ioexception1) { }
        if(true) goto _L1; else goto _L10
_L10:
        Exception exception;
        exception;
        if(fileinputstream != null)
            try {
                fileinputstream.close();
            }
            catch(IOException ioexception) { }
        throw exception;
    }

    private void writePersistentServicesLocked() {
        if(mSerializerAndParser != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        java.io.FileOutputStream fileoutputstream = null;
        IOException ioexception;
        FastXmlSerializer fastxmlserializer;
        fileoutputstream = mPersistentServicesFile.startWrite();
        fastxmlserializer = new FastXmlSerializer();
        fastxmlserializer.setOutput(fileoutputstream, "utf-8");
        fastxmlserializer.startDocument(null, Boolean.valueOf(true));
        fastxmlserializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        fastxmlserializer.startTag(null, "services");
        for(Iterator iterator = mPersistentServices.entrySet().iterator(); iterator.hasNext(); fastxmlserializer.endTag(null, "service")) {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            fastxmlserializer.startTag(null, "service");
            fastxmlserializer.attribute(null, "uid", Integer.toString(((Integer)entry.getValue()).intValue()));
            mSerializerAndParser.writeAsXml(entry.getKey(), fastxmlserializer);
        }

        try {
            fastxmlserializer.endTag(null, "services");
            fastxmlserializer.endDocument();
            mPersistentServicesFile.finishWrite(fileoutputstream);
        }
        // Misplaced declaration of an exception variable
        catch(IOException ioexception) {
            Log.w("PackageManager", "Error writing accounts", ioexception);
            if(fileoutputstream != null)
                mPersistentServicesFile.failWrite(fileoutputstream);
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void close() {
        BroadcastReceiver broadcastreceiver = (BroadcastReceiver)mReceiver.getAndSet(null);
        if(broadcastreceiver != null)
            mContext.unregisterReceiver(broadcastreceiver);
    }

    public void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        Map map;
        synchronized(mServicesLock) {
            map = mServices;
        }
        printwriter.println((new StringBuilder()).append("RegisteredServicesCache: ").append(map.size()).append(" services").toString());
        ServiceInfo serviceinfo;
        for(Iterator iterator = map.values().iterator(); iterator.hasNext(); printwriter.println((new StringBuilder()).append("  ").append(serviceinfo).toString()))
            serviceinfo = (ServiceInfo)iterator.next();

        break MISSING_BLOCK_LABEL_126;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void finalize() throws Throwable {
        if(mReceiver.get() != null)
            Log.e("PackageManager", "RegisteredServicesCache finalized without being closed");
        close();
        super.finalize();
    }

    public void generateServicesMap() {
        ArrayList arraylist;
        Iterator iterator;
        PackageManager packagemanager = mContext.getPackageManager();
        arraylist = new ArrayList();
        iterator = packagemanager.queryIntentServices(new Intent(mInterfaceName), 128).iterator();
_L2:
        ResolveInfo resolveinfo;
        if(!iterator.hasNext())
            break; /* Loop/switch isn't completed */
        resolveinfo = (ResolveInfo)iterator.next();
        ServiceInfo serviceinfo1 = parseServiceInfo(resolveinfo);
        XmlPullParserException xmlpullparserexception;
        if(serviceinfo1 == null) {
            Log.w("PackageManager", (new StringBuilder()).append("Unable to load service info ").append(resolveinfo.toString()).toString());
            continue; /* Loop/switch isn't completed */
        }
        try {
            arraylist.add(serviceinfo1);
        }
        // Misplaced declaration of an exception variable
        catch(XmlPullParserException xmlpullparserexception) {
            Log.w("PackageManager", (new StringBuilder()).append("Unable to load service info ").append(resolveinfo.toString()).toString(), xmlpullparserexception);
        }
        catch(IOException ioexception) {
            Log.w("PackageManager", (new StringBuilder()).append("Unable to load service info ").append(resolveinfo.toString()).toString(), ioexception);
        }
        if(true) goto _L2; else goto _L1
_L1:
        Object obj = mServicesLock;
        obj;
        JVM INSTR monitorenter ;
        StringBuilder stringbuilder;
        Iterator iterator1;
        if(mPersistentServices == null)
            readPersistentServicesLocked();
        mServices = Maps.newHashMap();
        stringbuilder = new StringBuilder();
        iterator1 = arraylist.iterator();
_L3:
        ServiceInfo serviceinfo;
        Integer integer;
        do {
            if(!iterator1.hasNext())
                break MISSING_BLOCK_LABEL_583;
            serviceinfo = (ServiceInfo)iterator1.next();
            integer = (Integer)mPersistentServices.get(serviceinfo.type);
            if(integer != null)
                break MISSING_BLOCK_LABEL_362;
            stringbuilder.append("  New service added: ").append(serviceinfo).append("\n");
            mServices.put(serviceinfo.type, serviceinfo);
            mPersistentServices.put(serviceinfo.type, Integer.valueOf(serviceinfo.uid));
            if(!mPersistentServicesFileDidNotExist)
                notifyListener(serviceinfo.type, false);
        } while(true);
        Exception exception;
        exception;
        throw exception;
        if(integer.intValue() == serviceinfo.uid) {
            if(Log.isLoggable("PackageManager", 2))
                stringbuilder.append("  Existing service (nop): ").append(serviceinfo).append("\n");
            mServices.put(serviceinfo.type, serviceinfo);
        } else
        if(inSystemImage(serviceinfo.uid) || !containsTypeAndUid(arraylist, serviceinfo.type, integer.intValue())) {
            if(inSystemImage(serviceinfo.uid))
                stringbuilder.append("  System service replacing existing: ").append(serviceinfo).append("\n");
            else
                stringbuilder.append("  Existing service replacing a removed service: ").append(serviceinfo).append("\n");
            mServices.put(serviceinfo.type, serviceinfo);
            mPersistentServices.put(serviceinfo.type, Integer.valueOf(serviceinfo.uid));
            notifyListener(serviceinfo.type, false);
        } else {
            stringbuilder.append("  Existing service with new uid ignored: ").append(serviceinfo).append("\n");
        }
          goto _L3
        ArrayList arraylist1 = Lists.newArrayList();
        Iterator iterator2 = mPersistentServices.keySet().iterator();
        do {
            if(!iterator2.hasNext())
                break;
            Object obj2 = iterator2.next();
            if(!containsType(arraylist, obj2))
                arraylist1.add(obj2);
        } while(true);
        Object obj1;
        for(Iterator iterator3 = arraylist1.iterator(); iterator3.hasNext(); notifyListener(obj1, true)) {
            obj1 = iterator3.next();
            mPersistentServices.remove(obj1);
            stringbuilder.append("  Service removed: ").append(obj1).append("\n");
        }

        if(stringbuilder.length() > 0) {
            Log.d("PackageManager", (new StringBuilder()).append("generateServicesMap(").append(mInterfaceName).append("): ").append(arraylist.size()).append(" services:\n").append(stringbuilder).toString());
            writePersistentServicesLocked();
        } else {
            Log.d("PackageManager", (new StringBuilder()).append("generateServicesMap(").append(mInterfaceName).append("): ").append(arraylist.size()).append(" services unchanged").toString());
        }
        mPersistentServicesFileDidNotExist = false;
        obj;
        JVM INSTR monitorexit ;
    }

    public Collection getAllServices() {
        Object obj = mServicesLock;
        obj;
        JVM INSTR monitorenter ;
        Collection collection = Collections.unmodifiableCollection(mServices.values());
        return collection;
    }

    public RegisteredServicesCacheListener getListener() {
        this;
        JVM INSTR monitorenter ;
        RegisteredServicesCacheListener registeredservicescachelistener = mListener;
        return registeredservicescachelistener;
    }

    public ServiceInfo getServiceInfo(Object obj) {
        Object obj1 = mServicesLock;
        obj1;
        JVM INSTR monitorenter ;
        ServiceInfo serviceinfo = (ServiceInfo)mServices.get(obj);
        return serviceinfo;
    }

    public abstract Object parseServiceAttributes(Resources resources, String s, AttributeSet attributeset);

    public void setListener(RegisteredServicesCacheListener registeredservicescachelistener, Handler handler) {
        if(handler == null)
            handler = new Handler(mContext.getMainLooper());
        this;
        JVM INSTR monitorenter ;
        mHandler = handler;
        mListener = registeredservicescachelistener;
        return;
    }

    private static final String TAG = "PackageManager";
    private final String mAttributesName;
    public final Context mContext;
    private Handler mHandler;
    private final String mInterfaceName;
    private RegisteredServicesCacheListener mListener;
    private final String mMetaDataName;
    private HashMap mPersistentServices;
    private final AtomicFile mPersistentServicesFile;
    private boolean mPersistentServicesFileDidNotExist;
    private final AtomicReference mReceiver;
    private final XmlSerializerAndParser mSerializerAndParser;
    private Map mServices;
    private final Object mServicesLock = new Object();
}
