package Patterns.SmartParking;

import java.util.Calendar;

public class Utils {
    public static double minuteDifference(Calendar date1, Calendar date2) {
        return (date1.getTimeInMillis() - date2.getTimeInMillis()) / 60000.0;
    }
}
