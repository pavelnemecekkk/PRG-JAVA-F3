package OOP.basics;

import java.awt.*;

public class Basics {
    public static void main(String[] args) {
        Coordinates coordinates = new Coordinates(7.5,16.1);
        // new Coordinates(); => konstruktor
        // Coordinates coordinates  => instance
        Rectangle r0 = new Rectangle();
        Rectangle r1 = new Rectangle(4,5);
        Rectangle r2 = new Rectangle(new Dimension(120,150));
    }

}
class Coordinates {
    double x, y;

    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
   }
//    public Coordinates(double x, double y) {
//        this.x = x;
//        this.y = y;
//    }
// =>   Parametrický konstruktor, NESMÍ tam být private


}

class Rectangle{
    double height, width;

    final double Default_height = 2;
    final double Default_width = 4;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }  public Rectangle(int height, double width) {
        this.height = height;
        this.width = width;
    }  public Rectangle(double height, int width) {
        this.height = height;
        this.width = width;
    } public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }public Rectangle(double width) {
        this.height = Default_height;
        this.width = width;
    }

   public Rectangle(Dimension d){
       this.height = d.getHeight();
       this.width = d.getWidth();
   }
    // Délka a šířka v classe Dimension

    public  Rectangle(){
        this.height = Default_height;
        this.width = Default_width;
    }

}