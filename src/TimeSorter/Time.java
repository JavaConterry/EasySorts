package TimeSorter;

import java.util.List;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        if(hours >= 0 && minutes >= 0 && seconds >= 0) {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
            this.normalizeTime();
        }else{
            System.out.println("setting time is unavailable for these values");
        }
    }


    private void normalizeTime() {
        if(this.seconds>=60){
            int rez = this.seconds/60;
            this.seconds %= 60;
            this.minutes += rez;
        }
        if(this.minutes>=60){
            int rez = this.minutes/60;
            this.minutes %= 60;
            this.hours += rez;
        }
        if(this.hours>=24){
            this.hours %= 24;
        }
    }

    public static List<Time> sort(List<Time> timeList) {
        // bubble sorting
        int n = timeList.size()-1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(timeList.get(j).biggerOrEqualThan(timeList.get(j+1))){
                    var temp = timeList.get(j);
                    timeList.set(j, timeList.get(j+1));
                    timeList.set(j+1, temp);
                }
            }
        }
        return timeList;
    }

    private boolean biggerOrEqualThan(Time anotherTime){
        if(this.hours >= anotherTime.hours){
            return true;
        }
        else if(this.hours == anotherTime.hours && this.minutes >= anotherTime.minutes){
            return true;
        }
        else if(this.hours == anotherTime.hours && this.minutes == anotherTime.minutes && this.seconds >= anotherTime.seconds){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString(){
        String result = this.hours + " " + this.minutes + " " + this.seconds;
        return result;
    }
}