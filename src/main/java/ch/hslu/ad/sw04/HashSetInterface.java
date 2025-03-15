package ch.hslu.ad.sw04;

/**
 * Interface for a simple hash-based set of elements.
 * Implements the basic operations for a collection without duplicates.
 *
 * @param <T> The type of elements stored in this set
 */
public interface HashSetInterface<T> {

    /**
     * Adds an element to the hash set.
     *
     * @param element The element to be added
     */
    void add(T element);

    /**
     * Removes an element from the hash set.
     *
     * @param element The element to be removed
     */
    void remove(T element);

    /**
     * Checks if an element is contained in the hash set.
     *
     * @param element The element to search for
     * @return true if the element is contained in the set, false otherwise
     */
    boolean contains(T element);

}
