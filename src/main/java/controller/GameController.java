package controller;

import model.Form;
import model.Game;
import model.Rotate;
import users.Users;
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
    /**
     * mozgas nagysaga
     */
    public static final int MOVE = 25;
    /**
     * a blokkok merete
     */
    public static final int SIZE = 25;
    /**
     * a jatekter szelessege
     */
    public static int XMAX = SIZE * 12;
    /**
     * a jatekter magassaga
     */
    public static int YMAX = SIZE * 24;
    /**
     * a jatekterhez tartozo 2 dimenzios matrix. 12*24
     */
    public static int[][] HALO = new int[XMAX / SIZE][YMAX / SIZE];
    public static Pane group = new Pane();
    /**
     * a jatekablaka, jatekter + oldalsav
     */
    private static Scene scene = new Scene(group, XMAX + 150, YMAX);;
    public static int pont = 0;
    public static String felhasznalo ="";
    public static int top = 0;

    public static Form object;
    /**
     * a kovetkezo alakzat letrehozasa, {@code makeRandom()} fuggveny segitsegevel.
     */
    public static Form nextObj = game.makeRect(makeRandom());


    public static int getPont() {
        return pont;
    }

    public static void setPont(int pont) {
        GameController.pont = pont;
    }

    /**
     * Maga a jatek, minden fontos folyamat ezen belol tortonik.
     */
    @FXML
    public static void jatek(){

        log.info("Kezdodik a jatek");

        game = new Game();


        Stage jatekstage = new Stage();
        go = true;
        Text nametext = new Text("Felhasznalo:\n ");
        Text scoretext = new Text("Pontszam:\n ");
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
                            scoretext.setText("Pontszam:\n " + Integer.toString(pont));
                            nametext.setText("Felhasznalo:\n" + felhasznalo);
                        }
                    }
                });
            }
        };
        fall.schedule(task, 0, 300);

    }

    /**
     * Jatek vege fuggveny, abban az esetben hivodik meg, ha az alakzatok elerik az ablak tetejet.
     *
     * @param jatekstage - a jatekhoz nyitott uj ablak
     */
    private static void GameOver(Stage jatekstage) {
        Text over = new Text("JATEK VEGE!");
        over.setLayoutX(25);
        over.setLayoutY(YMAX / 2);
        over.setStyle("-fx-font: 45 arial;");
        over.setFill(Color.RED);
        group.getChildren().add(over);


        Injector injector = Guice.createInjector(new PersistenceModule("jpa-persistence-unit-1"));
        UsersDao usersDao = injector.getInstance(UsersDao.class);
        Users user = new Users(felhasznalo, pont);
        usersDao.persist(user);

        log.info("Elbuktad a jatekot");
        log.info("Felhasznalo: " + felhasznalo);
        log.info("Pontszam: " + pont);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        jatekstage.close();
        group.getChildren().removeAll();

    }

    /**
     * Letrehozza a jatek feluletet, hozza adaja a vonalat es a szukseges alakzatokat.
     *
     * @param jatekstage -a jatekhoz nyitott uj ablak
     * @param scoretext  - a jatekos pontszama
     * @param nametext   - a jatekos felhasznaloneve
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
                log.info("Kilepes a jatekbol");
                log.info("Felhasznolo: " + felhasznalo);
                log.info("Pontszam: " + pont);
            }
        });

        group.getChildren().addAll(scoretext, nametext, line, kilep);

        Form form = nextObj;
        group.getChildren().addAll(form.a, form.b, form.c, form.d);

        object = form;
        moveOnKeyPress(form);
        nextObj = game.makeRect(makeRandom());

        jatekstage.setScene(scene);
        jatekstage.setTitle("TETRIS");
        jatekstage.show();
    }

    /**
     * A gombnyomasok erzekelese, objetumok mozgatesa
     *
     * @param form a mozgatni kivant objektum
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

    /**
     * Random szam generalasa 0-70 között.
     *
     * @return a random szam
     */
    public static int makeRandom() {
        return (int) (Math.random() * 70);
    }


}
