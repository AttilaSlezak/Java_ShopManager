package auxiliary.testclasses;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Slezak Attila on 2016.09.24..
 */
public class TimeDelta {

    public static Date addOneHour(Date date) {
        Calendar testCalender = Calendar.getInstance();
        testCalender.setTime(date);
        testCalender.add(Calendar.HOUR, 1);

        return testCalender.getTime();
    }

    public static Date addOneDay(Date date) {
        Calendar testCalender = Calendar.getInstance();
        testCalender.setTime(date);
        testCalender.add(Calendar.DATE, 1);

        return testCalender.getTime();
    }
}
