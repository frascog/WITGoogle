/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;

import java.util.List;

/**
 *
 * @author Greg
 */
public class InvertedFile<D, W> implements InvertedFileInterface<D, W> {

    private static final int DEFUALT_INITIAL_CAPACITY = 1000;
    private static final int MAXIMUM_CAPACITY = 20000;
    private int size = 0;
    private Entry[] entries;

    public InvertedFile() {
        this.entries = new Entry[DEFUALT_INITIAL_CAPACITY];
    }

    public InvertedFile(int initialCapacity) {
        this.entries = new Entry[initialCapacity];
    }

    @Override
    public boolean add(D document, W word) {
        if (word == null) {
            return false;
        }
        int hash = word.hashCode();
        if (this.containsWord(word)) {
            return this.entries[getIndex(word)].add(document);
        }
        
        this.entries[size] = new Entry(word);
        size++;
        return this.entries[size-1].add(document);
    }

    @Override
    public boolean remove(D document, W word) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int capasity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsWord(W word) {
        for (int i = 0; i < size; i++) {
            if(this.entries[i].getKey().equals(word)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(D document, W word) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public D search(W word) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public D[] search(W[] words) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        String message = "";
        for (Entry entry : entries) {
            if (entry != null) {
                message += entry.toString() + "\n";
            }
        }
        return message;
    }

    private int getIndex(W word) {
        if (this.containsWord(word)) {
            for (int i = 0; i < this.size; i++) {
                if (entries[i].getKey().equals(word)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
