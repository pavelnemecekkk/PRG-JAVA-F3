
import fileworks.DataImport;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Test_Lambda {


    public static ArrayList<Health> toLoad (String nameofFile){
        ArrayList<Health> people = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(nameofFile));
            String[] paramas;
            for(String line : lines){
                paramas = line.split(",");
                people.add(new Health(
                        paramas[0],
                        Integer.parseInt(paramas[1]),
                        paramas[2],
                        paramas[3],
                        Double.parseDouble(paramas[4])));
        }

    } catch (IOException e){
            System.out.println("Nepodařilo se načíst");
            System.out.println(e.getMessage());
        }
        return people;
    }

    public static void main(String[] args) {
        ArrayList<Health> donors = toLoad("health.csv");
        System.out.println(donors);
    int countByAMinus = (int) donors.stream()
                .distinct()
                .filter(health -> health.getBloodType().equals("A-") && health.getAge() >= 20 || health.getAge() <= 50)
                .count();
    System.out.println(countByAMinus);

    double avgOfDonors0 =  donors.stream()
            .distinct()
            .filter(health -> health.getBloodType().equals("O-") || health.getBloodType().equals("O+"))
            .count();
        System.out.println(avgOfDonors0);
        System.out.println((int)((avgOfDonors0 / donors.size()) * 100) + " %");

       Set<Health> countByDuplicate = donors.stream()
                .filter(health -> health.getRace().equals("Female"))
               .sorted(Comparator.comparing(Health::getName))
               .collect(Collectors.toSet());
        System.out.println(donors.size() - countByDuplicate.size());

        int countByPrice = (int) donors.stream()
                .distinct()
                .filter(health -> health.getPrice() < 10000 & health.getBloodType().contains("-") )
                .count();
        System.out.println(countByPrice);

/*        List<Health> donorsFilter = donors.stream()
                .distinct()
                .filter(health -> health.getBloodType().equals("B+") || health.getBloodType().equals("B-") || health.getBloodType().equals("0-") || health.getBloodType().equals("0+"))
                .toList();

        System.out.println(donorsFilter);*/

        double avgToPay = donors.stream()
                .distinct()
                .filter(health -> health.getRace().equals("Male"))
                .mapToDouble(Health::getPrice)
                .average()
                .orElse(0);

        System.out.println(avgToPay);

    }
}

class Health {
    String name;
    int age;
    String race;
    String bloodType;
    double price;

    public Health(String name, int age, String race, String bloodType, double price) {
        this.name = name;
        this.age = age;
        this.race = race;
        this.bloodType = bloodType;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRace() {
        return race;
    }

    public String getBloodType() {
        return bloodType;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "name: " + name + " age: " + age + " Male/Female: " + race + " bloodType: " + bloodType + " price: " + price;
    }
}
