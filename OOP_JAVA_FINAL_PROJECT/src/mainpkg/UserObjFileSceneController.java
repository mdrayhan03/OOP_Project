package mainpkg;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import mainpkg.AbstractClass.User;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class UserObjFileSceneController implements Initializable {

    @FXML
    private Label show;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String str = null ;
        User u ;
        FileInputStream fis = null ;
        ObjectInputStream ois = null ;
        try {
            fis = new FileInputStream("src/FIle/UserObjFile.bin") ;
            ois = new ObjectInputStream(fis) ;
            while (true) {
               u = (User) ois.readObject() ;
               str += u.getId() + "\n" ;
            }
        }
        catch(Exception e) {
            System.out.println(e.getClass().getName()) ;
        }
        show.setText(str) ;
    }    
    
}
