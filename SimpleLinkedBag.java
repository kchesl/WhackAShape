package game;

import bag.Node;
import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 *

 * @param <T>
 *            the entry
 */
public class SimpleLinkedBag<T> implements SimpleBagInterface<T> {

    private Node<T> firstNode;
    private int numberOfEntries;

    /**
     * constructor
     */
    public SimpleLinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }


    @Override
    public boolean add(T anEntry) {
        Node<T> no = new Node(anEntry);
        no.setNext(firstNode);
        firstNode = no;
        numberOfEntries++;
        return anEntry != null;

    }


    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }


    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }


    @Override
    public T pick() {
        if (this.isEmpty()) {
            return null;
        }
        TestableRandom generator = new TestableRandom();
        int index = generator.nextInt(numberOfEntries);
        for (int i = 0; i < index; i++) {
            firstNode = firstNode.next();
        }
        return firstNode.data();
    }


    @Override
    public boolean remove(T anEntry) {
        Node<T> node = this.getReferenceTo(anEntry);
        if (node != null) {
            node.setData(firstNode.data());
            firstNode = firstNode.next();
            numberOfEntries--;
            return true;
        }
        return false;
    }


    /**
     * get specified node
     * 
     * @param anEntry
     *            the specific one
     * @return returns the reference
     */
    public Node<T> getReferenceTo(T anEntry) {
        boolean found = false;
        Node<T> currentNode = firstNode;
        while (!found && currentNode != null) {
            if (anEntry.equals(currentNode.data())) {
                found = true;
            }
            else {
                currentNode = currentNode.next();
            }
        }
        return currentNode;
    }

}
