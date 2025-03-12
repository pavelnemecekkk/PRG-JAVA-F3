package streaming.maps;

import java.util.HashMap;
import java.util.Map;


public class BasicMaps {
    public static void main(String[] args) {
        // Napořadí zavisí, relace 1:1
        HashMap<String, String > countries = new HashMap<>();
        // Přidání něčeho, Klíč a hodnotu
        countries.put("USA", "Washington DC");
        countries.put("Germany", "Berlin");
        countries.put("Finland", "Helsinki");
        countries.put("Czech Republic", "Prague");
        System.out.println(countries.size());
        System.out.println(countries);
        //Chce to klíč
        System.out.println(countries.get("Finland"));
        // Pokud tam není, napiš default
        System.out.println(countries.getOrDefault("Norway", "Country not found"));
        countries.put("France", "Paris");
        // Potřebuje pouze klíč (index v poli)
        countries.remove("France");
        // Přepsání hodnoty pomocí klíče
        countries.replace("USA", "Detroit");
        System.out.println(countries);
        System.out.println(countries.containsKey("France"));
        System.out.println(countries.containsValue("Prague"));

        for (String country : countries.keySet()){
            System.out.println(country);
            System.out.println("Capital: " + countries.get(country));
        }

        // entrySet, procyklený mapa, hodí se pro indexování, pokud mám mapu hotovou
        for (Map.Entry<String, String> entry : countries.entrySet()){
            System.out.println("Country: " + entry.getKey() + ", Capital: " + entry.getValue());
        }

        double avgNameLength = countries.values().stream()
                .mapToInt(String::length)
                .average()
                .orElse(0);
        System.out.println("Avarage capital name: " + avgNameLength);

    }
}
