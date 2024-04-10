package mainpkg.Rayhan.User8.Goal5_Education;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import mainpkg.AbstractClass.Date;
import mainpkg.Rayhan.User8.NGOs;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class EducationFacilitiesSceneFxmlController implements Initializable {

    @FXML    private ComboBox<String> supportComboBox;
    @FXML    private TextField amountTextField;
    @FXML    private TextField ddTextField;
    @FXML    private TextField mmTextField;
    @FXML    private TextField yyyyTextField;
    @FXML    private TableView<EducationFacilities> educationTableView;
    @FXML    private TableColumn<EducationFacilities , String> idTableColumn;
    @FXML    private TableColumn<EducationFacilities , String> nameTableColumn;
    @FXML    private TableColumn<EducationFacilities , Integer> amountTableColumn;
    @FXML    private TableColumn<EducationFacilities , Date> dateTableColumn;
    @FXML    private TableColumn<EducationFacilities , String> givenByTableColumn;
    
    ObservableList<EducationFacilities> list = FXCollections.observableArrayList() ;
    NGOs user ;
    Alert alert ;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    public NGOs get() {
        return user ;
    }
    
    public void set(NGOs u) {
        user = u ;
    }
    
    public void tableShow() {
        educationTableView.setItems(list) ;
    }
    
    public void setComboBox() {
        for(EducationFacilities efc: list) {
            supportComboBox.getItems().add(efc.getId()) ;
        }
        supportComboBox.setValue(list.get(0).getId());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backOnMouseClick(MouseEvent event) {
    }

    @FXML
    private void supplyOnMouseClick(MouseEvent event) {
        Boolean rtn = true ;
        String name = "" , samount = "" , sdd = "" , smm = "" , syyyy = "" ;
        Integer amount = 0 , dd = 0 , mm = 0 , yyyy = 0 ;
        
        name = supportComboBox.getValue() ;
        
        samount = amountTextField.getText() ;
        if (samount.length() == 0) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Amount Error") ;
            alert.setContentText("Amount must.") ;
            rtn = false ;
            alert.showAndWait() ;      
        }
        
        sdd = ddTextField.getText() ;
        smm = mmTextField.getText() ;
        syyyy = yyyyTextField.getText() ;
        if(sdd.length() == 0 || smm.length() == 0 || syyyy.length() == 0) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Date Error") ;
            alert.setContentText("Date must.") ;
            rtn = false ;
            alert.showAndWait() ;      
        }
        else {
            dd = Integer.parseInt(sdd) ;
            mm = Integer.parseInt(smm) ;
            yyyy = Integer.parseInt(syyyy) ;
        }
        Date date = new Date(dd , mm , yyyy) ;
        if(date.isValid() == false) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Date Error") ;
            alert.setContentText("Date is not Valid.") ;
            rtn = false ;
            alert.showAndWait() ;      
        }
        
        if (rtn == true) {
            EducationFacilities efc = user.educationFacilities(user.getId() , user.getName() , name, amount, date) ;
            list.add(efc) ;
            
            amountTextField.clear() ;
            ddTextField.clear() ;
            mmTextField.clear() ;
            yyyyTextField.clear() ;
        }
        else {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("ERROR") ;
            alert.setContentText("Unable to SUBMIT.") ;
            alert.showAndWait() ;      
        }
        
    }
    
}
