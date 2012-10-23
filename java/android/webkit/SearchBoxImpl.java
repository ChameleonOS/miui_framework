// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.text.TextUtils;
import android.util.Log;
import java.util.*;
import org.json.*;

// Referenced classes of package android.webkit:
//            SearchBox, WebViewCore, CallbackProxy

final class SearchBoxImpl
    implements SearchBox {

    SearchBoxImpl(WebViewCore webviewcore, CallbackProxy callbackproxy) {
        mNextEventId = 1;
        mWebViewCore = webviewcore;
        mCallbackProxy = callbackproxy;
    }

    private void dispatchEvent(String s, SearchBox.SearchBoxListener searchboxlistener) {
        if(searchboxlistener == null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        int i;
        i = mNextEventId;
        mNextEventId = i + 1;
        mEventCallbacks.put(Integer.valueOf(i), searchboxlistener);
        this;
        JVM INSTR monitorexit ;
_L4:
        Object aobj[] = new Object[2];
        aobj[0] = s;
        aobj[1] = Integer.valueOf(i);
        dispatchJs(String.format("if (window.chrome && window.chrome.searchBox && window.chrome.searchBox.on%1$s) {  window.chrome.searchBox.on%1$s();  window.searchBoxJavaBridge_.dispatchCompleteCallback('%1$s', %2$d, true);} else {  window.searchBoxJavaBridge_.dispatchCompleteCallback('%1$s', %2$d, false);}", aobj));
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        i = 0;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void dispatchJs(String s) {
        mWebViewCore.sendMessage(194, s);
    }

    private static String jsonSerialize(String s) {
        JSONStringer jsonstringer = new JSONStringer();
        jsonstringer.array().value(s).endArray();
        String s1 = jsonstringer.toString();
_L2:
        return s1;
        JSONException jsonexception;
        jsonexception;
        Log.w("WebKit.SearchBoxImpl", (new StringBuilder()).append("Error serializing query : ").append(s).toString());
        s1 = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void addSearchBoxListener(SearchBox.SearchBoxListener searchboxlistener) {
        List list = mListeners;
        list;
        JVM INSTR monitorenter ;
        mListeners.add(searchboxlistener);
        return;
    }

    public void dispatchCompleteCallback(String s, int i, boolean flag) {
        mCallbackProxy.onSearchboxDispatchCompleteCallback(s, i, flag);
    }

    public void handleDispatchCompleteCallback(String s, int i, boolean flag) {
        if(i == 0) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        SearchBox.SearchBoxListener searchboxlistener;
        searchboxlistener = (SearchBox.SearchBoxListener)mEventCallbacks.get(Integer.valueOf(i));
        mEventCallbacks.remove(Integer.valueOf(i));
        this;
        JVM INSTR monitorexit ;
        if(searchboxlistener == null) goto _L2; else goto _L3
_L3:
        if(!TextUtils.equals("change", s)) goto _L5; else goto _L4
_L4:
        searchboxlistener.onChangeComplete(flag);
_L2:
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L5:
        if(TextUtils.equals("submit", s))
            searchboxlistener.onSubmitComplete(flag);
        else
        if(TextUtils.equals("resize", s))
            searchboxlistener.onResizeComplete(flag);
        else
        if(TextUtils.equals("cancel", s))
            searchboxlistener.onCancelComplete(flag);
        if(true) goto _L2; else goto _L6
_L6:
    }

    public void handleIsSupportedCallback(boolean flag) {
        SearchBox.IsSupportedCallback issupportedcallback = mSupportedCallback;
        mSupportedCallback = null;
        if(issupportedcallback != null)
            issupportedcallback.searchBoxIsSupported(flag);
    }

    void handleSuggestions(String s, List list) {
        List list1 = mListeners;
        list1;
        JVM INSTR monitorenter ;
        for(int i = -1 + mListeners.size(); i >= 0; i--)
            ((SearchBox.SearchBoxListener)mListeners.get(i)).onSuggestionsReceived(s, list);

        return;
    }

    public void isSupported(SearchBox.IsSupportedCallback issupportedcallback) {
        mSupportedCallback = issupportedcallback;
        dispatchJs("if (window.searchBoxJavaBridge_) {  if (window.chrome && window.chrome.sv) {    window.searchBoxJavaBridge_.isSupportedCallback(true);  } else {    window.searchBoxJavaBridge_.isSupportedCallback(false);  }}");
    }

    public void isSupportedCallback(boolean flag) {
        mCallbackProxy.onIsSupportedCallback(flag);
    }

    public void oncancel(SearchBox.SearchBoxListener searchboxlistener) {
        dispatchEvent("cancel", searchboxlistener);
    }

    public void onchange(SearchBox.SearchBoxListener searchboxlistener) {
        dispatchEvent("change", searchboxlistener);
    }

    public void onresize(SearchBox.SearchBoxListener searchboxlistener) {
        dispatchEvent("resize", searchboxlistener);
    }

    public void onsubmit(SearchBox.SearchBoxListener searchboxlistener) {
        dispatchEvent("submit", searchboxlistener);
    }

    public void removeSearchBoxListener(SearchBox.SearchBoxListener searchboxlistener) {
        List list = mListeners;
        list;
        JVM INSTR monitorenter ;
        mListeners.remove(searchboxlistener);
        return;
    }

    public void setDimensions(int i, int j, int k, int l) {
        Object aobj[] = new Object[4];
        aobj[0] = Integer.valueOf(i);
        aobj[1] = Integer.valueOf(j);
        aobj[2] = Integer.valueOf(k);
        aobj[3] = Integer.valueOf(l);
        dispatchJs(String.format("if (window.chrome && window.chrome.searchBox) {   var f = window.chrome.searchBox;  f.x = %d;  f.y = %d;  f.width = %d;  f.height = %d;}", aobj));
    }

    public void setQuery(String s) {
        String s1 = jsonSerialize(s);
        if(s1 != null) {
            Object aobj[] = new Object[1];
            aobj[0] = s1;
            dispatchJs(String.format("if (window.chrome && window.chrome.searchBox) {  window.chrome.searchBox.setValue(%s);}", aobj));
        }
    }

    public void setSelection(int i, int j) {
        Object aobj[] = new Object[2];
        aobj[0] = Integer.valueOf(i);
        aobj[1] = Integer.valueOf(j);
        dispatchJs(String.format("if (window.chrome && window.chrome.searchBox) {  var f = window.chrome.searchBox;  f.selectionStart = %d  f.selectionEnd = %d}", aobj));
    }

    public void setSuggestions(String s) {
        if(s != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ArrayList arraylist = new ArrayList();
        String s1;
        JSONArray jsonarray;
        int i;
        JSONObject jsonobject = new JSONObject(s);
        s1 = jsonobject.getString("query");
        jsonarray = jsonobject.getJSONArray("suggestions");
        i = 0;
_L3:
        if(i >= jsonarray.length())
            break MISSING_BLOCK_LABEL_128;
        String s2 = jsonarray.getJSONObject(i).getString("value");
        if(s2 != null)
            arraylist.add(s2);
        i++;
          goto _L3
        JSONException jsonexception;
        jsonexception;
        Log.w("WebKit.SearchBoxImpl", (new StringBuilder()).append("Error parsing json [").append(s).append("], exception = ").append(jsonexception).toString());
        continue; /* Loop/switch isn't completed */
        mCallbackProxy.onSearchboxSuggestionsReceived(s1, arraylist);
        if(true) goto _L1; else goto _L4
_L4:
    }

    public void setVerbatim(boolean flag) {
        Object aobj[] = new Object[1];
        aobj[0] = String.valueOf(flag);
        dispatchJs(String.format("if (window.chrome && window.chrome.searchBox) {  window.chrome.searchBox.verbatim = %1$s;}", aobj));
    }

    private static final String DISPATCH_EVENT_SCRIPT = "if (window.chrome && window.chrome.searchBox && window.chrome.searchBox.on%1$s) {  window.chrome.searchBox.on%1$s();  window.searchBoxJavaBridge_.dispatchCompleteCallback('%1$s', %2$d, true);} else {  window.searchBoxJavaBridge_.dispatchCompleteCallback('%1$s', %2$d, false);}";
    private static final String EVENT_CANCEL = "cancel";
    private static final String EVENT_CHANGE = "change";
    private static final String EVENT_RESIZE = "resize";
    private static final String EVENT_SUBMIT = "submit";
    private static final String IS_SUPPORTED_SCRIPT = "if (window.searchBoxJavaBridge_) {  if (window.chrome && window.chrome.sv) {    window.searchBoxJavaBridge_.isSupportedCallback(true);  } else {    window.searchBoxJavaBridge_.isSupportedCallback(false);  }}";
    static final String JS_BRIDGE = "(function(){if (!window.chrome) {  window.chrome = {};}if (!window.chrome.searchBox) {  var sb = window.chrome.searchBox = {};  sb.setSuggestions = function(suggestions) {    if (window.searchBoxJavaBridge_) {      window.searchBoxJavaBridge_.setSuggestions(JSON.stringify(suggestions));    }  };  sb.setValue = function(valueArray) { sb.value = valueArray[0]; };  sb.value = '';  sb.x = 0;  sb.y = 0;  sb.width = 0;  sb.height = 0;  sb.selectionStart = 0;  sb.selectionEnd = 0;  sb.verbatim = false;}})();";
    static final String JS_INTERFACE_NAME = "searchBoxJavaBridge_";
    private static final String SET_DIMENSIONS_SCRIPT = "if (window.chrome && window.chrome.searchBox) {   var f = window.chrome.searchBox;  f.x = %d;  f.y = %d;  f.width = %d;  f.height = %d;}";
    private static final String SET_QUERY_SCRIPT = "if (window.chrome && window.chrome.searchBox) {  window.chrome.searchBox.setValue(%s);}";
    private static final String SET_SELECTION_SCRIPT = "if (window.chrome && window.chrome.searchBox) {  var f = window.chrome.searchBox;  f.selectionStart = %d  f.selectionEnd = %d}";
    private static final String SET_VERBATIM_SCRIPT = "if (window.chrome && window.chrome.searchBox) {  window.chrome.searchBox.verbatim = %1$s;}";
    private static final String TAG = "WebKit.SearchBoxImpl";
    private final CallbackProxy mCallbackProxy;
    private final HashMap mEventCallbacks = new HashMap();
    private final List mListeners = new ArrayList();
    private int mNextEventId;
    private SearchBox.IsSupportedCallback mSupportedCallback;
    private final WebViewCore mWebViewCore;
}
