package FileWorks;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PracticeForTest {
    public static void main(String[] args) throws IOException {
        //Vygeneruj  souboru plných náhodných čísel
        //path, lines(5000000), (-10000, 10000)
        String filepath = "task.txt";
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(filepath))));
        for (int i = 0; i < 500000; i++) {
            pw.println((int) (Math.random() * 20001 - 10000));
        }
        pw.close();
        //přijde soubor, spočítat řádky
        List<String> lines = Files.readAllLines(Paths.get(filepath));
        System.out.println(lines.size());

        //Jaká řádky mají kladné čísla

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (Integer.parseInt(line) > 0 ){
                System.out.println("Line:" + (i+1) +", Value: " + line);
            }

            long a = 500_000_000_000_000L;
        }
    }
}
