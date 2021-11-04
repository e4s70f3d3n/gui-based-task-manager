/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Easton Vitulli
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class listsController implements Initializable {

    /*
    declare FXML GUI controllers for tableview, columns, text and data fields, buttons, and lists/variables.
    */

    @FXML
    private Button addItemsButton;

    @FXML
    private Button addListButton;

    @FXML
    private Button deleteListButton;

    @FXML
    private MenuButton ioButton;

    @FXML
    private TextField listsTextField;

    @FXML
    private MenuItem loadListButton;

    @FXML
    private MenuItem saveListButton;

    @FXML
    private TableColumn<toDoList, String> tcListTitle;

    @FXML
    private TableView<toDoList> tvToDoLists;

    @FXML
    void addItems(ActionEvent event) {
        /*
        set addItemsButton onAction and use lambda
        get scene, set root, FXMLLoader, load the class and resource, access todolist.fxml file
        check with IOException
         */
    }

    @FXML
    void addList(ActionEvent event) {
        /*
        create a new list that is empty
        get the text from the listsTextField to name the list
        add new list to the table view
        reset listsTextField
         */
    }

    @FXML
    void deleteList(ActionEvent event) {
        /*
        get the index of a selected item in the to do list
        remove the item at the given index
         */
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*
        initialize cellValueFactory of the cells in the tableview.
        set table to allow for multiple selection mode.
        set table so cells are editable.
        set table to an empty list.
        initialize the text field of the cells in the tableview.
         */
    }
}
