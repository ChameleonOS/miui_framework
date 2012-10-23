// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import miui.os.Build;

public class ExtraSettings {
    public static class Secure {

        public static Cursor checkPrivacyAndReturnCursor(Context context) {
            boolean flag;
            MatrixCursor matrixcursor;
            if(1 == android.provider.Settings.Secure.getInt(context.getContentResolver(), "privacy_mode_enabled", 0))
                flag = true;
            else
                flag = false;
            if(flag) {
                String as[] = new String[1];
                as[0] = "_id";
                matrixcursor = new MatrixCursor(as);
            } else {
                matrixcursor = null;
            }
            return matrixcursor;
        }

        public static long getStorageThreshold(ContentResolver contentresolver) {
            if(sStorageThreshold == 0L) {
                int i = android.provider.Settings.Secure.getInt(contentresolver, "sys_storage_threshold_percentage", 10);
                StatFs statfs = new StatFs(Environment.getDataDirectory().getPath());
                sStorageThreshold = ((long)statfs.getBlockCount() * (long)statfs.getBlockSize() * (long)i) / 100L;
            }
            return sStorageThreshold;
        }

        public static boolean isForceCloseDialogEnabled(Context context) {
            boolean flag;
            boolean flag1;
            flag = false;
            flag1 = true;
            int i = android.provider.Settings.Secure.getInt(context.getContentResolver(), FORCE_CLOCE_DIALOG_ENABLED);
            if(flag1 != i)
                flag1 = false;
_L2:
            return flag1;
            android.provider.Settings.SettingNotFoundException settingnotfoundexception;
            settingnotfoundexception;
            if(!"user".equals(Build.TYPE) || Build.isDevelopmentVersion())
                flag = flag1;
            flag1 = flag;
            if(true) goto _L2; else goto _L1
_L1:
        }

        public static boolean showMagnifierWhenInput(Context context) {
            boolean flag = true;
            if(!Build.SHOW_MAGNIFIER_WHEN_INPUT && !context.getResources().getBoolean(0x6090010) || flag != android.provider.Settings.Secure.getInt(context.getContentResolver(), SHOW_MAGNIFIER_WHEN_INPUT, DEFAULT_SHOW_MAGNIFIER_WHEN_INPUT))
                flag = false;
            return flag;
        }

        public static final String ACCESS_CONTROL_LOCK_ENABLED = "access_control_lock_enabled";
        public static String APP_ENCRYPT_PASSWORD = "app_encrypt_password";
        public static final String DATA_USAGE_ADJUSTING_TIME = "data_usage_adjusting_time";
        public static final String DATA_USAGE_ADJUSTMENT = "data_usage_adjustment";
        public static final String DATA_USAGE_LIMIT_BYTES = "data_usage_limit_bytes";
        public static final int DEFAULT_FIND_DEVICE_PIN_LOCK = 0;
        public static final String DEFAULT_INPUT_METHOD_CHOOSED = "default_input_method_choosed";
        public static final int DEFAULT_PERMANENTLY_LOCK_SIM_CHANGE = 0;
        public static int DEFAULT_SHOW_MAGNIFIER_WHEN_INPUT = 0;
        public static final int DEFAULT_VPN_ENABLE_PASSWORD = 0;
        public static String FIND_DEVICE_PIN_LOCK = "find_device_pin_lock";
        public static String FORCE_CLOCE_DIALOG_ENABLED = "force_close_dialog_enabled";
        public static String MOBILE_DOWNLOAD_FILE_SIZE_PROMPT_POPUP_ENABLED = "mobile_download_file_size_prompt_popup_enabled";
        public static final String MOBILE_POLICY = "mobile_policy";
        public static final String PASSWORD_FOR_PRIVACYMODE = "password_for_privacymode";
        public static String PERMANENTLY_LOCK_SIM_CHANGE = "permanently_lock_sim_change";
        public static final String PRIVACY_MODE_ENABLED = "privacy_mode_enabled";
        public static String REGISTER_FIND_DEVICE_SIM_NUMBER = "resister_find_device_sim_number";
        public static final String SCREEN_BUTTONS_HAS_BEEN_DISABLED = "screen_buttons_has_been_disabled";
        public static final String SCREEN_BUTTONS_STATE = "screen_buttons_state";
        public static final String SCREEN_BUTTONS_TURN_ON = "screen_buttons_turn_on";
        public static String SHOW_MAGNIFIER_WHEN_INPUT = "show_magnifier_when_input";
        public static final String STATUS_BAR_EXPANDED_NOTIFICATION_BLACK_LIST = "status_bar_expanded_notification_black_list";
        public static final String UPLOAD_LOG = "upload_log_pref";
        public static final String USB_MODE = "usb_mode";
        public static final int USB_MODE_ASK_USER = 0;
        public static final int USB_MODE_CHARGE_ONLY = 1;
        public static final int USB_MODE_MOUNT_STORAGE = 2;
        public static final String VPN_ENABLE_PASSWORD = "vpn_password_enable";
        private static long sStorageThreshold = 0L;

