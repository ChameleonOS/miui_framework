// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.content.Context;
import android.hardware.SensorListener;

// Referenced classes of package android.view:
//            OrientationEventListener

public abstract class OrientationListener
    implements SensorListener {
    class OrientationEventListenerInternal extends OrientationEventListener {

        public void onOrientationChanged(int i) {
            OrientationListener.this.onOrientationChanged(i);
        }

        final OrientationListener this$0;

        OrientationEventListenerInternal(Context context) {
            this$0 = OrientationListener.this;
            super(context);
        }

        OrientationEventListenerInternal(Context context, int i) {
            this$0 = OrientationListener.this;
            super(context, i);
            registerListener(OrientationListener.this);
        }
    }


    public OrientationListener(Context context) {
        mOrientationEventLis = new OrientationEventListenerInternal(context);
    }

    public OrientationListener(Context context, int i) {
        mOrientationEventLis = new OrientationEventListenerInternal(context, i);
    }

    public void disable() {
        mOrientationEventLis.disable();
    }

    public void enable() {
        mOrientationEventLis.enable();
    }

    public void onAccuracyChanged(int i, int j) {
    }

    public abstract void onOrientationChanged(int i);

    public void onSensorChanged(int i, float af[]) {
    }

    public static final int ORIENTATION_UNKNOWN = -1;
    private OrientationEventListener mOrientationEventLis;
}
