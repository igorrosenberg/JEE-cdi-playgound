package org.cdi.advocacy.grocery;

import org.cdi.advocacy.grocery.qualifier.Fruit;
import org.cdi.advocacy.grocery.shelf.FlourShelf;
import org.cdi.advocacy.grocery.shelf.Shelf;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GroceryImpl implements Grocery {

    //@Inject @Veggy
    //private Shelf veggyShelf; // = new Shelf ();

    @Inject @Fruit
    private Shelf fruitShelf; // = new Shelf ();

    @Inject // @Flour
    private FlourShelf flourShelf; // = new Shelf ();

    @Inject @Any
    Instance<Shelf> shelves;

    @Override
    public Iterable<? extends Available> inventory() {

        if (! shelves.isAmbiguous())
            throw new NullPointerException("Instance injection is not ambiguous");

        List<Available> l = new LinkedList();

        System.out.println("------ checking instances ------");
        System.out.println("    fruitShelf ID: " + fruitShelf);
        System.out.println("    flourShelf ID: " + flourShelf);
        for (Shelf s : shelves) {
            System.out.println("iterator Shelf ID: " + s);
        }

        System.out.println("------ calling named and instances ------");
        l.addAll(fruitShelf.contents());
        l.addAll(flourShelf.contents());
        for (Shelf s : shelves) {
            l.addAll(s.contents());
        }
        System.out.println("------ calling only instances ------");
        for (Shelf s : shelves) {
        }

        return l;
    }
}
