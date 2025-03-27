package streaming.maps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieReviews {

    static class Movie{
        private int movieID;
        private String title;
        private String genre;
        private double rating;

        public Movie(int movieID, String title, String genre) {
            this.movieID = movieID;
            this.title = title;
            this.genre = genre;
            this.rating = Double.NaN;
        }
        public int getMovieID() {
            return movieID;
        }

        public String getTitle() {
            return title;
        }

        public String getGenre() {
            return genre;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }
    }

    static class Rating{
        private int movieID;
        private double rating;

        public Rating(int movieID, double rating) {
            this.movieID = movieID;
            this.rating = rating;
        }

        public int getMovieID() {
            return movieID;
        }

        public double getRating() {
            return rating;
        }
    }

    public static void main(String[] args) throws IOException {

        // načtění pomocí lambdy
        List<Movie> movies = Files.lines(Paths.get("reviews\\input.csv"))
                .skip(1) // Vynechávání podle řádku, n není index
                .map(line -> line.split(","))
                .map(parts -> new Movie(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        parts[2]
                ))
                .toList();

        System.out.println("Načteno filmů: " + movies.size());

        List<Rating> ratings = Files.lines(Paths.get("reviews\\ratings.csv"))
                .skip(1)
                .map(line -> line.split(","))
                .map(parts -> new Rating(
                        Integer.parseInt(parts[1].trim()),
                        Double.parseDouble(parts[2].trim())
                ))
                .collect(Collectors.toList());

        System.out.println("Načteno recenzí: " + ratings.size());


        // Počítání času
        long start = System.currentTimeMillis();



        Map<Integer, List<Double>> ratingsMap = ratings.stream().
                collect(Collectors.groupingBy(
                        Rating::getMovieID,
                        Collectors.mapping(Rating::getRating, Collectors.toList())
                        ));

        movies.forEach(movie -> {
            List<Double> movieRatings = ratingsMap.get(movie.getMovieID());
            if (movieRatings != null && !movieRatings.isEmpty()) {
                double avg = movieRatings.stream()
                        .mapToDouble(Double::doubleValue)
                        .average()
                        .orElse(Double.NaN);
                movie.setRating(avg);
            }
        });

        movies.forEach(m -> System.out.println(m.getTitle() + ": " + m.getRating()));
        long stop = System.currentTimeMillis();
        System.out.println("Duration: " + (stop - start) + "ms");
    }
}


