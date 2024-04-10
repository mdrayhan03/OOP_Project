package mainpkg.Rayhan.User5.Goal3_AEReport;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import mainpkg.Rayhan.User5.Goal3_AEReport.AEReport;

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
    public void set (AEReport ae) {
        AEReport mae = ae ;
        
        fromLabel.setText(Integer.toString(mae.getSenderId())) ;
        toLabel.setText(Integer.toString(mae.getReceiverId())) ;
        subjectLabel.setText(mae.getSubject()) ;
        dateLabel.setText(mae.getApplyDate().toString()) ;
        reportBodyTextArea.setText(mae.description) ;
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
