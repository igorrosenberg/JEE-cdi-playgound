package org.cdi.advocacy.grocery.shelf;

import org.cdi.advocacy.grocery.Available;
import org.cdi.advocacy.grocery.qualifier.Fruit;
import org.cdi.advocacy.grocery.shelf.Shelf;

import javax.enterprise.inject.Alternative;
import java.util.LinkedList;
import java.util.List;

@Fruit
public class FruitShelf implements Shelf {
    public List<Available> contents() {
        List<Available> l = new LinkedList();
        l.add(new Available("Apple", 5));
        return l;

    }
}
