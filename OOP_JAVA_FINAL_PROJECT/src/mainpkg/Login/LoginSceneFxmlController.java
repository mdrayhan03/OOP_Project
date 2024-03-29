package mainpkg.Login;

import java.io.IOException;
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
import mainpkg.AbstractClass.User;
import mainpkg.Rayhan.User5.VolunteerCoordinator;
import mainpkg.Rayhan.User6.EducationCoordinator;

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

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        VolunteerCoordinator v = new VolunteerCoordinator(5500000 , "MD.Rayhan Hossain" , "asdfghjk" , "01312961737" , "rayhan@gmail.com" , "Volunteer Coordinator" , "04/04/2003") ;
        list.add(v) ;
        EducationCoordinator e = new EducationCoordinator(6600000 , "Abul Kalam" , "asdfghjk" , "01312961737" , "rayhan@gmail.com" , "Education Coordinator" , "04/04/2003") ;
        list.add(e);
        
        userTypeComboBox.getItems().addAll("Refugee Camp Manager" , "Aid Executive" , "Doctor" , "Volunteer Coordinator" , "Education Coordinator" , "Security Incharge" , "NGO") ;
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
        
        for (User u: list) {
            User verified = u.verifyLogin(id, pw) ;
            if (verified != null)
                if ("Volunteer Coordinator".equals(u.getUserType())) {
                    alert = new Alert(Alert.AlertType.CONFIRMATION) ;
                    alert.setHeaderText("Verification Confirmed.");
                    alert.showAndWait() ;
                    Parent root = null ;
                    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User5/DashBoardSceneFxml.fxml")) ;
                    root = (Parent) myLoader.load() ;
                    Scene myScene = new Scene(root) ;

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
                    stage.setScene(myScene) ;
                    stage.setTitle("Login") ;
                    stage.show() ;
                    System.out.println("Volunteer Coordinator");
                }
                else if ("Education Coordinator".equals(u.getUserType())) {
                    alert = new Alert(Alert.AlertType.CONFIRMATION) ;
                    alert.setHeaderText("Verification Confirmed.");
                    alert.showAndWait() ;
                    Parent root = null ;
                    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User6/DashBoardSceneFxml.fxml")) ;
                    root = (Parent) myLoader.load() ;
                    Scene myScene = new Scene(root) ;

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
                    stage.setScene(myScene) ;
                    stage.setTitle("Login") ;
                    stage.show() ;
                    System.out.println("Education Coordinator");
                }

            }
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
    
}
