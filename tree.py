
import statistics as st 


class Node():
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

class Tree():
    def __init__(self, value):
        self.root = Node(value)
        
    def insert(self, number:int):
        new_node = Node(number)
        current = self.root
        while(True):
            if current.value == number:
                return False
            elif new_node.value > number:
                current.left = new_node if current.left == None else current.left
                return True
            else: 
                current.right = new_node if current.right == None else current.right
                return True

if __name__ == '__main__':
    bst = Tree(6)
    bst.insert(8)
    print(bst.root.right.value)       
            
                
            

    