package Main;

import Controller.*;
import Users.Users;
import com.google.inject.Guice;
import com.google.inject.Injector;
import dao.UsersDao;
import guice.PersistenceModule;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import static Controller.GameController.MoveDown;


public class Main extends Application {

    public static boolean game = false;

    public static final int MOVE = 25;
    public static final int SIZE = 25;
    public static int XMAX = SIZE * 12;
    public static int YMAX = SIZE * 24;
    public static int[][] HALO = new int[XMAX / SIZE][YMAX / SIZE];
    public static Pane group = new Pane();
    private static Scene scene = new Scene(group, XMAX + 150, YMAX);
    public static int pont = 0;
    public static String felhasznalo="";
    private static int top = 0;

    public static From object;
    public static From nextObj = GameController.makeRect();

    public void start(Stage primaryStage) throws Exception {


        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/sample.fxml"));
        primaryStage.setTitle("Tetris");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void jatek(){
        Stage uj = new Stage();
        game = true;

        for (int[] row : HALO) {
            Arrays.fill(row, 0);
        }

        Line line = new Line(XMAX, 0, XMAX, YMAX);
        Text scoretext = new Text("Pontszám:\n ");
        scoretext.setStyle("-fx-font: 20 arial;");
        scoretext.setY(50);
        scoretext.setX(XMAX + 5);
        Button kilep = new Button("Kilép");
        kilep.setLayoutY(YMAX - 30);
        kilep.setLayoutX(XMAX + 40);
        kilep.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                uj.close();
                Injector injector = Guice.createInjector(new PersistenceModule("jpa-persistence-unit-1"));
                UsersDao usersDao = injector.getInstance(UsersDao.class);
                Users user = new Users(felhasznalo,pont);
                usersDao.persist(user);
                System.exit(0);
            }
        });

        group.getChildren().addAll(scoretext,line,kilep);

        From form = nextObj;
        group.getChildren().addAll(form.a, form.b, form.c, form.d);

        object = form;
        moveOnKeyPress(form);
        nextObj = GameController.makeRect();

        uj.setScene(scene);
        uj.setTitle("T E T R I S");
        uj.show();


        Timer fall = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        if (object.a.getY() == 0 || object.b.getY() == 0 || object.c.getY() == 0
                                || object.d.getY() == 0)
                            top++;
                        else
                            top = 0;

                        if (top == 3) {
                            // GAME OVER
                            Text over = new Text("JÁTÉK VÉGE!");
                            over.setFill(Color.RED);
                            over.setStyle("-fx-font: 55 Italic;");
                            over.setY(YMAX/2);
                            over.setX(10);
                            group.getChildren().add(over);
                            game = false;

                            /**
                             * A felhasználó és a pontszám kimentése adatbázisba.
                             */
                            Injector injector = Guice.createInjector(new PersistenceModule("jpa-persistence-unit-1"));
                            UsersDao usersDao = injector.getInstance(UsersDao.class);
                            Users user = new Users(felhasznalo,pont);
                            usersDao.persist(user);

                        }
                        // Exit
                        if (top == 6) {
                            System.exit(0);
                        }

                        if (game) {
                            MoveDown(object);
                            scoretext.setText("Pontszám:\n " + Integer.toString(pont));
                        }
                    }
                });
            }
        };
        fall.schedule(task, 0, 300);

    }


    public static void moveOnKeyPress(From form) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case RIGHT:
                        GameController.MoveRight(form);
                        break;
                    case LEFT:
                        GameController.MoveLeft(form);
                        break;
                    case UP:
                        RotateController.Rotate(form);
                    case DOWN:
                        MoveDown(form);

                }
            }
        });
    }


    public static void main(String[] args) {

        launch(args);

    }

}