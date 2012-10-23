// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.hardware;

import android.graphics.*;
import android.os.*;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.*;

public class Camera {
    public class Parameters {

        private String cameraFormatForPixelFormat(int i) {
            i;
            JVM INSTR lookupswitch 7: default 68
        //                       4: 99
        //                       16: 72
        //                       17: 79
        //                       20: 86
        //                       256: 105
        //                       512: 111
        //                       842094169: 93;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
            String s = null;
_L10:
            return s;
_L3:
            s = "yuv422sp";
            continue; /* Loop/switch isn't completed */
_L4:
            s = "yuv420sp";
            continue; /* Loop/switch isn't completed */
_L5:
            s = "yuv422i-yuyv";
            continue; /* Loop/switch isn't completed */
_L8:
            s = "yuv420p";
            continue; /* Loop/switch isn't completed */
_L2:
            s = "rgb565";
            continue; /* Loop/switch isn't completed */
_L6:
            s = "jpeg";
            continue; /* Loop/switch isn't completed */
_L7:
            s = "bayer-rggb";
            if(true) goto _L10; else goto _L9
_L9:
        }

        private float getFloat(String s, float f) {
            float f1 = Float.parseFloat((String)mMap.get(s));
            f = f1;
_L2:
            return f;
            NumberFormatException numberformatexception;
            numberformatexception;
            if(true) goto _L2; else goto _L1
_L1:
        }

        private int getInt(String s, int i) {
            int j = Integer.parseInt((String)mMap.get(s));
            i = j;
_L2:
            return i;
            NumberFormatException numberformatexception;
            numberformatexception;
            if(true) goto _L2; else goto _L1
_L1:
        }

        private int pixelFormatForCameraFormat(String s) {
            int i = 0;
            if(s != null) goto _L2; else goto _L1
_L1:
            return i;
_L2:
            if(s.equals("yuv422sp"))
                i = 16;
            else
            if(s.equals("yuv420sp"))
                i = 17;
            else
            if(s.equals("yuv422i-yuyv"))
                i = 20;
            else
            if(s.equals("yuv420p"))
                i = 0x32315659;
            else
            if(s.equals("rgb565"))
                i = 4;
            else
            if(s.equals("jpeg"))
                i = 256;
            if(true) goto _L1; else goto _L3
_L3:
        }

        private boolean same(String s, String s1) {
            boolean flag;
            flag = true;
            break MISSING_BLOCK_LABEL_2;
            if((s != null || s1 != null) && (s == null || !s.equals(s1)))
                flag = false;
            return flag;
        }

        private void set(String s, List list) {
            if(list == null) {
                set(s, "(0,0,0,0,0)");
            } else {
                StringBuilder stringbuilder = new StringBuilder();
                for(int i = 0; i < list.size(); i++) {
                    Area area = (Area)list.get(i);
                    Rect rect = area.rect;
                    stringbuilder.append('(');
                    stringbuilder.append(rect.left);
                    stringbuilder.append(',');
                    stringbuilder.append(rect.top);
                    stringbuilder.append(',');
                    stringbuilder.append(rect.right);
                    stringbuilder.append(',');
                    stringbuilder.append(rect.bottom);
                    stringbuilder.append(',');
                    stringbuilder.append(area.weight);
                    stringbuilder.append(')');
                    if(i != -1 + list.size())
                        stringbuilder.append(',');
                }

                set(s, stringbuilder.toString());
            }
        }

        private ArrayList split(String s) {
            ArrayList arraylist;
            if(s == null) {
                arraylist = null;
            } else {
                StringTokenizer stringtokenizer = new StringTokenizer(s, ",");
                arraylist = new ArrayList();
                while(stringtokenizer.hasMoreElements()) 
                    arraylist.add(stringtokenizer.nextToken());
            }
            return arraylist;
        }

