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
        if (word == null) {
            return false;
        }
        if (this.containsWord(word)) {
            boolean result = this.entries[getIndex(word)].add(document);
            this.insertionSort();
            return result;
        }
        this.entries[size] = new Entry(word);
        size++;
        boolean result = this.entries[size-1].add(document);
        this.insertionSort();
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
        int hash = word.hashCode();
        return containsWord(hash);
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
        if (this.containsWord(word.hashCode())) {
            for (int i = 0; i < this.size; i++) {
                if (entries[i].getKey().equals(word)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private boolean containsWord(int hash) {
        for (int i = 0; i < size; i++) {
            if(this.entries[i].getKey().equals(hash)){
                return true;
            }
        }
        return false;
    }
    
    private void insertionSort() {
        for (int j = 1; j < this.size; j++) {
            Entry key = this.entries[j];
            int i = j-1;
            while ( (i > -1) && ( this.entries[i].getHash() > key.getHash() ) ) {
                this.entries[i+1] = this.entries[i];
                i--;
            }
            this.entries[i+1] = key;
        }
    }
}
