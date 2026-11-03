package it.unibo.inner.impl;
import java.util.Iterator;
import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;
/**
 * this class implement {@code IterableWithPolicy<T>} inteface
 * @param <T> is an iterable collection
 * @see IterableWithPolicy
 */
public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {
    private T[] elements;
    public IterableWithPolicyImpl(final T[] elements) {
        this.elements = elements;
    }
    /**
     * {@inheritDoc}
     */
    public Iterator<T> iterator() {
        return new IteratorWithPolicyImpl(elements);
    }

    /**
     * {@inheritDoc}
     */
    public void setIterationPolicy(Predicate<T> filter) {
        
    }
    private  class IteratorWithPolicyImpl implements Iterator<T>{
        private int index;
        private T[] array;
        private IteratorWithPolicyImpl(final T[] array) {
            this.array = array;
            this.index = 0;
        }
        @Override
        public boolean hasNext() {
            return index < array.length;
        }

        @Override
        public T next() {
            int returnIndex = index;
            index++;
            return array[returnIndex];
        }
        
    }
}