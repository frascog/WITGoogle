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

    private Node rootNode;
    private final int T = 4;

    public InvertedFile() {
        rootNode = new Node<D, W>();
        rootNode.setLeafNode(true);
    }

    @Override
    public void add(D document, W word) {
        Node rootNode = this.rootNode;
        if (rootNode.getNumWords() == (2 * T - 1)) {
            Node newRootNode = new Node();
            rootNode = newRootNode;
            newRootNode.setLeafNode(false);
            rootNode.getChildNodes()[0] = rootNode;
            splitChildNode(newRootNode, 0, rootNode); // Split rootNode and move its median (middle) key up into newRootNode.
            insertIntoNonFullNode(newRootNode, word, document); // Insert the key into the B-Tree with root newRootNode.
        } else {
            insertIntoNonFullNode(rootNode, word, document); // Insert the key into the B-Tree with root rootNode.
        }
    }

    // Split the node, node, of a B-Tree into two nodes that contain T-1 (and T) elements and move node's median key up to the parentNode.
    // This method will only be called if node is full; node is the i-th child of parentNode.
    // All internal keys (elements) will have duplicates within the leaf nodes.
    private void splitChildNode(Node parentNode, int i, Node node) {
        Node newNode = new Node();
        newNode.setLeafNode(node.isLeafNode());
        newNode.setNumWords(T);
        for (int j = 0; j < T; j++) { // Copy the last T elements of node into newNode. Keep the median key as duplicate in the first key of newNode.
            newNode.getWords()[j] = node.getWords()[j + T - 1];
            newNode.getDocuments()[j] = node.getDocuments()[j + T - 1];
        }
        if (!newNode.isLeafNode()) {
            for (int j = 0; j < T + 1; j++) { // Copy the last T + 1 pointers of node into newNode.
                newNode.getChildNodes()[j] = node.getChildNodes()[j + T - 1];
            }
            for (int j = T; j <= node.getNumWords(); j++) {
                node.getChildNodes()[j] = null;
            }
        } else {
            // Manage the linked list that is used e.g. for doing fast range queries.
            newNode.setNextNode(node.getNextNode());
            node.setNextNode(newNode);
        }
        for (int j = T - 1; j < node.getNumWords(); j++) {
            node.getWords()[j] = 0;
            node.getDocuments()[j] = null;
        }
        node.setNumWords(T - 1);

        // Insert a (child) pointer to node newNode into the parentNode, moving other keys and pointers as necessary.
        for (int j = parentNode.getNumWords(); j >= i + 1; j--) {
            parentNode.getChildNodes()[j + 1] = parentNode.getChildNodes()[j];
        }
        parentNode.getChildNodes()[i + 1] = newNode;
        for (int j = parentNode.getNumWords() - 1; j >= i; j--) {
            parentNode.getWords()[j + 1] = parentNode.getWords()[j];
            parentNode.getDocuments()[j + 1] = parentNode.getDocuments()[j];
        }
        parentNode.getWords()[i] = newNode.getWords()[0];
        parentNode.getDocuments()[i] = newNode.getDocuments()[0];
        parentNode.setNumWords(parentNode.getNumWords() + 1);
    }

    // Insert an element into a B-Tree. (The element will ultimately be inserted into a leaf node). 
    private void insertIntoNonFullNode(Node node, W word, D document) {
        int i = node.getNumWords() - 1;
        if (node.isLeafNode()) {
            // Since node is not a full node insert the new element into its proper place within node.
            while (i >= 0 && word < node.getWords()[i]) {
                node.getWords()[i + 1] = node.getWords()[i];
                node.getDocuments()[i + 1] = node.getDocuments()[i];
                i--;
            }
            i++;
            node.getWords()[i] = word;
            node.getDocuments()[i] = document;
            node.setNumWords(node.getNumWords()+1);
        } else {
                        // Move back from the last key of node until we find the child pointer to the node
            // that is the root node of the subtree where the new element should be placed.
            while (i >= 0 && word < node.getWords()[i]) {
                i--;
            }
            i++;
            if (node.getChildNodes()[i].getNumWords() == (2 * T - 1)) {
                splitChildNode(node, i, node.getChildNodes()[i]);
                if (word > node.getWords()[i]) {
                    i++;
                }
            }
            insertIntoNonFullNode(node.getChildNodes()[i], word, document);
        }
    }

    @Override
    public void remove(D document, W word) {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

}
