package org.cdi.advocacy.grocery.shelf;

import org.cdi.advocacy.grocery.Available;
import org.cdi.advocacy.grocery.qualifier.Flour;
//import org.cdi.advocacy.grocery.qualifier.Veggy;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

// @Flour
public class FlourShelf implements Shelf {

    //@Inject @Veggy
    private Shelf veggyShelf; // = new Shelf ();

    public List<Available> contents() {
        System.out.println("By the way, flour shelf has: "  + veggyShelf);
        List<Available> l = new LinkedList();
        l.add(new Available("Wheat Flour", 3));
        return l;
    }
}
