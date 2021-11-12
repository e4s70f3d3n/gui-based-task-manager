package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.robot.Robot;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.matcher.control.*;

import java.io.IOException;

import static javafx.scene.control.cell.CheckBoxTableCell.forTableColumn;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.assertions.api.Assertions.assertThat;
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

    @AfterEach
    void tearDown() {
    }

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
        fxRobot.clickOn("#itemDescriptionTextField");
        fxRobot.write("submit application assignment 1, part 2");
        verifyThat("#itemDescriptionTextField", TextInputControlMatchers.hasText("submit application assignment 1, part 2"));
    }

    @Test
    void testDatePicker(FxRobot fxRobot) {
        fxRobot.clickOn(770, 600);
        fxRobot.clickOn(750, 540);
    }

    @Test
    void testAddItemButton(FxRobot fxRobot) {
         /*
         test a string value in the description text bar.
         get the actual value from the function.
         set an expected value based on input.
         assert actual and expected equals to each other.
          */

        verifyThat("#itemList", hasTableCell("submit application assignment 1, part 2"));
    }

    @Test
    void testClearListButton(FxRobot fxRobot) {
        fxRobot.clickOn("Clear List");
        verifyThat("#itemList", NodeMatchers.hasChild(""));
    }

    @org.junit.Test
    void filterItems() {
         /*
        set expected array list of all todolist values.
        get actual array list of all todolist values.
        use assertArrayEquals to verify expected and actual are true.
         */
    }

    @Test
    void checkCompleted(FxRobot fxRobot) {
        /*
        set expected array of completed todolist values.
        get actual values that start as uncompleted values but
        should be marked as completed if the function works properly.
        use assertArrayEquals to determine if actual equals expected.
         */

        fxRobot.clickOn(450, 228);
        verifyThat("#itemList", TableViewMatchers.containsRow(true, "submit application assignment 1, part 2", "2021-12-07"));
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
        verifyThat("#itemList", TableViewMatchers.hasNumRows(2));

    }

    @Test
    void showCompletedFilter(FxRobot fxRobot) {
        /*
        set expected array list of completed todolist values.
        get actual array list of completed todolist values.
        use assertArrayEquals to verify expected and actual are true.
         */

        fxRobot.clickOn(455, 228);
        fxRobot.clickOn(455, 283);
        fxRobot.clickOn("Filter Items");
        fxRobot.clickOn("#showCompletedMenuButton");
        verifyThat("#itemList", TableViewMatchers.hasNumRows(2));
        verifyThat("#itemList", TableViewMatchers.containsRow(true, "submit application assignment 1, part 2", "2021-12-07"));
        verifyThat("#itemList", TableViewMatchers.containsRow(true, "submit logic project", "2021-12-09"));

    }

    @org.junit.Test
    void showEntireList() {
                 /*
                set expected array list of all todolist values.
                get actual array list of all todolist values.
                use assertArrayEquals to verify expected and actual are true.
                 */
    }

    @org.junit.Test
    void showUncompletedFilter() {
                /*
                set expected array list of uncompleted todolist values.
                get actual array list of uncompleted todolist values.
                use assertArrayEquals to verify expected and actual are true.
                */
    }

    @org.junit.Test
    void sortByDueDateAscendingFilter() {
                 /*
                set expected array list of all todolist values.
                get actual array list of all todolist values.
                use assertArrayEquals to verify expected and actual are true.
                 */
    }

    @org.junit.Test
    void sortByDueDateDescendingFilter() {
                 /*
                set expected array list of all todolist values.
                get actual array list of all todolist values.
                use assertArrayEquals to verify expected and actual are true.
                 */
    }
}



