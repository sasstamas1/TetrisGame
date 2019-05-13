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
     * A start gombot kezel? függvény. Indítja a játékot és vizsgálja, hogy van e felhasználónév.
     *
     * @param event - a gomb lenyomása esemény.
     */
    @FXML
    private void handleButtonAction(ActionEvent event){
        try {
            GameController.felhasznalo=felh.getText();
            System.out.println(GameController.felhasznalo);

            if(GameController.felhasznalo.isEmpty()){
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

    /**
     * A figyelmeztet? felület, amely jelzi ha nincs megadva felhasználónév.
     * @param event - a gombnyomás esemény.
     */
    @FXML
    private void handlealertButton(ActionEvent event){
        alertPane.setVisible(false);
        alert.setText("");
        basPane.setOpacity(1);
        basPane.setDisable(false);
    }

    /**
     * Kilépést kezel? függvény. Bezárja az egész alkalmazást.
     * @param event - a kilépés gomb lenyomása esemény.
     */
    @FXML
    private void exit(ActionEvent event){
        System.exit(0);
    }

    /**
     * Játék kezdete.
     */
    @FXML
    private void gamestart(){
        basPane.setDisable(true);
        GameController.jatek();
        gameoverPane.setVisible(true);
        gameoverPane.setDisable(false);

    }

    /**
     * A ranglistát kezel? függvény.
     * @param event a ranglista gomb lenyomása.
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
     * A ranglistából vissza lép? gombot kezel? függvény.
     * @param event - a ranglistán lév? vissza gomb lenyomása.
     */
    @FXML
    private void visszabutton(ActionEvent event){
        basPane.setDisable(false);
        basPane.setVisible(true);
        rangsor.setDisable(true);
        rangsor.setVisible(false);
    }

    /**
     * Az adatbázisból kiolvassa a ranglistát és létrehozza a táblázatot.
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