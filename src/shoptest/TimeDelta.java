package shoptest;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Slezak Attila on 2016.09.24..
 */
class TimeDelta {

    static Date addOneHour(Date date) {
        Calendar testCalender = Calendar.getInstance();
        testCalender.setTime(date);
        testCalender.add(Calendar.HOUR, 1);

        return testCalender.getTime();
    }

    static Date addOneDay(Date date) {
        Calendar testCalender = Calendar.getInstance();
        testCalender.setTime(date);
        testCalender.add(Calendar.DATE, 1);

        return testCalender.getTime();
    }
}
