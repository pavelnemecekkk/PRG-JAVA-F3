import java.util.LinkedList;
import java.util.Queue;

class Character {
    String name;
    int health;
    int attack;

    double defense;

    public Character(String name, int health, int attack, double defense) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    /**
     * Postava se pokusi zautocit na jinou
     *
     * @param opponent postava, na kterou je utoceno
     */
    public void attack(Character opponent) {
        int attackforprint = 0;

        if (defense > 89) {
            attackforprint = (int) (attack * (89.0 / 100));
        } else {
            attackforprint = (int) (attack * (defense / 100));
        }


        System.out.println(name + " attacks " + opponent.name + " for " + attackforprint + " damage!");

        if (defense >= 90) {
            opponent.health -= (int) (attack * (89.0 / 100));
        } else {
            opponent.health -= (int) (attack * (defense / 100));
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String toString() {
        return name + " (HP: " + health + ", Attack: " + attack + ", Defense: " + defense + ")";
    }
}

public class RPGQueue {
    public static void main(String[] args) {
        Queue<Character> team1 = new LinkedList<>();
        Queue<Character> team2 = new LinkedList<>();

        //Naplnit obe fronty postavami

        team1.add(new Character("Warrior", 50, 10, 50));
        team1.add(new Character("Mage", 30, 15, 50));
        team1.add(new Character("Rogue", 40, 12, 50));

        team2.add(new Character("Goofy Bear", 55, 8, 60));
        team2.add(new Character("Spider", 15, 14, 70));
        team2.add(new Character("AnotherSpider", 15, 14, 50));
        team2.add(new Character("Wolf", 45, 10, 70));

        //klasicka implementace by mela zvladnout vypis toString defaultne
        System.out.println("Starting Battle!");
        System.out.println("Team 1: " + team1);
        System.out.println("Team 2: " + team2);


        // TODO: 20.11.2024 Zajistit combat dvou teamu


        while (!team1.isEmpty() && !team2.isEmpty()) {
            Character top = team1.peek();
            Character OpponentTop = team2.peek();

            top.attack(OpponentTop);
            if (!OpponentTop.isAlive()) {
                System.out.println(OpponentTop.name + "is defeated");
                team2.poll();
            } else {
                OpponentTop.attack(top);
            }

            if (!top.isAlive()) {
                System.out.println(top.name + "is defeated");
                team1.poll();
            }

            System.out.println("Team 1: " + team1);
            System.out.println("Team 2: " + team2);
            System.out.println("--------------------");
        }


        //RULES: turn based combat, bojuji vzdy ti na vrcholu fronty
        //combat se opakuje, dokud neni jeden team porazen tak, ze ve fronte nic neni

        //vzdy zacne nekdo z teamu 1 utocit na neco z teamu 2
        //pote neco z teamu 2 na nekoho v temau 1
        //Pokud je clen tymu na vrchu fronty porazen, je vyndan z fronty
        //to, kdo je porazen, za kolik utoci vyuzijte metody v Character


        // TODO: 20.11.2024 Vypsat viteze

        if (team1.isEmpty()) {
            System.out.println("Team 2 wins");
        } else {
            System.out.println("Team 1 wins");
        }
    }
}
