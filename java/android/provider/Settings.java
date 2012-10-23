// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.provider;

import android.content.*;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.*;
import android.text.TextUtils;
import android.util.AndroidException;
import android.util.Log;
import com.android.internal.widget.ILockSettings;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;

// Referenced classes of package android.provider:
//            BaseColumns

public final class Settings {
    public static final class Bookmarks
        implements BaseColumns {

        public static Uri add(ContentResolver contentresolver, Intent intent, String s, String s1, char c, int i) {
            if(c != 0) {
                Uri uri = CONTENT_URI;
                String as[] = new String[1];
                as[0] = String.valueOf(c);
                contentresolver.delete(uri, "shortcut=?", as);
            }
            ContentValues contentvalues = new ContentValues();
            if(s != null)
                contentvalues.put("title", s);
            if(s1 != null)
                contentvalues.put("folder", s1);
            contentvalues.put("intent", intent.toUri(0));
            if(c != 0)
                contentvalues.put("shortcut", Integer.valueOf(c));
            contentvalues.put("ordering", Integer.valueOf(i));
            return contentresolver.insert(CONTENT_URI, contentvalues);
        }

        public static Intent getIntentForShortcut(ContentResolver contentresolver, char c) {
            Intent intent;
            Cursor cursor;
            intent = null;
            Uri uri = CONTENT_URI;
            String as[] = sIntentProjection;
            String as1[] = new String[1];
            as1[0] = String.valueOf(c);
            cursor = contentresolver.query(uri, as, "shortcut=?", as1, "ordering");
_L2:
            if(intent != null)
                break MISSING_BLOCK_LABEL_118;
            boolean flag = cursor.moveToNext();
            if(!flag)
                break MISSING_BLOCK_LABEL_118;
            Intent intent1 = Intent.parseUri(cursor.getString(cursor.getColumnIndexOrThrow("intent")), 0);
            intent = intent1;
            continue; /* Loop/switch isn't completed */
            IllegalArgumentException illegalargumentexception;
            illegalargumentexception;
            Log.w("Bookmarks", "Intent column not found", illegalargumentexception);
            continue; /* Loop/switch isn't completed */
            Exception exception;
            exception;
            if(cursor != null)
                cursor.close();
            throw exception;
            if(cursor != null)
                cursor.close();
            return intent;
            URISyntaxException urisyntaxexception;
            urisyntaxexception;
            if(true) goto _L2; else goto _L1
_L1:
        }

        public static CharSequence getLabelForFolder(Resources resources, String s) {
            return s;
        }

        public static CharSequence getTitle(Context context, Cursor cursor) {
            int j;
            Object obj;
            int i = cursor.getColumnIndex("title");
            j = cursor.getColumnIndex("intent");
            if(i == -1 || j == -1)
                throw new IllegalArgumentException("The cursor must contain the TITLE and INTENT columns.");
            obj = cursor.getString(i);
            if(TextUtils.isEmpty(((CharSequence) (obj)))) goto _L2; else goto _L1
_L1:
            return ((CharSequence) (obj));
_L2:
            String s;
            s = cursor.getString(j);
            if(TextUtils.isEmpty(s)) {
                obj = "";
                continue; /* Loop/switch isn't completed */
            }
            Intent intent = Intent.parseUri(s, 0);
            PackageManager packagemanager = context.getPackageManager();
            ResolveInfo resolveinfo = packagemanager.resolveActivity(intent, 0);
            URISyntaxException urisyntaxexception;
            Object obj1;
            if(resolveinfo != null)
                obj1 = resolveinfo.loadLabel(packagemanager);
            else
                obj1 = "";
            obj = obj1;
            continue; /* Loop/switch isn't completed */
            urisyntaxexception;
            obj = "";
            if(true) goto _L1; else goto _L3
_L3:
        }

        public static final Uri CONTENT_URI = Uri.parse("content://settings/bookmarks");
        public static final String FOLDER = "folder";
        public static final String ID = "_id";
        public static final String INTENT = "intent";
        public static final String ORDERING = "ordering";
        public static final String SHORTCUT = "shortcut";
        private static final String TAG = "Bookmarks";
        public static final String TITLE = "title";
        private static final String sIntentProjection[];
        private static final String sShortcutProjection[];
        private static final String sShortcutSelection = "shortcut=?";

        static  {
            String as[] = new String[1];
            as[0] = "intent";
            sIntentProjection = as;
            String as1[] = new String[2];
            as1[0] = "_id";
            as1[1] = "shortcut";
            sShortcutProjection = as1;
        }

        public Bookmarks() {
        }
    }

    public static final class Secure extends NameValueTable {

        public static final String getBluetoothA2dpSinkPriorityKey(String s) {
            return (new StringBuilder()).append("bluetooth_a2dp_sink_priority_").append(s.toUpperCase()).toString();
        }

        public static final String getBluetoothHeadsetPriorityKey(String s) {
            return (new StringBuilder()).append("bluetooth_headset_priority_").append(s.toUpperCase()).toString();
        }

        public static final String getBluetoothInputDevicePriorityKey(String s) {
            return (new StringBuilder()).append("bluetooth_input_device_priority_").append(s.toUpperCase()).toString();
        }

        public static float getFloat(ContentResolver contentresolver, String s) throws SettingNotFoundException {
            String s1 = getString(contentresolver, s);
            if(s1 == null)
                throw new SettingNotFoundException(s);
            float f;
            try {
                f = Float.parseFloat(s1);
            }
            catch(NumberFormatException numberformatexception) {
                throw new SettingNotFoundException(s);
            }
            return f;
        }

        public static float getFloat(ContentResolver contentresolver, String s, float f) {
            String s1;
            s1 = getString(contentresolver, s);
            if(s1 == null)
                break MISSING_BLOCK_LABEL_19;
            float f1 = Float.parseFloat(s1);
            f = f1;
_L2:
            return f;
            NumberFormatException numberformatexception;
            numberformatexception;
            if(true) goto _L2; else goto _L1
_L1:
        }

        public static int getInt(ContentResolver contentresolver, String s) throws SettingNotFoundException {
            String s1 = getString(contentresolver, s);
            int i;
            try {
                i = Integer.parseInt(s1);
            }
            catch(NumberFormatException numberformatexception) {
                throw new SettingNotFoundException(s);
            }
            return i;
        }

        public static int getInt(ContentResolver contentresolver, String s, int i) {
            String s1;
            s1 = getString(contentresolver, s);
            if(s1 == null)
                break MISSING_BLOCK_LABEL_19;
            int j = Integer.parseInt(s1);
            i = j;
_L2:
            return i;
            NumberFormatException numberformatexception;
            numberformatexception;
            if(true) goto _L2; else goto _L1
_L1:
        }

        public static long getLong(ContentResolver contentresolver, String s) throws SettingNotFoundException {
            String s1 = getString(contentresolver, s);
            long l;
            try {
                l = Long.parseLong(s1);
            }
            catch(NumberFormatException numberformatexception) {
                throw new SettingNotFoundException(s);
            }
            return l;
        }

        public static long getLong(ContentResolver contentresolver, String s, long l) {
            String s1 = getString(contentresolver, s);
            if(s1 == null) goto _L2; else goto _L1
_L1:
            long l2 = Long.parseLong(s1);
            long l1 = l2;
_L4:
            return l1;
_L2:
            l1 = l;
            continue; /* Loop/switch isn't completed */
            NumberFormatException numberformatexception;
            numberformatexception;
            l1 = l;
            if(true) goto _L4; else goto _L3
_L3:
        }

        /**
         * @deprecated Method getString is deprecated
         */

        public static String getString(ContentResolver contentresolver, String s) {
            android/provider/Settings$Secure;
            JVM INSTR monitorenter ;
            if(sNameValueCache == null)
                sNameValueCache = new NameValueCache("sys.settings_secure_version", CONTENT_URI, "GET_secure");
            if(sLockSettings != null) goto _L2; else goto _L1
_L1:
            sLockSettings = com.android.internal.widget.ILockSettings.Stub.asInterface(ServiceManager.getService("lock_settings"));
            if(Process.myUid() != 1000) goto _L4; else goto _L3
_L3:
            boolean flag1 = true;
_L8:
            sIsSystemProcess = flag1;
_L2:
            if(sLockSettings == null || sIsSystemProcess) goto _L6; else goto _L5
_L5:
            boolean flag = MOVED_TO_LOCK_SETTINGS.contains(s);
            if(!flag) goto _L6; else goto _L7
_L7:
            String s3 = sLockSettings.getString(s, "0", UserId.getCallingUserId());
            String s2 = s3;
_L9:
            android/provider/Settings$Secure;
            JVM INSTR monitorexit ;
            return s2;
_L4:
            flag1 = false;
              goto _L8
            RemoteException remoteexception;
            remoteexception;
_L6:
            String s1 = sNameValueCache.getString(contentresolver, s);
            s2 = s1;
              goto _L9
            Exception exception;
            exception;
            throw exception;
              goto _L8
        }

