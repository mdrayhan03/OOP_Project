package mainpkg.Rayhan.User7.Goal1_Volunteer;

import java.io.File;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.AppendableObjectOutputStream;
import mainpkg.Rayhan.User5.DashBoard5SceneFxmlController;
import mainpkg.Rayhan.User5.VolunteerCoordinator;
import mainpkg.Rayhan.User5.Goal1_Volunteer.Volunteer;
import mainpkg.Rayhan.User7.DashBoard7SceneFxmlController;
import mainpkg.Rayhan.User7.SecurityIncharge;

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
    @FXML    private Label totalLabel;
    @FXML    private Label freeLabel;
    @FXML    private Label workLabel;
    
    Alert alert ;
    SecurityIncharge user ;
    

    

    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    public SecurityIncharge get() {
        return user ;
    }
    public void set(SecurityIncharge u) {
        user = u ;
        tableShow() ;
    }
    
    public void tableShow() {
//        totalLabel.setText(Integer.toString(user.getVolunteerAmount())) ;
//        freeLabel.setText(Integer.toString(user.getVolunteerFree())) ;
//        workLabel.setText(Integer.toString(user.getVolunteerOnWork())) ;
        ObservableList<Volunteer> list = fileRead() ;
        volunteerInfoTableView.setItems(list) ;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id")) ;
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name")) ;
        pNTableColumn.setCellValueFactory(new PropertyValueFactory<>("phoneN")) ;
        addedByTableColumn.setCellValueFactory(new PropertyValueFactory<>("addedBy")) ;
    }    

    @FXML
    private void backButtonOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User7/DashBoard7SceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        DashBoard7SceneFxmlController dsc = myLoader.getController() ;
        dsc.set(user) ;

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
            Volunteer vc = user.addVolunteer(name, pN, user.getName(), user.getId()) ;
            fileWrite(vc) ;
            
            tableShow() ;
            nameTextField.clear() ;
            pNTextField.clear() ;
        }
        
        
    }
        
    private ObservableList<Volunteer> fileRead() {
        ObservableList<Volunteer> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/SIVolunteer.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Volunteer st ;
            try {
                while(true){
                    st = (Volunteer)ois.readObject();
//                    System.out.println(st);
                    studList.add(st) ;
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
    
    private void fileWrite(Volunteer stu) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("src/File/SIVolunteer.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(stu);

        } catch (IOException ex) {
            Logger.getLogger(VolunteerInfoSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(VolunteerInfoSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
    }
}
