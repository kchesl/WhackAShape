package game;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Kirsten Chesley (kchesley888)

import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 *
 * @author Kirsten Chesley (kchesley888)
 * @version (2020-Mar-01)
 * @param <T>
 *            the entry
 */
public class SimpleArrayBag<T> implements SimpleBagInterface<T> {

    private T[] bag;
    final static private int MAX = 25;
    private int numberOfEntries;

    /**
     * constructor
     */
    public SimpleArrayBag() {
        @SuppressWarnings("unchecked")
        T[] tempbag = (T[])new Object[MAX];
        bag = tempbag;
        numberOfEntries = 0;
    }


    @Override
    public boolean add(T anEntry) {
        if ((numberOfEntries < 25) && (anEntry != null)) {
            bag[numberOfEntries] = anEntry;
            numberOfEntries++;
            return true;
        }
        return false;
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
        if (!this.isEmpty()) {
            TestableRandom generator = new TestableRandom();
            int index = generator.nextInt(numberOfEntries);
            return bag[index];
        }
        return null;
    }


    @Override
    public boolean remove(T anEntry) {
        if (this.getIndexOf(anEntry) != -1) {
            bag[this.getIndexOf(anEntry)] = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
            return true;
        }
        return false;
    }


    /**
     * gets index
     * 
     * @return returns the index
     */
    private int getIndexOf(T anEntry) {
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                return i;
            }
        }
        return -1;
    }
}
