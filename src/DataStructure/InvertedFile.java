/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;

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
        boolean result = false;
        Entry tempEntry = this.entries[size];
        boolean newKey = true;
        //look to see if key already exist
        for (int i = 0; i < size; i++) {
            if (this.entries[i].getKey() == word) {
                newKey = false;
                if (!this.entries[i].contains(document)) {
                    result = this.entries[i].add(document);
                }
                break;
            }
        }
        //add new key if does not exist
        if (newKey) {
            this.entries[size] = new Entry(word);
            result = this.entries[size].add(document);
            if (result) {
                size++;
            } else {
                this.entries[size] = tempEntry;
            }
        }
        return result;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
