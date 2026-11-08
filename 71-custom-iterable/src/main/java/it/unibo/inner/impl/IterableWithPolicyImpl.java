package it.unibo.inner.impl;
import java.util.Iterator;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;
/**
 * this class implement {@code IterableWithPolicy<T>} inteface
 * @param <T> it's an iterable collection
 * @see IterableWithPolicy
 */
public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {
    private T[] elements;
    private Predicate<T> filter;
    /**
     * this constructor takes:
     * @param
     * @param
     */
    public IterableWithPolicyImpl(final T[] elements, final Predicate<T> filter ) {
        this.elements = elements;
        this.filter = filter;
    }
    /**
     * this constructor only takes:
     * @param
     * in this constructor it's suppoused that we want to iterate every object in the array
     */
    public IterableWithPolicyImpl(final T[] elements) {
        this(elements, 
            new  Predicate<T>() {
                public boolean test(T elem) {
                    return true;
                }
            }
        );
    }
    /**
     * {@inheritDoc}
     */
    public Iterator<T> iterator() {
        return new IteratorWithPolicyImpl(elements, filter);
    }

    /**
     * {@inheritDoc}
     */
    public void setIterationPolicy(Predicate<T> filter) {
        this.filter = filter;
    }
    private  class IteratorWithPolicyImpl implements Iterator<T>{
        private int index;
        private int filteredLength;
        private Predicate<T> filter;
        private T[] array;
        private IteratorWithPolicyImpl(final T[] array, final Predicate<T> filter) {
            this.array = array;
            this.filter = filter;
            this.index = 0;
            int i = array.length;
            while(i > 0 && !filter.test(array[i - 1])){
                i--;
            }
            this.filteredLength = i;
        }
        /**
         * {@inheritDoc}
         */
        public boolean hasNext() {
            return index < filteredLength;
        }
        public T next(){
            while (hasNext() && !filter.test(array[index])) {
                index++;
            }
            int lastvalidIndex = index;
            index++;
            return array[lastvalidIndex];
        }
        
    }
}