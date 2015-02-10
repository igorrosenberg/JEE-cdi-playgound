package org.cdi.advocacy.grocery;

import org.cdi.advocacy.grocery.shelf.Shelf;
import org.cdisource.beancontainer.BeanContainer;
import org.cdisource.beancontainer.BeanContainerManager;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

public class GroceryMain {

    static BeanContainer beanContainer =  BeanContainerManager.getInstance();

    public static void main(String[] args) {
        System.out.println("Groceries");

        Grocery grocery = beanContainer.getBeanByType(Grocery.class);

        for (Available a : grocery.inventory()) {
            System.out.printf("  Article available: %s, number: %d%n", a.name, a.number);
        }
    }
}