        private ArrayList splitArea(String s) {
            if(s != null && s.charAt(0) == '(' && s.charAt(-1 + s.length()) == ')') goto _L2; else goto _L1
_L1:
            ArrayList arraylist;
            Log.e("Camera", (new StringBuilder()).append("Invalid area string=").append(s).toString());
            arraylist = null;
_L4:
            return arraylist;
_L2:
            arraylist = new ArrayList();
            int i = 1;
            int ai[] = new int[5];
            int j;
            do {
                j = s.indexOf("),(", i);
                if(j == -1)
                    j = -1 + s.length();
                splitInt(s.substring(i, j), ai);
                arraylist.add(new Area(new Rect(ai[0], ai[1], ai[2], ai[3]), ai[4]));
                i = j + 3;
            } while(j != -1 + s.length());
            if(arraylist.size() == 0)
                arraylist = null;
            else
            if(arraylist.size() == 1) {
                Area area = (Area)arraylist.get(0);
                Rect rect = area.rect;
                if(rect.left == 0 && rect.top == 0 && rect.right == 0 && rect.bottom == 0 && area.weight == 0)
                    arraylist = null;
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        private void splitFloat(String s, float af[]) {
            if(s != null) {
                StringTokenizer stringtokenizer = new StringTokenizer(s, ",");
                int i = 0;
                while(stringtokenizer.hasMoreElements())  {
                    String s1 = stringtokenizer.nextToken();
                    int j = i + 1;
                    af[i] = Float.parseFloat(s1);
                    i = j;
                }
            }
        }

        private ArrayList splitInt(String s) {
            if(s != null) goto _L2; else goto _L1
_L1:
            ArrayList arraylist = null;
_L4:
            return arraylist;
_L2:
            StringTokenizer stringtokenizer = new StringTokenizer(s, ",");
            arraylist = new ArrayList();
            for(; stringtokenizer.hasMoreElements(); arraylist.add(Integer.valueOf(Integer.parseInt(stringtokenizer.nextToken()))));
            if(arraylist.size() == 0)
                arraylist = null;
            if(true) goto _L4; else goto _L3
_L3:
        }

        private void splitInt(String s, int ai[]) {
            if(s != null) {
                StringTokenizer stringtokenizer = new StringTokenizer(s, ",");
                int i = 0;
                while(stringtokenizer.hasMoreElements())  {
                    String s1 = stringtokenizer.nextToken();
                    int j = i + 1;
                    ai[i] = Integer.parseInt(s1);
                    i = j;
                }
            }
        }

        private ArrayList splitRange(String s) {
            if(s != null && s.charAt(0) == '(' && s.charAt(-1 + s.length()) == ')') goto _L2; else goto _L1
_L1:
            ArrayList arraylist;
            Log.e("Camera", (new StringBuilder()).append("Invalid range list string=").append(s).toString());
            arraylist = null;
_L4:
            return arraylist;
_L2:
            arraylist = new ArrayList();
            int i = 1;
            int j;
            do {
                int ai[] = new int[2];
                j = s.indexOf("),(", i);
                if(j == -1)
                    j = -1 + s.length();
                splitInt(s.substring(i, j), ai);
                arraylist.add(ai);
                i = j + 3;
            } while(j != -1 + s.length());
            if(arraylist.size() == 0)
                arraylist = null;
            if(true) goto _L4; else goto _L3
_L3:
        }

        private ArrayList splitSize(String s) {
            if(s != null) goto _L2; else goto _L1
_L1:
            ArrayList arraylist = null;
_L4:
            return arraylist;
_L2:
            StringTokenizer stringtokenizer = new StringTokenizer(s, ",");
            arraylist = new ArrayList();
            do {
                if(!stringtokenizer.hasMoreElements())
                    break;
                Size size = strToSize(stringtokenizer.nextToken());
                if(size != null)
                    arraylist.add(size);
            } while(true);
            if(arraylist.size() == 0)
                arraylist = null;
            if(true) goto _L4; else goto _L3
_L3:
        }

        private Size strToSize(String s) {
            Size size = null;
            if(s != null) {
                int i = s.indexOf('x');
                if(i != -1) {
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i + 1);
                    size = new Size(Integer.parseInt(s1), Integer.parseInt(s2));
                } else {
                    Log.e("Camera", (new StringBuilder()).append("Invalid size parameter string=").append(s).toString());
                }
            }
            return size;
        }

        public void dump() {
            Log.e("Camera", (new StringBuilder()).append("dump: size=").append(mMap.size()).toString());
            String s;
            for(Iterator iterator = mMap.keySet().iterator(); iterator.hasNext(); Log.e("Camera", (new StringBuilder()).append("dump: ").append(s).append("=").append((String)mMap.get(s)).toString()))
                s = (String)iterator.next();

        }

        public String flatten() {
            StringBuilder stringbuilder = new StringBuilder();
            for(Iterator iterator = mMap.keySet().iterator(); iterator.hasNext(); stringbuilder.append(";")) {
                String s = (String)iterator.next();
                stringbuilder.append(s);
                stringbuilder.append("=");
                stringbuilder.append((String)mMap.get(s));
            }

            stringbuilder.deleteCharAt(-1 + stringbuilder.length());
            return stringbuilder.toString();
        }

        public String get(String s) {
            return (String)mMap.get(s);
        }

        public String getAntibanding() {
            return get("antibanding");
        }

        public boolean getAutoExposureLock() {
            return "true".equals(get("auto-exposure-lock"));
        }

        public boolean getAutoWhiteBalanceLock() {
            return "true".equals(get("auto-whitebalance-lock"));
        }

        public String getColorEffect() {
            return get("effect");
        }

        public int getExposureCompensation() {
            return getInt("exposure-compensation", 0);
        }

        public float getExposureCompensationStep() {
            return getFloat("exposure-compensation-step", 0.0F);
        }

        public String getFlashMode() {
            return get("flash-mode");
        }

        public float getFocalLength() {
            return Float.parseFloat(get("focal-length"));
        }

        public List getFocusAreas() {
            return splitArea(get("focus-areas"));
        }

        public void getFocusDistances(float af[]) {
            if(af == null || af.length != 3) {
                throw new IllegalArgumentException("output must be a float array with three elements.");
            } else {
                splitFloat(get("focus-distances"), af);
                return;
            }
        }

        public String getFocusMode() {
            return get("focus-mode");
        }

        public float getHorizontalViewAngle() {
            return Float.parseFloat(get("horizontal-view-angle"));
        }

        public int getInt(String s) {
            return Integer.parseInt((String)mMap.get(s));
        }

        public int getJpegQuality() {
            return getInt("jpeg-quality");
        }

        public int getJpegThumbnailQuality() {
            return getInt("jpeg-thumbnail-quality");
        }

        public Size getJpegThumbnailSize() {
            return new Size(getInt("jpeg-thumbnail-width"), getInt("jpeg-thumbnail-height"));
        }

        public int getMaxExposureCompensation() {
            return getInt("max-exposure-compensation", 0);
        }

        public int getMaxNumDetectedFaces() {
            return getInt("max-num-detected-faces-hw", 0);
        }

        public int getMaxNumFocusAreas() {
            return getInt("max-num-focus-areas", 0);
        }

        public int getMaxNumMeteringAreas() {
            return getInt("max-num-metering-areas", 0);
        }

        public int getMaxZoom() {
            return getInt("max-zoom", 0);
        }

        public List getMeteringAreas() {
            return splitArea(get("metering-areas"));
        }

        public int getMinExposureCompensation() {
            return getInt("min-exposure-compensation", 0);
        }

        public int getPictureFormat() {
            return pixelFormatForCameraFormat(get("picture-format"));
        }

        public Size getPictureSize() {
            return strToSize(get("picture-size"));
        }

        public Size getPreferredPreviewSizeForVideo() {
            return strToSize(get("preferred-preview-size-for-video"));
        }

        public int getPreviewFormat() {
            return pixelFormatForCameraFormat(get("preview-format"));
        }

        public void getPreviewFpsRange(int ai[]) {
            if(ai == null || ai.length != 2) {
                throw new IllegalArgumentException("range must be an array with two elements.");
            } else {
                splitInt(get("preview-fps-range"), ai);
                return;
            }
        }

        public int getPreviewFrameRate() {
            return getInt("preview-frame-rate");
        }

        public Size getPreviewSize() {
            return strToSize(get("preview-size"));
        }

        public String getSceneMode() {
            return get("scene-mode");
        }

        public List getSupportedAntibanding() {
            return split(get("antibanding-values"));
        }

        public List getSupportedColorEffects() {
            return split(get("effect-values"));
        }

        public List getSupportedFlashModes() {
            return split(get("flash-mode-values"));
        }

        public List getSupportedFocusModes() {
            return split(get("focus-mode-values"));
        }

        public List getSupportedJpegThumbnailSizes() {
            return splitSize(get("jpeg-thumbnail-size-values"));
        }

        public List getSupportedPictureFormats() {
            String s = get("picture-format-values");
            ArrayList arraylist = new ArrayList();
            Iterator iterator = split(s).iterator();
            do {
                if(!iterator.hasNext())
                    break;
                int i = pixelFormatForCameraFormat((String)iterator.next());
                if(i != 0)
                    arraylist.add(Integer.valueOf(i));
            } while(true);
            return arraylist;
        }

        public List getSupportedPictureSizes() {
            return splitSize(get("picture-size-values"));
        }

        public List getSupportedPreviewFormats() {
            String s = get("preview-format-values");
            ArrayList arraylist = new ArrayList();
            Iterator iterator = split(s).iterator();
            do {
                if(!iterator.hasNext())
                    break;
                int i = pixelFormatForCameraFormat((String)iterator.next());
                if(i != 0)
                    arraylist.add(Integer.valueOf(i));
            } while(true);
            return arraylist;
        }

        public List getSupportedPreviewFpsRange() {
            return splitRange(get("preview-fps-range-values"));
        }

        public List getSupportedPreviewFrameRates() {
            return splitInt(get("preview-frame-rate-values"));
        }

        public List getSupportedPreviewSizes() {
            return splitSize(get("preview-size-values"));
        }

        public List getSupportedSceneModes() {
            return split(get("scene-mode-values"));
        }

        public List getSupportedVideoSizes() {
            return splitSize(get("video-size-values"));
        }

        public List getSupportedWhiteBalance() {
            return split(get("whitebalance-values"));
        }

        public float getVerticalViewAngle() {
            return Float.parseFloat(get("vertical-view-angle"));
        }

        public boolean getVideoStabilization() {
            return "true".equals(get("video-stabilization"));
        }

        public String getWhiteBalance() {
            return get("whitebalance");
        }

        public int getZoom() {
            return getInt("zoom", 0);
        }

        public List getZoomRatios() {
            return splitInt(get("zoom-ratios"));
        }

        public boolean isAutoExposureLockSupported() {
            return "true".equals(get("auto-exposure-lock-supported"));
        }

        public boolean isAutoWhiteBalanceLockSupported() {
            return "true".equals(get("auto-whitebalance-lock-supported"));
        }

        public boolean isSmoothZoomSupported() {
            return "true".equals(get("smooth-zoom-supported"));
        }

        public boolean isVideoSnapshotSupported() {
            return "true".equals(get("video-snapshot-supported"));
        }

        public boolean isVideoStabilizationSupported() {
            return "true".equals(get("video-stabilization-supported"));
        }

        public boolean isZoomSupported() {
            return "true".equals(get("zoom-supported"));
        }

        public void remove(String s) {
            mMap.remove(s);
        }

        public void removeGpsData() {
            remove("gps-latitude");
            remove("gps-longitude");
            remove("gps-altitude");
            remove("gps-timestamp");
            remove("gps-processing-method");
        }

        public void set(String s, int i) {
            mMap.put(s, Integer.toString(i));
        }

        public void set(String s, String s1) {
            if(s.indexOf('=') != -1 || s.indexOf(';') != -1 || s.indexOf('\0') != -1)
                Log.e("Camera", (new StringBuilder()).append("Key \"").append(s).append("\" contains invalid character (= or ; or \\0)").toString());
            else
            if(s1.indexOf('=') != -1 || s1.indexOf(';') != -1 || s1.indexOf('\0') != -1)
                Log.e("Camera", (new StringBuilder()).append("Value \"").append(s1).append("\" contains invalid character (= or ; or \\0)").toString());
            else
                mMap.put(s, s1);
        }

        public void setAntibanding(String s) {
            set("antibanding", s);
        }

        public void setAutoExposureLock(boolean flag) {
            String s;
            if(flag)
                s = "true";
            else
                s = "false";
            set("auto-exposure-lock", s);
        }

        public void setAutoWhiteBalanceLock(boolean flag) {
            String s;
            if(flag)
                s = "true";
            else
                s = "false";
            set("auto-whitebalance-lock", s);
        }

        public void setColorEffect(String s) {
            set("effect", s);
        }

        public void setExposureCompensation(int i) {
            set("exposure-compensation", i);
        }

        public void setFlashMode(String s) {
            set("flash-mode", s);
        }

        public void setFocusAreas(List list) {
            set("focus-areas", list);
        }

        public void setFocusMode(String s) {
            set("focus-mode", s);
        }

        public void setGpsAltitude(double d) {
            set("gps-altitude", Double.toString(d));
        }

        public void setGpsLatitude(double d) {
            set("gps-latitude", Double.toString(d));
        }

        public void setGpsLongitude(double d) {
            set("gps-longitude", Double.toString(d));
        }

        public void setGpsProcessingMethod(String s) {
            set("gps-processing-method", s);
        }

        public void setGpsTimestamp(long l) {
            set("gps-timestamp", Long.toString(l));
        }

        public void setJpegQuality(int i) {
            set("jpeg-quality", i);
        }

        public void setJpegThumbnailQuality(int i) {
            set("jpeg-thumbnail-quality", i);
        }

        public void setJpegThumbnailSize(int i, int j) {
            set("jpeg-thumbnail-width", i);
            set("jpeg-thumbnail-height", j);
        }

        public void setMeteringAreas(List list) {
            set("metering-areas", list);
        }

        public void setPictureFormat(int i) {
            String s = cameraFormatForPixelFormat(i);
            if(s == null) {
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid pixel_format=").append(i).toString());
            } else {
                set("picture-format", s);
                return;
            }
        }

        public void setPictureSize(int i, int j) {
            set("picture-size", (new StringBuilder()).append(Integer.toString(i)).append("x").append(Integer.toString(j)).toString());
        }

        public void setPreviewFormat(int i) {
            String s = cameraFormatForPixelFormat(i);
            if(s == null) {
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid pixel_format=").append(i).toString());
            } else {
                set("preview-format", s);
                return;
            }
        }

        public void setPreviewFpsRange(int i, int j) {
            set("preview-fps-range", (new StringBuilder()).append("").append(i).append(",").append(j).toString());
        }

        public void setPreviewFrameRate(int i) {
            set("preview-frame-rate", i);
        }

        public void setPreviewSize(int i, int j) {
            set("preview-size", (new StringBuilder()).append(Integer.toString(i)).append("x").append(Integer.toString(j)).toString());
        }

        public void setRecordingHint(boolean flag) {
            String s;
            if(flag)
                s = "true";
            else
                s = "false";
            set("recording-hint", s);
        }

        public void setRotation(int i) {
            if(i == 0 || i == 90 || i == 180 || i == 270) {
                set("rotation", Integer.toString(i));
                return;
            } else {
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid rotation=").append(i).toString());
            }
        }

        public void setSceneMode(String s) {
            set("scene-mode", s);
        }

        public void setVideoStabilization(boolean flag) {
            String s;
            if(flag)
                s = "true";
            else
                s = "false";
            set("video-stabilization", s);
        }

        public void setWhiteBalance(String s) {
            if(!same(s, get("whitebalance"))) {
                set("whitebalance", s);
                set("auto-whitebalance-lock", "false");
            }
        }

        public void setZoom(int i) {
            set("zoom", i);
        }

        public void unflatten(String s) {
            mMap.clear();
            StringTokenizer stringtokenizer = new StringTokenizer(s, ";");
            do {
                if(!stringtokenizer.hasMoreElements())
                    break;
                String s1 = stringtokenizer.nextToken();
                int i = s1.indexOf('=');
                if(i != -1) {
                    String s2 = s1.substring(0, i);
                    String s3 = s1.substring(i + 1);
                    mMap.put(s2, s3);
                }
            } while(true);
        }

        public static final String ANTIBANDING_50HZ = "50hz";
        public static final String ANTIBANDING_60HZ = "60hz";
        public static final String ANTIBANDING_AUTO = "auto";
        public static final String ANTIBANDING_OFF = "off";
        public static final String EFFECT_AQUA = "aqua";
        public static final String EFFECT_BLACKBOARD = "blackboard";
        public static final String EFFECT_MONO = "mono";
        public static final String EFFECT_NEGATIVE = "negative";
        public static final String EFFECT_NONE = "none";
        public static final String EFFECT_POSTERIZE = "posterize";
        public static final String EFFECT_SEPIA = "sepia";
        public static final String EFFECT_SOLARIZE = "solarize";
        public static final String EFFECT_WHITEBOARD = "whiteboard";
        private static final String FALSE = "false";
        public static final String FLASH_MODE_AUTO = "auto";
        public static final String FLASH_MODE_OFF = "off";
        public static final String FLASH_MODE_ON = "on";
        public static final String FLASH_MODE_RED_EYE = "red-eye";
        public static final String FLASH_MODE_TORCH = "torch";
        public static final int FOCUS_DISTANCE_FAR_INDEX = 2;
        public static final int FOCUS_DISTANCE_NEAR_INDEX = 0;
        public static final int FOCUS_DISTANCE_OPTIMAL_INDEX = 1;
        public static final String FOCUS_MODE_AUTO = "auto";
        public static final String FOCUS_MODE_CONTINUOUS_PICTURE = "continuous-picture";
        public static final String FOCUS_MODE_CONTINUOUS_VIDEO = "continuous-video";
        public static final String FOCUS_MODE_EDOF = "edof";
        public static final String FOCUS_MODE_FIXED = "fixed";
        public static final String FOCUS_MODE_INFINITY = "infinity";
        public static final String FOCUS_MODE_MACRO = "macro";
        private static final String KEY_ANTIBANDING = "antibanding";
        private static final String KEY_AUTO_EXPOSURE_LOCK = "auto-exposure-lock";
        private static final String KEY_AUTO_EXPOSURE_LOCK_SUPPORTED = "auto-exposure-lock-supported";
        private static final String KEY_AUTO_WHITEBALANCE_LOCK = "auto-whitebalance-lock";
        private static final String KEY_AUTO_WHITEBALANCE_LOCK_SUPPORTED = "auto-whitebalance-lock-supported";
        private static final String KEY_EFFECT = "effect";
        private static final String KEY_EXPOSURE_COMPENSATION = "exposure-compensation";
        private static final String KEY_EXPOSURE_COMPENSATION_STEP = "exposure-compensation-step";
        private static final String KEY_FLASH_MODE = "flash-mode";
        private static final String KEY_FOCAL_LENGTH = "focal-length";
        private static final String KEY_FOCUS_AREAS = "focus-areas";
        private static final String KEY_FOCUS_DISTANCES = "focus-distances";
        private static final String KEY_FOCUS_MODE = "focus-mode";
        private static final String KEY_GPS_ALTITUDE = "gps-altitude";
        private static final String KEY_GPS_LATITUDE = "gps-latitude";
        private static final String KEY_GPS_LONGITUDE = "gps-longitude";
        private static final String KEY_GPS_PROCESSING_METHOD = "gps-processing-method";
        private static final String KEY_GPS_TIMESTAMP = "gps-timestamp";
        private static final String KEY_HORIZONTAL_VIEW_ANGLE = "horizontal-view-angle";
        private static final String KEY_JPEG_QUALITY = "jpeg-quality";
        private static final String KEY_JPEG_THUMBNAIL_HEIGHT = "jpeg-thumbnail-height";
        private static final String KEY_JPEG_THUMBNAIL_QUALITY = "jpeg-thumbnail-quality";
        private static final String KEY_JPEG_THUMBNAIL_SIZE = "jpeg-thumbnail-size";
        private static final String KEY_JPEG_THUMBNAIL_WIDTH = "jpeg-thumbnail-width";
        private static final String KEY_MAX_EXPOSURE_COMPENSATION = "max-exposure-compensation";
        private static final String KEY_MAX_NUM_DETECTED_FACES_HW = "max-num-detected-faces-hw";
        private static final String KEY_MAX_NUM_DETECTED_FACES_SW = "max-num-detected-faces-sw";
        private static final String KEY_MAX_NUM_FOCUS_AREAS = "max-num-focus-areas";
        private static final String KEY_MAX_NUM_METERING_AREAS = "max-num-metering-areas";
        private static final String KEY_MAX_ZOOM = "max-zoom";
        private static final String KEY_METERING_AREAS = "metering-areas";
        private static final String KEY_MIN_EXPOSURE_COMPENSATION = "min-exposure-compensation";
        private static final String KEY_PICTURE_FORMAT = "picture-format";
        private static final String KEY_PICTURE_SIZE = "picture-size";
        private static final String KEY_PREFERRED_PREVIEW_SIZE_FOR_VIDEO = "preferred-preview-size-for-video";
        private static final String KEY_PREVIEW_FORMAT = "preview-format";
        private static final String KEY_PREVIEW_FPS_RANGE = "preview-fps-range";
        private static final String KEY_PREVIEW_FRAME_RATE = "preview-frame-rate";
        private static final String KEY_PREVIEW_SIZE = "preview-size";
        private static final String KEY_RECORDING_HINT = "recording-hint";
        private static final String KEY_ROTATION = "rotation";
        private static final String KEY_SCENE_MODE = "scene-mode";
        private static final String KEY_SMOOTH_ZOOM_SUPPORTED = "smooth-zoom-supported";
        private static final String KEY_VERTICAL_VIEW_ANGLE = "vertical-view-angle";
        private static final String KEY_VIDEO_SIZE = "video-size";
        private static final String KEY_VIDEO_SNAPSHOT_SUPPORTED = "video-snapshot-supported";
        private static final String KEY_VIDEO_STABILIZATION = "video-stabilization";
        private static final String KEY_VIDEO_STABILIZATION_SUPPORTED = "video-stabilization-supported";
        private static final String KEY_WHITE_BALANCE = "whitebalance";
        private static final String KEY_ZOOM = "zoom";
        private static final String KEY_ZOOM_RATIOS = "zoom-ratios";
        private static final String KEY_ZOOM_SUPPORTED = "zoom-supported";
        private static final String PIXEL_FORMAT_BAYER_RGGB = "bayer-rggb";
        private static final String PIXEL_FORMAT_JPEG = "jpeg";
        private static final String PIXEL_FORMAT_RGB565 = "rgb565";
        private static final String PIXEL_FORMAT_YUV420P = "yuv420p";
        private static final String PIXEL_FORMAT_YUV420SP = "yuv420sp";
        private static final String PIXEL_FORMAT_YUV422I = "yuv422i-yuyv";
        private static final String PIXEL_FORMAT_YUV422SP = "yuv422sp";
        public static final int PREVIEW_FPS_MAX_INDEX = 1;
        public static final int PREVIEW_FPS_MIN_INDEX = 0;
        public static final String SCENE_MODE_ACTION = "action";
        public static final String SCENE_MODE_AUTO = "auto";
        public static final String SCENE_MODE_BARCODE = "barcode";
        public static final String SCENE_MODE_BEACH = "beach";
        public static final String SCENE_MODE_CANDLELIGHT = "candlelight";
        public static final String SCENE_MODE_FIREWORKS = "fireworks";
        public static final String SCENE_MODE_LANDSCAPE = "landscape";
        public static final String SCENE_MODE_NIGHT = "night";
        public static final String SCENE_MODE_NIGHT_PORTRAIT = "night-portrait";
        public static final String SCENE_MODE_PARTY = "party";
        public static final String SCENE_MODE_PORTRAIT = "portrait";
        public static final String SCENE_MODE_SNOW = "snow";
        public static final String SCENE_MODE_SPORTS = "sports";
        public static final String SCENE_MODE_STEADYPHOTO = "steadyphoto";
        public static final String SCENE_MODE_SUNSET = "sunset";
        public static final String SCENE_MODE_THEATRE = "theatre";
        private static final String SUPPORTED_VALUES_SUFFIX = "-values";
        private static final String TRUE = "true";
        public static final String WHITE_BALANCE_AUTO = "auto";
        public static final String WHITE_BALANCE_CLOUDY_DAYLIGHT = "cloudy-daylight";
        public static final String WHITE_BALANCE_DAYLIGHT = "daylight";
        public static final String WHITE_BALANCE_FLUORESCENT = "fluorescent";
        public static final String WHITE_BALANCE_INCANDESCENT = "incandescent";
        public static final String WHITE_BALANCE_SHADE = "shade";
        public static final String WHITE_BALANCE_TWILIGHT = "twilight";
        public static final String WHITE_BALANCE_WARM_FLUORESCENT = "warm-fluorescent";
        private HashMap mMap;
        final Camera this$0;

        private Parameters() {
            this$0 = Camera.this;
            super();
            mMap = new HashMap();
        }

    }

