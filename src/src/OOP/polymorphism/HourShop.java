package OOP.polymorphism;

public class HourShop{

    static  void callPrint(Clock c){
        c.printTime();
    }
    public static void main(String[] args) {

        HourClock hourClock = new HourClock();
        hourClock.seconds = 7700;
        hourClock.printTime();
        Timer timer = new Timer();
        timer.second = 550;
        timer.printTime();

        Clock[] clocks = {timer,hourClock};
    }
}
//Co dokážu volat za metodu, bez předem určerní metod, Interface můžeme implementovat několikrat kolikrat chceme
class HourClock implements Clock{

    int seconds;
    @Override
    public void printTime() {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;
        System.out.println(hours +":" + minutes + ":" + secs);
    }
    @Override
    public int getTIme() {
        return seconds;
    }
}

class Timer implements Clock{

    int second;
    @Override
    public void printTime(){
        System.out.println((second/60) + ":" + (second%60));

    }

    @Override
    public int getTIme() {
        return second;
    }
}
