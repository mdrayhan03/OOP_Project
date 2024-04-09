package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import mainpkg.Rayhan.User7.Goal3_Notice.Notice;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class ReplySceneFxmlController implements Initializable {

    @FXML    private Label idLabel;
    @FXML    private TextArea messagTextArea;
    
    Notice nc ;

    /**
     * Initializes the controller class.
     */
    
    public void set(Notice ntc) {
        nc = ntc ;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idLabel.setText(nc.getId()) ;
    }    

    @FXML
    private void replyOnMouseClick(MouseEvent event) {
        String message = "" ;
        message = messagTextArea.getText() ;
        
        nc.setReply(message) ;
        
    }
    
}
