import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TESTVerfied {

    public static ArrayList<String> toRead (File names, File pin) throws IOException {
        ArrayList<String> toReturn = new ArrayList<>();
        List<String> name = Files.readAllLines(names.toPath());
        List<String> pins = Files.readAllLines(pin.toPath());
        String together = null;
        for (int i = 0; i < name.size(); i++) {
            together = name.get(i)+"="+pins.get(i);
            toReturn.add(together);
            together = null;
        }
        return toReturn;
    }
    public static void Verified(ArrayList<String> users) throws IOException {
        double counter = 0;
        double tocount = 0;
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("validLogins.txt")));
        for (int i = 1; i < 6; i++) {
            List<String> verifyFile = Files.readAllLines(Path.of("Verifydata\\attempts_"+ (i) +".txt"));
            for (int j = 0; j < verifyFile.size(); j++) {
                for (int k = 0; k < users.size(); k++) {
                    if (users.get(k).equals(verifyFile.get(j))){
                        counter++;
                        bw.write(users.get(j)+"\n");
                    }
                }
            }
            System.out.println("attemps" + i +" " + (int) counter);
            tocount += counter;
            counter = 0;

        }
        bw.close();
        System.out.println(counter);
        System.out.println("Percent: " +(int)((tocount/500)*100) + "%");
        }

    public static void main(String[] args) throws IOException {
        File name = new File("Verifydata\\usernames.txt");
        File pins = new File("Verifydata\\AllPINs.txt");
        ArrayList<String> users = toRead(name,pins);
        System.out.println(toRead(name,pins));
        Verified(users);
    }
}
