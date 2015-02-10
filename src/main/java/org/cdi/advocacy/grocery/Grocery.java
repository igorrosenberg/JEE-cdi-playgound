package org.cdi.advocacy.grocery;

public interface Grocery {
    Iterable<? extends Available> inventory();
}
