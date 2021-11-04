/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Easton Vitulli
 */

package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;

public class toDoList implements Serializable {

    /*
    declare all variables used in the class (i.e. SimpleStringProperty listName and an
    observable list of the item properties class with FXCollections observable array list).
    */

    public toDoList(String listName) {
        /*
        the constructor to initialize and assign listName.
        */
    }

    public ObservableList<itemProperties> getItemObservableList() {
        /*
        getter to return observable list value.
        */
        return null;
    }

    public void addItem(itemProperties itemProperties) {
        /*
        setter to initialize this.itemPropertiesObservableList.add(itemProperties);
        */
    }

    public String getListName() {
        /*
        getter to return itemDescription value.
        */
        return "";
    }

    public void setListName(String listName) {
         /*
        setter to initialize this.listName.set(listName);
        */
    }

}
