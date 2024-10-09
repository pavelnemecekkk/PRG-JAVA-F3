package Dědičnost;

public class Doctor {
    int salary;

    String name;



    public Doctor(int salary, String name) {
        this.salary = salary;
        this.name = name;
    }



    public int getSalary() {
        return salary;
    }

    void diagnose(){
        System.out.println("Figuring out what's wrong...");
        salary += 1000;
    }

}
