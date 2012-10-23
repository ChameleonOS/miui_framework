// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.inputmethodservice;

import android.app.Dialog;
import android.content.pm.ApplicationInfo;
import android.content.res.*;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.*;
import android.text.Editable;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.util.*;
import android.view.*;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.*;
import android.widget.Button;
import android.widget.FrameLayout;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package android.inputmethodservice:
//            AbstractInputMethodService, ExtractEditLayout, ExtractEditText, SoftInputWindow

public class InputMethodService extends AbstractInputMethodService {
    public static final class Insets {

        public static final int TOUCHABLE_INSETS_CONTENT = 1;
        public static final int TOUCHABLE_INSETS_FRAME = 0;
        public static final int TOUCHABLE_INSETS_REGION = 3;
        public static final int TOUCHABLE_INSETS_VISIBLE = 2;
        public int contentTopInsets;
        public int touchableInsets;
        public final Region touchableRegion = new Region();
        public int visibleTopInsets;

        public Insets() {
        }
    }

    public class InputMethodSessionImpl extends AbstractInputMethodService.AbstractInputMethodSessionImpl {

        public void appPrivateCommand(String s, Bundle bundle) {
            if(isEnabled())
                onAppPrivateCommand(s, bundle);
        }

        public void displayCompletions(CompletionInfo acompletioninfo[]) {
            if(isEnabled()) {
                mCurCompletions = acompletioninfo;
                onDisplayCompletions(acompletioninfo);
            }
        }

        public void finishInput() {
            if(isEnabled())
                doFinishInput();
        }

        public void toggleSoftInput(int i, int j) {
            onToggleSoftInput(i, j);
        }

        public void updateCursor(Rect rect) {
            if(isEnabled())
                onUpdateCursor(rect);
        }

        public void updateExtractedText(int i, ExtractedText extractedtext) {
            if(isEnabled())
                onUpdateExtractedText(i, extractedtext);
        }

        public void updateSelection(int i, int j, int k, int l, int i1, int j1) {
            if(isEnabled())
                onUpdateSelection(i, j, k, l, i1, j1);
        }

        public void viewClicked(boolean flag) {
            if(isEnabled())
                onViewClicked(flag);
        }

        final InputMethodService this$0;

        public InputMethodSessionImpl() {
            this$0 = InputMethodService.this;
            super(InputMethodService.this);
        }
    }

    public class InputMethodImpl extends AbstractInputMethodService.AbstractInputMethodImpl {

        public void attachToken(IBinder ibinder) {
            if(mToken == null) {
                mToken = ibinder;
                mWindow.setToken(ibinder);
            }
        }

        public void bindInput(InputBinding inputbinding) {
            mInputBinding = inputbinding;
            mInputConnection = inputbinding.getConnection();
            InputConnection inputconnection = getCurrentInputConnection();
            if(inputconnection != null)
                inputconnection.reportFullscreenMode(mIsFullscreen);
            initialize();
            onBindInput();
        }

        public void changeInputMethodSubtype(InputMethodSubtype inputmethodsubtype) {
            onCurrentInputMethodSubtypeChanged(inputmethodsubtype);
        }

        public void hideSoftInput(int i, ResultReceiver resultreceiver) {
            byte byte0;
            boolean flag;
            byte0 = 0;
            flag = isInputViewShown();
            mShowInputFlags = 0;
            mShowInputRequested = false;
            mShowInputForced = false;
            doHideWindow();
            if(resultreceiver == null) goto _L2; else goto _L1
_L1:
            if(flag == isInputViewShown()) goto _L4; else goto _L3
_L3:
            byte0 = 3;
_L6:
            resultreceiver.send(byte0, null);
_L2:
            return;
_L4:
            if(!flag)
                byte0 = 1;
            if(true) goto _L6; else goto _L5
_L5:
        }

        public void restartInput(InputConnection inputconnection, EditorInfo editorinfo) {
            doStartInput(inputconnection, editorinfo, true);
        }

        public void showSoftInput(int i, ResultReceiver resultreceiver) {
            byte byte0 = 2;
            boolean flag = isInputViewShown();
            mShowInputFlags = 0;
            if(onShowInputRequested(i, false))
                showWindow(true);
            boolean flag1 = onEvaluateInputViewShown();
            InputMethodManager inputmethodmanager = mImm;
            IBinder ibinder = mToken;
            byte byte1;
            if(flag1)
                byte1 = byte0;
            else
                byte1 = 0;
            inputmethodmanager.setImeWindowStatus(ibinder, byte1 | 1, mBackDisposition);
            if(resultreceiver != null) {
                if(flag == isInputViewShown())
                    if(flag)
                        byte0 = 0;
                    else
                        byte0 = 1;
                resultreceiver.send(byte0, null);
            }
        }

        public void startInput(InputConnection inputconnection, EditorInfo editorinfo) {
            doStartInput(inputconnection, editorinfo, false);
        }

        public void unbindInput() {
            onUnbindInput();
            mInputStarted = false;
            mInputBinding = null;
            mInputConnection = null;
        }

        final InputMethodService this$0;

        public InputMethodImpl() {
            this$0 = InputMethodService.this;
            super(InputMethodService.this);
        }
    }


    public InputMethodService() {
        mTheme = 0;
    }

    private void doHideWindow() {
        mImm.setImeWindowStatus(mToken, 0, mBackDisposition);
        hideWindow();
    }

