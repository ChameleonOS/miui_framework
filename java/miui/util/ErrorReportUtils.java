// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import miui.os.Build;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONObject;

public class ErrorReportUtils {
    private static class Base64Coder {

        public static char[] encode(byte abyte0[]) {
            return encode(abyte0, 0, abyte0.length);
        }

        public static char[] encode(byte abyte0[], int i, int j) {
            int k = (2 + j * 4) / 3;
            char ac[] = new char[4 * ((j + 2) / 3)];
            int l = i + j;
            int i1 = 0;
            int j1 = i;
            while(j1 < l)  {
                int k1 = j1 + 1;
                int l1 = 0xff & abyte0[j1];
                int i2;
                int j2;
                int k2;
                int l2;
                int i3;
                int j3;
                int k3;
                int l3;
                int i4;
                int j4;
                char c;
                int k4;
                char c1;
                if(k1 < l) {
                    j2 = k1 + 1;
                    i2 = 0xff & abyte0[k1];
                } else {
                    i2 = 0;
                    j2 = k1;
                }
                if(j2 < l) {
                    l2 = j2 + 1;
                    k2 = 0xff & abyte0[j2];
                } else {
                    k2 = 0;
                    l2 = j2;
                }
                i3 = l1 >>> 2;
                j3 = (l1 & 3) << 4 | i2 >>> 4;
                k3 = (i2 & 0xf) << 2 | k2 >>> 6;
                l3 = k2 & 0x3f;
                i4 = i1 + 1;
                ac[i1] = map1[i3];
                j4 = i4 + 1;
                ac[i4] = map1[j3];
                if(j4 < k)
                    c = map1[k3];
                else
                    c = '=';
                ac[j4] = c;
                k4 = j4 + 1;
                if(k4 < k)
                    c1 = map1[l3];
                else
                    c1 = '=';
                ac[k4] = c1;
                i1 = k4 + 1;
                j1 = l2;
            }
            return ac;
        }

        private static char map1[];
        private static byte map2[];

        static  {
            map1 = new char[64];
            char c = 'A';
            int i;
            int k1;
            for(i = 0; c <= 'Z'; i = k1) {
                char ac4[] = map1;
                k1 = i + 1;
                ac4[i] = c;
                c++;
            }

            for(char c1 = 'a'; c1 <= 'z';) {
                char ac3[] = map1;
                int j1 = i + 1;
                ac3[i] = c1;
                c1++;
                i = j1;
            }

            for(char c2 = '0'; c2 <= '9';) {
                char ac2[] = map1;
                int i1 = i + 1;
                ac2[i] = c2;
                c2++;
                i = i1;
            }

            char ac[] = map1;
            int j = i + 1;
            ac[i] = '+';
            char ac1[] = map1;
            int _tmp = j + 1;
            ac1[j] = '/';
            map2 = new byte[128];
            for(int k = 0; k < map2.length; k++)
                map2[k] = -1;

            for(int l = 0; l < 64; l++)
                map2[map1[l]] = (byte)l;

        }

        private Base64Coder() {
        }
    }

    private static class CommonUtils {

        public static byte[] getBytes(String s) {
            byte abyte1[] = s.getBytes("UTF-8");
            byte abyte0[] = abyte1;
_L2:
            return abyte0;
            UnsupportedEncodingException unsupportedencodingexception;
            unsupportedencodingexception;
            abyte0 = s.getBytes();
            if(true) goto _L2; else goto _L1
_L1:
        }

        public static String getMd5Digest(String s) {
            String s1;
            try {
                MessageDigest messagedigest = MessageDigest.getInstance("MD5");
                messagedigest.update(getBytes(s));
                BigInteger biginteger = new BigInteger(1, messagedigest.digest());
                Object aobj[] = new Object[1];
                aobj[0] = biginteger;
                s1 = String.format("%1$032X", aobj);
            }
            catch(NoSuchAlgorithmException nosuchalgorithmexception) {
                throw new RuntimeException(nosuchalgorithmexception);
            }
            return s1;
        }

        private CommonUtils() {
        }
    }

    public static class ReportErrorTask extends AsyncTask {