    public static class Area {

        public boolean equals(Object obj) {
            boolean flag = false;
            if(obj instanceof Area) goto _L2; else goto _L1
_L1:
            return flag;
_L2:
            Area area = (Area)obj;
            if((rect != null ? rect.equals(area.rect) : area.rect == null) && weight == area.weight)
                flag = true;
            if(true) goto _L1; else goto _L3
_L3:
        }

        public Rect rect;
        public int weight;

        public Area(Rect rect1, int i) {
            rect = rect1;
            weight = i;
        }
    }

    public class Size {

        public boolean equals(Object obj) {
            boolean flag = false;
            if(obj instanceof Size) goto _L2; else goto _L1
_L1:
            return flag;
_L2:
            Size size = (Size)obj;
            if(width == size.width && height == size.height)
                flag = true;
            if(true) goto _L1; else goto _L3
_L3:
        }

        public int hashCode() {
            return 32713 * width + height;
        }

        public int height;
        final Camera this$0;
        public int width;

        public Size(int i, int j) {
            this$0 = Camera.this;
            super();
            width = i;
            height = j;
        }
    }

    public static interface ErrorCallback {

        public abstract void onError(int i, Camera camera);
    }

    public static class Face {

        public int id;
        public Point leftEye;
        public Point mouth;
        public Rect rect;
        public Point rightEye;
        public int score;

