package Controller;

import Model.From;
import Model.Game;
import Model.Rotate;
import Users.Users;
import com.google.inject.Guice;
import com.google.inject.Injector;
import dao.UsersDao;
import guice.PersistenceModule;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import static Model.Game.MoveDown;

public class GameController {


    public static boolean game = false;
    public static final int MOVE = 25;
    public static final int SIZE = 25;
    public static int XMAX = SIZE * 12;
    public static int YMAX = SIZE * 24;
    public static int[][] HALO = new int[XMAX / SIZE][YMAX / SIZE];
    public static Pane group = new Pane();
    public static Scene scene = new Scene(group, XMAX + 150, YMAX);
    public static int pont = 0;
    public static String felhasznalo="";
    private static int top = 0;

    public static From object;
    public static From nextObj = Game.makeRect();

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
        Text nametext = new Text("Felhasználó:\n  " + felhasznalo);
        nametext.setStyle("-fx-font: 20 arial;");
        nametext.setY(YMAX/2);
        nametext.setX(XMAX + 5);
        Button kilep = new Button("Kilép");
        kilep.setLayoutY(YMAX - 30);
        kilep.setLayoutX(XMAX + 40);
        kilep.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                uj.close();
                Injector injector = Guice.createInjector(new PersistenceModule("jpa-persistence-unit-1"));
                UsersDao usersDao = injector.getInstance(UsersDao.class);
                Users user = new Users(felhasznalo, pont);
                usersDao.persist(user);
            }
        });

        group.getChildren().addAll(scoretext,nametext,line,kilep);

        From form = nextObj;
        group.getChildren().addAll(form.a, form.b, form.c, form.d);

        object = form;
        GameController.moveOnKeyPress(form);
        nextObj = Game.makeRect();

        uj.setScene(scene);
        uj.setTitle("TETRIS");
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
                            nametext.setText("Felhasználó:\n" + felhasznalo);
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
                        Game.MoveRight(form);
                        break;
                    case LEFT:
                        Game.MoveLeft(form);
                        break;
                    case UP:
                        Rotate.Rotate(form);
                    case DOWN:
                        MoveDown(form);

                }
            }
        });
    }


}

