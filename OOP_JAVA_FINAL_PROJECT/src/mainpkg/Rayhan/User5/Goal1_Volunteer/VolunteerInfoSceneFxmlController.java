package mainpkg.Rayhan.User5.Goal1_Volunteer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.User;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class VolunteerInfoSceneFxmlController implements Initializable {

    @FXML    private TableView<Volunteer> volunteerInfoTableView;
    @FXML    private TableColumn<Volunteer, String> idTableColumn;
    @FXML    private TableColumn<Volunteer, String> nameTableColumn;
    @FXML    private TableColumn<Volunteer, String> pNTableColumn;
    @FXML    private TableColumn<Volunteer, String> addedByTableColumn;
    @FXML    private TextField nameTextField;
    @FXML    private TextField pNTextField;
    
    Alert alert ;
    User user ;
    ObservableList<Volunteer> listobj = FXCollections.observableArrayList() ;
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    public User get() {
        return user ;
    }
    public void set(User u) {
        user = u ;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idTableColumn.setCellValueFactory(new PropertyValueFactory<Volunteer,String>("id")) ;
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<Volunteer,String>("name")) ;
        pNTableColumn.setCellValueFactory(new PropertyValueFactory<Volunteer,String>("phoneN")) ;
        addedByTableColumn.setCellValueFactory(new PropertyValueFactory<Volunteer,String>("addedBy")) ;
        
        try {
            //        ObservableList<Volunteer> listobj = FXCollections.observableArrayList() ;
//        FileInputStream fis = null ;
//        ObjectInputStream ois = null ;
//        try {
//            fis = new FileInputStream("src/File/VolunteerInfo.bin") ;
//            ois = new ObjectInputStream(fis) ;
//            while (true) {
//               listobj.add((Volunteer) ois.readObject()) ;
//            } 
//        }
//        catch (Exception e) {
//        }

            volunteerInfoTableView.setItems(this.fileRead()) ;
        } 
        catch (IOException ex) {
            Logger.getLogger(VolunteerInfoSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void backButtonOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User5/DashBoard5SceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Volunteer Coordinator DashBoard") ;
        stage.show() ;
    }

    @FXML
    private void addVolunteerOnMouseClick(MouseEvent event) throws IOException {
        String name = "" ;
        String pN = "" ;
        Boolean rtn = true ;
        
        name = nameTextField.getText() ;
        pN = pNTextField.getText() ;
        
        if (name.length() == 0) {
            rtn = false ;
            alert = new Alert(Alert.AlertType.WARNING) ;
            alert.setHeaderText("Name Error");
            alert.setContentText("Name is must");
            alert.showAndWait() ;
        }
        if (pN.length() != 11) {
            rtn = false ;
            alert = new Alert(Alert.AlertType.WARNING) ;
            alert.setHeaderText("Phone No Error");
            alert.setContentText("Phone No is must 11 digits.");
            alert.showAndWait() ;
        }
        
        if (rtn == true) {
            Volunteer vc = new Volunteer (name , pN , user.getName()) ;
            fileWrite(vc) ;
            alert = new Alert(Alert.AlertType.INFORMATION) ;
            alert.setHeaderText("Done");
            alert.setContentText("Exception : " ) ;
            alert.showAndWait() ;
        }
        
        nameTextField.clear() ;
        pNTextField.clear() ;
    }
    
    private void fileWrite(Volunteer vc) {
        try {
            FileOutputStream fos = new FileOutputStream("src/File/VolunteerInfo.bin" , true) ;
            ObjectOutputStream oos = new ObjectOutputStream(fos) ;
            oos.writeObject(vc) ;
            oos.close() ;
        }
        catch (Exception e) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Exception Error");
            alert.setContentText("Exception : " + e.getClass().getName()) ;
            alert.showAndWait() ;
        } 
    }
    
    private ObservableList<Volunteer> fileRead() throws IOException {
        FileInputStream fis = null ;
        ObjectInputStream ois = null ;
        try {
            fis = new FileInputStream("src/File/VolunteerInfo.bin") ;
            ois = new ObjectInputStream(fis) ;
            while (true) {
               listobj.add((Volunteer) ois.readObject()) ;
            } 
        }
        catch (Exception e) {
            ois.close() ;
//            alert = new Alert(Alert.AlertType.WARNING) ;
//            alert.setHeaderText("File Warning.");
//            alert.setContentText("File not found.") ;
//            alert.showAndWait() ;
        }
        return listobj ;
    }
    
}