        public Face() {
            id = -1;
            leftEye = null;
            rightEye = null;
            mouth = null;
        }
    }

    public static interface FaceDetectionListener {

        public abstract void onFaceDetection(Face aface[], Camera camera);
    }

    public static interface OnZoomChangeListener {

        public abstract void onZoomChange(int i, boolean flag, Camera camera);
    }

    public static interface PictureCallback {

        public abstract void onPictureTaken(byte abyte0[], Camera camera);
    }

    public static interface ShutterCallback {

        public abstract void onShutter();
    }

    public static interface AutoFocusMoveCallback {

        public abstract void onAutoFocusMoving(boolean flag, Camera camera);
    }

    public static interface AutoFocusCallback {

        public abstract void onAutoFocus(boolean flag, Camera camera);
    }

    private class EventHandler extends Handler {

        public void handleMessage(Message message) {
            boolean flag;
            boolean flag1;
            flag = true;
            flag1 = false;
            message.what;
            JVM INSTR lookupswitch 10: default 100
        //                       1: 507
        //                       2: 129
        //                       4: 350
        //                       8: 414
        //                       16: 232
        //                       64: 311
        //                       128: 154
        //                       256: 193
        //                       1024: 468
        //                       2048: 568;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
            Log.e("Camera", (new StringBuilder()).append("Unknown message type ").append(message.what).toString());
_L13:
            return;
_L3:
            if(mShutterCallback != null)
                mShutterCallback.onShutter();
            continue; /* Loop/switch isn't completed */
_L8:
            if(mRawImageCallback != null)
                mRawImageCallback.onPictureTaken((byte[])(byte[])message.obj, mCamera);
            continue; /* Loop/switch isn't completed */
_L9:
            if(mJpegCallback != null)
                mJpegCallback.onPictureTaken((byte[])(byte[])message.obj, mCamera);
            continue; /* Loop/switch isn't completed */
_L6:
            PreviewCallback previewcallback = mPreviewCallback;
            if(previewcallback == null)
                continue; /* Loop/switch isn't completed */
            if(mOneShot)
                mPreviewCallback = null;
            else
            if(!mWithBuffer)
                setHasPreviewCallback(flag, false);
            previewcallback.onPreviewFrame((byte[])(byte[])message.obj, mCamera);
            continue; /* Loop/switch isn't completed */
_L7:
            if(mPostviewCallback != null)
                mPostviewCallback.onPictureTaken((byte[])(byte[])message.obj, mCamera);
            continue; /* Loop/switch isn't completed */
_L4:
            AutoFocusCallback autofocuscallback;
            synchronized(mAutoFocusCallbackLock) {
                autofocuscallback = mAutoFocusCallback;
            }
            if(autofocuscallback != null) {
                if(message.arg1 != 0)
                    flag1 = flag;
                autofocuscallback.onAutoFocus(flag1, mCamera);
            }
            continue; /* Loop/switch isn't completed */
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
_L5:
            if(mZoomListener != null) {
                OnZoomChangeListener onzoomchangelistener = mZoomListener;
                int i = message.arg1;
                if(message.arg2 == 0)
                    flag = false;
                onzoomchangelistener.onZoomChange(i, flag, mCamera);
            }
            continue; /* Loop/switch isn't completed */
_L10:
            if(mFaceListener != null)
                mFaceListener.onFaceDetection((Face[])(Face[])message.obj, mCamera);
            continue; /* Loop/switch isn't completed */
_L2:
            Log.e("Camera", (new StringBuilder()).append("Error ").append(message.arg1).toString());
            if(mErrorCallback != null)
                mErrorCallback.onError(message.arg1, mCamera);
            continue; /* Loop/switch isn't completed */
_L11:
            if(mAutoFocusMoveCallback != null) {
                AutoFocusMoveCallback autofocusmovecallback = mAutoFocusMoveCallback;
                if(message.arg1 != 0)
                    flag1 = flag;
                autofocusmovecallback.onAutoFocusMoving(flag1, mCamera);
            }
            if(true) goto _L13; else goto _L12
_L12:
        }

