public interface Iterator<T> {

    // The get() method returns the element at the current position.
    T get();

    // The advance() method moves the iterator to the next position.
    void advance();

    // The equals() method tests whether this iterator is at the same position
    // as the other iterator.
    @Override
    boolean equals(Object other);

    // The clone() method creates a new iterator at the same position as this iterator.
    Iterator<T> clone();

}