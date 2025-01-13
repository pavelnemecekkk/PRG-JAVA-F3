import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TEST_READING {
    public static void main(String[] args) throws IOException {
        String path = "testData";
        File folder = new File("src\\src\\testData");
        if (folder.isDirectory()){
            System.out.println("Jedná se o složku");
            File[] files = folder.listFiles();
            System.out.println(files);
            ArrayList<String> arrayFile = new ArrayList<>();
            ArrayList<String> arrayFile2 = new ArrayList<>();
            System.out.println(Arrays.toString(files));
            for(File file : files){
                arrayFile.add(file.toString());
            }
            for (int i = 0; i <arrayFile.size() ; i++) {
                if (arrayFile.get(i).contains(".txt")){
                    arrayFile2.add(arrayFile.get(i));
                }
            }
            System.out.println(arrayFile2);
            ArrayList sss = new ArrayList();
            String line;


            for (int i = 0; i < arrayFile2.size() ; i++) {
               BufferedReader toRead = new BufferedReader(new FileReader(new File(arrayFile2.get(i))));
                line = toRead.readLine();
                System.out.println(line);
                sss.add(line);
            }
            System.out.println(sss);
        }
        else{
            System.out.println("nejedná se o složku, zadej jinou cestu");
        }
    }
}
