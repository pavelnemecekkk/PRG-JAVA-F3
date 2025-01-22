package Movies_to_Playlist;

import java.io.Serial;
import java.io.Serializable;

public class MoviesToPlaylist implements Serializable {
    String name;
    int yearOfRelease;
    double rating;
    int duraiton;

    @Serial
    private static final long serialVersionUID = 42L;

    public MoviesToPlaylist(String name, int yearOfRelease, double rating, int duraiton) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.duraiton = duraiton;
    }

    @Override
    public String toString() {
        return name + " (" + yearOfRelease + ")";
    }
}
