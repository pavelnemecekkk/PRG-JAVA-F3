package Dědičnost;

import fileworks.DataExport;
import fileworks.DataImport;

import java.util.ArrayList;

public class Hospital {
    public static void main(String[] args) {

        DataImport di = new DataImport("procedures.txt");
        DataExport de = new DataExport("report.txt");;
        doktori toRead;
        ArrayList<doktori> lekar = new ArrayList<>();


        while (di.hasNext()) {
          String  line = di.readLine();
         String[]  atributes = line.split(",");
         ArrayList<String> sub = new ArrayList<>();
            for (int i = 2; i < line.split(",").length; i++) {
                sub.add(atributes[i]);
            }
            lekar.add(new doktori(atributes[0], atributes[1], sub));
        }

        System.out.println(lekar);
        di.finishImport();
        de.finishExport();
    }


    static void action(doktori tester){
        switch (tester.sub){
            case"D":
                tester.;
            case "S":;
            case "C":;
        }
    }





        static class doktori extends CardioSurgeon {
            String name;
            String work;
            ArrayList<String> sub;

            public doktori(String name, String work, ArrayList<String> sub) {
                super(salary, name);
                this.name = name;
                this.work = work;
                this.sub = sub;
            }
            @Override
            public String toString() {
                return "doktori{" +
                        "name='" + name + '\'' +
                        ", work='" + work + '\'' +
                        ", sub=" + sub +
                        '}';
            }


        }

}
