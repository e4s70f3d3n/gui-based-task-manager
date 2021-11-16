package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.matcher.control.TableViewMatchers;
import org.testfx.matcher.control.TextInputControlMatchers;

import java.io.IOException;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.TableViewMatchers.hasTableCell;

@ExtendWith(ApplicationExtension.class)
class toDoListControllersTest {

    private static Scene scene;
    public static Stage stage1;
    @FXML
    private TableColumn<itemProperties, Boolean> completedColumn;
    @FXML
    private TableColumn<itemProperties, String> descriptionColumn;
    @FXML
    private TableColumn<itemProperties, String> dueDateColumn;

    @FXML
    private TableView<itemProperties> itemList;

    @FXML
    private DatePicker datePicker;


    public ObservableList<itemProperties> toDoList = FXCollections.observableArrayList();
    private String dateString;

    @BeforeEach
    void setUp(FxRobot fxRobot) {
        fxRobot.clickOn("#itemDescriptionTextField");
        fxRobot.write("submit application assignment 1, part 2");
        fxRobot.clickOn(770, 600);
        fxRobot.clickOn(740, 575);
        fxRobot.clickOn("#addItemButton");

        fxRobot.clickOn("#itemDescriptionTextField");
        fxRobot.write("take statistics exam 3");
        fxRobot.clickOn(770, 600);
        fxRobot.clickOn(760, 575);
        fxRobot.clickOn("#addItemButton");

        fxRobot.clickOn("#itemDescriptionTextField");
        fxRobot.write("submit logic project");
        fxRobot.clickOn(770, 600);
        fxRobot.clickOn(795, 575);
        fxRobot.clickOn("#addItemButton");
    }

