/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Easton Vitulli
 */

package ucf.assignments;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;

import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class toDoListController implements Initializable {

    /*
    declare FXML GUI controllers for tableview, columns, text and data fields, buttons, and lists/variables.
    */

    @FXML
    private Button addItemButton;

    @FXML
    private Button clearListButton;

    @FXML
    private TableColumn<itemProperties, Boolean> completedColumn;

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
    private Button showEntireListButton;

    @FXML
    private MenuItem showUncompletedMenuButton;

    @FXML
    private MenuItem sortByDueDateMenuButton;

    private SimpleBooleanProperty completed;

    public ObservableList<itemProperties> toDoList = FXCollections.observableArrayList();
    public ObservableList<itemProperties> completedToDoList = FXCollections.observableArrayList();
    public TableView<itemProperties> itemListCompleted = new TableView<>();

    @FXML
    void addItem(ActionEvent event) throws ParseException {
         /*
        use the text from itemDescriptionTextField to create a new item description.
        use the value from the datePicker to get the date. convert it to a string with format of YYYY-MM-DD.
        add new item to the table view.
        fill in date into the datePicker.
        reset listsTextField
         */

        if (!datePicker.getValue().isBefore(LocalDate.now()) & itemDescriptionTextField.getText().length() < 257 &
                itemDescriptionTextField.getText().length() > 0) {

            itemProperties newItem = new itemProperties(itemDescriptionTextField.getText(), formatDueDate(datePicker));
            itemList.getItems().add(newItem);
            itemDescriptionTextField.setText("");
            datePicker.setValue(LocalDate.now());
        }
    }

    public String formatDueDate(DatePicker datePicker) throws ParseException {
        String updatedFormat = "yyyy-MM-dd";

        datePicker.setPromptText(updatedFormat.toLowerCase(Locale.ROOT));
        datePicker.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(updatedFormat);

            @Override
            public String toString(LocalDate object) {
                if (object != null) {
                    return dateTimeFormatter.format(object);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateTimeFormatter);
                } else {
                    return null;
                }
            }
        });
        return datePicker.getValue().format(DateTimeFormatter.ofPattern(updatedFormat));
    }

    void changeCompleted() {

    }

    @FXML
    void clearList(ActionEvent event) {
        // retrieves all items from tableview toDoList and clears it.
        itemList.getItems().clear();
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

        itemProperties selectedItem = itemList.getSelectionModel().getSelectedItem();
        itemList.getItems().remove(selectedItem);
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

    @FXML
    void saveList(ActionEvent event) {
        /*
        call function fileSaver();
         */
    }

    @FXML
    void loadList(ActionEvent event) {
        /*
        call function fileLoader();
         */
    }

    public void fileSaver() {
        /*
        declare an observable list and have it get the selected items.
        start try
            declare a pathway for new FileWriter inside a new BufferedWriter inside a new PrintWriter.
                **(the path utilized for this project was "C:\\Users\\easto\\IdeaProjects\\vitulli-cop3330
                -assignment\\src\\main\\resources\\txt files\\todolists.txt" and the appropriate directory
                is attached in my repository for when my project is fully functional.
            start for loop at i equals zero and continue as long as i is less than the size of the
            array incrementing by 1
                get i of the array and save in the value items
                write item to file
            close file
         */
    }

    public void fileLoader() {
        /*
        start try
            declare a pathway for FileReader. declare buffered reader with filereader.
                **(the path utilized for this project was "C:\\Users\\easto\\IdeaProjects\\vitulli-cop3330
                -assignment\\src\\main\\resources\\txt files\\todolists.txt" and the appropriate directory
                is attached in my repository for when my project is fully functional.
            set a string line to empty.

            start while loop if buffered reader line contains content
                declare new to do list and get the text content from the listsTextField.
                get the items stored within that to do list and store within new todolist.
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
        completedColumn.setCellValueFactory(new PropertyValueFactory<>("completed"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("itemDescription"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));

        itemList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        itemList.setItems(toDoList);
        itemList.setEditable(true);

        descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        dueDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        completedColumn.setCellFactory(CheckBoxTableCell.forTableColumn(completedColumn));
    }
}
