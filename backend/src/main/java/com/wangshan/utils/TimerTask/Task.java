package com.wangshan.utils.TimerTask;

import org.joda.time.DateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/4/4.
 */
public class Task {
    TimerTask timerTask = new TimerTask(){
        @Override
        public void run() {
            System.out.println("====================task run, time:" + new DateTime());
        }
    };
    public Task(){
        Timer timer = new Timer();
        timer.schedule(timerTask, getTime(), 24*1000*1000);
    }

    public Date getTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 13);
        calendar.set(Calendar.MINUTE, 21);
        calendar.set(Calendar.SECOND, 00);
        Date time = calendar.getTime();
        return time;
    }
}
