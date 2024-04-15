package mainpkg.Rayhan.User6.Goal4_Student;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import mainpkg.AbstractClass.AppendableObjectOutputStream;
import mainpkg.Rayhan.User6.EducationCoordinator;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class CourseSceneFxmlController implements Initializable {

    @FXML    private TextField nameTextField;
    @FXML    private TextField tClassTextField;
    @FXML    private TextField tHwTextField;
    @FXML    private Label showLabel;
    
    EducationCoordinator user ;
    Alert alert ;

    /**
     * Initializes the controller class.
     * @param u
     * @param url
     * @param rb
     */
    public void set( EducationCoordinator u) {
        user = u ;
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void createOnMouseClick(MouseEvent event) {
        Boolean rtn = true ;
        String name = "" , stc = "" , sthw = "" ;
        int tc = 0 , thw = 0 ;
        
        name = nameTextField.getText() ;
        if (name.length() == 0) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Name Error") ;
            alert.setContentText("Course name must.");
            rtn = false ;
            alert.showAndWait() ;
        }
        
        stc = tClassTextField.getText() ;
        sthw = tHwTextField.getText() ;
        if (stc.length() == 0 || sthw.length() == 0) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Error") ;
            alert.setContentText("Class Homework must.");
            rtn = false ;
            alert.showAndWait() ;
        }
        else {
            tc = Integer.parseInt(stc) ;
            thw = Integer.parseInt(sthw) ;
        }
        System.out.println(name+tc+thw) ;
        System.out.println(user) ;
        if (rtn == true) {
            Course co = user.addCourse(name, tc, thw) ;
            fileWrite(co) ;
            showLabel.setText(co.toString()) ;
        }
        
    }
    
      private void fileWrite(Course stu) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("src/File/Course.bin");
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
            Logger.getLogger(CourseSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(CourseSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
    }
    
}