    private static Parent viewToDoList() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/todolist.fxml"));
        Parent parent = fxmlLoader.load();
        return parent;
    }

    @Start
    void Start(Stage stage) throws IOException {
        scene = new Scene(viewToDoList());
        stage.setScene(scene);
        stage1 = stage;
        stage.show();
    }

    @Test
    void testItemDescriptionTextField(FxRobot fxRobot) {
        /*
        click on item description text field
        write "submit application assignment 1, part 2" into text field.
        verify that the text field contains the expected text.
         */
        fxRobot.clickOn("#itemDescriptionTextField");
        fxRobot.write("submit application assignment 1, part 2");
        verifyThat("#itemDescriptionTextField", TextInputControlMatchers.hasText("submit application assignment 1, part 2"));
    }

    @Test
    void testDatePicker(FxRobot fxRobot) {
        /*
        select due date 2021-12-12 from date picker.
         */

        fxRobot.clickOn(770, 600);
        fxRobot.clickOn(755, 390);
        fxRobot.clickOn(675, 500);
    }

    @Test
    void testAddItemButton(FxRobot fxRobot) {
         /*
         assert that item list has a cell containing the listed string.
          */

        verifyThat("#itemList", hasTableCell("submit application assignment 1, part 2"));
    }

    @Test
    void testClearListButton(FxRobot fxRobot) {
        /*
        click clear list button.
        assure that item list is empty
         */
        fxRobot.clickOn("Clear List");
        fxRobot.sleep(3000);
        verifyThat("#itemList", NodeMatchers.hasChild(""));
    }

    @Test
    void checkCompleted(FxRobot fxRobot) {
        /*
        click on check mark in completed column for item at index 0 to mark as completed.
        use verify that to ensure the cell value changed from false to true.
         */

        fxRobot.clickOn(450, 228);
        fxRobot.sleep(3000);
        verifyThat("#itemList", TableViewMatchers.containsRow(true, "submit application assignment 1, part 2", "2021-12-07"));
    }

    @Test
    void should_NotAddItem_when_GreaterThan256Characters(FxRobot fxRobot) {

        /*
        click on item description text field.
        write text into field that is greater than 256 characters.
        click on valid date.
        click on add item button.
        verify that item list has 3 rows since item was not added.
         */

        fxRobot.clickOn("#itemDescriptionTextField");
        fxRobot.write("submit application assignment 1, part 2, submit practice exercises in c++, submit application assignment in c++ (EXTRA " +
                "CREDIT), submit computer logic and organization semester project, complete statistics exam 3,  submit statistics homework 5, " +
                "complete statistics final exam");
        fxRobot.clickOn(770, 600);
        fxRobot.clickOn(740, 575);
        fxRobot.clickOn("#addItemButton");
        fxRobot.sleep(3000);
        verifyThat("#itemList", TableViewMatchers.hasNumRows(3));
    }

    @Test
    void should_NotAddItem_when_LessThan1Character(FxRobot fxRobot) {

        /*
        click on item description text field.
        write nothing into text field.
        click on valid date.
        click on add item button.
        verify that item list has 3 rows since item was not added.
         */

        fxRobot.clickOn("#itemDescriptionTextField");
        fxRobot.write("");
        fxRobot.clickOn(770, 600);
        fxRobot.clickOn(740, 575);
        fxRobot.clickOn("#addItemButton");
        fxRobot.sleep(3000);
        verifyThat("#itemList", TableViewMatchers.hasNumRows(3));

    }

    @Test
    void should_ReturnEmptyList_when_ItemDescriptionFieldIsEmpty(FxRobot fxRobot) {
        /*
        leave item field empty.
        check that list is empty when that occurs.
         */

        itemProperties toDoList = new itemProperties("", "2021-12-15");
        verifyThat("#itemList", hasTableCell(null));
    }

    @Test
    void should_NotAddItem_when_DueDateIsNotValid(FxRobot fxRobot) {
        fxRobot.clickOn("#itemDescriptionTextField");
        fxRobot.write("submit practice exercises in c++");
        fxRobot.clickOn(770, 600);
        fxRobot.clickOn(725, 450);
        fxRobot.clickOn("#addItemButton");
        fxRobot.sleep(3000);
        verifyThat("#itemList", TableViewMatchers.hasNumRows(3));
    }

    @Test
    void removeItem(FxRobot fxRobot) {
        /*
        test an empty string value in the description text bar.
        get the actual value from the function.
        assert actual and expected equals to each other.
         */

        fxRobot.clickOn(770, 225);
        fxRobot.clickOn("#removeItemButton");
        fxRobot.sleep(3000);
        verifyThat("#itemList", TableViewMatchers.hasNumRows(2));
    }


    @Test
    void should_AllowItemDescriptionCellContentEditing_when_TableViewCellIsDoubleClicked(FxRobot fxRobot) {

        /*
        verify that all three items are contained within the table view:
        the first row with an uncompleted item titled "submit application assignment 1, part 2" due
        on "2021-12-07"
        the second row with an uncompleted item titled "take statistics exam 3" due on "2021-12-08"
        the third row with an uncompleted item titled "submit logic project" due on "2021-12-09"
        double click on the item description column cell containing the string "submit logic project"
        erase the old text
        write new string "submit final draft of logic project"
        enter new string value.
        verify that the table view now contains a third row with an uncompleted item titled "submit
        final draft logic project" due on "2021-12-09"
        */

        verifyThat("#itemList", TableViewMatchers.containsRow(false, "submit application assignment 1, part 2", "2021-12-07"));
        verifyThat("#itemList", TableViewMatchers.containsRow(false, "take statistics exam 3", "2021-12-08"));
        verifyThat("#itemList", TableViewMatchers.containsRow(false, "submit logic project", "2021-12-09"));
        fxRobot.doubleClickOn("submit logic project");
        fxRobot.eraseText(20);
        fxRobot.write("submit final draft of logic project");
        fxRobot.press(KeyCode.ENTER);
        fxRobot.sleep(3000);
        verifyThat("#itemList", TableViewMatchers.containsRow(false, "submit final draft of logic project", "2021-12-09"));

    }

    @Test
    void should_AllowDueDateCellContentEditing_when_TableViewCellIsDoubleClicked(FxRobot fxRobot) {

        /*
        verify that all three items are contained within the table view:
        the first row with an uncompleted item titled "submit application assignment 1, part 2" due
        on "2021-12-07"
        the second row with an uncompleted item titled "take statistics exam 3" due on "2021-12-08"
        the third row with an uncompleted item titled "submit logic project" due on "2021-12-09"
        double click on the due date column cell containing the string "2021-12-08"
        erase the old text
        write new string "2021-12-13"
        enter new string value.
        verify that the table view now contains a third row with an uncompleted item titled "take
        statistics exam 3" due on "2021-12-13"
        */

        verifyThat("#itemList", TableViewMatchers.containsRow(false, "submit application assignment 1, part 2", "2021-12-07"));
        verifyThat("#itemList", TableViewMatchers.containsRow(false, "take statistics exam 3", "2021-12-08"));
        verifyThat("#itemList", TableViewMatchers.containsRow(false, "submit logic project", "2021-12-09"));
        fxRobot.doubleClickOn("2021-12-08");
        fxRobot.eraseText(10);
        fxRobot.write("2021-12-13");
        fxRobot.press(KeyCode.ENTER);
        fxRobot.sleep(3000);
        verifyThat("#itemList", TableViewMatchers.containsRow(false, "take statistics exam 3", "2021-12-13"));

    }

    @Test
    void showCompletedFilter(FxRobot fxRobot) {
        /*
        click on check boxes for first and third table view items.
        click on filter items button.
        click on show completed items button.
        verify that the table view only contains two rows now instead of the previous 3.
        verify that the table view contains a row with a completed item titled "submit
        application assignment 1, part 2" due on "2021-12-07"
        verify that the table view contains a row with a completed item titled "submit
        logic project" due on "2021-12-09"
         */

        fxRobot.clickOn(455, 228);
        fxRobot.clickOn(455, 283);
        fxRobot.clickOn("Filter Items");
        fxRobot.clickOn("#showCompletedMenuButton");
        fxRobot.sleep(3000);
        verifyThat("#itemList", TableViewMatchers.hasNumRows(2));
        verifyThat("#itemList", TableViewMatchers.containsRow(true, "submit application assignment 1, part 2", "2021-12-07"));
        verifyThat("#itemList", TableViewMatchers.containsRow(true, "submit logic project", "2021-12-09"));

    }

    @Test
    void showUncompletedFilter(FxRobot fxRobot) {

         /*
        click on check boxes for first and third table view items.
        click on filter items button.
        click on show uncompleted items button.
        verify that the table view only contains one rows now instead of the previous 3.
        verify that the table view contains a row with an uncompleted item titled "take
        statistics exam 3" due on "2021-12-08"
         */

        fxRobot.clickOn(455, 228);
        fxRobot.clickOn(455, 283);
        fxRobot.clickOn("Filter Items");
        fxRobot.clickOn("#showUncompletedMenuButton");
        fxRobot.sleep(3000);
        verifyThat("#itemList", TableViewMatchers.hasNumRows(1));
        verifyThat("#itemList", TableViewMatchers.containsRow(false, "take statistics exam 3", "2021-12-08"));

    }

    @Test
    void should_VerifyEntireListContentsPresent_when_SwitchingFromCompletedFilter(FxRobot fxRobot) {
        /*
        click on check boxes for first and third table view items.
        click on filter items button.
        click on show completed items button.
        verify that the table view only contains two rows now instead of the previous 3.
        click on show entire list button.
        verify that the table view now contains all 3 original rows.
        */

        fxRobot.clickOn(455, 228);
        fxRobot.clickOn(455, 283);
        fxRobot.clickOn("Filter Items");
        fxRobot.clickOn("#showCompletedMenuButton");
        fxRobot.sleep(1500);
        verifyThat("#itemList", TableViewMatchers.hasNumRows(2));
        fxRobot.clickOn("#showEntireListButton");
        fxRobot.sleep(3000);
        verifyThat("#itemList", TableViewMatchers.hasNumRows(3));
        verifyThat("#itemList", TableViewMatchers.containsRow(true, "submit application assignment 1, part 2", "2021-12-07"));
        verifyThat("#itemList", TableViewMatchers.containsRow(false, "take statistics exam 3", "2021-12-08"));
        verifyThat("#itemList", TableViewMatchers.containsRow(true, "submit logic project", "2021-12-09"));
    }

    @Test
    void should_VerifyEntireListContentsPresent_when_SwitchingFromUncompletedFilter(FxRobot fxRobot) {
        /*
        click on check boxes for first and third table view items.
        click on filter items button.
        click on show uncompleted items button.
        verify that the table view only contains one rows now instead of the previous 3.
        click on show entire list button.
        verify that the table view now contains all 3 original rows.
         */

        fxRobot.clickOn(455, 228);
        fxRobot.clickOn(455, 283);
        fxRobot.clickOn("Filter Items");
        fxRobot.clickOn("#showUncompletedMenuButton");
        fxRobot.sleep(1500);
        verifyThat("#itemList", TableViewMatchers.hasNumRows(1));
        fxRobot.clickOn("#showEntireListButton");
        fxRobot.sleep(3000);
        verifyThat("#itemList", TableViewMatchers.hasNumRows(3));
        verifyThat("#itemList", TableViewMatchers.containsRow(true, "submit application assignment 1, part 2", "2021-12-07"));
        verifyThat("#itemList", TableViewMatchers.containsRow(false, "take statistics exam 3", "2021-12-08"));
        verifyThat("#itemList", TableViewMatchers.containsRow(true, "submit logic project", "2021-12-09"));
    }

    @Test
    void sortByDueDateAscendingFilter(FxRobot fxRobot) {

         /*
        add two new items.
        one with due date 2021-12-18 and the other 2021-12-12
        click on filter items button.
        click on sort by due date ascending button.
        verify that each of the five items have the proper associated boolean value,
        text, and due date and use at index to organize by ascending date
         */

        fxRobot.clickOn("#itemDescriptionTextField");
        fxRobot.write("submit practice exercises in c++");
        fxRobot.clickOn(770, 600);
        fxRobot.clickOn(755, 390);
        fxRobot.clickOn(850, 500);
        fxRobot.clickOn("#addItemButton");

        fxRobot.clickOn("#itemDescriptionTextField");
        fxRobot.write("submit application assignment in c++ (EXTRA CREDIT)");
        fxRobot.clickOn(770, 600);
        fxRobot.clickOn(755, 390);
        fxRobot.clickOn(675, 500);
        fxRobot.clickOn("#addItemButton");

        fxRobot.clickOn("Filter Items");
        fxRobot.clickOn("#sortByDueDateAscendingMenuButton");
        fxRobot.sleep(3000);
        verifyThat("#itemList", TableViewMatchers.containsRowAtIndex(0, false, "submit application assignment 1, part 2", "2021-12-07"));
        verifyThat("#itemList", TableViewMatchers.containsRowAtIndex(1, false, "take statistics exam 3", "2021-12-08"));
        verifyThat("#itemList", TableViewMatchers.containsRowAtIndex(2, false, "submit logic project", "2021-12-09"));
        verifyThat("#itemList", TableViewMatchers.containsRowAtIndex(4, false, "submit practice exercises in c++", "2021-12-18"));
        verifyThat("#itemList", TableViewMatchers.containsRowAtIndex(3, false, "submit application assignment in c++ (EXTRA CREDIT)", "2021-12-12"));

    }

    @Test
    void sortByDueDateDescendingFilter(FxRobot fxRobot) {

        /*
        add two new items.
        one with due date 2021-12-18 and the other 2021-12-12
        click on filter items button.
        click on sort by due date ascending button.
        verify that each of the five items have the proper associated boolean value,
        text, and due date and use at index to organize by descending date
         */

        fxRobot.clickOn("#itemDescriptionTextField");
        fxRobot.write("submit practice exercises in c++");
        fxRobot.clickOn(770, 600);
        fxRobot.clickOn(755, 390);
        fxRobot.clickOn(850, 500);
        fxRobot.clickOn("#addItemButton");

        fxRobot.clickOn("#itemDescriptionTextField");
        fxRobot.write("submit application assignment in c++ (EXTRA CREDIT)");
        fxRobot.clickOn(770, 600);
        fxRobot.clickOn(755, 390);
        fxRobot.clickOn(675, 500);
        fxRobot.clickOn("#addItemButton");

        fxRobot.clickOn("Filter Items");
        fxRobot.clickOn("#sortByDueDateDescendingMenuButton");
        fxRobot.sleep(3000);
        verifyThat("#itemList", TableViewMatchers.containsRowAtIndex(4, false, "submit application assignment 1, part 2", "2021-12-07"));
        verifyThat("#itemList", TableViewMatchers.containsRowAtIndex(3, false, "take statistics exam 3", "2021-12-08"));
        verifyThat("#itemList", TableViewMatchers.containsRowAtIndex(2, false, "submit logic project", "2021-12-09"));
        verifyThat("#itemList", TableViewMatchers.containsRowAtIndex(0, false, "submit practice exercises in c++", "2021-12-18"));
        verifyThat("#itemList", TableViewMatchers.containsRowAtIndex(1, false, "submit application assignment in c++ (EXTRA CREDIT)", "2021-12-12"));

    }

    @Test
    void testSaveListMenuButton(FxRobot fxRobot) {
        /*
        click on Save/Load button.
        click on save list button.
        */
        fxRobot.clickOn("Save/Load");
        fxRobot.clickOn("#saveListMenuButton");
        fxRobot.sleep(3000);
    }

    @Test
    void testLoadListMenuButton(FxRobot fxRobot) {
        /*
        click on Save/Load button.
        click on load list button.
        */
        fxRobot.clickOn("Save/Load");
        fxRobot.clickOn("#loadListMenuButton");
        fxRobot.sleep(3000);
    }


}





