package oops;

import java.util.List;

class Department {
    List<Professors> p;

    Department(List<Professors> p){
        this.p = p;
    }
}

class Professors {
    String name;
}


/*
Aggregation -> It is a special type of association.
It represents "HAS-A" relationship but with weak ownership.
The contained object can exist independently.
Key point:: Objects are loosely connected.
If container dies, contained objects survive.

UML Representation
Aggregation uses hollow diamond.
Department ◇------ Professor

Like in here the contained object of Professors can be exist independently,
even if we delete the Department object
*/

public class Aggregation {
    
}
