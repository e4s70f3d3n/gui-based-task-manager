/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Easton Vitulli
 */

package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class App extends Application {

    public static List<toDoList> lists = new ArrayList<>();
    private static Scene scene;
    public static Stage stage1;

    @Override
    public void start(Stage stage) throws IOException {
        lists = new ArrayList<>();
        scene = new Scene(viewToDoList());
        stage.setScene(scene);
        stage1 = stage;
        stage.show();
    }

    public static Parent viewToDoList() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/todolist.fxml"));
        Parent parent = fxmlLoader.load();
        return parent;
    }

    public static void main(String[] args) {
        launch();
    }
}
