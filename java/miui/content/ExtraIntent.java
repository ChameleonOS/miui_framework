// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.content;


public class ExtraIntent {

    public ExtraIntent() {
    }

    public static final String ACTION_ACCESS_CONTROL_CHANGED = "android.intent.action.ACCESS_CONTROL_CHANGED";
    public static final String ACTION_ACTIVATE_MX_EXTERNAL = "com.xiaomi.action.ACTIVATE_MX_EXTERNAL";
    public static final String ACTION_ACTIVATE_PHONE = "android.intent.action.XIAOMI_ACTIVATE_PHONE";
    public static final String ACTION_ACTIVATE_STATUS_CHANGED = "com.xiaomi.xmsf.action.ACTIVATE_STATUS_CHANGED";
    public static final String ACTION_ADD_FIREWALL = "android.intent.action.ADD_FIREWALL";
    public static final String ACTION_APPLICATION_MESSAGE_QUERY = "android.intent.action.APPLICATION_MESSAGE_QUERY";
    public static final String ACTION_APPLICATION_MESSAGE_UPDATE = "android.intent.action.APPLICATION_MESSAGE_UPDATE";
    public static final String ACTION_ASSIST = "android.intent.action.ASSIST";
    public static final String ACTION_BIND_WIDGET_COMPLETED = "miui.intent.action.BIND_WIDGET_COMPLETED";
    public static final String ACTION_BLUETOOTH_HANDSFREE_BATTERY_CHANGED = "android.intent.action.BLUETOOTH_HANDSFREE_BATTERY_CHANGED";
    public static final String ACTION_CAPTURE_SCREENSHOT = "android.intent.action.CAPTURE_SCREENSHOT";
    public static final String ACTION_CLOUD_RESTORE = "android.intent.action.CLOUD_RESTORE";
    public static final String ACTION_COLLECT_ANALYTICS_DATA = "android.intent.action.COLLECT_ANALYTICS_DATA";
    public static final String ACTION_CONFIRM_ACCESS_CONTROL = "android.app.action.CONFIRM_ACCESS_CONTROL";
    public static final String ACTION_CROP_SET_LOCKSCREEN_WALLPAPER = "android.intent.action.CROP_SET_LOCKSCREEN_WALLPAPER";
    public static final String ACTION_CROP_SET_WALLPAPER = "android.intent.action.CROP_SET_WALLPAPER";
    public static final String ACTION_DISABLE_FIND_DEVICE = "com.xiaomi.action.DISABLE_FIND_DEVICE";
    public static final String ACTION_ENABLE_FIND_DEVICE = "com.xiaomi.action.ENABLE_FIND_DEVICE";
    public static final String ACTION_FIND_DEVICE_STATUS_CHANGED = "com.xiaomi.action.FIND_DEVICE_STATUS_CHANGED";
    public static final String ACTION_FIREWALL_UPDATED = "android.intent.action.FIREWALL_UPDATED";
    public static final String ACTION_INSTALL_WIDGET = "com.miui.home.launcher.action.INSTALL_WIDGET";
    public static final String ACTION_KEYCODE_POWER_UP = "android.intent.action.KEYCODE_POWER_UP";
    public static final String ACTION_LOCK_DEVICE = "miui.intent.action.LOCK_DEVICE";
    public static final String ACTION_MANAGE_ACCOUNT = "android.intent.action.MANAGE_XIAOMI_ACCOUNT";
    public static final String ACTION_MIUI_DISCLAIMER = "android.intent.action.MIUI_DISCLAIMER";
    public static final String ACTION_MIUI_LICENSE = "android.intent.action.MIUI_LICENSE";
    public static final String ACTION_NOISE = "miui.intent.action.NOISE";
    public static final String ACTION_PRIVACY_MODE_CHANGED = "android.intent.action.PRIVACY_MODE_CHANGED";
    public static final String ACTION_REQUEST_LOCATION = "miui.intent.action.REQUEST_LOCATION";
    public static final String ACTION_RESTORE_FINISH = "android.intent.action.RESTORE_FINISH";
    public static final String ACTION_SET_FIREWALL = "android.intent.action.SET_FIREWALL";
    public static final String ACTION_SET_LOCKSCREEN_WALLPAPER = "android.intent.action.SET_LOCKSCREEN_WALLPAPER";
    public static final String ACTION_SHOW_MAGNIFIER = "android.intent.action.SHOW_MAGNIFIER";
    public static final String ACTION_START_ACTIVATE_PHONE = "com.xiaomi.xmsf.action.START_ACTIVATE";
    public static final String ACTION_TOGGLE_TORCH = "miui.intent.action.TOGGLE_TORCH";
    public static final String ACTION_VIEW_CONTACT_SHORTCUT = "android.intent.action.VIEW_CONTACT_SHORTCUT";
    public static final String ACTION_VIEW_DATA_USAGE_SUMMARY = "android.intent.action.VIEW_DATA_USAGE_SUMMARY";
    public static final String ACTION_WIPE_DATA = "miui.intent.action.WIPE_DATA";
    public static final String ACTION_XIAOMI_ACCOUNT_BIND_NICKNAME = "android.settings.XIAOMI_ACCOUNT_BIND_NICKNAME";
    public static final String ACTION_XIAOMI_ACCOUNT_EXPIRED = "android.intent.account.expired";
    public static final String ACTION_XIAOMI_ACCOUNT_SETTING = "android.settings.XIAOMI_ACCOUNT_SYNC_SETTINGS";
    public static final String ACTION_XIAOMI_SYNC_ADVANCED_SETTINGS = "com.xiaomi.SYNC_ADVANCED_SETTINGS";
    public static final String ADDRESSBOOK_NAME = "ADDRESSBOOK";
    public static final String CALLLOG_NAME = "CALLLOG";
    public static final String EXTRA_ACCOUNT = "account";
    public static final String EXTRA_ACTIVATE_ERROR_CODE = "extra_activate_err_code";
    public static final String EXTRA_AUTHORITY = "authority";
    public static final String EXTRA_BIND_TYPE = "extra_bind_type";
    public static final String EXTRA_BIND_WIDGET_RESULT = "miui.intent.extra.bind_widget_result";
    public static final String EXTRA_BLUETOOTH_HANDSFREE_BATTERY_LEVEL = "android.intent.extra.bluetooth_handsfree_battery_level";
    public static final String EXTRA_CAPTURE_SCREENSHOT_DELAY = "capture_delay";
    public static final long EXTRA_CAPTURE_SCREENSHOT_DELAY_DEFAULT = 1000L;
    public static final String EXTRA_CLOUD_RESTORE_TYPE = "cloud_restore_type";
    public static final String EXTRA_CUSTOMIZED_ICON_SHORTCUT = "android.intent.extra.CUSTOMIZED_ICON_SHORTCUT";
    public static final String EXTRA_DEVICE_CMD = "android.intent.extra.device_cmd";
    public static final String EXTRA_DEVICE_DIGEST = "android.intent.extra.device_digest";
    public static final String EXTRA_DEVICE_ID = "extra_deviceId";
    public static final String EXTRA_DEVICE_MSGID = "android.intent.extra.device_msgId";
    public static final String EXTRA_DEVICE_TIME = "android.intent.extra.device_time";
    public static final String EXTRA_DEVICE_TOKEN = "android.intent.extra.device_token";
    public static final String EXTRA_FIND_DEVICE_ENABLED = "find_device_enabled";
    public static final String EXTRA_IS_ENABLE = "miui.intent.extra.IS_ENABLE";
    public static final String EXTRA_IS_TOGGLE = "miui.intent.extra.IS_TOGGLE";
    public static final String EXTRA_LOCK_DEVICE_PASSWORD = "android.intent.extra.lock_password";
    public static final String EXTRA_PHONE = "extra_phone";
    public static final String EXTRA_PICKED_MULTIPLE_CONTACTS = "android.intent.extra.picked_multiple_contacts";
    public static final String EXTRA_PICK_ACCOUNT_DATASET = "android.intent.extra.pick_account_dataset";
    public static final String EXTRA_PICK_ACCOUNT_NAME = "android.intent.extra.pick_account_name";
    public static final String EXTRA_PICK_ACCOUNT_TYPE = "android.intent.extra.pick_account_type";
    public static final String EXTRA_PICK_GROUP_ID = "android.intent.extra.pick_group_id";
    public static final String EXTRA_PICK_MULTIPLE_CONTACTS_MODE = "android.intent.extra.pick_multiple_contacts_mode";
    public static final String EXTRA_PROVIDER_COMPONENT_NAME = "miui.intent.extra.provider_component_name";
    public static final String EXTRA_PWD = "extra_pwd";
    public static final String EXTRA_REG_TYPE_EMAIL = "reg_type_email";
    public static final String EXTRA_REG_TYPE_SMS = "reg_type_sms";
    public static final String EXTRA_RESULT_RECEIVER_COMPONENT_NAME = "miui.intent.extra.result_receiver_component_name";
    public static final String EXTRA_SHOW_BLUETOOTH_HANDSFREE_BATTERY = "android.intent.extra.show_bluetooth_handsfree_battery";
    public static final String EXTRA_SIM_ID = "extra_simId";
    public static final String EXTRA_UPDATE_APPLICATION_COMPONENT_NAME = "android.intent.extra.update_application_component_name";
    public static final String EXTRA_UPDATE_APPLICATION_MESSAGE_ICON_TILE = "android.intent.extra.update_application_message_icon_tile";
    public static final String EXTRA_UPDATE_APPLICATION_MESSAGE_TEXT = "android.intent.extra.update_application_message_text";
    public static final String EXTRA_UPDATE_APPLICATION_MESSAGE_TEXT_BACKGROUND = "android.intent.extra.update_application_message_text_background";
    public static final String EXTRA_VIEW_SIM_CONTACTS = "view_sim_contacts";
    public static final String EXTRA_XIAOMI_ACCOUNT = "account";
    public static final String EXTRA_XIAOMI_ACCOUNT_NAME = "user_name";
    public static final String EXTRA_XIAOMI_ACCOUNT_REG_TYPE = "reg_type";
    public static final String EXTRA_XIAOMI_ACCOUNT_USER_ID = "user_id";
    public static final String NOTE_NAME = "NOTE";
    public static final String SMS_NAME = "SMS";
    public static final String SYNC_SETTINGS_ACTION_APPENDER = ".SYNC_SETTINGS";
    public static final String WIFI_NAME = "WIFI";
    public static final String XIAOMI_ACCOUNT_TYPE = "com.xiaomi";
    public static final String XIAOMI_ACCOUNT_TYPE_UNACTIVATED = "com.xiaomi.unactivated";
    public static final String XIAOMI_KEY_ACCOUNT_TYPE = "com.miui.auth";
    public static final String XIAOMI_KEY_AUTHTOKEN = "token";
    public static final String XIAOMI_KEY_SERVICE_URL = "service_url";
}
