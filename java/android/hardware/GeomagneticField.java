// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.hardware;

import java.util.GregorianCalendar;

public class GeomagneticField {
    private static class LegendreTable {

        static final boolean $assertionsDisabled;
        public final float mP[][];
        public final float mPDeriv[][];

        static  {
            boolean flag;
            if(!android/hardware/GeomagneticField.desiredAssertionStatus())
                flag = true;
            else
                flag = false;
            $assertionsDisabled = flag;
        }

        public LegendreTable(int i, float f) {
            float f1 = (float)Math.cos(f);
            float f2 = (float)Math.sin(f);
            mP = new float[i + 1][];
            mPDeriv = new float[i + 1][];
            float af[][] = mP;
            float af1[] = new float[1];
            af1[0] = 1.0F;
            af[0] = af1;
            float af2[][] = mPDeriv;
            float af3[] = new float[1];
            af3[0] = 0.0F;
            af2[0] = af3;
            for(int j = 1; j <= i; j++) {
                mP[j] = new float[j + 1];
                mPDeriv[j] = new float[j + 1];
                int k = 0;
                while(k <= j)  {
                    if(j == k) {
                        mP[j][k] = f2 * mP[j - 1][k - 1];
                        mPDeriv[j][k] = f1 * mP[j - 1][k - 1] + f2 * mPDeriv[j - 1][k - 1];
                    } else
                    if(j == 1 || k == j - 1) {
                        mP[j][k] = f1 * mP[j - 1][k];
                        mPDeriv[j][k] = -f2 * mP[j - 1][k] + f1 * mPDeriv[j - 1][k];
                    } else {
                        if(!$assertionsDisabled && (j <= 1 || k >= j - 1))
                            throw new AssertionError();
                        float f3 = (float)((j - 1) * (j - 1) - k * k) / (float)((-1 + j * 2) * (-3 + j * 2));
                        mP[j][k] = f1 * mP[j - 1][k] - f3 * mP[j - 2][k];
                        mPDeriv[j][k] = (-f2 * mP[j - 1][k] + f1 * mPDeriv[j - 1][k]) - f3 * mPDeriv[j - 2][k];
                    }
                    k++;
                }
            }

        }
    }


    public GeomagneticField(float f, float f1, float f2, long l) {
        int i = G_COEFF.length;
        float f3 = Math.min(89.99999F, Math.max(-89.99999F, f));
        computeGeocentricCoordinates(f3, f1, f2);
        if(!$assertionsDisabled && G_COEFF.length != H_COEFF.length)
            throw new AssertionError();
        LegendreTable legendretable = new LegendreTable(i - 1, (float)(1.5707963267948966D - (double)mGcLatitudeRad));
        float af[] = new float[i + 2];
        af[0] = 1.0F;
        af[1] = 6371.2F / mGcRadiusKm;
        for(int j = 2; j < af.length; j++)
            af[j] = af[j - 1] * af[1];

        float af1[] = new float[i];
        float af2[] = new float[i];
        af1[0] = 0.0F;
        af2[0] = 1.0F;
        af1[1] = (float)Math.sin(mGcLongitudeRad);
        af2[1] = (float)Math.cos(mGcLongitudeRad);
        for(int k = 2; k < i; k++) {
            int k1 = k >> 1;
            af1[k] = af1[k - k1] * af2[k1] + af2[k - k1] * af1[k1];
            af2[k] = af2[k - k1] * af2[k1] - af1[k - k1] * af1[k1];
        }

        float f4 = 1.0F / (float)Math.cos(mGcLatitudeRad);
        float f5 = (float)(l - BASE_TIME) / 3.1536E+10F;
        float f6 = 0.0F;
        float f7 = 0.0F;
        float f8 = 0.0F;
        for(int i1 = 1; i1 < i; i1++) {
            for(int j1 = 0; j1 <= i1; j1++) {
                float f9 = G_COEFF[i1][j1] + f5 * DELTA_G[i1][j1];
                float f10 = H_COEFF[i1][j1] + f5 * DELTA_H[i1][j1];
                f6 += af[i1 + 2] * (f9 * af2[j1] + f10 * af1[j1]) * legendretable.mPDeriv[i1][j1] * SCHMIDT_QUASI_NORM_FACTORS[i1][j1];
                f7 += f4 * (af[i1 + 2] * (float)j1 * (f9 * af1[j1] - f10 * af2[j1]) * legendretable.mP[i1][j1] * SCHMIDT_QUASI_NORM_FACTORS[i1][j1]);
                f8 -= (float)(i1 + 1) * af[i1 + 2] * (f9 * af2[j1] + f10 * af1[j1]) * legendretable.mP[i1][j1] * SCHMIDT_QUASI_NORM_FACTORS[i1][j1];
            }

        }

        double d = Math.toRadians(f3) - (double)mGcLatitudeRad;
        mX = (float)((double)f6 * Math.cos(d) + (double)f8 * Math.sin(d));
        mY = f7;
        mZ = (float)((double)(-f6) * Math.sin(d) + (double)f8 * Math.cos(d));
    }

