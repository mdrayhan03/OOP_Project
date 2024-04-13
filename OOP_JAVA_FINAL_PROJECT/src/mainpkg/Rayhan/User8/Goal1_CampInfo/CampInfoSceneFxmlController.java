package mainpkg.Rayhan.User8.Goal1_CampInfo;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.Rasel.Refugee.Refugee;
import mainpkg.Rayhan.User8.DashBoard8SceneFxmlController;
import mainpkg.Rayhan.User8.NGOs;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class CampInfoSceneFxmlController implements Initializable {

    @FXML    private Label doctorLabel;
    @FXML    private Label totalRefugeeLabel;
    @FXML    private Label maleRefugeeLabel;
    @FXML    private Label femaleRefugeeLabel;
    @FXML    private Label teacherLabel;
    @FXML    private Label volunteerLabel;
    @FXML    private Label studentLabel;
    
    NGOs user ;
    ObservableList<Refugee> refList = FXCollections.observableArrayList() ;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    public NGOs get() {
        return user ;
    }
    
    public void set(NGOs u) {
        user = u ;
    }
    
    public void setter() {
        ArrayList<Integer> list = user.campInfo(refList) ;
        
        totalRefugeeLabel.setText(Integer.toString(list.get(0))) ;
        maleRefugeeLabel.setText(Integer.toString(list.get(1))) ;
        femaleRefugeeLabel.setText(Integer.toString(list.get(2))) ;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;                  
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User8/DashBoard8SceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
                    
        DashBoard8SceneFxmlController dsc = myLoader.getController() ;
        dsc.set(user) ; 

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("NGO DashBoard") ;
        stage.show() ;
    }
    
}
