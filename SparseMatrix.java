package DataStructures; 

public class SparseMatrix{
    public static class Node{
        int value, row, column; 
        Node next; 
        public Node(int value, int row, int column){
            this.value = value; 
            this.row = row; 
            this.column = column; 
            this.next = null; 
        }
    }

    private Node head, tail; 
    private int length = 0;

    private int maxRow(){
        if(this.head == null) return -1; 
        
        Node temp = this.head;
        int max = 0; 
        for(int i =0; i<length; i++){
            if(temp.row> max){
                max = temp.row;
            }   
            temp = temp.next; 
        }

        return max; 
        
        
    }

    private int maxColumn(){
        if(this.head == null) return -1; 

        Node temp = this.head;
        int max = 0; 
        for(int i =0; i<length; i++){
            if(temp.column> max){
                max = temp.column;  
            }   
            temp = temp.next;
        }
        

        return max; 

    
    }
    
    public SparseMatrix(int value, int row , int column){
        Node newNode = new Node(value, row, column); 
        this.head = newNode; 
        this.tail = newNode; 
        length++; 
    }

    public SparseMatrix(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j =0; j<matrix[0].length; j++){
                if(matrix[i][j]!=0){
                    this.append(matrix[i][j], i, j); 
                }
            }
        }
    }

    public int[][] convert2D(){
        
        int[][] matrix = new int[this.maxRow()+1][this.maxColumn()+1]; 
        if(this.head == null) return matrix; 
        Node temp = this.head; 
        for(int i = 0; i<length; i++){
            matrix[temp.row][temp.column] = temp.value; 
            temp = temp.next; 
        }

        return matrix; 
    }

    public void append(int value, int row, int column) {
        Node newNode = new Node(value, row, column); 
        if(this.head == null){
            this.head = newNode; 
            this.tail = newNode; 
            return; 
        }
        
        this.tail.next = newNode; 
        this.tail =  newNode; 
        length++; 
    }

    public Node access(int index){
        if(index < 0 || index >= length) return null; 
        else{
            Node temp = this.head; 
            for(int i=0; i<index; i++){
                temp = temp.next; 
            }

            return temp; 
        }

    }

    public Node remove(int index){
        if(index < 0 || index >= length) return null; 
        else if(index == 0){
            Node temp = this.head; 
            this.head = temp.next; 
            temp.next = null;  
            length--; 
            return temp; 
        }
        else{
            Node prev = this.access(index - 1); 
            Node current = prev.next; 
            prev.next = current.next; 
            current.next = null; 
            length--; 
            return current; 
        }   
    }

    public void displayMatrix(){
        System.out.println(); 
        int[][] matrix = this.convert2D(); 
        for(int i = 0; i<matrix.length; i++){
            System.out.print("[ "); 
            for(int j = 0; j<matrix[0].length; j++){
                System.out.printf("%d ", matrix[i][j]) ; 
            }
            System.out.println("]"); 
        }

    }

    public void display(){
        System.out.print("SparseMatrix( "); 
        if(this.head == null){
            System.out.print(") "); 
        }
        else{
            Node temp = this.head; 
            for(int i=0; i<length-1; i++){
                System.out.printf("[ %d, %d, %d ], ", temp.value, temp.row, temp.column); 
                temp = temp.next; 
            }

            System.out.printf("[ %d, %d, %d ] )", temp.value, temp.row, temp.column);
        }
    }
}