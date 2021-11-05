/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Easton Vitulli
 */

package ucf.assignments;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

public class itemProperties implements Serializable {

    private StringProperty itemDescription;
    private StringProperty dueDate;
    private BooleanProperty completed;

    /*
    declare all variables used in the class (i.e. StringProperty itemDescription,
    StringProperty dueDate, and BooleanProperty completed) designating each as private.
    */


    public itemProperties(String itemDescription, String dueDate) {
        this.itemDescription = new SimpleStringProperty(itemDescription);
        this.dueDate = new SimpleStringProperty(dueDate);
        this.completed = new SimpleBooleanProperty(false);
        /*
        constructor to initialize and assign itemDescription, dueDate,
        and completed to uncompleted.
        */
    }

    // getter to return itemDescription value
    public String getItemDescription() {
        return itemDescription.get();
    }

    // setter to initialize this.itemDescription.
    public void setItemDescription(String itemDescription) {
        this.itemDescription.set(itemDescription);
    }

    // getter to return dueDate value.
    public String getDueDate() {
        return dueDate.get();
    }

    // setter to initialize this.dueDate.
    public void setDueDate(String dueDate) {
        this.dueDate.set(dueDate);
    }

    // getter to return completed value.
    public boolean isCompleted() {
        return completed.get();
    }

    // setter to initialize this.completed.
    public void setCompleted(boolean completed) {
        this.completed.set(completed);
    }

    // property listening and binding itemDescription.
    public StringProperty itemDescriptionProperty() {
        return itemDescription;
    }

    // property listening and binding dueDate.
    public StringProperty dueDateProperty() {
        return dueDate;
    }

    // property listening and binding completed.
    public BooleanProperty completedProperty() {
        return completed;
    }
}