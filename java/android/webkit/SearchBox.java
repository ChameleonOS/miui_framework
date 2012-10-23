// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import java.util.List;

public interface SearchBox {
    public static interface IsSupportedCallback {

        public abstract void searchBoxIsSupported(boolean flag);
    }

    public static abstract class SearchBoxListener {

        public void onCancelComplete(boolean flag) {
        }

        public void onChangeComplete(boolean flag) {
        }

        public void onResizeComplete(boolean flag) {
        }

        public void onSubmitComplete(boolean flag) {
        }

        public void onSuggestionsReceived(String s, List list) {
        }

        public SearchBoxListener() {
        }
    }


    public abstract void addSearchBoxListener(SearchBoxListener searchboxlistener);

    public abstract void isSupported(IsSupportedCallback issupportedcallback);

    public abstract void oncancel(SearchBoxListener searchboxlistener);

    public abstract void onchange(SearchBoxListener searchboxlistener);

    public abstract void onresize(SearchBoxListener searchboxlistener);

    public abstract void onsubmit(SearchBoxListener searchboxlistener);

    public abstract void removeSearchBoxListener(SearchBoxListener searchboxlistener);

    public abstract void setDimensions(int i, int j, int k, int l);

    public abstract void setQuery(String s);

    public abstract void setSelection(int i, int j);

    public abstract void setVerbatim(boolean flag);
}