        public static Uri getUriFor(String s) {
            return getUriFor(CONTENT_URI, s);
        }

        public static final boolean isLocationProviderEnabled(ContentResolver contentresolver, String s) {
            return TextUtils.delimitedStringContains(getString(contentresolver, "location_providers_allowed"), ',', s);
        }

        public static boolean putFloat(ContentResolver contentresolver, String s, float f) {
            return putString(contentresolver, s, Float.toString(f));
        }

        public static boolean putInt(ContentResolver contentresolver, String s, int i) {
            return putString(contentresolver, s, Integer.toString(i));
        }

        public static boolean putLong(ContentResolver contentresolver, String s, long l) {
            return putString(contentresolver, s, Long.toString(l));
        }

        public static boolean putString(ContentResolver contentresolver, String s, String s1) {
            return putString(contentresolver, CONTENT_URI, s, s1);
        }

        public static final void setLocationProviderEnabled(ContentResolver contentresolver, String s, boolean flag) {
            String s1;
            if(flag)
                s1 = (new StringBuilder()).append("+").append(s).toString();
            else
                s1 = (new StringBuilder()).append("-").append(s).toString();
            putString(contentresolver, "location_providers_allowed", s1);
        }

        public static final String ACCESSIBILITY_ENABLED = "accessibility_enabled";
        public static final String ACCESSIBILITY_SCREEN_READER_URL = "accessibility_script_injection_url";
        public static final String ACCESSIBILITY_SCRIPT_INJECTION = "accessibility_script_injection";
        public static final String ACCESSIBILITY_SPEAK_PASSWORD = "speak_password";
        public static final String ACCESSIBILITY_WEB_CONTENT_KEY_BINDINGS = "accessibility_web_content_key_bindings";
        public static final String ADB_ENABLED = "adb_enabled";
        public static final String ALLOWED_GEOLOCATION_ORIGINS = "allowed_geolocation_origins";
        public static final String ALLOW_MOCK_LOCATION = "mock_location";
        public static final String ANDROID_ID = "android_id";
        public static final String ANR_SHOW_BACKGROUND = "anr_show_background";
        public static final String ASSISTED_GPS_ENABLED = "assisted_gps_enabled";
        public static final String BACKGROUND_DATA = "background_data";
        public static final String BACKUP_AUTO_RESTORE = "backup_auto_restore";
        public static final String BACKUP_ENABLED = "backup_enabled";
        public static final String BACKUP_PROVISIONED = "backup_provisioned";
        public static final String BACKUP_TRANSPORT = "backup_transport";
        public static final String BATTERY_DISCHARGE_DURATION_THRESHOLD = "battery_discharge_duration_threshold";
        public static final String BATTERY_DISCHARGE_THRESHOLD = "battery_discharge_threshold";
        public static final String BLUETOOTH_ON = "bluetooth_on";
        public static final String CDMA_CELL_BROADCAST_SMS = "cdma_cell_broadcast_sms";
        public static final String CDMA_ROAMING_MODE = "roaming_settings";
        public static final String CDMA_SUBSCRIPTION_MODE = "subscription_mode";
        public static final String CONNECTIVITY_CHANGE_DELAY = "connectivity_change_delay";
        public static final int CONNECTIVITY_CHANGE_DELAY_DEFAULT = 3000;
        public static final String CONTACTS_PREAUTH_URI_EXPIRATION = "contacts_preauth_uri_expiration";
        public static final Uri CONTENT_URI = Uri.parse("content://settings/secure");
        public static final String DATA_ROAMING = "data_roaming";
        public static final String DATA_STALL_ALARM_AGGRESSIVE_DELAY_IN_MS = "data_stall_alarm_aggressive_delay_in_ms";
        public static final String DATA_STALL_ALARM_NON_AGGRESSIVE_DELAY_IN_MS = "data_stall_alarm_non_aggressive_delay_in_ms";
        public static final String DEFAULT_DNS_SERVER = "default_dns_server";
        public static final String DEFAULT_INPUT_METHOD = "default_input_method";
        public static final String DEFAULT_INSTALL_LOCATION = "default_install_location";
        public static final String DEVELOPMENT_SETTINGS_ENABLED = "development_settings_enabled";
        public static final String DEVICE_PROVISIONED = "device_provisioned";
        public static final String DISABLED_SYSTEM_INPUT_METHODS = "disabled_system_input_methods";
        public static final String DISK_FREE_CHANGE_REPORTING_THRESHOLD = "disk_free_change_reporting_threshold";
        public static final String DISPLAY_SIZE_FORCED = "display_size_forced";
        public static final String DOWNLOAD_MAX_BYTES_OVER_MOBILE = "download_manager_max_bytes_over_mobile";
        public static final String DOWNLOAD_RECOMMENDED_MAX_BYTES_OVER_MOBILE = "download_manager_recommended_max_bytes_over_mobile";
        public static final String DROPBOX_AGE_SECONDS = "dropbox_age_seconds";
        public static final String DROPBOX_MAX_FILES = "dropbox_max_files";
        public static final String DROPBOX_QUOTA_KB = "dropbox_quota_kb";
        public static final String DROPBOX_QUOTA_PERCENT = "dropbox_quota_percent";
        public static final String DROPBOX_RESERVE_PERCENT = "dropbox_reserve_percent";
        public static final String DROPBOX_TAG_PREFIX = "dropbox:";
        public static final String ENABLED_ACCESSIBILITY_SERVICES = "enabled_accessibility_services";
        public static final String ENABLED_INPUT_METHODS = "enabled_input_methods";
        public static final String ENHANCED_VOICE_PRIVACY_ENABLED = "enhanced_voice_privacy_enabled";
        public static final String ERROR_LOGCAT_PREFIX = "logcat_for_";
        public static final String GLOBAL_HTTP_PROXY_EXCLUSION_LIST = "global_http_proxy_exclusion_list";
        public static final String GLOBAL_HTTP_PROXY_HOST = "global_http_proxy_host";
        public static final String GLOBAL_HTTP_PROXY_PORT = "global_http_proxy_port";
        public static final String GPRS_REGISTER_CHECK_PERIOD_MS = "gprs_register_check_period_ms";
        public static final String HTTP_PROXY = "http_proxy";
        public static final String INCALL_POWER_BUTTON_BEHAVIOR = "incall_power_button_behavior";
        public static final int INCALL_POWER_BUTTON_BEHAVIOR_DEFAULT = 1;
        public static final int INCALL_POWER_BUTTON_BEHAVIOR_HANGUP = 2;
        public static final int INCALL_POWER_BUTTON_BEHAVIOR_SCREEN_OFF = 1;
        public static final String INET_CONDITION_DEBOUNCE_DOWN_DELAY = "inet_condition_debounce_down_delay";
        public static final String INET_CONDITION_DEBOUNCE_UP_DELAY = "inet_condition_debounce_up_delay";
        public static final String INPUT_METHODS_SUBTYPE_HISTORY = "input_methods_subtype_history";
        public static final String INPUT_METHOD_SELECTOR_VISIBILITY = "input_method_selector_visibility";
        public static final String INSTALL_NON_MARKET_APPS = "install_non_market_apps";
        public static final String LAST_SETUP_SHOWN = "last_setup_shown";
        public static final String LOCATION_PROVIDERS_ALLOWED = "location_providers_allowed";
        public static final String LOCK_BIOMETRIC_WEAK_FLAGS = "lock_biometric_weak_flags";
        public static final String LOCK_PATTERN_ENABLED = "lock_pattern_autolock";
        public static final String LOCK_PATTERN_TACTILE_FEEDBACK_ENABLED = "lock_pattern_tactile_feedback_enabled";
        public static final String LOCK_PATTERN_VISIBLE = "lock_pattern_visible_pattern";
        public static final String LOCK_SCREEN_LOCK_AFTER_TIMEOUT = "lock_screen_lock_after_timeout";
        public static final String LOCK_SCREEN_OWNER_INFO = "lock_screen_owner_info";
        public static final String LOCK_SCREEN_OWNER_INFO_ENABLED = "lock_screen_owner_info_enabled";
        public static final String LOGGING_ID = "logging_id";
        public static final String LONG_PRESS_TIMEOUT = "long_press_timeout";
        public static final String MEMCHECK_EXEC_END_TIME = "memcheck_exec_end_time";
        public static final String MEMCHECK_EXEC_START_TIME = "memcheck_exec_start_time";
        public static final String MEMCHECK_INTERVAL = "memcheck_interval";
        public static final String MEMCHECK_LOG_REALTIME_INTERVAL = "memcheck_log_realtime_interval";
        public static final String MEMCHECK_MIN_ALARM = "memcheck_min_alarm";
        public static final String MEMCHECK_MIN_SCREEN_OFF = "memcheck_min_screen_off";
        public static final String MEMCHECK_PHONE_ENABLED = "memcheck_phone_enabled";
        public static final String MEMCHECK_PHONE_HARD_THRESHOLD = "memcheck_phone_hard";
        public static final String MEMCHECK_PHONE_SOFT_THRESHOLD = "memcheck_phone_soft";
        public static final String MEMCHECK_RECHECK_INTERVAL = "memcheck_recheck_interval";
        public static final String MEMCHECK_SYSTEM_ENABLED = "memcheck_system_enabled";
        public static final String MEMCHECK_SYSTEM_HARD_THRESHOLD = "memcheck_system_hard";
        public static final String MEMCHECK_SYSTEM_SOFT_THRESHOLD = "memcheck_system_soft";
        public static final String MOBILE_DATA = "mobile_data";
        public static final String MOUNT_PLAY_NOTIFICATION_SND = "mount_play_not_snd";
        public static final String MOUNT_UMS_AUTOSTART = "mount_ums_autostart";
        public static final String MOUNT_UMS_NOTIFY_ENABLED = "mount_ums_notify_enabled";
        public static final String MOUNT_UMS_PROMPT = "mount_ums_prompt";
        private static final HashSet MOVED_TO_LOCK_SETTINGS;
        public static final String NETSTATS_DEV_BUCKET_DURATION = "netstats_dev_bucket_duration";
        public static final String NETSTATS_DEV_DELETE_AGE = "netstats_dev_delete_age";
        public static final String NETSTATS_DEV_PERSIST_BYTES = "netstats_dev_persist_bytes";
        public static final String NETSTATS_DEV_ROTATE_AGE = "netstats_dev_rotate_age";
        public static final String NETSTATS_ENABLED = "netstats_enabled";
        public static final String NETSTATS_GLOBAL_ALERT_BYTES = "netstats_global_alert_bytes";
        public static final String NETSTATS_POLL_INTERVAL = "netstats_poll_interval";
        public static final String NETSTATS_REPORT_XT_OVER_DEV = "netstats_report_xt_over_dev";
        public static final String NETSTATS_SAMPLE_ENABLED = "netstats_sample_enabled";
        public static final String NETSTATS_TIME_CACHE_MAX_AGE = "netstats_time_cache_max_age";
        public static final String NETSTATS_UID_BUCKET_DURATION = "netstats_uid_bucket_duration";
        public static final String NETSTATS_UID_DELETE_AGE = "netstats_uid_delete_age";
        public static final String NETSTATS_UID_PERSIST_BYTES = "netstats_uid_persist_bytes";
        public static final String NETSTATS_UID_ROTATE_AGE = "netstats_uid_rotate_age";
        public static final String NETSTATS_UID_TAG_BUCKET_DURATION = "netstats_uid_tag_bucket_duration";
        public static final String NETSTATS_UID_TAG_DELETE_AGE = "netstats_uid_tag_delete_age";
        public static final String NETSTATS_UID_TAG_PERSIST_BYTES = "netstats_uid_tag_persist_bytes";
        public static final String NETSTATS_UID_TAG_ROTATE_AGE = "netstats_uid_tag_rotate_age";
        public static final String NETWORK_PREFERENCE = "network_preference";
        public static final String NITZ_UPDATE_DIFF = "nitz_update_diff";
        public static final String NITZ_UPDATE_SPACING = "nitz_update_spacing";
        public static final String NSD_ON = "nsd_on";
        public static final String NTP_SERVER = "ntp_server";
        public static final String NTP_TIMEOUT = "ntp_timeout";
        public static final String PACKAGE_VERIFIER_ENABLE = "verifier_enable";
        public static final String PACKAGE_VERIFIER_TIMEOUT = "verifier_timeout";
        public static final String PARENTAL_CONTROL_ENABLED = "parental_control_enabled";
        public static final String PARENTAL_CONTROL_LAST_UPDATE = "parental_control_last_update";
        public static final String PARENTAL_CONTROL_REDIRECT_URL = "parental_control_redirect_url";
        public static final String PDP_WATCHDOG_ERROR_POLL_COUNT = "pdp_watchdog_error_poll_count";
        public static final String PDP_WATCHDOG_ERROR_POLL_INTERVAL_MS = "pdp_watchdog_error_poll_interval_ms";
        public static final String PDP_WATCHDOG_LONG_POLL_INTERVAL_MS = "pdp_watchdog_long_poll_interval_ms";
        public static final String PDP_WATCHDOG_MAX_PDP_RESET_FAIL_COUNT = "pdp_watchdog_max_pdp_reset_fail_count";
        public static final String PDP_WATCHDOG_POLL_INTERVAL_MS = "pdp_watchdog_poll_interval_ms";
        public static final String PDP_WATCHDOG_TRIGGER_PACKET_COUNT = "pdp_watchdog_trigger_packet_count";
        public static final String PREFERRED_CDMA_SUBSCRIPTION = "preferred_cdma_subscription";
        public static final String PREFERRED_NETWORK_MODE = "preferred_network_mode";
        public static final String PREFERRED_TTY_MODE = "preferred_tty_mode";
        public static final String READ_EXTERNAL_STORAGE_ENFORCED_DEFAULT = "read_external_storage_enforced_default";
        public static final String REBOOT_INTERVAL = "reboot_interval";
        public static final String REBOOT_START_TIME = "reboot_start_time";
        public static final String REBOOT_WINDOW = "reboot_window";
        public static final String SAMPLING_PROFILER_MS = "sampling_profiler_ms";
        public static final String SCREENSAVER_ACTIVATE_ON_DOCK = "screensaver_activate_on_dock";
        public static final String SCREENSAVER_COMPONENT = "screensaver_component";
        public static final String SCREENSAVER_ENABLED = "screensaver_enabled";
        public static final String SEARCH_GLOBAL_SEARCH_ACTIVITY = "search_global_search_activity";
        public static final String SEARCH_MAX_RESULTS_PER_SOURCE = "search_max_results_per_source";
        public static final String SEARCH_MAX_RESULTS_TO_DISPLAY = "search_max_results_to_display";
        public static final String SEARCH_MAX_SHORTCUTS_RETURNED = "search_max_shortcuts_returned";
        public static final String SEARCH_MAX_SOURCE_EVENT_AGE_MILLIS = "search_max_source_event_age_millis";
        public static final String SEARCH_MAX_STAT_AGE_MILLIS = "search_max_stat_age_millis";
        public static final String SEARCH_MIN_CLICKS_FOR_SOURCE_RANKING = "search_min_clicks_for_source_ranking";
        public static final String SEARCH_MIN_IMPRESSIONS_FOR_SOURCE_RANKING = "search_min_impressions_for_source_ranking";
        public static final String SEARCH_NUM_PROMOTED_SOURCES = "search_num_promoted_sources";
        public static final String SEARCH_PER_SOURCE_CONCURRENT_QUERY_LIMIT = "search_per_source_concurrent_query_limit";
        public static final String SEARCH_PREFILL_MILLIS = "search_prefill_millis";
        public static final String SEARCH_PROMOTED_SOURCE_DEADLINE_MILLIS = "search_promoted_source_deadline_millis";
        public static final String SEARCH_QUERY_THREAD_CORE_POOL_SIZE = "search_query_thread_core_pool_size";
        public static final String SEARCH_QUERY_THREAD_MAX_POOL_SIZE = "search_query_thread_max_pool_size";
        public static final String SEARCH_SHORTCUT_REFRESH_CORE_POOL_SIZE = "search_shortcut_refresh_core_pool_size";
        public static final String SEARCH_SHORTCUT_REFRESH_MAX_POOL_SIZE = "search_shortcut_refresh_max_pool_size";
        public static final String SEARCH_SOURCE_TIMEOUT_MILLIS = "search_source_timeout_millis";
        public static final String SEARCH_THREAD_KEEPALIVE_SECONDS = "search_thread_keepalive_seconds";
        public static final String SEARCH_WEB_RESULTS_OVERRIDE_LIMIT = "search_web_results_override_limit";
        public static final String SELECTED_INPUT_METHOD_SUBTYPE = "selected_input_method_subtype";
        public static final String SELECTED_SPELL_CHECKER = "selected_spell_checker";
        public static final String SELECTED_SPELL_CHECKER_SUBTYPE = "selected_spell_checker_subtype";
        public static final String SEND_ACTION_APP_ERROR = "send_action_app_error";
        public static final String SETTINGS_CLASSNAME = "settings_classname";
        public static final String SETTINGS_TO_BACKUP[];
        public static final String SETUP_PREPAID_DATA_SERVICE_URL = "setup_prepaid_data_service_url";
        public static final String SETUP_PREPAID_DETECTION_REDIR_HOST = "setup_prepaid_detection_redir_host";
        public static final String SETUP_PREPAID_DETECTION_TARGET_URL = "setup_prepaid_detection_target_url";
        public static final String SET_GLOBAL_HTTP_PROXY = "set_global_http_proxy";
        public static final String SET_INSTALL_LOCATION = "set_install_location";
        public static final String SHORT_KEYLIGHT_DELAY_MS = "short_keylight_delay_ms";
        public static final String SMS_OUTGOING_CHECK_INTERVAL_MS = "sms_outgoing_check_interval_ms";
        public static final String SMS_OUTGOING_CHECK_MAX_COUNT = "sms_outgoing_check_max_count";
        public static final String SMS_SHORT_CODES_PREFIX = "sms_short_codes_";
        public static final String SPELL_CHECKER_ENABLED = "spell_checker_enabled";
        public static final String SYNC_MAX_RETRY_DELAY_IN_SECONDS = "sync_max_retry_delay_in_seconds";
        public static final String SYS_FREE_STORAGE_LOG_INTERVAL = "sys_free_storage_log_interval";
        public static final String SYS_PROP_SETTING_VERSION = "sys.settings_secure_version";
        public static final String SYS_STORAGE_FULL_THRESHOLD_BYTES = "sys_storage_full_threshold_bytes";
        public static final String SYS_STORAGE_THRESHOLD_MAX_BYTES = "sys_storage_threshold_max_bytes";
        public static final String SYS_STORAGE_THRESHOLD_PERCENTAGE = "sys_storage_threshold_percentage";
        public static final String TETHER_DUN_APN = "tether_dun_apn";
        public static final String TETHER_DUN_REQUIRED = "tether_dun_required";
        public static final String TETHER_SUPPORTED = "tether_supported";
        public static final String THROTTLE_HELP_URI = "throttle_help_uri";
        public static final String THROTTLE_MAX_NTP_CACHE_AGE_SEC = "throttle_max_ntp_cache_age_sec";
        public static final String THROTTLE_NOTIFICATION_TYPE = "throttle_notification_type";
        public static final String THROTTLE_POLLING_SEC = "throttle_polling_sec";
        public static final String THROTTLE_RESET_DAY = "throttle_reset_day";
        public static final String THROTTLE_THRESHOLD_BYTES = "throttle_threshold_bytes";
        public static final String THROTTLE_VALUE_KBITSPS = "throttle_value_kbitsps";
        public static final String TOUCH_EXPLORATION_ENABLED = "touch_exploration_enabled";
        public static final String TOUCH_EXPLORATION_GRANTED_ACCESSIBILITY_SERVICES = "touch_exploration_granted_accessibility_services";
        public static final String TTS_DEFAULT_COUNTRY = "tts_default_country";
        public static final String TTS_DEFAULT_LANG = "tts_default_lang";
        public static final String TTS_DEFAULT_LOCALE = "tts_default_locale";
        public static final String TTS_DEFAULT_PITCH = "tts_default_pitch";
        public static final String TTS_DEFAULT_RATE = "tts_default_rate";
        public static final String TTS_DEFAULT_SYNTH = "tts_default_synth";
        public static final String TTS_DEFAULT_VARIANT = "tts_default_variant";
        public static final String TTS_ENABLED_PLUGINS = "tts_enabled_plugins";
        public static final String TTS_USE_DEFAULTS = "tts_use_defaults";
        public static final String TTY_MODE_ENABLED = "tty_mode_enabled";
        public static final String UI_NIGHT_MODE = "ui_night_mode";
        public static final String USB_MASS_STORAGE_ENABLED = "usb_mass_storage_enabled";
        public static final String USE_GOOGLE_MAIL = "use_google_mail";
        public static final String VOICE_RECOGNITION_SERVICE = "voice_recognition_service";
        public static final String WEB_AUTOFILL_QUERY_URL = "web_autofill_query_url";
        public static final String WIFI_AP_PASSWD = "wifi_ap_passwd";
        public static final String WIFI_AP_SECURITY = "wifi_ap_security";
        public static final String WIFI_AP_SSID = "wifi_ap_ssid";
        public static final String WIFI_COUNTRY_CODE = "wifi_country_code";
        public static final String WIFI_FRAMEWORK_SCAN_INTERVAL_MS = "wifi_framework_scan_interval_ms";
        public static final String WIFI_FREQUENCY_BAND = "wifi_frequency_band";
        public static final String WIFI_IDLE_MS = "wifi_idle_ms";
        public static final String WIFI_MAX_DHCP_RETRY_COUNT = "wifi_max_dhcp_retry_count";
        public static final String WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS = "wifi_mobile_data_transition_wakelock_timeout_ms";
        public static final String WIFI_NETWORKS_AVAILABLE_NOTIFICATION_ON = "wifi_networks_available_notification_on";
        public static final String WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY = "wifi_networks_available_repeat_delay";
        public static final String WIFI_NUM_OPEN_NETWORKS_KEPT = "wifi_num_open_networks_kept";
        public static final String WIFI_ON = "wifi_on";
        public static final String WIFI_P2P_DEVICE_NAME = "wifi_p2p_device_name";
        public static final String WIFI_SAVED_STATE = "wifi_saved_state";
        public static final String WIFI_SUPPLICANT_SCAN_INTERVAL_MS = "wifi_supplicant_scan_interval_ms";
        public static final String WIFI_WATCHDOG_ACCEPTABLE_PACKET_LOSS_PERCENTAGE = "wifi_watchdog_acceptable_packet_loss_percentage";
        public static final String WIFI_WATCHDOG_AP_COUNT = "wifi_watchdog_ap_count";
        public static final String WIFI_WATCHDOG_ARP_CHECK_INTERVAL_MS = "wifi_watchdog_arp_interval_ms";
        public static final String WIFI_WATCHDOG_ARP_PING_TIMEOUT_MS = "wifi_watchdog_arp_ping_timeout_ms";
        public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_DELAY_MS = "wifi_watchdog_background_check_delay_ms";
        public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_ENABLED = "wifi_watchdog_background_check_enabled";
        public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_TIMEOUT_MS = "wifi_watchdog_background_check_timeout_ms";
        public static final String WIFI_WATCHDOG_INITIAL_IGNORED_PING_COUNT = "wifi_watchdog_initial_ignored_ping_count";
        public static final String WIFI_WATCHDOG_MAX_AP_CHECKS = "wifi_watchdog_max_ap_checks";
        public static final String WIFI_WATCHDOG_MIN_ARP_RESPONSES = "wifi_watchdog_min_arp_responses";
        public static final String WIFI_WATCHDOG_NUM_ARP_PINGS = "wifi_watchdog_num_arp_pings";
        public static final String WIFI_WATCHDOG_ON = "wifi_watchdog_on";
        public static final String WIFI_WATCHDOG_PING_COUNT = "wifi_watchdog_ping_count";
        public static final String WIFI_WATCHDOG_PING_DELAY_MS = "wifi_watchdog_ping_delay_ms";
        public static final String WIFI_WATCHDOG_PING_TIMEOUT_MS = "wifi_watchdog_ping_timeout_ms";
        public static final String WIFI_WATCHDOG_POOR_NETWORK_TEST_ENABLED = "wifi_watchdog_poor_network_test_enabled";
        public static final String WIFI_WATCHDOG_RSSI_FETCH_INTERVAL_MS = "wifi_watchdog_rssi_fetch_interval_ms";
        public static final String WIFI_WATCHDOG_WALLED_GARDEN_INTERVAL_MS = "wifi_watchdog_walled_garden_interval_ms";
        public static final String WIFI_WATCHDOG_WALLED_GARDEN_TEST_ENABLED = "wifi_watchdog_walled_garden_test_enabled";
        public static final String WIFI_WATCHDOG_WALLED_GARDEN_URL = "wifi_watchdog_walled_garden_url";
        public static final String WIFI_WATCHDOG_WATCH_LIST = "wifi_watchdog_watch_list";
        public static final String WIMAX_NETWORKS_AVAILABLE_NOTIFICATION_ON = "wimax_networks_available_notification_on";
        public static final String WTF_IS_FATAL = "wtf_is_fatal";
        private static boolean sIsSystemProcess;
        private static ILockSettings sLockSettings = null;
        private static NameValueCache sNameValueCache = null;