    private void finishViews() {
        if(!mInputViewStarted) goto _L2; else goto _L1
_L1:
        onFinishInputView(false);
_L4:
        mInputViewStarted = false;
        mCandidatesViewStarted = false;
        return;
_L2:
        if(mCandidatesViewStarted)
            onFinishCandidatesView(false);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private boolean handleBack(boolean flag) {
        boolean flag1 = true;
        if(!mShowInputRequested) goto _L2; else goto _L1
_L1:
        if(!isExtractViewShown() || !(mExtractView instanceof ExtractEditLayout)) goto _L4; else goto _L3
_L3:
        ExtractEditLayout extracteditlayout = (ExtractEditLayout)mExtractView;
        if(!extracteditlayout.isActionModeStarted()) goto _L4; else goto _L5
_L5:
        if(flag)
            extracteditlayout.finishActionMode();
_L7:
        return flag1;
_L4:
        if(flag)
            requestHideSelf(0);
        continue; /* Loop/switch isn't completed */
_L2:
        if(mWindowVisible) {
            if(mCandidatesVisibility == 0) {
                if(flag)
                    setCandidatesViewShown(false);
            } else
            if(flag)
                doHideWindow();
        } else {
            flag1 = false;
        }
        if(true) goto _L7; else goto _L6
_L6:
    }

    private void onToggleSoftInput(int i, int j) {
        if(isInputViewShown())
            requestHideSelf(j);
        else
            requestShowSelf(i);
    }

    private void requestShowSelf(int i) {
        mImm.showSoftInputFromInputMethod(mToken, i);
    }

    void doFinishInput() {
        if(!mInputViewStarted) goto _L2; else goto _L1
_L1:
        onFinishInputView(true);
_L4:
        mInputViewStarted = false;
        mCandidatesViewStarted = false;
        if(mInputStarted)
            onFinishInput();
        mInputStarted = false;
        mStartedInputConnection = null;
        mCurCompletions = null;
        return;
_L2:
        if(mCandidatesViewStarted)
            onFinishCandidatesView(true);
        if(true) goto _L4; else goto _L3
_L3:
    }

    boolean doMovementKey(int i, KeyEvent keyevent, int j) {
        boolean flag;
        ExtractEditText extractedittext;
        flag = true;
        extractedittext = mExtractEditText;
        if(!isExtractViewShown() || !isInputViewShown() || extractedittext == null) goto _L2; else goto _L1
_L1:
        MovementMethod movementmethod;
        android.text.Layout layout;
        movementmethod = extractedittext.getMovementMethod();
        layout = extractedittext.getLayout();
        if(movementmethod == null || layout == null) goto _L4; else goto _L3
_L3:
        if(j != -1) goto _L6; else goto _L5
_L5:
        if(!movementmethod.onKeyDown(extractedittext, extractedittext.getText(), i, keyevent)) goto _L4; else goto _L7
_L7:
        reportExtractedMovement(i, flag);
_L10:
        return flag;
_L6:
        if(j != -2) goto _L9; else goto _L8
_L8:
        if(movementmethod.onKeyUp(extractedittext, extractedittext.getText(), i, keyevent)) goto _L10; else goto _L4
_L4:
        i;
        JVM INSTR tableswitch 19 22: default 144
    //                   19 84
    //                   20 84
    //                   21 84
    //                   22 84;
           goto _L2 _L10 _L10 _L10 _L10
_L2:
        flag = false;
          goto _L10
_L9:
        if(movementmethod.onKeyOther(extractedittext, extractedittext.getText(), keyevent)) {
            reportExtractedMovement(i, j);
        } else {
            KeyEvent keyevent1 = KeyEvent.changeAction(keyevent, 0);
            if(movementmethod.onKeyDown(extractedittext, extractedittext.getText(), i, keyevent1)) {
                KeyEvent keyevent2 = KeyEvent.changeAction(keyevent, flag);
                movementmethod.onKeyUp(extractedittext, extractedittext.getText(), i, keyevent2);
                while(--j > 0)  {
                    movementmethod.onKeyDown(extractedittext, extractedittext.getText(), i, keyevent1);
                    movementmethod.onKeyUp(extractedittext, extractedittext.getText(), i, keyevent2);
                }
                reportExtractedMovement(i, j);
            }
        }
          goto _L4
    }

    void doStartInput(InputConnection inputconnection, EditorInfo editorinfo, boolean flag) {
        if(!flag)
            doFinishInput();
        mInputStarted = true;
        mStartedInputConnection = inputconnection;
        mInputEditorInfo = editorinfo;
        initialize();
        onStartInput(editorinfo, flag);
        if(!mWindowVisible) goto _L2; else goto _L1
_L1:
        if(!mShowInputRequested) goto _L4; else goto _L3
_L3:
        mInputViewStarted = true;
        onStartInputView(mInputEditorInfo, flag);
        startExtractingText(true);
_L2:
        return;
_L4:
        if(mCandidatesVisibility == 0) {
            mCandidatesViewStarted = true;
            onStartCandidatesView(mInputEditorInfo, flag);
        }
        if(true) goto _L2; else goto _L5
_L5:
    }

    protected void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        PrintWriterPrinter printwriterprinter = new PrintWriterPrinter(printwriter);
        printwriterprinter.println((new StringBuilder()).append("Input method service state for ").append(this).append(":").toString());
        printwriterprinter.println((new StringBuilder()).append("  mWindowCreated=").append(mWindowCreated).append(" mWindowAdded=").append(mWindowAdded).toString());
        printwriterprinter.println((new StringBuilder()).append("  mWindowVisible=").append(mWindowVisible).append(" mWindowWasVisible=").append(mWindowWasVisible).append(" mInShowWindow=").append(mInShowWindow).toString());
        printwriterprinter.println((new StringBuilder()).append("  Configuration=").append(getResources().getConfiguration()).toString());
        printwriterprinter.println((new StringBuilder()).append("  mToken=").append(mToken).toString());
        printwriterprinter.println((new StringBuilder()).append("  mInputBinding=").append(mInputBinding).toString());
        printwriterprinter.println((new StringBuilder()).append("  mInputConnection=").append(mInputConnection).toString());
        printwriterprinter.println((new StringBuilder()).append("  mStartedInputConnection=").append(mStartedInputConnection).toString());
        printwriterprinter.println((new StringBuilder()).append("  mInputStarted=").append(mInputStarted).append(" mInputViewStarted=").append(mInputViewStarted).append(" mCandidatesViewStarted=").append(mCandidatesViewStarted).toString());
        if(mInputEditorInfo != null) {
            printwriterprinter.println("  mInputEditorInfo:");
            mInputEditorInfo.dump(printwriterprinter, "    ");
        } else {
            printwriterprinter.println("  mInputEditorInfo: null");
        }
        printwriterprinter.println((new StringBuilder()).append("  mShowInputRequested=").append(mShowInputRequested).append(" mLastShowInputRequested=").append(mLastShowInputRequested).append(" mShowInputForced=").append(mShowInputForced).append(" mShowInputFlags=0x").append(Integer.toHexString(mShowInputFlags)).toString());
        printwriterprinter.println((new StringBuilder()).append("  mCandidatesVisibility=").append(mCandidatesVisibility).append(" mFullscreenApplied=").append(mFullscreenApplied).append(" mIsFullscreen=").append(mIsFullscreen).append(" mExtractViewHidden=").append(mExtractViewHidden).toString());
        if(mExtractedText != null) {
            printwriterprinter.println("  mExtractedText:");
            printwriterprinter.println((new StringBuilder()).append("    text=").append(mExtractedText.text.length()).append(" chars").append(" startOffset=").append(mExtractedText.startOffset).toString());
            printwriterprinter.println((new StringBuilder()).append("    selectionStart=").append(mExtractedText.selectionStart).append(" selectionEnd=").append(mExtractedText.selectionEnd).append(" flags=0x").append(Integer.toHexString(mExtractedText.flags)).toString());
        } else {
            printwriterprinter.println("  mExtractedText: null");
        }
        printwriterprinter.println((new StringBuilder()).append("  mExtractedToken=").append(mExtractedToken).toString());
        printwriterprinter.println((new StringBuilder()).append("  mIsInputViewShown=").append(mIsInputViewShown).append(" mStatusIcon=").append(mStatusIcon).toString());
        printwriterprinter.println("Last computed insets:");
        printwriterprinter.println((new StringBuilder()).append("  contentTopInsets=").append(mTmpInsets.contentTopInsets).append(" visibleTopInsets=").append(mTmpInsets.visibleTopInsets).append(" touchableInsets=").append(mTmpInsets.touchableInsets).append(" touchableRegion=").append(mTmpInsets.touchableRegion).toString());
    }

