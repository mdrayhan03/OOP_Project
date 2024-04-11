package mainpkg.Rayhan.User7.Goal3_Notice;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class ReplySceneFxmlController implements Initializable {

    @FXML    private Label idLabel;
    @FXML    private TextArea messagTextArea;
    
    Notice nc ;
    
    public void set(Notice n) {
        nc = n ;
        idLabel.setText(nc.getId()) ;
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void replyOnMouseClick(MouseEvent event) {
        String reply = "" ;
        
        reply = messagTextArea.getText() ;
        if (reply.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Error") ;
            alert.setContentText("Reply must.") ;
            alert.showAndWait() ;
        }
        else {
            nc.setReply(reply) ;
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION) ;
            alert.setHeaderText("Sucessfull") ;
            alert.setContentText("Reply Done!") ;
            alert.showAndWait() ;
        }
    }
    
}
