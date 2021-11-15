/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Easton Vitulli
 */

package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;


public class App extends Application {

    private static Scene scene;
    public static Stage stage1;
    @FXML
    private TableView<itemProperties> itemList;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(viewToDoList());
        stage.setScene(scene);
        stage1 = stage;
        stage.show();
        stage1.setResizable(false);
    }

    private static Parent viewToDoList() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/todolist.fxml"));
        Parent parent = fxmlLoader.load();
        return parent;
    }

    public static void main(String[] args) {
        launch();
    }

}