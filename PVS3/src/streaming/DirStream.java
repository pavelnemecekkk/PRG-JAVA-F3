package streaming;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirStream {
    public static void main(String[] args) {
        // znamy zpusob čtení složky
        /*File[] files = new File("cesta").listFiles();*/
        // Cesta
        Path start = Paths.get("testData");
        //Vrací stream cest
        // try with resources, pokud se něco pokazí, automaticky se zavře, můžu tu danou věc použít jenom jednou
        try(Stream<Path> filesStream = Files.walk(start)) {

/*            filesStream.forEach(System.out::println);*/
/*            long count = filesStream
                    .filter(p -> p.endsWith(".java"))
                    .count();
            System.out.println("Java files: " + count);*/



        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
