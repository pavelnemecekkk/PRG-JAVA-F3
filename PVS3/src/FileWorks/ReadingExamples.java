package FileWorks;

import fileworks.DataImport;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ReadingExamples {

    public static void main(String[] args) throws IOException {
        File file = new File("countries.txt");
        if (file.exists() && file.isFile()){
            DataImport di = new DataImport(file.getPath());
            while (di.hasNext()){
                System.out.println(di.readLine());
            }
            di.finishImport();
        }


        System.out.println("----------------");
        System.out.println("----------------");
        System.out.println("----------------");
        System.out.println("----------------");
        System.out.println("----------------");

        Scanner sc = new Scanner("hello, world, beutifull, day");
        sc.useDelimiter(","); // Vysplitování scanneru, podle něčeho
        sc.useLocale(Locale.CANADA); // Lokální nastavení státu

        FileReader reader = new FileReader(file);
        int input;
        while ((input = reader.read()) != -1){
            System.out.print((char) input); // Převedení do UTF-16
        }
        reader.close();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
        bufferedReader.close();
        List<String> lines = Files.readAllLines(Paths.get("countries.txt"));
        System.out.println(lines);
        System.out.println(lines.size());
//        for(String oneLine : lines ){
//          // parse
//        }


    }
}