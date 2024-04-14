package mainpkg.Rayhan.User7.Goal6_Duty;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.AppendableObjectOutputStream;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.Time_Place;
import mainpkg.Rayhan.User5.Goal1_Volunteer.Volunteer;
import mainpkg.Rayhan.User7.DashBoard7SceneFxmlController;
import mainpkg.Rayhan.User7.SecurityIncharge;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class DutySceneFxmlController implements Initializable {

    @FXML    private ComboBox<String> timeComboBox;
    @FXML    private ComboBox<String> placeComboBox;
    @FXML    private TextField amountTextField;
    @FXML    private TextField ddTextField;
    @FXML    private TextField mmTextField;
    @FXML    private TextField yyyyTextField;
    @FXML    private TableView<Duty> dutyTableView;
    @FXML    private TableColumn<Duty , String> idTableColumn;
    @FXML    private TableColumn<Duty , String> timeTableColumn;
    @FXML    private TableColumn<Duty , String> placeTableColumn;
    @FXML    private TableColumn<Duty , String> dateTableColumn;
    @FXML    private TableColumn<Duty , String> amountTableColumn;
    @FXML    private Label tVLabel;
    @FXML    private Label fVLabel1;
    
    
    SecurityIncharge user ;
    Alert alert ;
    Time_Place tp = new Time_Place() ;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    public void set(SecurityIncharge u) {
        user = u ;
        ObservableList<Volunteer> list = fileReadVC();
        user.setVolunteerAmount(list.size()) ;
        fVLabel1.setText(Integer.toString(user.getVolunteerFree())) ;
        
    }
    
    public void tableShow() {
        tVLabel.setText(Integer.toString(user.getVolunteerAmount())) ;
        fVLabel1.setText(Integer.toString(user.getVolunteerFree())) ;
        
        ObservableList<Duty> list = fileRead();
        
        dutyTableView.setItems(list) ;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        timeComboBox.setItems(tp.getSecurityTime()) ;
        timeComboBox.setValue(tp.getSecurityTime().get(0)) ;
        placeComboBox.setItems(tp.getSecurityPlace()) ;
        placeComboBox.setValue(tp.getSecurityPlace().get(0)) ;
    }    

    @FXML
    private void backOnMouseCLick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User7/DashBoard7SceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        DashBoard7SceneFxmlController dsc = myLoader.getController() ;
        dsc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Security Incharge") ;
        stage.show() ;
    }

    @FXML
    private void dutyOnMouseClick(MouseEvent event) {
        Boolean rtn = true ;
        String time , place , sdd = "" , smm = "" , syyyy = "" ;
        Integer amount = 0 , dd = 0 , mm = 0 , yyyy = 0 ;
        
        time = timeComboBox.getValue() ;
        place = placeComboBox.getValue() ;
        
        amount = Integer.parseInt(amountTextField.getText()) ;
        
        sdd = ddTextField.getText() ;
        smm = mmTextField.getText() ;
        syyyy = yyyyTextField.getText() ;
        if(sdd.length() == 0 || smm.length() == 0 || syyyy.length() == 0) {
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
        if(date.isValid() == false) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Date Error") ;
            alert.setContentText("Date is not Valid.");
            rtn = false ;
            alert.showAndWait() ;
        }
        
        if (rtn == true) {
            Duty du = user.setDuty(time , place , amount , date) ;
            if (du != null) {
                fileWrite(du) ;
                amountTextField.clear() ;
                ddTextField.clear() ;
                mmTextField.clear() ;
                yyyyTextField.clear() ;
            }
            else {
                alert = new Alert(Alert.AlertType.WARNING) ;
                alert.setHeaderText("Not enough volunteer.");
                alert.showAndWait() ;
            }
        }
        
    }
    
    private ObservableList<Duty> fileRead() {
        ObservableList<Duty> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/VCVolunteer.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Duty st ;
            try {
                while(true){
                    st = (Duty)ois.readObject();
//                    System.out.println(st);
                    studList.add(st) ;
                }
            }//end of nested try
            catch(Exception e){
                // handling code
            }//nested catch     
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } 
        finally {
            try {
                
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }           
        
        return studList ;
    }
    
    private void fileWrite(Duty stu) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("src/File/VCVolunteer.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(stu);

        } catch (IOException ex) {
            Logger.getLogger(DutySceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(DutySceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
    }
    
    private ObservableList<Volunteer> fileReadVC() {
        ObservableList<Volunteer> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/SIVolunteer.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Volunteer st ;
            try {
                while(true){
                    st = (Volunteer)ois.readObject();
//                    System.out.println(st);
                    studList.add(st) ;
                }
            }//end of nested try
            catch(Exception e){
                // handling code
            }//nested catch     
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } 
        finally {
            try {
                
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }           
        
        return studList ;
    }
    
}