    private void computeGeocentricCoordinates(float f, float f1, float f2) {
        float f3 = f2 / 1000F;
        double d = Math.toRadians(f);
        float f4 = (float)Math.cos(d);
        float f5 = (float)Math.sin(d);
        float f6 = f5 / f4;
        float f7 = (float)Math.sqrt(f4 * (4.068064E+07F * f4) + f5 * (4.04083E+07F * f5));
        mGcLatitudeRad = (float)Math.atan((f6 * (4.04083E+07F + f7 * f3)) / (4.068064E+07F + f7 * f3));
        mGcLongitudeRad = (float)Math.toRadians(f1);
        mGcRadiusKm = (float)Math.sqrt(f3 * f3 + 2.0F * f3 * (float)Math.sqrt(f4 * (4.068064E+07F * f4) + f5 * (4.04083E+07F * f5)) + (f4 * (f4 * (4.068064E+07F * 4.068064E+07F)) + f5 * (f5 * (4.04083E+07F * 4.04083E+07F))) / (f4 * (4.068064E+07F * f4) + f5 * (4.04083E+07F * f5)));
    }

    private static float[][] computeSchmidtQuasiNormFactors(int i) {
        float af[][] = new float[i + 1][];
        float af1[] = new float[1];
        af1[0] = 1.0F;
        af[0] = af1;
        for(int j = 1; j <= i; j++) {
            af[j] = new float[j + 1];
            af[j][0] = (af[j - 1][0] * (float)(-1 + j * 2)) / (float)j;
            int k = 1;
            while(k <= j)  {
                float af2[] = af[j];
                float f = af[j][k - 1];
                int l = 1 + (j - k);
                byte byte0;
                if(k == 1)
                    byte0 = 2;
                else
                    byte0 = 1;
                af2[k] = f * (float)Math.sqrt((float)(byte0 * l) / (float)(j + k));
                k++;
            }
        }

        return af;
    }

    public float getDeclination() {
        return (float)Math.toDegrees(Math.atan2(mY, mX));
    }

    public float getFieldStrength() {
        return (float)Math.sqrt(mX * mX + mY * mY + mZ * mZ);
    }

    public float getHorizontalStrength() {
        return (float)Math.sqrt(mX * mX + mY * mY);
    }

    public float getInclination() {
        return (float)Math.toDegrees(Math.atan2(mZ, getHorizontalStrength()));
    }

    public float getX() {
        return mX;
    }

    public float getY() {
        return mY;
    }

    public float getZ() {
        return mZ;
    }

    static final boolean $assertionsDisabled = false;
    private static final long BASE_TIME = 0L;
    private static final float DELTA_G[][];
    private static final float DELTA_H[][];
    private static final float EARTH_REFERENCE_RADIUS_KM = 6371.2F;
    private static final float EARTH_SEMI_MAJOR_AXIS_KM = 6378.137F;
    private static final float EARTH_SEMI_MINOR_AXIS_KM = 6356.752F;
    private static final float G_COEFF[][];
    private static final float H_COEFF[][];
    private static final float SCHMIDT_QUASI_NORM_FACTORS[][];
    private float mGcLatitudeRad;
    private float mGcLongitudeRad;
    private float mGcRadiusKm;
    private float mX;
    private float mY;
    private float mZ;