    public int getBackDisposition() {
        return mBackDisposition;
    }

    public int getCandidatesHiddenVisibility() {
        byte byte0;
        if(isExtractViewShown())
            byte0 = 8;
        else
            byte0 = 4;
        return byte0;
    }

    public InputBinding getCurrentInputBinding() {
        return mInputBinding;
    }

    public InputConnection getCurrentInputConnection() {
        InputConnection inputconnection = mStartedInputConnection;
        if(inputconnection == null)
            inputconnection = mInputConnection;
        return inputconnection;
    }

    public EditorInfo getCurrentInputEditorInfo() {
        return mInputEditorInfo;
    }

    public boolean getCurrentInputStarted() {
        return mInputStarted;
    }

    public LayoutInflater getLayoutInflater() {
        return mInflater;
    }

    public int getMaxWidth() {
        return ((WindowManager)getSystemService("window")).getDefaultDisplay().getWidth();
    }

    public CharSequence getTextForImeAction(int i) {
        i & 0xff;
        JVM INSTR tableswitch 1 7: default 48
    //                   1 58
    //                   2 63
    //                   3 74
    //                   4 85
    //                   5 96
    //                   6 107
    //                   7 118;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        CharSequence charsequence = getText(0x104046b);
_L10:
        return charsequence;
_L2:
        charsequence = null;
        continue; /* Loop/switch isn't completed */
_L3:
        charsequence = getText(0x1040465);
        continue; /* Loop/switch isn't completed */
_L4:
        charsequence = getText(0x1040466);
        continue; /* Loop/switch isn't completed */
_L5:
        charsequence = getText(0x1040467);
        continue; /* Loop/switch isn't completed */
_L6:
        charsequence = getText(0x1040468);
        continue; /* Loop/switch isn't completed */
_L7:
        charsequence = getText(0x1040469);
        continue; /* Loop/switch isn't completed */
_L8:
        charsequence = getText(0x104046a);
        if(true) goto _L10; else goto _L9
_L9:
    }

    public Dialog getWindow() {
        return mWindow;
    }

    public void hideStatusIcon() {
        mStatusIcon = 0;
        mImm.hideStatusIcon(mToken);
    }

    public void hideWindow() {
        finishViews();
        if(mWindowVisible) {
            mWindow.hide();
            mWindowVisible = false;
            onWindowHidden();
            mWindowWasVisible = false;
        }
    }

