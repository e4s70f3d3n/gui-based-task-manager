package ucf.assignments;

import com.sun.javafx.scene.control.DatePickerContent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.matcher.control.*;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.assertions.api.Assertions.assertThat;
import static org.testfx.matcher.control.TableViewMatchers.hasTableCell;
import static ucf.assignments.App.viewToDoList;

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

    }

    @Test
    void testAddItemButton(FxRobot fxRobot) {
        fxRobot.clickOn("#itemDescriptionTextField");
        fxRobot.write("submit application assignment 1, part 2");

        fxRobot.moveTo(770, 600);
        fxRobot.clickOn(770, 600);
        fxRobot.moveTo(770, 550);
        fxRobot.clickOn(770, 550);
        fxRobot.clickOn("#addItemButton");

        verifyThat("#itemList", hasTableCell("submit application assignment 1, part 2"));

    }

    @Test
    void testClearListButton(FxRobot fxRobot) {
        fxRobot.clickOn("Clear List");
        verifyThat("#itemList", NodeMatchers.hasChild(""));
    }

    @org.junit.Test
    void addItem() {
                /*
                test a string value in the description text bar.
                get the actual value from the function.
                set an expected value based on input.
                assert actual and expected equals to each other.
                 */
    }

    @org.junit.Test
    void backToList() {
                /*
                set the expected scene.
                get actual scene.
                assert the expected and actual scenes as equal to each other.
                 */
    }

    @org.junit.Test
    void filterItems() {
                 /*
                set expected array list of all todolist values.
                get actual array list of all todolist values.
                use assertArrayEquals to verify expected and actual are true.
                 */
    }

    @org.junit.Test
    void checkComplete() {
                /*
                set expected array of completed todolist values.
                get actual values that start as uncompleted values but
                should be marked as completed if the function works properly.
                use assertArrayEquals to determine if actual equals expected.
                 */
    }

    @org.junit.Test
    void removeItem() {
                /*
                test an empty string value in the description text bar.
                get the actual value from the function.
                assert actual and expected equals to each other.
                 */
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
    void showUncompletedFilter() {
                /*
                set expected array list of uncompleted todolist values.
                get actual array list of uncompleted todolist values.
                use assertArrayEquals to verify expected and actual are true.
                */
    }

    @org.junit.Test
    void sortByDueDateFilter() {
                /*
                set expected array list of sorted todolist values.
                get actual array list of sorted todolist values.
                use assertArrayEquals to verify expected and actual are true.
                 */
    }
}



