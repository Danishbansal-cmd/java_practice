package oops;

/*
Dependency means: One class temporarily uses another class.
It has a Depends-on relation.
It has Very weak relationship.
Usually: method parameter, local variable, static method call
No permanent storage.

Employee depends on Printer, only during method execution.

UML Representation: Employee -------> Printer (dotted arrow)
A - - - -> B
*/

class Printer {
    void print(String msg) {
        System.out.println(msg);
    }
}

class Employee {

    void work(Printer p) {
        p.print("Working");
    }
}


public class Dependency {
    
}
