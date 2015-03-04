/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;

import java.util.ArrayList;

/**
 *
 * @author frascog
 */
public class Entry<W,D> {
    
    private final W key;
    private ArrayList<D> documents;
    private Entry<W,D> next;
    
    public Entry(W key) {
        this.key = key;
    }
    
    public boolean add(D document){
        return this.documents.add(document);
    }
    
    public boolean remove(D document){
        return this.documents.remove(document);
    }
    
    public boolean isEmpty() {
        return this.documents.isEmpty();
    }
    
    public boolean contains(D document){
        return this.documents.contains(document);
    }
    
    public D[] getDocuments(){
        return (D[]) this.documents.toArray();
    }

    public int getNumberOfDocuments(){
        return this.documents.size();
    }
    
    public D getDocument(int index){
        return this.documents.get(index);
    }

    public Entry<W, D> getNext() {
        return next;
    }

    public void setNext(Entry<W, D> next) {
        this.next = next;
    }

    public W getKey() {
        return key;
    }
    
    @Override
    public String toString() {
        String message = this.key.toString() + " | ";
        for (D document : documents) {
            message += document.toString() + ", ";
        }
        return message.substring(0, message.length() - 2);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Entry) {
            Entry e = (Entry) obj;
            if(this.key == e.key && this.documents == e.documents && this.next == e.next){
                return true;
            }
        }
        return false;
    }
}