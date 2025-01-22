package OOP.basics;

public class ClassArray {
    public static void main(String[] args) {

        Coordinatess c = new Coordinatess(4.1,5.8);
        System.out.println(c.x); // Vezmu objekt c a vypíše to, co mám na x
        System.out.println(c.y);
        System.out.println(c); // Vezme to toString()

        Coordinatess[] coords = new Coordinatess[5];
        Coordinatess[] coordinatesses =  {new Coordinatess(4.2,5.5),
                                            c,
                                            new Coordinatess(400_000_000_000.4,.9)};

        for (int i = 0; i < coordinatesses.length; i++) {
            System.out.println(coordinatesses[i]);
        }


        // Vytvoří proměnou a udělá tohle: Coordinatess cord = coordinates[0], vytvoří odkaz na to
        // Heap = složítý věci, Stack = jednoduchý, názvy proměnných, velikost 4KB
        for(Coordinatess cord : coordinatesses){
            System.out.println(cord);
        }

    }
}
class Coordinatess{
    double x,y;

    public Coordinatess(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinatess{" + "x=" + x + ", y=" + y + '}';
    }
}




