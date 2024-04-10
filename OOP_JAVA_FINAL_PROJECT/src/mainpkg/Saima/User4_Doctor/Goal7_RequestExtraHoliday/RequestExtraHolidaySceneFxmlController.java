/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User4_Doctor.Goal7_RequestExtraHoliday;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.Holiday;
import mainpkg.Saima.User4_Doctor.Doctor;

/**
 * FXML Controller class
 *
 * @author HP
 */
   

public class RequestExtraHolidaySceneFxmlController implements Initializable {

    @FXML    private TextField startddTextField;
    @FXML    private TextField startmmTextField;
    @FXML    private TextField startyyyyTextField;
    @FXML    private TextField ddTextField;
    @FXML    private TextField mmTextField;
    @FXML    private TextField yyyyTextField;
    @FXML    private TextField endddTextField;
    @FXML    private TextField endmmTextField;
    @FXML    private TextField endyyyyTextField;
    @FXML    private TableView<Holiday> holidayTableView;
    @FXML    private TableColumn<Holiday , String> idTableColumn;
    @FXML    private TableColumn<Holiday , String> reasonTableColumn;
    @FXML    private TableColumn<Holiday , Date> sDTableColumn;
    @FXML    private TableColumn<Holiday , Date> eDTableColumn;
    @FXML    private TableColumn<Holiday , Date> dateTableColumn;
    @FXML    private TableColumn<Holiday , String> statusTableColumn;
    @FXML    private TextField reasonTextField;
    
    ObservableList<Holiday> list = FXCollections.observableArrayList() ;
    Doctor user ;
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    public void tableShow() {
        holidayTableView.setItems(user.getHolidayList()) ;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User4_Doctor/DashBoardSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Doctor") ;
        stage.show() ;
    }

    @FXML
    private void applyOnMouseClick(MouseEvent event) {
        Boolean rtn = true ;
        String reason , ssdd , ssmm , ssyyyy , sedd , semm , seyyyy , sadd , samm , sayyyy ;
        Integer sdd , smm , syyyy , edd , emm , eyyyy , add , amm , ayyyy ;
        
        reason = reasonTextField.getText() ;
        
        ssdd = startddTextField.getText() ;
        ssmm = startmmTextField.getText() ;
        ssyyyy = startyyyyTextField.getText() ;
        sdd = Integer.parseInt(ssdd) ;
        smm = Integer.parseInt(ssmm) ;
        syyyy = Integer.parseInt(ssyyyy) ;
        Date start = new Date(sdd , smm , syyyy) ;
        
        sedd = endddTextField.getText() ;
        semm = endmmTextField.getText() ;
        seyyyy = endyyyyTextField.getText() ;
        edd = Integer.parseInt(sedd) ;
        emm = Integer.parseInt(semm) ;
        eyyyy = Integer.parseInt(seyyyy) ;
        Date end = new Date(edd , emm , eyyyy) ;
        
        sadd = ddTextField.getText() ;
        samm = mmTextField.getText() ;
        sayyyy = yyyyTextField.getText() ;
        add = Integer.parseInt(sadd) ;
        amm = Integer.parseInt(samm) ;
        ayyyy = Integer.parseInt(sayyyy) ;
        Date apply = new Date(add , amm , ayyyy) ;
        
        if(start.isValid() && end.isValid() && apply.isValid()) {
            rtn = user.requestToLeave(reason, start , end) ;
        }
    }
    
}
