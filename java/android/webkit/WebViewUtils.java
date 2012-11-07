// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.net.Uri;
import java.util.HashMap;

public class WebViewUtils {

    public WebViewUtils() {
    }

    public static String processUrl(String s) {
        if(s != null) goto _L2; else goto _L1
_L1:
        s = null;
_L5:
        return s;
_L2:
        String s1;
        int i;
        byte byte0;
        Uri uri = Uri.parse(s);
        if(uri == null || uri.getPath() != null && !uri.getPath().equals("/") || uri.getQuery() != null)
            continue; /* Loop/switch isn't completed */
        s1 = uri.getHost();
        if(s1 == null)
            continue; /* Loop/switch isn't completed */
        i = s1.lastIndexOf('.');
        if(i == -1)
            continue; /* Loop/switch isn't completed */
        if(!s1.startsWith("www."))
            break MISSING_BLOCK_LABEL_119;
        byte0 = 4;
_L3:
        String s3;
        String s2 = s1.substring(byte0, i);
        if(!UNION_SITES_MAP.containsKey(s2))
            continue; /* Loop/switch isn't completed */
        s3 = (String)UNION_SITES_MAP.get(s2);
        s = s3;
        continue; /* Loop/switch isn't completed */
        byte0 = 0;
          goto _L3
        Exception exception;
        exception;
        if(true) goto _L5; else goto _L4
_L4:
    }

    static final String AMAZON = "http://www.amazon.cn/gp/aw/?tag=xm05-23";
    static final String BAIDU = "http://m.baidu.com/?from=1269a";
    static final String BUY360 = "http://union.m.360buy.com/click/go.action?to=http://m.360buy.com&type=1&keyword=&unionId=35295&subunionId=0";
    static final String CTRIP = "http://me.ctrip.com/hotel/default.html?sid=44237";
    static final String DANGDANG = "http://m.dangdang.com/?unionid=p-307566m";
    static final String DDMAP = "http://wap.ddmap.com/forword_city_configdata.jsp?from=xm";
    static final String DIYICAI = "http://m.diyicai.com/wap/csj/index.jsp?sid=31017545293";
    static final String ELONG = "http://m.elong.com/?ref=xiaomi";
    static final String GANJI = "http://3g.ganji.cn/?from=xiaomi_shouye";
    static final String IFENG = "http://i.ifeng.com/?ch=rj_mr_dh";
    static final String LEXUN = "http://adv.lexun.com/go.aspx?cd=131";
    static final String SHUPENG = "xiaomi.shupeng.com";
    static final String SOHU_TV = "http://m.tv.sohu.com/?pvid=4b7ac3c25600002a";
    static final String TAOBAO = "http://r.m.taobao.com/m2?e=%2BH8j1GjPyOOPa7lSh9yl0ZKuVhyUwLhPGSY0flyd5vURHvdLKD84V5WIA0jtv%2B%2FYKh8niYXjxykNEw6fEG%2FZKZVD2YEvHQ%3D%3D";
    static final String TMALL = "http://r.m.taobao.com/m2?e=%2BH8j1GjPyOOPa7lSh9yl0ZKuVhyW4Ue7bosm0iveBlJ9WF9tt4O%2Fk%2FfyX%2B1sS7hnUmD%2BV%2Be3DOq8";
    static final HashMap UNION_SITES_MAP;
    static final String WAN500 = "http://3g.500wan.com/index?coopid=2328";
    static final String YOUYUAN = "http://youyuan.com/?from=3114";

