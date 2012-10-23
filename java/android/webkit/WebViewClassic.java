// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.animation.ObjectAnimator;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.*;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.net.ProxyProperties;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.*;
import android.text.*;
import android.util.*;
import android.view.*;
import android.view.accessibility.*;
import android.view.inputmethod.*;
import android.widget.*;
import java.io.*;
import java.net.URLDecoder;
import java.util.*;
import junit.framework.Assert;

// Referenced classes of package android.webkit:
//            WebViewProvider, QuadF, WebView, WebViewCore, 
//            FindActionModeCallback, ZoomManager, CallbackProxy, JniUtil, 
//            PluginFullScreenHolder, OverScrollGlow, WebSettingsClassic, AccessibilityInjector, 
//            PluginList, SelectionFloatPanel, AutoCompletePopup, WebBackForwardList, 
//            WebHistoryItem, WebViewDatabaseClassic, BrowserFrame, ViewManager, 
//            L10nUtils, HTML5VideoViewProxy, WebCoreThreadWatchdog, WebViewInputDispatcher, 
//            JWebCoreJavaBridge, URLUtil, ValueCallback, SearchBox, 
//            WebSettings, WebBackForwardListClient, WebChromeClient, WebViewClient, 
//            DownloadListener, WebTextView, PluginManager, WebViewFactoryProvider, 
//            CookieManagerClassic, GeolocationPermissionsClassic, WebIconDatabaseClassic, WebStorageClassic, 
//            CookieManager, GeolocationPermissions, WebIconDatabase, WebStorage, 
//            WebViewDatabase, HTML5VideoInline, ViewStateSerializer

