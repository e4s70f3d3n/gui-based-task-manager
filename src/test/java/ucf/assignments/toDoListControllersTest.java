package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.matcher.control.*;

import java.io.IOException;

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

        fxRobot.clickOn("#itemDescriptionTextField");
        fxRobot.write("submit application assignment 1, part 2");
        fxRobot.clickOn(770, 600);
        fxRobot.clickOn(725, 575);
        fxRobot.clickOn("#addItemButton");

        verifyThat("#itemList", hasTableCell("submit application assignment 1, part 2"));
    }

    @Test
    void testClearListButton(FxRobot fxRobot) {
        fxRobot.clickOn("#itemDescriptionTextField");
        fxRobot.write("submit application assignment 1, part 2");

        fxRobot.clickOn(770, 600);
        fxRobot.clickOn(725, 575);
        fxRobot.clickOn("#addItemButton");

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
    void checkComplete(FxRobot fxRobot) {
        /*
        set expected array of completed todolist values.
        get actual values that start as uncompleted values but
        should be marked as completed if the function works properly.
        use assertArrayEquals to determine if actual equals expected.
         */

    }

    @Test
    void removeItem(FxRobot fxRobot) {
        /*
        test an empty string value in the description text bar.
        get the actual value from the function.
        assert actual and expected equals to each other.
         */

        fxRobot.clickOn("#itemDescriptionTextField");
        fxRobot.write("submit application assignment 1, part 2");

        fxRobot.clickOn(770, 600);
        fxRobot.clickOn(725, 575);
        fxRobot.clickOn("#addItemButton");

        fxRobot.clickOn(770, 225);
        fxRobot.clickOn("#removeItemButton");
        verifyThat("#itemList", NodeMatchers.hasChild(""));

    }

    @org.junit.Test
    void showCompletedFilter() {
                /*
                set expected array list of completed todolist values.
                get actual array list of completed todolist values.
                use assertArrayEquals to verify expected and actual are true.
                 */
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