        static  {
            MOVED_TO_LOCK_SETTINGS = new HashSet(3);
            MOVED_TO_LOCK_SETTINGS.add("lock_pattern_autolock");
            MOVED_TO_LOCK_SETTINGS.add("lock_pattern_visible_pattern");
            MOVED_TO_LOCK_SETTINGS.add("lock_pattern_tactile_feedback_enabled");
            String as[] = new String[30];
            as[0] = "adb_enabled";
            as[1] = "mock_location";
            as[2] = "parental_control_enabled";
            as[3] = "parental_control_redirect_url";
            as[4] = "usb_mass_storage_enabled";
            as[5] = "accessibility_script_injection";
            as[6] = "backup_auto_restore";
            as[7] = "enabled_accessibility_services";
            as[8] = "touch_exploration_granted_accessibility_services";
            as[9] = "touch_exploration_enabled";
            as[10] = "accessibility_enabled";
            as[11] = "speak_password";
            as[12] = "tts_use_defaults";
            as[13] = "tts_default_rate";
            as[14] = "tts_default_pitch";
            as[15] = "tts_default_synth";
            as[16] = "tts_default_lang";
            as[17] = "tts_default_country";
            as[18] = "tts_enabled_plugins";
            as[19] = "tts_default_locale";
            as[20] = "wifi_networks_available_notification_on";
            as[21] = "wifi_networks_available_repeat_delay";
            as[22] = "wifi_num_open_networks_kept";
            as[23] = "mount_play_not_snd";
            as[24] = "mount_ums_autostart";
            as[25] = "mount_ums_prompt";
            as[26] = "mount_ums_notify_enabled";
            as[27] = "ui_night_mode";
            as[28] = "lock_screen_owner_info";
            as[29] = "lock_screen_owner_info_enabled";
            SETTINGS_TO_BACKUP = as;
        }

