package Opakování;

import fileworks.DataExport;
import fileworks.DataImport;

public class FileBasics {
    public static void main(String[] args) {
        DataImport di = new DataImport("inputs.txt");
        DataExport de = new DataExport("Resutls.txt");
        // di.printFile();
        String Line;
//        System.out.println(FirstLine);
        while (di.hasNext()){
            Line = di.readLine();
            String[] params;
            int a,b;
            System.out.println(Line);
            params = Line.split(",");
            a = Integer.parseInt(params[0]);
//            a = (int)params[0] // Nebude fungovat
            b = Integer.parseInt(params[1]); // Integer.parseInt Převedení do Integeru

            switch (params[2]){
                case "A":
                    de.writeLine(String.valueOf(a+b)); break; // valueOf Převedení do Stringu
                case "S":
                    de.writeLine(String.valueOf(a-b)); break;
                case "M":
                    de.writeLine(String.valueOf(a*b)); break;
                case "D":
                    de.writeLine(String.valueOf(a/b)); break;
            }

        }
        di.finishImport();
        de.finishExport();
    }
}
