package temp;

// Consider this Java snippet:

interface Vehicle { 
    void move(); 
}

abstract class Car implements Vehicle { 
    public void move(){
        System.out.println("Car moves"); 
    } 
}

class Tesla extends Car { 
    void autopilot(){ 
        System.out.println("Self driving"); 
    } 
}

public class Test { 
    public static void main(String[] args){ 
        Vehicle v = new Tesla();
        v.move(); // Line A
        // v.autopilot(); // Line B 
    } 
}
