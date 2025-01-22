package Dědičnost;

public class Cuboid extends Rectengle{

    double depth;
    public Cuboid(double width, double height, double depth) {
        super(width, height); // super zavolá construktor v classe Rectengle
        this.depth = depth;
    }

    public double getArea(){
        return 2 * ((width * height) + (height * depth) + (width * depth));
    }
    double getVolume(){
        return super.getArea() * depth;
    }

    public static void main(String[] args) {
        Rectengle r = new Rectengle(5,6);
        System.out.println(r.getArea());

        Cuboid c = new Cuboid(5,6,3);
        c.getArea();

       Rectengle weird = new Cuboid(4,1,3); // Tohle funguje, jelikoš Rectangle je SuperClassa
//       Cuboid weird2 = new Rectengle(5,2);  // Tohle nefunguje, jelikož Cuboid je SubClassa

       if (weird instanceof Cuboid){
           // instanceof => je to Cuboid ?
           //přetypování, weirdCuboid je ted kvadr
           Cuboid weirdCuboid = (Cuboid) weird;
           //Rovnout používám věci z kvádu
           ((Cuboid)weird).getVolume();

       }
    }
}
