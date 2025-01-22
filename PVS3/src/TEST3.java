import fileworks.DataImport;

import java.util.*;

public class TEST3 {

    public static Set<Cities> toLoad (String nameofFile){
        Set<Cities> cities = new HashSet<>();
        DataImport di = new DataImport(nameofFile);
        String line;
        String[] atributes;
        while (di.hasNext()){
            line = di.readLine();
            atributes = line.split(",");

            cities.add(new Cities(atributes[0], atributes[1], atributes[2]));
        }
        di.finishImport();
        System.out.println(cities.size());
        return cities;
    }


    public static void printCites(String country){


    }



    public static void main(String[] args) {
        Set<Cities> cities = toLoad("Cities.txt");
        ArrayList<Cities> arrayCity = new ArrayList<>(cities);
//        System.out.println(cities);
//        System.out.println(arrayCity.size());
//        System.out.println(cities.size());
//        System.out.println(arrayCity);
        System.out.println();
        arrayCity.sort(Cities.BY_CONTINENT);
        System.out.println(arrayCity);
        System.out.println();
        System.out.println("--------");
        printCites("Canada");

        Set<String> citiesToCount = new HashSet<>();

        for (int i = 0; i < cities.size(); i++) {

        }

        System.out.println(cities.size());

        }
        }



class Cities{
    String Cityname;
    String State;
    String Continent;

    static final Comparator<Cities> BY_CONTINENT = new Comparator<Cities>() {
        @Override
        public int compare(Cities o1, Cities o2) {
            return o1.Continent.compareTo(o2.Continent);
        }
    };

    public Cities(String cityname, String state, String continent) {
        Cityname = cityname;
        State = state;
        Continent = continent;
    }

    @Override
    public String toString() {
        return "\n" + "City name: " + Cityname + " state: " + State + " continent: " + Continent;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cities cities = (Cities) o;
        return Cityname.equals(cities.Cityname);
    }

    @Override
    public int hashCode() {
        return Cityname.hashCode();
    }
}