        static  {
            DEFAULT_SHOW_MAGNIFIER_WHEN_INPUT = 1;
        }

        public Secure() {
        }
    }

    public static final class System {

        public static boolean getBoolean(ContentResolver contentresolver, String s, boolean flag) {
            boolean flag1 = true;
            int i;
            if(flag)
                i = ((flag1) ? 1 : 0);
            else
                i = 0;
            if(android.provider.Settings.System.getInt(contentresolver, s, i) == 0)
                flag1 = false;
            return flag1;
        }

        private static int getDefaultPref(String s) {
            while("vibrate_mms".equals(s) || "vibrate_ringer".equals(s) || "vibrate_notification".equals(s)) 
                return 1;
            throw new IllegalArgumentException((new StringBuilder()).append("non-support default value for ").append(s).toString());
        }

        public static ArrayList getScreenKeyOrder(Context context) {
            ArrayList arraylist;
            String s;
            arraylist = new ArrayList();
            s = android.provider.Settings.System.getString(context.getContentResolver(), "screen_key_order");
            if(TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
            String as[];
            int i;
            as = s.split(" ");
            i = 0;
_L3:
            if(i >= as.length)
                break; /* Loop/switch isn't completed */
            int j = Integer.valueOf(as[i]).intValue();
            if(screenKeys.contains(Integer.valueOf(j)))
                arraylist.add(Integer.valueOf(j));
            i++;
            if(true) goto _L3; else goto _L2
            Exception exception;
            exception;
            arraylist.clear();
_L2:
            if(arraylist.size() == 0) {
                for(Iterator iterator = screenKeys.iterator(); iterator.hasNext(); arraylist.add((Integer)iterator.next()));
            }
            return arraylist;
        }

        /**
         * @deprecated Method getString is deprecated
         */

        public static String getString(ContentResolver contentresolver, String s, String s1) {
            miui/provider/ExtraSettings$System;
            JVM INSTR monitorenter ;
            String s2 = android.provider.Settings.System.getString(contentresolver, s);
            String s3;
            s3 = s2;
            if(s3 == null)
                s3 = s1;
            miui/provider/ExtraSettings$System;
            JVM INSTR monitorexit ;
            return s3;
            Exception exception;
            exception;
            throw exception;
        }

        public static boolean isVibratePrefOn(Context context, String s) {
            boolean flag = true;
            if(android.provider.Settings.System.getInt(context.getContentResolver(), s, getDefaultPref(s)) != flag)
                flag = false;
            return flag;
        }

        public static void putBoolean(ContentResolver contentresolver, String s, boolean flag) {
            int i;
            if(flag)
                i = 1;
            else
                i = 0;
            android.provider.Settings.System.putInt(contentresolver, s, i);
        }

        public static final String ADD_ZERO_PREFIX_SWITCH = "button_add_zero_prefix";
        public static final int ADD_ZERO_PREFIX_SWITCH_DEFAULT = 0;
        public static final String ALWAYS_ENABLE_MMS = "always_enable_mms";
        public static final String ANTI_PRIVATE_CALL_ENABLED = "anti_private_call";
        public static final String ANTI_STRANGER_CALL_ENABLED = "anti_stranger_call";
        public static final String AUTOIP_PREFIX = "autoip_prefix";
        public static final String AUTOIP_SWITCH = "button_autoip";
        public static final int AUTOIP_SWITCH_DEFAULT = 0;
        public static final String AUTO_COUNTRY_CODE = "auto_country_code";
        public static final int AUTO_COUNTRY_CODE_DEFAULT = 0;
        public static final String AUTO_IP_SUPPORT_LOCAL_NUMBERS = "button_auto_ip_support_local_numbers";
        public static final int AUTO_IP_SUPPORT_LOCAL_NUMBERS_DEFAULT = 0;
        public static final String BACK_KEY_LONG_PRESS_TIMEOUT = "back_key_long_press_timeout";
        public static final int BACK_KEY_LONG_PRESS_TIMEOUT_DEFAULT = 1500;
        public static final String BATTERY_INDICATOR_STYLE = "battery_indicator_style";
        public static final int BATTERY_INDICATOR_STYLE_GRAPHIC = 0;
        public static final int BATTERY_INDICATOR_STYLE_NUMBER = 1;
        public static final int BATTERY_INDICATOR_STYLE_TOP = 2;
        public static final String BATTERY_LEVEL_LOW_CUSTOMIZED = "battery_level_low_customized";
        public static final String BLACKLIST_ENABLED = "blacklist_enabled";
        public static final String BREATHING_LIGHT_COLOR = "breathing_light_color";
        public static final String BREATHING_LIGHT_FREQ = "breathing_light_freq";
        public static final String CALL_BREATHING_LIGHT_COLOR = "call_breathing_light_color";
        public static final int CALL_BREATHING_LIGHT_COLOR_DEFAULT = 0;
        public static final String CALL_BREATHING_LIGHT_FREQ = "call_breathing_light_freq";
        public static final int CALL_BREATHING_LIGHT_FREQ_DEFAULT = 0;
        public static final String CALL_LOG_LIMIT_NUMBER = "call_log_limit_number";
        public static final int CALL_LOG_NUMBER_HAS_LIMIT = 1;
        public static final String CALL_LOG_NUMBER_LIMIT = "call_log_number_limit";
        public static final int CALL_LOG_NUMBER_LIMIT_OPTION_DEFAULT = 0;
        public static final int CALL_LOG_NUMBER_NO_LIMIT = 0;
        public static final String CAMERA_KEY_PREFERRED_ACTION_APP_COMPONENT = "camera_key_preferred_action_app_component";
        public static final String CAMERA_KEY_PREFERRED_ACTION_SHORTCUT_ID = "camera_key_preferred_action_shortcut_id";
        public static final int CAMERA_KEY_PREFERRED_ACTION_SHORTCUT_ID_CALL = 3;
        public static final int CAMERA_KEY_PREFERRED_ACTION_SHORTCUT_ID_HOME = 0;
        public static final int CAMERA_KEY_PREFERRED_ACTION_SHORTCUT_ID_SCREENSHOT = 1;
        public static final int CAMERA_KEY_PREFERRED_ACTION_SHORTCUT_ID_SEARCH = 2;
        public static final int CAMERA_KEY_PREFERRED_ACTION_SHORTCUT_ID_WAKE = 4;
        public static final String CAMERA_KEY_PREFERRED_ACTION_TOGGLE_ID = "camera_key_preferred_action_toggle_id";
        public static final String CAMERA_KEY_PREFERRED_ACTION_TYPE = "camera_key_preferred_action_type";
        public static final int CAMERA_KEY_PREFERRED_ACTION_TYPE_APP = 3;
        public static final int CAMERA_KEY_PREFERRED_ACTION_TYPE_DEFAULT = 0;
        public static final int CAMERA_KEY_PREFERRED_ACTION_TYPE_NONE = 0;
        public static final int CAMERA_KEY_PREFERRED_ACTION_TYPE_SHORTCUT = 1;
        public static final int CAMERA_KEY_PREFERRED_ACTION_TYPE_TOGGLE = 2;
        public static final String CHECK_UPDATE_ONLY_WIFI_AVAILABLE = "check_update_only_wifi_available";
        public static final int CHECK_UPDATE_ONLY_WIFI_AVAILABLE_DEFAULT = 1;
        public static final String CONFIRM_MIUI_DISCLAIMER = "confirm_miui_disclaimer";
        public static final String CONTACT_COUNTRYCODE = "persist.radio.countrycode";
        public static final String CURRENT_AREACODE = "current_areacode";
        public static final int DEFAULT_CALL_LOG_LIMIT_NUMBER = 500;
        public static final int DEFAULT_SCREEN_BUTTONS_TIMEOUT = 5000;
        public static final Uri DEFAULT_SMS_DELIVERED_RINGTONE_URI = android.provider.Settings.System.getUriFor("sms_delivered_sound");
        public static final Uri DEFAULT_SMS_RECEIVED_RINGTONE_URI = android.provider.Settings.System.getUriFor("sms_received_sound");
        public static final String DIALER_AUTO_DIALPAD = "dialer_auto_dialpad";
        public static final int DIALER_AUTO_DIALPAD_DEFAULT = 1;
        public static final String DIALER_CLICK = "dialer_click_setting";
        public static final int DIALER_CLICK_DEFAULT = 0;
        public static final int DIALER_CLICK_DIAL = 0;
        public static final int DIALER_CLICK_VIEW_CONTACT = 1;
        public static final String DIALER_SHOW_CALL_LOG_NUMBER = "dialer_show_call_log_number";
        public static final String DIAL_PAD_TOUCH_TONE = "dial_pad_touch_tone";
        public static final int DIAL_PAD_TOUCH_TONE_DEFAULT = -1;
        public static final int DIAL_PAD_TOUCH_TONE_HUMAN = 1;
        public static final int DIAL_PAD_TOUCH_TONE_PIANO = 0;
        public static final String DOWNLOAD_ONLY_ON_WIFI = "download_only_on_wifi";
        public static final String ELECTRON_BEAM_ANIMATION_OFF = "electron_beam_animation_off";
        public static final String ELECTRON_BEAM_ANIMATION_ON = "electron_beam_animation_on";
        public static final String ENABLE_ASSIST_MENU_LONG_PRESS = "enable_assist_menu_key_long_press";
        public static final int ENABLE_ASSIST_MENU_LONG_PRESS_DEFAULT = 1;
        public static final String ENABLE_SCREEN_ON_PROXIMITY_SENSOR = "enable_screen_on_proximity_sensor";
        public static final boolean ENABLE_SCREEN_ON_PROXIMITY_SENSOR_DEFAULT = false;
        public static final String ENABLE_SNAPSHOT_SCREENLOCK = "enable_snapshot_screenlock";
        public static final int ENABLE_SNAPSHOT_SCREENLOCK_DEFAULT = 0;
        public static final String ENABLE_TELOCATION = "enable_telocation";
        public static final int ENABLE_TELOCATION_DEFAULT = 1;
        public static final String FAKE_MOBILE_OPERATOR_FOR_VENDING = "fake_mobile_operator_for_vending";
        public static final String FILTER_STRANGER_SMS_ENABLED = "filter_stranger_sms";
        public static final String FIREWALL_CALL_ACT = "firewall_call_act";
        public static final int FIREWALL_CALL_ACT_HANGUP = 0;
        public static final int FIREWALL_CALL_ACT_MUTE = 1;
        public static final String FIREWALL_ENABLED = "firewall_enabled";
        public static final String FIREWALL_END_TIME = "firewall_end_time";
        public static final String FIREWALL_HIDE_CALLLOG = "firewall_hide_calllog";
        public static final String FIREWALL_SMS_ACT = "firewall_sms_act";
        public static final int FIREWALL_SMS_ACT_DELETE = 2;
        public static final int FIREWALL_SMS_ACT_IGNORE = 0;
        public static final int FIREWALL_SMS_ACT_MUTE = 1;
        public static final String FIREWALL_START_TIME = "firewall_start_time";
        public static final String FIREWALL_TIME_LIMIT_ENABLED = "firewall_time_limit_enabled";
        public static final String HAPTIC_FEEDBACK_LEVEL = "haptic_feedback_level";
        public static final int HAPTIC_FEEDBACK_LEVEL_DEFAULT = 1;
        public static final int HAPTIC_FEEDBACK_LEVEL_MAX = 2;
        public static final int HAPTIC_FEEDBACK_LEVEL_MIN = 0;
        public static final String INCOMING_CALL_LIMIT = "incoming_call_limit_setting";
        public static final int INCOMING_CALL_LIMIT_ADDRESSBOOK_CONTACT_ONLY = 1;
        public static final int INCOMING_CALL_LIMIT_BLOCK_ALL = 3;
        public static final int INCOMING_CALL_LIMIT_NO_LIMIT = 0;
        public static final int INCOMING_CALL_LIMIT_STARRED_CONTACT_ONLY = 2;
        public static final String KEEP_CONTACTS_IN_MEMORY = "keep_contacts_in_memory";
        public static final int KEEP_CONTACTS_IN_MEMORY_DEFAULT = 0;
        public static final String KEEP_LAUNCHER_IN_MEMORY = "keep_launcher_in_memory";
        public static final int KEEP_LAUNCHER_IN_MEMORY_DEFAULT = 1;
        public static final String KEEP_MMS_IN_MEMORY = "keep_mms_in_memory";
        public static final int KEEP_MMS_IN_MEMORY_DEFAULT = 1;
        public static final String KEYGUARD_DISABLE_POWER_KEY_LONG_PRESS = "keyguard_disable_power_key_long_press";
        public static final int KEYGUARD_DISABLE_POWER_KEY_LONG_PRESS_DEFAULT = 0;
        public static final String LAST_AUDIBLE_RING_VOLUME = "last_audible_ring_volume";
        public static final int LAST_MINUTE_OF_DAY = 1439;
        public static final String MAX_DOWNLOADS = "max_downloads";
        public static final String MAX_DOWNLOADS_PER_DOMAIN = "max_downloads_per_domain";
        public static final int MIUI_DISCLAIMER_ACCEPT = 1;
        public static final int MIUI_DISCLAIMER_REFUSE = 0;
        public static final String MMS_BREATHING_LIGHT_COLOR = "mms_breathing_light_color";
        public static final String MMS_BREATHING_LIGHT_FREQ = "mms_breathing_light_freq";
        public static final String MMS_SYNC_WILD_MSG_STATE = "mms_sync_wild_msg_state";
        public static final int MMS_SYNC_WILD_MSG_STATE_DONE = 3;
        public static final int MMS_SYNC_WILD_MSG_STATE_DOWNLOAD_PENDING = 2;
        public static final int MMS_SYNC_WILD_MSG_STATE_INIT = 0;
        public static final int MMS_SYNC_WILD_MSG_STATE_MSG_FOUND = 1;
        public static final String MMS_SYNC_WILD_NUMBERS = "mms_sync_wild_numbers";
        public static final String MMS_UPLOAD_OLD_MSG_ACCOUNTS = "mms_upload_old_msg_accounts";
        public static final String MMS_UPLOAD_OLD_MSG_STATE = "mms_upload_old_msg_state";
        public static final int MMS_UPLOAD_OLD_MSG_STATE_INIT = 0;
        public static final int MMS_UPLOAD_OLD_MSG_STATE_NEED_PROMPT = 1;
        public static final String MX_USED = "mx_used";
        public static final String RECENT_APPS_KEY_SHOW = "recent_apps_key_show";
        public static final String SCREENSHOT_NOTIFICATION_ENABLED = "screenshot_notification_enabled";
        public static final String SCREEN_BUTTONS_TIMEOUT = "screen_buttons_timeout";
        public static final int SCREEN_KEY_BACK = 3;
        public static final int SCREEN_KEY_COUNT = 4;
        public static final int SCREEN_KEY_HOME = 1;
        public static final int SCREEN_KEY_MENU = 0;
        public static final String SCREEN_KEY_ORDER = "screen_key_order";
        public static final int SCREEN_KEY_RECENT_APPS = 2;
        public static final String SHOW_LOCK_BEFORE_UNLOCK = "show_lock_before_unlock";
        public static final String SHOW_ROUNDED_CORNERS = "show_rounded_corners";
        public static final String SMS_DELIVERED_SOUND = "sms_delivered_sound";
        public static final String SMS_NOTIFICATION_BODY_ENABLED = "pref_key_enable_notification_body";
        public static final String SMS_NOTIFICATION_ENABLED = "pref_key_enable_notification";
        public static final String SMS_RECEIVED_SOUND = "sms_received_sound";
        public static final String SMS_WAKE_UP_SCREEN_ENABLED = "pref_key_enable_wake_up_screen";
        public static final String STATUS_BAR_EXPANDABLE_UNDER_FULLSCREEN = "status_bar_expandable_under_fullscreen";
        public static final String STATUS_BAR_EXPANDABLE_UNDER_KEYGUARD = "status_bar_expandable_under_keyguard";
        public static final String STATUS_BAR_NOTIFICATION_FILTER_BLACK_LIST = "status_bar_notification_filter_black_list";
        public static final String STATUS_BAR_NOTIFICATION_FILTER_ENABLED = "status_bar_notification_filter_enabled";
        public static final int STATUS_BAR_NOTIFICATION_FILTER_ENABLED_DEFAULT = 1;
        public static final String STATUS_BAR_NOTIFICATION_FILTER_MODE = "status_bar_notification_filter_mode";
        public static final int STATUS_BAR_NOTIFICATION_FILTER_MODE_BLACK_LIST = 0;
        public static final int STATUS_BAR_NOTIFICATION_FILTER_MODE_DEFAULT = 1;
        public static final int STATUS_BAR_NOTIFICATION_FILTER_MODE_WHITE_LIST = 1;
        public static final String STATUS_BAR_NOTIFICATION_FILTER_WHITE_LIST = "status_bar_notification_filter_white_list";
        public static final String STATUS_BAR_SHOW_NETWORK_ASSISTANT = "status_bar_show_network_assistant";
        public static final int STATUS_BAR_SHOW_NETWORK_ASSISTANT_DEFAULT = 0;
        public static final String STATUS_BAR_SHOW_NETWORK_SPEED = "status_bar_show_network_speed";
        public static final int STATUS_BAR_SHOW_NETWORK_SPEED_DEFAULT = 0;
        public static final String STATUS_BAR_STYLE = "status_bar_style";
        public static final int STATUS_BAR_STYLE_DEFAULT = 1;
        public static final int STATUS_BAR_STYLE_LIST = 0;
        public static final int STATUS_BAR_STYLE_PAGE = 1;
        public static final String STATUS_BAR_TOGGLE_LIST = "status_bar_toggle_list";
        public static final String STATUS_BAR_TOGGLE_PAGE = "status_bar_toggle_page";
        public static final String STATUS_BAR_UPDATE_NETWORK_SPEED_INTERVAL = "status_bar_network_speed_interval";
        public static final int STATUS_BAR_UPDATE_NETWORK_SPEED_INTERVAL_DEFAULT = 4000;
        public static final String T9_INDEXING_KEY = "t9_indexing_key";
        public static final int T9_INDEXING_KEY_DEFAULT = 0;
        public static final int T9_INDEXING_KEY_PINYIN = 0;
        public static final int T9_INDEXING_KEY_ZHUYIN = 1;
        public static final String TORCH_STATE = "torch_state";
        public static final String TRACKBALL_WAKE_SCREEN = "trackball_wake_screen";
        public static final String UI_MODE_SCALE = "ui_mode_scale";
        public static final String UPDATE_STABLE_VERSION_ONLY = "update_stable_version_only";
        public static final int UPDATE_STABLE_VERSION_ONLY_DEFAULT = 1;
        public static final String USER_APPS_KEPT_IN_MEMORY = "user_apps_kept_in_memory";
        public static final String USER_APPS_KEPT_IN_MEMORY_DEFAULT = "";
        public static final String USER_GUIDE_LOCK_SCREEN_UNLOCK = "user_guide_lock_screen_unlock";
        public static final String USER_GUIDE_STATUS_BAR_CALL = "user_guide_status_bar_call";
        public static final String USER_GUIDE_STATUS_BAR_NOTIFICATION = "user_guide_status_bar_notification";
        public static final String USER_GUIDE_STATUS_BAR_TOGGLE = "user_guide_status_bar_toggle";
        public static final String USER_GUIDE_STATUS_BAR_TOGGLE_LIST = "user_guide_status_bar_toggle_list";
        public static final String VIBRATE_IN_NORMAL = "vibrate_in_normal";
        public static final int VIBRATE_IN_NORMAL_DEFAULT = 0;
        public static final String VIBRATE_MMS_PREF = "vibrate_mms";
        public static final int VIBRATE_MMS_PREF_DEFAULT = 1;
        public static final String VIBRATE_NOTIFICATION_PREF = "vibrate_notification";
        public static final int VIBRATE_NOTIFICATION_PREF_DEFAULT = 1;
        public static final String VIBRATE_RINGER_PREF = "vibrate_ringer";
        public static final int VIBRATE_RINGER_PREF_DEFAULT = 1;
        public static final String VOLUMEKEY_WAKE_SCREEN = "volumekey_wake_screen";
        public static final String WHITELIST_ENABLED = "whitelist_enabled";
        public static final String XIAOMI_ACCOUNT_MITALK_ENABLE_PROPERTY = "persist.sys.mitalk.enable";
        public static final boolean XIAOMI_ACCOUNT_MITALK_ENABLE_PROPERTY_DEFAULT = true;
        public static ArrayList screenKeys;

        static  {
            int i = 1;
            CALL_BREATHING_LIGHT_COLOR_DEFAULT = Resources.getSystem().getColor(0x6070009);
            CALL_BREATHING_LIGHT_FREQ_DEFAULT = Resources.getSystem().getInteger(0x608000a);
            screenKeys = new ArrayList();
            screenKeys.add(Integer.valueOf(0));
            screenKeys.add(Integer.valueOf(i));
            screenKeys.add(Integer.valueOf(2));
            screenKeys.add(Integer.valueOf(3));
            if(!Build.IS_TW_BUILD)
                i = 0;
            T9_INDEXING_KEY_DEFAULT = i;
        }

        public System() {
        }
    }


    public ExtraSettings() {
    }
}
