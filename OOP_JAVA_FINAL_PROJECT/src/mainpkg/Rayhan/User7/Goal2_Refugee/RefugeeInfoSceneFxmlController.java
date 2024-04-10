package mainpkg.Rayhan.User7.Goal2_Refugee;

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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.Rasel.Refugee.Refugee;
import mainpkg.Rayhan.User7.SecurityIncharge;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class RefugeeInfoSceneFxmlController implements Initializable {

    @FXML    private ComboBox<Integer> idComboBox;
    @FXML    private Label nameLabel;
    @FXML    private Label pNLabel;
    @FXML    private Label emailLabel;
    @FXML    private Label dobLabel;
    @FXML    private Label shelterLabel;
    @FXML    private Label showLabel;
    
    ObservableList<Refugee> list = FXCollections.observableArrayList() ;
    SecurityIncharge user ;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    public void setComboBox() {
        for(Refugee ref: list) {
            idComboBox.getItems().add(ref.getId()) ;
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
        stage.setTitle("Security Incharge") ;
        stage.show() ;
    }

    @FXML
    private void idOnMouseClick(MouseEvent event) {
        Refugee ref = user.refugeeInfo(idComboBox.getValue(), list) ;
        if (ref != null) {
            nameLabel.setText(ref.getName()) ;
            pNLabel.setText(ref.getPhoneNo()) ;
            emailLabel.setText(ref.getEmail()) ;
            dobLabel.setText(ref.getDob()) ;
            shelterLabel.setText(ref.getName()) ;
            showLabel.setText(ref.getName()) ;
        }
    }
    
}
