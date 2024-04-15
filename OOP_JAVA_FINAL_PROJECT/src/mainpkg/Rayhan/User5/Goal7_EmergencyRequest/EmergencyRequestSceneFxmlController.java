package mainpkg.Rayhan.User5.Goal7_EmergencyRequest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.Date;
import mainpkg.Rayhan.User5.DashBoard5SceneFxmlController;
import mainpkg.Rayhan.User5.Goal4_VRequest.RequestedVolunteer;
import mainpkg.Rayhan.User5.VolunteerCoordinator;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class EmergencyRequestSceneFxmlController implements Initializable {

    @FXML    private ComboBox<String> idComboBox;
    @FXML    private TableView<RequestedVolunteer> requestTableView;
    @FXML    private TableColumn<RequestedVolunteer, String> idTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, String> reasonTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, String> timeTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, String> placeTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, Date> dateTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, Integer> amountTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, String> statusTableColumn;
    @FXML    private CheckBox pendingCheckBox;
    @FXML    private CheckBox acceptedCheckBox;
    
    ObservableList<RequestedVolunteer> list = FXCollections.observableArrayList() ;
    VolunteerCoordinator user ;
  

    /**
     * Initializes the controller class.
     */
    
    public void set(VolunteerCoordinator u) {
        user = u ;
        tableShow() ;
    }
    
    public void tableShow() {
        ObservableList<RequestedVolunteer> list = fileRead() ;
        ObservableList<RequestedVolunteer> reqList = FXCollections.observableArrayList() ;
        if (acceptedCheckBox.isSelected()) {
            for (RequestedVolunteer rv : list) {
                if (rv.getStatus() == "Accepted") {
                    reqList.add(rv) ;
                }
            }
        }
        if (pendingCheckBox.isSelected()) {
            for (RequestedVolunteer rv : list) {
                if (rv.getStatus() == "Pending") {
                    reqList.add(rv) ;
                }
            }
        }
        
        else {
            reqList = list ;
        }
        requestTableView.setItems(reqList) ;
        requestTableView.setItems(list) ;
        for(RequestedVolunteer rv: list) {
            idComboBox.getItems().add(rv.getId()) ;
        }
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        reasonTableColumn.setCellValueFactory(new PropertyValueFactory<>("reason"));
        timeTableColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        placeTableColumn.setCellValueFactory(new PropertyValueFactory<>("place"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        amountTableColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
    }    

    @FXML
    private void backOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User5/DashBoard5SceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        DashBoard5SceneFxmlController dsc = myLoader.getController() ;
        dsc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Volunteer Coordinator DashBoard") ;
        stage.show() ;
    }

    @FXML
    private void acceptOnMouseClick(MouseEvent event) {
        for (RequestedVolunteer rv: list) {
            if (rv.getId().equals(idComboBox.getValue())) {
                if(user.getEmergencyRequestForVolunteer(rv.getAmount())){
                    rv.setStatus("Accepted");
                }                
            }
        }
    }
    
    private ObservableList<RequestedVolunteer> fileRead() {
        ObservableList<RequestedVolunteer> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/Campaign.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            RequestedVolunteer st ;
            try {
                while(true){
                    st = (RequestedVolunteer)ois.readObject();
                    if (st.getUserType() == user.getUserType()) {
                        studList.add(st) ;
                    }
                }
            }//end of nested try
            catch(Exception e){
                // handling code
            }//nested catch     
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } 
        finally {
            try {
                
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }           
        
        return studList ;
    }

    @FXML
    private void checkboxOnMouseClick(MouseEvent event) {
        tableShow() ;
    }
    
    
}
