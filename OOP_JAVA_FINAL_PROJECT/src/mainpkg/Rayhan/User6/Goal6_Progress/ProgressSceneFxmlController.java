package mainpkg.Rayhan.User6.Goal6_Progress;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import mainpkg.Rayhan.User6.EducationCoordinator;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class ProgressSceneFxmlController implements Initializable {

    @FXML    private ComboBox<?> studetnIdComboBox;
    @FXML    private ComboBox<?> addCourseIdComboBox;
    @FXML    private ComboBox<?> courseIdComboBox;
    @FXML    private Label nameLabel;
    @FXML    private Label pNLabel;
    @FXML    private Label emailLabel;
    @FXML    private Label courseListLabel;
    @FXML    private Label courseNameLabel;
    @FXML    private Label tClassLabel;
    @FXML    private Label tHWLabel;
    @FXML    private Label attendanceLabel;
    @FXML    private Label hwDoneLabel;
    @FXML    private Label progressLabel;
    @FXML    private CheckBox presentCheckBox;
    @FXML    private CheckBox hwCheckBox;

    EducationCoordinator user ;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    public EducationCoordinator get() {
        return user ;
    }
    
    public void set(EducationCoordinator u) {
        user = u ;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backOnMouseClick(MouseEvent event) {
    }

    @FXML
    private void addOnMouseClick(MouseEvent event) {
    }

    @FXML
    private void updateOnMouseClick(MouseEvent event) {
    }
    
}
