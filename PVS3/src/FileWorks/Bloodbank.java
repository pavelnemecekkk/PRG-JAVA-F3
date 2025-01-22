package FileWorks;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bloodbank {
    void testDonations(int times) {

        for (int i = 0; i < times; i++) {
            // TODO: 18.12.2024  Nahodná dvojice se snaží datovat
        }
    }

    static ArrayList<BloodDonor> getDoonors(String filePath) throws IOException {
        ArrayList<BloodDonor> donors = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        lines.remove(0); // První řádek jsou nazvy sloupců
        String[] atributes;
        BloodDonor donor;
        for (String line : lines) {
            atributes = line.split(",");
            donor = new BloodDonor(atributes[0], Integer.parseInt(atributes[1]), atributes[2], parseBlood(atributes[3]));
            donors.add(donor);
        }
        return donors;
    }

    static BloodType parseBlood(String bloodType) {
        switch (bloodType) {
            case "A+":
                return BloodType.A_POSITIVE;
            case "B+":
                return BloodType.B_POSITIVE;
            case "AB+":
                return BloodType.AB_POSITIVE;
            case "0+":
                return BloodType.O_POSITIVE;
            case "A-":
                return BloodType.A_NEGATIVE;
            case "B-":
                return BloodType.B_NEGATIVE;
            case "AB-":
                return BloodType.AB_NEGATIVE;
            case "0-":
                return BloodType.O_NEGATIVE;
            default:
                return BloodType.AB_POSITIVE;
        }
    }

    public static void main(String[] args) throws IOException {

        ArrayList<BloodDonor> donors = getDoonors("data\\blood.csv");

        for (BloodDonor donor : donors) {
            System.out.println(donor);
        }


        System.out.println(  BloodDonor.donate(donors.get(0), donors.get(1)));

    }
}

class BloodDonor {
    String name;
    int age;
    String state;
    BloodType bloodType;

    public BloodDonor(String name, int age, String state, BloodType bloodType) {
        this.name = name;
        this.age = age;
        this.state = state;
        this.bloodType = bloodType;
    }

    @Override
    public String toString() {
        return name + "(" + bloodType.toString() + ")";
    }

    static boolean donate(BloodDonor from, BloodDonor to) {
        if (from.bloodType.equals(to.bloodType)) {
            return true;
        }
        return false;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BloodDonor donor = (BloodDonor) o;
        return bloodType == donor.bloodType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bloodType);
    }
}


enum BloodType {
    O_POSITIVE(1),
    O_NEGATIVE(2),
    A_POSITIVE(3),
    A_NEGATIVE(4),
    B_POSITIVE(5),
    B_NEGATIVE(6),
    AB_POSITIVE(7),
    AB_NEGATIVE(8),
    ;

    public int position;
    BloodType(int position) {
    }

    public static final byte[][] BLOOD_COMPABILITY = {
            {}
    };
}

