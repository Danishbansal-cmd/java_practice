package oops;


/*
Composition is a strong form of aggregation.
Represents:: It has a part-of relation (Strong HAS-A relationship), 
with strong ownership.
Contained object's lifetime depends on container.
Parts cannot exist without whole

Real Life Example
House has Rooms. If house is destroyed, rooms also disappear.
Room cannot exist independently.

UML Representation: Solid line with filled diamond at whole side
A ◆------- B
*/

class Room {
    String name;

    Room(){
        this("No-name");
    }

    Room(String n){
        this.name = n;
    }
}

class House {
    private Room livingRoom;
    private Room kitchen;

    House(){
        livingRoom = new Room();
        kitchen = new Room();
    }

    void info(){
        System.out.print(livingRoom.name);
        System.out.print(kitchen.name);
    }
}


public class Composition {
    public static void main(String[] args) {
        
    }
}
