package OOP.collections;

import java.util.*;

public class Setting {
    public static void main(String[] args) {
        int[] arrray = new int[100];

        for (int i = 0; i < arrray.length; i++) {
            arrray[i] = (int) (Math.random() * 121);
        }

        System.out.println(Arrays.toString(arrray));

        Set<Integer> uniqueNumbers = new HashSet<>();

        uniqueNumbers.add(5);
        uniqueNumbers.add(5);
        uniqueNumbers.add(5);
        uniqueNumbers.add(5);
        System.out.println();
        System.out.println(uniqueNumbers);

        // vygeneruj 100 unikátních čísel
        while (uniqueNumbers.size() < 100){
            uniqueNumbers.add((int) (Math.random() * 121));
        }
        System.out.println(uniqueNumbers);

        // je něco v množině
        // a)
        System.out.println(uniqueNumbers.contains(6));

        //b), zkus to tam přidat, pokud to tam je -> vrať boolean false
        System.out.println(uniqueNumbers.add(6));
        System.out.println();
        System.out.println(uniqueNumbers);


        // Kolekce jsou na sebe prohoditelný
        ArrayList<Integer> trulyUniqueNumbers = new ArrayList<>(uniqueNumbers);
        System.out.println(trulyUniqueNumbers);

        ArrayList<Integer> arrayList = new ArrayList<>();

        while (arrayList.size() < 100){
            arrayList.add((int) (Math.random() * 200));
        }
        System.out.println();
        System.out.println(arrayList);
        System.out.println();

        Set<Integer> quest = new HashSet<>(arrayList);
        System.out.println(quest);

        //kolik je tam unikatnich čisel
        System.out.println(quest.size());

        //kolikrat tam nebyli unikatní čísla
        System.out.println(arrayList.size() - quest.size());


    }
}
