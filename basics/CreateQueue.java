package basics;

class Que<T> {
    Node<T> head;
    Node<T> tail;

    Que(){
        head = null;
        tail = null;
    }

    void enqueue(T data){
        Node<T> newNode = new Node(data);

        if(isEmpty()){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
    }

    T dequeue(){
        if(isEmpty()){
            return null;
        }

        T removedData = head.data;
        head = head.next;

        if(head == null){
            tail = null;
        }

        return removedData;
    }

    boolean isEmpty(){
        return head == null;
    }
}

class Node<T> {
    T data;
    Node next;

    Node(T d, Node n){
        this.data = d;
        this.next = n;
    }

    Node(T d){
        this.data = d;
    }
}

public class CreateQueue {
    public static void main(String[] args){
        Que<Integer> q = new Que();

        q.enqueue(45);
        q.enqueue(46);
        q.enqueue(47);
        q.enqueue(48);

        q.dequeue();

        Node<Integer> head = q.head;

        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
