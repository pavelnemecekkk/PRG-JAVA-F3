package OOP.basics;

import fileworks.DataImport;

public class PersonReading {
    public void main(String[] args) {

        DataImport di = new DataImport("osoba.txt");
        String line;
        String[] atributes;
        Person p;
        Person talles = new Person("TMPerson", Integer.MIN_VALUE, 0,0);
        while (di.hasNext()){
          line = di.readLine();
           atributes = line.split(",");

           p = new Person(
                   atributes[0],
                   Integer.parseInt(atributes[1]),
                   Integer.parseInt(atributes[2]),
                   Integer.parseInt(atributes[3])
           );
        }
        di.finishImport();
    }
    class Person{


        String fullname;
        int height, weight, age;

        public Person(String fullname, int height, int weight, int age) {
            this.fullname = fullname;
            this.height = height;
            this.weight = weight;
            this.age = age;
        }
        @Override
        public String toString() {
            return fullname + " h = " +
                    " height= " + height +
                    " weight= " + weight +
                    " age= " + age +
                    '}';
        }
    }
}
