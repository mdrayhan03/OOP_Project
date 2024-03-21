package mainpkg.Login;

import java.io.IOException;
import java.net.URL;
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

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        userTypeComboBox.getItems().addAll("Refugee Camp Manager" , "Aid Executive" , "Doctor" , "Volunteer Coordinator" , "Education Coordinator" , "Security Incharge" , "NGO") ;
        userTypeComboBox.setValue("Refugee Camp Manager") ;
    }    

    @FXML
    private void loginOnMouseClick(MouseEvent event) {
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
