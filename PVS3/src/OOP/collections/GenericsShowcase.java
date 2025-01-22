package OOP.collections;

public class GenericsShowcase {
    public static <T> void printArray(T[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] num = {1, 6, 5, 98, 53, 0, 512};
        String[] word = {"delta, alpha, beta, gamma"};
        Double[] rnum = {Math.PI, -Math.sqrt(17), .5, 4.0};

        printArray(num);
        printArray(word);
        printArray(rnum);
    }
}

