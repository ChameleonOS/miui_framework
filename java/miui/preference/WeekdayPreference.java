// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.preference.ListPreference;
import android.text.TextUtils;
import android.util.AttributeSet;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;

public class WeekdayPreference extends ListPreference {
    public static final class DaysOfWeek {

        private boolean isSet(int i) {
            boolean flag = true;
            if((mDays & flag << i) <= 0)
                flag = false;
            return flag;
        }

        public boolean[] getBooleanArray() {
            boolean aflag[] = new boolean[7];
            for(int i = 0; i < 7; i++)
                aflag[i] = isSet(i);

            return aflag;
        }

        public int getCoded() {
            return mDays;
        }

        public int getNextAlarm(Calendar calendar) {
            int j;
            if(mDays == 0) {
                j = -1;
            } else {
                int i = (5 + calendar.get(7)) % 7;
                j = 0;
                while(j < 7 && !isSet((i + j) % 7)) 
                    j++;
            }
            return j;
        }

        public boolean isRepeatSet() {
            boolean flag;
            if(mDays != 0)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public void set(int i, boolean flag) {
            if(flag)
                mDays = mDays | 1 << i;
            else
                mDays = mDays & (-1 ^ 1 << i);
        }

        public void set(DaysOfWeek daysofweek) {
            mDays = daysofweek.mDays;
        }

        public String toString(Context context, boolean flag) {
            String s;
            if(mDays == 0) {
                if(flag)
                    s = context.getText(0x60c01b0).toString();
                else
                    s = "";
            } else
            if(mDays == 127) {
                s = context.getText(0x60c01af).toString();
            } else {
                int i = 0;
                for(int j = mDays; j > 0; j >>= 1)
                    if((j & 1) == 1)
                        i++;

                DateFormatSymbols dateformatsymbols = new DateFormatSymbols();
                String as[];
                ArrayList arraylist;
                if(i > 1)
                    as = dateformatsymbols.getShortWeekdays();
                else
                    as = dateformatsymbols.getWeekdays();
                arraylist = new ArrayList();
                for(int k = 0; k < 7; k++)
                    if((mDays & 1 << k) != 0) {
                        arraylist.add(as[DAY_MAP[k]]);
                        i--;
                    }

                s = TextUtils.join(arraylist).toString();
            }
            return s;
        }

        private static int DAY_MAP[];
        private int mDays;

        static  {
            int ai[] = new int[7];
            ai[0] = 2;
            ai[1] = 3;
            ai[2] = 4;
            ai[3] = 5;
            ai[4] = 6;
            ai[5] = 7;
            ai[6] = 1;
            DAY_MAP = ai;
        }

        public DaysOfWeek(int i) {
            mDays = i;
        }
    }


    public WeekdayPreference(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mDaysOfWeek = new DaysOfWeek(0);
        mNewDaysOfWeek = new DaysOfWeek(0);
        String as[] = (new DateFormatSymbols()).getWeekdays();
        String as1[] = new String[7];
        as1[0] = as[2];
        as1[1] = as[3];
        as1[2] = as[4];
        as1[3] = as[5];
        as1[4] = as[6];
        as1[5] = as[7];
        as1[6] = as[1];
        setEntries(as1);
        setEntryValues(as1);
    }

    public DaysOfWeek getDaysOfWeek() {
        return mDaysOfWeek;
    }

    protected void onDialogClosed(boolean flag) {
        if(flag) {
            mDaysOfWeek.set(mNewDaysOfWeek);
            setSummary(mDaysOfWeek.toString(getContext(), true));
            callChangeListener(mDaysOfWeek);
        } else {
            mNewDaysOfWeek.set(mDaysOfWeek);
        }
    }

    protected void onPrepareDialogBuilder(android.app.AlertDialog.Builder builder) {
        if(mIsSingleChoice)
            super.onPrepareDialogBuilder(builder);
        else
            builder.setMultiChoiceItems(getEntries(), mDaysOfWeek.getBooleanArray(), new android.content.DialogInterface.OnMultiChoiceClickListener() {

                public void onClick(DialogInterface dialoginterface, int i, boolean flag) {
                    mNewDaysOfWeek.set(i, flag);
                }

                final WeekdayPreference this$0;

             {
                this$0 = WeekdayPreference.this;
                super();
            }
            });
    }

    public void setDaysOfWeek(DaysOfWeek daysofweek) {
        mDaysOfWeek.set(daysofweek);
        mNewDaysOfWeek.set(daysofweek);
        setSummary(daysofweek.toString(getContext(), true));
    }

    public void setSingleChoice(boolean flag) {
        mIsSingleChoice = flag;
    }

    private DaysOfWeek mDaysOfWeek;
    private boolean mIsSingleChoice;
    private DaysOfWeek mNewDaysOfWeek;

}