        private Camera mCamera;
        final Camera this$0;

        public EventHandler(Camera camera1, Looper looper) {
            this$0 = Camera.this;
            super(looper);
            mCamera = camera1;
        }
    }

    public static interface PreviewCallback {

        public abstract void onPreviewFrame(byte abyte0[], Camera camera);
    }

    public static class CameraInfo {

        public static final int CAMERA_FACING_BACK = 0;
        public static final int CAMERA_FACING_FRONT = 1;
        public int facing;
        public int orientation;

        public CameraInfo() {
        }
    }


    Camera() {
        mFaceDetectionRunning = false;
        mAutoFocusCallbackLock = new Object();
    }

    Camera(int i) {
        mFaceDetectionRunning = false;
        mAutoFocusCallbackLock = new Object();
        mShutterCallback = null;
        mRawImageCallback = null;
        mJpegCallback = null;
        mPreviewCallback = null;
        mPostviewCallback = null;
        mZoomListener = null;
        Looper looper = Looper.myLooper();
        if(looper != null) {
            mEventHandler = new EventHandler(this, looper);
        } else {
            Looper looper1 = Looper.getMainLooper();
            if(looper1 != null)
                mEventHandler = new EventHandler(this, looper1);
            else
                mEventHandler = null;
        }
        native_setup(new WeakReference(this), i);
    }

