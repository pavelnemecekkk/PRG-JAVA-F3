package Reference;

public class Person {
    private String name;
    private int age;

    public static void main(String[] args) {
        Person p1 = new Person(20);
        Person p2 = new Person(30);
        Person p3 = p1;
        p2.age = 40;
        p3.birthday();
        p3 = p2;
        p3.birthday();
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
    public Person(int age) {
        this.age = age;
    }
    public void birthday() {
        this.age++;
    }
    
}
