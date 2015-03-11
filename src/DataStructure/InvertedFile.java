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
            return this.entries[getIndex(word)].add(document);
        }
        this.entries[size] = new Entry(word);
        size++;
        boolean result = this.entries[size - 1].add(document);
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
        int index = this.getIndex(word);
        return this.entries[index].contains(document);
    }

    @Override
    public D[] search(W word) {
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
        int hash = word.hashCode();
        int low = 0;
        int high = size - 1;
        while (high >= low) {
            int middle = (low + high) / 2;
            if (this.entries[middle].getHash() == hash) {
                return middle;
            }
            if (this.entries[middle].getHash() < hash) {
                low = middle + 1;
            }
            if (this.entries[middle].getHash() > hash) {
                high = middle - 1;
            }
        }
        return -1;
    }

    private boolean containsWord(int hash) {
        int low = 0;
        int high = size - 1;
        while (high >= low) {
            int middle = (low + high) / 2;
            if (this.entries[middle].getHash() == hash) {
                return true;
            }
            if (this.entries[middle].getHash() < hash) {
                low = middle + 1;
            }
            if (this.entries[middle].getHash() > hash) {
                high = middle - 1;
            }
        }
        return false;
    }

    private void insertionSort() {
        for (int j = 1; j < this.size; j++) {
            Entry key = this.entries[j];
            int i = j - 1;
            while ((i > -1) && (this.entries[i].getHash() > key.getHash())) {
                this.entries[i + 1] = this.entries[i];
                i--;
            }
            this.entries[i + 1] = key;
        }
    }
}