        protected volatile Object doInBackground(Object aobj[]) {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[]) {
            try {
                HttpPost httppost = new HttpPost("http://api.chat.xiaomi.net/v2/miui/feedback");
                httppost.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
                LinkedList linkedlist = new LinkedList();
                linkedlist.add(new BasicNameValuePair("error", mJsPost.toString()));
                linkedlist.add(new BasicNameValuePair("s", ErrorReportUtils.getKeyFromParams(linkedlist)));
                httppost.setEntity(new UrlEncodedFormEntity(linkedlist, "UTF-8"));
                BasicHttpParams basichttpparams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(basichttpparams, 3000);
                HttpConnectionParams.setSoTimeout(basichttpparams, 5000);
                int i = (new DefaultHttpClient(basichttpparams)).execute(httppost).getStatusLine().getStatusCode();
                if(i != 200)
                    Log.w(miui/util/ErrorReportUtils$ReportErrorTask.getSimpleName(), (new StringBuilder()).append("failed to report errors to miui. status code:").append(i).toString());
            }
            catch(UnsupportedEncodingException unsupportedencodingexception) {
                unsupportedencodingexception.printStackTrace();
            }
            catch(ClientProtocolException clientprotocolexception) {
                clientprotocolexception.printStackTrace();
            }
            catch(IOException ioexception) {
                ioexception.printStackTrace();
            }
            return null;
        }

        private JSONObject mJsPost;

        public ReportErrorTask(JSONObject jsonobject) {
            mJsPost = jsonobject;
        }
    }


    public ErrorReportUtils() {
    }

    private static String getKeyFromParams(List list) {
        Collections.sort(list, new Comparator() {

            public volatile int compare(Object obj, Object obj1) {
                return compare((NameValuePair)obj, (NameValuePair)obj1);
            }

            public int compare(NameValuePair namevaluepair1, NameValuePair namevaluepair2) {
                return namevaluepair1.getName().compareTo(namevaluepair2.getName());
            }

        });
        StringBuilder stringbuilder = new StringBuilder();
        boolean flag = true;
        for(Iterator iterator = list.iterator(); iterator.hasNext();) {
            NameValuePair namevaluepair = (NameValuePair)iterator.next();
            if(!flag)
                stringbuilder.append("&");
            stringbuilder.append(namevaluepair.getName()).append("=").append(namevaluepair.getValue());
            flag = false;
        }

        stringbuilder.append("&").append("8007236f-");
        stringbuilder.append("a2d6-4847-ac83-");
        stringbuilder.append("c49395ad6d65");
        return CommonUtils.getMd5Digest(new String(Base64Coder.encode(CommonUtils.getBytes(stringbuilder.toString()))));
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo networkinfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        boolean flag;
        if(networkinfo != null && networkinfo.isAvailable())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isUserAllowed(Context context) {
        boolean flag = true;
        int i;
        if(Build.isDevelopmentVersion())
            i = ((flag) ? 1 : 0);
        else
            i = 0;
        if(android.provider.Settings.Secure.getInt(context.getContentResolver(), "upload_log_pref", i) == 0)
            flag = false;
        return flag;
    }

    public static boolean isWifiConnected(Context context) {
        boolean flag = true;
        NetworkInfo networkinfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if(networkinfo == null || networkinfo.getType() != flag)
            flag = false;
        return flag;
    }

    public static boolean postErrorReport(Context context, JSONObject jsonobject) {
        boolean flag;
        if(isNetworkAvailable(context)) {
            (new ReportErrorTask(jsonobject)).execute((Void[])null);
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public static final int ANR_MAX_LINE_NUMBER = 300;
    public static final String ERROR_TYPE_ANR = "anr";
    public static final String ERROR_TYPE_FC = "fc";
    public static final String JSON_ANR_ACTIVITY = "anr_activity";
    public static final String JSON_ANR_CAUSE = "anr_cause";
    public static final String JSON_APP_VESION = "app_version";
    public static final String JSON_BUILD_VERSION = "build_version";
    public static final String JSON_DEVICE = "device";
    public static final String JSON_ERROR_TYPE = "error_type";
    public static final String JSON_EXCEPTION_CLASS = "exception_class";
    public static final String JSON_EXCEPTION_SOURCE_METHOD = "exception_source_method";
    public static final String JSON_IMEI = "imei";
    public static final String JSON_NETWORK = "network";
    public static final String JSON_PACKAGE_NAME = "package_name";
    public static final String JSON_PLATFORM = "platform";
    public static final String JSON_STACK_TRACK = "stack_track";
    private static final String SALT_P1 = "8007236f-";
    private static final String SALT_P2 = "a2d6-4847-ac83-";
    private static final String SALT_P3 = "c49395ad6d65";

}