    static  {
        boolean flag;
        float af[][];
        float af1[];
        float af2[];
        float af3[];
        float af4[];
        float af5[];
        float af6[];
        float af7[];
        float af8[];
        float af9[];
        float af10[];
        float af11[];
        float af12[];
        float af13[];
        float af14[][];
        float af15[];
        float af16[];
        float af17[];
        float af18[];
        float af19[];
        float af20[];
        float af21[];
        float af22[];
        float af23[];
        float af24[];
        float af25[];
        float af26[];
        float af27[];
        float af28[][];
        float af29[];
        float af30[];
        float af31[];
        float af32[];
        float af33[];
        float af34[];
        float af35[];
        float af36[];
        float af37[];
        float af38[];
        float af39[];
        float af40[];
        float af41[];
        float af42[][];
        float af43[];
        float af44[];
        float af45[];
        float af46[];
        float af47[];
        float af48[];
        float af49[];
        float af50[];
        float af51[];
        float af52[];
        float af53[];
        float af54[];
        float af55[];
        if(!android/hardware/GeomagneticField.desiredAssertionStatus())
            flag = true;
        else
            flag = false;
        $assertionsDisabled = flag;
        af = new float[13][];
        af1 = new float[1];
        af1[0] = 0.0F;
        af[0] = af1;
        af2 = new float[2];
        af2[0] = -29496.6F;
        af2[1] = -1586.3F;
        af[1] = af2;
        af3 = new float[3];
        af3[0] = -2396.6F;
        af3[1] = 3026.1F;
        af3[2] = 1668.6F;
        af[2] = af3;
        af4 = new float[4];
        af4[0] = 1340.1F;
        af4[1] = -2326.2F;
        af4[2] = 1231.9F;
        af4[3] = 634F;
        af[3] = af4;
        af5 = new float[5];
        af5[0] = 912.6F;
        af5[1] = 808.9F;
        af5[2] = 166.7F;
        af5[3] = -357.1F;
        af5[4] = 89.4F;
        af[4] = af5;
        af6 = new float[6];
        af6[0] = -230.9F;
        af6[1] = 357.2F;
        af6[2] = 200.3F;
        af6[3] = -141.1F;
        af6[4] = -163F;
        af6[5] = -7.8F;
        af[5] = af6;
        af7 = new float[7];
        af7[0] = 72.8F;
        af7[1] = 68.6F;
        af7[2] = 76F;
        af7[3] = -141.4F;
        af7[4] = -22.8F;
        af7[5] = 13.2F;
        af7[6] = -77.9F;
        af[6] = af7;
        af8 = new float[8];
        af8[0] = 80.5F;
        af8[1] = -75.1F;
        af8[2] = -4.7F;
        af8[3] = 45.3F;
        af8[4] = 13.9F;
        af8[5] = 10.4F;
        af8[6] = 1.7F;
        af8[7] = 4.9F;
        af[7] = af8;
        af9 = new float[9];
        af9[0] = 24.4F;
        af9[1] = 8.1F;
        af9[2] = -14.5F;
        af9[3] = -5.6F;
        af9[4] = -19.3F;
        af9[5] = 11.5F;
        af9[6] = 10.9F;
        af9[7] = -14.1F;
        af9[8] = -3.7F;
        af[8] = af9;
        af10 = new float[10];
        af10[0] = 5.4F;
        af10[1] = 9.4F;
        af10[2] = 3.4F;
        af10[3] = -5.2F;
        af10[4] = 3.1F;
        af10[5] = -12.4F;
        af10[6] = -0.7F;
        af10[7] = 8.4F;
        af10[8] = -8.5F;
        af10[9] = -10.1F;
        af[9] = af10;
        af11 = new float[11];
        af11[0] = -2F;
        af11[1] = -6.3F;
        af11[2] = 0.9F;
        af11[3] = -1.1F;
        af11[4] = -0.2F;
        af11[5] = 2.5F;
        af11[6] = -0.3F;
        af11[7] = 2.2F;
        af11[8] = 3.1F;
        af11[9] = -1F;
        af11[10] = -2.8F;
        af[10] = af11;
        af12 = new float[12];
        af12[0] = 3F;
        af12[1] = -1.5F;
        af12[2] = -2.1F;
        af12[3] = 1.7F;
        af12[4] = -0.5F;
        af12[5] = 0.5F;
        af12[6] = -0.8F;
        af12[7] = 0.4F;
        af12[8] = 1.8F;
        af12[9] = 0.1F;
        af12[10] = 0.7F;
        af12[11] = 3.8F;
        af[11] = af12;
        af13 = new float[13];
        af13[0] = -2.2F;
        af13[1] = -0.2F;
        af13[2] = 0.3F;
        af13[3] = 1.0F;
        af13[4] = -0.6F;
        af13[5] = 0.9F;
        af13[6] = -0.1F;
        af13[7] = 0.5F;
        af13[8] = -0.4F;
        af13[9] = -0.4F;
        af13[10] = 0.2F;
        af13[11] = -0.8F;
        af13[12] = 0.0F;
        af[12] = af13;
        G_COEFF = af;
        af14 = new float[13][];
        af15 = new float[1];
        af15[0] = 0.0F;
        af14[0] = af15;
        af16 = new float[2];
        af16[0] = 0.0F;
        af16[1] = 4944.4F;
        af14[1] = af16;
        af17 = new float[3];
        af17[0] = 0.0F;
        af17[1] = -2707.7F;
        af17[2] = -576.1F;
        af14[2] = af17;
        af18 = new float[4];
        af18[0] = 0.0F;
        af18[1] = -160.2F;
        af18[2] = 251.9F;
        af18[3] = -536.6F;
        af14[3] = af18;
        af19 = new float[5];
        af19[0] = 0.0F;
        af19[1] = 286.4F;
        af19[2] = -211.2F;
        af19[3] = 164.3F;
        af19[4] = -309.1F;
        af14[4] = af19;
        af20 = new float[6];
        af20[0] = 0.0F;
        af20[1] = 44.6F;
        af20[2] = 188.9F;
        af20[3] = -118.2F;
        af20[4] = 0.0F;
        af20[5] = 100.9F;
        af14[5] = af20;
        af21 = new float[7];
        af21[0] = 0.0F;
        af21[1] = -20.8F;
        af21[2] = 44.1F;
        af21[3] = 61.5F;
        af21[4] = -66.3F;
        af21[5] = 3.1F;
        af21[6] = 55F;
        af14[6] = af21;
        af22 = new float[8];
        af22[0] = 0.0F;
        af22[1] = -57.9F;
        af22[2] = -21.1F;
        af22[3] = 6.5F;
        af22[4] = 24.9F;
        af22[5] = 7F;
        af22[6] = -27.7F;
        af22[7] = -3.3F;
        af14[7] = af22;
        af23 = new float[9];
        af23[0] = 0.0F;
        af23[1] = 11F;
        af23[2] = -20F;
        af23[3] = 11.9F;
        af23[4] = -17.4F;
        af23[5] = 16.7F;
        af23[6] = 7F;
        af23[7] = -10.8F;
        af23[8] = 1.7F;
        af14[8] = af23;
        af24 = new float[10];
        af24[0] = 0.0F;
        af24[1] = -20.5F;
        af24[2] = 11.5F;
        af24[3] = 12.8F;
        af24[4] = -7.2F;
        af24[5] = -7.4F;
        af24[6] = 8F;
        af24[7] = 2.1F;
        af24[8] = -6.1F;
        af24[9] = 7F;
        af14[9] = af24;
        af25 = new float[11];
        af25[0] = 0.0F;
        af25[1] = 2.8F;
        af25[2] = -0.1F;
        af25[3] = 4.7F;
        af25[4] = 4.4F;
        af25[5] = -7.2F;
        af25[6] = -1F;
        af25[7] = -3.9F;
        af25[8] = -2F;
        af25[9] = -2F;
        af25[10] = -8.3F;
        af14[10] = af25;
        af26 = new float[12];
        af26[0] = 0.0F;
        af26[1] = 0.2F;
        af26[2] = 1.7F;
        af26[3] = -0.6F;
        af26[4] = -1.8F;
        af26[5] = 0.9F;
        af26[6] = -0.4F;
        af26[7] = -2.5F;
        af26[8] = -1.3F;
        af26[9] = -2.1F;
        af26[10] = -1.9F;
        af26[11] = -1.8F;
        af14[11] = af26;
        af27 = new float[13];
        af27[0] = 0.0F;
        af27[1] = -0.9F;
        af27[2] = 0.3F;
        af27[3] = 2.1F;
        af27[4] = -2.5F;
        af27[5] = 0.5F;
        af27[6] = 0.6F;
        af27[7] = 0.0F;
        af27[8] = 0.1F;
        af27[9] = 0.3F;
        af27[10] = -0.9F;
        af27[11] = -0.2F;
        af27[12] = 0.9F;
        af14[12] = af27;
        H_COEFF = af14;
        af28 = new float[13][];
        af29 = new float[1];
        af29[0] = 0.0F;
        af28[0] = af29;
        af30 = new float[2];
        af30[0] = 11.6F;
        af30[1] = 16.5F;
        af28[1] = af30;
        af31 = new float[3];
        af31[0] = -12.1F;
        af31[1] = -4.4F;
        af31[2] = 1.9F;
        af28[2] = af31;
        af32 = new float[4];
        af32[0] = 0.4F;
        af32[1] = -4.1F;
        af32[2] = -2.9F;
        af32[3] = -7.7F;
        af28[3] = af32;
        af33 = new float[5];
        af33[0] = -1.8F;
        af33[1] = 2.3F;
        af33[2] = -8.7F;
        af33[3] = 4.6F;
        af33[4] = -2.1F;
        af28[4] = af33;
        af34 = new float[6];
        af34[0] = -1F;
        af34[1] = 0.6F;
        af34[2] = -1.8F;
        af34[3] = -1F;
        af34[4] = 0.9F;
        af34[5] = 1.0F;
        af28[5] = af34;
        af35 = new float[7];
        af35[0] = -0.2F;
        af35[1] = -0.2F;
        af35[2] = -0.1F;
        af35[3] = 2.0F;
        af35[4] = -1.7F;
        af35[5] = -0.3F;
        af35[6] = 1.7F;
        af28[6] = af35;
        af36 = new float[8];
        af36[0] = 0.1F;
        af36[1] = -0.1F;
        af36[2] = -0.6F;
        af36[3] = 1.3F;
        af36[4] = 0.4F;
        af36[5] = 0.3F;
        af36[6] = -0.7F;
        af36[7] = 0.6F;
        af28[7] = af36;
        af37 = new float[9];
        af37[0] = -0.1F;
        af37[1] = 0.1F;
        af37[2] = -0.6F;
        af37[3] = 0.2F;
        af37[4] = -0.2F;
        af37[5] = 0.3F;
        af37[6] = 0.3F;
        af37[7] = -0.6F;
        af37[8] = 0.2F;
        af28[8] = af37;
        af38 = new float[10];
        af38[0] = 0.0F;
        af38[1] = -0.1F;
        af38[2] = 0.0F;
        af38[3] = 0.3F;
        af38[4] = -0.4F;
        af38[5] = -0.3F;
        af38[6] = 0.1F;
        af38[7] = -0.1F;
        af38[8] = -0.4F;
        af38[9] = -0.2F;
        af28[9] = af38;
        af39 = new float[11];
        af39[0] = 0.0F;
        af39[1] = 0.0F;
        af39[2] = -0.1F;
        af39[3] = 0.2F;
        af39[4] = 0.0F;
        af39[5] = -0.1F;
        af39[6] = -0.2F;
        af39[7] = 0.0F;
        af39[8] = -0.1F;
        af39[9] = -0.2F;
        af39[10] = -0.2F;
        af28[10] = af39;
        af40 = new float[12];
        af40[0] = 0.0F;
        af40[1] = 0.0F;
        af40[2] = 0.0F;
        af40[3] = 0.1F;
        af40[4] = 0.0F;
        af40[5] = 0.0F;
        af40[6] = 0.0F;
        af40[7] = 0.0F;
        af40[8] = 0.0F;
        af40[9] = 0.0F;
        af40[10] = -0.1F;
        af40[11] = 0.0F;
        af28[11] = af40;
        af41 = new float[13];
        af41[0] = 0.0F;
        af41[1] = 0.0F;
        af41[2] = 0.1F;
        af41[3] = 0.1F;
        af41[4] = -0.1F;
        af41[5] = 0.0F;
        af41[6] = 0.0F;
        af41[7] = 0.0F;
        af41[8] = 0.0F;
        af41[9] = 0.0F;
        af41[10] = 0.0F;
        af41[11] = -0.1F;
        af41[12] = 0.1F;
        af28[12] = af41;
        DELTA_G = af28;
        af42 = new float[13][];
        af43 = new float[1];
        af43[0] = 0.0F;
        af42[0] = af43;
        af44 = new float[2];
        af44[0] = 0.0F;
        af44[1] = -25.9F;
        af42[1] = af44;
        af45 = new float[3];
        af45[0] = 0.0F;
        af45[1] = -22.5F;
        af45[2] = -11.8F;
        af42[2] = af45;
        af46 = new float[4];
        af46[0] = 0.0F;
        af46[1] = 7.3F;
        af46[2] = -3.9F;
        af46[3] = -2.6F;
        af42[3] = af46;
        af47 = new float[5];
        af47[0] = 0.0F;
        af47[1] = 1.1F;
        af47[2] = 2.7F;
        af47[3] = 3.9F;
        af47[4] = -0.8F;
        af42[4] = af47;
        af48 = new float[6];
        af48[0] = 0.0F;
        af48[1] = 0.4F;
        af48[2] = 1.8F;
        af48[3] = 1.2F;
        af48[4] = 4F;
        af48[5] = -0.6F;
        af42[5] = af48;
        af49 = new float[7];
        af49[0] = 0.0F;
        af49[1] = -0.2F;
        af49[2] = -2.1F;
        af49[3] = -0.4F;
        af49[4] = -0.6F;
        af49[5] = 0.5F;
        af49[6] = 0.9F;
        af42[6] = af49;
        af50 = new float[8];
        af50[0] = 0.0F;
        af50[1] = 0.7F;
        af50[2] = 0.3F;
        af50[3] = -0.1F;
        af50[4] = -0.1F;
        af50[5] = -0.8F;
        af50[6] = -0.3F;
        af50[7] = 0.3F;
        af42[7] = af50;
        af51 = new float[9];
        af51[0] = 0.0F;
        af51[1] = -0.1F;
        af51[2] = 0.2F;
        af51[3] = 0.4F;
        af51[4] = 0.4F;
        af51[5] = 0.1F;
        af51[6] = -0.1F;
        af51[7] = 0.4F;
        af51[8] = 0.3F;
        af42[8] = af51;
        af52 = new float[10];
        af52[0] = 0.0F;
        af52[1] = 0.0F;
        af52[2] = -0.2F;
        af52[3] = 0.0F;
        af52[4] = -0.1F;
        af52[5] = 0.1F;
        af52[6] = 0.0F;
        af52[7] = -0.2F;
        af52[8] = 0.3F;
        af52[9] = 0.2F;
        af42[9] = af52;
        af53 = new float[11];
        af53[0] = 0.0F;
        af53[1] = 0.1F;
        af53[2] = -0.1F;
        af53[3] = 0.0F;
        af53[4] = -0.1F;
        af53[5] = -0.1F;
        af53[6] = 0.0F;
        af53[7] = -0.1F;
        af53[8] = -0.2F;
        af53[9] = 0.0F;
        af53[10] = -0.1F;
        af42[10] = af53;
        af54 = new float[12];
        af54[0] = 0.0F;
        af54[1] = 0.0F;
        af54[2] = 0.1F;
        af54[3] = 0.0F;
        af54[4] = 0.1F;
        af54[5] = 0.0F;
        af54[6] = 0.1F;
        af54[7] = 0.0F;
        af54[8] = -0.1F;
        af54[9] = -0.1F;
        af54[10] = 0.0F;
        af54[11] = -0.1F;
        af42[11] = af54;
        af55 = new float[13];
        af55[0] = 0.0F;
        af55[1] = 0.0F;
        af55[2] = 0.0F;
        af55[3] = 0.0F;
        af55[4] = 0.0F;
        af55[5] = 0.0F;
        af55[6] = 0.1F;
        af55[7] = 0.0F;
        af55[8] = 0.0F;
        af55[9] = 0.0F;
        af55[10] = 0.0F;
        af55[11] = 0.0F;
        af55[12] = 0.0F;
        af42[12] = af55;
        DELTA_H = af42;
        BASE_TIME = (new GregorianCalendar(2010, 1, 1)).getTimeInMillis();
        SCHMIDT_QUASI_NORM_FACTORS = computeSchmidtQuasiNormFactors(G_COEFF.length);
    }
}
