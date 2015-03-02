/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;

/**
 *
 * @author frascog
 */
public class Node<D,W> {

    private static final int T = 4;
    private int numWords;
    private W[] words;
    private D[] documents;
    private Node[] childNodes;
    private boolean leafNode;
    private Node nextNode;

    public Node() {
        numWords = 0;
        words = (W[]) new Object[2 * T - 1];
        documents = (D[]) new Object[2 * T - 1];
        childNodes = new Node[2 * T];
    }

    public int getNumWords() {
        return numWords;
    }

    public void setNumWords(int numWords) {
        this.numWords = numWords;
    }

    public W[] getWords() {
        return words;
    }

    public void setWords(W[] words) {
        this.words = words;
    }

    public D[] getDocuments() {
        return documents;
    }

    public void setDocuments(D[] documents) {
        this.documents = documents;
    }

    public Node[] getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(Node[] childNodes) {
        this.childNodes = childNodes;
    }

    public boolean isLeafNode() {
        return leafNode;
    }

    public void setLeafNode(boolean leafNode) {
        this.leafNode = leafNode;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}