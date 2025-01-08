package FileWorks;

public class Enums {
    public static void main(String[] args) {
        User basicUser = new User("Karel",15,Access.ADMIN);

    }
}

class SpecificLocation{
    double x,y;
    Geo region;
}
enum Geo{
    NORTH,
    SOUTH,
    EAST,
    WEST
}
 enum Access{
     BASE_USER(3),
     SUPERBVISOR(2),
     ADMIN(1);

     Access(int i) {

     }
 }

 class User{
    String name;
    int id;
    Access level;

     public User(String name, int id, Access level) {
         this.name = name;
         this.id = id;
         this.level = level;
     }
 }