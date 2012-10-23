// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.accessibility;


// Referenced classes of package android.view.accessibility:
//            AccessibilityEvent

public interface AccessibilityEventSource {

    public abstract void sendAccessibilityEvent(int i);

    public abstract void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityevent);
}