    private final native void _addCallbackBuffer(byte abyte0[], int i);

    private final native void _startFaceDetection(int i);

    private final native void _stopFaceDetection();

    private final native void _stopPreview();

    private final void addCallbackBuffer(byte abyte0[], int i) {
        if(i != 16 && i != 128) {
            throw new IllegalArgumentException((new StringBuilder()).append("Unsupported message type: ").append(i).toString());
        } else {
            _addCallbackBuffer(abyte0, i);
            return;
        }
    }

    private native void enableFocusMoveCallback(int i);

    public static native void getCameraInfo(int i, CameraInfo camerainfo);

    public static Parameters getEmptyParameters() {
        Camera camera = new Camera();
        camera.getClass();
        return camera. new Parameters();
    }

    public static native int getNumberOfCameras();

    private final native void native_autoFocus();

    private final native void native_cancelAutoFocus();

    private final native String native_getParameters();

    private final native void native_release();

    private final native void native_setParameters(String s);

    private final native void native_setup(Object obj, int i);

    private final native void native_takePicture(int i);

    public static Camera open() {
        int i;
        CameraInfo camerainfo;
        int j;
        i = getNumberOfCameras();
        camerainfo = new CameraInfo();
        j = 0;
_L3:
        if(j >= i)
            break MISSING_BLOCK_LABEL_48;
        getCameraInfo(j, camerainfo);
        if(camerainfo.facing != 0) goto _L2; else goto _L1
_L1:
        Camera camera = new Camera(j);
_L4:
        return camera;
_L2:
        j++;
          goto _L3
        camera = null;
          goto _L4
    }

