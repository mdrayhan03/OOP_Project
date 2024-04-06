package mainpkg.Rayhan.User5.Goal3_AEReport;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import mainpkg.Rayhan.User5.Goal3_AEReport.AEReport;
import mainpkg.Rayhan.User5.Goal3_AEReport.AEReportList;

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
    public void set (AEReport si , AEReportList sir) {
        AEReport msi = si ;
        AEReportList msir = sir ;
        
        fromLabel.setText(Integer.toString(msir.getSenderId())) ;
        toLabel.setText(Integer.toString(msir.getReceiverId())) ;
        subjectLabel.setText(msi.getSubject()) ;
        dateLabel.setText(msi.getApplyDate().toString()) ;
        reportBodyTextArea.setText(msi.description) ;
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
