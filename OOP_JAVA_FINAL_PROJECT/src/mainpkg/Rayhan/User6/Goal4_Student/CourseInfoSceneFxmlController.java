package mainpkg.Rayhan.User6.Goal4_Student;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
import javafx.scene.control.cell.PropertyValueFactory;
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
    
    
    EducationCoordinator user ;
    Alert alert ;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    public void tableShow() {
        ObservableList<Course> list = fileRead() ;
        courseTableView.setItems(list) ;
        for (Course co: list) {
            idComboBox.getItems().add(co.getId()) ;
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id")) ;
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name")) ;
        tcTableColumn.setCellValueFactory(new PropertyValueFactory<>("tC")) ;
        tHwTableColumn.setCellValueFactory(new PropertyValueFactory<>("tHW")) ;
    }    

    @FXML
    private void courseIdOnMouseClick(MouseEvent event) {
        ObservableList<Course> list = fileRead() ;
        for(Course co: list) {
            if (co.getId().equals(idComboBox.getValue())) {
                nameLabel.setText(co.getName()) ;
                tCLabel.setText(Integer.toString(co.gettC())) ; 
                tHwLabel.setText(Integer.toString(co.gettHW())) ; 
            }
        }
    }
    
    private ObservableList<Course> fileRead() {
        ObservableList<Course> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/Course.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Course st ;
            try {
                while(true){
                    st = (Course)ois.readObject();
//                    System.out.println(st);
                    studList.add(st) ;
                }
            }//end of nested try
            catch(Exception e){
                // handling code
            }//nested catch     
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } 
        finally {
            try {
                
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }           
        
        return studList ;
    }
    
}
