package mainpkg.Rayhan.User8.Profile;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    }
    
}
