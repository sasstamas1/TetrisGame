package Controller;

import Model.Form;
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
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


@Slf4j
public class GameController {

    public static Game game;
    public static boolean go = false;
    public static final int MOVE = 25;
    public static final int SIZE = 25;
    public static int XMAX = SIZE * 12;
    public static int YMAX = SIZE * 24;
    public static int[][] HALO = new int[XMAX / SIZE][YMAX / SIZE];
    public static Pane group = new Pane();
    private static Scene scene = new Scene(group, XMAX + 150, YMAX);;
    public static int pont = 0;
    public static String felhasznalo ="";
    public static int top = 0;

    public static Form object;
    public static Form nextObj = game.makeRect();

    public static Game getGame() {
        return game;
    }

    public static void setGame(Game game) {
        GameController.game = game;
    }

    public static int getPont() {
        return pont;
    }

    public static void setPont(int pont) {
        GameController.pont = pont;
    }

    public static String getFelhasznalo() {
        return felhasznalo;
    }

    public static void setFelhasznalo(String felhasznalo) {
        GameController.felhasznalo = felhasznalo;
    }

    /**
     * Maga a j�t�k, minden fontos folyamat ezen bel�l t�rt�nik.
     */
    @FXML
    public static void jatek(){

        log.info("Kezdodik a j�t�k");

        game = new Game();


        Stage jatekstage = new Stage();
        go = true;
        Text nametext = new Text("Felhaszn�l�:\n ");
        Text scoretext = new Text("Pontsz�m:\n ");
        Felulet(jatekstage, scoretext, nametext);


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

                        if (top == 5) {
                            // GAME OVER
                            GameOver(jatekstage);
                        }

                        if (go) {
                            game.MoveDown(object);
                            scoretext.setText("Pontsz�m:\n " + Integer.toString(pont));
                            nametext.setText("Felhaszn�l�:\n" + felhasznalo);
                        }
                    }
                });
            }
        };
        fall.schedule(task, 0, 300);

    }

    /**
     * J�t�k v�ge f�ggv�ny, abban az esetben h�v�dik meg, ha az alakzatok el�rik az ablak tetej�t.
     *
     * @param jatekstage - a j�t�khoz nyitott �j ablak
     */
    private static void GameOver(Stage jatekstage) {
        Text over = new Text("J�T�K V�GE!");
        over.setLayoutX(25);
        over.setLayoutY(YMAX / 2);
        over.setStyle("-fx-font: 45 arial;");
        over.setFill(Color.RED);
        group.getChildren().add(over);


        Injector injector = Guice.createInjector(new PersistenceModule("jpa-persistence-unit-1"));
        UsersDao usersDao = injector.getInstance(UsersDao.class);
        Users user = new Users(felhasznalo, pont);
        usersDao.persist(user);

        log.info("Elbuktad a j�t�kot");
        log.info("Felhaszn�l�: " + felhasznalo);
        log.info("Pontsz�m: " + pont);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        jatekstage.close();
        group.getChildren().removeAll();

    }

    /**
     * L�trehozza a j�t�k fel�letet, hozz� adaja a vonalat �s a sz�ks�ges alakzatokat.
     *
     * @param jatekstage -a j�t�khoz nyitott �j ablak
     * @param scoretext  - a j�t�kos pontsz�ma
     * @param nametext   - a j�t�kos felhaszn�l�neve
     */
    private static void Felulet(Stage jatekstage, Text scoretext, Text nametext) {
        for (int[] row : HALO) {
            Arrays.fill(row, 0);
        }

        Line line = new Line(XMAX, 0, XMAX, YMAX);
        scoretext.setStyle("-fx-font: 20 arial;");
        scoretext.setY(50);
        scoretext.setX(XMAX + 5);


        nametext.setStyle("-fx-font: 20 arial;");
        nametext.setY(YMAX / 2);
        nametext.setX(XMAX + 5);


        Button kilep = new Button("Kil�p");
        kilep.setLayoutY(YMAX - 30);
        kilep.setLayoutX(XMAX + 40);
        kilep.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                jatekstage.close();
                group.getChildren().removeAll();
                Injector injector = Guice.createInjector(new PersistenceModule("jpa-persistence-unit-1"));
                UsersDao usersDao = injector.getInstance(UsersDao.class);
                Users user = new Users(felhasznalo, pont);
                usersDao.persist(user);
                log.info("Kil�p�s a j�t�kb�l");
                log.info("Felhaszn�l�: " + felhasznalo);
                log.info("Pontsz�m: " + pont);
            }
        });

        group.getChildren().addAll(scoretext, nametext, line, kilep);

        Form form = nextObj;
        group.getChildren().addAll(form.a, form.b, form.c, form.d);

        object = form;
        moveOnKeyPress(form);
        nextObj = game.makeRect();

        jatekstage.setScene(scene);
        jatekstage.setTitle("TETRIS");
        jatekstage.show();
    }

    /**
     * A gombnyom�sok �rz�kel�se, objetumok mozgat�sa
     *
     * @param form a mozgatni k�v�nt objektum
     */
    public static void moveOnKeyPress(Form form) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case RIGHT:
                        game.MoveRight(form);
                        break;
                    case LEFT:
                        game.MoveLeft(form);
                        break;
                    case UP:
                        Rotate rotate = new Rotate();
                        rotate.Rotate(form);
                    case DOWN:
                        game.MoveDown(form);

                }
            }
        });
    }


}
