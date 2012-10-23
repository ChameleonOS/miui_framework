// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.provider;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.*;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.os.RemoteException;

// Referenced classes of package android.provider:
//            BaseColumns

public final class CalendarContract {
    public static final class EventsRawTimes
        implements BaseColumns, EventsRawTimesColumns {

        private EventsRawTimes() {
        }
    }

    protected static interface EventsRawTimesColumns {

        public static final String DTEND_2445 = "dtend2445";
        public static final String DTSTART_2445 = "dtstart2445";
        public static final String EVENT_ID = "event_id";
        public static final String LAST_DATE_2445 = "lastDate2445";
        public static final String ORIGINAL_INSTANCE_TIME_2445 = "originalInstanceTime2445";
    }

    public static final class SyncState
        implements SyncStateContract.Columns {

        private static final String CONTENT_DIRECTORY = "syncstate";
        public static final Uri CONTENT_URI;

        static  {
            CONTENT_URI = Uri.withAppendedPath(CalendarContract.CONTENT_URI, "syncstate");
        }

        private SyncState() {
        }
    }

    public static final class ExtendedProperties
        implements BaseColumns, ExtendedPropertiesColumns, EventsColumns {

        public static final Uri CONTENT_URI = Uri.parse("content://com.android.calendar/extendedproperties");


        private ExtendedProperties() {
        }
    }

    protected static interface ExtendedPropertiesColumns {

        public static final String EVENT_ID = "event_id";
        public static final String NAME = "name";
        public static final String VALUE = "value";
    }

    public static final class Colors
        implements ColorsColumns {

        public static final Uri CONTENT_URI = Uri.parse("content://com.android.calendar/colors");
        public static final String TABLE_NAME = "Colors";


        private Colors() {
        }
    }

    protected static interface ColorsColumns
        extends SyncStateContract.Columns {

        public static final String COLOR = "color";
        public static final String COLOR_KEY = "color_index";
        public static final String COLOR_TYPE = "color_type";
        public static final int TYPE_CALENDAR = 0;
        public static final int TYPE_EVENT = 1;
    }

