package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Arrays;


public class Main extends Application {

    public static boolean game = false;

    public static final int MOVE = 30;
    public static final int SIZE = 30;
    public static int XMAX = SIZE * 12;
    public static int YMAX = SIZE * 24;
    public static int[][] MESH = new int[XMAX / SIZE][YMAX / SIZE];
    private static Pane group = new Pane();
    private static Scene scene = new Scene(group, XMAX + 150, YMAX);
    public static int score = 0;
    private static int top = 0;
    private static int linesNo;

    private static Form object;
    private static Form nextObj = Controller.makeRect();


    static {
        linesNo = 0;
    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample.fxml"));
        primaryStage.setTitle("Tetris");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void jatek(){
        Stage uj = new Stage();
        game = true;

        for (int[] row : MESH) {
            Arrays.fill(row, 0);
        }

        Line line = new Line(XMAX, 0, XMAX, YMAX);
        Text scoretext = new Text("Pontszám: ");
        scoretext.setStyle("-fx-font: 20 arial;");
        scoretext.setY(50);
        scoretext.setX(XMAX + 5);
        Text level = new Text("Sorok: ");
        level.setStyle("-fx-font: 20 arial;");
        level.setY(100);
        level.setX(XMAX + 5);
        level.setFill(Color.GREEN);
        group.getChildren().addAll(scoretext, line, level);

        Form a = nextObj;
        group.getChildren().addAll(a.a, a.b, a.c, a.d);
        object = a;
        nextObj = Controller.makeRect();

        uj.setScene(scene);
        uj.setTitle("T E T R I S");
        uj.show();

    }

    public static void main(String[] args) {

        launch(args);

    }

}