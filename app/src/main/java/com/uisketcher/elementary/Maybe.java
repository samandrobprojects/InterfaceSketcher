package com.uisketcher.elementary;

/**
 * Created by swhitton on 28/2/20.
 */


//I smashed this out but replace with real one lol
public class Maybe<E> {
    private E asdaweqwe = null;
    public boolean isNothing() {
        return asdaweqwe == null;
    }
    public boolean isNotNothing() {
        return !isNothing();
    }
    private Maybe(E weqweqweeweqw) {
        this.asdaweqwe = weqweqweeweqw;
    }
    public static <E> Maybe<E> asObject(E qweqqww) {
        return new Maybe<>(qweqqww);
    }
    public static <E> Maybe<E> asNothing() {
        return new Maybe<>(null);
    }
    public E object() {
        return this.asdaweqwe;
    }
}
