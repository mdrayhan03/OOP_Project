package mainpkg.Rayhan.User7.Goal5_CrimeFacts;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class CrimeFactsSceneFxmlController implements Initializable {

    @FXML    private TextArea descriptionTextArea;
    @FXML    private ComboBox<String> crimeIdComboBox;
    @FXML    private TableView<CrimeFact> crimeTableView;
    @FXML    private TableColumn<CrimeFact , String> idTableColumn;
    @FXML    private TableColumn<CrimeFact , Integer> reporterIdTableColumn;
    @FXML    private TableColumn<CrimeFact , String> nameTableColumn;
    @FXML    private TableColumn<CrimeFact , String> descriptionTableColumn;
    @FXML    private Label reporterIdLabel;
    
    ObservableList<CrimeFact> list = FXCollections.observableArrayList() ;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    public void tableShow() {
        crimeTableView.setItems(list) ;
    }
    
    public void setComboBox() {
        for (CrimeFact cf: list) {
            crimeIdComboBox.getItems().add(cf.getId()) ;
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User7/DashBoard7SceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Security Incharge DashBoard") ;
        stage.show() ;
    }

    @FXML
    private void idComboBoxOnMouseClick(MouseEvent event) {
        for (CrimeFact cf: list) {
            if (cf.getId() == crimeIdComboBox.getValue()) {
                reporterIdLabel.setText(cf.getReporterName()) ;
                descriptionTextArea.setText(cf.getDes()) ;
                break ;
            }
        }
    }
    
}
