package oops;

class Doctor {
    void care(Patient p){
        System.out.print("Taking care of: " + p.name);
    }
}

class Patient {
    String name;
}


/*  
Association -> means simply one class is connected to the other.
The most basic relationship.
Objects have independent lifecycles


here there is a Association between the doctor and the patient, 
means both can exist independently, if we delete the doctor the patient object lives,
same with the patient if we delete it, the doctor object lives

UML Representation: 
Teacher ----- Student
A -------- B
*/

public class Association {
    public static void main(String[] args) {
        
    }
}
