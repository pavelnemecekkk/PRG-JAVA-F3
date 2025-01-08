package FileWorks.Serials;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class CollectionSerialzition {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Coordinates> coordinates = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            coordinates.add(new Coordinates(r.nextInt(10000), r.nextInt(10000), r.nextInt(10000)));
        }
        System.out.println(coordinates);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("coordsList.ser"));
        if (!coordinates.isEmpty()){
            oos.writeObject(coordinates);
        }
        oos.close();

        List<Coordinates> deseriallizedCoordinates = null;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("coordsList.ser"));
        deseriallizedCoordinates = (List<Coordinates>) ois.readObject();
        ois.close();
        System.out.println(deseriallizedCoordinates);
        System.out.println(deseriallizedCoordinates.size() == coordinates.size());
    }
}
