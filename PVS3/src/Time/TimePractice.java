package Time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class TimePractice {
    public static void main(String[] args) {
        // LocalTime je statický objekt, nemá konstruktor, dá se vytahnout jedna informace v daný moment
        LocalTime time = LocalTime.now();
        System.out.println(time);

        // Čas, který si sám zadám
        LocalTime lessonStart = LocalTime.of(9,50);
        System.out.println(lessonStart);

        // Není to časový interval, vezme do čas. format a převedo na hh:mm:ss
        LocalTime from = LocalTime.from(lessonStart);
        System.out.println(from);

        // Konstanta na poledne
        LocalTime constants = LocalTime.NOON;
        System.out.println(constants);

        /*lessonStart.get
        * drapnutí si nějakého času*/
        // Kolik odběhlo času
        // Na sekundy
        System.out.println(time.toSecondOfDay() - lessonStart.toSecondOfDay());
        // Lepší výpis i s konvertem
        System.out.println(time.minusSeconds(lessonStart.toSecondOfDay()));

        // Dvě věci mezi
        System.out.println(Duration.between(from, time));

        LocalDate date = LocalDate.now();

        // Year, month, day
        System.out.println(date);

        // Nějaký začátek
        System.out.println(LocalDate.EPOCH);
        
    }
}