    public static final class CalendarAlerts
        implements BaseColumns, CalendarAlertsColumns, EventsColumns, CalendarColumns {

        public static final boolean alarmExists(ContentResolver contentresolver, long l, long l1, long l2) {
            Cursor cursor;
            boolean flag;
            String as[] = new String[1];
            as[0] = "alarmTime";
            Uri uri = CONTENT_URI;
            String as1[] = new String[3];
            as1[0] = Long.toString(l);
            as1[1] = Long.toString(l1);
            as1[2] = Long.toString(l2);
            cursor = contentresolver.query(uri, as, "event_id=? AND begin=? AND alarmTime=?", as1, null);
            flag = false;
            if(cursor == null)
                break MISSING_BLOCK_LABEL_88;
            int i = cursor.getCount();
            if(i > 0)
                flag = true;
            if(cursor != null)
                cursor.close();
            return flag;
            Exception exception;
            exception;
            if(cursor != null)
                cursor.close();
            throw exception;
        }

        public static final long findNextAlarmTime(ContentResolver contentresolver, long l) {
            Cursor cursor;
            long l1;
            (new StringBuilder()).append("alarmTime>=").append(l).toString();
            String as[] = new String[1];
            as[0] = "alarmTime";
            Uri uri = CONTENT_URI;
            String as1[] = new String[1];
            as1[0] = Long.toString(l);
            cursor = contentresolver.query(uri, as, "alarmTime>=?", as1, "alarmTime ASC");
            l1 = -1L;
            if(cursor == null)
                break MISSING_BLOCK_LABEL_101;
            long l2;
            if(!cursor.moveToFirst())
                break MISSING_BLOCK_LABEL_101;
            l2 = cursor.getLong(0);
            l1 = l2;
            if(cursor != null)
                cursor.close();
            return l1;
            Exception exception;
            exception;
            if(cursor != null)
                cursor.close();
            throw exception;
        }

        public static final Uri insert(ContentResolver contentresolver, long l, long l1, long l2, long l3, int i) {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("event_id", Long.valueOf(l));
            contentvalues.put("begin", Long.valueOf(l1));
            contentvalues.put("end", Long.valueOf(l2));
            contentvalues.put("alarmTime", Long.valueOf(l3));
            contentvalues.put("creationTime", Long.valueOf(System.currentTimeMillis()));
            contentvalues.put("receivedTime", Integer.valueOf(0));
            contentvalues.put("notifyTime", Integer.valueOf(0));
            contentvalues.put("state", Integer.valueOf(0));
            contentvalues.put("minutes", Integer.valueOf(i));
            return contentresolver.insert(CONTENT_URI, contentvalues);
        }

        public static final void rescheduleMissedAlarms(ContentResolver contentresolver, Context context, AlarmManager alarmmanager) {
            Cursor cursor;
            long l = System.currentTimeMillis();
            long l1 = l - 0x5265c00L;
            String as[] = new String[1];
            as[0] = "alarmTime";
            Uri uri = CONTENT_URI;
            String as1[] = new String[3];
            as1[0] = Long.toString(l);
            as1[1] = Long.toString(l1);
            as1[2] = Long.toString(l);
            cursor = contentresolver.query(uri, as, "state=0 AND alarmTime<? AND alarmTime>? AND end>=?", as1, "alarmTime ASC");
            if(cursor != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            long l2 = -1L;
_L4:
            long l3;
            if(!cursor.moveToNext())
                break; /* Loop/switch isn't completed */
            l3 = cursor.getLong(0);
            if(l2 == l3)
                continue; /* Loop/switch isn't completed */
            scheduleAlarm(context, alarmmanager, l3);
            l2 = l3;
            if(true) goto _L4; else goto _L3
_L3:
            cursor.close();
            if(true) goto _L1; else goto _L5
_L5:
            Exception exception;
            exception;
            cursor.close();
            throw exception;
        }

        public static void scheduleAlarm(Context context, AlarmManager alarmmanager, long l) {
            if(alarmmanager == null)
                alarmmanager = (AlarmManager)context.getSystemService("alarm");
            Intent intent = new Intent("android.intent.action.EVENT_REMINDER");
            intent.setData(ContentUris.withAppendedId(CalendarContract.CONTENT_URI, l));
            intent.putExtra("alarmTime", l);
            alarmmanager.set(0, l, PendingIntent.getBroadcast(context, 0, intent, 0));
        }

        public static final Uri CONTENT_URI = Uri.parse("content://com.android.calendar/calendar_alerts");
        public static final Uri CONTENT_URI_BY_INSTANCE = Uri.parse("content://com.android.calendar/calendar_alerts/by_instance");
        private static final boolean DEBUG = false;
        private static final String SORT_ORDER_ALARMTIME_ASC = "alarmTime ASC";
        public static final String TABLE_NAME = "CalendarAlerts";
        private static final String WHERE_ALARM_EXISTS = "event_id=? AND begin=? AND alarmTime=?";
        private static final String WHERE_FINDNEXTALARMTIME = "alarmTime>=?";
        private static final String WHERE_RESCHEDULE_MISSED_ALARMS = "state=0 AND alarmTime<? AND alarmTime>? AND end>=?";


        private CalendarAlerts() {
        }
    }

    protected static interface CalendarAlertsColumns {

        public static final String ALARM_TIME = "alarmTime";
        public static final String BEGIN = "begin";
        public static final String CREATION_TIME = "creationTime";
        public static final String DEFAULT_SORT_ORDER = "begin ASC,title ASC";
        public static final String END = "end";
        public static final String EVENT_ID = "event_id";
        public static final String MINUTES = "minutes";
        public static final String NOTIFY_TIME = "notifyTime";
        public static final String RECEIVED_TIME = "receivedTime";
        public static final String STATE = "state";
        public static final int STATE_DISMISSED = 2;
        public static final int STATE_FIRED = 1;
        public static final int STATE_SCHEDULED;
    }

    public static final class Reminders
        implements BaseColumns, RemindersColumns, EventsColumns {

        public static final Cursor query(ContentResolver contentresolver, long l, String as[]) {
            String as1[] = new String[1];
            as1[0] = Long.toString(l);
            return contentresolver.query(CONTENT_URI, as, "event_id=?", as1, null);
        }

        public static final Uri CONTENT_URI = Uri.parse("content://com.android.calendar/reminders");
        private static final String REMINDERS_WHERE = "event_id=?";


        private Reminders() {
        }
    }

    protected static interface RemindersColumns {

        public static final String EVENT_ID = "event_id";
        public static final String METHOD = "method";
        public static final int METHOD_ALARM = 4;
        public static final int METHOD_ALERT = 1;
        public static final int METHOD_DEFAULT = 0;
        public static final int METHOD_EMAIL = 2;
        public static final int METHOD_SMS = 3;
        public static final String MINUTES = "minutes";
        public static final int MINUTES_DEFAULT = -1;
    }

    public static final class EventDays
        implements EventDaysColumns {

        public static final Cursor query(ContentResolver contentresolver, int i, int j, String as[]) {
            Cursor cursor = null;
            if(j >= 1) {
                int k = -1 + (i + j);
                android.net.Uri.Builder builder = CONTENT_URI.buildUpon();
                ContentUris.appendId(builder, i);
                ContentUris.appendId(builder, k);
                cursor = contentresolver.query(builder.build(), as, "selected=1", null, "startDay");
            }
            return cursor;
        }

        public static final Uri CONTENT_URI = Uri.parse("content://com.android.calendar/instances/groupbyday");
        private static final String SELECTION = "selected=1";


        private EventDays() {
        }
    }

    protected static interface EventDaysColumns {

        public static final String ENDDAY = "endDay";
        public static final String STARTDAY = "startDay";
    }

    public static final class CalendarMetaData
        implements CalendarMetaDataColumns, BaseColumns {

        private CalendarMetaData() {
        }
    }

    protected static interface CalendarMetaDataColumns {

        public static final String LOCAL_TIMEZONE = "localTimezone";
        public static final String MAX_EVENTDAYS = "maxEventDays";
        public static final String MAX_INSTANCE = "maxInstance";
        public static final String MIN_EVENTDAYS = "minEventDays";
        public static final String MIN_INSTANCE = "minInstance";
    }

    public static final class CalendarCache
        implements CalendarCacheColumns {

        public static final String KEY_TIMEZONE_INSTANCES = "timezoneInstances";
        public static final String KEY_TIMEZONE_INSTANCES_PREVIOUS = "timezoneInstancesPrevious";
        public static final String KEY_TIMEZONE_TYPE = "timezoneType";
        public static final String TIMEZONE_TYPE_AUTO = "auto";
        public static final String TIMEZONE_TYPE_HOME = "home";
        public static final Uri URI = Uri.parse("content://com.android.calendar/properties");


        private CalendarCache() {
        }
    }

    protected static interface CalendarCacheColumns {

        public static final String KEY = "key";
        public static final String VALUE = "value";
    }

    public static final class Instances
        implements BaseColumns, EventsColumns, CalendarColumns {

        public static final Cursor query(ContentResolver contentresolver, String as[], long l, long l1) {
            android.net.Uri.Builder builder = CONTENT_URI.buildUpon();
            ContentUris.appendId(builder, l);
            ContentUris.appendId(builder, l1);
            return contentresolver.query(builder.build(), as, "visible=?", WHERE_CALENDARS_ARGS, "begin ASC");
        }

        public static final Cursor query(ContentResolver contentresolver, String as[], long l, long l1, String s) {
            android.net.Uri.Builder builder = CONTENT_SEARCH_URI.buildUpon();
            ContentUris.appendId(builder, l);
            ContentUris.appendId(builder, l1);
            return contentresolver.query(builder.appendPath(s).build(), as, "visible=?", WHERE_CALENDARS_ARGS, "begin ASC");
        }

        public static final String BEGIN = "begin";
        public static final Uri CONTENT_BY_DAY_URI = Uri.parse("content://com.android.calendar/instances/whenbyday");
        public static final Uri CONTENT_SEARCH_BY_DAY_URI = Uri.parse("content://com.android.calendar/instances/searchbyday");
        public static final Uri CONTENT_SEARCH_URI = Uri.parse("content://com.android.calendar/instances/search");
        public static final Uri CONTENT_URI = Uri.parse("content://com.android.calendar/instances/when");
        private static final String DEFAULT_SORT_ORDER = "begin ASC";
        public static final String END = "end";
        public static final String END_DAY = "endDay";
        public static final String END_MINUTE = "endMinute";
        public static final String EVENT_ID = "event_id";
        public static final String START_DAY = "startDay";
        public static final String START_MINUTE = "startMinute";
        private static final String WHERE_CALENDARS_ARGS[];
        private static final String WHERE_CALENDARS_SELECTED = "visible=?";

        static  {
            String as[] = new String[1];
            as[0] = "1";
            WHERE_CALENDARS_ARGS = as;
        }

        private Instances() {
        }
    }

    public static final class Events
        implements BaseColumns, SyncColumns, EventsColumns, CalendarColumns {

        public static final Uri CONTENT_EXCEPTION_URI = Uri.parse("content://com.android.calendar/exception");
        public static final Uri CONTENT_URI = Uri.parse("content://com.android.calendar/events");
        private static final String DEFAULT_SORT_ORDER = "";
        public static String PROVIDER_WRITABLE_COLUMNS[];
        public static final String SYNC_WRITABLE_COLUMNS[];

        static  {
            String as[] = new String[24];
            as[0] = "account_name";
            as[1] = "account_type";
            as[2] = "cal_sync1";
            as[3] = "cal_sync2";
            as[4] = "cal_sync3";
            as[5] = "cal_sync4";
            as[6] = "cal_sync5";
            as[7] = "cal_sync6";
            as[8] = "cal_sync7";
            as[9] = "cal_sync8";
            as[10] = "cal_sync9";
            as[11] = "cal_sync10";
            as[12] = "allowedReminders";
            as[13] = "allowedAttendeeTypes";
            as[14] = "allowedAvailability";
            as[15] = "calendar_access_level";
            as[16] = "calendar_color";
            as[17] = "calendar_timezone";
            as[18] = "canModifyTimeZone";
            as[19] = "canOrganizerRespond";
            as[20] = "calendar_displayName";
            as[21] = "canPartiallyUpdate";
            as[22] = "sync_events";
            as[23] = "visible";
            PROVIDER_WRITABLE_COLUMNS = as;
            String as1[] = new String[12];
            as1[0] = "_sync_id";
            as1[1] = "dirty";
            as1[2] = "sync_data1";
            as1[3] = "sync_data2";
            as1[4] = "sync_data3";
            as1[5] = "sync_data4";
            as1[6] = "sync_data5";
            as1[7] = "sync_data6";
            as1[8] = "sync_data7";
            as1[9] = "sync_data8";
            as1[10] = "sync_data9";
            as1[11] = "sync_data10";
            SYNC_WRITABLE_COLUMNS = as1;
        }

        private Events() {
        }
    }

    public static final class EventsEntity
        implements BaseColumns, SyncColumns, EventsColumns {
        private static class EntityIteratorImpl extends CursorEntityIterator {

            public Entity getEntityAndIncrementCursor(Cursor cursor) throws RemoteException {
                long l;
                Entity entity;
                Cursor cursor1;
                l = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
                ContentValues contentvalues = new ContentValues();
                contentvalues.put("_id", Long.valueOf(l));
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentvalues, "calendar_id");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "title");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "description");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "eventLocation");
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentvalues, "eventStatus");
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentvalues, "selfAttendeeStatus");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentvalues, "dtstart");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentvalues, "dtend");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "duration");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "eventTimezone");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "eventEndTimezone");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "allDay");
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentvalues, "accessLevel");
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentvalues, "availability");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "hasAlarm");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "hasExtendedProperties");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "rrule");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "rdate");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "exrule");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "exdate");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "original_sync_id");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "original_id");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentvalues, "originalInstanceTime");
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentvalues, "originalAllDay");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentvalues, "lastDate");
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentvalues, "hasAttendeeData");
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentvalues, "guestsCanInviteOthers");
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentvalues, "guestsCanModify");
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentvalues, "guestsCanSeeGuests");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "customAppPackage");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "customAppUri");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "organizer");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "_sync_id");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentvalues, "dirty");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentvalues, "lastSynced");
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentvalues, "deleted");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "sync_data1");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "sync_data2");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "sync_data3");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "sync_data4");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "sync_data5");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "sync_data6");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "sync_data7");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "sync_data8");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "sync_data9");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "sync_data10");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "cal_sync1");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "cal_sync2");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "cal_sync3");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "cal_sync4");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "cal_sync5");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "cal_sync6");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "cal_sync7");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "cal_sync8");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "cal_sync9");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "cal_sync10");
                entity = new Entity(contentvalues);
                Exception exception;
                ContentValues contentvalues1;
                if(mResolver != null) {
                    ContentResolver contentresolver2 = mResolver;
                    Uri uri5 = Reminders.CONTENT_URI;
                    String as10[] = REMINDERS_PROJECTION;
                    String as11[] = new String[1];
                    as11[0] = Long.toString(l);
                    cursor1 = contentresolver2.query(uri5, as10, "event_id=?", as11, null);
                } else {
                    ContentProviderClient contentproviderclient = mProvider;
                    Uri uri = Reminders.CONTENT_URI;
                    String as[] = REMINDERS_PROJECTION;
                    String as1[] = new String[1];
                    as1[0] = Long.toString(l);
                    cursor1 = contentproviderclient.query(uri, as, "event_id=?", as1, null);
                }
                for(; cursor1.moveToNext(); entity.addSubValue(Reminders.CONTENT_URI, contentvalues1)) {
                    contentvalues1 = new ContentValues();
                    contentvalues1.put("minutes", Integer.valueOf(cursor1.getInt(0)));
                    contentvalues1.put("method", Integer.valueOf(cursor1.getInt(1)));
                }

                break MISSING_BLOCK_LABEL_676;
                exception;
                cursor1.close();
                throw exception;
                Cursor cursor2;
                cursor1.close();
                Exception exception1;
                ContentValues contentvalues2;
                if(mResolver != null) {
                    ContentResolver contentresolver1 = mResolver;
                    Uri uri4 = Attendees.CONTENT_URI;
                    String as8[] = ATTENDEES_PROJECTION;
                    String as9[] = new String[1];
                    as9[0] = Long.toString(l);
                    cursor2 = contentresolver1.query(uri4, as8, "event_id=?", as9, null);
                } else {
                    ContentProviderClient contentproviderclient1 = mProvider;
                    Uri uri1 = Attendees.CONTENT_URI;
                    String as2[] = ATTENDEES_PROJECTION;
                    String as3[] = new String[1];
                    as3[0] = Long.toString(l);
                    cursor2 = contentproviderclient1.query(uri1, as2, "event_id=?", as3, null);
                }
                for(; cursor2.moveToNext(); entity.addSubValue(Attendees.CONTENT_URI, contentvalues2)) {
                    contentvalues2 = new ContentValues();
                    contentvalues2.put("attendeeName", cursor2.getString(0));
                    contentvalues2.put("attendeeEmail", cursor2.getString(1));
                    contentvalues2.put("attendeeRelationship", Integer.valueOf(cursor2.getInt(2)));
                    contentvalues2.put("attendeeType", Integer.valueOf(cursor2.getInt(3)));
                    contentvalues2.put("attendeeStatus", Integer.valueOf(cursor2.getInt(4)));
                    contentvalues2.put("attendeeIdentity", cursor2.getString(5));
                    contentvalues2.put("attendeeIdNamespace", cursor2.getString(6));
                }

                break MISSING_BLOCK_LABEL_944;
                exception1;
                cursor2.close();
                throw exception1;
                Cursor cursor3;
                cursor2.close();
                Exception exception2;
                ContentValues contentvalues3;
                if(mResolver != null) {
                    ContentResolver contentresolver = mResolver;
                    Uri uri3 = ExtendedProperties.CONTENT_URI;
                    String as6[] = EXTENDED_PROJECTION;
                    String as7[] = new String[1];
                    as7[0] = Long.toString(l);
                    cursor3 = contentresolver.query(uri3, as6, "event_id=?", as7, null);
                } else {
                    ContentProviderClient contentproviderclient2 = mProvider;
                    Uri uri2 = ExtendedProperties.CONTENT_URI;
                    String as4[] = EXTENDED_PROJECTION;
                    String as5[] = new String[1];
                    as5[0] = Long.toString(l);
                    cursor3 = contentproviderclient2.query(uri2, as4, "event_id=?", as5, null);
                }
                for(; cursor3.moveToNext(); entity.addSubValue(ExtendedProperties.CONTENT_URI, contentvalues3)) {
                    contentvalues3 = new ContentValues();
                    contentvalues3.put("_id", cursor3.getString(0));
                    contentvalues3.put("name", cursor3.getString(1));
                    contentvalues3.put("value", cursor3.getString(2));
                }

                break MISSING_BLOCK_LABEL_1142;
                exception2;
                cursor3.close();
                throw exception2;
                cursor3.close();
                cursor.moveToNext();
                return entity;
            }

            private static final String ATTENDEES_PROJECTION[];
            private static final int COLUMN_ATTENDEE_EMAIL = 1;
            private static final int COLUMN_ATTENDEE_IDENTITY = 5;
            private static final int COLUMN_ATTENDEE_ID_NAMESPACE = 6;
            private static final int COLUMN_ATTENDEE_NAME = 0;
            private static final int COLUMN_ATTENDEE_RELATIONSHIP = 2;
            private static final int COLUMN_ATTENDEE_STATUS = 4;
            private static final int COLUMN_ATTENDEE_TYPE = 3;
            private static final int COLUMN_ID = 0;
            private static final int COLUMN_METHOD = 1;
            private static final int COLUMN_MINUTES = 0;
            private static final int COLUMN_NAME = 1;
            private static final int COLUMN_VALUE = 2;
            private static final String EXTENDED_PROJECTION[];
            private static final String REMINDERS_PROJECTION[];
            private static final String WHERE_EVENT_ID = "event_id=?";
            private final ContentProviderClient mProvider;
            private final ContentResolver mResolver;

            static  {
                String as[] = new String[2];
                as[0] = "minutes";
                as[1] = "method";
                REMINDERS_PROJECTION = as;
                String as1[] = new String[7];
                as1[0] = "attendeeName";
                as1[1] = "attendeeEmail";
                as1[2] = "attendeeRelationship";
                as1[3] = "attendeeType";
                as1[4] = "attendeeStatus";
                as1[5] = "attendeeIdentity";
                as1[6] = "attendeeIdNamespace";
                ATTENDEES_PROJECTION = as1;
                String as2[] = new String[3];
                as2[0] = "_id";
                as2[1] = "name";
                as2[2] = "value";
                EXTENDED_PROJECTION = as2;
            }

            public EntityIteratorImpl(Cursor cursor, ContentProviderClient contentproviderclient) {
                super(cursor);
                mResolver = null;
                mProvider = contentproviderclient;
            }

            public EntityIteratorImpl(Cursor cursor, ContentResolver contentresolver) {
                super(cursor);
                mResolver = contentresolver;
                mProvider = null;
            }
        }


        public static EntityIterator newEntityIterator(Cursor cursor, ContentProviderClient contentproviderclient) {
            return new EntityIteratorImpl(cursor, contentproviderclient);
        }

        public static EntityIterator newEntityIterator(Cursor cursor, ContentResolver contentresolver) {
            return new EntityIteratorImpl(cursor, contentresolver);
        }

        public static final Uri CONTENT_URI = Uri.parse("content://com.android.calendar/event_entities");


        private EventsEntity() {
        }
    }

    protected static interface EventsColumns {

        public static final int ACCESS_CONFIDENTIAL = 1;
        public static final int ACCESS_DEFAULT = 0;
        public static final String ACCESS_LEVEL = "accessLevel";
        public static final int ACCESS_PRIVATE = 2;
        public static final int ACCESS_PUBLIC = 3;
        public static final String ALL_DAY = "allDay";
        public static final String AVAILABILITY = "availability";
        public static final int AVAILABILITY_BUSY = 0;
        public static final int AVAILABILITY_FREE = 1;
        public static final int AVAILABILITY_TENTATIVE = 2;
        public static final String CALENDAR_ID = "calendar_id";
        public static final String CAN_INVITE_OTHERS = "canInviteOthers";
        public static final String CUSTOM_APP_PACKAGE = "customAppPackage";
        public static final String CUSTOM_APP_URI = "customAppUri";
        public static final String DESCRIPTION = "description";
        public static final String DISPLAY_COLOR = "displayColor";
        public static final String DTEND = "dtend";
        public static final String DTSTART = "dtstart";
        public static final String DURATION = "duration";
        public static final String EVENT_COLOR = "eventColor";
        public static final String EVENT_COLOR_KEY = "eventColor_index";
        public static final String EVENT_END_TIMEZONE = "eventEndTimezone";
        public static final String EVENT_LOCATION = "eventLocation";
        public static final String EVENT_TIMEZONE = "eventTimezone";
        public static final String EXDATE = "exdate";
        public static final String EXRULE = "exrule";
        public static final String GUESTS_CAN_INVITE_OTHERS = "guestsCanInviteOthers";
        public static final String GUESTS_CAN_MODIFY = "guestsCanModify";
        public static final String GUESTS_CAN_SEE_GUESTS = "guestsCanSeeGuests";
        public static final String HAS_ALARM = "hasAlarm";
        public static final String HAS_ATTENDEE_DATA = "hasAttendeeData";
        public static final String HAS_EXTENDED_PROPERTIES = "hasExtendedProperties";
        public static final String LAST_DATE = "lastDate";
        public static final String LAST_SYNCED = "lastSynced";
        public static final String ORGANIZER = "organizer";
        public static final String ORIGINAL_ALL_DAY = "originalAllDay";
        public static final String ORIGINAL_ID = "original_id";
        public static final String ORIGINAL_INSTANCE_TIME = "originalInstanceTime";
        public static final String ORIGINAL_SYNC_ID = "original_sync_id";
        public static final String RDATE = "rdate";
        public static final String RRULE = "rrule";
        public static final String SELF_ATTENDEE_STATUS = "selfAttendeeStatus";
        public static final String STATUS = "eventStatus";
        public static final int STATUS_CANCELED = 2;
        public static final int STATUS_CONFIRMED = 1;
        public static final int STATUS_TENTATIVE = 0;
        public static final String SYNC_DATA1 = "sync_data1";
        public static final String SYNC_DATA10 = "sync_data10";
        public static final String SYNC_DATA2 = "sync_data2";
        public static final String SYNC_DATA3 = "sync_data3";
        public static final String SYNC_DATA4 = "sync_data4";
        public static final String SYNC_DATA5 = "sync_data5";
        public static final String SYNC_DATA6 = "sync_data6";
        public static final String SYNC_DATA7 = "sync_data7";
        public static final String SYNC_DATA8 = "sync_data8";
        public static final String SYNC_DATA9 = "sync_data9";
        public static final String TITLE = "title";
    }

    public static final class Attendees
        implements BaseColumns, AttendeesColumns, EventsColumns {

        public static final Cursor query(ContentResolver contentresolver, long l, String as[]) {
            String as1[] = new String[1];
            as1[0] = Long.toString(l);
            return contentresolver.query(CONTENT_URI, as, "event_id=?", as1, null);
        }

        private static final String ATTENDEES_WHERE = "event_id=?";
        public static final Uri CONTENT_URI = Uri.parse("content://com.android.calendar/attendees");


        private Attendees() {
        }
    }

    protected static interface AttendeesColumns {

        public static final String ATTENDEE_EMAIL = "attendeeEmail";
        public static final String ATTENDEE_IDENTITY = "attendeeIdentity";
        public static final String ATTENDEE_ID_NAMESPACE = "attendeeIdNamespace";
        public static final String ATTENDEE_NAME = "attendeeName";
        public static final String ATTENDEE_RELATIONSHIP = "attendeeRelationship";
        public static final String ATTENDEE_STATUS = "attendeeStatus";
        public static final int ATTENDEE_STATUS_ACCEPTED = 1;
        public static final int ATTENDEE_STATUS_DECLINED = 2;
        public static final int ATTENDEE_STATUS_INVITED = 3;
        public static final int ATTENDEE_STATUS_NONE = 0;
        public static final int ATTENDEE_STATUS_TENTATIVE = 4;
        public static final String ATTENDEE_TYPE = "attendeeType";
        public static final String EVENT_ID = "event_id";
        public static final int RELATIONSHIP_ATTENDEE = 1;
        public static final int RELATIONSHIP_NONE = 0;
        public static final int RELATIONSHIP_ORGANIZER = 2;
        public static final int RELATIONSHIP_PERFORMER = 3;
        public static final int RELATIONSHIP_SPEAKER = 4;
        public static final int TYPE_NONE = 0;
        public static final int TYPE_OPTIONAL = 2;
        public static final int TYPE_REQUIRED = 1;
        public static final int TYPE_RESOURCE = 3;
    }

    public static final class Calendars
        implements BaseColumns, SyncColumns, CalendarColumns {

        public static final String CALENDAR_LOCATION = "calendar_location";
        public static final Uri CONTENT_URI = Uri.parse("content://com.android.calendar/calendars");
        public static final String DEFAULT_SORT_ORDER = "calendar_displayName";
        public static final String NAME = "name";
        public static final String SYNC_WRITABLE_COLUMNS[];

        static  {
            String as[] = new String[24];
            as[0] = "account_name";
            as[1] = "account_type";
            as[2] = "_sync_id";
            as[3] = "dirty";
            as[4] = "ownerAccount";
            as[5] = "maxReminders";
            as[6] = "allowedReminders";
            as[7] = "canModifyTimeZone";
            as[8] = "canOrganizerRespond";
            as[9] = "canPartiallyUpdate";
            as[10] = "calendar_location";
            as[11] = "calendar_timezone";
            as[12] = "calendar_access_level";
            as[13] = "deleted";
            as[14] = "cal_sync1";
            as[15] = "cal_sync2";
            as[16] = "cal_sync3";
            as[17] = "cal_sync4";
            as[18] = "cal_sync5";
            as[19] = "cal_sync6";
            as[20] = "cal_sync7";
            as[21] = "cal_sync8";
            as[22] = "cal_sync9";
            as[23] = "cal_sync10";
            SYNC_WRITABLE_COLUMNS = as;
        }

        private Calendars() {
        }
    }

    public static final class CalendarEntity
        implements BaseColumns, SyncColumns, CalendarColumns {
        private static class EntityIteratorImpl extends CursorEntityIterator {

            public Entity getEntityAndIncrementCursor(Cursor cursor) throws RemoteException {
                long l = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
                ContentValues contentvalues = new ContentValues();
                contentvalues.put("_id", Long.valueOf(l));
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "account_name");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "account_type");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "_sync_id");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentvalues, "dirty");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "cal_sync1");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "cal_sync2");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "cal_sync3");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "cal_sync4");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "cal_sync5");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "cal_sync6");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "cal_sync7");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "cal_sync8");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "cal_sync9");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "cal_sync10");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "name");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "calendar_displayName");
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentvalues, "calendar_color");
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentvalues, "calendar_access_level");
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentvalues, "visible");
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentvalues, "sync_events");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "calendar_location");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "calendar_timezone");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "ownerAccount");
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentvalues, "canOrganizerRespond");
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentvalues, "canModifyTimeZone");
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentvalues, "maxReminders");
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentvalues, "canPartiallyUpdate");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "allowedReminders");
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentvalues, "deleted");
                Entity entity = new Entity(contentvalues);
                cursor.moveToNext();
                return entity;
            }

            public EntityIteratorImpl(Cursor cursor) {
                super(cursor);
            }
        }


        public static EntityIterator newEntityIterator(Cursor cursor) {
            return new EntityIteratorImpl(cursor);
        }

        public static final Uri CONTENT_URI = Uri.parse("content://com.android.calendar/calendar_entities");


        private CalendarEntity() {
        }
    }

    protected static interface CalendarColumns {

        public static final String ALLOWED_ATTENDEE_TYPES = "allowedAttendeeTypes";
        public static final String ALLOWED_AVAILABILITY = "allowedAvailability";
        public static final String ALLOWED_REMINDERS = "allowedReminders";
        public static final String CALENDAR_ACCESS_LEVEL = "calendar_access_level";
        public static final String CALENDAR_COLOR = "calendar_color";
        public static final String CALENDAR_COLOR_KEY = "calendar_color_index";
        public static final String CALENDAR_DISPLAY_NAME = "calendar_displayName";
        public static final String CALENDAR_TIME_ZONE = "calendar_timezone";
        public static final int CAL_ACCESS_CONTRIBUTOR = 500;
        public static final int CAL_ACCESS_EDITOR = 600;
        public static final int CAL_ACCESS_FREEBUSY = 100;
        public static final int CAL_ACCESS_NONE = 0;
        public static final int CAL_ACCESS_OVERRIDE = 400;
        public static final int CAL_ACCESS_OWNER = 700;
        public static final int CAL_ACCESS_READ = 200;
        public static final int CAL_ACCESS_RESPOND = 300;
        public static final int CAL_ACCESS_ROOT = 800;
        public static final String CAN_MODIFY_TIME_ZONE = "canModifyTimeZone";
        public static final String CAN_ORGANIZER_RESPOND = "canOrganizerRespond";
        public static final String MAX_REMINDERS = "maxReminders";
        public static final String OWNER_ACCOUNT = "ownerAccount";
        public static final String SYNC_EVENTS = "sync_events";
        public static final String VISIBLE = "visible";
    }

    protected static interface SyncColumns
        extends CalendarSyncColumns {

        public static final String ACCOUNT_NAME = "account_name";
        public static final String ACCOUNT_TYPE = "account_type";
        public static final String CAN_PARTIALLY_UPDATE = "canPartiallyUpdate";
        public static final String DELETED = "deleted";
        public static final String DIRTY = "dirty";
        public static final String _SYNC_ID = "_sync_id";
    }

    protected static interface CalendarSyncColumns {

        public static final String CAL_SYNC1 = "cal_sync1";
        public static final String CAL_SYNC10 = "cal_sync10";
        public static final String CAL_SYNC2 = "cal_sync2";
        public static final String CAL_SYNC3 = "cal_sync3";
        public static final String CAL_SYNC4 = "cal_sync4";
        public static final String CAL_SYNC5 = "cal_sync5";
        public static final String CAL_SYNC6 = "cal_sync6";
        public static final String CAL_SYNC7 = "cal_sync7";
        public static final String CAL_SYNC8 = "cal_sync8";
        public static final String CAL_SYNC9 = "cal_sync9";
    }


    private CalendarContract() {
    }

    public static final String ACCOUNT_TYPE_LOCAL = "LOCAL";
    public static final String ACTION_EVENT_REMINDER = "android.intent.action.EVENT_REMINDER";
    public static final String ACTION_HANDLE_CUSTOM_EVENT = "android.provider.calendar.action.HANDLE_CUSTOM_EVENT";
    public static final String AUTHORITY = "com.android.calendar";
    public static final String CALLER_IS_SYNCADAPTER = "caller_is_syncadapter";
    public static final Uri CONTENT_URI = Uri.parse("content://com.android.calendar");
    public static final String EXTRA_CUSTOM_APP_URI = "customAppUri";
    public static final String EXTRA_EVENT_ALL_DAY = "allDay";
    public static final String EXTRA_EVENT_BEGIN_TIME = "beginTime";
    public static final String EXTRA_EVENT_END_TIME = "endTime";
    private static final String TAG = "Calendar";

}
