package OOP.polymorphism;

import fileworks.DataImport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CountrySorting {
    static ArrayList<Country> loadData(String filePath) {
        ArrayList<Country> countries = new ArrayList<>();
        DataImport di = new DataImport(filePath);
        String line;
        String[] atributes;
        while (di.hasNext()) {
            line = di.readLine();
            atributes = line.split(";");
            countries.add(new Country(atributes[0],
                    atributes[1],
                    Integer.parseInt(atributes[2]),
                    Double.parseDouble(atributes[3])));
        }
        di.finishImport();
        return countries;
    }

    public static void main(String[] args) {
       ArrayList<Country> countries = new ArrayList<>(loadData("countries.txt"));
        Collections.sort(countries);
        System.out.println(countries);
        Collections.sort(countries, new CountryComparator());
        System.out.println(countries);

//        Comparator<Country> lifeCompare = new Comparator<Country>() {
//            @Override
//            public int compare(Country o1, Country o2) {
//                return Double.compare(o1.lifeExpectancy,o2.lifeExpectancy);
//            }
//        };
//        countries.sort(lifeCompare);
//        System.out.println(countries);

        countries.sort(Country.BY_NAME);
        System.out.println(countries);
        countries.sort(Country.BY_NAME.reversed()); // Pozpátku

    }
}

class Country implements Comparable<Country> {
    String name, continent;
    int population;
    double lifeExpectancy;
    static final Comparator<Country> BY_NAME = new Comparator<Country>() {
        @Override
        public int compare(Country o1, Country o2) {
            return o1.name.compareTo(o2.name);
        }
    } ;

    public Country(String name, String continent, int population, double lifeExpectancy) {
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
    }

    @Override
    public String toString() {
        return "\n name: " + name + " continent: " + continent + " population: " + population + " lifeExpectancy:  " + lifeExpectancy;
    }


    // Přirozené řazení
    @Override
    public int compareTo(Country o) {
        return Integer.compare(this.population,o.population);
    }

    // Absolutní řazení
//    @Override
//    public int compare(Country o1, Country o2) {
//        return 0;
//    }
}

class CountryComparator implements Comparator<Country>{


    @Override
    public int compare(Country o1, Country o2) {
        return o1.name.compareTo(o2.name);
    }
}
