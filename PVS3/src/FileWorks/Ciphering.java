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

        System.out.println("Encrypted");
        System.out.println(encryptedLines);

        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(new File("data\\dataEncrypted.txt"))));
        for (String line : lines) {
            writer.println(cipher.encrypt(line));
        }
        writer.close();

        System.out.println("Decrypted");
        lines = Files.readAllLines(Paths.get("data\\dataEncrypted.txt"));
        for (String line : lines) {
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
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String lowerMessage = input.toLowerCase();

        for (int i = 0; i < input.length(); i++) {
            if (Character.isAlphabetic(lowerMessage.charAt(i))){
                int position = alphabet.indexOf(lowerMessage.charAt(i));
                if (position + key >= alphabet.length()){
                    result.append(alphabet.charAt(position + key - alphabet.length()));
                } else {
                    result.append(alphabet.charAt(position + key));
                }
            } else {
                result.append(lowerMessage.charAt(i));
            }
        }

        return result.toString();
    }


    @Override
    String decrypt(String encryptedInput) {
        int tmp = key;
        key = 26 - key;
        String result = encrypt(encryptedInput);
        key = tmp;
        return result;
    }
}


