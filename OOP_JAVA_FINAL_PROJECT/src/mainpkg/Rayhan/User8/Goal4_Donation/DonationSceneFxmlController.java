package mainpkg.Rayhan.User8.Goal4_Donation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
public class DonationSceneFxmlController implements Initializable {

    @FXML    private TextField nameTextField;
    @FXML    private TextField amountTextField;
    @FXML    private TextField ddTextField;
    @FXML    private TextField mmTextField;
    @FXML    private TextField yyyyTextField;
    @FXML    private TableView<Donation> donationTableView;
    @FXML    private TableColumn<Donation , String> idTableColumn;
    @FXML    private TableColumn<Donation , String> nameTableColumn;
    @FXML    private TableColumn<Donation , String> amountTableColumn;
    @FXML    private TableColumn<Donation , String> dateTableColumn;
    @FXML    private TableColumn<Donation , Integer> donatedByTableColumn;
    
    NGOs user ;
    Alert alert ;
    ObservableList<Donation> list = FXCollections.observableArrayList() ;
    

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
        donationTableView.setItems(list) ;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backOnMouseClick(MouseEvent event) {
    }

    @FXML
    private void donationOnMouseClick(MouseEvent event) {
        Boolean rtn = true ;
        String name = "" , samount = "" , sdd = "" , smm = "" , syyyy = "" ;
        Integer dd = 0 , mm = 0 , yyyy = 0 , amount = 0 ;
        
        name = nameTextField.getText() ;
        if(name.length() == 0) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Name Error") ;
            alert.setContentText("Doner name must.");
            rtn = false ;
            alert.showAndWait() ;
        }
        
        samount = amountTextField.getText() ;
        if (samount.length() == 0) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Amount Error") ;
            alert.setContentText("Amount must.");
            rtn = false ;
            alert.showAndWait() ;
        }
        
        sdd = ddTextField.getText() ;
        smm = mmTextField.getText() ;
        syyyy = yyyyTextField.getText() ;
        if (sdd.length() == 0 || smm.length() == 0 || syyyy.length() == 0) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Date Error") ;
            alert.setContentText("Date must.");
            rtn = false ;
            alert.showAndWait() ;
        }
        else {
            dd = Integer.parseInt(sdd) ;
            mm = Integer.parseInt(smm) ;
            yyyy = Integer.parseInt(syyyy) ;
        }
        Date date = new Date(dd , mm , yyyy) ;
        if (date.isValid() == false) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Date Error") ;
            alert.setContentText("Date is not Valid.");
            rtn = false ;
            alert.showAndWait() ;
        }
        
        if (rtn == true) {
            Donation don = user.donationToCamp(user.getId(), amount , name, date) ;
            list.add(don) ;
        }
    }
    
}
