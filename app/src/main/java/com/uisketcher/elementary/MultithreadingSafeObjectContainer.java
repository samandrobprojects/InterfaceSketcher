package com.uisketcher.elementary;

/**
 * Created by swhitton on 28/2/20.
 */

public class MultithreadingSafeObjectContainer<CONTAINED_OBJECT> {

    public interface ObjectAccessor<ACCESSED_OBJECT> {
        public void accessObject(ACCESSED_OBJECT accessedObjectInQuestion);
    }

    private final CONTAINED_OBJECT _safelyContainedObject;

    private MultithreadingSafeObjectContainer(CONTAINED_OBJECT objectToContain) {
        _safelyContainedObject = objectToContain;
    }

    public static <CONTAINED_OBJECT> MultithreadingSafeObjectContainer<CONTAINED_OBJECT> containerSafelyContainingObject(CONTAINED_OBJECT givenObject) {
        return new MultithreadingSafeObjectContainer<>(givenObject);
    }

    public synchronized void accessObjectWithAccessor(ObjectAccessor<CONTAINED_OBJECT> givenObjectAccessor) {
        givenObjectAccessor.accessObject(_safelyContainedObject);
    }
}
