package DataStructures; 

public class Queue {
    private int front = -1, rear = -1; 
    private int maxSize; 
    private int[] queue; 
    private int items = 0; 
    public Queue(int length){
        maxSize = length; 
        queue = new int[maxSize]; 
    }

    public void enqueue(int number){
        if(rear>=maxSize) return; 
        front = rear==-1?front+1:front; 
        queue[++rear] = number; 
        items++; 
        return;  
    }

    public int dequeue(){
        if(front==-1) return -1;
        else{
            int removedNumber = queue[front]; 
            front++; 
            items--; 
            return removedNumber; 
        }
    }

    public void display(){
        System.out.print("Queue( "); 
        if(rear == -1){
            System.out.print(")\n"); 
            return; 
        }
        for(int i =0; i<items-1; i++){
            System.out.print(queue[i]+", "); 
        }

        System.out.print(queue[items -1]+" ) \n");

    }
}