    void initViews() {
        mInitialized = false;
        mWindowCreated = false;
        mShowInputRequested = false;
        mShowInputForced = false;
        mThemeAttrs = obtainStyledAttributes(android.R.styleable.InputMethodService);
        mRootView = mInflater.inflate(0x1090047, null);
        mWindow.setContentView(mRootView);
        mRootView.getViewTreeObserver().addOnComputeInternalInsetsListener(mInsetsComputer);
        if(android.provider.Settings.System.getInt(getContentResolver(), "fancy_ime_animations", 0) != 0)
            mWindow.getWindow().setWindowAnimations(0x10301e5);
        mFullscreenArea = (ViewGroup)mRootView.findViewById(0x102028c);
        mExtractViewHidden = false;
        mExtractFrame = (FrameLayout)mRootView.findViewById(0x102001c);
        mExtractView = null;
        mExtractEditText = null;
        mExtractAccessories = null;
        mExtractAction = null;
        mFullscreenApplied = false;
        mCandidatesFrame = (FrameLayout)mRootView.findViewById(0x102001d);
        mInputFrame = (FrameLayout)mRootView.findViewById(0x102001e);
        mInputView = null;
        mIsInputViewShown = false;
        mExtractFrame.setVisibility(8);
        mCandidatesVisibility = getCandidatesHiddenVisibility();
        mCandidatesFrame.setVisibility(mCandidatesVisibility);
        mInputFrame.setVisibility(8);
    }

    void initialize() {
        if(!mInitialized) {
            mInitialized = true;
            onInitializeInterface();
        }
    }

