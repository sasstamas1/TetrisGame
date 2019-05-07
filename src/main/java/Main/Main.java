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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;



public class Main extends Application {

    public static boolean game = false;

    public static final int MOVE = 25;
    public static final int SIZE = 25;
    public static int XMAX = SIZE * 12;
    public static int YMAX = SIZE * 24;
    public static int[][] HALO = new int[XMAX / SIZE][YMAX / SIZE];
    private static Pane group = new Pane();
    private static Scene scene = new Scene(group, XMAX + 150, YMAX);
    public static int pont = 0;
    public static String felhasznalo="";
    private static int top = 0;

    private static Form object;
    private static Form nextObj = Control.makeRect();

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
        Text scoretext = new Text("Pontsz�m:\n ");
        scoretext.setStyle("-fx-font: 20 arial;");
        scoretext.setY(50);
        scoretext.setX(XMAX + 5);
        Button kilep = new Button("Kil�p");
        kilep.setLayoutY(YMAX - 30);
        kilep.setLayoutX(XMAX + 40);
        kilep.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                uj.close();
                System.exit(0);
            }
        });

        group.getChildren().addAll(scoretext, line,kilep);

        Form form = nextObj;
        group.getChildren().addAll(form.a, form.b, form.c, form.d);

        object = form;
        moveOnKeyPress(form);
        nextObj = Control.makeRect();

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
                            Text over = new Text("J�T�K V�GE!");
                            over.setFill(Color.RED);
                            over.setStyle("-fx-font: 55 Italic;");
                            over.setY(YMAX/2);
                            over.setX(10);
                            group.getChildren().add(over);
                            game = false;

                            /**
                             * A felhaszn�l� �s a pontsz�m kiment�se adatb�zisba.
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
                            scoretext.setText("Pontsz�m:\n " + Integer.toString(pont));
                        }
                    }
                });
            }
        };
        fall.schedule(task, 0, 300);

    }


    private static void moveOnKeyPress(Form form) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case RIGHT:
                        Control.MoveRight(form);
                        break;
                    case LEFT:
                        Control.MoveLeft(form);
                        break;
                    case UP:
                        Rotate.Rotate(form);
                    case DOWN:
                        MoveDown(form);

                }
            }
        });
    }



    public static void MoveDown(Form form){
        if (form.a.getY() + MOVE < YMAX && form.b.getY() + MOVE < YMAX && form.c.getY() + MOVE < YMAX
                && form.d.getY() + MOVE < YMAX) {
            int movea = HALO[(int) form.a.getX() / SIZE][((int) form.a.getY() / SIZE) + 1];
            int moveb = HALO[(int) form.b.getX() / SIZE][((int) form.b.getY() / SIZE) + 1];
            int movec = HALO[(int) form.c.getX() / SIZE][((int) form.c.getY() / SIZE) + 1];
            int moved = HALO[(int) form.d.getX() / SIZE][((int) form.d.getY() / SIZE) + 1];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                form.a.setY(form.a.getY() + MOVE);
                form.b.setY(form.b.getY() + MOVE);
                form.c.setY(form.c.getY() + MOVE);
                form.d.setY(form.d.getY() + MOVE);
            }
            pont++;
        }
        if (form.a.getY() == YMAX - SIZE || form.b.getY() == YMAX - SIZE || form.c.getY() == YMAX - SIZE
                || form.d.getY() == YMAX - SIZE || moveA(form) || moveB(form) || moveC(form) || moveD(form)) {
            HALO[(int) form.a.getX() / SIZE][(int) form.a.getY() / SIZE] = 1;
            HALO[(int) form.b.getX() / SIZE][(int) form.b.getY() / SIZE] = 1;
            HALO[(int) form.c.getX() / SIZE][(int) form.c.getY() / SIZE] = 1;
            HALO[(int) form.d.getX() / SIZE][(int) form.d.getY() / SIZE] = 1;
            Control.DeleteRows(group);

            Form a = nextObj;
            nextObj = Control.makeRect();
            object = a;
            group.getChildren().addAll(a.a, a.b, a.c, a.d);
            moveOnKeyPress(a);
            pont++;
        }
    }


    public static boolean moveA(Form form) {
        return (HALO[(int) form.a.getX() / SIZE][((int) form.a.getY() / SIZE) + 1] == 1);
    }

    private static boolean moveB(Form form) {
        return (HALO[(int) form.b.getX() / SIZE][((int) form.b.getY() / SIZE) + 1] == 1);
    }

    private static boolean moveC(Form form) {
        return (HALO[(int) form.c.getX() / SIZE][((int) form.c.getY() / SIZE) + 1] == 1);
    }

    private static boolean moveD(Form form) {
        return (HALO[(int) form.d.getX() / SIZE][((int) form.d.getY() / SIZE) + 1] == 1);
    }

    public static void main(String[] args) {

        launch(args);

    }

}