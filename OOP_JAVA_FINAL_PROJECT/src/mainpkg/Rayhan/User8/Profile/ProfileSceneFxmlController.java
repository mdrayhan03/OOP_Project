package mainpkg.Rayhan.User8.Profile;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class ProfileSceneFxmlController implements Initializable {

    @FXML    private Label statusLabel;
    @FXML    private Label nameLabel;
    @FXML    private Label idLabel;
    @FXML    private Label userTypeLabel;
    @FXML    private Label pNLabel;
    @FXML    private Label emailLabel;

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
    private void backOnMouseClick(MouseEvent event) {
    }

    @FXML
    private void changePWOnMouseClick(MouseEvent event) {
    }
    
}
