package mainpkg.Rayhan.User6.Goal4_Student;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import mainpkg.Rayhan.User6.EducationCoordinator;
import mainpkg.Rayhan.User6.Goal2_Teacher.Teacher;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class CourseInfoSceneFxmlController implements Initializable {

    @FXML    private TableView<Course> courseTableView;
    @FXML    private TableColumn<Course , String> idTableColumn;
    @FXML    private TableColumn<Course , String> nameTableColumn;
    @FXML    private TableColumn<Course , String> tcTableColumn;
    @FXML    private TableColumn<Course , String> tHwTableColumn;
    @FXML    private ComboBox<String> idComboBox;
    @FXML    private Label nameLabel;
    @FXML    private Label tCLabel;
    @FXML    private Label tHwLabel;
    
    ObservableList<Course> list = FXCollections.observableArrayList() ;
    ObservableList<String> idList = FXCollections.observableArrayList() ;
    EducationCoordinator user ;
    Alert alert ;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    public void tableShow() {
        courseTableView.setItems(list) ;
        idComboBox.setItems(idList) ;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void courseIdOnMouseClick(MouseEvent event) {
        for(Course co: list) {
            if (co.getId() == idComboBox.getValue()) {
                nameLabel.setText(co.getName()) ;
                tCLabel.setText(Integer.toString(co.gettC())) ; 
                tHwLabel.setText(Integer.toString(co.gettHW())) ; 
            }
        }
    }
    
}