public final class WebViewClassic
    implements WebViewProvider, WebViewProvider.ScrollDelegate, WebViewProvider.ViewDelegate {
    private class InvokeListBox
        implements Runnable {
        private class SingleDataSetObserver extends DataSetObserver {

            public void onChanged() {
                long l;
                int i = mListView.getCheckedItemPosition();
                l = mAdapter.getItemId(i);
                if(mCheckedId == l) goto _L2; else goto _L1
_L1:
                int j;
                int k;
                mListView.clearChoices();
                j = mAdapter.getCount();
                k = 0;
_L7:
                if(k >= j) goto _L2; else goto _L3
_L3:
                if(mAdapter.getItemId(k) != mCheckedId) goto _L5; else goto _L4
_L4:
                mListView.setItemChecked(k, true);
_L2:
                return;
_L5:
                k++;
                if(true) goto _L7; else goto _L6
_L6:
            }

            private Adapter mAdapter;
            private long mCheckedId;
            private ListView mListView;
            final InvokeListBox this$1;

            public SingleDataSetObserver(long l, ListView listview, Adapter adapter) {
                this$1 = InvokeListBox.this;
                super();
                mCheckedId = l;
                mListView = listview;
                mAdapter = adapter;
            }
        }

        private class MyArrayListAdapter extends ArrayAdapter {

            private Container item(int i) {
                Container container;
                if(i < 0 || i >= getCount())
                    container = null;
                else
                    container = (Container)getItem(i);
                return container;
            }

            public boolean areAllItemsEnabled() {
                return false;
            }

            public long getItemId(int i) {
                Container container = item(i);
                long l;
                if(container == null)
                    l = -1L;
                else
                    l = container.mId;
                return l;
            }

            public View getView(int i, View view, ViewGroup viewgroup) {
                View view1 = super.getView(i, null, viewgroup);
                Container container = item(i);
                Object obj;
                if(container != null && 1 != container.mEnabled) {
                    obj = new LinearLayout(mContext);
                    ((LinearLayout) (obj)).setOrientation(1);
                    if(i > 0) {
                        View view2 = new View(mContext);
                        view2.setBackgroundResource(0x1080012);
                        ((LinearLayout) (obj)).addView(view2);
                    }
                    if(-1 == container.mEnabled) {
                        if(mMultiple) {
                            Assert.assertTrue(view1 instanceof CheckedTextView);
                            ((CheckedTextView)view1).setCheckMarkDrawable(null);
                        }
                    } else {
                        view1.setEnabled(false);
                    }
                    ((LinearLayout) (obj)).addView(view1);
                    if(i < -1 + getCount()) {
                        View view3 = new View(mContext);
                        view3.setBackgroundResource(0x1080012);
                        ((LinearLayout) (obj)).addView(view3);
                    }
                } else {
                    obj = view1;
                }
                return ((View) (obj));
            }

            public boolean hasStableIds() {
                return false;
            }

            public boolean isEnabled(int i) {
                int j = 1;
                int k = 0;
                Container container = item(i);
                if(container != null) {
                    if(j != container.mEnabled)
                        j = 0;
                    k = j;
                }
                return k;
            }

            final InvokeListBox this$1;

            public MyArrayListAdapter() {
                this$1 = InvokeListBox.this;
                Context context = mContext;
                int i;
                if(mMultiple)
                    i = 0x1090013;
                else
                    i = 0x10900c8;
                super(context, i, mContainers);
            }
        }

        private class Container {

            public String toString() {
                return mString;
            }

            static final int OPTGROUP = -1;
            static final int OPTION_DISABLED = 0;
            static final int OPTION_ENABLED = 1;
            int mEnabled;
            int mId;
            String mString;
            final InvokeListBox this$1;

            private Container() {
                this$1 = InvokeListBox.this;
                super();
            }

        }


        public void run() {
            if(mWebViewCore != null && getWebView().getWindowToken() != null && getWebView().getViewRootImpl() != null) {
                final ListView listView = (ListView)LayoutInflater.from(mContext).inflate(0x10900a4, null);
                final MyArrayListAdapter adapter = new MyArrayListAdapter();
                android.app.AlertDialog.Builder builder = (new android.app.AlertDialog.Builder(mContext)).setView(listView).setCancelable(true).setInverseBackgroundForced(true);
                if(mMultiple) {
                    builder.setPositiveButton(0x104000a, new android.content.DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialoginterface, int k) {
                            mWebViewCore.sendMessage(123, adapter.getCount(), 0, listView.getCheckedItemPositions());
                        }

                        final InvokeListBox this$1;
                        final MyArrayListAdapter val$adapter;
                        final ListView val$listView;

                 {
                    this$1 = InvokeListBox.this;
                    adapter = myarraylistadapter;
                    listView = listview;
                    super();
                }
                    });
                    builder.setNegativeButton(0x1040000, new android.content.DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialoginterface, int k) {
                            mWebViewCore.sendMessage(124, -2, 0);
                        }

                        final InvokeListBox this$1;

                 {
                    this$1 = InvokeListBox.this;
                    super();
                }
                    });
                }
                mListBoxDialog = builder.create();
                listView.setAdapter(adapter);
                listView.setFocusableInTouchMode(true);
                boolean flag;
                if(!mMultiple)
                    flag = true;
                else
                    flag = false;
                listView.setTextFilterEnabled(flag);
                if(mMultiple) {
                    listView.setChoiceMode(2);
                    int i = mSelectedArray.length;
                    for(int j = 0; j < i; j++)
                        listView.setItemChecked(mSelectedArray[j], true);

                } else {
                    listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                        public void onItemClick(AdapterView adapterview, View view, int k, long l) {
                            mListBoxMessage = Message.obtain(null, 124, (int)l, 0);
                            if(mListBoxDialog != null) {
                                mListBoxDialog.dismiss();
                                mListBoxDialog = null;
                            }
                        }

                        final InvokeListBox this$1;

                 {
                    this$1 = InvokeListBox.this;
                    super();
                }
                    });
                    if(mSelection != -1) {
                        listView.setSelection(mSelection);
                        listView.setChoiceMode(1);
                        listView.setItemChecked(mSelection, true);
                        adapter.registerDataSetObserver(new SingleDataSetObserver(adapter.getItemId(mSelection), listView, adapter));
                    }
                }
                mListBoxDialog.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                    public void onCancel(DialogInterface dialoginterface) {
                        mWebViewCore.sendMessage(124, -2, 0);
                        mListBoxDialog = null;
                    }

                    final InvokeListBox this$1;

                 {
                    this$1 = InvokeListBox.this;
                    super();
                }
                });
                mListBoxDialog.show();
            }
        }

        private Container mContainers[];
        private boolean mMultiple;
        private int mSelectedArray[];
        private int mSelection;
        final WebViewClassic this$0;



        private InvokeListBox(String as[], int ai[], int i) {
            this$0 = WebViewClassic.this;
            super();
            mSelection = i;
            mMultiple = false;
            int j = as.length;
            mContainers = new Container[j];
            for(int k = 0; k < j; k++) {
                mContainers[k] = new Container();
                mContainers[k].mString = as[k];
                mContainers[k].mEnabled = ai[k];
                mContainers[k].mId = k;
            }

        }


        private InvokeListBox(String as[], int ai[], int ai1[]) {
            this$0 = WebViewClassic.this;
            super();
            mMultiple = true;
            mSelectedArray = ai1;
            int i = as.length;
            mContainers = new Container[i];
            for(int j = 0; j < i; j++) {
                mContainers[j] = new Container();
                mContainers[j].mString = as[j];
                mContainers[j].mEnabled = ai[j];
                mContainers[j].mId = j;
            }

        }

    }

    public static interface PageSwapDelegate {

        public abstract void onPageSwapOccurred(boolean flag);
    }

    static class FocusTransitionDrawable extends Drawable {

        public void draw(Canvas canvas) {
            if(mTranslate == null) {
                Rect rect2 = mPreviousRegion.getBounds();
                Point point = new Point(rect2.centerX(), rect2.centerY());
                mNewRegion.getBounds(rect2);
                Point point1 = new Point(rect2.centerX(), rect2.centerY());
                mTranslate = new Point(point.x - point1.x, point.y - point1.y);
            }
            int i = (int)(mProgress * (float)mMaxAlpha);
            RegionIterator regioniterator = new RegionIterator(mPreviousRegion);
            Rect rect = new Rect();
            mPaint.setAlpha(mMaxAlpha - i);
            float f = (float)mTranslate.x * mProgress;
            float f1 = (float)mTranslate.y * mProgress;
            int j = canvas.save(1);
            canvas.translate(-f, -f1);
            for(; regioniterator.next(rect); canvas.drawRect(rect, mPaint));
            canvas.restoreToCount(j);
            RegionIterator regioniterator1 = new RegionIterator(mNewRegion);
            Rect rect1 = new Rect();
            mPaint.setAlpha(i);
            int k = canvas.save(1);
            canvas.translate((float)mTranslate.x - f, (float)mTranslate.y - f1);
            for(; regioniterator1.next(rect1); canvas.drawRect(rect1, mPaint));
            canvas.restoreToCount(k);
        }

        public int getOpacity() {
            return 0;
        }

        public float getProgress() {
            return mProgress;
        }

        public void setAlpha(int i) {
        }

        public void setColorFilter(ColorFilter colorfilter) {
        }

        public void setProgress(float f) {
            mProgress = f;
            if(mWebView.mFocusTransition == this) {
                if(mProgress == 1.0F)
                    mWebView.mFocusTransition = null;
                mWebView.invalidate();
            }
        }

        int mMaxAlpha;
        Region mNewRegion;
        Paint mPaint;
        Region mPreviousRegion;
        float mProgress;
        Point mTranslate;
        WebViewClassic mWebView;

        public FocusTransitionDrawable(WebViewClassic webviewclassic) {
            mProgress = 0.0F;
            mWebView = webviewclassic;
            mPaint = new Paint(mWebView.mTouchHightlightPaint);
            mMaxAlpha = mPaint.getAlpha();
        }
    }

    class PrivateHandler extends Handler
        implements WebViewInputDispatcher.UiCallbacks {

        public void clearPreviousHitTest() {
            setHitTestResult(null);
        }

        public void dispatchUiEvent(MotionEvent motionevent, int i, int j) {
            onHandleUiEvent(motionevent, i, j);
        }

        public Context getContext() {
            return WebViewClassic.this.getContext();
        }

        public Looper getUiLooper() {
            return getLooper();
        }

        public void handleMessage(Message message) {
_L2:
            return;
            if(mWebViewCore == null || mBlockWebkitViewMessages && message.what != 107) goto _L2; else goto _L1
_L1:
            switch(message.what) {
            default:
                super.handleMessage(message);
                continue; /* Loop/switch isn't completed */

            case 5001: 
                String as1[] = mWebViewCore.getReadModeString();
                getWebViewClient().onReadModeDataReady(as1[0], as1[1], as1[2], mWebView);
                continue; /* Loop/switch isn't completed */

            case 1: // '\001'
                mDatabase.setUsernamePassword(message.getData().getString("host"), message.getData().getString("username"), message.getData().getString("password"));
                ((Message)message.obj).sendToTarget();
                continue; /* Loop/switch isn't completed */

            case 2: // '\002'
                mDatabase.setUsernamePassword(message.getData().getString("host"), null, null);
                ((Message)message.obj).sendToTarget();
                continue; /* Loop/switch isn't completed */

            case 11: // '\013'
                if(mAutoScrollX == 0 && mAutoScrollY == 0) {
                    mSentAutoScrollMessage = false;
                } else {
                    if(mCurrentScrollingLayerId == 0)
                        pinScrollBy(mAutoScrollX, mAutoScrollY, true, 0);
                    else
                        scrollLayerTo(mScrollingLayerRect.left + mAutoScrollX, mScrollingLayerRect.top + mAutoScrollY);
                    sendEmptyMessageDelayed(11, 16L);
                }
                continue; /* Loop/switch isn't completed */

            case 101: // 'e'
                if(message.arg2 == 1) {
                    InputMethodManager inputmethodmanager = InputMethodManager.peekInstance();
                    if(inputmethodmanager == null || !inputmethodmanager.isAcceptingText() || !inputmethodmanager.isActive(mWebView))
                        continue; /* Loop/switch isn't completed */
                }
                Point point = (Point)message.obj;
                WebViewClassic webviewclassic1 = WebViewClassic.this;
                int l4 = point.x;
                int i5 = point.y;
                boolean flag3;
                if(message.arg1 == 1)
                    flag3 = true;
                else
                    flag3 = false;
                webviewclassic1.contentScrollTo(l4, i5, flag3);
                break;

            case 109: // 'm'
                WebViewCore.ViewState viewstate = (WebViewCore.ViewState)message.obj;
                mZoomManager.updateZoomRange(viewstate, getViewWidth(), viewstate.mScrollX);
                break;

            case 139: 
                float f = ((Float)message.obj).floatValue();
                mZoomManager.updateDefaultZoomDensity(f);
                break;

            case 105: // 'i'
                WebViewCore.DrawData drawdata = (WebViewCore.DrawData)message.obj;
                setNewPicture(drawdata, true);
                break;

            case 107: // 'k'
                String s3 = BrowserFrame.getRawResFilename(3, mContext);
                android.view.Display display = ((WindowManager)mContext.getSystemService("window")).getDefaultDisplay();
                nativeCreate(message.arg1, s3, ActivityManager.isHighEndGfx(display));
                if(mDelaySetPicture != null) {
                    setNewPicture(mDelaySetPicture, true);
                    mDelaySetPicture = null;
                }
                if(mIsPaused)
                    WebViewClassic.nativeSetPauseDrawing(mNativeClass, true);
                mInputDispatcher = new WebViewInputDispatcher(this, mWebViewCore.getInputDispatcherCallbacks());
                break;

            case 108: // 'l'
                if(message.arg2 == mTextGeneration) {
                    String s2 = (String)message.obj;
                    if(s2 == null)
                        s2 = "";
                    if(mInputConnection != null && mFieldPointer == message.arg1)
                        mInputConnection.setTextAndKeepSelection(s2);
                }
                break;

            case 112: // 'p'
                updateTextSelectionFromMessage(message.arg1, message.arg2, (WebViewCore.TextSelectionData)message.obj);
                break;

            case 110: // 'n'
                int k4 = message.arg1;
                View view1 = mWebView.focusSearch(k4);
                if(view1 != null && view1 != mWebView)
                    view1.requestFocus();
                break;

            case 111: // 'o'
                hideSoftKeyboard();
                break;

            case 117: // 'u'
                Rect rect = (Rect)message.obj;
                if(rect == null)
                    invalidate();
                else
                    viewInvalidate(rect.left, rect.top, rect.right, rect.bottom);
                break;

            case 6: // '\006'
                if(mFieldPointer == message.arg1) {
                    ArrayAdapter arrayadapter = (ArrayAdapter)message.obj;
                    mAutoCompletePopup.setAdapter(arrayadapter);
                }
                break;

            case 114: // 'r'
                mGotCenterDown = false;
                mTrackballDown = false;
                mWebView.performLongClick();
                break;

            case 116: // 't'
                WebViewInputDispatcher webviewinputdispatcher = mInputDispatcher;
                boolean flag2;
                if(message.arg1 != 0)
                    flag2 = true;
                else
                    flag2 = false;
                webviewinputdispatcher.setWebKitWantsTouchEvents(flag2);
                break;

            case 118: // 'v'
                if(message.arg1 == 0)
                    hideSoftKeyboard();
                else
                    displaySoftKeyboard(false);
                break;

            case 8: // '\b'
                mHeldMotionless = 2;
                invalidate();
                break;

            case 136: 
                WebView webview = mWebView;
                boolean flag1;
                if(message.arg1 == 1)
                    flag1 = true;
                else
                    flag1 = false;
                webview.setKeepScreenOn(flag1);
                break;

            case 137: 
                int j4 = message.arg1;
                String s1 = (String)message.obj;
                if(mHTML5VideoViewProxy != null)
                    mHTML5VideoViewProxy.enterFullScreenVideo(j4, s1);
                break;

            case 140: 
                if(mHTML5VideoViewProxy != null)
                    mHTML5VideoViewProxy.exitFullScreenVideo();
                break;

            case 120: // 'x'
                View view = (View)message.obj;
                int l3 = message.arg1;
                int i4 = message.arg2;
                if(inFullScreenMode()) {
                    Log.w("webview", "Should not have another full screen.");
                    dismissFullScreenMode();
                }
                mFullScreenHolder = new PluginFullScreenHolder(WebViewClassic.this, l3, i4);
                mFullScreenHolder.setContentView(view);
                mFullScreenHolder.show();
                invalidate();
                break;

            case 121: // 'y'
                dismissFullScreenMode();
                break;

            case 113: // 'q'
                WebViewCore.ShowRectData showrectdata = (WebViewCore.ShowRectData)message.obj;
                int j1 = contentToViewX(showrectdata.mLeft);
                int k1 = contentToViewDimension(showrectdata.mWidth);
                int l1 = contentToViewDimension(showrectdata.mContentWidth);
                int i2 = getViewWidth();
                int j2 = Math.max(0, Math.min(l1, i2 + (int)(((float)j1 + showrectdata.mXPercentInDoc * (float)k1) - showrectdata.mXPercentInView * (float)i2)) - i2);
                int k2 = contentToViewY(showrectdata.mTop);
                int l2 = contentToViewDimension(showrectdata.mHeight);
                int i3 = contentToViewDimension(showrectdata.mContentHeight);
                int j3 = getViewHeight();
                int k3 = Math.max(0, Math.max(0, Math.min(i3, j3 + (int)(((float)k2 + showrectdata.mYPercentInDoc * (float)l2) - showrectdata.mYPercentInView * (float)j3)) - j3) - getVisibleTitleHeightImpl());
                mWebView.scrollTo(j2, k3);
                break;

            case 127: // '\177'
                centerFitRect((Rect)message.obj);
                break;

            case 129: 
                mHorizontalScrollBarMode = message.arg1;
                mVerticalScrollBarMode = message.arg2;
                break;

            case 130: 
                if(isAccessibilityEnabled())
                    getAccessibilityInjector().handleSelectionChangedIfNecessary((String)message.obj);
                break;

            case 147: 
                WebViewClassic webviewclassic = WebViewClassic.this;
                WebViewCore.WebKitHitTest webkithittest;
                boolean flag;
                if(message.arg1 == mFieldPointer)
                    flag = true;
                else
                    flag = false;
                webviewclassic.mIsEditingText = flag;
                if(mAutoCompletePopup != null && !mIsEditingText)
                    mAutoCompletePopup.clearAdapter();
                // fall through

            case 131: 
                webkithittest = (WebViewCore.WebKitHitTest)message.obj;
                mFocusedNode = webkithittest;
                setTouchHighlightRects(webkithittest);
                setHitTestResult(webkithittest);
                break;

            case 132: 
                SaveWebArchiveMessage savewebarchivemessage = (SaveWebArchiveMessage)message.obj;
                if(savewebarchivemessage.mCallback != null)
                    savewebarchivemessage.mCallback.onReceiveValue(savewebarchivemessage.mResultFile);
                break;

            case 133: 
                mAutoFillData = (WebViewCore.AutoFillData)message.obj;
                if(mInputConnection != null) {
                    mInputConnection.setAutoFillable(mAutoFillData.getQueryId());
                    mAutoCompletePopup.setAutoFillQueryId(mAutoFillData.getQueryId());
                }
                break;

            case 134: 
                if(mAutoCompletePopup != null) {
                    ArrayList arraylist = new ArrayList();
                    mAutoCompletePopup.setAdapter(new ArrayAdapter(mContext, 0x10900c6, arraylist));
                }
                break;

            case 141: 
                copyToClipboard((String)message.obj);
                break;

            case 5000: 
                String as[] = (String[])(String[])message.obj;
                mBeforeStart = as[0];
                mAfterStart = as[1];
                invalidate();
                break;

            case 142: 
                if(mInputConnection != null) {
                    WebViewCore.TextFieldInitData textfieldinitdata = (WebViewCore.TextFieldInitData)message.obj;
                    mTextGeneration = 0;
                    mFieldPointer = textfieldinitdata.mFieldPointer;
                    mInputConnection.initEditorInfo(textfieldinitdata);
                    mInputConnection.setTextAndKeepSelection(textfieldinitdata.mText);
                    mEditTextContentBounds.set(textfieldinitdata.mContentBounds);
                    mEditTextLayerId = textfieldinitdata.mNodeLayerId;
                    WebViewClassic.nativeMapLayerRect(mNativeClass, mEditTextLayerId, mEditTextContentBounds);
                    mEditTextContent.set(textfieldinitdata.mContentRect);
                    relocateAutoCompletePopup();
                }
                break;

            case 143: 
                String s = (String)message.obj;
                int k = message.arg1;
                int l = message.arg2;
                int i1 = k + s.length();
                replaceTextfieldText(k, l, s, i1, i1);
                selectionDone();
                break;

            case 126: // '~'
                WebViewCore.FindAllRequest findallrequest = (WebViewCore.FindAllRequest)message.obj;
                if(findallrequest == null) {
                    if(mFindCallback != null)
                        mFindCallback.updateMatchCount(0, 0, true);
                } else
                if(findallrequest == mFindRequest) {
                    int i;
                    int j;
                    synchronized(mFindRequest) {
                        i = findallrequest.mMatchCount;
                        j = findallrequest.mMatchIndex;
                    }
                    if(mFindCallback != null)
                        mFindCallback.updateMatchCount(j, i, false);
                    if(mFindListener != null)
                        mFindListener.onFindResultReceived(j, i, true);
                }
                break;

            case 144: 
                if(mIsCaretSelection)
                    selectionDone();
                break;

            case 145: 
                sendBatchableInputMessage(223, message.arg1, 0, null);
                break;

            case 146: 
                relocateAutoCompletePopup();
                break;

            case 148: 
                mWebViewCore.sendMessage(192, message.arg1, 0);
                break;

            case 150: 
                if(message.arg1 == mFieldPointer)
                    mEditTextContent.set((Rect)message.obj);
                break;

            case 151: 
                if(!mSelectingText && mIsEditingText && mIsCaretSelection) {
                    setupWebkitSelect();
                    resetCaretTimer();
                    showPasteWindow();
                }
                break;

            case 152: 
                mEditTextContentBounds.set((Rect)message.obj);
                WebViewClassic.nativeMapLayerRect(mNativeClass, mEditTextLayerId, mEditTextContentBounds);
                break;

            case 149: 
                scrollEditWithCursor();
                break;
            }
            continue; /* Loop/switch isn't completed */
            exception;
            findallrequest1;
            JVM INSTR monitorexit ;
            throw exception;
            if(true) goto _L2; else goto _L3
_L3:
        }

        public boolean shouldInterceptTouchEvent(MotionEvent motionevent) {
            boolean flag = false;
            if(mSelectingText) goto _L2; else goto _L1
_L1:
            return flag;
_L2:
            ensureSelectionHandles();
            int i = Math.round((motionevent.getY() - (float)getTitleHeight()) + (float)getScrollY());
            int j = Math.round(motionevent.getX() + (float)getScrollX());
            if(mIsCaretSelection)
                flag = mSelectHandleCenter.getBounds().contains(j, i);
            else
            if(mSelectHandleLeft.getBounds().contains(j, i) || mSelectHandleRight.getBounds().contains(j, i))
                flag = true;
            if(true) goto _L1; else goto _L3
_L3:
        }

        public void showTapHighlight(boolean flag) {
            if(mShowTapHighlight != flag) {
                mShowTapHighlight = flag;
                invalidate();
            }
        }

        final WebViewClassic this$0;

        PrivateHandler() {
            this$0 = WebViewClassic.this;
            super();
        }
    }

    private class RequestFormData
        implements Runnable {

        public void run() {
            ArrayList arraylist = new ArrayList();
            if(mAutoFillable)
                if(mWebSettings != null && mWebSettings.getAutoFillProfile() != null) {
                    arraylist.add((new StringBuilder()).append(mWebView.getResources().getText(0x1040342).toString()).append(" ").append(mAutoFillData.getPreviewString()).toString());
                    mAutoCompletePopup.setIsAutoFillProfileSet(true);
                } else {
                    arraylist.add(mWebView.getResources().getText(0x1040343).toString());
                    mAutoCompletePopup.setIsAutoFillProfileSet(false);
                }
            if(mAutoComplete)
                arraylist.addAll(mDatabase.getFormData(mUrl, mName));
            if(arraylist.size() > 0) {
                ArrayAdapter arrayadapter = new ArrayAdapter(mContext, 0x10900c6, arraylist);
                mUpdateMessage.obj = arrayadapter;
                mUpdateMessage.sendToTarget();
            }
        }

        private boolean mAutoComplete;
        private boolean mAutoFillable;
        private String mName;
        private Message mUpdateMessage;
        private String mUrl;
        private WebSettingsClassic mWebSettings;
        final WebViewClassic this$0;

        public RequestFormData(String s, String s1, Message message, boolean flag, boolean flag1) {
            this$0 = WebViewClassic.this;
            super();
            mName = s;
            mUrl = WebTextView.urlForAutoCompleteData(s1);
            mUpdateMessage = message;
            mAutoFillable = flag;
            mAutoComplete = flag1;
            mWebSettings = getSettings();
        }
    }

    private class SelectionHandleAlpha {

        public int getAlpha() {
            return mAlpha;
        }

        public void setAlpha(int i) {
            mAlpha = i;
            if(mSelectHandleCenter != null) {
                mSelectHandleCenter.setAlpha(i);
                mSelectHandleLeft.setAlpha(i);
                mSelectHandleRight.setAlpha(i);
                invalidate();
            }
        }

        private int mAlpha;
        final WebViewClassic this$0;

        private SelectionHandleAlpha() {
            this$0 = WebViewClassic.this;
            super();
            mAlpha = 0;
        }

    }

    static class ViewSizeData {

        int mActualViewHeight;
        int mAnchorX;
        int mAnchorY;
        int mHeight;
        float mHeightWidthRatio;
        boolean mIgnoreHeight;
        float mScale;
        int mTextWrapWidth;
        int mWidth;

        ViewSizeData() {
        }
    }

    static class SaveWebArchiveMessage {

        final boolean mAutoname;
        final String mBasename;
        final ValueCallback mCallback;
        String mResultFile;

        SaveWebArchiveMessage(String s, boolean flag, ValueCallback valuecallback) {
            mBasename = s;
            mAutoname = flag;
            mCallback = valuecallback;
        }
    }

    private static class DestroyNativeRunnable
        implements Runnable {

        public void run() {
            WebViewClassic.nativeDestroy(mNativePtr);
        }

        private int mNativePtr;

        public DestroyNativeRunnable(int i) {
            mNativePtr = i;
        }
    }

    public static interface TitleBarDelegate {

        public abstract int getTitleHeight();

        public abstract void onSetEmbeddedTitleBar(View view);
    }

    private static class PackageListener extends BroadcastReceiver {

        public void onReceive(Context context, Intent intent) {
            String s;
            String s1;
            boolean flag;
            s = intent.getAction();
            s1 = intent.getData().getSchemeSpecificPart();
            flag = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
            if(!"android.intent.action.PACKAGE_REMOVED".equals(s) || !flag) goto _L2; else goto _L1
_L1:
            return;
_L2:
            PluginManager pluginmanager;
            if(WebViewClassic.sGoogleApps.contains(s1))
                if("android.intent.action.PACKAGE_ADDED".equals(s))
                    WebViewCore.sendStaticMessage(185, s1);
                else
                    WebViewCore.sendStaticMessage(186, s1);
            pluginmanager = PluginManager.getInstance(context);
            if(pluginmanager.containsPluginPermissionAndSignatures(s1))
                pluginmanager.refreshPlugins("android.intent.action.PACKAGE_ADDED".equals(s));
            if(true) goto _L1; else goto _L3
_L3:
        }

        private PackageListener() {
        }

    }

    private static class ProxyReceiver extends BroadcastReceiver {

        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals("android.intent.action.PROXY_CHANGE"))
                WebViewClassic.handleProxyBroadcast(intent);
        }

        private ProxyReceiver() {
        }

    }

    private static class TrustStorageListener extends BroadcastReceiver {

        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals("android.security.STORAGE_CHANGED"))
                WebViewClassic.handleCertTrustChanged();
        }

        private TrustStorageListener() {
        }

    }

    static class Factory
        implements WebViewFactoryProvider, WebViewFactoryProvider.Statics {

        public WebViewProvider createWebView(WebView webview, WebView.PrivateAccess privateaccess) {
            return new WebViewClassic(webview, privateaccess);
        }

        public String findAddress(String s) {
            return WebViewClassic.findAddress(s);
        }

        public CookieManager getCookieManager() {
            return CookieManagerClassic.getInstance();
        }

        public GeolocationPermissions getGeolocationPermissions() {
            return GeolocationPermissionsClassic.getInstance();
        }

        public WebViewFactoryProvider.Statics getStatics() {
            return this;
        }

        public WebIconDatabase getWebIconDatabase() {
            return WebIconDatabaseClassic.getInstance();
        }

        public WebStorage getWebStorage() {
            return WebStorageClassic.getInstance();
        }

        public WebViewDatabase getWebViewDatabase(Context context) {
            return WebViewDatabaseClassic.getInstance(context);
        }

        public void setPlatformNotificationsEnabled(boolean flag) {
            if(flag)
                WebViewClassic.enablePlatformNotifications();
            else
                WebViewClassic.disablePlatformNotifications();
        }

        Factory() {
        }
    }

    static class FocusNodeHref {

        static final String SRC = "src";
        static final String TITLE = "title";
        static final String URL = "url";

        FocusNodeHref() {
        }
    }

    private static class OnTrimMemoryListener
        implements ComponentCallbacks2 {

        static void init(Context context) {
            if(sInstance == null)
                sInstance = new OnTrimMemoryListener(context.getApplicationContext());
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
        }

        public void onTrimMemory(int i) {
            if(i >= 20)
                HTML5VideoInline.cleanupSurfaceTexture();
            WebViewClassic.nativeOnTrimMemory(i);
        }

        private static OnTrimMemoryListener sInstance = null;


        private OnTrimMemoryListener(Context context) {
            context.registerComponentCallbacks(this);
        }
    }

    private class PastePopupWindow extends PopupWindow
        implements android.view.View.OnClickListener {

        public void hide() {
            dismiss();
        }

        protected void measureContent() {
            DisplayMetrics displaymetrics = mContext.getResources().getDisplayMetrics();
            mContentView.measure(android.view.View.MeasureSpec.makeMeasureSpec(displaymetrics.widthPixels, 0x80000000), android.view.View.MeasureSpec.makeMeasureSpec(displaymetrics.heightPixels, 0x80000000));
        }

        public void onClick(View view) {
            pasteFromClipboard();
            selectionDone();
        }

        public void show(Point point, Point point1, int i, int j) {
            measureContent();
            int k = mContentView.getMeasuredWidth();
            int l = mContentView.getMeasuredHeight();
            int i1 = point1.y - l;
            int j1 = point1.x - k / 2;
            if(i1 < j) {
                ensureSelectionHandles();
                i1 = point.y + mSelectHandleCenter.getIntrinsicHeight();
                j1 = point.x - k / 2;
            }
            if(j1 < i)
                j1 = i;
            if(!isShowing())
                showAtLocation(mWebView, 0, j1, i1);
            update(j1, i1, k, l);
        }

        private ViewGroup mContentView;
        private TextView mPasteTextView;
        final WebViewClassic this$0;

        public PastePopupWindow() {
            this$0 = WebViewClassic.this;
            super(mContext, null, 0x10102c8);
            setClippingEnabled(true);
            LinearLayout linearlayout = new LinearLayout(mContext);
            linearlayout.setOrientation(0);
            mContentView = linearlayout;
            mContentView.setBackgroundResource(0x10805b7);
            LayoutInflater layoutinflater = (LayoutInflater)mContext.getSystemService("layout_inflater");
            android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(-2, -2);
            mPasteTextView = (TextView)layoutinflater.inflate(0x10900b4, null);
            mPasteTextView.setLayoutParams(layoutparams);
            mContentView.addView(mPasteTextView);
            mPasteTextView.setText(0x104000b);
            mPasteTextView.setOnClickListener(this);
            setContentView(mContentView);
        }
    }

    class WebViewInputConnection extends BaseInputConnection {

        private CharSequence limitReplaceTextByMaxLength(CharSequence charsequence, int i) {
            if(mMaxLength > 0) {
                Editable editable = getEditable();
                int j = i + (mMaxLength - editable.length());
                if(j < charsequence.length())
                    charsequence = charsequence.subSequence(0, Math.max(j, 0));
            }
            return charsequence;
        }

        private void restartInput() {
            InputMethodManager inputmethodmanager = InputMethodManager.peekInstance();
            if(inputmethodmanager != null)
                inputmethodmanager.restartInput(mWebView);
        }

        private void sendCharacter(char c) {
            if(mKeyCharacterMap == null)
                mKeyCharacterMap = KeyCharacterMap.load(-1);
            char ac[] = new char[1];
            ac[0] = c;
            KeyEvent akeyevent[] = mKeyCharacterMap.getEvents(ac);
            if(akeyevent != null) {
                int i = akeyevent.length;
                for(int j = 0; j < i; j++)
                    sendKeyEvent(akeyevent[j]);

            } else {
                Message message = mPrivateHandler.obtainMessage(145, c, 0);
                mPrivateHandler.sendMessage(message);
            }
        }

        private void sendKey(int i) {
            long l = SystemClock.uptimeMillis();
            sendKeyEvent(new KeyEvent(l, l, 0, i, 0, 0, -1, 0, 2));
            sendKeyEvent(new KeyEvent(SystemClock.uptimeMillis(), l, 1, i, 0, 0, -1, 0, 2));
        }

        private void setNewText(int i, int j, CharSequence charsequence) {
            mIsKeySentByMe = true;
            Editable editable = getEditable();
            CharSequence charsequence1 = editable.subSequence(i, j);
            boolean flag = false;
            boolean flag1 = false;
            int k = charsequence.length();
            int l = charsequence1.length();
            if(Selection.getSelectionStart(editable) == Selection.getSelectionEnd(editable))
                if(k > l) {
                    if(k == l + 1 && TextUtils.regionMatches(charsequence, 0, charsequence1, 0, l))
                        flag = true;
                    else
                        flag = false;
                } else
                if(l > k)
                    if(k == l - 1 && TextUtils.regionMatches(charsequence, 0, charsequence1, 0, k))
                        flag1 = true;
                    else
                        flag1 = false;
            if(flag)
                sendCharacter(charsequence.charAt(k - 1));
            else
            if(flag1)
                sendKey(67);
            else
            if(k != l || !TextUtils.regionMatches(charsequence, 0, charsequence1, 0, k)) {
                Message message = mPrivateHandler.obtainMessage(143, i, j, charsequence.toString());
                mPrivateHandler.sendMessage(message);
            }
            if(mAutoCompletePopup != null) {
                StringBuilder stringbuilder = new StringBuilder();
                stringbuilder.append(editable.subSequence(0, i));
                stringbuilder.append(charsequence);
                stringbuilder.append(editable.subSequence(j, editable.length()));
                mAutoCompletePopup.setText(stringbuilder.toString());
            }
            mIsKeySentByMe = false;
        }

        private void updateSelection() {
            Editable editable = getEditable();
            int i = Selection.getSelectionStart(editable);
            int j = Selection.getSelectionEnd(editable);
            int k = getComposingSpanStart(editable);
            int l = getComposingSpanEnd(editable);
            InputMethodManager inputmethodmanager = InputMethodManager.peekInstance();
            if(inputmethodmanager != null)
                inputmethodmanager.updateSelection(mWebView, i, j, k, l);
        }

        public boolean beginBatchEdit() {
            if(mBatchLevel == 0)
                beginTextBatch();
            mBatchLevel = 1 + mBatchLevel;
            return false;
        }

        public boolean commitText(CharSequence charsequence, int i) {
            setComposingText(charsequence, i);
            finishComposingText();
            return true;
        }

        public boolean deleteSurroundingText(int i, int j) {
            Editable editable = getEditable();
            int k = Selection.getSelectionStart(editable);
            int l = Selection.getSelectionEnd(editable);
            if(k > l) {
                int j2 = k;
                k = l;
                l = j2;
            }
            int i1 = getComposingSpanStart(editable);
            int j1 = getComposingSpanEnd(editable);
            if(j1 < i1) {
                int i2 = i1;
                i1 = j1;
                j1 = i2;
            }
            if(i1 != -1 && j1 != -1) {
                if(i1 < k)
                    k = i1;
                if(j1 > l)
                    l = j1;
            }
            int k1 = Math.min(editable.length(), l + j);
            if(k1 > l)
                setNewText(l, k1, "");
            int l1 = Math.max(0, k - i);
            if(l1 < k)
                setNewText(l1, k, "");
            return super.deleteSurroundingText(i, j);
        }

        public boolean endBatchEdit() {
            mBatchLevel = -1 + mBatchLevel;
            if(mBatchLevel == 0)
                commitTextBatch();
            return false;
        }

        public boolean getIsAutoFillable() {
            return mIsAutoFillable;
        }

        public void initEditorInfo(WebViewCore.TextFieldInitData textfieldinitdata) {
            int i;
            int j;
            int k;
            i = textfieldinitdata.mType;
            j = 161;
            k = 0x12000000;
            if(!textfieldinitdata.mIsSpellCheckEnabled)
                j |= 0x80000;
            if(1 != i) {
                if(textfieldinitdata.mIsTextFieldNext)
                    k |= 0x8000000;
                if(textfieldinitdata.mIsTextFieldPrev)
                    k |= 0x4000000;
            }
            i;
            JVM INSTR tableswitch 0 7: default 104
        //                       0 164
        //                       1 173
        //                       2 188
        //                       3 203
        //                       4 212
        //                       5 225
        //                       6 238
        //                       7 249;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
            int l = k | 2;
_L11:
            mHint = textfieldinitdata.mLabel;
            mInputType = j;
            mImeOptions = l;
            mMaxLength = textfieldinitdata.mMaxLength;
            mIsAutoCompleteEnabled = textfieldinitdata.mIsAutoCompleteEnabled;
            mName = textfieldinitdata.mName;
            mAutoCompletePopup.clearAdapter();
            return;
_L2:
            l = k | 2;
            continue; /* Loop/switch isn't completed */
_L3:
            j |= 0x2c000;
            l = k | 1;
            continue; /* Loop/switch isn't completed */
_L4:
            j |= 0xe0;
            l = k | 2;
            continue; /* Loop/switch isn't completed */
_L5:
            l = k | 3;
            continue; /* Loop/switch isn't completed */
_L6:
            j = 209;
            l = k | 2;
            continue; /* Loop/switch isn't completed */
_L7:
            j = 12290;
            l = k | 5;
            continue; /* Loop/switch isn't completed */
_L8:
            j = 3;
            l = k | 5;
            continue; /* Loop/switch isn't completed */
_L9:
            l = k | 2;
            j |= 0x10;
            if(true) goto _L11; else goto _L10
_L10:
        }

        public boolean performEditorAction(int i) {
            boolean flag = true;
            i;
            JVM INSTR tableswitch 2 7: default 40
        //                       2 88
        //                       3 88
        //                       4 40
        //                       5 48
        //                       6 78
        //                       7 63;
               goto _L1 _L2 _L2 _L1 _L3 _L4 _L5
_L1:
            flag = super.performEditorAction(i);
_L7:
            return flag;
_L3:
            mWebView.requestFocus(2);
            continue; /* Loop/switch isn't completed */
_L5:
            mWebView.requestFocus(1);
            continue; /* Loop/switch isn't completed */
_L4:
            hideSoftKeyboard();
            continue; /* Loop/switch isn't completed */
_L2:
            hideSoftKeyboard();
            String s = getEditable().toString();
            passToJavaScript(s, new KeyEvent(0, 66));
            passToJavaScript(s, new KeyEvent(1, 66));
            if(true) goto _L7; else goto _L6
_L6:
        }

        public void replaceSelection(CharSequence charsequence) {
            Editable editable = getEditable();
            int i = Selection.getSelectionStart(editable);
            int j = Selection.getSelectionEnd(editable);
            CharSequence charsequence1 = limitReplaceTextByMaxLength(charsequence, j - i);
            setNewText(i, j, charsequence1);
            editable.replace(i, j, charsequence1);
            restartInput();
            int k = i + charsequence1.length();
            setSelection(k, k);
        }

        public boolean sendKeyEvent(KeyEvent keyevent) {
            boolean flag = true;
            if(mIsKeySentByMe) goto _L2; else goto _L1
_L1:
            if(keyevent.getAction() != flag) goto _L4; else goto _L3
_L3:
            if(keyevent.getKeyCode() != 67) goto _L6; else goto _L5
_L5:
            flag = deleteSurroundingText(flag, 0);
_L8:
            return flag;
_L6:
            if(keyevent.getKeyCode() == 112) {
                flag = deleteSurroundingText(0, flag);
                continue; /* Loop/switch isn't completed */
            }
            if(keyevent.getUnicodeChar() != 0) {
                flag = commitText(Character.toString((char)keyevent.getUnicodeChar()), flag);
                continue; /* Loop/switch isn't completed */
            }
              goto _L2
_L4:
            if(keyevent.getAction() == 0 && (keyevent.getKeyCode() == 67 || keyevent.getKeyCode() == 112 || keyevent.getUnicodeChar() != 0))
                continue; /* Loop/switch isn't completed */
_L2:
            flag = super.sendKeyEvent(keyevent);
            if(true) goto _L8; else goto _L7
_L7:
        }

        public void setAutoFillable(int i) {
            boolean flag;
            if(getSettings().getAutoFillEnabled() && i != -1)
                flag = true;
            else
                flag = false;
            mIsAutoFillable = flag;
            if((0xff0 & mInputType) != 224 && (mIsAutoFillable || mIsAutoCompleteEnabled) && mName != null && mName.length() > 0)
                requestFormData(mName, mFieldPointer, mIsAutoFillable, mIsAutoCompleteEnabled);
        }

        public boolean setComposingRegion(int i, int j) {
            boolean flag = super.setComposingRegion(i, j);
            updateSelection();
            return flag;
        }

        public boolean setComposingText(CharSequence charsequence, int i) {
            Editable editable = getEditable();
            int j = getComposingSpanStart(editable);
            int k = getComposingSpanEnd(editable);
            if(j < 0 || k < 0) {
                j = Selection.getSelectionStart(editable);
                k = Selection.getSelectionEnd(editable);
            }
            if(k < j) {
                int i1 = k;
                k = j;
                j = i1;
            }
            CharSequence charsequence1 = limitReplaceTextByMaxLength(charsequence, k - j);
            setNewText(j, k, charsequence1);
            if(charsequence1 != charsequence)
                i -= charsequence.length() - charsequence1.length();
            super.setComposingText(charsequence1, i);
            updateSelection();
            if(charsequence1 != charsequence) {
                restartInput();
                int l = j + charsequence1.length();
                finishComposingText();
                setSelection(l, l);
            }
            return true;
        }

        public boolean setSelection(int i, int j) {
            boolean flag = super.setSelection(i, j);
            updateSelection();
            return flag;
        }

        public void setTextAndKeepSelection(CharSequence charsequence) {
            Editable editable = getEditable();
            int i = Selection.getSelectionStart(editable);
            int j = Selection.getSelectionEnd(editable);
            CharSequence charsequence1 = limitReplaceTextByMaxLength(charsequence, editable.length());
            editable.replace(0, editable.length(), charsequence1);
            restartInput();
            setSelection(Math.min(i, editable.length()), Math.min(j, editable.length()));
            finishComposingText();
        }

        public void setupEditorInfo(EditorInfo editorinfo) {
            editorinfo.inputType = mInputType;
            editorinfo.imeOptions = mImeOptions;
            editorinfo.hintText = mHint;
            editorinfo.initialCapsMode = getCursorCapsMode(1);
            Editable editable = getEditable();
            int i = Selection.getSelectionStart(editable);
            int j = Selection.getSelectionEnd(editable);
            if(i < 0 || j < 0) {
                i = editable.length();
                j = i;
            }
            editorinfo.initialSelStart = i;
            editorinfo.initialSelEnd = j;
        }

        private int mBatchLevel;
        private String mHint;
        private int mImeOptions;
        private int mInputType;
        private boolean mIsAutoCompleteEnabled;
        private boolean mIsAutoFillable;
        private boolean mIsKeySentByMe;
        private KeyCharacterMap mKeyCharacterMap;
        private int mMaxLength;
        private String mName;
        final WebViewClassic this$0;

        public WebViewInputConnection() {
            this$0 = WebViewClassic.this;
            super(mWebView, true);
        }
    }


    public WebViewClassic(WebView webview, WebView.PrivateAccess privateaccess) {
        mListBoxDialog = null;
        mIsWebViewVisible = true;
        mInputConnection = null;
        mEditTextContentBounds = new Rect();
        mEditTextContent = new Rect();
        mIsEditingText = false;
        mBatchedTextChanges = new ArrayList();
        mIsBatchingTextChanges = false;
        mLastEditScroll = 0L;
        mCurrentTouchInterval = 0;
        mScrollingLayerRect = new Rect();
        mTouchMode = 7;
        mDrawCursorRing = true;
        mOverlayHorizontalScrollbar = true;
        mOverlayVerticalScrollbar = false;
        mInOverScrollMode = false;
        mSelectCursorLeft = new Point();
        mSelectCursorLeftTextQuad = new QuadF();
        mSelectCursorRight = new Point();
        mSelectCursorRightTextQuad = new QuadF();
        mTouchHighlightRegion = new Region();
        mTouchHightlightPaint = new Paint();
        mBlockWebkitViewMessages = false;
        mHardwareAccelSkia = false;
        mInitialScaleInPercent = 0;
        mSendScrollEvent = true;
        mSnapScrollMode = 0;
        mHorizontalScrollBarMode = 0;
        mVerticalScrollBarMode = 0;
        mLastTouchUpTime = 0L;
        mBackgroundColor = -1;
        mAutoScrollX = 0;
        mAutoScrollY = 0;
        mMinAutoScrollX = 0;
        mMaxAutoScrollX = 0;
        mMinAutoScrollY = 0;
        mMaxAutoScrollY = 0;
        mScrollingLayerBounds = new Rect();
        mSentAutoScrollMessage = false;
        mPictureUpdatePausedForFocusChange = false;
        mCachedOverlappingActionModeHeight = -1;
        mLastVisibleRectSent = new Rect();
        mLastGlobalRect = new Rect();
        mVisibleRect = new Rect();
        mGlobalVisibleRect = new Rect();
        mScrollOffset = new Point();
        mGlobalVisibleOffset = new Point();
        mFindRequest = null;
        mOrientation = 0;
        mMenuLeft = -1;
        mMenuTop = -1;
        mDrawHistory = false;
        mHistoryPicture = null;
        mHistoryWidth = 0;
        mHistoryHeight = 0;
        mGotCenterDown = false;
        mTrackballFirstTime = 0L;
        mTrackballLastTime = 0L;
        mTrackballRemainsX = 0.0F;
        mTrackballRemainsY = 0.0F;
        mTrackballXMove = 0;
        mTrackballYMove = 0;
        mSelectingText = false;
        mShowTextSelectionExtra = false;
        mSelectionStarted = false;
        mSelectX = 0;
        mSelectY = 0;
        mTrackballDown = false;
        mTrackballUpTime = 0L;
        mLastCursorTime = 0L;
        mHandleAlpha = new SelectionHandleAlpha();
        SelectionHandleAlpha selectionhandlealpha = mHandleAlpha;
        int ai[] = new int[1];
        ai[0] = 0;
        mHandleAlphaAnimator = ObjectAnimator.ofInt(selectionhandlealpha, "alpha", ai);
        mMapTrackballToArrowKeys = true;
        mFocusTransition = null;
        mWebView = webview;
        mWebViewPrivate = privateaccess;
        mContext = webview.getContext();
    }

    private void abortAnimation() {
        mScroller.abortAnimation();
        mLastVelocity = 0.0F;
    }

    private void adjustSelectionCursors() {
        if(mIsCaretSelection) {
            syncSelectionCursors();
        } else {
            boolean flag;
            int i;
            int j;
            int k;
            int l;
            int i1;
            int j1;
            boolean flag1;
            boolean flag2;
            if(mSelectDraggingCursor == mSelectCursorLeft)
                flag = true;
            else
                flag = false;
            i = mSelectDraggingCursor.x;
            j = mSelectDraggingCursor.y;
            k = mSelectCursorLeft.x;
            l = mSelectCursorLeft.y;
            i1 = mSelectCursorRight.x;
            j1 = mSelectCursorRight.y;
            syncSelectionCursors();
            if(i1 != mSelectCursorRight.x || j1 != mSelectCursorRight.y)
                flag1 = true;
            else
                flag1 = false;
            if(k != mSelectCursorLeft.x || l != mSelectCursorLeft.y)
                flag2 = true;
            else
                flag2 = false;
            if(flag2 && flag1) {
                boolean flag3;
                Point point;
                QuadF quadf;
                Point point1;
                if(!flag)
                    flag3 = true;
                else
                    flag3 = false;
                if(flag3)
                    point = mSelectCursorLeft;
                else
                    point = mSelectCursorRight;
                mSelectDraggingCursor = point;
                if(flag3)
                    quadf = mSelectCursorLeftTextQuad;
                else
                    quadf = mSelectCursorRightTextQuad;
                mSelectDraggingTextQuad = quadf;
                if(flag3)
                    point1 = mSelectHandleLeftOffset;
                else
                    point1 = mSelectHandleRightOffset;
                mSelectDraggingOffset = point1;
            }
            mSelectDraggingCursor.set(i, j);
        }
    }

    private void beginScrollEdit() {
        if(mLastEditScroll == 0L) {
            mLastEditScroll = SystemClock.uptimeMillis() - 16L;
            scrollEditWithCursor();
        }
    }

    private void beginTextBatch() {
        mIsBatchingTextChanges = true;
    }

    private void calcOurContentVisibleRect(Rect rect) {
        calcOurVisibleRect(rect);
        rect.left = viewToContentX(rect.left);
        rect.top = viewToContentY(rect.top + getVisibleTitleHeightImpl());
        rect.right = viewToContentX(rect.right);
        rect.bottom = viewToContentY(rect.bottom);
    }

    private void calcOurContentVisibleRectF(RectF rectf) {
        calcOurVisibleRect(mTempContentVisibleRect);
        viewToContentVisibleRect(rectf, mTempContentVisibleRect);
    }

    private void calcOurVisibleRect(Rect rect) {
        mWebView.getGlobalVisibleRect(rect, mGlobalVisibleOffset);
        rect.offset(-mGlobalVisibleOffset.x, -mGlobalVisibleOffset.y);
    }

    private Point calculateCaretTop() {
        float f = scaleAlongSegment(mSelectCursorLeft.x, mSelectCursorLeft.y, mSelectCursorLeftTextQuad.p4, mSelectCursorLeftTextQuad.p3);
        return new Point(Math.round(scaleCoordinate(f, mSelectCursorLeftTextQuad.p1.x, mSelectCursorLeftTextQuad.p2.x)), Math.round(scaleCoordinate(f, mSelectCursorLeftTextQuad.p1.y, mSelectCursorLeftTextQuad.p2.y)));
    }

    private float calculateDragAngle(int i, int j) {
        int k = Math.abs(i);
        return (float)Math.atan2(Math.abs(j), k);
    }

    private boolean canTextScroll(int i, int j) {
        boolean flag = false;
        int k = getTextScrollX();
        int l = getTextScrollY();
        int i1 = getMaxTextScrollX();
        int j1 = getMaxTextScrollY();
        boolean flag1;
        boolean flag2;
        if(i > 0) {
            if(k < i1)
                flag1 = true;
            else
                flag1 = false;
        } else
        if(k > 0)
            flag1 = true;
        else
            flag1 = false;
        if(j > 0) {
            if(l < j1)
                flag2 = true;
            else
                flag2 = false;
        } else
        if(l > 0)
            flag2 = true;
        else
            flag2 = false;
        if(flag1 || flag2)
            flag = true;
        return flag;
    }

    private void cancelSelectDialog() {
        if(mListBoxDialog != null) {
            mListBoxDialog.cancel();
            mListBoxDialog = null;
        }
    }

    private void cancelTouch() {
        if(mVelocityTracker != null) {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
        if((mTouchMode == 3 || mTouchMode == 9) && !mSelectingText) {
            WebViewCore.resumePriority();
            WebViewCore.resumeUpdatePicture(mWebViewCore);
            nativeSetIsScrolling(false);
        }
        mPrivateHandler.removeMessages(3);
        mPrivateHandler.removeMessages(4);
        mPrivateHandler.removeMessages(8);
        removeTouchHighlight();
        mHeldMotionless = 2;
        mTouchMode = 7;
    }

    private void clearActionModes() {
        if(mFindCallback != null)
            mFindCallback.finish();
    }

    private void clearHelpers() {
        hideSoftKeyboard();
        clearActionModes();
        dismissFullScreenMode();
        cancelSelectDialog();
    }

    private void commitTextBatch() {
        if(mWebViewCore != null)
            mWebViewCore.sendMessages(mBatchedTextChanges);
        mBatchedTextChanges.clear();
        mIsBatchingTextChanges = false;
    }

    private static int computeDuration(int i, int j) {
        return Math.min((1000 * Math.max(Math.abs(i), Math.abs(j))) / 480, 750);
    }

    private int computeRealHorizontalScrollRange() {
        int i;
        if(mDrawHistory)
            i = mHistoryWidth;
        else
            i = (int)Math.floor((float)mContentWidth * mZoomManager.getScale());
        return i;
    }

    private int computeRealVerticalScrollRange() {
        int i;
        if(mDrawHistory)
            i = mHistoryHeight;
        else
            i = (int)Math.floor((float)mContentHeight * mZoomManager.getScale());
        return i;
    }

    private void contentScrollTo(int i, int j, boolean flag) {
        if(!mDrawHistory)
            pinScrollTo(contentToViewX(i), contentToViewY(j), flag, 0);
    }

    private void contentSizeChanged(boolean flag) {
        if((mContentWidth | mContentHeight) != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(mHeightCanMeasure) {
            if(mWebView.getMeasuredHeight() != contentToViewDimension(mContentHeight) || flag)
                mWebView.requestLayout();
        } else
        if(mWidthCanMeasure) {
            if(mWebView.getMeasuredWidth() != contentToViewDimension(mContentWidth) || flag)
                mWebView.requestLayout();
        } else {
            sendViewSizeZoom(false);
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private Rect contentToViewRect(Rect rect) {
        return new Rect(contentToViewX(rect.left), contentToViewY(rect.top), contentToViewX(rect.right), contentToViewY(rect.bottom));
    }

    private void copyToClipboard(String s) {
        ((ClipboardManager)mContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(getTitle(), s));
    }

    private void destroyJava() {
        mCallbackProxy.blockMessages();
        clearHelpers();
        if(mListBoxDialog != null) {
            mListBoxDialog.dismiss();
            mListBoxDialog = null;
        }
        if(mWebViewCore == null)
            break MISSING_BLOCK_LABEL_63;
        this;
        JVM INSTR monitorenter ;
        WebViewCore webviewcore = mWebViewCore;
        mWebViewCore = null;
        webviewcore.destroy();
        this;
        JVM INSTR monitorexit ;
        mPrivateHandler.removeCallbacksAndMessages(null);
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void destroyNative() {
        if(mNativeClass != 0) {
            int i = mNativeClass;
            mNativeClass = 0;
            if(Thread.currentThread() == mPrivateHandler.getLooper().getThread())
                nativeDestroy(i);
            else
                mPrivateHandler.post(new DestroyNativeRunnable(i));
        }
    }

    public static void disablePlatformNotifications() {
        android/webkit/WebViewClassic;
        JVM INSTR monitorenter ;
        sNotificationsEnabled = false;
        Context context = JniUtil.getContext();
        if(context != null)
            disableProxyListener(context);
        return;
    }

    /**
     * @deprecated Method disableProxyListener is deprecated
     */

    private static void disableProxyListener(Context context) {
        android/webkit/WebViewClassic;
        JVM INSTR monitorenter ;
        ProxyReceiver proxyreceiver = sProxyReceiver;
        if(proxyreceiver != null) goto _L2; else goto _L1
_L1:
        android/webkit/WebViewClassic;
        JVM INSTR monitorexit ;
        return;
_L2:
        context.getApplicationContext().unregisterReceiver(sProxyReceiver);
        sProxyReceiver = null;
        if(true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private void dismissFullScreenMode() {
        if(inFullScreenMode()) {
            mFullScreenHolder.hide();
            mFullScreenHolder = null;
            invalidate();
        }
    }

    private void displaySoftKeyboard(boolean flag) {
        InputMethodManager inputmethodmanager = (InputMethodManager)mContext.getSystemService("input_method");
        boolean flag1;
        if(mZoomManager.getScale() < mZoomManager.getDefaultScale())
            flag1 = true;
        else
            flag1 = false;
        if(flag1) {
            mZoomManager.setZoomCenter(mLastTouchX, mLastTouchY);
            mZoomManager.setZoomScale(mZoomManager.getDefaultScale(), false);
        }
        inputmethodmanager.showSoftInput(mWebView, 0);
    }

    private float distanceSquared(int i, int j, Point point) {
        float f = point.x - i;
        float f1 = point.y - j;
        return f * f + f1 * f1;
    }

    private boolean doDrag(int i, int j) {
        boolean flag = true;
        if((i | j) == 0) goto _L2; else goto _L1
_L1:
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        k = getScrollX();
        l = getScrollY();
        i1 = computeMaxScrollX();
        j1 = computeMaxScrollY();
        k1 = (int)Math.floor((float)i * mZoomManager.getInvScale());
        l1 = (int)Math.floor((float)j * mZoomManager.getInvScale());
        mTouchMode = 3;
        if(!mIsEditingText || !mTouchInEditText || !canTextScroll(i, j)) goto _L4; else goto _L3
_L3:
        k = getTextScrollX();
        i1 = getMaxTextScrollX();
        i = k1;
        l = getTextScrollY();
        j1 = getMaxTextScrollY();
        j = l1;
        mTouchMode = 10;
        flag = false;
_L6:
        if(mOverScrollGlow != null)
            mOverScrollGlow.setOverScrollDeltas(i, j);
        WebView.PrivateAccess privateaccess = mWebViewPrivate;
        int i3 = mOverscrollDistance;
        int j3 = mOverscrollDistance;
        privateaccess.overScrollBy(i, j, k, l, i1, j1, i3, j3, true);
        if(mOverScrollGlow != null && mOverScrollGlow.isAnimating())
            invalidate();
_L2:
        mZoomManager.keepZoomPickerVisible();
        return flag;
_L4:
        if(mCurrentScrollingLayerId != 0) {
            int i2 = mScrollingLayerRect.right;
            int j2 = mScrollingLayerRect.bottom;
            int k2 = Math.max(0, Math.min(k1 + mScrollingLayerRect.left, i2));
            int l2 = Math.max(0, Math.min(l1 + mScrollingLayerRect.top, j2));
            if(k2 != mScrollingLayerRect.left || l2 != mScrollingLayerRect.top || (k1 | l1) == 0) {
                mTouchMode = 9;
                i = k1;
                j = l1;
                k = mScrollingLayerRect.left;
                l = mScrollingLayerRect.top;
                i1 = i2;
                j1 = j2;
                flag = false;
            }
        }
        if(true) goto _L6; else goto _L5
_L5:
    }

    private void doFling() {
        if(mVelocityTracker != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i = computeMaxScrollX();
        int j = computeMaxScrollY();
        mVelocityTracker.computeCurrentVelocity(1000, mMaximumFling);
        int k = (int)mVelocityTracker.getXVelocity();
        int l = (int)mVelocityTracker.getYVelocity();
        int i1 = getScrollX();
        int j1 = getScrollY();
        int k1 = mOverscrollDistance;
        int l1 = mOverflingDistance;
        if(mTouchMode == 9) {
            i1 = mScrollingLayerRect.left;
            j1 = mScrollingLayerRect.top;
            i = mScrollingLayerRect.right;
            j = mScrollingLayerRect.bottom;
            l1 = 0;
            k1 = 0;
        } else
        if(mTouchMode == 10) {
            i1 = getTextScrollX();
            j1 = getTextScrollY();
            i = getMaxTextScrollX();
            j = getMaxTextScrollY();
            l1 = 0;
            k1 = 0;
        }
        if(mSnapScrollMode != 0)
            if((2 & mSnapScrollMode) == 2)
                l = 0;
            else
                k = 0;
        if(i == 0 && l == 0 || j == 0 && k == 0) {
            WebViewCore.resumePriority();
            if(!mSelectingText)
                WebViewCore.resumeUpdatePicture(mWebViewCore);
            if(mScroller.springBack(i1, j1, 0, i, 0, j))
                invalidate();
        } else {
            float f = mScroller.getCurrVelocity();
            float f1 = (float)Math.hypot(k, l);
            if(mLastVelocity > 0.0F && f > 0.0F && f1 > 0.2F * mLastVelocity) {
                float f2 = (float)Math.abs(Math.atan2(mLastVelY, mLastVelX) - Math.atan2(l, k));
                if(f2 > 5.654867F || f2 < 0.6283185F) {
                    k = (int)((float)k + (f * mLastVelX) / mLastVelocity);
                    l = (int)((float)l + (f * mLastVelY) / mLastVelocity);
                    f1 = (float)Math.hypot(k, l);
                }
            }
            if((i1 == 0 || i1 == i) && Math.abs(k) < Math.abs(l))
                k = 0;
            if((j1 == 0 || j1 == j) && Math.abs(l) < Math.abs(k))
                l = 0;
            if(k1 < l1) {
                if(k > 0 && i1 == -k1 || k < 0 && i1 == i + k1)
                    k = 0;
                if(l > 0 && j1 == -k1 || l < 0 && j1 == j + k1)
                    l = 0;
            }
            mLastVelX = k;
            mLastVelY = l;
            mLastVelocity = f1;
            OverScroller overscroller = mScroller;
            int i2 = -k;
            int j2 = -l;
            int k2;
            if(i == 0)
                k2 = 0;
            else
                k2 = l1;
            overscroller.fling(i1, j1, i2, j2, 0, i, 0, j, k2, l1);
            invalidate();
        }
        continue; /* Loop/switch isn't completed */
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void doTrackball(long l, int i) {
        int j = (int)(mTrackballLastTime - mTrackballFirstTime);
        if(j == 0)
            j = 200;
        float f = (1000F * mTrackballRemainsX) / (float)j;
        float f1 = (1000F * mTrackballRemainsY) / (float)j;
        int k = getViewWidth();
        int i1 = getViewHeight();
        Math.max(Math.abs(f), Math.abs(f1));
        int j1 = mContentWidth - k;
        int k1 = mContentHeight - i1;
        if(j1 < 0)
            j1 = 0;
        if(k1 < 0)
            k1 = 0;
        float f2 = Math.abs(3F * mTrackballRemainsX);
        float f3 = Math.abs(3F * mTrackballRemainsY);
        int l1 = Math.max(0, (int)Math.max(f2, f3));
        int i2 = getScrollX();
        int j2 = getScrollY();
        if(l1 > 0) {
            byte byte0;
            if(f2 < f3) {
                if(mTrackballRemainsY < 0.0F)
                    byte0 = 19;
                else
                    byte0 = 20;
            } else
            if(mTrackballRemainsX < 0.0F)
                byte0 = 21;
            else
                byte0 = 22;
            l1 = Math.min(l1, 10);
            if(mNativeClass != 0) {
                for(int i3 = 0; i3 < l1; i3++)
                    letPageHandleNavKey(byte0, l, true, i);

                letPageHandleNavKey(byte0, l, false, i);
            }
            mTrackballRemainsY = 0.0F;
            mTrackballRemainsX = 0.0F;
        }
        if(l1 >= 5) {
            int k2 = scaleTrackballX(f, j1);
            int l2 = scaleTrackballY(f1, k1);
            if(Math.abs(getScrollX() - i2) > Math.abs(k2))
                k2 = 0;
            if(Math.abs(getScrollY() - j2) > Math.abs(l2))
                l2 = 0;
            if(k2 != 0 || l2 != 0)
                pinScrollBy(k2, l2, true, 0);
        }
    }

    private void drawContent(Canvas canvas) {
        if(!mDrawHistory) goto _L2; else goto _L1
_L1:
        canvas.scale(mZoomManager.getScale(), mZoomManager.getScale());
        canvas.drawPicture(mHistoryPicture);
_L4:
        return;
_L2:
        boolean flag1;
        boolean flag2;
        int j;
        if(mNativeClass == 0)
            continue; /* Loop/switch isn't completed */
        boolean flag = mZoomManager.isFixedLengthAnimationInProgress();
        int i;
        Rect rect;
        Rect rect1;
        int k;
        if((!mScroller.isFinished() || mVelocityTracker != null) && (mTouchMode != 3 || mHeldMotionless != 2))
            flag1 = true;
        else
            flag1 = false;
        if(mTouchMode == 3) {
            if(mHeldMotionless == 1) {
                mPrivateHandler.removeMessages(8);
                mHeldMotionless = 0;
            }
            if(mHeldMotionless == 0) {
                mPrivateHandler.sendMessageDelayed(mPrivateHandler.obtainMessage(8), 100L);
                mHeldMotionless = 1;
            }
        }
        i = canvas.save();
        if(flag)
            mZoomManager.animateZoom(canvas);
        else
        if(!canvas.isHardwareAccelerated())
            canvas.scale(mZoomManager.getScale(), mZoomManager.getScale());
        flag2 = false;
        if(mNativeClass != 0 && !canvas.isHardwareAccelerated() && nativeEvaluateLayersAnimations(mNativeClass)) {
            flag2 = true;
            mWebViewCore.sendMessage(196);
            invalidate();
        }
        j = 0;
        if(!mFindIsUp && mShowTextSelectionExtra)
            j = 1;
        calcOurContentVisibleRectF(mVisibleContentRect);
        if(!canvas.isHardwareAccelerated())
            break; /* Loop/switch isn't completed */
        if(mIsWebViewVisible)
            rect = mInvScreenRect;
        else
            rect = null;
        if(mIsWebViewVisible)
            rect1 = mScreenRect;
        else
            rect1 = null;
        k = nativeCreateDrawGLFunction(mNativeClass, rect, rect1, mVisibleContentRect, getScale(), j);
        ((HardwareCanvas)canvas).callDrawGLFunction(k);
        if(mHardwareAccelSkia != getSettings().getHardwareAccelSkiaEnabled()) {
            mHardwareAccelSkia = getSettings().getHardwareAccelSkiaEnabled();
            nativeUseHardwareAccelSkia(mHardwareAccelSkia);
        }
_L5:
        canvas.restoreToCount(i);
        drawTextSelectionHandles(canvas);
        if(j == 2 && mTouchMode == 4)
            mTouchMode = 5;
        if(true) goto _L4; else goto _L3
_L3:
        DrawFilter drawfilter = null;
        if(mZoomManager.isZoomAnimating() || flag2)
            drawfilter = mZoomFilter;
        else
        if(flag1)
            drawfilter = mScrollFilter;
        canvas.setDrawFilter(drawfilter);
        nativeDraw(canvas, mVisibleContentRect, mBackgroundColor, j);
        canvas.setDrawFilter(null);
          goto _L5
        if(true) goto _L4; else goto _L6
_L6:
    }

    private void drawOverScrollBackground(Canvas canvas) {
        if(mOverScrollBackground == null) {
            mOverScrollBackground = new Paint();
            Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), 0x1080561);
            mOverScrollBackground.setShader(new BitmapShader(bitmap, android.graphics.Shader.TileMode.REPEAT, android.graphics.Shader.TileMode.REPEAT));
            mOverScrollBorder = new Paint();
            mOverScrollBorder.setStyle(android.graphics.Paint.Style.STROKE);
            mOverScrollBorder.setStrokeWidth(0.0F);
            mOverScrollBorder.setColor(0xffbbbbbb);
        }
        int i = computeRealHorizontalScrollRange();
        int j = 0 + computeRealVerticalScrollRange();
        canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        canvas.clipRect(-getScrollX(), 0 - getScrollY(), i - getScrollX(), j - getScrollY(), android.graphics.Region.Op.DIFFERENCE);
        canvas.drawPaint(mOverScrollBackground);
        canvas.restore();
        canvas.drawRect(-1F, -1, i, j, mOverScrollBorder);
        canvas.clipRect(0, 0, i, j);
    }

    private void drawTextSelectionHandles(Canvas canvas) {
        if(mHandleAlpha.getAlpha() != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ensureSelectionHandles();
        Rect rect = new Rect(-1, -1, -1, -1);
        Rect rect1 = new Rect(-1, -1, -1, -1);
        if(mSelectingText) {
            int ai[] = new int[4];
            getSelectionHandles(ai);
            int i = contentToViewDimension(ai[0]);
            int j = contentToViewDimension(ai[1]);
            int k = contentToViewDimension(ai[2]);
            int l = contentToViewDimension(ai[3]);
            int i1;
            if(mIsCaretSelection) {
                i1 = i - mSelectHandleCenter.getIntrinsicWidth() / 2;
                mSelectHandleCenter.setBounds(i1, j, i1 + mSelectHandleCenter.getIntrinsicWidth(), j + mSelectHandleCenter.getIntrinsicHeight());
            } else {
                i1 = i - (3 * mSelectHandleLeft.getIntrinsicWidth()) / 4;
                mSelectHandleLeft.setBounds(i1, j, i1 + mSelectHandleLeft.getIntrinsicWidth(), j + mSelectHandleLeft.getIntrinsicHeight());
                k -= mSelectHandleRight.getIntrinsicWidth() / 4;
                mSelectHandleRight.setBounds(k, l, k + mSelectHandleRight.getIntrinsicWidth(), l + mSelectHandleRight.getIntrinsicHeight());
            }
            rect = new Rect(i1, j, i1 + 60, j + 60);
            rect1 = new Rect(k, l, k + 60, l + 60);
        }
        if(mIsCaretSelection) {
            mSelectHandleCenter.draw(canvas);
        } else {
            mSelectHandleLeft.draw(canvas);
            mSelectHandleRight.draw(canvas);
            if(mSelectingText)
                showMagnifier(canvas, rect, rect1);
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static void enablePlatformNotifications() {
        android/webkit/WebViewClassic;
        JVM INSTR monitorenter ;
        sNotificationsEnabled = true;
        Context context = JniUtil.getContext();
        if(context != null)
            setupProxyListener(context);
        return;
    }

    private void endScrollEdit() {
        mLastEditScroll = 0L;
    }

    private void endSelectingText() {
        mSelectingText = false;
        mShowTextSelectionExtra = false;
        ObjectAnimator objectanimator = mHandleAlphaAnimator;
        int ai[] = new int[1];
        ai[0] = 0;
        objectanimator.setIntValues(ai);
        mHandleAlphaAnimator.start();
    }

    private void ensureFunctorDetached() {
        if(mWebView.isHardwareAccelerated()) {
            int i = nativeGetDrawGLFunction(mNativeClass);
            ViewRootImpl viewrootimpl = mWebView.getViewRootImpl();
            if(i != 0 && viewrootimpl != null)
                viewrootimpl.detachFunctor(i);
        }
    }

    private void ensureSelectionHandles() {
        if(mSelectHandleCenter == null) {
            mSelectHandleCenter = mContext.getResources().getDrawable(0x10805bb).mutate();
            mSelectHandleLeft = mContext.getResources().getDrawable(0x10805ba).mutate();
            mSelectHandleRight = mContext.getResources().getDrawable(0x10805bc).mutate();
            mHandleAlpha.setAlpha(mHandleAlpha.getAlpha());
            mSelectHandleCenterOffset = new Point(0, -mSelectHandleCenter.getIntrinsicHeight());
            mSelectHandleLeftOffset = new Point(0, -mSelectHandleLeft.getIntrinsicHeight());
            mSelectHandleRightOffset = new Point(-mSelectHandleLeft.getIntrinsicWidth() / 2, -mSelectHandleRight.getIntrinsicHeight());
        }
    }

    private boolean extendScroll(int i) {
        boolean flag = false;
        int j = mScroller.getFinalY();
        int k = pinLocY(j + i);
        if(k != j) {
            mScroller.setFinalY(k);
            mScroller.extendDuration(computeDuration(0, i));
            flag = true;
        }
        return flag;
    }

    public static String findAddress(String s) {
        return findAddress(s, false);
    }

    public static String findAddress(String s, boolean flag) {
        return WebViewCore.nativeFindAddress(s, flag);
    }

    private int findAllBody(String s, boolean flag) {
        int i;
        i = 0;
        if(mNativeClass != 0) {
            mFindRequest = null;
            if(s != null) {
label0:
                {
                    mWebViewCore.removeMessages(221);
                    mFindRequest = new WebViewCore.FindAllRequest(s);
                    if(!flag)
                        break label0;
                    mWebViewCore.sendMessage(221, mFindRequest);
                }
            }
        }
_L1:
        return i;
        findallrequest;
        JVM INSTR monitorenter ;
        try {
            mWebViewCore.sendMessageAtFrontOfQueue(221, mFindRequest);
            while(mFindRequest.mMatchCount == -1) 
                mFindRequest.wait();
            break MISSING_BLOCK_LABEL_124;
        }
        catch(InterruptedException interruptedexception) { }
        finally {
            throw exception;
        }
          goto _L1
        i = mFindRequest.mMatchCount;
        findallrequest;
        JVM INSTR monitorexit ;
          goto _L1
    }

    public static WebViewClassic fromWebView(WebView webview) {
        WebViewClassic webviewclassic;
        if(webview == null)
            webviewclassic = null;
        else
            webviewclassic = (WebViewClassic)webview.getWebViewProvider();
        return webviewclassic;
    }

    private AccessibilityInjector getAccessibilityInjector() {
        if(mAccessibilityInjector == null)
            mAccessibilityInjector = new AccessibilityInjector(this);
        return mAccessibilityInjector;
    }

    private int getMaxTextScrollX() {
        return Math.max(0, mEditTextContent.width() - mEditTextContentBounds.width());
    }

    private int getMaxTextScrollY() {
        return Math.max(0, mEditTextContent.height() - mEditTextContentBounds.height());
    }

    private int getOverlappingActionModeHeight() {
        int i = 0;
        if(mFindCallback != null) {
            if(mCachedOverlappingActionModeHeight < 0) {
                mWebView.getGlobalVisibleRect(mGlobalVisibleRect, mGlobalVisibleOffset);
                mCachedOverlappingActionModeHeight = Math.max(0, mFindCallback.getActionModeGlobalBottom() - mGlobalVisibleRect.top);
            }
            i = mCachedOverlappingActionModeHeight;
        }
        return i;
    }

    /**
     * @deprecated Method getPluginList is deprecated
     */

    public static PluginList getPluginList() {
        android/webkit/WebViewClassic;
        JVM INSTR monitorenter ;
        PluginList pluginlist = new PluginList();
        android/webkit/WebViewClassic;
        JVM INSTR monitorexit ;
        return pluginlist;
        Exception exception;
        exception;
        throw exception;
    }

    private int getScaledMaxXScroll() {
        int i;
        if(!mHeightCanMeasure) {
            i = getViewWidth() / 4;
        } else {
            Rect rect = new Rect();
            calcOurVisibleRect(rect);
            i = rect.width() / 2;
        }
        return viewToContentX(i);
    }

    private int getScaledMaxYScroll() {
        int i;
        if(!mHeightCanMeasure) {
            i = getViewHeight() / 4;
        } else {
            Rect rect = new Rect();
            calcOurVisibleRect(rect);
            i = rect.height() / 2;
        }
        return Math.round((float)i * mZoomManager.getInvScale());
    }

    private void getSelectionHandles(int ai[]) {
        ai[0] = mSelectCursorLeft.x;
        ai[1] = mSelectCursorLeft.y;
        ai[2] = mSelectCursorRight.x;
        ai[3] = mSelectCursorRight.y;
    }

    private static int getTextScrollDelta(float f, long l) {
        float f1 = f * (float)l;
        int i = (int)Math.floor(f1);
        float f2 = f1 - (float)i;
        if(Math.random() < (double)f2)
            i++;
        return i;
    }

    private static float getTextScrollSpeed(int i, int j, int k) {
        float f;
        if(i < j)
            f = 0.01F * (float)(i - j);
        else
        if(i >= k)
            f = 0.01F * (float)(1 + (i - k));
        else
            f = 0.0F;
        return f;
    }

    private int getTextScrollX() {
        return -mEditTextContent.left;
    }

    private int getTextScrollY() {
        return -mEditTextContent.top;
    }

    private int getVisibleTitleHeightImpl() {
        return Math.max(getTitleHeight() - Math.max(0, getScrollY()), getOverlappingActionModeHeight());
    }

    private void goBackOrForward(int i, boolean flag) {
        if(i != 0) {
            clearHelpers();
            WebViewCore webviewcore = mWebViewCore;
            int j;
            if(flag)
                j = 1;
            else
                j = 0;
            webviewcore.sendMessage(106, i, j);
        }
    }

    private void goBackOrForwardImpl(int i) {
        goBackOrForward(i, false);
    }

    private static void handleCertTrustChanged() {
        WebViewCore.sendStaticMessage(220, null);
    }

    private static void handleProxyBroadcast(Intent intent) {
        ProxyProperties proxyproperties = (ProxyProperties)intent.getExtra("proxy");
        if(proxyproperties == null || proxyproperties.getHost() == null)
            WebViewCore.sendStaticMessage(193, null);
        else
            WebViewCore.sendStaticMessage(193, proxyproperties);
    }

    private void handleTouchEventCommon(MotionEvent motionevent, int i, int j, int k) {
        ScaleGestureDetector scalegesturedetector;
        long l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        scalegesturedetector = mZoomManager.getScaleGestureDetector();
        l = motionevent.getEventTime();
        i1 = Math.min(j, -1 + getViewWidth());
        j1 = Math.min(k, -1 + getViewHeightWithTitle());
        k1 = mLastTouchX - i1;
        l1 = mLastTouchY - j1;
        i2 = viewToContentX(i1 + getScrollX());
        j2 = viewToContentY(j1 + getScrollY());
        i;
        JVM INSTR tableswitch 0 3: default 116
    //                   0 117
    //                   1 1467
    //                   2 612
    //                   3 1834;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        mConfirmMove = false;
        if(!mEditTextScroller.isFinished())
            mEditTextScroller.abortAnimation();
        if(!mScroller.isFinished()) {
            mScroller.abortAnimation();
            mTouchMode = 2;
            mConfirmMove = true;
            nativeSetIsScrolling(false);
        } else
        if(mPrivateHandler.hasMessages(5)) {
            mPrivateHandler.removeMessages(5);
            removeTouchHighlight();
            if(k1 * k1 + l1 * l1 < mDoubleTapSlopSquare)
                mTouchMode = 6;
            else
                mTouchMode = 1;
        } else {
            mTouchMode = 1;
            if(mLogEvent && l - mLastTouchUpTime < 1000L) {
                Object aobj[] = new Object[2];
                aobj[0] = Long.valueOf(l - mLastTouchUpTime);
                aobj[1] = Long.valueOf(l);
                EventLog.writeEvent(0x111d6, aobj);
            }
            mSelectionStarted = false;
            if(mSelectingText) {
                ensureSelectionHandles();
                int k3 = (j1 - getTitleHeight()) + getScrollY();
                int l3 = i1 + getScrollX();
                if(mSelectHandleCenter != null && mSelectHandleCenter.getBounds().contains(l3, k3)) {
                    mSelectionStarted = true;
                    mSelectDraggingCursor = mSelectCursorLeft;
                    mSelectDraggingOffset = mSelectHandleCenterOffset;
                    mSelectDraggingTextQuad = mSelectCursorLeftTextQuad;
                    mPrivateHandler.removeMessages(144);
                    hidePasteButton();
                } else
                if(mSelectHandleLeft != null && mSelectHandleLeft.getBounds().contains(l3, k3)) {
                    mSelectionStarted = true;
                    mSelectDraggingOffset = mSelectHandleLeftOffset;
                    mSelectDraggingCursor = mSelectCursorLeft;
                    mSelectDraggingTextQuad = mSelectCursorLeftTextQuad;
                } else
                if(mSelectHandleRight != null && mSelectHandleRight.getBounds().contains(l3, k3)) {
                    mSelectionStarted = true;
                    mSelectDraggingOffset = mSelectHandleRightOffset;
                    mSelectDraggingCursor = mSelectCursorRight;
                    mSelectDraggingTextQuad = mSelectCursorRightTextQuad;
                } else
                if(mIsCaretSelection)
                    selectionDone();
            }
        }
        if(!mSelectingText && (mTouchMode == 1 || mTouchMode == 6)) {
            mPrivateHandler.sendEmptyMessageDelayed(3, 300L);
            mPrivateHandler.sendEmptyMessageDelayed(4, 1000L);
        }
        startTouch(i1, j1, l);
        if(mIsEditingText)
            mTouchInEditText = mEditTextContentBounds.contains(i2, j2);
        continue; /* Loop/switch isn't completed */
_L4:
        if(!mConfirmMove && k1 * k1 + l1 * l1 >= mTouchSlopSquare) {
            mPrivateHandler.removeMessages(3);
            mPrivateHandler.removeMessages(4);
            mConfirmMove = true;
            if(mTouchMode == 6)
                mTouchMode = 1;
            removeTouchHighlight();
        }
        if(mSelectingText && mSelectionStarted) {
            ViewParent viewparent = mWebView.getParent();
            if(viewparent != null)
                viewparent.requestDisallowInterceptTouchEvent(true);
            if(k1 != 0 || l1 != 0) {
                int i3 = i2 + viewToContentDimension(mSelectDraggingOffset.x);
                int j3 = j2 + viewToContentDimension(mSelectDraggingOffset.y);
                mSelectDraggingCursor.set(i3, j3);
                boolean flag4 = mSelectDraggingTextQuad.containsPoint(i3, j3);
                boolean flag5 = mEditTextContentBounds.contains(i3, j3);
                if(mIsEditingText && !flag5)
                    beginScrollEdit();
                else
                    endScrollEdit();
                if(flag4 || mIsEditingText && !flag5)
                    snapDraggingCursor();
                updateWebkitSelection();
                if(!flag4 && mIsEditingText && flag5)
                    snapDraggingCursor();
                mLastTouchX = i1;
                mLastTouchY = j1;
                invalidate();
            }
            continue; /* Loop/switch isn't completed */
        }
        if(mTouchMode == 7)
            continue; /* Loop/switch isn't completed */
        if(mVelocityTracker == null)
            Log.e("webview", (new StringBuilder()).append("Got null mVelocityTracker when  mTouchMode = ").append(mTouchMode).toString());
        else
            mVelocityTracker.addMovement(motionevent);
        if(mTouchMode == 3 || mTouchMode == 9 || mTouchMode == 10) goto _L7; else goto _L6
_L6:
        if(!mConfirmMove)
            continue; /* Loop/switch isn't completed */
        mAverageAngle = calculateDragAngle(k1, l1);
        if(scalegesturedetector != null && scalegesturedetector.isInProgress()) goto _L9; else goto _L8
_L8:
        if(mAverageAngle >= 0.25F) goto _L11; else goto _L10
_L10:
        mSnapScrollMode = 2;
        boolean flag3;
        if(k1 > 0)
            flag3 = true;
        else
            flag3 = false;
        mSnapPositive = flag3;
        mAverageAngle = 0.0F;
_L9:
        mTouchMode = 3;
        mLastTouchX = i1;
        mLastTouchY = j1;
        k1 = 0;
        l1 = 0;
        startScrollingLayer(i1, j1);
        startDrag();
_L7:
        if(k1 == 0 && l1 == 0)
            continue; /* Loop/switch isn't completed */
        break; /* Loop/switch isn't completed */
_L11:
        if(mAverageAngle > 1.25F) {
            mSnapScrollMode = 4;
            boolean flag2;
            if(l1 > 0)
                flag2 = true;
            else
                flag2 = false;
            mSnapPositive = flag2;
            mAverageAngle = 2.0F;
        }
        if(true) goto _L9; else goto _L12
_L12:
        mAverageAngle = mAverageAngle + (calculateDragAngle(k1, l1) - mAverageAngle) / 5F;
        if(mSnapScrollMode != 0) {
            if(mSnapScrollMode == 4 && mAverageAngle < 0.95F)
                mSnapScrollMode = 0;
            if(mSnapScrollMode == 2 && mAverageAngle > 0.4F)
                mSnapScrollMode = 0;
        } else
        if(mAverageAngle < 0.25F) {
            mSnapScrollMode = 2;
            boolean flag1;
            if(k1 > 0)
                flag1 = true;
            else
                flag1 = false;
            mSnapPositive = flag1;
            mAverageAngle = (0.0F + mAverageAngle) / 2.0F;
        } else
        if(mAverageAngle > 1.25F) {
            mSnapScrollMode = 4;
            boolean flag;
            if(l1 > 0)
                flag = true;
            else
                flag = false;
            mSnapPositive = flag;
            mAverageAngle = (2.0F + mAverageAngle) / 2.0F;
        }
        if(mSnapScrollMode != 0)
            if((2 & mSnapScrollMode) == 2)
                l1 = 0;
            else
                k1 = 0;
        if(k1 * k1 + l1 * l1 > mTouchSlopSquare)
            mHeldMotionless = 0;
        else
            mHeldMotionless = 2;
        mLastTouchTime = l;
        if(doDrag(k1, l1)) {
            mLastTouchX = i1;
            mLastTouchY = j1;
        } else {
            int k2 = contentToViewDimension((int)Math.floor((float)k1 * mZoomManager.getInvScale()));
            int l2 = contentToViewDimension((int)Math.floor((float)l1 * mZoomManager.getInvScale()));
            mLastTouchX = mLastTouchX - k2;
            mLastTouchY = mLastTouchY - l2;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        endScrollEdit();
        if(!mConfirmMove && mIsEditingText && mSelectionStarted && mIsCaretSelection) {
            showPasteWindow();
            stopTouch();
            continue; /* Loop/switch isn't completed */
        }
        mLastTouchUpTime = l;
        if(mSentAutoScrollMessage) {
            mAutoScrollY = 0;
            mAutoScrollX = 0;
        }
        mTouchMode;
        JVM INSTR tableswitch 1 10: default 1592
    //                   1 1624
    //                   2 1809
    //                   3 1706
    //                   4 1624
    //                   5 1624
    //                   6 1599
    //                   7 1592
    //                   8 1592
    //                   9 1706
    //                   10 1706;
           goto _L13 _L14 _L15 _L16 _L14 _L14 _L17 _L13 _L13 _L16 _L16
_L13:
        stopTouch();
        continue; /* Loop/switch isn't completed */
_L17:
        mPrivateHandler.removeMessages(3);
        mPrivateHandler.removeMessages(4);
        mTouchMode = 7;
          goto _L13
_L14:
        mPrivateHandler.removeMessages(3);
        mPrivateHandler.removeMessages(4);
        if(mConfirmMove) goto _L16; else goto _L18
_L18:
        if(mSelectingText) {
            if(!mSelectionStarted)
                selectionDone();
        } else
        if(mTouchMode == 1 && (canZoomIn() || canZoomOut()))
            mPrivateHandler.sendEmptyMessageDelayed(5, ViewConfiguration.getDoubleTapTimeout());
          goto _L13
_L16:
        mPrivateHandler.removeMessages(8);
        if(l - mLastTouchTime > 250L) goto _L20; else goto _L19
_L19:
        if(mVelocityTracker == null)
            Log.e("webview", "Got null mVelocityTracker");
        else
            mVelocityTracker.addMovement(motionevent);
        mHeldMotionless = 3;
        doFling();
          goto _L13
_L20:
        if(mScroller.springBack(getScrollX(), getScrollY(), 0, computeMaxScrollX(), 0, computeMaxScrollY()))
            invalidate();
        mHeldMotionless = 2;
        invalidate();
_L15:
        mLastVelocity = 0.0F;
        WebViewCore.resumePriority();
        if(!mSelectingText)
            WebViewCore.resumeUpdatePicture(mWebViewCore);
          goto _L13
_L5:
        if(mTouchMode == 3) {
            mScroller.springBack(getScrollX(), getScrollY(), 0, computeMaxScrollX(), 0, computeMaxScrollY());
            invalidate();
        }
        cancelTouch();
        if(true) goto _L1; else goto _L21
_L21:
    }

    private void hideFloatView() {
        if(mCopyFloatPanel != null)
            mCopyFloatPanel.setVisibility(4);
    }

    private void hidePasteButton() {
        if(mPasteWindow != null)
            mPasteWindow.hide();
    }

    private void hideSoftKeyboard() {
        InputMethodManager inputmethodmanager = InputMethodManager.peekInstance();
        if(inputmethodmanager != null && inputmethodmanager.isActive(mWebView))
            inputmethodmanager.hideSoftInputFromWindow(mWebView.getWindowToken(), 0);
    }

    private boolean inFullScreenMode() {
        boolean flag;
        if(mFullScreenHolder != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private void init() {
        OnTrimMemoryListener.init(mContext);
        mWebView.setWillNotDraw(false);
        mWebView.setClickable(true);
        mWebView.setLongClickable(true);
        ViewConfiguration viewconfiguration = ViewConfiguration.get(mContext);
        int i = viewconfiguration.getScaledTouchSlop();
        mTouchSlopSquare = i * i;
        int j = viewconfiguration.getScaledDoubleTapSlop();
        mDoubleTapSlopSquare = j * j;
        float f = mContext.getResources().getDisplayMetrics().density;
        mNavSlop = (int)(16F * f);
        mZoomManager.init(f);
        mMaximumFling = viewconfiguration.getScaledMaximumFlingVelocity();
        DRAG_LAYER_INVERSE_DENSITY_SQUARED = 1.0F / (f * f);
        mOverscrollDistance = viewconfiguration.getScaledOverscrollDistance();
        mOverflingDistance = viewconfiguration.getScaledOverflingDistance();
        setScrollBarStyle(mWebViewPrivate.super_getScrollBarStyle());
        mKeysPressed = new Vector(2);
        mHTML5VideoViewProxy = null;
    }

    private void invalidateContentRect(Rect rect) {
        viewInvalidate(rect.left, rect.top, rect.right, rect.bottom);
    }

    private boolean isAccessibilityEnabled() {
        return AccessibilityManager.getInstance(mContext).isEnabled();
    }

    private boolean isEnterActionKey(int i) {
        boolean flag;
        if(i == 23 || i == 66 || i == 160)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private boolean isScrollableForAccessibility() {
        boolean flag;
        if(contentToViewX(getContentWidth()) > getWidth() - mWebView.getPaddingLeft() - mWebView.getPaddingRight() || contentToViewY(getContentHeight()) > getHeight() - mWebView.getPaddingTop() - mWebView.getPaddingBottom())
            flag = true;
        else
            flag = false;
        return flag;
    }

    private int keyCodeToSoundsEffect(int i) {
        i;
        JVM INSTR tableswitch 19 22: default 32
    //                   19 36
    //                   20 46
    //                   21 51
    //                   22 41;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        int j = 0;
_L7:
        return j;
_L2:
        j = 2;
        continue; /* Loop/switch isn't completed */
_L5:
        j = 3;
        continue; /* Loop/switch isn't completed */
_L3:
        j = 4;
        continue; /* Loop/switch isn't completed */
_L4:
        j = 1;
        if(true) goto _L7; else goto _L6
_L6:
    }

    private void letPageHandleNavKey(int i, long l, boolean flag, int j) {
        int k;
        if(flag)
            k = 0;
        else
            k = 1;
        sendKeyEvent(new KeyEvent(l, l, k, i, 1, j & 1 | j & 2 | j & 4, -1, 0, 0));
    }

    private void loadDataImpl(String s, String s1, String s2) {
        StringBuilder stringbuilder = new StringBuilder("data:");
        stringbuilder.append(s1);
        if("base64".equals(s2))
            stringbuilder.append(";base64");
        stringbuilder.append(",");
        stringbuilder.append(s);
        loadUrlImpl(stringbuilder.toString());
    }

    private void loadUrlImpl(String s) {
        if(s != null)
            loadUrlImpl(s, null);
    }

    private void loadUrlImpl(String s, Map map) {
        switchOutDrawHistory();
        WebViewCore.GetUrlData geturldata = new WebViewCore.GetUrlData();
        geturldata.mUrl = s;
        geturldata.mExtraHeaders = map;
        mWebViewCore.sendMessage(100, geturldata);
        clearHelpers();
    }

    private native void nativeCopyBaseContentToPicture(Picture picture);

    private native void nativeCreate(int i, String s, boolean flag);

    private native int nativeCreateDrawGLFunction(int i, Rect rect, Rect rect1, RectF rectf, float f, int j);

    private native void nativeDebugDump();

    private static native void nativeDestroy(int i);

    private native void nativeDiscardAllTextures();

    private native void nativeDraw(Canvas canvas, RectF rectf, int i, int j);

    private native void nativeDumpDisplayTree(String s);

    private native boolean nativeEvaluateLayersAnimations(int i);

    private static native void nativeFindMaxVisibleRect(int i, int j, Rect rect);

    private native int nativeGetBackgroundColor(int i);

    private native int nativeGetBaseLayer(int i);

    private native int nativeGetDrawGLFunction(int i);

    private static native int nativeGetHandleLayerId(int i, int j, Point point, QuadF quadf);

    private native String nativeGetSelection();

    private native boolean nativeHasContent();

    private static native void nativeMapLayerRect(int i, int j, Rect rect);

    private static native void nativeOnTrimMemory(int i);

    private native boolean nativeScrollLayer(int i, int j, int k, int l);

    private native int nativeScrollableLayer(int i, int j, int k, Rect rect, Rect rect1);

    private native boolean nativeSetBaseLayer(int i, int j, boolean flag, boolean flag1, int k);

    private native void nativeSetHeightCanMeasure(boolean flag);

    private static native int nativeSetHwAccelerated(int i, boolean flag);

    private native void nativeSetIsScrolling(boolean flag);

    private static native void nativeSetPauseDrawing(int i, boolean flag);

    private static native void nativeSetTextSelection(int i, int j);

    private native void nativeStopGL(int i);

    private native void nativeTileProfilingClear();

    private native float nativeTileProfilingGetFloat(int i, int j, String s);

    private native int nativeTileProfilingGetInt(int i, int j, String s);

    private native int nativeTileProfilingNumFrames();

    private native int nativeTileProfilingNumTilesInFrame(int i);

    private native void nativeTileProfilingStart();

    private native float nativeTileProfilingStop();

    private native void nativeUpdateDrawGLFunction(int i, Rect rect, Rect rect1, RectF rectf, float f);

    private native void nativeUseHardwareAccelSkia(boolean flag);

    private void onHandleUiEvent(MotionEvent motionevent, int i, int j) {
        i;
        JVM INSTR tableswitch 0 5: default 40
    //                   0 77
    //                   1 40
    //                   2 40
    //                   3 41
    //                   4 85
    //                   5 59;
           goto _L1 _L2 _L1 _L1 _L3 _L4 _L5
_L1:
        return;
_L3:
        if(getHitTestResult() != null)
            mWebView.performLongClick();
        continue; /* Loop/switch isn't completed */
_L5:
        mZoomManager.handleDoubleTap(motionevent.getX(), motionevent.getY());
        continue; /* Loop/switch isn't completed */
_L2:
        onHandleUiTouchEvent(motionevent);
        continue; /* Loop/switch isn't completed */
_L4:
        if(mFocusedNode != null && mFocusedNode.mIntentUrl != null) {
            mWebView.playSoundEffect(0);
            overrideLoading(mFocusedNode.mIntentUrl);
        }
        if(true) goto _L1; else goto _L6
_L6:
    }

    private void onHandleUiTouchEvent(MotionEvent motionevent) {
        int i;
        float f2;
        float f3;
        ScaleGestureDetector scalegesturedetector = mZoomManager.getScaleGestureDetector();
        i = motionevent.getActionMasked();
        boolean flag;
        boolean flag1;
        int j;
        float f;
        float f1;
        int k;
        int l;
        if(i == 6)
            flag = true;
        else
            flag = false;
        if(i == 6 || i == 5)
            flag1 = true;
        else
            flag1 = false;
        if(flag)
            j = motionevent.getActionIndex();
        else
            j = -1;
        f = 0.0F;
        f1 = 0.0F;
        k = motionevent.getPointerCount();
        l = 0;
        while(l < k)  {
            if(j != l) {
                f += motionevent.getX(l);
                f1 += motionevent.getY(l);
            }
            l++;
        }
        int i1;
        if(flag)
            i1 = k - 1;
        else
            i1 = k;
        f2 = f / (float)i1;
        f3 = f1 / (float)i1;
        if(flag1) {
            mLastTouchX = Math.round(f2);
            mLastTouchY = Math.round(f3);
            mLastTouchTime = motionevent.getEventTime();
            mWebView.cancelLongPress();
            mPrivateHandler.removeMessages(4);
        }
        if(scalegesturedetector == null) goto _L2; else goto _L1
_L1:
        scalegesturedetector.onTouchEvent(motionevent);
        if(!scalegesturedetector.isInProgress()) goto _L2; else goto _L3
_L3:
        mLastTouchTime = motionevent.getEventTime();
        if(mZoomManager.supportsPanDuringZoom()) goto _L5; else goto _L4
_L4:
        return;
_L5:
        mTouchMode = 3;
        if(mVelocityTracker == null)
            mVelocityTracker = VelocityTracker.obtain();
_L2:
        if(i != 5)
            break; /* Loop/switch isn't completed */
        cancelTouch();
        i = 0;
_L8:
        handleTouchEventCommon(motionevent, i, Math.round(f2), Math.round(f3));
        if(true) goto _L7; else goto _L6
_L6:
        continue; /* Loop/switch isn't completed */
_L7:
        break; /* Loop/switch isn't completed */
        if(i != 2 || f2 >= 0.0F && f3 >= 0.0F) goto _L8; else goto _L4
    }

    private void onZoomAnimationEnd() {
        mPrivateHandler.sendEmptyMessage(146);
    }

    private void onZoomAnimationStart() {
        if(!mSelectingText && mHandleAlpha.getAlpha() > 0)
            mHandleAlphaAnimator.end();
    }

    private void overrideLoading(String s) {
        mCallbackProxy.uiOverrideUrlLoading(s);
    }

    static int pinLoc(int i, int j, int k) {
        if(k >= j) goto _L2; else goto _L1
_L1:
        i = 0;
_L4:
        return i;
_L2:
        if(i < 0)
            i = 0;
        else
        if(i + j > k)
            i = k - j;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private boolean pinScrollBy(int i, int j, boolean flag, int k) {
        return pinScrollTo(i + getScrollX(), j + getScrollY(), flag, k);
    }

    private boolean pinScrollTo(int i, int j, boolean flag, int k) {
        abortAnimation();
        int l = pinLocX(i);
        int i1 = pinLocY(j);
        int j1 = l - getScrollX();
        int k1 = i1 - getScrollY();
        boolean flag1;
        if((j1 | k1) == 0) {
            flag1 = false;
        } else {
            if(flag) {
                OverScroller overscroller = mScroller;
                int l1 = getScrollX();
                int i2 = getScrollY();
                int j2;
                if(k > 0)
                    j2 = k;
                else
                    j2 = computeDuration(j1, k1);
                overscroller.startScroll(l1, i2, j1, k1, j2);
                invalidate();
            } else {
                mWebView.scrollTo(l, i1);
            }
            flag1 = true;
        }
        return flag1;
    }

    private void postInvalidate() {
        mWebView.postInvalidate();
    }

    private void recordNewContentSize(int i, int j, boolean flag) {
        if((i | j) == 0) {
            invalidate();
        } else {
            if(mContentWidth != i || mContentHeight != j) {
                mContentWidth = i;
                mContentHeight = j;
                if(!mDrawHistory) {
                    updateScrollCoordinates(pinLocX(getScrollX()), pinLocY(getScrollY()));
                    if(!mScroller.isFinished()) {
                        mScroller.setFinalX(pinLocX(mScroller.getFinalX()));
                        mScroller.setFinalY(pinLocY(mScroller.getFinalY()));
                    }
                }
                invalidate();
            }
            contentSizeChanged(flag);
        }
    }

    private void relocateAutoCompletePopup() {
        if(mAutoCompletePopup != null) {
            mAutoCompletePopup.resetRect();
            mAutoCompletePopup.setText(mInputConnection.getEditable());
        }
    }

    private void removeTouchHighlight() {
        setTouchHighlightRects(null);
    }

    private void resetCaretTimer() {
        mPrivateHandler.removeMessages(144);
        if(!mSelectionStarted)
            mPrivateHandler.sendEmptyMessageDelayed(144, 3000L);
    }

    private void restoreHistoryPictureFields(Picture picture, Bundle bundle) {
        int i = bundle.getInt("scrollX", 0);
        int j = bundle.getInt("scrollY", 0);
        mDrawHistory = true;
        mHistoryPicture = picture;
        setScrollXRaw(i);
        setScrollYRaw(j);
        mZoomManager.restoreZoomState(bundle);
        float f = mZoomManager.getScale();
        mHistoryWidth = Math.round(f * (float)picture.getWidth());
        mHistoryHeight = Math.round(f * (float)picture.getHeight());
        invalidate();
    }

    private void saveWebArchiveImpl(String s, boolean flag, ValueCallback valuecallback) {
        mWebViewCore.sendMessage(147, new SaveWebArchiveMessage(s, flag, valuecallback));
    }

    private static float scaleAlongSegment(int i, int j, PointF pointf, PointF pointf1) {
        float f = pointf1.x - pointf.x;
        float f1 = pointf1.y - pointf.y;
        float f2 = f * f + f1 * f1;
        float f3 = (float)i - pointf.x;
        float f4 = (float)j - pointf.y;
        return (f3 * f + f4 * f1) / f2;
    }

    private static float scaleCoordinate(float f, float f1, float f2) {
        return f1 + f * (f2 - f1);
    }

    private int scaleTrackballX(float f, int i) {
        int j;
        int k;
        j = (int)((f / 400F) * (float)i);
        k = j;
        if(j <= 0) goto _L2; else goto _L1
_L1:
        if(j > mTrackballXMove)
            j -= mTrackballXMove;
_L4:
        mTrackballXMove = k;
        return j;
_L2:
        if(j < mTrackballXMove)
            j -= mTrackballXMove;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private int scaleTrackballY(float f, int i) {
        int j;
        int k;
        j = (int)((f / 400F) * (float)i);
        k = j;
        if(j <= 0) goto _L2; else goto _L1
_L1:
        if(j > mTrackballYMove)
            j -= mTrackballYMove;
_L4:
        mTrackballYMove = k;
        return j;
_L2:
        if(j < mTrackballYMove)
            j -= mTrackballYMove;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void scrollEditIntoView() {
        Rect rect = new Rect(viewToContentX(getScrollX()), viewToContentY(getScrollY()), viewToContentX(getScrollX() + getWidth()), viewToContentY(getScrollY() + getViewHeightWithTitle()));
        if(!rect.contains(mEditTextContentBounds)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Rect rect1;
        int k;
        syncSelectionCursors();
        nativeFindMaxVisibleRect(mNativeClass, mEditTextLayerId, rect);
        int i = Math.max(1, viewToContentDimension(10));
        rect1 = new Rect(Math.max(0, mEditTextContentBounds.left - i), Math.max(0, mEditTextContentBounds.top - i), i + mEditTextContentBounds.right, i + mEditTextContentBounds.bottom);
        Point point = calculateCaretTop();
        int j;
        if(rect.width() < mEditTextContentBounds.width())
            if(mSelectCursorLeft.x < point.x) {
                rect1.left = Math.max(0, mSelectCursorLeft.x - i);
                rect1.right = i + point.x;
            } else {
                rect1.left = Math.max(0, point.x - i);
                rect1.right = i + mSelectCursorLeft.x;
            }
        if(rect.height() < mEditTextContentBounds.height())
            if(mSelectCursorLeft.y > point.y) {
                rect1.top = Math.max(0, point.y - i);
                rect1.bottom = i + mSelectCursorLeft.y;
            } else {
                rect1.top = Math.max(0, mSelectCursorLeft.y - i);
                rect1.bottom = i + point.y;
            }
        if(rect.contains(rect1))
            continue; /* Loop/switch isn't completed */
        j = viewToContentX(getScrollX());
        if(rect.left > rect1.left)
            j += rect1.left - rect.left;
        else
        if(rect.right < rect1.right)
            j += rect1.right - rect.right;
        k = viewToContentY(getScrollY());
        if(rect.top <= rect1.top)
            break; /* Loop/switch isn't completed */
        k += rect1.top - rect.top;
_L5:
        contentScrollTo(j, k, false);
        if(true) goto _L1; else goto _L3
_L3:
        if(rect.bottom >= rect1.bottom) goto _L5; else goto _L4
_L4:
        k += rect1.bottom - rect.bottom;
          goto _L5
    }

    private void scrollEditText(int i, int j) {
        float f = getMaxTextScrollX();
        float f1 = (float)i / f;
        mEditTextContent.offsetTo(-i, -j);
        mWebViewCore.sendMessageAtFrontOfQueue(99, 0, j, Float.valueOf(f1));
    }

    private void scrollEditWithCursor() {
        if(mLastEditScroll != 0L) {
            int i = viewToContentX(mLastTouchX + getScrollX() + mSelectDraggingOffset.x);
            float f = getTextScrollSpeed(i, mEditTextContentBounds.left, mEditTextContentBounds.right);
            int j = viewToContentY(mLastTouchY + getScrollY() + mSelectDraggingOffset.y);
            float f1 = getTextScrollSpeed(j, mEditTextContentBounds.top, mEditTextContentBounds.bottom);
            if(f == 0.0F && f1 == 0.0F) {
                endScrollEdit();
            } else {
                long l = SystemClock.uptimeMillis();
                long l1 = l - mLastEditScroll;
                int k = getTextScrollDelta(f, l1);
                int i1 = getTextScrollDelta(f1, l1);
                mLastEditScroll = l;
                if(k == 0 && i1 == 0) {
                    mPrivateHandler.sendEmptyMessageDelayed(149, 16L);
                } else {
                    int j1 = k + getTextScrollX();
                    int k1 = Math.max(0, Math.min(getMaxTextScrollX(), j1));
                    int i2 = i1 + getTextScrollY();
                    scrollEditText(k1, Math.max(0, Math.min(getMaxTextScrollY(), i2)));
                    int j2 = mSelectDraggingCursor.x;
                    int k2 = mSelectDraggingCursor.y;
                    mSelectDraggingCursor.set(i - k, j - i1);
                    updateWebkitSelection();
                    mSelectDraggingCursor.set(j2, k2);
                }
            }
        }
    }

    private void scrollLayerTo(int i, int j) {
        int k;
        int l;
        k = mScrollingLayerRect.left - i;
        l = mScrollingLayerRect.top - j;
        if((k != 0 || l != 0) && mNativeClass != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(!mSelectingText)
            break; /* Loop/switch isn't completed */
        if(mSelectCursorLeftLayerId == mCurrentScrollingLayerId) {
            mSelectCursorLeft.offset(k, l);
            mSelectCursorLeftTextQuad.offset(k, l);
        }
        if(mSelectCursorRightLayerId == mCurrentScrollingLayerId) {
            mSelectCursorRight.offset(k, l);
            mSelectCursorRightTextQuad.offset(k, l);
        }
_L5:
        if(mAutoCompletePopup != null && mCurrentScrollingLayerId == mEditTextLayerId) {
            mEditTextContentBounds.offset(k, l);
            mAutoCompletePopup.resetRect();
        }
        nativeScrollLayer(mNativeClass, mCurrentScrollingLayerId, i, j);
        mScrollingLayerRect.left = i;
        mScrollingLayerRect.top = j;
        mWebViewCore.sendMessage(198, mCurrentScrollingLayerId, mScrollingLayerRect);
        mWebViewPrivate.onScrollChanged(getScrollX(), getScrollY(), getScrollX(), getScrollY());
        invalidate();
        if(true) goto _L1; else goto _L3
_L3:
        if(mHandleAlpha.getAlpha() <= 0) goto _L5; else goto _L4
_L4:
        mHandleAlphaAnimator.end();
          goto _L5
    }

    private void sendKeyEvent(KeyEvent keyevent) {
        int i = 0;
        keyevent.getKeyCode();
        JVM INSTR lookupswitch 5: default 56
    //                   19: 126
    //                   20: 119
    //                   21: 132
    //                   22: 138
    //                   61: 144;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        if(i != 0 && mWebView.focusSearch(i) == null)
            i = 0;
        byte byte0 = 104;
        if(keyevent.getAction() == 0) {
            byte0 = 103;
            int j = keyCodeToSoundsEffect(keyevent.getKeyCode());
            if(j != 0)
                mWebView.playSoundEffect(j);
        }
        sendBatchableInputMessage(byte0, i, 0, keyevent);
        return;
_L3:
        i = 130;
        continue; /* Loop/switch isn't completed */
_L2:
        i = 33;
        continue; /* Loop/switch isn't completed */
_L4:
        i = 17;
        continue; /* Loop/switch isn't completed */
_L5:
        i = 66;
        continue; /* Loop/switch isn't completed */
_L6:
        if(keyevent.isShiftPressed())
            i = 1;
        else
            i = 2;
        if(true) goto _L1; else goto _L7
_L7:
    }

    private boolean setContentScrollBy(int i, int j, boolean flag) {
        boolean flag1 = false;
        if(!mDrawHistory) goto _L2; else goto _L1
_L1:
        return flag1;
_L2:
        int k = contentToViewDimension(i);
        int l = contentToViewDimension(j);
        if(mHeightCanMeasure) {
            if(l != 0) {
                Rect rect = new Rect();
                calcOurVisibleRect(rect);
                rect.offset(k, l);
                mWebView.requestRectangleOnScreen(rect);
            }
            if(l == 0 && k != 0 && pinScrollBy(k, 0, flag, 0))
                flag1 = true;
        } else {
            flag1 = pinScrollBy(k, l, flag, 0);
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void setFindIsUp(boolean flag) {
        mFindIsUp = flag;
    }

    private void setHitTestResult(WebViewCore.WebKitHitTest webkithittest) {
        if(webkithittest != null) goto _L2; else goto _L1
_L1:
        mInitialHitTestResult = null;
_L4:
        return;
_L2:
        mInitialHitTestResult = new WebView.HitTestResult();
        if(webkithittest.mLinkUrl != null) {
            setHitTestTypeFromUrl(webkithittest.mLinkUrl);
            if(webkithittest.mImageUrl != null && mInitialHitTestResult.getType() == 7) {
                mInitialHitTestResult.setType(8);
                mInitialHitTestResult.setExtra(webkithittest.mImageUrl);
            }
        } else
        if(webkithittest.mImageUrl != null) {
            mInitialHitTestResult.setType(5);
            mInitialHitTestResult.setExtra(webkithittest.mImageUrl);
        } else
        if(webkithittest.mEditable)
            mInitialHitTestResult.setType(9);
        else
        if(webkithittest.mIntentUrl != null)
            setHitTestTypeFromUrl(webkithittest.mIntentUrl);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void setHitTestTypeFromUrl(String s) {
        String s1;
        if(s.startsWith("geo:0,0?q=")) {
            mInitialHitTestResult.setType(3);
            s1 = s.substring("geo:0,0?q=".length());
        } else
        if(s.startsWith("tel:")) {
            mInitialHitTestResult.setType(2);
            s1 = s.substring("tel:".length());
        } else {
label0:
            {
                if(!s.startsWith("mailto:"))
                    break label0;
                mInitialHitTestResult.setType(4);
                s1 = s.substring("mailto:".length());
            }
        }
        mInitialHitTestResult.setExtra(URLDecoder.decode(s1, "UTF-8"));
_L1:
        return;
        mInitialHitTestResult.setType(7);
        mInitialHitTestResult.setExtra(s);
          goto _L1
        Throwable throwable;
        throwable;
        Log.w("webview", (new StringBuilder()).append("Failed to decode URL! ").append(s1).toString(), throwable);
        mInitialHitTestResult.setType(0);
          goto _L1
    }

    public static void setShouldMonitorWebCoreThread() {
        WebViewCore.setShouldMonitorWebCoreThread();
    }

    private void setTouchHighlightRects(WebViewCore.WebKitHitTest webkithittest) {
        FocusTransitionDrawable focustransitiondrawable = null;
        if(shouldAnimateTo(webkithittest))
            focustransitiondrawable = new FocusTransitionDrawable(this);
        Rect arect[];
        if(webkithittest != null)
            arect = webkithittest.mTouchRects;
        else
            arect = null;
        if(!mTouchHighlightRegion.isEmpty()) {
            mWebView.invalidate(mTouchHighlightRegion.getBounds());
            if(focustransitiondrawable != null)
                focustransitiondrawable.mPreviousRegion = new Region(mTouchHighlightRegion);
            mTouchHighlightRegion.setEmpty();
        }
        if(arect != null) {
            mTouchHightlightPaint.setColor(webkithittest.mTapHighlightColor);
            Rect arect1[] = arect;
            int i = arect1.length;
            for(int j = 0; j < i; j++) {
                Rect rect = contentToViewRect(arect1[j]);
                if(rect.width() < getWidth() >> 1 || rect.height() < getHeight() >> 1)
                    mTouchHighlightRegion.union(rect);
            }

            mWebView.invalidate(mTouchHighlightRegion.getBounds());
            if(focustransitiondrawable != null && focustransitiondrawable.mPreviousRegion != null) {
                focustransitiondrawable.mNewRegion = new Region(mTouchHighlightRegion);
                mFocusTransition = focustransitiondrawable;
                FocusTransitionDrawable focustransitiondrawable1 = mFocusTransition;
                float af[] = new float[1];
                af[0] = 1.0F;
                ObjectAnimator.ofFloat(focustransitiondrawable1, "progress", af).start();
            }
        }
    }

    private void setupPackageListener(Context context) {
        android/webkit/WebViewClassic;
        JVM INSTR monitorenter ;
        if(!sPackageInstallationReceiverAdded)
            break MISSING_BLOCK_LABEL_15;
        android/webkit/WebViewClassic;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_93;
        IntentFilter intentfilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentfilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentfilter.addDataScheme("package");
        PackageListener packagelistener = new PackageListener();
        context.getApplicationContext().registerReceiver(packagelistener, intentfilter);
        sPackageInstallationReceiverAdded = true;
        android/webkit/WebViewClassic;
        JVM INSTR monitorexit ;
        (new AsyncTask() {

            protected volatile Object doInBackground(Object aobj[]) {
                return doInBackground((Void[])aobj);
            }

            protected transient Set doInBackground(Void avoid[]) {
                HashSet hashset = new HashSet();
                PackageManager packagemanager = mContext.getPackageManager();
                for(Iterator iterator = WebViewClassic.sGoogleApps.iterator(); iterator.hasNext();) {
                    String s = (String)iterator.next();
                    try {
                        packagemanager.getPackageInfo(s, 5);
                        hashset.add(s);
                    }
                    catch(android.content.pm.PackageManager.NameNotFoundException namenotfoundexception) { }
                }

                return hashset;
            }

            protected volatile void onPostExecute(Object obj) {
                onPostExecute((Set)obj);
            }

            protected void onPostExecute(Set set) {
                if(mWebViewCore != null)
                    mWebViewCore.sendMessage(184, set);
            }

            final WebViewClassic this$0;

             {
                this$0 = WebViewClassic.this;
                super();
            }
        }).execute(new Void[0]);
        break MISSING_BLOCK_LABEL_93;
        Exception exception;
        exception;
        android/webkit/WebViewClassic;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method setupProxyListener is deprecated
     */

    private static void setupProxyListener(Context context) {
        android/webkit/WebViewClassic;
        JVM INSTR monitorenter ;
        if(sProxyReceiver != null) goto _L2; else goto _L1
_L1:
        boolean flag = sNotificationsEnabled;
        if(flag) goto _L3; else goto _L2
_L2:
        android/webkit/WebViewClassic;
        JVM INSTR monitorexit ;
        return;
_L3:
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.intent.action.PROXY_CHANGE");
        sProxyReceiver = new ProxyReceiver();
        Intent intent = context.getApplicationContext().registerReceiver(sProxyReceiver, intentfilter);
        if(intent != null)
            handleProxyBroadcast(intent);
        if(true) goto _L2; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    private static void setupTrustStorageListener(Context context) {
        if(sTrustStorageListener == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.security.STORAGE_CHANGED");
        sTrustStorageListener = new TrustStorageListener();
        if(context.getApplicationContext().registerReceiver(sTrustStorageListener, intentfilter) != null)
            handleCertTrustChanged();
        if(true) goto _L1; else goto _L3
_L3:
    }

    private boolean setupWebkitSelect() {
        syncSelectionCursors();
        boolean flag;
        if(!mIsCaretSelection && !startSelectActionMode()) {
            selectionDone();
            flag = false;
        } else {
            startSelectingText();
            mTouchMode = 3;
            flag = true;
        }
        return flag;
    }

    private boolean shouldAnimateTo(WebViewCore.WebKitHitTest webkithittest) {
        return false;
    }

    private boolean shouldDrawHighlightRect() {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        while(true)  {
            do
                return flag;
            while(mFocusedNode == null || mInitialHitTestResult == null || mTouchHighlightRegion.isEmpty());
            if(mFocusedNode.mHasFocus && !mWebView.isInTouchMode()) {
                if(mDrawCursorRing && !mFocusedNode.mEditable)
                    flag = true;
            } else
            if(!mFocusedNode.mHasFocus || !mFocusedNode.mEditable)
                flag = mShowTapHighlight;
        }
    }

    private void showFloatView() {
        if(mCopyFloatPanel == null)
            mCopyFloatPanel = SelectionFloatPanel.getInstance(mContext, this);
        if(mMenuLeft == -1) {
            int ai[] = new int[4];
            getSelectionHandles(ai);
            int i = contentToViewDimension(ai[0]);
            int j = contentToViewDimension(ai[1]);
            int k = contentToViewDimension(ai[2]);
            int l = contentToViewDimension(ai[3]);
            mMenuLeft = (i + k) / 2;
            if(j >= l)
                j = l;
            mMenuTop = j - 30;
        }
        mCopyFloatPanel.showAt(mMenuLeft, mMenuTop);
    }

    private void showMagnifier(Canvas canvas, Rect rect, Rect rect1) {
        int k3;
        int i4;
        getSelectionHandles(new int[5]);
        boolean flag;
        Rect rect3;
        float f;
        int j1;
        Paint paint;
        Paint paint1;
        int l2;
        String s;
        int i3;
        int j3;
        float f1;
        float f2;
        int l3;
        float f3;
        float f4;
        int j4;
        int k4;
        int l4;
        int i5;
        if(mSelectDraggingCursor == mSelectCursorLeft)
            flag = true;
        else
            flag = false;
        if(mIsActionUp || !mSelectingText || mBeforeStart == null && mAfterStart == null) goto _L2; else goto _L1
_L1:
        Rect rect2 = new Rect();
        if(mSelectMagnifier == null)
            mSelectMagnifier = mContext.getResources().getDrawable(0x6020026);
        rect3 = new Rect();
        mSelectMagnifier.getPadding(rect3);
        f = mContext.getResources().getDisplayMetrics().density / 1.5F;
        int i = (int)(f * (float)mSelectMagnifier.getIntrinsicHeight());
        int j = (int)(f * (float)(mSelectMagnifier.getIntrinsicWidth() / 2));
        int k = (int)(20F * f);
        int l;
        int i1;
        int k1;
        Rect rect4;
        if(flag) {
            rect2.left = rect.left - j;
            rect2.top = rect.top - i - k;
            rect2.right = j + rect.left;
            rect2.bottom = rect.top - k;
        } else {
            rect2.left = rect1.right - j;
            rect2.top = rect1.top - i - k;
            rect2.right = j + rect1.right;
            rect2.bottom = rect1.top - k;
        }
        mMenuLeft = (rect.left + rect1.left) / 2;
        mMenuTop = rect.top;
        mSelectMagnifier.setBounds(rect2.left, rect2.top, rect2.left + j * 2, i + rect2.top);
        mSelectMagnifier.draw(canvas);
        if(mSelectHighlight == null)
            mSelectHighlight = mContext.getResources().getDrawable(0x6020025);
        l = (int)(f * (float)rect3.left);
        i1 = (int)(f * (float)rect3.top);
        j1 = (int)(f * (float)rect3.right);
        k1 = (int)(f * (float)rect3.bottom);
        mSelectHighlight.setBounds(l + rect2.left, i1 + rect2.top, (j + rect2.left) - j1, (i + rect2.top) - k1);
        mSelectHighlight.draw(canvas);
        paint = new Paint();
        paint.setColor(0x6633b5e5);
        if(flag) {
            j4 = j + rect2.left;
            k4 = i1 + rect2.top;
            l4 = rect2.right - j1;
            i5 = rect2.bottom - k1;
            rect4 = new Rect(j4, k4, l4, i5);
        } else {
            int l1 = l + rect2.left;
            int i2 = i1 + rect2.top;
            int j2 = j + rect2.left;
            int k2 = rect2.bottom - k1;
            rect4 = new Rect(l1, i2, j2, k2);
        }
        canvas.drawRect(rect4, paint);
        canvas.clipRect(l + rect2.left, i1 + rect2.top, rect2.right - j1, rect2.bottom - k1);
        paint1 = new Paint();
        paint1.setStyle(android.graphics.Paint.Style.STROKE);
        paint1.setStrokeWidth(0.0F);
        paint1.setColor(0xff000000);
        paint1.setTextSize(f * (3F * paint.getTextSize()));
        l2 = 0;
        s = " ";
        if(mBeforeStart == null) goto _L4; else goto _L3
_L3:
        l3 = mBeforeStart.length();
        i4 = 0;
_L9:
        if(i4 >= l3) goto _L6; else goto _L5
_L5:
        s = mBeforeStart.substring(-1 + (l3 - i4));
        l2 = (int)paint1.measureText(s);
        if(l2 <= j * 2) goto _L7; else goto _L6
_L6:
        f3 = -2 + ((j + rect2.left) - l2);
        f4 = (float)(rect2.bottom - k1 - k / 2) + paint1.descent() / 2.0F;
        canvas.drawText(s, f3, f4, paint1);
_L4:
        if(mAfterStart == null) goto _L2; else goto _L8
_L8:
        i3 = mAfterStart.length();
        j3 = j * 2;
        k3 = 0;
_L10:
        if(k3 < i3) {
            s = mAfterStart.substring(0, k3 + 1);
            if((int)paint1.measureText(s) <= j3)
                break MISSING_BLOCK_LABEL_935;
        }
        f1 = 2 + (j + rect2.left);
        f2 = (float)(rect2.bottom - k1 - k / 2) + paint1.descent() / 2.0F;
        canvas.drawText(s, f1, f2, paint1);
_L2:
        return;
_L7:
        i4++;
          goto _L9
        k3++;
          goto _L10
    }

    private void showPasteWindow() {
        if(((ClipboardManager)(ClipboardManager)mContext.getSystemService("clipboard")).hasPrimaryClip()) {
            Point point = new Point(contentToViewX(mSelectCursorLeft.x), contentToViewY(mSelectCursorLeft.y));
            Point point1 = calculateCaretTop();
            point1.set(contentToViewX(point1.x), contentToViewY(point1.y));
            int ai[] = new int[2];
            mWebView.getLocationInWindow(ai);
            int i = ai[0] - getScrollX();
            int j = ai[1] - getScrollY();
            point.offset(i, j);
            point1.offset(i, j);
            if(mPasteWindow == null)
                mPasteWindow = new PastePopupWindow();
            mPasteWindow.show(point, point1, ai[0], ai[1]);
        }
    }

    private void snapDraggingCursor() {
        float f = Math.min(Math.max(0.0F, scaleAlongSegment(mSelectDraggingCursor.x, mSelectDraggingCursor.y, mSelectDraggingTextQuad.p4, mSelectDraggingTextQuad.p3)), 1.0F);
        float f1 = scaleCoordinate(f, mSelectDraggingTextQuad.p4.x, mSelectDraggingTextQuad.p3.x);
        float f2 = scaleCoordinate(f, mSelectDraggingTextQuad.p4.y, mSelectDraggingTextQuad.p3.y);
        int i = Math.round(f1);
        int j = Math.round(f2);
        if(mIsEditingText) {
            i = Math.max(mEditTextContentBounds.left, Math.min(mEditTextContentBounds.right, i));
            j = Math.max(mEditTextContentBounds.top, Math.min(mEditTextContentBounds.bottom, j));
        }
        mSelectDraggingCursor.set(i, j);
    }

    private void startDrag() {
        WebViewCore.reducePriority();
        WebViewCore.pauseUpdatePicture(mWebViewCore);
        nativeSetIsScrolling(true);
        if(mHorizontalScrollBarMode != 1 || mVerticalScrollBarMode != 1)
            mZoomManager.invokeZoomPicker();
    }

    private void startPrivateBrowsing() {
        getSettings().setPrivateBrowsingEnabled(true);
    }

    private void startScrollingLayer(float f, float f1) {
        if(mNativeClass != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i = viewToContentX((int)f + getScrollX());
        int j = viewToContentY((int)f1 + getScrollY());
        mCurrentScrollingLayerId = nativeScrollableLayer(mNativeClass, i, j, mScrollingLayerRect, mScrollingLayerBounds);
        if(mCurrentScrollingLayerId != 0)
            mTouchMode = 9;
        if(true) goto _L1; else goto _L3
_L3:
    }

    private boolean startSelectActionMode() {
        mWebView.performHapticFeedback(0);
        return true;
    }

    private void startSelectingText() {
        mSelectingText = true;
        mShowTextSelectionExtra = true;
        ObjectAnimator objectanimator = mHandleAlphaAnimator;
        int ai[] = new int[1];
        ai[0] = 255;
        objectanimator.setIntValues(ai);
        mHandleAlphaAnimator.start();
    }

    private void startTouch(float f, float f1, long l) {
        int i = Math.round(f);
        mLastTouchX = i;
        mStartTouchX = i;
        int j = Math.round(f1);
        mLastTouchY = j;
        mStartTouchY = j;
        mLastTouchTime = l;
        mVelocityTracker = VelocityTracker.obtain();
        mSnapScrollMode = 0;
    }

    private void stopTouch() {
        if(mScroller.isFinished() && !mSelectingText && (mTouchMode == 3 || mTouchMode == 9)) {
            WebViewCore.resumePriority();
            WebViewCore.resumeUpdatePicture(mWebViewCore);
            nativeSetIsScrolling(false);
        }
        if(mVelocityTracker != null) {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
        if(mOverScrollGlow != null)
            mOverScrollGlow.releaseAll();
        if(mSelectingText) {
            mSelectionStarted = false;
            syncSelectionCursors();
            if(mIsCaretSelection)
                resetCaretTimer();
            invalidate();
        }
    }

    private void syncSelectionCursors() {
        mSelectCursorLeftLayerId = nativeGetHandleLayerId(mNativeClass, 0, mSelectCursorLeft, mSelectCursorLeftTextQuad);
        mSelectCursorRightLayerId = nativeGetHandleLayerId(mNativeClass, 1, mSelectCursorRight, mSelectCursorRightTextQuad);
    }

    private void updateHwAccelerated() {
        if(mNativeClass != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        boolean flag = false;
        if(mWebView.isHardwareAccelerated() && mWebView.getLayerType() != 1)
            flag = true;
        int i = nativeSetHwAccelerated(mNativeClass, flag);
        if(mWebViewCore != null && !mBlockWebkitViewMessages && i != 0)
            mWebViewCore.contentDraw();
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void updateTextSelectionFromMessage(int i, int j, WebViewCore.TextSelectionData textselectiondata) {
        boolean flag = true;
        if(j == mTextGeneration && mInputConnection != null && mFieldPointer == i)
            mInputConnection.setSelection(textselectiondata.mStart, textselectiondata.mEnd);
        nativeSetTextSelection(mNativeClass, textselectiondata.mSelectTextPtr);
        if(textselectiondata.mSelectionReason == flag || !mSelectingText && textselectiondata.mStart != textselectiondata.mEnd && textselectiondata.mSelectionReason != 2) {
            selectionDone();
            mShowTextSelectionExtra = flag;
            invalidate();
        } else {
            if(textselectiondata.mSelectTextPtr != 0 && (textselectiondata.mStart != textselectiondata.mEnd || mFieldPointer == i && mFieldPointer != 0)) {
                if(textselectiondata.mStart != textselectiondata.mEnd)
                    flag = false;
                mIsCaretSelection = flag;
                if(mIsCaretSelection && (mInputConnection == null || mInputConnection.getEditable().length() == 0)) {
                    selectionDone();
                } else {
                    if(!mSelectingText)
                        setupWebkitSelect();
                    else
                    if(!mSelectionStarted)
                        syncSelectionCursors();
                    else
                        adjustSelectionCursors();
                    if(mIsCaretSelection)
                        resetCaretTimer();
                }
            } else {
                selectionDone();
            }
            invalidate();
        }
    }

    private void updateWebkitSelection() {
        int i = 0;
        int ai[] = null;
        if(mIsCaretSelection)
            mSelectCursorRight.set(mSelectCursorLeft.x, mSelectCursorLeft.y);
        if(mSelectingText) {
            ai = new int[5];
            getSelectionHandles(ai);
            if(mSelectDraggingCursor == mSelectCursorLeft)
                i = 1;
            ai[4] = i;
        } else {
            nativeSetTextSelection(mNativeClass, 0);
        }
        mWebViewCore.removeMessages(213);
        mWebViewCore.sendMessageAtFrontOfQueue(213, ai);
    }

    private void viewInvalidate() {
        invalidate();
    }

    private void viewInvalidate(int i, int j, int k, int l) {
        float f = mZoomManager.getScale();
        int i1 = getTitleHeight();
        mWebView.invalidate((int)Math.floor(f * (float)i), i1 + (int)Math.floor(f * (float)j), (int)Math.ceil(f * (float)k), i1 + (int)Math.ceil(f * (float)l));
    }

    private void viewInvalidateDelayed(long l, int i, int j, int k, int i1) {
        float f = mZoomManager.getScale();
        int j1 = getTitleHeight();
        mWebView.postInvalidateDelayed(l, (int)Math.floor(f * (float)i), j1 + (int)Math.floor(f * (float)j), (int)Math.ceil(f * (float)k), j1 + (int)Math.ceil(f * (float)i1));
    }

    private int viewToContentDimension(int i) {
        return Math.round((float)i * mZoomManager.getInvScale());
    }

    private void viewToContentVisibleRect(RectF rectf, Rect rect) {
        rectf.left = viewToContentXf(rect.left) / mWebView.getScaleX();
        rectf.top = viewToContentYf(rect.top + getVisibleTitleHeightImpl()) / mWebView.getScaleY();
        rectf.right = viewToContentXf(rect.right) / mWebView.getScaleX();
        rectf.bottom = viewToContentYf(rect.bottom) / mWebView.getScaleY();
    }

    private float viewToContentXf(int i) {
        return (float)i * mZoomManager.getInvScale();
    }

    private float viewToContentYf(int i) {
        return (float)(i - getTitleHeight()) * mZoomManager.getInvScale();
    }

    public void addJavascriptInterface(Object obj, String s) {
        if(obj != null) {
            WebViewCore.JSInterfaceData jsinterfacedata = new WebViewCore.JSInterfaceData();
            jsinterfacedata.mObject = obj;
            jsinterfacedata.mInterfaceName = s;
            mWebViewCore.sendMessage(138, jsinterfacedata);
        }
    }

    void adjustDefaultZoomDensity(int i) {
        updateDefaultZoomDensity((100F * mContext.getResources().getDisplayMetrics().density) / (float)i);
    }

    void autoFillForm(int i) {
        mPrivateHandler.obtainMessage(148, i, 0).sendToTarget();
    }

    public boolean canGoBack() {
        boolean flag = false;
        WebBackForwardList webbackforwardlist = mCallbackProxy.getBackForwardList();
        webbackforwardlist;
        JVM INSTR monitorenter ;
        if(!webbackforwardlist.getClearPending())
            if(webbackforwardlist.getCurrentIndex() > 0)
                flag = true;
        return flag;
    }

    public boolean canGoBackOrForward(int i) {
        boolean flag = false;
        WebBackForwardList webbackforwardlist = mCallbackProxy.getBackForwardList();
        webbackforwardlist;
        JVM INSTR monitorenter ;
        if(!webbackforwardlist.getClearPending()) {
            int j = i + webbackforwardlist.getCurrentIndex();
            if(j >= 0 && j < webbackforwardlist.getSize())
                flag = true;
        }
        return flag;
    }

    public boolean canGoForward() {
        boolean flag = false;
        WebBackForwardList webbackforwardlist = mCallbackProxy.getBackForwardList();
        webbackforwardlist;
        JVM INSTR monitorenter ;
        if(!webbackforwardlist.getClearPending())
            if(webbackforwardlist.getCurrentIndex() < -1 + webbackforwardlist.getSize())
                flag = true;
        return flag;
    }

    public boolean canZoomIn() {
        return mZoomManager.canZoomIn();
    }

    public boolean canZoomOut() {
        return mZoomManager.canZoomOut();
    }

    public Picture capturePicture() {
        Picture picture;
        if(mNativeClass == 0) {
            picture = null;
        } else {
            picture = new Picture();
            nativeCopyBaseContentToPicture(picture);
        }
        return picture;
    }

    void centerFitRect(Rect rect) {
        int i;
        int j;
        int k;
        int l;
        float f1;
        i = rect.width();
        j = rect.height();
        k = getViewWidth();
        l = getViewHeightWithTitle();
        float f = Math.min((float)k / (float)i, (float)l / (float)j);
        f1 = mZoomManager.computeScaleWithLimits(f);
        if(mZoomManager.willScaleTriggerZoom(f1)) goto _L2; else goto _L1
_L1:
        pinScrollTo(contentToViewX(rect.left + i / 2) - k / 2, contentToViewY(rect.top + j / 2) - l / 2, true, 0);
_L4:
        return;
_L2:
        float f10;
        float f11;
        float f12;
        float f13;
        float f2 = mZoomManager.getScale();
        float f3 = f2 * (float)rect.left - (float)getScrollX();
        float f4 = f1 * (float)rect.left;
        float f5 = f1 * (float)i;
        float f6 = f1 * (float)mContentWidth;
        float f7 = ((float)k - f5) / 2.0F;
        float f8;
        float f9;
        float f14;
        if(f7 > f4)
            f7 = f4;
        else
        if(f7 > f6 - f4 - f5)
            f7 = (float)k - (f6 - f4);
        f8 = (f3 * f1 - f7 * f2) / (f1 - f2);
        f9 = (f2 * (float)rect.top + (float)getTitleHeight()) - (float)getScrollY();
        f10 = f1 * (float)rect.top + (float)getTitleHeight();
        f11 = f1 * (float)j;
        f12 = f1 * (float)mContentHeight + (float)getTitleHeight();
        f13 = ((float)l - f11) / 2.0F;
        if(f13 <= f10)
            break; /* Loop/switch isn't completed */
        f13 = f10;
_L6:
        f14 = (f9 * f1 - f13 * f2) / (f1 - f2);
        mZoomManager.setZoomCenter(f8, f14);
        mZoomManager.startZoomAnimation(f1, false);
        if(true) goto _L4; else goto _L3
_L3:
        if(f13 <= f12 - f10 - f11) goto _L6; else goto _L5
_L5:
        f13 = (float)l - (f12 - f10);
          goto _L6
    }

    public void checkIfReadModeAvailable() {
        mWebViewCore.sendMessage(5010, 0);
    }

    public void checkIfReadModeAvailable(boolean flag) {
        WebViewCore webviewcore = mWebViewCore;
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        webviewcore.sendMessage(5010, i);
    }

    public void clearCache(boolean flag) {
        WebViewCore webviewcore = mWebViewCore;
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        webviewcore.sendMessage(111, i, 0);
    }

    public void clearFormData() {
        if(mAutoCompletePopup != null)
            mAutoCompletePopup.clearAdapter();
    }

    public void clearHistory() {
        mCallbackProxy.getBackForwardList().setClearPending();
        mWebViewCore.sendMessage(112);
    }

    public void clearMatches() {
        if(mNativeClass != 0) {
            mWebViewCore.removeMessages(221);
            mWebViewCore.sendMessage(221, null);
        }
    }

    public void clearSslPreferences() {
        mWebViewCore.sendMessage(150);
    }

    public void clearView() {
        mContentWidth = 0;
        mContentHeight = 0;
        setBaseLayer(0, false, false);
        mWebViewCore.sendMessage(134);
    }

    public void clearViewState() {
        mBlockWebkitViewMessages = false;
        mLoadedPicture = null;
        invalidate();
    }

    public int computeHorizontalScrollOffset() {
        return Math.max(getScrollX(), 0);
    }

    public int computeHorizontalScrollRange() {
        int i;
        int j;
        int k;
        i = computeRealHorizontalScrollRange();
        j = getScrollX();
        k = computeMaxScrollX();
        if(j >= 0) goto _L2; else goto _L1
_L1:
        i -= j;
_L4:
        return i;
_L2:
        if(j > k)
            i += j - k;
        if(true) goto _L4; else goto _L3
_L3:
    }

    int computeMaxScrollX() {
        return Math.max(computeRealHorizontalScrollRange() - getViewWidth(), 0);
    }

    int computeMaxScrollY() {
        return Math.max((computeRealVerticalScrollRange() + getTitleHeight()) - getViewHeightWithTitle(), 0);
    }

    float computeReadingLevelScale(float f) {
        return mZoomManager.computeReadingLevelScale(f);
    }

    public void computeScroll() {
        if(mScroller.computeScrollOffset()) {
            int i = getScrollX();
            int j = getScrollY();
            int k = mScroller.getCurrX();
            int l = mScroller.getCurrY();
            invalidate();
            if(!mScroller.isFinished()) {
                int i1 = computeMaxScrollX();
                int j1 = computeMaxScrollY();
                int k1 = mOverflingDistance;
                if(mTouchMode == 9) {
                    i = mScrollingLayerRect.left;
                    j = mScrollingLayerRect.top;
                    i1 = mScrollingLayerRect.right;
                    j1 = mScrollingLayerRect.bottom;
                    k1 = 0;
                } else
                if(mTouchMode == 10) {
                    i = getTextScrollX();
                    j = getTextScrollY();
                    i1 = getMaxTextScrollX();
                    j1 = getMaxTextScrollY();
                    k1 = 0;
                }
                mWebViewPrivate.overScrollBy(k - i, l - j, i, j, i1, j1, k1, k1, false);
                if(mOverScrollGlow != null)
                    mOverScrollGlow.absorbGlow(k, l, i, j, i1, j1);
            } else {
                if(mTouchMode == 9)
                    scrollLayerTo(k, l);
                else
                if(mTouchMode == 10) {
                    scrollEditText(k, l);
                } else {
                    setScrollXRaw(k);
                    setScrollYRaw(l);
                }
                abortAnimation();
                nativeSetIsScrolling(false);
                if(!mBlockWebkitViewMessages) {
                    WebViewCore.resumePriority();
                    if(!mSelectingText)
                        WebViewCore.resumeUpdatePicture(mWebViewCore);
                }
                if(i != getScrollX() || j != getScrollY())
                    sendOurVisibleRect();
            }
        } else {
            mWebViewPrivate.super_computeScroll();
        }
    }

    public int computeVerticalScrollExtent() {
        return getViewHeight();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(getScrollY() - getTitleHeight(), 0);
    }

    public int computeVerticalScrollRange() {
        int i;
        int j;
        int k;
        i = computeRealVerticalScrollRange();
        j = getScrollY();
        k = computeMaxScrollY();
        if(j >= 0) goto _L2; else goto _L1
_L1:
        i -= j;
_L4:
        return i;
_L2:
        if(j > k)
            i += j - k;
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected void contentInvalidateAll() {
        if(mWebViewCore != null && !mBlockWebkitViewMessages)
            mWebViewCore.sendMessage(175);
    }

    int contentToViewDimension(int i) {
        return Math.round((float)i * mZoomManager.getScale());
    }

    int contentToViewX(int i) {
        return contentToViewDimension(i);
    }

    int contentToViewY(int i) {
        return contentToViewDimension(i) + getTitleHeight();
    }

    public WebBackForwardList copyBackForwardList() {
        return mCallbackProxy.getBackForwardList().clone();
    }

    public boolean copySelection() {
        boolean flag = false;
        String s = getSelection();
        if(s != null && s != "") {
            Toast.makeText(mContext, 0x1040396, 0).show();
            flag = true;
            ((ClipboardManager)mContext.getSystemService("clipboard")).setText(s);
            int ai[] = new int[4];
            getSelectionHandles(ai);
            mWebViewCore.sendMessage(210, ai);
        }
        invalidate();
        return flag;
    }

    public void cutSelection() {
        copySelection();
        int ai[] = new int[4];
        getSelectionHandles(ai);
        mWebViewCore.sendMessage(211, ai);
    }

    public void debugDump() {
    }

    void deleteSelection(int i, int j) {
        mTextGeneration = 1 + mTextGeneration;
        WebViewCore.TextSelectionData textselectiondata = new WebViewCore.TextSelectionData(i, j, 0);
        mWebViewCore.sendMessage(122, mTextGeneration, 0, textselectiondata);
    }

    public void destroy() {
        if(mWebView.getViewRootImpl() != null)
            Log.e("webview", "Error: WebView.destroy() called while still attached!");
        ensureFunctorDetached();
        destroyJava();
        destroyNative();
    }

    public void discardAllTextures() {
        nativeDiscardAllTextures();
    }

    void dismissZoomControl() {
        mZoomManager.dismissZoomPicker();
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent) {
        keyevent.getAction();
        JVM INSTR tableswitch 0 2: default 32
    //                   0 45
    //                   1 63
    //                   2 32;
           goto _L1 _L2 _L3 _L1
_L1:
        boolean flag = mWebViewPrivate.super_dispatchKeyEvent(keyevent);
_L5:
        return flag;
_L2:
        mKeysPressed.add(Integer.valueOf(keyevent.getKeyCode()));
        continue; /* Loop/switch isn't completed */
_L3:
        int i;
        i = mKeysPressed.indexOf(Integer.valueOf(keyevent.getKeyCode()));
        if(i != -1)
            break; /* Loop/switch isn't completed */
        flag = false;
        if(true) goto _L5; else goto _L4
_L4:
        mKeysPressed.remove(i);
        if(true) goto _L1; else goto _L6
_L6:
    }

    public void documentAsText(Message message) {
        mWebViewCore.sendMessage(161, message);
    }

    public void documentHasImages(Message message) {
        if(message != null)
            mWebViewCore.sendMessage(120, message);
    }

    boolean drawHistory() {
        return mDrawHistory;
    }

    public void dumpDisplayTree() {
        nativeDumpDisplayTree(getUrl());
    }

    public void dumpDomTree(boolean flag) {
        WebViewCore webviewcore = mWebViewCore;
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        webviewcore.sendMessage(170, i, 0);
    }

    public void dumpRenderTree(boolean flag) {
        WebViewCore webviewcore = mWebViewCore;
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        webviewcore.sendMessage(171, i, 0);
    }

    public void emulateShiftHeld() {
    }

    public void enterReadMode() {
        if(mWebViewCore.getReadModeString() == null);
    }

    public void externalRepresentation(Message message) {
        mWebViewCore.sendMessage(160, message);
    }

    protected void finalize() throws Throwable {
        destroy();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public int findAll(String s) {
        return findAllBody(s, false);
    }

    public void findAllAsync(String s) {
        findAllBody(s, true);
    }

    public void findNext(boolean flag) {
        if(mNativeClass != 0 && mFindRequest != null) {
            WebViewCore webviewcore = mWebViewCore;
            int i;
            if(flag)
                i = 1;
            else
                i = 0;
            webviewcore.sendMessage(222, i, mFindRequest);
        }
    }

    public void flingScroll(int i, int j) {
        mScroller.fling(getScrollX(), getScrollY(), i, j, 0, computeMaxScrollX(), 0, computeMaxScrollY(), mOverflingDistance, mOverflingDistance);
        invalidate();
    }

    boolean focusCandidateIsEditableText() {
        boolean flag;
        if(mFocusedNode != null)
            flag = mFocusedNode.mEditable;
        else
            flag = false;
        return flag;
    }

    public void freeMemory() {
        mWebViewCore.sendMessage(145);
    }

    int getBaseLayer() {
        int i;
        if(mNativeClass == 0)
            i = 0;
        else
            i = nativeGetBaseLayer(mNativeClass);
        return i;
    }

    int getBlockLeftEdge(int i, int j, float f) {
        int k;
        int l;
        k = (int)((1.0F / f) * (float)getViewWidth());
        l = -1;
        if(mFocusedNode == null) goto _L2; else goto _L1
_L1:
        int i1;
        int j1;
        i1 = mFocusedNode.mEnclosingParentRects.length;
        j1 = 0;
_L6:
        if(j1 >= i1) goto _L2; else goto _L3
_L3:
        Rect rect = mFocusedNode.mEnclosingParentRects[j1];
        if(rect.width() >= mFocusedNode.mHitTestSlop) goto _L5; else goto _L4
_L4:
        j1++;
          goto _L6
_L5:
        if(rect.width() <= k)
            break MISSING_BLOCK_LABEL_89;
_L2:
        return l;
        l = rect.left;
          goto _L4
    }

    public SslCertificate getCertificate() {
        return mCertificate;
    }

    public int getContentHeight() {
        return mContentHeight;
    }

    public int getContentWidth() {
        return mContentWidth;
    }

    Context getContext() {
        return mContext;
    }

    float getDefaultZoomScale() {
        return mZoomManager.getDefaultScale();
    }

    public Bitmap getFavicon() {
        WebHistoryItem webhistoryitem = mCallbackProxy.getBackForwardList().getCurrentItem();
        Bitmap bitmap;
        if(webhistoryitem != null)
            bitmap = webhistoryitem.getFavicon();
        else
            bitmap = null;
        return bitmap;
    }

    int getHeight() {
        return mWebView.getHeight();
    }

    int getHistoryPictureWidth() {
        int i;
        if(mHistoryPicture != null)
            i = mHistoryPicture.getWidth();
        else
            i = 0;
        return i;
    }

    public WebView.HitTestResult getHitTestResult() {
        return mInitialHitTestResult;
    }

    public String[] getHttpAuthUsernamePassword(String s, String s1) {
        return mDatabase.getHttpAuthUsernamePassword(s, s1);
    }

    public String getOriginalUrl() {
        WebHistoryItem webhistoryitem = mCallbackProxy.getBackForwardList().getCurrentItem();
        String s;
        if(webhistoryitem != null)
            s = webhistoryitem.getOriginalUrl();
        else
            s = null;
        return s;
    }

    public int getPageBackgroundColor() {
        int i;
        if(mNativeClass == 0)
            i = -1;
        else
        if(getSettings().getNightReadModeEnabled())
            i = 0xff000000;
        else
            i = nativeGetBackgroundColor(mNativeClass);
        return i;
    }

    public int getProgress() {
        return mCallbackProxy.getProgress();
    }

    public float getScale() {
        return mZoomManager.getScale();
    }

    int getScaledNavSlop() {
        return viewToContentDimension(mNavSlop);
    }

    public WebViewProvider.ScrollDelegate getScrollDelegate() {
        return this;
    }

    int getScrollX() {
        return mWebView.getScrollX();
    }

    int getScrollY() {
        return mWebView.getScrollY();
    }

    public SearchBox getSearchBox() {
        SearchBox searchbox;
        if(mWebViewCore == null || mWebViewCore.getBrowserFrame() == null)
            searchbox = null;
        else
            searchbox = mWebViewCore.getBrowserFrame().getSearchBox();
        return searchbox;
    }

    String getSelection() {
        String s;
        if(mNativeClass == 0)
            s = "";
        else
            s = nativeGetSelection();
        return s;
    }

    public volatile WebSettings getSettings() {
        return getSettings();
    }

    public WebSettingsClassic getSettings() {
        WebSettingsClassic websettingsclassic;
        if(mWebViewCore != null)
            websettingsclassic = mWebViewCore.getSettings();
        else
            websettingsclassic = null;
        return websettingsclassic;
    }

    public String getTitle() {
        WebHistoryItem webhistoryitem = mCallbackProxy.getBackForwardList().getCurrentItem();
        String s;
        if(webhistoryitem != null)
            s = webhistoryitem.getTitle();
        else
            s = null;
        return s;
    }

    protected int getTitleHeight() {
        int i;
        if(mWebView instanceof TitleBarDelegate)
            i = ((TitleBarDelegate)mWebView).getTitleHeight();
        else
            i = 0;
        return i;
    }

    public String getTouchIconUrl() {
        WebHistoryItem webhistoryitem = mCallbackProxy.getBackForwardList().getCurrentItem();
        String s;
        if(webhistoryitem != null)
            s = webhistoryitem.getTouchIconUrl();
        else
            s = null;
        return s;
    }

    public String getUrl() {
        WebHistoryItem webhistoryitem = mCallbackProxy.getBackForwardList().getCurrentItem();
        String s;
        if(webhistoryitem != null)
            s = webhistoryitem.getUrl();
        else
            s = null;
        return s;
    }

    public WebViewProvider.ViewDelegate getViewDelegate() {
        return this;
    }

    int getViewHeight() {
        return getViewHeightWithTitle() - getVisibleTitleHeightImpl();
    }

    int getViewHeightWithTitle() {
        int i = getHeight();
        if(mWebView.isHorizontalScrollBarEnabled() && !mOverlayHorizontalScrollbar)
            i -= mWebViewPrivate.getHorizontalScrollbarHeight();
        return i;
    }

    ViewManager getViewManager() {
        return mViewManager;
    }

    int getViewWidth() {
        int i;
        if(!mWebView.isVerticalScrollBarEnabled() || mOverlayVerticalScrollbar)
            i = getWidth();
        else
            i = Math.max(0, getWidth() - mWebView.getVerticalScrollbarWidth());
        return i;
    }

    public int getVisibleTitleHeight() {
        return getVisibleTitleHeightImpl();
    }

    public WebBackForwardListClient getWebBackForwardListClient() {
        return mCallbackProxy.getWebBackForwardListClient();
    }

    public WebChromeClient getWebChromeClient() {
        return mCallbackProxy.getWebChromeClient();
    }

    public WebView getWebView() {
        return mWebView;
    }

    public WebViewClient getWebViewClient() {
        return mCallbackProxy.getWebViewClient();
    }

    /**
     * @deprecated Method getWebViewCore is deprecated
     */

    public WebViewCore getWebViewCore() {
        this;
        JVM INSTR monitorenter ;
        WebViewCore webviewcore = mWebViewCore;
        this;
        JVM INSTR monitorexit ;
        return webviewcore;
        Exception exception;
        exception;
        throw exception;
    }

    int getWidth() {
        return mWebView.getWidth();
    }

    public View getZoomControls() {
        View view;
        if(!getSettings().supportZoom()) {
            Log.w("webview", "This WebView doesn't support zoom.");
            view = null;
        } else {
            view = mZoomManager.getExternalZoomPicker();
        }
        return view;
    }

    float getZoomOverviewScale() {
        return mZoomManager.getZoomOverviewScale();
    }

    public void goBack() {
        goBackOrForwardImpl(-1);
    }

    public void goBackOrForward(int i) {
        goBackOrForwardImpl(i);
    }

    public void goForward() {
        goBackOrForwardImpl(1);
    }

    void incrementTextGeneration() {
        mTextGeneration = 1 + mTextGeneration;
    }

    public void init(Map map, boolean flag) {
        Context context = mContext;
        JniUtil.setContext(context);
        mCallbackProxy = new CallbackProxy(context, this);
        mViewManager = new ViewManager(this);
        L10nUtils.setApplicationContext(context.getApplicationContext());
        mWebViewCore = new WebViewCore(context, this, mCallbackProxy, map);
        mDatabase = WebViewDatabaseClassic.getInstance(context);
        mScroller = new OverScroller(context, null, 0.0F, 0.0F, false);
        mZoomManager = new ZoomManager(this, mCallbackProxy);
        init();
        setupPackageListener(context);
        setupProxyListener(context);
        setupTrustStorageListener(context);
        updateMultiTouchSupport(context);
        if(flag)
            startPrivateBrowsing();
        mAutoFillData = new WebViewCore.AutoFillData();
        mEditTextScroller = new Scroller(context);
    }

    void invalidate() {
        mWebView.invalidate();
    }

    public void invokeZoomPicker() {
        if(!getSettings().supportZoom()) {
            Log.w("webview", "This WebView doesn't support zoom.");
        } else {
            clearHelpers();
            mZoomManager.invokeZoomPicker();
        }
    }

    public boolean isPaused() {
        return mIsPaused;
    }

    public boolean isPrivateBrowsingEnabled() {
        WebSettingsClassic websettingsclassic = getSettings();
        boolean flag;
        if(websettingsclassic != null)
            flag = websettingsclassic.isPrivateBrowsingEnabled();
        else
            flag = false;
        return flag;
    }

    boolean isRectFitOnScreen(Rect rect) {
        int i = rect.width();
        int j = rect.height();
        int k = getViewWidth();
        int l = getViewHeightWithTitle();
        float f = Math.min((float)k / (float)i, (float)l / (float)j);
        float f1 = mZoomManager.computeScaleWithLimits(f);
        boolean flag;
        if(!mZoomManager.willScaleTriggerZoom(f1) && contentToViewX(rect.left) >= getScrollX() && contentToViewX(rect.right) <= k + getScrollX() && contentToViewY(rect.top) >= getScrollY() && contentToViewY(rect.bottom) <= l + getScrollY())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void loadData(String s, String s1, String s2) {
        loadDataImpl(s, s1, s2);
    }

    public void loadDataWithBaseURL(String s, String s1, String s2, String s3, String s4) {
        if(s != null && s.toLowerCase().startsWith("data:")) {
            loadDataImpl(s1, s2, s3);
        } else {
            switchOutDrawHistory();
            WebViewCore.BaseUrlData baseurldata = new WebViewCore.BaseUrlData();
            baseurldata.mBaseUrl = s;
            baseurldata.mData = s1;
            baseurldata.mMimeType = s2;
            baseurldata.mEncoding = s3;
            baseurldata.mHistoryUrl = s4;
            mWebViewCore.sendMessage(139, baseurldata);
            clearHelpers();
        }
    }

    public void loadUrl(String s) {
        loadUrlImpl(s);
    }

    public void loadUrl(String s, Map map) {
        loadUrlImpl(s, map);
    }

    public void loadViewState(InputStream inputstream) {
        mBlockWebkitViewMessages = true;
        AsyncTask asynctask = new AsyncTask() {

            protected transient WebViewCore.DrawData doInBackground(InputStream ainputstream1[]) {
                WebViewCore.DrawData drawdata1 = ViewStateSerializer.deserializeViewState(ainputstream1[0]);
                WebViewCore.DrawData drawdata = drawdata1;
_L2:
                return drawdata;
                IOException ioexception;
                ioexception;
                drawdata = null;
                if(true) goto _L2; else goto _L1
_L1:
            }

            protected volatile Object doInBackground(Object aobj[]) {
                return doInBackground((InputStream[])aobj);
            }

            protected void onPostExecute(WebViewCore.DrawData drawdata) {
                if(drawdata == null) {
                    Log.e("webview", "Failed to load view state!");
                } else {
                    drawdata.mViewSize = new Point(getViewWidth(), getViewHeightWithTitle() - getTitleHeight());
                    drawdata.mViewState.mDefaultScale = getDefaultZoomScale();
                    mLoadedPicture = drawdata;
                    setNewPicture(mLoadedPicture, true);
                    mLoadedPicture.mViewState = null;
                }
            }

            protected volatile void onPostExecute(Object obj) {
                onPostExecute((WebViewCore.DrawData)obj);
            }

            final WebViewClassic this$0;

             {
                this$0 = WebViewClassic.this;
                super();
            }
        };
        InputStream ainputstream[] = new InputStream[1];
        ainputstream[0] = inputstream;
        asynctask.execute(ainputstream);
    }

    native String nativeGetProperty(String s);

    native boolean nativeSetProperty(String s, String s1);

    void notifyFindDialogDismissed() {
        mFindCallback = null;
        mCachedOverlappingActionModeHeight = -1;
        if(mWebViewCore != null) {
            clearMatches();
            setFindIsUp(false);
            pinScrollTo(getScrollX(), getScrollY(), false, 0);
            invalidate();
        }
    }

    public void onAttachedToWindow() {
        if(mWebView.hasWindowFocus())
            setActive(true);
        if(isAccessibilityEnabled())
            getAccessibilityInjector().addAccessibilityApisIfNecessary();
        updateHwAccelerated();
    }

    public void onConfigurationChanged(Configuration configuration) {
        mCachedOverlappingActionModeHeight = -1;
        if(mSelectingText && mOrientation != configuration.orientation)
            selectionDone();
        mOrientation = configuration.orientation;
        if(mWebViewCore != null && !mBlockWebkitViewMessages)
            mWebViewCore.sendMessage(134);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorinfo) {
        if(mInputConnection == null) {
            mInputConnection = new WebViewInputConnection();
            mAutoCompletePopup = new AutoCompletePopup(this, mInputConnection);
        }
        mInputConnection.setupEditorInfo(editorinfo);
        return mInputConnection;
    }

    public void onDetachedFromWindow() {
        clearHelpers();
        mZoomManager.dismissZoomPicker();
        if(mWebView.hasWindowFocus())
            setActive(false);
        if(isAccessibilityEnabled())
            getAccessibilityInjector().removeAccessibilityApisIfNecessary();
        else
            mAccessibilityInjector = null;
        updateHwAccelerated();
        ensureFunctorDetached();
    }

    public void onDraw(Canvas canvas) {
        if(!inFullScreenMode()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(getSettings() != null && getSettings().getNightReadModeEnabled()) {
            mBackgroundColor = 0xff000000;
            canvas.drawColor(0xff000000);
        }
        if(mNativeClass == 0) {
            canvas.drawColor(mBackgroundColor);
            continue; /* Loop/switch isn't completed */
        }
        if((mContentWidth | mContentHeight) == 0 && mHistoryPicture == null) {
            canvas.drawColor(mBackgroundColor);
            continue; /* Loop/switch isn't completed */
        }
        int i;
        if(canvas.isHardwareAccelerated())
            mZoomManager.setHardwareAccelerated();
        else
            mWebViewCore.resumeWebKitDraw();
        i = canvas.save();
        if(mInOverScrollMode && !getSettings().getUseWebViewBackgroundForOverscrollBackground())
            drawOverScrollBackground(canvas);
        canvas.translate(0.0F, getTitleHeight());
        drawContent(canvas);
        canvas.restoreToCount(i);
        mWebViewCore.signalRepaintDone();
        if(mOverScrollGlow != null && mOverScrollGlow.drawEdgeGlows(canvas))
            invalidate();
        if(mFocusTransition == null)
            break; /* Loop/switch isn't completed */
        mFocusTransition.draw(canvas);
_L5:
        if(getSettings().getNavDump() && (mTouchHighlightX | mTouchHighlightY) != 0) {
            if(mTouchCrossHairColor == null) {
                mTouchCrossHairColor = new Paint();
                mTouchCrossHairColor.setColor(0xffff0000);
            }
            canvas.drawLine(mTouchHighlightX - mNavSlop, mTouchHighlightY - mNavSlop, 1 + (mTouchHighlightX + mNavSlop), 1 + (mTouchHighlightY + mNavSlop), mTouchCrossHairColor);
            canvas.drawLine(1 + (mTouchHighlightX + mNavSlop), mTouchHighlightY - mNavSlop, mTouchHighlightX - mNavSlop, 1 + (mTouchHighlightY + mNavSlop), mTouchCrossHairColor);
        }
        if(true) goto _L1; else goto _L3
_L3:
        if(!shouldDrawHighlightRect()) goto _L5; else goto _L4
_L4:
        RegionIterator regioniterator = new RegionIterator(mTouchHighlightRegion);
        Rect rect = new Rect();
        while(regioniterator.next(rect)) 
            canvas.drawRect(rect, mTouchHightlightPaint);
          goto _L5
    }

    public void onDrawVerticalScrollBar(Canvas canvas, Drawable drawable, int i, int j, int k, int l) {
        if(getScrollY() < 0)
            j -= getScrollY();
        drawable.setBounds(i, j + getVisibleTitleHeightImpl(), k, l);
        drawable.draw(canvas);
    }

    void onFixedLengthZoomAnimationEnd() {
        if(!mBlockWebkitViewMessages && !mSelectingText)
            WebViewCore.resumeUpdatePicture(mWebViewCore);
        onZoomAnimationEnd();
    }

    void onFixedLengthZoomAnimationStart() {
        WebViewCore.pauseUpdatePicture(getWebViewCore());
        onZoomAnimationStart();
    }

    public void onFocusChanged(boolean flag, int i, Rect rect) {
        if(flag) {
            mDrawCursorRing = true;
            setFocusControllerActive(true);
        } else {
            mDrawCursorRing = false;
            setFocusControllerActive(false);
            mKeysPressed.clear();
        }
        if(!mTouchHighlightRegion.isEmpty())
            mWebView.invalidate(mTouchHighlightRegion.getBounds());
    }

    public boolean onGenericMotionEvent(MotionEvent motionevent) {
        if((2 & motionevent.getSource()) == 0) goto _L2; else goto _L1
_L1:
        motionevent.getAction();
        JVM INSTR tableswitch 8 8: default 32
    //                   8 43;
           goto _L2 _L3
_L2:
        boolean flag = mWebViewPrivate.super_onGenericMotionEvent(motionevent);
_L6:
        return flag;
_L3:
        float f;
        float f1;
        int i;
        if((1 & motionevent.getMetaState()) != 0) {
            f = 0.0F;
            f1 = motionevent.getAxisValue(9);
        } else {
            f = -motionevent.getAxisValue(9);
            f1 = motionevent.getAxisValue(10);
        }
        if(f1 == 0.0F && f == 0.0F) goto _L2; else goto _L4
_L4:
        i = (int)(f * mWebViewPrivate.getVerticalScrollFactor());
        if(!pinScrollBy((int)(f1 * mWebViewPrivate.getHorizontalScrollFactor()), i, false, 0)) goto _L2; else goto _L5
_L5:
        flag = true;
          goto _L6
    }

    public boolean onHoverEvent(MotionEvent motionevent) {
        boolean flag;
        if(mNativeClass == 0) {
            flag = false;
        } else {
            int i = viewToContentX((int)motionevent.getX() + getScrollX());
            int j = viewToContentY((int)motionevent.getY() + getScrollY());
            mWebViewCore.sendMessage(135, i, j);
            mWebViewPrivate.super_onHoverEvent(motionevent);
            flag = true;
        }
        return flag;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        accessibilityevent.setScrollable(isScrollableForAccessibility());
        accessibilityevent.setScrollX(getScrollX());
        accessibilityevent.setScrollY(getScrollY());
        accessibilityevent.setMaxScrollX(Math.max(contentToViewX(getContentWidth()) - (getWidth() - mWebView.getPaddingLeft() - mWebView.getPaddingLeft()), 0));
        accessibilityevent.setMaxScrollY(Math.max(contentToViewY(getContentHeight()) - (getHeight() - mWebView.getPaddingTop() - mWebView.getPaddingBottom()), 0));
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        if(mWebView.isEnabled()) {
            accessibilitynodeinfo.setScrollable(isScrollableForAccessibility());
            int i = Math.max(contentToViewY(getContentHeight()) - (getHeight() - mWebView.getPaddingTop() - mWebView.getPaddingBottom()), 0);
            if(getScrollY() <= 0);
            boolean flag;
            if(getScrollY() - i > 0)
                flag = true;
            else
                flag = false;
            if(flag)
                accessibilitynodeinfo.addAction(4096);
            if(flag)
                accessibilitynodeinfo.addAction(8192);
            getAccessibilityInjector().onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyevent) {
        boolean flag;
        boolean flag1;
        flag = false;
        flag1 = true;
        if(mIsCaretSelection)
            selectionDone();
        if(!mBlockWebkitViewMessages) goto _L2; else goto _L1
_L1:
        flag1 = false;
_L10:
        return flag1;
_L2:
        if(keyevent.isCtrlPressed()) {
            flag1 = false;
            continue; /* Loop/switch isn't completed */
        }
        if(mNativeClass == 0) {
            flag1 = false;
            continue; /* Loop/switch isn't completed */
        }
        if(keyevent.isSystem() || mCallbackProxy.uiOverrideKeyEvent(keyevent)) {
            flag1 = false;
            continue; /* Loop/switch isn't completed */
        }
        if(isAccessibilityEnabled() && getAccessibilityInjector().handleKeyEventIfNecessary(keyevent))
            continue; /* Loop/switch isn't completed */
        if(i == 92) {
            if(keyevent.hasNoModifiers()) {
                pageUp(false);
                continue; /* Loop/switch isn't completed */
            }
            if(keyevent.hasModifiers(2)) {
                pageUp(flag1);
                continue; /* Loop/switch isn't completed */
            }
        }
        if(i == 93) {
            if(keyevent.hasNoModifiers()) {
                pageDown(false);
                continue; /* Loop/switch isn't completed */
            }
            if(keyevent.hasModifiers(2)) {
                pageDown(flag1);
                continue; /* Loop/switch isn't completed */
            }
        }
        if(i == 122 && keyevent.hasNoModifiers()) {
            pageUp(flag1);
            continue; /* Loop/switch isn't completed */
        }
        if(i == 123 && keyevent.hasNoModifiers()) {
            pageDown(flag1);
            continue; /* Loop/switch isn't completed */
        }
        if(i >= 19 && i <= 22)
            switchOutDrawHistory();
        if(isEnterActionKey(i)) {
            switchOutDrawHistory();
            if(keyevent.getRepeatCount() == 0) {
                if(mSelectingText)
                    continue; /* Loop/switch isn't completed */
                mGotCenterDown = flag1;
                mPrivateHandler.sendMessageDelayed(mPrivateHandler.obtainMessage(114), 1000L);
            }
        }
        if(!getSettings().getNavDump()) goto _L4; else goto _L3
_L3:
        i;
        JVM INSTR tableswitch 11 15: default 336
    //                   11 344
    //                   12 351
    //                   13 351
    //                   14 368
    //                   15 368;
           goto _L5 _L6 _L7 _L7 _L8 _L8
_L8:
        break MISSING_BLOCK_LABEL_368;
_L5:
        break; /* Loop/switch isn't completed */
_L6:
        break; /* Loop/switch isn't completed */
_L4:
        sendKeyEvent(keyevent);
        if(true) goto _L10; else goto _L9
_L9:
        dumpDisplayTree();
          goto _L4
_L7:
        if(i == 12)
            flag = flag1;
        dumpDomTree(flag);
          goto _L4
        if(i == 14)
            flag = flag1;
        dumpRenderTree(flag);
          goto _L4
    }

    public boolean onKeyMultiple(int i, int j, KeyEvent keyevent) {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_3;
        if(!mBlockWebkitViewMessages && i == 0 && keyevent.getCharacters() != null) {
            sendBatchableInputMessage(103, 0, 0, keyevent);
            sendBatchableInputMessage(104, 0, 0, keyevent);
            flag = true;
        }
        return flag;
    }

    public boolean onKeyPreIme(int i, KeyEvent keyevent) {
        boolean flag;
        if(mAutoCompletePopup != null)
            flag = mAutoCompletePopup.onKeyPreIme(i, keyevent);
        else
            flag = false;
        return flag;
    }

    public boolean onKeyUp(int i, KeyEvent keyevent) {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        while(true)  {
            do
                return flag;
            while(mBlockWebkitViewMessages || mNativeClass == 0);
            if(i == 5 && mInitialHitTestResult != null && mInitialHitTestResult.getType() == 2) {
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(mInitialHitTestResult.getExtra()));
                mContext.startActivity(intent);
                flag = true;
                continue;
            }
            if(keyevent.isSystem() || mCallbackProxy.uiOverrideKeyEvent(keyevent))
                continue;
            if(isAccessibilityEnabled() && getAccessibilityInjector().handleKeyEventIfNecessary(keyevent)) {
                flag = true;
                continue;
            }
            if(isEnterActionKey(i)) {
                mPrivateHandler.removeMessages(114);
                mGotCenterDown = false;
                if(mSelectingText) {
                    copySelection();
                    selectionDone();
                    flag = true;
                    continue;
                }
            }
            sendKeyEvent(keyevent);
            flag = true;
        }
    }

    public void onMeasure(int i, int j) {
        int l1;
        int j2;
        int k = android.view.View.MeasureSpec.getMode(j);
        int l = android.view.View.MeasureSpec.getSize(j);
        int i1 = android.view.View.MeasureSpec.getMode(i);
        int j1 = android.view.View.MeasureSpec.getSize(i);
        int k1 = l;
        l1 = j1;
        int i2 = contentToViewDimension(mContentHeight);
        j2 = contentToViewDimension(mContentWidth);
        if(k != 0x40000000) {
            mHeightCanMeasure = true;
            k1 = i2;
            if(k == 0x80000000 && k1 > l) {
                mHeightCanMeasure = false;
                k1 = l | 0x1000000;
            }
        } else {
            mHeightCanMeasure = false;
        }
        if(mNativeClass != 0)
            nativeSetHeightCanMeasure(mHeightCanMeasure);
        if(i1 != 0) goto _L2; else goto _L1
_L1:
        mWidthCanMeasure = true;
        l1 = j2;
_L4:
        this;
        JVM INSTR monitorenter ;
        mWebViewPrivate.setMeasuredDimension(l1, k1);
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if(l1 < j2)
            l1 |= 0x1000000;
        mWidthCanMeasure = false;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onOverScrolled(int i, int j, boolean flag, boolean flag1) {
        if(mTouchMode != 10) goto _L2; else goto _L1
_L1:
        scrollEditText(i, j);
_L4:
        return;
_L2:
        int k;
        int l;
        if(mTouchMode == 9) {
            scrollLayerTo(i, j);
            continue; /* Loop/switch isn't completed */
        }
        mInOverScrollMode = false;
        k = computeMaxScrollX();
        l = computeMaxScrollY();
        if(k != 0)
            break; /* Loop/switch isn't completed */
        i = pinLocX(i);
_L6:
        if(j < 0 || j > l)
            mInOverScrollMode = true;
        int i1 = getScrollX();
        int j1 = getScrollY();
        mWebViewPrivate.super_scrollTo(i, j);
        if(mOverScrollGlow != null)
            mOverScrollGlow.pullGlow(getScrollX(), getScrollY(), i1, j1, k, l);
        if(true) goto _L4; else goto _L3
_L3:
        if(i >= 0 && i <= k) goto _L6; else goto _L5
_L5:
        mInOverScrollMode = true;
          goto _L6
    }

    void onPageFinished(String s) {
        mZoomManager.onPageFinished(s);
        if(isAccessibilityEnabled())
            getAccessibilityInjector().onPageFinished(s);
    }

    void onPageStarted(String s) {
        mWebView.setCertificate(null);
        if(isAccessibilityEnabled())
            getAccessibilityInjector().onPageStarted(s);
        mIsEditingText = false;
    }

    public void onPause() {
        if(!mIsPaused) {
            mIsPaused = true;
            mWebViewCore.sendMessage(143);
            if(mHTML5VideoViewProxy != null)
                mHTML5VideoViewProxy.pauseAndDispatch();
            if(mNativeClass != 0)
                nativeSetPauseDrawing(mNativeClass, true);
            cancelSelectDialog();
            WebCoreThreadWatchdog.pause();
        }
    }

    void onPinchToZoomAnimationEnd(ScaleGestureDetector scalegesturedetector) {
        onZoomAnimationEnd();
        mTouchMode = 8;
        mConfirmMove = true;
        startTouch(scalegesturedetector.getFocusX(), scalegesturedetector.getFocusY(), mLastTouchTime);
    }

    void onPinchToZoomAnimationStart() {
        cancelTouch();
        onZoomAnimationStart();
    }

    public void onResume() {
        if(mIsPaused) {
            mIsPaused = false;
            mWebViewCore.sendMessage(144);
            if(mNativeClass != 0)
                nativeSetPauseDrawing(mNativeClass, false);
        }
        WebCoreThreadWatchdog.resume();
    }

    boolean onSavePassword(String s, String s1, String s2, final Message resumeMsg) {
        boolean flag;
        boolean flag1;
        flag = true;
        flag1 = false;
        if(resumeMsg != null) goto _L2; else goto _L1
_L1:
        mDatabase.setUsernamePassword(s, s1, s2);
_L6:
        flag = flag1;
_L4:
        return flag;
_L2:
        if(mResumeMsg == null)
            break; /* Loop/switch isn't completed */
        Log.w("webview", "onSavePassword should not be called while dialog is up");
        resumeMsg.sendToTarget();
        if(true) goto _L4; else goto _L3
_L3:
        mResumeMsg = resumeMsg;
        final Message remember = mPrivateHandler.obtainMessage(flag);
        remember.getData().putString("host", s);
        remember.getData().putString("username", s1);
        remember.getData().putString("password", s2);
        remember.obj = resumeMsg;
        final Message neverRemember = mPrivateHandler.obtainMessage(2);
        neverRemember.getData().putString("host", s);
        neverRemember.getData().putString("username", s1);
        neverRemember.getData().putString("password", s2);
        neverRemember.obj = resumeMsg;
        (new android.app.AlertDialog.Builder(mContext)).setTitle(0x1040340).setMessage(0x1040391).setPositiveButton(0x1040392, new android.content.DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialoginterface, int i) {
                if(mResumeMsg != null) {
                    resumeMsg.sendToTarget();
                    mResumeMsg = null;
                }
            }

            final WebViewClassic this$0;
            final Message val$resumeMsg;

             {
                this$0 = WebViewClassic.this;
                resumeMsg = message;
                super();
            }
        }).setNeutralButton(0x1040393, new android.content.DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialoginterface, int i) {
                if(mResumeMsg != null) {
                    remember.sendToTarget();
                    mResumeMsg = null;
                }
            }

            final WebViewClassic this$0;
            final Message val$remember;

             {
                this$0 = WebViewClassic.this;
                remember = message;
                super();
            }
        }).setNegativeButton(0x1040394, new android.content.DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialoginterface, int i) {
                if(mResumeMsg != null) {
                    neverRemember.sendToTarget();
                    mResumeMsg = null;
                }
            }

            final WebViewClassic this$0;
            final Message val$neverRemember;

             {
                this$0 = WebViewClassic.this;
                neverRemember = message;
                super();
            }
        }).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            public void onCancel(DialogInterface dialoginterface) {
                if(mResumeMsg != null) {
                    resumeMsg.sendToTarget();
                    mResumeMsg = null;
                }
            }

            final WebViewClassic this$0;
            final Message val$resumeMsg;

             {
                this$0 = WebViewClassic.this;
                resumeMsg = message;
                super();
            }
        }).show();
        flag1 = true;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public void onScrollChanged(int i, int j, int k, int l) {
        if(!mInOverScrollMode) {
            sendOurVisibleRect();
            int i1 = getTitleHeight();
            if(Math.max(i1 - j, 0) != Math.max(i1 - l, 0))
                sendViewSizeZoom(false);
        }
    }

    public void onSizeChanged(int i, int j, int k, int l) {
        int i1 = (int)((float)Math.max(i, j) / mZoomManager.getDefaultMinZoomScale());
        if(i1 > sMaxViewportWidth)
            sMaxViewportWidth = i1;
        mZoomManager.onSizeChanged(i, j, k, l);
        if(mLoadedPicture != null && mDelaySetPicture == null)
            setNewPicture(mLoadedPicture, false);
        if(mIsEditingText)
            scrollEditIntoView();
        relocateAutoCompletePopup();
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
_L3:
        do
            return flag;
        while(mNativeClass == 0 || !mWebView.isClickable() && !mWebView.isLongClickable() || mInputDispatcher == null);
        if(mWebView.isFocusable() && mWebView.isFocusableInTouchMode() && !mWebView.isFocused())
            mWebView.requestFocus();
        if(motionevent.getAction() != 1) goto _L2; else goto _L1
_L1:
        mIsActionUp = true;
        mAfterStart = null;
        mBeforeStart = null;
        invalidate();
        if(mSelectingText)
            showFloatView();
_L4:
        if(mInputDispatcher.postPointerEvent(motionevent, getScrollX(), getScrollY() - getTitleHeight(), mZoomManager.getInvScale())) {
            mInputDispatcher.dispatchUiEvents();
            flag = true;
        } else {
            Log.w("webview", "mInputDispatcher rejected the event!");
        }
        if(true) goto _L3; else goto _L2
_L2:
        if(mSelectingText) {
            mIsActionUp = false;
            hideFloatView();
        }
          goto _L4
    }

    public boolean onTrackballEvent(MotionEvent motionevent) {
        boolean flag;
        long l;
        flag = true;
        l = motionevent.getEventTime();
        if((2 & motionevent.getMetaState()) == 0) goto _L2; else goto _L1
_L1:
        if(motionevent.getY() > 0.0F)
            pageDown(flag);
        if(motionevent.getY() < 0.0F)
            pageUp(flag);
_L4:
        return flag;
_L2:
        if(motionevent.getAction() == 0) {
            if(!mSelectingText) {
                mTrackballDown = flag;
                if(mNativeClass == 0) {
                    flag = false;
                } else {
                    if(mWebView.isInTouchMode())
                        mWebView.requestFocusFromTouch();
                    flag = false;
                }
            }
        } else
        if(motionevent.getAction() == flag) {
            mPrivateHandler.removeMessages(114);
            mTrackballDown = false;
            mTrackballUpTime = l;
            if(mSelectingText) {
                copySelection();
                selectionDone();
            } else {
                flag = false;
            }
        } else
        if(mMapTrackballToArrowKeys && (1 & motionevent.getMetaState()) == 0 || AccessibilityManager.getInstance(mContext).isEnabled())
            flag = false;
        else
        if(!mTrackballDown && l - mTrackballUpTime >= 200L) {
            switchOutDrawHistory();
            if(l - mTrackballLastTime > 200L) {
                mTrackballFirstTime = l;
                mTrackballYMove = 0;
                mTrackballXMove = 0;
            }
            mTrackballLastTime = l;
            mTrackballRemainsX = mTrackballRemainsX + motionevent.getX();
            mTrackballRemainsY = mTrackballRemainsY + motionevent.getY();
            doTrackball(l, motionevent.getMetaState());
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void onVisibilityChanged(View view, int i) {
        if(i != 0 && mZoomManager != null)
            mZoomManager.dismissZoomPicker();
        updateDrawingState();
    }

    public void onWindowFocusChanged(boolean flag) {
        setActive(flag);
        if(!flag) goto _L2; else goto _L1
_L1:
        JWebCoreJavaBridge.setActiveWebView(this);
        if(mPictureUpdatePausedForFocusChange) {
            WebViewCore.resumeUpdatePicture(mWebViewCore);
            mPictureUpdatePausedForFocusChange = false;
        }
_L4:
        return;
_L2:
        JWebCoreJavaBridge.removeActiveWebView(this);
        WebSettingsClassic websettingsclassic = getSettings();
        if(websettingsclassic != null && websettingsclassic.enableSmoothTransition() && mWebViewCore != null && !WebViewCore.isUpdatePicturePaused(mWebViewCore)) {
            WebViewCore.pauseUpdatePicture(mWebViewCore);
            mPictureUpdatePausedForFocusChange = true;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void onWindowVisibilityChanged(int i) {
        updateDrawingState();
    }

    public boolean overlayHorizontalScrollbar() {
        return mOverlayHorizontalScrollbar;
    }

    public boolean overlayVerticalScrollbar() {
        return mOverlayVerticalScrollbar;
    }

    public boolean pageDown(boolean flag) {
        boolean flag1 = false;
        if(mNativeClass != 0)
            if(flag) {
                flag1 = pinScrollTo(getScrollX(), computeRealVerticalScrollRange(), true, 0);
            } else {
                int i = getHeight();
                int j;
                if(i > 48)
                    j = i - 24;
                else
                    j = i / 2;
                if(mScroller.isFinished())
                    flag1 = pinScrollBy(0, j, true, 0);
                else
                    flag1 = extendScroll(j);
            }
        return flag1;
    }

    protected void pageSwapCallback(boolean flag) {
        mWebViewCore.resumeWebKitDraw();
        if(flag)
            mWebViewCore.sendMessage(196);
        if(mWebView instanceof PageSwapDelegate)
            ((PageSwapDelegate)mWebView).onPageSwapOccurred(flag);
        if(mPictureListener != null)
            mPictureListener.onNewPicture(getWebView(), capturePicture());
    }

    public boolean pageUp(boolean flag) {
        boolean flag1 = false;
        if(mNativeClass != 0)
            if(flag) {
                flag1 = pinScrollTo(getScrollX(), 0, true, 0);
            } else {
                int i = getHeight();
                int j;
                if(i > 48)
                    j = 24 + -i;
                else
                    j = -i / 2;
                if(mScroller.isFinished())
                    flag1 = pinScrollBy(0, j, true, 0);
                else
                    flag1 = extendScroll(j);
            }
        return flag1;
    }

    void passToJavaScript(String s, KeyEvent keyevent) {
        if(mWebViewCore != null) {
            WebViewCore.JSKeyData jskeydata = new WebViewCore.JSKeyData();
            jskeydata.mEvent = keyevent;
            jskeydata.mCurrentText = s;
            mTextGeneration = 1 + mTextGeneration;
            mWebViewCore.sendMessage(115, mTextGeneration, 0, jskeydata);
            mWebViewCore.removeMessages(128);
            mWebViewCore.sendMessageDelayed(128, null, 1000L);
        }
    }

    public void pasteFromClipboard() {
        ClipData clipdata = ((ClipboardManager)mContext.getSystemService("clipboard")).getPrimaryClip();
        if(clipdata != null) {
            CharSequence charsequence = clipdata.getItemAt(0).getText();
            if(mInputConnection != null)
                mInputConnection.replaceSelection(charsequence);
        }
    }

    public void pauseTimers() {
        mWebViewCore.sendMessage(109);
    }

    public boolean performAccessibilityAction(int i, Bundle bundle) {
        boolean flag = true;
        if(mWebView.isEnabled()) goto _L2; else goto _L1
_L1:
        flag = mWebViewPrivate.super_performAccessibilityAction(i, bundle);
_L4:
        return flag;
_L2:
        if(!getAccessibilityInjector().supportsAccessibilityAction(i))
            break; /* Loop/switch isn't completed */
        flag = getAccessibilityInjector().performAccessibilityAction(i, bundle);
        if(true) goto _L4; else goto _L3
_L3:
        switch(i) {
        default:
            flag = mWebViewPrivate.super_performAccessibilityAction(i, bundle);
            break;

        case 4096: 
        case 8192: 
            int j = contentToViewY(getContentHeight());
            int k = getHeight() - mWebView.getPaddingTop() - mWebView.getPaddingBottom();
            int l = Math.max(j - k, 0);
            boolean flag1;
            boolean flag2;
            if(getScrollY() > 0)
                flag1 = flag;
            else
                flag1 = false;
            if(getScrollY() - l > 0)
                flag2 = flag;
            else
                flag2 = false;
            if(i == 8192 && flag1)
                mWebView.scrollBy(0, k);
            else
            if(i == 4096 && flag2)
                mWebView.scrollBy(0, -k);
            else
                flag = false;
            break;
        }
        if(true) goto _L4; else goto _L5
_L5:
    }

    public boolean performLongClick() {
        if(mWebView.getParent() != null) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        ScaleGestureDetector scalegesturedetector = mZoomManager.getScaleGestureDetector();
        if(scalegesturedetector != null && scalegesturedetector.isInProgress())
            flag = false;
        else
        if(mSelectingText)
            flag = false;
        else
        if(mWebViewPrivate.super_performLongClick()) {
            flag = true;
        } else {
            flag = selectText();
            if(flag)
                mWebView.performHapticFeedback(0);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    int pinLocX(int i) {
        if(!mInOverScrollMode)
            i = pinLoc(i, getViewWidth(), computeRealHorizontalScrollRange());
        return i;
    }

    int pinLocY(int i) {
        if(!mInOverScrollMode)
            i = pinLoc(i, getViewHeightWithTitle(), computeRealVerticalScrollRange() + getTitleHeight());
        return i;
    }

    public void postUrl(String s, byte abyte0[]) {
        if(URLUtil.isNetworkUrl(s)) {
            switchOutDrawHistory();
            WebViewCore.PostUrlData posturldata = new WebViewCore.PostUrlData();
            posturldata.mUrl = s;
            posturldata.mPostData = abyte0;
            mWebViewCore.sendMessage(132, posturldata);
            clearHelpers();
        } else {
            loadUrlImpl(s);
        }
    }

    public void refreshPlugins(boolean flag) {
    }

    public void reload() {
        clearHelpers();
        switchOutDrawHistory();
        mWebViewCore.sendMessage(102);
    }

    public void removeJavascriptInterface(String s) {
        if(mWebViewCore != null) {
            WebViewCore.JSInterfaceData jsinterfacedata = new WebViewCore.JSInterfaceData();
            jsinterfacedata.mInterfaceName = s;
            mWebViewCore.sendMessage(149, jsinterfacedata);
        }
    }

    void replaceTextfieldText(int i, int j, String s, int k, int l) {
        WebViewCore.ReplaceTextData replacetextdata = new WebViewCore.ReplaceTextData();
        replacetextdata.mReplace = s;
        replacetextdata.mNewStart = k;
        replacetextdata.mNewEnd = l;
        mTextGeneration = 1 + mTextGeneration;
        replacetextdata.mTextGeneration = mTextGeneration;
        sendBatchableInputMessage(114, i, j, replacetextdata);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean flag) {
        if(mNativeClass != 0) goto _L2; else goto _L1
_L1:
        boolean flag1 = false;
_L8:
        return flag1;
_L2:
        if(!mZoomManager.isFixedLengthAnimationInProgress()) goto _L4; else goto _L3
_L3:
        flag1 = false;
          goto _L5
_L4:
        int i1;
        int j1;
        int l1;
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        Rect rect1 = new Rect(viewToContentX(getScrollX()), viewToContentY(getScrollY()), viewToContentX((getScrollX() + getWidth()) - mWebView.getVerticalScrollbarWidth()), viewToContentY(getScrollY() + getViewHeightWithTitle()));
        int i = contentToViewY(rect1.top);
        int j = contentToViewY(rect1.bottom);
        int k = j - i;
        int l = 0;
        if(rect.bottom > j) {
            int i2 = k / 3;
            int k1;
            if(rect.height() > i2 * 2)
                l = rect.top - i;
            else
                l = rect.top - (i + i2);
        } else
        if(rect.top < i)
            l = rect.top - i;
        i1 = contentToViewX(rect1.left);
        j1 = contentToViewX(rect1.right);
        k1 = j1 - i1;
        l1 = 0;
        if(rect.right <= j1 || rect.left <= i1) goto _L7; else goto _L6
_L6:
        if(rect.width() > k1)
            l1 = 0 + (rect.left - i1);
        else
            l1 = 0 + (rect.right - j1);
_L9:
        if((l | l1) != 0) {
            boolean flag2;
            if(!flag)
                flag2 = true;
            else
                flag2 = false;
            flag1 = pinScrollBy(l1, l, flag2, 0);
        } else {
            flag1 = false;
        }
_L5:
        if(true) goto _L8; else goto _L7
_L7:
        if(rect.left < i1)
            l1 = 0 - (i1 - rect.left);
          goto _L9
    }

    public boolean requestFocus(int i, Rect rect) {
        if(!mFindIsUp) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = mWebViewPrivate.super_requestFocus(i, rect);
        if(!mWebViewCore.getSettings().getNeedInitialFocus() || mWebView.isInTouchMode()) goto _L4; else goto _L3
_L3:
        i;
        JVM INSTR lookupswitch 4: default 88
    //                   17: 91
    //                   33: 110
    //                   66: 124
    //                   130: 117;
           goto _L4 _L5 _L6 _L7 _L8
_L5:
        byte byte0 = 21;
_L9:
        mWebViewCore.sendMessage(224, byte0);
          goto _L4
_L6:
        byte0 = 19;
          goto _L9
_L8:
        byte0 = 20;
          goto _L9
_L7:
        byte0 = 22;
          goto _L9
    }

    public void requestFocusNodeHref(Message message) {
        if(message != null) {
            int i = viewToContentX(mLastTouchX + getScrollX());
            int j = viewToContentY(mLastTouchY + getScrollY());
            if(mFocusedNode != null && mFocusedNode.mHitTestX == i && mFocusedNode.mHitTestY == j) {
                message.getData().putString("url", mFocusedNode.mLinkUrl);
                message.getData().putString("title", mFocusedNode.mAnchorText);
                message.getData().putString("src", mFocusedNode.mImageUrl);
                message.sendToTarget();
            } else {
                mWebViewCore.sendMessage(137, i, j, message);
            }
        }
    }

    void requestFormData(String s, int i, boolean flag, boolean flag1) {
        if(mWebViewCore.getSettings().getSaveFormData()) {
            Message message = mPrivateHandler.obtainMessage(6);
            message.arg1 = i;
            (new Thread(new RequestFormData(s, getUrl(), message, flag, flag1))).start();
        }
    }

    public void requestImageRef(Message message) {
        if(mNativeClass != 0) {
            String s;
            Bundle bundle;
            if(mFocusedNode != null)
                s = mFocusedNode.mImageUrl;
            else
                s = null;
            bundle = message.getData();
            bundle.putString("url", s);
            message.setData(bundle);
            message.sendToTarget();
        }
    }

    void requestListBox(String as[], int ai[], int i) {
        mPrivateHandler.post(new InvokeListBox(as, ai, i));
    }

    void requestListBox(String as[], int ai[], int ai1[]) {
        mPrivateHandler.post(new InvokeListBox(as, ai, ai1));
    }

    void resetTrackballTime() {
        mTrackballLastTime = 0L;
    }

    public boolean restorePicture(Bundle bundle, File file) {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        if(file != null && bundle != null && file.exists()) {
            try {
                (new Thread(new Runnable() {

                    public void run() {
                        final Picture p = Picture.createFromStream(in);
                        if(p != null)
                            mPrivateHandler.post(new Runnable() {

                                public void run() {
                                    restoreHistoryPictureFields(p, copy);
                                }

                                final _cls7 this$1;
                                final Picture val$p;

                     {
                        this$1 = _cls7.this;
                        p = picture;
                        super();
                    }
                            });
                        in.close();
_L2:
                        return;
                        Exception exception;
                        exception;
                        Exception exception2;
                        try {
                            in.close();
                        }
                        catch(Exception exception1) { }
                        throw exception;
                        exception2;
                        if(true) goto _L2; else goto _L1
_L1:
                    }

                    final WebViewClassic this$0;
                    final Bundle val$copy;
                    final FileInputStream val$in;

             {
                this$0 = WebViewClassic.this;
                in = fileinputstream;
                copy = bundle;
                super();
            }
                })).start();
            }
            catch(FileNotFoundException filenotfoundexception) {
                filenotfoundexception.printStackTrace();
            }
            flag = true;
        }
        return flag;
    }

    public WebBackForwardList restoreState(Bundle bundle) {
        WebBackForwardList webbackforwardlist;
        WebBackForwardList webbackforwardlist1;
        webbackforwardlist = null;
        webbackforwardlist1 = null;
        if(bundle != null) goto _L2; else goto _L1
_L1:
        webbackforwardlist = null;
_L5:
        return webbackforwardlist;
_L2:
        WebBackForwardList webbackforwardlist2;
        if(!bundle.containsKey("index") || !bundle.containsKey("history"))
            break MISSING_BLOCK_LABEL_226;
        mCertificate = SslCertificate.restoreState(bundle.getBundle("certificate"));
        webbackforwardlist2 = mCallbackProxy.getBackForwardList();
        int i = bundle.getInt("index");
        webbackforwardlist2;
        JVM INSTR monitorenter ;
        List list;
        int j;
        list = (List)bundle.getSerializable("history");
        j = list.size();
        if(i < 0 || i >= j)
            continue; /* Loop/switch isn't completed */
        break MISSING_BLOCK_LABEL_114;
        Exception exception;
        exception;
        throw exception;
        int k = 0;
_L3:
        if(k >= j)
            break MISSING_BLOCK_LABEL_168;
        byte abyte0[];
        abyte0 = (byte[])list.remove(0);
        if(abyte0 != null)
            break MISSING_BLOCK_LABEL_148;
        webbackforwardlist2;
        JVM INSTR monitorexit ;
        continue; /* Loop/switch isn't completed */
        webbackforwardlist2.addHistoryItem(new WebHistoryItem(abyte0));
        k++;
          goto _L3
        webbackforwardlist1 = copyBackForwardList();
        webbackforwardlist1.setCurrentIndex(i);
        webbackforwardlist2;
        JVM INSTR monitorexit ;
        if(bundle.getBoolean("privateBrowsingEnabled"))
            getSettings().setPrivateBrowsingEnabled(true);
        mZoomManager.restoreZoomState(bundle);
        mWebViewCore.removeMessages();
        mWebViewCore.sendMessage(108, i);
        webbackforwardlist = webbackforwardlist1;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public void resumeTimers() {
        mWebViewCore.sendMessage(110);
    }

    public void savePassword(String s, String s1, String s2) {
        mDatabase.setUsernamePassword(s, s1, s2);
    }

    public boolean savePicture(Bundle bundle, File file) {
        boolean flag;
        if(file == null || bundle == null) {
            flag = false;
        } else {
            Picture picture = capturePicture();
            (new Thread(new Runnable() {

                public void run() {
                    FileOutputStream fileoutputstream = null;
                    FileOutputStream fileoutputstream1 = new FileOutputStream(temp);
                    p.writeToStream(fileoutputstream1);
                    temp.renameTo(dest);
                    Exception exception2;
                    Exception exception1;
                    Exception exception3;
                    Exception exception5;
                    if(fileoutputstream1 != null)
                        try {
                            fileoutputstream1.close();
                        }
                        catch(Exception exception4) { }
                    temp.delete();
                    return;
                    exception2;
_L1:
                    if(fileoutputstream != null)
                        try {
                            fileoutputstream.close();
                        }
                        // Misplaced declaration of an exception variable
                        catch(Exception exception3) { }
                    temp.delete();
                    throw exception2;
                    exception5;
_L2:
                    if(fileoutputstream != null)
                        try {
                            fileoutputstream.close();
                        }
                        // Misplaced declaration of an exception variable
                        catch(Exception exception1) { }
                    temp.delete();
                    break MISSING_BLOCK_LABEL_50;
                    exception2;
                    fileoutputstream = fileoutputstream1;
                      goto _L1
                    Exception exception;
                    exception;
                    fileoutputstream = fileoutputstream1;
                      goto _L2
                }

                final WebViewClassic this$0;
                final File val$dest;
                final Picture val$p;
                final File val$temp;

             {
                this$0 = WebViewClassic.this;
                temp = file;
                p = picture;
                dest = file1;
                super();
            }
            })).start();
            bundle.putInt("scrollX", getScrollX());
            bundle.putInt("scrollY", getScrollY());
            mZoomManager.saveZoomState(bundle);
            flag = true;
        }
        return flag;
    }

    public WebBackForwardList saveState(Bundle bundle) {
        if(bundle != null) goto _L2; else goto _L1
_L1:
        WebBackForwardList webbackforwardlist = null;
_L4:
        return webbackforwardlist;
_L2:
        webbackforwardlist = copyBackForwardList();
        int i = webbackforwardlist.getCurrentIndex();
        int j = webbackforwardlist.getSize();
        if(i < 0 || i >= j || j == 0) {
            webbackforwardlist = null;
            continue; /* Loop/switch isn't completed */
        }
        bundle.putInt("index", i);
        ArrayList arraylist = new ArrayList(j);
        int k = 0;
        do {
            if(k >= j)
                break;
            WebHistoryItem webhistoryitem = webbackforwardlist.getItemAtIndex(k);
            if(webhistoryitem == null) {
                Log.w("webview", "saveState: Unexpected null history item.");
                webbackforwardlist = null;
                continue; /* Loop/switch isn't completed */
            }
            byte abyte0[] = webhistoryitem.getFlattenedData();
            if(abyte0 == null) {
                webbackforwardlist = null;
                continue; /* Loop/switch isn't completed */
            }
            arraylist.add(abyte0);
            k++;
        } while(true);
        bundle.putSerializable("history", arraylist);
        if(mCertificate != null)
            bundle.putBundle("certificate", SslCertificate.saveState(mCertificate));
        bundle.putBoolean("privateBrowsingEnabled", isPrivateBrowsingEnabled());
        mZoomManager.saveZoomState(bundle);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void saveViewState(OutputStream outputstream, ValueCallback valuecallback) {
        if(mWebViewCore == null)
            valuecallback.onReceiveValue(Boolean.valueOf(false));
        else
            mWebViewCore.sendMessageAtFrontOfQueue(225, new WebViewCore.SaveViewStateRequest(outputstream, valuecallback));
    }

    public void saveWebArchive(String s) {
        saveWebArchiveImpl(s, false, null);
    }

    public void saveWebArchive(String s, boolean flag, ValueCallback valuecallback) {
        saveWebArchiveImpl(s, flag, valuecallback);
    }

    public void selectAll() {
        mWebViewCore.sendMessage(215);
    }

    public boolean selectText() {
        return selectText(viewToContentX(mLastTouchX + getScrollX()), viewToContentY(mLastTouchY + getScrollY()));
    }

    boolean selectText(int i, int j) {
        boolean flag;
        if(mWebViewCore == null) {
            flag = false;
        } else {
            mWebViewCore.sendMessage(214, i, j);
            flag = true;
        }
        return flag;
    }

    void selectionDone() {
        if(mSelectingText) {
            hideFloatView();
            hidePasteButton();
            endSelectingText();
            invalidate();
            mAutoScrollX = 0;
            mAutoScrollY = 0;
            mSentAutoScrollMessage = false;
        }
    }

    void sendBatchableInputMessage(int i, int j, int k, Object obj) {
        if(mWebViewCore != null) {
            Message message = Message.obtain(null, i, j, k, obj);
            if(mIsBatchingTextChanges)
                mBatchedTextChanges.add(message);
            else
                mWebViewCore.sendMessage(message);
        }
    }

    Rect sendOurVisibleRect() {
        Rect rect;
        if(mZoomManager.isPreventingWebkitUpdates()) {
            rect = mLastVisibleRectSent;
        } else {
            calcOurContentVisibleRect(mVisibleRect);
            if(!mVisibleRect.equals(mLastVisibleRectSent)) {
                if(!mBlockWebkitViewMessages) {
                    mScrollOffset.set(mVisibleRect.left, mVisibleRect.top);
                    mWebViewCore.removeMessages(107);
                    WebViewCore webviewcore = mWebViewCore;
                    int i;
                    if(mSendScrollEvent)
                        i = 1;
                    else
                        i = 0;
                    webviewcore.sendMessage(107, i, mScrollOffset);
                }
                mLastVisibleRectSent.set(mVisibleRect);
                mPrivateHandler.removeMessages(4);
            }
            if(mWebView.getGlobalVisibleRect(mGlobalVisibleRect) && !mGlobalVisibleRect.equals(mLastGlobalRect)) {
                if(!mBlockWebkitViewMessages)
                    mWebViewCore.sendMessage(116, mGlobalVisibleRect);
                mLastGlobalRect.set(mGlobalVisibleRect);
            }
            rect = mVisibleRect;
        }
        return rect;
    }

    boolean sendViewSizeZoom(boolean flag) {
        boolean flag1;
        flag1 = false;
        break MISSING_BLOCK_LABEL_2;
        while(true)  {
            do
                return flag1;
            while(mBlockWebkitViewMessages || mZoomManager.isPreventingWebkitUpdates());
            int i = getViewWidth();
            int j = Math.round((float)i * mZoomManager.getInvScale());
            int k = getViewHeightWithTitle() - getTitleHeight();
            int l = Math.round((float)k * mZoomManager.getInvScale());
            float f = (float)k / (float)i;
            if(j > mLastWidthSent && mWrapContent) {
                l = 0;
                f = 0.0F;
            }
            int i1 = Math.round((float)getViewHeight() * mZoomManager.getInvScale());
            if(j != mLastWidthSent || l != mLastHeightSent || flag || i1 != mLastActualHeightSent) {
                ViewSizeData viewsizedata = new ViewSizeData();
                viewsizedata.mWidth = j;
                viewsizedata.mHeight = l;
                viewsizedata.mHeightWidthRatio = f;
                viewsizedata.mActualViewHeight = i1;
                viewsizedata.mTextWrapWidth = Math.round((float)i / mZoomManager.getTextWrapScale());
                viewsizedata.mScale = mZoomManager.getScale();
                if(mZoomManager.isFixedLengthAnimationInProgress() && !mHeightCanMeasure)
                    flag1 = true;
                viewsizedata.mIgnoreHeight = flag1;
                viewsizedata.mAnchorX = mZoomManager.getDocumentAnchorX();
                viewsizedata.mAnchorY = mZoomManager.getDocumentAnchorY();
                mWebViewCore.sendMessage(105, viewsizedata);
                mLastWidthSent = j;
                mLastHeightSent = l;
                mLastActualHeightSent = i1;
                mZoomManager.clearDocumentAnchor();
                flag1 = true;
            }
        }
    }

    void setActive(boolean flag) {
        if(flag) {
            if(mWebView.hasFocus()) {
                mDrawCursorRing = true;
                setFocusControllerActive(true);
            } else {
                mDrawCursorRing = false;
                setFocusControllerActive(false);
            }
        } else {
            if(!mZoomManager.isZoomPickerVisible())
                mDrawCursorRing = false;
            mKeysPressed.clear();
            mPrivateHandler.removeMessages(4);
            mTouchMode = 7;
            setFocusControllerActive(false);
        }
        invalidate();
    }

    public void setBackgroundColor(int i) {
        mBackgroundColor = i;
        mWebViewCore.sendMessage(126, i);
    }

    void setBaseLayer(int i, boolean flag, boolean flag1) {
        if(mNativeClass != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int j;
        if(mTouchMode == 9)
            j = mCurrentScrollingLayerId;
        else
            j = 0;
        if(nativeSetBaseLayer(mNativeClass, i, flag, flag1, j))
            mWebViewCore.pauseWebKitDraw();
        else
            mWebViewCore.resumeWebKitDraw();
        if(mHTML5VideoViewProxy != null)
            mHTML5VideoViewProxy.setBaseLayer(i);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void setCertificate(SslCertificate sslcertificate) {
        mCertificate = sslcertificate;
    }

    public void setDownloadListener(DownloadListener downloadlistener) {
        mCallbackProxy.setDownloadListener(downloadlistener);
    }

    public void setFindListener(WebView.FindListener findlistener) {
        mFindListener = findlistener;
    }

    void setFocusControllerActive(boolean flag) {
        if(mWebViewCore != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        WebViewCore webviewcore = mWebViewCore;
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        webviewcore.sendMessage(142, i, 0);
        if(flag && mListBoxMessage != null) {
            mWebViewCore.sendMessage(mListBoxMessage);
            mListBoxMessage = null;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean setFrame(int i, int j, int k, int l) {
        boolean flag = mWebViewPrivate.super_setFrame(i, j, k, l);
        if(!flag && mHeightCanMeasure)
            sendViewSizeZoom(false);
        updateRectsForGL();
        return flag;
    }

    public void setHTML5VideoViewProxy(HTML5VideoViewProxy html5videoviewproxy) {
        mHTML5VideoViewProxy = html5videoviewproxy;
    }

    public void setHorizontalScrollbarOverlay(boolean flag) {
        mOverlayHorizontalScrollbar = flag;
    }

    public void setHttpAuthUsernamePassword(String s, String s1, String s2, String s3) {
        mDatabase.setHttpAuthUsernamePassword(s, s1, s2, s3);
    }

    public void setInitialScale(int i) {
        mZoomManager.setInitialScaleInPercent(i);
    }

    public void setJsFlags(String s) {
        mWebViewCore.sendMessage(174, s);
    }

    public void setLayerType(int i, Paint paint) {
        updateHwAccelerated();
    }

    public void setLayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
        if(layoutparams.height == -2)
            mWrapContent = true;
        mWebViewPrivate.super_setLayoutParams(layoutparams);
    }

    public void setMapTrackballToArrowKeys(boolean flag) {
        mMapTrackballToArrowKeys = flag;
    }

    public void setMockDeviceOrientation(boolean flag, double d, boolean flag1, double d1, boolean flag2, 
            double d2) {
        mWebViewCore.setMockDeviceOrientation(flag, d, flag1, d1, flag2, d2);
    }

    public void setNetworkAvailable(boolean flag) {
        WebViewCore webviewcore = mWebViewCore;
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        webviewcore.sendMessage(119, i, 0);
    }

    public void setNetworkType(String s, String s1) {
        HashMap hashmap = new HashMap();
        hashmap.put("type", s);
        hashmap.put("subtype", s1);
        mWebViewCore.sendMessage(183, hashmap);
    }

    void setNewPicture(WebViewCore.DrawData drawdata, boolean flag) {
        boolean flag1 = false;
        if(mNativeClass != 0) goto _L2; else goto _L1
_L1:
        if(mDelaySetPicture != null)
            throw new IllegalStateException("Tried to setNewPicture with a delay picture already set! (memory leak)");
        mDelaySetPicture = drawdata;
_L4:
        return;
_L2:
        WebViewCore.ViewState viewstate = drawdata.mViewState;
        boolean flag2;
        Point point;
        boolean flag3;
        if(viewstate != null)
            flag2 = true;
        else
            flag2 = false;
        if(flag)
            setBaseLayer(drawdata.mBaseLayer, getSettings().getShowVisualIndicator(), flag2);
        point = drawdata.mViewSize;
        if(point.x == mLastWidthSent && point.y == mLastHeightSent)
            flag3 = true;
        else
            flag3 = false;
        mSendScrollEvent = false;
        recordNewContentSize(drawdata.mContentSize.x, drawdata.mContentSize.y, flag3);
        if(flag2) {
            mLastWidthSent = 0;
            mZoomManager.onFirstLayout(drawdata);
            int i;
            boolean flag4;
            ViewRootImpl viewrootimpl;
            int j;
            if(viewstate.mShouldStartScrolledRight)
                j = getContentWidth();
            else
                j = viewstate.mScrollX;
            contentScrollTo(j, viewstate.mScrollY, false);
            if(!mDrawHistory)
                hideSoftKeyboard();
        }
        mSendScrollEvent = true;
        i = 0;
        flag4 = flag2;
        viewrootimpl = mWebView.getViewRootImpl();
        if(mWebView.isHardwareAccelerated() && viewrootimpl != null) {
            i = nativeGetDrawGLFunction(mNativeClass);
            if(i != 0) {
                if(!viewrootimpl.attachFunctor(i))
                    flag1 = true;
                flag4 |= flag1;
            }
        }
        if(i == 0 || flag4 || mWebView.getLayerType() != 0)
            mWebView.invalidate();
        if(mZoomManager.onNewPicture(drawdata))
            invalidate();
        if(flag2)
            mViewManager.postReadyToDrawAll();
        scrollEditWithCursor();
        if(mPictureListener != null && (!mWebView.isHardwareAccelerated() || mWebView.getLayerType() == 1))
            mPictureListener.onNewPicture(getWebView(), capturePicture());
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void setOverScrollMode(int i) {
        if(i != 2) {
            if(mOverScrollGlow == null)
                mOverScrollGlow = new OverScrollGlow(this);
        } else {
            mOverScrollGlow = null;
        }
    }

    public void setPictureListener(WebView.PictureListener picturelistener) {
        mPictureListener = picturelistener;
    }

    public void setScrollBarStyle(int i) {
        if(i == 0x1000000 || i == 0x3000000) {
            mOverlayVerticalScrollbar = false;
            mOverlayHorizontalScrollbar = false;
        } else {
            mOverlayVerticalScrollbar = true;
            mOverlayHorizontalScrollbar = true;
        }
    }

    void setScrollXRaw(int i) {
        mWebViewPrivate.setScrollXRaw(i);
    }

    void setScrollYRaw(int i) {
        mWebViewPrivate.setScrollYRaw(i);
    }

    void setSelection(int i, int j) {
        if(mWebViewCore != null)
            mWebViewCore.sendMessage(113, i, j);
    }

    public void setTouchInterval(int i) {
        mCurrentTouchInterval = i;
    }

    public void setUseMockDeviceOrientation() {
        mWebViewCore.sendMessage(191);
    }

    public void setVerticalScrollbarOverlay(boolean flag) {
        mOverlayVerticalScrollbar = flag;
    }

    public void setWebBackForwardListClient(WebBackForwardListClient webbackforwardlistclient) {
        mCallbackProxy.setWebBackForwardListClient(webbackforwardlistclient);
    }

    public void setWebChromeClient(WebChromeClient webchromeclient) {
        mCallbackProxy.setWebChromeClient(webchromeclient);
    }

    public void setWebViewClient(WebViewClient webviewclient) {
        mCallbackProxy.setWebViewClient(webviewclient);
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public boolean showFindDialog(String s, boolean flag) {
        boolean flag1;
        FindActionModeCallback findactionmodecallback;
        flag1 = true;
        findactionmodecallback = new FindActionModeCallback(mContext);
        if(mWebView.getParent() != null && mWebView.startActionMode(findactionmodecallback) != null) goto _L2; else goto _L1
_L1:
        flag1 = false;
_L8:
        return flag1;
_L2:
        mCachedOverlappingActionModeHeight = -1;
        mFindCallback = findactionmodecallback;
        setFindIsUp(flag1);
        mFindCallback.setWebView(this);
        if(!flag) goto _L4; else goto _L3
_L3:
        mFindCallback.showSoftInput();
_L6:
        if(s == null)
            if(mFindRequest == null)
                s = null;
            else
                s = mFindRequest.mSearchText;
        if(s != null) {
            mFindCallback.setText(s);
            mFindCallback.findAll();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if(s == null) goto _L6; else goto _L5
_L5:
        mFindCallback.setText(s);
        mFindCallback.findAll();
        if(true) goto _L8; else goto _L7
_L7:
    }

    public void stopLoading() {
        switchOutDrawHistory();
        mWebViewCore.sendMessage(101);
    }

    public void stopScroll() {
        mScroller.forceFinished(true);
        mLastVelocity = 0.0F;
    }

    void switchOutDrawHistory() {
        if(mWebViewCore != null && mDrawHistory && (getProgress() == 100 || nativeHasContent())) {
            mDrawHistory = false;
            mHistoryPicture = null;
            invalidate();
            int i = getScrollX();
            int j = getScrollY();
            setScrollXRaw(pinLocX(getScrollX()));
            setScrollYRaw(pinLocY(getScrollY()));
            if(i != getScrollX() || j != getScrollY())
                mWebViewPrivate.onScrollChanged(getScrollX(), getScrollY(), i, j);
            else
                sendOurVisibleRect();
        }
    }

    public void tileProfilingClear() {
        nativeTileProfilingClear();
    }

    public float tileProfilingGetFloat(int i, int j, String s) {
        return nativeTileProfilingGetFloat(i, j, s);
    }

    public int tileProfilingGetInt(int i, int j, String s) {
        return nativeTileProfilingGetInt(i, j, s);
    }

    public int tileProfilingNumFrames() {
        return nativeTileProfilingNumFrames();
    }

    public int tileProfilingNumTilesInFrame(int i) {
        return nativeTileProfilingNumTilesInFrame(i);
    }

    public void tileProfilingStart() {
        nativeTileProfilingStart();
    }

    public float tileProfilingStop() {
        return nativeTileProfilingStop();
    }

    void updateDefaultZoomDensity(float f) {
        mNavSlop = (int)(16F * f);
        mZoomManager.updateDefaultZoomDensity(f);
    }

    void updateDoubleTapZoom(int i) {
        mZoomManager.updateDoubleTapZoom(i);
    }

    void updateDrawingState() {
        if(mNativeClass != 0 && !mIsPaused)
            if(mWebView.getWindowVisibility() != 0)
                nativeSetPauseDrawing(mNativeClass, true);
            else
            if(mWebView.getVisibility() != 0)
                nativeSetPauseDrawing(mNativeClass, true);
            else
                nativeSetPauseDrawing(mNativeClass, false);
    }

    void updateMultiTouchSupport(Context context) {
        mZoomManager.updateMultiTouchSupport(context);
    }

    void updateRectsForGL() {
        boolean flag = mWebView.getGlobalVisibleRect(mTempVisibleRect, mTempVisibleRectOffset);
        mInvScreenRect.set(mTempVisibleRect);
        int i;
        Rect rect;
        Rect rect1;
        if(flag) {
            int j = mWebView.getRootView().getHeight();
            mScreenRect.set(mInvScreenRect);
            int k = mInvScreenRect.bottom;
            mInvScreenRect.bottom = j - mInvScreenRect.top - getVisibleTitleHeightImpl();
            mInvScreenRect.top = j - k;
            mIsWebViewVisible = true;
        } else {
            mIsWebViewVisible = false;
        }
        mTempVisibleRect.offset(-mTempVisibleRectOffset.x, -mTempVisibleRectOffset.y);
        viewToContentVisibleRect(mVisibleContentRect, mTempVisibleRect);
        i = mNativeClass;
        if(mIsWebViewVisible)
            rect = mInvScreenRect;
        else
            rect = null;
        if(mIsWebViewVisible)
            rect1 = mScreenRect;
        else
            rect1 = null;
        nativeUpdateDrawGLFunction(i, rect, rect1, mVisibleContentRect, getScale());
    }

    boolean updateScrollCoordinates(int i, int j) {
        int k = getScrollX();
        int l = getScrollY();
        setScrollXRaw(i);
        setScrollYRaw(j);
        boolean flag;
        if(k != getScrollX() || l != getScrollY()) {
            mWebViewPrivate.onScrollChanged(getScrollX(), getScrollY(), k, l);
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    int viewToContentX(int i) {
        return viewToContentDimension(i);
    }

    int viewToContentY(int i) {
        return viewToContentDimension(i - getTitleHeight());
    }

    public boolean zoomIn() {
        return mZoomManager.zoomIn();
    }

    public boolean zoomOut() {
        return mZoomManager.zoomOut();
    }

    private static final float ANGLE_HORIZ = 0F;
    private static final float ANGLE_VERT = 2F;
    static final int AUTOFILL_COMPLETE = 134;
    static final int AUTOFILL_FORM = 148;
    private static final boolean AUTO_REDRAW_HACK = false;
    private static final long CARET_HANDLE_STAMINA_MS = 3000L;
    static final int CENTER_FIT_RECT = 127;
    static final int CLEAR_CARET_HANDLE = 144;
    static final int CLEAR_TEXT_ENTRY = 111;
    static final int COPY_TO_CLIPBOARD = 141;
    private static final boolean DEBUG_TOUCH_HIGHLIGHT = true;
    static final int DEFAULT_VIEWPORT_WIDTH = 980;
    private static final int DRAG_HELD_MOTIONLESS = 8;
    private static final int DRAG_LAYER_FINGER_DISTANCE = 20000;
    private static final int DRAW_EXTRAS_CURSOR_RING = 2;
    private static final int DRAW_EXTRAS_NONE = 0;
    private static final int DRAW_EXTRAS_SELECTION = 1;
    private static final int EDIT_RECT_BUFFER = 10;
    static final int EDIT_TEXT_SIZE_CHANGED = 150;
    static final int ENTER_FULLSCREEN_VIDEO = 137;
    static final int EXIT_FULLSCREEN_VIDEO = 140;
    private static final int FIRST_PACKAGE_MSG_ID = 101;
    private static final int FIRST_PRIVATE_MSG_ID = 1;
    static final int FOCUS_NODE_CHANGED = 147;
    static final int HANDLE_ID_LEFT = 0;
    static final int HANDLE_ID_RIGHT = 1;
    static final int HIDE_FULLSCREEN = 121;
    static final int HIGHLIGHT_COLOR = 0x6633b5e5;
    static final int HIT_TEST_RESULT = 131;
    private static final float HSLOPE_TO_BREAK_SNAP = 0.4F;
    private static final float HSLOPE_TO_START_SNAP = 0.25F;
    static final String HandlerPackageDebugString[];
    static final String HandlerPrivateDebugString[];
    static final int INIT_EDIT_FIELD = 142;
    static final int INVAL_RECT_MSG_ID = 117;
    static final int KEY_PRESS = 145;
    private static final int LAST_PACKAGE_MSG_ID = 131;
    private static final int LAST_PRIVATE_MSG_ID = 11;
    static final String LOGTAG = "webview";
    static final int LONG_PRESS_CENTER = 114;
    private static final int LONG_PRESS_TIMEOUT = 1000;
    private static final int MAX_DURATION = 750;
    private static final float MINIMUM_VELOCITY_RATIO_FOR_ACCELERATION = 0.2F;
    private static final int MIN_FLING_TIME = 250;
    private static final float MMA_WEIGHT_N = 5F;
    private static final int MOTIONLESS_FALSE = 0;
    private static final int MOTIONLESS_IGNORE = 3;
    private static final int MOTIONLESS_PENDING = 1;
    private static final int MOTIONLESS_TIME = 100;
    private static final int MOTIONLESS_TRUE = 2;
    private static final int NEVER_REMEMBER_PASSWORD = 2;
    static final int NEW_PICTURE_MSG_ID = 105;
    static final int NO_LEFTEDGE = -1;
    private static final int PAGE_SCROLL_OVERLAP = 24;
    private static final int PREVENT_DEFAULT_TIMEOUT = 10;
    static final int PREVENT_TOUCH_ID = 115;
    private static final int RELEASE_SINGLE_TAP = 5;
    static final int RELOCATE_AUTO_COMPLETE_POPUP = 146;
    private static final int REMEMBER_PASSWORD = 1;
    static final int REPLACE_TEXT = 143;
    private static final int REQUEST_FORM_DATA = 6;
    static final int REQUEST_KEYBOARD = 118;
    static final int SAVE_WEBARCHIVE_FINISHED = 132;
    public static final String SCHEME_GEO = "geo:0,0?q=";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_TEL = "tel:";
    static final int SCREEN_ON = 136;
    private static final int SCROLLBAR_ALWAYSOFF = 1;
    private static final int SCROLLBAR_ALWAYSON = 2;
    private static final int SCROLLBAR_AUTO = 0;
    private static final int SCROLL_BITS = 6;
    static final int SCROLL_EDIT_TEXT = 149;
    private static final int SCROLL_SELECT_TEXT = 11;
    static final int SCROLL_TO_MSG_ID = 101;
    static final int SELECTION_STRING_CHANGED = 130;
    private static final int SELECT_CURSOR_OFFSET = 16;
    private static final int SELECT_SCROLL = 5;
    private static final long SELECT_SCROLL_INTERVAL = 16L;
    static final int SET_AUTOFILLABLE = 133;
    static final int SET_SCROLLBAR_MODES = 129;
    static final int SHOW_CARET_HANDLE = 151;
    static final int SHOW_FULLSCREEN = 120;
    static final int SHOW_MAGNIFIER = 5000;
    static final int SHOW_RECT_MSG_ID = 113;
    private static final int SNAP_LOCK = 1;
    private static final int SNAP_NONE = 0;
    private static final int SNAP_X = 2;
    private static final int SNAP_Y = 4;
    private static final int STD_SPEED = 480;
    static final int SWITCH_READ_MODE = 5001;
    private static final int SWITCH_TO_LONGPRESS = 4;
    private static final int SWITCH_TO_SHORTPRESS = 3;
    static final int TAKE_FOCUS = 110;
    private static final int TAP_TIMEOUT = 300;
    private static final long TEXT_SCROLL_FIRST_SCROLL_MS = 16L;
    private static final float TEXT_SCROLL_RATE = 0.01F;
    private static final int TOUCH_DONE_MODE = 7;
    private static final int TOUCH_DOUBLE_TAP_MODE = 6;
    private static final int TOUCH_DRAG_LAYER_MODE = 9;
    private static final int TOUCH_DRAG_MODE = 3;
    private static final int TOUCH_DRAG_START_MODE = 2;
    private static final int TOUCH_DRAG_TEXT_MODE = 10;
    private static final int TOUCH_HIGHLIGHT_ELAPSE_TIME = 2000;
    private static final int TOUCH_INIT_MODE = 1;
    private static final int TOUCH_PINCH_DRAG = 8;
    private static final int TOUCH_SENT_INTERVAL = 0;
    private static final int TOUCH_SHORTPRESS_MODE = 5;
    private static final int TOUCH_SHORTPRESS_START_MODE = 4;
    private static final int TRACKBALL_KEY_TIMEOUT = 1000;
    private static final int TRACKBALL_MOVE_COUNT = 10;
    private static final int TRACKBALL_MULTIPLIER = 3;
    private static final int TRACKBALL_SCALE = 400;
    private static final int TRACKBALL_SCROLL_COUNT = 5;
    private static final int TRACKBALL_TIMEOUT = 200;
    private static final int TRACKBALL_WAIT = 100;
    static final int UPDATE_CONTENT_BOUNDS = 152;
    static final int UPDATE_MATCH_COUNT = 126;
    static final int UPDATE_TEXTFIELD_TEXT_MSG_ID = 108;
    static final int UPDATE_TEXT_SELECTION_MSG_ID = 112;
    static final int UPDATE_ZOOM_DENSITY = 139;
    static final int UPDATE_ZOOM_RANGE = 109;
    private static final float VSLOPE_TO_BREAK_SNAP = 0.95F;
    private static final float VSLOPE_TO_START_SNAP = 1.25F;
    static final int WEBCORE_INITIALIZED_MSG_ID = 107;
    static final int WEBCORE_NEED_TOUCH_EVENTS = 116;
    private static final int ZOOM_BITS = 134;
    static boolean mLogEvent = true;
    private static Paint mOverScrollBackground;
    private static Paint mOverScrollBorder;
    private static Set sGoogleApps;
    static int sMaxViewportWidth = 980;
    private static boolean sNotificationsEnabled = true;
    private static boolean sPackageInstallationReceiverAdded = false;
    private static ProxyReceiver sProxyReceiver;
    private static TrustStorageListener sTrustStorageListener;
    private float DRAG_LAYER_INVERSE_DENSITY_SQUARED;
    private AccessibilityInjector mAccessibilityInjector;
    private String mAfterStart;
    private AutoCompletePopup mAutoCompletePopup;
    private WebViewCore.AutoFillData mAutoFillData;
    private boolean mAutoRedraw;
    private int mAutoScrollX;
    private int mAutoScrollY;
    private float mAverageAngle;
    double mAverageSwapFps;
    private int mBackgroundColor;
    ArrayList mBatchedTextChanges;
    private String mBeforeStart;
    private boolean mBlockWebkitViewMessages;
    private int mCachedOverlappingActionModeHeight;
    private CallbackProxy mCallbackProxy;
    private SslCertificate mCertificate;
    private boolean mConfirmMove;
    private int mContentHeight;
    private int mContentWidth;
    private final Context mContext;
    private SelectionFloatPanel mCopyFloatPanel;
    private int mCurrentScrollingLayerId;
    private int mCurrentTouchInterval;
    private WebViewDatabaseClassic mDatabase;
    private WebViewCore.DrawData mDelaySetPicture;
    private int mDoubleTapSlopSquare;
    private boolean mDrawCursorRing;
    private boolean mDrawHistory;
    Rect mEditTextContent;
    Rect mEditTextContentBounds;
    int mEditTextLayerId;
    Scroller mEditTextScroller;
    private int mFieldPointer;
    private FindActionModeCallback mFindCallback;
    private boolean mFindIsUp;
    private WebView.FindListener mFindListener;
    private WebViewCore.FindAllRequest mFindRequest;
    private FocusTransitionDrawable mFocusTransition;
    private WebViewCore.WebKitHitTest mFocusedNode;
    PluginFullScreenHolder mFullScreenHolder;
    private Point mGlobalVisibleOffset;
    private Rect mGlobalVisibleRect;
    private boolean mGotCenterDown;
    private HTML5VideoViewProxy mHTML5VideoViewProxy;
    private SelectionHandleAlpha mHandleAlpha;
    private ObjectAnimator mHandleAlphaAnimator;
    private boolean mHardwareAccelSkia;
    boolean mHeightCanMeasure;
    private int mHeldMotionless;
    private int mHistoryHeight;
    private Picture mHistoryPicture;
    private int mHistoryWidth;
    private int mHorizontalScrollBarMode;
    private boolean mInOverScrollMode;
    private WebView.HitTestResult mInitialHitTestResult;
    private int mInitialScaleInPercent;
    WebViewInputConnection mInputConnection;
    private WebViewInputDispatcher mInputDispatcher;
    private final Rect mInvScreenRect = new Rect();
    private boolean mIsActionUp;
    boolean mIsBatchingTextChanges;
    private boolean mIsCaretSelection;
    boolean mIsEditingText;
    private boolean mIsPaused;
    private boolean mIsWebViewVisible;
    private Vector mKeysPressed;
    int mLastActualHeightSent;
    private Rect mLastCursorBounds;
    private long mLastCursorTime;
    private long mLastEditScroll;
    private Rect mLastGlobalRect;
    int mLastHeightSent;
    private long mLastSentTouchTime;
    long mLastSwapTime;
    private long mLastTouchTime;
    private long mLastTouchUpTime;
    private int mLastTouchX;
    private int mLastTouchY;
    private float mLastVelX;
    private float mLastVelY;
    private float mLastVelocity;
    private Rect mLastVisibleRectSent;
    int mLastWidthSent;
    private AlertDialog mListBoxDialog;
    private Message mListBoxMessage;
    private WebViewCore.DrawData mLoadedPicture;
    private boolean mMapTrackballToArrowKeys;
    private int mMaxAutoScrollX;
    private int mMaxAutoScrollY;
    private int mMaximumFling;
    private int mMenuLeft;
    private int mMenuTop;
    private int mMinAutoScrollX;
    private int mMinAutoScrollY;
    private int mNativeClass;
    private int mNavSlop;
    private int mOrientation;
    private OverScrollGlow mOverScrollGlow;
    private int mOverflingDistance;
    private boolean mOverlayHorizontalScrollbar;
    private boolean mOverlayVerticalScrollbar;
    private int mOverscrollDistance;
    private PastePopupWindow mPasteWindow;
    private WebView.PictureListener mPictureListener;
    private boolean mPictureUpdatePausedForFocusChange;
    final Handler mPrivateHandler = new PrivateHandler();
    private Message mResumeMsg;
    private final Rect mScreenRect = new Rect();
    private final DrawFilter mScrollFilter = new PaintFlagsDrawFilter(6, 0);
    private Point mScrollOffset;
    OverScroller mScroller;
    private Rect mScrollingLayerBounds;
    private Rect mScrollingLayerRect;
    private Point mSelectCursorLeft;
    private int mSelectCursorLeftLayerId;
    private QuadF mSelectCursorLeftTextQuad;
    private Point mSelectCursorRight;
    private int mSelectCursorRightLayerId;
    private QuadF mSelectCursorRightTextQuad;
    private Point mSelectDraggingCursor;
    private Point mSelectDraggingOffset;
    private QuadF mSelectDraggingTextQuad;
    private Drawable mSelectHandleCenter;
    private Point mSelectHandleCenterOffset;
    private Drawable mSelectHandleLeft;
    private Point mSelectHandleLeftOffset;
    private Drawable mSelectHandleRight;
    private Point mSelectHandleRightOffset;
    private Drawable mSelectHighlight;
    private Drawable mSelectMagnifier;
    private int mSelectX;
    private int mSelectY;
    private boolean mSelectingText;
    private boolean mSelectionStarted;
    private boolean mSendScrollEvent;
    private boolean mSentAutoScrollMessage;
    private boolean mShowTapHighlight;
    private boolean mShowTextSelectionExtra;
    private boolean mSnapPositive;
    private int mSnapScrollMode;
    private int mStartTouchX;
    private int mStartTouchY;
    private final Rect mTempContentVisibleRect = new Rect();
    private final Rect mTempVisibleRect = new Rect();
    private final Point mTempVisibleRectOffset = new Point();
    private int mTextGeneration;
    private Paint mTouchCrossHairColor;
    private Region mTouchHighlightRegion;
    private int mTouchHighlightX;
    private int mTouchHighlightY;
    private Paint mTouchHightlightPaint;
    private boolean mTouchInEditText;
    private int mTouchMode;
    private int mTouchSlopSquare;
    private boolean mTrackballDown;
    private long mTrackballFirstTime;
    private long mTrackballLastTime;
    private float mTrackballRemainsX;
    private float mTrackballRemainsY;
    private long mTrackballUpTime;
    private int mTrackballXMove;
    private int mTrackballYMove;
    VelocityTracker mVelocityTracker;
    private int mVerticalScrollBarMode;
    ViewManager mViewManager;
    private final RectF mVisibleContentRect = new RectF();
    private Rect mVisibleRect;
    private final WebView mWebView;
    private WebViewCore mWebViewCore;
    private final WebView.PrivateAccess mWebViewPrivate;
    boolean mWidthCanMeasure;
    private boolean mWrapContent;
    private final DrawFilter mZoomFilter = new PaintFlagsDrawFilter(134, 64);
    private ZoomManager mZoomManager;

    static  {
        String as[] = new String[11];
        as[0] = "REMEMBER_PASSWORD";
        as[1] = "NEVER_REMEMBER_PASSWORD";
        as[2] = "SWITCH_TO_SHORTPRESS";
        as[3] = "SWITCH_TO_LONGPRESS";
        as[4] = "RELEASE_SINGLE_TAP";
        as[5] = "REQUEST_FORM_DATA";
        as[6] = "RESUME_WEBCORE_PRIORITY";
        as[7] = "DRAG_HELD_MOTIONLESS";
        as[8] = "";
        as[9] = "PREVENT_DEFAULT_TIMEOUT";
        as[10] = "SCROLL_SELECT_TEXT";
        HandlerPrivateDebugString = as;
        String as1[] = new String[38];
        as1[0] = "SCROLL_TO_MSG_ID";
        as1[1] = "102";
        as1[2] = "103";
        as1[3] = "104";
        as1[4] = "NEW_PICTURE_MSG_ID";
        as1[5] = "UPDATE_TEXT_ENTRY_MSG_ID";
        as1[6] = "WEBCORE_INITIALIZED_MSG_ID";
        as1[7] = "UPDATE_TEXTFIELD_TEXT_MSG_ID";
        as1[8] = "UPDATE_ZOOM_RANGE";
        as1[9] = "UNHANDLED_NAV_KEY";
        as1[10] = "CLEAR_TEXT_ENTRY";
        as1[11] = "UPDATE_TEXT_SELECTION_MSG_ID";
        as1[12] = "SHOW_RECT_MSG_ID";
        as1[13] = "LONG_PRESS_CENTER";
        as1[14] = "PREVENT_TOUCH_ID";
        as1[15] = "WEBCORE_NEED_TOUCH_EVENTS";
        as1[16] = "INVAL_RECT_MSG_ID";
        as1[17] = "REQUEST_KEYBOARD";
        as1[18] = "DO_MOTION_UP";
        as1[19] = "SHOW_FULLSCREEN";
        as1[20] = "HIDE_FULLSCREEN";
        as1[21] = "DOM_FOCUS_CHANGED";
        as1[22] = "REPLACE_BASE_CONTENT";
        as1[23] = "RETURN_LABEL";
        as1[24] = "UPDATE_MATCH_COUNT";
        as1[25] = "CENTER_FIT_RECT";
        as1[26] = "REQUEST_KEYBOARD_WITH_SELECTION_MSG_ID";
        as1[27] = "SET_SCROLLBAR_MODES";
        as1[28] = "SELECTION_STRING_CHANGED";
        as1[29] = "SET_TOUCH_HIGHLIGHT_RECTS";
        as1[30] = "SAVE_WEBARCHIVE_FINISHED";
        as1[31] = "SET_AUTOFILLABLE";
        as1[32] = "AUTOFILL_COMPLETE";
        as1[33] = "SELECT_AT";
        as1[34] = "SCREEN_ON";
        as1[35] = "ENTER_FULLSCREEN_VIDEO";
        as1[36] = "UPDATE_SELECTION";
        as1[37] = "UPDATE_ZOOM_DENSITY";
        HandlerPackageDebugString = as1;
        sGoogleApps = new HashSet();
        sGoogleApps.add("com.google.android.youtube");
    }





/*
    static int access$102(WebViewClassic webviewclassic, int i) {
        webviewclassic.mFieldPointer = i;
        return i;
    }

*/






/*
    static Message access$1702(WebViewClassic webviewclassic, Message message) {
        webviewclassic.mResumeMsg = message;
        return message;
    }

*/






/*
    static WebViewCore.DrawData access$2002(WebViewClassic webviewclassic, WebViewCore.DrawData drawdata) {
        webviewclassic.mLoadedPicture = drawdata;
        return drawdata;
    }

*/





/*
    static WebViewCore.AutoFillData access$2302(WebViewClassic webviewclassic, WebViewCore.AutoFillData autofilldata) {
        webviewclassic.mAutoFillData = autofilldata;
        return autofilldata;
    }

*/






/*
    static boolean access$2902(WebViewClassic webviewclassic, boolean flag) {
        webviewclassic.mSentAutoScrollMessage = flag;
        return flag;
    }

*/











/*
    static WebViewCore.DrawData access$3702(WebViewClassic webviewclassic, WebViewCore.DrawData drawdata) {
        webviewclassic.mDelaySetPicture = drawdata;
        return drawdata;
    }

*/







/*
    static WebViewInputDispatcher access$4102(WebViewClassic webviewclassic, WebViewInputDispatcher webviewinputdispatcher) {
        webviewclassic.mInputDispatcher = webviewinputdispatcher;
        return webviewinputdispatcher;
    }

*/



/*
    static int access$4202(WebViewClassic webviewclassic, int i) {
        webviewclassic.mTextGeneration = i;
        return i;
    }

*/




/*
    static boolean access$4502(WebViewClassic webviewclassic, boolean flag) {
        webviewclassic.mGotCenterDown = flag;
        return flag;
    }

*/


/*
    static boolean access$4602(WebViewClassic webviewclassic, boolean flag) {
        webviewclassic.mTrackballDown = flag;
        return flag;
    }

*/



/*
    static int access$4802(WebViewClassic webviewclassic, int i) {
        webviewclassic.mHeldMotionless = i;
        return i;
    }

*/







/*
    static int access$5302(WebViewClassic webviewclassic, int i) {
        webviewclassic.mHorizontalScrollBarMode = i;
        return i;
    }

*/


/*
    static int access$5402(WebViewClassic webviewclassic, int i) {
        webviewclassic.mVerticalScrollBarMode = i;
        return i;
    }

*/




/*
    static WebViewCore.WebKitHitTest access$5702(WebViewClassic webviewclassic, WebViewCore.WebKitHitTest webkithittest) {
        webviewclassic.mFocusedNode = webkithittest;
        return webkithittest;
    }

*/






/*
    static String access$6102(WebViewClassic webviewclassic, String s) {
        webviewclassic.mBeforeStart = s;
        return s;
    }

*/


/*
    static String access$6202(WebViewClassic webviewclassic, String s) {
        webviewclassic.mAfterStart = s;
        return s;
    }

*/
















/*
    static boolean access$7502(WebViewClassic webviewclassic, boolean flag) {
        webviewclassic.mShowTapHighlight = flag;
        return flag;
    }

*/




/*
    static FocusTransitionDrawable access$7702(WebViewClassic webviewclassic, FocusTransitionDrawable focustransitiondrawable) {
        webviewclassic.mFocusTransition = focustransitiondrawable;
        return focustransitiondrawable;
    }

*/




/*
    static AlertDialog access$8102(WebViewClassic webviewclassic, AlertDialog alertdialog) {
        webviewclassic.mListBoxDialog = alertdialog;
        return alertdialog;
    }

*/


/*
    static Message access$8202(WebViewClassic webviewclassic, Message message) {
        webviewclassic.mListBoxMessage = message;
        return message;
    }

*/

}
