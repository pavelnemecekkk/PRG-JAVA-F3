package FileWorks.Serials;


import java.io.*;

public class SerialExport {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // EXPORT, serialization
        // Musím serializovat i danou třídu
        Coordinates cords = new Coordinates(5,6,20);
        System.out.println("Exportuju: " + cords);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("single_court.ser"));
        oos.writeObject(cords);
        oos.close();

        //IMPORT, deserialization

        Coordinates deserialized = null;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("single_court.ser"));
        deserialized = (Coordinates) ois.readObject();
        System.out.println("Importovano: " + deserialized);
        ois.close();
    }
}
