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
import mainpkg.Saima.User3_AidExcutive.Goal8_Report.ReportList;

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
    
    public void set (Report r) {
       Report mr = r ;
        
        fromLabel.setText(Integer.toString(mr.getSenderId())) ;
        toLabel.setText(Integer.toString(mr.getReceiverId())) ;
        subjectLabel.setText(mr.getSubject()) ;
        dateLabel.setText(mr.getApplyDate().toString()) ;
        reportBodyTextArea.setText(mr.getDescription()) ;
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
