import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TEST_READING {
    final static Comparator<File> BY_SIZE = new Comparator<File>() {

        @Override
        public int compare(File o1, File o2) {
            return Long.compare(o1.length(), o2.length());
        }
    };

    static void printSortedFiles(ArrayList<File> files) {
        files.sort(BY_SIZE);
        for (File f : files) {
            System.out.println(f + ": " + f.length());
        }
    }

    public static void main(String[] args) throws IOException {
        String path = "testData";
        File folder = new File("src\\src\\testData");
        if (folder.isDirectory()) {
            System.out.println("Jedná se o složku");
            File[] files = folder.listFiles();
            ArrayList<File> Filearraylist = new ArrayList<>();
            System.out.println(Arrays.toString(files));
            for (File file : files) {
                if (file.toString().contains(".txt")) {
                    Filearraylist.add(file);
                }
            }
            printSortedFiles(Filearraylist);

            String line;
            BufferedReader toRead;

            ArrayList<String> sss = new ArrayList<>();
            for (int i = 0; i < Filearraylist.size(); i++) {
                toRead = new BufferedReader(new FileReader(new File(String.valueOf(Filearraylist.get(i)))));
                line = toRead.readLine();
                System.out.println(line);
                sss.add(line);
            }
            System.out.println(sss);
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("basnicka.txt")));
            for (int i = 0; i < sss.size(); i++) {
                bw.write(sss.get(i));
            }
            bw.close();


        } else {
            System.out.println("Nejedná se o složku");
        }
    }
}