        public Secure() {
        }
    }

    public static final class System extends NameValueTable {

        public static void clearConfiguration(Configuration configuration) {
            configuration.fontScale = 0.0F;
        }

        public static void getConfiguration(ContentResolver contentresolver, Configuration configuration) {
            configuration.fontScale = getFloat(contentresolver, "font_scale", configuration.fontScale);
            if(configuration.fontScale < 0.0F)
                configuration.fontScale = 1.0F;
        }

        public static float getFloat(ContentResolver contentresolver, String s) throws SettingNotFoundException {
            String s1 = getString(contentresolver, s);
            if(s1 == null)
                throw new SettingNotFoundException(s);
            float f;
            try {
                f = Float.parseFloat(s1);
            }
            catch(NumberFormatException numberformatexception) {
                throw new SettingNotFoundException(s);
            }
            return f;
        }

        public static float getFloat(ContentResolver contentresolver, String s, float f) {
            String s1;
            s1 = getString(contentresolver, s);
            if(s1 == null)
                break MISSING_BLOCK_LABEL_19;
            float f1 = Float.parseFloat(s1);
            f = f1;
_L2:
            return f;
            NumberFormatException numberformatexception;
            numberformatexception;
            if(true) goto _L2; else goto _L1
_L1:
        }

        public static int getInt(ContentResolver contentresolver, String s) throws SettingNotFoundException {
            String s1 = getString(contentresolver, s);
            int i;
            try {
                i = Integer.parseInt(s1);
            }
            catch(NumberFormatException numberformatexception) {
                throw new SettingNotFoundException(s);
            }
            return i;
        }

