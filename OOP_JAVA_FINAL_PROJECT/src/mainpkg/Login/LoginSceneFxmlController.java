package mainpkg.Login;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.User;

import mainpkg.Rayhan.User5.DashBoard5SceneFxmlController;
import mainpkg.Rayhan.User5.Profile.ProfileSceneFxmlController;
import mainpkg.Rayhan.User5.VolunteerCoordinator;
import mainpkg.Rayhan.User6.DashBoard6SceneFxmlController;
import mainpkg.Rayhan.User6.EducationCoordinator;
import mainpkg.Rayhan.User7.SecurityIncharge;
import mainpkg.Rayhan.User8.NGOs;

import mainpkg.Rayhan.User7.DashBoard7SceneFxmlController;
import mainpkg.Rayhan.User7.SecurityIncharge;
import mainpkg.Rayhan.User8.DashBoard8SceneFxmlController;

import mainpkg.Saima.User3_AidExcutive.AidExcutive;
import mainpkg.Saima.User3_AidExcutive.AidExcutiveDashBoardSceneFxmlController;
import mainpkg.Saima.User4_Doctor.Doctor;
import mainpkg.Saima.User4_Doctor.DoctorDashBoardSceneFxmlController;


/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class LoginSceneFxmlController implements Initializable {

    @FXML    private TextField userIdTextField;
    @FXML    private PasswordField pwPasswordField;
    @FXML    private Label forgetPasswordLabel;
    @FXML    private ComboBox<String> userTypeComboBox;
    
    Alert alert ;
    ObservableList<VolunteerCoordinator> vcList = FXCollections.observableArrayList() ;
    ObservableList<EducationCoordinator> ecList = FXCollections.observableArrayList() ;
    ObservableList<SecurityIncharge> siList = FXCollections.observableArrayList() ;
    ObservableList<NGOs> ngList = FXCollections.observableArrayList() ;
    
    ObservableList<AidExcutive> aeList = FXCollections.observableArrayList() ;
    ObservableList<Doctor> docList = FXCollections.observableArrayList() ;
   
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        VolunteerCoordinator v = new VolunteerCoordinator(5500000 , "MD.Rayhan Hossain" , "asdfghjk" , "01312961737" , "rayhan@gmail.com" , "Volunteer Coordinator" , "Male" , "04/04/2003") ;
        vcList.add(v) ;
        EducationCoordinator e = new EducationCoordinator(6600000 , "Abul Kalam" , "asdfghjk" , "01312961737" , "rayhan@gmail.com" , "Education Coordinator" , "Male" , "04/04/2003") ;

        ecList.add(e);
        SecurityIncharge s = new SecurityIncharge(7700000 , "Abul Kalam" , "asdfghjk" , "01312961737" , "rayhan@gmail.com" , "Security Incharge" , "Male" , "04/04/2003") ;
        siList.add(s);
        NGOs n = new NGOs(8800000 , "Abul Kalam" , "asdfghjk" , "01312961737" , "rayhan@gmail.com" , "NGOs" , "Male" , "04/04/2003") ;
        ngList.add(n);
        
       
        
       
        AidExcutive aE = new  AidExcutive(3300000, "Saima Sinthiye" , "asd11111" , "01312961700" , "saima@gmail.com" , "AidExcutive" , "Female" , "04/04/2003") ;
        aeList.add(aE);
        Doctor doc = new Doctor(1100000, "Ahad" , "11111asd" , "01312961739" , "ahad@gmail.com" , "Doctor" , "Male" , "04/04/2003") ;
        docList.add(doc);
        
        userTypeComboBox.getItems().addAll("Refugee Camp Manager", "Refugee", "Aid Excutive" , "Doctor" , "Volunteer Coordinator" , "Education Coordinator" , "Security Incharge" , "NGO") ;
        userTypeComboBox.setValue("Refugee Camp Manager") ;
    }    

    @FXML
    private void loginOnMouseClick(MouseEvent event) throws IOException, InterruptedException {
        boolean rtn = true ;
        String str = "" ;
        str = userIdTextField.getText() ;
        int id = 0 ;
        if (str.length() != 0) {
            id = Integer.parseInt(str) ;
        }
        
        if (id == 0) {
            alert = new Alert(Alert.AlertType.WARNING) ;
            alert.setHeaderText("ID Error.") ;
            alert.setContentText("ID Required.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        else if (id < 1000000 || id > 9999999) {
            alert = new Alert(Alert.AlertType.WARNING) ;
            alert.setHeaderText("ID Error.") ;
            alert.setContentText("ID must be 7 digit.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        
        String pw = "" ;
        pw = pwPasswordField.getText() ;
        if (pw.length() < 8) {
            alert = new Alert(Alert.AlertType.WARNING) ;
            alert.setHeaderText("Password Error.") ;
            if (pw.length() == 0) {
                alert.setContentText("Password Required.") ;
            }
            alert.setContentText("Password must be more than 8 character.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        String userType = userTypeComboBox.getValue() ;
        Boolean done = false ;
        
   
        if (userType == "Volunteer Coordinator") {
            for(VolunteerCoordinator vc: vcList) {
                VolunteerCoordinator user = vc.verifyLogin(id, pw) ;
                if (user != null) {
                    alert = new Alert(Alert.AlertType.CONFIRMATION) ;
                    alert.setHeaderText("Verification Confirmed.");
                    alert.showAndWait() ;   
                    Parent root = null ;
                    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User5/DashBoard5SceneFxml.fxml")) ;
                    root = (Parent) myLoader.load() ;
                    Scene myScene = new Scene(root) ;
        
                    DashBoard5SceneFxmlController psc = myLoader.getController() ;
                    psc.set(user) ;
        

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
                    stage.setScene(myScene) ;
                    stage.setTitle("Volunteer Coordinator DashBoard") ;
                    stage.show() ;

                }
                
            }
        }
        else if (userType == "Education Coordinator") {
            for(EducationCoordinator ec: ecList) {
                EducationCoordinator user = ec.verifyLogin(id, pw) ;
                if (user != null) {
                    alert = new Alert(Alert.AlertType.CONFIRMATION) ;
                    alert.setHeaderText("Verification Confirmed.");
                    alert.showAndWait() ;   
                    Parent root = null ;
                    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User6/DashBoard6SceneFxml.fxml")) ;
                    root = (Parent) myLoader.load() ;
                    Scene myScene = new Scene(root) ;
        
                    DashBoard6SceneFxmlController psc = myLoader.getController() ;
                    psc.set(user) ;
        

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
                    stage.setScene(myScene) ;
                    stage.setTitle("Education Coordinator DashBoard") ;
                    stage.show() ;
                }
            }}
        else if (userType == "Security Incharge") {
            for(SecurityIncharge si: siList) {
                SecurityIncharge user = si.verifyLogin(id, pw) ;
                if (user != null) {
                    alert = new Alert(Alert.AlertType.CONFIRMATION) ;
                    alert.setHeaderText("Verification Confirmed.");
                    alert.showAndWait() ;   
                    Parent root = null ;
                    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User7/DashBoard7SceneFxml.fxml")) ;
                    root = (Parent) myLoader.load() ;
                    Scene myScene = new Scene(root) ;
        
                    DashBoard7SceneFxmlController psc = myLoader.getController() ;
                    psc.set(user) ;
        

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
                    stage.setScene(myScene) ;
                    stage.setTitle("Security Incharge DashBoard") ;
                    stage.show() ;
                }
            }}
        else if (userType == "NGOs") {
            for(NGOs ng: ngList) {
                NGOs user = ng.verifyLogin(id, pw) ;
                if (user != null) {
                    alert = new Alert(Alert.AlertType.CONFIRMATION) ;
                    alert.setHeaderText("Verification Confirmed.");
                    alert.showAndWait() ;   
                    Parent root = null ;
                    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User8/DashBoard8SceneFxml.fxml")) ;
                    root = (Parent) myLoader.load() ;
                    Scene myScene = new Scene(root) ;
        
                    DashBoard8SceneFxmlController psc = myLoader.getController() ;
                    psc.set(user) ;
        

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
                    stage.setScene(myScene) ;
                    stage.setTitle("Volunteer Coordinator DashBoard") ;
                    stage.show() ;
                }
            }
        }
        
        else if (userType == "Aid Excutive") {
            for(AidExcutive a: aeList) {
                AidExcutive user = (AidExcutive)a.verifyLogin(id, pw) ;
                if (user != null) {
                    alert = new Alert(Alert.AlertType.CONFIRMATION) ;
                    alert.setHeaderText("Verification Confirmed.");
                    alert.showAndWait() ;   
                    Parent root = null ;
                    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User3_AidExcutive/AidExcutiveDashBoardSceneFxml.fxml")) ;
                    root = (Parent) myLoader.load() ;
                    Scene myScene = new Scene(root) ;
                    user.setStatus("Active");
        
                    AidExcutiveDashBoardSceneFxmlController psc = myLoader.getController() ;
                    psc.set(user) ;
        

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
                    stage.setScene(myScene) ;
                    stage.setTitle("Aid Excutive DashBoard") ;
                    stage.show() ;
                    
                 }
            }
        }
        else if (userType == "Doctor") {
            for(Doctor d: docList) {
                Doctor user = (Doctor)d.verifyLogin(id, pw) ;
                if (user != null) {
                    alert = new Alert(Alert.AlertType.CONFIRMATION) ;
                    alert.setHeaderText("Verification Confirmed.");
                    alert.showAndWait() ;   
                    Parent root = null ;
                    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User4_Doctor/DoctorDashBoardSceneFxml.fxml")) ;
                    root = (Parent) myLoader.load() ;
                    Scene myScene = new Scene(root) ;
                    user.setStatus("Active");
        
                    DoctorDashBoardSceneFxmlController psc = myLoader.getController() ;
                    psc.set(user) ;
        

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
                    stage.setScene(myScene) ;
                    stage.setTitle("Doctor DashBoard") ;
                    stage.show() ;
                    
                }
            }
        }

        if (done == false) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Wrong User") ;
            alert.setContentText("No user found with this id and password.");
            alert.showAndWait() ;
        }
    }
        

        
    
    @FXML
    private void forgetPasswordOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/ForgetPW/ForgetPWFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage myStage = new Stage() ;
        myStage.setScene(myScene) ;
        myStage.getIcons().add(new Image("/image/campIcon.jpg")) ;
        myStage.setTitle("Reset Password") ;
        myStage.show();
    }

    @FXML
    private void createAccountOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/CreateAccount/CreateAccountSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage myStage = new Stage() ;
        myStage.setScene(myScene) ;
        myStage.getIcons().add(new Image("/image/campIcon.jpg")) ;
        myStage.setTitle("Create Account") ;
        myStage.show();
    }
    
//    private FXMLLoader fxmlload (String str1 , String str2 , MouseEvent event) throws IOException {
//        alert = new Alert(Alert.AlertType.CONFIRMATION) ;
//        alert.setHeaderText("Verification Confirmed.");
//        alert.showAndWait() ;
//        Parent root = null ;
//        FXMLLoader myLoader = new FXMLLoader(getClass().getResource(str1)) ;
//        root = (Parent) myLoader.load() ;
//        Scene myScene = new Scene(root) ;              
//                                
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
//        stage.setScene(myScene) ;
//        stage.setTitle("Login") ;
//        stage.show() ;
//        System.out.println(str2);
//            
//        return myLoader ;
//    }
    
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
    
    private ObservableList<NGOs> fileReadNG() {
        ObservableList<NGOs> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/NGOs.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            NGOs st ;
            try {
                while(true){
                    st = (NGOs)ois.readObject();
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
            f = new File("src/File/AidExctive.bin");
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
    
     private ObservableList<Doctor> fileReadDoc() {
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
    
    
}