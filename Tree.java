package DataStructures; 


public class Tree {
    static class Node{
        Node left, right; 
        int value; 
        public Node(int number){
            this.value = number;
            this.left = this.right = null; 
        }
    }

    private Node root; 
    private StringBuilder s = new StringBuilder(""); 

    public Tree(int number){
        this.root = new Node(number); 
    }

    public void insert(int number){
        Node newNode = new Node(number);
        this.insertRecursively(this.root, newNode);  
    }

    public Node insertRecursively(Node currentRoot, Node newNode){
        if(currentRoot == null){
            return newNode; 
        }else if(currentRoot.value > newNode.value){
            currentRoot.left = this.insertRecursively(currentRoot.left, newNode); 
        }else{
            currentRoot.right = this.insertRecursively(currentRoot.right, newNode); 
        }

        return currentRoot; 
    }

    public String inorder(){
        this.inorderTraversal(this.root);
        String p = new String(s); 
        this.s = new StringBuilder(" "); 
        return p; 
    }

    private void inorderTraversal(Node currentRoot){
        if(currentRoot == null){
           return; 
        }
        this.inorderTraversal(currentRoot.left);
        s.append(currentRoot.value).append(", "); 
        this.inorderTraversal(currentRoot.right);
    }

    public static void main(String[] args){
        Tree tr = new Tree(100); 
        tr.insert(49);
        tr.insert(53); 
        tr.insert(101); 
        tr.insert(79); 
        tr.insert(153); 
        tr.insert(125); 
        tr.insert(110); 
        String s = tr.inorder(); 
        System.out.println(s);
    }



}
