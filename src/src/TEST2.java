import OOP.polymorphism.Movie;
import fileworks.DataImport;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class TEST2 {

    public static ArrayList<Movies> toLoad (String nameOfFile){
        ArrayList <Movies> movies = new ArrayList<>();
        DataImport di = new DataImport(nameOfFile);
        String line;
        String [] atributes;
        while (di.hasNext()){
            line = di.readLine();
            atributes = line.split(";");
            movies.add(new Movies(atributes[0], Integer.parseInt(atributes[1]),Double.parseDouble(atributes[2]), Integer.parseInt(atributes[3])));
        }
        return movies;
    }

    public static void top10Rating(ArrayList<Movies> movies){
        movies.sort(Movies.BY_RATING.reversed());
        for (int i = 10; i > 0; i--) {
            System.out.println(movies.get(i));
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pom = sc.nextLine();
      ArrayList<Movies> movies = toLoad("Movies.txt");
        System.out.println(movies);
        movies.sort(Movies.BY_YEAR.reversed());
        top10Rating(movies);
        if (pom == "reverse") {
        switch (sc.nextLine()){
                case "name":  movies.sort(Movies.BY_NAME.reversed());break;
                case "year":  movies.sort(Movies.BY_YEAR.reversed());break;
                case "rating": movies.sort(Movies.BY_RATING.reversed());break;
                case "length": movies.sort(Movies.BY_LENGTH.reversed());break;
            }
        } else {
            switch (sc.nextLine()){
                case "name":  movies.sort(Movies.BY_NAME);break;
                case "year":  movies.sort(Movies.BY_YEAR);break;
                case "rating": movies.sort(Movies.BY_RATING);break;
                case "length": movies.sort(Movies.BY_LENGTH);break;
        }
    }
}

class Movies {
    String name;
    int year;
    double rating;
    int lengthInSeconds;
   static final Comparator<Movies> BY_NAME = new Comparator<Movies>() {
       @Override
       public int compare(Movies o1, Movies o2) {
           return o1.name.compareTo(o2.name);
       }
   };
    static final Comparator<Movies> BY_YEAR  = new Comparator<Movies>() {
        @Override
        public int compare(Movies o1, Movies o2) {
            return Integer.compare(o1.year, o2.year);
        }
    };

    static final Comparator<Movies> BY_RATING = new Comparator<Movies>() {
        @Override
        public int compare(Movies o1, Movies o2) {
            return Double.compare(o1.rating, o2.rating);
        }
    };
    static final Comparator<Movies> BY_LENGTH = new Comparator<Movies>() {
        @Override
        public int compare(Movies o1, Movies o2) {
            return Integer.compare(o1.lengthInSeconds, o2.lengthInSeconds);
        }
    };


    @Override
    public String toString() {
        return "\n" + name + " " + year + " " + rating + " " + lengthInSeconds;
    }

    public Movies(String name, int year, double rating, int lengthInSeconds) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.lengthInSeconds = lengthInSeconds;
    }
}
