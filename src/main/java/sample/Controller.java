package sample;

//import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import static sample.Main.SIZE;
import static sample.Main.XMAX;

public class Controller implements Initializable {

    String felhasznalo = "";

    @FXML
    private TextField felh;
    @FXML
    private Pane basPane;
    @FXML
    private Pane alertPane;
    @FXML
    private Label alert;
    @FXML
    private Pane background;
    @FXML
    private Pane rangsor;
    @FXML
    private Pane game;
    @FXML
    public Rectangle recta,rectb,rectc,rectd;




    @FXML
    private void handleButtonAction(ActionEvent event){
        try {
            felhasznalo=felh.getText();
            System.out.println(felhasznalo);

            if(felhasznalo.isEmpty()){
                alertPane.setVisible(true);
                alert.setText("Nem adt�l meg nevet!");
                basPane.setOpacity(0.3);
                basPane.setDisable(true);
            }else
                gamestart();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    private void handlealertButton(ActionEvent event){
        alertPane.setVisible(false);
        alert.setText("");
        basPane.setOpacity(1);
        basPane.setDisable(false);
    }


    @FXML
    private void gamestart(){
        basPane.setDisable(true);
        Main.jatek();

    }

    @FXML
    private void rangsorbutton(ActionEvent event){
        basPane.setDisable(true);
        basPane.setVisible(false);
        rangsor.setDisable(false);
        rangsor.setVisible(true);
    }

    @FXML
    private void visszabutton(ActionEvent event){
        basPane.setDisable(false);
        basPane.setVisible(true);
        rangsor.setDisable(true);
        rangsor.setVisible(false);
    }


    public static Form makeReact(){
        int block = (int) (Math.random() * 70);
        String name;

        Rectangle a = new Rectangle(SIZE-1,SIZE-1),
                  b = new Rectangle(SIZE-1,SIZE-1),
                  c = new Rectangle(SIZE-1,SIZE-1),
                  d = new Rectangle(SIZE-1,SIZE-1);


        if (block < 10) {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2 - SIZE);
            b.setY(SIZE);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            d.setY(SIZE);
            name = "j";
        } else if (block < 20) {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2 - SIZE);
            b.setY(SIZE);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            d.setY(SIZE);
            name = "l";
        } else if (block < 30) {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2 - SIZE);
            c.setY(SIZE);
            d.setX(XMAX / 2);
            d.setY(SIZE);
            name = "o";
        } else if (block < 40) {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 - SIZE);
            d.setY(SIZE);
            name = "s";
        } else if (block < 50) {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            name = "t";
        } else if (block < 60) {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2 + SIZE);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE + SIZE);
            d.setY(SIZE);
            name = "z";
        } else {
            a.setX(XMAX / 2 - SIZE - SIZE);
            b.setX(XMAX / 2 - SIZE);
            c.setX(XMAX / 2);
            d.setX(XMAX / 2 + SIZE);
            name = "i";
        }
        return new Form(a, b, c, d, name);

    }


    @Override
    public void initialize(URL url, ResourceBundle rb){
        //Todo
    }
}