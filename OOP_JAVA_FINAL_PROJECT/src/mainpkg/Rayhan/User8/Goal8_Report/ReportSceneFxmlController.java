package mainpkg.Rayhan.User8.Goal8_Report;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class ReportSceneFxmlController implements Initializable {

    @FXML    private TextField ddTextField;
    @FXML    private TextField subjectTextField;
    @FXML    private TextField mmTextField;
    @FXML    private TextField yyyyTextField;
    @FXML    private TextArea reportBodyTextArea;
    @FXML    private TextField siIdTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backOnMouseClick(MouseEvent event) {
    }

    @FXML
    private void submitOnMouseClick(MouseEvent event) {
    }
    
}
