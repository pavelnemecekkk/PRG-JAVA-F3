package streaming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Basics {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add((int) (Math.random()*100));
        }
        System.out.println(numbers);

        System.out.println("Size: " + numbers.size());
        int size = (int) numbers.stream()
                .count();

        // distinct => unikátní čísla
        int uniques = (int) numbers.stream()
                .distinct()
                .count();

        System.out.println("Unikátních čísel: " +uniques);

        int uniquesHigherThan50 = (int) numbers.stream()
                .distinct()
                .filter(num -> num > 50)
                .count();

        System.out.println(uniquesHigherThan50);

        numbers.stream()
                .filter(num -> num % 2 == 0)
                .forEach(System.out::println);

        numbers.stream()
                .sorted((n1, n2) -> n1 - n2)
                .forEach(System.out::println);

        String[] names = {"Řehoř", "Anastasia", "Ludmila", "Jarmil", "Jonáš"};
        Stream.of(names)
                .sorted((o1, o2) -> o1.length() - o2.length())
                .forEach(System.out::println);

        double avg = numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0);

        System.out.println(avg);

    }
}
