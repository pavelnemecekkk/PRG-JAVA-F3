package FileWorks;

import java.io.*;
import java.util.HashSet;

public class ExamplesOfFireworks {
    public static void main(String[] args) throws IOException {

        PrintWriter evenFile = new PrintWriter(new BufferedWriter(new FileWriter(("data\\EvenFile.txt"))));
        File data = new File("data");
        if (data.isDirectory()){
            File[] files = data.listFiles();
            if (data.listFiles() != null){
            String line;
            for(File file : files){
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                while ((line = bufferedReader.readLine()) != null){
                    if (Integer.parseInt(line) % 2 == 0){
                        evenFile.println(line);
                    }
                }
                bufferedReader.close();
            }
        }
        }
        evenFile.close();



    }
}
