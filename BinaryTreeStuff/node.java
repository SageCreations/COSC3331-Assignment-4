// Code from the book: "Data Structures & Algorithms in Java"

import java.io.*;

public class node {
    public int iData;
    public double dData;
    public node leftChild;
    public node rightChild;
    
    public void DisplayNode() {
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}