        public static int getInt(ContentResolver contentresolver, String s, int i) {
            String s1;
            s1 = getString(contentresolver, s);
            if(s1 == null)
                break MISSING_BLOCK_LABEL_19;
            int j = Integer.parseInt(s1);
            i = j;
_L2:
            return i;
            NumberFormatException numberformatexception;
            numberformatexception;
            if(true) goto _L2; else goto _L1
_L1:
        }

        public static long getLong(ContentResolver contentresolver, String s) throws SettingNotFoundException {
            String s1 = getString(contentresolver, s);
            long l;
            try {
                l = Long.parseLong(s1);
            }
            catch(NumberFormatException numberformatexception) {
                throw new SettingNotFoundException(s);
            }
            return l;
        }

        public static long getLong(ContentResolver contentresolver, String s, long l) {
            String s1 = getString(contentresolver, s);
            if(s1 == null) goto _L2; else goto _L1
_L1:
            long l2 = Long.parseLong(s1);
            long l1 = l2;
_L4:
            return l1;
_L2:
            l1 = l;
            continue; /* Loop/switch isn't completed */
            NumberFormatException numberformatexception;
            numberformatexception;
            l1 = l;
            if(true) goto _L4; else goto _L3
_L3:
        }

        public static boolean getShowGTalkServiceStatus(ContentResolver contentresolver) {
            boolean flag = false;
            if(getInt(contentresolver, "SHOW_GTALK_SERVICE_STATUS", 0) != 0)
                flag = true;
            return flag;
        }

        /**
         * @deprecated Method getString is deprecated
         */

