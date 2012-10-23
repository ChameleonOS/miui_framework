// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.*;
import android.content.pm.*;
import android.os.*;
import android.util.Printer;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ApplicationErrorReport
    implements Parcelable {
    public static class RunningServiceInfo {

        public void dump(Printer printer, String s) {
            printer.println((new StringBuilder()).append(s).append("durationMillis: ").append(durationMillis).toString());
            printer.println((new StringBuilder()).append(s).append("serviceDetails: ").append(serviceDetails).toString());
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(durationMillis);
            parcel.writeString(serviceDetails);
        }

        public long durationMillis;
        public String serviceDetails;

        public RunningServiceInfo() {
        }

        public RunningServiceInfo(Parcel parcel) {
            durationMillis = parcel.readLong();
            serviceDetails = parcel.readString();
        }
    }

    public static class BatteryInfo {

        public void dump(Printer printer, String s) {
            printer.println((new StringBuilder()).append(s).append("usagePercent: ").append(usagePercent).toString());
            printer.println((new StringBuilder()).append(s).append("durationMicros: ").append(durationMicros).toString());
            printer.println((new StringBuilder()).append(s).append("usageDetails: ").append(usageDetails).toString());
            printer.println((new StringBuilder()).append(s).append("checkinDetails: ").append(checkinDetails).toString());
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(usagePercent);
            parcel.writeLong(durationMicros);
            parcel.writeString(usageDetails);
            parcel.writeString(checkinDetails);
        }

        public String checkinDetails;
        public long durationMicros;
        public String usageDetails;
        public int usagePercent;

        public BatteryInfo() {
        }

        public BatteryInfo(Parcel parcel) {
            usagePercent = parcel.readInt();
            durationMicros = parcel.readLong();
            usageDetails = parcel.readString();
            checkinDetails = parcel.readString();
        }
    }

    public static class AnrInfo {

        public void dump(Printer printer, String s) {
            printer.println((new StringBuilder()).append(s).append("activity: ").append(activity).toString());
            printer.println((new StringBuilder()).append(s).append("cause: ").append(cause).toString());
            printer.println((new StringBuilder()).append(s).append("info: ").append(info).toString());
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(activity);
            parcel.writeString(cause);
            parcel.writeString(info);
        }

        public String activity;
        public String cause;
        public String info;

        public AnrInfo() {
        }

        public AnrInfo(Parcel parcel) {
            activity = parcel.readString();
            cause = parcel.readString();
            info = parcel.readString();
        }
    }

    public static class CrashInfo {

        public void dump(Printer printer, String s) {
            printer.println((new StringBuilder()).append(s).append("exceptionClassName: ").append(exceptionClassName).toString());
            printer.println((new StringBuilder()).append(s).append("exceptionMessage: ").append(exceptionMessage).toString());
            printer.println((new StringBuilder()).append(s).append("throwFileName: ").append(throwFileName).toString());
            printer.println((new StringBuilder()).append(s).append("throwClassName: ").append(throwClassName).toString());
            printer.println((new StringBuilder()).append(s).append("throwMethodName: ").append(throwMethodName).toString());
            printer.println((new StringBuilder()).append(s).append("throwLineNumber: ").append(throwLineNumber).toString());
            printer.println((new StringBuilder()).append(s).append("stackTrace: ").append(stackTrace).toString());
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(exceptionClassName);
            parcel.writeString(exceptionMessage);
            parcel.writeString(throwFileName);
            parcel.writeString(throwClassName);
            parcel.writeString(throwMethodName);
            parcel.writeInt(throwLineNumber);
            parcel.writeString(stackTrace);
        }

        public String exceptionClassName;
        public String exceptionMessage;
        public String stackTrace;
        public String throwClassName;
        public String throwFileName;
        public int throwLineNumber;
        public String throwMethodName;

        public CrashInfo() {
        }

        public CrashInfo(Parcel parcel) {
            exceptionClassName = parcel.readString();
            exceptionMessage = parcel.readString();
            throwFileName = parcel.readString();
            throwClassName = parcel.readString();
            throwMethodName = parcel.readString();
            throwLineNumber = parcel.readInt();
            stackTrace = parcel.readString();
        }

        public CrashInfo(Throwable throwable) {
            StringWriter stringwriter = new StringWriter();
            throwable.printStackTrace(new PrintWriter(stringwriter));
            stackTrace = stringwriter.toString();
            exceptionMessage = throwable.getMessage();
            Throwable throwable1 = throwable;
            do {
                if(throwable.getCause() == null)
                    break;
                throwable = throwable.getCause();
                if(throwable.getStackTrace() != null && throwable.getStackTrace().length > 0)
                    throwable1 = throwable;
                String s = throwable.getMessage();
                if(s != null && s.length() > 0)
                    exceptionMessage = s;
            } while(true);
            exceptionClassName = throwable1.getClass().getName();
            if(throwable1.getStackTrace().length > 0) {
                StackTraceElement stacktraceelement = throwable1.getStackTrace()[0];
                throwFileName = stacktraceelement.getFileName();
                throwClassName = stacktraceelement.getClassName();
                throwMethodName = stacktraceelement.getMethodName();
                throwLineNumber = stacktraceelement.getLineNumber();
            } else {
                throwFileName = "unknown";
                throwClassName = "unknown";
                throwMethodName = "unknown";
                throwLineNumber = 0;
            }
        }
    }


    public ApplicationErrorReport() {
    }

    ApplicationErrorReport(Parcel parcel) {
        readFromParcel(parcel);
    }

    public static ComponentName getErrorReportReceiver(Context context, String s, int i) {
        if(android.provider.Settings.Secure.getInt(context.getContentResolver(), "send_action_app_error", 0) != 0) goto _L2; else goto _L1
_L1:
        ComponentName componentname = null;
_L4:
        return componentname;
_L2:
        PackageManager packagemanager = context.getPackageManager();
        componentname = getErrorReportReceiver(packagemanager, s, packagemanager.getInstallerPackageName(s));
        if(componentname != null)
            continue; /* Loop/switch isn't completed */
        if((i & 1) != 0) {
            componentname = getErrorReportReceiver(packagemanager, s, SystemProperties.get("ro.error.receiver.system.apps"));
            if(componentname != null)
                continue; /* Loop/switch isn't completed */
        }
        componentname = getErrorReportReceiver(packagemanager, s, SystemProperties.get("ro.error.receiver.default"));
        if(true) goto _L4; else goto _L3
_L3:
    }

    static ComponentName getErrorReportReceiver(PackageManager packagemanager, String s, String s1) {
        ComponentName componentname;
        componentname = null;
        break MISSING_BLOCK_LABEL_2;
        while(true)  {
            do
                return componentname;
            while(s1 == null || s1.length() == 0 || s1.equals(s));
            Intent intent = new Intent("android.intent.action.APP_ERROR");
            intent.setPackage(s1);
            ResolveInfo resolveinfo = packagemanager.resolveActivity(intent, 0);
            if(resolveinfo != null && resolveinfo.activityInfo != null)
                componentname = new ComponentName(s1, ((PackageItemInfo) (resolveinfo.activityInfo)).name);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void dump(Printer printer, String s) {
        printer.println((new StringBuilder()).append(s).append("type: ").append(type).toString());
        printer.println((new StringBuilder()).append(s).append("packageName: ").append(packageName).toString());
        printer.println((new StringBuilder()).append(s).append("installerPackageName: ").append(installerPackageName).toString());
        printer.println((new StringBuilder()).append(s).append("processName: ").append(processName).toString());
        printer.println((new StringBuilder()).append(s).append("time: ").append(time).toString());
        printer.println((new StringBuilder()).append(s).append("systemApp: ").append(systemApp).toString());
        type;
        JVM INSTR tableswitch 1 5: default 232
    //                   1 233
    //                   2 245
    //                   3 257
    //                   4 232
    //                   5 269;
           goto _L1 _L2 _L3 _L4 _L1 _L5
_L1:
        return;
_L2:
        crashInfo.dump(printer, s);
        continue; /* Loop/switch isn't completed */
_L3:
        anrInfo.dump(printer, s);
        continue; /* Loop/switch isn't completed */
_L4:
        batteryInfo.dump(printer, s);
        continue; /* Loop/switch isn't completed */
_L5:
        runningServiceInfo.dump(printer, s);
        if(true) goto _L1; else goto _L6
_L6:
    }

    public void readFromParcel(Parcel parcel) {
        boolean flag = true;
        type = parcel.readInt();
        packageName = parcel.readString();
        installerPackageName = parcel.readString();
        processName = parcel.readString();
        time = parcel.readLong();
        if(parcel.readInt() != flag)
            flag = false;
        systemApp = flag;
        type;
        JVM INSTR tableswitch 1 5: default 92
    //                   1 98
    //                   2 128
    //                   3 158
    //                   4 92
    //                   5 188;
           goto _L1 _L2 _L3 _L4 _L1 _L5
_L1:
        return;
_L2:
        crashInfo = new CrashInfo(parcel);
        anrInfo = null;
        batteryInfo = null;
        runningServiceInfo = null;
        continue; /* Loop/switch isn't completed */
_L3:
        anrInfo = new AnrInfo(parcel);
        crashInfo = null;
        batteryInfo = null;
        runningServiceInfo = null;
        continue; /* Loop/switch isn't completed */
_L4:
        batteryInfo = new BatteryInfo(parcel);
        anrInfo = null;
        crashInfo = null;
        runningServiceInfo = null;
        continue; /* Loop/switch isn't completed */
_L5:
        batteryInfo = null;
        anrInfo = null;
        crashInfo = null;
        runningServiceInfo = new RunningServiceInfo(parcel);
        if(true) goto _L1; else goto _L6
_L6:
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(type);
        parcel.writeString(packageName);
        parcel.writeString(installerPackageName);
        parcel.writeString(processName);
        parcel.writeLong(time);
        int j;
        if(systemApp)
            j = 1;
        else
            j = 0;
        parcel.writeInt(j);
        type;
        JVM INSTR tableswitch 1 5: default 92
    //                   1 98
    //                   2 110
    //                   3 122
    //                   4 92
    //                   5 134;
           goto _L1 _L2 _L3 _L4 _L1 _L5
_L1:
        return;
_L2:
        crashInfo.writeToParcel(parcel, i);
        continue; /* Loop/switch isn't completed */
_L3:
        anrInfo.writeToParcel(parcel, i);
        continue; /* Loop/switch isn't completed */
_L4:
        batteryInfo.writeToParcel(parcel, i);
        continue; /* Loop/switch isn't completed */
_L5:
        runningServiceInfo.writeToParcel(parcel, i);
        if(true) goto _L1; else goto _L6
_L6:
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ApplicationErrorReport createFromParcel(Parcel parcel) {
            return new ApplicationErrorReport(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public ApplicationErrorReport[] newArray(int i) {
            return new ApplicationErrorReport[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    static final String DEFAULT_ERROR_RECEIVER_PROPERTY = "ro.error.receiver.default";
    static final String SYSTEM_APPS_ERROR_RECEIVER_PROPERTY = "ro.error.receiver.system.apps";
    public static final int TYPE_ANR = 2;
    public static final int TYPE_BATTERY = 3;
    public static final int TYPE_CRASH = 1;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_RUNNING_SERVICE = 5;
    public AnrInfo anrInfo;
    public BatteryInfo batteryInfo;
    public CrashInfo crashInfo;
    public String installerPackageName;
    public String packageName;
    public String processName;
    public RunningServiceInfo runningServiceInfo;
    public boolean systemApp;
    public long time;
    public int type;

}
