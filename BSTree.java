package DataStructures; 

public class BSTree {
    static class Node{
        int value; 
        Node left; 
        Node right; 
        public Node(int value){
            this.value = value; 
            this.left = null; 
            this.right = null; 
        }
    }

    private Node root; 
    public BSTree(int number){
        Node newNode = new Node(number);
        this.root = newNode; 
    }

    public boolean insert(int number){
        Node newNode = new Node(number); 
        Node current = this.root; 
        while(true){
            if(current.value == newNode.value) return false; 
            else if(current.value < newNode.value){
                current.left = current.left == null? newNode: current.left; 
            }
            else{
                current.right = current.right == null? newNode: current.right; 
            }
        }
    }


}
