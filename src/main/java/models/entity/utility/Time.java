package models.entity.utility;

import models.excpetions.InvalidTime;

public class Time {
    int hours;
    int minutes;
    int seconds;

    public Time(String stime) throws InvalidTime {
        int[] masTime = new int[3];
        int i = 0;
        for (String retval : stime.split(":")) {
            masTime[i++] = Integer.parseInt(retval);

        }
        hours = masTime[0];

        if (hours > 100 || minutes > 60 || seconds > 60) {
            throw new InvalidTime(stime);

        }
        minutes = masTime[1];
        seconds = masTime[2];

    }

    @Override
    public String toString() {
        return "Time{" +
                "hours=" + hours +
                ", minutes=" + minutes +
                ", seconds=" + seconds +
                '}';
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

}
