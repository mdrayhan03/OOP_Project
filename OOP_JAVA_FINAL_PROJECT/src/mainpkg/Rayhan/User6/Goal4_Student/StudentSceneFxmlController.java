package mainpkg.Rayhan.User6.Goal4_Student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import mainpkg.AbstractClass.AppendableObjectOutputStream;
import mainpkg.Rasel.Refugee.Refugee;
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
    @FXML    private TableView<Student> studentTableView;
    @FXML    private TableColumn<Student , Integer> idTableColumn;
    @FXML    private TableColumn<Student , String> nameTableColumn;
    @FXML    private TableColumn<Student , String> pNTableColumn;
    @FXML    private TableColumn<Student , String> emailTableColumn;
    @FXML    private TableColumn<Student , String> courseIdTableColumn;
    @FXML    private ComboBox<String> courseIdComboBox;
    @FXML    private Label tSLabel;
    
    EducationCoordinator user ;
    
    ObservableList<Student> studentList = FXCollections.observableArrayList() ;
    
    ObservableList<Course> course = FXCollections.observableArrayList() ;

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
        ObservableList<Refugee> refugeeList = fileReadRe() ;
        studentTableView.setItems(studentList) ;
        for (Refugee re: refugeeList) {
            refugeeIdComboBox.getItems().add(re.getId()) ;
        }
        
        ObservableList<Student> studentList = fileRead() ;
        
        ObservableList<Course> courseList = fileReadCO() ;
        for(Course cou: courseList) {
            courseIdComboBox.getItems().add(cou.getId()) ;
        }
        tSLabel.setText(Integer.toString(studentList.size())) ;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
//
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
        ObservableList<Refugee> refugeeList = fileReadRe() ;
        for (Refugee re: refugeeList) {
            if (refugeeIdComboBox.getValue() == re.getId()){
            Student st = new Student(re.getId(), re.getName(), re.getPassword(), re.getPhoneNo(),re.getEmail(),re.getUserType(),re.getGender(), re.getDob(), course) ;
            fileWrite(st) ;
            break ;
            }
        }
    }

    @FXML
    private void createOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User6/Goal4_Student/CourseSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        CourseSceneFxmlController csc = myLoader.getController() ;
        csc.set(user) ;

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
        

        Stage stage = new Stage() ;
        stage.setScene(myScene) ;
        stage.setTitle("Education Coordinator CourseInfo") ;
        stage.show() ;
    }

    @FXML
    private void addCourseOnMouseClick(MouseEvent event) {
        ObservableList<Course> co = fileReadCO() ;
        for (Course c: co) {
            if (c.getId().equals(courseIdComboBox.getValue())) {
                course.add(c) ;
            }
        }

    }

    @FXML
    private void IdButtonOnMouseClick(MouseEvent event) {
        ObservableList<Refugee> refugeeList = fileReadRe() ;
        for(Refugee re: refugeeList) {
            if(refugeeIdComboBox.getValue() == re.getId()) {
                nameLabel.setText(re.getName()) ;
                emailLabel.setText(re.getEmail()) ;
                pNLabel.setText(re.getPhoneNo()) ;
                break ;
            }
        }
    }
    
    private ObservableList<Refugee> fileReadRe() {
        ObservableList<Refugee> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/VCVolunteer.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Refugee st ;
            try {
                while(true){
                    st = (Refugee)ois.readObject();
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
    
    private ObservableList<Student> fileRead() {
        ObservableList<Student> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/Student.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Student st ;
            try {
                while(true){
                    st = (Student)ois.readObject();
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
    
      private void fileWrite(Student stu) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("src/File/Student.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(stu);

        } catch (IOException ex) {
            Logger.getLogger(StudentSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(StudentSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
    }
      
    private ObservableList<Course> fileReadCO() {
        ObservableList<Course> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/Student.bin");
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
