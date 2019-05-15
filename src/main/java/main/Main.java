package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;


/**
 * Az alkalmazás Main class-a.
 */
@Slf4j
public class Main extends Application {


    /**
     * Az alkalmazás kezdete.
     *
     * @param primaryStage - a főmenü ablaka.
     * @throws Exception - kivételek.
     */
    public void start(Stage primaryStage) throws Exception {

        log.info("Indul a program");
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/TetrisGame.fxml"));
        primaryStage.setTitle("Tetris");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    /**
     * main függvény.
     * @param args semmit.
     */
    public static void main(String[] args) {

        launch(args);

    }

}