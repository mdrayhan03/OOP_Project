package mainpkg.ForgetPW;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import mainpkg.AbstractClass.User;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class ForgetPasswordController implements Initializable {

    @FXML    private TextField idTextField;
    @FXML    private TextField phoneNoTextField;
    @FXML    private PasswordField newPasswordField;
    @FXML    private PasswordField confirmPasswordField;
    @FXML    private Label showOutputLabel;
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
    private void confirmOnMouseClick(MouseEvent event) {
        boolean rtn = false ;
        String str = "" ;
        str = idTextField.getText() ;
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
        
        String userType = userTypeComboBox.getValue() ;
        
        
        String pN = "" ;
        pN = phoneNoTextField.getText() ;
        if (pN.length() != 11) {
            alert = new Alert(Alert.AlertType.WARNING) ;
            alert.setHeaderText("Phone No Error.") ;
            if (pN.length() == 0) {
                alert.setContentText("Phone No Required.") ;
            }
            alert.setContentText("Phone No must be 11 digit.") ;
            alert.showAndWait() ;
        }
        
        String nPW = "" ;
        nPW = newPasswordField.getText() ;
        if (nPW.length() < 8) {
            alert = new Alert(Alert.AlertType.WARNING) ;
            alert.setHeaderText("Password Error.") ;
            if (nPW.length() == 0) {
                alert.setContentText("New Password Required.") ;
                nPW = "nPW" ;
            }
            alert.setContentText("Password must be more than 8 character.") ;
            alert.showAndWait() ;
        }
        
        String cPW = "" ;
        cPW = confirmPasswordField.getText() ;
        if (cPW.length() < 8) {
            alert = new Alert(Alert.AlertType.WARNING) ;
            alert.setHeaderText("Password Error.") ;
            if (cPW.length() == 0) {
                alert.setContentText("Confirm Password Required.") ;
                cPW = "cPW" ;
            }
            alert.setContentText("Password must be more than 8 character.") ;
            alert.showAndWait() ;
        }
        
        if (!nPW.equals(cPW)) {
            alert = new Alert(Alert.AlertType.WARNING) ;
            alert.setHeaderText("Password Error.") ;
            alert.setContentText("New Password and Confirm Password is not same.") ;
            alert.showAndWait() ;
        }
    }
}
