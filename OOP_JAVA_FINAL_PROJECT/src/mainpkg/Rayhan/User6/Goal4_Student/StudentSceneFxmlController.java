package mainpkg.Rayhan.User6.Goal4_Student;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.Rayhan.User6.DashBoard6SceneFxmlController;
import mainpkg.Rayhan.User6.EducationCoordinator;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class StudentSceneFxmlController implements Initializable {

    @FXML    private ComboBox<Integer> refugeeIdComboBox;
    @FXML    private Label nameLabel;
    @FXML    private Label emailLabel;
    @FXML    private Label pNLabel;
    @FXML    private TableView<?> studentTableView;
    @FXML    private TableColumn<?, ?> idTableColumn;
    @FXML    private TableColumn<?, ?> nameTableColumn;
    @FXML    private TableColumn<?, ?> pNTableColumn;
    @FXML    private TableColumn<?, ?> emailTableColumn;
    @FXML    private TableColumn<?, ?> courseIdTableColumn;
    @FXML    private ComboBox<String> courseIdComboBox;
    @FXML    private Label tSLabel;
    
    EducationCoordinator user ;
    ObservableList<Refugee> refugeeList = FXCollections.observableArrayList() ;
    ObservableList<Student> studentList = FXCollections.observableArrayList() ;
    ObservableList<Course> courseList = FXCollections.observableArrayList() ;

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
    
    public void tableShow() {
        studentTableView.setItems(studentList) ;
        for (Refugee re: refugeeList) {
            refugeeIdComboBox.add(re.getID) ;
        }
        for(Course cou: courseList) {
            courseIdComboBox.getItems().add(cou.getId()) ;
        }
        tSLabel.setText(Integer.toString(studentList.size())) ;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User6/DashBoard6SceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        DashBoard6SceneFxmlController dsc = myLoader.getController() ;
        dsc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Education Coordinator DashBoard") ;
        stage.show() ;
    }

    @FXML
    private void addOnMouseClick(MouseEvent event) {
    }

    @FXML
    private void createOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User6/Goal4_Student/CourseSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage stage = new Stage() ;
        stage.setScene(myScene) ;
        stage.setTitle("Education Coordinator Course") ;
        stage.show() ;
    }

    @FXML
    private void coursInfoOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User6/Goal4_Student/CourseInfoSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Education Coordinator CourseInfo") ;
        stage.show() ;
    }

    @FXML
    private void addCourseOnMouseClick(MouseEvent event) {
        
    }

    @FXML
    private void IdButtonOnMouseClick(MouseEvent event) {
        for(Refugee re: refugeeList) {
            if(refugeeIdComboBox.getValue() == re.getId()) {
                nameLabel.setText(re.getName()) ;
                emailLabel.setText(re.getEmail()) ;
                pNLabel.setText(re.getPN()) ;
                break ;
            }
        }
    }
    
}
