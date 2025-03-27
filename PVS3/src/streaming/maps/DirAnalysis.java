package streaming.maps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DirAnalysis {

    public static void analyzeDir(String path) throws IOException {
        Path p = Paths.get(path);

        try (Stream<Path> fileStream = Files.walk(p)){
//            fileStream.forEach(System.out::println);
            List<Path> filePaths = fileStream.
                    filter(Files::isRegularFile)
                    .toList();
            System.out.println(filePaths);

            Map<String, Long> filesTypeCount = filePaths.stream()
                    .collect(Collectors.groupingBy(
                            filePath -> getExtension(filePath.getFileName().toString())
                            ,
                            Collectors.counting() // počet souborů v groupě
                    ));
            //fuj vypis
            System.out.println(filesTypeCount);
            // lepši vypis
            filesTypeCount.forEach((string, aLong) -> System.out.println("Type: " + string + " count: " + aLong ));

            // velikost všech souboru dle typu

            Map<String, Long> fileTypeSizeTotal = filePaths.stream()
                    .collect(Collectors.groupingBy(
                            filePath -> getExtension(filePath.getFileName().toString())
                            , Collectors.summingLong(p1 -> { // bude součet souboru
                                try{
                                    return Files.size(p1); // vrat velikost
                                } catch (IOException e){
                                    return 0L;
                                }
                                }
                             )
                            ));

            fileTypeSizeTotal.forEach((string, aLong) -> System.out.println(string + " : " + aLong + " size"));
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    static String getExtension(String fileName){
        int dotIndex = fileName.lastIndexOf(".");
        return (dotIndex == -1 ) ? "No_Type" : fileName.substring((dotIndex+1)).toLowerCase();
    }
    public static void main(String[] args) {
        try {
            analyzeDir("testData");
        } catch (IOException e) {
            System.out.println("Zpracovaní souboru se nepodařilo " + e.getMessage());
        }
    }
}
