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
                alert.setText("Nem adtál meg nevet!");
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

    @Override
    public void initialize(URL url, ResourceBundle rb){
        //Todo
    }
}