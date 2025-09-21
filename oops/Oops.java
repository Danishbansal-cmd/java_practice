package oops;
import bank.*;

class Student{
    String name;
    int age;

    // copy constructor
    Student(Student s2){
        this.name = s2.name;
        this.age = s2.age;
    }
    // simple constructor
    Student(){}


    // example of compile-time polymorphism (Static Polymorphism) (method overloading)
    public void printInfo(){
        System.out.println(this.name);
        System.out.println(this.age);
    }
    public void printInfo(int age){
        System.out.println(age);
    }
    public void printInfo(String name, int age){
        System.out.println(name + " is " + age + " years old.");
    }
    public void printInfo(int age, String name){
        System.out.println(age + " years had been spent on planet earth by " + name);
    }
}


// abstract means it is just the concept
// not the actual implementation or the abstraction class
// will not have any implementation

// PROPERTIES of ABSTRACT Class
// Abstract class must be declared with an abstract keyword
// It can have abstract and non-abstract methods
// It cannot be instantiated
// // Animal a = new Animal(); cannot instantiate abstract class
// It can have constructors and static methods also
// It can have final methods which will force the sub-class not to change the body of the method

// Why Use an abstract class
// 1. Force Subclasses to Implement Certain Methods
// 2. Common Code Sharing (Partial Implementation)
// 3. Prevent Instantiation of Base Class
abstract class Animal{
    // Abstract methods do not specify a body
    // Abstract methods needs to be implemented in every derived class
    abstract void walk();

    public void eat(){
        System.out.println("Animal eats");
    }

    // this constructor will be called when the sub-class constructor is called
    Animal(){
        System.out.println("You are creating a new Animal.");
    }

    // it is final, and cannot be changed in the sub-classes or anywhere
    // apart from this abstract class
    final void herbivores(){
        System.out.println("Eats grass only");
    }
}
class Horse extends Animal {
    @Override
    public void walk(){
        System.out.println("Walk on 4 legs");
    }
    // Compile time polymorphism 
    // Because this is overloading the walk() method 
    // within the same class with different parameters.
    public void walk(int pace){
        System.out.println("Walk on 4 legs at pace of " + pace + "km/h");
    }
    Horse(){
        System.out.println("Created a Horse.");
    }

    // Method over-riding
    @Override
    public void eat(){
        System.out.println("Horse eats");
    }
    // Compile time polymorphism 
    public void eat(String thing){
        System.out.println("Horse eats " + thing);
    }
}
class Chicken extends Animal {
    public void walk(){
        System.out.println("Walk on 2 legs");
    }
}


public class Oops {
    public static void main(String args[]){
        Student s1 = new Student();
        s1.age = 23;
        s1.name = "Danish";
        Student s2 = new Student(s1);
        s2.printInfo();
        // s2.printInfo(s2.age);
        // s2.printInfo(s2.name, s2.age);
        // s2.printInfo(s2.age, s2.name);

        // from another package
        Bank b1 = new Bank();
        b1.name = "Danish";

        // Horse() constructor is called
        Horse h1 = new Horse();
        h1.walk();
        h1.eat();
        h1.eat("grass");

        // gives error here, 
        // because "Cannot instantiate the type Animal"
        // Animal a1 = new Animal();
        // a1.walk();
    }
}
