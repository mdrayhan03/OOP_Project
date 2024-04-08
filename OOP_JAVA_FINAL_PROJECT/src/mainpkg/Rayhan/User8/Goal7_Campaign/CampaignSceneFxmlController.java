package mainpkg.Rayhan.User8.Goal7_Campaign;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class CampaignSceneFxmlController implements Initializable {

    @FXML    private TextField ddTextField;
    @FXML    private TextField mmTextField;
    @FXML    private TextField yyyyTextField;
    @FXML    private ComboBox<?> timeComboBox;
    @FXML    private ComboBox<?> placeComboBox;
    @FXML    private TextField reasonTextField;
    @FXML    private TextArea descriptionTextArea;
    @FXML    private TableView<?> campaignTableView;
    @FXML    private TableColumn<?, ?> idTableColumn;
    @FXML    private TableColumn<?, ?> reasonTableColumn;
    @FXML    private TableColumn<?, ?> dateTableColumn;
    @FXML    private TableColumn<?, ?> timeTableColumn;
    @FXML    private TableColumn<?, ?> descriptionTableColumn;
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
    private void applyOnMouseClick(MouseEvent event) {
    }
    
}
