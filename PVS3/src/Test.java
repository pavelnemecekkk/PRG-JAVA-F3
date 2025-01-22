import fileworks.DataImport;
// Nejlešpí film
// Průměr ratingu filmu
import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Test {

    static double AvarageRating(ArrayList<Film> films){
        double pom = 0;
        for(Film film : films){
            pom += film.rating;
        }
        return pom / films.size();
    }

    static Film TopRating(ArrayList<Film> films){
        Film d = films.get(0);
        for(Film film : films){
            if (film.rating > d.rating){
                d = film;
            }
        }
        return d;
    }



    public static void main(String[] args) {
        DataImport di = new DataImport("Movies.txt");
        String line;
        String[] atributes;
        Film toRead;
        ArrayList<Film> films = new ArrayList<>();

        while(di.hasNext()){
            line = di.readLine();
            atributes = line.split(";");
            toRead = new Film(atributes[0],
                                Integer.parseInt(atributes[1]),
                                Double.parseDouble(atributes[2]),
                                Integer.parseInt(atributes[3]));
            films.add(toRead);
        }
        System.out.println(AvarageRating(films));
        System.out.println(TopRating(films));

        System.out.println(films);
        di.finishImport();
    }
}


class Film{
    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                ", longinsecond=" + longinsecond +
                '}';
    }

    String name;
    int year;
    double rating;
    int longinsecond;

    public Film(String name, int year, double rating, int longinsecond) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.longinsecond = longinsecond;
    }
}
