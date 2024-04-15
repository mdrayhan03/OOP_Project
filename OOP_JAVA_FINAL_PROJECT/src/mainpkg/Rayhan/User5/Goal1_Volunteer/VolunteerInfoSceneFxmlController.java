package mainpkg.Rayhan.User5.Goal1_Volunteer;

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
import mainpkg.Rayhan.User5.DashBoard5SceneFxmlController;
import mainpkg.Rayhan.User5.VolunteerCoordinator;
import mainpkg.AbstractClass.AppendableObjectOutputStream;

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
    @FXML    private TableColumn<Volunteer, String> statusTableColumn;
    @FXML    private TextField nameTextField;
    @FXML    private TextField pNTextField;
    @FXML    private Label totalLabel;
    @FXML    private Label freeLabel;
    @FXML    private Label workLabel;
    @FXML    private CheckBox workCheckBox;
    @FXML    private CheckBox freeCheckBox;
    
    Alert alert ;
    VolunteerCoordinator user ;


    

    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    public VolunteerCoordinator get() {
        return user ;
    }
    
    public void set(VolunteerCoordinator u) {
        user = u ;
        System.out.println(user) ;
        tableShow() ;
    }
    
    public void tableShow() {
        ObservableList<Volunteer> list = fileRead() ;
        volunteerInfoTableView.getItems().clear() ; 
        totalLabel.setText(Integer.toString(list.size())) ;
        int work = 0 , free = 0;
        for (Volunteer vn: list) {
            if ("Work".equals(vn.getStatus())) {
                work++ ;
            }
            else if ("Free".equals(vn.getStatus())) {
                free++ ;           
            }
        }
        freeLabel.setText(Integer.toString(free)) ;
        workLabel.setText(Integer.toString(work)) ;
        ObservableList<Volunteer> rlist = FXCollections.observableArrayList() ;
        
        if (workCheckBox.isSelected()) {
            for (Volunteer vc : list) {
                if("Work".equals(vc.getStatus())) {
                    rlist.add(vc) ;
                }
            }
        }
        
        if (freeCheckBox.isSelected()) {
            for (Volunteer vc : list) {
                if("Free".equals(vc.getStatus())) {
                    rlist.add(vc) ;
                }
            }
        }
        
        if (workCheckBox.isSelected() && freeCheckBox.isSelected() || !workCheckBox.isSelected() && !freeCheckBox.isSelected()) {
            rlist = list ;
        }
        
       System.out.println(rlist) ;
       volunteerInfoTableView.setItems(rlist) ;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id")) ;
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name")) ;
        pNTableColumn.setCellValueFactory(new PropertyValueFactory<>("phoneN")) ;
        addedByTableColumn.setCellValueFactory(new PropertyValueFactory<>("addedBy")) ;
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status")) ;
    }    

    @FXML
    private void backButtonOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User5/DashBoard5SceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        DashBoard5SceneFxmlController dsc = myLoader.getController() ;
        dsc.set(this.get()) ;

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
            f = new File("src/File/VCVolunteer.bin");
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
            f = new File("src/File/VCVolunteer.bin");
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

    @FXML
    private void checkBoxOnMouseClick(MouseEvent event) {
        tableShow() ;
    }

    
}
