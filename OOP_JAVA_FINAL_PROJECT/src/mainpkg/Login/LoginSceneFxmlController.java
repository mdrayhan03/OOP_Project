package mainpkg.Login;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
import mainpkg.Rasel.CampManager.CampManager;
import mainpkg.Rasel.Refugee.Refugee;
import mainpkg.Rayhan.User5.DashBoard5SceneFxmlController;
import mainpkg.Rayhan.User5.VolunteerCoordinator;
import mainpkg.Rayhan.User6.DashBoard6SceneFxmlController;
import mainpkg.Rayhan.User6.EducationCoordinator;
import mainpkg.Saima.User3_AidExcutive.AidExcutive;
import mainpkg.Saima.User3_AidExcutive.DashBoardSceneFxmlController;
import mainpkg.Saima.User4_Doctor.Doctor;

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
    ArrayList<User> list = new ArrayList<>();
    User u ;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        VolunteerCoordinator v = new VolunteerCoordinator(5500000 , "MD.Rayhan Hossain" , "asdfghjk" , "01312961737" , "rayhan@gmail.com" , "Volunteer Coordinator" , "Male" , "04/04/2003") ;
        list.add(v) ;
        EducationCoordinator e = new EducationCoordinator(6600000 , "Abul Kalam" , "asdfghjk" , "01312961737" , "rayhan@gmail.com" , "Education Coordinator" , "Male" , "04/04/2003") ;
        list.add(e);
        CampManager c = new CampManager(7700000 , "Brigadier Gen Niaz" , "admin1234" , "01476589098" , "refugee.camp.niaz@gmail.com" , "Camp Manager" , "Male" , "07/02/1980", new Date(20,01,2020));
        list.add(c);
        Refugee r = new Refugee(8800000 , "Niloy Sarder" , "admin1234" , "01676543198" , "niloy@gmail.com" , "Refugee" , "Male" , "02/07/1998") ;
        list.add(r);
        
        userTypeComboBox.getItems().addAll("Refugee Camp Manager", "Refugee", "Aid Executive" , "Doctor" , "Volunteer Coordinator" , "Education Coordinator" , "Security Incharge" , "NGO") ;
        AidExcutive ae = new AidExcutive(2233456 , "Saima" , "asd123" , "01792760030" , "saima@gmail.com" , "Aid Excuive" , "Male" , "08/04/2003") ;
        list.add(ae) ;
        Doctor d = new Doctor(5555777 , "Sintiya" , "abc555" , "01951820192" , "sinthiya@gmail.com" , "Doctor" , "Female" , "06/04/2003") ;
        list.add(d);
        
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
        
        for (User user: list) {
            User u = user.verifyLogin(id, pw) ;
            if (u != null) {
                done = true ;
                if (userType == "Volunteer Coordinator"){
                FXMLLoader fx = fxmlload("/mainpkg/Rayhan/User5/DashBoard5SceneFxml.fxml" , "Volunteer Coordinator" , event) ;
                System.out.println("Volunteer Coordinator") ;
                DashBoard5SceneFxmlController ds = fx.getController() ;
//                ds.set(u) ;
                }
                else if ("Education Coordinator".equals(u.getUserType())) {
                    FXMLLoader fx = fxmlload("/mainpkg/Rayhan/User6/DashBoard6SceneFxml.fxml" , "Education Coordinator" , event) ;
                    System.out.println("Volunteer Coordinator") ;
                    DashBoard6SceneFxmlController ds = fx.getController() ;
                    ds.set(u);
                }
                
                else if ("Camp Manager".equals(u.getUserType())) {
                    FXMLLoader fx = fxmlload("/mainpkg/Rasel/CampManager/CampManagerDashboardScene.fxml" , "Camp Manager" , event) ;
                    System.out.println("Camp Manager") ;
                    DashBoard6SceneFxmlController ds = fx.getController() ;
                    ds.set(u);
                }
                
                else if ("Refugee".equals(u.getUserType())) {
                    FXMLLoader fx = fxmlload("/mainpkg/Rasel/Refugee/RefugeeDashboardScene.fxml" , "Refugee" , event) ;
                    System.out.println("Refugee") ;
                    DashBoard6SceneFxmlController ds = fx.getController() ;
                    ds.set(u);

                else if ("Aid Excutive".equals(u.getUserType())) {
                    FXMLLoader fx = fxmlload("/mainpkg/Saima/User3_AidExcutive/DashBoardSceneFxml.fxml" , "Aid Excutive" , event) ;
                    System.out.println("Aid Excutive") ;
                    DashBoardSceneFxmlController ds = fx.getController() ;
                    ds.set((AidExcutive) u) ;
                }
                
            }
        }
        if (done == false) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Wrong User") ;
            alert.setContentText("No user found with this id and password.");
            alert.showAndWait() ;
        }
        
//        FileInputStream fis = null ;
//        ObjectInputStream ois = null ;
//        
//        if ("Volunteer Coordinator".equals(userType)) {
//            try {
//                fis = new FileInputStream("src/FIle/VolunteerCoordinatorObjFile.bin") ;
//                ois = new ObjectInputStream(fis) ;
//                while (true) {
//                    VolunteerCoordinator vc = (VolunteerCoordinator) ois.readObject() ;
//                    System.out.println("File Read") ;
//                    User verified = vc.verifyLogin(id, pw) ;
//                    System.out.println("Verified") ;
//                    if (verified != null)
//                        if ("Volunteer Coordinator".equals(u.getUserType())) {
//                            FXMLLoader fx = fxmlload("/mainpkg/Rayhan/User5/DashBoard5SceneFxml.fxml" , "Volunteer Coordinator" , event) ;
//                            System.out.println("Volunteer Coordinator") ;
//                            DashBoard5SceneFxmlController ds = fx.getController() ;
//                            ds.set(vc) ;
//                        }                    
//                    }
//                }
//            catch (Exception e) {
//                System.out.println(e.getClass().getName()) ;
//                ois.close() ;
//            }
//        }
//        else if ("Education Coordinator".equals(userType)) {
//            try {
//                fis = new FileInputStream("src/FIle/EducationCoordinatorObjFile.bin") ;
//                ois = new ObjectInputStream(fis) ;
//                while (true) {
//                    EducationCoordinator ec = (EducationCoordinator) ois.readObject() ;
//                    System.out.println("File Read") ;
//                    User verified = ec.verifyLogin(id, pw) ;
//                    System.out.println("Verified") ;
//                    if (verified != null)
//                        if ("Volunteer Coordinator".equals(u.getUserType())) {
//                            FXMLLoader fx = fxmlload("/mainpkg/Rayhan/User6/DashBoard5SceneFxml.fxml" , "Education Coordinator" , event) ;
//                            System.out.println("Volunteer Coordinator") ;
//                            DashBoard5SceneFxmlController ds = fx.getController() ;
//                            ds.set(ec) ;
//                        }                    
//                    }
//                }
//            catch (Exception e) {
//                System.out.println(e.getClass().getName()) ;
//                ois.close() ;
//            }
//        }
//        alert = new Alert(Alert.AlertType.ERROR) ;
//        alert.setHeaderText("Wrong ID or Password.");
//        alert.showAndWait() ;
        
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
    
    private FXMLLoader fxmlload (String str1 , String str2 , MouseEvent event) throws IOException {
        alert = new Alert(Alert.AlertType.CONFIRMATION) ;
        alert.setHeaderText("Verification Confirmed.");
        alert.showAndWait() ;
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource(str1)) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;              
                                
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Login") ;
        stage.show() ;
        System.out.println(str2);
            
        return myLoader ;
    }
    
}
