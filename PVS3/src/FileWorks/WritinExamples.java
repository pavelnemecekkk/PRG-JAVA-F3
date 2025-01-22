package FileWorks;

import fileworks.DataExport;

import java.io.*;
import java.util.Arrays;

public class WritinExamples {

    public WritinExamples() {
    }

    public static void main(String[] args) throws IOException {
        DataExport de = new DataExport("data\\output0.txt");
        for (int i = 0; i < 1000; i++) {
            de.writeLine(String.valueOf((int) (Math.random() *50001)));
        }
        de.finishExport();

        //Scanner - nemá write variantu
        FileWriter fw = new FileWriter("data\\output2.txt");

        // po znacích
        for (int i = 0; i < 1000; i++) {
            fw.write(String.valueOf((int) (Math.random() *50001)));
//            fw.write(((int) (Math.random() *50001))); , převede to na znaky UTF-16
            fw.write('\n');
        }
        fw.close();

        //po řádcích
        BufferedWriter bw = new BufferedWriter(new FileWriter("data\\output3.txt"));
        for (int i = 0; i < 1000; i++) {
            bw.write(String.valueOf((int) (Math.random() *50001)));
            bw.newLine();
        }
        bw.flush(); // Vezme to obsah buffer a dá je do souboru
        bw.close();

        //výstup s formátem

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("data\\output4.txt")));
        for (int i = 0; i < 1000; i++) {
            pw.println(String.valueOf((int) (Math.random() *50001))); // Chce většinou stringy
        }
        pw.close();

        String text  = "neco";
        System.out.println(text);
        System.out.println(Arrays.toString(text.getBytes()));





    }





}
