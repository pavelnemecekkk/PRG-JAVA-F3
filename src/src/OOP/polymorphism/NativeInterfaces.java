package OOP.polymorphism;


import java.util.ArrayList;
import java.util.Collections;

public class NativeInterfaces {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Carl", 25, 44.3));
        persons.add(new Person("Old Carl", 99, 39.6));
        persons.add(new Person("Jarmil", 19, 40.3));
        persons.add(new Person("Radim", 33, 50.3));

        System.out.println(persons);
        Collections.sort(persons);
        System.out.println("Sort by Age");
        System.out.println(persons);
    }
}

// Comperable => Porovnatelný, může se objevovat pouze jednou
// Comperator =>
class Person implements Comparable<Person>{
    String name;
    int age;
    double shoeSize;
    public Person(String name, int age, double shoeSize) {
        this.name = name;
        this.age = age;
        this.shoeSize = shoeSize;
    }

    @Override
    public String toString() {
        return  '\n' +"Name :" + name + ", Age: " + age + ", Shoe Size: " + shoeSize ;
    }



    // Pokud je záporny výsledek tak b > a
    // Pokud je kladny výsledek tak a > b
    // Pokud je nula a = b

    // Vrací Int, řešíme podle int
//    @Override
//    public int compareTo(Person o) {
//        return this.age - o.age;
//    }

    // Vrací int, řešíme podle double
/*    @Override
    public int compareTo(Person o) {
        return (int) (this.shoeSize - o.shoeSize);
    } */

// Vrací int, řešíme podle String
    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }
}
