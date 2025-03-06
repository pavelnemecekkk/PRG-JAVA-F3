package Lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MovieLambda {

    public static void main(String[] args) {
        ArrayList<Movie> movies = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get("movieList.txt"));
            String[] paramas;
            for(String line : lines){
                paramas = line.split(";");
                movies.add(new Movie(
                                paramas[0],
                                Integer.parseInt(paramas[1]),
                                paramas[2],
                                Double.parseDouble(paramas[3])));
            }

            movies.stream()
                    .filter(movie -> movie.getYear() > 2000)
                    .forEach(System.out::println);

            System.out.println("------------------");
            movies.stream()
                    .sorted(Comparator.comparingDouble(Movie::getRating).reversed())
                    .forEach(System.out::println);
            System.out.println("------------------");

           double avg = movies.stream()
                    .filter(movie -> movie.genre.equals("Horror"))
                    .distinct()
                    .mapToDouble(movie -> movie.rating)
                    .average()
                    .orElse(0);
            System.out.println(avg);

            List<Movie> actionMovies = movies.stream()
                    .filter(movie -> movie.genre.equals("Action") && movie.year > 2000)
                    .distinct()
                    .toList();
            System.out.println(actionMovies);

        } catch (IOException e){
            System.out.println("Nepodařilo se načíst");
            System.out.println(e.getMessage());
        }


    }

}

class Movie {

    String name;
    int year;
    String genre;
    double rating;

    public Movie(String name, int year, String genre, double rating) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "name: " + name + " year: " + year + " genre: " + genre + " rating: " + rating;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