    static  {
        UNION_SITES_MAP = new HashMap();
        UNION_SITES_MAP.put("baidu", "http://m.baidu.com/?from=1269a");
        UNION_SITES_MAP.put("m.baidu", "http://m.baidu.com/?from=1269a");
        UNION_SITES_MAP.put("taobao", "http://r.m.taobao.com/m2?e=%2BH8j1GjPyOOPa7lSh9yl0ZKuVhyUwLhPGSY0flyd5vURHvdLKD84V5WIA0jtv%2B%2FYKh8niYXjxykNEw6fEG%2FZKZVD2YEvHQ%3D%3D");
        UNION_SITES_MAP.put("m.taobao", "http://r.m.taobao.com/m2?e=%2BH8j1GjPyOOPa7lSh9yl0ZKuVhyUwLhPGSY0flyd5vURHvdLKD84V5WIA0jtv%2B%2FYKh8niYXjxykNEw6fEG%2FZKZVD2YEvHQ%3D%3D");
        UNION_SITES_MAP.put("tmall", "http://r.m.taobao.com/m2?e=%2BH8j1GjPyOOPa7lSh9yl0ZKuVhyW4Ue7bosm0iveBlJ9WF9tt4O%2Fk%2FfyX%2B1sS7hnUmD%2BV%2Be3DOq8");
        UNION_SITES_MAP.put("m.tmall", "http://r.m.taobao.com/m2?e=%2BH8j1GjPyOOPa7lSh9yl0ZKuVhyW4Ue7bosm0iveBlJ9WF9tt4O%2Fk%2FfyX%2B1sS7hnUmD%2BV%2Be3DOq8");
        UNION_SITES_MAP.put("360buy", "http://union.m.360buy.com/click/go.action?to=http://m.360buy.com&type=1&keyword=&unionId=35295&subunionId=0");
        UNION_SITES_MAP.put("m.360buy", "http://union.m.360buy.com/click/go.action?to=http://m.360buy.com&type=1&keyword=&unionId=35295&subunionId=0");
        UNION_SITES_MAP.put("amazon", "http://www.amazon.cn/gp/aw/?tag=xm05-23");
        UNION_SITES_MAP.put("dangdang", "http://m.dangdang.com/?unionid=p-307566m");
        UNION_SITES_MAP.put("m.dangdang", "http://m.dangdang.com/?unionid=p-307566m");
        UNION_SITES_MAP.put("youyuan", "http://youyuan.com/?from=3114");
        UNION_SITES_MAP.put("ctrip", "http://me.ctrip.com/hotel/default.html?sid=44237");
        UNION_SITES_MAP.put("me.ctrip", "http://me.ctrip.com/hotel/default.html?sid=44237");
        UNION_SITES_MAP.put("elong", "http://m.elong.com/?ref=xiaomi");
        UNION_SITES_MAP.put("m.elong", "http://m.elong.com/?ref=xiaomi");
        UNION_SITES_MAP.put("ifeng", "http://i.ifeng.com/?ch=rj_mr_dh");
        UNION_SITES_MAP.put("i.ifeng", "http://i.ifeng.com/?ch=rj_mr_dh");
        UNION_SITES_MAP.put("ganji", "http://3g.ganji.cn/?from=xiaomi_shouye");
        UNION_SITES_MAP.put("3g.ganji", "http://3g.ganji.cn/?from=xiaomi_shouye");
        UNION_SITES_MAP.put("lexun", "http://adv.lexun.com/go.aspx?cd=131");
        UNION_SITES_MAP.put("ddmap", "http://wap.ddmap.com/forword_city_configdata.jsp?from=xm");
        UNION_SITES_MAP.put("wap.ddmap", "http://wap.ddmap.com/forword_city_configdata.jsp?from=xm");
        UNION_SITES_MAP.put("shupeng", "xiaomi.shupeng.com");
        UNION_SITES_MAP.put("m.shupeng", "xiaomi.shupeng.com");
        UNION_SITES_MAP.put("tv.sohu", "http://m.tv.sohu.com/?pvid=4b7ac3c25600002a");
        UNION_SITES_MAP.put("m.tv.sohu", "http://m.tv.sohu.com/?pvid=4b7ac3c25600002a");
        UNION_SITES_MAP.put("500wan", "http://3g.500wan.com/index?coopid=2328");
        UNION_SITES_MAP.put("3g.500wan", "http://3g.500wan.com/index?coopid=2328");
        UNION_SITES_MAP.put("diyicai", "http://m.diyicai.com/wap/csj/index.jsp?sid=31017545293");
        UNION_SITES_MAP.put("m.diyicai", "http://m.diyicai.com/wap/csj/index.jsp?sid=31017545293");
    }
}
