// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.util;

import android.app.*;
import android.content.Context;
import android.content.Intent;
import android.content.pm.*;
import android.os.*;
import android.util.Log;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AudioOutputHelper {
    private static class DUMP_TAG {

        public static final Pattern ACTIVE_TRACKS_FINDER = Pattern.compile("^Output thread 0x[\\w]+ active tracks");
        public static final int PID_GRP_IDX = 2;
        public static final Pattern SESSIONS_CONTENT_FINDER = Pattern.compile("^\\s+(\\d+)\\s+(\\d+)\\s+\\d+$");
        public static final Pattern SESSIONS_HEAD_FINDER = Pattern.compile("^ session pid (cnt|count)");
        public static final int SESSION_GRP_IDX = 1;
        public static final Pattern STANDBY_FINDER = Pattern.compile("^standby: (\\w+)");
        public static final int STANDBY_GRP_IDX = 1;
        public static final Pattern TRACKS_FINDER = Pattern.compile("^Output thread 0x[\\w]+ tracks");
        public static final Pattern TRACK_CONTENT_FINDER = Pattern.compile("^(\\s|F)+\\d+\\s+\\d+\\s+(\\d+)\\s+\\d+\\s+\\w+\\s+(\\d+)\\s.+");
        public static final int TRACK_SESSION_GRP_IDX = 3;
        public static final int TRACK_STREAM_TYPE_GRP_IDX = 2;


        private DUMP_TAG() {
        }
    }

    public static class AudioOutputClient {

        public boolean mActive;
        public final int mProcessId;
        public final int mSessionId;
        public final int mStreamType;

        public AudioOutputClient(int i, int j, int k) {
            this(i, j, k, false);
        }

        public AudioOutputClient(int i, int j, int k, boolean flag) {
            mSessionId = i;
            mProcessId = j;
            mStreamType = k;
            mActive = flag;
        }
    }


    public AudioOutputHelper() {
    }

    private static String collectSessions(BufferedReader bufferedreader, Map map) throws NumberFormatException, IOException {
        do {
            Matcher matcher;
label0:
            {
                String s = bufferedreader.readLine();
                if(s != null) {
                    matcher = DUMP_TAG.SESSIONS_CONTENT_FINDER.matcher(s);
                    if(matcher.find())
                        break label0;
                }
                return s;
            }
            int i = Integer.valueOf(matcher.group(1)).intValue();
            int j = Integer.valueOf(matcher.group(2)).intValue();
            map.put(Integer.valueOf(i), Integer.valueOf(j));
        } while(true);
    }

    private static String collectTracks(BufferedReader bufferedreader, List list, Map map, boolean flag) throws NumberFormatException, IOException {
        do {
            Matcher matcher;
label0:
            {
                String s = bufferedreader.readLine();
                if(s != null) {
                    matcher = DUMP_TAG.TRACK_CONTENT_FINDER.matcher(s);
                    if(matcher.find())
                        break label0;
                }
                return s;
            }
            int i = Integer.valueOf(matcher.group(3)).intValue();
            Integer integer = (Integer)map.get(Integer.valueOf(i));
            if(integer != null) {
                int j = integer.intValue();
                int k = Integer.valueOf(matcher.group(2)).intValue();
                boolean flag1 = false;
                if(flag) {
                    Iterator iterator = list.iterator();
                    do {
                        if(!iterator.hasNext())
                            break;
                        AudioOutputClient audiooutputclient = (AudioOutputClient)iterator.next();
                        if(audiooutputclient.mSessionId == i) {
                            audiooutputclient.mActive = flag;
                            flag1 = true;
                        }
                    } while(true);
                }
                if(!flag1)
                    list.add(new AudioOutputClient(i, j, k, flag));
            }
        } while(true);
    }

    public static List getActiveClientNameList(List list, Context context, boolean flag) {
        Object obj = null;
        if(list != null) goto _L2; else goto _L1
_L1:
        return ((List) (obj));
_L2:
        List list1 = parseAudioFlingerDump(context);
        if(list1 == null)
            continue; /* Loop/switch isn't completed */
        obj = new ArrayList();
        for(Iterator iterator = list1.iterator(); iterator.hasNext();) {
            AudioOutputClient audiooutputclient = (AudioOutputClient)iterator.next();
            if(audiooutputclient.mActive) {
                int i = audiooutputclient.mProcessId;
                Iterator iterator1 = list.iterator();
                while(iterator1.hasNext())  {
                    android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)iterator1.next();
                    if(runningappprocessinfo.pid == i)
                        ((ArrayList) (obj)).add(runningappprocessinfo.processName);
                }
            }
        }

        if(flag)
            ((ArrayList) (obj)).addAll(getMainProcessNames(((List) (obj))));
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static List getActiveReceiverNameList(Context context) {
        List list;
        List list1;
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        list = AppGlobals.getPackageManager().queryIntentReceivers(intent, null, 0, 0);
        if(list == null || list.isEmpty())
            break MISSING_BLOCK_LABEL_187;
        list1 = getActiveClientNameList(ActivityManagerNative.getDefault().getRunningAppProcesses(), context, true);
        RemoteException remoteexception;
        ArrayList arraylist;
        if(list1 != null && !list1.isEmpty()) {
            arraylist = new ArrayList();
            Iterator iterator = list1.iterator();
label0:
            do {
                if(!iterator.hasNext())
                    break;
                String s = (String)iterator.next();
                Iterator iterator1 = list.iterator();
                ResolveInfo resolveinfo;
                do {
                    if(!iterator1.hasNext())
                        continue label0;
                    resolveinfo = (ResolveInfo)iterator1.next();
                } while(resolveinfo.activityInfo == null || !s.equals(((ComponentInfo) (resolveinfo.activityInfo)).processName));
                arraylist.add(s);
            } while(true);
        } else {
            arraylist = null;
        }
        break MISSING_BLOCK_LABEL_189;
        remoteexception;
        arraylist = null;
        break MISSING_BLOCK_LABEL_189;
        arraylist = null;
        return arraylist;
    }

    private static List getMainProcessNames(List list) {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = list.iterator();
        do {
            if(!iterator.hasNext())
                break;
            String s = (String)iterator.next();
            int i = s.indexOf(":");
            if(i > 0)
                arraylist.add(s.substring(0, i));
        } while(true);
        return arraylist;
    }

    public static boolean hasActiveReceivers(Context context) {
        List list = getActiveReceiverNameList(context);
        boolean flag;
        if(list != null && !list.isEmpty())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static List parseAudioFlingerDump(Context context) {
        File file = null;
        File file2 = context.getFilesDir();
        file = file2;
_L2:
        if(file == null)
            file = new File("/cache");
        int i = Process.myPid();
        long l = Thread.currentThread().getId();
        Object aobj[] = new Object[3];
        aobj[0] = Integer.valueOf(i);
        aobj[1] = Long.valueOf(l);
        int j = 0 + 1;
        aobj[2] = Integer.valueOf(0);
        File file1 = new File(file, String.format("audio_flinger_%d_%d_%d.dump", aobj));
        int i1;
        for(int k = j; file1.exists(); k = i1) {
            Object aobj1[] = new Object[3];
            aobj1[0] = Integer.valueOf(i);
            aobj1[1] = Long.valueOf(l);
            i1 = k + 1;
            aobj1[2] = Integer.valueOf(k);
            file1 = new File(file, String.format("audio_flinger_%d_%d_%d.dump", aobj1));
        }

        List list = parseAudioFlingerDumpInternal(file1);
        file1.delete();
        return list;
        Exception exception;
        exception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private static List parseAudioFlingerDumpInternal(File file) {
        FileOutputStream fileoutputstream = null;
        FileOutputStream fileoutputstream1 = new FileOutputStream(file);
        ServiceManager.getService("media.audio_flinger").dump(fileoutputstream1.getFD(), null);
        FileNotFoundException filenotfoundexception;
        Exception exception;
        FileInputStream fileinputstream;
        FileInputStream fileinputstream1;
        Object obj;
        String s;
        Object obj1;
        RemoteException remoteexception;
        IOException ioexception5;
        if(fileoutputstream1 != null)
            try {
                fileoutputstream1.close();
            }
            catch(IOException ioexception6) { }
        fileinputstream = null;
        fileinputstream1 = new FileInputStream(file);
        fileinputstream = fileinputstream1;
_L9:
        if(fileinputstream != null) goto _L2; else goto _L1
_L1:
        obj = null;
_L8:
        return ((List) (obj));
        filenotfoundexception;
_L13:
        Log.e(TAG, filenotfoundexception.toString());
        if(fileoutputstream != null)
            try {
                fileoutputstream.close();
            }
            catch(IOException ioexception1) { }
        break MISSING_BLOCK_LABEL_35;
        remoteexception;
_L12:
        Log.e(TAG, remoteexception.toString());
        if(fileoutputstream == null)
            break MISSING_BLOCK_LABEL_35;
        fileoutputstream.close();
        break MISSING_BLOCK_LABEL_35;
        ioexception5;
_L11:
        Log.e(TAG, ioexception5.toString());
        if(fileoutputstream == null)
            break MISSING_BLOCK_LABEL_35;
        fileoutputstream.close();
        break MISSING_BLOCK_LABEL_35;
        exception;
_L10:
        BufferedReader bufferedreader;
        HashMap hashmap;
        boolean flag;
        Exception exception1;
        Exception exception2;
        String s1;
        IOException ioexception4;
        Matcher matcher;
        String s2;
        if(fileoutputstream != null)
            try {
                fileoutputstream.close();
            }
            catch(IOException ioexception) { }
        throw exception;
_L2:
        bufferedreader = new BufferedReader(new InputStreamReader(fileinputstream));
        obj = new ArrayList();
        hashmap = null;
        flag = false;
        s = null;
          goto _L3
_L7:
        if(!DUMP_TAG.SESSIONS_HEAD_FINDER.matcher(((CharSequence) (obj1))).matches()) goto _L5; else goto _L4
_L4:
        if(hashmap == null)
            hashmap = new HashMap();
        s = collectSessions(bufferedreader, hashmap);
          goto _L3
_L15:
        s1 = bufferedreader.readLine();
        obj1 = s1;
        if(obj1 != null) goto _L7; else goto _L6
_L6:
        try {
            fileinputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch(IOException ioexception4) { }
          goto _L8
_L5:
        matcher = DUMP_TAG.STANDBY_FINDER.matcher(((CharSequence) (obj1)));
        if(matcher.find()) {
            flag = Boolean.valueOf(matcher.group(1)).booleanValue();
            continue; /* Loop/switch isn't completed */
        }
        if(flag)
            continue; /* Loop/switch isn't completed */
        if(DUMP_TAG.TRACKS_FINDER.matcher(((CharSequence) (obj1))).find()) {
            bufferedreader.readLine();
            s = collectTracks(bufferedreader, ((List) (obj)), hashmap, false);
            continue; /* Loop/switch isn't completed */
        }
        if(!DUMP_TAG.ACTIVE_TRACKS_FINDER.matcher(((CharSequence) (obj1))).find())
            continue; /* Loop/switch isn't completed */
        bufferedreader.readLine();
        s2 = collectTracks(bufferedreader, ((List) (obj)), hashmap, true);
        s = s2;
        continue; /* Loop/switch isn't completed */
        exception2;
        Log.e(TAG, exception2.toString());
        IOException ioexception2;
        try {
            fileinputstream.close();
        }
        catch(IOException ioexception3) { }
        obj = null;
          goto _L8
        exception1;
        try {
            fileinputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch(IOException ioexception2) { }
        throw exception1;
        FileNotFoundException filenotfoundexception1;
        filenotfoundexception1;
          goto _L9
        exception;
        fileoutputstream = fileoutputstream1;
          goto _L10
        ioexception5;
        fileoutputstream = fileoutputstream1;
          goto _L11
        remoteexception;
        fileoutputstream = fileoutputstream1;
          goto _L12
        filenotfoundexception;
        fileoutputstream = fileoutputstream1;
          goto _L13
_L3:
        if(s == null) goto _L15; else goto _L14
_L14:
        obj1 = s;
        s = null;
          goto _L7
    }

    private static final String DEFAULT_TEMP_FILE = "audio_flinger_%d_%d_%d.dump";
    private static final String TAG = miui/util/AudioOutputHelper.getName();

}
