package DataStructures; 

public class CQueue{
    private int[] cqueue; 
    private int rear = -1, front=-1; 
    private int maxSize; 
    private int items = 0; 
    public CQueue(int maxLength){
        this.maxSize = maxLength; 
        this.cqueue = new int[this.maxSize]; 
    }

    private boolean overflow(){
        if(this.front == 0 && this.rear == maxSize -1) return true;
        if(this.rear + 1 == this.front) return true; 
        else return false; 
    }

    private boolean underflow(){
        if(front == -1) return true; 
        else return false; 
    }

    public int dequeue(){
        if(this.underflow()) return -1; 
        if(rear == front) {
            int number = cqueue[this.front]; 
            cqueue[this.front] = 0; 
            front = -1; 
            rear = -1; 
            items--; 
            return number; 
        }

        int number = cqueue[front]; 
        cqueue[this.front] = 0;
        front =(front+1)%maxSize;
        items--;  
        return number; 
    }

    public void enqueue(int number){
        if(this.overflow()) return; 
        else{
            rear = (rear+1)%maxSize; 
            cqueue[rear] = number; 
            if(front == -1) front = 0; 
            items++; 
        }
    }
 
    
}