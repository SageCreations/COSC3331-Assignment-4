// Code from the book: "Data Structures & Algorithms in Java"

import java.io.*;
import java.util.*;

public class tree {
    private node root;
    
	public tree() { root = null; }

    public node find(int key) {
        node current = root;
        
        while (current.iData != key) {
            if (key < current.iData) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            
            if (current == null) {
                return null;
            }
        }
    
        return current;
    }
    
    
    public void insert(int id, double dd) {
        node newNode = new node();
        newNode.iData = id;
        newNode.dData = dd;
        
        if (root == null) {
            root = newNode;
        } else {
            node current = root;
            node parent;
            
            while (true) {
                parent = current;
                if (id < current.iData) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }
    
    public boolean delete(int key) {
        node current = root;
        node parent = root;
        boolean isLeftChild = true;
        
        while (current.iData != key) {
            parent = current;
            if (key < current.iData) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }

            if (current == null) {
                return false;
            }
        }

        // found node to delete
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            node Successor = getSuccessor(current);
            if (current == root) {
                root = Successor;
            } else if (isLeftChild) {
                parent.leftChild = Successor;
            } else {
                parent.rightChild = Successor;
            }
            Successor.leftChild = current.leftChild;
        }
        return true;
    }
    
    private node getSuccessor(node delNode) {
        node successorParent = delNode;
        node successor = delNode;
        node current = delNode.rightChild;
        
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        
        return successor;
    }
    
    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.print("\nInorder traversal: ");
                inOrder(root);
                break;
            case 3:
                System.out.print("\nPostorder Traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }
    
    private void preOrder(node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.iData + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }
    
    private void inOrder(node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData + " ");
            inOrder(localRoot.rightChild);
        }
    }
    
    private void postOrder(node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.iData + " ");
        }
    }
    
    public void DisplayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println(
        "...................................................................");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            
            for (int j = 0; j < nBlanks; j++) {
                System.out.print(" ");
            }
            
            while (globalStack.isEmpty() == false) {
                node temp = (node)globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    
                    if (temp.leftChild != null || temp.rightChild != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                
                for (int j = 0; j < nBlanks*2-2; j++) {
                    System.out.print(" ");
                }
            }
            System.out.println("");
            nBlanks /= 2;
            while (localStack.isEmpty() == false) {
                globalStack.push(localStack.pop());
            }
        }
        System.out.println(
                "...............................................................");
    }

	node maximum(node X) {
		node temp = X;
		if (X.rightChild != null) {
		    temp = maximum(X.rightChild);
		}
		return temp;
	}

	void getMaximum() {
		if (root != null) {
		    node temp = maximum(root);
			System.out.println(temp.iData + " is the biggest node");
		} else {
		    System.out.println("The tree is empty!!!");
		}

	}
}
