package mainpkg.Rayhan.User5.Goal8_Report;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class ShowReportFxmlController implements Initializable {

    @FXML    private Label fromLabel;
    @FXML    private Label subjectLabel;
    @FXML    private Label dateLabel;
    @FXML    private Label toLabel;
    @FXML    private TextArea reportBodyTextArea;

    /**
     * Initializes the controller class.
     * @param si
     * @param sir
     * @param rb
     */
    public void set (Report r) {
        Report mr = r ;
        
        fromLabel.setText(Integer.toString(mr.getSenderId())) ;
        toLabel.setText(Integer.toString(mr.getReceiverId())) ;
        subjectLabel.setText(mr.getSubject()) ;
        dateLabel.setText(mr.getApplyDate().toString()) ;
        reportBodyTextArea.setText(mr.description) ;
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
