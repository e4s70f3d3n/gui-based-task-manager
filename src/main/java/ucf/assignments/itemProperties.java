/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Easton Vitulli
 */

package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class itemProperties implements Serializable {

    /*
    declare all variables used in the class (i.e. SimpleStringProperty itemDescription,
    SimpleStringProperty dueDate, and SimpleStringProperty completed) designating each as private.
    */

    public itemProperties(String itemDescription, String dueDate) {
        /*
        the constructor to initialize and assign itemDescription, dueDate, and
        set completed to uncompleted.
        */
    }

    public String getItemDescription() {
        /*
        getter to return itemDescription value.
        */
        return "";
    }

    public void setItemDescription(String cutoff) {
         /*
        setter to initialize this.itemDescription.
        */
    }

    public String getDueDate() {
        /*
        getter to return dueDate value.
        */
        return "";
    }

    public void setDueDate(String dueDate) {
         /*
        setter to initialize this.dueDate.
        */
    }

    public String getCompleted() {
        /*
        getter to return completed value.
        */
        return "";
    }

    public void setCompleted() {
        /*
        setter to initialize this.completed.
        */
    }
}