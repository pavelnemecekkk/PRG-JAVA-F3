package FileWorks;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Ciphering {


    public static void main(String[] args) throws IOException {
        Caeser cipher = new Caeser(3, "Caesar");
        List<String> lines = Files.readAllLines(Paths.get("data\\cipherTest.txt"));
        // pro účely debugu, uložit cely soubor do promene
        ArrayList<String> encryptedLines = new ArrayList<>();

        for (String line : lines) {
            encryptedLines.add(cipher.encrypt(line));
        }

        System.out.println("Encrypted");
        System.out.println(encryptedLines);

        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(new File("data\\dataEncrypted.txt"))));
        for (String line : lines) {
            writer.println(line);
        }
        writer.close();

        System.out.println("Decrypted");
        lines = Files.readAllLines(Paths.get("data\\dataEncrypted.txt"));
        for(String line : lines){
            System.out.println(cipher.decrypt(line));
        }

    }
}

abstract class Cipher {
    int key;
    String name;

    public Cipher(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cipher name: " + name + " secret: " + key;
    }

    abstract String encrypt(String input);

    abstract String decrypt(String encryptedInput);
}

class Caeser extends Cipher {

    public Caeser(int key, String name) {
        super(key, name);
    }

    @Override
    String encrypt(String input) {

        StringBuilder result = new StringBuilder();
        String alphabet = "abcdefghijklmnopqrstujvxyz";
        String lowerMessage = input.toLowerCase();

        return result.toString();
    }

    @Override
    String decrypt(String encryptedInput) {




        return null;
    }
}


