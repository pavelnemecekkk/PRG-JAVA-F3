package OOP.basics;

import fileworks.DataImport;

import java.lang.reflect.Array;
import java.util.ArrayList;
public class CountryReading {

    static double ageAvarage(ArrayList<Country> countries){
        double totalSum = 0;
        for (Country country : countries){
            totalSum += country.expetedAge;
        }
        return totalSum / countries.size();
    }

    static int amountInContinent(ArrayList<Country> countries, String Continent){
        int counter = 0;
        for(Country country : countries){
            if (country.Continent.equals(Continent)){
                counter++;
            }
        }
        return counter;
    }

    static Country mostPopulated(ArrayList<Country> countries){
        Country c = countries.get(0);
        for ( Country country : countries){
            if(country.area > c.area){
                c = country;
            }
        }
        return  c;
    }

    public static void main(String[] args) {
        // TODO: Počet zemí v Evropě
        // TODO: Největší země
        // TODO: spočítat průměr věku dožítí, Metoda ageAvarage(countries)
        DataImport di = new DataImport("countries.txt");
            String line;
            String[] atributes;
            Country toRead;

        ArrayList<Country> countries = new ArrayList<>();
            while (di.hasNext()){
                line= di.readLine();
                atributes = line.split(";");
                toRead = new Country(atributes[0],
                                     atributes[1],
                                     Integer.parseInt(atributes[2]),
                                     Double.parseDouble(atributes[3])
                );
                countries.add(toRead);
            }

        System.out.println(ageAvarage(countries));
        System.out.println(amountInContinent(countries,"Europe"));
        System.out.println(mostPopulated(countries));
        di.finishImport();
    }
}

class Country{

    @Override
    public String toString() {
        return "Country{" + "name='" + name + '\'' + ", Continent='" + Continent + '\'' + ", area=" + area + ", expetedAge=" + expetedAge + '}';
    }
    String name;
    String Continent;
    int area;
    double expetedAge;
    public Country(String name, String continent, int area, double expetedAge) {
        this.name = name;
        Continent = continent;
        this.area = area;
        this.expetedAge = expetedAge;
    }
}