        public static String getString(ContentResolver contentresolver, String s) {
            android/provider/Settings$System;
            JVM INSTR monitorenter ;
            if(!MOVED_TO_SECURE.contains(s)) goto _L2; else goto _L1
_L1:
            String s3;
            Log.w("Settings", (new StringBuilder()).append("Setting ").append(s).append(" has moved from android.provider.Settings.System").append(" to android.provider.Settings.Secure, returning read-only value.").toString());
            s3 = Secure.getString(contentresolver, s);
            String s2 = s3;
_L4:
            android/provider/Settings$System;
            JVM INSTR monitorexit ;
            return s2;
_L2:
            String s1;
            if(sNameValueCache == null)
                sNameValueCache = new NameValueCache("sys.settings_system_version", CONTENT_URI, "GET_system");
            s1 = sNameValueCache.getString(contentresolver, s);
            s2 = s1;
            if(true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        public static Uri getUriFor(String s) {
            Uri uri;
            if(MOVED_TO_SECURE.contains(s)) {
                Log.w("Settings", (new StringBuilder()).append("Setting ").append(s).append(" has moved from android.provider.Settings.System").append(" to android.provider.Settings.Secure, returning Secure URI.").toString());
                uri = Secure.getUriFor(Secure.CONTENT_URI, s);
            } else {
                uri = getUriFor(CONTENT_URI, s);
            }
            return uri;
        }

        public static boolean hasInterestingConfigurationChanges(int i) {
            boolean flag;
            if((0x40000000 & i) != 0)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public static boolean putConfiguration(ContentResolver contentresolver, Configuration configuration) {
            return putFloat(contentresolver, "font_scale", configuration.fontScale);
        }

        public static boolean putFloat(ContentResolver contentresolver, String s, float f) {
            return putString(contentresolver, s, Float.toString(f));
        }

        public static boolean putInt(ContentResolver contentresolver, String s, int i) {
            return putString(contentresolver, s, Integer.toString(i));
        }

        public static boolean putLong(ContentResolver contentresolver, String s, long l) {
            return putString(contentresolver, s, Long.toString(l));
        }

        public static boolean putString(ContentResolver contentresolver, String s, String s1) {
            boolean flag;
            if(MOVED_TO_SECURE.contains(s)) {
                Log.w("Settings", (new StringBuilder()).append("Setting ").append(s).append(" has moved from android.provider.Settings.System").append(" to android.provider.Settings.Secure, value is unchanged.").toString());
                flag = false;
            } else {
                flag = putString(contentresolver, CONTENT_URI, s, s1);
            }
            return flag;
        }

        public static void setShowGTalkServiceStatus(ContentResolver contentresolver, boolean flag) {
            int i;
            if(flag)
                i = 1;
            else
                i = 0;
            putInt(contentresolver, "SHOW_GTALK_SERVICE_STATUS", i);
        }

        public static final String ACCELEROMETER_ROTATION = "accelerometer_rotation";
        public static final String ADB_ENABLED = "adb_enabled";
        public static final String ADVANCED_SETTINGS = "advanced_settings";
        public static final int ADVANCED_SETTINGS_DEFAULT = 0;
        public static final String AIRPLANE_MODE_ON = "airplane_mode_on";
        public static final String AIRPLANE_MODE_RADIOS = "airplane_mode_radios";
        public static final String AIRPLANE_MODE_TOGGLEABLE_RADIOS = "airplane_mode_toggleable_radios";
        public static final String ALARM_ALERT = "alarm_alert";
        public static final String ALWAYS_FINISH_ACTIVITIES = "always_finish_activities";
        public static final String ANDROID_ID = "android_id";
        public static final String ANIMATOR_DURATION_SCALE = "animator_duration_scale";
        public static final String APPEND_FOR_LAST_AUDIBLE = "_last_audible";
        public static final String AUTO_TIME = "auto_time";
        public static final String AUTO_TIME_ZONE = "auto_time_zone";
        public static final String BLUETOOTH_DISCOVERABILITY = "bluetooth_discoverability";
        public static final String BLUETOOTH_DISCOVERABILITY_TIMEOUT = "bluetooth_discoverability_timeout";
        public static final String BLUETOOTH_ON = "bluetooth_on";
        public static final String CALL_AUTO_RETRY = "call_auto_retry";
        public static final String CAR_DOCK_SOUND = "car_dock_sound";
        public static final String CAR_UNDOCK_SOUND = "car_undock_sound";
        public static final String COMPATIBILITY_MODE = "compatibility_mode";
        public static final Uri CONTENT_URI = Uri.parse("content://settings/system");
        public static final String DATA_ROAMING = "data_roaming";
        public static final String DATE_FORMAT = "date_format";
        public static final String DEBUG_APP = "debug_app";
        public static final Uri DEFAULT_ALARM_ALERT_URI = getUriFor("alarm_alert");
        public static final Uri DEFAULT_NOTIFICATION_URI = getUriFor("notification_sound");
        public static final Uri DEFAULT_RINGTONE_URI = getUriFor("ringtone");
        public static final String DESK_DOCK_SOUND = "desk_dock_sound";
        public static final String DESK_UNDOCK_SOUND = "desk_undock_sound";
        public static final String DEVICE_PROVISIONED = "device_provisioned";
        public static final String DIM_SCREEN = "dim_screen";
        public static final String DOCK_SOUNDS_ENABLED = "dock_sounds_enabled";
        public static final String DTMF_TONE_TYPE_WHEN_DIALING = "dtmf_tone_type";
        public static final String DTMF_TONE_WHEN_DIALING = "dtmf_tone";
        public static final String EMERGENCY_TONE = "emergency_tone";
        public static final String END_BUTTON_BEHAVIOR = "end_button_behavior";
        public static final int END_BUTTON_BEHAVIOR_DEFAULT = 2;
        public static final int END_BUTTON_BEHAVIOR_HOME = 1;
        public static final int END_BUTTON_BEHAVIOR_SLEEP = 2;
        public static final String FANCY_IME_ANIMATIONS = "fancy_ime_animations";
        public static final String FONT_SCALE = "font_scale";
        public static final String HAPTIC_FEEDBACK_ENABLED = "haptic_feedback_enabled";
        public static final String HEARING_AID = "hearing_aid";
        public static final String HIDE_ROTATION_LOCK_TOGGLE_FOR_ACCESSIBILITY = "hide_rotation_lock_toggle_for_accessibility";
        public static final String HTTP_PROXY = "http_proxy";
        public static final String INSTALL_NON_MARKET_APPS = "install_non_market_apps";
        public static final String LOCATION_PROVIDERS_ALLOWED = "location_providers_allowed";
        public static final String LOCKSCREEN_DISABLED = "lockscreen.disabled";
        public static final String LOCKSCREEN_SOUNDS_ENABLED = "lockscreen_sounds_enabled";
        public static final String LOCK_PATTERN_ENABLED = "lock_pattern_autolock";
        public static final String LOCK_PATTERN_TACTILE_FEEDBACK_ENABLED = "lock_pattern_tactile_feedback_enabled";
        public static final String LOCK_PATTERN_VISIBLE = "lock_pattern_visible_pattern";
        public static final String LOCK_SOUND = "lock_sound";
        public static final String LOGGING_ID = "logging_id";
        public static final String LOW_BATTERY_SOUND = "low_battery_sound";
        public static final String MEDIA_BUTTON_RECEIVER = "media_button_receiver";
        public static final String MODE_RINGER = "mode_ringer";
        public static final String MODE_RINGER_STREAMS_AFFECTED = "mode_ringer_streams_affected";
        private static final HashSet MOVED_TO_SECURE;
        public static final String MUTE_STREAMS_AFFECTED = "mute_streams_affected";
        public static final String NETWORK_PREFERENCE = "network_preference";
        public static final String NEXT_ALARM_FORMATTED = "next_alarm_formatted";
        public static final String NOTIFICATIONS_USE_RING_VOLUME = "notifications_use_ring_volume";
        public static final String NOTIFICATION_LIGHT_PULSE = "notification_light_pulse";
        public static final String NOTIFICATION_SOUND = "notification_sound";
        public static final String PARENTAL_CONTROL_ENABLED = "parental_control_enabled";
        public static final String PARENTAL_CONTROL_LAST_UPDATE = "parental_control_last_update";
        public static final String PARENTAL_CONTROL_REDIRECT_URL = "parental_control_redirect_url";
        public static final String POINTER_LOCATION = "pointer_location";
        public static final String POINTER_SPEED = "pointer_speed";
        public static final String POWER_SOUNDS_ENABLED = "power_sounds_enabled";
        public static final String RADIO_BLUETOOTH = "bluetooth";
        public static final String RADIO_CELL = "cell";
        public static final String RADIO_NFC = "nfc";
        public static final String RADIO_WIFI = "wifi";
        public static final String RADIO_WIMAX = "wimax";
        public static final String RINGTONE = "ringtone";
        public static final String SCREEN_AUTO_BRIGHTNESS_ADJ = "screen_auto_brightness_adj";
        public static final String SCREEN_BRIGHTNESS = "screen_brightness";
        public static final String SCREEN_BRIGHTNESS_MODE = "screen_brightness_mode";
        public static final int SCREEN_BRIGHTNESS_MODE_AUTOMATIC = 1;
        public static final int SCREEN_BRIGHTNESS_MODE_MANUAL = 0;
        public static final String SCREEN_OFF_TIMEOUT = "screen_off_timeout";
        public static final String SETTINGS_CLASSNAME = "settings_classname";
        public static final String SETTINGS_TO_BACKUP[];
        public static final String SETUP_WIZARD_HAS_RUN = "setup_wizard_has_run";
        public static final String SHOW_GTALK_SERVICE_STATUS = "SHOW_GTALK_SERVICE_STATUS";
        public static final String SHOW_PROCESSES = "show_processes";
        public static final String SHOW_TOUCHES = "show_touches";
        public static final String SHOW_WEB_SUGGESTIONS = "show_web_suggestions";
        public static final String SIP_ADDRESS_ONLY = "SIP_ADDRESS_ONLY";
        public static final String SIP_ALWAYS = "SIP_ALWAYS";
        public static final String SIP_ASK_ME_EACH_TIME = "SIP_ASK_ME_EACH_TIME";
        public static final String SIP_CALL_OPTIONS = "sip_call_options";
        public static final String SIP_RECEIVE_CALLS = "sip_receive_calls";
        public static final String SOUND_EFFECTS_ENABLED = "sound_effects_enabled";
        public static final String STAY_ON_WHILE_PLUGGED_IN = "stay_on_while_plugged_in";
        public static final String SYS_PROP_SETTING_VERSION = "sys.settings_system_version";
        public static final String TEXT_AUTO_CAPS = "auto_caps";
        public static final String TEXT_AUTO_PUNCTUATE = "auto_punctuate";
        public static final String TEXT_AUTO_REPLACE = "auto_replace";
        public static final String TEXT_SHOW_PASSWORD = "show_password";
        public static final String TIME_12_24 = "time_12_24";
        public static final String TRANSITION_ANIMATION_SCALE = "transition_animation_scale";
        public static final String TTY_MODE = "tty_mode";
        public static final String UNLOCK_SOUND = "unlock_sound";
        public static final String USB_MASS_STORAGE_ENABLED = "usb_mass_storage_enabled";
        public static final String USER_ROTATION = "user_rotation";
        public static final String USE_GOOGLE_MAIL = "use_google_mail";
        public static final String VIBRATE_INPUT_DEVICES = "vibrate_input_devices";
        public static final String VIBRATE_IN_SILENT = "vibrate_in_silent";
        public static final String VIBRATE_ON = "vibrate_on";
        public static final String VIBRATE_WHEN_RINGING = "vibrate_when_ringing";
        public static final String VOLUME_ALARM = "volume_alarm";
        public static final String VOLUME_BLUETOOTH_SCO = "volume_bluetooth_sco";
        public static final String VOLUME_MASTER = "volume_master";
        public static final String VOLUME_MASTER_MUTE = "volume_master_mute";
        public static final String VOLUME_MUSIC = "volume_music";
        public static final String VOLUME_NOTIFICATION = "volume_notification";
        public static final String VOLUME_RING = "volume_ring";
        public static final String VOLUME_SETTINGS[];
        public static final String VOLUME_SYSTEM = "volume_system";
        public static final String VOLUME_VOICE = "volume_voice";
        public static final String WAIT_FOR_DEBUGGER = "wait_for_debugger";
        public static final String WALLPAPER_ACTIVITY = "wallpaper_activity";
        public static final String WIFI_MAX_DHCP_RETRY_COUNT = "wifi_max_dhcp_retry_count";
        public static final String WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS = "wifi_mobile_data_transition_wakelock_timeout_ms";
        public static final String WIFI_NETWORKS_AVAILABLE_NOTIFICATION_ON = "wifi_networks_available_notification_on";
        public static final String WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY = "wifi_networks_available_repeat_delay";
        public static final String WIFI_NUM_OPEN_NETWORKS_KEPT = "wifi_num_open_networks_kept";
        public static final String WIFI_ON = "wifi_on";
        public static final String WIFI_SLEEP_POLICY = "wifi_sleep_policy";
        public static final int WIFI_SLEEP_POLICY_DEFAULT = 0;
        public static final int WIFI_SLEEP_POLICY_NEVER = 2;
        public static final int WIFI_SLEEP_POLICY_NEVER_WHILE_PLUGGED = 1;
        public static final String WIFI_STATIC_DNS1 = "wifi_static_dns1";
        public static final String WIFI_STATIC_DNS2 = "wifi_static_dns2";
        public static final String WIFI_STATIC_GATEWAY = "wifi_static_gateway";
        public static final String WIFI_STATIC_IP = "wifi_static_ip";
        public static final String WIFI_STATIC_NETMASK = "wifi_static_netmask";
        public static final String WIFI_USE_STATIC_IP = "wifi_use_static_ip";
        public static final String WIFI_WATCHDOG_ACCEPTABLE_PACKET_LOSS_PERCENTAGE = "wifi_watchdog_acceptable_packet_loss_percentage";
        public static final String WIFI_WATCHDOG_AP_COUNT = "wifi_watchdog_ap_count";
        public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_DELAY_MS = "wifi_watchdog_background_check_delay_ms";
        public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_ENABLED = "wifi_watchdog_background_check_enabled";
        public static final String WIFI_WATCHDOG_BACKGROUND_CHECK_TIMEOUT_MS = "wifi_watchdog_background_check_timeout_ms";
        public static final String WIFI_WATCHDOG_INITIAL_IGNORED_PING_COUNT = "wifi_watchdog_initial_ignored_ping_count";
        public static final String WIFI_WATCHDOG_MAX_AP_CHECKS = "wifi_watchdog_max_ap_checks";
        public static final String WIFI_WATCHDOG_ON = "wifi_watchdog_on";
        public static final String WIFI_WATCHDOG_PING_COUNT = "wifi_watchdog_ping_count";
        public static final String WIFI_WATCHDOG_PING_DELAY_MS = "wifi_watchdog_ping_delay_ms";
        public static final String WIFI_WATCHDOG_PING_TIMEOUT_MS = "wifi_watchdog_ping_timeout_ms";
        public static final String WINDOW_ANIMATION_SCALE = "window_animation_scale";
        public static final String WINDOW_ORIENTATION_LISTENER_LOG = "window_orientation_listener_log";
        private static NameValueCache sNameValueCache = null;

        static  {
            MOVED_TO_SECURE = new HashSet(30);
            MOVED_TO_SECURE.add("adb_enabled");
            MOVED_TO_SECURE.add("android_id");
            MOVED_TO_SECURE.add("bluetooth_on");
            MOVED_TO_SECURE.add("data_roaming");
            MOVED_TO_SECURE.add("device_provisioned");
            MOVED_TO_SECURE.add("http_proxy");
            MOVED_TO_SECURE.add("install_non_market_apps");
            MOVED_TO_SECURE.add("location_providers_allowed");
            MOVED_TO_SECURE.add("lock_biometric_weak_flags");
            MOVED_TO_SECURE.add("lock_pattern_autolock");
            MOVED_TO_SECURE.add("lock_pattern_visible_pattern");
            MOVED_TO_SECURE.add("lock_pattern_tactile_feedback_enabled");
            MOVED_TO_SECURE.add("logging_id");
            MOVED_TO_SECURE.add("parental_control_enabled");
            MOVED_TO_SECURE.add("parental_control_last_update");
            MOVED_TO_SECURE.add("parental_control_redirect_url");
            MOVED_TO_SECURE.add("settings_classname");
            MOVED_TO_SECURE.add("usb_mass_storage_enabled");
            MOVED_TO_SECURE.add("use_google_mail");
            MOVED_TO_SECURE.add("wifi_networks_available_notification_on");
            MOVED_TO_SECURE.add("wifi_networks_available_repeat_delay");
            MOVED_TO_SECURE.add("wifi_num_open_networks_kept");
            MOVED_TO_SECURE.add("wifi_on");
            MOVED_TO_SECURE.add("wifi_watchdog_acceptable_packet_loss_percentage");
            MOVED_TO_SECURE.add("wifi_watchdog_ap_count");
            MOVED_TO_SECURE.add("wifi_watchdog_background_check_delay_ms");
            MOVED_TO_SECURE.add("wifi_watchdog_background_check_enabled");
            MOVED_TO_SECURE.add("wifi_watchdog_background_check_timeout_ms");
            MOVED_TO_SECURE.add("wifi_watchdog_initial_ignored_ping_count");
            MOVED_TO_SECURE.add("wifi_watchdog_max_ap_checks");
            MOVED_TO_SECURE.add("wifi_watchdog_on");
            MOVED_TO_SECURE.add("wifi_watchdog_ping_count");
            MOVED_TO_SECURE.add("wifi_watchdog_ping_delay_ms");
            MOVED_TO_SECURE.add("wifi_watchdog_ping_timeout_ms");
            String as[] = new String[7];
            as[0] = "volume_voice";
            as[1] = "volume_system";
            as[2] = "volume_ring";
            as[3] = "volume_music";
            as[4] = "volume_alarm";
            as[5] = "volume_notification";
            as[6] = "volume_bluetooth_sco";
            VOLUME_SETTINGS = as;
            String as1[] = new String[57];
            as1[0] = "stay_on_while_plugged_in";
            as1[1] = "wifi_use_static_ip";
            as1[2] = "wifi_static_ip";
            as1[3] = "wifi_static_gateway";
            as1[4] = "wifi_static_netmask";
            as1[5] = "wifi_static_dns1";
            as1[6] = "wifi_static_dns2";
            as1[7] = "bluetooth_discoverability";
            as1[8] = "bluetooth_discoverability_timeout";
            as1[9] = "dim_screen";
            as1[10] = "screen_off_timeout";
            as1[11] = "screen_brightness";
            as1[12] = "screen_brightness_mode";
            as1[13] = "screen_auto_brightness_adj";
            as1[14] = "vibrate_input_devices";
            as1[15] = "mode_ringer";
            as1[16] = "mode_ringer_streams_affected";
            as1[17] = "mute_streams_affected";
            as1[18] = "volume_voice";
            as1[19] = "volume_system";
            as1[20] = "volume_ring";
            as1[21] = "volume_music";
            as1[22] = "volume_alarm";
            as1[23] = "volume_notification";
            as1[24] = "volume_bluetooth_sco";
            as1[25] = "volume_voice_last_audible";
            as1[26] = "volume_system_last_audible";
            as1[27] = "volume_ring_last_audible";
            as1[28] = "volume_music_last_audible";
            as1[29] = "volume_alarm_last_audible";
            as1[30] = "volume_notification_last_audible";
            as1[31] = "volume_bluetooth_sco_last_audible";
            as1[32] = "auto_replace";
            as1[33] = "auto_caps";
            as1[34] = "auto_punctuate";
            as1[35] = "show_password";
            as1[36] = "auto_time";
            as1[37] = "auto_time_zone";
            as1[38] = "time_12_24";
            as1[39] = "date_format";
            as1[40] = "dtmf_tone";
            as1[41] = "dtmf_tone_type";
            as1[42] = "emergency_tone";
            as1[43] = "call_auto_retry";
            as1[44] = "hearing_aid";
            as1[45] = "tty_mode";
            as1[46] = "sound_effects_enabled";
            as1[47] = "haptic_feedback_enabled";
            as1[48] = "power_sounds_enabled";
            as1[49] = "dock_sounds_enabled";
            as1[50] = "lockscreen_sounds_enabled";
            as1[51] = "show_web_suggestions";
            as1[52] = "notification_light_pulse";
            as1[53] = "sip_call_options";
            as1[54] = "sip_receive_calls";
            as1[55] = "pointer_speed";
            as1[56] = "vibrate_when_ringing";
            SETTINGS_TO_BACKUP = as1;
        }

        public System() {
        }
    }

    private static class NameValueCache {

        public String getString(ContentResolver contentresolver, String s) {
            long l = SystemProperties.getLong(mVersionSystemProperty, 0L);
            this;
            JVM INSTR monitorenter ;
            String s2;
            if(mValuesVersion != l) {
                mValues.clear();
                mValuesVersion = l;
            }
            if(!mValues.containsKey(s))
                break MISSING_BLOCK_LABEL_65;
            s2 = (String)mValues.get(s);
            this;
            JVM INSTR monitorexit ;
            String s1;
            s1 = s2;
            break MISSING_BLOCK_LABEL_423;
            this;
            JVM INSTR monitorexit ;
            this;
            JVM INSTR monitorenter ;
            IContentProvider icontentprovider;
            icontentprovider = mContentProvider;
            if(icontentprovider == null) {
                IContentProvider icontentprovider1 = contentresolver.acquireProvider(mUri.getAuthority());
                mContentProvider = icontentprovider1;
                icontentprovider = icontentprovider1;
            }
            this;
            JVM INSTR monitorexit ;
            if(mCallCommand == null)
                break MISSING_BLOCK_LABEL_166;
            Bundle bundle;
            bundle = icontentprovider.call(mCallCommand, s, null);
            if(bundle == null)
                break MISSING_BLOCK_LABEL_166;
            s1 = bundle.getPairValue();
            this;
            JVM INSTR monitorenter ;
            mValues.put(s, s1);
            break MISSING_BLOCK_LABEL_423;
            RemoteException remoteexception1;
            remoteexception1;
            Cursor cursor = null;
            Uri uri = mUri;
            String as[] = SELECT_VALUE;
            String as1[] = new String[1];
            as1[0] = s;
            cursor = icontentprovider.query(uri, as, "name=?", as1, null, null);
            if(cursor != null)
                break MISSING_BLOCK_LABEL_284;
            Log.w("Settings", (new StringBuilder()).append("Can't get key ").append(s).append(" from ").append(mUri).toString());
            s1 = null;
            if(cursor != null)
                cursor.close();
            break MISSING_BLOCK_LABEL_423;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
            Exception exception1;
            exception1;
            this;
            JVM INSTR monitorexit ;
            throw exception1;
            if(!cursor.moveToNext())
                break MISSING_BLOCK_LABEL_334;
            s1 = cursor.getString(0);
_L1:
            this;
            JVM INSTR monitorenter ;
            mValues.put(s, s1);
            this;
            JVM INSTR monitorexit ;
            if(cursor != null)
                cursor.close();
            break MISSING_BLOCK_LABEL_423;
            s1 = null;
              goto _L1
            Exception exception3;
            exception3;
            this;
            JVM INSTR monitorexit ;
            throw exception3;
            RemoteException remoteexception;
            remoteexception;
            Log.w("Settings", (new StringBuilder()).append("Can't get key ").append(s).append(" from ").append(mUri).toString(), remoteexception);
            s1 = null;
            if(cursor != null)
                cursor.close();
            break MISSING_BLOCK_LABEL_423;
            Exception exception2;
            exception2;
            if(cursor != null)
                cursor.close();
            throw exception2;
            return s1;
        }

        private static final String NAME_EQ_PLACEHOLDER = "name=?";
        private static final String SELECT_VALUE[];
        private final String mCallCommand;
        private IContentProvider mContentProvider;
        private final Uri mUri;
        private final HashMap mValues = new HashMap();
        private long mValuesVersion;
        private final String mVersionSystemProperty;

        static  {
            String as[] = new String[1];
            as[0] = "value";
            SELECT_VALUE = as;
        }

        public NameValueCache(String s, Uri uri, String s1) {
            mValuesVersion = 0L;
            mContentProvider = null;
            mVersionSystemProperty = s;
            mUri = uri;
            mCallCommand = s1;
        }
    }

    public static class NameValueTable
        implements BaseColumns {

        public static Uri getUriFor(Uri uri, String s) {
            return Uri.withAppendedPath(uri, s);
        }

        protected static boolean putString(ContentResolver contentresolver, Uri uri, String s, String s1) {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("name", s);
            contentvalues.put("value", s1);
            contentresolver.insert(uri, contentvalues);
            boolean flag = true;
_L2:
            return flag;
            SQLException sqlexception;
            sqlexception;
            Log.w("Settings", (new StringBuilder()).append("Can't set key ").append(s).append(" in ").append(uri).toString(), sqlexception);
            flag = false;
            if(true) goto _L2; else goto _L1
_L1:
        }

        public static final String NAME = "name";
        public static final String VALUE = "value";

        public NameValueTable() {
        }
    }

    public static class SettingNotFoundException extends AndroidException {

        public SettingNotFoundException(String s) {
            super(s);
        }
    }


    public Settings() {
    }

    public static String getGTalkDeviceId(long l) {
        return (new StringBuilder()).append("android-").append(Long.toHexString(l)).toString();
    }

    public static final String ACTION_ACCESSIBILITY_SETTINGS = "android.settings.ACCESSIBILITY_SETTINGS";
    public static final String ACTION_ADD_ACCOUNT = "android.settings.ADD_ACCOUNT_SETTINGS";
    public static final String ACTION_AIRPLANE_MODE_SETTINGS = "android.settings.AIRPLANE_MODE_SETTINGS";
    public static final String ACTION_APN_SETTINGS = "android.settings.APN_SETTINGS";
    public static final String ACTION_APPLICATION_DETAILS_SETTINGS = "android.settings.APPLICATION_DETAILS_SETTINGS";
    public static final String ACTION_APPLICATION_DEVELOPMENT_SETTINGS = "android.settings.APPLICATION_DEVELOPMENT_SETTINGS";
    public static final String ACTION_APPLICATION_SETTINGS = "android.settings.APPLICATION_SETTINGS";
    public static final String ACTION_BLUETOOTH_SETTINGS = "android.settings.BLUETOOTH_SETTINGS";
    public static final String ACTION_DATA_ROAMING_SETTINGS = "android.settings.DATA_ROAMING_SETTINGS";
    public static final String ACTION_DATE_SETTINGS = "android.settings.DATE_SETTINGS";
    public static final String ACTION_DEVICE_INFO_SETTINGS = "android.settings.DEVICE_INFO_SETTINGS";
    public static final String ACTION_DISPLAY_SETTINGS = "android.settings.DISPLAY_SETTINGS";
    public static final String ACTION_INPUT_METHOD_SETTINGS = "android.settings.INPUT_METHOD_SETTINGS";
    public static final String ACTION_INPUT_METHOD_SUBTYPE_SETTINGS = "android.settings.INPUT_METHOD_SUBTYPE_SETTINGS";
    public static final String ACTION_INTERNAL_STORAGE_SETTINGS = "android.settings.INTERNAL_STORAGE_SETTINGS";
    public static final String ACTION_LOCALE_SETTINGS = "android.settings.LOCALE_SETTINGS";
    public static final String ACTION_LOCATION_SOURCE_SETTINGS = "android.settings.LOCATION_SOURCE_SETTINGS";
    public static final String ACTION_MANAGE_ALL_APPLICATIONS_SETTINGS = "android.settings.MANAGE_ALL_APPLICATIONS_SETTINGS";
    public static final String ACTION_MANAGE_APPLICATIONS_SETTINGS = "android.settings.MANAGE_APPLICATIONS_SETTINGS";
    public static final String ACTION_MEMORY_CARD_SETTINGS = "android.settings.MEMORY_CARD_SETTINGS";
    public static final String ACTION_NETWORK_OPERATOR_SETTINGS = "android.settings.NETWORK_OPERATOR_SETTINGS";
    public static final String ACTION_NFCSHARING_SETTINGS = "android.settings.NFCSHARING_SETTINGS";
    public static final String ACTION_NFC_SETTINGS = "android.settings.NFC_SETTINGS";
    public static final String ACTION_PRIVACY_SETTINGS = "android.settings.PRIVACY_SETTINGS";
    public static final String ACTION_QUICK_LAUNCH_SETTINGS = "android.settings.QUICK_LAUNCH_SETTINGS";
    public static final String ACTION_SEARCH_SETTINGS = "android.search.action.SEARCH_SETTINGS";
    public static final String ACTION_SECURITY_SETTINGS = "android.settings.SECURITY_SETTINGS";
    public static final String ACTION_SETTINGS = "android.settings.SETTINGS";
    public static final String ACTION_SHOW_INPUT_METHOD_PICKER = "android.settings.SHOW_INPUT_METHOD_PICKER";
    public static final String ACTION_SOUND_SETTINGS = "android.settings.SOUND_SETTINGS";
    public static final String ACTION_SYNC_SETTINGS = "android.settings.SYNC_SETTINGS";
    public static final String ACTION_SYSTEM_UPDATE_SETTINGS = "android.settings.SYSTEM_UPDATE_SETTINGS";
    public static final String ACTION_USER_DICTIONARY_INSERT = "com.android.settings.USER_DICTIONARY_INSERT";
    public static final String ACTION_USER_DICTIONARY_SETTINGS = "android.settings.USER_DICTIONARY_SETTINGS";
    public static final String ACTION_WIFI_IP_SETTINGS = "android.settings.WIFI_IP_SETTINGS";
    public static final String ACTION_WIFI_SETTINGS = "android.settings.WIFI_SETTINGS";
    public static final String ACTION_WIRELESS_SETTINGS = "android.settings.WIRELESS_SETTINGS";
    public static final String AUTHORITY = "settings";
    public static final String CALL_METHOD_GET_SECURE = "GET_secure";
    public static final String CALL_METHOD_GET_SYSTEM = "GET_system";
    public static final String EXTRA_AUTHORITIES = "authorities";
    public static final String EXTRA_INPUT_METHOD_ID = "input_method_id";
    private static final String JID_RESOURCE_PREFIX = "android";
    private static final boolean LOCAL_LOGV = false;
    private static final String TAG = "Settings";
}
