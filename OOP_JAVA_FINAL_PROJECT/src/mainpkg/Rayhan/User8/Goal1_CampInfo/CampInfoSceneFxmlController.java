package mainpkg.Rayhan.User8.Goal1_CampInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
import mainpkg.Rayhan.User5.Goal1_Volunteer.Volunteer;
import mainpkg.Rayhan.User6.Goal2_Teacher.Teacher;
import mainpkg.Rayhan.User8.DashBoard8SceneFxmlController;
import mainpkg.Rayhan.User8.NGOs;
import mainpkg.Saima.User4_Doctor.Doctor;

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
        ObservableList<Refugee> refList = fileReadRF() ;
        ObservableList<Doctor> docList = fileReadDC() ;
        ObservableList<Teacher> thList = fileReadTH() ;
        ObservableList<Volunteer> vcList = fileReadVCVL() ;
        ObservableList<Volunteer> siList = fileReadSIVL() ;
        ArrayList<Integer> list = user.campInfo(refList , docList , thList , vcList , siList) ;
        
        totalRefugeeLabel.setText(Integer.toString(list.get(0))) ;
        maleRefugeeLabel.setText(Integer.toString(list.get(1))) ;
        femaleRefugeeLabel.setText(Integer.toString(list.get(2))) ;
        doctorLabel.setText(Integer.toString(list.get(3))) ;
        teacherLabel.setText(Integer.toString(list.get(4))) ;
        volunteerLabel.setText(Integer.toString(list.get(5))) ;
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
    
    private ObservableList<Refugee> fileReadRF() {
        ObservableList<Refugee> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/Refugee.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Refugee st ;
            try {
                while(true){
                    st = (Refugee)ois.readObject();
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
    
    private ObservableList<Teacher> fileReadTH() {
        ObservableList<Teacher> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/Teacher.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Teacher st ;
            try {
                while(true){
                    st = (Teacher)ois.readObject();
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
    
        private ObservableList<Volunteer> fileReadVCVL() {
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
    
    private ObservableList<Volunteer> fileReadSIVL() {
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
}
