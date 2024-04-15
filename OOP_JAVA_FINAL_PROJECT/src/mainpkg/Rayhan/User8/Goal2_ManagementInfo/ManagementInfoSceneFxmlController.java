package mainpkg.Rayhan.User8.Goal2_ManagementInfo;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.Date;
import mainpkg.Rasel.CampManager.CampManager;
import mainpkg.Rayhan.User5.VolunteerCoordinator;
import mainpkg.Rayhan.User6.EducationCoordinator;
import mainpkg.Rayhan.User7.SecurityIncharge;
import mainpkg.Rayhan.User8.DashBoard8SceneFxmlController;
import mainpkg.Rayhan.User8.NGOs;
import mainpkg.Saima.User3_AidExcutive.AidExcutive;
import mainpkg.Saima.User4_Doctor.Doctor;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class ManagementInfoSceneFxmlController implements Initializable {

    @FXML    private TableView<CampManager> campManagerTableView;
    @FXML    private TableColumn<CampManager , Integer> campIdTableColumn;
    @FXML    private TableColumn<CampManager , String> campNameTableColumn;
    @FXML    private TableColumn<CampManager , String> campPNTableColumn;
    @FXML    private TableColumn<CampManager , String> campEmailTableColumn;
    @FXML    private TableColumn<CampManager , String> campDoBTableColumn;
    @FXML    private TableView<AidExcutive> aidTableView;
    @FXML    private TableColumn<AidExcutive , Integer> aidIdTableColumn;
    @FXML    private TableColumn<AidExcutive , String> aidNameTableColumn;
    @FXML    private TableColumn<AidExcutive , String> aidPNTableColumn;
    @FXML    private TableColumn<AidExcutive , String> aidEmailTableColumn;
    @FXML    private TableColumn<AidExcutive , String> aidDoBTableColumn;
    @FXML    private TableView<Doctor> doctorTableView;
    @FXML    private TableColumn<Doctor , Integer> doctorIdTableColumn;
    @FXML    private TableColumn<Doctor , String> doctorNameTableColumn;
    @FXML    private TableColumn<Doctor , String> doctorPNTableColumn;
    @FXML    private TableColumn<Doctor , String> doctorEmailTableColumn;
    @FXML    private TableColumn<Doctor , String> doctorDoBTableColumn;
    @FXML    private TableView<VolunteerCoordinator> volunteerTableView;
    @FXML    private TableColumn<VolunteerCoordinator, Integer> volunteerIdTableColumn;
    @FXML    private TableColumn<VolunteerCoordinator, String> volunteerNameTableColumn;
    @FXML    private TableColumn<VolunteerCoordinator, String> volunteerPNTableColumn;
    @FXML    private TableColumn<VolunteerCoordinator, String> volunteerEmailTableColumn;
    @FXML    private TableColumn<VolunteerCoordinator, Date> volunteerDoBTableColumn;
    @FXML    private TableView<EducationCoordinator> educationTableView;
    @FXML    private TableColumn<EducationCoordinator, Integer> educationIdTableColumn;
    @FXML    private TableColumn<EducationCoordinator, String> educationNameTableColumn;
    @FXML    private TableColumn<EducationCoordinator, String> educationPNTableColumn;
    @FXML    private TableColumn<EducationCoordinator, String> educationEmailTableColumn;
    @FXML    private TableColumn<EducationCoordinator, Date> educationDoBTableColumn;
    @FXML    private TableView<SecurityIncharge> securityTableView;
    @FXML    private TableColumn<SecurityIncharge, Integer> securityIdTableColumn;
    @FXML    private TableColumn<SecurityIncharge, String> securityNameTableColumn;
    @FXML    private TableColumn<SecurityIncharge, String> securityPNTableColumn;
    @FXML    private TableColumn<SecurityIncharge, String> securityEmailTableColumn;
    @FXML    private TableColumn<SecurityIncharge, Date> securityDoBTableColumn;
    
    NGOs user ; 
    ObservableList<VolunteerCoordinator> cmList = FXCollections.observableArrayList() ;
    ObservableList<VolunteerCoordinator> aeList = FXCollections.observableArrayList() ;
    ObservableList<VolunteerCoordinator> dcList = FXCollections.observableArrayList() ;
    ObservableList<VolunteerCoordinator> vcList = FXCollections.observableArrayList() ;
    ObservableList<EducationCoordinator> ecList = FXCollections.observableArrayList() ;
    ObservableList<SecurityIncharge> siList = FXCollections.observableArrayList() ;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    public NGOs get() {
        return user ;
    }
    
    public void tableShow() {
        campManagerTableView.setItems(fileReadCM()) ;
        aidTableView.setItems(fileReadAE()) ;
        doctorTableView.setItems(fileReadDC()) ;
        volunteerTableView.setItems(fileReadVC()) ;
        educationTableView.setItems(fileReadEC()) ;
        securityTableView.setItems(fileReadSI()) ;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//    @FXML    private TableColumn<CampManager , Integer> campIdTableColumn;
//    @FXML    private TableColumn<CampManager , String> campNameTableColumn;
//    @FXML    private TableColumn<CampManager , String> campPNTableColumn;
//    @FXML    private TableColumn<CampManager , String> campEmailTableColumn;
//    @FXML    private TableColumn<CampManager , String> campDoBTableColumn;
//    
//    @FXML    private TableColumn<AidExcutive , Integer> aidIdTableColumn;
//    @FXML    private TableColumn<AidExcutive , String> aidNameTableColumn;
//    @FXML    private TableColumn<AidExcutive , String> aidPNTableColumn;
//    @FXML    private TableColumn<AidExcutive , String> aidEmailTableColumn;
//    @FXML    private TableColumn<AidExcutive , String> aidDoBTableColumn;
//
//    @FXML    private TableColumn<Doctor , Integer> doctorIdTableColumn;
//    @FXML    private TableColumn<Doctor , String> doctorNameTableColumn;
//    @FXML    private TableColumn<Doctor , String> doctorPNTableColumn;
//    @FXML    private TableColumn<Doctor , String> doctorEmailTableColumn;
//    @FXML    private TableColumn<Doctor , String> doctorDoBTableColumn;
//
//    @FXML    private TableColumn<VolunteerCoordinator, Integer> volunteerIdTableColumn;
//    @FXML    private TableColumn<VolunteerCoordinator, String> volunteerNameTableColumn;
//    @FXML    private TableColumn<VolunteerCoordinator, String> volunteerPNTableColumn;
//    @FXML    private TableColumn<VolunteerCoordinator, String> volunteerEmailTableColumn;
//    @FXML    private TableColumn<VolunteerCoordinator, Date> volunteerDoBTableColumn;
//
//    @FXML    private TableColumn<EducationCoordinator, Integer> educationIdTableColumn;
//    @FXML    private TableColumn<EducationCoordinator, String> educationNameTableColumn;
//    @FXML    private TableColumn<EducationCoordinator, String> educationPNTableColumn;
//    @FXML    private TableColumn<EducationCoordinator, String> educationEmailTableColumn;
//    @FXML    private TableColumn<EducationCoordinator, Date> educationDoBTableColumn;
//
//    @FXML    private TableColumn<SecurityIncharge, Integer> securityIdTableColumn;
//    @FXML    private TableColumn<SecurityIncharge, String> securityNameTableColumn;
//    @FXML    private TableColumn<SecurityIncharge, String> securityPNTableColumn;
//    @FXML    private TableColumn<SecurityIncharge, String> securityEmailTableColumn;
//    @FXML    private TableColumn<SecurityIncharge, Date> securityDoBTableColumn;
        
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
        stage.setTitle("Education Coordinator") ;
        stage.show() ;
    }
    
    private ObservableList<CampManager> fileReadCM() {
        ObservableList<CampManager> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/CampManager.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            CampManager st ;
            try {
                while(true){
                    st = (CampManager)ois.readObject();
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
    
        private ObservableList<AidExcutive> fileReadAE() {
        ObservableList<AidExcutive> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/AidExcutive.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            AidExcutive st ;
            try {
                while(true){
                    st = (AidExcutive)ois.readObject();
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
        
        private ObservableList<Doctor> fileReadDC() {
        ObservableList<Doctor> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/Doctor.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Doctor st ;
            try {
                while(true){
                    st = (Doctor)ois.readObject();
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
    
        private ObservableList<VolunteerCoordinator> fileReadVC() {
        ObservableList<VolunteerCoordinator> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/VolunteerCoordinator.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            VolunteerCoordinator st ;
            try {
                while(true){
                    st = (VolunteerCoordinator)ois.readObject();
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
    
        private ObservableList<EducationCoordinator> fileReadEC() {
        ObservableList<EducationCoordinator> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/EducationCoordinator.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            EducationCoordinator st ;
            try {
                while(true){
                    st = (EducationCoordinator)ois.readObject();
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
        
    private ObservableList<SecurityIncharge> fileReadSI() {
        ObservableList<SecurityIncharge> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/SecurityIncharge.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            SecurityIncharge st ;
            try {
                while(true){
                    st = (SecurityIncharge)ois.readObject();
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
    
}
