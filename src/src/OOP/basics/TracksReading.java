package OOP.basics;

import fileworks.DataExport;
import fileworks.DataImport;

public class TracksReading {
    public static void main(String[] args) {
        DataImport di = new DataImport("Tracks.txt");
        DataExport de = new DataExport("Exportovaná_data.txt");
        Song Track;
        String line;
        String[] attributes;
        while (di.hasNext()){
            line = di.readLine();
            attributes = line.split(";");
            Track = new Song(
                    attributes[0],
                    Integer.parseInt(attributes[1]),
                    Double.parseDouble(attributes[2]),
                    Integer.parseInt(attributes[3]));
            de.writeLine(Track.toString());
            System.out.println(Track);


        }

        di.finishImport();
        de.finishExport();
    }

}
class Song{
    String name;
    int year;
    double rating;
    int time;

    public Song(String name, int year, double rating, int time) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Song: " + name + " " + year + " " + rating + " "  + timeFormat();
    }

    String timeFormat(){
        return ((time/60) + ":" + (time%60));
    }
}
