package oops;

// WHY INTERFACE IS USED
// to implement the pure abstraction class
// Purpose	Define abstract behavior

// PROPERTIES OF INTERFACE
// . cannot have non-abstract method
// . All the fields in interfaces are public, static and final by default.
// . All methods are public & abstract by default.
// . A class that implements an interface must implement all the methods declared
// in the interface.
// . Interfaces support the functionality of multiple inheritance.

interface Robots {
    int legs = 4;
    void walk();
}

interface Mind {
    void think();
}

// Mutltiple-level Inheritance can be implemented using interfaces
// Base-1 class         Base-2 class
//     \                 /
//       \             /
//         \         /
//          Sub-Class
class MiniRobot implements Robots, Mind{
    int legs = 51;
    @Override
    public void walk(){
        System.out.println("MiniRobot walks");
    }
    @Override
    public void think(){
        System.out.println("MiniRobot can think, it have mind");
    }
}

public class Interfaces {
    public static void main(String[] args) {
        MiniRobot m1 = new MiniRobot();
        m1.walk();
        m1.think();
        System.out.println(m1.legs);
        // remains final and constant
        System.out.println(Robots.legs);
    }
}
