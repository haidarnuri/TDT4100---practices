package inheritance;

import java.util.NoSuchElementException;

public interface IndexedCollection<T> {
    T getElement(int pos) throws NoSuchElementException;
}
