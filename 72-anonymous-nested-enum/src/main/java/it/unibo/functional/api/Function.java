package it.unibo.functional.api;

/**
 * This class models a function of a single parameter as an Object.
 *
 * @param <I> the input type
 * @param <O> the output type
 */
public interface Function<I, O> {

    /**
     * Calls the function.
     *
     * @param input the input of the function
     * @return the result of the function evaluation on the provided input
     */
    O call(I input);

    /**
     * Returns the identity function, which returns the same object that is provided as input.
     *
     * @param <T> the input (and output) type of the function
     * @return A new {@code Function} that implements the identity function with the provided type
     */
    /*
        risposta: dev'essere un metodo e non una costante perché altrimenti il compilatore dopo aver tradotto il codice andrebbe 
        a restituire 
        un riferimento alla classe anonima Funtion$1 che a causa della type-ereasure rappresenterebbe una funzione da obj a obj 
        invece che da T a T(dove il tipo generico T viene deciso a tempo di compilazione)
     */
    static <T> Function<T, T> identity() {
        return new Function<T,T>() {
                    public T call(T input) {
                        return input;
                    }
                };
    }

}
