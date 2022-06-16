package DataStructures; 

public class LinkedList {
    static class Node{
        Node next; 
        int value; 
        Node(int number){
            this.next = null; 
            this.value = number; 
        }

    }

    private Node head, tail; 
    private int length; 

    public LinkedList(int num){
        Node newNode = new Node(num); 
        this.head = newNode; 
        this.tail = newNode; 
        this.length++; 
    }

   

    public void append(int num){
        Node newNode = new Node(num);
        if(this.head == null && this.tail == null) {
            this.head = newNode;
        }
        else{
            this.tail.next = newNode;
        }
        this.tail = newNode;
        length++;
    }

    public void appendMany(int ... args){
        for(int num: args){
            this.append(num);
        }
    }

    public void prepend(int num){
        Node newNode = new Node(num);
        if(this.head == null && this.tail == null){
            this.tail = newNode;
        }
        else{
            newNode.next = this.head;
        }
        this.head = newNode;
        length++;
    }

    public void display(){
        Node temp = this.head;
        System.out.print("LinkedList( ");
        if(this.head == null) System.out.println(") ");
        else{
            while(temp.next != null){
                System.out.print(temp.value+", ");
                temp = temp.next;
            }

            System.out.println(temp.value + " )");
        }


    }

    public int getLength() {
        return length;
    }

    public Node getTail() {
        return tail;
    }

    public Node getHead() {
        return head;
    }
    
}
