/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Easton Vitulli
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class toDoListController implements Initializable {

    /*
    declare FXML GUI controllers for tableview, columns, text and data fields, buttons, and lists/variables.
    */

    @FXML
    private Button addItemButton;

    @FXML
    private Button backToListButton;

    @FXML
    private TableColumn<itemProperties, String> completedColumn;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TableColumn<itemProperties, String> descriptionColumn;

    @FXML
    private TableColumn<itemProperties, String> dueDateColumn;

    @FXML
    private MenuButton filterItemsMenuButton;

    @FXML
    private TextField itemDescriptionTextField;

    @FXML
    private TableView<itemProperties> itemList;

    @FXML
    private Button removeItemButton;

    @FXML
    private MenuItem showCompletedMenuButton;

    @FXML
    private MenuItem showUncompletedMenuButton;

    @FXML
    private MenuItem sortByDueDateMenuButton;

    /*
    declare additional tableview and lists used for functions like TableView<itemProperties> selectedItems.
     */

    @FXML
    void addItem(ActionEvent event) {
         /*
        use the text from itemDescriptionTextField to create a new item description.
        use the value from the datePicker to get the date. convert it to a string with format of YYYY-MM-DD.
        add new item to the table view.
        fill in date into the datePicker.
        reset listsTextField
         */
    }

    @FXML
    void backToList(ActionEvent event) {
        /*
        set backToListButton onAction and use lambda
        get scene, set root, FXMLLoader, load the class and resource, access lists.fxml file
        check with IOException
         */
    }

    @FXML
    void checkComplete(ActionEvent event) {
        /*
        declare list of selected items
        get selected items and remove them
        mark selected items as complete
        add selected items again
         */
    }

    @FXML
    void filterItems(ActionEvent event) {
        /*
        default displays all items but menu button allows for access to filters.
         */
    }

    @FXML
    void removeItem(ActionEvent event) {
        /*
        declare list of selected items
        get selected items and remove them from list
        */
    }

    @FXML
    void showCompletedFilter(ActionEvent event) {
        /*
        declare a new list
        for all items that do have completed values marked, add to new list.
        display new completed list in table view.
         */
    }

    @FXML
    void showUncompletedFilter(ActionEvent event) {
         /*
        declare a new list
        for all items that do not have completed values marked, add to new list.
        display new uncompleted list in table view.
         */
    }

    @FXML
    void sortByDueDateFilter(ActionEvent event) {
        /*
        set dueDate table column to setSortType.
        use SortType.ASCENDING or SortType.DESCENDING to organize values
         */
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         /*
        initialize cellValueFactory of the cells in the tableview.
        set table to allow for multiple selection mode.
        set table so cells are editable.
        initialize the text field of the cells in the tableview.
         */
    }
}