/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User4_Doctor.Goal8_MedicalReport;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import mainpkg.Rayhan.User5.Goal8_Report.Report;
import mainpkg.Rayhan.User5.Goal8_Report.ReportList;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ShowReportFxmlController implements Initializable {

    @FXML
    private Label fromLabel;
    @FXML
    private Label subjectLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private Label toLabel;
    @FXML
    private TextArea reportBodyTextArea;

    /**
     * Initializes the controller class.
     */
    
    public void set (Report si , ReportList sir) {
        Report msi = si ;
        ReportList msir = sir ;
        
        fromLabel.setText(Integer.toString(msir.getSenderId())) ;
        toLabel.setText(Integer.toString(msir.getReceiverId())) ;
        subjectLabel.setText(msi.getSubject()) ;
        dateLabel.setText(msi.getApplyDate().toString()) ;
        reportBodyTextArea.setText(msi.getDescription()) ;
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
