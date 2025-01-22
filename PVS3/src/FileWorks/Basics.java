package FileWorks;

import java.io.File;
import java.util.Arrays;

public class Basics {


    static void tree(String filepath){
        File f = new File(filepath);
        if (f.exists()){
            if (f.isDirectory()){
                System.out.println(f.getPath());
                File[] files = f.listFiles();
                for (File file :files){
                    tree(file.getPath());
                }
            } else {
                System.out.println(f.getPath());
            }
        } else {
            System.out.println("Wrong tree call");
        }
    }

    public static void main(String[] args) {

        // File nám dává systemové info o tom
        File file = new File("Cities.txt"); // relativní cesta
        File fileAbsolut = new File("C:\\Users\\pavel.nemecek\\Desktop\\pepazdepa.txt"); // Absolutní cesta
        File folder = new File("src\\src\\FileWorks"); // čte i složky

        System.out.println(file.getPath());
        System.out.println(fileAbsolut.getPath());
        System.out.println(fileAbsolut.getAbsoluteFile());
        System.out.println(fileAbsolut.getName()); // Jméno složky

        System.out.println(file.isFile()); // Je soubor


        System.out.println("Velikost: " + file.length() ); // V Bajtech velikost souboru
        System.out.println("Velikost: (kB)" + ( (double) file.length() /1000));

        System.out.println("Existuje? " + file.exists());
        //file.createNewFile() Vytvoření souboru
        //file.renameTo() Přesunout
        System.out.println(file.getParent()); // Není žádný, jelikož není v složce, tedy nikdo není nad ním

        System.out.println(folder.getPath());
        System.out.println(folder.isDirectory()); // Je složka
        System.out.println(Arrays.toString(folder.list())); // Vypiš obsah složky
        System.out.println(Arrays.toString(folder.listFiles())); // Vypiš obsah složky

    }
}
