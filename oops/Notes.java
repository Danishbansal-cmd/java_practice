package oops;

// in java we don't need to create the destructor function
// because java is smart and have the "garbage collector"


// types of inheritance in java for classes
// single-level 
// multi-level 
// hierarchical-level 
// hybrid-level 
// multiple-level (not implemented using class, but interfaces)

// Access modifiers in Java
// 1. public - (can be accessed from anywhere)
// 2. protected - (can be accessed by anyone or anywhere in the same package, and along with the sub-classes of the
// other packages)
// 3. private - (can be accessed in the same class only, no matter the package, sub-class and all
// only in the same class only)
// 4. default - (when not applied any access modifier for either class, method or variable, then it uses this
// the meaning of "default" is that, it is only accessed in the same package,
// or in the same package it can be accessed by anyone or anywhere)


// need to make the main function public, because it needs
// to be accessed by the complier and start compiling and all


// ENCAPSULATION
// in simple terms - bind the data members and methods into a single unit.
// Explain - so making the object and the classes is the concept or implementation
// of encapsulation as we hide the internal methods and working of the things
// in the class and show only the useful or necessary things to the user


// DATA HIDING
// DATA HIDING is the process of protecting members of the class from unintended
// changes whereas, ABSTRACTION is hiding the implementation details and showing only
// important/useful parts to the user


// CONSTRUCTOR CHAINING
// it is the concept of calling the parent's constructor when
// creating the object from the sub-class

// STATIC
// in this the memory is allocated only one time

class StickyNote{
    public String note;
    protected String characterCode;
    private int noteId;
    private String password;

    StickyNote(String note, String characterCode, int noteId){
        this.note = note;
        this.characterCode = characterCode;
        this.noteId = noteId;
    }
    void printNote(){
        System.out.println(this.note);
        System.out.println(this.characterCode);
        System.out.println(this.getNoteId());
    }

    // getters and setters for the private thing
    public int getNoteId(){
        return this.noteId;
    }
    // public setter
    public void setNoteId(int value){
        this.noteId = value;
    }


    // getters and setters for the private thing(password)
    public String getPassword(){
        setPassword("randomPasswordFunction");
        return this.password;
    }
    // private setter
    private void setPassword(String value){
        this.password = value;
    }
}


public class Notes{
    public static void main(String[] args) {
        StickyNote note1 = new StickyNote("this is some test note", "UTF-8", 12);
        note1.note = "changed";
        note1.printNote();
        note1.printNote();
    }
}