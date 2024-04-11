package mainpkg.Saima.User3_AidExcutive.Profile;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class ChangePWSceneFxmlController implements Initializable {

    @FXML    private PasswordField oldPasswordField;
    @FXML    private PasswordField newPasswordField;
    @FXML    private PasswordField confirmPasswordField;
    
    Alert alert ;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void changePasswordOnMouseClick(MouseEvent event) {
        boolean rtn = true ;
        String opw = "" , npw = "" , cpw = "" ;
        
        opw = oldPasswordField.getText() ;
        if (opw.length() < 8) {
            alert = new Alert(Alert.AlertType.WARNING) ;
            alert.setHeaderText("Password Error.") ;
            if (opw.length() == 0) {
                alert.setContentText("Password Required.") ;
            }
            alert.setContentText("Old Password must be more than 8 character.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        
        npw = newPasswordField.getText() ;
        if (npw.length() < 8) {
            alert = new Alert(Alert.AlertType.WARNING) ;
            alert.setHeaderText("Password Error.") ;
            if (npw.length() == 0) {
                alert.setContentText("Password Required.") ;
            }
            alert.setContentText("New Password must be more than 8 character.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        
        cpw = oldPasswordField.getText() ;
        if (cpw.length() < 8) {
            alert = new Alert(Alert.AlertType.WARNING) ;
            alert.setHeaderText("Password Error.") ;
            
            if (cpw.length() == 0) {
                alert.setContentText("Password Required.") ;
            }
            alert.setContentText("Confirm Password must be more than 8 character.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        
        if(!npw.equals(cpw)) {
            alert = new Alert(Alert.AlertType.WARNING) ;
            alert.setHeaderText("Password Error.") ;
            alert.setContentText("New password and Confirm password is not same.");
        }
    }
    
}
