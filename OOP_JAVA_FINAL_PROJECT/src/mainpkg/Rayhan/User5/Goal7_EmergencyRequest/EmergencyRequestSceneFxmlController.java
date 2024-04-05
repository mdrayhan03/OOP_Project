package mainpkg.Rayhan.User5.Goal7_EmergencyRequest;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class EmergencyRequestSceneFxmlController implements Initializable {

    @FXML    private ComboBox<?> idComboBox;
    @FXML    private TableView<?> requestTableView;
    @FXML    private TableColumn<?, ?> idTableColumn;
    @FXML    private TableColumn<?, ?> reasonTableColumn;
    @FXML    private TableColumn<?, ?> timeTableColumn;
    @FXML    private TableColumn<?, ?> placeTableColumn;
    @FXML    private TableColumn<?, ?> dateTableColumn;
    @FXML    private TableColumn<?, ?> amountTableColumn;
    @FXML    private TableColumn<?, ?> statusTableColumn;

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
    private void acceptOnMouseClick(MouseEvent event) {
    }
    
}