    public static Camera open(int i) {
        return new Camera(i);
    }

    private static void postEventFromNative(Object obj, int i, int j, int k, Object obj1) {
        Camera camera;
        camera = (Camera)((WeakReference)obj).get();
        break MISSING_BLOCK_LABEL_12;
        if(camera != null && camera.mEventHandler != null) {
            Message message = camera.mEventHandler.obtainMessage(i, j, k, obj1);
            camera.mEventHandler.sendMessage(message);
        }
        return;
    }

    private final native void setHasPreviewCallback(boolean flag, boolean flag1);

    private final native void setPreviewDisplay(Surface surface) throws IOException;

    public final void addCallbackBuffer(byte abyte0[]) {
        _addCallbackBuffer(abyte0, 16);
    }

    public final void addRawImageCallbackBuffer(byte abyte0[]) {
        addCallbackBuffer(abyte0, 128);
    }

    public final void autoFocus(AutoFocusCallback autofocuscallback) {
        synchronized(mAutoFocusCallbackLock) {
            mAutoFocusCallback = autofocuscallback;
        }
        native_autoFocus();
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void cancelAutoFocus() {
        synchronized(mAutoFocusCallbackLock) {
            mAutoFocusCallback = null;
        }
        native_cancelAutoFocus();
        mEventHandler.removeMessages(4);
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void finalize() {
        release();
    }

    public Parameters getParameters() {
        Parameters parameters = new Parameters();
        parameters.unflatten(native_getParameters());
        return parameters;
    }

    public final native void lock();

    public final native boolean previewEnabled();

    public final native void reconnect() throws IOException;

    public final void release() {
        native_release();
        mFaceDetectionRunning = false;
    }

    public void setAutoFocusMoveCallback(AutoFocusMoveCallback autofocusmovecallback) {
        mAutoFocusMoveCallback = autofocusmovecallback;
        int i;
        if(mAutoFocusMoveCallback != null)
            i = 1;
        else
            i = 0;
        enableFocusMoveCallback(i);
    }

    public final native void setDisplayOrientation(int i);

    public final void setErrorCallback(ErrorCallback errorcallback) {
        mErrorCallback = errorcallback;
    }

    public final void setFaceDetectionListener(FaceDetectionListener facedetectionlistener) {
        mFaceListener = facedetectionlistener;
    }

    public final void setOneShotPreviewCallback(PreviewCallback previewcallback) {
        boolean flag = true;
        mPreviewCallback = previewcallback;
        mOneShot = flag;
        mWithBuffer = false;
        if(previewcallback == null)
            flag = false;
        setHasPreviewCallback(flag, false);
    }

    public void setParameters(Parameters parameters) {
        native_setParameters(parameters.flatten());
    }

    public final void setPreviewCallback(PreviewCallback previewcallback) {
        mPreviewCallback = previewcallback;
        mOneShot = false;
        mWithBuffer = false;
        boolean flag;
        if(previewcallback != null)
            flag = true;
        else
            flag = false;
        setHasPreviewCallback(flag, false);
    }

    public final void setPreviewCallbackWithBuffer(PreviewCallback previewcallback) {
        boolean flag = false;
        mPreviewCallback = previewcallback;
        mOneShot = false;
        mWithBuffer = true;
        if(previewcallback != null)
            flag = true;
        setHasPreviewCallback(flag, true);
    }

    public final void setPreviewDisplay(SurfaceHolder surfaceholder) throws IOException {
        if(surfaceholder != null)
            setPreviewDisplay(surfaceholder.getSurface());
        else
            setPreviewDisplay((Surface)null);
    }

    public final native void setPreviewTexture(SurfaceTexture surfacetexture) throws IOException;

    public final void setZoomChangeListener(OnZoomChangeListener onzoomchangelistener) {
        mZoomListener = onzoomchangelistener;
    }

    public final void startFaceDetection() {
        if(mFaceDetectionRunning) {
            throw new RuntimeException("Face detection is already running");
        } else {
            _startFaceDetection(0);
            mFaceDetectionRunning = true;
            return;
        }
    }

    public final native void startPreview();

    public final native void startSmoothZoom(int i);

    public final void stopFaceDetection() {
        _stopFaceDetection();
        mFaceDetectionRunning = false;
    }

    public final void stopPreview() {
        _stopPreview();
        mFaceDetectionRunning = false;
        mShutterCallback = null;
        mRawImageCallback = null;
        mPostviewCallback = null;
        mJpegCallback = null;
        synchronized(mAutoFocusCallbackLock) {
            mAutoFocusCallback = null;
        }
        mAutoFocusMoveCallback = null;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final native void stopSmoothZoom();

    public final void takePicture(ShutterCallback shuttercallback, PictureCallback picturecallback, PictureCallback picturecallback1) {
        takePicture(shuttercallback, picturecallback, null, picturecallback1);
    }

    public final void takePicture(ShutterCallback shuttercallback, PictureCallback picturecallback, PictureCallback picturecallback1, PictureCallback picturecallback2) {
        mShutterCallback = shuttercallback;
        mRawImageCallback = picturecallback;
        mPostviewCallback = picturecallback1;
        mJpegCallback = picturecallback2;
        int i = 0;
        if(mShutterCallback != null)
            i = 0 | 2;
        if(mRawImageCallback != null)
            i |= 0x80;
        if(mPostviewCallback != null)
            i |= 0x40;
        if(mJpegCallback != null)
            i |= 0x100;
        native_takePicture(i);
        mFaceDetectionRunning = false;
    }

    public final native void unlock();

    public static final String ACTION_NEW_PICTURE = "android.hardware.action.NEW_PICTURE";
    public static final String ACTION_NEW_VIDEO = "android.hardware.action.NEW_VIDEO";
    public static final int CAMERA_ERROR_SERVER_DIED = 100;
    public static final int CAMERA_ERROR_UNKNOWN = 1;
    private static final int CAMERA_FACE_DETECTION_HW = 0;
    private static final int CAMERA_FACE_DETECTION_SW = 1;
    private static final int CAMERA_MSG_COMPRESSED_IMAGE = 256;
    private static final int CAMERA_MSG_ERROR = 1;
    private static final int CAMERA_MSG_FOCUS = 4;
    private static final int CAMERA_MSG_FOCUS_MOVE = 2048;
    private static final int CAMERA_MSG_POSTVIEW_FRAME = 64;
    private static final int CAMERA_MSG_PREVIEW_FRAME = 16;
    private static final int CAMERA_MSG_PREVIEW_METADATA = 1024;
    private static final int CAMERA_MSG_RAW_IMAGE = 128;
    private static final int CAMERA_MSG_RAW_IMAGE_NOTIFY = 512;
    private static final int CAMERA_MSG_SHUTTER = 2;
    private static final int CAMERA_MSG_VIDEO_FRAME = 32;
    private static final int CAMERA_MSG_ZOOM = 8;
    private static final String TAG = "Camera";
    private AutoFocusCallback mAutoFocusCallback;
    private Object mAutoFocusCallbackLock;
    private AutoFocusMoveCallback mAutoFocusMoveCallback;
    private ErrorCallback mErrorCallback;
    private EventHandler mEventHandler;
    private boolean mFaceDetectionRunning;
    private FaceDetectionListener mFaceListener;
    private PictureCallback mJpegCallback;
    private int mNativeContext;
    private boolean mOneShot;
    private PictureCallback mPostviewCallback;
    private PreviewCallback mPreviewCallback;
    private PictureCallback mRawImageCallback;
    private ShutterCallback mShutterCallback;
    private boolean mWithBuffer;
    private OnZoomChangeListener mZoomListener;










/*
    static PreviewCallback access$302(Camera camera, PreviewCallback previewcallback) {
        camera.mPreviewCallback = previewcallback;
        return previewcallback;
    }

*/






}
