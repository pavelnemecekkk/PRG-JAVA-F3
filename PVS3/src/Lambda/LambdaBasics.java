package Lambda;

import Opakování.FileBasics;

import java.io.File;
import java.util.Comparator;

public class LambdaBasics {
    public static void main(String[] args) {
        // Anonymní vnitřní třída, ne lambda
        Functions f = new Functions() {
            @Override
            public double quadratic(double a) {
                return a*a;
            }
        };

        //Přijme a, vrátí a*a
        Functions quadratic = a -> a*a;
        quadratic.quadratic(5);
        // pokud chceme 2 vstupy, musíme dát do závorek
        Operations addition = (a,b) -> (a+b);
        // Alternativa k zapsání
//        Operations addition = Double::sum;
        Operations multiplication = (a,b) -> (a*b);
        // Vstup void, nevrací to nic
        Texting text = b -> {
            System.out.println("Hello " + b);
        };
        text.text("World");
        // Žádný vstup to nebere
        Zero z = () -> System.out.println("Tohle nic nedělá");
        z.print();
        // lambda
        Comparator<File> fileSize = ((o1, o2) -> (int)(o1.length()  - o2.length()));
        //agragace: Silne, ale je potřeba vědět co dělám
        Comparator<File> fileSize2 = Comparator.comparing(File::length);

    }
    interface Functions{
        double quadratic(double a);
    }

    interface Operations{
        double operation(double a, double b);
    }
    interface Texting {
        void text(String b);
    }

    interface Zero{
        void print();
    }
}
