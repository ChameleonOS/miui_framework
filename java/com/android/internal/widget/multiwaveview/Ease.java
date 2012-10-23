// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget.multiwaveview;

import android.animation.TimeInterpolator;

class Ease {
    static class Sine {

        public static final TimeInterpolator easeIn = new TimeInterpolator() {

            public float getInterpolation(float f) {
                return 0.0F + (1.0F + -1F * (float)Math.cos(1.5707963267948966D * (double)(f / 1.0F)));
            }

        };
        public static final TimeInterpolator easeInOut = new TimeInterpolator() {

            public float getInterpolation(float f) {
                return 0.0F + -0.5F * ((float)Math.cos((3.1415926535897931D * (double)f) / 1.0D) - 1.0F);
            }

        };
        public static final TimeInterpolator easeOut = new TimeInterpolator() {

            public float getInterpolation(float f) {
                return 0.0F + 1.0F * (float)Math.sin(1.5707963267948966D * (double)(f / 1.0F));
            }

        };


        Sine() {
        }
    }

    static class Quint {

        public static final TimeInterpolator easeIn = new TimeInterpolator() {

            public float getInterpolation(float f) {
                float f1 = f / 1.0F;
                return 0.0F + f1 * (f1 * (f1 * (f1 * (1.0F * f1))));
            }

        };
        public static final TimeInterpolator easeInOut = new TimeInterpolator() {

            public float getInterpolation(float f) {
                float f1 = f / 0.5F;
                float f3;
                if(f1 < 1.0F) {
                    f3 = 0.0F + f1 * (f1 * (f1 * (f1 * (0.5F * f1))));
                } else {
                    float f2 = f1 - 2.0F;
                    f3 = 0.0F + 0.5F * (2.0F + f2 * (f2 * (f2 * (f2 * f2))));
                }
                return f3;
            }

        };
        public static final TimeInterpolator easeOut = new TimeInterpolator() {

            public float getInterpolation(float f) {
                float f1 = f / 1.0F - 1.0F;
                return 0.0F + 1.0F * (1.0F + f1 * (f1 * (f1 * (f1 * f1))));
            }

        };


        Quint() {
        }
    }

    static class Quart {

        public static final TimeInterpolator easeIn = new TimeInterpolator() {

            public float getInterpolation(float f) {
                float f1 = f / 1.0F;
                return 0.0F + f1 * (f1 * (f1 * (1.0F * f1)));
            }

        };
        public static final TimeInterpolator easeInOut = new TimeInterpolator() {

            public float getInterpolation(float f) {
                float f1 = f / 0.5F;
                float f3;
                if(f1 < 1.0F) {
                    f3 = 0.0F + f1 * (f1 * (f1 * (0.5F * f1)));
                } else {
                    float f2 = f1 - 2.0F;
                    f3 = 0.0F + -0.5F * (f2 * (f2 * (f2 * f2)) - 2.0F);
                }
                return f3;
            }

        };
        public static final TimeInterpolator easeOut = new TimeInterpolator() {

            public float getInterpolation(float f) {
                float f1 = f / 1.0F - 1.0F;
                return 0.0F + -1F * (f1 * (f1 * (f1 * f1)) - 1.0F);
            }

        };


        Quart() {
        }
    }

    static class Quad {

        public static final TimeInterpolator easeIn = new TimeInterpolator() {

            public float getInterpolation(float f) {
                float f1 = f / 1.0F;
                return 0.0F + f1 * (1.0F * f1);
            }

        };
        public static final TimeInterpolator easeInOut = new TimeInterpolator() {

            public float getInterpolation(float f) {
                float f1 = f / 0.5F;
                float f3;
                if(f1 < 1.0F) {
                    f3 = 0.0F + f1 * (0.5F * f1);
                } else {
                    float f2 = f1 - 1.0F;
                    f3 = 0.0F + -0.5F * (f2 * (f2 - 2.0F) - 1.0F);
                }
                return f3;
            }

        };
        public static final TimeInterpolator easeOut = new TimeInterpolator() {

            public float getInterpolation(float f) {
                float f1 = f / 1.0F;
                return 0.0F + -1F * f1 * (f1 - 2.0F);
            }

        };


        Quad() {
        }
    }

    static class Cubic {

        public static final TimeInterpolator easeIn = new TimeInterpolator() {

            public float getInterpolation(float f) {
                float f1 = f / 1.0F;
                return 0.0F + f1 * (f1 * (1.0F * f1));
            }

        };
        public static final TimeInterpolator easeInOut = new TimeInterpolator() {

            public float getInterpolation(float f) {
                float f1 = f / 0.5F;
                float f3;
                if(f1 < 1.0F) {
                    f3 = 0.0F + f1 * (f1 * (0.5F * f1));
                } else {
                    float f2 = f1 - 2.0F;
                    f3 = 0.0F + 0.5F * (2.0F + f2 * (f2 * f2));
                }
                return f3;
            }

        };
        public static final TimeInterpolator easeOut = new TimeInterpolator() {

            public float getInterpolation(float f) {
                float f1 = f / 1.0F - 1.0F;
                return 0.0F + 1.0F * (1.0F + f1 * (f1 * f1));
            }

        };


        Cubic() {
        }
    }

    static class Linear {

        public static final TimeInterpolator easeNone = new TimeInterpolator() {

            public float getInterpolation(float f) {
                return f;
            }

        };


        Linear() {
        }
    }


    Ease() {
    }

    private static final float DOMAIN = 1F;
    private static final float DURATION = 1F;
    private static final float START;
}
