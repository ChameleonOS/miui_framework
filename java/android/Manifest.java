// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android;


public final class Manifest {
    public static final class permission_group {

        public static final String ACCOUNTS = "android.permission-group.ACCOUNTS";
        public static final String COST_MONEY = "android.permission-group.COST_MONEY";
        public static final String DEVELOPMENT_TOOLS = "android.permission-group.DEVELOPMENT_TOOLS";
        public static final String HARDWARE_CONTROLS = "android.permission-group.HARDWARE_CONTROLS";
        public static final String LOCATION = "android.permission-group.LOCATION";
        public static final String MESSAGES = "android.permission-group.MESSAGES";
        public static final String NETWORK = "android.permission-group.NETWORK";
        public static final String PERSONAL_INFO = "android.permission-group.PERSONAL_INFO";
        public static final String PHONE_CALLS = "android.permission-group.PHONE_CALLS";
        public static final String STORAGE = "android.permission-group.STORAGE";
        public static final String SYSTEM_TOOLS = "android.permission-group.SYSTEM_TOOLS";

        public permission_group() {
        }
    }

    public static final class permission {

        public static final String ACCESS_CACHE_FILESYSTEM = "android.permission.ACCESS_CACHE_FILESYSTEM";
        public static final String ACCESS_CHECKIN_PROPERTIES = "android.permission.ACCESS_CHECKIN_PROPERTIES";
        public static final String ACCESS_COARSE_LOCATION = "android.permission.ACCESS_COARSE_LOCATION";
        public static final String ACCESS_CONTENT_PROVIDERS_EXTERNALLY = "android.permission.ACCESS_CONTENT_PROVIDERS_EXTERNALLY";
        public static final String ACCESS_FINE_LOCATION = "android.permission.ACCESS_FINE_LOCATION";
        public static final String ACCESS_LOCATION_EXTRA_COMMANDS = "android.permission.ACCESS_LOCATION_EXTRA_COMMANDS";
        public static final String ACCESS_MOCK_LOCATION = "android.permission.ACCESS_MOCK_LOCATION";
        public static final String ACCESS_MTP = "android.permission.ACCESS_MTP";
        public static final String ACCESS_NETWORK_STATE = "android.permission.ACCESS_NETWORK_STATE";
        public static final String ACCESS_SURFACE_FLINGER = "android.permission.ACCESS_SURFACE_FLINGER";
        public static final String ACCESS_WIFI_STATE = "android.permission.ACCESS_WIFI_STATE";
        public static final String ACCESS_WIMAX_STATE = "android.permission.ACCESS_WIMAX_STATE";
        public static final String ACCOUNT_MANAGER = "android.permission.ACCOUNT_MANAGER";
        public static final String ADD_VOICEMAIL = "com.android.voicemail.permission.ADD_VOICEMAIL";
        public static final String ALLOW_ANY_CODEC_FOR_PLAYBACK = "android.permission.ALLOW_ANY_CODEC_FOR_PLAYBACK";
        public static final String ASEC_ACCESS = "android.permission.ASEC_ACCESS";
        public static final String ASEC_CREATE = "android.permission.ASEC_CREATE";
        public static final String ASEC_DESTROY = "android.permission.ASEC_DESTROY";
        public static final String ASEC_MOUNT_UNMOUNT = "android.permission.ASEC_MOUNT_UNMOUNT";
        public static final String ASEC_RENAME = "android.permission.ASEC_RENAME";
        public static final String AUTHENTICATE_ACCOUNTS = "android.permission.AUTHENTICATE_ACCOUNTS";
        public static final String BACKUP = "android.permission.BACKUP";
        public static final String BATTERY_STATS = "android.permission.BATTERY_STATS";
        public static final String BIND_ACCESSIBILITY_SERVICE = "android.permission.BIND_ACCESSIBILITY_SERVICE";
        public static final String BIND_APPWIDGET = "android.permission.BIND_APPWIDGET";
        public static final String BIND_DEVICE_ADMIN = "android.permission.BIND_DEVICE_ADMIN";
        public static final String BIND_INPUT_METHOD = "android.permission.BIND_INPUT_METHOD";
        public static final String BIND_PACKAGE_VERIFIER = "android.permission.BIND_PACKAGE_VERIFIER";
        public static final String BIND_REMOTEVIEWS = "android.permission.BIND_REMOTEVIEWS";
        public static final String BIND_TEXT_SERVICE = "android.permission.BIND_TEXT_SERVICE";
        public static final String BIND_VPN_SERVICE = "android.permission.BIND_VPN_SERVICE";
        public static final String BIND_WALLPAPER = "android.permission.BIND_WALLPAPER";
        public static final String BLUETOOTH = "android.permission.BLUETOOTH";
        public static final String BLUETOOTH_ADMIN = "android.permission.BLUETOOTH_ADMIN";
        public static final String BRICK = "android.permission.BRICK";
        public static final String BROADCAST_PACKAGE_REMOVED = "android.permission.BROADCAST_PACKAGE_REMOVED";
        public static final String BROADCAST_SMS = "android.permission.BROADCAST_SMS";
        public static final String BROADCAST_STICKY = "android.permission.BROADCAST_STICKY";
        public static final String BROADCAST_WAP_PUSH = "android.permission.BROADCAST_WAP_PUSH";
        public static final String C2D_MESSAGE = "android.intent.category.MASTER_CLEAR.permission.C2D_MESSAGE";
        public static final String CALL_PHONE = "android.permission.CALL_PHONE";
        public static final String CALL_PRIVILEGED = "android.permission.CALL_PRIVILEGED";
        public static final String CAMERA = "android.permission.CAMERA";
        public static final String CHANGE_BACKGROUND_DATA_SETTING = "android.permission.CHANGE_BACKGROUND_DATA_SETTING";
        public static final String CHANGE_COMPONENT_ENABLED_STATE = "android.permission.CHANGE_COMPONENT_ENABLED_STATE";
        public static final String CHANGE_CONFIGURATION = "android.permission.CHANGE_CONFIGURATION";
        public static final String CHANGE_NETWORK_STATE = "android.permission.CHANGE_NETWORK_STATE";
        public static final String CHANGE_WIFI_MULTICAST_STATE = "android.permission.CHANGE_WIFI_MULTICAST_STATE";
        public static final String CHANGE_WIFI_STATE = "android.permission.CHANGE_WIFI_STATE";
        public static final String CHANGE_WIMAX_STATE = "android.permission.CHANGE_WIMAX_STATE";
        public static final String CLEAR_APP_CACHE = "android.permission.CLEAR_APP_CACHE";
        public static final String CLEAR_APP_USER_DATA = "android.permission.CLEAR_APP_USER_DATA";
        public static final String CONFIRM_FULL_BACKUP = "android.permission.CONFIRM_FULL_BACKUP";
        public static final String CONNECTIVITY_INTERNAL = "android.permission.CONNECTIVITY_INTERNAL";
        public static final String CONTROL_LOCATION_UPDATES = "android.permission.CONTROL_LOCATION_UPDATES";
        public static final String COPY_PROTECTED_DATA = "android.permission.COPY_PROTECTED_DATA";
        public static final String CRYPT_KEEPER = "android.permission.CRYPT_KEEPER";
        public static final String DELETE_CACHE_FILES = "android.permission.DELETE_CACHE_FILES";
        public static final String DELETE_PACKAGES = "android.permission.DELETE_PACKAGES";
        public static final String DEVICE_POWER = "android.permission.DEVICE_POWER";
        public static final String DIAGNOSTIC = "android.permission.DIAGNOSTIC";
        public static final String DISABLE_KEYGUARD = "android.permission.DISABLE_KEYGUARD";
        public static final String DUMP = "android.permission.DUMP";
        public static final String EXPAND_STATUS_BAR = "android.permission.EXPAND_STATUS_BAR";
        public static final String FACTORY_TEST = "android.permission.FACTORY_TEST";
        public static final String FLASHLIGHT = "android.permission.FLASHLIGHT";
        public static final String FORCE_BACK = "android.permission.FORCE_BACK";
        public static final String FORCE_STOP_PACKAGES = "android.permission.FORCE_STOP_PACKAGES";
        public static final String GET_ACCOUNTS = "android.permission.GET_ACCOUNTS";
        public static final String GET_DETAILED_TASKS = "android.permission.GET_DETAILED_TASKS";
        public static final String GET_PACKAGE_SIZE = "android.permission.GET_PACKAGE_SIZE";
        public static final String GET_TASKS = "android.permission.GET_TASKS";
        public static final String GLOBAL_SEARCH = "android.permission.GLOBAL_SEARCH";
        public static final String GLOBAL_SEARCH_CONTROL = "android.permission.GLOBAL_SEARCH_CONTROL";
        public static final String GRANT_REVOKE_PERMISSIONS = "android.permission.GRANT_REVOKE_PERMISSIONS";
        public static final String HARDWARE_TEST = "android.permission.HARDWARE_TEST";
        public static final String INJECT_EVENTS = "android.permission.INJECT_EVENTS";
        public static final String INSTALL_LOCATION_PROVIDER = "android.permission.INSTALL_LOCATION_PROVIDER";
        public static final String INSTALL_PACKAGES = "android.permission.INSTALL_PACKAGES";
        public static final String INTERNAL_SYSTEM_WINDOW = "android.permission.INTERNAL_SYSTEM_WINDOW";
        public static final String INTERNET = "android.permission.INTERNET";
        public static final String KILL_BACKGROUND_PROCESSES = "android.permission.KILL_BACKGROUND_PROCESSES";
        public static final String MANAGE_ACCOUNTS = "android.permission.MANAGE_ACCOUNTS";
        public static final String MANAGE_APP_TOKENS = "android.permission.MANAGE_APP_TOKENS";
        public static final String MANAGE_NETWORK_POLICY = "android.permission.MANAGE_NETWORK_POLICY";
        public static final String MANAGE_USB = "android.permission.MANAGE_USB";
        public static final String MASTER_CLEAR = "android.permission.MASTER_CLEAR";
        public static final String MODIFY_APPWIDGET_BIND_PERMISSIONS = "android.permission.MODIFY_APPWIDGET_BIND_PERMISSIONS";
        public static final String MODIFY_AUDIO_SETTINGS = "android.permission.MODIFY_AUDIO_SETTINGS";
        public static final String MODIFY_NETWORK_ACCOUNTING = "android.permission.MODIFY_NETWORK_ACCOUNTING";
        public static final String MODIFY_PHONE_STATE = "android.permission.MODIFY_PHONE_STATE";
        public static final String MOUNT_FORMAT_FILESYSTEMS = "android.permission.MOUNT_FORMAT_FILESYSTEMS";
        public static final String MOUNT_UNMOUNT_FILESYSTEMS = "android.permission.MOUNT_UNMOUNT_FILESYSTEMS";
        public static final String MOVE_PACKAGE = "android.permission.MOVE_PACKAGE";
        public static final String NET_ADMIN = "android.permission.NET_ADMIN";
        public static final String NFC = "android.permission.NFC";
        public static final String PACKAGE_USAGE_STATS = "android.permission.PACKAGE_USAGE_STATS";
        public static final String PACKAGE_VERIFICATION_AGENT = "android.permission.PACKAGE_VERIFICATION_AGENT";
        public static final String PERFORM_CDMA_PROVISIONING = "android.permission.PERFORM_CDMA_PROVISIONING";
        public static final String PERSISTENT_ACTIVITY = "android.permission.PERSISTENT_ACTIVITY";
        public static final String PROCESS_OUTGOING_CALLS = "android.permission.PROCESS_OUTGOING_CALLS";
        public static final String READ_CALENDAR = "android.permission.READ_CALENDAR";
        public static final String READ_CALL_LOG = "android.permission.READ_CALL_LOG";
        public static final String READ_CELL_BROADCASTS = "android.permission.READ_CELL_BROADCASTS";
        public static final String READ_CONTACTS = "android.permission.READ_CONTACTS";
        public static final String READ_EXTERNAL_STORAGE = "android.permission.READ_EXTERNAL_STORAGE";
        public static final String READ_FRAME_BUFFER = "android.permission.READ_FRAME_BUFFER";
        public static final String READ_HISTORY_BOOKMARKS = "com.android.browser.permission.READ_HISTORY_BOOKMARKS";
        public static final String READ_INPUT_STATE = "android.permission.READ_INPUT_STATE";
        public static final String READ_LOGS = "android.permission.READ_LOGS";
        public static final String READ_NETWORK_USAGE_HISTORY = "android.permission.READ_NETWORK_USAGE_HISTORY";
        public static final String READ_PHONE_STATE = "android.permission.READ_PHONE_STATE";
        public static final String READ_PRIVILEGED_PHONE_STATE = "android.permission.READ_PRIVILEGED_PHONE_STATE";
        public static final String READ_PROFILE = "android.permission.READ_PROFILE";
        public static final String READ_SMS = "android.permission.READ_SMS";
        public static final String READ_SOCIAL_STREAM = "android.permission.READ_SOCIAL_STREAM";
        public static final String READ_SYNC_SETTINGS = "android.permission.READ_SYNC_SETTINGS";
        public static final String READ_SYNC_STATS = "android.permission.READ_SYNC_STATS";
        public static final String READ_USER_DICTIONARY = "android.permission.READ_USER_DICTIONARY";
        public static final String REBOOT = "android.permission.REBOOT";
        public static final String RECEIVE_BOOT_COMPLETED = "android.permission.RECEIVE_BOOT_COMPLETED";
        public static final String RECEIVE_EMERGENCY_BROADCAST = "android.permission.RECEIVE_EMERGENCY_BROADCAST";
        public static final String RECEIVE_MMS = "android.permission.RECEIVE_MMS";
        public static final String RECEIVE_SMS = "android.permission.RECEIVE_SMS";
        public static final String RECEIVE_WAP_PUSH = "android.permission.RECEIVE_WAP_PUSH";
        public static final String RECORD_AUDIO = "android.permission.RECORD_AUDIO";
        public static final String REMOTE_AUDIO_PLAYBACK = "android.permission.REMOTE_AUDIO_PLAYBACK";
        public static final String REMOVE_TASKS = "android.permission.REMOVE_TASKS";
        public static final String REORDER_TASKS = "android.permission.REORDER_TASKS";
        public static final String RESTART_PACKAGES = "android.permission.RESTART_PACKAGES";
        public static final String RETRIEVE_WINDOW_CONTENT = "android.permission.RETRIEVE_WINDOW_CONTENT";
        public static final String SEND_SMS = "android.permission.SEND_SMS";
        public static final String SEND_SMS_NO_CONFIRMATION = "android.permission.SEND_SMS_NO_CONFIRMATION";
        public static final String SERIAL_PORT = "android.permission.SERIAL_PORT";
        public static final String SET_ACTIVITY_WATCHER = "android.permission.SET_ACTIVITY_WATCHER";
        public static final String SET_ALARM = "com.android.alarm.permission.SET_ALARM";
        public static final String SET_ALWAYS_FINISH = "android.permission.SET_ALWAYS_FINISH";
        public static final String SET_ANIMATION_SCALE = "android.permission.SET_ANIMATION_SCALE";
        public static final String SET_DEBUG_APP = "android.permission.SET_DEBUG_APP";
        public static final String SET_KEYBOARD_LAYOUT = "android.permission.SET_KEYBOARD_LAYOUT";
        public static final String SET_ORIENTATION = "android.permission.SET_ORIENTATION";
        public static final String SET_POINTER_SPEED = "android.permission.SET_POINTER_SPEED";
        public static final String SET_PREFERRED_APPLICATIONS = "android.permission.SET_PREFERRED_APPLICATIONS";
        public static final String SET_PROCESS_LIMIT = "android.permission.SET_PROCESS_LIMIT";
        public static final String SET_SCREEN_COMPATIBILITY = "android.permission.SET_SCREEN_COMPATIBILITY";
        public static final String SET_TIME = "android.permission.SET_TIME";
        public static final String SET_TIME_ZONE = "android.permission.SET_TIME_ZONE";
        public static final String SET_WALLPAPER = "android.permission.SET_WALLPAPER";
        public static final String SET_WALLPAPER_COMPONENT = "android.permission.SET_WALLPAPER_COMPONENT";
        public static final String SET_WALLPAPER_HINTS = "android.permission.SET_WALLPAPER_HINTS";
        public static final String SHUTDOWN = "android.permission.SHUTDOWN";
        public static final String SIGNAL_PERSISTENT_PROCESSES = "android.permission.SIGNAL_PERSISTENT_PROCESSES";
        public static final String START_ANY_ACTIVITY = "android.permission.START_ANY_ACTIVITY";
        public static final String STATUS_BAR = "android.permission.STATUS_BAR";
        public static final String STATUS_BAR_SERVICE = "android.permission.STATUS_BAR_SERVICE";
        public static final String STOP_APP_SWITCHES = "android.permission.STOP_APP_SWITCHES";
        public static final String SUBSCRIBED_FEEDS_READ = "android.permission.SUBSCRIBED_FEEDS_READ";
        public static final String SUBSCRIBED_FEEDS_WRITE = "android.permission.SUBSCRIBED_FEEDS_WRITE";
        public static final String SYSTEM_ALERT_WINDOW = "android.permission.SYSTEM_ALERT_WINDOW";
        public static final String UPDATE_DEVICE_STATS = "android.permission.UPDATE_DEVICE_STATS";
        public static final String UPDATE_LOCK = "android.permission.UPDATE_LOCK";
        public static final String USE_CREDENTIALS = "android.permission.USE_CREDENTIALS";
        public static final String USE_SIP = "android.permission.USE_SIP";
        public static final String VIBRATE = "android.permission.VIBRATE";
        public static final String WAKE_LOCK = "android.permission.WAKE_LOCK";
        public static final String WRITE_APN_SETTINGS = "android.permission.WRITE_APN_SETTINGS";
        public static final String WRITE_CALENDAR = "android.permission.WRITE_CALENDAR";
        public static final String WRITE_CALL_LOG = "android.permission.WRITE_CALL_LOG";
        public static final String WRITE_CONTACTS = "android.permission.WRITE_CONTACTS";
        public static final String WRITE_EXTERNAL_STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE";
        public static final String WRITE_GSERVICES = "android.permission.WRITE_GSERVICES";
        public static final String WRITE_HISTORY_BOOKMARKS = "com.android.browser.permission.WRITE_HISTORY_BOOKMARKS";
        public static final String WRITE_MEDIA_STORAGE = "android.permission.WRITE_MEDIA_STORAGE";
        public static final String WRITE_PROFILE = "android.permission.WRITE_PROFILE";
        public static final String WRITE_SECURE_SETTINGS = "android.permission.WRITE_SECURE_SETTINGS";
        public static final String WRITE_SETTINGS = "android.permission.WRITE_SETTINGS";
        public static final String WRITE_SMS = "android.permission.WRITE_SMS";
        public static final String WRITE_SOCIAL_STREAM = "android.permission.WRITE_SOCIAL_STREAM";
        public static final String WRITE_SYNC_SETTINGS = "android.permission.WRITE_SYNC_SETTINGS";
        public static final String WRITE_USER_DICTIONARY = "android.permission.WRITE_USER_DICTIONARY";

        public permission() {
        }
    }


    public Manifest() {
    }
}
