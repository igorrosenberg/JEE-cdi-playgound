package org.cdi.advocacy.grocery.shelf;

import org.cdi.advocacy.grocery.Available;
import org.cdi.advocacy.grocery.qualifier.Veggy;

import javax.enterprise.inject.Produces;
import java.util.LinkedList;
import java.util.List;

public class ShelfProducer {

    public static final Shelf singleton = singletonInit();

    private static Shelf singletonInit() {
        System.out.println("Producing singleton Veggy");
        return new Shelf() {
            @Override
            public List<Available> contents() {
                List<Available> l = new LinkedList();
                l.add(new Available("Potatoe", 10));
                return l;
            }
        };
    }

    @Produces @Veggy
    Shelf createVeggyShelf() {
        System.out.println("Factory called");
        return singleton;
    }

}
