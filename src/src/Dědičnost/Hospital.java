package Dědičnost;

public class Hospital {
    public static void main(String[] args) {

        Doctor Carl = new Doctor(50000, "Carl");
        System.out.println(Carl.name + " " + Carl.getSalary());
        Carl.diagnose();
        Carl.diagnose();
        System.out.println(Carl.name + ": " + Carl.getSalary());
        Surgeon joseph = new Surgeon(50000, "Joseph");
        System.out.println(joseph.name + ": " + joseph.getSalary());
        joseph.Surgery();
        joseph.diagnose();
        System.out.println(joseph.name + ": " + joseph.getSalary());
        CardioSurgeon frenchie = new CardioSurgeon(50000, "Frenchie");
        System.out.println(frenchie.name + ": " + frenchie.getSalary());
        frenchie.diagnose();
        frenchie.Surgery();
        frenchie.cardiacSurgery();
        System.out.println(frenchie.name + ": " + frenchie.getSalary());

        Doctor jarmil = new Surgeon(50000, "Jarmil"); // Spustí Konstruktor Surgeon, ale neumí metody jako Surgeon

        // Varianta 1, přetypovat a hodid do proměné
//        Surgeon temp = (Surgeon) jarmil;
        //varianta 2, rovnou volat na pretypovanou promenout
//        ((Surgeon)jarmil).Surgery();
        Doctor[] doctors = {Carl, joseph, frenchie, jarmil};
        //vsichni zkusí operaci
        for (Doctor doctor : doctors) {
            //pokus se o operaci
            System.out.println("Provádí operaci: " + doctor.name);
            if (doctor instanceof Surgeon) {
                ((Surgeon) doctor).Surgery();
            } else {
                System.out.println("Tenhle doktor " + doctor.name + " to neumí");
            }
        }


    }
}
