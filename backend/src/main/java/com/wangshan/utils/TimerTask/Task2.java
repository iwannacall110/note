package com.wangshan.utils.TimerTask;

import org.joda.time.DateTime;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/4/4.
 */
public class Task2{
    private long allDay = 24 * 60 * 1000 * 1000;

    public Task2(){
        ScheduledExecutorService scheduExec = Executors.newScheduledThreadPool(2);
        scheduExec.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("====================task run, time:" + new DateTime());
            }
        }, getTime("T17:55:00"), 3000, TimeUnit.MILLISECONDS);
    }

    public long getTime(String firstTime){
        long gap = new DateTime(firstTime).getMillisOfDay() - DateTime.now().getMillisOfDay();
        if(gap < 0){
            gap = allDay + gap;
        }
        return gap;
    }
}
