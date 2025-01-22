package Movies_to_Playlist;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlaylistForUsers {

    public static List<MoviesToPlaylist> toParse(List<String> toRead){
        List<MoviesToPlaylist> toReturn = new ArrayList<>();
        int index = 1;
        String[] params;
        for(String read : toRead){
            params = read.split(";");

            toReturn.add(new MoviesToPlaylist(
                   index + " " +  params[0],
                    Integer.parseInt(params[1]),
                    Double.parseDouble(params[2]),
                    Integer.parseInt(params[3])
            ));
            index++;
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File toRevise = new File("lists.ser");
        List<String> moviesToRead = Files.readAllLines(Paths.get("ListOfFilms.txt"));
        List<MoviesToPlaylist> moviesToPlaylists = toParse(moviesToRead);
        System.out.println(moviesToPlaylists);
        Playlist defaultPlaylist = new Playlist(moviesToPlaylists, "defaultPlaylist");
        Scanner sc = new Scanner(System.in);
        System.out.println(defaultPlaylist);


        if (toRevise.isFile()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("lists.ser"));
            defaultPlaylist = null;
            defaultPlaylist = (Playlist) ois.readObject();
            System.out.println(defaultPlaylist);
            ois.close();
            ArrayList<Playlist> PlaylistsArray = new ArrayList<>();
            PlaylistsArray.add(defaultPlaylist);
            System.out.println("Vyber si číslo pro splnění úkolu");
            System.out.println( "1 - vypsat všechny filmy\n" +
                                "2 - vypsat všechny playlisty\n" +
                                "3 - vytvořit nový playlist\n" +
                                "4 (BONUS) - editovat playlist\n" +
                                "0 - uložit a ukončit (tj. zajistit serializaci)\n" +
                                "-1 - neuložit a ukončit");
            switch (sc.nextInt()){
                case (0):
                    break;
                case (1):
                    for (int i = 0; i < defaultPlaylist.programme.size(); i++) {
                        System.out.println(defaultPlaylist.programme.get(i));
                    }
                    break;
                case (2):
                    System.out.println(PlaylistsArray);
                    break;
                case (3):
                    System.out.println("Name of Playlist:");
                    String name = sc.nextLine();
                    ArrayList<MoviesToPlaylist> toAdd = new ArrayList<>();
                    while (sc.nextInt() == -1 ){
                        System.out.println("Vyber si filmy podle indexu");
                        System.out.println(defaultPlaylist);
                        if (sc.nextInt() > defaultPlaylist.programme.size()){
                            System.out.println("Vyber si čílo od: 1 až " + defaultPlaylist.programme.size() + ", nebo pro ukončení vypiš -1");
                            break;
                        } else {
                            toAdd.add(defaultPlaylist.programme.get(sc.nextInt()));
                        }
                        PlaylistsArray.add(new Playlist(toAdd, name));
                    }
                    break;
                case (-1):
                    break;
                default:
                    System.out.println("Nebylo nic vybráno"); break;
            }
        } else {
            System.err.println("Nebyla nalezen soubor: " + toRevise);
        }
    }
}
