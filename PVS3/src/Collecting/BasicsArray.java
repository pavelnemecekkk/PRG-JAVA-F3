package Collecting;


import java.util.Arrays;

public class BasicsArray {

    public static void main(String[] args) {
        //staticky
        int[] numbers = {5,3,4};
        // pouze deklarace
        int[] numburs2 = new int[10];
        //itarace
        for (int i = 0; i < numburs2.length; i++) {
            numburs2[i] = (int) (Math.random() * 100);
        }
        numbers = numburs2;
        // {5,3,4}; sezere garbage collector, numbers ukazuje na numburs2;

        // Vezme to hodnoty numburs, zkopíruje se na prvních 10 indexu, zbylých 5 bude "0"
        // Není to same jako pole = takypole, není to reference
        int [] yetAnotherNumbers = Arrays.copyOf(numburs2, 15);

        yetAnotherNumbers[5] = 20;
        numbers [5] = 30;
        numburs2 [5] = 40;

        //int[] je primitivní, pro výpis musím vyvolat knihovnu, nemá žadné metody
        System.out.println(Arrays.toString(yetAnotherNumbers));

        //jednoducha ukazka rezeni
        Arrays.sort(yetAnotherNumbers); //Použije quicksort
        System.out.println(Arrays.toString(yetAnotherNumbers));
    }
}
