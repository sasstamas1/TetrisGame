package Controller;


import java.net.URL;
import java.util.ResourceBundle;

import com.google.inject.Guice;
import com.google.inject.Injector;
import dao.UsersDao;
import guice.PersistenceModule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class MenuController implements Initializable {

    @FXML
    private TextField felh;
    @FXML
    private Pane basPane;
    @FXML
    public Pane alertPane;
    @FXML
    private Label alert;
    @FXML
    private Pane rangsor;
    @FXML
    private TableView rang;
    @FXML
    private Pane gameoverPane;


    /**
     * A start gombot kezel? f�ggv�ny. Ind�tja a j�t�kot �s vizsg�lja, hogy van e felhaszn�l�n�v.
     *
     * @param event - a gomb lenyom�sa esem�ny.
     */
    @FXML
    private void handleButtonAction(ActionEvent event){
        try {
            GameController.felhasznalo=felh.getText();
            System.out.println(GameController.felhasznalo);

            if(GameController.felhasznalo.isEmpty()){
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

    /**
     * A figyelmeztet? fel�let, amely jelzi ha nincs megadva felhaszn�l�n�v.
     * @param event - a gombnyom�s esem�ny.
     */
    @FXML
    private void handlealertButton(ActionEvent event){
        alertPane.setVisible(false);
        alert.setText("");
        basPane.setOpacity(1);
        basPane.setDisable(false);
    }

    /**
     * Kil�p�st kezel? f�ggv�ny. Bez�rja az eg�sz alkalmaz�st.
     * @param event - a kil�p�s gomb lenyom�sa esem�ny.
     */
    @FXML
    private void exit(ActionEvent event){
        System.exit(0);
    }

    /**
     * J�t�k kezdete.
     */
    @FXML
    private void gamestart(){
        basPane.setDisable(true);
        GameController.jatek();
        gameoverPane.setVisible(true);
        gameoverPane.setDisable(false);

    }

    /**
     * A ranglist�t kezel? f�ggv�ny.
     * @param event a ranglista gomb lenyom�sa.
     */
    @FXML
    private void rangsorbutton(ActionEvent event){
        basPane.setDisable(true);
        basPane.setVisible(false);
        rangsor.setDisable(false);
        rangsor.setVisible(true);
        Ranglista();
    }

    /**
     * A ranglist�b�l vissza l�p? gombot kezel? f�ggv�ny.
     * @param event - a ranglist�n l�v? vissza gomb lenyom�sa.
     */
    @FXML
    private void visszabutton(ActionEvent event){
        basPane.setDisable(false);
        basPane.setVisible(true);
        rangsor.setDisable(true);
        rangsor.setVisible(false);
    }

    /**
     * Az adatb�zisb�l kiolvassa a ranglist�t �s l�trehozza a t�bl�zatot.
     */
    @FXML
    private void Ranglista(){
        Injector injector = Guice.createInjector(new PersistenceModule("jpa-persistence-unit-1"));
        UsersDao usersDao = injector.getInstance(UsersDao.class);
        TableColumn id = new TableColumn("id");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn nameColumn = new TableColumn("name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn score = new TableColumn("score");
        score.setCellValueFactory(new PropertyValueFactory<>("score"));
        rang.getItems().clear();
        rang.getColumns().clear();

        rang.getColumns().addAll(id,nameColumn,score);
        rang.getItems().addAll(usersDao.getTopTen());

    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        //Todo
    }
}