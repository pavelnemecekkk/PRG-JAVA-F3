package OOP.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Listing {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
//        LinkedList<Integer> alsoNumbers = new LinkedList<>(); // Drží si start a end, start aby věděl odkud to číst, end aby věděl, kde končí a mohl přidavat jiné prvky
        numbers.add(3);
        System.out.println(numbers);
        ArrayList<Integer> stillNumbers = new ArrayList<>();
        stillNumbers.add(5);
        stillNumbers.add(42);
        stillNumbers.add(50);
        stillNumbers.add(100);
        // Najekej index padne
        stillNumbers.add(108);
        // Nakopíruj jiný ArrayList a přidej ho za start
        numbers.addAll(stillNumbers);
        System.out.println(numbers);

        //problemetické s intigerem, můžeme pouze s indexem
        numbers.remove(5);
        ArrayList<Integer> yetStillNumbers = new ArrayList<>();

        // Odstraň čísla, které jsou 100
        yetStillNumbers.add(100);
        numbers.removeAll(yetStillNumbers);

        System.out.println(numbers);
        ArrayList<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("World");

        // Najdi tohle a smaž to z listu
        words.remove("World");
        // Smaž na indexu
        words.remove(0);

        System.out.println(numbers.get(3));

        // Ověř jestli je to tam je
        System.out.println(numbers.contains(6));

        // Zjisti na jakej indexu je tohle číslo
        System.out.println(numbers.indexOf(6));

        // Jestli to tam je jenom jednou nebo vůbec
        System.out.println(numbers.lastIndexOf(12));

        // Vytvoř nakopíruj jiný Arraylist

//        Integer[] simpleNUmbers = numbers.toArray(); nefunugje
//        String[] simpleWords = (String[]) words.toArray(); musím přetypovat
        numbers.trimToSize(); //Sníží zbytečný prostor, vola se automaticky
        numbers.add(4,25); // Přídám na index 4 a co
        System.out.println(numbers);
//       numbers.stream().filter(e -> e >10).count();
        // filter => podmínky
        // stream => dokáže to číst na bity, bajty // Tok dat
    }
}
