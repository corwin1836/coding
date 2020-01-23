package com.company;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Timer implements Tickable {
    Date startTime;
    int ticksElapsed;
    public Timer(){
        startTime = new Date();
    }

    public void tick(){
        ticksElapsed++;
    }

    public void printCurrentTime() {
        Calendar minuteCount = Calendar.getInstance();
        minuteCount.setTime(startTime);
        minuteCount.add(Calendar.MINUTE, ticksElapsed);
        Date currentTime = minuteCount.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        System.out.println("Tick: " + formatter.format(currentTime));
    }
}