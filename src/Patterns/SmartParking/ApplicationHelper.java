package Patterns.SmartParking;

import java.util.Calendar;

public class ApplicationHelper {
    private static ApplicationHelper instance;
    private Calendar curDt;

    public static ApplicationHelper getInstance() {
        if (instance == null) {
            instance = new ApplicationHelper();
        }
        return instance;
    }

    private ApplicationHelper(){}

    public Calendar getCurDt() {
        if (curDt == null) {
            return Calendar.getInstance();
        }
        else
            return curDt;
    }

    public void setCurDt(Calendar curDt) {
        this.curDt = curDt;
    }
}
