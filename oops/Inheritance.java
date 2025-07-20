package oops;

class Shape{
    String color;

    public void area(){
        System.out.println("display area");
    }

}

// single-level inheritance
class Triangle extends Shape{
    // Runtime Polymorphism (Dynamic Polymorphism) (method overriding)
    public void area(int l, int h){
        System.out.println(1/2 * l * h);  
    }
}


// Hierarchical-level inheritance
// OR Hybrid-level inheritance (mixture of sinlge-level, multi-level, and hierarchical)
class Circle extends Shape{
    public void area(int r){
        System.out.println((3.14) * r * r);  
    }
}

// Multi-level inheritance
class EquilateralTriangle extends Triangle{
    public void area(int l, int h){
        System.out.println(1/2 * l * h);  
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Triangle t1 = new Triangle();
        t1.color = "red";
    }
}
