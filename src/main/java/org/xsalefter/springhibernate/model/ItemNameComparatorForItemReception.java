package org.xsalefter.springhibernate.model;

import java.util.Comparator;

/**
 * @author xsalefter (xsalefter@gmail.com)
 */
public class ItemNameComparatorForItemReception implements Comparator<ItemReception> {

    public int compare(ItemReception firstItem, ItemReception secondItem) {
        String firstName = firstItem.getItem().getName();
        String secondName = secondItem.getItem().getName();

        return firstName.compareTo(secondName);
    }

}