    public boolean isExtractViewShown() {
        boolean flag;
        if(mIsFullscreen && !mExtractViewHidden)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isFullscreenMode() {
        return mIsFullscreen;
    }

    public boolean isInputViewShown() {
        boolean flag;
        if(mIsInputViewShown && mWindowVisible)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isShowInputRequested() {
        return mShowInputRequested;
    }

    public void onAppPrivateCommand(String s, Bundle bundle) {
    }

    public void onBindInput() {
    }

    public void onComputeInsets(Insets insets) {
        int ai[] = mTmpLocation;
        if(mInputFrame.getVisibility() == 0)
            mInputFrame.getLocationInWindow(ai);
        else
            ai[1] = getWindow().getWindow().getDecorView().getHeight();
        if(isFullscreenMode())
            insets.contentTopInsets = getWindow().getWindow().getDecorView().getHeight();
        else
            insets.contentTopInsets = ai[1];
        if(mCandidatesFrame.getVisibility() == 0)
            mCandidatesFrame.getLocationInWindow(ai);
        insets.visibleTopInsets = ai[1];
        insets.touchableInsets = 2;
        insets.touchableRegion.setEmpty();
    }

    public void onConfigurationChanged(Configuration configuration) {
        byte byte0 = 0;
        super.onConfigurationChanged(configuration);
        boolean flag = mWindowVisible;
        int i = mShowInputFlags;
        boolean flag1 = mShowInputRequested;
        CompletionInfo acompletioninfo[] = mCurCompletions;
        initViews();
        mInputViewStarted = false;
        mCandidatesViewStarted = false;
        if(mInputStarted)
            doStartInput(getCurrentInputConnection(), getCurrentInputEditorInfo(), true);
        if(flag) {
            boolean flag2;
            InputMethodManager inputmethodmanager;
            IBinder ibinder;
            if(flag1) {
                if(onShowInputRequested(i, true)) {
                    showWindow(true);
                    if(acompletioninfo != null) {
                        mCurCompletions = acompletioninfo;
                        onDisplayCompletions(acompletioninfo);
                    }
                } else {
                    doHideWindow();
                }
            } else
            if(mCandidatesVisibility == 0)
                showWindow(false);
            else
                doHideWindow();
            flag2 = onEvaluateInputViewShown();
            inputmethodmanager = mImm;
            ibinder = mToken;
            if(flag2)
                byte0 = 2;
            inputmethodmanager.setImeWindowStatus(ibinder, byte0 | 1, mBackDisposition);
        }
    }

    public void onConfigureWindow(Window window, boolean flag, boolean flag1) {
        if(flag)
            mWindow.getWindow().setLayout(-1, -1);
        else
            mWindow.getWindow().setLayout(-1, -2);
    }

    public void onCreate() {
        mTheme = Resources.selectSystemTheme(mTheme, getApplicationInfo().targetSdkVersion, 0x1030054, 0x103007f, 0x103013e);
        super.setTheme(mTheme);
        super.onCreate();
        mImm = (InputMethodManager)getSystemService("input_method");
        mInflater = (LayoutInflater)getSystemService("layout_inflater");
        mWindow = new SoftInputWindow(this, mTheme, super.mDispatcherState);
        initViews();
        mWindow.getWindow().setLayout(-1, -2);
    }

    public View onCreateCandidatesView() {
        return null;
    }

    public View onCreateExtractTextView() {
        return mInflater.inflate(0x1090048, null);
    }

    public AbstractInputMethodService.AbstractInputMethodImpl onCreateInputMethodInterface() {
        return new InputMethodImpl();
    }

    public AbstractInputMethodService.AbstractInputMethodSessionImpl onCreateInputMethodSessionInterface() {
        return new InputMethodSessionImpl();
    }

    public View onCreateInputView() {
        return null;
    }

    protected void onCurrentInputMethodSubtypeChanged(InputMethodSubtype inputmethodsubtype) {
    }

    public void onDestroy() {
        super.onDestroy();
        mRootView.getViewTreeObserver().removeOnComputeInternalInsetsListener(mInsetsComputer);
        finishViews();
        if(mWindowAdded) {
            mWindow.getWindow().setWindowAnimations(0);
            mWindow.dismiss();
        }
    }

    public void onDisplayCompletions(CompletionInfo acompletioninfo[]) {
    }

    public boolean onEvaluateFullscreenMode() {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        if(getResources().getConfiguration().orientation == 2 && (mInputEditorInfo == null || (0x2000000 & mInputEditorInfo.imeOptions) == 0))
            flag = true;
        return flag;
    }

    public boolean onEvaluateInputViewShown() {
        boolean flag = true;
        Configuration configuration = getResources().getConfiguration();
        if(configuration.keyboard != flag && configuration.hardKeyboardHidden != 2)
            flag = false;
        return flag;
    }

    public boolean onExtractTextContextMenuItem(int i) {
        InputConnection inputconnection = getCurrentInputConnection();
        if(inputconnection != null)
            inputconnection.performContextMenuAction(i);
        return true;
    }

    public void onExtractedCursorMovement(int i, int j) {
        if(mExtractEditText != null && j != 0 && mExtractEditText.hasVerticalScrollBar())
            setCandidatesViewShown(false);
    }

    public void onExtractedDeleteText(int i, int j) {
        InputConnection inputconnection = getCurrentInputConnection();
        if(inputconnection != null) {
            inputconnection.setSelection(i, i);
            inputconnection.deleteSurroundingText(0, j - i);
        }
    }

    public void onExtractedReplaceText(int i, int j, CharSequence charsequence) {
        InputConnection inputconnection = getCurrentInputConnection();
        if(inputconnection != null) {
            inputconnection.setComposingRegion(i, j);
            inputconnection.commitText(charsequence, 1);
        }
    }

    public void onExtractedSelectionChanged(int i, int j) {
        InputConnection inputconnection = getCurrentInputConnection();
        if(inputconnection != null)
            inputconnection.setSelection(i, j);
    }

    public void onExtractedSetSpan(Object obj, int i, int j, int k) {
        InputConnection inputconnection = getCurrentInputConnection();
        if(inputconnection != null && inputconnection.setSelection(i, j)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        CharSequence charsequence = inputconnection.getSelectedText(1);
        if(charsequence instanceof Spannable) {
            ((Spannable)charsequence).setSpan(obj, 0, charsequence.length(), k);
            inputconnection.setComposingRegion(i, j);
            inputconnection.commitText(charsequence, 1);
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void onExtractedTextClicked() {
        if(mExtractEditText != null && mExtractEditText.hasVerticalScrollBar())
            setCandidatesViewShown(false);
    }

    public void onExtractingInputChanged(EditorInfo editorinfo) {
        if(editorinfo.inputType == 0)
            requestHideSelf(2);
    }

    public void onFinishCandidatesView(boolean flag) {
        if(!flag) {
            InputConnection inputconnection = getCurrentInputConnection();
            if(inputconnection != null)
                inputconnection.finishComposingText();
        }
    }

    public void onFinishInput() {
        InputConnection inputconnection = getCurrentInputConnection();
        if(inputconnection != null)
            inputconnection.finishComposingText();
    }

    public void onFinishInputView(boolean flag) {
        if(!flag) {
            InputConnection inputconnection = getCurrentInputConnection();
            if(inputconnection != null)
                inputconnection.finishComposingText();
        }
    }

    public void onInitializeInterface() {
    }

    public boolean onKeyDown(int i, KeyEvent keyevent) {
        boolean flag = false;
        if(keyevent.getKeyCode() == 4) {
            if(handleBack(false)) {
                keyevent.startTracking();
                flag = true;
            }
        } else {
            flag = doMovementKey(i, keyevent, -1);
        }
        return flag;
    }

    public boolean onKeyLongPress(int i, KeyEvent keyevent) {
        return false;
    }

    public boolean onKeyMultiple(int i, int j, KeyEvent keyevent) {
        return doMovementKey(i, keyevent, j);
    }

    public boolean onKeyUp(int i, KeyEvent keyevent) {
        boolean flag;
        if(keyevent.getKeyCode() == 4 && keyevent.isTracking() && !keyevent.isCanceled())
            flag = handleBack(true);
        else
            flag = doMovementKey(i, keyevent, -2);
        return flag;
    }

    public boolean onShowInputRequested(int i, boolean flag) {
        boolean flag1;
        flag1 = false;
        break MISSING_BLOCK_LABEL_2;
        if(onEvaluateInputViewShown() && ((i & 1) != 0 || (flag || !onEvaluateFullscreenMode()) && getResources().getConfiguration().keyboard == 1)) {
            if((i & 2) != 0)
                mShowInputForced = true;
            flag1 = true;
        }
        return flag1;
    }

    public void onStartCandidatesView(EditorInfo editorinfo, boolean flag) {
    }

    public void onStartInput(EditorInfo editorinfo, boolean flag) {
    }

    public void onStartInputView(EditorInfo editorinfo, boolean flag) {
    }

    public boolean onTrackballEvent(MotionEvent motionevent) {
        return false;
    }

    public void onUnbindInput() {
    }

    public void onUpdateCursor(Rect rect) {
    }

    public void onUpdateExtractedText(int i, ExtractedText extractedtext) {
        if(mExtractedToken == i && extractedtext != null && mExtractEditText != null) {
            mExtractedText = extractedtext;
            mExtractEditText.setExtractedText(extractedtext);
        }
    }

    public void onUpdateExtractingViews(EditorInfo editorinfo) {
        int i;
        i = 1;
        break MISSING_BLOCK_LABEL_2;
        while(true)  {
            do
                return;
            while(!isExtractViewShown() || mExtractAccessories == null);
            if(editorinfo.actionLabel == null && ((0xff & editorinfo.imeOptions) == i || (0x20000000 & editorinfo.imeOptions) != 0 || editorinfo.inputType == 0))
                i = 0;
            if(i != 0) {
                mExtractAccessories.setVisibility(0);
                if(mExtractAction != null) {
                    if(editorinfo.actionLabel != null)
                        mExtractAction.setText(editorinfo.actionLabel);
                    else
                        mExtractAction.setText(getTextForImeAction(editorinfo.imeOptions));
                    mExtractAction.setOnClickListener(mActionClickListener);
                }
            } else {
                mExtractAccessories.setVisibility(8);
                if(mExtractAction != null)
                    mExtractAction.setOnClickListener(null);
            }
        }
    }

    public void onUpdateExtractingVisibility(EditorInfo editorinfo) {
        if(editorinfo.inputType == 0 || (0x10000000 & editorinfo.imeOptions) != 0)
            setExtractViewShown(false);
        else
            setExtractViewShown(true);
    }

    public void onUpdateSelection(int i, int j, int k, int l, int i1, int j1) {
        ExtractEditText extractedittext = mExtractEditText;
        if(extractedittext != null && isFullscreenMode() && mExtractedText != null) {
            int k1 = mExtractedText.startOffset;
            extractedittext.startInternalChanges();
            int l1 = k - k1;
            int i2 = l - k1;
            int j2 = extractedittext.getText().length();
            if(l1 < 0)
                l1 = 0;
            else
            if(l1 > j2)
                l1 = j2;
            if(i2 < 0)
                i2 = 0;
            else
            if(i2 > j2)
                i2 = j2;
            extractedittext.setSelection(l1, i2);
            extractedittext.finishInternalChanges();
        }
    }

    public void onViewClicked(boolean flag) {
    }

    public void onWindowHidden() {
    }

    public void onWindowShown() {
    }

    void reportExtractedMovement(int i, int j) {
        int k;
        int l;
        k = 0;
        l = 0;
        i;
        JVM INSTR tableswitch 19 22: default 36
    //                   19 55
    //                   20 62
    //                   21 44
    //                   22 50;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        onExtractedCursorMovement(k, l);
        return;
_L4:
        k = -j;
        continue; /* Loop/switch isn't completed */
_L5:
        k = j;
        continue; /* Loop/switch isn't completed */
_L2:
        l = -j;
        continue; /* Loop/switch isn't completed */
_L3:
        l = j;
        if(true) goto _L1; else goto _L6
_L6:
    }

    public void requestHideSelf(int i) {
        mImm.hideSoftInputFromInputMethod(mToken, i);
    }

    public boolean sendDefaultEditorAction(boolean flag) {
        boolean flag1 = true;
        EditorInfo editorinfo = getCurrentInputEditorInfo();
        if(editorinfo != null && (!flag || (0x40000000 & editorinfo.imeOptions) == 0) && (0xff & editorinfo.imeOptions) != flag1) {
            InputConnection inputconnection = getCurrentInputConnection();
            if(inputconnection != null)
                inputconnection.performEditorAction(0xff & editorinfo.imeOptions);
        } else {
            flag1 = false;
        }
        return flag1;
    }

    public void sendDownUpKeyEvents(int i) {
        InputConnection inputconnection = getCurrentInputConnection();
        if(inputconnection != null) {
            long l = SystemClock.uptimeMillis();
            inputconnection.sendKeyEvent(new KeyEvent(l, l, 0, i, 0, 0, -1, 0, 6));
            inputconnection.sendKeyEvent(new KeyEvent(SystemClock.uptimeMillis(), l, 1, i, 0, 0, -1, 0, 6));
        }
    }

    public void sendKeyChar(char c) {
        c;
        JVM INSTR tableswitch 10 10: default 20
    //                   10 44;
           goto _L1 _L2
_L1:
        if(c < '0' || c > '9') goto _L4; else goto _L3
_L3:
        sendDownUpKeyEvents(7 + (c + -48));
_L6:
        return;
_L2:
        if(!sendDefaultEditorAction(true))
            sendDownUpKeyEvents(66);
        continue; /* Loop/switch isn't completed */
_L4:
        InputConnection inputconnection = getCurrentInputConnection();
        if(inputconnection != null)
            inputconnection.commitText(String.valueOf(c), 1);
        if(true) goto _L6; else goto _L5
_L5:
    }

    public void setBackDisposition(int i) {
        mBackDisposition = i;
    }

    public void setCandidatesView(View view) {
        mCandidatesFrame.removeAllViews();
        mCandidatesFrame.addView(view, new android.widget.FrameLayout.LayoutParams(-1, -2));
    }

    public void setCandidatesViewShown(boolean flag) {
        updateCandidatesVisibility(flag);
        if(!mShowInputRequested && mWindowVisible != flag)
            if(flag)
                showWindow(false);
            else
                doHideWindow();
    }

    public void setExtractView(View view) {
        mExtractFrame.removeAllViews();
        mExtractFrame.addView(view, new android.widget.FrameLayout.LayoutParams(-1, -1));
        mExtractView = view;
        if(view != null) {
            mExtractEditText = (ExtractEditText)view.findViewById(0x1020025);
            mExtractEditText.setIME(this);
            mExtractAction = (Button)view.findViewById(0x102028e);
            if(mExtractAction != null)
                mExtractAccessories = (ViewGroup)view.findViewById(0x102028d);
            startExtractingText(false);
        } else {
            mExtractEditText = null;
            mExtractAccessories = null;
            mExtractAction = null;
        }
    }

    public void setExtractViewShown(boolean flag) {
        if(mExtractViewHidden == flag) {
            boolean flag1;
            if(!flag)
                flag1 = true;
            else
                flag1 = false;
            mExtractViewHidden = flag1;
            updateExtractFrameVisibility();
        }
    }

    public void setInputView(View view) {
        mInputFrame.removeAllViews();
        mInputFrame.addView(view, new android.widget.FrameLayout.LayoutParams(-1, -2));
        mInputView = view;
    }

    public void setTheme(int i) {
        if(mWindow != null) {
            throw new IllegalStateException("Must be called before onCreate()");
        } else {
            mTheme = i;
            return;
        }
    }

    public void showStatusIcon(int i) {
        mStatusIcon = i;
        mImm.showStatusIcon(mToken, getPackageName(), i);
    }

    public void showWindow(boolean flag) {
        if(!mInShowWindow) goto _L2; else goto _L1
_L1:
        Log.w("InputMethodService", "Re-entrance in to showWindow");
_L4:
        return;
_L2:
        mWindowWasVisible = mWindowVisible;
        mInShowWindow = true;
        showWindowInner(flag);
        mWindowWasVisible = true;
        mInShowWindow = false;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        mWindowWasVisible = true;
        mInShowWindow = false;
        throw exception;
    }

    void showWindowInner(boolean flag) {
        boolean flag1;
        boolean flag2;
        flag1 = false;
        flag2 = mWindowVisible;
        mWindowVisible = true;
        if(!mShowInputRequested && (mInputStarted && flag)) {
            flag1 = true;
            mShowInputRequested = true;
        }
        initialize();
        updateFullscreenMode();
        updateInputViewShown();
        if(!mWindowAdded || !mWindowCreated) {
            mWindowAdded = true;
            mWindowCreated = true;
            initialize();
            View view = onCreateCandidatesView();
            if(view != null)
                setCandidatesView(view);
        }
        if(!mShowInputRequested) goto _L2; else goto _L1
_L1:
        if(!mInputViewStarted) {
            mInputViewStarted = true;
            onStartInputView(mInputEditorInfo, false);
        }
_L4:
        if(flag1)
            startExtractingText(false);
        if(!flag2) {
            mImm.setImeWindowStatus(mToken, 1, mBackDisposition);
            onWindowShown();
            mWindow.show();
        }
        return;
_L2:
        if(!mCandidatesViewStarted) {
            mCandidatesViewStarted = true;
            onStartCandidatesView(mInputEditorInfo, false);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    void startExtractingText(boolean flag) {
        ExtractEditText extractedittext = mExtractEditText;
        if(extractedittext == null || !getCurrentInputStarted() || !isFullscreenMode()) goto _L2; else goto _L1
_L1:
        mExtractedToken = 1 + mExtractedToken;
        ExtractedTextRequest extractedtextrequest = new ExtractedTextRequest();
        extractedtextrequest.token = mExtractedToken;
        extractedtextrequest.flags = 1;
        extractedtextrequest.hintMaxLines = 10;
        extractedtextrequest.hintMaxChars = 10000;
        InputConnection inputconnection = getCurrentInputConnection();
        ExtractedText extractedtext;
        EditorInfo editorinfo;
        int i;
        if(inputconnection == null)
            extractedtext = null;
        else
            extractedtext = inputconnection.getExtractedText(extractedtextrequest, 1);
        mExtractedText = extractedtext;
        if(mExtractedText == null || inputconnection == null)
            Log.e("InputMethodService", (new StringBuilder()).append("Unexpected null in startExtractingText : mExtractedText = ").append(mExtractedText).append(", input connection = ").append(inputconnection).toString());
        editorinfo = getCurrentInputEditorInfo();
        extractedittext.startInternalChanges();
        onUpdateExtractingVisibility(editorinfo);
        onUpdateExtractingViews(editorinfo);
        i = editorinfo.inputType;
        if((i & 0xf) == 1 && (0x40000 & i) != 0)
            i |= 0x20000;
        extractedittext.setInputType(i);
        extractedittext.setHint(editorinfo.hintText);
        if(mExtractedText == null) goto _L4; else goto _L3
_L3:
        extractedittext.setEnabled(true);
        extractedittext.setExtractedText(mExtractedText);
_L6:
        extractedittext.finishInternalChanges();
        if(flag)
            onExtractingInputChanged(editorinfo);
_L2:
        return;
_L4:
        extractedittext.setEnabled(false);
        extractedittext.setText("");
        if(true) goto _L6; else goto _L5
_L5:
        Exception exception;
        exception;
        extractedittext.finishInternalChanges();
        throw exception;
    }

    public void switchInputMethod(String s) {
        mImm.setInputMethod(mToken, s);
    }

    void updateCandidatesVisibility(boolean flag) {
        int i;
        if(flag)
            i = 0;
        else
            i = getCandidatesHiddenVisibility();
        if(mCandidatesVisibility != i) {
            mCandidatesFrame.setVisibility(i);
            mCandidatesVisibility = i;
        }
    }

    void updateExtractFrameVisibility() {
        int i = 1;
        byte byte0;
        boolean flag;
        if(isFullscreenMode()) {
            TypedArray typedarray;
            int j;
            if(mExtractViewHidden)
                byte0 = 4;
            else
                byte0 = 0;
            mExtractFrame.setVisibility(0);
        } else {
            byte0 = 0;
            mExtractFrame.setVisibility(8);
        }
        if(mCandidatesVisibility == 0)
            flag = i;
        else
            flag = false;
        updateCandidatesVisibility(flag);
        if(mWindowWasVisible && mFullscreenArea.getVisibility() != byte0) {
            typedarray = mThemeAttrs;
            if(byte0 != 0)
                i = 2;
            j = typedarray.getResourceId(i, 0);
            if(j != 0)
                mFullscreenArea.startAnimation(AnimationUtils.loadAnimation(this, j));
        }
        mFullscreenArea.setVisibility(byte0);
    }

    public void updateFullscreenMode() {
        boolean flag = true;
        boolean flag1;
        boolean flag2;
        if(mShowInputRequested && onEvaluateFullscreenMode())
            flag1 = flag;
        else
            flag1 = false;
        if(mLastShowInputRequested != mShowInputRequested)
            flag2 = flag;
        else
            flag2 = false;
        if(mIsFullscreen != flag1 || !mFullscreenApplied) {
            flag2 = true;
            mIsFullscreen = flag1;
            InputConnection inputconnection = getCurrentInputConnection();
            if(inputconnection != null)
                inputconnection.reportFullscreenMode(flag1);
            mFullscreenApplied = flag;
            initialize();
            android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)mFullscreenArea.getLayoutParams();
            Window window;
            if(flag1) {
                mFullscreenArea.setBackgroundDrawable(mThemeAttrs.getDrawable(0));
                layoutparams.height = 0;
                layoutparams.weight = 1.0F;
            } else {
                mFullscreenArea.setBackgroundDrawable(null);
                layoutparams.height = -2;
                layoutparams.weight = 0.0F;
            }
            ((ViewGroup)mFullscreenArea.getParent()).updateViewLayout(mFullscreenArea, layoutparams);
            if(flag1) {
                if(mExtractView == null) {
                    View view = onCreateExtractTextView();
                    if(view != null)
                        setExtractView(view);
                }
                startExtractingText(false);
            }
            updateExtractFrameVisibility();
        }
        if(flag2) {
            window = mWindow.getWindow();
            if(mShowInputRequested)
                flag = false;
            onConfigureWindow(window, flag1, flag);
            mLastShowInputRequested = mShowInputRequested;
        }
    }

    public void updateInputViewShown() {
        int i = 0;
        boolean flag;
        if(mShowInputRequested && onEvaluateInputViewShown())
            flag = true;
        else
            flag = false;
        if(mIsInputViewShown != flag && mWindowVisible) {
            mIsInputViewShown = flag;
            FrameLayout framelayout = mInputFrame;
            if(!flag)
                i = 8;
            framelayout.setVisibility(i);
            if(mInputView == null) {
                initialize();
                View view = onCreateInputView();
                if(view != null)
                    setInputView(view);
            }
        }
    }

    public static final int BACK_DISPOSITION_DEFAULT = 0;
    public static final int BACK_DISPOSITION_WILL_DISMISS = 2;
    public static final int BACK_DISPOSITION_WILL_NOT_DISMISS = 1;
    static final boolean DEBUG = false;
    public static final int IME_ACTIVE = 1;
    public static final int IME_VISIBLE = 2;
    static final int MOVEMENT_DOWN = -1;
    static final int MOVEMENT_UP = -2;
    static final String TAG = "InputMethodService";
    final android.view.View.OnClickListener mActionClickListener = new android.view.View.OnClickListener() {

        public void onClick(View view) {
            EditorInfo editorinfo;
            InputConnection inputconnection;
            editorinfo = getCurrentInputEditorInfo();
            inputconnection = getCurrentInputConnection();
            if(editorinfo == null || inputconnection == null) goto _L2; else goto _L1
_L1:
            if(editorinfo.actionId == 0) goto _L4; else goto _L3
_L3:
            inputconnection.performEditorAction(editorinfo.actionId);
_L2:
            return;
_L4:
            if((0xff & editorinfo.imeOptions) != 1)
                inputconnection.performEditorAction(0xff & editorinfo.imeOptions);
            if(true) goto _L2; else goto _L5
_L5:
        }

        final InputMethodService this$0;

             {
                this$0 = InputMethodService.this;
                super();
            }
    };
    int mBackDisposition;
    FrameLayout mCandidatesFrame;
    boolean mCandidatesViewStarted;
    int mCandidatesVisibility;
    CompletionInfo mCurCompletions[];
    ViewGroup mExtractAccessories;
    Button mExtractAction;
    ExtractEditText mExtractEditText;
    FrameLayout mExtractFrame;
    View mExtractView;
    boolean mExtractViewHidden;
    ExtractedText mExtractedText;
    int mExtractedToken;
    boolean mFullscreenApplied;
    ViewGroup mFullscreenArea;
    InputMethodManager mImm;
    boolean mInShowWindow;
    LayoutInflater mInflater;
    boolean mInitialized;
    InputBinding mInputBinding;
    InputConnection mInputConnection;
    EditorInfo mInputEditorInfo;
    FrameLayout mInputFrame;
    boolean mInputStarted;
    View mInputView;
    boolean mInputViewStarted;
    final android.view.ViewTreeObserver.OnComputeInternalInsetsListener mInsetsComputer = new android.view.ViewTreeObserver.OnComputeInternalInsetsListener() {

        public void onComputeInternalInsets(android.view.ViewTreeObserver.InternalInsetsInfo internalinsetsinfo) {
            if(isExtractViewShown()) {
                View view = getWindow().getWindow().getDecorView();
                Rect rect = internalinsetsinfo.contentInsets;
                Rect rect1 = internalinsetsinfo.visibleInsets;
                int i = view.getHeight();
                rect1.top = i;
                rect.top = i;
                internalinsetsinfo.touchableRegion.setEmpty();
                internalinsetsinfo.setTouchableInsets(0);
            } else {
                onComputeInsets(mTmpInsets);
                internalinsetsinfo.contentInsets.top = mTmpInsets.contentTopInsets;
                internalinsetsinfo.visibleInsets.top = mTmpInsets.visibleTopInsets;
                internalinsetsinfo.touchableRegion.set(mTmpInsets.touchableRegion);
                internalinsetsinfo.setTouchableInsets(mTmpInsets.touchableInsets);
            }
        }

        final InputMethodService this$0;

             {
                this$0 = InputMethodService.this;
                super();
            }
    };
    boolean mIsFullscreen;
    boolean mIsInputViewShown;
    boolean mLastShowInputRequested;
    View mRootView;
    int mShowInputFlags;
    boolean mShowInputForced;
    boolean mShowInputRequested;
    InputConnection mStartedInputConnection;
    int mStatusIcon;
    int mTheme;
    TypedArray mThemeAttrs;
    final Insets mTmpInsets = new Insets();
    final int mTmpLocation[] = new int[2];
    IBinder mToken;
    SoftInputWindow mWindow;
    boolean mWindowAdded;
    boolean mWindowCreated;
    boolean mWindowVisible;
    boolean mWindowWasVisible;


}
