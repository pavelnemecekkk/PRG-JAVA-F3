package Movies_to_Playlist;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Playlist implements Serializable {
    /**
     * Kolekce vsech filmu v playlistu
     */
    List<MoviesToPlaylist> programme;
    /**
     * Jmeno pro playlist filmu
     */
    String name;

    @Serial
    private static final long serialVersionUID = 42L;

    /**
     * Konstruktor pro vytvoreni playlistu rovnou s nejakou sadou filmu
     * @param name nazev pro playlist
     * @param programme pocatecni list, do kteroho lze vkladat
     */
    public Playlist(List<MoviesToPlaylist> programme, String name){
        this.name = name;
        this.programme = programme;
    }

    /**
     * Konstruktor pro vytvoreni prazdneho playlistu
     * @param name nazev pro playlist
     */
    public Playlist(String name){
        this.name = name;
        this.programme = new ArrayList();
    }


    @Override
    public String toString(){
        //Vypise ve formatu: PlaylistName (doba trvani ve formatu mm:ss):
        //
        //                      movie1.toString()...
        return name + " ("+ getTotalDuration()/60 + " minut : " + getTotalDuration()%60 + " sekund )";
    }

    /**
     * Metoda pro celkove doby trvani ve vterinach
     * @return
     */
    public int getTotalDuration(){
        int total = 0;
        for (int i = 0; i < programme.size(); i++) {
           total += programme.get(i).yearOfRelease;
        }
        return total;
    }

    public void toSerialization (Playlist name) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("lists.ser"));
        if (!name.programme.isEmpty()){
            oos.writeObject(name);
        }
        oos.close();

    }

    }


